package com.example.relevo.signal

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioDeviceInfo
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import kotlin.concurrent.thread
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.sin

class SignalPlayer(private val context: Context) {
  @Volatile private var playing = false
  private var audioTrack: AudioTrack? = null
  private var audioThread: Thread? = null

  /** Reproduce de forma continua solo si existe una salida Bluetooth multimedia. */
  fun play(): Boolean {
    stop()
    val audioManager = context.getSystemService(AudioManager::class.java) ?: return false
    val bluetoothOutput =
      audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS).firstOrNull(::isBluetoothMediaOutput)
        ?: run {
          vibrateOnce()
          return false
        }

    val sampleRate = 44_100
    val minimumBuffer = AudioTrack.getMinBufferSize(
      sampleRate,
      AudioFormat.CHANNEL_OUT_MONO,
      AudioFormat.ENCODING_PCM_16BIT,
    )
    if (minimumBuffer <= 0) return false

    val track =
      AudioTrack.Builder()
        .setAudioAttributes(
          AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build(),
        )
        .setAudioFormat(
          AudioFormat.Builder()
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setSampleRate(sampleRate)
            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
            .build(),
        )
        .setBufferSizeInBytes(max(minimumBuffer, 8_192))
        .setTransferMode(AudioTrack.MODE_STREAM)
        .build()

    if (!track.setPreferredDevice(bluetoothOutput)) {
      track.release()
      vibrateOnce()
      return false
    }

    track.play()
    val silence = ShortArray(2_048)
    repeat(10) {
      track.write(silence, 0, silence.size, AudioTrack.WRITE_BLOCKING)
      if (track.routedDevice?.id == bluetoothOutput.id) {
        audioTrack = track
        playing = true
        startTone(track, bluetoothOutput.id, sampleRate)
        vibrateOnce()
        return true
      }
    }
    track.stop()
    track.release()
    return false
  }

  private fun startTone(track: AudioTrack, outputId: Int, sampleRate: Int) {
    audioThread =
      thread(name = "relevo-bluetooth-signal", isDaemon = true) {
        val samples = ShortArray(2_048)
        var sampleIndex = 0L
        while (playing) {
          if (track.routedDevice?.id != outputId) {
            playing = false
            break
          }
          for (index in samples.indices) {
            val frequency = if ((sampleIndex % sampleRate) < sampleRate / 2) 660.0 else 784.0
            val phase = 2.0 * PI * frequency * sampleIndex / sampleRate
            samples[index] = (sin(phase) * Short.MAX_VALUE * 0.18).toInt().toShort()
            sampleIndex += 1
          }
          if (track.write(samples, 0, samples.size, AudioTrack.WRITE_BLOCKING) < 0) {
            playing = false
            break
          }
        }
      }
  }

  fun stop() {
    playing = false
    audioThread?.let { worker ->
      worker.interrupt()
      runCatching { worker.join(300L) }
    }
    audioThread = null
    audioTrack?.let { track ->
      runCatching { track.pause() }
      runCatching { track.flush() }
      runCatching { track.stop() }
      track.release()
    }
    audioTrack = null
    vibrator()?.cancel()
  }

  private fun vibrateOnce() {
    vibrator()?.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 220, 140, 220, 140, 500), -1))
  }

  private fun isBluetoothMediaOutput(device: AudioDeviceInfo): Boolean =
    device.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP ||
      (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && device.type == AudioDeviceInfo.TYPE_BLE_SPEAKER)

  @Suppress("DEPRECATION")
  private fun vibrator(): Vibrator? =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
      context.getSystemService(VibratorManager::class.java)?.defaultVibrator
    } else {
      context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    }
}
