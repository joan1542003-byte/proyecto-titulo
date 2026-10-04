# Letras para relevo: archivos

Copia de la propuesta 3.7 descrita en el [documento 35](../35_letras-para-relevo-2026-10-04.md) y publicada como [lámina](https://claude.ai/artifact/R9eHYeUaWooRcPjXqvC2B6) (privada del autor).

- `letras-para-relevo.html`: la lámina completa, con los tableros incrustados como imágenes.
- `tableros/`: los 18 tableros de las finalistas (la letra grande, en cinco tintas, en cuatro tamaños, como ícono y en uso).
- `hojas/`: las cinco hojas con las 176 letras numeradas e `indice.json`, que asocia cada número con su letra y su fuente.
- `construccion/`:
  - `pangram-run.js`, `sitios-run.js` y `fontshare-run.js` escriben «relevo» con cada letra, dentro de la página de su fundición o con la hoja de estilo pública de Fontshare; no guardan archivos de fuentes;
  - `hojas.js` y `cortas.js` arman las hojas de contacto y la segunda ronda;
  - `tableros.js` genera los tableros de las finalistas;
  - `creditos.js` lee la autoría y la licencia de la página de cada letra;
  - `lamina-build.js` arma la lámina.

  Se ejecutan en la carpeta de trabajo del sistema 3.1 (ver [sistema 3.1](../sistema-de-diseno-3.1/README.md)).

Las imágenes muestran la palabra «relevo» compuesta con cada letra para evaluarla. No se incluye ningún archivo de fuente.

## Registro de cambios (disclaimer)

### 2026-10-04 — Creación

- **Qué cambió:** se guardaron la lámina, los 18 tableros, las cinco hojas con las 176 letras y los generadores de la propuesta 3.7.
- **Cómo estaba antes:** la propuesta no existía; la última era la 3.6.
- **Por qué:** el autor pidió explorar más tipografías, con más licencias y sin Google Fonts en el logotipo, y tener una variedad de elecciones.
