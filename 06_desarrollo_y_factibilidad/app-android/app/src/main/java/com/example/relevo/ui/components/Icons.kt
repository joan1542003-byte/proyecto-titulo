package com.example.relevo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cl.udp.relevo.R
import com.example.relevo.theme.Relevo

/**
 * Ícono de Relevo (D-124). El trazo cambia con el tamaño, como los tamaños ópticos de Material
 * Symbols: 16 → 2,0; 20 → 1,8; 24 → 1,6; 32 → 1,4; 48 → 1,3 (en unidades de la retícula de 24).
 * Los recortes («avisos», «ajustes») usan el color del fondo.
 */
@Composable
fun RelevoIcon(
  icon: KitIcon,
  modifier: Modifier = Modifier,
  size: Dp = 24.dp,
  tint: Color = Relevo.colors.ink,
  background: Color = Relevo.colors.paper,
  contentDescription: String? = null,
  /** Peso del kit: 1,5 regular, 1,8 medio, 2,1 semibold. Sin valor, el trazo sigue al tamaño. */
  strokeWidth: Float? = null,
) {
  val paths = remember(icon) { icon.shapes.map { PathParser().parsePathString(it.pathData).toPath() } }
  val stroke = strokeWidth ?: when {
    size <= 17.dp -> 2.0f
    size <= 21.dp -> 1.8f
    size <= 25.dp -> 1.6f
    size <= 33.dp -> 1.4f
    else -> 1.3f
  }
  val described = if (contentDescription != null) Modifier.semantics { this.contentDescription = contentDescription } else Modifier
  Canvas(modifier.size(size).then(described)) {
    scale(this.size.minDimension / 24f, pivot = androidx.compose.ui.geometry.Offset.Zero) {
      icon.shapes.forEachIndexed { index, shape ->
        val path = paths[index]
        when (shape.fill) {
          KitFill.INK -> drawPath(path, tint, style = Fill)
          KitFill.PAPER -> drawPath(path, background, style = Fill)
          KitFill.NONE -> Unit
        }
        if (shape.stroke) drawPath(path, tint, style = Stroke(width = stroke, cap = StrokeCap.Round, join = StrokeJoin.Round))
      }
    }
  }
}

/** Logotipo «relevo» en minúsculas (Chillax Semibold a trazos, D-125). Siempre en tinta o en blanco. */
@Composable
fun Wordmark(modifier: Modifier = Modifier, height: Dp = 22.dp, color: Color = Relevo.colors.ink) {
  Image(
    painter = painterResource(R.drawable.relevo_wordmark),
    contentDescription = "relevo",
    colorFilter = ColorFilter.tint(color),
    modifier = modifier.height(height).width(height * WORDMARK_ASPECT),
  )
}
