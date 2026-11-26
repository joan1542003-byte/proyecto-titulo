# Verificación de citas y referencias (25 de noviembre de 2026)

**Estado:** aplicada el mismo día. Las correcciones 1 a 9 de la sección 2 están en la [memoria](borrador-memoria-v8-2026-11-21.md) y en el [Anexo H](anexos/anexo-h-identidad.md), y la memoria y los anexos se compusieron de nuevo. También se aplicaron dos puntos de la sección 4: Semilla Inicia dice que su convocatoria de 2024 fue regional y ya cerró, y la licencia de Lucide se nombra completa. No cambió el costo de las suscripciones de la Tabla 2 (sección 5, punto 2): es el gasto del propio autor, que no necesita una fuente externa. De las cuatro páginas sin PDF de la sección 5, McDaniel y Einstein (2000, p. S138) se comprobó esa noche con el acceso de la biblioteca de la UDP: la página dice que una actividad más absorbente deja menos recursos para los procesos estratégicos del recuerdo. Esa misma noche se comprobaron también Guynn et al. (1998, p. 296), en su discusión general: los recordatorios que nombraban solo el evento no mejoraron el recuerdo, y los que nombraban el evento y la acción sí; y Middlebrooks y Green (1991, p. 138): un estímulo de banda ancha permite resolver la ambigüedad de la ubicación que hay en una banda estrecha. Queda Kirsh (1995, p. 38), porque ScienceDirect no abre en el navegador de Claude; su contenido coincide con la copia del autor. Las líneas citadas son las del archivo antes de aplicar las correcciones.

Esta verificación sigue a la del [9 de noviembre](verificacion-de-referencias-2026-11-09.md) y responde al punto “Pulido” de la [pauta escrita de los profesores](../01_contexto_y_fuentes/feedback-pase-2026-11-25/retroalimentacion-memoria-profesores.md): contrastar una muestra de referencias con sus citas.

**Fecha:** 25 de noviembre de 2026.

**Base:** `08_memoria/borrador-memoria-v8-2026-11-21.md` y `08_memoria/anexos/anexo-*.md` en el commit `7a9db80` (25 de noviembre, 19:00). Ese commit llegó durante la auditoría. Cambió el resumen, el objetivo 4, los resultados y las conclusiones, pero no tocó citas ni referencias. Desde el capítulo 14 corrió las líneas en dos. Las líneas de este informe son las de ese commit. También valen para el commit siguiente, `5f47061` (19:20), que cambió cuatro párrafos sin tocar citas, referencias ni la numeración de las líneas citadas. No se editó ningún archivo del repositorio.

**Cómo se hizo**

- **Cruce mecánico.** Un script recorrió todas las citas con año o “s. f.”: entre paréntesis y narrativas, con varias obras por paréntesis, “et al.”, iniciales y letras. Los casos límite se revisaron a mano. La memoria se revisó entera: capítulos 1 a 14, notas de figuras, resumen y glosario. Cada anexo se cruzó con su propia lista.
- **Diferencias con la v6.** Se comparó con la lista de la v6 tal como se verificó el 9 de noviembre (commit `f0c4161`). El archivo v6 actual no sirve para eso: se siguió editando después (commits `203f8cf` y `cbddf7b`) y ya trae 18 entradas que no estaban en la lista verificada. Comparado con él, solo habrían aparecido 4 entradas nuevas.
- **Fuentes.** Primero los PDF de la carpeta local de bibliografía del autor, que no se versiona. Después Crossref, doi.org, PubMed, OpenAlex, RePEc, Google Patents, GitHub y la página de cada sitio. Las búsquedas usaron solo datos bibliográficos.

## 1. Resumen

| | Memoria | Anexos |
| --- | --- | --- |
| Entradas en la lista | 101 | 75: A 2, C 35, D 9, E 1, H 27 e I 1. B, F y G no citan |
| Citas en el texto | 211: 188 en los capítulos 1 a 14 y 23 en el glosario. Además, 3 comunicaciones personales | 94: A 2, C 38, D 9, E 1, H 43 e I 1 |
| Nuevas o cambiadas desde el 9 de noviembre | 22: 21 nuevas, y Google (s. f.-a) solo cambió de letra | 10 en el Anexo H: 9 nuevas, y Restrepo Betancur solo cambió de comillas |

