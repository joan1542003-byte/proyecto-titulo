package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/** Forma de las filas de la línea 3.2: 21 dp, como la de la lámina a escala. */
val RowShape = RoundedCornerShape(21.dp)

/**
 * Grupo de filas: un rótulo opcional (en tinta, como «Tus actividades» en la lámina) y las filas sueltas,
 * separadas por 9 dp.
 */
@Composable
fun ListSection(
  modifier: Modifier = Modifier,
  title: String? = null,
  footer: String? = null,
  content: @Composable ColumnScope.() -> Unit,
) {
  Column(modifier.fillMaxWidth()) {
    if (title != null) SectionLabel(title, Modifier.padding(bottom = 10.dp))
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(Gap.list), content = content)
    if (footer != null) {
      Text(footer, style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 10.dp))
    }
  }
}

/** Rótulo de un grupo: en tinta y seminegrita; la continuación opcional, en grafito («Intereses Elige una o varias.»). */
@Composable
fun SectionLabel(text: String, modifier: Modifier = Modifier, soft: String? = null) {
  val colors = Relevo.colors
  Text(
    androidx.compose.ui.text.buildAnnotatedString {
      append(text)
      if (!soft.isNullOrBlank()) {
        pushStyle(androidx.compose.ui.text.SpanStyle(color = colors.graphite, fontWeight = FontWeight.Medium)); append(" "); append(soft); pop()
      }
    },
    style = Relevo.type.headline, color = colors.ink,
    modifier = modifier.fillMaxWidth().semantics { heading() },
  )
}

/** Ícono de fila en su ficha (D-124, D-127): 45 dp, con el color de su papel; si no tiene papel, en piedra. */
@Composable
fun IconTile(icon: KitIcon, tint: Color = Relevo.colors.ink, size: Dp = 45.dp, background: Color? = null) {
  if (background != null) {
    Box(Modifier.size(size).clip(RoundedCornerShape(size * 0.31f)).background(background), contentAlignment = Alignment.Center) {
      RelevoIcon(icon, size = size * 0.58f, tint = if (tint == Relevo.colors.ink && background != Relevo.colors.mist && background != Relevo.colors.card) Relevo.colors.onTile else tint, background = background)
    }
  } else RoleTile(icon, size = size, tint = tint)
}

/**
 * Fila de la línea 3.2 («Relevo, la app»): una tarjeta blanca de 21 dp con la ficha de color a la
 * izquierda, el título en seminegrita y, debajo, el detalle en grafito. A la derecha, un valor, un control
 * o el galón que dice que se abre. Al presionar se oscurece apenas. [selected] la marca con un anillo de tinta.
 */
@Composable
fun ListRow(
  title: String,
  modifier: Modifier = Modifier,
  icon: KitIcon? = null,
  subtitle: String? = null,
  value: String? = null,
  valueIsVoice: Boolean = false,
  titleColor: Color = Relevo.colors.ink,
  iconTint: Color = Relevo.colors.ink,
  chevron: Boolean = false,
  onClick: (() -> Unit)? = null,
  leading: (@Composable () -> Unit)? = null,
  @Suppress("UNUSED_PARAMETER") leadingWidth: Dp = 45.dp,
  trailing: (@Composable RowScope.() -> Unit)? = null,
  @Suppress("UNUSED_PARAMETER") divider: Boolean = true,
  selected: Boolean = false,
  tileColor: Color? = null,
  /** Una fila sin fondo y con borde fino, para agregar algo («Agregar un paso»). */
  outlined: Boolean = false,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val base = if (outlined) Color.Transparent else colors.card
  val background by animateColorAsState(if (pressed && onClick != null) colors.mist else base, Motion.standard(90), label = "row")
  Row(
    modifier.fillMaxWidth().heightIn(min = 64.dp).pressScale(interaction, 0.985f)
      .then(if (outlined || colors.isDark) Modifier else Modifier.shadow(1.dp, RowShape, ambientColor = Color(0x0D1E160C), spotColor = Color(0x141E160C)))
      .clip(RowShape).background(background)
      .then(if (selected) Modifier.border(2.dp, colors.ink, RowShape) else if (outlined) Modifier.border(1.5.dp, colors.line, RowShape) else Modifier)
      .then(if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick) else Modifier)
      .then(if (selected) Modifier.semantics { stateDescription = "Elegido" } else Modifier)
      .padding(start = 10.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    when {
      leading != null -> { leading(); Spacer(Modifier.width(14.dp)) }
      icon != null -> { IconTile(icon, iconTint, background = tileColor); Spacer(Modifier.width(14.dp)) }
      else -> Spacer(Modifier.width(6.dp))
    }
    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(1.dp)) {
      Text(title, style = Relevo.type.headline, color = titleColor, maxLines = 3, overflow = TextOverflow.Ellipsis)
      if (subtitle != null) Text(subtitle, style = Relevo.type.subhead, color = colors.graphite)
    }
    if (value != null) {
      Spacer(Modifier.width(10.dp))
      Text(
        value, style = if (valueIsVoice) Relevo.type.subhead.copy(fontWeight = FontWeight.Medium) else Relevo.type.subhead,
        color = if (valueIsVoice) colors.ink else colors.graphite, textAlign = TextAlign.End, maxLines = 2, overflow = TextOverflow.Ellipsis,
        modifier = Modifier.widthIn(max = 160.dp),
      )
    }
    if (trailing != null) { Spacer(Modifier.width(10.dp)); trailing() }
    if (chevron) { Spacer(Modifier.width(8.dp)); RelevoIcon(KitIcon.ABRIR, size = 20.dp, tint = colors.graphite, background = colors.card, strokeWidth = 1.9f) }
  }
}

