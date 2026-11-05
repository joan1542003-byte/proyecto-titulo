package com.example.relevo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.Profile
import com.example.relevo.data.Settings
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.RouteTrack
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.AddRingCell
import com.example.relevo.ui.components.BigCounter
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Carousel
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.Chip
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.ProgressLine
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RingCell
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SectionHeader
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.enterBlur
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.pressScale
import kotlinx.coroutines.delay
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

internal class HomeActions(
  val onPrepare: () -> Unit,
  val onRepeat: (photoKey: String?) -> Unit,
  val onIdea: (ActivityIdea, String?) -> Unit,
  val onCustom: (CustomActivity, String?) -> Unit,
  val onRouteStep: (interest: String, stepId: String, photoKey: String?) -> Unit,
  val onNewActivity: () -> Unit,
  val onOpenActive: () -> Unit,
  val onOpenActivities: (ActivitiesSection) -> Unit,
  val onUsageSettings: () -> Unit,
  val onBackground: () -> Unit,
  val onDismissAcknowledgement: () -> Unit,
  val onDismissInstruction: (Int) -> Unit,
  val onWeekReview: () -> Unit,
  val onClosing: () -> Unit,
  val onDismissReturn: (Long) -> Unit,
)

internal const val ACTIVE_PHOTO = "activo"

/** Aviso de batería: qué hacer y para qué, en una frase. */
internal const val BATTERY_TEXT = "Para que Relevo siga contando aunque pasen días, quítale la restricción de batería."

/**
 * Inicio de la 4.0 (D-155), de arriba abajo: la fecha y el saludo; lo de la prueba si toca; lo más
 * próximo (el relevo que cuenta, el regreso tras unos días o «Preparar un relevo» con el paso sugerido);
 * un resumen de la semana que solo cuenta hechos, y tus actividades en anillos, a un toque. Sin campana
 * ni ajustes: esos viven en Perfil.
 */
