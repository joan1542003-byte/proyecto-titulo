package com.example.relevo.signal

import kotlin.math.abs
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FirmaSonoraTest {
  private val rate = FirmaSonora.SAMPLE_RATE

  private fun peak(pcm: ShortArray, fromSecond: Double, toSecond: Double): Int =
    ((fromSecond * rate).toInt() until minOf((toSecond * rate).toInt(), pcm.size)).maxOfOrNull { abs(pcm[it].toInt()) } ?: 0

  @Test
  fun signalLastsAboutThirtySecondsAndEndsInSilence() {
    val pcm = FirmaSonora.signal()
    assertEquals(30.0, pcm.size.toDouble() / rate, 0.01)
    // La última repetición empieza a los 26,4 s y dura 2,2 s: después solo hay silencio.
    assertEquals(0, peak(pcm, 28.7, 30.0))
  }

  @Test
  fun signalStartsSofterThanItsFullLevel() {
    val pcm = FirmaSonora.signal()
    val first = peak(pcm, 0.0, 2.2)
    val fourth = peak(pcm, 3 * 4.4, 3 * 4.4 + 2.2)
    assertTrue("primera $first, cuarta $fourth", first < fourth * 0.5)
  }

  @Test
  fun pausesBetweenRepetitionsAreSilent() {
    val pcm = FirmaSonora.signal()
    assertEquals(0, peak(pcm, 2.3, 4.3))
  }

  @Test
  fun signatureStaysBelowFullScale() {
    val max = FirmaSonora.signature().maxOf { abs(it) }
    assertEquals(0.708f, max, 0.01f)
  }

  @Test
  fun soundTestIsASingleSignature() {
    assertEquals(2.2, FirmaSonora.test().size.toDouble() / rate, 0.01)
  }
}