En total hay 129 obras distintas. De la memoria salieron Anthropic, OpenAI y Springer Nature, y ninguna cita quedó sin entrada.

**Problemas por tipo**

| Tipo | N.º | Dónde |
| --- | --- | --- |
| Cita sin entrada o entrada sin cita | 0 | Moore (2016) y Waggoner et al. (2026) se citan solo en el glosario. Es válido |
| Año, grafía, tilde o partícula distintos | 0 | Se revisaron Grüning, Terzimehić, Peña-Albert, O’Rear, “De Segovia” al inicio de oración, De Russis, van den Hoven, von Lindern, de Vries, Kauppinen-Räisänen y Sánchez-Borrero |
| Mismo autor y año sin a/b, o “et al.” mal usado | 0 | E. B.-N. Sanders y S. Sanders llevan iniciales, como pide APA 7 |
| Comunicación personal en la lista | 0 | D. Parra se cita tres veces solo en el texto, con el formato correcto |
| Obras sin fecha después de las fechadas | 2 bloques | Memoria: Apple y Google. Es una regresión: el 9 de noviembre estaban bien |
| Autor o fecha omitidos aunque la página los muestra | 2 | Memoria: el codelab de Google es de Alex Hays (2026). Anexo H: Material Symbols guide tiene fecha (2024) |
| Formato incoherente | 2 | Memoria: Lukoff et al. (2021) da páginas en vez de número de artículo; “Material's” lleva apóstrofo recto |
| Localizador mal ubicado en la cita | 1 | Anexo H, línea 239 |
| Datos erróneos: autores, año, título, revista, volumen, páginas o DOI | 0 de 42 | 32 entradas nuevas o cambiadas y 10 de la muestra |
| Páginas citadas | 21 citas | 17 coinciden y 4 no se pudieron verificar. Ninguna contradice la fuente |
| Paráfrasis imprecisa | 2 | Norman, p. 73 (línea 178), y Guynn et al. (línea 168) |
| Cambio opcional | 1 | Fechar *Typography* de Apple como *Writing* |

## 2. Correcciones necesarias

Las filas 1 a 6 son necesarias. La 7 y la 8 son recomendadas y la 9 es opcional.

