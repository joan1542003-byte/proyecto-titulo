package com.example.relevo.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ResearchLogStore(context: Context) :
  SQLiteOpenHelper(context, "relevo_research.db", null, 2) {

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
        consent_version TEXT NOT NULL
      )
      """.trimIndent(),
    )
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    if (oldVersion < 2) {
      db.execSQL("ALTER TABLE events ADD COLUMN consent_version TEXT NOT NULL DEFAULT '2026-09-21'")
    }
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
        put("consent_version", "2026-09-21")
      },
    )
  }
}
