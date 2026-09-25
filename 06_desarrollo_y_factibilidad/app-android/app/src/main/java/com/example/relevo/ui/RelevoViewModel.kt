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
import com.example.relevo.data.StudyStore
import com.example.relevo.data.SyncStatus
import com.example.relevo.domain.StudyCondition
import com.example.relevo.domain.StudyPlan
import com.example.relevo.monitor.AppUsageMonitorService
import com.example.relevo.monitor.BackgroundAccess
import com.example.relevo.monitor.UsageAfterSignal
import java.time.LocalDate
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

  private val lastStore = ReminderStore(application, ReminderStore.LAST_CONFIGURATION)
  private val _lastReminder = MutableStateFlow(lastStore.load().takeIf { it.activity.isNotBlank() && it.selectedApps.isNotEmpty() })
  val lastReminder: StateFlow<Reminder?> = _lastReminder.asStateFlow()

  private val _backgroundUnrestricted = MutableStateFlow(BackgroundAccess.isUnrestricted(application))
  val backgroundUnrestricted: StateFlow<Boolean> = _backgroundUnrestricted.asStateFlow()

  private val _syncStatus = MutableStateFlow(remoteSync.status())
  val syncStatus: StateFlow<SyncStatus> = _syncStatus.asStateFlow()

  private val studyStore = StudyStore(application)
  private val _study = MutableStateFlow(computeStudyState())
  val study: StateFlow<StudyState> = _study.asStateFlow()

  /** Último relevo cuya tarjeta de regreso la persona cerró con «Ahora no». */
  private val _returnDismissedFor = MutableStateFlow(experiencePreferences.getLong("return_dismissed_for", 0L))
  val returnDismissedFor: StateFlow<Long> = _returnDismissedFor.asStateFlow()

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
    onAppResumed()
  }

  /** Al volver a la app: comprueba permisos, retoma un conteo interrumpido y reintenta el envío pendiente. */
  fun onAppResumed() {
    _usageAccessGranted.value = UsageAccess.isGranted(getApplication())
    _backgroundUnrestricted.value = BackgroundAccess.isUnrestricted(getApplication())
    refreshStudy()
    val current = _reminder.value
    if (current.status == ReminderStatus.WAITING && _usageAccessGranted.value && hasCurrentConsent() && !AppUsageMonitorService.isCounting) {
      ContextCompat.startForegroundService(
        getApplication(),
        Intent(getApplication(), AppUsageMonitorService::class.java).setAction(AppUsageMonitorService.ACTION_RESTORE),
      )
    }
    // Si Android cerró la app mientras sonaba, la señal ya no suena: la pantalla debe decirlo.
    if (current.status == ReminderStatus.SIGNALLED && !current.signalEnded && !AppUsageMonitorService.isCounting) {
      updateValue(current.endSignal())
    }
    if (hasCurrentConsent()) {
      viewModelScope.launch(Dispatchers.IO) {
        UsageAfterSignal.update(getApplication(), researchLog)
        syncRemote()
      }
    } else refreshSyncStatus()
  }

  // ---- Prueba de 21 días (protocolo 02) ----

  private fun computeStudyState(today: LocalDate = LocalDate.now()): StudyState {
    val plan = studyStore.plan() ?: return StudyState()
    val week = plan.week(today)
    return StudyState(
      plan = plan,
      day = plan.day(today),
      week = week,
      condition = plan.condition(today),
      pendingWeek = plan.weeksReadyForReview(today).firstOrNull { !studyStore.weekDone(it) },
      instructionWeek = week?.takeIf { !studyStore.instructionSeen(it) },
      closingPending = plan.closingReady(today) && !studyStore.closingDone(),
    )
  }

  /** Recalcula el día y la condición; fuera de un relevo activo, la condición fija la salida del sonido. */
  fun refreshStudy() {
    val state = computeStudyState()
    _study.value = state
    val current = _reminder.value
    val route = state.condition?.route
    if (route != null && current.signalRoute != route && current.status != ReminderStatus.WAITING && current.status != ReminderStatus.SIGNALLED) {
      updateValue(current.copy(signalRoute = route))
    }
  }

  /** El investigador asigna la secuencia en la sesión inicial; hoy es el día 0. */
  fun startStudy(sequence: String) {
    val today = LocalDate.now()
    studyStore.start(sequence, today)
    researchLog.recordAnswer(_reminder.value.participantCode, "prueba_inicio", "secuencia=$sequence;dia0=$today")
    refreshStudy()
    syncRemote()
  }

  fun endStudy() {
    val plan = studyStore.plan() ?: return
    researchLog.recordAnswer(_reminder.value.participantCode, "prueba_fin", "secuencia=${plan.sequence};dia=${plan.day(LocalDate.now())}")
    studyStore.clear()
    refreshStudy()
    syncRemote()
  }

  fun dismissInstruction(week: Int) {
    studyStore.markInstructionSeen(week)
    refreshStudy()
  }

  /** Tarjeta de cierre de semana: tres escalas de 1 a 5 y un comentario, todo opcional. */
  fun submitWeek(week: Int, preparation: Int?, annoyance: Int?, place: Int?, comment: String) {
    val code = _reminder.value.participantCode
    preparation?.let { researchLog.recordAnswer(code, "semana${week}_costo_preparar", it.toString()) }
    annoyance?.let { researchLog.recordAnswer(code, "semana${week}_molestia_senal", it.toString()) }
    place?.let { researchLog.recordAnswer(code, "semana${week}_relacion_lugar", it.toString()) }
    comment.trim().takeIf { it.isNotEmpty() }?.let { researchLog.recordAnswer(code, "semana${week}_comentario", it) }
    if (preparation == null && annoyance == null && place == null && comment.isBlank()) researchLog.recordAnswer(code, "semana${week}_omitida", "si")
    studyStore.markWeekDone(week)
    refreshStudy()
    syncRemote()
  }

  /** Cierre del día 21: respuestas por clave; las vacías se omiten. */
  fun submitClosing(answers: Map<String, String>) {
    val code = _reminder.value.participantCode
    val given = answers.filterValues { it.isNotBlank() }
    given.forEach { (question, answer) -> researchLog.recordAnswer(code, "cierre_$question", answer.trim()) }
    if (given.isEmpty()) researchLog.recordAnswer(code, "cierre_omitido", "si")
    studyStore.markClosingDone()
    refreshStudy()
    syncRemote()
  }

  fun dismissReturn(lastCompletedAt: Long) {
    experiencePreferences.edit().putLong("return_dismissed_for", lastCompletedAt).apply()
    _returnDismissedFor.value = lastCompletedAt
  }

  fun requestBackgroundAccess() {
    val context = getApplication<Application>()
    runCatching { context.startActivity(BackgroundAccess.requestIntent(context)) }
      .recoverCatching { context.startActivity(BackgroundAccess.settingsIntent()) }
  }

  /** Carga la última configuración usada para revisarla y activarla de nuevo. No la activa por sí sola. */
  fun repeatLast(): Boolean {
    val last = _lastReminder.value ?: return false
    val installed = _installedApps.value.map { it.packageName }.toSet()
    val apps = last.selectedApps.filter { it.packageName in installed }
    if (apps.isEmpty()) return false
    updateValue(last.copy(
      targetApps = apps,
      targetPackage = apps.first().packageName,
      targetAppLabel = apps.first().label,
      participantCode = _reminder.value.participantCode,
      consentAccepted = hasCurrentConsent(),
      sessionId = "",
      observedUsageSeconds = 0,
      signalDelivered = false,
      signalAt = 0L,
      signalEnded = false,
      status = ReminderStatus.DRAFT,
    ))
    refreshStudy()
    return true
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

  /** Durante la prueba, la condición de la semana decide dónde suena; la persona no la cambia. */
  fun updateSignalRoute(route: SignalRoute) {
    if (_study.value.condition != null) return
    update { copy(signalRoute = route, status = ReminderStatus.DRAFT) }
  }

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
    refreshStudy()
    // Cada relevo queda asociado al día y a la condición en que se activó.
    val study = _study.value
    val prepared = _reminder.value.copy(
      signalRoute = study.condition?.route ?: _reminder.value.signalRoute,
      studyCondition = study.condition?.code?.toString().orEmpty(),
      studyDay = if (study.active) study.day else -1,
    )
    val next = prepared.arm(UUID.randomUUID().toString())
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

  /** Prueba de sonido: una firma, que termina sola. */
  fun testSignal(): Boolean {
    val started = signalPlayer.play(_reminder.value.signalRoute, SignalPlayer.Pattern.TEST)
    if (started) viewModelScope.launch {
      delay(3_000)
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

  /**
   * Primera acción de la persona en la pantalla de señal. Si el sonido seguía, lo silencia; si ya
   * había terminado, solo registra la respuesta. En ambos casos guarda cuánto tardó en responder.
   */
  fun silence() {
    signalPlayer.stop()
    AppUsageMonitorService.cancelSignalNotification(getApplication())
    val current = _reminder.value
    historyStore.add(current)
    _history.value = historyStore.load()
    val responseSeconds = if (current.signalAt > 0L) ((System.currentTimeMillis() - current.signalAt) / 1_000L).toInt().coerceAtLeast(0) else null
    researchLog.record(current.sessionId, current.participantCode, if (current.signalEnded) "responded" else "silenced", current.targetPackage, responseSeconds)
    if (!current.signalEnded) researchLog.markSignalEnd(current.sessionId, "silenced")
    responseSeconds?.let { researchLog.markResponse(current.sessionId, it) }
    updateValue(current.silence())
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

  /**
   * Cierra el relevo con la respuesta declarada. Durante la prueba se agregan dos preguntas de un
   * toque (protocolo 02); null significa que no se respondieron.
   */
  fun completeEvaluation(outcome: String, knewIntention: String? = null, recalledFirstStep: String? = null) {
    AppUsageMonitorService.cancelSignalNotification(getApplication())
    historyStore.markOutcome(_reminder.value.sessionId, outcome)
    _history.value = historyStore.load()
    researchLog.completeSession(_reminder.value, outcome, knewIntention, recalledFirstStep)
    syncRemote()
  }

  fun reset() {
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    _reminder.value.takeIf { it.activity.isNotBlank() && it.selectedApps.isNotEmpty() }?.let { finished ->
      val configuration = finished.copy(
        sessionId = "", observedUsageSeconds = 0, signalDelivered = false, status = ReminderStatus.DRAFT,
        signalAt = 0L, signalEnded = false, studyCondition = "", studyDay = -1,
      )
      lastStore.save(configuration)
      _lastReminder.value = configuration
    }
    store.clear()
    _reminder.value = Reminder(
      participantCode = experiencePreferences.getString("participant_code", null).orEmpty(),
      consentAccepted = hasCurrentConsent(),
    )
    store.save(_reminder.value)
    _remainingSeconds.value = 0
    refreshStudy()
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
        lastStore.clear()
        _lastReminder.value = null
        studyStore.clear()
        _study.value = StudyState()
        _returnDismissedFor.value = 0L
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
    viewModelScope.launch(Dispatchers.IO) {
      remoteSync.syncPending()
      refreshSyncStatus()
    }
  }

  private fun refreshSyncStatus() {
    viewModelScope.launch(Dispatchers.IO) { _syncStatus.value = remoteSync.status() }
  }

  override fun onCleared() {
    signalPlayer.stop()
    stateSyncJob?.cancel()
    super.onCleared()
  }
}

/** Estado de la prueba de 21 días que necesita la interfaz. */
data class StudyState(
  val plan: StudyPlan? = null,
  val day: Int = -1,
  val week: Int? = null,
  val condition: StudyCondition? = null,
  /** Semana cuya tarjeta de cierre falta responder u omitir. */
  val pendingWeek: Int? = null,
  /** Semana cuya instrucción de condición aún no se leyó. */
  val instructionWeek: Int? = null,
  val closingPending: Boolean = false,
) {
  val active: Boolean get() = plan != null && day in 0..StudyPlan.LAST_DAY
  val initialSession: Boolean get() = plan != null && day == 0
  val finished: Boolean get() = plan != null && day > StudyPlan.LAST_DAY
}
