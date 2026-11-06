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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import com.example.relevo.ui.components.Text
import androidx.compose.runtime.Composable
import com.example.relevo.monitor.InstalledApp
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.relevo.domain.Interests
import com.example.relevo.domain.RouteTrack
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.CircleButton
import com.example.relevo.ui.components.GuardedButton
import com.example.relevo.ui.components.Avatar
import com.example.relevo.ui.components.Emoji
import com.example.relevo.ui.components.EmojiGroup
import com.example.relevo.ui.components.EmojiTile
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.ListRow
import com.example.relevo.ui.components.ListSection
import com.example.relevo.ui.components.Motion
import com.example.relevo.ui.components.PlainAction
import com.example.relevo.ui.components.RelevoScreen
import com.example.relevo.ui.components.RelevoSheet
import com.example.relevo.ui.components.RingCell
import com.example.relevo.ui.components.RingGrid
import com.example.relevo.ui.components.RenglonField
import com.example.relevo.ui.components.SectionGap
import com.example.relevo.ui.components.appear
import com.example.relevo.ui.components.pressScale
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.example.relevo.ui.components.rememberReduceMotion
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import com.example.relevo.ui.components.Gap
import com.example.relevo.ui.components.SkyOrder
import com.example.relevo.ui.components.SectionLabel
import com.example.relevo.ui.components.skyFor

internal class ProfileActions(
  val onEdit: () -> Unit,
  val onSettings: () -> Unit,
  val onHistory: () -> Unit,
  val onActivities: () -> Unit,
  val onRoute: () -> Unit,
  val onFeedback: () -> Unit,
  val onReport: () -> Unit,
  val onToggleApp: (InstalledApp) -> Unit,
  val onHowItWorks: () -> Unit,
)

/**
 * Perfil (4.0, D-155): la persona arriba —su emoji, su nombre y sus intereses—, lo suyo en un grupo y la
 * ayuda en otro. Los ajustes se abren con la tuerca de arriba a la derecha y ya no están en Inicio. Todos
 * los íconos van iguales, en tinta sobre piedra. Desde 4.2 (D-157), «Envíanos un comentario» reúne en una
 * sola fila lo que antes eran «¿Qué te ayudó esta semana?» y «Opinar sobre Relevo».
 */
@Composable
internal fun ProfileTab(
  profile: Profile,
  routes: List<RouteTrack>,
  history: List<HistoryEntry>,
  customCount: Int,
  apps: List<InstalledApp>,
  reselect: Int,
  actions: ProfileActions,
) {
  val scroll = rememberScrollState()
  var firstReselect by remember { mutableStateOf(reselect) }
  LaunchedEffect(reselect) { if (reselect != firstReselect) scroll.animateScrollTo(0) else firstReselect = reselect }
  var tagGuide by rememberSaveable { mutableStateOf(false) }
  var pickingApps by rememberSaveable { mutableStateOf(false) }
  if (tagGuide) TagGuideSheet(onDismiss = { tagGuide = false })
  if (pickingApps) AppPickerSheet(apps, profile.apps.map { it.packageName }.toSet(), actions.onToggleApp, onDismiss = { pickingApps = false })
  RelevoScreen(scrollState = scroll, barTitle = "Perfil", trailing = { GearButton(actions.onSettings) }) {
    ProfileHeader(profile, routes, actions.onEdit, Modifier.appear(0))
    Spacer(Modifier.height(Gap.section))
    ListSection(Modifier.appear(1)) {
      ListRow("Relevos", icon = KitIcon.RELEVOS, subtitle = countLine(history.size, "relevo terminado", "relevos terminados", "Todavía no terminas ninguno"), chevron = true, onClick = actions.onHistory)
      ListRow("Actividades", icon = KitIcon.ACTIVIDADES, subtitle = countLine(customCount, "actividad guardada", "actividades guardadas", "Guarda las que haces seguido"), chevron = true, onClick = actions.onActivities)
      ListRow("Pasos", icon = KitIcon.DECISION, subtitle = routes.firstNotNullOfOrNull { it.currentStep?.activity }?.let { "Ahora: $it" } ?: "Elige intereses", chevron = true, onClick = actions.onRoute)
      // 4.3 (D-158): las apps que cuentan tu tiempo; Preparar las trae marcadas.
      ListRow(
        "Apps", icon = KitIcon.TELEFONO,
        subtitle = profile.apps.takeIf { it.isNotEmpty() }?.joinToString(" y ") { it.label } ?: "Las que cuentan el tiempo",
        chevron = true, onClick = { pickingApps = true },
      )
    }
    Spacer(Modifier.height(Gap.section))
    // Ajustes también como fila, no solo con la tuerca (4.3).
    ListSection(Modifier.appear(2)) {
      ListRow("Ajustes", icon = KitIcon.TUERCA, subtitle = "Sonido, avisos, apariencia y datos", chevron = true, onClick = actions.onSettings)
    }
    Spacer(Modifier.height(Gap.section))
    ListSection(Modifier.appear(3), title = "Ayuda") {
      ListRow("Cómo funciona Relevo", icon = KitIcon.AYUDA, chevron = true, onClick = actions.onHowItWorks)
      ListRow("Cómo usar el Tag", icon = KitIcon.OBJETO, chevron = true, onClick = { tagGuide = true })
      ListRow("Envíanos un comentario", icon = KitIcon.COMENTARIO, chevron = true, onClick = actions.onFeedback)
      ListRow("Reportar un problema", icon = KitIcon.PROBLEMA, chevron = true, onClick = actions.onReport)
    }
    Spacer(Modifier.height(20.dp))
    Text(
      "Relevo ${BuildConfig.VERSION_NAME} · Proyecto de Título de Diseño, Universidad Diego Portales",
      style = Relevo.type.footnote, color = Relevo.colors.graphite, textAlign = TextAlign.Center,
      modifier = Modifier.fillMaxWidth(),
    )
  }
}

