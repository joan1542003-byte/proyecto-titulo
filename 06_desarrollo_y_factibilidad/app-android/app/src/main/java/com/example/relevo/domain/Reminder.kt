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
 * Por dónde suena la señal. BLUETOOTH: parlante multimedia. PHONE: altavoz del teléfono.
 * WATCH: reloj u otro equipo que contesta llamadas; el tono viaja como audio de llamada (D-093, experimental).
 * TAG: llavero iTag clásico; pita con el servicio Bluetooth estándar de alerta inmediata (D-109).
 */
enum class SignalRoute { BLUETOOTH, PHONE, WATCH, TAG }
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
  /**
   * Condición en que sonó (D-110): la elige la persona con la salida y el lugar del objeto. A: objeto donde
   * empieza; B: objeto en otro lugar; C: teléfono. Vacío si no eligió dónde deja el objeto.
   */
  val studyCondition: String = "",
  /**
   * La persona eligió dónde suena. En un relevo nuevo no hay salida marcada (2.21): sin elegir,
   * [signalRoute] no se muestra ni se usa. Al repetir un relevo se conserva su propia elección.
   */
  val routeChosen: Boolean = false,
  /** Dónde deja el objeto que suena: true donde empieza, false en otro lugar; null sin elegir (D-110). */
  val objectNearStart: Boolean? = null,
  /** Día de la prueba en que se activó (0 a 21); −1 fuera de la prueba. */
  val studyDay: Int = -1,
  /** Momento en que se emitió la señal. */
  val signalAt: Long = 0L,
  /** La señal ya no suena: terminó sola a los 30 s, se perdió la salida o no pudo reproducirse. */
  val signalEnded: Boolean = false,
  /** Se usa sin participar en la prueba (A2): funciona igual, sin código ni registro del estudio. */
  val localOnly: Boolean = false,
  /** Se activó solo al abrir una app elegida (activación automática, D-095). */
  val autoActivated: Boolean = false,
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
        ((participantCode.isNotBlank() && consentAccepted) || localOnly)

  val hasRequiredContent: Boolean
    get() = hasPreparedContent && place.isNotBlank()

  /** La condición que eligió la persona: C en el teléfono; A o B según dónde deja el objeto (D-110). */
  fun chosenCondition(): String = when {
    signalRoute == SignalRoute.PHONE -> "C"
    objectNearStart == true -> "A"
    objectNearStart == false -> "B"
    else -> ""
  }

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
