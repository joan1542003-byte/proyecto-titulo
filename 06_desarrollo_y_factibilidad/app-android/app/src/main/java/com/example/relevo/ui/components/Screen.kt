package com.example.relevo.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.progressBarRangeInfo
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.LocalRelevoColors
import com.example.relevo.theme.Relevo
import dev.chrisbanes.haze.rememberHazeState
import dev.chrisbanes.haze.hazeSource

/**
 * Espacio que reserva abajo la barra de pestañas flotante. Las pantallas de pestañas lo dejan libre y
 * ponen su acción principal por encima.
 */
val LocalDockInset = compositionLocalOf { 0.dp }

private val BarHeight = 56.dp

/** La foto que llega al borde superior termina con esquinas amplias abajo. */
private val HeroShape = RoundedCornerShape(bottomStart = 34.dp, bottomEnd = 34.dp)

/**
 * Marco de pantalla a sangre, al estilo de iOS 26 (D-083):
 * - el contenido ocupa toda la pantalla y se desplaza bajo barras de vidrio;
 * - arriba y abajo, el contenido se desenfoca y se funde con el papel al pasar bajo las barras;
 * - los botones de la barra son redondos y de vidrio; el título grande sube a la barra al desplazar;
 * - una acción principal flotante abajo, en cápsula, al alcance del pulgar.
 * Con [hero], una foto llega hasta el borde superior, bajo la barra de estado. Si se indica
 * [heroPicture], los botones de la barra y los iconos de la barra de estado toman el tono de esa foto
 * mientras está debajo: claros sobre fotos oscuras y oscuros sobre fotos claras (D-084).
 */
