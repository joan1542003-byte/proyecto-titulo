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
 * - si una orden queda sin respuesta, Android no acepta otra en esa conexión. Desde 2.31 la conexión se
 *   marca como dudosa y, para callar el Tag, se abre de nuevo (D-134). Antes, la orden de apagar podía
 *   fallar sin aviso: el Tag seguía pitando y, al desconectarse, sonaba su alarma por desconexión.
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
  @Volatile private var connectedAddress: String? = null
  @Volatile private var heldAddress: String? = null
  @Volatile private var pendingConnect: CompletableDeferred<Boolean>? = null
  @Volatile private var pendingDiscovery: CompletableDeferred<Boolean>? = null
  @Volatile private var pendingOperation: CompletableDeferred<Boolean>? = null
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
        if (!isConnectedTo(target) || unreliable) connect(app, target)
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

  /**
   * Calla el pitido en la conexión abierta: FFE2, la alerta estándar y la alarma por desconexión en 0, cada
   * una con hasta tres intentos (2.31). Devuelve true solo si el Tag confirmó las tres que tenga.
   */
  suspend fun alertOff(): Boolean {
    val g = gatt ?: return false
    if (unreliable) return false
    return silence(g).all
  }

  /**
   * Se asegura de que el Tag quede callado y sin alarma por desconexión. Prueba en la conexión abierta y, si
   * no resulta, la abre de nuevo, porque al conectar se apagan las tres (2.31). Si ningún relevo usa el
   * llavero, después desconecta. Puede tardar hasta unos 45 s.
   */
  suspend fun quiet(context: Context): Off {
    val app = context.applicationContext
    return connection.withLock {
      val address = connectedAddress ?: heldAddress ?: TagStore(app).address
      val off = when {
        alertOff() -> Off.QUIET
        address != null && withTimeoutOrNull(QUIET_MILLIS) { hangUp(); connectLocked(app, address) && alertOff() } == true -> Off.RECONNECTED
        else -> Off.FAILED
      }
      if (heldAddress == null) {
        hangUp()
        publish(Status(battery = _status.value.battery))
      }
      off
    }
  }

  /** [quiet] sin esperar, para quien no puede detenerse, como el hilo que hace pitar la señal. */
  fun quietInBackground(context: Context) {
    val app = context.applicationContext
    scope.launch { quiet(app) }
  }

  /**
   * Cierra la conexión y la abre de nuevo. La señal la usa si el Tag no confirma la orden: una conexión
   * que se cortó sin aviso puede parecer abierta.
   */
  suspend fun reconnect(context: Context, address: String): Boolean =
    connection.withLock {
      hangUp()
      connectLocked(context.applicationContext, address)
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
    lastOff = if (alertOff()) Off.QUIET else quiet(context)
    return on
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

  /**
   * Desconecta solo después de callar el Tag: si la orden no se confirma, la conexión se abre de nuevo para
   * callarlo. Después espera a que Android cierre de verdad, porque cerrar sin esperar puede dejar la
   * conexión abierta a medias, y el Tag suena cuando por fin se corta (2.31).
   */
  private suspend fun disconnect() {
    connection.withLock {
      if (heldAddress != null) return@withLock
      val address = connectedAddress
      val app = appContext
      if (gatt != null && !alertOff() && address != null && app != null) {
        withTimeoutOrNull(QUIET_MILLIS) { hangUp(); connectLocked(app, address) && alertOff() }
      }
      hangUp()
      publish(Status(battery = _status.value.battery))
    }
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
    if (isConnectedTo(address) && !unreliable) return true
    if (!hasPermissions(app)) return fail(Problem.NO_PERMISSION)
    val adapter = adapter(app)
    if (adapter == null || !adapter.isEnabled) return fail(Problem.BLUETOOTH_OFF)
    hangUp()
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
    val standard = g.getService(TagProtocol.LINK_LOSS_SERVICE)?.getCharacteristic(TagProtocol.ALERT_LEVEL)
    linkLoss = standard
    profile = describe(g, switchLabel, switchValue)
    // Mientras espera, el Tag queda en silencio y sin alarma por desconexión. Desde 2.31 también se apaga la
    // alerta estándar: un Tag que quedó pitando desde una conexión anterior se calla al volver a conectarse.
    val off = silence(g)
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
  }

  /**
   * FFE2, la alerta estándar y la alarma por desconexión en 0, con confirmación cuando el Tag la ofrece y
   * hasta tres intentos cada una. FFE2 va primero: en algunos modelos es lo que hace pitar.
   */
  private suspend fun silence(g: BluetoothGatt): Silence {
    suspend fun off(characteristic: BluetoothGattCharacteristic?): Boolean {
      characteristic ?: return true
      repeat(OFF_ATTEMPTS) { if (write(g, characteristic, byteArrayOf(TagProtocol.ALERT_OFF), confirm = true)) return true }
      return false
    }
    return Silence(switchOff = off(switch), alertOff = off(alertLevel), linkLossOff = off(linkLoss))
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
  private suspend fun write(g: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray, confirm: Boolean = false): Boolean =
    operation.withLock {
      val canConfirm = characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE != 0
      val noResponse = characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0 && !(confirm && canConfirm)
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
      val answer = if (started) withTimeoutOrNull(OPERATION_MILLIS) { done.await() } else null
      // Sin respuesta a una escritura que la pide, o con Android ocupado, la conexión queda dudosa.
      if (g == gatt && (!started || (answer == null && !noResponse))) unreliable = true
      pendingOperation = null
      started && (answer ?: noResponse)
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
  private const val OPERATION_MILLIS = 1_500L
  private const val OFF_ATTEMPTS = 3
  private const val DISCONNECT_MILLIS = 2_000L
  /** Lo más que se espera para callar el Tag abriendo otra conexión: dos intentos de conexión completos. */
  private const val QUIET_MILLIS = 45_000L
  private const val RETRY_PAUSE_MILLIS = 1_000L
  private const val CONNECT_ATTEMPTS = 2
  /** Android admite pocas búsquedas seguidas: cada intento hace hasta dos, cada 30 s. */
  private const val HOLD_RETRY_MILLIS = 30_000L
  private const val BUTTON_DEBOUNCE_MILLIS = 500L
}
