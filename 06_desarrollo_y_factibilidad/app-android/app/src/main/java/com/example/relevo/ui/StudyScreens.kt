package com.example.relevo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.relevo.domain.StudyCondition
import com.example.relevo.domain.StudyPlan
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RadioMark
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RenglonArea
import com.example.relevo.ui.components.ScaleControl
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SegmentedControl

/** Tarjetas de la prueba de 21 días en Inicio: sesión inicial, condición de la semana y cierres. */
@Composable
internal fun StudyCards(study: StudyState, onDismissInstruction: (Int) -> Unit, onWeekReview: () -> Unit, onClosing: () -> Unit, firstRelevoDone: Boolean = false) {
  if (!study.active && !study.finished) return
  val week = study.instructionWeek
  val condition = study.condition
  val closing = study.pendingWeek == null && study.closingPending
  val firstCard = study.initialSession && !firstRelevoDone
  if (!firstCard && (week == null || condition == null) && study.pendingWeek == null && !closing) return
  Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    if (firstCard) {
      StudyCard(KitIcon.VALIDACION, "Hoy", "Tu primer relevo", "Prepáralo con calma. Deja el parlante, el reloj o el Tag junto a lo que usas para empezar.")
    }
    if (week != null && condition != null) {
      StudyCard(conditionIcon(condition), "Esta semana", conditionName(condition), conditionInstruction(condition), conditionDetail(condition)) {
        PlainAction("Entendido", { onDismissInstruction(week) }, icon = KitIcon.LISTO)
      }
    }
    study.pendingWeek?.let { pending ->
      StudyCard(KitIcon.CALENDARIO, "Tu semana", "¿Cómo te fue esta semana?", "Tres preguntas de un toque.") {
        PlainAction("Responder", onWeekReview, icon = KitIcon.SIGUIENTE)
      }
    }
    if (closing) {
      StudyCard(KitIcon.LISTO, "Día 21", "¡Llegaste al día 21! Gracias.", "Cinco preguntas cortas, unos 2 minutos.") {
        PlainAction("Responder", onClosing, icon = KitIcon.SIGUIENTE)
      }
    }
  }
  SectionGap()
}

/** Tarjeta de la prueba: rótulo, icono del kit, título y qué hacer. */
@Composable
private fun StudyCard(icon: KitIcon, label: String, title: String, text: String, detail: String? = null, action: (@Composable () -> Unit)? = null) {
  Panel {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Box(Modifier.size(36.dp).clip(CircleShape).background(Relevo.colors.mist), contentAlignment = Alignment.Center) {
        RelevoIcon(icon, size = 20.dp, background = Relevo.colors.mist)
      }
      Spacer(Modifier.width(12.dp))
      Text(label, style = Relevo.type.label, color = Relevo.colors.graphite)
    }
    Text(title, style = Relevo.type.headline, color = Relevo.colors.ink)
    Text(text, style = Relevo.type.subhead, color = Relevo.colors.ink)
    detail?.let { Text(it, style = Relevo.type.footnote, color = Relevo.colors.graphite) }
    action?.invoke()
  }
}

