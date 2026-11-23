# Variantes del logo de Relevo con degradados sutiles

Revisión del [logo vigente](../logo-relevo-2026-10-11/) pedida por el autor el 23 de noviembre de 2026: degradados sutiles en los colores de la marca y color en el logotipo, que hasta ahora va en tinta. Son variantes para elegir; el logo vigente no cambia hasta que el autor escoja una.

Los trazados son los mismos del logo vigente (los cuatro círculos y «relevo» en Chillax Semibold, en curvas). Solo cambian los rellenos y el fondo.

![Lámina con las 16 variantes](lamina-variantes.png)

## Qué hay en la carpeta

- **`lamina-variantes.png` y `lamina-variantes.html`:** las 16 variantes lado a lado, con una nota por cada una.
- **`svg/`:** cada variante como SVG del logo horizontal, con el mismo número y nombre que en la lámina. Las que van sobre tinta o sobre color traen su fondo.
- **`gif/relevo-colores-papel.gif`:** el logotipo pasa por los cuatro colores, con un degradado sutil, sobre el papel. Dura 6,4 segundos y se repite sin corte.
- **`gif/relevo-colores-tinta.gif`:** lo mismo sobre la tinta.
- **`gif/*.mp4`:** los mismos movimientos en video, más nítidos y livianos.
- **`animacion-marca/`:** dos animaciones de la marca (los cuatro círculos), sola y junto al logotipo, en GIF y MP4.
- **`scripts/`:** lo que genera todo, para rehacerlo o ajustar un color.

## Las variantes

| Archivo | Variante |
| --- | --- |
| `relevo-logo-01-actual.svg` | El logo vigente: la marca con su degradado radial y el logotipo en tinta. Sirve para comparar. |
| `relevo-logo-02-marca-tres-tonos.svg` | Cada círculo va de su tono claro a su color y a un tono vecino, en diagonal. Logotipo en tinta. |
| `relevo-logo-03-marca-pasa-el-turno.svg` | Cada círculo termina en el color del siguiente, en el sentido del reloj. Logotipo en tinta. |
| `relevo-logo-04-logotipo-cuatro-colores.svg` | «relevo» con los cuatro colores, cada uno de su tono claro a su color, en orden de tono: lima, cielo, rubor y amarillo. |
| `relevo-logo-05` a `08-logotipo-<color>.svg` | «relevo» en amarillo, cielo, lima o rubor, de su tono claro a su color. |
| `relevo-logo-09-fondo-tinta-logotipo-blanco.svg` | Sobre tinta: la marca en color y el logotipo en blanco. |
| `relevo-logo-10-fondo-tinta-logotipo-cuatro-colores.svg` | Sobre tinta: el logotipo con los cuatro colores. |
| `relevo-logo-11` a `14-fondo-tinta-logotipo-<color>.svg` | Sobre tinta: el logotipo en amarillo, cielo, lima o rubor. |
| `relevo-logo-15-fondo-cuatro-colores.svg` | Fondo con los cuatro colores, la marca en blanco y el logotipo en tinta. |
| `relevo-logo-16-fondo-cielo.svg` | Fondo cielo, la marca en blanco y el logotipo en tinta. |

## Los colores

Se usan los cuatro colores originales de la marca, sin oscurecer. Cada degradado va de su tono claro al color original:

| Color | Claro | Original |
| --- | --- | --- |
| amarillo | `#FFE57E` | `#FFD54A` |
| cielo | `#B5E3FC` | `#9DD6F4` |
| lima | `#C8F3A6` | `#B3E788` |
| rubor | `#FDB7D8` | `#F6A3CB` |

- **Sobre el papel** (`#F6F4F3`), un logotipo en estos colores se lee menos que en tinta, con un contraste de 1,3 a 1,7. Funciona en tamaño grande, como en una portada o una lámina. En tamaño chico conviene la tinta o el fondo oscuro.
- **Sobre la tinta** (`#141312`), los cuatro colores se leen muy bien.

## Cómo se mueve el GIF

- La marca queda quieta, con los tres tonos vecinos de la variante 02.
- Cada color se queda quieto un momento y luego se desliza hacia el siguiente, de izquierda a derecha.
- Mientras está quieto, el logotipo va de su tono claro a su color original. Nunca muestra los cuatro colores a la vez.

## Animaciones de la marca

