package com.example.relevo.monitor

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import cl.udp.relevo.R
import com.example.relevo.MainActivity
import com.example.relevo.data.Participation
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.ResearchLogStore
import com.example.relevo.data.SettingsStore
import com.example.relevo.domain.ReminderStatus
import java.util.Locale

/**
 * V2: aviso de regreso opcional. Empieza apagado y se activa en «Avisos y resúmenes». Llega como
 * máximo una vez por semana y solo si la persona no abrió Relevo en ese tiempo. No dice cuántos días
 * pasaron ni sugiere una falta; tras dos «Ahora no» seguidos, la app pregunta una vez si se apaga.
 */
object ReturnNotice {
  const val ACTION_CHECK = "cl.udp.relevo.action.RETURN_CHECK"
  const val ACTION_NOT_NOW = "cl.udp.relevo.action.RETURN_NOT_NOW"
  const val EXTRA_PREPARE = "relevo_prepare_last"
  private const val CHANNEL_ID = "relevo_return"
  private const val NOTIFICATION_ID = 1104
  private const val GENERIC_QUESTION = "¿Quieres preparar un relevo esta semana?"
  const val WEEK_MILLIS = 7L * 24 * 60 * 60 * 1000

  /** Corresponde avisar si pasó una semana desde la última apertura y desde el último aviso. */
  fun due(now: Long, lastOpenedAt: Long, lastNoticeAt: Long): Boolean =
    now - lastOpenedAt >= WEEK_MILLIS && now - lastNoticeAt >= WEEK_MILLIS

  /** Revisa una vez al día; Android agrupa la alarma con otras para no gastar batería. */
  fun schedule(context: Context) {
    context.getSystemService(AlarmManager::class.java)?.setInexactRepeating(
      AlarmManager.RTC,
      System.currentTimeMillis() + AlarmManager.INTERVAL_HALF_DAY,
      AlarmManager.INTERVAL_DAY,
      checkIntent(context),
    )
  }

  fun cancel(context: Context) {
    context.getSystemService(AlarmManager::class.java)?.cancel(checkIntent(context))
    dismiss(context)
  }

  fun dismiss(context: Context) {
    context.getSystemService(NotificationManager::class.java)?.cancel(NOTIFICATION_ID)
  }

  fun check(context: Context, now: Long = System.currentTimeMillis()) {
    val settings = SettingsStore(context)
    if (!settings.load().returnNotice || !Participation.canUse(context)) return
    val status = ReminderStore(context).load().status
    if (status == ReminderStatus.WAITING || status == ReminderStatus.SIGNALLED) return
    if (!due(now, settings.lastOpenedAt, settings.lastReturnNoticeAt)) return
    val manager = context.getSystemService(NotificationManager::class.java) ?: return
    if (!manager.areNotificationsEnabled()) return
    manager.createNotificationChannel(
      NotificationChannel(CHANNEL_ID, "Aviso semanal", NotificationManager.IMPORTANCE_LOW).apply {
        description = "Una vez por semana como máximo, si no abriste Relevo. Se apaga en Perfil, en Avisos y resúmenes."
      },
    )
    val activity = ReminderStore(context, ReminderStore.LAST_CONFIGURATION).load().activity.trim().trimEnd('.')
    val question = if (activity.isBlank()) GENERIC_QUESTION
      else "¿Sigue en pie ${activity.replaceFirstChar { it.lowercase(Locale.forLanguageTag("es")) }} esta semana?"
    // En la pantalla de bloqueo no se muestra la actividad, como en la señal.
    val publicVersion = NotificationCompat.Builder(context, CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_stat_relevo)
      .setContentTitle("Relevo")
      .setContentText(GENERIC_QUESTION)
      .build()
    val prepare = PendingIntent.getActivity(
      context, 2,
      Intent(context, MainActivity::class.java).putExtra(EXTRA_PREPARE, true)
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP),
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
    )
    val notNow = PendingIntent.getBroadcast(
      context, 3, Intent(context, ReturnNoticeReceiver::class.java).setAction(ACTION_NOT_NOW),
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
    )
    manager.notify(
      NOTIFICATION_ID,
      NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_relevo)
        .setContentTitle("Relevo")
        .setContentText(question)
        .setContentIntent(prepare)
        .addAction(0, "Preparar", prepare)
        .addAction(0, "Ahora no", notNow)
        .setAutoCancel(true)
        .setSilent(true)
        .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
        .setPublicVersion(publicVersion)
        .build(),
    )
    settings.lastReturnNoticeAt = now
    ResearchLogStore(context).logApp(Participation.code(context), "aviso_semanal_enviado", if (activity.isBlank()) "sin_actividad" else activity)
  }

  private fun checkIntent(context: Context): PendingIntent = PendingIntent.getBroadcast(
    context, 1, Intent(context, ReturnNoticeReceiver::class.java).setAction(ACTION_CHECK),
    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
  )
}

class ReturnNoticeReceiver : BroadcastReceiver() {
  override fun onReceive(context: Context, intent: Intent) {
    when (intent.action) {
      ReturnNotice.ACTION_CHECK -> ReturnNotice.check(context)
      ReturnNotice.ACTION_NOT_NOW -> {
        SettingsStore(context).run { returnNotNow += 1 }
        ResearchLogStore(context).logApp(Participation.code(context), "aviso_semanal_ahora_no")
        ReturnNotice.dismiss(context)
      }
    }
  }
}
