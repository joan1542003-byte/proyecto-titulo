# ListRow

Fila dentro de una sección: ícono, texto, valor y destino. Al presionarla se oscurece.

**Qué entrega quien lo usa:**
- `title` y `subtitle` opcional;
- `icon` o `leading` (un Avatar, una miniatura);
- `value` alineado al final; con `valueIsVoice` va en `voice` porque lo escribió la persona;
- `trailing` (un RadioMark, un CheckMark), `chevron` y `onClick`.

**Medidas:** alto mínimo de 54 px; relleno de 12, 16, 12 y 18 px; el rótulo conserva su ancho hasta el 58 % y el valor usa el resto, con dos líneas como máximo.

**3.0:** la flecha de destino pasa de `gray` a `graphite`, por contraste.

Escrito a mano desde `ui/components/Lists.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
