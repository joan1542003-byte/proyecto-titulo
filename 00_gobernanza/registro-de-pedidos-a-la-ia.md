# Registro de pedidos del autor a la IA

**Propósito:** dejar una auditoría de cómo el autor dirige el trabajo con IA en Relevo: qué pidió, de qué tipo fue cada pedido, qué se obtuvo y qué decidió. Cada fila resume un pedido y enlaza su resultado. Las citas textuales, cuando existen, están en la [trazabilidad del uso de IA](trazabilidad-uso-ia-2026-09-23.md); el resumen de los días 26 a 28 de septiembre está en la [bitácora](bitacora-trabajo-con-ia-2026-09-26-28.md).

**Herramienta:** Claude Code, con el modelo Claude Opus 5.5, salvo que se indique otra.

**Regla:** desde el 29 de septiembre de 2026, cada pedido, cambio u orden del autor se registra aquí el mismo día, antes de cerrar el trabajo.

## Tipos de pedido

- **Encargo:** producir algo nuevo (una versión de la app, un documento, una pieza visual).
- **Corrección:** cambiar algo ya hecho a partir de la revisión del autor.
- **Consulta:** pedir una opinión, una explicación o una orientación.
- **Decisión:** el autor elige entre opciones que la IA le presentó.

## Pedidos

