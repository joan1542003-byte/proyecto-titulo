package com.example.relevo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.relevo.domain.StudyCondition
import com.example.relevo.domain.StudyPlan

// ---- Textos de las condiciones (protocolo 02) ----

internal fun conditionName(condition: StudyCondition): String = when (condition) {
  StudyCondition.SITUATED -> "Parlante junto al comienzo"
  StudyCondition.NEUTRAL -> "Parlante en un lugar neutro"
  StudyCondition.PHONE -> "Aviso en el teléfono"
}

/** Lo que la app pide al comenzar cada semana, con las palabras del protocolo 02. */
internal fun conditionInstruction(condition: StudyCondition): String = when (condition) {
  StudyCondition.SITUATED -> "Esta semana deja el parlante junto a lo que necesitas para empezar."
  StudyCondition.NEUTRAL -> "Esta semana deja el parlante en un lugar que no tenga relación con la actividad."
  StudyCondition.PHONE -> "Esta semana el aviso sonará en tu teléfono."
}

private fun conditionDetail(condition: StudyCondition): String? = when (condition) {
  StudyCondition.NEUTRAL -> "Un lugar visible de la casa, a más de un metro de lo que necesitas para empezar y fuera de tu camino hacia ello."
  StudyCondition.PHONE -> "No necesitas el parlante. La notificación dirá solo «Tu intención está disponible» hasta que abras Relevo."
  StudyCondition.SITUATED -> null
}

/** Reconocimiento breve tras la respuesta (B5). Las tres respuestas pesan lo mismo; omitir no recibe mensaje. */
internal fun acknowledgementFor(outcome: String): String? = when (outcome) {
  "started" -> "Gracias por contarlo."
  "later" -> "Queda guardado. Puedes prepararlo cuando quieras."
  "changed" -> "Está bien. Puedes elegir otra actividad cuando quieras."
  else -> null
}

// ---- Tarjetas en Inicio ----

@Composable
internal fun StudyCards(study: StudyState, onDismissInstruction: (Int) -> Unit, onWeekReview: () -> Unit, onClosing: () -> Unit) {
  if (!study.active && !study.finished) return
  Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    if (study.initialSession) {
      StudyCard("Sesión inicial de la prueba", "Hoy preparas Relevo junto al investigador. Deja el parlante junto a lo que necesitas para empezar.")
    }
    val week = study.instructionWeek
    val condition = study.condition
    if (week != null && condition != null) {
      StudyCard("Semana $week de 3 · ${conditionName(condition)}", conditionInstruction(condition), conditionDetail(condition)) {
        InlineAction("Cerrar", { onDismissInstruction(week) }, modifier = Modifier.align(Alignment.End))
      }
    }
    study.pendingWeek?.let { pending ->
      StudyCard("Cierre de la semana $pending", "Tres preguntas breves sobre esta semana. Puedes omitirlas.") {
        InlineAction("Responder", onWeekReview, modifier = Modifier.align(Alignment.End))
      }
    }
    if (study.pendingWeek == null && study.closingPending) {
      StudyCard("Terminaste la prueba. Gracias.", "Cinco preguntas breves, unos 2 minutos.") {
        InlineAction("Responder", onClosing, modifier = Modifier.align(Alignment.End))
      }
    }
  }
}

@Composable
private fun StudyCard(title: String, text: String, detail: String? = null, actions: @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit = {}) {
  Surface(shape = RoundedCornerShape(24.dp), color = MaterialTheme.colorScheme.secondaryContainer) {
    Column(Modifier.fillMaxWidth().padding(18.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
      Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
      Text(text, lineHeight = 22.sp)
      detail?.let { Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 19.sp) }
      actions()
    }
  }
}

// ---- Configuración de la prueba (investigador) ----

