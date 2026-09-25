# Relevo

*Sistema phygital para recuperar intenciones personales durante el ocio digital*

## Memoria de Proyecto de Título

- **Estudiante:** Johan Yantén
- **Nota de título:** Memoria para optar al título profesional de la carrera de Diseño *(confirmar la denominación oficial y la mención)*
- **Profesor o profesora guía:** *(por completar)*
- **Unidad académica:** Facultad de Arquitectura, Arte y Diseño, Escuela de Diseño, Universidad Diego Portales
- **Lugar y fecha:** Santiago, Chile, 2026

## Resumen

Algunas sesiones de ocio digital se prolongan sin que la persona vuelva a decidir si quiere continuar. En esos momentos, otra actividad que también deseaba realizar puede dejar de estar presente justo cuando todavía era posible comenzarla. Este proyecto tiene como objetivo diseñar y evaluar formativamente un sistema phygital que ayude a recuperar esa intención sin bloquear el teléfono ni calificar la decisión posterior.

La investigación combinó una revisión bibliográfica sobre ocio, conflicto entre metas, bienestar digital, memoria prospectiva e interacción tangible; ocho entrevistas semiestructuradas con personas de 19 a 27 años, analizadas con el método Framework; y una comparación de herramientas que miden, pausan, bloquean o alejan el teléfono. Los resultados muestran que la duración no basta para juzgar una sesión, que las herramientas existentes actúan sobre todo sobre la actividad presente y que conviene distinguir dos situaciones: una en que la intención alternativa pierde presencia y otra en que el ocio digital conserva sentido y no debe interrumpirse. De ello se derivan ocho criterios de diseño.

Relevo responde con una aplicación Android y un objeto situado junto al primer paso de la actividad elegida, que emite una señal breve de luz y sonido cuando se cumple una condición configurada. El proyecto cuenta con un prototipo Android funcional que prepara el ciclo y emite un aviso sonoro, y con un protocolo para comparar la señal situada con una notificación digital. El aporte del objeto físico sigue siendo una hipótesis que esas pruebas deberán confirmar o descartar.

**Palabras clave:** ocio digital, memoria prospectiva, autonomía, diseño phygital.

## Abstract

Some digital leisure sessions continue without the person deciding again whether to go on. At such moments, another activity they also wanted to do may fade from view precisely when it could still begin. This project aims to design and formatively evaluate a phygital system that helps people recover that intention without blocking the phone or judging what they decide next.

The research combined a literature review on leisure, goal conflict, digital wellbeing, prospective memory and tangible interaction; eight semi-structured interviews with people aged 19 to 27, analysed with the Framework method; and a comparison of tools that measure, pause, block or distance the phone. The results show that duration alone cannot establish the value of a session, that existing tools mostly act on the current activity, and that two situations should be distinguished: one in which the alternative intention loses salience and another in which digital leisure remains meaningful and should not be interrupted. Eight design criteria follow from these findings.

Relevo responds with an Android application and an object placed next to the first step of the chosen activity, which emits a brief light and sound cue when a user-defined condition is met. The project has a working Android prototype that prepares the cycle and plays a sound cue, and a protocol to compare the situated cue with a digital notification. The contribution of the physical object remains a hypothesis that these tests must confirm or reject.

**Keywords:** digital leisure, prospective memory, autonomy, phygital design.

## Índice

1. Motivación personal
2. Introducción
3. Planteamiento del problema
4. Justificación
5. Antecedentes y estado de la cuestión
6. Marco teórico por ámbitos
7. Usuario, contexto y hallazgos de entrevistas
8. Estado del arte y referentes
9. Criterios de diseño
10. Formulación
11. Bajada proyectual
12. Factibilidad y límites
13. Plan de desarrollo y validación
14. Referencias

Glosario

### Índice de tablas

- Tabla 1. Participantes y función analítica de cada entrevista
- Tabla 2. Familias de herramientas y sus límites frente al problema
- Tabla 3. Actores y responsabilidades
- Tabla 4. Estados del ciclo y salidas disponibles
- Tabla 5. Soporte requerido en cada momento de la experiencia

### Índice de figuras

- Figura 1. Relación entre intención, lugar, condición y decisión

# 1. Motivación personal

Me ocurre con frecuencia abrir una aplicación para descansar unos minutos y quedarme en ella más tiempo del que imaginaba. Al cerrarla, descubro que otras cosas que también quería hacer —dibujar, leer, caminar o cocinar con calma— dejaron de estar presentes en ese intervalo. No decidí abandonarlas; simplemente dejaron de participar en lo que hacía.

No pienso que todo uso del teléfono sea negativo. Muchas veces encuentro en él entretención, conversación, información o un descanso que valoro. Lo que me inquieta es la diferencia entre elegir seguir y darme cuenta, después, de que no volví a considerar lo demás.

Me interesa estudiar ese momento sin convertirlo en un juicio sobre disciplina o productividad: por qué una intención personal pierde presencia, qué condiciones lo favorecen y cómo el Diseño podría ayudar a que vuelva a ser considerada. La pregunta nace de una experiencia propia, pero parte de un límite claro: descansar, cambiar de actividad o seguir frente al teléfono pueden ser decisiones igualmente válidas.

# 2. Introducción

Los teléfonos inteligentes reúnen comunicación, información, trabajo y entretenimiento en un mismo dispositivo. Han cambiado la forma de organizar el tiempo y también la de descansar: una persona puede conversar, escuchar música, jugar, mirar una serie o recorrer una red social sin cambiar de soporte. Esa diversidad impide tratar el uso del teléfono como una experiencia única y vuelve insuficiente cualquier evaluación basada solo en la duración.

Aquí se entiende por **ocio digital** el conjunto de actividades mediadas por dispositivos que una persona realiza en su tiempo disponible para descansar, entretenerse, satisfacer su curiosidad o vincularse con otros. No se opone a otras formas de ocio ni necesita justificarse por su utilidad. Una sesión extensa puede ser satisfactoria y coherente con lo que alguien desea; una breve puede sentirse inoportuna si desplaza algo que la persona consideraba importante. La diferencia depende del propósito, el contexto y la valoración de quien vive la experiencia (Lukoff et al., 2018; Meier & Reinecke, 2021).

Dentro de ese marco aparece una situación específica. Al comenzar una actividad digital, la persona puede tener presente otra intención: salir a caminar, leer, dibujar, ordenar su pieza, dormir o llamar a alguien. Aun así, la sesión continúa y esa alternativa deja de orientar el paso siguiente. Cuando vuelve a recordarla, la ocasión puede haber cambiado o quedar menos tiempo. No se trata de olvidar por completo ni de perder el control, sino de que una intención propia no estuvo disponible cuando podía influir en la decisión.

Algunas interfaces favorecen esa continuidad. El **desplazamiento infinito** carga contenido nuevo a medida que la persona avanza, sin un final de página reconocible; la reproducción automática y las recomendaciones encadenadas hacen algo parecido, porque el siguiente contenido aparece sin exigir una elección nueva. Estos patrones no determinan la conducta, pero reducen los puntos de cierre y mantienen disponible la acción actual (de Segovia Vicente et al., 2024; Montag et al., 2019).

Las herramientas que abordan esta situación miden el tiempo, fijan límites, bloquean aplicaciones o introducen pausas antes de abrirlas (Apple, s. f.; Google, s. f.-c; Lyngs et al., 2019). Son útiles cuando alguien quiere reducir una conducta concreta, pero detener la actividad presente no devuelve aquello que se quería hacer: un bloqueo puede cerrar una aplicación y dejar igualmente ausente la otra intención, o interrumpir una conversación o un descanso que la persona sí quería mantener. Impedir una acción y volver perceptible otra posibilidad son, por tanto, dos cosas distintas.

La **memoria prospectiva** ayuda a precisar esa diferencia. Designa la capacidad de recordar una acción que se quiere realizar en el futuro cuando aparece la ocasión adecuada (McDaniel & Einstein, 2000). Recordar al final del día que se quería leer no equivale a recuperar esa intención cuando todavía era posible abrir el libro. El problema, entonces, no es almacenar una meta, sino encontrar una señal pertinente que la traiga de vuelta a tiempo.

Esta investigación pregunta cómo puede el Diseño apoyar la recuperación oportuna de una intención personal durante una sesión de ocio digital, sin prohibir la actividad actual ni imponer una jerarquía entre formas de descanso. Para responder, estudia la experiencia subjetiva del ocio, las decisiones de interfaz que sostienen la continuidad, el papel del contexto y las formas en que las personas delegan el recuerdo en objetos, notas o alarmas, además de las soluciones que ya existen y lo que dejan abierto.

# 3. Planteamiento del problema

En 2025, el 96,6 % de los hogares chilenos declaró contar con acceso propio y pagado a internet, y entre los hogares conectados el teléfono inteligente fue el dispositivo de acceso más extendido, con una presencia de 99,1 % (Subsecretaría de Telecomunicaciones, 2025). Estas cifras describen un entorno ampliamente conectado, pero no dicen nada sobre el valor de cada experiencia digital. Para comprender la situación estudiada importa la relación entre la actividad presente, otras intenciones y el momento de elegir. El problema se organiza en tres aristas que evitan atribuirlo a una causa única.

## Arista experiencial y cognitiva

Una persona puede iniciar una actividad digital con un propósito claro y mantener, al mismo tiempo, otras intenciones para ese periodo. El conflicto aparece cuando la sesión se prolonga y alguna de esas alternativas deja de orientar la acción inmediata. Recordarla más tarde muestra que no desapareció de la memoria, pero también que no se recuperó cuando podía participar en la decisión.

De Segovia Vicente et al. (2024) estudiaron el desplazamiento digital percibido como carente de propósito en 1.315 personas adultas, combinando evaluaciones breves repetidas durante el día con registros del teléfono. Cuanto más se prolongaba ese desplazamiento, más culpa reportaban, y el conflicto con otras metas explicaba parte de esa relación. El estudio no establece causalidad ni convierte en perjudicial toda sesión extensa, pero indica que la relación con otras intenciones influye en cómo se vive la experiencia.

La dificultad no se define, por tanto, como un daño a la memoria ni como una incapacidad permanente. Aparece en momentos concretos, cuando una intención deja de estar disponible para orientar el paso siguiente, lo que permite estudiarla sin diagnosticar a la persona ni suponer que necesita dejar el teléfono cada vez que lo usa.

## Arista tecnológica

Las sesiones digitales ocurren dentro de interfaces diseñadas. A diferencia de una página, un capítulo o una pieza con término reconocible, el desplazamiento infinito, la reproducción automática y las recomendaciones consecutivas mantienen abierta la secuencia y ofrecen la acción siguiente con muy poco esfuerzo (Montag et al., 2019). Así se reducen los momentos en que hace falta decidir si se quiere continuar.

El propósito, el estado de ánimo, el contexto y los hábitos también influyen. Pero explicar la experiencia solo como falta de disciplina omite que el diseño organiza cierres, transiciones y oportunidades de elección: pedir confirmación, introducir una pausa o continuar sin interrupciones cambia las condiciones en que la persona decide. Las herramientas de bienestar digital son también decisiones de diseño, y la mayoría actúa sobre la conducta presente. Cuando otra intención ha perdido presencia, impedir el acceso no garantiza recordarla ni facilita comenzarla.

## Arista evaluativa

El ocio no se valora solo por su duración o contenido; también influyen las expectativas con que se interpreta ese tiempo. Tonietto et al. (2021) observaron que considerar el ocio como improductivo disminuía su disfrute, sobre todo cuando la actividad se realizaba como un fin en sí mismo. Aunque el estudio no trata específicamente del teléfono, explica por qué una intervención basada en culpa o rendimiento podría empeorar la experiencia que pretende apoyar.

Dos sesiones parecidas pueden tener sentidos distintos: una conversación extensa puede conservar valor afectivo y el mismo tiempo frente a una secuencia de contenidos puede sentirse incongruente con una intención previa. La diferencia no surge de una jerarquía universal entre actividades, sino de la relación que cada persona reconoce entre lo que hace y lo que quería hacer (de Segovia Vicente et al., 2024; Meier & Reinecke, 2021). Por eso el problema no se resuelve imponiendo productividad. Recuperar una intención significa devolverla a la decisión, no transformarla en obligación.

En síntesis, durante algunos episodios de ocio digital una actividad continúa mientras otra intención valorada deja de estar presente en el momento de elegir qué hacer. El desafío de Diseño consiste en apoyar la recuperación de esa intención sin bloquear la actividad actual, sin decidir por la persona y sin intervenir cuando el ocio digital conserva sentido.

# 4. Justificación

El tema es relevante porque el teléfono participa de forma constante en la vida cotidiana y reúne actividades que no pueden evaluarse con una regla única. Las mediciones de tiempo informan cuánto se usó, pero no si una sesión respondió al propósito de la persona ni si otra intención dejó de estar disponible. Una respuesta más precisa debe reconocer tanto el derecho a cambiar de actividad como el derecho a seguir en un descanso elegido.

La pregunta tiene además un valor preventivo. Cuando las únicas alternativas son bloquear, contabilizar o comparar, una herramienta de apoyo puede convertirse en una nueva fuente de presión. Fijar una intención no debería crear una deuda con el sistema: ignorar una señal, cambiar de idea o permanecer en la actividad digital son resultados legítimos. Este criterio traduce la autonomía en decisiones de diseño concretas y evita confundir ayuda con obediencia.

El problema involucra variables propias del Diseño: continuidad, cierre, momento, canal, jerarquía, legibilidad, fricción y control. La psicología aporta conceptos para entender el recuerdo de acciones futuras y el conflicto entre metas, y la ingeniería hace posible ejecutar condiciones y comunicaciones técnicas; al Diseño le corresponde articular ambos conocimientos en una experiencia clara, situada y respetuosa de quien la usa.

La pertinencia disciplinar se relaciona también con la posibilidad de distribuir una interacción entre componentes físicos y digitales. Un recordatorio situado en el entorno podría devolver una intención fuera del mismo flujo que concentra la atención. Esa posibilidad no se acepta de antemano: la presencia de un objeto solo se justifica si su ubicación y su señal aportan algo que una notificación convencional no logra con igual claridad y menor esfuerzo. Comprobarlo es parte del aporte de este proyecto.

# 5. Antecedentes y estado de la cuestión

## De la duración al sentido de la experiencia

Las herramientas nativas de los teléfonos muestran minutos diarios, aperturas y aplicaciones consultadas (Apple, s. f.; Google, s. f.-c). Ayudan a reconocer patrones y fijar límites, pero no informan sobre el propósito ni el significado de cada sesión.

Lukoff et al. (2018) estudiaron qué hace que el uso del teléfono se perciba como significativo o carente de sentido. La valoración dependía del propósito, la actividad y la autonomía experimentada, de modo que usos de duración semejante producían experiencias distintas. Meier y Reinecke (2021) llegaron a una conclusión compatible al revisar la investigación sobre comunicación mediada, redes sociales y salud mental: los efectos no siguen una dirección única y varían según la persona, la forma de uso y el contexto. Radtke et al. (2022), por su parte, revisaron intervenciones de desconexión digital y encontraron resultados positivos, nulos y negativos. En conjunto, estos antecedentes desaconsejan tratar la reducción del uso como una solución universal y orientan el análisis, como el estudio de De Segovia Vicente et al. (2024) descrito en el planteamiento, hacia la relación entre actividad e intención.

## Pausas, límites y separación del teléfono

Las herramientas de autocontrol digital recurren a bloqueos, temporizadores, eliminación de estímulos, demoras y mensajes de reconsideración. Lyngs et al. (2019) analizaron 367 aplicaciones y extensiones de navegador: predominaban los obstáculos a la conducta no deseada y solo una proporción menor apoyaba directamente la actividad alternativa.

La evidencia sobre su eficacia es heterogénea. Biedermann et al. (2021) revisaron 28 intervenciones y encontraron resultados variables, limitados por muestras pequeñas, periodos breves y métodos diferentes; las que solo buscaban aumentar la conciencia del uso fueron las menos eficaces. Monge Roffarello y De Russis (2023) revisaron 43 estudios: la mediana de duración fue de 21 días y solo cinco superaron los dos meses. En los siete estudios que permitieron estimarlo, el efecto sobre el tiempo dedicado a las fuentes de distracción fue pequeño a medio, sin que se identificara un mecanismo superior ni se pudiera equiparar menos tiempo con más bienestar.

