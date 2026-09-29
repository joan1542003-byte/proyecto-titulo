package com.example.relevo.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Random

class ParticipantCodeTest {
  @Test
  fun codeHasFourCharactersFromTheClearAlphabet() {
    val random = Random(7)
    repeat(500) {
      val code = Participation.newCode(random)
      assertEquals(Participation.CODE_LENGTH, code.length)
      assertTrue(code, code.all { it in Participation.CODE_ALPHABET })
    }
  }

  @Test
  fun alphabetLeavesOutLookAlikes() {
    listOf('0', 'O', '1', 'I', 'L', '5', 'S', '2', 'Z').forEach { assertTrue("$it", it !in Participation.CODE_ALPHABET) }
    assertEquals(Participation.CODE_ALPHABET.length, Participation.CODE_ALPHABET.toSet().size)
  }

  @Test
  fun codesFitTheDatabaseLimit() {
    // La base acepta códigos de 3 a 24 caracteres.
    assertTrue(Participation.CODE_LENGTH in 3..24)
  }
}