| # | Archivo | Línea | Problema | Texto actual | Texto corregido | Evidencia |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | memoria | 993–1003 | Las obras de Apple sin fecha van después de las fechadas | Apple (2024) · (2025a) · (2025b) · (s. f.-a) · (s. f.-b) · (s. f.-c) | Apple (s. f.-a) · (s. f.-b) · (s. f.-c) · (2024) · (2025a) · (2025b). Las líneas 999, 1001 y 1003 pasan antes de la 993. El texto de las entradas no cambia | APA 7, §9.46: las obras sin fecha de un autor van antes que las fechadas. Purdue OWL lo dice igual. La verificación del 9 de noviembre ya lo había corregido |
| 2 | memoria | 1037–1043 | El mismo problema con Google | Google (2026a) · (2026b) · (s. f.-a) · (s. f.-b) | Con la fila 3, el bloque queda así: `Google. (s. f.). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Pixel Phone Help. Recuperado el 11 de octubre de 2026, de https://support.google.com/pixelphone/answer/9137850?hl=en` y después Google (2026a) y Google (2026b), sin cambios. Sin la fila 3, el orden es (s. f.-a) · (s. f.-b) · (2026a) · (2026b) | Como en la fila 1 |
| 3 | memoria | 1043. Citas en 378, 633 y 641 | El codelab muestra su autor y su fecha, y la entrada los omite | `Google. (s. f.-b). *Material's communication principles: Intro to UX writing* [Codelab]. Google Codelabs. Recuperado el 10 de noviembre de 2026, de https://codelabs.developers.google.com/codelabs/material-communication-guidance` | Entrada nueva entre Haliburton (1049) y Hellier (1051): `Hays, A. (2026, 27 de marzo). *Material’s communication principles: Intro to UX writing* [Codelab]. Google Codelabs. https://codelabs.developers.google.com/codelabs/material-communication-guidance`. Citas: en la 378, `(Apple, s. f.-b; Google, s. f.)`; en la 633, `Apple (2024, 2025b), Google (Hays, 2026) y Microsoft (2021)`; en la 641, `Apple (2024, 2025b), Hays (2026) y Microsoft (2021)`. Si no se aplica, al menos va `Material’s` con apóstrofo curvo, como en el resto de la lista | La página dice “Escrito por Alex Hays” y “Última actualización: mar 27, 2026”. En el HTML: `authors="Alex Hays"` y `last-updated="2026-03-27"`. APA 7 pide el autor individual que nombra la página y la fecha de actualización (§9.15) |
| 4 | memoria | 1087 | La ponencia de CHI 2021 tiene número de artículo. Las otras entradas de CHI lo usan: Haliburton (Artículo 243) y Lyngs (Artículo 131) | `… Human Factors in Computing Systems* (pp. 1–17). Association for Computing Machinery. …` | `Lukoff, K., Lyngs, U., Zade, H., Liao, J. V., Choi, J., Fan, K., Munson, S. A. y Hiniker, A. (2021). How the design of YouTube influences user sense of agency. En *Proceedings of the 2021 CHI Conference on Human Factors in Computing Systems* (Artículo 368). Association for Computing Machinery. https://doi.org/10.1145/3411764.3445467` | El registro de Oxford (ORA, uuid:31bc88e5…) da el artículo 368. Crossref solo da pp. 1–17 |
| 5 | Anexo H | 359–361. Citas en 158, 161 y 187 | La guía de Material Symbols tiene fecha | `Google. (s. f.-a). *Material Symbols guide*. …` y `Google. (s. f.-b). *System icons*. …` | `Google. (s. f.). *System icons*. Material Design. Recuperado el 10 de noviembre de 2026, de https://m2.material.io/design/iconography/system-icons.html` y después `Google. (2024, 26 de septiembre). *Material Symbols guide*. Google for Developers. https://developers.google.com/fonts/docs/material_symbols`. Citas: en la 158, `(Google, s. f.)`; en la 161 y la 187, `(Google, 2024)` | El pie de la página dice “Last updated 2024-09-26 UTC”. Es el criterio con que la memoria fecha las páginas de Android Developers |
| 6 | Anexo H | 239 | El localizador va antes del autor | `4,5:1 para la tipografía (criterio 1.4.3) y 3:1 para los gráficos que informan (criterio 1.4.11; World Wide Web Consortium, 2024).` | `4,5:1 para la tipografía y 3:1 para los gráficos que informan (World Wide Web Consortium, 2024, criterios 1.4.3 y 1.4.11).` | APA 7, §8.13: la parte citada va después del año. La línea 238 ya lo hace bien |
| 7 | memoria | 178 | “Todo recordatorio reúne” no es lo que dice la fuente, y choca con la frase siguiente | `Todo recordatorio reúne una señal que avisa que hay algo que recordar y un mensaje que dice qué es (Figura 3). El ideal tiene los dos (Norman, 1988/2002, p. 73).` | `Un recordatorio tiene dos aspectos: una señal que avisa que hay algo que recordar y un mensaje que dice qué es (Figura 3). Muchos dan solo uno; el ideal tiene los dos (Norman, 1988/2002, p. 73).` | PDF local de Norman, p. 73: distingue los dos aspectos y dice que la mayoría de los recordatorios da solo uno |
| 8 | memoria | 168 | Guynn et al. estudiaron eventos, no momentos del reloj | `…nombraban a la vez el momento de actuar y la acción que había que hacer; los que solo nombraban el momento no mejoraron el recuerdo (Guynn et al., 1998, p. 296).` | `…nombraban a la vez la ocasión de actuar y la acción que había que hacer; los que solo nombraban la ocasión no mejoraron el recuerdo (Guynn et al., 1998, p. 296).` | El resumen (PubMed 9584436) dice que los recordatorios eficaces nombraban el evento objetivo y la acción. El Anexo H, línea 99, ya dice “la ocasión” |
| 9 | memoria | 1003. Citas en 625, 633, 641 y 643 | Opcional. *Typography* tiene la misma fecha de actualización que *Writing*, y solo *Writing* se fecha | `Apple. (s. f.-c). *Typography*. Human Interface Guidelines. Recuperado el 2 de noviembre de 2026, de https://developer.apple.com/design/human-interface-guidelines/typography` | `Apple. (2025b, 16 de diciembre). *Typography*. Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/typography`. *Writing* pasa a 2025c. Citas: en la 625, `Apple, 2025b`; en la 633, la 641 y la 643, `2025c` | En las dos páginas, la última entrada del registro de cambios es del 16 de diciembre de 2025 |

