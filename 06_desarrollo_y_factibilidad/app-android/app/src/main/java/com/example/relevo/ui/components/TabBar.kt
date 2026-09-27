package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.snap
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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

/** Alto de la barra de pestañas flotante. */
val TabBarHeight = 64.dp

/**
 * Barra de pestañas de iOS 26: una cápsula de vidrio que flota sobre el contenido, separada de los
 * bordes. Una cápsula más clara marca el destino elegido y se desliza al cambiar, sin rebote. Los
 * destinos llevan icono y nombre.
 */
@Composable
fun TabBar(items: List<TabItem>, selected: Int, onSelect: (Int) -> Unit, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val reduce = rememberReduceMotion()
  BoxWithConstraints(modifier.fillMaxWidth().height(TabBarHeight).glass(Relevo.controlShape, blur = BarBlur).padding(5.dp)) {
    val segment = maxWidth / items.size
    val offset by animateDpAsState(segment * selected, if (reduce) snap() else Motion.smooth(stiffness = 420f), label = "tab_indicator")
    Box(
      Modifier.offset(x = offset).width(segment).fillMaxHeight().clip(Relevo.controlShape)
        .background(if (colors.isDark) Color.White.copy(alpha = .10f) else colors.ink.copy(alpha = .07f)),
    )
    Row(Modifier.fillMaxWidth().fillMaxHeight()) {
      items.forEachIndexed { index, item ->
        val active = index == selected
        val tint by animateColorAsState(if (active) colors.ink else colors.graphite, Motion.standard(Motion.SHORT), label = "tab_tint")
        val bump = remember { Animatable(1f) }
        LaunchedEffect(active) {
          if (active && !reduce) {
            bump.snapTo(0.84f)
            bump.animateTo(1f, Motion.smooth(stiffness = 600f))
          }
        }
        Column(
          Modifier.weight(1f).fillMaxHeight().clip(Relevo.controlShape)
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Tab) {
              haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
              onSelect(index)
            }
            .semantics { this.selected = active },
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
        ) {
          RelevoIcon(
            item.icon, size = 24.dp, tint = tint, background = Color.Transparent, strokeWidth = if (active) 2.1f else 1.7f,
            modifier = Modifier.graphicsLayer { scaleX = bump.value; scaleY = bump.value },
          )
          Spacer(Modifier.height(2.dp))
          Text(item.label, style = Relevo.type.caption.copy(fontSize = 11.sp, fontWeight = if (active) FontWeight.SemiBold else FontWeight.Medium), color = tint)
        }
      }
    }
  }
}
