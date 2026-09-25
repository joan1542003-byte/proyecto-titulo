package com.example.relevo.data

import android.content.Context
import android.util.Log
import cl.udp.relevo.BuildConfig
import org.json.JSONObject
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL
import java.time.Instant

/** Estado del envío que se muestra en Privacidad y datos para comprobar el piloto. */
data class SyncStatus(
  val configured: Boolean,
  val pending: Int,
  val rejected: Int,
  val lastSuccessAt: Long,
  val lastError: String?,
)

class RemoteSync(context: Context, private val store: ResearchLogStore) {
  private val preferences = context.getSharedPreferences("relevo_remote", Context.MODE_PRIVATE)
  private val baseUrl = BuildConfig.SUPABASE_URL.trimEnd('/')
  private val apiKey = BuildConfig.SUPABASE_PUBLISHABLE_KEY

  val configured: Boolean get() = baseUrl.isNotBlank() && apiKey.isNotBlank()
  val deletionPending: Boolean get() = preferences.getBoolean("deleting", false)

  fun status(): SyncStatus = SyncStatus(
    configured = configured,
    pending = store.countBySyncState(ResearchLogStore.PENDING),
    rejected = store.countBySyncState(ResearchLogStore.REJECTED),
    lastSuccessAt = preferences.getLong("last_success_at", 0L),
    lastError = preferences.getString("last_error", null),
  )

  /**
   * Envía sesiones y eventos pendientes. Una fila que la base rechaza de forma definitiva (error 4xx)
   * se marca como rechazada y el envío continúa; antes, una sola fila inválida detenía la cola completa.
   * Los fallos de red o del servidor detienen el envío para reintentarlo más tarde.
   */
  fun syncPending(): Boolean = synchronized(LOCK) {
    if (preferences.getBoolean("deleting", false)) return false
    if (!configured) return false
    preferences.edit().putBoolean("ever_configured", true).apply()
    var token = accessToken(allowNewUser = true) ?: return fail("No se pudo abrir la sesión con la base remota.")
    var rejectedNow = 0

    fun send(path: String, body: String, upsert: Boolean): HttpResult {
      val first = post(path, body, token, upsert)
      if (first.code != 401 && first.code != 403) return first
      invalidateAccessToken()
      token = accessToken(allowNewUser = true) ?: return first
      return post(path, body, token, upsert)
    }

    for (session in store.pendingSessions()) {
      val result = send("relevo_sessions?on_conflict=session_id", session.toJson().toString(), upsert = true)
      when {
        result.ok -> store.markSessionSynced(session.sessionId)
        result.permanent -> { store.markSessionRejected(session.sessionId); rejectedNow++; remember(result, "sesión") }
        else -> return fail(result, "sesión")
      }
    }

    for (chunk in store.pendingEvents().chunked(EVENT_BATCH)) {
      val batch = send(EVENTS_PATH, JSONArray().apply { chunk.forEach { put(it.toJson()) } }.toString(), upsert = false)
      when {
        batch.ok -> chunk.forEach { store.markEventSynced(it.id) }
        batch.permanent -> for (event in chunk) {
          // Se reenvía fila por fila para aislar la que la base no acepta.
          val single = send(EVENTS_PATH, JSONArray().put(event.toJson()).toString(), upsert = false)
          when {
            single.ok -> store.markEventSynced(event.id)
            single.permanent -> { store.markEventRejected(event.id); rejectedNow++; remember(single, "evento") }
            else -> return fail(single, "evento")
          }
        }
        else -> return fail(batch, "evento")
      }
    }

    for (answer in store.pendingAnswers()) {
      val result = send(ANSWERS_PATH, JSONArray().put(answer.toJson()).toString(), upsert = false)
      when {
        result.ok -> store.markAnswerSynced(answer.id)
        result.permanent -> { store.markAnswerRejected(answer.id); rejectedNow++; remember(result, "respuesta") }
        else -> return fail(result, "respuesta")
      }
    }

    val editor = preferences.edit().putLong("last_success_at", System.currentTimeMillis())
    if (rejectedNow == 0) editor.remove("last_error")
    editor.apply()
    return true
  }

  /** Borra únicamente las filas visibles para la sesión anónima autenticada. */
  fun beginDeletion() { preferences.edit().putBoolean("deleting", true).commit() }

  fun deleteOwnResearchData(): Boolean {
    beginDeletion()
    return synchronized(LOCK) { deleteOwnResearchDataLocked() }
  }

