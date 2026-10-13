package com.example.relevo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.relevo.theme.Relevo

/*
 * Piezas de «Relevo, la app» (D-127, D-128) llevadas a la app en la línea 3.2 (D-131): la ficha de cielo con
 * su cápsula, el cuadrito de cielo, la tarjeta de vidrio, el Tag que suena y la cifra grande. Las medidas son
 * las de la lámina por 1,5, que es la escala de su teléfono de muestra.
 */

private val Ink = Color(0xFF141312)

/** Anillo de tinta por fuera de una ficha elegida, separado por una franja de papel, sin mover nada. */
fun Modifier.outerRing(show: Boolean, radius: Dp, color: Color, gap: Dp = 4.dp, width: Dp = 2.dp): Modifier = drawBehind {
  if (!show) return@drawBehind
  val stroke = width.toPx()
  val offset = gap.toPx() + stroke / 2
  drawRoundRect(
    color, topLeft = Offset(-offset, -offset), size = Size(size.width + offset * 2, size.height + offset * 2),
    cornerRadius = CornerRadius(radius.toPx() + offset), style = Stroke(stroke),
  )
}

/**
 * Ficha de una actividad: su cielo y, abajo a la izquierda, el nombre en una cápsula blanca. Sin íconos ni
 * textos encima, como en la lámina. La elegida lleva un anillo de tinta por fuera.
 */
@Composable
fun SkyCard(
  title: String?,
  icon: KitIcon,
  modifier: Modifier = Modifier,
  aspect: Float? = 1.55f,
  selected: Boolean = false,
  onClick: (() -> Unit)? = null,
  variant: Int = 0,
  sharedKey: String? = null,
  radius: Dp = 24.dp,
  largeLabel: Boolean = false,
  description: String? = title,
  radio: Boolean = false,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val sky = skyFor(icon)
  val shape = RoundedCornerShape(radius)
  Box(
    modifier.fillMaxWidth().then(if (aspect != null) Modifier.aspectRatio(aspect) else Modifier)
      .outerRing(selected, radius, colors.ink)
      .pressScale(interaction, 0.97f)
      .sharedPhoto(sharedKey)
      .clip(shape)
      .drawBehind { drawSky(sky, variant = variant) }
      .then(
        if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = if (radio) Role.RadioButton else Role.Button, onClickLabel = description, onClick = onClick)
        else Modifier,
      )
      .semantics { if (radio) this.selected = selected; if (description != null && onClick == null) contentDescription = description },
  ) {
    if (!title.isNullOrBlank()) SkyLabel(title, Modifier.align(Alignment.BottomStart).padding(if (largeLabel) 12.dp else 9.dp), large = largeLabel)
  }
}

/** Cuadrito de cielo: la actividad en pequeño, al comienzo de una fila o en una opción rápida. */
@Composable
fun SkySquare(sky: Sky, size: Dp = 45.dp, radius: Dp = 14.dp, variant: Int = 0, modifier: Modifier = Modifier) {
  Box(modifier.size(size).clip(RoundedCornerShape(radius)).drawBehind { drawSky(sky, grain = size >= 30.dp, variant = variant) })
}

/** Cuadrito de cielo de una actividad, por su ícono. */
@Composable
fun SkySquare(icon: KitIcon, size: Dp = 45.dp, radius: Dp = 14.dp, variant: Int = 0, modifier: Modifier = Modifier) = SkySquare(skyFor(icon), size, radius, variant, modifier)

/**
 * Tarjeta de vidrio claro (la del mensaje de «Suena» y las filas que flotan en la bienvenida): blanco
 * translúcido con un borde blanco, sobre el aura o un cielo.
 */
@Composable
fun GlassCard(modifier: Modifier = Modifier, padding: Dp = 18.dp, content: @Composable ColumnScope.() -> Unit) {
  val colors = Relevo.colors
  val shape = RoundedCornerShape(28.dp)
  Column(
    modifier.fillMaxWidth().shadow(18.dp, shape, ambientColor = Color.Black.copy(alpha = .05f), spotColor = Color.Black.copy(alpha = .18f))
      .clip(shape).background(colors.card.copy(alpha = if (colors.isDark) .9f else .84f))
      .border(1.dp, Color.White.copy(alpha = if (colors.isDark) .12f else .85f), shape)
      .padding(padding),
    verticalArrangement = Arrangement.spacedBy(9.dp),
    content = content,
  )
}

/**
 * El Tag de la lámina: un disco claro con su botón al centro y el orificio del llavero. Cuando suena, el
 * sonido se dibuja en anillos de tinta que se abren; no hay luz, porque el Tag no se ilumina.
 */
@Composable
fun TagObject(modifier: Modifier = Modifier, size: Dp = 96.dp, sounding: Boolean = false) {
  Box(modifier.size(size), contentAlignment = Alignment.Center) {
    if (sounding) SoundRings(Modifier.size(size), color = Ink)
    Canvas(Modifier.size(size).shadow(size / 5, CircleShape, ambientColor = Color.Black.copy(alpha = .08f), spotColor = Color.Black.copy(alpha = .28f))) {
      val r = this.size.minDimension / 2
      val c = Offset(r, r)
      drawCircle(
        Brush.radialGradient(0f to Color.White, .16f to Color.White, .52f to Color(0xFFF5F2ED), 1f to Color(0xFFE4DED5), center = Offset(r * .72f, r * .6f), radius = r * 1.3f),
        radius = r, center = c,
      )
      drawCircle(Brush.radialGradient(0f to Color.White, 1f to Color(0xFFEFEBE5), center = Offset(r * .92f, r * .9f), radius = r * .4f), radius = r * .38f, center = c)
      drawCircle(Ink.copy(alpha = .1f), radius = r * .38f, center = c, style = Stroke(1.2f))
      drawCircle(Color(0xFFEEE9E3), radius = r * .11f, center = Offset(r, r * .25f))
      drawCircle(Ink.copy(alpha = .14f), radius = r * .11f, center = Offset(r, r * .25f), style = Stroke(1f))
    }
  }
}

