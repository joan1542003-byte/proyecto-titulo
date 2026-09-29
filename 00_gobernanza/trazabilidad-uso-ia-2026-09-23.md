# Trazabilidad del uso de IA en la investigación y el diseño de Relevo

**Estado:** reconstrucción documental parcial y formato de registro para las siguientes iteraciones. **Fecha de corte:** 23 de septiembre de 2026, revisión `fe416ca`. No se reconstruyen conversaciones completas que no estén conservadas en el repositorio.

## Texto utilizable en la memoria o en la defensa

«Durante el desarrollo de Relevo utilicé herramientas de IA generativa como apoyo para explorar composiciones visuales, redactar variantes, revisar consistencia entre documentos y organizar información. La herramienta recibió contexto explícito: la memoria, las entrevistas anonimizadas, los criterios de autonomía, los recorridos y las restricciones del objeto. Sus salidas fueron propuestas sometidas a selección, corrección o descarte. La definición del problema, las entrevistas y repreguntas, la elección de criterios, la selección de variantes y la responsabilidad por citas y conclusiones corresponden al autor. Las imágenes generadas se identifican como visualizaciones conceptuales, nunca como fotografías de un prototipo o evidencia de uso. Donde no se conserva el prompt literal, registro una síntesis y no finjo una transcripción».