  private fun deleteOwnResearchDataLocked(): Boolean {
    if (!store.hasRecords() && preferences.getString("access_token", null) == null &&
      preferences.getString("refresh_token", null) == null && !preferences.getBoolean("ever_configured", false)) return true
    if (!configured) return !preferences.getBoolean("ever_configured", false)
    // No se crea un usuario nuevo al borrar: uno nuevo no tendría filas y el borrado parecería completo sin serlo.
    val token = accessToken(allowNewUser = false) ?: return false
    val user = runCatching {
      val response = connection("/auth/v1/user", token).apply { requestMethod = "GET"; doOutput = false }
      if (response.responseCode !in 200..299) return false
      JSONObject(response.inputStream.bufferedReader().use { it.readText() }).getString("id")
    }.getOrNull() ?: return false
    if (!user.matches(Regex("[0-9a-fA-F-]{36}"))) return false
    if (!delete("/rest/v1/relevo_answers?user_id=eq.$user", token)) return false
    if (!delete("/rest/v1/relevo_events?user_id=eq.$user", token)) return false
    if (!delete("/rest/v1/relevo_sessions?user_id=eq.$user", token)) return false
    return noRows("/rest/v1/relevo_answers?select=id&user_id=eq.$user&limit=1", token) &&
      noRows("/rest/v1/relevo_events?select=id&user_id=eq.$user&limit=1", token) &&
      noRows("/rest/v1/relevo_sessions?select=session_id&user_id=eq.$user&limit=1", token)
  }

  fun clearCredentials() { preferences.edit().clear().apply() }

  private fun delete(path: String, token: String): Boolean = runCatching {
    val response = connection(path, token).apply { requestMethod = "DELETE"; doOutput = false }
    response.responseCode in 200..299
  }.getOrDefault(false)

  private fun noRows(path: String, token: String): Boolean = runCatching {
    val response = connection(path, token).apply { requestMethod = "GET"; doOutput = false }
    response.responseCode in 200..299 && JSONArray(response.inputStream.bufferedReader().use { it.readText() }).length() == 0
  }.getOrDefault(false)

  private fun invalidateAccessToken() { preferences.edit().remove("access_token").putLong("expires_at", 0L).apply() }

  private fun accessToken(allowNewUser: Boolean): String? {
    val cached = preferences.getString("access_token", null)
    if (cached != null && preferences.getLong("expires_at", 0) > System.currentTimeMillis() + 60_000) return cached
    val refresh = preferences.getString("refresh_token", null)
    if (refresh != null) {
      val (token, code) = authenticate("/auth/v1/token?grant_type=refresh_token", JSONObject().put("refresh_token", refresh))
      if (token != null) return token
      // Sin conexión o error del servidor: se reintenta más tarde con la misma sesión.
      if (code !in 400..499 || !allowNewUser) return null
      // La sesión anónima dejó de ser válida. Se abre otra para no perder el registro de las semanas siguientes;
      // las filas anteriores conservan el mismo código de participación y pueden borrarse desde la administración.
      preferences.edit().remove("refresh_token").remove("access_token")
        .putString("last_error", "La sesión remota había expirado y se abrió una nueva (código $code).").apply()
    } else if (!allowNewUser && preferences.getBoolean("ever_configured", false)) return null
    return authenticate("/auth/v1/signup", JSONObject()).first
  }

  private fun authenticate(path: String, body: JSONObject): Pair<String?, Int> = runCatching {
    val connection = connection(path, null).apply { requestMethod = "POST" }
    connection.outputStream.use { it.write(body.toString().toByteArray()) }
    val code = connection.responseCode
    if (code !in 200..299) return null to code
    val response = JSONObject(connection.inputStream.bufferedReader().readText())
    response.getString("access_token").also { token ->
      preferences.edit()
        .putString("access_token", token)
        .putString("refresh_token", response.optString("refresh_token"))
        .putLong("expires_at", System.currentTimeMillis() + response.optLong("expires_in", 3600) * 1000)
        .apply()
    } to code
  }.getOrDefault(null to -1)

  private fun post(path: String, body: String, token: String, upsert: Boolean): HttpResult = runCatching {
    val connection = connection("/rest/v1/$path", token).apply {
      requestMethod = "POST"
      setRequestProperty("Prefer", if (upsert) "resolution=merge-duplicates,return=minimal" else "resolution=ignore-duplicates,return=minimal")
    }
    connection.outputStream.use { it.write(body.toByteArray()) }
    val code = connection.responseCode
    HttpResult(code, if (code in 200..299) "" else connection.errorStream?.bufferedReader()?.use { it.readText() }.orEmpty())
  }.getOrElse { HttpResult(-1, it.javaClass.simpleName) }

