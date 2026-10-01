# PlainAction

Una acción de texto, con área táctil de 48 px.

**Cuándo:** acciones secundarias dentro de una sección o un aviso («Ver todas», «Probar otra vez») y el cierre de una hoja sin vidrio.

**Qué entrega quien lo usa:** la etiqueta, `onClick`, `icon` opcional y `color` (`ink` por omisión; `graphite` para acciones menores).

**Comportamiento:** al presionar baja a la mitad de opacidad.

Escrito a mano desde `ui/components/Controls.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
