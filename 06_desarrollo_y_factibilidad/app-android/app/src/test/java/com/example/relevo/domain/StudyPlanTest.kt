package com.example.relevo.domain

import java.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class StudyPlanTest {
  private val day0 = LocalDate.of(2026, 10, 8)
  private val plan = StudyPlan("BCA", day0)

  @Test
  fun dayZeroIsTheInitialSessionWithoutCondition() {
    assertTrue(plan.isInitialSession(day0))
    assertNull(plan.week(day0))
    assertNull(plan.condition(day0))
  }

  @Test
  fun weeksFollowTheAssignedSequence() {
    assertEquals(StudyCondition.NEUTRAL, plan.condition(day0.plusDays(1)))
    assertEquals(StudyCondition.NEUTRAL, plan.condition(day0.plusDays(7)))
    assertEquals(StudyCondition.PHONE, plan.condition(day0.plusDays(8)))
    assertEquals(StudyCondition.PHONE, plan.condition(day0.plusDays(14)))
    assertEquals(StudyCondition.SITUATED, plan.condition(day0.plusDays(15)))
    assertEquals(StudyCondition.SITUATED, plan.condition(day0.plusDays(21)))
  }

  @Test
  fun objectWeeksKeepTheWatchAndPhoneWeekUsesThePhone() {
    // A y B piden el objeto: si la persona usa el reloj, se mantiene; si no, suena el parlante.
    assertEquals(SignalRoute.WATCH, StudyCondition.SITUATED.routeFor(SignalRoute.WATCH))
    assertEquals(SignalRoute.WATCH, StudyCondition.NEUTRAL.routeFor(SignalRoute.WATCH))
    assertEquals(SignalRoute.BLUETOOTH, StudyCondition.SITUATED.routeFor(SignalRoute.PHONE))
    assertEquals(SignalRoute.BLUETOOTH, StudyCondition.NEUTRAL.routeFor(SignalRoute.BLUETOOTH))
    // C siempre suena en el teléfono.
    assertEquals(SignalRoute.PHONE, StudyCondition.PHONE.routeFor(SignalRoute.WATCH))
    assertEquals(SignalRoute.PHONE, StudyCondition.PHONE.routeFor(SignalRoute.BLUETOOTH))
  }

  @Test
  fun objectWeeksKeepTheTag() {
    // El llavero (D-109) también reemplaza al parlante en A y B; en C suena el teléfono.
    assertEquals(SignalRoute.TAG, StudyCondition.SITUATED.routeFor(SignalRoute.TAG))
    assertEquals(SignalRoute.TAG, StudyCondition.NEUTRAL.routeFor(SignalRoute.TAG))
    assertEquals(SignalRoute.PHONE, StudyCondition.PHONE.routeFor(SignalRoute.TAG))
  }

  @Test
  fun studyEndsAfterDayTwentyOne() {
    assertFalse(plan.isFinished(day0.plusDays(21)))
    assertTrue(plan.isFinished(day0.plusDays(22)))
    assertNull(plan.condition(day0.plusDays(22)))
  }

  @Test
  fun weeklyReviewOpensOnTheLastDayOfEachWeek() {
    assertEquals(emptyList<Int>(), plan.weeksReadyForReview(day0.plusDays(6)))
    assertEquals(listOf(1), plan.weeksReadyForReview(day0.plusDays(7)))
    assertEquals(listOf(1, 2), plan.weeksReadyForReview(day0.plusDays(14)))
    assertEquals(listOf(1, 2, 3), plan.weeksReadyForReview(day0.plusDays(21)))
    assertFalse(plan.closingReady(day0.plusDays(20)))
    assertTrue(plan.closingReady(day0.plusDays(21)))
  }

  @Test
  fun phoneConditionUsesThePhoneSpeaker() {
    assertEquals(SignalRoute.PHONE, StudyCondition.PHONE.route)
    assertEquals(SignalRoute.BLUETOOTH, StudyCondition.SITUATED.route)
    assertEquals(SignalRoute.BLUETOOTH, StudyCondition.NEUTRAL.route)
  }

  @Test
  fun allSixOrdersAreAvailable() {
    assertEquals(6, StudyPlan.SEQUENCES.toSet().size)
    StudyPlan.SEQUENCES.forEach { assertEquals(setOf('A', 'B', 'C'), it.toSet()) }
  }

  @Test(expected = IllegalArgumentException::class)
  fun rejectsSequencesOutsideTheProtocol() {
    StudyPlan("AAB", day0)
  }
}
