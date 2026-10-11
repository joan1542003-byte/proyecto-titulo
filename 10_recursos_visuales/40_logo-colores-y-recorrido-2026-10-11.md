# Logo, colores de las actividades y recorrido

**Fecha:** 11 de octubre de 2026. **Decisiones:** D-125 (logo) y D-126 (colores de las actividades y su uso en el recorrido), propuestas pendientes de la revisión del autor. **Lámina:** [relevo-aplicado.html](logo-relevo-2026-10-11/relevo-aplicado.html), también publicada como [página privada en claude.ai](https://claude.ai/artifact/5FCdqi76iF52dfNoFyYoeX). **Archivos del logo:** [12 SVG](logo-relevo-2026-10-11).

## Pedido

El autor pidió tres cosas:

- Fundamentar los colores también en Chile o en Latinoamérica, si existe un estudio.
- Pensar los colores que nombran las actividades dentro de todo el sistema: el recorrido, las pantallas, los wireframes y el uso de colores e íconos.
- Un logo de Relevo fundamentado, simple y hermoso.

## Qué se hizo

- **Logo:** una marca de cuatro luces y un logotipo en Chillax Semibold, con 12 archivos SVG: versiones a color, en una tinta y en blanco, horizontal y vertical, ícono de la app y notificación de Android.
- **Evidencia de Chile y Latinoamérica:** cuatro fuentes, con lo que cada una confirma o cambia.
- **Colores de las actividades:** siete familias de cielos, con reglas de uso.
- **Recorrido y pantallas:** el flujo de la app 2.30 y 12 wireframes en gris, con notas de dónde va cada color y cada ícono.
- **Una lámina** que reúne todo, revisada en escritorio y en un teléfono de 390 px.

## Logo

### Concepto

Cuatro luces que se pasan el turno. Cada luz es un peldaño de Relevo, en el sentido del reloj desde arriba:

| Luz | Color | Papel |
| --- | --- | --- |
| Arriba | `#FFD54A` amarillo | Tu tiempo |
| Derecha | `#9DD6F4` celeste | Tu primer paso |
| Abajo | `#B3E788` lima | El lugar donde empiezas (antes, el Tag: ver D-127) |
| Izquierda | `#F6A3CB` rosa | Lo que decides |

Cada luz queda bajo la siguiente, como el testigo que pasa de mano en una carrera de relevos. El centro queda abierto: es el momento del traspaso, de la pantalla a lo que la persona quería hacer.

### Construcción

- Cuatro círculos iguales de radio 29, a 21 del centro, en una unidad de 100.
- Cada luz se recorta con el círculo siguiente agrandado: un corte de 3,4 en tamaño normal, 6,5 en tamaños chicos y 7 en la notificación de 24 dp.
- Cada luz es un trazado plano de dos arcos: sin máscaras, sin transparencias y sin mezclas. Funciona igual en cualquier programa y en una sola tinta.
- Reemplaza a la marca de D-122, que mezclaba las luces oscureciendo: en el centro, los cuatro colores juntos daban un tono turbio.

### Letra

- **Chillax Semibold**, de Indian Type Foundry, distribuida por Fontshare.
- Se compararon 20 letras sin serifa de Fontshare y llegaron cinco al final: Chillax 600 y 700, Cabinet Grotesk 800, Pally 700 y Panchang 600, con Instrument Sans 700 de referencia.
- Ganó Chillax porque sus formas son redondas como las luces:
  - Su «o» es casi un círculo: ancho y alto 1,03.
  - La «e» y la «r» terminan en curvas abiertas.
  - En chico no pierde la forma (altura x de 0,495 del cuerpo).
- No es de Google Fonts, como pide la regla del autor para el logotipo. Instrument Sans sigue siendo la letra de la app.
- **Licencia:** ITF Free Font License. Permite el uso personal y comercial. Un logo hecho con la letra no es obra derivada y pertenece a quien lo crea.
- **Archivos:**
  - El logotipo va convertido a trazos con opentype.js, con un interletrado de −0,02.
  - El archivo de la fuente no se guarda en el repositorio.

### Versiones y reglas de uso

| Archivo | Uso |
| --- | --- |
| `relevo-logo-horizontal.svg` | La versión principal |
| `relevo-logo-vertical.svg` | Espacios cuadrados y portadas |
| `relevo-marca.svg` | La marca sola, desde 24 px |
| `relevo-marca-chica.svg` | La marca de 16 a 23 px, con el corte más ancho |
| `relevo-marca-tinta.svg` y `relevo-logo-horizontal-tinta.svg` | Una sola tinta: impresión, sellos, fotocopias |
| `relevo-marca-blanca.svg`, `relevo-logo-horizontal-blanco.svg` y `relevo-logotipo-blanco.svg` | Sobre fondos oscuros |
| `relevo-logotipo.svg` | El nombre solo |
| `relevo-icono-app.svg` | Ícono de la app: superelipse blanca, con la marca al 62 % |
| `relevo-notificacion.svg` | Ícono de notificación de Android: silueta blanca de 24 dp |

- **Espacio libre:** alrededor del logo queda libre al menos la mitad del ancho de la marca.
- **Tamaños mínimos:** la marca, 16 px con su versión chica; el logo horizontal, 96 px de ancho.
- **Composición horizontal:** la marca mide 1,18 veces la altura de la «l» y se centra en ella. La separación es 0,30 del cuerpo de la letra.
- **Color del logotipo:** siempre en minúsculas, y en tinta o en blanco, nunca de colores.
- **Logo blanco:** solo sobre fondos oscuros. Sobre el aura clara se pierde.
- **Con degradado (D-127):** desde 48 px se puede usar la versión «Luz» (`*-degradado.svg`): cada luz es más clara afuera y más intensa hacia el centro.
- **Prohibido:** girarlo, rellenar el centro, cambiar el orden de las luces o agregarle sombras o brillos.

### Fundamento

- **Dice lo que hace.** En seis estudios, los logos que comunican qué hace la marca se evalúan mejor y parecen más auténticos, sobre todo en marcas que la gente aún no conoce (Luffarelli et al., 2019). Relevo es nuevo: donde aún no lo conocen, el logo va con una frase que explique qué hace.
- **Redondo, porque acompaña.** En cinco experimentos, las formas circulares hicieron pensar en suavidad, comodidad y cuidado, y las angulosas en dureza (Jiang et al., 2016). Relevo no debe sonar a control.
- **Plano y sin transparencias.** Slack rehízo su logo en 2019 con Pentagram, el estudio de Michael Bierut:
  - El logo anterior tenía once colores que se cruzaban con transparencia, y Slack lo describió como muy fácil de hacer mal (Slack, 2019).
  - El nuevo quedó en cuatro colores y formas simples que funcionan en cualquier tamaño (Design Week, 2019).

## Color desde Chile y Latinoamérica

Se buscó, en español y en inglés, un estudio de color y emoción hecho solo en Chile, y no apareció. Sí hay cuatro fuentes útiles:

| Fuente | Muestra | Hallazgos | Qué cambia o confirma en Relevo |
| --- | --- | --- | --- |
| UNAM (2023), «El color del miedo en diferentes entornos» | 1.066 personas de México, Argentina y Chile, más un 10 % de otros países de habla hispana; encuesta de 34 preguntas con paleta de color | El miedo se asocia con el negro (52,4 %), el rojo (13,5 %) y el gris (8,9 %). El celeste claro y el magenta son los menos asociados al miedo. El miedo al fracaso se asocia con el gris; los cambios y el éxito, con el blanco y el amarillo | Ningún estado de la persona va en negro, gris o rojo. El celeste claro del primer paso queda respaldado. Dormir usa azul de noche, nunca negro |
| Restrepo Betancur (2022) | 2.400 universitarios de Medellín, mitad hombres y mitad mujeres | Amarillo: alegría e iluminación. Verde: naturaleza y esperanza. Azul: mar y cielo, con cerca de 75 % de aceptación. Rosa: ternura y delicadeza, más preferido por mujeres y rechazado por más del 11 %. Morado: luto y dolor. Gris: mal tiempo y tristeza | El lima del Tag suma esperanza. El rosa de lo que decides queda claro y se prueba con hombres y mujeres. El lila del aura queda claro y opcional, lejos del morado |
| Sánchez-Borrero et al. (2026) | 260 universitarios de la Pontificia Universidad Católica del Ecuador | Los conceptos con raíz sensorial o cultural tienen colores consistentes; los abstractos, como «creativo», se dispersan | Las actividades concretas toman colores con raíz sensorial. «Crear» usa un cielo de varios tonos. Los papeles abstractos de Relevo van siempre con ícono y palabra |
| Jonauskaite et al. (2020, 2024) | 30 y 31 países, entre ellos México y Colombia | Las asociaciones se parecen mucho entre países (r = 0,88) y más entre los que comparten lengua y cercanía | Es probable que en Chile se parezcan a las de México, Colombia y España. Es una inferencia, no un dato chileno |

- **Límite de la UNAM:** es un boletín de prensa sobre una ponencia, no un artículo revisado por pares. Se usa como apoyo, no como prueba.
- **Lo que falta:** preguntar a las personas de la prueba qué color asocian a su actividad.

## Colores de las actividades

### Dos lenguajes que no se mezclan

- **Fichas:** pastel planas, chicas, con ícono en tinta. Dicen qué hace Relevo, con la paleta 2 de D-124.
- **Cielos:** degradados con grano y volumen. Dicen qué quiere hacer la persona.

### Siete familias

| Familia | Cielo | Actividades | Por qué |
| --- | --- | --- | --- |
| Moverse y aire libre | Menta | Caminar, hacer ejercicio, bicicleta, pasear al perro, cuidar las plantas | El verde es naturaleza y esperanza (Restrepo Betancur, 2022) y activa menos que el rojo (Wilms y Oberfeld, 2018) |
| Leer y aprender | Cielo | Leer, estudiar, escribir | El azul es el mar y el cielo, tiene cerca de 75 % de aceptación (Restrepo Betancur, 2022) y activa menos que el rojo |
| Crear | Atardecer | Dibujar, pintar, manualidades, maqueta, fotos | «Creativo» no tiene un color propio (Sánchez-Borrero et al., 2026): un cielo de varios tonos, con el naranja de la diversión |
| Jugar y disfrutar | Ámbar | Videojuegos, juego de mesa, película, música, guitarra | El amarillo se asocia con alegría (55,7 %) y el naranja con alegría (44,6 %) y diversión (41 %) (Jonauskaite et al., 2024) |
| La casa | Brasa | Cocinar, ordenar | El naranja del fuego y la cocina; no llega al rojo, que también es rabia (55,2 %) |
| Descansar | Noche | Dormir, meditar | Dormir tiene raíz sensorial. Azul de noche, nunca negro: el negro es el color del miedo (UNAM, 2023) |
| Personas | Rosa | Llamar a alguien | El rosa es amor (53,2 %) y ternura; como más del 11 % lo rechaza, se puede cambiar |

Las familias parten de las agrupaciones que ya usa la app (`artPalette`) y de los cielos de la exploración «Relevo con aura». Llevarlas a la app cambiaría algunos colores: por ejemplo, Crear pasa de lila y rosa al cielo Atardecer, y Llamar deja el grupo de música y juegos para tener su propia familia.

### Reglas

- **Contraste:** el nombre de la actividad va en una cápsula blanca con letra de tinta.
  - Se midió el texto blanco sobre los cielos y en los claros no llega al 4,5:1 que pide WCAG 2.2 (criterio 1.4.3): «Dibujar», 2,6:1; «Música», 2,9:1; «Videojuegos», 3,2:1.
  - Con la cápsula, el peor caso queda entre 15:1 y 17,8:1 sobre cualquier cielo.
- **Lugar:** el cielo aparece solo donde está la actividad:
  - en su tarjeta;
  - en el encabezado mientras se prepara el relevo;
  - en la pantalla completa cuando suena.

  Nunca va en botones, avisos ni pestañas.
- **Momento:** cuando suena, la pantalla toma el cielo de la actividad (D-103: el color sube con el momento). El mensaje va en una tarjeta de vidrio blanco y el botón, en tinta.
- **Personalización:** el color es un punto de partida.
  - Cada persona lo cambia en «Elige su color».
  - Una actividad escrita por la persona toma el cielo de la familia que la app reconoce. Si no reconoce ninguna, usa el aura suave.

## Recorrido y pantallas

- **La primera vez:** Bienvenida → Cómo funciona → Consentimiento → Permisos → Tu perfil → Primer relevo.
- **Preparar un relevo:** ¿Qué quieres hacer? → ¿Cómo empiezas? → ¿Dónde empiezas? → ¿Cuándo suena? → ¿Dónde suena? → Todo listo.
- **El relevo:** Inicio → Contando → Suena → ¿Qué decidiste? → Tu avance, y de vuelta a Inicio. El relevo se puede repetir o editar sin borrarlo (D-120).

| Pantalla | Color | Íconos |
| --- | --- | --- |
| Bienvenida | Solo la marca; el resto, papel y tinta | Ninguno |
| Permisos | Ninguno: pedir permisos no es un estado de la persona | Permiso, avisos y pila, siempre con su palabra |
| Inicio | El relevo activo en aura suave; cada actividad, en su cielo; el Tag, en su ficha lima | Pestañas Inicio, Ruta y Perfil; la activa en tinta y negrita |
| ¿Qué quieres hacer? | Cada idea en el cielo de su familia | Editar, para escribir otra |
| ¿Cómo empiezas? | Encabezado con el cielo de la actividad; el primer paso en ficha celeste | Primer paso; la opción elegida en tinta |
| ¿Cuándo suena? | Las apps y el tiempo en mantequilla | Apps elegidas y tiempo |
| ¿Dónde suena? | El Tag y el parlante en lima; la elección, con borde de tinta | Tag y parlante |
| Todo listo | Cada dato en la ficha de su papel | Los de cada paso |
| Contando | El aura respira, suave; si la persona la apagó, el fondo es papel | Íconos en la frase, justo después de lo que nombran (D-122) |
| Suena | La pantalla toma el cielo de la actividad | El Tag con anillos de sonido: no brilla, suena |
| ¿Qué decidiste? | Lo que decides en rosa; «después» en durazno; ninguna respuesta en gris ni rojo | Empecé, después y cambié de idea |
| Tu avance | Los días en que empezó, en el degradado de lo que decides; los demás, en piedra | Decidir y después; sin rachas ni medallas (D-111) |

Los wireframes muestran dónde va cada cosa; no son la app final.

## Verificación

- **Chrome sin ventana, a 1280 y a 390 px:**
  - La lámina carga sin errores.
  - No se desborda a lo ancho.
  - Muestra 12 pantallas, 7 familias, 4 fuentes y 84 íconos, ninguno vacío.
- **Contraste:** se midió en las capturas, sobre el píxel más desfavorable del fondo de cada rótulo.
- **Logo:**
  - Se revisó a 16, 24, 32, 48 y 96 px, en tinta, en blanco y como ícono de la app.
  - Los rótulos de la construcción se ven completos.
- **No se probó:** el logo y los colores no se probaron con personas.

## Límites

- No hay un estudio de color hecho solo en Chile. Lo chileno viene de una encuesta que incluye a Chile y de una inferencia por cercanía de lengua y región.
- Las asociaciones de color son tendencias por familia, no efectos garantizados.
- El logo no se probó con personas ni se buscó si hay marcas registradas parecidas en Chile (INAPI).

## Pendientes

- Que el autor revise D-125 y D-126.
- Si los aprueba:
  - Llevar el logo, los cielos con cápsula y la tarjeta de vidrio de Suena a la app Android. El ícono adaptable de Android necesita una capa de fondo y otra de primer plano.
  - Cambiar la marca en «Relevo con aura» y en el Taller de auras.
- Buscar en INAPI si hay marcas parecidas antes de usar el logo fuera de la universidad.
- Preguntar en la prueba qué color asocia cada persona a su actividad.

## Referencias

Design Week. (2019). *Pentagram’s Michael Bierut gives Slack its first ever rebrand*. https://www.designweek.co.uk/pentagrams-michael-bierut-gives-slack-its-first-ever-rebrand/

Fontshare. (s. f.). *ITF Free Font License*. https://www.fontshare.com/licenses/itf-ffl

Jiang, Y., Gorn, G. J., Galli, M. y Chattopadhyay, A. (2016). Does your company have the right logo? How and why circular- and angular-logo shapes influence brand attribute judgments. *Journal of Consumer Research, 42*(5), 709–726. https://doi.org/10.1093/jcr/ucv049

Jonauskaite, D., Abu-Akel, A., Dael, N., Oberfeld, D., Abdel-Khalek, A. M., Al-Rasheed, A. S., Antonietti, J., Bogushevskaya, V., Chamseddine, A., Chkonia, E., Corona, V., Fonseca-Pedrero, E., Griber, Y. A., Grimshaw, G., Hasan, A. A., Havelka, J., Hirnstein, M., Karlsson, B. S. A., Laurent, E., … Mohr, C. (2020). Universal patterns in color-emotion associations are further shaped by linguistic and geographic proximity. *Psychological Science, 31*(10), 1245–1260. https://doi.org/10.1177/0956797620948810

Jonauskaite, D., Epicoco, D., Al-Rasheed, A. S., Aruta, J. J. B. R., Bogushevskaya, V., Brederoo, S. G., Corona, V., Fomins, S., Gizdic, A., Griber, Y. A., Havelka, J., Hirnstein, M., John, G., Jopp, D. S., Karlsson, B., Konstantinou, N., Laurent, É., Marquardt, L., Mefoh, P. C., … Mohr, C. (2024). A comparative analysis of colour–emotion associations in 16–88-year-old adults from 31 countries. *British Journal of Psychology, 115*(2), 275–305. https://doi.org/10.1111/bjop.12687

Luffarelli, J., Mukesh, M. y Mahmood, A. (2019). Let the logo do the talking: The influence of logo descriptiveness on brand equity. *Journal of Marketing Research, 56*(5), 862–878. https://doi.org/10.1177/0022243719845000

Restrepo Betancur, F. (2022). Preferencia por los colores en universitarios de la ciudad de Medellín, Colombia. *Anuario Electrónico de Estudios en Comunicación Social «Disertaciones», 15*(1), 1–15. https://doi.org/10.12804/revistas.urosario.edu.co/disertaciones/a.10455

Sánchez-Borrero, G., Quelal-Moncayo, S. y Bustos-Cevallos, S. (2026). Asociaciones culturales latinoamericanas del color: estudio desde la psicología cromática en estudiantes universitarios de la Pontificia Universidad Católica del Ecuador. *Kepes, 23*(33), 105–145. https://doi.org/10.17151/kepes.2026.23.33.5

Slack. (2019, 16 de enero). *Say hello, new logo*. https://slack.com/blog/news/say-hello-new-logo

Universidad Nacional Autónoma de México, Dirección General de Comunicación Social. (2023, 16 de abril). *Relacionamos nuestros miedos con los colores* (Boletín UNAM-DGCS-273). https://www.dgcs.unam.mx/boletin/bdboletin/2023_273.html

Wilms, L. y Oberfeld, D. (2018). Color and emotion: Effects of hue, saturation, and brightness. *Psychological Research, 82*(5), 896–914. https://doi.org/10.1007/s00426-017-0880-8

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-10-11 — El lugar y el degradado

- **Qué cambió:** la tercera luz es el lugar y no el Tag, y se suman las versiones con degradado «Luz» (D-127).
- **Cómo estaba antes:** la tercera luz era el Tag y solo había versiones planas.
- **Por qué:** el autor pidió pensar en el fundamento y no en el resultado, y probar un degradado sutil.

### 2026-10-11 — Creación

- **Qué se añadió:**
  - El logo: la marca de cuatro luces y el logotipo en Chillax Semibold, con 12 SVG y sus reglas de uso.
  - La evidencia de color de Chile y Latinoamérica.
  - Las siete familias de colores de las actividades y sus reglas.
  - El recorrido y 12 wireframes con notas de color e íconos.
  - La lámina «Relevo aplicado».
- **Cómo estaba antes:**
  - La marca de cuatro luces se mezclaba oscureciendo (D-122) y no tenía logotipo propio.
  - Los cielos de las actividades llevaban el nombre en blanco.
  - Los colores solo se fundamentaban con estudios sin muestra chilena.
- **Por qué:** pedido del autor (D-125 y D-126).
