package com.example.relevo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import com.example.relevo.ui.components.Text
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.domain.RouteStep
import com.example.relevo.domain.RouteTrack
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Carousel
import com.example.relevo.ui.components.IconAction
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.rememberReduceMotion
import com.example.relevo.ui.components.pressScale
import androidx.compose.foundation.border
import java.util.UUID
import androidx.compose.foundation.layout.BoxWithConstraints
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.IconTile
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.skyFor

/** Marca del paso en que está la persona: una cápsula de tinta con «Ahora». */
@Composable
internal fun NowChip() {
  Box(Modifier.background(Relevo.colors.ink, Relevo.controlShape).padding(horizontal = 10.dp, vertical = 4.dp)) {
    Text("Ahora", style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold), color = Relevo.colors.onInk)
  }
}

/** Número del paso en un círculo: de tinta el actual, en piedra los demás. */
@Composable
internal fun StepDot(number: Int, current: Boolean, past: Boolean = false, size: Dp = 30.dp) {
  val colors = Relevo.colors
  Box(Modifier.size(size).clip(CircleShape).background(if (current) colors.ink else colors.mist), contentAlignment = Alignment.Center) {
    Text(
      "$number", style = Relevo.type.subhead.copy(fontWeight = FontWeight.SemiBold),
      color = when { current -> colors.onInk; past -> colors.graphite; else -> colors.ink },
    )
  }
}

/** R2: los pasos de un interés. Se editan, se ordenan, se borran y se agregan; nada se guarda hasta «Guardar». */
@Composable
internal fun RouteEditScreen(track: RouteTrack, customActivities: List<CustomActivity>, onSave: (RouteTrack) -> Unit, onBack: () -> Unit) {
  var draft by remember(track.interest) { mutableStateOf(track) }
  var editing by remember { mutableStateOf<RouteStep?>(null) }
  var menuFor by remember { mutableStateOf<String?>(null) }
  RelevoScreen(
    title = draft.title,
    onBack = onBack, backLabel = "Cancelar",
    bottom = { GuardedButton("Guardar", { onSave(draft) }, missing = if (draft == track) "No hay cambios que guardar." else null) },
  ) {
    if (draft.steps.isNotEmpty()) {
      ListSection {
        draft.steps.forEachIndexed { index, step ->
          ListRow(
            step.activity,
            subtitle = startSentence(step.firstStep, step.place),
            leading = { StepDot(index + 1, current = index == draft.currentIndex, past = index < draft.currentIndex) },
            onClick = { editing = step },
            trailing = {
              Box {
                IconAction(KitIcon.MAS, "Más opciones de ${step.activity}", { menuFor = step.id })
                DropdownMenu(
                  expanded = menuFor == step.id, onDismissRequest = { menuFor = null },
                  containerColor = Relevo.colors.card, shape = RoundedCornerShape(20.dp),
                ) {
                  MenuItem("Editar", KitIcon.EDITAR) { menuFor = null; editing = step }
                  if (index > 0) MenuItem("Subir", KitIcon.CONTRAER) { menuFor = null; draft = draft.move(step.id, -1) }
                  if (index < draft.steps.lastIndex) MenuItem("Bajar", KitIcon.EXPANDIR) { menuFor = null; draft = draft.move(step.id, 1) }
                  if (index != draft.currentIndex) {
                    MenuItem(if (index > draft.currentIndex) "Pasar a este paso" else "Volver a este paso", KitIcon.LUGAR) { menuFor = null; draft = draft.moveTo(index) }
                  }
                  MenuItem("Borrar", KitIcon.BORRAR, danger = true) { menuFor = null; draft = draft.remove(step.id) }
                }
              }
            },
          )
        }
      }
      Spacer(Modifier.height(12.dp))
    }
    RelevoButton("Agregar un paso", { editing = RouteStep(UUID.randomUUID().toString(), "", "", "") }, kind = ButtonKind.Secondary, compact = true, icon = KitIcon.AGREGAR)
  }

  editing?.let { step ->
    StepEditorSheet(step, isNew = draft.steps.none { it.id == step.id }, onDismiss = { editing = null }) { saved ->
      draft = if (draft.steps.any { it.id == saved.id }) draft.update(saved) else draft.add(saved)
      editing = null
    }
  }
}

