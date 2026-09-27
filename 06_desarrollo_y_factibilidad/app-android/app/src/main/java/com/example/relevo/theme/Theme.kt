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
  /**
   * Formas (D-083): botones, controles y etiquetas en cápsula; tarjetas y fotos con esquinas amplias;
   * hojas flotantes aún más redondeadas, concéntricas con las del teléfono. Nada de bloques cuadrados.
   */
  val controlShape = RoundedCornerShape(percent = 50)
  val panelShape = RoundedCornerShape(28.dp)
  val tileShape = RoundedCornerShape(22.dp)
  val sheetShape = RoundedCornerShape(34.dp)
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
      surfaceVariant = colors.mist, onSurfaceVariant = colors.graphite, surfaceContainerLow = colors.card,
      surfaceContainer = colors.card, surfaceContainerHigh = colors.card,
      outline = colors.line, outlineVariant = colors.line, error = colors.error,
    )
  } else {
    lightColorScheme(
      primary = colors.ink, onPrimary = colors.onInk, secondary = colors.voice,
      background = colors.paper, onBackground = colors.ink, surface = colors.paper, onSurface = colors.ink,
      surfaceVariant = colors.mist, onSurfaceVariant = colors.graphite, surfaceContainerLow = colors.card,
      surfaceContainer = colors.card, surfaceContainerHigh = colors.card,
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
        extraSmall = RoundedCornerShape(12.dp),
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