Otra línea introduce una pausa antes de abrir o continuar en una aplicación. Grüning et al. (2023) estudiaron one sec, que demora la apertura y pide reconsiderar la acción; en su experimento, la opción explícita de desistir tuvo más efecto que el mensaje de reflexión, que por sí solo no fue eficaz. Haliburton et al. (2024) observaron las mismas fricciones en 1.039 personas durante un promedio de 13 semanas. Ambos trabajos muestran que una interrupción breve puede modificar recorridos y que su efecto depende del uso sostenido y del esfuerzo requerido. Aun así, una pausa puede abrir una decisión sin recuperar la intención alternativa: cerrar una aplicación ante una barrera no prueba que la persona haya recordado lo que quería hacer. Interrupción y recuerdo deben evaluarse por separado.

La intervención también puede trasladarse al espacio. Alejar el teléfono, guardarlo o condicionar su acceso a una llave física aumenta el esfuerzo de volver a él y apoya una restricción elegida, pero no indica qué actividad se quería comenzar. La distancia es una estrategia posible, no una respuesta completa.

## Recordar mediante señales y recursos externos

Las personas usan agendas, notas, alarmas y objetos para recordar acciones futuras. Esta práctica se conoce como **descarga cognitiva**: parte de la información que habría que mantener o recuperar se deposita en un recurso externo (Risko & Gilbert, 2016). Cuando lo que se externaliza es una acción futura, se habla de descarga de intenciones (Gilbert et al., 2023). Preparar un recordatorio exige formular la intención, elegir una señal y reconocerla después, y ese costo pesa: en dos experimentos, Chiu y Gilbert (2024) observaron que las personas usaban menos los recordatorios cuando prepararlos exigía más esfuerzo físico.

Los recordatorios basados en ubicación exploran el vínculo entre intención y contexto. Place-Its asociaba mensajes a lugares en teléfonos móviles (Sohn et al., 2005), y O’Rear y Radvansky (2019) mostraron, en un entorno virtual, que el lugar puede favorecer el recuerdo de una acción futura. El contexto colabora con la recuperación, aunque la proximidad no asegura que la acción se realice.

En el campo de la **interacción tangible**, que incorpora objetos físicos a la forma de representar o manipular información, *The Tangible Reminder* vinculó objetos cotidianos con información de citas y señales ambientales (Hermann et al., 2007). Mostró que un recordatorio puede distribuirse entre información digital, presencia física y entorno, aunque su propósito era comunicar compromisos temporales y no responde a sesiones de ocio digital ni a intenciones que la persona puede decidir no ejecutar.

## Alcance de los antecedentes

Las métricas describen el uso; los bloqueos modifican el acceso; las pausas abren una reconsideración; y los recordatorios apoyan el recuerdo. Ninguno asegura por sí solo que una intención alternativa vuelva a orientar la decisión. Queda abierta la pregunta de bajo qué condiciones una intención propia puede volver a estar disponible mientras la sesión continúa. La revisión no determina el soporte ni el momento más adecuados, ni permite suponer que una respuesta física sea superior a una digital.

La revisión es exploratoria. Se priorizaron publicaciones desde 2019 y se mantuvieron antecedentes anteriores cuando eran necesarios para definir memoria prospectiva, interacción tangible o uso del espacio. No se realizó una revisión sistemática ni un estudio de patentes, de modo que los vacíos identificados delimitan una oportunidad de investigación y no prueban que no existan soluciones semejantes.

# 6. Marco teórico por ámbitos

El marco teórico relaciona tres ámbitos: la experiencia subjetiva del ocio digital, las interfaces que organizan su continuidad y los recursos materiales que apoyan el recuerdo. Su intersección sirve para estudiar cuándo una intención deja de orientar la decisión y qué condiciones debería respetar una ayuda.

## Experiencia subjetiva del ocio digital

El ocio puede ofrecer descanso, disfrute, aprendizaje y vínculo social. Como se vio en la arista evaluativa, juzgarlo como improductivo reduce su disfrute (Tonietto et al., 2021), lo que cuestiona las intervenciones que convierten todo tiempo disponible en una obligación productiva.

La valoración de lo digital depende de la relación entre propósito y experiencia. Una misma aplicación puede sostener una conversación importante o una secuencia rutinaria; su categoría no define esa diferencia (Lukoff et al., 2018). Meier y Reinecke (2021) proponen atender a quién usa la tecnología, qué hace y en qué contexto, en lugar de inferir bienestar o malestar desde una categoría general como el tiempo de pantalla. Para esta investigación, la unidad relevante es el **episodio**: una situación concreta con un inicio, una actividad, un propósito, otras intenciones posibles y una valoración posterior.

Una **meta** es un resultado que orienta la acción, y varias metas pueden competir por tiempo, atención o recursos. El **conflicto entre metas** aparece cuando una actividad dificulta otra también valorada; describe una tensión entre posibilidades sin establecer cuál debería prevalecer. En el estudio de De Segovia Vicente et al. (2024), este conflicto explicaba parte de la culpa asociada al desplazamiento prolongado, lo que vincula el malestar con la distancia respecto de otras intenciones y no con la duración.

La culpa, sin embargo, no sirve como indicador automático. Puede surgir de expectativas sociales que desvalorizan el descanso incluso cuando la actividad fue elegida (Tonietto et al., 2021), y diseñar desde ella arriesga reforzar una norma externa. Es más preciso preguntar si existía otra intención y si la persona quería mantenerla disponible.

La relación entre metas cambia durante una sesión: una elección inicial deliberada no implica que cada momento posterior responda a una nueva decisión. Una **decisión renovada** ocurre al volver a considerar si se desea continuar, cambiar o detenerse, y puede surgir ante el final de un contenido, una pausa o una señal del entorno. Sin cierres claros, la sesión puede prolongarse sin que las alternativas vuelvan a compararse. La decisión inicial puede seguir siendo válida aunque convenga reconsiderarla; la distinción describe la continuidad sin suponer pérdida de conciencia o de control.

## Arquitecturas de atención y bienestar digital

Una interfaz define acciones, esfuerzos y puntos de cierre. El desplazamiento infinito, la reproducción automática y las recomendaciones encadenadas ofrecen el siguiente contenido sin exigir una búsqueda o confirmación nueva (Montag et al., 2019). Estas decisiones forman una **arquitectura de atención**: un conjunto de elementos que orienta lo que se percibe y cómo avanza la interacción. Las personas conservan su capacidad de elegir, pero seguir con un gesto mínimo exige menos preparación que levantarse, reunir materiales o cambiar de espacio. Esta asimetría ayuda a comparar comienzos: seguir viendo contenido y salir a caminar pueden ser igualmente valorados, aunque sus primeros pasos exijan esfuerzos distintos.

Algunas interfaces introducen **fricción**, es decir, un esfuerzo adicional como esperar, confirmar o desplazarse. La fricción puede abrir una ocasión de reconsiderar, pero si es excesiva frustra o dificulta actividades legítimas. Las demoras estudiadas por Grüning et al. (2023) y Haliburton et al. (2024) abren una elección, aunque se concentran en la acción digital presente: dificultar la continuidad puede producir una pausa sin que la persona recuerde qué otra cosa quería hacer. Sigue abierta la pregunta por una ayuda que devuelva esa alternativa sin restringir el acceso.

La autonomía depende de comprender la intervención y poder aceptarla, ajustarla o rechazarla. Una ayuda persistente o difícil de detener puede presionar aunque no bloquee el teléfono, y un tono amable no reemplaza la posibilidad real de elegir. En un experimento de comunicación digital sobre alimentación, ofrecer opciones mejoró la evaluación de la intervención, mientras que cambiar solo el lenguaje no produjo diferencias significativas (Smit et al., 2019). El estudio no evalúa Relevo, pero distingue una salida real de una frase que solo suena alentadora.

Si no existe una intención alternativa, la duración o la aplicación no justifican por sí solas una interrupción, y seguir después de recordar una intención también puede ser válido. Un sistema puede registrar tiempo, aplicación activa, horario o conexión, pero esos datos no revelan aburrimiento, culpa o satisfacción; interpretarlos como estados subjetivos llevaría a intervenciones injustificadas.

Las **intenciones de implementación** vinculan una situación anticipada con una respuesta: si ocurre cierta condición, entonces se realiza una acción (Gollwitzer & Sheeran, 2006). El vínculo se establece de antemano, de modo que observar el evento no prueba que el momento sea problemático. Recordar una intención, iniciar una actividad y adquirir un hábito son, además, resultados distintos. Formar un hábito supone que una conducta se vuelva más automática en un contexto recurrente, y medir su frecuencia o registrar una señal no basta para demostrarlo (Gardner et al., 2012; Lally et al., 2010). Las rachas pueden favorecer la continuidad de una conducta registrada, pero también convertir su mantenimiento en una meta en sí misma (Silverman & Barasch, 2023). Por eso el proyecto estudia cómo acompañar una decisión y no atribuye a un aviso la creación de hábitos.

## Mediación material de información personal

La memoria prospectiva, definida en la introducción, se distingue del recuerdo de acontecimientos pasados porque su valor depende del momento: la intención debe volver cuando todavía es posible actuar (McDaniel & Einstein, 2000). Una intención puede recuperarse ante una hora o un evento. Las alarmas señalan un momento; las claves contextuales, como lugares u objetos, relacionan la situación con la acción. En ambos casos la persona debe percibir y comprender la señal antes de decidir qué hacer. Percibir una señal, identificar su origen, recordar una actividad y decidir iniciarla son resultados distintos, y separarlos permite localizar dónde falla una ayuda sin exigir que su recepción termine en acción.

Una nota, un libro dispuesto sobre la mesa o una alarma conservan información fuera de la memoria activa; son formas de descarga cognitiva y, cuando guardan una acción futura, de descarga de intenciones (Gilbert et al., 2023; Risko & Gilbert, 2016). Externalizar reduce la necesidad de mantener una meta presente, pero obliga a configurar una señal y a encontrarla a tiempo, y cada paso de preparación tiene un costo que debe justificarse (Chiu & Gilbert, 2024). Una señal no necesita contener toda la información si su relación con la intención se comprende; si es ambigua, obliga a consultar otra fuente.

Kirsh (1995) explica que organizar el espacio reduce demandas cognitivas y hace perceptibles ciertas relaciones: preparar los ingredientes o dejar un objeto junto a la puerta permite que el entorno apoye la comprensión y el inicio de una acción. El lugar puede favorecer el recuerdo, aunque la proximidad no asegura actuar (O’Rear & Radvansky, 2019; Sohn et al., 2005); importan su significado personal y la posibilidad de percibir la señal entre otras actividades. Una meta amplia también debe distinguirse de su comienzo: hacer ejercicio puede empezar al preparar las zapatillas y dibujar, al disponer los materiales. Esta distinción abre la pregunta por la distancia entre recordar y reconocer una acción posible.

El espacio introduce a la vez límites de percepción, privacidad y convivencia. Los objetos pueden moverse o quedar cubiertos, y una señal puede molestar a otros. Situar una interacción exige estudiar las condiciones de cada hogar y permitir cambiar la asociación.

La **interacción tangible** incorpora objetos físicos a la representación o manipulación de información; su significado puede depender de la ubicación, la presencia, el peso y el movimiento, además del tacto. Una experiencia **phygital** integra componentes físicos y digitales con funciones complementarias. Añadir un objeto a una aplicación no basta: la relación debe aportar a la experiencia y evaluarse como un conjunto. *The Tangible Reminder* (Hermann et al., 2007) muestra cómo el entorno puede comunicar un compromiso, pero también las exigencias de energía, mantenimiento, costo y aprendizaje que el objeto introduce. Waggoner et al. (2026) señalan que estas experiencias requieren métodos capaces de observar la relación entre canales, lugares y momentos: evaluar solo la aplicación o solo el objeto fragmentaría el sistema, y es necesario comprobar si la capa física aporta valor frente a una solución exclusivamente digital.

## Conclusiones del marco teórico

Los tres ámbitos explican una misma tensión: una sesión puede conservar valor y, a la vez, coincidir con otra intención que pierde presencia. La interfaz sostiene la continuidad, la memoria prospectiva distingue recordar después de recordar a tiempo y el espacio puede apoyar la recuperación. De esta relación surgen las preguntas que orientan el trabajo con usuarios y referentes: cómo se recupera una intención, qué eventos pueden vincularse con ella y qué papel cumplen el contexto, la autonomía y el esfuerzo. La teoría orienta esas preguntas sin determinar una solución; las entrevistas permiten contrastar episodios de conflicto con usos elegidos y con las estrategias que las personas ya utilizan.

# 7. Usuario, contexto y hallazgos de entrevistas

## Método, participantes y alcance del estudio

Se realizó un estudio cualitativo exploratorio, es decir, orientado a comprender relatos y reconocer patrones iniciales, sin buscar representatividad estadística. Las entrevistas abordaron experiencias de ocio digital, momentos de continuidad, intenciones alternativas, formas de cierre y estrategias frente al teléfono. El formato semiestructurado mantuvo una pauta común y permitió profundizar en situaciones particulares mediante repreguntas.

Participaron ocho personas de 19 a 27 años. Las entrevistas fueron presenciales y se realizaron en Santiago el 11 y el 12 de junio de 2026. El reclutamiento se hizo mediante contactos de personas cercanas al investigador, y el único criterio común confirmado fue la edad, dentro de un rango de convocatoria de 18 a 30 años. El lugar y el rango etario describen el levantamiento, pero no permiten generalizar los resultados a todos los adultos jóvenes.

La pauta avanzó desde las actividades de tiempo libre hacia el relato de una sesión reciente: su propósito, continuidad, percepción del tiempo, valoración y cierre. Al final se formularon dos preguntas adicionales, una sobre estrategias para descansar sin el teléfono y otra sobre una idea anterior del proyecto: depositar el teléfono en un objeto que luego devolvía una señal de ese descanso. Las respuestas a estas dos preguntas se anotaron en el momento y se integraron después al corpus; esas notas originales ya no están disponibles. Se obtuvo consentimiento informado oral para participar y para el uso académico anonimizado del material.

Las conversaciones se transcribieron y regularizaron para facilitar su lectura, y el corpus se organizó con los códigos P1–P8 para participantes y Q1–Q13 para preguntas. La unidad de análisis fue el episodio: una situación relatada en relación con actividad, intención, continuidad, recuerdo, valoración o estrategia. El método Framework organizó temas y casos en una matriz común sin perder el vínculo con cada entrevista (Goldsmith, 2021). A partir de semejanzas y contrastes se construyeron **tipos ideales**, modelos analíticos que reúnen rasgos recurrentes sin convertirlos en perfiles permanentes de los participantes (Stapley et al., 2022). Combinaciones como «P2, Q3–Q7» localizan las respuestas que sostienen cada paráfrasis; no son citas textuales, sino una forma de contrastar la interpretación con el corpus anonimizado, que se reúne junto con el instrumento y los documentos de análisis en el [índice de anexos](anexos/README.md).

El estudio tiene límites que condicionan su lectura. La interpretación la realizó el investigador sin un segundo codificador; la duración de cada entrevista no quedó registrada; y no se observaron directamente las conductas ni los espacios domésticos. Los hallazgos permiten reconocer patrones y contraejemplos dentro del corpus, no estimar frecuencia, causalidad, eficacia o disposición de pago.

*Tabla 1*

*Participantes y función analítica de cada entrevista*

| Código | Edad | Aporte principal al análisis |
| --- | ---: | --- |
| P1 | 21 | Diferencia entre ocio digital valorado y sesiones difíciles de describir. |
| P2 | 22 | Tensión entre sueño reconocido y continuidad posterior en el teléfono. |
| P3 | 19 | Pérdida de noción temporal y presencia de actividades alternativas. |
| P4 | 22 | Contraste entre desplazamiento rutinario y sudoku focalizado. |
| P5 | 20 | Entretenimiento inmediato, aburrimiento posterior y estrategias frágiles. |
| P6 | 27 | Videollamada extensa, significativa y recordada. |
| P7 | 21 | Actividad elegida sin reconocimiento de un problema. |
| P8 | 19 | Variación entre rutina digital y descanso aceptado. |

