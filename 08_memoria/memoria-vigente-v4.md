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

Relevo propone un sistema phygital: integra una aplicación Android y un objeto físico situado cerca del primer paso de una actividad elegida. Cuando se cumple una condición configurada por la persona, el objeto emite una señal ambiental breve. Su propósito es hacer nuevamente perceptible la intención, sin bloquear el teléfono ni decidir qué debe ocurrir después. La propuesta se entiende como una hipótesis de diseño que deberá comprobar su aporte frente al aviso digital definido para la prueba.

**Palabras clave:** ocio digital, memoria prospectiva, autonomía, diseño phygital.

## Abstract

Digital leisure has become part of everyday life. Talking to others, playing games, watching videos, or browsing social media can be legitimate forms of rest and entertainment. Nevertheless, some sessions continue without the person making a renewed decision to remain engaged. At such moments, another activity they intended to pursue may no longer come to mind while there is still time to begin it. The issue does not lie in the phone itself or in a universal amount of time, but in the difficulty of recovering a personal intention within an interaction that continuously offers more content.

This study draws on literature about leisure experience, goal conflict, prospective memory, digital wellbeing, and tangible interaction. It also considers eight semi-structured interviews with people aged 19 to 27 and an analysis of tools that measure, interrupt, or block phone use. The evidence suggests that digital experiences cannot be assessed through duration alone and that existing responses largely focus on restricting the current activity. Two use situations emerge from the analysis: one in which an alternative intention loses salience, and another in which the digital activity remains meaningful and should not be interrupted.

Relevo is formulated as a phygital system: it combines an Android application with a physical object placed near the first step of a chosen activity. When a user-defined condition is met, the object emits a brief ambient signal. Its purpose is to make the intention perceptible again without blocking the phone or deciding what should happen next. The proposal is presented as a design hypothesis whose contribution must be assessed against the digital notice defined for the test.

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

Las herramientas revisadas frente a esta situación miden el tiempo, fijan límites, bloquean aplicaciones o introducen pausas antes de abrirlas (Apple, s. f.; Google, s. f.-c; Lyngs et al., 2019). Tales recursos pueden ser útiles cuando alguien quiere reducir una conducta concreta. Sin embargo, detener la actividad presente no basta para recuperar aquello que se quería hacer. Un bloqueo puede cerrar una aplicación y, al mismo tiempo, dejar ausente la intención alternativa. También puede interrumpir una conversación o un descanso que la persona sí desea mantener. Por eso resulta necesario distinguir entre impedir una acción y volver perceptible otra posibilidad.

La memoria prospectiva permite precisar esta diferencia. El concepto se refiere a la capacidad de recordar una acción que se quiere realizar en el futuro cuando aparece una ocasión adecuada (McDaniel & Einstein, 2000). Recordar al final del día que se quería leer no equivale a recuperar esa intención cuando todavía existía la oportunidad de abrir el libro. Desde esta perspectiva, el problema no consiste en almacenar una meta, sino en encontrar una señal pertinente que ayude a traerla de vuelta al presente.

Esta investigación pregunta cómo puede el Diseño apoyar la recuperación oportuna de una intención personal durante una sesión de ocio digital, sin prohibir la actividad actual ni imponer una jerarquía entre formas de descanso. Para responder, es necesario estudiar la experiencia subjetiva del ocio, las decisiones de interfaz que sostienen la continuidad, el papel del contexto y las formas en que las personas delegan parte del recuerdo en objetos, notas o alarmas. También es indispensable conocer qué soluciones existen, qué problemas resuelven y qué aspectos dejan abiertos.

# 3. Planteamiento del problema

En 2025, el 96,6 % de los hogares chilenos declaró contar con acceso propio y pagado a internet. Entre los hogares conectados, el teléfono inteligente fue el dispositivo más extendido, con una presencia declarada de 99,1 % (Subsecretaría de Telecomunicaciones, 2026b). Estas cifras describen un entorno ampliamente conectado, pero no permiten determinar el valor de una experiencia digital. Para comprender la situación estudiada importa observar la relación entre la actividad presente, otras intenciones y el momento de elegir.

El problema se organiza en tres aristas. Cada una examina una parte de la situación y evita atribuirla a una causa única.

## Arista experiencial y cognitiva

Una persona puede iniciar una actividad digital con un propósito claro y, mientras la realiza, mantener otras intenciones para ese mismo periodo. El conflicto aparece cuando la sesión se prolonga y alguna de esas alternativas deja de orientar la acción inmediata. Recordarla más tarde demuestra que no desapareció necesariamente de la memoria, pero también que no fue recuperada cuando podía participar en la decisión.

De Segovia Vicente et al. (2024) estudiaron el desplazamiento digital percibido como carente de propósito mediante evaluaciones cotidianas y registros del teléfono. Los episodios más prolongados se asociaron con mayor conflicto entre la actividad digital y otras metas, además de mayor culpa reportada. El estudio no demuestra causalidad ni permite considerar perjudicial toda sesión extensa. Sí muestra que la relación con otras intenciones influye en la experiencia.

La dificultad, entonces, no se define como un daño a la memoria ni como una incapacidad permanente. Se presenta en momentos concretos, cuando una intención deja de estar disponible para orientar el siguiente paso. Esta precisión permite estudiar el fenómeno sin diagnosticar a la persona y sin suponer que necesita dejar el teléfono cada vez que lo utiliza.

## Arista tecnológica

Las sesiones digitales ocurren dentro de interfaces diseñadas. El desplazamiento infinito, la reproducción automática y las recomendaciones consecutivas reducen los momentos en que hace falta decidir si se quiere continuar. A diferencia de una página, un capítulo o una pieza con término reconocible, estos patrones mantienen abierta la secuencia y ofrecen una acción siguiente con muy poco esfuerzo (Montag et al., 2019).

El propósito, el estado de ánimo, el contexto y los hábitos también influyen. Sin embargo, explicar la experiencia únicamente como falta de disciplina omite que el diseño organiza cierres, transiciones y oportunidades de elección. Pedir confirmación, introducir una pausa o continuar sin interrupciones modifica las condiciones en que la persona decide.

Las herramientas de bienestar digital también actúan mediante decisiones de diseño. Medir, bloquear o retrasar una apertura puede ser pertinente cuando el objetivo es reducir el acceso a una aplicación. No obstante, esas acciones se concentran en la conducta presente. Cuando existe otra intención que ha perdido presencia, impedir el acceso no garantiza que esa alternativa sea recordada ni que resulte más fácil comenzar.

## Arista evaluativa

El ocio no se valora únicamente por su duración o contenido. También intervienen las expectativas con que una persona interpreta ese tiempo. Tonietto et al. (2021) observaron que considerar el ocio como improductivo o desperdiciado disminuía su disfrute, especialmente cuando la actividad se realizaba como un fin en sí mismo. Aunque el estudio no se refiere exclusivamente al teléfono, permite comprender por qué una intervención basada en culpa o rendimiento podría empeorar la experiencia que intenta apoyar.

Dos sesiones semejantes pueden adquirir sentidos distintos. Una conversación extensa puede conservar valor afectivo; el mismo tiempo frente a una secuencia de contenidos puede sentirse incongruente con una intención previa. La diferencia no surge de una jerarquía universal entre actividades, sino de la relación que cada persona reconoce entre lo que hace y lo que quería hacer (de Segovia Vicente et al., 2024; Meier & Reinecke, 2021).

Por ello, el problema no puede resolverse imponiendo productividad. Cualquier respuesta debe respetar la posibilidad de continuar cuando esa sea todavía la elección. Recuperar una intención significa devolverla a la decisión, no transformarla en obligación.

El problema puede sintetizarse así: durante algunos episodios de ocio digital, una actividad continúa mientras otra intención valorada deja de estar presente en el momento de elegir qué hacer a continuación. El desafío de Diseño consiste en apoyar la recuperación de esa intención sin bloquear la actividad actual, decidir por la persona ni intervenir cuando el ocio digital conserva sentido.

# 4. Justificación

Abordar esta situación resulta relevante porque el teléfono participa de forma constante en la vida cotidiana y reúne actividades que no pueden evaluarse mediante una regla única. Las mediciones de tiempo ofrecen información útil, pero no explican si una sesión respondió al propósito de la persona ni si otra intención dejó de estar disponible. Una respuesta más precisa debe reconocer tanto el derecho a cambiar de actividad como el derecho a continuar con un descanso elegido.

La pregunta también tiene importancia preventiva. Cuando las únicas alternativas son bloquear, contabilizar o comparar, una herramienta de apoyo puede convertirse en una nueva fuente de presión. Fijar una intención no debería crear una deuda frente al sistema. Ignorar una señal, cambiar de idea o permanecer en la actividad digital son resultados posibles y legítimos. Este criterio permite abordar la autonomía mediante decisiones concretas y evita confundir ayuda con obediencia.

Desde el Diseño, el problema involucra variables propias de la disciplina: continuidad, cierre, momento, canal, jerarquía, legibilidad, fricción y control. La psicología aporta conceptos para comprender el recuerdo de acciones futuras y el conflicto entre metas; la ingeniería permite ejecutar condiciones y comunicaciones técnicas. El aporte del Diseño consiste en articular esos conocimientos en una experiencia clara, situada y respetuosa de quien la utiliza.

La pertinencia disciplinar también se relaciona con la posibilidad de distribuir una interacción entre componentes físicos y digitales. Un recordatorio situado en el entorno podría recuperar una intención fuera del mismo flujo que concentra la atención. Sin embargo, esa posibilidad no debe aceptarse de antemano. La presencia de un objeto solo se justifica si su ubicación y su forma de señalización aportan algo que una notificación convencional no consigue con igual claridad y menor esfuerzo.

# 5. Antecedentes y estado de la cuestión

## De la duración al sentido de la experiencia

Las herramientas nativas muestran minutos diarios, aperturas y aplicaciones consultadas (Apple, s. f.; Google, s. f.-c). Permiten reconocer patrones y establecer límites, pero no explican el propósito ni el significado de cada sesión.

Lukoff et al. (2018) estudiaron la diferencia entre usos del teléfono percibidos como significativos y carentes de sentido. La valoración dependía del propósito, la actividad y la autonomía experimentada. Usos de duración semejante podían producir experiencias distintas, lo que cuestiona que una cifra aislada represente la calidad del ocio digital.

Meier y Reinecke (2021) llegaron a una conclusión compatible al revisar investigaciones sobre comunicación mediada, redes sociales y salud mental. Los efectos no siguen una dirección única: varían según las características de la persona, la forma de uso y el contexto. Por su parte, Radtke et al. (2022) examinaron intervenciones de desconexión digital y encontraron resultados positivos, nulos y negativos. En conjunto, estos antecedentes desaconsejan tratar la reducción del uso como una solución universal.

De Segovia Vicente et al. (2024) combinaron registros de uso con evaluaciones cotidianas y relacionaron algunos periodos de desplazamiento percibido como carente de propósito con mayor conflicto y culpa. Esta asociación, sin demostrar causalidad, orienta el análisis hacia la relación entre actividad e intención.

