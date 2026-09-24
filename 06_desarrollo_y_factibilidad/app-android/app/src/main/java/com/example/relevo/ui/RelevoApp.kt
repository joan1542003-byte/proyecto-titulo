package com.example.relevo.ui

import android.provider.Settings
import android.Manifest
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.activity.compose.BackHandler
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.DirectionsWalk
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.SelfImprovement
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Insights
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.NotificationsActive
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.monitor.AppUsageSummary
import cl.udp.relevo.R
import com.example.relevo.theme.RelevoCoral
import com.example.relevo.theme.RelevoGraphite
import com.example.relevo.theme.RelevoTeal
import java.util.UUID
import dev.chrisbanes.haze.HazeProgressive
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.hazeEffect

private enum class Screen { CONSENT, ONBOARDING, HOME, SETUP, ACTIVE, SIGNAL, DONE }
private enum class HomeTab { START, ACTIVITY, HISTORY }
private enum class SetupStep { ACTIVITY, TIMING, PLACE, REVIEW }
private data class ActivityPreset(val activity: String, val start: String, val place: String, val image: Int)
private val activityPresets = listOf(
  ActivityPreset("Caminar", "Ponerme las zapatillas", "Junto a las zapatillas", R.drawable.activity_walk),
  ActivityPreset("Entrenar", "Preparar una serie", "Junto a las pesas", R.drawable.activity_train),
  ActivityPreset("Leer", "Abrir el libro", "Junto al libro", R.drawable.activity_read),
  ActivityPreset("Estudiar", "Abrir mis apuntes", "Junto al escritorio", R.drawable.activity_study),
  ActivityPreset("Dibujar", "Preparar el cuaderno", "Junto a mis materiales", R.drawable.activity_draw),
  ActivityPreset("Cocinar", "Reunir los ingredientes", "En la cocina", R.drawable.activity_cook),
  ActivityPreset("Ordenar", "Despejar una superficie", "En el espacio que quiero ordenar", R.drawable.activity_tidy),
)
private val customIcons = listOf("walk", "train", "read", "draw", "music", "pause", "cook", "star")
private val customColors = listOf(
  0xFFDDF4EC.toInt(), 0xFFE9E4F8.toInt(), 0xFFFFE8D9.toInt(),
  0xFFDDEBF9.toInt(), 0xFFF8E3E6.toInt(), 0xFFF1F0D8.toInt(),
)
private val customColorNames = listOf("menta", "lila", "durazno", "azul", "rosa", "crema")

private fun customIconLabel(key: String) = when (key) {
  "walk" -> "caminar"
  "train" -> "entrenar"
  "read" -> "leer"
  "draw" -> "dibujar"
  "music" -> "música"
  "pause" -> "pausa"
  "cook" -> "cocinar"
  else -> "estrella"
}

private fun customIcon(key: String) = when (key) {
  "walk" -> Icons.Rounded.DirectionsWalk
  "train" -> Icons.Rounded.FitnessCenter
  "read" -> Icons.Rounded.MenuBook
  "draw" -> Icons.Rounded.Brush
  "music" -> Icons.Rounded.MusicNote
  "pause" -> Icons.Rounded.SelfImprovement
  "cook" -> Icons.Rounded.Restaurant
  else -> Icons.Rounded.Star
}

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
  val animationsEnabled = rememberAnimationsEnabled()
  val reminder by viewModel.reminder.collectAsState()
  val remaining by viewModel.remainingSeconds.collectAsState()
  val apps by viewModel.installedApps.collectAsState()
  val usageAccess by viewModel.usageAccessGranted.collectAsState()
  val history by viewModel.history.collectAsState()
  val todayUsage by viewModel.todayUsage.collectAsState()
  val customActivities by viewModel.customActivities.collectAsState()
  val context = LocalContext.current
  var tab by rememberSaveable { mutableStateOf(HomeTab.START) }
  var createCustomRequested by rememberSaveable { mutableStateOf(false) }
  var showStartAcknowledgement by rememberSaveable { mutableStateOf(false) }
  val introduction = remember { context.getSharedPreferences("relevo_experience", android.content.Context.MODE_PRIVATE) }
  var screen by rememberSaveable {
    mutableStateOf(
      when {
        introduction.getString("academic_consent_version", null) != ResearchLogStore.CONSENT_VERSION -> Screen.CONSENT
        !introduction.getBoolean("onboarding_complete", false) -> Screen.ONBOARDING
        else -> screenFor(reminder.status)
      },
    )
  }

  LaunchedEffect(reminder.status) { screen = screenFor(reminder.status, screen) }

  Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
    AnimatedContent(
      targetState = screen,
      modifier = Modifier.fillMaxSize(),
      transitionSpec = {
        if (animationsEnabled) (fadeIn(tween(350)) + slideInHorizontally(tween(400)) { it / 10 }) togetherWith (fadeOut(tween(180)) + slideOutHorizontally(tween(300)) { -it / 12 })
        else EnterTransition.None togetherWith ExitTransition.None
      },
      label = "main_navigation",
    ) { currentScreen ->
    when (currentScreen) {
      Screen.CONSENT -> ConsentScreen(
        onAccept = {
          viewModel.updateConsent(true)
          screen = Screen.ONBOARDING
        },
        onDecline = { (context as? Activity)?.finishAndRemoveTask() },
      )
      Screen.ONBOARDING -> OnboardingScreen(
        usageAccess = usageAccess,
        onUsagePermission = viewModel::openUsageAccessSettings,
        onRefreshUsage = viewModel::refreshUsageAccess,
        onComplete = { configureFirst ->
          if (usageAccess) {
            introduction.edit().putBoolean("onboarding_complete", true).apply()
            screen = if (configureFirst) Screen.SETUP else Screen.HOME
          } else {
            screen = Screen.ONBOARDING
          }
        },
      )
      Screen.HOME -> HomeScreen(
        history, todayUsage, customActivities, reminder.participantCode, usageAccess, tab, viewModel::refreshDashboard,
        { screen = if (reminder.status == ReminderStatus.WAITING || reminder.status == ReminderStatus.SIGNALLED) screenFor(reminder.status) else Screen.SETUP },
        { preset ->
          if (reminder.status == ReminderStatus.WAITING || reminder.status == ReminderStatus.SIGNALLED) screen = screenFor(reminder.status)
          else { viewModel.applyPreset(preset.activity, preset.start, preset.place); screen = Screen.SETUP }
        },
        { custom ->
          if (reminder.status == ReminderStatus.WAITING || reminder.status == ReminderStatus.SIGNALLED) screen = screenFor(reminder.status)
          else { viewModel.applyPreset(custom.name, custom.firstStep, custom.place); screen = Screen.SETUP }
        },
        {
          if (reminder.status == ReminderStatus.WAITING || reminder.status == ReminderStatus.SIGNALLED) screen = screenFor(reminder.status)
          else { createCustomRequested = true; screen = Screen.SETUP }
        },
        { screen = screenFor(reminder.status, Screen.HOME) },
        reminder.status,
        { tab = it },
        showStartAcknowledgement,
        { showStartAcknowledgement = false },
      )
      Screen.SETUP -> SetupScreen(
        reminder = reminder,
        customActivities = customActivities,
        startWithEditor = createCustomRequested,
        apps = apps,
        usageAccess = usageAccess,
        onBack = { createCustomRequested = false; screen = Screen.HOME },
        onActivity = viewModel::updateActivity,
        onStart = viewModel::updateHowToStart,
        onPlace = viewModel::updatePlace,
        onApp = viewModel::selectTargetApp,
        onDuration = viewModel::updateRequiredUsage,
        onPreset = viewModel::applyPreset,
        onSaveCustom = { viewModel.saveCustomActivity(it); createCustomRequested = false },
        onDeleteCustom = viewModel::deleteCustomActivity,
        onPermission = viewModel::openUsageAccessSettings,
        onRefresh = viewModel::refreshUsageAccess,
        onTest = viewModel::testSignal,
        onActivate = {
          requestNotificationPermissionIfNeeded(context)
          if (viewModel.activate()) screen = Screen.ACTIVE
        },
      )
      Screen.ACTIVE -> ActiveScreen(reminder, remaining) { viewModel.disarm(); screen = Screen.DONE }
      Screen.SIGNAL -> SignalScreen(reminder) { viewModel.silence(); screen = Screen.DONE }
      Screen.DONE -> DoneScreen(reminder) { outcome ->
        viewModel.completeEvaluation(outcome)
        showStartAcknowledgement = outcome == "started"
        viewModel.reset()
        screen = Screen.HOME
      }
    }
    }
  }
}

