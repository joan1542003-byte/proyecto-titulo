package com.example.relevo.data

import android.content.Context
import com.example.relevo.domain.Reminder
import org.json.JSONArray
import org.json.JSONObject

data class HistoryEntry(
  val activity: String,
  val appLabel: String,
  val appPackage: String,
  val place: String,
  val seconds: Int,
  val completedAt: Long,
  val sessionId: String = "",
  val outcome: String = "",
  val signalDelivered: Boolean = false,
  val appPackages: List<String> = listOf(appPackage),
)

class HistoryStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_history", Context.MODE_PRIVATE)

  fun load(): List<HistoryEntry> = runCatching {
    val array = JSONArray(preferences.getString("entries", "[]"))
    List(array.length()) { index ->
      val item = array.getJSONObject(index)
      HistoryEntry(
        activity = item.getString("activity"),
        appLabel = item.getString("app_label"),
        appPackage = item.getString("app_package"),
        place = item.optString("place", "Sin ubicación registrada"),
        seconds = item.getInt("seconds"),
        completedAt = item.getLong("completed_at"),
        sessionId = item.optString("session_id", ""),
        outcome = item.optString("outcome", ""),
        signalDelivered = item.optBoolean("signal_delivered", false),
        appPackages = item.optJSONArray("app_packages")?.let { array -> List(array.length()) { array.getString(it) } } ?: listOf(item.getString("app_package")),
      )
    }
  }.getOrDefault(emptyList())

  fun add(reminder: Reminder) {
    if (reminder.activity.isBlank() || reminder.observedUsageSeconds <= 0) return
    val updated = (listOf(HistoryEntry(reminder.activity, reminder.selectedApps.joinToString(", ") { it.label }, reminder.targetPackage, reminder.place, reminder.observedUsageSeconds, System.currentTimeMillis(), reminder.sessionId, signalDelivered = reminder.signalDelivered, appPackages = reminder.selectedApps.map { it.packageName })) + load()).take(200)
    save(updated)
  }

  fun markOutcome(sessionId: String, outcome: String) {
    if (sessionId.isBlank()) return
    save(load().map { if (it.sessionId == sessionId) it.copy(outcome = outcome) else it })
  }

  fun clear() { preferences.edit().clear().apply() }

  private fun save(updated: List<HistoryEntry>) {
    val array = JSONArray()
    updated.forEach { entry ->
      array.put(JSONObject().apply {
        put("activity", entry.activity)
        put("app_label", entry.appLabel)
        put("app_package", entry.appPackage)
        put("place", entry.place)
        put("seconds", entry.seconds)
        put("completed_at", entry.completedAt)
        put("session_id", entry.sessionId)
        put("outcome", entry.outcome)
        put("signal_delivered", entry.signalDelivered)
        put("app_packages", JSONArray(entry.appPackages))
      })
    }
    preferences.edit().putString("entries", array.toString()).apply()
  }
}
