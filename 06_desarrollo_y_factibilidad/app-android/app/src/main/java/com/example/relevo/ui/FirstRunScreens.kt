package com.example.relevo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.PhotoImage
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.Signature
import com.example.relevo.ui.components.StatusChip
import com.example.relevo.ui.components.Wordmark
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.rememberReduceMotion

/**
 * A1. La foto del comienzo (zapatillas y el parlante junto a la puerta) llega al borde superior y se
 * acerca despacio; la firma se escribe sola. No pide datos ni explica de más.
 */
@Composable
internal fun WelcomeScreen(onStart: () -> Unit) {
  val reduce = rememberReduceMotion()
  val zoom = remember { Animatable(if (reduce) 1f else 1.08f) }
  LaunchedEffect(Unit) { zoom.animateTo(1f, tween(1600, easing = Motion.Easing)) }
  RelevoScreen(
    hero = {
      PhotoImage(Photo.PUERTA, Modifier.fillMaxSize().graphicsLayer { scaleX = zoom.value; scaleY = zoom.value }, describe = true)
    },
    heroHeight = 400.dp,
    heroPicture = Picture.OfPhoto(Photo.PUERTA),
    heroWide = false,
    bottom = { RelevoButton("Empezar", onStart) },
  ) {
    Spacer(Modifier.height(26.dp))
    Wordmark(height = 22.dp, modifier = Modifier.appear(0))
    Spacer(Modifier.height(22.dp))
    Signature("lo que querías hacer", phraseColor = Relevo.colors.ink)
    Spacer(Modifier.height(14.dp))
    Text("Anota algo que quieres hacer. Relevo te lo recuerda mientras todavía puedes hacerlo.",
      style = Relevo.type.body, color = Relevo.colors.graphite, modifier = Modifier.appear(2))
  }
}

/**
 * A2. En esta versión, Relevo es parte de la prueba (D-084): para usarlo hay que aceptar participar.
 * Arriba va la versión breve y, a pedido, el detalle de la hoja de consentimiento de 21 días. Aceptar
 * sigue siendo voluntario; quien no quiere participar no sigue, y quien participa puede dejar la
 * prueba y borrar sus datos cuando quiera.
 */
