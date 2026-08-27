# Relevo

*Sistema phygital para recuperar intenciones personales durante el ocio digital*

## Memoria de Proyecto de Título

- **Disciplina:** Diseño
- **Institución:** Universidad Diego Portales
- **Estudiante:** Johan Yantén
- **Año académico:** 2026

## Resumen

El ocio digital ocupa un lugar habitual en la vida cotidiana. Conversar, jugar, mirar videos o recorrer redes sociales pueden ser formas legítimas de descanso y entretención. Sin embargo, algunas sesiones se prolongan sin que la persona vuelva a decidir si quiere continuar. En esos momentos, una actividad que también deseaba realizar puede dejar de estar presente justo cuando todavía era posible comenzarla. El problema no radica en el teléfono ni en una cantidad universal de minutos, sino en la dificultad de recuperar una intención propia dentro de una interacción que ofrece contenido de manera continua.

La investigación reúne bibliografía sobre ocio, conflicto entre metas, bienestar digital, recuerdo de acciones futuras y uso de objetos físicos para interactuar con información. También considera ocho entrevistas semiestructuradas realizadas a personas de 19 a 27 años y un análisis de herramientas que miden, interrumpen o bloquean el uso del teléfono. Los antecedentes muestran que las experiencias digitales no pueden juzgarse solo por su duración y que las respuestas existentes se concentran, principalmente, en limitar la actividad presente. A partir de esta revisión se distinguen dos situaciones de uso: aquella en que una intención alternativa pierde presencia y aquella en que la actividad digital conserva sentido, por lo que interrumpirla sería improcedente.

Relevo se formula como un sistema phygital que vincula una aplicación Android con un objeto situado cerca del primer paso de una actividad elegida. Cuando se cumple una condición configurada por la persona, el objeto emite una señal ambiental breve. Su propósito es hacer nuevamente perceptible la intención, sin bloquear el teléfono ni decidir qué debe ocurrir después. La propuesta se entiende como una hipótesis de diseño que deberá comprobar su aporte frente a una notificación digital equivalente.

**Palabras clave:** ocio digital, memoria prospectiva, autonomía, diseño phygital.

## Abstract

Digital leisure has become part of everyday life. Talking to others, playing games, watching videos, or browsing social media can be legitimate forms of rest and entertainment. Nevertheless, some sessions continue without the person making a renewed decision to remain engaged. At such moments, another activity they intended to pursue may no longer come to mind while there is still time to begin it. The issue does not lie in the phone itself or in a universal amount of time, but in the difficulty of recovering a personal intention within an interaction that continuously offers more content.

This study draws on literature about leisure experience, goal conflict, prospective memory, digital wellbeing, and tangible interaction. It also considers eight semi-structured interviews with people aged 19 to 27 and an analysis of tools that measure, interrupt, or block phone use. The evidence suggests that digital experiences cannot be assessed through duration alone and that existing responses largely focus on restricting the current activity. Two use situations emerge from the analysis: one in which an alternative intention loses salience, and another in which the digital activity remains meaningful and should not be interrupted.

Relevo is formulated as a phygital system linking an Android application to an object placed near the first step of a chosen activity. When a user-defined condition is met, the object emits a brief ambient signal. Its purpose is to make the intention perceptible again without blocking the phone or deciding what should happen next. The proposal is presented as a design hypothesis whose contribution must be assessed against an equivalent digital notification.

**Keywords:** digital leisure, prospective memory, autonomy, phygital design.

## Índice

1. Motivación personal.
2. Introducción.
3. Planteamiento del problema.
4. Justificación.
5. Antecedentes y estado de la cuestión.
6. Marco teórico por ámbitos.
7. Usuario, contexto y hallazgos de entrevistas.
8. Estado del arte y referentes.
9. Criterios de diseño.
10. Formulación.
11. Bajada proyectual.
12. Factibilidad y límites.
13. Plan de desarrollo y validación.
14. Referencias.

# 1. Motivación personal

Me ocurre con frecuencia abrir una aplicación para descansar unos minutos y permanecer en ella más tiempo del que imaginaba. Al cerrarla, descubro que otras actividades que también quería realizar —dibujar, leer, caminar o preparar algo con calma— dejaron de estar presentes durante ese intervalo. No siempre decido abandonarlas; simplemente dejan de participar en lo que hago.

Esta experiencia no me lleva a pensar que todo uso del teléfono sea negativo. Muchas veces encuentro allí entretención, conversación, información o un descanso que valoro. Lo que me inquieta es la diferencia entre elegir continuar y darme cuenta, después, de que no volví a considerar mis otras intenciones.

Me interesa observar ese momento sin convertirlo en un juicio sobre disciplina o productividad. Quiero comprender por qué una intención personal puede perder presencia, qué condiciones favorecen esa situación y de qué manera el Diseño puede ayudar a que vuelva a ser considerada. La pregunta nace de una experiencia cercana, pero también de la necesidad de respetar que descansar, cambiar de actividad o seguir frente al teléfono pueden ser decisiones igualmente válidas.

# 2. Introducción

Los teléfonos inteligentes reúnen comunicación, información, trabajo y entretenimiento en un mismo dispositivo. Su incorporación a la vida cotidiana ha cambiado la forma de organizar el tiempo y también la manera de descansar. Una persona puede conversar con amistades, escuchar música, jugar, mirar una serie o recorrer una red social sin cambiar de soporte. Esta diversidad impide tratar el uso del teléfono como una experiencia única y vuelve insuficiente cualquier evaluación basada solamente en la duración.

El ocio digital se entiende aquí como el conjunto de actividades mediadas por dispositivos que una persona realiza en su tiempo disponible con fines de descanso, entretención, curiosidad o vínculo social. No se opone necesariamente a otras formas de ocio ni debe justificarse por su utilidad. Una sesión extensa puede ser satisfactoria y coherente con lo que alguien desea hacer. Del mismo modo, una sesión breve puede sentirse inoportuna si desplaza una actividad que la persona consideraba importante. La diferencia depende del propósito, el contexto y la valoración de quien vive la experiencia (Lukoff et al., 2018; Meier & Reinecke, 2021).

Dentro de ese marco aparece una situación específica. Al comenzar una actividad digital, la persona puede tener presente otra intención: salir a caminar, leer, dibujar, ordenar un espacio, dormir o conversar con alguien. Aun así, la sesión continúa y esa alternativa deja de orientar el siguiente paso. Cuando vuelve a recordarla, la ocasión puede haber cambiado o el tiempo disponible puede ser menor. No se trata necesariamente de olvidar por completo ni de perder el control. Se trata de que una intención propia no estuvo disponible en el momento en que podía influir en la decisión.

Algunas interfaces favorecen la continuidad. El **desplazamiento infinito** es un patrón que carga contenido nuevo a medida que la persona avanza, sin presentar un final de página claramente marcado. La reproducción automática y las recomendaciones encadenadas cumplen una función semejante: el siguiente contenido aparece sin exigir una elección nueva. Estas características no determinan por sí solas la conducta, pero reducen los puntos de cierre y mantienen disponible la acción actual (de Segovia Vicente et al., 2024; Montag et al., 2019).

La respuesta habitual frente a esta situación ha sido medir el tiempo, fijar límites, bloquear aplicaciones o introducir pausas antes de abrirlas. Tales recursos pueden ser útiles cuando alguien quiere reducir una conducta concreta. Sin embargo, detener la actividad presente no basta para recuperar aquello que se quería hacer. Un bloqueo puede cerrar una aplicación y, al mismo tiempo, dejar ausente la intención alternativa. También puede interrumpir una conversación o un descanso que la persona sí desea mantener. Por eso resulta necesario distinguir entre impedir una acción y volver perceptible otra posibilidad.

La memoria prospectiva permite precisar esta diferencia. El concepto se refiere a la capacidad de recordar una acción que se quiere realizar en el futuro cuando aparece una ocasión adecuada (McDaniel & Einstein, 2000). Recordar al final del día que se quería leer no equivale a recuperar esa intención cuando todavía existía la oportunidad de abrir el libro. Desde esta perspectiva, el problema no consiste en almacenar una meta, sino en encontrar una señal pertinente que ayude a traerla de vuelta al presente.

Esta investigación pregunta cómo puede el Diseño apoyar la recuperación oportuna de una intención personal durante una sesión de ocio digital, sin prohibir la actividad actual ni imponer una jerarquía entre formas de descanso. Para responder, es necesario estudiar la experiencia subjetiva del ocio, las decisiones de interfaz que sostienen la continuidad, el papel del contexto y las formas en que las personas delegan parte del recuerdo en objetos, notas o alarmas. También es indispensable conocer qué soluciones existen, qué problemas resuelven y qué aspectos dejan abiertos.

La secuencia de la memoria sigue ese recorrido. Primero se delimita el problema y se justifica su relevancia. Luego se revisan los antecedentes, el marco teórico, las entrevistas y el estado del arte. A partir de esa base se establecen criterios y, más adelante, se desarrolla una propuesta, su factibilidad y el plan necesario para comprobarla. De este modo, las decisiones proyectuales aparecen después de la investigación que les da sustento.

# 3. Planteamiento del problema

En 2025, el 96,6 % de los hogares chilenos declaró contar con acceso propio y pagado a internet. Entre los hogares conectados, el teléfono inteligente fue el dispositivo más extendido, con una presencia declarada de 99,1 % (Subsecretaría de Telecomunicaciones, 2026b). Estas cifras describen un entorno ampliamente conectado, pero no permiten determinar el valor de una experiencia digital. Para comprender la situación estudiada importa observar la relación entre la actividad presente, otras intenciones y el momento de elegir.

El problema se organiza en tres aristas. Cada una examina una parte de la situación y evita atribuirla a una causa única.

## 3.1 Arista experiencial y cognitiva

Una persona puede iniciar una actividad digital con un propósito claro y, mientras la realiza, mantener otras intenciones para ese mismo periodo. El conflicto aparece cuando la sesión se prolonga y alguna de esas alternativas deja de orientar la acción inmediata. Recordarla más tarde demuestra que no desapareció necesariamente de la memoria, pero también que no fue recuperada cuando podía participar en la decisión.

De Segovia Vicente et al. (2024) estudiaron el desplazamiento digital percibido como carente de propósito mediante evaluaciones cotidianas y registros del teléfono. Los episodios más prolongados se asociaron con mayor conflicto entre la actividad digital y otras metas, además de mayor culpa reportada. El estudio no demuestra causalidad ni permite considerar perjudicial toda sesión extensa. Sí muestra que la relación con otras intenciones influye en la experiencia.

La dificultad, entonces, no se define como un daño a la memoria ni como una incapacidad permanente. Se presenta en momentos concretos, cuando una intención deja de estar disponible para orientar el siguiente paso. Esta precisión permite estudiar el fenómeno sin diagnosticar a la persona y sin suponer que necesita dejar el teléfono cada vez que lo utiliza.

## 3.2 Arista tecnológica

Las sesiones digitales ocurren dentro de interfaces diseñadas. El desplazamiento infinito, la reproducción automática y las recomendaciones consecutivas reducen los momentos en que hace falta decidir si se quiere continuar. A diferencia de una página, un capítulo o una pieza con término reconocible, estos patrones mantienen abierta la secuencia y ofrecen una acción siguiente con muy poco esfuerzo (Montag et al., 2019).

El propósito, el estado de ánimo, el contexto y los hábitos también influyen. Sin embargo, explicar la experiencia únicamente como falta de disciplina omite que el diseño organiza cierres, transiciones y oportunidades de elección. Pedir confirmación, introducir una pausa o continuar sin interrupciones modifica las condiciones en que la persona decide.

Las herramientas de bienestar digital también actúan mediante decisiones de diseño. Medir, bloquear o retrasar una apertura puede ser pertinente cuando el objetivo es reducir el acceso a una aplicación. No obstante, esas acciones se concentran en la conducta presente. Cuando existe otra intención que ha perdido presencia, impedir el acceso no garantiza que esa alternativa sea recordada ni que resulte más fácil comenzar.

## 3.3 Arista evaluativa

El ocio no se valora únicamente por su duración o contenido. También intervienen las expectativas con que una persona interpreta ese tiempo. Tonietto et al. (2021) observaron que considerar el ocio como improductivo o desperdiciado disminuía su disfrute, especialmente cuando la actividad se realizaba como un fin en sí mismo. Aunque el estudio no se refiere exclusivamente al teléfono, permite comprender por qué una intervención basada en culpa o rendimiento podría empeorar la experiencia que intenta apoyar.

Dos sesiones semejantes pueden adquirir sentidos distintos. Una conversación extensa puede conservar valor afectivo; el mismo tiempo frente a una secuencia de contenidos puede sentirse incongruente con una intención previa. La diferencia no surge de una jerarquía universal entre actividades, sino de la relación que cada persona reconoce entre lo que hace y lo que quería hacer (de Segovia Vicente et al., 2024; Meier & Reinecke, 2021).

Por ello, el problema no puede resolverse imponiendo productividad. Cualquier respuesta debe respetar la posibilidad de continuar cuando esa sea todavía la elección. Recuperar una intención significa devolverla a la decisión, no transformarla en obligación.

## 3.4 Síntesis del problema

Las tres aristas describen una misma situación desde escalas complementarias. En la experiencia, una intención deja de orientar el momento oportuno. En la interfaz, la actividad actual mantiene su continuidad. En la valoración, el ocio puede convivir con disfrute, conflicto o culpa. Responsabilizar solo a la persona desconoce las condiciones de interacción; responsabilizar únicamente a la plataforma borra la diversidad de propósitos; y juzgar mediante productividad reemplaza una decisión personal por una norma externa.

