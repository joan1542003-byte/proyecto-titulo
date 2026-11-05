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
import com.example.relevo.MainActivity
import com.example.relevo.data.AutoModeStore
import com.example.relevo.data.Participation
import com.example.relevo.data.RemoteSync
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.ResearchBackup
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.data.SettingsStore
import com.example.relevo.data.TagStore
import com.example.relevo.domain.AutoMode
import com.example.relevo.domain.QuietHours
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.SignalRoute
import com.example.relevo.signal.SignalPlayer
import com.example.relevo.signal.TagLink
import java.time.LocalTime
import java.util.UUID
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Cuenta el tiempo en las apps elegidas mientras un relevo está activo y, al cumplirse, hace sonar lo que
 * la persona eligió. Con la activación automática, espera a que se abra una de esas apps. Corre en primer
 * plano, con una notificación permanente, como pide Android para un trabajo que la persona inició.
 */
class AppUsageMonitorService : Service() {
  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
  private lateinit var store: ReminderStore
  private lateinit var researchLog: ResearchLogStore
  private lateinit var signalPlayer: SignalPlayer
  private lateinit var autoMode: AutoModeStore
  private lateinit var settings: SettingsStore
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
    settings = SettingsStore(this)
    lastConfiguration = ReminderStore(this, ReminderStore.LAST_CONFIGURATION)
    messageStream = MessageStream(this, scope)
    createNotificationChannels()
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val reminder = store.load()
    val counting = reminder.status == ReminderStatus.WAITING
    // Android exige mostrar la notificación de primer plano antes de detenerse, incluso si no se va a contar.
    startInForeground(if (counting) Ongoing.COUNTING else Ongoing.WATCHING, reminder)
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
    TagLink.release()
    scope.cancel()
    super.onDestroy()
  }

  /** Qué dice la notificación permanente. */
  private enum class Ongoing { COUNTING, QUIET, WATCHING, TAG_MISSING }

  private fun startInForeground(state: Ongoing, reminder: Reminder = store.load()) {
    val minutes = (reminder.requiredUsageSeconds / 60).coerceAtLeast(1)
    val current = settings.load()
    val (title, text) = when (state) {
      Ongoing.COUNTING -> "Tu relevo está contando" to "Suena al sumar $minutes min en tus apps"
      Ongoing.QUIET -> "Tu relevo está en pausa" to "Horas sin sonar, hasta las ${current.quietUntil}:00"
      Ongoing.WATCHING -> "Activación automática" to "Cuenta cuando abras las apps de tu último relevo"
      Ongoing.TAG_MISSING -> "Tu relevo está contando" to "El Tag no responde; si sigue así, sonará el teléfono"
    }
    val notification =
      NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle(title)
        .setContentText(text)
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

  /** Está dentro de las horas sin sonar que eligió la persona (1.0.0). */
  private fun quietNow(): Boolean = settings.load().let { it.quietHours && QuietHours.contains(LocalTime.now().hour, it.quietFrom, it.quietUntil) }

  private fun startMonitoring() {
    monitorJob?.cancel()
    isWatching = false
    isCounting = true
    messageStream.start()
    // El Tag se conecta al activar el relevo y se mantiene así hasta que suena (D-109).
    if (store.load().signalRoute == SignalRoute.TAG) TagStore(this).address?.let { TagLink.hold(this, it) }
    val startedAt = System.currentTimeMillis()
    // Se revisa un periodo previo para saber qué app estaba abierta al empezar o al retomar.
    lastQueryMillis = startedAt - LOOKBACK_MILLIS
    val tracker = ForegroundTracker(startedAt).apply { accumulatedMillis = store.load().observedUsageSeconds * 1_000L }
    monitorJob =
      scope.launch {
        var wasTargetForeground = false
        var lastTargetPackage = store.load().targetPackage
        var ticks = 0L
        var wasQuiet = false
        var tagChecked = false

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

          // En las horas sin sonar el relevo sigue activo, pero no cuenta: así no suena a esa hora.
          val quiet = quietNow()
          if (quiet != wasQuiet) {
            wasQuiet = quiet
            researchLog.logApp(reminder.participantCode, if (quiet) "horas_sin_sonar_inicio" else "horas_sin_sonar_fin", reminder.activity)
            startInForeground(if (quiet) Ongoing.QUIET else Ongoing.COUNTING, reminder)
          }

          val now = System.currentTimeMillis()
          readUsageEvents(now, tracker)
          tracker.tick(now) { !quiet && reminder.tracks(it) }
          // Entrar y salir de una app elegida se registra aunque sean horas sin sonar.
          val targetForeground = reminder.tracks(tracker.currentPackage)

          if (targetForeground != wasTargetForeground || (targetForeground && tracker.currentPackage != lastTargetPackage)) {
            // Pasar de una app elegida a otra también queda registrado como salida y entrada.
            if (wasTargetForeground) researchLog.record(reminder.sessionId, reminder.participantCode, "target_left", lastTargetPackage, (tracker.accumulatedMillis / 1_000L).toInt())
            if (targetForeground) {
              lastTargetPackage = tracker.currentPackage.orEmpty()
              researchLog.record(reminder.sessionId, reminder.participantCode, "target_entered", lastTargetPackage, (tracker.accumulatedMillis / 1_000L).toInt())
            }
            wasTargetForeground = targetForeground
          }

          val observedSeconds = (tracker.accumulatedMillis / 1_000L).toInt()
          if (observedSeconds != reminder.observedUsageSeconds) {
            store.save(reminder.copy(observedUsageSeconds = observedSeconds))
          }

          // Antes de que se cumpla el tiempo, Relevo busca el Tag; así sabe con tiempo si tendrá que sonar en el
          // teléfono (pedido de la comisión del 28 de octubre, Tabla 4 de la memoria).
          if (!tagChecked && reminder.signalRoute == SignalRoute.TAG && reminder.requiredUsageSeconds - observedSeconds <= TAG_CHECK_SECONDS) {
            tagChecked = true
            launch(Dispatchers.IO) { checkTagBeforeSignal(reminder) }
          }

          if (observedSeconds >= reminder.requiredUsageSeconds) {
            deliverSignal(reminder.copy(observedUsageSeconds = observedSeconds))
            break
          }

          delay(POLL_INTERVAL_MILLIS)
        }
        TagLink.release()
        // Con la activación automática, al terminar un relevo vuelve a esperar en vez de detenerse.
        if (autoMode.enabled && hasCurrentConsent()) startWatching() else stopMonitoring()
      }
  }

  /**
   * Abre la conexión con el Tag si no está abierta. Si no responde, la notificación lo dice: al cumplirse
   * el tiempo, Relevo lo intenta de nuevo y, si sigue sin responder, suena en el teléfono.
   */
  private suspend fun checkTagBeforeSignal(reminder: Reminder) {
    val address = TagStore(this).address
    val ok = address != null && TagLink.hasPermissions(this) &&
      (TagLink.isConnectedTo(address) || withTimeoutOrNull(TAG_CHECK_TIMEOUT_MILLIS) { TagLink.reconnect(this@AppUsageMonitorService, address) } == true)
    researchLog.logApp(reminder.participantCode, "tag_revisado_antes", if (ok) "responde" else "no_responde")
    if (!ok && store.load().status == ReminderStatus.WAITING) startInForeground(Ongoing.TAG_MISSING, reminder)
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
    startInForeground(Ongoing.WATCHING)
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
            startInForeground(Ongoing.COUNTING, current)
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
          // En las horas sin sonar no se activa solo: el relevo no contaría.
          if (!quietNow() && AutoMode.shouldArm(true, current.status, last, tracker.currentPackage, now, autoMode.lastClosedAt) && armAutomatically(last)) {
            isWatching = false
            startInForeground(Ongoing.COUNTING)
            startMonitoring()
            return@launch
          }
          delay(WATCH_INTERVAL_MILLIS)
        }
        isWatching = false
        stopMonitoring()
      }
  }

  /** Activa el último relevo, igual que al activarlo a mano. */
  private fun armAutomatically(last: Reminder): Boolean {
    val code = Participation.code(this).ifBlank { return false }
    val next = AutoMode.fromLast(last, code, UUID.randomUUID().toString())
    if (next.status != ReminderStatus.WAITING) return false
    store.save(next)
    researchLog.record(next.sessionId, next.participantCode, "armed", next.targetPackage, 0)
    researchLog.startSession(next)
    researchLog.logApp(code, "relevo_automatico", next.activity)
    scope.launch(Dispatchers.IO) { RemoteSync(this@AppUsageMonitorService, researchLog).syncPending() }
    return true
  }

  /**
   * Suena unos 30 segundos y termina solo (D-078). Si el Tag no responde, suena una notificación en el
   * teléfono, que siempre está a mano (1.0.0). Después, la pantalla y la notificación quedan en silencio
   * hasta que la persona responde.
   */
  private suspend fun deliverSignal(reminder: Reminder) {
    val signalAt = System.currentTimeMillis()
    val tracked = reminder.selectedApps.map { it.packageName }.toSet()
    val usageBefore = UsageWindow.trackedSeconds(this, signalAt - UsageWindow.WINDOW_MILLIS, signalAt, tracked)
    val ending = CompletableDeferred<SignalPlayer.Ending>()
    var audible = signalPlayer.play(reminder.signalRoute, SignalPlayer.Pattern.SIGNAL) { ending.complete(it) }
    var onPhone = false
    if (!audible && reminder.signalRoute == SignalRoute.TAG) {
      onPhone = signalPlayer.play(SignalRoute.PHONE, SignalPlayer.Pattern.SIGNAL) { ending.complete(it) }
      audible = onPhone
      researchLog.logApp(reminder.participantCode, "tag_sin_respuesta", if (onPhone) "sono_en_el_telefono" else "no_sono")
    }
    val signalled = reminder.deliverSignal(audible, signalAt, onPhone)
    store.save(signalled)
    researchLog.record(signalled.sessionId, signalled.participantCode, if (audible) "signal_emitted" else "signal_failed", signalled.targetPackage, signalled.observedUsageSeconds)
    if (audible) researchLog.markSignal(signalled.sessionId, signalled.observedUsageSeconds, signalAt, usageBefore)
    // La carga de la pila del Tag al sonar, si la informó al conectarse: explica sonidos que no se oyeron (2.31).
    if (reminder.signalRoute == SignalRoute.TAG) TagStore(this).battery?.let { researchLog.logApp(signalled.participantCode, "llavero_pila", "pila=$it") }
    researchLog.markAppSeconds(signalled.sessionId, signalAt)
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
        // Se apretó el botón del Tag: el sonido se calló en el objeto, sin abrir la app (D-109).
        SignalPlayer.Ending.SILENCED_ON_OBJECT -> {
          researchLog.record(signalled.sessionId, signalled.participantCode, "silenced_object", signalled.targetPackage, seconds)
          researchLog.markSignalEnd(signalled.sessionId, "object")
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
   * Sin el permiso de Tiempo de uso no se puede contar. El relevo sigue activo, pero el conteo se detiene
   * y la persona recibe una notificación para dar el permiso o desactivar el relevo.
   */
  private fun pauseForMissingAccess(sessionId: String, participantCode: String, targetPackage: String, observedSeconds: Int) {
    researchLog.record(sessionId, participantCode, "monitor_paused", targetPackage, observedSeconds)
    getSystemService(NotificationManager::class.java)?.notify(
      STATUS_NOTIFICATION_ID,
      NotificationCompat.Builder(this, STATUS_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle("Tu relevo dejó de contar")
        .setContentText("Falta el permiso de Tiempo de uso")
        .setStyle(NotificationCompat.BigTextStyle().bigText("Falta el permiso de Tiempo de uso. Abre Relevo para darlo o para desactivar el relevo."))
        .setContentIntent(openAppIntent())
        .setAutoCancel(true)
        .build(),
    )
    stopMonitoring()
  }

  /** Relevo cuenta solo con el consentimiento vigente. */
  private fun hasCurrentConsent(): Boolean = Participation.participating(this)

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
        description = "Muestra que tu relevo está contando o que la activación automática está encendida."
      },
    )
    manager.createNotificationChannel(
      NotificationChannel(SIGNAL_CHANNEL_ID, "Cuando suena tu relevo", NotificationManager.IMPORTANCE_HIGH).apply {
        description = "Aparece cuando sumas el tiempo que elegiste. El sonido lo pone Relevo."
        setSound(null, null)
        enableVibration(true)
      },
    )
    manager.createNotificationChannel(
      NotificationChannel(STATUS_CHANNEL_ID, "Estado del relevo", NotificationManager.IMPORTANCE_DEFAULT).apply {
        description = "Avisa si tu relevo dejó de contar, por ejemplo al quitar un permiso."
        setSound(null, null)
      },
    )
  }

  /**
   * La notificación de cuando suena: la actividad como título y, primero, cómo empezar (R11 del estudio de
   * los textos). En la pantalla bloqueada se ve una versión que no dice la actividad.
   */
  private fun showCompletionNotification(reminder: Reminder, audible: Boolean) {
    val manager = getSystemService(NotificationManager::class.java) ?: return
    val publicVersion = NotificationCompat.Builder(this, SIGNAL_CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_stat_relevo)
      .setContentTitle("Relevo")
      .setContentText(PUBLIC_SIGNAL_TEXT)
      .build()
    val start = reminder.howToStart.trim().trimEnd('.').replaceFirstChar { it.lowercase() }
    val text = when {
      !audible -> "No sonó en ${routeName(reminder.signalRoute)}. Abre Relevo para revisarlo"
      reminder.soundedOnPhone -> "El Tag no respondió y sonó el teléfono"
      start.isNotBlank() -> "Para empezar: $start"
      else -> PUBLIC_SIGNAL_TEXT
    }
    manager.notify(
      SIGNAL_NOTIFICATION_ID,
      NotificationCompat.Builder(this, SIGNAL_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle(reminder.activity.trim().ifBlank { "Relevo" })
        .setContentText(text)
        .setStyle(NotificationCompat.BigTextStyle().bigText(if (reminder.soundedOnPhone && start.isNotBlank()) "$text. Para empezar: $start" else text))
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

  private fun routeName(route: SignalRoute): String = when (route) {
    SignalRoute.TAG -> "el Tag"
    SignalRoute.BLUETOOTH -> "el dispositivo de audio"
    SignalRoute.PHONE -> "el teléfono"
  }

  companion object {
    const val ACTION_RESTORE = "cl.udp.relevo.action.RESTORE_MONITOR"
    const val PUBLIC_SIGNAL_TEXT = "Suena tu relevo"

    /** Retira la notificación de cuando suena, si la persona ya respondió en la app. */
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
    /** El Tag se busca cuando falta un minuto y medio, con hasta 30 s para responder. */
    private const val TAG_CHECK_SECONDS = 90
    private const val TAG_CHECK_TIMEOUT_MILLIS = 30_000L
  }
}
