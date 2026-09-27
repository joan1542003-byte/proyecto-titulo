package com.example.relevo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.data.CustomActivity
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.RouteTrack
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.StudyCondition
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.DurationStepper
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.PhotoHero
import com.example.relevo.ui.components.PhotoImage
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PictureContent
import com.example.relevo.ui.components.PictureTile
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RadioMark
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SearchField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.key
import com.example.relevo.ui.components.pressScale
import com.example.relevo.ui.components.rememberReduceMotion
import com.example.relevo.ui.components.sharedPhoto
import java.util.UUID

private enum class PrepareStep(val title: String) {
  ACTIVITY("¿Qué quieres hacer?"),
  START("¿Cómo empiezas?"),
  PLACE("¿Dónde empiezas?"),
  USAGE("¿Cuándo te avisa?"),
  SOUND("¿Cómo te avisa?"),
  REVIEW("Todo listo"),
}

/** En la semana del parlante en otro lugar, el lugar que se anota es el del parlante, no el del comienzo. */
private fun PrepareStep.titleFor(condition: StudyCondition?): String =
  if (this == PrepareStep.PLACE && condition == StudyCondition.NEUTRAL) "¿Dónde dejas el parlante?" else title

internal class PrepareActions(
  val onActivity: (String) -> Unit,
  val onStart: (String) -> Unit,
  val onPlace: (String) -> Unit,
  val onIdea: (String, String, String) -> Unit,
  val onRouteStep: (interest: String, stepId: String) -> Boolean,
  val onToggleApp: (InstalledApp) -> Unit,
  val onDuration: (Int) -> Unit,
  val onRoute: (SignalRoute) -> Unit,
  val onTestSound: () -> Boolean,
  val onUsageSettings: () -> Unit,
  val onBackground: () -> Unit,
  val onSaveCustom: (CustomActivity) -> Unit,
  val onActivate: () -> Unit,
  val onClose: () -> Unit,
)

/**
 * B2: seis pasos con avance continuo. «Seguir» ocupa siempre el mismo lugar y volver con el gesto
 * conserva lo escrito. Una idea elegida en Inicio llega con su foto, que viaja a esta pantalla; un
 * relevo repetido llega completo y abre en la revisión.
 */
