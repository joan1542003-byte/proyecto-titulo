package com.example.relevo.ui.components

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.BitmapFactory
import android.util.LruCache
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.relevo.theme.DarkColors
import com.example.relevo.theme.LightColors
import com.example.relevo.theme.Relevo
import com.example.relevo.theme.RelevoColors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Tono de la foto que queda bajo un texto (D-084). Si esa zona es oscura, el texto y el vidrio de
 * encima toman la paleta de noche; si es clara, la de papel. Así nunca queda texto negro sobre una
 * foto oscura ni texto blanco sobre una clara. Se calcula una vez por foto y zona, con una copia de
 * unos 64 px de ancho y fuera del hilo principal.
 */
object PhotoTone {
  private val cache = LruCache<String, Float>(128)

  /** Luminancia media de la franja vertical [from]–[to] (fracciones del marco) de una foto recortada. */
  suspend fun luminance(context: Context, @DrawableRes res: Int, frameAspect: Float, from: Float, to: Float): Float {
    val key = "$res:${(frameAspect * 100).roundToInt()}:${(from * 20).roundToInt()}:${(to * 20).roundToInt()}"
    cache.get(key)?.let { return it }
    val value = withContext(Dispatchers.Default) {
      val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
      BitmapFactory.decodeResource(context.resources, res, bounds)
      var sample = 1
      while (bounds.outWidth / (sample * 2) >= 64) sample *= 2
      val bitmap = BitmapFactory.decodeResource(context.resources, res, BitmapFactory.Options().apply { inSampleSize = sample })
        ?: return@withContext 1f
      val (left, top, width, height) = ToneMath.visibleArea(bitmap.width, bitmap.height, frameAspect).toList()
      val y0 = top + (height * from.coerceIn(0f, 1f)).toInt()
      val y1 = (top + (height * to.coerceIn(0f, 1f)).toInt()).coerceAtLeast(y0 + 1).coerceAtMost(bitmap.height)
      val pixels = IntArray(width * (y1 - y0))
      bitmap.getPixels(pixels, 0, width, left, y0, width, y1 - y0)
      bitmap.recycle()
      ToneMath.meanLuminance(pixels)
    }
    cache.put(key, value)
    return value
  }
}

/** Cálculos del tono, sin dependencias de Android, para poder probarlos. */
object ToneMath {
  /**
   * Bajo esta luminancia media (lineal, de 0 a 1) se usa la paleta de noche. Es el punto en que el
   * texto blanco y el de tinta tienen el mismo contraste sobre la foto (WCAG 2.2).
   */
  const val DARK_BELOW = 0.19f

  private val linear = FloatArray(256) { i ->
    val c = i / 255f
    if (c <= 0.04045f) c / 12.92f else ((c + 0.055f) / 1.055f).pow(2.4f)
  }

  /**
   * Parte de la imagen que se ve cuando se recorta al centro para llenar un marco de proporción
   * [frameAspect] (ancho sobre alto), como `ContentScale.Crop`: izquierda, arriba, ancho y alto.
   */
  fun visibleArea(width: Int, height: Int, frameAspect: Float): IntArray {
    val imageAspect = width.toFloat() / height
    return if (imageAspect > frameAspect) {
      val visible = (height * frameAspect).roundToInt().coerceIn(1, width)
      intArrayOf((width - visible) / 2, 0, visible, height)
    } else {
      val visible = (width / frameAspect).roundToInt().coerceIn(1, height)
      intArrayOf(0, (height - visible) / 2, width, visible)
    }
  }

  /** Luminancia relativa media de píxeles ARGB: sRGB a lineal y pesos de Rec. 709. */
  fun meanLuminance(pixels: IntArray): Float {
    if (pixels.isEmpty()) return 1f
    var sum = 0.0
    pixels.forEach { p ->
      sum += 0.2126f * linear[(p shr 16) and 0xff] + 0.7152f * linear[(p shr 8) and 0xff] + 0.0722f * linear[p and 0xff]
    }
    return (sum / pixels.size).toFloat()
  }
}

/**
 * Si la franja [from]–[to] de la foto es oscura, en un marco de proporción [frameAspect]. Es null
 * mientras se calcula y cuando la imagen no es una foto (un icono sobre niebla sigue el tema).
 */
@Composable
fun rememberPhotoDark(picture: Picture?, wide: Boolean, frameAspect: Float, from: Float, to: Float): Boolean? {
  val photo = (picture as? Picture.OfPhoto)?.photo ?: return null
  val res = if (wide) photo.wide ?: photo.res else photo.res
  val context = LocalContext.current
  val dark by produceState<Boolean?>(null, res, frameAspect, from, to) {
    value = PhotoTone.luminance(context, res, frameAspect, from, to) < ToneMath.DARK_BELOW
  }
  return dark
}

/** Paleta para lo que va sobre una foto: la de noche si la zona es oscura, la de papel si es clara. */
@Composable
fun paletteOver(dark: Boolean?): RelevoColors = when (dark) {
  true -> DarkColors
  false -> LightColors
  null -> Relevo.colors
}

/**
 * Pedidos de tono de la barra de estado. Al pasar de una foto a otra, la pantalla nueva pide su tono
 * antes de que la anterior se vaya; por eso, al irse una, se aplica el último pedido que sigue vivo.
 */
private object StatusBarRequests {
  val active = mutableListOf<Pair<Any, Boolean>>()
}

/**
 * Iconos de la barra de estado claros sobre fondos oscuros y oscuros sobre fondos claros. Al salir,
 * vuelven a los de la pantalla que queda o a los del tema.
 */
@Composable
fun StatusBarTone(darkBackground: Boolean) {
  val view = LocalView.current
  val themeDark = Relevo.colors.isDark
  val token = remember { Any() }
  if (view.isInEditMode) return
  DisposableEffect(darkBackground, themeDark) {
    val window = view.context.findActivity()?.window
    val controller = window?.let { WindowCompat.getInsetsController(it, view) }
    StatusBarRequests.active.removeAll { it.first === token }
    StatusBarRequests.active.add(token to darkBackground)
    controller?.isAppearanceLightStatusBars = !darkBackground
    onDispose {
      StatusBarRequests.active.removeAll { it.first === token }
      controller?.isAppearanceLightStatusBars = !(StatusBarRequests.active.lastOrNull()?.second ?: themeDark)
    }
  }
}

private tailrec fun Context.findActivity(): Activity? = when (this) {
  is Activity -> this
  is ContextWrapper -> baseContext.findActivity()
  else -> null
}
