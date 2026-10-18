package com.example.relevo.signal

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.BluetoothStatusCodes
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.example.relevo.data.TagStore
import com.example.relevo.domain.TagProtocol
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
import java.util.UUID

/**
 * Conexión con el llavero iTag (D-109). Hay una sola por app: la usan el servicio que cuenta, que la
 * mantiene abierta mientras un relevo espera para sonar, y la pantalla de preparar, que vincula y prueba.
 *
 * Cómo funciona el llavero, verificado en código abierto y en el manual de iSearching:
 * - pita al escribir en la característica estándar «Nivel de alerta» (2 enciende, 0 apaga);
 * - FFE2 cambia según el modelo: en unos apaga la alarma por desconexión, en el del autor hace pitar.
 *   Relevo lo deja en 0 mientras espera y lo pone en 1, junto con la alerta estándar, solo mientras suena;
 * - avisa cada vez que se aprieta su botón (FFE1): durante la señal, eso la silencia;
 * - algunos se apagan si nadie se conecta en unos minutos: por eso la conexión se abre al activar el
 *   relevo y se mantiene, como hace iSearching;
 * - si una orden queda sin respuesta, Android no acepta otra en esa conexión. Desde 2.31 la orden de callar
 *   se confirma (D-136). Antes, la orden de apagar podía fallar sin aviso: el Tag seguía pitando y, al
 *   desconectarse, sonaba su alarma por desconexión;
 * - después de mucho rato sin uso, el Tag responde lento. Desde 2.32 la app pide una conexión rápida, espera
 *   hasta 6 s cada respuesta y nunca corta una conexión mientras la alarma por desconexión pueda estar
 *   encendida: cortarla es justo lo que la hace sonar («tutututu») hasta reiniciar el Tag (D-137).
 *
 * Todas las entradas revisan los permisos de Bluetooth antes de usar el adaptador.
 */
@SuppressLint("MissingPermission")
object TagLink {
  enum class Phase { IDLE, CONNECTING, CONNECTED }

  enum class Problem { NO_PERMISSION, BLUETOOTH_OFF, NOT_FOUND, NOT_A_TAG }

  /**
   * [button]: el botón del llavero avisa al apretarlo. [linkLossOff]: se apagó su alarma por desconexión.
   * [battery]: la carga de su pila en porcentaje, si el Tag la informa (2.31).
   */
  data class Status(
    val phase: Phase = Phase.IDLE,
    val problem: Problem? = null,
    val button: Boolean = false,
    val linkLossOff: Boolean = false,
    val battery: Int? = null,
  )

  /** Cómo quedó el Tag al pedirle callar: confirmado, después de abrir otra conexión, o sin confirmar. */
  enum class Off { QUIET, RECONNECTED, FAILED }

  /** Un llavero encontrado en la búsqueda. */
  data class Found(val address: String, val name: String, val rssi: Int)

  val requiredPermissions = arrayOf(Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT)

  private val _status = MutableStateFlow(Status())
  val status: StateFlow<Status> = _status.asStateFlow()

  /** Se llama, desde otro hilo, cada vez que se aprieta el botón del llavero conectado. */
  @Volatile var onButton: (() -> Unit)? = null

  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
  /** Una conexión o desconexión a la vez. */
  private val connection = Mutex()
  /** Una operación de Bluetooth a la vez: Android no acepta otra mientras una espera respuesta. */
  private val operation = Mutex()

  @Volatile private var gatt: BluetoothGatt? = null
  @Volatile private var alertLevel: BluetoothGattCharacteristic? = null
  @Volatile private var switch: BluetoothGattCharacteristic? = null
  /** «Nivel de alerta» del servicio «Pérdida de enlace» (0x1803): la alarma por desconexión estándar. */
  @Volatile private var linkLoss: BluetoothGattCharacteristic? = null
  /** Una orden quedó sin respuesta: Android puede no aceptar otra en esta conexión hasta abrirla de nuevo. */
  @Volatile private var unreliable = false
  /** Para volver a conectar al desconectar, cuando no hay otro contexto a mano. */
  @Volatile private var appContext: Context? = null
  /**
   * El Tag confirmó, en esta conexión, que su alarma por desconexión está apagada (FFE2 y la estándar en 0).
   * Solo así se puede desconectar sin que suene (2.32).
   */
  @Volatile private var alarmOff = false
  /** Cuándo se pidió por última vez una conexión rápida. */
  @Volatile private var boostedAt = 0L
  /** Desconexión diferida después de una prueba, o mientras se espera confirmar la alarma apagada. */
  private var lingerJob: Job? = null
  @Volatile private var connectedAddress: String? = null
  @Volatile private var heldAddress: String? = null
  @Volatile private var pendingConnect: CompletableDeferred<Boolean>? = null
  @Volatile private var pendingDiscovery: CompletableDeferred<Boolean>? = null
  @Volatile private var pendingOperation: CompletableDeferred<Boolean>? = null
  /** La característica que espera respuesta: una respuesta atrasada de otra orden no la confirma (2.32). */
  @Volatile private var pendingUuid: UUID? = null
  @Volatile private var pendingRead: CompletableDeferred<ByteArray?>? = null
  @Volatile private var pendingDisconnect: CompletableDeferred<Boolean>? = null

