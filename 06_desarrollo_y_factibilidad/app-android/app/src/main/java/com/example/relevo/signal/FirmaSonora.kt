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
 * Receta de un sonido de la señal: sus notas (inicio en s, altura en Hz y nivel), sus parciales (razón con la
 * nota, amplitud y caída en s), el ataque, el golpe de ruido que ayuda a ubicarlo, cuánto dura el motivo,
 * cada cuánto se repite y la rampa de volumen de cada repetición.
 */
internal class Perfil(
  val notes: List<Triple<Double, Double, Double>>,
  val partials: List<Triple<Double, Double, Double>>,
  val attack: Double,
  val noise: Double,
  val noiseSeconds: Double,
  val motif: Double,
  val period: Double,
  val gains: FloatArray,
)

/**
 * Sonidos que se pueden elegir en Ajustes (4.3, D-158). [MADERA] es la firma de Relevo (D-071); los otros tres
 * comparten su final, una cuarta que baja, y su duración, unos 30 s (D-078). Cada uno cambia lo que la
 * investigación sobre avisos sonoros muestra que mueve la urgencia y la molestia: el ritmo, la altura, el
 * espectro y la envolvente. Los fundamentos y las fuentes están en `sonido-de-relevo-2026-11-05.md`. En el Tag
 * suena siempre su propio pitido.
 */
enum class Sonido(val id: String, val label: String, val description: String, internal val perfil: Perfil) {
  /** Dos golpes de timbre de madera que bajan, de Re5 a La4, con un ataque de banda ancha para ubicarlo. */
  MADERA(
    "madera", "Madera", "Dos golpes de madera que bajan. Se ubica con facilidad.",
    Perfil(
      notes = listOf(Triple(0.00, 587.33, 1.00), Triple(0.46, 440.00, 0.92)),
      partials = listOf(Triple(1.0, 1.00, 0.95), Triple(3.9, 0.30, 0.22), Triple(9.2, 0.10, 0.07)),
      attack = 0.004, noise = 0.18, noiseSeconds = 0.004, motif = 2.2, period = 4.4,
      gains = floatArrayOf(0.40f, 0.60f, 0.80f, 1f, 1f, 1f, 1f),
    ),
  ),
  /** Más grave (La4 a Mi4), más lento y con menos repeticiones; armónicos breves y ataque de 20 ms. */
  FIELTRO(
    "fieltro", "Fieltro", "Más grave, lento y suave. Para una casa silenciosa.",
    Perfil(
      notes = listOf(Triple(0.00, 440.00, 1.00), Triple(0.60, 329.63, 0.92)),
      partials = listOf(Triple(1.0, 1.00, 0.45), Triple(2.0, 0.35, 0.20), Triple(3.0, 0.15, 0.10)),
      attack = 0.020, noise = 0.0, noiseSeconds = 0.0, motif = 3.0, period = 6.5,
      gains = floatArrayOf(0.30f, 0.50f, 0.70f, 0.60f, 0.50f),
    ),
  ),
  /** Corto-largo (Re5, Re5, La4) con seis armónicos que caen antes cuanto más agudos: se oye por espectro y ritmo. */
  CLARO(
    "claro", "Claro", "Más brillante y seguido. Para una casa con ruido.",
    Perfil(
      notes = listOf(Triple(0.00, 587.33, 0.85), Triple(0.25, 587.33, 0.85), Triple(0.71, 440.00, 1.00)),
      partials = listOf(
        Triple(1.0, 1.00, 0.35), Triple(2.0, 0.60, 0.25), Triple(3.0, 0.40, 0.18),
        Triple(4.0, 0.30, 0.13), Triple(5.0, 0.20, 0.10), Triple(6.0, 0.15, 0.08),
      ),
      attack = 0.005, noise = 0.22, noiseSeconds = 0.006, motif = 1.8, period = 3.3,
      gains = floatArrayOf(0.50f, 0.75f, 1f, 1f, 1f, 1f, 1f, 1f, 1f),
    ),
  ),
  /** Seis notas de un mismo acorde (La4, Re5, Fa♯5, Fa♯5, Re5, La4), sin segundas que rocen entre sí. */
  TONADA(
    "tonada", "Tonada", "Una frase corta de seis notas.",
    Perfil(
      notes = listOf(
        Triple(0.00, 440.00, 0.90), Triple(0.35, 587.33, 0.90), Triple(0.70, 739.99, 0.95),
        Triple(1.05, 739.99, 0.85), Triple(1.40, 587.33, 0.90), Triple(1.75, 440.00, 1.00),
      ),
      partials = listOf(Triple(1.0, 1.00, 0.50), Triple(2.0, 0.40, 0.30), Triple(3.0, 0.20, 0.20)),
      attack = 0.010, noise = 0.0, noiseSeconds = 0.0, motif = 2.7, period = 6.0,
      gains = floatArrayOf(0.40f, 0.60f, 0.80f, 1f, 1f),
    ),
  );