| Fecha | Tipo | Pedido del autor | Resultado | Decisión |
| --- | --- | --- | --- | --- |
| 23 sep. | Encargo | Revisar el repositorio, desarrollar por escrito las anotaciones del día y tomar `proyecto-titulo` como única fuente de contexto. | [Síntesis de anotaciones](../02_investigacion/sintesis-anotaciones-2026-09-23.md), [ficha de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) y trazabilidad | — |
| 23 sep. | Encargo | Aplicar a la app el feedback docente del día: reconocer lo que la persona hace, sin rachas y sin generar culpa. | Android 2.5 | — |
| 25–26 sep. | Encargo y corrección | Quitar la opción de agendar una entrevista y elevar el diseño al nivel de las mejores apps, según las nuevas directrices del repositorio. Tras ver una primera versión, recuperar las fotografías, la personalización y las pantallas que faltaban, y cuidar interacciones y animaciones. | [Android 2.8](../06_desarrollo_y_factibilidad/app-android/version-2.8-rediseno-perfil-y-ruta-2026-09-26.md) | D-082 |
| 27 sep. | Encargo | Llevar la app al estilo de iOS 26: pantalla completa, transparencias y desenfoques sutiles sin brillo, bordes redondeados, emoji 3D de Google en el perfil, sin repetir avisos de privacidad y sin sobreexplicar. | [Android 2.9](../06_desarrollo_y_factibilidad/app-android/version-2.9-vidrio-y-emoji-2026-09-27.md) | D-083 |
| 27 sep. | Corrección | Aclarar los textos confusos, cambiar la tipografía de «Estás aquí», no usar mayúsculas sostenidas, hacer obligatoria la participación, reducir el desenfoque, adaptar el color del texto a cada foto, sumar emoji y hacer más claras «Tu ruta» y «Tus actividades». | [Android 2.10](../06_desarrollo_y_factibilidad/app-android/version-2.10-participacion-y-claridad-2026-09-27.md) | D-084 |
| 27 sep. | Encargo | Desarrollar en Figma el sistema de marca de la nueva app, con vidrio líquido, iconos, emoji y tratamiento de imagen. | [Sistema de marca 2.0](../10_recursos_visuales/22_sistema-de-marca-2.0-figma-2026-09-27.md) | D-085, pendiente de aprobación |
| 27 sep. | Encargo | Leer las anotaciones dejadas en cada diapositiva de Figma y actualizar el texto de la presentación del 30 de septiembre. | [Guion v2](guion-presentacion-correccion-cruzada-2026-09-30.md) | — |
| 27 sep. | Encargo | Grabar un GIF de la app en funcionamiento para la presentación. | [GIF de la app 2.10](../06_desarrollo_y_factibilidad/app-android/capturas/como-funciona-2.10/README.md) | — |
| 28 sep. | Encargo | Crear un video de animación de 15 segundos, en español, que explique qué es Relevo con calidad profesional. | [Video](../10_recursos_visuales/marca-2.0/video/README.md), versión de 15 s | — |
| 28 sep. | Corrección | Extender el video a 30 segundos y quitar los textos que no aportan, como «Proyecto de título». | Video de 30 s | — |
| 28 sep. | Encargo | Revisar todo lo hecho, subirlo a GitHub y documentar decisiones, uso de la IA y cambios. | [Bitácora del trabajo con IA](bitacora-trabajo-con-ia-2026-09-26-28.md) | — |
| 28 sep. | Consulta | Pedir una evaluación franca del estado del proyecto y de sus posibilidades de titulación. | Respuesta en la conversación: riesgos en la evidencia con personas, el objeto físico y el calendario | — |
| 28 sep. | Consulta | Preguntar cómo ampliar el testeo con un solo parlante y poco presupuesto, cuándo empezar, con cuántas personas, a quién reclutar y si tres personas bastan. | Orientación en la conversación: parlantes propios de los participantes, tres a seis personas con órdenes equilibrados y el perfil del usuario principal | D-081 sigue sin actualizar |
| 28 sep. | Encargo | Revisar la app y dejarla lista para el primer testeo: mantener el parlante y el teléfono, explicar su uso la primera vez, incluir el video en vertical y guardar todos los datos en la base y en el teléfono. | [Android 2.11](../06_desarrollo_y_factibilidad/app-android/version-2.11-primer-testeo-2026-09-28.md) | D-086 |
| 28 sep. | Corrección y encargo | Simplificar la app para que no se sienta un testeo, registrar la mayor cantidad de datos, facilitar las opiniones, encender las notificaciones, usar un código más simple y el modo claro por defecto. Proponer actividades para generar sus imágenes. | [Android 2.12](../06_desarrollo_y_factibilidad/app-android/version-2.12-mas-simple-y-mas-datos-2026-09-29.md) y [actividades](../10_recursos_visuales/23_actividades-e-imagenes-2026-09-29.md) | D-087 |
| 29 sep. | Corrección y encargo | Reemplazar los intereses amplios por actividades concretas de las entrevistas, guardar el nombre, crear una guía de cada parte, revisar el audio saturado, resumir el relevo activo en Inicio y contrastar todo con la memoria. | [Android 2.13](../06_desarrollo_y_factibilidad/app-android/version-2.13-guia-intereses-y-nombre-2026-09-29.md) y [coherencia con la memoria](../08_memoria/coherencia-app-con-la-memoria-2026-09-29.md) | D-088 |
| 29 sep. | Decisión | Guardar el nombre de cada participante, después de conocer por qué no se guardaba, y preguntar Sí o No por el aviso semanal. | Tabla aparte para el nombre; aviso semanal preguntado en la guía | D-089 y D-088 |
| 29 sep. | Corrección y encargo | Reescribir las frases poco naturales, agrandar el video, rehacer la guía con contexto para que acompañe también el primer relevo, dejar la app lista para el testeo real y registrar cada pedido a la IA. | [Android 2.14](../06_desarrollo_y_factibilidad/app-android/version-2.14-guia-y-primer-relevo-2026-09-29.md) y este registro | D-090 |
| 29 sep. | Consulta | Revisar el encargo escrito para diseñar en Figma las diapositivas de la corrección cruzada, antes de ejecutarlo. | Revisión en la conversación: los datos teóricos coinciden con la memoria; la diapositiva 10 describe la app 2.6 y la 11 una prueba con seis personas, lo que choca con D-081; el conector de Figma necesita volver a autorizarse | — |
| 29 sep. | Encargo | Diseñar en Figma las diapositivas de la corrección cruzada según el encargo, con dos variantes por diapositiva, conservando la 2, 3 y 4 y usando los datos más recientes. | 18 diapositivas nuevas en las secciones «Variantes A» y «Variantes B» de la presentación, con notas del orador; la 10 muestra la app 2.14 y la 11, la prueba con una persona (D-081) | — |
| 29 sep. | Corrección | Rehacer las diapositivas con el estilo de diseño del autor, usar la hipótesis literal de la memoria y ordenar mejor la información, con textos más claros y concisos y sin elementos innecesarios. | Las 18 diapositivas rehechas con fondo blanco, Inter y el subrayado azul del autor; pregunta, hipótesis y objetivo general copiados de la memoria v4; se quitaron ilustraciones, tarjetas y pies sobrantes | — |
| 29 sep. | Consulta y encargo | Replantear la hipótesis, porque es compleja y difícil de entender: debe expresar aquello en que se basa la app, no su resultado. Estudiar la documentación, proponer opciones y, una vez elegida, actualizarla en todo el proyecto. | Tres opciones de hipótesis fundamentadas en el marco teórico y comprobables con el protocolo 02 | — |
| 29 sep. | Decisión | Adoptar la hipótesis de dos frases: la premisa (no se recuerda a tiempo) y lo que se pone a prueba (un aviso en el lugar donde empieza la actividad), y actualizarla en todo el proyecto. | Hipótesis cambiada en la memoria, el protocolo 02, los flujos, la guía de comunicación, el guion y las diapositivas 8A y 8B | D-091 |
| 29 sep. | Corrección | Señalar que la versión adoptada no es una hipótesis y pedir que se revisen las anteriores del proyecto. | Revisión de las hipótesis anteriores, todas con forma «si…, entonces…», y tres formulaciones nuevas con esa forma | — |
| 29 sep. | Decisión | Adoptar la hipótesis «Si durante una sesión en el teléfono suena una señal junto al primer paso…, entonces recordará esa actividad a tiempo para decidir si empezarla, mejor que con una notificación en el teléfono». | Hipótesis reemplazada en la memoria, el protocolo 02, los flujos, la guía de comunicación, el guion y las diapositivas 8A y 8B | D-091, corregida |
| 29 sep. | Consulta y decisión | Revisar las hipótesis de las presentaciones del examen de julio y los encargos del seminario que explican cómo debe ser una hipótesis. Elegir entre tres formulaciones que cumplen esas reglas. | Reglas de la cátedra reunidas (afirmativa, «si se diseña…, entonces…, porque…», un efecto con comparación, sin «podría»); hipótesis final actualizada en todo el proyecto | D-091, versión final |
| 29 sep. | Corrección | Simplificar la hipótesis para que cualquier persona la entienda, manteniendo «phygital» y los requisitos del seminario, sin explicar de más. | Hipótesis reescrita con palabras de uso diario en la memoria, el protocolo 02, los flujos, la guía, el guion y las diapositivas 8A y 8B | D-091 |
| 29 sep. | Consulta, corrección y decisión | Pedir que se le corrija si la hipótesis explica de más, compararla con las de sus compañeros usando el feedback del pase y del examen de julio, y que responda a lo teórico y no a lo que hace el proyecto, porque el sistema phygital se basa en la hipótesis. | Comparación con seis hipótesis y su evaluación: la de Relevo narraba el funcionamiento del producto. El autor eligió una versión teórica de 38 palabras, actualizada en todo el proyecto | D-091 |
| 29 sep. | Corrección y decisión | Mejorar la redacción de la hipótesis y elegir entre opciones. | Cuatro redacciones con distinto tono; el autor eligió la fluida («vincula… lo recordará a tiempo… se lo trae de vuelta»), actualizada en todo el proyecto | D-091 |
| 29 sep. | Corrección y decisión | Señalar que «el lugar donde empieza» no dice qué empieza y que «se lo trae de vuelta» suena informal, y preguntar si el «porque» es necesario. | Explicación: la cátedra pide el mecanismo, dentro de la hipótesis o justo después. El autor eligió mantenerlo en registro formal: «…con el lugar donde esa actividad comienza… porque el entorno actúa como señal de recuerdo fuera de la pantalla» | D-091 |
| 29 sep. | Consulta | Pedir una opinión franca sobre la hipótesis, en particular si el «porque» suena a la defensiva. | Opinión en la conversación: el «porque» se define contra la pantalla, cambia «lugar» por «entorno» y casi repite la condición. Se propuso un mecanismo teórico en forma de principio, pendiente de aprobación | — |
| 29 sep. | Consulta | Preguntar si el marco teórico exige que la señal esté en un lugar, por qué no podría funcionar solo en la app o en ambos, y revisar el marco y los referentes antes de decidir. | Revisión en la conversación de los capítulos 5 a 9 de la memoria: el marco respalda con firmeza recordar a tiempo mediante una señal, con menos fuerza el lugar, y no respalda que lo físico supere a lo digital; eso es lo que compara el protocolo 02 | — |
| 29 sep. | Consulta | Pedir una recomendación sobre la dirección: el autor considera que la hipótesis funciona y que la memoria puede quedar como está mientras el marco teórico siga justificando el objeto físico. | Recomendación en la conversación: adoptar la hipótesis con el «porque» de la memoria prospectiva y reforzar el capítulo 6 con el marco multiproceso de McDaniel y Einstein (2000), fuente ya citada, que explica por qué una señal saliente y asociada a la acción sirve cuando la persona está absorta | Aprobada: D-091 |
| 29 sep. | Encargo | Aplicar la hipótesis y el marco multiproceso, leer la memoria completa, revisar que las citas estén en APA 7 en español y dejarla sin errores. | Memoria actualizada: marco multiproceso en el capítulo 6 y el glosario, hipótesis final en el capítulo 10, estado del prototipo 2.14 en el capítulo 11 y la Tabla 5, prueba con una persona y texto de notificación en el capítulo 13, «&» reemplazado por «y» y «Artículo» en los números de artículo. Se actualizaron el protocolo 02, D-091, la guía, el guion, los flujos, la coherencia con la memoria y las diapositivas 8A y 8B | D-091 |
| 29 sep. | Encargo | Crear en Figma un archivo nuevo con la presentación más completa posible, no solo texto (por ejemplo, un diagrama de Venn para el marco teórico), tomando ideas de las presentaciones de otros estudiantes; y usar la encuesta a usuarios en la memoria. | Presentación nueva de 18 diapositivas con el estilo del autor: árbol de problemas, Venn del marco teórico, diagrama del marco multiproceso, gráficos de la encuesta, mapa de referentes, criterios, hipótesis y objetivos, sistema, capturas de la app, línea de la prueba, carta Gantt y referencias, con notas del orador. Encuesta analizada e incorporada a la memoria | D-092 |
| 29 sep. | Decisión | Confirmar que las 53 respuestas de la encuesta son reales pero editadas, y que el formulario informaba el uso académico anónimo. | La encuesta se usa con recuentos y categorías, sin citas; su origen y límites quedan declarados | D-092 |
| 29 sep. | Corrección | Simplificar la presentación para 5 minutos, al nivel de una keynote de Apple: menos explicación, resultados y su significado en vez de métodos, un poco más de detalle de cada ámbito teórico, un glosario, capturas que muestren la app y no la prueba, y menos peso en la prueba. Se adjuntaron tres presentaciones de compañeros como referencia. | Presentación reorganizada en 14 diapositivas principales con una idea por diapositiva: escena, resultados con su significado, problema, Venn, una diapositiva por ámbito teórico, glosario, hipótesis y objetivos breves, Relevo en tres pasos, capturas del producto, siguiente paso y cierre. Las 12 diapositivas de detalle quedaron en una sección de respaldo que se omite al presentar | — |
| 29 sep. | Consulta | Preguntar si existe en Chile algo barato que Relevo pueda hacer sonar, y si su reloj Huawei Watch Fit 5 podría sonar como Relevo necesita. | Respuesta en la conversación: un llavero antipérdida iTag (unos CLP 7.000) usa el servicio Bluetooth estándar de alerta inmediata y la app podría hacerlo sonar y detenerlo; una placa ESP32 con zumbador permite elegir sonido y duración, pero hay que armarla. El reloj solo vibra con las notificaciones de otras apps; hacerlo sonar exige el SDK Wear Engine de Huawei y, además, está en la muñeca y no en el lugar donde empieza la actividad | Pendiente del autor |
| 29 sep. | Consulta | Aclarar que interesa la forma del reloj, ya fabricada, como objeto situado; preguntar cuánto tarda y cuánto cuesta el programa de Huawei y cómo probar una app en el reloj; pedir un iTag que con seguridad suene desde Relevo, incluso con ingeniería inversa de la app oficial. | Respuesta en la conversación: la cuenta de Huawei es gratis, con verificación de 1 a 2 días hábiles; Wear Engine requiere aprobación, normalmente de 1 a 2 semanas; se prueba con modo desarrollador, un certificado de depuración y el registro del reloj. No se pudo confirmar que una app de terceros use su altavoz. Se propuso probar antes, sin Huawei, enviar el tono como audio de llamada al reloj. El iTag clásico usa el servicio Bluetooth estándar de alerta inmediata, así que no requiere ingeniería inversa; se verifica en minutos con nRF Connect antes de programarlo | Pendiente del autor |
| 29 sep. | Encargo | Integrar a Relevo el sonido como llamada para usar el reloj como objeto, y comprobar cómo la app oficial hace sonar el iTag, incluso descargando y revisando su APK. | [Android 2.15](../06_desarrollo_y_factibilidad/app-android/version-2.15-reloj-como-llamada-2026-09-29.md) con la salida experimental «El reloj», compilada y con 62 pruebas unitarias, sin probar con el reloj; Supabase acepta `watch`. El iTag se verificó en el código de una app Android de código abierto publicada en Google Play, sin descargar el APK oficial de un sitio espejo ([objetos que suenan](../06_desarrollo_y_factibilidad/objetos-que-suenan-2026-09-29.md)) | D-093 |
| 29 sep. | Consulta | Pedir qué iTag comprar para tener la seguridad de que Relevo podrá hacerlo sonar. | Recomendación en la conversación: el iTag clásico con forma de gota que usa la app iSearching (Tienda8, modelo OEM-AP008P, CLP 6.990; alternativa: Netexpertos, CLP 4.990, con retiro en Providencia). Se puede verificar al recibirlo con la app de código abierto iTag.One de Google Play, que usa la misma instrucción que usaría Relevo | Pendiente del autor |
| 29 sep. | Corrección | Revisar las notas y los textos que el autor dejó en la presentación de Figma y corregirlos; recuperar el mapa comparativo de las apps del mercado frente a Relevo. | Textos reescritos en el ámbito 2, el ámbito 3 («metido en el teléfono» en vez de «absorto»), el glosario (con fuentes teóricas), los objetivos, los pasos de Relevo y las preguntas a la comisión, ahora sobre puntos débiles. «Siguiente paso» muestra qué se registra en la prueba y para qué sirve. El mapa de referentes vuelve al flujo principal, que queda en 15 diapositivas | — |
| 29 sep. | Corrección | Agregar al diagrama de Venn de los tres ámbitos las intersecciones que faltaban. | Intersecciones de vuelta: «Seguir sin decidir» (experiencia y arquitecturas), «Recordar tarde» (experiencia y memoria), «Una señal fuera de la pantalla» (arquitecturas y memoria) y Relevo al centro, con notas del orador que explican cada una | — |
| 29 sep. | Corrección y decisión | Cuestionar si los títulos del Venn eran los reales y pedir contrastarlos con la memoria y con presentaciones anteriores. | Se comprobó que eran versiones acortadas. El autor eligió los títulos exactos del capítulo 6 de la memoria para los círculos y las diapositivas de cada ámbito, y las intersecciones de su examen de julio tal cual: «Interfaz que interrumpe el propósito», «Lo físico como apoyo a la reflexión» y «El dispositivo también ocupa atención» | — |
| 29 sep. | Corrección y decisión | Pedir títulos más fáciles de entender para los ámbitos, en especial «Mediación material de información personal» y «Experiencia subjetiva del ocio digital», recordando que la comisión dijo que se podían cambiar. | Se encontró el respaldo en el feedback del examen de julio. El autor eligió nombres cortos para los tres ámbitos: «La experiencia del ocio digital», «El diseño de la atención» y «Recordar con objetos y lugares», aplicados en la memoria, los documentos que los enlazan y la presentación | D-094 |
| 29 sep. | Encargo | Subir todo a GitHub, documentar el estado del proyecto y explicar cómo se hizo la presentación. | [Estado y proceso de la presentación](../10_recursos_visuales/24_presentacion-correccion-cruzada-2026-09-30.md) con las 15 diapositivas exportadas; [bitácora del 29 de septiembre](bitacora-trabajo-con-ia-2026-09-29.md); estado actualizado en el README y en el traspaso | — |
| 29 sep. | Encargo | Enviar el trabajo a `main`. | `main` avanzó hasta el último commit de `android-2.7`, sin conflictos; ambas ramas quedan iguales en GitHub | — |
| 29 sep. | Encargo | Adjuntar el GIF de la app hecho antes. | Se envió el [GIF «Cómo funciona»](../06_desarrollo_y_factibilidad/app-android/capturas/como-funciona-2.10/relevo-como-funciona.gif) de la app 2.10 | — |
| 29 sep. | Corrección | Reescribir la diapositiva «Siguiente paso», que no le convence: mostrar lo que sigue en las próximas semanas y meses, bien explicado y con sentido. | Diapositiva 14, «Probar antes de decidir.»: cuatro etapas (preparar, probar, decidir y defender) con las fechas del plan de cierre, qué se hace y para qué. La versión anterior quedó en el respaldo como R10 | — |
| 29 sep. | Corrección | Ordenar y desglosar mejor la diapositiva 14 con el formato de la carta Gantt del respaldo, que el autor hizo visible como referencia. | Diapositiva 14 rehecha como carta Gantt desde hoy hasta el examen: 13 tareas con sus fechas, agrupadas en preparar, probar, decidir y defender, con el para qué de cada etapa. La carta Gantt de referencia volvió a omitirse al presentar | — |
| 30 sep. | Corrección | Cambiar los textos de la carta Gantt: «Probar» es en realidad el testeo de 21 días con el usuario; mostrar qué más se hará en ese tiempo y los detalles de cada tarea, no solo el hecho; «Lugar y objeto decididos» no dice nada. | Título «Primero el testeo, después el diseño final.»; etapas «Preparación», «Testeo de 21 días», «Análisis» y «Entrega y examen»; una línea de detalle por tarea; seguimiento y objeto en paralelo al testeo; semana de Pruebas Solemnes marcada; hito «Diseño final: qué objeto suena y dónde se deja» | — |
| 30 sep. | Información y corrección | Informar que esta semana compra los materiales del testeo. Pedir los textos en tercera persona («el usuario elige…»), cambiar «pruebo el reloj y el llavero» por «Testeo de objeto físico; forma, materiales y costos» y quitar «reviso el consentimiento». | Diapositiva 14 con la compra de materiales (30 de septiembre al 4 de octubre), textos en tercera persona, el objeto con las palabras del autor y sin la revisión del consentimiento | — |
| 30 sep. | Consulta y encargo | Preguntar si Relevo podría activarse siempre solo al usar las apps y pedir agregarlo; pedir un panel de administración en un sitio (GitHub Pages u otro) con respuestas, usuarios activos, estadísticas en tiempo real y envío de notificaciones. | Tres preguntas antes de construir: cómo activarse solo, cómo enviar notificaciones y dónde publicar el panel | — |
| 30 sep. | Decisión | Activación automática opcional, también en el testeo; notificaciones con el Supabase del proyecto, enviadas desde su computador; panel como página privada en claude.ai. | [Android 2.16](../06_desarrollo_y_factibilidad/app-android/version-2.16-activacion-automatica-y-mensajes-2026-09-30.md) con activación automática, mensajes y consentimiento v10; tablas de mensajes en Supabase; [panel privado](../06_desarrollo_y_factibilidad/panel-admin/README.md). Probado en emulador: se activa solo, suena, llega el mensaje y se registran su llegada y su apertura | D-095 y D-096 |
| 30 sep. | Corrección y consulta | Ordenar mejor el panel y diseñarlo como la app de Relevo; preguntar si la notificación puede llegar al instante. | Panel rediseñado con los colores, la fuente, las tarjetas y las cápsulas de la app, en cuatro pestañas y con una hoja por persona. [Android 2.17](../06_desarrollo_y_factibilidad/app-android/version-2.17-mensajes-al-instante-2026-09-30.md): el mensaje llega al instante mientras Relevo cuenta o espera (0,8 s en emulador); para que llegue siempre al instante haría falta Firebase | D-096 |
| 30 sep. | Encargo y corrección | Registrar y tener almacenado todo lo de cada usuario (apps elegidas, uso y lo demás); dar mensajes predeterminados para enviarles; agregar la opción de eliminar un relevo activo, que no existía, y que la app avise qué campo falta cuando se toca «Seguir» sin completarlo. | [Android 2.18](../06_desarrollo_y_factibilidad/app-android/version-2.18-registro-completo-y-avisos-2026-09-30.md) con uso diario de las apps elegidas y tiempo total de pantalla desde 7 días antes, estado del teléfono, eliminación del relevo activo y avisos de campos faltantes; consentimiento v11. [Panel v3](../06_desarrollo_y_factibilidad/panel-admin/README.md) con 12 mensajes listos, uso y configuración de cada persona, «Para revisar» y descarga de datos. Probado en emulador, incluido el borrado de las tablas nuevas | D-097 |
| 30 sep. | Información y encargo | Informar lo que dijo la corrección cruzada: a la identidad de Relevo le falta desarrollo; se recordó el diseño de la presentación, pero no se vio en la app. Pedir elegir bien, quizás íconos propios que mezclen Material Design 3 y los de Apple, y sobre todo una identidad más notoria y fundamentada. | Diagnóstico de las dos identidades (presentación y app) y [propuesta «el subrayado»](../10_recursos_visuales/25_identidad-el-subrayado-2026-09-30.md) con lámina interactiva: logotipo con renglón, el azul de la presentación con cuatro usos, Schibsted Grotesk en todo, reglas del subrayado, 27 íconos redibujados, maquetas y fuentes | D-098, pendiente de decisión |
| 30 sep. | Información | Compartir sus referencias personales para Relevo: tres afiches de una marca llamada Otherwise (trama de puntos de colores, tarjetas de vidrio, titulares en serif, letras dispersas). | Versión 2 de la propuesta, en la misma lámina. Toma la trama (píxeles y rejilla del parlante), el paso de color de la pantalla a la casa, el vidrio y la serif en titulares, con maquetas, afiches y la foto de la app en trama. Señala que contradice D-068, D-070 y D-073 | D-098, pendiente; tres decisiones nuevas |
| 30 sep. | Decisión, consulta y encargo | Eligió sus referencias como dirección y pidió hacerla más neutra. Dijo que Instrument Serif está bien y pidió explorar serifas pensadas para pantalla. Pidió que la trama sea parte de la identidad y explorarla en los íconos, y confirmó «relevo» en minúsculas. Pidió evitar el degradado magenta y usar un color fundamentado, como un azul eléctrico. Preguntó si los íconos son propios y pidió buscar referencias parecidas en internet. | [Versión 3](../10_recursos_visuales/25_identidad-el-subrayado-2026-09-30.md): un solo azul eléctrico sobre neutros, la trama en fotos, tiempo y señal, cinco serifas comparadas (Newsreader recomendada para pantalla), íconos en trama para momentos de marca y referencias de Braun, Nothing y Klein. Respuesta: los íconos se dibujaron para Relevo | D-098, decidida en parte |
| 1 oct. | Encargo | Desarrollar, mejorar y perfeccionar el sistema gráfico (comunicación, tono, colores, variantes y lo demás) y, si se puede, pasarlo a Claude Design. | [Sistema de diseño 3.0](../10_recursos_visuales/26_sistema-de-diseno-3.0-2026-10-01.md) publicado en el tipo Design System de claude.ai: libro de marca con siete secciones (voz y tono, color y variantes, logotipo, trama, iconografía, aplicaciones y fundamentos), tokens en tema claro y oscuro, 43 componentes en React escritos desde los de la app, 124 recursos y portada. Lo que el autor no había decidido se usó como supuesto: Newsreader, una tinta y trama en íconos solo en momentos de marca | D-098, decidida en parte |

