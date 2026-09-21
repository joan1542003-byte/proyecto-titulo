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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.monitor.InstalledApp

private enum class Screen { HOME, SETUP, ACTIVE, SIGNAL, DONE }

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
  val reminder by viewModel.reminder.collectAsState()
  val remaining by viewModel.remainingSeconds.collectAsState()
  val apps by viewModel.installedApps.collectAsState()
  val usageAccess by viewModel.usageAccessGranted.collectAsState()
  var screen by rememberSaveable { mutableStateOf(screenFor(reminder.status)) }

  LaunchedEffect(reminder.status) { screen = screenFor(reminder.status, screen) }

  Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
    when (screen) {
      Screen.HOME -> HomeScreen { screen = Screen.SETUP }
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

@Composable
private fun HomeScreen(onStart: () -> Unit) = Page {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Brand()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
      SignalGraphic()
      Text("Vuelve a lo que querías hacer.", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
      Text(
        "Elige una aplicación. Cuando acumules el tiempo definido, Relevo emitirá una señal cerca de aquello que te ayuda a comenzar.",
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
    PrimaryButton("Crear un relevo", onStart)
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

      OutlinedTextField(reminder.activity, onActivity, label = { Text("Qué quieres hacer") }, placeholder = { Text("Salir a caminar") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
      OutlinedTextField(reminder.howToStart, onStart, label = { Text("Cómo puedes empezar") }, placeholder = { Text("Ponerme las zapatillas") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
      OutlinedTextField(reminder.place, onPlace, label = { Text("Dónde estará la señal") }, placeholder = { Text("Junto a las zapatillas") }, modifier = Modifier.fillMaxWidth(), singleLine = true)

      Text("Aplicación que activa la señal", fontWeight = FontWeight.Medium)
      OutlinedButton(onClick = { chooseApp = true }, modifier = Modifier.fillMaxWidth().height(56.dp)) {
        Text(reminder.targetAppLabel.ifBlank { "Elegir aplicación" })
      }

      Text("Avisarme al acumular", fontWeight = FontWeight.Medium)
      Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf(15 to "15 s", 60 to "1 min", 300 to "5 min").forEach { (seconds, label) ->
          if (reminder.requiredUsageSeconds == seconds) Button({ onDuration(seconds) }, Modifier.weight(1f)) { Text(label) }
          else OutlinedButton({ onDuration(seconds) }, Modifier.weight(1f)) { Text(label) }
        }
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
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    Brand()
    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
      Text("Relevo activo", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
      Text(reminder.activity, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.SemiBold)
      Text("${formatTime(reminder.observedUsageSeconds)} acumulados en ${reminder.targetAppLabel}", style = MaterialTheme.typography.titleMedium)
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
    text = { LazyColumn(Modifier.heightIn(max = 420.dp)) { items(apps) { app -> TextButton(onClick = { onSelect(app) }, modifier = Modifier.fillMaxWidth()) { Text(app.label, modifier = Modifier.fillMaxWidth()) } } } },
    confirmButton = { TextButton(onClick = onDismiss) { Text("Cancelar") } },
  )
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
  Box(Modifier.fillMaxWidth().height(150.dp), contentAlignment = Alignment.Center) {
    Surface(Modifier.size(132.dp), CircleShape, MaterialTheme.colorScheme.primaryContainer) {
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
