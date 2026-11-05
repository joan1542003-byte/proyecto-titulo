package com.example.relevo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.domain.RouteStep
import com.example.relevo.domain.RouteTrack
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.AddRingCell
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Carousel
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.RingCell
import com.example.relevo.ui.components.RingGrid
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SectionLabel
import com.example.relevo.ui.components.SegmentedControl
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.familyName
import com.example.relevo.ui.components.key
import com.example.relevo.ui.components.pictureIcon
import com.example.relevo.ui.components.rememberReduceMotion
import java.util.UUID

/** Las tres partes de Actividades (4.0): lo tuyo, tu ruta paso a paso y las ideas. */
internal enum class ActivitiesSection(val label: String) { MINE("Tuyas"), STEPS("Paso a paso"), IDEAS("Ideas") }

/** Lo que se puede hacer desde Actividades. */
internal class ActivitiesActions(
  val onPrepareCustom: (CustomActivity) -> Unit,
  val onPrepareIdea: (ActivityIdea) -> Unit,
  val onPrepareStep: (interest: String, stepId: String, photoKey: String?) -> Unit,
  val onNewActivity: () -> Unit,
  val onEditActivity: (String) -> Unit,
  val onSetCurrent: (interest: String, index: Int) -> Unit,
  val onEditRoute: (String) -> Unit,
  val onChooseInterests: () -> Unit,
)

/**
 * Actividades (4.0, D-155): todo lo que la persona quiere hacer, en un solo lugar y en tres partes que no
 * se mezclan. «Tuyas» son las que guardó; «Paso a paso», su ruta por interés (antes, la pestaña Ruta);
 * «Ideas», las de las entrevistas, por familia. Cada actividad es un anillo con su color y su ícono, la
 * pieza que el autor prefirió a las fichas de cielo con cápsula.
 */
@Composable
internal fun ActivitiesTab(
  section: ActivitiesSection,
  onSection: (ActivitiesSection) -> Unit,
  customActivities: List<CustomActivity>,
  routes: List<RouteTrack>,
  routeInterest: String?,
  onRouteInterest: (String) -> Unit,
  activeRelevo: Boolean,
  reselect: Int,
  actions: ActivitiesActions,
) {
  val scroll = rememberScrollState()
  var firstReselect by remember { mutableStateOf(reselect) }
  LaunchedEffect(reselect) { if (reselect != firstReselect) scroll.animateScrollTo(0) else firstReselect = reselect }
  val reduce = rememberReduceMotion()
  RelevoScreen(title = "Actividades", largeTitle = true, scrollState = scroll) {
    SegmentedControl(
      ActivitiesSection.entries.map { it.name to it.label }, section.name,
      { value -> value?.let { onSection(ActivitiesSection.valueOf(it)) } }, allowDeselect = false,
    )
    Spacer(Modifier.height(Gap.section))
    AnimatedContent(
      targetState = section,
      transitionSpec = { if (reduce) EnterTransition.None togetherWith ExitTransition.None else fadeIn(Motion.standard()) togetherWith fadeOut(Motion.standard(Motion.SHORT)) },
      label = "activities_section",
    ) { shown ->
      Column(Modifier.fillMaxWidth()) {
        when (shown) {
          ActivitiesSection.MINE -> MineSection(customActivities, actions)
          ActivitiesSection.STEPS -> StepsSection(routes, customActivities, routeInterest, onRouteInterest, activeRelevo, actions)
          ActivitiesSection.IDEAS -> IdeasSection(customActivities, actions)
        }
      }
    }
  }
}