El problema puede sintetizarse así: durante algunos episodios de ocio digital, una actividad continúa mientras otra intención valorada deja de estar presente en el momento de elegir qué hacer a continuación. El desafío de Diseño consiste en apoyar la recuperación de esa intención sin bloquear la actividad actual, decidir por la persona ni intervenir cuando el ocio digital conserva sentido.

# 4. Justificación

Abordar esta situación resulta relevante porque el teléfono participa de forma constante en la vida cotidiana y reúne actividades que no pueden evaluarse mediante una regla única. Las mediciones de tiempo ofrecen información útil, pero no explican si una sesión respondió al propósito de la persona ni si otra intención dejó de estar disponible. Una respuesta más precisa debe reconocer tanto el derecho a cambiar de actividad como el derecho a continuar con un descanso elegido.

La pregunta también tiene importancia preventiva. Cuando las únicas alternativas son bloquear, contabilizar o comparar, una herramienta de apoyo puede convertirse en una nueva fuente de presión. Fijar una intención no debería crear una deuda frente al sistema. Ignorar una señal, cambiar de idea o permanecer en la actividad digital son resultados posibles y legítimos. Este criterio permite abordar la autonomía mediante decisiones concretas y evita confundir ayuda con obediencia.

Desde el Diseño, el problema involucra variables propias de la disciplina: continuidad, cierre, momento, canal, jerarquía, legibilidad, fricción y control. La psicología aporta conceptos para comprender el recuerdo de acciones futuras y el conflicto entre metas; la ingeniería permite ejecutar condiciones y comunicaciones técnicas. El aporte del Diseño consiste en articular esos conocimientos en una experiencia clara, situada y respetuosa de quien la utiliza.

La pertinencia disciplinar también se relaciona con la posibilidad de distribuir una interacción entre componentes físicos y digitales. Un recordatorio situado en el entorno podría recuperar una intención fuera del mismo flujo que concentra la atención. Sin embargo, esa posibilidad no debe aceptarse de antemano. La presencia de un objeto solo se justifica si su ubicación y su forma de señalización aportan algo que una notificación convencional no consigue con igual claridad y menor esfuerzo.

Finalmente, estudiar este problema permite ampliar el bienestar digital más allá de la reducción del tiempo de pantalla. En vez de establecer cuánto debería durar el ocio, la investigación se concentra en una pregunta acotada: cómo mantener disponible una decisión personal dentro de una experiencia continua. Esa delimitación vuelve el problema abordable desde Diseño, permite comparar respuestas y ofrece criterios para evaluar una propuesta sin atribuirle beneficios que aún no han sido demostrados.

# 5. Antecedentes y estado de la cuestión

## 5.1 Del tiempo de pantalla a la experiencia de uso

Las primeras herramientas de bienestar digital hicieron visible el uso del teléfono mediante indicadores como minutos diarios, cantidad de aperturas y aplicaciones más consultadas. Estas mediciones permiten reconocer patrones, establecer límites y comparar periodos. Su utilidad es descriptiva: muestran cuánto ocurrió, pero no explican por qué ocurrió ni qué significado tuvo para la persona.

Lukoff et al. (2018) estudiaron la diferencia entre usos del teléfono percibidos como significativos y carentes de sentido. La valoración dependía del propósito, la actividad y la autonomía experimentada. Usos de duración semejante podían producir experiencias distintas, lo que cuestiona que una cifra aislada represente la calidad del ocio digital.

Meier y Reinecke (2021) llegaron a una conclusión compatible al revisar investigaciones sobre comunicación mediada, redes sociales y salud mental. Los efectos no siguen una dirección única: varían según las características de la persona, la forma de uso y el contexto. Por su parte, Radtke et al. (2022) examinaron intervenciones de desconexión digital y encontraron resultados positivos, nulos y negativos. En conjunto, estos antecedentes desaconsejan tratar la reducción del uso como una solución universal.

La discusión reciente presta mayor atención a la experiencia situada: qué buscaba la persona, cómo continuó la sesión y si entró en conflicto con otras metas. De Segovia Vicente et al. (2024) combinaron registros de uso con evaluaciones cotidianas y relacionaron algunos periodos de desplazamiento percibido como carente de propósito con mayor conflicto y culpa. La asociación no demuestra causalidad, pero desplaza el análisis desde la duración hacia la relación entre actividad e intención.

Esta distinción evita considerar todo ocio digital como un problema y, al mismo tiempo, reconocer que propósito, continuidad, contexto y valoración se influyen mutuamente.

## 5.2 Intervenciones de autocontrol digital

Las herramientas de autocontrol digital buscan ayudar a las personas a modificar usos que consideran distractores o excesivos. Sus mecanismos incluyen bloqueos, temporizadores, remoción de estímulos, demoras, mensajes de reconsideración y cambios en la apariencia de la interfaz. Lyngs et al. (2019) revisaron 367 herramientas y observaron una concentración en obstáculos que vuelven menos accesible la conducta no deseada. Una proporción menor apoyaba directamente la actividad que la persona quería realizar.

Biedermann et al. (2021) analizaron 28 intervenciones y encontraron resultados variables, limitados por muestras pequeñas, periodos breves y métodos diferentes. Monge Roffarello y De Russis (2023) revisaron 43 estudios sobre bienestar digital; solo cinco superaban los dos meses. El efecto estimado sobre la reducción del uso no deseado fue pequeño a medio, pero no permitió identificar un mecanismo superior ni equiparar menos tiempo con mayor bienestar.

Una línea distinta introduce una pausa antes de abrir o continuar en una aplicación. Grüning et al. (2023) estudiaron one sec, que demora la apertura y pide reconsiderar la acción. Haliburton et al. (2024) examinaron fricciones similares durante un periodo prolongado. Ambos trabajos muestran que una interrupción breve puede modificar recorridos y que el efecto depende del uso sostenido y del esfuerzo requerido.

Estas investigaciones permiten distinguir dos efectos. Una pausa puede crear un momento de decisión donde antes había continuidad. Sin embargo, alterar la conducta presente no permite saber si otra intención fue recuperada. Una persona puede cerrar una aplicación porque encontró una barrera y seguir sin recordar aquello que quería hacer. La interrupción de una conducta y la recuperación de una intención son fenómenos relacionados, pero no equivalentes.

## 5.3 Desconexión y separación física

Otra familia de respuestas propone alejar el dispositivo, guardarlo en un contenedor o vincular su acceso a una llave física. La separación puede aumentar el esfuerzo para retomar una aplicación y hacer visible un compromiso previo. No obstante, su propósito principal suele ser restringir el acceso. Resulta adecuada cuando la persona desea impedir una conducta durante un periodo definido, pero no necesariamente cuando necesita recuperar una actividad alternativa.

La revisión de Radtke et al. (2022) muestra que la desconexión digital no produce un resultado uniforme: puede reducir interrupciones, pero también generar incomodidad o interferir con actividades que dependen del dispositivo. La variación refuerza la necesidad de conocer el propósito antes de intervenir.

Alejar el teléfono puede disminuir su disponibilidad, pero no indica qué actividad se quería comenzar. La distancia física es una estrategia posible, no una respuesta completa al problema.

## 5.4 Recordatorios externos y memoria prospectiva

Las personas utilizan agendas, notas, alarmas y objetos para recordar acciones futuras. Esta práctica se conoce como **descarga cognitiva**: parte de la información que debería mantenerse o recuperarse se deposita en un recurso externo (Risko & Gilbert, 2016). Cuando aquello que se externaliza es una acción futura, también puede hablarse de descarga de intenciones (Gilbert et al., 2023).

El recurso externo reduce ciertas demandas, pero introduce otras. Es necesario formular la intención, escoger una señal, ubicarla y reconocerla cuando aparece. Chiu y Gilbert (2024) observaron que el esfuerzo necesario para configurar un recordatorio influye en la decisión de utilizarlo. Una ayuda demasiado compleja puede ser abandonada antes de cumplir su función.

Los recordatorios basados en ubicación exploran el vínculo entre intención y contexto. Place-Its permitió asociar mensajes a lugares en teléfonos móviles (Sohn et al., 2005), mientras O’Rear y Radvansky (2019) estudiaron cómo el lugar puede favorecer el recuerdo de una acción futura. Los hallazgos muestran que el contexto puede colaborar con la recuperación, aunque la proximidad no garantiza que la acción se realice.

En el campo de la **interacción tangible**, que incorpora objetos físicos a la manera de representar o manipular información, *The Tangible Reminder* vinculó objetos cotidianos con información de citas y señales ambientales (Hermann et al., 2007). El proyecto demostró que un recordatorio puede distribuirse entre información digital, presencia física y entorno. Su propósito, sin embargo, era comunicar compromisos temporales mediante un objeto con información visible. No responde directamente a sesiones de ocio digital ni a intenciones que la persona puede decidir no ejecutar.

## 5.5 Estado de la cuestión

La literatura permite establecer cuatro acuerdos parciales. La duración no basta para valorar una experiencia digital; ciertas interfaces reducen los momentos de cierre; las fricciones pueden abrir una pausa antes de continuar; y los recursos externos pueden apoyar el recuerdo de una acción futura. Al mismo tiempo, cada línea deja una pregunta pendiente.

Las métricas describen el uso, pero no recuperan por sí mismas el propósito. Los bloqueos modifican el acceso, aunque pueden actuar sin considerar el sentido de la actividad. Las pausas crean una reconsideración dentro del teléfono, pero no necesariamente devuelven una intención alternativa. Los recordatorios externos apoyan el recuerdo, aunque exigen una relación comprensible entre señal, lugar y acción.

La intersección de estas líneas deja una pregunta abierta: bajo qué condiciones una intención formulada por la propia persona puede volver a estar disponible mientras una sesión digital continúa, sin convertir el apoyo en bloqueo o mandato. La literatura revisada no determina todavía qué soporte, momento o contexto respondería mejor a esa pregunta. Tampoco permite suponer que una respuesta física sea necesariamente superior a una digital.

La revisión es exploratoria. Se priorizaron publicaciones desde 2019 y se mantuvieron antecedentes anteriores cuando resultaban necesarios para definir memoria prospectiva, interacción tangible o uso del espacio. No se realizó una revisión sistemática ni un estudio de patentes. Por ello, los vacíos identificados delimitan una oportunidad de investigación y no demuestran la inexistencia universal de soluciones semejantes.

# 6. Marco teórico por ámbitos

El marco teórico se organiza en tres ámbitos. El primero estudia la experiencia del ocio digital y la relación entre actividad presente, metas e intenciones. El segundo examina cómo las interfaces sostienen la continuidad y qué condiciones debe cumplir una intervención respetuosa de la autonomía. El tercero aborda la memoria prospectiva, el uso del espacio y la interacción tangible. La intersección permite comprender el problema antes de definir una respuesta proyectual.

## 6.1 Ámbito 1: experiencia subjetiva del ocio digital

### 6.1.1 El ocio como experiencia situada

El ocio no constituye un tiempo vacío ni una pausa de menor valor frente al trabajo. Puede ofrecer descanso, disfrute, aprendizaje, exploración y vínculo social. Tonietto et al. (2021) mostraron que juzgar el ocio como improductivo reduce el disfrute, especialmente cuando la actividad se realiza por sí misma y no para obtener otro resultado. Esta relación obliga a evitar un enfoque que convierta cada minuto disponible en una tarea productiva.

En el entorno digital, la valoración depende de la correspondencia entre propósito y experiencia. Lukoff et al. (2018) encontraron que las personas distinguen usos del teléfono que consideran significativos de otros que perciben como carentes de sentido. La diferencia no está fijada por una aplicación. Una red social puede sostener una conversación importante y, en otro momento, una secuencia difícil de describir. Un videojuego puede ser descanso, encuentro o concentración, mientras una búsqueda breve puede sentirse inoportuna.

Meier y Reinecke (2021) proponen atender a quién usa la tecnología, qué hace y en qué contexto. Este enfoque evita inferir bienestar o malestar desde una categoría general como tiempo de pantalla. Para la presente investigación, la unidad relevante es el episodio: una situación concreta con un inicio, una actividad, un propósito, otras intenciones posibles y una valoración posterior.

### 6.1.2 Conflicto entre metas

Una meta puede entenderse como un resultado o estado que orienta la acción. Varias metas pueden coexistir y competir por tiempo, atención o recursos. El **conflicto entre metas** aparece cuando avanzar en una actividad dificulta otra que la persona también valora. No implica que una deba ser correcta y la otra incorrecta; describe una relación experimentada entre posibilidades.

De Segovia Vicente et al. (2024) relacionaron algunos episodios de desplazamiento digital percibido como carente de propósito con mayor conflicto y culpa. La importancia del hallazgo no reside en condenar el desplazamiento, sino en mostrar que el malestar puede surgir cuando la actividad deja de coincidir con lo que la persona quería hacer. Una sesión extensa y coherente con su propósito no presenta necesariamente el mismo conflicto.

La culpa tampoco debe utilizarse como indicador automático. Puede aparecer por expectativas sociales que desvalorizan el descanso, incluso cuando la actividad fue elegida (Tonietto et al., 2021). Diseñar desde la culpa correría el riesgo de reforzar una norma externa. Resulta más preciso preguntar si existía otra intención y si la persona quería mantenerla disponible.

### 6.1.3 Elección inicial y decisión renovada