*Nota.* La tabla resume la función analítica de cada caso; no establece diagnósticos ni perfiles permanentes.

El autor informó además una encuesta a 70 participantes cuyos materiales, procedencia, consentimiento, anonimización y análisis todavía no están documentados. Queda fuera de la evidencia de esta memoria hasta revisar esos antecedentes; su [ficha de seguimiento](../03_usuarios/encuesta-70-participantes-pendiente.md) registra la incorporación pendiente.

## Hallazgos, contrastes y estrategias cotidianas

P2 relató que abrió Instagram al acostarse para mirar memes. Reconoció que tenía sueño y aun así siguió usando el teléfono. Recordaba la sesión con claridad, pero dudó de que hubiera sido un descanso precisamente por haber seguido con sueño. El episodio no muestra un olvido, sino una tensión entre una intención alternativa —dormir— y la continuidad de la actividad (P2, Q3–Q7).

P3 describió una sesión de videos humorísticos en Instagram como una forma de matar el tiempo: perdió la noción de su duración y reconoció que tenía cosas mejores que hacer. Al mismo tiempo, consideró que la sesión le sirvió como pausa frente a sus responsabilidades. Esta ambivalencia es importante: una actividad puede ofrecer descanso y competir con otra intención sin volverse, por ello, incorrecta (P3, Q3–Q8).

P5 habló de un entretenimiento inmediato seguido de aburrimiento y de estrategias que no siempre evitaban volver al teléfono. Su relato ayuda a diferenciar una valoración negativa posterior de una intención alternativa ya formulada: no toda insatisfacción indica que existiera una actividad concreta que recuperar durante el episodio (P5, Q3–Q10 y Q12). P1 y P4, por su parte, distinguieron momentos de uso dirigido de otros más rutinarios, lo que impide tratar a una persona como usuaria permanente del problema: la pertinencia cambia con la actividad y el contexto (P1, Q3–Q5, Q8 y Q12; P4, Q3–Q8 y Q12).

Estos casos contrastan con experiencias que conservaron sentido durante toda la sesión. P6 relató una videollamada de varias horas que valoró por su contenido y por el vínculo con una amiga (P6, Q3–Q9). P7 describió un pódcast elegido mientras comía, sin reconocer nada que debiera corregir (P7, Q3–Q10). P4 diferenció el sudoku, que le exigía concentración, de otras actividades digitales menos dirigidas (P4, Q3–Q8), y P8 mostró que una rutina difícil de describir puede coincidir con un descanso aceptable (P8, Q3–Q10).

Los contraejemplos cumplen una función central. Dentro del corpus muestran que ni la duración, ni la presencia del teléfono, ni la categoría de aplicación bastan para decidir una intervención, y de ellos se deriva un riesgo de diseño: una señal activada solo por tiempo podría interrumpir una conversación importante, una actividad concentrada o una pausa deliberada. La ausencia de una intención alternativa también es significativa. Si la persona no ha formulado otra actividad que quiera mantener disponible, el sistema no tiene nada legítimo que recordar, y permanecer inactivo no es una falla sino una forma de respetar el propósito actual.

Las entrevistas indagaron también cómo las personas intentaban modificar sus sesiones. Mencionaron alejar el teléfono, cargarlo en otro lugar, silenciarlo, activar el modo no molestar o, en un caso, desinstalar temporalmente una aplicación (P1–P5 y P7–P8, Q12). Son estrategias declaradas, no observadas ni comparadas, pero muestran que la distancia, el lugar y el silencio ya forman parte del repertorio cotidiano de varios participantes. También revelan su límite: alejar el teléfono reduce su disponibilidad, pero no siempre evita el retorno ni recuerda qué actividad se quería comenzar.

Ante la idea anterior del proyecto, varias personas pidieron señales calmadas, discretas o visuales (P3–P5 y P7–P8, Q13), y una rechazó expresamente las notas o comparaciones entre días (P7, Q13). Esa idea registraba un descanso ya realizado en lugar de recordar una intención durante la sesión, y la pregunta presentó un concepto, no una experiencia de uso. Por eso estas reacciones solo orientan criterios generales de tono y discreción; no validan Relevo ni definen su forma.

## Dos situaciones de usuario

Los hallazgos permiten distinguir dos tipos situacionales. No son identidades ni segmentos comerciales: una misma persona puede pasar de uno a otro según la actividad.

El **usuario principal** aparece cuando la sesión continúa sin una decisión renovada reconocible y otra intención propia deja de orientar el paso siguiente. P2 y P3 ilustran con mayor claridad esta situación; P5 presenta un caso menos definido. Su necesidad no es abandonar el teléfono, sino volver a considerar una alternativa propia en un momento oportuno. Para traducirla en diseño, la intención debe vincularse con un comienzo concreto: dormir puede empezar al dejar el teléfono y preparar el espacio; caminar, al ponerse las zapatillas; leer, al abrir el libro. Sus principales dificultades son la continuidad difícil de cerrar, la pérdida de presencia de otra actividad y el regreso al teléfono después de haber intentado alejarlo, a lo que se suma una tensión: recibir ayuda sin sentir que una herramienta convierte la intención en obligación.

El **usuario límite** aparece cuando la actividad digital es elegida, significativa, relacional, concentrada o reparadora, o cuando no existe una intención alternativa que apoyar. P6 y P7 ofrecen los contrastes más claros; P4 y P8 muestran que la posición puede cambiar dentro de una misma persona. Su necesidad principal es conservar la autonomía. Una intervención equivocada puede convertir una actividad legítima en un problema, exponer una intención privada o interrumpir a otras personas; para este usuario, poder no activar, ignorar o detener la señal importa tanto como poder recibirla.

## Recorridos, contexto y necesidades de diseño

El recorrido del usuario principal comienza con una sesión elegida o tolerada como descanso. La sucesión de contenidos sostiene la actividad mientras una intención alternativa no logra orientar el cambio, y después la persona valora el episodio con ambivalencia o intenta alejar o silenciar el teléfono. El recorrido del usuario límite es distinto: la actividad se elige con un propósito y conserva valor durante la sesión; puede ser extensa, pero no entra en conflicto con otra intención reconocida, y termina sin necesidad de corrección. Cualquier ayuda debe permitir que este segundo recorrido continúe sin interrupciones injustificadas.

El hogar aparece como primer contexto pertinente, porque varias de las intenciones y estrategias relatadas dependen de objetos, superficies y distancias. Leer, dibujar, cocinar, dormir o salir a caminar suelen comenzar con acciones materiales reconocibles, y cargar el teléfono en otro lugar o dejarlo lejos ya forma parte de las prácticas mencionadas. Esta elección es todavía una hipótesis: las entrevistas no incluyeron observaciones de viviendas, convivencia, ruido, iluminación, privacidad o movilidad de objetos. Un elemento visible puede ser desplazado, una luz puede pasar inadvertida y un sonido puede molestar o revelar información personal, de modo que las condiciones del espacio deberán estudiarse antes de suponer que una solución sirve en todos los hogares.

Ambos recorridos exigen que la persona conserve la autoridad para interpretar el momento. De ellos se desprenden requisitos comunes: intención explícita, configuración voluntaria, posibilidad de cambio, señal discreta, salida inmediata y ausencia de sanciones. Las entrevistas no definen la forma de la solución; precisan el momento que debe abordarse y las situaciones en que intervenir sería un error, sin convertir a los participantes en validadores de una propuesta que no probaron.

# 8. Estado del arte y referentes

## Método y criterios de comparación

El estado del arte compara investigaciones, servicios y productos según su mecanismo, valor, evidencia y límites frente al problema estudiado. La búsqueda se cerró el 24 de agosto de 2026 e incluyó artículos académicos, documentación oficial, sitios de productos y fichas técnicas. El [registro metodológico](../04_mercado_y_referentes/registro-busqueda-2026-08-24.md) conserva la pregunta, las familias de términos, los tipos de fuente, los criterios de inclusión y exclusión, nueve referentes nucleares y los límites del levantamiento. Como no se preservó un historial literal de consultas ni conteos de resultados, la búsqueda puede repetirse de forma equivalente, pero no se presenta como revisión sistemática.

Las fuentes comerciales describen funciones, compatibilidad y modelo de negocio; no demuestran eficacia. La revisión se limita al corpus consultado y no es un estudio de patentes, participación de mercado o disponibilidad en Chile. Las seis familias en que se agrupan los referentes son una clasificación analítica para esta comparación, no una taxonomía universal. Cada referente se examinó con seis preguntas:

1. ¿Qué problema declara abordar?
2. ¿Qué mecanismo utiliza: medición, pausa, bloqueo, distancia, recordatorio o recompensa?
3. ¿Dónde ocurre la interacción principal?
4. ¿Qué debe hacer la persona para configurarlo y mantenerlo?
5. ¿Cómo conserva o limita su autonomía?
6. ¿Qué evidencia existe sobre sus resultados?

## Herramientas digitales de medición y pausa

Apple Screen Time y Google Digital Wellbeing ofrecen mediciones, límites por aplicación, periodos de descanso y control de notificaciones (Apple, s. f.; Google, s. f.-c). Vienen incluidas en el teléfono, lo que reduce costos y aprendizaje. Registran minutos, aperturas, horarios y aplicaciones, y pueden apoyar la reducción de un uso específico, pero no distinguen si una sesión corresponde a conversación, descanso, información o contenido sin propósito renovado.

Pause Point, anunciado por Google en 2026, lleva la reconsideración al sistema operativo: al abrir una aplicación marcada como distractora, introduce una pausa de diez segundos que ofrece respirar, fijar un temporizador o elegir otra actividad, y para desactivarlo hay que reiniciar el teléfono (Sanders, 2026). El anuncio no precisa en qué versiones y dispositivos estará disponible. Es el ejemplo más reciente del corpus de una pausa integrada que combina demora y precompromiso. Estas herramientas nativas son accesibles, pero expresan el significado dentro del teléfono, mediante tiempo o restricciones, y no asocian una intención con su comienzo en el entorno.

Las aplicaciones de pausa trasladan la reconsideración al momento de apertura. one sec introduce una demora antes de abrir aplicaciones elegidas, pide reconsiderar la acción y permite continuar tras la pausa (one sec, s. f.). Su mecanismo se ha estudiado en condiciones experimentales y en uso prolongado (Grüning et al., 2023; Haliburton et al., 2024), con evidencia de que una pausa puede disminuir aperturas automáticas y cambiar parte del recorrido. Esa evidencia no demuestra que todas las personas mantengan la herramienta ni que reducir aperturas mejore por sí solo el bienestar. Para esta investigación, su límite es que la decisión permanece en la pantalla: no conserva otra actividad ni la relaciona con el lugar donde puede comenzar. Quedan pendientes la duración del efecto, la transferencia hacia otra actividad y el esfuerzo de mantener la herramienta.

## Objetos que restringen o alejan el teléfono

Brick vincula una aplicación con un dispositivo físico que activa o revierte modos de bloqueo. Al momento de la consulta declaraba compatibilidad con Android 12 o posterior e iOS 17 o posterior, con un precio de USD 59 (Brick LLC, s. f.-a). Su propuesta combina distancia y **precompromiso**, una decisión previa que restringe deliberadamente las opciones futuras: para recuperar el acceso hay que volver al objeto. Brick Zone extiende esa lógica a un espacio declarado mediante Bluetooth, por USD 99 en la tienda estadounidense consultada (Brick LLC, s. f.-b). Unpluq usa una etiqueta de comunicación de campo cercano —NFC, tecnología que intercambia datos a muy corta distancia— junto con horarios, barreras, estadísticas y un modelo de suscripción (Unpluq, s. f.). Screenless Breaker ofrece una llave NFC para reabrir aplicaciones bloqueadas, aunque su sitio entregaba información contradictoria sobre precio y compatibilidad con Android (Screenless, s. f.).

En estos productos el objeto físico aumenta el esfuerzo de revertir una restricción y hace visible el compromiso, pero añade costos de compra, compatibilidad y aprendizaje, puede ser desproporcionado frente a una actividad legítima y no recupera por sí mismo una intención alternativa. Su oferta comercial tampoco prueba demanda, adopción ni disposición de pago.

Una restricción semejante puede lograrse sin conexión con el sistema operativo. kSafe es un contenedor con cierre temporizado para guardar el teléfono u otros objetos (Kitchen Safe, s. f.); se incluye como antecedente de mecanismo, sin confirmar su distribución en Chile. Su simplicidad técnica se acompaña de una restricción fuerte: revertir la decisión antes del plazo es difícil sin dañar el contenedor, y una llamada importante queda sometida a la misma barrera. Alejar o silenciar el teléfono, estrategias mencionadas en las entrevistas, ofrece una restricción más reversible y sin costo, pero tampoco conserva información sobre la actividad alternativa.

## Objetos de foco y recordatorios situados

Focusaur combina un dispositivo físico con una aplicación, etiquetas NFC, sonidos y funciones de hábito, y su comunicación comercial mezcla foco, constancia y recompensa. En la fecha de consulta mostraba un precio promocional de USD 129 frente a un valor de referencia de USD 169 en su tienda estadounidense, que despacha solo a Estados Unidos (Focusaur, s. f.); no se comprobó disponibilidad en Chile. El caso muestra una variante en que el objeto deja de ser una llave y participa de un ritual de inicio. Esta familia pone en valor el ritual y el lugar, pero sus estadísticas, recompensas o mecanismos de juego pueden desplazar el propósito personal hacia el cumplimiento frente al sistema, y su orientación a la productividad limita su adecuación al ocio y a intenciones que pueden cambiar.

Otro uso del objeto consiste en recordar una acción sin administrar el acceso al teléfono. *The Tangible Reminder*, aunque anterior al periodo priorizado, sigue siendo el referente más claro de integración entre información digital, objeto y entorno (Hermann et al., 2007). Las citas que comunicaba, sin embargo, tienen horarios y contenidos estables, mientras que una intención durante el ocio puede cambiar de prioridad sin que eso sea un incumplimiento. Los recordatorios basados en lugar, como Place-Its, presentan la señal donde puede ser significativa (Sohn et al., 2005), pero una ubicación detectada técnicamente no equivale a una relación personal con el espacio.

## Comparación de aportes y límites

Cada mecanismo responde a un propósito: observar patrones, abrir una pausa, sostener una restricción, dificultar el retorno o recordar mediante el entorno. Los límites aparecen al confundirlos: medir no explica el significado, bloquear no recupera una alternativa y recordar no garantiza actuar. La incorporación de un objeto debe justificar además sus costos y su mantenimiento.

La evidencia académica sobre autocontrol digital sigue siendo heterogénea: los estudios suelen ser breves y medir tiempo, aperturas o permanencia (Biedermann et al., 2021; Monge Roffarello & De Russis, 2023), y se sabe poco sobre autonomía, comprensión del mecanismo y abandono a largo plazo. Una tendencia reciente es permitir que las reglas se revisen. Peña-Albert et al. (2026) invitaron a reconfigurar sus avisos a personas que los habían desactivado en una herramienta de autocontrol digital, y 63 de 138 aceptaron. El resultado no prueba una eficacia general, pero indica que una regla puede perder pertinencia y que ajustarla forma parte de la experiencia.

El corpus muestra dos direcciones: simplificar el apoyo dentro del sistema operativo o añadir presencia física para reforzar un compromiso o una relación con el lugar. La Tabla 2 resume los mecanismos y sus límites frente al problema estudiado.

*Tabla 2*

*Familias de herramientas y sus límites frente al problema*

