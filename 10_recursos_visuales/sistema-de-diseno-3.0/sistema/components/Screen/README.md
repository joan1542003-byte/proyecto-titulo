# Screen

Marco de pantalla de la app: barra de vidrio arriba, título, contenido que se desplaza y una acción principal flotante abajo.

**Qué entrega quien lo usa:**
- `title` (en serif `displayTitle` en 3.0; `serif={false}` vuelve a `largeTitle`), `eyebrow` y `subtitle`;
- `onBack` con `closeIcon` en las hojas de creación;
- `progress` y `step` para recorridos por pasos;
- `trailing`, `header` y `bottom` (la acción principal);
- el contenido como `children` y un contenedor con alto (`height`).

**Comportamiento:** el contenido pasa bajo la barra y se desenfoca; el título sube a la barra al desplazar. Margen de 20 px.

Escrito a mano desde `ui/components/Screen.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0. Versión web simplificada: sin la foto que llega al borde superior ni el tono de la barra de estado.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
