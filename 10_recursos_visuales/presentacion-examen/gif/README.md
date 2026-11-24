# GIF de la presentación del examen

Estos son los seis GIF que usa la [presentación del examen](../../47_presentacion-examen-2026-11-23.md), tal como están en Figma Slides. Su huella SHA-1 coincide con la de la imagen de cada lámina, así que son los mismos archivos. En Figma, cada GIF va sobre su [cuadro fijo](cuadros-fijos/), que es igual a su primer cuadro. Todos se repiten sin fin.

| Lámina | GIF | Qué muestra | Tamaño | Cuadros y duración |
| --- | --- | --- | --- | --- |
| 1 · Portada | [`lamina-01-portada-logo.gif`](lamina-01-portada-logo.gif) | El logo «pasa el turno», sobre el aura de la portada de la memoria | 1056 × 312 | 150 cuadros, 6 s |
| 28 · Relevo | [`lamina-28-como-funciona.gif`](lamina-28-como-funciona.gif) | «Cómo funciona», en su versión simple; empieza con los cuatro círculos | 1280 × 720 | 330 cuadros, 13,2 s |
| 29 · Cómo se usa | [`lamina-29-2-seguir-en-el-telefono.gif`](lamina-29-2-seguir-en-el-telefono.gif) | Seguir en el teléfono: el anillo del tiempo; empieza con el anillo completo | 480 × 480 | 120 cuadros, 4,8 s |
| 30 · La aplicación | [`lamina-30-preparar-un-relevo-en-la-app.gif`](lamina-30-preparar-un-relevo-en-la-app.gif) | Cómo se prepara un relevo en la app 4.8.2 | 400 × 889 | 394 cuadros, 39,2 s |
| 31 · Identidad | [`lamina-31-identidad-logo.gif`](lamina-31-identidad-logo.gif) | El logo «pasa el turno», sobre blanco | 960 × 284 | 150 cuadros, 6 s |
| 41 · Cierre | [`lamina-41-cierre-logo.gif`](lamina-41-cierre-logo.gif) | El logo «pasa el turno», sobre el aura de la contraportada de la memoria | 1160 × 343 | 150 cuadros, 6 s |

## Dónde se mueven

Según la [ayuda de Figma](https://help.figma.com/hc/en-us/articles/25427361244183-Add-images-and-videos-to-slides), los GIF se ven quietos en el editor de Figma Slides y se mueven solo en el modo presentación. Un PDF no reproduce animaciones: Figma exporta un cuadro de cada GIF. Para un PDF con las animaciones en marcha, está el [armador del PDF animado](../pdf-animado/README.md). Cada GIF empieza en un cuadro representativo, el mismo de su cuadro fijo:

- **«Cómo funciona» (lámina 28)** empezaba en un cuadro en blanco. Ahora empieza en el segundo 9,92, con los cuatro círculos, y lo anterior pasa al final.
- **«Seguir en el teléfono» (lámina 29)** empieza en el segundo 4,2, con el anillo completo.
- **El GIF de la app (lámina 30)** empieza en el cuadro 81, la pantalla que ya era su cuadro fijo. Al reordenarlo, gifsicle juntó los cuadros repetidos: quedan 394 en vez de 453, con la misma duración.

Los dos primeros se rehicieron con el parámetro `INICIO` de [`gif-sobre-fondo.sh`](../gif-sobre-fondo.sh), que los reproduce byte a byte. El de la app se reordenó con `gifsicle --unoptimize lamina-30-….gif "#81-" "#0-80" -O3 --loopcount=forever`.

## Si en el modo presentación no se mueven

Los GIF se pusieron en Figma por código, y la API de Figma no puede crear GIF insertados en Slides. Si alguno no se mueve en el modo presentación, se reemplaza desde el editor:

1. Descargar el GIF de esta carpeta.
2. En Figma, elegir la capa «GIF …» de la lámina.
3. En la sección **Fill** de la barra derecha, abrir la imagen de arriba y elegir **Choose image** con el GIF descargado. Figma marca los GIF con la etiqueta «GIF» en esa sección.

El cuadro fijo de abajo se deja como está.

## De dónde salen

- **El logo y las animaciones de Relevo** se hicieron con [`gif-sobre-fondo.sh`](../gif-sobre-fondo.sh). El script parte de las animaciones WebM con transparencia del [logo](../../logo-relevo-variantes-2026-11-23/README.md#animaciones-del-logo) y de [«sin palabras»](../../animaciones-de-relevo-2026-11-23/README.md), y las pone sobre el fondo exacto de su lámina. Sus comentarios dicen con qué tamaño, fondo e inicio se hizo cada uno.
- **El GIF de la lámina 30** es la grabación «Crear un relevo» de la app 4.8.2, con el mismo tamaño y la misma duración que la de las [capturas de la 4.8.2](../../../06_desarrollo_y_factibilidad/app-android/capturas/interfaz-4.8.2/README.md).
- **Los que se quitaron:** los de Preparar (un libro que se abre), Oír la señal (el libro sobre la cómoda) y Decidir (el teléfono junto al libro) salieron de la lámina 29, que ahora muestra el ícono de cada momento. Las animaciones originales siguen en [animaciones-de-relevo-2026-11-23](../../animaciones-de-relevo-2026-11-23/README.md).

## Registro de cambios (disclaimer)

### 2026-11-24 — Enlace al PDF animado

- **Qué cambió:** se enlaza el armador del PDF con los GIF animados.
- **Cómo estaba antes:** decía solo que un PDF no reproduce animaciones.
- **Por qué:** el autor preguntó si había forma de poner los GIF en el PDF.

### 2026-11-24 — Primer cuadro representativo y tres GIF menos

- **Qué cambió:** «Cómo funciona», «Seguir en el teléfono» y el GIF de la app empiezan ahora en un cuadro representativo, el mismo de su cuadro fijo. Se quitaron los GIF de Preparar, Oír la señal y Decidir, y se guardaron los seis cuadros fijos. Se explican dónde se mueven los GIF y cómo reemplazarlos desde el editor.
- **Cómo estaba antes:** había nueve GIF. «Cómo funciona» empezaba en un cuadro en blanco, así que en el editor y en el PDF la lámina 28 podía verse vacía, y otros dos empezaban en un cuadro poco representativo.
- **Por qué:** el autor pidió eliminar los GIF del libro y del libro en la cómoda, dijo que no veía moverse los GIF y que en el PDF no se veían.

### 2026-11-24 — Creación

- **Qué cambió:** se guardaron en el repositorio los nueve GIF de la presentación, con el número de su lámina en el nombre, y esta tabla.
- **Cómo estaba antes:** los GIF estaban solo en Figma y en la carpeta temporal de la sesión.
- **Por qué:** el autor preguntó si los GIF funcionan y pidió tenerlos aparte, con su enlace de descarga y su lámina.
