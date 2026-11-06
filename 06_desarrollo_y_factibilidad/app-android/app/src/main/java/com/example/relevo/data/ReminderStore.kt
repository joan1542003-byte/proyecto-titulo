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
      requiredUsageSeconds = preferences.getInt("required_usage_seconds", Reminder.DEFAULT_LIMIT_SECONDS),
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
      signalRoute = signalRouteOf(preferences.getString("signal_route", null)),
      targetApps = runCatching {
        val array = JSONArray(preferences.getString("target_apps", "[]"))
        List(array.length()) { index -> array.getJSONObject(index).let { TrackedApp(it.getString("package"), it.getString("label")) } }
      }.getOrDefault(emptyList()),
      signalAt = preferences.getLong("signal_at", 0L),
      signalEnded = preferences.getBoolean("signal_ended", false),
      autoActivated = preferences.getBoolean("auto_activated", false),
      soundedOnPhone = preferences.getBoolean("sounded_on_phone", false),
      // Antes de 2.21 la salida siempre estaba elegida: si hay una guardada sin esta marca, cuenta como elegida.
      routeChosen = preferences.getBoolean("route_chosen", preferences.contains("signal_route")),
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
      .putLong("signal_at", reminder.signalAt)
      .putBoolean("signal_ended", reminder.signalEnded)
      .putBoolean("auto_activated", reminder.autoActivated)
      .putBoolean("route_chosen", reminder.routeChosen)
      .putBoolean("sounded_on_phone", reminder.soundedOnPhone)
      // Claves de la prueba de 21 días y del uso sin participar (2.8 a 3.3): ya no se usan.
      .remove("study_condition").remove("study_day").remove("local_only")
      .apply()
  }

  /**
   * La salida guardada. El reloj (D-093) dejó de existir en 1.0.0: un relevo que lo usaba suena en el
   * teléfono, que siempre está disponible. Sin salida guardada, el Tag (D-117).
   */
  fun clear() {
    preferences.edit().clear().apply()
  }
}

/**
 * Con qué suena un relevo guardado. Uno sin salida guardada suena en el Tag (D-117); uno guardado con el
 * reloj, que salió en la 1.0.0, pasa a sonar en el teléfono.
 */
internal fun signalRouteOf(saved: String?): SignalRoute = when (saved) {
  null, "" -> SignalRoute.TAG
  "WATCH" -> SignalRoute.PHONE
  else -> runCatching { SignalRoute.valueOf(saved) }.getOrDefault(SignalRoute.TAG)
}
