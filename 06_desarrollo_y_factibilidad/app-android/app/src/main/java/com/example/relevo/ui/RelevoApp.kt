package com.example.relevo.ui

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.PredictiveBackHandler
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.SeekableTransitionState
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.relevo.LaunchRequests
import com.example.relevo.data.ThemeMode
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.theme.Relevo
import com.example.relevo.theme.RelevoTheme
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.LocalNavScope
import com.example.relevo.ui.components.LocalSharedScope
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.LocalDockInset
import com.example.relevo.ui.components.LocalGlassSource
import com.example.relevo.ui.components.LocalSheetHost
import com.example.relevo.ui.components.SheetHost
import com.example.relevo.ui.components.SheetHostState
import com.example.relevo.ui.components.TabBar
import com.example.relevo.ui.components.TabBarHeight
import com.example.relevo.ui.components.TabItem
import com.example.relevo.ui.components.rememberReduceMotion
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

internal enum class Route {
  WELCOME, HOW_IT_WORKS, CONSENT, PERMISSION, PROFILE_SETUP,
  TABS, PREPARE, ACTIVE, SIGNAL, DECIDE,
  ROUTE_EDIT, PROFILE_EDIT, SETTINGS, NOTICES, APPEARANCE, PERMISSIONS, HISTORY, ACTIVITY_EDIT,
  PRIVACY, CONSENT_DETAILS, FEEDBACK, REPORT,
  /** 4.7 (D-175): el cierre de la prueba. */
  CLOSING,
}

/** Las tres pestañas de la 4.0 (D-155): la Ruta pasa a Actividades, junto a lo tuyo y las ideas. */
internal enum class Tab(val label: String, val icon: KitIcon) {
  HOME("Inicio", KitIcon.INICIO),
  ACTIVITIES("Actividades", KitIcon.ACTIVIDADES),
  PROFILE("Perfil", KitIcon.PERFIL),
}

