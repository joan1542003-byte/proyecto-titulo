# Íconos y color con fundamento

**Fecha:** 11 de octubre de 2026. **Decisión:** D-123, propuesta pendiente de la revisión del autor. **Lámina:** [iconos-relevo.html](iconos-relevo-2026-10-11/iconos-relevo.html), también publicada como [página privada en claude.ai](https://claude.ai/artifact/NHpnEr63JXn6JqCfDotPC2). **Archivos:** [72 SVG](iconos-relevo-2026-10-11/svg), el [sprite](iconos-relevo-2026-10-11/iconos-relevo.svg) y los [datos en JSON](iconos-relevo-2026-10-11/iconos-relevo.json).

## Pedido

El autor pidió íconos nuevos en SVG, hermosos y acordes a lo que necesitan la app y quienes la usan. Mandó tres referencias que le atraen: [Dafi](https://www.behance.net/gallery/253069605/Dafi), [DAYO](https://www.behance.net/gallery/249049085/DAYO-A-Travel-App-UIUX-Branding) y [Biceps Grotesk](https://www.behance.net/gallery/205606987/BICEPS-GROTESK-100-FREE-FONT). Pidió que las decisiones de diseño, incluidos los colores, estén fundamentadas: no un rojo «porque evoca algo», sino familias de color con razones. También dejó [Obsidian UI](https://www.obsidianui.dev/) como recurso para animar más adelante.

## Qué se hizo

- **72 íconos propios**, en cuatro grupos:
  - **Relevo** (13): tiempo, contando, apps elegidas, primer paso, Tag, suena, silenciar, lugar, aura, decidir, empecé, después y cambié de idea.
  - **Actividades** (23): las que la app sugiere o reconoce, tomadas de lo que contaron P1–P8.
  - **Navegación** (14): las pestañas Inicio, Ruta y Perfil, y lo que se usa para moverse.
  - **Acciones y estados** (22).
- **Paleta 2:** la misma familia de fichas, medida y ajustada (abajo).
- **Una lámina** que muestra todo, permite ver cada ícono a 16, 20, 24, 32 y 48 px y copiarlo o descargarlo, y explica cada decisión con su fuente.
- **Integración:** la lámina «Relevo con aura» y el Taller de auras usan los íconos nuevos y la paleta 2. En el taller están los 72, y los nombres antiguos (`{time butter}` y otros) siguen funcionando.
- **La app Android no cambia todavía.** Cada ícono indica en el JSON a qué `KitIcon` reemplazaría, para generarlos cuando el autor lo apruebe.

## Cómo se eligieron

Se contó qué íconos usa hoy la app: 80 del kit D-073, en pestañas, filas, avisos y la preparación del relevo. Se revisaron además sus tres pestañas (Inicio, Ruta y Perfil) y las 21 ideas de actividad del código, cada una con su fuente en el corpus. El set cubre esos usos y suma uno que no existía: **Suena**, el Tag con sus anillos, para la fila «Suena» de la preparación, que hoy usa la campana de avisos.

## Construcción

| Decisión | Por qué | Fuente |
| --- | --- | --- |
| Retícula de 24 y área viva de 20 | Se alinean en listas, botones y barras, con 2 de margen | Google, Material Design, íconos de sistema |
| Cuatro formas de base: círculo (r 9), cuadrado (16), vertical (14 × 18) y horizontal (18 × 14) | Así un ícono redondo y uno con esquinas miden lo mismo a la vista | Google, Material Design, keylines |
| Trazo 1,6 | Se midió el asta de Instrument Sans Medium: 0,105 de su tamaño. Junto a texto de 15 px, el de las fichas, da 1,6: el ícono pesa lo mismo que su palabra | Apple, SF Symbols; medición propia del 11 de octubre |
| Tamaños ópticos: 16 → 2,0; 20 → 1,8; 24 → 1,6; 32 → 1,4; 48 → 1,3 | Se ve igual de firme en una lista que en una lámina | Google, eje de tamaño óptico de Material Symbols |
| Puntas y uniones redondas | Conversan con las cápsulas y las fichas de la interfaz; a tamaño chico no dejan picos | Coherencia con «Relevo con aura» |
| Un solo peso; solo se rellenan puntos que marcan algo | El punto del primer peldaño («estás aquí»), la argolla del Tag | Decisión de este sistema |
| Siempre con una palabra | Casi ningún ícono tiene un significado único; la app ya los muestra con texto | Harley, Nielsen Norman Group |

**Metáforas:**
- **Lo propio de Relevo se dibuja con su objeto y sus ideas.** El Tag como es (redondo, con su botón y la argolla); el sonido como anillos, nunca luz (D-122); el primer paso como un punto en el primer peldaño; el tiempo como cronómetro, porque se cuentan minutos de uso.
- **Lo que hace cualquier app usa formas conocidas,** como volver, borrar o buscar: lo que la gente reconoce de otras apps le ahorra aprender.
- **Dos actividades se rehicieron tras verlas a 16 px.** «Caminar» pasó de zapatilla, que parecía una bota, a dos huellas. «Primer paso» perdió un «+» que se confundía con «Agregar».

## Color: paleta 2

El autor pidió no elegir un tono porque «evoque» algo. La evidencia disponible habla de **familias de color** (rojo, rosa, amarillo…), de **luminosidad** y de **saturación**, no de tonos exactos:

- **Asociaciones compartidas entre países.** En 30 países, las asociaciones entre color y emoción son muy parecidas (similitud media r = 0,88), con matices según la lengua y la geografía (Jonauskaite et al., 2020).
- **Asociaciones más frecuentes.** Con 7.393 personas de 31 países, las que elige el 40 % o más son:
  - **Rojo:** amor 69,2 %, rabia 55,2 %.
  - **Amarillo:** alegría 55,7 %.
  - **Negro:** tristeza 53,7 %, miedo 48,7 %, odio 41,6 %.
  - **Rosa:** amor 53,2 %, placer 41,8 %, alegría 41,8 %.
  - **Gris:** tristeza 47,7 %, decepción 43,9 %.
  - **Naranja:** alegría 44,6 %, diversión 41,0 %.
  - **Blanco:** alivio 43,5 %.

  Ni el verde, ni el azul, ni el turquesa, ni el morado, ni el café alcanzan ese umbral con ninguna emoción (Jonauskaite et al., 2024).
- **Luminosidad y saturación.** Los colores más claros se asocian con emociones más positivas, y los más saturados y oscuros con más activación (Jonauskaite et al., 2024). Al mirar colores de verdad, la saturación y el brillo suben la activación declarada y la conductancia de la piel, y la activación crece del azul y el verde al rojo (Wilms y Oberfeld, 2018).
- **Señalética.** En la norma ISO 3864, el rojo es prohibición; el amarillo, precaución; el azul, acción obligatoria; y el verde, condición segura.

| Papel | Ficha | Antes | OKLCH (L · C · h) | Por qué |
| --- | --- | --- | --- | --- |
| Tu tiempo | `#F4E496` mantequilla | `#F9E77C` | 0,91 · 0,10 · 98° | El amarillo es el color más asociado con alegría y pide precaución en señalética: llama la atención sin reproche. Baja de saturación porque un amarillo intenso activa más. |
| Tu primer paso | `#B3E5FC` cielo | `#C2E4F3` | 0,90 · 0,06 · 228° | El azul es «acción que hay que hacer» en ISO 3864, y junto al verde es lo que menos activa: una instrucción tranquila. |
| El Tag | `#C6EEAE` lima | `#DCEA98` | 0,91 · 0,09 · 134° | El verde es condición segura y, por costumbre, «adelante»: la señal invita a empezar. Pasa hacia el verde para separarse del amarillo. |
| Lo que decides | `#FAC8D9` rubor | `#F8C9D9` | 0,88 · 0,06 · 356° | El rosa conserva el amor, el placer y la alegría del rojo, sin su rabia. Decidir no se juzga. |
| Tu aura | `#DFD1FC` lila | `#DED2F7` | 0,89 · 0,06 · 300° | El morado no tiene una emoción compartida por el 40 %: es un color neutro para lo que cada persona personaliza. |
| Después | `#FBD1B3` durazno | `#FBD3B6` | 0,89 · 0,06 · 57° | El naranja se asocia con alegría y diversión: mirar lo que pasó, con ligereza. |

- **Los tonos rojos:** del rojo se toma su lado rosa, para lo que decides. El rojo pleno (`#B3261E`, D-103) queda solo para errores, con ícono y texto, por su asociación con la rabia. El negro y el gris se asocian con tristeza: la tinta se usa para texto y selección, nunca como fondo de un estado del relevo.
- **Medidas** (OKLCH, un espacio de color perceptual; Ottosson, 2020):
  - Las seis fichas tienen luminosidad de 0,88 a 0,91.
  - La saturación va de 0,06 a 0,10; antes iba de 0,04 a 0,13.
  - La tinta sobre cualquier ficha tiene un contraste de 12,7:1 a 14,5:1.
  - El amarillo y el lima pasan de ΔE 0,043 a 0,061: un 42 % más distintos.
  - El lima del aura pasa de `#C8E06A` a `#B3E788`.
- **Daltonismo:** se simularon protanopia, deuteranopia y tritanopia (matrices de Machado y otros, 2009).
  - Con deuteranopia, el celeste y el lila se confunden.
  - Con tritanopia, el rosa y el durazno se confunden.
  - Con tonos claros de igual luminosidad no se puede evitar del todo. Por eso el color nunca va solo: va siempre con ícono y palabra (WCAG 2.2, criterio 1.4.1). Los íconos superan con holgura el contraste de 3:1 del criterio 1.4.11.

## Lo que se tomó de las referencias del autor

| Referencia | Qué enseña | Qué se tomó | Qué no |
| --- | --- | --- | --- |
| Dafi (Mambo Mambo) | Íconos de línea sobre cuadrados de color, fichas en escalera, aura | Las fichas con ícono de línea, ahora con un papel por color | Sus dibujos: los 72 se trazaron de nuevo |
| DAYO | Personajes que nacen de cuatro estados emocionales, ordenados con el modelo de valencia y activación | Fundamentar el color en estudios de emoción, con datos de 31 países y la saturación como activación | El volumen peludo en 3D: a 16 px se pierde; el volumen de Relevo vive en el aura |
| Biceps Grotesk | Una letra modular de cuadrados y triángulos en una retícula de 30 px, en rojos y rosas | La construcción modular: las mismas formas de base y una sola retícula; de sus rojos, el lado rosa | La letra para la interfaz: es para lucirse en grande |

## Obsidian UI, para más adelante

Es una biblioteca abierta, con licencia MIT, de componentes animados para React, con Tailwind y Motion, GSAP o WebGL; los componentes se copian al proyecto. Sirve para prototipos web, una página de Relevo o piezas de presentación. La app Android está en Compose, así que ahí sus animaciones son referencia y se rehacen en Compose.

## Verificación

- Cada ícono se revisó a 168 px sobre la retícula y las formas de base, a 24 y a 16 px, y sobre su ficha. Se corrigieron «Primer paso», «Dormir», «Caminar», «Meditar» y «Tocar guitarra».
- Se revisó en Chrome sin ventana, en escritorio y en un teléfono de 390 px:
  - La lámina carga sin errores, no se desborda a lo ancho y abre el detalle de cada ícono.
  - La lámina «Relevo con aura» muestra los íconos nuevos en la frase, las fichas y las pantallas.
  - El taller exporta sus 39 piezas sin errores.
- No se probó la descarga ni «Copiar SVG» dentro de claude.ai.
- No se probó con personas si reconocen cada ícono.

## Pendientes

- Que el autor revise D-123: los íconos y la paleta 2.
- Si los aprueba, generar los íconos de la app desde el JSON, como se hizo con el kit D-073, y probarlos en el teléfono a 16 y 20 px.
- Dibujar variantes rellenas para la pestaña activa (el eje de relleno de Material Symbols sirve para cambios de estado).
- Probar el reconocimiento de los íconos de Relevo con personas, por ejemplo pidiendo que digan qué significa cada uno sin su palabra.
- La muestra de los estudios de color incluye Colombia, España y México, pero no Chile: es una base, no una verdad local.

## Referencias

Apple. (s. f.). *SF Symbols*. Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/sf-symbols

Google. (s. f.-a). *Material Symbols guide*. Google Fonts. https://developers.google.com/fonts/docs/material_symbols

Google. (s. f.-b). *System icons*. Material Design. https://m2.material.io/design/iconography/system-icons.html

Harley, A. (s. f.). *Tips for icon usability* [Video]. Nielsen Norman Group. https://www.nngroup.com/videos/icon-usability/

International Organization for Standardization. (2011). *Graphical symbols — Safety colours and safety signs — Part 1: Design principles for safety signs and safety markings* (ISO 3864-1:2011).

Jonauskaite, D., Abu-Akel, A., Dael, N., Oberfeld, D., Abdel-Khalek, A. M., Al-Rasheed, A. S., Antonietti, J., Bogushevskaya, V., Chamseddine, A., Chkonia, E., Corona, V., Fonseca-Pedrero, E., Griber, Y. A., Grimshaw, G., Hasan, A. A., Havelka, J., Hirnstein, M., Karlsson, B. S. A., Laurent, E., … Mohr, C. (2020). Universal patterns in color-emotion associations are further shaped by linguistic and geographic proximity. *Psychological Science, 31*(10), 1245–1260. https://doi.org/10.1177/0956797620948810

Jonauskaite, D., Epicoco, D., Al-Rasheed, A. S., Aruta, J. J. B. R., Bogushevskaya, V., Brederoo, S. G., Corona, V., Fomins, S., Gizdic, A., Griber, Y. A., Havelka, J., Hirnstein, M., John, G., Jopp, D. S., Karlsson, B., Konstantinou, N., Laurent, É., Marquardt, L., Mefoh, P. C., … Mohr, C. (2024). A comparative analysis of colour–emotion associations in 16–88-year-old adults from 31 countries. *British Journal of Psychology, 115*(2), 275–305. https://doi.org/10.1111/bjop.12687

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

Ottosson, B. (2020). *A perceptual color space for image processing*. https://bottosson.github.io/posts/oklab/

Wilms, L. y Oberfeld, D. (2018). Color and emotion: Effects of hue, saturation, and brightness. *Psychological Research, 82*(5), 896–914. https://doi.org/10.1007/s00426-017-0880-8

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-10-11 — Creación

- **Qué se añadió:**
  - 72 íconos propios con su construcción y sus metáforas.
  - La paleta 2 con el fundamento de cada color.
  - Lo tomado de las referencias del autor y la nota sobre Obsidian UI.
  - La lámina y los archivos SVG, sprite y JSON.
- **Cómo estaba antes:**
  - La gráfica nueva usaba 14 íconos dibujados para la exploración.
  - La app usaba el kit D-073.
  - Los colores de las fichas no tenían un fundamento escrito.
- **Por qué:** pedido del autor (D-123).
