package com.example.relevo.ui

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.udp.relevo.BuildConfig
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.CustomActivityStore
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.HistoryStore
import com.example.relevo.data.Participation
import com.example.relevo.data.Profile
import com.example.relevo.data.ProfileStore
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.RemoteSync
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.data.RouteStore
import com.example.relevo.data.Settings
import com.example.relevo.data.SettingsStore
import com.example.relevo.data.StudyStore
import com.example.relevo.data.SyncStatus
import com.example.relevo.domain.Interests
import com.example.relevo.domain.NextStepRule
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.RouteStep
import com.example.relevo.domain.RouteTrack
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.StudyCondition
import com.example.relevo.domain.StudyPlan
import com.example.relevo.monitor.AppUsageMonitorService
import com.example.relevo.monitor.BackgroundAccess
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.monitor.InstalledAppsRepository
import com.example.relevo.monitor.ReturnNotice
import com.example.relevo.monitor.UsageAccess
import com.example.relevo.monitor.UsageAfterSignal
import com.example.relevo.signal.SignalPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.time.LocalDate
import java.util.UUID

/** Cómo usa la persona la app: participa en la prueba, la usa solo en el teléfono o aún no decide. */
enum class ParticipationMode { STUDY, LOCAL, NONE }

/** R3: la persona dijo varias veces que empezó el mismo paso; se le ofrece el siguiente, sin afirmar un hábito. */
data class RouteSuggestion(val interest: String, val current: RouteStep, val next: RouteStep, val starts: Int)

class RelevoViewModel(application: Application) : AndroidViewModel(application) {
  private val store = ReminderStore(application)
  private val researchLog = ResearchLogStore(application)
  private val remoteSync = RemoteSync(application, researchLog)
  val remoteConfigured: Boolean get() = remoteSync.configured
  val deletionPending: Boolean get() = remoteSync.deletionPending
  private val historyStore = HistoryStore(application)
  private val customActivityStore = CustomActivityStore(application)
  private val profileStore = ProfileStore(application)
  private val routeStore = RouteStore(application)
  private val settingsStore = SettingsStore(application)
  private val signalPlayer = SignalPlayer(application)
  private val appsRepository = InstalledAppsRepository(application)
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

  private val _participation = MutableStateFlow(currentParticipation())
  val participation: StateFlow<ParticipationMode> = _participation.asStateFlow()

  private val _profile = MutableStateFlow(profileStore.load())
  val profile: StateFlow<Profile> = _profile.asStateFlow()

  private val _routes = MutableStateFlow(routeStore.load())
  val routes: StateFlow<List<RouteTrack>> = _routes.asStateFlow()

  private val _settings = MutableStateFlow(settingsStore.load())
  val settings: StateFlow<Settings> = _settings.asStateFlow()

  private val _routeSuggestion = MutableStateFlow<RouteSuggestion?>(null)
  val routeSuggestion: StateFlow<RouteSuggestion?> = _routeSuggestion.asStateFlow()

  /** Interés de la ruta cuyo paso la persona dejó con «Cambié de idea», para ofrecer cambiarlo. */
  private val _changedRouteInterest = MutableStateFlow<String?>(null)
  val changedRouteInterest: StateFlow<String?> = _changedRouteInterest.asStateFlow()

  /** Tras dos «Ahora no» seguidos en el aviso de regreso, se pregunta una sola vez si se apaga (V2). */
  private val _askTurnOffReturn = MutableStateFlow(false)
  val askTurnOffReturn: StateFlow<Boolean> = _askTurnOffReturn.asStateFlow()

  private var stateSyncJob: Job? = null

  init {
    _installedApps.value = appsRepository.launcherApps()
    when (currentParticipation()) {
      ParticipationMode.NONE -> {
        application.stopService(Intent(application, AppUsageMonitorService::class.java))
        updateValue(_reminder.value.copy(participantCode = "", consentAccepted = false, localOnly = false, status = ReminderStatus.DRAFT))
      }
      ParticipationMode.LOCAL -> if (!_reminder.value.localOnly || _reminder.value.participantCode.isNotBlank())
        updateValue(_reminder.value.copy(participantCode = "", consentAccepted = false, localOnly = true))
      ParticipationMode.STUDY -> {
        val participantCode = experiencePreferences.getString("participant_code", null)
          ?: _reminder.value.participantCode.ifBlank { "P-${UUID.randomUUID().toString().take(8).uppercase()}" }
        experiencePreferences.edit().putString("participant_code", participantCode).apply()
        if (_reminder.value.participantCode != participantCode || !_reminder.value.consentAccepted || _reminder.value.localOnly)
          updateValue(_reminder.value.copy(participantCode = participantCode, consentAccepted = true, localOnly = false))
      }
    }
    startStateSync()
    if (Participation.canUse(application)) refreshDashboard()
    onAppResumed()
  }

