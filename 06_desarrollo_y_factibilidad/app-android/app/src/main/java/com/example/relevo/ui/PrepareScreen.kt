package com.example.relevo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.example.relevo.ui.components.PhotoImage
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PictureContent
import com.example.relevo.ui.components.PictureTile
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RadioMark
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SearchField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.key
import com.example.relevo.ui.components.rememberReduceMotion
import com.example.relevo.ui.components.sharedPhoto
import java.util.UUID

private enum class PrepareStep(val title: String) {
  ACTIVITY("¿Qué quieres hacer?"),
  START("¿Cómo empezarás?"),
  PLACE("¿Dónde lo dejas?"),
  USAGE("¿Después de cuánto uso?"),
  SOUND("¿Dónde sonará?"),
  REVIEW("Revisa tu relevo"),
}

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
    title = step.title,
    onBack = { back() },
    backLabel = if (step == PrepareStep.ACTIVITY) "Cancelar" else "Volver",
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
            Text("Una acción breve y concreta, lo primero que harías.", style = Relevo.type.body, color = Relevo.colors.graphite)
            SectionGap()
            RenglonField("Primer paso", reminder.howToStart, actions.onStart, placeholder = "Ejemplo: sacar la guitarra del estuche", imeAction = ImeAction.Next, onImeAction = { if (canContinue) go(PrepareStep.PLACE) })
          }
          PrepareStep.PLACE -> PlaceStep(reminder, studyCondition, actions, onNext = { if (canContinue) go(PrepareStep.USAGE) })
          PrepareStep.USAGE -> UsageStep(reminder, usageAccess, actions, onPick = { picking = true })
          PrepareStep.SOUND -> SoundStep(reminder, studyCondition, actions)
          PrepareStep.REVIEW -> {
            PictureContent(picture, Modifier.fillMaxWidth().aspectRatio(1.5f).sharedPhoto(photoKey).clip(Relevo.panelShape), iconSize = 56.dp, wide = true)
            Spacer(Modifier.height(20.dp))
            Signature(reminder.activity)
            SectionGap()
            ListSection {
              FactRow(KitIcon.PRIMER_PASO, "Cómo empieza", reminder.howToStart) { go(PrepareStep.START) }
              FactRow(KitIcon.LUGAR, "Lugar", reminder.place) { go(PrepareStep.PLACE) }
              FactRow(KitIcon.APPS, "Apps", reminder.selectedApps.joinToString(", ") { it.label }, valueIsVoice = false) { go(PrepareStep.USAGE) }
              FactRow(KitIcon.USO, "Suena después de", formatDuration(reminder.requiredUsageSeconds), valueIsVoice = false) { go(PrepareStep.USAGE) }
              FactRow(if (reminder.signalRoute == SignalRoute.PHONE) KitIcon.TELEFONO else KitIcon.PARLANTE, "Suena en",
                if (reminder.signalRoute == SignalRoute.PHONE) "Este teléfono" else "El parlante", valueIsVoice = false) { go(PrepareStep.SOUND) }
            }
            if (!isKnown && reminder.activity.isNotBlank()) {
              Spacer(Modifier.height(8.dp))
              Row(
                Modifier.fillMaxWidth().heightIn(min = 52.dp)
                  .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { saveActivity = !saveActivity },
                verticalAlignment = Alignment.CenterVertically,
              ) {
                CheckMark(saveActivity)
                Spacer(Modifier.width(12.dp))
                Text("Guardar «${reminder.activity.trim()}» en tus actividades", style = Relevo.type.subhead, color = Relevo.colors.ink)
              }
            }
            if (!backgroundUnrestricted) {
              SectionGap()
              Notice("Algunos teléfonos detienen apps para ahorrar batería. Para usar Relevo varios días, permite que funcione sin esa restricción.",
                title = "Funcionamiento en segundo plano", icon = KitIcon.BATERIA) { PlainAction("Permitir", actions.onBackground) }
            }
          }
        }
      }
    }
  }

  if (picking) AppPickerSheet(apps, reminder.selectedApps.map { it.packageName }.toSet(), actions.onToggleApp) { picking = false }
}

/** La actividad elegida acompaña cada paso: su foto y «Vuelve a ___.» con las palabras de la persona. */
@Composable
private fun ActivityHeader(activity: String, picture: Picture, photoKey: String?, onEdit: () -> Unit) {
  Row(
    Modifier.fillMaxWidth().clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Button, onClickLabel = "Cambiar la actividad", onClick = onEdit)
      .padding(top = 14.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    PictureContent(picture, Modifier.size(52.dp, 65.dp).sharedPhoto(photoKey).clip(RoundedCornerShape(10.dp)), iconSize = 24.dp)
    Spacer(Modifier.width(14.dp))
    Signature(activity, style = Relevo.type.title2, animate = false, modifier = Modifier.weight(1f))
  }
}

