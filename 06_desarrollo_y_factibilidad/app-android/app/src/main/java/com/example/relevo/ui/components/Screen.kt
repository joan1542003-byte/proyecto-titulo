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
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.progressBarRangeInfo
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState

/**
 * Espacio que reserva abajo la barra de pestañas. Las pantallas de pestañas lo dejan libre.
 */
val LocalDockInset = compositionLocalOf { 0.dp }

/** Alto de la barra superior: volver o cerrar a la izquierda y una acción a la derecha. */
private val BarHeight = 56.dp

/**
 * Marco de pantalla de la 4.0 (D-155). El contenido ocupa toda la pantalla y pasa por debajo de la barra de
 * arriba y de los botones de abajo, que flotan sobre un borde con desenfoque progresivo, como en iOS 26
 * ([ScrollEdge]). Todo se ordena en una columna con el margen de 20 dp:
 * - arriba, flotando, volver o cerrar a la izquierda y una acción o el paso («1 de 6») a la derecha; al
 *   desplazar, el título aparece pequeño al centro de la barra;
 * - el título en tinta, una sola frase, y debajo el contenido;
 * - abajo, flotando, el botón principal.
 * Con [backdrop], un color ocupa toda la pantalla detrás del contenido y no hay bordes de papel.
 */
@Composable
fun RelevoScreen(
  modifier: Modifier = Modifier,
  title: String? = null,
  subtitle: String? = null,
  eyebrow: String? = null,
  onBack: (() -> Unit)? = null,
  backLabel: String = "Volver",
  /** En las hojas de creación, volver al comienzo cierra: se muestra una cruz. */
  closeIcon: Boolean = false,
  leading: (@Composable () -> Unit)? = null,
  trailing: (@Composable RowScope.() -> Unit)? = null,
  step: String? = null,
  progress: Float? = null,
  scrollState: ScrollState = rememberScrollState(),
  /** Título grande, para la primera pantalla de cada pestaña. */
  largeTitle: Boolean = false,
  /** El título pequeño de la barra al desplazar; por defecto, el mismo título. */
  barTitle: String? = title,
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
  val haze = rememberHazeState()
  val statusTop = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
  val navBottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
  val barSpace = if (hasBar) BarHeight else 0.dp
  val segments = if (progress != null) 18.dp else 0.dp
  val topSpace = statusTop + barSpace + segments
  val bottomSpace = if (bottom != null) with(density) { bottomHeight.toDp() } else dock + navBottom
  val topEdge by animateFloatAsState(if (scrollState.value > 2) 1f else 0f, Motion.standard(Motion.SHORT), label = "top_edge")
  val bottomEdge by animateFloatAsState(if (scrollState.canScrollForward) 1f else 0f, Motion.standard(Motion.SHORT), label = "bottom_edge")
  val titleOut by remember { derivedStateOf { scrollState.value > with(density) { 52.dp.toPx() } } }
  val barTitleAlpha by animateFloatAsState(if (titleOut && barTitle != null) 1f else 0f, Motion.standard(Motion.SHORT), label = "bar_title")

  Box(modifier.fillMaxSize().background(colors.paper).imePadding()) {
    if (backdrop != null) Box(Modifier.fillMaxSize()) { backdrop() }
    Column(
      Modifier.fillMaxSize().then(if (backdrop == null) Modifier.hazeSource(haze) else Modifier)
        .verticalScroll(scrollState).padding(horizontal = Relevo.margin),
    ) {
      Spacer(Modifier.height(topSpace + if (hasBar) 6.dp else 20.dp))
      if (header != null) {
        header()
        Spacer(Modifier.height(Gap.block))
      }
      if (title != null) {
        Row(Modifier.fillMaxWidth().padding(bottom = Gap.title), verticalAlignment = Alignment.Bottom) {
          Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            if (eyebrow != null) Text(eyebrow, style = Relevo.type.subhead.copy(fontWeight = FontWeight.Medium), color = colors.graphite)
            ScreenTitle(title, style = if (largeTitle) Relevo.type.largeTitle else Relevo.type.title)
            if (subtitle != null) Text(subtitle, style = Relevo.type.body, color = colors.graphite)
          }
          titleTrailing?.invoke()
        }
      }
      content()
      Spacer(Modifier.height(bottomSpace + 28.dp))
    }

    // Arriba: el borde con desenfoque progresivo aparece apenas algo pasa por debajo.
    if (backdrop == null && topEdge > 0.01f) ScrollEdge(haze, top = true, height = topSpace + 24.dp, visible = topEdge)
    if (hasBar) {
      Box(Modifier.fillMaxWidth().statusBarsPadding().height(BarHeight).padding(horizontal = Relevo.margin)) {
        if (barTitle != null) {
          Text(
            barTitle, style = Relevo.type.headline, color = colors.ink, maxLines = 1, overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center).padding(horizontal = 64.dp).graphicsLayer { alpha = barTitleAlpha },
          )
        }
        Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
          when {
            onBack != null -> CircleButton(if (closeIcon) KitIcon.CERRAR else KitIcon.VOLVER, backLabel, onBack)
            leading != null -> leading()
          }
          Spacer(Modifier.weight(1f))
          if (trailing != null) trailing()
          else if (step != null) Text(step, style = Relevo.type.subhead.copy(fontWeight = FontWeight.Medium), color = colors.graphite)
        }
      }
      if (progress != null) {
        StepSegments(progress, step, Modifier.padding(top = statusTop + BarHeight).padding(horizontal = Relevo.margin + 6.dp).padding(top = 2.dp))
      }
    } else if (progress != null) {
      StepSegments(progress, step, Modifier.statusBarsPadding().padding(horizontal = Relevo.margin + 6.dp).padding(top = 8.dp))
    }

    // Abajo: los botones flotan sobre el mismo borde; en las pestañas, el borde queda detrás de la barra.
    if (bottom != null) {
      if (backdrop == null && bottomEdge > 0.01f) {
        ScrollEdge(haze, top = false, height = with(density) { bottomHeight.toDp() } + 26.dp, modifier = Modifier.align(Alignment.BottomCenter), visible = bottomEdge)
      }
      Column(
        Modifier.align(Alignment.BottomCenter).fillMaxWidth().onSizeChanged { bottomHeight = it.height }
          .padding(horizontal = Relevo.margin).padding(top = 10.dp, bottom = 12.dp + dock).navigationBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) { bottom() }
    } else if (dock > 0.dp && backdrop == null && bottomEdge > 0.01f) {
      ScrollEdge(haze, top = false, height = dock + navBottom + 30.dp, modifier = Modifier.align(Alignment.BottomCenter), visible = bottomEdge)
    }
  }
}

/** Espacios de la 4.0: entre piezas de una lista, entre bloques, bajo el título y entre secciones. */
object Gap {
  val list = 10.dp
  val block = 16.dp
  val title = 20.dp
  val section = 28.dp
}

/** Título de pantalla: una sola frase en tinta, sin punto final (D-155). */
@Composable
fun ScreenTitle(title: String, modifier: Modifier = Modifier, style: TextStyle = Relevo.type.title) {
  Text(title, style = style, color = Relevo.colors.ink, modifier = modifier.semantics { heading() })
}

/** Botón redondo blanco de la barra: cerrar o volver, 40 dp con sombra suave para leerse sobre el borde, y área táctil de 48 dp. */
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
      Modifier.size(40.dp).pressScale(interaction, 0.92f)
        .then(if (colors.isDark) Modifier else Modifier.shadow(6.dp, CircleShape, ambientColor = Color.Black.copy(alpha = .04f), spotColor = Color.Black.copy(alpha = .14f)))
        .clip(CircleShape).background(if (pressed) colors.mist else colors.card),
      contentAlignment = Alignment.Center,
    ) { RelevoIcon(icon, size = 20.dp, tint = colors.ink, background = colors.card, strokeWidth = 2f) }
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

