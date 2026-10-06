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
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.StudyCondition
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.Picture
import java.text.Normalizer
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.Locale

private val spanish: Locale = Locale.forLanguageTag("es")

/** Idea de actividad: un atajo editable, nunca una categoría cerrada. El nombre completa «Vuelve a ___.». */
data class ActivityIdea(val activity: String, val start: String, val place: String, val icon: KitIcon, val photo: Photo? = null) {
  val picture: Picture get() = photo?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(icon)
}

internal val activityIdeas = listOf(
  // Desde 2.13 (D-088), solo actividades que aparecen en las entrevistas P1–P8 (corpus, Q1, Q2 y Q12).
  ActivityIdea("Leer", "Abrir el libro", "En el velador", KitIcon.LEER, Photo.LEER), // P6, P8
  ActivityIdea("Dormir a tiempo", "Dejar el teléfono cargando lejos", "Junto al cargador", KitIcon.DORMIR), // P2, P3, P8
  ActivityIdea("Hacer ejercicio", "Ponerte ropa cómoda", "En tu pieza", KitIcon.EJERCICIO, Photo.EJERCICIO), // P1, P3
  ActivityIdea("Pasear al perro", "Tomar la correa", "Junto a la puerta", KitIcon.SALIR, Photo.PERRO), // P1, P4
  ActivityIdea("Dibujar", "Sacar el cuaderno y un lápiz", "En el escritorio", KitIcon.DIBUJAR, Photo.DIBUJAR), // P2
  ActivityIdea("Pintar", "Preparar las acuarelas", "En la mesa", KitIcon.PINTAR, Photo.PINTAR), // P2
  ActivityIdea("Cocinar", "Reunir los ingredientes", "En la cocina", KitIcon.COCINAR, Photo.COCINAR), // P1
  ActivityIdea("Estudiar", "Abrir tus apuntes", "En el escritorio", KitIcon.ESTUDIAR, Photo.ESTUDIAR), // P8
  ActivityIdea("Ordenar tu pieza", "Despejar una superficie", "En tu pieza", KitIcon.ORDENAR, Photo.ORDENAR), // P5
  ActivityIdea("Hacer manualidades", "Preparar los materiales", "En la mesa de trabajo", KitIcon.MANUALIDADES, Photo.MANUALIDADES), // P2
  ActivityIdea("Armar una maqueta", "Abrir la caja de la maqueta", "En la mesa", KitIcon.MANUALIDADES), // P6
  ActivityIdea("Salir en bicicleta", "Sacar la bici", "Junto a la puerta", KitIcon.BICICLETA), // P7
  ActivityIdea("Meditar", "Sentarte en el cojín", "En tu pieza", KitIcon.ESTIRAR), // P3
  ActivityIdea("Leer manga", "Sacar el tomo del estante", "Junto al estante", KitIcon.LEER, Photo.LIBRO), // P1
)

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
  "perro", "mover" -> KitIcon.CAMINAR
  "dibujar", "crear" -> KitIcon.DIBUJAR
  "manualidades" -> KitIcon.MANUALIDADES
  "cocinar" -> KitIcon.COCINAR
  "ordenar" -> KitIcon.ORDENAR
  "meditar" -> KitIcon.ESTIRAR
  "estudiar", "aprender" -> KitIcon.ESTUDIAR
  "compartir" -> KitIcon.JUEGO_DE_MESA
  "cuidar" -> KitIcon.PLANTAS
  else -> KitIcon.ACTIVIDAD
}

private fun plain(text: String): String =
  Normalizer.normalize(text.lowercase(spanish), Normalizer.Form.NFD).replace(Regex("\\p{Mn}+"), "")

