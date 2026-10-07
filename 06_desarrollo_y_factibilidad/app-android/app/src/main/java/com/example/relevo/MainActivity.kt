package com.example.relevo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.relevo.monitor.ProjectMessages
import com.example.relevo.monitor.ReturnNotice
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    preferFastestRefreshRate()
    LaunchRequests.handle(intent)
    messageOpened(intent)
    setContent { MainNavigation() }
  }

  override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)
    setIntent(intent)
    LaunchRequests.handle(intent)
    messageOpened(intent)
  }

  /**
   * Pide la frecuencia de pantalla más alta que el teléfono ofrece con la misma resolución (90 o 120 Hz),
   * para que las animaciones vayan a 60 cuadros por segundo o más (2.28). Android puede bajarla para
   * ahorrar batería; la app solo la pide.
   */
  private fun preferFastestRefreshRate() {
    val display = display ?: return
    val current = display.mode
    val fastest = display.supportedModes
      .filter { it.physicalWidth == current.physicalWidth && it.physicalHeight == current.physicalHeight }
      .maxByOrNull { it.refreshRate } ?: return
    if (fastest.modeId != current.modeId) window.attributes = window.attributes.apply { preferredDisplayModeId = fastest.modeId }
  }

  /** Se abrió la app desde un mensaje del proyecto (D-096): queda registrado cuándo. */
  private fun messageOpened(intent: Intent?) {
    val id = intent?.getStringExtra(ProjectMessages.EXTRA_MESSAGE_ID) ?: return
    intent.removeExtra(ProjectMessages.EXTRA_MESSAGE_ID)
    val context = applicationContext
    Thread { runCatching { ProjectMessages.opened(context, id) } }.start()
  }
}

/** Pedidos que llegan desde fuera de la app, como «Preparar» en el aviso de regreso (V2). */
object LaunchRequests {
  val prepareLast = MutableStateFlow(false)

  fun handle(intent: Intent?) {
    if (intent?.getBooleanExtra(ReturnNotice.EXTRA_PREPARE, false) == true) {
      intent.removeExtra(ReturnNotice.EXTRA_PREPARE)
      prepareLast.value = true
    }
  }
}
