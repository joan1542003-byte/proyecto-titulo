package com.example.relevo.ui.components

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.isSpecified

/*
 * Texto de Relevo (4.1, D-156). Es el `Text` de Material con la regla de composición que el autor fijó para la
 * memoria (D-135): «las últimas palabras de cada párrafo van unidas», para que ninguna línea final quede con
 * una sola palabra (una viuda). Además, los títulos y el texto centrado se parten en líneas de largo parejo,
 * para que el bloque quede simétrico, y el texto corrido con la estrategia de mejor calidad de Android. Toda la app usa este `Text`, así la regla no depende de
 * acordarse en cada pantalla.
 */

/** Espacio que no se parte. */
private const val NBSP = ' '

/**
 * Une con un espacio que no se parte las dos últimas palabras de cada párrafo, si tiene tres o más. Con dos
 * palabras no se une nada: en una celda angosta cada palabra necesita poder ir en su línea.
 */
internal fun sinViuda(text: String): String = if (' ' !in text) text else text.split('\n').joinToString("\n") { line ->
  val end = line.trimEnd().length
  val last = line.lastIndexOf(' ', end - 1)
  if (last <= 0 || line.lastIndexOf(' ', last - 1) < 0) line else line.substring(0, last) + NBSP + line.substring(last + 1)
}

private fun sinViuda(text: AnnotatedString): AnnotatedString {
  val fixed = sinViuda(text.text)
  if (fixed == text.text) return text
  // Mismo largo: se cambian los espacios uno por uno y se conservan los estilos.
  var result = AnnotatedString("")
  var start = 0
  fixed.forEachIndexed { index, char ->
    if (char == NBSP && text.text[index] == ' ') {
      result += text.subSequence(start, index) + AnnotatedString(NBSP.toString())
      start = index + 1
    }
  }
  return result + text.subSequence(start, text.length)
}

/** Títulos y texto centrado en líneas parejas; texto corrido con el corte de mejor calidad. */
private fun TextStyle.conCorte(fontSize: TextUnit, textAlign: TextAlign?): TextStyle {
  val size = if (fontSize.isSpecified) fontSize else this.fontSize
  val heading = size.isSpecified && size.value >= 20f
  val centered = (textAlign ?: this.textAlign) == TextAlign.Center
  return if (lineBreak != LineBreak.Unspecified && lineBreak != LineBreak.Simple) this
  else copy(lineBreak = if (heading || centered) LineBreak.Heading else LineBreak.Paragraph)
}

@Composable
fun Text(
  text: String,
  modifier: Modifier = Modifier,
  color: Color = Color.Unspecified,
  fontSize: TextUnit = TextUnit.Unspecified,
  fontStyle: FontStyle? = null,
  fontWeight: FontWeight? = null,
  fontFamily: FontFamily? = null,
  letterSpacing: TextUnit = TextUnit.Unspecified,
  textDecoration: TextDecoration? = null,
  textAlign: TextAlign? = null,
  lineHeight: TextUnit = TextUnit.Unspecified,
  overflow: TextOverflow = TextOverflow.Clip,
  softWrap: Boolean = true,
  maxLines: Int = Int.MAX_VALUE,
  minLines: Int = 1,
  onTextLayout: ((TextLayoutResult) -> Unit)? = null,
  style: TextStyle = LocalTextStyle.current,
) {
  androidx.compose.material3.Text(
    text = if (maxLines > 1) sinViuda(text) else text, modifier = modifier, color = color, fontSize = fontSize, fontStyle = fontStyle,
    fontWeight = fontWeight, fontFamily = fontFamily, letterSpacing = letterSpacing, textDecoration = textDecoration, textAlign = textAlign,
    lineHeight = lineHeight, overflow = overflow, softWrap = softWrap, maxLines = maxLines, minLines = minLines, onTextLayout = onTextLayout,
    style = style.conCorte(fontSize, textAlign),
  )
}

@Composable
fun Text(
  text: AnnotatedString,
  modifier: Modifier = Modifier,
  color: Color = Color.Unspecified,
  fontSize: TextUnit = TextUnit.Unspecified,
  fontStyle: FontStyle? = null,
  fontWeight: FontWeight? = null,
  fontFamily: FontFamily? = null,
  letterSpacing: TextUnit = TextUnit.Unspecified,
  textDecoration: TextDecoration? = null,
  textAlign: TextAlign? = null,
  lineHeight: TextUnit = TextUnit.Unspecified,
  overflow: TextOverflow = TextOverflow.Clip,
  softWrap: Boolean = true,
  maxLines: Int = Int.MAX_VALUE,
  minLines: Int = 1,
  inlineContent: Map<String, InlineTextContent> = mapOf(),
  onTextLayout: (TextLayoutResult) -> Unit = {},
  style: TextStyle = LocalTextStyle.current,
) {
  androidx.compose.material3.Text(
    text = if (maxLines > 1) sinViuda(text) else text, modifier = modifier, color = color, fontSize = fontSize, fontStyle = fontStyle,
    fontWeight = fontWeight, fontFamily = fontFamily, letterSpacing = letterSpacing, textDecoration = textDecoration, textAlign = textAlign,
    lineHeight = lineHeight, overflow = overflow, softWrap = softWrap, maxLines = maxLines, minLines = minLines,
    inlineContent = inlineContent, onTextLayout = onTextLayout, style = style.conCorte(fontSize, textAlign),
  )
}
