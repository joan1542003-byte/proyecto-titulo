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
  fun signalLastsThirtySecondsInSixBeeps() {
    val pulses = TagProtocol.pulses(test = false)
    assertEquals(6, pulses.size)
    assertEquals(30_000L, pulses.sumOf { it.onMillis + it.offMillis })
    assertTrue(pulses.all { it.onMillis == 2_000L })
  }

  @Test
  fun testIsASingleShortBeep() {
    val pulses = TagProtocol.pulses(test = true)
    assertEquals(1, pulses.size)
    assertEquals(2_000L, pulses.single().onMillis)
    assertEquals(0L, pulses.single().offMillis)
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
  fun describesSignalStrengthInWords() {
    assertEquals("Muy cerca", TagProtocol.strength(-50))
    assertEquals("Cerca", TagProtocol.strength(-70))
    assertEquals("Lejos", TagProtocol.strength(-90))
  }
}
