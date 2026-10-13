package com.example.relevo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cl.udp.relevo.BuildConfig
import com.example.relevo.data.HistoryEntry
import com.example.relevo.data.Profile
import com.example.relevo.data.Settings
import com.example.relevo.domain.Interests
import com.example.relevo.domain.RouteTrack
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.Avatar
import com.example.relevo.ui.components.ButtonKind
import com.example.relevo.ui.components.Emoji
import com.example.relevo.ui.components.EmojiGroup
import com.example.relevo.ui.components.EmojiTile
import com.example.relevo.ui.components.GlassTextButton
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.Photo
import com.example.relevo.ui.components.Picture
import com.example.relevo.ui.components.PictureTile
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoButton
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RenglonArea
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.pressScale
import androidx.compose.foundation.layout.width
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.ui.text.font.FontWeight
import com.example.relevo.ui.components.rememberReduceMotion
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.QuickChoice
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.SkyOrder
import com.example.relevo.ui.components.SectionLabel
import com.example.relevo.ui.components.skyFor

internal class ProfileActions(
  val onEdit: () -> Unit,
  val onNotices: () -> Unit,
  val onAppearance: () -> Unit,
  val onPermissions: () -> Unit,
  val onHistory: () -> Unit,
  val onActivities: () -> Unit,
  val onStudy: () -> Unit,
  val onPrivacy: () -> Unit,
  val onFeedback: () -> Unit,
  val onReport: () -> Unit,
  val onWeekNote: (String) -> Unit,
  val onOpenRoute: () -> Unit,
  val onHowItWorks: () -> Unit,
)

/** Fotos que se pueden elegir como imagen de una actividad propia. No se suben fotos propias. */
internal val choosablePhotos = listOf(
  Photo.CAMINAR, Photo.SALIDA, Photo.LEER, Photo.LIBRO, Photo.ESCRIBIR, Photo.ESTUDIAR, Photo.APRENDER, Photo.DIBUJAR,
  Photo.PINTAR, Photo.MANUALIDADES, Photo.GUITARRA, Photo.COCINAR, Photo.PAN, Photo.ORDENAR, Photo.PERRO, Photo.EJERCICIO,
)

/**
 * S1: el perfil. El emoji y el nombre al centro, «Tu semana» si la persona lo activó (hechos, sin
 * metas) y las secciones de relevos, ajustes, estudio y ayuda.
 */