| Familia | Mecanismo principal | Referentes | Fortaleza | Límite frente al problema estudiado |
| --- | --- | --- | --- | --- |
| Medición | Mostrar tiempo, aperturas o categorías. | Screen Time, Digital Wellbeing. | Hace visible el patrón general. | No distingue el sentido de la sesión ni recupera una intención. |
| Pausa | Introducir una demora antes de continuar. | one sec, Pause Point. | Crea una ocasión de reconsideración. | Mantiene la señal y el significado dentro del teléfono. |
| Bloqueo | Restringir el acceso mediante una regla. | Brick, Unpluq, Screenless Breaker. | Sostiene un precompromiso difícil de eludir. | Se concentra en impedir la actividad presente. |
| Separación | Alejar o encerrar el dispositivo. | kSafe, estrategias cotidianas. | Reduce la disponibilidad física del teléfono. | No conserva qué otra actividad se quería comenzar. |
| Objeto de foco | Vincular lugar, hábito y compromiso. | Focusaur, Brick Zone. | Hace visible un estado y puede formar un ritual. | Tiende hacia productividad, control o recompensa. |
| Recordatorio tangible | Asociar información con objetos o lugares. | *The Tangible Reminder*, Place-Its. | Lleva una clave al contexto de la acción. | No aborda el ocio digital ni la decisión de continuar. |

*Nota.* Clasificación analítica elaborada para esta investigación a partir de las fuentes citadas en el capítulo.

## Oportunidad y exigencia de comparación

En el corpus revisado no apareció una evaluación independiente que reuniera seis elementos: una intención formulada por la persona, un primer paso concreto, una condición digital comprensible, una señal física situada, la posibilidad legítima de continuar y una comparación con una notificación equivalente. Esta ausencia se limita a las fuentes consultadas y no es una afirmación de novedad universal.

La oportunidad consiste en apoyar el tránsito entre recordar una intención y reconocer dónde comenzarla, relacionando intención, señal y lugar fuera del teléfono sin aumentar la dificultad de acceso. Esta dirección contiene también su principal exigencia crítica: si una notificación digital ofrece el mismo apoyo con menor carga, el componente físico no se justifica. El aporte debe probarse mediante comparación, no suponerse por la novedad aparente del objeto.

# 9. Criterios de diseño

Los criterios traducen la investigación en condiciones para formular y evaluar la propuesta. Son ocho y se agrupan según tres responsabilidades: conservar una intención comprensible, respetar la decisión de la persona y justificar el esfuerzo que introduce el sistema.

## Intención propia y comienzo concreto

**C1. Partir de una intención propia.** La intervención debe conservar una actividad elegida por la persona y no deducirla desde el tiempo de uso, la aplicación abierta o una categoría de productividad, porque experiencias de duración semejante adquieren sentidos distintos según el propósito y el contexto (Lukoff et al., 2018; Meier & Reinecke, 2021). Los contrastes entre P2–P3 y P6–P8 muestran esa diferencia dentro de las entrevistas. Sin una intención formulada no hay contenido legítimo que recuperar.

**C2. Relacionar la intención con un primer paso.** Una meta amplia puede dejar sin definir cómo empezar. Las intenciones de implementación muestran que vincular una situación con una respuesta prevista facilita pasar de la meta a la acción (Gollwitzer & Sheeran, 2006). Por eso cada intención se expresa mediante una acción concreta y próxima, que no obliga a completar la actividad: solo acorta la distancia entre recordarla e iniciarla.

## Activación comprensible y decisión autónoma

**C3. Usar una condición comprensible.** La activación debe depender de un evento que la persona pueda entender y modificar. Android puede registrar tiempo, horario o continuidad de uso con autorización, pero esos datos no revelan aburrimiento, culpa o satisfacción (Google, s. f.-d), y la variación entre episodios de una misma persona confirma que una condición técnica no equivale al sentido de la experiencia. Cualquiera de esas condiciones debe explicarse y probarse.

**C4. Abrir una elección, no imponer una conducta.** Una vez activada, la señal devuelve la intención al presente sin bloquear el teléfono. Las intervenciones restrictivas pueden sostener un compromiso, pero también interferir con usos legítimos, mientras que una pausa breve conserva la posibilidad de continuar (Grüning et al., 2023; Radtke et al., 2022). Ignorar la señal, detenerla, cambiar la intención o permanecer en la actividad digital son respuestas válidas. El sistema puede reconocer una elección que conoce —haber preparado una actividad o declarar que se comenzó—, pero no felicitar por una acción que no observó ni convertir la respuesta en una nota de cumplimiento. El prototipo muestra una confirmación breve ante esa declaración, y las pruebas deberán establecer si ayuda o presiona. Puntajes, rachas y premios quedan fuera.

**C5. Reconocer cuándo no intervenir.** Una actividad digital elegida, relacional, concentrada o reparadora no requiere corrección. P6 y P7 relataron experiencias extensas o focalizadas que conservaron sentido, y P4 y P8 mostraron que la pertinencia cambia dentro de una misma persona. La propuesta debe permanecer inactiva cuando no exista una intención alternativa y permitir que una regla pierda vigencia sin tratarlo como un error.

## Carga de uso, convivencia y aporte físico

**C6. Mantener una carga proporcional.** Configurar el ciclo, vincular y cargar el objeto, situarlo y prepararlo de nuevo agregan esfuerzo, y más esfuerzo de preparación reduce el uso de un recordatorio (Chiu & Gilbert, 2024). Los objetos revisados suman además costos de compatibilidad, mantenimiento y aprendizaje. Cada paso debe aportar a la comprensión o al funcionamiento; si la carga supera el beneficio, la propuesta debe simplificarse.

**C7. Proteger la privacidad y la convivencia.** Una señal situada no debe exponer su contenido ni molestar a quienes comparten el espacio. Las preferencias por señales discretas (P3–P5 y P7–P8) y el rechazo a comparaciones entre días (P7) apuntan en esa dirección, aunque respondían a un concepto anterior. Intensidad, canal, duración y ubicación deben ajustarse a cada contexto mediante pruebas.

**C8. Demostrar el valor de la capa física.** El objeto se justifica por la ayuda que ofrece. Los recordatorios tangibles y basados en ubicación muestran que el entorno puede participar en la recuperación de una acción futura, pero no aseguran que la persona comprenda la señal ni que actúe (Hermann et al., 2007; O’Rear & Radvansky, 2019). El objeto debe aportar una asociación con el lugar que una notificación no produzca de igual manera, y comparar ambas alternativas es una condición central de la evaluación.

# 10. Formulación

## Problema de diseño y pregunta de investigación

El estado del arte mostró que medir, pausar o restringir la actividad presente no devuelve necesariamente una intención alternativa ni indica dónde comenzarla. El problema de diseño consiste en hacer de nuevo perceptible una intención formulada por la persona, sin bloquear el teléfono, evaluar su conducta ni intervenir cuando la actividad digital conserva sentido. La propuesta se dirige a quien ya eligió una actividad y sabe cómo comenzarla, pero necesita mantenerla disponible durante ciertos episodios de ocio digital: una necesidad situacional, no un rasgo permanente ni una consecuencia de la edad.

> ¿Qué condiciones pueden ayudar a que una persona vuelva a considerar una actividad elegida cuando, durante una sesión de ocio digital, esa intención deja de orientar su decisión inmediata?

Volver a considerar una actividad significa reconocer la intención y recordar cómo comenzarla. La investigación distingue ese resultado de abandonar el teléfono, completar la actividad o reducir el tiempo de uso, de modo que una ayuda pueda evaluarse sin exigir que la persona siga su señal.

## Definición y alcance de Relevo

Relevo es un sistema phygital compuesto por una aplicación Android y un objeto de señal situado junto al primer paso de una actividad elegida. La aplicación registra la intención, define cómo comienza y configura una condición de activación. Cuando esa condición se cumple, el objeto emite un pulso ambiental breve, y la persona puede considerar la intención, seguir con la actividad digital o detener la señal.

El **pulso ambiental** es una señal física de corta duración que busca llamar la atención sin dar una instrucción. Su significado proviene de la asociación creada antes entre intención, objeto y lugar: no informa que la persona falló ni indica qué debe hacer, solo vuelve perceptible la actividad que decidió mantener disponible. Situar la señal cerca del comienzo busca que la persona reconozca, en el mismo lugar, la actividad que quería hacer y la posibilidad de iniciarla. Esa relación con el entorno es el aporte que el objeto deberá demostrar.

El alcance inicial considera una persona, una intención activa, un primer paso, una o varias aplicaciones cuyo uso se suma bajo un mismo límite, una condición observable, un objeto y un lugar doméstico elegido manualmente. El sistema no infiere estados emocionales, no juzga si una sesión es adecuada y no observa si la persona realiza la actividad. Android es la plataforma del primer prototipo integrado. El objeto emitirá luz y sonido; su forma, intensidad, duración, autonomía energética, materiales, precio y uso sostenido se definirán mediante desarrollo y pruebas. La propuesta mantiene su carácter phygital, pero el componente físico puede cambiar si la evidencia muestra que otra relación con los objetos responde mejor al problema.

## Hipótesis y objetivos

> Si una persona registra una intención y su primer paso, sitúa una señal física junto a ese comienzo y la recibe cuando se cumple una condición configurada, entonces la intención podría volver a estar disponible para decidir, sin bloquear la actividad digital ni imponer su ejecución.

La hipótesis se evalúa en cuatro dimensiones: asociación, aporte del lugar, autonomía y funcionamiento. Se debilita si la persona necesita consultar el teléfono para comprender la señal, si el soporte o la ubicación no marcan una diferencia o si la carga supera el beneficio.

El **objetivo general** es diseñar y evaluar formativamente un sistema phygital que apoye la recuperación situada de una intención personal durante episodios de ocio digital, mediante una señal asociada al primer paso de la actividad y sin bloquear ni calificar la decisión posterior. La evaluación formativa usa pruebas sucesivas para identificar dificultades y orientar mejoras del diseño. Los **objetivos específicos** son:

1. Caracterizar la relación entre ocio digital, continuidad, intención alternativa y contexto mediante revisión bibliográfica, entrevistas y análisis de referentes.
2. Traducir los hallazgos en una experiencia phygital que articule configuración digital, señal física, lugar y control de la persona.
3. Comparar la señal situada con una notificación digital para establecer si la capa física aporta una diferencia reconocible.
4. Evaluar comprensión, percepción, autonomía, funcionamiento técnico, convivencia y carga de uso mediante prototipos progresivos.

## Actores y responsabilidades

La experiencia depende de quien configura el ciclo, de quienes comparten el espacio y de quienes participan en el desarrollo. La Tabla 3 identifica funciones necesarias; no describe un equipo contratado ni acuerdos de fabricación.

*Tabla 3*

*Actores y responsabilidades*

| Actor | Relación con Relevo | Necesidad o responsabilidad principal |
| --- | --- | --- |
| Usuario principal | Formula la intención, sitúa el objeto e interpreta la señal. | Comprensión, control, privacidad y carga razonable. |
| Usuario límite | Utiliza el teléfono en una actividad que conserva sentido. | No recibir una intervención injustificada. |
| Convivientes | Comparten el espacio donde puede aparecer la señal. | Discreción y ausencia de molestias. |
| Diseñador | Articula investigación, experiencia, forma y evaluación. | Mantener coherencia entre problema y decisiones. |
| Desarrollo Android | Implementa permisos, condición, estados y comunicación. | Funcionamiento comprensible y recuperación de fallos. |
| Desarrollo electrónico | Resuelve energía, enlace y componentes de luz y sonido. | Fiabilidad, seguridad y mantenimiento. |
| Fabricación y proveedores | Producen carcasa, circuito y ensamblaje. | Costos, trazabilidad y reparación. |
| Especialistas en accesibilidad | Revisan canales, controles y barreras de uso. | Evitar exclusiones y promesas no comprobadas. |

# 11. Bajada proyectual

## Aplicación, testigo y relación con el lugar

Relevo distribuye funciones entre una aplicación, que conserva la información y configura la condición; un objeto, que hace visible que existe una intención activa y emite la señal; y el entorno, que relaciona esa señal con una acción posible. La persona reúne esas partes mediante una asociación que ella misma decide (Figura 1).

*Figura 1*

*Relación entre intención, lugar, condición y decisión*

> intención personal → primer paso → lugar elegido → condición configurada → pulso ambiental → decisión de la persona

*Nota.* Elaboración propia. La secuencia termina en una decisión abierta, no en una acción obligatoria.

La aplicación permite nombrar una actividad en lenguaje cotidiano y convertirla en un primer paso concreto; para una intención amplia como hacer ejercicio, solicita un comienzo —ponerse las zapatillas— y un lugar elegido manualmente, sin intentar detectarlo. También configura y explica la condición de activación, vincula el objeto y muestra los estados técnicos necesarios para modificar o detener el ciclo. La preparación debe ser breve.

La condición de activación permanece abierta a comparación. Puede basarse en continuidad de uso, tiempo acumulado dentro de una ventana o una franja horaria. El prototipo utiliza provisionalmente el tiempo acumulado en primer plano de las aplicaciones elegidas, porque es fácil de explicar y de ajustar; su pertinencia frente a las otras alternativas no está probada. Cada alternativa debe explicarse con ejemplos. El sistema no utiliza expresiones como detectar distracción o reconocer pérdida de control, porque esos estados no pueden deducirse desde un registro técnico.

La interfaz distingue intención y primer paso de estados técnicos como permiso revocado, desconexión o batería baja. Así evita presentar un fallo de comunicación como una decisión de la persona.

El componente físico, denominado **testigo**, representa la intención que la persona decidió mantener disponible. Se concibe como un cuerpo compacto y transportable que puede ubicarse sobre distintas superficies del hogar. Su presencia indica que existe una intención activa vinculada a ese lugar. Se propone una superficie que distribuya la luz para que el pulso pueda verse desde diferentes ángulos, un sonido breve que complemente su percepción y un control físico accesible para silenciarlo o probarlo.

La forma circular podría reducir la dependencia de una orientación frontal. Se comparará con un rectángulo redondeado de volumen interno equivalente mediante estabilidad, manipulación, percepción y acceso al control. La envolvente objetivo es de 42–48 mm de diámetro y 12–16 mm de grosor, con espacio para montaje y reparación. Dimensiones, peso, color y material se ajustarán tras comprobar señal, autonomía y distribución interior.

El testigo debe distinguir tres situaciones: reposo, señal y problema técnico. En las primeras pruebas se cubrirán las luces propias de la placa para que no compitan con el pulso, y la aplicación informará el estado técnico. Si más adelante el objeto avisa por sí mismo de batería baja o desconexión, ese aviso necesitará un patrón distinto de la señal, comprobado frente al riesgo de confusión.

El lugar es una relación elegida, no una coordenada detectada: junto al libro para leer o a los materiales para dibujar. El objeto puede asociarse con actividades diferentes entre ciclos, manteniendo una sola intención activa, pero esta adaptabilidad no implica universalidad. Como las superficies, los objetos y la convivencia cambian, cada reubicación exige probar de nuevo la señal, que puede quedar cubierta, perderse o conservar una asociación anterior, y la señal debe mantenerse discreta sin exponer el contenido de la intención.

## Preparación, señal y cierre del ciclo

Un **ciclo** es el periodo durante el cual una intención y su regla de activación permanecen vigentes. **Armar** el ciclo significa confirmar que el sistema está preparado para emitir la señal; desarmarlo significa retirar esa autorización. El recorrido previsto comprende nueve momentos y todavía no está implementado por completo.

1. **Formular.** La persona registra una intención y un primer paso concreto.
2. **Configurar.** Selecciona las aplicaciones, una condición observable provisional y la vigencia del ciclo.
3. **Revisar.** Comprueba y puede corregir lo preparado antes de continuar.
4. **Situar.** Confirma la vinculación y disponibilidad del objeto, y lo coloca cerca del primer paso.
5. **Probar.** Emite un pulso de prueba y comprueba percepción y silencio local.
6. **Armar.** Confirma explícitamente el ciclo mediante el control físico previsto; una confirmación ambigua permite repetir o salir.
7. **Esperar.** Utiliza el teléfono mientras la condición permanece vigente y puede desarmar.
8. **Recibir y decidir.** Percibe la señal y puede reconsiderar la intención, continuar, ignorar o silenciar.
9. **Cerrar.** El ciclo termina sin evaluar cumplimiento; otro ciclo requiere preparación y rearme voluntarios.

Comprender la señal no debería exigir consultar de nuevo la aplicación. El teléfono interviene para configurar, modificar o resolver un estado técnico. Para el primer ensayo físico se preparó un programa para la placa programable micro:bit que, junto con una herramienta Android, permitirá enviar la orden manualmente y comprobar su llegada y el patrón emitido. Ese programa compila, pero todavía no se ha instalado ni medido, y no verificará el armado físico ni la condición automática de este recorrido.