/** Palabras que sugieren una foto y un icono cuando la persona escribe su propia actividad. */
private val keywords: List<Triple<List<String>, Photo?, KitIcon>> = listOf(
  Triple(listOf("perro", "correa"), Photo.PERRO, KitIcon.SALIR),
  Triple(listOf("camin", "trot", "corr", "zapatill", "pasear"), Photo.CAMINAR, KitIcon.CAMINAR),
  Triple(listOf("bici"), null, KitIcon.BICICLETA),
  Triple(listOf("estir", "yoga"), null, KitIcon.ESTIRAR),
  Triple(listOf("ejercicio", "entren", "pesas", "gimnasio", "serie"), Photo.EJERCICIO, KitIcon.EJERCICIO),
  Triple(listOf("leer", "libro", "capitulo", "pagina", "lectura", "genero"), Photo.LEER, KitIcon.LEER),
  Triple(listOf("dibuj", "boceto"), Photo.DIBUJAR, KitIcon.DIBUJAR),
  Triple(listOf("pint", "acuarel", "tecnica"), Photo.PINTAR, KitIcon.PINTAR),
  Triple(listOf("guitarra", "instrumento", "tocar", "piano", "ukelele"), Photo.GUITARRA, KitIcon.GUITARRA),
  Triple(listOf("musica", "cantar"), null, KitIcon.MUSICA),
  Triple(listOf("cocin", "ingrediente", "receta", "hornear", "pan"), Photo.COCINAR, KitIcon.COCINAR),
  Triple(listOf("orden", "cajon", "limpi", "doblar"), Photo.ORDENAR, KitIcon.ORDENAR),
  Triple(listOf("planta", "regar", "regadera", "jardin"), null, KitIcon.PLANTAS),
  Triple(listOf("dormir", "acostar", "descansar"), null, KitIcon.DORMIR),
  Triple(listOf("escrib", "diario", "carta"), Photo.ESCRIBIR, KitIcon.ESCRIBIR),
  Triple(listOf("llamar"), null, KitIcon.LLAMAR),
  Triple(listOf("estudi", "apunte", "leccion", "practic", "aprend", "repasar"), Photo.ESTUDIAR, KitIcon.ESTUDIAR),
  Triple(listOf("manualidad", "tejer", "coser", "armar"), Photo.MANUALIDADES, KitIcon.MANUALIDADES),
  Triple(listOf("foto"), null, KitIcon.FOTOGRAFIA),
  Triple(listOf("juego de mesa", "ajedrez"), null, KitIcon.JUEGO_DE_MESA),
)

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
  val words = plain(trimmed)
  keywords.firstOrNull { (keys, _, _) -> keys.any { words.contains(it) } }?.let { (_, photo, icon) ->
    return photo?.let { Picture.OfPhoto(it) } ?: Picture.OfIcon(icon)
  }
  return Picture.OfIcon(KitIcon.ACTIVIDAD)
}

/** Rutas de la persona, para que cada pantalla muestre la misma foto de un paso. */
internal val LocalRoutes = staticCompositionLocalOf<List<RouteTrack>> { emptyList() }

@Composable
internal fun activityPicture(name: String, custom: List<CustomActivity>): Picture = pictureForActivity(name, custom, LocalRoutes.current)

internal fun iconForActivity(name: String, custom: List<CustomActivity>): KitIcon {
  val trimmed = name.trim()
  activityIdeas.firstOrNull { it.activity.equals(trimmed, ignoreCase = true) }?.let { return it.icon }
  val words = plain(trimmed)
  return keywords.firstOrNull { (keys, _, _) -> keys.any { words.contains(it) } }?.third
    ?: (custom.firstOrNull { it.name.equals(trimmed, ignoreCase = true) }?.let { (Picture.parse(it.icon) as? Picture.OfIcon)?.icon })
    ?: KitIcon.ACTIVIDAD
}

/** Clave estable para que la foto de una actividad viaje entre pantallas. */
internal fun photoKey(source: String, name: String) = "$source:${name.trim().lowercase(spanish)}"

/**
 * Une el primer paso y el lugar en una frase (D-084): «Empieza por ponerte las zapatillas, junto a
 * la puerta.». Reemplaza los rótulos «Empiezas» y «Lugar», que se entendían mal. Sin datos, null.
 */
