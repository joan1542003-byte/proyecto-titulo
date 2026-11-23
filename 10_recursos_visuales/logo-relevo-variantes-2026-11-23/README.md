# Variantes del logo de Relevo con degradados sutiles

Revisión del [logo vigente](../logo-relevo-2026-10-11/) pedida por el autor el 23 de noviembre de 2026: degradados sutiles en los colores de la marca y color en el logotipo, que hasta ahora va en tinta. Son variantes para elegir; el logo vigente no cambia hasta que el autor escoja una.

Los trazados son los mismos del logo vigente (los cuatro círculos y «relevo» en Chillax Semibold, en curvas). Solo cambian los rellenos y el fondo.

![Lámina con las 14 variantes](lamina-variantes.png)

## Qué hay en la carpeta

- **`lamina-variantes.png` y `lamina-variantes.html`:** las 14 variantes lado a lado, con una nota por cada una.
- **`svg/`:** cada variante como SVG del logo horizontal. Las variantes 10 y 11 van sin fondo: son blancas y se ponen sobre el color.
- **`gif/relevo-colores-papel.gif`:** el logotipo pasa por los cuatro colores, con un degradado sutil, sobre el papel. Dura 6,4 segundos y se repite sin corte.
- **`gif/relevo-colores-tinta.gif`:** lo mismo sobre la tinta, con los colores claros.
- **`gif/*.mp4`:** los mismos movimientos en video, más nítidos y livianos.
- **`scripts/`:** lo que genera todo, para rehacerlo o ajustar un color.

## Las variantes

| N.º | Variante | Qué cambia |
| --- | --- | --- |
| 01 | Actual | La marca con su degradado radial y el logotipo en tinta. Sirve para comparar. |
| 02 | Marca con tres tonos vecinos | Cada círculo va de su tono claro a su color y a un tono vecino, en diagonal, como las figuras de la memoria. |
| 03 | Marca que pasa el turno | Cada círculo termina en el color del siguiente, en el sentido del reloj. |
| 04 | Logotipo con los cuatro colores | «relevo» recorre lima, cielo, rubor y amarillo en tonos más hondos, legibles sobre el papel. |
| 05 | Logotipo con los cuatro colores, claros | Los colores de la marca sin oscurecer: el más luminoso, pero se lee poco sobre el papel. |
| 06a–d | Logotipo en un color | Amarillo, cielo, lima o rubor, cada uno con un degradado sutil de su tono hondo a uno más profundo. |
| 07 | Tinta que se tiñe | El logotipo empieza en tinta y termina, apenas, en el celeste hondo. |
| 08 | Sobre tinta, logotipo blanco | La marca en color y el logotipo en blanco. |
| 09 | Sobre tinta, logotipo con los cuatro colores | Sobre la tinta los colores claros se leen bien, sin oscurecerlos. |
| 10 | Todo en blanco, sobre los colores | Marca y logotipo en blanco, sobre un degradado de los cuatro tonos hondos. |
| 11 | Todo en blanco, sobre un color | Marca y logotipo en blanco, sobre el celeste hondo. |

## Cómo se eligieron los colores

- **Los cuatro colores de la marca no se tocan:** amarillo `#FFD54A`, cielo `#9DD6F4`, lima `#B3E788` y rubor `#F6A3CB`.
- **Tonos hondos para el logotipo:** sobre el papel (`#F6F4F3`), los colores de la marca casi no se leen (contraste de 1,3 a 1,7). Para el logotipo se oscurecieron hasta un contraste de 3 a 1, el mínimo para texto grande y logotipos. Se usó el espacio OKLCH, que mantiene el tono al oscurecer:

  | Color | Tono hondo | Más profundo |
  | --- | --- | --- |
  | amarillo | `#C27F08` | `#9F620D` |
  | cielo | `#5594B4` | `#317697` |
  | lima | `#659B2A` | `#4C7D09` |
  | rubor | `#C7729D` | `#A9517F` |

- **Sin oliva:** el amarillo oscurecido tiende al oliva, que el autor ya había descartado. Por eso el amarillo hondo gira hacia el ámbar. Por la misma razón, el logotipo de cuatro colores los ordena por tono (lima, cielo, rubor, amarillo), para que ningún paso cruce del amarillo al verde por un tono turbio.
- **En el GIF:** en el único paso del amarillo al lima, el color se aclara a mitad de camino y pasa por un amarillo limpio en vez del oliva. El paso dura una fracción de segundo.

## Cómo se mueve el GIF

- La marca queda quieta, con los tres tonos vecinos de la variante 02.
- Cada color se queda quieto un momento y luego se desliza hacia el siguiente, de izquierda a derecha.
- Mientras está quieto, el logotipo muestra un degradado sutil del tono a uno un poco más profundo. Nunca muestra los cuatro colores a la vez.

## Cómo rehacerlo

Se necesitan Node, Google Chrome y ffmpeg. Desde esta carpeta:

```
node scripts/gen.js
bash scripts/render-gif.sh papel
bash scripts/render-gif.sh tinta
```

- **`gen.js`:** escribe los SVG y la lámina HTML. La lámina se pasa a PNG abriéndola en Chrome a 1600 px de ancho.
- **`render-gif.sh`:** dibuja los 160 cuadros en una carpeta temporal y deja el GIF y el MP4 en `gif/`.
- **`color.js`:** las conversiones a OKLCH y el cálculo de contraste.

## Registro de cambios (disclaimer)

### 2026-11-23 — Creación

- **Qué se añadió:** 14 variantes del logo horizontal con degradados sutiles y color en el logotipo, una lámina para compararlas, dos GIF del logotipo pasando por los cuatro colores (sobre papel y sobre tinta) y los scripts que los generan.
- **Cómo estaba antes:** el logo vigente tenía la marca con un degradado radial y el logotipo solo en tinta o en blanco.
- **Por qué:** el autor pidió revisar el logo: agregar degradados sutiles a los colores, dar color al logotipo (los cuatro colores, uno solo o blanco), probar variantes y hacer un GIF del texto «relevo» pasando por los cuatro colores.