/** La tuerca de los ajustes, arriba a la derecha de Perfil: un círculo blanco como el de volver. */
@Composable
private fun GearButton(onClick: () -> Unit) = CircleButton(KitIcon.TUERCA, "Ajustes", onClick)

/**
 * Encabezado del perfil: el emoji en un círculo blanco con sombra suave, el nombre y, en grafito, los
 * intereses. Tocarlo abre la edición.
 */
@Composable
private fun ProfileHeader(profile: Profile, routes: List<RouteTrack>, onEdit: () -> Unit, modifier: Modifier = Modifier) {
  val interaction = remember { MutableInteractionSource() }
  val interests = routes.joinToString(" · ") { it.title }
  Column(
    modifier.fillMaxWidth().pressScale(interaction, 0.985f)
      .clickable(interactionSource = interaction, indication = null, role = Role.Button, onClickLabel = "Editar el perfil", onClick = onEdit),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Box(Modifier.size(92.dp).clip(CircleShape).background(Relevo.colors.card).border(1.dp, Relevo.colors.line, CircleShape), contentAlignment = Alignment.Center) {
      Avatar(profile.image, profile.name, 92.dp, background = Relevo.colors.card)
    }
    Spacer(Modifier.height(12.dp))
    Text(profile.name.ifBlank { "Perfil" }, style = Relevo.type.title, color = Relevo.colors.ink, maxLines = 2, textAlign = TextAlign.Center)
    if (interests.isNotBlank()) Text(interests, style = Relevo.type.subhead, color = Relevo.colors.graphite, maxLines = 2, textAlign = TextAlign.Center)
    Spacer(Modifier.height(2.dp))
    PlainAction("Editar el perfil", onEdit, color = Relevo.colors.graphite)
  }
}

private fun countLine(count: Int, one: String, many: String, none: String): String = when (count) {
  0 -> none
  1 -> "1 $one"
  else -> "$count $many"
}