@Composable
internal fun HomeTab(
  reminder: Reminder,
  history: List<HistoryEntry>,
  customActivities: List<CustomActivity>,
  lastReminder: Reminder?,
  study: StudyState,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  profile: Profile,
  routes: List<RouteTrack>,
  settings: Settings,
  acknowledgement: String?,
  returnDismissedFor: Long,
  changedRouteInterest: String?,
  reselect: Int,
  actions: HomeActions,
  onChangeRoute: (String) -> Unit,
  quickFeedbackDue: Boolean = false,
  onQuickFeedback: (Int?) -> Unit = {},
  onFeedback: () -> Unit = {},
  guided: Boolean = false,
  autoMode: Boolean = false,
  onAutoModeOff: () -> Unit = {},
) {
  val scroll = rememberScrollState()
  var firstReselect by remember { mutableStateOf(reselect) }
  LaunchedEffect(reselect) { if (reselect != firstReselect) scroll.animateScrollTo(0) else firstReselect = reselect }
  val active = reminder.status == ReminderStatus.WAITING
  val last = history.firstOrNull()
  val daysSinceLast = last?.let {
    ChronoUnit.DAYS.between(Instant.ofEpochMilli(it.completedAt).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
  } ?: 0L
  // V1: dos días o más después del último relevo; no dice cuántos pasaron ni sugiere una falta.
  val returning = !active && last != null && daysSinceLast >= 2 && returnDismissedFor != last.completedAt
  val name = profile.name.trim()
  val greeting = when {
    returning && name.isNotEmpty() -> "Hola de nuevo, $name"
    returning -> "Hola de nuevo"
    name.isNotEmpty() -> "Hola, $name"
    else -> "Hola"
  }
  val nextTrack = routes.firstOrNull { it.currentStep != null }

  RelevoScreen(title = greeting, eyebrow = todayLabel(), largeTitle = true, barTitle = "Inicio", scrollState = scroll) {
    StudyCards(study, actions.onDismissInstruction, actions.onWeekReview, actions.onClosing, firstRelevoDone = history.isNotEmpty())
    if (guided && !active && history.isEmpty()) {
      GuideTip("Empieza aquí: toca «Preparar un relevo».")
      Spacer(Modifier.height(Gap.block))
    }
    if (quickFeedbackDue && !active) {
      QuickFeedbackCard(onQuickFeedback, { onQuickFeedback(null); onFeedback() })
      Spacer(Modifier.height(Gap.block))
    }
    // D-095: con la activación automática, Inicio recuerda qué se activará y cómo apagarla.
    if (autoMode && !active && lastReminder != null) {
      Notice(
        "Al abrir ${lastReminder.selectedApps.joinToString(" o ") { it.label }}, empieza a contar «${lastReminder.activity}».",
        title = "Se activa solo", icon = KitIcon.ESPERANDO,
      ) { PlainAction("Apagar", onAutoModeOff) }
      Spacer(Modifier.height(Gap.block))
    }
    AcknowledgementToast(acknowledgement, changedRouteInterest, actions.onDismissAcknowledgement, onChangeRoute)
    Column(Modifier.appear(0)) {
      when {
        active -> {
          ActiveCard(reminder, usageAccess, customActivities, actions.onOpenActive)
          if (!usageAccess) {
            Spacer(Modifier.height(Gap.list))
            Notice("Falta el permiso de Tiempo de uso.", title = "Relevo no puede contar", icon = KitIcon.ADVERTENCIA) {
              PlainAction("Dar el permiso", actions.onUsageSettings)
            }
          }
          if (!backgroundUnrestricted) {
            Spacer(Modifier.height(Gap.list))
            Notice(BATTERY_TEXT, title = "Batería", icon = KitIcon.BATERIA) {
              PlainAction("Quitar la restricción", actions.onBackground)
            }
          }
        }
        returning && last != null -> ReturnCard(last, lastReminder, customActivities, actions)
        else -> PrepareBlock(nextTrack, lastReminder, customActivities, actions)
      }
    }
    if (settings.weeklySummary) {
      SectionGap()
      WeekBanner(history, customActivities, settings, Modifier.appear(1))
    }
    SectionGap()
    QuickActivities(customActivities, actions, Modifier.appear(2))
  }
}

/**
 * Lo que se puede preparar ahora: el botón principal y, debajo, dos atajos en un mismo grupo: el paso
 * sugerido de tu ruta y el último relevo.
 */
@Composable
private fun PrepareBlock(nextTrack: RouteTrack?, lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  RelevoButton("Preparar un relevo", actions.onPrepare, icon = KitIcon.AGREGAR)
  val step = nextTrack?.currentStep
  if (step != null || lastReminder != null) {
    Spacer(Modifier.height(Gap.block))
    ListSection(dividerInset = 70.dp) {
      if (nextTrack != null && step != null) {
        val key = photoKey("ruta", step.id)
        ListRow(
          step.activity, subtitle = "Tu paso en ${nextTrack.title.replaceFirstChar { it.lowercase() }}",
          leading = { ActivityRing(activityIcon(step.activity, customActivities), 42.dp, variant = activityVariant(step.activity)) },
          chevron = true, onClick = { actions.onRouteStep(nextTrack.interest, step.id, key) },
        )
      }
      if (lastReminder != null) {
        val key = photoKey("ultima", lastReminder.activity)
        ListRow(
          lastReminder.activity, subtitle = "Repetir el último · ${formatDuration(lastReminder.requiredUsageSeconds)}",
          leading = { ActivityRing(activityIcon(lastReminder.activity, customActivities), 42.dp, variant = activityVariant(lastReminder.activity)) },
          chevron = true, onClick = { actions.onRepeat(key) },
        )
      }
    }
  }
}

/**
 * Tu semana (4.0): un resumen de las actividades que hiciste esta semana, de lunes a hoy. Solo cuenta
 * hechos: cuántos relevos y en qué actividades. No compara con otras semanas, no dice qué faltó y no
 * premia (D-074). Se apaga en Ajustes › Avisos, con «Resumen semanal».
 */
@Composable
private fun WeekBanner(history: List<HistoryEntry>, customActivities: List<CustomActivity>, settings: Settings, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val monday = LocalDate.now().with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY))
  val thisWeek = history.filter { !Instant.ofEpochMilli(it.completedAt).atZone(ZoneId.systemDefault()).toLocalDate().isBefore(monday) }
  val byActivity = thisWeek.groupBy { it.activity.trim() }.map { (activity, entries) -> activity to entries.size }.sortedByDescending { it.second }
  Panel(modifier, padding = 18.dp) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Text("Tu semana", style = Relevo.type.headline, color = colors.ink, modifier = Modifier.weight(1f))
      if (thisWeek.isNotEmpty()) {
        Text(
          "${countWord(thisWeek.size, "relevo", "relevos")} · ${countWord(byActivity.size, "actividad", "actividades")}",
          style = Relevo.type.subhead, color = colors.graphite,
        )
      }
    }
    if (thisWeek.isEmpty()) {
      Text("Aquí verás lo que hagas esta semana.", style = Relevo.type.subhead, color = colors.graphite)
    } else {
      Spacer(Modifier.height(6.dp))
      Carousel(spacing = 14.dp) {
        items(byActivity, key = { it.first }) { (activity, count) ->
          RingCell(
            activityIcon(activity, customActivities), activity, onClick = null, size = 52.dp, variant = activityVariant(activity), count = count,
            description = "$activity, ${countWord(count, "vez", "veces")}",
          )
        }
      }
    }
    if (settings.constancy > 0 && !settings.constancyPaused) {
      Text("Elegiste ${countWord(settings.constancy, "vez", "veces")} por semana.", style = Relevo.type.footnote, color = colors.graphite)
    }
  }
}

