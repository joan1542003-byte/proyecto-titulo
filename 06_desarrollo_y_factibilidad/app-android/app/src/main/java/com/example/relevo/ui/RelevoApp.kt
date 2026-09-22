package com.example.relevo.ui

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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
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
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Slider
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
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

private enum class Screen { HOME, SETUP, ACTIVE, SIGNAL, DONE }

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
  val reminder by viewModel.reminder.collectAsState()
  val remaining by viewModel.remainingSeconds.collectAsState()
  val apps by viewModel.installedApps.collectAsState()
  val usageAccess by viewModel.usageAccessGranted.collectAsState()
  val history by viewModel.history.collectAsState()
  val todayUsage by viewModel.todayUsage.collectAsState()
  var screen by rememberSaveable { mutableStateOf(screenFor(reminder.status)) }

  LaunchedEffect(reminder.status) { screen = screenFor(reminder.status, screen) }

  Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
    AnimatedContent(targetState = screen, label = "main_navigation") { currentScreen ->
    when (currentScreen) {
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
        onConsent = viewModel::updateConsent,
        onPreset = viewModel::applyPreset,
        onPermission = viewModel::openUsageAccessSettings,
        onRefresh = viewModel::refreshUsageAccess,
        onTest = viewModel::testSignal,
        onActivate = { if (viewModel.activate()) screen = Screen.ACTIVE },
      )
      Screen.ACTIVE -> ActiveScreen(reminder, remaining) { viewModel.disarm(); screen = Screen.DONE }
      Screen.SIGNAL -> SignalScreen(reminder) { viewModel.silence(); screen = Screen.DONE }
      Screen.DONE -> DoneScreen(reminder) { viewModel.reset(); screen = Screen.HOME }
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
      Brand(); Spacer(Modifier.weight(1f))
      Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.primaryContainer) {
        Row(Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Rounded.CheckCircle, null, Modifier.size(18.dp), tint = MaterialTheme.colorScheme.primary)
          Spacer(Modifier.width(6.dp)); Text("Listo", style = MaterialTheme.typography.labelMedium)
        }
      }
    }
    AnimatedContent(targetState = tab, modifier = Modifier.weight(1f), label = "home_tabs") { selected ->
      when (selected) {
        HomeTab.START -> StartDashboard(history, usage, onStart)
        HomeTab.ACTIVITY -> ActivityDashboard(usage, usageAccess, onStart)
        HomeTab.HISTORY -> HistoryDashboard(history, onStart)
      }
    }
    NavigationBar(
      modifier = Modifier.navigationBarsPadding().padding(horizontal = 16.dp, vertical = 8.dp).clip(RoundedCornerShape(28.dp)),
      containerColor = MaterialTheme.colorScheme.surfaceVariant,
      tonalElevation = 0.dp,
    ) {
      NavigationBarItem(tab == HomeTab.START, { tab = HomeTab.START }, { Icon(Icons.Rounded.Home, null) }, label = { Text("Inicio") })
      NavigationBarItem(tab == HomeTab.ACTIVITY, { tab = HomeTab.ACTIVITY }, { Icon(Icons.Rounded.Insights, null) }, label = { Text("Actividad") })
      NavigationBarItem(tab == HomeTab.HISTORY, { tab = HomeTab.HISTORY }, { Icon(Icons.Rounded.History, null) }, label = { Text("Relevos") })
    }
  }
}

