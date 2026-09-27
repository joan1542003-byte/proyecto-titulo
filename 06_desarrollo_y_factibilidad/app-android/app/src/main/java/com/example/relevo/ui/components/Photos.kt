package com.example.relevo.ui.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cl.udp.relevo.R
import com.example.relevo.theme.Relevo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Fotos de la app. Muestran el comienzo, no el resultado: lo que espera, con su primer paso a la
 * vista (D-073). Todas pasan por la receta de imagen del proyecto; el texto va siempre fuera de la
 * foto, sin velos ni degradados encima. Procedencia y licencias en `licencias/README.md`.
 */
enum class Photo(@param:DrawableRes val res: Int, val description: String, @param:DrawableRes val wide: Int? = null) {
  CAMINAR(R.drawable.foto_caminar, "Zapatillas listas para salir"),
  EJERCICIO(R.drawable.foto_ejercicio, "Dos pesas en el suelo"),
  LEER(R.drawable.foto_leer, "Un libro abierto sobre la mesa"),
  ESTUDIAR(R.drawable.foto_estudiar, "Un cuaderno con un lápiz"),
  DIBUJAR(R.drawable.foto_dibujar, "Un cuaderno de dibujo abierto"),
  COCINAR(R.drawable.foto_cocinar, "Ingredientes y una cuchara de palo"),
  ORDENAR(R.drawable.foto_ordenar, "Toallas dobladas junto a un canasto"),
  PERRO(R.drawable.foto_perro, "La correa del perro junto a la puerta"),
  MANUALIDADES(R.drawable.foto_manualidades, "Papeles de colores y tijeras sobre la mesa"),
  GUITARRA(R.drawable.foto_guitarra, "Una mano sobre una guitarra"),
  ESCRIBIR(R.drawable.foto_escribir, "Una mano que empieza a escribir"),
  LIBRO(R.drawable.foto_libro, "Las páginas de un libro abierto"),
  APRENDER(R.drawable.foto_aprender, "Manos sobre un cuaderno con una regla"),
  PAN(R.drawable.foto_pan, "Manos que amasan"),
  PINTAR(R.drawable.foto_pintar, "Acuarelas, pinceles y un croquis"),
  PUERTA(R.drawable.foto_puerta, "Zapatillas y el parlante junto a la puerta", R.drawable.foto_puerta_ancha),
  SALIDA(R.drawable.foto_salida, "Zapatillas junto a la puerta abierta", R.drawable.foto_salida_ancha),
  TIEMPO(R.drawable.foto_tiempo, "Un teléfono boca abajo junto a un reloj de tiempo", R.drawable.foto_tiempo_ancha);

  val key: String get() = "foto:$name"
}

/** Imagen elegida por la persona para su perfil o una actividad: una foto o un icono del kit. */
sealed interface Picture {
  data class OfPhoto(val photo: Photo) : Picture
  data class OfIcon(val icon: KitIcon) : Picture

  companion object {
    /** «foto:LEER», «icono:GUITARRA» y las claves de actividades guardadas antes de 2.8. */
    fun parse(key: String?): Picture? {
      if (key.isNullOrBlank()) return null
      val value = key.substringAfter(':')
      return when {
        key.startsWith("foto:") -> runCatching { OfPhoto(Photo.valueOf(value)) }.getOrNull()
        key.startsWith("icono:") -> runCatching { OfIcon(KitIcon.valueOf(value)) }.getOrNull()
        else -> legacyIcon(key)?.let(::OfIcon)
      }
    }

    private fun legacyIcon(key: String): KitIcon? = when (key) {
      "walk" -> KitIcon.CAMINAR
      "train" -> KitIcon.EJERCICIO
      "read" -> KitIcon.LEER
      "draw" -> KitIcon.DIBUJAR
      "music" -> KitIcon.MUSICA
      "cook" -> KitIcon.COCINAR
      "pause", "star" -> KitIcon.ACTIVIDAD
      else -> runCatching { KitIcon.valueOf(key) }.getOrNull()
    }
  }
}

val KitIcon.key: String get() = "icono:$name"

