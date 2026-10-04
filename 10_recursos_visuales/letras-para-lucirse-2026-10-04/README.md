# Letras para lucirse: archivos

Copia de la propuesta 3.9 descrita en el [documento 37](../37_letras-para-lucirse-2026-10-04.md) y publicada como [lámina](https://claude.ai/artifact/YAVi4rd5H4tKPPXSAnn3rp) (privada del autor).

- `letras-para-lucirse.html`: la lámina completa, con los tableros incrustados como imágenes.
- `tableros/`: los 23 tableros (la letra grande, en cinco tintas, en cuatro tamaños, como ícono y en uso).
- `especimenes/`: seis hojas con los 113 especímenes de «relevo»: `hoja-pp-1` a `hoja-pp-3` (57 de Pangram Pangram, con pesos y cursivas) y `hoja-local-1` a `hoja-local-3` (56 de Fontshare, Velvetyne, Collletttivo, UNCUT y Le75). Cada celda lleva su número y la etiqueta de la letra y el peso.
- `datos/`: `datos-lamina.js` (las notas de cada tablero), `creditos-pangram-pangram.json` (autoría y licencia leídas en cada página), `especimenes-pangram-pangram.json` y `especimenes-locales.json` (las listas de especímenes, sin rutas locales), `fontshare-estilos.json` (los estilos de cada familia de Fontshare) y `descargas-github.json` (los zips de Velvetyne y Collletttivo que se abrieron).
- `construccion/`: los scripts. `sonda.js` lista las familias que carga la página de una fundición; `especimen.js` escribe «relevo» con familias concretas dentro de esa página; `fsBajar.js` y `ghBajar.js` bajan archivos de Fontshare y de GitHub; `espLocal.js` y `armarLocal.js` hacen los especímenes locales; `galeria.js` arma las hojas; `creditosPP.js` y `ff-cat.js` leen autorías y licencias; `tableros3.js` arma los tableros; `recortes.js`, el muestrario; `lamina3.js`, la página, y `previa3.js`, la vista previa en escritorio y teléfono. Se ejecutan en la carpeta de trabajo del sistema 3.1 (ver [sistema 3.1](../sistema-de-diseno-3.1/README.md)); las listas que leen se generan allí, con las rutas de los archivos descargados.

Las imágenes muestran la palabra «relevo» compuesta con cada letra para evaluarla. No se incluye ningún archivo de fuente.

## Registro de cambios (disclaimer)

### 2026-10-04 — Creación

- **Qué cambió:** se guardaron la lámina, los 23 tableros, las hojas de especímenes, los datos y los generadores de la propuesta 3.9.
- **Cómo estaba antes:** la propuesta no existía; la última era la 3.8.
- **Por qué:** el autor pidió letras display hermosas, hechas para lucirse en un logotipo.
