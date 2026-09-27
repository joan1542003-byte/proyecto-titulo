package com.example.relevo.ui.components

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class EmojiTest {
  @Test fun everyEmojiHasItsOwnKey() {
    assertEquals(Emoji.entries.size, Emoji.entries.map { it.key }.toSet().size)
    Emoji.entries.forEach { assertEquals(it, Emoji.fromKey(it.key)) }
  }

  @Test fun profileImagesChosenBefore29BecomeTheClosestEmoji() {
    assertEquals(Emoji.GUITARRA, Emoji.forProfile("foto:GUITARRA"))
    assertEquals(Emoji.ZAPATILLA, Emoji.forProfile("foto:CAMINAR"))
    assertEquals(Emoji.AUDIFONOS, Emoji.forProfile("icono:MUSICA"))
    assertEquals(Emoji.PLANTA, Emoji.forProfile("icono:PLANTAS"))
  }

  @Test fun thereAre84EmojiInFiveGroups() {
    assertEquals(84, Emoji.entries.size)
    EmojiGroup.entries.forEach { group -> assertTrue(Emoji.entries.any { it.group == group }) }
  }

  @Test fun withoutAnImageThereIsNoEmoji() {
    assertNull(Emoji.forProfile(""))
    assertNull(Emoji.forProfile(null))
    assertNull(Emoji.fromKey("emoji:0000"))
  }
}
