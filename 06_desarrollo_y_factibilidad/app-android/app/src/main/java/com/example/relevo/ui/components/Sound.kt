package com.example.relevo.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * El sonido dibujado como anillos de tinta que se abren desde el objeto: el Tag suena, no brilla. Sin movimiento del sistema, quedan tres anillos quietos y tenues.
 */
@Composable
fun SoundRings(modifier: Modifier = Modifier, color: Color = Relevo.colors.onTile) {
  val reduce = rememberReduceMotion()
  val phase = if (reduce) null else rememberInfiniteTransition(label = "rings").animateFloat(
    0f, 1f, infiniteRepeatable(tween(2400, easing = LinearEasing)), label = "ring_phase",
  )
  Canvas(modifier) {
    val base = size.minDimension / 2f
    val stroke = Stroke(width = 1.4.dp.toPx())
    for (i in 0 until 3) {
      val p = phase?.value?.let { (it + i / 3f) % 1f } ?: ((i + 1) / 4f)
      val alpha = if (phase == null) .2f - i * .05f else (1f - p) * .5f
      drawCircle(color.copy(alpha = alpha.coerceIn(0f, 1f)), radius = base * (1f + p * 1.4f), style = stroke)
    }
  }
}
