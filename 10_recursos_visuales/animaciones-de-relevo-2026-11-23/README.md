# Animaciones sin palabras de Relevo

Siete animaciones que explican Relevo solo con imágenes y movimiento, sin texto. Todas van sin fondo, para ponerlas sobre una lámina o una página. Se hicieron el 23 de noviembre de 2026, a pedido del autor: algo que uno vea y entienda la app, sin palabras.

Son ilustraciones, no capturas de la app. El teléfono, el contenido que se desliza y el Tag son genéricos: no copian ninguna marca ni ninguna app real.

## Los colores

Cada color de la marca dice siempre lo mismo. Ninguno se usa como adorno. El orden es el de la marca, en el sentido del reloj desde arriba, y el de «Cómo funciona» en la app:

| Color | Qué significa | En la app |
| --- | --- | --- |
| amarillo | tu tiempo | «Cuenta el tiempo», en las apps que eliges |
| cielo | tu primer paso | «Te recuerda cómo empezar», con un primer paso, como abrir el libro |
| lima | el lugar donde empiezas, que es donde suena | «Suena donde empiezas», en el Tag o en un dispositivo de audio |
| rubor | lo que decides | «Tú decides»: empezar, dejarlo o cambiar de idea |

Todo lo demás va en neutros o en tinta: el teléfono, el contenido que se desliza, el velador y el logotipo «relevo».

## Los archivos

Están en `animaciones/`. Cada animación tiene tres formatos:

- **`.gif` sin fondo.** Sirve para láminas (Figma, Google Slides, Keynote). Sus bordes y sombras están preparados para un fondo blanco o claro.
- **`.webm` con transparencia real.** Sirve para la web y para programas de video que lo acepten. Se ve bien sobre cualquier fondo.
- **`.mp4` sobre blanco.** Sirve para reproducir en cualquier lado, a 1080 px de alto o de lado.

| Archivo | Qué muestra | Duración |
| --- | --- | --- |
| `relevo-como-funciona` | Un relevo completo en las cuatro partes de la marca. Termina en el logo (16:9). **Versión simple**, la principal: colores planos y sin efectos. | 13,2 s, se repite |
| `relevo-como-funciona-detallada` | La misma historia con degradados, resortes, íconos que se dibujan, ondas y estela. | 13 s, se repite |
| `relevo-sin-palabras` | Un relevo contado como escena: el teléfono, el velador, el libro y la marca (16:9). | 15,6 s |
| `relevo-tu-tiempo` | El teléfono con el contenido que se desliza. El anillo amarillo se llena y llega el aviso. | 4,8 s, se repite |
| `relevo-suena-donde-empieza` | El velador con el libro y el Tag, que suena dos veces y descansa. | 2,4 s, se repite |
| `relevo-tu-primer-paso` | El libro se abre, pasa una hoja y se cierra. | 4,6 s, se repite |
| `relevo-tu-decides` | El teléfono se apaga y se aleja. El libro queda al frente con el visto rubor. | 4,4 s, se repite |

Las animaciones cortas son cuadradas y sirven por separado, una por idea.

## Cómo funciona: la marca cuenta la app

Hay dos versiones de la misma historia. La principal es la simple: el autor pidió que pareciera menos hecha por IA, más minimalista y como hecha en un editor básico, con la misma calidad y menos efectos.

- **Simple (`relevo-como-funciona`):** colores planos, sin degradados ni sombras.
  - **Movimiento:** solo entradas y salidas suaves (ease-in-out), sin rebotes.
  - **Teléfono:** un rectángulo negro con tres bloques grises que suben.
  - **Íconos y logotipo:** los íconos aparecen con un fundido, y «relevo» aparece de una vez.
  - **El punto que pasa el turno:** va sin estela y sin huella.
  - **Ritmo:** las ondas del Tag laten dos veces. La bandera y los círculos no se mueven por su cuenta.
- **Detallada (`relevo-como-funciona-detallada`):** la primera versión, con degradados sutiles, resortes, íconos que se dibujan trazo a trazo, ondas que salen del círculo lima, la bandera que flamea, la huella gris del relevo y las letras que suben una por una.

Lo que sigue vale para las dos:

`relevo-como-funciona` usa el ejemplo de la app: leer, con el primer paso de abrir el libro. Cada parte aparece en su color, en el lugar que ocupa en la marca, con el ícono que usa la app:

1. **Tu tiempo.** El contenido se desliza y un anillo amarillo cuenta el tiempo alrededor del teléfono. Al completarse, la pantalla queda en blanco y el teléfono se transforma en el círculo amarillo, arriba. Aparece el reloj, cuya aguja da una vuelta.
2. **Tu primer paso.** El turno pasa en el sentido del reloj: un punto amarillo viaja por el arco hasta la derecha y ahí se abre el círculo cielo. El libro se abre desde su lomo.
3. **El lugar.** El turno pasa hacia abajo, al círculo lima. Aparece el Tag, que suena: sus ondas laten y salen del círculo.
4. **Lo que decides.** El turno pasa a la izquierda, al círculo rubor. Aparece la bandera, que flamea.
5. **La marca.** El turno vuelve a tu tiempo y el círculo se cierra. Los cuatro círculos se llenan de su color, se juntan y, al tocarse, se cortan entre sí como en el logo. La marca se corre y aparece «relevo», en tinta.

Detalles del movimiento:

- **El punto que pasa el turno:** conserva el color de quien lo entrega. Si se mezclara, el amarillo pasaría por el verde del lugar en camino al cielo.
- **La huella del relevo:** el punto deja una huella gris fina. Al final dibuja el círculo completo.
- **El turno activo:** el círculo que tiene el turno crece apenas, igual que en «pasa el turno».
- **El teléfono:** se vuelve el círculo amarillo sin desaparecer. Primero la pantalla blanca cubre el marco, y después la forma se redondea hasta ser un círculo.

## Cómo se hizo el movimiento

Se aplicó lo que se revisó para la [familia de animaciones del logo](../logo-relevo-variantes-2026-11-23/README.md#cómo-se-pensó-el-movimiento): un gesto claro por idea, recorridos en arco, acciones que se superponen y curvas medidas.

- **Resortes suaves:** las cosas llegan y se asientan sin rebotar varias veces.
- **El turno como hilo:** lo que se mueve de una parte a otra es siempre el turno.
- **Contenido que se desliza:** se mueve a golpes, como cuando se pasa el dedo, y no a velocidad constante.
- **Libro:** la tapa y la hoja giran sobre el lomo, con un leve sesgo de perspectiva en la ilustración y sin él en el ícono.
- **Calidad:** se dibuja a 50 cuadros por segundo y al doble de resolución (1920 × 1080 en las de 16:9). El GIF va a 25 cuadros por segundo, nítido. El MP4 y el WebM van a 50.

## El estilo

- **Colores:** cada color va en su parte y nada más, con su degradado sutil (del color original a su tono claro). El teléfono va en tinta y el velador en neutros cálidos.
- **Sombras:** sombras de contacto suaves bajo cada objeto. No hay brillos ni halos.
- **Contenido del teléfono:** fotos, avatares, barras de texto y los íconos de corazón y comentario, al estilo de Lucide. Se reconoce como una red social sin mostrar ninguna.
- **Íconos:** los mismos de la app. Son de Lucide (reloj, libro abierto y bandera) y el de «Suena» es propio, el Tag con sus ondas. Van en tinta, dentro de un círculo blanco con el anillo de su color, como en la app.

## Cómo rehacerlas

Se necesitan Node, Google Chrome y ffmpeg. Desde `scripts/`:

```
node ../../logo-relevo-variantes-2026-11-23/scripts/render.js explica.js relevo-como-funciona ../animaciones --gif 800 --webm --mp4 -- como-funciona
node ../../logo-relevo-variantes-2026-11-23/scripts/render.js explica.js relevo-tu-tiempo ../animaciones --gif 540 --webm --mp4 -- tiempo
```

Las escenas son `como-funciona` (la simple), `como-funciona-detallada`, `pelicula`, `tiempo`, `suena`, `primer-paso` y `decides`. Para revisar cuadros sueltos sin renderizar todo, se usa `PREVIEW="1,4.5,9" node explica.js <carpeta> como-funciona`, que escribe una página con esos instantes.

- **`explica.js`:** dibuja cada cuadro: el teléfono, el anillo del tiempo, los círculos de las cuatro partes, el velador, el libro, el Tag, el visto y la marca.
- **`render.js`:** está en la carpeta del logo. Fotografía los cuadros con fondo transparente y arma el GIF, el WebM y el MP4.

## Registro de cambios (disclaimer)

### 2026-11-23 — Cómo funciona, versión simple

- **Qué cambió:** `relevo-como-funciona` es ahora la versión simple, con colores planos, sin sombras, degradados ni rebotes, íconos con fundido, un punto sin estela y un teléfono más simple. La versión anterior pasó a llamarse `relevo-como-funciona-detallada`.
- **Cómo estaba antes:** la única versión tenía degradados, resortes, íconos que se dibujaban, ondas, estela y letras que subían una por una.
- **Por qué:** al autor le gustó, pero pidió que pareciera menos hecha por IA, más minimalista y como hecha en un editor básico, con la misma calidad y menos efectos.

### 2026-11-23 — Cómo funciona, con cada color en su significado

- **Qué cambió:** `relevo-como-funciona` reemplaza a `relevo-tu-tiempo-en-actividades`, que se borró. El teléfono se transforma en el círculo amarillo y el turno pasa por las cuatro partes de la marca: tu tiempo, tu primer paso, el lugar y lo que decides. Cada parte va en su color, con el ícono de la app, y la narración termina en el logo. Se sumó la tabla de los colores.
- **Cómo estaba antes:** la versión anterior asignaba los colores a actividades (guitarra, libro, perro y lápiz), sin respetar lo que significa cada uno.
- **Por qué:** el autor recordó que cada color tiene un significado y no se usa a la ligera. También pidió mejorar la animación con una narrativa.

### 2026-11-23 — El teléfono se transforma en actividades

- **Qué se añadió:** `relevo-tu-tiempo-en-actividades`, donde el teléfono se transformaba en cuatro actividades. Se reemplazó el mismo día por `relevo-como-funciona`.
- **Cómo estaba antes:** «tu tiempo» terminaba en el aviso de Relevo.
- **Por qué:** el autor pidió que el teléfono se transforme en actividades al activarse Relevo.

### 2026-11-23 — Creación

- **Qué se añadió:** una película de 15,6 s y cuatro animaciones cortas que explican Relevo sin palabras, en GIF sin fondo, WebM con transparencia y MP4, con el script que las dibuja.
- **Cómo estaba antes:** las animaciones mostraban solo el logo.
- **Por qué:** el autor pidió más animaciones, algo que uno vea y entienda la app, sin palabras, de muy alta calidad, y los GIF sin fondo.