@Composable
internal fun ProfileTab(
  profile: Profile,
  routes: List<RouteTrack>,
  history: List<HistoryEntry>,
  settings: Settings,
  study: StudyState,
  participation: ParticipationMode,
  customCount: Int,
  reselect: Int,
  actions: ProfileActions,
) {
  val scroll = rememberScrollState()
  var firstReselect by remember { mutableStateOf(reselect) }
  LaunchedEffect(reselect) { if (reselect != firstReselect) scroll.animateScrollTo(0) else firstReselect = reselect }
  var noting by rememberSaveable { mutableStateOf(false) }
  var tagGuide by rememberSaveable { mutableStateOf(false) }
  if (tagGuide) TagGuideSheet(onDismiss = { tagGuide = false })
  // Lámina «Perfil»: el emoji, el nombre y una frase de la semana; debajo, filas sueltas con su ficha y qué hay adentro.
  val facts = weekFacts(history)
  val canTell = participation == ParticipationMode.STUDY && facts.prepared > 0
  RelevoScreen(scrollState = scroll) {
    ProfileHeader(profile, routes, history, actions.onEdit, Modifier.appear(0))
    Spacer(Modifier.height(Gap.section))
    Column(Modifier.appear(1), verticalArrangement = Arrangement.spacedBy(Gap.list)) {
      if (settings.weeklySummary) {
        ListRow(
          "Tu semana", icon = KitIcon.AVANCE, subtitle = weekLine(facts, settings),
          chevron = canTell, onClick = if (canTell) ({ noting = true }) else null,
        )
      }
      ListRow("Tus relevos", icon = KitIcon.RELEVOS, tileColor = Relevo.colors.peach, subtitle = countLine(history.size, "relevo terminado", "relevos terminados", "Todavía no terminas ninguno"), chevron = true, onClick = actions.onHistory)
      ListRow("Tus actividades", icon = KitIcon.ESTRELLA, subtitle = countLine(customCount, "actividad", "actividades", "Guarda las que haces seguido"), chevron = true, onClick = actions.onActivities)
      ListRow("Tus pasos", icon = KitIcon.RUTA, tileColor = Relevo.colors.mist, subtitle = routes.firstNotNullOfOrNull { it.currentStep?.activity } ?: "Elige tus intereses", chevron = true, onClick = actions.onOpenRoute)
    }
    Spacer(Modifier.height(Gap.section))
    Column(Modifier.appear(2), verticalArrangement = Arrangement.spacedBy(Gap.list)) {
      ListRow("Apariencia y aura", icon = KitIcon.AURA, subtitle = "Tu aura, tema y letra", chevron = true, onClick = actions.onAppearance)
      ListRow("Avisos y resúmenes", icon = KitIcon.AVISOS, subtitle = if (settings.returnNotice) "Aviso semanal encendido" else "Aviso semanal apagado", chevron = true, onClick = actions.onNotices)
      ListRow("Permisos", icon = KitIcon.PERMISO, subtitle = "Tiempo de uso, avisos y batería", chevron = true, onClick = actions.onPermissions)
      ListRow("Privacidad y datos", icon = KitIcon.PRIVACIDAD, chevron = true, onClick = actions.onPrivacy)
    }
    Spacer(Modifier.height(Gap.section))
    Column(Modifier.appear(3), verticalArrangement = Arrangement.spacedBy(Gap.list)) {
      ListRow("Cómo funciona Relevo", icon = KitIcon.AYUDA, chevron = true, onClick = actions.onHowItWorks)
      ListRow("Cómo usar el Tag", icon = KitIcon.OBJETO, chevron = true, onClick = { tagGuide = true })
      ListRow("Tu opinión", icon = KitIcon.ESTRELLA, chevron = true, onClick = actions.onFeedback)
      ListRow("Reportar un problema", icon = KitIcon.PROBLEMA, chevron = true, onClick = actions.onReport)
    }
    Spacer(Modifier.height(20.dp))
    Text(
      "Relevo ${BuildConfig.VERSION_NAME} · Proyecto de Título de Diseño, Universidad Diego Portales",
      style = Relevo.type.footnote, color = Relevo.colors.graphite, textAlign = TextAlign.Center,
      // Mantener presionado abre la configuración de las tres semanas, solo para el investigador (D-087).
      modifier = Modifier.fillMaxWidth().pointerInput(Unit) { detectTapGestures(onLongPress = { actions.onStudy() }) },
    )
  }
  if (noting) WeekNoteSheet(onDismiss = { noting = false }, onSend = { actions.onWeekNote(it); noting = false })
}

/**
 * Encabezado del perfil (lámina «Perfil»): el emoji en un círculo blanco con sombra suave, el nombre y, en
 * grafito, los intereses. Tocarlo abre la edición.
 */
@Composable
private fun ProfileHeader(profile: Profile, routes: List<RouteTrack>, @Suppress("UNUSED_PARAMETER") history: List<HistoryEntry>, onEdit: () -> Unit, modifier: Modifier = Modifier) {
  val interaction = remember { MutableInteractionSource() }
  val interests = routes.joinToString(" · ") { it.title }
  Row(
    modifier.fillMaxWidth().pressScale(interaction, 0.985f)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Editar el perfil", onClick = onEdit),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Box(Modifier.size(80.dp).shadow(14.dp, CircleShape, ambientColor = Color.Black.copy(alpha = .05f), spotColor = Color.Black.copy(alpha = .18f)).clip(CircleShape).background(Relevo.colors.card), contentAlignment = Alignment.Center) {
      Avatar(profile.image, profile.name, 80.dp, background = Relevo.colors.card)
    }
    Spacer(Modifier.width(16.dp))
    Column(Modifier.weight(1f)) {
      Text(profile.name.ifBlank { "Tu perfil" }, style = Relevo.type.title, color = Relevo.colors.ink, maxLines = 2)
      Text(interests.ifBlank { "Toca para editar tu perfil" }, style = Relevo.type.subhead, color = Relevo.colors.graphite, maxLines = 2)
    }
    RelevoIcon(KitIcon.EDITAR, size = 22.dp, tint = Relevo.colors.graphite, background = Relevo.colors.paper)
  }
}

