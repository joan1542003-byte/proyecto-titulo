package com.example.relevo.ui.components

import androidx.compose.ui.graphics.vector.PathParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Los íconos de la 4.8 (D-187) salen de Lucide y de los SVG propios por un generador. Estas pruebas cuidan que
 * Android lea cada trazado completo y que ningún dibujo diga dos cosas (regla 1 de D-162).
 */
class KitIconsTest {
  private val command = Regex("([MmLlHhVvCcSsQqTtAaZz])([^MmLlHhVvCcSsQqTtAaZz]*)")
  private val number = Regex("[-+]?(?:\\d+\\.?\\d*|\\.\\d+)(?:[eE][-+]?\\d+)?")
  private val arguments = mapOf('M' to 2, 'L' to 2, 'H' to 1, 'V' to 1, 'C' to 6, 'S' to 4, 'Q' to 4, 'T' to 2, 'A' to 7, 'Z' to 0)

  /** Cuántos pasos debería leer el parser: uno por cada grupo completo de números de cada comando. */
  private fun expectedNodes(pathData: String): Int = command.findAll(pathData).sumOf { match ->
    val perStep = arguments.getValue(match.groupValues[1].uppercase()[0])
    val numbers = number.findAll(match.groupValues[2]).count()
    if (perStep == 0) 1 else numbers / perStep
  }

  @Test fun everyIconHasAtLeastOneShape() {
    KitIcon.entries.forEach { assertTrue("${it.name} no tiene formas", it.shapes.isNotEmpty()) }
  }

  @Test fun androidReadsEveryStepOfEveryPath() {
    KitIcon.entries.forEach { icon ->
      icon.shapes.forEach { shape ->
        val nodes = PathParser().parsePathString(shape.pathData).toNodes()
        assertEquals("${icon.name}: «${shape.pathData}»", expectedNodes(shape.pathData), nodes.size)
      }
    }
  }

  @Test fun arcFlagsAreWrittenApart() {
    // El SVG permite «A5 5 0 0012 5», con las banderas pegadas; el generador las separa para que Android no lea «0012».
    KitIcon.entries.forEach { icon ->
      icon.shapes.forEach { shape ->
        command.findAll(shape.pathData).filter { it.groupValues[1] in setOf("A", "a") }.forEach { arc ->
          val values = number.findAll(arc.groupValues[2]).map { it.value }.toList()
          assertEquals("${icon.name}: un arco lleva siete números", 0, values.size % 7)
          values.chunked(7).forEach { step ->
            assertTrue("${icon.name}: bandera ${step[3]}", step[3] == "0" || step[3] == "1")
            assertTrue("${icon.name}: bandera ${step[4]}", step[4] == "0" || step[4] == "1")
          }
        }
      }
    }
  }

  @Test fun noTwoIconsShareADrawing() {
    // La estrella llena y la vacía tienen el mismo trazado, pero una va rellena: no son el mismo dibujo.
    val drawings = KitIcon.entries.groupBy { icon -> icon.shapes.map { it.pathData to it.fill } }
    val repeated = drawings.values.filter { it.size > 1 }.map { group -> group.map { it.name } }
    assertTrue("Íconos con el mismo dibujo: $repeated", repeated.isEmpty())
  }
}
