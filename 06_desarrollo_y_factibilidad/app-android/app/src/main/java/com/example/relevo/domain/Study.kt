package com.example.relevo.domain

import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * Condiciones del protocolo 02 (D-079). Cada semana de la prueba usa una, en el orden que asigna
 * la secuencia de la persona.
 */
enum class StudyCondition(val code: Char, val route: SignalRoute) {
  /** A. Parlante junto al primer paso. */
  SITUATED('A', SignalRoute.BLUETOOTH),
  /** B. Parlante en un lugar visible sin relación con la actividad. */
  NEUTRAL('B', SignalRoute.BLUETOOTH),
  /** C. Altavoz del teléfono con notificación genérica. */
  PHONE('C', SignalRoute.PHONE);

  companion object {
    fun fromCode(code: Char): StudyCondition? = entries.firstOrNull { it.code == code }
  }
}

/**
 * Plan de la prueba de 21 días de una persona: la secuencia de condiciones que le asignó el
 * investigador (una de las seis posibles) y la fecha de la sesión inicial (día 0).
 * Los días 1 a 7 son la semana 1; 8 a 14, la semana 2, y 15 a 21, la semana 3.
 */
data class StudyPlan(val sequence: String, val day0: LocalDate) {
  init { require(sequence in SEQUENCES) { "Secuencia no válida: $sequence" } }

  fun day(today: LocalDate): Int = ChronoUnit.DAYS.between(day0, today).toInt()

  /** Semana en curso (1 a 3); null el día 0, antes de empezar o después del día 21. */
  fun week(today: LocalDate): Int? = day(today).takeIf { it in 1..LAST_DAY }?.let { (it - 1) / 7 + 1 }

  fun condition(today: LocalDate): StudyCondition? = week(today)?.let { conditionOfWeek(it) }

  fun conditionOfWeek(week: Int): StudyCondition = StudyCondition.fromCode(sequence[week - 1])!!

  fun isInitialSession(today: LocalDate): Boolean = day(today) == 0

  fun isFinished(today: LocalDate): Boolean = day(today) > LAST_DAY

  /** Semanas cuyo cierre ya llegó (día 7, 14 o 21) y que, por lo tanto, pueden responderse. */
  fun weeksReadyForReview(today: LocalDate): List<Int> = (1..3).filter { day(today) >= it * 7 }

  /** El cierre del día 21 se ofrece desde ese día. */
  fun closingReady(today: LocalDate): Boolean = day(today) >= LAST_DAY

  companion object {
    const val LAST_DAY = 21

    /** Las seis secuencias posibles de A, B y C, una por participante (protocolo 02). */
    val SEQUENCES = listOf("ABC", "ACB", "BAC", "BCA", "CAB", "CBA")
  }
}
