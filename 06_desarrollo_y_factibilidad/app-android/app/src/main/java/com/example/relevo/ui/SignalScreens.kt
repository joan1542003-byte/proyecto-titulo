package com.example.relevo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.relevo.data.CustomActivity
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.SignalRoute
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.Chip
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.GlassCard
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.OptionRow
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SegmentedControl
import com.example.relevo.ui.components.Sky
import com.example.relevo.ui.components.SkyBackground
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.SoundObject
import com.example.relevo.ui.components.StatusBarTone
import com.example.relevo.ui.components.StatusChip
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.pictureIcon
import com.example.relevo.ui.components.skyFor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * B4 (lámina «Suena»): la pantalla toma el cielo de la actividad, el momento de más color (D-103). Al
 * centro, lo que suena; si es el Tag, el sonido se dibuja en anillos de tinta, sin luz (D-121). Abajo, el
 * mensaje en una tarjeta de vidrio claro con la acción de silenciar. La señal termina sola a los 30 s
 * (D-078). Si no sonó, lo dice y ofrece probar (E1). Si el Tag no respondió y sonó el teléfono, lo dice (4.4).
 */
@Composable
internal fun SignalScreen(
  reminder: Reminder,
  customActivities: List<CustomActivity>,
  onTestSound: (SignalRoute?) -> Boolean,
  onContinue: () -> Unit,
) {
  val sounding = reminder.signalDelivered && !reminder.signalEnded
  var tested by rememberSaveable { mutableStateOf<Boolean?>(null) }
  val icon = pictureIcon(activityPicture(reminder.activity, customActivities))
  val sky = skyFor(icon)
  val colors = Relevo.colors
  // Con qué sonó de verdad: el teléfono, si el Tag no respondió (4.4).
  val soundedOn = if (reminder.soundedOnPhone) SignalRoute.PHONE else reminder.signalRoute
  Box(Modifier.fillMaxSize()) {
    SkyBackground(sky, Modifier.fillMaxSize(), variant = activityVariant(reminder.activity))
    StatusBarTone(darkBackground = sky == Sky.NOCHE)
    BoxWithConstraints(Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding()) {
      Column(
        Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).heightIn(min = maxHeight).padding(horizontal = 20.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Spacer(Modifier.height(8.dp))
        Box(Modifier.padding(vertical = 56.dp).appear(0), contentAlignment = Alignment.Center) {
          // Sin dibujo del Tag (4.4): el ícono de con qué suena, como las otras salidas.
          SoundObject(routeIcon(soundedOn), size = 112.dp, sounding = sounding)
        }
        GlassCard(Modifier.appear(1), padding = 20.dp) {
          Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            when {
              !reminder.signalDelivered -> StatusChip(KitIcon.ERROR, "No sonó")
              sounding -> Chip("Suena " + routeWhere(soundedOn))
              else -> Chip("Ya dejó de sonar")
            }
          }
          Text(
            "Es momento de volver a elegir", style = Relevo.type.title.copy(fontSize = 26.sp, lineHeight = 30.sp), color = colors.ink,
            textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(),
          )
          Text(
            listOfNotNull(reminder.activity.trim().trimEnd('.').takeIf { it.isNotEmpty() }?.let { "$it." }, startLine(reminder.howToStart, reminder.place))
              .joinToString(" "),
            style = Relevo.type.callout, color = colors.graphite, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(),
          )
          if (reminder.soundedOnPhone) {
            Text("El Tag no respondió; sonó en tu teléfono.", style = Relevo.type.footnote, color = colors.graphite, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
          }
          if (!reminder.signalDelivered) {
            Notice(
              routeFailure(reminder.signalRoute),
              title = "Se cumplió el tiempo", tone = Tone.Error,
            ) {
              PlainAction("Probar otra vez", { tested = onTestSound(null) }, icon = KitIcon.PROBAR)
              if (reminder.signalRoute != SignalRoute.PHONE) PlainAction("Sonar en el teléfono", { tested = onTestSound(SignalRoute.PHONE) }, icon = KitIcon.TELEFONO)
              tested?.let { Text(if (it) "Ahora sonó." else "Tampoco sonó.", style = Relevo.type.subhead, color = colors.graphite) }
            }
          }
          Spacer(Modifier.height(2.dp))
          RelevoButton(if (sounding) "Silenciar y continuar" else "Continuar", onContinue, icon = if (sounding) KitIcon.SILENCIAR else null)
          if (sounding && soundedOn == SignalRoute.TAG) {
            Text("Un toque al botón del Tag también lo calla.", style = Relevo.type.footnote, color = colors.ink, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
          }
        }
      }
    }
  }
}

/**
 * B5. Si sonó, primero van cuatro preguntas de un toque (protocolo 02; la primera, desde la 3.3) y después
 * «¿Qué decidiste?», como en las láminas «Tres preguntas» y «¿Qué decidiste?». Las tres respuestas tienen el mismo tamaño, color y
 * lugar; tocar una la marca y termina. Todo se puede saltar. Desde la 4.4, «La dejé para después» pregunta
 * si se deja lista: queda en Inicio para activarla con un toque y no suena sola (Tabla 4 de la memoria).
 */
@Composable
internal fun DecideScreen(
  reminder: Reminder,
  customActivities: List<CustomActivity>,
  askSignalQuestions: Boolean,
  onAnswer: (outcome: String, knew: String?, recalled: String?, feeling: String?, noticed: String?, keepForLater: Boolean) -> Unit,
) {
  var noticed by rememberSaveable { mutableStateOf<String?>(null) }
  var knew by rememberSaveable { mutableStateOf<String?>(null) }
  var recalled by rememberSaveable { mutableStateOf<String?>(null) }
  var feeling by rememberSaveable { mutableStateOf<String?>(null) }
  var chosen by rememberSaveable { mutableStateOf<String?>(null) }
  // Al responder, el relevo se reinicia mientras la pantalla todavía sale; se sigue mostrando el último
  // relevo con actividad para no dejar ver «Vuelve a .» vacío (defecto de 2.10).
  val lastShown = remember { arrayOf(reminder) }
  val lastFlags = remember { booleanArrayOf(askSignalQuestions) }
  if (reminder.activity.isNotBlank()) { lastShown[0] = reminder; lastFlags[0] = askSignalQuestions }
  val shownReminder = lastShown[0]
  val ask = lastFlags[0]
  var phase by rememberSaveable { mutableIntStateOf(if (askSignalQuestions) 0 else 1) }
  val scope = rememberCoroutineScope()
  val colors = Relevo.colors
  fun finish(outcome: String, keep: Boolean = false) = onAnswer(outcome, knew.takeIf { ask }, recalled.takeIf { ask }, feeling.takeIf { ask }, noticed.takeIf { ask }, keep)
  fun choose(outcome: String) {
    if (chosen != null) return
    chosen = outcome
    scope.launch { delay(280); if (outcome == "later") phase = 2 else finish(outcome) }
  }
  BackHandler(enabled = (ask && phase == 1 && chosen == null) || phase == 2) { if (phase == 2) { chosen = null; phase = 1 } else phase = 0 }
  RelevoScreen(
    leading = { Chip("Después de la señal", background = colors.mist) },
    trailing = { if (phase != 2) PlainAction("Saltar", { finish("not_answered") }, color = colors.graphite) },
    title = when (phase) { 0 -> "Cuatro preguntas de un toque"; 2 -> "¿La dejas lista para después?"; else -> null },
    subtitle = if (phase == 2) "Queda en Inicio para activarla con un toque. No sonará sola." else null,
    bottom = when (phase) {
      0 -> ({ RelevoButton("Seguir", { phase = 1 }) })
      // Las dos respuestas pesan lo mismo.
      2 -> ({
        RelevoButton("Dejarla lista", { finish("later", keep = true) }, kind = ButtonKind.Secondary)
        RelevoButton("No, gracias", { finish("later") }, kind = ButtonKind.Secondary)
      })
      else -> null
    },
  ) {
    if (phase == 2) {
      Column(Modifier.fillMaxWidth().padding(top = 12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        ActivityRing(pictureIcon(activityPicture(shownReminder.activity, customActivities)), 88.dp)
        Spacer(Modifier.height(16.dp))
        Text(shownReminder.activity.trim(), style = Relevo.type.title, color = colors.ink, textAlign = TextAlign.Center)
      }
    } else if (phase == 0) {
      // Percibir la señal es el primer paso para recordar (protocolo 02); compara el teléfono con el objeto (2.33).
      Question("¿Notaste el aviso apenas sonó?") {
        SegmentedControl(listOf("enseguida" to "Enseguida", "tarde" to "Un rato después", "no" to "No lo noté"), noticed, { noticed = it })
      }
      Spacer(Modifier.height(Gap.section))
      Question("¿Cómo te cayó el sonido?") { FacePicker(feelingFaces, feeling, { feeling = it }) }
      Spacer(Modifier.height(Gap.section))
      Question("Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla?") {
        SegmentedControl(listOf("yes" to "Sí", "partly" to "A medias", "no" to "No"), knew, { knew = it })
      }
      Spacer(Modifier.height(Gap.section))
      Question("¿Recordaste cómo empezar?") {
        SegmentedControl(listOf("yes" to "Sí", "no" to "No"), recalled, { recalled = it })
      }
    } else {
      val icon = pictureIcon(activityPicture(shownReminder.activity, customActivities))
      Column(Modifier.fillMaxWidth().padding(top = 12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        ActivityRing(icon, 88.dp)
        Spacer(Modifier.height(16.dp))
        Text(shownReminder.activity.trim(), style = Relevo.type.title, color = colors.ink, textAlign = TextAlign.Center)
        Spacer(Modifier.height(6.dp))
        Text(
          if (shownReminder.signalAt > 0L) "Sonó ${if (shownReminder.soundedOnPhone || shownReminder.signalRoute == SignalRoute.PHONE) "en tu teléfono" else placePhrase(shownReminder.place)}."
          else "Desactivaste el relevo.",
          style = Relevo.type.subhead, color = colors.graphite, textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(22.dp))
        Text("¿Qué decidiste?", style = Relevo.type.title2.copy(fontWeight = FontWeight.Medium), color = colors.ink, textAlign = TextAlign.Center)
        // Criterio 4 de la memoria: las tres respuestas valen lo mismo. Se dice siempre, no solo la primera vez.
        Spacer(Modifier.height(4.dp))
        Text("Ninguna respuesta es mejor que otra.", style = Relevo.type.subhead, color = colors.graphite, textAlign = TextAlign.Center)
      }
      Spacer(Modifier.height(Gap.block))
      // Las tres respuestas pesan lo mismo: misma tarjeta, mismo ícono en tinta y mismo tamaño.
      Column(verticalArrangement = Arrangement.spacedBy(Gap.list)) {
        OptionRow("Comencé la actividad", chosen == "started", { choose("started") }, icon = KitIcon.COMENCE, haptic = HapticFeedbackType.Confirm)
        OptionRow("La dejé para después", chosen == "later", { choose("later") }, icon = KitIcon.DESPUES, haptic = HapticFeedbackType.Confirm)
        OptionRow("Cambié de idea", chosen == "changed", { choose("changed") }, icon = KitIcon.CAMBIE, haptic = HapticFeedbackType.Confirm)
      }
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