  /**
   * Resumen de la última conexión: servicios, características con sus propiedades y el nombre y valor de
   * FFE2. Sirve para saber cómo es un modelo sin tenerlo a mano; no incluye la dirección ni el nombre.
   */
  @Volatile var profile: String? = null
    private set
  @Volatile private var lastButtonAt = 0L

  /** Cómo terminó la última prueba al callar el Tag. Se registra con la prueba (2.31). */
  @Volatile var lastOff: Off = Off.QUIET
    private set

  /** La respuesta más lenta del Tag en esta conexión, en milisegundos. Se registra con la prueba (2.32). */
  @Volatile var slowestMillis = 0L
    private set

  /** La última conexión se abrió para esta orden (true) o ya estaba abierta (false). */
  @Volatile var freshConnection = false
    private set
  private var holdJob: Job? = null

  fun hasPermissions(context: Context): Boolean = requiredPermissions.all {
    ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
  }

  fun bluetoothOn(context: Context): Boolean = adapter(context)?.isEnabled == true

  fun isConnectedTo(address: String?): Boolean =
    address != null && gatt != null && alertLevel != null && connectedAddress.equals(address, ignoreCase = true)

  /**
   * Busca llaveros cerca durante [millis] y entrega cada uno al aparecer, con la fuerza de su señal
   * actualizada. Con [all], entrega todos los aparatos con nombre, por si un llavero se anuncia de otra
   * forma; al conectarse se comprueba que sepa pitar. Devuelve el problema que impidió buscar, o null.
   */
  suspend fun search(context: Context, millis: Long = SEARCH_MILLIS, all: Boolean = false, onFound: (Found) -> Unit): Problem? {
    val app = context.applicationContext
    if (!hasPermissions(app)) return Problem.NO_PERMISSION
    val adapter = adapter(app)
    if (adapter == null || !adapter.isEnabled) return Problem.BLUETOOTH_OFF
    val scanner = adapter.bluetoothLeScanner ?: return Problem.BLUETOOTH_OFF
    val callback = object : ScanCallback() {
      override fun onScanResult(callbackType: Int, result: ScanResult) {
        val record = result.scanRecord
        val name = record?.deviceName ?: runCatching { result.device.name }.getOrNull()
        val services = record?.serviceUuids.orEmpty().map { it.uuid }
        if (TagProtocol.looksLikeTag(name, services) || (all && !name.isNullOrBlank())) onFound(Found(result.device.address, name?.trim().orEmpty().ifBlank { "iTag" }, result.rssi))
      }

      override fun onBatchScanResults(results: MutableList<ScanResult>) { results.forEach { onScanResult(0, it) } }
    }
    val started = runCatching { scanner.startScan(null, lowLatency(), callback) }.isSuccess
    if (!started) return Problem.BLUETOOTH_OFF
    try { delay(millis) } finally { runCatching { scanner.stopScan(callback) } }
    return null
  }

  /** Se conecta al llavero de [address] y lo deja listo para pitar. Puede tardar hasta unos 30 s. */
  suspend fun connect(context: Context, address: String): Boolean =
    connection.withLock { connectLocked(context.applicationContext, address) }

  /** Mantiene la conexión mientras un relevo espera: si se corta, la vuelve a abrir cada 30 s. */
  fun hold(context: Context, address: String) {
    val app = context.applicationContext
    heldAddress = address
    if (holdJob?.isActive == true) return
    cancelLinger()
    holdJob = scope.launch {
      while (isActive) {
        val target = heldAddress ?: break
        if (!isConnectedTo(target)) {
          connect(app, target)
        } else if (!alarmOff || unreliable) {
          // Sin cortar la conexión: se insiste hasta que el Tag confirme que su alarma quedó apagada (2.32).
          connection.withLock { if (heldAddress != null) settleLocked(SETTLE_HOLD_MILLIS) }
        } else if (boostedAt != 0L && System.currentTimeMillis() - boostedAt > RELAX_AFTER_MILLIS) {
          relax()
        }
        delay(HOLD_RETRY_MILLIS)
      }
    }
  }