@Composable
private fun Page(content: @Composable () -> Unit) {
  Box(Modifier.fillMaxSize().safeDrawingPadding().padding(horizontal = 24.dp, vertical = 18.dp)) { content() }
}

@Composable
private fun Brand() {
  Text("Relevo", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
}

@Composable
private fun HomeScreen(
  history: List<HistoryEntry>,
  usage: List<AppUsageSummary>,
  customActivities: List<CustomActivity>,
  participantCode: String,
  usageAccess: Boolean,
  tab: HomeTab,
  onRefresh: () -> Unit,
  onStart: () -> Unit,
  onPreset: (ActivityPreset) -> Unit,
  onCustom: (CustomActivity) -> Unit,
  onCreate: () -> Unit,
  onResume: () -> Unit,
  status: ReminderStatus,
  onSelectTab: (HomeTab) -> Unit,
  showStartAcknowledgement: Boolean,
  onDismissAcknowledgement: () -> Unit,
) {
  val animationsEnabled = rememberAnimationsEnabled()
  val hazeState = remember { HazeState() }
  LaunchedEffect(tab) { if (tab == HomeTab.ACTIVITY) onRefresh() }
  Box(Modifier.fillMaxSize()) {
    AnimatedContent(
      targetState = tab,
      modifier = Modifier.fillMaxSize().hazeSource(hazeState),
      transitionSpec = { if (animationsEnabled) fadeIn(tween(220)) togetherWith fadeOut(tween(160)) else EnterTransition.None togetherWith ExitTransition.None },
      label = "home_tabs",
    ) { selected ->
      when (selected) {
        HomeTab.START -> StartDashboard(history, usage, customActivities, onStart, onPreset, onCustom, onCreate, showStartAcknowledgement, onDismissAcknowledgement)
        HomeTab.ACTIVITY -> ActivityDashboard(usage, usageAccess, onStart)
        HomeTab.HISTORY -> HistoryDashboard(history, participantCode, onStart)
      }
    }
    Box(Modifier.align(Alignment.TopCenter).fillMaxWidth().height(92.dp)
      .hazeEffect(hazeState, style = HazeStyle(backgroundColor = Color(0xFFF8FAF8).copy(alpha = .12f), tints = emptyList(), blurRadius = 14.dp)) {
        progressive = HazeProgressive.verticalGradient(startIntensity = 1f, endIntensity = 0f)
      }, contentAlignment = Alignment.TopCenter) {
      Text("relevo", modifier = Modifier.statusBarsPadding().padding(top = 13.dp), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, letterSpacing = (-.7).sp)
    }
    Box(Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(96.dp)
      .hazeEffect(hazeState, style = HazeStyle(backgroundColor = Color(0xFFF8FAF8).copy(alpha = .07f), tints = emptyList(), blurRadius = 12.dp)) {
        progressive = HazeProgressive.verticalGradient(startIntensity = 0f, endIntensity = 1f)
      })
    FloatingTabBar(tab, onSelectTab, Modifier.align(Alignment.BottomCenter).hazeEffect(
      hazeState, style = HazeStyle(backgroundColor = Color.White.copy(alpha = .22f), tints = emptyList(), blurRadius = 18.dp),
    ))
    if (status == ReminderStatus.WAITING || status == ReminderStatus.SIGNALLED) {
      Surface(
        onClick = onResume,
        modifier = Modifier.align(Alignment.TopCenter).fillMaxWidth().padding(start = 24.dp, end = 24.dp, top = 104.dp),
        shape = RoundedCornerShape(20.dp),
        color = if (status == ReminderStatus.SIGNALLED) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.primaryContainer,
      ) {
        Row(Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
          Text(if (status == ReminderStatus.SIGNALLED) "El parlante está sonando" else "Tienes un relevo activo", Modifier.weight(1f), fontWeight = FontWeight.SemiBold)
          Icon(Icons.AutoMirrored.Rounded.ArrowForward, "Volver al relevo")
        }
      }
    }
  }
}

@Composable
private fun FloatingTabBar(currentTab: HomeTab, onSelect: (HomeTab) -> Unit, modifier: Modifier = Modifier) {
  val items = listOf(
    Triple(HomeTab.START, Icons.Rounded.Home, "Inicio"),
    Triple(HomeTab.ACTIVITY, Icons.Rounded.Insights, "Actividad"),
    Triple(HomeTab.HISTORY, Icons.Rounded.History, "Relevos"),
  )
  Surface(
    modifier = modifier.navigationBarsPadding().padding(horizontal = 18.dp, vertical = 8.dp).fillMaxWidth()
      .border(1.dp, Color.White.copy(alpha = .9f), RoundedCornerShape(32.dp)),
    shape = RoundedCornerShape(32.dp),
    color = Color(0xFFF1F6F3).copy(alpha = .68f),
    shadowElevation = 5.dp,
  ) {
    Row(Modifier.background(Brush.linearGradient(listOf(Color.White.copy(alpha = .45f), Color(0xFFDDECE8).copy(alpha = .25f)))).padding(5.dp), horizontalArrangement = Arrangement.spacedBy(3.dp)) {
      items.forEach { (tab, icon, label) ->
        val active = tab == currentTab
        val background by androidx.compose.animation.animateColorAsState(
          if (active) Color.White.copy(alpha = .94f) else Color.Transparent,
          animationSpec = tween(320),
          label = "tab_background",
        )
        Column(
          Modifier.weight(1f).height(60.dp).clip(RoundedCornerShape(26.dp)).background(background)
            .border(1.dp, if (active) Color.White else Color.Transparent, RoundedCornerShape(26.dp))
            .clickable { onSelect(tab) }
            .semantics { selected = active; contentDescription = label },
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Icon(icon, null, Modifier.size(20.dp), tint = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface)
          Spacer(Modifier.height(2.dp))
          Text(label, style = MaterialTheme.typography.labelMedium, fontWeight = if (active) FontWeight.SemiBold else FontWeight.Medium, color = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface)
        }
      }
    }
  }
}

@Composable
private fun StartDashboard(history: List<HistoryEntry>, usage: List<AppUsageSummary>, customActivities: List<CustomActivity>, onStart: () -> Unit, onPreset: (ActivityPreset) -> Unit, onCustom: (CustomActivity) -> Unit, onCreate: () -> Unit, showStartAcknowledgement: Boolean, onDismissAcknowledgement: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp).padding(top = 104.dp, bottom = 144.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    Spacer(Modifier.height(4.dp))
    AnimatedVisibility(showStartAcknowledgement, enter = expandVertically(tween(280)) + fadeIn(tween(220)), exit = shrinkVertically(tween(180)) + fadeOut(tween(150))) {
      Surface(shape = RoundedCornerShape(22.dp), color = MaterialTheme.colorScheme.primaryContainer) {
        Column(Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 15.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
          Text("¡Qué bueno que empezaste!", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onPrimaryContainer)
          Text("Dejamos registrada tu respuesta, tal como nos la contaste.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
          InlineAction("Cerrar", onDismissAcknowledgement, modifier = Modifier.align(Alignment.End))
        }
      }
    }
    Text("¿Qué quieres hacer?", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 42.sp, letterSpacing = (-1).sp)
    Text("Elige una actividad y decide cuánto tiempo usarás otra app antes de recibir el aviso.", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 23.sp)
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
      Text("Actividades", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
      InlineAction("Ver todas", onStart)
    }
    activityPresets.take(4).chunked(2).forEach { row ->
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        row.forEach { preset -> PresetCard(preset, false, Modifier.weight(1f)) { onPreset(preset) } }
      }
    }
    if (customActivities.isNotEmpty()) {
      Text("Tus actividades", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
      LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(customActivities) { activity -> CustomActivityCard(activity, Modifier.width(200.dp)) { onCustom(activity) } }
      }
    }
    AnimatedGradientAction(onCreate)
    Row(Modifier.fillMaxWidth().padding(vertical = 2.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
      MetricCard("Tiempo hoy en las apps que vinculaste", formatTime(usage.sumOf { it.seconds }), Icons.Rounded.Timer, Modifier.weight(1f).height(132.dp))
      MetricCard("Dijiste que empezaste", history.count { it.signalDelivered && it.outcome == "started" }.toString(), Icons.Rounded.History, Modifier.weight(1f).height(132.dp))
    }
    if (history.isNotEmpty()) {
      Text("La última vez", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
      HistoryCard(history.first())
    } else {
      Text("Cuando termines un relevo, podrás volver a verlo aquí.", color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodyMedium)
    }
    Spacer(Modifier.height(8.dp))
  }
}

@Composable
private fun AnimatedGradientAction(onClick: () -> Unit) {
  val animationsEnabled = rememberAnimationsEnabled()
  val transition = rememberInfiniteTransition(label = "primary_gradient")
  val gradientShift by transition.animateFloat(
    initialValue = 0f,
    targetValue = if (animationsEnabled) 1f else 0f,
    animationSpec = infiniteRepeatable(tween(4_000), RepeatMode.Reverse),
    label = "primary_gradient_shift",
  )
  val endColor = lerp(Color(0xFF096B60), Color(0xFF238A75), gradientShift)
  Surface(
    onClick = onClick,
    modifier = Modifier.fillMaxWidth().height(126.dp),
    shape = RoundedCornerShape(30.dp),
    color = Color.Transparent,
  ) {
    Box(Modifier.fillMaxSize().background(Brush.linearGradient(listOf(RelevoTeal, endColor)))) {
      Canvas(Modifier.fillMaxSize()) {
        val center = Offset(size.width * .85f, size.height * .35f)
        listOf(45f, 100f, 165f, 235f).forEach { radius ->
          drawCircle(Color.White.copy(alpha = .16f), radius = radius, center = center, style = Stroke(width = 1.dp.toPx()))
        }
        drawCircle(RelevoCoral, radius = 14.dp.toPx(), center = center)
      }
      Column(Modifier.fillMaxSize().padding(23.dp), verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(Modifier.height(1.dp))
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
          Column(Modifier.weight(1f)) {
            Text("Otra actividad", color = Color.White, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
            Text("Escribe la tuya", color = Color.White.copy(alpha = .8f))
          }
          Icon(Icons.AutoMirrored.Rounded.ArrowForward, null, tint = Color.White)
        }
      }
    }
  }
}

private data class OnboardingPage(val image: Int?, val title: String, val text: String, val permissions: Boolean = false)

@Composable
private fun ConsentScreen(onAccept: () -> Unit, onDecline: () -> Unit) {
  var checked by rememberSaveable { mutableStateOf(false) }
  Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFF075F54), Color(0xFF0A8573)))).safeDrawingPadding()) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
      Spacer(Modifier.height(18.dp))
      Text("Antes de comenzar", style = MaterialTheme.typography.displaySmall, color = Color.White, fontWeight = FontWeight.SemiBold)
      Text("Uso académico de los datos", style = MaterialTheme.typography.titleMedium, color = Color.White.copy(alpha = .76f))
      Spacer(Modifier.height(24.dp))
      Surface(Modifier.fillMaxWidth().weight(1f), RoundedCornerShape(30.dp), Color(0xFFF8FAF8)) {
        Column(Modifier.verticalScroll(rememberScrollState()).padding(24.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
          Text("Relevo es un prototipo de Proyecto de Título de Diseño de la Universidad Diego Portales. Los datos se usarán para evaluar su funcionamiento y la experiencia de uso.", lineHeight = 23.sp)
          ConsentPoint("Plazo y contacto", "El plazo máximo propuesto de conservación vence el 30 de diciembre de 2026 y se confirmará antes del testeo. Puedes solicitar retirar tu participación o pedir la eliminación de tus datos en joan1542003@gmail.com. La app no tiene un borrado integral; el procedimiento se verificará antes de iniciar las pruebas. Participar es voluntario y puedes detener un relevo cuando quieras.")
          ConsentPoint("Qué datos registra", "La actividad elegida, cómo quieres empezar, el lugar que indicas, la aplicación seleccionada y su identificador interno, el tiempo definido y las horas y eventos de inicio, uso, aviso y cierre. Tu respuesta final es opcional.")
          ConsentPoint("Dónde se guardan", "En esta versión configurada, los datos se guardan en el teléfono y se envían a Supabase, la base remota del estudio.")
          ConsentPoint("Qué no se consulta", "El permiso da acceso técnico a estadísticas de uso. Relevo está diseñado para contar la aplicación elegida; no lee mensajes, fotos, búsquedas ni contenido de pantalla.")
          ConsentPoint("Cómo se identifican", "Relevo crea un código aleatorio, un seudónimo, y no pide tu nombre, correo ni teléfono para funcionar. Los datos son seudonimizados, no anónimos: horarios y detalles podrían relacionarlos contigo.")
        }
      }
      Spacer(Modifier.height(12.dp))
      Row(
        Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(Color.White.copy(alpha = .12f)).clickable { checked = !checked }.padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Surface(Modifier.size(26.dp), RoundedCornerShape(8.dp), if (checked) Color(0xFFFF8B72) else Color.Transparent, border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = .8f))) {
          if (checked) Box(contentAlignment = Alignment.Center) { Icon(Icons.Rounded.CheckCircle, null, Modifier.size(18.dp), tint = Color.White) }
        }
        Spacer(Modifier.width(12.dp))
        Text("He leído y acepto participar.", color = Color.White, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
      }
      Spacer(Modifier.height(10.dp))
      ActionButton("Aceptar y continuar", onAccept, checked, Color(0xFFFF8B72), Color(0xFF321C17))
      InlineAction("No participar", onDecline, Color.White, Modifier.align(Alignment.CenterHorizontally))
    }
  }
}