/** Paso 1: el renglón para escribir y, debajo, ideas con foto, los pasos de la ruta y las actividades propias. */
@Composable
private fun ActivityStep(reminder: Reminder, customActivities: List<CustomActivity>, routes: List<RouteTrack>, actions: PrepareActions, onNext: () -> Unit) {
  RenglonField("Actividad", reminder.activity, actions.onActivity, placeholder = "Ejemplo: leer", imeAction = ImeAction.Next, onImeAction = onNext)
  val steps = routes.mapNotNull { track -> track.currentStep?.let { track to it } }
  if (steps.isNotEmpty()) {
    SectionGap()
    Text("TU RUTA", style = Relevo.type.label, color = Relevo.colors.graphite)
    Spacer(Modifier.height(10.dp))
    TileGrid(steps.map { (track, step) ->
      Tile(step.activity, interestPhoto(track.interest)?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(interestIcon(track.interest)),
        reminder.activity.equals(step.activity, true)) { actions.onRouteStep(track.interest, step.id) }
    })
  }
  SectionGap()
  Text("IDEAS", style = Relevo.type.label, color = Relevo.colors.graphite)
  Spacer(Modifier.height(10.dp))
  TileGrid(activityIdeas.map { idea ->
    Tile(idea.activity, idea.picture, reminder.activity.equals(idea.activity, true)) { actions.onIdea(idea.activity, idea.start, idea.place) }
  })
  if (customActivities.isNotEmpty()) {
    SectionGap()
    Text("TUS ACTIVIDADES", style = Relevo.type.label, color = Relevo.colors.graphite)
    Spacer(Modifier.height(10.dp))
    TileGrid(customActivities.map { custom ->
      Tile(custom.name, Picture.parse(custom.icon) ?: pictureForActivity(custom.name, emptyList()), reminder.activity.equals(custom.name, true)) {
        actions.onIdea(custom.name, custom.firstStep, custom.place)
      }
    })
  }
}

private class Tile(val label: String, val picture: Picture, val selected: Boolean, val onClick: () -> Unit)

/** Fichas de 4:5 en tres columnas, con el nombre debajo. */
@Composable
private fun TileGrid(tiles: List<Tile>) {
  tiles.chunked(3).forEach { row ->
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
      row.forEach { tile -> PictureTile(tile.picture, tile.selected, tile.onClick, Modifier.weight(1f), label = tile.label) }
      repeat(3 - row.size) { Spacer(Modifier.weight(1f)) }
    }
    Spacer(Modifier.height(12.dp))
  }
}

/** Paso 3: dónde se deja el parlante. La foto muestra la idea: el objeto junto a lo que se necesita para empezar. */
@Composable
private fun PlaceStep(reminder: Reminder, studyCondition: StudyCondition?, actions: PrepareActions, onNext: () -> Unit) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    if (studyCondition != StudyCondition.PHONE && studyCondition != StudyCondition.NEUTRAL) {
      PhotoImage(Photo.PUERTA, Modifier.size(76.dp, 95.dp).clip(RoundedCornerShape(12.dp)))
      Spacer(Modifier.width(14.dp))
    }
    Column(Modifier.weight(1f)) {
      Text(
        when (studyCondition) {
          null -> "Deja el parlante junto a lo que necesitas para empezar."
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
      StudyCondition.PHONE -> "Lo que necesitas está"
      StudyCondition.NEUTRAL -> "El parlante está"
      else -> "Lugar"
    },
    reminder.place, actions.onPlace,
    placeholder = if (studyCondition == StudyCondition.NEUTRAL) "Ejemplo: en la repisa del living" else "Ejemplo: junto a las zapatillas",
    onImeAction = onNext,
  )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun UsageStep(reminder: Reminder, usageAccess: Boolean, actions: PrepareActions, onPick: () -> Unit) {
  Text("El tiempo de estas apps se suma hasta llegar al límite.", style = Relevo.type.body, color = Relevo.colors.graphite)
  if (!usageAccess) {
    SectionGap()
    Notice("Para contar el tiempo, Android pide el permiso de Tiempo de uso.", title = "Falta un permiso", icon = KitIcon.PERMISO) {
      PlainAction("Abrir ajustes de Android", actions.onUsageSettings)
    }
  }
  SectionGap()
  ListSection(title = "Apps elegidas") {
    reminder.selectedApps.forEach { app ->
      ListRow(app.label, leading = { AppIcon(app.packageName, 30.dp) })
    }
    ListRow(if (reminder.selectedApps.isEmpty()) "Elegir apps" else "Cambiar apps", icon = if (reminder.selectedApps.isEmpty()) KitIcon.AGREGAR else KitIcon.EDITAR, chevron = true, onClick = onPick)
  }
  SectionGap()
  DurationStepper(reminder.requiredUsageSeconds, actions.onDuration, "en las apps elegidas")
  Spacer(Modifier.height(14.dp))
  FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    listOf(15 * 60, 30 * 60, 60 * 60, 2 * 60 * 60).forEach { seconds ->
      QuickChoice(formatDuration(seconds), reminder.requiredUsageSeconds == seconds, { actions.onDuration(seconds) })
    }
  }
  Spacer(Modifier.height(6.dp))
  PlainAction("Probar 15 segundos", { actions.onDuration(15) }, color = Relevo.colors.graphite, icon = KitIcon.TIEMPO)
}

