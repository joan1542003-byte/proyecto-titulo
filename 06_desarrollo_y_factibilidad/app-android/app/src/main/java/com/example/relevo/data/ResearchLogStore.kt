package com.example.relevo.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class PendingEvent(val id: Long, val sessionId: String, val participantCode: String, val type: String, val targetPackage: String, val seconds: Int?, val createdAt: Long, val consentVersion: String)
data class PendingSession(val sessionId: String, val participantCode: String, val activity: String, val firstStep: String, val place: String, val targetPackage: String, val targetAppLabel: String, val thresholdSeconds: Int, val startedAt: Long, val signalAt: Long?, val closedAt: Long?, val observedSeconds: Int, val outcome: String?, val consentVersion: String)

class ResearchLogStore(context: Context) :
  SQLiteOpenHelper(context, "relevo_research.db", null, 3) {

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
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    if (oldVersion < 2) {
      db.execSQL("ALTER TABLE events ADD COLUMN consent_version TEXT NOT NULL DEFAULT '2026-09-21'")
    }
    if (oldVersion < 3) {
      db.execSQL("ALTER TABLE events ADD COLUMN synced INTEGER NOT NULL DEFAULT 0")
      createSessionsTable(db)
    }
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
      threshold_seconds INTEGER NOT NULL,
      started_at INTEGER NOT NULL,
      signal_at INTEGER,
      closed_at INTEGER,
      observed_seconds INTEGER NOT NULL DEFAULT 0,
      outcome TEXT,
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
      put("threshold_seconds", reminder.requiredUsageSeconds); put("started_at", System.currentTimeMillis())
      put("consent_version", CONSENT_VERSION); put("synced", 0)
    }, SQLiteDatabase.CONFLICT_REPLACE)
  }

  fun completeSession(reminder: com.example.relevo.domain.Reminder, outcome: String) {
    if (reminder.sessionId.isBlank()) return
    writableDatabase.update("sessions", ContentValues().apply {
      put("closed_at", System.currentTimeMillis()); put("observed_seconds", reminder.observedUsageSeconds)
      put("outcome", outcome); put("synced", 0)
    }, "session_id = ?", arrayOf(reminder.sessionId))
  }

  fun markSignal(sessionId: String, observedSeconds: Int) {
    writableDatabase.update("sessions", ContentValues().apply {
      put("signal_at", System.currentTimeMillis()); put("observed_seconds", observedSeconds); put("synced", 0)
    }, "session_id = ?", arrayOf(sessionId))
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
        put("synced", 0)
      },
    )
  }

  fun pendingSessions(): List<PendingSession> = readableDatabase.query("sessions", null, "synced = 0", null, null, null, "started_at").use { cursor ->
    buildList { while (cursor.moveToNext()) add(PendingSession(
      cursor.getString(cursor.getColumnIndexOrThrow("session_id")), cursor.getString(cursor.getColumnIndexOrThrow("participant_code")),
      cursor.getString(cursor.getColumnIndexOrThrow("activity")), cursor.getString(cursor.getColumnIndexOrThrow("first_step")), cursor.getString(cursor.getColumnIndexOrThrow("place")),
      cursor.getString(cursor.getColumnIndexOrThrow("target_package")), cursor.getString(cursor.getColumnIndexOrThrow("target_app_label")), cursor.getInt(cursor.getColumnIndexOrThrow("threshold_seconds")),
      cursor.getLong(cursor.getColumnIndexOrThrow("started_at")), cursor.longOrNull("signal_at"), cursor.longOrNull("closed_at"), cursor.getInt(cursor.getColumnIndexOrThrow("observed_seconds")), cursor.stringOrNull("outcome"), cursor.getString(cursor.getColumnIndexOrThrow("consent_version")),
    )) }
  }

  fun pendingEvents(): List<PendingEvent> = readableDatabase.query("events", null, "synced = 0", null, null, null, "created_at").use { cursor ->
    buildList { while (cursor.moveToNext()) add(PendingEvent(cursor.getLong(cursor.getColumnIndexOrThrow("id")), cursor.getString(cursor.getColumnIndexOrThrow("session_id")), cursor.getString(cursor.getColumnIndexOrThrow("participant_code")), cursor.getString(cursor.getColumnIndexOrThrow("event_type")), cursor.getString(cursor.getColumnIndexOrThrow("target_package")), cursor.intOrNull("value_seconds"), cursor.getLong(cursor.getColumnIndexOrThrow("created_at")), cursor.getString(cursor.getColumnIndexOrThrow("consent_version")))) }
  }

  fun markSessionSynced(id: String) { writableDatabase.execSQL("UPDATE sessions SET synced = 1 WHERE session_id = ?", arrayOf(id)) }
  fun markEventSynced(id: Long) { writableDatabase.execSQL("UPDATE events SET synced = 1 WHERE id = ?", arrayOf(id)) }

  private fun android.database.Cursor.longOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getLong(it) }
  private fun android.database.Cursor.intOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getInt(it) }
  private fun android.database.Cursor.stringOrNull(name: String) = getColumnIndexOrThrow(name).let { if (isNull(it)) null else getString(it) }

  companion object { const val CONSENT_VERSION = "2026-09-23-v4" }
}
