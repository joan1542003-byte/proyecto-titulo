package com.example.relevo.data

import android.content.Context

/**
 * El llavero vinculado (D-109): su dirección Bluetooth y el nombre con que se anuncia. Queda solo en
 * el teléfono; al registro remoto va únicamente si hay un llavero vinculado, nunca su dirección.
 */
class TagStore(context: Context) {
  private val preferences = context.applicationContext.getSharedPreferences("relevo_tag", Context.MODE_PRIVATE)

  val address: String? get() = preferences.getString("address", null)?.takeIf { it.isNotBlank() }

  val name: String get() = preferences.getString("name", null)?.trim().orEmpty().ifBlank { "Llavero" }

  val linked: Boolean get() = address != null

  fun save(address: String, name: String?) {
    preferences.edit()
      .putString("address", address)
      .putString("name", name?.trim().orEmpty())
      .putLong("linked_at", System.currentTimeMillis())
      .apply()
  }

  fun clear() { preferences.edit().clear().apply() }
}