## Lo que muestra el registro

- **Cómo dirige el autor:** la mayoría de los pedidos corrigen algo ya hecho a partir de su propia revisión de la app o de las piezas. La IA propone y ejecuta; el autor revisa, corrige el rumbo y decide.
- **Decisiones que tomó el autor tras conocer alternativas:** guardar el nombre (D-089) y preguntar por el aviso semanal en vez de encenderlo (D-088).
- **Contradicciones que la IA señaló antes de actuar:** el nombre en la base y el aviso semanal encendido, ambos frente a la memoria.

Los pedidos anteriores al 23 de septiembre están en el «Registro de prompts existentes» de la [trazabilidad](trazabilidad-uso-ia-2026-09-23.md).

## Registro de cambios (disclaimer)

### 2026-10-01 — Sistema de diseño 3.0

- **Qué cambió:** se registró el pedido del 1 de octubre de desarrollar el sistema gráfico y pasarlo a Claude Design, con su resultado.
- **Cómo estaba antes:** el registro terminaba en las decisiones del autor sobre la versión 3 de la identidad.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-30 — Identidad después de la corrección cruzada

- **Qué cambió:** se registró el comentario de la corrección cruzada sobre la identidad y el pedido del autor, con la propuesta D-098 como resultado; después, sus referencias personales y la versión 2.
- **Cómo estaba antes:** el registro terminaba en la app 2.18.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-30 — Registro completo y mensajes listos