/** P1 a P3 en tres pasos, que se pueden saltar. Los intereses arman la ruta sugerida (R1). */
@Composable
internal fun ProfileSetupScreen(
  profile: Profile,
  onName: (String) -> Unit,
  onImage: (String) -> Unit,
  onInterests: (List<String>, String) -> Unit,
  onFinish: (showRoute: Boolean) -> Unit,
  /** Desde Inicio o la hoja del primer relevo (4.4), el perfil se puede cerrar y completar después. */
  onClose: (() -> Unit)? = null,
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
  val stepScroll = rememberScrollState()
  // Cada paso empieza arriba (4.3): el desplazamiento de un paso no se arrastra al siguiente.
  LaunchedEffect(step) { stepScroll.scrollTo(0) }
  RelevoScreen(
    scrollState = stepScroll,
    title = when (step) { 0 -> "¿Cómo te llamas?"; 1 -> "¿Con qué te identificas?"; else -> "¿Qué te gustaría hacer más seguido?" },
    onBack = if (step > 0) ({ go(step - 1) }) else onClose,
    step = "${step + 1} de 3",
    progress = (step + 1) / 3f,
    // El nombre es obligatorio desde 2.13 (D-089); el emoji y los intereses se pueden saltar.
    trailing = if (step > 0) ({ PlainAction("Saltar", { if (step < 2) go(step + 1) else onFinish(false) }, color = Relevo.colors.graphite) }) else null,
    bottom = {
      when (step) {
        0 -> GuardedButton("Seguir", { onName(name.trim()); go(1) }, missing = if (name.isBlank()) "Escribe tu nombre." else null)
        1 -> GuardedButton("Seguir", { onImage(image); go(2) }, missing = if (image.isBlank()) "Elige uno o salta este paso." else null)
        else -> GuardedButton("Listo", { onInterests(interests, other); onFinish(true) }, missing = when {
          interests.isEmpty() -> "Elige al menos uno o salta este paso."
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
            RenglonField("Nombre", name, { name = it.take(40) }, placeholder = "Como te dicen", imeAction = ImeAction.Next,
              onImeAction = { if (name.isNotBlank()) { onName(name.trim()); go(1) } })
            Spacer(Modifier.height(10.dp))
            Text("Se guarda con tu código, aparte de lo que haces en Relevo.", style = Relevo.type.footnote, color = Relevo.colors.graphite, modifier = Modifier.padding(horizontal = 4.dp))
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
  Box(Modifier.size(96.dp).clip(CircleShape).background(Relevo.colors.card).border(1.dp, Relevo.colors.line, CircleShape), contentAlignment = Alignment.Center) {
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

/** P3: intereses en opciones de un toque con su ícono; «Otra» abre un renglón para escribirla. */
@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun InterestGrid(selected: List<String>, other: String, onToggle: (String) -> Unit, onOther: (String) -> Unit) {
  // En el orden de las familias, para que lo parecido quede junto. Desde 4.3 (D-158), anillos de a tres con
  // una o dos palabras: las cápsulas de largos muy distintos se veían desordenadas.
  val options: List<String?> = Interests.all.sortedBy { SkyOrder.indexOf(skyFor(interestIcon(it.id))) }.map { it.id } + Interests.OTHER
  RingGrid(options, columns = 3) { id ->
    if (id == Interests.OTHER) RingCell(KitIcon.AGREGAR, "Otra", { onToggle(Interests.OTHER) }, size = 64.dp, selected = Interests.OTHER in selected)
    else if (id != null) RingCell(interestIcon(id), interestShort(id), { onToggle(id) }, size = 64.dp, selected = id in selected, description = Interests.byId(id)?.label ?: interestShort(id))
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
    title = "Perfil",
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
    RenglonField("Nombre", name, { name = it.take(40) }, placeholder = "Como quieras que te diga Relevo")
    SectionGap()
    SectionLabel("Intereses", Modifier.padding(bottom = 12.dp), soft = "Elige una o varias.")
    InterestGrid(interests, other, onToggle = { id -> interests = if (id in interests) interests - id else interests + id }, onOther = { other = it })
  }
  if (picking) {
    RelevoSheet(onDismiss = { picking = false }, title = "Emoji", done = "Listo", tall = true) {
      Spacer(Modifier.height(4.dp))
      EmojiGrid(image) { image = it }
    }
  }
}

/** Nombre corto de un interés para su anillo (4.3): una o dos palabras; la ruta conserva el nombre completo. */
private fun interestShort(id: String): String = when (id) {
  "dormir" -> "Dormir"
  "leer" -> "Leer"
  "ejercicio" -> "Ejercicio"
  "bici" -> "Bicicleta"
  "perro" -> "Perro"
  "dibujar" -> "Dibujar"
  "manualidades" -> "Manualidades"
  "cocinar" -> "Cocinar"
  "ordenar" -> "Ordenar"
  "meditar" -> "Meditar"
  "estudiar" -> "Estudiar"
  "videojuegos" -> "Videojuegos"
  "musica" -> "Música"
  "peliculas" -> "Películas"
  "compartir" -> "Compartir"
  else -> Interests.byId(id)?.label ?: "Otra"
}
