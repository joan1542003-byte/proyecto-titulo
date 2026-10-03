# Las ganas estaban: propuesta 3.4

**Fecha:** 3 de octubre de 2026. **Estado:** propuesta D-102. Reemplaza en la propuesta 3.3 (D-101) la serif, el desenfoque y el renglón azul en las piezas, y en las propuestas 3.2 y 3.3 los titulares con nombres de categoría. No cambia todavía la app ni el sistema publicado. **Dónde está:**

- Lámina publicada en claude.ai: [Las ganas estaban](https://claude.ai/artifact/TLqwUeq6KhgbFXvbVRsXff) (privada del autor).
- Copia en el repositorio: [`las-ganas-estaban-2026-10-03/`](las-ganas-estaban-2026-10-03/las-ganas-estaban.html), con las 19 piezas en PNG y su generador.

## Qué pidió el autor

Sobre la versión 2 de la [propuesta 3.3](30_volver-a-enfocar-2026-10-03.md), el autor hizo cuatro correcciones:

1. Los afiches citaban textualmente palabras de usuario, como «Cuidar la casa y a mí», en vez de comunicar con lo que el proyecto sabe.
2. La serif no funciona.
3. El marcador azul no puede estar en todas las piezas.
4. Los colores deben combinar entre sí; dio como ejemplo un verde neón con morado.

## La idea

Cada pieza dice algo que sabemos: un hallazgo de la encuesta, el principio en que se basa Relevo o lo que hace la app. Se dice en una frase corta, en tú y en presente, y el dato va con su fuente. El nombre de la propuesta sale del primer hallazgo: en 43 de 47 casos, las ganas de hacer otra cosa estaban.

## Qué dice cada pieza

| Frase | Lo que sabemos | Fuente |
| --- | --- | --- |
| «Las ganas estaban.» | 43 de 47 personas querían hacer otra cosa mientras seguían en el teléfono. | [Encuesta en línea](../03_usuarios/encuesta-53-respuestas-2026-09.md) |
| «Pasa donde están tus cosas.» | 44 de 47 estaban en casa cuando siguieron en el teléfono más de lo que querían. | Encuesta en línea |
| «Sabes por dónde empezar.» | 42 de 43 nombraron el primer paso de lo que querían hacer. | Encuesta en línea |
| «Lo que querías hacer vuelve cuando algo te lo recuerda.» | Cuando una persona está absorta en otra tarea, recuperar una intención depende de que aparezca una señal ligada a ella. | McDaniel y Einstein (2000); hipótesis D-091 |
| «El libro sigue en el velador.» y cinco objetos más | Relevo guarda la actividad, cómo empieza y dónde, y suena en ese lugar cuando se suma el tiempo elegido en las apps. | App 2.18; [actividades e imágenes](23_actividades-e-imagenes-2026-09-29.md) |

- **Afiches de dato.** Cierran con una línea sobre Relevo: «Relevo te recuerda esa otra cosa donde empieza», «Relevo se queda ahí, junto a lo que querías hacer» y «Relevo te lo muestra cuando suena». Llevan la fuente: «Encuesta en línea, 53 respuestas, no representativa».
- **Afiches del objeto.** El libro en el velador, las zapatillas junto a la puerta, las acuarelas en la mesa, la correa donde la dejaste, los apuntes en el escritorio y la carta a medias. Debajo, la misma línea: «Relevo suena ahí cuando sumas el tiempo que elegiste en tus apps». Muestran con las cosas de la casa el principio de la señal ligada a la acción.
- **Nada de nombres de categoría.** Las categorías siguen en la app, pero no aparecen en las piezas. Las palabras de la persona quedan donde ella escribe: la app, la historia y la tarjeta.

## Color: seis pares

Cada par une un color profundo con uno vivo de tono vecino u opuesto, y sale de la actividad de su foto. El primero es el de la marca y responde al ejemplo del autor: el azul de Relevo con un lima.

| Par | Profundo | Vivo | Contraste | Peor caso con visión del color simulada | De dónde sale | Dónde se usa |
| --- | --- | --- | --- | --- | --- | --- |
| Azul y lima | `#3D38F5` | `#D8FF4A` | 5,9:1 | 4,2:1 (protanopía) | El azul de Relevo con un lima de tono casi opuesto | Leer, la tarjeta, la app y el primer dato |
| Noche y naranja | `#1E1B5C` | `#FF8636` | 6,4:1 | 4,9:1 (protanopía) | El cielo y el atardecer cuando sales a caminar | Salir a caminar y el dato del primer paso |
| Violeta y rosa | `#4C1D95` | `#FF9FD8` | 5,8:1 | 4,7:1 (protanopía) | Dos pigmentos vecinos en la caja de acuarelas | Pintar, el dato de la casa y la historia |
| Bosque y menta | `#0B5D3B` | `#8CFFB9` | 6,5:1 | 6,4:1 (tritanopía) | Las hojas y el pasto del paseo con el perro | Pasear al perro |
| Azul y celeste | `#0F4C81` | `#9EDCFF` | 6,0:1 | 5,5:1 (tritanopía) | La tinta y los renglones celestes del cuaderno | Estudiar y las portadas de sección |
| Rojo y rosa pálido | `#B71A29` | `#FFE1E8` | 5,4:1 | 4,6:1 (deuteranopía) | Un sobre rojo y el papel de una carta | Escribirle a alguien a mano |

- **Legibles entre sí.** Todos los pares superan 4,5:1, el mínimo de WCAG 2.2 para texto normal, así que el texto chico se lee en cualquiera de los dos sentidos. Con visión del color simulada (Machado et al., 2009), cinco pares siguen sobre 4,5:1; el de la marca baja a 4,2:1 con protanopía porque su azul no se cambia. Para llegar a esto se aclaró el naranja (antes `#FF7A2F`) y se oscureció el rojo (antes `#C81E2B`).
- **Un par por pieza.** Los afiches del objeto van en el color profundo con el texto en el vivo; los de dato, al revés. La app y las láminas de ideas siguen en papel `#FAFAF7` y tinta `#141519`; el par aparece en la tarjeta del relevo activo, la señal, las ideas de Preparar y las portadas de sección.
- **La foto, teñida y nítida.** Un filtro SVG pasa la foto a gris y da a cada gris una mezcla de los dos colores del par: las sombras toman el profundo y las luces el vivo (duotono). Las fotos claras llevan una curva que oscurece los medios tonos (exponente de 1 a 1,9). La foto ya no se desenfoca, porque el objeto que muestra es parte del mensaje.

## Letra

| Rol | Letra | Uso |
| --- | --- | --- |
| Titulares y números | Schibsted Grotesk 780 a 820, apretada (−4 a −6 %) | Una frase por pieza, las cifras y la actividad de la persona en grande |
| Textos e interfaz | Schibsted Grotesk 450 a 650 | La línea sobre Relevo, explicaciones, botones; el logotipo sigue en 600 |
| Datos | IBM Plex Mono 400 | Solo fuentes de los datos, números de lámina y códigos de color |

No hay serif. Las palabras de la persona se distinguen por tamaño: «Vuelve a» va chico y su actividad, grande.

## El renglón azul

- **Queda en:** el logotipo, el campo donde se escribe en la app (la línea bajo el texto y el cursor) y la pestaña activa.
- **No va en:** afiches, láminas, la historia ni bajo un titular. En las piezas de color, el logotipo va entero en el color vivo del par, sin azul.
- **Para escribir:** la historia y el frente de la tarjeta dejan una línea vacía en el color del par.

## Piezas

Diecinueve piezas en [`las-ganas-estaban-2026-10-03/piezas/`](las-ganas-estaban-2026-10-03/piezas/):

- tres afiches de dato y seis afiches del objeto;
- tres pantallas de la app: Inicio con el relevo activo, Preparar y la señal;
- una historia para escribir sobre la línea;
- la tarjeta de bolsillo, frente y reverso;
- cuatro láminas: un dato, por qué funciona, cómo funciona y una portada de sección.

Los textos de la app vienen de la 2.18 y de las ideas de actividades; los datos, de la encuesta; ninguno es inventado. Los números de lámina (03, 05, 06 y 07) son de ejemplo.

## Fundamentos

| Fuente | Qué hizo | Qué se toma |
| --- | --- | --- |
| Collins para Spotify (Design Week, 2015) | Llevó la paleta de 2 a 31 colores y sumó fotos en duotono para pasar de marca de tecnología a marca de entretenimiento. | Cada foto teñida con un par, y un par por pieza. |
| Collins para Twitch (Creative Bloq, 2019) | Un morado propio más brillante, «Extruded Purple», con una paleta nueva de colores vivos. | El azul de Relevo como color de marca y, a su lado, un vivo de tono opuesto. |
| Equipo creativo propio de Spotify, «Thanks 2016, It's Been Weird» (Glenday, 2016) | Su mayor campaña hasta entonces, en 14 países, con afiches hechos a partir de datos reales de escucha. | Un dato real dicho en una frase cercana, con su fuente. |
| Bakken & Bæck, Schibsted Grotesk (s. f.) | Grotesca pensada para interfaces digitales, con licencia libre. | Una sola letra: gruesa en titulares y números, regular en textos. |
| McDaniel y Einstein (2000) | Marco multiproceso: cuando la persona está absorta, recordar una intención depende de una señal ligada a la acción. | Los afiches del objeto y la lámina «Por qué funciona». |
| [Encuesta en línea](../03_usuarios/encuesta-53-respuestas-2026-09.md) | 53 respuestas; cifras de episodios, lugar y primer paso. | Los tres afiches de dato y la lámina del dato. |

## Qué se evitó

- Nombres de categorías o palabras de una persona como titular.
- Serif y letra escrita a mano.
- El renglón azul en piezas gráficas y bajo los titulares.
- Dos pares en una pieza, un color suelto sin su par y texto sobre la foto.
- Degradados, brillos, sombras de adorno, emoji, íconos de banco, frases hechas, signos de exclamación y reproches.

## Preguntas para el autor

1. ¿Los titulares dicen con claridad lo que sabemos, o falta algún hallazgo?
2. ¿Los seis pares reemplazan la paleta viva de la 3.2 y la luz de la 3.3?
3. ¿Llevamos esta versión al sistema de diseño publicado y a la app 2.19?

## Límites

- Son maquetas: no se probaron con personas, en un teléfono real ni impresas.
- La encuesta tiene respuestas reales editadas antes de exportarse, de una muestra no representativa, y mide preferencias, no uso. Las piezas citan solo cifras y siempre con su fuente; la codificación de las respuestas abiertas espera la revisión del autor.
- Dos de las seis fotos, las zapatillas y la correa, son imágenes generadas con IA de la app. Hay que cambiarlas por fotos reales antes de mostrarlas fuera del proyecto.
- El duotono usa un filtro SVG y se revisó solo en Chrome.
- La lámina tiene tema oscuro; las piezas mantienen sus colores. No hay todavía tema oscuro de la app para esta propuesta.

## Referencias

Bakken & Bæck. (s. f.). *Schibsted Grotesk* [Tipografía]. GitHub. https://github.com/schibsted/schibsted-grotesk

Creative Bloq. (2019). *Twitch's rebrand is here – and you're already part of it*. https://www.creativebloq.com/news/twitch-rebrand

Design Week. (2015). *Spotify undergoes colourful brand refresh*. https://www.designweek.co.uk/spotify-undergoes-colourful-brand-refresh/

Glenday, J. (29 de noviembre de 2016). Spotify celebrates 'weird' 2016 in largest ever campaign push. *The Drum*. https://www.thedrum.com/news/spotify-celebrates-weird-2016-largest-ever-campaign-push

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

McDaniel, M. A. y Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*(7), S127–S144. https://doi.org/10.1002/acp.775

W3C. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-10-03 — Creación

- **Qué cambió:** se documentó la propuesta 3.4, «Las ganas estaban»: titulares con hallazgos de la encuesta, el principio de la señal y lo que hace Relevo; seis pares de color con fotos en duotono; una sola letra; el renglón azul solo en el logotipo y donde se escribe; diecinueve piezas.
- **Cómo estaba antes:** la propuesta 3.3 usaba Newsreader para las palabras de la persona, fotos desenfocadas en luz suave, un renglón azul bajo esas palabras y nombres de categoría en los afiches.
- **Por qué:** el autor señaló que los afiches citaban palabras de usuario sin comunicar lo que se sabe, que la serif no funcionaba y que el marcador azul no podía estar en todas las piezas, y pidió colores que combinen.
