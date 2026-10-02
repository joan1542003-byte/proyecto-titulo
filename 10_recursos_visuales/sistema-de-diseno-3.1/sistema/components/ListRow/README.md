# ListRow

Fila dentro de una sección: ícono, texto, valor y destino. Al presionarla se oscurece.

**Qué entrega quien lo usa:**
- `title` y `subtitle` opcional;
- `icon` o `leading` (un Avatar, una miniatura);
- `value` alineado al final; con `valueIsVoice` va en la voz de la persona (Newsreader itálica, en tinta), porque lo escribió ella;
- `trailing` (un RadioMark, un CheckMark), `chevron` y `onClick`.

**Medidas:** alto mínimo de 54 px; relleno de 12, 16, 12 y 18 px; el rótulo conserva su ancho hasta el 58 % y el valor usa el resto, con dos líneas como máximo.

**3.0:** la flecha de destino pasa de `gray` a `graphite`, por contraste.

Escrito a mano desde `ui/components/Lists.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** guía de ListRow actualizada a 3.1.
- **Cómo estaba antes:** seguía las reglas de 3.0.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
