# Wordmark

El logotipo «relevo» en minúsculas sobre su renglón azul: la firma de todas las piezas.

**Cuándo:** en la barra de Inicio, la señal, portadas, afiches y la primera diapositiva. Una vez por pantalla o pieza.

**Qué entrega quien lo usa:**
- `size`: alto de las letras en px (22 en la barra de la app; nunca menos de 16, que da 64 px de ancho).
- `tone`: `ink` (tinta y renglón `blue`; en tema oscuro se aclara solo), `paper` (papel y renglón `azul-300`, sobre tinta) u `on-blue` (todo en `on-blue`, sobre un fondo `blue`).
- `line={false}` solo donde el renglón ya está en otra parte de la pieza.

**Construcción:** contornos de Schibsted Grotesk 650 con −3 %. El renglón mide el ancho de la palabra y 0,075 em de alto, con su borde superior a 0,236 em bajo la línea base.

**No:** no se escribe con mayúscula, no se dibuja en azul (azul con renglón azul se lee como enlace), no se estira ni se pone sobre la trama sin una tarjeta.

Escrito a mano desde `ui/components/Icons.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0. El renglón viene de D-098.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