/** Tus actividades: anillos de a tres y «Nueva» al final. Tocar una abre su hoja. */
@Composable
private fun MineSection(customActivities: List<CustomActivity>, actions: ActivitiesActions) {
  var shown by rememberSaveable { mutableStateOf<String?>(null) }
  if (customActivities.isEmpty()) {
    Panel(Modifier.appear(0)) {
      Text("Todavía no tienes actividades", style = Relevo.type.headline, color = Relevo.colors.ink)
      Text("Guarda lo que haces seguido, con cómo empiezas y dónde. Después lo preparas en un toque.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      Spacer(Modifier.height(6.dp))
      RelevoButton("Crear una actividad", actions.onNewActivity, icon = KitIcon.AGREGAR)
    }
    return
  }
  val cells: List<CustomActivity?> = customActivities + null
  RingGrid(cells, Modifier.appear(0), columns = 3) { custom ->
    if (custom == null) AddRingCell("Nueva", actions.onNewActivity, size = 72.dp)
    else RingCell(activityIcon(custom.name, customActivities), custom.name, { shown = custom.id }, size = 72.dp, variant = activityVariant(custom.name))
  }
  val selected = customActivities.firstOrNull { it.id == shown }
  if (selected != null) {
    ActivitySheet(
      name = selected.name, icon = activityIcon(selected.name, customActivities), firstStep = selected.firstStep, place = selected.place,
      onDismiss = { shown = null },
      primary = "Preparar un relevo" to { shown = null; actions.onPrepareCustom(selected) },
      secondary = "Editar" to { shown = null; actions.onEditActivity(selected.id) },
    )
  }
}

/** Ideas de las entrevistas, por familia: moverte, leer y aprender, crear, jugar, en casa y descansar. */
@Composable
private fun IdeasSection(customActivities: List<CustomActivity>, actions: ActivitiesActions) {
  var shown by rememberSaveable { mutableStateOf<String?>(null) }
  Column(Modifier.appear(0), verticalArrangement = Arrangement.spacedBy(Gap.section)) {
    ideasByFamily.forEach { (sky, ideas) ->
      Column {
        SectionLabel(sky.familyName, Modifier.padding(start = 4.dp, bottom = 14.dp))
        RingGrid(ideas, columns = 3) { idea ->
          RingCell(pictureIcon(idea.picture), idea.activity, { shown = idea.activity }, size = 72.dp, variant = activityVariant(idea.activity))
        }
      }
    }
  }
  val idea = activityIdeas.firstOrNull { it.activity == shown }
  if (idea != null) {
    ActivitySheet(
      name = idea.activity, icon = pictureIcon(idea.picture), firstStep = idea.start, place = idea.place,
      onDismiss = { shown = null },
      primary = "Preparar un relevo" to { shown = null; actions.onPrepareIdea(idea) },
      secondary = null,
    )
  }
}

/** Hoja de una actividad: su anillo, el nombre, cómo empieza y dónde, y lo que se puede hacer con ella. */
@Composable
private fun ActivitySheet(
  name: String,
  icon: KitIcon,
  firstStep: String,
  place: String,
  onDismiss: () -> Unit,
  primary: Pair<String, () -> Unit>,
  secondary: Pair<String, () -> Unit>?,
) {
  RelevoSheet(onDismiss = onDismiss, scrollable = false) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      ActivityRing(icon, 80.dp, variant = activityVariant(name))
      Spacer(Modifier.height(14.dp))
      Text(name, style = Relevo.type.title2, color = Relevo.colors.ink, textAlign = TextAlign.Center)
    }
    if (firstStep.isNotBlank() || place.isNotBlank()) {
      Spacer(Modifier.height(18.dp))
      ListSection {
        if (firstStep.isNotBlank()) ListRow(firstStep.trim(), icon = KitIcon.PRIMER_PASO, subtitle = "Para empezar")
        if (place.isNotBlank()) ListRow(place.trim(), icon = KitIcon.LUGAR, subtitle = "Dónde empiezas")
      }
    }
    Spacer(Modifier.height(22.dp))
    RelevoButton(primary.first, primary.second)
    if (secondary != null) {
      Spacer(Modifier.height(8.dp))
      RelevoButton(secondary.first, secondary.second, kind = ButtonKind.Secondary, icon = KitIcon.EDITAR)
    }
  }
}

/**
 * Paso a paso (antes, la pestaña Ruta; D-074): los pasos de un interés en orden, con el de ahora marcado.
 * Son sugerencias editables: la ruta no avanza sola ni muestra porcentajes, puntos o niveles. La escalera
 * de la 3.1 pasa a una lista numerada, más fácil de leer.
 */
