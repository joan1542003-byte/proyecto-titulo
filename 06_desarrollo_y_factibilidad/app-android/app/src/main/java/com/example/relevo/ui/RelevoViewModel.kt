package com.example.relevo.ui

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.core.content.ContextCompat
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.HistoryStore
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.CustomActivityStore
import com.example.relevo.data.RemoteSync
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.SignalRoute
import com.example.relevo.monitor.AppUsageMonitorService
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.monitor.InstalledAppsRepository
import com.example.relevo.monitor.UsageAccess
import com.example.relevo.monitor.AppUsageSummary
import com.example.relevo.monitor.UsageSummaryRepository
import com.example.relevo.signal.SignalPlayer
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class RelevoViewModel(application: Application) : AndroidViewModel(application) {
  private val store = ReminderStore(application)
  private val researchLog = ResearchLogStore(application)
  private val remoteSync = RemoteSync(application, researchLog)
  val remoteConfigured: Boolean get() = remoteSync.configured
  val deletionPending: Boolean get() = remoteSync.deletionPending
  private val historyStore = HistoryStore(application)
  private val customActivityStore = CustomActivityStore(application)
  private val signalPlayer = SignalPlayer(application)
  private val appsRepository = InstalledAppsRepository(application)
  private val usageSummaryRepository = UsageSummaryRepository(application)
  private val experiencePreferences = application.getSharedPreferences("relevo_experience", Application.MODE_PRIVATE)
  private val _reminder = MutableStateFlow(store.load())
  val reminder: StateFlow<Reminder> = _reminder.asStateFlow()

  private val _customActivities = MutableStateFlow(customActivityStore.load())
  val customActivities: StateFlow<List<CustomActivity>> = _customActivities.asStateFlow()

  private val _remainingSeconds = MutableStateFlow(0)
  val remainingSeconds: StateFlow<Int> = _remainingSeconds.asStateFlow()

  private val _installedApps = MutableStateFlow<List<InstalledApp>>(emptyList())
  val installedApps: StateFlow<List<InstalledApp>> = _installedApps.asStateFlow()

  private val _usageAccessGranted = MutableStateFlow(UsageAccess.isGranted(application))
  val usageAccessGranted: StateFlow<Boolean> = _usageAccessGranted.asStateFlow()

  private val _history = MutableStateFlow(historyStore.load())
  val history: StateFlow<List<HistoryEntry>> = _history.asStateFlow()

  private val _todayUsage = MutableStateFlow<List<AppUsageSummary>>(emptyList())
  val todayUsage: StateFlow<List<AppUsageSummary>> = _todayUsage.asStateFlow()

  private val _deletionStatus = MutableStateFlow<String?>(null)
  val deletionStatus: StateFlow<String?> = _deletionStatus.asStateFlow()
  private var deletingData = false

  private var stateSyncJob: Job? = null

  init {
    _installedApps.value = appsRepository.launcherApps()
    if (!hasCurrentConsent()) {
      application.stopService(Intent(application, AppUsageMonitorService::class.java))
      updateValue(_reminder.value.copy(participantCode = "", consentAccepted = false, status = ReminderStatus.DRAFT))
    } else {
      val participantCode = experiencePreferences.getString("participant_code", null)
        ?: _reminder.value.participantCode.ifBlank { "P-${UUID.randomUUID().toString().take(8).uppercase()}" }
      experiencePreferences.edit().putString("participant_code", participantCode).apply()
      if (_reminder.value.participantCode != participantCode || !_reminder.value.consentAccepted)
        updateValue(_reminder.value.copy(participantCode = participantCode, consentAccepted = true))
    }
    startStateSync()
    if (hasCurrentConsent()) refreshDashboard()
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

  fun updateSignalRoute(route: SignalRoute) = update { copy(signalRoute = route, status = ReminderStatus.DRAFT) }

  fun updateParticipantCode(value: String) {
    val code = value.trim().take(24)
    experiencePreferences.edit().putString("participant_code", code).apply()
    update { copy(participantCode = code, status = ReminderStatus.DRAFT) }
  }

  fun updateConsent(accepted: Boolean) {
    if (accepted && remoteSync.deletionPending) return
    if (accepted) _deletionStatus.value = null
    val participantCode = if (accepted) experiencePreferences.getString("participant_code", null)
      ?: "P-${UUID.randomUUID().toString().take(8).uppercase()}" else ""
    experiencePreferences.edit()
      .putBoolean("academic_consent_accepted", accepted)
      .putString("academic_consent_version", if (accepted) ResearchLogStore.CONSENT_VERSION else null)
      .putString("participant_code", if (accepted) participantCode else null)
      .apply()
    update { copy(participantCode = participantCode, consentAccepted = accepted, status = ReminderStatus.DRAFT) }
    if (accepted) refreshDashboard()
  }

  fun applyPreset(activity: String, firstStep: String, place: String) =
    update {
      copy(activity = activity, howToStart = firstStep, place = place,
        requiredUsageSeconds = if (requiredUsageSeconds < 60) 900 else requiredUsageSeconds,
        status = ReminderStatus.DRAFT)
    }

  fun saveCustomActivity(activity: CustomActivity) {
    _customActivities.value = customActivityStore.upsert(activity)
    applyPreset(activity.name, activity.firstStep, activity.place)
  }

  fun deleteCustomActivity(id: String) {
    _customActivities.value = customActivityStore.delete(id)
  }

  fun selectTargetApp(app: InstalledApp) =
    update {
      val current = selectedApps.toMutableList()
      val existing = current.indexOfFirst { it.packageName == app.packageName }
      if (existing >= 0) current.removeAt(existing) else current.add(com.example.relevo.domain.TrackedApp(app.packageName, app.label))
      copy(
        targetPackage = current.firstOrNull()?.packageName.orEmpty(),
        targetAppLabel = current.firstOrNull()?.label.orEmpty(),
        targetApps = current,
        status = ReminderStatus.DRAFT,
      )
    }

  fun refreshUsageAccess() {
    _usageAccessGranted.value = UsageAccess.isGranted(getApplication())
    refreshDashboard()
  }

  fun refreshDashboard() {
    val history = historyStore.load()
    val selectedPackages = (history.flatMap { it.appPackages } + _reminder.value.selectedApps.map { it.packageName }).filter { it.isNotBlank() }.toSet()
    _history.value = history
    _todayUsage.value = usageSummaryRepository.today().filter { it.packageName in selectedPackages }
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
    if (!hasCurrentConsent()) return false
    refreshUsageAccess()
    if (!_usageAccessGranted.value) return false
    val next = _reminder.value.arm(UUID.randomUUID().toString())
    updateValue(next)
    if (next.status == ReminderStatus.WAITING) {
      researchLog.record(next.sessionId, next.participantCode, "armed", next.targetPackage, 0)
      researchLog.startSession(next)
      syncRemote()
      ContextCompat.startForegroundService(
        getApplication(),
        Intent(getApplication(), AppUsageMonitorService::class.java),
      )
    }
    return next.status == ReminderStatus.WAITING
  }

  fun testSignal(): Boolean {
    val started = signalPlayer.play(_reminder.value.signalRoute)
    if (started) viewModelScope.launch {
      delay(2_400)
      signalPlayer.stop()
    }
    return started
  }

  fun stopTestSignal() = signalPlayer.stop()

  fun disarm() {
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    val current = _reminder.value
    historyStore.add(current)
    _history.value = historyStore.load()
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
    historyStore.add(current)
    _history.value = historyStore.load()
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

  fun completeEvaluation(outcome: String) {
    historyStore.markOutcome(_reminder.value.sessionId, outcome)
    _history.value = historyStore.load()
    researchLog.completeSession(_reminder.value, outcome)
    syncRemote()
  }

  fun reset() {
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    store.clear()
    _reminder.value = Reminder(
      participantCode = experiencePreferences.getString("participant_code", null).orEmpty(),
      consentAccepted = hasCurrentConsent(),
    )
    store.save(_reminder.value)
    _remainingSeconds.value = 0
  }

  fun deleteResearchData() {
    if (deletingData) return
    deletingData = true
    _deletionStatus.value = "Eliminando datos…"
    remoteSync.beginDeletion()
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    experiencePreferences.edit().putBoolean("academic_consent_accepted", false).remove("academic_consent_version").apply()
    updateValue(_reminder.value.copy(consentAccepted = false, status = ReminderStatus.DRAFT))
    viewModelScope.launch(Dispatchers.IO) {
      val deleted = remoteSync.deleteOwnResearchData()
      if (deleted) {
        researchLog.clearAll()
        historyStore.clear()
        customActivityStore.clear()
        store.clear()
        remoteSync.clearCredentials()
        experiencePreferences.edit().clear().apply()
        val code = "P-${UUID.randomUUID().toString().take(8).uppercase()}"
        experiencePreferences.edit().putString("participant_code", code).apply()
        val fresh = Reminder(participantCode = code)
        store.save(fresh)
        _reminder.value = fresh
        _history.value = emptyList()
        _customActivities.value = emptyList()
        _todayUsage.value = emptyList()
        _deletionStatus.value = "Datos eliminados. Si quieres volver a usar Relevo, tendrás que aceptar de nuevo las condiciones."
      } else {
        _deletionStatus.value = "Se detuvo el registro, pero no pudimos confirmar la eliminación. Tus datos siguen en el teléfono. Puedes reintentar o escribir a joan1542003@gmail.com."
      }
      deletingData = false
    }
  }

  private fun hasCurrentConsent(): Boolean =
    experiencePreferences.getBoolean("academic_consent_accepted", false) &&
      experiencePreferences.getString("academic_consent_version", null) == ResearchLogStore.CONSENT_VERSION

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

  private fun syncRemote() {
    if (deletingData) return
    viewModelScope.launch(Dispatchers.IO) { remoteSync.syncPending() }
  }

  override fun onCleared() {
    signalPlayer.stop()
    stateSyncJob?.cancel()
    super.onCleared()
  }
}
