package com.example.relevo.monitor

import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Context

/** Evento de primer plano reducido a lo que el cálculo necesita. */
data class ForegroundEvent(val at: Long, val kind: ForegroundTracker.Kind, val packageName: String?)

/**
 * Tiempo en las apps elegidas dentro de una ventana, por ejemplo los 10 minutos anteriores y
 * posteriores a la señal (protocolo 02). Solo para la investigación: la app no lo muestra.
 */
object UsageWindow {
  const val WINDOW_MILLIS = 10 * 60_000L

  /** Se revisa un periodo previo a la ventana para saber qué app estaba abierta cuando empezó. */
  private const val LOOKBACK_MILLIS = 60 * 60_000L

  fun trackedMillis(events: List<ForegroundEvent>, start: Long, end: Long, tracked: Set<String>): Long {
    if (end <= start) return 0L
    val tracker = ForegroundTracker(start, maxStepMillis = Long.MAX_VALUE)
    var cursor = start
    for (event in events.sortedBy { it.at }) {
      if (event.at > end) break
      if (event.at > start) {
        tracker.tick(event.at) { it in tracked }
        cursor = event.at
      }
      tracker.onEvent(event.kind, event.packageName)
    }
    if (cursor < end) tracker.tick(end) { it in tracked }
    return tracker.accumulatedMillis
  }

  /** Lee los eventos de Tiempo de uso de Android. Devuelve null si no hay permiso. */
  fun trackedSeconds(context: Context, start: Long, end: Long, tracked: Set<String>): Int? {
    if (!UsageAccess.isGranted(context)) return null
    val manager = context.getSystemService(UsageStatsManager::class.java) ?: return null
    val events = runCatching { manager.queryEvents(start - LOOKBACK_MILLIS, end) }.getOrNull() ?: return null
    val list = mutableListOf<ForegroundEvent>()
    val event = UsageEvents.Event()
    while (events.hasNextEvent()) {
      events.getNextEvent(event)
      val kind = when (event.eventType) {
        UsageEvents.Event.ACTIVITY_RESUMED -> ForegroundTracker.Kind.RESUMED
        UsageEvents.Event.ACTIVITY_PAUSED -> ForegroundTracker.Kind.PAUSED
        UsageEvents.Event.SCREEN_NON_INTERACTIVE -> ForegroundTracker.Kind.SCREEN_OFF
        else -> null
      } ?: continue
      list += ForegroundEvent(event.timeStamp, kind, event.packageName)
    }
    return (trackedMillis(list, start, end, tracked) / 1_000L).toInt()
  }
}
