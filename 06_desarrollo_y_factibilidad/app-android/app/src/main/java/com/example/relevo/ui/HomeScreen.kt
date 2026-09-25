package com.example.relevo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.StudyCondition
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.StatusChip
import com.example.relevo.ui.components.Wordmark
import com.example.relevo.ui.components.formatDuration
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

internal class HomeActions(
  val onPrepare: () -> Unit,
  val onRepeat: () -> Unit,
  val onIdea: (ActivityIdea) -> Unit,
  val onCustom: (CustomActivity) -> Unit,
  val onDisarm: () -> Unit,
  val onSettings: () -> Unit,
  val onUsageSettings: () -> Unit,
  val onBackground: () -> Unit,
  val onDismissAcknowledgement: () -> Unit,
  val onDismissInstruction: (Int) -> Unit,
  val onWeekReview: () -> Unit,
  val onClosing: () -> Unit,
  val onDismissReturn: (Long) -> Unit,
)

/** B1 y B3: Inicio sin relevo, con uno activo (la firma con las palabras de la persona) o de regreso. */
@Composable
internal fun HomeScreen(
  reminder: Reminder,
  history: List<HistoryEntry>,
  customActivities: List<CustomActivity>,
  lastReminder: Reminder?,
  study: StudyState,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  acknowledgement: String?,
  returnDismissedFor: Long,
  actions: HomeActions,
) {
  val active = reminder.status == ReminderStatus.WAITING
  val last = history.firstOrNull()
  val daysSinceLast = last?.let {
    ChronoUnit.DAYS.between(Instant.ofEpochMilli(it.completedAt).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
  } ?: 0L
  // V1: dos días o más después del último relevo; no dice cuántos pasaron ni sugiere una falta.
  val returning = !active && last != null && daysSinceLast >= 2 && returnDismissedFor != last.completedAt

  RelevoScreen(
    leading = { Wordmark(height = 24.dp) },
    trailing = { SettingsButton(actions.onSettings) },
    bottom = {
      when {
        active -> RelevoButton("Desactivar el relevo", actions.onDisarm, kind = ButtonKind.Secondary)
        returning && lastReminder != null -> RelevoButton("Preparar de nuevo", actions.onRepeat)
        else -> RelevoButton("Preparar un relevo", actions.onPrepare, icon = KitIcon.AGREGAR)
      }
    },
  ) {
    StudyCards(study, actions.onDismissInstruction, actions.onWeekReview, actions.onClosing)
    AnimatedVisibility(acknowledgement != null, enter = expandVertically(Motion.standard()) + fadeIn(Motion.standard()), exit = shrinkVertically(Motion.standard()) + fadeOut(Motion.standard(Motion.SHORT))) {
      Column {
        Panel {
          Text(acknowledgement.orEmpty(), style = Relevo.type.headline, color = Relevo.colors.ink)
          PlainAction("Cerrar", actions.onDismissAcknowledgement, color = Relevo.colors.graphite)
        }
        SectionGap()
      }
    }
    when {
      active -> WaitingContent(reminder, usageAccess, backgroundUnrestricted, actions)
      returning && last != null -> ReturnContent(last, lastReminder, actions)
      else -> EmptyContent(lastReminder, customActivities, actions)
    }
  }
}

@Composable
private fun SettingsButton(onClick: () -> Unit) {
  Box(
    Modifier.size(48.dp).clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = "Ajustes" },
    contentAlignment = Alignment.Center,
  ) { RelevoIcon(KitIcon.AJUSTES) }
}

