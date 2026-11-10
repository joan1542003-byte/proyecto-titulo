package com.example.relevo.ui.components

import org.junit.Assert.assertEquals
import org.junit.Test

class SinViudaTest {
  private val nbsp = ' '

  @Test fun theLastTwoWordsOfAParagraphStayTogether() {
    assertEquals("Anota algo que quieres${nbsp}hacer", sinViuda("Anota algo que quieres hacer"))
    assertEquals("Suena al sumar 15${nbsp}min", sinViuda("Suena al sumar 15 min"))
  }

  @Test fun everyParagraphIsTreatedOnItsOwn() {
    assertEquals("Uno dos${nbsp}tres\nCuatro cinco${nbsp}seis", sinViuda("Uno dos tres\nCuatro cinco seis"))
  }

  @Test fun shortTextsCanStillBreakBetweenTheirWords() {
    assertEquals("Tocar guitarra", sinViuda("Tocar guitarra"))
    assertEquals("Leer", sinViuda("Leer"))
    assertEquals("", sinViuda(""))
  }

  @Test fun aTrailingSpaceDoesNotHideTheLastWord() {
    assertEquals("Faltan 12${nbsp}min ", sinViuda("Faltan 12 min "))
  }
}
