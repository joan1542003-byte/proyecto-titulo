# Relevo vivo: archivos

Copia de la propuesta 3.2 descrita en el [documento 29](../29_relevo-vivo-2026-10-03.md) y publicada como [lámina](https://claude.ai/artifact/VyeLFYsuWgkyJ45pkfywJL) (privada del autor).

- `relevo-vivo.html`: la lámina completa; carga Schibsted Grotesk, Playwrite CL e IBM Plex Mono de Google Fonts.
- `piezas/`: las catorce piezas en PNG a 2x (afiches, pantallas de la app, historia, tarjeta y láminas).
- `construccion/`: `palette-vivo.js` calcula la paleta en OKLCH y la guarda en `palette-vivo.json`; `build.js` arma la lámina desde `plantilla.html`; `export.js` exporta las piezas con Chrome sin interfaz. Se ejecutan en la carpeta de trabajo del sistema 3.1, junto a `color-lib.js`, `apps-lib.js`, `cdp.js` y `out/logo-geometry.json` (ver [sistema 3.1](../sistema-de-diseno-3.1/README.md)).

## Registro de cambios (disclaimer)

### 2026-10-03 — Creación

- **Qué cambió:** se guardaron la lámina, las piezas y el generador de la propuesta 3.2.
- **Cómo estaba antes:** la propuesta no existía.
- **Por qué:** el autor pidió colores más vivos y más personalidad, sin diseño genérico ni recargado.
