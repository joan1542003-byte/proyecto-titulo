package com.example.relevo.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class ButtonKind { Primary, Secondary, Destructive }

/**
 * Botón en cápsula (D-083): 56 dp de alto y ancho completo, o compacto dentro de una tarjeta. El
 * principal va en tinta; el secundario, en un relleno suave, sin bordes. Al presionar se hunde un
 * poco, sin ondas ni rebotes; la acción principal se confirma con un toque háptico.
 */
@Composable
fun RelevoButton(
  label: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  kind: ButtonKind = ButtonKind.Primary,
  enabled: Boolean = true,
  icon: KitIcon? = null,
  compact: Boolean = false,
  /** Se ve apagado pero responde: lo usa [GuardedButton] para decir qué falta. */
  muted: Boolean = false,
) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val (container, content) = when {
    !enabled || muted -> colors.mist to colors.gray
    kind == ButtonKind.Primary -> colors.ink to colors.onInk
    kind == ButtonKind.Destructive -> colors.error.copy(alpha = if (colors.isDark) .16f else .09f) to colors.error
    else -> colors.mist to colors.ink
  }
  val pressedColor = when (kind) {
    ButtonKind.Primary -> colors.slate
    ButtonKind.Destructive -> colors.error.copy(alpha = if (colors.isDark) .24f else .15f)
    ButtonKind.Secondary -> colors.line
  }
  val background by animateColorAsState(if (pressed && enabled) pressedColor else container, Motion.standard(120), label = "button_background")
  Row(
    modifier.then(if (compact) Modifier else Modifier.fillMaxWidth())
      .heightIn(min = if (compact) 40.dp else 56.dp)
      .pressScale(interaction, if (compact) 0.95f else 0.97f)
      .clip(Relevo.controlShape).background(background)
      .clickable(interactionSource = interaction, indication = null, enabled = enabled, role = Role.Button) {
        if (kind == ButtonKind.Primary && !muted) haptics.performHapticFeedback(HapticFeedbackType.ContextClick)
        onClick()
      }
      .padding(horizontal = if (compact) 16.dp else 22.dp),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    if (icon != null) {
      RelevoIcon(icon, size = if (compact) 18.dp else 20.dp, tint = content, background = background, strokeWidth = 2f)
      Spacer(Modifier.width(if (compact) 6.dp else 10.dp))
    }
    Text(label, style = if (compact) Relevo.type.subhead.copy(fontWeight = FontWeight.SemiBold) else Relevo.type.button, color = content, textAlign = TextAlign.Center, maxLines = 2)
  }
}

/**
 * Botón que dice qué falta (2.18). Si [missing] no es null, se ve apagado pero responde: al tocarlo
 * muestra encima qué falta completar y vibra, en vez de no hacer nada. El aviso es neutro: no se
 * pinta de rojo, porque no es un error de la persona. [onMissing] permite registrar qué faltó.
 */
@Composable
fun GuardedButton(
  label: String,
  onClick: () -> Unit,
  missing: String?,
  modifier: Modifier = Modifier,
  kind: ButtonKind = ButtonKind.Primary,
  icon: KitIcon? = null,
  onMissing: (String) -> Unit = {},
) {
  val haptics = LocalHapticFeedback.current
  val scope = rememberCoroutineScope()
  val bump = remember { Animatable(1f) }
  var shown by remember { mutableStateOf<String?>(null) }
  // Al completar lo que faltaba, el aviso se va; si falta otra cosa, se actualiza.
  LaunchedEffect(missing) { shown = if (missing == null) null else shown?.let { missing } }
  Column(modifier.fillMaxWidth()) {
    AnimatedVisibility(visible = shown != null, enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut()) {
      MissingHint(shown.orEmpty(), Modifier.padding(bottom = 10.dp).graphicsLayer { scaleX = bump.value; scaleY = bump.value })
    }
    RelevoButton(label, {
      if (missing != null) {
        // Si el aviso ya estaba a la vista, crece un instante para que se note.
        val again = shown == missing
        shown = missing
        haptics.performHapticFeedback(HapticFeedbackType.LongPress)
        if (again) scope.launch { bump.animateTo(1.04f, tween(110)); bump.animateTo(1f, tween(170)) }
        onMissing(missing)
      } else onClick()
    }, kind = kind, icon = icon, muted = missing != null)
  }
}

