package com.example.relevo.data

import android.content.Context

enum class ThemeMode { SYSTEM, LIGHT, DARK }

/**
 * Preferencias de S2 y de apariencia. Desde 2.12 (D-087) la app empieza en modo claro y con el resumen
 * semanal encendido. Desde 2.13 (D-088) el aviso semanal vuelve a empezar apagado y la guía de la primera
 * vez pregunta Sí o No, sin respuesta marcada: la memoria pide configuración voluntaria (secciones 7 y 11).
 */
data class Settings(
  val theme: ThemeMode = ThemeMode.LIGHT,
  val largeText: Boolean = false,
  /** Resumen «Tu semana» en el perfil. */
  val weeklySummary: Boolean = true,
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
    theme = runCatching { ThemeMode.valueOf(preferences.getString("theme", ThemeMode.LIGHT.name).orEmpty()) }.getOrDefault(ThemeMode.LIGHT),
    largeText = preferences.getBoolean("large_text", false),
    weeklySummary = preferences.getBoolean("weekly_summary", true),
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
