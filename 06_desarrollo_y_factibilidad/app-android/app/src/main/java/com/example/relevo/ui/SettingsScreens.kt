package com.example.relevo.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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

/** Una opción de ajuste: qué es, en una línea, y sus valores en un control segmentado. */
@Composable
private fun SettingPanel(title: String, detail: String, options: List<Pair<String, String>>, selected: String, onSelect: (String) -> Unit, extra: (@Composable () -> Unit)? = null) {
  Panel {
    Text(title, style = Relevo.type.headline, color = Relevo.colors.ink)
    Text(detail, style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(6.dp))
    SegmentedControl(options, selected, { it?.let(onSelect) }, allowDeselect = false)
    extra?.invoke()
  }
}

/** S2: avisos y resúmenes. Todo lo opcional empieza apagado y se apaga con un toque. */
@Composable
internal fun NoticesScreen(settings: Settings, onChange: (Settings.() -> Settings) -> Unit, onBack: () -> Unit) {
  val context = LocalContext.current
  RelevoScreen(title = "Avisos y resúmenes", onBack = onBack, backLabel = "Perfil") {
    SettingPanel(
      "Resumen semanal", "Lo que preparaste esta semana, en tu perfil.",
      listOf("no" to "No", "si" to "Sí"), if (settings.weeklySummary) "si" else "no",
      { value -> onChange { copy(weeklySummary = value == "si") } },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Aviso semanal", "Si pasas una semana sin abrir Relevo, te avisa una vez.",
      listOf("nunca" to "No", "semanal" to "Sí"), if (settings.returnNotice) "semanal" else "nunca",
      { value ->
        if (value == "semanal") requestNotificationPermission(context)
        onChange { copy(returnNotice = value == "semanal") }
      },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Mensaje después de responder", "Unas palabras cuando cuentas qué decidiste.",
      listOf("solo" to "No", "con" to "Sí"), if (settings.acknowledgements) "con" else "solo",
      { value -> onChange { copy(acknowledgements = value == "con") } },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Veces por semana", "Cuántas veces por semana quieres hacerlo. Aparece en tu resumen semanal.",
      listOf("no" to "No", "si" to "Sí"), if (settings.constancy > 0) "si" else "no",
      { value -> onChange { copy(constancy = if (value == "si") constancy.coerceAtLeast(3) else 0, constancyPaused = false) } },
    ) {
      if (settings.constancy > 0) {
        Spacer(Modifier.height(8.dp))
        CountStepper(settings.constancy, { value -> onChange { copy(constancy = value) } }, 1..7, "${settings.constancy} ${if (settings.constancy == 1) "vez" else "veces"} por semana")
        PlainAction(if (settings.constancyPaused) "Retomar" else "Pausar", { onChange { copy(constancyPaused = !constancyPaused) } },
          icon = if (settings.constancyPaused) KitIcon.REPRODUCIR else KitIcon.PAUSAR)
      }
    }
    Spacer(Modifier.height(10.dp))
  }
}

/** Apariencia: tema y tamaño del texto, con una vista previa que cambia al instante. */
@Composable
internal fun AppearanceScreen(settings: Settings, onChange: (Settings.() -> Settings) -> Unit, onBack: () -> Unit) {
  RelevoScreen(title = "Apariencia", onBack = onBack, backLabel = "Perfil") {
    Panel {
      Signature("leer", style = Relevo.type.title, animate = false)
      Text("Sonará junto al sillón después de 40 min.", style = Relevo.type.body, color = Relevo.colors.graphite)
    }
    SectionGap()
    SettingPanel(
      "Tema", "Claro, oscuro o como esté tu teléfono.",
      listOf(ThemeMode.SYSTEM.name to "Automático", ThemeMode.LIGHT.name to "Claro", ThemeMode.DARK.name to "Oscuro"), settings.theme.name,
      { value -> onChange { copy(theme = ThemeMode.valueOf(value)) } },
    )
    Spacer(Modifier.height(14.dp))
    SettingPanel(
      "Tamaño del texto", "Se suma al tamaño que usas en el teléfono.",
      listOf("normal" to "Estándar", "grande" to "Grande"), if (settings.largeText) "grande" else "normal",
      { value -> onChange { copy(largeText = value == "grande") } },
    )
  }
}

