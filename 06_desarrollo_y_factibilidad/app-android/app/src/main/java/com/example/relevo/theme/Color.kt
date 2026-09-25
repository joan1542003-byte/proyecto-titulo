package com.example.relevo.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Paleta del manual de marca D-073. El azul es solo para lo que escribe la persona o para el foco
 * de un control; nunca decora. Sin degradados ni luz (D-070).
 */
@Immutable
data class RelevoColors(
  /** Papel: fondo general. */
  val paper: Color,
  /** Tinta: texto, acciones y lo impreso. */
  val ink: Color,
  /** Texto sobre un botón de tinta. */
  val onInk: Color,
  /** Grafito: texto secundario (5,71:1 sobre papel). */
  val graphite: Color,
  /** Niebla: paneles y controles de fondo. */
  val mist: Color,
  /** Línea de separación. */
  val line: Color,
  /** Gris: deshabilitado; no se usa para texto. */
  val gray: Color,
  /** La voz de la persona: lo que escribe sobre el renglón. */
  val voice: Color,
  /** Azul muy suave para una selección. */
  val voiceSoft: Color,
  /** Solo errores. */
  val error: Color,
  val isDark: Boolean,
)

internal val LightColors = RelevoColors(
  paper = Color(0xFFF2F2EF),
  ink = Color(0xFF17181C),
  onInk = Color(0xFFF2F2EF),
  graphite = Color(0xFF5B5F68),
  mist = Color(0xFFE3E4E6),
  line = Color(0xFFC9CBCF),
  gray = Color(0xFF9BA0A9),
  voice = Color(0xFF2A4BD7),
  voiceSoft = Color(0xFFEEF1FD),
  error = Color(0xFFB3261E),
  isDark = false,
)

/** Tema oscuro del kit: noche de fondo y azul claro para lo que escribe la persona. */
internal val DarkColors = RelevoColors(
  paper = Color(0xFF111215),
  ink = Color(0xFFE9EAEC),
  onInk = Color(0xFF111215),
  graphite = Color(0xFF9BA0A9),
  mist = Color(0xFF1C1E23),
  line = Color(0xFF30333A),
  gray = Color(0xFF5B5F68),
  voice = Color(0xFF8CA6FF),
  voiceSoft = Color(0xFF1C2238),
  error = Color(0xFFF2B8B5),
  isDark = true,
)

val LocalRelevoColors = staticCompositionLocalOf { LightColors }
