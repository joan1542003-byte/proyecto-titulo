package com.example.relevo.domain

enum class ReminderStatus {
  DRAFT,
  READY,
  WAITING,
  SIGNALLED,
  SILENCED,
  CLOSED,
}

enum class SignalRoute { BLUETOOTH, PHONE }
data class TrackedApp(val packageName: String, val label: String)

data class Reminder(
  val activity: String = "",
  val howToStart: String = "",
  val place: String = "",
  val targetPackage: String = "",
  val targetAppLabel: String = "",
  val requiredUsageSeconds: Int = 900,
  val observedUsageSeconds: Int = 0,
  val participantCode: String = "",
  val consentAccepted: Boolean = false,
  val sessionId: String = "",
  val status: ReminderStatus = ReminderStatus.DRAFT,
  val signalDelivered: Boolean = false,
  val signalRoute: SignalRoute = SignalRoute.BLUETOOTH,
  val targetApps: List<TrackedApp> = emptyList(),
  /** Condición de la prueba de 21 días en que se activó (A, B o C); vacío fuera de la prueba o el día 0. */
  val studyCondition: String = "",
  /** Día de la prueba en que se activó (0 a 21); −1 fuera de la prueba. */
  val studyDay: Int = -1,
  /** Momento en que se emitió la señal. */
  val signalAt: Long = 0L,
  /** La señal ya no suena: terminó sola a los 30 s, se perdió la salida o no pudo reproducirse. */
  val signalEnded: Boolean = false,
) {
  val selectedApps: List<TrackedApp>
    get() = targetApps.ifEmpty { if (targetPackage.isNotBlank()) listOf(TrackedApp(targetPackage, targetAppLabel)) else emptyList() }

  fun tracks(packageName: String?): Boolean = selectedApps.any { it.packageName == packageName }

  val hasPreparedContent: Boolean
    get() =
      activity.isNotBlank() &&
        howToStart.isNotBlank() &&
        selectedApps.isNotEmpty() &&
        selectedApps.all { it.packageName.isNotBlank() && it.label.isNotBlank() } &&
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
        signalAt = 0L,
        signalEnded = false,
      )
    } else {
      this
    }

  fun deliverSignal(audible: Boolean, at: Long = System.currentTimeMillis()): Reminder =
    if (status == ReminderStatus.WAITING) {
      copy(status = ReminderStatus.SIGNALLED, signalDelivered = audible, signalAt = at, signalEnded = !audible)
    } else {
      this
    }

  /** La señal dejó de sonar sin que la persona la silenciara; la pantalla sigue esperando su respuesta. */
  fun endSignal(): Reminder = if (status == ReminderStatus.SIGNALLED) copy(signalEnded = true) else this

  fun silence(): Reminder =
    if (status == ReminderStatus.SIGNALLED) copy(status = ReminderStatus.SILENCED) else this

  fun disarm(): Reminder =
    if (status == ReminderStatus.WAITING) {
      copy(status = ReminderStatus.CLOSED)
    } else {
      this
    }

  fun close(): Reminder = copy(status = ReminderStatus.CLOSED)
}
