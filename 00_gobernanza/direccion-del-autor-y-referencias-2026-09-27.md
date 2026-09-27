# Cómo el autor orientó el trabajo con IA en Relevo

**Fecha:** 27 de septiembre de 2026. **Estado:** recopilación documental parcial. **Uso:** proceso de diseño, preparación de la defensa y antecedente para un posible apartado metodológico. No modifica la memoria, la app ni las decisiones vigentes.

## Qué reúne este documento

Johan pidió reunir las recomendaciones, referencias y correcciones que fue entregando a las herramientas durante el desarrollo de Relevo. Aquí se documenta esa dirección: qué contexto aportó, qué pidió estudiar, qué resultados rechazó y qué cambios solicitó. La palabra entrenamiento, usada en la conversación, se entiende aquí como instrucciones y retroalimentación acumuladas; el registro no demuestra un entrenamiento de los modelos.

Hay dos fuentes principales: los mensajes del autor visibles en esta conversación de Codex y mensajes originales de la tarea **Repositorio proyecto-titulo** de Claude para Windows. La correspondencia entre la tarea de Windows y su registro local de Claude Code se verificó mediante su identificador de sesión. El [anexo de fuentes](fuentes-direccion-del-autor-2026-09-27.md) permite localizar los mensajes, distingue citas de síntesis y explica qué se pudo recuperar.

Complementa la [trazabilidad del uso de IA](trazabilidad-uso-ia-2026-09-23.md). Aquella registra tareas ejecutadas por las herramientas; este documento se concentra en las entradas, referencias y revisiones del autor. Ninguno permite atribuirle automáticamente al autor todas las decisiones propuestas por un agente.

## 1. Los criterios que el autor sostuvo durante el proceso

Las siguientes entradas son **síntesis editoriales**, no citas literales. Los códigos C remiten a grupos de mensajes de Codex; los códigos L, a mensajes originales de Claude. Se desarrollan en el anexo.

| Área | Orientación del autor | Qué permite reconocer en el proceso | Fuente |
| --- | --- | --- | --- |
| Contexto antes de producir | Leer la memoria, entrevistas, feedback, encargos y README de cada carpeta antes de desarrollar. | El resultado debe responder a un proyecto documentado; no basta una instrucción aislada de producir una app. | C01, C02; L01 |
| Investigación | Revisar cómo se aborda cada problema y qué métodos se usan; priorizar artículos y fuentes primarias recientes. | Exigencia de fundamento previo y comparación de alternativas. | C01 |
| Usuario | Entender necesidades, deseos, dificultades y experiencias; revisar los tipos de usuario si la evidencia lo requiere. | El público y sus necesidades no quedan fijados solo por una primera descripción. | C01 |
| Trabajo por etapas | Desarrollar una cosa a la vez, cuestionar decisiones y alternar revisión del detalle y del conjunto. | Control de alcance y coherencia entre partes. | C01 |
| Evidencia | Explicitar qué información falta y de dónde provienen las afirmaciones. | Necesidad de distinguir datos, decisiones e interpretaciones. No acredita que todas las verificaciones se hayan realizado. | C01 |
| Escritura académica | APA 7 en español, conceptos explicados al primer uso, sin relleno ni repeticiones; respetar títulos y límites del encargo de examen. | Criterios concretos de edición y estructura. La petición posterior de respetar límites precisa la anterior de no limitar artificialmente la extensión. | C01, C02 |
| Orden narrativo | Seguir el avance de la memoria del primer semestre y no presentar la solución antes de desarrollar el problema. | Rechazo de textos que anticipaban Relevo en la motivación o relataban versiones anteriores dentro del argumento académico. | C02 |
| Lenguaje de producto | Usar palabras habituales, acciones comprensibles y textos con una función. Evitar rótulos genéricos y explicaciones obvias. | Revisión de la interfaz desde lo que una persona necesita entender. | C02, C06; L04, L05 |
| Experiencia | Reducir pasos innecesarios y distribuir la configuración en pantallas para que no abrume; mostrar un resumen antes de activar. | Una decisión sobre secuencia de uso, distinta de un cambio decorativo. | C06 |
| Interacción | Personalizar actividades, iconos y colores; respuestas directas; transiciones suaves y estados comprensibles. | Requisitos concretos de comportamiento. Cada implementación debe comprobarse en su versión. | C06 |
| Calidad visual | Buscar una app cuidada, atractiva y fácil de usar; revisar referencias profesionales y evitar resultados genéricos. | Dirección estética sostenida, acompañada de sucesivas correcciones. | C03–C06; L02–L05 |
| Componentes visuales | Distinguir decoración, iconos y elecciones. Los elementos decorativos no deben interferir con la selección. | Separación de funciones dentro de la interfaz. | C03 |
| Organización | GitHub como registro central, Markdown por área, README explicativos y cambios justificados al final de cada documento. | Continuidad del proyecto entre herramientas y conversaciones. | C01 |
| Delegación | Encargar producción a agentes y reservar revisión y coordinación al proceso principal; ajustar modelos y esfuerzo al presupuesto. | Una modalidad de trabajo solicitada, no prueba de que cada tarea se delegó ni de qué modelo la ejecutó. | C07 |

