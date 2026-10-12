package com.example.relevo.ui.components

import android.graphics.RuntimeShader
import android.os.Build
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.Canvas
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import com.example.relevo.data.AuraLevel
import com.example.relevo.theme.Relevo
import kotlin.math.cos
import kotlin.math.sin

/** Cuánta aura quiere la persona (Perfil › Apariencia y aura). La da RelevoApp desde los ajustes. */
val LocalAuraLevel = compositionLocalOf { AuraLevel.MEDIUM }

/**
 * Cómo se mueve el aura según el momento (D-103, el color sube con el momento): en calma al abrir,
 * lenta mientras cuenta y más viva en la vista previa de los ajustes.
 */
enum class AuraMood(internal val scale: Float, internal val speed: Float) {
  CALM(.62f, 1f),
  COUNTING(.66f, .55f),
  PREVIEW(.7f, .8f),
}

/** Intensidad de cada nivel: apagada, suave, media o viva. */
private fun AuraLevel.strength(): Float = when (this) {
  AuraLevel.OFF -> 0f
  AuraLevel.SOFT -> .55f
  AuraLevel.MEDIUM -> .85f
  AuraLevel.STRONG -> 1.05f
}

/** Luces del aura: mantequilla, rubor, lila, celeste y una luz tibia al centro (D-121). */
private val AuraColors = listOf(Color(0xFFFFD54A), Color(0xFFF6A3CB), Color(0xFFC5B2F6), Color(0xFF9DD6F4), Color(0xFFFFF3D6))

/**
 * El aura de la pantalla (D-121): cinco luces que se mueven despacio, con grano. Es de la app y no del
 * Tag, que no emite luz. Desde Android 13 se dibuja con un sombreador; en Android 12, con quitar el
 * movimiento del sistema o con el aura apagada, queda quieta. Apagada, es papel.
 */
@Composable
fun AuraBackground(
  modifier: Modifier = Modifier,
  mood: AuraMood = AuraMood.COUNTING,
  level: AuraLevel = LocalAuraLevel.current,
  content: @Composable BoxScope.() -> Unit = {},
) {
  val colors = Relevo.colors
  val strength = level.strength() * if (colors.isDark) .7f else 1f
  val reduce = rememberReduceMotion()
  val shaders = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
  val moving = shaders && !reduce && strength > 0f
  val time: State<Float> = if (moving) {
    produceState(3f, mood) {
      var start = -1L
      while (true) withFrameNanos { now -> if (start < 0) start = now; value = 3f + (now - start) / 1_000_000_000f * mood.speed }
    }
  } else remember { mutableFloatStateOf(3f) }
  val paper = colors.paper
  Box(
    modifier.drawWithCache {
      if (strength <= 0f) return@drawWithCache onDrawBehind { drawRect(paper) }
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val aura = AuraShader.create(paper)
        onDrawBehind {
          AuraShader.update(aura, size.width, size.height, time.value, strength, mood.scale)
          drawRect(ShaderBrush(aura))
        }
      } else {
        // Sin sombreador: las mismas luces, quietas, como degradados.
        val w = size.width; val h = size.height; val unit = minOf(w, h) * mood.scale
        val t = 3f
        val centers = listOf(
          Offset(-0.06f + 0.07f * cos(t * 0.25f + 0.7f), -0.15f + 0.06f * sin(t * 0.37f)),
          Offset(0.08f + 0.06f * sin(t * 0.29f + 2.1f), 0.17f + 0.05f * cos(t * 0.33f)),
          Offset(0.22f + 0.08f * cos(t * 0.23f + 1.3f), -0.04f + 0.07f * sin(t * 0.35f)),
          Offset(-0.20f + 0.07f * sin(t * 0.31f), 0.05f + 0.08f * cos(t * 0.27f)),
          Offset(0.02f + 0.05f * sin(t * 0.41f + 3.0f), -0.02f + 0.04f * cos(t * 0.39f)),
        )
        val radii = listOf(0.27f, 0.24f, 0.25f, 0.26f, 0.13f)
        onDrawBehind {
          drawRect(paper)
          centers.forEachIndexed { i, c ->
            val color = AuraColors[i]
            val center = Offset(w / 2 + c.x * unit, h / 2 - c.y * unit)
            drawRect(Brush.radialGradient(0f to color.copy(alpha = strength.coerceAtMost(1f)), 1f to color.copy(alpha = 0f), center = center, radius = radii[i] * unit * 1.9f))
          }
        }
      }
    },
  ) { content() }
}

