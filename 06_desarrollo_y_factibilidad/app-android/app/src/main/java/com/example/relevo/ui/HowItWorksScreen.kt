package com.example.relevo.ui

import android.graphics.SurfaceTexture
import androidx.compose.foundation.layout.fillMaxSize
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PictureContent
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
import androidx.compose.ui.text.font.FontWeight
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.GlassTextButton
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.PhotoImage
import com.example.relevo.ui.components.ProgressLine
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.StatusChip
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

/** Una pantalla de la guía: un título, un ejemplo que se ve como en la app y una explicación corta. */
private class GuidePage(val key: String, val title: String, val text: String, val example: @Composable () -> Unit)

/**
 * Guía de la primera vez (D-088, D-090). Antes del consentimiento, pocas pantallas dan el contexto:
 * qué es Relevo (el video), para qué sirve —la intención que queda esperando mientras se usa el
 * teléfono (memoria, secciones 3 y 7)— y cómo funciona el sistema: la app, el parlante y la persona,
 * que decide (sección 11). Lo demás se aprende haciendo el primer relevo, guiado paso a paso, para no
 * cargar la primera vez (criterio 6). La primera vez termina preguntando por el aviso semanal, sin
 * respuesta marcada. Desde el perfil se abre igual, sin esa pregunta.
 */
@Composable
internal fun HowItWorksScreen(
  onContinue: () -> Unit,
  continueLabel: String = "Entendido",
  onBack: (() -> Unit)? = null,
  /** Registro de uso: segundos vistos, si llegó al final y si activó el sonido. */
  onVideo: (seconds: Int, completed: Boolean, soundOn: Boolean) -> Unit = { _, _, _ -> },
  /** Solo la primera vez: la respuesta al aviso semanal. */
  onReturnNotice: ((Boolean) -> Unit)? = null,
  /** Registro de uso: la pantalla de la guía que se muestra. */
  onPage: (String) -> Unit = {},
) {
  val pages = buildList {
    add(GuidePage("video", "Esto es Relevo", "Mira este video corto. Después te contamos cómo funciona y hacemos juntos tu primer relevo.") {
      IntroVideo(Modifier.fillMaxWidth(.84f), onVideo)
    })
    add(GuidePage("para_que", "¿Te ha pasado?", "Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas.") {
      GuidePanel {
        PhotoImage(Photo.TIEMPO, Modifier.fillMaxWidth().height(170.dp).clip(RoundedCornerShape(20.dp)))
        Spacer(Modifier.height(16.dp))
        Text("Abres una app para descansar.", style = Relevo.type.title2, color = Relevo.colors.ink)
        Spacer(Modifier.height(4.dp))
        Text("Se pasa el rato y lo que querías hacer queda esperando.", style = Relevo.type.body, color = Relevo.colors.graphite)
      }
    })
    add(GuidePage("sistema", "Cómo funciona", "Cuando suene, nos cuentas qué hiciste con un toque. Ninguna respuesta es mejor que otra.") {
      GuidePanel {
        SystemRow(KitIcon.TELEFONO, "La app", "Anotas qué quieres hacer y cómo empiezas.")
        Spacer(Modifier.height(18.dp))
        SystemRow(KitIcon.PARLANTE, "Lo que suena", "Un parlante, un reloj o un Tag que dejas donde empiezas. Suena cuando llevas en tus apps el tiempo que elegiste.")
        Spacer(Modifier.height(18.dp))
        SystemRow(KitIcon.USUARIO, "Tú", "Decides si empiezas o sigues con lo que estabas haciendo.")
      }
    })
    if (onReturnNotice != null) add(GuidePage("aviso_semanal", "Una última pregunta", "Si pasas una semana sin abrir Relevo, ¿quieres que te avise una vez? Lo puedes cambiar cuando quieras en Perfil.") {
      GuidePanel {
        StatusChip(KitIcon.AVISOS, "Relevo")
        Spacer(Modifier.height(10.dp))
        Text("¿Quieres preparar un relevo esta semana?", style = Relevo.type.headline, color = Relevo.colors.ink)
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
    trailing = if (!last) ({ GlassTextButton("Saltar", { go(pages.lastIndex) }, color = Relevo.colors.graphite) }) else null,
    bottom = {
      when {
        !last -> RelevoButton("Seguir", { go(index + 1) })
        onReturnNotice != null -> {
          // Las dos respuestas pesan lo mismo: ninguna viene sugerida.
          RelevoButton("Sí, avísame", { onReturnNotice(true); onContinue() }, kind = ButtonKind.Secondary)
          RelevoButton("No, gracias", { onReturnNotice(false); onContinue() }, kind = ButtonKind.Secondary)
        }
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
        SectionGap()
        Text(shown.text, style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.fillMaxWidth())
      }
    }
  }
}

/** Una parte del sistema: icono en un círculo, su nombre y qué hace. */
@Composable
private fun SystemRow(icon: KitIcon, title: String, text: String) {
  Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
    Box(Modifier.size(44.dp).clip(CircleShape).background(Relevo.colors.mist), contentAlignment = Alignment.Center) {
      RelevoIcon(icon, size = 22.dp, background = Relevo.colors.mist)
    }
    Spacer(Modifier.width(14.dp))
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
      Text(title, style = Relevo.type.headline, color = Relevo.colors.ink)
      Text(text, style = Relevo.type.subhead, color = Relevo.colors.graphite)
    }
  }
}

/**
 * Primer relevo (D-090): después de registrarse, la app propone hacerlo juntos, con el primer paso de
 * la ruta que la persona eligió como ejemplo. Así la guía no solo explica: deja el primer relevo listo.
 */
@Composable
internal fun FirstRelevoScreen(name: String, suggestion: String?, routeTitle: String?, picture: Picture, onStart: () -> Unit, onLater: () -> Unit) {
  RelevoScreen(
    hero = { PictureContent(picture, Modifier.fillMaxSize(), iconSize = 64.dp, wide = true) },
    heroHeight = 200.dp,
    heroPicture = picture,
    bottom = {
      RelevoButton("Empezar", onStart)
      RelevoButton("Lo hago después", onLater, kind = ButtonKind.Secondary)
    },
  ) {
    Spacer(Modifier.height(24.dp))
    Text(if (name.isBlank()) "Hagamos tu primer relevo" else "${name.trim()}, hagamos tu primer relevo", style = Relevo.type.title, color = Relevo.colors.ink)
    Spacer(Modifier.height(10.dp))
    Text(
      if (suggestion != null && routeTitle != null) "Empecemos con «$suggestion», de tu ruta «$routeTitle». Te guiamos paso a paso y puedes cambiar lo que quieras."
      else "Te guiamos paso a paso. Toma un par de minutos.",
      style = Relevo.type.body, color = Relevo.colors.graphite,
    )
    SectionGap()
    Panel {
      listOf("Qué quieres hacer", "Cómo empiezas", "Dónde empiezas", "Cuándo suena", "Dónde suena", "Activarlo").forEachIndexed { i, step ->
        Row(Modifier.fillMaxWidth().padding(vertical = 2.dp), verticalAlignment = Alignment.CenterVertically) {
          Box(Modifier.size(26.dp).clip(CircleShape).background(Relevo.colors.ink), contentAlignment = Alignment.Center) {
            Text("${i + 1}", style = Relevo.type.footnote, color = Relevo.colors.onInk)
          }
          Spacer(Modifier.width(12.dp))
          Text(step, style = Relevo.type.subhead, color = Relevo.colors.ink)
        }
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
