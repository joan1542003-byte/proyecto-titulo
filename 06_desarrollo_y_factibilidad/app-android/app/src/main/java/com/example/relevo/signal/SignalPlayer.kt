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
  /** La señal abrió el canal de llamada (salida WATCH) y hay que cerrarlo al terminar. */
  @Volatile private var usingCallRoute = false

  /**
   * Dirige la señal a la salida que la persona eligió, sin redirigirla silenciosamente. Devuelve
   * false si esa salida no está disponible. [onEnded] se llama una vez, desde otro hilo, cuando la
   * señal termina sola, cuando se pierde la salida o cuando se detiene con [stop].
   */
  fun play(route: SignalRoute = SignalRoute.BLUETOOTH, pattern: Pattern = Pattern.SIGNAL, onEnded: ((Ending) -> Unit)? = null): Boolean {
    stop()
    val audioManager = context.getSystemService(AudioManager::class.java) ?: return false
    val callRoute = route == SignalRoute.WATCH
    val chosenOutput =
      (if (callRoute) callDevice(audioManager)
      else audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS).firstOrNull { device ->
        if (route == SignalRoute.BLUETOOTH) isBluetoothMediaOutput(device)
        else device.type == AudioDeviceInfo.TYPE_BUILTIN_SPEAKER
      })
        ?: run {
          vibrateOnce()
          return false
        }

    // El reloj recibe el tono como audio de llamada: se abre el canal de comunicación hacia él.
    if (callRoute) {
      audioManager.mode = AudioManager.MODE_IN_COMMUNICATION
      usingCallRoute = true
      if (!audioManager.setCommunicationDevice(chosenOutput)) {
        releaseCallRoute(audioManager)
        vibrateOnce()
        return false
      }
    }

    val sampleRate = FirmaSonora.SAMPLE_RATE
    val minimumBuffer = AudioTrack.getMinBufferSize(sampleRate, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT)
    if (minimumBuffer <= 0) {
      releaseCallRoute(audioManager)
      return false
    }

    val track =
      AudioTrack.Builder()
        .setAudioAttributes(
          AudioAttributes.Builder()
            .setUsage(if (callRoute) AudioAttributes.USAGE_VOICE_COMMUNICATION else AudioAttributes.USAGE_MEDIA)
            .setContentType(if (callRoute) AudioAttributes.CONTENT_TYPE_SPEECH else AudioAttributes.CONTENT_TYPE_SONIFICATION)
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

    // En el canal de llamada la ruta la fija el equipo de comunicación; la preferencia es solo una ayuda.
    if (!track.setPreferredDevice(chosenOutput) && !callRoute) {
      track.release()
      vibrateOnce()
      return false
    }

    track.play()
    val silence = ShortArray(2_048)
    // El canal de llamada tarda más en abrirse (hasta unos 4 s) que un parlante multimedia.
    repeat(if (callRoute) 90 else 10) {
      track.write(silence, 0, silence.size, AudioTrack.WRITE_BLOCKING)
      if (sameOutput(track.routedDevice, chosenOutput)) {
        audioTrack = track
        playing = true
        isPlaying = true
        val pcm = if (pattern == Pattern.SIGNAL) FirmaSonora.signal() else FirmaSonora.test()
        startPlayback(track, chosenOutput, callRoute, pcm, onEnded)
        vibrateOnce()
        return true
      }
    }
    track.stop()
    track.release()
    releaseCallRoute(audioManager)
    return false
  }

  /** Equipos conectados que pueden recibir audio de llamada, como un reloj que contesta llamadas. */
  private fun callDevice(audioManager: AudioManager): AudioDeviceInfo? =
    audioManager.availableCommunicationDevices.firstOrNull {
      it.type == AudioDeviceInfo.TYPE_BLUETOOTH_SCO || it.type == AudioDeviceInfo.TYPE_BLE_HEADSET
    }

  private fun sameOutput(routed: AudioDeviceInfo?, chosen: AudioDeviceInfo): Boolean =
    routed != null && (routed.id == chosen.id || (routed.type == chosen.type && routed.address == chosen.address))

  /** Devuelve el audio del teléfono a su estado normal si la señal usó el canal de llamada. */
  private fun releaseCallRoute(audioManager: AudioManager? = context.getSystemService(AudioManager::class.java)) {
    if (!usingCallRoute) return
    usingCallRoute = false
    audioManager ?: return
    runCatching { audioManager.clearCommunicationDevice() }
    runCatching { audioManager.mode = AudioManager.MODE_NORMAL }
  }

  private fun startPlayback(track: AudioTrack, output: AudioDeviceInfo, callRoute: Boolean, pcm: ShortArray, onEnded: ((Ending) -> Unit)?) {
    audioThread =
      thread(name = "relevo-signal", isDaemon = true) {
        var ending = Ending.COMPLETED
        var position = 0
        while (position < pcm.size) {
          if (!playing) { ending = Ending.STOPPED; break }
          val routed = track.routedDevice
          // En el canal de llamada la ruta puede quedar un instante sin informar; solo cuenta un cambio real.
          val lost = if (callRoute) routed != null && !sameOutput(routed, output) else !sameOutput(routed, output)
          if (lost) { ending = Ending.ROUTE_LOST; break }
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
        releaseCallRoute()
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
    releaseCallRoute()
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
