# CheckMark

Marca de selección redonda: el círculo se llena de tinta y la marca se dibuja con el trazo.

**Cuándo:** listas con varias elecciones (apps elegidas, intereses) y la esquina de una PictureTile elegida.

**Qué entrega quien lo usa:** `checked` y `size` (24 px; 22 en fichas). Va dentro de un control que tiene el rol y el nombre.

**3.0:** el borde sin marcar pasa de `gray` (2,56:1 sobre `card`) a `graphite` (6,23:1), para que el control se vea con 3:1 o más.

Escrito a mano desde `ui/components/Controls.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
