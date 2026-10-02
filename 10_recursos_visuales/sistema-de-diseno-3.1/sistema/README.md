Relevo es un sistema phygital: una app y un parlante que suena en el lugar donde empieza una actividad que la persona quería hacer, cuando lleva un rato en el teléfono. Su identidad es **el renglón**: una línea bajo lo que importa. En el logotipo resalta la palabra y pasa la «o» para hacer lugar; en la app sostiene las palabras de la persona («Vuelve a *leer*.»); en la casa, el objeto subraya el lugar. Esta es la versión 3.1: el sistema 3.0 con un logotipo nuevo, dos voces tipográficas, los seis colores de la casa, 135 íconos, ilustraciones, patrones, aplicaciones y movimiento.

## Principios

- **El renglón marca lo que importa.** Uno por pantalla, lámina o afiche, bajo palabras en `ink`. Nunca bajo texto azul ni como enlace.
- **La pantalla es azul; la casa, de colores.** `blue` es Relevo: el logotipo, el renglón, el tiempo y dónde estás. Los colores de la casa (`moverme`, `leer`, `crear`, `aprender`, `cuidar`, `compartir` y sus roles) aparecen solo donde hay una actividad de esa categoría.
- **Dos voces.** Relevo habla en Schibsted Grotesk y en Newsreader romana. Lo que escribió la persona va en Newsreader itálica (`personaDisplay`, `persona`, `personaBody`), en `ink`.
- **La trama en momentos de marca.** Puntos en la señal, la foto de la actividad activa, el tiempo, el ícono de la app y las piezas de comunicación. No en cada pantalla.
- **Papel para leer, vidrio para navegar.** El contenido va en `paper` y `card`; barras, pestañas, botones de la barra y hojas, en vidrio. Todo texto sobre una foto, una trama o un campo de color va en una tarjeta.
- **Tranquila y concreta.** Pocas palabras, sin mayúsculas sostenidas, sin signos de exclamación y sin juzgar el uso del teléfono.

## Voz

Relevo habla de tú, con frases cortas y verbos concretos. Se nombra en tercera persona («Relevo te avisa…») y el equipo del estudio habla en primera plural («Lo guardamos junto a tu código…»). Los títulos son preguntas o frases breves en minúscula de oración: «¿Qué quieres hacer?», «Tu semana», «¿Qué decidiste?». Cada aviso dice qué pasó y qué hacer. En el texto, «Relevo» va con mayúscula inicial; en minúsculas va solo el logotipo.

- Firma: «Vuelve a lo que querías hacer.» (D-073). Su forma abierta, «Vuelve a ___.», se completa con las palabras de la persona.
- Frase de marca de la memoria: «Hazle lugar a lo que quieres hacer.» (D-062). El logotipo la dibuja: su renglón deja lugar después de la «o».
- Descriptor, cuando no conocen el producto: «Un recordatorio físico que preparas desde el teléfono.»
- Las tres respuestas después de la señal van iguales: «Comencé la actividad», «La dejé para después» y «Cambié de idea». Ninguna es mejor que otra.

La sección Voz y tono tiene las reglas y los ejemplos.

## Color

- Fondo: `paper`. Contenido agrupado: `card`. Rellenos de controles secundarios: `mist`. Separadores: `line` (decorativa; nunca el único borde de un control).
- Texto: `ink` para todo; `graphite` para lo secundario, rótulos y pies. Ambos pasan 4,5:1 sobre `paper`, `card` y `mist` en los dos temas.
- `blue` es el azul del sistema: renglón, `TimeDots`, `ProgressLine`, `StepProgress`, la pestaña elegida y el foco. Sobre `blue`, el texto es `on-blue`; sobre `ink`, `on-ink`.
- `voice` es `ink`: la voz de la persona se distingue por la letra, no por el color.
- **Colores de la casa.** Seis escalas constantes de 50 a 900 (`mostaza-*`, `arcilla-*`, `salvia-*`, `terracota-*`, `ciruela-*`, `pizarra-*`) y cuatro roles por categoría, que cambian con el tema:
  - `<cat>`: el color firma; campos, afiches y fotos en trama. Decorativo: sin texto encima.
  - `<cat>-line`: el renglón y los íconos de esa categoría (3:1 o más sobre `paper` y `card`).
  - `<cat>-text`: rótulos de la categoría (4,5:1 o más sobre `paper`, `card` y `<cat>-soft`).
  - `<cat>-soft`: fondo de etiquetas y tarjetas de la categoría.