@Composable
private fun StepsSection(
  routes: List<RouteTrack>,
  customActivities: List<CustomActivity>,
  selected: String?,
  onSelect: (String) -> Unit,
  activeRelevo: Boolean,
  actions: ActivitiesActions,
) {
  val track = routes.firstOrNull { it.interest == selected } ?: routes.firstOrNull()
  var openStep by rememberSaveable { mutableStateOf<String?>(null) }
  if (track == null) {
    Panel(Modifier.appear(0)) {
      Text("¿Qué te gustaría hacer más seguido?", style = Relevo.type.headline, color = Relevo.colors.ink)
      Text("Elige tus intereses y te sugerimos pasos pequeños para empezar. Los puedes cambiar.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      Spacer(Modifier.height(6.dp))
      RelevoButton("Elegir intereses", actions.onChooseInterests, icon = KitIcon.AGREGAR)
    }
    return
  }
  Column(Modifier.appear(0)) {
    if (routes.size > 1) {
      Carousel(spacing = 8.dp) {
        items(routes, key = { it.interest }) { item ->
          QuickChoice(item.title, item.interest == track.interest, { onSelect(item.interest) }, icon = interestIcon(item.interest))
        }
      }
      Spacer(Modifier.height(Gap.block))
    }
    val now = track.currentStep
    if (now == null) {
      Panel {
        Text(track.title, style = Relevo.type.headline, color = Relevo.colors.ink)
        Text("Todavía no tiene pasos.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
        RelevoButton("Agregar pasos", { actions.onEditRoute(track.interest) }, kind = ButtonKind.Secondary, compact = true, icon = KitIcon.AGREGAR)
      }
      return@Column
    }
    ListSection(title = track.title) {
      track.steps.forEachIndexed { index, step ->
        val current = index == track.currentIndex
        val past = index < track.currentIndex
        ListRow(
          step.activity,
          Modifier.semantics { if (current) stateDescription = "Paso actual" },
          subtitle = when { current -> "Ahora"; past -> "Hecho"; index == track.currentIndex + 1 -> "Siguiente"; else -> null },
          titleColor = if (past) Relevo.colors.graphite else Relevo.colors.ink,
          leading = { StepDot(index + 1, current = current, past = past) },
          chevron = true,
          onClick = { openStep = step.id },
        )
      }
    }
    Spacer(Modifier.height(Gap.block))
    if (activeRelevo) {
      Text("Tienes un relevo activo. Cuando termine, puedes preparar este paso.", style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
    } else {
      RelevoButton("Preparar este paso", { actions.onPrepareStep(track.interest, now.id, photoKey("ruta", now.id)) })
    }
    Spacer(Modifier.height(4.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
      PlainAction("Editar los pasos", { actions.onEditRoute(track.interest) })
      Text("·", style = Relevo.type.callout, color = Relevo.colors.graphite)
      PlainAction("Cambiar intereses", actions.onChooseInterests)
    }
  }

  val tapped = track.steps.firstOrNull { it.id == openStep }
  if (tapped != null) StepSheet(track, tapped, customActivities, activeRelevo, onDismiss = { openStep = null }, actions)
}

/** Un paso: su anillo, cómo y dónde empezar, prepararlo y moverse a él. */
@Composable
private fun StepSheet(track: RouteTrack, step: RouteStep, customActivities: List<CustomActivity>, activeRelevo: Boolean, onDismiss: () -> Unit, actions: ActivitiesActions) {
  val index = track.steps.indexOf(step)
  val isCurrent = index == track.currentIndex
  RelevoSheet(onDismiss = onDismiss, scrollable = false) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      ActivityRing(activityIcon(step.activity, customActivities), 80.dp, variant = activityVariant(step.activity))
      Spacer(Modifier.height(12.dp))
      Text(if (isCurrent) "Ahora" else "Paso ${index + 1} de ${track.steps.size}", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      Text(step.activity, style = Relevo.type.title2, color = Relevo.colors.ink, textAlign = TextAlign.Center)
    }
    if (step.firstStep.isNotBlank() || step.place.isNotBlank()) {
      Spacer(Modifier.height(16.dp))
      ListSection {
        if (step.firstStep.isNotBlank()) ListRow(step.firstStep.trim(), icon = KitIcon.PRIMER_PASO, subtitle = "Para empezar")
        if (step.place.isNotBlank()) ListRow(step.place.trim(), icon = KitIcon.LUGAR, subtitle = "Dónde empiezas")
      }
    }
    Spacer(Modifier.height(22.dp))
    if (!activeRelevo) {
      RelevoButton("Preparar este paso", { onDismiss(); actions.onPrepareStep(track.interest, step.id, photoKey("ruta", step.id)) })
      Spacer(Modifier.height(8.dp))
    }
    if (!isCurrent) {
      RelevoButton(if (index > track.currentIndex) "Pasar a este paso" else "Volver a este paso", { actions.onSetCurrent(track.interest, index); onDismiss() }, kind = ButtonKind.Secondary)
    }
  }
}

/** Íconos que se pueden elegir para una actividad propia (21, del grupo «Actividades» del kit). */
internal val activityIcons = listOf(
  KitIcon.LEER, KitIcon.ESCRIBIR, KitIcon.DIBUJAR, KitIcon.PINTAR, KitIcon.GUITARRA, KitIcon.MUSICA, KitIcon.CAMINAR,
  KitIcon.BICICLETA, KitIcon.EJERCICIO, KitIcon.ESTIRAR, KitIcon.COCINAR, KitIcon.PLANTAS, KitIcon.DORMIR, KitIcon.LLAMAR,
  KitIcon.CARTA, KitIcon.ORDENAR, KitIcon.ESTUDIAR, KitIcon.FOTOGRAFIA, KitIcon.MANUALIDADES, KitIcon.JUEGO_DE_MESA, KitIcon.SALIR,
  KitIcon.VIDEOJUEGOS, KitIcon.REPRODUCIR,
)

/**
 * Crear o editar una actividad propia (4.0): arriba su anillo, que se cambia en una hoja de anillos (la
 * pieza que dio origen al rediseño), y tres renglones: la actividad, cómo empieza y dónde. Si la persona no
 * elige un ícono, lo sugieren las palabras del nombre.
 */
@Composable
internal fun ActivityEditScreen(initial: CustomActivity?, existing: List<CustomActivity>, onSave: (CustomActivity) -> Unit, onDelete: (String) -> Unit, onBack: () -> Unit) {
  var name by rememberSaveable { mutableStateOf(initial?.name.orEmpty()) }
  var first by rememberSaveable { mutableStateOf(initial?.firstStep.orEmpty()) }
  var place by rememberSaveable { mutableStateOf(initial?.place.orEmpty()) }
  var image by rememberSaveable { mutableStateOf(initial?.icon?.let { Picture.parse(it) }?.let { pictureIcon(it).key }.orEmpty()) }
  var confirmDelete by rememberSaveable { mutableStateOf(false) }
  var picking by rememberSaveable { mutableStateOf(false) }
  val duplicate = activityIdeas.any { it.activity.equals(name.trim(), true) } || existing.any { it.id != initial?.id && it.name.equals(name.trim(), true) }
  val icon = pictureIcon(Picture.parse(image) ?: pictureForActivity(name, emptyList()))
  RelevoScreen(
    title = if (initial == null) "Nueva actividad" else "Editar la actividad",
    onBack = onBack, closeIcon = initial == null, backLabel = "Cancelar",
    bottom = {
      GuardedButton("Guardar", {
        onSave(CustomActivity(initial?.id ?: UUID.randomUUID().toString(), name.trim(), first.trim(), place.trim(), image.ifBlank { icon.key }, 0))
      }, missing = when {
        name.trim().length < 2 -> "Escribe el nombre de la actividad."
        name.trim().length > 60 -> "Usa hasta 60 caracteres en el nombre."
        duplicate -> "Ya tienes una actividad con ese nombre."
        first.isBlank() -> "Escribe cómo empiezas."
        place.isBlank() -> "Escribe dónde empiezas."
        else -> null
      })
    },
  ) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      RingCell(icon, null, { picking = true }, size = 96.dp, variant = activityVariant(name), description = "Cambiar el ícono")
      PlainAction("Cambiar el ícono", { picking = true })
    }
    Spacer(Modifier.height(Gap.block))
    RenglonField("Actividad", name, { name = it.take(60) }, placeholder = "Ej.: practicar guitarra")
    if (duplicate) { Spacer(Modifier.height(6.dp)); Text("Ya tienes una actividad con ese nombre.", style = Relevo.type.footnote, color = Relevo.colors.error) }
    Spacer(Modifier.height(Gap.list))
    RenglonField("Para empezar", first, { first = it.take(120) }, placeholder = "Ej.: sacar la guitarra del estuche", icon = KitIcon.PRIMER_PASO)
    Spacer(Modifier.height(Gap.list))
    RenglonField("Dónde empiezas", place, { place = it.take(120) }, placeholder = "Ej.: junto a la guitarra", icon = KitIcon.LUGAR)
    if (initial != null) {
      SectionGap()
      RelevoButton("Borrar la actividad", { confirmDelete = true }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
    }
  }
  if (picking) {
    RelevoSheet(onDismiss = { picking = false }, title = "Elige un ícono", done = "Listo", tall = true) {
      Spacer(Modifier.height(6.dp))
      RingGrid(activityIcons, columns = 4) { option ->
        RingCell(option, null, { image = option.key }, size = 60.dp, selected = icon == option, description = option.label)
      }
      Spacer(Modifier.height(12.dp))
    }
  }
  if (confirmDelete && initial != null) {
    RelevoSheet(onDismiss = { confirmDelete = false }, scrollable = false) {
      Text("¿Borrar «${initial.name}»?", style = Relevo.type.title2, color = Relevo.colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Se quita de tus actividades. Los relevos que ya hiciste se mantienen.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Borrar", { confirmDelete = false; onDelete(initial.id) }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
      Spacer(Modifier.height(8.dp))
      RelevoButton("Cancelar", { confirmDelete = false }, kind = ButtonKind.Secondary)
    }
  }
}
