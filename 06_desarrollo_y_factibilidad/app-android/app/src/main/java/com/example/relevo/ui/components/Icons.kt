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
 * Icono del kit D-073. El trazo cambia con el tamaño, como pide el manual: 16 → 1,9;
 * 20 → 1,8; 24 → 1,75; 32 → 1,6; 48 → 1,5 (en unidades de la retícula de 24).
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
) {
  val paths = remember(icon) { icon.shapes.map { PathParser().parsePathString(it.pathData).toPath() } }
  val stroke = when {
    size <= 16.dp -> 1.9f
    size <= 20.dp -> 1.8f
    size <= 24.dp -> 1.75f
    size <= 32.dp -> 1.6f
    else -> 1.5f
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

/** Logotipo «relevo» en minúsculas (Schibsted Grotesk 650). Mínimo 64 px de ancho. */
@Composable
fun Wordmark(modifier: Modifier = Modifier, height: Dp = 22.dp, color: Color = Relevo.colors.ink) {
  Image(
    painter = painterResource(R.drawable.relevo_wordmark),
    contentDescription = "relevo",
    colorFilter = ColorFilter.tint(color),
    modifier = modifier.height(height).width(height * (5910f / 1526f)),
  )
}