Comenzar una actividad de forma deliberada no significa que cada minuto posterior responda a una nueva decisión. Las interfaces continuas permiten que la acción siga con muy poca participación. Esto no convierte el episodio en involuntario, pero vuelve pertinente distinguir la elección inicial de las decisiones que podrían renovarla o cerrarla.

Una **decisión renovada** ocurre cuando la persona vuelve a considerar si desea continuar, cambiar o detenerse. No necesita adoptar la forma de una pregunta explícita. Puede surgir ante el final de un capítulo, una pausa, una señal del entorno o la aparición de otra intención. Cuando no hay cierres claros, la misma acción puede extenderse sin que la comparación entre alternativas vuelva a ocupar el centro de la experiencia.

El concepto ayuda a describir la situación con palabras simples. No se afirma que la persona actúe sin conciencia, que pierda el control ni que toda continuidad sea indeseada. Solo se reconoce que una sesión puede seguir mientras otra posibilidad deja de estar presente.

## 6.2 Ámbito 2: arquitecturas de atención y bienestar digital

### 6.2.1 Continuidad diseñada

Una interfaz organiza acciones posibles. Define qué aparece primero, qué esfuerzo exige cada paso y cuándo termina una secuencia. En plataformas de contenido, el desplazamiento infinito, la reproducción automática y las recomendaciones encadenadas reducen los puntos de cierre. El siguiente elemento está disponible antes de que la persona deba buscarlo o confirmar que quiere continuar (Montag et al., 2019).

Estas decisiones forman una **arquitectura de atención**, es decir, un conjunto de elementos que orienta qué se percibe y cómo avanza la interacción. El concepto no supone una manipulación absoluta. Las personas mantienen propósitos, experiencia y capacidad de elección. Aun así, una opción inmediata y continua compite en condiciones distintas con una actividad que exige levantarse, reunir materiales o cambiar de espacio.

La asimetría entre acciones importa. Continuar viendo contenido puede requerir un gesto mínimo; comenzar a caminar puede exigir recordar la intención, decidir, ponerse las zapatillas y salir. Incluso cuando ambas actividades son valoradas, sus primeros pasos no ofrecen la misma facilidad. El Diseño participa en esa diferencia al organizar la disponibilidad de cada acción.

### 6.2.2 Fricción y reconsideración

La **fricción** es el esfuerzo adicional introducido en una interacción. Puede consistir en esperar, confirmar, realizar un gesto o desplazarse hacia un objeto. Una fricción bien dirigida abre tiempo para reconsiderar; una fricción excesiva puede frustrar, ser eludida o dificultar una actividad legítima.

Lyngs et al. (2019) muestran que las herramientas de autocontrol emplean fricciones con distintos niveles de intensidad. Algunas eliminan estímulos; otras bloquean; otras presentan mensajes o demoras. Grüning et al. (2023) y Haliburton et al. (2024) encontraron que una pausa antes de abrir una aplicación puede cambiar el curso de la interacción. El mecanismo es relevante porque puede abrir un punto de elección, pero sigue concentrado en la acción digital presente.

Para el problema estudiado, conviene distinguir la fricción de la recuperación de una intención. Hacer más difícil continuar puede abrir una reconsideración, pero no equivale a recordar qué otra cosa se quería hacer. La literatura deja pendiente qué mecanismo permitiría que una alternativa volviera a ser considerada sin restringir la actividad presente.

### 6.2.3 Autonomía y posibilidad de no intervenir

La autonomía no se resuelve únicamente declarando que la persona conserva el control. También depende de que comprenda la intervención y pueda aceptarla, ajustarla o rechazarla. Una ayuda persistente o difícil de detener puede ejercer presión aun cuando no exista un bloqueo formal.

También es necesario reconocer cuándo una intervención sería improcedente. Una videollamada significativa, un videojuego concentrado, un pódcast elegido o una sesión de descanso pueden extenderse sin constituir el problema descrito. Si no existe una intención alternativa formulada, la duración o la aplicación no bastan para justificar una interrupción.

Esta frontera cambia la definición de éxito. Continuar con el teléfono después de recordar una intención puede ser una decisión válida. La función de una ayuda no sería conseguir obediencia, sino devolver una posibilidad a la evaluación de la persona. En algunos episodios, permanecer inactiva será la respuesta correcta.

### 6.2.4 Condiciones observables y límites de interpretación

Los sistemas digitales operan a partir de eventos que pueden registrar: tiempo transcurrido, aplicación activa, horario, conexión o movimiento. No pueden conocer de manera directa si una persona está aburrida, culpable, concentrada o satisfecha. Confundir un dato técnico con una experiencia subjetiva produciría intervenciones injustificadas.

Las **intenciones de implementación** vinculan una situación anticipada con una acción prevista: si ocurre una condición, entonces se realiza una respuesta (Gollwitzer & Sheeran, 2006). Esta estructura permite comprender cómo un evento observable puede relacionarse con una acción futura sin atribuirle un significado subjetivo. El vínculo se establece de antemano; el evento no demuestra por sí mismo que el momento sea problemático.

Los eventos observables tampoco son equivalentes. El uso continuo describe una secuencia; el uso acumulado reúne periodos diferentes; una franja horaria solo indica una coincidencia temporal. Cada dato permite reconocer una condición limitada, pero ninguno revela por sí solo el propósito, la satisfacción o el conflicto experimentado por la persona.

## 6.3 Ámbito 3: mediación material de información personal

### 6.3.1 Recordar una acción futura

La memoria prospectiva permite recordar que se quiere hacer algo cuando llega la ocasión adecuada (McDaniel & Einstein, 2000). Se diferencia de la memoria retrospectiva, que permite recuperar información o acontecimientos pasados. Pensar por la mañana que se quiere leer y recordarlo al final del día no garantiza que la intención haya aparecido cuando existía tiempo para comenzar.

Una intención futura puede recuperarse por el paso del tiempo o por un evento. Las alarmas responden al primer caso: señalan una hora. Las claves contextuales responden al segundo: un lugar, una persona o un objeto vuelve pertinente la acción. Ninguna señal garantiza la ejecución. Primero debe ser percibida; luego debe relacionarse con la intención; finalmente, la persona decide qué hacer.

Separar esos momentos evita evaluar una ayuda mediante un único resultado. Percibir una señal no demuestra haberla comprendido. Comprender su origen no significa recordar la actividad. Recordarla tampoco obliga a comenzar. La secuencia completa incluye percepción, asociación, recuperación y decisión.

### 6.3.2 Descarga de intenciones

Externalizar una intención permite que el entorno participe en su recuerdo. Una nota junto a la puerta, un libro sobre la mesa o una alarma antes de una cita conservan información fuera de la memoria activa. Risko y Gilbert (2016) describen este fenómeno como descarga cognitiva, mientras Gilbert et al. (2023) revisan específicamente la descarga de intenciones.

La estrategia ofrece ventajas y costos. Puede reducir la necesidad de mantener una meta presente, pero exige confiar en la señal, configurarla y encontrarla en el momento adecuado. Chiu y Gilbert (2024) muestran que el esfuerzo físico requerido para establecer un recordatorio modifica la decisión de externalizar. Por ello, cada paso adicional debe justificar su presencia.

Una señal no necesita contener toda la información para funcionar como clave, siempre que la persona comprenda su relación con la intención. Si resulta demasiado ambigua, puede obligar a consultar una fuente adicional y aumentar el esfuerzo necesario para recordar. El grado adecuado de información depende del contexto y no puede establecerse únicamente desde la teoría.

### 6.3.3 El espacio como parte de la acción

Kirsh (1995) explica que las personas organizan el espacio para reducir demandas cognitivas y volver perceptibles ciertas relaciones. Colocar ingredientes sobre una mesa, dejar un objeto junto a una puerta o preparar ropa para el día siguiente son formas de apoyar la acción mediante el entorno. El espacio no es un fondo neutro; puede colaborar con la comprensión y el inicio.

Los recordatorios situados amplían esta idea. Sohn et al. (2005) y O’Rear y Radvansky (2019) muestran que el lugar puede ayudar a recuperar una intención, aunque estar cerca no asegura actuar. La relación funciona cuando el contexto es significativo para la persona y cuando la señal puede percibirse sin competir de manera excesiva con otras actividades.

Para estudiar esa relación puede ser útil distinguir una meta amplia de las acciones concretas que permiten iniciarla. Hacer ejercicio, por ejemplo, puede comenzar al preparar las zapatillas; leer, al abrir un libro; dibujar, al disponer los materiales. Esta diferencia ayuda a observar la distancia entre recordar una intención y reconocer cómo podría comenzar, pero todavía no establece cómo debe diseñarse una intervención.

El lugar también introduce límites. Una señal puede molestar a otras personas, revelar información privada, perderse entre objetos o dejar de ser visible. El hogar no es homogéneo: sus superficies, recorridos, sonidos y acuerdos de convivencia cambian. Situar una interacción exige estudiar esas condiciones y permitir que la asociación pueda modificarse.

### 6.3.4 Interacción tangible y experiencia phygital

La interacción tangible incorpora objetos físicos como parte del modo en que se representa o manipula información. Su aporte no depende únicamente de tocar. La ubicación, la presencia, el peso y el movimiento pueden participar en el significado de la acción.

Una experiencia **phygital** integra componentes físicos y digitales que cumplen funciones complementarias dentro de un mismo sistema. No consiste simplemente en añadir un objeto a una aplicación. Las funciones pueden distribuirse de distintas maneras y ninguna capa posee un valor superior por sí misma. La relación solo adquiere sentido cuando la integración aporta a la experiencia y puede estudiarse como un conjunto.

*The Tangible Reminder* constituye un antecedente porque conectó información de citas con objetos y señales ambientales (Hermann et al., 2007). El caso muestra que el entorno puede hacer visible un compromiso sin depender exclusivamente de una alerta convencional. Al mismo tiempo, recuerda que cada objeto trae exigencias de energía, mantención, costo y aprendizaje.

Waggoner et al. (2026) señalan que las experiencias phygital requieren métodos capaces de observar la relación entre canales, lugares y momentos. Evaluar solo la aplicación o solo el objeto fragmentaría el sistema. También resulta necesario comprobar si la capa física aporta valor frente a una solución exclusivamente digital.

## 6.4 Conclusiones del marco teórico

Los tres ámbitos convergen en una situación precisa. Una sesión de ocio digital puede continuar y conservar valor, pero también puede coincidir con una intención alternativa que deja de orientar la acción. La interfaz influye al mantener disponible la actividad presente; la memoria prospectiva explica por qué recordar después no equivale a recordar a tiempo; y el estudio del espacio muestra que el entorno puede participar en la organización y recuperación de acciones.

La intersección no determina una solución. Plantea preguntas que deben contrastarse con la investigación de usuarios y el estado del arte: cómo vuelve a estar disponible una intención, qué eventos pueden relacionarse legítimamente con ella, qué papel cumple el contexto y cómo se conserva la autonomía. También obliga a considerar el esfuerzo necesario para establecer y mantener cualquier apoyo.

Estas preguntas permiten avanzar desde la teoría sin confundir una posibilidad con una decisión de diseño. Los criterios y la formulación del proyecto deberán aparecer después de examinar la experiencia de los usuarios y las respuestas existentes.

# 7. Usuario, contexto y hallazgos de entrevistas

## 7.1 Método y participantes

Se realizó un estudio cualitativo exploratorio para comprender relatos y reconocer patrones iniciales, sin buscar una representación estadística de la población. El estudio abordó experiencias de ocio digital, momentos de continuidad, intenciones alternativas, formas de cierre y estrategias utilizadas frente al teléfono. El formato semiestructurado permitió mantener una pauta común y profundizar en situaciones particulares mediante repreguntas.

Participaron ocho personas de 19 a 27 años. Las entrevistas fueron habladas y presenciales, y se realizaron en Santiago los días 11 y 12 de junio de 2026. El reclutamiento se efectuó mediante contactos proporcionados por personas cercanas al investigador. La edad fue el único criterio común confirmado. En consecuencia, el lugar y el rango etario describen el levantamiento, pero no permiten generalizar los resultados a todos los adultos jóvenes.

La pauta avanzó desde las actividades de tiempo libre hacia el relato de una sesión reciente, su propósito, continuidad, percepción temporal, valoración y cierre. Dos preguntas adicionales abordaron las estrategias para descansar o separarse del teléfono y la reacción ante el concepto In(Visible). Se obtuvo consentimiento informado oral para la participación y el uso académico anonimizado del material.

Las conversaciones fueron transcritas y regularizadas para facilitar su lectura. El corpus se organizó con códigos P1–P8 y Q1–Q13. La unidad principal fue el episodio: una situación relatada en relación con actividad, intención, continuidad, recuerdo, valoración o estrategia. El método Framework organizó temas y casos en una matriz común, manteniendo el vínculo con cada entrevista (Goldsmith, 2021). A partir de semejanzas y contrastes se construyeron tipos ideales revisables: modelos analíticos que reúnen rasgos recurrentes sin convertirlos en perfiles permanentes de los participantes (Stapley et al., 2022).

Las referencias internas que combinan participante y pregunta —por ejemplo, P2, Q3–Q7— permiten localizar el segmento del corpus que sustenta una paráfrasis. No corresponden a citas textuales ni sustituyen la interpretación transversal; su función es mantener trazabilidad entre las respuestas anonimizadas y los hallazgos presentados.

