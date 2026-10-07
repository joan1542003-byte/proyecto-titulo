package com.example.relevo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.artPalette
import com.example.relevo.ui.components.rememberReduceMotion

/** Qué muestra el dibujo del Tag en cada paso. */
private enum class TagGesture { IDLE, HOLD_ON, LINK, PLACE, TAP, HOLD_OFF, BATTERY, ONE_PHONE }

private class GuideStep(val title: String, val text: String, val gesture: TagGesture, val cue: String)

/**
 * Cómo usar el Tag, paso a paso (D-109). Es redondo, con un solo botón al centro, como el NEWOTAG-BL
 * que se compró para la prueba. Se abre sola la primera vez que se elige el Tag y desde Perfil › Ayuda.
 */
private val guideSteps = listOf(
  GuideStep("Este es tu Tag", "Es redondo y tiene un solo botón, al centro. Relevo lo hace sonar por Bluetooth.", TagGesture.IDLE, "Un botón al centro"),
  GuideStep("Enciéndelo", "Mantén apretado el botón 3 segundos, hasta que pite dos veces. Queda encendido: no hay que hacerlo cada vez.", TagGesture.HOLD_ON, "3 segundos · pita dos veces"),
  GuideStep("Búscalo en Relevo", "Con el Tag cerca del teléfono, toca «Buscar el Tag» y elígelo en la lista. Va a pitar una vez para confirmarlo.", TagGesture.LINK, "Cerca del teléfono"),
  GuideStep("Déjalo en su lugar", "Ponlo donde te indica Relevo esta semana. Sonará cuando sumes el tiempo que elegiste en tus apps.", TagGesture.PLACE, "Donde te indica la semana"),
  GuideStep("Para callarlo, un toque", "Cuando suene, toca el botón una vez. No lo mantengas apretado: así se apaga.", TagGesture.TAP, "Un toque"),
  GuideStep("Para apagarlo", "Mantén apretado el botón 3 segundos, hasta que dé un pitido largo. Durante la prueba, mejor déjalo encendido.", TagGesture.HOLD_OFF, "3 segundos · pitido largo"),
  GuideStep("La pila dura meses", "Usa una pila de botón CR2032. Para cambiarla, abre la tapa por la ranura del borde con una uña o una moneda.", TagGesture.BATTERY, "Pila CR2032"),
  GuideStep("Si no aparece", "El Tag se conecta a un solo teléfono a la vez. Cierra apps como iSearching y, si lo usaste con otro teléfono, apaga su Bluetooth.", TagGesture.ONE_PHONE, "Un teléfono a la vez"),
)

/**
 * La guía en pasos: un dibujo animado del Tag, una frase y «Siguiente». [finishLabel] y [onFinish]
 * permiten terminar buscando el Tag cuando todavía no hay uno elegido.
 */
