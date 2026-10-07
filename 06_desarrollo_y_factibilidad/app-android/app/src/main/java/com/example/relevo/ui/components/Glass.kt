package com.example.relevo.ui.components

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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
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

/** Desenfoque de los botones de vidrio: más leve que el de las hojas, para que se vea el fondo (D-084). */
val ControlBlur = 12.dp

/** Desenfoque de la barra de pestañas. */
val BarBlur = 16.dp

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
  blur: Dp = 24.dp,
): Modifier {
  val colors = Relevo.colors
  val clipped = this.clip(shape)
  val surface = if (state != null) clipped.hazeEffect(state, glassStyle(tint, blur)) else clipped.background(colors.card.copy(alpha = .96f))
  return if (edge) surface.border(0.75.dp, colors.glassEdge, shape) else surface
}

/**
 * Borde de desplazamiento, como en iOS 26: el contenido se funde con el papel al pasar bajo una barra.
 * Arriba es completo bajo la barra y se desvanece en la mitad inferior de la franja; abajo empieza a la
 * altura del botón y se completa detrás de las pestañas (D-084). Desde 2.28 es un degradado y no un
 * desenfoque progresivo: el desenfoque se recalculaba en cada cuadro al desplazar y bajaba la app de los
 * 60 cuadros por segundo. [fromTop] indica dónde el efecto es completo.
 */
@Composable
fun Modifier.edgeFade(fromTop: Boolean, alpha: Float = 1f): Modifier {
  val paper = Relevo.colors.paper
  val full = paper.copy(alpha = .94f)
  val clear = paper.copy(alpha = 0f)
  val brush = if (fromTop) Brush.verticalGradient(0f to full, 0.5f to full, 1f to clear)
    else Brush.verticalGradient(0f to clear, 0.2f to clear, 0.7f to full, 1f to full)
  return this.drawBehind { if (alpha > 0f) drawRect(brush, alpha = alpha.coerceAtMost(1f)) }
}

/**
 * Banda sobre la parte baja de una imagen: empieza transparente y llega pronto a un velo de papel, para
 * que el texto se lea. Toma el tono de la paleta vigente (ver [PhotoTone]). Desde 2.28 es un degradado:
 * sobre los fondos de color de las actividades, el desenfoque no se notaba y costaba cuadros.
 */
@Composable
fun Modifier.photoBand(): Modifier {
  val colors = Relevo.colors
  val veil = colors.paper.copy(alpha = if (colors.isDark) .72f else .76f)
  val brush = Brush.verticalGradient(0f to veil.copy(alpha = 0f), 0.5f to veil, 1f to veil)
  return this.background(brush)
}

/** Botón redondo de vidrio para la barra: volver, cerrar, más opciones. Área táctil de 44 dp. */
@Composable
fun GlassIconButton(icon: KitIcon, description: String, onClick: () -> Unit, modifier: Modifier = Modifier, size: Dp = 44.dp) {
  val interaction = remember { MutableInteractionSource() }
  val pressed by interaction.collectIsPressedAsState()
  Box(
    modifier.size(size).pressScale(interaction, 0.92f).glass(CircleShape, blur = ControlBlur)
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
    modifier.heightIn(min = 44.dp).pressScale(interaction, 0.95f).glass(Relevo.controlShape, blur = ControlBlur)
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
