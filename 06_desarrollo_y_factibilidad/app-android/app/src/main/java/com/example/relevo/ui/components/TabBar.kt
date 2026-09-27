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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

/**
 * Barra de pestañas como la de iOS, plana sobre papel y con una línea fina arriba (sin vidrio: D-073).
 * Los destinos son sustantivos. La pestaña elegida va en tinta y con el trazo semibold del kit; al
 * elegirla, el icono se asienta con un leve cambio de escala.
 */
@Composable
fun TabBar(items: List<TabItem>, selected: Int, onSelect: (Int) -> Unit, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val reduce = rememberReduceMotion()
  Column(modifier.fillMaxWidth().background(colors.paper).navigationBarsPadding()) {
    Hairline()
    Row(Modifier.fillMaxWidth().height(58.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
      items.forEachIndexed { index, item ->
        val active = index == selected
        val tint by animateColorAsState(if (active) colors.ink else colors.graphite, Motion.standard(Motion.SHORT), label = "tab_tint")
        val bump = remember { Animatable(1f) }
        LaunchedEffect(active) {
          if (active && !reduce) {
            bump.snapTo(0.86f)
            bump.animateTo(1f, Motion.smooth(stiffness = 600f))
          }
        }
        Column(
          Modifier.weight(1f).fillMaxHeight()
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.Tab) {
              haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
              onSelect(index)
            }
            .semantics { this.selected = active },
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
        ) {
          RelevoIcon(
            item.icon, size = 26.dp, tint = tint, strokeWidth = if (active) 2.1f else 1.6f,
            modifier = Modifier.graphicsLayer { scaleX = bump.value; scaleY = bump.value },
          )
          Spacer(Modifier.height(3.dp))
          Text(item.label, style = Relevo.type.caption.copy(fontSize = 12.sp, fontWeight = if (active) FontWeight.SemiBold else FontWeight.Medium), color = tint)
        }
      }
    }
  }
}
