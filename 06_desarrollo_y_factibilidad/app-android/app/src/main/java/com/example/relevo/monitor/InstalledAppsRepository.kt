package com.example.relevo.monitor

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

data class InstalledApp(val packageName: String, val label: String)

class InstalledAppsRepository(private val context: Context) {
  fun launcherApps(): List<InstalledApp> {
    val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
    return context.packageManager
      .queryIntentActivities(intent, PackageManager.MATCH_ALL)
      .asSequence()
      .map {
        InstalledApp(
          packageName = it.activityInfo.packageName,
          label = it.loadLabel(context.packageManager).toString(),
        )
      }
      .filter { it.packageName != context.packageName }
      .distinctBy { it.packageName }
      .sortedBy { it.label.lowercase() }
      .toList()
  }
}
