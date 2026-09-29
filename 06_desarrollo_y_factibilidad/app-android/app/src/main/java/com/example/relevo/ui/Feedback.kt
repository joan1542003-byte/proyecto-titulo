package com.example.relevo.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cl.udp.relevo.R
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.Panel
import com.example.relevo.ui.components.PlainAction

/** Una cara de Google (Noto 3D, SIL OFL 1.1) con su nombre, para responder con un toque. */
internal data class Face(val value: String, @param:DrawableRes val res: Int, val label: String)

/** Cómo le cayó el aviso: se guarda con el relevo (signal_feeling). */
internal val feelingFaces = listOf(
  Face("good", R.drawable.emoji_1f642, "Bien"),
  Face("neutral", R.drawable.emoji_1f610, "Normal"),
  Face("bad", R.drawable.emoji_1f615, "Mal"),
)

/** Opinión rápida sobre Relevo, de 1 a 5. */
internal val ratingFaces = listOf(
  Face("1", R.drawable.emoji_1f61e, "Muy mal"),
  Face("2", R.drawable.emoji_1f615, "Mal"),
  Face("3", R.drawable.emoji_1f610, "Normal"),
  Face("4", R.drawable.emoji_1f642, "Bien"),
  Face("5", R.drawable.emoji_1f604, "Muy bien"),
)

/** Caras en una fila, todas del mismo tamaño. Tocar la elegida la desmarca. */
@Composable
internal fun FacePicker(faces: List<Face>, selected: String?, onSelect: (String?) -> Unit, size: Dp = 48.dp) {
  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
    faces.forEach { face ->
      val on = face.value == selected
      Column(
        Modifier
          .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, role = Role.RadioButton) { onSelect(if (on) null else face.value) }
          .semantics(mergeDescendants = true) { contentDescription = face.label; this.selected = on },
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Box(
          Modifier.size(size + 12.dp).clip(CircleShape)
            .background(if (on) Relevo.colors.card else Relevo.colors.mist)
            .then(if (on) Modifier.border(2.dp, Relevo.colors.ink, CircleShape) else Modifier),
          contentAlignment = Alignment.Center,
        ) {
          Image(painterResource(face.res), contentDescription = null, modifier = Modifier.size(size))
        }
        Spacer(Modifier.height(6.dp))
        Text(face.label, style = Relevo.type.footnote, color = if (on) Relevo.colors.ink else Relevo.colors.graphite, textAlign = TextAlign.Center)
      }
    }
  }
}

/**
 * Tarjeta de Inicio tras el tercer y el décimo relevo respondidos: una pregunta y cinco caras.
 * Tocar una cara la envía; «Contar más» abre la opinión con comentario.
 */
@Composable
internal fun QuickFeedbackCard(onAnswer: (Int?) -> Unit, onMore: () -> Unit) {
  Panel {
    Text("¿Qué tal te va con Relevo?", style = Relevo.type.headline, color = Relevo.colors.ink)
    Text("Toca una cara. Nos ayuda a mejorarlo.", style = Relevo.type.subhead, color = Relevo.colors.graphite)
    Spacer(Modifier.height(4.dp))
    FacePicker(ratingFaces, null, { value -> value?.toIntOrNull()?.let(onAnswer) }, size = 36.dp)
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      PlainAction("Contar más", onMore, icon = KitIcon.COMENTARIO)
      PlainAction("Ahora no", { onAnswer(null) }, color = Relevo.colors.graphite)
    }
  }
}
