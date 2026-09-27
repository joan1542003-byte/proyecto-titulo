package com.example.relevo.data

import android.content.Context

/**
 * Cómo usa la persona la app (A2). Con el consentimiento vigente participa en la prueba: se registra y
 * se envía. Si elige «No participar», la app funciona igual, pero no registra datos del estudio ni
 * abre una sesión con la base remota.
 */
object Participation {
  private const val PREFERENCES = "relevo_experience"
  private const val LOCAL_MODE = "local_mode"

  fun participating(context: Context): Boolean = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).let {
    it.getBoolean("academic_consent_accepted", false) && it.getString("academic_consent_version", null) == ResearchLogStore.CONSENT_VERSION
  }

  fun localMode(context: Context): Boolean =
    !participating(context) && context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).getBoolean(LOCAL_MODE, false)

  /** Puede preparar y activar relevos: participa o eligió usarla sin participar. */
  fun canUse(context: Context): Boolean = participating(context) || localMode(context)

  fun setLocalMode(context: Context, enabled: Boolean) {
    context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).edit().putBoolean(LOCAL_MODE, enabled).apply()
  }
}