- **Qué cambió:** se registró el pedido de guardar todo lo de cada participante, los mensajes predeterminados, la eliminación de un relevo activo y los avisos de campos faltantes, con su resultado (Android 2.18 y panel v3, D-097).
- **Cómo estaba antes:** el registro terminaba en el rediseño del panel y los mensajes al instante.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-30 — Activación automática y panel

- **Qué cambió:** se registraron el pedido de activación automática y del panel con notificaciones, las decisiones del autor (D-095 y D-096), y el rediseño del panel con los mensajes al instante.
- **Cómo estaba antes:** el registro terminaba en la diapositiva 14 en tercera persona.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-30 — Textos de la carta Gantt

- **Qué cambió:** se registraron la corrección de los textos y los detalles de la diapositiva 14, el paso a tercera persona y la compra de materiales de esta semana.
- **Cómo estaba antes:** el registro terminaba en la carta Gantt del 29 de septiembre.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Rama principal, GIF y diapositiva 14

- **Qué cambió:** se registraron los pedidos de enviar el trabajo a `main`, adjuntar el GIF y rehacer la diapositiva «Siguiente paso», primero en columnas y después como carta Gantt.
- **Cómo estaba antes:** el registro terminaba en el pedido de documentar el estado y la presentación.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Objetos que suenan, correcciones de la presentación y estado

