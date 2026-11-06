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
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
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
import com.example.relevo.data.TagStore
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.RouteTrack
import com.example.relevo.domain.SignalRoute
import com.example.relevo.data.SignalVolume
import com.example.relevo.domain.TagProtocol
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.signal.TagLink
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import kotlinx.coroutines.delay
import com.example.relevo.ui.components.Picture
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
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.key
import com.example.relevo.ui.components.pressScale
import com.example.relevo.ui.components.rememberReduceMotion
import com.example.relevo.ui.components.pictureIcon
import java.util.UUID
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.OptionRow
import com.example.relevo.ui.components.SectionLabel
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.RingCell
import com.example.relevo.ui.components.RingGrid
import com.example.relevo.ui.components.DurationButtons
import com.example.relevo.ui.components.familyName
import com.example.relevo.ui.components.Suggestions
import com.example.relevo.ui.components.FamilyLabel
import com.example.relevo.ui.components.Sky

private enum class PrepareStep(val title: String) {
  ACTIVITY("¿Qué quieres hacer?"),
  START(START_QUESTION),
  PLACE(PLACE_QUESTION),
  USAGE("¿Cuándo suena?"),
  SOUND("¿Dónde suena?"),
  REVIEW("Todo listo"),
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
  /** Volumen del sonido en el teléfono y en un dispositivo de audio (4.4). */
  val onVolume: (SignalVolume) -> Unit = {},
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
  val onTagHeard: (Boolean) -> Unit = {},
  val onTagForget: () -> Unit = {},
  /** El Bluetooth se encendió después del aviso: retoma la búsqueda o borra el aviso. */
  val onBluetoothOn: () -> Unit = {},
)

