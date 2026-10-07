package com.example.relevo.data

import android.content.Context

/**
 * El llavero vinculado (D-109): su dirección Bluetooth y el nombre con que se anuncia. Queda solo en
 * el teléfono; al registro remoto va únicamente si hay un llavero vinculado, nunca su dirección.
 */
class TagStore(context: Context) {
  private val preferences = context.applicationContext.getSharedPreferences("relevo_tag", Context.MODE_PRIVATE)

  val address: String? get() = preferences.getString("address", null)?.takeIf { it.isNotBlank() }

  val name: String get() = preferences.getString("name", null)?.trim().orEmpty().ifBlank { "Tag" }

  val linked: Boolean get() = address != null

  /** Guarda un Tag nuevo; la forma de hacerlo pitar se vuelve a probar. */
  fun save(address: String, name: String?) {
    preferences.edit()
      .remove("alert_level").remove("keep_link_loss_alarm").remove("heard")
      .putString("address", address)
      .putString("name", name?.trim().orEmpty())
      .putLong("linked_at", System.currentTimeMillis())
      .apply()
  }

  /**
   * Cómo se le pide a este Tag que pite (2.26). Los modelos no responden igual: la prueba recorre las
   * formas hasta que la persona confirma que lo escuchó, y se guarda la que funcionó. [alertLevel]: 2
   * (alto, el de iTag One) o 1 (medio). [keepLinkLossAlarm]: no tocar su interruptor FFE2, porque en
   * algunos modelos apagarlo también silencia el pitido.
   */
  var alertLevel: Int
    get() = preferences.getInt("alert_level", 2)
    set(value) { preferences.edit().putInt("alert_level", value).apply() }

  var keepLinkLossAlarm: Boolean
    get() = preferences.getBoolean("keep_link_loss_alarm", false)
    set(value) { preferences.edit().putBoolean("keep_link_loss_alarm", value).apply() }

  /** La persona confirmó que lo escuchó pitar con la forma guardada. */
  var heard: Boolean
    get() = preferences.getBoolean("heard", false)
    set(value) { preferences.edit().putBoolean("heard", value).apply() }

  /** La guía «Cómo usar el Tag» ya se mostró: se abre sola solo la primera vez. */
  var guideSeen: Boolean
    get() = preferences.getBoolean("guide_seen", false)
    set(value) { preferences.edit().putBoolean("guide_seen", value).apply() }

  fun clear() {
    val seen = guideSeen
    preferences.edit().clear().putBoolean("guide_seen", seen).apply()
  }
}