/** Configuración de la prueba, para el investigador en la sesión inicial. */
@Composable
internal fun StudyScreen(study: StudyState, participantCode: String, participating: Boolean, onStart: (String) -> Unit, onEnd: () -> Unit, onBack: () -> Unit) {
  var sequence by rememberSaveable { mutableStateOf<String?>(null) }
  var confirmEnd by rememberSaveable { mutableStateOf(false) }
  BackHandler(onBack = onBack)
  val plan = study.plan
  RelevoScreen(
    title = "Prueba de 21 días", onBack = onBack,
    bottom = if (plan == null && participating) ({ GuardedButton("Empezar la prueba hoy", { sequence?.let(onStart) }, missing = if (sequence == null) "Elige una secuencia." else null) }) else null,
  ) {
    if (!participating) {
      Text("Para configurar la prueba, primero hay que aceptar participar.", style = Relevo.type.body, color = Relevo.colors.graphite)
    } else if (plan == null) {
      Text("Para el investigador, en la sesión inicial. Elige la secuencia asignada; hoy será el día 0.", style = Relevo.type.body, color = Relevo.colors.graphite)
      SectionGap()
      ListSection(title = "Condiciones") {
        StudyCondition.entries.forEach { ListRow("${it.code}. ${conditionName(it)}", subtitle = conditionInstruction(it)) }
      }
      SectionGap()
      ListSection(title = "Secuencia") {
        StudyPlan.SEQUENCES.forEachIndexed { index, option ->
          ListRow("Secuencia ${index + 1}", subtitle = option.toList().joinToString(" → "), onClick = { sequence = option }, trailing = { RadioMark(sequence == option) })
        }
      }
    } else {
      Text(
        when {
          study.finished -> "La prueba terminó el día 21."
          study.day == 0 -> "Hoy es la sesión inicial (día 0)."
          else -> "Día ${study.day} de 21 · semana ${study.week}: ${study.condition?.let(::conditionName)?.lowercase()}."
        },
        style = Relevo.type.title2, color = Relevo.colors.ink,
      )
      SectionGap()
      ListSection {
        ListRow("Secuencia", value = plan.sequence.toList().joinToString(" → "))
        ListRow("Día 0", value = plan.day0.toString())
        ListRow("Código de participación", value = participantCode)
      }
      Spacer(Modifier.height(10.dp))
      Text("La condición de cada semana fija dónde suena la señal. Las preguntas y las tarjetas aparecen solas.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
      SectionGap()
      if (confirmEnd) {
        RelevoButton("Terminar la prueba", { confirmEnd = false; onEnd() }, kind = ButtonKind.Destructive)
        PlainAction("Cancelar", { confirmEnd = false })
      } else {
        PlainAction("Terminar la prueba", { confirmEnd = true }, color = Relevo.colors.error)
      }
    }
  }
}

/** T1: cierre de cada semana (días 7, 14 y 21): tres escalas de 1 a 5 y un comentario opcional. */
@Composable
internal fun WeekReviewScreen(week: Int, condition: StudyCondition?, onSubmit: (Int?, Int?, Int?, String) -> Unit, onLater: () -> Unit) {
  var preparation by rememberSaveable { mutableStateOf<Int?>(null) }
  var annoyance by rememberSaveable { mutableStateOf<Int?>(null) }
  var place by rememberSaveable { mutableStateOf<Int?>(null) }
  var comment by rememberSaveable { mutableStateOf("") }
  BackHandler(onBack = onLater)
  RelevoScreen(
    title = "¿Cómo te fue esta semana?",
    subtitle = condition?.let(::conditionName),
    onBack = onLater, closeIcon = true, backLabel = "Después",
    bottom = {
      RelevoButton("Enviar", { onSubmit(preparation, annoyance, place, comment) })
      PlainAction("Saltar", { onSubmit(null, null, null, "") }, color = Relevo.colors.graphite)
    },
  ) {
    Question("¿Te costó preparar Relevo?") { ScaleControl(preparation, { preparation = it }) }
    SectionGap()
    Question("¿Te molestó el sonido?") { ScaleControl(annoyance, { annoyance = it }) }
    SectionGap()
    Question("¿El sonido tenía que ver con el lugar donde sonó?") { ScaleControl(place, { place = it }) }
    SectionGap()
    RenglonArea("¿Algo más que quieras contarnos?", comment, { comment = it }, "Escribe aquí, si quieres")
  }
}

/**
 * T2: cierre del día 21. Cinco preguntas derivadas de T2 y de los temas del protocolo 02
 * (D-080, pendientes de revisión del autor). La entrevista la acuerda el investigador.
 */
@Composable
internal fun ClosingScreen(onSubmit: (Map<String, String>) -> Unit, onLater: () -> Unit) {
  var continueUsing by rememberSaveable { mutableStateOf<String?>(null) }
  var helpedMost by rememberSaveable { mutableStateOf<String?>(null) }
  var bothered by rememberSaveable { mutableStateOf("") }
  var change by rememberSaveable { mutableStateOf("") }
  var speakerPlace by rememberSaveable { mutableStateOf("") }
  BackHandler(onBack = onLater)
  RelevoScreen(
    title = "¡Terminaste los 21 días!",
    subtitle = "Gracias. Cinco preguntas cortas; puedes saltar las que quieras.",
    onBack = onLater, closeIcon = true, backLabel = "Después",
    bottom = {
      RelevoButton("Enviar", {
        onSubmit(mapOf(
          "seguiria_usando" to continueUsing.orEmpty(),
          "semana_que_ayudo" to helpedMost.orEmpty(),
          "que_molesto" to bothered,
          "que_cambiaria" to change,
          "lugar_parlante" to speakerPlace,
        ))
      })
    },
  ) {
    Question("1. ¿Seguirías usando Relevo?") {
      SegmentedControl(listOf("si" to "Sí", "tal_vez" to "Tal vez", "no" to "No"), continueUsing, { continueUsing = it })
    }
    SectionGap()
    Question("2. ¿Qué semana te ayudó más?") {
      ListSection {
        (StudyCondition.entries.map { it.code.toString() to conditionName(it) } + ("ninguna" to "Ninguna")).forEach { (value, label) ->
          ListRow(label, onClick = { helpedMost = if (helpedMost == value) null else value }, trailing = { RadioMark(helpedMost == value) })
        }
      }
    }
    SectionGap()
    RenglonArea("3. ¿Qué te molestó?", bothered, { bothered = it }, "Escribe aquí")
    SectionGap()
    RenglonArea("4. ¿Qué cambiarías?", change, { change = it }, "Escribe aquí")
    SectionGap()
    RenglonArea("5. ¿Dónde quedó lo que sonaba la mayor parte del tiempo?", speakerPlace, { speakerPlace = it }, "Ejemplo: junto a la puerta")
  }
}
