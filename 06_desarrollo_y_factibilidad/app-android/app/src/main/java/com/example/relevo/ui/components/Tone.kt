package com.example.relevo.ui.components

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.relevo.theme.Relevo

/**
 * Pedidos de tono de la barra de estado. Al pasar de un fondo a otro, la pantalla nueva pide su tono
 * antes de que la anterior se vaya; por eso, al irse una, se aplica el último pedido que sigue vivo.
 */
private object StatusBarRequests {
  val active = mutableListOf<Pair<Any, Boolean>>()
}

/**
 * Iconos de la barra de estado claros sobre fondos oscuros y oscuros sobre fondos claros. Al salir,
 * vuelven a los de la pantalla que queda o a los del tema.
 */
@Composable
fun StatusBarTone(darkBackground: Boolean) {
  val view = LocalView.current
  val themeDark = Relevo.colors.isDark
  val token = remember { Any() }
  if (view.isInEditMode) return
  DisposableEffect(darkBackground, themeDark) {
    val window = view.context.findActivity()?.window
    val controller = window?.let { WindowCompat.getInsetsController(it, view) }
    StatusBarRequests.active.removeAll { it.first === token }
    StatusBarRequests.active.add(token to darkBackground)
    controller?.isAppearanceLightStatusBars = !darkBackground
    onDispose {
      StatusBarRequests.active.removeAll { it.first === token }
      controller?.isAppearanceLightStatusBars = !(StatusBarRequests.active.lastOrNull()?.second ?: themeDark)
    }
  }
}

private tailrec fun Context.findActivity(): Activity? = when (this) {
  is Activity -> this
  is ContextWrapper -> baseContext.findActivity()
  else -> null
}