/** Qué falta completar, en una cápsula clara con el icono de información. */
@Composable
fun MissingHint(text: String, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  Row(
    modifier.fillMaxWidth().clip(Relevo.controlShape).background(colors.card).padding(horizontal = 18.dp, vertical = 12.dp)
      .semantics { contentDescription = text },
    verticalAlignment = Alignment.CenterVertically,
  ) {
    RelevoIcon(KitIcon.INFO, size = 18.dp, tint = colors.ink, background = colors.card, strokeWidth = 2f)
    Spacer(Modifier.width(10.dp))
    Text(text, style = Relevo.type.subhead, color = colors.ink)
  }
}

/** Acción de texto, con área táctil de 48 dp. */
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
      .padding(horizontal = 4.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    val tint = if (!enabled) Relevo.colors.gray else color.copy(alpha = if (pressed) .5f else 1f)
    if (icon != null) {
      RelevoIcon(icon, size = 20.dp, tint = tint, background = Color.Transparent)
      Spacer(Modifier.width(8.dp))
    }
    Text(label, style = Relevo.type.headline, color = tint)
  }
}

/** Botón redondo de icono: 44 dp y nombre accesible. */
@Composable
fun IconAction(icon: KitIcon, description: String, onClick: () -> Unit, modifier: Modifier = Modifier, filled: Boolean = false) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val colors = Relevo.colors
  Box(
    modifier.size(44.dp).pressScale(interaction, 0.92f).clip(CircleShape)
      .background(if (filled || pressed) colors.mist else Color.Transparent)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = description },
    contentAlignment = Alignment.Center,
  ) { RelevoIcon(icon, size = 20.dp, tint = colors.ink, background = Color.Transparent) }
}

/**
 * Control segmentado de iOS: una pista en cápsula y una cápsula clara que se desliza hasta la opción
 * elegida. Tocar la elegida la desmarca cuando la pregunta se puede omitir.
 */
