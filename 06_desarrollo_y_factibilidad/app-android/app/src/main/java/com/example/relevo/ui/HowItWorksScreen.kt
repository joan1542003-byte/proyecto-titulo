package com.example.relevo.ui

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.view.Surface
import android.view.TextureView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import cl.udp.relevo.R
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.IconAction
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.rememberReduceMotion

/** Un paso de «Cómo funciona»: qué hace la persona y qué pasa. */
private data class HowStep(val title: String, val text: String)

private val howSteps = listOf(
  HowStep("Elige qué quieres hacer", "Por ejemplo, leer 10 páginas. Anota el primer paso, como abrir el libro, y dónde lo haces."),
  HowStep("Elige las apps y el tiempo", "Por ejemplo, 15 minutos en Instagram. Relevo solo cuenta el tiempo en esas apps; no ve lo que haces en ellas."),
  HowStep("Deja el parlante donde empiezas", "Encendido y conectado al teléfono, junto a lo que necesitas para empezar. Algunas semanas la app te pedirá dejarlo en otro lugar o usar el teléfono."),
  HowStep("Cuando suene, tú decides", "Suena unos 30 segundos y se detiene solo. Puedes empezar, dejarlo para después o cambiar de idea. Ninguna respuesta es mejor que otra."),
  HowStep("Responde con un toque", "Después de cada aviso y al final de cada semana hay preguntas breves. Puedes omitirlas."),
)

/**
 * Explica cómo usar Relevo antes del consentimiento y, después, desde el perfil. Arriba, el video
 * vertical de 30 segundos (sin voz, empieza en silencio); abajo, los cinco pasos con las palabras
 * de la app. En la prueba, el objeto del video es un parlante Bluetooth.
 */
@Composable
internal fun HowItWorksScreen(onContinue: () -> Unit, continueLabel: String = "Seguir", onBack: (() -> Unit)? = null) {
  RelevoScreen(
    title = "Cómo funciona",
    onBack = onBack,
    bottom = { RelevoButton(continueLabel, onContinue) },
  ) {
    IntroVideo(Modifier.fillMaxWidth(.62f).align(Alignment.CenterHorizontally))
    SectionGap()
    Panel {
      howSteps.forEachIndexed { index, step ->
        Row(verticalAlignment = Alignment.Top) {
          Box(Modifier.size(32.dp).clip(CircleShape).background(Relevo.colors.ink), contentAlignment = Alignment.Center) {
            Text("${index + 1}", style = Relevo.type.label, color = Relevo.colors.onInk)
          }
          Spacer(Modifier.width(14.dp))
          Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(step.title, style = Relevo.type.headline, color = Relevo.colors.ink)
            Text(step.text, style = Relevo.type.subhead, color = Relevo.colors.graphite)
          }
        }
        if (index < howSteps.lastIndex) Spacer(Modifier.height(18.dp))
      }
    }
    Spacer(Modifier.height(14.dp))
    Text(
      "En esta prueba, el objeto que suena es un parlante Bluetooth. Lo que preparas y respondes se guarda en el teléfono y en la base del estudio, con un código en vez de tu nombre.",
      style = Relevo.type.footnote, color = Relevo.colors.graphite,
    )
  }
}

/**
 * Video vertical de 30 segundos. Se reproduce en un TextureView para que respete las esquinas
 * redondeadas. Empieza sin sonido; con «Reducir movimiento» activo no empieza solo. Tocarlo lo pausa
 * o lo retoma; al terminar, se puede ver de nuevo.
 */
@Composable
private fun IntroVideo(modifier: Modifier = Modifier) {
  val reduce = rememberReduceMotion()
  var player by remember { mutableStateOf<MediaPlayer?>(null) }
  var playing by remember { mutableStateOf(false) }
  var ended by remember { mutableStateOf(false) }
  var muted by remember { mutableStateOf(true) }

  fun play() { player?.let { if (ended) it.seekTo(0); it.start(); playing = true; ended = false } }
  fun pause() { player?.pause(); playing = false }

  LifecycleEventEffect(Lifecycle.Event.ON_PAUSE) { pause() }
  DisposableEffect(Unit) { onDispose { player?.release(); player = null } }

  Box(
    modifier
      .aspectRatio(9f / 16f)
      .clip(RoundedCornerShape(28.dp))
      .background(Relevo.colors.mist)
      .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Button) { if (playing) pause() else play() }
      .semantics { contentDescription = "Video de 30 segundos que explica Relevo. Tócalo para ${if (playing) "pausarlo" else "reproducirlo"}." },
  ) {
    AndroidView(
      factory = { context ->
        TextureView(context).apply {
          surfaceTextureListener = object : TextureView.SurfaceTextureListener {
            override fun onSurfaceTextureAvailable(texture: SurfaceTexture, width: Int, height: Int) {
              val created = MediaPlayer.create(context, R.raw.relevo_como_funciona) ?: return
              created.setSurface(Surface(texture))
              created.setVolume(if (muted) 0f else 1f, if (muted) 0f else 1f)
              created.setOnCompletionListener { playing = false; ended = true }
              player = created
              if (!reduce) { created.start(); playing = true } else created.seekTo(1)
            }
            override fun onSurfaceTextureSizeChanged(texture: SurfaceTexture, width: Int, height: Int) = Unit
            override fun onSurfaceTextureDestroyed(texture: SurfaceTexture): Boolean {
              player?.release(); player = null; playing = false
              return true
            }
            override fun onSurfaceTextureUpdated(texture: SurfaceTexture) = Unit
          }
        }
      },
      modifier = Modifier.matchParentSize(),
    )
    Row(Modifier.align(Alignment.BottomEnd).padding(10.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
      IconAction(
        if (muted) KitIcon.SILENCIAR else KitIcon.PARLANTE,
        if (muted) "Activar el sonido" else "Quitar el sonido",
        { muted = !muted; player?.setVolume(if (muted) 0f else 1f, if (muted) 0f else 1f) },
        filled = true,
      )
      IconAction(
        when { ended -> KitIcon.REINTENTAR; playing -> KitIcon.PAUSAR; else -> KitIcon.REPRODUCIR },
        when { ended -> "Ver de nuevo"; playing -> "Pausar"; else -> "Reproducir" },
        { if (playing) pause() else play() },
        filled = true,
      )
    }
  }
}
