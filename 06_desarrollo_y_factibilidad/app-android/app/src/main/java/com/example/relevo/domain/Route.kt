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

  /**
   * Intereses concretos, tomados de lo que contaron P1–P8 sobre su tiempo libre y sus estrategias
   * (corpus, Q1, Q2 y Q12). Desde 2.13 (D-088) reemplazan a los cinco intereses amplios de 2.8, que
   * el autor encontró ambiguos. Cada ruta propone tres pasos pequeños y editables (R1–R2).
   */
  val all = listOf(
    // P2, Q3–Q7; P3 y P8, Q2: dormir aparece como intención y como descanso.
    Interest("dormir", "Dormir a tiempo", listOf(
      Triple("Acostarte sin el teléfono", "Dejar el teléfono cargando lejos de la cama", "Junto al cargador"),
      Triple("Leer un rato antes de dormir", "Dejar el libro en el velador", "En el velador"),
      Triple("Acostarte a la misma hora", "Apagar la luz grande", "En tu pieza"),
    )),
    // P6 y P8, Q1–Q2 y Q12; P1, Q12 (manga).
    Interest("leer", "Leer", listOf(
      Triple("Leer 10 páginas", "Abrir el libro", "En el velador"),
      Triple("Leer un capítulo de manga", "Sacar el tomo del estante", "Junto al estante"),
      Triple("Leer un capítulo", "Abrir el libro en el marcador", "En el velador"),
    )),
    // P1, Q2 y Q12; P3, Q1 y Q12 (artes marciales).
    Interest("ejercicio", "Hacer ejercicio", listOf(
      Triple("Hacer una serie corta", "Ponerte ropa cómoda", "En tu pieza"),
      Triple("Entrenar 20 minutos", "Estirar la colchoneta", "En el living"),
      Triple("Ir a entrenar", "Preparar el bolso", "Junto a la puerta"),
    )),
    // P7, Q1 y Q12.
    Interest("bici", "Salir en bicicleta", listOf(
      Triple("Dar una vuelta corta", "Sacar la bici", "Junto a la puerta"),
      Triple("Andar 30 minutos", "Inflar las ruedas", "Junto a la bici"),
      Triple("Ir en bici a algún lugar", "Ponerte el casco", "Junto a la puerta"),
    )),
    // P1, Q1; P4, Q2 y Q12.
    Interest("perro", "Pasear o jugar con tu perro", listOf(
      Triple("Salir 10 minutos con el perro", "Tomar la correa", "Junto a la puerta"),
      Triple("Jugar con el perro", "Sacar su pelota", "Donde está su pelota"),
      Triple("Salir con el perro sin el teléfono", "Dejar el teléfono en casa", "Junto a la puerta"),
    )),
    // P2, Q12.
    Interest("dibujar", "Dibujar o pintar", listOf(
      Triple("Dibujar 10 minutos", "Sacar el cuaderno y un lápiz", "En el escritorio"),
      Triple("Pintar", "Preparar las acuarelas", "En la mesa"),
      Triple("Terminar un dibujo", "Abrir el cuaderno en ese dibujo", "En el escritorio"),
    )),
    // P2, Q12 (manualidades); P6, Q2 y Q12 (maquetas).
    Interest("manualidades", "Manualidades o maquetas", listOf(
      Triple("Avanzar 15 minutos", "Sacar los materiales", "En la mesa de trabajo"),
      Triple("Armar una parte de la maqueta", "Abrir la caja de la maqueta", "En la mesa"),
      Triple("Terminar lo que empezaste", "Dejar la pieza a la vista", "En la mesa"),
    )),
    // P1, Q2 y Q12.
    Interest("cocinar", "Cocinar", listOf(
      Triple("Cocinar algo simple", "Reunir los ingredientes", "En la cocina"),
      Triple("Probar una receta nueva", "Dejar la receta a la vista", "En la cocina"),
      Triple("Preparar la comida de mañana", "Sacar los táper", "En la cocina"),
    )),
    // P5, Q2 y Q12.
    Interest("ordenar", "Ordenar tu pieza", listOf(
      Triple("Ordenar un cajón", "Vaciar el cajón sobre la cama", "Junto al cajón"),
      Triple("Hacer la cama", "Estirar las sábanas", "En tu pieza"),
      Triple("Ordenar la ropa", "Juntar la ropa en el canasto", "Junto al canasto"),
    )),
    // P3, Q2 y Q12.
    Interest("meditar", "Meditar", listOf(
      Triple("Respirar 5 minutos", "Sentarte en el cojín", "En tu pieza"),
      Triple("Meditar 10 minutos", "Apagar la luz grande", "En tu pieza"),
      Triple("Estirar antes de dormir", "Desenrollar la colchoneta", "Junto a la cama"),
    )),
    // P8, Q12 (tareas).
    Interest("estudiar", "Estudiar o hacer tareas", listOf(
      Triple("Estudiar 20 minutos", "Abrir tus apuntes", "En el escritorio"),
      Triple("Hacer una tarea", "Abrir el cuaderno en la tarea", "En el escritorio"),
      Triple("Repasar para una prueba", "Sacar tus resúmenes", "En el escritorio"),
    )),
    // P2, Q2 (pareja); P6, Q1 (cenar con su familia); P7, Q2 (fútbol).
    Interest("compartir", "Compartir con alguien", listOf(
      Triple("Comer sin el teléfono", "Poner la mesa", "En el comedor"),
      Triple("Jugar un juego de mesa", "Sacar la caja", "En la mesa"),
      Triple("Juntarte a jugar a la pelota", "Preparar las zapatillas", "Junto a la puerta"),
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
