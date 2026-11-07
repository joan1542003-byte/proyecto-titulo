# Por qué Relevo tiene íconos propios

**Fecha:** 6 de noviembre de 2026. **Qué es:** el fundamento de haber dibujado íconos propios en vez de usar un set existente, con fuentes y una comparación con los íconos de ChatGPT. No agrega una decisión: reúne lo que sostiene a D-073, D-124 y D-158. **Íconos de la app:** 117 en la 4.4 ([`KitIcons.kt`](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/components/KitIcons.kt)), del kit D-073 ampliado en la 4.0 y la 4.3. Usan la retícula de 24 y, desde la 4.1, los tamaños ópticos de D-124 ([documento 39](39_iconos-y-color-con-fundamento-2026-10-11.md)).

## En breve

- **Primero se investigó y después se dibujó.** El 11 de octubre (D-124) se estudiaron Material Design, SF Symbols y Nielsen Norman Group. De ellos se tomaron la retícula, los tamaños ópticos y la regla de acompañar cada ícono con una palabra; los dibujos se hicieron en Relevo.
- **Las actividades no son al azar.** Las 19 ideas de actividad de la app salen de lo que contaron P1–P8 sobre su tiempo libre y lo que les ayuda a desconectarse, y cada una dice en el código de quién viene.
- **Lo propio de Relevo no existe en otros sets:** el Tag como es, el sonido como anillos, el primer paso, el lugar, decidir, «Después» y «Cambié de idea».
- **El estilo es el que la gente ya conoce:** contorno, un solo color, retícula de 24 y puntas redondas, como ChatGPT y Material. Lo propio es el dibujo, no un estilo extraño.

## 1. Primero se investigó, después se dibujó

Antes de dibujar, D-124 revisó cómo construyen sus íconos los sistemas más usados y adoptó sus reglas:

| Regla | De dónde | En Relevo |
| --- | --- | --- |
| Retícula de 24 con área viva de 20 | Material Design, íconos de sistema | Igual |
| Formas de base del mismo peso visual | Material Design, *keylines* | Círculo, cuadrado, vertical y horizontal |
| Grosor ligado a la letra | SF Symbols | 1,6 a 24 px, medido en Instrument Sans Medium, la letra de la app |
| Tamaños ópticos | Material Symbols | De 2,0 a 16 px a 1,3 a 48 px (`opticalStroke` en [`Icons.kt`](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/components/Icons.kt)) |
| Con una palabra | Nielsen Norman Group | Los íconos van con su palabra; los pocos botones de solo ícono llevan su nombre para lectores de pantalla |

Lo que hace cualquier app (volver, borrar, buscar, agregar) se dibujó con las formas que la gente ya reconoce. Se dibujó a la medida lo que es de Relevo y lo que nombraron las personas.

## 2. No son íconos de actividades al azar

Desde la 2.13 (D-088), la app solo propone actividades que aparecen en las entrevistas, en tres preguntas: Q1 (tardes o noches sin obligaciones), Q2 (actividades que ayudan a desconectarse o descansar) y Q12 (estrategias para descansar sin el teléfono). Cada idea tiene su ícono y anota su fuente en [`Common.kt`](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/Common.kt):

| Actividad | Quién la nombró |
| --- | --- |
| Leer | P6, P8 |
| Dormir a tiempo | P2, P3, P8 |
| Hacer ejercicio | P1, P3 |
| Pasear al perro | P1, P4 |
| Dibujar, Pintar, Hacer manualidades, Jugar un juego de mesa | P2 |
| Cocinar, Leer manga | P1 |
| Estudiar | P8 |
| Ordenar la pieza | P5 |
| Armar una maqueta, Llamar a alguien | P6 |
| Salir en bicicleta | P7 |
| Meditar | P3 |
| Jugar videojuegos | P3, P6, P7, P8 |
| Escuchar música | P5, P6, P8 |
| Ver una película | P1, P2, P5 |

La encuesta de 53 respuestas muestra la brecha que esas actividades llenan ([análisis](../03_usuarios/encuesta-53-respuestas-2026-09.md)):

- En 43 de 47 episodios había otra actividad que la persona quería hacer.
- En 21 de esos 43, no la empezó.
- En 42 de 43, supo decir con qué habría empezado.

