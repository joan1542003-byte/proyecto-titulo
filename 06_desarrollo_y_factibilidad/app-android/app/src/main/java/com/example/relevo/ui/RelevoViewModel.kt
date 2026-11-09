package com.example.relevo.ui

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.udp.relevo.BuildConfig
import com.example.relevo.data.ActiveStore
import com.example.relevo.data.AutoModeStore
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.CustomActivityStore
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.HistoryStore
import com.example.relevo.data.Participation
import com.example.relevo.data.Profile
import com.example.relevo.data.ProfileStore
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.RemoteSync
import com.example.relevo.data.ResearchBackup
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.data.RouteStore
import com.example.relevo.data.Settings
import com.example.relevo.data.SettingsStore
import com.example.relevo.data.SyncStatus
import com.example.relevo.data.TagStore
import com.example.relevo.domain.AutoMode
import com.example.relevo.domain.Interests
import com.example.relevo.domain.NextStepRule
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.RouteStep
import com.example.relevo.domain.RouteTrack
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.TagProtocol
import com.example.relevo.monitor.AppUsageMonitorService
import com.example.relevo.monitor.BackgroundAccess
import com.example.relevo.monitor.InstalledApp
import com.example.relevo.monitor.InstalledAppsRepository
import com.example.relevo.monitor.ProjectMessages
import com.example.relevo.monitor.ReturnNotice
import com.example.relevo.monitor.UsageAccess
import com.example.relevo.monitor.UsageAfterSignal
import com.example.relevo.signal.SignalPlayer
import com.example.relevo.signal.TagLink
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
import java.util.UUID

/** Si la persona aceptó el consentimiento vigente o todavía no. Sin aceptarlo no se usa Relevo (D-084). */
enum class ParticipationMode { ACCEPTED, NONE }

/** R3: la persona dijo varias veces que empezó el mismo paso; se le ofrece el siguiente, sin afirmar un hábito. */
data class RouteSuggestion(val interest: String, val current: RouteStep, val next: RouteStep, val starts: Int)

class RelevoViewModel(application: Application) : AndroidViewModel(application) {
  private val store = ReminderStore(application)
  /** Relevos que cuentan, varios a la vez (4.3, D-158). Se crea antes que [_reminder]: mueve el de la 4.2. */
  private val activeStore = ActiveStore(application).also { ActiveStore.migrate(application) }
  private val researchLog = ResearchLogStore(application)
  private val remoteSync = RemoteSync(application, researchLog)
  val remoteConfigured: Boolean get() = remoteSync.configured
  val deletionPending: Boolean get() = remoteSync.deletionPending
  private val historyStore = HistoryStore(application)
  private val customActivityStore = CustomActivityStore(application)
  private val profileStore = ProfileStore(application)
  private val routeStore = RouteStore(application)
  private val settingsStore = SettingsStore(application)
  private val autoModeStore = AutoModeStore(application)
  private val signalPlayer = SignalPlayer(application)
  private val appsRepository = InstalledAppsRepository(application)
  private val experiencePreferences = application.getSharedPreferences("relevo_experience", Application.MODE_PRIVATE)
  private val _reminder = MutableStateFlow(store.load())
  /** El borrador que se prepara, o el relevo que suena y espera la respuesta. */
  val reminder: StateFlow<Reminder> = _reminder.asStateFlow()
  private val _actives = MutableStateFlow(activeStore.load())
  /** Los relevos que están contando (4.3). */
  val actives: StateFlow<List<Reminder>> = _actives.asStateFlow()

  private val _customActivities = MutableStateFlow(customActivityStore.load())
  val customActivities: StateFlow<List<CustomActivity>> = _customActivities.asStateFlow()

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

  /**
   * La persona respondió «La dejé para después» y pidió dejarlo listo (1.0.0): Inicio lo ofrece para
   * activarlo con un toque, sin que vuelva a sonar solo. Guarda cuándo, para mostrarlo una sola vez.
   */
  private val _laterPending = MutableStateFlow(experiencePreferences.getLong("later_pending_at", 0L) > 0L)
  val laterPending: StateFlow<Boolean> = _laterPending.asStateFlow()

  /** Tras las primeras veces que suena, Inicio pregunta una vez si el tiempo elegido queda bien (1.0.0). */
  private val _limitReviewDue = MutableStateFlow(false)
  val limitReviewDue: StateFlow<Boolean> = _limitReviewDue.asStateFlow()

  /** Último relevo cuya tarjeta de regreso la persona cerró con «Ahora no». */
  private val _returnDismissedFor = MutableStateFlow(experiencePreferences.getLong("return_dismissed_for", 0L))
  val returnDismissedFor: StateFlow<Long> = _returnDismissedFor.asStateFlow()

  /** Llavero (D-109): el vinculado, la búsqueda y la última prueba. */
  private val tagStore = TagStore(application)
  private val _tag = MutableStateFlow(TagUi(linkedName = tagStore.name.takeIf { tagStore.linked }, heard = tagStore.heard, battery = tagStore.battery))
  val tag: StateFlow<TagUi> = _tag.asStateFlow()
  val tagStatus: StateFlow<TagLink.Status> = TagLink.status

  private val _participation = MutableStateFlow(currentParticipation())
  val participation: StateFlow<ParticipationMode> = _participation.asStateFlow()

  private val _profile = MutableStateFlow(profileStore.load())
  val profile: StateFlow<Profile> = _profile.asStateFlow()

  private val _routes = MutableStateFlow(routeStore.load())
  val routes: StateFlow<List<RouteTrack>> = _routes.asStateFlow()

  private val _settings = MutableStateFlow(settingsStore.load())
  val settings: StateFlow<Settings> = _settings.asStateFlow()

  /** Activación automática encendida (D-095). */
  private val _autoMode = MutableStateFlow(autoModeStore.enabled)
  val autoMode: StateFlow<Boolean> = _autoMode.asStateFlow()

  private val _routeSuggestion = MutableStateFlow<RouteSuggestion?>(null)
  val routeSuggestion: StateFlow<RouteSuggestion?> = _routeSuggestion.asStateFlow()

  /** Interés de la ruta cuyo paso la persona dejó con «Cambié de idea», para ofrecer cambiarlo. */
  private val _changedRouteInterest = MutableStateFlow<String?>(null)
  val changedRouteInterest: StateFlow<String?> = _changedRouteInterest.asStateFlow()

  /** Tras dos «Ahora no» seguidos en el aviso de regreso, se pregunta una sola vez si se apaga (V2). */
  private val _askTurnOffReturn = MutableStateFlow(false)
  val askTurnOffReturn: StateFlow<Boolean> = _askTurnOffReturn.asStateFlow()

  private var stateSyncJob: Job? = null

