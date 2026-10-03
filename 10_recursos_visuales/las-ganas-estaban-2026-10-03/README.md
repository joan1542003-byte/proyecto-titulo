# Las ganas estaban: archivos

Copia de la propuesta 3.4 descrita en el [documento 31](../31_las-ganas-estaban-2026-10-03.md) y publicada como [lámina](https://claude.ai/artifact/TLqwUeq6KhgbFXvbVRsXff) (privada del autor).

- `las-ganas-estaban.html`: la lámina completa. Carga Schibsted Grotesk e IBM Plex Mono de Google Fonts y lleva las fotos dentro.
- `piezas/`: las diecinueve piezas en PNG a 2x: tres afiches de dato (`dato-*`), seis afiches del objeto (`afiche-*`), tres pantallas de la app (`app-*`), la historia, la tarjeta (frente y reverso) y cuatro láminas (`lamina-*`).
- `construccion/`: `build.js` arma la lámina desde `plantilla.html` con los seis pares de color y un filtro SVG de duotono por par; `export.js` exporta las piezas en tema claro. `fotos/` tiene las seis fotos de la app en escala de grises y a 640 px: libro, acuarelas, apuntes y escritura son CC0; zapatillas y correa fueron generadas con IA (ver las [licencias de la app](../../06_desarrollo_y_factibilidad/app-android/licencias/README.md)). Los scripts se ejecutan en la carpeta de trabajo del sistema 3.1 (ver [sistema 3.1](../sistema-de-diseno-3.1/README.md)), de donde toman la geometría del logotipo, los íconos y el cálculo de contraste.

## Registro de cambios (disclaimer)

### 2026-10-03 — Creación

- **Qué cambió:** se guardaron la lámina, las piezas, el generador y las fotos de la propuesta 3.4.
- **Cómo estaba antes:** la propuesta no existía; la última era la versión 2 de la 3.3.
- **Por qué:** el autor pidió comunicar con lo que se sabe en vez de citar palabras de usuario, quitar la serif, no poner el marcador azul en todas las piezas y usar colores que combinen.