/** Pantallas que dependen del estado del relevo y no se abandonan con el gesto de volver. */
private val stateScreens = setOf(Route.SIGNAL, Route.DECIDE)
private val firstRun = setOf(Route.WELCOME, Route.CONSENT, Route.PERMISSION, Route.PROFILE_SETUP)
/** Se presentan como hoja completa: suben desde abajo, como las pantallas de creación de iOS. */
private val modalRoutes = setOf(Route.PREPARE, Route.ACTIVITY_EDIT, Route.FEEDBACK, Route.REPORT, Route.PROFILE_EDIT)
/** Manejan su propio «volver» porque tienen pasos internos. */
private val selfBack = setOf(Route.PREPARE, Route.PROFILE_SETUP) + stateScreens

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
  val settings by viewModel.settings.collectAsState()
  val dark = when (settings.theme) {
    ThemeMode.SYSTEM -> isSystemInDarkTheme()
    ThemeMode.LIGHT -> false
    ThemeMode.DARK -> true
  }
  val activity = LocalContext.current as? ComponentActivity
  LaunchedEffect(dark) {
    val style = if (dark) SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
      else SystemBarStyle.light(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT)
    activity?.enableEdgeToEdge(statusBarStyle = style, navigationBarStyle = style)
  }
  RelevoTheme(darkTheme = dark, largeText = settings.largeText) {
    RelevoNavigation(viewModel)
  }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun RelevoNavigation(viewModel: RelevoViewModel) {
  val reminder by viewModel.reminder.collectAsState()
  val actives by viewModel.actives.collectAsState()
  // El relevo activo que se está viendo (4.3): puede haber varios.
  var activeSession by rememberSaveable { mutableStateOf<String?>(null) }
  val editing by viewModel.editing.collectAsState()
  val apps by viewModel.installedApps.collectAsState()
  val usageAccess by viewModel.usageAccessGranted.collectAsState()
  val history by viewModel.history.collectAsState()
  val customActivities by viewModel.customActivities.collectAsState()
  val deletionStatus by viewModel.deletionStatus.collectAsState()
  val lastReminder by viewModel.lastReminder.collectAsState()
  val backgroundUnrestricted by viewModel.backgroundUnrestricted.collectAsState()
  val syncStatus by viewModel.syncStatus.collectAsState()
  val laterPending by viewModel.laterPending.collectAsState()
  val limitReviewDue by viewModel.limitReviewDue.collectAsState()
  val returnDismissedFor by viewModel.returnDismissedFor.collectAsState()
  val participation by viewModel.participation.collectAsState()
  val profile by viewModel.profile.collectAsState()
  val routes by viewModel.routes.collectAsState()
  val settings by viewModel.settings.collectAsState()
  val routeSuggestion by viewModel.routeSuggestion.collectAsState()
  val changedRouteInterest by viewModel.changedRouteInterest.collectAsState()
  val askTurnOffReturn by viewModel.askTurnOffReturn.collectAsState()
  val autoMode by viewModel.autoMode.collectAsState()
  val prepareRequest by LaunchRequests.prepareLast.collectAsState()
  val context = LocalContext.current
  val reduce = rememberReduceMotion()
  val scope = rememberCoroutineScope()
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { viewModel.onAppResumed() }
  LifecycleEventEffect(Lifecycle.Event.ON_PAUSE) { viewModel.onAppPaused() }
  val quickFeedbackDue by viewModel.quickFeedbackDue.collectAsState()
  val redesignSurveyDue by viewModel.redesignSurveyDue.collectAsState()
  val closing by viewModel.closing.collectAsState()
  val closingOfferDue by viewModel.closingOfferDue.collectAsState()
  val guide by viewModel.guide.collectAsState()
  val firstActivated by viewModel.firstActivated.collectAsState()
  val tag by viewModel.tag.collectAsState()
  val tagStatus by viewModel.tagStatus.collectAsState()
  // Horas sin sonar (4.4): se calcula al dibujar, y la app se vuelve a dibujar al abrirla.
  val quietNow = settings.quietHours && com.example.relevo.domain.QuietHours.contains(java.time.LocalTime.now().hour, settings.quietFrom, settings.quietUntil)

  val preferences = remember { context.getSharedPreferences("relevo_experience", android.content.Context.MODE_PRIVATE) }
  fun onboardingComplete() = preferences.getBoolean("onboarding_complete", false)
  fun completeOnboarding() = preferences.edit().putBoolean("onboarding_complete", true).apply()
  fun routeForStatus(status: ReminderStatus) = when (status) {
    ReminderStatus.SIGNALLED -> listOf(Route.TABS, Route.SIGNAL)
    ReminderStatus.SILENCED, ReminderStatus.CLOSED -> listOf(Route.TABS, Route.DECIDE)
    else -> listOf(Route.TABS)
  }
  /**
   * Después del permiso, la primera vez va directo a preparar el primer relevo, que enseña haciendo. El
   * perfil se pide después de activarlo (4.4, desde la 1.0.0; pedido de la comisión del 28 de octubre).
   */
  fun afterOnboarding(): List<Route> =
    if (guide.prepare && history.isEmpty() && actives.isEmpty() && (reminder.status == ReminderStatus.DRAFT || reminder.status == ReminderStatus.READY)) listOf(Route.TABS, Route.PREPARE)
    else routeForStatus(reminder.status)
  // Sin el consentimiento vigente no se usa la app (D-084). La primera vez, la bienvenida; quien ya aceptó
  // una versión anterior, el texto nuevo.
  fun initialStack(): List<Route> = when {
    participation == ParticipationMode.NONE ->
      if (onboardingComplete() || com.example.relevo.data.Participation.acceptedBefore(context)) listOf(Route.CONSENT) else listOf(Route.WELCOME)
    !onboardingComplete() -> listOf(Route.PERMISSION)
    else -> routeForStatus(reminder.status)
  }

  var stack by rememberSaveable(stateSaver = RouteStackSaver) { mutableStateOf(initialStack()) }
  var tab by rememberSaveable { mutableStateOf(Tab.HOME) }
  var reselect by remember { mutableIntStateOf(0) }
  var back by remember { mutableStateOf(false) }
  var acknowledgement by rememberSaveable { mutableStateOf<String?>(null) }
  /** Foto que viaja de la tarjeta tocada a la pantalla siguiente. */
  var photoKey by rememberSaveable { mutableStateOf<String?>(null) }
  // Desde dónde abre Preparar (4.2.1): «Preparar un relevo» sin nada elegido y el primer relevo guiado
  // empiezan por el paso 1; una idea, una actividad, un paso o un relevo repetido abren en lo que falta.
  var prepareFromStart by rememberSaveable { mutableStateOf(false) }
  var routeEditInterest by rememberSaveable { mutableStateOf("") }
  var editingActivityId by rememberSaveable { mutableStateOf<String?>(null) }
  var routeInterest by rememberSaveable { mutableStateOf<String?>(null) }
  var activitiesSection by rememberSaveable { mutableStateOf(ActivitiesSection.MINE) }
  fun openActivities(section: ActivitiesSection) { activitiesSection = section; tab = Tab.ACTIVITIES }
  /** Paso en que abre Preparar: «usage» para cambiar solo el tiempo (4.4). */
  var prepareAt by rememberSaveable { mutableStateOf<String?>(null) }
  val holder = rememberSaveableStateHolder()
  val discarded = remember { mutableStateListOf<Route>() }
  val current = stack.last()
  // Registro de uso: qué pantalla o pestaña tiene delante la persona.
  LaunchedEffect(current, tab) { viewModel.logScreen(if (current == Route.TABS) "pestana_${tab.name.lowercase()}" else current.name.lowercase()) }

  fun push(route: Route) { if (current != route) { back = false; stack = stack + route } }
  fun pop() {
    if (stack.size > 1) { back = true; discarded += stack.last(); stack = stack.dropLast(1) }
  }
  fun replace(routes: List<Route>, isBack: Boolean = false) {
    back = isBack
    discarded += stack.filter { it !in routes }
    stack = routes
  }

  val transitionState = remember { SeekableTransitionState(stack.last()) }
  LaunchedEffect(current) { transitionState.animateTo(current) }
  // Al terminar una transición se olvida el estado de las pantallas que ya no están en la pila.
  LaunchedEffect(transitionState.currentState, transitionState.targetState) {
    if (transitionState.currentState == transitionState.targetState) {
      discarded.filter { it !in stack }.distinct().forEach { holder.removeState(it.name) }
      discarded.clear()
    }
  }

  // El gesto de volver de Android 14+ arrastra la pantalla con el dedo, como en iOS; si se suelta antes, vuelve a su lugar.
  PredictiveBackHandler(enabled = stack.size > 1 && current !in selfBack) { progress ->
    val previous = stack[stack.size - 2]
    back = true
    try {
      progress.collect { event -> transitionState.seekTo(event.progress, targetState = previous) }
      pop()
    } catch (cancel: CancellationException) {
      scope.launch { transitionState.animateTo(current) }
      throw cancel
    }
  }

  // El estado del relevo decide la señal y la respuesta, aunque lleguen con la app en segundo plano.
  LaunchedEffect(reminder.status) {
    if (current in firstRun) return@LaunchedEffect
    when (reminder.status) {
      ReminderStatus.SIGNALLED -> if (current != Route.SIGNAL) replace(routeForStatus(reminder.status))
      ReminderStatus.SILENCED, ReminderStatus.CLOSED -> if (current != Route.DECIDE) replace(routeForStatus(reminder.status))
      else -> if (current in stateScreens) replace(listOf(Route.TABS), isBack = true)
    }
  }

  // «Preparar» desde el aviso de regreso (V2).
  LaunchedEffect(prepareRequest) {
    if (!prepareRequest) return@LaunchedEffect
    LaunchRequests.prepareLast.value = false
    if (current !in firstRun && viewModel.prepareFromReturnNotice()) {
      tab = Tab.HOME
      photoKey = null
      prepareFromStart = false
      replace(listOf(Route.TABS, Route.PREPARE))
    }
  }

  fun startPrepare(key: String?, at: String? = null) {
    viewModel.applyPreferredApps()
    viewModel.onPrepareOpened(key?.substringBefore(':')?.ifBlank { null } ?: "nuevo")
    photoKey = key
    prepareFromStart = key == null && at == null
    prepareAt = at
    push(Route.PREPARE)
  }

  val homeActions = HomeActions(
    onPrepare = { startPrepare(null) },
    onRepeat = { key -> viewModel.repeatLast(); startPrepare(key) },
    onIdea = { idea, key -> viewModel.applyPreset(idea.activity, idea.start, idea.place); startPrepare(key) },
    onCustom = { custom, key -> viewModel.applyPreset(custom.name, custom.firstStep, custom.place); startPrepare(key) },
    onRouteStep = { interest, stepId, key -> if (viewModel.prepareFromStep(interest, stepId)) startPrepare(key) },
    onNewActivity = { editingActivityId = null; push(Route.ACTIVITY_EDIT) },
    onOpenActive = { id -> activeSession = id; push(Route.ACTIVE) },
    onOpenActivities = ::openActivities,
    onUsageSettings = viewModel::openUsageAccessSettings,
    onBackground = viewModel::requestBackgroundAccess,
    onDismissAcknowledgement = { acknowledgement = null },
    onDismissReturn = viewModel::dismissReturn,
    onLaterActivate = { if (!viewModel.activateLater()) startPrepare(null) },
    onLaterDismiss = viewModel::dismissLater,
    onLimitReview = { change -> viewModel.answerLimitReview(change); if (change && viewModel.repeatLast()) startPrepare(null, at = "usage") },
    onProfileSetup = { push(Route.PROFILE_SETUP) },
  )

  val rootHaze = rememberHazeState()
  val sheets = remember { SheetHostState() }
  CompositionLocalProvider(LocalRoutes provides routes, LocalSheetHost provides sheets) {
  Box(Modifier.fillMaxSize().background(Relevo.colors.paper)) {
    Box(Modifier.fillMaxSize().hazeSource(rootHaze)) {
    SharedTransitionLayout {
      val transition = rememberTransition(transitionState, label = "navigation")
      transition.AnimatedContent(
        transitionSpec = { navigationTransition(reduce, back) },
        contentKey = { it },
      ) { route ->
        CompositionLocalProvider(LocalSharedScope provides this@SharedTransitionLayout, LocalNavScope provides this) {
          holder.SaveableStateProvider(route.name) {
            Box(Modifier.fillMaxSize().background(Relevo.colors.paper)) {
              when (route) {
                // 4.4: la primera vez son tres pantallas —bienvenida, consentimiento y Tiempo de uso—; «Cómo
                // funciona» queda en Perfil, y el aviso semanal, en los ajustes, apagado (D-088).
                Route.WELCOME -> WelcomeScreen(onStart = { push(Route.CONSENT) })
                Route.HOW_IT_WORKS -> HowItWorksScreen(onContinue = { pop() }, continueLabel = "Entendido", onBack = { pop() })
                Route.CONSENT -> ConsentScreen(
                  remoteConfigured = viewModel.remoteConfigured,
                  deletionPending = viewModel.deletionPending,
                  renewal = com.example.relevo.data.Participation.acceptedBefore(context) || onboardingComplete(),
                  onAccept = {
                    viewModel.updateConsent(true)
                    if (onboardingComplete()) replace(routeForStatus(reminder.status)) else push(Route.PERMISSION)
                  },
                  onPrivacy = { push(Route.PRIVACY) },
                )
                Route.PERMISSION -> PermissionScreen(
                  usageAccess = usageAccess,
                  onOpenUsageSettings = viewModel::openUsageAccessSettings,
                  onRefresh = viewModel::refreshUsageAccess,
                  onContinue = {
                    completeOnboarding()
                    val next = afterOnboarding()
                    if (Route.PREPARE in next) {
                      viewModel.applyPreferredApps()
                      viewModel.onPrepareOpened("primer_relevo")
                      photoKey = null
                      prepareAt = null
                      prepareFromStart = true
                    }
                    tab = Tab.HOME
                    replace(next)
                  },
                )
                Route.PROFILE_SETUP -> ProfileSetupScreen(
                  profile = profile,
                  onName = { name -> viewModel.updateProfile { copy(name = name) } },
                  onImage = { image -> viewModel.updateProfile { copy(image = image) } },
                  onInterests = viewModel::setInterests,
                  onFinish = { showRoute ->
                    viewModel.completeProfileSetup()
                    if (showRoute) openActivities(ActivitiesSection.STEPS) else tab = Tab.HOME
                    replace(routeForStatus(reminder.status))
                  },
                  onClose = if (stack.size > 1) ({ pop() }) else null,
                )
                Route.TABS -> TabsHost(
                  tab = tab,
                  reselect = reselect,
                  onTab = { selected -> if (selected == tab) reselect++ else tab = selected },
                ) { selected ->
                  when (selected) {
                    Tab.HOME -> HomeTab(
                      reminder = reminder, actives = actives, history = history, customActivities = customActivities, lastReminder = lastReminder,
                      usageAccess = usageAccess, backgroundUnrestricted = backgroundUnrestricted, profile = profile,
                      laterPending = laterPending, limitReviewDue = limitReviewDue, quiet = quietNow, quietUntil = settings.quietUntil,
                      routes = routes, settings = settings, acknowledgement = acknowledgement, returnDismissedFor = returnDismissedFor,
                      quickFeedbackDue = quickFeedbackDue, onQuickFeedback = viewModel::submitQuickFeedback, onFeedback = { push(Route.FEEDBACK) },
                      autoMode = autoMode, onAutoModeOff = { viewModel.setAutoMode(false) },
                      changedRouteInterest = changedRouteInterest, reselect = reselect, actions = homeActions,
                      onChangeRoute = { interest -> viewModel.clearChangedRoute(); acknowledgement = null; routeEditInterest = interest; push(Route.ROUTE_EDIT) },
                    )
                    Tab.ACTIVITIES -> ActivitiesTab(
                      section = activitiesSection, onSection = { activitiesSection = it },
                      customActivities = customActivities, routes = routes,
                      routeInterest = routeInterest, onRouteInterest = { routeInterest = it },
                      reselect = reselect,
                      actions = ActivitiesActions(
                        onPrepareCustom = { custom -> homeActions.onCustom(custom, com.example.relevo.ui.photoKey("propia", custom.id)) },
                        onPrepareIdea = { idea -> homeActions.onIdea(idea, com.example.relevo.ui.photoKey("idea", idea.activity)) },
                        onPrepareStep = homeActions.onRouteStep,
                        onNewActivity = { editingActivityId = null; push(Route.ACTIVITY_EDIT) },
                        onEditActivity = { id -> editingActivityId = id; push(Route.ACTIVITY_EDIT) },
                        onSetCurrent = viewModel::setCurrentStep,
                        onEditRoute = { interest -> routeEditInterest = interest; push(Route.ROUTE_EDIT) },
                        onChooseInterests = { push(Route.PROFILE_EDIT) },
                      ),
                    )
                    Tab.PROFILE -> ProfileTab(
                      profile = profile, routes = routes, history = history,
                      customCount = customActivities.size, apps = apps, reselect = reselect,
                      actions = ProfileActions(
                        onEdit = { push(Route.PROFILE_EDIT) },
                        onSettings = { push(Route.SETTINGS) },
                        onHistory = { push(Route.HISTORY) },
                        onActivities = { openActivities(ActivitiesSection.MINE) },
                        onRoute = { openActivities(ActivitiesSection.STEPS) },
                        onFeedback = { push(Route.FEEDBACK) },
                        onReport = { push(Route.REPORT) },
                        onToggleApp = viewModel::togglePreferredApp,
                        onHowItWorks = { push(Route.HOW_IT_WORKS) },
                      ),
                    )
                  }
                }
                Route.PREPARE -> PrepareScreen(
                  editing = editing,
                  reminder = reminder, apps = apps, customActivities = customActivities, routes = routes, usageAccess = usageAccess,
                  backgroundUnrestricted = backgroundUnrestricted, photoKey = photoKey, fromStart = prepareFromStart, openAt = prepareAt,
                  tag = tag, tagStatus = tagStatus, volume = settings.volume,
                  actions = PrepareActions(
                    onActivity = viewModel::updateActivity,
                    onStart = viewModel::updateHowToStart,
                    onPlace = viewModel::updatePlace,
                    onIdea = viewModel::applyPreset,
                    onRouteStep = { interest, stepId -> viewModel.prepareFromStep(interest, stepId) },
                    onToggleApp = viewModel::selectTargetApp,
                    onDuration = viewModel::updateRequiredUsage,
                    onRoute = viewModel::updateSignalRoute,
                    onTestSound = { viewModel.testSignal() },
                    onVolume = { volume -> viewModel.updateSettings { copy(volume = volume) } },
                    onUsageSettings = viewModel::openUsageAccessSettings,
                    onBackground = viewModel::requestBackgroundAccess,
                    onSaveCustom = { viewModel.saveCustomActivity(it, apply = false) },
                    onActivate = { requestNotificationPermission(context); if (viewModel.activate()) { tab = Tab.HOME; replace(listOf(Route.TABS), isBack = true) } },
                    onClose = { viewModel.onPrepareClosed(); pop() },
                    onStepShown = viewModel::onPrepareStep,
                    onMissing = viewModel::onMissingField,
                    onTagSearch = viewModel::searchTags,
                    onTagSearchAll = viewModel::searchAllDevices,
                    onTagLink = viewModel::linkTag,
                    onTagTest = viewModel::testTag,
                    onTagHeard = viewModel::tagHeard,
                    onTagForget = viewModel::forgetTag,
                    onBluetoothOn = viewModel::bluetoothTurnedOn,
                  ),
                )
                Route.ACTIVE -> {
                  // Si el relevo ya no cuenta (sonó, se desactivó o se eliminó), vuelve a Inicio.
                  val shown = actives.firstOrNull { it.sessionId == activeSession }
                  if (shown == null) LaunchedEffect(Unit) { replace(listOf(Route.TABS), isBack = true) }
                  else ActiveScreen(
                  reminder = shown, customActivities = customActivities, usageAccess = usageAccess,
                  backgroundUnrestricted = backgroundUnrestricted, photoKey = photoKey,
                  quiet = quietNow, quietUntil = settings.quietUntil,
                  onBack = { pop() }, onDisarm = { viewModel.disarm(shown.sessionId) },
                  onUsageSettings = viewModel::openUsageAccessSettings, onBackground = viewModel::requestBackgroundAccess,
                  onDelete = { viewModel.deleteActive(shown.sessionId) },
                  onEdit = {
                    if (viewModel.editActive(shown.sessionId)) {
                      viewModel.onPrepareOpened("editar")
                      photoKey = null
                      prepareFromStart = false
                      replace(listOf(Route.TABS, Route.PREPARE))
                    }
                  },
                )
                }
                Route.SIGNAL -> SignalScreen(
                  reminder = reminder, customActivities = customActivities,
                  onTestSound = { viewModel.testSignal(it) }, onContinue = viewModel::silence,
                )
                Route.DECIDE -> DecideScreen(reminder, customActivities, askSignalQuestions = reminder.signalDelivered) { outcome, knew, recalled, feeling, noticed, keepForLater ->
                  viewModel.completeEvaluation(outcome, knew, recalled, feeling, noticed, keepForLater)
                  acknowledgement = when {
                    !settings.acknowledgements -> null
                    keepForLater -> "Queda lista en Inicio para cuando quieras."
                    else -> acknowledgementFor(outcome)
                  }
                  viewModel.reset()
                  tab = Tab.HOME
                  replace(listOf(Route.TABS), isBack = true)
                }
                Route.ROUTE_EDIT -> {
                  val track = routes.firstOrNull { it.interest == routeEditInterest }
                  if (track == null) LaunchedEffect(Unit) { pop() }
                  else RouteEditScreen(track, customActivities, onSave = { viewModel.saveTrack(it); pop() }, onBack = { pop() })
                }
                Route.PROFILE_EDIT -> ProfileEditScreen(
                  profile = profile,
                  onSave = { name, image, interests, other ->
                    viewModel.updateProfile { copy(name = name, image = image) }
                    viewModel.setInterests(interests, other)
                    pop()
                  },
                  onBack = { pop() },
                )
                Route.SETTINGS -> SettingsScreen(
                  settings = settings, usageAccess = usageAccess,
                  onNotices = { push(Route.NOTICES) }, onAppearance = { push(Route.APPEARANCE) },
                  onPermissions = { push(Route.PERMISSIONS) }, onPrivacy = { push(Route.PRIVACY) },
                  onBack = { pop() }, onSound = viewModel::chooseSound, onChange = viewModel::updateSettings,
                  closing = closing?.takeIf { !it.done }, onClosing = { viewModel.markClosingOffered("ajustes"); push(Route.CLOSING) },
                )
                Route.NOTICES -> NoticesScreen(
                  settings, onChange = viewModel::updateSettings, onBack = { pop() },
                  autoMode = autoMode, lastReminder = lastReminder, onAutoMode = viewModel::setAutoMode,
                )
                Route.APPEARANCE -> AppearanceScreen(settings, onChange = viewModel::updateSettings, onBack = { pop() })
                Route.PERMISSIONS -> PermissionsScreen(usageAccess, backgroundUnrestricted, viewModel::openUsageAccessSettings, viewModel::requestBackgroundAccess, onBack = { pop() })
                Route.HISTORY -> HistoryScreen(history, customActivities, onBack = { pop() })
                Route.ACTIVITY_EDIT -> ActivityEditScreen(
                  initial = customActivities.firstOrNull { it.id == editingActivityId },
                  existing = customActivities,
                  onSave = { viewModel.saveCustomActivity(it, apply = false); pop() },
                  onDelete = { id -> viewModel.deleteCustomActivity(id); pop() },
                  onBack = { pop() },
                )
                Route.PRIVACY -> PrivacyScreen(
                  participantCode = reminder.participantCode,
                  participation = participation,
                  remoteConfigured = viewModel.remoteConfigured,
                  syncStatus = syncStatus,
                  deletionStatus = deletionStatus,
                  onBack = { pop() },
                  onConsent = { push(Route.CONSENT_DETAILS) },
                  onExport = viewModel::exportData,
                  onDelete = viewModel::deleteResearchData,
                  onRestart = { tab = Tab.HOME; replace(listOf(Route.WELCOME)) },
                )
                Route.CONSENT_DETAILS -> ConsentDetailsScreen(viewModel.remoteConfigured, onBack = { pop() })
                Route.FEEDBACK -> FeedbackScreen(onSend = { stars, comment -> viewModel.submitFeedback(stars, comment); pop() }, onBack = { pop() })
                Route.REPORT -> ReportScreen(onSend = { text, attach -> viewModel.submitReport(text, attach); pop() }, onBack = { pop() })
                Route.CLOSING -> ClosingSurveyScreen(
                  startPart = closing?.part ?: 0,
                  onPart = viewModel::saveClosingPart,
                  onClose = { pop() },
                )
              }
            }
          }
        }
      }
    }

    }

    // Hojas que pueden aparecer sobre Inicio después de responder.
    if (current == Route.TABS) {
      routeSuggestion?.let { suggestion ->
        NextStepSheet(suggestion, onAccept = viewModel::acceptNextStep, onStay = viewModel::declineNextStep, onDismiss = viewModel::dismissNextStep)
      }
      if (askTurnOffReturn) TurnOffReturnSheet(onAnswer = viewModel::answerTurnOffReturn)
      actives.lastOrNull()?.let { latest ->
        if (firstActivated) FirstRelevoActiveSheet(
          latest,
          onDismiss = viewModel::dismissFirstActivated,
          // El perfil se pide aquí, después del primer relevo, y no antes (4.4).
          onProfile = if (!profile.setupSeen) ({ viewModel.dismissFirstActivated(); push(Route.PROFILE_SETUP) }) else null,
        )
      }
      // 4.7 (D-175): el cierre de la prueba, al abrir la app, una vez y sin otra hoja abierta; después, en Ajustes.
      if (closingOfferDue && !firstActivated && routeSuggestion == null && !askTurnOffReturn) {
        ClosingIntroSheet(
          onStart = { viewModel.markClosingOffered("empezar"); push(Route.CLOSING) },
          onLater = { viewModel.markClosingOffered("ahora_no") },
        )
      }
      // 4.6 (D-164): la encuesta del rediseño, una vez, solo sobre las pestañas y sin otra hoja abierta.
      if (redesignSurveyDue && !closingOfferDue && !firstActivated && routeSuggestion == null && !askTurnOffReturn) {
        RedesignSurveySheet(
          onShown = viewModel::markRedesignSurveyShown,
          onSend = viewModel::submitRedesignSurvey,
          onDismiss = viewModel::dismissRedesignSurvey,
        )
      }
    }
    // Las hojas van sobre todo y desenfocan la app que queda detrás.
    SheetHost(sheets, rootHaze)
  }
  }

  // En Actividades o Perfil, volver lleva a Inicio antes de salir de la app.
  BackHandler(enabled = current == Route.TABS && tab != Tab.HOME) { tab = Tab.HOME }
}

