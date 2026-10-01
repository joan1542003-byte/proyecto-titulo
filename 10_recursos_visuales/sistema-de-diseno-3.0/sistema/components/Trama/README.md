# Trama

La trama de puntos: una foto, un fondo o un ícono hecho de puntos en una sola tinta azul.

**Cuándo:** solo en momentos de marca. La señal (`mode="senal"`, late mientras suena), las fotos de actividades en Inicio (`mode="foto"`), portadas y afiches (`mode="campo"`) y los íconos grandes de momentos de marca (`mode="icono"`). No va en cada pantalla.

**Qué entrega quien lo usa:**
- un contenedor con tamaño: el lienzo lo ocupa entero;
- `mode` y, según el modo, `src` (una foto del mismo origen), `icon` y `grid` (12 o 16);
- `pitch`: 6 px en pantalla (por omisión), 4 px en fotos pequeñas;
- `label` si la trama comunica algo (una foto de actividad); si es fondo, se oculta a los lectores de pantalla.

**Reglas:**
- El punto crece con la sombra, de 16 % a 104 % de la distancia entre puntos.
- Todo texto sobre la trama va en una tarjeta de vidrio o sólida; nunca suelto encima.
- La animación se detiene fuera de la vista y cuando el sistema pide reducir el movimiento.

Nuevo en 3.0 (D-098 v3): la trama son los píxeles de la pantalla y la rejilla del parlante.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
