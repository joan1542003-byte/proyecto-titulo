package com.example.relevo.ui

import android.provider.Settings
import android.Manifest
import android.app.Activity
import android.os.Build
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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.animation.AnimatedContent
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.FilterChip
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
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.data.HistoryEntry
import com.example.relevo.monitor.AppUsageSummary
import cl.udp.relevo.R

private enum class Screen { CONSENT, ONBOARDING, HOME, SETUP, ACTIVE, SIGNAL, DONE }

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
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
        !introduction.getBoolean("academic_consent_accepted", false) -> Screen.CONSENT
        !introduction.getBoolean("onboarding_complete", false) -> Screen.ONBOARDING
        else -> screenFor(reminder.status)
      },
    )
  }

  LaunchedEffect(reminder.status) { screen = screenFor(reminder.status, screen) }

  Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
    AnimatedContent(
      targetState = screen,
      transitionSpec = { (fadeIn(tween(420)) + slideInHorizontally(tween(520)) { it / 8 }) togetherWith (fadeOut(tween(260)) + slideOutHorizontally(tween(420)) { -it / 10 }) },
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
      Screen.ONBOARDING -> OnboardingScreen {
        introduction.edit().putBoolean("onboarding_complete", true).apply()
        screen = Screen.HOME
      }
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
  Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
    Surface(Modifier.size(12.dp), CircleShape, MaterialTheme.colorScheme.primary) {}
    Text("RELEVO", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
  }
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
  var tab by rememberSaveable { mutableStateOf(HomeTab.START) }
  LaunchedEffect(tab) { if (tab == HomeTab.ACTIVITY) onRefresh() }
  Column(Modifier.fillMaxSize().safeDrawingPadding()) {
    Row(Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 18.dp), verticalAlignment = Alignment.CenterVertically) {
      Brand()
    }
    AnimatedContent(
      targetState = tab,
      modifier = Modifier.weight(1f),
      transitionSpec = { fadeIn(tween(240)) togetherWith fadeOut(tween(180)) },
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
    modifier = Modifier.navigationBarsPadding().padding(horizontal = 18.dp, vertical = 10.dp).fillMaxWidth().border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = .12f), RoundedCornerShape(28.dp)),
    shape = RoundedCornerShape(28.dp),
    color = MaterialTheme.colorScheme.surface.copy(alpha = .97f),
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
          Modifier.weight(1f).clip(RoundedCornerShape(22.dp)).background(background).clickable { onSelect(tab) }.padding(vertical = 12.dp),
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Icon(icon, null, Modifier.size(20.dp), tint = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant)
          AnimatedContent(active, transitionSpec = { fadeIn(tween(240)) togetherWith fadeOut(tween(160)) }, label = "tab_label") { show ->
            if (show) { Spacer(Modifier.width(7.dp)); Text(label, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.SemiBold) }
          }
        }
      }
    }
  }
}

