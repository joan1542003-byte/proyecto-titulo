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
)

/** Respuesta de una tarjeta semanal o del cierre del día 21. */
data class PendingAnswer(val id: Long, val participantCode: String, val sessionId: String?, val question: String, val answer: String, val createdAt: Long, val consentVersion: String)

/** Sesión que ya tiene señal y a la que le falta calcular el uso de los 10 minutos posteriores. */
data class UsageAfterRequest(val sessionId: String, val signalAt: Long, val packages: Set<String>)

class ResearchLogStore(context: Context) :
  SQLiteOpenHelper(context, "relevo_research.db", null, 5) {

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
      ${STUDY_COLUMNS.joinToString(",\n      ") { (name, type) -> "$name $type" }}
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

  fun startSession(reminder: com.example.relevo.domain.Reminder) {
    if (reminder.sessionId.isBlank()) return
    writableDatabase.insertWithOnConflict("sessions", null, ContentValues().apply {
      put("session_id", reminder.sessionId); put("participant_code", reminder.participantCode)
      put("activity", reminder.activity); put("first_step", reminder.howToStart); put("place", reminder.place)
      put("target_package", reminder.targetPackage); put("target_app_label", reminder.targetAppLabel)
      put("target_apps", JSONArray().apply { reminder.selectedApps.forEach { app -> put(JSONObject().put("package", app.packageName).put("label", app.label)) } }.toString())
      put("threshold_seconds", reminder.requiredUsageSeconds); put("started_at", System.currentTimeMillis())
      put("consent_version", CONSENT_VERSION); put("synced", PENDING)
      if (reminder.studyCondition.isNotBlank()) put("study_condition", reminder.studyCondition)
      if (reminder.studyDay >= 0) put("study_day", reminder.studyDay)
    }, SQLiteDatabase.CONFLICT_REPLACE)
  }

  /**
   * Cierra la sesión con la respuesta de la persona. Las dos preguntas de la prueba son opcionales:
   * null significa que no se hicieron o que se omitieron.
   */
  fun completeSession(reminder: com.example.relevo.domain.Reminder, outcome: String, knewIntention: String? = null, recalledFirstStep: String? = null) {
    if (reminder.sessionId.isBlank()) return
    writableDatabase.update("sessions", ContentValues().apply {
      put("closed_at", System.currentTimeMillis()); put("observed_seconds", reminder.observedUsageSeconds)
      put("outcome", outcome); put("synced", PENDING)
      knewIntention?.let { put("knew_intention", it) }
      recalledFirstStep?.let { put("recalled_first_step", it) }
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
    if (sessionId.isBlank() || participantCode.isBlank()) return
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
    if (participantCode.isBlank()) return
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
    "SELECT (SELECT COUNT(*) FROM events WHERE synced = ?) + (SELECT COUNT(*) FROM sessions WHERE synced = ?) + (SELECT COUNT(*) FROM answers WHERE synced = ?)",
    arrayOf(state.toString(), state.toString(), state.toString()),
  ).use { cursor -> if (cursor.moveToFirst()) cursor.getInt(0) else 0 }

  fun clearAll() { writableDatabase.run { delete("events", null, null); delete("sessions", null, null); delete("answers", null, null) } }

  fun hasRecords(): Boolean = readableDatabase.rawQuery(
    "SELECT (SELECT COUNT(*) FROM events) + (SELECT COUNT(*) FROM sessions) + (SELECT COUNT(*) FROM answers)", null,
  ).use { cursor -> cursor.moveToFirst() && cursor.getInt(0) > 0 }

  private fun Cursor.string(name: String): String = getString(getColumnIndexOrThrow(name))
  private fun Cursor.int(name: String): Int = getInt(getColumnIndexOrThrow(name))
  private fun Cursor.long(name: String): Long = getLong(getColumnIndexOrThrow(name))
  private fun Cursor.longOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getLong(it) }
  private fun Cursor.intOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getInt(it) }
  private fun Cursor.stringOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getString(it) }

  companion object {
    /** Consentimiento de la prueba de 21 días (protocolo 02). Cambiarlo pide aceptar de nuevo. */
    const val CONSENT_VERSION = "2026-09-25-v6"
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
  }
}