  // Guía de la primera vez (D-088): notas en preparar, señal y respuesta hasta completar el primer relevo.
  private fun loadGuide() = GuideState(
    prepare = !experiencePreferences.getBoolean("guide_prepare_done", false),
    signal = !experiencePreferences.getBoolean("guide_signal_done", false),
    decide = !experiencePreferences.getBoolean("guide_decide_done", false),
  )
  private val _guide = MutableStateFlow(loadGuide())
  val guide: StateFlow<GuideState> = _guide.asStateFlow()
  /** El primer relevo se acaba de activar: Inicio explica qué pasa ahora (D-090). */
  private val _firstActivated = MutableStateFlow(false)
  val firstActivated: StateFlow<Boolean> = _firstActivated.asStateFlow()

  /** Tiempo contado de un relevo que se está editando: sigue si cuenta las mismas apps (2.30). */
  private data class CarriedCount(val apps: Set<String>, val seconds: Int)
  private var carriedCount: CarriedCount? = null
  private val _editing = MutableStateFlow(false)
  /** Se está editando un relevo que ya estaba activo. */
  val editing: StateFlow<Boolean> = _editing.asStateFlow()

  private fun clearCarried() { carriedCount = null; _editing.value = false }
  fun dismissFirstActivated() { _firstActivated.value = false }

  private fun markGuide(key: String) {
    if (experiencePreferences.getBoolean(key, false)) return
    experiencePreferences.edit().putBoolean(key, true).apply()
    _guide.value = loadGuide()
  }

  // Estado del registro de uso: se declara antes de init, que ya lo usa.
  private var resumedAt = 0L
  private var lastScreen: String? = null
  private var lastPrepareStep: String? = null
  /** Usos de la guía antes de aceptar: se registran al aceptar. */
  private val beforeConsent = mutableListOf<Pair<String, String>>()
  private val _quickFeedbackDue = MutableStateFlow(false)
  val quickFeedbackDue: StateFlow<Boolean> = _quickFeedbackDue.asStateFlow()
  /** 4.6 (D-164): la encuesta del rediseño está lista para mostrarse sobre Inicio. */
  private val _redesignSurveyDue = MutableStateFlow(false)
  val redesignSurveyDue: StateFlow<Boolean> = _redesignSurveyDue.asStateFlow()
  private var redesignSurveyTimer: Job? = null
  private var redesignSurveyResumedAt = 0L
  /** 4.7 (D-175): el cierre de la prueba; null para quien no lo ve. */
  private val _closing = MutableStateFlow<ClosingStatus?>(null)
  internal val closing: StateFlow<ClosingStatus?> = _closing.asStateFlow()
  /** El cierre está listo para ofrecerse al abrir la app, una vez. */
  private val _closingOfferDue = MutableStateFlow(false)
  val closingOfferDue: StateFlow<Boolean> = _closingOfferDue.asStateFlow()

  init {
    _installedApps.value = appsRepository.launcherApps()
    when (currentParticipation()) {
      ParticipationMode.NONE -> {
        application.stopService(Intent(application, AppUsageMonitorService::class.java))
        // Quien aceptó una versión anterior conserva su código y su relevo: solo lee el texto nuevo (1.0.0).
        if (!Participation.acceptedBefore(application))
          updateValue(_reminder.value.copy(participantCode = "", consentAccepted = false, status = ReminderStatus.DRAFT))
      }
      ParticipationMode.ACCEPTED -> {
        val participantCode = experiencePreferences.getString("participant_code", null)
          ?: _reminder.value.participantCode.ifBlank { Participation.newCode() }
        experiencePreferences.edit().putString("participant_code", participantCode).apply()
        if (_reminder.value.participantCode != participantCode || !_reminder.value.consentAccepted)
          updateValue(_reminder.value.copy(participantCode = participantCode, consentAccepted = true))
      }
    }
    startStateSync()
    if (Participation.participating(application)) {
      refreshDashboard()
      if (_settings.value.returnNotice) ReturnNotice.schedule(application)
      ProjectMessages.schedule(application)
    }
    checkRedesignSurvey()
    checkClosingSurvey()
    onAppResumed()
  }

  // ---- Registro del uso de la app (desde 2.12) ----

  /**
   * Guarda un uso de la app con el código de la persona. Antes de aceptar, lo que pasa en la guía queda
   * en memoria y se guarda recién al aceptar, marcado como anterior; si la persona no acepta, se pierde.
   */
  private fun log(event: String, detail: String? = null) {
    if (!hasCurrentConsent()) {
      if (beforeConsent.size < 80) beforeConsent += event to listOfNotNull(detail, "antes_de_aceptar").joinToString(";")
      return
    }
    researchLog.logApp(_reminder.value.participantCode, event, detail)
  }


  fun onAppPaused() {
    stopRedesignSurveyTimer()
    if (resumedAt > 0L) log("app_cerrada", "segundos=${((System.currentTimeMillis() - resumedAt) / 1000L).coerceAtLeast(0)}")
    resumedAt = 0L
    lastScreen = null
    // Lo registrado se envía al salir de la app, sin esperar a la próxima vez.
    if (hasCurrentConsent()) syncRemote()
  }

  /** Pantalla que la persona tiene delante. Solo se guarda cuando cambia. */
  fun logScreen(screen: String) {
    if (screen == lastScreen) return
    lastScreen = screen
    log("pantalla", screen)
  }

  /**
   * 2.18: la persona tocó «Seguir» con algo sin completar; sirve para ver qué pasos cuestan. Los toques
   * repetidos con el mismo aviso se registran una vez cada 10 segundos.
   */
  fun onMissingField(step: String, missing: String) {
    val key = "$step|$missing"
    val now = System.currentTimeMillis()
    lastMissing?.let { (previous, at) -> if (previous == key && now - at < 10_000L) return }
    lastMissing = key to now
    log("falta_completar", "paso=$step;aviso=$missing")
  }
  private var lastMissing: Pair<String, Long>? = null

  fun onPrepareOpened(source: String) { lastPrepareStep = null; log("preparar_abierto", source) }
  fun onPrepareStep(step: String) { lastPrepareStep = step; log("preparar_paso", step) }
  fun onPrepareClosed() { log("preparar_cerrado", "paso=${lastPrepareStep.orEmpty()}") }


  /** Permisos que tiene Relevo; se registra cuando cambian. */
  private fun logPermissions() {
    val context = getApplication<Application>()
    val snapshot = listOf(
      "tiempo_de_uso=${if (_usageAccessGranted.value) "si" else "no"}",
      "notificaciones=${if (androidx.core.app.NotificationManagerCompat.from(context).areNotificationsEnabled()) "si" else "no"}",
      "bateria=${if (_backgroundUnrestricted.value) "sin_restriccion" else "con_restriccion"}",
    ).joinToString(";")
    if (experiencePreferences.getString("last_permissions", null) == snapshot) return
    experiencePreferences.edit().putString("last_permissions", snapshot).apply()
    log("permisos", snapshot)
  }

