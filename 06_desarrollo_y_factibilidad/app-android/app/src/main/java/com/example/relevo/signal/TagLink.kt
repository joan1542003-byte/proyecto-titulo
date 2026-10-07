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
 *   relevo y se mantiene, como hace iSearching.
 *
 * Todas las entradas revisan los permisos de Bluetooth antes de usar el adaptador.
 */
@SuppressLint("MissingPermission")
object TagLink {
  enum class Phase { IDLE, CONNECTING, CONNECTED }

  enum class Problem { NO_PERMISSION, BLUETOOTH_OFF, NOT_FOUND, NOT_A_TAG }

  /** [button]: el botón del llavero avisa al apretarlo. [linkLossOff]: se apagó su alarma por desconexión. */
  data class Status(
    val phase: Phase = Phase.IDLE,
    val problem: Problem? = null,
    val button: Boolean = false,
    val linkLossOff: Boolean = false,
  )

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
  @Volatile private var connectedAddress: String? = null
  @Volatile private var heldAddress: String? = null
  @Volatile private var pendingConnect: CompletableDeferred<Boolean>? = null
  @Volatile private var pendingDiscovery: CompletableDeferred<Boolean>? = null
  @Volatile private var pendingOperation: CompletableDeferred<Boolean>? = null
  @Volatile private var pendingRead: CompletableDeferred<ByteArray?>? = null

  /**
   * Resumen de la última conexión: servicios, características con sus propiedades y el nombre y valor de
   * FFE2. Sirve para saber cómo es un modelo sin tenerlo a mano; no incluye la dirección ni el nombre.
   */
  @Volatile var profile: String? = null
    private set
  @Volatile private var lastButtonAt = 0L
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
    holdJob = scope.launch {
      while (isActive) {
        val target = heldAddress ?: break
        if (!isConnectedTo(target)) connect(app, target)
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
    val switched = switch?.let { write(g, it, byteArrayOf(1)) }
    val alerted = write(g, alert, byteArrayOf(TagStore(context).alertLevel.toByte()))
    return switched ?: alerted
  }

  /** Calla el pitido: la alerta estándar en 0 y FFE2 en 0. */
  suspend fun alertOff(): Boolean {
    val g = gatt ?: return false
    val alerted = alertLevel?.let { write(g, it, byteArrayOf(TagProtocol.ALERT_OFF)) } == true
    val switched = switch?.let { write(g, it, byteArrayOf(0)) }
    return switched ?: alerted
  }

  /**
   * Cierra la conexión y la abre de nuevo. La señal la usa si el Tag no confirma la orden: una conexión
   * que se cortó sin aviso puede parecer abierta.
   */
  suspend fun reconnect(context: Context, address: String): Boolean =
    connection.withLock {
      closeGatt()
      connectLocked(context.applicationContext, address)
    }

  /** Un pitido de prueba de [millis], seguido: la orden se repite como en la señal. */
  suspend fun beep(context: Context, millis: Long): Boolean {
    if (!alertOn(context)) return false
    var left = millis
    while (left > 0) {
      val step = minOf(TagProtocol.REPEAT_MILLIS, left)
      delay(step)
      left -= step
      if (left > 0) alertOn(context)
    }
    alertOff()
    return true
  }

  /** Termina el relevo: deja de mantener la conexión, apaga el pitido y desconecta. */
  fun release() {
    heldAddress = null
    holdJob?.cancel()
    holdJob = null
    scope.launch { disconnect() }
  }

  /** Después de una prueba: desconecta solo si ningún relevo está usando el llavero. */
  fun idle() {
    if (heldAddress != null) return
    scope.launch { disconnect() }
  }

  private suspend fun disconnect() {
    connection.withLock {
      if (heldAddress != null) return@withLock
      alertOff()
      closeGatt()
      publish(Status())
    }
  }

  private suspend fun connectLocked(app: Context, address: String): Boolean {
    if (isConnectedTo(address)) return true
    if (!hasPermissions(app)) return fail(Problem.NO_PERMISSION)
    val adapter = adapter(app)
    if (adapter == null || !adapter.isEnabled) return fail(Problem.BLUETOOTH_OFF)
    closeGatt()
    publish(Status(Phase.CONNECTING))
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
    if (withTimeoutOrNull(CONNECT_MILLIS) { connected.await() } != true) {
      closeGatt()
      return Problem.NOT_FOUND
    }
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
    val switchLabel = ffe2?.getDescriptor(TagProtocol.USER_DESCRIPTION)?.let { readDescriptor(g, it) }?.let(::label)
    val switchValue = ffe2?.takeIf { it.properties and BluetoothGattCharacteristic.PROPERTY_READ != 0 }?.let { read(g, it) }
    profile = describe(g, switchLabel, switchValue)
    // Mientras espera, el Tag queda en silencio y sin alarma por desconexión: FFE2 en 0 y la estándar en 0.
    val switchOff = ffe2?.let { write(g, it, byteArrayOf(0)) } == true
    val standardOff = g.getService(TagProtocol.LINK_LOSS_SERVICE)?.getCharacteristic(TagProtocol.ALERT_LEVEL)
      ?.let { write(g, it, byteArrayOf(TagProtocol.ALERT_OFF)) } == true
    val button = keys?.getCharacteristic(TagProtocol.BUTTON)?.let { enableNotifications(g, it) } == true
    publish(Status(Phase.CONNECTED, button = button, linkLossOff = switchOff || standardOff))
    return null
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

  private suspend fun write(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray): Boolean =
    operation.withLock {
      val noResponse = characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0
      val type = if (noResponse) BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE else BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
      val done = CompletableDeferred<Boolean>().also { pendingOperation = it }
      val started = runCatching {
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
      val ok = started && (withTimeoutOrNull(OPERATION_MILLIS) { done.await() } ?: noResponse)
      pendingOperation = null
      ok
    }

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
      pendingConnect?.complete(false)
      pendingDiscovery?.complete(false)
      pendingOperation?.complete(false)
      pendingRead?.complete(null)
      if (g == gatt) {
        gatt = null
        alertLevel = null
        switch = null
        connectedAddress = null
        publish(Status(if (heldAddress != null) Phase.CONNECTING else Phase.IDLE, problem = if (heldAddress != null) Problem.NOT_FOUND else null))
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
      pendingOperation?.complete(status == BluetoothGatt.GATT_SUCCESS)
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
    connectedAddress = null
    runCatching { g.disconnect() }
    runCatching { g.close() }
  }

  private fun fail(problem: Problem): Boolean {
    publish(Status(if (heldAddress != null) Phase.CONNECTING else Phase.IDLE, problem = problem))
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
  private const val OPERATION_MILLIS = 1_500L
  private const val RETRY_PAUSE_MILLIS = 1_000L
  private const val CONNECT_ATTEMPTS = 2
  /** Android admite pocas búsquedas seguidas: cada intento hace hasta dos, cada 30 s. */
  private const val HOLD_RETRY_MILLIS = 30_000L
  private const val BUTTON_DEBOUNCE_MILLIS = 500L
}