/** B3: la firma con las palabras de la persona. Sin cuenta regresiva: el avance es un dato más. */
@Composable
private fun WaitingContent(reminder: Reminder, usageAccess: Boolean, backgroundUnrestricted: Boolean, actions: HomeActions) {
  Spacer(Modifier.height(8.dp))
  StatusChip(KitIcon.ESPERANDO, "Esperando")
  Spacer(Modifier.height(20.dp))
  Signature(reminder.activity)
  Spacer(Modifier.height(14.dp))
  val where = if (reminder.signalRoute == SignalRoute.PHONE) "en este teléfono" else placePhrase(reminder.place)
  Text("Sonará $where después de ${formatDuration(reminder.requiredUsageSeconds)} en las apps elegidas.", style = Relevo.type.body, color = Relevo.colors.graphite)
  if (!usageAccess) {
    SectionGap()
    Notice(
      "Relevo dejó de contar porque se retiró el permiso de Tiempo de uso.",
      title = "El conteo está en pausa", icon = KitIcon.ADVERTENCIA,
    ) { PlainAction("Abrir ajustes de Android", actions.onUsageSettings) }
  }
  SectionGap()
  ListSection {
    FactRow(KitIcon.PRIMER_PASO, "Cómo empieza", reminder.howToStart)
    if (reminder.signalRoute == SignalRoute.PHONE) FactRow(KitIcon.LUGAR, "Lo que necesitas", reminder.place)
    else FactRow(KitIcon.PARLANTE, "Suena en", reminder.place)
    FactRow(KitIcon.APPS, "Apps", reminder.selectedApps.joinToString(", ") { it.label }, valueIsVoice = false)
    FactRow(KitIcon.USO, "Llevas", "${formatDuration(reminder.observedUsageSeconds)} de ${formatDuration(reminder.requiredUsageSeconds)}", valueIsVoice = false)
  }
  StudyConditionLine(reminder.studyCondition)
  if (!backgroundUnrestricted) {
    SectionGap()
    Notice(
      "Algunos teléfonos detienen apps para ahorrar batería. Para usar Relevo varios días, permite que funcione sin esa restricción.",
      title = "Funcionamiento en segundo plano", icon = KitIcon.BATERIA,
    ) { PlainAction("Permitir", actions.onBackground) }
  }
}

@Composable
private fun StudyConditionLine(code: String) {
  val condition = StudyCondition.fromCode(code.firstOrNull() ?: ' ') ?: return
  Text("Prueba: ${conditionName(condition).lowercase()}.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.fillMaxWidth())
}

/** V1: «Hola de nuevo». Las opciones pesan lo mismo; «Ahora no» la oculta hasta el próximo regreso. */
@Composable
private fun ReturnContent(last: HistoryEntry, lastReminder: Reminder?, actions: HomeActions) {
  Spacer(Modifier.height(12.dp))
  Text("Hola de nuevo.", style = Relevo.type.largeTitle, color = Relevo.colors.ink)
  Spacer(Modifier.height(12.dp))
  Text("La última vez preparaste: ${last.activity}. ¿Sigue siendo lo que quieres?", style = Relevo.type.body, color = Relevo.colors.graphite)
  SectionGap()
  Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
    if (lastReminder == null) PlainAction("Preparar de nuevo", actions.onPrepare, icon = KitIcon.REINTENTAR)
    PlainAction("Elegir otra actividad", actions.onPrepare, icon = KitIcon.ACTIVIDAD)
    PlainAction("Ahora no", { actions.onDismissReturn(last.completedAt) }, icon = KitIcon.CERRAR, color = Relevo.colors.graphite)
  }
}

/** Inicio vacío: invita sin prometer resultados. */
@Composable
private fun EmptyContent(lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  Spacer(Modifier.height(12.dp))
  Text("Todavía no hay nada preparado.", style = Relevo.type.body, color = Relevo.colors.graphite)
  Spacer(Modifier.height(6.dp))
  Text("¿Qué quieres hacer hoy?", style = Relevo.type.largeTitle, color = Relevo.colors.ink)
  SectionGap()
  if (lastReminder != null) {
    ListSection(title = "La última vez") {
      ListRow(
        lastReminder.activity, icon = iconForActivity(lastReminder.activity, customActivities),
        subtitle = "${lastReminder.selectedApps.joinToString(", ") { it.label }} · ${formatDuration(lastReminder.requiredUsageSeconds)}",
        chevron = true, onClick = actions.onRepeat,
      )
    }
    SectionGap()
  }
  if (customActivities.isNotEmpty()) {
    ListSection(title = "Tus actividades") {
      customActivities.forEach { activity ->
        ListRow(activity.name, icon = customIconOf(activity.icon), subtitle = activity.firstStep.takeIf { it.isNotBlank() }, chevron = true, onClick = { actions.onCustom(activity) })
      }
    }
    SectionGap()
  }
  ListSection(title = "Ideas") {
    activityIdeas.take(4).forEach { idea ->
      ListRow(idea.activity, icon = idea.icon, subtitle = idea.start, chevron = true, onClick = { actions.onIdea(idea) })
    }
  }
  Spacer(Modifier.height(4.dp))
  Row(Modifier.fillMaxWidth()) { PlainAction("Ver todas las actividades", actions.onPrepare, color = Relevo.colors.graphite) }
}
