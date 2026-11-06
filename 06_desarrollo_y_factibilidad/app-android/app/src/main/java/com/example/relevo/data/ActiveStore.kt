package com.example.relevo.data

import android.content.Context
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.TrackedApp
import org.json.JSONArray
import org.json.JSONObject

/**
 * Relevos activos (4.3, D-158): los que están contando, cada uno con su sesión, sus apps y su tiempo. Desde
 * la 4.3 puede haber varios a la vez; hasta la 4.2 había uno solo y vivía en [ReminderStore].
 *
 * [ReminderStore] queda para el borrador que se prepara y para el relevo que suena o espera la respuesta.
 * Cuando uno de estos cumple su tiempo, pasa allá para la señal y «¿Qué decidiste?»; si había un borrador a
 * medias, se guarda aparte ([park]) y vuelve al terminar.
 */
class ActiveStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_activos", Context.MODE_PRIVATE)

  fun load(): List<Reminder> = runCatching {
    val array = JSONArray(preferences.getString(KEY_ACTIVE, "[]"))
    List(array.length()) { reminderFromJson(array.getJSONObject(it)) }
  }.getOrDefault(emptyList())

  fun save(actives: List<Reminder>) {
    preferences.edit().putString(KEY_ACTIVE, JSONArray().apply { actives.forEach { put(it.toJson()) } }.toString()).apply()
  }

  fun add(reminder: Reminder) = save(load().filterNot { it.sessionId == reminder.sessionId } + reminder)

  fun remove(sessionId: String) = save(load().filterNot { it.sessionId == sessionId })

  fun update(sessionId: String, transform: (Reminder) -> Reminder) = save(load().map { if (it.sessionId == sessionId) transform(it) else it })

  /** Guarda el borrador que se estaba preparando mientras otro relevo suena. */
  fun park(draft: Reminder) { preferences.edit().putString(KEY_PARKED, draft.toJson().toString()).apply() }

  /** Devuelve el borrador guardado, si hay uno, y lo borra. */
  fun takeParked(): Reminder? {
    val raw = preferences.getString(KEY_PARKED, null) ?: return null
    preferences.edit().remove(KEY_PARKED).apply()
    return runCatching { reminderFromJson(JSONObject(raw)) }.getOrNull()
  }

  fun clear() { preferences.edit().clear().apply() }

  companion object {
    private const val KEY_ACTIVE = "activos"
    private const val KEY_PARKED = "borrador_guardado"

    /**
     * Paso desde la 4.2: si el relevo único estaba contando, pasa a los activos y [ReminderStore] queda con un
     * borrador vacío. Se hace al abrir la app y al empezar el servicio; si no hay nada que mover, no hace nada.
     */
    fun migrate(context: Context) {
      val store = ReminderStore(context)
      val current = store.load()
      if (current.status != ReminderStatus.WAITING || current.sessionId.isBlank()) return
      ActiveStore(context).add(current)
      store.save(Reminder(participantCode = current.participantCode, consentAccepted = current.consentAccepted, localOnly = current.localOnly))
    }
  }
}

internal fun Reminder.toJson(): JSONObject = JSONObject()
  .put("activity", activity).put("how_to_start", howToStart).put("place", place)
  .put("target_package", targetPackage).put("target_app_label", targetAppLabel)
  .put("required_usage_seconds", requiredUsageSeconds).put("observed_usage_seconds", observedUsageSeconds)
  .put("participant_code", participantCode).put("consent_accepted", consentAccepted)
  .put("session_id", sessionId).put("status", status.name).put("signal_delivered", signalDelivered)
  .put("signal_route", signalRoute.name)
  .put("target_apps", JSONArray().apply { targetApps.forEach { put(JSONObject().put("package", it.packageName).put("label", it.label)) } })
  .put("study_condition", studyCondition).put("route_chosen", routeChosen).put("study_day", studyDay)
  .put("signal_at", signalAt).put("signal_ended", signalEnded).put("local_only", localOnly).put("auto_activated", autoActivated)

internal fun reminderFromJson(o: JSONObject): Reminder = Reminder(
  activity = o.optString("activity"), howToStart = o.optString("how_to_start"), place = o.optString("place"),
  targetPackage = o.optString("target_package"), targetAppLabel = o.optString("target_app_label"),
  requiredUsageSeconds = o.optInt("required_usage_seconds", 900), observedUsageSeconds = o.optInt("observed_usage_seconds", 0),
  participantCode = o.optString("participant_code"), consentAccepted = o.optBoolean("consent_accepted"),
  sessionId = o.optString("session_id"),
  status = runCatching { ReminderStatus.valueOf(o.optString("status")) }.getOrDefault(ReminderStatus.WAITING),
  signalDelivered = o.optBoolean("signal_delivered"),
  signalRoute = runCatching { SignalRoute.valueOf(o.optString("signal_route")) }.getOrDefault(SignalRoute.BLUETOOTH),
  targetApps = o.optJSONArray("target_apps")?.let { array -> List(array.length()) { array.getJSONObject(it).let { app -> TrackedApp(app.getString("package"), app.getString("label")) } } }.orEmpty(),
  studyCondition = o.optString("study_condition"), routeChosen = o.optBoolean("route_chosen", true), studyDay = o.optInt("study_day", -1),
  signalAt = o.optLong("signal_at"), signalEnded = o.optBoolean("signal_ended"), localOnly = o.optBoolean("local_only"),
  autoActivated = o.optBoolean("auto_activated"),
)
