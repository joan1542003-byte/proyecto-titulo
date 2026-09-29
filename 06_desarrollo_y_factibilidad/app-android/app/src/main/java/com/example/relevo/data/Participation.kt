package com.example.relevo.data

import android.content.Context

/**
 * Participación en la prueba (A2). Desde 2.10, Relevo es parte de la prueba (D-084): se usa solo con
 * el consentimiento vigente, que registra y envía los datos del estudio. Ya no existe el uso «sin
 * participar» de 2.8 y 2.9; quien lo había elegido vuelve a ver el consentimiento.
 */
object Participation {
  private const val PREFERENCES = "relevo_experience"
  /** Marca del uso sin participar de 2.8 y 2.9; solo se lee para borrarla. */
  private const val LEGACY_LOCAL_MODE = "local_mode"

  fun participating(context: Context): Boolean = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).let {
    it.getBoolean("academic_consent_accepted", false) && it.getString("academic_consent_version", null) == ResearchLogStore.CONSENT_VERSION
  }

  /** Código de participación guardado en el teléfono, o vacío. */
  fun code(context: Context): String = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).getString("participant_code", null).orEmpty()

  /** Puede preparar y activar relevos: solo quien participa. */
  fun canUse(context: Context): Boolean = participating(context)

  /**
   * Código nuevo, corto y fácil de dictar (desde 2.12): cuatro caracteres sin letras ni números que
   * se confundan (sin 0, O, 1, I, L, 5, S, 2 ni Z). Con 22 símbolos hay 234 256 códigos posibles.
   */
  fun newCode(random: java.util.Random = java.security.SecureRandom()): String =
    (1..CODE_LENGTH).map { CODE_ALPHABET[random.nextInt(CODE_ALPHABET.length)] }.joinToString("")

  const val CODE_ALPHABET = "ACDEFHJKMNPRTUVWXY3469"
  const val CODE_LENGTH = 4

  /** Borra la marca del uso sin participar que dejaron 2.8 y 2.9. */
  fun clearLegacyLocalMode(context: Context) {
    val preferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    if (preferences.contains(LEGACY_LOCAL_MODE)) preferences.edit().remove(LEGACY_LOCAL_MODE).apply()
  }
}
