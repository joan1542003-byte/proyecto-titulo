package com.example.relevo.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioDeviceInfo
import android.media.AudioManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.SyncStatus
import com.example.relevo.domain.RouteTrack
import com.example.relevo.domain.Interests
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.SignalRoute
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.Sky
import com.example.relevo.ui.components.SkyOrder
import com.example.relevo.ui.components.pictureIcon
import com.example.relevo.ui.components.skyFor
import java.text.Normalizer
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.Locale

private val spanish: Locale = Locale.forLanguageTag("es")

/**
 * Las dos preguntas de cada actividad (4.2, D-157), como las escribió el autor: el primer paso y el lugar.
 * Tienen una sola forma en toda la app: en los campos, en las hojas de las actividades y en «Todo listo».
 */
internal const val START_QUESTION = "¿Cómo empiezas la actividad?"
internal const val PLACE_QUESTION = "¿En qué lugar empieza?"

/** Idea de actividad: un atajo editable, nunca una categoría cerrada. El nombre completa «Vuelve a ___.». */
data class ActivityIdea(val activity: String, val start: String, val place: String, val icon: KitIcon, val photo: Photo? = null) {
  val picture: Picture get() = photo?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(icon)
}

internal val activityIdeas = listOf(
  // Desde 2.13 (D-088), solo actividades que aparecen en las entrevistas P1–P8 (corpus, Q1, Q2 y Q12).
  ActivityIdea("Leer", "Abrir el libro", "En el velador", KitIcon.LEER, Photo.LEER), // P6, P8
  ActivityIdea("Dormir a tiempo", "Dejar el teléfono cargando lejos", "Junto al cargador", KitIcon.DORMIR), // P2, P3, P8
  ActivityIdea("Hacer ejercicio", "Ponerte ropa cómoda", "Junto al clóset", KitIcon.EJERCICIO, Photo.EJERCICIO), // P1, P3
  ActivityIdea("Pasear al perro", "Tomar la correa", "Junto a la puerta", KitIcon.PERRO, Photo.PERRO), // P1, P4
  ActivityIdea("Dibujar", "Sacar el cuaderno y un lápiz", "En el escritorio", KitIcon.DIBUJAR, Photo.DIBUJAR), // P2
  ActivityIdea("Pintar", "Preparar las acuarelas", "En la mesa", KitIcon.PINTAR, Photo.PINTAR), // P2
  ActivityIdea("Cocinar", "Reunir los ingredientes", "En el mesón de la cocina", KitIcon.COCINAR, Photo.COCINAR), // P1
  ActivityIdea("Estudiar", "Abrir los apuntes", "En el escritorio", KitIcon.ESTUDIAR, Photo.ESTUDIAR), // P8
  ActivityIdea("Ordenar la pieza", "Despejar una superficie", "En el escritorio", KitIcon.ORDENAR, Photo.ORDENAR), // P5
  ActivityIdea("Hacer manualidades", "Preparar los materiales", "En la mesa de trabajo", KitIcon.MANUALIDADES, Photo.MANUALIDADES), // P2
  ActivityIdea("Armar una maqueta", "Abrir la caja de la maqueta", "En la mesa", KitIcon.MAQUETA), // P6
  ActivityIdea("Salir en bicicleta", "Sacar la bici", "Junto a la puerta", KitIcon.BICICLETA), // P7
  ActivityIdea("Meditar", "Sentarte en el cojín", "Junto al cojín", KitIcon.MEDITAR), // P3
  ActivityIdea("Leer manga", "Sacar el tomo del estante", "Junto al estante", KitIcon.MANGA), // P1
  // Desde 2.23, a pedido del autor: actividades de ocio que también son válidas y aparecen en P1–P8.
  ActivityIdea("Jugar videojuegos", "Encender la consola", "Junto a la tele", KitIcon.VIDEOJUEGOS), // P3, P6, P7, P8
  ActivityIdea("Escuchar música", "Ponerte los audífonos", "En el sillón", KitIcon.MUSICA), // P5, P6, P8
  ActivityIdea("Ver una película", "Elegir la película", "Junto a la tele", KitIcon.PELICULA), // P1, P2, P5
  ActivityIdea("Llamar a alguien", "Buscar su número", "En el sillón", KitIcon.LLAMAR), // P6
  ActivityIdea("Jugar un juego de mesa", "Sacar la caja", "En la mesa", KitIcon.JUEGO_DE_MESA), // P2
)

