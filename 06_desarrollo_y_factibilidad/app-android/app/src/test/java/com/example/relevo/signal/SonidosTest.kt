package com.example.relevo.signal

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.math.abs

/** Los cuatro sonidos de Ajustes (4.3, D-158): unos 30 s, sin saturar, y la firma sigue igual. */
class SonidosTest {
  private val rate = FirmaSonora.SAMPLE_RATE

  @Test fun everySignalLastsAboutThirtySeconds() {
    Sonido.entries.forEach { sonido ->
      assertEquals(sonido.label, 30.0, FirmaSonora.signal(sonido).size.toDouble() / rate, 0.01)
    }
  }

  @Test fun noSoundClips() {
    Sonido.entries.forEach { sonido ->
      val peak = FirmaSonora.signal(sonido).maxOf { abs(it.toInt()) }
      assertTrue(sonido.label, peak < Short.MAX_VALUE)
    }
  }

  @Test fun theTestPlaysOneMotif() {
    Sonido.entries.forEach { sonido ->
      assertEquals(sonido.label, sonido.perfil.motif, FirmaSonora.test(sonido).size.toDouble() / rate, 0.01)
    }
  }

  @Test fun unknownIdsFallBackToTheSignature() {
    assertEquals(Sonido.MADERA, Sonido.from(null))
    assertEquals(Sonido.MADERA, Sonido.from("otro"))
    assertEquals(Sonido.TONADA, Sonido.from("tonada"))
  }
}
