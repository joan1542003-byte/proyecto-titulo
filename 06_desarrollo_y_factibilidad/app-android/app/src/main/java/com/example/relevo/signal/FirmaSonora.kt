package com.example.relevo.signal

import java.util.Random
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sin

/**
 * Firma sonora de Relevo (D-071) y señal de unos 30 segundos (D-078).
 *
 * Reproduce la receta de `10_recursos_visuales/marca-suena-donde-empieza/sonido/firma-sonora.py`:
 * dos golpes de timbre de madera en descenso (587 → 440 Hz), parciales 1 : 3,9 : 9,2 y un ataque
 * breve de banda ancha que ayuda a ubicar la fuente. La señal repite la firma con pausas, empieza
 * más suave y termina sola.
 */
object FirmaSonora {
  const val SAMPLE_RATE = 44_100
  const val SIGNATURE_SECONDS = 2.2
  const val SIGNAL_SECONDS = 30.0

  /** Cada repetición empieza 4,4 s después de la anterior: 2,2 s de firma y 2,2 s de pausa. */
  const val PERIOD_SECONDS = 4.4

  /** Siete repeticiones; las primeras suben de a poco para no sobresaltar. */
  val SIGNAL_GAINS = floatArrayOf(0.40f, 0.60f, 0.80f, 1f, 1f, 1f, 1f)

  private val NOTES = listOf(Triple(0.00, 587.33, 1.00), Triple(0.46, 440.00, 0.92)) // inicio (s), Hz, nivel
  private val PARTIALS = listOf(Triple(1.0, 1.00, 0.95), Triple(3.9, 0.30, 0.22), Triple(9.2, 0.10, 0.07)) // razón, amplitud, tau (s)
  private val PEAK = 10.0.pow(-3.0 / 20.0) // −3 dBFS, como la receta

  /** Una firma de 2,2 s con pico en −3 dBFS. */
  fun signature(): FloatArray {
    val n = (SIGNATURE_SECONDS * SAMPLE_RATE).toInt()
    val out = DoubleArray(n)
    for ((start, f0, level) in NOTES) {
      val offset = (start * SAMPLE_RATE).toInt()
      val strike = strike(f0, n - offset)
      for (i in strike.indices) out[offset + i] += level * strike[i]
    }
    val tail = (0.25 * SAMPLE_RATE).toInt()
    for (i in 0 until tail) out[n - tail + i] *= 1.0 - i.toDouble() / (tail - 1)
    val max = out.maxOf { abs(it) }.takeIf { it > 0 } ?: 1.0
    return FloatArray(n) { (out[it] / max * PEAK).toFloat() }
  }

  /** Señal de D-078 en PCM de 16 bits: unos 30 s, con la firma repetida y un comienzo más suave. */
  fun signal(): ShortArray = sequence(SIGNAL_GAINS, SIGNAL_SECONDS)

  /** Prueba de sonido de la preparación: una sola firma. */
  fun test(): ShortArray = sequence(floatArrayOf(1f), SIGNATURE_SECONDS)

  private fun sequence(gains: FloatArray, totalSeconds: Double): ShortArray {
    val firma = signature()
    val total = max((totalSeconds * SAMPLE_RATE).toInt(), firma.size)
    val period = (PERIOD_SECONDS * SAMPLE_RATE).toInt()
    val pcm = ShortArray(total)
    gains.forEachIndexed { rep, gain ->
      val offset = rep * period
      for (i in firma.indices) {
        val index = offset + i
        if (index >= total) break
        pcm[index] = (min(1f, max(-1f, firma[i] * gain)) * Short.MAX_VALUE).roundToInt().toShort()
      }
    }
    return pcm
  }

  private fun strike(f0: Double, n: Int): DoubleArray {
    val s = DoubleArray(n)
    for (i in 0 until n) {
      val t = i.toDouble() / SAMPLE_RATE
      var v = 0.0
      for ((ratio, amp, tau) in PARTIALS) v += amp * sin(2 * PI * f0 * ratio * t) * exp(-t / tau)
      val attack = min(1.0, t / 0.004)
      s[i] = v * (0.5 - 0.5 * cos(PI * attack))
    }
    // Transitorio de banda ancha de 4 ms: ruido suavizado con ventana de Hann.
    val k = (0.004 * SAMPLE_RATE).toInt()
    val random = Random(7)
    val noise = DoubleArray(k) { random.nextGaussian() * (0.5 - 0.5 * cos(2 * PI * it / (k - 1))) }
    for (i in 0 until min(k, n)) {
      val smooth = (noise.getOrElse(i - 1) { 0.0 } + noise[i] + noise.getOrElse(i + 1) { 0.0 }) / 3.0
      s[i] += 0.18 * smooth
    }
    return s
  }
}