La interpretación fue realizada por el investigador y no contó con un segundo codificador. Tampoco se observaron directamente las conductas ni los espacios domésticos. Los hallazgos permiten reconocer patrones y contraejemplos dentro del corpus, pero no estimar frecuencia, causalidad, eficacia o disposición de pago.

## 7.2 Caracterización del corpus

La siguiente tabla resume la función analítica de cada participante. No establece diagnósticos ni perfiles permanentes.

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

La diversidad interna fue más útil que una división demográfica. Una misma persona podía describir actividades digitales dirigidas y otras que continuaban sin una nueva decisión reconocible. La aplicación utilizada, la duración o la edad no bastaron para identificar el problema. Lo decisivo fue la relación entre la sesión y otra intención presente en ese momento.

## 7.3 Episodios centrales

P2 relató que abrió Instagram al acostarse para mirar memes. Reconoció el sueño y, aun así, continuó usando el teléfono. Recordaba la sesión con claridad, pero evaluó su cierre como incompleto. El episodio no indica que hubiera olvidado lo ocurrido. Muestra una tensión entre una intención alternativa —dormir— y la continuidad de la actividad (P2, Q3–Q7).

P3 describió videos humorísticos en Instagram como una forma de pasar el tiempo. Relató una pérdida de noción temporal y reconoció otras actividades que habría preferido realizar. Al mismo tiempo, consideró que la sesión había funcionado como una pausa frente a sus responsabilidades. Esta ambivalencia es importante: una actividad puede ofrecer descanso y competir con otra intención sin volverse, por ello, incorrecta (P3, Q3–Q8).

P5 mencionó entretenimiento inmediato y aburrimiento posterior. También habló de estrategias que no siempre evitaban volver al teléfono. Su relato ayuda a diferenciar una valoración negativa después de la sesión de una intención alternativa ya formulada. No toda insatisfacción posterior indica que existía una actividad concreta que pudiera recuperarse durante el episodio (P5, Q3–Q10 y Q12).

P1 y P4 mostraron variaciones semejantes. Ambos distinguieron momentos de uso dirigido de otros más rutinarios. Estos relatos impiden tratar a una persona como un usuario permanente del problema. La pertinencia cambia según la actividad y el contexto (P1, Q3–Q5, Q8 y Q12; P4, Q3–Q8 y Q12).

## 7.4 Contraejemplos y necesidad de no intervenir

P6 relató una videollamada extensa que valoró por su contenido y por el vínculo con otra persona (P6, Q3–Q9). P7 describió un pódcast elegido mientras comía y no reconoció una obligación que exigiera corregir la experiencia (P7, Q3–Q10). P4 diferenció el sudoku focalizado de actividades digitales menos dirigidas (P4, Q3–Q8). P8 mostró que una rutina difícil de describir puede coincidir con un descanso que se considera aceptable (P8, Q3–Q10).

Estos contraejemplos cumplen una función central. Dentro del corpus muestran que ni la duración, ni la presencia del teléfono, ni una categoría de aplicación bastan por sí solas para decidir una intervención. De ellos se deriva un riesgo de diseño: una señal activada únicamente por tiempo podría interrumpir una conversación importante, una actividad concentrada o una pausa deliberada.

La ausencia de una intención alternativa también resulta significativa para la propuesta. Si la persona no ha formulado otra actividad que quiera mantener disponible, el sistema carece de contenido legítimo para recordar. Permanecer inactivo no constituye una falla, sino una forma de respetar el propósito actual.

## 7.5 Estrategias existentes

Ante la pregunta por formas de descansar o separarse del teléfono, las personas mencionaron alejarlo, cargarlo en otro lugar, silenciarlo o activar modos de no molestar (P1–P5 y P7–P8, Q12). Estas estrategias fueron declaradas, pero no observadas ni comparadas. Su aporte consiste en mostrar que la distancia, el lugar y el silencio ya forman parte del repertorio cotidiano de algunos participantes.

También revelan una dificultad. Alejar el teléfono puede disminuir su disponibilidad, aunque no siempre evita el retorno ni recuerda qué actividad se quería comenzar. El espacio aparece como un recurso posible, pero su eficacia no puede darse por supuesta.

Las respuestas frente a In(Visible) incluyeron solicitudes de señales calmadas, discretas o visuales y el rechazo de notas o comparaciones entre días (P3–P5 y P7–P8, Q13). Como la pregunta se refería a un concepto anterior y no incluyó una prueba de Relevo, esas reacciones solo orientan criterios generales; no validan el producto ni permiten cerrar su forma.

## 7.6 Dos tipos de usuario

Los hallazgos permiten distinguir dos tipos situacionales. No representan identidades cerradas ni segmentos comerciales; una misma persona puede pasar de uno a otro según la actividad.

### Usuario principal

El usuario principal aparece cuando coinciden tres condiciones: la sesión digital continúa sin una decisión renovada claramente reconocida; existe otra actividad que la persona quiere mantener disponible; y esa intención deja de orientar el siguiente paso. P2 y P3 representan con mayor claridad esta situación, mientras P5 muestra un caso menos definido.

Su necesidad no es abandonar siempre el teléfono. Necesita volver a considerar una alternativa propia en un momento oportuno. Para que esa necesidad pueda traducirse en diseño, la intención debe vincularse con un comienzo concreto: dormir puede iniciar al dejar el teléfono y preparar el espacio; caminar, al ponerse las zapatillas; leer, al abrir el libro.

Sus principales puntos de dolor son la continuidad difícil de cerrar, la pérdida de presencia de otra actividad y el retorno al teléfono después de haber intentado alejarlo. A ello se suma una tensión: recibir ayuda sin sentir que una herramienta transforma la intención en obligación.

### Usuario límite

El usuario límite aparece cuando la actividad digital es elegida, significativa, relacional, concentrada o reparadora, o cuando no existe una intención alternativa que requiera apoyo. P6 y P7 ofrecen los contrastes más claros; P4 y P8 muestran que la posición puede cambiar dentro de una misma persona.

Su necesidad principal es conservar autonomía. Una intervención equivocada puede convertir una actividad legítima en un problema, exponer una intención privada o interrumpir a otras personas. Para este usuario, la posibilidad de no activar, ignorar o detener la señal tiene tanta importancia como la capacidad de recibirla.

## 7.7 Recorridos de experiencia

El recorrido del usuario principal comienza con una sesión elegida o tolerada como descanso. El contenido sucesivo mantiene disponible la siguiente acción. En algún momento existe o reaparece una actividad alternativa, pero no logra orientar el cambio. La sesión continúa o termina con ambivalencia. Más tarde, la persona reconstruye lo ocurrido y puede intentar estrategias como alejar o silenciar el teléfono.

El recorrido del usuario límite es diferente. La actividad se elige con un propósito y conserva valor durante la sesión. Puede ser extensa, pero no entra en conflicto con otra intención reconocida. El cierre ocurre sin necesidad de corrección. Cualquier ayuda debe permitir que este recorrido continúe sin interrupciones injustificadas.

Ambos recorridos comparten una exigencia: la persona debe conservar la autoridad para interpretar el momento. Ningún dato de uso reemplaza esa valoración. Una futura propuesta tendrá que pedir una intención explícita, permitir cambios y evitar que la continuidad digital sea interpretada automáticamente como un problema.

## 7.8 Contexto de uso

El hogar se considera un primer contexto pertinente porque varias intenciones y estrategias relatadas dependen de objetos, superficies y distancias. Leer, dibujar, cocinar, dormir o salir a caminar suelen comenzar mediante acciones materiales reconocibles. Además, cargar el teléfono en otro lugar o dejarlo lejos ya forma parte de las prácticas mencionadas.

Esta elección sigue siendo una hipótesis. Las entrevistas no incluyeron observaciones sistemáticas de viviendas, convivencia, ruido, iluminación, privacidad o movilidad de objetos. Un elemento visible puede ser desplazado; una luz puede pasar inadvertida; un sonido puede molestar o revelar información personal. Las condiciones del espacio deberán estudiarse antes de afirmar que una misma solución funciona en todos los hogares.

## 7.9 Síntesis de necesidades

El usuario principal necesita mantener disponible una intención y reconocer cómo comenzar, sin que el apoyo imponga la acción. El usuario límite necesita proteger una experiencia digital que conserva sentido y decidir si una ayuda es pertinente. De ambos se desprenden requisitos comunes: configuración voluntaria, posibilidad de cambio, señal discreta, salida inmediata y ausencia de sanciones.

Las entrevistas no definen la forma final de una solución. Su aporte consiste en precisar el momento que debe abordarse y en establecer situaciones donde intervenir sería un error. Esta distinción permite avanzar sin convertir a los participantes en validadores de una propuesta que no probaron.

# 8. Estado del arte y referentes

## 8.1 Criterios de análisis

El estado del arte examina cómo otras investigaciones, servicios y productos han respondido a problemas cercanos. La revisión no se limita a enumerar referentes visuales. Compara el mecanismo con que cada propuesta interviene, el valor que ofrece, la evidencia disponible y aquello que no resuelve.

La búsqueda se cerró el 24 de agosto de 2026. Se consultaron artículos académicos, documentación oficial, sitios de productos y fichas técnicas. El [registro metodológico](../04_mercado_y_referentes/registro-busqueda-2026-08-24.md) conserva la pregunta, las familias de términos, los tipos de fuente, los criterios de inclusión y exclusión, nueve referentes nucleares y los límites del levantamiento. No se preservó un historial literal de consultas, buscadores ni conteos completos de resultados; por ello, permite repetir una exploración equivalente, pero no se presenta como revisión sistemática.

Las fuentes comerciales permiten conocer funciones, compatibilidad declarada y modelo de valor, pero no demuestran eficacia independiente. La revisión tampoco corresponde a un estudio jurídico de patentes, un cálculo de participación de mercado ni una auditoría de disponibilidad en Chile. Sus conclusiones se restringen al corpus consultado.

Las seis familias utilizadas en el capítulo son una clasificación construida para comparar mecanismos dentro de esta investigación. No corresponden a una taxonomía universal ni a categorías empleadas necesariamente por las marcas.

Para ordenar la comparación se utilizaron seis preguntas:

1. ¿Qué problema declara abordar la propuesta?
2. ¿Qué mecanismo utiliza: medición, pausa, bloqueo, distancia, recordatorio o recompensa?
3. ¿Dónde ocurre la interacción principal?
4. ¿Qué debe hacer la persona para configurarla y mantenerla?
5. ¿Cómo conserva o limita su autonomía?
6. ¿Qué evidencia existe sobre sus resultados?

Estas preguntas permiten distinguir soluciones que parecen semejantes por su apariencia, pero actúan de maneras diferentes.

## 8.2 Herramientas nativas de bienestar digital

Apple Screen Time y Google Digital Wellbeing integran al sistema operativo mediciones de tiempo, límites por aplicación, periodos de descanso y controles de notificaciones (Apple, s. f.; Google, s. f.-c). Su principal fortaleza es la disponibilidad. No exigen comprar un objeto ni aprender una plataforma completamente nueva. Además, entregan datos que pueden ayudar a reconocer patrones generales.

Su lógica se apoya en categorías cuantificables: minutos, aperturas, horarios y aplicaciones. Esta información resulta útil cuando la persona desea observar o reducir un uso específico. El límite aparece cuando el problema depende del sentido de la sesión. El sistema conoce que una aplicación estuvo activa, pero no sabe si la persona conversaba, descansaba, buscaba información o recorría contenido sin un propósito renovado.

Pause Point, anunciado por Google en 2026, representa una evolución hacia la reconsideración. La función permite introducir una pausa temporal en aplicaciones seleccionadas y refleja un interés actual por crear cierres flexibles dentro del sistema operativo (Sanders, 2026). Su disponibilidad depende de versiones y dispositivos, por lo que no constituye una capacidad universal. Aun así, muestra que el mercado comienza a desplazarse desde el conteo hacia intervenciones breves y reversibles.

Las herramientas nativas funcionan bien como línea base porque reducen costos y concentran el control en un entorno conocido. No resuelven, en cambio, la recuperación situada de una intención. El significado continúa dentro del teléfono y suele expresarse mediante información temporal o restricciones de acceso.

## 8.3 Aplicaciones de pausa y fricción

one sec introduce una demora antes de abrir determinadas aplicaciones y pide reconsiderar la acción (one sec, s. f.). Su mecanismo ha sido estudiado tanto en condiciones experimentales como durante periodos prolongados (Grüning et al., 2023; Haliburton et al., 2024). La evidencia sugiere que una pausa puede disminuir aperturas automáticas y cambiar parte del recorrido. No demuestra que todas las personas mantengan el uso de la herramienta ni que reducir aperturas mejore por sí solo el bienestar.

El aporte de one sec consiste en actuar cerca del momento de decisión. A diferencia de un informe semanal, la fricción aparece antes de continuar. También conserva una salida: la persona puede avanzar después de la pausa. Su límite para el problema investigado es que toda la interacción ocurre en la misma pantalla y se concentra en decidir si abrir o no una aplicación. La herramienta no conserva necesariamente una actividad alternativa ni la relaciona con el lugar donde puede comenzar.

Otras aplicaciones utilizan respiración, preguntas, mensajes personalizados, escalas de intención o cambios visuales. La variedad muestra que el mercado reconoce un problema de continuidad y busca introducir momentos de reflexión. Sin embargo, muchas propuestas dependen de la repetición de un aviso dentro del dispositivo. Con el tiempo, ese aviso puede volverse parte del flujo, ser omitido o requerir una intensidad creciente.

