package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
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
import androidx.compose.material3.Text
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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
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

/**
 * Barra de pestañas de la 4.0 (D-155): una cápsula de vidrio centrada, del ancho de sus tres destinos, y no
 * una tarjeta de borde a borde. El destino elegido va en tinta sobre una cápsula apenas marcada; los demás,
 * en grafito. Así pesa menos que el bloque negro de la 3.3 y deja ver más contenido.
 */
@Composable
fun TabBar(items: List<TabItem>, selected: Int, onSelect: (Int) -> Unit, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val reduce = rememberReduceMotion()
  Row(
    modifier.height(TabBarHeight)
      .then(if (colors.isDark) Modifier else Modifier.shadow(18.dp, Relevo.controlShape, ambientColor = Color.Black.copy(alpha = .05f), spotColor = Color.Black.copy(alpha = .14f)))
      .glass(Relevo.controlShape, blur = BarBlur).padding(5.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    items.forEachIndexed { index, item ->
      val active = index == selected
      val fill by animateColorAsState(if (active) colors.ink.copy(alpha = if (colors.isDark) .16f else .075f) else Color.Transparent, Motion.standard(Motion.SHORT), label = "tab_fill")
      val tint by animateColorAsState(if (active) colors.ink else colors.graphite, Motion.standard(Motion.SHORT), label = "tab_tint")
      val bump = remember { Animatable(1f) }
      LaunchedEffect(active) {
        if (active && !reduce) {
          bump.snapTo(0.92f)
          bump.animateTo(1f, Motion.smooth(stiffness = 600f))
        }
      }
      Column(
        Modifier.width(TabWidth).fillMaxHeight().clip(Relevo.controlShape).background(fill)
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Tab) {
            haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
            onSelect(index)
          }
          .semantics { this.selected = active }
          .graphicsLayer { scaleX = bump.value; scaleY = bump.value },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
      ) {
        RelevoIcon(item.icon, size = 22.dp, tint = tint, background = Color.Transparent, strokeWidth = if (active) 1.9f else 1.6f)
        Spacer(Modifier.height(2.dp))
        Text(item.label, style = Relevo.type.caption.copy(fontSize = 11.sp, fontWeight = if (active) FontWeight.SemiBold else FontWeight.Medium), color = tint, maxLines = 1)
      }
    }
  }
}