@Composable
internal fun ConsentScreen(
  remoteConfigured: Boolean,
  deletionPending: Boolean,
  onAccept: () -> Unit,
  onPrivacy: () -> Unit,
) {
  var checked by rememberSaveable { mutableStateOf(false) }
  var details by rememberSaveable { mutableStateOf(false) }
  RelevoScreen(
    title = "Antes de empezar",
    bottom = {
      Row(
        Modifier.fillMaxWidth().heightIn(min = 48.dp)
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { checked = !checked },
        verticalAlignment = Alignment.CenterVertically,
      ) {
        CheckMark(checked)
        Spacer(Modifier.width(12.dp))
        Text("Acepto participar durante 21 días.", style = Relevo.type.subhead, color = Relevo.colors.ink)
      }
      GuardedButton("Aceptar y empezar", onAccept, missing = when {
        deletionPending -> "Espera a que terminemos de borrar tus datos."
        !checked -> "Marca «Acepto participar durante 21 días» para seguir."
        else -> null
      })
    },
  ) {
    Text(
      "Relevo es parte de un proyecto de título de Diseño. Por 21 días lo usas como quieras y, de vez en cuando, te hacemos preguntas cortas. Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte. Puedes salir y borrar tus datos cuando quieras.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.height(12.dp))
    PlainAction(if (details) "Ocultar" else "Leer más", { details = !details }, icon = if (details) KitIcon.CONTRAER else KitIcon.EXPANDIR)
    AnimatedVisibility(details, enter = expandVertically(Motion.smooth()) + fadeIn(Motion.standard()), exit = shrinkVertically(Motion.smooth()) + fadeOut(Motion.standard(Motion.SHORT))) {
      Column { ConsentSections(remoteConfigured) }
    }
    if (deletionPending) {
      SectionGap()
      Notice("Todavía estamos borrando tus datos. Mientras tanto, Relevo no guarda nada.", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Abrir Privacidad y datos", onPrivacy)
      }
    }
  }
}

/** Detalle de la hoja de consentimiento de 21 días (07_validacion/consentimiento-android-vigente). */
@Composable
internal fun ConsentSections(remoteConfigured: Boolean) {
  Column(Modifier.padding(top = 8.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    ConsentPart("Cómo es", "Empieza con un encuentro de unos 45 minutos para dejar todo listo. Cada vez eliges dónde suena: un parlante, un reloj, un llavero o el teléfono, y dónde lo dejas. Cuando se cumple el tiempo que elegiste, suena unos 30 segundos y se apaga. Después de cada aviso y al final de cada semana hay preguntas de un toque; puedes saltarlas. Al final te invitamos a conversar unos 15 minutos. El parlante es provisorio; no es el objeto final.")
    ConsentPart("Tú decides", "Participar es voluntario. Puedes saltar preguntas, silenciar el aviso, quitar los permisos o salir cuando quieras, sin dar explicaciones. Nadie va a juzgar lo que elijas hacer. El sonido puede molestar a otras personas; puedes detenerlo y contárnoslo.")
    ConsentPart("Qué guardamos", "Un código al azar; lo que preparas (actividad, cómo empiezas, dónde, apps y tiempo); cuándo lo activas, a mano o solo, cuándo suena y qué respondes; cuánto usaste las apps elegidas 10 minutos antes y después del aviso; cuánto usas cada día las apps que elegiste en Relevo y cuánto tiempo usas el teléfono en total, desde 7 días antes de aceptar; el modelo del teléfono y los permisos que diste; y cómo usas Relevo: cuándo lo abres y por cuánto tiempo, qué pantallas ves, cuánto del video ves, tus intereses, tus actividades y los ajustes que cambias. Tu nombre se guarda aparte, solo con tu código, para saber quién participa; no va junto a lo que haces en Relevo.")
    ConsentPart("Dónde se guarda", if (remoteConfigured) "En el teléfono y en la base de datos del proyecto (Supabase). Si no hay internet, se envía después. También queda una copia sin tu nombre en la carpeta Documentos/Relevo del teléfono; se borra si borras tus datos."
      else "Esta instalación no tiene configurada la base remota: todo queda en este teléfono.")
    ConsentPart("Qué no vemos", "El permiso de Tiempo de uso podría mostrar el uso de otras apps. Relevo cuenta las que eliges mientras el relevo está activo y, cada día, cuánto las usas y el tiempo total del teléfono; de las demás apps no guarda el nombre. Si enciendes la activación automática, además mira qué app tienes abierta —solo su nombre— para saber cuándo empezar; puedes apagarla cuando quieras. No lee mensajes, fotos, búsquedas ni lo que hay en tu pantalla.")
    ConsentPart("Mensajes", "El investigador puede enviarte mensajes sobre el testeo; llegan como notificación de Relevo. Guardamos cuándo llegó y cuándo abriste cada uno.")
    ConsentPart("Tu código", "El código reemplaza tu nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte.")
    ConsentPart("Hasta cuándo", "Puedes borrar tus datos desde Perfil, en Tus datos, o escribiendo a joan1542003@gmail.com con tu código. Si no lo haces antes, los borramos a más tardar el 30 de diciembre de 2026.")
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
  RelevoScreen(title = "Lo que aceptaste", onBack = onBack) {
    Text("Aceptaste participar con este texto.", style = Relevo.type.body, color = Relevo.colors.graphite)
    ConsentSections(remoteConfigured)
  }
}

/**
 * A3. El permiso de Tiempo de uso es necesario para avanzar; al volver con el permiso activo, la
 * app sigue sola. Desde 2.12 (D-087) la app pide las notificaciones apenas se abre esta pantalla,
 * para que queden encendidas, y ofrece quitar la restricción de batería.
 */
@Composable
internal fun PermissionScreen(
  usageAccess: Boolean,
  onOpenUsageSettings: () -> Unit,
  onRefresh: () -> Unit,
  onContinue: () -> Unit,
  backgroundUnrestricted: Boolean = true,
  onBattery: () -> Unit = {},
) {
  val context = LocalContext.current
  var notifications by remember { mutableStateOf(hasNotificationPermission(context)) }
  var waitingForSettings by remember { mutableStateOf(false) }
  LaunchedEffect(Unit) { if (!notifications) requestNotificationPermission(context) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
    onRefresh()
    notifications = hasNotificationPermission(context)
  }
  LaunchedEffect(usageAccess) { if (usageAccess && waitingForSettings) onContinue() }
  RelevoScreen(
    title = "Para saber cuándo avisarte",
    hero = { PhotoImage(Photo.TIEMPO, Modifier.fillMaxSize(), wide = true, describe = true) },
    heroHeight = 260.dp,
    heroPicture = Picture.OfPhoto(Photo.TIEMPO),
    bottom = {
      if (usageAccess) RelevoButton("Seguir", onContinue)
      else RelevoButton("Dar el permiso", { waitingForSettings = true; onOpenUsageSettings() })
    },
  ) {
    Text("Relevo necesita saber cuánto tiempo pasas en las apps que elijas. No ve lo que haces en ellas.", style = Relevo.type.body, color = Relevo.colors.ink)
    SectionGap()
    ListSection {
      ListRow(
        "Tiempo de uso", icon = KitIcon.PERMISO, subtitle = "Necesario.",
        onClick = if (usageAccess) null else ({ waitingForSettings = true; onOpenUsageSettings() }),
        trailing = { StatusChip(if (usageAccess) KitIcon.LISTO else KitIcon.ADVERTENCIA, if (usageAccess) "Listo" else "Falta", onPanel = true) },
      )
      ListRow(
        "Notificaciones", icon = KitIcon.AVISOS, subtitle = "Para avisarte aunque estés en otra app.",
        onClick = if (notifications) null else ({ requestNotificationPermission(context) }),
        trailing = { StatusChip(if (notifications) KitIcon.LISTO else KitIcon.AGREGAR, if (notifications) "Listo" else "Activar", onPanel = true) },
      )
      ListRow(
        "Batería", icon = KitIcon.BATERIA, subtitle = "Para que Relevo siga funcionando aunque pasen días.",
        onClick = if (backgroundUnrestricted) null else onBattery,
        trailing = { StatusChip(if (backgroundUnrestricted) KitIcon.LISTO else KitIcon.AGREGAR, if (backgroundUnrestricted) "Listo" else "Activar", onPanel = true) },
      )
    }
  }
}
