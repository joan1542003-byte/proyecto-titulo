# Sistema de diseño 3.1 de Relevo

**Fecha:** 1 y 2 de octubre de 2026. **Estado:** propuesta D-099, sobre la identidad D-098; cuatro supuestos abiertos (ver «Supuestos»). **Dónde está:**

- Sistema publicado en el tipo Design System de claude.ai: [página privada](https://claude.ai/artifact/SsGWeeHPHxxkXrCKN1WW8x), versión del 2 de octubre.
- Copia en el repositorio: [`sistema-de-diseno-3.1/`](sistema-de-diseno-3.1/README.md), con los recursos y los programas que los generan.

## Qué pidió el autor

El 1 de octubre, después del sistema 3.0 ([documento 26](26_sistema-de-diseno-3.0-2026-10-01.md)): seguir con el desarrollo de iconografía, tipografías y diseños, con «un sinfín de recursos», cada uno argumentado en la memoria o en principios de diseño; perfección de diseño, variedad e identidad propia; un logotipo hermoso y una selección tipográfica cuidada, y libertad para no usar un solo color. El 2 de octubre pidió retomar el trabajo, que se había interrumpido.

## Qué cambió respecto de 3.0

| Parte | 3.0 | 3.1 | Razón principal |
| --- | --- | --- | --- |
| Logotipo | Schibsted Grotesk 650, rectángulo del ancho de la palabra | 600, renglón en cápsula del grosor de la «e» que pasa la «o» en una altura de x | «Relevar» también es resaltar; el renglón deja lugar («Hazle lugar a lo que quieres hacer», D-062) |
| Familia del logotipo | 3 versiones y 3 íconos | 29 archivos: versiones, renglón por categoría, firmas, símbolo, íconos, Android, construcción y exploración | Cada uso tiene su archivo y sus reglas |
| Tipografía | Grotesca y serif; la voz de la persona en azul | Dos voces: Relevo en grotesca y romana; la persona en Newsreader itálica, en tinta | El azul queda para el sistema y la voz no depende del color |
| Color | Una sola tinta azul | El azul del sistema y seis colores de la casa, uno por categoría de actividad | La pantalla es azul; la casa, de colores |
| Íconos | 102 | 135: lugares, actividades nuevas, el testigo y los ámbitos | Relevo suena donde empieza la actividad: el lugar necesitaba dibujo |
| Ilustración | No había | 6 escenas sin personas | El comienzo, no el resultado (documento 23) |
| Patrones | Campos de trama azules | Renglones, cuadrícula, un campo por categoría y renglones de colores | Fondos hechos con los dos recursos de la marca |
| Aplicaciones | Descritas | 24 piezas hechas | Afiches, redes, presentación, memoria, objeto, tarjeta y stickers |
| Movimiento y sonido | Escribir sobre el renglón (450 ms) | Además, el logotipo animado y la firma sonora de D-071 | Una sola animación de marca, con sonido tranquilo |
| Componentes | 43 | 46 (`Symbol`, `AppIcon`, `ActivityTag`) y 13 páginas de muestra | El sistema se ve armado |

## El logotipo

- **Construcción** (unidades de la fuente, 2048 por eme): Schibsted Grotesk 600; espaciado −2,2 %; kerning el −40, le −10, vo −8; renglón de 160 de alto (el travesaño de la «e») a 180 bajo la línea base, en cápsula, desde el asta de la «r» hasta 1080 unidades después de la «o».
- **Exploración:** seis posiciones del renglón y ocho ajustes de peso, espaciado y distancia, guardados como láminas. Se descartaron la «o» como parlante (pone el objeto en el centro, como D-071 antes de D-072) y la «o» llena (se lee como un punto o el botón de grabar).
- **Herramienta:** los contornos salen de la fuente variable de la app con un lector propio (`ttf.js`) que aplica las variaciones de peso; se comparó con el logotipo oficial antes de usarlo.
- **Versión en trama:** letras en medio tono sobre una retícula de 72 unidades y el renglón hecho de puntos del grosor del renglón, como el tiempo en `TimeDots`.

## Los colores de la casa

| Categoría | Familia | Firma | Material |
| --- | --- | --- | --- |
| Moverme | terracota | 600 · `#B0582D` | el ladrillo y la tierra de afuera |
| Leer | mostaza | 300 · `#DAB974` | el papel y la luz de una lámpara |
| Crear con las manos | arcilla | 400 · `#DA8C8E` | la arcilla y el pigmento |
| Aprender algo | pizarra | 800 · `#1A4D55` | el pizarrón y la tinta |
| Cuidar la casa y a mí | salvia | 500 · `#649C66` | las hojas de una planta |
| Con otras personas | ciruela | 700 · `#82466F` | una tela de sobremesa |

- **Método:** escalas de 50 a 900 en OKLCH (Ottosson, 2020), con la misma luminosidad por paso en las seis familias (diferencias de ±0,002) y croma ajustado al límite de lo que se puede mostrar.
- **Apagados a propósito:** croma de 0,055 a 0,128, contra 0,266 del azul. En 3.0 se descartó una paleta de colores vivos porque se parecería al diseño que captura la atención; esa razón se mantiene: el azul sigue siendo el único color del sistema.
- **Contraste medido:** el 600 (renglones e íconos) da de 3,96 a 4,38:1 sobre papel; el 700 (texto), de 5,59 a 6,13:1; en el tema oscuro, el 300 sobre la tarjeta da de 8,79 a 9,39:1.
- **Visión del color:** distancia mínima entre firmas (ΔEok × 100) de 13,2 con visión típica, 4,8 con protanopía (ciruela y pizarra), 8,5 con deuteranopía y 9,8 con tritanopía, según la simulación de Machado et al. (2009). Las firmas están en luminosidades distintas y siempre van con ícono y nombre.
- **Roles:** `<cat>` (firma), `<cat>-line` (600 / 300), `<cat>-text` (700 / 200) y `<cat>-soft` (100 / 900), en `tokens.json`.

## Las dos voces

Relevo habla en Schibsted Grotesk y, en su frase principal, en Newsreader romana (380, tamaño óptico de 6 a 72). Lo que escribió la persona va en Newsreader itálica, en tinta, sobre el renglón: estilos `personaDisplay` (36/40), `persona` (22/28) y `personaBody` (19/26). IBM Plex Mono 300 queda para los datos. La itálica reemplaza al azul que usaba la app 2.18 para la voz de la persona: así el azul es solo del sistema, y la diferencia se ve también en blanco y negro (WCAG 2.2, criterio 1.4.1).

## Recursos

106 archivos subidos al sistema y una firma sonora en WAV (detalle en la [copia del repositorio](sistema-de-diseno-3.1/README.md)):

- **Logotipo (29):** versiones, renglón por categoría, firmas, símbolo, íconos de la app, capas Android, notificación, favicon, construcción y exploración.
- **Íconos (33):** puerta, cama, velador, escritorio, mesa, sillón, estante, cocina, ventana, mochila, canasto; trotar, gimnasio, yoga, cómic, teclado, tejer, hornear, idioma, sudoku, proyecto, ropa, táper, meditar, armar, huella; testigo, testigo sonando, testigo con problema, cerrar ciclo; y los tres ámbitos.
- **Ilustraciones (6), patrones (11) y la lámina de color (1).**
- **Aplicaciones (24):** seis afiches «Vuelve a…», carrusel de cuatro láminas, dos historias, una publicación, seis láminas de presentación, la portada de la memoria, la lámina del objeto, la tarjeta de bolsillo (frente y reverso) y un pliego de stickers.
- **Movimiento (2):** el logotipo animado con la firma sonora y su último cuadro.

## De dónde salen los textos

Ningún texto de las piezas es inventado: vienen de la app 2.18 (pantallas «Cómo funciona», Preparar y la señal), de la guía de comunicación (descriptor, explicación principal y pie sobre lo que falta validar), de la memoria v4 (título académico y resumen: 8 entrevistas, 53 respuestas, una prueba de 21 días diseñada) y del documento 23 (las actividades, cómo empiezan y dónde). La firma «Vuelve a lo que querías hacer» es la que eligió el autor (D-073). Las actividades que el documento 23 marca como propuestas siguen siendo propuestas.

## Supuestos

Mientras el autor decide (D-099):

1. **Newsreader** como serif (alternativa: Instrument Serif).
2. **Los seis colores de la casa** junto al azul (alternativa: volver a una sola tinta; basta no usar los roles de categoría).
3. **La itálica para la voz de la persona** (alternativa: la voz en azul, como en la app 2.18).
4. **Trama en íconos solo en momentos de marca.**

## Cómo se comprobó

- Las 60 vistas previas (46 componentes, la portada y 13 páginas) se abrieron en un servidor local que imita el marco del sistema, con Chrome sin interfaz; la portada y las páginas de logotipo, tipografía, paleta e iconografía se revisaron también en tema oscuro.
- El contraste y la simulación de visión del color se calcularon con `palette-report.js`.
- Las referencias nuevas (Edworthy et al., 1991; Krishnan et al., 2012) se revisaron en sus fuentes.
- **No se comprobó:** la página publicada en claude.ai (el navegador de trabajo no tiene sesión), cómo suena la firma sonora en un parlante real, la impresión en papel de afiches y tarjeta, ni si las personas reconocen la marca, los íconos o los colores.

## Lo que falta

- Que el autor decida los cuatro supuestos.
- Corregir el capítulo 11 de la memoria: todavía describe Source Sans 3 y el verde `#006B5F` (D-062). La frase «Hazle lugar a lo que quieres hacer» sigue vigente y el logotipo la recoge. No se tocó el texto académico.
- Llevar 3.1 a la app 2.19 (orden propuesto en la sección Aplicaciones del sistema) y al archivo de Figma.
- Exportar afiches y tarjeta a 300 ppp para imprenta.

## Referencias

Edworthy, J., Loxley, S. y Dennis, I. (1991). Improving auditory warning design: Relationship between warning sound parameters and perceived urgency. *Human Factors, 33*(2), 205–231. https://doi.org/10.1177/001872089103300206

Krishnan, V., Kellaris, J. J. y Aurand, T. W. (2012). Sonic logos: Can sound influence willingness to pay? *Journal of Product & Brand Management, 21*(4), 275–284. https://doi.org/10.1108/10610421211246685

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

Ottosson, B. (2020, 23 de diciembre). *A perceptual color space for image processing*. https://bottosson.github.io/posts/oklab/

W3C. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

Las demás referencias (Romaniuk, 2018; Ward et al., 2020; Wallace et al., 2022; Isherwood et al., 2007; Gollwitzer y Sheeran, 2006, entre otras) están en la sección `10-fundamentos` del sistema y en el [documento 26](26_sistema-de-diseno-3.0-2026-10-01.md).

## Registro de cambios (disclaimer)

### 2026-10-02 — Creación

- **Qué cambió:** se documentó el sistema de diseño 3.1: logotipo, tipografía, colores de la casa, íconos, ilustraciones, patrones, aplicaciones, movimiento y sonido, con sus razones, su comprobación y lo que falta.
- **Cómo estaba antes:** el sistema vigente era 3.0 (documento 26), de una sola tinta y sin ilustraciones, patrones ni piezas hechas.
- **Por qué:** el autor pidió el 1 de octubre más recursos argumentados, un logotipo y una tipografía cuidados y libertad de color, y el 2 de octubre retomar el trabajo interrumpido.
