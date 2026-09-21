package com.example.relevo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

private enum class RelevoStep {
  FORMULATE,
  CONFIGURE,
  REVIEW,
  SITUATE,
  TEST,
  ARM,
  WAIT,
  SIGNAL,
  CLOSE,
}

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
  val reminder by viewModel.reminder.collectAsState()
  val remainingSeconds by viewModel.remainingSeconds.collectAsState()
  var step by rememberSaveable { mutableStateOf(initialStep(reminder.status)) }
  var showMissingData by rememberSaveable { mutableStateOf(false) }
  var signalWasPerceived by rememberSaveable { mutableStateOf<Boolean?>(null) }

  LaunchedEffect(reminder.status) {
    step =
      when (reminder.status) {
        ReminderStatus.WAITING -> RelevoStep.WAIT
        ReminderStatus.SIGNALLED -> RelevoStep.SIGNAL
        ReminderStatus.SILENCED -> RelevoStep.CLOSE
        else -> step
      }
  }

  RelevoScaffold(step = step, onBack = { step = previousStep(step) }) {
    when (step) {
      RelevoStep.FORMULATE ->
        FormulateScreen(
          reminder,
          viewModel::updateActivity,
          viewModel::updateHowToStart,
        ) { step = RelevoStep.CONFIGURE }
      RelevoStep.CONFIGURE ->
        ConfigureScreen(reminder, viewModel::updateDelay) { step = RelevoStep.REVIEW }
      RelevoStep.REVIEW ->
        ReviewScreen(
          reminder = reminder,
          showMissingData = showMissingData,
          onEdit = { step = RelevoStep.FORMULATE },
          onContinue = {
            showMissingData = !viewModel.markReady()
            if (!showMissingData) step = RelevoStep.SITUATE
          },
        )
      RelevoStep.SITUATE ->
        SituateScreen(
          reminder = reminder,
          showMissingData = showMissingData,
          onPlaceChange = viewModel::updatePlace,
          onContinue = {
            showMissingData = reminder.place.isBlank()
            if (!showMissingData) step = RelevoStep.TEST
          },
        )
      RelevoStep.TEST ->
        TestSignalScreen(
          reminder = reminder,
          result = signalWasPerceived,
          onPlay = viewModel::testSignal,
          onStop = viewModel::stopTestSignal,
          onResult = { signalWasPerceived = it },
          onContinue = {
            viewModel.stopTestSignal()
            step = RelevoStep.ARM
          },
        )
      RelevoStep.ARM ->
        ArmScreen(
          reminder = reminder,
          onArm = { if (viewModel.arm()) step = RelevoStep.WAIT },
          onExit = {
            viewModel.close()
            step = RelevoStep.CLOSE
          },
        )
      RelevoStep.WAIT ->
        WaitScreen(reminder, remainingSeconds) {
          viewModel.disarm()
          step = RelevoStep.CLOSE
        }
      RelevoStep.SIGNAL ->
        SignalScreen(reminder) {
          viewModel.silence()
          step = RelevoStep.CLOSE
        }
      RelevoStep.CLOSE ->
        CloseScreen(reminder, viewModel::close) {
          viewModel.reset()
          showMissingData = false
          signalWasPerceived = null
          step = RelevoStep.FORMULATE
        }
    }
  }
}

@Composable
private fun RelevoScaffold(step: RelevoStep, onBack: () -> Unit, content: @Composable () -> Unit) {
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    Column(
      modifier = Modifier.fillMaxSize().safeDrawingPadding().padding(horizontal = 24.dp, vertical = 16.dp),
    ) {
      Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("RELEVO", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.weight(1f))
        Text(
          "${step.ordinal + 1} / ${RelevoStep.entries.size}",
          style = MaterialTheme.typography.labelMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
      Spacer(Modifier.height(12.dp))
      ProgressDots(step.ordinal)
      if (step !in listOf(RelevoStep.FORMULATE, RelevoStep.WAIT, RelevoStep.SIGNAL, RelevoStep.CLOSE)) {
        TextButton(onClick = onBack) { Text("Volver") }
      } else {
        Spacer(Modifier.height(16.dp))
      }
      Box(modifier = Modifier.weight(1f)) { content() }
    }
  }
}

@Composable
private fun ProgressDots(active: Int) {
  Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
    RelevoStep.entries.forEachIndexed { index, _ ->
      Surface(
        modifier = Modifier.size(if (index == active) 10.dp else 6.dp),
        shape = CircleShape,
        color = if (index <= active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
        content = {},
      )
    }
  }
}