@Composable
internal fun PrepareScreen(
  reminder: Reminder,
  apps: List<InstalledApp>,
  customActivities: List<CustomActivity>,
  routes: List<RouteTrack>,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  studyCondition: StudyCondition?,
  photoKey: String?,
  actions: PrepareActions,
) {
  // Se abre en el primer dato que falta: una idea elegida ya trae actividad, comienzo y lugar.
  var step by rememberSaveable {
    mutableStateOf(
      when {
        reminder.hasRequiredContent -> PrepareStep.REVIEW
        reminder.activity.isNotBlank() && reminder.howToStart.isNotBlank() && reminder.place.isNotBlank() -> PrepareStep.USAGE
        else -> PrepareStep.ACTIVITY
      },
    )
  }
  var forward by remember { mutableStateOf(true) }
  var picking by rememberSaveable { mutableStateOf(false) }
  var saveActivity by rememberSaveable { mutableStateOf(false) }
  val reduce = rememberReduceMotion()
  fun go(to: PrepareStep) { forward = to.ordinal > step.ordinal; step = to }
  fun back() = if (step == PrepareStep.ACTIVITY) actions.onClose() else go(PrepareStep.entries[step.ordinal - 1])
  BackHandler(enabled = !picking) { back() }

  val canContinue = when (step) {
    PrepareStep.ACTIVITY -> reminder.activity.isNotBlank()
    PrepareStep.START -> reminder.howToStart.isNotBlank()
    PrepareStep.PLACE -> reminder.place.isNotBlank()
    PrepareStep.USAGE -> reminder.selectedApps.isNotEmpty() && usageAccess
    PrepareStep.SOUND -> true
    PrepareStep.REVIEW -> reminder.hasRequiredContent && usageAccess
  }
  val isKnown = activityIdeas.any { it.activity.equals(reminder.activity.trim(), true) } || customActivities.any { it.name.equals(reminder.activity.trim(), true) }
  val picture = activityPicture(reminder.activity, customActivities)

  RelevoScreen(
    title = step.titleFor(studyCondition),
    onBack = { back() },
    closeIcon = step == PrepareStep.ACTIVITY,
    backLabel = if (step == PrepareStep.ACTIVITY) "Cerrar" else "Volver",
    step = "${step.ordinal + 1} de ${PrepareStep.entries.size}",
    progress = (step.ordinal + 1f) / PrepareStep.entries.size,
    header = if (step != PrepareStep.ACTIVITY && step != PrepareStep.REVIEW && reminder.activity.isNotBlank()) ({
      ActivityHeader(reminder.activity, picture, photoKey) { go(PrepareStep.ACTIVITY) }
    }) else null,
    bottom = {
      if (step == PrepareStep.REVIEW) {
        RelevoButton("Activar el relevo", {
          if (saveActivity && !isKnown) {
            val image = (picture as? Picture.OfPhoto)?.photo?.key ?: (picture as? Picture.OfIcon)?.icon?.key ?: KitIcon.ACTIVIDAD.key
            actions.onSaveCustom(CustomActivity(UUID.randomUUID().toString(), reminder.activity.trim(), reminder.howToStart.trim(), reminder.place.trim(), image, 0))
          }
          actions.onActivate()
        }, enabled = canContinue)
      } else {
        RelevoButton("Seguir", { go(PrepareStep.entries[step.ordinal + 1]) }, enabled = canContinue)
      }
    },
  ) {
    AnimatedContent(
      targetState = step,
      transitionSpec = {
        if (reduce) EnterTransition.None togetherWith ExitTransition.None
        else if (forward) (slideInHorizontally(Motion.smooth()) { it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.smooth()) { -it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
        else (slideInHorizontally(Motion.smooth()) { -it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.smooth()) { it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
      },
      label = "prepare_step",
    ) { current ->
      Column(Modifier.fillMaxWidth()) {
        when (current) {
          PrepareStep.ACTIVITY -> ActivityStep(reminder, customActivities, routes, actions, onNext = { if (reminder.activity.isNotBlank()) go(PrepareStep.START) })
          PrepareStep.START -> {
            Text("Lo primero que harías, en pocas palabras.", style = Relevo.type.body, color = Relevo.colors.graphite)
            SectionGap()
            RenglonField("Para empezar", reminder.howToStart, actions.onStart, placeholder = "Ej.: sacar la guitarra del estuche", imeAction = ImeAction.Next, onImeAction = { if (canContinue) go(PrepareStep.PLACE) })
          }
          PrepareStep.PLACE -> PlaceStep(reminder, studyCondition, actions, onNext = { if (canContinue) go(PrepareStep.USAGE) })
          PrepareStep.USAGE -> UsageStep(reminder, usageAccess, actions, onPick = { picking = true })
          PrepareStep.SOUND -> SoundStep(reminder, studyCondition, actions)
          PrepareStep.REVIEW -> {
            PhotoHero(picture, aspect = 1.25f, wide = true, sharedKey = photoKey) {
              Signature(reminder.activity, style = Relevo.type.title)
            }
            SectionGap()
            ListSection {
              FactRow(KitIcon.PRIMER_PASO, "Para empezar", reminder.howToStart) { go(PrepareStep.START) }
              FactRow(KitIcon.LUGAR, if (studyCondition == StudyCondition.NEUTRAL) "Parlante" else "Dónde empiezas", reminder.place) { go(PrepareStep.PLACE) }
              FactRow(KitIcon.APPS, "Apps que cuentan", reminder.selectedApps.joinToString(", ") { it.label }, valueIsVoice = false) { go(PrepareStep.USAGE) }
              FactRow(KitIcon.USO, "Te avisa después de", formatDuration(reminder.requiredUsageSeconds), valueIsVoice = false) { go(PrepareStep.USAGE) }
              FactRow(if (reminder.signalRoute == SignalRoute.PHONE) KitIcon.TELEFONO else KitIcon.PARLANTE, "Te avisa",
                if (reminder.signalRoute == SignalRoute.PHONE) "El teléfono" else "El parlante", valueIsVoice = false) { go(PrepareStep.SOUND) }
            }
            if (!isKnown && reminder.activity.isNotBlank()) {
              Spacer(Modifier.height(10.dp))
              Row(
                Modifier.fillMaxWidth().heightIn(min = 52.dp).padding(horizontal = 4.dp)
                  .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { saveActivity = !saveActivity },
                verticalAlignment = Alignment.CenterVertically,
              ) {
                CheckMark(saveActivity)
                Spacer(Modifier.width(12.dp))
                Text("Guardar en tus actividades para la próxima vez", style = Relevo.type.subhead, color = Relevo.colors.ink)
              }
            }
            if (!backgroundUnrestricted) {
              SectionGap()
              Notice(BATTERY_TEXT, title = "Batería", icon = KitIcon.BATERIA) {
                PlainAction("Quitar la restricción", actions.onBackground)
              }
            }
          }
        }
      }
    }
  }

  if (picking) AppPickerSheet(apps, reminder.selectedApps.map { it.packageName }.toSet(), actions.onToggleApp) { picking = false }
}

/** La actividad elegida acompaña cada paso: su foto en un círculo y «Vuelve a ___.» con las palabras de la persona. */
@Composable
private fun ActivityHeader(activity: String, picture: Picture, photoKey: String?, onEdit: () -> Unit) {
  Row(
    Modifier.fillMaxWidth().clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Button, onClickLabel = "Cambiar la actividad", onClick = onEdit)
      .padding(top = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    PictureContent(picture, Modifier.size(56.dp).sharedPhoto(photoKey).clip(CircleShape), iconSize = 24.dp)
    Spacer(Modifier.width(14.dp))
    Signature(activity, style = Relevo.type.title2, animate = false, modifier = Modifier.weight(1f))
  }
}

/** Paso 1: el renglón para escribir y, debajo, los pasos de la ruta, ideas con foto y las actividades propias. */
@Composable
private fun ActivityStep(reminder: Reminder, customActivities: List<CustomActivity>, routes: List<RouteTrack>, actions: PrepareActions, onNext: () -> Unit) {
  RenglonField("Actividad", reminder.activity, actions.onActivity, placeholder = "Ej.: leer", imeAction = ImeAction.Next, onImeAction = onNext)
  val steps = routes.mapNotNull { track -> track.currentStep?.let { track to it } }
  if (steps.isNotEmpty()) {
    SectionGap()
    GroupLabel("Tu ruta")
    TileGrid(steps.map { (track, step) ->
      Tile(step.activity, interestPhoto(track.interest)?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(interestIcon(track.interest)),
        reminder.activity.equals(step.activity, true)) { actions.onRouteStep(track.interest, step.id) }
    })
  }
  SectionGap()
  GroupLabel("Ideas")
  TileGrid(activityIdeas.map { idea ->
    Tile(idea.activity, idea.picture, reminder.activity.equals(idea.activity, true)) { actions.onIdea(idea.activity, idea.start, idea.place) }
  })
  if (customActivities.isNotEmpty()) {
    SectionGap()
    GroupLabel("Tus actividades")
    TileGrid(customActivities.map { custom ->
      Tile(custom.name, Picture.parse(custom.icon) ?: pictureForActivity(custom.name, emptyList()), reminder.activity.equals(custom.name, true)) {
        actions.onIdea(custom.name, custom.firstStep, custom.place)
      }
    })
  }
}

@Composable
private fun GroupLabel(text: String) {
  Text(text, style = Relevo.type.section, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, bottom = 12.dp))
}

private class Tile(val label: String, val picture: Picture, val selected: Boolean, val onClick: () -> Unit)

/** Fichas de 4:5 en tres columnas, con el nombre debajo. */
@Composable
private fun TileGrid(tiles: List<Tile>) {
  tiles.chunked(3).forEach { row ->
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
      row.forEach { tile -> PictureTile(tile.picture, tile.selected, tile.onClick, Modifier.weight(1f), label = tile.label, cornerRadius = 20.dp) }
      repeat(3 - row.size) { Spacer(Modifier.weight(1f)) }
    }
    Spacer(Modifier.height(14.dp))
  }
}

/** Paso 3: dónde empieza la actividad, que es donde se deja el parlante. La foto muestra la idea. */
@Composable
private fun PlaceStep(reminder: Reminder, studyCondition: StudyCondition?, actions: PrepareActions, onNext: () -> Unit) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    if (studyCondition != StudyCondition.PHONE && studyCondition != StudyCondition.NEUTRAL) {
      PhotoImage(Photo.PUERTA, Modifier.size(72.dp).clip(CircleShape))
      Spacer(Modifier.width(16.dp))
    }
    Column(Modifier.weight(1f)) {
      Text(
        when (studyCondition) {
          null -> "Deja el parlante ahí, junto a lo que necesitas para empezar."
          StudyCondition.PHONE -> "${conditionInstruction(studyCondition)} Anota dónde está lo que necesitas para empezar."
          else -> conditionInstruction(studyCondition)
        },
        style = Relevo.type.body, color = Relevo.colors.graphite,
      )
      studyCondition?.let(::conditionDetail)?.let { Spacer(Modifier.height(6.dp)); Text(it, style = Relevo.type.footnote, color = Relevo.colors.graphite) }
    }
  }
  SectionGap()
  RenglonField(
    when (studyCondition) {
      StudyCondition.NEUTRAL -> "Dónde está el parlante"
      else -> "Dónde empiezas"
    },
    reminder.place, actions.onPlace,
    placeholder = if (studyCondition == StudyCondition.NEUTRAL) "Ej.: en la repisa del living" else "Ej.: junto a las zapatillas",
    onImeAction = onNext,
  )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun UsageStep(reminder: Reminder, usageAccess: Boolean, actions: PrepareActions, onPick: () -> Unit) {
  Text("Te avisa cuando sumes este tiempo en las apps que elijas.", style = Relevo.type.body, color = Relevo.colors.graphite)
  if (!usageAccess) {
    SectionGap()
    Notice("Relevo necesita el permiso de Tiempo de uso para contar.", title = "Falta un permiso", icon = KitIcon.PERMISO) {
      PlainAction("Dar el permiso", actions.onUsageSettings)
    }
  }
  SectionGap()
  ListSection(title = "Apps que cuentan") {
    reminder.selectedApps.forEach { app ->
      ListRow(app.label, leading = { AppIcon(app.packageName, 32.dp) }, leadingWidth = 32.dp)
    }
    ListRow(if (reminder.selectedApps.isEmpty()) "Elegir apps" else "Cambiar apps", icon = if (reminder.selectedApps.isEmpty()) KitIcon.AGREGAR else KitIcon.EDITAR, chevron = true, onClick = onPick)
  }
  SectionGap()
  DurationStepper(reminder.requiredUsageSeconds, actions.onDuration, "en esas apps")
  Spacer(Modifier.height(16.dp))
  FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    listOf(15 * 60, 30 * 60, 60 * 60, 2 * 60 * 60).forEach { seconds ->
      QuickChoice(formatDuration(seconds), reminder.requiredUsageSeconds == seconds, { actions.onDuration(seconds) })
    }
  }
  Spacer(Modifier.height(8.dp))
  PlainAction("Probar con 15 segundos", { actions.onDuration(15) }, color = Relevo.colors.graphite, icon = KitIcon.TIEMPO)
}

