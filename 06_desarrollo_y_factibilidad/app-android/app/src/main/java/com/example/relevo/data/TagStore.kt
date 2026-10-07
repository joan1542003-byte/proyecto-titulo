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

  fun save(address: String, name: String?) {
    preferences.edit()
      .putString("address", address)
      .putString("name", name?.trim().orEmpty())
      .putLong("linked_at", System.currentTimeMillis())
      .apply()
  }

  /** La guía «Cómo usar el Tag» ya se mostró: se abre sola solo la primera vez. */
  var guideSeen: Boolean
    get() = preferences.getBoolean("guide_seen", false)
    set(value) { preferences.edit().putBoolean("guide_seen", value).apply() }

  fun clear() {
    val seen = guideSeen
    preferences.edit().clear().putBoolean("guide_seen", seen).apply()
  }
}