@Composable
private fun ScreenBody(
  eyebrow: String,
  title: String,
  description: String,
  content: @Composable ColumnScope.() -> Unit,
) {
  Column(
    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(18.dp),
  ) {
    Text(eyebrow.uppercase(), style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
    Text(title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold)
    Text(description, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
    content()
    Spacer(Modifier.height(8.dp))
  }
}

@Composable
private fun FormulateScreen(
  reminder: Reminder,
  onActivityChange: (String) -> Unit,
  onStartChange: (String) -> Unit,
  onContinue: () -> Unit,
) =
  ScreenBody("Preparar", "¿Qué quieres hacer?", "Escribe una actividad y una forma concreta de comenzar.") {
    OutlinedTextField(
      value = reminder.activity,
      onValueChange = onActivityChange,
      label = { Text("Actividad") },
      supportingText = { Text("Por ejemplo: salir a caminar") },
      modifier = Modifier.fillMaxWidth(),
      singleLine = true,
    )
    OutlinedTextField(
      value = reminder.howToStart,
      onValueChange = onStartChange,
      label = { Text("Cómo podrías empezar") },
      supportingText = { Text("Por ejemplo: ponerme las zapatillas") },
      modifier = Modifier.fillMaxWidth(),
      singleLine = true,
    )
    PrimaryButton(
      "Continuar",
      enabled = reminder.activity.isNotBlank() && reminder.howToStart.isNotBlank(),
      onClick = onContinue,
    )
  }

@Composable
private fun ConfigureScreen(reminder: Reminder, onDelayChange: (Int) -> Unit, onContinue: () -> Unit) =
  ScreenBody("Condición de prueba", "¿Cuándo quieres recibir la señal?", "Para esta prueba, Relevo esperará el tiempo que elijas.") {
    listOf(15 to "15 segundos", 60 to "1 minuto", 300 to "5 minutos").forEach { (seconds, label) ->
      if (reminder.delaySeconds == seconds) {
        Button(onClick = { onDelayChange(seconds) }, modifier = Modifier.fillMaxWidth()) { Text(label) }
      } else {
        OutlinedButton(onClick = { onDelayChange(seconds) }, modifier = Modifier.fillMaxWidth()) { Text(label) }
      }
    }
    Text(
      "La detección automática del uso de otras aplicaciones no forma parte de esta versión.",
      style = MaterialTheme.typography.bodySmall,
    )
    PrimaryButton("Revisar", onClick = onContinue)
  }

@Composable
private fun ReviewScreen(
  reminder: Reminder,
  showMissingData: Boolean,
  onEdit: () -> Unit,
  onContinue: () -> Unit,
) =
  ScreenBody("Revisar", "Comprueba tu recordatorio", "Puedes volver y cambiar cualquier dato antes de situarlo.") {
    SummaryCard("Actividad", reminder.activity)
    SummaryCard("Cómo empezar", reminder.howToStart)
    SummaryCard("Espera", formatDelay(reminder.delaySeconds))
    if (showMissingData) ErrorText("Completa la actividad y la forma de comenzar antes de continuar.")
    PrimaryButton("Continuar", onClick = onContinue)
    TextButton(onClick = onEdit, modifier = Modifier.fillMaxWidth()) { Text("Editar") }
  }

@Composable
private fun SituateScreen(
  reminder: Reminder,
  showMissingData: Boolean,
  onPlaceChange: (String) -> Unit,
  onContinue: () -> Unit,
) =
  ScreenBody("Situar", "¿Dónde quedará la señal?", "Deja el parlante u objeto cerca de algo que te ayude a comenzar.") {
    OutlinedTextField(
      value = reminder.place,
      onValueChange = onPlaceChange,
      label = { Text("Lugar") },
      supportingText = { Text("Por ejemplo: junto a las zapatillas") },
      modifier = Modifier.fillMaxWidth(),
      singleLine = true,
    )
    if (showMissingData && reminder.place.isBlank()) ErrorText("Escribe un lugar para continuar.")
    PrimaryButton("Probar la señal", enabled = reminder.place.isNotBlank(), onClick = onContinue)
  }

@Composable
private fun TestSignalScreen(
  reminder: Reminder,
  result: Boolean?,
  onPlay: () -> Unit,
  onStop: () -> Unit,
  onResult: (Boolean) -> Unit,
  onContinue: () -> Unit,
) =
  ScreenBody("Probar", "Escucha la señal en ${reminder.place}", "Comprueba que se perciba sin interrumpir más de lo necesario.") {
    SignalMark()
    PrimaryButton("Emitir señal de prueba", onClick = onPlay)
    OutlinedButton(onClick = onStop, modifier = Modifier.fillMaxWidth()) { Text("Detener") }
    Text("¿La señal se percibe bien?", fontWeight = FontWeight.Medium)
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
      OutlinedButton(onClick = { onResult(false) }, modifier = Modifier.weight(1f)) { Text("Ajustar") }
      Button(onClick = { onResult(true) }, modifier = Modifier.weight(1f)) { Text("Sí") }
    }
    if (result == false) ErrorText("Ajusta el volumen o cambia el lugar y vuelve a probar.")
    PrimaryButton("Continuar", enabled = result == true, onClick = onContinue)
  }

@Composable
private fun ArmScreen(reminder: Reminder, onArm: () -> Unit, onExit: () -> Unit) =
  ScreenBody("Activar", "Todo está preparado", "La señal se emitirá una vez después de ${formatDelay(reminder.delaySeconds)}.") {
    SummaryCard(reminder.activity, reminder.howToStart)
    SummaryCard("Lugar", reminder.place)
    PrimaryButton("Activar recordatorio", onClick = onArm)
    TextButton(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Salir sin activar") }
  }

@Composable
private fun WaitScreen(reminder: Reminder, remainingSeconds: Int, onDisarm: () -> Unit) =
  ScreenBody("Recordatorio activo", reminder.activity, "La señal se emitirá en el lugar elegido cuando termine la espera.") {
    Text(
      if (remainingSeconds > 0) formatCountdown(remainingSeconds) else "Preparando señal…",
      fontSize = 44.sp,
      fontWeight = FontWeight.Light,
    )
    SummaryCard("Cómo empezar", reminder.howToStart)
    SummaryCard("Lugar", reminder.place)
    Text("Puedes cambiar de idea. Desactivar no se considera un error.", style = MaterialTheme.typography.bodySmall)
    OutlinedButton(onClick = onDisarm, modifier = Modifier.fillMaxWidth()) { Text("Desactivar") }
  }

@Composable
private fun SignalScreen(reminder: Reminder, onSilence: () -> Unit) =
  ScreenBody("Señal emitida", reminder.activity, "La señal está en ${reminder.place}. Tú decides qué hacer ahora.") {
    SignalMark()
    SummaryCard("Una forma de empezar", reminder.howToStart)
    PrimaryButton("Silenciar y cerrar", onClick = onSilence)
  }

@Composable
private fun CloseScreen(reminder: Reminder, onClose: () -> Unit, onNew: () -> Unit) =
  ScreenBody("Cierre", "El recordatorio terminó", "Relevo no registra si hiciste la actividad. La decisión sigue siendo tuya.") {
    LaunchedEffect(Unit) { onClose() }
    if (reminder.activity.isNotBlank()) SummaryCard(reminder.activity, reminder.howToStart)
    PrimaryButton("Preparar otro recordatorio", onClick = onNew)
  }

@Composable
private fun SummaryCard(label: String, value: String) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
    shape = RoundedCornerShape(16.dp),
  ) {
    Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
      Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text(value.ifBlank { "Sin completar" }, style = MaterialTheme.typography.titleMedium)
    }
  }
}