/** Tus actividades a un toque. Sin actividades, la invitación a crear la primera y las ideas. */
@Composable
private fun QuickActivities(customActivities: List<CustomActivity>, actions: HomeActions, modifier: Modifier = Modifier) {
  Column(modifier) {
    SectionHeader("Tus actividades", action = "Ver todas", onAction = { actions.onOpenActivities(ActivitiesSection.MINE) })
    Spacer(Modifier.height(6.dp))
    Carousel(spacing = 14.dp) {
      items(customActivities, key = { it.id }) { custom ->
        RingCell(
          activityIcon(custom.name, customActivities), custom.name, onClick = { actions.onCustom(custom, photoKey("propia", custom.id)) },
          variant = activityVariant(custom.name), description = "Preparar «${custom.name}»",
        )
      }
      item(key = "nueva") { AddRingCell("Nueva", actions.onNewActivity) }
    }
    if (customActivities.isEmpty()) {
      Spacer(Modifier.height(10.dp))
      Text("Guarda lo que haces seguido y prepáralo en un toque.", style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 2.dp))
      Box(Modifier.fillMaxWidth()) { PlainAction("Ver ideas", { actions.onOpenActivities(ActivitiesSection.IDEAS) }) }
    }
  }
}

private fun countWord(count: Int, one: String, many: String) = if (count == 1) "1 $one" else "$count $many"

/**
 * Reconocimiento breve después de responder: sube con un leve desenfoque y se va solo. «Cambié de idea»
 * puede llevar a cambiar la actividad de la ruta.
 */
@Composable
private fun AcknowledgementToast(text: String?, changedRouteInterest: String?, onDismiss: () -> Unit, onChangeRoute: (String) -> Unit) {
  LaunchedEffect(text, changedRouteInterest) {
    if (text != null && changedRouteInterest == null) { delay(6_000); onDismiss() }
  }
  AnimatedVisibility(
    text != null,
    enter = expandVertically(Motion.smooth()) + fadeIn(Motion.standard()) + scaleIn(Motion.smooth(), initialScale = .94f),
    exit = shrinkVertically(Motion.smooth()) + fadeOut(Motion.standard(Motion.SHORT)),
  ) {
    Column(Modifier.enterBlur(this)) {
      Panel {
        Row(verticalAlignment = Alignment.CenterVertically) {
          CheckMark(true, size = 26.dp)
          Spacer(Modifier.width(12.dp))
          Text(text.orEmpty(), style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
        }
        if (changedRouteInterest != null) {
          Text("¿Cambias este paso por otra actividad?", style = Relevo.type.subhead, color = Relevo.colors.graphite)
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            RelevoButton("Cambiar", { onChangeRoute(changedRouteInterest) }, kind = ButtonKind.Secondary, compact = true)
            PlainAction("Ahora no", onDismiss, color = Relevo.colors.graphite)
          }
        }
      }
      Spacer(Modifier.height(Gap.block))
    }
  }
}

/**
 * El relevo que cuenta, en Inicio: su anillo, la actividad, dónde suena, el avance y cuánto falta. Tocarla
 * abre el relevo.
 */
