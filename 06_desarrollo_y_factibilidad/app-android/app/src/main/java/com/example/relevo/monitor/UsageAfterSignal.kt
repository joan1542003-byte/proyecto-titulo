package com.example.relevo.monitor

import android.content.Context
import com.example.relevo.data.ResearchLogStore

/**
 * Calcula, cuando ya pasaron, los 10 minutos posteriores a cada señal: cuánto siguió la persona en
 * las apps elegidas (D-078, protocolo 02). Se usa solo para la investigación y no se muestra como
 * «tiempo excedido». Android conserva estos eventos unos días; si nadie abre la app en ese plazo,
 * el dato queda vacío.
 */
object UsageAfterSignal {
  fun update(context: Context, log: ResearchLogStore) {
    for (request in log.usageAfterRequests(System.currentTimeMillis(), UsageWindow.WINDOW_MILLIS)) {
      val seconds = UsageWindow.trackedSeconds(context, request.signalAt, request.signalAt + UsageWindow.WINDOW_MILLIS, request.packages) ?: return
      log.setUsageAfter(request.sessionId, seconds)
    }
  }
}
