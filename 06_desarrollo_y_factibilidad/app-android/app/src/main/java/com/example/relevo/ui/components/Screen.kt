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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * Marco de pantalla, con la estructura de una pantalla de iOS y las reglas del manual:
 * - barra superior plana sobre papel, sin desenfoque;
 * - título grande alineado a la izquierda que, al desplazarse, pasa a la barra;
 * - margen de 20 dp;
 * - una acción principal fija abajo, que se separa con una línea cuando hay contenido debajo.
 */
@Composable
fun RelevoScreen(
  modifier: Modifier = Modifier,
  title: String? = null,
  subtitle: String? = null,
  onBack: (() -> Unit)? = null,
  backLabel: String = "Volver",
  leading: (@Composable () -> Unit)? = null,
  trailing: (@Composable RowScope.() -> Unit)? = null,
  step: String? = null,
  progress: Float? = null,
  scrollState: ScrollState = rememberScrollState(),
  bottom: (@Composable ColumnScope.() -> Unit)? = null,
  content: @Composable ColumnScope.() -> Unit,
) {
  val colors = Relevo.colors
  var titleHeight by remember { mutableIntStateOf(Int.MAX_VALUE) }
  val collapsed = title != null && scrollState.value > titleHeight
  val inlineAlpha by animateFloatAsState(if (collapsed) 1f else 0f, Motion.standard(160), label = "inline_title")
  val barLineAlpha by animateFloatAsState(if (scrollState.value > 0) 1f else 0f, Motion.standard(160), label = "bar_line")
  val bottomLineAlpha by animateFloatAsState(if (scrollState.canScrollForward) 1f else 0f, Motion.standard(160), label = "bottom_line")

  Column(modifier.fillMaxSize().background(colors.paper).imePadding()) {
    Column(Modifier.background(colors.paper).statusBarsPadding()) {
      Row(Modifier.fillMaxWidth().height(56.dp).padding(start = if (onBack != null) 10.dp else Relevo.margin, end = 12.dp), verticalAlignment = Alignment.CenterVertically) {
        when {
          onBack != null -> PlainAction(backLabel, onBack, icon = KitIcon.VOLVER)
          leading != null -> leading()
        }
        if (title != null) {
          Spacer(Modifier.width(if (onBack != null) 12.dp else 0.dp))
          Text(title, style = Relevo.type.headline, color = colors.ink, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f).alpha(inlineAlpha))
        } else {
          Spacer(Modifier.weight(1f))
        }
        if (step != null) Text(step, style = Relevo.type.subhead, color = colors.graphite, modifier = Modifier.padding(horizontal = 8.dp))
        trailing?.invoke(this)
      }
      if (progress != null) ProgressLine(progress)
      Box(Modifier.fillMaxWidth().alpha(barLineAlpha)) { Hairline() }
    }
    Box(Modifier.weight(1f).fillMaxWidth().clipToBounds()) {
      Column(Modifier.fillMaxSize().verticalScroll(scrollState).padding(horizontal = Relevo.margin)) {
        if (title != null) {
          Column(Modifier.padding(top = 6.dp, bottom = 22.dp).onSizeChanged { titleHeight = it.height }, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(title, style = Relevo.type.largeTitle, color = colors.ink, modifier = Modifier.semantics { heading() })
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
          Modifier.fillMaxWidth().padding(horizontal = Relevo.margin).padding(top = 12.dp, bottom = 12.dp).navigationBarsPadding(),
          verticalArrangement = Arrangement.spacedBy(4.dp),
          content = bottom,
        )
      }
    } else {
      Spacer(Modifier.navigationBarsPadding())
    }
  }
}

/** Avance continuo de un recorrido por pasos. */
@Composable
fun ProgressLine(progress: Float) {
  val value by animateFloatAsState(progress.coerceIn(0f, 1f), Motion.standard(), label = "progress")
  Box(Modifier.fillMaxWidth().padding(horizontal = Relevo.margin).height(3.dp).background(Relevo.colors.mist, Relevo.controlShape)) {
    Box(Modifier.fillMaxWidth(value).height(3.dp).background(Relevo.colors.ink, Relevo.controlShape))
  }
}