@Composable
internal fun StudyScreen(study: StudyState, participantCode: String, onStart: (String) -> Unit, onEnd: () -> Unit, onBack: () -> Unit) = Page {
  var sequence by rememberSaveable { mutableStateOf<String?>(null) }
  var confirmEnd by rememberSaveable { mutableStateOf(false) }
  BackHandler(onBack = onBack)
  Column(Modifier.fillMaxSize()) {
    InlineAction("Volver", onBack)
    Spacer(Modifier.height(16.dp))
    Text("Prueba de 21 días", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Spacer(Modifier.height(12.dp))
    Column(Modifier.weight(1f).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
      val plan = study.plan
      if (plan == null) {
        Text("Para el investigador, en la sesión inicial. Elige la secuencia asignada a esta persona; hoy será el día 0. Cada semana usa una condición.", lineHeight = 22.sp)
        StudyCondition.entries.forEach { ConsentPoint("${it.code}. ${conditionName(it)}", conditionInstruction(it)) }
        StudyPlan.SEQUENCES.forEachIndexed { index, option ->
          SelectableRow("Secuencia ${index + 1} · ${option.toList().joinToString(" → ")}", sequence == option) { sequence = option }
        }
        PrimaryButton("Empezar la prueba hoy", { sequence?.let(onStart) }, enabled = sequence != null)
      } else {
        val day = study.day
        Text(
          when {
            study.finished -> "La prueba terminó el día 21."
            day == 0 -> "Hoy es la sesión inicial (día 0)."
            else -> "Día $day de 21 · semana ${study.week}: ${study.condition?.let(::conditionName)}."
          },
          style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold,
        )
        ConsentPoint("Secuencia", plan.sequence.toList().joinToString(" → ") { "$it. ${conditionName(StudyCondition.fromCode(it)!!)}" })
        ConsentPoint("Día 0", plan.day0.toString())
        ConsentPoint("Código de participación", participantCode)
        Text("La condición de cada semana fija dónde suena la señal. Las preguntas tras cada señal y las tarjetas semanales aparecen solas.",
          color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 21.sp)
        InlineAction(if (confirmEnd) "Cancelar" else "Terminar la prueba", { confirmEnd = !confirmEnd })
        if (confirmEnd) SecondaryButton("Confirmar: terminar la prueba", { confirmEnd = false; onEnd() })
      }
    }
  }
}

@Composable
private fun SelectableRow(label: String, selected: Boolean, onClick: () -> Unit) {
  Box(
    Modifier.fillMaxWidth().heightIn(min = 52.dp).clip(RoundedCornerShape(16.dp))
      .background(if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant)
      .clickable(onClick = onClick).semantics { this.selected = selected }.padding(horizontal = 18.dp, vertical = 14.dp),
    contentAlignment = Alignment.CenterStart,
  ) {
    Text(label, color = if (selected) Color.White else MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Medium)
  }
}

// ---- Preguntas de un toque ----

/** Opciones de una sola elección; tocar la seleccionada la desmarca, porque toda pregunta se puede omitir. */
@Composable
internal fun ChoiceRow(options: List<Pair<String, String>>, selected: String?, onSelect: (String?) -> Unit) {
  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
    options.forEach { (value, label) ->
      val active = value == selected
      Box(
        Modifier.weight(1f).height(48.dp).clip(RoundedCornerShape(14.dp))
          .background(if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant)
          .border(1.dp, if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = .12f), RoundedCornerShape(14.dp))
          .clickable { onSelect(if (active) null else value) }
          .semantics { this.selected = active },
        contentAlignment = Alignment.Center,
      ) {
        Text(label, color = if (active) Color.White else MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Medium)
      }
    }
  }
}

@Composable
private fun Question(text: String, content: @Composable () -> Unit) {
  Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    Text(text, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, lineHeight = 24.sp)
    content()
  }
}

@Composable
private fun Scale(value: Int?, onChange: (Int?) -> Unit) {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    ChoiceRow((1..5).map { it.toString() to it.toString() }, value?.toString()) { onChange(it?.toInt()) }
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      Text("1 · nada", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text("5 · mucho", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
  }
}

@Composable
private fun MultilineField(value: String, placeholder: String, onChange: (String) -> Unit) {
  BasicTextField(
    value = value,
    onValueChange = { onChange(it.take(600)) },
    textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
    cursorBrush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.primary),
    modifier = Modifier.fillMaxWidth().heightIn(min = 96.dp).clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(horizontal = 18.dp, vertical = 16.dp),
    decorationBox = { inner ->
      Box {
        if (value.isBlank()) Text(placeholder, color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = .58f))
        inner()
      }
    },
  )
}