/**
 * Contenedor de las pestañas: el contenido ocupa toda la pantalla y pasa bajo la barra de pestañas, una
 * cápsula de vidrio centrada (4.0). Cada pestaña conserva su desplazamiento; tocar la elegida sube al comienzo.
 */
@Composable
private fun TabsHost(tab: Tab, reselect: Int, onTab: (Tab) -> Unit, content: @Composable (Tab) -> Unit) {
  val holder = rememberSaveableStateHolder()
  val reduce = rememberReduceMotion()
  val tabHaze = rememberHazeState()
  Box(Modifier.fillMaxSize()) {
    Box(Modifier.fillMaxSize().hazeSource(tabHaze)) {
      CompositionLocalProvider(LocalDockInset provides TabBarHeight + 14.dp) {
        AnimatedContent(
          targetState = tab,
          transitionSpec = { if (reduce) EnterTransition.None togetherWith ExitTransition.None else fadeIn(Motion.standard(180)) togetherWith fadeOut(Motion.standard(120)) },
          label = "tabs",
        ) { selected ->
          holder.SaveableStateProvider(selected.name) { content(selected) }
        }
      }
    }
    CompositionLocalProvider(LocalGlassSource provides tabHaze) {
      // La barra flota centrada sobre el borde con desenfoque progresivo que dibuja cada pantalla.
      TabBar(
        Tab.entries.map { TabItem(it.label, it.icon) }, Tab.entries.indexOf(tab), { onTab(Tab.entries[it]) },
        Modifier.align(Alignment.BottomCenter).navigationBarsPadding().padding(bottom = 10.dp),
      )
    }
  }
}