**Lo que no requiere cambio**

- La misma obra lleva distinta letra en la memoria y en un anexo: Lucide design language, UsageStatsManager y Screen Time. Es correcto, porque cada lista asigna sus letras.
- Ottosson (2020), S. Sanders (2026) y Slack (2019) son entradas de blog. APA 7 también admite citarlas como artículo de blog: el título sin cursiva y el nombre del blog en cursiva. El formato de página web que usan se aceptó el 9 de noviembre.
- La “y” sin coma antes del último autor coincide con la guía de la Escuela (`Guía APA_Citación Textos_diseño.pdf`, p. 9).
- La sangría francesa y las cursivas están bien en `memoria-relevo-v8-1920x1080.pdf` (p. 67) y en `anexos-relevo.pdf` (p. 116).
- Las abreviaturas [UNAM] e [ISO] del Anexo H están bien introducidas.

## 3. Muestra verificada

### 3.1 Entradas nuevas o cambiadas (32)

“Coincide” significa que lo que la memoria afirma con esa cita está en la fuente.

| Entrada | Veredicto | Evidencia |
| --- | --- | --- |
| **Memoria** | | |
| Ball, Peper y Robison (2025) | Correcta. La línea 130 coincide | Crossref 10.1037/pag0000844: B. Hunter Ball, Phil Peper y Matthew K. Robison; *Psychology and Aging* 40(1), 54–65, febrero de 2025. Salió en línea en septiembre de 2024 (PubMed 39325414). El DOI lleva a doi.apa.org. En el texto completo (PMC11781985) los encargos se veían arriba en la pantalla |
| Corporación de Fomento de la Producción (s. f.) | Correcta. La línea 802 coincide | corfo.gob.cl responde. Título: “Semilla Inicia”. Hasta 15 millones de pesos y hasta el 75 % del proyecto; personas mayores de 18 años con residencia en Chile. Hay una nota en la sección 4 |
| Covington, Adams y Sargin (2016) | Correcta. La línea 256 coincide | Crossref 10.1145/2959100.2959190: RecSys ’16, pp. 191–198. El DOI lleva a dl.acm.org. El modelo de ranking predice el tiempo de visionado esperado (sección 4.2 de la copia en research.google.com) |
| Driver y Nasgowitz (2026) | Correcta | Google Patents US20260082231A1: Thomas John Killian Driver y Zachary Mario Nasgowitz. Publicada el 19 de marzo de 2026; titular, Brick LLC. Texto idéntico al del Anexo C, verificado el 9 de noviembre |
| Fuenzalida y Egstad (s. f.) | Correcta. La línea 672 coincide | Página “About” de Google Fonts y archivo METADATA.pb del repositorio google/fonts: diseñadores Rodrigo Fuenzalida y Jordan Egstad. Fuenzalida está radicado en Santiago. La página no muestra fecha |
| Google (s. f.-a), Pixel | Correcta. Solo cambió de letra | Verificada el 9 de noviembre. El enlace responde |
| Google (s. f.-b), codelab | Faltan el autor y la fecha. Ver la fila 3 | El título coincide. La página nombra a Alex Hays y da el 27 de marzo de 2026 |
| Herman y Akmal (2023) | Correcta | Google Patents US20230267422A1: Brad K. Herman y Shiraz Akmal. Publicada el 24 de agosto de 2023; titular, Apple Inc. |
| Hofmann, Vohs y Baumeister (2012) | Correcta. La línea 454 coincide | Crossref 10.1177/0956797612437426: *Psychological Science* 23(6), 582–588. El DOI lleva a SAGE. Según el resumen, los deseos de usar medios y de trabajar son los que más terminan en fallas de autocontrol |
| Indian Type Foundry (s. f.) | Correcta | API de Fontshare: la editora es Indian Type Foundry y la diseñadora, Manushi Parikh. El sitio muestra a la fundición como autora. El enlace responde |
| Kleinberg, Mullainathan y Raghavan (2024) | Correcta. La línea 256 coincide | Crossref solo tiene la versión en línea, del 7 de noviembre de 2023 y sin volumen. RePEc da *Management Science* 70(9), 6336–6355, 2024. El DOI lleva a INFORMS |
| Lucide Contributors (s. f.-a), design language | Correcta | lucide.dev responde. Título: “Lucide design language”. Pide un lienzo de 24, un margen de 1 y un trazo de 2 |
| Lucide Contributors (s. f.-b), license | Correcta. La línea 674 coincide | lucide.dev/license: licencia ISC, y MIT para los íconos que vienen de Feather. Las dos piden conservar el aviso |
| Lukoff et al. (2021) | Datos correctos, sin número de artículo (fila 4). Las líneas 96, 222 y 454 coinciden | Crossref 10.1145/3411764.3445467: ocho autores en el orden de la entrada; CHI ’21, pp. 1–17. ORA da el artículo 368. Según el resumen (arXiv 2101.11778), la reproducción automática y las recomendaciones debilitan el sentido de agencia |
| Ministerio de las Culturas, las Artes y el Patrimonio (s. f.) | Correcta. La línea 801 coincide | fondosdecultura.cl responde. “Investigación - Fondart Nacional 2027”: cerró en septiembre de 2026, da hasta 15 millones por proyecto e incluye el diseño |
| Moore (2016) | Correcta. El glosario (línea 1308) coincide | Crossref 10.3389/fpsyg.2016.01272: *Frontiers in Psychology* 7, artículo 1272. El texto (PMC5002400) distingue la sensación y el juicio de agencia |
| Newman y Newman (2022) | Correcta | Google Patents US11321677B1: Julia Jester Newman y Russell Grant Newman. Concedida el 3 de mayo de 2022 |
| Ottosson (2020) | Correcta | La entrada del blog es del 23 de diciembre de 2020. Texto idéntico al del Anexo H, verificado el 9 de noviembre |
| Reinecke y Hofmann (2016) | Correcta. Las líneas 222 y 454 coinciden | Crossref 10.1111/hcre.12082: *Human Communication Research* 42(3), 441–461. El DOI lleva a OUP. Según el resumen, el uso recreativo de medios mejoró el bienestar |
| Rosenberg (2009) | Correcta | Google Patents US7577522B2: Louis B. Rosenberg. Concedida el 18 de agosto de 2009 |
| Servicio de Cooperación Técnica (s. f.) | Correcta. La línea 802 coincide | sercotec.cl responde. Subsidio de 3,5 millones de pesos, aporte propio del 3 %, para personas sin inicio de actividades en primera categoría |
| Sheeran y Webb (2016) | Correcta. La línea 903 coincide | Crossref 10.1111/spc3.12265: *Social and Personality Psychology Compass* 10(9), 503–518. El DOI lleva a Wiley |
| Apple (s. f.-a, s. f.-b y s. f.-c) | Mismo texto que el 9 de noviembre, en mal lugar. Ver la fila 1 | Comparación con la v6 verificada |
| **Anexo H** | | |
| Apple (s. f.), SF Symbols | Correcta. Las líneas 160 y 187 coinciden | developer.apple.com/sf-symbols responde: símbolos en nueve pesos que se alinean con el texto |
| Google (s. f.-a), Material Symbols guide | Falta la fecha. Ver la fila 5. Las líneas 161 y 187 coinciden | Pie de la página: “Last updated 2024-09-26 UTC”. El eje de tamaño óptico ajusta el grosor del trazo |
| Google (s. f.-b), System icons | Correcta. La línea 158 coincide | La página actual se arma con JavaScript. La copia de material.io en Internet Archive (22 de enero de 2020) da un área viva de 20 × 20 dp con 2 dp de margen |
| Harley (2014) | Correcta. Las líneas 167 y 187 coinciden | nngroup.com: Aurora Harley, 27 de julio de 2014, “Icon Usability”. Recomienda acompañar los íconos con texto |
| Hou y Pan (2025) | Correcta. La línea 189 coincide | Crossref 10.1080/10447318.2025.2466063: *International Journal of Human–Computer Interaction* 41(20), 12959–12969. En línea en febrero y en el número de octubre de 2025. Según el resumen, el dibujo directo del concepto se entiende más rápido |
| Lucide Contributors (s. f.-a), specification | Correcta | lucide.dev responde. Título: “Icon design specification” |
| Lucide Contributors (s. f.-b), design language | Correcta | La misma página que cita la memoria, con otra letra |
| Lucide Contributors (2026), versión 1.70.0 | Correcta | GitHub lucide-icons/lucide: la versión 1.70.0 salió el 6 de noviembre de 2026 |
| Shen, Xue y Wang (2018) | Correcta. La línea 189 coincide | Crossref 10.1177/2041669518780807: *i-Perception* 9(3), artículo 2041669518780807. Según el resumen, los íconos de objetos familiares se identifican mejor |
| Restrepo Betancur (2022) | Correcta. Solo cambiaron las comillas | Verificada el 9 de noviembre |

