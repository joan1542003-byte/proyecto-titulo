package com.example.relevo.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.Settings
import com.example.relevo.data.SyncStatus
import com.example.relevo.data.ThemeMode
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.CountStepper
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PictureContent
import com.example.relevo.ui.components.PictureTile
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonArea
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SegmentedControl
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.StarRating
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.key
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.UUID

/** Una opción de ajuste: qué es, para qué sirve y sus valores en un control segmentado. */
@Composable
private fun SettingPanel(title: String, detail: String, options: List<Pair<String, String>>, selected: String, onSelect: (String) -> Unit, extra: (@Composable () -> Unit)? = null) {
  Panel {
    Text(title, style = Relevo.type.headline, color = Relevo.colors.ink)
    Text(detail, style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(4.dp))
    SegmentedControl(options, selected, { it?.let(onSelect) }, allowDeselect = false, trackColor = Relevo.colors.paper)
    extra?.invoke()
  }
}

/** S2: avisos y resúmenes. Todo lo opcional empieza apagado y se apaga con un toque. */
@Composable
internal fun NoticesScreen(settings: Settings, participation: ParticipationMode, onChange: (Settings.() -> Settings) -> Unit, onBack: () -> Unit) {
  val context = LocalContext.current
  RelevoScreen(title = "Avisos y resúmenes", onBack = onBack, backLabel = "Perfil") {
    SettingPanel(
      "Resumen «Tu semana»", "Lo que preparaste esta semana, en tu perfil.",
      listOf("no" to "No", "si" to "Sí"), if (settings.weeklySummary) "si" else "no",
      { value -> onChange { copy(weeklySummary = value == "si") } },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Aviso de regreso", "Como máximo una vez por semana y solo si no abriste Relevo.",
      listOf("nunca" to "Nunca", "semanal" to "Una vez por semana"), if (settings.returnNotice) "semanal" else "nunca",
      { value ->
        if (value == "semanal") requestNotificationPermission(context)
        onChange { copy(returnNotice = value == "semanal") }
      },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Después de responder", "Un mensaje breve o solo registrar tu respuesta.",
      listOf("con" to "Con mensajes", "solo" to "Solo registrar"), if (settings.acknowledgements) "con" else "solo",
      { value -> onChange { copy(acknowledgements = value == "con") } },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Constancia elegida", "Tú fijas cuántas veces por semana quieres hacerlo. Aparece en «Tu semana».",
      listOf("no" to "Apagada", "si" to "Elegir"), if (settings.constancy > 0) "si" else "no",
      { value -> onChange { copy(constancy = if (value == "si") constancy.coerceAtLeast(3) else 0, constancyPaused = false) } },
    ) {
      if (settings.constancy > 0) {
        Spacer(Modifier.height(6.dp))
        CountStepper(settings.constancy, { value -> onChange { copy(constancy = value) } }, 1..7, "Quiero hacerlo ${settings.constancy} ${if (settings.constancy == 1) "vez" else "veces"} por semana")
        PlainAction(if (settings.constancyPaused) "Retomar la constancia" else "Pausar la constancia", { onChange { copy(constancyPaused = !constancyPaused) } },
          icon = if (settings.constancyPaused) KitIcon.REPRODUCIR else KitIcon.PAUSAR)
      }
    }
    if (participation == ParticipationMode.STUDY) {
      Spacer(Modifier.height(10.dp))
      Text("La constancia elegida es una variante que se compara en la prueba.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
  }
}

/** Apariencia: tema y tamaño del texto, con una vista previa que cambia al instante. */
@Composable
internal fun AppearanceScreen(settings: Settings, onChange: (Settings.() -> Settings) -> Unit, onBack: () -> Unit) {
  RelevoScreen(title = "Apariencia", onBack = onBack, backLabel = "Perfil") {
    Panel {
      Text("VISTA PREVIA", style = Relevo.type.label, color = Relevo.colors.graphite)
      Signature("leer", style = Relevo.type.title, animate = false)
      Text("Sonará junto al sillón después de 40 min.", style = Relevo.type.body, color = Relevo.colors.graphite)
    }
    SectionGap()
    SettingPanel(
      "Tema", "Claro sobre papel u oscuro sobre noche.",
      listOf(ThemeMode.SYSTEM.name to "Sistema", ThemeMode.LIGHT.name to "Claro", ThemeMode.DARK.name to "Oscuro"), settings.theme.name,
      { value -> onChange { copy(theme = ThemeMode.valueOf(value)) } },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Tamaño del texto", "Se suma al tamaño que eliges en Android.",
      listOf("normal" to "Estándar", "grande" to "Grande"), if (settings.largeText) "grande" else "normal",
      { value -> onChange { copy(largeText = value == "grande") } },
    )
    Spacer(Modifier.height(10.dp))
    Text("Si en Android quitas las animaciones, Relevo tampoco las usa.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
  }
}

/** Permisos: qué pide Relevo, para qué y en qué estado está cada uno. */
@Composable
internal fun PermissionsScreen(usageAccess: Boolean, backgroundUnrestricted: Boolean, onUsageSettings: () -> Unit, onBackground: () -> Unit, onBack: () -> Unit) {
  val context = LocalContext.current
  var notifications by remember { mutableStateOf(hasNotificationPermission(context)) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { notifications = hasNotificationPermission(context) }
  RelevoScreen(title = "Permisos", onBack = onBack, backLabel = "Perfil") {
    ListSection(footer = "Tiempo de uso es necesario para contar. Las notificaciones y el funcionamiento sin restricción de batería son opcionales.") {
      ListRow("Tiempo de uso", icon = KitIcon.PERMISO, subtitle = "Cuenta el tiempo en las apps elegidas.", value = if (usageAccess) "Permitido" else "Falta", chevron = true, onClick = onUsageSettings)
      ListRow("Notificaciones", icon = KitIcon.AVISOS, subtitle = "Muestran el aviso con otra app abierta.", value = if (notifications) "Permitidas" else "Desactivadas",
        chevron = !notifications, onClick = if (notifications) null else ({ requestNotificationPermission(context) }))
      ListRow("Segundo plano", icon = KitIcon.BATERIA, subtitle = "Para que Android no detenga el conteo.", value = if (backgroundUnrestricted) "Sin restricción" else "Con restricción",
        chevron = !backgroundUnrestricted, onClick = if (backgroundUnrestricted) null else onBackground)
    }
  }
}

/** Relevos terminados, por día: hechos, sin metas ni comparaciones. */
@Composable
internal fun HistoryScreen(history: List<HistoryEntry>, customActivities: List<CustomActivity>, onBack: () -> Unit) {
  RelevoScreen(title = "Tus relevos", onBack = onBack, backLabel = "Perfil") {
    if (history.isEmpty()) {
      Text("Los relevos que termines aparecerán aquí.", style = Relevo.type.body, color = Relevo.colors.graphite)
      return@RelevoScreen
    }
    val today = LocalDate.now()
    history.groupBy { Instant.ofEpochMilli(it.completedAt).atZone(ZoneId.systemDefault()).toLocalDate() }.forEach { (day, entries) ->
      val label = when (day) {
        today -> "Hoy"
        today.minusDays(1) -> "Ayer"
        else -> todayLabel(day)
      }
      ListSection(title = label) {
        entries.forEach { entry ->
          ListRow(
            entry.activity,
            subtitle = listOfNotNull(entry.appLabel.takeIf { it.isNotBlank() }, formatDuration(entry.seconds), outcomeLabel(entry.outcome) ?: if (entry.signalDelivered) "Sonó" else "Terminó antes de sonar").joinToString(" · "),
            leading = { PictureContent(activityPicture(entry.activity, customActivities), Modifier.size(36.dp, 45.dp).clip(RoundedCornerShape(8.dp)), iconSize = 20.dp) },
            leadingWidth = 36.dp,
            trailing = { RelevoIcon(outcomeIcon(entry.outcome), size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.mist) },
          )
        }
      }
      SectionGap()
    }
  }
}

/** Actividades propias guardadas en el teléfono. No se envían a la base. */
@Composable
internal fun ActivitiesScreen(customActivities: List<CustomActivity>, onOpen: (String) -> Unit, onNew: () -> Unit, onBack: () -> Unit) {
  RelevoScreen(title = "Tus actividades", subtitle = "Se guardan solo en este teléfono.", onBack = onBack, backLabel = "Perfil") {
    ListSection {
      ListRow("Nueva actividad", icon = KitIcon.AGREGAR, chevron = true, onClick = onNew)
      customActivities.forEach { activity ->
        ListRow(
          activity.name, subtitle = activity.firstStep.takeIf { it.isNotBlank() },
          leading = { PictureContent(Picture.parse(activity.icon) ?: pictureForActivity(activity.name, emptyList()), Modifier.size(36.dp, 45.dp).clip(RoundedCornerShape(8.dp)), iconSize = 20.dp) },
          leadingWidth = 36.dp, chevron = true, onClick = { onOpen(activity.id) },
        )
      }
    }
    if (customActivities.isEmpty()) {
      Spacer(Modifier.height(12.dp))
      Text("Crea una actividad con su primer paso, su lugar y una imagen. Aparecerá en Inicio.", style = Relevo.type.body, color = Relevo.colors.graphite)
    }
  }
}

/** Iconos de actividades del kit (grupo «Actividades», 21). */
private val activityIcons = listOf(
  KitIcon.LEER, KitIcon.ESCRIBIR, KitIcon.DIBUJAR, KitIcon.PINTAR, KitIcon.GUITARRA, KitIcon.MUSICA, KitIcon.CAMINAR,
  KitIcon.BICICLETA, KitIcon.EJERCICIO, KitIcon.ESTIRAR, KitIcon.COCINAR, KitIcon.PLANTAS, KitIcon.DORMIR, KitIcon.LLAMAR,
  KitIcon.CARTA, KitIcon.ORDENAR, KitIcon.ESTUDIAR, KitIcon.FOTOGRAFIA, KitIcon.MANUALIDADES, KitIcon.JUEGO_DE_MESA, KitIcon.SALIR,
)

/** Crear o editar una actividad propia: nombre, primer paso, lugar y una imagen (foto o icono). */
@Composable
internal fun ActivityEditScreen(initial: CustomActivity?, existing: List<CustomActivity>, onSave: (CustomActivity) -> Unit, onDelete: (String) -> Unit, onBack: () -> Unit) {
  var name by rememberSaveable { mutableStateOf(initial?.name.orEmpty()) }
  var first by rememberSaveable { mutableStateOf(initial?.firstStep.orEmpty()) }
  var place by rememberSaveable { mutableStateOf(initial?.place.orEmpty()) }
  var image by rememberSaveable { mutableStateOf(initial?.icon?.let { Picture.parse(it) }?.let { if (it is Picture.OfPhoto) it.photo.key else (it as Picture.OfIcon).icon.key }.orEmpty()) }
  var confirmDelete by rememberSaveable { mutableStateOf(false) }
  val duplicate = activityIdeas.any { it.activity.equals(name.trim(), true) } || existing.any { it.id != initial?.id && it.name.equals(name.trim(), true) }
  val valid = name.trim().length in 2..60 && !duplicate && first.isNotBlank() && place.isNotBlank()
  val picture = Picture.parse(image) ?: pictureForActivity(name, emptyList())
  RelevoScreen(
    title = if (initial == null) "Nueva actividad" else "Editar la actividad",
    onBack = onBack, backLabel = "Cancelar",
    bottom = {
      RelevoButton("Guardar la actividad", {
        onSave(CustomActivity(initial?.id ?: UUID.randomUUID().toString(), name.trim(), first.trim(), place.trim(), image.ifBlank { (picture as? Picture.OfPhoto)?.photo?.key ?: (picture as Picture.OfIcon).icon.key }, 0))
      }, enabled = valid)
    },
  ) {
    Row(verticalAlignment = Alignment.Bottom) {
      PictureContent(picture, Modifier.width(96.dp).aspectRatio(0.8f).clip(Relevo.panelShape), iconSize = 36.dp)
      Spacer(Modifier.width(16.dp))
      if (name.isNotBlank()) Signature(name, style = Relevo.type.title2, animate = false, modifier = Modifier.weight(1f))
      else Text("Vuelve a ___.", style = Relevo.type.title2, color = Relevo.colors.graphite, modifier = Modifier.weight(1f))
    }
    SectionGap()
    RenglonField("Actividad", name, { name = it.take(60) }, placeholder = "Ejemplo: practicar guitarra")
    if (duplicate) { Spacer(Modifier.height(6.dp)); Text("Ya hay una actividad con ese nombre.", style = Relevo.type.footnote, color = Relevo.colors.error) }
    Spacer(Modifier.height(20.dp))
    RenglonField("¿Cómo empezarás?", first, { first = it.take(120) }, placeholder = "Ejemplo: sacar la guitarra del estuche")
    Spacer(Modifier.height(20.dp))
    RenglonField("Lugar", place, { place = it.take(120) }, placeholder = "Ejemplo: junto a la guitarra")
    SectionGap()
    Text("IMAGEN", style = Relevo.type.label, color = Relevo.colors.graphite)
    Spacer(Modifier.height(10.dp))
    choosablePhotos.chunked(4).forEach { row ->
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        row.forEach { photo -> PictureTile(Picture.OfPhoto(photo), image == photo.key, { image = photo.key }, Modifier.weight(1f), description = photo.description) }
        repeat(4 - row.size) { Spacer(Modifier.weight(1f)) }
      }
      Spacer(Modifier.height(10.dp))
    }
    Spacer(Modifier.height(6.dp))
    activityIcons.chunked(6).forEach { row ->
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        row.forEach { icon -> PictureTile(Picture.OfIcon(icon), image == icon.key, { image = icon.key }, Modifier.weight(1f), description = icon.label, aspect = 1f) }
        repeat(6 - row.size) { Spacer(Modifier.weight(1f)) }
      }
      Spacer(Modifier.height(8.dp))
    }
    if (initial != null) {
      SectionGap()
      PlainAction("Borrar la actividad", { confirmDelete = true }, color = Relevo.colors.error, icon = KitIcon.BORRAR)
    }
  }
  if (confirmDelete && initial != null) {
    RelevoSheet(onDismiss = { confirmDelete = false }, scrollable = false) {
      Text("¿Borrar «${initial.name}»?", style = Relevo.type.title2, color = Relevo.colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Se borra de tus actividades. Los relevos que ya hiciste se mantienen.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(20.dp))
      RelevoButton("Borrar la actividad", { confirmDelete = false; onDelete(initial.id) }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
      Spacer(Modifier.height(4.dp))
      PlainAction("Cancelar", { confirmDelete = false })
    }
  }
}

/**
 * S3: privacidad breve, código, estado del envío, descarga de los datos y borrado en un paso.
 * Sin participar, explica que nada sale del teléfono y ofrece participar.
 */
@Composable
internal fun PrivacyScreen(
  participantCode: String,
  participation: ParticipationMode,
  remoteConfigured: Boolean,
  syncStatus: SyncStatus,
  deletionStatus: String?,
  onBack: () -> Unit,
  onConsent: () -> Unit,
  onParticipate: () -> Unit,
  onExport: (Uri, (Boolean) -> Unit) -> Unit,
  onDelete: () -> Unit,
  onRestart: () -> Unit,
) {
  val context = LocalContext.current
  var confirming by rememberSaveable { mutableStateOf(false) }
  var copied by remember { mutableStateOf(false) }
  var exportMessage by rememberSaveable { mutableStateOf<String?>(null) }
  val deleted = deletionStatus?.startsWith("Datos eliminados") == true
  val participating = participation == ParticipationMode.STUDY
  val exporter = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/json")) { uri ->
    if (uri != null) onExport(uri) { ok -> exportMessage = if (ok) "Tus datos quedaron en el archivo que elegiste." else "No se pudo guardar el archivo. Prueba otra vez." }
  }
  RelevoScreen(
    title = "Privacidad y datos", onBack = onBack,
    bottom = if (deleted) ({ RelevoButton("Volver a comenzar", onRestart) }) else null,
  ) {
    Text(
      if (participating) "Guardamos lo que preparas, cuándo suena el aviso y lo que respondes, con un código en vez de tu nombre. No leemos lo que haces dentro de otras apps. Tu nombre y tu imagen se quedan en el teléfono. Puedes descargar o borrar tus datos cuando quieras. Si no los borras antes, los eliminamos el 30 de diciembre de 2026."
      else "No participas en la prueba. Lo que preparas se queda en este teléfono y no se envía a ninguna parte.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    SectionGap()
    if (!deleted) {
      if (participating) {
        ListSection {
          ListRow("Código de participación", icon = KitIcon.CODIGO, value = participantCode.ifBlank { "Sin código" },
            onClick = if (participantCode.isBlank()) null else ({ copy(context, participantCode); copied = true }),
            trailing = { if (participantCode.isNotBlank()) RelevoIcon(if (copied) KitIcon.LISTO else KitIcon.COPIAR, size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.mist) })
          ListRow("Consentimiento", icon = KitIcon.CONSENTIMIENTO, value = "Aceptado", chevron = true, onClick = onConsent)
          if (remoteConfigured) ListRow("Envío de datos", icon = KitIcon.SINCRONIZAR, subtitle = syncStatusText(syncStatus))
        }
      } else {
        ListSection {
          ListRow("Participar en la prueba", icon = KitIcon.VALIDACION, subtitle = "21 días, con preguntas breves.", chevron = true, onClick = onParticipate)
        }
      }
      SectionGap()
      ListSection(footer = if (participating && remoteConfigured) "Primero se confirma el borrado en la base del estudio. Si falla, el registro se detiene y lo del teléfono se guarda para reintentar." else null) {
        ListRow("Descargar mis datos", icon = KitIcon.DESCARGAR, subtitle = "Un archivo con todo lo guardado en el teléfono.", chevron = true,
          onClick = { exporter.launch("relevo-mis-datos-${LocalDate.now()}.json") })
        ListRow(if (participating) "Borrar mis datos" else "Borrar los datos del teléfono", icon = KitIcon.BORRAR, iconTint = Relevo.colors.error, titleColor = Relevo.colors.error, onClick = { confirming = true })
      }
      exportMessage?.let { Spacer(Modifier.height(12.dp)); Text(it, style = Relevo.type.subhead, color = Relevo.colors.ink) }
      if (participating) {
        Spacer(Modifier.height(12.dp))
        Text("Para consultar o pedir el borrado por correo: joan1542003@gmail.com, con tu código.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
      }
    }
    if (deletionStatus != null) {
      SectionGap()
      Notice(deletionStatus, icon = if (deleted) KitIcon.LISTO else KitIcon.INFO, tone = Tone.Info)
    }
  }
  if (confirming) {
    RelevoSheet(onDismiss = { confirming = false }, scrollable = false) {
      Text("¿Borrar tus datos?", style = Relevo.type.title2, color = Relevo.colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Se borran tus relevos, actividades, perfil, ruta, respuestas y registros del estudio. El conteo se detiene.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(20.dp))
      RelevoButton("Borrar mis datos", { confirming = false; onDelete() }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
      Spacer(Modifier.height(4.dp))
      PlainAction("Cancelar", { confirming = false })
    }
  }
}

private fun copy(context: Context, text: String) {
  context.getSystemService(ClipboardManager::class.java)?.setPrimaryClip(ClipData.newPlainText("Código de participación", text))
}

/** Opinión sobre la app: las estrellas califican la app, no a la persona. Es opcional. */
@Composable
internal fun FeedbackScreen(onSend: (Int?, String) -> Unit, onBack: () -> Unit) {
  var stars by rememberSaveable { mutableStateOf<Int?>(null) }
  var comment by rememberSaveable { mutableStateOf("") }
  RelevoScreen(
    title = "¿Cómo te resultó usar Relevo?",
    subtitle = "Tu opinión ayuda a mejorar la app. Puedes omitirla.",
    onBack = onBack, backLabel = "Cancelar",
    bottom = {
      RelevoButton("Enviar", { onSend(stars, comment) }, enabled = stars != null || comment.isNotBlank(), icon = KitIcon.ENVIAR)
      PlainAction("Omitir", onBack, color = Relevo.colors.graphite)
    },
  ) {
    StarRating(stars) { stars = it }
    SectionGap()
    RenglonArea("Comentario (opcional)", comment, { comment = it }, "¿Qué cambiarías?")
  }
}

/** Reportar un problema. El registro técnico se adjunta solo si la persona lo marca y no incluye nada de sus apps. */
@Composable
internal fun ReportScreen(onSend: (String, Boolean) -> Unit, onBack: () -> Unit) {
  var text by rememberSaveable { mutableStateOf("") }
  var attach by rememberSaveable { mutableStateOf(true) }
  RelevoScreen(
    title = "Reportar un problema",
    onBack = onBack, backLabel = "Cancelar",
    bottom = { RelevoButton("Enviar reporte", { onSend(text, attach) }, enabled = text.isNotBlank(), icon = KitIcon.ENVIAR) },
  ) {
    RenglonArea("¿Qué pasó?", text, { text = it }, "Ejemplo: no sonó en el parlante después de 40 min")
    SectionGap()
    Row(
      Modifier.fillMaxWidth().heightIn(min = 52.dp)
        .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { attach = !attach },
      verticalAlignment = Alignment.CenterVertically,
    ) {
      CheckMark(attach)
      Spacer(Modifier.width(12.dp))
      Column {
        Text("Adjuntar registro técnico", style = Relevo.type.body, color = Relevo.colors.ink)
        Text("Versión, permisos y envío. Sin contenido de tus apps.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
      }
    }
  }
}
