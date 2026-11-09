package com.example.relevo.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** 4.7 (D-175): el cierre de la prueba en la app usa las claves del instrumento en papel. */
class ClosingSurveyTest {
  private val keys = ClosingSurvey.parts.flatMap { part -> part.questions.map { it.key } }

  @Test
  fun keysAreTheInstrumentOnesAndFitTheDatabase() {
    assertEquals(25, keys.size)
    assertEquals(keys.size, keys.toSet().size)
    assertTrue(keys.all { it.length in 1..40 })
    assertTrue("semanas_previas_costo_preparar" in keys)
    assertTrue("semana1_comparacion" in keys)
    assertTrue("cierre_lugar_parlante" in keys)
    assertEquals((1..9).map { "entrevista_$it" }, keys.filter { it.startsWith("entrevista_") })
  }

  @Test
  fun onlyPeopleWhoAlreadyUsedRelevoSeeIt() {
    assertFalse(ClosingSurvey.eligibleAtFirstRun(onboardingComplete = false, acceptedBefore = false, hasHistory = false))
    assertTrue(ClosingSurvey.eligibleAtFirstRun(onboardingComplete = false, acceptedBefore = true, hasHistory = false))
    assertTrue(ClosingSurvey.eligibleAtFirstRun(onboardingComplete = true, acceptedBefore = false, hasHistory = false))
  }

  @Test
  fun resumesFromTheSavedPartAndAsksEveryQuestion() {
    // 4.7.1: no se salta ninguna parte por respuestas anteriores; solo se retoma desde la parte guardada.
    assertEquals(listOf(0, 1, 2, 3), ClosingSurvey.remainingParts(0))
    assertEquals(listOf(2, 3), ClosingSurvey.remainingParts(2))
    assertEquals(emptyList<Int>(), ClosingSurvey.remainingParts(4))
  }

  @Test
  fun answersKeepTheirOrderAndSkipBlanks() {
    val values = mapOf(
      "semana1_comentario" to "  Me sirvió más el Tag.  ",
      "semana1_costo_preparar" to "2",
      "semana1_molestia_senal" to "   ",
      "semana1_comparacion" to "menos",
    )
    assertEquals(
      listOf("semana1_costo_preparar" to "2", "semana1_comparacion" to "menos", "semana1_comentario" to "Me sirvió más el Tag."),
      ClosingSurvey.answersOf(1, values),
    )
    val long = "a".repeat(700)
    assertEquals(600, ClosingSurvey.answersOf(3, mapOf("entrevista_1" to long)).single().second.length)
  }

  @Test
  fun settingsSaysWhatIsLeft() {
    assertEquals("Sin responder · unos 15 minutos", closingSubtitle(ClosingStatus(0, false)))
    assertEquals("Te faltan 2 de 4 partes", closingSubtitle(ClosingStatus(2, false)))
    assertEquals("Te falta 1 de 4 partes", closingSubtitle(ClosingStatus(3, false)))
  }
}