Por eso la firma de la marca es «Vuelve a lo que querías hacer» (D-073). Los íconos dibujan esas actividades: lo que estas personas hacen o quieren hacer en vez de seguir en el teléfono.

**Dos precisiones, para escribirlo con exactitud:**

- **«Recuperar»:** las entrevistas preguntaron qué hacen y qué les ayuda a desconectarse, no qué dejaron de hacer. La palabra que sostienen los datos es «lo que querían hacer», que es también la de la firma.
- **El catastro de la 4.3** (D-158) reconoce 34 conceptos y sumó 13 íconos, como nadar, tejer, piano, idiomas y cartas, para entender lo que la persona escribe. Esos conceptos amplían las 19 ideas y no anotan una fuente en el corpus.

## 3. Por qué no usar los íconos de otros

Hay sets abiertos y muy completos. Material Symbols tiene más de 3.800 íconos con licencia Apache 2.0 (Google, s. f.-a). Al revisar su lista oficial, el 5 de noviembre de 2026, ya tenía equivalentes genéricos de casi todas las actividades: `pets`, `directions_bike`, `menu_book`, `bed`, `fitness_center`, `brush`, `palette`, `cooking`, `self_improvement`, `sports_esports`, `headphones`, `movie`, `call`, `manga` y `chess`, entre otros. No se encontraron tejer, armar una maqueta ni la correa del perro. **La razón no es que no existan.** Son estas:

| Razón | Qué dice la evidencia | En Relevo |
| --- | --- | --- |
| **Lo propio de Relevo no está en ningún set** | Un ícono que dibuja directamente lo que significa se entiende más rápido y con más precisión que uno que lo sugiere por metáfora o por una parte (Hou y Pan, 2025). La familiaridad con lo dibujado mejora la identificación (Shen et al., 2018). | El Tag se dibuja como el objeto que la persona tiene en la mano: redondo, con su botón y su argolla. El ícono remite a un objeto que la persona ya conoce, y el objeto físico y la pantalla se nombran igual, que es lo phygital del proyecto. |
| **Cerca de lo que la persona nombró** | Cuanto menor es la distancia semántica, es decir, entre el dibujo y su significado (McDougall et al., 1999), mejor se busca y se reconoce un ícono (Zhang et al., 2024). Esa distancia es decisiva mientras se aprende qué significa cada ícono; después pesa la familiaridad (Isherwood et al., 2007). | Un set general nombra categorías: `pets` es una huella. Relevo dibuja la actividad tal como se dijo, «Pasear al perro», con el perro. |
| **Una sola voz** | La familiaridad con el estilo es lo que más explica que un ícono guste (Zheng et al., 2026). | Mezclar un set ajeno con los íconos de Relevo daría dos grosores y dos geometrías. Un set propio mantiene la retícula y el grosor de la letra, en el estilo de contorno que la gente ya conoce. |
| **Licencias** | SF Symbols solo se puede usar en apps para productos Apple (Apple, 2026, cláusula 2.10). Material Symbols (Apache 2.0) y los íconos de OpenAI (MIT) sí se podrían usar. | La app es Android, así que SF Symbols queda fuera. Las licencias no son razón contra Material ni OpenAI: la razón es la tabla de arriba. |
| **Con una palabra** | Con su palabra, desaparecen las diferencias de reconocimiento entre tipos de ícono y entre edades (Song et al., 2024). | Un ícono propio cuesta poco reconocimiento, porque casi siempre va con su palabra. |

Hay un precedente de íconos hechos a partir de lo que dicen quienes los usan: Salman et al. (2012) diseñaron los de un sistema de urgencias desde las tareas y los bocetos del personal, y otro grupo probó si se entendían. Relevo toma de las personas el contenido, es decir, las actividades. El dibujo lo hizo el diseño, así que falta medir si se entienden (sección 6).

## 4. Comparación con ChatGPT y con los sets más usados

Datos de las fuentes primarias, revisadas el 5 y el 6 de noviembre de 2026. Los de ChatGPT salen del código de los íconos que OpenAI publica para las apps dentro de ChatGPT (OpenAI, 2026); su guía pide íconos «monocromos y de contorno» (OpenAI, s. f.).