@Composable
fun SegmentedControl(
  options: List<Pair<String, String>>,
  selected: String?,
  onSelect: (String?) -> Unit,
  modifier: Modifier = Modifier,
  allowDeselect: Boolean = true,
  trackColor: Color = Relevo.colors.mist,
) {
  val colors = Relevo.colors
  val haptics = LocalHapticFeedback.current
  val reduce = rememberReduceMotion()
  val index = options.indexOfFirst { it.first == selected }
  BoxWithConstraints(modifier.fillMaxWidth().height(44.dp).clip(Relevo.controlShape).background(trackColor).padding(3.dp)) {
    val segment = maxWidth / options.size
    val offset by animateDpAsState(segment * index.coerceAtLeast(0), if (reduce) snap() else Motion.smooth(), label = "segment_offset")
    val thumbAlpha by animateFloatAsState(if (index >= 0) 1f else 0f, Motion.standard(Motion.SHORT), label = "segment_thumb")
    Box(
      Modifier.offset(x = offset).width(segment).fillMaxHeight().graphicsLayer { alpha = thumbAlpha }
        .shadow(if (colors.isDark) 0.dp else 3.dp, Relevo.controlShape, ambientColor = Color.Black.copy(alpha = .06f), spotColor = Color.Black.copy(alpha = .12f))
        .clip(Relevo.controlShape).background(if (colors.isDark) Color(0xFF3A3C42) else colors.card),
    )
    Row(Modifier.fillMaxWidth().fillMaxHeight()) {
      options.forEachIndexed { i, (value, label) ->
        val active = i == index
        val textColor by animateColorAsState(if (active) colors.ink else colors.graphite, Motion.standard(Motion.SHORT), label = "segment_text")
        Box(
          Modifier.weight(1f).fillMaxHeight().clip(Relevo.controlShape)
            .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }, role = Role.RadioButton) {
              haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
              onSelect(if (active && allowDeselect) null else value)
            }
            .semantics { this.selected = active },
          contentAlignment = Alignment.Center,
        ) {
          Text(label, style = Relevo.type.subhead.copy(fontWeight = if (active) FontWeight.SemiBold else FontWeight.Medium), color = textColor, maxLines = 1)
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
    Row(Modifier.fillMaxWidth().padding(horizontal = 6.dp), horizontalArrangement = Arrangement.SpaceBetween) {
      Text("1 · $low", style = Relevo.type.footnote, color = Relevo.colors.graphite)
      Text("5 · $high", style = Relevo.type.footnote, color = Relevo.colors.graphite)
    }
  }
}

/**
 * Estrellas para opinar sobre la app o la prueba. Nunca califican a la persona ni lo que hizo (D-073).
 * Tocar la estrella elegida la quita.
 */
@Composable
fun StarRating(value: Int?, onChange: (Int?) -> Unit) {
  val haptics = LocalHapticFeedback.current
  Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
    (1..5).forEach { star ->
      val filled = (value ?: 0) >= star
      val scale by animateFloatAsState(if (filled) 1f else .9f, Motion.smooth(stiffness = 700f), label = "star")
      Box(
        Modifier.size(54.dp).clip(CircleShape)
          .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }, role = Role.RadioButton) {
            haptics.performHapticFeedback(HapticFeedbackType.SegmentTick)
            onChange(if (value == star) null else star)
          }
          .semantics { contentDescription = "$star de 5"; selected = value == star },
        contentAlignment = Alignment.Center,
      ) {
        RelevoIcon(
          if (filled) KitIcon.ESTRELLA_LLENA else KitIcon.ESTRELLA, size = 34.dp, tint = if (filled) Relevo.colors.ink else Relevo.colors.gray,
          background = Color.Transparent, modifier = Modifier.graphicsLayer { scaleX = scale; scaleY = scale },
        )
      }
    }
  }
}

/** Selector de tiempo con − y +: la cifra cambia deslizándose. Mantener presionado repite el paso. */
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
      AnimatedContent(
        targetState = seconds,
        transitionSpec = {
          val up = targetState > initialState
          (slideInVertically(Motion.smooth()) { if (up) it / 2 else -it / 2 } + fadeIn(Motion.standard(Motion.SHORT))) togetherWith
            (slideOutVertically(Motion.smooth()) { if (up) -it / 2 else it / 2 } + fadeOut(Motion.standard(120)))
        },
        label = "duration",
      ) { value -> Text(formatDuration(value), style = Relevo.type.largeTitle, color = colors.ink, modifier = Modifier.enterBlur(this)) }
      Text(label, style = Relevo.type.footnote, color = colors.graphite)
    }
    RepeatButton("Restar tiempo", "−", enabled = seconds > 60) { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onChange(decrease(seconds)) }
    Spacer(Modifier.width(10.dp))
    RepeatButton("Sumar tiempo", "+", enabled = seconds < 6 * 60 * 60) { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onChange(increase(seconds)) }
  }
}

/** Cantidad con − y +, para la constancia elegida. */
@Composable
fun CountStepper(value: Int, onChange: (Int) -> Unit, range: IntRange, label: String) {
  val haptics = LocalHapticFeedback.current
  Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
    Text(label, style = Relevo.type.body, color = Relevo.colors.ink, modifier = Modifier.weight(1f))
    RepeatButton("Restar", "−", enabled = value > range.first) { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onChange((value - 1).coerceIn(range)) }
    Spacer(Modifier.width(10.dp))
    RepeatButton("Sumar", "+", enabled = value < range.last) { haptics.performHapticFeedback(HapticFeedbackType.SegmentTick); onChange((value + 1).coerceIn(range)) }
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
    Modifier.size(52.dp).pressScale(interaction, 0.9f).clip(CircleShape).background(if (pressed) colors.line else colors.mist)
      .clickable(interactionSource = interaction, indication = null, enabled = enabled, role = Role.Button, onClick = onStep)
      .semantics { contentDescription = description },
    contentAlignment = Alignment.Center,
  ) {
    Text(symbol, style = Relevo.type.title2, color = if (enabled) colors.ink else colors.gray)
  }
}