@Composable
private fun SoundStep(reminder: Reminder, studyCondition: StudyCondition?, actions: PrepareActions) {
  val context = LocalContext.current
  var speakerConnected by remember { mutableStateOf(bluetoothSpeakerConnected(context)) }
  var tested by rememberSaveable { mutableIntStateOf(0) } // 0 sin probar, 1 sonó, 2 falló
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { speakerConnected = bluetoothSpeakerConnected(context) }
  Text(
    if (studyCondition != null) "Esta semana lo decide la prueba: ${conditionName(studyCondition).lowercase()}."
    else "Prueba cómo suena antes de activarlo.",
    style = Relevo.type.body, color = Relevo.colors.graphite,
  )
  SectionGap()
  Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    SoundOption(KitIcon.PARLANTE, "El parlante", if (speakerConnected) "Conectado por Bluetooth" else "Sin parlante conectado",
      selected = reminder.signalRoute == SignalRoute.BLUETOOTH, enabled = studyCondition == null) { actions.onRoute(SignalRoute.BLUETOOTH) }
    SoundOption(KitIcon.TELEFONO, "El teléfono", "Suena donde esté el teléfono",
      selected = reminder.signalRoute == SignalRoute.PHONE, enabled = studyCondition == null) { actions.onRoute(SignalRoute.PHONE) }
  }
  SectionGap()
  RelevoButton("Probar el sonido", { tested = if (actions.onTestSound()) 1 else 2 }, kind = ButtonKind.Secondary, icon = KitIcon.PROBAR)
  Spacer(Modifier.height(12.dp))
  AnimatedVisibility(tested != 0, enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut()) {
    when (tested) {
      1 -> Text("Así va a sonar.", style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.padding(horizontal = 4.dp))
      else -> Notice(if (reminder.signalRoute == SignalRoute.BLUETOOTH) "No sonó en el parlante. Revisa que esté encendido y conectado." else "No sonó en el teléfono. Revisa el volumen.", tone = Tone.Error)
    }
  }
  if (reminder.signalRoute == SignalRoute.BLUETOOTH) {
    Spacer(Modifier.height(8.dp))
    Text("Si tu parlante se apaga solo, no sonará.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
  }
}

