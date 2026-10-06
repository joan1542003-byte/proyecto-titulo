package com.example.relevo.ui

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.LaunchedEffect
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
import com.example.relevo.domain.TagProtocol
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.signal.TagLink
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.DurationStepper
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Photo
import kotlinx.coroutines.delay
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
import com.example.relevo.ui.components.SegmentedControl
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

/** Nota de la guía para cada paso del primer relevo. */
private fun guideTipFor(step: PrepareStep, condition: StudyCondition?, reminder: Reminder): String = when (step) {
  PrepareStep.ACTIVITY -> if (reminder.activity.isNotBlank()) "Te propusimos «${reminder.activity.trim()}». Puedes dejarla o escribir otra cosa que quieras hacer."
    else "Escribe algo que quieras hacer o toca una idea. Mientras más concreto, mejor: «leer 10 páginas» en vez de «leer más»."
  PrepareStep.START -> if (reminder.howToStart.isNotBlank()) "El primer paso es «${reminder.howToStart.trim().replaceFirstChar { it.lowercase() }}». Mientras más pequeño, menos cuesta empezar."
    else "Anota lo primero que harías, algo que tome segundos: abrir el libro, ponerte las zapatillas."
  PrepareStep.PLACE -> if (condition == StudyCondition.NEUTRAL) "Esta semana deja el parlante en otro lugar de tu casa y anota dónde."
    else "Anota el lugar donde está lo que usas para empezar. Más adelante eliges dónde suena."
  PrepareStep.USAGE -> "Elige las apps donde se te pasa el rato. Para ver ahora cómo funciona, toca «Probar con 15 segundos»."
  PrepareStep.SOUND -> "No hay una respuesta correcta: elige lo que te acomode. Lo puedes cambiar en cada relevo."
  PrepareStep.REVIEW -> "Revisa que todo esté bien y toca «Activar el relevo». Puedes desactivarlo cuando quieras."
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
  /** Registro de uso: el paso que se muestra. */
  val onStepShown: (String) -> Unit = {},
  /** Registro de uso: la persona tocó «Seguir» con algo sin completar (paso, qué faltaba). */
  val onMissing: (String, String) -> Unit = { _, _ -> },
  /** Llavero (D-109): buscar, vincular el elegido, probar y olvidar. */
  val onTagSearch: () -> Unit = {},
  /** Respaldo: buscar todos los aparatos cercanos si el llavero no aparece. */
  val onTagSearchAll: () -> Unit = {},
  val onTagLink: (TagLink.Found) -> Unit = {},
  val onTagTest: () -> Unit = {},
  val onTagForget: () -> Unit = {},
  /** Dónde deja el objeto que suena: true donde empieza, false en otro lugar (D-110). */
  val onObjectPlace: (Boolean) -> Unit = {},
  /** El Bluetooth se encendió después del aviso: retoma la búsqueda o borra el aviso. */
  val onBluetoothOn: () -> Unit = {},
)

