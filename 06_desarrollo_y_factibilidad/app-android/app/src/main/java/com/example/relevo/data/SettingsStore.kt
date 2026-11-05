package com.example.relevo.data

import android.content.Context
import com.example.relevo.domain.QuietHours

enum class ThemeMode { SYSTEM, LIGHT, DARK }

/** Aura de la pantalla (3.0, D-128): apagada, suave, media o viva. Es de la app; el Tag no emite luz. */
enum class AuraLevel { OFF, SOFT, MEDIUM, STRONG }

/**
 * Volumen del sonido en el teléfono y en un dispositivo de audio (1.0.0). Multiplica el sonido de Relevo;
 * el volumen multimedia del teléfono sigue mandando. El Tag pita siempre con su propio volumen.
 */
enum class SignalVolume(val gain: Float) { SOFT(0.35f), MEDIUM(0.65f), LOUD(1f) }

/**
 * Ajustes de la persona. El aviso semanal empieza apagado (D-088): la memoria pide configuración
 * voluntaria (secciones 7 y 11). Las horas sin sonar empiezan apagadas y, al encenderlas, proponen de
 * 23:00 a 8:00 (1.0.0).
 */
data class Settings(
  val theme: ThemeMode = ThemeMode.LIGHT,
  val largeText: Boolean = false,
  /** Resumen «Tu semana» en el perfil. */
  val weeklySummary: Boolean = true,
  /** Aviso semanal (V2): como máximo una vez por semana. */
  val returnNotice: Boolean = false,
  /** Unas palabras después de responder; si se apaga, solo se registra la respuesta. */
  val acknowledgements: Boolean = true,
  /** Veces por semana que la persona elige; 0 es apagado. */
  val constancy: Int = 0,
  val constancyPaused: Boolean = false,
  /** Desde 3.0. Quien actualiza parte con el aura media. */
  val aura: AuraLevel = AuraLevel.MEDIUM,
  /** Horas sin sonar (1.0.0): entre [quietFrom] y [quietUntil], Relevo no cuenta ni suena. */
  val quietHours: Boolean = false,
  val quietFrom: Int = QuietHours.DEFAULT_FROM,
  val quietUntil: Int = QuietHours.DEFAULT_UNTIL,
  val volume: SignalVolume = SignalVolume.MEDIUM,
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
    aura = runCatching { AuraLevel.valueOf(preferences.getString("aura", AuraLevel.MEDIUM.name).orEmpty()) }.getOrDefault(AuraLevel.MEDIUM),
    quietHours = preferences.getBoolean("quiet_hours", false),
    quietFrom = preferences.getInt("quiet_from", QuietHours.DEFAULT_FROM).coerceIn(0, 23),
    quietUntil = preferences.getInt("quiet_until", QuietHours.DEFAULT_UNTIL).coerceIn(0, 23),
    volume = runCatching { SignalVolume.valueOf(preferences.getString("volume", SignalVolume.MEDIUM.name).orEmpty()) }.getOrDefault(SignalVolume.MEDIUM),
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
      .putString("aura", settings.aura.name)
      .putBoolean("quiet_hours", settings.quietHours)
      .putInt("quiet_from", settings.quietFrom.coerceIn(0, 23))
      .putInt("quiet_until", settings.quietUntil.coerceIn(0, 23))
      .putString("volume", settings.volume.name)
      .apply()
  }

  /** Última vez que se abrió la app; el aviso semanal solo llega si pasó una semana sin abrirla. */
  var lastOpenedAt: Long
    get() = preferences.getLong("last_opened_at", 0L)
    set(value) { preferences.edit().putLong("last_opened_at", value).apply() }

  var lastReturnNoticeAt: Long
    get() = preferences.getLong("last_return_notice_at", 0L)
    set(value) { preferences.edit().putLong("last_return_notice_at", value).apply() }

  /** «Ahora no» seguidos en el aviso semanal; al segundo, la app pregunta una vez si se apaga. */
  var returnNotNow: Int
    get() = preferences.getInt("return_not_now", 0)
    set(value) { preferences.edit().putInt("return_not_now", value).apply() }

  var turnOffAsked: Boolean
    get() = preferences.getBoolean("turn_off_asked", false)
    set(value) { preferences.edit().putBoolean("turn_off_asked", value).apply() }

  fun clear() { preferences.edit().clear().apply() }
}
