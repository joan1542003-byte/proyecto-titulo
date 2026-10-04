# Letras que dicen relevo: archivos

Copia de la propuesta 3.8 descrita en el [documento 36](../36_letras-que-dicen-relevo-2026-10-04.md) y publicada como [lámina](https://claude.ai/artifact/C8C9apN8tayiAoPERJ9gxZ) (privada del autor).

- `letras-que-dicen-relevo.html`: la lámina completa, con las láminas de lectura incrustadas como imágenes.
- `fichas/`: las 14 láminas de lectura (la palabra grande, cada letra con sus notas numeradas y pruebas en azul, a tres tamaños, con la firma y como ícono) y `anchos32.json`, con lo que mide «relevo» a 32 px en cada letra.
- `mesa/` y `mesa2/`: las 14 tandas de la mesa de análisis, con 108 letras escritas en grande, con la firma y los acentos. Los números de cada tarjeta siguen el orden de `datos/candidatas-mesa-1.json` y `datos/candidatas-mesa-2.json` (la segunda empieza en 101).
- `hojas/`: las hojas de contacto de las 61 letras nuevas, con `indice-le75.json` (números 265 a 307) e `indice-nuevas.json` (308 a 325). Siguen la numeración de las hojas de la [propuesta 3.7](../letras-para-relevo-2026-10-04/README.md), que llegaba a 264.
- `datos/`: `fichas-datos.js` (las notas de cada ficha), `cobertura.json` (minúsculas y acentos de cada candidata), las dos listas de candidatas sin rutas locales, `descargas.json` (el registro de las descargas) y `freefaces.json` (las 42 letras display de Free Faces Gallery).
- `construccion/`: los scripts. `freefaces-lista.js` y `freefaces-fichas.js` leen Free Faces Gallery; `le75-bajar.js`, `bajarWeb.js` y `renderLocal.js` bajan y escriben «relevo» con cada letra; `hoja.js` arma las hojas; `armarLista.js` y `armarLista2.js` reúnen las candidatas; `analisis.js` hace la mesa; `lupa.js`, las lupas; `cobertura.js`, la prueba de acentos; `fvar.js`, los ejes de una fuente variable; `fichas.js`, las láminas de lectura; `lamina.js`, la página, y `previa.js`, la vista previa en escritorio y teléfono. Se ejecutan en la carpeta de trabajo del sistema 3.1 (ver [sistema 3.1](../sistema-de-diseno-3.1/README.md)); las listas de candidatas que leen se generan allí, con las rutas de los archivos descargados.

Las imágenes muestran la palabra «relevo» compuesta con cada letra para evaluarla. No se incluye ningún archivo de fuente.

## Registro de cambios (disclaimer)

### 2026-10-04 — Creación

- **Qué cambió:** se guardaron la lámina, las 14 láminas de lectura, la mesa de análisis, las hojas de las 61 letras nuevas, los datos y los generadores de la propuesta 3.8.
- **Cómo estaba antes:** la propuesta no existía; la última era la 3.7.
- **Por qué:** el autor pidió buscar más letras de tipo display y analizarlas, viéndolas y leyendo qué conceptos de Relevo evocan.
