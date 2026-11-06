package com.example.relevo.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import com.example.relevo.theme.Relevo
import kotlinx.coroutines.launch

/**
 * Nombre de una familia de actividades que responde cuando se elige algo suyo (4.3, D-158): un pulso breve
 * —crece un 6 % y vuelve, con resortes sin rebote— y, por un momento, el degradado de su anillo recorre las
 * letras y se apaga hasta volver a la tinta. Así el grupo también confirma qué tipo de actividad se eligió,
 * no solo el anillo. Cada vez que [pulse] cambia, el pulso se repite; con «quitar animaciones» solo cambia
 * el color.
 */
@Composable
fun FamilyLabel(sky: Sky, pulse: Int, modifier: Modifier = Modifier) {
  val reduce = rememberReduceMotion()
  val scale = remember { Animatable(1f) }
  val glow = remember { Animatable(0f) }
  val sweep = remember { Animatable(0f) }
  LaunchedEffect(pulse) {
    if (pulse == 0) return@LaunchedEffect
    if (!reduce) launch {
      scale.animateTo(1.06f, spring(dampingRatio = 1f, stiffness = 1100f))
      scale.animateTo(1f, spring(dampingRatio = 1f, stiffness = 260f))
    }
    launch {
      sweep.snapTo(0f)
      sweep.animateTo(1f, tween(1200, easing = LinearOutSlowInEasing))
    }
    glow.animateTo(1f, tween(160))
    glow.animateTo(0f, tween(700, delayMillis = 450))
  }
  val style = Relevo.type.headline
  Box(modifier.graphicsLayer { scaleX = scale.value; scaleY = scale.value; transformOrigin = TransformOrigin(0f, .5f) }) {
    Text(sky.familyName, style = style, color = Relevo.colors.ink.copy(alpha = 1f - glow.value), modifier = Modifier.semantics { heading() })
    if (glow.value > 0f) {
      Text(
        sky.familyName, style = style.copy(brush = movingGradient(sky.ring, sweep.value)),
        modifier = Modifier.graphicsLayer { alpha = glow.value }.clearAndSetSemantics {},
      )
    }
  }
}

/** Degradado del anillo que se desplaza a lo ancho del texto: [phase] de 0 a 1 lo recorre una vez. */
private fun movingGradient(colors: List<Color>, phase: Float): ShaderBrush = object : ShaderBrush() {
  override fun createShader(size: Size): Shader {
    val width = size.width.coerceAtLeast(1f)
    val start = -width + phase * width
    return LinearGradientShader(Offset(start, 0f), Offset(start + width, 0f), colors, tileMode = TileMode.Mirror)
  }
}