Una aplicación Android de prueba ya implementa parte de este recorrido. Permite escribir una actividad y su forma de comenzar, o elegir una de las propuestas; seleccionar una o varias aplicaciones cuyo tiempo en primer plano se suma hasta un límite de entre un minuto y seis horas; indicar dónde quedará la señal; revisar la configuración y activar el ciclo. Mientras cuenta, muestra una notificación permanente. Al cumplirse el límite reproduce un tono en un parlante Bluetooth elegido o en el teléfono, que puede silenciarse, y pregunta de forma opcional qué decidió hacer la persona. Antes de registrar datos solicita consentimiento para el uso académico y explica los permisos de Android.

Esta versión sustituye provisionalmente el testigo por un parlante Bluetooth comercial. Ese parlante no emite luz, no está reservado para Relevo y puede reproducir el audio de otras aplicaciones; por eso permite ensayar la preparación y la recepción, pero no representa el objeto propuesto. La salida por el teléfono sirve como comparación, no como experiencia phygital. La aplicación compila y supera sus pruebas automáticas, y algunas pantallas se revisaron en un emulador. No se ha comprobado todavía el ciclo completo en un teléfono y un parlante reales ni se ha usado con participantes.

## Funcionamiento y recuperación de fallos

La comunicación entre la aplicación y un testigo propio aún no está implementada ni validada. Android comprobaría localmente la condición autorizada, como ya lo hace el prototipo, y enviaría un comando durante su vigencia. Bluetooth de baja energía, una comunicación inalámbrica de corto alcance, conectaría aplicación y objeto. Este verificaría el ciclo, emitiría el patrón y volvería a reposo tras su término o silencio.

La integración deberá resolver identificación del ciclo, órdenes duplicadas y vencimiento; el formato de mensajes sigue abierto. El banco técnico, es decir, el ensayo sin participantes con la micro:bit, solo comprobará llegada de la orden, patrón y silencio local, no el control de mensajes tardíos. El objeto no necesita conservar el texto de la intención.

Si se revoca un permiso, se pierde conexión o falta batería, la aplicación debe informar y permitir desarmar. Lo mismo ocurre si se limita la ejecución en segundo plano, es decir, mientras la aplicación no está visible. No debe aparentar que evaluó una condición cuando no pudo hacerlo.

La Tabla 4 resume qué puede ocurrir durante el recorrido y cómo salir de cada situación.

*Tabla 4*

*Estados del ciclo y salidas disponibles*

| Estado | Qué ocurre | Salida disponible |
| --- | --- | --- |
| Sin intención | No existe un ciclo activo. | Crear una intención o permanecer inactivo. |
| Preparación | Se define actividad y primer paso. | Guardar, editar o cancelar. |
| Vinculación | Se asocia y prueba el objeto. | Reintentar, cambiar o abandonar. |
| Situado | El lugar fue elegido y la señal probada. | Reubicar, editar o continuar. |
| Armado | La condición se encuentra vigente. | Pausar, desarmar o modificar. |
| Señal activa | El objeto emite el pulso ambiental. | Silenciar, ignorar o actuar. |
| Fallo técnico | La condición o el enlace no pueden ejecutarse. | Recuperar, revisar o desarmar. |
| Ciclo cerrado | La señal terminó o la regla venció. | Rearmar, cambiar intención o eliminar. |

*Nota.* Estados del recorrido previsto con el testigo. La cobertura completa, con 35 estados alternativos, está en el [índice de anexos](anexos/README.md) y describe la estructura, no resultados de uso.

## Autonomía, privacidad y accesibilidad

El prototipo Android conserva en el teléfono la intención, el comienzo, el lugar declarado, las aplicaciones elegidas, el tiempo acumulado y los eventos del ciclo. Cuando está configurado, también intenta sincronizar estos registros con Supabase, un servicio remoto de almacenamiento, mediante un código aleatorio. Ese código separa el registro del nombre, pero no vuelve anónimos los horarios y las actividades. La aplicación incluye una opción para retirar el consentimiento y solicitar la eliminación local y remota; ni esa eliminación ni el envío de eventos se han comprobado de extremo a extremo, por lo que deben verificarse antes de trabajar con participantes. El objeto solo necesitaría recibir una orden para emitir la señal, no el texto de la intención.

El control debe estar disponible en ambos componentes. Desde la aplicación se puede pausar, editar o desarmar. Desde el objeto se puede silenciar el pulso. La ausencia de respuesta no debe generar recordatorios repetidos, mensajes de reproche ni pérdida de funciones.

La accesibilidad amplía esta revisión hacia las capacidades visuales, auditivas, táctiles, cognitivas y motoras de quienes utilicen el sistema. Ningún canal aislado puede declararse universal. Una luz puede pasar inadvertida y un sonido puede molestar o no percibirse. El prototipo deberá comprobar si ambos canales se complementan, permitir regularlos y facilitar el control físico sin movimientos precisos. Una alternativa táctil se estudiará como adaptación si las pruebas muestran que la combinación excluye a una persona, no como función añadida de antemano.

Las Pautas de Accesibilidad para el Contenido Web ofrecen un criterio preventivo frente a destellos, aunque cumplirlo no demuestra que una señal sea perceptible o adecuada (World Wide Web Consortium, s. f.). En la aplicación, los estados deben explicarse con lenguaje claro y no depender solo del color.

## Continuidad de la experiencia y soporte

Un mapa de servicio, o *service blueprint*, relaciona las acciones de la persona con los puntos de contacto y los procesos internos que las sostienen (Gibbons, 2017). La Tabla 5 lo aplica para revisar qué soporte exige cada momento de Relevo, desde la preparación hasta el retiro.

*Tabla 5*

*Soporte requerido en cada momento de la experiencia*

| Momento previsto | Qué necesita la persona | Soporte que debe estar resuelto | Estado |
| --- | --- | --- | --- |
| Conocer y aceptar | Entender propósito, límites y condiciones de participación. | Explicación consistente y, en la investigación, consentimiento revisado. | Consentimiento en la app con responsable, contacto y plazo; revisión académica pendiente. |
| Preparar | Registrar intención, configurar y verificar objeto y lugar. | Material comprobado, enlace disponible y explicación de permisos. | Preparación y permisos implementados en la app; objeto y enlace sin construir. |
| Recibir y cerrar | Percibir la señal y conservar una salida local. | Patrón reproducible y término sin insistencia. | Tono y silencio implementados con parlante o teléfono; prueba en equipos reales pendiente. |
| Recuperar un fallo | Saber si el ciclo sigue activo y poder detenerlo. | Separación entre incidente técnico y respuesta de usuario; procedimiento para restablecer el sistema. | Casos identificados; recuperación integrada pendiente. |
| Mantener o retirar | Cargar, reubicar, reparar o dejar de usar el sistema. | Componentes accesibles y procedimientos para desvincular y eliminar datos; retorno del material si fue prestado. | Solicitud de eliminación implementada en la app, sin comprobar; mantenimiento del objeto por definir. |

## Nombre y comunicación del propósito

La estrategia de marca se desarrolla después de definir el producto y su posición. Un posicionamiento necesita aclarar el marco en que el público comprenderá la propuesta, los atributos que comparte con esa categoría y una diferencia que resulte pertinente y creíble (Keller et al., 2002). Relevo se presenta como un recordatorio físico preparado desde el teléfono y explica de inmediato su diferencia: relaciona una actividad elegida con una señal ubicada en su contexto, sin bloquear ni evaluar la respuesta. Esta es una decisión de comunicación; no constituye un resultado sobre comprensión o eficacia.

La posición se vuelve experiencia cuando orienta decisiones observables en cada punto de contacto, y no cuando permanece como una lista de atributos (Motta-Filho, 2021). Los rasgos formales pueden favorecer reconocimiento si traducen valores con consistencia, pero su interpretación depende del producto y del contexto (Karjalainen & Snelders, 2010).

Relevo es el nombre definitivo del proyecto de título. Es breve, pronunciable y permite construir asociaciones propias sin explicar el mecanismo mediante una metáfora. También puede asociarse con deporte, turnos laborales, reemplazo de personas o logística; por ello, una eventual salida comercial exigiría comprobar disponibilidad jurídica y coincidencias de categoría. Esta precaución no mantiene abierto el nombre dentro del proyecto académico, sino que distingue una decisión de identidad de su posible registro comercial (Aaker, 1996).

La frase de marca es **Hazle lugar a lo que quieres hacer.** Vincula la actividad elegida con un lugar concreto y con la posibilidad de volver a considerarla. No promete cumplimiento ni presenta el uso del teléfono como una falta. Cuando el producto necesita explicarse sin contexto, el descriptor **Un recordatorio físico preparado desde el teléfono** acompaña al nombre y luego da paso a la descripción completa de la experiencia.

`Primer paso` se mantiene como concepto analítico para describir una acción breve, concreta y disponible que permite comenzar una actividad elegida. No aparece como expresión de los participantes P1–P8 y puede admitir interpretaciones diferentes sin una definición. Tampoco se limita a una decisión de interfaz: es una hipótesis transversal que debe ayudar a formular la actividad, elegir dónde ubicar el objeto y reconstruir el sentido de la señal. La interfaz comparará formulaciones cotidianas como «¿Cómo podrías empezar?» con alternativas equivalentes. Si concretar el comienzo no mejora configuración, ubicación y recuperación, el concepto deberá simplificarse o retirarse.

El sistema visual se organiza por funciones antes de incorporar recursos expresivos. Source Sans 3 constituye la familia tipográfica común. Los fondos neutros y el verde Relevo `#006B5F` forman la paleta principal; en superficies oscuras, `#72DBC7` conserva contraste como acento. La selección no atribuye al verde turquesa una emoción universal. Responde a su separación respecto de error y advertencia, a su funcionamiento en ambos temas y a la posibilidad de construir reconocimiento mediante un uso localizado (Elliot & Maier, 2014; Kauppinen-Räisänen & Luomala, 2010; Ward et al., 2020). La regla común es mantener un solo énfasis principal por pantalla o pieza. La aplicación prioriza la actividad, la forma de comenzar y el estado del recordatorio mediante componentes Android reconocibles. El dispositivo debe distinguirse de su entorno y comunicar sus estados sin depender exclusivamente del color. Su luz conserva pruebas propias: encontrar el objeto, notar la señal y comprender su relación con la actividad son comprobaciones distintas.

La memoria, la aplicación, el testigo y la comunicación deben reconocerse como partes de un mismo producto sin repetir una composición decorativa en todos los soportes. La [investigación visual](../10_recursos_visuales/README.md) reúne los criterios y alternativas; la [guía explicativa](../00_gobernanza/guia-comunicacion-relevo.md) distingue la promesa del producto de la evidencia disponible. La comunicación deberá revisarse si hace pensar que Relevo obliga a actuar o detecta un estado subjetivo.

# 12. Factibilidad y límites

## Plataforma y arquitectura técnica

El primer prototipo integrado se desarrollará para Android. La decisión responde a dos capacidades necesarias: consultar estadísticas autorizadas de otras aplicaciones mediante UsageStatsManager, una interfaz de programación provista por Android, y comunicarse con un dispositivo cercano mediante Bluetooth de baja energía. Ambas funciones cuentan con documentación nativa y permiten construir una prueba acotada (Google, s. f.-a, s. f.-b, s. f.-d).

Un sitio web sería más fácil de distribuir y permitiría acceso desde distintos sistemas. Sin embargo, el navegador no puede observar de manera confiable el uso de otras aplicaciones del teléfono ni mantener las mismas condiciones de ejecución en segundo plano. Web Bluetooth, la interfaz que permite a ciertos navegadores comunicarse con dispositivos cercanos compatibles, tampoco resuelve el acceso al uso global del teléfono (Chrome for Developers, s. f.). Por estas razones, una versión web no puede ejecutar el núcleo técnico del prototipo.

iPhone ofrece marcos de desarrollo como Device Activity y Family Controls, destinados a observar actividad autorizada y aplicar controles definidos por la persona, y Core Bluetooth para comunicarse con accesorios cercanos. Su implementación depende de permisos, capacidades y procesos de distribución específicos de Apple (Apple Developer, s. f.-a, s. f.-b, s. f.-c). Incorporar ambos sistemas durante la primera etapa duplicaría desarrollo y pruebas antes de comprobar la hipótesis central. La elección de Android concentra recursos; no impide estudiar otras plataformas si el mecanismo demuestra valor.

Las capacidades de Android también tienen límites. UsageStatsManager requiere que la persona conceda desde los ajustes un permiso especial para consultar estadísticas de uso y no detecta estados subjetivos. La ejecución en segundo plano y la comunicación Bluetooth varían según versión, fabricante y políticas de energía. El prototipo deberá probar pantalla bloqueada, cambio de aplicación, reinicio, pérdida de permiso y reconexión. No se afirma compatibilidad universal.

La arquitectura prevista para el testigo evalúa localmente la condición y le envía una orden por Bluetooth de baja energía, sin trasladar el audio de otras aplicaciones. El prototipo Android disponible utiliza en cambio un parlante Bluetooth multimedia o el altavoz del teléfono: puede solicitar que su propio tono se dirija al parlante y comprobar la ruta que informa el sistema, pero Android no garantiza esa ruta ni que el resto del sonido del teléfono permanezca en el teléfono (Android Developers, s. f.). Esta diferencia exige una prueba física y mantiene abierta la elección técnica del objeto. La sincronización remota de registros es un flujo aparte de la señal y requiere consentimiento y control de acceso.

El primer nivel técnico utilizará una micro:bit V2 para comprobar conexión Android, sonido y silencio local. Su matriz roja sirve solo para ensayos sin participantes. La prueba de comprensión requiere una luz blanca cálida externa y difundida (Micro:bit Educational Foundation, s. f.-a, s. f.-b).

El segundo nivel integraría el testigo portátil mediante una placa XIAO nRF52840, batería recargable protegida, una luz, un transductor sonoro pequeño —componente que convierte una señal eléctrica en sonido— y un control local. La placa reúne Bluetooth de baja energía y gestión de carga en 21 × 17,8 mm, por lo que reduce el tamaño y el número de conexiones frente a los montajes de mesa anteriores (Seeed Studio, 2026). BleenyButton demuestra una disposición abierta de la misma placa con batería, botón y carcasa atornillada; se estudia como antecedente constructivo, no como solución de uso. Cualquier reutilización de sus archivos o código exige revisar su licencia GPL-3.0 (Asterics Foundation, s. f.).

La batería se seleccionará midiendo reposo, conexión, señal y recuperación, junto con temperatura, protección, reemplazo y fin de vida. Un consumo aislado no permite prometer autonomía.

## Fabricación, mantenimiento y costos

Una carcasa impresa y componentes de desarrollo permiten modificar dimensiones, apertura y señal durante la etapa académica, pero no representan fabricación industrial ni determinan el costo en serie. Una versión posterior podría usar un circuito propio y una carcasa que permita reemplazar y separar batería, placa y señal al final de su vida útil; sellar el conjunto exigiría justificar que la protección compensa la pérdida de reparabilidad.

Al 7 de septiembre de 2026, una micro:bit V2 se ofrecía localmente por CLP 24.990 y una XIAO nRF52840 por CLP 16.590 (MCI Electronics, s. f.; MechatronicStore, s. f.). El primer valor corresponde a una plataforma completa de ensayo que se buscará conseguir prestada o disponible; el segundo incluye solo la placa de la integración portátil. Aún faltan batería, luz, transductor, control, conexiones, carcasa, difusor, envío y revisión especializada. Por tanto, ninguno representa el costo del prototipo.

Para evitar confusiones se separan cuatro magnitudes:

1. costo del prototipo académico;
2. trabajo profesional de investigación, diseño, programación y electrónica;
3. costo de producción, logística y soporte;
4. precio eventual y disposición de pago.

Producir en cantidad exigirá cotizar circuito, carcasa, batería, ensamblaje, pruebas, embalaje, distribución y merma —material o unidades perdidas durante la fabricación—. Ese cálculo debe seguir a la comprobación del aporte físico.

## Seguridad y condiciones de distribución

