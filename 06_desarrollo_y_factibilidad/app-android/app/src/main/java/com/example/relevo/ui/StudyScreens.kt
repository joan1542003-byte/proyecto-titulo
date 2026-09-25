package com.example.relevo.ui

import androidx.activity.compose.BackHandler
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
import com.example.relevo.domain.StudyCondition
import com.example.relevo.domain.StudyPlan
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
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
internal fun StudyCards(study: StudyState, onDismissInstruction: (Int) -> Unit, onWeekReview: () -> Unit, onClosing: () -> Unit) {
  if (!study.active && !study.finished) return
  Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    if (study.initialSession) {
      Panel {
        Text("Sesión inicial de la prueba", style = Relevo.type.headline, color = Relevo.colors.ink)
        Text("Hoy preparas Relevo junto al investigador. Deja el parlante junto a lo que necesitas para empezar.", style = Relevo.type.subhead, color = Relevo.colors.ink)
      }
    }
    val week = study.instructionWeek
    val condition = study.condition
    if (week != null && condition != null) {
      Panel {
        Text("Semana $week de 3 · ${conditionName(condition)}", style = Relevo.type.headline, color = Relevo.colors.ink)
        Text(conditionInstruction(condition), style = Relevo.type.subhead, color = Relevo.colors.ink)
        conditionDetail(condition)?.let { Text(it, style = Relevo.type.footnote, color = Relevo.colors.graphite) }
        PlainAction("Cerrar", { onDismissInstruction(week) }, color = Relevo.colors.graphite)
      }
    }
    study.pendingWeek?.let { pending ->
      Panel {
        Text("Cierre de la semana $pending", style = Relevo.type.headline, color = Relevo.colors.ink)
        Text("Tres preguntas breves. Puedes omitirlas.", style = Relevo.type.subhead, color = Relevo.colors.ink)
        PlainAction("Responder", onWeekReview, icon = KitIcon.SIGUIENTE)
      }
    }
    if (study.pendingWeek == null && study.closingPending) {
      Panel {
        Text("Terminaste la prueba. Gracias.", style = Relevo.type.headline, color = Relevo.colors.ink)
        Text("Cinco preguntas breves, unos 2 minutos.", style = Relevo.type.subhead, color = Relevo.colors.ink)
        PlainAction("Responder", onClosing, icon = KitIcon.SIGUIENTE)
      }
    }
  }
  SectionGap()
}

/** Configuración de la prueba, para el investigador en la sesión inicial. */
@Composable
internal fun StudyScreen(study: StudyState, participantCode: String, onStart: (String) -> Unit, onEnd: () -> Unit, onBack: () -> Unit) {
  var sequence by rememberSaveable { mutableStateOf<String?>(null) }
  var confirmEnd by rememberSaveable { mutableStateOf(false) }
  BackHandler(onBack = onBack)
  val plan = study.plan
  RelevoScreen(
    title = "Prueba de 21 días", onBack = onBack,
    bottom = if (plan == null) ({ RelevoButton("Empezar la prueba hoy", { sequence?.let(onStart) }, enabled = sequence != null) }) else null,
  ) {
    if (plan == null) {
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
    title = "Cierre de la semana $week",
    subtitle = condition?.let(::conditionName),
    onBack = onLater, backLabel = "Después",
    bottom = {
      RelevoButton("Enviar las respuestas", { onSubmit(preparation, annoyance, place, comment) })
      PlainAction("Omitir esta semana", { onSubmit(null, null, null, "") }, color = Relevo.colors.graphite)
    },
  ) {
    Question("¿Cuánto te costó preparar Relevo esta semana?") { ScaleControl(preparation, { preparation = it }) }
    SectionGap()
    Question("¿Cuánto te molestó la señal?") { ScaleControl(annoyance, { annoyance = it }) }
    SectionGap()
    Question("¿Cuánto se relacionaba la señal con el lugar?") { ScaleControl(place, { place = it }) }
    SectionGap()
    RenglonArea("Comentario (opcional)", comment, { comment = it }, "Escribe aquí")
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
    title = "Terminaste la prueba",
    subtitle = "Gracias. Cinco preguntas breves; todas se pueden omitir.",
    onBack = onLater, backLabel = "Después",
    bottom = {
      RelevoButton("Enviar las respuestas", {
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
    RenglonArea("5. ¿Dónde quedó el parlante la mayor parte del tiempo?", speakerPlace, { speakerPlace = it }, "Ejemplo: junto a la puerta")
  }
}