Todos los DOI de esta sección y de la 3.2 resuelven en doi.org y llevan a la página de su editorial.

### 3.2 Muestra aleatoria (10)

**Cómo se eligió.** La población son las 101 entradas que no cambiaron desde el 9 de noviembre. Son 79 de la memoria, idénticas a la lista verificada, y 22 que solo están en los anexos. Se ordenaron alfabéticamente y se sacaron 10 con Python: `random.seed(20261125)` y `random.sample(range(101), 10)`. Salieron los índices 1, 4, 23, 31, 40, 50, 57, 66, 71 y 85.

| Índice | Entrada | Veredicto | Evidencia |
| --- | --- | --- | --- |
| 1 | Android Open Source Project (s. f.), *TypeScaleTokens.kt* | Correcta | GitHub responde: es el archivo de tokens de Compose Material 3 en la rama androidx-main. Como el código cambia, la fecha de consulta corresponde |
| 4 | Apple (2025b), *Writing* | Correcta. La línea 643 coincide | HIG: el título es “Writing” y la última entrada del registro de cambios es del 16 de diciembre de 2025. La guía recomienda que los botones empiecen con un verbo |
| 23 | Hellier, Edworthy y Dennis (1993) | Correcta | Crossref 10.1177/001872089303500408: Elizabeth J. Hellier, Judy Edworthy e Ian Dennis; *Human Factors* 35(4), 693–706, diciembre de 1993 |
| 31 | Kitchen Safe (s. f.) | Correcta. La línea 388 coincide | thekitchensafe.com responde. Título: “kSafe by Kitchen Safe \| The Time Lock Safe”. Se abre solo cuando el temporizador llega a cero |
| 40 | Meier y Reinecke (2021) | Correcta. La línea 120 coincide | Crossref 10.1177/0093650220958224: *Communication Research* 48(8), 1182–1209. En línea en 2020 y en el número de diciembre de 2021. El resumen da 34 revisiones y una asociación negativa pequeña |
| 50 | O’Rear y Radvansky (2019) | Correcta. La línea 132 coincide | Crossref 10.1177/1747021818758608: *Quarterly Journal of Experimental Psychology* 72(3), 491–507. En línea en 2018 y en el número de marzo de 2019 |
| 57 | Sanders y Stappers (2012) | Correcta | PDF local, p. 313 del PDF: copyright de 2012 de BIS Publishers, E. B.-N. Sanders y P. J. Stappers; ISBN 978-90-6369-284-1 |
| 66 | Terzimehić et al. (2022) | Correcta. La línea 126 coincide | Crossref 10.1145/3532106.3533575: seis autores en el orden de la entrada; DIS ’22, pp. 1818–1830. El resumen coincide con lo que la memoria dice de las dos preguntas |
| 71 | Weiser y Brown (1997) | Correcta | Crossref 10.1007/978-1-4612-0685-9_6: capítulo de *Beyond Calculation*, pp. 75–85, de Springer New York con su sello Copernicus. ISBN 978-0-387-98588-6, confirmado en Open Library |
| 85 | Google (2026, 28 de agosto), *UsageStatsManager* (Anexo D) | Correcta | developer.android.com: “Last updated 2026-08-28 UTC” |

