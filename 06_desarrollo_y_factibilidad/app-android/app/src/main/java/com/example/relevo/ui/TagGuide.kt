package com.example.relevo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo
import com.example.relevo.ui.components.KitIcon
import com.example.relevo.ui.components.RelevoIcon
import com.example.relevo.ui.components.RelevoSheet

/**
 * Cómo usar el llavero (D-109): encenderlo, apagarlo, callarlo, saber si está encendido, la pila y
 * qué hacer si no aparece. Vale para el iTag clásico, como el NEWOTAG-BL que se compró para la prueba.
 * Se abre desde el panel del llavero en preparar y desde Perfil › Ayuda.
 */
@Composable
internal fun TagGuideSheet(onDismiss: () -> Unit) {
  RelevoSheet(onDismiss = onDismiss, title = "Cómo usar el llavero", done = "Listo") {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
      TagGuideItem(KitIcon.LISTO, "Encenderlo", "Mantén apretado el botón unos 3 segundos, hasta que pite dos veces. Queda encendido hasta que lo apagues o se acabe la pila: no hay que encenderlo cada vez.")
      TagGuideItem(KitIcon.SILENCIAR, "Callarlo cuando suena", "Toca el botón una vez. No lo mantengas apretado: así se apaga.")
      TagGuideItem(KitIcon.DETENER, "Apagarlo", "Mantén apretado el botón unos 3 segundos, hasta que dé un pitido largo. Durante la prueba, déjalo encendido.")
      TagGuideItem(KitIcon.BUSCAR, "Saber si está encendido", "Búscalo en Relevo: en «¿Dónde suena?», toca «El llavero» y «Buscar el llavero». Si aparece en la lista, está encendido.")
      TagGuideItem(KitIcon.BATERIA, "La pila", "Usa una pila de botón CR2032, que dura meses. Para cambiarla, abre la tapa por la ranura del borde con una uña o una moneda y pon la nueva igual que la anterior, con el «+» hacia el mismo lado.")
      TagGuideItem(KitIcon.CONEXION, "Si no aparece", "El llavero se conecta a un solo teléfono a la vez. Cierra apps como iSearching y, si lo usaste con otro teléfono, apaga su Bluetooth o elige «Omitir este dispositivo» u «Olvidar».")
    }
  }
}

@Composable
private fun TagGuideItem(icon: KitIcon, title: String, text: String) {
  val colors = Relevo.colors
  Row(verticalAlignment = Alignment.Top) {
    Box(Modifier.size(40.dp).clip(CircleShape).background(colors.mist), contentAlignment = Alignment.Center) {
      RelevoIcon(icon, size = 22.dp, background = colors.mist)
    }
    Spacer(Modifier.width(14.dp))
    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
      Text(title, style = Relevo.type.headline, color = colors.ink)
      Text(text, style = Relevo.type.subhead, color = colors.graphite)
    }
  }
}
