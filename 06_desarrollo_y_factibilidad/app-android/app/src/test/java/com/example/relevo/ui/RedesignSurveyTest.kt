package com.example.relevo.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** La encuesta del rediseño (4.6, D-164): solo para quien ya usaba Relevo, tras un minuto, y lo vacío no se envía. */
class RedesignSurveyTest {
  @Test fun onlyPeopleWhoAlreadyUsedRelevoSeeIt() {
    assertFalse(RedesignSurvey.eligibleAtFirstRun(onboardingComplete = false, acceptedBefore = false, hasHistory = false))
    assertTrue(RedesignSurvey.eligibleAtFirstRun(onboardingComplete = true, acceptedBefore = false, hasHistory = false))
    assertTrue(RedesignSurvey.eligibleAtFirstRun(onboardingComplete = false, acceptedBefore = true, hasHistory = false))
    assertTrue(RedesignSurvey.eligibleAtFirstRun(onboardingComplete = false, acceptedBefore = false, hasHistory = true))
  }

  @Test fun theMinuteAddsUpAcrossOpenings() {
    assertEquals(60_000L, RedesignSurvey.remainingMillis(0L))
    assertEquals(15_000L, RedesignSurvey.remainingMillis(45_000L))
    assertEquals(0L, RedesignSurvey.remainingMillis(90_000L))
  }

  @Test fun onlyWhatWasAnsweredIsSent() {
    assertTrue(RedesignAnswers().isEmpty())
    assertTrue(RedesignAnswers(change = "   ").isEmpty())
    val answers = RedesignAnswers(impression = 4, umuxEasy = 6, liked = setOf("textos", "colores"), change = "  Más grande  ").toAnswers()
    assertEquals(
      listOf("rediseno_impresion" to "4", "umux_lite_facil" to "6", "rediseno_gusta" to "colores,textos", "rediseno_cambiaria" to "Más grande"),
      answers,
    )
  }

  @Test fun keysFitTheAnswersTable() {
    val all = RedesignAnswers(5, "mejor", 7, 7, RedesignSurvey.likes.map { it.first }.toSet(), "x".repeat(900)).toAnswers()
    assertEquals(6, all.size)
    assertTrue(all.all { it.first.length <= 40 && it.second.length <= 600 })
  }
}
