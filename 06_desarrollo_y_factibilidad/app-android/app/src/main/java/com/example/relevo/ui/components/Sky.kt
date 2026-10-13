package com.example.relevo.ui.components

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.random.Random

/** Una luz de un cielo: color y posición (fracciones del marco) y radio (fracción del lado mayor). */
internal class SkyBlob(val color: Color, val x: Float, val y: Float, val radius: Float)

/**
 * Cielos de las actividades (D-126): siete familias, cada una con el color que viene de lo que la
 * actividad es. Son degradados con grano y volumen, un material distinto de las fichas planas de
 * los papeles, para que el color de una actividad no se confunda con el de una función.
 */
enum class Sky(internal val base: Color, internal val blobs: List<SkyBlob>) {
  /** Moverse y aire libre: verde de pasto y hojas, naturaleza y esperanza. */
  MENTA(Color(0xFFBFE7D3), listOf(SkyBlob(Color(0xFF3FB487), .2f, .8f, .6f), SkyBlob(Color(0xFFE6F7FF), .7f, .25f, .55f), SkyBlob(Color(0xFF9ED6F4), .85f, .75f, .5f), SkyBlob(Color(0xFF5FC79A), .4f, .45f, .4f))),
  /** Leer y aprender: azul de mar y cielo, que activa poco. */
  CIELO(Color(0xFF8DB9EA), listOf(SkyBlob(Color(0xFF2559C9), .2f, .85f, .6f), SkyBlob(Color(0xFFE9F3FF), .6f, .35f, .45f), SkyBlob(Color(0xFF7EA9E8), .85f, .7f, .45f), SkyBlob(Color(0xFFF7FBFF), .35f, .2f, .35f), SkyBlob(Color(0xFF3B6BD2), .9f, .1f, .35f))),
  /** Crear: un atardecer de varios tonos, porque «creativo» no tiene un color propio. */
  ATARDECER(Color(0xFFF3B38E), listOf(SkyBlob(Color(0xFFF06A3B), .25f, .3f, .5f), SkyBlob(Color(0xFFF7C6DD), .8f, .3f, .5f), SkyBlob(Color(0xFFB9A4F2), .75f, .85f, .5f), SkyBlob(Color(0xFFFFE6A6), .3f, .8f, .4f))),
  /** Jugar y disfrutar: ámbar y violeta, alegría y diversión. */
  AMBAR(Color(0xFFE9B85C), listOf(SkyBlob(Color(0xFFF2A20C), .2f, .3f, .6f), SkyBlob(Color(0xFFB78BEF), .85f, .2f, .55f), SkyBlob(Color(0xFFF7D27A), .5f, .7f, .45f), SkyBlob(Color(0xFF9C7BE8), .9f, .85f, .4f))),
  /** La casa: el naranja del fuego y la cocina, sin llegar al rojo. */
  BRASA(Color(0xFFF28A4A), listOf(SkyBlob(Color(0xFFE8501E), .2f, .75f, .6f), SkyBlob(Color(0xFFF9B36B), .75f, .3f, .55f), SkyBlob(Color(0xFFFFE0B8), .55f, .1f, .4f), SkyBlob(Color(0xFFC9370F), .9f, .9f, .35f))),
  /** Descansar: azul de noche con luces lavanda; nunca negro. */
  NOCHE(Color(0xFF2B3A66), listOf(SkyBlob(Color(0xFF0F1A3D), .2f, .3f, .6f), SkyBlob(Color(0xFF5E7BD8), .8f, .7f, .55f), SkyBlob(Color(0xFFA9B8F5), .6f, .2f, .35f), SkyBlob(Color(0xFF1E2B5C), .9f, .9f, .4f))),
  /** Personas: rosa de amor y ternura. */
  ROSA(Color(0xFFF4C9D2), listOf(SkyBlob(Color(0xFFC8325A), .25f, .35f, .55f), SkyBlob(Color(0xFFF7A9BE), .75f, .25f, .5f), SkyBlob(Color(0xFFFFFFFF), .55f, .6f, .35f), SkyBlob(Color(0xFFE0617F), .3f, .85f, .45f))),
  /** Lo que no tiene familia: el aura suave. */
  AURA(Color(0xFFFBF5EC), listOf(SkyBlob(Color(0xFFFFD54A).copy(alpha = .75f), .25f, .75f, .55f), SkyBlob(Color(0xFFF6A3CB).copy(alpha = .75f), .7f, .3f, .5f), SkyBlob(Color(0xFF9DD6F4).copy(alpha = .75f), .15f, .2f, .45f), SkyBlob(Color(0xFFC5B2F6).copy(alpha = .75f), .9f, .8f, .45f))),
  ;