@Composable
private fun ConsentPoint(title: String, text: String) {
  Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
    Text(title, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
    Text(text, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 21.sp)
  }
}

@Composable
private fun OnboardingScreen(
  usageAccess: Boolean,
  onUsagePermission: () -> Unit,
  onRefreshUsage: () -> Unit,
  onComplete: (Boolean) -> Unit,
) {
  val animationsEnabled = rememberAnimationsEnabled()
  val context = LocalContext.current
  var notificationAccess by remember { mutableStateOf(hasNotificationPermission(context)) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
    onRefreshUsage()
    notificationAccess = hasNotificationPermission(context)
  }
  val pages = remember { listOf(
    OnboardingPage(R.drawable.onboarding_activity, "Elige una actividad", "Puedes partir de una sugerencia o guardar una actividad propia con una forma sencilla de comenzar."),
    OnboardingPage(R.drawable.onboarding_condition, "Define cuándo avisarte", "Elige una aplicación y un tiempo. El conteo funciona solo mientras el relevo está activo."),
    OnboardingPage(R.drawable.onboarding_place, "Ubica el dispositivo", "Déjalo cerca de aquello que necesitas para comenzar: tus zapatillas, un libro o tus materiales."),
    OnboardingPage(R.drawable.onboarding_signal, "Recibe el aviso", "Al cumplirse el tiempo, Relevo reproduce un sonido en el parlante Bluetooth conectado. Tú decides qué hacer después."),
    OnboardingPage(null, "Autoriza Tiempo de uso", "Relevo necesita contar el tiempo de la aplicación que elegiste para activar el aviso. No lee lo que haces dentro de ella. Las notificaciones ayudan a mostrar el aviso cuando usas otra app y son opcionales.", permissions = true),
  ) }
  var page by rememberSaveable { mutableStateOf(0) }
  BackHandler { if (page > 0) page -= 1 }
  val item = pages[page]
  Box(
    Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFFF8FBF9), Color(0xFFEAF8F4), Color(0xFFF7F8F6)))).safeDrawingPadding().padding(24.dp),
  ) {
    Column(Modifier.fillMaxSize()) {
      Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("Cómo funciona", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.weight(1f)); Text("${page + 1} de ${pages.size}", color = MaterialTheme.colorScheme.onSurfaceVariant)
      }
      Spacer(Modifier.height(12.dp))
      val progress by animateFloatAsState(
        targetValue = (page + 1).toFloat() / pages.size,
        animationSpec = tween(if (animationsEnabled) 420 else 0),
        label = "onboarding_progress",
      )
      LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier.fillMaxWidth().height(5.dp).clip(CircleShape),
        color = MaterialTheme.colorScheme.primary,
        trackColor = MaterialTheme.colorScheme.outline.copy(alpha = .18f),
      )
      Spacer(Modifier.height(14.dp))
      BoxWithConstraints(Modifier.weight(1f).fillMaxWidth()) {
        val illustrationHeight = (maxHeight * .58f).coerceIn(240.dp, 400.dp)
        AnimatedContent(
          targetState = item,
          modifier = Modifier.fillMaxSize(),
          transitionSpec = {
            if (animationsEnabled) (fadeIn(tween(350)) + slideInHorizontally(tween(400)) { it / 6 }) togetherWith (fadeOut(tween(180)) + slideOutHorizontally(tween(300)) { -it / 7 })
            else EnterTransition.None togetherWith ExitTransition.None
          },
          label = "onboarding_page",
        ) { current ->
          Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            if (current.image == null) PermissionIllustration(Modifier.height(illustrationHeight))
            else Image(
              painter = painterResource(current.image),
              contentDescription = current.title,
              contentScale = ContentScale.Crop,
              modifier = Modifier.fillMaxWidth().height(illustrationHeight).clip(RoundedCornerShape(30.dp)),
            )
            Text(current.title, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold, lineHeight = 37.sp)
            Text(current.text, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 23.sp)
            if (current.permissions) {
              PermissionRow("Tiempo de uso", "Permite contar cuánto tiempo usas la aplicación que elegiste.", usageAccess) { onUsagePermission() }
              PermissionRow("Notificaciones", "Muestran el aviso aunque otra aplicación esté abierta. Puedes continuar sin activarlas.", notificationAccess) {
                requestNotificationPermissionIfNeeded(context)
              }
              if (!usageAccess) {
                Text(
                  "Tiempo de uso es necesario para medir la aplicación y activar un relevo. Sin este permiso no puedes terminar ni ir a Inicio. Las notificaciones son opcionales.",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  lineHeight = 22.sp,
                )
              }
            }
          }
        }
      }
      Spacer(Modifier.height(10.dp))
      PrimaryButton(
        if (page == pages.lastIndex) "Preparar mi primer relevo" else "Continuar",
        onClick = { if (page == pages.lastIndex) onComplete(true) else page += 1 },
        enabled = page != pages.lastIndex || usageAccess,
      )
      Spacer(Modifier.height(8.dp))
      Box(Modifier.fillMaxWidth().height(40.dp), contentAlignment = Alignment.Center) {
        if (page == pages.lastIndex && usageAccess) {
          InlineAction("Ir al inicio", { onComplete(false) }, modifier = Modifier.align(Alignment.Center))
        }
      }
    }
  }
}

