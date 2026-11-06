package com.example.relevo.signal

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioDeviceInfo
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Looper
import android.os.VibrationEffect
import android.os.VibratorManager
import com.example.relevo.data.SettingsStore
import com.example.relevo.data.TagStore
import com.example.relevo.domain.SignalRoute
import com.example.relevo.domain.TagProtocol
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/** Hace sonar el relevo en el Tag, en el teléfono o en un dispositivo de audio Bluetooth. */
class SignalPlayer(private val context: Context) {
  /** SIGNAL: unos 30 s que terminan solos (D-078). TEST: una firma, para probar el sonido. */
  enum class Pattern { SIGNAL, TEST }

  /** Cómo terminó. SILENCED_ON_OBJECT: se apretó el botón del Tag (D-109). */
  enum class Ending { COMPLETED, ROUTE_LOST, STOPPED, SILENCED_ON_OBJECT }

  @Volatile private var playing = false
  @Volatile var isPlaying = false
    private set
  private var audioTrack: AudioTrack? = null
  private var audioThread: Thread? = null
  /** Pitidos del Tag. */
  private var tagThread: Thread? = null

  /**
   * Suena en la salida que la persona eligió, sin cambiarla en silencio. Devuelve false si esa salida no
   * está disponible. [onEnded] se llama una vez, desde otro hilo, cuando termina sola, cuando se pierde la
   * salida o cuando se detiene con [stop].
   */
  fun play(route: SignalRoute, pattern: Pattern = Pattern.SIGNAL, onEnded: ((Ending) -> Unit)? = null): Boolean {
    stop()
    if (route == SignalRoute.TAG) return playOnTag(pattern, onEnded)
    val audioManager = context.getSystemService(AudioManager::class.java) ?: return false
    val chosenOutput = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS).firstOrNull { device ->
      if (route == SignalRoute.BLUETOOTH) isBluetoothAudioOutput(device) else device.type == AudioDeviceInfo.TYPE_BUILTIN_SPEAKER
    } ?: run {
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
      if (sameOutput(track.routedDevice, chosenOutput)) {
        audioTrack = track
        playing = true
        isPlaying = true
        // El sonido elegido en Ajustes (4.3) con el volumen elegido (4.4); sin elección, la madera, la firma.
        val sonido = Sonido.from(SettingsStore(context).load().sound)
        val pcm = scaled(if (pattern == Pattern.SIGNAL) FirmaSonora.signal(sonido) else FirmaSonora.test(sonido))
        startPlayback(track, chosenOutput, pcm, onEnded)
        vibrateOnce()
        return true
      }
    }
    track.stop()
    track.release()
    return false
  }

  /** El sonido con el volumen que eligió la persona (1.0.0). El volumen multimedia del teléfono sigue mandando. */
  private fun scaled(pcm: ShortArray): ShortArray {
    val gain = SettingsStore(context).load().volume.gain
    if (gain >= 1f) return pcm
    return ShortArray(pcm.size) { (pcm[it] * gain).roundToInt().toShort() }
  }

  /**
   * El Tag pita seguido 30 s, o 3 s en la prueba, hasta que se toca su botón (D-116). Si no está conectado,
   * se conecta antes (hasta 30 s), salvo que la orden llegue desde la pantalla: ahí no se espera, se abre la
   * conexión en segundo plano y se avisa que no sonó. Si el Tag no confirma la orden, se insiste una vez.
   */
  private fun playOnTag(pattern: Pattern, onEnded: ((Ending) -> Unit)?): Boolean {
    val address = TagStore(context).address
    if (address == null || !TagLink.hasPermissions(context)) {
      vibrateOnce()
      return false
    }
    val onScreen = Looper.myLooper() == Looper.getMainLooper()
    var on = TagLink.isConnectedTo(address) && runBlocking { TagLink.alertOn(context) }
    if (!on && onScreen) {
      TagLink.connectInBackground(context, address)
    } else if (!on) {
      on = runBlocking { withTimeoutOrNull(TAG_CONNECT_MILLIS) { TagLink.reconnect(context, address) && TagLink.alertOn(context) } } == true
    }
    if (!on) {
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
        val endAt = System.currentTimeMillis() + TagProtocol.durationMillis(pattern == Pattern.TEST)
        var repeatAt = System.currentTimeMillis() + TagProtocol.REPEAT_MILLIS
        var misses = 0
        var reopened = false
        while (System.currentTimeMillis() < endAt) {
          when {
            pressed.get() -> { ending = Ending.SILENCED_ON_OBJECT; break }
            !playing -> { ending = Ending.STOPPED; break }
            !TagLink.isConnectedTo(address) && reopened -> { ending = Ending.ROUTE_LOST; break }
          }
          // La orden se repite cada segundo para que el pitido siga. Tres fallos seguidos o una conexión
          // perdida abren la conexión de nuevo una vez (2.31); si vuelve a fallar, cuenta como corte.
          if (System.currentTimeMillis() >= repeatAt || !TagLink.isConnectedTo(address)) {
            misses = if (TagLink.isConnectedTo(address) && runBlocking { TagLink.alertOn(context) }) 0 else misses + 1
            if (misses >= TAG_MISSES || !TagLink.isConnectedTo(address)) {
              if (reopened) { ending = Ending.ROUTE_LOST; break }
              reopened = true
              val back = runBlocking { withTimeoutOrNull(TAG_CONNECT_MILLIS) { TagLink.reconnect(context, address) && TagLink.alertOn(context) } } == true
              if (!back) { ending = Ending.ROUTE_LOST; break }
              misses = 0
            }
            repeatAt = System.currentTimeMillis() + TagProtocol.REPEAT_MILLIS
          }
          runCatching { Thread.sleep(TAG_STEP_MILLIS) }
        }
        val quiet = runBlocking { TagLink.alertOff() }
        TagLink.onButton = null
        // Solo stop() apaga `playing`: si ocurrió, el sonido se detuvo por decisión de la persona en la app.
        if (!playing && ending == Ending.COMPLETED) ending = Ending.STOPPED
        playing = false
        isPlaying = false
        onEnded?.invoke(ending)
        // Si el Tag no confirmó que se calló, se abre otra conexión para callarlo y apagar su alarma por
        // desconexión (2.31). Va después de avisar el final, para no alargar la duración registrada.
        if (!quiet) TagLink.quietInBackground(context)
      }
    vibrateOnce()
    return true
  }

  private fun sameOutput(routed: AudioDeviceInfo?, chosen: AudioDeviceInfo): Boolean =
    routed != null && (routed.id == chosen.id || (routed.type == chosen.type && routed.address == chosen.address))

  private fun startPlayback(track: AudioTrack, output: AudioDeviceInfo, pcm: ShortArray, onEnded: ((Ending) -> Unit)?) {
    audioThread =
      thread(name = "relevo-signal", isDaemon = true) {
        var ending = Ending.COMPLETED
        var position = 0
        while (position < pcm.size) {
          if (!playing) { ending = Ending.STOPPED; break }
          if (!sameOutput(track.routedDevice, output)) { ending = Ending.ROUTE_LOST; break }
          val count = min(CHUNK, pcm.size - position)
          val written = track.write(pcm, position, count, AudioTrack.WRITE_BLOCKING)
          if (written < 0) { ending = Ending.ROUTE_LOST; break }
          position += written
        }
        // Deja sonar lo que queda en el búfer antes de cerrar.
        if (ending == Ending.COMPLETED) runCatching { Thread.sleep(250) }
        // Solo stop() apaga `playing`: si ocurrió, el sonido se detuvo por decisión de la persona.
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
    // El hilo del Tag ve `playing` apagado en una décima de segundo y apaga el pitido al salir.
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
    vibrator()?.cancel()
  }

  private fun vibrateOnce() {
    vibrator()?.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 220, 140, 220, 140, 500), -1))
  }

  /** Un parlante o unos audífonos Bluetooth. */
  private fun isBluetoothAudioOutput(device: AudioDeviceInfo): Boolean =
    device.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP || device.type == AudioDeviceInfo.TYPE_BLE_SPEAKER || device.type == AudioDeviceInfo.TYPE_BLE_HEADSET

  private fun vibrator() = context.getSystemService(VibratorManager::class.java)?.defaultVibrator

  private companion object {
    const val CHUNK = 2_048
    /** Hasta 30 s para conectar o para que un Tag lento responda antes de sonar (2.32). */
    const val TAG_CONNECT_MILLIS = 30_000L
    const val TAG_STEP_MILLIS = 100L
    const val TAG_MISSES = 3
  }
}
