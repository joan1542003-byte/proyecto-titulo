package com.example.relevo.data

import android.content.Context

/**
 * Perfil de P1 a P3. El nombre se envía aparte, solo con el código (D-089). La imagen y los intereses
 * van en el estado del teléfono (D-097), sin el nombre.
 */
data class Profile(
  val name: String = "",
  /** Imagen elegida: «foto:NOMBRE» o «icono:NOMBRE». No se suben fotos, para no guardar rostros. */
  val image: String = "",
  val interests: List<String> = emptyList(),
  val otherInterest: String = "",
  /** Ya pasó por P1 a P3, aunque haya saltado todo. */
  val setupSeen: Boolean = false,
)

class ProfileStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_profile", Context.MODE_PRIVATE)

  fun load(): Profile = Profile(
    name = preferences.getString("name", "").orEmpty(),
    image = preferences.getString("image", "").orEmpty(),
    interests = preferences.getString("interests", "").orEmpty().split(',').filter { it.isNotBlank() },
    otherInterest = preferences.getString("other_interest", "").orEmpty(),
    setupSeen = preferences.getBoolean("setup_seen", false),
  )

  fun save(profile: Profile) {
    preferences.edit()
      .putString("name", profile.name.trim().take(40))
      .putString("image", profile.image)
      .putString("interests", profile.interests.joinToString(","))
      .putString("other_interest", profile.otherInterest.trim().take(40))
      .putBoolean("setup_seen", profile.setupSeen)
      .apply()
  }

  fun clear() { preferences.edit().clear().apply() }
}
