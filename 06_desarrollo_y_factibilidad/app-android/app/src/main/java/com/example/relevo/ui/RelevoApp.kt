package com.example.relevo.ui

import android.provider.Settings
import android.Manifest
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Insights
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.NotificationsActive
import androidx.compose.material.icons.rounded.Timer
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.monitor.AppUsageSummary
import cl.udp.relevo.R
import com.example.relevo.theme.RelevoCoral
import com.example.relevo.theme.RelevoGraphite
import com.example.relevo.theme.RelevoTeal

private enum class Screen { CONSENT, ONBOARDING, HOME, SETUP, ACTIVE, SIGNAL, DONE }

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
  val animationsEnabled = rememberAnimationsEnabled()
  val reminder by viewModel.reminder.collectAsState()
  val remaining by viewModel.remainingSeconds.collectAsState()
  val apps by viewModel.installedApps.collectAsState()
  val usageAccess by viewModel.usageAccessGranted.collectAsState()
  val history by viewModel.history.collectAsState()
  val todayUsage by viewModel.todayUsage.collectAsState()
  val context = LocalContext.current
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
        onComplete = {
          introduction.edit().putBoolean("onboarding_complete", true).apply()
          screen = Screen.HOME
        },
      )
      Screen.HOME -> HomeScreen(history, todayUsage, usageAccess, viewModel::refreshDashboard) { screen = Screen.SETUP }
      Screen.SETUP -> SetupScreen(
        reminder = reminder,
        apps = apps,
        usageAccess = usageAccess,
        onBack = { screen = Screen.HOME },
        onActivity = viewModel::updateActivity,
        onStart = viewModel::updateHowToStart,
        onPlace = viewModel::updatePlace,
        onApp = viewModel::selectTargetApp,
        onDuration = viewModel::updateRequiredUsage,
        onPreset = viewModel::applyPreset,
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
      Screen.DONE -> DoneScreen(reminder) { outcome -> viewModel.completeEvaluation(outcome); viewModel.reset(); screen = Screen.HOME }
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

private enum class HomeTab { START, ACTIVITY, HISTORY }

@Composable
private fun HomeScreen(
  history: List<HistoryEntry>,
  usage: List<AppUsageSummary>,
  usageAccess: Boolean,
  onRefresh: () -> Unit,
  onStart: () -> Unit,
) {
  val animationsEnabled = rememberAnimationsEnabled()
  var tab by rememberSaveable { mutableStateOf(HomeTab.START) }
  LaunchedEffect(tab) { if (tab == HomeTab.ACTIVITY) onRefresh() }
  Column(Modifier.fillMaxSize().safeDrawingPadding()) {
    Row(Modifier.fillMaxWidth().padding(horizontal = 26.dp, vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
      Text("relevo", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, letterSpacing = (-.7).sp)
      Spacer(Modifier.weight(1f))
      Text("Tu espacio", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    AnimatedContent(
      targetState = tab,
      modifier = Modifier.weight(1f),
      transitionSpec = { if (animationsEnabled) fadeIn(tween(220)) togetherWith fadeOut(tween(160)) else EnterTransition.None togetherWith ExitTransition.None },
      label = "home_tabs",
    ) { selected ->
      when (selected) {
        HomeTab.START -> StartDashboard(history, usage, onStart)
        HomeTab.ACTIVITY -> ActivityDashboard(usage, usageAccess, onStart)
        HomeTab.HISTORY -> HistoryDashboard(history, onStart)
      }
    }
    FloatingTabBar(tab) { tab = it }
  }
}

@Composable
private fun FloatingTabBar(selected: HomeTab, onSelect: (HomeTab) -> Unit) {
  val items = listOf(
    Triple(HomeTab.START, Icons.Rounded.Home, "Inicio"),
    Triple(HomeTab.ACTIVITY, Icons.Rounded.Insights, "Actividad"),
    Triple(HomeTab.HISTORY, Icons.Rounded.History, "Relevos"),
  )
  Surface(
    modifier = Modifier.navigationBarsPadding().padding(horizontal = 20.dp, vertical = 10.dp).fillMaxWidth().border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .12f), RoundedCornerShape(30.dp)),
    shape = RoundedCornerShape(30.dp),
    color = MaterialTheme.colorScheme.surface,
  ) {
    Row(Modifier.padding(6.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
      items.forEach { (tab, icon, label) ->
        val active = tab == selected
        val background by androidx.compose.animation.animateColorAsState(
          if (active) MaterialTheme.colorScheme.primaryContainer else Color.Transparent,
          animationSpec = tween(320),
          label = "tab_background",
        )
        Row(
          Modifier.weight(1f).height(48.dp).clip(RoundedCornerShape(24.dp)).background(background).clickable { onSelect(tab) },
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Icon(icon, null, Modifier.size(19.dp), tint = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant)
          Spacer(Modifier.width(5.dp))
          Text(label, style = MaterialTheme.typography.labelSmall, fontWeight = if (active) FontWeight.SemiBold else FontWeight.Medium, color = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant)
        }
      }
    }
  }
}

@Composable
private fun StartDashboard(history: List<HistoryEntry>, usage: List<AppUsageSummary>, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 26.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    Spacer(Modifier.height(4.dp))
    Text("Lo que quieres hacer,\nmás cerca.", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 42.sp, letterSpacing = (-1).sp)
    Text("Elige una actividad. Relevo te avisará cuando se cumpla el tiempo que decidas pasar en otra app.", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 23.sp)
    AnimatedGradientAction(onStart)
    Row(Modifier.fillMaxWidth().padding(vertical = 2.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
      MetricCard("Hoy en apps elegidas", formatTime(usage.sumOf { it.seconds }), Icons.Rounded.Timer, Modifier.weight(1f))
      MetricCard("Relevos cerrados", history.size.toString(), Icons.Rounded.History, Modifier.weight(1f))
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
    modifier = Modifier.fillMaxWidth().height(210.dp),
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
        Text("UNA IDEA PARA HOY", color = Color.White.copy(alpha = .8f), style = MaterialTheme.typography.labelSmall, letterSpacing = 1.5.sp)
        Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
          Text("Prepara tu\nrelevo", color = Color.White, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold, lineHeight = 34.sp)
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Elegir actividad", color = Color.White.copy(alpha = .9f), fontWeight = FontWeight.Medium)
            Spacer(Modifier.width(8.dp))
            Text("→", color = Color.White, style = MaterialTheme.typography.titleLarge)
          }
        }
      }
    }
  }
}

