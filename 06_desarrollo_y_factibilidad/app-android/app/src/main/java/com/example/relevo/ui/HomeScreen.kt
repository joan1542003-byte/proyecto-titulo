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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.sp
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.Profile
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.RouteTrack
import com.example.relevo.domain.SignalRoute
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.AuraBackground
import com.example.relevo.ui.components.AuraMood
import com.example.relevo.ui.components.Avatar
import com.example.relevo.ui.components.BackStyle
import com.example.relevo.ui.components.BigCounter
import com.example.relevo.ui.components.BrandMark
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.Chip
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.IconSentence
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
import com.example.relevo.ui.components.SentencePart
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
  val onDismissInstruction: (Int) -> Unit,
  val onWeekReview: () -> Unit,
  val onClosing: () -> Unit,
  val onDismissReturn: (Long) -> Unit,
  val onNotices: () -> Unit = {},
)

internal const val ACTIVE_PHOTO = "activo"

/** Aviso de batería: qué hacer y para qué, en una frase. */
internal const val BATTERY_TEXT = "Para que Relevo siga contando aunque pasen días, quítale la restricción de batería."

/**
 * B1: Inicio, compuesto como en «Relevo, la app» (3.2, D-131): arriba la marca y «Inicio»; el saludo en dos
 * tonos; lo más próximo (el relevo que cuenta sobre el aura, el regreso tras varios días o el paso de la
 * ruta) y, debajo, ideas y actividades en sus cielos, de a dos por fila.
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
  val title = when {
    returning -> if (name.isEmpty()) "Hola de nuevo." else "Hola de nuevo, $name."
    name.isEmpty() -> "Hola."
    else -> "Hola, $name."
  }
  val soft = when {
    active && usageAccess -> "Tu relevo está contando."
    active -> "Tu relevo está en pausa."
    returning -> "¿Sigue siendo lo que quieres?"
    else -> "¿Qué quieres hacer hoy?"
  }
  val nextTrack = routes.firstOrNull { it.currentStep != null }

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
    trailing = { BellButton(actions.onNotices) },
    scrollState = scroll,
  ) {
    StudyCards(study, actions.onDismissInstruction, actions.onWeekReview, actions.onClosing, firstRelevoDone = history.isNotEmpty())
    if (guided && !active && history.isEmpty()) {
      GuideTip("Empieza aquí: toca «Preparar un relevo». Te acompañamos paso a paso.")
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
          ActiveCard(reminder, usageAccess, actions.onOpenActive)
          Spacer(Modifier.height(Gap.list))
          SoundRow(reminder)
          if (!usageAccess) {
            Spacer(Modifier.height(Gap.list))
            Notice("Falta el permiso de Tiempo de uso.", title = "Relevo no puede contar el tiempo", icon = KitIcon.ADVERTENCIA) {
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
        nextTrack != null -> NextStepCard(nextTrack, actions)
        else -> {
          Panel {
            Text("¿Tienes algo en mente?", style = Relevo.type.title2, color = Relevo.colors.ink)
            Text("Anótalo y Relevo te avisa cuando lleves un rato en el teléfono.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
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
      if (lastReminder != null && !returning) {
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

/** La campana de los avisos, arriba a la derecha, como en la lámina «Inicio». */
@Composable
private fun BellButton(onClick: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  Box(
    Modifier.size(48.dp).pressScale(interaction, 0.9f).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = "Avisos y resúmenes" },
    contentAlignment = Alignment.Center,
  ) { RelevoIcon(KitIcon.AVISOS, size = 26.dp, tint = Relevo.colors.ink, background = Relevo.colors.paper) }
}

/** La imagen de la persona en un círculo blanco, arriba a la derecha; lleva a Perfil. */
@Composable
private fun AvatarButton(profile: Profile, onClick: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  Box(
    Modifier.size(48.dp).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = "Perfil" },
    contentAlignment = Alignment.Center,
  ) {
    Box(Modifier.size(42.dp).pressScale(interaction, 0.92f).shadow(6.dp, CircleShape, ambientColor = Color.Black.copy(alpha = .05f), spotColor = Color.Black.copy(alpha = .14f)).clip(CircleShape).background(Relevo.colors.card), contentAlignment = Alignment.Center) {
      Avatar(profile.image, profile.name, 42.dp, background = Relevo.colors.card)
    }
  }
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

/**
 * El relevo que cuenta, en Inicio (lámina «Inicio»): una tarjeta sobre el aura con «Contando», el tiempo
 * contado, la actividad, el avance y «Ver, editar o desactivar».
 */
