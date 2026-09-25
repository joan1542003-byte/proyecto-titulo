package com.example.relevo.monitor

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.PowerManager
import android.provider.Settings

/**
 * Optimización de batería. Algunos fabricantes detienen servicios en segundo plano aunque muestren
 * una notificación; durante un uso de varias semanas eso interrumpiría el conteo sin aviso.
 */
object BackgroundAccess {
  fun isUnrestricted(context: Context): Boolean =
    context.getSystemService(PowerManager::class.java)?.isIgnoringBatteryOptimizations(context.packageName) == true

  /** Abre el diálogo del sistema; la persona puede rechazarlo y la app sigue funcionando. */
  @SuppressLint("BatteryLife")
  fun requestIntent(context: Context): Intent =
    Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, Uri.parse("package:${context.packageName}"))
      .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

  fun settingsIntent(): Intent =
    Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
}
