# Diseñar Relevo con inteligencia artificial: decisiones, límites y aprendizaje

**Fecha:** 27 de septiembre de 2026. **Estado:** borrador para revisión del autor y conversación con los profesores guía. **Alcance:** reflexión sobre el proceso documentado de Relevo hasta Android 2.10. Su incorporación a la memoria todavía no está decidida.

## Producir un resultado y comprender cómo se llegó a él

El desarrollo de Relevo permite examinar una pregunta que atraviesa la formación en Diseño: ¿qué trabajo realiza el diseñador cuando puede encargar a una herramienta la producción de imágenes, pantallas y código? En este proyecto, la inteligencia artificial participó en la exploración visual, la escritura, la organización documental, los wireframes y la construcción de una aplicación Android. También propuso soluciones y revisó resultados. Su intervención fue amplia y exige una explicación más precisa que presentarla como apoyo ocasional.

Las orientaciones para docentes de la Universidad Diego Portales (2024) recomiendan acordar los usos de IA, reconocer su intervención e idealmente registrar las instrucciones. Mantienen la responsabilidad del estudiante por el contenido y proponen examinar avances, borradores y reflexiones para valorar el aprendizaje. Este escrito recoge esa invitación; no responde a una pauta obligatoria específica para la titulación. Su propósito es analizar el trabajo realizado, identificar sus límites y reconocer qué revisión personal sigue siendo necesaria.

Los mensajes y las versiones de Relevo muestran un proceso de instrucciones, propuestas, rechazos y correcciones. Permiten reconstruir parte de las decisiones, pero no conocer automáticamente lo aprendido por el autor. Por ello, la reflexión distingue los hechos conservados en el repositorio de las interpretaciones sobre su significado. Las experiencias personales que no fueron expresadas por Johan no se completan por inferencia (*Fuentes de las recomendaciones y correcciones del autor*, 2026).

## Cómo se trabajó

El autor pidió que las herramientas conocieran la memoria, las entrevistas, los referentes y los comentarios docentes antes de producir. Añadió condiciones de escritura y diseño: explicar los conceptos, evitar repeticiones, justificar decisiones, mantener el carácter phygital y ordenar los resultados en GitHub. Estas instrucciones proporcionaron un marco al que volver cuando una propuesta se alejaba del proyecto.

La dirección se fue haciendo más específica al revisar resultados. Una petición general de mejorar la interfaz dio paso a observaciones sobre la cantidad de información por pantalla, la posición de las acciones, el lenguaje de los botones y el efecto del desenfoque sobre el contenido. El autor también aportó referencias como Laws of UX y sitios de microinteracciones. Su función fue orientar la búsqueda y hacer más concretas las expectativas; nombrarlos no acreditaba por sí solo que una solución estuviera bien resuelta (*Cómo el autor orientó el trabajo con IA en Relevo*, 2026).

Las herramientas tuvieron un papel activo dentro de ese marco. Produjeron alternativas, redactaron textos, programaron componentes, escribieron pruebas y propusieron decisiones de detalle. Parte de la revisión se encargó a otros agentes. Por tanto, no sería exacto atribuir al autor cada decisión presente en el resultado ni reducir la intervención de IA a ejecutar instrucciones completamente definidas. El registro permite distinguir pedidos humanos, soluciones propuestas por las herramientas y aspectos que aún requerían aprobación o comprobación (*Trazabilidad del uso de IA en la investigación y el diseño de Relevo*, 2026).

## Qué ocurrió con los wireframes

Un wireframe es un esquema de la estructura de una pantalla: permite discutir qué información aparece, qué acciones ofrece y cómo se relaciona con las demás. En Relevo se desarrollaron marcos de baja fidelidad, láminas de referencia y una versión HTML que permitía recorrer y exportar pantallas. Más adelante se construyó la aplicación Android. Estos materiales cumplían funciones distintas y no constituían versiones igualmente completas del producto (*Encargo 17*, s. f.).

El paso al código permitió representar comportamientos que una imagen no podía comprobar, como contar el uso de aplicaciones, mantener una sesión activa o iniciar una señal. Al mismo tiempo, una interfaz visualmente elaborada podía conservar textos confusos, decisiones sin resolver o estados incompletos. El nivel de acabado de la pantalla y la madurez de la experiencia avanzaron a ritmos diferentes.

Este recorrido permite cuestionar la necesidad de producir siempre la misma secuencia de entregables. Si la duda está en la distribución de información, un esquema puede ser suficiente. Si está en el comportamiento del sistema, resulta necesario un prototipo que lo ejecute. Para Relevo, el criterio que se propone es elegir la representación según lo que se necesita comprender, comparar o probar.

El caso no demuestra que los wireframes hayan quedado obsoletos. Tampoco permite afirmar que trabajar directamente en código sea siempre más rápido o produzca mejores interfaces: no hubo una comparación controlada entre métodos. Sí documenta que una parte de la exploración pasó a realizarse sobre una aplicación ejecutable. Esa posibilidad hizo especialmente importante revisar su estructura, incluso cuando la apariencia sugería que ya estaba terminada.

