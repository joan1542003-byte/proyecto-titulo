package com.example.relevo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.Profile
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.RouteTrack
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.StudyCondition
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.Avatar
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Carousel
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.PhotoCard
import com.example.relevo.ui.components.PhotoImage
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PictureContent
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.ProgressLine
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SectionHeader
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.StatusChip
import com.example.relevo.ui.components.Wordmark
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.pressScale
import com.example.relevo.ui.components.sharedPhoto
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
)

internal const val ACTIVE_PHOTO = "activo"

/**
 * B1: Inicio. Saluda por el nombre, muestra el relevo activo, el regreso tras varios días (V1) o el
 * siguiente paso de la ruta, y ofrece ideas con foto. La acción principal está siempre abajo.
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
  val nextTrack = routes.firstOrNull { it.currentStep != null }

  RelevoScreen(
    title = title,
    eyebrow = todayLabel(),
    leading = { Wordmark(height = 22.dp) },
    trailing = {
      Box(
        Modifier.padding(end = 4.dp).size(48.dp).clip(RoundedCornerShape(12.dp))
          .clickable(role = Role.Button, onClick = actions.onProfile).semantics { contentDescription = "Perfil" },
        contentAlignment = Alignment.Center,
      ) { Avatar(profile.image, profile.name, 34.dp) }
    },
    scrollState = scroll,
    insetBottom = false,
    bottom = {
      when {
        active -> RelevoButton("Ver mi relevo", actions.onOpenActive, icon = KitIcon.ESPERANDO)
        returning && lastReminder != null -> RelevoButton("Preparar de nuevo", { actions.onRepeat(photoKey("regreso", lastReminder.activity)) }, icon = KitIcon.REINTENTAR)
        else -> RelevoButton("Preparar un relevo", actions.onPrepare, icon = KitIcon.AGREGAR)
      }
    },
  ) {
    StudyCards(study, actions.onDismissInstruction, actions.onWeekReview, actions.onClosing)
    AcknowledgementBanner(acknowledgement, changedRouteInterest, actions.onDismissAcknowledgement, onChangeRoute)
    when {
      active -> Column(Modifier.appear(0)) {
        ActiveCard(reminder, customActivities, usageAccess, actions.onOpenActive)
        if (!usageAccess) {
          Spacer(Modifier.height(12.dp))
          Notice("Relevo dejó de contar porque se retiró el permiso de Tiempo de uso.", title = "El conteo está en pausa", icon = KitIcon.ADVERTENCIA) {
            PlainAction("Abrir ajustes de Android", actions.onUsageSettings)
          }
        }
        if (!backgroundUnrestricted) {
          Spacer(Modifier.height(12.dp))
          Notice("Algunos teléfonos detienen apps para ahorrar batería. Para usar Relevo varios días, permite que funcione sin esa restricción.",
            title = "Funcionamiento en segundo plano", icon = KitIcon.BATERIA) { PlainAction("Permitir", actions.onBackground) }
        }
      }
      returning -> Column(Modifier.appear(0)) { ReturnCard(last, lastReminder, customActivities, actions) }
      nextTrack != null -> Column(Modifier.appear(0)) { NextStepCard(nextTrack, actions) }
      else -> Text("¿Tienes algo en mente? Puedes preparar un relevo cuando quieras.", style = Relevo.type.body, color = Relevo.colors.graphite, modifier = Modifier.appear(0))
    }
    if (!active) {
      SectionGap()
      SectionHeader("Ideas", Modifier.appear(1))
      Spacer(Modifier.height(4.dp))
      Carousel(Modifier.appear(2)) {
        items(activityIdeas, key = { it.activity }) { idea ->
          val key = photoKey("idea", idea.activity)
          PhotoCard(idea.activity, idea.picture, { actions.onIdea(idea, key) }, subtitle = idea.start, sharedKey = key, fallback = idea.icon)
        }
      }
      SectionGap()
      if (customActivities.isEmpty()) {
        ListSection(modifier = Modifier.appear(3)) {
          ListRow("Crear una actividad propia", icon = KitIcon.AGREGAR, subtitle = "Con su primer paso, su lugar y una imagen.", chevron = true, onClick = actions.onNewActivity)
        }
      } else {
        SectionHeader("Tus actividades", Modifier.appear(3))
        Spacer(Modifier.height(4.dp))
        Carousel(Modifier.appear(4)) {
          items(customActivities, key = { it.id }) { custom ->
            val key = photoKey("propia", custom.id)
            PhotoCard(custom.name, Picture.parse(custom.icon) ?: pictureForActivity(custom.name, emptyList()), { actions.onCustom(custom, key) },
              subtitle = custom.firstStep.ifBlank { null }, sharedKey = key)
          }
          item(key = "nueva") { NewActivityCard(actions.onNewActivity) }
        }
      }
      if (lastReminder != null && !returning) {
        SectionGap()
        ListSection(title = "La última vez", modifier = Modifier.appear(5)) {
          val key = photoKey("ultima", lastReminder.activity)
          ListRow(
            lastReminder.activity,
            subtitle = "${lastReminder.selectedApps.joinToString(", ") { it.label }} · ${formatDuration(lastReminder.requiredUsageSeconds)}",
            leading = {
              PictureContent(activityPicture(lastReminder.activity, customActivities), Modifier.size(40.dp, 50.dp).sharedPhoto(key).clip(RoundedCornerShape(8.dp)), iconSize = 22.dp)
            },
            leadingWidth = 40.dp,
            chevron = true, onClick = { actions.onRepeat(key) },
          )
        }
      }
    }
  }
}

/** Reconocimiento breve después de responder; se va solo. «Cambié de idea» puede llevar a cambiar la ruta. */
@Composable
private fun AcknowledgementBanner(text: String?, changedRouteInterest: String?, onDismiss: () -> Unit, onChangeRoute: (String) -> Unit) {
  LaunchedEffect(text, changedRouteInterest) {
    if (text != null && changedRouteInterest == null) { delay(6_000); onDismiss() }
  }
  AnimatedVisibility(text != null, enter = expandVertically(Motion.smooth()) + fadeIn(Motion.standard()), exit = shrinkVertically(Motion.smooth()) + fadeOut(Motion.standard(Motion.SHORT))) {
    Column {
      Panel {
        Row(verticalAlignment = Alignment.CenterVertically) {
          RelevoIcon(KitIcon.LISTO, background = Relevo.colors.mist)
          Spacer(Modifier.width(12.dp))
          Text(text.orEmpty(), style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
        }
        if (changedRouteInterest != null) {
          Text("¿Quieres cambiar la actividad de tu ruta?", style = Relevo.type.subhead, color = Relevo.colors.graphite)
          Row {
            PlainAction("Cambiar la actividad", { onChangeRoute(changedRouteInterest) }, icon = KitIcon.EDITAR)
            Spacer(Modifier.weight(1f))
            PlainAction("Ahora no", onDismiss, color = Relevo.colors.graphite)
          }
        }
      }
      SectionGap()
    }
  }
}

/** B3 en Inicio: la foto, la firma con las palabras de la persona y el tiempo contado como un renglón que se llena. */
@Composable
private fun ActiveCard(reminder: Reminder, customActivities: List<CustomActivity>, usageAccess: Boolean, onOpen: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  Column(
    Modifier.fillMaxWidth().pressScale(interaction, 0.985f).clip(Relevo.panelShape).background(Relevo.colors.mist)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Ver mi relevo", onClick = onOpen)
      .padding(16.dp),
  ) {
    Row(verticalAlignment = Alignment.Top) {
      PictureContent(
        activityPicture(reminder.activity, customActivities),
        Modifier.width(84.dp).aspectRatio(0.8f).sharedPhoto(ACTIVE_PHOTO).clip(RoundedCornerShape(12.dp)), iconSize = 30.dp,
      )
      Spacer(Modifier.width(16.dp))
      Column(Modifier.weight(1f)) {
        StatusChip(if (usageAccess) KitIcon.ESPERANDO else KitIcon.PAUSAR, if (usageAccess) "Esperando" else "En pausa", onPanel = true)
        Spacer(Modifier.height(10.dp))
        Signature(reminder.activity, style = Relevo.type.title2, animate = false)
        Spacer(Modifier.height(6.dp))
        val where = if (reminder.signalRoute == SignalRoute.PHONE) "en este teléfono" else placePhrase(reminder.place)
        Text("Sonará $where después de ${formatDuration(reminder.requiredUsageSeconds)}.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      }
    }
    Spacer(Modifier.height(16.dp))
    ProgressLine(progress, height = 4.dp, trackColor = Relevo.colors.line)
    Spacer(Modifier.height(8.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
      CountedTime(reminder.observedUsageSeconds)
      Text(" de ${formatDuration(reminder.requiredUsageSeconds)} en las apps elegidas", style = Relevo.type.footnote, color = Relevo.colors.graphite, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
  }
}

/** El tiempo contado cambia deslizándose hacia arriba, como un contador. */
@Composable
private fun CountedTime(seconds: Int) {
  AnimatedContent(
    targetState = formatDuration(seconds),
    transitionSpec = { (slideInVertically(Motion.smooth()) { it } + fadeIn(Motion.standard(160))) togetherWith (slideOutVertically(Motion.smooth()) { -it } + fadeOut(Motion.standard(120))) },
    label = "counted",
  ) { text -> Text(text, style = Relevo.type.footnote.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold), color = Relevo.colors.ink) }
}

/** V1: «Hola de nuevo». Las opciones pesan lo mismo; «Ahora no» la oculta hasta el próximo regreso. */
@Composable
private fun ReturnCard(last: HistoryEntry, lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  Panel(padding = 16.dp) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      PictureContent(
        activityPicture(last.activity, customActivities),
        Modifier.width(64.dp).aspectRatio(0.8f).sharedPhoto(if (lastReminder != null) photoKey("regreso", lastReminder.activity) else null).clip(RoundedCornerShape(10.dp)),
        iconSize = 26.dp,
      )
      Spacer(Modifier.width(14.dp))
      Column(Modifier.weight(1f)) {
        Text("La última vez preparaste", style = Relevo.type.footnote, color = Relevo.colors.graphite)
        Text(last.activity, style = Relevo.type.headline, color = Relevo.colors.voice)
      }
    }
    Text("¿Sigue siendo lo que quieres?", style = Relevo.type.body, color = Relevo.colors.ink)
    Row {
      PlainAction("Elegir otra actividad", actions.onPrepare, icon = KitIcon.ACTIVIDAD)
      Spacer(Modifier.weight(1f))
      PlainAction("Ahora no", { actions.onDismissReturn(last.completedAt) }, color = Relevo.colors.graphite)
    }
  }
}

/** El paso actual de la ruta, con su foto y su primer paso. Tocarlo prepara un relevo con ese paso. */
@Composable
private fun NextStepCard(track: RouteTrack, actions: HomeActions) {
  val step = track.currentStep ?: return
  val key = photoKey("ruta", step.id)
  val interaction = remember { MutableInteractionSource() }
  Column(
    Modifier.fillMaxWidth().pressScale(interaction, 0.985f)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Preparar un relevo con este paso") {
        actions.onRouteStep(track.interest, step.id, key)
      },
  ) {
    PictureContent(activityPicture(step.activity, emptyList()), Modifier.fillMaxWidth().aspectRatio(1.5f).sharedPhoto(key).clip(Relevo.panelShape), iconSize = 44.dp, wide = true)
    Spacer(Modifier.height(14.dp))
    Text("TU RUTA · ${track.title.uppercase()}", style = Relevo.type.label, color = Relevo.colors.graphite)
    Spacer(Modifier.height(6.dp))
    Text(step.activity, style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(4.dp))
    Text(listOf(step.firstStep, step.place).filter { it.isNotBlank() }.joinToString(" · "), style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Row(Modifier.fillMaxWidth().padding(top = 4.dp)) {
      PlainAction("Preparar con este paso", { actions.onRouteStep(track.interest, step.id, key) })
      Spacer(Modifier.weight(1f))
      PlainAction("Ver la ruta", { actions.onOpenRoute(track.interest) }, color = Relevo.colors.graphite)
    }
  }
}

/** Ficha para crear una actividad propia, con la misma forma que las demás. */
@Composable
private fun NewActivityCard(onClick: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  Column(
    Modifier.width(152.dp).pressScale(interaction).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick),
  ) {
    Box(
      Modifier.fillMaxWidth().aspectRatio(0.8f).clip(Relevo.panelShape).background(Relevo.colors.mist),
      contentAlignment = Alignment.Center,
    ) { RelevoIcon(KitIcon.AGREGAR, size = 40.dp, background = Relevo.colors.mist) }
    Spacer(Modifier.height(10.dp))
    Text("Nueva actividad", style = Relevo.type.headline, color = Relevo.colors.ink)
    Spacer(Modifier.height(2.dp))
    Text("Escribe la tuya", style = Relevo.type.footnote, color = Relevo.colors.graphite)
  }
}

/**
 * B3: «Tu relevo». La foto, la firma, el tiempo contado y lo que se preparó. Desactivar pide
 * confirmación en una hoja, para no hacerlo sin querer.
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
) {
  var confirming by rememberSaveable { mutableStateOf(false) }
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  RelevoScreen(
    title = "Tu relevo",
    onBack = onBack, backLabel = "Inicio",
    header = {
      PictureContent(
        activityPicture(reminder.activity, customActivities),
        Modifier.fillMaxWidth(0.62f).aspectRatio(0.8f).sharedPhoto(ACTIVE_PHOTO).clip(Relevo.panelShape), iconSize = 56.dp,
      )
    },
    bottom = { RelevoButton("Desactivar el relevo", { confirming = true }, kind = ButtonKind.Secondary) },
  ) {
    StatusChip(if (usageAccess) KitIcon.ESPERANDO else KitIcon.PAUSAR, if (usageAccess) "Esperando" else "En pausa")
    Spacer(Modifier.height(16.dp))
    Signature(reminder.activity)
    Spacer(Modifier.height(12.dp))
    val where = if (reminder.signalRoute == SignalRoute.PHONE) "en este teléfono" else placePhrase(reminder.place)
    Text("Sonará $where después de ${formatDuration(reminder.requiredUsageSeconds)} en las apps elegidas.", style = Relevo.type.body, color = Relevo.colors.graphite)
    Spacer(Modifier.height(20.dp))
    ProgressLine(progress, height = 4.dp)
    Spacer(Modifier.height(8.dp))
    Row {
      CountedTime(reminder.observedUsageSeconds)
      Text(" de ${formatDuration(reminder.requiredUsageSeconds)} contados", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
    if (!usageAccess) {
      SectionGap()
      Notice("Relevo dejó de contar porque se retiró el permiso de Tiempo de uso.", title = "El conteo está en pausa", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Abrir ajustes de Android", onUsageSettings)
      }
    }
    SectionGap()
    ListSection {
      FactRow(KitIcon.PRIMER_PASO, "Cómo empieza", reminder.howToStart)
      if (reminder.signalRoute == SignalRoute.PHONE) FactRow(KitIcon.LUGAR, "Lo que necesitas", reminder.place)
      else FactRow(KitIcon.PARLANTE, "Suena en", reminder.place)
      ListRow(
        "Apps", icon = KitIcon.APPS, titleColor = Relevo.colors.graphite,
        trailing = {
          Row(horizontalArrangement = Arrangement.spacedBy((-6).dp)) { reminder.selectedApps.take(4).forEach { AppIcon(it.packageName, 28.dp) } }
        },
        value = reminder.selectedApps.joinToString(", ") { it.label },
      )
      StudyCondition.fromCode(reminder.studyCondition.firstOrNull() ?: ' ')?.let { condition ->
        ListRow("Prueba", icon = conditionIcon(condition), titleColor = Relevo.colors.graphite, value = conditionName(condition))
      }
    }
    if (!backgroundUnrestricted) {
      SectionGap()
      Notice("Algunos teléfonos detienen apps para ahorrar batería. Para usar Relevo varios días, permite que funcione sin esa restricción.",
        title = "Funcionamiento en segundo plano", icon = KitIcon.BATERIA) { PlainAction("Permitir", onBackground) }
    }
  }
  if (confirming) {
    RelevoSheet(onDismiss = { confirming = false }, scrollable = false) {
      Text("¿Desactivar el relevo?", style = Relevo.type.title2, color = Relevo.colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("El conteo se detiene y no sonará. Después puedes contar qué decidiste.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(20.dp))
      RelevoButton("Desactivar", { confirming = false; onDisarm() }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(4.dp))
      PlainAction("Seguir esperando", { confirming = false })
    }
  }
}