Un objeto con comunicación por radio deberá revisar la normativa chilena aplicable a equipos de alcance reducido, junto con ensayos, documentación y etiquetado (Subsecretaría de Telecomunicaciones, 2026). El uso de batería incorpora exigencias adicionales de transporte, carga y protección. El prototipo académico no equivale a certificación de producto.

La distribución de la aplicación también depende de los requisitos de Android y Google Play, especialmente cuando se emplean servicios en primer plano, tareas persistentes que deben informar su actividad mediante una notificación visible, o permisos sensibles (Google Play, s. f.). Estas condiciones pueden cambiar y deberán verificarse antes de publicar.

## Gestión y límites de factibilidad

El proyecto requiere diseño de interacción e industrial, desarrollo Android, electrónica y revisión de accesibilidad. El diseñador coordina decisiones; las áreas técnicas verifican permisos, energía, enlace y reparación.

Un posible modelo inicial corresponde a producción acotada con aplicación complementaria y soporte directo. Todavía no es posible elegir entre venta única, suscripción o distribución institucional. Ninguna entrevista estudió disposición de pago y los precios de referentes no representan automáticamente el valor de Relevo.

La condición de activación, los parámetros de luz y sonido, la forma, la autonomía, los materiales y los costos reales continúan abiertos. Tampoco se ha demostrado que el objeto ayude a recuperar intenciones, que el lugar produzca una diferencia o que la experiencia sea preferible a una notificación.

El alcance no incluye adicción, tratamiento clínico, control parental, vigilancia, productividad general ni reducción universal del tiempo de pantalla. El sistema tampoco busca detectar emociones o interpretar la calidad del ocio. Estas exclusiones mantienen el problema dentro de una escala abordable desde Diseño.

# 13. Plan de desarrollo y validación

El desarrollo avanza desde la asociación básica entre intención, señal y lugar hacia un prototipo integrado y su uso cotidiano. En cada etapa aumenta la **fidelidad** del prototipo, es decir, su semejanza con el uso previsto, y cada especificación se mantiene como candidata hasta contrastarla. Antes de trabajar con participantes se comprueban enlace, patrón, control local y materiales, para no confundir un fallo técnico con una dificultad de comprensión. Privacidad, accesibilidad y seguridad se revisan en todas las etapas.

En paralelo, el prototipo Android se comprobará en un teléfono y un parlante concretos: conteo de varias aplicaciones, notificación, salida del sonido, silencio, desconexión, envío de registros y eliminación de datos. Solo si esa revisión técnica y la del consentimiento son satisfactorias, una evaluación formativa con cinco o seis personas observará si comprenden la preparación, qué carga les supone y si conservan el control. Esa evaluación no compara el lugar con una notificación ni evalúa la forma final del objeto.

## Asociación y comparación con alternativas

La primera prueba de asociación usará una señal física real, activada manualmente desde Android, con una luz blanca cálida externa ya revisada. La persona formulará una intención y su primer paso, elegirá el lugar y recibirá el pulso mientras realiza otra actividad. En este ensayo la señal se enviará ocho minutos después de la configuración y el patrón durará tres segundos; ambos son parámetros de la prueba, no el momento ideal de intervención, y la condición de activación sigue abierta.

El registro distinguirá cuatro momentos: percepción de la señal, atribución al sistema, recuperación de la intención e identificación del primer paso. Por separado se comprobará si la persona entiende que puede ignorar, silenciar o seguir la señal; iniciar la actividad no será requisito. Si el significado no puede reconstruirse o las salidas no se comprenden, la configuración se reformulará antes de avanzar.

Si la asociación se sostiene, una segunda etapa comparará tres condiciones: el objeto junto al primer paso, el mismo objeto en un lugar neutro y una notificación local de Android. Cada persona prepara una intención distinta para cada condición, de relevancia y claridad semejantes según su propia valoración, y el orden se distribuye entre las seis secuencias posibles para reducir el efecto de practicar antes con una alternativa. El intervalo es equivalente en las tres condiciones; la diferencia entre intenciones se declara como límite. La notificación dice «Relevo · Tu intención está disponible», sin mostrar la intención ni el primer paso, de modo que la comparación se limita a ese aviso genérico y no permite afirmar superioridad frente a recordatorios que expliciten el contenido. Se compararán comprensión, consulta del teléfono, carga, intrusión y control; si el aviso ofrece el mismo apoyo con menos esfuerzo, se reconsiderará la configuración física.

## Forma, integración y piloto doméstico

Una vez sostenida la asociación, se compararán formas y comportamientos de luz y sonido: intensidad, duración, ritmo y separación entre ambos canales, sobre superficies y distancias reales. También se evaluarán el control para silenciar, la estabilidad del objeto y su lectura como parte del entorno, y la selección considerará percepción, privacidad, convivencia, accesibilidad y consumo.

Con esos parámetros, la integración incorporará aplicación Android, condición observable, comunicación Bluetooth, vencimiento y estados de error, y se probarán permisos, pantalla bloqueada, cambio de aplicación, pérdida de conexión, batería baja, reinicio y órdenes tardías. Solo después se realizará un piloto doméstico de duración acotada, cuyo protocolo definirá participantes, días de uso, criterios de inclusión, consentimiento, registros y forma de retiro. Se observarán armado, reubicación, pérdida, carga, convivencia, abandono y posible habituación a la señal. Un piloto de dos días puede mostrar dificultades de uso, pero no la formación de un hábito; para eso haría falta un seguimiento más largo y una medida de automaticidad adecuada a la actividad (Gardner et al., 2012).

## Registro de evidencia y criterios de decisión

Cada ficha registrará fecha, versión, pregunta, participantes codificados, contexto, materiales, procedimiento, evidencia, interpretación, límites y decisión, y distinguirá lo observado de lo inferido: mirar el objeto no equivale a comprenderlo. Se combinarán observación, preguntas abiertas, reconstrucción del significado y registro de errores; los cuestionarios breves sobre carga o intrusión complementarán el relato sin reemplazarlo, y se conservarán contraejemplos y razones de abandono. Los registros requieren consentimiento y se guardan bajo códigos seudónimos. El historial visible en la aplicación y los datos para evaluar el prototipo se explican por separado, porque ninguno prueba que la actividad elegida haya ocurrido, y antes de iniciar un estudio debe ser posible localizar y eliminar lo registrado en el teléfono y en la base remota.

La propuesta se mantiene cuando la señal se relaciona con la intención, el lugar aporta una diferencia, la salida es clara y la ejecución técnica es proporcional. Se modifica cuando falla una capa específica, como la intensidad, el vínculo, la forma o la explicación. La configuración física probada se detiene cuando no aporta lo suficiente frente al control o produce intrusión, sensación de vigilancia o una carga que no puede corregirse; ese resultado obliga a reformular la relación phygital, no demuestra que toda alternativa física carezca de valor.

El [primer protocolo](../07_validacion/protocolo-01-asociacion-y-comparacion.md) considera completa la asociación cuando la persona percibe la señal, la atribuye al ciclo y recupera la intención y el primer paso sin consultar el teléfono ni recibir pistas. La comprensión de las salidas se registra aparte: reconocer al menos dos opciones sin considerar obligatoria ninguna es una condición de autonomía para avanzar, no un quinto componente de la asociación. Con una muestra formativa de seis personas, se avanzará con al menos cinco asociaciones completas; con tres o cuatro se modificará la capa donde aparece el fallo; y con dos o menos, tras una iteración correctiva, se detendrá la configuración probada. La comparación posterior mantendrá la configuración situada si iguala o supera al aviso genérico en asociación, supera al lugar neutro en una mayoría simple y no introduce carga o intrusión recurrentes. Un fallo crítico de autonomía, privacidad, seguridad o accesibilidad impedirá avanzar aunque se alcance ese umbral. Estos umbrales organizan una decisión formativa; no estiman eficacia en la población.

## Conclusiones y alcance de la contribución

La pregunta de investigación puede responderse, por ahora, en el plano de las condiciones. La revisión bibliográfica, las entrevistas y el estado del arte coinciden en que una ayuda para volver a considerar una actividad elegida debería partir de una intención formulada por la propia persona, vincularla con un comienzo reconocible, activarse con una condición comprensible y dejar abierta la posibilidad de ignorarla. Las entrevistas agregan un límite decisivo: cuando el ocio digital conserva sentido o no existe otra intención, lo pertinente es no intervenir. Estas condiciones, reunidas en ocho criterios, son el principal resultado de la investigación.

La hipótesis, en cambio, sigue sin contrastarse. Todavía no hay evidencia de que una señal física situada junto al primer paso devuelva la intención mejor que una notificación, ni de que el lugar aporte significado. Lo alcanzado es la delimitación del problema, la distinción entre un usuario principal y un usuario límite como situaciones y no como grupos, la fundamentación de los criterios, una arquitectura de uso y evaluación, y un prototipo Android que ejecuta la preparación, el conteo y un aviso sonoro. El aporte disciplinar consiste en haber traducido una tensión cotidiana en decisiones de diseño verificables —qué se recuerda, cuándo, dónde y con qué salida— sin reducirla a una cuestión de disciplina o tiempo de pantalla.

El estudio tiene límites que condicionan estas conclusiones: una muestra cualitativa de ocho personas reclutadas por cercanía, sin segundo codificador ni observación de viviendas; una revisión de mercado exploratoria con corte en agosto de 2026; y un prototipo que todavía usa un parlante comercial en lugar del testigo. Por eso se recomienda seguir el orden previsto: verificar primero el prototipo y la gestión de datos, comprobar después la asociación con un objeto real y solo entonces compararlo con el aviso y con la ubicación neutra. Si la configuración física no marca una diferencia o exige demasiado esfuerzo, la relación phygital deberá reformularse. La continuidad del proyecto depende de esa evidencia.

# 14. Referencias

Aaker, D. A. (1996). *Building strong brands*. Free Press.

Android Developers. (s. f.). *AudioRouting*. Recuperado el 23 de septiembre de 2026, de https://developer.android.com/reference/android/media/AudioRouting

Apple. (s. f.). *Get started with Screen Time on iPhone*. Recuperado el 24 de agosto de 2026, de https://support.apple.com/en-ie/guide/iphone/iphb0c7313c9/ios

Apple Developer. (s. f.-a). *Core Bluetooth*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/CoreBluetooth

Apple Developer. (s. f.-b). *Device Activity*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/DeviceActivity

Apple Developer. (s. f.-c). *Family Controls App and Website Usage*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/bundleresources/entitlements/com.apple.developer.family-controls.app-and-website-usage

Asterics Foundation. (s. f.). *BleenyButton* [Repositorio de código]. GitHub. Recuperado el 7 de septiembre de 2026, de https://github.com/asterics/BleenyButton

Biedermann, D., Schneider, J., & Drachsler, H. (2021). Digital self-control interventions for distracting media multitasking: A systematic review. *Journal of Computer Assisted Learning, 37*(5), 1217–1231. https://doi.org/10.1111/jcal.12581

Brick LLC. (s. f.-a). *Brick: Take back your time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/

Brick LLC. (s. f.-b). *Brick Zone*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/pages/brick-zone

Chiu, G., & Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

Chrome for Developers. (s. f.). *Communicating with Bluetooth devices over JavaScript*. Recuperado el 25 de agosto de 2026, de https://developer.chrome.com/docs/capabilities/bluetooth

de Segovia Vicente, D., Van Gaeveren, K., Murphy, S. L., & Vanden Abeele, M. M. P. (2024). Does mindless scrolling hamper well-being? Combining ESM and log-data to examine the link between mindless scrolling, goal conflict, guilt, and daily well-being. *Journal of Computer-Mediated Communication, 29*(1), zmad056. https://doi.org/10.1093/jcmc/zmad056

Elliot, A. J., & Maier, M. A. (2014). Color psychology: Effects of perceiving color on psychological functioning in humans. *Annual Review of Psychology, 65*, 95–120. https://doi.org/10.1146/annurev-psych-010213-115035

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Gardner, B., Abraham, C., Lally, P., & de Bruijn, G.-J. (2012). Towards parsimony in habit measurement: Testing the convergent and predictive validity of an automaticity subscale of the Self-Report Habit Index. *International Journal of Behavioral Nutrition and Physical Activity, 9*, Artículo 102. https://doi.org/10.1186/1479-5868-9-102

Gibbons, S. (2017, 27 de agosto). *Service blueprints: Definition*. Nielsen Norman Group. https://www.nngroup.com/articles/service-blueprints-definition/

Gilbert, S. J., Boldt, A., Sachdeva, C., Scarampi, C., & Tsai, P.-C. (2023). Outsourcing memory to external tools: A review of intention offloading. *Psychonomic Bulletin & Review, 30*(1), 60–76. https://doi.org/10.3758/s13423-022-02139-4

Goldsmith, L. J. (2021). Using framework analysis in applied qualitative research. *The Qualitative Report, 26*(6), 2061–2076. https://doi.org/10.46743/2160-3715/2021.5011

Gollwitzer, P. M., & Sheeran, P. (2006). Implementation intentions and goal achievement: A meta-analysis of effects and processes. *Advances in Experimental Social Psychology, 38*, 69–119. https://doi.org/10.1016/S0065-2601(06)38002-1

Google. (s. f.-a). *Communicate in the background*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (s. f.-b). *Companion device pairing*. Android Developers. Recuperado el 9 de septiembre de 2026, de https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing

Google. (s. f.-c). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Recuperado el 24 de agosto de 2026, de https://support.google.com/pixelphone/answer/9137850

Google. (s. f.-d). *UsageStatsManager*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/reference/android/app/usage/UsageStatsManager

Google Play. (s. f.). *Understanding foreground service and full-screen intent requirements*. Play Console Help. Recuperado el 25 de septiembre de 2026, de https://support.google.com/googleplay/android-developer/answer/13392821

Grüning, D. J., Riedel, F., & Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), e2213114120. https://doi.org/10.1073/pnas.2213114120

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A., & Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (pp. 1–16). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hermann, M., Mahler, T., de Melo, G., & Weber, M. (2007). The tangible reminder. En *Proceedings of the 3rd IET International Conference on Intelligent Environments* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

Karjalainen, T.-M., & Snelders, D. (2010). Designing visual recognition for the brand. *Journal of Product Innovation Management, 27*(1), 6–22. https://doi.org/10.1111/j.1540-5885.2009.00696.x

Kauppinen-Räisänen, H., & Luomala, H. T. (2010). Exploring consumers’ product-specific colour meanings. *Qualitative Market Research: An International Journal, 13*(3), 287–308. https://doi.org/10.1108/13522751011053644

Keller, K. L., Sternthal, B., & Tybout, A. M. (2002). Three questions you need to ask about your brand. *Harvard Business Review, 80*(9), 80–86. https://hbr.org/2002/09/three-questions-you-need-to-ask-about-your-brand

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Kitchen Safe. (s. f.). *kSafe*. Recuperado el 25 de septiembre de 2026, de https://www.thekitchensafe.com/

Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W., & Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

Lukoff, K., Yu, C., Kientz, J. A., & Hiniker, A. (2018). What makes smartphone use meaningful or meaningless? *Proceedings of the ACM on Interactive, Mobile, Wearable and Ubiquitous Technologies, 2*(1), Artículo 22. https://doi.org/10.1145/3191754

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M., & Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (Artículo 131, pp. 1–18). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

McDaniel, M. A., & Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*(7), S127–S144. https://doi.org/10.1002/acp.775

MCI Electronics. (s. f.). *Placa BBC micro:bit V2*. Recuperado el 7 de septiembre de 2026, de https://mcielectronics.cl/shop/product/bbc-microbit-v2-placa-unica/

MechatronicStore. (s. f.). *Seeed Studio XIAO nRF52840*. Recuperado el 7 de septiembre de 2026, de https://www.mechatronicstore.cl/seed-studio-xiao-nrf52840/

Meier, A., & Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Micro:bit Educational Foundation. (s. f.-a). *Bluetooth*. Recuperado el 7 de septiembre de 2026, de https://tech.microbit.org/bluetooth/

Micro:bit Educational Foundation. (s. f.-b). *Hardware*. Recuperado el 8 de septiembre de 2026, de https://tech.microbit.org/hardware/

Monge Roffarello, A., & De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53, 1–66. https://doi.org/10.1145/3571810

Montag, C., Lachmann, B., Herrlich, M., & Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), 2612. https://doi.org/10.3390/ijerph16142612

