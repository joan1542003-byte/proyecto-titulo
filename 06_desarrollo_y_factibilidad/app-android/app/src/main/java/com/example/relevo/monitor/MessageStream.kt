package com.example.relevo.monitor

import android.content.Context
import com.example.relevo.data.RemoteSync
import com.example.relevo.data.ResearchLogStore
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

/**
 * Mensajes del proyecto al instante (D-096). Mientras Relevo cuenta o espera para activarse solo, el
 * servicio mantiene abierta una conexión Realtime de Supabase. Cuando el panel inserta un mensaje, la
 * base avisa por esa conexión y la app lo busca y lo muestra en uno o dos segundos. Realtime respeta
 * las reglas de la tabla: cada teléfono solo recibe avisos de los mensajes generales y los suyos.
 * Si la conexión cae, se reintenta; la revisión periódica sigue como respaldo.
 */
class MessageStream(private val context: Context, private val scope: CoroutineScope) {
  private val client = OkHttpClient.Builder().readTimeout(0, TimeUnit.MILLISECONDS).build()
  private var job: Job? = null
  @Volatile private var socket: WebSocket? = null
  private var ref = 0

  fun start() {
    if (job?.isActive == true) return
    job = scope.launch(Dispatchers.IO) { run() }
  }

  fun stop() {
    job?.cancel()
    job = null
    socket?.close(NORMAL_CLOSURE, null)
    socket = null
  }

  private suspend fun run() {
    var backoff = MIN_BACKOFF_MILLIS
    while (currentCoroutineContext().isActive) {
      val sync = RemoteSync(context, ResearchLogStore(context))
      val token = if (sync.configured) sync.liveAccessToken() else null
      if (token == null) { delay(NO_SESSION_RETRY_MILLIS); continue }
      val closed = CompletableDeferred<Unit>()
      val opened = CompletableDeferred<Unit>()
      socket = client.newWebSocket(Request.Builder().url(sync.realtimeUrl).build(), object : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
          webSocket.send(join(token))
          opened.complete(Unit)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
          val event = runCatching { JSONObject(text).optString("event") }.getOrDefault("")
          if (event == "postgres_changes") scope.launch(Dispatchers.IO) { ProjectMessages.check(context, force = true) }
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) { closed.complete(Unit) }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) { closed.complete(Unit) }
      })
      val renewed = coroutineScope {
        val heartbeat = launch {
          while (isActive) {
            delay(HEARTBEAT_MILLIS)
            socket?.send(JSONObject().put("topic", "phoenix").put("event", "heartbeat").put("payload", JSONObject()).put("ref", nextRef()).toString())
          }
        }
        // Al conectarse, revisa por si llegó algo mientras no había conexión.
        launch { if (withTimeoutOrNull(OPEN_TIMEOUT_MILLIS) { opened.await() } != null) ProjectMessages.check(context, force = true) }
        // El token de la sesión dura una hora: se reconecta antes con uno nuevo.
        val timedOut = withTimeoutOrNull(RECONNECT_MILLIS) { closed.await() } == null
        heartbeat.cancel()
        timedOut
      }
      socket?.close(NORMAL_CLOSURE, null)
      socket = null
      if (renewed) { backoff = MIN_BACKOFF_MILLIS; continue }
      delay(backoff)
      backoff = (backoff * 2).coerceAtMost(MAX_BACKOFF_MILLIS)
    }
  }

  private fun join(token: String): String = JSONObject()
    .put("topic", TOPIC)
    .put("event", "phx_join")
    .put("payload", JSONObject()
      .put("config", JSONObject()
        .put("broadcast", JSONObject().put("ack", false).put("self", false))
        .put("presence", JSONObject().put("key", ""))
        .put("postgres_changes", JSONArray().put(JSONObject().put("event", "INSERT").put("schema", "public").put("table", "relevo_messages")))
        .put("private", false))
      .put("access_token", token))
    .put("ref", nextRef())
    .put("join_ref", "1")
    .toString()

  private fun nextRef(): String = synchronized(this) { (++ref).toString() }

  private companion object {
    const val TOPIC = "realtime:relevo_messages"
    const val NORMAL_CLOSURE = 1000
    const val HEARTBEAT_MILLIS = 25_000L
    const val OPEN_TIMEOUT_MILLIS = 15_000L
    const val RECONNECT_MILLIS = 50 * 60_000L
    const val MIN_BACKOFF_MILLIS = 2_000L
    const val MAX_BACKOFF_MILLIS = 60_000L
    const val NO_SESSION_RETRY_MILLIS = 60_000L
  }
}
