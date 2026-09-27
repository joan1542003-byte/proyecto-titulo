package com.example.relevo.domain

/** Un paso de la ruta: una actividad con su primer paso y su lugar. Es una sugerencia editable (R1–R2). */
data class RouteStep(val id: String, val activity: String, val firstStep: String, val place: String)

/**
 * La ruta de un interés: pasos en orden y el paso en que está la persona. No avanza sola ni muestra
 * porcentajes, puntos o niveles; la persona se queda en un paso el tiempo que quiera (D-074).
 */
data class RouteTrack(val interest: String, val title: String, val steps: List<RouteStep>, val current: Int = 0) {
  val currentIndex: Int get() = if (steps.isEmpty()) 0 else current.coerceIn(0, steps.lastIndex)
  val currentStep: RouteStep? get() = steps.getOrNull(currentIndex)
  val nextStep: RouteStep? get() = steps.getOrNull(currentIndex + 1)

  fun moveTo(index: Int): RouteTrack = copy(current = if (steps.isEmpty()) 0 else index.coerceIn(0, steps.lastIndex))

  fun advance(): RouteTrack = if (nextStep != null) copy(current = currentIndex + 1) else this

  fun update(step: RouteStep): RouteTrack = copy(steps = steps.map { if (it.id == step.id) step else it })

  fun add(step: RouteStep): RouteTrack = copy(steps = steps + step)

  /** Al borrar un paso, la persona sigue en el mismo paso si todavía existe. */
  fun remove(id: String): RouteTrack {
    val index = steps.indexOfFirst { it.id == id }
    if (index < 0) return this
    val remaining = steps.filterNot { it.id == id }
    val current = when {
      index < currentIndex -> currentIndex - 1
      else -> currentIndex
    }
    return copy(steps = remaining, current = if (remaining.isEmpty()) 0 else current.coerceIn(0, remaining.lastIndex))
  }

  /** Mueve un paso una posición; el paso actual sigue marcado aunque cambie de lugar. */
  fun move(id: String, offset: Int): RouteTrack {
    val index = steps.indexOfFirst { it.id == id }
    val target = index + offset
    if (index < 0 || target !in steps.indices) return this
    val marked = currentStep?.id
    val reordered = steps.toMutableList().apply { add(target, removeAt(index)) }
    return copy(steps = reordered, current = reordered.indexOfFirst { it.id == marked }.coerceAtLeast(0))
  }
}

/** Interés de P3. Son intereses, no perfiles fijos: se cambian cuando la persona quiera. */
data class Interest(val id: String, val label: String, val suggestions: List<Triple<String, String, String>>)

object Interests {
  const val OTHER = "otra"

  /** Rutas sugeridas del diseño escrito (sección 6): ejemplos editables de las entrevistas y la memoria. */
  val all = listOf(
    Interest("mover", "Moverme", listOf(
      Triple("Salir a caminar 15 minutos", "Ponerte las zapatillas", "Junto a la puerta"),
      Triple("Caminar 30 minutos", "Ponerte las zapatillas", "Junto a la puerta"),
      Triple("Trotar un tramo", "Ponerte las zapatillas", "Junto a la puerta"),
    )),
    Interest("leer", "Leer", listOf(
      Triple("Leer 10 páginas", "Abrir el libro", "En el velador"),
      Triple("Leer un capítulo", "Abrir el libro en el marcador", "En el velador"),
      Triple("Probar un género nuevo", "Elegir un libro distinto", "En el velador"),
    )),
    Interest("crear", "Crear con las manos", listOf(
      Triple("Dibujar 10 minutos", "Sacar el cuaderno y un lápiz", "En el escritorio"),
      Triple("Terminar un boceto", "Abrir el cuaderno en el boceto", "En el escritorio"),
      Triple("Probar otra técnica", "Preparar los materiales nuevos", "En el escritorio"),
    )),
    Interest("cuidar", "Cuidar la casa y a mí", listOf(
      Triple("Ordenar un cajón", "Vaciar el cajón sobre la mesa", "Junto al cajón"),
      Triple("Cocinar algo simple", "Reunir los ingredientes", "En la cocina"),
      Triple("Acostarte sin el teléfono", "Dejar el teléfono cargando lejos", "En el velador"),
    )),
    Interest("aprender", "Aprender algo", listOf(
      Triple("Practicar 10 minutos", "Abrir el cuaderno o el instrumento", "Donde estudias"),
      Triple("Tomar una lección", "Abrir la lección", "Donde estudias"),
      Triple("Contarle a alguien lo que aprendiste", "Escribirle a alguien", "Donde estudias"),
    )),
  )

  fun byId(id: String): Interest? = all.firstOrNull { it.id == id }

  /** Crea la ruta sugerida de un interés. «Otra» empieza vacía, con el nombre que escribió la persona. */
  fun suggestedTrack(id: String, otherLabel: String = "", newId: () -> String): RouteTrack {
    val interest = byId(id)
    return if (interest == null) {
      RouteTrack(OTHER, otherLabel.trim().ifBlank { "Otra actividad" }, emptyList())
    } else {
      RouteTrack(interest.id, interest.label, interest.suggestions.map { (activity, first, place) -> RouteStep(newId(), activity, first, place) })
    }
  }

  /**
   * Ajusta las rutas a los intereses elegidos: conserva las que siguen elegidas, tal como la persona
   * las dejó, agrega las nuevas con sus pasos sugeridos y quita las de intereses que ya no eligió.
   */
  fun reconcile(tracks: List<RouteTrack>, chosen: List<String>, otherLabel: String, newId: () -> String): List<RouteTrack> =
    chosen.distinct().map { id ->
      tracks.firstOrNull { it.interest == id }?.let { existing ->
        if (id == OTHER && otherLabel.isNotBlank()) existing.copy(title = otherLabel.trim()) else existing
      } ?: suggestedTrack(id, otherLabel, newId)
    }
}

/** R3: tras varias respuestas «Comencé la actividad» en el mismo paso se ofrece el siguiente. Se ajusta en la prueba. */
object NextStepRule {
  const val STARTS_BEFORE_OFFER = 3

  fun shouldOffer(starts: Int, hasNext: Boolean, declined: Boolean): Boolean =
    hasNext && !declined && starts >= STARTS_BEFORE_OFFER
}
