package com.example.relevo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * La marca de Relevo (D-125, D-127): cuatro luces que se pasan el turno, en el sentido del reloj
 * desde arriba: tu tiempo, tu primer paso, el lugar y lo que decides. Desde 48 dp lleva el degradado
 * «Luz»; en tamaños chicos va plana y con el corte más ancho, para que no se cierre. [color] la dibuja
 * en una sola tinta.
 */
@Composable
fun BrandMark(modifier: Modifier = Modifier, size: Dp = 48.dp, color: Color? = null, description: String? = null) {
  val small = size < 32.dp
  val paths = remember(small) { BrandLights.map { PathParser().parsePathString(if (small) it.smallPath else it.path).toPath() } }
  val gradient = color == null && size >= 48.dp
  Canvas(modifier.size(size).then(if (description != null) Modifier.semantics { contentDescription = description } else Modifier)) {
    scale(this.size.minDimension / 100f, pivot = Offset.Zero) {
      BrandLights.forEachIndexed { index, light ->
        val path = paths[index]
        when {
          color != null -> drawPath(path, color)
          gradient -> drawPath(path, Brush.radialGradient(*light.stops.toTypedArray(), center = light.center, radius = light.radius))
          else -> drawPath(path, light.color)
        }
      }
    }
  }
}