/** Dato con su rótulo, como en «Todo listo»: el dato en tinta y, debajo, qué es. Si se puede cambiar, lleva un lápiz. */
@Composable
fun FactRow(icon: KitIcon, label: String, value: String, @Suppress("UNUSED_PARAMETER") valueIsVoice: Boolean = true, leading: (@Composable () -> Unit)? = null, onClick: (() -> Unit)? = null) {
  ListRow(
    title = value.ifBlank { "Sin completar" }, subtitle = label, icon = icon, leading = leading,
    titleColor = if (value.isBlank()) Relevo.colors.graphite else Relevo.colors.ink, onClick = onClick,
    trailing = if (onClick != null) ({ RelevoIcon(KitIcon.EDITAR, size = 20.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card) }) else null,
  )
}

/**
 * Opción de una pregunta («¿Dónde suena?», «¿Qué decidiste?»): tarjeta blanca con borde fino, la ficha
 * opcional, el texto y un círculo a la derecha. La elegida lleva borde de tinta y el círculo lleno.
 */
@Composable
fun OptionRow(
  label: String,
  selected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  icon: KitIcon? = null,
  tileColor: Color? = null,
  subtitle: String? = null,
  enabled: Boolean = true,
) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val interaction = remember { MutableInteractionSource() }
  val ring by animateColorAsState(if (selected) colors.ink else colors.line, Motion.standard(Motion.SHORT), label = "option_ring")
  val width by animateDpAsState(if (selected) 2.dp else 1.5.dp, Motion.standard(Motion.SHORT), label = "option_width")
  Row(
    modifier.fillMaxWidth().heightIn(min = 60.dp).pressScale(interaction, 0.985f).clip(RoundedCornerShape(20.dp)).background(colors.card)
      .border(width, ring, RoundedCornerShape(20.dp))
      .clickable(interactionSource = interaction, indication = null, enabled = enabled, role = Role.RadioButton) {
        haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onClick()
      }
      .semantics { this.selected = selected }
      .padding(start = if (icon != null) 12.dp else 18.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    if (icon != null) {
      IconTile(icon, size = 38.dp, background = tileColor ?: (roleTint(icon) ?: colors.mist))
      Spacer(Modifier.width(13.dp))
    }
    Column(Modifier.weight(1f)) {
      Text(label, style = Relevo.type.body.copy(fontWeight = FontWeight.Medium, lineHeight = Relevo.type.headline.lineHeight), color = if (enabled || selected) colors.ink else colors.graphite)
      if (subtitle != null) Text(subtitle, style = Relevo.type.footnote, color = colors.graphite)
    }
    Spacer(Modifier.width(10.dp))
    RadioDot(selected)
  }
}

/** El círculo de una opción: vacío con borde fino; elegido, de tinta con un anillo blanco adentro. */
@Composable
fun RadioDot(selected: Boolean, size: Dp = 22.dp) {
  val colors = Relevo.colors
  val inner by animateDpAsState(if (selected) size * 0.42f else 0.dp, Motion.smooth(stiffness = 700f), label = "radio_inner")
  Box(
    Modifier.size(size).clip(CircleShape).background(if (selected) colors.ink else Color.Transparent)
      .border(1.5.dp, if (selected) colors.ink else colors.line, CircleShape),
    contentAlignment = Alignment.Center,
  ) {
    if (selected) {
      Box(Modifier.size(size - 7.dp).clip(CircleShape).background(colors.card), contentAlignment = Alignment.Center) {
        Box(Modifier.size(inner).clip(CircleShape).background(colors.ink))
      }
    }
  }
}

/**
 * Interruptor de la línea 3.2: cápsula de tinta encendido y de línea apagado, con el círculo blanco.
 */
