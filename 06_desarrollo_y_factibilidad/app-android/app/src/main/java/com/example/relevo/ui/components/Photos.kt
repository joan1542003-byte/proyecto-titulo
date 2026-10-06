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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cl.udp.relevo.R
import com.example.relevo.theme.LocalRelevoColors
import com.example.relevo.theme.Relevo
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

/**
 * Imágenes de las actividades. Desde 2.21 no son fotos: cada una se dibuja como su icono del kit sobre
 * un degradado sutil del color de su familia (pedido del autor del 6 de octubre). Las fotos de D-073
 * quedan en los recursos y en `licencias/README.md` como antecedente; [res] ya no se dibuja.
 */
enum class Photo(@param:DrawableRes val res: Int, val description: String, @param:DrawableRes val wide: Int? = null, val icon: KitIcon = KitIcon.ACTIVIDAD) {
  CAMINAR(R.drawable.foto_caminar, "Caminar", icon = KitIcon.CAMINAR),
  EJERCICIO(R.drawable.foto_ejercicio, "Hacer ejercicio", icon = KitIcon.EJERCICIO),
  LEER(R.drawable.foto_leer, "Leer", icon = KitIcon.LEER),
  ESTUDIAR(R.drawable.foto_estudiar, "Estudiar", icon = KitIcon.ESTUDIAR),
  DIBUJAR(R.drawable.foto_dibujar, "Dibujar", icon = KitIcon.DIBUJAR),
  COCINAR(R.drawable.foto_cocinar, "Cocinar", icon = KitIcon.COCINAR),
  ORDENAR(R.drawable.foto_ordenar, "Ordenar", icon = KitIcon.ORDENAR),
  PERRO(R.drawable.foto_perro, "Salir con el perro", icon = KitIcon.CAMINAR),
  MANUALIDADES(R.drawable.foto_manualidades, "Manualidades", icon = KitIcon.MANUALIDADES),
  GUITARRA(R.drawable.foto_guitarra, "Tocar guitarra", icon = KitIcon.GUITARRA),
  ESCRIBIR(R.drawable.foto_escribir, "Escribir", icon = KitIcon.ESCRIBIR),
  LIBRO(R.drawable.foto_libro, "Leer un libro", icon = KitIcon.LEER),
  APRENDER(R.drawable.foto_aprender, "Aprender", icon = KitIcon.ESTUDIAR),
  PAN(R.drawable.foto_pan, "Hacer pan", icon = KitIcon.COCINAR),
  PINTAR(R.drawable.foto_pintar, "Pintar", icon = KitIcon.PINTAR),
  PUERTA(R.drawable.foto_puerta, "Empezar", R.drawable.foto_puerta_ancha, icon = KitIcon.PRIMER_PASO),
  SALIDA(R.drawable.foto_salida, "Salir", R.drawable.foto_salida_ancha, icon = KitIcon.SALIR),
  TIEMPO(R.drawable.foto_tiempo, "El tiempo en el teléfono", R.drawable.foto_tiempo_ancha, icon = KitIcon.TIEMPO);

  val key: String get() = "foto:$name"
}

/** Grupos del selector de emoji, en el orden de los teclados. */
enum class EmojiGroup(val label: String) {
  CARAS("Caras"), ANIMALES("Animales"), NATURALEZA("Naturaleza"), COMIDA("Comida"), ACTIVIDADES("Actividades"),
}

/**
 * Emoji 3D de Google (Noto 3D, licencia SIL OFL 1.1) para la imagen del perfil (D-083): caras,
 * animales, naturaleza, comida y actividades (84 desde 2.10, D-084). Se muestran en círculos; no se
 * suben fotos propias.
 */