@Composable
private fun ActiveCard(reminder: Reminder, usageAccess: Boolean, customActivities: List<CustomActivity>, onOpen: () -> Unit) {
  val colors = Relevo.colors
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  val remaining = (reminder.requiredUsageSeconds - reminder.observedUsageSeconds).coerceAtLeast(0)
  val interaction = remember { MutableInteractionSource() }
  Column(
    Modifier.fillMaxWidth().pressScale(interaction, 0.985f).clip(Relevo.panelShape).background(colors.card)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Ver tu relevo", onClick = onOpen)
      .padding(18.dp),
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      ActivityRing(activityIcon(reminder.activity, customActivities), 48.dp, variant = activityVariant(reminder.activity))
      Spacer(Modifier.width(14.dp))
      Column(Modifier.weight(1f)) {
        Text(reminder.activity.trim(), style = Relevo.type.title2, color = colors.ink, maxLines = 2, overflow = TextOverflow.Ellipsis)
        Text("Suena " + soundWhere(reminder), style = Relevo.type.subhead, color = colors.graphite, maxLines = 2)
      }
    }
    Spacer(Modifier.height(16.dp))
    ProgressLine(progress)
    Spacer(Modifier.height(12.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
      Chip(if (usageAccess) "Contando" else "En pausa", background = colors.mist)
      Spacer(Modifier.weight(1f))
      Text("Faltan ${formatDuration(remaining)}", style = Relevo.type.subhead.copy(fontWeight = FontWeight.SemiBold, fontFeatureSettings = "tnum"), color = colors.ink)
    }
  }
}

/**
 * Después de activar el primer relevo (D-090): qué pasa ahora, con los datos que la persona eligió.
 * Cierra la guía del primer relevo.
 */
@Composable
internal fun FirstRelevoActiveSheet(reminder: Reminder, onDismiss: () -> Unit) {
  RelevoSheet(onDismiss = onDismiss, scrollable = false) {
    Text("Tu primer relevo está activo", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(10.dp))
    Text(
      "Usa el teléfono como siempre. Al sumar ${formatDuration(reminder.requiredUsageSeconds)} en ${reminder.selectedApps.joinToString(", ") { it.label }}, suena ${soundWhere(reminder)}.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.height(8.dp))
    Text("Lo ves o lo desactivas en Inicio.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(22.dp))
    RelevoButton("Entendido", onDismiss)
  }
}

/** V1: «Hola de nuevo». La última actividad con su anillo; las opciones pesan lo mismo y «Ahora no» la oculta. */
@Composable
private fun ReturnCard(last: HistoryEntry, lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  val key = lastReminder?.let { photoKey("regreso", it.activity) }
  Panel(padding = 18.dp) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      ActivityRing(activityIcon(last.activity, customActivities), 48.dp, variant = activityVariant(last.activity))
      Spacer(Modifier.width(14.dp))
      Column(Modifier.weight(1f)) {
        Text("La última vez", style = Relevo.type.subhead, color = Relevo.colors.graphite)
        Text(last.activity, style = Relevo.type.title2, color = Relevo.colors.ink, maxLines = 2, overflow = TextOverflow.Ellipsis)
      }
    }
    Spacer(Modifier.height(8.dp))
    if (lastReminder != null) RelevoButton("Preparar de nuevo", { actions.onRepeat(key) }, icon = KitIcon.REINTENTAR)
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
      PlainAction("Elegir otra", actions.onPrepare)
      Text("·", style = Relevo.type.callout, color = Relevo.colors.graphite)
      PlainAction("Ahora no", { actions.onDismissReturn(last.completedAt) }, color = Relevo.colors.graphite)
    }
  }
}

/**
 * Tu relevo mientras cuenta (4.0): solo la actividad, cuánto falta y una acción, como pidió la revisión
 * del 28 de octubre (Tabla 4 de la memoria). Cambiar, desactivar o eliminar se eligen en una hoja que
 * explica qué pasa con cada opción, para no hacerlo sin querer. Sin aura: papel y el anillo de la actividad.
 */
