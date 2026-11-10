package com.example.relevo.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.isSpecified
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import kotlin.math.max
import kotlin.math.round

private val Ink = Color(0xFF141312)

/**
 * El anillo de una actividad (4.0, D-155; simétrico desde la 4.1, D-156): un círculo claro con su ícono
 * en tinta, rodeado por un anillo con el color de su familia. Todo se dibuja en un solo lienzo y con un
 * mismo centro, para que el anillo mida lo mismo en todo el contorno: antes el círculo interior se
 * centraba redondeando a píxeles y podía quedar uno corrido. El degradado es igual a la izquierda y a la
 * derecha (arriba, los lados y abajo), con colores de una misma luminancia, y el ícono va a su centro
 * óptico. El grosor es el 7,5 % del diámetro, redondeado a píxeles enteros.
 */
@Composable
fun ActivityRing(icon: KitIcon, size: Dp, modifier: Modifier = Modifier, description: String? = null) {
  val colors = skyFor(icon).ring
  // En el tema oscuro, el círculo es apenas tibio para no encandilar; el ícono sigue en tinta.
  val disc = if (Relevo.colors.isDark) Color(0xFFEAE7E5) else Color.White
  val geometry = remember(icon) { kitGeometry(icon) }
  val iconSide = size * 0.42f
  val stroke = opticalStroke(iconSide)
  Canvas(modifier.size(size).then(if (description != null) Modifier.semantics { contentDescription = description } else Modifier)) {
    val diameter = this.size.minDimension
    val radius = diameter / 2f
    val ring = max(round(diameter * 0.075f), round(2.5.dp.toPx()))
    val brush = Brush.sweepGradient(
      0f to colors[1], 0.25f to colors[2], 0.5f to colors[1], 0.75f to colors[0], 1f to colors[1],
      center = center,
    )
    drawCircle(brush, radius = radius - ring / 2f, center = center, style = Stroke(width = ring))
    drawCircle(disc, radius = radius - ring + 0.5f, center = center)
    val side = iconSide.toPx()
    translate(center.x - side / 2f, center.y - side / 2f) { drawKitIcon(icon, geometry, side, Ink, disc, stroke) }
  }
}

/**
 * Una actividad en una cuadrícula: su anillo y, debajo, el nombre en dos líneas como máximo. [selected]
 * dibuja un anillo de tinta por fuera, como el selector de fondos de iOS; [count] pone una cifra pequeña
 * en la esquina (cuántas veces esta semana), sin comparar ni premiar.
 */
@Composable
fun RingCell(
  icon: KitIcon,
  label: String?,
  /** Sin acción, el anillo solo muestra (como en «Tu semana»). */
  onClick: (() -> Unit)?,
  modifier: Modifier = Modifier,
  size: Dp = 64.dp,
  selected: Boolean = false,
  count: Int? = null,
  description: String = label.orEmpty(),
) {
  val interaction = remember { MutableInteractionSource() }
  val haptics = LocalHapticFeedback.current
  // El anillo de tinta de la elegida aparece desde adentro, con un resorte sin rebote.
  val chosen by animateFloatAsState(if (selected) 1f else 0f, Motion.smooth(stiffness = 700f), label = "ring_selected")
  val ink = Relevo.colors.ink
  Column(
    modifier
      .then(
        if (onClick != null) Modifier.pressScale(interaction, 0.94f)
          .clickable(interactionSource = interaction, indication = null, role = if (label == null) Role.RadioButton else Role.Button) {
            if (label == null) haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
            onClick()
          }
        else Modifier,
      )
      .semantics(mergeDescendants = true) { if (onClick != null) this.selected = selected; contentDescription = description },
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Box(
      Modifier.size(size).drawBehind {
        if (chosen > 0f) {
          val width = 2.dp.toPx()
          drawCircle(ink.copy(alpha = chosen), radius = this.size.minDimension / 2f + 3.dp.toPx() + width / 2f - (1f - chosen) * 3.dp.toPx(), style = Stroke(width))
        }
      },
    ) {
      ActivityRing(icon, size)
      if (count != null && count > 1) {
        Box(
          Modifier.align(Alignment.TopEnd).offset(x = 4.dp, y = (-2).dp).size(22.dp).clip(CircleShape).background(Relevo.colors.ink),
          contentAlignment = Alignment.Center,
        ) { Text("$count", style = Relevo.type.caption.copy(fontWeight = FontWeight.SemiBold), color = Relevo.colors.onInk) }
      }
    }
    if (label != null) {
      Spacer(Modifier.height(8.dp))
      // 4.6.1: el nombre nunca parte una palabra. Ocupa su ancho de siempre y solo se ensancha, dejando aire con
      // la celda vecina, si una palabra no cabe; si tampoco cabe ahí (letra grande), la letra baja lo justo.
      // Antes «Hacer manualidades» se leía «Hacer man / ualidades» en la cuadrícula de cuatro.
      val base = Relevo.type.footnote.copy(fontWeight = FontWeight.Medium, lineHeight = Relevo.type.footnote.lineHeight)
      val measurer = rememberTextMeasurer()
      val density = LocalDensity.current
      BoxWithConstraints(Modifier.widthIn(min = size + 22.dp).fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        val preferredPx = with(density) { (size + 22.dp).roundToPx() }
        val availablePx = (constraints.maxWidth - with(density) { 8.dp.roundToPx() }).coerceAtLeast(preferredPx)
        val fit = remember(label, base, preferredPx, availablePx) { labelFit(label, base, preferredPx, availablePx, measurer) }
        Text(
          label, style = fit.second, color = Relevo.colors.ink, textAlign = TextAlign.Center, maxLines = 2,
          overflow = TextOverflow.Ellipsis, modifier = Modifier.width(with(density) { fit.first.toDp() }),
        )
      }
    }
  }
}