/** Qué falta para seguir en cada paso; null si está completo. Se muestra al tocar «Seguir» (2.18). */
private fun missingFor(step: PrepareStep, reminder: Reminder, usageAccess: Boolean, tagLinked: Boolean): String? = when (step) {
  PrepareStep.ACTIVITY -> if (reminder.activity.isBlank()) "Escribe qué quieres hacer o elige una idea." else null
  PrepareStep.START -> if (reminder.howToStart.isBlank()) "Escribe cómo empiezas la actividad: lo primero que harías." else null
  PrepareStep.PLACE -> if (reminder.place.isNotBlank()) null else "Escribe en qué lugar empieza."
  PrepareStep.USAGE -> when {
    !usageAccess -> "Da el permiso de Tiempo de uso."
    reminder.selectedApps.isEmpty() -> "Elige al menos una app que cuente."
    else -> null
  }
  PrepareStep.SOUND -> when {
    !reminder.routeChosen -> "Elige dónde quieres que suene."
    reminder.signalRoute == SignalRoute.TAG && !tagLinked -> "Busca y elige el Tag, o elige otra forma de avisar."
    else -> null
  }
  PrepareStep.REVIEW -> when {
    !usageAccess -> "Falta el permiso de Tiempo de uso."
    !reminder.routeChosen -> "Falta elegir dónde suena."
    reminder.signalRoute == SignalRoute.TAG && !tagLinked -> "Falta elegir el Tag."
    reminder.activity.isBlank() -> "Falta qué quieres hacer."
    reminder.howToStart.isBlank() -> "Falta cómo empiezas la actividad."
    reminder.place.isBlank() -> "Falta en qué lugar empieza."
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
  photoKey: String?,
  actions: PrepareActions,
  /**
   * Empezar por el paso 1 aunque ya haya datos: «Preparar un relevo» sin nada elegido y el primer relevo
   * guiado (D-088). Con una idea, una actividad o un paso elegidos, abre en lo primero que falta (4.2.1).
   */
  fromStart: Boolean = false,
  /** «usage»: abre en «¿Cuándo suena?», para cambiar solo el tiempo, y «Seguir» vuelve a «Todo listo» (4.4). */
  openAt: String? = null,
  /** Volumen elegido para el teléfono y el dispositivo de audio (4.4). */
  volume: SignalVolume = SignalVolume.MEDIUM,
  /** Llavero (D-109): el vinculado, la búsqueda y la conexión. */
  tag: TagUi = TagUi(),
  tagStatus: TagLink.Status = TagLink.Status(),
  /** Se está editando un relevo que ya estaba activo (2.30). */
  editing: Boolean = false,
) {
  // Se abre en el primer dato que falta: una idea elegida ya trae actividad, comienzo y lugar.
  var step by rememberSaveable {
    mutableStateOf(
      when {
        // Antes, mientras no se activaba el primer relevo, Preparar empezaba siempre por el paso 1: elegir una
        // idea parecía empezar de cero (4.2.1). Ahora solo el primer relevo guiado recorre todos los pasos.
        openAt == "usage" -> PrepareStep.USAGE
        fromStart -> PrepareStep.ACTIVITY
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
  // Un dato tocado en «Todo listo» se cambia y se vuelve ahí, sin recorrer los pasos siguientes (2.30).
  var fromReview by rememberSaveable { mutableStateOf(openAt == "usage") }
  fun go(to: PrepareStep) { forward = to.ordinal > step.ordinal; step = to; if (to == PrepareStep.REVIEW) fromReview = false }
  fun edit(to: PrepareStep) { fromReview = true; go(to) }
  fun next(to: PrepareStep) = go(if (fromReview && reminder.hasRequiredContent && reminder.routeChosen) PrepareStep.REVIEW else to)
  fun back() = when {
    fromReview && reminder.hasRequiredContent && reminder.routeChosen -> go(PrepareStep.REVIEW)
    step == PrepareStep.ACTIVITY -> actions.onClose()
    else -> go(PrepareStep.entries[step.ordinal - 1])
  }
  LaunchedEffect(step) { actions.onStepShown(step.name.lowercase()) }
  BackHandler(enabled = !picking) { back() }

  val missing = missingFor(step, reminder, usageAccess, tag.linkedName != null)
  val canContinue = missing == null
  val isKnown = activityIdeas.any { it.activity.equals(reminder.activity.trim(), true) } || customActivities.any { it.name.equals(reminder.activity.trim(), true) }
  val picture = activityPicture(reminder.activity, customActivities)

  val scroll = rememberScrollState()
  // Cada paso empieza arriba (4.3): el desplazamiento de un paso no se arrastra al siguiente.
  LaunchedEffect(step) { scroll.scrollTo(0) }
  RelevoScreen(
    scrollState = scroll,
    title = step.title,
    onBack = { back() },
    closeIcon = step == PrepareStep.ACTIVITY,
    backLabel = if (step == PrepareStep.ACTIVITY) "Cerrar" else "Volver",
    step = "${step.ordinal + 1} de ${PrepareStep.entries.size}",
    progress = (step.ordinal + 1f) / PrepareStep.entries.size,
    header = if ((step == PrepareStep.START || step == PrepareStep.PLACE || step == PrepareStep.USAGE) && reminder.activity.isNotBlank()) ({
      ActivityHeader(reminder.activity, picture, photoKey) { go(PrepareStep.ACTIVITY) }
    }) else null,
    bottom = {
      val onMissing: (String) -> Unit = { actions.onMissing(step.name.lowercase(), it) }
      if (step == PrepareStep.REVIEW) {
        GuardedButton(if (editing) "Guardar y activar" else "Activar el relevo", {
          if (saveActivity && !isKnown) {
            val image = (picture as? Picture.OfPhoto)?.photo?.key ?: (picture as? Picture.OfIcon)?.icon?.key ?: KitIcon.ACTIVIDAD.key
            actions.onSaveCustom(CustomActivity(UUID.randomUUID().toString(), reminder.activity.trim(), reminder.howToStart.trim(), reminder.place.trim(), image, 0))
          }
          actions.onActivate()
        }, missing = missing, onMissing = onMissing, haptic = HapticFeedbackType.Confirm)
      } else {
        GuardedButton(if (fromReview) "Listo" else "Seguir", { next(PrepareStep.entries[step.ordinal + 1]) }, missing = missing, onMissing = onMissing)
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
          PrepareStep.ACTIVITY -> ActivityStep(reminder, customActivities, routes, actions, onNext = { if (reminder.activity.isNotBlank()) next(PrepareStep.START) })
          PrepareStep.START -> {
            Suggestions(startSuggestions(reminder.activity), reminder.howToStart, actions.onStart)
            Spacer(Modifier.height(Gap.block))
            // La ayuda dice lo que importa (criterio 2): algo pequeño, que se hace enseguida.
            RenglonField(START_QUESTION, reminder.howToStart, actions.onStart, placeholder = startExample(reminder.activity), imeAction = ImeAction.Next, onImeAction = { if (canContinue) next(PrepareStep.PLACE) }, icon = KitIcon.COMENCE, showLabel = false)
          }
          PrepareStep.PLACE -> PlaceStep(reminder, actions, onNext = { if (canContinue) next(PrepareStep.USAGE) })
          PrepareStep.USAGE -> UsageStep(reminder, usageAccess, actions, onPick = { picking = true })
          PrepareStep.SOUND -> SoundStep(reminder, tag, tagStatus, volume, actions)
          PrepareStep.REVIEW -> {
            if (editing) {
              Text("Estás editando tu relevo. Al guardarlo vuelve a contar, con el tiempo que llevabas si las apps son las mismas.", style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 2.dp))
              Spacer(Modifier.height(Gap.block))
            }
            val apps = reminder.selectedApps.joinToString(" y ") { it.label }
            ListSection {
              // 2.30: la actividad también se cambia desde aquí, sin volver atrás.
              // 4.2: cada dato lleva arriba la pregunta de su paso; tocarlo vuelve a ese paso.
              FactRow(KitIcon.ACTIVIDAD, PrepareStep.ACTIVITY.title, reminder.activity, leading = {
                ActivityRing(pictureIcon(picture), 40.dp)
              }) { edit(PrepareStep.ACTIVITY) }
              FactRow(KitIcon.COMENCE, START_QUESTION, reminder.howToStart) { edit(PrepareStep.START) }
              FactRow(KitIcon.LUGAR, PrepareStep.PLACE.title, reminder.place) { edit(PrepareStep.PLACE) }
              FactRow(KitIcon.TIEMPO, PrepareStep.USAGE.title, if (apps.isBlank()) "" else "${formatDuration(reminder.requiredUsageSeconds)} en $apps") { edit(PrepareStep.USAGE) }
              FactRow(if (reminder.routeChosen) routeIcon(reminder.signalRoute) else KitIcon.AVISOS, PrepareStep.SOUND.title, if (reminder.routeChosen) soundPlace(reminder) else "") { edit(PrepareStep.SOUND) }
            }
            if (!isKnown && reminder.activity.isNotBlank()) {
              Spacer(Modifier.height(Gap.block))
              Row(
                Modifier.fillMaxWidth().heightIn(min = 52.dp).padding(horizontal = 2.dp)
                  .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { saveActivity = !saveActivity },
                verticalAlignment = Alignment.CenterVertically,
              ) {
                CheckMark(saveActivity, square = true)
                Spacer(Modifier.width(12.dp))
                Text("Guardar la actividad para la próxima vez", style = Relevo.type.callout, color = Relevo.colors.ink)
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

/** La actividad elegida acompaña cada paso (4.0): su anillo y su nombre en una fila; tocarla la cambia. */
@Composable
private fun ActivityHeader(activity: String, picture: Picture, @Suppress("UNUSED_PARAMETER") photoKey: String?, onEdit: () -> Unit) {
  ListRow(
    activity.trim(), subtitle = "Actividad",
    leading = { ActivityRing(pictureIcon(picture), 42.dp) },
    trailing = { RelevoIcon(KitIcon.EDITAR, size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card) },
    onClick = onEdit,
  )
}

/** Paso 1: el renglón para escribir y, debajo, los pasos de la ruta, ideas con foto y las actividades propias. */
@Composable
private fun ActivityStep(reminder: Reminder, customActivities: List<CustomActivity>, routes: List<RouteTrack>, actions: PrepareActions, onNext: () -> Unit) {
  RenglonField(PrepareStep.ACTIVITY.title, reminder.activity, actions.onActivity, placeholder = "Ej.: leer 10 páginas", imeAction = ImeAction.Next, onImeAction = onNext, showLabel = false)
  val steps = routes.mapNotNull { track -> track.currentStep?.let { track to it } }
  if (steps.isNotEmpty()) {
    TileGroup("Pasos", steps.map { (track, step) ->
      Tile(step.activity, pictureIcon(activityPictureFor(step.activity, customActivities, routes)), reminder.activity.equals(step.activity, true)) { actions.onRouteStep(track.interest, step.id) }
    })
  }
  if (customActivities.isNotEmpty()) {
    TileGroup("Creadas por ti", customActivities.map { custom ->
      Tile(custom.name, pictureIcon(Picture.parse(custom.icon) ?: pictureForActivity(custom.name, emptyList())), reminder.activity.equals(custom.name, true)) {
        actions.onIdea(custom.name, custom.firstStep, custom.place)
      }
    })
  }
  // Las ideas van agrupadas por familia (3.2): el color del anillo dice qué tipo de actividad es. Una idea
  // que la persona ya guardó aparece solo en «Tus actividades», con su forma de empezar (4.2).
  val saved = customActivities.map { it.name.trim().lowercase() }.toSet()
  ideasByFamily.forEach { (sky, ideas) ->
    val shown = ideas.filter { it.activity.trim().lowercase() !in saved }
    if (shown.isNotEmpty()) TileGroup(sky.familyName, sky = sky, tiles = shown.map { idea ->
      Tile(idea.activity, pictureIcon(idea.picture), reminder.activity.equals(idea.activity, true)) { actions.onIdea(idea.activity, idea.start, idea.place) }
    })
  }
}

private fun activityPictureFor(name: String, custom: List<CustomActivity>, routes: List<RouteTrack>): Picture = pictureForActivity(name, custom, routes)

private class Tile(val label: String, val icon: KitIcon, val selected: Boolean, val onClick: () -> Unit)

/**
 * Un grupo de actividades con su rótulo, en anillos de a cuatro (4.0). La elegida lleva un anillo de tinta. Si
 * el grupo es una familia, su nombre late con su degradado al elegir una de sus actividades (4.3).
 */
@Composable
private fun TileGroup(label: String, tiles: List<Tile>, sky: Sky? = null) {
  var pulse by remember { mutableIntStateOf(0) }
  Spacer(Modifier.height(Gap.section))
  if (sky != null) FamilyLabel(sky, pulse, Modifier.padding(bottom = 14.dp)) else SectionLabel(label, Modifier.padding(bottom = 14.dp))
  RingGrid(tiles, columns = 4) { tile ->
    RingCell(tile.icon, tile.label, { pulse++; tile.onClick() }, size = 58.dp, selected = tile.selected)
  }
}

/** Paso 3: dónde empieza la actividad, que es donde se deja el Tag o el dispositivo de audio. */
@Composable
private fun PlaceStep(reminder: Reminder, actions: PrepareActions, onNext: () -> Unit) {
  Suggestions(placeSuggestions(reminder.activity), reminder.place, actions.onPlace)
  Spacer(Modifier.height(Gap.block))
  RenglonField(
    PrepareStep.PLACE.title,
    reminder.place, actions.onPlace,
    placeholder = "Ej.: en el velador",
    onImeAction = onNext,
    icon = KitIcon.LUGAR,
    showLabel = false,
  )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun UsageStep(reminder: Reminder, usageAccess: Boolean, actions: PrepareActions, onPick: () -> Unit) {
  if (!usageAccess) {
    Notice("Relevo necesita el permiso de Tiempo de uso para contar.", title = "Falta un permiso", icon = KitIcon.PERMISO) {
      PlainAction("Dar el permiso", actions.onUsageSettings)
    }
    Spacer(Modifier.height(Gap.block))
  }
  val apps = reminder.selectedApps
  ListRow(
    if (apps.isEmpty()) "Elige las apps" else apps.joinToString(" y ") { it.label },
    icon = KitIcon.APPS, subtitle = "Apps que cuentan", onClick = onPick,
    titleColor = if (apps.isEmpty()) Relevo.colors.graphite else Relevo.colors.ink,
    trailing = {
      Row(horizontalArrangement = Arrangement.spacedBy((-6).dp)) { apps.take(3).forEach { AppIcon(it.packageName, 26.dp) } }
      Spacer(Modifier.width(10.dp))
      RelevoIcon(if (apps.isEmpty()) KitIcon.AGREGAR else KitIcon.EDITAR, size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card)
    },
  )
  Spacer(Modifier.height(Gap.list))
  ListRow(
    "Después de ${formatDuration(reminder.requiredUsageSeconds)}", icon = KitIcon.TIEMPO,
    subtitle = if (apps.size > 1) "Sumando las ${apps.size} apps" else "En esas apps",
    trailing = { DurationButtons(reminder.requiredUsageSeconds, actions.onDuration) },
  )
  Spacer(Modifier.height(Gap.block))
  FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    listOf(15 * 60, 30 * 60, 45 * 60, 60 * 60).forEach { seconds ->
      QuickChoice(formatDuration(seconds), reminder.requiredUsageSeconds == seconds, { actions.onDuration(seconds) })
    }
  }
  Spacer(Modifier.height(12.dp))
  // Un límite breve al empezar (4.4, Tabla 4 de la memoria): con 45 minutos, al sonar una persona ya estaba
  // muy metida en un video. «Probar con 15 segundos», un atajo para probar la app, sale.
  Text("Al empezar, conviene un tiempo breve: suena antes de que te pierdas en las apps.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
}

/** Dónde conseguir un Tag compatible: una búsqueda en Mercado Libre, que no caduca como una publicación. */
private const val GET_A_TAG_URL = "https://listado.mercadolibre.cl/itag-llavero-bluetooth"

@Composable
private fun SoundStep(reminder: Reminder, tag: TagUi, tagStatus: TagLink.Status, volume: SignalVolume, actions: PrepareActions) {
  val context = LocalContext.current
  var speakerConnected by remember { mutableStateOf(audioDeviceConnected(context)) }
  var tested by rememberSaveable { mutableIntStateOf(0) } // 0 sin probar, 1 sonó, 2 falló
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
    speakerConnected = audioDeviceConnected(context)
  }
  Column(verticalArrangement = Arrangement.spacedBy(Gap.list)) {
    // 4.3 (D-158): tres respuestas con nombre directo. El reloj ya no es una opción: «Notificaciones» llega al
    // teléfono y al reloj que las reciba. Solo el Tag lleva una línea más, cuando ya hay uno elegido.
    OptionRow(routeLabel(SignalRoute.TAG), reminder.routeChosen && reminder.signalRoute == SignalRoute.TAG, { tested = 0; actions.onRoute(SignalRoute.TAG) },
      icon = KitIcon.OBJETO, subtitle = tagSubtitle(tag, tagStatus))
    OptionRow(routeLabel(SignalRoute.BLUETOOTH), reminder.routeChosen && reminder.signalRoute == SignalRoute.BLUETOOTH, { tested = 0; actions.onRoute(SignalRoute.BLUETOOTH) },
      icon = KitIcon.PARLANTE)
    OptionRow(routeLabel(SignalRoute.PHONE), reminder.routeChosen && reminder.signalRoute == SignalRoute.PHONE, { tested = 0; actions.onRoute(SignalRoute.PHONE) },
      icon = routeIcon(SignalRoute.PHONE))
  }
  // Sin elección todavía: nada más que elegir.
  if (!reminder.routeChosen) return
  Spacer(Modifier.height(Gap.section))
  // Sin dibujo del Tag (4.4): un dibujo puede dar una idea equivocada de cómo se ve el que tiene la persona.
  if (reminder.signalRoute == SignalRoute.TAG) {
    TagPanel(tag, actions)
    return
  }
  // Volumen (4.4, Tabla 4 de la memoria): para el teléfono y el dispositivo de audio. El Tag pita con el suyo.
  Column(
    Modifier.fillMaxWidth().clip(Relevo.panelShape).background(Relevo.colors.card).padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp),
  ) {
    Text("Volumen", style = Relevo.type.headline, color = Relevo.colors.ink)
    Text("El volumen multimedia del teléfono también cuenta.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(4.dp))
    SegmentedControl(
      listOf(SignalVolume.SOFT.name to "Suave", SignalVolume.MEDIUM.name to "Medio", SignalVolume.LOUD.name to "Fuerte"), volume.name,
      { picked -> picked?.let { tested = 0; actions.onVolume(SignalVolume.valueOf(it)) } }, allowDeselect = false,
    )
  }
  Spacer(Modifier.height(Gap.block))
  RelevoButton("Probar el sonido", { tested = if (actions.onTestSound()) 1 else 2 }, kind = ButtonKind.Secondary, icon = KitIcon.PROBAR)
  Spacer(Modifier.height(12.dp))
  AnimatedVisibility(tested != 0, enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut()) {
    when (tested) {
      1 -> Text("Sonó ${routeWhere(reminder.signalRoute)}.", style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.padding(horizontal = 4.dp))
      else -> Notice(routeFailure(reminder.signalRoute), tone = Tone.Error)
    }
  }
  if (reminder.signalRoute == SignalRoute.BLUETOOTH) {
    Spacer(Modifier.height(8.dp))
    Text(
      if (speakerConnected) "Si el dispositivo de audio se apaga solo, no sonará." else "Conecta un parlante o audífonos por Bluetooth para que suene.",
      style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp),
    )
  }
}

/** Con la carga de la pila, si el Tag la informó (2.31). */
private fun tagSubtitle(tag: TagUi, status: TagLink.Status): String? {
  val battery = (status.battery ?: tag.battery)?.let { " · " + TagProtocol.batteryLabel(it) }.orEmpty()
  return when {
    tag.linkedName == null -> null
    status.phase == TagLink.Phase.CONNECTED -> "${tag.linkedName}, conectado$battery"
    else -> "${tag.linkedName}, elegido$battery"
  }
}

private fun tagProblem(problem: TagLink.Problem?): String = when (problem) {
  TagLink.Problem.NO_PERMISSION -> "Falta el permiso de dispositivos cercanos."
  TagLink.Problem.BLUETOOTH_OFF -> "El Bluetooth del teléfono está apagado."
  TagLink.Problem.NOT_A_TAG -> "Ese aparato no acepta la orden para pitar: no es un Tag compatible."
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
  // La guía se abre solo si la persona la pide, con «Cómo usar el Tag» (4.3): abrirse sola la primera vez
  // demoraba la búsqueda con ocho pasos que no siempre hacen falta.
  val tagStore = remember { TagStore(context) }
  var guide by rememberSaveable { mutableStateOf(false) }
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
  if (guide) {
    TagGuideSheet(
      onDismiss = { guide = false; tagStore.guideSeen = true },
      finishLabel = if (tag.linkedName == null) "Buscar mi Tag" else "Entendido",
      onFinish = if (tag.linkedName == null) ({ withPermission(actions.onTagSearch) }) else null,
    )
  }
  // Sin Tag elegido, la búsqueda empieza sola al llegar (2.28): basta tocar el que aparece. Si no aparece
  // ninguno, se vuelve a buscar hasta tres veces.
  var autoSearched by rememberSaveable { mutableStateOf(false) }
  var retries by rememberSaveable { mutableIntStateOf(0) }
  LaunchedEffect(tag.linkedName, guide, tag.searching) {
    if (tag.linkedName != null || guide || tag.searching || autoSearched || denied) return@LaunchedEffect
    autoSearched = true
    withPermission(actions.onTagSearch)
  }
  LaunchedEffect(tag.searched, tag.searching) {
    if (tag.linkedName == null && tag.searched && !tag.searching && tag.found.isEmpty() && tag.problem == null && retries < 3 && TagLink.hasPermissions(context)) {
      delay(2_000)
      retries++
      actions.onTagSearch()
    }
  }
  if (denied) {
    Notice("Relevo necesita el permiso de dispositivos cercanos para encontrar el Tag. Solo lo usa para eso.", title = "Falta un permiso", icon = KitIcon.PERMISO) {
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
    Notice("Enciende el Bluetooth del teléfono para encontrar el Tag.", title = "Bluetooth apagado", icon = KitIcon.CONEXION) {
      PlainAction("Encender Bluetooth", {
        runCatching { enableBluetooth.launch(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)) }
          .onFailure { context.startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)) }
      })
    }
    SectionGap()
  }
  if (tag.linkedName == null) {
    Text(
      if (tag.searching) "Buscando Tags cerca. Si está apagado, mantén apretado su botón 3 segundos, hasta que pite dos veces."
      else "Enciende el Tag: mantén apretado su botón 3 segundos, hasta que pite dos veces. Después elígelo en la lista.",
      style = Relevo.type.body, color = Relevo.colors.graphite,
    )
    Spacer(Modifier.height(8.dp))
    PlainAction("Cómo usar el Tag", { guide = true }, icon = KitIcon.AYUDA)
    SectionGap()
    RelevoButton(
      if (tag.searching) "Buscando…" else if (tag.searched) "Buscar de nuevo" else "Buscar el Tag", { retries = 0; withPermission(actions.onTagSearch) },
      kind = ButtonKind.Secondary, icon = KitIcon.BUSCAR, enabled = !tag.searching,
    )
    if (!TagLink.hasPermissions(context)) {
      Spacer(Modifier.height(8.dp))
      Text(
        "Para buscarlo, Android te pedirá permiso para encontrar dispositivos cercanos. Relevo solo recuerda el Tag que elijas, en este teléfono; no usa tu ubicación.",
        style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp),
      )
    }
    if (tag.found.isNotEmpty()) {
      SectionGap()
      ListSection(
        title = if (tag.searchedAll) "Aparatos cerca" else "Tags cerca",
        footer = if (tag.searchedAll) "Si es compatible, pita una vez al elegirlo." else "Al elegirlo, pita una vez para confirmarlo.",
      ) {
        tag.found.forEach { found ->
          ListRow(found.name, icon = KitIcon.OBJETO, subtitle = TagProtocol.strength(found.rssi), chevron = true, onClick = { actions.onTagLink(found) })
        }
      }
    } else if (tag.searched && !tag.searching && tag.problem == null) {
      SectionGap()
      Notice(
        if (tag.searchedAll) "No apareció ningún aparato con Bluetooth cerca. Revisa que el Tag esté encendido y cerca del teléfono, y búscalo de nuevo."
        else "No apareció ningún Tag. Revisa que esté encendido y cerca del teléfono, y búscalo de nuevo. Si lo usa otra app, como iSearching, ciérrala: el Tag acepta una conexión a la vez.",
        tone = Tone.Error,
        actions = if (tag.searchedAll) null else {
          { PlainAction("Ver todos los aparatos cercanos", { withPermission(actions.onTagSearchAll) }) }
        },
      )
    } else if (tag.problem == TagLink.Problem.NOT_A_TAG && !tag.searching) {
      SectionGap()
      Notice("Ese aparato no aceptó la orden para pitar: no es un Tag compatible. Búscalo de nuevo y elige otro.", tone = Tone.Error)
    }
    // «¿No tienes un Tag?» (4.4, pedido de la comisión del 28 de octubre): dónde conseguir uno y, mientras
    // tanto, las notificaciones.
    SectionGap()
    ListSection(footer = "Sirve un iTag, el llavero que se usa con la app iSearching. Mientras tanto, elige «Notificaciones».") {
      ListRow("¿No tienes un Tag?", icon = KitIcon.ENLACE_EXTERNO, subtitle = "Consíguelo en Mercado Libre", chevron = true, onClick = {
        runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(GET_A_TAG_URL)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)) }
      })
    }
    return
  }
  RelevoButton(
    when {
      tag.test == TagTest.WORKING && tag.retry -> "Probando de otra forma…"
      tag.test == TagTest.WORKING -> "Probando…"
      else -> "Probar el Tag"
    },
    { withPermission(actions.onTagTest) },
    kind = ButtonKind.Secondary, icon = KitIcon.PROBAR, enabled = tag.test != TagTest.WORKING && tag.test != TagTest.ASKING,
  )
  Spacer(Modifier.height(12.dp))
  // Con el Bluetooth apagado basta el aviso de arriba.
  AnimatedVisibility(
    tag.test == TagTest.ASKING || tag.test == TagTest.SOUNDED || (tag.test == TagTest.FAILED && tag.problem != TagLink.Problem.BLUETOOTH_OFF),
    enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut(),
  ) {
    when {
      tag.test == TagTest.ASKING -> TagHeardQuestion(tag.retry, actions.onTagHeard)
      tag.test == TagTest.SOUNDED -> Column(verticalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.padding(horizontal = 4.dp)) {
        Text("Sonó. Al cumplirse el tiempo, pita hasta 30 segundos.", style = Relevo.type.body, color = Relevo.colors.ink)
        if (tag.button) Text("Un toque a su botón lo calla; mantenerlo apretado lo apaga.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
        if (!tag.linkLossOff) {
          Text("Este Tag mantiene su alarma de alejamiento: si el teléfono se aleja mucho mientras espera, puede pitar solo. Para callarlo, tócalo una vez.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
        }
      }
      tag.silent -> Notice(
        "Recibió la orden, pero no pitó. Apágalo y vuelve a encenderlo: mantén su botón apretado 3 segundos hasta que pite largo, y otra vez hasta que pite dos veces. Después pruébalo de nuevo. Si sigue sin pitar, elige otra salida.",
        title = "El Tag no pitó", tone = Tone.Error,
      )
      else -> Notice(tagProblem(tag.problem), title = "No sonó en el Tag", tone = Tone.Error)
    }
  }
  Spacer(Modifier.height(8.dp))
  PlainAction("Cómo usar el Tag", { guide = true }, icon = KitIcon.AYUDA)
  Spacer(Modifier.height(4.dp))
  PlainAction("Elegir otro Tag", actions.onTagForget, color = Relevo.colors.graphite, icon = KitIcon.CAMBIE)
  Spacer(Modifier.height(8.dp))
  Text(
    "Déjalo encendido donde empiezas. Relevo se conecta a él al activar el relevo y lo mantiene así hasta que suene.",
    style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp),
  )
}

/**
 * Después de pedirle al Tag que pite: solo la persona sabe si sonó (2.26). Las dos respuestas pesan lo
 * mismo; «No pitó» prueba otra forma.
 */
@Composable
private fun TagHeardQuestion(retry: Boolean, onAnswer: (Boolean) -> Unit) {
  Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(horizontal = 4.dp)) {
    Text("¿Lo escuchaste pitar?", style = Relevo.type.headline, color = Relevo.colors.ink)
    Text(
      if (retry) "Lo probamos de otra forma. Debió pitar 3 segundos seguidos." else "Debió pitar 3 segundos seguidos.",
      style = Relevo.type.footnote, color = Relevo.colors.graphite,
    )
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
      RelevoButton("Sí, pitó", { onAnswer(true) }, modifier = Modifier.weight(1f), kind = ButtonKind.Secondary)
      RelevoButton("No pitó", { onAnswer(false) }, modifier = Modifier.weight(1f), kind = ButtonKind.Secondary)
    }
  }
}

/** Selector de apps en una hoja alta, con buscador y marca redonda. */
@Composable
internal fun AppPickerSheet(apps: List<InstalledApp>, selected: Set<String>, onToggle: (InstalledApp) -> Unit, onDismiss: () -> Unit) {
  var query by rememberSaveable { mutableStateOf("") }
  val visible = remember(apps, query) { apps.filter { it.label.contains(query.trim(), ignoreCase = true) } }
  val colors = Relevo.colors
  RelevoSheet(onDismiss = onDismiss, title = "Elige las apps", done = "Listo", scrollable = false, tall = true) {
    SearchField(query, { query = it }, "Buscar")
    Spacer(Modifier.height(12.dp))
    LazyColumn(Modifier.fillMaxWidth().weight(1f), verticalArrangement = Arrangement.spacedBy(Gap.list)) {
      itemsIndexed(visible, key = { _, app -> app.packageName }) { index, app ->
        ListRow(app.label, leading = { AppIcon(app.packageName, 40.dp) }, onClick = { onToggle(app) }, trailing = { CheckMark(app.packageName in selected) }, selected = app.packageName in selected)
      }
    }
  }
}

/**
 * Ejemplo para el campo del primer paso (4.3): el primero que sugiere el catastro para esta actividad o, si
 * no hay, uno de leer. Reemplaza a «Algo que tome segundos», que el autor encontró demasiado abierta.
 */
private fun startExample(activity: String): String =
  "Ej.: " + (startSuggestions(activity).firstOrNull() ?: "Abrir el libro").replaceFirstChar { it.lowercase() }