@OptIn(ExperimentalLayoutApi::class)
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
  hero: (@Composable BoxScope.() -> Unit)? = null,
  heroHeight: Dp = 0.dp,
  heroPicture: Picture? = null,
  heroWide: Boolean = true,
  header: (@Composable ColumnScope.() -> Unit)? = null,
  titleTrailing: (@Composable () -> Unit)? = null,
  bottom: (@Composable ColumnScope.() -> Unit)? = null,
  content: @Composable ColumnScope.() -> Unit,
) {
  val colors = Relevo.colors
  val density = LocalDensity.current
  val haze = rememberHazeState()
  val dock = LocalDockInset.current
  var titleBottom by remember { mutableFloatStateOf(Float.MAX_VALUE) }
  var bottomHeight by remember { mutableIntStateOf(0) }
  val window = with(density) { 40.dp.toPx() }
  // 0 con el título grande a la vista; 1 cuando ya pasó bajo la barra.
  val collapse = if (title == null) 0f else ((scrollState.value - (titleBottom - window)) / window).coerceIn(0f, 1f)
  val lift = with(density) { 6.dp.toPx() }
  val imeVisible = WindowInsets.isImeVisible
  val statusTop = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
  // Tono de la foto bajo la barra: se mide la franja de la barra de estado y los botones.
  val heroFrame = heroHeight + statusTop
  val screenWidth = LocalConfiguration.current.screenWidthDp.dp
  val heroDark = if (hero != null && heroFrame > 0.dp) {
    rememberPhotoDark(heroPicture, heroWide, screenWidth / heroFrame, 0f, ((statusTop + BarHeight) / heroFrame).coerceIn(0.05f, 1f))
  } else null
  val heroUnderBar = hero != null && scrollState.value < with(density) { (heroHeight - BarHeight).toPx() }
  val barColors = if (heroUnderBar) paletteOver(heroDark) else colors
  if (hero != null) StatusBarTone(darkBackground = barColors.isDark)
  // El borde superior aparece solo cuando pasa contenido bajo la barra, como en iOS; sobre la foto, no.
  val topAlpha by animateFloatAsState(if (scrollState.value > 0 && !heroUnderBar) 1f else 0f, Motion.standard(Motion.SHORT), label = "top_edge")

  Box(modifier.fillMaxSize().background(colors.paper).imePadding()) {
    Column(
      Modifier.fillMaxSize()
        .padding(bottom = if (imeVisible && bottom != null) with(density) { bottomHeight.toDp() } else 0.dp)
        .hazeSource(haze).verticalScroll(scrollState),
    ) {
      if (hero != null) Box(Modifier.fillMaxWidth().height(heroHeight + statusTop).clip(HeroShape)) { hero() }
      else Spacer(Modifier.statusBarsPadding().height(BarHeight))
      Column(Modifier.fillMaxWidth().padding(horizontal = Relevo.margin)) {
        if (header != null) {
          Spacer(Modifier.height(8.dp))
          header()
        }
        if (title != null) {
          Row(
            Modifier.fillMaxWidth().padding(top = if (header != null || hero != null) 22.dp else 6.dp, bottom = 22.dp)
              .onGloballyPositioned { titleBottom = it.positionInRoot().y + it.size.height + scrollState.value },
            verticalAlignment = Alignment.Bottom,
          ) {
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
              if (eyebrow != null) Text(eyebrow, style = Relevo.type.label, color = colors.graphite)
              Text(title, style = Relevo.type.largeTitle, color = colors.ink, modifier = Modifier.semantics { heading() }.graphicsLayer { alpha = 1f - collapse * .7f })
              if (subtitle != null) Text(subtitle, style = Relevo.type.body, color = colors.graphite)
            }
            titleTrailing?.invoke()
          }
        }
        content()
        val reserved = with(density) { bottomHeight.toDp() }
        if (bottom != null) Spacer(Modifier.height(reserved + 24.dp))
        else Spacer(Modifier.height(dock + 36.dp).navigationBarsPadding())
      }
    }

    // Borde superior: el contenido se funde bajo la barra, en una franja que termina poco después de ella.
    Column(Modifier.fillMaxWidth().edgeBlur(haze, fromTop = true, alpha = topAlpha)) {
      Spacer(Modifier.statusBarsPadding())
      Spacer(Modifier.height(BarHeight + 12.dp))
    }

    // Barra: botones de vidrio y el título, que aparece al desplazar.
    CompositionLocalProvider(LocalGlassSource provides haze, LocalRelevoColors provides barColors) {
    Row(
      Modifier.fillMaxWidth().statusBarsPadding().height(BarHeight).padding(horizontal = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Box(Modifier.width(88.dp), contentAlignment = Alignment.CenterStart) {
        when {
          onBack != null -> GlassIconButton(if (closeIcon) KitIcon.CERRAR else KitIcon.VOLVER, backLabel, onBack)
          leading != null -> Box(Modifier.padding(start = 8.dp)) { leading() }
        }
      }
      Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
        when {
          progress != null -> StepProgress(progress, step)
          title != null -> Text(
            title, style = Relevo.type.headline, color = colors.ink, maxLines = 1, overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center,
            modifier = Modifier.graphicsLayer { alpha = collapse; translationY = (1f - collapse) * lift },
          )
        }
      }
      Row(Modifier.width(88.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) { trailing?.invoke(this) }
    }
    }

    // Abajo: la acción principal flota sobre un borde desenfocado; en las pestañas, por encima de la barra.
    if (bottom != null || dock > 0.dp) {
      Box(Modifier.align(Alignment.BottomCenter).fillMaxWidth()) {
        Box(Modifier.matchParentSize().edgeBlur(haze, fromTop = false))
        Column(
          Modifier.fillMaxWidth().onSizeChanged { bottomHeight = it.height }
            .padding(horizontal = Relevo.margin).padding(top = 22.dp, bottom = 12.dp + dock).navigationBarsPadding(),
          verticalArrangement = Arrangement.spacedBy(6.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) { CompositionLocalProvider(LocalGlassSource provides haze) { bottom?.invoke(this) } }
      }
    }
  }
}

/** Avance de un recorrido por pasos: una cápsula fina que se llena, con su lectura para TalkBack. */
@Composable
private fun StepProgress(progress: Float, step: String?) {
  val value by animateFloatAsState(progress.coerceIn(0f, 1f), Motion.smooth(stiffness = 220f), label = "step_progress")
  Box(
    Modifier.width(112.dp).height(6.dp).background(Relevo.colors.mist, Relevo.controlShape)
      .semantics {
        progressBarRangeInfo = ProgressBarRangeInfo(value, 0f..1f)
        if (step != null) contentDescription = "Paso $step"
      },
  ) {
    Box(Modifier.fillMaxWidth(value).height(6.dp).background(Relevo.colors.ink, Relevo.controlShape))
  }
}

/**
 * Carrusel horizontal que llega a los bordes y se detiene con cada ficha alineada al margen, como
 * las filas de la App Store.
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

/** Deja que un carrusel o una foto lleguen a los bordes de la pantalla, fuera del margen de 20 dp. */
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
