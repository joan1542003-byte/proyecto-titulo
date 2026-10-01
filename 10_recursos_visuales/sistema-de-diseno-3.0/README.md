# Sistema de diseño 3.0: archivos

Copia en el repositorio del [sistema de diseño de Relevo](https://claude.ai/artifact/SsGWeeHPHxxkXrCKN1WW8x) publicado en el tipo Design System de claude.ai (página privada del autor). El documento que lo explica es el [26](../26_sistema-de-diseno-3.0-2026-10-01.md).

## Carpetas

- **`sistema/`**: los archivos del sistema tal como se publicaron bajo `project/`:
  - el libro de marca: `README.md` y las secciones `01` a `07`;
  - `tokens.json`;
  - los componentes: `components/bundle.js`, `bundle.css`, `index.d.ts` y una carpeta por componente con su guía y su vista previa;
  - la portada (`components/Cover`) y la página de muestra `components/Pantallas`;
  - `design-system.json`, el índice con los identificadores de los recursos subidos;
  - las notas de cada grupo de recursos.

  Aquí cada Markdown lleva su registro de cambios, como pide el repositorio; en la versión publicada no está. La fuente Schibsted Grotesk no se duplica: está en `06_desarrollo_y_factibilidad/app-android/app/src/main/res/font/`.
- **`recursos/`**: los SVG subidos como recursos: 102 íconos, 6 del logotipo y del ícono de la app, y 10 de la trama. Las 6 fotos CC0 están en `app/src/main/res/drawable-nodpi/` (`foto_libro`, `foto_escribir`, `foto_aprender`, `foto_guitarra`, `foto_pan` y `foto_pintar`).
- **`construccion/`**: los programas que generan todo lo anterior a partir de la app y de la lámina D-098 v3:
  - `parse-kit.js` lee `KitIcons.kt` y produce `kit-icons.json`.
  - `build-assets.js` arma los íconos, el logotipo, el ícono de la app y los campos de trama.
  - `gen-dots.js` prepara la página que calcula en Chrome los íconos en trama y la foto en trama.
  - `tokens.js` escribe `tokens.json`.
  - `components.js` escribe el paquete, las guías y las vistas previas a partir de `bundle-src.js`.
  - `ids-de-recursos.json` guarda el identificador de cada recurso subido.

## Volver a generar

Desde `construccion/`, con Node 18 o posterior:

1. `node parse-kit.js ../../../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/components/KitIcons.kt`, solo si cambian los íconos de la app.
2. `node build-assets.js`.
3. `node gen-dots.js`. Luego, abrir `gen-dots.html` con Chrome sin interfaz (`--headless=new --dump-dom`) y guardar como SVG cada entrada del JSON que aparece en la página, en `recursos/Trama/`.
4. `node tokens.js` y `node components.js`.

Para actualizar la página publicada, se publican solo los archivos que cambiaron, con el índice al final. Un recurso nuevo se sube primero y su identificador se agrega al índice. Las reglas del tipo están en su `SKILL.md`, que se lee desde la página.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se guardaron los archivos del sistema de diseño 3.0, sus recursos y los programas que los generan.
- **Cómo estaba antes:** la identidad D-098 existía solo como lámina y documento; no había tokens, componentes web ni recursos sueltos.
- **Por qué:** el autor pidió desarrollar el sistema gráfico y pasarlo a Claude Design; el repositorio es la fuente de verdad.
