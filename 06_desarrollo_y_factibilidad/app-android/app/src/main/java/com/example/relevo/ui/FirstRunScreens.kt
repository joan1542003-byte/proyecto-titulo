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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.Wordmark
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.ActivityRing
import com.example.relevo.ui.components.BrandMark
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.draw.clip
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.IconTile
import com.example.relevo.ui.components.RelevoIcon

/**
 * A1 (4.0, D-155): la marca sobre el papel, sin aura, y una frase que dice qué hace Relevo. Debajo, un
 * ejemplo como se ve en la app: la actividad en su anillo, cómo empieza y dónde. No pide datos ni explica
 * de más.
 */
@Composable
internal fun WelcomeScreen(onStart: () -> Unit) {
  RelevoScreen(
    bottom = { RelevoButton("Empezar", onStart) },
  ) {
    Column(Modifier.fillMaxWidth().padding(top = 28.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      BrandMark(size = 64.dp, description = "Relevo", modifier = Modifier.appear(0))
      Spacer(Modifier.height(14.dp))
      Wordmark(height = 30.dp, modifier = Modifier.appear(0))
      Spacer(Modifier.height(28.dp))
      Text("Anota algo que quieres hacer", style = Relevo.type.title, color = Relevo.colors.ink, textAlign = TextAlign.Center, modifier = Modifier.appear(1))
      Spacer(Modifier.height(8.dp))
      Text("Cuando cumplas el tiempo que elegiste en tus apps, sonará un aviso donde empieza esa actividad.", style = Relevo.type.body, color = Relevo.colors.graphite, textAlign = TextAlign.Center, modifier = Modifier.appear(1))
    }
    Spacer(Modifier.height(36.dp))
    // Un ejemplo que se ve como en la app: la actividad en su anillo, cómo empieza y dónde.
    Column(Modifier.fillMaxWidth().appear(2), horizontalAlignment = Alignment.CenterHorizontally) {
      ActivityRing(KitIcon.LEER, 84.dp)
      Spacer(Modifier.height(10.dp))
      Text("Leer", style = Relevo.type.headline, color = Relevo.colors.ink)
      Spacer(Modifier.height(16.dp))
      ListSection {
        ListRow("Abrir el libro", icon = KitIcon.COMENCE, overline = START_QUESTION)
        ListRow("En el velador", icon = KitIcon.LUGAR, overline = PLACE_QUESTION)
      }
    }
  }
}

/**
 * A2. Para usar Relevo hay que aceptar el consentimiento vigente (D-084), la v14 desde la 4.4: los mismos
 * datos que antes, sin la prueba de 21 días (D-154 de la 1.0.0). Quien aceptó una versión anterior ve
 * «Relevo cambió» y conserva su código y sus datos. Decir que no es tan fácil como decir que sí.
 */
@Composable
internal fun ConsentScreen(
  remoteConfigured: Boolean,
  deletionPending: Boolean,
  renewal: Boolean = false,
  onAccept: () -> Unit,
  onPrivacy: () -> Unit,
) {
  var checked by rememberSaveable { mutableStateOf(false) }
  var declined by rememberSaveable { mutableStateOf(false) }
  RelevoScreen(
    title = if (renewal) "Relevo cambió" else "Antes de empezar",
    subtitle = if (renewal) "Ya no hay una prueba de 21 días. Tu código y tus datos se mantienen."
      else "Lee lo que aceptas. Puedes dejar de usarlo cuando quieras.",
    bottom = {
      val shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp)
      Row(
        Modifier.fillMaxWidth().heightIn(min = 56.dp).clip(shape).background(Relevo.colors.card)
          .border(if (checked) 2.dp else 1.5.dp, if (checked) Relevo.colors.ink else Relevo.colors.line, shape)
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Checkbox) { checked = !checked }
          .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        CheckMark(checked, square = true)
        Spacer(Modifier.width(12.dp))
        Text("Acepto usar Relevo con estas condiciones", style = Relevo.type.body.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Medium), color = Relevo.colors.ink)
      }
      GuardedButton(if (renewal) "Aceptar y seguir" else "Aceptar y empezar", onAccept, missing = when {
        deletionPending -> "Espera a que termine el borrado de los datos."
        !checked -> "Marca «Acepto usar Relevo con estas condiciones» para seguir."
        else -> null
      })
      PlainAction(if (declined) "Ocultar" else "No acepto", { declined = !declined }, color = Relevo.colors.graphite)
      if (declined) {
        Text(
          if (renewal) "Está bien. Sin aceptar, Relevo deja de contar el tiempo en tus apps. Los datos anteriores siguen guardados hasta que pidas borrarlos, o hasta el 30 de diciembre de 2026."
          else "Está bien. Sin aceptar, Relevo no se puede usar: puedes cerrar la app y desinstalarla. No se guardó nada.",
          style = Relevo.type.footnote, color = Relevo.colors.graphite,
        )
        if (renewal) PlainAction("Abrir Tus datos", onPrivacy)
      }
    },
  ) {
    Text(
      "Relevo es parte de un proyecto de título de Diseño de la Universidad Diego Portales. Mientras lo usas, guarda lo que haces en Relevo con un código, para estudiar cómo funciona. El nombre se guarda aparte. Puedes borrar los datos cuando quieras.",
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    Spacer(Modifier.height(Gap.block))
    ConsentSections(remoteConfigured)
    if (deletionPending) {
      SectionGap()
      Notice("Todavía se están borrando los datos. Mientras tanto, Relevo no guarda nada.", icon = KitIcon.ADVERTENCIA) {
        PlainAction("Abrir Tus datos", onPrivacy)
      }
    }
  }
}