  /** Abre la conexión sin esperar, por ejemplo cuando una prueba se pide desde la pantalla. */
  fun connectInBackground(context: Context, address: String) {
    val app = context.applicationContext
    scope.launch { connect(app, address) }
  }

  /**
   * Enciende el pitido con el nivel que funcionó en la prueba de este Tag: FFE2 en 1 y la alerta estándar.
   * FFE2 se escribe con respuesta, así que confirma que el Tag la recibió; sin FFE2 cuenta la alerta, que
   * sin respuesta solo confirma que salió del teléfono.
   */
  suspend fun alertOn(context: Context): Boolean {
    val g = gatt ?: return false
    val alert = alertLevel ?: return false
    boost()
    // En algunos modelos FFE2 en 1 también enciende la alarma por desconexión: hasta callarlo, no se corta.
    if (switch != null) alarmOff = false
    val switched = switch?.let { write(g, it, byteArrayOf(1), timeout = ALERT_OPERATION_MILLIS) }
    val alerted = write(g, alert, byteArrayOf(TagStore(context).alertLevel.toByte()), timeout = ALERT_OPERATION_MILLIS)
    return switched ?: alerted
  }

  /**
   * Calla el pitido en la conexión abierta: FFE2, la alerta estándar y la alarma por desconexión en 0, cada
   * una con hasta tres intentos (2.31). Devuelve true solo si el Tag confirmó las tres que tenga.
   */
  suspend fun alertOff(): Boolean {
    val g = gatt ?: return false
    val off = silence(g)
    if (off.alarm) alarmOff = true
    if (off.all) unreliable = false
    return off.all
  }

  /**
   * Se asegura de que el Tag quede callado y sin alarma por desconexión. Insiste en la conexión abierta, sin
   * cortarla, porque cortarla con la alarma encendida es lo que la hace sonar (2.32). Solo si la conexión ya
   * se perdió, abre otra, que al conectar apaga las tres. Con [release], y si ningún relevo usa el llavero,
   * después desconecta, pero solo con la alarma confirmada apagada. Puede tardar hasta unos 45 s.
   */
  suspend fun quiet(context: Context, release: Boolean = true): Off {
    val app = context.applicationContext
    return connection.withLock {
      val address = connectedAddress ?: heldAddress ?: TagStore(app).address
      val off = when {
        gatt != null && settleLocked(SETTLE_MILLIS_QUIET) -> Off.QUIET
        gatt == null && address != null &&
          withTimeoutOrNull(QUIET_MILLIS) { connectLocked(app, address) && settleLocked(SETTLE_MILLIS_QUIET) } == true -> Off.RECONNECTED
        else -> Off.FAILED
      }
      if (release && heldAddress == null) releaseLocked()
      off
    }
  }

  /** [quiet] sin esperar, para quien no puede detenerse, como el hilo que hace pitar la señal. */
  fun quietInBackground(context: Context) {
    val app = context.applicationContext
    scope.launch { quiet(app) }
  }

  /**
   * La señal lo usa si el Tag no confirma la orden. Con la conexión abierta, insiste en ella hasta que el
   * Tag responda; solo si se perdió, abre otra. Desde 2.32 ya no la corta para abrirla de nuevo.
   */
  suspend fun reconnect(context: Context, address: String): Boolean =
    connection.withLock {
      boost()
      if (isConnectedTo(address)) settleLocked(SETTLE_MILLIS_QUIET) else connectLocked(context.applicationContext, address)
    }

  /**
   * Un pitido de prueba de [millis], seguido: la orden se repite como en la señal. Al terminar, el Tag se
   * calla con [quiet] aunque la orden de encender haya fallado: pudo llegar al Tag sin confirmarse (2.31).
   */
  suspend fun beep(context: Context, millis: Long): Boolean {
    val on = alertOn(context)
    if (on) {
      var left = millis
      while (left > 0) {
        val step = minOf(TagProtocol.REPEAT_MILLIS, left)
        delay(step)
        left -= step
        if (left > 0) alertOn(context)
      }
    }
    lastOff = if (alertOff()) Off.QUIET else quiet(context, release = false)
    return on
  }

  /** Termina el relevo: deja de mantener la conexión, apaga el pitido y desconecta. */
  fun release() {
    heldAddress = null
    holdJob?.cancel()
    holdJob = null
    scope.launch { disconnect() }
  }

  /**
   * Después de una prueba: desconecta en 90 s si ningún relevo usa el llavero. Así, probar de nuevo no abre
   * otra conexión, y cada conexión nueva es un riesgo con un Tag que responde lento (2.32).
   */
  fun idle() {
    if (heldAddress != null) return
    cancelLinger()
    lingerJob = scope.launch {
      delay(IDLE_LINGER_MILLIS)
      disconnect()
    }
  }

