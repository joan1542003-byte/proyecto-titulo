package com.example.relevo.domain

import java.util.UUID
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TagProtocolTest {
  @Test
  fun usesTheStandardBluetoothIdentifiers() {
    // Los mismos que usa la app de código abierto iTag One para hacer pitar el llavero.
    assertEquals(UUID.fromString("00001802-0000-1000-8000-00805f9b34fb"), TagProtocol.IMMEDIATE_ALERT_SERVICE)
    assertEquals(UUID.fromString("00002a06-0000-1000-8000-00805f9b34fb"), TagProtocol.ALERT_LEVEL)
    assertEquals(UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb"), TagProtocol.KEY_SERVICE)
    assertEquals(UUID.fromString("0000ffe1-0000-1000-8000-00805f9b34fb"), TagProtocol.BUTTON)
    assertEquals(UUID.fromString("0000ffe2-0000-1000-8000-00805f9b34fb"), TagProtocol.LINK_LOSS_SWITCH)
    assertEquals(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"), TagProtocol.CLIENT_CONFIG)
    assertEquals(UUID.fromString("00001803-0000-1000-8000-00805f9b34fb"), TagProtocol.LINK_LOSS_SERVICE)
    assertEquals(0x02.toByte(), TagProtocol.ALERT_HIGH)
    assertEquals(0x00.toByte(), TagProtocol.ALERT_OFF)
  }

  @Test
  fun beepsWithoutPausesThirtySecondsOrThreeInTheTest() {
    assertEquals(30_000L, TagProtocol.durationMillis(test = false))
    assertEquals(3_000L, TagProtocol.durationMillis(test = true))
    // La orden se repite varias veces dentro de la prueba, para que el pitido no se corte.
    assertTrue(TagProtocol.REPEAT_MILLIS * 2 < TagProtocol.durationMillis(test = true))
  }

  @Test
  fun recognisesTagsByNameOrService() {
    assertTrue(TagProtocol.looksLikeTag("iTAG            ", emptyList()))
    assertTrue(TagProtocol.looksLikeTag("iTag", emptyList()))
    assertTrue(TagProtocol.looksLikeTag(null, listOf(TagProtocol.KEY_SERVICE)))
    assertTrue(TagProtocol.looksLikeTag("", listOf(TagProtocol.IMMEDIATE_ALERT_SERVICE)))
    assertFalse(TagProtocol.looksLikeTag("JBL Go 4", emptyList()))
    assertFalse(TagProtocol.looksLikeTag(null, emptyList()))
  }

  @Test
  fun triesMediumThenHighLevel() {
    // Con el Tag del autor, el nivel medio pita y el alto no: el medio va primero (2.29).
    assertEquals(listOf(1, 2), TagProtocol.ALERT_LEVELS)
    assertEquals(1, TagProtocol.nextTry(0))
    assertEquals(null, TagProtocol.nextTry(1))
    assertEquals(0, TagProtocol.tryIndex(1))
    assertEquals(1, TagProtocol.tryIndex(2))
    assertEquals(0, TagProtocol.tryIndex(3))
  }

  @Test
  fun describesSignalStrengthInWords() {
    assertEquals("Muy cerca", TagProtocol.strength(-50))
    assertEquals("Cerca", TagProtocol.strength(-70))
    assertEquals("Lejos", TagProtocol.strength(-90))
  }
}
