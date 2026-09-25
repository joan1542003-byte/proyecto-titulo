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
 * Schibsted Grotesk variable (eje de peso 400–900), en todos los usos (D-073). Cada peso fija el
 * eje `wght` de forma explícita; sin eso, Android dibuja todos los pesos como el regular.
 */
@OptIn(ExperimentalTextApi::class)
private fun schibsted(weight: FontWeight) =
  Font(R.font.schibsted_grotesk, weight, variationSettings = FontVariation.Settings(FontVariation.weight(weight.weight)))

val SchibstedGrotesk = FontFamily(
  schibsted(FontWeight.Normal),
  schibsted(FontWeight.Medium),
  schibsted(FontWeight.SemiBold),
  schibsted(FontWeight(650)),
  schibsted(FontWeight.Bold),
)

/** Peso de titular del manual: 650. */
val FontWeight.Companion.Title: FontWeight get() = FontWeight(650)

/**
 * Escala tipográfica. Toma la jerarquía de las apps de iOS (título grande, título, encabezado,
 * texto, nota) con las reglas del manual: titulares en 650 con −2 %, texto de 17 con interlineado
 * amplio y notas en mayúsculas con +6 %.
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
  /** Nota del manual: 500, 13, mayúsculas con +6 %. Para rótulos de sección. */
  val label: TextStyle,
  /** Lo que escribió la persona sobre el renglón. */
  val voice: TextStyle,
  /** La firma «Vuelve a ___.» con las palabras de la persona. */
  val signature: TextStyle,
  val button: TextStyle,
)

private val trim = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)

private fun style(size: Int, lineHeight: Int, weight: FontWeight, tracking: Double = 0.0) = TextStyle(
  fontFamily = SchibstedGrotesk,
  fontSize = size.sp,
  lineHeight = lineHeight.sp,
  fontWeight = weight,
  letterSpacing = tracking.em,
  lineHeightStyle = trim,
)

internal val DefaultType = RelevoType(
  largeTitle = style(34, 40, FontWeight.Title, -0.02),
  title = style(28, 34, FontWeight.Title, -0.02),
  title2 = style(22, 28, FontWeight.SemiBold, -0.01),
  headline = style(17, 22, FontWeight.SemiBold),
  body = style(17, 26, FontWeight.Normal),
  callout = style(16, 23, FontWeight.Normal),
  subhead = style(15, 21, FontWeight.Normal),
  footnote = style(13, 18, FontWeight.Normal),
  caption = style(12, 16, FontWeight.Normal),
  label = style(13, 18, FontWeight.Medium, 0.06),
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
