# Trama

La trama de puntos: una foto, un fondo o un ícono hecho de puntos en una sola tinta.

**Cuándo:** solo en momentos de marca. La señal (`mode="senal"`, late mientras suena), la foto de la actividad activa en Inicio (`mode="foto"`), portadas y afiches (`mode="campo"`) y los íconos grandes de momentos de marca (`mode="icono"`).

**Qué entrega quien lo usa:**
- un contenedor con tamaño: el lienzo lo ocupa entero;
- `mode` y, según el modo, `src` (una foto del mismo origen), `icon` y `grid` (12 o 16);
- `color`: en 3.1, una categoría o una familia de la casa. Por omisión, el azul. La señal y el sistema van en azul; la foto de una actividad, en el color de su categoría;
- `pitch`: 6 px en pantalla, 4 px en fotos pequeñas; `label` si la trama comunica algo.

**Reglas:** el punto crece con la sombra, de 16 % a 104 % de la distancia entre puntos. Todo texto encima va en una tarjeta. La animación se detiene fuera de la vista y cuando el sistema pide reducir el movimiento.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** guía de Trama actualizada a 3.1.
- **Cómo estaba antes:** seguía las reglas de 3.0.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