/** Permisos: qué pide Relevo, para qué y en qué estado está cada uno. */
@Composable
internal fun PermissionsScreen(usageAccess: Boolean, backgroundUnrestricted: Boolean, onUsageSettings: () -> Unit, onBackground: () -> Unit, onBack: () -> Unit) {
  val context = LocalContext.current
  var notifications by remember { mutableStateOf(hasNotificationPermission(context)) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { notifications = hasNotificationPermission(context) }
  RelevoScreen(title = "Permisos", onBack = onBack, backLabel = "Perfil") {
    ListSection(footer = "Tiempo de uso es necesario para contar. Lo demás es opcional.") {
      ListRow("Tiempo de uso", icon = KitIcon.PERMISO, subtitle = "Para contar el tiempo en las apps que elijas.", value = if (usageAccess) "Permitido" else "Falta", chevron = true, onClick = onUsageSettings)
      ListRow("Notificaciones", icon = KitIcon.AVISOS, subtitle = "Para avisarte aunque estés en otra app.", value = if (notifications) "Permitidas" else "Apagadas",
        chevron = !notifications, onClick = if (notifications) null else ({ requestNotificationPermission(context) }))
      ListRow("Batería", icon = KitIcon.BATERIA, subtitle = "Para que Android no detenga a Relevo.", value = if (backgroundUnrestricted) "Sin restricción" else "Con restricción",
        chevron = !backgroundUnrestricted, onClick = if (backgroundUnrestricted) null else onBackground)
    }
  }
}

/** Relevos terminados, por día: hechos, sin metas ni comparaciones. */
@Composable
internal fun HistoryScreen(history: List<HistoryEntry>, customActivities: List<CustomActivity>, onBack: () -> Unit) {
  RelevoScreen(title = "Tus relevos", onBack = onBack, backLabel = "Perfil") {
    if (history.isEmpty()) {
      Text("Aquí verás los relevos que termines.", style = Relevo.type.body, color = Relevo.colors.graphite)
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
            leading = { PictureContent(activityPicture(entry.activity, customActivities), Modifier.size(44.dp).clip(CircleShape), iconSize = 20.dp) },
            leadingWidth = 44.dp,
            trailing = { RelevoIcon(outcomeIcon(entry.outcome), size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card) },
          )
        }
      }
      SectionGap()
    }
  }
}

/**
 * Tus actividades (D-084): lo que la persona hace seguido, guardado con su primer paso y el lugar
 * donde empieza, para prepararlo en un toque. Tocar una abre una hoja con «Preparar un relevo» y
 * «Editar». Se guardan en el teléfono.
 */
@Composable
internal fun ActivitiesScreen(
  customActivities: List<CustomActivity>,
  onOpen: (String) -> Unit,
  onNew: () -> Unit,
  onPrepare: (CustomActivity) -> Unit,
  onBack: () -> Unit,
) {
  var shown by rememberSaveable { mutableStateOf<String?>(null) }
  RelevoScreen(
    title = "Tus actividades",
    subtitle = "Lo que haces seguido, listo para preparar en un toque.",
    onBack = onBack, backLabel = "Perfil",
    bottom = { RelevoButton("Crear una actividad", onNew, icon = KitIcon.AGREGAR) },
  ) {
    if (customActivities.isEmpty()) {
      Panel {
        Box(Modifier.size(48.dp).clip(CircleShape).background(Relevo.colors.mist), contentAlignment = Alignment.Center) {
          RelevoIcon(KitIcon.ACTIVIDAD, size = 24.dp, background = Relevo.colors.mist)
        }
        Text("Todavía no tienes actividades", style = Relevo.type.headline, color = Relevo.colors.ink)
        Text("Anota qué haces, cómo empiezas y dónde. Después la encuentras en Inicio y al preparar un relevo.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
      }
    } else {
      ListSection {
        customActivities.forEach { activity ->
          ListRow(
            activity.name, subtitle = startSentence(activity.firstStep, activity.place),
            leading = { PictureContent(Picture.parse(activity.icon) ?: pictureForActivity(activity.name, emptyList()), Modifier.size(48.dp).clip(CircleShape), iconSize = 22.dp) },
            leadingWidth = 48.dp, chevron = true, onClick = { shown = activity.id },
          )
        }
      }
    }
  }
  val selected = customActivities.firstOrNull { it.id == shown }
  if (selected != null) {
    RelevoSheet(onDismiss = { shown = null }, scrollable = false) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        PictureContent(Picture.parse(selected.icon) ?: pictureForActivity(selected.name, emptyList()), Modifier.size(64.dp).clip(CircleShape), iconSize = 28.dp)
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text(selected.name, style = Relevo.type.title2, color = Relevo.colors.ink)
          startSentence(selected.firstStep, selected.place)?.let { Text(it, style = Relevo.type.subhead, color = Relevo.colors.graphite) }
        }
      }
      Spacer(Modifier.height(22.dp))
      RelevoButton("Preparar un relevo", { shown = null; onPrepare(selected) })
      Spacer(Modifier.height(8.dp))
      RelevoButton("Editar", { shown = null; onOpen(selected.id) }, kind = ButtonKind.Secondary, icon = KitIcon.EDITAR)
    }
  }
}

