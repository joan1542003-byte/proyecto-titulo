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
import com.example.relevo.data.SyncStatus
import com.example.relevo.domain.StudyCondition
import com.example.relevo.ui.components.KitIcon
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

/** Idea de actividad: un atajo editable, nunca una categoría cerrada. El nombre completa «Vuelve a ___.». */
data class ActivityIdea(val activity: String, val start: String, val place: String, val icon: KitIcon)

internal val activityIdeas = listOf(
  ActivityIdea("Leer", "Abrir el libro", "Junto al libro", KitIcon.LEER),
  ActivityIdea("Caminar", "Ponerme las zapatillas", "Junto a las zapatillas", KitIcon.CAMINAR),
  ActivityIdea("Hacer ejercicio", "Preparar una serie", "Junto a las pesas", KitIcon.EJERCICIO),
  ActivityIdea("Estudiar", "Abrir mis apuntes", "En el escritorio", KitIcon.ESTUDIAR),
  ActivityIdea("Dibujar", "Sacar el cuaderno y un lápiz", "En el escritorio", KitIcon.DIBUJAR),
  ActivityIdea("Tocar un instrumento", "Sacar la guitarra del estuche", "Junto a la guitarra", KitIcon.GUITARRA),
  ActivityIdea("Cocinar", "Reunir los ingredientes", "En la cocina", KitIcon.COCINAR),
  ActivityIdea("Ordenar", "Despejar una superficie", "En el lugar que quiero ordenar", KitIcon.ORDENAR),
  ActivityIdea("Cuidar las plantas", "Llenar la regadera", "Junto a las plantas", KitIcon.PLANTAS),
  ActivityIdea("Pasear al perro", "Tomar la correa", "Junto a la correa", KitIcon.SALIR),
  ActivityIdea("Hacer manualidades", "Preparar los materiales", "En la mesa de trabajo", KitIcon.MANUALIDADES),
  ActivityIdea("Dormir", "Dejar el teléfono cargando lejos", "En el velador", KitIcon.DORMIR),
)

/** Iconos de las actividades propias guardadas antes de 2.8, con sus claves antiguas. */
internal fun customIconOf(key: String): KitIcon = when (key) {
  "walk" -> KitIcon.CAMINAR
  "train" -> KitIcon.EJERCICIO
  "read" -> KitIcon.LEER
  "draw" -> KitIcon.DIBUJAR
  "music" -> KitIcon.MUSICA
  "cook" -> KitIcon.COCINAR
  "pause", "star" -> KitIcon.ACTIVIDAD
  else -> runCatching { KitIcon.valueOf(key) }.getOrDefault(KitIcon.ACTIVIDAD)
}

internal fun iconForActivity(name: String, custom: List<CustomActivity>): KitIcon =
  activityIdeas.firstOrNull { it.activity.equals(name, ignoreCase = true) }?.icon
    ?: custom.firstOrNull { it.name.equals(name, ignoreCase = true) }?.let { customIconOf(it.icon) }
    ?: KitIcon.ACTIVIDAD

/** «Junto a las zapatillas» → «junto a las zapatillas»; un lugar sin preposición va entre comillas. */
internal fun placePhrase(place: String): String {
  val trimmed = place.trim().trimEnd('.')
  if (trimmed.isEmpty()) return "donde lo dejaste"
  val lower = trimmed.replaceFirstChar { it.lowercase(Locale.forLanguageTag("es")) }
  val prepositions = listOf("junto", "en ", "sobre", "al ", "a ", "cerca", "bajo", "dentro", "frente", "detrás", "encima", "debajo", "entre")
  return if (prepositions.any { lower.startsWith(it) }) lower else "en «$trimmed»"
}

/** Icono real de una app instalada. Es de la persona y la ayuda a reconocerla. */
@Composable
internal fun AppIcon(packageName: String, size: Dp = 32.dp) {
  val context = LocalContext.current
  val bitmap = remember(packageName) {
    runCatching { context.packageManager.getApplicationIcon(packageName).toBitmap(96, 96).asImageBitmap() }.getOrNull()
  }
  if (bitmap != null) Image(bitmap, contentDescription = null, modifier = Modifier.size(size).clip(RoundedCornerShape(8.dp)))
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

internal fun syncStatusText(status: SyncStatus): String = buildString {
  append(if (status.pending == 0) "No hay registros pendientes." else "${status.pending} registros esperan conexión.")
  if (status.lastSuccessAt > 0L) append(" Último envío: ${formatMoment(status.lastSuccessAt)}.")
  if (status.rejected > 0) append(" La base no aceptó ${status.rejected}; se guardan en el teléfono.")
  status.lastError?.let { append(" Aviso técnico: $it") }
}

private val momentFormat = DateTimeFormatter.ofPattern("d MMM, HH:mm", Locale.forLanguageTag("es"))

internal fun formatMoment(epochMillis: Long): String =
  Instant.ofEpochMilli(epochMillis).atZone(ZoneId.systemDefault()).format(momentFormat)

internal fun outcomeLabel(outcome: String): String? = when (outcome) {
  "started" -> "Dijiste que empezaste"
  "later" -> "La dejaste para después"
  "changed" -> "Cambiaste de idea"
  else -> null
}

/** Reconocimiento breve tras la respuesta (B5). Las tres pesan lo mismo; omitir no recibe mensaje. */
internal fun acknowledgementFor(outcome: String): String? = when (outcome) {
  "started" -> "Gracias por contarlo."
  "later" -> "Queda guardado. Puedes prepararlo cuando quieras."
  "changed" -> "Está bien. Puedes elegir otra actividad cuando quieras."
  else -> null
}

internal fun conditionName(condition: StudyCondition): String = when (condition) {
  StudyCondition.SITUATED -> "Parlante junto al comienzo"
  StudyCondition.NEUTRAL -> "Parlante en un lugar neutro"
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
  StudyCondition.PHONE -> "No necesitas el parlante. La notificación dirá solo «Tu intención está disponible»."
  StudyCondition.SITUATED -> null
}
