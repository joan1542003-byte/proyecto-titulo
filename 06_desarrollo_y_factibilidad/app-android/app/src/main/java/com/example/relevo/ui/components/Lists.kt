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
 * Sección agrupada, como las de iOS 26: título breve escrito como frase, tarjeta clara con esquinas
 * amplias y filas separadas por una línea fina que empieza después del icono.
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
    Column(
      Modifier.fillMaxWidth().clip(Relevo.panelShape).background(Relevo.colors.card)
        // Cada fila dibuja su línea arriba; se recorta la de la primera para que solo haya líneas entre filas.
        .layout { measurable, constraints ->
          val cut = 1.dp.roundToPx()
          val placeable = measurable.measure(constraints)
          layout(placeable.width, (placeable.height - cut).coerceAtLeast(0)) { placeable.place(0, -cut) }
        },
      content = content,
    )
    if (footer != null) {
      Text(footer, style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 8.dp))
    }
  }
}

/** Icono de fila: el trazo del kit, sin baldosa (nada de bloques cuadrados, D-083). */
@Composable
fun IconTile(icon: KitIcon, tint: Color = Relevo.colors.ink) {
  Box(Modifier.size(30.dp), contentAlignment = Alignment.Center) {
    RelevoIcon(icon, size = 22.dp, tint = tint, background = Relevo.colors.card)
  }
}

/** Fila del kit dentro de una sección: icono, texto, valor y destino. Al presionar se oscurece. */
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
  leadingWidth: Dp = 30.dp,
  trailing: (@Composable RowScope.() -> Unit)? = null,
  divider: Boolean = true,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val background by animateColorAsState(if (pressed) colors.line.copy(alpha = .55f) else Color.Transparent, Motion.standard(90), label = "row")
  val hasLeading = leading != null || icon != null
  val inset = if (hasLeading) 18.dp + leadingWidth + 14.dp else 18.dp
  Row(
    modifier.fillMaxWidth().heightIn(min = 54.dp).background(background)
      .drawBehind { if (divider) drawLine(colors.line, Offset(inset.toPx(), 0f), Offset(size.width, 0f), strokeWidth = 1.dp.toPx()) }
      .then(if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick) else Modifier)
      .padding(start = 18.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
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
          Text(title, style = Relevo.type.body, color = titleColor)
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

/** Dato con su rótulo, para resúmenes: «Cómo empieza · Abrir el libro». Lo que escribió la persona va en azul. */
@Composable
fun FactRow(icon: KitIcon, label: String, value: String, valueIsVoice: Boolean = true, onClick: (() -> Unit)? = null) {
  ListRow(title = label, icon = icon, value = value, valueIsVoice = valueIsVoice, titleColor = Relevo.colors.graphite, chevron = onClick != null, onClick = onClick)
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
    Box(Modifier.size(36.dp).clip(CircleShape).background(if (error) colors.error.copy(alpha = .12f) else colors.mist), contentAlignment = Alignment.Center) {
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
  val background = if (onPanel) colors.paper else colors.mist
  Row(
    modifier.background(background, Relevo.controlShape).padding(horizontal = 12.dp, vertical = 7.dp),
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
