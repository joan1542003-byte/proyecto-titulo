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
import com.example.relevo.domain.SignalRoute
import kotlin.concurrent.thread
import kotlin.math.max
import kotlin.math.min

class SignalPlayer(private val context: Context) {
  /** SIGNAL: señal de unos 30 s que termina sola (D-078). TEST: una firma para probar el sonido. */
  enum class Pattern { SIGNAL, TEST }

  /** Cómo terminó la reproducción. */
  enum class Ending { COMPLETED, ROUTE_LOST, STOPPED }

  @Volatile private var playing = false
  @Volatile var isPlaying = false
    private set
  private var audioTrack: AudioTrack? = null
  private var audioThread: Thread? = null

  /**
   * Dirige la señal a la salida que la persona eligió, sin redirigirla silenciosamente. Devuelve
   * false si esa salida no está disponible. [onEnded] se llama una vez, desde otro hilo, cuando la
   * señal termina sola, cuando se pierde la salida o cuando se detiene con [stop].
   */
  fun play(route: SignalRoute = SignalRoute.BLUETOOTH, pattern: Pattern = Pattern.SIGNAL, onEnded: ((Ending) -> Unit)? = null): Boolean {
    stop()
    val audioManager = context.getSystemService(AudioManager::class.java) ?: return false
    val chosenOutput =
      audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS).firstOrNull { device ->
        if (route == SignalRoute.BLUETOOTH) isBluetoothMediaOutput(device)
        else device.type == AudioDeviceInfo.TYPE_BUILTIN_SPEAKER
      }
        ?: run {
          vibrateOnce()
          return false
        }

    val sampleRate = FirmaSonora.SAMPLE_RATE
    val minimumBuffer = AudioTrack.getMinBufferSize(sampleRate, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT)
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

    if (!track.setPreferredDevice(chosenOutput)) {
      track.release()
      vibrateOnce()
      return false
    }

    track.play()
    val silence = ShortArray(2_048)
    repeat(10) {
      track.write(silence, 0, silence.size, AudioTrack.WRITE_BLOCKING)
      if (track.routedDevice?.id == chosenOutput.id) {
        audioTrack = track
        playing = true
        isPlaying = true
        val pcm = if (pattern == Pattern.SIGNAL) FirmaSonora.signal() else FirmaSonora.test()
        startPlayback(track, chosenOutput.id, pcm, onEnded)
        vibrateOnce()
        return true
      }
    }
    track.stop()
    track.release()
    return false
  }

  private fun startPlayback(track: AudioTrack, outputId: Int, pcm: ShortArray, onEnded: ((Ending) -> Unit)?) {
    audioThread =
      thread(name = "relevo-signal", isDaemon = true) {
        var ending = Ending.COMPLETED
        var position = 0
        while (position < pcm.size) {
          if (!playing) { ending = Ending.STOPPED; break }
          if (track.routedDevice?.id != outputId) { ending = Ending.ROUTE_LOST; break }
          val count = min(CHUNK, pcm.size - position)
          val written = track.write(pcm, position, count, AudioTrack.WRITE_BLOCKING)
          if (written < 0) { ending = Ending.ROUTE_LOST; break }
          position += written
        }
        // Deja sonar lo que queda en el búfer antes de cerrar.
        if (ending == Ending.COMPLETED) runCatching { Thread.sleep(250) }
        // Solo stop() apaga `playing`: si ocurrió, la señal se detuvo por decisión de la persona.
        if (!playing) ending = Ending.STOPPED
        playing = false
        isPlaying = false
        onEnded?.invoke(ending)
      }
  }

  fun stop() {
    playing = false
    audioThread?.let { worker ->
      worker.interrupt()
      runCatching { worker.join(400L) }
    }
    audioThread = null
    audioTrack?.let { track ->
      runCatching { track.pause() }
      runCatching { track.flush() }
      runCatching { track.stop() }
      track.release()
    }
    audioTrack = null
    isPlaying = false
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

  private companion object { const val CHUNK = 2_048 }
}
