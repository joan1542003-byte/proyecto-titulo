package com.example.relevo.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Paleta de la 4.0 (D-155): la interfaz va en papel y tinta, y el color es solo de las actividades, en
 * su anillo. Las seis fichas de papel de la 3.0 (D-124) se retiraron: un ícono con color y otro sin él
 * no decían nada claro. El vidrio es un tinte translúcido sobre un desenfoque, solo en la navegación.
 */
@Immutable
data class RelevoColors(
  /** Papel: fondo general. */
  val paper: Color,
  /** Tarjeta: el contenido agrupado, más claro que el papel. */
  val card: Color,
  /** Tinta: texto, acciones, la selección y lo que escribe la persona. */
  val ink: Color,
  /** Texto sobre un botón de tinta. */
  val onInk: Color,
  /** Grafito: texto secundario y el segundo tono de los títulos (5,3:1 sobre papel). */
  val graphite: Color,
  /** Piedra: rellenos de controles secundarios y fichas sin papel. */
  val mist: Color,
  /** Línea de separación. */
  val line: Color,
  /** Gris: deshabilitado; no se usa para texto. */
  val gray: Color,
  /** Pizarra: tinta presionada. */
  val slate: Color,
  /** Lo que escribe la persona. Desde 3.0 va en tinta, como toda la selección. */
  val voice: Color,
  /** Fondo suave de una selección. */
  val voiceSoft: Color,
  /** Solo errores, siempre con ícono y texto. */
  val error: Color,
  /** Tinte del vidrio de la capa de navegación. */
  val glass: Color,
  /** Borde fino que separa el vidrio del contenido. */
  val glassEdge: Color,
  /** Velo detrás de una hoja. */
  val scrim: Color,
  /** Tinta de los íconos sobre el color de una actividad: igual en claro y en oscuro. */
  val onTile: Color,
  val isDark: Boolean,
)

/** Tinta fija sobre el color de una actividad, en los dos temas. */
private val TileInk = Color(0xFF141312)

internal val LightColors = RelevoColors(
  paper = Color(0xFFF7F4F0),
  card = Color(0xFFFFFFFF),
  ink = Color(0xFF141312),
  onInk = Color(0xFFFFFFFF),
  graphite = Color(0xFF6B655F),
  mist = Color(0xFFEEE9E3),
  line = Color(0xFFE4DED6),
  gray = Color(0xFFA9A197),
  slate = Color(0xFF33302C),
  voice = Color(0xFF141312),
  voiceSoft = Color(0xFFEEE9E3),
  error = Color(0xFFB3261E),
  glass = Color(0xFFFFFFFF).copy(alpha = 0.62f),
  glassEdge = Color(0xFF141312).copy(alpha = 0.06f),
  scrim = Color.Black.copy(alpha = 0.18f),
  onTile = TileInk,
  isDark = false,
)

/** Tema oscuro «Noche» (D-128): se conserva para quien lo eligió, con los mismos papeles. */
internal val DarkColors = RelevoColors(
  paper = Color(0xFF141312),
  card = Color(0xFF1F1D1B),
  ink = Color(0xFFF2EEE9),
  onInk = Color(0xFF141312),
  graphite = Color(0xFFABA49C),
  mist = Color(0xFF2A2724),
  line = Color(0xFF36322E),
  gray = Color(0xFF6E6862),
  slate = Color(0xFFD8D2CB),
  voice = Color(0xFFF2EEE9),
  voiceSoft = Color(0xFF2A2724),
  error = Color(0xFFF2B8B5),
  glass = Color(0xFF1F1D1B).copy(alpha = 0.68f),
  glassEdge = Color.White.copy(alpha = 0.09f),
  scrim = Color.Black.copy(alpha = 0.45f),
  onTile = TileInk,
  isDark = true,
)

val LocalRelevoColors = staticCompositionLocalOf { LightColors }