- Categorías: `moverme` (terracota), `leer` (mostaza), `crear` (arcilla), `aprender` (pizarra), `cuidar` (salvia) y `compartir` (ciruela).
- Nunca uses un color de la casa para el sistema (botones, foco, tiempo, progreso) ni el azul para una categoría. Botones en tinta. `error`, `error-soft` y `error-tint` solo para fallas del sistema.
- Piezas fijas (logotipo, afiches, impresión): `tinta`, `papel`, `blanco`, la escala azul (`azul-700` a `azul-50`) y las escalas de la casa.

La sección Color tiene las combinaciones, el contraste medido y las razones.

## Tipografía

- **Schibsted Grotesk** (variable 400–900, `fonts/schibsted-grotesk.ttf`) para la interfaz, el logotipo y las presentaciones. Grupo Interfaz: `body` 17/26, `headline` 17/22 en 600, `title2` 22/28, `largeTitle` 34/40 en 650 con −2 %.
- **Newsreader romana** (tamaño óptico de 6 a 72, Google Fonts) para la frase principal de Relevo, desde 28 px: `displayTitle`, `displayCard`, `displaySignal`, `displaySlide` y `displayPoster`. Una frase en serif por pantalla.
- **Newsreader itálica** para lo que escribió la persona: `personaDisplay` dentro de un titular, `persona` en el campo y `personaBody` en filas. Siempre en `ink`, nunca en azul.
- **IBM Plex Mono** 300 (`mono`) solo para datos: piezas de comunicación y el panel del investigador.
- Nada en mayúsculas sostenidas ni con letras espaciadas. Las cifras de tiempo usan números tabulares: «6 min de 15».

## El renglón

- `Subrayado` y `Signature` lo dibujan en texto: 0,09 em de grosor, 0,14 em bajo la línea base y continuo bajo la palabra. `Subrayado` va en `blue`; `Signature`, en `blue` o, con `category`, en `<cat>-line`.
- `RenglonField` es el campo donde la persona escribe: su texto en itálica (`persona`) sobre una línea de 1,5 px que pasa a 2,5 px con el foco, en `blue` o en `<cat>-line`.
- El del logotipo es una cápsula del grosor del travesaño de la «e» (0,078 em), a 0,088 em bajo la línea base, que pasa la «o» en una altura de x.
- En afiches, el renglón bajo la palabra de la persona puede seguir hasta el borde: deja lugar.
- Nunca doble, punteado, como enlace ni bajo texto azul.

## Logotipo, símbolo e ícono

- «relevo» en minúsculas, en Schibsted Grotesk 600 con −2,2 % y kerning propio, sobre su renglón. En código: `Wordmark` (`tone` ink, paper, white, on-blue o mono; `renglon` con una categoría o una familia; `compact`).
- Archivos en el grupo Logotipo: `relevo.svg` (principal), `relevo-papel.svg` (sobre tinta), `relevo-blanco.svg` (sobre `azul-500`), `relevo-tinta.svg` (una tinta), `relevo-azul-profundo.svg` (impresión), `relevo-compacto.svg`, `relevo-trama.svg` (momentos de marca, desde 240 px), `relevo-<familia>.svg` (piezas de una categoría), las tres firmas, `construccion.svg` y las dos láminas de exploración.
- Ancho mínimo: 64 px. Espacio libre: la altura de la «o». El símbolo nunca va al lado del logotipo.
- Símbolo: la «r» con su renglón (`Symbol`, `simbolo.svg`). Ícono de la app: el símbolo en una caja de 512 con esquinas de 114 (`AppIcon`, `icono-azul.svg` principal, `icono-tinta.svg`, `icono-papel.svg`, `icono-trama.svg` desde 96 px), capas Android, ícono de notificación y favicon.
- El grupo Logotipo 3.0 es histórico: no lo uses en piezas nuevas.

## Iconografía

- 135 íconos propios (`Icon`, grupo Iconos) en una retícula de 24 con área útil de 20, trazo de 1,75 que sigue al tamaño (`stroke-16` a `stroke-48`) o al peso del texto (`stroke-semibold`), extremos y uniones redondeados.
- 3.1 suma 33: lugares y objetos donde empieza una actividad (su renglón azul es el suelo), actividades nuevas, el testigo con sus estados y los tres ámbitos.
- Contorno para lo normal; lleno para lo elegido (`inicio-lleno`, `ruta-llena`, `perfil-lleno`). Los íconos propios de Relevo llevan el renglón en `blue`.
- Un ícono de actividad puede ir en el `<cat>-line` de su categoría (`mono`). Siempre con una palabra al lado, salvo en botones redondos con nombre accesible.
- Íconos en trama (16 × 16 puntos) solo en momentos de marca. Sin emoji en el texto.

## Ilustración, patrones e imágenes

