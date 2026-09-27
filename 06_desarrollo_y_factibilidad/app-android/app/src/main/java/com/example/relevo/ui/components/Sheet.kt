package com.example.relevo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.relevo.theme.Relevo

/**
 * Hoja inferior como las de iOS: sube desde abajo, se cierra arrastrándola o con «Listo», y deja la
 * pantalla de atrás a la vista. Papel, esquinas de 20 y una barra de arrastre.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelevoSheet(
  onDismiss: () -> Unit,
  title: String? = null,
  done: String? = null,
  scrollable: Boolean = true,
  content: @Composable ColumnScope.() -> Unit,
) {
  val colors = Relevo.colors
  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    containerColor = colors.paper,
    contentColor = colors.ink,
    scrimColor = Color.Black.copy(alpha = if (colors.isDark) .5f else .28f),
    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
    dragHandle = { Box(Modifier.padding(top = 10.dp, bottom = 6.dp).width(36.dp).height(5.dp).background(colors.line, RoundedCornerShape(3.dp))) },
  ) {
    Column(
      Modifier.fillMaxWidth().then(if (scrollable) Modifier.verticalScroll(rememberScrollState()) else Modifier)
        .padding(horizontal = Relevo.margin).padding(bottom = 16.dp).navigationBarsPadding(),
    ) {
      if (title != null || done != null) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
          Text(title.orEmpty(), style = Relevo.type.title2, color = colors.ink, modifier = Modifier.weight(1f))
          if (done != null) PlainAction(done, onDismiss)
        }
        Spacer(Modifier.height(8.dp))
      }
      content()
    }
  }
}