@Composable
private fun StartDashboard(history: List<HistoryEntry>, usage: List<AppUsageSummary>, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    Text("Vuelve a hacer presente una actividad que elegiste.", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Text("Configura cuándo avisarte y deja la señal cerca de donde puedes comenzar.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    AnimatedGradientAction(onStart)
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
      MetricCard("Tiempo vinculado", formatTime(usage.sumOf { it.seconds }), Icons.Rounded.Timer, Modifier.weight(1f))
      MetricCard("Relevos", history.size.toString(), Icons.Rounded.History, Modifier.weight(1f))
    }
    Card(shape = RoundedCornerShape(22.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), elevation = CardDefaults.cardElevation(0.dp)) {
      Row(Modifier.fillMaxWidth().padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
        Surface(Modifier.size(46.dp), CircleShape, MaterialTheme.colorScheme.primaryContainer) {
          Icon(Icons.Rounded.LocationOn, null, Modifier.padding(11.dp), tint = MaterialTheme.colorScheme.primary)
        }
        Spacer(Modifier.width(14.dp))
        Column { Text("Dónde está Relevo", fontWeight = FontWeight.SemiBold); Text(history.firstOrNull()?.place ?: "Sin ubicación activa", color = MaterialTheme.colorScheme.onSurfaceVariant) }
      }
    }
    if (history.isNotEmpty()) {
      Text("Último relevo", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
      HistoryCard(history.first())
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
  val endColor = lerp(Color(0xFF0B806F), Color(0xFF27A892), gradientShift)
  Surface(
    onClick = onClick,
    modifier = Modifier.fillMaxWidth().height(76.dp),
    shape = RoundedCornerShape(24.dp),
    color = Color.Transparent,
  ) {
    Row(
      Modifier.fillMaxSize().background(Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.primary, endColor))).padding(horizontal = 24.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Icon(Icons.Rounded.Add, null, tint = MaterialTheme.colorScheme.onPrimary)
      Spacer(Modifier.width(12.dp))
      Column { Text("Preparar un relevo", color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.SemiBold); Text("Actividad · aplicación · tiempo", color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .78f), style = MaterialTheme.typography.bodySmall) }
    }
  }
}

private data class OnboardingPage(val image: Int, val eyebrow: String, val title: String, val text: String)

@Composable
private fun ConsentScreen(onAccept: () -> Unit, onDecline: () -> Unit) {
  var checked by rememberSaveable { mutableStateOf(false) }
  Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFF075F54), Color(0xFF0A8573)))).safeDrawingPadding()) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
      BrandLight()
      Spacer(Modifier.height(34.dp))
      Text("Antes de comenzar", style = MaterialTheme.typography.displaySmall, color = Color.White, fontWeight = FontWeight.SemiBold)
      Text("Participación y uso académico de datos", style = MaterialTheme.typography.titleMedium, color = Color.White.copy(alpha = .76f))
      Spacer(Modifier.height(24.dp))
      Surface(Modifier.fillMaxWidth().weight(1f), RoundedCornerShape(30.dp), Color(0xFFF8FAF8)) {
        Column(Modifier.verticalScroll(rememberScrollState()).padding(24.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
          Text("Relevo es un prototipo de Proyecto de Título de Diseño de la Universidad Diego Portales. Los datos se utilizarán únicamente para evaluar su funcionamiento y la experiencia de uso.", lineHeight = 23.sp)
          ConsentPoint("Qué se registra", "Código seudónimo, actividad elegida, aplicación seleccionada, tiempo acumulado y momentos de activación, señal y cierre.")
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
      Button(
        onClick = onAccept,
        enabled = checked,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        shape = RoundedCornerShape(18.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8B72), contentColor = Color(0xFF321C17), disabledContainerColor = Color.White.copy(alpha = .12f), disabledContentColor = Color.White.copy(alpha = .38f)),
      ) { Text("Aceptar y continuar", fontWeight = FontWeight.SemiBold) }
      TextButton(onClick = onDecline, modifier = Modifier.align(Alignment.CenterHorizontally)) { Text("No participar", color = Color.White) }
    }
  }
}

@Composable
private fun BrandLight() {
  Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
    Surface(Modifier.size(12.dp), CircleShape, Color(0xFFFF8B72)) {}
    Text("RELEVO", style = MaterialTheme.typography.titleMedium, color = Color.White, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
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
private fun OnboardingScreen(onComplete: () -> Unit) {
  val pages = remember { listOf(
    OnboardingPage(R.drawable.onboarding_activity, "1 · ELIGE", "Define qué quieres retomar.", "Selecciona una actividad y escribe una forma sencilla de comenzar."),
    OnboardingPage(R.drawable.onboarding_condition, "2 · CONFIGURA", "Elige la aplicación y el tiempo.", "Relevo cuenta únicamente el uso acumulado de esa aplicación mientras la señal está activa."),
    OnboardingPage(R.drawable.onboarding_place, "3 · SITÚA", "Deja la señal cerca de la actividad.", "Pon el dispositivo junto a las zapatillas, el libro o aquello que facilite comenzar."),
    OnboardingPage(R.drawable.onboarding_signal, "4 · DECIDE", "Escucha la señal y elige qué hacer.", "Cuando se cumpla el tiempo recibirás el aviso. Relevo recuerda; la decisión sigue siendo tuya."),
  ) }
  var page by rememberSaveable { mutableStateOf(0) }
  val item = pages[page]
  Box(
    Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFFF8FBF9), Color(0xFFEAF8F4), Color(0xFFF7F8F6)))).safeDrawingPadding().padding(24.dp),
  ) {
    Column(Modifier.fillMaxSize()) {
      Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Brand(); Spacer(Modifier.weight(1f)); Text("${page + 1} / ${pages.size}", color = MaterialTheme.colorScheme.onSurfaceVariant)
      }
      Spacer(Modifier.height(22.dp))
      AnimatedContent(
        targetState = item,
        transitionSpec = { (fadeIn(tween(420)) + slideInHorizontally(tween(520)) { it / 4 }) togetherWith (fadeOut(tween(220)) + slideOutHorizontally(tween(380)) { -it / 5 }) },
        label = "onboarding_page",
      ) { current ->
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
          Image(
            painter = painterResource(current.image),
            contentDescription = current.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(250.dp).clip(RoundedCornerShape(30.dp)),
          )
          Text(current.eyebrow, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary, letterSpacing = 1.5.sp, fontWeight = FontWeight.SemiBold)
          Text(current.title, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold, lineHeight = 37.sp)
          Text(current.text, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 23.sp)
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
      PrimaryButton(if (page == pages.lastIndex) "Entrar a Relevo" else "Continuar", onClick = {
        if (page == pages.lastIndex) onComplete() else page += 1
      })
    }
  }
}

