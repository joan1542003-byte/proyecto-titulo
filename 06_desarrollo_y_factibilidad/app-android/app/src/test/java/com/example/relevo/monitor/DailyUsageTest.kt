package com.example.relevo.monitor

import org.junit.Assert.assertEquals
import org.junit.Test

/** Uso diario (D-097): tiempo por app, aperturas y total de pantalla. */
class DailyUsageTest {
  private val resumed = ForegroundTracker.Kind.RESUMED
  private val paused = ForegroundTracker.Kind.PAUSED
  private val screenOff = ForegroundTracker.Kind.SCREEN_OFF
  private fun e(at: Long, kind: ForegroundTracker.Kind, pkg: String?) = ForegroundEvent(at, kind, pkg)

  @Test
  fun sumsTimeAndOpensPerApp() {
    val usage = DailyUsage.aggregate(listOf(
      e(1_000, resumed, "insta"), e(61_000, paused, "insta"),
      e(70_000, resumed, "tiktok"), e(100_000, screenOff, null),
      e(200_000, resumed, "insta"), e(230_000, paused, "insta"),
    ), start = 0, end = 300_000)
    assertEquals(90L, usage.seconds["insta"])
    assertEquals(30L, usage.seconds["tiktok"])
    assertEquals(2, usage.opens["insta"])
    assertEquals(1, usage.opens["tiktok"])
    assertEquals(120L, usage.totalSeconds)
  }

  @Test
  fun clipsToTheDayAndKeepsTheAppOpenAtMidnight() {
    // La app se abrió antes de medianoche: cuenta solo desde el inicio del día y no suma una apertura.
    val usage = DailyUsage.aggregate(listOf(e(-30_000, resumed, "insta"), e(20_000, paused, "insta")), start = 0, end = 60_000)
    assertEquals(20L, usage.seconds["insta"])
    assertEquals(null, usage.opens["insta"])
  }

  @Test
  fun anAppStillOpenCountsUntilTheEnd() {
    val usage = DailyUsage.aggregate(listOf(e(10_000, resumed, "insta")), start = 0, end = 70_000)
    assertEquals(60L, usage.seconds["insta"])
  }

  @Test
  fun returningWithinSecondsIsTheSameOpen() {
    val usage = DailyUsage.aggregate(listOf(
      e(0, resumed, "insta"), e(10_000, paused, "insta"), e(12_000, resumed, "insta"), e(40_000, paused, "insta"),
    ), start = 0, end = 60_000)
    assertEquals(1, usage.opens["insta"])
    assertEquals(38L, usage.seconds["insta"])
  }

  @Test
  fun launcherTimeIsNotScreenTime() {
    val usage = DailyUsage.aggregate(listOf(
      e(0, resumed, "launcher"), e(30_000, resumed, "insta"), e(90_000, screenOff, null),
    ), start = 0, end = 100_000, excluded = setOf("launcher"))
    assertEquals(30L, usage.seconds["launcher"])
    assertEquals(60L, usage.totalSeconds)
  }

  @Test
  fun aLatePauseFromThePreviousAppDoesNotStopTheNewOne() {
    val usage = DailyUsage.aggregate(listOf(
      e(0, resumed, "insta"), e(20_000, resumed, "tiktok"), e(20_500, paused, "insta"), e(50_000, paused, "tiktok"),
    ), start = 0, end = 60_000)
    assertEquals(20L, usage.seconds["insta"])
    assertEquals(30L, usage.seconds["tiktok"])
  }
}