## Tres episodios de revisión

### Recuperar imágenes sin perder coherencia

Una primera aplicación de las nuevas directrices de marca produjo una versión plana y sin fotografías que no convenció al autor. En su comentario señaló que las versiones anteriores tenían imágenes, más personalización y pantallas que faltaban. El informe de Android 2.8 registra ese rechazo y la siguiente implementación (*Android 2.8*, 2026).

La observación muestra una intervención humana sobre el resultado. También revela una tensión de diseño: respetar un conjunto de reglas formales no garantiza que la experiencia conserve lo que se valoraba en versiones anteriores. La revisión obligó a considerar conjuntamente identidad, contenido y posibilidades de uso. Sin pruebas con personas, el episodio acredita una preferencia y una decisión de proyecto; no demuestra todavía que incorporar fotografías facilite la comprensión.

### Precisar lo que la interfaz dice

En una revisión posterior, el autor identificó expresiones que le resultaban poco naturales, entre ellas Empiezas, Lugar y Marcar como paso actual. Solicitó aclararlas y eliminar las mayúsculas sostenidas. La versión 2.10 documenta cambios como Pasar a este paso y una explicación que reúne cómo comenzar y dónde hacerlo (*Fuentes de las recomendaciones y correcciones del autor*, 2026; *Android 2.10*, 2026).

El interés de este caso está en el criterio que orienta la corrección: el texto debe ayudar a anticipar una acción. La herramienta propuso las formulaciones concretas, mientras el autor señaló el problema y exigió revisarlo. La siguiente comprobación tendría que observar si alguien que no conoce Relevo interpreta correctamente esos mensajes. La aceptación de una frase durante el desarrollo no sustituye esa observación.

### Revisar el efecto visual sobre la lectura

El autor pidió transparencias y desenfoques sutiles, pero después observó que el efecto comenzaba demasiado cerca del centro y que algunos textos podían perderse sobre fotografías oscuras. La versión 2.10 registra una reducción del desenfoque y un mecanismo para adaptar el tono del texto a la imagen. También reconoce que el cálculo utiliza un promedio y que todavía debe comprobarse en el teléfono real (*Android 2.10*, 2026).

Este episodio permite seguir una decisión desde la referencia estética hasta una dificultad de uso. El efecto deseado tuvo que ajustarse al contenido. El autor identificó la dificultad; la herramienta propuso e implementó una respuesta técnica. Para cerrar la decisión faltaba comprobar que funcionara con las distintas fotografías, tamaños de texto y condiciones de visualización.

## Qué aportó esta forma de trabajar y qué dejó pendiente

El repositorio conserva materiales que abarcan desde esquemas iniciales hasta una aplicación compilada, además de registros de cambios y capturas. Esa producción permite discutir propuestas concretas y volver sobre versiones descartadas. Sin embargo, no se midió cuánto tiempo habría requerido un proceso distinto. La disponibilidad de numerosos resultados no permite calcular horas ahorradas ni asignar un porcentaje de autoría humana.

La facilidad para solicitar otra versión también plantea un problema de alcance. En el historial aparecen numerosas exploraciones gráficas, rediseños y ampliaciones de funciones. Una lectura posible es que el proyecto necesitaba mejores criterios para decidir cuándo seguir explorando y cuándo detenerse a comprobar lo construido. Esa interpretación surge de la secuencia documental; no se atribuye aquí como un pensamiento que el autor haya expresado personalmente.

Otro límite es la revisión delegada. Que un agente encuentre errores en el trabajo de otro puede ser útil, pero sigue siendo una comprobación automatizada. Para el aprendizaje del autor importa también qué revisó directamente, qué pudo explicar y qué problema reconoció por sí mismo. El estudio de Muehlhaus y Steimle (2024) sobre diseño de interacción con IA describe apoyo en distintas fases y la necesidad de evaluar humanamente los resultados. En Relevo, los mensajes conservados acreditan algunas revisiones personales; no un examen humano exhaustivo de cada pantalla, fuente y componente.

La documentación de Android 2.10 informa pruebas automáticas y recorridos en emulador. También deja pendientes comprobaciones con teléfono y parlante reales, accesibilidad y otros aspectos del funcionamiento. Esa distinción es importante: tener una aplicación ejecutable amplía lo que puede probarse, pero el valor de la experiencia phygital todavía requiere observar su uso. La IA puede ayudar a preparar la evaluación; las respuestas de las personas deben provenir de la evaluación efectivamente realizada (*Android 2.10*, 2026).

## Qué convendría hacer de otra manera

Como propuesta de mejora del proceso, cada iteración debería comenzar con una pregunta acotada. En lugar de pedir una mejora general de toda la aplicación, se podría revisar si una persona comprende qué tiempo cuenta Relevo, dónde debe dejar el parlante o qué ocurre cuando termina la señal. Así sería más fácil relacionar cada cambio con un problema y decidir qué comprobar después.