## Pausas, límites y separación del teléfono

Las herramientas de autocontrol digital utilizan bloqueos, temporizadores, eliminación de estímulos, demoras y mensajes de reconsideración. Lyngs et al. (2019) revisaron 367 herramientas: predominaban los obstáculos a la conducta no deseada y una proporción menor apoyaba directamente la actividad alternativa.

Biedermann et al. (2021) analizaron 28 intervenciones y encontraron resultados variables, limitados por muestras pequeñas, periodos breves y métodos diferentes. Monge Roffarello y De Russis (2023) revisaron 43 estudios sobre bienestar digital; solo cinco superaban los dos meses. El efecto estimado sobre la reducción del uso no deseado fue pequeño a medio, pero no permitió identificar un mecanismo superior ni equiparar menos tiempo con mayor bienestar.

Una línea distinta introduce una pausa antes de abrir o continuar en una aplicación. Grüning et al. (2023) estudiaron one sec, que demora la apertura y pide reconsiderar la acción. Haliburton et al. (2024) examinaron fricciones similares durante un periodo prolongado. Ambos trabajos muestran que una interrupción breve puede modificar recorridos y que el efecto depende del uso sostenido y del esfuerzo requerido.

Una pausa puede abrir una decisión sin recuperar la intención alternativa. Cerrar una aplicación ante una barrera no demuestra que la persona haya recordado lo que quería hacer. La interrupción y el recuerdo deben evaluarse por separado.

La intervención también puede trasladarse al espacio: alejar el teléfono, guardarlo o condicionar su acceso a una llave física aumenta el esfuerzo de retorno. Estas estrategias apoyan una restricción elegida, pero no necesariamente recuperan una actividad alternativa.

Alejar el teléfono puede disminuir su disponibilidad, pero no indica qué actividad se quería comenzar. La distancia física es una estrategia posible, no una respuesta completa al problema.

## Recordar mediante señales y recursos externos

Las personas utilizan agendas, notas, alarmas y objetos para recordar acciones futuras. Esta práctica se conoce como **descarga cognitiva**: parte de la información que debería mantenerse o recuperarse se deposita en un recurso externo (Risko & Gilbert, 2016). Cuando aquello que se externaliza es una acción futura, también puede hablarse de descarga de intenciones (Gilbert et al., 2023).

Preparar un recordatorio exige formular la intención, elegir una señal y reconocerla después. Chiu y Gilbert (2024) observaron que el esfuerzo de configuración influye en su uso: una ayuda demasiado compleja puede abandonarse antes de cumplir su función.

Los recordatorios basados en ubicación exploran el vínculo entre intención y contexto. Place-Its permitió asociar mensajes a lugares en teléfonos móviles (Sohn et al., 2005), mientras O’Rear y Radvansky (2019) estudiaron cómo el lugar puede favorecer el recuerdo de una acción futura. Los hallazgos muestran que el contexto puede colaborar con la recuperación, aunque la proximidad no garantiza que la acción se realice.

En el campo de la **interacción tangible**, que incorpora objetos físicos a la manera de representar o manipular información, *The Tangible Reminder* vinculó objetos cotidianos con información de citas y señales ambientales (Hermann et al., 2007). El proyecto demostró que un recordatorio puede distribuirse entre información digital, presencia física y entorno. Su propósito, sin embargo, era comunicar compromisos temporales mediante un objeto con información visible. No responde directamente a sesiones de ocio digital ni a intenciones que la persona puede decidir no ejecutar.

## Alcance de los antecedentes

La literatura distingue aportes complementarios: valorar la experiencia más allá de su duración, crear ocasiones de reconsideración y apoyar el recuerdo mediante recursos externos. Cada aporte deja una pregunta abierta sobre el propósito, el contexto o la carga de la intervención.

Las métricas describen el uso; los bloqueos modifican el acceso; las pausas permiten reconsiderar; y los recordatorios apoyan el recuerdo. Ninguno garantiza por sí solo que una intención alternativa vuelva a orientar la decisión.

La cuestión pendiente es bajo qué condiciones una intención propia puede volver a estar disponible mientras la sesión continúa. La revisión no determina el soporte ni el momento más adecuado, y tampoco permite suponer que una respuesta física sea superior a una digital.

La revisión es exploratoria. Se priorizaron publicaciones desde 2019 y se mantuvieron antecedentes anteriores cuando resultaban necesarios para definir memoria prospectiva, interacción tangible o uso del espacio. No se realizó una revisión sistemática ni un estudio de patentes. Por ello, los vacíos identificados delimitan una oportunidad de investigación y no demuestran la inexistencia universal de soluciones semejantes.

# 6. Marco teórico por ámbitos

El marco teórico relaciona tres ámbitos: la experiencia subjetiva del ocio digital, las interfaces que organizan su continuidad y los recursos materiales que apoyan el recuerdo. Su intersección permite estudiar cuándo una intención deja de orientar la decisión y qué condiciones debería respetar una ayuda.

## Experiencia subjetiva del ocio digital

El ocio puede ofrecer descanso, disfrute, aprendizaje y vínculo social. Tonietto et al. (2021) mostraron que juzgarlo como improductivo reduce su disfrute, especialmente cuando se realiza por sí mismo. Esta relación cuestiona las intervenciones que convierten todo tiempo disponible en una obligación productiva.

La valoración digital depende de la relación entre propósito y experiencia. Lukoff et al. (2018) encontraron usos del teléfono percibidos como significativos y otros como carentes de sentido. Una misma aplicación puede sostener una conversación importante o una secuencia rutinaria; su categoría no determina esa diferencia.

Meier y Reinecke (2021) proponen atender a quién usa la tecnología, qué hace y en qué contexto. Este enfoque evita inferir bienestar o malestar desde una categoría general como tiempo de pantalla. Para la presente investigación, la unidad relevante es el episodio: una situación concreta con un inicio, una actividad, un propósito, otras intenciones posibles y una valoración posterior.

Una **meta** es un resultado que orienta la acción. Varias metas pueden competir por tiempo, atención o recursos. El **conflicto entre metas** aparece cuando una actividad dificulta otra también valorada; describe una tensión entre posibilidades, sin establecer cuál debería prevalecer.

De Segovia Vicente et al. (2024) relacionaron episodios de desplazamiento percibido como carente de propósito con mayor conflicto y culpa. El hallazgo vincula el malestar con la distancia respecto de otras intenciones, sin atribuirlo necesariamente a toda sesión extensa.

La culpa tampoco debe utilizarse como indicador automático. Puede aparecer por expectativas sociales que desvalorizan el descanso, incluso cuando la actividad fue elegida (Tonietto et al., 2021). Diseñar desde la culpa correría el riesgo de reforzar una norma externa. Resulta más preciso preguntar si existía otra intención y si la persona quería mantenerla disponible.

La relación entre metas cambia durante una sesión. Una elección inicial deliberada no implica que cada momento posterior responda a una nueva decisión. Las interfaces continuas hacen pertinente distinguir el inicio de las ocasiones para renovar o cerrar la actividad.

Una **decisión renovada** ocurre al volver a considerar si se desea continuar, cambiar o detenerse. Puede surgir ante el final de un contenido, una pausa o una señal del entorno. Sin cierres claros, la sesión puede prolongarse sin que las alternativas vuelvan a compararse. La decisión inicial puede seguir siendo válida aunque resulte útil reconsiderarla. Esta distinción describe la continuidad sin asumir pérdida de conciencia o de control.

## Arquitecturas de atención y bienestar digital

Una interfaz define acciones, esfuerzo y puntos de cierre. El desplazamiento infinito, la reproducción automática y las recomendaciones encadenadas ofrecen el siguiente contenido sin exigir una búsqueda o confirmación nueva (Montag et al., 2019).

Estas decisiones forman una **arquitectura de atención**: elementos que orientan lo percibido y el avance de la interacción. Las personas conservan capacidad de elección, pero continuar con un gesto mínimo exige menos preparación que levantarse, reunir materiales o cambiar de espacio. Esta asimetría permite comparar los comienzos: seguir viendo contenido y salir a caminar pueden ser actividades igualmente valoradas, aunque sus primeros pasos requieran esfuerzos distintos.

Algunas interfaces introducen **fricción**, un esfuerzo adicional como esperar, confirmar o desplazarse. Puede abrir una ocasión de reconsideración, pero, si resulta excesiva, también puede frustrar o dificultar una actividad legítima.

Lyngs et al. (2019) describen fricciones que eliminan estímulos, bloquean o introducen demoras. Grüning et al. (2023) y Haliburton et al. (2024) encontraron que pausar antes de abrir una aplicación puede modificar el recorrido. El mecanismo abre una elección, aunque se concentra en la acción digital presente.

La fricción no equivale a recuperar una intención. Dificultar la continuidad puede provocar una pausa sin recordar qué otra actividad se quería hacer. Sigue abierta la pregunta por una ayuda que devuelva esa alternativa sin restringir el acceso.

La autonomía depende de comprender la intervención y poder aceptarla, ajustarla o rechazarla. Una ayuda persistente o difícil de detener puede ejercer presión aunque no bloquee el teléfono.

El tono amable no reemplaza esa capacidad de elección. En un experimento de comunicación digital sobre alimentación, ofrecer opciones mejoró la evaluación de la intervención, mientras que modificar solo el lenguaje no produjo diferencias significativas en los resultados medidos (Smit et al., 2019). El estudio no evalúa Relevo, pero ayuda a distinguir una salida real de una frase que simplemente suena alentadora.

Una videollamada, un videojuego o una sesión de descanso elegida pueden prolongarse sin presentar el problema estudiado. Si no existe una intención alternativa, la duración o la aplicación no justifican por sí solas una interrupción. Continuar después de recordar una intención puede ser válido. El apoyo debe devolver una posibilidad a la decisión, y permanecer inactivo cuando no sea pertinente.

Un sistema puede registrar eventos como tiempo, aplicación activa, horario o conexión. Esos datos no revelan directamente aburrimiento, culpa o satisfacción. Interpretarlos como estados subjetivos podría producir intervenciones injustificadas.

Las **intenciones de implementación** relacionan una situación anticipada con una respuesta: si ocurre una condición, entonces se realiza una acción (Gollwitzer & Sheeran, 2006). El vínculo se establece de antemano; observar el evento no demuestra que el momento sea problemático.

Recordar una intención, iniciar una actividad y adquirir un hábito tampoco son el mismo resultado. La formación de hábitos supone que una conducta se vuelva más automática en un contexto recurrente; medir su frecuencia o registrar una señal no basta para demostrarlo (Gardner et al., 2012; Lally et al., 2010). Las rachas pueden favorecer la continuidad de una conducta registrada, pero también convertir su mantenimiento en una meta propia (Silverman & Barasch, 2023). Estos hallazgos justifican estudiar cómo se acompaña una decisión, no atribuirle a un aviso la creación de hábitos.

El uso continuo describe una secuencia; el acumulado reúne periodos diferentes; el horario señala una coincidencia temporal. Ninguno revela por sí solo el propósito o la valoración de la experiencia.

## Mediación material de información personal

