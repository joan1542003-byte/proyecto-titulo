package com.example.relevo.ui

import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.Photo
import java.text.Normalizer
import java.util.Locale

/**
 * Catastro de palabras clave (4.3, D-158). Cada concepto reúne las palabras con que la gente nombra una
 * actividad, el ícono de su familia y lo que tiene sentido sugerir para empezar y dónde. Cuando la persona
 * escribe su propia actividad, sus palabras eligen el concepto: «tocar guitarra» sugiere sacarla del estuche
 * y nunca un libro.
 *
 * Antes, las sugerencias se mezclaban por el ícono y por pedazos de palabras: «capítulo» hacía que «Leer un
 * capítulo de manga» contara como una película y «serie», que «Hacer una serie corta» también; por eso «Ver
 * una película» terminaba sugiriendo «Sacar el tomo del estante». Ahora una palabra se compara entera, o por
 * su raíz si lleva «*», y solo sugiere lo de su propio concepto.
 *
 * Las sugerencias nombran el objeto concreto («Elegir la película», «Elegir el libro»), nunca algo abierto
 * como «Elegir qué ver» (4.3, a pedido del autor).
 *
 * Cómo se elige: cada palabra que coincide suma 1; una frase completa, 2, y una palabra débil, medio punto,
 * porque sola no decide («ver», «jugar», «tocar»). Gana el concepto con más puntos si suma al menos 1; ante
 * un empate, el que va primero en la lista.
 */
internal class Concept(
  val id: String,
  val icon: KitIcon,
  /** Palabras enteras; con «*» al final, cualquier palabra que empiece así («dibuj*»: dibujar, dibujo). */
  val words: List<String>,
  /** Primeros pasos: acciones de segundos, concretas y del mismo objeto de la actividad. */
  val starts: List<String>,
  /** Lugares concretos, donde se puede dejar el Tag: nunca una habitación entera (2.28). */
  val places: List<String>,
  val phrases: List<String> = emptyList(),
  val weak: List<String> = emptyList(),
  val photo: Photo? = null,
  /** Para los instrumentos: la palabra y su nombre con artículo, que reemplaza «{x}» en lo sugerido. */
  val objects: Map<String, String> = emptyMap(),
)

private val spanishLocale: Locale = Locale.forLanguageTag("es")

/** Minúsculas y sin tildes, para comparar como lo escribe la gente: «Película» y «pelicula» son lo mismo. */
internal fun normalized(text: String): String =
  Normalizer.normalize(text.lowercase(spanishLocale), Normalizer.Form.NFD).replace(Regex("\\p{Mn}+"), "")

private fun tokens(text: String): List<String> = normalized(text).split(Regex("[^a-z]+")).filter { it.isNotEmpty() }

