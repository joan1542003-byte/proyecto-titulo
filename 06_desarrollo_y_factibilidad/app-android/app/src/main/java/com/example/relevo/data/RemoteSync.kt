package com.example.relevo.data

import android.content.Context
import cl.udp.relevo.BuildConfig
import org.json.JSONObject
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL
import java.time.Instant

class RemoteSync(context: Context, private val store: ResearchLogStore) {
  private val preferences = context.getSharedPreferences("relevo_remote", Context.MODE_PRIVATE)
  private val baseUrl = BuildConfig.SUPABASE_URL.trimEnd('/')
  private val apiKey = BuildConfig.SUPABASE_PUBLISHABLE_KEY

  val configured: Boolean get() = baseUrl.isNotBlank() && apiKey.isNotBlank()
  val deletionPending: Boolean get() = preferences.getBoolean("deleting", false)

  fun syncPending(): Boolean = synchronized(LOCK) {
    if (preferences.getBoolean("deleting", false)) return false
    if (!configured) return false
    preferences.edit().putBoolean("ever_configured", true).apply()
    val token = accessToken() ?: return false
    store.pendingSessions().forEach { session ->
      if (!post("relevo_sessions?on_conflict=session_id", session.toJson(), token, upsert = true)) return false
      store.markSessionSynced(session.sessionId)
    }
    store.pendingEvents().forEach { event ->
      if (!post("relevo_events?on_conflict=client_event_id", event.toJson(), token, upsert = false)) return false
      store.markEventSynced(event.id)
    }
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
    val token = accessToken() ?: return false
    val user = runCatching {
      val response = connection("/auth/v1/user", token).apply { requestMethod = "GET"; doOutput = false }
      if (response.responseCode !in 200..299) return false
      JSONObject(response.inputStream.bufferedReader().use { it.readText() }).getString("id")
    }.getOrNull() ?: return false
    if (!user.matches(Regex("[0-9a-fA-F-]{36}"))) return false
    if (!delete("/rest/v1/relevo_events?user_id=eq.$user", token)) return false
    if (!delete("/rest/v1/relevo_sessions?user_id=eq.$user", token)) return false
    return noRows("/rest/v1/relevo_events?select=id&user_id=eq.$user&limit=1", token) &&
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

  private fun accessToken(): String? {
    val cached = preferences.getString("access_token", null)
    if (cached != null && preferences.getLong("expires_at", 0) > System.currentTimeMillis() + 60_000) return cached
    val refresh = preferences.getString("refresh_token", null)
    return authenticate(if (refresh == null) "/auth/v1/signup" to JSONObject() else "/auth/v1/token?grant_type=refresh_token" to JSONObject().put("refresh_token", refresh))
  }

  private fun authenticate(request: Pair<String, JSONObject>): String? = runCatching {
    val connection = connection(request.first, null).apply { requestMethod = "POST" }
    connection.outputStream.use { it.write(request.second.toString().toByteArray()) }
    if (connection.responseCode !in 200..299) return null
    val response = JSONObject(connection.inputStream.bufferedReader().readText())
    response.getString("access_token").also { token ->
      preferences.edit()
        .putString("access_token", token)
        .putString("refresh_token", response.optString("refresh_token"))
        .putLong("expires_at", System.currentTimeMillis() + response.optLong("expires_in", 3600) * 1000)
        .apply()
    }
  }.getOrNull()

  private fun post(path: String, body: JSONObject, token: String, upsert: Boolean): Boolean = runCatching {
    val connection = connection("/rest/v1/$path", token).apply {
      requestMethod = "POST"
      setRequestProperty("Prefer", if (upsert) "resolution=merge-duplicates,return=minimal" else "resolution=ignore-duplicates,return=minimal")
    }
    connection.outputStream.use { it.write(body.toString().toByteArray()) }
    connection.responseCode in 200..299
  }.getOrDefault(false)

  private fun connection(path: String, token: String?) = (URL(baseUrl + path).openConnection() as HttpURLConnection).apply {
    connectTimeout = 10_000; readTimeout = 10_000; doOutput = true
    setRequestProperty("Content-Type", "application/json")
    setRequestProperty("apikey", apiKey)
    setRequestProperty("Authorization", "Bearer ${token ?: apiKey}")
  }

  private fun PendingSession.toJson() = JSONObject()
    .put("session_id", sessionId).put("participant_code", participantCode).put("activity", activity)
    .put("first_step", firstStep).put("place", place).put("target_package", targetPackage).put("target_app_label", targetAppLabel)
    .put("target_apps", JSONArray(targetAppsJson))
    .put("threshold_seconds", thresholdSeconds).put("started_at", startedAt.iso()).put("signal_at", signalAt?.iso())
    .put("closed_at", closedAt?.iso()).put("observed_seconds", observedSeconds).put("outcome", outcome).put("consent_version", consentVersion)

  private fun PendingEvent.toJson() = JSONObject()
    .put("client_event_id", "$sessionId-$id").put("session_id", sessionId).put("participant_code", participantCode)
    .put("event_type", type).put("target_package", targetPackage).put("value_seconds", seconds)
    .put("created_at", createdAt.iso()).put("consent_version", consentVersion)

  private fun Long.iso() = Instant.ofEpochMilli(this).toString()

  private companion object { val LOCK = Any() }
}
