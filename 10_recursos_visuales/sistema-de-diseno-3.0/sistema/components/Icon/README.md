# Icon

Un ícono del kit de Relevo (102 dibujos propios) en trazo, con el grosor que pide su tamaño.

**Cuándo:** siempre junto a una palabra, salvo en botones redondos con nombre accesible (`label`). Los íconos de acción y de estado son formas conocidas; los propios de Relevo (actividad, para empezar, lugar, parlante, apps elegidas) llevan el renglón en `blue`.

**Qué entrega quien lo usa:**
- `name`: uno de `Icon.names` (por ejemplo `inicio`, `inicio-lleno`, `actividad`, `senal`).
- `size`: 16, 18, 20, 22, 24, 34, 40 o 56 px.
- `strokeWidth`: por omisión sigue al tamaño (16 → 1,9; 20 → 1,8; 24 → 1,75; 32 → 1,6; más → 1,5). Junto a texto en 600 se usa 2,1.
- `color`: hereda `currentColor`. `mono` pinta también el renglón en ese color.
- `label`: solo si el ícono va sin palabra.

**Retícula:** 24 con área útil de 20, extremos y uniones redondeados, contorno para lo normal y relleno para lo elegido (`inicio-lleno`, `ruta-llena`, `perfil-lleno`). Los recortes son máscaras: el ícono funciona sobre cualquier fondo.

Escrito a mano desde `ui/components/Icons.kt y KitIcons.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0. 28 dibujos vienen de la propuesta D-098 (26 reemplazan a su par de la app; Ruta y Señal son nuevos) y 3 son sus versiones llenas.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