private data class OnboardingPage(val image: Int, val title: String, val text: String, val permissions: Boolean = false)

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
          Text("Relevo es un prototipo de Proyecto de Título de Diseño de la Universidad Diego Portales. Los datos se utilizarán únicamente para evaluar su funcionamiento y la experiencia de uso.", lineHeight = 23.sp)
          ConsentPoint("Qué se registra", "La aplicación crea un identificador aleatorio para agrupar tus datos sin pedir tu nombre, correo ni teléfono. También guarda la actividad elegida, la aplicación seleccionada, el tiempo acumulado y los momentos de activación, aviso y cierre.")
          ConsentPoint("Qué no se registra", "Mensajes, imágenes, búsquedas, pulsaciones ni contenido de pantalla.")
          ConsentPoint("Cómo se protege", "Los registros se guardan primero en el teléfono y se envían a una base protegida. Cada instalación solo puede acceder a sus propias sesiones.")
          ConsentPoint("Tu decisión", "Participar es voluntario. Puedes detener un relevo en cualquier momento. Si no aceptas, la aplicación se cerrará y no recopilará datos.")
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
  onComplete: () -> Unit,
) {
  val animationsEnabled = rememberAnimationsEnabled()
  val context = LocalContext.current
  var notificationAccess by remember { mutableStateOf(hasNotificationPermission(context)) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
    onRefreshUsage()
    notificationAccess = hasNotificationPermission(context)
  }
  val pages = remember { listOf(
    OnboardingPage(R.drawable.onboarding_activity, "Elige una actividad", "Escribe qué quieres hacer y una acción sencilla con la que puedas comenzar."),
    OnboardingPage(R.drawable.onboarding_condition, "Define cuándo avisarte", "Elige una aplicación y un tiempo. El conteo funciona solo mientras el relevo está activo."),
    OnboardingPage(R.drawable.onboarding_place, "Ubica el dispositivo", "Déjalo cerca de aquello que necesitas para comenzar: tus zapatillas, un libro o tus materiales."),
    OnboardingPage(R.drawable.onboarding_signal, "Recibe el aviso", "Al cumplirse el tiempo, Relevo reproduce un sonido en el parlante Bluetooth conectado. Tú decides qué hacer después."),
    OnboardingPage(R.drawable.onboarding_permissions, "Activa los permisos necesarios", "Relevo necesita ver cuánto tiempo usas la aplicación elegida y enviarte el aviso. No puede leer lo que haces dentro de ella.", permissions = true),
  ) }
  var page by rememberSaveable { mutableStateOf(0) }
  val item = pages[page]
  Box(
    Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFFF8FBF9), Color(0xFFEAF8F4), Color(0xFFF7F8F6)))).safeDrawingPadding().padding(24.dp),
  ) {
    Column(Modifier.fillMaxSize()) {
      Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("Cómo funciona", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.weight(1f)); Text("${page + 1} de ${pages.size}", color = MaterialTheme.colorScheme.onSurfaceVariant)
      }
      Spacer(Modifier.height(22.dp))
      AnimatedContent(
        targetState = item,
        transitionSpec = {
          if (animationsEnabled) (fadeIn(tween(350)) + slideInHorizontally(tween(400)) { it / 6 }) togetherWith (fadeOut(tween(180)) + slideOutHorizontally(tween(300)) { -it / 7 })
          else EnterTransition.None togetherWith ExitTransition.None
        },
        label = "onboarding_page",
      ) { current ->
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
          Image(
            painter = painterResource(current.image),
            contentDescription = current.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(if (current.permissions) 210.dp else 250.dp).clip(RoundedCornerShape(30.dp)),
          )
          Text(current.title, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold, lineHeight = 37.sp)
          Text(current.text, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 23.sp)
          if (current.permissions) {
            PermissionRow("Tiempo de uso", "Permite medir solo la aplicación que elijas.", usageAccess) { onUsagePermission() }
            PermissionRow("Notificaciones", "Muestran el aviso aunque otra aplicación esté abierta. Puedes continuar sin activarlas.", notificationAccess) {
              requestNotificationPermissionIfNeeded(context)
            }
          }
        }
      }
      Spacer(Modifier.weight(1f))
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
        pages.indices.forEach { index ->
          val width by androidx.compose.animation.core.animateDpAsState(if (index == page) 28.dp else 7.dp, tween(320), label = "page_indicator")
          Box(Modifier.width(width).height(7.dp).clip(CircleShape).background(if (index == page) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = .22f)))
        }
      }
      Spacer(Modifier.height(24.dp))
      PrimaryButton(
        if (page == pages.lastIndex) "Comenzar" else "Continuar",
        onClick = { if (page == pages.lastIndex) onComplete() else page += 1 },
        enabled = page != pages.lastIndex || usageAccess,
      )
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
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
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
private fun HistoryDashboard(history: List<HistoryEntry>, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
    Text("Tus relevos.", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 42.sp)
    Text("Tus actividades y el tiempo que dedicaste a las apps elegidas.", color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)
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
  Box(modifier.animateContentSize().clip(RoundedCornerShape(22.dp)).background(Color.White).border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .1f), RoundedCornerShape(22.dp))) {
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
      Column(Modifier.weight(1f)) { Text(entry.activity, fontWeight = FontWeight.SemiBold); Text("${entry.appLabel} · ${formatTime(entry.seconds)}", color = MaterialTheme.colorScheme.onSurfaceVariant) }
      Icon(Icons.Rounded.CheckCircle, null, tint = MaterialTheme.colorScheme.primary)
    }
  }
}

