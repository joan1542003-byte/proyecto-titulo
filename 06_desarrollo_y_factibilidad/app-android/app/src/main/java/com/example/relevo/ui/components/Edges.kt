package com.example.relevo.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
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
 * Borde de desplazamiento de la 4.0 (D-155), como en iOS 26: el contenido que pasa bajo la barra de arriba
 * o bajo los botones de abajo se desenfoca de a poco y se funde con el papel. Detrás de la barra o de los
 * botones el desenfoque es pleno; en los últimos [fade] hacia el contenido se apaga. Encima va un velo de
 * papel que deja leer la hora y los botones aunque pase un color por debajo.
 *
 * Para no repetir lo que pasó en la 2.28, cuando el desenfoque bajaba la app de los 60 cuadros, se calcula
 * sobre la imagen reducida a la mitad y con una máscara en vez de un desenfoque variable punto por punto.
 * [visible] lo apaga cuando nada pasa por debajo.
 */
@Composable
fun ScrollEdge(state: HazeState, top: Boolean, height: Dp, modifier: Modifier = Modifier, fade: Dp = 26.dp, visible: Float = 1f) {
  val paper = Relevo.colors.paper
  val density = LocalDensity.current
  val total = with(density) { height.toPx() }.coerceAtLeast(1f)
  val ramp = with(density) { fade.toPx() }.coerceIn(1f, total)
  // Dónde termina la parte plena, en fracción del borde: arriba, al empezar la rampa; abajo, al terminarla.
  val edge = if (top) (total - ramp) / total else ramp / total
  Box(
    modifier.fillMaxWidth().height(height).graphicsLayer { alpha = visible }
      .hazeEffect(state) {
        backgroundColor = paper
        blurRadius = 20.dp
        noiseFactor = 0f
        inputScale = HazeInputScale.Fixed(0.5f)
        progressive = if (top) {
          HazeProgressive.verticalGradient(startY = total - ramp, startIntensity = 1f, endY = total, endIntensity = 0f, preferPerformance = true)
        } else {
          HazeProgressive.verticalGradient(startY = 0f, startIntensity = 0f, endY = ramp, endIntensity = 1f, preferPerformance = true)
        }
      }
      .drawBehind {
        val veil = if (top) {
          Brush.verticalGradient(0f to paper.copy(alpha = .86f), edge to paper.copy(alpha = .74f), 1f to paper.copy(alpha = 0f))
        } else {
          Brush.verticalGradient(0f to paper.copy(alpha = 0f), edge to paper.copy(alpha = .8f), 1f to paper.copy(alpha = .9f))
        }
        drawRect(veil)
      },
  )
}
