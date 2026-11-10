package com.example.relevo.ui

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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.rememberReduceMotion
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.ListSection

/** Una pantalla de la guía: un título, un ejemplo que se ve como en la app y una explicación corta. */
private class GuidePage(val key: String, val title: String, val text: String, val example: @Composable () -> Unit)

/**
 * «Cómo funciona Relevo» (D-088, D-090): para qué sirve —la intención que queda esperando mientras se usa
 * el teléfono (memoria, secciones 3 y 7)— y cómo funciona el sistema: la app, el Tag y la persona, que decide
 * (sección 11). Desde la 4.4 se abre desde Perfil y no en la primera vez, que va directo al primer relevo
 * guiado (criterio 6); el aviso semanal queda en los ajustes, apagado (D-088).
 */
@Composable
internal fun HowItWorksScreen(
  onContinue: () -> Unit,
  continueLabel: String = "Entendido",
  onBack: (() -> Unit)? = null,
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
  }
  var index by rememberSaveable { mutableIntStateOf(0) }
  var forward by remember { mutableStateOf(true) }
  val reduce = rememberReduceMotion()
  val page = pages[index.coerceIn(0, pages.lastIndex)]
  val last = index >= pages.lastIndex
  fun go(to: Int) { forward = to > index; index = to.coerceIn(0, pages.lastIndex) }
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

/** Marco de los ejemplos de la guía. */
@Composable
private fun GuidePanel(content: @Composable ColumnScope.() -> Unit) {
  Panel(Modifier.fillMaxWidth()) { content() }
}