También convendría fijar momentos de revisión personal. Antes de aceptar una nueva versión, el autor podría recorrer una tarea completa, explicar las decisiones principales y registrar una dificultad encontrada. Cuando una solución se apoya en una referencia, debería poder señalar qué tomó de ella y qué adaptó al contexto de Relevo. El resultado de esa revisión sería más informativo que una valoración general de que la interfaz se ve mejor.

Por último, sería útil seleccionar pocas decisiones representativas y conservar su secuencia completa. No basta acumular instrucciones: interesa mostrar qué propuesta se recibió, qué criterio motivó su rechazo o modificación y qué evidencia permite sostener el resultado. Los tres episodios descritos ofrecen un punto de partida, aunque aún necesitan incorporar la valoración personal del autor y, cuando corresponda, observaciones de uso.

El proceso documentado muestra una participación humana concreta y una delegación considerable en las herramientas. Explicar ambas permite discutir el trabajo de Diseño con mayor precisión. La contribución del autor puede hacerse visible en la relación entre el problema investigado, las decisiones que adopta y su capacidad de examinar sus consecuencias. Esa relación deberá sostenerse tanto en la presentación del proyecto como en las pruebas que todavía quedan por realizar.

## Nota de elaboración y revisión

Este borrador se redactó con asistencia de IA a partir de los mensajes del autor, la documentación de Relevo y las fuentes citadas. El encargo fue elaborar una reflexión sobre el uso de IA, sus aportes y límites, siguiendo las orientaciones docentes de la UDP. La revisión, edición y aprobación personal del autor están pendientes. Las interpretaciones del proceso son propuestas de análisis; no se presentan como recuerdos, sentimientos ni aprendizajes personales ya confirmados por Johan.

Para completar esa dimensión personal, queda abierta la pregunta formulada al autor: **¿qué aprendiste trabajando con IA en Relevo y qué harías distinto si empezaras de nuevo?** Su respuesta podrá incorporarse en una siguiente revisión con sus propias razones y ejemplos.

## Referencias

*Android 2.8: Sistema de marca D-073, perfil, ruta y regreso*. (2026, 26 de septiembre). Documentación interna del proyecto Relevo. [Informe de versión](../06_desarrollo_y_factibilidad/app-android/version-2.8-rediseno-perfil-y-ruta-2026-09-26.md).

*Android 2.10: Participación en la prueba, textos claros, tono de las fotos y más emoji*. (2026, 27 de septiembre). Documentación interna del proyecto Relevo. [Informe de versión](../06_desarrollo_y_factibilidad/app-android/version-2.10-participacion-y-claridad-2026-09-27.md).

*Cómo el autor orientó el trabajo con IA en Relevo*. (2026, 27 de septiembre). Documentación interna del proyecto Relevo. [Recopilación](direccion-del-autor-y-referencias-2026-09-27.md).

*Encargo 17 — Wireframes: Del flujo a la estructura*. (s. f.). Documentación interna del proyecto Relevo. [Registro de entrega](../05_propuesta_phygital/entrega-encargo-17.md).

*Fuentes de las recomendaciones y correcciones del autor*. (2026, 27 de septiembre). Documentación interna del proyecto Relevo. [Mensajes y procedencia](fuentes-direccion-del-autor-2026-09-27.md).

Muehlhaus, M., & Steimle, J. (2024). *Interaction design with generative AI: An empirical study of emerging strategies across the four phases of design* [Prepublicación]. arXiv. https://doi.org/10.48550/arXiv.2411.02662

*Trazabilidad del uso de IA en la investigación y el diseño de Relevo*. (2026, 27 de septiembre). Documentación interna del proyecto Relevo, versión actualizada. [Registro de proceso](trazabilidad-uso-ia-2026-09-23.md).

Universidad Diego Portales. (2024, abril). *Orientaciones en el uso de IA para docentes UDP*. https://desarrollodocente.udp.cl/cms/wp-content/uploads/2024/08/Orientaciones-IA_V2.pdf

## Registro de cambios (disclaimer)

### 2026-09-27 — Borrador de reflexión sobre el proceso

- **Qué se añadió:** una reflexión redactada con asistencia de IA sobre el trabajo documentado en Relevo, la función de los wireframes, tres episodios de revisión, los aportes de las herramientas y los límites de la evaluación realizada. Incluye referencias y una pregunta abierta para incorporar la perspectiva personal del autor.
- **Cómo estaba antes:** existían una recopilación de instrucciones y una trazabilidad de tareas, pero no un escrito continuo que examinara ese proceso a la luz de las orientaciones UDP.
- **Por qué:** el autor solicitó desarrollar esa reflexión a partir de sus conversaciones con los profesores guía y de la revisión del documento institucional.
- **Alcance:** borrador independiente. No modifica la memoria académica, la app ni los protocolos; no atribuye al autor pensamientos no expresados ni presenta pruebas pendientes como realizadas.
