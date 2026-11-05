package com.example.relevo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.IconTile
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.rememberReduceMotion

private class GuideStep(val icon: KitIcon, val title: String, val text: String)

/**
 * Cómo usar el Tag, paso a paso (D-109), para un iTag redondo con un solo botón al centro, como el que se
 * usó en la prueba. Desde 1.0.0 no lleva dibujos del Tag: un dibujo podía dar una idea equivocada de cómo se
 * ve el que tiene cada persona (pedido del autor). Se abre sola la primera vez que se elige el Tag y desde
 * Perfil.
 */
private val guideSteps = listOf(
  GuideStep(KitIcon.OBJETO, "Tu Tag", "Es un llavero Bluetooth con un solo botón. En muchos modelos el botón no se ve: es el centro de la cara de arriba, y al apretarlo firme se siente un clic."),
  GuideStep(KitIcon.REPRODUCIR, "Enciéndelo", "Mantén apretado el botón 3 segundos, hasta que pite dos veces. Queda encendido: no hay que hacerlo cada vez."),
  GuideStep(KitIcon.BUSCAR, "Búscalo en Relevo", "Con el Tag cerca del teléfono, toca «Buscar el Tag» y elígelo en la lista. Va a pitar una vez para confirmarlo."),
  GuideStep(KitIcon.LUGAR, "Déjalo donde empiezas", "Ponlo junto a lo que usas para empezar, como el libro o la guitarra. Sonará ahí cuando sumes el tiempo que elegiste en tus apps."),
  GuideStep(KitIcon.SILENCIAR, "Para callarlo, un toque", "Cuando suene, toca el botón una vez. No lo mantengas apretado: así se apaga."),
  GuideStep(KitIcon.PAUSAR, "Para apagarlo", "Mantén apretado el botón 3 segundos, hasta que dé un pitido largo. Mientras uses Relevo, conviene dejarlo encendido."),
  GuideStep(KitIcon.BATERIA, "La pila dura meses", "Usa una pila de botón CR2032. Para cambiarla, abre la tapa por la ranura del borde con una uña o una moneda."),
  GuideStep(KitIcon.AYUDA, "Si no aparece o no pita", "El Tag se conecta a un solo teléfono a la vez: cierra iSearching, la app que trae el Tag, y, si lo usaste con otro teléfono, apaga el Bluetooth de ese teléfono. Si se conecta pero no pita, o si suena lento y sin parar, sácale la pila unos segundos y vuelve a ponerla."),
)

/**
 * La guía en pasos: el número y el ícono de cada paso, una frase y «Siguiente». [finishLabel] y [onFinish]
 * permiten terminar buscando el Tag cuando todavía no hay uno elegido.
 */
@Composable
internal fun TagGuideSheet(onDismiss: () -> Unit, finishLabel: String = "Entendido", onFinish: (() -> Unit)? = null) {
  var index by rememberSaveable { mutableIntStateOf(0) }
  val last = guideSteps.lastIndex
  val reduce = rememberReduceMotion()
  RelevoSheet(onDismiss = onDismiss, title = "Cómo usar el Tag", done = "Cerrar", scrollable = false) {
    AnimatedContent(
      targetState = index,
      transitionSpec = {
        val forward = targetState > initialState
        if (reduce) fadeIn() togetherWith fadeOut()
        else (slideInHorizontally { if (forward) it / 4 else -it / 4 } + fadeIn()) togetherWith (slideOutHorizontally { if (forward) -it / 4 else it / 4 } + fadeOut())
      },
      label = "tag_guide",
    ) { i ->
      val step = guideSteps[i]
      Column(Modifier.fillMaxWidth().heightIn(min = 200.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          IconTile(step.icon)
          Spacer(Modifier.width(12.dp))
          Text("Paso ${i + 1} de ${guideSteps.size}", style = Relevo.type.footnote, color = Relevo.colors.graphite)
        }
        Text(step.title, style = Relevo.type.title2, color = Relevo.colors.ink)
        Text(step.text, style = Relevo.type.body, color = Relevo.colors.graphite)
      }
    }
    Spacer(Modifier.height(12.dp))
    StepDots(index, guideSteps.size)
    Spacer(Modifier.height(18.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
      if (index > 0) RelevoButton("Atrás", { index-- }, Modifier.weight(1f), kind = ButtonKind.Secondary)
      RelevoButton(
        if (index < last) "Siguiente" else finishLabel,
        { if (index < last) index++ else { onDismiss(); onFinish?.invoke() } },
        Modifier.weight(if (index > 0) 1.6f else 1f),
      )
    }
  }
}

/** Puntos de avance: el paso actual es una cápsula de tinta. */
@Composable
private fun StepDots(current: Int, count: Int) {
  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
    repeat(count) { i ->
      Box(
        Modifier.padding(horizontal = 3.dp).height(8.dp).width(if (i == current) 22.dp else 8.dp).clip(CircleShape)
          .background(if (i == current) Relevo.colors.ink else Relevo.colors.line),
      )
    }
  }
}
