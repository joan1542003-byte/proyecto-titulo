package com.example.relevo.domain

enum class ReminderStatus {
  DRAFT,
  READY,
  WAITING,
  SIGNALLED,
  SILENCED,
  CLOSED,
}

data class Reminder(
  val activity: String = "",
  val howToStart: String = "",
  val place: String = "",
  val targetPackage: String = "",
  val targetAppLabel: String = "",
  val requiredUsageSeconds: Int = 60,
  val observedUsageSeconds: Int = 0,
  val participantCode: String = "",
  val consentAccepted: Boolean = false,
  val sessionId: String = "",
  val status: ReminderStatus = ReminderStatus.DRAFT,
  val signalDelivered: Boolean = false,
) {
  val hasPreparedContent: Boolean
    get() =
      activity.isNotBlank() &&
        howToStart.isNotBlank() &&
        targetPackage.isNotBlank() &&
        targetAppLabel.isNotBlank() &&
        requiredUsageSeconds > 0 &&
        participantCode.isNotBlank() &&
        consentAccepted

  val hasRequiredContent: Boolean
    get() = hasPreparedContent && place.isNotBlank()

  fun ready(): Reminder = if (hasPreparedContent) copy(status = ReminderStatus.READY) else this

  fun arm(newSessionId: String): Reminder =
    if (status == ReminderStatus.READY && hasRequiredContent) {
      copy(
        status = ReminderStatus.WAITING,
        sessionId = newSessionId,
        observedUsageSeconds = 0,
        signalDelivered = false,
      )
    } else {
      this
    }

  fun deliverSignal(): Reminder =
    if (status == ReminderStatus.WAITING && !signalDelivered) {
      copy(status = ReminderStatus.SIGNALLED, signalDelivered = true)
    } else {
      this
    }

  fun silence(): Reminder =
    if (status == ReminderStatus.SIGNALLED) copy(status = ReminderStatus.SILENCED) else this

  fun disarm(): Reminder =
    if (status == ReminderStatus.WAITING) {
      copy(status = ReminderStatus.CLOSED, observedUsageSeconds = 0)
    } else {
      this
    }

  fun close(): Reminder = copy(status = ReminderStatus.CLOSED)
}
