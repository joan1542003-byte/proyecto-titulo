package com.example.relevo.monitor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.relevo.data.ReminderStore
import com.example.relevo.domain.ReminderStatus

/** Retoma un relevo activo después de reiniciar el teléfono o actualizar la app. */
class RestoreMonitorReceiver : BroadcastReceiver() {
  override fun onReceive(context: Context, intent: Intent) {
    if (intent.action != Intent.ACTION_BOOT_COMPLETED && intent.action != Intent.ACTION_MY_PACKAGE_REPLACED) return
    if (ReminderStore(context).load().status != ReminderStatus.WAITING) return
    runCatching {
      ContextCompat.startForegroundService(
        context,
        Intent(context, AppUsageMonitorService::class.java).setAction(AppUsageMonitorService.ACTION_RESTORE),
      )
    }
  }
}