/** Lugares de la casa para elegir con un toque, sin escribir. */
private fun sameActivity(a: String, b: String): Boolean = plain(a).trim() == plain(b).trim()

/** Todos los relevos conocidos: ideas y pasos de las rutas, como (actividad, primer paso, lugar). */
private fun knownRelevos(): List<Triple<String, String, String>> =
  activityIdeas.map { Triple(it.activity, it.start, it.place) } + Interests.all.flatMap { it.suggestions }

/**
 * Primeros pasos para elegir con un toque (4.3, D-158): los del mismo relevo, si la actividad es una idea o un
 * paso de ruta, y después los de su concepto en el catastro de palabras clave. Nada de otras actividades ni
 * frases genéricas: si las palabras no nombran nada conocido, no se sugiere nada.
 */
internal fun startSuggestions(activity: String): List<String> {
  val same = knownRelevos().filter { sameActivity(it.first, activity) }.map { it.second }
  return (same + conceptStarts(activity)).distinct().take(5)
}

/** Lugares para elegir con un toque: los del mismo relevo y los de su concepto, con la misma regla. */
internal fun placeSuggestions(activity: String): List<String> {
  val same = knownRelevos().filter { sameActivity(it.first, activity) }.map { it.third }
  return (same + conceptPlaces(activity)).distinct().take(5)
}

/** Fotos e iconos de los intereses de P3 y de sus rutas (intereses concretos desde 2.13, D-088). */
internal fun interestPhoto(id: String): Photo? = when (id) {
  "leer" -> Photo.LIBRO
  "ejercicio" -> Photo.EJERCICIO
  "mover" -> Photo.SALIDA
  "perro" -> Photo.PERRO
  "dibujar" -> Photo.DIBUJAR
  "manualidades" -> Photo.MANUALIDADES
  "cocinar" -> Photo.COCINAR
  "ordenar" -> Photo.ORDENAR
  "estudiar" -> Photo.ESTUDIAR
  "crear" -> Photo.PINTAR
  "cuidar" -> Photo.PAN
  "aprender" -> Photo.APRENDER
  else -> null
}

internal fun interestIcon(id: String): KitIcon = when (id) {
  "dormir" -> KitIcon.DORMIR
  "leer" -> KitIcon.LEER
  "ejercicio" -> KitIcon.EJERCICIO
  "bici" -> KitIcon.BICICLETA
  "perro" -> KitIcon.PERRO
  "mover" -> KitIcon.CAMINAR
  "dibujar", "crear" -> KitIcon.DIBUJAR
  "manualidades" -> KitIcon.MANUALIDADES
  "cocinar" -> KitIcon.COCINAR
  "ordenar" -> KitIcon.ORDENAR
  "meditar" -> KitIcon.MEDITAR
  "estudiar", "aprender" -> KitIcon.ESTUDIAR
  "compartir" -> KitIcon.COMPARTIR
  "videojuegos" -> KitIcon.VIDEOJUEGOS
  "musica" -> KitIcon.MUSICA
  "peliculas" -> KitIcon.PELICULA
  "cuidar" -> KitIcon.PLANTAS
  else -> KitIcon.ACTIVIDAD
}

private fun plain(text: String): String =
  Normalizer.normalize(text.lowercase(spanish), Normalizer.Form.NFD).replace(Regex("\\p{Mn}+"), "")

/**
 * Imagen de una actividad: la de la idea, la que eligió la persona para su actividad propia o una
 * que sugieren sus palabras. Si ninguna calza, el icono de actividad.
 */