/** El texto del consentimiento v14, por secciones y en listas (R12). También se lee entero desde Tus datos. */
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
      "El nombre se guarda aparte, solo con el código, para saber quién usa Relevo. No va junto a lo que haces.",
    ))
    ConsentPart(KitIcon.TELEFONO, expanded, "Dónde se guarda", if (remoteConfigured) listOf(
      "En el teléfono y en la base de datos del proyecto, en Supabase, un servicio para guardar datos en internet. Si no hay internet, se envía después.",
      "Una copia sin el nombre queda en la carpeta Documentos/Relevo del teléfono. Se borra si borras los datos.",
    ) else listOf("Esta instalación no tiene configurada la base de datos del proyecto: todo queda en este teléfono."))
    ConsentPart(KitIcon.PRIVACIDAD, expanded, "Qué no se ve", listOf(
      "El permiso de Tiempo de uso podría mostrar otras apps. Relevo cuenta solo las que eliges; de las demás no guarda el nombre.",
      "Con la activación automática encendida, Relevo mira qué app tienes abierta, solo su nombre, para saber cuándo empezar. Puedes apagarla cuando quieras.",
      "Relevo no lee mensajes, fotos, búsquedas ni lo que hay en la pantalla.",
    ))
    ConsentPart(KitIcon.AVISOS, expanded, "Mensajes", listOf(
      "El autor del proyecto puede enviar mensajes sobre Relevo. Llegan como notificación.",
      "Se guarda cuándo llegó y cuándo se abrió cada uno.",
    ))
    ConsentPart(KitIcon.CODIGO, expanded, "El código", listOf(
      "El código reemplaza el nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte.",
    ))
    ConsentPart(KitIcon.CALENDARIO, expanded, "Hasta cuándo", listOf(
      "Puedes borrar los datos desde Perfil, en Tus datos, o escribiendo a joan1542003@gmail.com con el código.",
      "Si no lo haces antes, se borran a más tardar el 30 de diciembre de 2026.",
    ))
  }
}

