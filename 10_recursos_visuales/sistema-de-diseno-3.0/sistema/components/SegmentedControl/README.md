# SegmentedControl

Control segmentado: una pista en cápsula y una cápsula clara que se desliza hasta la opción elegida.

**Cuándo:** de dos a cinco opciones cortas y excluyentes (tema, tamaño del texto, una escala). Tocar la elegida la desmarca cuando la pregunta se puede omitir.

**Qué entrega quien lo usa:** `options` como `[valor, etiqueta]` o `{value, label}`, `value`, `onChange`, `label` para el grupo y `allowDeselect={false}` si la respuesta es obligatoria.

Escrito a mano desde `ui/components/Controls.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
