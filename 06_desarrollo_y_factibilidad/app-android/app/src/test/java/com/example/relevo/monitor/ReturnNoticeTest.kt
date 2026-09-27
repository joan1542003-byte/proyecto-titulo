package com.example.relevo.monitor

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ReturnNoticeTest {
  private val week = ReturnNotice.WEEK_MILLIS
  private val now = 100 * week

  @Test fun noNoticeIfTheAppWasOpenedThisWeek() {
    assertFalse(ReturnNotice.due(now, lastOpenedAt = now - week + 1, lastNoticeAt = 0L))
  }

  @Test fun noticeAfterAWeekWithoutOpening() {
    assertTrue(ReturnNotice.due(now, lastOpenedAt = now - week, lastNoticeAt = 0L))
  }

  @Test fun atMostOneNoticePerWeek() {
    assertFalse(ReturnNotice.due(now, lastOpenedAt = now - 3 * week, lastNoticeAt = now - week + 1))
    assertTrue(ReturnNotice.due(now, lastOpenedAt = now - 3 * week, lastNoticeAt = now - week))
  }
}
