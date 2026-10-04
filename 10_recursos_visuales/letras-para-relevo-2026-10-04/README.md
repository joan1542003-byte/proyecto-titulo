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
- `letras-para-relevo-v2.html`: la versión 2, con las 30 finalistas. `tableros-ronda2/` tiene los 12 tableros nuevos; `hojas/hoja2-1.png` a `hoja2-3.png`, las letras 177 a 264; `hojas/indice2.json`, su numeración; `hojas/uncut-enlaces.json`, las 163 letras de UNCUT con su autoría, licencia y enlace; y `hojas/uncut-descargas.json`, los 84 archivos descargados.
- `construccion/ronda2/`: los scripts de la segunda ronda: `enlaces.js` y `nombres.js` leen UNCUT; `descargar.js`, `descargar2.js` y `otros.js` bajan los archivos; `extraer.js` los abre; `uncut-render.js` y `openfoundry-run.js` escriben «relevo» con cada letra; `hojas2.js`, `tableros2.js` y `lamina2-build.js` arman las hojas, los tableros y la lámina. Los archivos de fuente descargados no se incluyen.

Las imágenes muestran la palabra «relevo» compuesta con cada letra para evaluarla. No se incluye ningún archivo de fuente.

## Registro de cambios (disclaimer)

### 2026-10-04 — Versión 2

- **Qué cambió:** se suman la lámina, los tableros, las hojas, los índices y los scripts de la segunda ronda.
- **Cómo estaba antes:** la carpeta tenía solo la primera ronda.
- **Por qué:** el autor dio permiso para descargar lo que quisiera de las fuentes que quisiera y pidió explorar más.

### 2026-10-04 — Creación

- **Qué cambió:** se guardaron la lámina, los 18 tableros, las cinco hojas con las 176 letras y los generadores de la propuesta 3.7.
- **Cómo estaba antes:** la propuesta no existía; la última era la 3.6.
- **Por qué:** el autor pidió explorar más tipografías, con más licencias y sin Google Fonts en el logotipo, y tener una variedad de elecciones.
