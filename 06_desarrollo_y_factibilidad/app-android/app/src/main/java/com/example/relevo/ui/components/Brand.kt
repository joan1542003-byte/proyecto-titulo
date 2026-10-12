package com.example.relevo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

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

/**
 * Color de la ficha de un ícono según su papel (D-124, D-127). Un color, un papel: mantequilla es tu
 * tiempo; cielo, el primer paso; lima, el lugar y lo que suena ahí; rubor, lo que decides; lila, tu
 * aura; durazno, lo que pasó después. Los objetos que suenan (Tag, teléfono) no tienen papel: van en
 * piedra, porque son el medio y no el fundamento.
 */
@Composable
fun roleTint(icon: KitIcon): Color? {
  val colors = Relevo.colors
  return when (icon) {
    KitIcon.TIEMPO, KitIcon.USO, KitIcon.APPS, KitIcon.ESPERANDO, KitIcon.PAUSAR -> colors.butter
    KitIcon.PRIMER_PASO, KitIcon.RUTA -> colors.sky
    KitIcon.LUGAR, KitIcon.SUENA -> colors.lime
    KitIcon.DECISION, KitIcon.COMENCE, KitIcon.CAMBIE -> colors.blush
    KitIcon.TEMA -> colors.lilac
    KitIcon.DESPUES, KitIcon.HISTORIAL -> colors.peach
    else -> null
  }
}

/** Ficha de color con su ícono en tinta: la pieza que dice qué hace Relevo. Sin papel, va en piedra. */
@Composable
fun RoleTile(icon: KitIcon, modifier: Modifier = Modifier, size: Dp = 30.dp, tint: Color? = null) {
  val colors = Relevo.colors
  val role = roleTint(icon)
  val background = role ?: colors.mist
  val ink = when {
    tint != null && tint != colors.ink -> tint
    role != null -> colors.onTile
    else -> colors.ink
  }
  Box(modifier.size(size).clip(RoundedCornerShape(size * 0.3f)).background(background), contentAlignment = Alignment.Center) {
    RelevoIcon(icon, size = size * 0.64f, tint = ink, background = background)
  }
}
