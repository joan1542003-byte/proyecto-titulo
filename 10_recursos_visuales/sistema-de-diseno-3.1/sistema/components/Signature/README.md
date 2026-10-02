# Signature

La firma «Vuelve a ___.»: Relevo habla en Newsreader romana y la persona, en itálica sobre el renglón.

**Dos voces (D-073, en 3.1 tipográficas):** las palabras que escribió la persona se distinguen por la letra, no por el color: Newsreader itálica, en tinta. Así se evita el azul subrayado, que se lee como enlace, y la diferencia no depende del color.

**Cuándo:** la tarjeta del relevo activo (`variant="card"`), el título de un relevo (`title`) y la señal (`signal`). `sans` pone el comienzo en Schibsted Grotesk.

**Qué entrega quien lo usa:** `words` (lo que escribió la persona; se quita el punto final y se pasa la primera letra a minúscula), `variant`, `category` (el renglón toma el color de la actividad), `prefix` («Vuelve a » por omisión) y `animate`.

**Movimiento:** el renglón está desde el comienzo y las letras se escriben encima en 450 ms, lineal. Es la única animación de marca; si el sistema pide reducir el movimiento, aparece entera.

Escrito a mano desde `ui/components/Fields.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** guía de Signature actualizada a 3.1.
- **Cómo estaba antes:** seguía las reglas de 3.0.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
