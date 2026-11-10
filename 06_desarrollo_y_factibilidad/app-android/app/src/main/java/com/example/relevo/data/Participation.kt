package com.example.relevo.data

import android.content.Context

/**
 * Relevo se usa con el consentimiento vigente (D-084), que explica qué datos se guardan y envía. Quien
 * aceptó una versión anterior conserva su código y sus datos; solo vuelve a leer y aceptar el texto nuevo.
 */
object Participation {
  private const val PREFERENCES = "relevo_experience"

  /** Aceptó el consentimiento vigente. Sin eso, Relevo no prepara ni cuenta relevos. */
  fun participating(context: Context): Boolean = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).let {
    it.getBoolean("academic_consent_accepted", false) && it.getString("academic_consent_version", null) == ResearchLogStore.CONSENT_VERSION
  }

  /** Aceptó alguna vez, aunque fuera una versión anterior: se le muestra el texto nuevo, no la bienvenida. */
  fun acceptedBefore(context: Context): Boolean =
    context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).getString("academic_consent_version", null) != null

  /** Código guardado en el teléfono, o vacío. */
  fun code(context: Context): String = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).getString("participant_code", null).orEmpty()

  /**
   * Código nuevo, corto y fácil de dictar (desde 2.12): cuatro caracteres sin letras ni números que
   * se confundan (sin 0, O, 1, I, L, 5, S, 2 ni Z). Con 22 símbolos hay 234 256 códigos posibles.
   */
  fun newCode(random: java.util.Random = java.security.SecureRandom()): String =
    (1..CODE_LENGTH).map { CODE_ALPHABET[random.nextInt(CODE_ALPHABET.length)] }.joinToString("")

  const val CODE_ALPHABET = "ACDEFHJKMNPRTUVWXY3469"
  const val CODE_LENGTH = 4
}
