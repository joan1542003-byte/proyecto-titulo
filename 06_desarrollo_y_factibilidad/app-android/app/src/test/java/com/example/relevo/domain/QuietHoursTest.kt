package com.example.relevo.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/** Horas sin sonar (1.0.0): en qué horas Relevo no cuenta ni suena. */
class QuietHoursTest {
  @Test
  fun aNightRangeCrossesMidnight() {
    assertTrue(QuietHours.contains(23, 23, 8))
    assertTrue(QuietHours.contains(0, 23, 8))
    assertTrue(QuietHours.contains(7, 23, 8))
    assertFalse(QuietHours.contains(8, 23, 8))
    assertFalse(QuietHours.contains(22, 23, 8))
    assertFalse(QuietHours.contains(15, 23, 8))
  }

  @Test
  fun aDayRangeStaysInsideTheDay() {
    assertTrue(QuietHours.contains(9, 9, 13))
    assertTrue(QuietHours.contains(12, 9, 13))
    assertFalse(QuietHours.contains(13, 9, 13))
    assertFalse(QuietHours.contains(8, 9, 13))
  }

  @Test
  fun theSameHourTwiceMeansNoQuietHours() {
    (0..23).forEach { assertFalse(QuietHours.contains(it, 10, 10)) }
  }

  @Test
  fun theLabelReadsAsARange() {
    assertEquals("23:00 a 8:00", QuietHours.label(QuietHours.DEFAULT_FROM, QuietHours.DEFAULT_UNTIL))
  }
}
