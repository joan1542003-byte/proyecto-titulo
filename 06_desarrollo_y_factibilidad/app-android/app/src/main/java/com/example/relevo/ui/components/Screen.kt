package com.example.relevo.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.progressBarRangeInfo
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * Espacio que reserva abajo la barra de pestañas. Las pantallas de pestañas lo dejan libre.
 */
val LocalDockInset = compositionLocalOf { 0.dp }

/** Alto de la barra superior: el botón de cerrar o volver y el paso, como en «Relevo, la app». */
private val BarHeight = 56.dp

/** Cómo se vuelve: un círculo blanco con la flecha o la cruz, o la flecha con la palabra («← Volver»). */
enum class BackStyle { Circle, Text }

/**
 * Marco de pantalla de la línea 3.2 («Relevo, la app», D-131). Todo se ordena en una columna con el margen
 * de 20 dp:
 * - arriba, fija, la barra con cerrar o volver a la izquierda y el paso («1 de 6») a la derecha; debajo, el
 *   avance en segmentos de lado a lado;
 * - el título en dos tonos (lo principal en tinta y la continuación en grafito) y, debajo, el contenido;
 * - abajo, fijo, el botón principal sobre el papel, con un fundido corto encima. El contenido nunca pasa
 *   por detrás de un botón sin velo, para que no se mezclen.
 * Con [backdrop], el aura o un cielo ocupan toda la pantalla detrás del contenido.
 */