/**
 * Transiciones como las de iOS, sin rebote: la pantalla nueva entra desde la derecha y la anterior se
 * corre un poco; las hojas de creación suben desde abajo; la señal y la respuesta aparecen con un fundido.
 */
private fun AnimatedContentTransitionScope<Route>.navigationTransition(reduce: Boolean, back: Boolean): ContentTransform {
  val from = initialState
  val to = targetState
  if (reduce) return EnterTransition.None togetherWith ExitTransition.None
  if (to in stateScreens || from in stateScreens || (from in firstRun && to !in firstRun) || (to in firstRun && from !in firstRun)) {
    return fadeIn(Motion.standard()) togetherWith fadeOut(Motion.standard(Motion.SHORT))
  }
  if (!back && to in modalRoutes) {
    return (slideInVertically(Motion.smooth()) { it } togetherWith ExitTransition.KeepUntilTransitionsFinished).apply { targetContentZIndex = 1f }
  }
  if (back && from in modalRoutes) {
    return (EnterTransition.None togetherWith slideOutVertically(Motion.smooth()) { it }).apply { targetContentZIndex = -1f }
  }
  return if (!back) {
    (slideInHorizontally(Motion.smooth()) { it } togetherWith slideOutHorizontally(Motion.smooth()) { -it / 4 }).apply { targetContentZIndex = 1f }
  } else {
    (slideInHorizontally(Motion.smooth()) { -it / 4 } togetherWith slideOutHorizontally(Motion.smooth()) { it }).apply { targetContentZIndex = -1f }
  }
}

private val RouteStackSaver = Saver<List<Route>, ArrayList<String>>(
  save = { routes -> ArrayList(routes.map { it.name }) },
  restore = { names -> names.mapNotNull { name -> Route.entries.firstOrNull { it.name == name } }.ifEmpty { listOf(Route.TABS) } },
)
