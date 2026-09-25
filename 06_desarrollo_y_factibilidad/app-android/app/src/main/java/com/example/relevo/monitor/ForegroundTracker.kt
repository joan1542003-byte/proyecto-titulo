package com.example.relevo.monitor

/**
 * Reconstruye qué aplicación está en primer plano a partir de los eventos de Tiempo de uso y suma
 * el tiempo que pasa en las aplicaciones elegidas. No depende de Android para poder probarse.
 */
class ForegroundTracker(initialMillis: Long, private val maxStepMillis: Long = MAX_STEP_MILLIS) {
  enum class Kind { RESUMED, PAUSED, SCREEN_OFF }

  var currentPackage: String? = null
    private set
  var accumulatedMillis: Long = 0L
  private var previousTick = initialMillis

  fun onEvent(kind: Kind, packageName: String?) {
    when (kind) {
      Kind.RESUMED -> currentPackage = packageName
      // Algunos fabricantes informan la pausa de la app anterior después de abrir la siguiente;
      // solo se limpia si corresponde a la app que se considera en primer plano.
      Kind.PAUSED -> if (currentPackage == packageName) currentPackage = null
      Kind.SCREEN_OFF -> currentPackage = null
    }
  }

  /**
   * Avanza el reloj. El paso se limita para que una pausa del proceso (por ejemplo, el teléfono
   * en reposo) no se cuente como uso continuo.
   */
  fun tick(nowMillis: Long, isTracked: (String?) -> Boolean): Boolean {
    val tracked = isTracked(currentPackage)
    if (tracked) accumulatedMillis += (nowMillis - previousTick).coerceIn(0L, maxStepMillis)
    previousTick = nowMillis
    return tracked
  }

  companion object { const val MAX_STEP_MILLIS = 2_000L }
}
