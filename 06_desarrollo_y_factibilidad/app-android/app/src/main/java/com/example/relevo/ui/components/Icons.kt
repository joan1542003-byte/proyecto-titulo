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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import android.graphics.PathMeasure
import kotlin.math.max
import kotlin.math.min
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
 * Los recortes («avisos», «ajustes») usan el color del fondo. Desde la 4.1 cada ícono se dibuja al centro
 * óptico de su retícula ([kitGeometry]).
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
  val geometry = remember(icon) { kitGeometry(icon) }
  val stroke = strokeWidth ?: opticalStroke(size)
  val described = if (contentDescription != null) Modifier.semantics { this.contentDescription = contentDescription } else Modifier
  Canvas(modifier.size(size).then(described)) {
    drawKitIcon(icon, geometry, this.size.minDimension, tint, background, stroke)
  }
}

/** El trazo según el tamaño en pantalla, en unidades de la retícula de 24. */
internal fun opticalStroke(size: Dp): Float = when {
  size <= 17.dp -> 2.0f
  size <= 21.dp -> 1.8f
  size <= 25.dp -> 1.6f
  size <= 33.dp -> 1.4f
  else -> 1.3f
}

/** Los trazados de un ícono, leídos una vez, y cuánto moverlo para que quede al centro. */
internal class KitGeometry(val paths: List<Path>, val shift: Offset)

private val geometries = HashMap<KitIcon, KitGeometry>()

/**
 * Trazados y centro óptico de un ícono (4.1, D-156). Varios íconos del kit no estaban al centro de su
 * retícula de 24: la campana bajaba 1,6 unidades por su badajo, la escalera 1,25, la bicicleta y el
 * control 1,1 y el pincel subía 1,1. Dentro de un círculo eso se veía chueco. Se centra por la caja del
 * dibujo y se suma un cuarto de la distancia al centro de la tinta, con un tope de 0,6: una figura pesada
 * abajo no se ve caída y una simétrica no se mueve. Se calcula una vez por ícono.
 */
internal fun kitGeometry(icon: KitIcon): KitGeometry = geometries.getOrPut(icon) {
  val paths = icon.shapes.map { PathParser().parsePathString(it.pathData).toPath() }
  KitGeometry(paths, opticalShift(icon, paths))
}

private fun opticalShift(icon: KitIcon, paths: List<Path>): Offset {
  var left = Float.MAX_VALUE
  var top = Float.MAX_VALUE
  var right = -Float.MAX_VALUE
  var bottom = -Float.MAX_VALUE
  var sumX = 0.0
  var sumY = 0.0
  var weight = 0.0
  val measure = PathMeasure()
  val position = FloatArray(2)
  icon.shapes.forEachIndexed { index, shape ->
    val path = paths[index]
    val bounds = path.getBounds()
    left = min(left, bounds.left); top = min(top, bounds.top); right = max(right, bounds.right); bottom = max(bottom, bounds.bottom)
    if (shape.fill == KitFill.INK && !shape.stroke) {
      // Un punto lleno pesa como su superficie.
      val area = max(bounds.width * bounds.height, 0.5f) * 2f
      sumX += bounds.center.x * area; sumY += bounds.center.y * area; weight += area
    } else {
      measure.setPath(path.asAndroidPath(), false)
      do {
        val length = measure.length
        var distance = 0f
        while (distance < length) {
          val piece = min(0.25f, length - distance)
          measure.getPosTan(distance + piece / 2f, position, null)
          sumX += position[0] * piece; sumY += position[1] * piece; weight += piece
          distance += 0.25f
        }
      } while (measure.nextContour())
    }
  }
  if (weight == 0.0 || left > right) return Offset.Zero
  val boxX = (left + right) / 2f - 12f
  val boxY = (top + bottom) / 2f - 12f
  val inkX = (sumX / weight).toFloat() - 12f
  val inkY = (sumY / weight).toFloat() - 12f
  val x = boxX + ((inkX - boxX) * 0.25f).coerceIn(-0.6f, 0.6f)
  val y = boxY + ((inkY - boxY) * 0.25f).coerceIn(-0.6f, 0.6f)
  return Offset(-x, -y)
}

/** Dibuja un ícono en un cuadrado de [side] px que empieza en el origen, ya centrado. */
internal fun DrawScope.drawKitIcon(icon: KitIcon, geometry: KitGeometry, side: Float, tint: Color, background: Color, stroke: Float) {
  scale(side / 24f, pivot = Offset.Zero) {
    translate(geometry.shift.x, geometry.shift.y) {
      icon.shapes.forEachIndexed { index, shape ->
        val path = geometry.paths[index]
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