  // ---- Opinión rápida: después del tercer y del décimo relevo, una pregunta de un toque ----


  private fun refreshQuickFeedback() {
    val done = _history.value.count { it.outcome.isNotBlank() }
    _quickFeedbackDue.value = hasCurrentConsent() && QUICK_FEEDBACK_AT.any { done >= it && !experiencePreferences.getBoolean("quick_feedback_$it", false) }
  }

  /** [value] de 1 a 5, o null si la persona la cerró sin responder. */
  fun submitQuickFeedback(value: Int?) {
    val done = _history.value.count { it.outcome.isNotBlank() }
    experiencePreferences.edit().apply { QUICK_FEEDBACK_AT.filter { done >= it }.forEach { putBoolean("quick_feedback_$it", true) } }.apply()
    if (value != null) researchLog.recordAnswer(_reminder.value.participantCode, "opinion_rapida", value.toString()) else log("opinion_rapida_cerrada")
    _quickFeedbackDue.value = false
    syncRemote()
  }

  // ---- 4.6 (D-164): encuesta del rediseño, una vez, para quien ya usaba Relevo ----

  /** La primera vez que abre esta versión se decide si es alguien que ya usaba Relevo; después no cambia. */
  private fun checkRedesignSurvey() {
    if (experiencePreferences.getBoolean(RedesignSurvey.CHECKED, false)) return
    val eligible = RedesignSurvey.eligibleAtFirstRun(
      onboardingComplete = experiencePreferences.getBoolean("onboarding_complete", false),
      acceptedBefore = Participation.acceptedBefore(getApplication()),
      hasHistory = _history.value.isNotEmpty(),
    )
    experiencePreferences.edit().putBoolean(RedesignSurvey.CHECKED, true).putBoolean(RedesignSurvey.ELIGIBLE, eligible).apply()
    log("encuesta_rediseno_elegible", if (eligible) "si" else "no")
  }

  private fun redesignSurveyPending(): Boolean =
    hasCurrentConsent() && experiencePreferences.getBoolean(RedesignSurvey.ELIGIBLE, false) &&
      !experiencePreferences.getBoolean(RedesignSurvey.SHOWN, false) && !closingComesFirst()

  /**
   * 4.7: quien ve el cierre de la prueba lo ve antes que la encuesta del rediseño, y esta espera un día desde
   * que se le ofreció el cierre, para no pedir dos encuestas seguidas.
   */
  private fun closingComesFirst(): Boolean {
    if (!experiencePreferences.getBoolean(ClosingSurvey.ELIGIBLE, false)) return false
    val offeredAt = experiencePreferences.getLong(ClosingSurvey.OFFERED_AT, 0L)
    return offeredAt == 0L || System.currentTimeMillis() - offeredAt < ClosingSurvey.REDESIGN_WAIT_MILLIS
  }

  // ---- 4.7 (D-175): cierre de la prueba, para quien ya usaba Relevo ----

  /** La primera vez que abre esta versión se decide si la persona ya usaba Relevo; después no cambia. */
  private fun checkClosingSurvey() {
    if (!experiencePreferences.getBoolean(ClosingSurvey.CHECKED, false)) {
      val eligible = ClosingSurvey.eligibleAtFirstRun(
        onboardingComplete = experiencePreferences.getBoolean("onboarding_complete", false),
        acceptedBefore = Participation.acceptedBefore(getApplication()),
        hasHistory = _history.value.isNotEmpty(),
      )
      experiencePreferences.edit().putBoolean(ClosingSurvey.CHECKED, true).putBoolean(ClosingSurvey.ELIGIBLE, eligible).apply()
      log("encuesta_cierre_elegible", if (eligible) "si" else "no")
    }
    refreshClosing()
  }

  private fun refreshClosing() {
    val eligible = experiencePreferences.getBoolean(ClosingSurvey.ELIGIBLE, false)
    val done = experiencePreferences.getBoolean(ClosingSurvey.DONE, false)
    _closing.value = if (eligible) ClosingStatus(experiencePreferences.getInt(ClosingSurvey.PART, 0), done) else null
    _closingOfferDue.value = eligible && !done && hasCurrentConsent() && experiencePreferences.getLong(ClosingSurvey.OFFERED_AT, 0L) == 0L
  }

  /** Se ofreció al abrir la app: no vuelve a aparecer sola, pero queda en Ajustes. */
  fun markClosingOffered(answer: String) {
    if (experiencePreferences.getLong(ClosingSurvey.OFFERED_AT, 0L) == 0L) {
      experiencePreferences.edit().putLong(ClosingSurvey.OFFERED_AT, System.currentTimeMillis()).apply()
      log("encuesta_cierre_ofrecida", answer)
    }
    _closingOfferDue.value = false
  }

  /** Guarda una parte del cierre y deja anotada la siguiente; sin [next], el cierre está terminado. */
  fun saveClosingPart(part: Int, answers: List<Pair<String, String>>, next: Int?) {
    val code = _reminder.value.participantCode
    answers.forEach { (question, answer) -> researchLog.recordAnswer(code, question, answer) }
    log("encuesta_cierre_parte", "parte=${part + 1};respuestas=${answers.size}")
    experiencePreferences.edit()
      .putInt(ClosingSurvey.PART, next ?: ClosingSurvey.parts.size)
      .putBoolean(ClosingSurvey.DONE, next == null)
      .apply()
    if (next == null) log("encuesta_cierre_terminada")
    refreshClosing()
    syncRemote()
  }

  /** Cuenta el tiempo con la app abierta, sumado entre aperturas, hasta un minuto. */
  private fun startRedesignSurveyTimer() {
    redesignSurveyTimer?.cancel()
    if (!redesignSurveyPending() || _redesignSurveyDue.value) return
    redesignSurveyResumedAt = System.currentTimeMillis()
    val remaining = RedesignSurvey.remainingMillis(experiencePreferences.getLong(RedesignSurvey.FOREGROUND_MS, 0L))
    redesignSurveyTimer = viewModelScope.launch {
      delay(remaining)
      if (redesignSurveyPending()) _redesignSurveyDue.value = true
    }
  }

  private fun stopRedesignSurveyTimer() {
    redesignSurveyTimer?.cancel()
    redesignSurveyTimer = null
    if (redesignSurveyResumedAt == 0L) return
    val spent = (System.currentTimeMillis() - redesignSurveyResumedAt).coerceAtLeast(0L)
    redesignSurveyResumedAt = 0L
    val total = experiencePreferences.getLong(RedesignSurvey.FOREGROUND_MS, 0L) + spent
    experiencePreferences.edit().putLong(RedesignSurvey.FOREGROUND_MS, total.coerceAtMost(RedesignSurvey.AFTER_MILLIS)).apply()
  }

