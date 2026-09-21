package com.example.relevo.ui

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.core.content.ContextCompat
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.monitor.AppUsageMonitorService
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.monitor.InstalledAppsRepository
import com.example.relevo.monitor.UsageAccess
import com.example.relevo.signal.SignalPlayer
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class RelevoViewModel(application: Application) : AndroidViewModel(application) {
  private val store = ReminderStore(application)
  private val researchLog = ResearchLogStore(application)
  private val signalPlayer = SignalPlayer(application)
  private val appsRepository = InstalledAppsRepository(application)
  private val _reminder = MutableStateFlow(store.load())
  val reminder: StateFlow<Reminder> = _reminder.asStateFlow()

  private val _remainingSeconds = MutableStateFlow(0)
  val remainingSeconds: StateFlow<Int> = _remainingSeconds.asStateFlow()

  private val _installedApps = MutableStateFlow<List<InstalledApp>>(emptyList())
  val installedApps: StateFlow<List<InstalledApp>> = _installedApps.asStateFlow()

  private val _usageAccessGranted = MutableStateFlow(UsageAccess.isGranted(application))
  val usageAccessGranted: StateFlow<Boolean> = _usageAccessGranted.asStateFlow()

  private var stateSyncJob: Job? = null

  init {
    _installedApps.value = appsRepository.launcherApps()
    if (_reminder.value.participantCode.isBlank()) {
      updateValue(_reminder.value.copy(participantCode = "P-${UUID.randomUUID().toString().take(8).uppercase()}"))
    }
    startStateSync()
    if (_reminder.value.status == ReminderStatus.WAITING && UsageAccess.isGranted(application)) {
      ContextCompat.startForegroundService(
        application,
        Intent(application, AppUsageMonitorService::class.java),
      )
    }
  }

  fun updateActivity(value: String) = update { copy(activity = value, status = ReminderStatus.DRAFT) }

  fun updateHowToStart(value: String) = update { copy(howToStart = value, status = ReminderStatus.DRAFT) }

  fun updatePlace(value: String) =
    update {
      copy(
        place = value,
        status = if (hasPreparedContent) ReminderStatus.READY else ReminderStatus.DRAFT,
      )
    }

  fun updateRequiredUsage(seconds: Int) =
    update { copy(requiredUsageSeconds = seconds.coerceAtLeast(1), status = ReminderStatus.DRAFT) }

  fun updateParticipantCode(value: String) =
    update { copy(participantCode = value.trim().take(24), status = ReminderStatus.DRAFT) }

  fun updateConsent(accepted: Boolean) =
    update { copy(consentAccepted = accepted, status = ReminderStatus.DRAFT) }

  fun selectTargetApp(app: InstalledApp) =
    update {
      copy(
        targetPackage = app.packageName,
        targetAppLabel = app.label,
        status = ReminderStatus.DRAFT,
      )
    }

  fun refreshUsageAccess() {
    _usageAccessGranted.value = UsageAccess.isGranted(getApplication())
  }

  fun openUsageAccessSettings() {
    getApplication<Application>().startActivity(UsageAccess.settingsIntent())
  }

  fun markReady(): Boolean {
    val next = _reminder.value.ready()
    updateValue(next)
    return next.status == ReminderStatus.READY
  }

  fun activate(): Boolean {
    if (!markReady()) return false
    return arm()
  }

  fun arm(): Boolean {
    refreshUsageAccess()
    if (!_usageAccessGranted.value) return false
    val next = _reminder.value.arm(UUID.randomUUID().toString())
    updateValue(next)
    if (next.status == ReminderStatus.WAITING) {
      researchLog.record(next.sessionId, next.participantCode, "armed", next.targetPackage, 0)
      ContextCompat.startForegroundService(
        getApplication(),
        Intent(getApplication(), AppUsageMonitorService::class.java),
      )
    }
    return next.status == ReminderStatus.WAITING
  }

  fun testSignal() = signalPlayer.play()

  fun stopTestSignal() = signalPlayer.stop()

  fun disarm() {
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    val current = _reminder.value
    researchLog.record(
      current.sessionId,
      current.participantCode,
      "disarmed",
      current.targetPackage,
      current.observedUsageSeconds,
    )
    updateValue(_reminder.value.disarm())
    _remainingSeconds.value = 0
  }

  fun silence() {
    signalPlayer.stop()
    val current = _reminder.value
    researchLog.record(
      current.sessionId,
      current.participantCode,
      "silenced",
      current.targetPackage,
      current.observedUsageSeconds,
    )
    updateValue(_reminder.value.silence())
  }

  fun close() {
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    val current = _reminder.value
    researchLog.record(
      current.sessionId,
      current.participantCode,
      "closed",
      current.targetPackage,
      current.observedUsageSeconds,
    )
    updateValue(_reminder.value.close())
    _remainingSeconds.value = 0
  }

  fun reset() {
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    store.clear()
    _reminder.value = Reminder(participantCode = "P-${UUID.randomUUID().toString().take(8).uppercase()}")
    _remainingSeconds.value = 0
  }

  private fun startStateSync() {
    stateSyncJob?.cancel()
    stateSyncJob =
      viewModelScope.launch {
        while (true) {
          val persisted = store.load()
          if (persisted != _reminder.value) _reminder.value = persisted
          _remainingSeconds.value =
            (persisted.requiredUsageSeconds - persisted.observedUsageSeconds).coerceAtLeast(0)
          delay(500)
        }
      }
  }

  private fun update(transform: Reminder.() -> Reminder) = updateValue(_reminder.value.transform())

  private fun updateValue(value: Reminder) {
    _reminder.value = value
    store.save(value)
  }

  override fun onCleared() {
    signalPlayer.stop()
    stateSyncJob?.cancel()
    super.onCleared()
  }
}
