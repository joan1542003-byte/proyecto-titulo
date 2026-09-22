package com.example.relevo.signal

import android.content.Context
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

class SignalPlayer(private val context: Context) {
  private var toneGenerator: ToneGenerator? = null

  fun play() {
    stop()
    toneGenerator = ToneGenerator(AudioManager.STREAM_ALARM, 65).also {
      it.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 3_000)
    }
    vibrator()?.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 220, 140, 220, 140, 500), -1))
  }

  fun stop() {
    toneGenerator?.stopTone()
    toneGenerator?.release()
    toneGenerator = null
    vibrator()?.cancel()
  }

  @Suppress("DEPRECATION")
  private fun vibrator(): Vibrator? =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
      context.getSystemService(VibratorManager::class.java)?.defaultVibrator
    } else {
      context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    }
}
