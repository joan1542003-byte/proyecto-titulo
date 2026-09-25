package com.example.relevo.data

import android.content.Context
import com.example.relevo.domain.StudyPlan
import java.time.LocalDate

/**
 * Plan de la prueba de 21 días en este teléfono y qué tarjetas ya se atendieron.
 * El investigador asigna la secuencia en la sesión inicial; la persona no necesita configurarla.
 */
class StudyStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_study", Context.MODE_PRIVATE)

  fun plan(): StudyPlan? {
    val sequence = preferences.getString("sequence", null) ?: return null
    if (!preferences.contains("day0")) return null
    return runCatching { StudyPlan(sequence, LocalDate.ofEpochDay(preferences.getLong("day0", 0L))) }.getOrNull()
  }

  fun start(sequence: String, day0: LocalDate) {
    preferences.edit().clear().putString("sequence", sequence).putLong("day0", day0.toEpochDay()).apply()
  }

  /** Semana cuya tarjeta de cierre se respondió o se omitió. */
  fun weekDone(week: Int): Boolean = preferences.getBoolean("week_${week}_done", false)
  fun markWeekDone(week: Int) { preferences.edit().putBoolean("week_${week}_done", true).apply() }

  /** Semana cuya instrucción de condición ya se leyó. */
  fun instructionSeen(week: Int): Boolean = preferences.getBoolean("week_${week}_instruction", false)
  fun markInstructionSeen(week: Int) { preferences.edit().putBoolean("week_${week}_instruction", true).apply() }

  fun closingDone(): Boolean = preferences.getBoolean("closing_done", false)
  fun markClosingDone() { preferences.edit().putBoolean("closing_done", true).apply() }

  fun clear() { preferences.edit().clear().apply() }
}
