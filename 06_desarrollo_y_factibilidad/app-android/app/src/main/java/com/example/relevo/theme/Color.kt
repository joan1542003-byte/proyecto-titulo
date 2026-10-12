package com.example.relevo.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Paleta de la línea 3.0 (D-124 a D-128): papel tibio, tinta casi negra y seis fichas claras, una por
 * papel. Cada color dice siempre lo mismo; la selección va en tinta. El vidrio es un tinte translúcido
 * sobre un desenfoque, solo en la capa de navegación (D-083).
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
  /** Mantequilla: tu tiempo (las apps y los minutos). */
  val butter: Color,
  /** Cielo: tu primer paso. */
  val sky: Color,
  /** Lima: el lugar donde empiezas, y donde suena (D-127). */
  val lime: Color,
  /** Rubor: lo que decides. */
  val blush: Color,
  /** Lila: tu aura, lo que personalizas. */
  val lilac: Color,
  /** Durazno: lo que pasó después de la señal. */
  val peach: Color,
  /** Tinta de los íconos sobre las fichas de color: igual en claro y en oscuro. */
  val onTile: Color,
  val isDark: Boolean,
)

/** Las seis fichas son las mismas en los dos temas: luminosidad OKLCH 0,88–0,91 y tinta encima (12,7:1 a 14,5:1). */
private val Butter = Color(0xFFF4E496)
private val Sky = Color(0xFFB3E5FC)
private val Lime = Color(0xFFC6EEAE)
private val Blush = Color(0xFFFAC8D9)
private val Lilac = Color(0xFFDFD1FC)
private val Peach = Color(0xFFFBD1B3)
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
  butter = Butter, sky = Sky, lime = Lime, blush = Blush, lilac = Lilac, peach = Peach, onTile = TileInk,
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
  butter = Butter, sky = Sky, lime = Lime, blush = Blush, lilac = Lilac, peach = Peach, onTile = TileInk,
  isDark = true,
)

val LocalRelevoColors = staticCompositionLocalOf { LightColors }
