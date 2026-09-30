package com.example.relevo.domain

/**
 * Activación automática (D-095). Con ella encendida, Relevo empieza a contar solo cuando la persona
 * abre una de las apps de su último relevo, con esa misma actividad. Reglas sin Android, para probarlas.
 */
object AutoMode {
  /** Pausa entre relevos: después de responder o desactivar uno, el siguiente automático espera este tiempo. */
  const val PAUSE_MILLIS = 30 * 60_000L

  /** Estados en que ya hay un relevo contando o esperando respuesta; ahí no se activa otro. */
  private val BUSY = setOf(ReminderStatus.WAITING, ReminderStatus.SIGNALLED, ReminderStatus.SILENCED)

  /** El último relevo sirve para repetirse solo: tiene actividad, primer paso, lugar, apps y tiempo. */
  fun usable(last: Reminder?): Boolean =
    last != null && last.activity.isNotBlank() && last.howToStart.isNotBlank() && last.place.isNotBlank() &&
      last.selectedApps.isNotEmpty() && last.requiredUsageSeconds > 0

  /**
   * Corresponde activar un relevo automático: está encendida, hay un relevo que repetir, la app abierta
   * es una de las suyas, no hay otro en curso y ya pasó la pausa desde el anterior.
   */
  fun shouldArm(
    enabled: Boolean,
    current: ReminderStatus,
    last: Reminder?,
    foregroundPackage: String?,
    now: Long,
    lastClosedAt: Long,
  ): Boolean =
    enabled && usable(last) && last!!.tracks(foregroundPackage) && current !in BUSY && now - lastClosedAt >= PAUSE_MILLIS

  /**
   * El relevo automático: la última configuración con el código de la persona y, durante la prueba,
   * el día y la condición de hoy, que deciden dónde suena, como en un relevo activado a mano.
   */
  fun fromLast(last: Reminder, participantCode: String, condition: StudyCondition?, studyDay: Int, sessionId: String): Reminder =
    last.copy(
      participantCode = participantCode,
      consentAccepted = true,
      localOnly = false,
      signalRoute = condition?.routeFor(last.signalRoute) ?: last.signalRoute,
      studyCondition = condition?.code?.toString().orEmpty(),
      studyDay = studyDay,
      status = ReminderStatus.READY,
      autoActivated = true,
    ).arm(sessionId)
}