  private fun currentParticipation(): ParticipationMode = when {
    Participation.participating(getApplication()) -> ParticipationMode.STUDY
    Participation.localMode(getApplication()) -> ParticipationMode.LOCAL
    else -> ParticipationMode.NONE
  }

  /** Al volver a la app: comprueba permisos, retoma un conteo interrumpido y reintenta el envío pendiente. */
  fun onAppResumed() {
    _usageAccessGranted.value = UsageAccess.isGranted(getApplication())
    _backgroundUnrestricted.value = BackgroundAccess.isUnrestricted(getApplication())
    _participation.value = currentParticipation()
    settingsStore.lastOpenedAt = System.currentTimeMillis()
    ReturnNotice.dismiss(getApplication())
    if (settingsStore.returnNotNow >= 2 && !settingsStore.turnOffAsked && _settings.value.returnNotice) _askTurnOffReturn.value = true
    refreshStudy()
    val current = _reminder.value
    if (current.status == ReminderStatus.WAITING && _usageAccessGranted.value && Participation.canUse(getApplication()) && !AppUsageMonitorService.isCounting) {
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
    routeStore.setPreparedStep(null)
    updateValue(last.copy(
      targetApps = apps,
      targetPackage = apps.first().packageName,
      targetAppLabel = apps.first().label,
      participantCode = _reminder.value.participantCode,
      consentAccepted = hasCurrentConsent(),
      localOnly = Participation.localMode(getApplication()),
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
    if (accepted) Participation.setLocalMode(getApplication(), false)
    _participation.value = currentParticipation()
    update { copy(participantCode = participantCode, consentAccepted = accepted, localOnly = false, status = ReminderStatus.DRAFT) }
    if (accepted) refreshDashboard()
  }

  /** A2 «No participar»: la app funciona igual, pero no registra datos del estudio ni los envía. */
  fun useWithoutParticipating() {
    experiencePreferences.edit()
      .putBoolean("academic_consent_accepted", false)
      .remove("academic_consent_version")
      .remove("participant_code")
      .apply()
    Participation.setLocalMode(getApplication(), true)
    _participation.value = currentParticipation()
    update { copy(participantCode = "", consentAccepted = false, localOnly = true, status = ReminderStatus.DRAFT) }
    refreshDashboard()
  }

  fun applyPreset(activity: String, firstStep: String, place: String) {
    routeStore.setPreparedStep(null)
    update {
      copy(activity = activity, howToStart = firstStep, place = place,
        requiredUsageSeconds = if (requiredUsageSeconds < 60) 900 else requiredUsageSeconds,
        status = ReminderStatus.DRAFT)
    }
  }

  fun saveCustomActivity(activity: CustomActivity, apply: Boolean = true) {
    _customActivities.value = customActivityStore.upsert(activity)
    if (apply) applyPreset(activity.name, activity.firstStep, activity.place)
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
    _history.value = historyStore.load()
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
    if (!Participation.canUse(getApplication())) return false
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

  /** Prueba de sonido: una firma, que termina sola. [route] permite probar otra salida (E1). */
  fun testSignal(route: SignalRoute? = null): Boolean {
    val started = signalPlayer.play(route ?: _reminder.value.signalRoute, SignalPlayer.Pattern.TEST)
    if (started) viewModelScope.launch {
      delay(3_000)
      signalPlayer.stop()
    }
    return started
  }

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

  /**
   * Cierra el relevo con la respuesta declarada. Durante la prueba se agregan dos preguntas de un
   * toque (protocolo 02); null significa que no se respondieron. Si el relevo vino de la ruta, la
   * respuesta puede ofrecer el siguiente paso (R3) o cambiar la actividad.
   */
  fun completeEvaluation(outcome: String, knewIntention: String? = null, recalledFirstStep: String? = null) {
    AppUsageMonitorService.cancelSignalNotification(getApplication())
    historyStore.markOutcome(_reminder.value.sessionId, outcome)
    _history.value = historyStore.load()
    researchLog.completeSession(_reminder.value, outcome, knewIntention, recalledFirstStep)
    syncRemote()
    val stepId = routeStore.preparedStep() ?: return
    val track = _routes.value.firstOrNull { track -> track.steps.any { it.id == stepId } } ?: return
    val step = track.steps.first { it.id == stepId }
    if (!step.activity.equals(_reminder.value.activity.trim(), ignoreCase = true)) return
    when (outcome) {
      "started" -> {
        val starts = routeStore.addStart(stepId)
        val next = track.nextStep
        if (next != null && track.currentStep?.id == stepId && NextStepRule.shouldOffer(starts, hasNext = true, declined = routeStore.declined(stepId))) {
          _routeSuggestion.value = RouteSuggestion(track.interest, step, next, starts)
        }
      }
      "changed" -> _changedRouteInterest.value = track.interest
    }
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
    routeStore.setPreparedStep(null)
    store.clear()
    _reminder.value = Reminder(
      participantCode = experiencePreferences.getString("participant_code", null).orEmpty(),
      consentAccepted = hasCurrentConsent(),
      localOnly = Participation.localMode(getApplication()),
    )
    store.save(_reminder.value)
    _remainingSeconds.value = 0
    refreshStudy()
  }

  // ---- Perfil (P1–P3) y ruta (R1–R3): solo en el teléfono ----

  fun updateProfile(transform: Profile.() -> Profile) {
    val next = _profile.value.transform()
    profileStore.save(next)
    _profile.value = next
  }

  /** P3: guarda los intereses y ajusta las rutas, sin tocar las que la persona ya editó. */
  fun setInterests(interests: List<String>, other: String) {
    updateProfile { copy(interests = interests, otherInterest = other) }
    saveRoutes(Interests.reconcile(_routes.value, interests, other) { UUID.randomUUID().toString() })
  }

  fun completeProfileSetup() = updateProfile { copy(setupSeen = true) }

  fun saveTrack(track: RouteTrack) {
    val tracks = _routes.value
    saveRoutes(if (tracks.any { it.interest == track.interest }) tracks.map { if (it.interest == track.interest) track else it } else tracks + track)
  }

  fun setCurrentStep(interest: String, index: Int) {
    _routes.value.firstOrNull { it.interest == interest }?.let { saveTrack(it.moveTo(index)) }
  }

  /** Prepara un relevo con un paso de la ruta; su respuesta cuenta para ofrecer el siguiente (R3). */
  fun prepareFromStep(interest: String, stepId: String): Boolean {
    val step = _routes.value.firstOrNull { it.interest == interest }?.steps?.firstOrNull { it.id == stepId } ?: return false
    applyPreset(step.activity, step.firstStep, step.place)
    routeStore.setPreparedStep(step.id)
    return true
  }

  fun acceptNextStep() {
    val suggestion = _routeSuggestion.value ?: return
    _routes.value.firstOrNull { it.interest == suggestion.interest }?.let { saveTrack(it.advance()) }
    _routeSuggestion.value = null
  }

  fun declineNextStep() {
    _routeSuggestion.value?.let { routeStore.decline(it.current.id) }
    _routeSuggestion.value = null
  }

  /** Cerrar la hoja sin elegir: se vuelve a ofrecer tras el próximo «Comencé la actividad». */
  fun dismissNextStep() { _routeSuggestion.value = null }

  fun clearChangedRoute() { _changedRouteInterest.value = null }

  private fun saveRoutes(tracks: List<RouteTrack>) {
    routeStore.save(tracks)
    _routes.value = tracks
  }

  // ---- Ajustes (S2 y apariencia) ----

  fun updateSettings(transform: Settings.() -> Settings) {
    val previous = _settings.value
    val next = previous.transform()
    settingsStore.save(next)
    _settings.value = next
    if (next.returnNotice != previous.returnNotice) {
      if (next.returnNotice) {
        settingsStore.returnNotNow = 0
        settingsStore.turnOffAsked = false
        ReturnNotice.schedule(getApplication())
      } else ReturnNotice.cancel(getApplication())
    }
  }

  fun answerTurnOffReturn(turnOff: Boolean) {
    settingsStore.turnOffAsked = true
    settingsStore.returnNotNow = 0
    _askTurnOffReturn.value = false
    if (turnOff) updateSettings { copy(returnNotice = false) }
  }

  /**
   * «Preparar» desde el aviso de regreso: carga el último relevo para revisarlo o, si no hay uno que
   * repetir, abre la preparación desde el comienzo. Con un relevo en curso o una respuesta pendiente, no cambia nada.
   */
  fun prepareFromReturnNotice(): Boolean {
    settingsStore.returnNotNow = 0
    val status = _reminder.value.status
    if (status != ReminderStatus.DRAFT && status != ReminderStatus.READY) return false
    repeatLast()
    return true
  }

  // ---- Respuestas opcionales: opinión, problemas y «Tu semana» ----

  /** Opinión sobre la app: las estrellas califican la app, no a la persona. */
  fun submitFeedback(stars: Int?, comment: String) {
    val code = _reminder.value.participantCode
    stars?.let { researchLog.recordAnswer(code, "opinion_estrellas", it.toString()) }
    comment.trim().takeIf { it.isNotEmpty() }?.let { researchLog.recordAnswer(code, "opinion_comentario", it) }
    syncRemote()
  }

  /** Reporte de un problema. El registro técnico no incluye nada de lo que la persona hace en sus apps. */
  fun submitReport(text: String, attachLog: Boolean) {
    val code = _reminder.value.participantCode
    text.trim().takeIf { it.isNotEmpty() }?.let { researchLog.recordAnswer(code, "reporte_problema", it) }
    if (attachLog) researchLog.recordAnswer(code, "reporte_registro", technicalLog())
    syncRemote()
  }

  fun submitWeekNote(text: String) {
    text.trim().takeIf { it.isNotEmpty() }?.let { researchLog.recordAnswer(_reminder.value.participantCode, "tu_semana_ayudo", it) }
    syncRemote()
  }

  private fun technicalLog(): String {
    val status = _syncStatus.value
    val reminder = _reminder.value
    return listOf(
      "app=${BuildConfig.VERSION_NAME}",
      "android=${Build.VERSION.SDK_INT}",
      "estado=${reminder.status.name.lowercase()}",
      "salida=${reminder.signalRoute.name.lowercase()}",
      "tiempo_de_uso=${if (_usageAccessGranted.value) "si" else "no"}",
      "segundo_plano=${if (_backgroundUnrestricted.value) "sin_restriccion" else "con_restriccion"}",
      "contando=${AppUsageMonitorService.isCounting}",
      "pendientes=${status.pending}",
      "rechazados=${status.rejected}",
      "aviso=${status.lastError.orEmpty().take(160)}",
    ).joinToString(";")
  }

  /** «Descargar mis datos» (S3): todo lo guardado en el teléfono, en un archivo JSON que elige la persona. */
  fun exportData(uri: Uri, onDone: (Boolean) -> Unit) {
    viewModelScope.launch {
      val ok = withContext(Dispatchers.IO) {
        runCatching {
          val profile = _profile.value
          val json = JSONObject().apply {
            put("app", "Relevo ${BuildConfig.VERSION_NAME}")
            put("exportado", java.time.OffsetDateTime.now().toString())
            put("codigo_participacion", _reminder.value.participantCode.ifBlank { JSONObject.NULL })
            put("perfil", JSONObject().put("nombre", profile.name).put("imagen", profile.image).put("intereses", JSONArray(profile.interests)).put("otro_interes", profile.otherInterest))
            put("ruta", JSONArray().apply {
              _routes.value.forEach { track ->
                put(JSONObject().put("interes", track.title).put("paso_actual", track.currentIndex + 1).put("pasos", JSONArray().apply {
                  track.steps.forEach { put(JSONObject().put("actividad", it.activity).put("como_empieza", it.firstStep).put("lugar", it.place)) }
                }))
              }
            })
            put("actividades_propias", JSONArray().apply {
              _customActivities.value.forEach { put(JSONObject().put("nombre", it.name).put("como_empieza", it.firstStep).put("lugar", it.place)) }
            })
            put("relevos", JSONArray().apply {
              _history.value.forEach { entry ->
                put(JSONObject().put("actividad", entry.activity).put("apps", entry.appLabel).put("lugar", entry.place)
                  .put("segundos", entry.seconds).put("terminado", java.time.Instant.ofEpochMilli(entry.completedAt).toString())
                  .put("sono", entry.signalDelivered).put("respuesta", entry.outcome))
              }
            })
            put("registro_del_estudio", researchLog.exportJson())
          }
          getApplication<Application>().contentResolver.openOutputStream(uri)?.use { it.write(json.toString(2).toByteArray()) } != null
        }.getOrDefault(false)
      }
      onDone(ok)
    }
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
        profileStore.clear()
        routeStore.clear()
        ReturnNotice.cancel(getApplication())
        settingsStore.clear()
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
        _profile.value = Profile()
        _routes.value = emptyList()
        _settings.value = Settings()
        _participation.value = ParticipationMode.NONE
        _deletionStatus.value = "Datos eliminados. Si quieres volver a usar Relevo, tendrás que aceptar de nuevo las condiciones."
      } else {
        _deletionStatus.value = "Se detuvo el registro, pero no pudimos confirmar la eliminación. Tus datos siguen en el teléfono. Puedes reintentar o escribir a joan1542003@gmail.com."
      }
      deletingData = false
    }
  }

  private fun hasCurrentConsent(): Boolean = Participation.participating(getApplication())

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
