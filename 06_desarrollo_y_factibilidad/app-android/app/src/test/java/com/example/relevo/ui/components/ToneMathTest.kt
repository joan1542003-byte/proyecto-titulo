package com.example.relevo.ui.components

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ToneMathTest {
  @Test fun aWideImageInATallFrameIsCroppedAtTheSides() {
    assertArrayEquals(intArrayOf(40, 0, 80, 100), ToneMath.visibleArea(160, 100, 0.8f))
  }

  @Test fun aTallImageInAWideFrameIsCroppedAboveAndBelow() {
    assertArrayEquals(intArrayOf(0, 25, 100, 50), ToneMath.visibleArea(100, 100, 2f))
  }

  @Test fun blackIsDarkAndPaperIsLight() {
    val black = IntArray(16) { 0xFF000000.toInt() }
    val paper = IntArray(16) { 0xFFF2F2EF.toInt() }
    assertEquals(0f, ToneMath.meanLuminance(black), 0.001f)
    assertTrue(ToneMath.meanLuminance(black) < ToneMath.DARK_BELOW)
    assertTrue(ToneMath.meanLuminance(paper) > ToneMath.DARK_BELOW)
  }

  @Test fun midGrayIsOnTheLightSide() {
    // #808080 tiene una luminancia de 0,22: el texto de tinta todavía contrasta más que el blanco.
    val gray = IntArray(4) { 0xFF808080.toInt() }
    assertEquals(0.216f, ToneMath.meanLuminance(gray), 0.002f)
    assertTrue(ToneMath.meanLuminance(gray) > ToneMath.DARK_BELOW)
  }
}
