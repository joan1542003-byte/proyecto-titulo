Relevo es un sistema phygital: una app y un parlante que suena en el lugar donde empieza una actividad que la persona quería hacer, cuando lleva un rato en el teléfono. Su identidad es **el subrayado**: un renglón azul bajo lo que importa. En la app marca las palabras de la persona («Vuelve a <u>leer</u>.»); en la presentación, la idea clave; en la casa, el objeto subraya el lugar. Este sistema es la versión 3.0: la app 2.18 más la identidad D-098 (azul eléctrico, renglón, trama de puntos y serif en titulares).

## Principios

- **El renglón marca lo que importa.** Uno por pantalla, lámina o afiche, en `blue`, bajo palabras en `ink`. Nunca bajo texto azul.
- **Un solo azul, y con función.** `blue` (el `azul-500` de la presentación, `#3D38F5`) solo para el logotipo, el renglón, el tiempo y dónde estás. Los botones son de tinta. El azul ocupa cerca del 10 % de una pantalla.
- **La trama en momentos de marca.** Puntos azules en la señal, las fotos de actividades en Inicio, el ícono de la app y las piezas de comunicación. No en cada pantalla.
- **Papel para leer, vidrio para navegar.** El contenido va en `paper` y `card`; las barras, pestañas, botones de la barra y hojas, en vidrio. Todo texto sobre una foto o una trama va en una tarjeta.
- **Tranquila y concreta.** Pocas palabras, sin mayúsculas sostenidas, sin signos de exclamación y sin juzgar el uso del teléfono.

## Voz

Relevo habla de tú, con frases cortas y verbos concretos. Se nombra en tercera persona («Relevo te avisa…») y el equipo del estudio habla en primera plural («Lo guardamos junto a tu código…»). Los títulos son preguntas o frases breves en minúscula de oración: «¿Qué quieres hacer?», «Tu semana», «Arma tu ruta». Cada aviso dice qué pasó y qué hacer. En el texto, «Relevo» va con mayúscula inicial, como todo nombre propio; en minúsculas va solo el logotipo. La sección Voz y tono tiene las reglas y los ejemplos.

## Color

- Fondo: `paper`. Contenido agrupado: `card`. Rellenos de controles secundarios: `mist`. Separadores: `line` (decorativa; nunca el único borde de un control).
- Texto: `ink` para todo; `graphite` para lo secundario, rótulos y pies. Ambos superan 4,5:1 sobre `paper`, `card` y `mist` en los dos temas.
- `blue` es el azul de la interfaz: renglón, `TimeDots`, `ProgressLine`, `StepProgress`, la pestaña elegida y el foco. `voice` es un alias de `blue` para lo que escribió la persona cuando aparece como valor de una fila.
- `error`, `error-soft` y `error-tint` solo para fallas del sistema; nunca para lo que hizo la persona.
- Sobre un relleno de `ink`, el texto es `on-ink`; sobre `blue`, `on-blue`.
- Piezas fijas (logotipo, ícono, afiches, impresión): `tinta`, `papel`, `blanco` y la escala `azul-700`, `azul-500`, `azul-300`, `azul-200`, `azul-50`.
- Hay dos temas, Claro y Oscuro; el oscuro aclara el azul a `azul-300`. La sección Color y variantes tiene las combinaciones permitidas y la variante «azul a celeste».

## Tipografía

- **Schibsted Grotesk** (variable 400–900, `fonts/schibsted-grotesk.ttf`) para toda la interfaz, el logotipo y la presentación. La escala del grupo Interfaz es la de la app: `body` 17/26, `headline` 17/22 en 600, `title2` 22/28, `largeTitle` 34/40 en 650 con −2 %.
- **Newsreader** (serif con tamaño óptico, Google Fonts) para la frase principal de una pantalla o pieza, desde 28 px: `displayTitle` 36/40 en pantallas principales, `displayCard` 30/34 para la frase del relevo, `displaySignal` 44/46 en la señal, `displaySlide` y `displayPoster` en láminas y afiches. Una frase en serif por pantalla.
- **IBM Plex Mono** 300 (`mono`) solo en piezas de comunicación y en el panel del investigador.
- Nada en mayúsculas sostenidas ni con letras espaciadas. Los rótulos se escriben como frase («Ahora», «La última vez»).
- Las cifras de tiempo usan números tabulares: «6 min de 15», «1 h 15 min».

## El renglón

- `Subrayado` (en texto) y `Signature` (la firma «Vuelve a ___.») dibujan el renglón: `blue`, 0,09 em de grosor y continuo bajo la palabra.
- `RenglonField` es el campo donde la persona escribe: texto en `ink` sobre una línea `blue` de 1,5 px, que pasa a 2,5 px con el foco.
- El logotipo lleva su propio renglón: del ancho de la palabra y 0,075 em de alto.
- Uno por pantalla. No se usa como enlace, ni doble, ni punteado, ni bajo texto azul.

## La trama

- Puntos en retícula cuadrada: 6 px en pantalla (`trama-pitch`), 4 px en fotos pequeñas y 2 mm en impresión. El punto crece con la sombra, de 16 % a 104 % de la distancia.
- Una sola tinta: `blue` sobre `paper`, `card` o blanco, con los claros en `blue-dots`.
- Cuatro usos: la señal (late mientras suena), la foto de la actividad activa en Inicio, el tiempo como puntos (`TimeDots`: un punto por minuto) y el ícono de la app con las portadas.
- El componente `Trama` la dibuja; los archivos del grupo Trama sirven para piezas fijas. La sección Trama explica cómo construirla.

