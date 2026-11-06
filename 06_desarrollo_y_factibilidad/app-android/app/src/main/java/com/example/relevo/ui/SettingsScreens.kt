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
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import com.example.relevo.ui.components.OptionRow
import com.example.relevo.signal.Sonido
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.relevo.ui.components.StarGlyphInset
import androidx.compose.foundation.layout.offset
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
import com.example.relevo.domain.Reminder
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.CountStepper
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonArea
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SegmentedControl
import com.example.relevo.ui.components.StarRating
import com.example.relevo.ui.components.Tone
import com.example.relevo.ui.components.formatDuration
import com.example.relevo.ui.components.key
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import java.util.UUID
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.RowShape
import com.example.relevo.ui.components.ToggleRow
import com.example.relevo.ui.components.pictureIcon

/** Una opción de ajuste: qué es, en una línea, y sus valores en un control segmentado. */
@Composable
private fun SettingPanel(title: String, detail: String, options: List<Pair<String, String>>, selected: String, onSelect: (String) -> Unit, extra: (@Composable () -> Unit)? = null) {
  Panel(Modifier.clip(RowShape)) {
    Text(title, style = Relevo.type.headline, color = Relevo.colors.ink)
    Text(detail, style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(4.dp))
    SegmentedControl(options, selected, { it?.let(onSelect) }, allowDeselect = false)
    extra?.invoke()
  }
}

/**
 * Ajustes (4.0, D-155): se abren con la tuerca de Perfil y ya no desde Inicio. Reúnen lo que se configura
 * una vez —avisos, apariencia, permisos y datos— para que Inicio quede para el día a día.
 */
@Composable
internal fun SettingsScreen(
  settings: Settings,
  usageAccess: Boolean,
  onNotices: () -> Unit,
  onAppearance: () -> Unit,
  onPermissions: () -> Unit,
  onPrivacy: () -> Unit,
  onBack: () -> Unit,
  onSound: (Sonido) -> Unit = {},
) {
  val theme = when (settings.theme) { ThemeMode.LIGHT -> "Claro"; ThemeMode.DARK -> "Oscuro"; ThemeMode.SYSTEM -> "Automático" }
  val sound = Sonido.from(settings.sound)
  var choosingSound by rememberSaveable { mutableStateOf(false) }
  RelevoScreen(title = "Ajustes", onBack = onBack, backLabel = "Perfil") {
    ListSection {
      ListRow("Sonido", icon = KitIcon.SUENA, subtitle = sound.label, chevron = true, onClick = { choosingSound = true })
      ListRow("Avisos", icon = KitIcon.AVISOS, subtitle = if (settings.returnNotice) "Aviso semanal encendido" else "Aviso semanal apagado", chevron = true, onClick = onNotices)
      ListRow("Apariencia", icon = KitIcon.TEMA, subtitle = theme + if (settings.largeText) " · letra grande" else "", chevron = true, onClick = onAppearance)
      ListRow("Permisos", icon = KitIcon.PERMISO, subtitle = if (usageAccess) "Todo listo para contar" else "Falta Tiempo de uso", chevron = true, onClick = onPermissions)
      ListRow("Datos", icon = KitIcon.PRIVACIDAD, subtitle = "Privacidad, código y borrado", chevron = true, onClick = onPrivacy)
    }
  }
  if (choosingSound) SoundSheet(sound, onSound, onDismiss = { choosingSound = false })
}

/**
 * Elegir el sonido de la señal (4.3, D-158): cuatro, con su razón en una línea. Al elegir uno suena una vez,
 * como al elegir un tono en el teléfono. Los fundamentos están en `sonido-de-relevo-2026-11-05.md`.
 */