  private fun cancelLinger() {
    lingerJob?.cancel()
    lingerJob = null
  }

  /** Desconecta solo después de callar el Tag y de confirmar que su alarma por desconexión quedó apagada. */
  private suspend fun disconnect() {
    connection.withLock {
      if (heldAddress != null) return@withLock
      if (gatt != null && !alarmOff) settleLocked(SETTLE_MILLIS_QUIET)
      releaseLocked()
    }
  }

  /**
   * Libera la conexión si la alarma por desconexión está confirmada apagada. Si no, la mantiene y vuelve a
   * intentar cada 15 s durante 10 minutos: es mejor gastar un poco de pila que dejar al Tag sonando. Si en
   * 10 minutos nunca lo confirma, desconecta igual (2.32).
   */
  private suspend fun releaseLocked() {
    val g = gatt
    if (g == null || alarmOff) {
      hangUp()
      publish(Status(battery = _status.value.battery))
      return
    }
    cancelLinger()
    lingerJob = scope.launch {
      val until = System.currentTimeMillis() + LINGER_MAX_MILLIS
      while (isActive && System.currentTimeMillis() < until) {
        delay(LINGER_RETRY_MILLIS)
        val done = connection.withLock {
          when {
            heldAddress != null -> true
            gatt == null -> { publish(Status(battery = _status.value.battery)); true }
            settleLocked(SETTLE_HOLD_MILLIS) -> { hangUp(); publish(Status(battery = _status.value.battery)); true }
            else -> false
          }
        }
        if (done) return@launch
      }
      connection.withLock {
        if (heldAddress == null) {
          hangUp()
          publish(Status(battery = _status.value.battery))
        }
      }
    }
  }

  /**
   * Insiste en la conexión abierta, sin cortarla, hasta que el Tag confirme que está callado y con su alarma
   * por desconexión apagada, o hasta [millis]. Devuelve true si lo confirmó.
   */
  private suspend fun settleLocked(millis: Long): Boolean {
    val until = System.currentTimeMillis() + millis
    boost()
    while (true) {
      val g = gatt ?: return false
      val off = withTimeoutOrNull(maxOf(1L, until - System.currentTimeMillis())) { silence(g) } ?: return false
      if (off.alarm) alarmOff = true
      if (off.all) {
        unreliable = false
        val current = _status.value
        if (current.phase == Phase.CONNECTED && !current.linkLossOff) publish(current.copy(linkLossOff = true))
        return true
      }
      if (System.currentTimeMillis() + SETTLE_PAUSE_MILLIS >= until) return false
      delay(SETTLE_PAUSE_MILLIS)
    }
  }

  /** Pide una conexión rápida: un Tag que pasó mucho rato quieto responde con más demora (2.32). */
  private suspend fun boost() {
    val g = gatt ?: return
    if (System.currentTimeMillis() - boostedAt < BOOST_VALID_MILLIS) return
    if (runCatching { g.requestConnectionPriority(BluetoothGatt.CONNECTION_PRIORITY_HIGH) }.getOrDefault(false)) {
      boostedAt = System.currentTimeMillis()
      delay(BOOST_SETTLE_MILLIS)
    }
  }

  /** Vuelve a una conexión normal mientras el relevo espera, para no gastar la pila del Tag. */
  private fun relax() {
    val g = gatt ?: return
    runCatching { g.requestConnectionPriority(BluetoothGatt.CONNECTION_PRIORITY_BALANCED) }
    boostedAt = 0L
  }

  /** Pide desconectar y espera hasta 2 s a que Android lo confirme; después libera la conexión. */
  private suspend fun hangUp() {
    val g = gatt ?: return
    val gone = CompletableDeferred<Boolean>().also { pendingDisconnect = it }
    runCatching { g.disconnect() }
    withTimeoutOrNull(DISCONNECT_MILLIS) { gone.await() }
    pendingDisconnect = null
    closeGatt()
  }

