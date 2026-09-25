package com.example.relevo.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import cl.udp.relevo.BuildConfig
import com.example.relevo.data.CustomActivity
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.SyncStatus
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.formatDuration

internal class SettingsActions(
  val onBack: () -> Unit,
  val onHistory: () -> Unit,
  val onActivities: () -> Unit,
  val onStudy: () -> Unit,
  val onPrivacy: () -> Unit,
  val onUsageSettings: () -> Unit,
  val onBackground: () -> Unit,
)

/** Ajustes: filas con icono, texto y destino, en secciones. */
@Composable
internal fun SettingsScreen(
  study: StudyState,
  historyCount: Int,
  customCount: Int,
  usageAccess: Boolean,
  backgroundUnrestricted: Boolean,
  actions: SettingsActions,
) {
  val context = LocalContext.current
  var notifications by remember { mutableStateOf(hasNotificationPermission(context)) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { notifications = hasNotificationPermission(context) }
  RelevoScreen(title = "Ajustes", onBack = actions.onBack) {
    ListSection(title = "Relevos") {
      ListRow("Tus relevos", icon = KitIcon.RELEVOS, value = if (historyCount > 0) historyCount.toString() else null, chevron = true, onClick = actions.onHistory)
      ListRow("Tus actividades", icon = KitIcon.ACTIVIDAD, value = if (customCount > 0) customCount.toString() else null, chevron = true, onClick = actions.onActivities)
    }
    SectionGap()
    ListSection(title = "Prueba") {
      ListRow(
        "Prueba de 21 días", icon = KitIcon.VALIDACION, chevron = true, onClick = actions.onStudy,
        value = when {
          study.plan == null -> "Sin configurar"
          study.finished -> "Terminada"
          study.day == 0 -> "Día 0"
          else -> "Día ${study.day} de 21"
        },
      )
    }
    SectionGap()
    ListSection(title = "Permisos", footer = "Tiempo de uso es necesario para contar. Las notificaciones y el funcionamiento sin restricción de batería son opcionales.") {
      ListRow("Tiempo de uso", icon = KitIcon.PERMISO, value = if (usageAccess) "Permitido" else "Falta", onClick = actions.onUsageSettings, chevron = true)
      ListRow("Notificaciones", icon = KitIcon.AVISOS, value = if (notifications) "Permitidas" else "Desactivadas", onClick = if (notifications) null else ({ requestNotificationPermission(context) }))
      ListRow("Segundo plano", icon = KitIcon.BATERIA, value = if (backgroundUnrestricted) "Sin restricción" else "Con restricción", onClick = if (backgroundUnrestricted) null else actions.onBackground)
    }
    SectionGap()
    ListSection(title = "Datos", footer = "Relevo ${BuildConfig.VERSION_NAME} · Proyecto de Título de Diseño, Universidad Diego Portales.") {
      ListRow("Privacidad y datos", icon = KitIcon.PRIVACIDAD, chevron = true, onClick = actions.onPrivacy)
    }
  }
}

/** Relevos terminados: hechos, sin metas ni comparaciones. */
@Composable
internal fun HistoryScreen(history: List<HistoryEntry>, customActivities: List<CustomActivity>, onBack: () -> Unit) {
  RelevoScreen(title = "Tus relevos", onBack = onBack) {
    if (history.isEmpty()) {
      Text("Los relevos que termines aparecerán aquí.", style = Relevo.type.body, color = Relevo.colors.graphite)
    } else {
      ListSection {
        history.forEach { entry ->
          ListRow(
            entry.activity,
            icon = iconForActivity(entry.activity, customActivities),
            subtitle = listOfNotNull(formatMoment(entry.completedAt), entry.appLabel.takeIf { it.isNotBlank() }, formatDuration(entry.seconds), outcomeLabel(entry.outcome)).joinToString(" · "),
          )
        }
      }
    }
  }
}

/** Actividades propias guardadas en el teléfono. No se envían a la base. */
@Composable
internal fun ActivitiesScreen(customActivities: List<CustomActivity>, onDelete: (String) -> Unit, onBack: () -> Unit) {
  RelevoScreen(title = "Tus actividades", subtitle = "Se guardan solo en este teléfono.", onBack = onBack) {
    if (customActivities.isEmpty()) {
      Text("Al revisar un relevo puedes guardar su actividad para la próxima vez.", style = Relevo.type.body, color = Relevo.colors.graphite)
    } else {
      ListSection {
        customActivities.forEach { activity ->
          ListRow(activity.name, icon = customIconOf(activity.icon), subtitle = activity.firstStep.takeIf { it.isNotBlank() }, trailing = {
            Box(
              Modifier.size(48.dp).clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Button) { onDelete(activity.id) }
                .semantics { contentDescription = "Borrar ${activity.name}" },
              contentAlignment = Alignment.Center,
            ) { RelevoIcon(KitIcon.BORRAR, tint = Relevo.colors.graphite) }
          })
        }
      }
    }
  }
}

