package com.example.relevo.ui

import com.example.relevo.ui.components.KitIcon
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/** El catastro de palabras clave (4.3, D-158): cada actividad sugiere lo suyo y nada de otra. */
class CatastroTest {
  @Test fun aMovieNeverSuggestsABook() {
    assertEquals("peliculas", conceptFor("Ver una película")?.id)
    val starts = startSuggestions("Ver una película")
    assertFalse(starts.any { "tomo" in it || "libro" in it || "teléfono" in it })
    assertTrue("Preparar cabritas" in starts)
  }

  @Test fun wordsAreComparedWholeNotByPieces() {
    // «capítulo» y «serie» ya no arrastran a leer ni a hacer ejercicio hacia las películas.
    assertEquals("manga", conceptFor("Leer un capítulo de manga")?.id)
    assertEquals("leer", conceptFor("Leer un capítulo")?.id)
    assertEquals("peliculas", conceptFor("Ver un capítulo")?.id)
    assertEquals("ejercicio", conceptFor("Hacer una serie corta")?.id)
  }

  @Test fun phrasesWeighMoreThanLooseWords() {
    assertEquals("perro", conceptFor("Pasear al perro")?.id)
    assertEquals("ordenar", conceptFor("Limpiar la cocina")?.id)
    assertEquals("juego de mesa", conceptFor("Jugar un juego de mesa")?.id)
  }

  @Test fun instrumentsNameTheirOwnObject() {
    assertEquals("Sacar la guitarra del estuche", startSuggestions("Tocar guitarra").first())
    assertEquals("Sacar el ukelele del estuche", startSuggestions("Practicar ukelele").first())
    assertEquals("Junto al violín", placeSuggestions("Tocar el violín").first())
    assertEquals(KitIcon.PIANO, conceptFor("Tocar el piano")?.icon)
  }

  @Test fun weakWordsAloneDecideNothing() {
    assertNull(conceptFor("Ver"))
    assertNull(conceptFor("Algo que me gusta"))
    assertTrue(startSuggestions("Algo que me gusta").isEmpty())
  }
  @Test fun chileanWordsAndPhrasesAreRecognized() {
    // 4.5 (D-163): más palabras y frases, también las del español de Chile.
    assertEquals("pelota", conceptFor("Jugar una pichanga")?.id)
    assertEquals("cartas", conceptFor("Jugar carioca con mi familia")?.id)
    assertEquals("cocinar", conceptFor("Tomar once")?.id)
    assertEquals("compartir", conceptFor("Ir a un carrete")?.id)
    assertEquals("ejercicio", conceptFor("Hacer lagartijas")?.id)
  }

  @Test fun phrasesSettleAmbiguousWords() {
    assertEquals("peliculas", conceptFor("Maratón de series")?.id)
    assertEquals("manga", conceptFor("Leer una novela gráfica")?.id)
    assertEquals("escribir", conceptFor("Escribir un cuento")?.id)
    assertEquals("bici", conceptFor("Dar una vuelta en bici")?.id)
    assertEquals("perro", conceptFor("Dar una vuelta con el perro")?.id)
    assertEquals("compartir", conceptFor("Salir con amigos")?.id)
    assertEquals("llamar", conceptFor("Llamar a mi mamá")?.id)
    assertEquals("yoga", conceptFor("Clase de yoga")?.id)
    assertEquals("idiomas", conceptFor("Aprender lengua de señas")?.id)
  }

  @Test fun moreActivitiesHaveTheirObject() {
    assertEquals("Sacar la batería del estuche", startSuggestions("Tocar batería").first())
    assertEquals("ordenar", conceptFor("Lavar la ropa")?.id)
    assertEquals("dormir", conceptFor("Dormir temprano")?.id)
    assertEquals("plantas", conceptFor("Sembrar el huerto")?.id)
    assertNull(conceptFor("Ir a clases"))
  }
}
