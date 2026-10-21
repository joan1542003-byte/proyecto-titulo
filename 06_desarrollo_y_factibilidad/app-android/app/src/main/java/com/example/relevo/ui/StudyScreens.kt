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
      if (pending == 0) {
        StudyCard(KitIcon.CALENDARIO, "Antes de esta semana", "¿Cómo te fue hasta ahora?", "Tres preguntas de un toque sobre las semanas anteriores, con el objeto que ya usabas.") {
          PlainAction("Responder", onWeekReview, icon = KitIcon.SIGUIENTE)
        }
      } else {
        StudyCard(KitIcon.CALENDARIO, "Tu semana", "¿Cómo te fue esta semana?", if (study.comparison) "Cuatro preguntas de un toque." else "Tres preguntas de un toque.") {
          PlainAction("Responder", onWeekReview, icon = KitIcon.SIGUIENTE)
        }
      }
    }
    if (closing) {
      StudyCard(KitIcon.LISTO, if (study.comparison) "Cierre" else "Día 21", if (study.comparison) "Terminaste la prueba. Gracias." else "¡Llegaste al día 21! Gracias.", if (study.comparison) "Siete preguntas cortas, unos 3 minutos." else "Cinco preguntas cortas, unos 2 minutos.") {
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
  val single = sequence in StudyPlan.COMPARISONS
  var confirmEnd by rememberSaveable { mutableStateOf(false) }
  BackHandler(onBack = onBack)
  val plan = study.plan
  RelevoScreen(
    title = "Prueba de 21 días", onBack = onBack,
    bottom = if (plan == null && participating) ({ GuardedButton(if (single) "Empezar la semana hoy" else "Empezar la prueba hoy", { sequence?.let(onStart) }, missing = if (sequence == null) "Elige una secuencia o una semana." else null) }) else null,
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
      SectionGap()
      // Una semana con una sola condición, para comparar con lo que la persona ya venía usando (2.33, D-138).
      ListSection(title = "Una semana para comparar") {
        StudyPlan.COMPARISONS.forEach { option ->
          val condition = StudyCondition.fromCode(option[0])!!
          ListRow("Semana ${option}: ${conditionName(condition).lowercase()}", subtitle = "Empieza hoy (día 1) y dura 7 días. Antes, pregunta por las semanas anteriores.", onClick = { sequence = option }, trailing = { RadioMark(sequence == option) })
        }
      }
    } else {
      Text(
        when {
          study.finished -> if (study.comparison) "La semana de comparación terminó." else "La prueba terminó el día 21."
          study.day == 0 -> "Hoy es la sesión inicial (día 0)."
          study.comparison -> "Día ${study.day} de 7 · semana de comparación: ${study.condition?.let(::conditionName)?.lowercase()}."
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
internal fun WeekReviewScreen(week: Int, condition: StudyCondition?, comparison: Boolean = false, onSubmit: (Int?, Int?, Int?, String, String?) -> Unit, onLater: () -> Unit) {
  var compared by rememberSaveable { mutableStateOf<String?>(null) }
  var preparation by rememberSaveable { mutableStateOf<Int?>(null) }
  var annoyance by rememberSaveable { mutableStateOf<Int?>(null) }
  var place by rememberSaveable { mutableStateOf<Int?>(null) }
  var comment by rememberSaveable { mutableStateOf("") }
  BackHandler(onBack = onLater)
  RelevoScreen(
    title = if (week == 0) "¿Cómo te fue hasta ahora?" else "¿Cómo te fue esta semana?",
    subtitle = if (week == 0) "Las semanas antes de esta, con el objeto que ya usabas." else condition?.let(::conditionName),
    onBack = onLater, closeIcon = true, backLabel = "Después",
    bottom = {
      RelevoButton("Enviar", { onSubmit(preparation, annoyance, place, comment, compared) })
      PlainAction("Saltar", { onSubmit(null, null, null, "", null) }, color = Relevo.colors.graphite)
    },
  ) {
    Question("¿Te costó preparar Relevo?") { ScaleControl(preparation, { preparation = it }) }
    SectionGap()
    Question("¿Te molestó el sonido?") { ScaleControl(annoyance, { annoyance = it }) }
    SectionGap()
    Question("¿El sonido tenía que ver con el lugar donde sonó?") { ScaleControl(place, { place = it }) }
    // En la semana de comparación, la pregunta central: esta semana frente a las anteriores (2.33).
    if (comparison && week > 0) {
      SectionGap()
      Question("Comparado con las semanas anteriores, ¿esta semana te ayudó a recordar lo que querías hacer…") {
        SegmentedControl(listOf("mas" to "Más", "igual" to "Igual", "menos" to "Menos"), compared, { compared = it })
      }
    }
    SectionGap()
    RenglonArea(if (comparison && week > 0) "¿Por qué? ¿Algo más que quieras contarnos?" else "¿Algo más que quieras contarnos?", comment, { comment = it }, "Escribe aquí, si quieres")
  }
}

/**
 * T2: cierre del día 21. Cinco preguntas derivadas de T2 y de los temas del protocolo 02
 * (D-080, pendientes de revisión del autor). La entrevista la acuerda el investigador.
 */
@Composable
internal fun ClosingScreen(comparison: Boolean = false, onSubmit: (Map<String, String>) -> Unit, onLater: () -> Unit) {
  var continueUsing by rememberSaveable { mutableStateOf<String?>(null) }
  var helpedMost by rememberSaveable { mutableStateOf<String?>(null) }
  var why by rememberSaveable { mutableStateOf("") }
  var prefers by rememberSaveable { mutableStateOf<String?>(null) }
  var bothered by rememberSaveable { mutableStateOf("") }
  var change by rememberSaveable { mutableStateOf("") }
  var speakerPlace by rememberSaveable { mutableStateOf("") }
  BackHandler(onBack = onLater)
  RelevoScreen(
    title = if (comparison) "¡Terminaste la prueba!" else "¡Terminaste los 21 días!",
    subtitle = if (comparison) "Gracias. Siete preguntas cortas; puedes saltar las que quieras." else "Gracias. Cinco preguntas cortas; puedes saltar las que quieras.",
    onBack = onLater, closeIcon = true, backLabel = "Después",
    bottom = {
      RelevoButton("Enviar", {
        onSubmit(mapOf(
          "seguiria_usando" to continueUsing.orEmpty(),
          "semana_que_ayudo" to helpedMost.orEmpty(),
          "por_que_ayudo" to why,
          "prefiere_que_suene" to prefers.orEmpty(),
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
    // En una comparación, la pregunta es qué ayudó más a recordar: el objeto donde se empieza o el teléfono (2.33).
    Question(if (comparison) "2. ¿Qué te ayudó más a recordar lo que querías hacer?" else "2. ¿Qué semana te ayudó más?") {
      val options = if (comparison) listOf("A" to "El objeto donde empiezo", "C" to "El aviso en el teléfono", "igual" to "Los dos por igual", "ninguna" to "Ninguno")
        else StudyCondition.entries.map { it.code.toString() to conditionName(it) } + ("ninguna" to "Ninguna")
      ListSection {
        options.forEach { (value, label) ->
          ListRow(label, onClick = { helpedMost = if (helpedMost == value) null else value }, trailing = { RadioMark(helpedMost == value) })
        }
      }
    }
    if (comparison) {
      SectionGap()
      RenglonArea("3. ¿Por qué?", why, { why = it }, "Escribe aquí")
      SectionGap()
      Question("4. Si siguieras usando Relevo, ¿con qué te gustaría que sonara?") {
        SegmentedControl(listOf("objeto" to "Un objeto", "telefono" to "El teléfono", "da_igual" to "Me da igual"), prefers, { prefers = it })
      }
    }
    SectionGap()
    RenglonArea(if (comparison) "5. ¿Qué te molestó?" else "3. ¿Qué te molestó?", bothered, { bothered = it }, "Escribe aquí")
    SectionGap()
    RenglonArea(if (comparison) "6. ¿Qué cambiarías?" else "4. ¿Qué cambiarías?", change, { change = it }, "Escribe aquí")
    SectionGap()
    RenglonArea(if (comparison) "7. ¿Dónde quedó el objeto la mayor parte del tiempo?" else "5. ¿Dónde quedó lo que sonaba la mayor parte del tiempo?", speakerPlace, { speakerPlace = it }, "Ejemplo: junto a la puerta")
  }
}