Motta-Filho, M. A. (2021). Brand experience manual: Bridging the gap between brand strategy and customer experience. *Review of Managerial Science, 15*(5), 1173–1204. https://doi.org/10.1007/s11846-020-00399-9

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

O’Rear, A. E., & Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

Peña-Albert, A. K., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C., & Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, e85349. https://doi.org/10.2196/85349

Radtke, T., Apel, T., Schenkel, K., Keller, J., & von Lindern, E. (2022). Digital detox: An effective solution in the smartphone era? A systematic literature review. *Mobile Media & Communication, 10*(2), 190–215. https://doi.org/10.1177/20501579211028647

Risko, E. F., & Gilbert, S. J. (2016). Cognitive offloading. *Trends in Cognitive Sciences, 20*(9), 676–688. https://doi.org/10.1016/j.tics.2016.07.002

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Seeed Studio. (2026). *Getting started with Seeed Studio XIAO nRF52840 series*. https://wiki.seeedstudio.com/XIAO_BLE/

Silverman, J., & Barasch, A. (2023). On or off track: How (broken) streaks affect consumer decisions. *Journal of Consumer Research, 49*(6), 1095–1117. https://doi.org/10.1093/jcr/ucac029

Smit, E. S., Zeidler, C., Resnicow, K., & de Vries, H. (2019). Identifying the most autonomy-supportive message frame in digital health communication: A 2 × 2 between-subjects experiment. *Journal of Medical Internet Research, 21*(10), e14074. https://doi.org/10.2196/14074

Sohn, T., Li, K. A., Lee, G., Smith, I., Scott, J., & Griswold, W. G. (2005). Place-Its: A study of location-based reminders on mobile phones. En M. Beigl, S. Intille, J. Rekimoto, & H. Tokuda (Eds.), *UbiComp 2005: Ubiquitous computing* (Lecture Notes in Computer Science, Vol. 3660, pp. 232–250). Springer. https://doi.org/10.1007/11551201_14

Stapley, E., O’Keeffe, S., & Midgley, N. (2022). Developing typologies in qualitative research: The use of ideal-type analysis. *International Journal of Qualitative Methods, 21*, 1–9. https://doi.org/10.1177/16094069221100633

Subsecretaría de Telecomunicaciones. (2025). *Informe final: Estudio duodécima encuesta sobre acceso, usos y usuarios de internet en Chile*. Ministerio de Transportes y Telecomunicaciones, Gobierno de Chile. https://www.subtel.gob.cl/wp-content/uploads/2026/02/Informe-Final-Acceso-y-Uso-Internet-2025_03.pdf

