package com.example.relevo.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** Activación automática (D-095): cuándo se activa sola y con qué datos. */
class AutoModeTest {
  private val instagram = TrackedApp("com.instagram.android", "Instagram")
  private val last = Reminder(
    activity = "Leer 10 páginas",
    howToStart = "Abrir el libro",
    place = "En el velador",
    targetApps = listOf(instagram),
    targetPackage = instagram.packageName,
    targetAppLabel = instagram.label,
    requiredUsageSeconds = 900,
    signalRoute = SignalRoute.BLUETOOTH,
  )
  private val now = 10 * AutoMode.PAUSE_MILLIS

  @Test
  fun armsWhenOneOfItsAppsOpensAfterThePause() {
    assertTrue(AutoMode.shouldArm(true, ReminderStatus.DRAFT, last, instagram.packageName, now, lastClosedAt = now - AutoMode.PAUSE_MILLIS))
  }

  @Test
  fun waitsForThePauseAfterTheLastRelevo() {
    assertFalse(AutoMode.shouldArm(true, ReminderStatus.CLOSED, last, instagram.packageName, now, lastClosedAt = now - AutoMode.PAUSE_MILLIS + 1))
  }

  @Test
  fun ignoresOtherAppsAndTheLockScreen() {
    assertFalse(AutoMode.shouldArm(true, ReminderStatus.DRAFT, last, "com.whatsapp", now, 0L))
    assertFalse(AutoMode.shouldArm(true, ReminderStatus.DRAFT, last, null, now, 0L))
  }

  @Test
  fun neverArmsOverARelevoInProgressOrAwaitingAnAnswer() {
    for (status in listOf(ReminderStatus.WAITING, ReminderStatus.SIGNALLED, ReminderStatus.SILENCED)) {
      assertFalse(AutoMode.shouldArm(true, status, last, instagram.packageName, now, 0L))
    }
  }

  @Test
  fun needsToBeOnAndACompleteLastRelevo() {
    assertFalse(AutoMode.shouldArm(false, ReminderStatus.DRAFT, last, instagram.packageName, now, 0L))
    assertFalse(AutoMode.shouldArm(true, ReminderStatus.DRAFT, null, instagram.packageName, now, 0L))
    assertFalse(AutoMode.usable(last.copy(place = "")))
    assertFalse(AutoMode.usable(last.copy(targetApps = emptyList(), targetPackage = "")))
  }

  @Test
  fun armsTheLastRelevoWithTodaysConditionAndMarksItAsAutomatic() {
    val armed = AutoMode.fromLast(last, participantCode = "K4MX", condition = StudyCondition.PHONE, studyDay = 9, sessionId = "s-1")
    assertEquals(ReminderStatus.WAITING, armed.status)
    assertTrue(armed.autoActivated)
    assertEquals("s-1", armed.sessionId)
    assertEquals("K4MX", armed.participantCode)
    assertEquals(SignalRoute.PHONE, armed.signalRoute)
    assertEquals(StudyCondition.PHONE.code.toString(), armed.studyCondition)
    assertEquals(9, armed.studyDay)
    assertEquals(0, armed.observedUsageSeconds)
    assertEquals(last.activity, armed.activity)
  }

  @Test
  fun outsideTheTestKeepsTheLastRoute() {
    val armed = AutoMode.fromLast(last, participantCode = "K4MX", condition = null, studyDay = -1, sessionId = "s-2")
    assertEquals(SignalRoute.BLUETOOTH, armed.signalRoute)
    assertEquals("", armed.studyCondition)
    assertEquals(-1, armed.studyDay)
  }
}