@Composable
private fun SetupScreen(
  reminder: Reminder,
  apps: List<InstalledApp>,
  usageAccess: Boolean,
  onBack: () -> Unit,
  onActivity: (String) -> Unit,
  onStart: (String) -> Unit,
  onPlace: (String) -> Unit,
  onApp: (InstalledApp) -> Unit,
  onDuration: (Int) -> Unit,
  onPreset: (String, String, String) -> Unit,
  onPermission: () -> Unit,
  onRefresh: () -> Unit,
  onTest: () -> Boolean,
  onActivate: () -> Unit,
) {
  var chooseApp by rememberSaveable { mutableStateOf(false) }
  var testMessage by rememberSaveable { mutableStateOf<String?>(null) }
  if (chooseApp) {
    AppPicker(apps, { chooseApp = false }) { onApp(it); chooseApp = false }
    return
  }

  Page {
    Column(Modifier.fillMaxSize()) {
    Column(Modifier.weight(1f).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
      Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        InlineAction("Volver", onBack)
      }
      Text("Prepara lo que\nquieres hacer.", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold, lineHeight = 42.sp)
      Text("Parte por algo concreto. Podrás cambiarlo antes de activar el aviso.", color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)

      Spacer(Modifier.height(6.dp))
      Text("Puedes partir por aquí", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
      LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(listOf(
          Triple("Caminar", "Ponerme las zapatillas", "Junto a las zapatillas"),
          Triple("Entrenar", "Preparar una serie", "Junto a las pesas"),
          Triple("Leer", "Abrir el libro", "Junto al libro"),
          Triple("Estudiar", "Abrir mis apuntes", "Junto al escritorio"),
          Triple("Dibujar", "Preparar el cuaderno", "Junto a mis materiales"),
          Triple("Cocinar", "Reunir los ingredientes", "En la cocina"),
          Triple("Ordenar", "Despejar una superficie", "En el espacio que quiero ordenar"),
        )) { preset ->
          PresetChip(preset.first, reminder.activity == preset.first) { onPreset(preset.first, preset.second, preset.third) }
        }
      }

      RelevoTextField("Qué quieres hacer", reminder.activity, "Salir a caminar", onActivity)
      RelevoTextField("Cómo puedes empezar", reminder.howToStart, "Ponerme las zapatillas", onStart)
      RelevoTextField("Dónde pondrás el parlante", reminder.place, "Junto a las zapatillas", onPlace)

      Spacer(Modifier.height(9.dp))
      Text("¿Cuándo necesitas el aviso?", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
      Text("El tiempo se suma solo mientras uses la app elegida.", color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text("Aplicación", fontWeight = FontWeight.Medium)
      Row(
        Modifier.fillMaxWidth().height(60.dp).clip(RoundedCornerShape(20.dp))
          .background(MaterialTheme.colorScheme.surfaceVariant).clickable { chooseApp = true }.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        if (reminder.targetPackage.isNotBlank()) {
          AppIcon(reminder.targetPackage); Spacer(Modifier.width(10.dp))
        } else Icon(Icons.Rounded.Apps, null)
        Text(reminder.targetAppLabel.ifBlank { "Elegir aplicación" }, modifier = Modifier.padding(start = 8.dp).weight(1f))
        Text(if (reminder.targetPackage.isBlank()) "Elegir" else "Cambiar", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelLarge)
      }

      Card(
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(0.dp),
      ) {
        Column(Modifier.fillMaxWidth().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text("Avísame después de", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = .72f))
          Text(formatTime(reminder.requiredUsageSeconds), style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
          Text("en ${reminder.targetAppLabel.ifBlank { "la aplicación elegida" }}", color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = .72f))
        }
      }
      Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf(15 to "Prueba", 300 to "5 min", 900 to "15 min").forEach { (seconds, label) ->
          TimeChoice(label, reminder.requiredUsageSeconds == seconds, Modifier.weight(1f)) { onDuration(seconds) }
        }
      }
      Slider(
        value = (reminder.requiredUsageSeconds.coerceAtLeast(60) / 60f),
        onValueChange = { onDuration((it.toInt().coerceAtLeast(1)) * 60) },
        valueRange = 1f..60f,
        steps = 0,
        colors = SliderDefaults.colors(
          thumbColor = MaterialTheme.colorScheme.primary,
          activeTrackColor = MaterialTheme.colorScheme.primary,
          inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.fillMaxWidth(),
      )
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("1 min", style = MaterialTheme.typography.labelSmall)
        Text("60 min", style = MaterialTheme.typography.labelSmall)
      }

      if (!usageAccess) PermissionCard(usageAccess, onPermission, onRefresh)
      Text("El sonido sale por un parlante Bluetooth conectado. Si no lo hay, Relevo mostrará un aviso sin hacer sonar el teléfono.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 20.sp)
      SecondaryButton("Probar parlante", { testMessage = if (onTest()) "Sonará durante unos segundos." else "No se encontró un parlante Bluetooth conectado." })
      if (testMessage != null) Text(testMessage.orEmpty(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodySmall)
      Spacer(Modifier.height(16.dp))
    }
    Column(Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background).padding(top = 10.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
      val pending = when {
        reminder.activity.isBlank() || reminder.howToStart.isBlank() -> "Elige una actividad y cómo empezar."
        reminder.place.isBlank() -> "Indica dónde dejarás el parlante."
        reminder.targetPackage.isBlank() -> "Elige la app que activará la señal."
        !usageAccess -> "Autoriza Tiempo de uso para continuar."
        else -> null
      }
      if (pending != null) Text(pending, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
      PrimaryButton("Activar relevo", onActivate, reminder.hasRequiredContent && usageAccess)
    }
    }
  }
}

@Composable
private fun PresetChip(label: String, selected: Boolean, onClick: () -> Unit) {
  val color by androidx.compose.animation.animateColorAsState(
    if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
    tween(240),
    label = "preset_color",
  )
  Surface(onClick = onClick, color = color, shape = RoundedCornerShape(18.dp)) {
    Text(
      label,
      modifier = Modifier.padding(horizontal = 16.dp, vertical = 11.dp),
      color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
      fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
    )
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
private fun OutcomeChoice(label: String, selected: Boolean, onClick: () -> Unit) {
  Row(
    Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp))
      .background(if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant)
      .border(1.dp, if (selected) MaterialTheme.colorScheme.primary.copy(alpha = .28f) else Color.Transparent, RoundedCornerShape(20.dp))
      .clickable(onClick = onClick).padding(17.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(label, Modifier.weight(1f), fontWeight = FontWeight.Medium)
    if (selected) Icon(Icons.Rounded.CheckCircle, null, tint = MaterialTheme.colorScheme.primary)
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
      Summary("Parlante ubicado en", reminder.place)
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
      Text("Dejaste el parlante en ${reminder.place}.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    PrimaryButton("Silenciar y continuar", onClose)
  }
}

@Composable
private fun DoneScreen(reminder: Reminder, onHome: (String) -> Unit) = Page {
  var outcome by rememberSaveable { mutableStateOf<String?>(null) }
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Spacer(Modifier.height(4.dp))
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
      Text("¿Qué decidiste?", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
      Text("El relevo terminó después de ${formatTime(reminder.observedUsageSeconds)} en ${reminder.targetAppLabel}.", color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)
      Text("Tu respuesta ayuda a entender si la señal resultó útil. No hay una respuesta correcta.", style = MaterialTheme.typography.bodyMedium)
      listOf("started" to "Comencé la actividad", "later" to "La dejé para después", "changed" to "Cambié de idea").forEach { option ->
        OutcomeChoice(option.second, outcome == option.first) { outcome = option.first }
      }
      Text("Responder es opcional.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    PrimaryButton("Volver al inicio", { onHome(outcome ?: "not_answered") })
  }
}

@Composable
private fun AppPicker(apps: List<InstalledApp>, onDismiss: () -> Unit, onSelect: (InstalledApp) -> Unit) {
  Page {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
      InlineAction("Volver", onDismiss)
      Text("Elige una aplicación", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
      Text("El conteo se aplicará únicamente a la aplicación que selecciones.", color = MaterialTheme.colorScheme.onSurfaceVariant)
      LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(apps) { app ->
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
  Box(
    Modifier.fillMaxWidth().height(56.dp).clip(RoundedCornerShape(18.dp))
      .background(if (enabled) background else MaterialTheme.colorScheme.surfaceVariant)
      .clickable(enabled = enabled, onClick = onClick),
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