@Composable
private fun ActiveCard(reminder: Reminder, usageAccess: Boolean, onOpen: () -> Unit) {
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  val interaction = remember { MutableInteractionSource() }
  val ink = Color(0xFF141312)
  Box(
    Modifier.fillMaxWidth().pressScale(interaction, 0.985f)
      .shadow(14.dp, Relevo.panelShape, ambientColor = Color.Black.copy(alpha = .04f), spotColor = Color.Black.copy(alpha = .16f))
      .clip(Relevo.panelShape)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Ver, editar o desactivar", onClick = onOpen),
  ) {
    SkyBackground(Sky.AURA, Modifier.matchParentSize())
    Column(Modifier.fillMaxWidth().padding(18.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Chip(if (usageAccess) "Contando" else "En pausa", background = Color.White, color = ink)
        Spacer(Modifier.weight(1f))
        Text(
          "${formatDuration(reminder.observedUsageSeconds)} de ${formatDuration(reminder.requiredUsageSeconds)}",
          style = Relevo.type.callout.copy(fontWeight = FontWeight.SemiBold, fontFeatureSettings = "tnum"), color = ink,
        )
      }
      Spacer(Modifier.height(14.dp))
      Text(reminder.activity.trim(), style = Relevo.type.title2, color = ink)
      Spacer(Modifier.height(12.dp))
      ProgressLine(progress, trackColor = Color.White.copy(alpha = .75f))
      Spacer(Modifier.height(12.dp))
      Text("Ver, editar o desactivar", style = Relevo.type.callout.copy(fontWeight = FontWeight.SemiBold), color = ink)
    }
  }
}

/** Dónde suena, en la ficha lima del lugar: «Suena junto al velador · en el Tag, cuando sumes 18 min más». */
@Composable
private fun SoundRow(reminder: Reminder) {
  val remaining = (reminder.requiredUsageSeconds - reminder.observedUsageSeconds).coerceAtLeast(0)
  val phone = reminder.signalRoute == SignalRoute.PHONE
  ListRow(
    if (phone) "Suena en el teléfono" else "Suena " + placePhrase(reminder.place),
    icon = KitIcon.LUGAR,
    subtitle = (if (phone) "" else "en " + routeName(reminder.signalRoute).replaceFirstChar { it.lowercase() } + ", ") + "cuando sumes ${formatDuration(remaining)} más",
  )
}

/**
 * Después de activar el primer relevo (D-090): qué pasa ahora, con los datos que la persona eligió.
 * Cierra la guía del primer relevo.
 */
@Composable
internal fun FirstRelevoActiveSheet(reminder: Reminder, onDismiss: () -> Unit) {
  val where = soundWhere(reminder)
  RelevoSheet(onDismiss = onDismiss, scrollable = false) {
    Text("Tu primer relevo está activo", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(10.dp))
    Text(
      "Usa el teléfono como siempre. Cuando sumes ${formatDuration(reminder.requiredUsageSeconds)} en ${reminder.selectedApps.joinToString(", ") { it.label }}, sonará $where.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.height(8.dp))
    Text("Cuando suene, la app te dirá qué hacer. Puedes ver o desactivar el relevo en Inicio.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(22.dp))
    RelevoButton("Entendido", onDismiss)
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
    RelevoButton("Preparar de nuevo", { actions.onRepeat(key) }, icon = KitIcon.REINTENTAR)
    Spacer(Modifier.height(10.dp))
  }
  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
    PlainAction("Elegir otra", actions.onPrepare)
    Text("·", style = Relevo.type.callout, color = Relevo.colors.graphite)
    PlainAction("Ahora no", { actions.onDismissReturn(last.completedAt) }, color = Relevo.colors.graphite)
  }
}

/** El paso actual de la ruta: su cielo, cómo empezar y dónde, y el botón para prepararlo. */
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
  RelevoButton("Preparar un relevo con este paso", { actions.onRouteStep(track.interest, step.id, key) })
  Spacer(Modifier.height(2.dp))
  Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { PlainAction("Preparar otro relevo", actions.onPrepare) }
}

/**
 * B3: «Tu relevo» mientras cuenta (lámina «Contando»): el aura a pantalla completa, el tiempo en grande al
 * centro y una frase con el primer paso y dónde suena. Editar, desactivar o eliminar piden confirmación en
 * una hoja, para no hacerlo sin querer.
 */