/** «Nueva»: un círculo punteado con el signo más, del tamaño de los anillos, para crear una actividad. */
@Composable
fun AddRingCell(label: String, onClick: () -> Unit, modifier: Modifier = Modifier, size: Dp = 64.dp) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  Column(
    modifier.pressScale(interaction, 0.94f).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Box(
      Modifier.size(size).drawBehind {
        val stroke = 1.5.dp.toPx()
        drawCircle(colors.graphite.copy(alpha = .55f), radius = this.size.minDimension / 2 - stroke, style = Stroke(stroke, pathEffect = PathEffect.dashPathEffect(floatArrayOf(6.dp.toPx(), 5.dp.toPx()))))
      },
      contentAlignment = Alignment.Center,
    ) { RelevoIcon(KitIcon.AGREGAR, size = size * 0.36f, tint = colors.ink, background = colors.paper, strokeWidth = 1.8f) }
    Spacer(Modifier.height(8.dp))
    Text(label, style = Relevo.type.footnote.copy(fontWeight = FontWeight.Medium), color = colors.ink, textAlign = TextAlign.Center, modifier = Modifier.width(size + 22.dp))
  }
}

/**
 * El ancho y el estilo con que [label] cabe sin partir una palabra. Decide el trozo más largo que no se puede
 * cortar (una palabra, o las dos últimas que [sinViuda] une): si cabe en [preferredPx], todo sigue igual; si
 * no, el nombre se ensancha hasta [availablePx]; y si tampoco cabe ahí, la letra baja en proporción.
 */
internal fun labelFit(label: String, base: TextStyle, preferredPx: Int, availablePx: Int, measurer: TextMeasurer): Pair<Int, TextStyle> {
  if (availablePx <= 0 || availablePx == Constraints.Infinity) return preferredPx to base
  val widest = sinViuda(label).split(' ', '\n').filter { it.isNotEmpty() }
    .maxOfOrNull { measurer.measure(it, base, maxLines = 1, softWrap = false).size.width } ?: return preferredPx to base
  if (widest <= preferredPx) return preferredPx to base
  if (widest <= availablePx) return widest to base
  val factor = availablePx.toFloat() / widest * 0.97f
  return availablePx to base.copy(
    fontSize = base.fontSize * factor,
    lineHeight = if (base.lineHeight.isSpecified) base.lineHeight * factor else base.lineHeight,
  )
}

/**
 * Cuadrícula de anillos: [columns] por fila, repartidos de lado a lado. Las celdas que faltan en la última
 * fila quedan vacías para que todo se alinee.
 */
@Composable
fun <T> RingGrid(items: List<T>, modifier: Modifier = Modifier, columns: Int = 4, cell: @Composable (T) -> Unit) {
  Column(modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    items.chunked(columns).forEach { row ->
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
        row.forEach { item -> Box(Modifier.weight(1f), contentAlignment = Alignment.TopCenter) { cell(item) } }
        repeat(columns - row.size) { Spacer(Modifier.weight(1f)) }
      }
    }
  }
}
