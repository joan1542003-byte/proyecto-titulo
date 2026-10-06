package com.example.relevo.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.json.JSONArray
import org.json.JSONObject

data class PendingEvent(val id: Long, val sessionId: String, val participantCode: String, val type: String, val targetPackage: String, val seconds: Int?, val createdAt: Long, val consentVersion: String)

data class PendingSession(
  val sessionId: String, val participantCode: String, val activity: String, val firstStep: String, val place: String,
  val targetPackage: String, val targetAppLabel: String, val thresholdSeconds: Int, val startedAt: Long, val signalAt: Long?,
  val closedAt: Long?, val observedSeconds: Int, val outcome: String?, val consentVersion: String, val targetAppsJson: String,
  val studyCondition: String?, val studyDay: Int?, val knewIntention: String?, val recalledFirstStep: String?,
  val signalEnd: String?, val responseSeconds: Int?, val usageBeforeSeconds: Int?, val usageAfterSeconds: Int?,
  val signalRoute: String?, val appVersion: String?, val signalFeeling: String?,
  /** «manual» o «auto» (D-095). */
  val activation: String?,
)

/** Respuesta de una tarjeta semanal o del cierre del día 21. */
data class PendingAnswer(val id: Long, val participantCode: String, val sessionId: String?, val question: String, val answer: String, val createdAt: Long, val consentVersion: String)

/** Uso de la app: qué se abre, qué se elige y qué se cambia (desde 2.12). */
data class PendingAppEvent(val id: Long, val participantCode: String, val event: String, val detail: String?, val createdAt: Long, val appVersion: String, val consentVersion: String)

/** Uso de un día de una app elegida, o el total de pantalla (`_total`), pendiente de enviar (D-097). */
data class PendingDailyUsage(val day: String, val packageName: String, val label: String?, val seconds: Int, val opens: Int)

/** Sesión que ya tiene señal y a la que le falta calcular el uso de los 10 minutos posteriores. */
data class UsageAfterRequest(val sessionId: String, val signalAt: Long, val packages: Set<String>)

