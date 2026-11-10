package com.example.relevo.domain

enum class ReminderStatus {
  DRAFT,
  READY,
  WAITING,
  SIGNALLED,
  SILENCED,
  CLOSED,
}

/**
 * Con qué suena un relevo. Los nombres son los que guarda la base de datos desde 2.11, así que no cambian.
 * - TAG: el Tag, el llavero Bluetooth que se deja donde empieza la actividad (D-109).
 * - PHONE: una notificación con sonido en el teléfono, donde esté.
 * - BLUETOOTH: un dispositivo de audio Bluetooth, como un parlante o unos audífonos.
 */
enum class SignalRoute { BLUETOOTH, PHONE, TAG }

data class TrackedApp(val packageName: String, val label: String)

data class Reminder(
  val activity: String = "",
  val howToStart: String = "",
  val place: String = "",
  val targetPackage: String = "",
  val targetAppLabel: String = "",
  val requiredUsageSeconds: Int = DEFAULT_LIMIT_SECONDS,
  val observedUsageSeconds: Int = 0,
  val participantCode: String = "",
  val consentAccepted: Boolean = false,
  val sessionId: String = "",
  val status: ReminderStatus = ReminderStatus.DRAFT,
  val signalDelivered: Boolean = false,
  val signalRoute: SignalRoute = SignalRoute.TAG,
  val targetApps: List<TrackedApp> = emptyList(),
  /**
   * La persona eligió con qué suena. Desde 1.0.0 el Tag viene elegido por defecto (D-117); la marca sigue
   * existiendo para los relevos guardados antes, que se respetan tal como estaban.
   */
  val routeChosen: Boolean = false,
  /** Momento en que sonó. */
  val signalAt: Long = 0L,
  /** Ya no suena: terminó sola a los 30 s, se perdió la salida o no pudo reproducirse. */
  val signalEnded: Boolean = false,
  /** Se activó solo al abrir una app elegida (activación automática, D-095). */
  val autoActivated: Boolean = false,
  /** El Tag no respondió al cumplirse el tiempo y sonó una notificación en el teléfono (1.0.0). */
  val soundedOnPhone: Boolean = false,
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
        participantCode.isNotBlank() && consentAccepted

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
        soundedOnPhone = false,
      )
    } else {
      this
    }

  fun deliverSignal(audible: Boolean, at: Long = System.currentTimeMillis(), onPhone: Boolean = false): Reminder =
    if (status == ReminderStatus.WAITING) {
      copy(status = ReminderStatus.SIGNALLED, signalDelivered = audible, signalAt = at, signalEnded = !audible, soundedOnPhone = onPhone)
    } else {
      this
    }

  /** Dejó de sonar sin que la persona lo silenciara; la pantalla sigue esperando su respuesta. */
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

  companion object {
    /** El tiempo que propone un relevo nuevo: 15 minutos, un límite breve para empezar (1.0.0). */
    const val DEFAULT_LIMIT_SECONDS = 15 * 60
  }
}