/** Opción de salida en una tarjeta redondeada: la elegida lleva un anillo de tinta. */
@Composable
private fun SoundOption(icon: KitIcon, title: String, subtitle: String, selected: Boolean, enabled: Boolean, onClick: () -> Unit) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val ring by animateColorAsState(if (selected) colors.ink else Color.Transparent, Motion.standard(Motion.SHORT), label = "sound_ring")
  Row(
    Modifier.fillMaxWidth().pressScale(interaction, 0.98f).clip(Relevo.panelShape).background(colors.card)
      .border(2.dp, ring, Relevo.panelShape)
      .clickable(interactionSource = interaction, indication = null, enabled = enabled, role = Role.RadioButton, onClick = onClick)
      .semantics { this.selected = selected }
      .padding(18.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Box(Modifier.size(48.dp).clip(CircleShape).background(colors.mist), contentAlignment = Alignment.Center) {
      RelevoIcon(icon, size = 24.dp, background = colors.mist)
    }
    Spacer(Modifier.width(16.dp))
    Column(Modifier.weight(1f)) {
      Text(title, style = Relevo.type.headline, color = if (enabled || selected) colors.ink else colors.graphite)
      Text(subtitle, style = Relevo.type.footnote, color = colors.graphite)
    }
    if (enabled || selected) RadioMark(selected)
  }
}

/** Selector de apps en una hoja alta, con buscador y marca redonda. */
@Composable
private fun AppPickerSheet(apps: List<InstalledApp>, selected: Set<String>, onToggle: (InstalledApp) -> Unit, onDismiss: () -> Unit) {
  var query by rememberSaveable { mutableStateOf("") }
  val visible = remember(apps, query) { apps.filter { it.label.contains(query.trim(), ignoreCase = true) } }
  val colors = Relevo.colors
  RelevoSheet(onDismiss = onDismiss, title = "Elige las apps", done = "Listo", scrollable = false, tall = true) {
    SearchField(query, { query = it }, "Buscar")
    Spacer(Modifier.height(12.dp))
    LazyColumn(Modifier.fillMaxWidth().weight(1f).clip(Relevo.panelShape).background(colors.card)) {
      itemsIndexed(visible, key = { _, app -> app.packageName }) { index, app ->
        ListRow(app.label, leading = { AppIcon(app.packageName, 32.dp) }, leadingWidth = 32.dp, onClick = { onToggle(app) }, trailing = { CheckMark(app.packageName in selected) }, divider = index > 0)
      }
    }
  }
}