  private suspend fun connectLocked(app: Context, address: String): Boolean {
    appContext = app
    cancelLinger()
    // Una conexión abierta con este Tag no se corta, aunque responda lento: cortarla puede hacerlo sonar (2.32).
    if (isConnectedTo(address)) {
      freshConnection = false
      return true
    }
    if (!hasPermissions(app)) return fail(Problem.NO_PERMISSION)
    val adapter = adapter(app)
    if (adapter == null || !adapter.isEnabled) return fail(Problem.BLUETOOTH_OFF)
    hangUp()
    freshConnection = true
    publish(Status(Phase.CONNECTING, battery = _status.value.battery))
    // El primer intento falla a veces con el error 133 de Android; un segundo intento suele bastar.
    repeat(CONNECT_ATTEMPTS) { attempt ->
      when (val result = openLocked(app, adapter, address)) {
        null -> return true
        Problem.NOT_A_TAG -> return fail(result)
        else -> if (attempt == CONNECT_ATTEMPTS - 1) return fail(result) else delay(RETRY_PAUSE_MILLIS)
      }
    }
    return fail(Problem.NOT_FOUND)
  }

  /** Un intento de conexión. Devuelve null si quedó listo para pitar, o el problema. */
  private suspend fun openLocked(app: Context, adapter: BluetoothAdapter, address: String): Problem? {
    val device = findDevice(adapter, address) ?: return Problem.NOT_FOUND
    val connected = CompletableDeferred<Boolean>().also { pendingConnect = it }
    val g = runCatching { device.connectGatt(app, false, callback, BluetoothDevice.TRANSPORT_LE) }.getOrNull()
      ?: return Problem.NOT_FOUND
    gatt = g
    unreliable = false
    alarmOff = false
    slowestMillis = 0L
    boostedAt = 0L
    if (withTimeoutOrNull(CONNECT_MILLIS) { connected.await() } != true) {
      closeGatt()
      return Problem.NOT_FOUND
    }
    // Conexión rápida desde el principio: un Tag dormido responde mucho más lento (2.32).
    if (runCatching { g.requestConnectionPriority(BluetoothGatt.CONNECTION_PRIORITY_HIGH) }.getOrDefault(false)) boostedAt = System.currentTimeMillis()
    // Pedir los servicios justo al conectar falla en algunos teléfonos: se espera un momento.
    delay(SETTLE_MILLIS)
    val discovered = CompletableDeferred<Boolean>().also { pendingDiscovery = it }
    if (!g.discoverServices() || withTimeoutOrNull(DISCOVERY_MILLIS) { discovered.await() } != true) {
      closeGatt()
      return Problem.NOT_FOUND
    }
    val alert = g.getService(TagProtocol.IMMEDIATE_ALERT_SERVICE)?.getCharacteristic(TagProtocol.ALERT_LEVEL)
    if (alert == null) {
      closeGatt()
      return Problem.NOT_A_TAG
    }
    alertLevel = alert
    connectedAddress = address
    val keys = g.getService(TagProtocol.KEY_SERVICE)
    val ffe2 = keys?.getCharacteristic(TagProtocol.LINK_LOSS_SWITCH)?.takeIf {
      it.properties and (BluetoothGattCharacteristic.PROPERTY_WRITE or BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE) != 0
    }
    switch = ffe2
    val standard = g.getService(TagProtocol.LINK_LOSS_SERVICE)?.getCharacteristic(TagProtocol.ALERT_LEVEL)
    linkLoss = standard
    // Lo primero es dejar al Tag en silencio y sin alarma por desconexión, antes de cualquier otra orden.
    // También se apaga la alerta estándar: un Tag que quedó pitando se calla al volver a conectarse (2.31).
    // Si responde lento, se insiste sin cortar la conexión (2.32).
    var off = silence(g)
    if (off.alarm) alarmOff = true
    if (!off.all && settleLocked(SETTLE_CONNECT_MILLIS)) off = Silence(switchOff = true, alertOff = true, linkLossOff = true)
    val switchLabel = ffe2?.getDescriptor(TagProtocol.USER_DESCRIPTION)?.let { readDescriptor(g, it) }?.let(::label)
    val switchValue = ffe2?.takeIf { it.properties and BluetoothGattCharacteristic.PROPERTY_READ != 0 }?.let { read(g, it) }
    profile = describe(g, switchLabel, switchValue)
    val button = keys?.getCharacteristic(TagProtocol.BUTTON)?.let { enableNotifications(g, it) } == true
    val battery = readBattery(g)
    battery?.let { TagStore(app).saveBattery(it) }
    val linkLossOff = (ffe2 != null && off.switchOff) || (standard != null && off.linkLossOff)
    publish(Status(Phase.CONNECTED, button = button, linkLossOff = linkLossOff, battery = battery))
    return null
  }

  /** Qué confirmó el Tag al callarlo. Lo que el Tag no tiene cuenta como confirmado. */
  private data class Silence(val switchOff: Boolean, val alertOff: Boolean, val linkLossOff: Boolean) {
    val all: Boolean get() = switchOff && alertOff && linkLossOff
    /** La alarma por desconexión quedó apagada: se puede desconectar sin que suene. */
    val alarm: Boolean get() = switchOff && linkLossOff
  }

