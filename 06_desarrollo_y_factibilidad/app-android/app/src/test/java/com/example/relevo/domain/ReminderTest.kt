package com.example.relevo.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ReminderTest {
  private val complete =
    Reminder(activity = "Salir a caminar", howToStart = "Ponerme las zapatillas", place = "Dormitorio", delaySeconds = 60)

  @Test
  fun incompleteReminderCannotBecomeReady() {
    assertEquals(ReminderStatus.DRAFT, Reminder(activity = "Caminar").ready().status)
  }

  @Test
  fun preparedReminderCanReachSituateBeforePlaceIsKnown() {
    val prepared = Reminder(activity = "Caminar", howToStart = "Ponerme las zapatillas", delaySeconds = 15)

    assertEquals(ReminderStatus.READY, prepared.ready().status)
    assertFalse(prepared.ready().hasRequiredContent)
  }

  @Test
  fun completeReminderCanBeArmed() {
    val armed = complete.ready().arm(nowMillis = 1_000)

    assertEquals(ReminderStatus.WAITING, armed.status)
    assertEquals(61_000L, armed.scheduledAtMillis)
  }

  @Test
  fun signalCanOnlyBeDeliveredOnce() {
    val first = complete.ready().arm(0).deliverSignal()
    val second = first.deliverSignal()

    assertTrue(first.signalDelivered)
    assertEquals(first, second)
  }

  @Test
  fun disarmPreventsSignalAndClearsSchedule() {
    val disarmed = complete.ready().arm(0).disarm()

    assertEquals(ReminderStatus.CLOSED, disarmed.status)
    assertNull(disarmed.scheduledAtMillis)
    assertFalse(disarmed.deliverSignal().signalDelivered)
  }

  @Test
  fun closedReminderDoesNotRearmItself() {
    val closed = complete.ready().arm(0).close()

    assertEquals(ReminderStatus.CLOSED, closed.status)
    assertEquals(closed, closed.arm(5_000))
  }
}
