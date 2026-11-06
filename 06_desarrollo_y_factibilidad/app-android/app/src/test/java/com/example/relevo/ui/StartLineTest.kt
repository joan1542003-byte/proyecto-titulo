package com.example.relevo.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/** «Para empezar» como rótulo de cómo empezar, en todas las pantallas (R1 del estudio de los textos). */
class StartLineTest {
  @Test fun joinsHowToStartAndThePlaceInOneLine() {
    assertEquals("Para empezar: ponerte las zapatillas, junto a la puerta.", startLine("Ponerte las zapatillas", "Junto a la puerta"))
    assertEquals("Para empezar: abrir el libro, en el velador.", startLine("Abrir el libro.", "En el velador"))
  }

  @Test fun aPlaceWithoutPrepositionGoesInQuotes() {
    assertEquals("Para empezar: abrir el libro, en «el living».", startLine("Abrir el libro", "el living"))
  }

  @Test fun worksWithOnlyOneOfTheTwo() {
    assertEquals("Para empezar: sacar la guitarra.", startLine("Sacar la guitarra", " "))
    assertEquals("Empieza junto a la puerta.", startLine("", "Junto a la puerta"))
    assertNull(startLine(" ", ""))
  }
}
