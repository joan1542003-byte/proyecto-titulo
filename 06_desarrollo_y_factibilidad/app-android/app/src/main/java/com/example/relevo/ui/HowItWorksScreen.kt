package com.example.relevo.ui

import android.graphics.SurfaceTexture
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.PhotoImage
import com.example.relevo.ui.components.RelevoIcon
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
import com.example.relevo.ui.components.rememberReduceMotion
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.PlainAction

/** Una pantalla de la guía: un título, un ejemplo que se ve como en la app y una explicación corta. */
private class GuidePage(val key: String, val title: String, val text: String, val example: @Composable () -> Unit)

/**
 * «Cómo funciona Relevo», desde Perfil: qué es (el video), para qué sirve —lo que la persona quería hacer
 * queda esperando mientras usa el teléfono (memoria, capítulos 3 y 7)— y cómo funciona el sistema. Desde
 * 1.0.0 ya no va en la primera vez: el primer relevo, guiado paso a paso, enseña haciendo (criterio 6).
 */
@Composable
internal fun HowItWorksScreen(
  onContinue: () -> Unit,
  continueLabel: String = "Entendido",
  onBack: (() -> Unit)? = null,
  /** Registro de uso: segundos vistos, si llegó al final y si activó el sonido. */
  onVideo: (seconds: Int, completed: Boolean, soundOn: Boolean) -> Unit = { _, _, _ -> },
  /** Registro de uso: la pantalla de la guía que se muestra. */
  onPage: (String) -> Unit = {},
) {
  val pages = buildList {
    add(GuidePage("video", "Esto es Relevo", "Un video corto: cómo se prepara un relevo y qué pasa cuando suena.") {
      IntroVideo(Modifier.fillMaxWidth(.78f), onVideo)
    })
    add(GuidePage("para_que", "¿Te ha pasado?", "Relevo suena a tiempo, en el lugar donde empiezas, para que lo que querías hacer no quede esperando.") {
      GuidePanel {
        PhotoImage(Photo.TIEMPO, Modifier.fillMaxWidth().height(170.dp).clip(RoundedCornerShape(20.dp)))
        Spacer(Modifier.height(16.dp))
        Text("Abres una app para descansar.", style = Relevo.type.title2, color = Relevo.colors.ink)
        Spacer(Modifier.height(4.dp))
        Text("Se pasa el rato y lo que querías hacer queda esperando.", style = Relevo.type.body, color = Relevo.colors.graphite)
      }
    })
    add(GuidePage("sistema", "Cómo funciona", "Cuando suena, dices qué decidiste con un toque. Ninguna respuesta es mejor que otra.") {
      // 3.1: cada parte en su tarjeta, con el color de su papel: el primer paso, el lugar y lo que decides.
      Column(verticalArrangement = Arrangement.spacedBy(Gap.list)) {
        ListRow("Cuenta tu tiempo", icon = KitIcon.TIEMPO, subtitle = "En las apps que eliges.")
        ListRow("Te recuerda cómo empezar", icon = KitIcon.PRIMER_PASO, subtitle = "Algo pequeño, que toma segundos.")
        ListRow("Suena donde empiezas", icon = KitIcon.LUGAR, subtitle = "En el Tag que dejas ahí, en el teléfono o en un dispositivo de audio.")
        ListRow("Tú decides", icon = KitIcon.DECISION, subtitle = "Empezar, dejarlo para después o cambiar de idea.")
      }
    })
  }
  var index by rememberSaveable { mutableIntStateOf(0) }
  var forward by remember { mutableStateOf(true) }
  val reduce = rememberReduceMotion()
  val page = pages[index.coerceIn(0, pages.lastIndex)]
  val last = index >= pages.lastIndex
  fun go(to: Int) { forward = to > index; index = to.coerceIn(0, pages.lastIndex) }
  LaunchedEffect(page.key) { onPage(page.key) }
  BackHandler(enabled = index > 0) { go(index - 1) }
  RelevoScreen(
    title = page.title,
    onBack = if (index > 0) ({ go(index - 1) }) else onBack,
    step = "${index + 1} de ${pages.size}",
    progress = (index + 1f) / pages.size,
    trailing = if (!last) ({ PlainAction("Saltar", { go(pages.lastIndex) }, color = Relevo.colors.graphite) }) else null,
    bottom = {
      when {
        !last -> RelevoButton("Seguir", { go(index + 1) })
        else -> RelevoButton(continueLabel, onContinue)
      }
    },
  ) {
    AnimatedContent(
      targetState = index,
      transitionSpec = {
        if (reduce) EnterTransition.None togetherWith ExitTransition.None
        else if (forward) (slideInHorizontally(Motion.smooth()) { it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.smooth()) { -it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
        else (slideInHorizontally(Motion.smooth()) { -it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.smooth()) { it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
      },
      label = "guide",
    ) { current ->
      val shown = pages[current.coerceIn(0, pages.lastIndex)]
      Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        shown.example()
        Spacer(Modifier.height(Gap.section))
        Text(shown.text, style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.fillMaxWidth())
      }
    }
  }
}

/** Marco de los ejemplos de la guía. */
@Composable
private fun GuidePanel(content: @Composable ColumnScope.() -> Unit) {
  Panel(Modifier.fillMaxWidth()) { content() }
}

/**
 * Nota de la guía dentro de una pantalla real (preparar, señal, respuesta), solo hasta completar el
 * primer relevo. Dice qué hacer en esa pantalla y para qué, en una o dos frases.
 */
@Composable
internal fun GuideTip(text: String, modifier: Modifier = Modifier) {
  Row(
    modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(Relevo.colors.voiceSoft).padding(horizontal = 16.dp, vertical = 12.dp),
    verticalAlignment = Alignment.Top,
  ) {
    RelevoIcon(KitIcon.AYUDA, size = 20.dp, tint = Relevo.colors.voice, background = Relevo.colors.voiceSoft)
    Spacer(Modifier.width(10.dp))
    Text(text, style = Relevo.type.subhead, color = Relevo.colors.ink)
  }
}

/**
 * Video vertical de 30 segundos. Se reproduce en un TextureView para que respete las esquinas
 * redondeadas. Empieza sin sonido; con «Reducir movimiento» activo no empieza solo. Tocarlo lo pausa
 * o lo retoma; al terminar, se puede ver de nuevo.
 */
@Composable
private fun IntroVideo(modifier: Modifier = Modifier, onVideo: (Int, Boolean, Boolean) -> Unit = { _, _, _ -> }) {
  val reduce = rememberReduceMotion()
  var player by remember { mutableStateOf<MediaPlayer?>(null) }
  var playing by remember { mutableStateOf(false) }
  var ended by remember { mutableStateOf(false) }
  var muted by remember { mutableStateOf(true) }
  var watchedMs by remember { mutableStateOf(0) }
  var completedOnce by remember { mutableStateOf(false) }
  var soundOnce by remember { mutableStateOf(false) }
  fun track(mp: MediaPlayer?) { mp?.let { runCatching { watchedMs = maxOf(watchedMs, it.currentPosition) } } }

  fun play() { player?.let { if (ended) it.seekTo(0); it.start(); playing = true; ended = false } }
  fun pause() { track(player); player?.pause(); playing = false }

  LifecycleEventEffect(Lifecycle.Event.ON_PAUSE) { pause() }
  DisposableEffect(Unit) {
    onDispose {
      track(player)
      onVideo(watchedMs / 1000, completedOnce, soundOnce)
      player?.release(); player = null
    }
  }

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
              created.setOnCompletionListener { mp -> watchedMs = maxOf(watchedMs, mp.duration); completedOnce = true; playing = false; ended = true }
              player = created
              if (!reduce) { created.start(); playing = true } else created.seekTo(1)
            }
            override fun onSurfaceTextureSizeChanged(texture: SurfaceTexture, width: Int, height: Int) = Unit
            override fun onSurfaceTextureDestroyed(texture: SurfaceTexture): Boolean {
              track(player); player?.release(); player = null; playing = false
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
        { muted = !muted; if (!muted) soundOnce = true; player?.setVolume(if (muted) 0f else 1f, if (muted) 0f else 1f) },
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