internal fun startSentence(firstStep: String, place: String): String? {
  val first = firstStep.trim().trimEnd('.')
  val where = place.trim().trimEnd('.').takeIf { it.isNotEmpty() }?.let(::placePhrase)
  return when {
    first.isNotEmpty() && where != null -> "Empieza por ${first.replaceFirstChar { it.lowercase(spanish) }}, $where."
    first.isNotEmpty() -> "Empieza por ${first.replaceFirstChar { it.lowercase(spanish) }}."
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

/** Hay un parlante Bluetooth multimedia conectado. No prueba que suene: para eso está «Probar el sonido». */
internal fun bluetoothSpeakerConnected(context: Context): Boolean =
  context.getSystemService(AudioManager::class.java)?.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
    ?.any { it.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP || it.type == AudioDeviceInfo.TYPE_BLE_SPEAKER } == true

internal fun routeName(route: SignalRoute): String = when (route) {
  SignalRoute.BLUETOOTH -> "El parlante"
  SignalRoute.WATCH -> "El reloj"
  SignalRoute.TAG -> "El llavero"
  SignalRoute.PHONE -> "El teléfono"
}

internal fun routeIcon(route: SignalRoute): KitIcon = when (route) {
  SignalRoute.BLUETOOTH -> KitIcon.PARLANTE
  SignalRoute.WATCH -> KitIcon.TIEMPO
  SignalRoute.TAG -> KitIcon.OBJETO
  SignalRoute.PHONE -> KitIcon.TELEFONO
}

internal fun routeFailure(route: SignalRoute): String = when (route) {
  SignalRoute.BLUETOOTH -> "No sonó en el parlante. Revisa que esté encendido y conectado."
  SignalRoute.WATCH -> "No sonó en el reloj. Revisa que esté conectado y con las llamadas por Bluetooth activadas."
  SignalRoute.TAG -> "No sonó en el llavero. Revisa que esté encendido y cerca del teléfono."
  SignalRoute.PHONE -> "No sonó en el teléfono. Revisa el volumen."
}

/** Hay un reloj u otro equipo conectado que puede recibir audio de llamada (D-093). */
internal fun callDeviceConnected(context: Context): Boolean =
  context.getSystemService(AudioManager::class.java)?.availableCommunicationDevices
    ?.any { it.type == AudioDeviceInfo.TYPE_BLUETOOTH_SCO || it.type == AudioDeviceInfo.TYPE_BLE_HEADSET } == true

internal fun syncStatusText(status: SyncStatus): String = buildString {
  append(if (status.pending == 0) "Todo está enviado." else "Algunos datos se enviarán cuando haya internet.")
  if (status.lastSuccessAt > 0L) append(" Último envío: ${formatMoment(status.lastSuccessAt)}.")
  if (status.rejected > 0) append(" ${status.rejected} no se aceptaron y quedan en el teléfono.")
  status.lastError?.let { append(" Detalle técnico: $it") }
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

/** Reconocimiento breve tras la respuesta (B5). Las tres pesan lo mismo; omitir no recibe mensaje. */
internal fun acknowledgementFor(outcome: String): String? = when (outcome) {
  "started" -> "Gracias por contarlo."
  "later" -> "Queda guardado. Puedes prepararlo cuando quieras."
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

/** Dónde suena, en palabras: «El parlante, donde empiezas» (D-110). */
internal fun soundPlace(reminder: Reminder): String = routeName(reminder.signalRoute) + when {
  reminder.signalRoute == SignalRoute.PHONE -> ""
  reminder.objectNearStart == true -> ", donde empiezas"
  reminder.objectNearStart == false -> ", en otro lugar"
  else -> ""
}

/** Nombre de la condición para la persona, en palabras de todos los días (D-084). */
internal fun conditionName(condition: StudyCondition): String = when (condition) {
  StudyCondition.SITUATED -> "Parlante donde empiezas"
  StudyCondition.NEUTRAL -> "Parlante en otro lugar"
  StudyCondition.PHONE -> "Aviso en el teléfono"
}

/** Lo que la app pide al comenzar cada semana, con las palabras del protocolo 02. */
internal fun conditionInstruction(condition: StudyCondition): String = when (condition) {
  StudyCondition.SITUATED -> "Esta semana deja el parlante junto a lo que necesitas para empezar."
  StudyCondition.NEUTRAL -> "Esta semana deja el parlante en un lugar que no tenga relación con la actividad."
  StudyCondition.PHONE -> "Esta semana el aviso sonará en tu teléfono."
}

internal fun conditionDetail(condition: StudyCondition): String? = when (condition) {
  StudyCondition.NEUTRAL -> "Un lugar visible, a más de un metro de lo que necesitas para empezar y fuera de tu camino."
  StudyCondition.PHONE -> "No necesitas el parlante. La notificación solo dirá «Es momento de volver a elegir»."
  StudyCondition.SITUATED -> null
}

internal fun conditionIcon(condition: StudyCondition): KitIcon = when (condition) {
  StudyCondition.SITUATED -> KitIcon.LUGAR
  StudyCondition.NEUTRAL -> KitIcon.PARLANTE
  StudyCondition.PHONE -> KitIcon.TELEFONO
}