- Ilustraciones (grupo Ilustraciones): un lugar por categoría, con todo listo y sin personas; el renglón de la categoría como suelo, sombras en trama y el parlante con su banda azul. Para piezas, presentaciones, la memoria y estados vacíos, no para las ideas de la app.
- Patrones (grupo Patrones): renglones, cuadrícula de puntos, un campo de trama por categoría y los renglones de colores. Son fondos: el texto va en una tarjeta.
- Las fotos muestran el comienzo de una actividad, no su resultado. El texto va fuera de la foto (`PhotoCard`) o en una banda de vidrio (`PhotoHero`). La actividad activa va en trama (`Trama mode="foto"`, con `color` igual a su categoría; en `PhotoCard`, `PictureTile` y `PhotoHero`, con `category`). Las seis fotos del grupo Fotos son CC0; las otras fotos de la app fueron generadas con IA y se presentan así.

## Aplicaciones

El grupo Aplicaciones tiene 24 piezas: seis afiches «Vuelve a…», un carrusel y dos historias para redes, una publicación con las categorías, seis láminas de presentación, la portada de la memoria, la lámina del objeto, una tarjeta de bolsillo y un pliego de stickers. Las páginas Afiches, Redes, Presentacion, Impresos y Objeto las muestran con sus razones. La sección Aplicaciones dice cómo armar piezas nuevas.

## Forma, espacio y vidrio

- Margen de pantalla de 20 px (`margin`); 28 px entre secciones (`section-gap`). Rellenos de la app, sin redondear (`space-*`).
- Cápsula (`radius-control`) para todo lo que se toca; `radius-panel` (28) en tarjetas, `radius-tile` (22) en fotos y `radius-sheet` (34) en hojas.
- Vidrio: tinte `glass` sobre un desenfoque de 12, 16 o 24 px, con un borde de 0,75 px en `glass-edge`. Sin brillos ni degradados de luz.
- Casi sin sombras: `shadow-thumb` en el control segmentado y `shadow-glass` en tarjetas de vidrio sobre la trama.
- Áreas táctiles de 44 px o más (`size-*`).

## Movimiento y sonido

- Transiciones de 200 a 250 ms con `cubic-bezier(.2, 0, 0, 1)`, sin rebotes. Al presionar, los controles se hunden a 92–97 %.
- La animación de marca es escribir sobre el renglón: 450 ms en `Signature`; en el logotipo animado, el renglón, luego las letras y al final el paso de la «o» (grupo Movimiento).
- Firma sonora: dos notas de madera que bajan, 587 → 440 Hz, una vez, 2,2 s (D-071). No reemplaza la señal de 30 segundos del parlante.
- Si el sistema pide reducir el movimiento, no hay animaciones: se muestra el estado final.

## Accesibilidad

- Texto a 4,5:1 o más en los dos temas; controles, íconos, renglones y el foco a 3:1 o más. Las notas de cada color dicen sobre qué fondos se usa.
- Foco de teclado: `focus-ring`, 2 px del papel y 2 px de `blue`.
- Nada se dice solo con color: las categorías van con ícono y nombre, la voz de la persona con itálica, y el tiempo con su cifra escrita.
- `gray` es para lo deshabilitado; no se usa para texto que haya que leer.
- La app respeta el tamaño de texto del sistema y suma un 15 % con «Texto grande».

## Componentes

`components/bundle.js` define `window.Relevo` con 46 componentes en React 18, escritos a mano desde `ui/components` de la app 2.18 con las reglas de 3.1. Cargar en este orden: `tokens.css`, `components/bundle.css` (trae Newsreader e IBM Plex Mono de Google Fonts), React 18, ReactDOM 18 y `components/bundle.js`. Nuevos en 3.1: `Symbol`, `AppIcon` y `ActivityTag`. `Signature`, `RenglonField` y las fotos aceptan `category`; `Wordmark` y `Symbol`, `renglon`; `Trama`, `color`. Las páginas Pantallas, Logotipo, Tipografia, Paleta, Iconografia, Patrones, Ilustraciones, Afiches, Redes, Presentacion, Impresos, Objeto y Movimiento muestran el sistema armado.

## Decisiones abiertas

Mientras el autor decide, se usa: **Newsreader** como serif (la alternativa es Instrument Serif; cambia solo `type.families.serif`), **los seis colores de la casa** junto al azul del sistema (la alternativa es volver a una sola tinta: basta no usar los roles de categoría), **la itálica para la voz de la persona** y **trama en íconos solo en momentos de marca**.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** libro de marca 3.1: renglón que hace lugar, dos voces, colores de la casa, 135 íconos, ilustraciones, patrones, aplicaciones, movimiento y sonido.
- **Cómo estaba antes:** libro de marca 3.0, de una sola tinta, con la voz de la persona en azul.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
