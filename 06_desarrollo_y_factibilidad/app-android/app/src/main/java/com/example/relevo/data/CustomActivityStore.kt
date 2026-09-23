package com.example.relevo.data

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

data class CustomActivity(
  val id: String,
  val name: String,
  val firstStep: String,
  val place: String,
  val icon: String,
  val color: Int,
)

class CustomActivityStore(context: Context) {
  private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

  fun load(): List<CustomActivity> {
    val raw = runCatching { preferences.getString(ACTIVITIES_KEY, "[]") }.getOrNull() ?: return emptyList()
    val array = runCatching { JSONArray(raw) }.getOrNull() ?: return emptyList()
    val activities = LinkedHashMap<String, CustomActivity>()

    for (index in 0 until array.length()) {
      val activity = runCatching { array.optJSONObject(index)?.toCustomActivity() }.getOrNull() ?: continue
      if (activity.id !in activities) activities[activity.id] = activity
    }

    return activities.values.toList()
  }

  fun upsert(item: CustomActivity): List<CustomActivity> {
    val activity = item.normalized()
    val updated = load().toMutableList()
    val index = updated.indexOfFirst { it.id == activity.id }
    if (index < 0) updated.add(activity) else updated[index] = activity
    save(updated)
    return updated
  }

  fun delete(id: String): List<CustomActivity> {
    val updated = load().filterNot { it.id == id.trim() }
    save(updated)
    return updated
  }

  private fun save(activities: List<CustomActivity>) {
    val array = JSONArray()
    activities.forEach { activity ->
      array.put(
        JSONObject().apply {
          put("id", activity.id)
          put("name", activity.name)
          put("first_step", activity.firstStep)
          put("place", activity.place)
          put("icon", activity.icon)
          put("color", activity.color)
        },
      )
    }
    preferences.edit().putString(ACTIVITIES_KEY, array.toString()).apply()
  }

  private fun JSONObject.toCustomActivity(): CustomActivity? {
    val id = (opt("id") as? String)?.trim()?.takeIf(String::isNotEmpty) ?: return null
    val name = (opt("name") as? String)?.trim()?.takeIf(String::isNotEmpty) ?: return null
    val firstStep = opt("first_step") as? String ?: return null
    val place = opt("place") as? String ?: return null
    val icon = opt("icon") as? String ?: return null
    val colorNumber = opt("color") as? Number ?: return null
    val color = colorNumber.toLong()
    if (colorNumber.toDouble() != color.toDouble() || color !in Int.MIN_VALUE.toLong()..Int.MAX_VALUE.toLong()) return null

    return CustomActivity(id, name, firstStep.trim(), place.trim(), icon.trim(), color.toInt())
  }

  private fun CustomActivity.normalized(): CustomActivity = copy(
    id = id.trim().also { require(it.isNotEmpty()) { "id must not be blank" } },
    name = name.trim().also { require(it.isNotEmpty()) { "name must not be blank" } },
    firstStep = firstStep.trim(),
    place = place.trim(),
    icon = icon.trim(),
  )

  private companion object {
    const val PREFERENCES_NAME = "relevo_custom_activities"
    const val ACTIVITIES_KEY = "activities"
  }
}
