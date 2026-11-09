package com.example.relevo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonArea
import com.example.relevo.ui.components.Text

/**
 * Cierre de la prueba (4.7, D-175): el [instrumento de cierre del 28 de octubre](07_validacion/instrumentos) en
 * la app, para que cada persona lo responda sola, cuando pueda. Son las mismas preguntas, opciones y claves que
 * el cuestionario en papel, así que el análisis las trata igual: las partes A, B y C vienen de la app 2.33.
 * Desde la 4.7.2 (D-177), la entrevista es la del 9 de noviembre, que sigue la guía de los profesores para la
 * entrevista semiestructurada. Los fallos críticos no están: los marca el investigador al leer las respuestas.
 *
 * La ve quien ya usaba Relevo cuando abrió esta versión por primera vez, nunca una instalación nueva. Aparece
 * al abrir la app, una vez, y después queda en Ajustes hasta terminarla. Cada parte se guarda al tocar
 * «Seguir», así que lo respondido no se pierde si la persona la deja a medias.
 *
 * 4.7.1: se muestran todas las preguntas, aunque alguna se haya respondido antes. Las claves `semana1_*` y
 * `cierre_*` también las usaron las tarjetas de la prueba de 21 días, con otro sentido (la primera semana, la
 * semana que más ayudó); saltarlas por eso podía dejar sin responder la semana con el teléfono. Lo anterior
 * queda guardado con su fecha y no se borra.
 */
internal object ClosingSurvey {
  const val CHECKED = "survey_closing_checked"
  const val ELIGIBLE = "survey_closing_eligible"
  /** Cuándo se ofreció al abrir la app; 0 si todavía no. */
  const val OFFERED_AT = "survey_closing_offered_at"
  /** La próxima parte por responder, de 0 a [parts].size. */
  const val PART = "survey_closing_part"
  const val DONE = "survey_closing_done"

  /** La encuesta del rediseño espera un día después de ofrecer esta, para no pedir dos encuestas seguidas. */
  const val REDESIGN_WAIT_MILLIS = 24L * 60 * 60 * 1000

  /** Igual que la encuesta del rediseño: quien terminó la primera vez, aceptó alguna vez o tiene relevos. */
  fun eligibleAtFirstRun(onboardingComplete: Boolean, acceptedBefore: Boolean, hasHistory: Boolean): Boolean =
    onboardingComplete || acceptedBefore || hasHistory

  /** Las partes que quedan desde [from], la próxima por responder. */
  fun remainingParts(from: Int): List<Int> = parts.indices.filter { it >= from }

  private fun scale(key: String, text: String) = ClosingQuestion(key, text, ClosingKind.SCALE)
  private fun choice(key: String, text: String, vararg options: Pair<String, String>) = ClosingQuestion(key, text, ClosingKind.CHOICE, options.toList())
  private fun open(key: String, text: String, vararg hints: String) = ClosingQuestion(key, text, ClosingKind.TEXT, hints = hints.toList())