@Composable
private fun PermissionIllustration(modifier: Modifier = Modifier) {
  Box(
    modifier.fillMaxWidth().clip(RoundedCornerShape(30.dp))
      .background(Brush.linearGradient(listOf(Color(0xFFE6F4EF), Color(0xFFF8F4EC)))),
    contentAlignment = Alignment.Center,
  ) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 32.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
      listOf(Icons.Rounded.Timer to "Tiempo de uso", Icons.Rounded.NotificationsActive to "Notificaciones").forEach { (icon, label) ->
        Surface(shape = RoundedCornerShape(20.dp), color = Color.White.copy(alpha = .88f)) {
          Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, Modifier.size(22.dp), tint = RelevoTeal)
            Spacer(Modifier.width(14.dp))
            Text(label, Modifier.weight(1f), fontWeight = FontWeight.SemiBold)
          }
        }
      }
    }
  }
}

@Composable
private fun PermissionRow(title: String, description: String, granted: Boolean, onClick: () -> Unit) {
  Row(
    Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(Color.White.copy(alpha = .72f))
      .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .12f), RoundedCornerShape(20.dp))
      .clickable(enabled = !granted, onClick = onClick).padding(15.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
      Text(title, fontWeight = FontWeight.SemiBold)
      Text(description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    Text(if (granted) "Activado" else "Permitir", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
  }
}

@Composable
private fun ActivityDashboard(usage: List<AppUsageSummary>, hasAccess: Boolean, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp).padding(top = 104.dp, bottom = 144.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
    Text("Tu tiempo,\nen contexto.", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 42.sp)
    Text("Aquí aparece únicamente el uso de las apps que elegiste para un relevo.", color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)
    if (!hasAccess) EmptyDashboard("Falta un permiso", "Al preparar tu primer relevo podrás autorizar Tiempo de uso.", onStart)
    else if (usage.isEmpty()) EmptyDashboard("Todavía no hay tiempo que mostrar", "Cuando actives un relevo, verás aquí el tiempo acumulado en la app elegida.", onStart)
    else {
      val total = usage.sumOf { it.seconds }.coerceAtLeast(1)
      Card(shape = RoundedCornerShape(28.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.fillMaxWidth().padding(22.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text("Tiempo acumulado hoy", color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = .72f))
          Text(formatTime(total), style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
          Text("en ${usage.size} ${if (usage.size == 1) "aplicación vinculada" else "aplicaciones vinculadas"}", style = MaterialTheme.typography.bodySmall)
        }
      }
      usage.forEach { item -> AppUsageCard(item, total) }
      SecondaryButton("Nuevo relevo", onStart)
    }
  }
}

@Composable
private fun HistoryDashboard(history: List<HistoryEntry>, participantCode: String, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp).padding(top = 104.dp, bottom = 144.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
    Text("Tus relevos.", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 42.sp)
    Text("Tus actividades y el tiempo que pasaste en las apps vinculadas.", color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)
    if (history.isEmpty()) EmptyDashboard("Aún no hay relevos", "Los que cierres quedarán aquí para que puedas volver a mirarlos.", onStart)
    else {
      val counts = history.groupingBy { it.activity }.eachCount().entries.sortedByDescending { it.value }
      Card(shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
        Column(Modifier.fillMaxWidth().padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
          Text("Actividades elegidas", fontWeight = FontWeight.SemiBold)
          counts.take(5).forEach { entry ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
              Text(entry.key)
              Text("${entry.value} ${if (entry.value == 1) "vez" else "veces"}", fontWeight = FontWeight.SemiBold)
            }
          }
        }
      }
      history.forEach { HistoryCard(it) }
      SecondaryButton("Crear relevo", onStart)
    }
    Surface(shape = RoundedCornerShape(22.dp), color = MaterialTheme.colorScheme.surface) {
      Column(Modifier.fillMaxWidth().padding(18.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text("Tu código para consultar tus datos", fontWeight = FontWeight.SemiBold)
        SelectionContainer { Text(participantCode, style = MaterialTheme.typography.titleMedium) }
        Text("Puedes usarlo para solicitar información o la eliminación de tus registros en joan1542003@gmail.com.", color = MaterialTheme.colorScheme.onSurfaceVariant)
      }
    }
  }
}

@Composable
private fun EmptyDashboard(title: String, detail: String, onStart: () -> Unit) {
  Spacer(Modifier.height(10.dp))
  Box(Modifier.fillMaxWidth().height(180.dp).clip(RoundedCornerShape(30.dp)).background(MaterialTheme.colorScheme.primaryContainer)) {
    Canvas(Modifier.fillMaxSize()) {
      val center = Offset(size.width * .5f, size.height * .5f)
      listOf(26f, 54f, 82f).forEach { radius ->
        drawCircle(RelevoTeal.copy(alpha = .23f), radius.dp.toPx(), center, style = Stroke(1.dp.toPx()))
      }
      drawCircle(RelevoTeal, 8.dp.toPx(), center)
    }
  }
  Text(title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
  Text(detail, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)
  Spacer(Modifier.height(4.dp))
  PrimaryButton("Preparar un relevo", onStart)
}

@Composable
private fun MetricCard(label: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector, modifier: Modifier = Modifier) {
  Box(modifier.clip(RoundedCornerShape(22.dp)).background(Color.White).border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .1f), RoundedCornerShape(22.dp))) {
    Column(Modifier.padding(17.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
      Text(value, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold, color = RelevoGraphite)
      Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 17.sp)
    }
  }
}

@Composable
private fun AppUsageCard(item: AppUsageSummary, totalSeconds: Int) {
  Box(Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(Color.White).border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .1f), RoundedCornerShape(20.dp))) {
    Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
      AppIcon(item.packageName); Spacer(Modifier.width(14.dp))
      Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) { Text(item.label, fontWeight = FontWeight.Medium); Text(formatTime(item.seconds), color = MaterialTheme.colorScheme.onSurfaceVariant) }
        LinearProgressIndicator(
          progress = { item.seconds.toFloat() / totalSeconds.coerceAtLeast(1) },
          modifier = Modifier.fillMaxWidth().height(7.dp).clip(CircleShape),
          color = MaterialTheme.colorScheme.primary,
          trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
      }
    }
  }
}