## 4. Citas textuales y páginas

Ni la memoria ni los anexos citan textualmente una obra publicada. La única cita textual de una fuente es una comunicación personal: D. Parra, en la línea 256. No lleva página ni entrada, y está bien. Las frases entre comillas de las líneas 889 y 891 son de participantes de la prueba. Los anexos no citan páginas.

Hay 21 citas con página, todas de paráfrasis:

| Línea | Cita | Fuente revisada | Resultado |
| --- | --- | --- | --- |
| 112 | Lyngs et al. (2019, pp. 7–8) | No hay PDF local. Se usó la copia de arXiv 1902.00157, con el formato de CHI | Coincide. En la p. 7, el 74 % de las herramientas bloquea o quita distracciones. En la p. 8, el 38 % registra el uso, el 35 % ayuda a avanzar a una meta y el 22 % premia o castiga. Las subcategorías de la Figura 1 coinciden |
| 160 y 268 | Ryan y Deci (2000, p. 70) | No hay PDF local. Se usó la copia escaneada de selfdeterminationtheory.org, con la paginación de la revista | Coincide: elegir aumenta la motivación intrínseca, y las órdenes, las amenazas y los plazos la disminuyen |
| 168 | Guynn et al. (1998, p. 296) | No hay PDF local. Springer bloquea la descarga automática | El contenido coincide con el resumen. La página no se verificó. Ver la fila 8 |
| 178, 186 y 895 | Norman (1988/2002, p. 73) | PDF local. La página 87 del PDF es la p. 73 | Coincide: el recordatorio tiene señal y mensaje, y el ideal tiene los dos. En la línea 895 también coincide el ejemplo del libro junto a la puerta. Para la línea 178, ver la fila 7 |
| 188 | Kirsh (1995, p. 31) | No hay PDF local. Se usó la copia del autor en interactivity.ucsd.edu | Coincide con el resumen, que va en la p. 31, la primera del artículo (pp. 31–68) |
| 188 | Kirsh (1995, p. 38) | No hay PDF local. La copia del autor no tiene páginas y ScienceDirect bloquea la descarga | El contenido coincide: un rollo de película junto a la puerta como recordatorio que llama la atención a tiempo. La página no se verificó |
| 202 | Norman (1988/2002, p. 103) | PDF local. La página 117 del PDF es la p. 103 | Coincide: el sonido se detecta aunque la atención esté en otra parte, y por eso es intrusivo |
| 254 | McDaniel y Einstein (2000, p. S138) | No hay PDF local ni copia abierta | Coherente con el resumen, según el cual vigilar el entorno exige recursos. La página no se verificó |
| 298 y 306 | E. B.-N. Sanders y Stappers (2012, p. 69) | PDF local. La página 71 del PDF es la p. 69 | Coincide: lo que las personas dicen difiere de lo que hacen |
| 529 | E. B.-N. Sanders y Stappers (2012, p. 66) | PDF local. La página 68 del PDF es la p. 66 | Coincide: se puede ir a las casas a observar lo que la gente hace, además de oír lo que dice |
| 418 | Kolko (2011, p. 40) | PDF local. La página 61 del PDF es la p. 40 | Coincide casi literal: la síntesis traduce la oportunidad en criterios de diseño específicos |
| 490 | Nielsen (1993, p. 170) | PDF local, una impresión de DjVu. La página 183 del PDF es la p. 170 | Coincide: la evaluación formativa busca mejorar la interfaz en un diseño iterativo |
| 702 | Nielsen (1993, pp. 96–97) | El mismo PDF, páginas 109 y 110 | Coincide: un prototipo puede usar medios más simples si conserva lo esencial de la interacción |
| 720 | Middlebrooks y Green (1991, p. 138) | No hay PDF local ni copia abierta | No verificado. El resumen de PubMed no habla del timbre |
| 785 | Gembali (2023, p. 53) | PDF local, p. 53 | Coincide: comprar un dispositivo existente evita invertir en hardware, pero puede no tener justo las funciones necesarias |
| 840 | Nielsen (1993, p. 221) | El mismo PDF, página 234 | Coincide: el registro muestra qué hizo la persona, pero no por qué |
| 903 | Fogg (2009, p. 1) | PDF local, versión del autor, p. 1 | Coincide: motivación, capacidad y señal tienen que darse en el mismo momento |

