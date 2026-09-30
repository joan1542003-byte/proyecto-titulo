package com.example.relevo.monitor

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import cl.udp.relevo.R
import com.example.relevo.data.AutoModeStore
import com.example.relevo.data.Participation
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.data.RemoteSync
import com.example.relevo.data.ResearchBackup
import com.example.relevo.data.StudyStore
import com.example.relevo.domain.AutoMode
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.StudyCondition
import com.example.relevo.domain.StudyPlan
import java.time.LocalDate
import java.util.UUID
import kotlinx.coroutines.CompletableDeferred
import com.example.relevo.signal.SignalPlayer
import com.example.relevo.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AppUsageMonitorService : Service() {
  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
  private lateinit var store: ReminderStore
  private lateinit var researchLog: ResearchLogStore
  private lateinit var signalPlayer: SignalPlayer
  private lateinit var autoMode: AutoModeStore
  private lateinit var lastConfiguration: ReminderStore
  /** Mensajes del proyecto al instante mientras el servicio está activo (D-096). */
  private lateinit var messageStream: MessageStream
  private var monitorJob: Job? = null
  private var lastQueryMillis: Long = 0L

  override fun onCreate() {
    super.onCreate()
    store = ReminderStore(this)
    researchLog = ResearchLogStore(this)
    signalPlayer = SignalPlayer(this)
    autoMode = AutoModeStore(this)
    lastConfiguration = ReminderStore(this, ReminderStore.LAST_CONFIGURATION)
    messageStream = MessageStream(this, scope)
    createNotificationChannels()
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val reminder = store.load()
    val counting = reminder.status == ReminderStatus.WAITING
    // Android exige mostrar la notificación de primer plano antes de detenerse, incluso si no se va a contar.
    startInForeground(counting)
    if (!hasCurrentConsent()) {
      stopMonitoring()
      return START_NOT_STICKY
    }
    if (!counting) {
      // Activación automática (D-095): espera a que se abra una app del último relevo.
      if (autoMode.enabled && UsageAccess.isGranted(this)) {
        if (!isWatching) startWatching()
        return START_STICKY
      }
      stopMonitoring()
      return START_NOT_STICKY
    }
    // Sin intent: Android recreó el servicio tras detenerlo. ACTION_RESTORE: reinicio del teléfono o actualización.
    val restored = intent == null || intent.action == ACTION_RESTORE
    if (!UsageAccess.isGranted(this)) {
      pauseForMissingAccess(reminder.sessionId, reminder.participantCode, reminder.targetPackage, reminder.observedUsageSeconds)
      return START_NOT_STICKY
    }
    if (restored) {
      researchLog.record(reminder.sessionId, reminder.participantCode, "monitor_resumed", reminder.targetPackage, reminder.observedUsageSeconds)
    }
    getSystemService(NotificationManager::class.java)?.cancel(STATUS_NOTIFICATION_ID)
    startMonitoring()
    return START_STICKY
  }

  override fun onBind(intent: Intent?): IBinder? = null

  override fun onDestroy() {
    isCounting = false
    isWatching = false
    messageStream.stop()
    monitorJob?.cancel()
    signalPlayer.stop()
    scope.cancel()
    super.onDestroy()
  }

  /** [counting]: hay un relevo contando. Si no, Relevo espera para activarse solo (D-095). */
  private fun startInForeground(counting: Boolean = true) {
    val notification =
      NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle(if (counting) "Relevo está contando tu tiempo en las apps que elegiste" else "Relevo se activará solo")
        .setContentText(if (counting) "Deja de contar cuando desactivas el relevo." else "Empieza a contar cuando abras las apps de tu último relevo.")
        .setContentIntent(openAppIntent())
        .setOngoing(true)
        .setSilent(true)
        .build()
    val serviceType =
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE else 0
    ServiceCompat.startForeground(this, NOTIFICATION_ID, notification, serviceType)
  }

  private fun stopMonitoring() {
    isCounting = false
    isWatching = false
    messageStream.stop()
    ServiceCompat.stopForeground(this, ServiceCompat.STOP_FOREGROUND_REMOVE)
    stopSelf()
  }

  private fun startMonitoring() {
    monitorJob?.cancel()
    isWatching = false
    isCounting = true
    messageStream.start()
    val startedAt = System.currentTimeMillis()
    // Se revisa un periodo previo para saber qué app estaba abierta al empezar o al retomar.
    lastQueryMillis = startedAt - LOOKBACK_MILLIS
    val tracker = ForegroundTracker(startedAt).apply { accumulatedMillis = store.load().observedUsageSeconds * 1_000L }
    monitorJob =
      scope.launch {
        var wasTargetForeground = false
        var lastTargetPackage = store.load().targetPackage
        var ticks = 0L

        while (true) {
          val reminder = store.load()
          if (reminder.status != ReminderStatus.WAITING || !hasCurrentConsent()) break

          ticks += 1
          if (ticks % ACCESS_CHECK_TICKS == 0L && !UsageAccess.isGranted(this@AppUsageMonitorService)) {
            pauseForMissingAccess(reminder.sessionId, reminder.participantCode, lastTargetPackage, reminder.observedUsageSeconds)
            return@launch
          }
          if (ticks % SYNC_TICKS == 0L) launch(Dispatchers.IO) {
            UsageAfterSignal.update(this@AppUsageMonitorService, researchLog)
            RemoteSync(this@AppUsageMonitorService, researchLog).syncPending()
          }
          if (ticks % MESSAGE_TICKS == 0L) launch(Dispatchers.IO) { ProjectMessages.check(this@AppUsageMonitorService) }

          val now = System.currentTimeMillis()
          readUsageEvents(now, tracker)
          val targetForeground = tracker.tick(now, reminder::tracks)

          if (targetForeground != wasTargetForeground || (targetForeground && tracker.currentPackage != lastTargetPackage)) {
            val entered = targetForeground
            // Pasar de una app elegida a otra también queda registrado como salida y entrada.
            if (wasTargetForeground) researchLog.record(reminder.sessionId, reminder.participantCode, "target_left", lastTargetPackage, (tracker.accumulatedMillis / 1_000L).toInt())
            if (entered) {
              lastTargetPackage = tracker.currentPackage.orEmpty()
              researchLog.record(reminder.sessionId, reminder.participantCode, "target_entered", lastTargetPackage, (tracker.accumulatedMillis / 1_000L).toInt())
            }
            wasTargetForeground = targetForeground
          }

          val observedSeconds = (tracker.accumulatedMillis / 1_000L).toInt()
          if (observedSeconds != reminder.observedUsageSeconds) {
            store.save(reminder.copy(observedUsageSeconds = observedSeconds))
          }

          if (observedSeconds >= reminder.requiredUsageSeconds) {
            deliverSignal(reminder.copy(observedUsageSeconds = observedSeconds))
            break
          }

          delay(POLL_INTERVAL_MILLIS)
        }
        // Con la activación automática, al terminar un relevo vuelve a esperar en vez de detenerse.
        if (autoMode.enabled && hasCurrentConsent()) startWatching() else stopMonitoring()
      }
  }

  /**
   * Activación automática (D-095): mira qué app está en primer plano, solo su nombre, y activa el último
   * relevo cuando se abre una de sus apps, si no hay otro en curso y ya pasó la pausa desde el anterior.
   */
  private fun startWatching() {
    monitorJob?.cancel()
    isCounting = false
    isWatching = true
    messageStream.start()
    startInForeground(counting = false)
    val startedAt = System.currentTimeMillis()
    lastQueryMillis = startedAt - LOOKBACK_MILLIS
    val tracker = ForegroundTracker(startedAt)
    monitorJob =
      scope.launch {
        var ticks = 0L
        while (true) {
          if (!autoMode.enabled || !hasCurrentConsent()) break
          val current = store.load()
          if (current.status == ReminderStatus.WAITING) {
            // Se activó un relevo a mano mientras Relevo esperaba: pasa a contarlo.
            isWatching = false
            startInForeground(counting = true)
            startMonitoring()
            return@launch
          }
          ticks += 1
          if (ticks % WATCH_ACCESS_TICKS == 0L && !UsageAccess.isGranted(this@AppUsageMonitorService)) break
          if (ticks % WATCH_MESSAGE_TICKS == 0L) launch(Dispatchers.IO) { ProjectMessages.check(this@AppUsageMonitorService) }
          val now = System.currentTimeMillis()
          readUsageEvents(now, tracker)
          tracker.tick(now) { false }
          val last = lastConfiguration.load()
          if (AutoMode.shouldArm(true, current.status, last, tracker.currentPackage, now, autoMode.lastClosedAt) && armAutomatically(last)) {
            isWatching = false
            startInForeground(counting = true)
            startMonitoring()
            return@launch
          }
          delay(WATCH_INTERVAL_MILLIS)
        }
        isWatching = false
        stopMonitoring()
      }
  }

  /** Activa el último relevo con el día y la condición de hoy, igual que al activarlo a mano. */
  private fun armAutomatically(last: Reminder): Boolean {
    val code = Participation.code(this).ifBlank { return false }
    val plan = StudyStore(this).plan()
    val today = LocalDate.now()
    val day = plan?.day(today)?.takeIf { it in 0..StudyPlan.LAST_DAY } ?: -1
    val next = AutoMode.fromLast(last, code, plan?.condition(today), day, UUID.randomUUID().toString())
    if (next.status != ReminderStatus.WAITING) return false
    store.save(next)
    researchLog.record(next.sessionId, next.participantCode, "armed", next.targetPackage, 0)
    researchLog.startSession(next)
    researchLog.logApp(code, "relevo_automatico", next.activity)
    scope.launch(Dispatchers.IO) { RemoteSync(this@AppUsageMonitorService, researchLog).syncPending() }
    return true
  }

  /**
   * Emite la señal de D-078: unos 30 segundos que terminan solos. Después, la pantalla y la
   * notificación quedan visibles en silencio hasta que la persona responde.
   */
  private suspend fun deliverSignal(reminder: Reminder) {
    val signalAt = System.currentTimeMillis()
    val tracked = reminder.selectedApps.map { it.packageName }.toSet()
    val usageBefore = UsageWindow.trackedSeconds(this, signalAt - UsageWindow.WINDOW_MILLIS, signalAt, tracked)
    val ending = CompletableDeferred<SignalPlayer.Ending>()
    val audible = signalPlayer.play(reminder.signalRoute, SignalPlayer.Pattern.SIGNAL) { ending.complete(it) }
    val signalled = reminder.deliverSignal(audible, signalAt)
    store.save(signalled)
    researchLog.record(signalled.sessionId, signalled.participantCode, if (audible) "signal_emitted" else "signal_failed", signalled.targetPackage, signalled.observedUsageSeconds)
    if (audible) researchLog.markSignal(signalled.sessionId, signalled.observedUsageSeconds, signalAt, usageBefore)
    scope.launch(Dispatchers.IO) {
      RemoteSync(this@AppUsageMonitorService, researchLog).syncPending()
      ResearchBackup.write(this@AppUsageMonitorService, researchLog, signalled.participantCode)
    }
    showCompletionNotification(signalled, audible)
    if (!audible) return

    // Espera a que la persona responda o a que el sonido termine.
    while (store.load().status == ReminderStatus.SIGNALLED && !ending.isCompleted) delay(250L)
    if (ending.isCompleted && store.load().status == ReminderStatus.SIGNALLED) {
      val seconds = ((System.currentTimeMillis() - signalAt) / 1_000L).toInt()
      when (ending.await()) {
        SignalPlayer.Ending.COMPLETED -> {
          researchLog.record(signalled.sessionId, signalled.participantCode, "signal_ended", signalled.targetPackage, seconds)
          researchLog.markSignalEnd(signalled.sessionId, "auto")
        }
        SignalPlayer.Ending.ROUTE_LOST -> {
          researchLog.record(signalled.sessionId, signalled.participantCode, "signal_interrupted", signalled.targetPackage, seconds)
          researchLog.markSignalEnd(signalled.sessionId, "interrupted")
        }
        SignalPlayer.Ending.STOPPED -> Unit
      }
      store.save(store.load().endSignal())
    }
    signalPlayer.stop()
  }

  private fun readUsageEvents(nowMillis: Long, tracker: ForegroundTracker) {
    val usageStats = getSystemService(UsageStatsManager::class.java) ?: return
    val events = usageStats.queryEvents(lastQueryMillis, nowMillis)
    val event = UsageEvents.Event()
    while (events.hasNextEvent()) {
      events.getNextEvent(event)
      when (event.eventType) {
        UsageEvents.Event.ACTIVITY_RESUMED -> tracker.onEvent(ForegroundTracker.Kind.RESUMED, event.packageName)
        UsageEvents.Event.ACTIVITY_PAUSED -> tracker.onEvent(ForegroundTracker.Kind.PAUSED, event.packageName)
        UsageEvents.Event.SCREEN_NON_INTERACTIVE -> tracker.onEvent(ForegroundTracker.Kind.SCREEN_OFF, null)
      }
    }
    lastQueryMillis = nowMillis
  }

  /**
   * Sin acceso a Tiempo de uso no se puede contar. El relevo sigue activo, pero el conteo se detiene
   * y la persona recibe un aviso visible para reactivarlo o desactivarlo.
   */
  private fun pauseForMissingAccess(sessionId: String, participantCode: String, targetPackage: String, observedSeconds: Int) {
    researchLog.record(sessionId, participantCode, "monitor_paused", targetPackage, observedSeconds)
    getSystemService(NotificationManager::class.java)?.notify(
      STATUS_NOTIFICATION_ID,
      NotificationCompat.Builder(this, STATUS_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle("Relevo dejó de contar")
        .setContentText("Falta el permiso de Tiempo de uso. Abre Relevo para darlo o desactivar el relevo.")
        .setStyle(NotificationCompat.BigTextStyle().bigText("Falta el permiso de Tiempo de uso. Abre Relevo para darlo o desactivar el relevo."))
        .setContentIntent(openAppIntent())
        .setAutoCancel(true)
        .build(),
    )
    stopMonitoring()
  }

  /** Cuenta si la persona participa o eligió usar Relevo sin participar; el registro decide aparte si guarda. */
  private fun hasCurrentConsent(): Boolean = Participation.canUse(this)

  private fun openAppIntent(): PendingIntent = PendingIntent.getActivity(
    this,
    0,
    Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP),
    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
  )

  private fun createNotificationChannels() {
    val manager = getSystemService(NotificationManager::class.java) ?: return
    manager.createNotificationChannel(
      NotificationChannel(CHANNEL_ID, "Relevo activo", NotificationManager.IMPORTANCE_LOW).apply {
        description = "Muestra que Relevo está contando el tiempo en las apps que elegiste o esperando para activarse solo."
      },
    )
    manager.createNotificationChannel(
      NotificationChannel(SIGNAL_CHANNEL_ID, "Señal de Relevo", NotificationManager.IMPORTANCE_HIGH).apply {
        description = "Suena cuando sumas el tiempo que elegiste."
        setSound(null, null)
        enableVibration(true)
      },
    )
    manager.createNotificationChannel(
      NotificationChannel(STATUS_CHANNEL_ID, "Estado del relevo", NotificationManager.IMPORTANCE_DEFAULT).apply {
        description = "Avisa si Relevo dejó de contar, por ejemplo al retirar un permiso."
        setSound(null, null)
      },
    )
  }

  /**
   * La notificación de la señal. En la condición «teléfono» es genérica y no muestra la intención
   * hasta abrir la app (protocolo 02). En la pantalla de bloqueo, siempre se ve la versión genérica.
   */
  private fun showCompletionNotification(reminder: Reminder, audible: Boolean) {
    val manager = getSystemService(NotificationManager::class.java) ?: return
    val generic = reminder.studyCondition == StudyCondition.PHONE.code.toString()
    val publicVersion = NotificationCompat.Builder(this, SIGNAL_CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_stat_relevo)
      .setContentTitle("Relevo")
      .setContentText(GENERIC_SIGNAL_TEXT)
      .build()
    val text = when {
      !audible && reminder.signalRoute == SignalRoute.BLUETOOTH -> "No se encontró el parlante. Abre Relevo para revisarlo."
      !audible && reminder.signalRoute == SignalRoute.WATCH -> "No se encontró el reloj. Abre Relevo para revisarlo."
      !audible -> "No sonó en el teléfono. Abre Relevo para revisarlo."
      generic -> GENERIC_SIGNAL_TEXT
      reminder.howToStart.isBlank() -> "Es momento de volver a elegir."
      else -> "Es momento de volver a elegir. Empieza por ${reminder.howToStart.trim().trimEnd('.').replaceFirstChar { it.lowercase() }}."
    }
    manager.notify(
      SIGNAL_NOTIFICATION_ID,
      NotificationCompat.Builder(this, SIGNAL_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle(if (generic && audible) "Relevo" else reminder.activity)
        .setContentText(text)
        .setContentIntent(openAppIntent())
        .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
        .setPublicVersion(publicVersion)
        .setAutoCancel(true)
        .setSilent(true)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setCategory(NotificationCompat.CATEGORY_ALARM)
        .build(),
    )
  }

  companion object {
    const val ACTION_RESTORE = "cl.udp.relevo.action.RESTORE_MONITOR"
    const val GENERIC_SIGNAL_TEXT = "Es momento de volver a elegir"

    /** Retira la notificación de la señal cuando la persona ya respondió en la app. */
    fun cancelSignalNotification(context: android.content.Context) {
      context.getSystemService(NotificationManager::class.java)?.cancel(SIGNAL_NOTIFICATION_ID)
    }

    /** Indica si el conteo está en marcha en este proceso; evita reiniciarlo cada vez que se abre la app. */
    @Volatile var isCounting = false
      private set

    /** Indica si Relevo está esperando para activarse solo (D-095). */
    @Volatile var isWatching = false
      private set
    private const val CHANNEL_ID = "relevo_monitor"
    private const val NOTIFICATION_ID = 1101
    private const val SIGNAL_NOTIFICATION_ID = 1102
    private const val STATUS_NOTIFICATION_ID = 1103
    private const val SIGNAL_CHANNEL_ID = "relevo_signal_bluetooth_v2"
    private const val STATUS_CHANNEL_ID = "relevo_status"
    private const val POLL_INTERVAL_MILLIS = 1_000L
    private const val LOOKBACK_MILLIS = 15 * 60_000L
    private const val ACCESS_CHECK_TICKS = 30L
    private const val SYNC_TICKS = 15 * 60L
    /** Mensajes del proyecto: cada minuto mientras cuenta. */
    private const val MESSAGE_TICKS = 60L
    /** Mientras espera para activarse solo, revisa cada 3 segundos; los permisos y mensajes, cada minuto. */
    private const val WATCH_INTERVAL_MILLIS = 3_000L
    private const val WATCH_ACCESS_TICKS = 20L
    private const val WATCH_MESSAGE_TICKS = 20L
  }
}