## Logotipo e ícono

- «relevo» en minúsculas, Schibsted Grotesk 650, sobre su renglón. Archivos en el grupo Logotipo: `relevo-tinta.svg` (principal, sobre `paper` o blanco), `relevo-papel.svg` (sobre `tinta`) y `relevo-blanco.svg` (sobre `azul-500`). En código, el componente `Wordmark`.
- Ancho mínimo de 64 px. Espacio libre alrededor: la altura de la «o».
- Ícono de la app: la «r» con su renglón. `icono-azul.svg` es el principal; `icono-tinta.svg` para fondos claros; `icono-trama.svg` solo desde 96 px.
- La sección Logotipo, renglón e ícono tiene la construcción y los usos incorrectos.

## Iconografía

- 102 íconos propios (`Icon`, grupo Iconos), dibujados para Relevo en una retícula de 24 con área útil de 20, extremos y uniones redondeados. De Material Design y de SF Symbols se tomaron reglas, no dibujos.
- El trazo sigue al tamaño (`stroke-16` a `stroke-48`) o al peso del texto (`stroke-semibold` junto a texto en 600).
- Contorno para lo normal; lleno para lo elegido (`inicio-lleno`, `ruta-llena`, `perfil-lleno`).
- Los íconos propios de Relevo (actividad, para empezar, lugar, parlante, apps elegidas) llevan el renglón en `blue`.
- Siempre con una palabra al lado, salvo en botones redondos con nombre accesible. Los SVG del grupo Iconos están en `tinta` con el renglón en `azul-500`.
- Íconos en trama (16 × 16 puntos) solo en momentos de marca: el ícono de la app, la señal, estados vacíos y afiches.
- Sin emoji en el texto. Los emoji Noto 3D se usan solo como imagen del perfil.

## Imágenes

- Las fotos muestran el comienzo de una actividad, no su resultado: un libro abierto, las manos sobre la masa.
- El texto va fuera de la foto (`PhotoCard`) o sobre una banda de vidrio (`PhotoHero`), nunca sobre la foto sin más.
- La actividad activa en Inicio va en trama azul (`Trama mode="foto"`); los carruseles usan la foto normal.
- Las seis fotos del grupo Fotos son CC0. Las otras fotos de la app fueron generadas con IA y se presentan como tales.

## Forma, espacio y vidrio

- Margen de pantalla de 20 px (`margin`); 28 px entre secciones (`section-gap`). Los rellenos son los de la app, sin redondear (`space-*`).
- Cápsula (`radius-control`) para todo lo que se toca; `radius-panel` (28) en tarjetas, `radius-tile` (22) en fotos y `radius-sheet` (34) en hojas.
- Vidrio: tinte `glass` sobre un desenfoque de 12 px (botones), 16 px (pestañas) o 24 px (hojas), con un borde de 0,75 px en `glass-edge`. Sin brillos, reflejos ni degradados de luz.
- Casi sin sombras: `shadow-thumb` en el control segmentado y `shadow-glass` en tarjetas de vidrio sobre la trama.
- Áreas táctiles de 44 px o más (`size-*`).

## Movimiento

- Transiciones de 200 a 250 ms con la curva `cubic-bezier(.2, 0, 0, 1)`, sin rebotes. Al presionar, los controles se hunden a 92–97 %.
- La única animación de marca es escribir sobre el renglón: 450 ms, lineal (`Signature`).
- La trama de la señal late mientras suena y se detiene fuera de la vista.
- Si el sistema pide reducir el movimiento, no hay animaciones.

## Accesibilidad

- Texto a 4,5:1 o más en los dos temas; controles, íconos y el foco a 3:1 o más. Las notas de cada color dicen sobre qué fondos se puede usar.
- Foco de teclado: `focus-ring`, 2 px del papel y 2 px de `blue` sólido.
- El tiempo nunca se dice solo con color: `TimeDots` y `ProgressLine` tienen su cifra escrita y su lectura para lectores de pantalla.
- `gray` es para lo deshabilitado; no se usa para texto que haya que leer.
- La app respeta el tamaño de texto del sistema y suma un 15 % con «Texto grande».

## Componentes

`components/bundle.js` define `window.Relevo` con 43 componentes en React 18, escritos a mano desde `ui/components` de la app 2.18 con las reglas de 3.0. Cargar en este orden: `tokens.css`, `components/bundle.css` (trae Newsreader e IBM Plex Mono de Google Fonts), React 18, ReactDOM 18 y `components/bundle.js`. La ficha **Pantallas** muestra Inicio, Preparar y la señal armadas solo con estos componentes. Los cambios de 3.0 respecto de la app están en la guía de cada componente (renglón azul en el campo, firma en serif, tiempo en azul, pestaña elegida con ícono lleno y renglón, bordes de selección en `graphite`).

## Decisiones abiertas

Lo que el autor aún no cerró se usa así mientras tanto: **Newsreader** como serif de titulares (la alternativa es Instrument Serif; cambia solo `type.families.serif`), **una sola tinta azul** (la variante «azul a celeste» queda descrita en Color y variantes) y **trama en íconos solo en momentos de marca**.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