La memoria prospectiva permite recordar una acción al llegar la ocasión adecuada (McDaniel & Einstein, 2000). Se diferencia de recuperar acontecimientos pasados: recordar al final del día que se quería leer no demuestra haberlo recordado cuando era posible comenzar.

Una intención puede recuperarse ante una hora o un evento. Las alarmas señalan un momento; las claves contextuales, como lugares u objetos, relacionan la situación con la acción. La persona debe percibir y comprender la señal antes de decidir qué hacer. Percibir una señal, identificar su origen, recordar una actividad y decidir iniciarla son resultados distintos. Esta separación permite localizar dónde falla una ayuda sin exigir que su recepción termine en acción.

Una nota, un libro dispuesto sobre la mesa o una alarma conservan información fuera de la memoria activa. Risko y Gilbert (2016) denominan esta práctica descarga cognitiva; Gilbert et al. (2023) revisan específicamente la externalización de intenciones futuras.

Externalizar reduce la necesidad de mantener una meta presente, pero exige configurar una señal y encontrarla a tiempo. Chiu y Gilbert (2024) muestran que el esfuerzo físico de preparación modifica esa decisión; cada paso adicional requiere justificación. Una señal puede funcionar sin contener toda la información si su relación con la intención se comprende. Cuando resulta ambigua, obliga a consultar otra fuente. El contenido necesario depende del contexto y requiere evaluación.

Kirsh (1995) explica que organizar el espacio reduce demandas cognitivas y hace perceptibles ciertas relaciones. Preparar ingredientes o dejar un objeto junto a la puerta permite que el entorno apoye la comprensión y el inicio de una acción.

Sohn et al. (2005) y O’Rear y Radvansky (2019) muestran que el lugar puede favorecer el recuerdo, aunque la proximidad no asegura actuar. Importan su significado personal y la posibilidad de percibir la señal entre otras actividades.

Una meta amplia también debe distinguirse de su comienzo: hacer ejercicio puede iniciar al preparar las zapatillas; dibujar, al disponer materiales. Esto permite estudiar la distancia entre recordar y reconocer una acción posible sin definir todavía la intervención.

El espacio introduce límites de percepción, privacidad y convivencia. Los objetos pueden moverse o quedar cubiertos; una señal puede molestar. Situar una interacción exige estudiar las condiciones de cada hogar y permitir cambiar la asociación.

La **interacción tangible** incorpora objetos físicos a la representación o manipulación de información. Su significado puede depender de la ubicación, la presencia, el peso y el movimiento, además del tacto.

Una experiencia **phygital** integra componentes físicos y digitales con funciones complementarias. Añadir un objeto a una aplicación no basta: la relación debe aportar a la experiencia y evaluarse como un conjunto.

*The Tangible Reminder* conectó citas digitales con objetos y señales ambientales (Hermann et al., 2007). Muestra cómo el entorno puede comunicar un compromiso, pero también las exigencias de energía, mantenimiento, costo y aprendizaje que introduce el objeto.

Waggoner et al. (2026) señalan que las experiencias phygital requieren métodos capaces de observar la relación entre canales, lugares y momentos. Evaluar solo la aplicación o solo el objeto fragmentaría el sistema. También resulta necesario comprobar si la capa física aporta valor frente a una solución exclusivamente digital.

## Conclusiones del marco teórico

Los tres ámbitos explican una misma tensión: una sesión puede conservar valor y, a la vez, coincidir con otra intención que pierde presencia. La interfaz sostiene la continuidad, la memoria prospectiva distingue recordar después de recordar a tiempo, y el espacio puede apoyar la recuperación. Esta relación deja preguntas para usuarios y referentes: cómo se recupera una intención, qué eventos pueden vincularse con ella y qué papel cumplen contexto, autonomía y esfuerzo. La teoría orienta esas preguntas sin determinar una solución. Las entrevistas permitirán reconocer episodios de conflicto, contrastarlos con usos elegidos y examinar estrategias existentes. Esa comparación evita atribuir a todos los participantes una misma necesidad.

# 7. Usuario, contexto y hallazgos de entrevistas

## Método, participantes y alcance del estudio

Se realizó un estudio cualitativo exploratorio para comprender relatos y reconocer patrones iniciales, sin buscar una representación estadística de la población. El estudio abordó experiencias de ocio digital, momentos de continuidad, intenciones alternativas, formas de cierre y estrategias utilizadas frente al teléfono. El formato semiestructurado permitió mantener una pauta común y profundizar en situaciones particulares mediante repreguntas.

Participaron ocho personas de 19 a 27 años. Las entrevistas fueron habladas y presenciales, y se realizaron en Santiago los días 11 y 12 de junio de 2026. El reclutamiento se efectuó mediante contactos proporcionados por personas cercanas al investigador. La edad fue el único criterio común confirmado. En consecuencia, el lugar y el rango etario describen el levantamiento, pero no permiten generalizar los resultados a todos los adultos jóvenes.

La pauta avanzó desde las actividades de tiempo libre hacia el relato de una sesión reciente, su propósito, continuidad, percepción temporal, valoración y cierre. Dos preguntas adicionales abordaron las estrategias para descansar o separarse del teléfono y la reacción ante una propuesta preliminar basada en una señal ambiental. Se obtuvo consentimiento informado oral para la participación y el uso académico anonimizado del material.

Las conversaciones fueron transcritas y regularizadas para facilitar su lectura. El corpus se organizó con códigos P1–P8 y Q1–Q13. La unidad principal fue el episodio: una situación relatada en relación con actividad, intención, continuidad, recuerdo, valoración o estrategia. El método Framework organizó temas y casos en una matriz común, manteniendo el vínculo con cada entrevista (Goldsmith, 2021). A partir de semejanzas y contrastes se construyeron tipos ideales revisables: modelos analíticos que reúnen rasgos recurrentes sin convertirlos en perfiles permanentes de los participantes (Stapley et al., 2022).

Las combinaciones de participante y pregunta —por ejemplo, P2, Q3–Q7— localizan las respuestas que sostienen una paráfrasis. No son citas textuales; permiten contrastar la interpretación con el corpus anonimizado.

El [índice de anexos](anexos/README.md) reúne el instrumento aplicado, el corpus anonimizado y los documentos de análisis que respaldan este capítulo. También declara los límites de conservación y uso de cada material.

La interpretación fue realizada por el investigador y no contó con un segundo codificador. La duración individual de las entrevistas no quedó registrada. Tampoco se observaron directamente las conductas ni los espacios domésticos. Los hallazgos permiten reconocer patrones y contraejemplos dentro del corpus, pero no estimar frecuencia, causalidad, eficacia o disposición de pago.

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

Una misma persona relató actividades dirigidas y otras que continuaban sin una decisión renovada. La aplicación, duración o edad no bastaron para identificar el problema: importó su relación con otra intención.

El autor informó además una encuesta a 70 participantes, cuyos materiales, procedencia, consentimiento, anonimización y análisis todavía no están documentados. Se mantiene fuera de la evidencia vigente hasta revisar esos antecedentes. La [ficha de seguimiento](../03_usuarios/encuesta-70-participantes-pendiente.md) registra su incorporación pendiente.

## Hallazgos, contrastes y estrategias cotidianas

P2 relató que abrió Instagram al acostarse para mirar memes. Reconoció el sueño y, aun así, continuó usando el teléfono. Recordaba la sesión con claridad, pero evaluó su cierre como incompleto. El episodio no indica que hubiera olvidado lo ocurrido. Muestra una tensión entre una intención alternativa —dormir— y la continuidad de la actividad (P2, Q3–Q7).

P3 describió videos humorísticos en Instagram como una forma de pasar el tiempo. Relató una pérdida de noción temporal y reconoció otras actividades que habría preferido realizar. Al mismo tiempo, consideró que la sesión había funcionado como una pausa frente a sus responsabilidades. Esta ambivalencia es importante: una actividad puede ofrecer descanso y competir con otra intención sin volverse, por ello, incorrecta (P3, Q3–Q8).

P5 mencionó entretenimiento inmediato y aburrimiento posterior. También habló de estrategias que no siempre evitaban volver al teléfono. Su relato ayuda a diferenciar una valoración negativa después de la sesión de una intención alternativa ya formulada. No toda insatisfacción posterior indica que existía una actividad concreta que pudiera recuperarse durante el episodio (P5, Q3–Q10 y Q12).

P1 y P4 mostraron variaciones semejantes. Ambos distinguieron momentos de uso dirigido de otros más rutinarios. Estos relatos impiden tratar a una persona como un usuario permanente del problema. La pertinencia cambia según la actividad y el contexto (P1, Q3–Q5, Q8 y Q12; P4, Q3–Q8 y Q12).

Los casos anteriores contrastan con experiencias que conservaron sentido durante toda la sesión. P6 relató una videollamada extensa que valoró por su contenido y por el vínculo con otra persona (P6, Q3–Q9). P7 describió un pódcast elegido mientras comía y no reconoció una obligación que exigiera corregir la experiencia (P7, Q3–Q10). P4 diferenció el sudoku focalizado de actividades digitales menos dirigidas (P4, Q3–Q8). P8 mostró que una rutina difícil de describir puede coincidir con un descanso que se considera aceptable (P8, Q3–Q10).

Estos contraejemplos cumplen una función central. Dentro del corpus muestran que ni la duración, ni la presencia del teléfono, ni una categoría de aplicación bastan por sí solas para decidir una intervención. De ellos se deriva un riesgo de diseño: una señal activada únicamente por tiempo podría interrumpir una conversación importante, una actividad concentrada o una pausa deliberada.

La ausencia de una intención alternativa también resulta significativa para la propuesta. Si la persona no ha formulado otra actividad que quiera mantener disponible, el sistema carece de contenido legítimo para recordar. Permanecer inactivo no constituye una falla, sino una forma de respetar el propósito actual.

Además de valorar las sesiones, las entrevistas indagaron cómo las personas intentaban modificarlas. Ante la pregunta por formas de descansar o separarse del teléfono, las personas mencionaron alejarlo, cargarlo en otro lugar, silenciarlo o activar modos de no molestar (P1–P5 y P7–P8, Q12). Estas estrategias fueron declaradas, pero no observadas ni comparadas. Su aporte consiste en mostrar que la distancia, el lugar y el silencio ya forman parte del repertorio cotidiano de algunos participantes.

También revelan una dificultad. Alejar el teléfono puede disminuir su disponibilidad, aunque no siempre evita el retorno ni recuerda qué actividad se quería comenzar. El espacio aparece como un recurso posible, pero su eficacia no puede darse por supuesta.

Las respuestas ante la propuesta preliminar incluyeron solicitudes de señales calmadas, discretas o visuales y el rechazo de notas o comparaciones entre días (P3–P5 y P7–P8, Q13). Como la pregunta presentó una idea y no una experiencia de uso, esas reacciones solo orientan criterios generales; no validan el producto ni permiten cerrar su forma.

## Dos situaciones de usuario

Los hallazgos permiten distinguir dos tipos situacionales. No representan identidades cerradas ni segmentos comerciales; una misma persona puede pasar de uno a otro según la actividad.