@Composable
private fun HistoryCard(entry: HistoryEntry) {
  Box(Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(Color.White).border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .1f), RoundedCornerShape(20.dp))) {
    Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
      AppIcon(entry.appPackage); Spacer(Modifier.width(14.dp))
      Column(Modifier.weight(1f)) {
        Text(entry.activity, fontWeight = FontWeight.SemiBold)
        Text("${entry.appLabel} · ${formatTime(entry.seconds)}", color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(
          when {
            entry.signalDelivered && entry.outcome == "started" -> "Dijiste que empezaste"
            entry.signalDelivered && entry.outcome == "later" -> "La dejaste para después"
            entry.signalDelivered && entry.outcome == "changed" -> "Cambiaste de idea"
            entry.signalDelivered -> "Aviso emitido"
            else -> "Cerrado antes del aviso"
          },
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SetupScreen(
  reminder: Reminder,
  customActivities: List<CustomActivity>,
  startWithEditor: Boolean,
  apps: List<InstalledApp>,
  usageAccess: Boolean,
  onBack: () -> Unit,
  onActivity: (String) -> Unit,
  onStart: (String) -> Unit,
  onPlace: (String) -> Unit,
  onApp: (InstalledApp) -> Unit,
  onDuration: (Int) -> Unit,
  onPreset: (String, String, String) -> Unit,
  onSaveCustom: (CustomActivity) -> Unit,
  onDeleteCustom: (String) -> Unit,
  onPermission: () -> Unit,
  onRefresh: () -> Unit,
  onTest: () -> Boolean,
  onActivate: () -> Unit,
) {
  var step by rememberSaveable { mutableStateOf(if (reminder.activity.isBlank()) SetupStep.ACTIVITY else SetupStep.TIMING) }
  var chooseApp by rememberSaveable { mutableStateOf(false) }
  var editingCustom by rememberSaveable { mutableStateOf(startWithEditor) }
  var editingCustomId by rememberSaveable { mutableStateOf<String?>(null) }
  var testMessage by rememberSaveable { mutableStateOf<String?>(null) }
  var customDraftName by rememberSaveable { mutableStateOf("") }
  var customDraftStart by rememberSaveable { mutableStateOf("") }
  var customDraftPlace by rememberSaveable { mutableStateOf("") }
  var customDraftIcon by rememberSaveable { mutableStateOf(customIcons.first()) }
  var customDraftColor by rememberSaveable { mutableStateOf(customColors.first()) }
  var customEditorPage by rememberSaveable { mutableStateOf(0) }

  fun goBackOneStep() {
    if (step == SetupStep.ACTIVITY) onBack()
    else step = SetupStep.entries[step.ordinal - 1]
  }
  BackHandler(enabled = !editingCustom && !chooseApp) { goBackOneStep() }

  if (editingCustom) {
    CustomActivityEditor(
      initial = customActivities.firstOrNull { it.id == editingCustomId },
      existing = customActivities,
      name = customDraftName,
      onNameChange = { customDraftName = it },
      firstStep = customDraftStart,
      onFirstStepChange = { customDraftStart = it },
      place = customDraftPlace,
      onPlaceChange = { customDraftPlace = it },
      icon = customDraftIcon,
      onIconChange = { customDraftIcon = it },
      color = customDraftColor,
      onColorChange = { customDraftColor = it },
      page = customEditorPage,
      onPageChange = { customEditorPage = it },
      onCancel = { editingCustom = false; editingCustomId = null },
      onSave = {
        onSaveCustom(it)
        editingCustom = false
        editingCustomId = null
        customDraftName = ""
        customDraftStart = ""
        customDraftPlace = ""
        customDraftIcon = customIcons.first()
        customDraftColor = customColors.first()
        customEditorPage = 0
        step = SetupStep.TIMING
      },
      onDelete = { id ->
        onDeleteCustom(id)
        onActivity(""); onStart(""); onPlace("")
        editingCustom = false
        editingCustomId = null
        customDraftName = ""
        customDraftStart = ""
        customDraftPlace = ""
        customDraftIcon = customIcons.first()
        customDraftColor = customColors.first()
        customEditorPage = 0
        step = SetupStep.ACTIVITY
      },
    )
    return
  }
  if (chooseApp) {
    AppPicker(apps, { chooseApp = false }) { onApp(it); chooseApp = false }
    return
  }

  val canContinue = when (step) {
    SetupStep.ACTIVITY -> reminder.activity.isNotBlank()
    SetupStep.TIMING -> reminder.targetPackage.isNotBlank() && usageAccess
    SetupStep.PLACE -> reminder.howToStart.isNotBlank() && reminder.place.isNotBlank()
    SetupStep.REVIEW -> reminder.hasRequiredContent && usageAccess
  }
  val title = when (step) {
    SetupStep.ACTIVITY -> "¿Qué quieres hacer?"
    SetupStep.TIMING -> "¿Cuándo quieres el aviso?"
    SetupStep.PLACE -> "Sitúa tu relevo"
    SetupStep.REVIEW -> "Revisa tu relevo"
  }
  val animationsEnabled = rememberAnimationsEnabled()
  val progress by animateFloatAsState(
    targetValue = (step.ordinal + 1).toFloat() / SetupStep.entries.size,
    animationSpec = tween(if (animationsEnabled) 420 else 0),
    label = "setup_progress",
  )
  Page {
    Column(Modifier.fillMaxSize()) {
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        InlineAction("Volver", { goBackOneStep() })
        Text("${step.ordinal + 1} de 4", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
      }
      Spacer(Modifier.height(12.dp))
      LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier.fillMaxWidth().height(5.dp).clip(CircleShape),
        color = MaterialTheme.colorScheme.primary,
        trackColor = MaterialTheme.colorScheme.outline.copy(alpha = .18f),
      )
      Spacer(Modifier.height(24.dp))
      Text(title, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold, lineHeight = 37.sp)
      Spacer(Modifier.height(20.dp))
      AnimatedContent(
        targetState = step,
        modifier = Modifier.weight(1f),
        transitionSpec = {
          (fadeIn(tween(260)) + slideInHorizontally(tween(320)) { it / 8 }) togetherWith
            (fadeOut(tween(130)) + slideOutHorizontally(tween(220)) { -it / 10 })
        },
        label = "setup_steps",
      ) { current ->
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
          when (current) {
            SetupStep.ACTIVITY -> {
              Text("Elige una opción o guarda una actividad propia.", color = MaterialTheme.colorScheme.onSurfaceVariant)
              LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(activityPresets) { preset ->
                  PresetCard(preset, reminder.activity == preset.activity, Modifier.width(160.dp)) {
                    onPreset(preset.activity, preset.start, preset.place)
                    step = SetupStep.TIMING
                  }
                }
              }
              if (customActivities.isNotEmpty()) {
                Text("Tus actividades", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                  items(customActivities) { custom ->
                    CustomActivityCard(custom, Modifier.width(200.dp)) {
                      onPreset(custom.name, custom.firstStep, custom.place)
                      step = SetupStep.TIMING
                    }
                  }
                }
              }
              InlineAction("Crear una actividad", { editingCustomId = null; editingCustom = true })
            }
            SetupStep.TIMING -> {
              Text("El tiempo se acumula solo mientras usas la aplicación que elijas.", color = MaterialTheme.colorScheme.onSurfaceVariant)
              Row(
                Modifier.fillMaxWidth().height(60.dp).clip(RoundedCornerShape(20.dp))
                  .background(MaterialTheme.colorScheme.surfaceVariant).clickable { chooseApp = true }.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
              ) {
                if (reminder.targetPackage.isNotBlank()) { AppIcon(reminder.targetPackage); Spacer(Modifier.width(10.dp)) }
                else Icon(Icons.Rounded.Apps, null)
                Text(reminder.targetAppLabel.ifBlank { "Elegir una aplicación" }, Modifier.padding(start = 8.dp).weight(1f), fontWeight = FontWeight.Medium)
                Text(if (reminder.targetPackage.isBlank()) "Elegir" else "Cambiar", color = MaterialTheme.colorScheme.primary)
              }
              Surface(shape = RoundedCornerShape(28.dp), color = MaterialTheme.colorScheme.primaryContainer) {
                Column(Modifier.fillMaxWidth().padding(20.dp), verticalArrangement = Arrangement.spacedBy(13.dp)) {
                  Text("Avísame después de", color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = .8f))
                  Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    RoundTimeButton(Icons.Rounded.Remove, "Restar tiempo", reminder.requiredUsageSeconds > 60) {
                      val step = if (reminder.requiredUsageSeconds > 3600) 300 else 60
                      onDuration((reminder.requiredUsageSeconds - step).coerceAtLeast(60))
                    }
                    AnimatedContent(reminder.requiredUsageSeconds, modifier = Modifier.weight(1f), label = "duration_value") { seconds ->
                      Text(formatTime(seconds), Modifier.fillMaxWidth(), style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.SemiBold, color = RelevoGraphite, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                    }
                    RoundTimeButton(Icons.Rounded.Add, "Sumar tiempo", reminder.requiredUsageSeconds < 21600) {
                      val step = if (reminder.requiredUsageSeconds >= 3600) 300 else 60
                      onDuration((reminder.requiredUsageSeconds + step).coerceAtMost(21600))
                    }
                  }
                  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(900 to "15 min", 3600 to "1 h", 7200 to "2 h").forEach { (seconds, label) ->
                      TimeChoice(label, reminder.requiredUsageSeconds == seconds, Modifier.weight(1f)) { onDuration(seconds) }
                    }
                  }
                  Slider(
                    value = reminder.requiredUsageSeconds.coerceIn(60, 21600) / 60f,
                    onValueChange = {
                      val minutes = it.toInt().coerceIn(1, 360)
                      onDuration((if (minutes <= 60) minutes else (minutes / 5) * 5) * 60)
                    },
                    valueRange = 1f..360f,
                    colors = SliderDefaults.colors(
                      thumbColor = MaterialTheme.colorScheme.primary,
                      activeTrackColor = MaterialTheme.colorScheme.primary,
                      inactiveTrackColor = Color.White.copy(alpha = .85f),
                    ),
                  )
                  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("1 min", style = MaterialTheme.typography.labelSmall)
                    Text("6 h", style = MaterialTheme.typography.labelSmall)
                  }
                }
              }
              if (!usageAccess) PermissionCard(usageAccess, onPermission, onRefresh)
              InlineAction("Prueba de 15 s", { onDuration(15) })
            }
            SetupStep.PLACE -> {
              Text("Piensa en una acción pequeña que te ayude a comenzar y deja el parlante cerca de ella.",
                color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 23.sp)
              RelevoTextField("¿Cómo empezarás?", reminder.howToStart, "Ponerme las zapatillas", onStart)
              RelevoTextField("Ubicación de Relevo", reminder.place, "Junto a las zapatillas", onPlace)
            }
            SetupStep.REVIEW -> {
              Text("Comprueba los datos antes de activar. Puedes volver a cualquier paso.", color = MaterialTheme.colorScheme.onSurfaceVariant)
              DetailRow("Actividad", reminder.activity) { step = SetupStep.ACTIVITY }
              DetailRow("Aplicación", reminder.targetAppLabel) { step = SetupStep.TIMING }
              DetailRow("Tiempo acumulado", formatTime(reminder.requiredUsageSeconds)) { step = SetupStep.TIMING }
              DetailRow("Para empezar", reminder.howToStart) { step = SetupStep.PLACE }
              DetailRow("Ubicación de Relevo", reminder.place) { step = SetupStep.PLACE }
              Text("El sonido irá al parlante Bluetooth conectado. Sin él, recibirás solo el aviso visual.",
                style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 20.sp)
              InlineAction("Probar sonido", {
                testMessage = if (onTest()) "El sonido sonará unos segundos." else "No se encontró un parlante Bluetooth conectado."
              })
              if (testMessage != null) Text(testMessage.orEmpty(), color = MaterialTheme.colorScheme.primary)
            }
          }
          Spacer(Modifier.height(12.dp))
        }
      }
      Spacer(Modifier.height(10.dp))
      PrimaryButton(if (step == SetupStep.REVIEW) "Activar relevo" else "Continuar", {
        if (step == SetupStep.REVIEW) onActivate() else step = SetupStep.entries[step.ordinal + 1]
      }, canContinue)
    }
  }
}
@Composable
private fun DetailRow(label: String, value: String, onEdit: () -> Unit) {
  Row(
    Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(Color.White)
      .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .13f), RoundedCornerShape(20.dp))
      .clickable(onClick = onEdit).padding(horizontal = 17.dp, vertical = 13.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Column(Modifier.weight(1f)) {
      Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text(value.ifBlank { "Añadir detalle" }, fontWeight = FontWeight.Medium)
    }
    Icon(Icons.Rounded.Edit, "Editar $label", Modifier.size(19.dp), tint = MaterialTheme.colorScheme.primary)
  }
}

