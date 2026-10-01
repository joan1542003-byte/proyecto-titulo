# PhotoHero

Foto grande con una banda de vidrio abajo: la foto sigue a la vista y el texto se lee sobre un desenfoque que crece hacia el borde, sin velos opacos.

**Qué entrega quien lo usa:** una imagen (`src`, `trama` o `icon`), el contenido de la banda como `children`, `aspect` (0,9), `dark` cuando la foto es oscura bajo el texto (la banda toma el tema oscuro) y `onClick` con `clickLabel` si toda la ficha se puede tocar.

Escrito a mano desde `ui/components/Photos.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
