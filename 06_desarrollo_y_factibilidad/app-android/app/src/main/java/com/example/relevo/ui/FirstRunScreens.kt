package com.example.relevo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.StatusChip
import com.example.relevo.ui.components.Wordmark

/** A1. La firma y los tres pasos, con los iconos del kit. No pide datos. */
@Composable
internal fun WelcomeScreen(onStart: () -> Unit) {
  RelevoScreen(
    leading = { Wordmark(height = 24.dp) },
    bottom = { RelevoButton("Empezar", onStart) },
  ) {
    Spacer(Modifier.heightIn(min = 36.dp))
    Text("Vuelve a lo que querías hacer.", style = Relevo.type.largeTitle.copy(fontSize = Relevo.type.signature.fontSize, lineHeight = Relevo.type.signature.lineHeight), color = Relevo.colors.ink)
    Spacer(Modifier.heightIn(min = 16.dp))
    Text("Anota algo que quieres hacer. Relevo te lo recuerda mientras todavía puedes hacerlo.", style = Relevo.type.body, color = Relevo.colors.graphite)
    SectionGap()
    listOf(
      KitIcon.ACTIVIDAD to "Escribes qué quieres hacer y cómo empieza.",
      KitIcon.LUGAR to "Dejas el parlante donde empieza.",
      KitIcon.PROBAR to "Suena ahí después del tiempo que elijas en el teléfono.",
      KitIcon.DECISION to "Tú decides qué hacer después.",
    ).forEach { (icon, text) ->
      Row(Modifier.fillMaxWidth().padding(vertical = 10.dp), verticalAlignment = Alignment.Top) {
        RelevoIcon(icon, size = 28.dp)
        Spacer(Modifier.width(16.dp))
        Text(text, style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
      }
    }
  }
}

/** A2. Versión breve arriba y, a pedido, el detalle de la hoja de consentimiento de 21 días. */
@Composable
internal fun ConsentScreen(
  remoteConfigured: Boolean,
  deletionPending: Boolean,
  onAccept: () -> Unit,
  onDecline: () -> Unit,
  onPrivacy: () -> Unit,
) {
  var checked by rememberSaveable { mutableStateOf(false) }
  var details by rememberSaveable { mutableStateOf(false) }
  RelevoScreen(
    title = "Participar en la prueba",
    bottom = {
      Row(
        Modifier.fillMaxWidth().heightIn(min = 52.dp)
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { checked = !checked },
        verticalAlignment = Alignment.CenterVertically,
      ) {
        CheckMark(checked)
        Spacer(Modifier.width(12.dp))
        Text("He leído y acepto participar durante 21 días.", style = Relevo.type.subhead, color = Relevo.colors.ink)
      }
      RelevoButton("Aceptar y seguir", onAccept, enabled = checked && !deletionPending)
      PlainAction("No participar", onDecline, color = Relevo.colors.graphite)
    },
  ) {
    Text(
      "Durante 21 días usarás Relevo y responderás preguntas breves. Guardamos lo que preparas y lo que respondes, con un código en vez de tu nombre. Puedes pedir que borremos todo cuando quieras.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.heightIn(min = 12.dp))
    PlainAction(if (details) "Ocultar los detalles" else "Leer los detalles", { details = !details }, icon = if (details) KitIcon.CONTRAER else KitIcon.EXPANDIR)
    AnimatedVisibility(details, enter = expandVertically(Motion.standard()) + fadeIn(Motion.standard()), exit = shrinkVertically(Motion.standard()) + fadeOut(Motion.standard(Motion.SHORT))) {
      Column { ConsentSections(remoteConfigured) }
    }
    if (deletionPending) {
      SectionGap()
      Notice("Hay una solicitud de eliminación pendiente. El registro sigue detenido.", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Abrir Privacidad y datos", onPrivacy)
      }
    }
  }
}

/** Detalle de la hoja de consentimiento de 21 días (07_validacion/consentimiento-android-vigente). */
@Composable
internal fun ConsentSections(remoteConfigured: Boolean) {
  Column(Modifier.padding(top = 8.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    ConsentPart("En qué consiste", "La prueba empieza con una sesión de unos 45 minutos con el investigador. Cada semana la app te pedirá dejar el parlante en un lugar distinto o usar el teléfono como aviso. Al cumplirse el límite que configures, sonará una señal de unos 30 segundos que se detiene sola. Tras cada señal y al final de cada semana habrá preguntas de un toque que puedes omitir. Al terminar, se te invitará a una conversación de unos 15 minutos. El parlante es material de prueba; no es el objeto final.")
    ConsentPart("Tu decisión", "Participar es voluntario. Puedes omitir preguntas, silenciar el aviso, retirar el permiso de Android o terminar la prueba sin explicar por qué. La actividad que elijas no será juzgada. El sonido puede molestar a otras personas; puedes detenerlo y comunicarlo.")
    ConsentPart("Qué se guarda", "Un código aleatorio, la actividad, cómo quieres empezar, el lugar que indicas, las apps elegidas, el tiempo configurado y acumulado, los momentos de activación, aviso y respuesta, si silenciaste la señal, el uso de las apps elegidas en los 10 minutos anteriores y posteriores a la señal, y las respuestas que decidas dar.")
    ConsentPart("Dónde se guarda", if (remoteConfigured) "En el teléfono, y la app intenta enviarlo a Supabase, la base de datos del estudio. Si no hay conexión, queda pendiente en el teléfono."
      else "Esta instalación no tiene configurada la base remota: todo queda en este teléfono.")
    ConsentPart("Qué no se consulta", "El permiso de Tiempo de uso podría permitir ver el uso de otras apps; Relevo cuenta solo las que eliges, mientras el relevo está activo. No lee mensajes, fotos, búsquedas ni lo que hay en la pantalla.")
    ConsentPart("Cómo se identifica", "El código reemplaza tu nombre, pero no vuelve anónimos los datos: la combinación de actividades, lugares y horarios podría identificarte.")
    ConsentPart("Plazo y contacto", "Puedes pedir la eliminación desde Privacidad y datos o escribiendo a joan1542003@gmail.com con tu código. Si no la pides antes, los registros se eliminan, como máximo, el 30 de diciembre de 2026.")
  }
}

@Composable
private fun ConsentPart(title: String, text: String) {
  Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
    Text(title, style = Relevo.type.headline, color = Relevo.colors.ink)
    Text(text, style = Relevo.type.subhead, color = Relevo.colors.graphite)
  }
}

/** Consentimiento completo, de solo lectura, desde Privacidad y datos. */
@Composable
internal fun ConsentDetailsScreen(remoteConfigured: Boolean, onBack: () -> Unit) {
  RelevoScreen(title = "Consentimiento", onBack = onBack) {
    Text("Aceptaste participar en la prueba de 21 días con este texto.", style = Relevo.type.body, color = Relevo.colors.graphite)
    ConsentSections(remoteConfigured)
  }
}

/**
 * A3. El permiso de Tiempo de uso es necesario para avanzar; al volver con el permiso activo, la
 * app sigue sola. Las notificaciones son opcionales.
 */
@Composable
internal fun PermissionScreen(
  usageAccess: Boolean,
  onOpenUsageSettings: () -> Unit,
  onRefresh: () -> Unit,
  onContinue: (configureFirst: Boolean) -> Unit,
) {
  val context = LocalContext.current
  var notifications by remember { mutableStateOf(hasNotificationPermission(context)) }
  var waitingForSettings by remember { mutableStateOf(false) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
    onRefresh()
    notifications = hasNotificationPermission(context)
  }
  LaunchedEffect(usageAccess) { if (usageAccess && waitingForSettings) onContinue(true) }
  RelevoScreen(
    title = "Para saber cuándo sonar",
    bottom = {
      if (usageAccess) {
        RelevoButton("Preparar mi primer relevo", { onContinue(true) })
        PlainAction("Ir al inicio", { onContinue(false) }, color = Relevo.colors.graphite)
      } else {
        RelevoButton("Abrir ajustes de Android", { waitingForSettings = true; onOpenUsageSettings() })
      }
    },
  ) {
    Text("Relevo necesita ver cuánto tiempo pasas en las apps que elijas. No ve lo que haces en ellas.", style = Relevo.type.body, color = Relevo.colors.ink)
    SectionGap()
    ListSection(title = "Permisos") {
      ListRow(
        "Tiempo de uso", icon = KitIcon.PERMISO, subtitle = "Necesario para contar el tiempo.",
        onClick = if (usageAccess) null else ({ waitingForSettings = true; onOpenUsageSettings() }),
        trailing = { StatusChip(if (usageAccess) KitIcon.LISTO else KitIcon.ADVERTENCIA, if (usageAccess) "Permitido" else "Falta") },
      )
      ListRow(
        "Notificaciones", icon = KitIcon.AVISOS, subtitle = "Opcional. Muestran el aviso con otra app abierta.",
        onClick = if (notifications) null else ({ requestNotificationPermission(context) }),
        trailing = { StatusChip(if (notifications) KitIcon.LISTO else KitIcon.AGREGAR, if (notifications) "Permitidas" else "Activar") },
      )
    }
  }
}