El **usuario principal** aparece cuando la sesión continúa sin una decisión renovada reconocible y otra intención propia deja de orientar el siguiente paso. P2 y P3 ilustran con mayor claridad esta situación; P5 presenta un caso menos definido.

Su necesidad no es abandonar siempre el teléfono. Necesita volver a considerar una alternativa propia en un momento oportuno. Para que esa necesidad pueda traducirse en diseño, la intención debe vincularse con un comienzo concreto: dormir puede iniciar al dejar el teléfono y preparar el espacio; caminar, al ponerse las zapatillas; leer, al abrir el libro.

Sus principales puntos de dolor son la continuidad difícil de cerrar, la pérdida de presencia de otra actividad y el retorno al teléfono después de haber intentado alejarlo. A ello se suma una tensión: recibir ayuda sin sentir que una herramienta transforma la intención en obligación.

En cambio, el **usuario límite** aparece cuando la actividad digital es elegida, significativa, relacional, concentrada o reparadora, o cuando no existe una intención alternativa que requiera apoyo. P6 y P7 ofrecen los contrastes más claros; P4 y P8 muestran que la posición puede cambiar dentro de una misma persona.

Su necesidad principal es conservar autonomía. Una intervención equivocada puede convertir una actividad legítima en un problema, exponer una intención privada o interrumpir a otras personas. Para este usuario, la posibilidad de no activar, ignorar o detener la señal tiene tanta importancia como la capacidad de recibirla.

## Recorridos, contexto y necesidades de diseño

El recorrido principal comienza con una sesión elegida o tolerada como descanso. La sucesión de contenidos sostiene la actividad mientras una intención alternativa no logra orientar el cambio. Después, la persona puede valorar el episodio con ambivalencia e intentar alejar o silenciar el teléfono.

El recorrido del usuario límite es diferente. La actividad se elige con un propósito y conserva valor durante la sesión. Puede ser extensa, pero no entra en conflicto con otra intención reconocida. El cierre ocurre sin necesidad de corrección. Cualquier ayuda debe permitir que este recorrido continúe sin interrupciones injustificadas.

Ambos recorridos exigen conservar la autoridad de la persona para interpretar el momento. Una propuesta deberá solicitar una intención explícita, permitir cambios y evitar interpretar automáticamente la continuidad como un problema.

Al relacionar estos recorridos con las estrategias declaradas, el hogar se considera un primer contexto pertinente porque varias intenciones y estrategias relatadas dependen de objetos, superficies y distancias. Leer, dibujar, cocinar, dormir o salir a caminar suelen comenzar mediante acciones materiales reconocibles. Además, cargar el teléfono en otro lugar o dejarlo lejos ya forma parte de las prácticas mencionadas.

Esta elección sigue siendo una hipótesis. Las entrevistas no incluyeron observaciones sistemáticas de viviendas, convivencia, ruido, iluminación, privacidad o movilidad de objetos. Un elemento visible puede ser desplazado; una luz puede pasar inadvertida; un sonido puede molestar o revelar información personal. Las condiciones del espacio deberán estudiarse antes de afirmar que una misma solución funciona en todos los hogares.

El usuario principal necesita mantener disponible una intención y reconocer cómo comenzar, sin que el apoyo imponga la acción. El usuario límite necesita proteger una experiencia digital que conserva sentido y decidir si una ayuda es pertinente. De ambos se desprenden requisitos comunes: configuración voluntaria, posibilidad de cambio, señal discreta, salida inmediata y ausencia de sanciones.

Las entrevistas no definen la forma final de una solución. Su aporte consiste en precisar el momento que debe abordarse y en establecer situaciones donde intervenir sería un error. Esta distinción permite avanzar sin convertir a los participantes en validadores de una propuesta que no probaron.

# 8. Estado del arte y referentes

## Método y criterios de comparación

El estado del arte compara investigaciones, servicios y productos por su mecanismo, valor, evidencia y límites frente al problema estudiado.

La búsqueda se cerró el 24 de agosto de 2026. Se consultaron artículos académicos, documentación oficial, sitios de productos y fichas técnicas. El [registro metodológico](../04_mercado_y_referentes/registro-busqueda-2026-08-24.md) conserva la pregunta, las familias de términos, los tipos de fuente, los criterios de inclusión y exclusión, nueve referentes nucleares y los límites del levantamiento. No se preservó un historial literal de consultas, buscadores ni conteos completos de resultados; por ello, permite repetir una exploración equivalente, pero no se presenta como revisión sistemática.

Las fuentes comerciales describen funciones, compatibilidad y modelo de valor; no demuestran eficacia independiente. La revisión se limita al corpus consultado y no constituye un estudio de patentes, participación de mercado o disponibilidad en Chile.

Las seis familias del capítulo agrupan mecanismos para esta comparación; no constituyen una taxonomía universal ni categorías propias de las marcas.

Para ordenar la comparación se utilizaron seis preguntas:

1. ¿Qué problema declara abordar la propuesta?
2. ¿Qué mecanismo utiliza: medición, pausa, bloqueo, distancia, recordatorio o recompensa?
3. ¿Dónde ocurre la interacción principal?
4. ¿Qué debe hacer la persona para configurarla y mantenerla?
5. ¿Cómo conserva o limita su autonomía?
6. ¿Qué evidencia existe sobre sus resultados?

Estas preguntas permiten distinguir soluciones que parecen semejantes por su apariencia, pero actúan de maneras diferentes.

## Herramientas digitales de medición y pausa

Apple Screen Time y Google Digital Wellbeing ofrecen mediciones, límites por aplicación, periodos de descanso y controles de notificaciones (Apple, s. f.; Google, s. f.-c). Su disponibilidad reduce costos y aprendizaje, y permite reconocer patrones sin adquirir otro dispositivo.

Estas herramientas registran minutos, aperturas, horarios y aplicaciones. Pueden apoyar la reducción de un uso específico, pero no distinguen si una sesión responde a conversación, descanso, información o contenido sin un propósito renovado.

Pause Point, anunciado por Google en 2026, representa una evolución hacia la reconsideración. La función permite introducir una pausa temporal en aplicaciones seleccionadas y refleja un interés por crear cierres flexibles dentro del sistema operativo (Sanders, 2026). Su disponibilidad depende de versiones y dispositivos, por lo que no constituye una capacidad universal. Dentro del corpus revisado, este caso amplía el conteo con una intervención breve y reversible.

Las herramientas nativas ofrecen una base accesible, aunque el significado permanece dentro del teléfono y suele expresarse mediante tiempo o restricciones. No resuelven la asociación de una intención con su comienzo en el entorno.

Las aplicaciones de pausa llevan esa reconsideración al momento de apertura. one sec introduce una demora antes de abrir determinadas aplicaciones y pide reconsiderar la acción (one sec, s. f.). Su mecanismo ha sido estudiado tanto en condiciones experimentales como durante periodos prolongados (Grüning et al., 2023; Haliburton et al., 2024). La evidencia sugiere que una pausa puede disminuir aperturas automáticas y cambiar parte del recorrido. No demuestra que todas las personas mantengan el uso de la herramienta ni que reducir aperturas mejore por sí solo el bienestar.

one sec interviene antes de abrir una aplicación y permite continuar tras la pausa. Su límite para esta investigación es que la decisión permanece en la pantalla: no conserva necesariamente otra actividad ni la relaciona con el lugar donde puede comenzar.

Las aplicaciones examinadas utilizan respiración, preguntas y mensajes personalizados para introducir reflexión. Sus funciones declaradas no permiten anticipar la permanencia del uso ni la posible omisión de avisos repetidos.

La proximidad entre pausa y acción explica el interés de esta familia. Quedan pendientes la duración del efecto, la transferencia hacia otra actividad y el esfuerzo de mantener la herramienta.

## Objetos que restringen o alejan el teléfono

Brick vincula una aplicación con un dispositivo físico utilizado para activar o revertir modos de bloqueo. Al momento de la consulta, la marca declaraba compatibilidad con Android 12 o posterior e iOS 17 o posterior, y mostraba un precio de USD 59 (Brick LLC, s. f.-a). Su propuesta de valor combina distancia y **precompromiso**, es decir, una decisión previa que restringe deliberadamente las opciones disponibles durante una situación: para recuperar el acceso es necesario volver al objeto.

Unpluq utiliza una etiqueta con comunicación de campo cercano —NFC, tecnología que intercambia datos a muy corta distancia— junto con horarios, barreras y estadísticas. Su modelo incluye una suscripción (Unpluq, s. f.). Screenless Breaker ofrece una llave NFC que permite reabrir aplicaciones bloqueadas (Screenless, s. f.). Su sitio entregaba información contradictoria tanto en precio como en compatibilidad: una tabla mencionaba iOS y Android, mientras la sección de preguntas frecuentes limitaba la compatibilidad actual a iOS y iPadOS y presentaba Android como una versión planificada. Brick Zone amplía la lógica hacia un espacio declarado mediante Bluetooth y mostraba un precio de USD 99 en la tienda estadounidense consultada (Brick LLC, s. f.-b).

Estos productos incorporan objetos al control del teléfono. El componente físico aumenta el esfuerzo de revertir una restricción y hace visible el compromiso, pero su oferta comercial no demuestra demanda, adopción ni disposición de pago.

Como llave de acceso, el objeto sostiene una restricción y añade costos de compra, compatibilidad y aprendizaje. Puede resultar desproporcionado ante una actividad digital legítima y no recupera por sí mismo una intención alternativa.

Una restricción semejante puede lograrse sin conexión con el sistema operativo. kSafe es un contenedor con cierre temporizado que puede utilizarse para guardar el teléfono u otros objetos (Kitchen Safe, s. f.). Se incorpora como antecedente de mecanismo; la revisión no confirmó de manera suficiente su stock ni su distribución actual en Chile. Su funcionamiento no depende del sistema operativo ni de permisos de uso. La persona establece un periodo durante el cual el contenido no estará disponible. La simplicidad técnica se acompaña de una restricción fuerte: revertir la decisión antes del tiempo fijado resulta difícil o imposible sin dañar el contenedor.

El precompromiso limita opciones futuras mediante una decisión previa. Una llamada importante o un uso legítimo posterior quedan sometidos a la misma barrera, lo que dificulta responder a cambios de contexto.

Alejar o silenciar el teléfono, estrategias mencionadas en las entrevistas, introduce una restricción más reversible y sin compra adicional. Sin embargo, tampoco conserva información sobre la actividad alternativa.

## Objetos de foco y recordatorios situados

Focusaur declara un dispositivo físico acompañado de una aplicación, etiquetas NFC, sonidos y funciones de hábito. Su comunicación comercial combina foco, constancia y recompensa, y mostraba en la tienda estadounidense un precio promocional de USD 129 frente a un valor de referencia de USD 169 en la fecha de consulta (Focusaur, s. f.). La oferta permite observar una variante en que el objeto deja de ser una simple llave y participa de un ritual de inicio.

