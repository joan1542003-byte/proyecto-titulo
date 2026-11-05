package com.example.relevo.ui.components

import androidx.compose.animation.core.EaseInOutSine
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import dev.chrisbanes.haze.HazeInputScale
import dev.chrisbanes.haze.HazeProgressive
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect

/**
 * Borde de desplazamiento (4.2, D-157), como el borde suave de iOS 26: el contenido que pasa bajo la barra
 * de arriba o bajo los botones de abajo se desenfoca de a poco y se funde con el papel, sin un corte.
 *
 * Es un desenfoque variable, como el de iOS: bajo la barra o los botones ([solid]) el radio es pleno, y en
 * los [ramp] siguientes baja punto a punto hasta cero, con una curva suave en los dos extremos para que no
 * se note dónde empieza. La 4.0 usaba un solo desenfoque que aparecía con una máscara, a media resolución y
 * bajo un velo de papel casi opaco: en la rampa se veían a la vez la imagen nítida y la borrosa, y abajo
 * quedaba una neblina. Desde Android 13 el desenfoque variable se calcula a resolución completa; en
 * Android 12, Haze vuelve a la máscara.
 *
 * Encima va un velo de papel que crece con la misma curva hasta [veil] en el borde de la pantalla: lo justo
 * para que la hora y los botones se lean aunque pase un color por debajo, sin tapar lo que pasa. [visible]
 * apaga el borde cuando nada pasa por debajo.
 */
@Composable
fun ScrollEdge(state: HazeState, top: Boolean, solid: Dp, modifier: Modifier = Modifier, ramp: Dp = 32.dp, visible: Float = 1f, veil: Float = .55f) {
  val paper = Relevo.colors.paper
  val density = LocalDensity.current
  val total = with(density) { (solid + ramp).toPx() }.coerceAtLeast(1f)
  val rampPx = with(density) { ramp.toPx() }.coerceIn(1f, total)
  Box(
    modifier.fillMaxWidth().height(solid + ramp).graphicsLayer { alpha = visible }
      .hazeEffect(state) {
        backgroundColor = paper
        blurRadius = EdgeBlur
        noiseFactor = 0f
        inputScale = HazeInputScale.None
        progressive = if (top) {
          HazeProgressive.verticalGradient(easing = EaseInOutSine, startY = total - rampPx, startIntensity = 1f, endY = total, endIntensity = 0f, preferPerformance = false)
        } else {
          HazeProgressive.verticalGradient(easing = EaseInOutSine, startY = 0f, startIntensity = 0f, endY = rampPx, endIntensity = 1f, preferPerformance = false)
        }
      }
      .drawBehind { drawRect(veilBrush(paper, top, veil)) },
  )
}

/** Radio pleno del borde: suficiente para que un texto que pasa por debajo no se lea, y sí su color. */
val EdgeBlur = 18.dp

/**
 * Velo de papel con una curva suave (seno de entrada y salida), en nueve tramos: en el borde de la pantalla
 * vale [max] y en el lado del contenido, cero.
 */
private fun veilBrush(paper: Color, top: Boolean, max: Float): Brush {
  val stops = (0..8).map { i ->
    val y = i / 8f
    val fromEdge = if (top) 1f - y else y
    val eased = (1f - kotlin.math.cos(Math.PI.toFloat() * fromEdge)) / 2f
    y to paper.copy(alpha = max * eased)
  }
  return Brush.verticalGradient(*stops.toTypedArray())
}