@Composable
private fun RoundTimeButton(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, enabled: Boolean, onClick: () -> Unit) {
  Box(
    Modifier.size(48.dp).clip(CircleShape).background(Color.White.copy(alpha = if (enabled) .9f else .38f))
      .clickable(enabled = enabled, onClick = onClick),
    contentAlignment = Alignment.Center,
  ) {
    Icon(icon, label, Modifier.size(20.dp), tint = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant)
  }
}

@Composable
private fun PresetCard(preset: ActivityPreset, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
  val interactions = remember { MutableInteractionSource() }
  val pressed by interactions.collectIsPressedAsState()
  val animationsEnabled = rememberAnimationsEnabled()
  val size by animateFloatAsState(if (pressed && animationsEnabled) .965f else 1f, spring(), label = "activity_press")
  val haptics = LocalHapticFeedback.current
  Box(
    modifier.height(158.dp).scale(size).clip(RoundedCornerShape(24.dp))
      .border(2.dp, if (selected) MaterialTheme.colorScheme.primary else Color(0xFFE1E5E1), RoundedCornerShape(24.dp))
      .clickable(interactionSource = interactions, indication = null) { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onClick() },
  ) {
    Image(painterResource(preset.image), null, Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
    Box(Modifier.fillMaxWidth().height(62.dp).background(Brush.verticalGradient(listOf(Color.White.copy(alpha = .9f), Color.White.copy(alpha = 0f)))))
    Row(Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
      Text(preset.activity, fontWeight = FontWeight.SemiBold, color = RelevoGraphite)
      Icon(Icons.AutoMirrored.Rounded.ArrowForward, null, Modifier.size(16.dp), tint = RelevoGraphite)
    }
  }
}

@Composable
private fun CustomActivitySymbol(activity: CustomActivity, modifier: Modifier = Modifier) {
  Box(modifier.background(Color(activity.color)), contentAlignment = Alignment.Center) {
    Icon(customIcon(activity.icon), null, Modifier.size(34.dp), tint = RelevoGraphite)
  }
}

@Composable
private fun CustomActivityCard(activity: CustomActivity, modifier: Modifier = Modifier, onClick: () -> Unit) {
  val interactions = remember { MutableInteractionSource() }
  val pressed by interactions.collectIsPressedAsState()
  val scale by animateFloatAsState(if (pressed && rememberAnimationsEnabled()) .965f else 1f, spring(), label = "custom_activity_press")
  Box(modifier.height(158.dp).scale(scale).clip(RoundedCornerShape(24.dp))
    .background(Color(activity.color)).clickable(interactionSource = interactions, indication = null, onClick = onClick)) {
    Icon(customIcon(activity.icon), null, Modifier.align(Alignment.Center).size(64.dp), tint = RelevoGraphite.copy(alpha = .72f))
    Row(Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
      Text(activity.name, Modifier.weight(1f), fontWeight = FontWeight.SemiBold, color = RelevoGraphite, maxLines = 2, overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis)
      Icon(Icons.AutoMirrored.Rounded.ArrowForward, null, Modifier.size(17.dp), tint = RelevoGraphite)
    }
  }
}

@Composable
private fun CustomActivityEditor(
  initial: CustomActivity?,
  existing: List<CustomActivity>,
  name: String,
  onNameChange: (String) -> Unit,
  firstStep: String,
  onFirstStepChange: (String) -> Unit,
  place: String,
  onPlaceChange: (String) -> Unit,
  icon: String,
  onIconChange: (String) -> Unit,
  color: Int,
  onColorChange: (Int) -> Unit,
  page: Int,
  onPageChange: (Int) -> Unit,
  onCancel: () -> Unit,
  onSave: (CustomActivity) -> Unit,
  onDelete: (String) -> Unit,
) = Page {
  var confirmDelete by rememberSaveable(initial?.id) { mutableStateOf(false) }
  val animationsEnabled = rememberAnimationsEnabled()
  val progress by animateFloatAsState(
    targetValue = (page + 1).toFloat() / 3,
    animationSpec = tween(if (animationsEnabled) 420 else 0),
    label = "custom_activity_progress",
  )
  BackHandler {
    if (page == 0) onCancel() else onPageChange(page - 1)
  }
  val duplicate = activityPresets.any { it.activity.equals(name.trim(), ignoreCase = true) } ||
    existing.any { it.id != initial?.id && it.name.equals(name.trim(), ignoreCase = true) }
  val nameValid = name.trim().length in 2..60 && !duplicate
  val detailsValid = firstStep.isNotBlank() && place.isNotBlank()

  Column(Modifier.fillMaxSize()) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      InlineAction("Volver", { if (page == 0) onCancel() else onPageChange(page - 1) })
      Text("${page + 1} de 3", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    Spacer(Modifier.height(12.dp))
    LinearProgressIndicator(
      progress = { progress },
      modifier = Modifier.fillMaxWidth().height(5.dp).clip(CircleShape),
      color = MaterialTheme.colorScheme.primary,
      trackColor = MaterialTheme.colorScheme.outline.copy(alpha = .18f),
    )
    Spacer(Modifier.height(24.dp))
    Text(when (page) {
      0 -> if (initial == null) "Nombra tu actividad" else "Edita tu actividad"
      1 -> "Hazla concreta"
      else -> "Dale un aspecto propio"
    }, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Spacer(Modifier.height(20.dp))
    AnimatedContent(
      targetState = page, modifier = Modifier.weight(1f),
      transitionSpec = { (fadeIn(tween(250)) + slideInHorizontally(tween(280)) { it / 8 }) togetherWith fadeOut(tween(140)) },
      label = "custom_activity_steps",
    ) { current ->
      Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(18.dp)) {
        when (current) {
          0 -> {
            Text("Usa un nombre que reconozcas de inmediato.", color = MaterialTheme.colorScheme.onSurfaceVariant)
            RelevoTextField("Nombre", name, "Por ejemplo, practicar guitarra", { onNameChange(it.take(60)) })
            if (duplicate) Text("Ese nombre ya está en uso.", color = MaterialTheme.colorScheme.error)
          }
          1 -> {
            Text("Elige una acción fácil de comenzar y dónde dejarás el parlante.", color = MaterialTheme.colorScheme.onSurfaceVariant)
            RelevoTextField("¿Cómo empezarás?", firstStep, "Sacar la guitarra", { onFirstStepChange(it.take(120)) })
            RelevoTextField("Ubicación de Relevo", place, "Junto a la guitarra", { onPlaceChange(it.take(120)) })
          }
          else -> {
            Text("El icono y el color te ayudarán a reconocer esta actividad más adelante.",
              color = MaterialTheme.colorScheme.onSurfaceVariant)
            Surface(shape = RoundedCornerShape(24.dp), color = Color(color)) {
              Row(Modifier.fillMaxWidth().padding(22.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(customIcon(icon), null, Modifier.size(38.dp), tint = RelevoGraphite)
                Spacer(Modifier.width(14.dp))
                Text(name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = RelevoGraphite)
              }
            }
            Text("Icono", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
              items(customIcons) { option ->
                val chosen = icon == option
                Box(Modifier.size(58.dp).clip(RoundedCornerShape(18.dp))
                  .background(if (chosen) Color(color) else MaterialTheme.colorScheme.surfaceVariant)
                  .border(if (chosen) 2.dp else 1.dp, if (chosen) MaterialTheme.colorScheme.primary else Color.Transparent, RoundedCornerShape(18.dp))
                  .semantics { contentDescription = "Icono ${customIconLabel(option)}"; selected = chosen }
                  .clickable { onIconChange(option) }, contentAlignment = Alignment.Center) {
                  Icon(customIcon(option), null, Modifier.size(27.dp), tint = RelevoGraphite)
                }
              }
            }
            Text("Color de fondo", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
              items(customColors) { option ->
                Box(Modifier.size(52.dp).clip(CircleShape).background(Color(option))
                  .border(if (color == option) 3.dp else 1.dp, if (color == option) RelevoGraphite else Color.Black.copy(alpha = .1f), CircleShape)
                  .semantics { contentDescription = "Color ${customColorNames[customColors.indexOf(option)]}"; selected = color == option }
                  .clickable { onColorChange(option) }, contentAlignment = Alignment.Center) {
                  if (color == option) Icon(Icons.Rounded.CheckCircle, null, Modifier.size(20.dp), tint = RelevoGraphite)
                }
              }
            }
            if (initial != null) InlineAction(if (confirmDelete) "Confirmar eliminación" else "Eliminar actividad", {
              if (confirmDelete) onDelete(initial.id) else confirmDelete = true
            })
          }
        }
      }
    }
    Spacer(Modifier.height(10.dp))
    PrimaryButton(if (page == 2) "Guardar actividad" else "Continuar", {
      if (page < 2) onPageChange(page + 1)
      else onSave(CustomActivity(initial?.id ?: UUID.randomUUID().toString(), name.trim(), firstStep.trim(), place.trim(), icon, color))
    }, when (page) { 0 -> nameValid; 1 -> detailsValid; else -> nameValid && detailsValid })
  }
}
@Composable
private fun RelevoTextField(label: String, value: String, placeholder: String, onValueChange: (String) -> Unit) {
  Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
    Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    BasicTextField(
      value = value,
      onValueChange = onValueChange,
      singleLine = true,
      textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
      cursorBrush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.primary),
      modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(horizontal = 18.dp, vertical = 17.dp),
      decorationBox = { inner ->
        Box {
          if (value.isBlank()) Text(placeholder, color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = .58f))
          inner()
        }
      },
    )
  }
}