@Composable
private fun ActivityDashboard(usage: List<AppUsageSummary>, hasAccess: Boolean, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
    Text("Aplicaciones vinculadas", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Text("Solo se muestra el tiempo de las aplicaciones que elegiste para activar una señal.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    if (!hasAccess) Summary("Permiso pendiente", "Autorízalo al crear tu primer relevo.")
    else if (usage.isEmpty()) Summary("Sin datos vinculados", "Crea un relevo y elige una aplicación para comenzar a verla aquí.")
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
    }
    OutlinedButton(onClick = onStart, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(18.dp)) {
      Icon(Icons.Rounded.Add, null); Spacer(Modifier.width(8.dp)); Text("Nuevo relevo")
    }
  }
}

@Composable
private fun HistoryDashboard(history: List<HistoryEntry>, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
    Text("Tus relevos", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Text("Actividades elegidas y señales que preparaste.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    if (history.isEmpty()) Summary("Aún no hay relevos", "Cuando cierres uno aparecerá aquí.")
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
    }
    OutlinedButton(onClick = onStart, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(18.dp)) {
      Icon(Icons.Rounded.Add, null); Spacer(Modifier.width(8.dp)); Text("Crear relevo")
    }
  }
}

@Composable
private fun MetricCard(label: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector, modifier: Modifier = Modifier) {
  Card(modifier.animateContentSize(), shape = RoundedCornerShape(22.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), elevation = CardDefaults.cardElevation(0.dp)) {
    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
      Icon(icon, null, tint = MaterialTheme.colorScheme.primary)
      Text(value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
      Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
  }
}

@Composable
private fun AppUsageCard(item: AppUsageSummary, totalSeconds: Int) {
  Card(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), elevation = CardDefaults.cardElevation(0.dp)) {
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
  Card(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), elevation = CardDefaults.cardElevation(0.dp)) {
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
  onTest: () -> Unit,
  onActivate: () -> Unit,
) {
  var chooseApp by rememberSaveable { mutableStateOf(false) }
  if (chooseApp) AppPicker(apps, { chooseApp = false }) { onApp(it); chooseApp = false }

  Page {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
      Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        TextButton(onClick = onBack) { Text("Volver") }
        Spacer(Modifier.weight(1f)); Brand()
      }
      Text("Prepara tu señal", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
      Text("Todo se configura aquí. Después solo debes activar.", color = MaterialTheme.colorScheme.onSurfaceVariant)

      Text("Empieza con una idea", fontWeight = FontWeight.Medium)
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
      RelevoTextField("Dónde estará la señal", reminder.place, "Junto a las zapatillas", onPlace)

      Text("Aplicación que activa la señal", fontWeight = FontWeight.Medium)
      OutlinedButton(onClick = { chooseApp = true }, modifier = Modifier.fillMaxWidth().height(56.dp)) {
        if (reminder.targetPackage.isNotBlank()) {
          AppIcon(reminder.targetPackage); Spacer(Modifier.width(10.dp))
        } else Icon(Icons.Rounded.Apps, null)
        Text(reminder.targetAppLabel.ifBlank { "Elegir aplicación" }, modifier = Modifier.padding(start = 8.dp))
      }

      Card(
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(0.dp),
      ) {
        Column(Modifier.fillMaxWidth().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text("AVISARME AL ACUMULAR", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = .68f), letterSpacing = 1.2.sp)
          Text(formatTime(reminder.requiredUsageSeconds), style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
          Text("en ${reminder.targetAppLabel.ifBlank { "la aplicación elegida" }}", color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = .72f))
        }
      }
      Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf(15 to "Prueba", 300 to "5 min", 900 to "15 min").forEach { (seconds, label) ->
          if (reminder.requiredUsageSeconds == seconds) Button({ onDuration(seconds) }, Modifier.weight(1f)) { Text(label) }
          else OutlinedButton({ onDuration(seconds) }, Modifier.weight(1f)) { Text(label) }
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

      PermissionCard(usageAccess, onPermission, onRefresh)
      OutlinedButton(onClick = onTest, modifier = Modifier.fillMaxWidth()) { Text("Probar sonido") }
      PrimaryButton(
        "Activar relevo",
        onActivate,
        reminder.hasRequiredContent && usageAccess,
      )
      Spacer(Modifier.height(16.dp))
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
        OutlinedButton(onClick = onPermission, modifier = Modifier.fillMaxWidth()) { Text("Autorizar acceso de uso") }
        TextButton(onClick = onRefresh, modifier = Modifier.fillMaxWidth()) { Text("Comprobar permiso") }
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
    Brand()
    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
      Text("Relevo activo", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
      Text(reminder.activity, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
      Box(Modifier.fillMaxWidth().height(150.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(progress = { progress }, modifier = Modifier.size(132.dp), strokeWidth = 10.dp, trackColor = MaterialTheme.colorScheme.surfaceVariant)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          AppIcon(reminder.targetPackage)
          Text(formatTime(reminder.observedUsageSeconds), fontWeight = FontWeight.SemiBold)
        }
      }
      Text("Acumulados en ${reminder.targetAppLabel}", style = MaterialTheme.typography.titleMedium)
      Text("Faltan ${formatTime(remaining)}. Puedes salir y volver: el progreso se conserva.", color = MaterialTheme.colorScheme.onSurfaceVariant)
      Summary("La señal está", reminder.place)
      Summary("Para comenzar", reminder.howToStart)
    }
    OutlinedButton(onClick = onStop, modifier = Modifier.fillMaxWidth().height(54.dp)) { Text("Desactivar") }
  }
}

@Composable
private fun SignalScreen(reminder: Reminder, onClose: () -> Unit) = Page {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Brand()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
      SignalGraphic()
      Text("Es momento de elegir.", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
      Text(reminder.activity, style = MaterialTheme.typography.headlineMedium)
      Summary("Puedes empezar por", reminder.howToStart)
      Text("La señal está en ${reminder.place}.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    PrimaryButton("Silenciar", onClose)
  }
}

@Composable
private fun DoneScreen(reminder: Reminder, onHome: (String) -> Unit) = Page {
  var outcome by rememberSaveable { mutableStateOf<String?>(null) }
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Brand()
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
      Text("Relevo finalizado", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
      Text("Usaste ${formatTime(reminder.observedUsageSeconds)} de ${reminder.targetAppLabel}. Relevo no evalúa si realizaste la actividad.", color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text("¿Qué decidiste hacer?", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
      listOf("started" to "Comencé la actividad", "later" to "La dejé para después", "changed" to "Cambié de idea").forEach { option ->
        FilterChip(selected = outcome == option.first, onClick = { outcome = option.first }, label = { Text(option.second) }, modifier = Modifier.fillMaxWidth())
      }
      Text("Responder es opcional y ayuda a evaluar el sistema.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    PrimaryButton("Volver al inicio", { onHome(outcome ?: "not_answered") })
  }
}

@Composable
private fun AppPicker(apps: List<InstalledApp>, onDismiss: () -> Unit, onSelect: (InstalledApp) -> Unit) {
  AlertDialog(
    onDismissRequest = onDismiss,
    title = { Text("Elige una aplicación") },
    text = {
      LazyColumn(Modifier.heightIn(max = 460.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
        items(apps) { app ->
          Surface(
            shape = RoundedCornerShape(18.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth().clickable { onSelect(app) },
          ) {
            Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
              AppIcon(app.packageName); Spacer(Modifier.width(12.dp)); Text(app.label, fontWeight = FontWeight.Medium)
            }
          }
        }
      }
    },
    confirmButton = { TextButton(onClick = onDismiss) { Text("Cancelar") } },
  )
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
  Box(Modifier.fillMaxWidth().height(150.dp), contentAlignment = Alignment.Center) {
    Surface(Modifier.size(132.dp).scale(pulse), CircleShape, MaterialTheme.colorScheme.primaryContainer) {
      Box(contentAlignment = Alignment.Center) { Surface(Modifier.size(30.dp), CircleShape, MaterialTheme.colorScheme.primary) {} }
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
  Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
      Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text(value, style = MaterialTheme.typography.titleMedium)
    }
  }
}

@Composable
private fun PrimaryButton(label: String, onClick: () -> Unit, enabled: Boolean = true) {
  Button(onClick, Modifier.fillMaxWidth().height(56.dp), enabled, shape = RoundedCornerShape(18.dp), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)) { Text(label, fontWeight = FontWeight.SemiBold) }
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
