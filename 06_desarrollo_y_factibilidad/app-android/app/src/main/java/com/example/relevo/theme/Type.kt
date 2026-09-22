package com.example.relevo.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import cl.udp.relevo.R

private val RelevoFontFamily =
  FontFamily(
    Font(R.font.source_sans_3_regular, FontWeight.Normal),
    Font(R.font.source_sans_3_medium, FontWeight.Medium),
    Font(R.font.source_sans_3_semibold, FontWeight.SemiBold),
    Font(R.font.source_sans_3_bold, FontWeight.Bold),
  )

private val BaseTypography = Typography()

val Typography =
  Typography(
    displayLarge = BaseTypography.displayLarge.copy(fontFamily = RelevoFontFamily),
    displayMedium = BaseTypography.displayMedium.copy(fontFamily = RelevoFontFamily),
    displaySmall = BaseTypography.displaySmall.copy(fontFamily = RelevoFontFamily),
    headlineLarge = BaseTypography.headlineLarge.copy(fontFamily = RelevoFontFamily),
    headlineMedium = BaseTypography.headlineMedium.copy(fontFamily = RelevoFontFamily),
    headlineSmall = BaseTypography.headlineSmall.copy(fontFamily = RelevoFontFamily),
    titleLarge = BaseTypography.titleLarge.copy(fontFamily = RelevoFontFamily),
    titleMedium = BaseTypography.titleMedium.copy(fontFamily = RelevoFontFamily),
    titleSmall = BaseTypography.titleSmall.copy(fontFamily = RelevoFontFamily),
    bodyLarge = BaseTypography.bodyLarge.copy(fontFamily = RelevoFontFamily),
    bodyMedium = BaseTypography.bodyMedium.copy(fontFamily = RelevoFontFamily),
    bodySmall = BaseTypography.bodySmall.copy(fontFamily = RelevoFontFamily),
    labelLarge = BaseTypography.labelLarge.copy(fontFamily = RelevoFontFamily),
    labelMedium = BaseTypography.labelMedium.copy(fontFamily = RelevoFontFamily),
    labelSmall = BaseTypography.labelSmall.copy(fontFamily = RelevoFontFamily),
  )
