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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.Profile
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.RouteTrack
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.AuraBackground
import com.example.relevo.ui.components.AuraMood
import com.example.relevo.ui.components.BackStyle
import com.example.relevo.ui.components.BigCounter
import com.example.relevo.ui.components.BrandMark
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.Chip
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.ProgressLine
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RowShape
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SectionHeader
import com.example.relevo.ui.components.SectionLabel
import com.example.relevo.ui.components.Sky
import com.example.relevo.ui.components.SkyBackground
import com.example.relevo.ui.components.SkyCard
import com.example.relevo.ui.components.SkySquare
import com.example.relevo.ui.components.TwoColumnGrid
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
  val onOpenRoute: (String) -> Unit,
  val onProfile: () -> Unit,
  val onUsageSettings: () -> Unit,
  val onBackground: () -> Unit,
  val onDismissAcknowledgement: () -> Unit,
  val onDismissReturn: (Long) -> Unit,
  val onNotices: () -> Unit,
  /** Lo que quedó para después (1.0.0): activarlo con un toque u ocultarlo. */
  val onLaterActivate: () -> Unit,
  val onLaterDismiss: () -> Unit,
  /** La pregunta por el tiempo, tras las primeras veces que sonó: true si la persona quiere cambiarlo. */
  val onLimitReview: (Boolean) -> Unit,
  /** El perfil, que se completa después del primer relevo (1.0.0). */
  val onProfileSetup: () -> Unit,
)

/** Aviso de batería: qué hacer y para qué, en una frase. Android lo llama «Sin restricciones» (R6). */
internal const val BATTERY_TEXT = "Para que Relevo siga contando aunque pasen días, deja su batería en «Sin restricciones»."

/**
 * B1: Inicio, compuesto como en «Relevo, la app» (3.2, D-131): arriba la marca y «Inicio»; el saludo en dos
 * tonos; lo más próximo —el relevo que cuenta, lo que quedó para después, el regreso tras varios días o el
 * paso de Actividades— y, debajo, ideas y actividades en sus cielos, de a dos por fila. Inicio muestra solo
 * lo más próximo: una tarjeta, no un tablero (documento 43, sección 9.2).
 */
