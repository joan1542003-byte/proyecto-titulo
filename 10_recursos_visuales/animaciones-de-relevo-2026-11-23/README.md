# Animaciones sin palabras de Relevo

Seis animaciones que explican Relevo solo con imágenes y movimiento, sin texto. Todas van sin fondo, para ponerlas sobre una lámina o una página. Se hicieron el 23 de noviembre de 2026, a pedido del autor: algo que uno vea y entienda la app, sin palabras.

Son ilustraciones, no capturas de la app. El teléfono, el contenido que se desliza y el Tag son genéricos: no copian ninguna marca ni ninguna app real.

## La historia

Relevo cuenta en cuatro colores lo que pasa, los mismos de la marca:

1. **Tu tiempo (amarillo).** Se usa el teléfono y el contenido se desliza. El tiempo se llena como un anillo amarillo alrededor del teléfono. Cuando se completa, llega el aviso de Relevo.
2. **El lugar (lima).** El anillo se vacía en un punto que viaja hasta el lugar donde empieza la actividad: un velador con un libro y el Tag. Al llegar, el punto se vuelve lima y el Tag suena.
3. **Tu primer paso (cielo).** El teléfono se apaga y se va. La cámara se acerca al libro, que se abre y pasa la primera hoja.
4. **Lo que decides (rubor).** Aparece un visto rubor sobre el libro: se eligió la actividad.
5. **La marca.** Cuatro puntos de color salen de donde ocurrió cada parte y forman la marca. La marca pasa el turno y aparece «relevo».

## Los archivos

Están en `animaciones/`. Cada animación tiene tres formatos:

- **`.gif` sin fondo.** Sirve para láminas (Figma, Google Slides, Keynote). Sus bordes y sombras están preparados para un fondo blanco o claro.
- **`.webm` con transparencia real.** Sirve para la web y para programas de video que lo acepten. Se ve bien sobre cualquier fondo.
- **`.mp4` sobre blanco.** Sirve para reproducir en cualquier lado, a 1080 px de alto o de lado.

| Archivo | Qué muestra | Duración |
| --- | --- | --- |
| `relevo-sin-palabras` | La historia completa, de tu tiempo a la marca (16:9). | 15,6 s |
| `relevo-tu-tiempo-en-actividades` | **El teléfono se transforma en actividades.** El anillo amarillo se llena mientras se desliza el contenido, y la pantalla queda en blanco con la marca de Relevo. El teléfono se disuelve y la marca se abre: sus cuatro círculos giran, se separan y se vuelven las actividades como las muestra la app (un círculo blanco con un anillo de color y su ícono): tocar guitarra, leer, pasear al perro y dibujar. Cada una hace su gesto y todo vuelve al teléfono. | 7,4 s, se repite |
| `relevo-tu-tiempo` | El teléfono con el contenido que se desliza. El anillo amarillo se llena y llega el aviso. | 4,8 s, se repite |
| `relevo-suena-donde-empieza` | El velador con el libro y el Tag, que suena dos veces y descansa. | 2,4 s, se repite |
| `relevo-tu-primer-paso` | El libro se abre, pasa una hoja y se cierra. | 4,6 s, se repite |
| `relevo-tu-decides` | El teléfono se apaga y se aleja. El libro queda al frente con el visto rubor. | 4,4 s, se repite |

Las animaciones cortas son cuadradas y sirven por separado, una por idea. La película las junta.

## Cómo se hizo el movimiento