  /**
   * FFE2, la alarma por desconexión y la alerta estándar en 0, con confirmación cuando el Tag la ofrece y
   * hasta dos intentos cada una. Las dos de la alarma van primero (2.32).
   */
  private suspend fun silence(g: BluetoothGatt): Silence {
    suspend fun off(characteristic: BluetoothGattCharacteristic?): Boolean {
      characteristic ?: return true
      repeat(OFF_ATTEMPTS) { if (write(g, characteristic, byteArrayOf(TagProtocol.ALERT_OFF), confirm = true)) return true }
      return false
    }
    val switchOff = off(switch)
    val linkLossOff = off(linkLoss)
    return Silence(switchOff = switchOff, alertOff = off(alertLevel), linkLossOff = linkLossOff)
  }

  /** La carga de la pila (servicio estándar 0x180F, característica 0x2A19), de 0 a 100, o null. */
  private suspend fun readBattery(g: BluetoothGatt): Int? {
    val level = g.getService(TagProtocol.BATTERY_SERVICE)?.getCharacteristic(TagProtocol.BATTERY_LEVEL) ?: return null
    if (level.properties and BluetoothGattCharacteristic.PROPERTY_READ == 0) return null
    return read(g, level)?.firstOrNull()?.toInt()?.and(0xFF)?.takeIf { it in 0..100 }
  }

  /** Servicios y características con sus propiedades en hexadecimal, más el nombre y valor de FFE2. */
  private fun describe(g: BluetoothGatt, switchLabel: String?, switchValue: ByteArray?): String {
    val services = g.services.joinToString(";") { service ->
      short(service.uuid) + ":" + service.characteristics.joinToString(",") { short(it.uuid) + "=" + "%02x".format(it.properties) }
    }
    val value = switchValue?.joinToString("") { "%02x".format(it) }
    return services + (switchLabel?.let { ";ffe2_nombre=" + it } ?: "") + (value?.let { ";ffe2_valor=" + it } ?: "")
  }

  /** Los UUID estándar se acortan a sus 4 cifras; los demás, a las primeras 8. */
  private fun short(uuid: UUID): String {
    val text = uuid.toString()
    return if (text.startsWith("0000") && text.endsWith("-0000-1000-8000-00805f9b34fb")) text.substring(4, 8) else text.substring(0, 8)
  }

  /** El nombre que entrega el Tag, limpio: solo letras, números y espacios, hasta 32 caracteres. */
  private fun label(bytes: ByteArray): String? =
    String(bytes, Charsets.UTF_8).filter { it.isLetterOrDigit() || it == ' ' }.trim().take(32).ifBlank { null }

  /**
   * Encuentra el llavero guardado. Buscarlo antes de conectar le dice a Android qué tipo de dirección
   * usa; sin eso, la conexión directa falla con muchos llaveros. Primero busca con filtro (funciona con
   * la pantalla apagada) y después sin filtro; si no aparece, intenta la conexión directa.
   */
  private suspend fun findDevice(adapter: BluetoothAdapter, address: String): BluetoothDevice? {
    val scanner = adapter.bluetoothLeScanner ?: return null
    val found = CompletableDeferred<BluetoothDevice>()
    val callback = object : ScanCallback() {
      override fun onScanResult(callbackType: Int, result: ScanResult) {
        if (result.device.address.equals(address, ignoreCase = true)) found.complete(result.device)
      }

      override fun onBatchScanResults(results: MutableList<ScanResult>) { results.forEach { onScanResult(0, it) } }
    }
    val filters = listOf(ScanFilter.Builder().setDeviceAddress(address.uppercase()).build())
    for ((scanFilters, millis) in listOf(filters to FILTERED_SCAN_MILLIS, null to OPEN_SCAN_MILLIS)) {
      if (runCatching { scanner.startScan(scanFilters, lowLatency(), callback) }.isFailure) continue
      val device = withTimeoutOrNull(millis) { found.await() }
      runCatching { scanner.stopScan(callback) }
      if (device != null) return device
    }
    return runCatching { adapter.getRemoteDevice(address.uppercase()) }.getOrNull()
  }