internal fun pictureForActivity(name: String, custom: List<CustomActivity>, routes: List<RouteTrack> = emptyList()): Picture {
  val trimmed = name.trim()
  activityIdeas.firstOrNull { it.activity.equals(trimmed, ignoreCase = true) }?.let { return it.picture }
  custom.firstOrNull { it.name.equals(trimmed, ignoreCase = true) }?.let { activity -> Picture.parse(activity.icon)?.let { return it } }
  // Un paso de la ruta lleva la foto de su interés, la misma que en Inicio y en Ruta.
  routes.firstOrNull { track -> track.steps.any { it.activity.equals(trimmed, ignoreCase = true) } }
    ?.let { track -> interestPhoto(track.interest) }?.let { return Picture.OfPhoto(it) }
  conceptFor(trimmed)?.let { concept -> return concept.photo?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(concept.icon) }
  return Picture.OfIcon(KitIcon.ACTIVIDAD)
}

/** Rutas de la persona, para que cada pantalla muestre la misma foto de un paso. */
internal val LocalRoutes = staticCompositionLocalOf<List<RouteTrack>> { emptyList() }

@Composable
internal fun activityPicture(name: String, custom: List<CustomActivity>): Picture = pictureForActivity(name, custom, LocalRoutes.current)

internal fun iconForActivity(name: String, custom: List<CustomActivity>): KitIcon {
  val trimmed = name.trim()
  activityIdeas.firstOrNull { it.activity.equals(trimmed, ignoreCase = true) }?.let { return it.icon }
  return conceptFor(trimmed)?.icon
    ?: (custom.firstOrNull { it.name.equals(trimmed, ignoreCase = true) }?.let { (Picture.parse(it.icon) as? Picture.OfIcon)?.icon })
    ?: KitIcon.ACTIVIDAD
}

/**
 * Variante del cielo de una actividad (3.2, D-131): las ideas de una misma familia toman variantes
 * distintas en orden, para que dos fichas del mismo color nunca se vean idénticas; las demás, una fija
 * según su nombre. Es la misma en todas las pantallas.
 */
internal fun activityVariant(name: String): Int {
  val trimmed = name.trim()
  val index = activityIdeas.indexOfFirst { it.activity.equals(trimmed, ignoreCase = true) }
  if (index >= 0) {
    val sky = skyFor(pictureIcon(activityIdeas[index].picture))
    return activityIdeas.take(index).count { skyFor(pictureIcon(it.picture)) == sky } % 4
  }
  return (plain(trimmed).hashCode() and 0x7fffffff) % 4
}

/** El ícono que da el cielo de una actividad: el de su imagen. */
@Composable
internal fun activityIcon(name: String, custom: List<CustomActivity>): KitIcon = pictureIcon(activityPicture(name, custom))

/**
 * Ideas para Inicio (3.2): una por familia, en el orden de los cielos (moverse, leer, crear, jugar, la casa
 * y descansar), para que los colores no se repitan ni se mezclen.
 */
internal val homeIdeas: List<ActivityIdea> = SkyOrder.mapNotNull { sky -> activityIdeas.firstOrNull { skyFor(pictureIcon(it.picture)) == sky } }.take(6)

/** Ideas agrupadas por familia, en el orden de los cielos, para «¿Qué quieres hacer?». */
internal val ideasByFamily: List<Pair<Sky, List<ActivityIdea>>> =
  SkyOrder.map { sky -> sky to activityIdeas.filter { skyFor(pictureIcon(it.picture)) == sky } }.filter { it.second.isNotEmpty() }

/** Clave estable para que la foto de una actividad viaje entre pantallas. */
internal fun photoKey(source: String, name: String) = "$source:${name.trim().lowercase(spanish)}"

/**
 * La línea de cuando suena, con el rótulo fijo de la app (R1 del estudio de los textos): «Para empezar:
 * abrir el libro, en el velador.». Sin datos, null.
 */