Lo que parece funcionar en esta familia es la proximidad entre intervención y acción. La pausa modifica el recorrido antes de que la sesión se establezca o continúe. Lo menos resuelto es la permanencia del efecto, la transferencia hacia otra actividad y la carga que surge cuando la herramienta se vuelve predecible o fácil de eludir.

## 8.4 Llaves físicas y bloqueadores

Brick vincula una aplicación con un dispositivo físico utilizado para activar o revertir modos de bloqueo. Al momento de la consulta, la marca declaraba compatibilidad con Android 12 o posterior e iOS 17 o posterior, y mostraba un precio de USD 59 (Brick LLC, s. f.-a). Su propuesta de valor combina distancia y **precompromiso**, es decir, una decisión previa que restringe deliberadamente las opciones disponibles durante una situación: para recuperar el acceso es necesario volver al objeto.

Unpluq utiliza una etiqueta con comunicación de campo cercano —NFC, tecnología que intercambia datos a muy corta distancia— junto con horarios, barreras y estadísticas. Su modelo incluye una suscripción (Unpluq, s. f.). Screenless Breaker ofrece una llave NFC que permite reabrir aplicaciones bloqueadas y mostraba un precio de EUR 45 (Screenless, s. f.). Su sitio entrega información contradictoria: una tabla menciona iOS y Android, mientras la sección de preguntas frecuentes limita la compatibilidad actual a iOS y iPadOS y presenta Android como una versión planificada. Brick Zone amplía la lógica hacia un espacio declarado mediante Bluetooth y presentaba un precio de USD 99 (Brick LLC, s. f.-b).

Estos productos muestran que existe un mercado dispuesto a incorporar objetos en el control del teléfono. El componente físico hace visible el compromiso y aumenta el esfuerzo necesario para revertirlo. Esa fricción puede ser valiosa para quien desea una barrera difícil de eludir.

La misma fortaleza define su límite. El objeto funciona principalmente como llave o condición de acceso. Su propósito es mantener la restricción, no recuperar una intención alternativa. Además, introduce costos de compra, compatibilidad, transporte y aprendizaje. Cuando la actividad digital es legítima, una barrera puede resultar desproporcionada.

## 8.5 Separación física y precompromiso

kSafe es un contenedor con cierre temporizado que puede utilizarse para guardar el teléfono u otros objetos (Kitchen Safe, s. f.). Se incorpora como antecedente de mecanismo; la revisión no confirmó de manera suficiente su stock ni su distribución actual en Chile. Su funcionamiento no depende del sistema operativo ni de permisos de uso. La persona establece un periodo durante el cual el contenido no estará disponible. La simplicidad técnica se acompaña de una restricción fuerte: revertir la decisión antes del tiempo fijado resulta difícil o imposible sin dañar el contenedor.

El producto representa la lógica de precompromiso. Una decisión tomada antes del episodio limita las opciones futuras. Puede resultar efectiva cuando el objetivo está claro, pero no se adapta con facilidad a cambios de contexto. Una llamada importante, una emergencia o un uso legítimo del teléfono quedan sometidos a la misma barrera.

Las estrategias mencionadas en las entrevistas —dejar el teléfono lejos, cargarlo en otro lugar o silenciarlo— comparten parte de esta lógica con menor intensidad. Su ventaja es que no requieren comprar un sistema. Su debilidad es que la distancia puede revertirse rápidamente y no conserva información sobre qué se quería hacer.

## 8.6 Objetos de foco y formación de hábitos

Focusaur declara un dispositivo físico acompañado de una aplicación, etiquetas NFC, sonidos y funciones de hábito. Su comunicación comercial combina foco, constancia y recompensa, y mostraba un precio promocional de USD 129 frente a un valor de referencia de USD 169 en la fecha de consulta (Focusaur, s. f.). La oferta permite observar una dirección de mercado en que el objeto deja de ser una simple llave y participa de un ritual de inicio.

La política de despacho consultada limita la tienda principal a Estados Unidos y remite a una tienda separada para Europa. No se comprobó disponibilidad en Chile. Esta condición importa porque una oferta visible en línea no equivale a acceso local ni permite comparar su costo final con el de una propuesta desarrollada en el país.

Los objetos de foco suelen vincular un espacio con una conducta: trabajar, estudiar o mantenerse lejos del teléfono. Esa relación puede hacer visible un compromiso y reducir la ambigüedad del comienzo. A la vez, la gamificación, las estadísticas o las recompensas pueden desplazar la atención desde el propósito personal hacia el cumplimiento frente al sistema.

Para esta investigación, el aporte de la familia es reconocer el valor del ritual y del lugar. Su límite está en la orientación predominante hacia productividad o disciplina. El ocio y las intenciones personales requieren una relación menos normativa, capaz de admitir que cambiar de idea también es válido.

## 8.7 Recordatorios tangibles y señales ambientales

*The Tangible Reminder* conectó objetos cotidianos con citas digitales y utilizó señales ambientales para comunicar cercanía temporal (Hermann et al., 2007). Aunque es anterior al periodo priorizado, sigue siendo pertinente porque muestra una integración clara entre información digital, objeto y entorno.

Su mecanismo se diferencia de los bloqueadores: no impide una acción, sino que vuelve perceptible un compromiso. También demuestra que un objeto puede adquirir significado mediante una asociación configurada. Sin embargo, las citas tienen horarios definidos y un contenido informativo estable. Una intención durante el ocio digital puede ser más ambigua, cambiar de prioridad o dejar de ser pertinente sin que exista incumplimiento.

Los recordatorios basados en lugar, como Place-Its, amplían la relación entre contexto y acción (Sohn et al., 2005). Su principal aporte es presentar la señal donde puede resultar significativa. Su límite es que una ubicación detectada técnicamente no equivale a una relación personal con el espacio. Estar cerca de un lugar no garantiza comprender ni ejecutar una intención.

## 8.8 Qué funciona, qué falla y qué se está desarrollando

La comparación permite reconocer fortalezas específicas. Las métricas funcionan para observar patrones; las pausas introducen una reconsideración cercana a la acción; los bloqueos sostienen compromisos fuertes; la separación física aumenta el esfuerzo de retorno; y los recordatorios tangibles relacionan información con el entorno. Ningún mecanismo es inútil por definición. Su pertinencia depende del problema que intenta resolver.

Los fallos aparecen cuando una respuesta se aplica fuera de su propósito. Medir no explica significado. Bloquear no recupera una alternativa. Alejar no indica cómo comenzar otra actividad. Recordar no garantiza actuar. Añadir un objeto tampoco asegura una experiencia mejor; puede aumentar costo, mantenimiento y carga de configuración.

La evidencia académica sobre autocontrol digital continúa siendo heterogénea. Los periodos de estudio suelen ser breves y las métricas más frecuentes son tiempo, aperturas o permanencia (Biedermann et al., 2021; Monge Roffarello & De Russis, 2023). Falta conocer mejor la autonomía, la comprensión del mecanismo y el abandono a largo plazo.

Una tendencia reciente consiste en permitir que las reglas se revisen. Kidel Peña-Albert et al. (2026) estudiaron una invitación a reconfigurar una herramienta de autocontrol digital. De 138 personas del grupo experimental, 63 aceptaron la propuesta. El resultado no demuestra eficacia general, pero indica que una regla puede perder pertinencia y que su ajuste forma parte de la experiencia.

También se observa una convergencia entre funciones nativas, aplicaciones de pausa y objetos conectados. El mercado no avanza en una sola dirección: algunas propuestas reducen complejidad dentro del sistema operativo, mientras otras agregan una capa física para aumentar compromiso o relacionar la acción con un lugar. Esta tensión vuelve necesaria una comparación directa entre alternativas digitales y phygitales.

## 8.9 Matriz comparativa

| Familia | Mecanismo principal | Referentes | Fortaleza | Límite frente al problema estudiado |
| --- | --- | --- | --- | --- |
| Medición | Mostrar tiempo, aperturas o categorías. | Screen Time, Digital Wellbeing. | Hace visible el patrón general. | No distingue el sentido de la sesión ni recupera una intención. |
| Pausa | Introducir una demora antes de continuar. | one sec, Pause Point. | Crea una ocasión de reconsideración. | Mantiene la señal y el significado dentro del teléfono. |
| Bloqueo | Restringir el acceso mediante una regla. | Brick, Unpluq, Screenless Breaker. | Sostiene un precompromiso difícil de eludir. | Se concentra en impedir la actividad presente. |
| Separación | Alejar o encerrar el dispositivo. | kSafe, estrategias cotidianas. | Reduce la disponibilidad física del teléfono. | No conserva qué otra actividad se quería comenzar. |
| Objeto de foco | Vincular lugar, hábito y compromiso. | Focusaur, Brick Zone. | Hace visible un estado y puede formar un ritual. | Tiende hacia productividad, control o recompensa. |
| Recordatorio tangible | Asociar información con objetos o lugares. | *The Tangible Reminder*, Place-Its. | Lleva una clave al contexto de la acción. | No aborda directamente el ocio digital ni la decisión de continuar. |

## 8.10 Oportunidad de diseño

El corpus revisado no mostró una evaluación independiente que reúna seis elementos: una intención formulada por la persona, un primer paso concreto, una condición digital comprensible, una señal física situada, la posibilidad legítima de continuar y una comparación con una notificación equivalente. Esta ausencia se limita a las fuentes consultadas y no constituye una afirmación de novedad universal.

La oportunidad se encuentra en apoyar el paso entre recordar una intención y reconocer dónde puede comenzar. A diferencia de las respuestas centradas en medir o restringir, la intervención podría hacer presente una alternativa fuera del flujo del teléfono. Su valor dependería de la relación entre intención, señal y lugar, no de aumentar la dificultad de acceso.

Esta dirección también contiene su principal exigencia crítica. Si una notificación digital ofrece el mismo apoyo con menor carga, el componente físico no se justifica. El aporte debe comprobarse mediante una comparación y no mediante la novedad aparente del objeto.

# 9. Criterios de diseño

Los criterios traducen la investigación en condiciones para formular y evaluar una propuesta. No describen todavía una solución final. Cada uno responde a evidencia del marco teórico, las entrevistas o el estado del arte.

## 9.1 Partir de una intención propia

La intervención debe conservar una actividad elegida por la persona. No puede deducirla desde el tiempo de uso, la aplicación abierta o una categoría de productividad, porque experiencias de duración semejante pueden adquirir sentidos distintos según el propósito y el contexto (Lukoff et al., 2018; Meier & Reinecke, 2021). Los contrastes entre P2–P3 y P6–P8 refuerzan esta diferencia dentro de las entrevistas. Sin una intención formulada, no existe contenido legítimo que recuperar.

## 9.2 Relacionar la intención con un primer paso

Las metas amplias dificultan reconocer cómo comenzar. Las intenciones de implementación muestran que vincular una situación con una respuesta prevista puede favorecer el paso desde una meta hacia la acción (Gollwitzer & Sheeran, 2006). Por ello, cada intención debe expresarse mediante una acción concreta y próxima. El primer paso no obliga a completar la actividad; solo reduce la distancia entre recordarla e iniciarla.

## 9.3 Utilizar una condición comprensible

La activación debe depender de un evento que la persona pueda entender y modificar. Los sistemas pueden registrar tiempo, horario o continuidad de uso, pero esos datos no revelan por sí solos aburrimiento, culpa o satisfacción. La diferencia entre episodios relatados por una misma persona confirma que una condición técnica no equivale al sentido de la experiencia. Tiempo, continuidad de uso u horario son condiciones posibles, pero su significado debe explicarse y probarse.

## 9.4 Abrir una elección, no imponer una conducta

La señal debe devolver la intención al presente sin bloquear el teléfono. Las intervenciones restrictivas pueden sostener un compromiso, pero también interferir con usos legítimos, mientras una pausa breve conserva la posibilidad de continuar (Grüning et al., 2023; Radtke et al., 2022). Ignorar la señal, detenerla, cambiar la intención o permanecer en la actividad digital son respuestas válidas. No se utilizarán sanciones, comparaciones ni registros de cumplimiento.

## 9.5 Reconocer cuándo no intervenir

Una actividad digital elegida, relacional, concentrada o reparadora no requiere corrección. P6 y P7 relataron experiencias extensas o focalizadas que conservaron sentido, mientras P4 y P8 mostraron que la pertinencia puede cambiar dentro de una misma persona. La propuesta debe permanecer inactiva cuando no exista una intención alternativa y permitir que una regla pierda vigencia sin convertirlo en un error.

## 9.6 Mantener una carga proporcional

Configurar, emparejar, cargar, situar y rearmar agregan esfuerzo. Chiu y Gilbert (2024) observaron que aumentar el esfuerzo físico necesario para preparar un recordatorio reduce su uso. Los objetos revisados también incorporan costos de compatibilidad, mantenimiento y aprendizaje. Cada paso debe aportar a la comprensión o al funcionamiento; si la carga supera el beneficio, la propuesta deberá simplificarse.

## 9.7 Proteger privacidad y convivencia

La intención pertenece a la persona. Las preferencias por señales discretas y el rechazo a comparaciones entre días aparecieron en P3–P5 y P7–P8, aunque fueron respuestas ante un concepto anterior y no una validación formal. Una señal situada no debe exponer su contenido ni molestar a quienes comparten el espacio. La intensidad, el canal, la duración y la ubicación deberán ajustarse al contexto mediante pruebas.

## 9.8 Demostrar el valor de la capa física