/** Qué falta para seguir en cada paso; null si está completo. Se muestra al tocar «Seguir» (2.18). */
private fun missingFor(step: PrepareStep, reminder: Reminder, usageAccess: Boolean, condition: StudyCondition?, tagLinked: Boolean): String? = when (step) {
  PrepareStep.ACTIVITY -> if (reminder.activity.isBlank()) "Escribe qué quieres hacer o toca una idea." else null
  PrepareStep.START -> if (reminder.howToStart.isBlank()) "Escribe cómo empiezas: lo primero que harías." else null
  PrepareStep.PLACE -> if (reminder.place.isNotBlank()) null
    else if (condition == StudyCondition.NEUTRAL) "Escribe dónde dejas el parlante." else "Escribe dónde empiezas."
  PrepareStep.USAGE -> when {
    !usageAccess -> "Falta el permiso de Tiempo de uso. Tócalo arriba para darlo."
    reminder.selectedApps.isEmpty() -> "Elige al menos una app que cuente."
    else -> null
  }
  PrepareStep.SOUND -> when {
    !reminder.routeChosen -> "Elige dónde quieres que suene."
    reminder.signalRoute == SignalRoute.TAG && !tagLinked -> "Busca y elige tu llavero, o elige otra forma de avisar."
    reminder.signalRoute != SignalRoute.PHONE && reminder.objectNearStart == null -> "Elige dónde lo dejarás: donde empiezas o en otro lugar."
    else -> null
  }
  PrepareStep.REVIEW -> when {
    !usageAccess -> "Falta el permiso de Tiempo de uso."
    !reminder.routeChosen -> "Falta elegir dónde suena."
    reminder.signalRoute == SignalRoute.TAG && !tagLinked -> "Falta elegir el llavero."
    reminder.signalRoute != SignalRoute.PHONE && reminder.objectNearStart == null -> "Falta elegir dónde lo dejarás."
    reminder.activity.isBlank() -> "Falta qué quieres hacer."
    reminder.howToStart.isBlank() -> "Falta cómo empiezas."
    reminder.place.isBlank() -> "Falta dónde empiezas."
    reminder.selectedApps.isEmpty() -> "Faltan las apps que cuentan."
    else -> null
  }
}

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
  /** Guía del primer relevo (D-088): una nota por paso que dice qué hacer y para qué. */
  guided: Boolean = false,
  /** Llavero (D-109): el vinculado, la búsqueda y la conexión. */
  tag: TagUi = TagUi(),
  tagStatus: TagLink.Status = TagLink.Status(),
) {
  // Se abre en el primer dato que falta: una idea elegida ya trae actividad, comienzo y lugar.
  var step by rememberSaveable {
    mutableStateOf(
      when {
        // En el primer relevo guiado se recorren todos los pasos, aunque vengan completos desde la ruta.
        guided -> PrepareStep.ACTIVITY
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
  LaunchedEffect(step) { actions.onStepShown(step.name.lowercase()) }
  BackHandler(enabled = !picking) { back() }

  val missing = missingFor(step, reminder, usageAccess, studyCondition, tag.linkedName != null)
  val canContinue = missing == null
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
      val onMissing: (String) -> Unit = { actions.onMissing(step.name.lowercase(), it) }
      if (step == PrepareStep.REVIEW) {
        GuardedButton("Activar el relevo", {
          if (saveActivity && !isKnown) {
            val image = (picture as? Picture.OfPhoto)?.photo?.key ?: (picture as? Picture.OfIcon)?.icon?.key ?: KitIcon.ACTIVIDAD.key
            actions.onSaveCustom(CustomActivity(UUID.randomUUID().toString(), reminder.activity.trim(), reminder.howToStart.trim(), reminder.place.trim(), image, 0))
          }
          actions.onActivate()
        }, missing = missing, onMissing = onMissing)
      } else {
        GuardedButton("Seguir", { go(PrepareStep.entries[step.ordinal + 1]) }, missing = missing, onMissing = onMissing)
      }
    },
  ) {
    if (guided) {
      GuideTip(guideTipFor(step, studyCondition, reminder))
      Spacer(Modifier.height(16.dp))
    }
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
          PrepareStep.SOUND -> SoundStep(reminder, studyCondition, tag, tagStatus, actions)
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
              FactRow(if (reminder.routeChosen) routeIcon(reminder.signalRoute) else KitIcon.AVISOS, "Te avisa", if (reminder.routeChosen) soundPlace(reminder) else "Sin elegir", valueIsVoice = false) { go(PrepareStep.SOUND) }
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
    // La foto del parlante junto a la puerta solo acompaña la condición A asignada; sin condición, no sugiere dónde dejarlo (D-110).
    if (studyCondition == StudyCondition.SITUATED) {
      PhotoImage(Photo.PUERTA, Modifier.size(72.dp).clip(CircleShape))
      Spacer(Modifier.width(16.dp))
    }
    Column(Modifier.weight(1f)) {
      Text(
        when (studyCondition) {
          null -> "El lugar donde está lo que necesitas para empezar."
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
private fun SoundStep(reminder: Reminder, studyCondition: StudyCondition?, tag: TagUi, tagStatus: TagLink.Status, actions: PrepareActions) {
  val context = LocalContext.current
  var speakerConnected by remember { mutableStateOf(bluetoothSpeakerConnected(context)) }
  var watchConnected by remember { mutableStateOf(callDeviceConnected(context)) }
  var tested by rememberSaveable { mutableIntStateOf(0) } // 0 sin probar, 1 sonó, 2 falló
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
    speakerConnected = bluetoothSpeakerConnected(context)
    watchConnected = callDeviceConnected(context)
  }
  // En las semanas A y B se elige el objeto (parlante, reloj o llavero); en la C suena en el teléfono.
  val objectChoice = studyCondition == null || studyCondition != StudyCondition.PHONE
  Text(
    when (studyCondition) {
      null -> "Elige una. Después puedes probar cómo suena."
      StudyCondition.PHONE -> "Esta semana suena en el teléfono."
      StudyCondition.SITUATED -> "Esta semana suena en el parlante, junto a lo que usas para empezar."
      StudyCondition.NEUTRAL -> "Esta semana suena en el parlante, en otro lugar de tu casa."
    },
    style = Relevo.type.body, color = Relevo.colors.graphite,
  )
  SectionGap()
  Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
    SoundOption(KitIcon.PARLANTE, "El parlante", if (speakerConnected) "Conectado por Bluetooth" else "Sin parlante conectado",
      selected = reminder.routeChosen && reminder.signalRoute == SignalRoute.BLUETOOTH, enabled = objectChoice) { actions.onRoute(SignalRoute.BLUETOOTH) }
    SoundOption(KitIcon.TIEMPO, "El reloj", if (watchConnected) "Suena como una llamada" else "Sin reloj conectado para llamadas",
      selected = reminder.routeChosen && reminder.signalRoute == SignalRoute.WATCH, enabled = objectChoice) { actions.onRoute(SignalRoute.WATCH) }
    SoundOption(KitIcon.OBJETO, "El llavero", tagSubtitle(tag, tagStatus),
      selected = reminder.routeChosen && reminder.signalRoute == SignalRoute.TAG, enabled = objectChoice) { actions.onRoute(SignalRoute.TAG) }
    SoundOption(KitIcon.TELEFONO, "El teléfono", "Suena donde esté el teléfono",
      selected = reminder.routeChosen && reminder.signalRoute == SignalRoute.PHONE, enabled = studyCondition == null) { actions.onRoute(SignalRoute.PHONE) }
  }
  SectionGap()
  // Sin elección todavía: nada más que elegir.
  if (!reminder.routeChosen) return
  if (reminder.signalRoute != SignalRoute.PHONE) {
    ObjectPlaceQuestion(reminder, actions)
    SectionGap()
  }
  if (reminder.signalRoute == SignalRoute.TAG) {
    TagPanel(tag, actions)
    return
  }
  RelevoButton("Probar el sonido", { tested = if (actions.onTestSound()) 1 else 2 }, kind = ButtonKind.Secondary, icon = KitIcon.PROBAR)
  Spacer(Modifier.height(12.dp))
  AnimatedVisibility(tested != 0, enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut()) {
    when (tested) {
      1 -> Text("Así va a sonar.", style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.padding(horizontal = 4.dp))
      else -> Notice(routeFailure(reminder.signalRoute), tone = Tone.Error)
    }
  }
  if (reminder.signalRoute == SignalRoute.BLUETOOTH) {
    Spacer(Modifier.height(8.dp))
    Text("Si tu parlante se apaga solo, no sonará.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
  }
  if (reminder.signalRoute == SignalRoute.WATCH) {
    Spacer(Modifier.height(8.dp))
    Text("Deja el reloj donde empiezas, con las llamadas por Bluetooth activadas.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
  }
}

/** Dónde deja el objeto: la persona lo elige y así se sabe a qué tiende (D-110). */
@Composable
private fun ObjectPlaceQuestion(reminder: Reminder, actions: PrepareActions) {
  val thing = when (reminder.signalRoute) { SignalRoute.WATCH -> "el reloj"; SignalRoute.TAG -> "el llavero"; else -> "el parlante" }
  Text("¿Dónde dejarás $thing?", style = Relevo.type.headline, color = Relevo.colors.ink)
  Spacer(Modifier.height(10.dp))
  SegmentedControl(
    listOf("cerca" to "Donde empiezas", "lejos" to "En otro lugar"),
    when (reminder.objectNearStart) { true -> "cerca"; false -> "lejos"; null -> null },
    { value -> value?.let { actions.onObjectPlace(it == "cerca") } },
  )
  Spacer(Modifier.height(8.dp))
  Text(
    // Sin elección todavía, el texto no inclina hacia ninguna opción.
    if (reminder.objectNearStart == null) "Las dos opciones sirven. Elige lo que de verdad vas a hacer."
    else if (reminder.objectNearStart == false) "En cualquier otra parte de tu casa."
    else "Junto a lo que usas para empezar${reminder.place.takeIf { it.isNotBlank() }?.let { ": " + it.replaceFirstChar { c -> c.lowercase() } } ?: ""}.",
    style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp),
  )
}

private fun tagSubtitle(tag: TagUi, status: TagLink.Status): String = when {
  tag.linkedName == null -> "Un llavero iTag que pita"
  status.phase == TagLink.Phase.CONNECTED -> "${tag.linkedName}, conectado"
  else -> "${tag.linkedName}, elegido"
}

private fun tagProblem(problem: TagLink.Problem?): String = when (problem) {
  TagLink.Problem.NO_PERMISSION -> "Falta el permiso de dispositivos cercanos."
  TagLink.Problem.BLUETOOTH_OFF -> "El Bluetooth del teléfono está apagado."
  TagLink.Problem.NOT_A_TAG -> "Ese aparato no acepta la orden para pitar: no es un llavero compatible."
  TagLink.Problem.NOT_FOUND, null -> "No lo encontramos. Revisa que esté encendido y cerca, y que ninguna otra app, como iSearching, esté conectada a él: acepta una conexión a la vez."
}

/**
 * Elegir y probar el llavero (D-109). Pide el permiso de dispositivos cercanos solo al buscar o probar.
 * Sin llavero elegido, lo busca; con uno elegido, lo prueba o permite cambiarlo.
 */
@Composable
private fun TagPanel(tag: TagUi, actions: PrepareActions) {
  val context = LocalContext.current
  var pending by remember { mutableStateOf<(() -> Unit)?>(null) }
  var denied by rememberSaveable { mutableStateOf(false) }
  val permissions = rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
    denied = result.values.any { !it }
    if (!denied) pending?.invoke()
    pending = null
  }
  // Diálogo del sistema para encender el Bluetooth; el resultado lo recoge la revisión del aviso.
  val enableBluetooth = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }
  val withPermission: (() -> Unit) -> Unit = { action ->
    if (TagLink.hasPermissions(context)) action() else { pending = action; permissions.launch(TagLink.requiredPermissions) }
  }
  if (denied) {
    Notice("Relevo necesita el permiso de dispositivos cercanos para encontrar el llavero. Solo lo usa para eso.", title = "Falta un permiso", icon = KitIcon.PERMISO) {
      PlainAction("Abrir los ajustes de Relevo", {
        context.startActivity(
          Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", context.packageName, null)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
        )
      })
    }
    SectionGap()
  }
  if (tag.problem == TagLink.Problem.BLUETOOTH_OFF) {
    // Se revisa cada segundo: al encenderlo (con el diálogo, los ajustes o el panel rápido) el aviso se va solo.
    LaunchedEffect(Unit) {
      while (!TagLink.bluetoothOn(context)) delay(1_000)
      actions.onBluetoothOn()
    }
    Notice("Enciende el Bluetooth del teléfono para encontrar el llavero.", title = "Bluetooth apagado", icon = KitIcon.CONEXION) {
      PlainAction("Encender Bluetooth", {
        runCatching { enableBluetooth.launch(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)) }
          .onFailure { context.startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)) }
      })
    }
    SectionGap()
  }
  if (tag.linkedName == null) {
    Text("Enciende el llavero: mantén apretado su botón 3 segundos, hasta que pite dos veces. Después búscalo.", style = Relevo.type.body, color = Relevo.colors.graphite)
    SectionGap()
    RelevoButton(
      if (tag.searching) "Buscando…" else "Buscar el llavero", { withPermission(actions.onTagSearch) },
      kind = ButtonKind.Secondary, icon = KitIcon.BUSCAR, enabled = !tag.searching,
    )
    if (!TagLink.hasPermissions(context)) {
      Spacer(Modifier.height(8.dp))
      Text(
        "Para buscarlo, Android te pedirá permiso para encontrar dispositivos cercanos. Relevo solo recuerda el llavero que elijas, en este teléfono; no usa tu ubicación.",
        style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp),
      )
    }
    if (tag.found.isNotEmpty()) {
      SectionGap()
      ListSection(
        title = if (tag.searchedAll) "Aparatos cerca" else "Llaveros cerca",
        footer = if (tag.searchedAll) "Toca tu llavero. Si es compatible, va a pitar una vez." else "Toca el tuyo. Va a pitar una vez para confirmarlo.",
      ) {
        tag.found.forEach { found ->
          ListRow(found.name, icon = KitIcon.OBJETO, subtitle = TagProtocol.strength(found.rssi), chevron = true, onClick = { actions.onTagLink(found) })
        }
      }
    } else if (tag.searched && !tag.searching && tag.problem == null) {
      SectionGap()
      Notice(
        if (tag.searchedAll) "No apareció ningún aparato con Bluetooth cerca. Revisa que el llavero esté encendido y cerca del teléfono, y búscalo de nuevo."
        else "No apareció ningún llavero. Revisa que esté encendido y cerca del teléfono, y búscalo de nuevo. Si lo usa otra app, como iSearching, ciérrala: el llavero acepta una conexión a la vez.",
        tone = Tone.Error,
        actions = if (tag.searchedAll) null else {
          { PlainAction("Ver todos los aparatos cercanos", { withPermission(actions.onTagSearchAll) }) }
        },
      )
    } else if (tag.problem == TagLink.Problem.NOT_A_TAG && !tag.searching) {
      SectionGap()
      Notice("Ese aparato no aceptó la orden para pitar: no es un llavero compatible. Búscalo de nuevo y elige otro.", tone = Tone.Error)
    }
    return
  }
  RelevoButton(
    if (tag.test == TagTest.WORKING) "Probando…" else "Probar el llavero", { withPermission(actions.onTagTest) },
    kind = ButtonKind.Secondary, icon = KitIcon.PROBAR, enabled = tag.test != TagTest.WORKING,
  )
  Spacer(Modifier.height(12.dp))
  // Con el Bluetooth apagado basta el aviso de arriba.
  AnimatedVisibility(
    tag.test == TagTest.SOUNDED || (tag.test == TagTest.FAILED && tag.problem != TagLink.Problem.BLUETOOTH_OFF),
    enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut(),
  ) {
    if (tag.test == TagTest.SOUNDED) {
      Column(verticalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.padding(horizontal = 4.dp)) {
        Text("Así va a sonar: cuando se cumpla el tiempo, pitará seis veces en 30 segundos.", style = Relevo.type.body, color = Relevo.colors.ink)
        if (tag.button) Text("Para callarlo antes, aprieta su botón.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
        if (!tag.linkLossOff) {
          Text("Este llavero no dejó apagar su alarma de desconexión: puede pitar un momento cuando Relevo termine.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
        }
      }
    } else {
      Notice(tagProblem(tag.problem), title = "No sonó en el llavero", tone = Tone.Error)
    }
  }
  Spacer(Modifier.height(8.dp))
  PlainAction("Elegir otro llavero", actions.onTagForget, color = Relevo.colors.graphite, icon = KitIcon.CAMBIE)
  Spacer(Modifier.height(8.dp))
  Text(
    "Déjalo encendido donde empiezas. Relevo se conecta a él al activar el relevo y lo mantiene así hasta que suene.",
    style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp),
  )
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