  val parts = listOf(
    ClosingPart(
      "Las semanas con el Tag", "¿Cómo te fue hasta ahora?",
      listOf(
        scale("semanas_previas_costo_preparar", "¿Te costó preparar Relevo?"),
        scale("semanas_previas_molestia_senal", "¿Te molestó el sonido?"),
        scale("semanas_previas_relacion_lugar", "¿El sonido tenía que ver con el lugar donde sonó?"),
        open("semanas_previas_comentario", "¿Algo más que quieras contarnos?"),
      ),
    ),
    ClosingPart(
      "La semana con el teléfono", "¿Cómo te fue esta semana?",
      listOf(
        scale("semana1_costo_preparar", "¿Te costó preparar Relevo?"),
        scale("semana1_molestia_senal", "¿Te molestó el sonido?"),
        scale("semana1_relacion_lugar", "¿El sonido tenía que ver con el lugar donde sonó?"),
        choice(
          "semana1_comparacion", "Comparado con las semanas anteriores, ¿esta semana te ayudó a recordar lo que querías hacer…",
          "mas" to "Más", "igual" to "Igual", "menos" to "Menos",
        ),
        open("semana1_comentario", "¿Por qué? ¿Algo más que quieras contarnos?"),
      ),
    ),
    ClosingPart(
      "¡Terminaste la prueba!", "Gracias. Siete preguntas cortas; puedes saltar las que quieras.",
      listOf(
        choice("cierre_seguiria_usando", "¿Seguirías usando Relevo?", "si" to "Sí", "tal_vez" to "Tal vez", "no" to "No"),
        choice(
          "cierre_semana_que_ayudo", "¿Qué te ayudó más a recordar lo que querías hacer?",
          "A" to "El objeto donde empiezo", "C" to "El aviso en el teléfono", "igual" to "Los dos por igual", "ninguna" to "Ninguno",
        ),
        open("cierre_por_que_ayudo", "¿Por qué?"),
        choice(
          "cierre_prefiere_que_suene", "Si siguieras usando Relevo, ¿con qué te gustaría que sonara?",
          "objeto" to "Un objeto", "telefono" to "El teléfono", "da_igual" to "Me da igual",
        ),
        open("cierre_que_molesto", "¿Qué te molestó?"),
        open("cierre_que_cambiaria", "¿Qué cambiarías?"),
        open("cierre_lugar_parlante", "¿Dónde quedó el objeto la mayor parte del tiempo?"),
      ),
    ),
    // 4.7.2 (D-177): la entrevista sigue la guía de los profesores para la entrevista semiestructurada. Todas las
    // preguntas son abiertas, ninguna se responde con sí o no, y van de lo general a lo particular: contexto,
    // contraste, opinión y una pregunta final proyectiva. Las claves llevan el tema, no un número, para que nunca
    // se confundan con las de la entrevista del 28 de octubre (`entrevista_1` a `entrevista_9`).
    ClosingPart(
      "Entrevista final, primera parte", "Cinco preguntas para contar con tus palabras cómo fue. No hay respuestas correctas y puedes saltar las que quieras.",
      listOf(
        open(
          "entrevista_uso", "Para empezar, cuéntame cómo usaste Relevo en estas semanas: qué actividad elegiste y en qué momentos lo preparabas.",
          "¿Qué te llevó a elegir esa actividad?",
        ),
        open(
          "entrevista_al_sonar", "Piensa en una vez en que sonó. ¿Qué pasó desde que lo escuchaste? Cuéntalo paso a paso.",
          "¿En qué estabas pensando justo antes de que sonara?",
          "¿Qué se te vino a la cabeza antes de mirar el teléfono?",
          "Cuéntame también de alguna vez en que sonó y no lo notaste, o lo notaste y seguiste en lo que estabas.",
        ),
        open(
          "entrevista_lugar", "¿Dónde estuvo el Tag la mayor parte del tiempo y cómo llegaste a dejarlo ahí?",
          "Si lo cambiaste de lugar, ¿qué te hizo moverlo?",
        ),
        open(
          "entrevista_tag_y_telefono", "¿Qué fue distinto y qué fue igual entre las semanas en que sonó el Tag y la semana en que sonó el teléfono?",
          "En la semana con el teléfono, ¿qué pasaba entre que sonaba y que leías la notificación?",
          "Cuéntame un ejemplo de cada una.",
        ),
        open(
          "entrevista_dias_sin_uso", "Cuéntame de los días en que no preparaste ningún relevo: ¿qué pasaba esos días?",
          "¿Qué te hizo volver a usarlo, o dejar de usarlo?",
        ),
      ),
    ),
    ClosingPart(
      "Entrevista final, segunda parte", "Cinco preguntas sobre lo que sentiste y lo que cambiarías. Puedes saltar las que quieras.",
      listOf(
        open(
          "entrevista_decidir", "Cuando sonaba, ¿cómo decidías qué hacer: empezar la actividad, dejarla para después o cambiar de idea?",
          "¿Qué sentías en ese momento?",
          "¿Cómo hacías para callarlo o dejarlo para después?",
        ),
        open(
          "entrevista_costo_y_molestia", "¿Qué te costó o te molestó de usar Relevo? Puede ser al prepararlo, el sonido, el Tag o el teléfono.",
          "Cuéntame una vez en que pasó.",
        ),
        open(
          "entrevista_fallas", "¿Qué cosas no funcionaron como esperabas?",
          "Por ejemplo, que no sonara, que sonara cuando no lo esperabas o que el Tag o la app hicieran algo raro.",
        ),
        open(
          "entrevista_otras_personas", "¿Cómo fue usar Relevo con otras personas cerca?",
          "¿Qué dijeron o hicieron cuando sonó o cuando vieron lo que preparaste?",
        ),
        open(
          "entrevista_cambiaria", "Si pudieras cambiar una sola cosa de Relevo, ¿cuál sería y por qué?",
          "¿Qué más te gustaría contar que no te haya preguntado?",
        ),
      ),
    ),
  )

