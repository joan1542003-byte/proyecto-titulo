package com.example.relevo.ui.components

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import dev.chrisbanes.haze.HazeProgressive
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeEffect

/**
 * Vidrio de la capa de navegación (D-083): barras, botones flotantes, pestañas y hojas desenfocan el
 * contenido que pasa detrás, con un tinte de papel y un borde fino. Sin brillos, reflejos ni
 * degradados de luz. El contenido (fotos, textos, listas) nunca lleva vidrio.
 */
val LocalGlassSource = compositionLocalOf<HazeState?> { null }

/** Desenfoque sutil y tinte translúcido; el ruido se deja en cero para que no parezca empañado. */
@Composable
fun glassStyle(tint: Color = Relevo.colors.glass, blur: Dp = 24.dp): HazeStyle = HazeStyle(
  backgroundColor = Relevo.colors.paper,
  tints = listOf(HazeTint(tint)),
  blurRadius = blur,
  noiseFactor = 0f,
)

/** Superficie de vidrio con la forma dada. Sin fuente de desenfoque, queda como una tarjeta casi opaca. */
@Composable
fun Modifier.glass(
  shape: Shape,
  state: HazeState? = LocalGlassSource.current,
  tint: Color = Relevo.colors.glass,
  edge: Boolean = true,
): Modifier {
  val colors = Relevo.colors
  val clipped = this.clip(shape)
  val surface = if (state != null) clipped.hazeEffect(state, glassStyle(tint)) else clipped.background(colors.card.copy(alpha = .96f))
  return if (edge) surface.border(0.75.dp, colors.glassEdge, shape) else surface
}

private val EdgeEasing = CubicBezierEasing(0.4f, 0f, 0.6f, 1f)

/** Arriba, el desenfoque es completo bajo la barra y se desvanece en el último tramo. */
private val TopEdgeEasing = Easing { t -> ((t - 0.58f) / 0.42f).coerceIn(0f, 1f) }

/** Abajo, se completa enseguida detrás de los botones. */
private val BottomEdgeEasing = Easing { t -> (t / 0.32f).coerceIn(0f, 1f) }

/**
 * Borde de desplazamiento, como en iOS 26: el contenido se desenfoca y se funde con el papel al pasar
 * bajo una barra. [fromTop] indica dónde el efecto es completo.
 */
@Composable
fun Modifier.edgeBlur(state: HazeState?, fromTop: Boolean, alpha: Float = 1f): Modifier {
  if (state == null) return this
  val style = glassStyle(Relevo.colors.paper.copy(alpha = if (Relevo.colors.isDark) .84f else .80f), blur = 22.dp)
  return this.hazeEffect(state, style) {
    this.alpha = alpha
    progressive = HazeProgressive.verticalGradient(
      easing = if (fromTop) TopEdgeEasing else BottomEdgeEasing,
      startIntensity = if (fromTop) 1f else 0f,
      endIntensity = if (fromTop) 0f else 1f,
    )
  }
}

/**
 * Banda de vidrio sobre la parte baja de una foto: empieza transparente y termina desenfocada, para
 * que el texto se lea sin velos opacos.
 */
@Composable
fun Modifier.photoBand(state: HazeState): Modifier {
  val colors = Relevo.colors
  val style = glassStyle(colors.paper.copy(alpha = if (colors.isDark) .7f else .64f), blur = 26.dp)
  return this.hazeEffect(state, style) {
    progressive = HazeProgressive.verticalGradient(easing = BandEasing, startIntensity = 0f, endIntensity = 1f)
  }
}

/** La banda llega pronto a su intensidad completa, para que el texto siempre se lea sobre vidrio. */
private val BandEasing = Easing { t -> val x = (t / 0.5f).coerceIn(0f, 1f); 1f - (1f - x) * (1f - x) }

/** Botón redondo de vidrio para la barra: volver, cerrar, más opciones. Área táctil de 44 dp. */
@Composable
fun GlassIconButton(icon: KitIcon, description: String, onClick: () -> Unit, modifier: Modifier = Modifier, size: Dp = 44.dp) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  Box(
    modifier.size(size).pressScale(interaction, 0.92f).glass(CircleShape)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .semantics { contentDescription = description },
    contentAlignment = Alignment.Center,
  ) {
    RelevoIcon(icon, size = 20.dp, tint = Relevo.colors.ink.copy(alpha = if (pressed) .55f else 1f), background = Color.Transparent, strokeWidth = 2f)
  }
}

/** Botón de texto en cápsula de vidrio: «Saltar», «Listo». */
@Composable
fun GlassTextButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier, icon: KitIcon? = null, color: Color = Relevo.colors.ink) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  Row(
    modifier.heightIn(min = 44.dp).pressScale(interaction, 0.95f).glass(Relevo.controlShape)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onClick)
      .padding(horizontal = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    val tint = color.copy(alpha = if (pressed) .55f else 1f)
    if (icon != null) {
      RelevoIcon(icon, size = 18.dp, tint = tint, background = Color.Transparent)
      Spacer(Modifier.width(6.dp))
    }
    Text(label, style = Relevo.type.headline.copy(fontSize = Relevo.type.subhead.fontSize), color = tint)
  }
}