@Composable
private fun MenuItem(label: String, icon: KitIcon, danger: Boolean = false, onClick: () -> Unit) {
  val color = if (danger) Relevo.colors.error else Relevo.colors.ink
  DropdownMenuItem(
    text = { Text(label, style = Relevo.type.body, color = color) },
    leadingIcon = { RelevoIcon(icon, size = 20.dp, tint = color, background = Relevo.colors.card) },
    onClick = onClick,
  )
}

/** Un paso con sus tres renglones: qué hacer, cómo empezar y dónde. */
@Composable
private fun StepEditorSheet(step: RouteStep, isNew: Boolean, onDismiss: () -> Unit, onSave: (RouteStep) -> Unit) {
  var activity by rememberSaveable(step.id) { mutableStateOf(step.activity) }
  var first by rememberSaveable(step.id) { mutableStateOf(step.firstStep) }
  var place by rememberSaveable(step.id) { mutableStateOf(step.place) }
  RelevoSheet(onDismiss = onDismiss, title = if (isNew) "Nuevo paso" else "Editar el paso") {
    Spacer(Modifier.height(4.dp))
    RenglonField("Actividad", activity, { activity = it }, placeholder = "Ej.: caminar 30 minutos")
    Spacer(Modifier.height(20.dp))
    RenglonField(START_QUESTION, first, { first = it }, placeholder = "Ej.: ponerte las zapatillas")
    Spacer(Modifier.height(20.dp))
    RenglonField(PLACE_QUESTION, place, { place = it }, placeholder = "Ej.: junto a la puerta")
    Spacer(Modifier.height(24.dp))
    GuardedButton("Guardar el paso", { onSave(step.copy(activity = activity.trim(), firstStep = first.trim(), place = place.trim())) },
      missing = if (activity.isBlank()) "Escribe la actividad del paso." else null)
  }
}

private val spelled = listOf("cero", "una", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez")

/**
 * R3: tras varias respuestas «Comencé la actividad» en el mismo paso. Repite lo que la persona
 * declaró, sin afirmar que se formó un hábito, y las dos opciones pesan lo mismo.
 */
@Composable
internal fun NextStepSheet(suggestion: RouteSuggestion, onAccept: () -> Unit, onStay: () -> Unit, onDismiss: () -> Unit) {
  val times = spelled.getOrNull(suggestion.starts)?.let { "$it veces" } ?: "${suggestion.starts} veces"
  RelevoSheet(onDismiss = onDismiss, scrollable = false) {
    Text("Dijiste que empezaste «${suggestion.current.activity}» $times.", style = Relevo.type.body, color = Relevo.colors.graphite)
    Spacer(Modifier.height(8.dp))
    Text("¿Quieres probar el siguiente paso?", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(16.dp))
    Panel(padding = 14.dp) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        ActivityRing(iconForActivity(suggestion.next.activity, emptyList()).takeIf { it != KitIcon.ACTIVIDAD } ?: interestIcon(suggestion.interest), 52.dp)
        Spacer(Modifier.width(14.dp))
        Column(Modifier.weight(1f)) {
          Text(suggestion.next.activity, style = Relevo.type.headline, color = Relevo.colors.ink)
          startSentence(suggestion.next.firstStep, suggestion.next.place)?.let { Text(it, style = Relevo.type.footnote, color = Relevo.colors.graphite) }
        }
      }
    }
    Spacer(Modifier.height(20.dp))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      RelevoButton("Probar el siguiente paso", onAccept, kind = ButtonKind.Secondary)
      RelevoButton("Seguir en este paso", onStay, kind = ButtonKind.Secondary)
    }
  }
}

/** V2: tras dos «Ahora no» seguidos, se pregunta una sola vez si se apaga el aviso semanal. */
@Composable
internal fun TurnOffReturnSheet(onAnswer: (Boolean) -> Unit) {
  RelevoSheet(onDismiss = { onAnswer(false) }, scrollable = false) {
    Text("¿Apagar el aviso semanal?", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(8.dp))
    Text("Puedes volver a encenderlo en Perfil › Ajustes › Avisos.", style = Relevo.type.body, color = Relevo.colors.graphite)
    Spacer(Modifier.height(20.dp))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      RelevoButton("Apagarlo", { onAnswer(true) }, kind = ButtonKind.Secondary)
      RelevoButton("Mantenerlo", { onAnswer(false) }, kind = ButtonKind.Secondary)
    }
  }
}