internal fun startLine(firstStep: String, place: String): String? {
  val first = firstStep.trim().trimEnd('.').replaceFirstChar { it.lowercase(spanish) }
  val where = place.trim().trimEnd('.').takeIf { it.isNotEmpty() }?.let(::placePhrase)
  return when {
    first.isNotEmpty() && where != null -> "Para empezar: $first, $where."
    first.isNotEmpty() -> "Para empezar: $first."
    where != null -> "Empieza $where."
    else -> null
  }
}

/** «Junto a las zapatillas» → «junto a las zapatillas»; un lugar sin preposición va entre comillas. */
internal fun placePhrase(place: String): String {
  val trimmed = place.trim().trimEnd('.')
  if (trimmed.isEmpty()) return "donde lo dejaste"
  val lower = trimmed.replaceFirstChar { it.lowercase(spanish) }
  val prepositions = listOf("junto", "en ", "sobre", "al ", "a ", "cerca", "bajo", "dentro", "frente", "detrás", "encima", "debajo", "entre", "donde")
  return if (prepositions.any { lower.startsWith(it) }) lower else "en «$trimmed»"
}

/** Icono real de una app instalada. Es de la persona y la ayuda a reconocerla. */
@Composable
internal fun AppIcon(packageName: String, size: Dp = 32.dp) {
  val context = LocalContext.current
  val bitmap = remember(packageName) {
    runCatching { context.packageManager.getApplicationIcon(packageName).toBitmap(96, 96).asImageBitmap() }.getOrNull()
  }
  if (bitmap != null) Image(bitmap, contentDescription = null, modifier = Modifier.size(size).clip(RoundedCornerShape(size * 0.25f)))
}

internal fun hasNotificationPermission(context: Context): Boolean =
  ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED

internal fun requestNotificationPermission(context: Context) {
  if (!hasNotificationPermission(context)) {
    (context as? Activity)?.let { ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1001) }
  }
}

/**
 * Hay un dispositivo de audio Bluetooth conectado, como un parlante o unos audífonos. No prueba que suene:
 * para eso está «Probar el sonido».
 */
internal fun audioDeviceConnected(context: Context): Boolean =
  context.getSystemService(AudioManager::class.java)?.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
    ?.any { it.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP || it.type == AudioDeviceInfo.TYPE_BLE_SPEAKER || it.type == AudioDeviceInfo.TYPE_BLE_HEADSET } == true

/** El nombre de cada salida. Como opción de «¿Dónde suena?», el teléfono se llama «Notificaciones» ([routeLabel]). */
internal fun routeName(route: SignalRoute): String = when (route) {
  SignalRoute.BLUETOOTH -> "Dispositivo de audio"
  SignalRoute.TAG -> "Tag"
  SignalRoute.PHONE -> "Teléfono"
}

/**
 * La respuesta a «¿Dónde suena?» (4.3, D-158): «Tag», «Dispositivo de audio» o «Notificaciones», que llegan
 * al teléfono y al reloj que las reciba. El reloj por llamada (D-093) deja de ofrecerse. Sin «tu» delante:
 * repetido en cada opción, cansaba la lectura.
 */
internal fun routeLabel(route: SignalRoute): String = if (route == SignalRoute.PHONE) "Notificaciones" else routeName(route)

/** «en el Tag», «en el dispositivo de audio» y, como pidió el autor, «en tu teléfono» (4.3). */
internal fun routeWhere(route: SignalRoute): String = when (route) {
  SignalRoute.PHONE -> "en tu teléfono"
  else -> "en el " + routeName(route).replaceFirstChar { if (route == SignalRoute.TAG) it else it.lowercaseChar() }
}

internal fun routeIcon(route: SignalRoute): KitIcon = when (route) {
  SignalRoute.BLUETOOTH -> KitIcon.PARLANTE
  SignalRoute.TAG -> KitIcon.OBJETO
  SignalRoute.PHONE -> KitIcon.AVISOS
}