Uno de los PDF locales de Nielsen es un resumen, no el libro. No se usó.

**Notas sobre lo que afirman las fuentes nuevas**

- **Corfo (línea 802).** La página citada es la de la convocatoria 2024 de Semilla Inicia. Está cerrada y era solo para Arica y Parinacota, Coquimbo, Magallanes y Maule. Lo que dice la memoria coincide con la página, pero no hay una convocatoria vigente que lo respalde.
- **Lucide en el Anexo H (líneas 146, 187 y 199).** Dicen “con licencia ISC”. La licencia de Lucide también trae la MIT para los íconos que vienen de Feather. La app ya incluye las dos en `assets/licencias/LUCIDE_LICENSE.txt`. Una forma precisa: “con licencia ISC (MIT en los íconos que vienen de Feather)”.

## 5. No verificado

1. **Cuatro páginas.** Guynn et al. (1998, p. 296), Kirsh (1995, p. 38), McDaniel y Einstein (2000, p. S138) y Middlebrooks y Green (1991, p. 138). No hay PDF local. Las copias en línea están bloqueadas para herramientas automáticas (Springer y ScienceDirect) o son de pago (Wiley y Annual Reviews). El contenido de las tres primeras coincide con su resumen o con la copia del autor. Para cerrarlas, basta abrir cada PDF desde la biblioteca de la UDP.
2. **El costo de la IA (línea 778).** “A unos 20 dólares al mes” quedó sin fuente. En la v6, esa fila citaba (Anthropic, s. f.; OpenAI, s. f.), dos entradas verificadas el 9 de noviembre que la v8 quitó. Si se quiere fuente, se pueden reponer con el texto de la v6: `Anthropic. (s. f.). *Planes y precios*. Claude. Recuperado el 27 de octubre de 2026, de https://claude.com/es/pricing` y `OpenAI. (s. f.). *Planes y precios*. ChatGPT. Recuperado el 27 de octubre de 2026, de https://chatgpt.com/es-419/pricing/`. Los precios no se volvieron a revisar. Cursor no tiene entrada.
3. **Copias abiertas.** Lyngs et al. (pp. 7–8), Ryan y Deci (p. 70) y Kirsh (p. 31) se verificaron con copias abiertas, no con PDF locales. La de Lyngs es de arXiv, con el mismo formato que la ponencia de ACM. La de Fogg es la versión del autor, y se supuso que su p. 1 es la misma del artículo 40 de ACM.
4. **Patentes.** Se verificaron en Google Patents, no en la USPTO.
5. **Resto de la lista.** Las 91 entradas sin cambios que quedaron fuera de la muestra no se volvieron a verificar: valen las verificaciones del 9 de noviembre.
6. **Semilla Inicia.** No se revisó si Corfo abrirá una convocatoria nueva.