  /** Se marca al aparecer: aunque la cierre sin responder, no vuelve a salir. */
  fun markRedesignSurveyShown() {
    if (experiencePreferences.getBoolean(RedesignSurvey.SHOWN, false)) return
    experiencePreferences.edit().putBoolean(RedesignSurvey.SHOWN, true).apply()
    redesignSurveyTimer?.cancel()
    log("encuesta_rediseno_vista")
  }

  internal fun submitRedesignSurvey(answers: RedesignAnswers) {
    val code = _reminder.value.participantCode
    answers.toAnswers().forEach { (question, answer) -> researchLog.recordAnswer(code, question, answer) }
    log("encuesta_rediseno_enviada", "respuestas=${answers.toAnswers().size}")
    _redesignSurveyDue.value = false
    syncRemote()
  }

  fun dismissRedesignSurvey() {
    log("encuesta_rediseno_cerrada")
    _redesignSurveyDue.value = false
    syncRemote()
  }

  private fun currentParticipation(): ParticipationMode =
    if (Participation.participating(getApplication())) ParticipationMode.ACCEPTED else ParticipationMode.NONE

  /** Al volver a la app: comprueba permisos, retoma un conteo interrumpido y reintenta el envío pendiente. */
  fun onAppResumed() {
    _usageAccessGranted.value = UsageAccess.isGranted(getApplication())
    _backgroundUnrestricted.value = BackgroundAccess.isUnrestricted(getApplication())
    _participation.value = currentParticipation()
    if (resumedAt == 0L) { resumedAt = System.currentTimeMillis(); log("app_abierta") }
    logPermissions()
    refreshQuickFeedback()
    refreshLimitReview()
    refreshClosing()
    startRedesignSurveyTimer()
    settingsStore.lastOpenedAt = System.currentTimeMillis()
    ReturnNotice.dismiss(getApplication())
    if (settingsStore.returnNotNow >= 2 && !settingsStore.turnOffAsked && _settings.value.returnNotice) _askTurnOffReturn.value = true
    ensureRoute()
    val current = _reminder.value
    _actives.value = activeStore.load()
    if (_actives.value.isNotEmpty() && _usageAccessGranted.value && Participation.participating(getApplication()) && !AppUsageMonitorService.isCounting) {
      ContextCompat.startForegroundService(
        getApplication(),
        Intent(getApplication(), AppUsageMonitorService::class.java).setAction(AppUsageMonitorService.ACTION_RESTORE),
      )
    }
    // Si Android cerró la app mientras sonaba, la señal ya no suena: la pantalla debe decirlo.
    if (current.status == ReminderStatus.SIGNALLED && !current.signalEnded && !AppUsageMonitorService.isCounting) {
      updateValue(current.endSignal())
    }
    if (_actives.value.isEmpty()) startWatchingIfNeeded()
    if (hasCurrentConsent()) {
      viewModelScope.launch(Dispatchers.IO) {
        UsageAfterSignal.update(getApplication(), researchLog)
        syncRemote()
        ProjectMessages.check(getApplication())
      }
    } else refreshSyncStatus()
  }

  // ---- Activación automática (D-095) ----

  /**
   * Enciende o apaga la activación automática. Usa el último relevo: sin uno completo que repetir, no se
   * enciende y devuelve false. Al encenderla, Relevo espera en segundo plano a que se abra una de sus apps.
   */
  fun setAutoMode(enabled: Boolean): Boolean {
    val last = _lastReminder.value
    if (enabled && !AutoMode.usable(last)) return false
    autoModeStore.enabled = enabled
    _autoMode.value = enabled
    log("activacion_automatica", if (enabled) "si;${last?.activity.orEmpty()};${last?.selectedApps?.joinToString(",") { it.label }.orEmpty()}" else "no")
    if (enabled) startWatchingIfNeeded()
    else stopServiceIfIdle()
    return true
  }

  /** Con la activación automática encendida, el servicio espera en segundo plano si no está contando ni esperando. */
  private fun startWatchingIfNeeded() {
    val app = getApplication<Application>()
    if (!autoModeStore.enabled || !Participation.participating(app) || !UsageAccess.isGranted(app)) return
    if (AppUsageMonitorService.isCounting || AppUsageMonitorService.isWatching) return
    runCatching { ContextCompat.startForegroundService(app, Intent(app, AppUsageMonitorService::class.java)) }
  }

  /** Terminó un relevo: el siguiente automático espera la pausa desde ahora. */
  private fun markRelevoClosed() { autoModeStore.lastClosedAt = System.currentTimeMillis() }

  // ---- Con qué suena, el tiempo y lo que queda para después (1.0.0) ----

  /** El Tag es la salida por defecto (D-117): sin una elección previa, queda elegido. */
  private fun ensureRoute() {
    val current = _reminder.value
    if (!current.routeChosen && current.status != ReminderStatus.WAITING && current.status != ReminderStatus.SIGNALLED) {
      updateValue(current.copy(signalRoute = SignalRoute.TAG, routeChosen = true))
    }
  }

  /**
   * Tras 3 relevos que sonaron, una pregunta, una sola vez: si el tiempo elegido queda bien. Responde a lo que
   * mostró la prueba: con 45 minutos, al sonar la persona ya estaba muy metida en un video (Tabla 4).
   */
  private fun refreshLimitReview() {
    val sounded = _history.value.count { it.signalDelivered }
    _limitReviewDue.value = hasCurrentConsent() && sounded >= LIMIT_REVIEW_AFTER && !experiencePreferences.getBoolean("limit_review_done", false)
  }

  /** [change]: la persona quiere cambiar el tiempo; si no, le queda bien así. */
  fun answerLimitReview(change: Boolean) {
    log("revisar_tiempo", if (change) "cambiar" else "esta_bien")
    experiencePreferences.edit().putBoolean("limit_review_done", true).apply()
    _limitReviewDue.value = false
  }

  /** «Activar ahora» desde Inicio: el relevo que quedó para después, tal como estaba. */
  fun activateLater(): Boolean {
    if (!repeatLast()) return false
    clearLater()
    log("para_despues_activado", _reminder.value.activity)
    return activate()
  }

  fun dismissLater() {
    log("para_despues_ahora_no")
    clearLater()
  }

  private fun clearLater() {
    experiencePreferences.edit().remove("later_pending_at").apply()
    _laterPending.value = false
  }