@Composable
private fun SoundSheet(current: Sonido, onSound: (Sonido) -> Unit, onDismiss: () -> Unit) {
  RelevoSheet(onDismiss = onDismiss, title = "Sonido", done = "Listo") {
    Column(verticalArrangement = Arrangement.spacedBy(Gap.list)) {
      Sonido.entries.forEach { option ->
        // Sin ícono: los cuatro llevarían el mismo, que no distingue nada.
        OptionRow(option.label, option == current, { onSound(option) }, subtitle = option.description)
      }
    }
    Spacer(Modifier.height(12.dp))
    Text("En el Tag suena siempre su propio pitido.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    Spacer(Modifier.height(12.dp))
  }
}

/** Avisos: todo lo opcional empieza apagado y se apaga con un toque. */
@Composable
internal fun NoticesScreen(
  settings: Settings,
  onChange: (Settings.() -> Settings) -> Unit,
  onBack: () -> Unit,
  autoMode: Boolean = false,
  lastReminder: Reminder? = null,
  onAutoMode: (Boolean) -> Boolean = { false },
) {
  val context = LocalContext.current
  var autoUnavailable by remember { mutableStateOf(false) }
  RelevoScreen(title = "Avisos", onBack = onBack, backLabel = "Ajustes") {
    // D-095: repite el último relevo cada vez que se abre una de sus apps.
    ListSection(
      footer = buildList {
        if (autoMode && lastReminder != null) add("${lastReminder.activity} · ${lastReminder.selectedApps.joinToString(", ") { it.label }} · ${formatDuration(lastReminder.requiredUsageSeconds)}.")
        if (autoUnavailable && !autoMode) add("Primero prepara y termina un relevo: la activación automática repite ese.")
        add("Mientras está encendida, Relevo mira qué app tienes abierta, solo su nombre. Después de cada relevo espera 30 minutos.")
      }.joinToString(" "),
    ) {
      ToggleRow("Activación automática", autoMode, { on -> autoUnavailable = !onAutoMode(on) }, icon = KitIcon.ESPERANDO,
        subtitle = "Al abrir las apps del último relevo, empieza a contar solo.")
    }
    SectionGap()
    ListSection {
      ToggleRow("Resumen semanal", settings.weeklySummary, { on -> onChange { copy(weeklySummary = on) } }, icon = KitIcon.AVANCE,
        subtitle = "«Esta semana», en Inicio.")
      ToggleRow("Aviso semanal", settings.returnNotice, { on ->
        if (on) requestNotificationPermission(context)
        onChange { copy(returnNotice = on) }
      }, icon = KitIcon.AVISOS, subtitle = "Si pasas una semana sin abrir Relevo, te avisa una vez.")
      ToggleRow("Mensaje al responder", settings.acknowledgements, { on -> onChange { copy(acknowledgements = on) } }, icon = KitIcon.COMENTARIO,
        subtitle = "Unas palabras después de decir qué decidiste.")
      ToggleRow("Veces por semana", settings.constancy > 0, { on -> onChange { copy(constancy = if (on) constancy.coerceAtLeast(3) else 0, constancyPaused = false) } },
        icon = KitIcon.CALENDARIO, subtitle = "Cuántas veces quieres hacerlo. Aparece en «Esta semana».")
    }
    if (settings.constancy > 0) {
      Spacer(Modifier.height(Gap.list))
      Panel {
        CountStepper(settings.constancy, { value -> onChange { copy(constancy = value) } }, 1..7, "${settings.constancy} ${if (settings.constancy == 1) "vez" else "veces"} por semana")
        PlainAction(if (settings.constancyPaused) "Retomar" else "Pausar", { onChange { copy(constancyPaused = !constancyPaused) } },
          icon = if (settings.constancyPaused) KitIcon.REPRODUCIR else KitIcon.PAUSAR)
      }
    }
  }
}

/** Apariencia (4.0): el tema y el tamaño de la letra. El aura se retiró (D-155). */
@Composable
internal fun AppearanceScreen(settings: Settings, onChange: (Settings.() -> Settings) -> Unit, onBack: () -> Unit) {
  RelevoScreen(title = "Apariencia", onBack = onBack, backLabel = "Ajustes") {
    SettingPanel(
      "Tema", "Claro, oscuro o como esté el teléfono.",
      listOf(ThemeMode.LIGHT.name to "Claro", ThemeMode.DARK.name to "Oscuro", ThemeMode.SYSTEM.name to "Automático"), settings.theme.name,
      { value -> onChange { copy(theme = ThemeMode.valueOf(value)) } },
    )
    Spacer(Modifier.height(Gap.block))
    ListSection(footer = "Se suma al tamaño que usas en el teléfono.", dividerInset = 16.dp) {
      ToggleRow("Letra grande", settings.largeText, { on -> onChange { copy(largeText = on) } })
    }
  }
}

/** Permisos: qué pide Relevo, para qué y en qué estado está cada uno. */
@Composable
internal fun PermissionsScreen(usageAccess: Boolean, backgroundUnrestricted: Boolean, onUsageSettings: () -> Unit, onBackground: () -> Unit, onBack: () -> Unit) {
  val context = LocalContext.current
  var notifications by remember { mutableStateOf(hasNotificationPermission(context)) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { notifications = hasNotificationPermission(context) }
  RelevoScreen(title = "Permisos", onBack = onBack, backLabel = "Ajustes") {
    ListSection(footer = "Tiempo de uso es necesario para contar. En Android se llama «Acceso a datos de uso». Lo demás es opcional.") {
      ListRow("Tiempo de uso", icon = KitIcon.PERMISO, subtitle = "Para contar el tiempo en las apps que elijas", value = if (usageAccess) "Permitido" else "Falta", chevron = true, onClick = onUsageSettings)
      ListRow("Notificaciones", icon = KitIcon.AVISOS, subtitle = "Para avisarte aunque estés en otra app", value = if (notifications) "Permitidas" else "Apagadas",
        chevron = !notifications, onClick = if (notifications) null else ({ requestNotificationPermission(context) }))
      ListRow("Batería", icon = KitIcon.BATERIA, subtitle = "Para que Android no detenga a Relevo", value = if (backgroundUnrestricted) "Sin restricciones" else "Con restricciones",
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
      ListSection(title = label, dividerInset = 68.dp) {
        entries.forEach { entry ->
          ListRow(
            entry.activity,
            subtitle = listOfNotNull(entry.appLabel.takeIf { it.isNotBlank() }, formatDuration(entry.seconds), outcomeLabel(entry.outcome) ?: if (entry.signalDelivered) "Sonó" else "Terminó antes de sonar").joinToString(" · "),
            leading = { ActivityRing(activityIcon(entry.activity, customActivities), 40.dp) },
            trailing = { RelevoIcon(outcomeIcon(entry.outcome), size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card) },
          )
        }
      }
      SectionGap()
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
    title = "Tus datos", onBack = onBack, backLabel = "Ajustes",
    bottom = if (deleted) ({ RelevoButton("Volver a comenzar", onRestart) }) else null,
  ) {
    Text(
      "Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte, solo con ese código. No vemos lo que haces dentro de otras apps. Si no borras tus datos antes, los borramos el 30 de diciembre de 2026.",
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
  // 4.2 (D-157): el comentario va primero, porque es lo que la persona vino a hacer; las estrellas son opcionales.
  RelevoScreen(
    title = "Envíanos un comentario",
    onBack = onBack, closeIcon = true, backLabel = "Cerrar",
    bottom = { GuardedButton("Enviar", { onSend(stars, comment) }, missing = if (stars == null && comment.isBlank()) "Escribe un comentario o elige las estrellas." else null, icon = KitIcon.ENVIAR) },
  ) {
    RenglonArea("Comentario", comment, { comment = it }, "Ej.: me gustaría elegir otro sonido")
    SectionGap()
    Text("¿Cómo te resultó Relevo?", style = Relevo.type.headline, color = Relevo.colors.ink)
    Spacer(Modifier.height(8.dp))
    StarRating(stars, { stars = it }, Modifier.offset(x = -StarGlyphInset))
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
    bottom = { GuardedButton("Enviar", { onSend(text, attach) }, missing = if (text.isBlank()) "Escribe qué pasó." else null, icon = KitIcon.ENVIAR) },
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

