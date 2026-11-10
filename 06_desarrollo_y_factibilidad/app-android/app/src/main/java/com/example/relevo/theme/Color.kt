package com.example.relevo.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Paleta de la 4.0 (D-155): la interfaz va en papel y tinta, y el color es solo de las actividades, en
 * su anillo. Las seis fichas de papel de la 3.0 (D-124) se retiraron: un ícono con color y otro sin él
 * no decían nada claro. El vidrio es un tinte translúcido sobre un desenfoque, solo en la navegación.
 *
 * 4.5 (D-163): los neutros se veían amarillentos en los dos temas. Tenían el tono de la crema (OKLCH h 68–75°);
 * ahora conservan su luminosidad, y con ella todos los contrastes, con un 40 % de su croma y el tono en 60°: un
 * papel apenas tibio, no crema.
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
private val TileInk = Color(0xFF141313)

internal val LightColors = RelevoColors(
  paper = Color(0xFFF6F4F3),
  card = Color(0xFFFFFFFF),
  ink = Color(0xFF141313),
  onInk = Color(0xFFFFFFFF),
  graphite = Color(0xFF686663),
  mist = Color(0xFFECE9E7),
  line = Color(0xFFE2DEDC),
  gray = Color(0xFFA6A19E),
  slate = Color(0xFF32302F),
  voice = Color(0xFF141313),
  voiceSoft = Color(0xFFECE9E7),
  error = Color(0xFFB3261E),
  glass = Color(0xFFFFFFFF).copy(alpha = 0.62f),
  glassEdge = Color(0xFF141313).copy(alpha = 0.06f),
  scrim = Color.Black.copy(alpha = 0.18f),
  onTile = TileInk,
  isDark = false,
)

/** Tema oscuro «Noche» (D-128): se conserva para quien lo eligió, con los mismos papeles. */
internal val DarkColors = RelevoColors(
  paper = Color(0xFF141313),
  card = Color(0xFF1E1D1C),
  ink = Color(0xFFF0EEED),
  onInk = Color(0xFF141313),
  graphite = Color(0xFFA8A4A2),
  mist = Color(0xFF292726),
  line = Color(0xFF343231),
  gray = Color(0xFF6B6966),
  slate = Color(0xFFD5D2D0),
  voice = Color(0xFFF0EEED),
  voiceSoft = Color(0xFF292726),
  error = Color(0xFFF2B8B5),
  glass = Color(0xFF1E1D1C).copy(alpha = 0.68f),
  glassEdge = Color.White.copy(alpha = 0.09f),
  scrim = Color.Black.copy(alpha = 0.45f),
  onTile = TileInk,
  isDark = true,
)

val LocalRelevoColors = staticCompositionLocalOf { LightColors }