Subsecretaría de Telecomunicaciones. (2026, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Tonietto, G. N., Malkoc, S. A., Reczek, R. W., & Norton, M. I. (2021). Viewing leisure as wasteful undermines enjoyment. *Journal of Experimental Social Psychology, 97*, 104198. https://doi.org/10.1016/j.jesp.2021.104198

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Ward, E., Yang, S., Romaniuk, J., & Beal, V. (2020). Building a unique brand identity: Measuring the relative ownership potential of brand identity element types. *Journal of Brand Management, 27*(4), 393–407. https://doi.org/10.1057/s41262-020-00187-6

Waggoner, J., Lucky, S., Redick, S., Rizki, A., & Yu, J. C. (2026). Going beyond digital libraries: A literature review of phygital user experience research methods. *International Journal on Digital Libraries, 27*(1), Artículo 1. https://doi.org/10.1007/s00799-025-00436-6

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 24 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold


# Glosario

**Arquitectura de atención.** Conjunto de decisiones de interfaz que orientan lo que se percibe y cómo avanza la interacción, como el desplazamiento infinito o la reproducción automática.

**Armar y desarmar.** Confirmar que el sistema está preparado para emitir la señal durante un ciclo, o retirar esa autorización.

**Bluetooth de baja energía (BLE).** Comunicación inalámbrica de corto alcance y bajo consumo con la que la aplicación enviaría órdenes al testigo.

**Ciclo.** Periodo durante el cual una intención y su regla de activación permanecen vigentes.

**Conflicto entre metas.** Tensión que aparece cuando una actividad dificulta otra también valorada, sin establecer cuál debe prevalecer.

**Decisión renovada.** Momento en que la persona vuelve a considerar si desea continuar, cambiar o detenerse.

**Descarga cognitiva.** Uso de un recurso externo, como una nota o una alarma, para conservar información que habría que mantener en la memoria; cuando se trata de una acción futura, descarga de intenciones.

**Episodio.** Unidad de análisis de las entrevistas: una situación concreta con un inicio, una actividad, un propósito, otras intenciones posibles y una valoración posterior.

**Fidelidad.** Grado de semejanza de un prototipo con el uso previsto.

**Fricción.** Esfuerzo adicional introducido en una interfaz, como esperar o confirmar, que puede abrir una reconsideración.

**Intención de implementación.** Plan que vincula una situación anticipada con una respuesta: «si ocurre X, haré Y».

**Interacción tangible.** Campo que incorpora objetos físicos a la representación o manipulación de información.

**Memoria prospectiva.** Capacidad de recordar una acción que se quiere realizar en el futuro cuando aparece la ocasión adecuada.

**Ocio digital.** Actividades mediadas por dispositivos que una persona realiza en su tiempo disponible para descansar, entretenerse, satisfacer su curiosidad o vincularse con otros.

**Phygital.** Experiencia que integra componentes físicos y digitales con funciones complementarias, evaluados como un solo sistema.

**Precompromiso.** Decisión previa que restringe deliberadamente las opciones futuras, como bloquear aplicaciones hasta volver a un objeto.

**Primer paso.** Acción breve, concreta y disponible con la que puede comenzar una actividad elegida; en la interfaz se pregunta «¿Cómo podrías empezar?».

**Pulso ambiental.** Señal física breve de luz y sonido que llama la atención sin dar una instrucción.

**Testigo.** Nombre técnico del objeto físico de Relevo, que se sitúa junto al primer paso y emite el pulso.

**Tipo ideal.** Modelo analítico que reúne rasgos recurrentes de varios casos sin convertirlos en perfiles permanentes.

**Usuario principal y usuario límite.** Situaciones de uso, no identidades: en la primera, una intención alternativa pierde presencia; en la segunda, el ocio digital conserva sentido y no corresponde intervenir.

---

## Registro de cambios

### 25 de septiembre de 2026 — Revisión editorial según la pauta UDP

- **Cambio:** los preliminares siguen la [pauta de presentación de memorias de la UDP](https://bibliotecas.udp.cl/wp-content/uploads/2020/04/tesis_pauta_udp_2020.pdf): portada con nota de título, unidad académica, lugar y fecha (profesor guía y denominación del título por completar); resumen y *abstract* con objetivo, metodología y resultados; índice de tablas y de figuras. Las cinco tablas y la figura tienen número y título según APA 7. Los ocho criterios del capítulo 9 se nombran C1–C8, como en la matriz de trazabilidad. Se añadió un glosario después de las referencias. Las conclusiones responden la pregunta, declaran que la hipótesis sigue sin contrastarse, enumeran límites y recomiendan un orden de trabajo. Se reescribieron los capítulos 1–10 y 13 para reducir repeticiones («permite» pasó de 48 a 31 usos y las negaciones defensivas de unas 40 a 12) y unir párrafos fragmentados. El segmento previo a referencias queda en 14.804 palabras.
- **Versión anterior:** la portada no tenía los datos que exige la pauta; el resumen no explicitaba objetivo ni resultados; las tablas no tenían título; el capítulo 9 hablaba de criterios sin numerarlos y las conclusiones no juzgaban la hipótesis.
- **Motivo:** el autor pidió perfeccionar y redactar mejor la memoria comparándola con otras. Como las memorias de otros estudiantes no se guardan en el repositorio, se usaron como referencia la pauta oficial de la UDP y las versiones anteriores de la propia memoria.
- **Alcance:** no cambian los datos, las fuentes, la pregunta, la hipótesis, los objetivos ni los umbrales. No se añadieron resultados.

### 25 de septiembre de 2026 — Estado del soporte actualizado

- **Cambio:** la tabla de continuidad de la experiencia (capítulo 11) indica lo que ya implementa la app 2.6: consentimiento con responsable, contacto y plazo; preparación y permisos; tono y silencio; y solicitud de eliminación, todavía sin comprobar.
- **Versión anterior:** la tabla describía el contacto del responsable como pendiente y la preparación como solo diseñada, estado anterior a la app.
- **Motivo:** alinear la memoria con los documentos operativos actualizados el mismo día, sin presentar implementación como validación.
- **Alcance:** no se añadieron resultados; la extensión se mantiene en torno a 15.100 palabras.

### 25 de septiembre de 2026 — Verificación de fuentes, corpus y prototipo; revisión de redacción

- **Cambio:** se verificaron las 64 referencias frente a Crossref, los textos oficiales y los sitios citados. Se corrigieron el apellido de Peña-Albert et al. (2026), el número de artículo de Lyngs et al. (2019), el número no verificable de Haliburton et al. (2024), las direcciones de Google Play y Kitchen Safe, el año del informe de la Subsecretaría de Telecomunicaciones (2025) y tres números de revista. Se precisaron hallazgos de De Segovia Vicente et al., Monge Roffarello y De Russis, Biedermann et al., Grüning et al., Haliburton et al., Chiu y Gilbert, O’Rear y Radvansky y Pause Point. En el capítulo 7 se corrigieron la descripción de P2, la de la pregunta Q13 y la atribución del rechazo a comparaciones entre días (solo P7), y se declararon el rango de convocatoria y la pérdida de las notas de Q12–Q13. Los capítulos 9–13 describen ahora el prototipo Android 2.6 (varias aplicaciones, salida por parlante o teléfono, confirmación autodeclarada, consentimiento y eliminación sin verificar) y una etapa previa de comprobación y evaluación formativa. Se eliminaron repeticiones entre los capítulos 5, 6, 7, 8, 11 y 12. El segmento previo a referencias queda en 15.111 palabras según `wc -w`.
- **Versión anterior:** algunas referencias tenían datos erróneos o direcciones que ya no llevaban al documento citado; ciertas paráfrasis de entrevistas ampliaban lo dicho por los participantes; la memoria describía una sola aplicación y un parlante como única salida, y presentaba el programa de micro:bit con verbos de funcionamiento actual. Varios estudios se explicaban dos o tres veces.
- **Motivo:** revisión completa solicitada por el autor para corregir fallas, mejorar la escritura y comprobar que todas las fuentes sean reales. El detalle está en la [revisión integral del 25 de septiembre](revision-integral-fuentes-y-redaccion-2026-09-25.md).
- **Alcance:** se conservan los catorce títulos, la pregunta, la hipótesis, los objetivos, los criterios y los umbrales. No se añadieron resultados con participantes ni pruebas físicas, porque no existen.

### 23 de septiembre de 2026 — Aplicación crítica del feedback docente

- **Cambio:** se separaron recuperación de la intención, inicio de la actividad y formación de hábitos; se abrió la posibilidad de estudiar reconocimiento positivo sin presentar rachas como requisito ni como mecanismo siempre perjudicial. Se corrigió la descripción del almacenamiento local y remoto y la diferencia entre el parlante Bluetooth actual y el testigo controlado por una orden. Se retiraron recapitulaciones repetidas sin cambiar los títulos, las fuentes ni los criterios; el cuerpo previo a referencias queda en 14.997 palabras según `Measure-Object -Word`.
- **Versión anterior:** la exclusión de rachas y recompensas era absoluta; el apartado de privacidad describía solo datos locales y una eliminación aún no verificada como si fuera parte del prototipo; la factibilidad presentaba el enlace BLE como ruta ya integrada. Algunos cierres de secciones repetían conclusiones ya desarrolladas y el texto superaba el límite aproximado de 15.000 palabras.
- **Motivo:** responder a las anotaciones del 23 de septiembre sin convertir hipótesis, funciones futuras o autoinformes en resultados. Las referencias sobre hábitos y rachas delimitan preguntas de diseño, no prueban eficacia de Relevo.
- **Alcance:** revisión escrita y documental. No se incorporaron rachas, premios ni mensajes de seguimiento a la aplicación; no se completaron pruebas físicas, consentimiento definitivo ni resultados con participantes.

### 16 de septiembre de 2026 — Sistema de marca adoptado

- **Cambio:** el capítulo 11 fija Relevo como nombre del proyecto, incorpora la frase y el descriptor vigentes, y adopta Source Sans 3 y la paleta verde-neutra como sistema común.
- **Versión anterior:** nombre, descriptor, tipografía y color permanecían como candidatos de una primera variante.
- **Motivo:** la etapa actual requiere decisiones consistentes para producir el proyecto; las pruebas posteriores deben detectar problemas concretos y no mantener indefinidamente abiertas todas las alternativas.
- **Límite:** estas son decisiones de diseño fundamentadas. No demuestran comprensión, preferencia, desempeño ni eficacia con usuarios.

### 15 de septiembre de 2026 — Estrategia de marca reconstruida

- **Cambio:** el capítulo define primero el marco de referencia, la diferencia provisional y la conducta del producto; retira la frase sobre transferencia, reabre el color de marca y trata `primer paso` como hipótesis transversal.
- **Versión anterior:** el nombre, el turquesa y el lenguaje se justificaban mediante la idea de que una intención cambiaba de soporte.
- **Motivo:** esa explicación era abstracta y confundía arquitectura técnica, experiencia e identidad; la marca debe partir de una posición comprensible y verificable.
- **Alcance:** se incorporan cinco referencias de marca y producto. No se acreditan comprensión, reconocimiento ni eficacia.

### 15 de septiembre de 2026 — Lenguaje y relato de marca

- **Cambio:** el capítulo 11 define el relato de transferencia entre soportes, conserva `primer paso` como concepto analítico, adopta `¿Cómo podrías empezar?` como texto de interfaz y explica el turquesa como color de presencia.
- **Versión anterior:** el descriptor utilizaba `primer paso` como lenguaje público y la paleta se justificaba principalmente por funciones de interfaz.
- **Motivo:** relacionar nombre, lenguaje y color con la conducta real del sistema, sin presentar vocabulario interno ni asociaciones cromáticas universales como evidencia de usuario.
- **Alcance:** son hipótesis para prototipar y comparar; no modifican los resultados de investigación ni acreditan comprensión o reconocimiento.

### 2026-09-15 — Primera hipótesis visual especificada

- **Cambio:** el capítulo registra Presencia útil, Source Sans 3, una paleta neutra con acento verde turquesa y el descriptor «Una señal cerca de tu primer paso».
- **Versión anterior:** después del reinicio, la memoria solo declaraba criterios funcionales y mantenía tipografía y color sin una hipótesis concreta.
- **Motivo:** permitir que la interfaz y la comunicación se comparen mediante prototipos verificables, sin presentar decisiones formales como resultados.
- **Alcance:** no se cierra la identidad, el símbolo, la forma física ni el color de la señal; tampoco se añaden resultados de validación.

### 2026-09-11 — Nombre y criterios visuales abiertos a prueba

- **Cambio:** se reemplazaron el descriptor, la paleta y las tipografías presentadas como vigentes por criterios funcionales para aplicación, testigo, marca y memoria.
- **Versión anterior:** el capítulo fijaba carbón, papel cálido, grises y ámbar, y remitía a una dirección gráfica retirada.
- **Motivo:** las decisiones visuales deben seguir a la comparación y a las pruebas de comprensión, legibilidad y percepción.
- **Alcance:** el nombre Relevo continúa como denominación académica provisional; no se modifican el problema, el flujo ni la arquitectura técnica.


### 2026-09-09 — Limpieza y vigencia documental

- **Cambio:** se corrigieron la URL y la fecha de consulta de la referencia oficial sobre vinculación de dispositivos Android.
- **Antes:** la dirección omitía el segmento `bluetooth` y respondía con una página no encontrada.
- **Motivo:** restablecer el acceso a la misma documentación oficial sin cambiar el argumento académico.
- **Alcance:** Revisión documental; no añade resultados ni modifica el protocolo o los artefactos.

### 2026-09-09 — Ajuste al límite aproximado de 15.000 palabras

- **Cambio:** se condensaron repeticiones entre antecedentes, teoría, referentes, sistema y conclusiones. El texto académico previo a la bibliografía queda en 15.033 palabras.
- **Versión anterior:** el mismo segmento contenía 17.920 palabras; los capítulos 1–13 sumaban 17.252.
- **Motivo:** cumplir el límite aproximado solicitado por el autor sin debilitar la lectura ni retirar fuentes.
- **Alcance:** el conteo incluye preliminares y capítulos 1–13; excluye bibliografía y registro administrativo. Se conservan títulos, citas, tablas, pregunta, hipótesis y umbrales de validación.

### 2026-09-09 — Lectura continua y jerarquía editorial

- **Cambio:** se agruparon apartados breves bajo títulos temáticos sin numeración secundaria; se reescribieron transiciones, formulación y explicaciones técnicas. El método de entrevistas conserva continuidad y el proceso de desarrollo se reúne en el capítulo 13.
- **Versión anterior:** los capítulos contenían numerosos subapartados de uno a tres párrafos y un tercer nivel de numeración; la encuesta pendiente interrumpía el método y el proceso de diseño repetía el plan de validación.
- **Motivo:** facilitar una lectura académica continua para quien no conoce Relevo ni su documentación interna.
- **Alcance:** se conservan los catorce capítulos, las fuentes y los límites de evidencia; no se modifica el protocolo ni se añaden resultados.

### 2026-09-09 — Coherencia de la memoria y alcance de cierre

- **Cambio:** Se alinearon secuencia, estados, banco y protocolo; se incorporaron continuidad del servicio y comunicación; se acotó la comparación digital y se separó autonomía de asociación.
- **Versión anterior:** la memoria y sus controles no reflejaban de manera uniforme el alcance de la prueba y las decisiones documentadas.
- **Motivo:** mantener continuidad entre investigación, experiencia, construcción y evaluación antes de ampliar el proyecto.
- **Alcance:** Se mantienen los catorce capítulos y la formulación desde el capítulo 10. Una nueva fuente metodológica sustenta la lectura de servicio; no se añaden resultados ni se cambia el protocolo.

### 2026-09-08 — Compatibilidad material de la prueba micro:bit

- **Cambio:** se distinguió la matriz roja utilizada en el banco técnico de la luz blanca cálida externa requerida para evaluar comprensión, y se añadió la fuente técnica correspondiente.
- **Versión anterior:** la matriz integrada aparecía como fuente luminosa de la primera etapa sin advertir que su color no coincidía con la señal descrita en el protocolo.
- **Motivo:** mantener correspondencia entre arquitectura, material de prueba y afirmaciones académicas, sin atribuir a una plataforma una capacidad que no posee.
- **Alcance:** el programa compila, pero no ha sido instalado ni medido; no se añadieron resultados ni se habilitaron participantes.

### 2026-09-07 — Ruta física portátil sincronizada

- **Cambio:** se actualizó la bajada proyectual, la arquitectura técnica, los costos, el plan de pruebas y las conclusiones para distinguir una plataforma de ensayo de la integración portátil con XIAO nRF52840.
- **Versión anterior:** la memoria presentaba B1/B2 con XIAO ESP32-C3 y alimentación de 5 V como siguiente comprobación, mantenía abiertos los canales de salida y no incorporaba un precedente constructivo para la versión compacta.
- **Motivo:** alinear el texto académico con D-045 y D-047, reducir trabajo inicial sin permitir que una placa educativa defina el producto y mantener trazabilidad entre factibilidad y propuesta.
- **Alcance:** se seleccionan luz y sonido como salidas y una arquitectura candidata para prototipar; no se declaran forma, costo, autonomía, percepción ni funcionamiento validados. No se autorizó una compra.

### 2026-09-02 — Encuesta complementaria registrada

- **Cambio:** se añadió una nota en el capítulo 7 para dejar constancia de una encuesta de 70 participantes pendiente de publicación y revisión.
- **Motivo:** actualizar la memoria con una fuente potencial sin presentar sus resultados como evidencia ni mezclarlos con el corpus cualitativo P1–P8.
- **Alcance:** la encuesta todavía no modifica hallazgos, decisiones, conclusiones ni la formulación; primero deben documentarse sus materiales, procedencia, consentimiento, anonimización y análisis.

### 2026-08-31 — Revisión final de vigencia y continuidad narrativa

- **Cambio:** se retiraron dos pasajes que explicaban la organización del documento en vez de desarrollar el argumento; la transición entre teoría y entrevistas ahora se concentra en la pauta de observación derivada del marco teórico.
- **Versión anterior:** la introducción describía el orden de los capítulos y el cierre del marco teórico anunciaba cuándo debían aparecer los criterios y la formulación.
- **Motivo:** mantener una lectura académica centrada en el fenómeno y evitar metalenguaje innecesario.
- **Cambio:** la pregunta adicional Q13 se describe como una propuesta preliminar de señal ambiental, sin trasladar al cuerpo académico el nombre de una etapa histórica.
- **Versión anterior:** el capítulo 7 nombraba In(Visible) y explicaba su relación temporal con Relevo.
- **Motivo:** conservar la procedencia metodológica relevante sin convertir la evolución interna del proyecto en parte de la argumentación.
- **Cambio:** la factibilidad técnica y económica se sincronizó con la comparación B1/B2 del 30 de agosto; se añadieron las rutas activas de 5 V, sus montos incompletos, sus exclusiones y los enlaces al desglose verificable.
- **Versión anterior:** la memoria presentaba una arquitectura genérica y un rango global de CLP 59.000–107.000 que ya no permitía reconstruir qué partidas correspondían al ensayo vigente.
- **Motivo:** distinguir desembolso experimental, costo del prototipo, trabajo profesional, producción y precio sin comunicar una precisión inexistente.
- **Cambio:** en las conclusiones, `wireframes` se reemplazó por `arquitectura de interacción`.
- **Versión anterior:** el cierre nombraba el formato utilizado para representar el recorrido.
- **Motivo:** comunicar el aporte proyectual y su límite, no la herramienta con que fue documentado.
- **Cambio:** se acotaron generalizaciones sobre herramientas y mercado al corpus revisado, se eliminaron precios comerciales ambiguos y se declaró explícitamente que la arquitectura de uso aún no está implementada.
- **Versión anterior:** algunos pasajes podían convertir una oferta comercial en evidencia de demanda o describir funciones proyectadas mediante verbos de funcionamiento actual.
- **Motivo:** separar funciones declaradas, evidencia comercial, comportamiento previsto y resultados comprobados.
- **Alcance:** no se añadieron resultados, no se cerró la condición de activación ni se seleccionaron señal, forma, material o arquitectura electrónica final.

### 2026-08-30 — Asociación y control separados

- **Cambio:** se mantuvieron cuatro momentos para reconstruir la asociación y se añadió el control como condición independiente de autonomía.
- **Versión anterior:** la memoria nombraba cuatro momentos, mientras el protocolo incluía el control como un quinto componente de la asociación completa.
- **Motivo:** evitar que comprender las salidas altere la medición del recuerdo y, al mismo tiempo, impedir el avance cuando ignorar o silenciar no resulta claro.
- **Alcance:** no se modificaron la muestra, los resultados —todavía inexistentes— ni la exigencia de no presentar la acción posterior como cumplimiento.

**27 de agosto de 2026 — Muestra y umbrales del primer protocolo.** La muestra formativa se fijó en seis personas y los porcentajes se tradujeron a cinco casos para avanzar, tres o cuatro para modificar y dos o menos para detener la configuración después de una iteración. Antes, el rango de seis a ocho participantes dejaba ambiguo el número exacto necesario en cada decisión. No se han reclutado participantes ni recogido datos.

**27 de agosto de 2026 — Reglas operativas previas a la primera prueba.** Se definieron la asociación completa, los umbrales formativos de avance, modificación y detención, la comparación entre soportes y los fallos críticos que impiden continuar. Antes, el capítulo 13 identificaba variables, pero dejaba la interpretación abierta hasta después de obtener resultados. En ese momento, el protocolo todavía mantenía abiertos participantes, tiempos, canal y gestión de registros; esos parámetros se cerraron en la revisión siguiente.

**27 de agosto de 2026 — Selección y enlace de anexos.** Se incorporaron dos referencias al índice de anexos y se definió un paquete formal para método, corpus, análisis de usuarios, mercado y arquitectura de interacción. Antes, esos documentos existían en distintas carpetas sin una selección editorial común. No se duplicaron archivos ni se añadieron informes de agentes, código, versiones antiguas o resultados inexistentes.

**27 de agosto de 2026 — Separación entre datos del sistema y registros de investigación.** Se aclaró que Relevo conserva únicamente la información necesaria para ejecutar el ciclo y no registra la conducta posterior al pulso. Las fichas, observaciones y errores recogidos durante las pruebas pertenecen a protocolos temporales con consentimiento y participantes codificados. Antes, ambas capas aparecían en capítulos distintos sin una frontera explícita y podían parecer contradictorias. La corrección no define todavía plazos de conservación ni instrumentos finales.

**27 de agosto de 2026 — Clasificación del cierre académico.** Las conclusiones distinguen ahora condiciones respaldadas por la investigación, decisión proyectual, aporte alcanzado, hipótesis pendiente y criterio de continuidad. Antes, la propuesta de valor y el aporte del objeto aparecían en un mismo párrafo y podían leerse como resultados demostrados. Se mantiene el carácter phygital como medio del proyecto; lo que debe probarse es el valor específico de la relación entre sus componentes.

**27 de agosto de 2026 — Trazabilidad individual de los criterios de diseño.** Cada criterio del capítulo 9 incorpora ahora su fundamento más próximo en literatura, entrevistas o estado del arte. Antes, el capítulo declaraba que los criterios provenían de la investigación, pero el lector debía reconstruir esa relación en secciones anteriores. Se mantuvieron los ocho criterios y su sentido original; la revisión no los convierte en resultados validados ni cierra las decisiones que requieren pruebas.

**27 de agosto de 2026 — Correspondencia APA 7 y orden bibliográfico.** Se completó la comprobación entre las citas del cuerpo y las 49 entradas de la lista de referencias. No se encontraron citas sin referencia ni referencias huérfanas. Se corrigieron el orden de una cita parentética, la posición alfabética de Kirsh, Kitchen Safe, one sec y O’Rear, y los sufijos 2026a/2026b de la Subsecretaría de Telecomunicaciones según el orden alfabético de los títulos. Antes, esas cuatro inconsistencias impedían declarar cerrado el control bibliográfico.

**26 de agosto de 2026 — Accesibilidad conceptual.** Se explicaron en su primera aparición los conceptos metodológicos y técnicos indispensables para comprender el análisis y la factibilidad: estudio cualitativo exploratorio, método Framework, tipos ideales, precompromiso, Bluetooth de baja energía, ejecución en segundo plano, fidelidad de prototipo, UsageStatsManager, Web Bluetooth, marcos de Apple, microcontrolador, actuador, contingencia, merma, servicio en primer plano, habituación y escalas breves. Antes, varios nombres aparecían sin indicar su función para el proyecto. Las explicaciones se integraron en las frases existentes y no modifican decisiones técnicas ni resultados.

**26 de agosto de 2026 — Orden narrativo de antecedentes y marco teórico.** Los capítulos 5 y 6 se limitaron a explicar antecedentes, relaciones conceptuales y preguntas abiertas. Antes, algunos cierres convertían el primer paso, la condición observable, la señal y la distribución phygital en requisitos antes de presentar usuarios, referentes y criterios. Se conservaron los conceptos necesarios, pero su traducción proyectual quedó reservada para los capítulos 9 y 10. También se restituyeron los títulos históricos de los ámbitos 2 y 3 y de las conclusiones del marco teórico, sin recuperar las afirmaciones desactualizadas de la memoria anterior.

**26 de agosto de 2026 — Vigencia y alcance del mercado.** Se aclaró que las seis familias del estado del arte son una clasificación analítica del proyecto y no una taxonomía universal. La comparación de Screenless registra ahora la contradicción de su sitio sobre Android; Focusaur distingue el despacho estadounidense de su tienda europea, y kSafe se mantiene como antecedente de mecanismo sin afirmar stock ni distribución en Chile. Antes, estas condiciones podían leerse como disponibilidades más amplias de lo que permiten las fuentes. La revisión no modifica la oportunidad de diseño ni presenta información comercial como evidencia de eficacia.

**26 de agosto de 2026 — Trazabilidad del estado del arte.** El apartado 8.1 enlaza ahora el registro metodológico y declara con precisión qué información conserva: pregunta, familias de términos, fuentes, criterios, corpus nuclear y límites. Antes, la memoria resumía el método, pero no permitía acceder directamente al documento que lo sustenta ni advertía que no existen consultas literales, buscadores y conteos completos. La corrección no añade referentes ni convierte la revisión exploratoria en una revisión sistemática.

**26 de agosto de 2026 — Trazabilidad de entrevistas.** Se añadieron identificadores P/Q a los hallazgos de los apartados 7.3, 7.4 y 7.5, y se explicó su función metodológica. Antes, el capítulo identificaba participantes, pero obligaba a reconstruir manualmente qué preguntas sostenían cada paráfrasis. La revisión corrigió dos sobreextensiones: P3 describió una pausa ambivalente, no una experiencia agradable, y P6 no declaró en Q12 una estrategia de separación. También se acotó Q13 al concepto histórico In(Visible): sus respuestas solo orientan criterios generales de calma, discreción y representación visual; no sostienen preferencias formales ni validan Relevo. No se incorporaron citas literales nuevas ni se modificaron las respuestas del corpus.

**26 de agosto de 2026 — Conclusiones.** El apartado 13.8, antes titulado “Síntesis del proyecto”, fue reemplazado por un cierre académico que responde la pregunta de investigación según el nivel de evidencia disponible. La versión anterior resumía el funcionamiento y declaraba que su valor debía probarse, pero no reunía hallazgos, aporte disciplinar, límites y criterio de continuidad. La nueva redacción distingue lo que sostienen la literatura, las entrevistas y la estructuración proyectual de aquello que requiere prototipado. Se mantuvieron los catorce capítulos de la arquitectura histórica y no se incorporaron resultados inexistentes.

**26 de agosto de 2026 — Pregunta de investigación.** Se incorporó una pregunta explícita entre el punto de vista y la oportunidad de diseño. Antes, el capítulo pasaba directamente desde la caracterización de la necesidad hacia la oportunidad, por lo que la relación investigada solo podía inferirse desde la hipótesis y los objetivos. La primera redacción incluía una intervención phygital dentro de la pregunta y confundía el medio del proyecto con aquello que debía comprenderse. La versión vigente pregunta por las condiciones que permitirían volver a considerar una actividad elegida; el diseño phygital se mantiene como el medio disciplinar definido para responder. También se aclara que considerar la actividad no equivale a ejecutarla ni a reducir el uso del teléfono. La numeración posterior del capítulo 10 se actualizó sin cambiar su contenido.

**26 de agosto de 2026 — Memoria vigente v4.** Se reorganizó la memoria con los mismos títulos y la misma secuencia del cierre del primer semestre. La formulación de Relevo se trasladó al capítulo 10; antes aparecía anticipada en la motivación, la introducción y apartados iniciales. La motivación se reescribió en presente y quedó limitada a la experiencia personal que origina la pregunta. Se reemplazó la expresión “continuidad digital poco deliberada” por descripciones directas de sesiones que continúan sin una decisión renovada. Se eliminaron códigos internos de prototipado y referencias al proceso de versiones dentro del cuerpo académico. También se incorporaron el análisis actualizado de mercado, los dos usuarios situacionales, la justificación de Android frente a web e iPhone, y los flujos de usuario, sistema y desarrollo. Estos cambios buscan que la propuesta aparezca como consecuencia de la investigación y que cada concepto se explique al ingresar en el relato.

**1 de septiembre de 2026 — Consistencia del naming.** El título `Objeto Relevo` se reemplazó por `El testigo`. Antes, la memoria utilizaba un nombre de producto para una capa cuya forma industrial continúa abierta, mientras los documentos de interacción ya empleaban `testigo` como denominación funcional. El cambio unifica el lenguaje sin modificar la composición phygital ni cerrar materialidad, forma o mecanismo.
