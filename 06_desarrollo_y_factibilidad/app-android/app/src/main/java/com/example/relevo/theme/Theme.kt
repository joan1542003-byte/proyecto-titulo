package com.example.relevo.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val RelevoColorScheme =
  lightColorScheme(
    primary = RelevoTeal,
    onPrimary = RelevoWarmWhite,
    primaryContainer = RelevoMint,
    onPrimaryContainer = RelevoGraphite,
    secondary = RelevoGray,
    background = RelevoWarmWhite,
    onBackground = RelevoGraphite,
    surface = RelevoWarmWhite,
    onSurface = RelevoGraphite,
    surfaceVariant = RelevoSurface,
    onSurfaceVariant = RelevoGray,
    outline = RelevoGray,
    error = RelevoError,
  )

@Composable
fun RelevoTheme(content: @Composable () -> Unit) {
  MaterialTheme(colorScheme = RelevoColorScheme, typography = Typography, content = content)
}
