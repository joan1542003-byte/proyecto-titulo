# Letra con identidad: propuesta 3.6

**Fecha:** 3 y 4 de octubre de 2026. **Estado:** propuesta D-105. Cambia el azul de Relevo (`#3D38F5`, D-098) y el logotipo de la [propuesta 3.5](33_el-traspaso-2026-10-03.md) (Familjen Grotesk, D-104). Lo demás de la 3.5 se mantiene: la idea del traspaso, la familia de colores, el uso medido del color y la voz. No cambia todavía la app ni el sistema publicado. **Dónde está:**

- Lámina publicada en claude.ai: [Letra con identidad](https://claude.ai/artifact/XPgDvNQEcgjZ1nnTWX3GXS) (privada del autor).
- Copia en el repositorio: [`letra-con-identidad-2026-10-04/`](letra-con-identidad-2026-10-04/letra-con-identidad.html), con los tableros, los logotipos dibujados que se descartaron y los generadores.

## Qué pidió el autor

- **3 de octubre:** el azul de Relevo no combina con los otros colores y hay que arreglarlo; que Claude diseñe el logotipo por sí mismo; seguir explorando los visuales generales de Relevo.
- **4 de octubre:** los logotipos dibujados le parecen feos. Prefiere explorar otras tipografías gratuitas, o que algún resquicio de su licencia permita usarlas, más atractivas, con identidad y que no caigan en una sans simple.

## 1. El azul, arreglado

El azul anterior, `#3D38F5`, tenía luz 0,50 y croma 0,27 en OKLCH. Es decir, entre dos y cuatro veces la intensidad de los colores de la familia (croma de 0,06 a 0,13) y una luz que no era la de ningún nivel (claros 0,82, profundos 0,33). Por eso saltaba, y los claros no se leían encima: daban de 3,7 a 4,1:1.

Se compararon cinco candidatos con la luz de los profundos y algo más de croma. Se eligió el que conversa con violeta, petróleo, bosque y vino sin perder su papel de marca:

| | Antes | Ahora |
| --- | --- | --- |
| Azul | `#3D38F5` | `#1C3891` (luz 0,38, croma 0,15, tono 266) |
| Sobre papel | 6,5:1 | 9,9:1 |
| Claros encima (mínimo) | 3,7:1 | 5,6:1; con visión del color simulada, 4,5:1 |
| Tema oscuro | `#9A97FF` | `#87A8F7` (8:1 sobre `#111215`) |

El azul sigue con sus papeles de sistema (foco, selección, pestaña activa, enlaces), ícono y marca.

## 2. Los logotipos dibujados (descartados)

Cuatro conceptos se dibujaron en SVG sin fuentes: el traspaso como ligadura, una grotesca con trampas de tinta, la «l» como testigo y una sans sin gesto. Dos jueces, uno de identidad y otro de tipografía, eligieron «el testigo»: la «l» dibujada como una cápsula inclinada. La ronda de refinamiento y la exploración de los visuales generales se cortaron por el límite de uso de la sesión. El autor encontró feos los logotipos dibujados, así que se descartan. Se guardan como antecedente en [`logos-dibujados-descartados/`](letra-con-identidad-2026-10-04/logos-dibujados-descartados/).

## 3. La búsqueda tipográfica

**Dónde se buscó:**

- **Fontshare**, de Indian Type Foundry: 100 familias, todas gratuitas para uso comercial.
- **Google Fonts**, con licencia OFL.

Se compusieron 29 letras escribiendo «relevo», en cinco grupos: redondas, grotescas raras, display, de ancho y peso, y fuera de la sans.

**Descartes:**

- Sharpie y Kihim, porque se leen como letra escrita a mano.
- Segment, Array y Kola, porque son de efecto.
- Tanker, porque solo tiene mayúsculas.
- Las demasiado frías o neutras para Relevo.

**Seis finalistas en uso:** se probaron con el azul nuevo y la familia de colores en la barra de la app, dos afiches, la tarjeta y el ícono.

- Pally y Chillax son amables, pero se acercan a una sans simple.
- Panchang tiene identidad, pero se siente industrial.
- Chubbo, Calistoga y Fraunces Soft son las que dan calidez propia.

| Letra | Autoría y origen | Qué tiene | Juicio |
| --- | --- | --- | --- |
| **Chubbo** (recomendada) | Rafał Buchner, Fontshare, 2021 | Una egipcia (remates rectangulares) cuyos remates terminan en curvas redondas: firmeza de afiche y suavidad de objeto de la casa. Cinco pesos con itálicas. | Cálida, analógica y reconocible de lejos. No es una sans simple ni la serif de libro que no funcionó. |
| Calistoga | Yvonne Schüttler con Sorkin Type, Google Fonts | Display alegre y compacta, inspirada en los rótulos de Oscar M. Bryn para los afiches del ferrocarril Santa Fe. Un peso. | Más nostálgica y compacta. Segunda opción. |
| Fraunces Soft | Undercase Type, Google Fonts | Serif con ejes de suavidad y de forma irregular («wonky») llevados al máximo. | La más cálida, pero es una serif. |

**Uso propuesto:** Chubbo Bold en minúsculas, apretada −2 %, solo para el logotipo y, si el autor quiere, para titulares muy grandes de campaña. La interfaz, los textos y los datos siguen en Schibsted Grotesk e IBM Plex Mono. El ícono es la «r» en papel sobre el azul nuevo.

**Fundamento:** en 2018, Collins y R/GA rehicieron la marca de Mailchimp. Eligieron Cooper Light porque captaba mejor su espíritu humano y cálido, y el logotipo partió de esa letra con ajustes para que no fuera la letra tal cual (Design Week, 2018). Chubbo y Calistoga trabajan en esa misma familia de formas blandas. Para Relevo, que habla de volver a cosas de la casa (un libro, unas acuarelas, una correa), una letra blanda y analógica lo dice antes de leer la palabra.

## 4. Licencias, en claro

| Origen | Licencia | Logotipo | Límite |
| --- | --- | --- | --- |
| Fontshare (Chubbo, Pally, Chillax, Panchang) | ITF Free Font License 2.0 (17 de agosto de 2026): gratis para uso personal y comercial, en cualquier medio. | Permite crear logotipos y registrarlos como marca. | No se puede modificar ni redistribuir el archivo de la fuente. |
| Google Fonts (Calistoga, Fraunces) | SIL Open Font License: libre, también para uso comercial. | Permitido. | Una versión modificada de la fuente debe mantener la misma licencia y, si tiene un nombre reservado, cambiarlo. |
| «Gratis para probar» (por ejemplo, Pangram Pangram) | Uso personal no comercial, incluidos portafolios y proyectos escolares. | Para el logotipo de una empresa piden una licencia de logotipo pagada. | Sirve para la tesis; si Relevo se vuelve un producto real, hay que comprar la licencia. |

No hace falta ningún resquicio legal: las tres finalistas son gratuitas para uso comercial.

## Preguntas para el autor

1. ¿El logotipo va en Chubbo, en Calistoga o en Fraunces Soft?
2. ¿La letra del logotipo se usa también en titulares grandes de campaña, o solo en el logotipo?
3. ¿Aceptas el azul nuevo, `#1C3891`?

## Límites

- **Imágenes en la lámina:** la página de claude.ai solo carga fuentes de Google Fonts, así que Chubbo aparece en imágenes renderizadas.
- **Descarga pendiente:** para dibujar el logotipo final en curvas, o para incorporar Chubbo a la app, hay que descargar sus archivos desde Fontshare, con permiso del autor. La licencia lo permite.
- **Exploración pendiente:** la de los visuales generales (composición, fotografía, app, movimiento y objeto) quedó sin hacer por el límite de uso.
- **Sin pruebas:** las finalistas no se probaron con personas.

## Referencias

Buchner, R. (2021). *Chubbo* [Tipografía]. Fontshare. https://www.fontshare.com/fonts/chubbo

Design Week. (2018). *«Playful» Mailchimp redesign aims to unify brand while encouraging creativity*. https://www.designweek.co.uk/issues/1-7-october-2018/mailchimp-rebrand-aims-to-unify-bran

Indian Type Foundry. (2026). *ITF Free Font License* (versión 2.0). Fontshare. https://www.fontshare.com/licenses/itf-ffl

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

Pangram Pangram. (2025). *Frequently asked questions*. https://pangrampangram.com/pages/faq

Schüttler, Y. y Sorkin Type. (2019). *Calistoga* [Tipografía]. Google Fonts. https://fonts.google.com/specimen/Calistoga

Undercase Type. (2020). *Fraunces* [Tipografía]. Google Fonts. https://fonts.google.com/specimen/Fraunces

W3C. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-10-04 — Creación

- **Qué cambió:** se documentó la propuesta 3.6. Incluye el azul nuevo, los cuatro logotipos dibujados (descartados por el autor), la búsqueda de 29 letras gratuitas con identidad, la recomendación de Chubbo con Calistoga y Fraunces Soft como alternativas, y las licencias explicadas.
- **Cómo estaba antes:** la 3.5 usaba el azul `#3D38F5`, que no combinaba con la familia, y el logotipo en Familjen Grotesk.
- **Por qué:** el autor pidió arreglar el azul y diseñar el logotipo. Después encontró feos los dibujados y pidió letras gratuitas más atractivas y con identidad, que no fueran una sans simple.