El objeto no se justifica por su presencia. Los recordatorios tangibles y basados en ubicación muestran que el entorno puede participar en la recuperación de una acción futura, pero no garantizan que la persona comprenda la señal ni que actúe (Hermann et al., 2007; O’Rear & Radvansky, 2019). Debe aportar una asociación con el lugar o una forma de recuperación que una notificación no produzca de igual manera. La comparación entre ambas alternativas será una condición central de evaluación.

## 9.9 Síntesis

Los criterios describen una ayuda voluntaria, situada y reversible. Su propósito no es reducir universalmente el tiempo de pantalla, sino mantener disponible una intención en los episodios donde la persona desea volver a considerarla. A partir de esta base puede formularse una propuesta concreta sin perder la relación con el problema investigado.

# 10. Formulación

La investigación delimita una oportunidad concreta: apoyar la recuperación de una intención personal cuando una sesión de ocio digital continúa y esa alternativa deja de orientar el siguiente paso. La respuesta debe mantener la decisión en la persona, reconocer que el ocio digital puede ser valioso y demostrar cualquier aporte físico frente a una opción digital más simple.

## 10.1 Problema de diseño

Las herramientas de bienestar digital se concentran, principalmente, en medir, pausar o restringir la actividad presente. Estos mecanismos pueden ayudar a reducir un uso, pero no necesariamente devuelven una intención alternativa ni indican dónde puede comenzar. El problema de diseño consiste en hacer nuevamente perceptible una intención formulada por la persona, sin bloquear el teléfono, evaluar su conducta o intervenir cuando la actividad digital conserva sentido.

## 10.2 Punto de vista

El punto de vista sintetiza al usuario, su necesidad y la razón que la explica:

> Una persona adulta joven que ya eligió una actividad alternativa y reconoce cómo comenzarla necesita mantener esa posibilidad disponible durante ciertos episodios de ocio digital, porque la continuidad de la interacción puede dejarla fuera de la decisión inmediata.

Esta formulación no describe a todas las personas del rango etario ni convierte la edad en una causa. Solo resulta pertinente cuando existe una intención propia que se desea recuperar. Si la actividad digital es significativa o no existe una alternativa, la necesidad desaparece.

## 10.3 Pregunta de investigación

> ¿Qué condiciones pueden ayudar a que una persona vuelva a considerar una actividad elegida cuando, durante una sesión de ocio digital, esa intención deja de orientar su decisión inmediata?

La pregunta se concentra en la experiencia que debe comprenderse y no anticipa el medio que la abordará. Volver a considerar una actividad significa reconocer la intención y recordar cómo comenzarla; no equivale a abandonar el teléfono, realizar la actividad ni reducir el tiempo de uso. El proyecto adopta el diseño phygital como medio para responder a esta pregunta. Lo que debe comprobarse es si la relación propuesta entre intención, señal, primer paso y lugar ofrece una ayuda comprensible y pertinente.

## 10.4 Oportunidad de diseño

La oportunidad consiste en trasladar una señal fuera del flujo del teléfono y relacionarla con el lugar donde puede comenzar la actividad elegida. De este modo, el entorno participa en la recuperación sin transformarse en una barrera. La intervención no presenta una orden ni mide cumplimiento; vuelve perceptible una posibilidad que la persona había decidido conservar.

Esta dirección se diferencia de cuatro mecanismos predominantes. No utiliza la medición como argumento principal, no introduce bloqueo, no se limita a una pausa dentro de la pantalla y no separa el teléfono como única acción. Su especialización se encuentra en la relación entre intención, primer paso y lugar.

## 10.5 Hipótesis

> Si una persona registra una intención y su primer paso, sitúa una señal física junto a ese comienzo y la recibe cuando se cumple una condición configurada, entonces la intención podría volver a estar disponible para decidir, sin bloquear la actividad digital ni imponer su ejecución.

La hipótesis reúne cuatro relaciones que deben evaluarse por separado. Primero, la señal debe asociarse con la intención. Segundo, el lugar debe aportar significado. Tercero, la persona debe poder ignorar o detener la intervención. Cuarto, la condición técnica debe funcionar de manera comprensible. La propuesta se debilita si exige consultar el teléfono para descifrar la señal, si el lugar no produce una diferencia frente a una notificación o si la carga de uso supera el beneficio.

## 10.6 Objetivo general

Diseñar y evaluar formativamente un sistema phygital que apoye la recuperación situada de una intención personal durante episodios de ocio digital, mediante una señal asociada al primer paso de la actividad, sin bloquear ni calificar la decisión posterior.

## 10.7 Objetivos específicos

1. Caracterizar la relación entre ocio digital, continuidad, intención alternativa y contexto mediante revisión bibliográfica, entrevistas y análisis de referentes.
2. Traducir los hallazgos en una experiencia phygital que articule configuración digital, señal física, lugar y control de la persona.
3. Comparar la señal situada con una notificación digital para establecer si la capa física aporta una diferencia reconocible.
4. Evaluar comprensión, percepción, autonomía, funcionamiento técnico, convivencia y carga de uso mediante prototipos progresivos.

## 10.8 Definición del proyecto

Relevo es un sistema phygital compuesto por una aplicación Android y un objeto de señal situado junto al primer paso de una actividad elegida. La aplicación permite registrar la intención, definir cómo comienza y configurar una condición de activación. Cuando esa condición se cumple, el objeto emite un pulso ambiental breve. La persona puede considerar la intención, continuar con la actividad digital o detener la señal.

El **pulso ambiental** es una señal física de corta duración que busca llamar la atención sin entregar una instrucción. Su significado proviene de la asociación creada previamente entre intención, objeto y lugar. La señal no informa que la persona ha fallado ni indica qué debe hacer; solo vuelve perceptible la actividad que decidió mantener disponible.

## 10.9 Alcance

El alcance inicial considera una persona, una intención activa, un primer paso, una aplicación seleccionada, una condición observable, un objeto y un lugar doméstico elegido manualmente. El sistema no infiere estados emocionales, no determina si una sesión es adecuada y no observa si la persona cumple la actividad. Tampoco utiliza puntajes, rachas, comparaciones o recompensas.

Android será la plataforma del primer prototipo integrado. La forma, el canal de señal, la autonomía energética, los materiales, el precio y la adopción sostenida deberán definirse mediante desarrollo y pruebas. La propuesta mantiene su carácter phygital, pero la configuración del componente físico puede cambiar si la evidencia muestra que otra relación objetual responde mejor al problema.

## 10.10 Mapa de actores

| Actor | Relación con Relevo | Necesidad o responsabilidad principal |
| --- | --- | --- |
| Usuario principal | Formula la intención, sitúa el objeto e interpreta la señal. | Comprensión, control, privacidad y carga razonable. |
| Usuario límite | Utiliza el teléfono en una actividad que conserva sentido. | No recibir una intervención injustificada. |
| Convivientes | Comparten el espacio donde puede aparecer la señal. | Discreción y ausencia de molestias. |
| Diseñador | Articula investigación, experiencia, forma y evaluación. | Mantener coherencia entre problema y decisiones. |
| Desarrollo Android | Implementa permisos, condición, estados y comunicación. | Funcionamiento comprensible y recuperación de fallos. |
| Desarrollo electrónico | Resuelve energía, enlace y componentes que producen luz, vibración o sonido. | Fiabilidad, seguridad y mantenimiento. |
| Fabricación y proveedores | Producen carcasa, circuito y ensamblaje. | Costos, trazabilidad y reparación. |
| Especialistas en accesibilidad | Revisan canales, controles y barreras de uso. | Evitar exclusiones y promesas no comprobadas. |

# 11. Bajada proyectual

## 11.1 Sistema phygital

Relevo distribuye funciones entre tres elementos: una aplicación, un objeto y el entorno. La aplicación conserva la información y configura la condición. El objeto hace visible que existe una intención activa y emite la señal. El lugar relaciona esa señal con una acción posible. La persona reúne esas partes mediante una asociación que ella misma decide.

Esta distribución evita que el objeto repita la aplicación. Su función no es mostrar instrucciones, administrar estadísticas ni reemplazar el teléfono. Tampoco actúa como llave de bloqueo. Su aporte esperado reside en estar cerca del primer paso y en permitir que la intención reaparezca fuera de la pantalla donde transcurre la sesión.

La relación puede representarse de la siguiente manera:

> intención personal → primer paso → lugar elegido → condición configurada → pulso ambiental → decisión de la persona

Los primeros elementos se preparan antes de la sesión. El pulso aparece solo mientras la regla se encuentra activa y dentro de una ventana vigente. Después de la señal, el sistema no interpreta qué decisión tomó la persona.

## 11.2 Aplicación Android

La aplicación cumple cinco funciones principales. Primero, permite nombrar una actividad en lenguaje cotidiano. Segundo, ayuda a convertirla en un primer paso concreto. Tercero, vincula el objeto correspondiente. Cuarto, configura y explica la condición que puede activar la señal. Quinto, muestra estados técnicos y permite detener o modificar el ciclo.

El recorrido debe reducir preguntas y evitar convertir la preparación en una tarea extensa. Una intención como hacer ejercicio todavía es amplia. La aplicación puede pedir una respuesta más próxima: ponerse las zapatillas. Después solicita que la persona elija dónde ubicará el objeto, sin intentar detectar ese lugar automáticamente.

La condición de activación permanece abierta a comparación. Puede basarse en continuidad de uso, tiempo acumulado dentro de una ventana o una franja horaria. Cada alternativa debe explicarse con ejemplos. El sistema no utiliza expresiones como detectar distracción o reconocer pérdida de control, porque esos estados no pueden deducirse desde un registro técnico.

La interfaz también debe distinguir entre información personal y estado del sistema. La intención y el primer paso pertenecen a la persona. Permiso revocado, objeto desconectado o batería baja son estados técnicos. Separarlos evita que un fallo de comunicación se presente como una decisión del usuario.

## 11.3 Objeto Relevo

El objeto se concibe como un cuerpo compacto y transportable que puede ubicarse sobre distintas superficies del hogar. Su presencia indica que existe una intención activa vinculada a ese lugar. Una superficie de señal difusa permite emitir un pulso visible desde diferentes ángulos, mientras un control físico accesible permite silenciarlo o probarlo.

La forma circular se mantiene como hipótesis porque evita una orientación frontal rígida y facilita una lectura ambiental. No se fijan aún medidas, peso, color o material definitivo. Esas decisiones dependen de la distancia de percepción, el espacio para batería y componentes, la estabilidad sobre la superficie y la posibilidad de abrir el cuerpo para reparar.

El objeto debe diferenciar tres estados sin exigir una vigilancia constante: reposo, señal y necesidad de atención técnica. La señal vinculada a la intención requiere un comportamiento distinto de batería baja o pérdida de conexión. Si ambos estados se expresan del mismo modo, el significado se vuelve ambiguo.

La transportabilidad permite que una misma persona relacione el objeto con actividades diferentes. También crea riesgos: puede perderse, cambiar de lugar, quedar cubierto o asociarse con demasiadas intenciones. Por esa razón, el alcance inicial considera una sola intención activa y exige probar la señal después de cada cambio de ubicación.

## 11.4 El primer paso y el lugar

La asociación espacial constituye el centro de la propuesta. El lugar no funciona como una coordenada detectada por el sistema, sino como una relación elegida. Para leer, el objeto puede situarse junto al libro. Para caminar, cerca de las zapatillas. Para dibujar, al lado de los materiales. La proximidad busca unir el recuerdo de la actividad con una acción que puede comenzar.

La persona debe poder explicar por qué ese lugar es pertinente. Esta explicación no se registra como una prueba de eficacia, pero ayuda a comprobar que la asociación tiene sentido antes de activar. Si el objeto se coloca en un espacio neutro y sigue produciendo la misma comprensión, la ubicación quizá no aporte el valor esperado.

El hogar exige flexibilidad. Las superficies cambian, los objetos se mueven y otras personas pueden compartir el espacio. El sistema debe permitir reubicar, probar y volver a armar sin sanciones. También debe evitar que la intención quede expuesta mediante texto o señales demasiado específicas.

## 11.5 Secuencia de uso

1. **Elegir una intención.** La persona identifica una actividad que desea mantener disponible.
2. **Definir el primer paso.** Expresa una acción concreta que permite comenzar.
3. **Vincular el objeto.** La aplicación confirma la identidad y el estado técnico del dispositivo.
4. **Situar.** El objeto se coloca junto al primer paso y se comprueba la relación con el lugar.
5. **Probar la señal.** La persona revisa si el pulso puede percibirse y detenerse.
6. **Configurar la condición.** Se elige una regla observable y una ventana de vigencia.
7. **Armar.** La persona activa el ciclo de manera explícita.
8. **Esperar.** La sesión digital transcurre sin que el sistema juzgue su valor.
9. **Recibir el pulso.** Si la condición se cumple y la conexión está disponible, el objeto emite la señal.
10. **Decidir.** La persona puede iniciar la actividad, continuar, ignorar o silenciar.
11. **Cerrar o rearmar.** El ciclo termina, cambia de intención o se prepara nuevamente.

La secuencia no exige consultar la aplicación después del pulso para comprender qué intención representa. El teléfono reaparece cuando es necesario configurar, modificar o resolver un estado técnico.

## 11.6 Flujo del sistema

La persona formula el contenido y establece la regla. Android consulta localmente la condición autorizada. Cuando el evento ocurre dentro de una ventana vigente, la aplicación envía un comando al objeto mediante Bluetooth de baja energía, una comunicación inalámbrica de corto alcance diseñada para consumir poca energía. El objeto verifica que el mensaje corresponda al ciclo activo y ejecuta el patrón de señal. Una vez silenciado o vencido, vuelve a reposo.

