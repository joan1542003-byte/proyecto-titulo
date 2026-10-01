# GlassIconButton

Botón redondo de vidrio para la barra: volver, cerrar, más opciones.

**Cuándo:** solo en la capa de navegación (barra superior, sobre fotos que llegan al borde). El vidrio deja ver, desenfocado, lo que pasa detrás.

**Qué entrega quien lo usa:** `icon`, `label` y `onClick`. `size`: 44 px por omisión.

**Reglas:** el vidrio es `glass` con un desenfoque de 12 px y un borde de 0,75 px en `glass-edge`. Sin brillos, reflejos ni degradados de luz. El contenido nunca va en vidrio.

Escrito a mano desde `ui/components/Glass.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
