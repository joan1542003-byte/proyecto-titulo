package com.example.relevo.data

import android.content.Context
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import cl.udp.relevo.BuildConfig
import com.example.relevo.domain.Reminder
import com.example.relevo.monitor.BackgroundAccess
import com.example.relevo.monitor.DailyUsage
import com.example.relevo.monitor.UsageAccess
import com.example.relevo.signal.TagLink
import org.json.JSONArray
import org.json.JSONObject
import java.time.LocalDate

/**
 * Todo lo que el teléfono sabe de la persona, en un solo registro para el panel (D-097): perfil sin el
 * nombre (que va aparte, D-089), ruta, actividades propias, ajustes, activación automática, permisos,
 * equipo, último relevo, relevo en curso, prueba y apps elegidas alguna vez.
 */
object StateSnapshot {
  fun build(context: Context, log: ResearchLogStore): JSONObject {
    val app = context.applicationContext
    val profile = ProfileStore(app).load()
    val settings = SettingsStore(app).load()
    val plan = StudyStore(app).plan()
    val today = LocalDate.now()
    return JSONObject()
      .put("perfil", JSONObject().put("imagen", profile.image).put("intereses", JSONArray(profile.interests)).put("otro_interes", profile.otherInterest))
      .put("ruta", JSONArray().apply {
        RouteStore(app).load().forEach { track ->
          put(JSONObject().put("interes", track.title).put("paso_actual", track.currentIndex + 1).put("pasos", JSONArray().apply {
            track.steps.forEach { put(JSONObject().put("actividad", it.activity).put("para_empezar", it.firstStep).put("lugar", it.place)) }
          }))
        }
      })
      .put("actividades_propias", JSONArray().apply {
        CustomActivityStore(app).load().forEach { put(JSONObject().put("actividad", it.name).put("para_empezar", it.firstStep).put("lugar", it.place)) }
      })
      .put("ajustes", JSONObject()
        .put("tema", settings.theme.name.lowercase()).put("texto_grande", settings.largeText).put("resumen_semanal", settings.weeklySummary)
        .put("aviso_semanal", settings.returnNotice).put("mensaje_despues_de_responder", settings.acknowledgements)
        .put("veces_por_semana", settings.constancy).put("activacion_automatica", AutoModeStore(app).enabled))
      .put("permisos", JSONObject()
        .put("tiempo_de_uso", UsageAccess.isGranted(app))
        .put("notificaciones", NotificationManagerCompat.from(app).areNotificationsEnabled())
        .put("bateria_sin_restriccion", BackgroundAccess.isUnrestricted(app))
        .put("bluetooth_cercano", TagLink.hasPermissions(app)))
      .put("equipo", JSONObject().put("android", Build.VERSION.SDK_INT).put("fabricante", Build.MANUFACTURER).put("modelo", Build.MODEL).put("app", BuildConfig.VERSION_NAME)
        // Solo si hay un llavero vinculado (D-109); su dirección no sale del teléfono.
        .put("llavero_vinculado", TagStore(app).linked))
      .put("ultimo_relevo", reminderJson(ReminderStore(app, ReminderStore.LAST_CONFIGURATION).load()))
      .put("relevo_actual", reminderJson(ReminderStore(app).load()))
      .put("prueba", if (plan == null) JSONObject.NULL else JSONObject().put("secuencia", plan.sequence).put("dia0", plan.day0.toString())
        .put("dia", plan.day(today)).put("condicion", plan.condition(today)?.code?.toString() ?: JSONObject.NULL))
      .put("apps_elegidas", JSONArray().apply { selectedApps(app, log).forEach { (pkg, label) -> put(JSONObject().put("paquete", pkg).put("nombre", label)) } })
  }

  /** Apps elegidas alguna vez: las de los relevos guardados y las del relevo actual y el último. */
  fun selectedApps(context: Context, log: ResearchLogStore): Map<String, String> {
    val apps = LinkedHashMap(log.selectedAppsEver())
    listOf(ReminderStore(context, ReminderStore.LAST_CONFIGURATION).load(), ReminderStore(context).load()).forEach { reminder ->
      reminder.selectedApps.forEach { if (it.packageName.isNotBlank()) apps.putIfAbsent(it.packageName, it.label) }
    }
    apps.remove(DailyUsage.TOTAL)
    return apps
  }

  private fun reminderJson(reminder: Reminder): Any = if (reminder.activity.isBlank()) JSONObject.NULL else JSONObject()
    .put("estado", reminder.status.name.lowercase()).put("actividad", reminder.activity).put("para_empezar", reminder.howToStart).put("lugar", reminder.place)
    .put("apps", JSONArray().apply { reminder.selectedApps.forEach { put(JSONObject().put("paquete", it.packageName).put("nombre", it.label)) } })
    .put("segundos", reminder.requiredUsageSeconds).put("contados", reminder.observedUsageSeconds)
    .put("salida", reminder.signalRoute.name.lowercase()).put("se_activo_solo", reminder.autoActivated)
}