El comando necesita, como mínimo, una identificación de ciclo, un patrón y un vencimiento. Esta información evita que una señal retrasada aparezca cuando ya perdió sentido. El objeto no conserva el texto de la intención ni decide cuándo activarse por cuenta propia.

Ante un fallo, el sistema debe priorizar la claridad. Si se revoca un permiso, se limita la ejecución en segundo plano —la capacidad de continuar una tarea aunque la aplicación no esté visible—, se pierde la conexión o la batería es insuficiente, la aplicación informa el estado y permite desarmar. No debe aparentar que una condición fue evaluada cuando no existían los medios técnicos para hacerlo.

## 11.7 Estados principales

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

La arquitectura detallada contempla validaciones, errores y retornos. Algunos estados se representan en la aplicación; otros ocurren en el objeto o en la relación de la persona con el lugar. Distinguirlos evita que cada contingencia se transforme en una función visible.

## 11.8 Flujo de diseño

El desarrollo avanza desde la pregunta hacia la especificación. Primero debe comprobarse que una señal puede recuperar la intención. Después se compara el lugar elegido con un lugar neutro y con una notificación. Solo si existe una diferencia se define el canal físico, se integra la electrónica y se estudia una forma de mayor fidelidad, es decir, más próxima a las condiciones de uso y funcionamiento que se quieren evaluar.

La secuencia proyectual es la siguiente:

1. Delimitar el episodio pertinente y el caso donde no se debe intervenir.
2. Probar la relación entre intención, primer paso, lugar y señal.
3. Comparar la alternativa situada con una notificación digital.
4. Definir canal, intensidad, duración y control físico.
5. Seleccionar una condición observable y su vencimiento.
6. Probar permisos, comunicación y fallos.
7. Integrar aplicación, objeto y entorno en un prototipo acotado.
8. Revisar fabricación, mantenimiento, privacidad y accesibilidad.

Una especificación formal o técnica que aparezca antes de resolver la pregunta correspondiente se mantiene como candidata. Este criterio evita que la disponibilidad de un componente determine el sentido del proyecto.

## 11.9 Privacidad, autonomía y convivencia

La aplicación necesita conservar la intención, el primer paso, la condición y el estado del objeto para ejecutar un ciclo. Esa información debería permanecer en el teléfono durante el prototipo y poder eliminarse de manera clara. Consultar una condición autorizada no exige conservar un historial de aplicaciones ni calificar la conducta posterior. El objeto recibe solo lo necesario para ejecutar la señal. Ninguno de los componentes registra si la persona inició la actividad, continuó con el teléfono o ignoró el pulso.

El control debe estar disponible en ambos componentes. Desde la aplicación se puede pausar, editar o desarmar. Desde el objeto se puede silenciar el pulso. La ausencia de respuesta no produce recordatorios repetidos, culpa o pérdida de funciones.

La convivencia requiere probar distancia, brillo, vibración o sonido según el canal elegido. Una señal útil para una persona puede ser molesta para otra. Tampoco debe revelar el contenido de la intención. Su carácter ambiental permite que el significado sea personal, pero esa discreción tendrá que comprobarse en contextos reales.

## 11.10 Accesibilidad

La accesibilidad se estudiará por dimensiones visuales, auditivas, táctiles, cognitivas y motoras. Ningún canal aislado puede declararse universal. Una luz puede pasar inadvertida; una vibración depende de la superficie; un sonido puede molestar o no percibirse. El prototipo deberá permitir comparar canales y facilitar el control físico sin movimientos precisos.

Las Pautas de Accesibilidad para el Contenido Web ofrecen un criterio preventivo frente a destellos, aunque cumplirlo no demuestra que una señal sea perceptible o adecuada (World Wide Web Consortium, s. f.). En la aplicación, los estados deben explicarse con lenguaje claro y no depender solo del color.

# 12. Factibilidad y límites

## 12.1 Plataforma digital

El primer prototipo integrado se desarrollará para Android. La decisión responde a dos capacidades necesarias: consultar estadísticas autorizadas de otras aplicaciones mediante UsageStatsManager, una interfaz de programación provista por Android, y comunicarse con un dispositivo cercano mediante Bluetooth de baja energía. Ambas funciones cuentan con documentación nativa y permiten construir una prueba acotada (Google, s. f.-a, s. f.-b, s. f.-d).

Un sitio web sería más fácil de distribuir y permitiría acceso desde distintos sistemas. Sin embargo, el navegador no puede observar de manera confiable el uso de otras aplicaciones del teléfono ni mantener las mismas condiciones de ejecución en segundo plano. Web Bluetooth, la interfaz que permite a ciertos navegadores comunicarse con dispositivos cercanos compatibles, tampoco resuelve el acceso al uso global del teléfono (Chrome for Developers, s. f.). Por estas razones, una versión web no puede ejecutar el núcleo técnico del prototipo.

iPhone ofrece marcos de desarrollo como Device Activity y Family Controls, destinados a observar actividad autorizada y aplicar controles definidos por la persona. Su implementación depende de permisos, capacidades y procesos de distribución específicos de Apple (Apple Developer, s. f.-a, s. f.-b, s. f.-c). Incorporar ambos sistemas durante la primera etapa duplicaría desarrollo y pruebas antes de comprobar la hipótesis central. La elección de Android concentra recursos; no impide estudiar otras plataformas si el mecanismo demuestra valor.

Las capacidades de Android también tienen límites. UsageStatsManager requiere que la persona conceda desde los ajustes un permiso especial para consultar estadísticas de uso y no detecta estados subjetivos. La ejecución en segundo plano y la comunicación Bluetooth varían según versión, fabricante y políticas de energía. El prototipo deberá probar pantalla bloqueada, cambio de aplicación, reinicio, pérdida de permiso y reconexión. No se afirma compatibilidad universal.

## 12.2 Arquitectura técnica

La aplicación conserva la información del ciclo y evalúa la condición de manera local. Bluetooth de baja energía transporta el comando hacia el objeto. Esta arquitectura reduce el envío de datos a servicios externos y permite que el dispositivo físico se mantenga simple. Procesamiento local no significa privacidad absoluta: los permisos, registros y respaldos deben documentarse.

Un microcontrolador —circuito programable que ejecuta la lógica del objeto— como el ESP32-C3 puede facilitar las primeras pruebas por su disponibilidad. Para una etapa de menor consumo se considera la familia de microcontroladores nRF52 y un circuito de gestión de alimentación y carga como el nPM1100. Los actuadores, componentes que transforman una orden eléctrica en una salida perceptible, podrían producir luz difusa, vibración o sonido breve. Las hojas técnicas de Nordic Semiconductor, Precision Microdrives y Texas Instruments ayudan a estimar capacidades, pero no prueban autonomía ni percepción del conjunto (Nordic Semiconductor ASA, s. f.-a, s. f.-b; Precision Microdrives Ltd., 2023; Texas Instruments, 2018).

La batería y el sistema de carga deberán seleccionarse a partir de mediciones del ciclo real: reposo, conexión, señal y recuperación. También se revisarán temperatura, seguridad, reemplazo y fin de vida. Una cifra de consumo aislada no basta para prometer duración.

## 12.3 Fabricación y reparación

La etapa académica puede utilizar una carcasa impresa y componentes de desarrollo. Este método permite modificar dimensiones, apertura y posición de los actuadores con rapidez. No representa un producto industrial ni permite calcular directamente el costo de fabricación en serie.

Una versión posterior podría incorporar una placa de circuito propia, carcasa resistente y elementos separados para señal y control. El cierre deberá permitir diagnóstico y reemplazo de batería, placa o actuador. Sellar completamente el cuerpo solo sería pertinente si una exigencia de seguridad o resistencia demuestra mayor importancia que la reparación.

El mantenimiento cotidiano incluye carga, revisión de conexión, prueba después de reubicar y actualización de la aplicación. Si estas acciones resultan demasiado frecuentes, la experiencia pierde proporcionalidad. El diseño físico debe hacer comprensible la carga sin añadir alertas constantes.

Al final de su vida útil, batería, placa y carcasa deberían separarse. Esta condición orienta la elección de materiales y uniones. La sostenibilidad no puede resolverse únicamente con un material reciclable si el conjunto impide reparación o separación.

## 12.4 Costos

La estimación preliminar del prototipo distingue componentes, fabricación de carcasa, reposición, ensamblaje básico y una contingencia, entendida como reserva para imprevistos o variaciones de precio. El rango calculado se sitúa entre CLP 51.140 y CLP 92.640. Al incorporar una contingencia de 15 %, el presupuesto se comunica como **CLP 59.000–107.000**.

Esta cifra no corresponde al precio del producto. Tampoco incluye horas profesionales, certificación, desarrollo completo, impuestos, soporte, garantía o producción en serie. Para evitar confusiones se separan cuatro magnitudes:

1. costo del prototipo académico;
2. trabajo profesional de investigación, diseño, programación y electrónica;
3. costo de producción, logística y soporte;
4. precio eventual y disposición de pago.

La producción en cantidad exigirá cotizaciones de placa, carcasa, batería, ensamblaje, pruebas, embalaje, distribución y merma, término que designa el material o las unidades perdidas durante la fabricación. Antes de ese cálculo debe comprobarse que la capa física aporta valor. Escalar una solución no validada solo aumenta el costo del supuesto.

## 12.5 Cumplimiento y seguridad

Un objeto con comunicación por radio deberá revisar la normativa chilena aplicable a equipos de alcance reducido, junto con ensayos, documentación y etiquetado (Subsecretaría de Telecomunicaciones, 2026a). El uso de batería incorpora exigencias adicionales de transporte, carga y protección. El prototipo académico no equivale a certificación de producto.

La distribución de la aplicación también depende de los requisitos de Android y Google Play, especialmente cuando se emplean servicios en primer plano, tareas persistentes que deben informar su actividad mediante una notificación visible, o permisos sensibles (Google Play, s. f.). Estas condiciones pueden cambiar y deberán verificarse antes de publicar.

## 12.6 Modelo de gestión

El proyecto requiere colaboración entre diseño de interacción, diseño industrial, desarrollo Android y electrónica. La investigación con usuarios necesita protocolos de consentimiento y revisión de accesibilidad. La fabricación requiere proveedores capaces de documentar materiales, componentes y pruebas.

El diseñador mantiene la coherencia del sistema y registra las decisiones, pero no reemplaza el conocimiento especializado. El desarrollador Android valida permisos y estados; electrónica mide energía y enlace; diseño industrial resuelve forma, ensamblaje y reparación; especialistas en accesibilidad revisan barreras; y proveedores entregan costos reales.

Un posible modelo inicial corresponde a producción acotada con aplicación complementaria y soporte directo. Todavía no es posible elegir entre venta única, suscripción o distribución institucional. Ninguna entrevista estudió disposición de pago y los precios de referentes no representan automáticamente el valor de Relevo.

## 12.7 Límites

Las entrevistas fueron realizadas a ocho personas reclutadas mediante referencias. La edad fue el único criterio común y no se observaron las conductas ni los hogares. Los resultados no permiten estimar prevalencia, definir un mercado ni afirmar que la propuesta será aceptada.

La condición de activación, el canal de señal, la forma, la autonomía, los materiales y los costos reales continúan abiertos. Tampoco se ha demostrado que el objeto ayude a recuperar intenciones, que el lugar produzca una diferencia o que la experiencia sea preferible a una notificación.

El alcance no incluye adicción, tratamiento clínico, control parental, vigilancia, productividad general ni reducción universal del tiempo de pantalla. El sistema tampoco busca detectar emociones o interpretar la calidad del ocio. Estas exclusiones mantienen el problema dentro de una escala abordable desde Diseño.

# 13. Plan de desarrollo y validación

El desarrollo se organiza en etapas consecutivas. Cada una responde una pregunta antes de aumentar fidelidad. Esta secuencia permite distinguir un problema conceptual de uno formal o técnico y evita construir una integración completa sin saber si la asociación básica se comprende.

## 13.1 Asociación entre intención, señal y lugar

La primera prueba utiliza un objeto simple y una activación manual. La persona formula una intención y su primer paso, elige un lugar y recibe una señal simulada durante otra actividad. El objetivo es conocer si puede relacionar el pulso con la intención sin consultar el teléfono.

El registro distinguirá cuatro momentos: percepción de la señal, atribución al sistema, recuperación de la intención e identificación del primer paso. Iniciar la actividad no será requisito. Si la señal se percibe pero no permite reconstruir el significado, la asociación deberá reformularse antes de avanzar.

## 13.2 Comparación con alternativas

La segunda etapa compara tres condiciones: objeto en un lugar relacionado con el primer paso, el mismo objeto en un lugar neutro y una notificación digital equivalente. Se mantendrán constantes el contenido, el momento y la duración en la medida de lo posible.

La comparación busca saber si el lugar o la materialidad aportan una diferencia reconocible. Se observarán comprensión, necesidad de consultar el teléfono, carga, intrusión y control. Si la notificación ofrece el mismo apoyo con menor esfuerzo, la configuración física deberá reconsiderarse.

## 13.3 Forma, canal y salida

Una vez sostenida la asociación, se compararán formas y canales. Luz, vibración y sonido breve se probarán sobre superficies y distancias reales. También se evaluará el control para silenciar, la estabilidad del objeto y su lectura como parte del entorno.

