package com.example.relevo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
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
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.ControlBlur
import com.example.relevo.ui.components.FactRow
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.PhotoCard
import com.example.relevo.ui.components.PhotoHero
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
import com.example.relevo.ui.components.enterBlur
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.glass
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

/** Aviso de batería: qué hacer y para qué, en una frase. */
internal const val BATTERY_TEXT = "Para que Relevo siga contando aunque pasen días, quítale la restricción de batería."

/**
 * B1: Inicio. Saluda por el nombre y muestra, en una foto grande, lo más próximo: el relevo activo,
 * el regreso tras varios días (V1) o el paso actual de la ruta. Debajo, ideas con foto. La acción
 * principal flota abajo, sobre la barra de pestañas.
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
  val nextTrack = routes.firstOrNull { it.currentStep != null }

  RelevoScreen(
    title = title,
    eyebrow = todayLabel(),
    leading = { Wordmark(height = 20.dp) },
    trailing = { AvatarButton(profile, actions.onProfile) },
    scrollState = scroll,
    bottom = {
      when {
        active -> RelevoButton("Ver mi relevo", actions.onOpenActive, icon = KitIcon.ESPERANDO)
        returning && lastReminder != null -> RelevoButton("Preparar de nuevo", { actions.onRepeat(photoKey("regreso", lastReminder.activity)) }, icon = KitIcon.REINTENTAR)
        else -> RelevoButton("Preparar un relevo", actions.onPrepare, icon = KitIcon.AGREGAR)
      }
    },
  ) {
    StudyCards(study, actions.onDismissInstruction, actions.onWeekReview, actions.onClosing, firstRelevoDone = history.isNotEmpty())
    if (guided && !active && history.isEmpty()) {
      GuideTip("Empieza aquí: toca «Preparar un relevo». Te acompañamos paso a paso.")
      SectionGap()
    }
    if (quickFeedbackDue && !active) {
      QuickFeedbackCard(onQuickFeedback, { onQuickFeedback(null); onFeedback() })
      SectionGap()
    }
    // D-095: con la activación automática, Inicio recuerda qué se activará y cómo apagarla.
    if (autoMode && !active && lastReminder != null) {
      Notice(
        "Cuando abras ${lastReminder.selectedApps.joinToString(" o ") { it.label }}, Relevo empieza a contar para «${lastReminder.activity}».",
        title = "Se activa solo", icon = KitIcon.ESPERANDO,
      ) { PlainAction("Apagar", onAutoModeOff) }
      SectionGap()
    }
    AcknowledgementToast(acknowledgement, changedRouteInterest, actions.onDismissAcknowledgement, onChangeRoute)
    Box(Modifier.appear(0)) {
      when {
        active -> Column {
          ActiveCard(reminder, customActivities, usageAccess, actions.onOpenActive)
          Spacer(Modifier.height(12.dp))
          ActiveSummary(reminder, actions.onOpenActive)
          if (!usageAccess) {
            Spacer(Modifier.height(12.dp))
            Notice("Falta el permiso de Tiempo de uso.", title = "Relevo no puede contar el tiempo", icon = KitIcon.ADVERTENCIA) {
              PlainAction("Dar el permiso", actions.onUsageSettings)
            }
          }
          if (!backgroundUnrestricted) {
            Spacer(Modifier.height(12.dp))
            Notice(BATTERY_TEXT, title = "Batería", icon = KitIcon.BATERIA) {
              PlainAction("Quitar la restricción", actions.onBackground)
            }
          }
        }
        returning -> ReturnCard(last, lastReminder, customActivities, actions)
        nextTrack != null -> NextStepCard(nextTrack, actions)
        else -> PhotoHero(Picture.OfPhoto(Photo.SALIDA), aspect = 1.1f, wide = true, onClick = actions.onPrepare, clickLabel = "Preparar un relevo") {
          Text("¿Tienes algo en mente?", style = Relevo.type.title2, color = Relevo.colors.ink)
          Spacer(Modifier.height(4.dp))
          Text("Anótalo y Relevo te avisa cuando lleves un rato en el teléfono.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
        }
      }
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
      SectionHeader("Tus actividades", Modifier.appear(3))
      Spacer(Modifier.height(4.dp))
      if (customActivities.isEmpty()) {
        Column(Modifier.appear(4), verticalArrangement = Arrangement.spacedBy(12.dp)) {
          Text("Guarda lo que haces seguido y prepáralo en un toque.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
          RelevoButton("Crear una actividad", actions.onNewActivity, kind = ButtonKind.Secondary, compact = true, icon = KitIcon.AGREGAR)
        }
      } else {
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
              PictureContent(activityPicture(lastReminder.activity, customActivities), Modifier.size(44.dp).sharedPhoto(key).clip(CircleShape), iconSize = 20.dp)
            },
            leadingWidth = 44.dp,
            chevron = true, onClick = { actions.onRepeat(key) },
          )
        }
      }
    }
  }
}

/** La imagen de la persona en un círculo de vidrio, arriba a la derecha; lleva a Perfil. */
@Composable
private fun AvatarButton(profile: Profile, onClick: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  Box(
    Modifier.size(44.dp).pressScale(interaction, 0.92f).glass(CircleShape, blur = ControlBlur)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = "Perfil" },
    contentAlignment = Alignment.Center,
  ) { Avatar(profile.image, profile.name, 40.dp, background = androidx.compose.ui.graphics.Color.Transparent) }
}