La política de despacho consultada limita la tienda principal a Estados Unidos y remite a una tienda separada para Europa. No se comprobó disponibilidad en Chile. Esta condición importa porque una oferta visible en línea no equivale a acceso local ni permite comparar su costo final con el de una propuesta desarrollada en el país.

Los objetos de foco vinculan espacio y conducta mediante un compromiso visible. Las estadísticas, recompensas o mecanismos de juego pueden desplazar el propósito personal hacia el cumplimiento frente al sistema.

Esta familia muestra el valor del ritual y del lugar, aunque su orientación a productividad o disciplina limita su adecuación al ocio y a intenciones que pueden cambiar.

Otro uso del objeto consiste en recordar una acción, sin administrar el acceso al teléfono. *The Tangible Reminder* conectó objetos cotidianos con citas digitales y utilizó señales ambientales para comunicar cercanía temporal (Hermann et al., 2007). Aunque es anterior al periodo priorizado, sigue siendo pertinente porque muestra una integración clara entre información digital, objeto y entorno.

El recordatorio tangible vuelve perceptible un compromiso mediante una asociación configurada. Las citas, sin embargo, tienen horarios y contenidos relativamente estables; una intención durante el ocio puede cambiar de prioridad sin que ello implique incumplimiento.

Los recordatorios basados en lugar, como Place-Its, amplían la relación entre contexto y acción (Sohn et al., 2005). Su principal aporte es presentar la señal donde puede resultar significativa. Su límite es que una ubicación detectada técnicamente no equivale a una relación personal con el espacio. Estar cerca de un lugar no garantiza comprender ni ejecutar una intención.

## Comparación de aportes y límites

Cada mecanismo responde a un propósito: observar patrones, abrir una pausa, sostener una restricción, dificultar el retorno o recordar mediante el entorno. Su utilidad depende de la necesidad y del contexto.

Los límites aparecen al confundir esos propósitos. Medir no explica el significado, bloquear no recupera una alternativa y recordar no garantiza actuar. La incorporación de un objeto también debe justificar sus costos y mantenimiento.

La evidencia académica sobre autocontrol digital continúa siendo heterogénea. Los periodos de estudio suelen ser breves y las métricas más frecuentes son tiempo, aperturas o permanencia (Biedermann et al., 2021; Monge Roffarello & De Russis, 2023). Falta conocer mejor la autonomía, la comprensión del mecanismo y el abandono a largo plazo.

Una tendencia reciente consiste en permitir que las reglas se revisen. Kidel Peña-Albert et al. (2026) estudiaron una invitación a reconfigurar una herramienta de autocontrol digital. De 138 personas del grupo experimental, 63 aceptaron la propuesta. El resultado no demuestra eficacia general, pero indica que una regla puede perder pertinencia y que su ajuste forma parte de la experiencia.

El corpus muestra dos direcciones: simplificar el apoyo dentro del sistema operativo o añadir presencia física para reforzar un compromiso o una relación con el lugar. Esta diferencia requiere comparar directamente las alternativas.

La tabla reúne los mecanismos anteriores y sus límites frente al problema estudiado.

| Familia | Mecanismo principal | Referentes | Fortaleza | Límite frente al problema estudiado |
| --- | --- | --- | --- | --- |
| Medición | Mostrar tiempo, aperturas o categorías. | Screen Time, Digital Wellbeing. | Hace visible el patrón general. | No distingue el sentido de la sesión ni recupera una intención. |
| Pausa | Introducir una demora antes de continuar. | one sec, Pause Point. | Crea una ocasión de reconsideración. | Mantiene la señal y el significado dentro del teléfono. |
| Bloqueo | Restringir el acceso mediante una regla. | Brick, Unpluq, Screenless Breaker. | Sostiene un precompromiso difícil de eludir. | Se concentra en impedir la actividad presente. |
| Separación | Alejar o encerrar el dispositivo. | kSafe, estrategias cotidianas. | Reduce la disponibilidad física del teléfono. | No conserva qué otra actividad se quería comenzar. |
| Objeto de foco | Vincular lugar, hábito y compromiso. | Focusaur, Brick Zone. | Hace visible un estado y puede formar un ritual. | Tiende hacia productividad, control o recompensa. |
| Recordatorio tangible | Asociar información con objetos o lugares. | *The Tangible Reminder*, Place-Its. | Lleva una clave al contexto de la acción. | No aborda directamente el ocio digital ni la decisión de continuar. |

## Oportunidad y exigencia de comparación

El corpus revisado no mostró una evaluación independiente que reúna seis elementos: una intención formulada por la persona, un primer paso concreto, una condición digital comprensible, una señal física situada, la posibilidad legítima de continuar y una comparación con una notificación equivalente. Esta ausencia se limita a las fuentes consultadas y no constituye una afirmación de novedad universal.

La oportunidad es apoyar el paso entre recordar una intención y reconocer dónde comenzar. Su valor dependería de relacionar intención, señal y lugar fuera del teléfono, sin aumentar la dificultad de acceso.

Esta dirección también contiene su principal exigencia crítica. Si una notificación digital ofrece el mismo apoyo con menor carga, el componente físico no se justifica. El aporte debe comprobarse mediante una comparación y no mediante la novedad aparente del objeto.

# 9. Criterios de diseño

Los criterios traducen la investigación en condiciones para formular y evaluar la propuesta. Se agrupan según tres responsabilidades: conservar una intención comprensible, respetar la decisión de la persona y justificar el esfuerzo que introduce el sistema.

## Intención propia y comienzo concreto

La intervención debe conservar una actividad elegida por la persona. No puede deducirla desde el tiempo de uso, la aplicación abierta o una categoría de productividad, porque experiencias de duración semejante pueden adquirir sentidos distintos según el propósito y el contexto (Lukoff et al., 2018; Meier & Reinecke, 2021). Los contrastes entre P2–P3 y P6–P8 refuerzan esta diferencia dentro de las entrevistas. Sin una intención formulada, no existe contenido legítimo que recuperar.

Conservar la intención también exige aclarar cómo podría comenzar, porque una meta amplia puede dejar ese paso sin definir. Las intenciones de implementación muestran que vincular una situación con una respuesta prevista puede favorecer el paso desde una meta hacia la acción (Gollwitzer & Sheeran, 2006). Por ello, cada intención debe expresarse mediante una acción concreta y próxima. El primer paso no obliga a completar la actividad; solo reduce la distancia entre recordarla e iniciarla.

## Activación comprensible y decisión autónoma

La activación debe depender de un evento que la persona pueda entender y modificar. Android puede registrar tiempo, horario o continuidad de uso con autorización, pero esos datos no revelan por sí solos aburrimiento, culpa o satisfacción (Google, s. f.-d). La diferencia entre episodios relatados por una misma persona confirma que una condición técnica no equivale al sentido de la experiencia. Tiempo, continuidad de uso u horario son condiciones posibles, pero su significado debe explicarse y probarse.

Una vez activada, la señal debe devolver la intención al presente sin bloquear el teléfono. Las intervenciones restrictivas pueden sostener un compromiso, pero también interferir con usos legítimos, mientras una pausa breve conserva la posibilidad de continuar (Grüning et al., 2023; Radtke et al., 2022). Ignorar la señal, detenerla, cambiar la intención o permanecer en la actividad digital son respuestas válidas. El sistema puede reconocer una elección que conoce, como haber preparado una actividad, pero no felicitar por una acción que no observó ni convertir la respuesta posterior en una nota de cumplimiento. Se comparará si un mensaje de reconocimiento ayuda o resulta presionante; puntajes, rachas y premios quedan fuera del prototipo inicial.

La misma autonomía exige reconocer cuándo la ayuda no es pertinente. Una actividad digital elegida, relacional, concentrada o reparadora no requiere corrección. P6 y P7 relataron experiencias extensas o focalizadas que conservaron sentido, mientras P4 y P8 mostraron que la pertinencia puede cambiar dentro de una misma persona. La propuesta debe permanecer inactiva cuando no exista una intención alternativa y permitir que una regla pierda vigencia sin convertirlo en un error.

## Carga de uso, convivencia y aporte físico

Configurar el ciclo, vincular y cargar el objeto, situarlo y prepararlo para otro uso agregan esfuerzo. Chiu y Gilbert (2024) observaron que aumentar el esfuerzo físico necesario para preparar un recordatorio reduce su uso. Los objetos revisados también incorporan costos de compatibilidad, mantenimiento y aprendizaje. Cada paso debe aportar a la comprensión o al funcionamiento; si la carga supera el beneficio, la propuesta deberá simplificarse.

Además de limitar el esfuerzo de uso, el sistema debe proteger la información personal y cuidar sus efectos en el espacio compartido. Las preferencias por señales discretas y el rechazo a comparaciones entre días aparecieron en P3–P5 y P7–P8, aunque fueron respuestas ante un concepto anterior y no una validación formal. Una señal situada no debe exponer su contenido ni molestar a quienes comparten el espacio. La intensidad, el canal, la duración y la ubicación deberán ajustarse al contexto mediante pruebas.

Estas exigencias hacen necesario justificar el objeto por la ayuda que ofrece. Los recordatorios tangibles y basados en ubicación muestran que el entorno puede participar en la recuperación de una acción futura, pero no garantizan que la persona comprenda la señal ni que actúe (Hermann et al., 2007; O’Rear & Radvansky, 2019). Debe aportar una asociación con el lugar o una forma de recuperación que una notificación no produzca de igual manera. La comparación entre ambas alternativas será una condición central de evaluación.

# 10. Formulación

## Problema de diseño y pregunta de investigación

Las herramientas de bienestar digital se concentran, principalmente, en medir, pausar o restringir la actividad presente. Estos mecanismos pueden ayudar a reducir un uso, pero no necesariamente devuelven una intención alternativa ni indican dónde puede comenzar. El problema de diseño consiste en hacer nuevamente perceptible una intención formulada por la persona, sin bloquear el teléfono, evaluar su conducta o intervenir cuando la actividad digital conserva sentido.

La propuesta se dirige a quien ya eligió una actividad y sabe cómo comenzarla, pero necesita mantenerla disponible durante ciertos episodios de ocio digital. Es una necesidad situacional, no una característica permanente ni una consecuencia de la edad.

> ¿Qué condiciones pueden ayudar a que una persona vuelva a considerar una actividad elegida cuando, durante una sesión de ocio digital, esa intención deja de orientar su decisión inmediata?

Volver a considerar una actividad significa reconocer la intención y recordar cómo comenzarla. La investigación debe distinguir ese resultado de abandonar el teléfono, completar la actividad o reducir el tiempo de uso. Esta distinción permite evaluar una ayuda sin exigir que la persona siga su señal.

## Definición y alcance de Relevo

Relevo es un sistema phygital compuesto por una aplicación Android y un objeto de señal situado junto al primer paso de una actividad elegida. La aplicación permite registrar la intención, definir cómo comienza y configurar una condición de activación. Cuando esa condición se cumple, el objeto emite un pulso ambiental breve. La persona puede considerar la intención, continuar con la actividad digital o detener la señal.

