# GuardedButton

Un botón que dice qué falta: si `missing` tiene texto, se ve apagado pero responde mostrando el aviso encima.

**Cuándo:** en pasos con campos obligatorios («Seguir» sin actividad escrita). Reemplaza al botón deshabilitado, que no explica nada.

**Qué entrega quien lo usa:** `missing` (qué falta, como frase: «Escribe qué quieres hacer o toca una idea.») o `null`; `onClick`; `onMissing` para registrar qué faltó.

**Comportamiento:** el primer toque muestra el aviso (MissingHint) y vibra; si se toca otra vez, el aviso crece un instante. El aviso es neutro, nunca rojo: no es un error de la persona. Al completar lo que faltaba, se va.

Escrito a mano desde `ui/components/Controls.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0. Nuevo en la app 2.18 (D-097).

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
