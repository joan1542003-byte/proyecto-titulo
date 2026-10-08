package com.example.relevo.domain

import java.util.Locale
import java.util.UUID

/**
 * Llavero iTag clásico, el que se configura con las apps iSearching o Kindelf, usado como objeto que
 * suena (D-109). Relevo lo hace pitar con el servicio estándar de Bluetooth «Alerta inmediata»:
 * escribir 2 en «Nivel de alerta» lo enciende y 0 lo apaga, como la app de código abierto iTag One
 * (s4ysolutions/itag). Desde 2.27 también escribe 1 en FFE2 al pitar y 0 al callar: en el Tag del
 * autor, la alerta estándar sola no suena (D-116). Ver
 * 06_desarrollo_y_factibilidad/objetos-que-suenan-2026-09-29.md.
 */
object TagProtocol {
  /** Servicio estándar «Alerta inmediata» (0x1802) y su característica «Nivel de alerta» (0x2A06). */
  val IMMEDIATE_ALERT_SERVICE: UUID = uuid16(0x1802)
  val ALERT_LEVEL: UUID = uuid16(0x2A06)

  /**
   * Servicio propio del iTag (0xFFE0): FFE1 avisa cada vez que se aprieta el botón. FFE2 cambia según el
   * modelo: en algunos es la alarma por desconexión (Shing Lyu, 2023); en el Tag del autor, escribir 1
   * lo hace pitar. Relevo lo deja en 0 mientras espera y lo pone en 1 solo mientras suena.
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

  /** Descriptor estándar con el nombre que el fabricante le dio a una característica (0x2901). */
  val USER_DESCRIPTION: UUID = uuid16(0x2901)

  const val ALERT_OFF: Byte = 0x00
  const val ALERT_HIGH: Byte = 0x02

  /**
   * Niveles de alerta que la prueba recorre, en orden, hasta que la persona escucha el pitido: medio y alto.
   * Desde 2.29 el medio va primero: con el Tag del autor, el alto (el de iTag One) no pitaba y el medio sí,
   * según el registro de la prueba.
   */
  val ALERT_LEVELS = listOf(1, 2)

  /** El índice del nivel que sigue después de [current], o null si no quedan. */
  fun nextTry(current: Int): Int? = (current + 1).takeIf { it < ALERT_LEVELS.size }

  /** El índice del nivel guardado, o 0 si no es uno de los conocidos. */
  fun tryIndex(level: Int): Int = ALERT_LEVELS.indexOf(level).coerceAtLeast(0)

  /**
   * Cuánto pita: la señal, 30 s seguidos, como dura la del parlante (D-078), salvo que se toque el Tag; la
   * prueba, 3 s seguidos. La orden se repite cada [REPEAT_MILLIS] para que el pitido no se corte: algunos
   * Tag pitan un rato y se detienen solos.
   */
  fun durationMillis(test: Boolean): Long = if (test) TEST_MILLIS else SIGNAL_MILLIS

  const val REPEAT_MILLIS = 1_000L

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

  private const val SIGNAL_MILLIS = 30_000L
  private const val TEST_MILLIS = 3_000L

  private fun uuid16(short: Int): UUID = UUID.fromString(String.format(Locale.ROOT, "%08x-0000-1000-8000-00805f9b34fb", short))
}
