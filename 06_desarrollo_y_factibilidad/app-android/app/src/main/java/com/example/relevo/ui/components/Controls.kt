package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import kotlinx.coroutines.delay

enum class ButtonKind { Primary, Secondary, Destructive }

/**
 * Botón del kit: 52 dp de alto, esquinas de 12, una acción principal por pantalla. Al presionar
 * se atenúa, como en iOS; no hay ondas ni rebotes.
 */
@Composable
fun RelevoButton(
  label: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  kind: ButtonKind = ButtonKind.Primary,
  enabled: Boolean = true,
  icon: KitIcon? = null,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val (container, content, border) = when {
    !enabled -> Triple(Color.Transparent, colors.gray, colors.line)
    kind == ButtonKind.Primary -> Triple(colors.ink, colors.onInk, colors.ink)
    kind == ButtonKind.Destructive -> Triple(Color.Transparent, colors.error, colors.error)
    else -> Triple(Color.Transparent, colors.ink, colors.ink)
  }
  val background by animateColorAsState(
    if (pressed && enabled) (if (kind == ButtonKind.Primary) container.copy(alpha = .82f) else colors.mist) else container,
    Motion.standard(120), label = "button_background",
  )
  Row(
    modifier.fillMaxWidth().heightIn(min = 52.dp).clip(Relevo.controlShape).background(background)
      .border(BorderStroke(1.5.dp, border), Relevo.controlShape)
      .clickable(interactionSource = interaction, indication = null, enabled = enabled, role = Role.Button, onClick = onClick)
      .padding(horizontal = 16.dp),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    if (icon != null) {
      RelevoIcon(icon, size = 20.dp, tint = content, background = if (kind == ButtonKind.Primary && enabled) colors.ink else colors.paper)
      Spacer(Modifier.width(10.dp))
    }
    Text(label, style = Relevo.type.button, color = content, textAlign = TextAlign.Center)
  }
}

/** Acción de texto en tinta, con área táctil de 48 dp. */
@Composable
fun PlainAction(
  label: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  color: Color = Relevo.colors.ink,
  icon: KitIcon? = null,
  enabled: Boolean = true,
) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  Row(
    modifier.heightIn(min = 48.dp).clip(Relevo.controlShape)
      .clickable(interactionSource = interaction, indication = null, enabled = enabled, role = Role.Button, onClick = onClick)
      .padding(horizontal = 2.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    val tint = if (!enabled) Relevo.colors.gray else color.copy(alpha = if (pressed) .55f else 1f)
    if (icon != null) {
      RelevoIcon(icon, size = 20.dp, tint = tint)
      Spacer(Modifier.width(8.dp))
    }
    Text(label, style = Relevo.type.headline, color = tint)
  }
}

/**
 * Control segmentado, como el de iOS pero con esquinas de 12. El segmento elegido va en tinta.
 * Tocar el elegido lo desmarca cuando la pregunta se puede omitir.
 */
@Composable
fun SegmentedControl(
  options: List<Pair<String, String>>,
  selected: String?,
  onSelect: (String?) -> Unit,
  modifier: Modifier = Modifier,
  allowDeselect: Boolean = true,
) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val index = options.indexOfFirst { it.first == selected }
  BoxWithConstraints(modifier.fillMaxWidth().height(48.dp).clip(Relevo.controlShape).background(colors.mist).padding(3.dp)) {
    val segment = maxWidth / options.size
    val offset by animateDpAsState(segment * index.coerceAtLeast(0), Motion.standard(Motion.SHORT), label = "segment_offset")
    if (index >= 0) {
      Box(Modifier.offset(x = offset).width(segment).fillMaxHeight().clip(RoundedCornerShape(10.dp)).background(colors.ink))
    }
    Row(Modifier.fillMaxWidth().fillMaxHeight()) {
      options.forEachIndexed { i, (value, label) ->
        val active = i == index
        val textColor by animateColorAsState(if (active) colors.onInk else colors.ink, Motion.standard(Motion.SHORT), label = "segment_text")
        Box(
          Modifier.weight(1f).fillMaxHeight().clip(RoundedCornerShape(10.dp))
            .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }, role = Role.RadioButton) {
              haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
              onSelect(if (active && allowDeselect) null else value)
            }
            .semantics { this.selected = active },
          contentAlignment = Alignment.Center,
        ) {
          Text(label, style = Relevo.type.subhead.copy(fontWeight = FontWeight.SemiBold), color = textColor, maxLines = 1)
        }
      }
    }
  }
}