  /** Tres colores representativos, para ilustraciones que usan la familia (la guía del Tag). */
  internal val palette: List<Color> get() = blobs.map { it.color.copy(alpha = 1f) }.take(3)
}

/** La familia de una actividad, por su ícono. Las que la app no reconoce toman el aura suave. */
fun skyFor(icon: KitIcon): Sky = when (icon) {
  KitIcon.CAMINAR, KitIcon.EJERCICIO, KitIcon.BICICLETA, KitIcon.SALIR, KitIcon.PLANTAS -> Sky.MENTA
  KitIcon.LEER, KitIcon.ESTUDIAR, KitIcon.ESCRIBIR, KitIcon.TEXTO -> Sky.CIELO
  KitIcon.DIBUJAR, KitIcon.PINTAR, KitIcon.MANUALIDADES, KitIcon.FOTOGRAFIA -> Sky.ATARDECER
  KitIcon.VIDEOJUEGOS, KitIcon.JUEGO_DE_MESA, KitIcon.MUSICA, KitIcon.GUITARRA, KitIcon.REPRODUCIR -> Sky.AMBAR
  KitIcon.COCINAR, KitIcon.ORDENAR -> Sky.BRASA
  KitIcon.DORMIR, KitIcon.ESTIRAR -> Sky.NOCHE
  KitIcon.LLAMAR -> Sky.ROSA
  else -> Sky.AURA
}

/** Grano de papel: ruido de 128 px que se repite, calculado una sola vez. */
private object Grain {
  val image: ImageBitmap by lazy {
    val size = 128
    val random = Random(7)
    val pixels = IntArray(size * size) {
      val v = random.nextInt(256)
      (random.nextInt(10, 24) shl 24) or (v shl 16) or (v shl 8) or v
    }
    Bitmap.createBitmap(pixels, size, size, Bitmap.Config.ARGB_8888).asImageBitmap()
  }
  val brush: ShaderBrush by lazy { ShaderBrush(ImageShader(image, TileMode.Repeated, TileMode.Repeated)) }
}

/**
 * Pinta un cielo en el área dada: su color de base, sus luces y el grano. [variant] (0 a 3) refleja las
 * luces a lo ancho o a lo alto (3.2): dos actividades de la misma familia comparten el color, pero no el
 * mismo cielo, así una cuadrícula no repite fichas idénticas.
 */
internal fun DrawScope.drawSky(sky: Sky, grain: Boolean = true, variant: Int = 0) {
  val w = size.width
  val h = size.height
  val m = maxOf(w, h)
  val flipX = variant and 1 == 1
  val flipY = variant and 2 == 2
  drawRect(sky.base)
  sky.blobs.forEach { blob ->
    val c = blob.color
    val x = if (flipX) 1f - blob.x else blob.x
    val y = if (flipY) 1f - blob.y else blob.y
    drawRect(
      Brush.radialGradient(
        0f to c.copy(alpha = .95f * c.alpha), .55f to c.copy(alpha = .45f * c.alpha), 1f to c.copy(alpha = 0f),
        center = Offset(x * w, y * h), radius = (blob.radius * m).coerceAtLeast(1f),
      ),
    )
  }
  if (grain) drawRect(Grain.brush)
}

/** Fondo de cielo para cualquier contenido. */
@Composable
fun SkyBackground(sky: Sky, modifier: Modifier = Modifier, variant: Int = 0, content: @Composable () -> Unit = {}) {
  Box(modifier.drawBehind { drawSky(sky, variant = variant) }) { content() }
}

/**
 * Orden de las familias en una cuadrícula (3.2): de moverse a descansar, para que los colores vayan
 * agrupados y en orden, y no salpicados.
 */
val SkyOrder = listOf(Sky.MENTA, Sky.CIELO, Sky.ATARDECER, Sky.AMBAR, Sky.BRASA, Sky.NOCHE, Sky.ROSA, Sky.AURA)

/** Nombre de cada familia, para los rótulos de «¿Qué quieres hacer?». */
val Sky.familyName: String get() = when (this) {
  Sky.MENTA -> "Moverte"
  Sky.CIELO -> "Leer y aprender"
  Sky.ATARDECER -> "Crear"
  Sky.AMBAR -> "Jugar y disfrutar"
  Sky.BRASA -> "En casa"
  Sky.NOCHE -> "Descansar"
  Sky.ROSA -> "Con otras personas"
  Sky.AURA -> "Otras"
}