/** El sombreador del aura en AGSL: el mismo de «Relevo con aura», con su grano. */
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
private object AuraShader {
  private const val SOURCE = """
    uniform float2 r;
    uniform float t;
    uniform float k;
    uniform float s;
    uniform float3 bg;
    uniform float3 c0;
    uniform float3 c1;
    uniform float3 c2;
    uniform float3 c3;
    uniform float3 c4;
    float h(float2 q) {
      float3 p3 = fract(float3(q.x, q.y, q.x) * 0.1031);
      p3 += dot(p3, p3.yzx + 33.33);
      return fract((p3.x + p3.y) * p3.z);
    }
    float3 blob(float3 col, float2 p, float2 c, float rad, float3 tint) {
      float2 d = p - c;
      float w = exp(-dot(d, d) / (rad * rad)) * k;
      return mix(col, tint, clamp(w, 0.0, 1.0));
    }
    half4 main(float2 fc) {
      float2 p = fc / r - 0.5;
      p.x *= r.x / r.y;
      p /= s;
      p.y = -p.y;
      float3 col = bg;
      col = blob(col, p, float2(-0.20 + 0.07 * sin(t * 0.31), 0.05 + 0.08 * cos(t * 0.27)), 0.26, c3);
      col = blob(col, p, float2(0.22 + 0.08 * cos(t * 0.23 + 1.3), -0.04 + 0.07 * sin(t * 0.35)), 0.25, c2);
      col = blob(col, p, float2(0.08 + 0.06 * sin(t * 0.29 + 2.1), 0.17 + 0.05 * cos(t * 0.33)), 0.24, c1);
      col = blob(col, p, float2(-0.06 + 0.07 * cos(t * 0.25 + 0.7), -0.15 + 0.06 * sin(t * 0.37)), 0.27, c0);
      col = blob(col, p, float2(0.02 + 0.05 * sin(t * 0.41 + 3.0), -0.02 + 0.04 * cos(t * 0.39)), 0.13, c4);
      col += (h(fc + fract(t * 7.0) * 61.0) - 0.5) * 0.045;
      return half4(half3(col), 1.0);
    }
  """

  fun create(paper: Color): RuntimeShader = RuntimeShader(SOURCE).apply {
    setFloatUniform("bg", paper.red, paper.green, paper.blue)
    listOf("c0", "c1", "c2", "c3", "c4").forEachIndexed { i, name -> val c = AuraColors[i]; setFloatUniform(name, c.red, c.green, c.blue) }
  }

  fun update(shader: RuntimeShader, width: Float, height: Float, time: Float, strength: Float, scale: Float) {
    shader.setFloatUniform("r", width.coerceAtLeast(1f), height.coerceAtLeast(1f))
    shader.setFloatUniform("t", time)
    shader.setFloatUniform("k", strength)
    shader.setFloatUniform("s", scale)
  }
}

/**
 * El sonido dibujado como anillos de tinta que se abren desde el objeto (D-121, D-122): el Tag suena,
 * no brilla. Sin movimiento del sistema, quedan tres anillos quietos y tenues.
 */
@Composable
fun SoundRings(modifier: Modifier = Modifier, color: Color = Relevo.colors.onTile) {
  val reduce = rememberReduceMotion()
  val phase = if (reduce) null else rememberInfiniteTransition(label = "rings").animateFloat(
    0f, 1f, infiniteRepeatable(tween(2400, easing = LinearEasing)), label = "ring_phase",
  )
  Canvas(modifier) {
    val base = size.minDimension / 2f
    val stroke = Stroke(width = 1.4.dp.toPx())
    for (i in 0 until 3) {
      val p = phase?.value?.let { (it + i / 3f) % 1f } ?: ((i + 1) / 4f)
      val alpha = if (phase == null) .2f - i * .05f else (1f - p) * .5f
      drawCircle(color.copy(alpha = alpha.coerceIn(0f, 1f)), radius = base * (1f + p * 1.4f), style = stroke)
    }
  }
}