/** Escala de 1 a 5 con sus extremos nombrados. */
@Composable
fun ScaleControl(value: Int?, onChange: (Int?) -> Unit, low: String = "Nada", high: String = "Mucho") {
  Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
    SegmentedControl((1..5).map { it.toString() to it.toString() }, value?.toString(), { onChange(it?.toInt()) })
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      Text("1 · $low", style = Relevo.type.footnote, color = Relevo.colors.graphite)
      Text("5 · $high", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
  }
}

/** Selector de tiempo con − y +. Mantener presionado repite el paso. */
@Composable
fun DurationStepper(seconds: Int, onChange: (Int) -> Unit, label: String) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  fun step(current: Int) = when {
    current < 10 * 60 -> 60
    current < 60 * 60 -> 5 * 60
    current < 120 * 60 -> 15 * 60
    else -> 30 * 60
  }
  fun decrease(current: Int) = (current - step(current - 1)).coerceAtLeast(60)
  fun increase(current: Int) = (current + step(current)).coerceAtMost(6 * 60 * 60)
  Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
    Column(Modifier.weight(1f)) {
      Text(formatDuration(seconds), style = Relevo.type.title, color = colors.ink)
      Text(label, style = Relevo.type.footnote, color = colors.graphite)
    }
    RepeatButton("Restar tiempo", "−", enabled = seconds > 60) { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onChange(decrease(seconds)) }
    Spacer(Modifier.width(10.dp))
    RepeatButton("Sumar tiempo", "+", enabled = seconds < 6 * 60 * 60) { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onChange(increase(seconds)) }
  }
}

@Composable
private fun RepeatButton(description: String, symbol: String, enabled: Boolean, onStep: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val colors = Relevo.colors
  LaunchedEffect(pressed) {
    if (!pressed || !enabled) return@LaunchedEffect
    delay(450)
    while (true) { onStep(); delay(110) }
  }
  Box(
    Modifier.size(52.dp).clip(Relevo.controlShape).background(if (pressed) colors.mist else Color.Transparent)
      .border(1.5.dp, if (enabled) colors.ink else colors.line, Relevo.controlShape)
      .clickable(interactionSource = interaction, indication = null, enabled = enabled, role = Role.Button, onClick = onStep)
      .semantics { contentDescription = description },
    contentAlignment = Alignment.Center,
  ) {
    Text(symbol, style = Relevo.type.title2, color = if (enabled) colors.ink else colors.gray)
  }
}

/** Opción rápida, como una etiqueta: esquinas de 10 y borde de 1,5. */
@Composable
fun QuickChoice(label: String, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier, icon: KitIcon? = null) {
  val colors = Relevo.colors
  val background by animateColorAsState(if (selected) colors.ink else Color.Transparent, Motion.standard(Motion.SHORT), label = "chip")
  val content = if (selected) colors.onInk else colors.ink
  Row(
    modifier.heightIn(min = 44.dp).clip(RoundedCornerShape(10.dp)).background(background)
      .border(1.5.dp, if (selected) colors.ink else colors.line, RoundedCornerShape(10.dp))
      .clickable(role = Role.Button, onClick = onClick).semantics { this.selected = selected }
      .padding(horizontal = 12.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    if (icon != null) {
      RelevoIcon(icon, size = 20.dp, tint = content, background = if (selected) colors.ink else colors.paper)
      Spacer(Modifier.width(8.dp))
    }
    Text(label, style = Relevo.type.subhead.copy(fontWeight = FontWeight.Medium), color = content, maxLines = 1)
  }
}

/** Casilla del kit: 22 dp, esquinas de 6. */
@Composable
fun CheckMark(checked: Boolean) {
  val colors = Relevo.colors
  Box(
    Modifier.size(22.dp).clip(RoundedCornerShape(6.dp)).background(if (checked) colors.ink else Color.Transparent)
      .border(1.75.dp, colors.ink, RoundedCornerShape(6.dp)),
    contentAlignment = Alignment.Center,
  ) {
    if (checked) RelevoIcon(KitIcon.COMENCE, size = 16.dp, tint = colors.onInk, background = colors.ink)
  }
}

/** Opción única del kit: círculo de 22 dp con punto de 12. */
@Composable
fun RadioMark(selected: Boolean) {
  val colors = Relevo.colors
  Box(Modifier.size(22.dp).border(1.75.dp, colors.ink, CircleShape), contentAlignment = Alignment.Center) {
    if (selected) Box(Modifier.size(12.dp).clip(CircleShape).background(colors.ink))
  }
}

internal fun formatDuration(seconds: Int): String = when {
  seconds < 60 -> "$seconds s"
  seconds % 3600 == 0 -> "${seconds / 3600} h"
  seconds > 3600 -> "${seconds / 3600} h ${(seconds % 3600) / 60} min"
  else -> "${seconds / 60} min"
}