@Composable
private fun TimeChoice(label: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
  Box(
    modifier.height(44.dp).clip(RoundedCornerShape(16.dp))
      .background(if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant)
      .clickable(onClick = onClick),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      label,
      color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
      fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium,
    )
  }
}

@Composable
private fun OutcomeChoice(label: String, onClick: () -> Unit) {
  Row(
    Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp))
      .background(MaterialTheme.colorScheme.surfaceVariant)
      .clickable(onClick = onClick).padding(17.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(label, Modifier.weight(1f), fontWeight = FontWeight.Medium)
    Icon(Icons.AutoMirrored.Rounded.ArrowForward, null, tint = MaterialTheme.colorScheme.primary)
  }
}

@Composable
private fun PermissionCard(
  usageAccess: Boolean,
  onPermission: () -> Unit,
  onRefresh: () -> Unit,
) {
  Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), shape = RoundedCornerShape(20.dp)) {
    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
      Text("Privacidad y permisos", fontWeight = FontWeight.SemiBold)
      Text("Relevo registra tiempo acumulado y eventos de esta prueba. No lee contenidos ni mensajes.", style = MaterialTheme.typography.bodySmall)
      if (!usageAccess) {
        SecondaryButton("Autorizar tiempo de uso", onPermission)
        InlineAction("Comprobar permiso", onRefresh, modifier = Modifier.align(Alignment.CenterHorizontally))
      } else Text("Acceso de uso autorizado", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelLarge)
    }
  }
}

@Composable
private fun ActiveScreen(reminder: Reminder, remaining: Int, onStop: () -> Unit) = Page {
  val progress by animateFloatAsState(
    targetValue = (reminder.observedUsageSeconds.toFloat() / reminder.requiredUsageSeconds.coerceAtLeast(1)).coerceIn(0f, 1f),
    animationSpec = spring(),
    label = "usage_progress",
  )
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Text("Relevo en espera", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
      Text(reminder.activity, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 41.sp)
      Box(Modifier.fillMaxWidth().height(215.dp).clip(RoundedCornerShape(32.dp)).background(Brush.linearGradient(listOf(RelevoTeal, Color(0xFF0C635A)))), contentAlignment = Alignment.Center) {
        Canvas(Modifier.fillMaxSize()) {
          drawCircle(Color.White.copy(alpha = .13f), radius = size.minDimension * .42f, center = Offset(size.width * .5f, size.height * .5f), style = Stroke(1.dp.toPx()))
        }
        CircularProgressIndicator(progress = { progress }, modifier = Modifier.size(148.dp), strokeWidth = 7.dp, color = Color.White, trackColor = Color.White.copy(alpha = .18f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Text(formatTime(reminder.observedUsageSeconds), style = MaterialTheme.typography.headlineMedium, color = Color.White, fontWeight = FontWeight.SemiBold)
          Text("de ${formatTime(reminder.requiredUsageSeconds)}", color = Color.White.copy(alpha = .75f))
        }
      }
      Row(verticalAlignment = Alignment.CenterVertically) { AppIcon(reminder.targetPackage); Spacer(Modifier.width(12.dp)); Text("El tiempo se suma en ${reminder.targetAppLabel}.", modifier = Modifier.weight(1f)) }
      Text("Faltan ${formatTime(remaining)}. Si sales de la app elegida, el conteo se pausa.", color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 21.sp)
      Summary("Ubicación de Relevo", reminder.place)
      Summary("Tu forma de empezar", reminder.howToStart)
    }
    SecondaryButton("Cancelar este relevo", onStop)
  }
}