El **pulso ambiental** es una señal física de corta duración que busca llamar la atención sin entregar una instrucción. Su significado proviene de la asociación creada previamente entre intención, objeto y lugar. La señal no informa que la persona ha fallado ni indica qué debe hacer; solo vuelve perceptible la actividad que decidió mantener disponible.

Situar la señal cerca del comienzo busca que la persona reconozca, en el mismo lugar, tanto la actividad que quería hacer como la posibilidad de iniciarla. Esta relación con el entorno constituye el aporte que deberá demostrar el objeto.

El alcance inicial considera una persona, una intención activa, un primer paso, una aplicación seleccionada, una condición observable, un objeto y un lugar doméstico elegido manualmente. El sistema no infiere estados emocionales, no determina si una sesión es adecuada y no observa si la persona cumple la actividad. El prototipo no incorpora puntajes, rachas ni premios. Estas opciones podrían estudiarse en otra etapa, pero no se justificarían por sí solas como formación de hábitos ni permitirían calificar la decisión de la persona.

Android será la plataforma del primer prototipo integrado. El objeto emitirá luz y sonido; su forma definitiva, intensidad, duración, autonomía energética, materiales, precio y adopción sostenida deberán definirse mediante desarrollo y pruebas. La propuesta mantiene su carácter phygital, pero la configuración del componente físico puede cambiar si la evidencia muestra que otra relación objetual responde mejor al problema.

## Hipótesis y objetivos

> Si una persona registra una intención y su primer paso, sitúa una señal física junto a ese comienzo y la recibe cuando se cumple una condición configurada, entonces la intención podría volver a estar disponible para decidir, sin bloquear la actividad digital ni imponer su ejecución.

La hipótesis exige evaluar asociación, aporte del lugar, autonomía y funcionamiento. Se debilita si la persona necesita consultar el teléfono para comprender la señal, si el soporte o la ubicación no aportan una diferencia, o si su carga supera el beneficio.

El **objetivo general** es diseñar y evaluar formativamente un sistema phygital que apoye la recuperación situada de una intención personal durante episodios de ocio digital, mediante una señal asociada al primer paso de la actividad, sin bloquear ni calificar la decisión posterior. La evaluación formativa utiliza pruebas sucesivas para identificar dificultades y orientar mejoras del diseño.

Este objetivo se desarrolla mediante cuatro **objetivos específicos**:

1. Caracterizar la relación entre ocio digital, continuidad, intención alternativa y contexto mediante revisión bibliográfica, entrevistas y análisis de referentes.
2. Traducir los hallazgos en una experiencia phygital que articule configuración digital, señal física, lugar y control de la persona.
3. Comparar la señal situada con una notificación digital para establecer si la capa física aporta una diferencia reconocible.
4. Evaluar comprensión, percepción, autonomía, funcionamiento técnico, convivencia y carga de uso mediante prototipos progresivos.

## Actores y responsabilidades

La experiencia depende de quien configura el ciclo y también de las personas que comparten el espacio o participan en el desarrollo. La tabla identifica funciones necesarias; no representa un equipo contratado ni acuerdos de fabricación ya establecidos.

| Actor | Relación con Relevo | Necesidad o responsabilidad principal |
| --- | --- | --- |
| Usuario principal | Formula la intención, sitúa el objeto e interpreta la señal. | Comprensión, control, privacidad y carga razonable. |
| Usuario límite | Utiliza el teléfono en una actividad que conserva sentido. | No recibir una intervención injustificada. |
| Convivientes | Comparten el espacio donde puede aparecer la señal. | Discreción y ausencia de molestias. |
| Diseñador | Articula investigación, experiencia, forma y evaluación. | Mantener coherencia entre problema y decisiones. |
| Desarrollo Android | Implementa permisos, condición, estados y comunicación. | Funcionamiento comprensible y recuperación de fallos. |
| Desarrollo electrónico | Resuelve energía, enlace y componentes que producen luz y sonido. | Fiabilidad, seguridad y mantenimiento. |
| Fabricación y proveedores | Producen carcasa, circuito y ensamblaje. | Costos, trazabilidad y reparación. |
| Especialistas en accesibilidad | Revisan canales, controles y barreras de uso. | Evitar exclusiones y promesas no comprobadas. |

# 11. Bajada proyectual

## Aplicación, testigo y relación con el lugar

Relevo distribuye funciones entre tres elementos: una aplicación, un objeto y el entorno. La aplicación conserva la información y configura la condición. El objeto hace visible que existe una intención activa y emite la señal. El lugar relaciona esa señal con una acción posible. La persona reúne esas partes mediante una asociación que ella misma decide.

La relación puede representarse de la siguiente manera:

> intención personal → primer paso → lugar elegido → condición configurada → pulso ambiental → decisión de la persona

La aplicación permite nombrar una actividad en lenguaje cotidiano y convertirla en un primer paso concreto. También configura y explica la condición de activación, vincula el objeto y muestra los estados técnicos necesarios para modificar o detener el ciclo.

La preparación debe ser breve. Para una intención amplia como hacer ejercicio, la aplicación solicita un comienzo concreto —ponerse las zapatillas— y un lugar elegido manualmente, sin intentar detectarlo.

La condición de activación permanece abierta a comparación. Puede basarse en continuidad de uso, tiempo acumulado dentro de una ventana o una franja horaria. Cada alternativa debe explicarse con ejemplos. El sistema no utiliza expresiones como detectar distracción o reconocer pérdida de control, porque esos estados no pueden deducirse desde un registro técnico.

La interfaz distingue intención y primer paso de estados técnicos como permiso revocado, desconexión o batería baja. Así evita presentar un fallo de comunicación como una decisión de la persona.

El componente físico, denominado **testigo**, representa la intención que la persona decidió mantener disponible. Se concibe como un cuerpo compacto y transportable que puede ubicarse sobre distintas superficies del hogar. Su presencia indica que existe una intención activa vinculada a ese lugar. Se propone una superficie que distribuya la luz para que el pulso pueda verse desde diferentes ángulos, un sonido breve que complemente su percepción y un control físico accesible para silenciarlo o probarlo.

La forma circular podría reducir la dependencia de una orientación frontal. Se comparará con un rectángulo redondeado de volumen interno equivalente mediante estabilidad, manipulación, percepción y acceso al control. La envolvente objetivo es de 42–48 mm de diámetro y 12–16 mm de grosor, con espacio para montaje y reparación. Dimensiones, peso, color y material se ajustarán tras comprobar señal, autonomía y distribución interior.

El sistema debe distinguir reposo, señal y atención técnica. Durante la prueba se ocultan los indicadores ajenos al pulso. En la integración, la aplicación informa el estado disponible. Un eventual aviso físico de batería o conexión necesitará un patrón distinto, comprobado frente al riesgo de confusión; aún no es obligatorio.

El objeto puede relacionarse con actividades diferentes entre ciclos, manteniendo una sola intención activa. Esta adaptabilidad no implica universalidad. Cada reubicación requiere probar la señal, porque puede quedar cubierta, perderse o conservar una asociación anterior.

El lugar es una relación elegida, no una coordenada detectada: junto al libro para leer o a los materiales para dibujar. La proximidad busca conectar el recuerdo con una acción disponible.

Como las superficies, los objetos y la convivencia cambian, el sistema debe permitir reubicar, probar y armar nuevamente. La señal debe conservar discreción sin exponer el contenido de la intención.

## Preparación, señal y cierre del ciclo

Un **ciclo** es el periodo durante el cual una intención y su regla de activación permanecen vigentes. **Armar** el ciclo significa confirmar que el sistema está preparado para emitir la señal; desarmarlo significa retirar esa autorización. El recorrido previsto comprende nueve momentos y todavía no está implementado por completo.

1. **Formular.** La persona registra una intención y un primer paso concreto.
2. **Configurar.** Selecciona la aplicación, una condición observable provisional y la vigencia del ciclo.
3. **Revisar.** Comprueba y puede corregir lo preparado antes de continuar.
4. **Situar.** Confirma la vinculación y disponibilidad del objeto, y lo coloca cerca del primer paso.
5. **Probar.** Emite un pulso de prueba y comprueba percepción y silencio local.
6. **Armar.** Confirma explícitamente el ciclo mediante el control físico previsto; una confirmación ambigua permite repetir o salir.
7. **Esperar.** Utiliza el teléfono mientras la condición permanece vigente y puede desarmar.
8. **Recibir y decidir.** Percibe la señal y puede reconsiderar la intención, continuar, ignorar o silenciar.
9. **Cerrar.** El ciclo termina sin evaluar cumplimiento; otro ciclo requiere preparación y rearme voluntarios.

Comprender la señal no debería exigir consultar de nuevo la aplicación. El teléfono interviene para configurar, modificar o resolver un estado técnico. En la comprobación con la placa programable micro:bit, una herramienta de Android permite enviar la orden manualmente y comprobar su llegada y el patrón emitido: no verifican el armado físico ni la condición automática de este recorrido.

## Funcionamiento y recuperación de fallos

La arquitectura prevista aún no está implementada ni validada. Android comprobaría localmente la condición autorizada y enviaría un comando durante su vigencia. Bluetooth de baja energía, una comunicación inalámbrica de corto alcance, conectaría aplicación y objeto. Este verificaría el ciclo, emitiría el patrón y volvería a reposo tras su término o silencio.

La integración deberá resolver identificación del ciclo, órdenes duplicadas y vencimiento; el formato de mensajes sigue abierto. El banco solo comprueba llegada de la orden, patrón y silencio local. No demuestra control de mensajes tardíos. El objeto no necesita conservar el texto de la intención.

Si se revoca un permiso, se pierde conexión o falta batería, la aplicación debe informar y permitir desarmar. Lo mismo ocurre si se limita la ejecución en segundo plano, es decir, mientras la aplicación no está visible. No debe aparentar que evaluó una condición cuando no pudo hacerlo.

Los estados siguientes permiten identificar qué puede ocurrir durante el recorrido y cómo salir de cada situación.

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

La cobertura completa del recorrido y sus estados alternativos se conserva en el [índice de anexos](anexos/README.md). Estos documentos permiten revisar la estructura, pero no constituyen resultados de uso.

## Autonomía, privacidad y accesibilidad

La aplicación de investigación conserva en el teléfono la intención, el comienzo, el lugar declarado, la aplicación elegida, el tiempo acumulado y los eventos del ciclo. La versión preparada para evaluación también sincroniza estos registros con Supabase, un servicio remoto de almacenamiento, mediante un código aleatorio. Ese código separa el registro del nombre, pero no vuelve anónimos los horarios y las actividades. La eliminación completa, tanto local como remota, todavía debe comprobarse antes de trabajar con participantes. El objeto solo necesitaría recibir una orden para emitir la señal, no el texto de la intención.

El control debe estar disponible en ambos componentes. Desde la aplicación se puede pausar, editar o desarmar. Desde el objeto se puede silenciar el pulso. La ausencia de respuesta no debe generar recordatorios repetidos, mensajes de reproche ni pérdida de funciones.

