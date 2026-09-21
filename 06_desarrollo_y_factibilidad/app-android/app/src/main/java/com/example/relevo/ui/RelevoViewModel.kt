package com.example.relevo.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.relevo.data.ReminderStore
import com.example.relevo.domain.Reminder
import com.example.relevo.domain.ReminderStatus
import com.example.relevo.signal.SignalPlayer
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RelevoViewModel(application: Application) : AndroidViewModel(application) {
  private val store = ReminderStore(application)
  private val signalPlayer = SignalPlayer(application)
  private val _reminder = MutableStateFlow(store.load())
  val reminder: StateFlow<Reminder> = _reminder.asStateFlow()

  private val _remainingSeconds = MutableStateFlow(0)
  val remainingSeconds: StateFlow<Int> = _remainingSeconds.asStateFlow()

  private var countdownJob: Job? = null

  init {
    resumeCountdownIfNeeded()
  }

  fun updateActivity(value: String) = update { copy(activity = value, status = ReminderStatus.DRAFT) }

  fun updateHowToStart(value: String) = update { copy(howToStart = value, status = ReminderStatus.DRAFT) }

  fun updatePlace(value: String) =
    update {
      copy(
        place = value,
        status = if (hasPreparedContent) ReminderStatus.READY else ReminderStatus.DRAFT,
      )
    }

  fun updateDelay(seconds: Int) = update { copy(delaySeconds = seconds.coerceAtLeast(1), status = ReminderStatus.DRAFT) }

  fun markReady(): Boolean {
    val next = _reminder.value.ready()
    updateValue(next)
    return next.status == ReminderStatus.READY
  }

  fun arm(nowMillis: Long = System.currentTimeMillis()): Boolean {
    val next = _reminder.value.arm(nowMillis)
    updateValue(next)
    if (next.status == ReminderStatus.WAITING) startCountdown()
    return next.status == ReminderStatus.WAITING
  }

  fun testSignal() = signalPlayer.play()

  fun stopTestSignal() = signalPlayer.stop()

  fun disarm() {
    countdownJob?.cancel()
    signalPlayer.stop()
    updateValue(_reminder.value.disarm())
    _remainingSeconds.value = 0
  }

  fun silence() {
    signalPlayer.stop()
    updateValue(_reminder.value.silence())
  }

  fun close() {
    countdownJob?.cancel()
    signalPlayer.stop()
    updateValue(_reminder.value.close())
    _remainingSeconds.value = 0
  }

  fun reset() {
    countdownJob?.cancel()
    signalPlayer.stop()
    store.clear()
    _reminder.value = Reminder()
    _remainingSeconds.value = 0
  }

  private fun resumeCountdownIfNeeded() {
    if (_reminder.value.status == ReminderStatus.WAITING) startCountdown()
  }

  private fun startCountdown() {
    countdownJob?.cancel()
    countdownJob =
      viewModelScope.launch {
        while (_reminder.value.status == ReminderStatus.WAITING) {
          val target = _reminder.value.scheduledAtMillis ?: break
          val remainingMillis = target - System.currentTimeMillis()
          if (remainingMillis <= 0) {
            val next = _reminder.value.deliverSignal()
            updateValue(next)
            if (next.status == ReminderStatus.SIGNALLED) signalPlayer.play()
            _remainingSeconds.value = 0
            break
          }
          _remainingSeconds.value = ((remainingMillis + 999) / 1_000).toInt()
          delay(250)
        }
      }
  }

  private fun update(transform: Reminder.() -> Reminder) = updateValue(_reminder.value.transform())

  private fun updateValue(value: Reminder) {
    _reminder.value = value
    store.save(value)
  }

  override fun onCleared() {
    signalPlayer.stop()
    super.onCleared()
  }
}
