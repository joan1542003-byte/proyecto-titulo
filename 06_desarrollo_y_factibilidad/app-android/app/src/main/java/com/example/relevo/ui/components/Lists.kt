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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * Sección de lista, como las de iOS pero sobre papel: rótulo en mayúsculas pequeñas, filas
 * separadas por una línea fina y una nota opcional al pie.
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
      Text(title.uppercase(), style = Relevo.type.label, color = Relevo.colors.graphite, modifier = Modifier.padding(bottom = 8.dp))
    }
    content()
    HorizontalDivider(thickness = 1.dp, color = Relevo.colors.line)
    if (footer != null) {
      Text(footer, style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(top = 8.dp))
    }
  }
}

/** Fila del kit: icono, texto y destino. Al presionar se ilumina en niebla. */
@Composable
fun ListRow(
  title: String,
  modifier: Modifier = Modifier,
  icon: KitIcon? = null,
  subtitle: String? = null,
  value: String? = null,
  valueIsVoice: Boolean = false,
  titleColor: Color = Relevo.colors.ink,
  chevron: Boolean = false,
  onClick: (() -> Unit)? = null,
  leading: (@Composable () -> Unit)? = null,
  trailing: (@Composable RowScope.() -> Unit)? = null,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val background by animateColorAsState(if (pressed) colors.mist else Color.Transparent, Motion.standard(100), label = "row")
  Column(modifier.fillMaxWidth()) {
    HorizontalDivider(thickness = 1.dp, color = colors.line)
    Row(
      Modifier.fillMaxWidth().heightIn(min = 56.dp).background(background)
        .then(if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick) else Modifier)
        .padding(vertical = 10.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      when {
        leading != null -> { leading(); Spacer(Modifier.width(14.dp)) }
        icon != null -> { RelevoIcon(icon, tint = colors.ink); Spacer(Modifier.width(14.dp)) }
      }
      Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(title, style = Relevo.type.body, color = titleColor)
        if (subtitle != null) Text(subtitle, style = Relevo.type.footnote, color = colors.graphite)
      }
      if (value != null) {
        Spacer(Modifier.width(12.dp))
        Text(
          value, style = if (valueIsVoice) Relevo.type.body.copy(fontWeight = FontWeight.Medium) else Relevo.type.body,
          color = if (valueIsVoice) colors.voice else colors.graphite, textAlign = TextAlign.End,
          maxLines = 2, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f, fill = false),
        )
      }
      if (trailing != null) { Spacer(Modifier.width(12.dp)); trailing() }
      if (chevron) { Spacer(Modifier.width(8.dp)); RelevoIcon(KitIcon.SIGUIENTE, size = 20.dp, tint = colors.graphite) }
    }
  }
}

/** Dato con su rótulo, para resúmenes: «Cómo empieza · Abrir el libro». */
@Composable
fun FactRow(icon: KitIcon, label: String, value: String, valueIsVoice: Boolean = true, onClick: (() -> Unit)? = null) {
  ListRow(title = label, icon = icon, value = value, valueIsVoice = valueIsVoice, titleColor = Relevo.colors.graphite, chevron = onClick != null, onClick = onClick)
}

enum class Tone { Info, Error }

/** Aviso del kit: dice qué pasó y qué hacer. El de error lleva borde rojo; nunca se usa para errores de la persona. */
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
  val accent = if (tone == Tone.Error) colors.error else colors.ink
  Row(
    modifier.fillMaxWidth().border(BorderStroke(1.5.dp, if (tone == Tone.Error) colors.error else colors.line), Relevo.controlShape).padding(14.dp),
    verticalAlignment = Alignment.Top,
  ) {
    RelevoIcon(if (tone == Tone.Error) KitIcon.ERROR else icon, tint = accent)
    Spacer(Modifier.width(12.dp))
    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
      if (title != null) Text(title, style = Relevo.type.headline, color = colors.ink)
      Text(text, style = Relevo.type.subhead, color = if (title != null) colors.graphite else colors.ink)
      if (actions != null) Column(Modifier.padding(top = 2.dp)) { actions() }
    }
  }
}

/** Estado breve: «Esperando», «Sonando». */
@Composable
fun StatusChip(icon: KitIcon, text: String, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  Row(
    modifier.background(colors.mist, RoundedCornerShape(8.dp)).padding(horizontal = 10.dp, vertical = 6.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    RelevoIcon(icon, size = 16.dp, tint = colors.ink, background = colors.mist)
    Spacer(Modifier.width(8.dp))
    Text(text, style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold), color = colors.ink)
  }
}

/** Panel de niebla con esquinas de 20. */
@Composable
fun Panel(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
  Column(modifier.fillMaxWidth().background(Relevo.colors.mist, Relevo.panelShape).padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp), content = content)
}

@Composable
fun SectionGap() = Spacer(Modifier.height(28.dp))

@Composable
internal fun Hairline() = Box(Modifier.fillMaxWidth().height(1.dp).background(Relevo.colors.line))
