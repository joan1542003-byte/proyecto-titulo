package com.example.relevo.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** 4.7 (D-175): el cierre de la prueba en la app usa las claves del instrumento. */
class ClosingSurveyTest {
  private val keys = ClosingSurvey.parts.flatMap { part -> part.questions.map { it.key } }

  @Test
  fun keysFitTheDatabaseAndTheQuestionnaireKeepsItsOwn() {
    assertEquals(26, keys.size)
    assertEquals(keys.size, keys.toSet().size)
    assertTrue(keys.all { it.length in 1..40 })
    assertTrue("semanas_previas_costo_preparar" in keys)
    assertTrue("semana1_comparacion" in keys)
    assertTrue("cierre_lugar_parlante" in keys)
  }

  @Test
  fun interviewKeysNameTheirTopicAndNeverReuseTheOldNumberedOnes() {
    // 4.7.2 (D-177): `entrevista_1` a `entrevista_9` son de la entrevista del 28 de octubre; no se reutilizan.
    assertEquals(
      listOf(
        "entrevista_uso", "entrevista_al_sonar", "entrevista_lugar", "entrevista_tag_y_telefono", "entrevista_dias_sin_uso",
        "entrevista_decidir", "entrevista_costo_y_molestia", "entrevista_fallas", "entrevista_otras_personas", "entrevista_cambiaria",
      ),
      keys.filter { it.startsWith("entrevista_") },
    )
    assertTrue(keys.none { Regex("entrevista_\\d+").matches(it) })
    assertEquals(2, ClosingSurvey.interviewParts.size)
  }

  @Test
  fun interviewQuestionsAreOpenNeverYesOrNo() {
    // La guía de los profesores: evitar las preguntas dicotómicas. Toda pregunta abre con qué, cómo, dónde o cuál.
    val open = Regex("^(qué|cómo|dónde|cuál|en qué|por qué)(\\s|$)", RegexOption.IGNORE_CASE)
    val texts = ClosingSurvey.interviewParts.flatMap { part -> part.questions.flatMap { listOf(it.text) + it.hints } }
    val asked = texts.flatMap { text -> Regex("¿([^?]+)\\?").findAll(text).map { it.groupValues[1].trim() }.toList() }
    assertTrue(asked.size >= 10)
    asked.forEach { question -> assertTrue("No es abierta: ¿$question?", open.containsMatchIn(question)) }
    // La última es la proyectiva de la guía: «Si pudieras cambiar algo…».
    assertTrue(ClosingSurvey.interviewParts.last().questions.last().text.startsWith("Si pudieras cambiar"))
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
    assertEquals(listOf(0, 1, 2, 3, 4), ClosingSurvey.remainingParts(0))
    // Quien quedó en la entrevista con la 4.7 (parte 4 de 4) sigue con las dos partes de la entrevista nueva.
    assertEquals(listOf(3, 4), ClosingSurvey.remainingParts(3))
    assertEquals(emptyList<Int>(), ClosingSurvey.remainingParts(5))
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
    assertEquals(600, ClosingSurvey.answersOf(3, mapOf("entrevista_uso" to long)).single().second.length)
    // Una parte solo envía sus propias preguntas: lo escrito para otra queda en el borrador.
    assertEquals(emptyList<Pair<String, String>>(), ClosingSurvey.answersOf(3, mapOf("entrevista_cambiaria" to "Nada")))
  }

  @Test
  fun settingsSaysWhatIsLeft() {
    assertEquals("Sin responder · unos 15 minutos", closingSubtitle(ClosingStatus(0, false)))
    assertEquals("Te faltan 3 de 5 partes", closingSubtitle(ClosingStatus(2, false)))
    assertEquals("Te falta 1 de 5 partes", closingSubtitle(ClosingStatus(4, false)))
  }
}
