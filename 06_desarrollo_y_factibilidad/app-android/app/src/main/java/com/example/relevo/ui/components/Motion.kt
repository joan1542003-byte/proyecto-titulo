package com.example.relevo.ui.components

import androidx.compose.animation.togetherWith
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.fadeOut
import androidx.compose.animation.fadeIn
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.AnimatedContent
import android.provider.Settings
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import kotlinx.coroutines.delay

/**
 * Movimiento del manual: transiciones de 200 a 250 ms, sin rebotes; la única animación de marca
 * es escribir sobre el renglón (450 ms). Si Android pide quitar animaciones, no hay ninguna.
 */
object Motion {
  /** Curva que desacelera sin pasarse del destino, como las transiciones de iOS. */
  val Easing = CubicBezierEasing(0.2f, 0f, 0f, 1f)
  const val SHORT = 200
  const val STANDARD = 240
  const val WRITING = 450

  fun <T> standard(duration: Int = STANDARD): FiniteAnimationSpec<T> = tween(duration, easing = Easing)

  /**
   * Resorte con amortiguación crítica: llega en unos 250 ms y nunca rebota. Se puede interrumpir a
   * mitad de camino sin saltos, como las animaciones de SwiftUI.
   */
  fun <T> smooth(stiffness: Float = 520f, visibilityThreshold: T? = null): FiniteAnimationSpec<T> =
    spring(dampingRatio = Spring.DampingRatioNoBouncy, stiffness = stiffness, visibilityThreshold = visibilityThreshold)
}

/** Lee el ajuste de animaciones de Android y lo vuelve a leer al regresar a la app. */
@Composable
fun rememberReduceMotion(): Boolean {
  val context = LocalContext.current
  fun read() = Settings.Global.getFloat(context.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE, 1f) == 0f
  var reduce by remember { mutableStateOf(read()) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { reduce = read() }
  return reduce
}

/** Al presionar, el elemento se hunde un poco y vuelve sin rebote. */
@Composable
fun Modifier.pressScale(interaction: InteractionSource, pressed: Float = 0.97f): Modifier {
  val reduce = rememberReduceMotion()
  val isPressed by interaction.collectIsPressedAsState()
  val scale by animateFloatAsState(if (isPressed && !reduce) pressed else 1f, Motion.smooth(stiffness = 700f), label = "press_scale")
  return graphicsLayer { scaleX = scale; scaleY = scale }
}

/**
 * Entrada breve del contenido: aparece y sube 12 dp, escalonado por [index]. Solo la primera vez;
 * al volver a una pantalla ya vista, el contenido está en su lugar.
 */
@Composable
fun Modifier.appear(index: Int = 0): Modifier {
  val reduce = rememberReduceMotion()
  var shown by rememberSaveable { mutableStateOf(false) }
  val progress = remember { Animatable(if (shown || reduce) 1f else 0f) }
  val distance = with(LocalDensity.current) { 12.dp.toPx() }
  LaunchedEffect(Unit) {
    if (progress.value < 1f) {
      delay(40L * index.coerceAtMost(8))
      progress.animateTo(1f, tween(260, easing = Motion.Easing))
    }
    shown = true
  }
  return graphicsLayer {
    alpha = progress.value
    translationY = (1f - progress.value) * distance
  }
}

/**
 * Una cifra que cambia como en iOS (4.1, D-156): el valor nuevo entra deslizándose y el anterior sale, hacia
 * abajo cuando la cuenta baja, como el contenido numérico de SwiftUI. El cambio se ve y no salta. Sin
 * movimiento si Android lo pide.
 */
@Composable
fun <T : Comparable<T>> RollingContent(value: T, modifier: Modifier = Modifier, content: @Composable (T) -> Unit) {
  val reduce = rememberReduceMotion()
  AnimatedContent(
    targetState = value,
    modifier = modifier,
    transitionSpec = {
      if (reduce) EnterTransition.None togetherWith ExitTransition.None
      else {
        val down = targetState < initialState
        (slideInVertically(Motion.smooth()) { if (down) -it / 3 else it / 3 } + fadeIn(Motion.standard(180))) togetherWith
          (slideOutVertically(Motion.smooth()) { if (down) it / 3 else -it / 3 } + fadeOut(Motion.standard(120))) using SizeTransform(clip = false)
      }
    },
    label = "rolling",
  ) { content(it) }
}
