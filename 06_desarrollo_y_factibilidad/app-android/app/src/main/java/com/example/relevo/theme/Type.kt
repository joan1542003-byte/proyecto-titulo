package com.example.relevo.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import cl.udp.relevo.R

/**
 * Instrument Sans variable (pesos 400–700, ancho 75–100), la letra de la línea 3.0 (D-128). Cada peso
 * fija el eje `wght` de forma explícita; sin eso, Android dibuja todos los pesos como el regular. El
 * logotipo no usa esta letra: es Chillax convertida a trazos (D-125).
 */
@OptIn(ExperimentalTextApi::class)
private fun instrument(weight: FontWeight) =
  Font(R.font.instrument_sans, weight, variationSettings = FontVariation.Settings(FontVariation.weight(weight.weight), FontVariation.width(100f)))

val InstrumentSans = FontFamily(
  instrument(FontWeight.Normal),
  instrument(FontWeight.Medium),
  instrument(FontWeight.SemiBold),
  instrument(FontWeight.Bold),
)

/** Peso de los titulares de la línea 3.0: 600, con interletrado cerrado. */
val FontWeight.Companion.Title: FontWeight get() = FontWeight.SemiBold

/**
 * Escala tipográfica. Toma la jerarquía de las apps de iOS (título grande, título, encabezado,
 * texto, nota): titulares en 600 con −2,5 % a −3 % y texto de 17 con interlineado
 * amplio. Nada va en mayúsculas sostenidas ni con letras espaciadas (D-084): los rótulos se
 * escriben como una frase.
 */
@Immutable
data class RelevoType(
  val largeTitle: TextStyle,
  val title: TextStyle,
  val title2: TextStyle,
  val headline: TextStyle,
  val body: TextStyle,
  val callout: TextStyle,
  val subhead: TextStyle,
  val footnote: TextStyle,
  val caption: TextStyle,
  /** Rótulo breve sobre un título: «Ahora», «La última vez». */
  val label: TextStyle,
  /** Título de un grupo de filas: «Ajustes», «Pasos». */
  val section: TextStyle,
  /** Lo que escribió la persona sobre el renglón. */
  val voice: TextStyle,
  /** La firma «Vuelve a ___.» con las palabras de la persona. */
  val signature: TextStyle,
  val button: TextStyle,
)

private val trim = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)

private fun style(size: Int, lineHeight: Int, weight: FontWeight, tracking: Double = 0.0) = TextStyle(
  fontFamily = InstrumentSans,
  fontSize = size.sp,
  lineHeight = lineHeight.sp,
  fontWeight = weight,
  letterSpacing = tracking.em,
  lineHeightStyle = trim,
)

internal val DefaultType = RelevoType(
  largeTitle = style(34, 38, FontWeight.Title, -0.03),
  title = style(28, 32, FontWeight.Title, -0.025),
  title2 = style(22, 27, FontWeight.SemiBold, -0.015),
  headline = style(17, 22, FontWeight.SemiBold),
  body = style(17, 26, FontWeight.Normal),
  callout = style(16, 23, FontWeight.Normal),
  subhead = style(15, 21, FontWeight.Normal),
  footnote = style(13, 18, FontWeight.Normal),
  caption = style(12, 16, FontWeight.Normal),
  label = style(14, 18, FontWeight.SemiBold),
  section = style(15, 20, FontWeight.SemiBold),
  voice = style(20, 26, FontWeight.Medium, -0.005),
  signature = style(36, 40, FontWeight.Title, -0.03),
  button = style(17, 22, FontWeight.SemiBold),
)

val LocalRelevoType = staticCompositionLocalOf { DefaultType }

/** Equivalencias para los componentes de Material que se usan (hojas y diálogos). */
internal val MaterialTypography = Typography(
  displaySmall = DefaultType.largeTitle,
  headlineLarge = DefaultType.largeTitle,
  headlineMedium = DefaultType.title,
  headlineSmall = DefaultType.title2,
  titleLarge = DefaultType.title2,
  titleMedium = DefaultType.headline,
  titleSmall = DefaultType.subhead.copy(fontWeight = FontWeight.SemiBold),
  bodyLarge = DefaultType.body,
  bodyMedium = DefaultType.subhead,
  bodySmall = DefaultType.footnote,
  labelLarge = DefaultType.button,
  labelMedium = DefaultType.footnote.copy(fontWeight = FontWeight.Medium),
  labelSmall = DefaultType.caption,
)
