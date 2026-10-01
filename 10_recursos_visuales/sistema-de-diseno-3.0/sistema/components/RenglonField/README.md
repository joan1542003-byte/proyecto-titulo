# RenglonField

El renglón: lo que escribe la persona, en tinta, sobre una línea azul.

**Cuándo:** el campo de la actividad, de cómo empieza y de dónde. Es el lugar donde la persona pone sus palabras; por eso es el recurso de marca dentro de la app.

**Qué entrega quien lo usa:** `label` (rótulo como frase), `placeholder` (un ejemplo real, en `graphite`), `value` y `onChange` (o `defaultValue`), `maxLength` (120).

**Medidas:** texto en `voice` (20/26, 500); línea de 1,5 px en `blue`, que pasa a 2,5 px con el foco; cursor azul.

**3.0:** en la app 2.18 el texto iba en azul sobre una línea de tinta. Ahora el texto es tinta y la línea es azul: el azul marca el lugar, no las palabras.

Escrito a mano desde `ui/components/Fields.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