/** «Tu semana» en una línea: solo hechos de esta semana, sin metas ni comparaciones. */
private fun weekLine(facts: WeekFacts, settings: Settings): String = when (facts.prepared) {
  0 -> "Esta semana todavía no preparaste relevos"
  1 -> "Preparaste 1 relevo"
  else -> "Preparaste ${facts.prepared} relevos"
} + when {
  facts.prepared == 0 -> ""
  facts.started == 1 -> "; empezaste 1 vez"
  facts.started > 1 -> "; empezaste ${facts.started} veces"
  else -> ""
} + if (settings.constancy > 0 && !settings.constancyPaused) " · elegiste ${settings.constancy} por semana" else ""

private fun countLine(count: Int, one: String, many: String, none: String): String = when (count) {
  0 -> none
  1 -> "1 $one"
  else -> "$count $many"
}

/** «Tu semana»: solo hechos, sin metas ni comparación con semanas anteriores. Se apaga en Avisos y resúmenes. */
@Composable
private fun WeekSummary(history: List<HistoryEntry>, settings: Settings, canTell: Boolean, onTell: () -> Unit, modifier: Modifier = Modifier) {
  val facts = weekFacts(history)
  Panel(modifier) {
    Text("Tu semana", style = Relevo.type.label, color = Relevo.colors.graphite)
    Text(
      when (facts.prepared) {
        0 -> "Esta semana todavía no preparaste relevos."
        1 -> "Preparaste 1 relevo."
        else -> "Preparaste ${facts.prepared} relevos."
      } + when {
        facts.prepared == 0 -> ""
        facts.started == 1 -> " Dijiste que empezaste 1 vez."
        facts.started > 1 -> " Dijiste que empezaste ${facts.started} veces."
        else -> ""
      },
      style = Relevo.type.body, color = Relevo.colors.ink,
    )
    if (settings.constancy > 0 && !settings.constancyPaused) {
      Text("Elegiste hacerlo ${settings.constancy} ${if (settings.constancy == 1) "vez" else "veces"} por semana.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    }
    if (canTell && facts.prepared > 0) PlainAction("¿Qué te ayudó?", onTell, icon = KitIcon.COMENTARIO)
  }
}

@Composable
private fun WeekNoteSheet(onDismiss: () -> Unit, onSend: (String) -> Unit) {
  var text by rememberSaveable { mutableStateOf("") }
  RelevoSheet(onDismiss = onDismiss, title = "¿Qué te ayudó?") {
    Text("Nos ayuda a mejorar Relevo.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(16.dp))
    RenglonArea("Tu respuesta", text, { text = it }, "Escribe aquí")
    Spacer(Modifier.height(22.dp))
    GuardedButton("Enviar", { onSend(text) }, missing = if (text.isBlank()) "Escribe qué te ayudó." else null)
  }
}

/** P1 a P3 en tres pasos, que se pueden saltar. Los intereses arman la ruta sugerida (R1). */
@Composable
internal fun ProfileSetupScreen(
  profile: Profile,
  onName: (String) -> Unit,
  onImage: (String) -> Unit,
  onInterests: (List<String>, String) -> Unit,
  onFinish: (showRoute: Boolean) -> Unit,
) {
  var step by rememberSaveable { mutableIntStateOf(0) }
  var forward by remember { mutableStateOf(true) }
  var name by rememberSaveable { mutableStateOf(profile.name) }
  var image by rememberSaveable { mutableStateOf(profile.image) }
  var interests by rememberSaveable { mutableStateOf(profile.interests) }
  var other by rememberSaveable { mutableStateOf(profile.otherInterest) }
  val reduce = rememberReduceMotion()
  fun go(to: Int) { forward = to > step; step = to }
  BackHandler(enabled = step > 0) { go(step - 1) }
  RelevoScreen(
    title = when (step) { 0 -> "¿Cómo te llamas?"; 1 -> "Elige tu emoji"; else -> "¿Qué te gustaría hacer más seguido?" },
    onBack = if (step > 0) ({ go(step - 1) }) else null,
    step = "${step + 1} de 3",
    progress = (step + 1) / 3f,
    // El nombre es obligatorio desde 2.13 (D-089); el emoji y los intereses se pueden saltar.
    trailing = if (step > 0) ({ PlainAction("Saltar", { if (step < 2) go(step + 1) else onFinish(false) }, color = Relevo.colors.graphite) }) else null,
    bottom = {
      when (step) {
        0 -> GuardedButton("Seguir", { onName(name.trim()); go(1) }, missing = if (name.isBlank()) "Escribe tu nombre." else null)
        1 -> GuardedButton("Seguir", { onImage(image); go(2) }, missing = if (image.isBlank()) "Elige un emoji o toca «Saltar»." else null)
        else -> GuardedButton("Armar mi ruta", { onInterests(interests, other); onFinish(true) }, missing = when {
          interests.isEmpty() -> "Elige al menos un interés o toca «Saltar»."
          Interests.OTHER in interests && other.isBlank() -> "Escribe cuál es tu otro interés."
          else -> null
        })
      }
    },
  ) {
    AnimatedContent(
      targetState = step,
      transitionSpec = {
        if (reduce) EnterTransition.None togetherWith ExitTransition.None
        else if (forward) (slideInHorizontally(Motion.smooth()) { it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.smooth()) { -it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
        else (slideInHorizontally(Motion.smooth()) { -it / 4 } + fadeIn(Motion.standard())) togetherWith (slideOutHorizontally(Motion.smooth()) { it / 4 } + fadeOut(Motion.standard(Motion.SHORT)))
      },
      label = "profile_step",
    ) { current ->
      Column(Modifier.fillMaxWidth()) {
        when (current) {
          0 -> {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { WhiteAvatar(image, name) }
            SectionGap()
            RenglonField("Tu nombre", name, { name = it.take(40) }, placeholder = "Tu nombre o como te dicen", imeAction = ImeAction.Next,
              onImeAction = { if (name.isNotBlank()) { onName(name.trim()); go(1) } })
            Spacer(Modifier.height(10.dp))
            Text("Lo guardamos junto a tu código, aparte de lo que haces en Relevo.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
          }
          1 -> {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { WhiteAvatar(image, name) }
            SectionGap()
            EmojiGrid(image) { image = it }
          }
          else -> {
            Text("Elige una o varias.", style = Relevo.type.body, color = Relevo.colors.graphite)
            SectionGap()
            InterestGrid(interests, other, onToggle = { id -> interests = if (id in interests) interests - id else interests + id }, onOther = { other = it })
          }
        }
      }
    }
  }
}

/** El emoji en un círculo blanco con sombra suave, como en la lámina «Tu perfil». */
@Composable
private fun WhiteAvatar(image: String, name: String) {
  Box(Modifier.size(96.dp).shadow(14.dp, CircleShape, ambientColor = Color.Black.copy(alpha = .05f), spotColor = Color.Black.copy(alpha = .18f)).clip(CircleShape).background(Relevo.colors.card), contentAlignment = Alignment.Center) {
    Avatar(image, name, 96.dp, background = Relevo.colors.card)
  }
}

/** Emoji 3D en círculos, cinco por fila y agrupados como en los teclados: caras, animales, naturaleza, comida y actividades. */
@Composable
internal fun EmojiGrid(selected: String, onSelect: (String) -> Unit) {
  val chosen = Emoji.forProfile(selected)
  Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    EmojiGroup.entries.forEach { group ->
      Text(
        group.label, style = Relevo.type.section, color = Relevo.colors.graphite,
        modifier = Modifier.padding(start = 4.dp, top = if (group.ordinal > 0) 16.dp else 0.dp).semantics { heading() },
      )
      Emoji.entries.filter { it.group == group }.chunked(5).forEach { row ->
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
          row.forEach { emoji -> EmojiTile(emoji, chosen == emoji, { onSelect(emoji.key) }, Modifier.weight(1f)) }
          repeat(5 - row.size) { Spacer(Modifier.weight(1f)) }
        }
      }
    }
  }
}

/** P3: intereses en opciones de un toque con el color de su cielo; «Otra» abre un renglón para escribirla. */
@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun InterestGrid(selected: List<String>, other: String, onToggle: (String) -> Unit, onOther: (String) -> Unit) {
  // 3.2: en el orden de los cielos, para que los colores vayan agrupados.
  val options = Interests.all.sortedBy { SkyOrder.indexOf(skyFor(interestIcon(it.id))) }
  FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    options.forEach { interest ->
      QuickChoice(interest.label, interest.id in selected, { onToggle(interest.id) }, sky = skyFor(interestIcon(interest.id)))
    }
    QuickChoice("Otra", Interests.OTHER in selected, { onToggle(Interests.OTHER) }, icon = KitIcon.AGREGAR)
  }
  AnimatedVisibility(Interests.OTHER in selected, enter = expandVertically(Motion.smooth()) + fadeIn(), exit = shrinkVertically(Motion.smooth()) + fadeOut()) {
    Column(Modifier.padding(top = 6.dp)) {
      RenglonField("¿Cuál?", other, { onOther(it.take(40)) }, placeholder = "Ej.: tejer")
    }
  }
}

/** Editar el perfil: el emoji (en una hoja), el nombre y los intereses. Cambiar intereses conserva las rutas ya editadas. */
@Composable
internal fun ProfileEditScreen(profile: Profile, onSave: (String, String, List<String>, String) -> Unit, onBack: () -> Unit) {
  var name by rememberSaveable { mutableStateOf(profile.name) }
  var image by rememberSaveable { mutableStateOf(profile.image) }
  var interests by rememberSaveable { mutableStateOf(profile.interests) }
  var other by rememberSaveable { mutableStateOf(profile.otherInterest) }
  var picking by rememberSaveable { mutableStateOf(false) }
  val changed = name != profile.name || image != profile.image || interests != profile.interests || other != profile.otherInterest
  RelevoScreen(
    title = "Tu perfil",
    onBack = onBack, backLabel = "Cancelar",
    bottom = {
      GuardedButton("Guardar", { onSave(name.trim(), image, interests, other.trim()) }, missing = when {
        name.isBlank() -> "Escribe tu nombre."
        Interests.OTHER in interests && other.isBlank() -> "Escribe cuál es tu otro interés."
        !changed -> "No hay cambios que guardar."
        else -> null
      })
    },
  ) {
    val interaction = remember { MutableInteractionSource() }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      Box(
        Modifier.pressScale(interaction, 0.95f).clickable(interactionSource = interaction, indication = null, role = Role.Button) { picking = true }
          .semantics { contentDescription = "Cambiar el emoji" },
      ) { WhiteAvatar(image, name) }
      Spacer(Modifier.height(10.dp))
      PlainAction("Cambiar el emoji", { picking = true })
    }
    SectionGap()
    RenglonField("Tu nombre", name, { name = it.take(40) }, placeholder = "Como quieras que te diga Relevo")
    SectionGap()
    SectionLabel("Intereses", Modifier.padding(bottom = 12.dp), soft = "Elige una o varias.")
    InterestGrid(interests, other, onToggle = { id -> interests = if (id in interests) interests - id else interests + id }, onOther = { other = it })
  }
  if (picking) {
    RelevoSheet(onDismiss = { picking = false }, title = "Tu emoji", done = "Listo", tall = true) {
      Spacer(Modifier.height(4.dp))
      EmojiGrid(image) { image = it }
    }
  }
}
