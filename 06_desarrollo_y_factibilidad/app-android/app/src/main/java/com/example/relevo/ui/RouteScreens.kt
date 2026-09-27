package com.example.relevo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
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
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.domain.RouteStep
import com.example.relevo.domain.RouteTrack
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Carousel
import com.example.relevo.ui.components.IconAction
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.PhotoHero
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PictureContent
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.rememberReduceMotion
import java.util.UUID

/**
 * R1: la ruta de cada interés, con el paso en que está la persona. Los pasos son sugerencias
 * editables; la ruta no avanza sola ni muestra porcentajes, puntos o niveles (D-074).
 */
@Composable
internal fun RouteTab(
  routes: List<RouteTrack>,
  customActivities: List<CustomActivity>,
  selected: String?,
  reselect: Int,
  activeRelevo: Boolean,
  onSelect: (String) -> Unit,
  onPrepare: (interest: String, stepId: String, photoKey: String?) -> Unit,
  onSetCurrent: (interest: String, index: Int) -> Unit,
  onEdit: (String) -> Unit,
  onChooseInterests: () -> Unit,
) {
  val scroll = rememberScrollState()
  var firstReselect by remember { mutableStateOf(reselect) }
  LaunchedEffect(reselect) { if (reselect != firstReselect) scroll.animateScrollTo(0) else firstReselect = reselect }
  val track = routes.firstOrNull { it.interest == selected } ?: routes.firstOrNull()
  var openStep by rememberSaveable { mutableStateOf<String?>(null) }
  val reduce = rememberReduceMotion()
  val current = track?.currentStep

  RelevoScreen(
    title = "Tu ruta",
    scrollState = scroll,
    bottom = when {
      track == null -> ({ RelevoButton("Elegir intereses", onChooseInterests, icon = KitIcon.AGREGAR) })
      current != null && !activeRelevo -> ({ RelevoButton("Preparar este paso", { onPrepare(track.interest, current.id, photoKey("ruta", current.id)) }) })
      else -> null
    },
  ) {
    if (track == null) {
      PhotoHero(Picture.OfPhoto(Photo.SALIDA), aspect = 1.1f, wide = true, modifier = Modifier.appear(0)) {
        Text("Arma tu ruta", style = Relevo.type.title2, color = Relevo.colors.ink)
        Spacer(Modifier.height(4.dp))
        Text("Elige lo que te gustaría hacer más seguido y te proponemos pasos que puedes cambiar.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      }
      return@RelevoScreen
    }
    if (routes.size > 1) {
      Carousel(spacing = 8.dp) {
        items(routes, key = { it.interest }) { item ->
          QuickChoice(item.title, item.interest == track.interest, { onSelect(item.interest) }, icon = interestIcon(item.interest))
        }
      }
      Spacer(Modifier.height(18.dp))
    }
    AnimatedContent(
      targetState = track.interest,
      transitionSpec = { if (reduce) fadeIn(Motion.standard(0)) togetherWith fadeOut(Motion.standard(0)) else fadeIn(Motion.standard()) togetherWith fadeOut(Motion.standard(Motion.SHORT)) },
      label = "route_track",
    ) { interest ->
      val shown = routes.firstOrNull { it.interest == interest } ?: track
      Column {
        val photo = interestPhoto(shown.interest)
        PhotoHero(photo?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(interestIcon(shown.interest)), aspect = 1.35f, wide = true) {
          Text(shown.title, style = Relevo.type.title, color = Relevo.colors.ink)
          Text(
            if (shown.steps.isEmpty()) "Todavía sin pasos" else "${shown.steps.size} ${if (shown.steps.size == 1) "paso" else "pasos"}",
            style = Relevo.type.subhead, color = Relevo.colors.graphite,
          )
        }
        Spacer(Modifier.height(16.dp))
        if (shown.steps.isNotEmpty()) {
          StepTimeline(shown) { openStep = it.id }
          Spacer(Modifier.height(16.dp))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          RelevoButton(if (shown.steps.isEmpty()) "Agregar pasos" else "Editar pasos", { onEdit(shown.interest) }, kind = ButtonKind.Secondary, compact = true,
            icon = if (shown.steps.isEmpty()) KitIcon.AGREGAR else KitIcon.EDITAR)
          RelevoButton("Intereses", onChooseInterests, kind = ButtonKind.Secondary, compact = true, icon = KitIcon.PERFIL)
        }
        if (activeRelevo) {
          Spacer(Modifier.height(14.dp))
          Text("Tienes un relevo activo. Cuando termine, puedes preparar el siguiente.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
        }
      }
    }
  }

  val tapped = track?.steps?.firstOrNull { it.id == openStep }
  if (track != null && tapped != null) {
    val index = track.steps.indexOf(tapped)
    RelevoSheet(onDismiss = { openStep = null }, scrollable = false) {
      Text(if (index == track.currentIndex) "ESTÁS AQUÍ" else "PASO ${index + 1}", style = Relevo.type.label, color = Relevo.colors.graphite)
      Spacer(Modifier.height(6.dp))
      Text(tapped.activity, style = Relevo.type.title2, color = Relevo.colors.ink)
      if (tapped.firstStep.isNotBlank() || tapped.place.isNotBlank()) {
        Spacer(Modifier.height(14.dp))
        ListSection {
          if (tapped.firstStep.isNotBlank()) ListRow("Empiezas", icon = KitIcon.PRIMER_PASO, value = tapped.firstStep, valueIsVoice = true, titleColor = Relevo.colors.graphite)
          if (tapped.place.isNotBlank()) ListRow("Lugar", icon = KitIcon.LUGAR, value = tapped.place, valueIsVoice = true, titleColor = Relevo.colors.graphite)
        }
      }
      Spacer(Modifier.height(22.dp))
      if (!activeRelevo) {
        RelevoButton("Preparar este paso", { openStep = null; onPrepare(track.interest, tapped.id, photoKey("ruta", tapped.id)) })
        Spacer(Modifier.height(8.dp))
      }
      if (index != track.currentIndex) {
        RelevoButton("Marcar como el paso actual", { onSetCurrent(track.interest, index); openStep = null }, kind = ButtonKind.Secondary)
      }
    }
  }
}

/** Pasos en una línea vertical. El actual lleva el punto lleno y «Estás aquí»; los demás, el círculo vacío. */
@Composable
private fun StepTimeline(track: RouteTrack, onTap: (RouteStep) -> Unit) {
  val colors = Relevo.colors
  Column(Modifier.fillMaxWidth().clip(Relevo.panelShape).background(colors.card).padding(vertical = 8.dp)) {
    track.steps.forEachIndexed { index, step ->
      val current = index == track.currentIndex
      val first = index == 0
      val last = index == track.steps.lastIndex
      val interaction = remember { MutableInteractionSource() }
      Row(
        Modifier.fillMaxWidth().heightIn(min = 62.dp)
          .clickable(interactionSource = interaction, indication = null, role = Role.Button) { onTap(step) }
          .semantics { if (current) stateDescription = "Estás aquí" }
          .drawBehind {
            val x = 18.dp.toPx() + 11.dp.toPx()
            val stroke = 1.5.dp.toPx()
            val center = size.height / 2
            if (!first) drawLine(colors.line, Offset(x, 0f), Offset(x, center - 11.dp.toPx()), stroke)
            if (!last) drawLine(colors.line, Offset(x, center + 11.dp.toPx()), Offset(x, size.height), stroke)
          }
          .padding(start = 18.dp, end = 16.dp, top = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Box(Modifier.size(22.dp), contentAlignment = Alignment.Center) {
          if (current) Box(Modifier.size(16.dp).clip(CircleShape).background(colors.ink))
          else Box(Modifier.size(12.dp).border(1.75.dp, colors.gray, CircleShape))
        }
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
          if (current) Text("ESTÁS AQUÍ", style = Relevo.type.label, color = colors.graphite)
          Text(step.activity, style = if (current) Relevo.type.headline else Relevo.type.body, color = if (current) colors.ink else colors.graphite)
          if (current && (step.firstStep.isNotBlank() || step.place.isNotBlank())) {
            Text(listOf(step.firstStep, step.place).filter { it.isNotBlank() }.joinToString(" · "), style = Relevo.type.footnote, color = colors.graphite)
          }
        }
        RelevoIcon(KitIcon.SIGUIENTE, size = 16.dp, tint = colors.gray, background = colors.card, strokeWidth = 2.2f)
      }
    }
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
    bottom = { RelevoButton("Guardar", { onSave(draft) }, enabled = draft != track) },
  ) {
    Text("Cambia, reordena o agrega pasos.", style = Relevo.type.body, color = Relevo.colors.graphite)
    SectionGap()
    if (draft.steps.isNotEmpty()) {
      ListSection {
        draft.steps.forEachIndexed { index, step ->
          ListRow(
            step.activity,
            subtitle = listOf(step.firstStep, step.place).filter { it.isNotBlank() }.joinToString(" · ").ifBlank { null },
            leading = {
              Box(Modifier.size(30.dp).clip(CircleShape).background(if (index == draft.currentIndex) Relevo.colors.ink else Relevo.colors.mist), contentAlignment = Alignment.Center) {
                Text("${index + 1}", style = Relevo.type.subhead.copy(fontWeight = FontWeight.SemiBold), color = if (index == draft.currentIndex) Relevo.colors.onInk else Relevo.colors.ink)
              }
            },
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
                  if (index != draft.currentIndex) MenuItem("Marcar como el paso actual", KitIcon.LUGAR) { menuFor = null; draft = draft.moveTo(index) }
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

/** Un paso con los tres renglones: qué, cómo empieza y dónde. */
@Composable
private fun StepEditorSheet(step: RouteStep, isNew: Boolean, onDismiss: () -> Unit, onSave: (RouteStep) -> Unit) {
  var activity by rememberSaveable(step.id) { mutableStateOf(step.activity) }
  var first by rememberSaveable(step.id) { mutableStateOf(step.firstStep) }
  var place by rememberSaveable(step.id) { mutableStateOf(step.place) }
  RelevoSheet(onDismiss = onDismiss, title = if (isNew) "Nuevo paso" else "Editar el paso") {
    Spacer(Modifier.height(4.dp))
    RenglonField("Actividad", activity, { activity = it }, placeholder = "Ej.: caminar 30 minutos")
    Spacer(Modifier.height(20.dp))
    RenglonField("¿Cómo empiezas?", first, { first = it }, placeholder = "Ej.: ponerte las zapatillas")
    Spacer(Modifier.height(20.dp))
    RenglonField("Lugar", place, { place = it }, placeholder = "Ej.: junto a la puerta")
    Spacer(Modifier.height(24.dp))
    RelevoButton("Guardar el paso", { onSave(step.copy(activity = activity.trim(), firstStep = first.trim(), place = place.trim())) }, enabled = activity.isNotBlank())
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
    Text("¿Pruebas el siguiente paso?", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(16.dp))
    Panel(padding = 14.dp) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        val photo = interestPhoto(suggestion.interest)
        PictureContent(photo?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(interestIcon(suggestion.interest)), Modifier.size(52.dp).clip(CircleShape), iconSize = 24.dp)
        Spacer(Modifier.width(14.dp))
        Column(Modifier.weight(1f)) {
          Text(suggestion.next.activity, style = Relevo.type.headline, color = Relevo.colors.ink)
          if (suggestion.next.firstStep.isNotBlank()) Text(suggestion.next.firstStep, style = Relevo.type.footnote, color = Relevo.colors.graphite)
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

/** V2: tras dos «Ahora no» seguidos, se pregunta una sola vez si se apagan los avisos de regreso. */
@Composable
internal fun TurnOffReturnSheet(onAnswer: (Boolean) -> Unit) {
  RelevoSheet(onDismiss = { onAnswer(false) }, scrollable = false) {
    Text("¿Apagar los avisos de regreso?", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(8.dp))
    Text("Puedes volver a activarlos en Perfil.", style = Relevo.type.body, color = Relevo.colors.graphite)
    Spacer(Modifier.height(20.dp))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      RelevoButton("Apagar", { onAnswer(true) }, kind = ButtonKind.Secondary)
      RelevoButton("Mantenerlos", { onAnswer(false) }, kind = ButtonKind.Secondary)
    }
  }
}

