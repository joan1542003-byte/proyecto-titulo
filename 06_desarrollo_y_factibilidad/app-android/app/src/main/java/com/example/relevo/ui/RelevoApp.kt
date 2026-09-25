package com.example.relevo.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.rememberReduceMotion

internal enum class Route { WELCOME, CONSENT, PERMISSION, HOME, PREPARE, SIGNAL, DECIDE, SETTINGS, HISTORY, ACTIVITIES, PRIVACY, CONSENT_DETAILS, STUDY, WEEK, CLOSING }

/** Pantallas que dependen del estado del relevo y no se abandonan con el gesto de volver. */
private val stateScreens = setOf(Route.SIGNAL, Route.DECIDE)

@Composable
fun RelevoApp(viewModel: RelevoViewModel = viewModel()) {
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
  val context = LocalContext.current
  val reduce = rememberReduceMotion()
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { viewModel.onAppResumed() }

  val preferences = remember { context.getSharedPreferences("relevo_experience", android.content.Context.MODE_PRIVATE) }
  fun onboardingComplete() = preferences.getBoolean("onboarding_complete", false)
  fun completeOnboarding() = preferences.edit().putBoolean("onboarding_complete", true).apply()
  fun routeForStatus(status: ReminderStatus) = when (status) {
    ReminderStatus.SIGNALLED -> listOf(Route.HOME, Route.SIGNAL)
    ReminderStatus.SILENCED, ReminderStatus.CLOSED -> listOf(Route.HOME, Route.DECIDE)
    else -> listOf(Route.HOME)
  }
  fun initialStack(): List<Route> = when {
    preferences.getString("academic_consent_version", null) != ResearchLogStore.CONSENT_VERSION ->
      if (onboardingComplete()) listOf(Route.CONSENT) else listOf(Route.WELCOME)
    !onboardingComplete() -> listOf(Route.PERMISSION)
    else -> routeForStatus(reminder.status)
  }

  var stack by rememberSaveable(stateSaver = RouteStackSaver) { mutableStateOf(initialStack()) }
  var forward by remember { mutableStateOf(true) }
  var acknowledgement by rememberSaveable { mutableStateOf<String?>(null) }
  val current = stack.last()
  fun push(route: Route) { forward = true; stack = stack + route }
  fun pop() { if (stack.size > 1) { forward = false; stack = stack.dropLast(1) } }
  fun replace(routes: List<Route>, isForward: Boolean = true) { forward = isForward; stack = routes }

  // El estado del relevo decide la señal y la respuesta, aunque lleguen con la app en segundo plano.
  LaunchedEffect(reminder.status) {
    val inFirstRun = current in setOf(Route.WELCOME, Route.CONSENT, Route.PERMISSION)
    if (inFirstRun) return@LaunchedEffect
    when (reminder.status) {
      ReminderStatus.SIGNALLED -> if (current != Route.SIGNAL) replace(routeForStatus(reminder.status))
      ReminderStatus.SILENCED, ReminderStatus.CLOSED -> if (current != Route.DECIDE) replace(routeForStatus(reminder.status))
      else -> if (current in stateScreens || (current == Route.PREPARE && reminder.status == ReminderStatus.WAITING)) replace(listOf(Route.HOME), isForward = false)
    }
  }

  BackHandler(enabled = stack.size > 1 && current !in stateScreens && current != Route.PREPARE) { pop() }

  Box(Modifier.fillMaxSize().background(Relevo.colors.paper)) {
    AnimatedContent(
      targetState = current,
      transitionSpec = {
        if (reduce) {
          EnterTransition.None togetherWith ExitTransition.None
        } else if (forward) {
          (slideInHorizontally(Motion.standard()) { it } togetherWith slideOutHorizontally(Motion.standard()) { -it / 3 }).apply { targetContentZIndex = 1f }
        } else {
          (slideInHorizontally(Motion.standard()) { -it / 3 } togetherWith slideOutHorizontally(Motion.standard()) { it }).apply { targetContentZIndex = -1f }
        }
      },
      label = "navigation",
    ) { route ->
      Box(Modifier.fillMaxSize().background(Relevo.colors.paper)) {
        when (route) {
          Route.WELCOME -> WelcomeScreen(onStart = { push(Route.CONSENT) })
          Route.CONSENT -> ConsentScreen(
            remoteConfigured = viewModel.remoteConfigured,
            deletionPending = viewModel.deletionPending,
            onAccept = { viewModel.updateConsent(true); if (onboardingComplete()) replace(routeForStatus(reminder.status)) else push(Route.PERMISSION) },
            onDecline = { (context as? Activity)?.finishAndRemoveTask() },
            onPrivacy = { push(Route.PRIVACY) },
          )
          Route.PERMISSION -> PermissionScreen(
            usageAccess = usageAccess,
            onOpenUsageSettings = viewModel::openUsageAccessSettings,
            onRefresh = viewModel::refreshUsageAccess,
            onContinue = { configureFirst ->
              completeOnboarding()
              replace(if (configureFirst) listOf(Route.HOME, Route.PREPARE) else listOf(Route.HOME))
            },
          )
          Route.HOME -> HomeScreen(
            reminder = reminder, history = history, customActivities = customActivities, lastReminder = lastReminder,
            study = study, usageAccess = usageAccess, backgroundUnrestricted = backgroundUnrestricted,
            acknowledgement = acknowledgement, returnDismissedFor = returnDismissedFor,
            actions = HomeActions(
              onPrepare = { push(Route.PREPARE) },
              onRepeat = { viewModel.repeatLast(); push(Route.PREPARE) },
              onIdea = { viewModel.applyPreset(it.activity, it.start, it.place); push(Route.PREPARE) },
              onCustom = { viewModel.applyPreset(it.name, it.firstStep, it.place); push(Route.PREPARE) },
              onDisarm = viewModel::disarm,
              onSettings = { push(Route.SETTINGS) },
              onUsageSettings = viewModel::openUsageAccessSettings,
              onBackground = viewModel::requestBackgroundAccess,
              onDismissAcknowledgement = { acknowledgement = null },
              onDismissInstruction = viewModel::dismissInstruction,
              onWeekReview = { push(Route.WEEK) },
              onClosing = { push(Route.CLOSING) },
              onDismissReturn = viewModel::dismissReturn,
            ),
          )
          Route.PREPARE -> PrepareScreen(
            reminder = reminder, apps = apps, customActivities = customActivities, usageAccess = usageAccess,
            backgroundUnrestricted = backgroundUnrestricted, studyCondition = study.condition,
            actions = PrepareActions(
              onActivity = viewModel::updateActivity,
              onStart = viewModel::updateHowToStart,
              onPlace = viewModel::updatePlace,
              onIdea = viewModel::applyPreset,
              onToggleApp = viewModel::selectTargetApp,
              onDuration = viewModel::updateRequiredUsage,
              onRoute = viewModel::updateSignalRoute,
              onTestSound = viewModel::testSignal,
              onUsageSettings = viewModel::openUsageAccessSettings,
              onBackground = viewModel::requestBackgroundAccess,
              onSaveCustom = viewModel::saveCustomActivity,
              onActivate = { requestNotificationPermission(context); if (viewModel.activate()) replace(listOf(Route.HOME), isForward = false) },
              onClose = { pop() },
            ),
          )
          Route.SIGNAL -> SignalScreen(reminder, onTestSound = viewModel::testSignal, onContinue = viewModel::silence)
          Route.DECIDE -> DecideScreen(reminder, askSignalQuestions = study.active && reminder.signalDelivered) { outcome, knew, recalled ->
            viewModel.completeEvaluation(outcome, knew, recalled)
            acknowledgement = acknowledgementFor(outcome)
            viewModel.reset()
            replace(listOf(Route.HOME), isForward = false)
          }
          Route.SETTINGS -> SettingsScreen(
            study = study, historyCount = history.size, customCount = customActivities.size,
            usageAccess = usageAccess, backgroundUnrestricted = backgroundUnrestricted,
            actions = SettingsActions(
              onBack = { pop() },
              onHistory = { push(Route.HISTORY) },
              onActivities = { push(Route.ACTIVITIES) },
              onStudy = { push(Route.STUDY) },
              onPrivacy = { push(Route.PRIVACY) },
              onUsageSettings = viewModel::openUsageAccessSettings,
              onBackground = viewModel::requestBackgroundAccess,
            ),
          )
          Route.HISTORY -> HistoryScreen(history, customActivities, onBack = { pop() })
          Route.ACTIVITIES -> ActivitiesScreen(customActivities, onDelete = viewModel::deleteCustomActivity, onBack = { pop() })
          Route.PRIVACY -> PrivacyScreen(
            participantCode = reminder.participantCode,
            consentAccepted = reminder.consentAccepted,
            remoteConfigured = viewModel.remoteConfigured,
            syncStatus = syncStatus,
            deletionStatus = deletionStatus,
            onBack = { pop() },
            onConsent = { push(Route.CONSENT_DETAILS) },
            onDelete = viewModel::deleteResearchData,
            onRestart = { replace(listOf(Route.WELCOME)) },
          )
          Route.CONSENT_DETAILS -> ConsentDetailsScreen(viewModel.remoteConfigured, onBack = { pop() })
          Route.STUDY -> StudyScreen(study, reminder.participantCode, onStart = viewModel::startStudy, onEnd = viewModel::endStudy, onBack = { pop() })
          Route.WEEK -> {
            val week = study.pendingWeek
            if (week == null) LaunchedEffect(Unit) { pop() }
            else WeekReviewScreen(week, study.plan?.conditionOfWeek(week),
              onSubmit = { preparation, annoyance, place, comment -> viewModel.submitWeek(week, preparation, annoyance, place, comment); pop() },
              onLater = { pop() })
          }
          Route.CLOSING -> ClosingScreen(onSubmit = { viewModel.submitClosing(it); pop() }, onLater = { pop() })
        }
      }
    }
  }
}

private val RouteStackSaver = androidx.compose.runtime.saveable.Saver<List<Route>, ArrayList<String>>(
  save = { routes -> ArrayList(routes.map { it.name }) },
  restore = { names -> names.mapNotNull { name -> Route.entries.firstOrNull { it.name == name } }.ifEmpty { listOf(Route.HOME) } },
)