@Composable
fun Toggle(checked: Boolean, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val track by animateColorAsState(if (checked) colors.ink else colors.line, Motion.standard(Motion.SHORT), label = "toggle_track")
  val knob by animateDpAsState(if (checked) 22.dp else 3.dp, Motion.smooth(stiffness = 700f), label = "toggle_knob")
  Box(modifier.width(48.dp).height(29.dp).clip(Relevo.controlShape).background(track)) {
    Box(Modifier.offset(x = knob, y = 3.dp).size(23.dp).clip(CircleShape).background(Color.White))
  }
}

/** Fila con interruptor: tocarla en cualquier parte lo cambia. */
@Composable
fun ToggleRow(title: String, checked: Boolean, onChange: (Boolean) -> Unit, modifier: Modifier = Modifier, icon: KitIcon? = null, subtitle: String? = null) {
  val haptics = LocalHapticFeedback.current
  ListRow(
    title, modifier.semantics { stateDescription = if (checked) "Encendido" else "Apagado" }, icon = icon, subtitle = subtitle,
    onClick = { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onChange(!checked) },
    trailing = { Toggle(checked) },
  )
}

enum class Tone { Info, Error }

/** Aviso: dice qué pasó y qué hacer, en una tarjeta como las filas. El de error va en un tinte rojo suave. */
@Composable
fun Notice(
  text: String,
  modifier: Modifier = Modifier,
  title: String? = null,
  icon: KitIcon = KitIcon.INFO,
  tone: Tone = Tone.Info,
  actions: (@Composable ColumnScope.() -> Unit)? = null,
) {
  val colors = Relevo.colors
  val error = tone == Tone.Error
  val background = if (error) colors.error.copy(alpha = if (colors.isDark) .14f else .07f) else colors.card
  Row(
    modifier.fillMaxWidth().clip(RowShape).background(background).padding(start = 10.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
    verticalAlignment = Alignment.Top,
  ) {
    Box(Modifier.size(45.dp).clip(RoundedCornerShape(14.dp)).background(if (error) colors.error.copy(alpha = .12f) else colors.mist), contentAlignment = Alignment.Center) {
      RelevoIcon(if (error) KitIcon.ERROR else icon, size = 24.dp, tint = if (error) colors.error else colors.ink, background = Color.Transparent)
    }
    Spacer(Modifier.width(14.dp))
    Column(Modifier.weight(1f).padding(top = 2.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
      if (title != null) Text(title, style = Relevo.type.headline, color = colors.ink)
      Text(text, style = Relevo.type.subhead, color = if (title != null) colors.graphite else colors.ink)
      if (actions != null) Column(Modifier.padding(top = 2.dp)) { actions() }
    }
  }
}

/**
 * Estado breve en cápsula blanca («Contando», «Después de la señal»), sin borde, como las etiquetas de la
 * lámina. [background] permite el color de un papel.
 */
@Composable
fun StatusChip(icon: KitIcon?, text: String, modifier: Modifier = Modifier, @Suppress("UNUSED_PARAMETER") onPanel: Boolean = false, background: Color? = null) {
  val colors = Relevo.colors
  val fill = background ?: colors.card
  val ink = if (background != null && background != colors.card) colors.onTile else colors.ink
  Row(
    modifier.heightIn(min = 30.dp).clip(Relevo.controlShape).background(fill)
      .then(if (background == null && !colors.isDark) Modifier.border(1.dp, colors.line.copy(alpha = .7f), Relevo.controlShape) else Modifier)
      .padding(horizontal = 12.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    if (icon == KitIcon.ERROR) {
      RelevoIcon(icon, size = 16.dp, tint = colors.error, background = fill)
      Spacer(Modifier.width(6.dp))
    }
    Text(text, style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold, fontSize = Relevo.type.subhead.fontSize * 0.93f), color = ink)
  }
}

/** Tarjeta blanca con esquinas amplias. */
@Composable
fun Panel(modifier: Modifier = Modifier, padding: Dp = 18.dp, content: @Composable ColumnScope.() -> Unit) {
  Column(modifier.fillMaxWidth().clip(Relevo.panelShape).background(Relevo.colors.card).padding(padding), verticalArrangement = Arrangement.spacedBy(9.dp), content = content)
}

/** Título de una sección con una acción opcional a la derecha: «Ideas · Ver todas». */
@Composable
fun SectionHeader(title: String, modifier: Modifier = Modifier, action: String? = null, onAction: (() -> Unit)? = null) {
  Row(modifier.fillMaxWidth().heightIn(min = 40.dp), verticalAlignment = Alignment.CenterVertically) {
    Text(title, style = Relevo.type.headline, color = Relevo.colors.ink, modifier = Modifier.weight(1f).semantics { heading() })
    if (action != null && onAction != null) PlainAction(action, onAction, color = Relevo.colors.graphite)
  }
}

@Composable
fun SectionGap() = Spacer(Modifier.height(Gap.section))

@Composable
internal fun Hairline(color: Color = Relevo.colors.line) = Box(Modifier.fillMaxWidth().height(1.dp).background(color))