/** S3: privacidad breve (60 palabras), código, estado del envío y borrado en un paso. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PrivacyScreen(
  participantCode: String,
  consentAccepted: Boolean,
  remoteConfigured: Boolean,
  syncStatus: SyncStatus,
  deletionStatus: String?,
  onBack: () -> Unit,
  onConsent: () -> Unit,
  onDelete: () -> Unit,
  onRestart: () -> Unit,
) {
  val context = LocalContext.current
  var confirming by rememberSaveable { mutableStateOf(false) }
  var copied by remember { mutableStateOf(false) }
  val deleted = deletionStatus?.startsWith("Datos eliminados") == true
  RelevoScreen(
    title = "Privacidad y datos", onBack = onBack,
    bottom = if (deleted) ({ RelevoButton("Volver a comenzar", onRestart) }) else null,
  ) {
    Text(
      "Guardamos lo que preparas, cuándo suena el aviso y lo que respondes, con un código en vez de tu nombre. No leemos lo que haces dentro de otras apps. Puedes borrar tus datos cuando quieras. Si no los borras antes, los eliminamos el 30 de diciembre de 2026.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    SectionGap()
    if (!deleted) {
      ListSection {
        ListRow("Código de participación", icon = KitIcon.CODIGO, value = participantCode.ifBlank { "Sin código" }, onClick = if (participantCode.isBlank()) null else ({ copy(context, participantCode); copied = true }),
          trailing = { if (participantCode.isNotBlank()) RelevoIcon(if (copied) KitIcon.LISTO else KitIcon.COPIAR, size = 20.dp, tint = Relevo.colors.graphite) })
        if (consentAccepted) ListRow("Consentimiento", icon = KitIcon.CONSENTIMIENTO, value = "Aceptado", chevron = true, onClick = onConsent)
        if (remoteConfigured) ListRow("Envío de datos", icon = KitIcon.SINCRONIZAR, subtitle = syncStatusText(syncStatus))
      }
      SectionGap()
      ListSection(footer = if (remoteConfigured) "Primero se confirma el borrado en la base del estudio. Si falla, el registro se detiene y lo del teléfono se guarda para reintentar." else null) {
        ListRow("Borrar mis datos", icon = KitIcon.BORRAR, titleColor = Relevo.colors.error, onClick = { confirming = true })
      }
      Spacer(Modifier.height(12.dp))
      Text("Para consultar o pedir el borrado por correo: joan1542003@gmail.com, con tu código.", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
    if (deletionStatus != null) {
      SectionGap()
      Text(deletionStatus, style = Relevo.type.body, color = if (deleted) Relevo.colors.ink else Relevo.colors.graphite)
    }
  }
  if (confirming) {
    ModalBottomSheet(
      onDismissRequest = { confirming = false },
      sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
      containerColor = Relevo.colors.paper,
      shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
      dragHandle = { Box(Modifier.padding(top = 10.dp, bottom = 6.dp).width(36.dp).height(5.dp).background(Relevo.colors.line, RoundedCornerShape(3.dp))) },
    ) {
      Column(Modifier.fillMaxWidth().padding(horizontal = Relevo.margin).padding(bottom = 12.dp).navigationBarsPadding()) {
        Text("¿Borrar tus datos?", style = Relevo.type.title2, color = Relevo.colors.ink)
        Spacer(Modifier.height(8.dp))
        Text("Se borran tus relevos, actividades guardadas, respuestas y registros del estudio. El conteo se detiene.", style = Relevo.type.body, color = Relevo.colors.graphite)
        Spacer(Modifier.height(20.dp))
        RelevoButton("Borrar mis datos", { confirming = false; onDelete() }, kind = ButtonKind.Destructive, icon = KitIcon.BORRAR)
        Spacer(Modifier.height(4.dp))
        PlainAction("Cancelar", { confirming = false }, modifier = Modifier.align(Alignment.CenterHorizontally))
      }
    }
  }
}

private fun copy(context: Context, text: String) {
  context.getSystemService(ClipboardManager::class.java)?.setPrimaryClip(ClipData.newPlainText("Código de participación", text))
}