/** T1: cierre de cada semana (días 7, 14 y 21), con escalas de 1 a 5 y un comentario opcional. */
@Composable
internal fun WeekReviewScreen(week: Int, condition: StudyCondition?, onSubmit: (Int?, Int?, Int?, String) -> Unit, onLater: () -> Unit) = Page {
  var preparation by rememberSaveable { mutableStateOf<Int?>(null) }
  var annoyance by rememberSaveable { mutableStateOf<Int?>(null) }
  var place by rememberSaveable { mutableStateOf<Int?>(null) }
  var comment by rememberSaveable { mutableStateOf("") }
  BackHandler(onBack = onLater)
  Column(Modifier.fillMaxSize()) {
    InlineAction("Responder después", onLater)
    Spacer(Modifier.height(12.dp))
    Text("Cierre de la semana $week", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold)
    condition?.let { Text(conditionName(it), color = MaterialTheme.colorScheme.onSurfaceVariant) }
    Spacer(Modifier.height(16.dp))
    Column(Modifier.weight(1f).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(22.dp)) {
      Question("¿Cuánto te costó preparar Relevo esta semana?") { Scale(preparation) { preparation = it } }
      Question("¿Cuánto te molestó la señal?") { Scale(annoyance) { annoyance = it } }
      Question("¿Cuánto se relacionaba la señal con el lugar?") { Scale(place) { place = it } }
      Question("¿Quieres comentar algo? (opcional)") { MultilineField(comment, "Escribe aquí") { comment = it } }
      Spacer(Modifier.height(4.dp))
    }
    PrimaryButton("Enviar las respuestas", { onSubmit(preparation, annoyance, place, comment) })
    InlineAction("Omitir esta semana", { onSubmit(null, null, null, "") }, modifier = Modifier.align(Alignment.CenterHorizontally))
  }
}

/**
 * T2: cierre del día 21. Las cinco preguntas salen de los temas que fija el protocolo 02 para el
 * cierre y del diseño escrito T2; están pendientes de revisión del autor.
 */
@Composable
internal fun ClosingScreen(onSubmit: (Map<String, String>) -> Unit, onLater: () -> Unit) = Page {
  var continueUsing by rememberSaveable { mutableStateOf<String?>(null) }
  var helpedMost by rememberSaveable { mutableStateOf<String?>(null) }
  var bothered by rememberSaveable { mutableStateOf("") }
  var change by rememberSaveable { mutableStateOf("") }
  var speakerPlace by rememberSaveable { mutableStateOf("") }
  BackHandler(onBack = onLater)
  Column(Modifier.fillMaxSize()) {
    InlineAction("Responder después", onLater)
    Spacer(Modifier.height(12.dp))
    Text("Terminaste la prueba. Gracias.", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold)
    Text("Cinco preguntas breves. Todas se pueden omitir.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    Spacer(Modifier.height(16.dp))
    Column(Modifier.weight(1f).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(22.dp)) {
      Question("1. ¿Seguirías usando Relevo?") {
        ChoiceRow(listOf("si" to "Sí", "tal_vez" to "Tal vez", "no" to "No"), continueUsing) { continueUsing = it }
      }
      Question("2. ¿Qué semana te ayudó más?") {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          (StudyCondition.entries.map { it.code.toString() to conditionName(it) } + ("ninguna" to "Ninguna")).forEach { (value, label) ->
            SelectableRow(label, helpedMost == value) { helpedMost = if (helpedMost == value) null else value }
          }
        }
      }
      Question("3. ¿Qué te molestó?") { MultilineField(bothered, "Escribe aquí") { bothered = it } }
      Question("4. ¿Qué cambiarías?") { MultilineField(change, "Escribe aquí") { change = it } }
      Question("5. ¿Dónde quedó el parlante la mayor parte del tiempo?") { MultilineField(speakerPlace, "Por ejemplo: junto a la puerta") { speakerPlace = it } }
      Spacer(Modifier.height(4.dp))
    }
    PrimaryButton("Enviar las respuestas", {
      onSubmit(mapOf(
        "seguiria_usando" to continueUsing.orEmpty(),
        "semana_que_ayudo" to helpedMost.orEmpty(),
        "que_molesto" to bothered,
        "que_cambiaria" to change,
        "lugar_parlante" to speakerPlace,
      ))
    })
  }
}
