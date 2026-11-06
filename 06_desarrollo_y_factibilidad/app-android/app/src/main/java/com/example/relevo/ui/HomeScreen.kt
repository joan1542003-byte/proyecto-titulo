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
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.relevo.ui.components.skyFor
import com.example.relevo.ui.components.SkyBackground
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.ColumnScope
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
import com.example.relevo.ui.components.RollingContent
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
  val onOpenActive: (sessionId: String) -> Unit,
  val onOpenActivities: (ActivitiesSection) -> Unit,
  val onUsageSettings: () -> Unit,
  val onBackground: () -> Unit,
  val onDismissAcknowledgement: () -> Unit,
  val onDismissReturn: (Long) -> Unit,
  /** Lo que quedó para después (4.4): activarlo con un toque u ocultarlo. */
  val onLaterActivate: () -> Unit,
  val onLaterDismiss: () -> Unit,
  /** La pregunta del tiempo tras 3 veces que sonó (4.4): true para cambiarlo. */
  val onLimitReview: (Boolean) -> Unit,
  val onProfileSetup: () -> Unit,
)

/** Aviso de batería: qué hacer y para qué, en una frase. */
internal const val BATTERY_TEXT = "Para que Relevo siga contando aunque pasen días."

/**
 * Inicio de la 4.0 (D-155), de arriba abajo: la fecha y el saludo; lo que pide una respuesta (el perfil o
 * el tiempo, desde la 4.4); lo más próximo (el relevo que cuenta, lo que quedó para después, el regreso tras
 * unos días o «Preparar un relevo» con el paso sugerido);
 * un resumen de la semana que solo cuenta hechos, y tus actividades en anillos, a un toque. Sin campana
 * ni ajustes: esos viven en Perfil. Desde 4.2 (D-157), lo más próximo va en una tarjeta con el color de su
 * actividad ([ActivityHero]) y la opinión rápida, debajo de ella.
 */