  private fun connection(path: String, token: String?) = (URL(baseUrl + path).openConnection() as HttpURLConnection).apply {
    connectTimeout = 10_000; readTimeout = 10_000; doOutput = true
    setRequestProperty("Content-Type", "application/json")
    setRequestProperty("apikey", apiKey)
    setRequestProperty("Authorization", "Bearer ${token ?: apiKey}")
  }

  /** Guarda solo código y mensaje del error. El detalle de PostgREST puede incluir la fila enviada y no se conserva. */
  private fun remember(result: HttpResult, kind: String) {
    val message = "No se aceptó un $kind (${result.code}): ${result.summary()}"
    Log.w(TAG, message)
    preferences.edit().putString("last_error", message).apply()
  }

  private fun fail(result: HttpResult, kind: String): Boolean =
    fail(if (result.code < 0) "Sin conexión con la base remota; los datos quedan pendientes." else "El envío de un $kind falló (${result.code}): ${result.summary()}")

  private fun fail(message: String): Boolean {
    Log.w(TAG, message)
    preferences.edit().putString("last_error", message).apply()
    return false
  }

  private fun HttpResult.summary(): String = runCatching {
    val json = JSONObject(body)
    listOf(json.optString("code"), json.optString("message")).filter { it.isNotBlank() }.joinToString(" · ").take(180)
  }.getOrDefault(body.take(60))

  private fun PendingSession.toJson() = JSONObject()
    .put("session_id", sessionId).put("participant_code", participantCode).put("activity", activity)
    .put("first_step", firstStep).put("place", place).put("target_package", targetPackage).put("target_app_label", targetAppLabel)
    .put("target_apps", JSONArray(targetAppsJson))
    .put("threshold_seconds", thresholdSeconds).put("started_at", startedAt.iso()).put("signal_at", signalAt?.iso() ?: JSONObject.NULL)
    .put("closed_at", closedAt?.iso() ?: JSONObject.NULL).put("observed_seconds", observedSeconds).put("outcome", outcome ?: JSONObject.NULL)
    .put("consent_version", consentVersion)
    .put("study_condition", studyCondition ?: JSONObject.NULL).put("study_day", studyDay ?: JSONObject.NULL)
    .put("knew_intention", knewIntention ?: JSONObject.NULL).put("recalled_first_step", recalledFirstStep ?: JSONObject.NULL)
    .put("signal_end", signalEnd ?: JSONObject.NULL).put("response_seconds", responseSeconds ?: JSONObject.NULL)
    .put("usage_before_seconds", usageBeforeSeconds ?: JSONObject.NULL).put("usage_after_seconds", usageAfterSeconds ?: JSONObject.NULL)

  private fun PendingAnswer.toJson() = JSONObject()
    .put("client_answer_id", "$participantCode-a$id").put("participant_code", participantCode)
    .put("session_id", sessionId ?: JSONObject.NULL).put("question", question).put("answer", answer)
    .put("created_at", createdAt.iso()).put("consent_version", consentVersion)

  // Todas las filas llevan las mismas claves: en un envío por lotes PostgREST toma las columnas del primer objeto.
  private fun PendingEvent.toJson() = JSONObject()
    .put("client_event_id", "$sessionId-$id").put("session_id", sessionId).put("participant_code", participantCode)
    .put("event_type", type).put("target_package", targetPackage).put("value_seconds", seconds ?: JSONObject.NULL)
    .put("created_at", createdAt.iso()).put("consent_version", consentVersion)

  private fun Long.iso() = Instant.ofEpochMilli(this).toString()

  private data class HttpResult(val code: Int, val body: String) {
    val ok: Boolean get() = code in 200..299
    /** Error de la petición misma (datos o restricción), que no se resolverá reintentando. */
    val permanent: Boolean get() = code in 400..499 && code !in setOf(401, 403, 408, 429)
  }

  private companion object {
    val LOCK = Any()
    const val TAG = "RelevoSync"
    const val EVENT_BATCH = 50
    const val EVENTS_PATH = "relevo_events?on_conflict=client_event_id"
    const val ANSWERS_PATH = "relevo_answers?on_conflict=client_answer_id"
  }
}
