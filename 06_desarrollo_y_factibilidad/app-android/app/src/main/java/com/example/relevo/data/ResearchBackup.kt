package com.example.relevo.data

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import cl.udp.relevo.BuildConfig
import org.json.JSONArray
import org.json.JSONObject
import java.time.OffsetDateTime

/**
 * Copia del registro del estudio en la carpeta Documentos/Relevo del teléfono (Android 2.11). Se
 * actualiza sola cada vez que la app intenta enviar datos, aunque no haya conexión, y queda aunque
 * se desinstale la app, para que el investigador pueda recuperar los resultados. Son cuatro archivos
 * por código de participación: el registro completo en JSON y tres tablas CSV (relevos, respuestas y uso)
 * que se abren en una planilla. No incluye el nombre ni la imagen del perfil. Borrar los datos desde
 * Privacidad y datos también borra estos archivos.
 */
object ResearchBackup {
  const val FOLDER = "Documents/Relevo/"
  private const val TAG = "RelevoBackup"
  private const val PREFERENCES = "relevo_backup"

  fun lastWrittenAt(context: Context): Long = preferences(context).getLong("last_at", 0L)

  fun write(context: Context, store: ResearchLogStore, participantCode: String): Boolean = synchronized(this) {
    if (participantCode.isBlank() || !Participation.participating(context)) return false
    if (!store.hasRecords()) return false
    runCatching {
      val log = store.exportJson()
      val json = JSONObject()
        .put("app", "Relevo ${BuildConfig.VERSION_NAME}")
        .put("copia", OffsetDateTime.now().toString())
        .put("codigo_participacion", participantCode)
        .put("registro_del_estudio", log)
      val base = "relevo-$participantCode"
      save(context, "$base.json", "application/json", json.toString(2))
      save(context, "$base-relevos.csv", "text/csv", csv(log.getJSONArray("sessions")))
      save(context, "$base-respuestas.csv", "text/csv", csv(log.getJSONArray("answers")))
      save(context, "$base-uso.csv", "text/csv", csv(log.getJSONArray("app_events")))
      preferences(context).edit().putLong("last_at", System.currentTimeMillis()).apply()
      true
    }.getOrElse { Log.w(TAG, "No se pudo escribir la copia: ${it.javaClass.simpleName}"); false }
  }

  /** Borra las copias que escribió esta instalación. Las de una instalación anterior no le pertenecen. */
  fun delete(context: Context): Boolean = synchronized(this) {
    val resolver = context.contentResolver
    val ok = ownFiles(context).all { uri -> runCatching { resolver.delete(uri, null, null) >= 0 }.getOrDefault(false) }
    preferences(context).edit().clear().apply()
    ok
  }

  private fun save(context: Context, name: String, mime: String, content: String) {
    val resolver = context.contentResolver
    val uri = find(context, name) ?: resolver.insert(collection(), ContentValues().apply {
      put(MediaStore.MediaColumns.DISPLAY_NAME, name)
      put(MediaStore.MediaColumns.MIME_TYPE, mime)
      put(MediaStore.MediaColumns.RELATIVE_PATH, FOLDER)
    }) ?: error("MediaStore no creó el archivo")
    // «wt» reemplaza el contenido. El BOM hace que las planillas lean bien los acentos del CSV.
    resolver.openOutputStream(uri, "wt")?.use { out ->
      if (mime == "text/csv") out.write(byteArrayOf(0xEF.toByte(), 0xBB.toByte(), 0xBF.toByte()))
      out.write(content.toByteArray())
    } ?: error("No se pudo abrir el archivo")
  }

  private fun find(context: Context, name: String): Uri? = context.contentResolver.query(
    collection(), arrayOf(MediaStore.MediaColumns._ID),
    "${MediaStore.MediaColumns.RELATIVE_PATH} = ? AND ${MediaStore.MediaColumns.DISPLAY_NAME} = ?", arrayOf(FOLDER, name), null,
  )?.use { cursor -> if (cursor.moveToFirst()) Uri.withAppendedPath(collection(), cursor.getLong(0).toString()) else null }

  /** Sin permisos de almacenamiento, MediaStore solo devuelve los archivos que creó esta instalación. */
  private fun ownFiles(context: Context): List<Uri> = context.contentResolver.query(
    collection(), arrayOf(MediaStore.MediaColumns._ID),
    "${MediaStore.MediaColumns.RELATIVE_PATH} = ? AND ${MediaStore.MediaColumns.DISPLAY_NAME} LIKE 'relevo-%'", arrayOf(FOLDER), null,
  )?.use { cursor -> buildList { while (cursor.moveToNext()) add(Uri.withAppendedPath(collection(), cursor.getLong(0).toString())) } }.orEmpty()

  private fun collection(): Uri = MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)

  private fun preferences(context: Context) = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

  /** Una fila por objeto; las columnas son la unión de las claves, en el orden en que aparecen. */
  internal fun csv(rows: JSONArray): String {
    val columns = LinkedHashSet<String>()
    for (i in 0 until rows.length()) rows.getJSONObject(i).keys().forEach { columns += it }
    columns -= "synced"
    val out = StringBuilder(columns.joinToString(",") { quote(it) }).append("\r\n")
    for (i in 0 until rows.length()) {
      val row = rows.getJSONObject(i)
      out.append(columns.joinToString(",") { column ->
        if (!row.has(column) || row.isNull(column)) "" else quote(dateIfTime(column, row.get(column)))
      }).append("\r\n")
    }
    return out.toString()
  }

  /** Las columnas de tiempo se guardan en milisegundos; en la planilla van como fecha y hora ISO. */
  private fun dateIfTime(column: String, value: Any): String =
    if (column.endsWith("_at") && value is Number) java.time.Instant.ofEpochMilli(value.toLong()).toString() else value.toString()

  private fun quote(value: String): String =
    if (value.any { it == ',' || it == '"' || it == '\n' || it == '\r' }) "\"" + value.replace("\"", "\"\"") + "\"" else value
}