@Composable
internal fun HomeTab(
  reminder: Reminder,
  actives: List<Reminder>,
  history: List<HistoryEntry>,
  customActivities: List<CustomActivity>,
  lastReminder: Reminder?,
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
  autoMode: Boolean = false,
  onAutoModeOff: () -> Unit = {},
  laterPending: Boolean = false,
  limitReviewDue: Boolean = false,
  quiet: Boolean = false,
  quietUntil: Int = 8,
) {
  val scroll = rememberScrollState()
  var firstReselect by remember { mutableStateOf(reselect) }
  LaunchedEffect(reselect) { if (reselect != firstReselect) scroll.animateScrollTo(0) else firstReselect = reselect }
  // Desde 4.3 (D-158) puede haber varios relevos contando; el que sonará primero va en la tarjeta.
  val counting = actives.sortedBy { it.requiredUsageSeconds - it.observedUsageSeconds }
  val active = counting.isNotEmpty()
  val last = history.firstOrNull()
  val daysSinceLast = last?.let {
    ChronoUnit.DAYS.between(Instant.ofEpochMilli(it.completedAt).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
  } ?: 0L
  // 4.4: «La dejé para después» con «Dejarla lista» deja el relevo a un toque.
  val later = laterPending && !active && lastReminder != null
  // V1: dos días o más después del último relevo; no dice cuántos pasaron ni sugiere una falta.
  val returning = !active && !later && last != null && daysSinceLast >= 2 && returnDismissedFor != last.completedAt
  val name = profile.name.trim()
  val greeting = when {
    returning && name.isNotEmpty() -> "Hola de nuevo, $name"
    returning -> "Hola de nuevo"
    name.isNotEmpty() -> "Hola, $name"
    else -> "Hola"
  }
  val nextTrack = routes.firstOrNull { it.currentStep != null }
  // 4.4: el perfil se pide después del primer relevo, no antes.
  val profileDue = !profile.setupSeen && (history.isNotEmpty() || active)

  RelevoScreen(title = greeting, eyebrow = todayLabel(), largeTitle = true, barTitle = "Inicio", scrollState = scroll) {
    if (profileDue) {
      Notice("El nombre y lo que te gustaría hacer más seguido. Toma un minuto.", title = "Completa el perfil", icon = KitIcon.PERFIL) {
        PlainAction("Completar", actions.onProfileSetup)
      }
      Spacer(Modifier.height(Gap.block))
    }
    if (limitReviewDue && !active) {
      Notice("Ya sonó 3 veces. Si al sonar ya llevas mucho rato en una app, prueba con menos tiempo.", title = "¿El tiempo queda bien?", icon = KitIcon.TIEMPO) {
        PlainAction("Cambiar el tiempo", { actions.onLimitReview(true) })
        PlainAction("Está bien así", { actions.onLimitReview(false) }, color = Relevo.colors.graphite)
      }
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
          ActiveCard(counting.first(), usageAccess && !quiet, customActivities) { actions.onOpenActive(counting.first().sessionId) }
          if (quiet) {
            Spacer(Modifier.height(Gap.list))
            Text("Horas sin sonar: vuelve a contar a las $quietUntil:00", style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
          }
          if (counting.size > 1) {
            Spacer(Modifier.height(Gap.list))
            ListSection(dividerInset = 70.dp) {
              counting.drop(1).forEach { other ->
                ListRow(
                  other.activity.trim(), subtitle = "Faltan ${formatDuration((other.requiredUsageSeconds - other.observedUsageSeconds).coerceAtLeast(0))}",
                  leading = { ActivityRing(activityIcon(other.activity, customActivities), 42.dp) },
                  chevron = true, onClick = { actions.onOpenActive(other.sessionId) },
                )
              }
            }
          }
          Spacer(Modifier.height(Gap.list))
          RelevoButton("Preparar otro relevo", actions.onPrepare, kind = ButtonKind.Secondary, icon = KitIcon.AGREGAR)
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
        later -> LaterCard(lastReminder, customActivities, actions)
        returning -> ReturnCard(last, lastReminder, customActivities, actions)
        else -> PrepareBlock(nextTrack, lastReminder, customActivities, actions)
      }
    }
    // 4.2: la opinión rápida va después de lo más próximo, que es lo que la persona viene a ver.
    if (quickFeedbackDue && !active) {
      SectionGap()
      QuickFeedbackCard(onQuickFeedback, { onQuickFeedback(null); onFeedback() })
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
 * Lo que se puede preparar ahora (4.2): el paso sugerido de tu ruta, en la tarjeta con su color, con
 * «Preparar un relevo» y «Elegir otra»; debajo, repetir el último. Sin un paso sugerido, el último relevo
 * ocupa la tarjeta; sin ninguno de los dos, queda el botón.
 */
@Composable
private fun PrepareBlock(nextTrack: RouteTrack?, lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  val step = nextTrack?.currentStep
  when {
    nextTrack != null && step != null -> {
      val key = photoKey("ruta", step.id)
      ActivityHero(
        activityIcon(step.activity, customActivities), step.activity,
        eyebrow = "Siguiente paso en ${nextTrack.title.replaceFirstChar { it.lowercase() }}",
        detail = startLine(step.firstStep, step.place),
      ) {
        Spacer(Modifier.height(16.dp))
        RelevoButton("Preparar un relevo", { actions.onRouteStep(nextTrack.interest, step.id, key) }, icon = KitIcon.AGREGAR)
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { PlainAction("Elegir otra", actions.onPrepare) }
      }
      if (lastReminder != null && !lastReminder.activity.trim().equals(step.activity.trim(), true)) {
        val lastKey = photoKey("ultima", lastReminder.activity)
        Spacer(Modifier.height(Gap.list))
        ListSection(dividerInset = 70.dp) {
          ListRow(
            lastReminder.activity, subtitle = "Repetir el último · ${formatDuration(lastReminder.requiredUsageSeconds)}",
            leading = { ActivityRing(activityIcon(lastReminder.activity, customActivities), 42.dp) },
            chevron = true, onClick = { actions.onRepeat(lastKey) },
          )
        }
      }
    }
    lastReminder != null -> {
      val key = photoKey("ultima", lastReminder.activity)
      ActivityHero(
        activityIcon(lastReminder.activity, customActivities), lastReminder.activity,
        eyebrow = "Último relevo", detail = startLine(lastReminder.howToStart, lastReminder.place),
      ) {
        Spacer(Modifier.height(16.dp))
        RelevoButton("Preparar de nuevo", { actions.onRepeat(key) }, icon = KitIcon.REINTENTAR)
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { PlainAction("Elegir otra", actions.onPrepare) }
      }
    }
    else -> RelevoButton("Preparar un relevo", actions.onPrepare, icon = KitIcon.AGREGAR)
  }
}

/**
 * Lo más próximo, en una tarjeta con el color de su actividad (4.2, D-157). Es la tarjeta de la memoria v6
 * (Figura 15b): «en Inicio, la actividad se presenta en una tarjeta con su degradado», el paso intermedio de
 * «el color sube con el momento», entre el papel de Preparar y el cielo a pantalla completa de la señal. La
 * 4.0 la había dejado en papel y tinta, e Inicio quedó sin un punto donde mirar. Arriba va el cielo de la
 * familia; sobre su borde, el anillo con un aro de papel, alineado con el texto, y abajo, en papel, el texto
 * y la acción, que se leen con el contraste de siempre. En el tema oscuro el cielo baja un poco su luz.
 */
@Composable
private fun ActivityHero(
  icon: KitIcon,
  activity: String,
  eyebrow: String,
  detail: String?,
  onClick: (() -> Unit)? = null,
  clickLabel: String? = null,
  content: @Composable ColumnScope.() -> Unit,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val dim = if (colors.isDark) Color.Black.copy(alpha = .2f) else Color.Transparent
  Column(
    Modifier.fillMaxWidth()
      .then(if (onClick != null) Modifier.pressScale(interaction, 0.985f) else Modifier)
      .clip(Relevo.panelShape).background(colors.card)
      .then(if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = clickLabel, onClick = onClick) else Modifier),
  ) {
    Box(Modifier.fillMaxWidth().height(HeroSky + HeroHalo / 2)) {
      SkyBackground(skyFor(icon), Modifier.fillMaxWidth().height(HeroSky).drawWithContent { drawContent(); drawRect(dim) }, variant = activityVariant(activity))
      Box(
        Modifier.align(Alignment.BottomStart).padding(start = HeroInset - HeroHaloWidth).size(HeroHalo).clip(CircleShape).background(colors.card),
        contentAlignment = Alignment.Center,
      ) { ActivityRing(icon, HeroRing) }
    }
    Column(Modifier.fillMaxWidth().padding(start = HeroInset, end = HeroInset, top = 10.dp, bottom = 20.dp)) {
      Text(eyebrow, style = Relevo.type.subhead, color = colors.graphite)
      Spacer(Modifier.height(2.dp))
      Text(activity.trim(), style = Relevo.type.title2, color = colors.ink, maxLines = 2, overflow = TextOverflow.Ellipsis)
      if (detail != null) {
        Spacer(Modifier.height(4.dp))
        Text(detail, style = Relevo.type.subhead, color = colors.graphite)
      }
      content()
    }
  }
}

/** Medidas de la tarjeta: el cielo, el anillo y su aro de papel; el borde del anillo cae en la columna del texto. */
private val HeroSky = 104.dp
private val HeroRing = 64.dp
private val HeroHaloWidth = 5.dp
private val HeroHalo = HeroRing + HeroHaloWidth * 2
private val HeroInset = 20.dp

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
      Text("Esta semana", style = Relevo.type.headline, color = colors.ink, modifier = Modifier.weight(1f))
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
            activityIcon(activity, customActivities), activity, onClick = null, size = 52.dp, count = count,
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

/** Tus actividades a un toque, aunque haya otros relevos contando (4.3). Sin actividades, la invitación a crear la primera y las ideas. */
@Composable
private fun QuickActivities(customActivities: List<CustomActivity>, actions: HomeActions, modifier: Modifier = Modifier) {
  Column(modifier) {
    SectionHeader("Actividades", action = "Ver todas", onAction = { actions.onOpenActivities(ActivitiesSection.MINE) })
    Spacer(Modifier.height(6.dp))
    Carousel(spacing = 14.dp) {
      items(customActivities, key = { it.id }) { custom ->
        RingCell(
          activityIcon(custom.name, customActivities), custom.name,
          onClick = { actions.onCustom(custom, photoKey("propia", custom.id)) },
          description = "Preparar «${custom.name}»",
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
          Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
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
 * El relevo que cuenta, en Inicio (4.2): la tarjeta con el color de su actividad, dónde suena, el avance y
 * cuánto falta. Tocarla abre el relevo.
 */
@Composable
private fun ActiveCard(reminder: Reminder, counting: Boolean, customActivities: List<CustomActivity>, onOpen: () -> Unit) {
  val progress = reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)
  val remaining = (reminder.requiredUsageSeconds - reminder.observedUsageSeconds).coerceAtLeast(0)
  ActivityHero(
    activityIcon(reminder.activity, customActivities), reminder.activity,
    eyebrow = if (counting) "Contando" else "En pausa", detail = "Suena " + soundWhere(reminder),
    onClick = onOpen, clickLabel = "Ver el relevo",
  ) {
    Spacer(Modifier.height(16.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
      ProgressLine(progress, Modifier.weight(1f))
      Spacer(Modifier.width(14.dp))
      RollingContent(remaining) { left ->
        Text("Faltan ${formatDuration(left)}", style = Relevo.type.subhead.copy(fontWeight = FontWeight.SemiBold, fontFeatureSettings = "tnum"), color = Relevo.colors.ink)
      }
    }
  }
}

/**
 * Después de activar el primer relevo (D-090): qué pasa ahora, con los datos que la persona eligió.
 * Cierra la guía del primer relevo.
 */
@Composable
internal fun FirstRelevoActiveSheet(reminder: Reminder, onDismiss: () -> Unit, onProfile: (() -> Unit)? = null) {
  RelevoSheet(onDismiss = onDismiss, scrollable = false) {
    Text("El relevo está contando", style = Relevo.type.title2, color = Relevo.colors.ink)
    Spacer(Modifier.height(10.dp))
    Text(
      "Suena ${soundWhere(reminder)} cuando sumes ${formatDuration(reminder.requiredUsageSeconds)} en ${reminder.selectedApps.joinToString(" y ") { it.label }}.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.height(22.dp))
    if (onProfile != null) {
      // 4.4: el perfil se pide aquí, después del primer relevo, y no antes.
      Text("Mientras tanto, puedes completar el perfil: el nombre y lo que te gustaría hacer más seguido.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      Spacer(Modifier.height(14.dp))
      RelevoButton("Completar el perfil", onProfile)
      Spacer(Modifier.height(10.dp))
      RelevoButton("Más tarde", onDismiss, kind = ButtonKind.Secondary)
    } else {
      RelevoButton("Entendido", onDismiss)
    }
  }
}

/**
 * Lo que quedó para después (4.4, desde la 1.0.0): la persona respondió «La dejé para después» y pidió
 * dejarlo listo. Se activa con un toque, tal como estaba; no suena solo. «Ahora no» lo oculta.
 */
@Composable
private fun LaterCard(lastReminder: Reminder, customActivities: List<CustomActivity>, actions: HomeActions) {
  ActivityHero(
    activityIcon(lastReminder.activity, customActivities), lastReminder.activity, eyebrow = "Para después",
    detail = "${formatDuration(lastReminder.requiredUsageSeconds)} en ${lastReminder.selectedApps.joinToString(" y ") { it.label }} · suena ${soundWhere(lastReminder)}",
  ) {
    Spacer(Modifier.height(16.dp))
    RelevoButton("Activar ahora", actions.onLaterActivate)
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { PlainAction("Ahora no", actions.onLaterDismiss, color = Relevo.colors.graphite) }
  }
}

/** V1: «Hola de nuevo». La última actividad en su tarjeta de color; las opciones pesan lo mismo y «Ahora no» la oculta. */
@Composable
private fun ReturnCard(last: HistoryEntry, lastReminder: Reminder?, customActivities: List<CustomActivity>, actions: HomeActions) {
  val key = lastReminder?.let { photoKey("regreso", it.activity) }
  ActivityHero(activityIcon(last.activity, customActivities), last.activity, eyebrow = "La última vez", detail = null) {
    Spacer(Modifier.height(16.dp))
    if (lastReminder != null) RelevoButton("Preparar de nuevo", { actions.onRepeat(key) }, icon = KitIcon.REINTENTAR)
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
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
  quiet: Boolean = false,
  quietUntil: Int = 8,
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
    trailing = { Chip(if (usageAccess && !quiet) "Contando" else "En pausa", background = colors.mist) },
    bottom = { RelevoButton("Cambiar o desactivar", { options = true }, kind = ButtonKind.Secondary) },
  ) {
    Column(Modifier.fillMaxWidth().padding(top = 28.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      ActivityRing(activityIcon(reminder.activity, customActivities), 112.dp, modifier = Modifier.appear(0))
      Spacer(Modifier.height(20.dp))
      Text(reminder.activity.trim(), style = Relevo.type.title, color = colors.ink, textAlign = TextAlign.Center)
      Spacer(Modifier.height(36.dp))
      Text("Faltan", style = Relevo.type.subhead, color = colors.graphite)
      RollingContent(remaining) { BigCounter(it) }
      Text(
        "de ${formatDuration(reminder.requiredUsageSeconds)} en ${reminder.selectedApps.joinToString(" y ") { it.label }.ifBlank { "las apps que elegiste" }}",
        style = Relevo.type.subhead, color = colors.graphite, textAlign = TextAlign.Center,
      )
      Spacer(Modifier.height(18.dp))
      // Mismo ancho que la tarjeta de abajo: los bordes de la pantalla quedan en una sola columna.
      ProgressLine(progress)
      if (reminder.autoActivated) {
        Spacer(Modifier.height(14.dp))
        Text("Se activó solo.", style = Relevo.type.footnote, color = colors.graphite)
      }
      if (quiet) {
        Spacer(Modifier.height(14.dp))
        Text("Horas sin sonar: vuelve a contar a las $quietUntil:00", style = Relevo.type.subhead, color = colors.graphite, textAlign = TextAlign.Center)
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
      Text("Relevo", style = Relevo.type.title2, color = colors.ink)
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
      Text("Deja de contar, no suena y no queda en Relevos.", style = Relevo.type.body, color = colors.graphite)
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
