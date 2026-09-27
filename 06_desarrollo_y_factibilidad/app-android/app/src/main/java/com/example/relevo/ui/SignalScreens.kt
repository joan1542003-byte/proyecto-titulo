package com.example.relevo.ui

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.SignalRoute
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.PictureContent
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SegmentedControl
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.StatusChip
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.rememberReduceMotion

/**
 * B4. Mientras suena, la acción es silenciar. La señal termina sola a los 30 s (D-078) y la
 * pantalla queda en silencio hasta que la persona responde. Si no sonó, lo dice y ofrece probar (E1).
 */
@Composable
internal fun SignalScreen(
  reminder: Reminder,
  customActivities: List<CustomActivity>,
  studyActive: Boolean,
  onTestSound: (SignalRoute?) -> Boolean,
  onContinue: () -> Unit,
) {
  val sounding = reminder.signalDelivered && !reminder.signalEnded
  var tested by rememberSaveable { mutableStateOf<Boolean?>(null) }
  RelevoScreen(
    hero = { PictureContent(activityPicture(reminder.activity, customActivities), Modifier.fillMaxSize(), iconSize = 64.dp, wide = true) },
    heroHeight = 320.dp,
    bottom = { RelevoButton(if (sounding) "Silenciar y continuar" else "Continuar", onContinue, icon = if (sounding) KitIcon.SILENCIAR else null) },
  ) {
    Spacer(Modifier.height(22.dp))
    Box(Modifier.appear(0)) {
      when {
        !reminder.signalDelivered -> StatusChip(KitIcon.ERROR, "No sonó")
        sounding -> SoundingChip(reminder.signalRoute == SignalRoute.PHONE)
        else -> StatusChip(KitIcon.LISTO, "La señal terminó")
      }
    }
    Spacer(Modifier.height(18.dp))
    Text("Es momento de volver a elegir", style = Relevo.type.title2, color = Relevo.colors.graphite, modifier = Modifier.appear(1))
    Spacer(Modifier.height(10.dp))
    Signature(reminder.activity)
    SectionGap()
    ListSection(modifier = Modifier.appear(2)) {
      FactRow(KitIcon.PRIMER_PASO, "Empiezas", reminder.howToStart)
      FactRow(KitIcon.LUGAR, "Está", placePhrase(reminder.place).replaceFirstChar { it.uppercase() })
    }
    if (!reminder.signalDelivered) {
      SectionGap()
      Notice(
        if (reminder.signalRoute == SignalRoute.BLUETOOTH) "No sonó en el parlante. Revisa que esté encendido o elige el teléfono." else "No sonó en el teléfono. Revisa el volumen.",
        title = "Se cumplió el tiempo", tone = Tone.Error,
      ) {
        PlainAction("Probar otra vez", { tested = onTestSound(null) }, icon = KitIcon.PROBAR)
        if (!studyActive && reminder.signalRoute == SignalRoute.BLUETOOTH) PlainAction("Sonar en el teléfono", { tested = onTestSound(SignalRoute.PHONE) }, icon = KitIcon.TELEFONO)
        tested?.let { Text(if (it) "Ahora sonó." else "Todavía no suena.", style = Relevo.type.subhead, color = Relevo.colors.graphite) }
      }
    }
  }
}

/** Estado mientras suena: el icono respira despacio; sin ondas ni destellos. */
@Composable
private fun SoundingChip(phone: Boolean) {
  val reduce = rememberReduceMotion()
  val pulse by rememberInfiniteTransition(label = "sounding").animateFloat(
    initialValue = 1f, targetValue = if (reduce) 1f else .35f,
    animationSpec = infiniteRepeatable(tween(900), RepeatMode.Reverse), label = "sounding_alpha",
  )
  val colors = Relevo.colors
  Row(Modifier.background(colors.mist, Relevo.controlShape).padding(horizontal = 12.dp, vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
    Box(Modifier.graphicsLayer { alpha = pulse }) { RelevoIcon(if (phone) KitIcon.TELEFONO else KitIcon.PARLANTE, size = 16.dp, background = colors.mist) }
    Spacer(Modifier.width(8.dp))
    Text(if (phone) "Suena en el teléfono" else "Suena en el parlante", style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold), color = colors.ink)
  }
}

/**
 * B5. Durante la prueba, antes de «¿Qué decidiste?», dos preguntas de un toque sobre la señal
 * (protocolo 02). Las tres respuestas tienen el mismo tamaño, color y lugar; todo se puede omitir.
 */
@Composable
internal fun DecideScreen(reminder: Reminder, customActivities: List<CustomActivity>, askSignalQuestions: Boolean, onAnswer: (String, String?, String?) -> Unit) {
  var knew by rememberSaveable { mutableStateOf<String?>(null) }
  var recalled by rememberSaveable { mutableStateOf<String?>(null) }
  fun finish(outcome: String) = onAnswer(outcome, knew.takeIf { askSignalQuestions }, recalled.takeIf { askSignalQuestions })
  RelevoScreen(
    bottom = { PlainAction("Omitir", { finish("not_answered") }, color = Relevo.colors.graphite) },
  ) {
    Spacer(Modifier.height(8.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
      PictureContent(activityPicture(reminder.activity, customActivities), Modifier.size(64.dp).clip(CircleShape), iconSize = 26.dp)
      Spacer(Modifier.width(16.dp))
      Column(Modifier.weight(1f)) {
        Text(
          if (reminder.signalAt > 0L) "Sonó ${if (reminder.signalRoute == SignalRoute.PHONE) "en el teléfono" else placePhrase(reminder.place)}."
          else "Desactivaste el relevo.",
          style = Relevo.type.subhead, color = Relevo.colors.graphite,
        )
        Signature(reminder.activity, style = Relevo.type.headline.copy(fontSize = Relevo.type.title2.fontSize, lineHeight = Relevo.type.title2.lineHeight), animate = false)
      }
    }
    if (askSignalQuestions) {
      SectionGap()
      Question("Cuando sonó, ¿supiste qué querías hacer antes de mirar el teléfono?") {
        SegmentedControl(listOf("yes" to "Sí", "partly" to "A medias", "no" to "No"), knew, { knew = it })
      }
      SectionGap()
      Question("¿Recordaste cómo empezar?") {
        SegmentedControl(listOf("yes" to "Sí", "no" to "No"), recalled, { recalled = it })
      }
    }
    SectionGap()
    Text("¿Qué decidiste?", style = Relevo.type.largeTitle, color = Relevo.colors.ink)
    Spacer(Modifier.height(18.dp))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      RelevoButton("Comencé la actividad", { finish("started") }, kind = ButtonKind.Secondary, icon = KitIcon.COMENCE)
      RelevoButton("La dejé para después", { finish("later") }, kind = ButtonKind.Secondary, icon = KitIcon.DESPUES)
      RelevoButton("Cambié de idea", { finish("changed") }, kind = ButtonKind.Secondary, icon = KitIcon.CAMBIE)
    }
  }
}

@Composable
internal fun Question(text: String, content: @Composable () -> Unit) {
  Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    Text(text, style = Relevo.type.headline, color = Relevo.colors.ink)
    content()
  }
}