/** Disco blanco con el ícono de lo que suena (parlante, reloj, teléfono), del mismo tamaño que el Tag. */
@Composable
fun SoundObject(icon: KitIcon, modifier: Modifier = Modifier, size: Dp = 96.dp, sounding: Boolean = false) {
  Box(modifier.size(size), contentAlignment = Alignment.Center) {
    if (sounding) SoundRings(Modifier.size(size), color = Ink)
    Box(Modifier.size(size).shadow(size / 5, CircleShape, ambientColor = Color.Black.copy(alpha = .08f), spotColor = Color.Black.copy(alpha = .25f)).clip(CircleShape).background(Color.White), contentAlignment = Alignment.Center) {
      RelevoIcon(icon, size = size * .44f, tint = Ink, background = Color.White)
    }
  }
}

/**
 * La cifra grande del tiempo contado: los números en 72 sp y las unidades más chicas («12 min»), como en
 * la lámina del relevo que cuenta.
 */
@Composable
fun BigCounter(seconds: Int, modifier: Modifier = Modifier, color: Color = Relevo.colors.ink) {
  val text = formatDuration(seconds)
  val styled = buildAnnotatedString {
    Regex("\\d+|\\D+").findAll(text).forEach { part ->
      val digits = part.value.first().isDigit()
      withStyle(if (digits) SpanStyle(fontSize = 72.sp, letterSpacing = (-0.05).em) else SpanStyle(fontSize = 26.sp, letterSpacing = (-0.02).em)) { append(part.value) }
    }
  }
  Text(
    styled, modifier = modifier.semantics { contentDescription = text },
    style = Relevo.type.title.copy(fontSize = 72.sp, lineHeight = 76.sp, fontWeight = FontWeight.SemiBold, fontFeatureSettings = "tnum"), color = color,
  )
}

/** Una parte de una frase con íconos: texto o una ficha con su ícono, como «Tu primer paso [ficha]: abrir el libro». */
sealed interface SentencePart {
  data class Words(val text: String) : SentencePart
  data class Tile(val icon: KitIcon, val color: Color) : SentencePart
}

/** Frase con fichas de color después de lo que nombran (D-122): el ícono va después de la palabra, nunca antes. */
@Composable
fun IconSentence(parts: List<SentencePart>, modifier: Modifier = Modifier, style: TextStyle = Relevo.type.body.copy(fontWeight = FontWeight.Medium, lineHeight = 28.sp), color: Color = Relevo.colors.ink, textAlign: TextAlign = TextAlign.Start) {
  val inline = remember(parts) {
    parts.filterIsInstance<SentencePart.Tile>().mapIndexed { i, tile ->
      "tile$i" to InlineTextContent(Placeholder(1.35.em, 1.35.em, PlaceholderVerticalAlign.TextCenter)) {
        Box(Modifier.fillMaxSize().clip(RoundedCornerShape(7.dp)).background(tile.color), contentAlignment = Alignment.Center) {
          RelevoIcon(tile.icon, size = 15.dp, tint = Ink, background = tile.color, strokeWidth = 2f)
        }
      }
    }.toMap()
  }
  val text = buildAnnotatedString {
    var i = 0
    parts.forEach { part ->
      when (part) {
        is SentencePart.Words -> append(part.text)
        is SentencePart.Tile -> { append(" "); appendInlineContent("tile${i++}", "(${part.icon.label.lowercase()})") }
      }
    }
  }
  Text(text, modifier = modifier, style = style, color = color, inlineContent = inline, textAlign = textAlign)
}

/** Nota breve en una tarjeta clara, como «Mientras más pequeño, menos cuesta empezar.» en la lámina. */
@Composable
fun TipCard(text: String, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  Text(
    text, style = Relevo.type.callout, color = colors.ink,
    modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(22.dp)).background(colors.card.copy(alpha = .7f))
      .border(1.dp, colors.card, RoundedCornerShape(22.dp)).padding(horizontal = 18.dp, vertical = 15.dp),
  )
}

/** Etiqueta pequeña en cápsula (14 sp), sobre el aura o el papel: «Contando», «Después de la señal». */
@Composable
fun Chip(text: String, modifier: Modifier = Modifier, background: Color = Relevo.colors.card, color: Color = Relevo.colors.ink) {
  Text(
    text, style = Relevo.type.footnote.copy(fontWeight = FontWeight.SemiBold, fontSize = 14.sp), color = color, maxLines = 1, overflow = TextOverflow.Ellipsis,
    modifier = modifier.clip(Relevo.controlShape).background(background).padding(horizontal = 12.dp, vertical = 5.dp),
  )
}

/** Dos fichas por fila con 9 dp entre ellas, como «Tus actividades» de la lámina. */
@Composable
fun <T> TwoColumnGrid(items: List<T>, modifier: Modifier = Modifier, spacing: Dp = 9.dp, cell: @Composable (T, Modifier) -> Unit) {
  Column(modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(spacing)) {
    items.chunked(2).forEach { row ->
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacing)) {
        row.forEach { item -> cell(item, Modifier.weight(1f)) }
        if (row.size == 1) Spacer(Modifier.weight(1f))
      }
    }
  }
}
