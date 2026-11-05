package com.example.relevo.ui.components

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

private val Ink = Color(0xFF141312)

/**
 * El anillo de una actividad (4.0, D-155): un círculo blanco con su ícono en tinta, rodeado por un anillo
 * con el color de su familia. Es la única pieza de color de la interfaz: el color dice qué actividad es, y
 * todo lo demás va en papel y tinta. Nace del selector de íconos de la 3.3, que el autor prefirió a las
 * fichas de cielo con cápsula.
 */
@Composable
fun ActivityRing(icon: KitIcon, size: Dp, modifier: Modifier = Modifier, variant: Int = 0, description: String? = null) {
  val sky = skyFor(icon)
  val ring = (size * 0.075f).coerceAtLeast(2.5.dp)
  Box(
    modifier.size(size).clip(CircleShape).drawBehind { drawSky(sky, grain = size >= 48.dp, variant = variant) }
      .then(if (description != null) Modifier.semantics { contentDescription = description } else Modifier),
    contentAlignment = Alignment.Center,
  ) {
    // En el tema oscuro, el círculo es apenas tibio para no encandilar; el ícono sigue en tinta.
    val disc = if (Relevo.colors.isDark) Color(0xFFECE7E1) else Color.White
    Box(Modifier.size(size - ring * 2).clip(CircleShape).background(disc), contentAlignment = Alignment.Center) {
      RelevoIcon(icon, size = size * 0.42f, tint = Ink, background = disc)
    }
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
  variant: Int = 0,
  selected: Boolean = false,
  count: Int? = null,
  description: String = label.orEmpty(),
) {
  val interaction = remember { MutableInteractionSource() }
  Column(
    modifier
      .then(
        if (onClick != null) Modifier.pressScale(interaction, 0.94f)
          .clickable(interactionSource = interaction, indication = null, role = if (label == null) Role.RadioButton else Role.Button, onClick = onClick)
        else Modifier,
      )
      .semantics(mergeDescendants = true) { if (onClick != null) this.selected = selected; contentDescription = description },
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Box(Modifier.size(size).outerRing(selected, size / 2, Relevo.colors.ink, gap = 3.dp, width = 2.dp)) {
      ActivityRing(icon, size, variant = variant)
      if (count != null && count > 1) {
        Box(
          Modifier.align(Alignment.TopEnd).offset(x = 4.dp, y = (-2).dp).size(22.dp).clip(CircleShape).background(Relevo.colors.ink),
          contentAlignment = Alignment.Center,
        ) { Text("$count", style = Relevo.type.caption.copy(fontWeight = FontWeight.SemiBold), color = Relevo.colors.onInk) }
      }
    }
    if (label != null) {
      Spacer(Modifier.height(8.dp))
      Text(
        label, style = Relevo.type.footnote.copy(fontWeight = FontWeight.Medium, lineHeight = Relevo.type.footnote.lineHeight),
        color = Relevo.colors.ink, textAlign = TextAlign.Center, maxLines = 2, overflow = TextOverflow.Ellipsis,
        modifier = Modifier.width(size + 22.dp),
      )
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
