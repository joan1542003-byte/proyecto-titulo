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
import androidx.compose.runtime.remember
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
import com.example.relevo.domain.StudyCondition
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.KitIcon
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
import com.example.relevo.ui.components.SoundRings
import androidx.compose.foundation.layout.size
import com.example.relevo.ui.components.SkyBackground
import com.example.relevo.ui.components.Sky
import com.example.relevo.ui.components.skyFor
import com.example.relevo.ui.components.pictureIcon
import com.example.relevo.ui.components.StatusBarTone
import com.example.relevo.ui.components.pressScale
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.clickable
import androidx.compose.ui.semantics.Role
import androidx.compose.foundation.layout.fillMaxWidth
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
  guided: Boolean = false,
) {
  val sounding = reminder.signalDelivered && !reminder.signalEnded
  var tested by rememberSaveable { mutableStateOf<Boolean?>(null) }
  val picture = activityPicture(reminder.activity, customActivities)
  RelevoScreen(
    // El momento de más color (D-103): la pantalla toma el cielo de la actividad, y el sonido se dibuja en
    // anillos de tinta alrededor de su ícono, sin luz (D-121). El mensaje va en una tarjeta blanca.
    backdrop = {
      val sky = skyFor(pictureIcon(picture))
      SkyBackground(sky, Modifier.fillMaxSize())
      StatusBarTone(darkBackground = sky == Sky.NOCHE)
      Box(Modifier.fillMaxWidth().statusBarsPadding().padding(top = 72.dp).height(200.dp), contentAlignment = Alignment.Center) {
        if (sounding) SoundRings(Modifier.size(112.dp))
        Box(Modifier.size(112.dp).clip(CircleShape).background(androidx.compose.ui.graphics.Color.White.copy(alpha = .94f)), contentAlignment = Alignment.Center) {
          RelevoIcon(pictureIcon(picture), size = 50.dp, tint = Relevo.colors.onTile, background = androidx.compose.ui.graphics.Color.White)
        }
      }
    },
    bottom = { RelevoButton(if (sounding) "Silenciar y continuar" else "Continuar", onContinue, icon = if (sounding) KitIcon.SILENCIAR else null) },
  ) {
    Spacer(Modifier.height(232.dp))
    Column(Modifier.fillMaxWidth().clip(Relevo.panelShape).background(Relevo.colors.card.copy(alpha = .96f)).padding(20.dp)) {
    if (guided) {
      GuideTip("Así suena Relevo. Toca «Silenciar y continuar» y después cuéntanos qué hiciste.")
      Spacer(Modifier.height(16.dp))
    }
    Box(Modifier.appear(0)) {
      when {
        !reminder.signalDelivered -> StatusChip(KitIcon.ERROR, "No sonó")
        sounding -> SoundingChip(reminder.signalRoute)
        else -> StatusChip(KitIcon.LISTO, "Ya dejó de sonar")
      }
    }
    if (sounding && reminder.signalRoute == SignalRoute.TAG) {
      Spacer(Modifier.height(8.dp))
      Text("Para callarlo en el Tag, toca su botón una vez.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
    Spacer(Modifier.height(18.dp))
    Text("Es momento de volver a elegir", style = Relevo.type.title2, color = Relevo.colors.graphite, modifier = Modifier.appear(1))
    Spacer(Modifier.height(10.dp))
    Signature(reminder.activity)
    // Una frase en vez de rótulos: cómo empezar y dónde (D-084). En la semana del parlante en otro lugar, el lugar no es el del comienzo.
    val neutral = StudyCondition.fromCode(reminder.studyCondition.firstOrNull() ?: ' ') == StudyCondition.NEUTRAL
    startSentence(reminder.howToStart, if (neutral) "" else reminder.place)?.let {
      Spacer(Modifier.height(14.dp))
      Text(it, style = Relevo.type.title2.copy(fontWeight = FontWeight.Normal), color = Relevo.colors.ink, modifier = Modifier.appear(2))
    }
    if (!reminder.signalDelivered) {
      SectionGap()
      // Solo se ofrece el teléfono cuando se puede usar: durante la prueba, la semana decide dónde suena.
      Notice(
        routeFailure(reminder.signalRoute) + if (!studyActive && reminder.signalRoute != SignalRoute.PHONE) " También puedes hacerlo sonar en el teléfono." else "",
        title = "Se cumplió el tiempo", tone = Tone.Error,
      ) {
        PlainAction("Probar otra vez", { tested = onTestSound(null) }, icon = KitIcon.PROBAR)
        if (!studyActive && reminder.signalRoute != SignalRoute.PHONE) PlainAction("Sonar en el teléfono", { tested = onTestSound(SignalRoute.PHONE) }, icon = KitIcon.TELEFONO)
        tested?.let { Text(if (it) "Ahora sonó." else "Todavía no suena.", style = Relevo.type.subhead, color = Relevo.colors.graphite) }
      }
    }
    }
  }
}

/** Estado mientras suena: el icono respira despacio; sin ondas ni destellos. */
@Composable
private fun SoundingChip(route: SignalRoute) {
  val reduce = rememberReduceMotion()
  val pulse by rememberInfiniteTransition(label = "sounding").animateFloat(
    initialValue = 1f, targetValue = if (reduce) 1f else .35f,
    animationSpec = infiniteRepeatable(tween(900), RepeatMode.Reverse), label = "sounding_alpha",
  )
  val colors = Relevo.colors
  Row(Modifier.background(colors.mist, Relevo.controlShape).padding(horizontal = 12.dp, vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
    Box(Modifier.graphicsLayer { alpha = pulse }) { RelevoIcon(routeIcon(route), size = 16.dp, background = colors.mist) }
    Spacer(Modifier.width(8.dp))
    Text("Suena en " + routeName(route).replaceFirstChar { it.lowercase() }, style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold), color = colors.ink)
  }
}

/**
 * B5. Si sonó, antes de «¿Qué decidiste?» van dos preguntas de un toque (protocolo 02) y, desde 2.12,
 * cómo le cayó el aviso, con tres caras. Desde 2.12 se preguntan siempre que suena, esté o no
 * configurada la prueba. Las tres respuestas tienen el mismo tamaño, color y lugar; todo se puede saltar.
 */
@Composable
internal fun DecideScreen(reminder: Reminder, customActivities: List<CustomActivity>, askSignalQuestions: Boolean, guided: Boolean = false, onAnswer: (String, String?, String?, String?) -> Unit) {
  var knew by rememberSaveable { mutableStateOf<String?>(null) }
  var recalled by rememberSaveable { mutableStateOf<String?>(null) }
  var feeling by rememberSaveable { mutableStateOf<String?>(null) }
  // Al responder, el relevo se reinicia mientras la pantalla todavía sale; se sigue mostrando el último
  // relevo con actividad para no dejar ver «Vuelve a .» vacío (defecto de 2.10).
  val lastShown = remember { arrayOf(reminder) }
  val lastFlags = remember { booleanArrayOf(askSignalQuestions, guided) }
  if (reminder.activity.isNotBlank()) { lastShown[0] = reminder; lastFlags[0] = askSignalQuestions; lastFlags[1] = guided }
  val shownReminder = lastShown[0]
  val ask = lastFlags[0]
  val showTip = lastFlags[1]
  fun finish(outcome: String) = onAnswer(outcome, knew.takeIf { ask }, recalled.takeIf { ask }, feeling.takeIf { ask })
  RelevoScreen(
    bottom = { PlainAction("Saltar", { finish("not_answered") }, color = Relevo.colors.graphite) },
  ) {
    Spacer(Modifier.height(8.dp))
    if (showTip) {
      GuideTip("Responde lo que pasó de verdad. No hay respuestas buenas ni malas; todas nos ayudan a mejorar Relevo.")
      Spacer(Modifier.height(16.dp))
    }
    Text("Después de la señal", style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold), color = Relevo.colors.onTile,
      modifier = Modifier.background(Relevo.colors.peach, Relevo.controlShape).padding(horizontal = 12.dp, vertical = 5.dp))
    Spacer(Modifier.height(14.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
      PictureContent(activityPicture(shownReminder.activity, customActivities), Modifier.size(64.dp).clip(RoundedCornerShape(18.dp)), iconSize = 24.dp)
      Spacer(Modifier.width(16.dp))
      Column(Modifier.weight(1f)) {
        Text(
          if (shownReminder.signalAt > 0L) "Sonó ${if (shownReminder.signalRoute == SignalRoute.PHONE) "en el teléfono" else placePhrase(shownReminder.place)}."
          else "Desactivaste el relevo.",
          style = Relevo.type.subhead, color = Relevo.colors.graphite,
        )
        Signature(shownReminder.activity, style = Relevo.type.headline.copy(fontSize = Relevo.type.title2.fontSize, lineHeight = Relevo.type.title2.lineHeight), animate = false)
      }
    }
    if (ask) {
      SectionGap()
      Question("¿Cómo te cayó el sonido?") {
        FacePicker(feelingFaces, feeling, { feeling = it })
      }
      SectionGap()
      Question("Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla?") {
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
    // Las tres respuestas pesan lo mismo: misma tarjeta, mismo color de ficha (lo que decides) y mismo tamaño.
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      DecisionRow("Comencé la actividad", KitIcon.COMENCE) { finish("started") }
      DecisionRow("La dejé para después", KitIcon.DESPUES) { finish("later") }
      DecisionRow("Cambié de idea", KitIcon.CAMBIE) { finish("changed") }
    }
  }
}

/** Una respuesta a «¿Qué decidiste?»: tarjeta blanca con su ficha rubor y un toque para responder. */
@Composable
private fun DecisionRow(label: String, icon: KitIcon, onClick: () -> Unit) {
  val colors = Relevo.colors
  val interaction = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }
  Row(
    Modifier.fillMaxWidth().heightIn(min = 64.dp).pressScale(interaction, 0.98f).clip(RoundedCornerShape(20.dp)).background(colors.card)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .padding(start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Box(Modifier.size(40.dp).clip(RoundedCornerShape(12.dp)).background(colors.blush), contentAlignment = Alignment.Center) {
      RelevoIcon(icon, size = 24.dp, tint = colors.onTile, background = colors.blush)
    }
    Spacer(Modifier.width(14.dp))
    Text(label, style = Relevo.type.callout.copy(fontWeight = FontWeight.SemiBold), color = colors.ink, modifier = Modifier.weight(1f))
    RelevoIcon(KitIcon.SIGUIENTE, size = 18.dp, tint = colors.graphite, background = colors.card)
  }
}

@Composable
internal fun Question(text: String, content: @Composable () -> Unit) {
  Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    Text(text, style = Relevo.type.headline, color = Relevo.colors.ink)
    content()
  }
}
