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
import com.example.relevo.ui.components.rememberReduceMotion

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
  RelevoScreen(scrollState = scroll) {
    ProfileHeader(profile, routes, actions.onEdit, Modifier.appear(0))
    if (settings.weeklySummary) {
      SectionGap()
      WeekSummary(history, settings, canTell = participation == ParticipationMode.STUDY, onTell = { noting = true }, modifier = Modifier.appear(1))
    }
    SectionGap()
    ListSection(title = "Relevos", modifier = Modifier.appear(2)) {
      ListRow("Tus relevos", icon = KitIcon.RELEVOS, value = history.size.takeIf { it > 0 }?.toString(), chevron = true, onClick = actions.onHistory)
      ListRow("Tus actividades", icon = KitIcon.ACTIVIDAD, value = customCount.takeIf { it > 0 }?.toString(), chevron = true, onClick = actions.onActivities)
      ListRow("Tu ruta", icon = KitIcon.PRIMER_PASO, value = routes.size.takeIf { it > 0 }?.let { "$it ${if (it == 1) "interés" else "intereses"}" }, chevron = true, onClick = actions.onOpenRoute)
    }
    SectionGap()
    ListSection(title = "Ajustes", modifier = Modifier.appear(3)) {
      ListRow("Avisos y resúmenes", icon = KitIcon.AVISOS, chevron = true, onClick = actions.onNotices)
      ListRow("Apariencia", icon = KitIcon.TEMA, chevron = true, onClick = actions.onAppearance)
      ListRow("Permisos", icon = KitIcon.PERMISO, chevron = true, onClick = actions.onPermissions)
    }
    SectionGap()
    ListSection(title = "Privacidad", modifier = Modifier.appear(4)) {
      ListRow("Tus datos", icon = KitIcon.PRIVACIDAD, chevron = true, onClick = actions.onPrivacy)
    }
    SectionGap()
    ListSection(title = "Ayuda", modifier = Modifier.appear(5)) {
      ListRow("Cómo funciona Relevo", icon = KitIcon.AYUDA, chevron = true, onClick = actions.onHowItWorks)
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

/** Encabezado del perfil al centro, como en los ajustes de iOS. Tocarlo abre la edición. */
@Composable
private fun ProfileHeader(profile: Profile, routes: List<RouteTrack>, onEdit: () -> Unit, modifier: Modifier = Modifier) {
  val interaction = remember { MutableInteractionSource() }
  val interests = routes.joinToString(" · ") { it.title }
  Column(
    modifier.fillMaxWidth().padding(top = 12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Box(
      Modifier.pressScale(interaction, 0.95f)
        .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClick = onEdit)
        .semantics { contentDescription = "Editar el perfil" },
    ) { Avatar(profile.image, profile.name, 104.dp) }
    Spacer(Modifier.height(14.dp))
    Text(profile.name.ifBlank { "Tu perfil" }, style = Relevo.type.title, color = Relevo.colors.ink, textAlign = TextAlign.Center)
    if (interests.isNotBlank()) {
      Spacer(Modifier.height(4.dp))
      Text(interests, style = Relevo.type.subhead, color = Relevo.colors.graphite, textAlign = TextAlign.Center)
    }
    Spacer(Modifier.height(14.dp))
    RelevoButton("Editar", onEdit, kind = ButtonKind.Secondary, compact = true)
  }
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
    RelevoButton("Enviar", { onSend(text) }, enabled = text.isNotBlank())
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
    trailing = { GlassTextButton("Saltar", { if (step < 2) go(step + 1) else onFinish(false) }, color = Relevo.colors.graphite) },
    bottom = {
      when (step) {
        0 -> RelevoButton("Seguir", { onName(name.trim()); go(1) }, enabled = name.isNotBlank())
        1 -> RelevoButton("Seguir", { onImage(image); go(2) }, enabled = image.isNotBlank())
        else -> RelevoButton("Armar mi ruta", { onInterests(interests, other); onFinish(true) }, enabled = interests.isNotEmpty() && (Interests.OTHER !in interests || other.isNotBlank()))
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
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Avatar(image, name, 104.dp) }
            SectionGap()
            RenglonField("Tu nombre", name, { name = it.take(40) }, placeholder = "Como quieras que te diga Relevo", imeAction = ImeAction.Next,
              onImeAction = { if (name.isNotBlank()) { onName(name.trim()); go(1) } })
          }
          1 -> {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Avatar(image, name, 104.dp) }
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

/** P3: intereses con foto, en dos columnas; «Otra» abre un renglón para escribirla. */
@Composable
internal fun InterestGrid(selected: List<String>, other: String, onToggle: (String) -> Unit, onOther: (String) -> Unit) {
  val options = Interests.all.map { Triple(it.id, it.label, interestPhoto(it.id)?.let { photo -> Picture.OfPhoto(photo) } as Picture?) } +
    Triple(Interests.OTHER, "Otra", Picture.OfIcon(KitIcon.AGREGAR))
  options.chunked(2).forEach { row ->
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
      row.forEach { (id, label, picture) ->
        PictureTile(picture, id in selected, { onToggle(id) }, Modifier.weight(1f), label = label, aspect = 1.2f, cornerRadius = 26.dp, prominent = true)
      }
      if (row.size == 1) Spacer(Modifier.weight(1f))
    }
    Spacer(Modifier.height(14.dp))
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
    bottom = { RelevoButton("Guardar", { onSave(name.trim(), image, interests, other.trim()) }, enabled = changed && (Interests.OTHER !in interests || other.isNotBlank())) },
  ) {
    val interaction = remember { MutableInteractionSource() }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      Box(
        Modifier.pressScale(interaction, 0.95f).clickable(interactionSource = interaction, indication = null, role = Role.Button) { picking = true }
          .semantics { contentDescription = "Cambiar el emoji" },
      ) { Avatar(image, name, 104.dp) }
      Spacer(Modifier.height(10.dp))
      PlainAction("Cambiar el emoji", { picking = true })
    }
    SectionGap()
    RenglonField("Tu nombre", name, { name = it.take(40) }, placeholder = "Como quieras que te diga Relevo")
    SectionGap()
    Text("Intereses", style = Relevo.type.section, color = Relevo.colors.graphite, modifier = Modifier.padding(start = 4.dp, bottom = 12.dp))
    InterestGrid(interests, other, onToggle = { id -> interests = if (id in interests) interests - id else interests + id }, onOther = { other = it })
  }
  if (picking) {
    RelevoSheet(onDismiss = { picking = false }, title = "Tu emoji", done = "Listo", tall = true) {
      Spacer(Modifier.height(4.dp))
      EmojiGrid(image) { image = it }
    }
  }
}