internal fun routeFailure(route: SignalRoute): String = when (route) {
  SignalRoute.BLUETOOTH -> "No sonó en el dispositivo de audio. Revisa que esté encendido y conectado."
  SignalRoute.TAG -> "No sonó en el Tag. Revisa que esté encendido y cerca del teléfono."
  SignalRoute.PHONE -> "No sonó en tu teléfono. Revisa el volumen."
}

internal fun syncStatusText(status: SyncStatus): String = buildString {
  append(if (status.pending == 0) "Todo está enviado." else "Algunos datos se enviarán cuando haya internet.")
  if (status.lastSuccessAt > 0L) append(" Último envío: ${formatMoment(status.lastSuccessAt)}.")
  if (status.rejected > 0) append(" ${status.rejected} no se aceptaron y quedan en el teléfono.")
}

internal fun backupStatusText(status: SyncStatus): String =
  if (status.backupAt > 0L) "En Documentos/Relevo. Última copia: ${formatMoment(status.backupAt)}." else "Se crea en Documentos/Relevo con el primer relevo."

private val momentFormat = DateTimeFormatter.ofPattern("d MMM, HH:mm", spanish)
private val todayFormat = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM", spanish)

internal fun formatMoment(epochMillis: Long): String =
  Instant.ofEpochMilli(epochMillis).atZone(ZoneId.systemDefault()).format(momentFormat)

/** «Jueves 25 de septiembre», para el encabezado de Inicio y los días de «Tus relevos». */
internal fun todayLabel(today: LocalDate = LocalDate.now()): String = today.format(todayFormat).replaceFirstChar { it.titlecase(spanish) }

internal fun outcomeLabel(outcome: String): String? = when (outcome) {
  "started" -> "Dijiste que empezaste"
  "later" -> "La dejaste para después"
  "changed" -> "Cambiaste de idea"
  else -> null
}

internal fun outcomeIcon(outcome: String): KitIcon = when (outcome) {
  "started" -> KitIcon.COMENCE
  "later" -> KitIcon.DESPUES
  "changed" -> KitIcon.CAMBIE
  else -> KitIcon.HISTORIAL
}

/**
 * Unas palabras tras la respuesta (B5). Las tres pesan lo mismo; saltar no recibe mensaje. «Contar» queda
 * solo para el tiempo (R3).
 */
internal fun acknowledgementFor(outcome: String): String? = when (outcome) {
  "started" -> "Queda anotado. Gracias por decirlo."
  "later" -> "Queda anotado. Puedes prepararlo cuando quieras."
  "changed" -> "Está bien. Puedes elegir otra actividad cuando quieras."
  else -> null
}

/**
 * «Tu semana» (S1): solo hechos de esta semana, de lunes a hoy. Sin metas ni comparación con
 * semanas anteriores.
 */
internal data class WeekFacts(val prepared: Int, val started: Int)

internal fun weekFacts(history: List<HistoryEntry>, today: LocalDate = LocalDate.now()): WeekFacts {
  val monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
  val thisWeek = history.filter { !Instant.ofEpochMilli(it.completedAt).atZone(ZoneId.systemDefault()).toLocalDate().isBefore(monday) }
  return WeekFacts(prepared = thisWeek.size, started = thisWeek.count { it.outcome == "started" })
}

/**
 * Dónde suena, en palabras. El objeto va donde la persona dijo que empieza; solo en la semana B va en
 * otro lugar de la casa (D-079, D-112).
 */
internal fun soundPlace(reminder: Reminder): String = routeLabel(reminder.signalRoute) + when {
  reminder.signalRoute == SignalRoute.PHONE -> ""
  else -> ", donde empiezas"
}

/** Dónde sonará, en una frase: «en el Tag, en el velador» o «en el teléfono». */
internal fun soundWhere(reminder: Reminder): String =
  if (reminder.signalRoute == SignalRoute.PHONE) routeWhere(SignalRoute.PHONE)
  else routeWhere(reminder.signalRoute) + ", " + placePhrase(reminder.place)