@Composable
private fun SignalMark() {
  Box(modifier = Modifier.fillMaxWidth().height(150.dp), contentAlignment = Alignment.Center) {
    Surface(modifier = Modifier.size(112.dp), shape = CircleShape, color = MaterialTheme.colorScheme.primaryContainer) {
      Box(contentAlignment = Alignment.Center) {
        Surface(modifier = Modifier.size(28.dp), shape = CircleShape, color = MaterialTheme.colorScheme.primary, content = {})
      }
    }
  }
}

@Composable
private fun PrimaryButton(label: String, enabled: Boolean = true, onClick: () -> Unit) {
  Button(
    onClick = onClick,
    enabled = enabled,
    modifier = Modifier.fillMaxWidth().height(54.dp),
    shape = RoundedCornerShape(14.dp),
    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
  ) {
    Text(label)
  }
}

@Composable
private fun ErrorText(message: String) {
  Text(message, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyMedium)
}

private fun initialStep(status: ReminderStatus): RelevoStep =
  when (status) {
    ReminderStatus.WAITING -> RelevoStep.WAIT
    ReminderStatus.SIGNALLED -> RelevoStep.SIGNAL
    ReminderStatus.SILENCED, ReminderStatus.CLOSED -> RelevoStep.CLOSE
    else -> RelevoStep.FORMULATE
  }

private fun previousStep(step: RelevoStep): RelevoStep =
  if (step == RelevoStep.FORMULATE) step else RelevoStep.entries[step.ordinal - 1]

private fun formatDelay(seconds: Int): String =
  when {
    seconds < 60 -> "$seconds segundos"
    seconds % 60 == 0 -> "${seconds / 60} ${if (seconds == 60) "minuto" else "minutos"}"
    else -> "$seconds segundos"
  }

private fun formatCountdown(seconds: Int): String = "%02d:%02d".format(seconds / 60, seconds % 60)