@Composable
internal fun TagGuideSheet(onDismiss: () -> Unit, finishLabel: String = "Entendido", onFinish: (() -> Unit)? = null) {
  var index by rememberSaveable { mutableIntStateOf(0) }
  val last = guideSteps.lastIndex
  RelevoSheet(onDismiss = onDismiss, title = "Cómo usar el Tag", done = "Cerrar", scrollable = false) {
    AnimatedContent(
      targetState = index,
      transitionSpec = {
        val forward = targetState > initialState
        (slideInHorizontally { if (forward) it / 4 else -it / 4 } + fadeIn()) togetherWith (slideOutHorizontally { if (forward) -it / 4 else it / 4 } + fadeOut())
      },
      label = "tag_guide",
    ) { i ->
      val step = guideSteps[i]
      Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        TagIllustration(step.gesture, Modifier.size(200.dp).semantics { contentDescription = step.cue })
        Spacer(Modifier.height(4.dp))
        Text(step.cue, style = Relevo.type.footnote, color = Relevo.colors.graphite)
        Spacer(Modifier.height(18.dp))
        Column(Modifier.fillMaxWidth().heightIn(min = 120.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
          Text(step.title, style = Relevo.type.title2, color = Relevo.colors.ink)
          Text(step.text, style = Relevo.type.body, color = Relevo.colors.graphite)
        }
      }
    }
    Spacer(Modifier.height(12.dp))
    StepDots(index, guideSteps.size)
    Spacer(Modifier.height(18.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
      if (index > 0) RelevoButton("Atrás", { index-- }, Modifier.weight(1f), kind = ButtonKind.Secondary)
      RelevoButton(
        if (index < last) "Siguiente" else finishLabel,
        { if (index < last) index++ else { onDismiss(); onFinish?.invoke() } },
        Modifier.weight(if (index > 0) 1.6f else 1f),
      )
    }
  }
}

/** Puntos de avance: el paso actual es una cápsula de tinta. */
@Composable
private fun StepDots(current: Int, count: Int) {
  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
    repeat(count) { i ->
      Box(
        Modifier.padding(horizontal = 3.dp).height(8.dp).width(if (i == current) 22.dp else 8.dp).clip(CircleShape)
          .background(if (i == current) Relevo.colors.ink else Relevo.colors.line),
      )
    }
  }
}

/**
 * El Tag dibujado: un disco con un botón al centro y una luz pequeña, sobre un halo de colores.
 * Cada paso anima lo que hay que hacer: mantener 3 s (un arco que se llena), un toque (un anillo que
 * se abre), la conexión con el teléfono o la pila. Con «reducir movimiento», queda quieto.
 */
