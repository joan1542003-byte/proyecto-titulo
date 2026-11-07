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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonArea
import com.example.relevo.ui.components.Text

/**
 * Encuesta del rediseño (4.6, D-164). La ve una sola vez quien ya usaba Relevo antes de esta versión, cuando
 * activa un relevo o tras un minuto en la app, lo que ocurra primero, y nunca en medio del consentimiento o
 * de una señal. Son seis preguntas que se pueden saltar; las respuestas van a las mismas tablas que las
 * demás preguntas de un toque (consentimiento v14: «qué respondes»).
 *
 * Dos preguntas son el UMUX-Lite (Lewis et al., 2013), una medida de usabilidad de dos ítems de 1 a 7, en
 * una traducción propia: sirve para comparar con otras apps y versiones sin pedir los diez ítems del SUS.
 */
internal object RedesignSurvey {
  const val CHECKED = "survey_redesign_checked"
  const val ELIGIBLE = "survey_redesign_eligible"
  const val SHOWN = "survey_redesign_shown"
  const val FOREGROUND_MS = "survey_redesign_foreground_ms"

  /** Tiempo en la app, sumado entre aperturas, tras el que aparece si antes no se activó un relevo. */
  const val AFTER_MILLIS = 60_000L

  /**
   * Quien ya usaba Relevo al abrir esta versión por primera vez: terminó la primera vez, aceptó alguna vez o
   * tiene relevos. Una instalación nueva no la ve: su primer arranque es antes de todo eso.
   */
  fun eligibleAtFirstRun(onboardingComplete: Boolean, acceptedBefore: Boolean, hasHistory: Boolean): Boolean =
    onboardingComplete || acceptedBefore || hasHistory

  fun remainingMillis(foregroundMillis: Long): Long = (AFTER_MILLIS - foregroundMillis).coerceAtLeast(0L)

  val comparisons = listOf("mejor" to "Mejor", "igual" to "Igual", "peor" to "Peor", "no_recuerdo" to "No me acuerdo")
  val likes = listOf(
    "colores" to "Los colores", "iconos" to "Los íconos", "anillos" to "Los anillos", "inicio" to "Inicio",
    "sugerencias" to "Las sugerencias", "sonidos" to "Los sonidos", "textos" to "Los textos",
  )
}

/** Lo respondido; lo que quedó en blanco no se envía. */
internal data class RedesignAnswers(
  val impression: Int? = null,
  val compared: String? = null,
  val umuxCapabilities: Int? = null,
  val umuxEasy: Int? = null,
  val liked: Set<String> = emptySet(),
  val change: String = "",
) {
  fun isEmpty(): Boolean = toAnswers().isEmpty()

  /** Pares pregunta y respuesta, en el orden de la encuesta, para la tabla de respuestas. */
  fun toAnswers(): List<Pair<String, String>> = buildList {
    impression?.let { add("rediseno_impresion" to it.toString()) }
    compared?.let { add("rediseno_comparado" to it) }
    umuxCapabilities?.let { add("umux_lite_funciones" to it.toString()) }
    umuxEasy?.let { add("umux_lite_facil" to it.toString()) }
    if (liked.isNotEmpty()) add("rediseno_gusta" to RedesignSurvey.likes.map { it.first }.filter { it in liked }.joinToString(","))
    change.trim().takeIf { it.isNotEmpty() }?.let { add("rediseno_cambiaria" to it.take(600)) }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun RedesignSurveySheet(onShown: () -> Unit, onSend: (RedesignAnswers) -> Unit, onDismiss: () -> Unit) {
  var impression by rememberSaveable { mutableStateOf<Int?>(null) }
  var compared by rememberSaveable { mutableStateOf<String?>(null) }
  var capabilities by rememberSaveable { mutableStateOf<Int?>(null) }
  var easy by rememberSaveable { mutableStateOf<Int?>(null) }
  var liked by rememberSaveable { mutableStateOf(listOf<String>()) }
  var change by rememberSaveable { mutableStateOf("") }
  val answers = RedesignAnswers(impression, compared, capabilities, easy, liked.toSet(), change)
  LaunchedEffect(Unit) { onShown() }
  RelevoSheet(onDismiss = onDismiss, title = "Relevo tiene un diseño nuevo", tall = true) {
    Text(
      "Seis preguntas sobre cómo se ve y se usa ahora. Toma menos de un minuto, todas se pueden saltar y no vuelve a aparecer.",
      style = Relevo.type.body, color = Relevo.colors.graphite,
    )
    Spacer(Modifier.height(Gap.title))
    Column(verticalArrangement = Arrangement.spacedBy(Gap.section)) {
      SurveyQuestion("¿Qué te parece el diseño nuevo?") {
        FacePicker(ratingFaces, impression?.toString(), { impression = it?.toIntOrNull() }, size = 36.dp)
      }
      SurveyQuestion("Comparado con la versión anterior, el diseño es…") {
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
          RedesignSurvey.comparisons.forEach { (key, label) ->
            QuickChoice(label, compared == key, { compared = if (compared == key) null else key })
          }
        }
      }
      SurveyQuestion("Relevo hace lo que necesito") { AgreementScale(capabilities) { capabilities = it } }
      SurveyQuestion("Relevo es fácil de usar") { AgreementScale(easy) { easy = it } }
      SurveyQuestion("¿Qué te gusta más?", hint = "Puedes elegir varias.") {
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
          RedesignSurvey.likes.forEach { (key, label) ->
            QuickChoice(label, key in liked, { liked = if (key in liked) liked - key else liked + key })
          }
        }
      }
      SurveyQuestion("¿Qué cambiarías?") {
        RenglonArea("Comentario", change, { change = it }, placeholder = "Opcional")
      }
    }
    Spacer(Modifier.height(Gap.section))
    RelevoButton("Enviar", { onSend(answers) }, Modifier.fillMaxWidth(), enabled = !answers.isEmpty())
    Spacer(Modifier.height(8.dp))
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
      PlainAction("Ahora no", onDismiss, color = Relevo.colors.graphite)
    }
    Spacer(Modifier.height(12.dp))
  }
}

@Composable
private fun SurveyQuestion(title: String, hint: String? = null, content: @Composable () -> Unit) {
  Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
      Text(title, style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.semantics { heading() })
      if (hint != null) Text(hint, style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
    content()
  }
}

/** De 1, nada de acuerdo, a 7, muy de acuerdo: la escala del UMUX-Lite. Tocar el elegido lo desmarca. */
@Composable
private fun AgreementScale(value: Int?, onChange: (Int?) -> Unit) {
  val colors = Relevo.colors
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      (1..7).forEach { n ->
        val on = value == n
        Box(
          Modifier.size(40.dp).clip(CircleShape).background(if (on) colors.ink else colors.card)
            .border(1.5.dp, if (on) colors.ink else colors.line, CircleShape)
            .clickable(remember { MutableInteractionSource() }, indication = null, role = Role.RadioButton) { onChange(if (on) null else n) }
            .semantics { contentDescription = "$n de 7"; selected = on },
          contentAlignment = Alignment.Center,
        ) {
          Text("$n", style = Relevo.type.callout.copy(fontWeight = FontWeight.Medium), color = if (on) colors.onInk else colors.ink)
        }
      }
    }
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      Text("Nada de acuerdo", style = Relevo.type.footnote, color = colors.graphite)
      Text("Muy de acuerdo", style = Relevo.type.footnote, color = colors.graphite)
    }
  }
}
