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
}
