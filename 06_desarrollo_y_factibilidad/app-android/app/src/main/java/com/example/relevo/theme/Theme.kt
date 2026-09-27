package com.example.relevo.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

/** Acceso a los tokens de Relevo: `Relevo.colors.ink`, `Relevo.type.body`. */
object Relevo {
  val colors: RelevoColors
    @Composable @ReadOnlyComposable get() = LocalRelevoColors.current
  val type: RelevoType
    @Composable @ReadOnlyComposable get() = LocalRelevoType.current

  /** Margen de pantalla del manual: 20 dp, como el de un cuaderno. */
  val margin = 20.dp
  /** Esquinas: 12 dp en botones y campos; 20 dp en paneles y fotos. Nunca píldoras. */
  val controlShape = RoundedCornerShape(12.dp)
  val panelShape = RoundedCornerShape(20.dp)
}

/**
 * Tema de la marca D-073. La persona puede fijar claro u oscuro y agrandar el texto (Apariencia);
 * el tamaño se suma al que ya pide Android, nunca lo reemplaza.
 */
@Composable
fun RelevoTheme(darkTheme: Boolean = isSystemInDarkTheme(), largeText: Boolean = false, content: @Composable () -> Unit) {
  val colors = if (darkTheme) DarkColors else LightColors
  val scheme = if (darkTheme) {
    darkColorScheme(
      primary = colors.ink, onPrimary = colors.onInk, secondary = colors.voice,
      background = colors.paper, onBackground = colors.ink, surface = colors.paper, onSurface = colors.ink,
      surfaceVariant = colors.mist, onSurfaceVariant = colors.graphite, surfaceContainerLow = colors.paper,
      surfaceContainer = colors.paper, surfaceContainerHigh = colors.mist,
      outline = colors.line, outlineVariant = colors.line, error = colors.error,
    )
  } else {
    lightColorScheme(
      primary = colors.ink, onPrimary = colors.onInk, secondary = colors.voice,
      background = colors.paper, onBackground = colors.ink, surface = colors.paper, onSurface = colors.ink,
      surfaceVariant = colors.mist, onSurfaceVariant = colors.graphite, surfaceContainerLow = colors.paper,
      surfaceContainer = colors.paper, surfaceContainerHigh = colors.mist,
      outline = colors.line, outlineVariant = colors.line, error = colors.error,
    )
  }
  val density = LocalDensity.current
  val scaled = if (largeText) Density(density.density, density.fontScale * LARGE_TEXT) else density
  CompositionLocalProvider(LocalRelevoColors provides colors, LocalRelevoType provides DefaultType, LocalDensity provides scaled) {
    MaterialTheme(
      colorScheme = scheme,
      typography = MaterialTypography,
      shapes = Shapes(
        extraSmall = RoundedCornerShape(8.dp),
        small = Relevo.controlShape,
        medium = Relevo.controlShape,
        large = Relevo.panelShape,
        extraLarge = Relevo.panelShape,
      ),
      content = content,
    )
  }
}

/** «Texto grande» en Apariencia: 15 % más, sobre el tamaño de Android. */
private const val LARGE_TEXT = 1.15f
