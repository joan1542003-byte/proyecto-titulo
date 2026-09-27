package com.example.relevo.ui.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cl.udp.relevo.R
import com.example.relevo.theme.Relevo
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState
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

/**
 * Emoji 3D de Google (Noto 3D, licencia SIL OFL 1.1) para la imagen del perfil (D-083): objetos de
 * actividades, animales y naturaleza. Se muestran en círculos; no se suben fotos propias.
 */
enum class Emoji(val code: String, @param:DrawableRes val res: Int, val description: String) {
  ZAPATILLA("1f45f", R.drawable.emoji_1f45f, "Zapatilla"),
  LIBROS("1f4da", R.drawable.emoji_1f4da, "Libros"),
  GUITARRA("1f3b8", R.drawable.emoji_1f3b8, "Guitarra"),
  PALETA("1f3a8", R.drawable.emoji_1f3a8, "Paleta de pintura"),
  PLANTA("1fab4", R.drawable.emoji_1fab4, "Planta"),
  SARTEN("1f373", R.drawable.emoji_1f373, "Sartén con un huevo"),
  LANA("1f9f6", R.drawable.emoji_1f9f6, "Ovillo de lana"),
  BICICLETA("1f6b2", R.drawable.emoji_1f6b2, "Bicicleta"),
  CAMARA("1f4f7", R.drawable.emoji_1f4f7, "Cámara"),
  AUDIFONOS("1f3a7", R.drawable.emoji_1f3a7, "Audífonos"),
  LAPIZ("270f", R.drawable.emoji_270f, "Lápiz"),
  PIEZA("1f9e9", R.drawable.emoji_1f9e9, "Pieza de rompecabezas"),
  PIANO("1f3b9", R.drawable.emoji_1f3b9, "Teclado de piano"),
  PELOTA("26bd", R.drawable.emoji_26bd, "Pelota"),
  CAFE("2615", R.drawable.emoji_2615, "Taza de café"),
  PAN("1f35e", R.drawable.emoji_1f35e, "Pan"),
  PERRO("1f436", R.drawable.emoji_1f436, "Perro"),
  GATO("1f431", R.drawable.emoji_1f431, "Gato"),
  ZORRO("1f98a", R.drawable.emoji_1f98a, "Zorro"),
  TORTUGA("1f422", R.drawable.emoji_1f422, "Tortuga"),
  GIRASOL("1f33b", R.drawable.emoji_1f33b, "Girasol"),
  OLA("1f30a", R.drawable.emoji_1f30a, "Ola"),
  LUNA("1f319", R.drawable.emoji_1f319, "Luna"),
  SOL("2600", R.drawable.emoji_2600, "Sol");

  val key: String get() = "emoji:$code"

  companion object {
    fun fromKey(key: String?): Emoji? = key?.takeIf { it.startsWith("emoji:") }?.substringAfter(':')?.let { code -> entries.firstOrNull { it.code == code } }

    /** Quien eligió una foto o un icono antes de 2.9 ve el emoji más cercano. */
    fun forProfile(key: String?): Emoji? = fromKey(key) ?: when (key?.substringAfter(':')) {
      "CAMINAR", "SALIDA", "SALIR" -> ZAPATILLA
      "LEER", "LIBRO" -> LIBROS
      "ESCRIBIR", "ESTUDIAR", "APRENDER" -> LAPIZ
      "DIBUJAR", "PINTAR" -> PALETA
      "MANUALIDADES" -> LANA
      "GUITARRA" -> GUITARRA
      "MUSICA" -> AUDIFONOS
      "COCINAR" -> SARTEN
      "PAN" -> PAN
      "ORDENAR", "PLANTAS" -> PLANTA
      "PERRO" -> PERRO
      "EJERCICIO", "ESTIRAR" -> PELOTA
      "BICICLETA" -> BICICLETA
      "FOTOGRAFIA" -> CAMARA
      "JUEGO_DE_MESA" -> PIEZA
      else -> null
    }
  }
}