  /**
   * Escribe en el Tag. Con [confirm], usa la escritura con respuesta si el Tag la ofrece, para saber que la
   * recibió. Si la respuesta no llega, la conexión queda marcada como dudosa (2.31).
   */
  private suspend fun write(
    g: BluetoothGatt,
    characteristic: BluetoothGattCharacteristic,
    value: ByteArray,
    confirm: Boolean = false,
    timeout: Long = OPERATION_MILLIS,
  ): Boolean =
    operation.withLock {
      val canConfirm = characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE != 0
      val noResponse = characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0 && !(confirm && canConfirm)
      val type = if (noResponse) BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE else BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
      val done = CompletableDeferred<Boolean>().also { pendingOperation = it }
      pendingUuid = characteristic.uuid
      val startedAt = System.currentTimeMillis()
      // Si Android sigue ocupado con una orden anterior, se espera un poco y se intenta de nuevo (2.32).
      var started = false
      for (attempt in 0 until BUSY_ATTEMPTS) {
        if (g != gatt) break
        started = startWrite(g, characteristic, value, type)
        if (started) break
        delay(BUSY_PAUSE_MILLIS)
      }
      val answer = try {
        if (started) withTimeoutOrNull(timeout) { done.await() } else null
      } finally {
        pendingOperation = null
        pendingUuid = null
      }
      if (started && answer != null && g == gatt) slowestMillis = maxOf(slowestMillis, System.currentTimeMillis() - startedAt)
      // Sin respuesta a una escritura que la pide, o con Android ocupado, la conexión queda dudosa.
      if (g == gatt && (!started || (answer == null && !noResponse))) unreliable = true
      started && (answer ?: noResponse)
    }