## Registro de cambios (disclaimer)

### 2026-11-25 — Guynn et al., p. 296, y Middlebrooks y Green, p. 138

- **Qué cambió:** se comprobaron las dos páginas con los PDF que el autor descargó desde la biblioteca de la UDP.
- **Cómo estaba antes:** figuraban como no verificadas.
- **Por qué:** el autor dio acceso a la biblioteca y descargó los artículos.

### 2026-11-25 — McDaniel y Einstein, p. S138

- **Qué cambió:** la página S138 de McDaniel y Einstein (2000) se comprobó con el acceso de la biblioteca de la UDP.
- **Cómo estaba antes:** figuraba como no verificada.
- **Por qué:** el autor dio acceso a la biblioteca para cerrar las páginas pendientes.

### 2026-11-25 — Verificación y correcciones

- **Qué cambió:** se cruzaron todas las citas de la memoria y de los anexos con sus listas, se contrastaron 42 obras con su fuente y se revisaron 21 citas con página. Las correcciones se aplicaron el mismo día.
- **Cómo estaba antes:** la última verificación completa era la del 9 de noviembre, sobre la v6. La v8 sumó 22 obras a la memoria y 10 al Anexo H.
- **Por qué:** los profesores pidieron revisar a mano una muestra de referencias frente a sus citas, y el autor pidió revisar las fuentes como prioridad después del Pase.