  companion object {
    /** El sonido guardado en Ajustes; si no hay uno, la firma. */
    fun from(id: String?): Sonido = entries.firstOrNull { it.id == id } ?: MADERA
  }
}

/**
 * Firma sonora de Relevo (D-071) y señal de unos 30 segundos (D-078), ahora para cada [Sonido] (4.3).
 *
 * [Sonido.MADERA] reproduce la receta de `10_recursos_visuales/marca-suena-donde-empieza/sonido/firma-sonora.py`:
 * dos golpes de timbre de madera en descenso (587 → 440 Hz), parciales 1 : 3,9 : 9,2 y un ataque breve de
 * banda ancha que ayuda a ubicar la fuente. Cada señal repite su motivo con pausas, empieza más suave y
 * termina sola.
 */
object FirmaSonora {
  const val SAMPLE_RATE = 44_100
  const val SIGNAL_SECONDS = 30.0

  private val PEAK = 10.0.pow(-3.0 / 20.0) // −3 dBFS, como la receta

  /** Un motivo con pico en −3 dBFS. */
  internal fun signature(sonido: Sonido = Sonido.MADERA): FloatArray {
    val perfil = sonido.perfil
    val n = (perfil.motif * SAMPLE_RATE).toInt()
    val out = DoubleArray(n)
    for ((start, f0, level) in perfil.notes) {
      val offset = (start * SAMPLE_RATE).toInt()
      if (offset >= n) continue
      val strike = strike(f0, n - offset, perfil)
      for (i in strike.indices) out[offset + i] += level * strike[i]
    }
    val tail = (0.25 * SAMPLE_RATE).toInt()
    for (i in 0 until tail) out[n - tail + i] *= 1.0 - i.toDouble() / (tail - 1)
    val max = out.maxOf { abs(it) }.takeIf { it > 0 } ?: 1.0
    return FloatArray(n) { (out[it] / max * PEAK).toFloat() }
  }

  /** Señal de D-078 en PCM de 16 bits: unos 30 s, con el motivo repetido y un comienzo más suave. */
  fun signal(sonido: Sonido = Sonido.MADERA): ShortArray = sequence(sonido, sonido.perfil.gains, SIGNAL_SECONDS)

  /** Prueba de sonido: un solo motivo. */
  fun test(sonido: Sonido = Sonido.MADERA): ShortArray = sequence(sonido, floatArrayOf(1f), sonido.perfil.motif)

  private fun sequence(sonido: Sonido, gains: FloatArray, totalSeconds: Double): ShortArray {
    val firma = signature(sonido)
    val total = max((totalSeconds * SAMPLE_RATE).toInt(), firma.size)
    val period = (sonido.perfil.period * SAMPLE_RATE).toInt()
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

  private fun strike(f0: Double, n: Int, perfil: Perfil): DoubleArray {
    val s = DoubleArray(n)
    for (i in 0 until n) {
      val t = i.toDouble() / SAMPLE_RATE
      var v = 0.0
      for ((ratio, amp, tau) in perfil.partials) v += amp * sin(2 * PI * f0 * ratio * t) * exp(-t / tau)
      val attack = min(1.0, t / perfil.attack)
      s[i] = v * (0.5 - 0.5 * cos(PI * attack))
    }
    if (perfil.noise <= 0.0) return s
    // Transitorio de banda ancha: ruido suavizado con ventana de Hann.
    val k = (perfil.noiseSeconds * SAMPLE_RATE).toInt().coerceAtLeast(2)
    val random = Random(7)
    val noise = DoubleArray(k) { random.nextGaussian() * (0.5 - 0.5 * cos(2 * PI * it / (k - 1))) }
    for (i in 0 until min(k, n)) {
      val smooth = (noise.getOrElse(i - 1) { 0.0 } + noise[i] + noise.getOrElse(i + 1) { 0.0 }) / 3.0
      s[i] += perfil.noise * smooth
    }
    return s
  }
}