/** Una parte del consentimiento en su fila: el título con su ícono y, al tocarla, la lista completa. */
@Composable
private fun ConsentPart(icon: KitIcon, expanded: Boolean, title: String, items: List<String>) {
  var open by rememberSaveable(title) { mutableStateOf(expanded) }
  val shape = androidx.compose.foundation.shape.RoundedCornerShape(21.dp)
  Column(
    Modifier.fillMaxWidth().clip(shape).background(Relevo.colors.card)
      .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Button, onClickLabel = if (open) "Ocultar" else "Leer") { open = !open }
      .padding(start = 14.dp, end = 15.dp, top = 12.dp, bottom = 12.dp),
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      IconTile(icon)
      Spacer(Modifier.width(14.dp))
      Text(title, style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
      RelevoIcon(if (open) KitIcon.CONTRAER else KitIcon.EXPANDIR, size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card)
    }
    AnimatedVisibility(open, enter = expandVertically(Motion.smooth()) + fadeIn(Motion.standard()), exit = shrinkVertically(Motion.smooth()) + fadeOut(Motion.standard(Motion.SHORT))) {
      Column(Modifier.padding(start = 48.dp, top = 6.dp, bottom = 4.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
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

/** Consentimiento completo, de solo lectura, desde Privacidad y datos. */
@Composable
internal fun ConsentDetailsScreen(remoteConfigured: Boolean, onBack: () -> Unit) {
  RelevoScreen(title = "Lo que aceptaste", subtitle = "Aceptaste usar Relevo con este texto.", onBack = onBack) {
    ConsentSections(remoteConfigured, expanded = true)
  }
}

/** Al final de la fila de un permiso: la marca de listo o un botón pequeño para darlo. */
@Composable
private fun PermissionEnd(granted: Boolean, label: String, primary: Boolean = false, onClick: () -> Unit) {
  if (granted) RelevoIcon(KitIcon.LISTO, size = 22.dp, tint = Relevo.colors.ink, background = Relevo.colors.card, strokeWidth = 2f)
  else RelevoButton(label, onClick, kind = if (primary) ButtonKind.Primary else ButtonKind.Secondary, compact = true)
}

/**
 * A3. La primera vez se pide un solo permiso: Tiempo de uso, sin el cual Relevo no puede contar (4.4, desde la
 * 1.0.0). Las notificaciones se piden al activar un relevo y la batería, solo si Android la restringe.
 * Al volver con el permiso activo, la app sigue sola.
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
    title = "Para saber cuándo avisarte",
    subtitle = "Relevo solo cuenta minutos en las apps que elijas. No ve lo que haces en ellas.",
    bottom = {
      if (usageAccess) RelevoButton("Seguir", onContinue)
      else RelevoButton("Dar el permiso", { waitingForSettings = true; onOpenUsageSettings() })
    },
  ) {
    ListSection {
      ListRow(
        "Tiempo de uso", icon = KitIcon.PERMISO, subtitle = "Necesario. En Android: Acceso a datos de uso",
        onClick = if (usageAccess) null else ({ waitingForSettings = true; onOpenUsageSettings() }),
        trailing = { PermissionEnd(usageAccess, "Dar el permiso", primary = true) { waitingForSettings = true; onOpenUsageSettings() } },
      )
    }
    if (!usageAccess) {
      Spacer(Modifier.height(Gap.block))
      Column(Modifier.padding(horizontal = 4.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        PermissionStep("1", "Toca «Dar el permiso».")
        PermissionStep("2", "En la lista, busca Relevo.")
        PermissionStep("3", "Actívalo y vuelve: Relevo sigue solo.")
      }
    }
  }
}

@Composable
private fun PermissionStep(number: String, text: String) {
  Row(verticalAlignment = Alignment.Top) {
    Text(number, style = Relevo.type.callout.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold), color = Relevo.colors.ink, modifier = Modifier.width(22.dp))
    Text(text, style = Relevo.type.callout, color = Relevo.colors.graphite)
  }
}
