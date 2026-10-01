# TimeDots

El tiempo en puntos: cada punto es un minuto en las apps elegidas y los llenos son los que ya pasaron.

**Cuándo:** en la tarjeta del relevo activo (Inicio) y en el detalle, mientras Relevo cuenta. «6 de 15» se ve como seis puntos llenos.

**Qué entrega quien lo usa:** `value` (minutos contados) y `total` (minutos hasta la señal). Sobre 60 minutos, cada punto vale 5. `caption={false}` oculta la cifra cuando ya está escrita al lado.

**Accesibilidad:** los puntos se leen como «6 de 15 minutos»; la cifra escrita repite el dato, así que el color no es la única pista.

Nuevo en 3.0 (D-098 v3). Reemplaza a la barra de avance en la tarjeta del relevo activo.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
