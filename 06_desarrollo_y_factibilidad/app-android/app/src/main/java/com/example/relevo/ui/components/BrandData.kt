package com.example.relevo.ui.components

// Generado por scratchpad/app3/gen-res.js desde el logo de D-125 y D-127. No editar a mano.

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

/** Una luz de la marca, en una unidad de 100: su trazado plano, el de tamaños chicos y su degradado «Luz». */
internal class BrandLight(val path: String, val smallPath: String, val color: Color, val center: Offset, val radius: Float, val stops: List<Pair<Float, Color>>)

/** Las cuatro luces en el sentido del reloj desde arriba: tu tiempo, tu primer paso, el lugar y lo que decides. */
internal val BrandLights = listOf(
  BrandLight(
    path = "M76.89 18.14A29 29 0 1 0 39.14 55.89A32.4 32.4 0 0 1 76.89 18.14Z",
    smallPath = "M75.261 14.757A29 29 0 1 0 35.757 54.261A35.5 35.5 0 0 1 75.261 14.757Z",
    color = Color(0xFFFFD54A),
    center = Offset(50f, 13.05f), radius = 42.05f,
    stops = listOf(0f to Color(0xFFFFE57E), 0.55f to Color(0xFFFFD54A), 1f to Color(0xFFF8CE41)),
  ),
  BrandLight(
    path = "M81.86 76.89A29 29 0 1 0 44.11 39.14A32.4 32.4 0 0 1 81.86 76.89Z",
    smallPath = "M85.243 75.261A29 29 0 1 0 45.739 35.757A35.5 35.5 0 0 1 85.243 75.261Z",
    color = Color(0xFF9DD6F4),
    center = Offset(86.95f, 50f), radius = 42.05f,
    stops = listOf(0f to Color(0xFFB5E3FC), 0.55f to Color(0xFF9DD6F4), 1f to Color(0xFF96CFED)),
  ),
  BrandLight(
    path = "M23.11 81.86A29 29 0 1 0 60.86 44.11A32.4 32.4 0 0 1 23.11 81.86Z",
    smallPath = "M24.739 85.243A29 29 0 1 0 64.243 45.739A35.5 35.5 0 0 1 24.739 85.243Z",
    color = Color(0xFFB3E788),
    center = Offset(50f, 86.95f), radius = 42.05f,
    stops = listOf(0f to Color(0xFFC8F3A6), 0.55f to Color(0xFFB3E788), 1f to Color(0xFFACE081)),
  ),
  BrandLight(
    path = "M18.14 23.11A29 29 0 1 0 55.89 60.86A32.4 32.4 0 0 1 18.14 23.11Z",
    smallPath = "M14.757 24.739A29 29 0 1 0 54.261 64.243A35.5 35.5 0 0 1 14.757 24.739Z",
    color = Color(0xFFF6A3CB),
    center = Offset(13.05f, 50f), radius = 42.05f,
    stops = listOf(0f to Color(0xFFFDB7D8), 0.55f to Color(0xFFF6A3CB), 1f to Color(0xFFEE9CC4)),
  ),
)

/** Ancho sobre alto del logotipo «relevo». */
internal const val WORDMARK_ASPECT = 3.955f
