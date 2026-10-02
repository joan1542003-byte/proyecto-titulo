# Sistema de diseño 3.1: archivos

Copia en el repositorio del [sistema de diseño de Relevo](https://claude.ai/artifact/SsGWeeHPHxxkXrCKN1WW8x) tal como quedó publicado el 2 de octubre de 2026 en el tipo Design System de claude.ai (página privada del autor). El documento que lo explica es el [27](../27_sistema-de-diseno-3.1-2026-10-02.md). La versión anterior sigue en [`../sistema-de-diseno-3.0/`](../sistema-de-diseno-3.0/README.md).

## Carpetas

- **`sistema/`**: los archivos publicados bajo `project/`:
  - el libro de marca: `README.md` y las secciones `01-voz-y-tono` a `10-fundamentos`;
  - `tokens.json` (117 colores, 23 estilos de letra);
  - los componentes: `components/bundle.js` (46 componentes), `bundle.css`, `index.d.ts` y una carpeta por componente con su guía y su vista previa;
  - la portada (`components/Cover`) y las páginas de muestra `Pantallas`, `Logotipo`, `Tipografia`, `Paleta`, `Iconografia`, `Patrones`, `Ilustraciones`, `Afiches`, `Redes`, `Presentacion`, `Impresos`, `Objeto` y `Movimiento`;
  - `design-system.json`, el índice con los 230 recursos subidos (106 de 3.1 y 124 de 3.0);
  - las notas de cada grupo de recursos en `assets/`.

  Cada Markdown lleva aquí su registro de cambios; en la versión publicada no está. La fuente Schibsted Grotesk no se duplica: está en `06_desarrollo_y_factibilidad/app-android/app/src/main/res/font/`.
- **`recursos/`**: los archivos subidos en 3.1, más la firma sonora en WAV:
  - `Logotipo/` (29): logotipo y sus versiones, renglón por categoría, firmas, símbolo, íconos de la app, capas Android, construcción y exploración;
  - `Iconos/` (33): los íconos nuevos de 3.1 (los 102 de 3.0 están en la carpeta 3.0);
  - `Ilustraciones/` (6), `Patrones/` (11) y `Color/` (la lámina de la paleta);
  - `Aplicaciones/` (24 PNG): afiches, redes, láminas, portada de la memoria, objeto, tarjeta y stickers;
  - `Movimiento/`: el logotipo animado (MP4), su último cuadro y `firma-sonora.wav`.
- **`construccion/`**: los programas que generan todo lo anterior:
  - `ttf.js` lee la fuente variable (contornos, variaciones y kerning) y convierte texto en trazados SVG en cualquier peso.
  - `color-lib.js` y `palette2.js` calculan la paleta en OKLCH, el contraste WCAG y la simulación de visión del color; `palette-report.js` imprime el contraste y las distancias entre firmas.
  - `gen-logo.js` hace la familia del logotipo; `gen-explore.js`, las láminas de exploración.
  - `icons31.js` define los 33 íconos nuevos; `gen-assets31.js` los escribe junto con los patrones y la lámina de color; `gen-illus.js` dibuja las ilustraciones.
  - `apps-lib.js` y `gen-apps.js` arman y capturan las 24 aplicaciones; `gen-motion.js`, el logotipo animado y la firma sonora (con ffmpeg); `cdp.js` maneja Chrome sin interfaz.
  - En `build/`: `tokens31.js` lleva `tokens.json` de 3.0 a 3.1; `bundle31-patch.js` es el cambio que ya se aplicó a `bundle-src.js`; `make-components31.js` adapta `components.js` (el generador de 3.0) y escribe los componentes; `make-cards31.js` escribe las páginas de muestra; `index31.js`, el índice.
  - `ids31.txt` e `ids-de-recursos.json` guardan el identificador y el tamaño de cada recurso subido.

## Volver a generar

Los programas esperan una carpeta de trabajo con esta forma: los programas de `construccion/`, `out/` (lo que aquí es `recursos/`), `relevo/project/` (lo que aquí es `sistema/`) y una copia de la fuente de la app como `schibsted.ttf`. Con Node 22 o posterior, ffmpeg y Chrome (ruta en la variable `CHROME_PATH`):

1. `node palette2.js` (paleta) y `node gen-logo.js`, `node gen-explore.js`, `node gen-assets31.js`, `node gen-illus.js`.
2. `node gen-apps.js` y `node gen-motion.js`.
3. Desde `build/`: `node tokens31.js` (solo sobre el `tokens.json` de 3.0), `node make-components31.js` y luego `node components31.js`, `node make-cards31.js` y, después de subir los recursos nuevos y anotar sus identificadores en `ids31.txt`, `node index31.js`.

Para actualizar la página publicada se suben primero los recursos, después los archivos que cambiaron y al final el índice, como en 3.0.

## Registro de cambios (disclaimer)

### 2026-10-02 — Creación

- **Qué cambió:** se guardaron los archivos del sistema de diseño 3.1, sus 107 recursos y los programas que los generan.
- **Cómo estaba antes:** el repositorio tenía solo el sistema 3.0, de una sola tinta, con 102 íconos y 124 recursos.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color; el repositorio es la fuente de verdad.