Esta formulación se apoya en la [declaración histórica de IA de la memoria v1](../99_archivo/antiguo/memoria/memoria-v1.md#anexo-e-declaración-de-uso-de-inteligencia-artificial), la [procedencia de imágenes conceptuales](../99_archivo/fuentes-locales/semestre-2/proceso/visualizacion-y-entrega/procedencia-imagenes-conceptuales.md) y los [registros de producción de wireframes](../05_propuesta_phygital/wireframes-referencia-4k/registro-laminas-07-14.md). Para la memoria vigente, debe revisarse de nuevo contra el proceso realmente ejecutado hasta la entrega; este texto no demuestra por sí solo cada interacción con una herramienta.

## Cómo cambió el proceso de diseño

| Etapa documentada | Aporte de IA registrado | Control y decisión humana documentados | Límite de la evidencia |
| --- | --- | --- | --- |
| Imágenes conceptuales del 17 de agosto | Generación de siete visualizaciones para explicar objeto, contexto y flujos; el archivo histórico conserva propósito y síntesis de prompt por imagen. | El autor las incorporó como apoyo de comunicación y las distinguió de mapas vectoriales y prototipo construido. | No hay en esa ficha un prompt literal por cada imagen ni pruebas con personas. |
| Referencias visuales de estados 07–14 y 15–24 | Prompt base, restricciones, copias específicas y variantes raster para discutir y reconstruir en Figma. | Se descartaron salidas con forma inconsistente o conectores fuera de marco; se corrigió un botón que decía «Desarmar» antes de armar. | Son referencias de baja/media fidelidad, no interfaz final ni validación. |
| Investigación y redacción | Los archivos históricos declaran apoyo en búsqueda dirigida, consistencia y corrección editorial. | La memoria vigente, perfiles situacionales y criterios deben conservar evidencia, procedencia y revisión del autor. | No hay registro exhaustivo de prompts y respuestas de todas las conversaciones. No cuantificar horas ahorradas ni atribuir mejoras causales sin datos. |
| Revisión documental del 23 de septiembre | La petición inicial fue revisar el repositorio y desarrollar la parte escrita de las anotaciones. La IA ordenó notas, contrastó documentación y fuentes y redactó borradores. | Las anotaciones y el alcance son del autor; la primera iteración no implementó la app. | Ningún texto de esa fase aporta resultados con participantes. |
| Revisión de Android 2.5 del 23 de septiembre | El autor pidió aplicar el feedback a la app, con reconocimiento positivo sin culpa. Un agente revisó el repositorio y modificó tutorial, navegación, progreso y mensaje de Inicio; el agente principal auditó el código, corrigió la continuidad del código de participación, el consentimiento, el tiempo máximo y la documentación. | El autor fijó el criterio de tono y el correo y plazo de datos; las correcciones se seleccionaron por relación con el flujo real, no por aceptación automática de todas las notas. | La compilación y un recorrido parcial en emulador no sustituyen pruebas con personas, audio físico ni verificación de borrado. |
| Android 2.8 del 25 y 26 de septiembre | Claude Code programó el rediseño con D-073, el perfil, la ruta y el regreso; trató con la receta de D-073 las fotografías generadas antes y seis CC0; compiló, probó en emulador con datos ficticios y documentó. No generó imágenes nuevas. | El autor rechazó una primera versión sin fotos y fijó el objetivo: D-073, fotografías, más personalización y las pantallas que faltaban. Las decisiones de detalle quedan en D-082 para su revisión. | Compilación, 47 pruebas unitarias y recorrido en emulador; sin teléfono real ni personas. |
| Android 2.9 del 27 de septiembre | Claude Code revisó referentes (pautas de Liquid Glass de Apple, Laws of UX, transitions.dev) y la disponibilidad y licencia de los emoji Noto 3D de Google; programó el vidrio, las formas en cápsula, las hojas flotantes, el selector de emoji y los textos nuevos; probó en emulador y documentó. Los emoji son de Google, no se generaron. | El autor fijó el objetivo: pantalla completa, desenfoques sutiles sin brillo, bordes redondeados, solo iconos o emoji en el perfil, textos naturales y sin avisos de privacidad repetidos. Registrado como D-083. | Compilación, 50 pruebas unitarias y recorrido en emulador; sin teléfono real ni personas. |
| Android 2.10 del 27 de septiembre | Claude Code reescribió los textos de todas las pantallas, quitó el uso sin participar, programó el tono del texto según cada foto con la luminancia de WCAG 2.2, sumó 60 emoji de Google, rediseñó «Tu ruta» y «Tus actividades», probó en emulador sin red y documentó. Los emoji son de Google, no se generaron. | El autor pidió participación obligatoria, textos claros, ninguna mayúscula sostenida, menos desenfoque, texto según la foto, más emoji y una ruta y unas actividades más claras. Registrado como D-084. | Compilación, 58 pruebas unitarias y recorrido en emulador; sin teléfono real ni personas. |
| Marca 2.0 en Figma del 27 de septiembre | Claude Code, con el conector oficial de Figma, construyó el archivo: variables, estilos, 97 iconos y 18 componentes a partir del código de 2.10 y de D-073; subió desde el repositorio emoji, imágenes y capturas; calculó el tono de las imágenes; compuso las páginas, afiches y diapositivas, y documentó. No generó imágenes. | El autor pidió llevar el diseño nuevo de la app a la marca en Figma, con vidrio líquido, iconos, emoji y tratamiento de imagen. Registrado como propuesta D-085, pendiente de su aprobación. | Revisión visual con capturas del archivo; sin revisión del autor ni pruebas con personas. |
| Guion de la corrección cruzada del 27 de septiembre | Claude Code leyó en Figma las anotaciones que el autor dejó en cada diapositiva y reescribió el guion: dato que introduce el problema, marco teórico, mapa de referentes en dos ejes, porqué de cada criterio, guion del GIF de la app, prueba contada en tres momentos, carta Gantt explicada y más preguntas probables. Corrigió datos vencidos (seis personas y app 2.6). | El autor revisó su presentación en Figma y anotó qué cambiar en cada diapositiva. Las frases, los datos elegidos y la diapositiva nueva de marco teórico son propuestas de la herramienta, pendientes de su revisión. | Sin ensayo ni revisión del autor. La encuesta de Google Forms no se incorporó porque sus materiales no están en el repositorio. |
| GIF de la app 2.10 del 27 de septiembre | Claude Code respaldó los datos del autor en el emulador, preparó sin red un relevo ficticio («Leer 10 páginas»), grabó la pantalla con adb, unió dos tomas con ffmpeg, restauró los datos y documentó. | El autor pidió el GIF para la diapositiva «Cómo funciona». | Es una recreación en emulador: la señal viene de un relevo de prueba de 15 s y suena en el teléfono porque no hay parlante. |
| Android 2.11 del 28 de septiembre | Claude Code revisó el registro y el envío de datos de la 2.10 y la base de Supabase; encontró que las respuestas nunca habían llegado a la base. Programó «Cómo funciona», adaptó el video a vertical, agregó la copia en el teléfono y dos columnas, aplicó en Supabase la migración y las vistas de análisis, probó en emulador con conexión y sin ella, borró los datos de prueba y documentó. | El autor pidió revisar la app, dejarla lista para el primer testeo, explicar su uso la primera vez, incluir el video en vertical y guardar todo en la base y en el teléfono. Registrado como D-086; los textos, el formato de la copia y las vistas son propuestas de la herramienta. | Sin teléfono real, parlante Bluetooth ni personas. |
| Diapositivas e hipótesis, 29 de septiembre | Claude Code diseñó en Figma las diapositivas de la corrección cruzada en dos variantes y las rehízo con el estilo del autor. Después leyó la memoria, las decisiones y el protocolo 02, propuso tres hipótesis y actualizó la elegida en todo el proyecto. | El autor pidió su estilo de diseño y una hipótesis más simple, que dijera en qué se basa la app y no su resultado: «La hipótesis no debe ser el resultado de la app, debe ser en lo que la app se basa». Eligió primero una versión en dos frases; luego señaló que «eso no es una hipótesis», pidió mirar las anteriores y eligió una formulación «si…, entonces…» (D-091). | La hipótesis sigue sin contrastarse. Las notas del orador de las diapositivas no se revisaron con el autor. |
| Android 2.14 y registro de pedidos, 29 de septiembre | Claude Code reescribió las frases poco naturales, agrandó el video, rehízo la guía con contexto y el primer relevo acompañado, corrigió el defecto de la 2.10, probó en emulador y creó el registro de pedidos del autor. | El autor pidió frases más naturales, un video más grande, una guía con contexto que deje hacer el primer relevo, la app lista para el testeo real y la auditoría de sus pedidos. Registrado como D-090. | Sin teléfono real ni personas. |
| Android 2.13 y coherencia con la memoria, 29 de septiembre | Claude Code leyó la memoria (secciones 6, 7, 9, 10 y 11) y el corpus P1–P8; señaló dos contradicciones (el nombre en la base y el aviso semanal encendido) y preguntó al autor; programó la guía, los intereses de las entrevistas, la tabla aparte del nombre, el resumen del relevo activo y el registro de la guía; rehízo el audio del video; probó en emulador y escribió la revisión de coherencia. | El autor pidió actividades concretas, guardar el nombre, una guía de cada cosa, revisar el audio, un resumen en Inicio y avisarle de toda contradicción con la memoria. Decidió guardar el nombre y preguntar por el aviso semanal. Registrado como D-088 y D-089. | Sin teléfono real ni personas; la memoria aún no se actualiza. |
| Android 2.12 y lista de actividades, noche del 28 de septiembre | Claude Code reescribió los textos para quitar el lenguaje de prueba, programó el pedido de notificaciones, el código corto, el modo claro, el registro del uso de la app, la reacción y la opinión rápida con caras de Google; creó la tabla y las vistas en Supabase; probó en emulador con conexión y borró los datos de prueba. También propuso 31 actividades con sus escenas y una plantilla de prompt. No generó imágenes. | El autor pidió una app más simple que no se sienta como un testeo, la mayor cantidad de datos, notificaciones y modo claro por defecto, un código más simple y una lista de actividades para generar él las imágenes. Registrado como D-087; los textos, los usos registrados y las actividades son propuestas de la herramienta. | Sin teléfono real ni personas; el consentimiento v8 no está revisado. |
| Video «Relevo en 30 segundos» del 28 de septiembre | Claude Code escribió el guion visual, animó la pieza en HTML con la marca 2.0, la renderizó cuadro a cuadro con Chrome sin ventana y sintetizó la banda sonora por código, con la firma sonora de D-071; después la alargó a 30 s. Solo usa fotos CC0, no imágenes generadas. | El autor pidió el video de 15 s en español, lo aprobó y pidió alargarlo a 30 s sin textos que no aporten, como «Proyecto de título». | La pantalla de la señal es una recreación animada; «1:47 h» es un ejemplo; nadie fuera del autor lo ha visto. |

Lo que puede sostenerse documentalmente es que la IA permitió **producir variantes y dejar rastros de descarte y corrección**. El repositorio no mide ahorro de tiempo ni permite afirmar que la IA mejoró la calidad de uso de Relevo: eso exigiría comparación y observación con personas. La responsabilidad académica tampoco se transfiere a la herramienta por haber escrito un borrador.

## Registro de prompts existentes

| Pieza | Prompt conservado | Uso, fin y resultado | Decisión atribuible |
| --- | --- | --- | --- |
| [Estados 07–14](../05_propuesta_phygital/wireframes-referencia-4k/registro-laminas-07-14.md#prompt-base-común) | Base redactada en español, más instrucciones específicas por lámina; algunas solicitudes están resumidas. | Producir láminas trazables para Figma; B2a y B2b se corrigieron tras auditoría. | El registro documenta selección y descarte de salidas; no atribuir a IA la aprobación final. |
| [Estados 15–24](../05_propuesta_phygital/wireframes-referencia-4k/registro-laminas-15-24.md#prompt-común) | Prompt base literal en inglés y especificaciones de C1, C2, D1 y D2. | Visualizar armado, espera, señal y respuestas; D1 recibió corrección focalizada. | La cobertura y las restricciones proceden de memoria y contrato visual; la generación ejecutó una propuesta. |
| [Imágenes conceptuales históricas](../99_archivo/fuentes-locales/semestre-2/proceso/visualizacion-y-entrega/procedencia-imagenes-conceptuales.md#contenido-migrado) | Síntesis por imagen; no prompt literal íntegro. | Ilustrar contextos y arquitectura del Encargo 16. | No reutilizar forma, paleta o funciones antiguas como dirección actual sin contraste con el [sistema de marca vigente](../10_recursos_visuales/14_sistema-de-marca-vigente.md). |

El prompt original de las siete fotografías de actividades predefinidas del prototipo Android 2.3 **no se localizó** en los documentos vigentes consultados. Su apariencia no permite reconstruirlo fielmente. Antes de generar nuevas imágenes, buscar el registro original fuera del repositorio o documentar la nueva instrucción como una iteración distinta, con su fecha, herramienta y resultado.

## Ficha obligatoria para futuras producciones con IA

Copiar una ficha por tarea o conjunto de variantes. Conservar el prompt literal cuando exista. Si solo se dispone de una reconstrucción, marcarla como **síntesis posterior**.

```text
ID, fecha y autor responsable:
Fase y pregunta de diseño:
Herramienta/modelo (si se conoce):
Tipo de uso: búsqueda / análisis / redacción / imagen / código / auditoría
Fuentes entregadas: archivo, versión, enlace y restricciones de privacidad
Prompt literal (o «síntesis posterior», nunca entrecomillada como original):
Resultado recibido: archivo/enlace, variantes y fecha
Revisión humana: fuentes comprobadas, errores, exclusiones, licencias, accesibilidad
Decisión del autor: adoptar / editar / descartar y motivo
Efecto en Relevo: documento/artefacto modificado y prueba pendiente
Límite: qué no demuestra la salida
```

No introducir transcripciones identificables de P1–P8, hojas firmadas, claves ni datos remotos en un prompt sin base de tratamiento, autorización y necesidad documentadas. Para explicar la evolución ante la comisión, mostrar un ejemplo **antes → prompt y contexto → salida → corrección humana → versión incorporada**, con el archivo del prompt y la decisión verificables. Los registros de B2a/B2b y D1 ofrecen ejemplos reales de esa secuencia.

## Registro de esta tarea

- **Entrada del autor:** lista de anotaciones del 23 de septiembre y corrección posterior que fijó `proyecto-titulo` de GitHub como único repositorio de contexto.
- **Contexto consultado:** `README.md`, directrices, memoria v4, perfiles P1–P8, requisitos, estado de Android 2.3, consentimiento, datos, diseño y registros de prompts. También se contrastaron fuentes primarias de ley, plataforma y estudios de hábitos.
- **Resultado de la primera revisión:** [síntesis de las anotaciones](../02_investigacion/sintesis-anotaciones-2026-09-23.md), [auditoría de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) y esta trazabilidad.
- **Decisión no atribuida a la herramienta:** adoptar rachas, ampliar el piloto o cambiar la arquitectura del producto; esas opciones permanecen abiertas o incompatibles con criterios vigentes.

## Registro de la iteración Android 2.5

- **Pedido literal del autor:** «Este es el feedback de hoy, aplícalo a la app. [...] rachas quizás no pero sí felicitar al usuario, sin sentir culpa». La lista completa se consultó en el texto pegado en la conversación; su contenido se ordenó en la [síntesis de feedback](../02_investigacion/sintesis-anotaciones-2026-09-23.md).
- **Contexto entregado al agente:** repositorio, notas docentes y archivos de la app. La primera instrucción operativa se conserva solo como síntesis en este registro: corregir el regreso por pasos, tutorial, permiso, legibilidad, navegación y reconocimiento ligado a la respuesta voluntaria; no añadir perfiles, rachas ni datos nuevos. No se presenta como prompt literal íntegro.
- **Corrección literal enviada durante la revisión:** «Revisé el diff preliminar: en FloatingTabBar cambiaste Row a Column pero quedó `verticalAlignment = Alignment.CenterVertically` (parámetro de Row), probablemente no compila; corrígelo en tu build. También verifica que el gesto atrás no cierre la actividad desde página 0 de tutorial y que la confirmación de consentimiento muestre correo/fecha completos. Gracias».
- **Resultado comprobable:** [interfaz y lógica en Android 2.5](../06_desarrollo_y_factibilidad/app-android/README.md). Pasaron siete pruebas unitarias y la compilación; se inspeccionaron consentimiento y tutorial en emulador. El agente principal detectó y corrigió un código de participación que cambiaba al cerrar cada ciclo y un permiso que podía omitirse desde el tutorial.
- **Decisiones del autor:** reconocer sin culpa una respuesta voluntaria; no convertirla en éxito observado ni usar rachas. El autor confirmó `joan1542003@gmail.com` y el 30 de diciembre de 2026 como datos para el borrador de privacidad.
- **Lo que no se afirma:** que la IA probó la experiencia de uso, que la actividad ocurrió realmente, que el borrado remoto funciona o que la ruta de audio fue comprobada con el equipo final.

## Registro de la iteración Android 2.8

- **Fecha y herramienta:** 25 y 26 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5.
- **Pedidos literales del autor:** «quitaria la de agendar una reunion/entrevista. [...] el diseño es muy mejorable, quiero algo al nivel swift ui. ademas, hay nuevas diretrices de diseño, leelas»; después de ver una primera versión sin fotografías: «visualkmente era mejor antes, tenia imagenes, era mejor diseñado ,estilo ios16 / 26. Tenia imagenes, era mas personalizable, faltaban mas pantallas. por favor hazlo bien»; y por último: «debes ajustarlo al nuevo directrices de diseño que hicimos, lee le reposotorio. [...] debe estar a lla altura de las mejores aplicaicones del mercado. bue ndiseñlo, interacciones, animaciones.»
- **Contexto usado:** el repositorio (D-073 y su kit, el diseño escrito de flujos, el protocolo 02 y la app 2.7). No se entregaron datos de participantes.
- **Qué hizo la herramienta:** programó la app 2.8 (tema, componentes, navegación y animaciones; pantallas de perfil, ruta, regreso y ajustes; uso sin participar y descarga de datos), trató las imágenes existentes con la receta de D-073, escribió pruebas unitarias, recorrió la app en un emulador con datos ficticios, borró de Supabase las sesiones de prueba y redactó la documentación.
- **Decisiones del autor:** aplicar D-073 a la app, recuperar las fotografías, permitir más personalización, completar las pantallas y retirar la pregunta sobre la entrevista. Las decisiones de detalle que tomó la herramienta están en D-082, pendientes de su revisión.
- **Lo que no se afirma:** que la app funcione en el teléfono y el parlante de la prueba, ni que la nueva interfaz se entienda mejor o se prefiera: no hubo pruebas con personas.

## Registro de la iteración Android 2.9

- **Fecha y herramienta:** 26 y 27 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5.
- **Pedido literal del autor (fragmentos):** «"Solo lo ves tu, no sale del telefono" no creo necesari oestar diciendole constantemente al usaurio que su info es privada [...] el diseño es mejorahble, aun mas moderno, con blur, pantalla completa. Bordes redondeados, algo al estilo de iOS 26 sin recurrir a "brillo" sino a esas trasnaprencias hermosas y con desenfoques sutiles. Las fotos del eprfil del usaurio deberian ser solo iconos, puedes crear iconos, o emojis (google lanzo recientemente emojsi en3d que podrian servirnos) [...] Debe estar perfectamente diseñado, ser hermoso, pero facil de usar, sin sobrediseñar ni sobre explicar. perfecciona la interfaz de cada pantalla. y nada de bloques cuadrados.»
- **Fuentes consultadas por la herramienta:** Laws of UX, transitions.dev y React Bits, que el autor recomendó; videos y resúmenes de Liquid Glass de Apple; el blog de Google y el repositorio googlefonts/noto-emoji, para confirmar la publicación de los emoji 3D y su licencia.
- **Qué hizo la herramienta:** programó el vidrio de la capa de navegación con Haze, el marco de pantalla a sangre, la barra de pestañas flotante, las hojas de vidrio, los controles en cápsula, las marcas redondas, el catálogo de 24 emoji con equivalencias para las imágenes antiguas y los textos nuevos; escribió una prueba unitaria; recorrió la app en emulador, respaldando y restaurando los datos de prueba del autor; borró de Supabase la sesión de prueba, y documentó la versión.
- **Decisiones del autor:** las de D-083. La selección concreta de emoji y los textos nuevos son propuestas de la herramienta, pendientes de su revisión.
- **Lo que no se afirma:** que la nueva interfaz se entienda mejor o se prefiera, ni que el desenfoque sea fluido en el teléfono de la prueba.

## Registro de la iteración Android 2.10

- **Fecha y herramienta:** 27 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5.
- **Pedido literal del autor (fragmentos):** «"empiezas" Ponerte las zapatillas "Lugar" Junto a la puerta "marcas omo pas oactual" hay muchos textos ,redacciones que pueden ellegar a ser confusa pra el osuuario o tener un lenguaje que n ose usa mucho. soluciona eso. Por cierto, la tipogradfia que ve oe "estas aqui" no me agrada, parece un poco mono [...] no uses nunca ALL CAPS. en esta version el usuario aprticipa en la prueba SI O SI. no hay opcion de no hacerlo. [...] siento que el desenfoque progresivo empieza demasiado antes [...] reduciria el nivel de blur de los botones, un poco mas. No se si hay un sistema que detecte si un fondo de imagen es blanco, de forma que e ltetxo sea negro, y viceversa. [...] Agrega mas emojis de google 3d al perfil del usuario. la seccion de "tu ruta" es mejorable, debe ser mas clara, intutiiva. la de tus actividades tambien debe ser mas clara, cuesta entenderla.» El autor también escribió que la interfaz de la 2.9 le parecía «preciosa».
- **Fuentes consultadas por la herramienta:** WCAG 2.2, para la luminancia relativa y el contraste; el repositorio googlefonts/noto-emoji, para confirmar qué emoji 3D existen; la presentación de Liquid Glass de Apple, sobre el vidrio que pasa de claro a oscuro según lo que tiene detrás.
- **Qué hizo la herramienta:** reescribió los textos con un vocabulario fijo; quitó el uso sin participar y dejó la salida de la prueba en «Borrar mis datos»; cambió los rótulos a frases sin mayúsculas; redujo el desenfoque; programó el tono del texto y de la barra de estado según cada foto; eligió y sumó 60 emoji; rediseñó la ruta y las actividades; escribió ocho pruebas unitarias; recorrió la app en emulador sin red, respaldando y restaurando los datos del emulador, y documentó la versión.
- **Decisiones del autor:** las de D-084. La elección concreta de los emoji, el umbral del tono y los textos nuevos son propuestas de la herramienta, pendientes de su revisión.
- **Lo que no se afirma:** que los textos nuevos se entiendan mejor, que el tono elegido sea siempre el más legible ni que exigir la participación esté aprobado desde el punto de vista ético.

## Registro del sistema de marca 2.0 en Figma

- **Fecha y herramienta:** 27 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5 y el conector oficial de Figma, con la cuenta del autor.
- **Pedido literal del autor:** «y si usas mcp cpn figma, para ayudarme en el proyecto de Relevo Diseño de marca La idea es desarrollarlo lo mejor posible, considerando todo, actualizandolo para que tambien sea acorde al diseño nuevo de la app. Me encnataria usar el vidrio liqduifo, o cosas asi, ya sabes, creo que podemos hacer un buen diseño. Iocnos, emojis, tratameint ode iamgne, etc.»
- **Fuentes usadas:** el código de Android 2.10 (tema, vidrio, tono y componentes), el manual D-073, los iconos y el logotipo en SVG, la receta de imagen, las capturas de 2.10 y los registros de licencias. No se consultaron fuentes externas nuevas.
- **Qué hizo la herramienta:** creó el archivo en el equipo de Figma del autor; definió variables y estilos; convirtió los 97 iconos y el logotipo en componentes; subió 84 emoji, 24 imágenes y 33 capturas; calculó con la fórmula de la app el tono de las 21 imágenes; diseñó los componentes, las once páginas, los afiches, las diapositivas, la tarjeta del objeto y la propuesta de ícono de vidrio; revisó cada página con capturas, corrigió errores de composición y el origen declarado de las imágenes, exportó doce vistas y documentó.
- **Decisiones del autor:** pedir el sistema en Figma y sus temas (vidrio líquido, iconos, emoji, tratamiento de imagen). Las decisiones de detalle (niveles de vidrio de marca, reglas nuevas, composición de las piezas, ícono de vidrio) son propuestas de la herramienta en D-085, pendientes de su revisión.
- **Lo que no se afirma:** que el sistema esté aprobado, que el ícono de vidrio se reconozca ni que las piezas se entiendan mejor que las de D-073.

## Registro del guion, el GIF y el video

- **Fechas y herramienta:** 27 y 28 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5. Para el guion se usó el conector de Figma solo para leer; para el GIF, el emulador Android, adb y ffmpeg; para el video, HTML, Chrome sin ventana, Node.js y ffmpeg.
- **Pedidos literales del autor:** para el guion, «basicamente deje anotaciones en cada slide, relacioandas a la paresentaicon del miercoles [...] necesitro que leas esas naotaciones ay ctualices el contenido del .md que tien eel texto de las slides»; para el GIF, «grava el gif»; para el video, «make a dynamic 15-second motion graphics video [...] the v ideo shows what is relevo, in spanish.» y luego «hazla de 30 segundos. esta muy buena, evita poner textos que no aporten como "Proyectro de titulo"».
- **Fuentes usadas:** las anotaciones del autor en la presentación de Figma, la memoria y los documentos vigentes del repositorio, la app 2.10 y la marca 2.0. No se consultaron fuentes externas nuevas.
- **Qué hizo la herramienta:** reescribió el guion en 13 diapositivas con instrucciones para Figma; grabó y montó el GIF sin red y sin datos personales, restaurando después los datos del emulador; diseñó, animó y sonorizó el video y lo documentó con su guion por segundos y sus fuentes.
- **Decisiones del autor:** qué cambiar en cada diapositiva, pedir el GIF y el video, aprobar la primera versión del video y quitar los textos de relleno. Las frases, el orden de las escenas, la música y el ritmo son propuestas de la herramienta.
- **Lo que no se afirma:** que la presentación esté ensayada, que el GIF muestre una señal real del objeto ni que el video se entienda sin explicación; ninguna pieza se ha mostrado a otras personas.

## Registro de la iteración Android 2.11

- **Fecha y herramienta:** 28 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5, el emulador Android, adb, el conector de Supabase (consultas, una migración y el revisor de seguridad), Chrome sin ventana y ffmpeg.
- **Pedido literal del autor:** «no se que tal esta la ultima version de la app, revisala, dejala lista para el primer testeo real. por ahora la opcion de parlante o telefono se mantiene. Necesitamos que se xplique bien y facil en la primera vez que la spersoan entra, como usar la app. podrias agregar e lvideo incluso, el ultimo que hiciste, pero habri que ajustarlo a vertical. y es importante que TODO se guarde de verdad en nuyestra abse de datos y en el telefono localmente, para tener copia de resultados y estadisticas.»
- **Fuentes usadas:** el código de la 2.10, el esquema y las filas de Supabase, el consentimiento vigente y el video de 30 segundos. No se consultaron fuentes externas nuevas.
- **Qué hizo la herramienta:** revisó el esquema y el envío; programó la pantalla «Cómo funciona» con el video; rehízo el video en vertical; agregó la salida real y la versión a cada relevo y la copia en Documentos/Relevo; actualizó el consentimiento a v7; aplicó la migración y las vistas en Supabase; probó con conexión, sin conexión, el borrado y la actualización desde 2.10; borró los datos de prueba, dejó Supabase con las filas previas, restauró los datos del emulador y documentó.
- **Decisiones del autor:** las de D-086. El texto de los pasos, que el video empiece sin sonido, el formato de la copia, las vistas y el cambio de versión del consentimiento son propuestas de la herramienta, pendientes de su revisión.
- **Lo que no se afirma:** que la explicación se entienda sin ayuda, que la copia funcione en el teléfono de la prueba ni que el consentimiento v7 esté aprobado por el profesor guía.

## Registro de la iteración Android 2.12

- **Fecha y herramienta:** noche del 28 al 29 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5, el emulador Android, adb y el conector de Supabase. Se descargaron cuatro emoji del repositorio oficial googlefonts/noto-emoji.
- **Pedido literal del autor:** «EVITA COMPLEJIZARL OAPRA EL USUARIO, no deberia sentrirse como un testeo, y por favor revisa que se registre todo en nuestar abse de datos. debemos tener la mayro cantidad de datos posibles y asegruarnos que el usuario nos de el mejro feedback de manera facil. seria muy pero muy util que tambien por dfeefecto todas las notifiaciones esten encendidas. y el codig ode usaurio es algo complejo no? deberia ser mas simple. por defecto la app en modo claro. recuerda debe ser lo mas facil posible para el usaurio, sin complejizar ni usar paalbras dificiles. tambie npodrias darme una serie de actividsades predefinidas, considerando el rango de usaurios, que tenemos, para geenrar yo imagenes para esas activcidades»
- **Fuentes usadas:** los textos de la app, el corpus P1–P8 (para ver qué actividades aparecen), el protocolo 02 (rango de 18 a 30 años), la fotografía de D-073 y la base de Supabase.
- **Qué hizo la herramienta:** lo descrito en la fila de la tabla y en [Android 2.12](../06_desarrollo_y_factibilidad/app-android/version-2.12-mas-simple-y-mas-datos-2026-09-29.md) y la [lista de actividades](../10_recursos_visuales/23_actividades-e-imagenes-2026-09-29.md).
- **Decisiones del autor:** las de D-087. Los textos concretos, los usos que se registran, el momento de la opinión rápida y las actividades sumadas sin base en las entrevistas son propuestas de la herramienta.
- **Lo que no se afirma:** que la app se sienta menos como un testeo para las personas, que el registro de uso sea aceptable éticamente sin revisión, ni que las actividades nuevas representen a los usuarios.

## Registro de la iteración Android 2.13

- **Fecha y herramienta:** 29 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5, el emulador Android, adb, el conector de Supabase y ffmpeg.
- **Pedido literal del autor:** citado en [Android 2.13](../06_desarrollo_y_factibilidad/app-android/version-2.13-guia-intereses-y-nombre-2026-09-29.md), junto con sus respuestas sobre el nombre y el aviso semanal.
- **Fuentes usadas:** la memoria v4, el corpus P1–P8 (Q1, Q2 y Q12), el registro de decisiones (D-076 y D-087), la ficha de privacidad y la base de Supabase.
- **Qué hizo la herramienta:** detectó las contradicciones y preguntó antes de programar; implementó y probó los cambios; dejó intactos los datos del emulador que no eran de sus pruebas; escribió la [revisión de coherencia](../08_memoria/coherencia-app-con-la-memoria-2026-09-29.md).
- **Decisiones del autor:** guardar el nombre (D-089) y preguntar por el aviso semanal; el resto de D-088 responde a sus pedidos. Los textos de la guía, los pasos de cada ruta y qué resume Inicio son propuestas de la herramienta.
- **Lo que no se afirma:** que la guía se entienda o no pese, que la causa del pitido sea la que se corrigió, ni que guardar el nombre esté aprobado éticamente.

## Registro de cambios (disclaimer)

### 2026-09-29 — Diapositivas e hipótesis

- **Qué cambió:** se añadió la fila de las diapositivas en Figma y de la hipótesis nueva (D-091).
- **Cómo estaba antes:** la tabla llegaba hasta Android 2.14.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-29 — Android 2.14 y registro de pedidos

- **Qué cambió:** se añadió la fila de Android 2.14 y se remite al nuevo [registro de pedidos](registro-de-pedidos-a-la-ia.md).
- **Cómo estaba antes:** la tabla llegaba hasta Android 2.13.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-29 — Iteración Android 2.13

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.13 y de la revisión de coherencia.
- **Cómo estaba antes:** el registro llegaba hasta Android 2.12.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-29 — Iteración Android 2.12

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.12 y de la lista de actividades, con el pedido literal del autor.
- **Cómo estaba antes:** el registro llegaba hasta Android 2.11.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-28 — Iteración Android 2.11

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.11, con el pedido literal del autor.
- **Cómo estaba antes:** el registro llegaba hasta el guion, el GIF y el video.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-28 — Guion, GIF y video

- **Qué cambió:** se añadieron filas para el GIF y el video y un registro común del guion, el GIF y el video, con los pedidos literales del autor.
- **Cómo estaba antes:** la tabla tenía la fila del guion, pero no había registro de este ni filas para el GIF y el video.
- **Por qué:** el autor pidió documentar todo lo hecho y cómo se usó la IA.

### 2026-09-27 — Guion de la corrección cruzada

- **Qué cambió:** se añadió una fila sobre la reescritura del guion a partir de las anotaciones del autor en Figma.
- **Cómo estaba antes:** la tabla no registraba el guion.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-27 — Sistema de marca 2.0 en Figma

- **Qué cambió:** se añadieron una fila y un registro del trabajo de marca en Figma, con el pedido literal del autor, las fuentes, lo que hizo la herramienta y lo que no se afirma.
- **Cómo estaba antes:** el registro llegaba hasta la iteración Android 2.10.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-27 — Iteración Android 2.10

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.10, con el pedido literal del autor, las fuentes consultadas, lo que hizo la herramienta y lo que no se afirma.
- **Antes:** el registro llegaba hasta la iteración Android 2.9.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-27 — Iteración Android 2.9

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.9, con el pedido literal del autor, las fuentes consultadas, lo que hizo la herramienta y lo que no se afirma.
- **Antes:** el registro llegaba hasta la iteración Android 2.8.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-26 — Iteración Android 2.8

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.8, con los pedidos literales del autor, lo que hizo la herramienta y lo que no se afirma.
- **Antes:** el registro llegaba hasta la iteración Android 2.5.
- **Por qué:** mantener trazable qué parte del trabajo hizo la IA y qué decidió el autor.

### 2026-09-23 — Implementación Android 2.5

- **Qué cambió:** se separó la revisión documental de la iteración de código, se registró un prompt de corrección literal y se atribuyeron decisiones y verificaciones.
- **Antes:** el documento decía que la tarea del día no modificaba la app, porque describía únicamente la primera revisión escrita.
- **Por qué:** dejar una historia verificable del proceso sin atribuir al autor o a la herramienta trabajo que no hicieron ni inventar prompts perdidos.

### 2026-09-23 — Creación

- **Qué cambió:** se reunió evidencia dispersa sobre IA, se propuso un texto de declaración y una ficha de trazabilidad para nuevos prompts.
- **Antes:** existían registros por pieza e informes históricos, pero no una lectura de proceso que distinguiera contexto, salida y decisión del autor para la etapa actual.
- **Por qué:** permitir explicar a la comisión cómo se usó la herramienta sin inventar prompts ni confundir generación con autoría o validación.
- **Alcance:** reconstrucción parcial; debe actualizarse con registros originales que el autor conserve fuera del repositorio y revisarse antes de la entrega final.
