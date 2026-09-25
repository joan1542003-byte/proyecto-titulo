package com.example.relevo.data

import android.content.Context
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.TrackedApp
import org.json.JSONArray
import org.json.JSONObject

/** Guarda el relevo en curso. Con otro nombre, guarda la última configuración usada para poder repetirla. */
class ReminderStore(context: Context, name: String = CURRENT) {
  private val preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

  companion object {
    const val CURRENT = "relevo_reminder"
    const val LAST_CONFIGURATION = "relevo_last_reminder"
  }

  fun load(): Reminder =
    Reminder(
      activity = preferences.getString("activity", "").orEmpty(),
      howToStart = preferences.getString("how_to_start", "").orEmpty(),
      place = preferences.getString("place", "").orEmpty(),
      targetPackage = preferences.getString("target_package", "").orEmpty(),
      targetAppLabel = preferences.getString("target_app_label", "").orEmpty(),
      requiredUsageSeconds = preferences.getInt("required_usage_seconds", 900),
      observedUsageSeconds = preferences.getInt("observed_usage_seconds", 0),
      participantCode = preferences.getString("participant_code", "").orEmpty(),
      consentAccepted = preferences.getBoolean("consent_accepted", false),
      sessionId = preferences.getString("session_id", "").orEmpty(),
      status =
        runCatching {
            ReminderStatus.valueOf(preferences.getString("status", ReminderStatus.DRAFT.name).orEmpty())
          }
          .getOrDefault(ReminderStatus.DRAFT),
      signalDelivered = preferences.getBoolean("signal_delivered", false),
      signalRoute = runCatching { SignalRoute.valueOf(preferences.getString("signal_route", SignalRoute.BLUETOOTH.name).orEmpty()) }.getOrDefault(SignalRoute.BLUETOOTH),
      targetApps = runCatching {
        val array = JSONArray(preferences.getString("target_apps", "[]"))
        List(array.length()) { index -> array.getJSONObject(index).let { TrackedApp(it.getString("package"), it.getString("label")) } }
      }.getOrDefault(emptyList()),
      studyCondition = preferences.getString("study_condition", "").orEmpty(),
      studyDay = preferences.getInt("study_day", -1),
      signalAt = preferences.getLong("signal_at", 0L),
      signalEnded = preferences.getBoolean("signal_ended", false),
    )

  fun save(reminder: Reminder) {
    preferences
      .edit()
      .putString("activity", reminder.activity)
      .putString("how_to_start", reminder.howToStart)
      .putString("place", reminder.place)
      .putString("target_package", reminder.targetPackage)
      .putString("target_app_label", reminder.targetAppLabel)
      .putInt("required_usage_seconds", reminder.requiredUsageSeconds)
      .putInt("observed_usage_seconds", reminder.observedUsageSeconds)
      .putString("participant_code", reminder.participantCode)
      .putBoolean("consent_accepted", reminder.consentAccepted)
      .putString("session_id", reminder.sessionId)
      .putString("status", reminder.status.name)
      .putBoolean("signal_delivered", reminder.signalDelivered)
      .putString("signal_route", reminder.signalRoute.name)
      .putString("target_apps", JSONArray().apply { reminder.selectedApps.forEach { app -> put(JSONObject().put("package", app.packageName).put("label", app.label)) } }.toString())
      .putString("study_condition", reminder.studyCondition)
      .putInt("study_day", reminder.studyDay)
      .putLong("signal_at", reminder.signalAt)
      .putBoolean("signal_ended", reminder.signalEnded)
      .apply()
  }

  fun clear() {
    preferences.edit().clear().apply()
  }
}