@Composable
internal fun ActiveScreen(
  reminder: Reminder,
  customActivities: List<CustomActivity>,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  @Suppress("UNUSED_PARAMETER") photoKey: String?,
  onBack: () -> Unit,
  onDisarm: () -> Unit,
  onUsageSettings: () -> Unit,
  onBackground: () -> Unit,
  onDelete: () -> Unit = {},
  onEdit: () -> Unit = {},
) {
  var options by rememberSaveable { mutableStateOf(false) }
  var confirming by rememberSaveable { mutableStateOf(false) }
  var confirmingDelete by rememberSaveable { mutableStateOf(false) }
  val colors = Relevo.colors
  val remaining = (reminder.requiredUsageSeconds - reminder.observedUsageSeconds).coerceAtLeast(0)
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  RelevoScreen(
    onBack = onBack, backLabel = "Inicio", barTitle = null,
    trailing = { Chip(if (usageAccess) "Contando" else "En pausa", background = colors.mist) },
    bottom = { RelevoButton("Cambiar o desactivar", { options = true }, kind = ButtonKind.Secondary) },
  ) {
    Column(Modifier.fillMaxWidth().padding(top = 28.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      ActivityRing(activityIcon(reminder.activity, customActivities), 112.dp, variant = activityVariant(reminder.activity), modifier = Modifier.appear(0))
      Spacer(Modifier.height(20.dp))
      Text(reminder.activity.trim(), style = Relevo.type.title, color = colors.ink, textAlign = TextAlign.Center)
      Spacer(Modifier.height(36.dp))
      Text("Faltan", style = Relevo.type.subhead, color = colors.graphite)
      BigCounter(remaining)
      Text(
        "de ${formatDuration(reminder.requiredUsageSeconds)} en ${reminder.selectedApps.joinToString(" y ") { it.label }.ifBlank { "las apps que elegiste" }}",
        style = Relevo.type.subhead, color = colors.graphite, textAlign = TextAlign.Center,
      )
      Spacer(Modifier.height(18.dp))
      ProgressLine(progress, Modifier.padding(horizontal = 24.dp))
      if (reminder.autoActivated) {
        Spacer(Modifier.height(14.dp))
        Text("Se activó solo.", style = Relevo.type.footnote, color = colors.graphite)
      }
    }
    if (!usageAccess) {
      Spacer(Modifier.height(Gap.section))
      Notice("Falta el permiso de Tiempo de uso.", title = "Relevo no puede contar", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Dar el permiso", onUsageSettings)
      }
    }
    if (!backgroundUnrestricted) {
      Spacer(Modifier.height(Gap.block))
      Notice(BATTERY_TEXT, title = "Batería", icon = KitIcon.BATERIA) {
        PlainAction("Quitar la restricción", onBackground)
      }
    }
  }
  if (options) {
    RelevoSheet(onDismiss = { options = false }, scrollable = false) {
      Text("Tu relevo", style = Relevo.type.title2, color = colors.ink)
      Spacer(Modifier.height(16.dp))
      ListSection {
        ListRow("Editar", icon = KitIcon.EDITAR, subtitle = "Mientras lo editas no cuenta.", chevron = true, onClick = { options = false; onEdit() })
        ListRow("Desactivar", icon = KitIcon.DETENER, subtitle = "Deja de contar y no suena.", chevron = true, onClick = { options = false; confirming = true })
        ListRow("Eliminar", icon = KitIcon.BORRAR, subtitle = "Si lo activaste por error.", iconTint = colors.error, titleColor = colors.error, onClick = { options = false; confirmingDelete = true })
      }
    }
  }
  if (confirmingDelete) {
    RelevoSheet(onDismiss = { confirmingDelete = false }, scrollable = false) {
      Text("¿Eliminar este relevo?", style = Relevo.type.title2, color = colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Deja de contar, no suena y no queda en tus relevos.", style = Relevo.type.body, color = colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Eliminar", { confirmingDelete = false; onDelete() }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(10.dp))
      RelevoButton("Mantenerlo", { confirmingDelete = false }, kind = ButtonKind.Secondary)
    }
  }
  if (confirming) {
    RelevoSheet(onDismiss = { confirming = false }, scrollable = false) {
      Text("¿Desactivar el relevo?", style = Relevo.type.title2, color = colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Deja de contar y no suena. Después puedes decir qué decidiste.", style = Relevo.type.body, color = colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Desactivar", { confirming = false; onDisarm() }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(10.dp))
      RelevoButton("Mantenerlo", { confirming = false }, kind = ButtonKind.Secondary)
    }
  }
}