Se aplicó lo que se revisó para la [familia de animaciones del logo](../logo-relevo-variantes-2026-11-23/README.md#cómo-se-pensó-el-movimiento): un gesto claro por idea, recorridos en arco, acciones que se superponen y curvas medidas.

- **Resortes suaves:** las cosas llegan y se asientan sin rebotar varias veces. El teléfono, el velador, el libro, el Tag y el visto entran con resortes amortiguados.
- **El turno como hilo:** el anillo amarillo se vacía justo donde sale el punto que viaja al Tag. Ese punto llega lima, y al final cuatro puntos forman la marca. Lo que se mueve es siempre el turno.
- **Cámara:** el teléfono se corre a un lado para mostrar el lugar, y después la cámara se acerca al libro y se aleja para la marca.
- **Contenido que se desliza:** se mueve a golpes, como cuando se pasa el dedo, y no a velocidad constante.
- **Libro:** la tapa y la hoja giran sobre el lomo con un leve sesgo de perspectiva.
- **Calidad:** se dibuja a 50 cuadros por segundo y al doble de resolución (1920 × 1080 en la película). El GIF va a 25 cuadros por segundo, nítido. El MP4 y el WebM van a 50.

## El estilo

- **Colores:** los cuatro colores originales de la marca, cada uno con su degradado sutil (del color original a su tono claro), la tinta del teléfono y neutros cálidos para el velador.
- **Sombras:** sombras de contacto suaves bajo cada objeto. No hay brillos ni halos.
- **Contenido del teléfono:** fotos, avatares, barras de texto y los íconos de corazón y comentario, al estilo de Lucide. Se reconoce como una red social sin mostrar ninguna.
- **El Tag:** pequeño y claro, con el botón lima, porque es el lugar.
- **Las actividades:** se dibujan como en la pestaña Actividades de la app: un círculo blanco, un anillo de color y el ícono en tinta. Los íconos son los mismos de Lucide que usa la app. Se ordenan en una grilla de dos por dos, como el ícono «Actividades» de la barra de la app, que también son cuatro círculos.

### Cómo se transforma el teléfono

- **Un solo objeto que cambia:** el teléfono no desaparece para que aparezca otra cosa. Su pantalla queda en blanco, nace la marca en el centro y el teléfono se disuelve hacia afuera, como cuando se abre una app.
- **La marca se abre:** los cuatro círculos de la marca giran un octavo de vuelta y se separan. Al separarse pierden el corte que se hacen entre sí y quedan como círculos completos.
- **Del logo a la app:** cada círculo pasa de su color lleno a blanco con un anillo de su color, y su ícono se dibuja trazo a trazo, uno tras otro, en el sentido del reloj.
- **Gestos:** cada actividad hace un gesto propio. La guitarra se rasguea, el libro respira, el perro mueve la cabeza y el lápiz vuelve a trazar su línea.
- **Vuelta al comienzo:** todo vuelve al teléfono más rápido de lo que salió, y el ciclo empieza sin corte.

## Cómo rehacerlas

Se necesitan Node, Google Chrome y ffmpeg. Desde `scripts/`:

```
node ../../logo-relevo-variantes-2026-11-23/scripts/render.js explica.js relevo-sin-palabras ../animaciones --gif 800 --webm --mp4 -- pelicula
node ../../logo-relevo-variantes-2026-11-23/scripts/render.js explica.js relevo-tu-tiempo ../animaciones --gif 540 --webm --mp4 -- tiempo
```

Las escenas son `pelicula`, `tiempo`, `transforma`, `suena`, `primer-paso` y `decides`. Para revisar cuadros sueltos sin renderizar todo, se usa `PREVIEW="1,4.5,9" node explica.js <carpeta> pelicula`, que escribe una página con esos instantes.

- **`explica.js`:** dibuja cada cuadro: el teléfono, el anillo del tiempo, el velador, el libro, el Tag, el visto y la marca.
- **`render.js`:** está en la carpeta del logo. Fotografía los cuadros con fondo transparente y arma el GIF, el WebM y el MP4.

## Registro de cambios (disclaimer)

### 2026-11-23 — El teléfono se transforma en actividades

- **Qué se añadió:** `relevo-tu-tiempo-en-actividades`. Cuando el anillo del tiempo se completa, el teléfono se transforma en la marca y la marca en cuatro actividades, como las muestra la app, con sus íconos y un gesto cada una. Va en GIF sin fondo, WebM con transparencia y MP4.
- **Cómo estaba antes:** «tu tiempo» terminaba en el aviso de Relevo, sin mostrar lo que se hace en lugar del teléfono.
- **Por qué:** el autor pidió que en «relevo tiempo» el teléfono se transforme en actividades al activarse Relevo, para que se entienda fácilmente, al nivel de Apple.

### 2026-11-23 — Creación

- **Qué se añadió:** una película de 15,6 s y cuatro animaciones cortas que explican Relevo sin palabras, en GIF sin fondo, WebM con transparencia y MP4, con el script que las dibuja.
- **Cómo estaba antes:** las animaciones mostraban solo el logo.
- **Por qué:** el autor pidió más animaciones, algo que uno vea y entienda la app, sin palabras, de muy alta calidad, y los GIF sin fondo.
