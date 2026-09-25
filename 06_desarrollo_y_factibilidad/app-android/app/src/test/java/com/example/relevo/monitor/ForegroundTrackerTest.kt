package com.example.relevo.monitor

import com.example.relevo.monitor.ForegroundTracker.Kind
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ForegroundTrackerTest {
  private val tracked = setOf("app.a", "app.b")
  private val isTracked: (String?) -> Boolean = { it in tracked }

  @Test
  fun sumsTimeWhileAlternatingBetweenTrackedApps() {
    val tracker = ForegroundTracker(0L)
    tracker.onEvent(Kind.RESUMED, "app.a")
    (1..10).forEach { tracker.tick(it * 1_000L, isTracked) }
    tracker.onEvent(Kind.PAUSED, "app.a")
    tracker.onEvent(Kind.RESUMED, "app.b")
    (11..15).forEach { tracker.tick(it * 1_000L, isTracked) }
    assertEquals(15_000L, tracker.accumulatedMillis)
  }

  @Test
  fun pausesOutsideTrackedAppsAndResumesOnReturn() {
    val tracker = ForegroundTracker(0L)
    tracker.onEvent(Kind.RESUMED, "app.a")
    (1..5).forEach { tracker.tick(it * 1_000L, isTracked) }
    tracker.onEvent(Kind.PAUSED, "app.a")
    tracker.onEvent(Kind.RESUMED, "other.app")
    (6..20).forEach { tracker.tick(it * 1_000L, isTracked) }
    tracker.onEvent(Kind.RESUMED, "app.b")
    (21..23).forEach { tracker.tick(it * 1_000L, isTracked) }
    assertEquals(8_000L, tracker.accumulatedMillis)
  }

  @Test
  fun latePauseOfPreviousAppDoesNotStopCounting() {
    val tracker = ForegroundTracker(0L)
    tracker.onEvent(Kind.RESUMED, "app.a")
    tracker.onEvent(Kind.RESUMED, "app.b")
    tracker.onEvent(Kind.PAUSED, "app.a")
    (1..4).forEach { tracker.tick(it * 1_000L, isTracked) }
    assertEquals("app.b", tracker.currentPackage)
    assertEquals(4_000L, tracker.accumulatedMillis)
  }

  @Test
  fun screenOffStopsCounting() {
    val tracker = ForegroundTracker(0L)
    tracker.onEvent(Kind.RESUMED, "app.a")
    tracker.tick(1_000L, isTracked)
    tracker.onEvent(Kind.SCREEN_OFF, null)
    tracker.tick(2_000L, isTracked)
    assertNull(tracker.currentPackage)
    assertEquals(1_000L, tracker.accumulatedMillis)
  }

  @Test
  fun longGapIsNotCountedAsContinuousUse() {
    val tracker = ForegroundTracker(0L)
    tracker.onEvent(Kind.RESUMED, "app.a")
    tracker.tick(60_000L, isTracked)
    assertEquals(ForegroundTracker.MAX_STEP_MILLIS, tracker.accumulatedMillis)
  }
}