| | Relevo 4.4 | ChatGPT (Apps SDK UI) | Material Symbols | SF Symbols |
| --- | --- | --- | --- | --- |
| Retícula | 24, área viva de 20 | 24 | 24, con tamaños ópticos de 20 a 48 | Alineada a la letra San Francisco |
| Línea a 24 px | 1,6 (6,7 % del ancho), según el tamaño | 2 (8,3 %) | Variable, de 100 a 700 | Nueve pesos, como la letra |
| Puntas | Redondas | Redondas | Según el estilo: con contorno, redondeado o recto | Según el peso |
| Relleno | Un solo peso; solo se rellenan puntos que marcan algo | Contorno, con variantes rellenas | Eje de relleno de 0 a 1 | Contorno y relleno |
| Color | Tinta, un solo color | El del texto | Un solo color | Un solo color y modos de varios colores |
| Cantidad | 117 | Varios cientos | Más de 3.800 | Más de 7.000 |
| Licencia | Propia | MIT | Apache 2.0 | Solo para productos Apple |
| Actividades de Relevo | Las 19 ideas y los 34 conceptos | No: son de interfaz | Casi todas, genéricas | No se puede usar en Android |

**Lo que Relevo ya comparte con ChatGPT:** contorno, un solo color, retícula de 24, puntas redondas y la línea como la letra. **Lo que los distingue:** la línea de ChatGPT es más gruesa (2 frente a 1,6) y sus dibujos tienen menos detalle.

## 5. Si se quieren más refinados, al estilo de ChatGPT

Una parte se aplicó el 6 de noviembre (D-162, [documento 44](44_iconos-desde-lo-que-pide-la-app-2026-11-06.md)): menos detalle en cuatro actividades y once íconos rehechos según lo que pide la app. La línea de 1,8 a 2 y las variantes rellenas siguen pendientes. La propuesta completa era:

- **Menos detalle:** revisar cada ícono a 16 y 20 px y quitar los trazos que no se distinguen, como ya se hizo con «Caminar» y «Primer paso» (D-124).
- **Esquinas iguales:** un mismo radio en todas las esquinas, como en el set de OpenAI.
- **Probar una línea de 1,8 a 2:** solo si sigue pesando lo mismo que Instrument Sans junto al texto de la app. Se compara en pantalla, con el texto al lado.
- **Variantes rellenas para la pestaña activa,** como las de OpenAI y el eje de relleno de Material. Ya estaba pendiente en D-124.
- **Conservar lo específico:** el Tag, los anillos y las actividades de P1–P8 no se cambian por formas genéricas.

## 6. Lo que falta para cerrarlo

- **Medir si se entienden:** mostrar cada ícono sin su palabra y pedir que digan qué significa, con el método de ISO 9186-1 (International Organization for Standardization, 2014). Todavía no se ha hecho con personas.
- **Las actividades de la encuesta:** la pregunta 5 pedía cuál era la otra actividad, pero el repositorio solo guarda recuentos, porque las respuestas quedan fuera. Contar qué actividades se nombraron mostraría si los 34 conceptos las cubren.

## 7. Texto propuesto para la memoria

> Los íconos de Relevo son propios. Antes de dibujarlos se estudiaron Material Design y SF Symbols, y de ellos se tomaron la retícula de 24, los tamaños ópticos y un grosor ligado a la letra de la app. Material Symbols ya ofrecía equivalentes genéricos de casi todas las actividades, de modo que la razón no fue su ausencia. Las actividades de la app provienen de lo que contaron P1–P8 sobre su tiempo libre y lo que les ayuda a desconectarse, y la encuesta mostró que en 43 de 47 episodios había otra actividad que la persona quería hacer. Un dibujo cercano a lo que la persona nombró se reconoce mejor, sobre todo mientras aprende a usar la app (Zhang et al., 2024; Isherwood et al., 2007). Además, el Tag se dibuja como el objeto que la persona tiene en la mano, y un dibujo directo de un objeto familiar se entiende más rápido (Hou y Pan, 2025; Shen et al., 2018). Los íconos van con su palabra, lo que iguala el reconocimiento (Song et al., 2024). Falta medir con personas si se entienden sin ella.

## Referencias

