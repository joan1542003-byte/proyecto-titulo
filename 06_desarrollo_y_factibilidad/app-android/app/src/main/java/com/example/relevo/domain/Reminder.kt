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
  val delaySeconds: Int = 60,
  val status: ReminderStatus = ReminderStatus.DRAFT,
  val scheduledAtMillis: Long? = null,
  val signalDelivered: Boolean = false,
) {
  val hasPreparedContent: Boolean
    get() = activity.isNotBlank() && howToStart.isNotBlank() && delaySeconds > 0

  val hasRequiredContent: Boolean
    get() = hasPreparedContent && place.isNotBlank()

  fun ready(): Reminder = if (hasPreparedContent) copy(status = ReminderStatus.READY) else this

  fun arm(nowMillis: Long): Reminder =
    if (status == ReminderStatus.READY && hasRequiredContent) {
      copy(
        status = ReminderStatus.WAITING,
        scheduledAtMillis = nowMillis + delaySeconds * 1_000L,
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
      copy(status = ReminderStatus.CLOSED, scheduledAtMillis = null)
    } else {
      this
    }

  fun close(): Reminder = copy(status = ReminderStatus.CLOSED, scheduledAtMillis = null)
}
