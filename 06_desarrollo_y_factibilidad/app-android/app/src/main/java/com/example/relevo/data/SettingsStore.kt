package com.example.relevo.data

import android.content.Context

enum class ThemeMode { SYSTEM, LIGHT, DARK }

/**
 * Preferencias de S2 y de apariencia. Todo lo opcional empieza apagado: la persona elige qué recibir
 * (diseño escrito, principio 2). Se guardan solo en el teléfono.
 */
data class Settings(
  val theme: ThemeMode = ThemeMode.SYSTEM,
  val largeText: Boolean = false,
  /** Resumen «Tu semana» en el perfil. */
  val weeklySummary: Boolean = false,
  /** Aviso de regreso (V2): como máximo una vez por semana. */
  val returnNotice: Boolean = false,
  /** Mensajes breves después de responder; si se apaga, solo se registra. */
  val acknowledgements: Boolean = true,
  /** Constancia elegida: veces por semana que fija la persona; 0 es apagada. Variante de la prueba. */
  val constancy: Int = 0,
  val constancyPaused: Boolean = false,
)

class SettingsStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_settings", Context.MODE_PRIVATE)

  fun load(): Settings = Settings(
    theme = runCatching { ThemeMode.valueOf(preferences.getString("theme", ThemeMode.SYSTEM.name).orEmpty()) }.getOrDefault(ThemeMode.SYSTEM),
    largeText = preferences.getBoolean("large_text", false),
    weeklySummary = preferences.getBoolean("weekly_summary", false),
    returnNotice = preferences.getBoolean("return_notice", false),
    acknowledgements = preferences.getBoolean("acknowledgements", true),
    constancy = preferences.getInt("constancy", 0).coerceIn(0, 7),
    constancyPaused = preferences.getBoolean("constancy_paused", false),
  )

  fun save(settings: Settings) {
    preferences.edit()
      .putString("theme", settings.theme.name)
      .putBoolean("large_text", settings.largeText)
      .putBoolean("weekly_summary", settings.weeklySummary)
      .putBoolean("return_notice", settings.returnNotice)
      .putBoolean("acknowledgements", settings.acknowledgements)
      .putInt("constancy", settings.constancy.coerceIn(0, 7))
      .putBoolean("constancy_paused", settings.constancyPaused)
      .apply()
  }

  /** Última vez que se abrió la app; el aviso de regreso solo llega si pasó una semana sin abrirla. */
  var lastOpenedAt: Long
    get() = preferences.getLong("last_opened_at", 0L)
    set(value) { preferences.edit().putLong("last_opened_at", value).apply() }

  var lastReturnNoticeAt: Long
    get() = preferences.getLong("last_return_notice_at", 0L)
    set(value) { preferences.edit().putLong("last_return_notice_at", value).apply() }

  /** «Ahora no» seguidos en el aviso de regreso; al segundo, la app pregunta una vez si se apaga. */
  var returnNotNow: Int
    get() = preferences.getInt("return_not_now", 0)
    set(value) { preferences.edit().putInt("return_not_now", value).apply() }

  var turnOffAsked: Boolean
    get() = preferences.getBoolean("turn_off_asked", false)
    set(value) { preferences.edit().putBoolean("turn_off_asked", value).apply() }

  fun clear() { preferences.edit().clear().apply() }
}