@Composable
internal fun HomeTab(
  reminder: Reminder,
  history: List<HistoryEntry>,
  customActivities: List<CustomActivity>,
  lastReminder: Reminder?,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  profile: Profile,
  routes: List<RouteTrack>,
  acknowledgement: String?,
  returnDismissedFor: Long,
  changedRouteInterest: String?,
  reselect: Int,
  actions: HomeActions,
  onChangeRoute: (String) -> Unit,
  laterPending: Boolean = false,
  limitReviewDue: Boolean = false,
  quiet: Boolean = false,
  quietUntil: Int = 8,
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
  val later = laterPending && !active && lastReminder != null
  // V1: dos días o más después del último relevo; no dice cuántos pasaron ni sugiere una falta.
  val returning = !active && !later && last != null && daysSinceLast >= 2 && returnDismissedFor != last.completedAt
  val name = profile.name.trim()
  // Títulos sin punto final (R8 del estudio de los textos).
  val title = when {
    returning -> if (name.isEmpty()) "Hola de nuevo" else "Hola de nuevo, $name"
    name.isEmpty() -> "Hola"
    else -> "Hola, $name"
  }
  val soft = when {
    active && (!usageAccess || quiet) -> "Tu relevo está en pausa"
    active -> "Tu relevo está contando"
    returning -> "¿Sigue siendo lo que quieres?"
    else -> "¿Qué quieres hacer hoy?"
  }
  val nextTrack = routes.firstOrNull { it.currentStep != null }
  val profileDue = !profile.setupSeen && (history.isNotEmpty() || active)

  RelevoScreen(
    title = title,
    titleSoft = soft,
    leading = {
      Row(verticalAlignment = Alignment.CenterVertically) {
        BrandMark(size = 28.dp)
        Spacer(Modifier.width(9.dp))
        Text("Inicio", style = Relevo.type.headline, color = Relevo.colors.ink)
      }
    },
    trailing = { SettingsButton(actions.onNotices) },
    scrollState = scroll,
  ) {
    if (guided && !active && history.isEmpty()) {
      GuideTip("Empieza aquí: toca «Preparar un relevo». Relevo te guía paso a paso.")
      Spacer(Modifier.height(Gap.block))
    }
    if (profileDue) {
      Panel {
        Text("Completa tu perfil", style = Relevo.type.title2, color = Relevo.colors.ink)
        Text("Tu nombre, un emoji y lo que te gustaría hacer más seguido. Toma un minuto.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
        Spacer(Modifier.height(4.dp))
        RelevoButton("Completar mi perfil", actions.onProfileSetup, kind = ButtonKind.Secondary, compact = true)
      }
      Spacer(Modifier.height(Gap.block))
    }
    if (limitReviewDue && !active) {
      Panel {
        Text("¿El tiempo te queda bien?", style = Relevo.type.title2, color = Relevo.colors.ink)
        Text("Ya sonó 3 veces. Si cuando suena ya llevas mucho rato en una app, prueba con menos tiempo.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
        Spacer(Modifier.height(4.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
          RelevoButton("Cambiar el tiempo", { actions.onLimitReview(true) }, kind = ButtonKind.Secondary, compact = true)
          PlainAction("Está bien así", { actions.onLimitReview(false) }, color = Relevo.colors.graphite)
        }
      }
      Spacer(Modifier.height(Gap.block))
    }
    if (quickFeedbackDue && !active) {
      QuickFeedbackCard(onQuickFeedback, { onQuickFeedback(null); onFeedback() })
      Spacer(Modifier.height(Gap.block))
    }
    // D-095: con la activación automática, Inicio recuerda qué se activará y cómo apagarla.
    if (autoMode && !active && lastReminder != null) {
      Notice(
        "Cuando abras ${lastReminder.selectedApps.joinToString(" o ") { it.label }}, Relevo empieza a contar para «${lastReminder.activity}».",
        title = "Se activa solo", icon = KitIcon.ESPERANDO,
      ) { PlainAction("Apagar", onAutoModeOff) }
      Spacer(Modifier.height(Gap.block))
    }
    AcknowledgementToast(acknowledgement, changedRouteInterest, actions.onDismissAcknowledgement, onChangeRoute)
    Column(Modifier.appear(0)) {
      when {
        active -> {
          ActiveCard(reminder, counting = usageAccess && !quiet, actions.onOpenActive)
          if (quiet) {
            Spacer(Modifier.height(Gap.list))
            Text("Horas sin sonar: vuelve a contar a las $quietUntil:00.", style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
          }
          if (!usageAccess) {
            Spacer(Modifier.height(Gap.list))
            Notice("Falta el permiso de Tiempo de uso.", title = "Relevo no puede contar el tiempo", icon = KitIcon.ADVERTENCIA) {
              PlainAction("Dar el permiso", actions.onUsageSettings)
            }
          }
          if (!backgroundUnrestricted) {
            Spacer(Modifier.height(Gap.list))
            Notice(BATTERY_TEXT, title = "Batería", icon = KitIcon.BATERIA) {
              PlainAction("Cambiar la batería", actions.onBackground)
            }
          }
        }
        later -> LaterCard(lastReminder, customActivities, actions)
        returning -> ReturnCard(last, lastReminder, customActivities, actions)
        nextTrack != null -> NextStepCard(nextTrack, actions)
        else -> {
          Panel {
            Text("¿Tienes algo en mente?", style = Relevo.type.title2, color = Relevo.colors.ink)
            Text("Anótalo y Relevo suena cuando lleves un rato en el teléfono.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
          }
          Spacer(Modifier.height(Gap.block))
          RelevoButton("Preparar un relevo", actions.onPrepare, icon = KitIcon.AGREGAR)
        }
      }
    }
    if (!active) {
      SectionGap()
      SectionHeader("Ideas", Modifier.appear(1), action = "Ver todas", onAction = actions.onPrepare)
      Spacer(Modifier.height(4.dp))
      TwoColumnGrid(homeIdeas, Modifier.appear(2)) { idea, cell ->
        val key = photoKey("idea", idea.activity)
        SkyCard(idea.activity, iconOf(idea), cell, aspect = 1.15f, onClick = { actions.onIdea(idea, key) }, variant = activityVariant(idea.activity), sharedKey = key)
      }
      SectionGap()
      SectionLabel("Tus actividades", Modifier.appear(3).padding(bottom = 10.dp))
      Column(Modifier.appear(4), verticalArrangement = Arrangement.spacedBy(Gap.list)) {
        if (customActivities.isNotEmpty()) {
          TwoColumnGrid(customActivities) { custom, cell ->
            val key = photoKey("propia", custom.id)
            val icon = activityIcon(custom.name, customActivities)
            SkyCard(custom.name, icon, cell, aspect = 1.15f, onClick = { actions.onCustom(custom, key) }, variant = activityVariant(custom.name), sharedKey = key)
          }
        } else {
          Text("Guarda lo que haces seguido y prepáralo en un toque.", style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 2.dp))
        }
        CreateActivityRow(actions.onNewActivity)
      }
      if (lastReminder != null && !returning && !later) {
        SectionGap()
        SectionLabel("La última vez", Modifier.padding(bottom = 10.dp))
        val key = photoKey("ultima", lastReminder.activity)
        ListRow(
          lastReminder.activity,
          subtitle = "${formatDuration(lastReminder.requiredUsageSeconds)} en ${lastReminder.selectedApps.joinToString(", ") { it.label }}",
          leading = { SkySquare(activityIcon(lastReminder.activity, customActivities), variant = activityVariant(lastReminder.activity)) },
          chevron = true, onClick = { actions.onRepeat(key) },
        )
      }
    }
  }
}

private fun iconOf(idea: ActivityIdea): KitIcon = com.example.relevo.ui.components.pictureIcon(idea.picture)

/** Los ajustes de los relevos, arriba a la derecha. */
@Composable
private fun SettingsButton(onClick: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  Box(
    Modifier.size(48.dp).pressScale(interaction, 0.9f).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = "Ajustes de tus relevos" },
    contentAlignment = Alignment.Center,
  ) { RelevoIcon(KitIcon.AJUSTES, size = 26.dp, tint = Relevo.colors.ink, background = Relevo.colors.paper) }
}

/** «Crear una actividad»: una fila con el degradado de la marca y el signo más en blanco, como en la lámina. */
@Composable
private fun CreateActivityRow(onClick: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  val ink = Color(0xFF141312)
  Row(
    Modifier.fillMaxWidth().heightIn(min = 64.dp).pressScale(interaction, 0.985f).clip(RowShape)
      .background(Brush.horizontalGradient(0f to Color(0xFFFBE68A), .45f to Color(0xFFFCEFD8), .75f to Color(0xFFF9D7E6), 1f to Color(0xFFE3D6FA)))
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .padding(start = 18.dp, end = 12.dp, top = 10.dp, bottom = 10.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text("Crear una actividad", style = Relevo.type.headline, color = ink, modifier = Modifier.weight(1f))
    Box(Modifier.size(42.dp).clip(RoundedCornerShape(14.dp)).background(Color.White), contentAlignment = Alignment.Center) {
      RelevoIcon(KitIcon.AGREGAR, size = 22.dp, tint = ink, background = Color.White, strokeWidth = 2f)
    }
  }
}

/**
 * Unas palabras después de responder: suben con un leve desenfoque y se van solas. «Cambié de idea»
 * puede llevar a cambiar la actividad de un paso.
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
          CheckMark(true, size = 28.dp)
          Spacer(Modifier.width(14.dp))
          Text(text.orEmpty(), style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
        }
        if (changedRouteInterest != null) {
          Text("¿Quieres cambiar este paso por otra actividad?", style = Relevo.type.subhead, color = Relevo.colors.graphite)
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            RelevoButton("Cambiar la actividad", { onChangeRoute(changedRouteInterest) }, kind = ButtonKind.Secondary, compact = true)
            PlainAction("Ahora no", onDismiss, color = Relevo.colors.graphite)
          }
        }
      }
      Spacer(Modifier.height(Gap.block))
    }
  }
}

/** El relevo que cuenta, en Inicio: la actividad, el tiempo que falta y el avance, sobre el aura. Tocarlo lo abre. */
@Composable
private fun ActiveCard(reminder: Reminder, counting: Boolean, onOpen: () -> Unit) {
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  val remaining = (reminder.requiredUsageSeconds - reminder.observedUsageSeconds).coerceAtLeast(0)
  val interaction = remember { MutableInteractionSource() }
  val ink = Color(0xFF141312)
  Box(
    Modifier.fillMaxWidth().pressScale(interaction, 0.985f)
      .shadow(14.dp, Relevo.panelShape, ambientColor = Color.Black.copy(alpha = .04f), spotColor = Color.Black.copy(alpha = .16f))
      .clip(Relevo.panelShape)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Ver tu relevo", onClick = onOpen),
  ) {
    SkyBackground(Sky.AURA, Modifier.matchParentSize())
    Column(Modifier.fillMaxWidth().padding(18.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Chip(if (counting) "Contando" else "En pausa", background = Color.White, color = ink)
        Spacer(Modifier.weight(1f))
        RelevoIcon(KitIcon.SIGUIENTE, size = 20.dp, tint = ink, background = Color.White)
      }
      Spacer(Modifier.height(14.dp))
      Text(reminder.activity.trim(), style = Relevo.type.title2, color = ink)
      Spacer(Modifier.height(4.dp))
      Text("Faltan ${formatDuration(remaining)}", style = Relevo.type.callout.copy(fontWeight = FontWeight.SemiBold, fontFeatureSettings = "tnum"), color = ink)
      Spacer(Modifier.height(12.dp))
      ProgressLine(progress, trackColor = Color.White.copy(alpha = .75f))
    }
  }
}

/**
 * Lo que quedó para después (1.0.0): la persona respondió «La dejé para después» y pidió dejarlo listo. Se
 * activa con un toque, tal como estaba; no suena solo. «Ahora no» lo oculta.
 */
@Composable
private fun LaterCard(lastReminder: Reminder, customActivities: List<CustomActivity>, actions: HomeActions) {
  SectionLabel("Para después", Modifier.padding(bottom = 10.dp))
  SkyCard(
    lastReminder.activity, activityIcon(lastReminder.activity, customActivities), aspect = 2.1f, variant = activityVariant(lastReminder.activity), largeLabel = true,
    onClick = actions.onLaterActivate, description = "Activar «${lastReminder.activity}»",
  )
  Spacer(Modifier.height(Gap.list))
  Text(
    "${formatDuration(lastReminder.requiredUsageSeconds)} en ${lastReminder.selectedApps.joinToString(", ") { it.label }} · suena ${soundWhere(lastReminder)}",
    style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp),
  )
  Spacer(Modifier.height(Gap.block))
  RelevoButton("Activar ahora", actions.onLaterActivate)
  Spacer(Modifier.height(2.dp))
  Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { PlainAction("Ahora no", actions.onLaterDismiss, color = Relevo.colors.graphite) }
}

/**
 * Después de activar el primer relevo (D-090): qué pasa ahora, con los datos que la persona eligió. Desde
 * 1.0.0 ofrece completar el perfil, que ya no se pide antes del primer relevo.
 */
@Composable
internal fun FirstRelevoActiveSheet(reminder: Reminder, onDismiss: () -> Unit, onProfile: (() -> Unit)? = null) {
  val where = soundWhere(reminder)
  RelevoSheet(onDismiss = onDismiss, scrollable = false) {
    Text("Tu primer relevo está activo", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(10.dp))
    Text(
      "Usa el teléfono como siempre. Cuando sumes ${formatDuration(reminder.requiredUsageSeconds)} en ${reminder.selectedApps.joinToString(", ") { it.label }}, sonará $where.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.height(8.dp))
    Text("Cuando suene, Relevo te dice qué hacer. Puedes ver o desactivar el relevo en Inicio.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    if (onProfile != null) {
      Spacer(Modifier.height(8.dp))
      Text("Mientras tanto, completa tu perfil: tu nombre, un emoji y lo que te gustaría hacer más seguido.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Completar mi perfil", onProfile)
      Spacer(Modifier.height(10.dp))
      RelevoButton("Ahora no", onDismiss, kind = ButtonKind.Secondary)
    } else {
      Spacer(Modifier.height(22.dp))
      RelevoButton("Entendido", onDismiss)
    }
  }
}

/** V1: «Hola de nuevo». La última actividad en su cielo; las opciones pesan lo mismo y «Ahora no» la oculta. */
@Composable
private fun ReturnCard(last: HistoryEntry, lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  val key = lastReminder?.let { photoKey("regreso", it.activity) }
  SectionLabel("La última vez", Modifier.padding(bottom = 10.dp))
  SkyCard(
    last.activity, activityIcon(last.activity, customActivities), aspect = 2.1f, variant = activityVariant(last.activity), sharedKey = key, largeLabel = true,
    onClick = if (lastReminder != null) ({ actions.onRepeat(key) }) else null,
  )
  Spacer(Modifier.height(Gap.block))
  if (lastReminder != null) {
    RelevoButton("Preparar otra vez", { actions.onRepeat(key) }, icon = KitIcon.REINTENTAR)
    Spacer(Modifier.height(10.dp))
  }
  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
    PlainAction("Elegir otra", actions.onPrepare)
    Text("·", style = Relevo.type.callout, color = Relevo.colors.graphite)
    PlainAction("Ahora no", { actions.onDismissReturn(last.completedAt) }, color = Relevo.colors.graphite)
  }
}

/** El paso actual de Actividades: su cielo, cómo empezar y dónde, y el botón para prepararlo. */
@Composable
private fun NextStepCard(track: RouteTrack, actions: HomeActions) {
  val step = track.currentStep ?: return
  val key = photoKey("ruta", step.id)
  SectionLabel("Tu siguiente paso", Modifier.padding(bottom = 10.dp), soft = "para " + track.title.replaceFirstChar { it.lowercase() })
  SkyCard(
    step.activity, activityIcon(step.activity, emptyList()), aspect = 2.1f, variant = activityVariant(step.activity), sharedKey = key, largeLabel = true,
    onClick = { actions.onRouteStep(track.interest, step.id, key) }, description = "Preparar «${step.activity}»",
  )
  if (step.firstStep.isNotBlank() || step.place.isNotBlank()) {
    Spacer(Modifier.height(Gap.list))
    Column(verticalArrangement = Arrangement.spacedBy(Gap.list)) {
      if (step.firstStep.isNotBlank()) ListRow(step.firstStep.trim(), icon = KitIcon.PRIMER_PASO, subtitle = "Para empezar")
      if (step.place.isNotBlank()) ListRow(step.place.trim(), icon = KitIcon.LUGAR, subtitle = "Dónde empiezas")
    }
  }
  Spacer(Modifier.height(Gap.block))
  RelevoButton("Preparar este paso", { actions.onRouteStep(track.interest, step.id, key) })
  Spacer(Modifier.height(2.dp))
  Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { PlainAction("Preparar otro relevo", actions.onPrepare) }
}

/**
 * B3: tu relevo mientras cuenta (lámina «Contando»). Desde 1.0.0 muestra solo lo necesario, como pidió la
 * comisión: la actividad, el tiempo que falta y una sola acción, «Cambiar o desactivar», que abre las
 * opciones. Editar, desactivar o eliminar piden confirmación, para no hacerlo sin querer.
 */
@Composable
internal fun ActiveScreen(
  reminder: Reminder,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  quiet: Boolean,
  quietUntil: Int,
  onBack: () -> Unit,
  onDisarm: () -> Unit,
  onUsageSettings: () -> Unit,
  onBackground: () -> Unit,
  onDelete: () -> Unit,
  onEdit: () -> Unit,
) {
  var options by rememberSaveable { mutableStateOf(false) }
  var confirming by rememberSaveable { mutableStateOf(false) }
  var confirmingEdit by rememberSaveable { mutableStateOf(false) }
  var confirmingDelete by rememberSaveable { mutableStateOf(false) }
  val colors = Relevo.colors
  val remaining = (reminder.requiredUsageSeconds - reminder.observedUsageSeconds).coerceAtLeast(0)
  val counting = usageAccess && !quiet
  RelevoScreen(
    onBack = onBack, backLabel = "Inicio", backStyle = BackStyle.Text,
    trailing = { Chip(if (counting) "Contando" else "En pausa") },
    // Mientras cuenta, el aura respira lenta a pantalla completa: está ahí, pero no llama (D-121, D-128).
    backdrop = { AuraBackground(Modifier.fillMaxSize(), mood = AuraMood.COUNTING) },
    bottom = { RelevoButton("Cambiar o desactivar", { options = true }, kind = ButtonKind.Secondary) },
  ) {
    Column(Modifier.fillMaxWidth().padding(top = 36.dp, bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      Text(reminder.activity.trim(), style = Relevo.type.title, color = colors.ink, textAlign = TextAlign.Center)
      Spacer(Modifier.height(18.dp))
      Text("Faltan", style = Relevo.type.callout, color = colors.ink)
      BigCounter(remaining)
      Text(
        "en ${reminder.selectedApps.joinToString(" y ") { it.label }.ifBlank { "las apps que elegiste" }}",
        style = Relevo.type.body, color = colors.ink, textAlign = TextAlign.Center,
      )
    }
    if (quiet) {
      Text("Horas sin sonar: vuelve a contar a las $quietUntil:00.", style = Relevo.type.subhead, color = colors.graphite, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
    }
    if (!usageAccess) {
      Spacer(Modifier.height(Gap.block))
      Notice("Falta el permiso de Tiempo de uso.", title = "Relevo no puede contar el tiempo", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Dar el permiso", onUsageSettings)
      }
    }
    if (!backgroundUnrestricted) {
      Spacer(Modifier.height(Gap.block))
      Notice(BATTERY_TEXT, title = "Batería", icon = KitIcon.BATERIA) {
        PlainAction("Cambiar la batería", onBackground)
      }
    }
  }
  if (options) {
    RelevoSheet(onDismiss = { options = false }, scrollable = false) {
      Text(reminder.activity.trim(), style = Relevo.type.title2, color = colors.ink)
      Spacer(Modifier.height(6.dp))
      Text(
        listOfNotNull(
          startLine(reminder.howToStart, ""),
          "Suena ${soundWhere(reminder)}, al sumar ${formatDuration(reminder.requiredUsageSeconds)}.",
          if (reminder.autoActivated) "Se activó solo, con la activación automática." else null,
        ).joinToString(" "),
        style = Relevo.type.subhead, color = colors.graphite,
      )
      Spacer(Modifier.height(22.dp))
      RelevoButton("Editar el relevo", { options = false; confirmingEdit = true }, kind = ButtonKind.Secondary, icon = KitIcon.EDITAR)
      Spacer(Modifier.height(10.dp))
      RelevoButton("Desactivar el relevo", { options = false; confirming = true }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(6.dp))
      Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        PlainAction("Lo activé por error: eliminarlo", { options = false; confirmingDelete = true }, color = colors.error)
      }
    }
  }
  if (confirmingEdit) {
    RelevoSheet(onDismiss = { confirmingEdit = false }, scrollable = false) {
      Text("¿Editar el relevo?", style = Relevo.type.title2, color = colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Puedes cambiar cualquier dato sin borrarlo. Mientras lo editas no cuenta; al activarlo otra vez, sigue con el tiempo que llevabas si las apps son las mismas.", style = Relevo.type.body, color = colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Editar", { confirmingEdit = false; onEdit() })
      Spacer(Modifier.height(10.dp))
      RelevoButton("Mantenerlo así", { confirmingEdit = false }, kind = ButtonKind.Secondary)
    }
  }
  if (confirmingDelete) {
    RelevoSheet(onDismiss = { confirmingDelete = false }, scrollable = false) {
      Text("¿Eliminar este relevo?", style = Relevo.type.title2, color = colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Deja de contar, no sonará y no queda en tus relevos. Sirve si lo activaste por error.", style = Relevo.type.body, color = colors.graphite)
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
      Text("Deja de contar el tiempo y no sonará. Después puedes decir qué decidiste.", style = Relevo.type.body, color = colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Desactivar", { confirming = false; onDisarm() }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(10.dp))
      RelevoButton("Mantenerlo", { confirming = false }, kind = ButtonKind.Secondary)
    }
  }
}
