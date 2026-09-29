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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
  ROUTE_EDIT, PROFILE_EDIT, NOTICES, APPEARANCE, PERMISSIONS, HISTORY, ACTIVITIES, ACTIVITY_EDIT,
  PRIVACY, CONSENT_DETAILS, STUDY, WEEK, CLOSING, FEEDBACK, REPORT,
}

internal enum class Tab(val label: String, val icon: KitIcon) {
  HOME("Inicio", KitIcon.INICIO),
  ROUTE("Ruta", KitIcon.PRIMER_PASO),
  PROFILE("Perfil", KitIcon.PERFIL),
}

/** Pantallas que dependen del estado del relevo y no se abandonan con el gesto de volver. */
private val stateScreens = setOf(Route.SIGNAL, Route.DECIDE)
private val firstRun = setOf(Route.WELCOME, Route.CONSENT, Route.PERMISSION, Route.PROFILE_SETUP)
/** Se presentan como hoja completa: suben desde abajo, como las pantallas de creación de iOS. */
private val modalRoutes = setOf(Route.PREPARE, Route.ACTIVITY_EDIT, Route.FEEDBACK, Route.REPORT, Route.WEEK, Route.CLOSING, Route.PROFILE_EDIT)
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
  RelevoTheme(darkTheme = dark, largeText = settings.largeText) { RelevoNavigation(viewModel) }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun RelevoNavigation(viewModel: RelevoViewModel) {
  val reminder by viewModel.reminder.collectAsState()
  val apps by viewModel.installedApps.collectAsState()
  val usageAccess by viewModel.usageAccessGranted.collectAsState()
  val history by viewModel.history.collectAsState()
  val customActivities by viewModel.customActivities.collectAsState()
  val deletionStatus by viewModel.deletionStatus.collectAsState()
  val lastReminder by viewModel.lastReminder.collectAsState()
  val backgroundUnrestricted by viewModel.backgroundUnrestricted.collectAsState()
  val syncStatus by viewModel.syncStatus.collectAsState()
  val study by viewModel.study.collectAsState()
  val returnDismissedFor by viewModel.returnDismissedFor.collectAsState()
  val participation by viewModel.participation.collectAsState()
  val profile by viewModel.profile.collectAsState()
  val routes by viewModel.routes.collectAsState()
  val settings by viewModel.settings.collectAsState()
  val routeSuggestion by viewModel.routeSuggestion.collectAsState()
  val changedRouteInterest by viewModel.changedRouteInterest.collectAsState()
  val askTurnOffReturn by viewModel.askTurnOffReturn.collectAsState()
  val prepareRequest by LaunchRequests.prepareLast.collectAsState()
  val context = LocalContext.current
  val reduce = rememberReduceMotion()
  val scope = rememberCoroutineScope()
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { viewModel.onAppResumed() }
  LifecycleEventEffect(Lifecycle.Event.ON_PAUSE) { viewModel.onAppPaused() }
  val quickFeedbackDue by viewModel.quickFeedbackDue.collectAsState()
  val guide by viewModel.guide.collectAsState()

  val preferences = remember { context.getSharedPreferences("relevo_experience", android.content.Context.MODE_PRIVATE) }
  fun onboardingComplete() = preferences.getBoolean("onboarding_complete", false)
  fun completeOnboarding() = preferences.edit().putBoolean("onboarding_complete", true).apply()
  fun routeForStatus(status: ReminderStatus) = when (status) {
    ReminderStatus.SIGNALLED -> listOf(Route.TABS, Route.SIGNAL)
    ReminderStatus.SILENCED, ReminderStatus.CLOSED -> listOf(Route.TABS, Route.DECIDE)
    else -> listOf(Route.TABS)
  }
  fun afterOnboarding(): List<Route> = if (!profile.setupSeen) listOf(Route.PROFILE_SETUP) else routeForStatus(reminder.status)
  // Sin el consentimiento vigente no se usa la app (D-084): la primera vez, bienvenida; después, el consentimiento.
  fun initialStack(): List<Route> = when {
    participation == ParticipationMode.NONE -> if (onboardingComplete()) listOf(Route.CONSENT) else listOf(Route.WELCOME)
    !onboardingComplete() -> listOf(Route.PERMISSION)
    else -> afterOnboarding()
  }

  var stack by rememberSaveable(stateSaver = RouteStackSaver) { mutableStateOf(initialStack()) }
  var tab by rememberSaveable { mutableStateOf(Tab.HOME) }
  var reselect by remember { mutableIntStateOf(0) }
  var back by remember { mutableStateOf(false) }
  var acknowledgement by rememberSaveable { mutableStateOf<String?>(null) }
  /** Foto que viaja de la tarjeta tocada a la pantalla siguiente. */
  var photoKey by rememberSaveable { mutableStateOf<String?>(null) }
  var routeEditInterest by rememberSaveable { mutableStateOf("") }
  var editingActivityId by rememberSaveable { mutableStateOf<String?>(null) }
  var routeInterest by rememberSaveable { mutableStateOf<String?>(null) }
  /** «Cómo funciona» se abre la primera vez, antes del consentimiento, o desde el perfil. */
  var howFromProfile by rememberSaveable { mutableStateOf(false) }
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
      ReminderStatus.WAITING -> if (current in stateScreens || current == Route.PREPARE) replace(listOf(Route.TABS), isBack = true)
      else -> if (current in stateScreens || current == Route.ACTIVE) replace(listOf(Route.TABS), isBack = true)
    }
  }

  // «Preparar» desde el aviso de regreso (V2).
  LaunchedEffect(prepareRequest) {
    if (!prepareRequest) return@LaunchedEffect
    LaunchRequests.prepareLast.value = false
    if (current !in firstRun && viewModel.prepareFromReturnNotice()) {
      tab = Tab.HOME
      photoKey = null
      replace(listOf(Route.TABS, Route.PREPARE))
    }
  }

  fun startPrepare(key: String?) {
    viewModel.onPrepareOpened(key?.substringBefore(':')?.ifBlank { null } ?: "nuevo")
    photoKey = key
    push(Route.PREPARE)
  }

  val homeActions = HomeActions(
    onPrepare = { startPrepare(null) },
    onRepeat = { key -> viewModel.repeatLast(); startPrepare(key) },
    onIdea = { idea, key -> viewModel.applyPreset(idea.activity, idea.start, idea.place); startPrepare(key) },
    onCustom = { custom, key -> viewModel.applyPreset(custom.name, custom.firstStep, custom.place); startPrepare(key) },
    onRouteStep = { interest, stepId, key -> if (viewModel.prepareFromStep(interest, stepId)) startPrepare(key) },
    onNewActivity = { editingActivityId = null; push(Route.ACTIVITY_EDIT) },
    onOpenActive = { push(Route.ACTIVE) },
    onOpenRoute = { interest -> routeInterest = interest; tab = Tab.ROUTE },
    onProfile = { tab = Tab.PROFILE },
    onUsageSettings = viewModel::openUsageAccessSettings,
    onBackground = viewModel::requestBackgroundAccess,
    onDismissAcknowledgement = { acknowledgement = null },
    onDismissInstruction = viewModel::dismissInstruction,
    onWeekReview = { push(Route.WEEK) },
    onClosing = { push(Route.CLOSING) },
    onDismissReturn = viewModel::dismissReturn,
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
                Route.WELCOME -> WelcomeScreen(onStart = { howFromProfile = false; push(Route.HOW_IT_WORKS) })
                Route.HOW_IT_WORKS -> if (howFromProfile) HowItWorksScreen(onContinue = { pop() }, continueLabel = "Entendido", onBack = { pop() }, onVideo = viewModel::onTutorialVideo)
                  else HowItWorksScreen(
                    onContinue = { push(Route.CONSENT) }, onBack = { pop() }, onVideo = viewModel::onTutorialVideo,
                    onReturnNotice = viewModel::chooseReturnNotice,
                    onPage = { viewModel.logScreen("guia_$it") },
                  )
                Route.CONSENT -> ConsentScreen(
                  remoteConfigured = viewModel.remoteConfigured,
                  deletionPending = viewModel.deletionPending,
                  onAccept = { viewModel.updateConsent(true); if (onboardingComplete()) replace(afterOnboarding()) else push(Route.PERMISSION) },
                  onPrivacy = { push(Route.PRIVACY) },
                )
                Route.PERMISSION -> PermissionScreen(
                  usageAccess = usageAccess,
                  onOpenUsageSettings = viewModel::openUsageAccessSettings,
                  onRefresh = viewModel::refreshUsageAccess,
                  onContinue = { completeOnboarding(); replace(afterOnboarding()) },
                  backgroundUnrestricted = backgroundUnrestricted,
                  onBattery = viewModel::requestBackgroundAccess,
                )
                Route.PROFILE_SETUP -> ProfileSetupScreen(
                  profile = profile,
                  onName = { name -> viewModel.updateProfile { copy(name = name) } },
                  onImage = { image -> viewModel.updateProfile { copy(image = image) } },
                  onInterests = viewModel::setInterests,
                  onFinish = { showRoute ->
                    viewModel.completeProfileSetup()
                    tab = if (showRoute) Tab.ROUTE else Tab.HOME
                    replace(routeForStatus(reminder.status))
                  },
                )
                Route.TABS -> TabsHost(
                  tab = tab,
                  reselect = reselect,
                  onTab = { selected -> if (selected == tab) reselect++ else tab = selected },
                ) { selected ->
                  when (selected) {
                    Tab.HOME -> HomeTab(
                      reminder = reminder, history = history, customActivities = customActivities, lastReminder = lastReminder,
                      study = study, usageAccess = usageAccess, backgroundUnrestricted = backgroundUnrestricted, profile = profile,
                      routes = routes, acknowledgement = acknowledgement, returnDismissedFor = returnDismissedFor,
                      quickFeedbackDue = quickFeedbackDue, onQuickFeedback = viewModel::submitQuickFeedback, onFeedback = { push(Route.FEEDBACK) },
                      guided = guide.prepare,
                      changedRouteInterest = changedRouteInterest, reselect = reselect, actions = homeActions,
                      onChangeRoute = { interest -> viewModel.clearChangedRoute(); acknowledgement = null; routeEditInterest = interest; push(Route.ROUTE_EDIT) },
                    )
                    Tab.ROUTE -> RouteTab(
                      routes = routes, customActivities = customActivities, selected = routeInterest, reselect = reselect,
                      activeRelevo = reminder.status == ReminderStatus.WAITING,
                      onSelect = { routeInterest = it },
                      onPrepare = homeActions.onRouteStep,
                      onSetCurrent = viewModel::setCurrentStep,
                      onEdit = { interest -> routeEditInterest = interest; push(Route.ROUTE_EDIT) },
                      onChooseInterests = { push(Route.PROFILE_EDIT) },
                    )
                    Tab.PROFILE -> ProfileTab(
                      profile = profile, routes = routes, history = history, settings = settings, study = study,
                      participation = participation, customCount = customActivities.size, reselect = reselect,
                      actions = ProfileActions(
                        onEdit = { push(Route.PROFILE_EDIT) },
                        onNotices = { push(Route.NOTICES) },
                        onAppearance = { push(Route.APPEARANCE) },
                        onPermissions = { push(Route.PERMISSIONS) },
                        onHistory = { push(Route.HISTORY) },
                        onActivities = { push(Route.ACTIVITIES) },
                        onStudy = { push(Route.STUDY) },
                        onPrivacy = { push(Route.PRIVACY) },
                        onFeedback = { push(Route.FEEDBACK) },
                        onReport = { push(Route.REPORT) },
                        onHowItWorks = { howFromProfile = true; push(Route.HOW_IT_WORKS) },
                        onWeekNote = viewModel::submitWeekNote,
                        onOpenRoute = { tab = Tab.ROUTE },
                      ),
                    )
                  }
                }
                Route.PREPARE -> PrepareScreen(
                  reminder = reminder, apps = apps, customActivities = customActivities, routes = routes, usageAccess = usageAccess,
                  backgroundUnrestricted = backgroundUnrestricted, studyCondition = study.condition, photoKey = photoKey, guided = guide.prepare,
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
                    onUsageSettings = viewModel::openUsageAccessSettings,
                    onBackground = viewModel::requestBackgroundAccess,
                    onSaveCustom = { viewModel.saveCustomActivity(it, apply = false) },
                    onActivate = { requestNotificationPermission(context); if (viewModel.activate()) { tab = Tab.HOME; replace(listOf(Route.TABS), isBack = true) } },
                    onClose = { viewModel.onPrepareClosed(); pop() },
                    onStepShown = viewModel::onPrepareStep,
                  ),
                )
                Route.ACTIVE -> ActiveScreen(
                  reminder = reminder, customActivities = customActivities, usageAccess = usageAccess,
                  backgroundUnrestricted = backgroundUnrestricted, photoKey = photoKey,
                  onBack = { pop() }, onDisarm = viewModel::disarm,
                  onUsageSettings = viewModel::openUsageAccessSettings, onBackground = viewModel::requestBackgroundAccess,
                )
                Route.SIGNAL -> SignalScreen(
                  reminder = reminder, customActivities = customActivities, studyActive = study.condition != null, guided = guide.signal,
                  onTestSound = { viewModel.testSignal(it) }, onContinue = viewModel::silence,
                )
                Route.DECIDE -> DecideScreen(reminder, customActivities, askSignalQuestions = reminder.signalDelivered, guided = guide.decide) { outcome, knew, recalled, feeling ->
                  viewModel.completeEvaluation(outcome, knew, recalled, feeling)
                  acknowledgement = if (settings.acknowledgements) acknowledgementFor(outcome) else null
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
                Route.NOTICES -> NoticesScreen(settings, onChange = viewModel::updateSettings, onBack = { pop() })
                Route.APPEARANCE -> AppearanceScreen(settings, onChange = viewModel::updateSettings, onBack = { pop() })
                Route.PERMISSIONS -> PermissionsScreen(usageAccess, backgroundUnrestricted, viewModel::openUsageAccessSettings, viewModel::requestBackgroundAccess, onBack = { pop() })
                Route.HISTORY -> HistoryScreen(history, customActivities, onBack = { pop() })
                Route.ACTIVITIES -> ActivitiesScreen(
                  customActivities,
                  onOpen = { id -> editingActivityId = id; push(Route.ACTIVITY_EDIT) },
                  onNew = { editingActivityId = null; push(Route.ACTIVITY_EDIT) },
                  onPrepare = { custom -> homeActions.onCustom(custom, com.example.relevo.ui.photoKey("propia", custom.id)) },
                  onBack = { pop() },
                )
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
                Route.STUDY -> StudyScreen(study, reminder.participantCode, participation == ParticipationMode.STUDY, onStart = viewModel::startStudy, onEnd = viewModel::endStudy, onBack = { pop() })
                Route.WEEK -> {
                  val week = study.pendingWeek
                  if (week == null) LaunchedEffect(Unit) { pop() }
                  else WeekReviewScreen(week, study.plan?.conditionOfWeek(week),
                    onSubmit = { preparation, annoyance, place, comment -> viewModel.submitWeek(week, preparation, annoyance, place, comment); pop() },
                    onLater = { pop() })
                }
                Route.CLOSING -> ClosingScreen(onSubmit = { viewModel.submitClosing(it); pop() }, onLater = { pop() })
                Route.FEEDBACK -> FeedbackScreen(onSend = { stars, comment -> viewModel.submitFeedback(stars, comment); pop() }, onBack = { pop() })
                Route.REPORT -> ReportScreen(onSend = { text, attach -> viewModel.submitReport(text, attach); pop() }, onBack = { pop() })
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
    }
    // Las hojas van sobre todo y desenfocan la app que queda detrás.
    SheetHost(sheets, rootHaze)
  }
  }

  // En Ruta o Perfil, volver lleva a Inicio antes de salir de la app.
  BackHandler(enabled = current == Route.TABS && tab != Tab.HOME) { tab = Tab.HOME }
}

/**
 * Contenedor de las pestañas: el contenido ocupa toda la pantalla y pasa bajo la barra de pestañas,
 * que flota en vidrio. Cada pestaña conserva su desplazamiento; tocar la elegida sube al comienzo.
 */
@Composable
private fun TabsHost(tab: Tab, reselect: Int, onTab: (Tab) -> Unit, content: @Composable (Tab) -> Unit) {
  val holder = rememberSaveableStateHolder()
  val reduce = rememberReduceMotion()
  val tabHaze = rememberHazeState()
  Box(Modifier.fillMaxSize()) {
    Box(Modifier.fillMaxSize().hazeSource(tabHaze)) {
      CompositionLocalProvider(LocalDockInset provides TabBarHeight + 12.dp) {
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
      TabBar(
        Tab.entries.map { TabItem(it.label, it.icon) }, Tab.entries.indexOf(tab), { onTab(Tab.entries[it]) },
        Modifier.align(Alignment.BottomCenter).navigationBarsPadding().padding(start = 22.dp, end = 22.dp, bottom = 12.dp),
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