@Composable
internal fun ActiveScreen(
  reminder: Reminder,
  customActivities: List<CustomActivity>,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  photoKey: String?,
  onBack: () -> Unit,
  onDisarm: () -> Unit,
  onUsageSettings: () -> Unit,
  onBackground: () -> Unit,
  onDelete: () -> Unit = {},
  onEdit: () -> Unit = {},
) {
  var confirming by rememberSaveable { mutableStateOf(false) }
  var confirmingEdit by rememberSaveable { mutableStateOf(false) }
  var confirmingDelete by rememberSaveable { mutableStateOf(false) }
  val colors = Relevo.colors
  val phone = reminder.signalRoute == SignalRoute.PHONE
  val first = reminder.howToStart.trim().trimEnd('.').replaceFirstChar { it.lowercase() }
  RelevoScreen(
    onBack = onBack, backLabel = "Inicio", backStyle = BackStyle.Text,
    trailing = { Chip(if (usageAccess) "Contando" else "En pausa") },
    // Mientras cuenta, el aura respira lenta a pantalla completa: está ahí, pero no llama (D-121, D-128). Apagada, es papel.
    backdrop = { AuraBackground(Modifier.fillMaxSize(), mood = AuraMood.COUNTING) },
    bottom = {
      RelevoButton("Volver al inicio", onBack)
      Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
        PlainAction("Editar este relevo", { confirmingEdit = true })
        Text("·", style = Relevo.type.callout, color = colors.graphite)
        PlainAction("Desactivarlo", { confirming = true })
      }
    },
  ) {
    Column(Modifier.fillMaxWidth().padding(top = 44.dp, bottom = 40.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      BigCounter(reminder.observedUsageSeconds)
      Spacer(Modifier.height(4.dp))
      Text(
        "de ${formatDuration(reminder.requiredUsageSeconds)} en ${reminder.selectedApps.joinToString(" y ") { it.label }.ifBlank { "las apps que elegiste" }}",
        style = Relevo.type.body, color = colors.ink, textAlign = TextAlign.Center,
      )
    }
    Text(reminder.activity.trim(), style = Relevo.type.title2, color = colors.ink)
    Spacer(Modifier.height(8.dp))
    IconSentence(
      buildList {
        if (first.isNotEmpty()) {
          add(SentencePart.Words("Tu primer paso")); add(SentencePart.Tile(KitIcon.PRIMER_PASO, colors.sky)); add(SentencePart.Words(": $first. "))
        }
        if (phone) add(SentencePart.Words("Suena en el teléfono."))
        else {
          add(SentencePart.Words("Suena " + placePhrase(reminder.place))); add(SentencePart.Tile(KitIcon.LUGAR, colors.lime))
          add(SentencePart.Words(", en " + routeName(reminder.signalRoute).replaceFirstChar { it.lowercase() } + "."))
        }
      },
      style = Relevo.type.body.copy(fontWeight = FontWeight.Medium, lineHeight = 29.sp),
    )
    if (reminder.autoActivated) {
      Spacer(Modifier.height(8.dp))
      Text("Se activó solo, con la activación automática.", style = Relevo.type.subhead, color = colors.graphite)
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
        PlainAction("Quitar la restricción", onBackground)
      }
    }
  }
  if (confirmingEdit) {
    RelevoSheet(onDismiss = { confirmingEdit = false }, scrollable = false) {
      Text("¿Editar el relevo?", style = Relevo.type.title2, color = colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Puedes cambiar cualquier dato sin borrarlo. Mientras lo editas no cuenta; al activarlo de nuevo, sigue con el tiempo que llevabas si las apps son las mismas.", style = Relevo.type.body, color = colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Editar", { confirmingEdit = false; onEdit() })
      Spacer(Modifier.height(10.dp))
      RelevoButton("Cancelar", { confirmingEdit = false }, kind = ButtonKind.Secondary)
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
      Text("Dejará de contar el tiempo y no sonará. Después podrás decir qué decidiste.", style = Relevo.type.body, color = colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Desactivar", { confirming = false; onDisarm() }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(10.dp))
      RelevoButton("Mantenerlo", { confirming = false }, kind = ButtonKind.Secondary)
      Spacer(Modifier.height(6.dp))
      // 2.18: eliminar un relevo activado por error, sin preguntas ni guardarlo en tus relevos.
      Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        PlainAction("Lo activé por error: eliminarlo", { confirming = false; confirmingDelete = true }, color = colors.error)
      }
    }
  }
}