/** Opción rápida en cápsula: relleno suave; la elegida, en tinta. */
@Composable
fun QuickChoice(label: String, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier, icon: KitIcon? = null) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val background by animateColorAsState(if (selected) colors.ink else colors.mist, Motion.standard(Motion.SHORT), label = "chip")
  val content by animateColorAsState(if (selected) colors.onInk else colors.ink, Motion.standard(Motion.SHORT), label = "chip_text")
  Row(
    modifier.heightIn(min = 40.dp).pressScale(interaction, 0.95f).clip(Relevo.controlShape).background(background)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick).semantics { this.selected = selected }
      .padding(horizontal = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    if (icon != null) {
      RelevoIcon(icon, size = 18.dp, tint = content, background = background)
      Spacer(Modifier.width(8.dp))
    }
    Text(label, style = Relevo.type.subhead.copy(fontWeight = FontWeight.SemiBold), color = content, maxLines = 1)
  }
}

/** Marca de selección redonda: el círculo se llena de tinta y la marca se dibuja con el trazo. */
@Composable
fun CheckMark(checked: Boolean, size: Dp = 24.dp) {
  val colors = Relevo.colors
  val reduce = rememberReduceMotion()
  val fill by animateColorAsState(if (checked) colors.ink else Color.Transparent, Motion.standard(Motion.SHORT), label = "check_fill")
  val draw by animateFloatAsState(
    if (checked) 1f else 0f,
    if (reduce) snap() else tween(260, delayMillis = if (checked) 60 else 0, easing = Motion.Easing),
    label = "check_draw",
  )
  Box(
    Modifier.size(size).clip(CircleShape).background(fill).border(1.75.dp, if (checked) colors.ink else colors.gray, CircleShape),
    contentAlignment = Alignment.Center,
  ) {
    Canvas(Modifier.size(size * 0.6f)) {
      if (draw <= 0f) return@Canvas
      val w = this.size.width
      val h = this.size.height
      val path = Path().apply {
        moveTo(w * 0.12f, h * 0.52f)
        lineTo(w * 0.40f, h * 0.78f)
        lineTo(w * 0.88f, h * 0.24f)
      }
      val measure = PathMeasure().apply { setPath(path, false) }
      val partial = Path()
      measure.getSegment(0f, measure.length * draw, partial, true)
      drawPath(partial, colors.onInk, style = Stroke(width = 2.2.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round))
    }
  }
}

/** Opción única: anillo con un punto que crece al elegirla. */
@Composable
fun RadioMark(selected: Boolean) {
  val colors = Relevo.colors
  val dot by animateDpAsState(if (selected) 10.dp else 0.dp, Motion.smooth(stiffness = 700f), label = "radio_dot")
  Box(Modifier.size(24.dp).border(if (selected) 2.dp else 1.75.dp, if (selected) colors.ink else colors.gray, CircleShape), contentAlignment = Alignment.Center) {
    Box(Modifier.size(dot).clip(CircleShape).background(colors.ink))
  }
}

/** Las cifras y los textos que cambian entran con un leve desenfoque («number pop-in», transitions.dev). */
@Composable
fun Modifier.enterBlur(scope: AnimatedVisibilityScope): Modifier {
  if (rememberReduceMotion()) return this
  val radius by scope.transition.animateFloat(transitionSpec = { tween(220, easing = Motion.Easing) }, label = "enter_blur") { state ->
    if (state == EnterExitState.Visible) 0f else 8f
  }
  return if (radius <= 0.1f) this else this.blur(radius.dp, BlurredEdgeTreatment.Unbounded)
}

internal fun formatDuration(seconds: Int): String = when {
  seconds < 60 -> "$seconds s"
  seconds % 3600 == 0 -> "${seconds / 3600} h"
  seconds > 3600 -> "${seconds / 3600} h ${(seconds % 3600) / 60} min"
  else -> "${seconds / 60} min"
}
