package com.example.relevo.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * Marco de pantalla con la estructura de una pantalla de iOS y las reglas del manual:
 * - barra superior plana sobre papel, sin desenfoque; la línea aparece al desplazar;
 * - título grande a la izquierda que, al desplazarse, sube a la barra con un fundido;
 * - margen de 20 dp;
 * - una acción principal fija abajo, separada por una línea cuando hay contenido debajo.
 */
@Composable
fun RelevoScreen(
  modifier: Modifier = Modifier,
  title: String? = null,
  subtitle: String? = null,
  eyebrow: String? = null,
  onBack: (() -> Unit)? = null,
  backLabel: String = "Volver",
  leading: (@Composable () -> Unit)? = null,
  trailing: (@Composable RowScope.() -> Unit)? = null,
  step: String? = null,
  progress: Float? = null,
  scrollState: ScrollState = rememberScrollState(),
  header: (@Composable ColumnScope.() -> Unit)? = null,
  insetBottom: Boolean = true,
  bottom: (@Composable ColumnScope.() -> Unit)? = null,
  content: @Composable ColumnScope.() -> Unit,
) {
  val colors = Relevo.colors
  val density = LocalDensity.current
  var titleBottom by remember { mutableFloatStateOf(Float.MAX_VALUE) }
  val window = with(density) { 36.dp.toPx() }
  // 0 con el título grande a la vista; 1 cuando ya pasó bajo la barra.
  val collapse = if (title == null) 0f else ((scrollState.value - (titleBottom - window)) / window).coerceIn(0f, 1f)
  val barLineAlpha by animateFloatAsState(if (scrollState.value > 0) 1f else 0f, Motion.standard(160), label = "bar_line")
  val bottomLineAlpha by animateFloatAsState(if (scrollState.canScrollForward) 1f else 0f, Motion.standard(160), label = "bottom_line")
  val lift = with(density) { 6.dp.toPx() }

  Column(modifier.fillMaxSize().background(colors.paper).imePadding()) {
    Column(Modifier.background(colors.paper).statusBarsPadding()) {
      Row(Modifier.fillMaxWidth().height(56.dp).padding(start = if (onBack != null) 8.dp else Relevo.margin, end = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        when {
          onBack != null -> PlainAction(backLabel, onBack, icon = KitIcon.VOLVER)
          leading != null -> leading()
        }
        if (title != null) {
          Spacer(Modifier.width(if (onBack != null || leading != null) 12.dp else 0.dp))
          Text(
            title, style = Relevo.type.headline, color = colors.ink, maxLines = 1, overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f).graphicsLayer { alpha = collapse; translationY = (1f - collapse) * lift },
          )
        } else {
          Spacer(Modifier.weight(1f))
        }
        if (step != null) Text(step, style = Relevo.type.subhead, color = colors.graphite, modifier = Modifier.padding(horizontal = 8.dp))
        trailing?.invoke(this)
      }
      if (progress != null) ProgressLine(progress, Modifier.padding(horizontal = Relevo.margin))
      Box(Modifier.fillMaxWidth().alpha(barLineAlpha)) { Hairline() }
    }
    Box(Modifier.weight(1f).fillMaxWidth().clipToBounds()) {
      Column(Modifier.fillMaxSize().verticalScroll(scrollState).padding(horizontal = Relevo.margin)) {
        if (header != null) {
          Spacer(Modifier.height(4.dp))
          header()
        }
        if (title != null) {
          Column(
            Modifier.padding(top = if (header != null) 20.dp else 6.dp, bottom = 22.dp)
              .onGloballyPositioned { titleBottom = it.positionInParent().y + it.size.height },
            verticalArrangement = Arrangement.spacedBy(6.dp),
          ) {
            if (eyebrow != null) Text(eyebrow.uppercase(), style = Relevo.type.label, color = colors.graphite)
            Text(title, style = Relevo.type.largeTitle, color = colors.ink, modifier = Modifier.semantics { heading() }.alpha(1f - collapse * .6f))
            if (subtitle != null) Text(subtitle, style = Relevo.type.body, color = colors.graphite)
          }
        }
        content()
        Spacer(Modifier.height(28.dp))
      }
    }
    if (bottom != null) {
      Column(Modifier.background(colors.paper)) {
        Box(Modifier.fillMaxWidth().alpha(bottomLineAlpha)) { Hairline() }
        Column(
          Modifier.fillMaxWidth().padding(horizontal = Relevo.margin).padding(top = 12.dp, bottom = 12.dp).then(if (insetBottom) Modifier.navigationBarsPadding() else Modifier),
          verticalArrangement = Arrangement.spacedBy(4.dp),
          content = bottom,
        )
      }
    } else if (insetBottom) {
      Spacer(Modifier.navigationBarsPadding())
    }
  }
}

/**
 * Carrusel horizontal que llega a los bordes y se detiene con cada ficha alineada al margen, como
 * las filas de la App Store.
 */
@Composable
fun Carousel(modifier: Modifier = Modifier, spacing: androidx.compose.ui.unit.Dp = 12.dp, content: androidx.compose.foundation.lazy.LazyListScope.() -> Unit) {
  val state = androidx.compose.foundation.lazy.rememberLazyListState()
  androidx.compose.foundation.lazy.LazyRow(
    modifier.bleed(),
    state = state,
    contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = Relevo.margin),
    horizontalArrangement = Arrangement.spacedBy(spacing),
    flingBehavior = androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior(state, androidx.compose.foundation.gestures.snapping.SnapPosition.Start),
    content = content,
  )
}

/** Deja que un carrusel llegue a los bordes de la pantalla, fuera del margen de 20 dp. */
fun Modifier.bleed(margin: androidx.compose.ui.unit.Dp = Relevo.margin): Modifier = layout { measurable, constraints ->
  val extra = margin.roundToPx()
  val placeable = measurable.measure(constraints.copy(minWidth = constraints.minWidth + extra * 2, maxWidth = constraints.maxWidth + extra * 2))
  layout(placeable.width - extra * 2, placeable.height) { placeable.place(-extra, 0) }
}

/** Avance continuo de un recorrido por pasos, o del tiempo contado: un renglón que se llena de tinta. */
@Composable
fun ProgressLine(progress: Float, modifier: Modifier = Modifier, height: androidx.compose.ui.unit.Dp = 3.dp, trackColor: androidx.compose.ui.graphics.Color = Relevo.colors.mist) {
  val value by animateFloatAsState(progress.coerceIn(0f, 1f), Motion.smooth(stiffness = 200f), label = "progress")
  Box(modifier.fillMaxWidth().height(height).background(trackColor, Relevo.controlShape)) {
    Box(Modifier.fillMaxWidth(value).height(height).background(Relevo.colors.ink, Relevo.controlShape))
  }
}