  /** Las partes que son entrevista: sus preguntas siguen la guía de los profesores. */
  val interviewParts: List<ClosingPart> get() = parts.filter { it.title.startsWith("Entrevista") }

  /** Versión del instrumento; va en el registro de uso junto a cada parte guardada. */
  const val INSTRUMENT = "2026-11-09"

  /** Lo escrito y aún no enviado, por si la persona cierra la pantalla a medias. Solo en el teléfono. */
  const val DRAFT = "survey_closing_draft"

  /**
   * Lo respondido de una parte, en el orden de sus preguntas y con las claves del instrumento. Lo que quedó en
   * blanco no se envía; un texto se recorta a 600 caracteres, el máximo de la base.
   */
  fun answersOf(part: Int, values: Map<String, String>): List<Pair<String, String>> =
    parts[part].questions.mapNotNull { question ->
      val value = values[question.key]?.trim().orEmpty()
      if (value.isEmpty()) null else question.key to (if (question.kind == ClosingKind.TEXT) value.take(600) else value)
    }
}

internal enum class ClosingKind { SCALE, CHOICE, TEXT }

internal data class ClosingQuestion(
  val key: String,
  val text: String,
  val kind: ClosingKind,
  val options: List<Pair<String, String>> = emptyList(),
  /** Las repreguntas de la entrevista, como ayuda bajo la pregunta. */
  val hints: List<String> = emptyList(),
)

internal data class ClosingPart(val title: String, val intro: String, val questions: List<ClosingQuestion>)

/** Lo que la app sabe del cierre: la próxima parte y si ya se terminó. Null para quien no lo ve. */
internal data class ClosingStatus(val part: Int, val done: Boolean) {
  val left: Int get() = (ClosingSurvey.parts.size - part).coerceAtLeast(0)
}

/** El subtítulo de la fila de Ajustes. */
internal fun closingSubtitle(status: ClosingStatus): String = when {
  status.part == 0 -> "Sin responder · unos 15 minutos"
  status.left == 1 -> "Te falta 1 de ${ClosingSurvey.parts.size} partes"
  else -> "Te faltan ${status.left} de ${ClosingSurvey.parts.size} partes"
}

/** Al abrir la app, una vez: qué es y cuánto toma. «Ahora no» la deja en Ajustes. */
@Composable
internal fun ClosingIntroSheet(onStart: () -> Unit, onLater: () -> Unit) {
  RelevoSheet(onDismiss = onLater, title = "Cierre de la prueba") {
    Text(
      "Gracias por estas semanas. Son unas respuestas cortas y, al final, diez preguntas para contar con tus palabras cómo te fue con el Tag y con el teléfono. Toma unos 15 minutos y puedes saltar cualquier pregunta.",
      style = Relevo.type.body, color = Relevo.colors.graphite,
    )
    Spacer(Modifier.height(12.dp))
    Text(
      "No hay respuestas buenas ni malas: sirve saber qué te pasó, también lo que no funcionó. Se guardan con tu código, aparte de tu nombre.",
      style = Relevo.type.body, color = Relevo.colors.graphite,
    )
    Spacer(Modifier.height(Gap.section))
    RelevoButton("Empezar", onStart, Modifier.fillMaxWidth())
    Spacer(Modifier.height(8.dp))
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
      PlainAction("Ahora no", onLater, color = Relevo.colors.graphite)
    }
    Text(
      "Queda en Ajustes para cuando quieras.",
      style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.fillMaxWidth(),
      textAlign = androidx.compose.ui.text.style.TextAlign.Center,
    )
    Spacer(Modifier.height(12.dp))
  }
}

