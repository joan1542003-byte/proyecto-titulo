# El traspaso: archivos

Copia de la propuesta 3.5 descrita en el [documento 33](../33_el-traspaso-2026-10-03.md) y publicada como [lámina](https://claude.ai/artifact/EG2Ta5ahzMU55sJrijL3fA) (privada del autor).

- `el-traspaso.html`: la lámina completa. Carga Familjen Grotesk, Schibsted Grotesk, IBM Plex Mono y las letras comparadas desde Google Fonts, y lleva las fotos dentro.
- `piezas/`: las diecinueve piezas en PNG a 2x: tres afiches de dato (`dato-*`), seis afiches del objeto (`afiche-*`), tres pantallas de la app (`app-*`), la historia, la tarjeta (frente y reverso) y cuatro láminas (`lamina-*`).
- `construccion/`:
  - `build.js` arma la lámina con `cuerpo.html` y `extra.css` sobre la plantilla de la 3.4 ([`../las-ganas-estaban-2026-10-03/construccion/v2/plantilla.html`](../las-ganas-estaban-2026-10-03/construccion/v2/plantilla.html)) y las fotos de [`../las-ganas-estaban-2026-10-03/construccion/fotos/`](../las-ganas-estaban-2026-10-03/construccion/fotos/);
  - `export.js` exporta las piezas en tema claro y `medir.js` mide qué parte de cada pantalla ocupa el color de actividad;
  - `paleta-lab.js` compara las tres familias de color y `logo-lab.js`, `logo-lab2.js` y `logo-lab3.js` comparan las letras y el gesto del logotipo.

  Los scripts se ejecutan en la carpeta de trabajo del sistema 3.1 (ver [sistema 3.1](../sistema-de-diseno-3.1/README.md)), de donde toman los íconos y el cálculo de contraste.

## Registro de cambios (disclaimer)

### 2026-10-03 — Creación

- **Qué cambió:** se guardaron la lámina, las piezas y el generador de la propuesta 3.5.
- **Cómo estaba antes:** la propuesta no existía; la última era la versión 2 de la 3.4.
- **Por qué:** el autor pidió no abusar de los colores, un logotipo con más carácter en una sans, colores que combinen todos entre sí y otras ideas en vez del subrayado.