@Composable
fun RelevoScreen(
  modifier: Modifier = Modifier,
  title: String? = null,
  subtitle: String? = null,
  eyebrow: String? = null,
  /** Continuación del título en grafito, en la misma línea: «Tu ruta · Pasos pequeños…». */
  titleSoft: String? = null,
  onBack: (() -> Unit)? = null,
  backLabel: String = "Volver",
  /** En las hojas de creación, volver al comienzo cierra: se muestra una cruz. */
  closeIcon: Boolean = false,
  backStyle: BackStyle = BackStyle.Circle,
  leading: (@Composable () -> Unit)? = null,
  trailing: (@Composable RowScope.() -> Unit)? = null,
  step: String? = null,
  progress: Float? = null,
  scrollState: ScrollState = rememberScrollState(),
  hero: (@Composable BoxScope.() -> Unit)? = null,
  heroHeight: Dp = 0.dp,
  @Suppress("UNUSED_PARAMETER") heroPicture: Picture? = null,
  @Suppress("UNUSED_PARAMETER") heroWide: Boolean = true,
  header: (@Composable ColumnScope.() -> Unit)? = null,
  titleTrailing: (@Composable () -> Unit)? = null,
  bottom: (@Composable ColumnScope.() -> Unit)? = null,
  backdrop: (@Composable BoxScope.() -> Unit)? = null,
  content: @Composable ColumnScope.() -> Unit,
) {
  val colors = Relevo.colors
  val density = LocalDensity.current
  val dock = LocalDockInset.current
  var bottomHeight by remember { mutableIntStateOf(0) }
  val hasBar = onBack != null || leading != null || trailing != null || step != null
  val scrolled by animateFloatAsState(if (scrollState.value > 4) 1f else 0f, Motion.standard(Motion.SHORT), label = "top_fade")
  val surface = if (backdrop != null) Color.Transparent else colors.paper

  Box(modifier.fillMaxSize().background(colors.paper).imePadding()) {
    if (backdrop != null) Box(Modifier.fillMaxSize()) { backdrop() }
    Column(Modifier.fillMaxSize()) {
      // Barra fija: cerrar o volver y el paso. Sin barra, el contenido empieza bajo la hora.
      if (hasBar) {
        Row(
          Modifier.fillMaxWidth().background(surface).statusBarsPadding().height(BarHeight).padding(horizontal = Relevo.margin),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          when {
            onBack != null && backStyle == BackStyle.Text -> TextBack(backLabel, onBack)
            onBack != null -> CircleButton(if (closeIcon) KitIcon.CERRAR else KitIcon.VOLVER, backLabel, onBack)
            leading != null -> leading()
          }
          Spacer(Modifier.weight(1f))
          if (trailing != null) trailing()
          else if (step != null) Text(step, style = Relevo.type.subhead.copy(fontWeight = FontWeight.Medium), color = colors.graphite)
        }
        if (progress != null) {
          StepSegments(progress, step, Modifier.background(surface).padding(horizontal = Relevo.margin + 6.dp).padding(top = 2.dp, bottom = 12.dp))
        }
      } else {
        Spacer(Modifier.fillMaxWidth().background(surface).statusBarsPadding())
      }
      Box(Modifier.fillMaxWidth().weight(1f)) {
        Column(Modifier.fillMaxSize().verticalScroll(scrollState)) {
          if (hero != null) Box(Modifier.fillMaxWidth().height(heroHeight).padding(horizontal = Relevo.margin).clip(Relevo.panelShape)) { hero() }
          Column(Modifier.fillMaxWidth().padding(horizontal = Relevo.margin)) {
            Spacer(Modifier.height(if (hasBar) 4.dp else 14.dp))
            if (header != null) {
              header()
              Spacer(Modifier.height(Gap.block))
            }
            if (title != null) {
              Row(Modifier.fillMaxWidth().padding(bottom = Gap.title), verticalAlignment = Alignment.Bottom) {
                Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                  if (eyebrow != null) Text(eyebrow, style = Relevo.type.subhead.copy(fontWeight = FontWeight.Medium), color = colors.graphite)
                  ScreenTitle(title, titleSoft)
                  if (subtitle != null) Text(subtitle, style = Relevo.type.body, color = colors.graphite)
                }
                titleTrailing?.invoke()
              }
            }
            content()
            val reserved = with(density) { bottomHeight.toDp() }
            if (bottom != null) Spacer(Modifier.height(reserved + 16.dp))
            else Spacer(Modifier.height(dock + 28.dp).navigationBarsPadding())
          }
        }
        // Al desplazar, el contenido se funde bajo la barra en una franja corta.
        if (backdrop == null) {
          Box(Modifier.fillMaxWidth().height(14.dp).drawBehind {
            if (scrolled > 0f) drawRect(Brush.verticalGradient(0f to colors.paper, 1f to colors.paper.copy(alpha = 0f)), alpha = scrolled)
          })
        }
      }
    }

    // Abajo: el botón principal, fijo, sobre el papel y con un fundido corto encima.
    if (bottom != null) {
      Column(Modifier.align(Alignment.BottomCenter).fillMaxWidth().onSizeChanged { bottomHeight = it.height }) {
        if (backdrop == null) Box(Modifier.fillMaxWidth().height(24.dp).background(Brush.verticalGradient(0f to colors.paper.copy(alpha = 0f), 1f to colors.paper)))
        Column(
          Modifier.fillMaxWidth().background(surface).padding(horizontal = Relevo.margin).padding(top = 4.dp, bottom = 12.dp + dock).navigationBarsPadding(),
          verticalArrangement = Arrangement.spacedBy(10.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) { bottom() }
      }
    }
  }
}

/** Espacios de la línea 3.2: entre piezas de una lista, entre bloques y bajo el título. */
object Gap {
  val list = 9.dp
  val block = 16.dp
  val title = 18.dp
  val section = 24.dp
}

/** Título de pantalla en dos tonos: lo principal en tinta y la continuación en grafito, en la misma línea. */
@Composable
fun ScreenTitle(title: String, soft: String? = null, modifier: Modifier = Modifier, style: androidx.compose.ui.text.TextStyle = Relevo.type.title) {
  val colors = Relevo.colors
  Text(
    buildAnnotatedString {
      withStyle(SpanStyle(color = colors.ink)) { append(title) }
      if (!soft.isNullOrBlank()) withStyle(SpanStyle(color = colors.graphite)) { append(" "); append(soft) }
    },
    style = style,
    modifier = modifier.semantics { heading() },
  )
}

