package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * Sección: título breve escrito como frase y, debajo, filas sueltas en tarjetas blancas (3.1).
 */
@Composable
fun ListSection(
  modifier: Modifier = Modifier,
  title: String? = null,
  footer: String? = null,
  content: @Composable ColumnScope.() -> Unit,
) {
  Column(modifier.fillMaxWidth()) {
    if (title != null) {
      Text(title, style = Relevo.type.section, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, bottom = 8.dp).semantics { heading() })
    }
    // 3.1: cada fila es su propia tarjeta, separadas por 8 dp, como en «Relevo, la app».
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp), content = content)
    if (footer != null) {
      Text(footer, style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 8.dp))
    }
  }
}

/**
 * Ícono de fila en su ficha (3.0): una cápsula redondeada con el color de su papel (D-124, D-127) y el
 * ícono en tinta; si el ícono no tiene papel, la ficha es de piedra. Un color, un papel.
 */
@Composable
fun IconTile(icon: KitIcon, tint: Color = Relevo.colors.ink) {
  RoleTile(icon, size = 38.dp, tint = tint)
}

/** Fila en su tarjeta: ficha de color, texto, valor y destino. Al presionar se oscurece. */
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
  leadingWidth: Dp = 38.dp,
  trailing: (@Composable RowScope.() -> Unit)? = null,
  divider: Boolean = true,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val background by animateColorAsState(if (pressed) colors.mist else colors.card, Motion.standard(90), label = "row")
  Row(
    modifier.fillMaxWidth().heightIn(min = 62.dp).pressScale(interaction, 0.985f).clip(RoundedCornerShape(20.dp)).background(background)
      .then(if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick) else Modifier)
      .padding(start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    when {
      leading != null -> { leading(); Spacer(Modifier.width(14.dp)) }
      icon != null -> { IconTile(icon, iconTint); Spacer(Modifier.width(14.dp)) }
    }
    TitleAndValue(
      Modifier.weight(1f),
      title = {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
          Text(title, style = Relevo.type.callout.copy(fontWeight = FontWeight.SemiBold), color = titleColor)
          if (subtitle != null) Text(subtitle, style = Relevo.type.footnote, color = colors.graphite)
        }
      },
      value = value?.let {
        {
          Text(
            it, style = if (valueIsVoice) Relevo.type.body.copy(fontWeight = FontWeight.Medium) else Relevo.type.body,
            color = if (valueIsVoice) colors.voice else colors.graphite, textAlign = TextAlign.End,
            maxLines = 2, overflow = TextOverflow.Ellipsis,
          )
        }
      },
    )
    if (trailing != null) { Spacer(Modifier.width(12.dp)); trailing() }
    if (chevron) { Spacer(Modifier.width(6.dp)); RelevoIcon(KitIcon.SIGUIENTE, size = 16.dp, tint = colors.gray, background = colors.card, strokeWidth = 2.2f) }
  }
}

/**
 * Rótulo a la izquierda y valor a la derecha, como en las filas de iOS: el rótulo conserva su ancho
 * natural (hasta el 58 %) y el valor usa el resto, alineado al final. Así el rótulo no se parte en dos
 * líneas por un valor largo.
 */
@Composable
private fun TitleAndValue(modifier: Modifier, title: @Composable () -> Unit, value: (@Composable () -> Unit)?) {
  if (value == null) {
    Box(modifier) { title() }
    return
  }
  Layout(contents = listOf(title, value), modifier = modifier) { (titles, values), constraints ->
    val gap = 12.dp.roundToPx()
    val width = constraints.maxWidth
    val available = (width - gap).coerceAtLeast(0)
    val titleMeasurable = titles.first()
    val valueMeasurable = values.first()
    val titleNatural = titleMeasurable.maxIntrinsicWidth(Constraints.Infinity)
    val cap = (available * 0.58f).toInt()
    val titleWidth = if (titleNatural + valueMeasurable.maxIntrinsicWidth(Constraints.Infinity) <= available) titleNatural else minOf(titleNatural, cap)
    val titlePlaceable = titleMeasurable.measure(Constraints(maxWidth = titleWidth.coerceAtLeast(0)))
    val valuePlaceable = valueMeasurable.measure(Constraints(maxWidth = (available - titlePlaceable.width).coerceAtLeast(0)))
    val height = maxOf(titlePlaceable.height, valuePlaceable.height, constraints.minHeight)
    layout(width, height) {
      titlePlaceable.place(0, (height - titlePlaceable.height) / 2)
      valuePlaceable.place(width - valuePlaceable.width, (height - valuePlaceable.height) / 2)
    }
  }
}

