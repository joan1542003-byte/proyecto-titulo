package com.example.relevo.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.dialog
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import dev.chrisbanes.haze.HazeState
import kotlinx.coroutines.launch

/** Una hoja abierta: su contenido se actualiza en cada recomposición de quien la pidió. */
internal class SheetEntry(content: @Composable ColumnScope.() -> Unit, onDismiss: () -> Unit) {
  var content by mutableStateOf(content)
  var onDismiss by mutableStateOf(onDismiss)
  var title by mutableStateOf<String?>(null)
  var done by mutableStateOf<String?>(null)
  var scrollable by mutableStateOf(true)
  var tall by mutableStateOf(false)
  val visibility = MutableTransitionState(false).apply { targetState = true }
}

/** Capa de hojas de la app: se dibujan sobre todo y desenfocan lo que queda detrás. */
class SheetHostState {
  internal val entries = mutableStateListOf<SheetEntry>()
}

val LocalSheetHost = staticCompositionLocalOf<SheetHostState?> { null }

/**
 * Hoja flotante de iOS 26 (D-083): una cápsula de vidrio separada de los bordes, que sube desde abajo
 * y deja ver, desenfocado, lo que hay detrás. Se cierra arrastrándola hacia abajo, tocando fuera, con
 * el gesto de volver o con [done].
 */
@Composable
fun RelevoSheet(
  onDismiss: () -> Unit,
  title: String? = null,
  done: String? = null,
  scrollable: Boolean = true,
  /** Para listas largas: la hoja ocupa casi toda la pantalla. */
  tall: Boolean = false,
  content: @Composable ColumnScope.() -> Unit,
) {
  val host = LocalSheetHost.current
  if (host == null) {
    FallbackSheet(onDismiss, title, done, scrollable, content)
    return
  }
  val entry = remember { SheetEntry(content, onDismiss) }
  SideEffect {
    entry.content = content
    entry.onDismiss = onDismiss
    entry.title = title
    entry.done = done
    entry.scrollable = scrollable
    entry.tall = tall
  }
  DisposableEffect(entry) {
    host.entries.add(entry)
    onDispose { entry.visibility.targetState = false }
  }
}

/** Dibuja las hojas abiertas; va al final de la raíz para quedar sobre la navegación. */
@Composable
fun SheetHost(state: SheetHostState, source: HazeState?) {
  val top = state.entries.lastOrNull { it.visibility.targetState }
  state.entries.toList().forEach { entry ->
    key(entry) { SheetLayer(entry, source, isTop = entry == top, onGone = { state.entries.remove(entry) }) }
  }
}

@Composable
private fun SheetLayer(entry: SheetEntry, source: HazeState?, isTop: Boolean, onGone: () -> Unit) {
  val visibility = entry.visibility
  val colors = Relevo.colors
  val scope = rememberCoroutineScope()
  val density = LocalDensity.current
  val drag = remember { Animatable(0f) }
  LaunchedEffect(visibility.isIdle, visibility.currentState) {
    if (visibility.isIdle && !visibility.currentState && !visibility.targetState) onGone()
  }
  if (isTop) BackHandler { entry.onDismiss() }
  AnimatedVisibility(visibility, enter = fadeIn(Motion.standard()), exit = fadeOut(Motion.standard(Motion.SHORT))) {
    BoxWithConstraints(Modifier.fillMaxSize().imePadding()) {
      val maxSheet = maxHeight * 0.9f
      Box(
        Modifier.fillMaxSize().background(colors.scrim)
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { entry.onDismiss() },
      )
      Column(
        Modifier.align(Alignment.BottomCenter)
          .animateEnterExit(
            enter = slideInVertically(Motion.smooth(stiffness = 380f)) { it },
            exit = slideOutVertically(Motion.smooth(stiffness = 520f)) { it },
          )
          .statusBarsPadding().navigationBarsPadding()
          .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
          .fillMaxWidth()
          .then(if (entry.tall) Modifier.height(maxSheet) else Modifier.heightIn(max = maxSheet))
          .graphicsLayer { translationY = drag.value }
          .glass(Relevo.sheetShape, state = source, tint = if (colors.isDark) colors.card.copy(alpha = .88f) else colors.paper.copy(alpha = .86f))
          .semantics { dialog() },
      ) {
        // Asa y encabezado: se arrastran para cerrar.
        Column(
          Modifier.fillMaxWidth().draggable(
            state = rememberDraggableState { delta -> scope.launch { drag.snapTo((drag.value + delta).coerceAtLeast(0f)) } },
            orientation = Orientation.Vertical,
            onDragStopped = { velocity ->
              if (drag.value > with(density) { 120.dp.toPx() } || velocity > 1800f) entry.onDismiss()
              else drag.animateTo(0f, Motion.smooth())
            },
          ),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Box(Modifier.padding(top = 8.dp, bottom = 6.dp).width(36.dp).height(5.dp).background(colors.line, Relevo.controlShape))
          if (entry.title != null || entry.done != null) {
            Row(Modifier.fillMaxWidth().padding(start = 22.dp, end = 12.dp, top = 4.dp, bottom = 4.dp), verticalAlignment = Alignment.CenterVertically) {
              Text(entry.title.orEmpty(), style = Relevo.type.title2, color = colors.ink, modifier = Modifier.weight(1f))
              entry.done?.let { GlassTextButton(it, entry.onDismiss) }
            }
          }
        }
        Column(
          Modifier.fillMaxWidth().weight(1f, fill = entry.tall)
            .then(if (entry.scrollable) Modifier.verticalScroll(rememberScrollState()) else Modifier)
            .padding(start = 22.dp, end = 22.dp, top = 8.dp, bottom = 22.dp),
        ) { entry.content(this) }
      }
    }
  }
}

/** Sin capa de hojas (vistas previas), se usa la hoja de Material con los mismos colores. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FallbackSheet(onDismiss: () -> Unit, title: String?, done: String?, scrollable: Boolean, content: @Composable ColumnScope.() -> Unit) {
  val colors = Relevo.colors
  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    containerColor = colors.paper,
    contentColor = colors.ink,
    scrimColor = colors.scrim,
    shape = Relevo.sheetShape,
  ) {
    Column(
      Modifier.fillMaxWidth().then(if (scrollable) Modifier.verticalScroll(rememberScrollState()) else Modifier)
        .padding(horizontal = Relevo.margin).padding(bottom = 16.dp).navigationBarsPadding(),
    ) {
      if (title != null || done != null) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
          Text(title.orEmpty(), style = Relevo.type.title2, color = colors.ink, modifier = Modifier.weight(1f))
          if (done != null) PlainAction(done, onDismiss)
        }
        Spacer(Modifier.height(8.dp))
      }
      content()
    }
  }
}