/** Botón redondo blanco de la barra: cerrar o volver, 40 dp, con nombre accesible y área táctil de 48 dp. */
@Composable
fun CircleButton(icon: KitIcon, description: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val colors = Relevo.colors
  Box(
    modifier.size(48.dp).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = description },
    contentAlignment = Alignment.Center,
  ) {
    Box(
      Modifier.size(40.dp).pressScale(interaction, 0.92f).clip(CircleShape).background(if (pressed) colors.mist else colors.card),
      contentAlignment = Alignment.Center,
    ) { RelevoIcon(icon, size = 20.dp, tint = colors.ink, background = colors.card, strokeWidth = 2f) }
  }
}

/** «← Volver»: la flecha y la palabra, sin fondo, como en la lámina del relevo que cuenta. */
@Composable
private fun TextBack(label: String, onClick: () -> Unit) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  val tint = Relevo.colors.ink.copy(alpha = if (pressed) .5f else 1f)
  Row(
    Modifier.heightIn(min = 48.dp).clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    RelevoIcon(KitIcon.VOLVER, size = 22.dp, tint = tint, background = Color.Transparent, strokeWidth = 1.9f)
    Spacer(Modifier.width(6.dp))
    Text(label, style = Relevo.type.headline, color = tint)
  }
}

/**
 * Avance de un recorrido por pasos: un segmento por paso, de tinta los hechos y el actual, de lado a lado,
 * con su lectura para TalkBack. Si el paso no dice cuántos hay, una línea que se llena.
 */
@Composable
fun StepSegments(progress: Float, step: String?, modifier: Modifier = Modifier) {
  val value by animateFloatAsState(progress.coerceIn(0f, 1f), Motion.smooth(stiffness = 220f), label = "step_progress")
  val parts = step?.let { Regex("(\\d+) de (\\d+)").find(it) }?.destructured?.let { (n, of) -> n.toInt() to of.toInt() }
  val colors = Relevo.colors
  Row(
    modifier.fillMaxWidth().semantics {
      progressBarRangeInfo = ProgressBarRangeInfo(value, 0f..1f)
      if (step != null) contentDescription = "Paso $step"
    },
    horizontalArrangement = Arrangement.spacedBy(6.dp),
  ) {
    if (parts != null && parts.second in 2..12) {
      repeat(parts.second) { i -> Box(Modifier.weight(1f).height(4.dp).background(if (i < parts.first) colors.ink else colors.line, Relevo.controlShape)) }
    } else {
      Box(Modifier.weight(1f).height(4.dp).background(colors.line, Relevo.controlShape)) {
        Box(Modifier.fillMaxWidth(value).height(4.dp).background(colors.ink, Relevo.controlShape))
      }
    }
  }
}

/**
 * Carrusel horizontal que llega a los bordes y se detiene con cada ficha alineada al margen.
 */
@Composable
fun Carousel(modifier: Modifier = Modifier, spacing: Dp = 12.dp, content: LazyListScope.() -> Unit) {
  val state = rememberLazyListState()
  LazyRow(
    modifier.bleed(),
    state = state,
    contentPadding = PaddingValues(horizontal = Relevo.margin),
    horizontalArrangement = Arrangement.spacedBy(spacing),
    flingBehavior = rememberSnapFlingBehavior(state, SnapPosition.Start),
    content = content,
  )
}

/** Deja que un carrusel llegue a los bordes de la pantalla, fuera del margen de 20 dp. */
fun Modifier.bleed(margin: Dp = Relevo.margin): Modifier = layout { measurable, constraints ->
  val extra = margin.roundToPx()
  val placeable = measurable.measure(constraints.copy(minWidth = constraints.minWidth + extra * 2, maxWidth = constraints.maxWidth + extra * 2))
  layout(placeable.width - extra * 2, placeable.height) { placeable.place(-extra, 0) }
}

/** Avance continuo del tiempo contado: una cápsula que se llena de tinta. */
@Composable
fun ProgressLine(progress: Float, modifier: Modifier = Modifier, height: Dp = 6.dp, trackColor: Color = Relevo.colors.mist) {
  val value by animateFloatAsState(progress.coerceIn(0f, 1f), Motion.smooth(stiffness = 200f), label = "progress")
  Box(modifier.fillMaxWidth().height(height).background(trackColor, Relevo.controlShape)) {
    Box(Modifier.fillMaxWidth(value).height(height).background(Relevo.colors.ink, Relevo.controlShape))
  }
}