@Composable
private fun StartDashboard(history: List<HistoryEntry>, usage: List<AppUsageSummary>, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    Text("Hola.", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
    Text("¿Qué quieres retomar hoy?", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Image(
      painter = painterResource(R.drawable.relevo_tutorial),
      contentDescription = "Elegir una aplicación, situar la señal y recibir el aviso",
      contentScale = ContentScale.Crop,
      modifier = Modifier.fillMaxWidth().height(144.dp).clip(RoundedCornerShape(28.dp)),
    )
    Button(onClick = onStart, modifier = Modifier.fillMaxWidth().height(64.dp), shape = RoundedCornerShape(22.dp)) {
      Icon(Icons.Rounded.Add, null); Spacer(Modifier.width(8.dp)); Text("Crear un relevo", fontWeight = FontWeight.SemiBold)
    }
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
      MetricCard("Hoy en apps", formatTime(usage.sumOf { it.seconds }), Icons.Rounded.Timer, Modifier.weight(1f))
      MetricCard("Relevos", history.size.toString(), Icons.Rounded.History, Modifier.weight(1f))
    }
    Card(shape = RoundedCornerShape(22.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
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
private fun ActivityDashboard(usage: List<AppUsageSummary>, hasAccess: Boolean, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
    Text("Actividad de hoy", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Text("Tiempo en primer plano informado por Android.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    if (!hasAccess) Summary("Permiso pendiente", "Autorízalo al crear tu primer relevo.")
    else if (usage.isEmpty()) Summary("Sin actividad", "Todavía no hay aplicaciones con tiempo registrado hoy.")
    else usage.forEach { item -> AppUsageCard(item) }
    OutlinedButton(onClick = onStart, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(18.dp)) {
      Icon(Icons.Rounded.Add, null); Spacer(Modifier.width(8.dp)); Text("Nuevo relevo")
    }
  }
}

@Composable
private fun HistoryDashboard(history: List<HistoryEntry>, onStart: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
    Text("Tus relevos", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
    Text("Un registro breve de las señales que preparaste.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    if (history.isEmpty()) Summary("Aún no hay relevos", "Cuando cierres uno aparecerá aquí.")
    else history.forEach { HistoryCard(it) }
    OutlinedButton(onClick = onStart, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(18.dp)) {
      Icon(Icons.Rounded.Add, null); Spacer(Modifier.width(8.dp)); Text("Crear relevo")
    }
  }
}

@Composable
private fun MetricCard(label: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector, modifier: Modifier = Modifier) {
  Card(modifier.animateContentSize(), shape = RoundedCornerShape(22.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
      Icon(icon, null, tint = MaterialTheme.colorScheme.primary)
      Text(value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
      Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
  }
}

@Composable
private fun AppUsageCard(item: AppUsageSummary) {
  Card(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
    Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
      AppIcon(item.packageName); Spacer(Modifier.width(14.dp))
      Column(Modifier.weight(1f)) { Text(item.label, fontWeight = FontWeight.Medium); Text(formatTime(item.seconds), color = MaterialTheme.colorScheme.onSurfaceVariant) }
    }
  }
}

@Composable
private fun HistoryCard(entry: HistoryEntry) {
  Card(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
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
  onConsent: (Boolean) -> Unit,
  onPreset: (String, String, String) -> Unit,
  onPermission: () -> Unit,
  onRefresh: () -> Unit,
  onTest: () -> Unit,
  onActivate: () -> Unit,
) {
  var chooseApp by rememberSaveable { mutableStateOf(false) }
  var showTerms by rememberSaveable { mutableStateOf(false) }
  if (chooseApp) AppPicker(apps, { chooseApp = false }) { onApp(it); chooseApp = false }
  if (showTerms) TermsDialog({ showTerms = false }) { onConsent(true); showTerms = false }

  Page {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
      Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        TextButton(onClick = onBack) { Text("Volver") }
        Spacer(Modifier.weight(1f)); Brand()
      }
      Text("Prepara tu señal", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
      Text("Todo se configura aquí. Después solo debes activar.", color = MaterialTheme.colorScheme.onSurfaceVariant)

      Text("Empieza con una idea", fontWeight = FontWeight.Medium)
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf(
          Triple("Caminar", "Ponerme las zapatillas", "Junto a las zapatillas"),
          Triple("Entrenar", "Preparar una serie", "Junto a las pesas"),
          Triple("Leer", "Abrir el libro", "Junto al libro"),
        ).forEach { preset ->
          FilterChip(
            selected = reminder.activity == preset.first,
            onClick = { onPreset(preset.first, preset.second, preset.third) },
            label = { Text(preset.first) },
            modifier = Modifier.weight(1f),
          )
        }
      }

      OutlinedTextField(reminder.activity, onActivity, label = { Text("Qué quieres hacer") }, placeholder = { Text("Salir a caminar") }, modifier = Modifier.fillMaxWidth(), singleLine = true, shape = RoundedCornerShape(18.dp))
      OutlinedTextField(reminder.howToStart, onStart, label = { Text("Cómo puedes empezar") }, placeholder = { Text("Ponerme las zapatillas") }, modifier = Modifier.fillMaxWidth(), singleLine = true, shape = RoundedCornerShape(18.dp))
      OutlinedTextField(reminder.place, onPlace, label = { Text("Dónde estará la señal") }, placeholder = { Text("Junto a las zapatillas") }, modifier = Modifier.fillMaxWidth(), singleLine = true, shape = RoundedCornerShape(18.dp))

      Text("Aplicación que activa la señal", fontWeight = FontWeight.Medium)
      OutlinedButton(onClick = { chooseApp = true }, modifier = Modifier.fillMaxWidth().height(56.dp)) {
        if (reminder.targetPackage.isNotBlank()) {
          AppIcon(reminder.targetPackage); Spacer(Modifier.width(10.dp))
        } else Icon(Icons.Rounded.Apps, null)
        Text(reminder.targetAppLabel.ifBlank { "Elegir aplicación" }, modifier = Modifier.padding(start = 8.dp))
      }

      Text("Avisarme al acumular ${formatTime(reminder.requiredUsageSeconds)}", fontWeight = FontWeight.Medium)
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
        steps = 58,
        modifier = Modifier.fillMaxWidth(),
      )
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("1 min", style = MaterialTheme.typography.labelSmall)
        Text("60 min", style = MaterialTheme.typography.labelSmall)
      }

      PermissionCard(usageAccess, reminder.consentAccepted, { showTerms = true }, onPermission, onRefresh)
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
private fun PermissionCard(
  usageAccess: Boolean,
  consent: Boolean,
  onTerms: () -> Unit,
  onPermission: () -> Unit,
  onRefresh: () -> Unit,
) {
  Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), shape = RoundedCornerShape(20.dp)) {
    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
      Text("Privacidad y permisos", fontWeight = FontWeight.SemiBold)
      Text("Relevo registra tiempo acumulado y eventos de esta prueba. No lee contenidos ni mensajes.", style = MaterialTheme.typography.bodySmall)
      TextButton(onClick = onTerms) { Text(if (consent) "Términos aceptados · Leer" else "Leer y aceptar términos") }
      if (!consent) {
        Text("Lee y acepta los términos antes de autorizar el acceso.", style = MaterialTheme.typography.bodySmall)
      } else if (!usageAccess) {
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
private fun DoneScreen(reminder: Reminder, onNew: () -> Unit) = Page {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Brand()
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
      Text("Relevo finalizado", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
      Text("Usaste ${formatTime(reminder.observedUsageSeconds)} de ${reminder.targetAppLabel}. Relevo no evalúa si realizaste la actividad.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    PrimaryButton("Crear otro relevo", onNew)
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
private fun TermsDialog(onDismiss: () -> Unit, onAccept: () -> Unit) {
  AlertDialog(
    onDismissRequest = onDismiss,
    title = { Text("Uso de datos en la prueba") },
    text = {
      Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Relevo guardará en este teléfono un código anónimo, la aplicación elegida, el tiempo acumulado y los momentos de activación, entrada, salida, señal y cierre.")
        Text("No registra mensajes, imágenes, búsquedas, teclas ni contenido de pantalla. Los datos se usan para evaluar el funcionamiento del proyecto y puedes detener el registro al desactivar el relevo.")
        Text("La sincronización remota solo se habilitará cuando exista una base protegida, un responsable y un procedimiento de eliminación.")
      }
    },
    confirmButton = { Button(onClick = onAccept) { Text("Entiendo y acepto") } },
    dismissButton = { TextButton(onClick = onDismiss) { Text("Cancelar") } },
  )
}

@Composable
private fun SignalGraphic() {
  val transition = rememberInfiniteTransition(label = "signal_pulse")
  val pulse by transition.animateFloat(
    initialValue = 0.88f,
    targetValue = 1f,
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