/**
 * Reconocimiento breve después de responder: sube con un leve desenfoque, la marca se dibuja y se va
 * solo. «Cambié de idea» puede llevar a cambiar la actividad de la ruta.
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
      Panel(padding = 18.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          CheckMark(true, size = 28.dp)
          Spacer(Modifier.width(14.dp))
          Text(text.orEmpty(), style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
        }
        if (changedRouteInterest != null) {
          Text("¿Quieres cambiar la actividad de tu ruta?", style = Relevo.type.subhead, color = Relevo.colors.graphite)
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            RelevoButton("Cambiar la actividad", { onChangeRoute(changedRouteInterest) }, kind = ButtonKind.Secondary, compact = true)
            PlainAction("Ahora no", onDismiss, color = Relevo.colors.graphite)
          }
        }
      }
      SectionGap()
    }
  }
}

/** B3 en Inicio: la foto, la firma con las palabras de la persona y el tiempo contado. */
@Composable
private fun ActiveCard(reminder: Reminder, customActivities: List<CustomActivity>, usageAccess: Boolean, onOpen: () -> Unit) {
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  val where = if (reminder.signalRoute == SignalRoute.PHONE) "en el teléfono" else placePhrase(reminder.place)
  PhotoHero(
    activityPicture(reminder.activity, customActivities), aspect = 0.92f, sharedKey = ACTIVE_PHOTO,
    onClick = onOpen, clickLabel = "Ver mi relevo",
  ) {
    StatusChip(if (usageAccess) KitIcon.ESPERANDO else KitIcon.PAUSAR, if (usageAccess) "Contando" else "En pausa", onPanel = true)
    Spacer(Modifier.height(12.dp))
    Signature(reminder.activity, style = Relevo.type.title, animate = false)
    Spacer(Modifier.height(6.dp))
    Text("Sonará $where.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(14.dp))
    ProgressLine(progress, trackColor = Relevo.colors.ink.copy(alpha = .12f))
    Spacer(Modifier.height(8.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
      CountedTime(reminder.observedUsageSeconds)
      Text(" de ${formatDuration(reminder.requiredUsageSeconds)}", style = Relevo.type.footnote, color = Relevo.colors.graphite, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
  }
}

/**
 * Resumen del relevo activo en Inicio (D-088): lo que la persona preparó, cuánto falta, dónde suena y
 * la salida. Apoya la memoria prospectiva —la intención y su comienzo siguen a la vista mientras el
 * ciclo está vigente— y la tabla 5 de la memoria: saber que el ciclo sigue activo y poder detenerlo.
 * No muestra rachas ni comparaciones entre días (criterios 4 y 7).
 */
@Composable
private fun ActiveSummary(reminder: Reminder, onOpen: () -> Unit) {
  val remaining = (reminder.requiredUsageSeconds - reminder.observedUsageSeconds).coerceAtLeast(0)
  ListSection(title = "Tu relevo") {
    FactRow(KitIcon.PRIMER_PASO, "Para empezar", reminder.howToStart)
    FactRow(KitIcon.LUGAR, "Dónde empiezas", reminder.place)
    ListRow("Suena", icon = routeIcon(reminder.signalRoute), titleColor = Relevo.colors.graphite, value = soundPlace(reminder))
    ListRow("Apps que cuentan", icon = KitIcon.APPS, titleColor = Relevo.colors.graphite, value = reminder.selectedApps.joinToString(", ") { it.label })
    ListRow("Falta", icon = KitIcon.TIEMPO, titleColor = Relevo.colors.graphite, value = "${formatDuration(remaining)} en esas apps")
    if (reminder.autoActivated) ListRow("Cómo empezó", icon = KitIcon.ESPERANDO, titleColor = Relevo.colors.graphite, value = "Se activó solo")
    ListRow("Ver, desactivar o eliminar", icon = KitIcon.AJUSTES, chevron = true, onClick = onOpen)
  }
}

/**
 * Después de activar el primer relevo (D-090): qué pasa ahora, con los datos que la persona eligió.
 * Cierra la guía del primer relevo.
 */
@Composable
internal fun FirstRelevoActiveSheet(reminder: Reminder, onDismiss: () -> Unit) {
  // Dónde sonará: el objeto donde empieza, en otro lugar o el teléfono, como lo eligió la persona (D-110).
  val spot = if (reminder.objectNearStart == false) "donde lo dejaste" else placePhrase(reminder.place)
  val where = when (reminder.signalRoute) {
    SignalRoute.PHONE -> "en el teléfono"
    SignalRoute.WATCH -> "en el reloj, $spot"
    SignalRoute.TAG -> "en el llavero, $spot"
    SignalRoute.BLUETOOTH -> "en el parlante, $spot"
  }
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

/** El tiempo contado cambia deslizándose hacia arriba y se enfoca al llegar, como un contador. */
@Composable
private fun CountedTime(seconds: Int) {
  AnimatedContent(
    targetState = formatDuration(seconds),
    transitionSpec = { (slideInVertically(Motion.smooth()) { it } + fadeIn(Motion.standard(160))) togetherWith (slideOutVertically(Motion.smooth()) { -it } + fadeOut(Motion.standard(120))) },
    label = "counted",
  ) { text -> Text(text, style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold), color = Relevo.colors.ink, modifier = Modifier.enterBlur(this)) }
}

/** V1: «Hola de nuevo». Las opciones pesan lo mismo; «Ahora no» la oculta hasta el próximo regreso. */
@Composable
private fun ReturnCard(last: HistoryEntry, lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  PhotoHero(
    activityPicture(last.activity, customActivities), aspect = 0.95f,
    sharedKey = lastReminder?.let { photoKey("regreso", it.activity) },
  ) {
    Text("La última vez", style = Relevo.type.label, color = Relevo.colors.graphite)
    Spacer(Modifier.height(4.dp))
    Text(last.activity, style = Relevo.type.title, color = Relevo.colors.voice)
    Spacer(Modifier.height(4.dp))
    Text("¿Sigue siendo lo que quieres?", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(14.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
      RelevoButton("Elegir otra", actions.onPrepare, kind = ButtonKind.Secondary, compact = true)
      PlainAction("Ahora no", { actions.onDismissReturn(last.completedAt) }, color = Relevo.colors.graphite)
    }
  }
}

/** El paso actual de la ruta, en grande. Tocarlo prepara un relevo con ese paso. */
@Composable
private fun NextStepCard(track: RouteTrack, actions: HomeActions) {
  val step = track.currentStep ?: return
  val key = photoKey("ruta", step.id)
  PhotoHero(
    activityPicture(step.activity, emptyList()), aspect = 0.9f, sharedKey = key,
    onClick = { actions.onRouteStep(track.interest, step.id, key) }, clickLabel = "Preparar un relevo con este paso",
  ) {
    Text("Tu ruta · ${track.title}", style = Relevo.type.label, color = Relevo.colors.graphite)
    Spacer(Modifier.height(6.dp))
    Row(verticalAlignment = Alignment.Bottom) {
      Column(Modifier.weight(1f)) {
        Text(step.activity, style = Relevo.type.title, color = Relevo.colors.ink)
        startSentence(step.firstStep, step.place)?.let {
          Spacer(Modifier.height(4.dp))
          Text(it, style = Relevo.type.subhead, color = Relevo.colors.graphite)
        }
      }
      Spacer(Modifier.width(12.dp))
      RelevoButton("Preparar", { actions.onRouteStep(track.interest, step.id, key) }, compact = true)
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
    Box(Modifier.fillMaxWidth().aspectRatio(0.8f), contentAlignment = Alignment.Center) {
      Box(Modifier.size(64.dp).clip(CircleShape).background(Relevo.colors.mist), contentAlignment = Alignment.Center) {
        RelevoIcon(KitIcon.AGREGAR, size = 26.dp, background = Relevo.colors.mist, strokeWidth = 2f)
      }
    }
    Spacer(Modifier.height(10.dp))
    Text("Nueva actividad", style = Relevo.type.headline, color = Relevo.colors.ink)
  }
}

/**
 * B3: «Tu relevo». La foto llega al borde superior; debajo, la firma, el tiempo contado y lo que se
 * preparó. Desactivar pide confirmación en una hoja, para no hacerlo sin querer.
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
) {
  var confirming by rememberSaveable { mutableStateOf(false) }
  var confirmingDelete by rememberSaveable { mutableStateOf(false) }
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  val where = if (reminder.signalRoute == SignalRoute.PHONE) "en el teléfono" else placePhrase(reminder.place)
  RelevoScreen(
    onBack = onBack, backLabel = "Inicio",
    hero = {
      PictureContent(activityPicture(reminder.activity, customActivities), Modifier.fillMaxSize().sharedPhoto(ACTIVE_PHOTO), iconSize = 64.dp, wide = true)
    },
    heroHeight = 300.dp,
    heroPicture = activityPicture(reminder.activity, customActivities),
    bottom = { RelevoButton("Desactivar el relevo", { confirming = true }, kind = ButtonKind.Secondary) },
  ) {
    Spacer(Modifier.height(24.dp))
    StatusChip(if (usageAccess) KitIcon.ESPERANDO else KitIcon.PAUSAR, if (usageAccess) "Contando" else "En pausa")
    Spacer(Modifier.height(16.dp))
    Signature(reminder.activity)
    Spacer(Modifier.height(12.dp))
    Text("Sonará $where después de ${formatDuration(reminder.requiredUsageSeconds)} en las apps que elegiste.", style = Relevo.type.body, color = Relevo.colors.graphite)
    Spacer(Modifier.height(22.dp))
    ProgressLine(progress)
    Spacer(Modifier.height(8.dp))
    Row {
      CountedTime(reminder.observedUsageSeconds)
      Text(" de ${formatDuration(reminder.requiredUsageSeconds)}", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
    if (!usageAccess) {
      SectionGap()
      Notice("Falta el permiso de Tiempo de uso.", title = "Relevo no puede contar el tiempo", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Dar el permiso", onUsageSettings)
      }
    }
    SectionGap()
    ListSection {
      FactRow(KitIcon.PRIMER_PASO, "Para empezar", reminder.howToStart)
      if (reminder.signalRoute == SignalRoute.PHONE) FactRow(KitIcon.LUGAR, "Dónde empiezas", reminder.place)
      else FactRow(KitIcon.PARLANTE, "Parlante", reminder.place)
      ListRow(
        "Apps que cuentan", icon = KitIcon.APPS, titleColor = Relevo.colors.graphite,
        trailing = {
          Row(horizontalArrangement = Arrangement.spacedBy((-6).dp)) { reminder.selectedApps.take(4).forEach { AppIcon(it.packageName, 28.dp) } }
        },
        value = reminder.selectedApps.joinToString(", ") { it.label },
      )
    }
    if (!backgroundUnrestricted) {
      SectionGap()
      Notice(BATTERY_TEXT, title = "Batería", icon = KitIcon.BATERIA) {
        PlainAction("Quitar la restricción", onBackground)
      }
    }
    // 2.18: eliminar un relevo activado por error, sin preguntas ni guardarlo en tus relevos.
    SectionGap()
    PlainAction("Eliminar este relevo", { confirmingDelete = true }, color = Relevo.colors.error, icon = KitIcon.BORRAR)
  }
  if (confirmingDelete) {
    RelevoSheet(onDismiss = { confirmingDelete = false }, scrollable = false) {
      Text("¿Eliminar este relevo?", style = Relevo.type.title2, color = Relevo.colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Deja de contar, no sonará y no queda en tus relevos. Sirve si lo activaste por error.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Eliminar", { confirmingDelete = false; onDelete() }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(8.dp))
      RelevoButton("Mantenerlo", { confirmingDelete = false }, kind = ButtonKind.Secondary)
    }
  }
  if (confirming) {
    RelevoSheet(onDismiss = { confirming = false }, scrollable = false) {
      Text("¿Desactivar el relevo?", style = Relevo.type.title2, color = Relevo.colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Dejará de contar el tiempo y no sonará. Después podrás decir qué decidiste.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Desactivar", { confirming = false; onDisarm() }, kind = ButtonKind.Destructive)
      Spacer(Modifier.height(8.dp))
      RelevoButton("Mantenerlo", { confirming = false }, kind = ButtonKind.Secondary)
    }
  }
}
