package com.example.relevo.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Paleta del manual de marca D-073, con las superficies de vidrio que el autor pidió para la app
 * (D-083). El azul es solo para lo que escribe la persona o para el foco de un control; nunca decora.
 * El vidrio es un tinte translúcido sobre un desenfoque: sin brillos ni degradados de luz.
 */
@Immutable
data class RelevoColors(
  /** Papel: fondo general. */
  val paper: Color,
  /** Tarjeta: el contenido agrupado, apenas más claro que el papel. */
  val card: Color,
  /** Tinta: texto, acciones y lo impreso. */
  val ink: Color,
  /** Texto sobre un botón de tinta. */
  val onInk: Color,
  /** Grafito: texto secundario (5,71:1 sobre papel). */
  val graphite: Color,
  /** Niebla: rellenos de controles secundarios. */
  val mist: Color,
  /** Línea de separación. */
  val line: Color,
  /** Gris: deshabilitado; no se usa para texto. */
  val gray: Color,
  /** Pizarra: tinta presionada. */
  val slate: Color,
  /** La voz de la persona: lo que escribe sobre el renglón. */
  val voice: Color,
  /** Azul muy suave para una selección. */
  val voiceSoft: Color,
  /** Solo errores. */
  val error: Color,
  /** Tinte del vidrio de la capa de navegación. */
  val glass: Color,
  /** Borde fino que separa el vidrio del contenido. */
  val glassEdge: Color,
  /** Velo detrás de una hoja. */
  val scrim: Color,
  val isDark: Boolean,
)

internal val LightColors = RelevoColors(
  paper = Color(0xFFF2F2EF),
  card = Color(0xFFFCFCFA),
  ink = Color(0xFF17181C),
  onInk = Color(0xFFF2F2EF),
  graphite = Color(0xFF5B5F68),
  mist = Color(0xFFE5E5E2),
  line = Color(0xFFD5D6D8),
  gray = Color(0xFF9BA0A9),
  slate = Color(0xFF33363D),
  voice = Color(0xFF2A4BD7),
  voiceSoft = Color(0xFFEEF1FD),
  error = Color(0xFFB3261E),
  glass = Color(0xFFF7F7F4).copy(alpha = 0.66f),
  glassEdge = Color(0xFF17181C).copy(alpha = 0.07f),
  scrim = Color.Black.copy(alpha = 0.18f),
  isDark = false,
)

/** Tema oscuro del kit: noche de fondo y azul claro para lo que escribe la persona. */
internal val DarkColors = RelevoColors(
  paper = Color(0xFF111215),
  card = Color(0xFF1B1C20),
  ink = Color(0xFFE9EAEC),
  onInk = Color(0xFF111215),
  graphite = Color(0xFF9BA0A9),
  mist = Color(0xFF26282D),
  line = Color(0xFF30333A),
  gray = Color(0xFF5B5F68),
  slate = Color(0xFFC9CBCF),
  voice = Color(0xFF8CA6FF),
  voiceSoft = Color(0xFF1C2238),
  error = Color(0xFFF2B8B5),
  glass = Color(0xFF1B1C20).copy(alpha = 0.68f),
  glassEdge = Color.White.copy(alpha = 0.09f),
  scrim = Color.Black.copy(alpha = 0.45f),
  isDark = true,
)

val LocalRelevoColors = staticCompositionLocalOf { LightColors }