La accesibilidad amplía esta revisión hacia las capacidades visuales, auditivas, táctiles, cognitivas y motoras de quienes utilicen el sistema. Ningún canal aislado puede declararse universal. Una luz puede pasar inadvertida y un sonido puede molestar o no percibirse. El prototipo deberá comprobar si ambos canales se complementan, permitir regularlos y facilitar el control físico sin movimientos precisos. Una alternativa táctil se estudiará como adaptación si las pruebas muestran que la combinación excluye a una persona, no como función añadida de antemano.

Las Pautas de Accesibilidad para el Contenido Web ofrecen un criterio preventivo frente a destellos, aunque cumplirlo no demuestra que una señal sea perceptible o adecuada (World Wide Web Consortium, s. f.). En la aplicación, los estados deben explicarse con lenguaje claro y no depender solo del color.

## Continuidad de la experiencia y soporte

Un mapa de servicio, o *service blueprint*, relaciona acciones de la persona, puntos de contacto y procesos internos (Gibbons, 2017). Permite revisar qué soporte exige cada momento de Relevo, desde la preparación hasta su retiro.

| Momento previsto | Qué necesita la persona | Soporte que debe estar resuelto | Estado |
| --- | --- | --- | --- |
| Conocer y aceptar | Entender propósito, límites y condiciones de participación. | Explicación consistente y, en la investigación, consentimiento revisado. | Comunicación documentada; revisión y contacto del responsable pendientes. |
| Preparar | Registrar intención, configurar y verificar objeto y lugar. | Material comprobado, enlace disponible y explicación de permisos. | Recorrido diseñado; ejecución sin demostrar. |
| Recibir y cerrar | Percibir la señal y conservar una salida local. | Patrón reproducible y término sin insistencia. | Programa compilado; medición pendiente. |
| Recuperar un fallo | Saber si el ciclo sigue activo y poder detenerlo. | Separación entre incidente técnico y respuesta de usuario; procedimiento para restablecer el sistema. | Casos identificados; recuperación integrada pendiente. |
| Mantener o retirar | Cargar, reubicar, reparar o dejar de usar el sistema. | Componentes accesibles y procedimientos para desvincular y eliminar datos; retorno del material si fue prestado. | Criterios definidos; procedimiento operativo y responsables por confirmar. |

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

iPhone ofrece marcos de desarrollo como Device Activity y Family Controls, destinados a observar actividad autorizada y aplicar controles definidos por la persona. Su implementación depende de permisos, capacidades y procesos de distribución específicos de Apple (Apple Developer, s. f.-a, s. f.-b, s. f.-c). Incorporar ambos sistemas durante la primera etapa duplicaría desarrollo y pruebas antes de comprobar la hipótesis central. La elección de Android concentra recursos; no impide estudiar otras plataformas si el mecanismo demuestra valor.

Las capacidades de Android también tienen límites. UsageStatsManager requiere que la persona conceda desde los ajustes un permiso especial para consultar estadísticas de uso y no detecta estados subjetivos. La ejecución en segundo plano y la comunicación Bluetooth varían según versión, fabricante y políticas de energía. El prototipo deberá probar pantalla bloqueada, cambio de aplicación, reinicio, pérdida de permiso y reconexión. No se afirma compatibilidad universal.

La arquitectura prevista para el testigo evalúa localmente la condición y le envía una orden por Bluetooth de baja energía, sin trasladar el audio de otras aplicaciones. El prototipo Android disponible utiliza en cambio un parlante Bluetooth multimedia: puede solicitar que su propio tono se dirija a él, pero Android no garantiza esa ruta ni que el resto del sonido del teléfono permanezca en el teléfono (Android Developers, s. f.). Esta diferencia exige una prueba física y mantiene abierta la elección técnica del objeto. La sincronización remota de registros es un flujo aparte de la señal y requiere consentimiento y control de acceso.

El primer nivel técnico utiliza una micro:bit V2 para comprobar conexión Android, sonido y silencio local. Su matriz roja sirve solo para ensayos sin participantes. La prueba de comprensión requiere una luz blanca cálida externa y difundida (Micro:bit Educational Foundation, s. f.-a, s. f.-b).

El segundo nivel integra el testigo portátil mediante una placa XIAO nRF52840, batería recargable protegida, una luz, un transductor sonoro pequeño —componente que convierte una señal eléctrica en sonido— y un control local. La placa reúne Bluetooth de baja energía y gestión de carga en 21 × 17,8 mm, por lo que reduce el tamaño y el número de conexiones frente a los montajes de mesa anteriores (Seeed Studio, 2026). BleenyButton demuestra una disposición abierta de la misma placa con batería, botón y carcasa atornillada; se estudia como antecedente constructivo, no como solución de uso. Cualquier reutilización de sus archivos o código exige revisar su licencia GPL-3.0 (Asterics Foundation, s. f.).

La batería se seleccionará midiendo reposo, conexión, señal y recuperación, junto con temperatura, protección, reemplazo y fin de vida. Un consumo aislado no permite prometer autonomía.

## Fabricación, mantenimiento y costos

Una carcasa impresa y componentes de desarrollo permiten modificar dimensiones, apertura y señal durante la etapa académica. Este método no representa fabricación industrial ni determina el costo en serie.

Una versión posterior podría usar un circuito propio y una carcasa resistente que permita reemplazar batería, placa y señal. Sellar el conjunto requeriría justificar que la protección necesaria compensa la pérdida de reparabilidad.

Batería, placa y carcasa deberían separarse al final de su vida útil. La sostenibilidad depende también de uniones y reparación, además de la elección de materiales.

La estimación se encuentra en una etapa de prototipo técnico abierto. Al 7 de septiembre de 2026, una micro:bit V2 se ofrecía localmente por CLP 24.990 y una XIAO nRF52840 por CLP 16.590 (MCI Electronics, s. f.; MechatronicStore, s. f.). El primer valor corresponde a una plataforma completa de ensayo que se buscará conseguir prestada o disponible; el segundo incluye solo la placa de la integración portátil. Aún faltan batería, luz, transductor, control, conexiones, carcasa, difusor, envío y revisión especializada. Por tanto, ninguno representa el costo del prototipo.

Para evitar confusiones se separan cuatro magnitudes:

1. costo del prototipo académico;
2. trabajo profesional de investigación, diseño, programación y electrónica;
3. costo de producción, logística y soporte;
4. precio eventual y disposición de pago.

Producir en cantidad exigirá cotizar circuito, carcasa, batería, ensamblaje, pruebas, embalaje, distribución y merma —material o unidades perdidas durante la fabricación—. Ese cálculo debe seguir a la comprobación del aporte físico.

## Seguridad y condiciones de distribución

Un objeto con comunicación por radio deberá revisar la normativa chilena aplicable a equipos de alcance reducido, junto con ensayos, documentación y etiquetado (Subsecretaría de Telecomunicaciones, 2026a). El uso de batería incorpora exigencias adicionales de transporte, carga y protección. El prototipo académico no equivale a certificación de producto.

La distribución de la aplicación también depende de los requisitos de Android y Google Play, especialmente cuando se emplean servicios en primer plano, tareas persistentes que deben informar su actividad mediante una notificación visible, o permisos sensibles (Google Play, s. f.). Estas condiciones pueden cambiar y deberán verificarse antes de publicar.

## Gestión y límites de factibilidad

El proyecto requiere diseño de interacción e industrial, desarrollo Android, electrónica y revisión de accesibilidad. El diseñador coordina decisiones; las áreas técnicas verifican permisos, energía, enlace y reparación.

Un posible modelo inicial corresponde a producción acotada con aplicación complementaria y soporte directo. Todavía no es posible elegir entre venta única, suscripción o distribución institucional. Ninguna entrevista estudió disposición de pago y los precios de referentes no representan automáticamente el valor de Relevo.

La condición de activación, los parámetros de luz y sonido, la forma, la autonomía, los materiales y los costos reales continúan abiertos. Tampoco se ha demostrado que el objeto ayude a recuperar intenciones, que el lugar produzca una diferencia o que la experiencia sea preferible a una notificación.

El alcance no incluye adicción, tratamiento clínico, control parental, vigilancia, productividad general ni reducción universal del tiempo de pantalla. El sistema tampoco busca detectar emociones o interpretar la calidad del ocio. Estas exclusiones mantienen el problema dentro de una escala abordable desde Diseño.

# 13. Plan de desarrollo y validación

Antes de trabajar con participantes se comprobarán enlace, patrón, control local y materiales. Esto permite distinguir un fallo técnico de una dificultad de comprensión. El desarrollo avanzará desde la asociación básica hacia un prototipo integrado y su uso cotidiano.

Las pruebas aumentarán la fidelidad del prototipo, su semejanza con el uso previsto. Cada especificación seguirá siendo candidata hasta contrastarla. Privacidad, accesibilidad y seguridad se revisarán durante todas las etapas.

## Asociación y comparación con alternativas

La primera prueba utilizará una señal física real, activada manualmente desde Android, con luz blanca cálida externa revisada. La persona formulará intención y primer paso, elegirá el lugar y recibirá el pulso durante otra actividad. Se observará si recupera la intención sin consultar el teléfono.

Los ocho minutos desde la configuración y los tres segundos del patrón son parámetros del ensayo. No definen el momento ideal de intervención ni demuestran detección de una intención ausente. La condición de activación sigue pendiente.

El registro distinguirá cuatro momentos: percepción de la señal, atribución al sistema, recuperación de la intención e identificación del primer paso. Por separado, se comprobará si la persona entiende que puede ignorar, silenciar o seguir la señal. Iniciar la actividad no será requisito. Si el significado no puede reconstruirse o las salidas no se comprenden, la configuración deberá reformularse antes de avanzar.

Si la asociación se sostiene, la segunda etapa comparará tres condiciones: objeto junto al primer paso, el mismo objeto en un lugar neutro y una notificación local Android. Cada persona prepara una intención distinta en cada condición, con relevancia y claridad semejantes según su valoración. Los órdenes se distribuyen entre las seis secuencias posibles para reducir el efecto de practicar antes con una alternativa. El intervalo se mantiene equivalente; la diferencia entre intenciones se conserva como límite.

El control digital dice «Relevo · Tu intención está disponible», sin mostrar intención ni primer paso. La comparación se limita a ese aviso genérico: no permite afirmar superioridad frente a recordatorios que expliciten el contenido. Sostener esa afirmación exigiría otra prueba previamente definida.

Se compararán comprensión, consulta del teléfono, carga, intrusión y control. Si el aviso ofrece el mismo apoyo con menor esfuerzo, se reconsiderará la configuración física.

## Forma, integración y piloto doméstico

Una vez sostenida la asociación, se compararán formas y comportamientos para la luz y el sonido. Intensidad, duración, ritmo y separación entre ambos se probarán sobre superficies y distancias reales. También se evaluará el control para silenciar, la estabilidad del objeto y su lectura como parte del entorno.

La selección considerará percepción, privacidad, convivencia, accesibilidad y consumo mediante pruebas situadas.

Con esos parámetros, la etapa de integración incorpora aplicación Android, condición observable, comunicación Bluetooth, vencimiento y estados de error. Se probarán permisos, pantalla bloqueada, cambio de aplicación, pérdida de conexión, batería baja, reinicio y comandos tardíos.