@Composable
private fun SignalScreen(reminder: Reminder, onClose: () -> Unit) = Page {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Spacer(Modifier.height(4.dp))
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
      SignalGraphic()
      Text("Querías hacer esto.", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text(reminder.activity, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 42.sp)
      Summary("Para empezar", reminder.howToStart)
      Summary("Ubicación de Relevo", reminder.place)
    }
    PrimaryButton("Silenciar y continuar", onClose)
  }
}

@Composable
private fun DoneScreen(reminder: Reminder, onHome: (String) -> Unit) = Page {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Spacer(Modifier.height(4.dp))
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
      Text("¿Qué decidiste?", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
      Text("El relevo terminó después de ${formatTime(reminder.observedUsageSeconds)} en ${reminder.targetAppLabel}.", color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)
      listOf("started" to "Comencé la actividad", "later" to "La dejé para después", "changed" to "Cambié de idea").forEach { option ->
        OutcomeChoice(option.second) { onHome(option.first) }
      }
    }
    InlineAction("Omitir y volver al inicio", { onHome("not_answered") })
  }
}

@Composable
private fun AppPicker(apps: List<InstalledApp>, onDismiss: () -> Unit, onSelect: (InstalledApp) -> Unit) {
  var search by rememberSaveable { mutableStateOf("") }
  BackHandler(onBack = onDismiss)
  val visibleApps = remember(apps, search) { apps.filter { it.label.contains(search.trim(), ignoreCase = true) } }
  Page {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
      InlineAction("Volver", onDismiss)
      Text("Elige una aplicación", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
      Text("El conteo se aplicará únicamente a la aplicación que selecciones.", color = MaterialTheme.colorScheme.onSurfaceVariant)
      Row(
        Modifier.fillMaxWidth().height(56.dp).clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.surfaceVariant).padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Icon(Icons.Rounded.Search, null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.width(10.dp))
        BasicTextField(
          value = search,
          onValueChange = { search = it },
          singleLine = true,
          textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
          cursorBrush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.primary),
          modifier = Modifier.weight(1f),
          decorationBox = { inner -> Box { if (search.isBlank()) Text("Buscar app", color = MaterialTheme.colorScheme.onSurfaceVariant); inner() } },
        )
      }
      LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (visibleApps.isEmpty()) item { Text("No encontramos esa app en el teléfono.", color = MaterialTheme.colorScheme.onSurfaceVariant) }
        items(visibleApps) { app ->
          Row(
            Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.surfaceVariant)
              .clickable { onSelect(app) }.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            AppIcon(app.packageName)
            Spacer(Modifier.width(12.dp))
            Text(app.label, fontWeight = FontWeight.Medium)
          }
        }
      }
    }
  }
}

@Composable
private fun AppIcon(packageName: String) {
  val context = LocalContext.current
  val icon = androidx.compose.runtime.remember(packageName) {
    runCatching { context.packageManager.getApplicationIcon(packageName).toBitmap(96, 96).asImageBitmap() }.getOrNull()
  }
  if (icon != null) {
    Image(icon, contentDescription = null, modifier = Modifier.size(42.dp).clip(RoundedCornerShape(12.dp)))
  } else {
    Surface(Modifier.size(42.dp), RoundedCornerShape(12.dp), MaterialTheme.colorScheme.primaryContainer) {
      Icon(Icons.Rounded.Apps, null, Modifier.padding(9.dp), tint = MaterialTheme.colorScheme.primary)
    }
  }
}

@Composable
private fun SignalGraphic() {
  val animationsEnabled = rememberAnimationsEnabled()
  val transition = rememberInfiniteTransition(label = "signal_pulse")
  val pulse by transition.animateFloat(
    initialValue = 0.88f,
    targetValue = if (animationsEnabled) 1f else 0.88f,
    animationSpec = infiniteRepeatable(tween(850), RepeatMode.Reverse),
    label = "signal_scale",
  )
  Box(Modifier.fillMaxWidth().height(220.dp).clip(RoundedCornerShape(32.dp)).background(Color(0xFFFFEAE3)), contentAlignment = Alignment.Center) {
    Canvas(Modifier.fillMaxSize()) {
      val center = Offset(size.width * .5f, size.height * .5f)
      listOf(44f, 80f, 120f).forEach { radius ->
        drawCircle(RelevoCoral.copy(alpha = .38f), radius = radius.dp.toPx() * pulse, center = center, style = Stroke(width = 1.dp.toPx()))
      }
      drawCircle(RelevoCoral, radius = 17.dp.toPx(), center = center)
    }
  }
}

@Composable
private fun rememberAnimationsEnabled(): Boolean {
  val context = LocalContext.current
  return remember {
    Settings.Global.getFloat(context.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE, 1f) > 0f
  }
}

@Composable
private fun Summary(label: String, value: String) {
  Box(Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(Color.White).border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .12f), RoundedCornerShape(18.dp))) {
    Column(Modifier.padding(17.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
      Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text(value, style = MaterialTheme.typography.titleMedium)
    }
  }
}

@Composable
private fun PrimaryButton(label: String, onClick: () -> Unit, enabled: Boolean = true) {
  ActionButton(label, onClick, enabled, MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onPrimary)
}

@Composable
private fun ActionButton(
  label: String,
  onClick: () -> Unit,
  enabled: Boolean = true,
  background: Color,
  foreground: Color,
) {
  val interactions = remember { MutableInteractionSource() }
  val pressed by interactions.collectIsPressedAsState()
  val animationsEnabled = rememberAnimationsEnabled()
  val pressScale by animateFloatAsState(if (enabled && pressed && animationsEnabled) .975f else 1f, spring(), label = "action_press")
  Box(
    Modifier.fillMaxWidth().height(56.dp).scale(pressScale).clip(RoundedCornerShape(18.dp))
      .background(if (enabled) background else MaterialTheme.colorScheme.surfaceVariant)
      .clickable(interactionSource = interactions, indication = null, enabled = enabled, onClick = onClick),
    contentAlignment = Alignment.Center,
  ) {
    Text(label, color = if (enabled) foreground else MaterialTheme.colorScheme.onSurfaceVariant, fontWeight = FontWeight.SemiBold)
  }
}

@Composable
private fun SecondaryButton(label: String, onClick: () -> Unit) {
  Box(
    Modifier.fillMaxWidth().height(54.dp).clip(RoundedCornerShape(18.dp))
      .background(MaterialTheme.colorScheme.surfaceVariant)
      .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .12f), RoundedCornerShape(18.dp))
      .clickable(onClick = onClick),
    contentAlignment = Alignment.Center,
  ) { Text(label, fontWeight = FontWeight.SemiBold) }
}

@Composable
private fun InlineAction(label: String, onClick: () -> Unit, color: Color = MaterialTheme.colorScheme.primary, modifier: Modifier = Modifier) {
  Text(
    label,
    color = color,
    fontWeight = FontWeight.SemiBold,
    modifier = modifier.clip(RoundedCornerShape(12.dp)).clickable(onClick = onClick).padding(horizontal = 10.dp, vertical = 8.dp),
  )
}

private fun screenFor(status: ReminderStatus, current: Screen = Screen.HOME): Screen = when (status) {
  ReminderStatus.WAITING -> Screen.ACTIVE
  ReminderStatus.SIGNALLED -> Screen.SIGNAL
  ReminderStatus.SILENCED, ReminderStatus.CLOSED -> Screen.DONE
  else -> current
}

private fun formatTime(seconds: Int): String = when {
  seconds < 60 -> "$seconds s"
  seconds >= 3600 && seconds % 3600 == 0 -> "${seconds / 3600} h"
  seconds >= 3600 -> "${seconds / 3600} h ${(seconds % 3600) / 60} min"
  seconds % 60 == 0 -> "${seconds / 60} min"
  else -> "${seconds / 60} min ${seconds % 60} s"
}

private fun requestNotificationPermissionIfNeeded(context: android.content.Context) {
  if (
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
    ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
  ) {
    (context as? Activity)?.let { ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1001) }
  }
}

private fun hasNotificationPermission(context: android.content.Context): Boolean =
  Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
    ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