  fun dismissReturn(lastCompletedAt: Long) {
    log("tarjeta_regreso_ahora_no")
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
    clearCarried()
    log("repetir_ultimo", last.activity)
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
      autoActivated = false,
      sessionId = "",
      observedUsageSeconds = 0,
      signalDelivered = false,
      signalAt = 0L,
      signalEnded = false,
      soundedOnPhone = false,
      status = ReminderStatus.DRAFT,
    ))
    ensureRoute()
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

  /** De 1 minuto a 6 horas, el rango que ofrece la pantalla de preparar. */
  fun updateRequiredUsage(seconds: Int) =
    update { copy(requiredUsageSeconds = seconds.coerceIn(60, 6 * 60 * 60), status = ReminderStatus.DRAFT) }

  /** Con qué suena: el Tag, una notificación en el teléfono o un dispositivo de audio. */
  fun updateSignalRoute(route: SignalRoute) {
    log("salida_elegida", route.name.lowercase())
    update { copy(signalRoute = route, routeChosen = true, status = ReminderStatus.DRAFT) }
  }

  fun updateConsent(accepted: Boolean) {
    if (accepted && remoteSync.deletionPending) return
    if (accepted) _deletionStatus.value = null
    val participantCode = if (accepted) experiencePreferences.getString("participant_code", null)
      ?: Participation.newCode() else ""
    experiencePreferences.edit()
      .putBoolean("academic_consent_accepted", accepted)
      .putString("academic_consent_version", if (accepted) ResearchLogStore.CONSENT_VERSION else null)
      .putString("participant_code", if (accepted) participantCode else null)
      .apply()
    _participation.value = currentParticipation()
    // Los relevos que contaban antes de leer el texto nuevo siguen contando: no se pierden (4.4).
    val resumes = accepted && _actives.value.isNotEmpty()
    update { copy(participantCode = participantCode, consentAccepted = accepted, status = ReminderStatus.DRAFT) }
    if (resumes && _usageAccessGranted.value) {
      ContextCompat.startForegroundService(
        getApplication(),
        Intent(getApplication(), AppUsageMonitorService::class.java).setAction(AppUsageMonitorService.ACTION_RESTORE),
      )
    }
    if (accepted) {
      log("consentimiento_aceptado", ResearchLogStore.CONSENT_VERSION)
      ProjectMessages.schedule(getApplication())
      if (_profile.value.name.isNotBlank()) remoteSync.markNamePending()
      beforeConsent.forEach { (event, detail) -> researchLog.logApp(participantCode, event, detail) }
      beforeConsent.clear()
      resumedAt = System.currentTimeMillis()
      logPermissions()
      if (_settings.value.returnNotice) ReturnNotice.schedule(getApplication())
      refreshDashboard()
      // 4.6: quien venía de una versión anterior empieza a contar el minuto de la encuesta al aceptar.
      startRedesignSurveyTimer()
      // 4.7: y, si le toca, ve el cierre de la prueba apenas vuelve a Inicio.
      refreshClosing()
      // Envía lo pendiente y actualiza la copia en el teléfono sin esperar a que la app vuelva a abrirse.
      syncRemote()
    }
  }

  fun applyPreset(activity: String, firstStep: String, place: String) {
    log("actividad_elegida", activity)
    routeStore.setPreparedStep(null)
    update {
      copy(activity = activity, howToStart = firstStep, place = place,
        requiredUsageSeconds = if (requiredUsageSeconds < 60) Reminder.DEFAULT_LIMIT_SECONDS else requiredUsageSeconds,
        status = ReminderStatus.DRAFT)
    }
  }

  fun saveCustomActivity(activity: CustomActivity, apply: Boolean = true) {
    log("actividad_propia_guardada", "${activity.name};${activity.firstStep};${activity.place}")
    _customActivities.value = customActivityStore.upsert(activity)
    if (apply) applyPreset(activity.name, activity.firstStep, activity.place)
  }

  fun deleteCustomActivity(id: String) {
    log("actividad_propia_borrada", _customActivities.value.firstOrNull { it.id == id }?.name)
    _customActivities.value = customActivityStore.delete(id)
  }

  /** Marca o desmarca una de las apps de la persona, en Perfil (4.3). */
  fun togglePreferredApp(app: InstalledApp) {
    val current = _profile.value.apps
    val next = if (current.any { it.packageName == app.packageName }) current.filterNot { it.packageName == app.packageName }
      else current + com.example.relevo.domain.TrackedApp(app.packageName, app.label)
    log("perfil_apps", next.size.toString())
    updateProfile { copy(apps = next) }
  }

  /**
   * Al abrir Preparar, un relevo sin apps toma las de Perfil que sigan instaladas (4.3). No toca uno que ya
   * tiene apps ni uno que está contando.
   */
  fun applyPreferredApps() {
    val draft = _reminder.value
    if (draft.selectedApps.isNotEmpty()) return
    val installed = _installedApps.value.map { it.packageName }.toSet()
    val apps = _profile.value.apps.filter { installed.isEmpty() || it.packageName in installed }
    if (apps.isEmpty()) return
    update { copy(targetApps = apps, targetPackage = apps.first().packageName, targetAppLabel = apps.first().label) }
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
    if (!Participation.participating(getApplication())) return false
    refreshUsageAccess()
    if (!_usageAccessGranted.value) return false
    ensureRoute()
    val prepared = _reminder.value.copy(autoActivated = false)
    // Un relevo editado sigue con el tiempo que llevaba si cuenta las mismas apps (2.30).
    val carried = carriedCount?.takeIf { it.apps == prepared.selectedApps.map { app -> app.packageName }.toSet() }?.seconds ?: 0
    val armed = prepared.arm(UUID.randomUUID().toString())
    val next = if (carried > 0 && armed.status == ReminderStatus.WAITING) armed.copy(observedUsageSeconds = carried.coerceAtMost(armed.requiredUsageSeconds - 1)) else armed
    if (next.status == ReminderStatus.WAITING) clearCarried()
    if (next.status != ReminderStatus.WAITING) { updateValue(next); return false }
    // 4.3 (D-158): el relevo pasa a los activos y el borrador queda libre para preparar otro.
    activeStore.add(next)
    _actives.value = activeStore.load()
    updateValue(restoreDraft(next))
    if (_guide.value.prepare) _firstActivated.value = true
    markGuide("guide_prepare_done")
    // Con un relevo nuevo contando, lo que había quedado para después ya no se ofrece.
    if (_laterPending.value) clearLater()
    researchLog.record(next.sessionId, next.participantCode, "armed", next.targetPackage, 0)
    researchLog.startSession(next)
    syncRemote()
    ContextCompat.startForegroundService(
      getApplication(),
      Intent(getApplication(), AppUsageMonitorService::class.java),
    )
    // 4.6: activar un relevo es uno de los dos momentos de la encuesta del rediseño.
    if (redesignSurveyPending()) _redesignSurveyDue.value = true
    return true
  }

  /** Prueba de sonido: una firma, que termina sola. [route] permite probar otra salida (E1). */
  fun testSignal(route: SignalRoute? = null): Boolean {
    val started = signalPlayer.play(route ?: _reminder.value.signalRoute, SignalPlayer.Pattern.TEST)
    log("prueba_de_sonido", "salida=${(route ?: _reminder.value.signalRoute).name.lowercase()};sono=${if (started) "si" else "no"}")
    if (started) viewModelScope.launch {
      delay(3_000)
      signalPlayer.stop()
    }
    return started
  }

  // ---- Llavero (D-109) ----

  /** Busca llaveros cerca durante unos 12 s y los ordena del más cercano al más lejano. */
  fun searchTags() = searchNearby(all = false)

  /** Respaldo si el llavero no aparece: muestra todos los aparatos con nombre (D-109). */
  fun searchAllDevices() = searchNearby(all = true)

  private fun searchNearby(all: Boolean) {
    if (_tag.value.searching) return
    _tag.value = _tag.value.copy(searching = true, found = emptyList(), searched = false, problem = null, searchedAll = all)
    log("llavero_busqueda", if (all) "todos" else null)
    viewModelScope.launch(Dispatchers.IO) {
      val problem = TagLink.search(getApplication(), all = all) { found ->
        val others = _tag.value.found.filterNot { it.address == found.address }
        _tag.value = _tag.value.copy(found = (others + found).sortedByDescending { it.rssi })
      }
      _tag.value = _tag.value.copy(searching = false, searched = true, problem = problem)
      log("llavero_encontrados", "${_tag.value.found.size};${problem?.name?.lowercase() ?: "ok"}")
    }
  }

  /** Guarda el llavero elegido y lo hace pitar una vez para confirmar que es el correcto. */
  fun linkTag(found: TagLink.Found) {
    tagStore.save(found.address, found.name)
    // Sin el nombre del aparato: solo este teléfono sabe cuál es el llavero.
    log("llavero_vinculado")
    _tag.value = _tag.value.copy(linkedName = tagStore.name, found = emptyList(), searched = false, test = TagTest.IDLE, heard = false)
    testTag()
  }

  /**
   * Prueba el Tag: se conecta si hace falta, le pide pitar 2 s y pregunta si se escuchó. Que el Tag
   * acepte la orden no prueba que haya pitado (2.26): solo la persona lo sabe. No bloquea la pantalla.
   */
  // Empieza por el nivel que la persona ya confirmó; si nunca lo confirmó, por el primero (2.29).
  fun testTag() = runTagTest(if (tagStore.heard) TagProtocol.tryIndex(tagStore.alertLevel) else 0, retry = false)

  /**
   * La persona dice si escuchó el pitido. Si no, se prueba la forma siguiente de hacerlo pitar; si ya no
   * quedan, se vuelve a la primera y se explica qué hacer.
   */
  fun tagHeard(heard: Boolean) {
    val current = _tag.value
    if (current.test != TagTest.ASKING) return
    log("llavero_escuchado", "${if (heard) "si" else "no"};intento=${current.attempt + 1}")
    tagStore.heard = heard
    if (heard) {
      _tag.value = current.copy(test = TagTest.SOUNDED, heard = true, silent = false)
      return
    }
    val next = TagProtocol.nextTry(current.attempt)
    if (next != null) {
      _tag.value = current.copy(heard = false)
      runTagTest(next, retry = true)
      return
    }
    tagStore.alertLevel = TagProtocol.ALERT_LEVELS.first()
    _tag.value = current.copy(test = TagTest.FAILED, problem = null, heard = false, silent = true, attempt = 0)
  }

  private fun runTagTest(attempt: Int, retry: Boolean) {
    val address = tagStore.address ?: return
    if (_tag.value.test == TagTest.WORKING) return
    val level = TagProtocol.ALERT_LEVELS[attempt]
    tagStore.alertLevel = level
    _tag.value = _tag.value.copy(test = TagTest.WORKING, problem = null, attempt = attempt, retry = retry, silent = false)
    viewModelScope.launch(Dispatchers.IO) {
      val app = getApplication<Application>()
      val connected = TagLink.connect(app, address)
      val sent = connected && TagLink.beep(app, TagProtocol.durationMillis(test = true))
      val status = TagLink.status.value
      // Un aparato que no sabe pitar no queda elegido: se vuelve a buscar, con el motivo a la vista.
      if (!sent && status.problem == TagLink.Problem.NOT_A_TAG) {
        tagStore.clear()
        _tag.value = TagUi(problem = TagLink.Problem.NOT_A_TAG)
        log("prueba_de_sonido", "salida=tag;orden=no;no_es_llavero")
        TagLink.idle()
        return@launch
      }
      val battery = status.battery ?: tagStore.battery
      _tag.value = _tag.value.copy(
        test = if (sent) TagTest.ASKING else TagTest.FAILED,
        problem = if (sent) null else status.problem,
        button = status.button,
        linkLossOff = status.linkLossOff,
        battery = battery,
      )
      // Desde 2.31 también cómo quedó el Tag al callarlo y la carga de su pila; desde 2.32, su respuesta más
      // lenta y si la conexión se abrió para esta prueba.
      log(
        "prueba_de_sonido",
        "salida=tag;orden=${if (sent) "si" else "no"};intento=${attempt + 1};nivel=$level;" +
          "boton=${if (status.button) "si" else "no"};" +
          "alarma_desconexion=${if (status.linkLossOff) "apagada" else "sin_apagar"}" +
          (if (connected) ";apagado=${TagLink.lastOff.name.lowercase()};respuesta_ms=${TagLink.slowestMillis};conexion=${if (TagLink.freshConnection) "nueva" else "abierta"}" else "") +
          (battery?.let { ";pila=$it" } ?: ""),
      )
      // Cómo es este modelo por dentro, una vez por prueba: servicios y propiedades, sin su dirección.
      if (connected && !retry) TagLink.profile?.let { log("llavero_perfil", it.take(600)) }
      // Si ningún relevo usa el llavero, se desconecta para no gastar su pila.
      TagLink.idle()
    }
  }

  /** El Bluetooth se encendió después del aviso: sin llavero elegido vuelve a buscar; con uno, borra el aviso. */
  fun bluetoothTurnedOn() {
    val current = _tag.value
    if (current.problem != TagLink.Problem.BLUETOOTH_OFF) return
    if (current.linkedName == null) searchNearby(current.searchedAll) else _tag.value = current.copy(problem = null, test = TagTest.IDLE)
  }

  /** Olvida el llavero vinculado, por ejemplo para elegir otro. No se usa con un relevo activo. */
  fun forgetTag() {
    if (_actives.value.any { it.signalRoute == SignalRoute.TAG }) return
    tagStore.clear()
    TagLink.idle()
    log("llavero_olvidado")
    _tag.value = TagUi()
  }

  /** El relevo activo de una sesión, si sigue activo. */
  private fun activeOf(sessionId: String): Reminder? = activeStore.load().firstOrNull { it.sessionId == sessionId }

  /**
   * Desactiva un relevo antes de que suene. Como antes, pasa a «¿Qué decidiste?»: queda en primer plano con
   * su respuesta pendiente; si había un borrador a medias, se guarda y vuelve al terminar (4.3).
   */
  fun disarm(sessionId: String) {
    val current = activeOf(sessionId) ?: return
    markRelevoClosed()
    historyStore.add(current)
    _history.value = historyStore.load()
    researchLog.record(current.sessionId, current.participantCode, "disarmed", current.targetPackage, current.observedUsageSeconds)
    val closedAt = System.currentTimeMillis()
    viewModelScope.launch(Dispatchers.IO) { researchLog.markAppSeconds(current.sessionId, closedAt) }
    activeStore.remove(sessionId)
    _actives.value = activeStore.load()
    parkDraft()
    updateValue(current.disarm())
    stopServiceIfIdle()
  }

  /**
   * 2.18: elimina un relevo activo, por ejemplo uno activado por error. Deja de contar y no sonará; no
   * entra al historial ni pasa a ser el último relevo (que repite la activación automática). En la base
   * queda registrado como `deleted`, con su evento, para que el estudio sepa que existió.
   */
  /**
   * 2.30: editar un relevo activo sin borrarlo ni crearlo de nuevo. Mientras se edita deja de contar; la
   * sesión anterior queda como `deleted`, con el evento `relevo_editado`, y al activarlo empieza otra.
   * Si cuenta las mismas apps, sigue con el tiempo que ya llevaba. Desde 4.3 ocupa el borrador; si había
   * otro a medias, se guarda y vuelve después.
   */
  fun editActive(sessionId: String): Boolean {
    val current = activeOf(sessionId) ?: return false
    researchLog.record(current.sessionId, current.participantCode, "disarmed", current.targetPackage, current.observedUsageSeconds)
    researchLog.completeSession(current, "deleted")
    log("relevo_editado", "${current.activity};segundos=${current.observedUsageSeconds}")
    markRelevoClosed()
    activeStore.remove(sessionId)
    _actives.value = activeStore.load()
    parkDraft()
    carriedCount = CarriedCount(current.selectedApps.map { it.packageName }.toSet(), current.observedUsageSeconds)
    _editing.value = true
    updateValue(current.copy(status = ReminderStatus.DRAFT, sessionId = "", signalDelivered = false, signalAt = 0L, signalEnded = false, autoActivated = false))
    stopServiceIfIdle()
    syncRemote()
    return true
  }

  fun deleteActive(sessionId: String) {
    val current = activeOf(sessionId) ?: return
    researchLog.record(current.sessionId, current.participantCode, "disarmed", current.targetPackage, current.observedUsageSeconds)
    researchLog.completeSession(current, "deleted")
    log("relevo_eliminado", "${current.activity};segundos=${current.observedUsageSeconds};${if (current.autoActivated) "solo" else "a_mano"}")
    activeStore.remove(sessionId)
    _actives.value = activeStore.load()
    stopServiceIfIdle()
    syncRemote()
  }

  /** Guarda el borrador que se estaba preparando, si tiene algo, para devolverlo después (4.3). */
  private fun parkDraft() {
    val draft = _reminder.value
    if (draft.status == ReminderStatus.DRAFT || draft.status == ReminderStatus.READY) {
      if (draft.activity.isNotBlank() || draft.selectedApps.isNotEmpty()) activeStore.park(draft)
    }
  }

  /** El borrador que vuelve: el que se guardó, o uno vacío con el código y el consentimiento de [base]. */
  private fun restoreDraft(base: Reminder): Reminder =
    activeStore.takeParked()?.copy(status = ReminderStatus.DRAFT)
      ?: Reminder(participantCode = base.participantCode, consentAccepted = hasCurrentConsent())

  /** Sin relevos activos ni activación automática, el servicio se detiene; con alguno, sigue contando. */
  private fun stopServiceIfIdle() {
    if (_actives.value.isNotEmpty() || autoModeStore.enabled) return
    val focus = _reminder.value.status
    if (focus == ReminderStatus.SIGNALLED) return
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
  }

  /**
   * Primera acción de la persona en la pantalla de señal. Si el sonido seguía, lo silencia; si ya
   * había terminado, solo registra la respuesta. En ambos casos guarda cuánto tardó en responder.
   */
  fun silence() {
    markGuide("guide_signal_done")
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
   * Cierra el relevo con la respuesta de la persona. Las preguntas de un toque que van antes son
   * opcionales: null significa que no se respondieron. [keepForLater]: con «La dejé para después», la
   * persona pidió dejarlo listo para activarlo con un toque desde Inicio (1.0.0). Si el relevo vino de un
   * paso de Actividades, la respuesta puede ofrecer el siguiente (R3) o cambiar la actividad.
   */
  fun completeEvaluation(
    outcome: String,
    knewIntention: String? = null,
    recalledFirstStep: String? = null,
    feeling: String? = null,
    noticed: String? = null,
    keepForLater: Boolean = false,
  ) {
    AppUsageMonitorService.cancelSignalNotification(getApplication())
    // Si notó el sonido enseguida, un rato después o no lo notó (2.33).
    noticed?.let { researchLog.recordAnswer(_reminder.value.participantCode, "percepcion_senal", it, _reminder.value.sessionId) }
    if (keepForLater) {
      experiencePreferences.edit().putLong("later_pending_at", System.currentTimeMillis()).apply()
      _laterPending.value = true
      log("para_despues_guardado", _reminder.value.activity)
    }
    markRelevoClosed()
    historyStore.markOutcome(_reminder.value.sessionId, outcome)
    _history.value = historyStore.load()
    markGuide("guide_decide_done")
    researchLog.completeSession(_reminder.value, outcome, knewIntention, recalledFirstStep, feeling)
    syncRemote()
    refreshQuickFeedback()
    refreshLimitReview()
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

  /** Vuelve a Inicio sin relevo. [keepAsLast]: el relevo terminado pasa a ser el último, para repetirlo. */
  fun reset(keepAsLast: Boolean = true) {
    clearCarried()
    if (_reminder.value.sessionId.isNotBlank()) {
      markRelevoClosed()
      // 4.6.3: el relevo que ya sonó y se respondió no puede seguir entre los activos; si quedó ahí (por el
      // paso desde la 4.2 de antes, ver [ActiveStore.migrate]), volvía a sonar al responder.
      activeStore.remove(_reminder.value.sessionId)
    }
    signalPlayer.stop()
    _reminder.value.takeIf { keepAsLast && it.activity.isNotBlank() && it.selectedApps.isNotEmpty() }?.let { finished ->
      val configuration = finished.copy(
        sessionId = "", observedUsageSeconds = 0, signalDelivered = false, status = ReminderStatus.DRAFT,
        signalAt = 0L, signalEnded = false, autoActivated = false, soundedOnPhone = false,
      )
      lastStore.save(configuration)
      _lastReminder.value = configuration
    }
    routeStore.setPreparedStep(null)
    store.clear()
    _reminder.value = restoreDraft(Reminder(participantCode = experiencePreferences.getString("participant_code", null).orEmpty(), consentAccepted = hasCurrentConsent()))
    store.save(_reminder.value)
    _actives.value = activeStore.load()
    stopServiceIfIdle()
    ensureRoute()
    startWatchingIfNeeded()
  }

  // ---- Perfil (P1–P3) y ruta (R1–R3): solo en el teléfono ----

  fun updateProfile(transform: Profile.() -> Profile) {
    val previous = _profile.value
    val next = previous.transform()
    if (next.image != previous.image) log("perfil_imagen", next.image)
    if (next.name.isBlank() != previous.name.isBlank()) log("perfil_nombre", if (next.name.isBlank()) "sin_nombre" else "con_nombre")
    // D-089: el nombre se envía aparte, solo con el código.
    if (next.name.trim() != previous.name.trim() && next.name.isNotBlank()) { remoteSync.markNamePending(); syncRemote() }
    profileStore.save(next)
    _profile.value = next
  }

  /** P3: guarda los intereses y ajusta las rutas, sin tocar las que la persona ya editó. */
  fun setInterests(interests: List<String>, other: String) {
    log("intereses", (interests + other.trim()).filter { it.isNotBlank() }.joinToString(";"))
    updateProfile { copy(interests = interests, otherInterest = other) }
    saveRoutes(Interests.reconcile(_routes.value, interests, other) { UUID.randomUUID().toString() })
  }

  fun completeProfileSetup() { log("perfil_listo"); updateProfile { copy(setupSeen = true) } }

  fun saveTrack(track: RouteTrack) {
    log("ruta_guardada", "interes=${track.interest};pasos=${track.steps.size};actual=${track.currentIndex + 1}")
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
    log("ruta_siguiente_paso", "acepto;${suggestion.next.activity}")
    _routes.value.firstOrNull { it.interest == suggestion.interest }?.let { saveTrack(it.advance()) }
    _routeSuggestion.value = null
  }

  fun declineNextStep() {
    _routeSuggestion.value?.let { log("ruta_siguiente_paso", "sigo_en_este;${it.current.activity}"); routeStore.decline(it.current.id) }
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

  /** Elige el sonido de la señal y lo hace sonar una vez en el teléfono (4.3). Queda en el registro, por D-078. */
  fun chooseSound(sonido: com.example.relevo.signal.Sonido) {
    log("sonido", sonido.id)
    updateSettings { copy(sound = sonido.id) }
    signalPlayer.play(SignalRoute.PHONE, SignalPlayer.Pattern.TEST)
  }

  fun updateSettings(transform: Settings.() -> Settings) {
    val previous = _settings.value
    val next = previous.transform()
    if (next != previous) log("ajuste", next.toString().substringAfter('(').removeSuffix(")"))
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
    log("aviso_semanal_apagar", if (turnOff) "si" else "no")
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
    _deletionStatus.value = "Borrando tus datos…"
    remoteSync.beginDeletion()
    getApplication<Application>().stopService(Intent(getApplication(), AppUsageMonitorService::class.java))
    signalPlayer.stop()
    experiencePreferences.edit().putBoolean("academic_consent_accepted", false).remove("academic_consent_version").apply()
    updateValue(_reminder.value.copy(consentAccepted = false, status = ReminderStatus.DRAFT))
    viewModelScope.launch(Dispatchers.IO) {
      val deleted = remoteSync.deleteOwnResearchData()
      if (deleted) {
        ResearchBackup.delete(getApplication())
        researchLog.clearAll()
        historyStore.clear()
        customActivityStore.clear()
        profileStore.clear()
        routeStore.clear()
        ReturnNotice.cancel(getApplication())
        ProjectMessages.clear(getApplication())
        autoModeStore.clear()
        _autoMode.value = false
        settingsStore.clear()
        store.clear()
        lastStore.clear()
        _lastReminder.value = null
        _laterPending.value = false
        _limitReviewDue.value = false
        tagStore.clear()
        TagLink.release()
        _tag.value = TagUi()
        _returnDismissedFor.value = 0L
        remoteSync.clearCredentials()
        experiencePreferences.edit().clear().apply()
        val code = Participation.newCode()
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
        _deletionStatus.value = DELETED_MESSAGE
      } else {
        _deletionStatus.value = "Relevo dejó de guardar datos, pero no se pudo confirmar el borrado en la base del proyecto. Tus datos siguen en el teléfono. Prueba otra vez o escribe a joan1542003@gmail.com."
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
          val actives = activeStore.load()
          if (actives != _actives.value) _actives.value = actives
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
      // La copia en el teléfono se escribe siempre, haya o no conexión.
      ResearchBackup.write(getApplication(), researchLog, _reminder.value.participantCode)
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

  companion object {

    /** Mensaje tras borrar los datos; también marca que la persona dejó la prueba. */
    const val DELETED_MESSAGE = "Tus datos se borraron. Si quieres volver a usar Relevo, tendrás que aceptar otra vez."

    /** Relevos respondidos tras los que se pide una opinión rápida. */
    val QUICK_FEEDBACK_AT = listOf(3, 10)

    /** Veces que sonó antes de preguntar si el tiempo queda bien. */
    const val LIMIT_REVIEW_AFTER = 3
  }
}

/** Estado de la prueba del llavero en la pantalla de preparar. */
enum class TagTest { IDLE, WORKING, ASKING, SOUNDED, FAILED }

/**
 * Lo que la pantalla de preparar muestra del llavero (D-109). [searched]: terminó una búsqueda, para
 * decir si no apareció ninguno; [searchedAll]: fue la búsqueda de respaldo, con todos los aparatos.
 * [button] y [linkLossOff], de la última prueba: si su botón avisa y si se pudo apagar su alarma por
 * desconexión. [attempt]: la forma de hacerlo pitar que se está probando; [retry]: no es la primera.
 * [heard]: la persona confirmó que lo escuchó; [silent]: ninguna forma funcionó.
 */
data class TagUi(
  val linkedName: String? = null,
  val searching: Boolean = false,
  val found: List<TagLink.Found> = emptyList(),
  val searched: Boolean = false,
  val searchedAll: Boolean = false,
  val problem: TagLink.Problem? = null,
  val test: TagTest = TagTest.IDLE,
  val button: Boolean = false,
  val linkLossOff: Boolean = true,
  val attempt: Int = 0,
  val retry: Boolean = false,
  val heard: Boolean = false,
  val silent: Boolean = false,
  /** Carga de la pila del Tag en porcentaje, si la informó (2.31). */
  val battery: Int? = null,
)

/** Qué notas de la guía siguen visibles: se ocultan después del primer relevo. */
data class GuideState(val prepare: Boolean = false, val signal: Boolean = false, val decide: Boolean = false)
