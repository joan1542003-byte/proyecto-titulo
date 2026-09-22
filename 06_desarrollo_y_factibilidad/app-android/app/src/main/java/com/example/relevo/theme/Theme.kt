package com.example.relevo.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

private val RelevoColorScheme =
  lightColorScheme(
    primary = RelevoTeal,
    onPrimary = RelevoWarmWhite,
    primaryContainer = RelevoMint,
    onPrimaryContainer = RelevoGraphite,
    secondary = RelevoGray,
    secondaryContainer = RelevoMint,
    onSecondaryContainer = RelevoGraphite,
    background = RelevoWarmWhite,
    onBackground = RelevoGraphite,
    surface = RelevoWarmWhite,
    onSurface = RelevoGraphite,
    surfaceVariant = RelevoSurface,
    onSurfaceVariant = RelevoGray,
    outline = RelevoGray,
    error = RelevoError,
  )

private val RelevoShapes =
  Shapes(
    extraSmall = RoundedCornerShape(10.dp),
    small = RoundedCornerShape(14.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(30.dp),
  )

@Composable
fun RelevoTheme(content: @Composable () -> Unit) {
  MaterialTheme(colorScheme = RelevoColorScheme, typography = Typography, shapes = RelevoShapes, content = content)
}
