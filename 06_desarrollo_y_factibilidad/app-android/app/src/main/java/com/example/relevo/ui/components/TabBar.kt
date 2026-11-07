package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import kotlin.math.abs
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.relevo.theme.Relevo

data class TabItem(val label: String, val icon: KitIcon)

/** Alto de la barra de pestañas (4.0): 58 dp, 14 menos que en la 3.3. */
val TabBarHeight = 58.dp

/** Ancho de cada destino: suficiente para «Actividades» y para un dedo. */
private val TabWidth = 92.dp

/** Hasta dónde crecen los nombres de las pestañas con la letra del teléfono. */
private const val MaxLabelScale = 1.3f

/**
 * Barra de pestañas de la 4.0 (D-155): una cápsula de vidrio centrada, del ancho de sus tres destinos, y no
 * una tarjeta de borde a borde. El destino elegido va en tinta sobre una píldora apenas marcada; los demás,
 * en grafito. Así pesa menos que el bloque negro de la 3.3 y deja ver más contenido.
 *
 * Desde 4.3 (D-158) la píldora es una sola y se desplaza hasta el destino elegido, con un resorte casi sin
 * rebote: se ve viajar de una pestaña a otra, en vez de apagarse en una y encenderse en otra. Mientras va
 * rápido se estira un poco a lo ancho, como una gota, y vuelve a su forma al llegar.
 */
@Composable
fun TabBar(items: List<TabItem>, selected: Int, onSelect: (Int) -> Unit, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val reduce = rememberReduceMotion()
  val tabPx = with(LocalDensity.current) { TabWidth.toPx() }
  // 4.6.3: con letra al 200 %, «Actividades» se cortaba en «Activida». La barra mide siempre lo mismo, así que
  // sus nombres crecen con la letra del teléfono hasta 1,3 veces y no más, como las barras de iOS.
  val fontScale = LocalDensity.current.fontScale
  val labelSize = (11f * fontScale.coerceAtMost(MaxLabelScale) / fontScale).sp
  val offset = remember { Animatable(selected * tabPx) }
  LaunchedEffect(selected, tabPx) {
    if (reduce) offset.snapTo(selected * tabPx) else offset.animateTo(selected * tabPx, spring(dampingRatio = .86f, stiffness = 520f))
  }
  Box(
    modifier.height(TabBarHeight)
      .then(if (colors.isDark) Modifier else Modifier.shadow(10.dp, Relevo.controlShape, ambientColor = Color.Black.copy(alpha = .04f), spotColor = Color.Black.copy(alpha = .1f)))
      .glass(Relevo.controlShape, blur = BarBlur).padding(5.dp),
  ) {
    Box(
      Modifier.width(TabWidth).fillMaxHeight()
        .graphicsLayer {
          translationX = offset.value
          scaleX = 1f + (abs(offset.velocity) / (tabPx * 50f)).coerceAtMost(.1f)
        }
        .clip(Relevo.controlShape).background(colors.ink.copy(alpha = if (colors.isDark) .16f else .075f)),
    )
    Row(Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
      items.forEachIndexed { index, item ->
        val active = index == selected
        val tint by animateColorAsState(if (active) colors.ink else colors.graphite, Motion.standard(Motion.SHORT), label = "tab_tint")
        val bump = remember { Animatable(1f) }
        LaunchedEffect(active) {
          if (active && !reduce) {
            bump.snapTo(0.92f)
            bump.animateTo(1f, Motion.smooth(stiffness = 600f))
          }
        }
        // Responde al apoyar el dedo (se hunde) y, al elegir, el ícono da un pequeño salto, como los símbolos de
        // iOS. Cambiar de pestaña no vibra: es moverse, no confirmar algo (4.1, D-156).
        val interaction = remember { MutableInteractionSource() }
        Column(
          Modifier.width(TabWidth).fillMaxHeight().pressScale(interaction, 0.92f).clip(Relevo.controlShape)
            .clickable(interactionSource = interaction, indication = null, role = Role.Tab) { onSelect(index) }
            .semantics { this.selected = active }
            .graphicsLayer { scaleX = bump.value; scaleY = bump.value },
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
        ) {
          RelevoIcon(item.icon, size = 22.dp, tint = tint, background = Color.Transparent, strokeWidth = if (active) 1.9f else 1.6f)
          Spacer(Modifier.height(2.dp))
          Text(item.label, style = Relevo.type.caption.copy(fontSize = labelSize, fontWeight = if (active) FontWeight.SemiBold else FontWeight.Medium), color = tint, maxLines = 1)
        }
      }
    }
  }
}