Apple. (s. f.). *SF Symbols*. Apple Developer. https://developer.apple.com/sf-symbols/

Apple. (2026). *Xcode and Apple SDKs Agreement* [Acuerdo de licencia]. https://www.apple.com/legal/sla/docs/xcode.pdf

Google. (s. f.-a). *Material Symbols guide*. Google for Developers. https://developers.google.com/fonts/docs/material_symbols

Google. (s. f.-b). *System icons*. Material Design. https://m2.material.io/design/iconography/system-icons.html

Harley, A. (s. f.). *Tips for icon usability* [Video]. Nielsen Norman Group. https://www.nngroup.com/videos/icon-usability/

Hou, G. y Pan, Y. (2025). What's behind the graphic? The impact of pictogram-semantic mapping structure on icon understanding. *International Journal of Human–Computer Interaction, 41*(20), 12959–12969. https://doi.org/10.1080/10447318.2025.2466063

International Organization for Standardization. (2014). *Graphical symbols — Test methods — Part 1: Method for testing comprehensibility* (ISO 9186-1:2014).

Isherwood, S. J., McDougall, S. J. P. y Curry, M. B. (2007). Icon identification in context: The changing role of icon characteristics with user experience. *Human Factors, 49*(3), 465–476. https://doi.org/10.1518/001872007X200102

McDougall, S. J. P., Curry, M. B. y de Bruijn, O. (1999). Measuring symbol and icon characteristics: Norms for concreteness, complexity, meaningfulness, familiarity, and semantic distance for 239 symbols. *Behavior Research Methods, Instruments, & Computers, 31*(3), 487–519. https://doi.org/10.3758/BF03200730

OpenAI. (s. f.). *UI guidelines*. OpenAI Developers. https://developers.openai.com/apps-sdk/concepts/design-guidelines

OpenAI. (2026). *Apps SDK UI* (Versión 0.2.2) [Software]. GitHub. https://github.com/openai/apps-sdk-ui

Salman, Y. B., Cheng, H.-I. y Patterson, P. E. (2012). Icon and user interface design for emergency medical information systems: A case study. *International Journal of Medical Informatics, 81*(1), 29–35. https://doi.org/10.1016/j.ijmedinf.2011.08.005

Shen, Z., Xue, C. y Wang, H. (2018). Effects of users' familiarity with the objects depicted in icons on the cognitive performance of icon identification. *i-Perception, 9*(3), Artículo 2041669518780807. https://doi.org/10.1177/2041669518780807

Song, X., Lin, Z. y Tang, R. (2024). Developing icons for older adults: The roles of icon design categories, text labels, and learning strategies. *International Journal of Industrial Ergonomics, 102*, Artículo 103613. https://doi.org/10.1016/j.ergon.2024.103613

Zhang, Y., Shao, J., Qin, L., Zhan, Y., Zhao, X., Geng, M. y Chen, B. (2024). Semantic distance of icons: Impact on user cognitive performance and a new model for semantic distance classification. *International Journal of Industrial Ergonomics, 102*, Artículo 103610. https://doi.org/10.1016/j.ergon.2024.103610

Zheng, J., Silvennoinen, J. y Kujala, T. (2026). The association between aesthetic appeal and semantic distance of icons varying in concreteness: Shedding light on the aesthetic-usability effect. *International Journal of Human-Computer Studies, 211*, Artículo 103799. https://doi.org/10.1016/j.ijhcs.2026.103799

## Registro de cambios (disclaimer)

### 2026-11-06 — Refinamiento aplicado en parte

- **Qué cambió:** la sección 5 enlaza lo aplicado en D-162.
- **Cómo estaba antes:** la sección 5 era solo una propuesta.
- **Por qué:** el autor pidió continuar con los íconos.

### 2026-11-06 — Creación

- **Qué cambió:** se documenta por qué Relevo tiene íconos propios, de dónde salen sus actividades y cómo se comparan con los de ChatGPT, Material Symbols y SF Symbols.
- **Cómo estaba antes:** la construcción estaba en el documento 39 y la marca en el 42, pero no había un argumento reunido de por qué no usar un set existente.
- **Por qué:** el autor preguntó cómo justificar los íconos propios y si responden a lo que querían sus usuarios.