@Composable
private fun SoundStep(reminder: Reminder, studyCondition: StudyCondition?, actions: PrepareActions) {
  val context = LocalContext.current
  var speakerConnected by remember { mutableStateOf(bluetoothSpeakerConnected(context)) }
  var tested by rememberSaveable { mutableIntStateOf(0) } // 0 sin probar, 1 sonó, 2 falló
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { speakerConnected = bluetoothSpeakerConnected(context) }
  Text(
    if (studyCondition != null) "Lo decide la condición de esta semana: ${conditionName(studyCondition).lowercase()}."
    else "Elige dónde sonará la señal. Puedes probarla antes de activar.",
    style = Relevo.type.body, color = Relevo.colors.graphite,
  )
  SectionGap()
  ListSection {
    RouteRow(KitIcon.PARLANTE, "Parlante", if (speakerConnected) "Conectado por Bluetooth" else "Sin parlante conectado",
      selected = reminder.signalRoute == SignalRoute.BLUETOOTH, enabled = studyCondition == null) { actions.onRoute(SignalRoute.BLUETOOTH) }
    RouteRow(KitIcon.TELEFONO, "Este teléfono", "No suena en el lugar de la actividad",
      selected = reminder.signalRoute == SignalRoute.PHONE, enabled = studyCondition == null) { actions.onRoute(SignalRoute.PHONE) }
  }
  SectionGap()
  RelevoButton("Probar el sonido", { tested = if (actions.onTestSound()) 1 else 2 }, kind = ButtonKind.Secondary, icon = KitIcon.PROBAR)
  Spacer(Modifier.height(12.dp))
  AnimatedVisibility(tested != 0, enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut()) {
    when (tested) {
      1 -> Text("Así va a sonar. ¿Lo escuchaste?", style = Relevo.type.body, color = Relevo.colors.ink)
      else -> Notice(if (reminder.signalRoute == SignalRoute.BLUETOOTH) "No sonó en el parlante. Revisa que esté encendido y conectado." else "No sonó en el teléfono. Revisa el volumen.", tone = Tone.Error)
    }
  }
  if (reminder.signalRoute == SignalRoute.BLUETOOTH) {
    Spacer(Modifier.height(12.dp))
    Text("Muchos parlantes se apagan solos tras un rato sin sonido. Si el tuyo lo hace, la señal no sonará.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
  }
}

@Composable
private fun RouteRow(icon: KitIcon, title: String, subtitle: String, selected: Boolean, enabled: Boolean, onClick: () -> Unit) {
  ListRow(title, icon = icon, subtitle = subtitle, onClick = if (enabled) onClick else null, trailing = { if (enabled || selected) RadioMark(selected) })
}

/** Selector de apps en una hoja inferior, con buscador y marca de verificación. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppPickerSheet(apps: List<InstalledApp>, selected: Set<String>, onToggle: (InstalledApp) -> Unit, onDismiss: () -> Unit) {
  val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
  var query by rememberSaveable { mutableStateOf("") }
  val visible = remember(apps, query) { apps.filter { it.label.contains(query.trim(), ignoreCase = true) } }
  val colors = Relevo.colors
  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = sheetState,
    containerColor = colors.paper,
    scrimColor = Color.Black.copy(alpha = if (colors.isDark) .5f else .28f),
    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
    dragHandle = { Box(Modifier.padding(top = 10.dp, bottom = 6.dp).width(36.dp).height(5.dp).background(colors.line, RoundedCornerShape(3.dp))) },
  ) {
    Column(Modifier.padding(horizontal = Relevo.margin)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Elige las apps", style = Relevo.type.title2, color = colors.ink, modifier = Modifier.weight(1f))
        PlainAction("Listo", onDismiss)
      }
      Text("El tiempo de las apps elegidas se suma hasta el límite.", style = Relevo.type.subhead, color = colors.graphite)
      Spacer(Modifier.height(14.dp))
      SearchField(query, { query = it }, "Buscar apps")
      Spacer(Modifier.height(12.dp))
    }
    LazyColumn(Modifier.fillMaxWidth().padding(horizontal = Relevo.margin).clip(Relevo.panelShape).navigationBarsPadding()) {
      itemsIndexed(visible, key = { _, app -> app.packageName }) { index, app ->
        Box(Modifier.background(colors.mist)) {
          ListRow(app.label, leading = { AppIcon(app.packageName, 30.dp) }, onClick = { onToggle(app) }, trailing = { CheckMark(app.packageName in selected) }, divider = index > 0)
        }
      }
      item { Spacer(Modifier.height(24.dp)) }
    }
  }
}