Las [directrices de trabajo](directrices-de-trabajo.md) recogen buena parte de estos criterios desde agosto. Este documento registra su procedencia y evolución; no las reemplaza.

## 2. Referencias aportadas por el autor

Este es un inventario de referencias **recomendadas o adjuntadas**, no una bibliografía de obras leídas por completo. Los enlaces se conservan para localizar las recomendaciones. En esta recopilación no se auditó el contenido, la licencia ni el funcionamiento de cada sitio. Recomendar un recurso, consultarlo e incorporar algo de él son hechos diferentes.

### Diseño de interacción y referentes de aplicaciones

| Referencia | Para qué la propuso el autor | Evidencia y alcance |
| --- | --- | --- |
| [Laws of UX](https://lawsofux.com/) | Fundamentar decisiones de interacción y facilidad de uso. | C03 y mensaje original L04. El informe de Android 2.9 documenta su consulta y la aplicación declarada de varios principios. |
| Mobbin | Observar aplicaciones y flujos de alto nivel. | C06. Recomendación del autor; este registro no demuestra acceso al catálogo ni revisión completa. |
| [Dribbble: best app design](https://dribbble.com/tags/best-app-design) | Ampliar la exploración visual. | C06. Referente de apariencia; no equivale a evidencia de usabilidad. |
| [Conversación de iOSProgramming sobre apps bien diseñadas](https://www.reddit.com/r/iOSProgramming/comments/1obpqg8/can_you_recommend_apps_with_great_design/) | Encontrar ejemplos sugeridos por otras personas. | C06. Pista de búsqueda, no estudio de evaluación. |
| SwiftUI e iOS 26 / Liquid Glass | Comunicar el nivel de acabado esperado: transiciones, superficies, bordes y desenfoque. | C06; L02–L05. Se pidió esa experiencia visual para Android; no implica que la app se haya construido en SwiftUI. |
| [Amicro](https://amicro.vercel.app/) y [loaders](https://amicro.vercel.app/loaders) | Explorar microinteracciones y animaciones. | C06. También se compartió un enlace al repositorio de Subhan-code; conviene comprobar la URL original antes de citar código o licencia. |

### Lista de componentes y movimiento recuperada de Claude

El mensaje L04 contiene la lista original completa. Las descripciones de esta tabla expresan cómo se presentó cada recurso en ese mensaje, **no capacidades verificadas durante esta tarea**.

| Dirección recomendada | Descripción aportada o propósito de consulta |
| --- | --- |
| `Libraries.dev` | Efectos y animaciones de interfaz. |
| `http://Transitions.dev` | Transiciones y microinteracciones. |
| `http://astryx.atmeta.com` | Componentes React personalizables. |
| `http://beui.dev` | Componentes animados. |
| `http://coss.com/ui` | Componentes React y accesibilidad. |
| `http://originkit.dev` | Componentes interactivos y animaciones. |
| `http://kinetics.colorion.co` | Movimiento basado en física. |
| `http://21st.dev` | Catálogo de componentes. |
| `http://beautifului.dev` | Referencias de interfaz. |
| `https://reactbits.dev/c/micro` | Microinteracciones. |

El [informe de Android 2.9](../06_desarrollo_y_factibilidad/app-android/version-2.9-vidrio-y-emoji-2026-09-27.md) explica qué declara haber tomado de Laws of UX y Transitions.dev. Que un recurso aparezca en la lista no demuestra que se importó su código. En particular, una referencia de componentes web puede orientar el movimiento sin ser una dependencia de la app Android.

### Gráfica, editorial y libros

| Referencia aportada | Uso buscado | Precisión necesaria |
| --- | --- | --- |
| Nothing; [widgets de Figma Community](https://www.figma.com/community/file/1263226487403928191/nothing-widgets-2-0); [artículo de PhoneArena](https://www.phonearena.com/news/did-nothing-ceo-hint-the-phone-3-design-mysterious-new-button-on-the-side_id158706) | Puntos, contraste, módulos y una familia visual reconocible. | Dirección histórica. Después el autor pidió abandonar el estilo Nothing y volver a investigar la marca. No debe recuperarse como criterio vigente por omisión. |
| [36 Days of Type (Numbers)](https://www.behance.net/gallery/26199707/36-Days-of-Type-(Numbers)) | Exploración tipográfica y gráfica de puntos. | Referente histórico compartido en C03. |
| Imágenes adjuntas de Relevo | Conservar ciertos rasgos entre app, piezas editoriales y recursos gráficos; comparar resultados y señalar preferencias. | Son materiales de referencia del proceso. Su selección no demuestra comprensión por parte de usuarios. |
| *The Design of Everyday Things*, Donald Norman | Comprensión del uso y decisiones de diseño. | PDF adjuntado por el autor. Esta recopilación no afirma lectura íntegra ni fija la edición. |
| *Interaction of Color*, Josef Albers | Relaciones cromáticas. | PDF adjuntado; edición por comprobar antes de citarlo académicamente. |
| *Design as Art*, Bruno Munari | Reflexión sobre diseño y objetos. | PDF adjuntado; no confundir recepción del archivo con lectura completa. |
| *Steve Jobs*, Walter Isaacson | Referente de desarrollo de productos y decisiones de diseño. | Dos archivos mencionados; no se asume que sean obras distintas. |
| Libro sobre *Grid systems* | Una retícula común para las páginas de la memoria. | El mensaje no precisa autor ni edición. No atribuirlo automáticamente a Müller-Brockmann sin confirmar el ejemplar. |
| Memoria del primer semestre de Johan; memorias de Emilia Guerra y otros estudiantes | Estudiar estructura, progresión narrativa y presentación editorial. | Referencias de organización, no evidencia sobre la eficacia de Relevo. |

## 3. Las preferencias cambiaron: hay que registrar la secuencia

El historial no debe convertirse en una lista de órdenes simultáneas. Algunas indicaciones sustituyeron a otras; otras pertenecían solo a un entregable.

1. **Primera exploración visual:** el autor seleccionó referencias cercanas a Nothing y solicitó puntos, piezas claras y oscuras, recursos transparentes y continuidad entre soportes. En una etapa acotó la app a oscuro; después volvió a pedir ambas variantes. Son instrucciones de momentos y piezas diferentes (C03).
2. **Exploración editorial:** pidió que la memoria se trabajara como publicación, aproximadamente A3 horizontal, con texto real, una retícula común y menos repetición del motivo origen–vínculo–señal. No equivale a una especificación para pantallas móviles (C04).
3. **Reinicio de la dirección:** pidió dejar atrás Nothing e investigar nuevamente gráfica, interfaces y branding desde las necesidades del proyecto. Ese giro impide tratar los primeros tableros como autoridad permanente (C05).
4. **App y experiencia:** insistió en configuración guiada, personalización, imágenes útiles, animaciones y un acabado cercano a aplicaciones iOS. Rechazó interfaces genéricas y el uso repetitivo de texto sin función (C06).
5. **25 de septiembre, Claude:** rechazó una versión que había perdido fotografías, personalización y pantallas. Solicitó recuperar esa riqueza visual (L03). El registro de Android 2.8 vincula ese pedido con su siguiente iteración.
6. **26 de septiembre, Claude:** precisó vidrio sin brillo, bordes redondeados, emoji, lenguaje natural y referencias concretas de interacción (L04; fecha local de Santiago).
7. **27 de septiembre, Claude:** valoró la interfaz y pidió correcciones específicas: etiquetas claras, sin mayúsculas sostenidas, menor desenfoque, texto adaptado a la fotografía y mejor comprensión de Ruta y Actividades (L05).
8. **27 de septiembre, Claude:** pidió llevar esos cambios al trabajo de marca en Figma (L06). Aquí se registra el pedido, no la terminación ni aprobación del archivo de Figma.

Esta secuencia muestra una revisión sostenida, pero no demuestra que todas las preferencias mejoraran el resultado. Una indicación del autor, una solución implementada y una mejora comprobada con personas deben registrarse por separado.

## 4. Casos que permiten mostrar el aporte humano y el de las herramientas

| Caso | Aporte del autor documentado | Aporte de la herramienta documentado | Qué falta para hablar de mejora comprobada |
| --- | --- | --- | --- |
| Leyes y referentes de interacción | Aporta Laws of UX y una lista de sitios; solicita claridad, movimiento y acabado. L04. | El informe de 2.9 describe cómo tradujo algunas referencias a componentes y navegación. | Evaluar esas interacciones; mencionar una ley no prueba cumplimiento ni usabilidad. |
| Recuperación de imágenes | Rechaza la versión sin fotografías y pide recuperar personalización y pantallas. L03. | El informe de 2.8 registra programación, tratamiento de imágenes y recorrido en emulador. | Comprobar que las fotografías orientan la acción y no solo hacen más atractiva la pantalla. |
| Textos de interfaz | Identifica expresiones concretas que le resultan confusas y rechaza mayúsculas sostenidas. L05. | El informe de 2.10 conserva una tabla de antes y después y las modificaciones de componentes. | Observar comprensión con personas; las frases finales siguen requiriendo revisión contextual. |
| Desenfoque y contraste | Señala que el desenfoque invade el centro y que el texto puede perderse sobre fotos oscuras. L05. | La 2.10 documenta cambios de desenfoque y un cálculo de tono sobre fotografías. | Comprobar legibilidad y fluidez en el teléfono real y en todas las composiciones. |
| Configuración por etapas | Solicita separar la creación de un relevo en varias pantallas y revisar un resumen antes de activar. C06. | Hay versiones sucesivas de la configuración; este documento no audita su implementación completa. | Relacionar el pedido con una versión concreta y observar si la secuencia se comprende. |
| Memoria y narrativa | Exige seguir la estructura del primer semestre, explicar conceptos y no anticipar la solución. C02. | Las auditorías y versiones de la memoria registran reescrituras. | Comparar pasajes y verificar que la revisión mantuvo fuentes, argumento y requisitos. |

Para explicar el proceso ante la comisión conviene seleccionar tres casos y mostrar la secuencia: **problema observado por el autor → instrucción → propuesta de la herramienta → corrección → versión registrada → comprobación pendiente o realizada**. No se necesita exponer conversaciones enteras.

## 5. Qué se puede afirmar y qué no

- Se puede afirmar que hubo instrucciones persistentes, referencias aportadas, rechazo de propuestas y correcciones humanas concretas. Los mensajes L04 y L05 lo muestran directamente.
- Se puede afirmar que las herramientas produjeron código, alternativas gráficas, textos y propuestas de detalle, según los registros de versiones y la trazabilidad existente. No corresponde reducir su aporte a transcribir órdenes.
- La autoría de una decisión concreta requiere rastrear su origen. Que el autor aprobara el resultado no demuestra que haya formulado personalmente cada solución técnica o cada texto.
- Los resúmenes automáticos y los archivos de memoria de Claude ayudan a localizar temas, pero no son mensajes originales del autor. Sus interpretaciones se deben identificar como tales.
- No se midieron en esta recopilación horas ahorradas, porcentajes de trabajo humano ni superioridad frente a un proceso sin IA.
- Las entrevistas reales, las pruebas con personas y la valoración de resultados son fuentes diferentes de las imágenes, el código o los datos de prueba de un emulador.
- Este documento reúne dirección de diseño y referencias. No pretende inventariar todos los mensajes de las conversaciones ni convertir instrucciones históricas descartadas en reglas actuales.

## 6. Próxima incorporación posible a la memoria

El contenido puede alimentar un apartado de proceso titulado **Desarrollo del prototipo con herramientas de IA**. Su centro sería el caso Relevo: qué se delegó, qué decisiones tomó el autor y cómo se revisaron las propuestas. La evolución general de las herramientas requiere una investigación bibliográfica aparte; estos mensajes solo prueban lo ocurrido y registrado en este proyecto.

La incorporación a la memoria no se realizó en esta tarea. Primero conviene seleccionar los casos, reunir sus imágenes de antes y después y revisarlos con el autor y los profesores guía.

## Fuentes internas

- [Mensajes y procedencia de esta recopilación](fuentes-direccion-del-autor-2026-09-27.md).
- [Directrices de trabajo](directrices-de-trabajo.md).
- [Trazabilidad del uso de IA](trazabilidad-uso-ia-2026-09-23.md).
- [Registro de decisiones, especialmente D-073 y D-082 a D-084](../09_decisiones/registro-de-decisiones.md).
- [Android 2.8: rediseño, perfil y ruta](../06_desarrollo_y_factibilidad/app-android/version-2.8-rediseno-perfil-y-ruta-2026-09-26.md).
- [Android 2.9: vidrio y emoji](../06_desarrollo_y_factibilidad/app-android/version-2.9-vidrio-y-emoji-2026-09-27.md).
- [Android 2.10: participación y claridad](../06_desarrollo_y_factibilidad/app-android/version-2.10-participacion-y-claridad-2026-09-27.md).

## Registro de cambios (disclaimer)

### 2026-09-27 — Recopilación de la dirección del autor

- **Qué se añadió:** criterios de investigación, escritura, diseño y colaboración; catálogo de referencias; evolución de preferencias y seis casos para estudiar el proceso con IA.
- **Cómo estaba antes:** existían directrices, registros por versión y una trazabilidad de IA; faltaba una lectura conjunta centrada en las recomendaciones y correcciones del autor, incluida su lista original de referencias en Claude.
- **Por qué:** el autor pidió recuperar cómo fue orientando a las herramientas, a partir de la conversación con sus profesores sobre wireframes, IA y trabajo humano.
- **Límite:** recopilación parcial con fuentes diferenciadas. No modifica el producto, los protocolos, la memoria ni la identidad vigente; tampoco incorpora transcripciones completas de las sesiones.