internal val catastro: List<Concept> = listOf(
  // Moverte
  Concept(
    "perro", KitIcon.PERRO,
    words = listOf("perro", "perros", "perrito", "perrita", "perra", "cachorro", "mascota", "correa"),
    phrases = listOf("pasear al perro", "sacar al perro", "jugar con el perro"),
    starts = listOf("Tomar la correa", "Sacar su pelota", "Llenar su botella de agua"),
    places = listOf("Junto a la puerta", "Donde está la correa"),
    photo = Photo.PERRO,
  ),
  Concept(
    "correr", KitIcon.CORRER,
    words = listOf("correr", "corro", "corriendo", "trotar", "troto", "trote", "running", "maraton"),
    starts = listOf("Ponerte las zapatillas", "Ponerte ropa deportiva", "Llenar la botella de agua"),
    places = listOf("Junto a la puerta", "Junto a las zapatillas"),
  ),
  Concept(
    "caminar", KitIcon.CAMINAR,
    words = listOf("caminar", "camino", "caminata", "pasear", "paseo", "cerro", "parque"),
    weak = listOf("salir"),
    starts = listOf("Ponerte las zapatillas", "Llenar la botella de agua", "Elegir el recorrido"),
    places = listOf("Junto a la puerta", "Junto a las zapatillas"),
    photo = Photo.CAMINAR,
  ),
  Concept(
    "bici", KitIcon.BICICLETA,
    words = listOf("bici", "bicis", "bicicleta", "pedalear", "ciclismo"),
    starts = listOf("Sacar la bici", "Inflar las ruedas", "Ponerte el casco"),
    places = listOf("Junto a la puerta", "Junto a la bici"),
  ),
  Concept(
    "ejercicio", KitIcon.EJERCICIO,
    words = listOf("ejercicio", "ejercicios", "entrenar", "entreno", "entrenamiento", "gimnasio", "gym", "pesas", "abdominales",
      "flexiones", "sentadillas", "crossfit", "funcional", "boxeo", "karate", "judo", "taekwondo"),
    phrases = listOf("hacer una serie", "serie corta", "artes marciales"),
    starts = listOf("Ponerte ropa deportiva", "Estirar la colchoneta", "Preparar el bolso"),
    places = listOf("Junto al clóset", "Donde guardas la colchoneta", "Junto a la puerta"),
    photo = Photo.EJERCICIO,
  ),
  Concept(
    "yoga", KitIcon.ESTIRAR,
    words = listOf("yoga", "estirar", "estiro", "elongar", "elongacion", "estiramiento", "estiramientos", "pilates"),
    starts = listOf("Desenrollar la colchoneta", "Ponerte ropa cómoda"),
    places = listOf("Donde guardas la colchoneta", "Junto a la cama"),
  ),
  Concept(
    "nadar", KitIcon.NADAR,
    words = listOf("nadar", "nado", "natacion", "piscina"),
    starts = listOf("Preparar el traje de baño", "Echar la toalla al bolso"),
    places = listOf("Junto a la puerta", "Junto al bolso"),
  ),
  Concept(
    "pelota", KitIcon.PELOTA,
    words = listOf("futbol", "pichanga", "pelota", "basquetbol", "basquet", "voleibol", "voley", "tenis", "padel", "partido", "deporte"),
    starts = listOf("Preparar las zapatillas", "Inflar la pelota", "Avisar al equipo"),
    places = listOf("Junto a la puerta"),
  ),
  Concept(
    "plantas", KitIcon.PLANTAS,
    words = listOf("planta", "plantas", "regar", "riego", "jardin", "huerto", "macetero", "maceteros", "suculentas", "podar"),
    starts = listOf("Llenar la regadera", "Ponerte los guantes"),
    places = listOf("Junto a las plantas", "Junto a la regadera"),
  ),
  // Leer y aprender
  Concept(
    "manga", KitIcon.MANGA,
    words = listOf("manga", "mangas", "comic", "comics", "historieta", "historietas", "tomo", "webtoon"),
    // «leer» y «capítulo» también son de leer: aquí suman poco, para que decida la palabra propia del manga.
    weak = listOf("leer", "capitulo", "capitulos"),
    starts = listOf("Sacar el tomo del estante", "Abrir el tomo donde quedaste"),
    places = listOf("Junto al estante", "En el velador"),
  ),
  Concept(
    "leer", KitIcon.LEER,
    words = listOf("leer", "leo", "lectura", "libro", "libros", "novela", "novelas", "cuento", "cuentos", "pagina", "paginas", "poesia"),
    weak = listOf("capitulo", "capitulos"),
    starts = listOf("Elegir el libro", "Abrir el libro en el marcador", "Dejar el libro a la vista"),
    places = listOf("En el velador", "En el sillón", "Junto al estante"),
    photo = Photo.LEER,
  ),
  Concept(
    "estudiar", KitIcon.ESTUDIAR,
    words = listOf("estudiar", "estudio", "apuntes", "tarea", "tareas", "prueba", "pruebas", "examen", "examenes", "certamen", "repasar",
      "repaso", "resumen", "resumenes", "materia", "ramo", "universidad"),
    starts = listOf("Abrir los apuntes", "Despejar el escritorio", "Abrir el cuaderno en la tarea"),
    places = listOf("En el escritorio"),
    photo = Photo.ESTUDIAR,
  ),
  Concept(
    "idiomas", KitIcon.IDIOMAS,
    words = listOf("ingles", "idioma", "idiomas", "frances", "portugues", "aleman", "japones", "coreano", "italiano", "chino", "vocabulario",
      "gramatica"),
    starts = listOf("Abrir el cuaderno de vocabulario", "Abrir el libro del curso"),
    places = listOf("En el escritorio"),
  ),
  Concept(
    "escribir", KitIcon.ESCRIBIR,
    words = listOf("escribir", "escribo", "escritura", "diario", "bitacora", "carta", "poema", "poemas", "relato", "relatos"),
    starts = listOf("Abrir el cuaderno", "Dejar un lápiz sobre el cuaderno"),
    places = listOf("En el escritorio", "En el velador"),
    photo = Photo.ESCRIBIR,
  ),
  // Crear
  Concept(
    "dibujar", KitIcon.DIBUJAR,
    words = listOf("dibuj*", "boceto", "bocetos", "ilustrar", "ilustracion", "croquis", "sketch"),
    starts = listOf("Sacar el cuaderno y un lápiz", "Abrir el cuaderno en ese dibujo", "Sacar los lápices"),
    places = listOf("En el escritorio", "En la mesa"),
    photo = Photo.DIBUJAR,
  ),
  Concept(
    "pintar", KitIcon.PINTAR,
    words = listOf("pintar", "pinto", "pintura", "pinturas", "acuarela", "acuarelas", "oleo", "acrilico", "acrilicos", "lienzo", "tempera", "temperas"),
    starts = listOf("Preparar las acuarelas", "Llenar un vaso con agua", "Sacar los pinceles"),
    places = listOf("En la mesa", "En el escritorio"),
    photo = Photo.PINTAR,
  ),
  Concept(
    "tejer", KitIcon.TEJER,
    words = listOf("tejer", "tejo", "tejido", "palillos", "crochet", "croche", "bordar", "bordado", "coser", "costura", "lana", "telar", "amigurumi"),
    starts = listOf("Sacar el tejido", "Enhebrar la aguja", "Dejar la lana a mano"),
    places = listOf("En el sillón", "En la mesa"),
  ),
  Concept(
    "maqueta", KitIcon.MAQUETA,
    words = listOf("maqueta", "maquetas", "modelismo", "lego", "legos"),
    weak = listOf("armar"),
    starts = listOf("Abrir la caja de la maqueta", "Dejar la pieza a la vista", "Ordenar las piezas"),
    places = listOf("En la mesa", "En la mesa de trabajo"),
  ),
  Concept(
    "manualidades", KitIcon.MANUALIDADES,
    words = listOf("manualidad", "manualidades", "recortar", "collage", "origami", "scrapbook"),
    starts = listOf("Sacar los materiales", "Despejar la mesa", "Dejar la tijera y el pegamento a mano"),
    places = listOf("En la mesa de trabajo", "En la mesa"),
    photo = Photo.MANUALIDADES,
  ),
  Concept(
    "foto", KitIcon.FOTOGRAFIA,
    words = listOf("foto", "fotos", "fotografia", "fotografiar", "camara", "revelar"),
    starts = listOf("Cargar la batería de la cámara", "Sacar la cámara del estuche"),
    places = listOf("Junto a la puerta", "En el escritorio"),
  ),
  // Jugar y disfrutar
  Concept(
    "piano", KitIcon.PIANO,
    words = listOf("piano", "organo", "sintetizador"),
    weak = listOf("teclado", "tocar", "practicar"),
    starts = listOf("Abrir la tapa del piano", "Dejar la partitura a la vista"),
    places = listOf("Junto al piano"),
  ),
  Concept(
    "instrumento", KitIcon.GUITARRA,
    words = listOf("guitarra", "ukelele", "violin", "charango", "flauta", "trompeta", "saxo", "saxofon", "cello", "instrumento"),
    weak = listOf("tocar", "practicar", "bajo"),
    starts = listOf("Sacar {x} del estuche", "Afinar {x}", "Dejar la partitura a la vista"),
    places = listOf("{junto}"),
    photo = Photo.GUITARRA,
    objects = mapOf(
      "guitarra" to "la guitarra", "ukelele" to "el ukelele", "violin" to "el violín", "charango" to "el charango",
      "flauta" to "la flauta", "trompeta" to "la trompeta", "saxo" to "el saxofón", "saxofon" to "el saxofón", "cello" to "el cello",
      "bajo" to "el bajo",
    ),
  ),
  Concept(
    "cantar", KitIcon.MUSICA,
    words = listOf("cantar", "canto", "coro", "karaoke"),
    starts = listOf("Elegir la canción", "Tomar un vaso de agua"),
    places = listOf("En el sillón"),
  ),
  Concept(
    "musica", KitIcon.MUSICA,
    words = listOf("musica", "disco", "discos", "album", "cancion", "canciones", "playlist", "vinilo", "vinilos", "podcast"),
    weak = listOf("escuchar"),
    starts = listOf("Ponerte los audífonos", "Elegir el disco"),
    places = listOf("En el sillón", "Junto a los discos"),
  ),
  Concept(
    "videojuegos", KitIcon.VIDEOJUEGOS,
    words = listOf("videojuego", "videojuegos", "consola", "play", "playstation", "xbox", "nintendo", "gamer", "partida"),
    phrases = listOf("jugar en el computador", "jugar en el pc"),
    weak = listOf("jugar", "juego", "switch"),
    starts = listOf("Encender la consola", "Dejar el control cargado", "Avisar a quien juega contigo"),
    places = listOf("Junto a la tele", "Junto al computador"),
  ),
  Concept(
    "peliculas", KitIcon.PELICULA,
    words = listOf("pelicula", "peliculas", "peli", "pelis", "serie", "series", "temporada", "documental", "documentales", "cine", "anime", "capitulo"),
    weak = listOf("ver"),
    starts = listOf("Elegir la película", "Elegir el capítulo", "Preparar cabritas", "Avisar a quien ve contigo"),
    places = listOf("Junto a la tele", "En el sillón"),
  ),
  Concept(
    "cartas", KitIcon.CARTAS,
    words = listOf("cartas", "naipe", "naipes", "poker", "truco", "brisca"),
    phrases = listOf("jugar a las cartas", "jugar cartas"),
    starts = listOf("Sacar el mazo", "Despejar la mesa", "Avisar a quien juega contigo"),
    places = listOf("En la mesa"),
  ),
  Concept(
    "juego de mesa", KitIcon.JUEGO_DE_MESA,
    words = listOf("ajedrez", "puzzle", "rompecabezas", "domino", "monopoly", "scrabble", "catan", "dados"),
    phrases = listOf("juego de mesa", "juegos de mesa"),
    starts = listOf("Sacar la caja", "Despejar la mesa", "Avisar a quien juega contigo"),
    places = listOf("En la mesa"),
  ),
  // En casa
  Concept(
    "cocinar", KitIcon.COCINAR,
    words = listOf("cocinar", "cocino", "cocina", "receta", "recetas", "hornear", "horno", "pan", "queque", "galletas", "torta", "postre",
      "almuerzo", "cena", "comida"),
    weak = listOf("preparar"),
    starts = listOf("Reunir los ingredientes", "Dejar la receta a la vista", "Lavar la tabla de picar"),
    places = listOf("En el mesón de la cocina"),
    photo = Photo.COCINAR,
  ),
  Concept(
    "ordenar", KitIcon.ORDENAR,
    words = listOf("ordenar", "ordeno", "orden", "limpiar", "limpio", "limpieza", "aseo", "barrer", "aspirar", "trapear", "cajon", "cajones",
      "closet", "doblar"),
    phrases = listOf("hacer la cama", "lavar la loza", "doblar la ropa", "limpiar la cocina", "ordenar la cocina"),
    starts = listOf("Juntar la ropa en el canasto", "Vaciar el cajón sobre la cama", "Abrir la ventana"),
    places = listOf("Junto al cajón", "Junto al canasto", "Junto a la cama"),
    photo = Photo.ORDENAR,
  ),
  // Descansar
  Concept(
    "dormir", KitIcon.DORMIR,
    words = listOf("dormir", "duermo", "acostarme", "acostarte", "acostar", "siesta", "descansar"),
    weak = listOf("cama"),
    starts = listOf("Dejar el teléfono cargando lejos de la cama", "Apagar la luz grande", "Ponerte el pijama"),
    places = listOf("Junto al cargador", "Junto a la cama"),
  ),
  Concept(
    "meditar", KitIcon.MEDITAR,
    words = listOf("meditar", "medito", "meditacion", "respirar", "respiracion", "mindfulness", "relajarme", "relajarte", "relajar", "rezar", "orar"),
    starts = listOf("Sentarte en el cojín", "Apagar la luz grande"),
    places = listOf("Junto al cojín", "Junto a la cama"),
  ),
  // Con otras personas
  Concept(
    "llamar", KitIcon.LLAMAR,
    words = listOf("llamar", "llamo", "llamada", "videollamada", "conversar"),
    weak = listOf("hablar"),
    starts = listOf("Buscar su número", "Escribirle que vas a llamar"),
    places = listOf("En el sillón"),
  ),
  Concept(
    "compartir", KitIcon.COMPARTIR,
    words = listOf("visitar", "visita", "juntarme", "juntarte", "juntarnos", "abuela", "abuelo", "abuelos", "amigos", "amiga", "amigo", "familia",
      "mama", "papa", "hermano", "hermana", "pareja", "polola", "pololo", "hijos", "hija", "hijo"),
    phrases = listOf("comer juntos", "almorzar con", "cenar con"),
    starts = listOf("Avisar que vas", "Preparar algo para llevar", "Poner la mesa"),
    places = listOf("Junto a la puerta", "En la mesa del comedor"),
  ),
)