Solo después de resolver las etapas anteriores se realizará un piloto doméstico de duración acotada. El protocolo definirá número de participantes, días de uso, criterios de inclusión, consentimiento, registros y forma de retiro. Se observarán armado, reubicación, pérdida, carga, convivencia, abandono y posible pérdida de atención a la señal con la repetición. Un ensayo de dos días puede mostrar dificultades de uso; no demuestra formación de hábitos. Un seguimiento más largo necesitaría otro protocolo y una medida de automaticidad adecuada a la actividad estudiada (Gardner et al., 2012).

## Registro de evidencia y criterios de decisión

Cada ficha registrará fecha, versión, pregunta, participantes codificados, contexto, materiales, procedimiento, evidencia, interpretación, límites y decisión. Se distinguirá lo observado de lo inferido: mirar el objeto no demuestra comprenderlo y conectarlo no prueba su utilidad.

Se combinarán observación, preguntas abiertas, reconstrucción del significado y registro de errores. Cuestionarios breves podrán apoyar la evaluación de carga o intrusión, sin sustituir el relato. Se conservarán contraejemplos y razones de abandono.

Los registros de investigación requieren consentimiento y se conservarán bajo códigos seudónimos según cada protocolo. El historial visible en la aplicación y los datos usados para evaluar el prototipo deben explicarse por separado: ninguno prueba que la actividad elegida ocurrió. Antes de iniciar un estudio debe poder localizarse y eliminarse lo registrado en el teléfono y en la base remota, si se utiliza.

La propuesta se mantiene cuando la señal puede relacionarse con la intención, el lugar aporta una diferencia, la salida es clara y la ejecución técnica resulta proporcional. Se modifica cuando falla una capa específica, como intensidad, vínculo, forma o explicación. Se detiene la configuración física probada cuando no ofrece un aporte suficiente frente al control utilizado o produce intrusión, vigilancia o una carga excesiva que no puede corregirse. Ese resultado exige reformular la relación phygital; no demuestra que toda alternativa física carezca de valor.

El [primer protocolo](../07_validacion/protocolo-01-asociacion-y-comparacion.md) considera completa la asociación cuando la persona percibe la señal, la atribuye al ciclo y recupera la intención y el primer paso sin consultar el teléfono ni recibir pistas. La comprensión de las salidas se registra por separado: reconocer al menos dos opciones sin considerar obligatoria una de ellas es una condición de autonomía para avanzar, no un quinto componente de la asociación. En una muestra formativa de seis personas, se avanzará con al menos cinco asociaciones completas; con tres o cuatro se modificará la capa donde aparece el fallo; y con dos o menos, después de una iteración correctiva, se detendrá la configuración probada.

La comparación posterior mantendrá la configuración situada si iguala o supera al aviso sin contenido específico en asociación, supera el lugar neutro para una mayoría simple y no introduce carga o intrusión recurrentes. Este criterio conserva el alcance limitado del control digital utilizado. Un fallo crítico de autonomía, privacidad, seguridad o accesibilidad impedirá avanzar aunque se alcance el porcentaje previsto. Estos umbrales organizan una decisión formativa y no estiman eficacia poblacional.

## Conclusiones y alcance de la contribución

La investigación permite proponer condiciones para recuperar una intención durante el ocio digital: debe provenir de la persona, tener un comienzo reconocible y conservar la posibilidad de ignorar la ayuda. Las experiencias digitales que mantienen sentido delimitan cuándo no corresponde intervenir. Estas condiciones orientan la respuesta, pero todavía no demuestran su eficacia. Las entrevistas documentan tensiones, usos significativos y estrategias para separarse del teléfono. Usuario principal y usuario límite describen situaciones variables, no grupos estables. La edad caracteriza la muestra, pero no explica el problema ni permite generalizarlo.

Medir, pausar, bloquear, separar y recordar cumplen funciones diferentes. Relevo propone articular intención, primer paso, señal y lugar: la aplicación conserva la información y el objeto la relaciona con el entorno. Esa es la propuesta de valor pendiente de comparación con un aviso digital. El aporte alcanzado consiste en delimitar el problema, fundamentar criterios, distinguir situaciones de usuario y diseñar una arquitectura de uso y evaluación. El recorrido permite examinar decisiones y fallos previstos, pero no acredita comprensión, eficacia o preferencia.

Las pruebas deberán establecer si la señal recupera la intención, si el lugar aporta significado y si el soporte físico justifica su carga. También quedan abiertas activación, percepción, convivencia, accesibilidad, integración, producción y costos. La asociación se comprobará antes de compararla con el aviso y la ubicación neutra. Si la configuración física no aporta una diferencia o exige demasiado esfuerzo, deberá reformularse la relación phygital. La continuidad del proyecto dependerá de esa evidencia.

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

Google Play. (s. f.). *Foreground service requirements for apps targeting Android 14 or higher*. Google Play Console Help. Recuperado el 24 de agosto de 2026, de https://support.google.com/googleplay/android-developer/answer/17105854

Grüning, D. J., Riedel, F., & Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), e2213114120. https://doi.org/10.1073/pnas.2213114120

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A., & Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (Artículo 243, pp. 1–16). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hermann, M., Mahler, T., de Melo, G., & Weber, M. (2007). The tangible reminder. En *Proceedings of the 3rd IET International Conference on Intelligent Environments* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

Karjalainen, T.-M., & Snelders, D. (2010). Designing visual recognition for the brand. *Journal of Product Innovation Management, 27*(1), 6–22. https://doi.org/10.1111/j.1540-5885.2009.00696.x

Kauppinen-Räisänen, H., & Luomala, H. T. (2010). Exploring consumers’ product-specific colour meanings. *Qualitative Market Research: An International Journal, 13*(3), 287–308. https://doi.org/10.1108/13522751011053644

Keller, K. L., Sternthal, B., & Tybout, A. M. (2002). Three questions you need to ask about your brand. *Harvard Business Review, 80*(9), 80–86. https://hbr.org/2002/09/three-questions-you-need-to-ask-about-your-brand

Kidel Peña-Albert, A., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C., & Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, e85349. https://doi.org/10.2196/85349

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Kitchen Safe. (s. f.). *kSafe*. Recuperado el 24 de agosto de 2026, de https://intl.thekitchensafe.com/

Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W., & Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

Lukoff, K., Yu, C., Kientz, J. A., & Hiniker, A. (2018). What makes smartphone use meaningful or meaningless? *Proceedings of the ACM on Interactive, Mobile, Wearable and Ubiquitous Technologies, 2*(1), Artículo 22. https://doi.org/10.1145/3191754

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M., & Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (Paper 21, pp. 1–18). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

McDaniel, M. A., & Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*, S127–S144. https://doi.org/10.1002/acp.775

MCI Electronics. (s. f.). *Placa BBC micro:bit V2*. Recuperado el 7 de septiembre de 2026, de https://mcielectronics.cl/shop/product/bbc-microbit-v2-placa-unica/

MechatronicStore. (s. f.). *Seeed Studio XIAO nRF52840*. Recuperado el 7 de septiembre de 2026, de https://www.mechatronicstore.cl/seed-studio-xiao-nrf52840/

Meier, A., & Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Micro:bit Educational Foundation. (s. f.-a). *Bluetooth*. Recuperado el 7 de septiembre de 2026, de https://tech.microbit.org/bluetooth/

Micro:bit Educational Foundation. (s. f.-b). *Hardware*. Recuperado el 8 de septiembre de 2026, de https://tech.microbit.org/hardware/

Monge Roffarello, A., & De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53, 1–66. https://doi.org/10.1145/3571810

Montag, C., Lachmann, B., Herrlich, M., & Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), 2612. https://doi.org/10.3390/ijerph16142612

Motta-Filho, M. A. (2021). Brand experience manual: Bridging the gap between brand strategy and customer experience. *Review of Managerial Science, 15*, 1173–1204. https://doi.org/10.1007/s11846-020-00399-9

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

O’Rear, A. E., & Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

Radtke, T., Apel, T., Schenkel, K., Keller, J., & von Lindern, E. (2022). Digital detox: An effective solution in the smartphone era? A systematic literature review. *Mobile Media & Communication, 10*(2), 190–215. https://doi.org/10.1177/20501579211028647

Risko, E. F., & Gilbert, S. J. (2016). Cognitive offloading. *Trends in Cognitive Sciences, 20*(9), 676–688. https://doi.org/10.1016/j.tics.2016.07.002

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Seeed Studio. (2026). *Getting started with Seeed Studio XIAO nRF52840 series*. https://wiki.seeedstudio.com/XIAO_BLE/

Silverman, J., & Barasch, A. (2023). On or off track: How (broken) streaks affect consumer decisions. *Journal of Consumer Research, 49*(6), 1095–1117. https://doi.org/10.1093/jcr/ucac029

Smit, E. S., Zeidler, C., Resnicow, K., & de Vries, H. (2019). Identifying the most autonomy-supportive message frame in digital health communication: A 2 × 2 between-subjects experiment. *Journal of Medical Internet Research, 21*(10), e14074. https://doi.org/10.2196/14074

Sohn, T., Li, K. A., Lee, G., Smith, I., Scott, J., & Griswold, W. G. (2005). Place-Its: A study of location-based reminders on mobile phones. En M. Beigl, S. Intille, J. Rekimoto, & H. Tokuda (Eds.), *UbiComp 2005: Ubiquitous computing* (Lecture Notes in Computer Science, Vol. 3660, pp. 232–250). Springer. https://doi.org/10.1007/11551201_14

Stapley, E., O’Keeffe, S., & Midgley, N. (2022). Developing typologies in qualitative research: The use of ideal-type analysis. *International Journal of Qualitative Methods, 21*, 1–9. https://doi.org/10.1177/16094069221100633

Subsecretaría de Telecomunicaciones. (2026a, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Subsecretaría de Telecomunicaciones. (2026b). *Informe final: Estudio Duodécima Encuesta sobre acceso, usos y usuarios de Internet en Chile*. Ministerio de Transportes y Telecomunicaciones, Gobierno de Chile. https://www.subtel.gob.cl/wp-content/uploads/2026/02/Informe-Final-Acceso-y-Uso-Internet-2025_03.pdf

Tonietto, G. N., Malkoc, S. A., Reczek, R. W., & Norton, M. I. (2021). Viewing leisure as wasteful undermines enjoyment. *Journal of Experimental Social Psychology, 97*, 104198. https://doi.org/10.1016/j.jesp.2021.104198

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Ward, E., Yang, S., Romaniuk, J., & Beal, V. (2020). Building a unique brand identity: Measuring the relative ownership potential of brand identity element types. *Journal of Brand Management, 27*, 393–407. https://doi.org/10.1057/s41262-020-00187-6

Waggoner, J., Lucky, S., Redick, S., Rizki, A., & Yu, J. C. (2026). Going beyond digital libraries: A literature review of phygital user experience research methods. *International Journal on Digital Libraries, 27*(1), Artículo 1. https://doi.org/10.1007/s00799-025-00436-6

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 24 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold

---

## Registro de cambios

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
