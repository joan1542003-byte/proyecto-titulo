package com.example.relevo.monitor

import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import java.time.LocalDate
import java.time.ZoneId

/** Uso de un día: segundos y aperturas por app, y el tiempo total de pantalla (D-097). */
data class DayUsage(val seconds: Map<String, Long>, val opens: Map<String, Int>, val totalSeconds: Long, val totalOpens: Int = 0)

/**
 * Uso diario para la investigación (D-097): cuánto se usó cada día cada app elegida alguna vez en
 * Relevo, cuántas veces se abrió y el tiempo total de pantalla. De las demás apps solo entra su
 * tiempo al total; su nombre no se guarda.
 */
object DailyUsage {
  /** Paquete con que se guarda el tiempo total de pantalla del día. */
  const val TOTAL = "_total"

  /** Dos entradas a la misma app separadas por menos que esto cuentan como una sola apertura. */
  private const val SAME_OPEN_MILLIS = 5_000L

  /** Se revisa un periodo previo para saber qué app estaba abierta al empezar el día. */
  private const val LOOKBACK_MILLIS = 60 * 60_000L

  /**
   * Suma el tiempo y las aperturas de cada app entre [start] y [end] a partir de eventos de primer
   * plano. [excluded] (pantallas de inicio y del sistema) no cuentan en el total.
   */
  fun aggregate(events: List<ForegroundEvent>, start: Long, end: Long, excluded: Set<String> = emptySet()): DayUsage {
    val millis = HashMap<String, Long>()
    val opens = HashMap<String, Int>()
    var current: String? = null
    var since = start
    var lastPackage: String? = null
    var lastLeftAt = Long.MIN_VALUE
    fun leave(at: Long) {
      val pkg = current ?: return
      val from = maxOf(since, start)
      val to = minOf(at, end)
      if (to > from) millis[pkg] = (millis[pkg] ?: 0L) + (to - from)
      lastPackage = pkg
      lastLeftAt = at
      current = null
    }
    for (event in events.sortedBy { it.at }) {
      if (event.at >= end) break
      when (event.kind) {
        ForegroundTracker.Kind.RESUMED -> if (event.packageName != current) {
          leave(event.at)
          val pkg = event.packageName ?: continue
          current = pkg
          since = event.at
          val reopened = pkg == lastPackage && event.at - lastLeftAt < SAME_OPEN_MILLIS
          if (event.at >= start && !reopened) opens[pkg] = (opens[pkg] ?: 0) + 1
        }
        // Algunos fabricantes informan la pausa de la app anterior después de abrir la siguiente.
        ForegroundTracker.Kind.PAUSED -> if (event.packageName == current) leave(event.at)
        ForegroundTracker.Kind.SCREEN_OFF -> leave(event.at)
      }
    }
    leave(end)
    val total = millis.filterKeys { it !in excluded }.values.sum()
    val totalOpens = opens.filterKeys { it !in excluded }.values.sum()
    return DayUsage(millis.mapValues { it.value / 1_000L }, opens, total / 1_000L, totalOpens)
  }

  /** Uso de [day] en la zona horaria del teléfono; el día de hoy, hasta ahora. null sin permiso. */
  fun collect(context: Context, day: LocalDate, now: Long = System.currentTimeMillis()): DayUsage? {
    if (!UsageAccess.isGranted(context)) return null
    val zone = ZoneId.systemDefault()
    val start = day.atStartOfDay(zone).toInstant().toEpochMilli()
    val end = minOf(day.plusDays(1).atStartOfDay(zone).toInstant().toEpochMilli(), now)
    if (end <= start) return null
    val manager = context.getSystemService(UsageStatsManager::class.java) ?: return null
    val events = runCatching { manager.queryEvents(start - LOOKBACK_MILLIS, end) }.getOrNull() ?: return null
    val list = ArrayList<ForegroundEvent>()
    val event = UsageEvents.Event()
    while (events.hasNextEvent()) {
      events.getNextEvent(event)
      val kind = when (event.eventType) {
        UsageEvents.Event.ACTIVITY_RESUMED -> ForegroundTracker.Kind.RESUMED
        UsageEvents.Event.ACTIVITY_PAUSED -> ForegroundTracker.Kind.PAUSED
        // Pantalla apagada, bloqueada o teléfono apagado: el tiempo deja de contar para la app abierta.
        UsageEvents.Event.SCREEN_NON_INTERACTIVE,
        UsageEvents.Event.KEYGUARD_SHOWN,
        UsageEvents.Event.DEVICE_SHUTDOWN -> ForegroundTracker.Kind.SCREEN_OFF
        else -> null
      } ?: continue
      list += ForegroundEvent(event.timeStamp, kind, event.packageName)
    }
    return aggregate(list, start, end, excludedPackages(context))
  }

  /** Pantallas de inicio y la interfaz del sistema: no son uso de una app. */
  private fun excludedPackages(context: Context): Set<String> {
    val homes = runCatching {
      context.packageManager.queryIntentActivities(Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), 0).map { it.activityInfo.packageName }
    }.getOrDefault(emptyList())
    return (homes + "com.android.systemui").toSet()
  }
}