/** Iconos de actividades del kit (grupo «Actividades», 21). */
private val activityIcons = listOf(
  KitIcon.LEER, KitIcon.ESCRIBIR, KitIcon.DIBUJAR, KitIcon.PINTAR, KitIcon.GUITARRA, KitIcon.MUSICA, KitIcon.CAMINAR,
  KitIcon.BICICLETA, KitIcon.EJERCICIO, KitIcon.ESTIRAR, KitIcon.COCINAR, KitIcon.PLANTAS, KitIcon.DORMIR, KitIcon.LLAMAR,
  KitIcon.CARTA, KitIcon.ORDENAR, KitIcon.ESTUDIAR, KitIcon.FOTOGRAFIA, KitIcon.MANUALIDADES, KitIcon.JUEGO_DE_MESA, KitIcon.SALIR,
)

/**
 * Crear o editar una actividad propia: la imagen arriba (se elige en una hoja; si no, la sugiere el
 * nombre) y tres renglones: la actividad, cómo empieza y dónde.
 */
@Composable
internal fun ActivityEditScreen(initial: CustomActivity?, existing: List<CustomActivity>, onSave: (CustomActivity) -> Unit, onDelete: (String) -> Unit, onBack: () -> Unit) {
  var name by rememberSaveable { mutableStateOf(initial?.name.orEmpty()) }
  var first by rememberSaveable { mutableStateOf(initial?.firstStep.orEmpty()) }
  var place by rememberSaveable { mutableStateOf(initial?.place.orEmpty()) }
  var image by rememberSaveable { mutableStateOf(initial?.icon?.let { Picture.parse(it) }?.let { if (it is Picture.OfPhoto) it.photo.key else (it as Picture.OfIcon).icon.key }.orEmpty()) }
  var confirmDelete by rememberSaveable { mutableStateOf(false) }
  var picking by rememberSaveable { mutableStateOf(false) }
  val duplicate = activityIdeas.any { it.activity.equals(name.trim(), true) } || existing.any { it.id != initial?.id && it.name.equals(name.trim(), true) }
  val valid = name.trim().length in 2..60 && !duplicate && first.isNotBlank() && place.isNotBlank()
  val picture = Picture.parse(image) ?: pictureForActivity(name, emptyList())
  RelevoScreen(
    title = if (initial == null) "Nueva actividad" else "Editar la actividad",
    onBack = onBack, closeIcon = initial == null, backLabel = "Cancelar",
    bottom = {
      RelevoButton("Guardar", {
        onSave(CustomActivity(initial?.id ?: UUID.randomUUID().toString(), name.trim(), first.trim(), place.trim(), image.ifBlank { (picture as? Picture.OfPhoto)?.photo?.key ?: (picture as Picture.OfIcon).icon.key }, 0))
      }, enabled = valid)
    },
  ) {
    val interaction = remember { MutableInteractionSource() }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      PictureContent(
        picture,
        Modifier.size(104.dp).clip(CircleShape).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Cambiar la imagen") { picking = true },
        iconSize = 40.dp,
      )
      Spacer(Modifier.height(8.dp))
      PlainAction("Cambiar la imagen", { picking = true })
    }
    SectionGap()
    RenglonField("Actividad", name, { name = it.take(60) }, placeholder = "Ej.: practicar guitarra")
    if (duplicate) { Spacer(Modifier.height(6.dp)); Text("Ya tienes una actividad con ese nombre.", style = Relevo.type.footnote, color = Relevo.colors.error) }
    Spacer(Modifier.height(20.dp))
    RenglonField("Para empezar", first, { first = it.take(120) }, placeholder = "Ej.: sacar la guitarra del estuche")
    Spacer(Modifier.height(20.dp))
    RenglonField("Dónde empiezas", place, { place = it.take(120) }, placeholder = "Ej.: junto a la guitarra")
    if (initial != null) {
      SectionGap()
      RelevoButton("Borrar la actividad", { confirmDelete = true }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
    }
  }
  if (picking) {
    RelevoSheet(onDismiss = { picking = false }, title = "Elige una imagen", done = "Listo", tall = true) {
      Text("Fotos", style = Relevo.type.section, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, bottom = 12.dp))
      choosablePhotos.chunked(4).forEach { row ->
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
          row.forEach { photo -> PictureTile(Picture.OfPhoto(photo), image == photo.key, { image = photo.key }, Modifier.weight(1f), description = photo.description, cornerRadius = 18.dp) }
          repeat(4 - row.size) { Spacer(Modifier.weight(1f)) }
        }
        Spacer(Modifier.height(10.dp))
      }
      Spacer(Modifier.height(10.dp))
      Text("Iconos", style = Relevo.type.section, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, bottom = 12.dp))
      activityIcons.chunked(6).forEach { row ->
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          row.forEach { icon -> PictureTile(Picture.OfIcon(icon), image == icon.key, { image = icon.key }, Modifier.weight(1f), description = icon.label, aspect = 1f, cornerRadius = 100.dp) }
          repeat(6 - row.size) { Spacer(Modifier.weight(1f)) }
        }
        Spacer(Modifier.height(8.dp))
      }
    }
  }
  if (confirmDelete && initial != null) {
    RelevoSheet(onDismiss = { confirmDelete = false }, scrollable = false) {
      Text("¿Borrar «${initial.name}»?", style = Relevo.type.title2, color = Relevo.colors.ink)
      Spacer(Modifier.height(8.dp))
      Text("Se quita de tus actividades. Los relevos que ya hiciste se mantienen.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Borrar", { confirmDelete = false; onDelete(initial.id) }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
      Spacer(Modifier.height(8.dp))
      RelevoButton("Cancelar", { confirmDelete = false }, kind = ButtonKind.Secondary)
    }
  }
}

