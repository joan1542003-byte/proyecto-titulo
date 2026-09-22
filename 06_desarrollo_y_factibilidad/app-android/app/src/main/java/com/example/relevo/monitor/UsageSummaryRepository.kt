package com.example.relevo.monitor

import android.app.usage.UsageStatsManager
import android.content.Context
import java.util.Calendar

data class AppUsageSummary(val packageName: String, val label: String, val seconds: Int)

class UsageSummaryRepository(private val context: Context) {
  fun today(): List<AppUsageSummary> {
    if (!UsageAccess.isGranted(context)) return emptyList()
    val start = Calendar.getInstance().apply {
      set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0)
    }.timeInMillis
    val manager = context.getSystemService(UsageStatsManager::class.java) ?: return emptyList()
    val packageManager = context.packageManager
    return manager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, start, System.currentTimeMillis())
      .asSequence()
      .filter { it.totalTimeInForeground > 0 && it.packageName != context.packageName }
      .mapNotNull { stat ->
        runCatching {
          AppUsageSummary(
            stat.packageName,
            packageManager.getApplicationLabel(packageManager.getApplicationInfo(stat.packageName, 0)).toString(),
            (stat.totalTimeInForeground / 1_000L).toInt(),
          )
        }.getOrNull()
      }
      .sortedByDescending { it.seconds }
      .take(8)
      .toList()
  }
}