enum class Emoji(val code: String, @param:DrawableRes val res: Int, val description: String, val group: EmojiGroup) {
  // Caras
  SONRISA("1f60a", R.drawable.emoji_1f60a, "Cara sonriente", EmojiGroup.CARAS),
  CONTENTA("1f642", R.drawable.emoji_1f642, "Cara contenta", EmojiGroup.CARAS),
  LENTES_DE_SOL("1f60e", R.drawable.emoji_1f60e, "Cara con lentes de sol", EmojiGroup.CARAS),
  ABRAZO("1f917", R.drawable.emoji_1f917, "Cara que abraza", EmojiGroup.CARAS),
  ESTRELLAS("1f929", R.drawable.emoji_1f929, "Cara con ojos de estrella", EmojiGroup.CARAS),
  CORAZONES("1f970", R.drawable.emoji_1f970, "Cara con corazones", EmojiGroup.CARAS),
  FIESTA("1f973", R.drawable.emoji_1f973, "Cara de fiesta", EmojiGroup.CARAS),
  PENSATIVA("1f914", R.drawable.emoji_1f914, "Cara pensativa", EmojiGroup.CARAS),
  DORMIDA("1f634", R.drawable.emoji_1f634, "Cara dormida", EmojiGroup.CARAS),
  VAQUERO("1f920", R.drawable.emoji_1f920, "Cara con sombrero de vaquero", EmojiGroup.CARAS),
  ROBOT("1f916", R.drawable.emoji_1f916, "Robot", EmojiGroup.CARAS),
  FANTASMA("1f47b", R.drawable.emoji_1f47b, "Fantasma", EmojiGroup.CARAS),
  // Animales
  PERRO("1f436", R.drawable.emoji_1f436, "Perro", EmojiGroup.ANIMALES),
  GATO("1f431", R.drawable.emoji_1f431, "Gato", EmojiGroup.ANIMALES),
  ZORRO("1f98a", R.drawable.emoji_1f98a, "Zorro", EmojiGroup.ANIMALES),
  TORTUGA("1f422", R.drawable.emoji_1f422, "Tortuga", EmojiGroup.ANIMALES),
  CONEJO("1f430", R.drawable.emoji_1f430, "Conejo", EmojiGroup.ANIMALES),
  OSO("1f43b", R.drawable.emoji_1f43b, "Oso", EmojiGroup.ANIMALES),
  PANDA("1f43c", R.drawable.emoji_1f43c, "Panda", EmojiGroup.ANIMALES),
  KOALA("1f428", R.drawable.emoji_1f428, "Koala", EmojiGroup.ANIMALES),
  TIGRE("1f42f", R.drawable.emoji_1f42f, "Tigre", EmojiGroup.ANIMALES),
  LEON("1f981", R.drawable.emoji_1f981, "León", EmojiGroup.ANIMALES),
  RANA("1f438", R.drawable.emoji_1f438, "Rana", EmojiGroup.ANIMALES),
  PINGUINO("1f427", R.drawable.emoji_1f427, "Pingüino", EmojiGroup.ANIMALES),
  BUHO("1f989", R.drawable.emoji_1f989, "Búho", EmojiGroup.ANIMALES),
  ABEJA("1f41d", R.drawable.emoji_1f41d, "Abeja", EmojiGroup.ANIMALES),
  MARIPOSA("1f98b", R.drawable.emoji_1f98b, "Mariposa", EmojiGroup.ANIMALES),
  PULPO("1f419", R.drawable.emoji_1f419, "Pulpo", EmojiGroup.ANIMALES),
  BALLENA("1f433", R.drawable.emoji_1f433, "Ballena", EmojiGroup.ANIMALES),
  UNICORNIO("1f984", R.drawable.emoji_1f984, "Unicornio", EmojiGroup.ANIMALES),
  PEREZOSO("1f9a5", R.drawable.emoji_1f9a5, "Perezoso", EmojiGroup.ANIMALES),
  DINOSAURIO("1f996", R.drawable.emoji_1f996, "Dinosaurio", EmojiGroup.ANIMALES),
  // Naturaleza
  PLANTA("1fab4", R.drawable.emoji_1fab4, "Planta", EmojiGroup.NATURALEZA),
  GIRASOL("1f33b", R.drawable.emoji_1f33b, "Girasol", EmojiGroup.NATURALEZA),
  OLA("1f30a", R.drawable.emoji_1f30a, "Ola", EmojiGroup.NATURALEZA),
  LUNA("1f319", R.drawable.emoji_1f319, "Luna", EmojiGroup.NATURALEZA),
  SOL("2600", R.drawable.emoji_2600, "Sol", EmojiGroup.NATURALEZA),
  ARCOIRIS("1f308", R.drawable.emoji_1f308, "Arcoíris", EmojiGroup.NATURALEZA),
  ESTRELLA("2b50", R.drawable.emoji_2b50, "Estrella", EmojiGroup.NATURALEZA),
  NUBE("2601", R.drawable.emoji_2601, "Nube", EmojiGroup.NATURALEZA),
  COPO("2744", R.drawable.emoji_2744, "Copo de nieve", EmojiGroup.NATURALEZA),
  FUEGO("1f525", R.drawable.emoji_1f525, "Fuego", EmojiGroup.NATURALEZA),
  CACTUS("1f335", R.drawable.emoji_1f335, "Cactus", EmojiGroup.NATURALEZA),
  ARBOL("1f333", R.drawable.emoji_1f333, "Árbol", EmojiGroup.NATURALEZA),
  TREBOL("1f340", R.drawable.emoji_1f340, "Trébol de cuatro hojas", EmojiGroup.NATURALEZA),
  TULIPAN("1f337", R.drawable.emoji_1f337, "Tulipán", EmojiGroup.NATURALEZA),
  HONGO("1f344", R.drawable.emoji_1f344, "Hongo", EmojiGroup.NATURALEZA),
  MONTANA("1f3d4", R.drawable.emoji_1f3d4, "Montaña nevada", EmojiGroup.NATURALEZA),
  PLANETA("1fa90", R.drawable.emoji_1fa90, "Planeta con anillo", EmojiGroup.NATURALEZA),
  // Comida
  CAFE("2615", R.drawable.emoji_2615, "Taza de café", EmojiGroup.COMIDA),
  PAN("1f35e", R.drawable.emoji_1f35e, "Pan", EmojiGroup.COMIDA),
  SARTEN("1f373", R.drawable.emoji_1f373, "Sartén con un huevo", EmojiGroup.COMIDA),
  PALTA("1f951", R.drawable.emoji_1f951, "Palta", EmojiGroup.COMIDA),
  FRUTILLA("1f353", R.drawable.emoji_1f353, "Frutilla", EmojiGroup.COMIDA),
  SANDIA("1f349", R.drawable.emoji_1f349, "Sandía", EmojiGroup.COMIDA),
  LIMON("1f34b", R.drawable.emoji_1f34b, "Limón", EmojiGroup.COMIDA),
  PIZZA("1f355", R.drawable.emoji_1f355, "Pizza", EmojiGroup.COMIDA),
  DONA("1f369", R.drawable.emoji_1f369, "Dona", EmojiGroup.COMIDA),
  HELADO("1f366", R.drawable.emoji_1f366, "Helado", EmojiGroup.COMIDA),
  TE_DE_BURBUJAS("1f9cb", R.drawable.emoji_1f9cb, "Té de burbujas", EmojiGroup.COMIDA),
  // Actividades
  ZAPATILLA("1f45f", R.drawable.emoji_1f45f, "Zapatilla", EmojiGroup.ACTIVIDADES),
  LIBROS("1f4da", R.drawable.emoji_1f4da, "Libros", EmojiGroup.ACTIVIDADES),
  GUITARRA("1f3b8", R.drawable.emoji_1f3b8, "Guitarra", EmojiGroup.ACTIVIDADES),
  PALETA("1f3a8", R.drawable.emoji_1f3a8, "Paleta de pintura", EmojiGroup.ACTIVIDADES),
  LANA("1f9f6", R.drawable.emoji_1f9f6, "Ovillo de lana", EmojiGroup.ACTIVIDADES),
  BICICLETA("1f6b2", R.drawable.emoji_1f6b2, "Bicicleta", EmojiGroup.ACTIVIDADES),
  CAMARA("1f4f7", R.drawable.emoji_1f4f7, "Cámara", EmojiGroup.ACTIVIDADES),
  AUDIFONOS("1f3a7", R.drawable.emoji_1f3a7, "Audífonos", EmojiGroup.ACTIVIDADES),
  LAPIZ("270f", R.drawable.emoji_270f, "Lápiz", EmojiGroup.ACTIVIDADES),
  PIEZA("1f9e9", R.drawable.emoji_1f9e9, "Pieza de rompecabezas", EmojiGroup.ACTIVIDADES),
  PIANO("1f3b9", R.drawable.emoji_1f3b9, "Teclado de piano", EmojiGroup.ACTIVIDADES),
  PELOTA("26bd", R.drawable.emoji_26bd, "Pelota", EmojiGroup.ACTIVIDADES),
  BASQUETBOL("1f3c0", R.drawable.emoji_1f3c0, "Pelota de básquetbol", EmojiGroup.ACTIVIDADES),
  TENIS("1f3be", R.drawable.emoji_1f3be, "Raqueta de tenis", EmojiGroup.ACTIVIDADES),
  SKATE("1f6f9", R.drawable.emoji_1f6f9, "Skate", EmojiGroup.ACTIVIDADES),
  DADO("1f3b2", R.drawable.emoji_1f3b2, "Dado", EmojiGroup.ACTIVIDADES),
  AJEDREZ("265f", R.drawable.emoji_265f, "Peón de ajedrez", EmojiGroup.ACTIVIDADES),
  CONTROL("1f3ae", R.drawable.emoji_1f3ae, "Control de videojuegos", EmojiGroup.ACTIVIDADES),
  VOLANTIN("1fa81", R.drawable.emoji_1fa81, "Volantín", EmojiGroup.ACTIVIDADES),
  MICROFONO("1f3a4", R.drawable.emoji_1f3a4, "Micrófono", EmojiGroup.ACTIVIDADES),
  VIOLIN("1f3bb", R.drawable.emoji_1f3bb, "Violín", EmojiGroup.ACTIVIDADES),
  TELESCOPIO("1f52d", R.drawable.emoji_1f52d, "Telescopio", EmojiGroup.ACTIVIDADES),
  CARPA("26fa", R.drawable.emoji_26fa, "Carpa", EmojiGroup.ACTIVIDADES),
  COHETE("1f680", R.drawable.emoji_1f680, "Cohete", EmojiGroup.ACTIVIDADES);

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

/** Emoji ya decodificados; los del selector, a la mitad de resolución. */
private object EmojiCache {
  private val cache = object : LruCache<Int, ImageBitmap>(16 * 1024 * 1024) {
    override fun sizeOf(key: Int, value: ImageBitmap): Int = value.width * value.height * 4
  }
  fun get(key: Int): ImageBitmap? = cache.get(key)
  fun put(key: Int, value: ImageBitmap) { cache.put(key, value) }
}

/**
 * Emoji 3D del perfil. Se decodifica fuera del hilo principal, para que el selector con 84 emoji se
 * abra sin tirones; [small] los carga a 128 px, suficiente para las fichas.
 */
@Composable
fun EmojiImage(emoji: Emoji, modifier: Modifier = Modifier, describe: Boolean = false, small: Boolean = false) {
  val key = emoji.res * 2 + if (small) 1 else 0
  val context = LocalContext.current
  var bitmap by remember(key) { mutableStateOf(EmojiCache.get(key)) }
  LaunchedEffect(key) {
    if (bitmap == null) {
      bitmap = withContext(Dispatchers.IO) {
        val options = BitmapFactory.Options().apply { inSampleSize = if (small) 2 else 1 }
        runCatching { BitmapFactory.decodeResource(context.resources, emoji.res, options)?.asImageBitmap() }.getOrNull()?.also { EmojiCache.put(key, it) }
      }
    }
  }
  Box(modifier.then(if (describe) Modifier.semantics { contentDescription = emoji.description } else Modifier)) {
    bitmap?.let { Image(it, contentDescription = null, contentScale = ContentScale.Fit, modifier = Modifier.fillMaxSize()) }
  }
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
  ActivityArt(photo.icon, modifier.then(if (describe) Modifier.semantics { contentDescription = photo.description } else Modifier))
}

/**
 * Familias de color de las actividades (los claros de D-104): moverse en menta, leer y estudiar en
 * celeste, crear en lila, música y juego en rosa, casa y cocina en naranja; lo demás en sol.
 */
internal fun artTint(icon: KitIcon): Color = when (icon) {
  KitIcon.CAMINAR, KitIcon.EJERCICIO, KitIcon.BICICLETA, KitIcon.ESTIRAR, KitIcon.SALIR, KitIcon.PLANTAS -> Color(0xFF6FDEA7)
  KitIcon.LEER, KitIcon.ESTUDIAR, KitIcon.ESCRIBIR, KitIcon.TEXTO -> Color(0xFF54D6FE)
  KitIcon.DIBUJAR, KitIcon.PINTAR, KitIcon.MANUALIDADES, KitIcon.FOTOGRAFIA -> Color(0xFFCEB5FE)
  KitIcon.GUITARRA, KitIcon.MUSICA, KitIcon.JUEGO_DE_MESA -> Color(0xFFFEA4CF)
  KitIcon.COCINAR, KitIcon.ORDENAR -> Color(0xFFFEB074)
  else -> Color(0xFFE7BF57)
}

/**
 * La imagen de una actividad: su icono en tinta sobre un degradado sutil de su color, de casi papel
 * arriba a la izquierda a un tinte suave abajo a la derecha. Sin fotos, sin brillos y sin texto encima.
 */
@Composable
fun ActivityArt(icon: KitIcon, modifier: Modifier = Modifier, iconSize: Dp? = null) {
  val colors = Relevo.colors
  val tint = artTint(icon)
  val start = tint.copy(alpha = if (colors.isDark) 0.10f else 0.16f).compositeOver(colors.card)
  val end = tint.copy(alpha = if (colors.isDark) 0.34f else 0.58f).compositeOver(colors.card)
  var side by remember { mutableIntStateOf(0) }
  val density = LocalDensity.current
  val auto = with(density) { (side * 0.28f).toDp() }.coerceIn(24.dp, 80.dp)
  Box(
    modifier.onSizeChanged { side = minOf(it.width, it.height) }.background(Brush.linearGradient(listOf(start, end))),
    contentAlignment = Alignment.Center,
  ) {
    RelevoIcon(icon, size = iconSize ?: auto, tint = colors.ink, background = Color.Transparent)
  }
}

@Suppress("unused")
@Composable
private fun LegacyPhotoImage(photo: Photo, modifier: Modifier = Modifier, wide: Boolean = false, size: PhotoSize = PhotoSize.Full, describe: Boolean = false) {
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
  // Foto o icono, se dibuja igual: el icono de la actividad sobre su degradado (2.21).
  val icon = when (picture) { is Picture.OfPhoto -> picture.photo.icon; is Picture.OfIcon -> picture.icon; null -> fallback }
  ActivityArt(icon, modifier, iconSize = iconSize)
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
 * desenfoque que crece hacia el borde, sin velos opacos (D-083). El texto y el vidrio toman el tono
 * de la foto que queda debajo: tinta sobre fotos claras y blanco sobre fotos oscuras (D-084). Toda
 * la ficha se puede tocar.
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
  val density = LocalDensity.current
  var frame by remember { mutableIntStateOf(0) }
  var bandHeight by remember { mutableIntStateOf(0) }
  // El texto empieza 48 dp bajo el borde de la banda: se mide esa zona de la foto, redondeada al 5 %.
  val textTop = if (frame > 0 && bandHeight > 0) ((frame - bandHeight + with(density) { 48.dp.toPx() }) / frame).coerceIn(0f, 0.9f) else 0.6f
  val dark = rememberPhotoDark(picture, wide, aspect, (textTop * 20).roundToInt() / 20f, 1f)
  Box(
    modifier.fillMaxWidth().aspectRatio(aspect).onSizeChanged { frame = it.height }.pressScale(interaction, 0.985f).clip(Relevo.panelShape)
      .then(if (onClick != null) Modifier.clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = clickLabel, onClick = onClick) else Modifier),
  ) {
    PictureContent(picture, Modifier.matchParentSize().hazeSource(haze).sharedPhoto(sharedKey), wide = wide, iconSize = 56.dp)
    CompositionLocalProvider(LocalRelevoColors provides paletteOver(dark)) {
      Column(
        Modifier.align(Alignment.BottomStart).fillMaxWidth().onSizeChanged { bandHeight = it.height }.photoBand(haze)
          .padding(start = 20.dp, end = 20.dp, top = 48.dp, bottom = 20.dp),
        content = band,
      )
    }
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
      EmojiImage(emoji, Modifier.fillMaxSize(0.64f), small = true)
    }
    if (selected) Box(Modifier.fillMaxSize().border(2.5.dp, colors.ink, CircleShape))
  }
}