Se mueve la forma, no el texto. Cada círculo es una parte del relevo, en el sentido del reloj desde arriba: tu tiempo (amarillo), tu primer paso (cielo), el lugar (lima) y lo que decides (rubor). Las dos animaciones cuentan que el turno pasa de uno al siguiente.

| Archivo | Qué hace | Duración |
| --- | --- | --- |
| `relevo-marca-arma-marca.gif` y `relevo-marca-arma-horizontal.gif` | **La marca se arma.** El amarillo aparece primero. Cada círculo siguiente sale del anterior y gira un cuarto de vuelta hasta su lugar, abriéndose espacio en él. El último, el rubor, cierra el círculo con el primero. Los cuatro se quedan quietos un momento, se recogen hacia el centro y vuelve a empezar. | 5,2 s |
| `relevo-marca-turno-marca.gif` y `relevo-marca-turno-horizontal.gif` | **Pasa el turno.** La marca está armada y el turno la recorre en el sentido del reloj. Quien lo tiene da un paso afuera y crece apenas; después se lo pasa al siguiente. | 3,6 s, sin corte |

- **Cómo se dibuja:** las animaciones usan los mismos círculos del logo (radio 29, a 21 del centro) con el mordisco del siguiente. Por eso, cuando un círculo se mueve o crece, el corte entre los dos lo sigue. La marca lleva los tres tonos vecinos de la variante 02.
- **Usos posibles:** «Se arma» sirve para abrir una presentación, un video o la pantalla de inicio de la app. «Pasa el turno» sirve para esperas o para el momento en que suena un relevo.

## Cómo rehacerlo

Se necesitan Node, Google Chrome y ffmpeg. Desde esta carpeta:

```
node scripts/gen.js
bash scripts/render-gif.sh papel
bash scripts/render-gif.sh tinta
bash scripts/render-marca.sh arma marca
bash scripts/render-marca.sh arma horizontal
bash scripts/render-marca.sh turno marca
bash scripts/render-marca.sh turno horizontal
```

- **`gen.js`:** escribe los SVG y la lámina HTML. La lámina se pasa a PNG abriéndola en Chrome a 1600 px de ancho.
- **`render-gif.sh`:** dibuja los 160 cuadros en una carpeta temporal y deja el GIF y el MP4 en `gif/`.
- **`marca-anim.js` y `render-marca.sh`:** las animaciones de la marca; dejan el GIF y el MP4 en `animacion-marca/`.
- **`color.js`:** las conversiones a OKLCH y el cálculo de contraste.

## Registro de cambios (disclaimer)

### 2026-11-23 — Animaciones de la marca

- **Qué se añadió:** dos animaciones de los cuatro círculos, «se arma» y «pasa el turno», sola y junto al logotipo, en GIF y MP4, con los scripts que las generan.
- **Cómo estaba antes:** solo se animaba el color del logotipo; la marca quedaba quieta.
- **Por qué:** el autor pidió animar la forma del logo, no el texto, con una animación que tenga sentido.

### 2026-11-23 — Colores originales y nombres

- **Qué cambió:** el logotipo usa ahora los cuatro colores originales, cada uno con un degradado de su tono claro a su color, en la lámina, en los SVG y en los dos GIF. Las variantes pasaron a ser 16, numeradas del 01 al 16 y con nombres que dicen qué tienen. Se sumaron las del logotipo en un color sobre tinta y las de fondo de color con logotipo en tinta. Los SVG con fondo lo traen incluido.
- **Cómo estaba antes:** el logotipo usaba tonos oscurecidos para leerse sobre el papel, y había 14 variantes con números y letras (06a–d).
- **Por qué:** el autor vio los colores muy apagados y distintos de los de la marca. Pidió un degradado más claro, con el color original, y cada variante en SVG bien nombrada en el repositorio.

### 2026-11-23 — Creación

- **Qué se añadió:** 14 variantes del logo horizontal con degradados sutiles y color en el logotipo, una lámina para compararlas, dos GIF del logotipo pasando por los cuatro colores (sobre papel y sobre tinta) y los scripts que los generan.
- **Cómo estaba antes:** el logo vigente tenía la marca con un degradado radial y el logotipo solo en tinta o en blanco.
- **Por qué:** el autor pidió revisar el logo: agregar degradados sutiles a los colores, dar color al logotipo (los cuatro colores, uno solo o blanco), probar variantes y hacer un GIF del texto «relevo» pasando por los cuatro colores.