class ResearchLogStore(context: Context) :
  SQLiteOpenHelper(context, "relevo_research.db", null, 9) {

  private val appContext = context.applicationContext

  /** Sin participar (A2) no se registra nada del estudio: la app funciona igual, solo en el teléfono. */
  private fun recording(): Boolean = Participation.participating(appContext)

  override fun onCreate(db: SQLiteDatabase) {
    db.execSQL(
      """
      CREATE TABLE events (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        session_id TEXT NOT NULL,
        participant_code TEXT NOT NULL,
        event_type TEXT NOT NULL,
        target_package TEXT NOT NULL,
        created_at INTEGER NOT NULL,
        value_seconds INTEGER,
        consent_version TEXT NOT NULL,
        synced INTEGER NOT NULL DEFAULT 0
      )
      """.trimIndent(),
    )
    createSessionsTable(db)
    createAnswersTable(db)
    createAppEventsTable(db)
    createDailyUsageTable(db)
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    if (oldVersion < 2) {
      db.execSQL("ALTER TABLE events ADD COLUMN consent_version TEXT NOT NULL DEFAULT '2026-09-21'")
    }
    if (oldVersion < 3) {
      db.execSQL("ALTER TABLE events ADD COLUMN synced INTEGER NOT NULL DEFAULT 0")
      // Se crea ya con todas las columnas actuales.
      createSessionsTable(db)
    }
    if (oldVersion == 3) db.execSQL("ALTER TABLE sessions ADD COLUMN target_apps TEXT NOT NULL DEFAULT '[]'")
    if (oldVersion in 3..4) STUDY_COLUMNS.forEach { (name, type) -> db.execSQL("ALTER TABLE sessions ADD COLUMN $name $type") }
    if (oldVersion < 5) createAnswersTable(db)
    if (oldVersion in 3..5) ROUTE_COLUMNS.forEach { (name, type) -> db.execSQL("ALTER TABLE sessions ADD COLUMN $name $type") }
    if (oldVersion in 3..6) FEELING_COLUMNS.forEach { (name, type) -> db.execSQL("ALTER TABLE sessions ADD COLUMN $name $type") }
    if (oldVersion < 7) createAppEventsTable(db)
    if (oldVersion in 3..7) ACTIVATION_COLUMNS.forEach { (name, type) -> db.execSQL("ALTER TABLE sessions ADD COLUMN $name $type") }
    if (oldVersion < 9) createDailyUsageTable(db)
  }

  /** Uso diario de las apps elegidas y total de pantalla (versión 9 de la base local, Android 2.18, D-097). */
  private fun createDailyUsageTable(db: SQLiteDatabase) = db.execSQL(
    """
    CREATE TABLE IF NOT EXISTS daily_usage (
      day TEXT NOT NULL,
      package TEXT NOT NULL,
      label TEXT,
      seconds INTEGER NOT NULL,
      opens INTEGER NOT NULL DEFAULT 0,
      updated_at INTEGER NOT NULL,
      consent_version TEXT NOT NULL,
      synced INTEGER NOT NULL DEFAULT 0,
      PRIMARY KEY (day, package)
    )
    """.trimIndent(),
  )

  /** Guarda el uso de un día; si cambió respecto de lo guardado, queda pendiente de enviar. */
  fun saveDailyUsage(day: String, packageName: String, label: String?, seconds: Int, opens: Int) {
    if (!recording()) return
    val db = writableDatabase
    val same = db.rawQuery("SELECT 1 FROM daily_usage WHERE day = ? AND package = ? AND seconds = ? AND opens = ?", arrayOf(day, packageName, seconds.toString(), opens.toString())).use { it.moveToFirst() }
    if (same) return
    db.insertWithOnConflict("daily_usage", null, ContentValues().apply {
      put("day", day); put("package", packageName); label?.let { put("label", it.take(120)) }
      put("seconds", seconds.coerceIn(0, 86_400)); put("opens", opens.coerceAtLeast(0))
      put("updated_at", System.currentTimeMillis()); put("consent_version", CONSENT_VERSION); put("synced", PENDING)
    }, SQLiteDatabase.CONFLICT_REPLACE)
  }

  fun pendingDailyUsage(): List<PendingDailyUsage> = readableDatabase.query("daily_usage", null, "synced = $PENDING", null, null, null, "day").use { cursor ->
    buildList { while (cursor.moveToNext()) add(PendingDailyUsage(cursor.string("day"), cursor.string("package"), cursor.stringOrNull("label"), cursor.int("seconds"), cursor.int("opens"))) }
  }

  fun markDailyUsageSynced(rows: List<PendingDailyUsage>, state: Int = SYNCED) {
    val db = writableDatabase
    rows.forEach { db.execSQL("UPDATE daily_usage SET synced = $state WHERE day = ? AND package = ?", arrayOf(it.day, it.packageName)) }
  }

  /** Apps elegidas alguna vez en un relevo (paquete y nombre), para el uso diario y el estado (D-097). */
  fun selectedAppsEver(): Map<String, String> = readableDatabase.query("sessions", arrayOf("target_apps", "target_package", "target_app_label"), null, null, null, null, "started_at").use { cursor ->
    val apps = LinkedHashMap<String, String>()
    while (cursor.moveToNext()) {
      runCatching {
        val array = JSONArray(cursor.getString(0))
        for (index in 0 until array.length()) array.getJSONObject(index).let { apps[it.getString("package")] = it.getString("label") }
      }
      val pkg = cursor.getString(1).orEmpty()
      if (pkg.isNotBlank() && pkg !in apps) apps[pkg] = cursor.getString(2).orEmpty()
    }
    apps
  }

  private fun createSessionsTable(db: SQLiteDatabase) = db.execSQL(
    """
    CREATE TABLE IF NOT EXISTS sessions (
      session_id TEXT PRIMARY KEY,
      participant_code TEXT NOT NULL,
      activity TEXT NOT NULL,
      first_step TEXT NOT NULL,
      place TEXT NOT NULL,
      target_package TEXT NOT NULL,
      target_app_label TEXT NOT NULL,
      target_apps TEXT NOT NULL DEFAULT '[]',
      threshold_seconds INTEGER NOT NULL,
      started_at INTEGER NOT NULL,
      signal_at INTEGER,
      closed_at INTEGER,
      observed_seconds INTEGER NOT NULL DEFAULT 0,
      outcome TEXT,
      consent_version TEXT NOT NULL,
      synced INTEGER NOT NULL DEFAULT 0,
      ${(STUDY_COLUMNS + ROUTE_COLUMNS + FEELING_COLUMNS + ACTIVATION_COLUMNS).joinToString(",\n      ") { (name, type) -> "$name $type" }}
    )
    """.trimIndent(),
  )

  private fun createAnswersTable(db: SQLiteDatabase) = db.execSQL(
    """
    CREATE TABLE IF NOT EXISTS answers (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      participant_code TEXT NOT NULL,
      session_id TEXT,
      question TEXT NOT NULL,
      answer TEXT NOT NULL,
      created_at INTEGER NOT NULL,
      consent_version TEXT NOT NULL,
      synced INTEGER NOT NULL DEFAULT 0
    )
    """.trimIndent(),
  )

  private fun createAppEventsTable(db: SQLiteDatabase) = db.execSQL(
    """
    CREATE TABLE IF NOT EXISTS app_events (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      participant_code TEXT NOT NULL,
      event TEXT NOT NULL,
      detail TEXT,
      created_at INTEGER NOT NULL,
      app_version TEXT NOT NULL,
      consent_version TEXT NOT NULL,
      synced INTEGER NOT NULL DEFAULT 0
    )
    """.trimIndent(),
  )

  /** Registra un uso de la app. Sin el consentimiento vigente no se guarda nada. */
  fun logApp(participantCode: String, event: String, detail: String? = null) {
    if (participantCode.isBlank() || !recording()) return
    writableDatabase.insert("app_events", null, ContentValues().apply {
      put("participant_code", participantCode); put("event", event.take(40)); detail?.let { put("detail", it.take(600)) }
      put("created_at", System.currentTimeMillis()); put("app_version", cl.udp.relevo.BuildConfig.VERSION_NAME)
      put("consent_version", CONSENT_VERSION); put("synced", PENDING)
    })
  }

  fun pendingAppEvents(): List<PendingAppEvent> = readableDatabase.query("app_events", null, "synced = $PENDING", null, null, null, "created_at").use { cursor ->
    buildList { while (cursor.moveToNext()) add(PendingAppEvent(cursor.long("id"), cursor.string("participant_code"), cursor.string("event"), cursor.stringOrNull("detail"), cursor.long("created_at"), cursor.string("app_version"), cursor.string("consent_version"))) }
  }

  fun markAppEventSynced(id: Long) { writableDatabase.execSQL("UPDATE app_events SET synced = $SYNCED WHERE id = ?", arrayOf(id)) }
  fun markAppEventRejected(id: Long) { writableDatabase.execSQL("UPDATE app_events SET synced = $REJECTED WHERE id = ?", arrayOf(id)) }

  fun startSession(reminder: com.example.relevo.domain.Reminder) {
    if (reminder.sessionId.isBlank() || !recording()) return
    writableDatabase.insertWithOnConflict("sessions", null, ContentValues().apply {
      put("session_id", reminder.sessionId); put("participant_code", reminder.participantCode)
      put("activity", reminder.activity); put("first_step", reminder.howToStart); put("place", reminder.place)
      put("target_package", reminder.targetPackage); put("target_app_label", reminder.targetAppLabel)
      put("target_apps", JSONArray().apply { reminder.selectedApps.forEach { app -> put(JSONObject().put("package", app.packageName).put("label", app.label)) } }.toString())
      put("threshold_seconds", reminder.requiredUsageSeconds); put("started_at", System.currentTimeMillis())
      put("consent_version", CONSENT_VERSION); put("synced", PENDING)
      if (reminder.studyCondition.isNotBlank()) put("study_condition", reminder.studyCondition)
      if (reminder.studyDay >= 0) put("study_day", reminder.studyDay)
      put("signal_route", when (reminder.signalRoute) {
        com.example.relevo.domain.SignalRoute.PHONE -> "phone"
        com.example.relevo.domain.SignalRoute.WATCH -> "watch"
        com.example.relevo.domain.SignalRoute.TAG -> "tag"
        com.example.relevo.domain.SignalRoute.BLUETOOTH -> "bluetooth"
      })
      put("app_version", cl.udp.relevo.BuildConfig.VERSION_NAME)
      put("activation", if (reminder.autoActivated) "auto" else "manual")
    }, SQLiteDatabase.CONFLICT_REPLACE)
  }

  /**
   * Cierra la sesión con la respuesta de la persona. Las dos preguntas de la prueba son opcionales:
   * null significa que no se hicieron o que se omitieron.
   */
  fun completeSession(reminder: com.example.relevo.domain.Reminder, outcome: String, knewIntention: String? = null, recalledFirstStep: String? = null, feeling: String? = null) {
    if (reminder.sessionId.isBlank()) return
    writableDatabase.update("sessions", ContentValues().apply {
      put("closed_at", System.currentTimeMillis()); put("observed_seconds", reminder.observedUsageSeconds)
      put("outcome", outcome); put("synced", PENDING)
      knewIntention?.let { put("knew_intention", it) }
      recalledFirstStep?.let { put("recalled_first_step", it) }
      feeling?.let { put("signal_feeling", it) }
    }, "session_id = ?", arrayOf(reminder.sessionId))
  }

  fun markSignal(sessionId: String, observedSeconds: Int, signalAt: Long, usageBeforeSeconds: Int?) {
    writableDatabase.update("sessions", ContentValues().apply {
      put("signal_at", signalAt); put("observed_seconds", observedSeconds); put("synced", PENDING)
      usageBeforeSeconds?.let { put("usage_before_seconds", it) }
    }, "session_id = ?", arrayOf(sessionId))
  }

  /** Cómo terminó el sonido: `silenced` si la persona lo detuvo, `auto` si terminó solo. Solo se guarda la primera vez. */
  fun markSignalEnd(sessionId: String, end: String) {
    writableDatabase.execSQL(
      "UPDATE sessions SET signal_end = ?, synced = $PENDING WHERE session_id = ? AND signal_end IS NULL",
      arrayOf(end, sessionId),
    )
  }

  /** Segundos entre la señal y la primera acción de la persona en la pantalla de señal. */
  fun markResponse(sessionId: String, seconds: Int) {
    writableDatabase.execSQL(
      "UPDATE sessions SET response_seconds = ?, synced = $PENDING WHERE session_id = ? AND response_seconds IS NULL",
      arrayOf<Any>(seconds, sessionId),
    )
  }

  fun usageAfterRequests(now: Long, windowMillis: Long): List<UsageAfterRequest> = readableDatabase.query(
    "sessions", arrayOf("session_id", "signal_at", "target_apps", "target_package"),
    "signal_at IS NOT NULL AND usage_after_seconds IS NULL AND signal_at <= ?", arrayOf((now - windowMillis).toString()),
    null, null, "signal_at",
  ).use { cursor ->
    buildList {
      while (cursor.moveToNext()) {
        val packages = runCatching {
          val array = JSONArray(cursor.getString(2))
          (0 until array.length()).map { array.getJSONObject(it).getString("package") }.toSet()
        }.getOrDefault(emptySet()).ifEmpty { setOf(cursor.getString(3)) }
        add(UsageAfterRequest(cursor.getString(0), cursor.getLong(1), packages))
      }
    }
  }

  fun setUsageAfter(sessionId: String, seconds: Int) {
    writableDatabase.update("sessions", ContentValues().apply { put("usage_after_seconds", seconds); put("synced", PENDING) }, "session_id = ?", arrayOf(sessionId))
  }

  fun record(
    sessionId: String,
    participantCode: String,
    eventType: String,
    targetPackage: String,
    valueSeconds: Int? = null,
  ) {
    if (sessionId.isBlank() || participantCode.isBlank() || !recording()) return
    writableDatabase.insert(
      "events",
      null,
      ContentValues().apply {
        put("session_id", sessionId)
        put("participant_code", participantCode)
        put("event_type", eventType)
        put("target_package", targetPackage)
        put("created_at", System.currentTimeMillis())
        valueSeconds?.let { put("value_seconds", it) }
        put("consent_version", CONSENT_VERSION)
        put("synced", PENDING)
      },
    )
  }

  fun recordAnswer(participantCode: String, question: String, answer: String, sessionId: String? = null) {
    if (participantCode.isBlank() || !recording()) return
    writableDatabase.insert("answers", null, ContentValues().apply {
      put("participant_code", participantCode); sessionId?.let { put("session_id", it) }
      put("question", question.take(40)); put("answer", answer.take(600))
      put("created_at", System.currentTimeMillis()); put("consent_version", CONSENT_VERSION); put("synced", PENDING)
    })
  }

  fun pendingSessions(): List<PendingSession> = readableDatabase.query("sessions", null, "synced = $PENDING", null, null, null, "started_at").use { cursor ->
    buildList { while (cursor.moveToNext()) add(PendingSession(
      cursor.string("session_id"), cursor.string("participant_code"), cursor.string("activity"), cursor.string("first_step"), cursor.string("place"),
      cursor.string("target_package"), cursor.string("target_app_label"), cursor.int("threshold_seconds"), cursor.long("started_at"),
      cursor.longOrNull("signal_at"), cursor.longOrNull("closed_at"), cursor.int("observed_seconds"), cursor.stringOrNull("outcome"),
      cursor.string("consent_version"), cursor.string("target_apps"),
      cursor.stringOrNull("study_condition"), cursor.intOrNull("study_day"), cursor.stringOrNull("knew_intention"), cursor.stringOrNull("recalled_first_step"),
      cursor.stringOrNull("signal_end"), cursor.intOrNull("response_seconds"), cursor.intOrNull("usage_before_seconds"), cursor.intOrNull("usage_after_seconds"),
      cursor.stringOrNull("signal_route"), cursor.stringOrNull("app_version"), cursor.stringOrNull("signal_feeling"),
      cursor.stringOrNull("activation"),
    )) }
  }

  fun pendingEvents(): List<PendingEvent> = readableDatabase.query("events", null, "synced = $PENDING", null, null, null, "created_at").use { cursor ->
    buildList { while (cursor.moveToNext()) add(PendingEvent(cursor.long("id"), cursor.string("session_id"), cursor.string("participant_code"), cursor.string("event_type"), cursor.string("target_package"), cursor.intOrNull("value_seconds"), cursor.long("created_at"), cursor.string("consent_version"))) }
  }

  fun pendingAnswers(): List<PendingAnswer> = readableDatabase.query("answers", null, "synced = $PENDING", null, null, null, "created_at").use { cursor ->
    buildList { while (cursor.moveToNext()) add(PendingAnswer(cursor.long("id"), cursor.string("participant_code"), cursor.stringOrNull("session_id"), cursor.string("question"), cursor.string("answer"), cursor.long("created_at"), cursor.string("consent_version"))) }
  }

  fun markSessionSynced(id: String) { writableDatabase.execSQL("UPDATE sessions SET synced = $SYNCED WHERE session_id = ?", arrayOf(id)) }
  fun markEventSynced(id: Long) { writableDatabase.execSQL("UPDATE events SET synced = $SYNCED WHERE id = ?", arrayOf(id)) }
  fun markAnswerSynced(id: Long) { writableDatabase.execSQL("UPDATE answers SET synced = $SYNCED WHERE id = ?", arrayOf(id)) }

  /** La base rechazó la fila de forma definitiva: se conserva en el teléfono, pero ya no bloquea el resto del envío. */
  fun markSessionRejected(id: String) { writableDatabase.execSQL("UPDATE sessions SET synced = $REJECTED WHERE session_id = ?", arrayOf(id)) }
  fun markEventRejected(id: Long) { writableDatabase.execSQL("UPDATE events SET synced = $REJECTED WHERE id = ?", arrayOf(id)) }
  fun markAnswerRejected(id: Long) { writableDatabase.execSQL("UPDATE answers SET synced = $REJECTED WHERE id = ?", arrayOf(id)) }

  fun countBySyncState(state: Int): Int = readableDatabase.rawQuery(
    "SELECT (SELECT COUNT(*) FROM events WHERE synced = ?) + (SELECT COUNT(*) FROM sessions WHERE synced = ?) + (SELECT COUNT(*) FROM answers WHERE synced = ?) + (SELECT COUNT(*) FROM app_events WHERE synced = ?) + (SELECT COUNT(*) FROM daily_usage WHERE synced = ?)",
    arrayOf(state.toString(), state.toString(), state.toString(), state.toString(), state.toString()),
  ).use { cursor -> if (cursor.moveToFirst()) cursor.getInt(0) else 0 }

  /** Todo lo registrado en el teléfono, para «Descargar mis datos». */
  fun exportJson(): JSONObject = JSONObject().apply {
    listOf("sessions" to "started_at", "events" to "created_at", "answers" to "created_at", "app_events" to "created_at", "daily_usage" to "day").forEach { (table, order) ->
      put(table, readableDatabase.query(table, null, null, null, null, null, order).use { cursor ->
        JSONArray().apply {
          while (cursor.moveToNext()) put(JSONObject().apply {
            cursor.columnNames.forEachIndexed { index, name ->
              when {
                cursor.isNull(index) -> put(name, JSONObject.NULL)
                cursor.getType(index) == Cursor.FIELD_TYPE_INTEGER -> put(name, cursor.getLong(index))
                else -> put(name, cursor.getString(index))
              }
            }
          })
        }
      })
    }
  }

  fun clearAll() { writableDatabase.run { delete("events", null, null); delete("sessions", null, null); delete("answers", null, null); delete("app_events", null, null); delete("daily_usage", null, null) } }

  fun hasRecords(): Boolean = readableDatabase.rawQuery(
    "SELECT (SELECT COUNT(*) FROM events) + (SELECT COUNT(*) FROM sessions) + (SELECT COUNT(*) FROM answers) + (SELECT COUNT(*) FROM app_events) + (SELECT COUNT(*) FROM daily_usage)", null,
  ).use { cursor -> cursor.moveToFirst() && cursor.getInt(0) > 0 }

  private fun Cursor.string(name: String): String = getString(getColumnIndexOrThrow(name))
  private fun Cursor.int(name: String): Int = getInt(getColumnIndexOrThrow(name))
  private fun Cursor.long(name: String): Long = getLong(getColumnIndexOrThrow(name))
  private fun Cursor.longOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getLong(it) }
  private fun Cursor.intOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getInt(it) }
  private fun Cursor.stringOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getString(it) }

  companion object {
    /** Consentimiento de la prueba de 21 días (protocolo 02). Cambiarlo pide aceptar de nuevo. */
    const val CONSENT_VERSION = "2026-10-06-v12"
    const val PENDING = 0
    const val SYNCED = 1
    const val REJECTED = 2

    /** Columnas que añadió la prueba de 21 días (versión 5 de la base local). */
    private val STUDY_COLUMNS = listOf(
      "study_condition" to "TEXT",
      "study_day" to "INTEGER",
      "knew_intention" to "TEXT",
      "recalled_first_step" to "TEXT",
      "signal_end" to "TEXT",
      "response_seconds" to "INTEGER",
      "usage_before_seconds" to "INTEGER",
      "usage_after_seconds" to "INTEGER",
    )

    /** Salida del sonido de cada relevo y versión de la app (versión 6 de la base local, Android 2.11). */
    private val ROUTE_COLUMNS = listOf(
      "signal_route" to "TEXT",
      "app_version" to "TEXT",
    )

    /** Cómo le cayó el aviso a la persona: good, neutral o bad (versión 7 de la base local, Android 2.12). */
    private val FEELING_COLUMNS = listOf("signal_feeling" to "TEXT")

    /** Si el relevo se activó a mano o solo (versión 8 de la base local, Android 2.16, D-095). */
    private val ACTIVATION_COLUMNS = listOf("activation" to "TEXT")
  }
}
