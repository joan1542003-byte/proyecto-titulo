package com.example.relevo.monitor

import com.example.relevo.data.ActiveStore
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
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.ServiceCompat
import cl.udp.relevo.R
import com.example.relevo.data.AutoModeStore
import com.example.relevo.data.Participation
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.data.RemoteSync
import com.example.relevo.data.ResearchBackup
import com.example.relevo.data.SettingsStore
import com.example.relevo.data.TagStore
import com.example.relevo.domain.AutoMode
import com.example.relevo.domain.QuietHours
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.domain.SignalRoute
import java.time.LocalTime
import java.util.UUID
import kotlinx.coroutines.CompletableDeferred
import com.example.relevo.signal.SignalPlayer
import com.example.relevo.signal.TagLink
import com.example.relevo.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

class AppUsageMonitorService : Service() {
  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
  private lateinit var store: ReminderStore
  /** Relevos que cuentan; puede haber varios (4.3, D-158). [store] queda para el que suena y el borrador. */
  private lateinit var activeStore: ActiveStore
  private lateinit var researchLog: ResearchLogStore
  private lateinit var signalPlayer: SignalPlayer
  private lateinit var autoMode: AutoModeStore
  private lateinit var lastConfiguration: ReminderStore
  private lateinit var settings: SettingsStore
  /** Lo que dice la notificación permanente además de contar: horas sin sonar o un Tag que no responde (4.4). */
  @Volatile private var quietShown = false
  @Volatile private var tagMissing = false
  /**
   * 4.6.2: el aviso permanente se publicó sin permiso de notificaciones. Pasa con el primer relevo, porque
   * Android pregunta por ese permiso mientras el servicio ya arrancó; sin volver a publicarlo, el aviso
   * «Contando el tiempo» no aparecía hasta reiniciar el teléfono o la app.
   */
  @Volatile private var postedHidden = false
  /** Mensajes del proyecto al instante mientras el servicio está activo (D-096). */
  private lateinit var messageStream: MessageStream
  private var monitorJob: Job? = null
  private var lastQueryMillis: Long = 0L

  override fun onCreate() {
    super.onCreate()
    store = ReminderStore(this)
    activeStore = ActiveStore(this)
    researchLog = ResearchLogStore(this)
    signalPlayer = SignalPlayer(this)
    autoMode = AutoModeStore(this)
    lastConfiguration = ReminderStore(this, ReminderStore.LAST_CONFIGURATION)
    settings = SettingsStore(this)
    messageStream = MessageStream(this, scope)
    createNotificationChannels()
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    ActiveStore.migrate(this)
    val actives = activeStore.load()
    val counting = actives.isNotEmpty()
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
      pauseForMissingAccess(actives)
      return START_NOT_STICKY
    }
    if (restored) {
      actives.forEach { researchLog.record(it.sessionId, it.participantCode, "monitor_resumed", it.targetPackage, it.observedUsageSeconds) }
    }
    getSystemService(NotificationManager::class.java)?.cancel(STATUS_NOTIFICATION_ID)
    // Si ya está contando, el ciclo toma solo el relevo nuevo de [activeStore]; reiniciarlo cortaría una señal.
    if (isCounting) startInForeground(counting = true) else startMonitoring()
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

  /**
   * [counting]: hay un relevo contando. Si no, Relevo espera para activarse solo (D-095). Desde la 4.0
   * (D-155, R11 del estudio de los textos) el título dice lo importante —la actividad— sin el nombre de la
   * app, y el texto, cuándo suena. En la pantalla de bloqueo se ve una versión sin la actividad. Desde la
   * 4.4 dice también si son horas sin sonar o si el Tag no responde antes de sonar.
   */
  private fun startInForeground(counting: Boolean = true) {
    val actives = runCatching { ActiveStore(this).load() }.getOrDefault(emptyList())
    // Con varios relevos (4.3), el título dice cuántos y el texto, cuál sonará primero.
    val next = actives.minByOrNull { it.requiredUsageSeconds - it.observedUsageSeconds }
    val title = when {
      !counting -> "Se activa solo"
      quietShown -> "En pausa"
      actives.size > 1 -> "Contando el tiempo de ${actives.size} relevos"
      next != null && next.activity.isNotBlank() -> "Contando el tiempo para «${next.activity.trim()}»"
      else -> "Contando el tiempo"
    }
    val text = when {
      !counting -> "Al abrir las apps del último relevo"
      quietShown -> "Horas sin sonar, hasta las ${settings.load().quietUntil}:00"
      tagMissing -> "El Tag no responde; si sigue así, sonará en tu teléfono"
      actives.size > 1 && next != null -> "El próximo en sonar: «${next.activity.trim()}»"
      next != null -> "Sonará al sumar ${minutes(next.requiredUsageSeconds)}"
      else -> "Hasta que lo desactives"
    }
    val publicVersion = NotificationCompat.Builder(this, CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_stat_relevo)
      .setContentTitle(if (counting) "Contando el tiempo" else "Se activa solo")
      .build()
    val notification =
      NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle(title)
        .setContentText(text)
        .setContentIntent(openAppIntent())
        .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
        .setPublicVersion(publicVersion)
        .setOngoing(true)
        .setSilent(true)
        .build()
    val serviceType =
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE else 0
    ServiceCompat.startForeground(this, NOTIFICATION_ID, notification, serviceType)
    postedHidden = !NotificationManagerCompat.from(this).areNotificationsEnabled()
  }

