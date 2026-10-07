package com.example.relevo.data

import android.content.Context
import com.example.relevo.domain.Interests
import com.example.relevo.domain.RouteStep
import com.example.relevo.domain.RouteTrack
import org.json.JSONArray
import org.json.JSONObject

/**
 * Rutas de la persona (R1–R3), solo en el teléfono. Guarda también cuántas veces dijo «Comencé la
 * actividad» en cada paso, para ofrecer el siguiente (R3) sin afirmar que se formó un hábito.
 */
class RouteStore(context: Context) {
  private val preferences = context.getSharedPreferences("relevo_route", Context.MODE_PRIVATE)

  fun load(): List<RouteTrack> = runCatching {
    val array = JSONArray(preferences.getString("tracks", "[]"))
    List(array.length()) { index ->
      val item = array.getJSONObject(index)
      val steps = item.getJSONArray("steps")
      RouteTrack(
        interest = item.getString("interest"),
        title = item.getString("title"),
        steps = List(steps.length()) { s ->
          steps.getJSONObject(s).let {
            val activity = it.getString("activity")
            val firstStep = it.optString("first_step")
            RouteStep(it.getString("id"), activity, firstStep, Interests.updatedPlace(activity, firstStep, it.optString("place")))
          }
        },
        current = item.optInt("current", 0),
      )
    }
  }.getOrDefault(emptyList())

  fun save(tracks: List<RouteTrack>) {
    val array = JSONArray()
    tracks.forEach { track ->
      array.put(JSONObject().apply {
        put("interest", track.interest)
        put("title", track.title)
        put("current", track.currentIndex)
        put("steps", JSONArray().apply {
          track.steps.forEach { step ->
            put(JSONObject().put("id", step.id).put("activity", step.activity).put("first_step", step.firstStep).put("place", step.place))
          }
        })
      })
    }
    preferences.edit().putString("tracks", array.toString()).apply()
  }

  fun starts(stepId: String): Int = preferences.getInt("starts_$stepId", 0)

  fun addStart(stepId: String): Int {
    val next = starts(stepId) + 1
    preferences.edit().putInt("starts_$stepId", next).apply()
    return next
  }

  /** La persona eligió «Seguir en este paso»; no se vuelve a ofrecer el siguiente desde este paso. */
  fun declined(stepId: String): Boolean = preferences.getBoolean("declined_$stepId", false)
  fun decline(stepId: String) { preferences.edit().putBoolean("declined_$stepId", true).apply() }

  /** Paso desde el que se preparó el relevo en curso, si vino de la ruta. */
  fun preparedStep(): String? = preferences.getString("prepared_step", null)
  fun setPreparedStep(stepId: String?) { preferences.edit().putString("prepared_step", stepId).apply() }

  fun clear() { preferences.edit().clear().apply() }
}
