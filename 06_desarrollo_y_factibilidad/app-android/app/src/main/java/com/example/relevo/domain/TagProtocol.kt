package com.example.relevo.domain

import java.util.Locale
import java.util.UUID

/**
 * Llavero iTag clásico, el que se configura con las apps iSearching o Kindelf, usado como objeto que
 * suena (D-109). Relevo lo hace pitar con el servicio estándar de Bluetooth «Alerta inmediata»:
 * escribir 2 en «Nivel de alerta» lo enciende y 0 lo apaga. Lo mismo usan la app de código abierto
 * iTag One (s4ysolutions/itag) y la función «Alert / Stop alert» de iSearching. Ver
 * 06_desarrollo_y_factibilidad/objetos-que-suenan-2026-09-29.md.
 */
object TagProtocol {
  /** Servicio estándar «Alerta inmediata» (0x1802) y su característica «Nivel de alerta» (0x2A06). */
  val IMMEDIATE_ALERT_SERVICE: UUID = uuid16(0x1802)
  val ALERT_LEVEL: UUID = uuid16(0x2A06)

  /**
   * Servicio propio del iTag (0xFFE0): FFE1 avisa cada vez que se aprieta el botón y FFE2 enciende o
   * apaga la alarma que suena en el llavero cuando pierde la conexión con el teléfono.
   */
  val KEY_SERVICE: UUID = uuid16(0xFFE0)
  val BUTTON: UUID = uuid16(0xFFE1)
  val LINK_LOSS_SWITCH: UUID = uuid16(0xFFE2)

  /**
   * Servicio estándar «Pérdida de enlace» (0x1803): su «Nivel de alerta» en 0 también apaga la alarma por
   * desconexión en los llaveros que lo tienen. Relevo usa las dos formas.
   */
  val LINK_LOSS_SERVICE: UUID = uuid16(0x1803)

  /** Descriptor estándar para pedir avisos de una característica (0x2902). */
  val CLIENT_CONFIG: UUID = uuid16(0x2902)

  const val ALERT_OFF: Byte = 0x00
  const val ALERT_HIGH: Byte = 0x02

  /** Un pitido de [onMillis] seguido de [offMillis] en silencio. */
  data class Pulse(val onMillis: Long, val offMillis: Long)

  /**
   * La señal dura 30 s, como la del parlante (D-078): seis pitidos de 2 s separados por 3 s, para que
   * no sea un pitido continuo. La prueba es un solo pitido de 2 s.
   */
  fun pulses(test: Boolean): List<Pulse> =
    if (test) listOf(Pulse(TEST_MILLIS, 0L)) else List(SIGNAL_PULSES) { Pulse(PULSE_ON_MILLIS, PULSE_OFF_MILLIS) }

  /**
   * Reconoce un iTag en la búsqueda: se anuncia como «iTAG» o «iTag», a veces seguido de espacios,
   * o publica alguno de sus servicios.
   */
  fun looksLikeTag(name: String?, services: Collection<UUID>): Boolean =
    name?.trim()?.contains("itag", ignoreCase = true) == true ||
      services.any { it == KEY_SERVICE || it == IMMEDIATE_ALERT_SERVICE }

  /** Fuerza de la señal en palabras, para elegir el llavero correcto cuando hay varios cerca. */
  fun strength(rssi: Int): String = when {
    rssi >= -60 -> "Muy cerca"
    rssi >= -75 -> "Cerca"
    else -> "Lejos"
  }

  private const val SIGNAL_PULSES = 6
  private const val PULSE_ON_MILLIS = 2_000L
  private const val PULSE_OFF_MILLIS = 3_000L
  private const val TEST_MILLIS = 2_000L

  private fun uuid16(short: Int): UUID = UUID.fromString(String.format(Locale.ROOT, "%08x-0000-1000-8000-00805f9b34fb", short))
}