/** Dato con su rótulo, como en «Relevo, la app»: el dato en tinta y, debajo, qué es. Si se puede cambiar, lleva un lápiz. */
@Composable
@Suppress("UNUSED_PARAMETER")
fun FactRow(icon: KitIcon, label: String, value: String, valueIsVoice: Boolean = true, onClick: (() -> Unit)? = null) {
  ListRow(
    title = value.ifBlank { "Sin completar" }, subtitle = label, icon = icon,
    titleColor = if (value.isBlank()) Relevo.colors.graphite else Relevo.colors.ink, onClick = onClick,
    trailing = if (onClick != null) ({ RelevoIcon(KitIcon.EDITAR, size = 18.dp, tint = Relevo.colors.graphite, background = Relevo.colors.card) }) else null,
  )
}

enum class Tone { Info, Error }

/** Aviso: dice qué pasó y qué hacer. El de error va en un tinte rojo suave; nunca se usa para errores de la persona. */
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
    modifier.fillMaxWidth().clip(Relevo.panelShape).background(background).padding(18.dp),
    verticalAlignment = Alignment.Top,
  ) {
    Box(Modifier.size(38.dp).clip(RoundedCornerShape(11.dp)).background(if (error) colors.error.copy(alpha = .12f) else colors.mist), contentAlignment = Alignment.Center) {
      RelevoIcon(if (error) KitIcon.ERROR else icon, size = 20.dp, tint = if (error) colors.error else colors.ink, background = Color.Transparent)
    }
    Spacer(Modifier.width(14.dp))
    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
      if (title != null) Text(title, style = Relevo.type.headline, color = colors.ink)
      Text(text, style = Relevo.type.subhead, color = if (title != null) colors.graphite else colors.ink)
      if (actions != null) Column(Modifier.padding(top = 2.dp)) { actions() }
    }
  }
}

/** Estado breve en cápsula: «Esperando», «Suena en el parlante». Sobre una tarjeta, va en papel. */
@Composable
fun StatusChip(icon: KitIcon, text: String, modifier: Modifier = Modifier, onPanel: Boolean = false) {
  val colors = Relevo.colors
  val background = if (onPanel) colors.card else colors.card
  Row(
    modifier.background(background, Relevo.controlShape).border(1.dp, colors.line, Relevo.controlShape).padding(horizontal = 12.dp, vertical = 7.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    RelevoIcon(icon, size = 16.dp, tint = colors.ink, background = background)
    Spacer(Modifier.width(8.dp))
    Text(text, style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold), color = colors.ink)
  }
}

/** Tarjeta clara con esquinas amplias. */
@Composable
fun Panel(modifier: Modifier = Modifier, padding: Dp = 20.dp, content: @Composable ColumnScope.() -> Unit) {
  Column(modifier.fillMaxWidth().clip(Relevo.panelShape).background(Relevo.colors.card).padding(padding), verticalArrangement = Arrangement.spacedBy(8.dp), content = content)
}

/** Título de una sección con una acción opcional a la derecha: «Ideas · Ver todas». */
@Composable
fun SectionHeader(title: String, modifier: Modifier = Modifier, action: String? = null, onAction: (() -> Unit)? = null) {
  Row(modifier.fillMaxWidth().heightIn(min = 48.dp), verticalAlignment = Alignment.CenterVertically) {
    Text(title, style = Relevo.type.title2, color = Relevo.colors.ink, modifier = Modifier.weight(1f).semantics { heading() })
    if (action != null && onAction != null) PlainAction(action, onAction, color = Relevo.colors.graphite)
  }
}

@Composable
fun SectionGap() = Spacer(Modifier.height(28.dp))

@Composable
internal fun Hairline(color: Color = Relevo.colors.line) = Box(Modifier.fillMaxWidth().height(1.dp).background(color))
