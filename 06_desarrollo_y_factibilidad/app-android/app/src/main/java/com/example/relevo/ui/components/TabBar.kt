package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

/** Alto de la barra de pestañas. */
val TabBarHeight = 72.dp

/**
 * Barra de pestañas de «Relevo, la app» (3.2): una tarjeta de vidrio de 32 dp de radio, separada de los
 * bordes, con tres destinos repartidos. El elegido va en una ficha de tinta con su ícono y su nombre en
 * blanco; los demás, en grafito.
 */
@Composable
fun TabBar(items: List<TabItem>, selected: Int, onSelect: (Int) -> Unit, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val reduce = rememberReduceMotion()
  val shape = RoundedCornerShape(32.dp)
  Row(
    modifier.fillMaxWidth().height(TabBarHeight).glass(shape, blur = BarBlur).padding(8.dp),
    horizontalArrangement = Arrangement.SpaceAround,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    items.forEachIndexed { index, item ->
      val active = index == selected
      val fill by animateColorAsState(if (active) colors.ink else Color.Transparent, Motion.standard(Motion.SHORT), label = "tab_fill")
      val tint by animateColorAsState(if (active) colors.onInk else colors.graphite, Motion.standard(Motion.SHORT), label = "tab_tint")
      val bump = remember { Animatable(1f) }
      LaunchedEffect(active) {
        if (active && !reduce) {
          bump.snapTo(0.9f)
          bump.animateTo(1f, Motion.smooth(stiffness = 600f))
        }
      }
      Box(
        Modifier.clip(RoundedCornerShape(21.dp))
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Tab) {
            haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
            onSelect(index)
          }
          .semantics { this.selected = active }
          .padding(horizontal = 4.dp),
        contentAlignment = Alignment.Center,
      ) {
        Column(
          Modifier.widthIn(min = 84.dp).graphicsLayer { scaleX = bump.value; scaleY = bump.value }
            .clip(RoundedCornerShape(21.dp)).background(fill).padding(horizontal = 16.dp, vertical = 6.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          RelevoIcon(item.icon, size = 26.dp, tint = tint, background = Color.Transparent, strokeWidth = if (active) 1.9f else 1.6f)
          Spacer(Modifier.height(1.dp))
          Text(item.label, style = Relevo.type.caption.copy(fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold), color = tint)
        }
      }
    }
  }
}
