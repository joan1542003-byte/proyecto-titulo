package com.example.relevo.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ReminderTest {
  private val complete = Reminder(
    activity = "Salir a caminar", howToStart = "Ponerme las zapatillas", place = "Dormitorio",
    targetPackage = "com.example.video", targetAppLabel = "Video", requiredUsageSeconds = 60,
    participantCode = "P01", consentAccepted = true,
  )

  @Test fun incompleteReminderCannotBecomeReady() {
    assertEquals(ReminderStatus.DRAFT, Reminder(activity = "Caminar").ready().status)
  }

  @Test fun preparedReminderCanReachSituateBeforePlaceIsKnown() {
    val prepared = complete.copy(place = "")
    assertEquals(ReminderStatus.READY, prepared.ready().status)
    assertFalse(prepared.ready().hasRequiredContent)
  }

  @Test fun consentAndTargetAppAreRequired() {
    assertFalse(complete.copy(consentAccepted = false).hasPreparedContent)
    assertFalse(complete.copy(targetPackage = "").hasPreparedContent)
  }

  @Test fun completeReminderCanBeArmed() {
    val armed = complete.ready().arm("session-1")
    assertEquals(ReminderStatus.WAITING, armed.status)
    assertEquals("session-1", armed.sessionId)
    assertEquals(0, armed.observedUsageSeconds)
  }

  @Test fun multipleSelectedAppsShareOneReminder() {
    val multi = complete.copy(
      targetApps = listOf(TrackedApp("com.example.video", "Video"), TrackedApp("com.example.social", "Social")),
    )
    assertEquals(2, multi.selectedApps.size)
    assertTrue(multi.tracks("com.example.social"))
    assertFalse(multi.tracks("com.example.mail"))
    assertEquals(ReminderStatus.WAITING, multi.ready().arm("multi").status)
  }

  @Test fun noSelectedAppsCannotBeArmed() {
    val empty = complete.copy(targetPackage = "", targetAppLabel = "", targetApps = emptyList())
    assertFalse(empty.hasPreparedContent)
    assertEquals(ReminderStatus.DRAFT, empty.ready().status)
  }

  @Test fun signalCanOnlyBeDeliveredOnce() {
    val first = complete.ready().arm("s").deliverSignal(true)
    assertTrue(first.signalDelivered)
    assertEquals(first, first.deliverSignal(true))
  }

  @Test fun unavailableAudioIsNotReportedAsDeliveredSignal() {
    val result = complete.ready().arm("s").deliverSignal(false)
    assertEquals(ReminderStatus.SIGNALLED, result.status)
    assertFalse(result.signalDelivered)
  }

  @Test fun disarmPreventsSignal() {
    val disarmed = complete.ready().arm("s").copy(observedUsageSeconds = 23).disarm()
    assertEquals(ReminderStatus.CLOSED, disarmed.status)
    assertEquals(23, disarmed.observedUsageSeconds)
    assertFalse(disarmed.deliverSignal(true).signalDelivered)
  }

  @Test fun closedReminderDoesNotRearmItself() {
    val closed = complete.ready().arm("s").close()
    assertEquals(ReminderStatus.CLOSED, closed.status)
    assertEquals(closed, closed.arm("another"))
  }
}
