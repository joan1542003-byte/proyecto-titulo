package com.example.relevo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.relevo.monitor.ReturnNotice
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    LaunchRequests.handle(intent)
    setContent { MainNavigation() }
  }

  override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)
    setIntent(intent)
    LaunchRequests.handle(intent)
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
