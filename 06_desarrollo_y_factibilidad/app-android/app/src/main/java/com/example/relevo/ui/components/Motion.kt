package com.example.relevo.ui.components

import android.provider.Settings
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect

/**
 * Movimiento del manual: transiciones de 200 a 250 ms, sin rebotes; la única animación de
 * marca es escribir sobre el renglón (450 ms). Si Android pide quitar animaciones, no hay ninguna.
 */
object Motion {
  /** Curva que desacelera sin pasarse del destino, como las transiciones de iOS. */
  val Easing = CubicBezierEasing(0.2f, 0f, 0f, 1f)
  const val SHORT = 200
  const val STANDARD = 240
  const val WRITING = 450

  fun <T> standard(duration: Int = STANDARD): FiniteAnimationSpec<T> = tween(duration, easing = Easing)
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