/**
 * Las partes del cierre, una por pantalla, desde [startPart]. [onPart] guarda una parte y dice cuál sigue (null
 * al terminar).
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ClosingSurveyScreen(
  startPart: Int,
  /** Lo que la persona había escrito y no envió: vuelve a aparecer en sus campos (4.7.2). */
  draft: Map<String, String>,
  onDraft: (Map<String, String>) -> Unit,
  onPart: (part: Int, answers: List<Pair<String, String>>, next: Int?) -> Unit,
  onClose: () -> Unit,
) {
  // Se calcula una vez al abrir: al guardar una parte, [startPart] avanza, y recalcularla saltaba la siguiente.
  val remaining = rememberSaveable { ArrayList(ClosingSurvey.remainingParts(startPart)) }
  var index by rememberSaveable { mutableIntStateOf(0) }
  var values by rememberSaveable { mutableStateOf(HashMap(draft)) }
  var finished by rememberSaveable { mutableStateOf(remaining.isEmpty()) }
  // 4.7.2: lo escrito se guarda en el teléfono mientras se responde y al salir de la pantalla, para que cerrar
  // a medias, por error o porque llegó una llamada, no borre una respuesta larga.
  val latest by rememberUpdatedState(values)
  LaunchedEffect(values) { delay(400); onDraft(values) }
  DisposableEffect(Unit) { onDispose { onDraft(latest) } }
  if (finished) {
    ClosingThanks(onClose)
    return
  }
  val partIndex = remaining[index.coerceIn(0, remaining.lastIndex)]
  val part = ClosingSurvey.parts[partIndex]
  val last = index >= remaining.lastIndex
  val scroll = rememberScrollState()
  LaunchedEffect(partIndex) { scroll.scrollTo(0) }
  RelevoScreen(
    title = part.title,
    subtitle = part.intro,
    onBack = onClose, closeIcon = true, backLabel = "Cerrar",
    // La parte entre las cuatro, también al retomar: «2 de 4» dice cuánto falta.
    step = "${partIndex + 1} de ${ClosingSurvey.parts.size}",
    progress = (partIndex + 1f) / ClosingSurvey.parts.size,
    scrollState = scroll,
    bottom = {
      RelevoButton(if (last) "Enviar" else "Seguir", {
        val next = remaining.getOrNull(index + 1)
        onPart(partIndex, ClosingSurvey.answersOf(partIndex, values), next)
        // Lo enviado sale del borrador: si no, volvería a guardarse como pendiente.
        values = HashMap(values).apply { part.questions.forEach { remove(it.key) } }
        if (next == null) finished = true else index += 1
      }, Modifier.fillMaxWidth())
    },
  ) {
    Column(verticalArrangement = Arrangement.spacedBy(Gap.section)) {
      part.questions.forEach { question ->
        val value = values[question.key]
        val set: (String?) -> Unit = { new -> values = HashMap(values).apply { if (new.isNullOrEmpty()) remove(question.key) else put(question.key, new) } }
        SurveyQuestion(question.text) {
          if (question.hints.isNotEmpty()) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
              question.hints.forEach { Text(it, style = Relevo.type.footnote, color = Relevo.colors.graphite) }
            }
          }
          when (question.kind) {
            ClosingKind.SCALE -> PointScale(value?.toIntOrNull(), 5, "Nada", "Mucho") { set(it?.toString()) }
            ClosingKind.CHOICE -> FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
              question.options.forEach { (key, label) -> QuickChoice(label, value == key, { set(if (value == key) null else key) }) }
            }
            ClosingKind.TEXT -> RenglonArea("Respuesta", value.orEmpty(), { set(it) }, placeholder = "Opcional")
          }
        }
      }
    }
  }
}

/** Al terminar: lo guardado y dónde ver o borrar los datos. */
@Composable
private fun ClosingThanks(onClose: () -> Unit) {
  RelevoScreen(
    title = "Gracias",
    subtitle = "Tus respuestas quedaron guardadas. Puedes ver o borrar tus datos en Ajustes, en Datos.",
    onBack = onClose, closeIcon = true, backLabel = "Cerrar",
    bottom = { RelevoButton("Listo", onClose, Modifier.fillMaxWidth()) },
  ) {}
}

/** De 1 a [count], con sus extremos nombrados. Tocar el elegido lo desmarca. */
@Composable
private fun PointScale(value: Int?, count: Int, low: String, high: String, onChange: (Int?) -> Unit) {
  val colors = Relevo.colors
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      (1..count).forEach { n ->
        val on = value == n
        val label = when (n) { 1 -> "1, $low"; count -> "$count, $high"; else -> "$n de $count" }
        Box(
          Modifier.size(48.dp).clip(CircleShape).background(if (on) colors.ink else colors.card)
            .border(1.5.dp, if (on) colors.ink else colors.line, CircleShape)
            .clickable(remember { MutableInteractionSource() }, indication = null, role = Role.RadioButton) { onChange(if (on) null else n) }
            .semantics { contentDescription = label; selected = on },
          contentAlignment = Alignment.Center,
        ) {
          Text("$n", style = Relevo.type.callout.copy(fontWeight = FontWeight.Medium), color = if (on) colors.onInk else colors.ink)
        }
      }
    }
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      Text(low, style = Relevo.type.footnote, color = colors.graphite)
      Text(high, style = Relevo.type.footnote, color = colors.graphite)
    }
  }
}
