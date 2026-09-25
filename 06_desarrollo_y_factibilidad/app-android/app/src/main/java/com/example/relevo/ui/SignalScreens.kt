package com.example.relevo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.SignalRoute
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SegmentedControl
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.StatusChip
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.Wordmark

/**
 * B4. Mientras suena, la acción es silenciar. La señal termina sola a los 30 s (D-078) y la
 * pantalla queda en silencio hasta que la persona responde. Si no sonó, lo dice (E1).
 */
@Composable
internal fun SignalScreen(reminder: Reminder, onTestSound: () -> Boolean, onContinue: () -> Unit) {
  val sounding = reminder.signalDelivered && !reminder.signalEnded
  var tested by rememberSaveable { mutableStateOf<Boolean?>(null) }
  RelevoScreen(
    leading = { Wordmark(height = 24.dp) },
    bottom = { RelevoButton(if (sounding) "Silenciar y continuar" else "Continuar", onContinue, icon = if (sounding) KitIcon.SILENCIAR else null) },
  ) {
    Spacer(Modifier.height(8.dp))
    when {
      !reminder.signalDelivered -> Notice(
        if (reminder.signalRoute == SignalRoute.BLUETOOTH) "No sonó en el parlante. Revisa que esté encendido y conectado." else "No sonó en el teléfono. Revisa el volumen.",
        title = "Se cumplió el tiempo", tone = Tone.Error,
      ) {
        PlainAction("Probar otra vez", { tested = onTestSound() }, icon = KitIcon.PROBAR)
        tested?.let { Text(if (it) "Ahora sonó." else "Todavía no suena.", style = Relevo.type.subhead, color = Relevo.colors.graphite) }
      }
      sounding -> StatusChip(KitIcon.PROBAR, if (reminder.signalRoute == SignalRoute.PHONE) "Suena en el teléfono" else "Suena en el parlante")
      else -> StatusChip(KitIcon.LISTO, "La señal terminó")
    }
    Spacer(Modifier.height(24.dp))
    Text("Es momento de volver a elegir", style = Relevo.type.title2, color = Relevo.colors.graphite)
    Spacer(Modifier.height(10.dp))
    Signature(reminder.activity)
    SectionGap()
    ListSection {
      FactRow(KitIcon.PRIMER_PASO, "Empiezas", reminder.howToStart)
      FactRow(KitIcon.LUGAR, "Está", placePhrase(reminder.place).replaceFirstChar { it.uppercase() })
    }
  }
}

/**
 * B5. Durante la prueba, antes de «¿Qué decidiste?», dos preguntas de un toque sobre la señal
 * (protocolo 02). Las tres respuestas tienen el mismo tamaño, color y lugar; todo se puede omitir.
 */
@Composable
internal fun DecideScreen(reminder: Reminder, askSignalQuestions: Boolean, onAnswer: (String, String?, String?) -> Unit) {
  var knew by rememberSaveable { mutableStateOf<String?>(null) }
  var recalled by rememberSaveable { mutableStateOf<String?>(null) }
  fun finish(outcome: String) = onAnswer(outcome, knew.takeIf { askSignalQuestions }, recalled.takeIf { askSignalQuestions })
  RelevoScreen(
    leading = { Wordmark(height = 24.dp) },
    bottom = { PlainAction("Omitir", { finish("not_answered") }, color = Relevo.colors.graphite) },
  ) {
    Spacer(Modifier.height(8.dp))
    Text(
      if (reminder.signalAt > 0L) "Sonó ${if (reminder.signalRoute == SignalRoute.PHONE) "en el teléfono" else placePhrase(reminder.place)}."
      else "Desactivaste el relevo.",
      style = Relevo.type.body, color = Relevo.colors.graphite,
    )
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
    Text("¿Qué decidiste?", style = Relevo.type.title, color = Relevo.colors.ink)
    Spacer(Modifier.height(16.dp))
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