private class Prepared(val concept: Concept, val exact: Set<String>, val stems: List<String>, val phrases: List<String>, val weak: Set<String>)

private val prepared: List<Prepared> = catastro.map { concept ->
  val words = concept.words.map(::normalized)
  Prepared(
    concept,
    exact = words.filterNot { it.endsWith("*") }.toSet(),
    stems = words.filter { it.endsWith("*") }.map { it.dropLast(1) },
    phrases = concept.phrases.map { tokens(it).joinToString(" ") },
    weak = concept.weak.map(::normalized).toSet(),
  )
}

/** El concepto que nombran las palabras de una actividad, o null si ninguno suma al menos 1. */
internal fun conceptFor(activity: String): Concept? {
  val words = tokens(activity)
  if (words.isEmpty()) return null
  val text = " " + words.joinToString(" ") + " "
  var best: Concept? = null
  var bestScore = 0.0
  for (entry in prepared) {
    var score = 0.0
    score += words.toSet().count { it in entry.exact || entry.stems.any(it::startsWith) }
    score += 2.0 * entry.phrases.count { text.contains(" $it ") }
    score += 0.5 * words.toSet().count { it in entry.weak }
    if (score > bestScore) { best = entry.concept; bestScore = score }
  }
  return best?.takeIf { bestScore >= 1.0 }
}

/** Lo sugerido por un concepto para una actividad: con un instrumento nombrado, su nombre reemplaza «{x}». */
private fun Concept.filled(list: List<String>, activity: String): List<String> {
  if (objects.isEmpty()) return list
  val noun = tokens(activity).firstNotNullOfOrNull { objects[it] } ?: "el instrumento"
  val near = if (noun.startsWith("el ")) "Junto al ${noun.removePrefix("el ")}" else "Junto a $noun"
  return list.map { it.replace("{x}", noun).replace("{junto}", near) }
}

internal fun conceptStarts(activity: String): List<String> = conceptFor(activity)?.let { it.filled(it.starts, activity) }.orEmpty()

internal fun conceptPlaces(activity: String): List<String> = conceptFor(activity)?.let { it.filled(it.places, activity) }.orEmpty()