/**
 * S3: privacidad breve, código, estado del envío, descarga de los datos y borrado en un paso. En esta
 * versión siempre se participa (D-084): borrar los datos es también dejar la prueba.
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
  onExport: (Uri, (Boolean) -> Unit) -> Unit,
  onDelete: () -> Unit,
  onRestart: () -> Unit,
) {
  val context = LocalContext.current
  var confirming by rememberSaveable { mutableStateOf(false) }
  var copied by remember { mutableStateOf(false) }
  var exportMessage by rememberSaveable { mutableStateOf<String?>(null) }
  val deleted = deletionStatus == RelevoViewModel.DELETED_MESSAGE
  val participating = participation == ParticipationMode.STUDY
  val exporter = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/json")) { uri ->
    if (uri != null) onExport(uri) { ok -> exportMessage = if (ok) "Tus datos quedaron en el archivo que elegiste." else "No se pudo guardar el archivo. Prueba otra vez." }
  }
  RelevoScreen(
    title = "Tus datos", onBack = onBack,
    bottom = if (deleted) ({ RelevoButton("Volver a comenzar", onRestart) }) else null,
  ) {
    Text(
      "Guardamos lo que haces en Relevo con un código, no con tu nombre. No vemos lo que haces dentro de otras apps. Si no borras tus datos antes, los borramos el 30 de diciembre de 2026.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    SectionGap()
    if (!deleted) {
      if (participating) {
        ListSection {
          ListRow("Tu código", icon = KitIcon.CODIGO, value = participantCode.ifBlank { "Sin código" },
            onClick = if (participantCode.isBlank()) null else ({ copy(context, participantCode); copied = true }),
            trailing = { if (participantCode.isNotBlank()) RelevoIcon(if (copied) KitIcon.LISTO else KitIcon.COPIAR, size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card) })
          ListRow("Lo que aceptaste", icon = KitIcon.CONSENTIMIENTO, chevron = true, onClick = onConsent)
          if (remoteConfigured) ListRow("Datos enviados", icon = KitIcon.SINCRONIZAR, subtitle = syncStatusText(syncStatus))
          ListRow("Copia en el teléfono", icon = KitIcon.DATOS, subtitle = backupStatusText(syncStatus))
        }
        SectionGap()
      }
      ListSection(footer = if (remoteConfigured) "Primero se borra en la base del proyecto. Si no se puede, Relevo deja de guardar datos y conserva lo del teléfono para intentarlo otra vez." else null) {
        ListRow("Descargar mis datos", icon = KitIcon.DESCARGAR, subtitle = "Un archivo con todo lo guardado en el teléfono.", chevron = true,
          onClick = { exporter.launch("relevo-mis-datos-${LocalDate.now()}.json") })
        ListRow("Borrar mis datos", icon = KitIcon.BORRAR, subtitle = "También sales del proyecto.", iconTint = Relevo.colors.error, titleColor = Relevo.colors.error, onClick = { confirming = true })
      }
      exportMessage?.let { Spacer(Modifier.height(12.dp)); Text(it, style = Relevo.type.subhead, color = Relevo.colors.ink, modifier = Modifier.padding(horizontal = 4.dp)) }
      if (participating) {
        Spacer(Modifier.height(12.dp))
        Text("¿Dudas, o prefieres pedir el borrado por correo? Escribe a joan1542003@gmail.com con tu código.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
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
      Text("Se borran tus relevos, actividades, perfil, ruta y respuestas, también en la base del proyecto y en la copia de Documentos/Relevo. Sales del proyecto y Relevo deja de contar.", style = Relevo.type.body, color = Relevo.colors.graphite)
      Spacer(Modifier.height(22.dp))
      RelevoButton("Borrar mis datos", { confirming = false; onDelete() }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
      Spacer(Modifier.height(8.dp))
      RelevoButton("Cancelar", { confirming = false }, kind = ButtonKind.Secondary)
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
    title = "¿Cómo te resultó Relevo?",
    onBack = onBack, closeIcon = true, backLabel = "Cerrar",
    bottom = { RelevoButton("Enviar", { onSend(stars, comment) }, enabled = stars != null || comment.isNotBlank(), icon = KitIcon.ENVIAR) },
  ) {
    StarRating(stars) { stars = it }
    SectionGap()
    RenglonArea("Comentario", comment, { comment = it }, "¿Qué cambiarías?")
  }
}

/** Reportar un problema. El registro técnico se adjunta solo si la persona lo marca y no incluye nada de sus apps. */
@Composable
internal fun ReportScreen(onSend: (String, Boolean) -> Unit, onBack: () -> Unit) {
  var text by rememberSaveable { mutableStateOf("") }
  var attach by rememberSaveable { mutableStateOf(true) }
  RelevoScreen(
    title = "Reportar un problema",
    onBack = onBack, closeIcon = true, backLabel = "Cerrar",
    bottom = { RelevoButton("Enviar", { onSend(text, attach) }, enabled = text.isNotBlank(), icon = KitIcon.ENVIAR) },
  ) {
    RenglonArea("¿Qué pasó?", text, { text = it }, "Ej.: no sonó en el parlante")
    SectionGap()
    Row(
      Modifier.fillMaxWidth().heightIn(min = 52.dp).padding(horizontal = 4.dp)
        .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { attach = !attach },
      verticalAlignment = Alignment.CenterVertically,
    ) {
      CheckMark(attach)
      Spacer(Modifier.width(12.dp))
      Column {
        Text("Adjuntar datos técnicos", style = Relevo.type.body, color = Relevo.colors.ink)
        Text("Versión, permisos y estado del envío. Nada de lo que haces en tus apps.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
      }
    }
  }
}

