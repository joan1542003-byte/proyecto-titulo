package com.example.relevo.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class RouteTest {
  private var counter = 0
  private fun id() = "s${counter++}"
  private val track = Interests.suggestedTrack("ejercicio") { id() }

  @Test fun suggestedTrackStartsOnTheFirstStep() {
    assertEquals("Hacer ejercicio", track.title)
    assertEquals(3, track.steps.size)
    assertEquals("Hacer una serie corta", track.currentStep?.activity)
    assertEquals("Entrenar 20 minutos", track.nextStep?.activity)
  }

  @Test fun advanceStopsAtTheLastStep() {
    val last = track.advance().advance().advance()
    assertEquals(2, last.currentIndex)
    assertNull(last.nextStep)
  }

  @Test fun removingAStepBeforeTheCurrentKeepsTheSameStep() {
    val onSecond = track.moveTo(1)
    val marked = onSecond.currentStep
    val removed = onSecond.remove(onSecond.steps.first().id)
    assertEquals(marked, removed.currentStep)
  }

  @Test fun removingTheOnlyStepLeavesAnEmptyTrack() {
    val single = RouteTrack("otra", "Tejer", listOf(RouteStep("a", "Tejer", "Sacar los palillos", "En el sillón")))
    val empty = single.remove("a")
    assertTrue(empty.steps.isEmpty())
    assertNull(empty.currentStep)
  }

  @Test fun movingAStepKeepsTheMarkOnTheSameStep() {
    val onFirst = track.moveTo(0)
    val marked = onFirst.currentStep
    val moved = onFirst.move(marked!!.id, 2)
    assertEquals(marked, moved.currentStep)
    assertEquals(marked, moved.steps.last())
  }

  @Test fun reconcileKeepsEditedTracksAndAddsNewOnes() {
    val edited = track.moveTo(2)
    val result = Interests.reconcile(listOf(edited), listOf("ejercicio", "leer"), "", ::id)
    assertEquals(2, result.size)
    assertEquals(2, result.first().currentIndex)
    assertEquals("Leer", result[1].title)
  }

  @Test fun reconcileDropsInterestsThatWereRemoved() {
    val result = Interests.reconcile(listOf(track), listOf("leer"), "", ::id)
    assertEquals(listOf("leer"), result.map { it.interest })
  }

  @Test fun otherInterestUsesTheWrittenName() {
    val other = Interests.reconcile(emptyList(), listOf(Interests.OTHER), "Tejer", ::id).single()
    assertEquals("Tejer", other.title)
    assertTrue(other.steps.isEmpty())
  }

  @Test fun nextStepIsOfferedOnlyAfterThreeStartsAndOnce() {
    assertFalse(NextStepRule.shouldOffer(starts = 2, hasNext = true, declined = false))
    assertTrue(NextStepRule.shouldOffer(starts = 3, hasNext = true, declined = false))
    assertFalse(NextStepRule.shouldOffer(starts = 5, hasNext = true, declined = true))
    assertFalse(NextStepRule.shouldOffer(starts = 5, hasNext = false, declined = false))
  }
}
