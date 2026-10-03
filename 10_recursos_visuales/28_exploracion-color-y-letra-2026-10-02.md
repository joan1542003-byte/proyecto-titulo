# Exploración de color y letra

**Fecha:** 2 de octubre de 2026. **Estado:** exploración para que el autor elija; no cambia el sistema 3.1 publicado ni la app. **Dónde está:**

- Lámina interactiva publicada en claude.ai: [Color y letra](https://claude.ai/artifact/T8FY5qmRDCa7T5Mmfk5oxP) (privada del autor).
- Copia en el repositorio: [`exploracion-color-y-letra-2026-10-02/color-y-letra.html`](exploracion-color-y-letra-2026-10-02/color-y-letra.html); su generador está en [`sistema-de-diseno-3.1/construccion/exploracion/`](sistema-de-diseno-3.1/construccion/exploracion/build.js).

## Qué pidió el autor

Después del sistema 3.1 ([documento 27](27_sistema-de-diseno-3.1-2026-10-02.md)), seguir explorando, mirar de nuevo los colores y la tipografía, y buscar referencias en Behance.

## Lo que se vio en Behance

Se revisaron proyectos de identidad, de apps de bienestar, de risografía y de lectura. Las imágenes no se guardan en el repositorio; se cita cada proyecto con su enlace.

| Proyecto | Qué se vio | Qué sirve para Relevo |
| --- | --- | --- |
| [Work in Progress, campaña de salud mental](https://www.behance.net/gallery/206664653/Work-in-Progress-Mental-Health-Campaign) | Personajes en azul y rojo coral con grano de risografía | Dos tintas cálidas tratan un tema delicado sin dramatismo |
| [Livres à Vous 2021-2022](https://www.behance.net/gallery/189594043/Livres-a-Vous-2021-2022) | Papel crema, dibujo a lápiz y dos tintas | El lápiz y el papel dicen «hecho a mano»; dos tintas alcanzan |
| [Hedwig](https://www.behance.net/gallery/256225289/Digital-Library-for-Reading-Listening-Hedwig) | Ilustraciones en grises con un solo amarillo | Un único acento sobre dibujos en tinta se lee tranquilo |
| [time:is](https://www.behance.net/gallery/223657767/timeis-visual-identity) | Fondos planos vivos con dibujos de píxeles en negro, sobre el tiempo | Color pleno con un dibujo en tinta; el tiempo hecho de puntos |
| [The Daily Form](https://www.behance.net/gallery/232670173/The-Daily-Form-Brand-Identity) | Casi el mismo azul eléctrico y un logotipo en minúsculas | El azul solo no distingue: lo propio es el renglón |
| [Embody](https://www.behance.net/gallery/245473209/Branding-Visual-Identity-for-Yoga-App-Embody) | App de yoga con colores apagados y letra limpia | Es el tono por defecto del bienestar |
| [Théâtre l'Avant Seine 26-27](https://www.behance.net/gallery/255056303/Thatre-lAvant-Seine-26-27) | Fotos cortadas por formas en degradados vivos | Es la dirección de degradados que el autor descartó (D-098) |
| [Matiz](https://www.behance.net/gallery/255387287/Matiz-ceramic-studio-Branding-Design) | Crema, negro, kraft y un logotipo escrito a mano | La materia de la casa puede venir del papel y de la mano |
| [OFFit](https://www.behance.net/gallery/225640497/OFFit) | Objeto para desconectarse presentado como aparato | Relevo va al revés: un objeto doméstico |

Cinco cosas se repiten: dos tintas bastan; un solo acento sobre dibujos en tinta se lee tranquilo; el azul eléctrico ya lo usan otros; el bienestar suena apagado y la casa de 3.1 se parece a ese promedio; lo hecho a mano da materialidad sin depender del color.

## Cuatro direcciones de color

| Dirección | Idea | Colores | Contraste medido | Riesgo |
| --- | --- | --- | --- | --- |
| A · Casa apagada (3.1) | El azul es Relevo; seis colores apagados, uno por categoría | Azul `#3D38F5` y las seis familias de 3.1 | Renglones 3,96–4,38:1; texto 5,59–6,13:1 | Se parece al promedio del bienestar y al estilo cálido muy repetido de crema, serif y terracota |
| B · Cuaderno | Dos tintas: el renglón azul donde se escribe y el margen rojo que marca dónde empieza | Papel `#FBFBF7`, grafito `#2A2C33`, azul `#3D38F5`, rojo de margen `#E23B45`, rojo para texto `#C72B36`, celeste de renglones `#BFD3F2` | Grafito 13,4:1; azul 6,6:1; rojo 4,1:1 en líneas y 5,3:1 en texto | Puede verse escolar si se abusa; el error de la app debe quedar en otro rojo |
| C · Tintas de imprenta | Seis tintas vivas que se sobreimprimen con el azul, como en risografía | Amarillo `#FFD23F`, rosa `#FF5D9E`, naranja `#FF7A33`, verde `#1FA866`, turquesa `#12A1B0`, morado `#8E3C8C` | Tinta encima: 5,7–12,3:1 (blanco en morado y azul) | No sirve en la interfaz: cinco tintas no llegan a 3:1 sobre papel; verde y turquesa se confunden con tritanopía (2,0) |
| D · Noche y lámpara | De noche, el teléfono es azul y la casa es la luz de una lámpara | Noche `#121327`, tarjeta `#1D1F3B`, luz `#F2EDE3`, azul `#8F8CFF`, lámpara `#FFB547` | Luz 15,7:1; azul 6,4:1; lámpara 10,4:1 | Una identidad oscura pesa en impresión; mejor como tema oscuro y pantalla de la señal |

El contraste se calculó con la fórmula de WCAG 2.2 (W3C, 2023) y la visión del color con la simulación de Machado et al. (2009).

**El margen como segundo recurso (dirección B).** Relevo suena donde empieza la actividad. En un cuaderno, la línea roja del margen marca dónde se empieza a escribir. El margen rojo vertical se suma al renglón azul horizontal: uno dice dónde se empieza; el otro, qué se quiere hacer.

## Cinco pares de letra

| Par | Qué es | A favor | En contra |
| --- | --- | --- | --- |
| 1 · Dos voces (3.1) | Schibsted Grotesk; Newsreader romana para Relevo e itálica para la persona | Tamaño óptico de 6 a 72; sobria y probada | Esperable; a 17 px la itálica se distingue poco |
| 2 · Instrument Serif | Schibsted Grotesk con Instrument Serif | El autor la aprobó el 30 de septiembre; más editorial | Sin tamaño óptico: bajo 28 px se ve frágil |
| 3 · Fraunces suave | Schibsted Grotesk con Fraunces (ejes SOFT y WONK) | Cálida, doméstica | Cerca del estilo cálido muy repetido; con peso alto, juguetona |
| 4 · Bricolage Grotesque | Una grotesca con carácter para titulares e interfaz | Más propia que una grotesca neutra; titulares estrechos | Cambia la letra de la app y la base del logotipo |
| 5 · Letra de cuaderno | Relevo en Schibsted Grotesk y Newsreader; la persona escribe en Playwrite CL | Es la letra ligada que se enseña en las escuelas de Chile; su versión Guides trae las líneas del cuaderno | Cuesta leerla en tamaños chicos: solo en piezas, la tarjeta y el campo grande |

Playwrite CL es parte de Playwrite, una familia de TypeTogether hecha a partir de su investigación Primarium sobre cómo se enseña a escribir en más de 40 países; la versión chilena sigue el modelo de letra ligada (TypeTogether, s. f.; Google Fonts, s. f.). Todas las letras tienen licencia SIL Open Font.

## Recomendación

1. **Cuaderno con letra de cuaderno (B5).** Es la dirección más propia: sale del renglón, que ya es la marca, y del cuaderno donde se escribe lo que uno quiere hacer. Suma el margen rojo con un sentido claro y deja que la persona escriba con la letra que aprendió en la escuela. Dos tintas se recuerdan mejor que seis colores (Romaniuk, 2018). En la app, las categorías siguen con ícono y nombre.
2. **Tintas de imprenta solo en piezas**, si se quiere más color: afiches, redes y stickers.
3. **Noche y lámpara como tema oscuro** y para la pantalla de la señal.

## Preguntas para el autor

1. ¿Dos tintas (azul y rojo de margen) o seis colores de la casa?
2. ¿La voz de la persona escrita a mano con Playwrite CL o en itálica como en 3.1?
3. ¿Sumar el margen rojo como segundo recurso, o el renglón solo?
4. ¿Alguna letra de titular convence más que Newsreader?

## Límites

- La búsqueda en Behance no es exhaustiva: el buscador mezcla resultados populares con los pertinentes, y se miraron solo algunas imágenes de cada proyecto.
- Las piezas de la lámina son maquetas; no se probó con personas ninguna dirección.
- Los valores de las tintas de la dirección C son propios, inspirados en la risografía; no son los colores oficiales de ningún fabricante.

## Referencias

Google Fonts. (s. f.). *Playwrite Chile*. https://fonts.google.com/specimen/Playwrite+CL

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

Romaniuk, J. (2018). *Building distinctive brand assets*. Oxford University Press.

TypeTogether. (s. f.). *Installing & using Playwrite*. https://www.type-together.com/playwrite-instructions

W3C. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

Ward, E., Yang, S., Romaniuk, J. y Beal, V. (2020). Building a unique brand identity: Measuring the relative ownership potential of brand identity element types. *Journal of Brand Management, 27*(4), 393–407. https://doi.org/10.1057/s41262-020-00187-6

## Registro de cambios (disclaimer)

### 2026-10-02 — Creación

- **Qué cambió:** se documentó la exploración de color y letra: referencias de Behance, cuatro direcciones de color, cinco pares de letra, una recomendación y preguntas para el autor.
- **Cómo estaba antes:** el sistema 3.1 tenía una sola propuesta de color (la casa apagada) y de letra (dos voces).
- **Por qué:** el autor pidió seguir explorando colores y tipografía, con referencias de Behance.
