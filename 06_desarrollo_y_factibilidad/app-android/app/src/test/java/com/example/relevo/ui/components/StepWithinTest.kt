package com.example.relevo.ui.components

import org.junit.Assert.assertEquals
import org.junit.Test

/** 4.6.3: las horas sin sonar dan la vuelta; la constancia se queda en sus bordes. */
class StepWithinTest {
  @Test
  fun hoursWrapForwardAndBack() {
    assertEquals(0, stepWithin(23, 1, 0..23, wrap = true))
    assertEquals(23, stepWithin(0, -1, 0..23, wrap = true))
    assertEquals(9, stepWithin(8, 1, 0..23, wrap = true))
  }

  @Test
  fun withoutWrapStaysAtTheEdges() {
    assertEquals(7, stepWithin(7, 1, 1..7, wrap = false))
    assertEquals(1, stepWithin(1, -1, 1..7, wrap = false))
    assertEquals(4, stepWithin(3, 1, 1..7, wrap = false))
  }
}
