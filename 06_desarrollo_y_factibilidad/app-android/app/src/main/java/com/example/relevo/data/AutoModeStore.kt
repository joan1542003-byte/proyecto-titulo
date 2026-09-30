package com.example.relevo.data

import android.content.Context

/** Activación automática (D-095): si está encendida y cuándo terminó el último relevo, para respetar la pausa. */
class AutoModeStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_auto", Context.MODE_PRIVATE)

  var enabled: Boolean
    get() = preferences.getBoolean("enabled", false)
    set(value) { preferences.edit().putBoolean("enabled", value).apply() }

  /** Fin del último relevo, automático o a mano. */
  var lastClosedAt: Long
    get() = preferences.getLong("last_closed_at", 0L)
    set(value) { preferences.edit().putLong("last_closed_at", value).apply() }

  fun clear() { preferences.edit().clear().apply() }
}