  /** Si el aviso permanente quedó oculto y ya hay permiso de notificaciones, lo publica de nuevo. */
  private fun repostIfAllowed(counting: Boolean) {
    if (postedHidden && NotificationManagerCompat.from(this).areNotificationsEnabled()) startInForeground(counting)
  }

  private fun stopMonitoring() {
    isCounting = false
    isWatching = false
    messageStream.stop()
    ServiceCompat.stopForeground(this, ServiceCompat.STOP_FOREGROUND_REMOVE)
    stopSelf()
  }

  /** Está dentro de las horas sin sonar que eligió la persona (4.4): Relevo no cuenta ni suena. */
  private fun quietNow(): Boolean = settings.load().let { it.quietHours && QuietHours.contains(LocalTime.now().hour, it.quietFrom, it.quietUntil) }

  /** Mantiene conectado el Tag mientras algún relevo activo suena en él (D-109). */
  private fun holdTagIfNeeded() {
    if (activeStore.load().any { it.signalRoute == SignalRoute.TAG }) TagStore(this).address?.let { TagLink.hold(this, it) }
  }

  /**
   * Cuenta todos los relevos activos a la vez (4.3, D-158). Una sola lectura de qué app está en primer plano
   * suma tiempo a cada relevo que la incluye, con sus propias entradas y salidas en el registro. Cuando uno
   * cumple su tiempo y nada está sonando, pasa a [store] para la señal; si había un borrador a medias, se
   * guarda aparte. Si otro relevo se cumple mientras suena uno, espera su turno y sigue contando.
   *
   * 4.4: en las horas sin sonar no suma tiempo ni suena; las entradas y salidas se registran igual. A un
   * minuto y medio del final, un relevo que suena en el Tag lo busca, para saber a tiempo si tendrá que
   * sonar en el teléfono (pedido de la comisión del 28 de octubre).
   */
  private fun startMonitoring() {
    monitorJob?.cancel()
    isWatching = false
    isCounting = true
    messageStream.start()
    holdTagIfNeeded()
    val startedAt = System.currentTimeMillis()
    // Se revisa un periodo previo para saber qué app estaba abierta al empezar o al retomar.
    lastQueryMillis = startedAt - LOOKBACK_MILLIS
    val tracker = ForegroundTracker(startedAt)
    monitorJob =
      scope.launch {
        var lastTick = startedAt
        val counted = mutableMapOf<String, Long>()
        val inTarget = mutableMapOf<String, Boolean>()
        val lastPackage = mutableMapOf<String, String>()
        var shownCount = activeStore.load().size
        var ticks = 0L
        val tagChecked = mutableSetOf<String>()
        quietShown = false
        tagMissing = false

        while (true) {
          val actives = activeStore.load()
          if (actives.isEmpty() || !hasCurrentConsent()) break
          if (actives.size != shownCount) { shownCount = actives.size; startInForeground(counting = true) }
          repostIfAllowed(counting = true)

          ticks += 1
          if (ticks % ACCESS_CHECK_TICKS == 0L && !UsageAccess.isGranted(this@AppUsageMonitorService)) {
            pauseForMissingAccess(actives)
            return@launch
          }
          if (ticks % SYNC_TICKS == 0L) launch(Dispatchers.IO) {
            UsageAfterSignal.update(this@AppUsageMonitorService, researchLog)
            RemoteSync(this@AppUsageMonitorService, researchLog).syncPending()
          }
          if (ticks % MESSAGE_TICKS == 0L) launch(Dispatchers.IO) { ProjectMessages.check(this@AppUsageMonitorService) }

          val quiet = quietNow()
          if (quiet != quietShown) {
            quietShown = quiet
            researchLog.logApp(actives.first().participantCode, if (quiet) "horas_sin_sonar_inicio" else "horas_sin_sonar_fin", actives.joinToString(" · ") { it.activity })
            startInForeground(counting = true)
          }

          val now = System.currentTimeMillis()
          readUsageEvents(now, tracker)
          tracker.tick(now) { false }
          val step = (now - lastTick).coerceIn(0L, ForegroundTracker.MAX_STEP_MILLIS)
          lastTick = now
          val foreground = tracker.currentPackage

          var due: Reminder? = null
          for (active in actives) {
            val id = active.sessionId
            val tracked = active.tracks(foreground)
            val total = counted.getOrPut(id) { active.observedUsageSeconds * 1_000L } + if (tracked && !quiet) step else 0L
            counted[id] = total
            val seconds = (total / 1_000L).toInt()
            // Pasar de una app elegida a otra también queda registrado como salida y entrada.
            val was = inTarget[id] ?: false
            if (tracked != was || (tracked && foreground != lastPackage[id])) {
              if (was) researchLog.record(id, active.participantCode, "target_left", lastPackage[id].orEmpty(), seconds)
              if (tracked) {
                lastPackage[id] = foreground.orEmpty()
                researchLog.record(id, active.participantCode, "target_entered", foreground.orEmpty(), seconds)
              }
              inTarget[id] = tracked
            }
            // Se actualiza cada uno por su sesión: si la persona desactivó uno mientras tanto, no vuelve.
            if (seconds != active.observedUsageSeconds) activeStore.update(id) { it.copy(observedUsageSeconds = seconds) }
            if (due == null && seconds >= active.requiredUsageSeconds) due = active.copy(observedUsageSeconds = seconds)
            if (active.signalRoute == SignalRoute.TAG && active.requiredUsageSeconds - seconds <= TAG_CHECK_SECONDS && tagChecked.add(id)) {
              launch(Dispatchers.IO) { checkTagBeforeSignal(active) }
            }
          }

          val focus = store.load()
          val sounding = focus.status == ReminderStatus.SIGNALLED || focus.status == ReminderStatus.SILENCED || focus.status == ReminderStatus.CLOSED
          val ready = due
          if (ready != null && !sounding && !quiet) {
            activeStore.remove(ready.sessionId)
            counted.remove(ready.sessionId)
            tagMissing = false
            if (focus.activity.isNotBlank() || focus.selectedApps.isNotEmpty()) activeStore.park(focus)
            store.save(ready)
            deliverSignal(ready)
            holdTagIfNeeded()
            shownCount = -1
          }

          delay(POLL_INTERVAL_MILLIS)
        }
        TagLink.release()
        // Con la activación automática, al terminar los relevos vuelve a esperar en vez de detenerse.
        if (autoMode.enabled && hasCurrentConsent()) startWatching() else stopMonitoring()
      }
  }