- **Qué cambió:** se registraron los pedidos sobre objetos que suenan, el reloj y el iTag (D-093), las correcciones de la presentación en Figma, el Venn, los títulos de los ámbitos (D-094) y el pedido de subir todo y documentar el estado.
- **Cómo estaba antes:** el registro terminaba en la simplificación de la presentación.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Presentación simplificada

- **Qué cambió:** se registró la corrección que simplificó la presentación a 14 diapositivas principales.
- **Cómo estaba antes:** el registro terminaba en la confirmación del origen de la encuesta.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Presentación completa y encuesta

- **Qué cambió:** se registraron el encargo de la presentación completa en un archivo nuevo de Figma, el uso de la encuesta y la confirmación de su origen (D-092).
- **Cómo estaba antes:** el registro terminaba en la revisión completa de la memoria.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Hipótesis

- **Qué cambió:** se registraron el pedido de una hipótesis más simple, la primera elección del autor, su corrección porque no tenía forma de hipótesis y la elección final (D-091).
- **Cómo estaba antes:** el registro terminaba en la corrección de las diapositivas.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Corrección de las diapositivas

- **Qué cambió:** se registró la corrección de estilo y contenido de las diapositivas en Figma.
- **Cómo estaba antes:** el registro terminaba en el encargo de las diapositivas.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Encargo de diapositivas

- **Qué cambió:** se registró la revisión del encargo de diapositivas para Figma.
- **Cómo estaba antes:** el registro terminaba en Android 2.14.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Creación

- **Qué se añadió:** un registro cronológico de los pedidos del autor a la IA desde el 23 de septiembre, con su tipo, su resultado y la decisión asociada, y la regla de registrar cada pedido nuevo.
- **Cómo estaba antes:** los pedidos estaban repartidos entre la trazabilidad, la bitácora y los documentos de cada versión.
- **Por qué:** el autor pidió una auditoría de cómo usa la IA en el proyecto.
