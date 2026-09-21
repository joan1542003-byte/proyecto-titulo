package com.example.relevo.monitor

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.signal.SignalPlayer
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
  private var monitorJob: Job? = null
  private var currentForegroundPackage: String? = null
  private var lastQueryMillis: Long = 0L

  override fun onCreate() {
    super.onCreate()
    store = ReminderStore(this)
    researchLog = ResearchLogStore(this)
    signalPlayer = SignalPlayer(this)
    createNotificationChannel()
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val reminder = store.load()
    if (reminder.status != ReminderStatus.WAITING || !UsageAccess.isGranted(this)) {
      stopSelf()
      return START_NOT_STICKY
    }

    val notification =
      NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(android.R.drawable.ic_popup_reminder)
        .setContentTitle("Relevo está observando ${reminder.targetAppLabel}")
        .setContentText("El registro se detiene al desactivar el recordatorio.")
        .setOngoing(true)
        .setSilent(true)
        .build()

    val serviceType =
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
        ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE
      } else {
        0
      }
    ServiceCompat.startForeground(this, NOTIFICATION_ID, notification, serviceType)
    startMonitoring()
    return START_NOT_STICKY
  }

  override fun onBind(intent: Intent?): IBinder? = null

  override fun onDestroy() {
    monitorJob?.cancel()
    scope.cancel()
    super.onDestroy()
  }

  private fun startMonitoring() {
    monitorJob?.cancel()
    lastQueryMillis = System.currentTimeMillis() - 60_000L
    monitorJob =
      scope.launch {
        var accumulatedMillis = store.load().observedUsageSeconds * 1_000L
        var previousTick = System.currentTimeMillis()
        var wasTargetForeground = false

        while (true) {
          val reminder = store.load()
          if (reminder.status != ReminderStatus.WAITING) break

          val now = System.currentTimeMillis()
          updateForegroundPackage(now)
          val targetForeground = currentForegroundPackage == reminder.targetPackage

          if (targetForeground) {
            accumulatedMillis += (now - previousTick).coerceAtMost(2_000L)
          }

          if (targetForeground != wasTargetForeground) {
            researchLog.record(
              reminder.sessionId,
              reminder.participantCode,
              if (targetForeground) "target_entered" else "target_left",
              reminder.targetPackage,
              (accumulatedMillis / 1_000L).toInt(),
            )
            wasTargetForeground = targetForeground
          }

          val observedSeconds = (accumulatedMillis / 1_000L).toInt()
          if (observedSeconds != reminder.observedUsageSeconds) {
            store.save(reminder.copy(observedUsageSeconds = observedSeconds))
          }

          if (observedSeconds >= reminder.requiredUsageSeconds) {
            val signalled = reminder.copy(observedUsageSeconds = observedSeconds).deliverSignal()
            store.save(signalled)
            researchLog.record(
              signalled.sessionId,
              signalled.participantCode,
              "signal_emitted",
              signalled.targetPackage,
              observedSeconds,
            )
            signalPlayer.play()
            break
          }

          previousTick = now
          delay(POLL_INTERVAL_MILLIS)
        }
        ServiceCompat.stopForeground(this@AppUsageMonitorService, ServiceCompat.STOP_FOREGROUND_REMOVE)
        stopSelf()
      }
  }

  private fun updateForegroundPackage(nowMillis: Long) {
    val usageStats = getSystemService(UsageStatsManager::class.java) ?: return
    val events = usageStats.queryEvents(lastQueryMillis, nowMillis)
    val event = UsageEvents.Event()
    while (events.hasNextEvent()) {
      events.getNextEvent(event)
      when (event.eventType) {
        UsageEvents.Event.ACTIVITY_RESUMED,
        UsageEvents.Event.MOVE_TO_FOREGROUND -> currentForegroundPackage = event.packageName
        UsageEvents.Event.ACTIVITY_PAUSED,
        UsageEvents.Event.MOVE_TO_BACKGROUND -> {
          if (currentForegroundPackage == event.packageName) currentForegroundPackage = null
        }
      }
    }
    lastQueryMillis = nowMillis
  }

  private fun createNotificationChannel() {
    val manager = getSystemService(NotificationManager::class.java) ?: return
    manager.createNotificationChannel(
      NotificationChannel(CHANNEL_ID, "Recordatorio activo", NotificationManager.IMPORTANCE_LOW).apply {
        description = "Informa cuándo Relevo observa la aplicación elegida."
      },
    )
  }

  companion object {
    private const val CHANNEL_ID = "relevo_monitor"
    private const val NOTIFICATION_ID = 1101
    private const val POLL_INTERVAL_MILLIS = 1_000L
  }
}
