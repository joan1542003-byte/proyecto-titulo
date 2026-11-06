package com.example.relevo.ui

import android.graphics.SurfaceTexture
import androidx.compose.foundation.layout.fillMaxSize
import com.example.relevo.ui.components.Picture
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
import com.example.relevo.ui.components.ProgressLine
import com.example.relevo.ui.components.RelevoIcon
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
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
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
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.pictureIcon

/** Una pantalla de la guía: un título, un ejemplo que se ve como en la app y una explicación corta. */
private class GuidePage(val key: String, val title: String, val text: String, val example: @Composable () -> Unit)

/**
 * Guía de la primera vez (D-088, D-090). Antes del consentimiento, pocas pantallas dan el contexto:
 * para qué sirve —la intención que queda esperando mientras se usa el
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
  /** Solo la primera vez: la respuesta al aviso semanal. */
  onReturnNotice: ((Boolean) -> Unit)? = null,
  /** Registro de uso: la pantalla de la guía que se muestra. */
  onPage: (String) -> Unit = {},
) {
  val pages = buildList {
    add(GuidePage("para_que", "¿Te ha pasado?", "Cuando se cumple el tiempo que elegiste en tus apps, Relevo suena donde empieza lo que querías hacer.") {
      GuidePanel {
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { ActivityRing(KitIcon.TIEMPO, 88.dp) }
        Spacer(Modifier.height(16.dp))
        Text("Abres una app para descansar.", style = Relevo.type.title2, color = Relevo.colors.ink)
        Spacer(Modifier.height(4.dp))
        Text("Se pasa el rato y lo que querías hacer queda esperando.", style = Relevo.type.body, color = Relevo.colors.graphite)
      }
    })
    add(GuidePage("sistema", "Cómo funciona", "" ) {
      // 4.0: las cuatro partes en un grupo, con íconos iguales.
      ListSection {
        ListRow("Cuenta el tiempo", icon = KitIcon.TIEMPO, subtitle = "En las apps que eliges")
        ListRow("Te recuerda cómo empezar", icon = KitIcon.COMENCE, subtitle = "Con un primer paso, como abrir el libro")
        ListRow("Suena donde empiezas", icon = KitIcon.LUGAR, subtitle = "En el Tag o en un dispositivo de audio, junto a lo que quieres hacer")
        ListRow("Tú decides", icon = KitIcon.DECISION, subtitle = "Empezar, dejarlo o cambiar de idea")
      }
    })
    if (onReturnNotice != null) add(GuidePage("aviso_semanal", "¿Te avisamos si pasa una semana?", "Si pasas una semana sin abrir Relevo, te llega este aviso una sola vez. Puedes apagarlo cuando quieras.") {
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
  val scroll = rememberScrollState()
  // Cada paso empieza arriba (4.3): el desplazamiento de un paso no se arrastra al siguiente.
  LaunchedEffect(index) { scroll.scrollTo(0) }
  RelevoScreen(
    scrollState = scroll,
    title = page.title,
    onBack = if (index > 0) ({ go(index - 1) }) else onBack,
    step = "${index + 1} de ${pages.size}",
    progress = (index + 1f) / pages.size,
    trailing = if (!last) ({ PlainAction("Saltar", { go(pages.lastIndex) }, color = Relevo.colors.graphite) }) else null,
    bottom = {
      when {
        !last -> RelevoButton("Seguir", { go(index + 1) })
        onReturnNotice != null -> {
          // Las dos respuestas pesan lo mismo: ninguna viene sugerida.
          RelevoButton("Sí, quiero el aviso", { onReturnNotice(true); onContinue() }, kind = ButtonKind.Secondary)
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
        if (shown.text.isNotBlank()) {
          Spacer(Modifier.height(Gap.section))
          Text(shown.text.trim(), style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.fillMaxWidth())
        }
      }
    }
  }
}

/**
 * Primer relevo (D-090): después de registrarse, la app propone hacerlo juntos, con el primer paso de
 * la ruta que la persona eligió como ejemplo. Así la guía no solo explica: deja el primer relevo listo.
 */
@Composable
internal fun FirstRelevoScreen(
  name: String, suggestion: String?, routeTitle: String?, picture: Picture, onStart: () -> Unit, onLater: () -> Unit,
  firstStep: String = "", place: String = "",
) {
  RelevoScreen(
    title = "Primer relevo",
    subtitle = null,
    bottom = {
      RelevoButton("Preparar un relevo", onStart)
      RelevoButton("Lo hago después", onLater, kind = ButtonKind.Secondary)
    },
  ) {
    Column(Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      ActivityRing(pictureIcon(picture), 96.dp)
      Spacer(Modifier.height(12.dp))
      Text(suggestion ?: "Actividad", style = Relevo.type.title2, color = Relevo.colors.ink)
    }
    if (firstStep.isNotBlank() || place.isNotBlank()) {
      Spacer(Modifier.height(Gap.block))
      ListSection {
        if (firstStep.isNotBlank()) ListRow(firstStep.trim(), icon = KitIcon.COMENCE, overline = START_QUESTION)
        if (place.isNotBlank()) ListRow(place.trim(), icon = KitIcon.LUGAR, overline = PLACE_QUESTION)
      }
    }
  }
}

/** Marco de los ejemplos de la guía. */
@Composable
private fun GuidePanel(content: @Composable ColumnScope.() -> Unit) {
  Panel(Modifier.fillMaxWidth()) { content() }
}