  /**
   * Abre la conexión con el Tag si no está abierta (4.4). Si no responde, la notificación lo dice; al
   * cumplirse el tiempo, Relevo lo intenta de nuevo y, si sigue sin responder, suena en el teléfono.
   */
  private suspend fun checkTagBeforeSignal(reminder: Reminder) {
    val address = TagStore(this).address
    val ok = address != null && TagLink.hasPermissions(this) &&
      (TagLink.isConnectedTo(address) || withTimeoutOrNull(TAG_CHECK_TIMEOUT_MILLIS) { TagLink.reconnect(this@AppUsageMonitorService, address) } == true)
    researchLog.logApp(reminder.participantCode, "tag_revisado_antes", if (ok) "responde" else "no_responde")
    if (!ok && activeStore.load().any { it.sessionId == reminder.sessionId }) {
      tagMissing = true
      startInForeground(counting = true)
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
          if (activeStore.load().isNotEmpty()) {
            // Se activó un relevo a mano mientras Relevo esperaba: pasa a contarlo.
            isWatching = false
            startInForeground(counting = true)
            startMonitoring()
            return@launch
          }
          repostIfAllowed(counting = false)
          ticks += 1
          if (ticks % WATCH_ACCESS_TICKS == 0L && !UsageAccess.isGranted(this@AppUsageMonitorService)) break
          if (ticks % WATCH_MESSAGE_TICKS == 0L) launch(Dispatchers.IO) { ProjectMessages.check(this@AppUsageMonitorService) }
          val now = System.currentTimeMillis()
          readUsageEvents(now, tracker)
          tracker.tick(now) { false }
          val last = lastConfiguration.load()
          // En las horas sin sonar no se activa solo: el relevo no contaría.
          if (!quietNow() && AutoMode.shouldArm(true, current.status, last, tracker.currentPackage, now, autoMode.lastClosedAt) && activeStore.load().isEmpty() && armAutomatically(last)) {
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

  /** Activa el último relevo, igual que al activarlo a mano. */
  private fun armAutomatically(last: Reminder): Boolean {
    val code = Participation.code(this).ifBlank { return false }
    val next = AutoMode.fromLast(last, code, UUID.randomUUID().toString())
    if (next.status != ReminderStatus.WAITING) return false
    activeStore.add(next)
    researchLog.record(next.sessionId, next.participantCode, "armed", next.targetPackage, 0)
    researchLog.startSession(next)
    researchLog.logApp(code, "relevo_automatico", next.activity)
    scope.launch(Dispatchers.IO) { RemoteSync(this@AppUsageMonitorService, researchLog).syncPending() }
    return true
  }

  /**
   * Emite la señal de D-078: unos 30 segundos que terminan solos. Si el Tag no responde, suena en el
   * teléfono, que siempre está a mano (4.4). Después, la pantalla y la notificación quedan visibles en
   * silencio hasta que la persona responde.
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
    // La carga de la pila del Tag al sonar, si la informó al conectarse: explica señales que no se oyeron (2.31).
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
        // Se apretó el botón del llavero: la señal se calló en el objeto, sin abrir la app (D-109).
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
   * Sin acceso a Tiempo de uso no se puede contar. El relevo sigue activo, pero el conteo se detiene
   * y la persona recibe un aviso visible para reactivarlo o desactivarlo.
   */
  private fun pauseForMissingAccess(actives: List<Reminder>) {
    actives.forEach { researchLog.record(it.sessionId, it.participantCode, "monitor_paused", it.targetPackage, it.observedUsageSeconds) }
    getSystemService(NotificationManager::class.java)?.notify(
      STATUS_NOTIFICATION_ID,
      NotificationCompat.Builder(this, STATUS_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle("Dejó de contar el tiempo")
        .setContentText("Falta el permiso de Tiempo de uso")
        .setStyle(NotificationCompat.BigTextStyle().bigText("Falta el permiso de Tiempo de uso. Sin él, Relevo no puede contar el tiempo en tus apps."))
        .setContentIntent(openAppIntent())
        .setAutoCancel(true)
        .build(),
    )
    stopMonitoring()
  }

  /** Cuenta solo si la persona aceptó el consentimiento vigente. */
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
        description = "Avisa si Relevo dejó de contar el tiempo, por ejemplo al retirar un permiso."
        setSound(null, null)
      },
    )
  }

  /**
   * La notificación de la señal: la actividad como título y cómo empezar. En la pantalla de bloqueo se ve
   * la versión genérica, sin la actividad.
   */
  private fun showCompletionNotification(reminder: Reminder, audible: Boolean) {
    val manager = getSystemService(NotificationManager::class.java) ?: return
    val publicVersion = NotificationCompat.Builder(this, SIGNAL_CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_stat_relevo)
      .setContentTitle("Relevo")
      .setContentText(GENERIC_SIGNAL_TEXT)
      .build()
    val text = when {
      // 4.0 (R11): lo útil primero y en menos de 40 caracteres; la frase genérica del protocolo se mantiene.
      !audible && reminder.signalRoute == SignalRoute.BLUETOOTH -> "No sonó en el dispositivo de audio"
      !audible && reminder.signalRoute == SignalRoute.TAG -> "No sonó en el Tag ni en tu teléfono"
      !audible -> "No sonó en tu teléfono"
      reminder.soundedOnPhone -> "El Tag no respondió; sonó en tu teléfono"
      reminder.howToStart.isBlank() -> GENERIC_SIGNAL_TEXT
      else -> "Empieza por ${reminder.howToStart.trim().trimEnd('.').replaceFirstChar { it.lowercase() }}"
    }
    manager.notify(
      SIGNAL_NOTIFICATION_ID,
      NotificationCompat.Builder(this, SIGNAL_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle(reminder.activity.trim().ifBlank { "Relevo" })
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

  /** «30 min», «1 h 15 min»: el tiempo elegido, para la notificación que queda mientras cuenta. */
  private fun minutes(seconds: Int): String = when {
    seconds < 60 -> "$seconds s"
    seconds % 3600 == 0 -> "${seconds / 3600} h"
    seconds > 3600 -> "${seconds / 3600} h ${(seconds % 3600) / 60} min"
    else -> "${seconds / 60} min"
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
    /** A cuántos segundos del final se busca el Tag, y cuánto se espera que responda (4.4). */
    private const val TAG_CHECK_SECONDS = 90
    private const val TAG_CHECK_TIMEOUT_MILLIS = 30_000L
  }
}