/** Emoji 3D del perfil. */
@Composable
fun EmojiImage(emoji: Emoji, modifier: Modifier = Modifier, describe: Boolean = false) {
  Image(
    painter = painterResource(emoji.res),
    contentDescription = if (describe) emoji.description else null,
    modifier = modifier,
  )
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
      picture, Modifier.fillMaxWidth().aspectRatio(0.8f).sharedPhoto(sharedKey).clip(Relevo.tileShape),
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

/**
 * Ficha elegible en una cuadrícula. La elegida se encoge un poco dentro de un anillo de tinta
 * concéntrico, como el selector de fondos de iOS, y muestra una marca redonda.
 */
@Composable
fun PictureTile(
  picture: Picture?,
  selected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  label: String? = null,
  description: String = label.orEmpty(),
  aspect: Float = 0.8f,
  cornerRadius: Dp = 22.dp,
  /** Rótulo destacado, para opciones grandes como los intereses. */
  prominent: Boolean = false,
) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val inset by animateDpAsState(if (selected) 5.dp else 0.dp, Motion.smooth(stiffness = 600f), label = "tile_inset")
  Column(
    modifier.pressScale(interaction)
      .clickable(interactionSource = interaction, indication = null, role = Role.RadioButton, onClick = onClick)
      .semantics { this.selected = selected; contentDescription = description },
  ) {
    Box(Modifier.fillMaxWidth().aspectRatio(aspect)) {
      PictureContent(picture, Modifier.fillMaxSize().padding(inset).clip(RoundedCornerShape(cornerRadius - inset)), size = PhotoSize.Thumb, iconSize = 30.dp)
      if (selected) {
        Box(Modifier.fillMaxSize().border(2.5.dp, colors.ink, RoundedCornerShape(cornerRadius)))
        Box(Modifier.align(Alignment.TopEnd).padding(10.dp)) { CheckMark(true, size = 22.dp) }
      }
    }
    if (label != null) {
      Spacer(Modifier.height(6.dp))
      Text(label, style = if (prominent) Relevo.type.headline else Relevo.type.footnote, color = if (selected || prominent) colors.ink else colors.graphite, maxLines = 2, overflow = TextOverflow.Ellipsis)
    }
  }
}

/**
 * Imagen de la persona: el emoji que eligió (P2), en un círculo. Sin emoji, la inicial de su nombre
 * o el icono de perfil. Al cambiar, el nuevo aparece con una leve escala.
 */
@Composable
fun Avatar(image: String, name: String, size: Dp, modifier: Modifier = Modifier, background: Color = Relevo.colors.mist) {
  val emoji = Emoji.forProfile(image)
  AnimatedContent(
    targetState = emoji to name.trim().firstOrNull()?.uppercaseChar(),
    transitionSpec = { (fadeIn(Motion.standard()) + scaleIn(Motion.smooth(), initialScale = .8f)) togetherWith fadeOut(Motion.standard(120)) },
    label = "avatar",
    modifier = modifier,
  ) { (shown, initial) ->
    Box(Modifier.size(size).clip(CircleShape).background(background), contentAlignment = Alignment.Center) {
      when {
        shown != null -> EmojiImage(shown, Modifier.size(size * 0.66f))
        initial != null -> Text(initial.toString(), style = Relevo.type.title.copy(fontSize = Relevo.type.title.fontSize * (size.value / 72f)), color = Relevo.colors.ink)
        else -> RelevoIcon(KitIcon.PERFIL, size = size * 0.46f, background = background)
      }
    }
  }
}

/**
 * Foto grande con una banda de vidrio abajo: la foto sigue a la vista y el texto se lee sobre un
 * desenfoque que crece hacia el borde, sin velos opacos (D-083). Toda la ficha se puede tocar.
 */
@Composable
fun PhotoHero(
  picture: Picture,
  modifier: Modifier = Modifier,
  aspect: Float = 0.9f,
  wide: Boolean = false,
  sharedKey: String? = null,
  onClick: (() -> Unit)? = null,
  clickLabel: String? = null,
  band: @Composable ColumnScope.() -> Unit,
) {
  val interaction = remember { MutableInteractionSource() }
  val haze = rememberHazeState()
  Box(
    modifier.fillMaxWidth().aspectRatio(aspect).pressScale(interaction, 0.985f).clip(Relevo.panelShape)
      .then(if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = clickLabel, onClick = onClick) else Modifier),
  ) {
    PictureContent(picture, Modifier.matchParentSize().hazeSource(haze).sharedPhoto(sharedKey), wide = wide, iconSize = 56.dp)
    Column(Modifier.align(Alignment.BottomStart).fillMaxWidth().photoBand(haze).padding(start = 20.dp, end = 20.dp, top = 48.dp, bottom = 20.dp), content = band)
  }
}

/** Emoji elegible en un círculo; el elegido se encoge dentro de un anillo de tinta. */
@Composable
fun EmojiTile(emoji: Emoji, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
  val colors = Relevo.colors
  val interaction = remember { MutableInteractionSource() }
  val inset by animateDpAsState(if (selected) 5.dp else 0.dp, Motion.smooth(stiffness = 600f), label = "emoji_inset")
  Box(
    modifier.aspectRatio(1f).pressScale(interaction, 0.92f)
      .clickable(interactionSource = interaction, indication = null, role = Role.RadioButton, onClick = onClick)
      .semantics { this.selected = selected; contentDescription = emoji.description },
    contentAlignment = Alignment.Center,
  ) {
    Box(Modifier.fillMaxSize().padding(inset).clip(CircleShape).background(colors.mist), contentAlignment = Alignment.Center) {
      EmojiImage(emoji, Modifier.fillMaxSize(0.64f))
    }
    if (selected) Box(Modifier.fillMaxSize().border(2.5.dp, colors.ink, CircleShape))
  }
}
