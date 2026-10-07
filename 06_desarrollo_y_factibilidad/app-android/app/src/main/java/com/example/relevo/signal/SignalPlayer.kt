package com.example.relevo.signal

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioDeviceInfo
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Build
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import com.example.relevo.data.TagStore
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.TagProtocol
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.math.max
import kotlin.math.min

class SignalPlayer(private val context: Context) {
  /** SIGNAL: señal de unos 30 s que termina sola (D-078). TEST: una firma para probar el sonido. */
  enum class Pattern { SIGNAL, TEST }

  /** Cómo terminó la reproducción. SILENCED_ON_OBJECT: se apretó el botón del llavero (D-109). */
  enum class Ending { COMPLETED, ROUTE_LOST, STOPPED, SILENCED_ON_OBJECT }

  @Volatile private var playing = false
  @Volatile var isPlaying = false
    private set
  private var audioTrack: AudioTrack? = null
  private var audioThread: Thread? = null
  /** Pitidos del llavero (salida TAG). */
  private var tagThread: Thread? = null
  /** La señal abrió el canal de llamada (salida WATCH) y hay que cerrarlo al terminar. */
  @Volatile private var usingCallRoute = false

  /**
   * Dirige la señal a la salida que la persona eligió, sin redirigirla silenciosamente. Devuelve
   * false si esa salida no está disponible. [onEnded] se llama una vez, desde otro hilo, cuando la
   * señal termina sola, cuando se pierde la salida o cuando se detiene con [stop].
   */
  fun play(route: SignalRoute = SignalRoute.BLUETOOTH, pattern: Pattern = Pattern.SIGNAL, onEnded: ((Ending) -> Unit)? = null): Boolean {
    stop()
    if (route == SignalRoute.TAG) return playOnTag(pattern, onEnded)
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

  /**
   * El llavero pita seis veces, 2 s cada vez, durante 30 s; la prueba es un pitido. Si no está
   * conectado, se conecta antes (hasta 20 s), salvo que la orden llegue desde la pantalla: ahí no se
   * espera, se abre la conexión en segundo plano y se avisa que no sonó. Apretar su botón la silencia.
   */
  private fun playOnTag(pattern: Pattern, onEnded: ((Ending) -> Unit)?): Boolean {
    val address = TagStore(context).address
    if (address == null || !TagLink.hasPermissions(context)) {
      vibrateOnce()
      return false
    }
    val onScreen = Looper.myLooper() == Looper.getMainLooper()
    val ready = TagLink.isConnectedTo(address) ||
      if (onScreen) {
        TagLink.connectInBackground(context, address)
        false
      } else {
        runBlocking { withTimeoutOrNull(TAG_CONNECT_MILLIS) { TagLink.connect(context, address) } } == true
      }
    if (!ready || !runBlocking { TagLink.alertOn(context) }) {
      vibrateOnce()
      return false
    }
    playing = true
    isPlaying = true
    val pressed = AtomicBoolean(false)
    TagLink.onButton = { pressed.set(true) }
    tagThread =
      thread(name = "relevo-tag", isDaemon = true) {
        var ending = Ending.COMPLETED
        // Espera [millis] mientras suena; devuelve por qué se cortó antes, o null si terminó la espera.
        fun waitOrEnd(millis: Long): Ending? {
          var waited = 0L
          while (waited < millis) {
            when {
              pressed.get() -> return Ending.SILENCED_ON_OBJECT
              !playing -> return Ending.STOPPED
              !TagLink.isConnectedTo(address) -> return Ending.ROUTE_LOST
            }
            runCatching { Thread.sleep(TAG_STEP_MILLIS) }
            waited += TAG_STEP_MILLIS
          }
          return null
        }
        for ((index, pulse) in TagProtocol.pulses(pattern == Pattern.TEST).withIndex()) {
          // El primer pitido ya se encendió al empezar.
          if (index > 0 && !runBlocking { TagLink.alertOn(context) }) { ending = Ending.ROUTE_LOST; break }
          waitOrEnd(pulse.onMillis)?.let { ending = it }
          runBlocking { TagLink.setAlert(TagProtocol.ALERT_OFF) }
          if (ending != Ending.COMPLETED) break
          if (pulse.offMillis > 0L) waitOrEnd(pulse.offMillis)?.let { ending = it }
          if (ending != Ending.COMPLETED) break
        }
        TagLink.onButton = null
        // Solo stop() apaga `playing`: si ocurrió, la señal se detuvo por decisión de la persona en la app.
        if (!playing && ending == Ending.COMPLETED) ending = Ending.STOPPED
        playing = false
        isPlaying = false
        onEnded?.invoke(ending)
      }
    vibrateOnce()
    return true
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
    // El hilo del llavero ve `playing` apagado en una décima de segundo y apaga el pitido al salir.
    tagThread?.let { worker -> runCatching { worker.join(400L) } }
    tagThread = null
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

  private companion object {
    const val CHUNK = 2_048
    const val TAG_CONNECT_MILLIS = 20_000L
    const val TAG_STEP_MILLIS = 100L
  }
}
