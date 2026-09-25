package com.example.relevo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.data.CustomActivity
import com.example.relevo.domain.Reminder
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
import com.example.relevo.ui.components.rememberReduceMotion
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
 * B2: seis pasos con avance continuo. «Seguir» ocupa siempre el mismo lugar y volver con el
 * gesto conserva lo escrito. Un relevo repetido llega completo y abre en la revisión.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun PrepareScreen(
  reminder: Reminder,
  apps: List<InstalledApp>,
  customActivities: List<CustomActivity>,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  studyCondition: StudyCondition?,
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

  RelevoScreen(
    title = step.title,
    onBack = { back() },
    backLabel = if (step == PrepareStep.ACTIVITY) "Cancelar" else "Volver",
    step = "${step.ordinal + 1} de ${PrepareStep.entries.size}",
    progress = (step.ordinal + 1f) / PrepareStep.entries.size,
    bottom = {
      if (step == PrepareStep.REVIEW) {
        RelevoButton("Activar el relevo", {
          if (saveActivity && !isKnown) {
            actions.onSaveCustom(CustomActivity(UUID.randomUUID().toString(), reminder.activity.trim(), reminder.howToStart.trim(), reminder.place.trim(), KitIcon.ACTIVIDAD.name, 0))
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
        else if (forward) (slideInHorizontally(Motion.standard()) { it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.standard()) { -it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
        else (slideInHorizontally(Motion.standard()) { -it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.standard()) { it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
      },
      label = "prepare_step",
    ) { current ->
      Column(Modifier.fillMaxWidth()) {
        when (current) {
          PrepareStep.ACTIVITY -> {
            RenglonField("Actividad", reminder.activity, actions.onActivity, placeholder = "Ejemplo: leer", imeAction = ImeAction.Next, onImeAction = { if (canContinue) go(PrepareStep.START) })
            SectionGap()
            Text("IDEAS", style = Relevo.type.label, color = Relevo.colors.graphite)
            Spacer(Modifier.height(10.dp))
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
              activityIdeas.forEach { idea ->
                QuickChoice(idea.activity, reminder.activity.equals(idea.activity, true), { actions.onIdea(idea.activity, idea.start, idea.place) }, icon = idea.icon)
              }
            }
            if (customActivities.isNotEmpty()) {
              SectionGap()
              Text("TUS ACTIVIDADES", style = Relevo.type.label, color = Relevo.colors.graphite)
              Spacer(Modifier.height(10.dp))
              FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                customActivities.forEach { custom ->
                  QuickChoice(custom.name, reminder.activity.equals(custom.name, true), { actions.onIdea(custom.name, custom.firstStep, custom.place) }, icon = customIconOf(custom.icon))
                }
              }
            }
          }
          PrepareStep.START -> {
            Text("Una acción breve y concreta, lo primero que harías.", style = Relevo.type.body, color = Relevo.colors.graphite)
            SectionGap()
            RenglonField("Primer paso", reminder.howToStart, actions.onStart, placeholder = "Ejemplo: sacar la guitarra del estuche", imeAction = ImeAction.Next, onImeAction = { if (canContinue) go(PrepareStep.PLACE) })
          }
          PrepareStep.PLACE -> {
            Text(
              when (studyCondition) {
                null -> "Deja el parlante junto a lo que necesitas para empezar."
                StudyCondition.PHONE -> "${conditionInstruction(studyCondition)} Anota dónde está lo que necesitas para empezar."
                else -> conditionInstruction(studyCondition)
              },
              style = Relevo.type.body, color = Relevo.colors.graphite,
            )
            studyCondition?.let(::conditionDetail)?.let { Spacer(Modifier.height(6.dp)); Text(it, style = Relevo.type.footnote, color = Relevo.colors.graphite) }
            SectionGap()
            RenglonField(
              when (studyCondition) {
                StudyCondition.PHONE -> "Lo que necesitas está"
                StudyCondition.NEUTRAL -> "El parlante está"
                else -> "Lugar"
              },
              reminder.place, actions.onPlace,
              placeholder = if (studyCondition == StudyCondition.NEUTRAL) "Ejemplo: en la repisa del living" else "Ejemplo: junto a las zapatillas",
              onImeAction = { if (canContinue) go(PrepareStep.USAGE) },
            )
          }
          PrepareStep.USAGE -> UsageStep(reminder, usageAccess, actions, onPick = { picking = true })
          PrepareStep.SOUND -> SoundStep(reminder, studyCondition, actions)
          PrepareStep.REVIEW -> {
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
      ListRow(app.label, leading = { AppIcon(app.packageName, 32.dp) })
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
  if (studyCondition != null) {
    Text("Lo decide la condición de esta semana: ${conditionName(studyCondition).lowercase()}.", style = Relevo.type.body, color = Relevo.colors.graphite)
    SectionGap()
  } else {
    Text("Elige dónde sonará la señal. Puedes probarla antes de activar.", style = Relevo.type.body, color = Relevo.colors.graphite)
    SectionGap()
  }
  ListSection {
    RouteRow(KitIcon.PARLANTE, "Parlante", if (speakerConnected) "Conectado por Bluetooth" else "Sin parlante conectado",
      selected = reminder.signalRoute == SignalRoute.BLUETOOTH, enabled = studyCondition == null) { actions.onRoute(SignalRoute.BLUETOOTH) }
    RouteRow(KitIcon.TELEFONO, "Este teléfono", "No suena en el lugar de la actividad",
      selected = reminder.signalRoute == SignalRoute.PHONE, enabled = studyCondition == null) { actions.onRoute(SignalRoute.PHONE) }
  }
  SectionGap()
  RelevoButton("Probar el sonido", { tested = if (actions.onTestSound()) 1 else 2 }, kind = ButtonKind.Secondary, icon = KitIcon.PROBAR)
  Spacer(Modifier.height(12.dp))
  when (tested) {
    1 -> Text("Así va a sonar. ¿Lo escuchaste?", style = Relevo.type.body, color = Relevo.colors.ink)
    2 -> Notice(if (reminder.signalRoute == SignalRoute.BLUETOOTH) "No sonó en el parlante. Revisa que esté encendido y conectado." else "No sonó en el teléfono. Revisa el volumen.", tone = Tone.Error)
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
  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = sheetState,
    containerColor = Relevo.colors.paper,
    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
    dragHandle = { Box(Modifier.padding(top = 10.dp, bottom = 6.dp).width(36.dp).height(5.dp).background(Relevo.colors.line, RoundedCornerShape(3.dp))) },
  ) {
    Column(Modifier.padding(horizontal = Relevo.margin)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Elige las apps", style = Relevo.type.title2, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
        PlainAction("Listo", onDismiss)
      }
      Text("El tiempo de las apps elegidas se suma hasta el límite.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      Spacer(Modifier.height(14.dp))
      SearchField(query, { query = it }, "Buscar apps")
      Spacer(Modifier.height(8.dp))
    }
    LazyColumn(Modifier.fillMaxWidth().padding(horizontal = Relevo.margin).navigationBarsPadding()) {
      items(visible, key = { it.packageName }) { app ->
        ListRow(app.label, leading = { AppIcon(app.packageName, 32.dp) }, onClick = { onToggle(app) }, trailing = { CheckMark(app.packageName in selected) })
      }
      item { Spacer(Modifier.height(24.dp)) }
    }
  }
}