/** Resolución de carga: las miniaturas se decodifican a la mitad para no gastar memoria. */
enum class PhotoSize(internal val sample: Int) { Thumb(2), Full(1) }

/** Caché de fotos ya decodificadas: al volver a una pantalla, la foto aparece sin esperar. */
private object PhotoCache {
  private val cache = object : LruCache<Int, ImageBitmap>(48 * 1024 * 1024) {
    override fun sizeOf(key: Int, value: ImageBitmap): Int = value.width * value.height * 4
  }
  fun get(key: Int): ImageBitmap? = cache.get(key)
  fun put(key: Int, value: ImageBitmap) { cache.put(key, value) }
}

/**
 * Foto que se carga fuera del hilo principal y aparece con un fundido breve. Mientras carga, el
 * espacio queda en niebla, del mismo tamaño, para que nada salte.
 */
@Composable
fun PhotoImage(photo: Photo, modifier: Modifier = Modifier, wide: Boolean = false, size: PhotoSize = PhotoSize.Full, describe: Boolean = false) {
  val res = if (wide) photo.wide ?: photo.res else photo.res
  val key = res * 4 + size.sample
  val context = LocalContext.current
  val reduce = rememberReduceMotion()
  var bitmap by remember(key) { mutableStateOf(PhotoCache.get(key)) }
  val alpha = remember(key) { Animatable(if (bitmap != null || reduce) 1f else 0f) }
  LaunchedEffect(key) {
    if (bitmap == null) {
      bitmap = withContext(Dispatchers.IO) {
        val options = BitmapFactory.Options().apply { inSampleSize = size.sample; inPreferredConfig = Bitmap.Config.HARDWARE }
        runCatching { BitmapFactory.decodeResource(context.resources, res, options)?.asImageBitmap() }.getOrNull()?.also { PhotoCache.put(key, it) }
      }
    }
    if (alpha.value < 1f) alpha.animateTo(1f, tween(220, easing = Motion.Easing))
  }
  Box(modifier.background(Relevo.colors.mist).then(if (describe) Modifier.semantics { contentDescription = photo.description } else Modifier)) {
    bitmap?.let {
      Image(it, contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize().graphicsLayer { this.alpha = alpha.value })
    }
  }
}

/** Escenas para las transiciones compartidas entre pantallas (la foto viaja de la tarjeta al detalle). */
@OptIn(ExperimentalSharedTransitionApi::class)
val LocalSharedScope = compositionLocalOf<SharedTransitionScope?> { null }
val LocalNavScope = compositionLocalOf<AnimatedVisibilityScope?> { null }

/** La foto viaja entre pantallas cuando dos elementos visibles comparten [key]. */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Modifier.sharedPhoto(key: String?): Modifier {
  val shared = LocalSharedScope.current
  val scope = LocalNavScope.current
  if (key == null || shared == null || scope == null || rememberReduceMotion()) return this
  return with(shared) { this@sharedPhoto.sharedElement(rememberSharedContentState(key), scope) }
}

/** Contenido de una ficha: foto o icono del kit sobre niebla. */
@Composable
fun PictureContent(picture: Picture?, modifier: Modifier = Modifier, iconSize: Dp = 36.dp, fallback: KitIcon = KitIcon.ACTIVIDAD, size: PhotoSize = PhotoSize.Full, wide: Boolean = false) {
  when (picture) {
    is Picture.OfPhoto -> PhotoImage(picture.photo, modifier, wide = wide, size = size)
    else -> Box(modifier.background(Relevo.colors.mist), contentAlignment = Alignment.Center) {
      RelevoIcon((picture as? Picture.OfIcon)?.icon ?: fallback, size = iconSize, tint = Relevo.colors.ink, background = Relevo.colors.mist)
    }
  }
}

/**
 * Ficha de actividad: foto 4:5 con el nombre debajo, sobre papel (el texto nunca va sobre la foto).
 * Al presionar se hunde un poco; la foto puede viajar a la pantalla siguiente.
 */
