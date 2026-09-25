package com.example.relevo.monitor

import com.example.relevo.monitor.ForegroundTracker.Kind
import org.junit.Assert.assertEquals
import org.junit.Test

class UsageWindowTest {
  private val tracked = setOf("app.a", "app.b")
  private fun event(second: Long, kind: Kind, pkg: String?) = ForegroundEvent(second * 1_000L, kind, pkg)

  @Test
  fun countsAnAppThatWasAlreadyOpenWhenTheWindowStarted() {
    val events = listOf(event(50, Kind.RESUMED, "app.a"), event(130, Kind.PAUSED, "app.a"))
    assertEquals(30_000L, UsageWindow.trackedMillis(events, 100_000L, 200_000L, tracked))
  }

  @Test
  fun sumsSeveralTrackedAppsAndIgnoresOthers() {
    val events = listOf(
      event(110, Kind.RESUMED, "app.a"),
      event(120, Kind.PAUSED, "app.a"),
      event(120, Kind.RESUMED, "other"),
      event(150, Kind.PAUSED, "other"),
      event(150, Kind.RESUMED, "app.b"),
    )
    // 10 s en app.a y 50 s en app.b, que sigue abierta hasta el final de la ventana.
    assertEquals(60_000L, UsageWindow.trackedMillis(events, 100_000L, 200_000L, tracked))
  }

  @Test
  fun stopsCountingWhenTheScreenTurnsOff() {
    val events = listOf(event(100, Kind.RESUMED, "app.a"), event(140, Kind.SCREEN_OFF, null))
    assertEquals(40_000L, UsageWindow.trackedMillis(events, 100_000L, 200_000L, tracked))
  }

  @Test
  fun ignoresEventsAfterTheWindow() {
    val events = listOf(event(90, Kind.RESUMED, "other"), event(250, Kind.RESUMED, "app.a"))
    assertEquals(0L, UsageWindow.trackedMillis(events, 100_000L, 200_000L, tracked))
  }
}