  private fun startWrite(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray, type: Int): Boolean =
    runCatching {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        g.writeCharacteristic(characteristic, value, type) == BluetoothStatusCodes.SUCCESS
      } else {
        @Suppress("DEPRECATION")
        characteristic.writeType = type
        @Suppress("DEPRECATION")
        characteristic.value = value
        @Suppress("DEPRECATION")
        g.writeCharacteristic(characteristic)
      }
    }.getOrDefault(false)

  private suspend fun read(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic): ByteArray? =
    operation.withLock {
      val done = CompletableDeferred<ByteArray?>().also { pendingRead = it }
      val started = runCatching { g.readCharacteristic(characteristic) }.getOrDefault(false)
      val value = if (started) withTimeoutOrNull(OPERATION_MILLIS) { done.await() } else null
      pendingRead = null
      value
    }

  private suspend fun readDescriptor(g: BluetoothGatt, descriptor: BluetoothGattDescriptor): ByteArray? =
    operation.withLock {
      val done = CompletableDeferred<ByteArray?>().also { pendingRead = it }
      val started = runCatching { g.readDescriptor(descriptor) }.getOrDefault(false)
      val value = if (started) withTimeoutOrNull(OPERATION_MILLIS) { done.await() } else null
      pendingRead = null
      value
    }

  private suspend fun enableNotifications(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic): Boolean =
    operation.withLock {
      if (!runCatching { g.setCharacteristicNotification(characteristic, true) }.getOrDefault(false)) return@withLock false
      // Algunos llaveros avisan sin este descriptor; si lo tienen, hay que encenderlo.
      val descriptor = characteristic.getDescriptor(TagProtocol.CLIENT_CONFIG) ?: return@withLock true
      val done = CompletableDeferred<Boolean>().also { pendingOperation = it }
      val started = runCatching {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
          g.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) == BluetoothStatusCodes.SUCCESS
        } else {
          @Suppress("DEPRECATION")
          descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
          @Suppress("DEPRECATION")
          g.writeDescriptor(descriptor)
        }
      }.getOrDefault(false)
      val ok = started && withTimeoutOrNull(OPERATION_MILLIS) { done.await() } == true
      pendingOperation = null
      ok
    }

  private val callback = object : BluetoothGattCallback() {
    override fun onConnectionStateChange(g: BluetoothGatt, status: Int, newState: Int) {
      if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
        pendingConnect?.complete(true)
        return
      }
      if (newState != BluetoothProfile.STATE_DISCONNECTED && status == BluetoothGatt.GATT_SUCCESS) return
      pendingDisconnect?.complete(true)
      pendingConnect?.complete(false)
      pendingDiscovery?.complete(false)
      pendingOperation?.complete(false)
      pendingRead?.complete(null)
      if (g == gatt) {
        gatt = null
        alertLevel = null
        switch = null
        linkLoss = null
        connectedAddress = null
        publish(Status(if (heldAddress != null) Phase.CONNECTING else Phase.IDLE, problem = if (heldAddress != null) Problem.NOT_FOUND else null, battery = _status.value.battery))
      }
      runCatching { g.close() }
    }

    override fun onServicesDiscovered(g: BluetoothGatt, status: Int) {
      pendingDiscovery?.complete(status == BluetoothGatt.GATT_SUCCESS)
    }

    override fun onCharacteristicRead(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray, status: Int) {
      pendingRead?.complete(if (status == BluetoothGatt.GATT_SUCCESS) value else null)
    }

    override fun onDescriptorRead(g: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int, value: ByteArray) {
      pendingRead?.complete(if (status == BluetoothGatt.GATT_SUCCESS) value else null)
    }

    // Android 12 llama a estas dos versiones; desde Android 13, a las de arriba.
    @Deprecated("Solo para Android 12")
    override fun onCharacteristicRead(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
      @Suppress("DEPRECATION")
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) pendingRead?.complete(if (status == BluetoothGatt.GATT_SUCCESS) characteristic.value else null)
    }

    @Deprecated("Solo para Android 12")
    override fun onDescriptorRead(g: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
      @Suppress("DEPRECATION")
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) pendingRead?.complete(if (status == BluetoothGatt.GATT_SUCCESS) descriptor.value else null)
    }

    override fun onCharacteristicWrite(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
      if (g == gatt && characteristic.uuid == pendingUuid) pendingOperation?.complete(status == BluetoothGatt.GATT_SUCCESS)
    }

    override fun onDescriptorWrite(g: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
      pendingOperation?.complete(status == BluetoothGatt.GATT_SUCCESS)
    }

    override fun onCharacteristicChanged(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray) {
      if (characteristic.uuid == TagProtocol.BUTTON) pressed()
    }

    // Android 12 llama a esta versión; desde Android 13 llama a la de arriba.
    @Deprecated("Solo para Android 12")
    override fun onCharacteristicChanged(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && characteristic.uuid == TagProtocol.BUTTON) pressed()
    }
  }

  /** Un toque produce a veces dos avisos seguidos: cuenta uno cada medio segundo. */
  private fun pressed() {
    val now = System.currentTimeMillis()
    if (now - lastButtonAt < BUTTON_DEBOUNCE_MILLIS) return
    lastButtonAt = now
    onButton?.invoke()
  }

  private fun closeGatt() {
    val g = gatt ?: return
    gatt = null
    alertLevel = null
    switch = null
    linkLoss = null
    connectedAddress = null
    runCatching { g.disconnect() }
    runCatching { g.close() }
  }

  private fun fail(problem: Problem): Boolean {
    publish(Status(if (heldAddress != null) Phase.CONNECTING else Phase.IDLE, problem = problem, battery = _status.value.battery))
    return false
  }

  private fun publish(status: Status) { _status.value = status }

  private fun adapter(context: Context): BluetoothAdapter? = context.getSystemService(BluetoothManager::class.java)?.adapter

  private fun lowLatency(): ScanSettings = ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build()

  private const val SEARCH_MILLIS = 12_000L
  private const val FILTERED_SCAN_MILLIS = 6_000L
  private const val OPEN_SCAN_MILLIS = 6_000L
  private const val CONNECT_MILLIS = 12_000L
  private const val SETTLE_MILLIS = 600L
  private const val DISCOVERY_MILLIS = 10_000L
  /** Cuánto se espera la respuesta del Tag a una orden: un Tag que pasó mucho rato quieto tarda más (2.32). */
  private const val OPERATION_MILLIS = 6_000L
  /** Para las órdenes que se repiten cada segundo mientras suena, se espera menos. */
  private const val ALERT_OPERATION_MILLIS = 3_000L
  private const val OFF_ATTEMPTS = 2
  private const val BUSY_ATTEMPTS = 4
  private const val BUSY_PAUSE_MILLIS = 400L
  private const val DISCONNECT_MILLIS = 2_000L
  /** Lo más que se espera para callar el Tag abriendo otra conexión: dos intentos de conexión completos. */
  private const val QUIET_MILLIS = 45_000L
  private const val SETTLE_MILLIS_QUIET = 25_000L
  private const val SETTLE_CONNECT_MILLIS = 15_000L
  private const val SETTLE_HOLD_MILLIS = 12_000L
  private const val SETTLE_PAUSE_MILLIS = 1_000L
  private const val BOOST_VALID_MILLIS = 20_000L
  private const val BOOST_SETTLE_MILLIS = 300L
  private const val RELAX_AFTER_MILLIS = 60_000L
  private const val IDLE_LINGER_MILLIS = 90_000L
  private const val LINGER_RETRY_MILLIS = 15_000L
  private const val LINGER_MAX_MILLIS = 10 * 60_000L
  private const val RETRY_PAUSE_MILLIS = 1_000L
  private const val CONNECT_ATTEMPTS = 2
  /** Android admite pocas búsquedas seguidas: cada intento hace hasta dos, cada 30 s. */
  private const val HOLD_RETRY_MILLIS = 30_000L
  private const val BUTTON_DEBOUNCE_MILLIS = 500L
}