La selección no se basará solo en preferencia. Debe considerar percepción, privacidad, convivencia, accesibilidad y consumo energético. Una señal intensa puede ser visible y, al mismo tiempo, resultar invasiva. Un canal discreto puede respetar el entorno y pasar inadvertido. El equilibrio se definirá mediante evidencia situada.

## 13.4 Integración técnica

La cuarta etapa incorpora aplicación Android, condición observable, comunicación Bluetooth, vencimiento y estados de error. Se probarán permisos, pantalla bloqueada, cambio de aplicación, pérdida de conexión, batería baja, reinicio y comandos tardíos.

El propósito no es demostrar que el sistema funciona en todos los teléfonos. Se busca documentar una arquitectura acotada y comprender sus fallos. La interfaz debe informar cuando una condición no puede evaluarse y evitar señales fuera de tiempo.

## 13.5 Piloto situado

Solo después de resolver las etapas anteriores se realizará un piloto doméstico de duración acotada. El protocolo definirá número de participantes, días de uso, criterios de inclusión, consentimiento, registros y forma de retiro. Se observarán armado, reubicación, pérdida, carga, convivencia, abandono y habituación, entendida como la disminución de la respuesta ante una señal repetida.

El piloto no permitirá afirmar eficacia poblacional ni adopción comercial. Su función será conocer si la relación conserva sentido fuera de una sesión guiada y si el mantenimiento cotidiano sigue siendo proporcional.

## 13.6 Instrumentos de registro

Cada prueba utilizará una ficha con fecha, versión, pregunta, participantes codificados, contexto, materiales, procedimiento, evidencia, interpretación, límites y decisión. Las observaciones se separarán de las inferencias. Una persona que mire el objeto no necesariamente comprendió la intención; una conexión correcta no demuestra que la señal sea útil.

Los instrumentos combinarán observación, preguntas abiertas, reconstrucción del significado, registro de errores y comparación entre condiciones. Las escalas breves —cuestionarios de pocos ítems para recoger una valoración acotada— podrán apoyar la lectura de carga o intrusión, pero no reemplazarán el relato del episodio. También se conservarán contraejemplos y razones de abandono.

Estos registros pertenecen a la investigación y no a las funciones de Relevo. Se obtendrán con consentimiento, se asociarán a códigos de participante y se conservarán durante el periodo que defina cada protocolo. Su propósito será revisar los prototipos, no construir historiales personales ni comprobar obediencia. Fuera de una prueba, el sistema no necesitará saber qué decisión tomó la persona después del pulso.

## 13.7 Criterios de decisión

La propuesta se mantiene cuando la señal puede relacionarse con la intención, el lugar aporta una diferencia, la salida es clara y la ejecución técnica resulta proporcional. Se modifica cuando falla una capa específica, como intensidad, vínculo, forma o explicación. Se detiene cuando el componente físico no ofrece una ventaja frente a la notificación o cuando ninguna alternativa evita intrusión, vigilancia o una carga excesiva.

Los resultados se comunicarán según su alcance. Una prueba conceptual puede sostener comprensión en una situación; no demuestra uso prolongado. Una integración técnica documenta funcionamiento bajo ciertas condiciones; no valida la experiencia. Un piloto aporta indicios situados; no permite generalizar a toda la población.

## 13.8 Conclusiones

Esta investigación preguntó qué condiciones pueden ayudar a que una persona vuelva a considerar una actividad elegida cuando, durante una sesión de ocio digital, esa intención deja de orientar su decisión inmediata. La evidencia reunida no ofrece una respuesta definitiva, pero permite establecer cuatro condiciones iniciales. La intención debe provenir de la persona; su comienzo necesita expresarse mediante un primer paso reconocible; cualquier intervención tiene que permitir continuar, cambiar de idea o ignorarla; y no corresponde intervenir cuando la actividad digital conserva sentido para quien la realiza.

Las entrevistas muestran que esta tensión aparece en algunos relatos, pero no en todos ni de la misma manera. También registran experiencias digitales recordadas como significativas y estrategias personales para separarse del teléfono. Por ello, el usuario principal y el usuario límite describen situaciones, no grupos demográficos estables. La edad permite caracterizar a quienes participaron, pero no explica el problema ni autoriza a generalizarlo a todos los adultos jóvenes.

Los antecedentes muestran que medir, pausar, bloquear, separar y recordar cumplen funciones diferentes. Ninguna de ellas sustituye por sí sola la recuperación situada de una actividad alternativa. Frente a ese límite, la decisión proyectual consiste en articular intención, primer paso, señal y lugar. El medio elegido es phygital: la aplicación conserva y configura la información, mientras el objeto lleva una señal al espacio donde la actividad puede comenzar. Esta articulación define la propuesta de valor que Relevo busca ofrecer; todavía no demuestra que el objeto produzca una ayuda mayor que una notificación.

El aporte alcanzado pertenece a la investigación y a la estructuración del proyecto. La memoria delimita un problema abordable desde Diseño, establece criterios de autonomía y no intervención, identifica dos situaciones de usuario, analiza respuestas existentes y organiza una arquitectura de uso, sistema y desarrollo. Los wireframes permiten examinar el recorrido y sus estados, pero no demuestran comprensión, eficacia o preferencia.

La hipótesis pendiente reúne las relaciones que el desarrollo deberá comprobar: si la señal permite reconocer la intención sin consultar el teléfono, si un lugar relacionado con el primer paso aporta más que una ubicación neutra y si el objeto ofrece una diferencia suficiente frente a una notificación. También continúan abiertos la condición de activación, el canal sensorial, la convivencia doméstica, la accesibilidad, la integración técnica, la producción y los costos definitivos. Estas preguntas deberán resolverse antes de cerrar la forma y fabricar una solución completa.

El criterio de continuidad comienza con una prueba controlada de la asociación entre intención, señal, primer paso y lugar. Si esa relación resulta comprensible, corresponderá compararla con una notificación y con una ubicación neutra. Si el objeto no aporta una diferencia reconocible o introduce una carga desproporcionada, deberá reformularse la relación entre los componentes físicos y digitales. La continuidad de Relevo dependerá de lo que los prototipos permitan aprender y no de sostener anticipadamente una configuración.

# 14. Referencias

Apple. (s. f.). *Get started with Screen Time on iPhone*. Recuperado el 24 de agosto de 2026, de https://support.apple.com/en-ie/guide/iphone/iphb0c7313c9/ios

Apple Developer. (s. f.-a). *Core Bluetooth*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/CoreBluetooth

Apple Developer. (s. f.-b). *Device Activity*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/DeviceActivity

Apple Developer. (s. f.-c). *Family Controls App and Website Usage*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/bundleresources/entitlements/com.apple.developer.family-controls.app-and-website-usage

Biedermann, D., Schneider, J., & Drachsler, H. (2021). Digital self-control interventions for distracting media multitasking: A systematic review. *Journal of Computer Assisted Learning, 37*(5), 1217–1231. https://doi.org/10.1111/jcal.12581

Brick LLC. (s. f.-a). *Brick: Take back your time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/

Brick LLC. (s. f.-b). *Brick Zone*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/pages/brick-zone

Chiu, G., & Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

Chrome for Developers. (s. f.). *Communicating with Bluetooth devices over JavaScript*. Recuperado el 25 de agosto de 2026, de https://developer.chrome.com/docs/capabilities/bluetooth

de Segovia Vicente, D., Van Gaeveren, K., Murphy, S. L., & Vanden Abeele, M. M. P. (2024). Does mindless scrolling hamper well-being? Combining ESM and log-data to examine the link between mindless scrolling, goal conflict, guilt, and daily well-being. *Journal of Computer-Mediated Communication, 29*(1), zmad056. https://doi.org/10.1093/jcmc/zmad056

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Gilbert, S. J., Boldt, A., Sachdeva, C., Scarampi, C., & Tsai, P.-C. (2023). Outsourcing memory to external tools: A review of intention offloading. *Psychonomic Bulletin & Review, 30*(1), 60–76. https://doi.org/10.3758/s13423-022-02139-4

Goldsmith, L. J. (2021). Using framework analysis in applied qualitative research. *The Qualitative Report, 26*(6), 2061–2076. https://doi.org/10.46743/2160-3715/2021.5011

Gollwitzer, P. M., & Sheeran, P. (2006). Implementation intentions and goal achievement: A meta-analysis of effects and processes. *Advances in Experimental Social Psychology, 38*, 69–119. https://doi.org/10.1016/S0065-2601(06)38002-1

Google. (s. f.-a). *Communicate in the background*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (s. f.-b). *Companion device pairing*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/develop/connectivity/companion-device-pairing

Google. (s. f.-c). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Recuperado el 24 de agosto de 2026, de https://support.google.com/pixelphone/answer/9137850

Google. (s. f.-d). *UsageStatsManager*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/reference/android/app/usage/UsageStatsManager

Google Play. (s. f.). *Foreground service requirements for apps targeting Android 14 or higher*. Google Play Console Help. Recuperado el 24 de agosto de 2026, de https://support.google.com/googleplay/android-developer/answer/17105854

Grüning, D. J., Riedel, F., & Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), e2213114120. https://doi.org/10.1073/pnas.2213114120

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A., & Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (Artículo 243, pp. 1–16). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hermann, M., Mahler, T., de Melo, G., & Weber, M. (2007). The tangible reminder. En *Proceedings of the 3rd IET International Conference on Intelligent Environments* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

Kidel Peña-Albert, A., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C., & Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, e85349. https://doi.org/10.2196/85349

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Kitchen Safe. (s. f.). *kSafe*. Recuperado el 24 de agosto de 2026, de https://intl.thekitchensafe.com/

Lukoff, K., Yu, C., Kientz, J. A., & Hiniker, A. (2018). What makes smartphone use meaningful or meaningless? *Proceedings of the ACM on Interactive, Mobile, Wearable and Ubiquitous Technologies, 2*(1), Artículo 22. https://doi.org/10.1145/3191754

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M., & Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (Paper 21, pp. 1–18). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

McDaniel, M. A., & Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*, S127–S144. https://doi.org/10.1002/acp.775

Meier, A., & Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Monge Roffarello, A., & De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53, 1–66. https://doi.org/10.1145/3571810

Montag, C., Lachmann, B., Herrlich, M., & Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), 2612. https://doi.org/10.3390/ijerph16142612

Nordic Semiconductor ASA. (s. f.-a). *nPM1100 product specification*. Recuperado el 24 de agosto de 2026, de https://docs.nordicsemi.com/r/bundle/ps_npm1100/page/keyfeatures_html5.html

Nordic Semiconductor ASA. (s. f.-b). *nRF52810 product specification*. Recuperado el 24 de agosto de 2026, de https://docs-be.nordicsemi.com/bundle/nRF52810-PS/raw/resource/enus/nRF52810_PS_v1.1.pdf

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

O’Rear, A. E., & Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

Precision Microdrives Ltd. (2023). *C08-00A: 8 mm linear resonant actuator* [Hoja de datos]. https://precisionmicrodrives.com/cdn/datasheets/C08-00A%20-%20datasheet%20-%20002/c08-00a-datasheet-002.pdf

Radtke, T., Apel, T., Schenkel, K., Keller, J., & von Lindern, E. (2022). Digital detox: An effective solution in the smartphone era? A systematic literature review. *Mobile Media & Communication, 10*(2), 190–215. https://doi.org/10.1177/20501579211028647

Risko, E. F., & Gilbert, S. J. (2016). Cognitive offloading. *Trends in Cognitive Sciences, 20*(9), 676–688. https://doi.org/10.1016/j.tics.2016.07.002

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Sohn, T., Li, K. A., Lee, G., Smith, I., Scott, J., & Griswold, W. G. (2005). Place-Its: A study of location-based reminders on mobile phones. En M. Beigl, S. Intille, J. Rekimoto, & H. Tokuda (Eds.), *UbiComp 2005: Ubiquitous computing* (Lecture Notes in Computer Science, Vol. 3660, pp. 232–250). Springer. https://doi.org/10.1007/11551201_14

Stapley, E., O’Keeffe, S., & Midgley, N. (2022). Developing typologies in qualitative research: The use of ideal-type analysis. *International Journal of Qualitative Methods, 21*, 1–9. https://doi.org/10.1177/16094069221100633

Subsecretaría de Telecomunicaciones. (2026a, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Subsecretaría de Telecomunicaciones. (2026b). *Informe final: Estudio Duodécima Encuesta sobre acceso, usos y usuarios de Internet en Chile*. Ministerio de Transportes y Telecomunicaciones, Gobierno de Chile. https://www.subtel.gob.cl/wp-content/uploads/2026/02/Informe-Final-Acceso-y-Uso-Internet-2025_03.pdf

Texas Instruments. (2018). *DRV2605L: 2- to 5.2-V haptic driver for LRA and ERM with effect library and Smart-Loop architecture* [Hoja de datos]. https://www.ti.com/lit/ds/symlink/drv2605l.pdf

Tonietto, G. N., Malkoc, S. A., Reczek, R. W., & Norton, M. I. (2021). Viewing leisure as wasteful undermines enjoyment. *Journal of Experimental Social Psychology, 97*, 104198. https://doi.org/10.1016/j.jesp.2021.104198

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Waggoner, J., Lucky, S., Redick, S., Rizki, A., & Yu, J. C. (2026). Going beyond digital libraries: A literature review of phygital user experience research methods. *International Journal on Digital Libraries, 27*(1), Artículo 1. https://doi.org/10.1007/s00799-025-00436-6

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 24 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold

---

## Registro de cambios

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
