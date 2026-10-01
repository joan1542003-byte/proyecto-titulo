# Signature

La firma «Vuelve a ___.»: las palabras de la persona en tinta, sobre el renglón azul.

**Cuándo:** la tarjeta del relevo activo (`variant="card"`), el título de un relevo (`title`) y la señal (`signal`). `sans` repite la firma de la app 2.18.

**Qué entrega quien lo usa:** `words` (lo que escribió la persona; se quita el punto final y se pasa la primera letra a minúscula), `variant`, `prefix` («Vuelve a » por omisión) y `animate`.

**Movimiento:** el renglón está desde el comienzo y las letras se escriben encima en 450 ms, lineal. Es la única animación de marca; si el sistema pide reducir el movimiento, aparece entera.

**3.0:** titulares en serif (Newsreader 380) y el renglón azul bajo la frase de la persona, en vez de texto azul con línea de tinta.

Escrito a mano desde `ui/components/Fields.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
