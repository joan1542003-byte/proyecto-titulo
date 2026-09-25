package com.example.relevo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * El renglón del manual: la línea en tinta y, encima, lo que escribe la persona en azul.
 * En reposo la línea mide 1,5 dp; con foco, 2 dp y azul. El ejemplo va en grafito.
 */
@Composable
fun RenglonField(
  label: String,
  value: String,
  onValueChange: (String) -> Unit,
  modifier: Modifier = Modifier,
  placeholder: String = "",
  singleLine: Boolean = true,
  imeAction: ImeAction = ImeAction.Done,
  onImeAction: () -> Unit = {},
  maxLength: Int = 120,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val focused by interaction.collectIsFocusedAsState()
  val lineColor by animateColorAsState(if (focused) colors.voice else colors.ink, Motion.standard(Motion.SHORT), label = "renglon_line")
  val lineWidth by animateDpAsState(if (focused) 2.dp else 1.5.dp, Motion.standard(Motion.SHORT), label = "renglon_width")
  Column(modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp)) {
    Text(label, style = Relevo.type.footnote.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Medium), color = colors.graphite)
    BasicTextField(
      value = value,
      onValueChange = { onValueChange(it.take(maxLength)) },
      singleLine = singleLine,
      textStyle = Relevo.type.voice.copy(color = colors.voice),
      cursorBrush = SolidColor(colors.voice),
      interactionSource = interaction,
      keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences, imeAction = imeAction),
      keyboardActions = KeyboardActions(onAny = { onImeAction() }),
      modifier = Modifier.fillMaxWidth().heightIn(min = 40.dp).drawBehind {
        val y = size.height - lineWidth.toPx() / 2
        drawLine(lineColor, Offset(0f, y), Offset(size.width, y), strokeWidth = lineWidth.toPx())
      }.padding(bottom = 8.dp),
      decorationBox = { inner ->
        Box {
          if (value.isEmpty() && placeholder.isNotEmpty()) Text(placeholder, style = Relevo.type.voice.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Normal), color = colors.graphite)
          inner()
        }
      },
    )
  }
}

/** Buscador sobre niebla, como el de las listas de iOS. */
@Composable
fun SearchField(value: String, onValueChange: (String) -> Unit, placeholder: String, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  Row(
    modifier.fillMaxWidth().heightIn(min = 44.dp).background(colors.mist, Relevo.controlShape).padding(horizontal = 12.dp),
    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
  ) {
    RelevoIcon(KitIcon.BUSCAR, size = 20.dp, tint = colors.graphite, background = colors.mist)
    Spacer(Modifier.width(8.dp))
    BasicTextField(
      value = value,
      onValueChange = onValueChange,
      singleLine = true,
      textStyle = Relevo.type.body.copy(color = colors.ink),
      cursorBrush = SolidColor(colors.voice),
      keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
      modifier = Modifier.weight(1f),
      decorationBox = { inner ->
        Box {
          if (value.isEmpty()) Text(placeholder, style = Relevo.type.body, color = colors.graphite)
          inner()
        }
      },
    )
  }
}

/**
 * La firma con las palabras de la persona: «Vuelve a leer.». Lo escrito aparece sobre el renglón
 * en 450 ms, la única animación de marca; sin animación si Android la desactiva.
 */
@Composable
fun Signature(words: String, modifier: Modifier = Modifier, style: TextStyle = Relevo.type.signature, animate: Boolean = true, prefix: String = "Vuelve a ") {
  val colors = Relevo.colors
  val reduce = rememberReduceMotion()
  val phrase = words.trim().trimEnd('.').replaceFirstChar { it.lowercase() }
  val progress = remember(phrase) { Animatable(if (animate && !reduce) 0f else 1f) }
  LaunchedEffect(phrase, reduce) {
    if (animate && !reduce) progress.animateTo(1f, tween(Motion.WRITING, easing = LinearEasing)) else progress.snapTo(1f)
  }
  val visible = (phrase.length * progress.value).toInt()
  var layout by remember { mutableStateOf<TextLayoutResult?>(null) }
  val text = buildAnnotatedString {
    withStyle(SpanStyle(color = colors.ink)) { append(prefix) }
    withStyle(SpanStyle(color = colors.voice)) { append(phrase.take(visible)) }
    withStyle(SpanStyle(color = Color.Transparent)) { append(phrase.drop(visible)) }
    withStyle(SpanStyle(color = colors.ink)) { append(".") }
  }
  val start = prefix.length
  val end = start + phrase.length
  Text(
    text,
    style = style,
    onTextLayout = { layout = it },
    modifier = modifier.drawBehind {
      val result = layout ?: return@drawBehind
      if (phrase.isEmpty()) return@drawBehind
      val thickness = 0.055f * style.fontSize.toPx()
      for (line in 0 until result.lineCount) {
        val lineStart = result.getLineStart(line)
        val lineEnd = result.getLineEnd(line, visibleEnd = true)
        val from = maxOf(start, lineStart)
        val to = minOf(end, lineEnd)
        if (from >= to) continue
        val x1 = result.getHorizontalPosition(from, usePrimaryDirection = true)
        val x2 = result.getBoundingBox(to - 1).right
        val y = result.getLineBaseline(line) + thickness * 2.2f
        drawLine(colors.ink, Offset(x1, y), Offset(x2, y), strokeWidth = thickness)
      }
    },
  )
}

/** Texto largo sobre renglón, para comentarios. */
@Composable
fun RenglonArea(label: String, value: String, onValueChange: (String) -> Unit, placeholder: String) {
  RenglonField(label, value, onValueChange, placeholder = placeholder, singleLine = false, imeAction = ImeAction.Default, maxLength = 600)
}

@Composable
internal fun VerticalSpace(height: androidx.compose.ui.unit.Dp) = Spacer(Modifier.height(height))
