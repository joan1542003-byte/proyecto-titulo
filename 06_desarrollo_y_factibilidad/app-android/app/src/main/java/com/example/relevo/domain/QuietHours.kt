package com.example.relevo.domain

/**
 * Horas sin sonar (1.0.0). En la prueba en los hogares, una persona contó que de noche oía el sonido desde
 * la cama y no se levantaba: a esa hora no le servía (Tabla 4 de la memoria). Entre [from] y [until] Relevo
 * no cuenta ni suena; el relevo sigue activo y retoma solo cuando terminan. Las horas van de 0 a 23 y el
 * tramo puede cruzar la medianoche, como de 23 a 8.
 */
object QuietHours {
  const val DEFAULT_FROM = 23
  const val DEFAULT_UNTIL = 8

  /** La hora [hour] cae dentro del tramo. Si [from] y [until] son iguales, el tramo está vacío. */
  fun contains(hour: Int, from: Int, until: Int): Boolean = when {
    from == until -> false
    from < until -> hour in from until until
    else -> hour >= from || hour < until
  }

  /** «23:00 a 8:00». */
  fun label(from: Int, until: Int): String = "$from:00 a $until:00"
}
