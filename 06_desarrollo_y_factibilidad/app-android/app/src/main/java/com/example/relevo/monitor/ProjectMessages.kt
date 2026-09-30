package com.example.relevo.monitor

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import cl.udp.relevo.R
import com.example.relevo.MainActivity
import com.example.relevo.data.Participation
import com.example.relevo.data.RemoteSync
import com.example.relevo.data.ResearchLogStore
import org.json.JSONArray
import java.time.Instant

/**
 * Mensajes del investigador (D-096). Se escriben en el panel privado, quedan en la base y cada teléfono
 * los busca: al abrir la app, cada minuto mientras Relevo cuenta o espera, y cada 15 minutos en segundo
 * plano. Llegan como notificación; la base registra cuándo llegó y cuándo se abrió cada uno.
 */
object ProjectMessages {
  const val EXTRA_MESSAGE_ID = "relevo_message_id"
  private const val CHANNEL_ID = "relevo_messages"
  private const val PREFERENCES = "relevo_messages"
  private const val JOB_ID = 1201
  private const val NOTIFICATION_BASE = 2000
  private const val MIN_INTERVAL_MILLIS = 45_000L
  private const val PERIOD_MILLIS = 15 * 60_000L
  private const val KEEP_IDS = 100

  /** Busca mensajes nuevos y los muestra. Se llama fuera del hilo principal. */
  fun check(context: Context) {
    val app = context.applicationContext
    if (!Participation.participating(app)) return
    val preferences = app.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    val now = System.currentTimeMillis()
    synchronized(this) {
      if (now - preferences.getLong("last_check_at", 0L) < MIN_INTERVAL_MILLIS) return
      preferences.edit().putLong("last_check_at", now).apply()
    }
    // Desde la primera revisión: los mensajes anteriores a la instalación no llegan.
    val since = preferences.getString("since", null) ?: Instant.ofEpochMilli(now).toString().also { preferences.edit().putString("since", it).apply() }
    val log = ResearchLogStore(app)
    val sync = RemoteSync(app, log)
    val messages = sync.fetchMessages(since) ?: return
    if (messages.isEmpty()) return
    val shown = shownIds(preferences)
    for (message in messages) {
      if (message.id in shown) continue
      val visible = notify(app, message)
      val deliveredAt = System.currentTimeMillis()
      shown += message.id
      preferences.edit().putString("shown", JSONArray(shown.takeLast(KEEP_IDS)).toString()).putLong("delivered_${message.id}", deliveredAt).apply()
      sync.sendReceipt(message.id, deliveredAt, null)
      log.logApp(Participation.code(app), if (visible) "mensaje_recibido" else "mensaje_sin_notificaciones", message.id)
    }
    preferences.edit().putString("since", messages.last().createdAt).apply()
    sync.syncPending()
  }

  /** La persona tocó la notificación: queda registrado cuándo se abrió. Se llama fuera del hilo principal. */
  fun opened(context: Context, messageId: String) {
    val app = context.applicationContext
    if (!Participation.participating(app)) return
    val preferences = app.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    val now = System.currentTimeMillis()
    val log = ResearchLogStore(app)
    RemoteSync(app, log).sendReceipt(messageId, preferences.getLong("delivered_$messageId", now), now)
    log.logApp(Participation.code(app), "mensaje_abierto", messageId)
  }

  /** Revisión periódica en segundo plano, con conexión. Android puede agruparla para ahorrar batería. */
  fun schedule(context: Context) {
    val scheduler = context.getSystemService(JobScheduler::class.java) ?: return
    if (scheduler.getPendingJob(JOB_ID) != null) return
    runCatching {
      scheduler.schedule(
        JobInfo.Builder(JOB_ID, ComponentName(context, MessageCheckJob::class.java))
          .setPeriodic(PERIOD_MILLIS)
          .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
          .setPersisted(true)
          .build(),
      )
    }
  }

  /** Al borrar los datos: deja de revisar y olvida lo mostrado. */
  fun clear(context: Context) {
    context.getSystemService(JobScheduler::class.java)?.cancel(JOB_ID)
    context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).edit().clear().apply()
  }

  private fun shownIds(preferences: android.content.SharedPreferences): MutableList<String> = runCatching {
    val array = JSONArray(preferences.getString("shown", "[]"))
    MutableList(array.length()) { array.getString(it) }
  }.getOrDefault(mutableListOf())

  /** Muestra el mensaje. En la pantalla de bloqueo solo se ve que hay uno nuevo. Devuelve si se pudo mostrar. */
  private fun notify(context: Context, message: RemoteSync.Message): Boolean {
    val manager = context.getSystemService(NotificationManager::class.java) ?: return false
    manager.createNotificationChannel(
      NotificationChannel(CHANNEL_ID, "Mensajes del proyecto", NotificationManager.IMPORTANCE_HIGH).apply {
        description = "Mensajes del investigador sobre el testeo."
      },
    )
    if (!manager.areNotificationsEnabled()) return false
    val open = PendingIntent.getActivity(
      context, message.id.hashCode(),
      Intent(context, MainActivity::class.java).putExtra(EXTRA_MESSAGE_ID, message.id)
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP),
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
    )
    val publicVersion = NotificationCompat.Builder(context, CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_stat_relevo)
      .setContentTitle("Relevo")
      .setContentText("Tienes un mensaje nuevo")
      .build()
    manager.notify(
      NOTIFICATION_BASE + (message.id.hashCode() and 0xFFF),
      NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle(message.title)
        .setContentText(message.body)
        .setStyle(NotificationCompat.BigTextStyle().bigText(message.body))
        .setContentIntent(open)
        .setAutoCancel(true)
        .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
        .setPublicVersion(publicVersion)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build(),
    )
    return true
  }
}

/** Revisión de mensajes cada 15 minutos, aunque Relevo no esté abierto ni contando. */
class MessageCheckJob : JobService() {
  override fun onStartJob(params: JobParameters): Boolean {
    Thread {
      runCatching { ProjectMessages.check(applicationContext) }
      jobFinished(params, false)
    }.start()
    return true
  }

  override fun onStopJob(params: JobParameters): Boolean = true
}
