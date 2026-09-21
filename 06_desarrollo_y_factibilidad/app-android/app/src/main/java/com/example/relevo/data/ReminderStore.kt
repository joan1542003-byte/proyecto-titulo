package com.example.relevo.data

import android.content.Context
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus

class ReminderStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_reminder", Context.MODE_PRIVATE)

  fun load(): Reminder =
    Reminder(
      activity = preferences.getString("activity", "").orEmpty(),
      howToStart = preferences.getString("how_to_start", "").orEmpty(),
      place = preferences.getString("place", "").orEmpty(),
      targetPackage = preferences.getString("target_package", "").orEmpty(),
      targetAppLabel = preferences.getString("target_app_label", "").orEmpty(),
      requiredUsageSeconds = preferences.getInt("required_usage_seconds", 60),
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
      .apply()
  }

  fun clear() {
    preferences.edit().clear().apply()
  }
}
