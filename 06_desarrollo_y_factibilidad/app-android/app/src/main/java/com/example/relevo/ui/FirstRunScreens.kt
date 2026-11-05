package com.example.relevo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.AuraBackground
import com.example.relevo.ui.components.AuraMood
import com.example.relevo.ui.components.BrandMark
import com.example.relevo.ui.components.CheckMark
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.IconTile
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Notice
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.ScreenTitle
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.SkyCard
import com.example.relevo.ui.components.Wordmark
import com.example.relevo.ui.components.appear

/**
 * A1. La bienvenida: la marca sobre el aura, el descriptor —para una marca nueva, decir qué hace ayuda a
 * entenderla (Luffarelli et al., 2019)— y un ejemplo que se ve como en la app. Es la primera de tres
 * pantallas antes del primer relevo (1.0.0): bienvenida, consentimiento y permiso.
 */
@Composable
internal fun WelcomeScreen(onStart: () -> Unit) {
  RelevoScreen(
    backdrop = { AuraBackground(Modifier.fillMaxSize(), mood = AuraMood.CALM) },
    bottom = {
      ScreenTitle("Anota algo que quieres hacer", "Cuando llevas un rato en el teléfono, Relevo suena donde empiezas.", Modifier.fillMaxWidth().padding(bottom = 8.dp).appear(3))
      RelevoButton("Empezar", onStart)
    },
  ) {
    Column(Modifier.fillMaxWidth().padding(top = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.appear(0)) {
        BrandMark(size = 52.dp, description = "Relevo")
        Spacer(Modifier.width(12.dp))
        Wordmark(height = 30.dp)
      }
      Spacer(Modifier.height(8.dp))
      Text("Un recordatorio físico preparado desde el teléfono", style = Relevo.type.subhead, color = Relevo.colors.graphite, textAlign = TextAlign.Center, modifier = Modifier.appear(1))
    }
    Spacer(Modifier.height(28.dp))
    // Un ejemplo que se ve como en la app: la actividad en su cielo, cómo empieza y dónde.
    BoxWithConstraints(Modifier.fillMaxWidth().height(392.dp).appear(2)) {
      val w = maxWidth
      SkyCard("Leer", KitIcon.LEER, Modifier.align(Alignment.TopCenter).width(w * 0.56f), aspect = 1f, largeLabel = true)
      FloatingRow(KitIcon.PRIMER_PASO, "Abrir el libro", "Para empezar", Modifier.align(Alignment.TopStart).padding(top = w * 0.56f + 18.dp).width(w * 0.68f))
      FloatingRow(KitIcon.LUGAR, "En el velador", "Dónde empiezas", Modifier.align(Alignment.TopEnd).padding(top = w * 0.56f + 108.dp).width(w * 0.62f))
    }
  }
}

