# PDF de la presentación con los GIF animados

Un PDF exportado desde Figma muestra los GIF quietos. [`armar-pdf-animado.py`](armar-pdf-animado.py) toma ese PDF y pone encima cada animación, en la misma posición y con el mismo tamaño que tiene en Figma, con el paquete [`animate`](https://ctan.org/pkg/animate) de LaTeX. Cada animación empieza sola al abrir su lámina y se repite sin fin.

## Dónde se mueven

- **Se mueven** en [Adobe Acrobat Reader](https://get.adobe.com/reader/), que es gratuito, en Windows y en macOS, y en otros lectores que ejecutan el JavaScript de los PDF, como PDF-XChange.
- **No se mueven** en los navegadores (Chrome, Edge, Safari, Firefox), en Vista Previa de macOS ni en los teléfonos: ahí se ve el primer cuadro, que es el mismo de Figma.

Para presentar: abrir el PDF en Acrobat Reader y pasar a pantalla completa (Ctrl + L en Windows, Cmd + L en macOS).

## Qué hace el armador

| Lámina | Animación | Cómo se arma |
| --- | --- | --- |
| 1 · Portada | Logo «pasa el turno» | El aura de la portada de la memoria, fija, y encima solo el logo, con transparencia, desde su WebM |
| 28 · Relevo | «Cómo funciona» | Los cuadros de su GIF, con las esquinas redondeadas sobre el fondo de la página |
| 29 · Cómo se usa | Seguir en el teléfono | Igual que la 28 |
| 30 · La aplicación | Preparar un relevo en la app | Igual que la 28, a su tamaño en pantalla |
| 31 · Identidad | Logo «pasa el turno» | El blanco de su ficha, fijo, y encima el logo con transparencia |
| 41 · Cierre | Logo «pasa el turno» | El aura de la contraportada de la memoria, fija, y encima el logo con transparencia |

Todos los cuadros se guardan en PNG de 256 colores. Los cuadros idénticos seguidos se juntan en uno solo y suman su duración. Así, el PDF de prueba pesa 36,5 MB; sin esas medidas pesaba 105 MB.

## Uso

```
python3 armar-pdf-animado.py PRESENTACION.pdf PRESENTACION-ANIMADA.pdf
```

La base puede ser el PDF exportado desde Figma (File → Export slides to → PDF) o una carpeta con las 41 láminas como `p01.png` … `p41.png` de 1920 × 1080. No hace falta ocultar los GIF antes de exportar, porque cada animación cubre su zona entera. El armador necesita `pdflatex` con los paquetes `animate`, `pdfpages` y `geometry`, además de `ffmpeg`, `pdftoppm` y Pillow; demora unos dos minutos.

## Prueba del 24 de noviembre

Se armó un PDF de prueba sobre capturas de las 41 láminas, de 1920 × 1080. Tiene 41 páginas y el JavaScript de las animaciones. Al convertirlo en imagen, el primer cuadro de cada animación coincide con la lámina de Figma: la diferencia media va de 1 a 5 niveles de 255, por la compresión. No se pudo abrir en Acrobat Reader desde este entorno, así que falta ver las animaciones en marcha. Con el PDF que exporte el autor desde Figma, el texto queda vectorial y más nítido.

## Registro de cambios (disclaimer)

### 2026-11-24 — Creación

- **Qué cambió:** se creó el armador del PDF con los GIF animados y se probó sobre capturas de las 41 láminas.
- **Cómo estaba antes:** el PDF exportado desde Figma mostraba los GIF quietos y no había forma de animarlos.
- **Por qué:** el autor preguntó si había forma de poner los GIF en el PDF, quizás fuera de Figma, y propuso exportarlo y que luego se pusieran los GIF encima.