@Composable
private fun TagIllustration(gesture: TagGesture, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val reduce = rememberReduceMotion()
  val time = rememberInfiniteTransition(label = "tag_art")
  // 0 → 1 en 3 s y una pausa breve: el arco de «mantén 3 segundos».
  val hold by time.animateFloat(
    initialValue = 0f, targetValue = 1f,
    animationSpec = infiniteRepeatable(keyframes { durationMillis = 3800; 0f at 0; 1f at 3000 using LinearEasing; 1f at 3800 }),
    label = "hold",
  )
  val pulse by time.animateFloat(0f, 1f, infiniteRepeatable(tween(1400, easing = FastOutSlowInEasing)), label = "pulse")
  val blink by time.animateFloat(0.25f, 1f, infiniteRepeatable(tween(900), RepeatMode.Reverse), label = "blink")
  val h = if (reduce) 0.7f else hold
  val p = if (reduce) 0.5f else pulse
  val (c1, c2, c3) = artPalette(KitIcon.OBJETO)
  Canvas(modifier) {
    val w = size.width; val center = Offset(w / 2f, size.height / 2f)
    val linked = gesture == TagGesture.LINK || gesture == TagGesture.ONE_PHONE
    val body = w * (if (linked) 0.22f else 0.30f)
    val button = body * 0.42f
    val line = w * 0.018f
    // Halo de colores detrás del Tag.
    drawCircle(Brush.radialGradient(listOf(c1.copy(alpha = .55f), c2.copy(alpha = .35f), c3.copy(alpha = 0f)), center, w * 0.5f), w * 0.5f, center)
    val tagCenter = when (gesture) {
      TagGesture.LINK, TagGesture.ONE_PHONE -> Offset(w * 0.30f, center.y)
      TagGesture.BATTERY -> Offset(w * 0.42f, center.y)
      else -> center
    }
    // Teléfono y ondas de Bluetooth que salen del Tag hacia él.
    if (linked) {
      val phoneW = w * 0.15f; val phoneH = w * 0.26f
      val single = gesture == TagGesture.LINK
      val phoneTop = Offset(w * 0.72f, if (single) center.y - phoneH / 2f else center.y - phoneH - w * 0.02f)
      val corner = androidx.compose.ui.geometry.CornerRadius(w * 0.03f)
      drawRoundRect(colors.card, phoneTop, Size(phoneW, phoneH), corner)
      drawRoundRect(colors.ink, phoneTop, Size(phoneW, phoneH), corner, style = Stroke(line))
      val target = Offset(phoneTop.x, phoneTop.y + phoneH / 2f)
      repeat(3) { k ->
        val phase = ((p * 3f) - k).coerceIn(0f, 1f)
        val x = tagCenter.x + body + w * 0.035f + k * w * 0.045f
        val y = tagCenter.y + (target.y - tagCenter.y) * ((k + 1) / 4f)
        val r = w * (0.03f + 0.025f * k)
        drawArc(colors.ink.copy(alpha = 0.2f + 0.7f * phase), -40f, 80f, false, Offset(x - r, y - r), Size(r * 2, r * 2), style = Stroke(line, cap = StrokeCap.Round))
      }
      if (!single) {
        // Un segundo teléfono, tachado: el Tag acepta solo uno a la vez.
        val second = Offset(w * 0.72f, center.y + w * 0.02f)
        drawRoundRect(colors.mist, second, Size(phoneW, phoneH), corner)
        drawRoundRect(colors.ink.copy(alpha = .35f), second, Size(phoneW, phoneH), corner, style = Stroke(line))
        drawLine(colors.error, second + Offset(-w * 0.02f, phoneH + w * 0.01f), second + Offset(phoneW + w * 0.02f, -w * 0.01f), line * 1.2f, StrokeCap.Round)
      }
    }
    // Lugar: una línea de mesa bajo el Tag.
    if (gesture == TagGesture.PLACE) {
      drawLine(colors.ink.copy(alpha = .5f), Offset(w * 0.18f, center.y + body + w * 0.06f), Offset(w * 0.82f, center.y + body + w * 0.06f), line, StrokeCap.Round)
    }
    // El Tag: disco, borde y botón.
    drawCircle(colors.ink.copy(alpha = .05f), body + line * 1.5f, tagCenter + Offset(0f, line * 1.5f))
    drawCircle(colors.card, body, tagCenter)
    drawCircle(colors.ink, body, tagCenter, style = Stroke(line))
    val pressed = (gesture == TagGesture.HOLD_ON || gesture == TagGesture.HOLD_OFF) && h < 1f || (gesture == TagGesture.TAP && p < 0.18f)
    drawCircle(if (pressed) colors.line else colors.mist, button, tagCenter)
    drawCircle(colors.ink, button, tagCenter, style = Stroke(line * 0.8f))
    // Luz pequeña arriba del botón.
    drawCircle(colors.ink.copy(alpha = if (reduce) 0.8f else blink), line * 1.1f, tagCenter + Offset(0f, -body * 0.68f))
    when (gesture) {
      TagGesture.HOLD_ON, TagGesture.HOLD_OFF -> {
        val r = body + w * 0.06f
        drawCircle(colors.line, r, tagCenter, style = Stroke(line * 1.4f))
        drawArc(colors.ink, -90f, 360f * h, false, Offset(tagCenter.x - r, tagCenter.y - r), Size(r * 2, r * 2), style = Stroke(line * 1.4f, cap = StrokeCap.Round))
      }
      TagGesture.TAP -> {
        val r = button + (body - button) * 1.6f * p
        drawCircle(colors.ink.copy(alpha = (1f - p) * 0.7f), r, tagCenter, style = Stroke(line))
      }
      TagGesture.BATTERY -> {
        val coin = body * 0.62f
        val cc = Offset(w * 0.70f, center.y + body * 0.35f)
        drawCircle(colors.mist, coin, cc)
        drawCircle(colors.ink, coin, cc, style = Stroke(line))
        val s = coin * 0.32f
        drawLine(colors.ink, cc - Offset(s, 0f), cc + Offset(s, 0f), line, StrokeCap.Round)
        drawLine(colors.ink, cc - Offset(0f, s), cc + Offset(0f, s), line, StrokeCap.Round)
      }
      else -> Unit
    }
  }
}