/** Fila que flota sobre el aura, en vidrio claro, con su ficha de color. */
@Composable
private fun FloatingRow(icon: KitIcon, title: String, subtitle: String, modifier: Modifier = Modifier) {
  val shape = RoundedCornerShape(21.dp)
  Row(
    modifier.shadow(16.dp, shape, ambientColor = Color.Black.copy(alpha = .04f), spotColor = Color.Black.copy(alpha = .16f))
      .clip(shape).background(Relevo.colors.card.copy(alpha = .88f)).padding(10.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    IconTile(icon)
    Spacer(Modifier.width(12.dp))
    Column {
      Text(title, style = Relevo.type.headline, color = Relevo.colors.ink)
      Text(subtitle, style = Relevo.type.subhead, color = Relevo.colors.graphite)
    }
  }
}

/**
 * A2. El consentimiento (versión 2026-11-04-v14). Relevo sigue siendo parte de un proyecto de título y
 * sigue guardando y enviando los mismos datos; desde 1.0.0 ya no hay una prueba de 21 días ni semanas con
 * instrucciones. Arriba, lo esencial; cada sección se abre con un toque y está escrita en listas (R12 del
 * estudio de los textos). Decir que no es tan fácil como decir que sí. [renewal]: la persona aceptó una
 * versión anterior; conserva su código y sus datos.
 */
@Composable
internal fun ConsentScreen(
  remoteConfigured: Boolean,
  deletionPending: Boolean,
  renewal: Boolean,
  onAccept: () -> Unit,
  onPrivacy: () -> Unit,
) {
  var checked by rememberSaveable { mutableStateOf(false) }
  var declined by rememberSaveable { mutableStateOf(false) }
  RelevoScreen(
    title = if (renewal) "Relevo cambió" else "Antes de empezar",
    subtitle = if (renewal) "Ya no hay una prueba de 21 días. Lee lo que aceptas; tu código y tus datos se mantienen."
      else "Lee lo que aceptas. Puedes dejar de usarlo cuando quieras.",
    bottom = {
      val shape = RoundedCornerShape(20.dp)
      Row(
        Modifier.fillMaxWidth().heightIn(min = 56.dp).clip(shape).background(Relevo.colors.card)
          .border(if (checked) 2.dp else 1.5.dp, if (checked) Relevo.colors.ink else Relevo.colors.line, shape)
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { checked = !checked }
          .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        CheckMark(checked, square = true)
        Spacer(Modifier.width(12.dp))
        Text("Acepto usar Relevo con estas condiciones", style = Relevo.type.body.copy(fontWeight = FontWeight.Medium), color = Relevo.colors.ink)
      }
      GuardedButton(if (renewal) "Aceptar y seguir" else "Aceptar y empezar", onAccept, missing = when {
        deletionPending -> "Espera a que termine el borrado de tus datos."
        !checked -> "Marca «Acepto usar Relevo con estas condiciones» para seguir."
        else -> null
      })
      PlainAction(if (declined) "Ocultar" else "No acepto", { declined = !declined }, color = Relevo.colors.graphite)
      if (declined) {
        Text(
          if (renewal) "Está bien. Sin aceptar, Relevo deja de contar. Tus datos anteriores siguen guardados hasta que pidas borrarlos, o hasta el 30 de diciembre de 2026; puedes borrarlos en Privacidad y datos."
          else "Está bien. Sin aceptar, Relevo no se puede usar: puedes cerrar la app y desinstalarla. No se guardó nada tuyo.",
          style = Relevo.type.footnote, color = Relevo.colors.graphite,
        )
        if (renewal) PlainAction("Abrir Privacidad y datos", onPrivacy)
      }
    },
  ) {
    Text(
      "Relevo es parte de un proyecto de título de Diseño de la Universidad Diego Portales. Mientras lo usas, guarda lo que haces en Relevo con un código, para estudiar cómo funciona. Tu nombre se guarda aparte. Puedes borrar tus datos cuando quieras.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.height(Gap.block))
    ConsentSections(remoteConfigured)
    if (deletionPending) {
      SectionGap()
      Notice("Todavía se están borrando tus datos. Mientras tanto, Relevo no guarda nada.", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Abrir Privacidad y datos", onPrivacy)
      }
    }
  }
}

/** El texto del consentimiento v14, por secciones. También se lee entero desde Privacidad y datos. */
@Composable
internal fun ConsentSections(remoteConfigured: Boolean, expanded: Boolean = false) {
  Column(verticalArrangement = Arrangement.spacedBy(Gap.list)) {
    ConsentPart(KitIcon.INFO, expanded, "Cómo funciona", listOf(
      "Preparas un relevo: qué quieres hacer, cómo empiezas, dónde y cuánto tiempo en tus apps.",
      "Cuando sumas ese tiempo, suena unos 30 segundos en el Tag, en el teléfono o en un dispositivo de audio, y se apaga solo.",
      "Después puedes responder preguntas de un toque. Todas se pueden saltar.",
    ))
    ConsentPart(KitIcon.DECISION, expanded, "Tú decides", listOf(
      "Usar Relevo es voluntario.",
      "Puedes saltar preguntas, silenciar el sonido, quitar los permisos o dejar de usarlo cuando quieras, sin dar explicaciones.",
      "Nadie juzga lo que eliges hacer.",
      "El sonido puede molestar a otras personas: puedes detenerlo cuando quieras.",
    ))
    ConsentPart(KitIcon.DATOS, expanded, "Qué se guarda", listOf(
      "Un código al azar, en lugar de tu nombre.",
      "Lo que preparas: la actividad, cómo empiezas, dónde, las apps y el tiempo.",
      "Cuándo activas un relevo, a mano o solo, cuándo suena y qué respondes.",
      "Cuánto usaste las apps elegidas 10 minutos antes y después de que sonara.",
      "Cada día, cuánto usas las apps que elegiste en Relevo y el tiempo total del teléfono.",
      "El modelo del teléfono, los permisos que diste y cómo usas Relevo: cuándo lo abres, qué pantallas ves, tus intereses, tus actividades y tus ajustes.",
      "Tu nombre se guarda aparte, solo con tu código, para saber quién usa Relevo. No va junto a lo que haces.",
    ))
    ConsentPart(KitIcon.TELEFONO, expanded, "Dónde se guarda", if (remoteConfigured) listOf(
      "En el teléfono y en la base de datos del proyecto, en Supabase, un servicio para guardar datos en internet. Si no hay internet, se envía después.",
      "Una copia sin tu nombre queda en la carpeta Documentos/Relevo del teléfono. Se borra si borras tus datos.",
    ) else listOf("Esta instalación no tiene configurada la base de datos del proyecto: todo queda en este teléfono."))
    ConsentPart(KitIcon.PRIVACIDAD, expanded, "Qué no se ve", listOf(
      "El permiso de Tiempo de uso podría mostrar otras apps. Relevo cuenta solo las que eliges; de las demás no guarda el nombre.",
      "Con la activación automática encendida, Relevo mira qué app tienes abierta, solo su nombre, para saber cuándo empezar. Puedes apagarla cuando quieras.",
      "Relevo no lee mensajes, fotos, búsquedas ni lo que hay en tu pantalla.",
    ))
    ConsentPart(KitIcon.AVISOS, expanded, "Mensajes", listOf(
      "El autor del proyecto puede enviarte mensajes sobre Relevo. Llegan como notificación.",
      "Se guarda cuándo llegó y cuándo abriste cada uno.",
    ))
    ConsentPart(KitIcon.CODIGO, expanded, "Tu código", listOf(
      "El código reemplaza tu nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte.",
    ))
    ConsentPart(KitIcon.CALENDARIO, expanded, "Hasta cuándo", listOf(
      "Puedes borrar tus datos desde Perfil, en Privacidad y datos, o escribiendo a joan1542003@gmail.com con tu código.",
      "Si no lo haces antes, se borran a más tardar el 30 de diciembre de 2026.",
    ))
  }
}

/** Una parte del consentimiento en su fila: el título con su ícono y, al tocarla, la lista completa. */
@Composable
private fun ConsentPart(icon: KitIcon, expanded: Boolean, title: String, items: List<String>) {
  var open by rememberSaveable(title) { mutableStateOf(expanded) }
  val shape = RoundedCornerShape(21.dp)
  Column(
    Modifier.fillMaxWidth().clip(shape).background(Relevo.colors.card)
      .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Button, onClickLabel = if (open) "Ocultar" else "Leer") { open = !open }
      .padding(start = 10.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      IconTile(icon, background = Relevo.colors.card)
      Spacer(Modifier.width(14.dp))
      Text(title, style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
      RelevoIcon(if (open) KitIcon.CONTRAER else KitIcon.EXPANDIR, size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card)
    }
    AnimatedVisibility(open, enter = expandVertically(Motion.smooth()) + fadeIn(Motion.standard()), exit = shrinkVertically(Motion.smooth()) + fadeOut(Motion.standard(Motion.SHORT))) {
      Column(Modifier.padding(start = 59.dp, top = 6.dp, bottom = 4.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
        items.forEach { item ->
          Row {
            Text("•", style = Relevo.type.subhead, color = Relevo.colors.graphite, modifier = Modifier.width(14.dp))
            Text(item, style = Relevo.type.subhead, color = Relevo.colors.graphite)
          }
        }
      }
    }
  }
}

/** El consentimiento completo, de solo lectura, desde Privacidad y datos. */
@Composable
internal fun ConsentDetailsScreen(remoteConfigured: Boolean, onBack: () -> Unit) {
  RelevoScreen(title = "Lo que aceptaste", subtitle = "Aceptaste usar Relevo con este texto.", onBack = onBack, backLabel = "Privacidad y datos") {
    ConsentSections(remoteConfigured, expanded = true)
  }
}

/**
 * A3. El único permiso que se pide antes del primer relevo: Tiempo de uso, sin el cual Relevo no puede
 * contar. Las notificaciones se piden al activar un relevo y la batería, cuando hace falta (1.0.0). Se dice
 * el nombre que usa Android, para encontrarlo en los ajustes (R6). Al volver con el permiso, sigue solo.
 */
@Composable
internal fun PermissionScreen(
  usageAccess: Boolean,
  onOpenUsageSettings: () -> Unit,
  onRefresh: () -> Unit,
  onContinue: () -> Unit,
) {
  var waitingForSettings by remember { mutableStateOf(false) }
  LifecycleEventEffect(Lifecycle.Event.ON_RESUME) { onRefresh() }
  LaunchedEffect(usageAccess) { if (usageAccess && waitingForSettings) onContinue() }
  RelevoScreen(
    title = "Para contar tu tiempo",
    subtitle = "Relevo cuenta minutos solo en las apps que elijas. No ve lo que haces en ellas.",
    bottom = {
      if (usageAccess) RelevoButton("Seguir", onContinue)
      else RelevoButton("Dar el permiso", { waitingForSettings = true; onOpenUsageSettings() })
    },
  ) {
    ListSection {
      ListRow(
        "Tiempo de uso", icon = KitIcon.PERMISO, subtitle = if (usageAccess) "Listo" else "Necesario para contar",
        onClick = if (usageAccess) null else ({ waitingForSettings = true; onOpenUsageSettings() }),
        trailing = { if (usageAccess) RelevoIcon(KitIcon.LISTO, size = 22.dp, tint = Relevo.colors.ink, background = Relevo.colors.card, strokeWidth = 2f) },
        tileColor = Relevo.colors.card,
      )
    }
    if (!usageAccess) {
      Spacer(Modifier.height(Gap.block))
      Column(Modifier.padding(horizontal = 4.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        PermissionStep("1", "Toca «Dar el permiso».")
        PermissionStep("2", "En la lista, busca Relevo. En Android, el permiso se llama «Acceso a datos de uso».")
        PermissionStep("3", "Actívalo y vuelve: Relevo sigue solo.")
      }
    }
  }
}

@Composable
private fun PermissionStep(number: String, text: String) {
  Row(verticalAlignment = Alignment.Top) {
    Text(number, style = Relevo.type.callout.copy(fontWeight = FontWeight.SemiBold), color = Relevo.colors.ink, modifier = Modifier.width(22.dp))
    Text(text, style = Relevo.type.callout, color = Relevo.colors.graphite)
  }
}
