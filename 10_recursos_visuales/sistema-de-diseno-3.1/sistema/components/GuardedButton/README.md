# GuardedButton

Un botón que dice qué falta: si `missing` tiene texto, se ve apagado pero responde mostrando el aviso encima.

**Cuándo:** en pasos con campos obligatorios («Seguir» sin actividad escrita). Reemplaza al botón deshabilitado, que no explica nada.

**Qué entrega quien lo usa:** `missing` (qué falta, como frase: «Escribe qué quieres hacer o toca una idea.») o `null`; `onClick`; `onMissing` para registrar qué faltó.

**Comportamiento:** el primer toque muestra el aviso (MissingHint) y vibra; si se toca otra vez, el aviso crece un instante. El aviso es neutro, nunca rojo: no es un error de la persona. Al completar lo que faltaba, se va.

Escrito a mano desde `ui/components/Controls.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0. Nuevo en la app 2.18 (D-097).

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** se copia a la carpeta 3.1 sin cambios de contenido.
- **Cómo estaba antes:** solo estaba en la carpeta 3.0.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
