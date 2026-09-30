package com.example.relevo.monitor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.relevo.data.AutoModeStore
import com.example.relevo.data.Participation
import com.example.relevo.data.ReminderStore
import com.example.relevo.data.SettingsStore
import com.example.relevo.domain.ReminderStatus

/**
 * Retoma un relevo activo, la activación automática, el aviso de regreso y la revisión de mensajes
 * después de reiniciar el teléfono o actualizar la app.
 */
class RestoreMonitorReceiver : BroadcastReceiver() {
  override fun onReceive(context: Context, intent: Intent) {
    if (intent.action != Intent.ACTION_BOOT_COMPLETED && intent.action != Intent.ACTION_MY_PACKAGE_REPLACED) return
    if (SettingsStore(context).load().returnNotice) ReturnNotice.schedule(context)
    if (Participation.participating(context)) ProjectMessages.schedule(context)
    // Con un relevo contando, o con la activación automática encendida (D-095), el servicio vuelve a empezar.
    val waiting = ReminderStore(context).load().status == ReminderStatus.WAITING
    if (!waiting && !(AutoModeStore(context).enabled && Participation.canUse(context))) return
    runCatching {
      ContextCompat.startForegroundService(
        context,
        Intent(context, AppUsageMonitorService::class.java).setAction(AppUsageMonitorService.ACTION_RESTORE),
      )
    }
  }
}
