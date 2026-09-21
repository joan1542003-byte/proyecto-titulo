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
      delaySeconds = preferences.getInt("delay_seconds", 60),
      status =
        runCatching {
            ReminderStatus.valueOf(preferences.getString("status", ReminderStatus.DRAFT.name).orEmpty())
          }
          .getOrDefault(ReminderStatus.DRAFT),
      scheduledAtMillis =
        preferences.getLong("scheduled_at", Long.MIN_VALUE).takeUnless { it == Long.MIN_VALUE },
      signalDelivered = preferences.getBoolean("signal_delivered", false),
    )

  fun save(reminder: Reminder) {
    preferences
      .edit()
      .putString("activity", reminder.activity)
      .putString("how_to_start", reminder.howToStart)
      .putString("place", reminder.place)
      .putInt("delay_seconds", reminder.delaySeconds)
      .putString("status", reminder.status.name)
      .putLong("scheduled_at", reminder.scheduledAtMillis ?: Long.MIN_VALUE)
      .putBoolean("signal_delivered", reminder.signalDelivered)
      .apply()
  }

  fun clear() {
    preferences.edit().clear().apply()
  }
}
