package com.example.relevo.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class StartSentenceTest {
  @Test fun joinsTheFirstStepAndThePlaceInOneSentence() {
    assertEquals("Empieza por ponerte las zapatillas, junto a la puerta.", startSentence("Ponerte las zapatillas", "Junto a la puerta"))
    assertEquals("Empieza por abrir el libro, en el velador.", startSentence("Abrir el libro.", "En el velador"))
  }

  @Test fun aPlaceWithoutPrepositionGoesInQuotes() {
    assertEquals("Empieza por abrir el libro, en «el living».", startSentence("Abrir el libro", "el living"))
  }

  @Test fun worksWithOnlyOneOfTheTwo() {
    assertEquals("Empieza por sacar la guitarra.", startSentence("Sacar la guitarra", " "))
    assertEquals("Empieza junto a la puerta.", startSentence("", "Junto a la puerta"))
    assertNull(startSentence(" ", ""))
  }
}