@Composable
fun PhotoCard(
  title: String,
  picture: Picture?,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  subtitle: String? = null,
  width: Dp = 152.dp,
  sharedKey: String? = null,
  fallback: KitIcon = KitIcon.ACTIVIDAD,
) {
  val interaction = remember { MutableInteractionSource() }
  Column(
    modifier.width(width).pressScale(interaction)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = title, onClick = onClick),
  ) {
    PictureContent(
      picture, Modifier.fillMaxWidth().aspectRatio(0.8f).sharedPhoto(sharedKey).clip(Relevo.panelShape),
      fallback = fallback, iconSize = 40.dp,
    )
    Spacer(Modifier.height(10.dp))
    Text(title, style = Relevo.type.headline, color = Relevo.colors.ink, maxLines = 2, overflow = TextOverflow.Ellipsis)
    if (subtitle != null) {
      Spacer(Modifier.height(2.dp))
      Text(subtitle, style = Relevo.type.footnote, color = Relevo.colors.graphite, maxLines = 2, overflow = TextOverflow.Ellipsis)
    }
  }
}

/** Ficha elegible en una cuadrícula: la elegida lleva un borde de tinta y la marca de listo. */
@Composable
fun PictureTile(
  picture: Picture?,
  selected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  label: String? = null,
  description: String = label.orEmpty(),
  aspect: Float = 0.8f,
  shape: Shape = Relevo.controlShape,
  /** Rótulo destacado, para opciones grandes como los intereses. */
  prominent: Boolean = false,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  Column(
    modifier.pressScale(interaction)
      .clickable(interactionSource = interaction, indication = null, role = Role.RadioButton, onClick = onClick)
      .semantics { this.selected = selected; contentDescription = description },
  ) {
    Box(Modifier.fillMaxWidth().aspectRatio(aspect)) {
      PictureContent(picture, Modifier.fillMaxSize().clip(shape), size = PhotoSize.Thumb, iconSize = 30.dp)
      if (selected) {
        Box(Modifier.fillMaxSize().border(2.5.dp, colors.ink, shape))
        Box(
          Modifier.align(Alignment.TopEnd).padding(6.dp).size(24.dp).background(colors.ink, RoundedCornerShape(7.dp)),
          contentAlignment = Alignment.Center,
        ) { RelevoIcon(KitIcon.COMENCE, size = 16.dp, tint = colors.onInk, background = colors.ink) }
      }
    }
    if (label != null) {
      Spacer(Modifier.height(6.dp))
      Text(label, style = if (prominent) Relevo.type.headline else Relevo.type.footnote, color = if (selected || prominent) colors.ink else colors.graphite, maxLines = 2, overflow = TextOverflow.Ellipsis)
    }
  }
}

/**
 * Imagen de la persona: una foto o un icono que eligió (P2), en una ficha con esquinas de 20.
 * Sin imagen, muestra la inicial de su nombre o el icono de perfil.
 */
@Composable
fun Avatar(image: String, name: String, size: Dp, modifier: Modifier = Modifier) {
  androidx.compose.animation.Crossfade(targetState = image to name.trim().firstOrNull()?.uppercaseChar(), animationSpec = Motion.standard(), label = "avatar", modifier = modifier) { (shown, _) ->
    AvatarContent(shown, name, size)
  }
}

@Composable
private fun AvatarContent(image: String, name: String, size: Dp, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val shape = RoundedCornerShape(size * 0.28f)
  when (val picture = Picture.parse(image)) {
    is Picture.OfPhoto -> PhotoImage(picture.photo, modifier.size(size).clip(shape), size = PhotoSize.Thumb)
    is Picture.OfIcon -> Box(modifier.size(size).clip(shape).background(colors.mist), contentAlignment = Alignment.Center) {
      RelevoIcon(picture.icon, size = size * 0.5f, background = colors.mist)
    }
    null -> Box(modifier.size(size).clip(shape).background(colors.mist), contentAlignment = Alignment.Center) {
      val initial = name.trim().firstOrNull()?.uppercaseChar()
      if (initial != null) Text(initial.toString(), style = Relevo.type.title.copy(fontSize = Relevo.type.title.fontSize * (size.value / 72f)), color = colors.ink)
      else RelevoIcon(KitIcon.PERFIL, size = size * 0.5f, background = colors.mist)
    }
  }
}
