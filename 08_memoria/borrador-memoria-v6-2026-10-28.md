Universidad Diego Portales

Facultad de Arquitectura, Arte y Diseño

Escuela de Diseño

# Relevo

Sistema *phygital* para recuperar intenciones personales durante el ocio digital

Memoria para optar al título profesional de Diseñador, mención Diseño Gráfico

Johan Maximiliano Yantén Acevedo

Profesores guía: Sergio Majluf y Simón Gallardo

Modalidad: Taller de Titulación

Santiago, Chile, diciembre de 2026

# Agradecimientos

A mi familia, que hizo posible este proyecto.

A mi mamá, por estar siempre presente, por apoyarme y por darme todo lo que he necesitado para cumplir mis metas.

A mi abuela, por educarme y por enseñarme a soñar y a explorar.

A las dos, por permitir que la creatividad, el arte y la entretención fueran parte de mi vida diaria.

# Resumen

Algunas sesiones de ocio digital se prolongan sin una decisión propia de continuar, y otras actividades también deseadas dejan de estar presentes cuando aún es posible comenzarlas. El proyecto busca diseñar y evaluar un sistema *phygital* (físico y digital) que ayude a recuperar esa intención —volver a tenerla presente— sin bloquear el teléfono ni juzgar la decisión posterior. La investigación combinó una revisión bibliográfica, ocho entrevistas semiestructuradas analizadas con el método Framework, una encuesta de 53 respuestas y una comparación de herramientas. Los resultados indican que la duración no basta para valorar una sesión, que la mayoría de las herramientas revisadas actúan sobre el uso del teléfono y no sobre la actividad que es desplazada, y que no corresponde intervenir cuando el ocio digital tiene un sentido. De ellos se derivaron ocho criterios de diseño que dan vida a Relevo: una aplicación Android y un objeto que se deja junto al primer paso de lo que la persona quiere hacer —por ejemplo, si quiere leer, lo deja junto a un libro— y emite un sonido al cumplirse una condición definida por la persona. Para probar la relación entre señal y lugar, el prototipo hace sonar un localizador Bluetooth comercial. Tres personas lo usaron en su hogar desde el 7 de octubre de 2026; hasta el 19, el ciclo completo funcionó en los tres hogares: el localizador sonó en 23 de 24 ciclos y, en 19 de 21 respuestas, la persona supo qué quería hacer antes de leerlo en la pantalla; en las 21 recordó cómo empezar, y en 10 decidió empezar. Después, con una notificación en el teléfono en lugar del localizador, recordaron igual, pero notaron el aviso tarde o no lo notaron en 10 de 21 respuestas. La prueba validó el ciclo.

*Palabras clave:* ocio digital, memoria prospectiva, diseño *phygital*

# Abstract

Some digital leisure sessions go on without a decision of one's own to continue, and other activities, also desired, fade from view while they can still be started. The project seeks to design and evaluate a phygital (physical and digital) system that helps people retrieve that intention—bring it back to mind—without blocking the phone or judging the decision that follows. The research combined a literature review, eight semistructured interviews analyzed with the Framework method, a survey with 53 responses, and a comparison of tools. The results indicate that duration alone is not enough to assess a session, that most of the tools reviewed act on phone use, not on the displaced activity, and that no intervention is called for when digital leisure has a meaning of its own. These results led to eight design criteria that shape Relevo: an Android application and an object left next to the first step of what the person wants to do (for example, next to a book, if they want to read), which plays a sound once a condition defined by the person is met. To test the relationship between signal and place, the prototype sounds a commercial Bluetooth tracker. Three people used it at home starting October 7, 2026; up to October 19, the full cycle worked in all three homes: the tracker sounded in 23 of 24 cycles, and in 19 of 21 responses the person knew what they wanted to do before reading it on the screen; in all 21 they remembered how to start, and in 10 they chose to start. Then, with a phone notification instead of the tracker, they remembered just as well, but noticed the alert late or not at all in 10 of 21 responses. The test validated the cycle.

*Keywords:* digital leisure, prospective memory, phygital design

# Índice

- 1. Motivación personal
- 2. Introducción
- 3. Planteamiento del problema
- 4. Justificación
- 5. Antecedentes y estado de la cuestión
- 6. Marco teórico por ámbitos
- 7. Usuario, contexto y hallazgos de entrevistas
- 8. Estado del arte y referentes
- 9. Criterios de diseño
- 10. Formulación
- 11. Bajada proyectual: decisiones de diseño
- 12. Factibilidad y límites
- 13. Plan de desarrollo y validación
- 14. Conclusiones
- Referencias
- Glosario
- Anexos

## Índice de tablas

- Tabla 1. Decisiones de diseño de Relevo
- Tabla 2. Iteraciones del prototipo
- Tabla 3. Presupuesto del prototipo académico
- Tabla 4. Resultados con el Tag y con el teléfono, por persona
- Tabla 5. Hallazgos de la prueba y de las revisiones, y cambios para la iteración

## Índice de figuras

- Figura 1. Ejemplo de una intención que vuelve tarde
- Figura 2. Dos caminos para que vuelva una intención
- Figura 3. Señal y mensaje de un recordatorio
- Figura 4. Paso de la señal del segundo plano al primero
- Figura 5. Discurso y conducta de las personas
- Figura 6. Última vez que siguieron en el teléfono, según la encuesta
- Figura 7. Opiniones sobre la propuesta
- Figura 8. Situaciones de uso
- Figura 9. Función y lugar de cada herramienta
- Figura 10. Ocho criterios de diseño, en tres grupos
- Figura 11. Proceso del proyecto, de marzo a octubre de 2026
- Figura 12. Recorrido del usuario
- Figura 13. Flujo de la aplicación, de preparar a decidir
- Figura 14. Arquitectura de información de la aplicación
- Figura 15. Calma, presencia y señal: el color sube con el momento
- Figura 16. Rasgos de la voz de Relevo
- Figura 17. Sistema de identidad de Relevo
- Figura 18. Tag durante la prueba en el hogar
- Figura 19. Relevo, con su carcasa propia y la placa del Tag adentro
- Figura 20. Etapas del proyecto
- Figura 21. Prueba en los hogares
- Figura 22. Resultados de los 24 relevos con el Tag
- Figura 23. Decisión de cada persona después de la señal
- Figura 24. Recordar no basta para empezar

# 1. Motivación personal

Me ocurre con frecuencia abrir una aplicación para descansar unos minutos y quedarme en ella más tiempo del que imaginaba. Al cerrarla, me doy cuenta de que otras cosas que también quería hacer —dibujar, leer, caminar o cocinar con calma— dejaron de estar presentes. No decidí abandonarlas; dejaron de participar, de tener presencia en lo que hacía.

No pienso que todo uso del teléfono sea negativo. Muchas veces encuentro en él entretención, conversación, información o un descanso que realmente valoro. Me inquieta la diferencia entre elegir seguir y seguir por inercia, como si el dispositivo decidiera por mí.

Me interesa estudiar ese momento sin convertirlo en un juicio sobre disciplina o productividad: ¿por qué una intención personal pierde presencia?, ¿qué condiciones lo favorecen y cómo podría el diseño ayudar a que vuelva a ser considerada? La pregunta nace de mi experiencia; lo que esta memoria afirma sobre otras personas proviene de la investigación. Parte de un límite claro: descansar, cambiar de actividad o seguir frente al teléfono pueden ser decisiones igualmente válidas.

# 2. Introducción

Los teléfonos inteligentes reúnen en un mismo dispositivo la comunicación, la información, el trabajo y el entretenimiento. Con ellos cambió la forma de organizar el tiempo y de descansar: una persona puede conversar, escuchar música, jugar, mirar una serie o recorrer una red social sin cambiar de espacio. Esa variedad impide tratar el uso del teléfono como una sola experiencia y vuelve insuficiente cualquier juicio basado solo en cuánto tiempo se usa.

Aquí se entiende por *ocio digital* el conjunto de actividades que una persona realiza a través de dispositivos en su tiempo disponible para descansar, entretenerse, satisfacer su curiosidad o vincularse con otros. Su valor no depende solo de la duración: una sesión larga puede ser satisfactoria y una breve puede sentirse inoportuna si pospone algo que la persona consideraba importante. En un estudio que siguió durante dos semanas el uso del teléfono de 45 personas, el sentido de cada uso dependió de su motivo y de su tipo: usarlo por hábito para pasar el tiempo se vivió como menos significativo que usarlo con un propósito, aunque incluso ese uso podía servir como un breve escape (Lukoff et al., 2018).

El problema aparece en un momento preciso. Al comenzar una sesión de ocio digital, la persona puede tener presente otra actividad que también quiere hacer: leer, dibujar, salir a caminar, ordenar su pieza o llamar a alguien. La sesión continúa y esa intención deja de estar presente; cuando la persona vuelve a pensar en ella, la ocasión puede haber cambiado o queda menos tiempo. La situación tiene dos formas: en una, la otra actividad deja de estar presente y se recuerda tarde; en la otra, sigue presente y aun así no se inicia.

Ese momento no ocurre en el vacío. Muchas aplicaciones están diseñadas para que la actividad continúe: el *desplazamiento infinito* carga contenido nuevo sin un final, y la reproducción automática inicia un contenido apenas termina otro. Estos patrones no determinan la conducta, pero reducen los momentos en que algo termina y aparece la oportunidad de elegir si seguir (Montag et al., 2019).

Las respuestas más difundidas actúan de forma directa y, a veces, drástica: las herramientas de bienestar digital miden el tiempo, fijan límites, bloquean aplicaciones o ponen una pausa antes de abrirlas (Lyngs et al., 2019). Sirven cuando alguien quiere reducir una conducta concreta, pero detener lo que se está haciendo no devuelve lo que se quería hacer: un bloqueo puede cerrar una aplicación y dejar igualmente ausente la otra intención, o cortar un descanso que la persona sí quería.

La psicología ofrece un concepto que conviene revisar. La *memoria prospectiva* es la capacidad de recordar una acción que se quiere realizar cuando llega la ocasión de hacerla (McDaniel y Einstein, 2000). Recordar al final del día que se quería leer no equivale a recuperar esa intención cuando todavía era posible abrir el libro. Así planteado, el desafío no es frenar el uso del teléfono, sino lograr que una intención vuelva a tiempo, sin convertirse en una obligación.

Este proyecto aborda ese desafío desde el diseño. Busca que una persona vuelva a considerar, mientras la sesión continúa, una actividad que ella misma eligió, sin prohibir la actividad actual ni decidir por ella qué forma de descanso vale más. Para comprender la experiencia, la investigación combina una revisión bibliográfica, ocho entrevistas, una encuesta y el análisis de herramientas y referentes. Para intervenir en ella, propone un sistema *phygital* —físico y digital— que vincula lo que la persona quiere hacer con el lugar donde eso comienza: la persona prepara en una aplicación su intención y su primer paso, y un objeto ubicado donde empieza esa actividad suena cuando se cumple una condición que ella define. La propuesta se prueba en el uso cotidiano, en tres hogares, para observar si esa señal ayuda a recuperar la intención y si la decisión sigue siendo de quien la recibe.

# 3. Planteamiento del problema

En Chile, el teléfono es la puerta principal a internet: en 2025, el 96,6 % de los hogares encuestados declaró tener acceso propio y pagado a internet, y entre los hogares conectados el teléfono inteligente fue el dispositivo más extendido, presente en el 99,1 % (Subsecretaría de Telecomunicaciones, 2025). Esas cifras describen un entorno conectado, pero no dicen si cada momento frente a la pantalla fue elegido. Este capítulo indaga cuándo ese uso se vuelve un problema y cuándo no.

## Problemática

Una persona abre una aplicación para descansar unos minutos antes de dibujar, algo que quería hacer desde la tarde. Una hora después la cierra, y ya es tarde para empezar. No decidió abandonar el dibujo: mientras la sesión de ocio digital seguía, el dibujo no volvió a aparecer. Que lo recuerde después muestra que la intención no se perdió; lo que faltó fue que volviera a tiempo, cuando todavía podía orientar la decisión (Figura 1).

**Figura 1**

*Ejemplo de una intención que vuelve tarde*

[FIGURA POR INSERTAR: (columna) esquema de problema: Antes | Hay algo que la persona quiere hacer | Dibujar en la tarde; Durante | Abre una aplicación para descansar | La sesión de ocio digital sigue, El dibujo no vuelve a aparecer; Después | Una hora más tarde | Lo recuerda, Ya es tarde para empezar]

*Nota.* Elaboración propia a partir del ejemplo del texto.

El problema puede formularse así: **durante algunas sesiones de ocio digital, una actividad que la persona también quería realizar deja de estar presente y vuelve cuando la ocasión ya pasó.**

No se trata de cuánto tiempo se usa el teléfono, sino de la relación entre la actividad presente y otra cosa que la persona también quería hacer.

Hay datos de que una intención pierde fuerza mientras la sesión continúa. Lukoff et al. (2018) preguntaron a 45 personas, en distintos momentos de cada uso del teléfono, si usaban la aplicación para lograr algo concreto o para pasar el tiempo: la primera respuesta bajó del 65,6 % al abrirla al 51,4 % durante su uso (p. 22:16). Ese estudio mide el propósito del propio uso, no otra actividad fuera del teléfono. Para esta última, la encuesta del proyecto ofrece un primer indicio: de 43 personas que, la última vez que siguieron en una aplicación más de lo que querían, tenían otra cosa que hacer, 21 no la empezaron. Es una muestra pequeña y no representativa, pero indica que la situación descrita no es solo una experiencia personal.

## Causas

**Atención ocupada.** Recordar una acción futura exige que la intención vuelva sin que nadie pida recordarla: la persona puede vigilar si llegó el momento, o algo del entorno puede traerla de vuelta, y que ocurra lo segundo depende de la señal, de la actividad en curso y de la persona (McDaniel y Einstein, 2000). Cuando una sesión absorbe la atención, vigilar se vuelve difícil; de ahí la importancia de la señal. En un estudio con 1315 personas adultas, que combinó cuestionarios breves durante el día con registros del uso del teléfono en 691 de ellas, cuanto más se prolongaba el desplazamiento sin propósito por redes sociales, más culpa declaraban las personas, y el conflicto con otras metas explicaba parte de esa relación (de Segovia Vicente et al., 2024). En promedio, ese conflicto fue bajo, lo que confirma que el problema aparece en algunas sesiones y no en todas. El estudio observa sin intervenir y no distingue el olvido de la postergación, pero muestra que la relación con otras intenciones pesa en cómo se vive una sesión de ocio digital.

**Continuidad sostenida por la interfaz.** Un capítulo, una canción o una página tienen un final reconocible; el desplazamiento infinito y la reproducción automática, en cambio, mantienen abierta la secuencia y ofrecen una acción siguiente con poco esfuerzo (Montag et al., 2019). La interfaz no actúa sola, pero define cuándo aparecen los cierres y las ocasiones de elegir.

**Ocio juzgado con la vara de la productividad.** Tonietto et al. (2021) observaron que considerar el ocio una pérdida de tiempo disminuye su disfrute, sobre todo cuando la actividad se realiza como un fin en sí misma. El estudio no trata del teléfono, pero advierte que presentar el descanso como tiempo perdido puede dañar lo que pretende cuidar.

## Desafío de diseño

De ahí nace el desafío: **ayudar a que la persona recuerde a tiempo algo que quería hacer, sin bloquear lo que está haciendo, sin decidir por ella y sin intervenir cuando el ocio digital conserva sentido.** Es importante diseñar con la idea de que recordar una intención significa devolverla a la decisión, no convertirla en obligación.

# 4. Justificación

El tema es relevante porque el teléfono participa constantemente en la vida cotidiana y reúne actividades que no pueden evaluarse con una sola regla. Las mediciones de tiempo informan cuánto se usó, pero no si una sesión respondió al propósito de la persona ni si desplazó otra intención. Una revisión de 43 evaluaciones de herramientas de autocontrol digital concluye que el tiempo de pantalla es una medida demasiado gruesa, que no refleja la variedad de metas ni de usos (Monge Roffarello y De Russis, 2023). Una respuesta más precisa debe reconocer tanto el derecho a cambiar de actividad como el de seguir descansando en el teléfono.

Cuando las alternativas se reducen a bloquear, contabilizar o comparar, una herramienta de apoyo puede convertirse en una nueva fuente de presión. Tener una intención no debería crear una deuda con el sistema: ignorar una señal, cambiar de idea o permanecer en la actividad digital son resultados legítimos. Este criterio traduce en decisiones de diseño la autonomía, una necesidad psicológica básica según la teoría de la autodeterminación: las órdenes y las metas impuestas debilitan la motivación propia, mientras que la posibilidad de elegir la fortalece (Ryan y Deci, 2000, p. 70). Así se evita confundir ayuda con obediencia.

La mayoría de las respuestas actuales trabaja dentro de la pantalla. De 367 herramientas de autocontrol digital, tres de cada cuatro bloqueaban o quitaban distracciones, y las que recordaban una meta lo hacían en la misma pantalla, por ejemplo reemplazando las publicaciones de una red social por una lista de tareas (Lyngs et al., 2019). Terzimehić et al. (2022) advierten que las intervenciones contra el uso distraído del teléfono casi no incluyen el entorno físico de las personas, y proponen considerarlo. Ese vacío corresponde al diseño: la interacción tangible estudia cómo los objetos y el espacio físico participan en la relación con la información digital (Ishii y Ullmer, 1997), y un recordatorio ubicado en el entorno podría devolver una intención desde fuera de la pantalla que concentra la atención.

El problema involucra variables que el propio diseño define y puede cambiar: continuidad, cierres, momentos, canales, jerarquías, legibilidad, esfuerzo y control. La psicología aporta conceptos para entender el recuerdo de acciones futuras y el conflicto entre metas, y la ingeniería permite programar las condiciones y la comunicación entre dispositivos; al diseño le corresponde unir ambos conocimientos en una experiencia clara, situada y respetuosa de quien la usa. El aporte se espera en dos planos: criterios para diseñar ayudas que acompañen una decisión sin presionarla, y un procedimiento para comparar, antes de fabricar un objeto propio, una señal que suena donde comienza la actividad con una notificación en el teléfono.

# 5. Antecedentes y estado de la cuestión

Antes de proponer una respuesta, conviene saber qué se ha estudiado y qué se ha probado. Este capítulo revisa esos antecedentes; el siguiente define los conceptos en que se apoya el proyecto.

## Uso del teléfono y sentido de la experiencia

Meier y Reinecke (2021) reunieron 34 revisiones sobre comunicación digital y salud mental: la asociación entre uso de redes sociales y salud mental fue, en general, negativa y pequeña, y varió según el tipo de uso y el indicador estudiado. Radtke et al. (2022) revisaron intervenciones de desconexión digital y encontraron resultados positivos, nulos y negativos. Si los efectos del uso y de la desconexión varían tanto, reducir el uso no basta como criterio. Importa también la relación entre lo que la persona hace y lo que quería hacer: en el estudio de 1315 adultos citado en el capítulo 3, la culpa tras el desplazamiento sin propósito dependía en parte de que el uso obstaculizara otras metas (de Segovia Vicente et al., 2024).

## Bloqueos, límites y pausas

Lyngs et al. (2019) analizaron 367 aplicaciones y extensiones de navegador: tres de cada cuatro bloqueaban o quitaban distracciones y alrededor de un tercio ayudaba a avanzar hacia una meta, por ejemplo recordándola en la pantalla o pidiendo fijarla. En los 43 estudios de evaluación que revisaron Monge Roffarello y De Russis (2023), la mediana de duración fue de 21 días y solo cinco superaron los 2 meses; su metaanálisis de siete estudios estimó un efecto entre pequeño y mediano sobre el tiempo de uso, medida que consideran demasiado gruesa para el bienestar.

En un experimento de campo de 6 semanas con one sec, que demora la apertura de una aplicación y pide reconsiderarla, 280 personas desistieron en el 36 % de los intentos; en otro, la opción explícita de desistir tuvo el mayor efecto y el mensaje de reflexión, por sí solo, no fue eficaz (Grüning et al., 2023). Los registros de 1039 personas que ya usaban la aplicación muestran que el uso sube durante las pausas de la intervención y vuelve a bajar al retomarla (Haliburton et al., 2024). Uno de los autores de ambos estudios desarrolló la aplicación, como declaran los propios artículos. MindPhone, en cambio, preguntaba al desbloquear el teléfono para qué se iba a usar o qué se haría después fuera de él: en un estudio de campo de 2 semanas con 28 personas, la segunda pregunta redujo el uso distraído y favoreció volver antes al entorno, y la primera aumentó la conciencia de los motivos de uso (Terzimehić et al., 2022).

## Recordatorios, lugares y objetos

Para acordarnos de algo más tarde solemos dejar una señal fuera de la cabeza: una nota, una alarma, un objeto a la vista. Tres estudios muestran de qué depende que esa señal sirva.

O’Rear y Radvansky (2019) probaron si el lugar basta como recordatorio. Las personas recorrían un centro comercial virtual repartiendo mensajes entre tiendas y, mientras lo hacían, tenían encargos pendientes: hacer algo determinado al llegar a cierta tienda. Las señales del lugar favorecieron el recuerdo, y el desempeño no cambió según cuánto rato hubiera pasado desde que recibieron el encargo.

Sohn et al. (2005) llevaron esa idea a la vida diaria con Place-Its, una aplicación de teléfono que permitía escribir una nota y dejarla colgada de un lugar conocido, para que apareciera al llegar ahí o al irse. Diez personas la usaron durante dos semanas y crearon 89 recordatorios. Hubo que volver a colgar diecinueve, porque saltaron en el lugar equivocado o en el correcto pero en un momento en que no se podían atender.

Chiu y Gilbert (2024) midieron lo que cuesta dejar la señal. Durante una tarea, en el computador, había que arrastrar círculos numerados en orden; algunos aparecían de un color que indicaba hacia qué lado llevarlos cuando llegara su turno, y el color se borraba a los dos segundos. La persona podía confiar en su memoria o adelantarse, arrastrando el círculo de inmediato al lado correcto para que su posición lo recordara después. En una de las condiciones, cada vez que alguien se adelantaba se abría una ventana que había que cerrar cinco veces antes de seguir. Ese estorbo bastó para que usaran menos el recordatorio y perdieran parte de la precisión que les daba. Los propios autores lo comparan con una aplicación de recordatorios mal diseñada, que pide clics de más para anotar algo.

Otros trabajos llevaron el recordatorio a un objeto. The Tangible Reminder mostraba cada compromiso en un objeto cotidiano que cambiaba de color al acercarse el plazo (Hermann et al., 2007); servía a citas o tomas de medicamentos, no a intenciones que la persona puede decidir no realizar. Wobble sirvió para investigar, en el hogar, recordatorios que no reclaman la atención y que, según sus autores, convienen a intenciones que no exigen actuar de inmediato (Zekveld et al., 2017). Keppel et al. (2025) compararon durante 9 semanas, con 24 personas, un artefacto físico y uno digital que mostraban en el hogar datos de actividad física: ambos sirvieron de recordatorio, y el físico generó más involucramiento. Ninguno de estos trabajos trata el ocio digital.

## Alcance de los antecedentes

Las métricas describen el uso, los bloqueos modifican el acceso, las pausas abren una reconsideración y los recordatorios apoyan el recuerdo; ninguna de estas muestra bajo qué condiciones lo que la persona quería hacer vuelve a orientar una decisión propia mientras la sesión de ocio digital continúa.

# 6. Marco teórico por ámbitos

Los antecedentes dicen qué se ha intentado, pero no por qué una intención deja de orientar lo que se hace. Tres ámbitos ayudan a entenderlo: la experiencia del ocio digital, las interfaces que sostienen su continuidad y los objetos y lugares que apoyan el recuerdo. Juntos indican qué condiciones debería respetar una ayuda.

## Experiencia del ocio digital

El sentido de una sesión se asocia con el motivo y el tipo de uso (Lukoff et al., 2018), por eso conviene mirar cada vez la forma en que alguien usa el teléfono —cuándo empezó, qué hacía, para qué y qué más quería hacer— y no el total de horas.

Hay *conflicto entre metas* cuando una actividad dificulta avanzar en otra. De Segovia Vicente et al. (2024) lo midieron como la sensación de que el uso del teléfono impedía avanzar en metas en curso, como trabajar, estudiar o hacer ejercicio, y encontraron que explicaba parte de la culpa tras el desplazamiento sin propósito. Esta memoria no supone cuál de las dos actividades debería prevalecer.

Una elección inicial deliberada no implica que cada momento posterior responda a una nueva decisión: el propósito con que se abre una aplicación se debilita mientras se usa, y lo que empezó como una elección puede seguir por hábito (Lukoff et al., 2018). Volver a decidir requiere una ocasión para reconsiderar si continuar, cambiar o detenerse (Grüning et al., 2023), y esa ocasión puede venir del final de un contenido, de una pausa o de una señal del entorno.

## Diseño de la atención

Patrones de interfaz como el desplazamiento infinito o la reproducción automática orientan lo que se percibe y cómo avanza la interacción (Montag et al., 2019). Seguir con un gesto mínimo exige menos preparación que levantarse, reunir materiales o cambiar de espacio. Agregar una *fricción*, un esfuerzo adicional como esperar o confirmar, puede abrir una ocasión de reconsiderar (Grüning et al., 2023), aunque también puede estorbar usos legítimos de la misma aplicación, como abrirla rápido para una tarea breve (Haliburton et al., 2024).

La *autonomía* se entiende en el sentido de la teoría de la autodeterminación: la posibilidad de elegir fortalece la motivación propia, y las órdenes y las metas impuestas la debilitan (Ryan y Deci, 2000, p. 70). En este proyecto, eso se traduce en que la persona entienda la ayuda y pueda aceptarla, ajustarla o rechazarla. Una ayuda difícil de detener puede presionar a la persona, aunque no bloquee el teléfono.

Las *intenciones de implementación* son planes que especifican de antemano cuándo, dónde y cómo actuar: si se presenta cierta situación, se inicia una respuesta (Gollwitzer y Sheeran, 2006).

## Recordar con objetos y lugares

La memoria prospectiva se distingue del recuerdo de acontecimientos pasados porque nadie pide explícitamente recordar: la intención debe volver por sí misma cuando todavía es posible actuar (McDaniel y Einstein, 2000).

El *marco multiproceso* explica cómo vuelve una intención: la persona puede vigilar el entorno esperando el momento indicado, o un evento puede traerla de vuelta de forma espontánea (McDaniel y Einstein, 2000; Figura 2). Que ocurra lo segundo depende de las características de la señal, de la actividad en curso y de la persona (McDaniel y Einstein, 2000). Los recordatorios más eficaces aludían a la vez a la ocasión y a la acción prevista, y los que solo anunciaban la ocasión no mejoraban el recuerdo (Guynn et al., 1998). Los estudios sobre el lugar evalúan intenciones que se recuperan al estar en el sitio, no un sonido que llega desde él (O’Rear y Radvansky, 2019). De ahí se desprende la hipótesis de este proyecto: una señal que proviene del lugar donde comienza la actividad podría indicar, sin texto, qué hacer y con qué empezar.

**Figura 2**

*Dos caminos para que vuelva una intención*

[FIGURA POR INSERTAR: (columna) esquema de caminos: Vigilar | La persona revisa si llegó el momento | Exige atención constante, Falla si otra actividad la absorbe; Recuperar ante una señal | Algo del entorno trae de vuelta la intención | Funciona aunque la atención esté en otra parte, Es el camino que busca Relevo]

*Nota.* Elaboración propia a partir de McDaniel y Einstein (2000).

Una nota, un libro sobre la mesa o una alarma son formas de *descarga cognitiva*, la acción física que reduce la demanda cognitiva de una tarea; cuando se usa el entorno para dejar un aviso de una intención que se cumplirá después, se habla de *descarga de intenciones* (Risko y Gilbert, 2016). Todo recordatorio reúne una señal, que avisa que hay algo que recordar, y un mensaje, que dice qué es (Norman, 1988/2002, p. 73; Figura 3); la señal no necesita contener un mensaje si su relación con la intención se comprende.

**Figura 3**

*Señal y mensaje de un recordatorio*

[FIGURA POR INSERTAR: (columna) esquema de recordatorio: Señal | Avisa si hay algo que recordar | Objeto, Sonido del objeto; Mensaje | Indica qué es | Objeto, Lugar donde suena y primer paso que está ahí]

*Nota.* Elaboración propia a partir de Norman (1988/2002, p. 73).

Kirsh (1995) muestra que la disposición de los objetos puede simplificar la elección, la percepción y el cálculo mental. Dejar algo junto a la puerta para no olvidar llevarlo es un ejemplo cotidiano: el lugar recuerda la intención sin que haya que pensar en ella.

**Figura 4**

*Paso de la señal del segundo plano al primero*

[FIGURA POR INSERTAR: (columna) pasos de atención: Antes de la señal | Pantalla | Objeto, junto a un primer paso; Suena el objeto | Sonido y actividad recordada | Pantalla; Termina la señal | Decisión de la persona | Objeto y pantalla]

*Nota.* Elaboración propia a partir de Weiser y Brown (1997).

La *interacción tangible* da forma física a la información digital. Ishii y Ullmer (1997) propusieron acoplarla con objetos y superficies cotidianos y distinguieron dos planos: objetos que se usan en primer plano y medios del ambiente —luz, sonido, corrientes de aire— que informan en segundo plano (Figura 4). Para el problema abordado, importa el segundo plano y el espacio: un objeto puede significar por el lugar donde se deja más que por la manipulación del mismo.

La *calm technology*, un término de Weiser y Brown (1997) que no tiene una traducción fija al español, describe el ideal de esas señales: informar en segundo plano y pasar al primero solo cuando hace falta, para luego volver (Figura 4). Una señal sonora dirigida a alguien absorto en una pantalla tensiona ese ideal, porque debe pasar al primer plano: el sonido se percibe aunque la atención esté en otra parte, y por eso mismo es intrusivo (Norman, 1988/2002, p. 103).

Los tres ámbitos dejan una idea de diseño: una ayuda podría devolver a tiempo lo que la persona quería hacer si llega desde fuera de la pantalla, desde el lugar donde la actividad comienza, y si deja la decisión en sus manos. A un sistema así, que reparte su trabajo entre lo físico y lo digital, se le llama *phygital* (Waggoner et al., 2026).

# 7. Usuario, contexto y hallazgos de entrevistas

## Público del proyecto

La teoría explica el fenómeno en general; faltaba saber cómo lo viven las personas. El proyecto se dirige a personas de 19 a 30 años que usan el teléfono para descansar y que, en ciertos momentos, quieren hacer otra cosa —leer, dibujar, tocar un instrumento, ordenar— y no la empiezan. Es el rango de edad de quienes participaron en las entrevistas y la encuesta. Un rango acotado permite comparar experiencias parecidas, sin mezclar etapas de la vida muy distintas.

## Fuentes de información

El usuario y su contexto se estudiaron a partir de dos fuentes: ocho entrevistas semiestructuradas y una encuesta en línea. Las entrevistas definieron a quién se dirige el proyecto y cuándo no debe intervenir; la encuesta, posterior, contrastó esos criterios con más personas.

Las entrevistas se hicieron en Santiago, de manera presencial durante junio de 2026, cuando el proyecto trabajaba sobre una idea anterior: un objeto donde dejar el teléfono y que luego mostraría una señal del descanso realizado. Por eso la pauta no preguntó directamente por otra actividad que la persona quisiera hacer; esa categoría surgió en el análisis. Participaron ocho personas de 19 a 27 años, y la pauta, de 13 preguntas, recorrió el tiempo libre, la última sesión de ocio digital, la valoración del ocio, los intentos de descansar sin el teléfono y la reacción ante la idea anterior. La pauta y la síntesis de cada entrevista están en el Anexo A.

La pauta recorrió la última sesión de cada persona sin nombrarle el fenómeno, así que la otra actividad apareció en sus relatos por sí sola. Después, la encuesta la preguntó de forma directa, y la prueba en los hogares registró lo que las personas hicieron tras cada señal: tres fuentes que se complementan.

Las conversaciones se grabaron en audio, se transcribieron y se analizaron con el método Framework, que ordena lo dicho en una matriz de personas y temas para compararlas entre sí (Goldsmith, 2021). De esa comparación surgieron *tipos ideales*: agrupaciones de situaciones parecidas que no pretenden calzar exactamente con nadie (Stapley et al., 2022). Sanders y Stappers (2012, p. 69), en su guía de investigación generativa, advierten que lo que las personas dicen puede diferir de lo que hacen; por eso, la prueba en los hogares registró también lo que hacen (Figura 5).

**Figura 5**

*Discurso y conducta de las personas*

[FIGURA POR INSERTAR: (columna) esquema de fuentes: Discurso | Entrevistas y encuesta | Motivos, Valoraciones, Recuerdos; Conducta | Registros de la prueba en los hogares | Momento de la señal, Respuestas, Decisiones]

*Nota.* Elaboración propia a partir de Sanders y Stappers (2012, p. 69).

La encuesta tuvo 16 preguntas y 53 respuestas de personas de 19 a 30 años: se preguntó por la última vez que alguien siguió en una aplicación más tiempo del que quería, qué otra cosa quería hacer y cómo la habría empezado, y luego pidió su opinión sobre la propuesta más reciente. Llegó cuando la propuesta ya existía y sirvió para contrastarla con más personas. Las respuestas abiertas se clasificaron en categorías; las preguntas, las categorías y los recuentos están en el Anexo B. Las Figuras 6 y 7 resumen sus resultados.

**Figura 6**

*Última vez que siguieron en el teléfono, según la encuesta*

[FIGURA POR INSERTAR: cuatro datos en tarjetas: 39 de 45, personas que siguieron en una aplicación más tiempo del que querían al menos un día de la última semana; 43 de 47, querían hacer otra cosa en ese tiempo; 42 de 43, sabían cuál habría sido su primer paso; 44 de 47, estaban en casa]

*Nota.* Encuesta en línea del autor (53 respuestas). Cada total corresponde a quienes respondieron esa pregunta.

**Figura 7**

*Opiniones sobre la propuesta*

[FIGURA POR INSERTAR: gráfico de barras: Ubicación preferida del parlante | Junto a la actividad: 36, En un lugar general de la casa: 7, No lo usaría o no sabe dónde: 10; Duración preferida del sonido | 1 a 5 segundos: 16, 6 a 15 segundos: 25, 16 a 30 segundos: 3, Que no sonara: 7, No sabe: 2; Probabilidad de probarlo, de 1 a 5 | 5: 3, 4: 20, 3: 18, 2: 8, 1: 3, No sabe: 1]

*Nota.* Encuesta en línea del autor (53 respuestas). Número de personas por respuesta.

## Relato de los usuarios

Una persona abrió Instagram al acostarse, reconoció que tenía sueño y aun así siguió; recordaba bien lo que hizo durante ese tiempo, pero dudó de que hubiera sido un descanso. Otra vio videos humorísticos, perdió la noción del tiempo y reconoció que tenía cosas mejores que hacer, aunque la sesión de ocio digital le sirvió como pausa: una actividad puede descansar y, a la vez, competir con otra intención. Una tercera describió entretenimiento seguido de aburrimiento, sin una meta concreta: no toda insatisfacción esconde una intención que recuperar. Y dos distinguieron usos dirigidos —leer manga, resolver un sudoku— de otros rutinarios: el problema no pertenece a una persona, sino a ciertos momentos.

Otras experiencias conservaron sentido: una videollamada de varias horas con una amiga, muy valorada por el vínculo; un pódcast mientras se come, o una rutina difícil de describir que se acepta como un descanso. Ni la duración ni el tipo de aplicación bastan para decidir cuándo intervenir: una señal de alerta solo por el tiempo de uso podría interrumpir una conversación o un descanso.

Para descansar sin el teléfono, siete de las ocho personas lo alejan, lo guardan, lo silencian o activan el modo No molestar, casi siempre para proteger otra actividad, y tres personas contaron que, si queda cerca, vuelven a mirarlo. La distancia y el silencio quitan el teléfono de en medio, pero no hacen presente otra actividad que quieren recuperar.

Ante una propuesta de proyecto anterior, seis personas pidieron señales simples, calmadas, discretas o visuales, y una rechazó las calificaciones y comparaciones entre días de uso en aplicaciones.

La encuesta mostró que el momento estudiado es frecuente y ocurre en casa (Figura 6). De las 43 personas que, la última vez, querían hacer otra cosa, 21 no la empezaron, 14 la empezaron —a veces mucho más tarde— y 8 cambiaron de idea, no podían empezarla o no lo recordaban. Casi todas sabían cuál habría sido su *primer paso*, la acción breve con que la actividad comienza, como abrir un libro o ponerse las zapatillas.

Después de leer la propuesta de proyecto, 49 de 53 personas explicaron bien cómo funcionaba. La mayoría pondría un parlante junto a la actividad y preferiría un sonido de 15 segundos o menos. La disposición a probarla quedó repartida: 23 personas probablemente la probarían, 18 no estaban seguras y 11 probablemente no (Figura 7). Los motivos más citados para no probarla fueron que sonara en un mal momento (8), el esfuerzo de prepararla (7) y el ruido que podía causar (7).

## Dos situaciones de uso

Los hallazgos permiten distinguir dos tipos ideales de situación (Stapley et al., 2022), que por convención se nombran como usuarios (Figura 8). El *usuario principal* está en la primera: la sesión continúa sin una nueva decisión, y otra cosa que la persona quería hacer deja de estar presente. La situación tiene las dos formas descritas en el capítulo 2: la actividad que se recuerda tarde y la que sigue presente y no se inicia. Las entrevistas respaldan sobre todo la segunda —una persona sabía que tenía sueño y siguió— y en parte la primera; la encuesta respalda sobre todo el caso al que apunta el proyecto: una actividad que la persona quiere hacer y sabe cómo empezar, pero no empieza. Su necesidad es volver a considerar a tiempo lo que quiere hacer, sin que el dispositivo decida por la persona.

**Figura 8**

*Situaciones de uso*

[FIGURA POR INSERTAR: (columna) esquema de situaciones: Usuario principal | Ocio digital que sigue sin una nueva decisión | Quiere hacer otra cosa y sabe cómo empezar, Necesita recordarla a tiempo; Usuario límite | Ocio digital con sentido | Videollamada o pódcast, Necesita poder no activar o ignorar la señal]

*Nota.* Elaboración propia a partir de las entrevistas y la encuesta.

El *usuario límite* está en la segunda: la actividad digital sucede por decisión propia, se comparte, requiere concentración, es reparadora, o no hay otra intención. La videollamada y el pódcast son los ejemplos más claros, y tres personas mostraron que la posición cambia en una misma persona. Su necesidad es conservar la autonomía: una intervención equivocada podría convertir una actividad valiosa en un problema. Para él, poder no activar, ignorar o detener la señal importa tanto como recibirla.

El hogar se eligió porque varias de las intenciones y estrategias relatadas dependen de objetos, superficies y distancias de la casa; además, muchas de las experiencias relatadas ocurren ahí.

## Necesidades de diseño

De ambas situaciones se desprenden necesidades comunes: una intención explícita, una preparación voluntaria, la posibilidad de cambiar de idea, una señal discreta, una salida inmediata y la ausencia de sanciones o sentimientos de culpa.

Las entrevistas y la encuesta precisan el momento que debe abordarse y cuándo intervenir podría convertirse en un error.

# 8. Estado del arte y referentes

## Método y criterios de comparación

Con esas necesidades a la vista, se compararon productos, servicios y proyectos que abordan el uso del teléfono, con seis preguntas: qué problema abordan, qué mecanismo usan, dónde ocurre la interacción principal, qué exigen configurar y mantener, cómo cuidan la autonomía y qué evidencia hay sobre sus resultados.

## Herramientas digitales de medición y pausa

Apple Screen Time y Google Digital Wellbeing miden el uso y fijan límites de tiempo en el teléfono (Apple, s. f.-b; Google, s. f.). Las aplicaciones de pausa llevan a una reconsideración al momento de la apertura: one sec la interrumpe con un ejercicio breve (one sec, s. f.), y su evidencia no informa qué hace la persona después de negarse (Grüning et al., 2023; Haliburton et al., 2024). Pause Point impone una espera de 10 segundos al abrir una aplicación que sea considerada distractora (Sanders, 2026). Junto con MindPhone (Terzimehić et al., 2022), todas intervienen en la pantalla, no en el lugar donde otra actividad puede comenzar.

## Proyectos de diseño en Chile

Dos memorias de diseño de la Universidad de Chile pusieron a prueba la gamificación en aplicaciones de bienestar. Riveros Oltra (2023) probó durante ocho semanas una función de hábitos con misiones, rachas y recompensas para Betterfly: los usuarios activos semanales aumentaron un 6,4 %, frente a una meta del 20 %. Venegas Álvarez (2026) diseñó un diario de gratitud que evitaba premiar con puntos o niveles, y tras un mes con 36 personas no pudo demostrar que resolviera la baja adherencia a la aplicación. Ambas buscan que la persona vuelva a la aplicación, mientras que Relevo busca que la deje; el caso de Betterfly es coherente con la decisión de excluir rachas y premios (criterio 4).

## Objetos que restringen o alejan el teléfono

Brick vincula una aplicación con un dispositivo físico que activa o revierte un bloqueo del teléfono (Brick LLC, s. f.-a). Combina alejamiento y un compromiso previo, o *precompromiso*: una decisión que restringe deliberadamente las opciones futuras. Brick Zone bloquea las aplicaciones donde se deja, sin un alcance ni una precisión documentados (Brick LLC, s. f.-b): el lugar es allí una condición restrictiva, no un recordatorio.

Unpluq (s. f.) y Screenless Breaker (Screenless, s. f.) usan etiquetas o llaves NFC (comunicación de campo cercano). En todos, el objeto hace visible el compromiso, pero suma costos de compra, compatibilidad y aprendizaje. kSafe, un contenedor que se cierra de forma temporizada, restringe sin conexión con el teléfono, pero es difícil de revertir (Kitchen Safe, s. f.). Ante estas opciones, alejar o silenciar el teléfono, como relataron las entrevistas, es más reversible y no tiene costo.

## Objetos de foco y recordatorios en el lugar

Focusaur combina un dispositivo físico con una aplicación, etiquetas NFC, sonidos, funciones de hábito y recompensas (Focusaur, s. f.). Sus recompensas pueden llevar a la persona a actuar para cumplir con el sistema y se orienta a la productividad. The Tangible Reminder y Wobble (capítulo 5) recuerdan una acción sin depender del teléfono; Place-Its la entregaba en la pantalla, a partir de una ubicación detectada, que no equivale a una relación personal con el espacio.

Una última familia resuelve el soporte, no el uso del teléfono: los localizadores Bluetooth y llaveros antipérdida, objetos pequeños que suenan cuando la persona los busca desde el teléfono. Muestran que una señal sonora cabe en un objeto pequeño y autónomo.

## Evidencia y límites de cada familia

La evidencia es desigual: los estudios sobre herramientas digitales suelen ser breves y medir el tiempo de uso (capítulo 5), y sobre los objetos comerciales no se encontró ninguna evaluación. Además, 63 de 138 personas que habían desactivado los avisos de una herramienta de autocontrol digital aceptaron darle otra oportunidad (Peña-Albert et al., 2026): una regla puede dejar de servir. La Figura 9 ubica a cada familia según lo que hace y dónde lo hace.

**Figura 9**

*Función y lugar de cada herramienta*

[FIGURA POR INSERTAR: mapa de posicionamiento: Limita el uso del teléfono | Recuerda lo que la persona quería hacer | En la pantalla | Fuera de la pantalla; Screen Time y Bienestar digital | 1.2 | 1.5; one sec y Pause Point | 2.2 | 3.1; MindPhone | 5.6 | 2.3; Place-Its | 7.7 | 3.5; Brick y Unpluq | 1.3 | 7.4; kSafe y dejar el teléfono lejos | 2.4 | 8.8; Focusaur | 4.6 | 6.4; The Tangible Reminder | 7.7 | 7.9]

*Nota.* Elaboración propia. Ubicación aproximada, según la documentación de cada producto y los estudios citados; no mide eficacia. Relevo no se incluye: el mapa muestra lo que existe. Las fichas de cada referente están en el Anexo C.

## Oportunidad

Cada elemento de Relevo tiene antecedentes, y una búsqueda de patentes halló cuatro documentos con coincidencias parciales: ni el aparato ni la relación entre recordatorios, objetos y lugares pueden presentarse como algo nuevo. Lo que no se encontró es un producto o prototipo que reúna cinco elementos —una intención formulada por la persona, un primer paso concreto, una condición digital comprensible, una señal emitida desde donde comienza la actividad y una decisión que queda abierta—, ni un estudio que compare esa señal con una notificación en el teléfono. El mapa de la Figura 9 lo deja ver: recordar lo que la persona quería hacer desde fuera de la pantalla es un cuadrante casi vacío, y su único referente, The Tangible Reminder, no trata el ocio digital. Ese es el lugar que busca ocupar Relevo.

De ahí nace una pregunta de diseño: ¿se recupera mejor una intención si la devuelve una señal desde el lugar donde comienza que si la devuelve una notificación?

# 9. Criterios de diseño

De lo investigado salen ocho criterios de diseño: reglas que guiaron cada decisión de Relevo y que después sirven para evaluarlo. Kolko (2011, p. 40) llama síntesis a este paso, en que lo aprendido se convierte en una oportunidad concreta de diseño. Los criterios se agrupan en tres ideas (Figura 10): partir de la persona, dejarle las decisiones y justificar el esfuerzo.

**Figura 10**

*Ocho criterios de diseño, en tres grupos*

[FIGURA POR INSERTAR: (columna) esquema de criterios: Partir de la persona | Criterios 1 y 2 | La persona elige qué quiere hacer, Cada actividad empieza con un paso concreto; Dejarle las decisiones | Criterios 3 a 5 | La persona decide cuándo suena, La persona decide qué hacer cuando suena, El sistema interviene solo cuando hace falta; Justificar el esfuerzo | Criterios 6 a 8 | Prepararlo toma poco esfuerzo, Lo que la persona escribe es privado, El objeto suma algo que el teléfono no da]

*Nota.* Elaboración propia a partir de la revisión bibliográfica, las entrevistas, la encuesta y la comparación de herramientas.

## Partir de la persona

**Criterio 1. La persona elige qué quiere hacer.** Relevo parte de una actividad que la persona anota —leer, dibujar, tocar guitarra—, no de algo que el sistema deduzca de su uso del teléfono. *Fundamento:* el mismo tiempo en una aplicación puede ser descanso o pérdida según el motivo y el tipo de uso (Lukoff et al., 2018), y el tiempo de pantalla, por sí solo, no basta para saber cómo está alguien (Meier y Reinecke, 2021). En las entrevistas, dos personas dudaron de que su sesión de ocio digital hubiera sido un descanso, mientras las otras seis la valoraron como tal. Solo quien usa el teléfono sabe si había otra cosa que quería hacer.

**Criterio 2. Cada actividad empieza con un paso concreto.** Junto a la actividad, la persona anota cómo empieza: una acción breve que puede hacer enseguida, como abrir un libro o sacar la guitarra. *Fundamento:* decidir de antemano cuándo, dónde y cómo actuar ayuda a pasar de la intención a la acción (Gollwitzer y Sheeran, 2006). Relevo toma de esa idea el cómo y el dónde se empieza, y deja el compromiso en manos de la persona. En la encuesta, 42 de las 43 personas que tenían otra cosa que querían hacer —fuera de su ocio digital— supieron decir cómo la habrían empezado.

## Dejarle las decisiones

**Criterio 3. La persona decide cuándo suena.** Relevo suena cuando las aplicaciones que la persona eligió suman el tiempo que ella misma fijó: una regla que se entiende y se cambia en un toque. *Fundamento:* el teléfono puede medir cuánto se usa cada aplicación (Google, 2026b), pero no sabe para qué se usa; en la encuesta, 18 de 53 personas valoraron el teléfono para aprender o resolver algo. Por eso la condición la pone la persona, no el sistema.

**Criterio 4. La persona decide qué hacer cuando suena.** Puede empezar su actividad, dejarla para después o cambiar de idea, y las tres respuestas valen lo mismo. *Fundamento:* ofrecer una opción real ayuda más que insistir; en un estudio con la aplicación one sec, la opción explícita de no seguir tuvo más efecto que el mensaje de reflexión (Grüning et al., 2023). Por eso las respuestas tampoco se califican: una racha puede volverse una meta en sí misma y desanimar cuando se rompe (Silverman y Barasch, 2023).

**Criterio 5. El sistema interviene solo cuando hace falta.** Suena solo cuando la persona preparó un relevo, es decir, cuando hay algo que ella quiere recordar. *Fundamento:* muchas veces el teléfono es justo lo que la persona quiere —una videollamada larga con una amiga o un pódcast para la hora de comer, contaron dos personas—, y tratar ese tiempo como perdido le quita disfrute (Tonietto et al., 2021). Una ayuda que interrumpe lo que vale la pena se vuelve una molestia.

## Justificar el esfuerzo

**Criterio 6. Prepararlo toma poco esfuerzo.** Un relevo se prepara con pocas preguntas y respuestas. Cuanto más esfuerzo exige fijar un recordatorio, menos se usa (Chiu y Gilbert, 2024), y en la encuesta el esfuerzo de prepararlo fue uno de los motivos más citados para no probar la propuesta. Si preparar cuesta más de lo que ayuda, el diseño debe simplificarse.

**Criterio 7. Lo que la persona escribe es privado.** La actividad que alguien quiere hacer es personal: Relevo la guarda con un código en lugar del nombre, la notificación de la pantalla bloqueada no la muestra y la persona puede borrar sus datos cuando quiera. En la encuesta, 12 de 53 personas aceptarían solo un registro que se almacena en su teléfono, o ninguno.

**Criterio 8. El objeto suma algo que el teléfono no da.** Un objeto cuesta dinero y cuidado, así que debe aportar algo propio, como sonar desde el lugar donde la actividad empieza. El lugar puede ayudar a recordar una acción futura (O’Rear y Radvansky, 2019), y la prueba busca comparar ese aporte frente a una notificación en el teléfono.

# 10. Formulación

## Problema de diseño y pregunta de investigación

El estado del arte mostró que medir, pausar o restringir el uso del teléfono no devuelve lo que la persona quería hacer ni le indica por dónde empezar. El problema de diseño, entonces, es ayudar a que una intención propia vuelva a tiempo, con el teléfono libre y la decisión en manos de la persona. Relevo se dirige a quien tiene una actividad en mente, sabe cómo empezarla y quiere tenerla presente mientras descansa con el teléfono. De ahí nace la pregunta que guía el proyecto:

> ¿Bajo qué condiciones lo que una persona quería hacer vuelve a estar presente a tiempo, y la decisión sigue siendo suya, mientras una sesión de ocio digital continúa?

La pregunta pide condiciones. La investigación y los criterios del capítulo 9 las proponen, y una de ellas —que la señal llegue desde el lugar donde la actividad comienza, el criterio 8— se formula como hipótesis y se pone a prueba frente a una notificación en el teléfono. Que una intención vuelva a estar presente a tiempo significa que, cuando suena la señal, la persona recuerda qué quería hacer y cómo empezarla antes de leerlo en la pantalla; se puede evaluar sin exigir que deje el teléfono.

## Definición y alcance de Relevo

Relevo es un sistema *phygital*: una aplicación Android y un objeto que se deja junto al primer paso de una actividad. En la aplicación, la persona anota qué quiere hacer, cómo empieza y cuánto tiempo quiere darse en ciertas aplicaciones; cuando ese tiempo se cumple, el objeto suena unos 30 segundos desde ese lugar, y ella decide qué hacer. Para probar la señal y el lugar antes de fabricar el objeto propio, el prototipo usa un llavero Bluetooth comercial, un Tag. El alcance es doméstico y personal: una persona, una actividad a la vez, las aplicaciones que ella elige y un lugar de su casa. El capítulo 11 explica por qué se tomó cada una de estas decisiones.

## Hipótesis y objetivos

> Si se diseña un sistema *phygital* que vincula una actividad que la persona quiere hacer con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella.

La hipótesis se apoya en la memoria prospectiva: una intención puede volver sin esfuerzo cuando algo del entorno la trae de vuelta, y que ocurra depende de la señal, de la actividad en curso y de la persona (McDaniel y Einstein, 2000); el lugar donde debe hacerse una acción puede ofrecer esa señal (Kirsh, 1995; O’Rear y Radvansky, 2019). Se descompone en tres supuestos:

1. Asociación: al oír la señal, la persona sabe que es Relevo y recuerda su actividad y cómo empezar, sin mirar el teléfono.
2. Lugar: el objeto junto al primer paso ayuda a recordar más que el mismo objeto en un lugar sin relación con la actividad.
3. Soporte: el objeto ayuda al menos tanto como una notificación en el teléfono, sin más molestia.

La prueba en los hogares examina el primer supuesto y el tercero.

El objetivo general es diseñar y evaluar Relevo, un sistema que ayude a una persona a recordar a tiempo algo que quería hacer mientras descansa con el teléfono, con una señal que suena junto al primer paso de esa actividad y que deja la decisión en sus manos. La evaluación es formativa: busca encontrar problemas y mejorar el diseño en cada vuelta (Nielsen, 1993, p. 170).

Los objetivos específicos son:

1. Entender cuándo el uso del teléfono desplaza algo que la persona quería hacer, a partir de estudios, entrevistas, una encuesta y herramientas existentes.
2. Diseñar una aplicación y un objeto que lleven esa intención al lugar donde la actividad empieza.
3. Comparar el sonido del objeto junto al primer paso con una notificación en el teléfono.
4. Probar en hogares si las personas entienden la señal, si les resulta cómoda y si el sistema funciona.

## Enfoque metodológico y plan de trabajo

El proyecto sigue un enfoque de investigación a través del diseño: diseñar el objeto y la aplicación es, en sí mismo, una forma de investigar, y su resultado es un aporte (Zimmerman et al., 2007). Es exploratorio y principalmente cualitativo, con recuentos simples. Consta de seis fases: investigación, análisis, formulación y diseño, prototipo, prueba en los hogares y cierre. La Figura 11 muestra el camino, un proceso con cambios de rumbo, en que cada decisión respondió a lo que se iba aprendiendo.

Ese enfoque aportó lo que otro no habría dado. Un prototipo funcionando en hogares reales permitió observar lo que las personas hacen, y no solo lo que dicen, y cada versión puso a prueba una decisión concreta —la duración de la señal, las opciones de un toque, el lugar del objeto— con consecuencias visibles en el uso. Los criterios del capítulo 9 son, a la vez, un resultado de la investigación y la regla con que se evalúa el diseño, y la Tabla 2 muestra cómo cambió el prototipo con lo aprendido. Zimmerman et al. (2007) proponen juzgar este tipo de trabajo por su proceso, su invención, su relevancia y su extensibilidad; esta memoria documenta el proceso en sus decisiones de diseño y en los anexos, y deja la extensibilidad en un procedimiento para comparar una señal que suena en el lugar con sus alternativas.

**Figura 11**

*Proceso del proyecto, de marzo a octubre de 2026*

[FIGURA POR INSERTAR: cronología del proyecto: Marzo a junio | Seminario de Título: un objeto para dejar el teléfono; 11 y 12 de junio | Ocho entrevistas a usuarios; 20 de julio | Examen: la comisión pide aclarar el objeto, el contexto y el usuario; 23 al 30 de agosto | Análisis de entrevistas y criterios de diseño; Septiembre | Se define una señal sonora y se decide probar un Tag; 21 al 25 de septiembre | Primera aplicación en Android; 29 de septiembre | Hipótesis y encuesta de 53 respuestas; 5 al 7 de octubre | El Tag pasa a ser el objeto del prototipo; 7 de octubre | Comienza la prueba en tres hogares; 9 al 20 de octubre | Cambios a partir de los comentarios de las personas; 28 de octubre | Modelo de Relevo para impresión 3D]

*Nota.* Elaboración propia.

### Uso de inteligencia artificial

El proyecto usó herramientas de inteligencia artificial generativa, que permitieron optimizar el tiempo y ahorrar recursos: Codex, de OpenAI, desde marzo de 2026, y Claude Code, de Anthropic, desde fines de septiembre. Codex ayudó a programar las primeras versiones de la aplicación, y Claude Code la desarrolló, con su base de datos, a partir de los prototipos, las ideas, los bocetos y los *wireframes* de Figma del autor; también ayudó a leer y ordenar el proceso. Además, las herramientas ayudaron a modelar el objeto en 3D según las especificaciones del autor, a revisar la redacción —errores, repeticiones y palabras que podían confundir—, a buscar fuentes sin un muro de pago y a verificar citas. Revisar la redacción es un uso que acepta la editorial académica Springer Nature: un modelo de lenguaje puede pulirla, y una persona responde siempre por el trabajo (Springer Nature, s. f.). El autor hizo la investigación y las entrevistas, escribió esta memoria, definió el problema y los criterios, diseñó la identidad y la interfaz, revisó, corrigió o descartó cada propuesta y responde por el contenido (Anexo E).

# 11. Bajada proyectual: decisiones de diseño

Con el problema y los criterios claros, comienza la etapa de diseño. La meta es que Relevo se sienta liviano: que prepararlo tome poco, que acompañe sin pedir atención y que, al sonar, devuelva algo que la persona misma eligió. Cada decisión de este capítulo responde a esa idea, y todas son del autor; la Tabla 1 las resume, de lo general a lo particular.

**Tabla 1**

*Decisiones de diseño de Relevo*

| Ámbito | Decisión | Fundamento | Opciones descartadas |
| --- | --- | --- | --- |
| Sistema | Una aplicación, un objeto junto al primer paso y el lugar. | La señal llega desde fuera de la pantalla y junto al comienzo. | Bloquear o pausar aplicaciones; una notificación como única señal. |
| Recorrido | Una pregunta por pantalla, con respuestas fáciles. | Prepararlo pide poca lectura y poco esfuerzo. | Un formulario único. |
| Condición | El tiempo en las aplicaciones que la persona elige. | Es fácil de entender y de ajustar. | La continuidad de uso; una franja horaria. |
| Arquitectura | Tres destinos: Inicio, Ruta y Perfil; Inicio muestra solo lo más próximo. | La aplicación acompaña sin pedir que se la revise. | Todo al mismo tiempo. |
| Lenguaje visual | Las pautas de diseño de Apple como referencia en el diseño de interfaces móviles. | Equilibran belleza y legibilidad, con acciones conocidas. | Una interfaz plana, más rápida; Material Design completo. |
| Comunicación | De tú, con preguntas y palabras cotidianas. | Una orden o una calificación presiona a la persona, no la ayuda. | Rachas, puntos y mensajes que apuran. |
| Identidad | Una paleta cromática de seis colores pastel de igual peso visual, uno por tipo de momento. | Ningún momento se impone a otro. | Fundar la paleta en asociaciones netamente emocionales. |
| Objeto | Un Tag comercial, fácil de conseguir, y después Relevo, el objeto propio. | Se conecta fácil, permite probar la señal y el lugar antes de fabricar y deja usar Relevo de varias formas. | Localizadores de ecosistema cerrado. |
| Señal | Un sonido de unos 30 segundos que termina solo o se puede silenciar. | Alcanza a distancias medias a quien mira una pantalla. | Una vibración; una alarma que insiste. |
| Datos | Un código en lugar del nombre y avisos que no muestran la actividad. | Lo que la persona escribe es suyo y privado. | Registrar más de lo necesario. |

*Nota.* Elaboración propia.

## Funcionamiento de Relevo

Relevo reúne tres piezas: una aplicación, un objeto y un lugar. En la aplicación, la persona anota algo que quiere hacer y cómo empezaría; deja el objeto junto a ese primer paso —sobre el libro o al lado de la guitarra— y elige cuánto tiempo quiere darse en ciertas aplicaciones. Cuando ese tiempo se cumple, Relevo suena desde ese lugar. El sonido llega desde fuera de la pantalla y desde donde la actividad empieza: la persona no necesita leer nada para saber qué era (Figura 12).

**Figura 12**

*Recorrido del usuario*

[FIGURA POR INSERTAR: esquema de recorrido: Preparar | Una pregunta por pantalla | ¿Qué quieres hacer?, ¿Cómo empiezas?, ¿Dónde empiezas?, ¿Cuándo suena?; Seguir en el teléfono | Relevo cuenta en segundo plano | Las aplicaciones seleccionadas suman el tiempo fijado; Oír la señal | Desde el lugar de la actividad | Un sonido de unos 30 segundos que termina solo o se puede silenciar; Decidir | Con un toque | Comencé la actividad, La dejé para después, Cambié de idea]

*Nota.* Elaboración propia. Las preguntas son las de la aplicación.

**Justificación del objeto.** La pantalla es justo lo que tiene la atención de la persona, y una notificación llega por ese mismo canal. Un objeto en el lugar de la actividad, en cambio, une la señal con el comienzo: algo del entorno puede traer de vuelta una intención (McDaniel y Einstein, 2000), y el lugar donde la acción ocurre puede ser esa señal (O’Rear y Radvansky, 2019). Es la idea de la interacción tangible y de la *calm technology*: que los objetos y el entorno informen sin pedir la pantalla (Ishii y Ullmer, 1997; Weiser y Brown, 1997).

**Decisión abierta.** Cuando Relevo suena, la persona puede empezar su actividad, dejarla para después o cambiar de idea, y las tres respuestas valen lo mismo. Hay tres razones. La primera: seguir en el teléfono no siempre es un error; a veces es justo el descanso que la persona eligió, como mostraron las entrevistas. La segunda: los mensajes que parecen ser una orden despiertan rechazo, y recordar que la decisión es de la persona lo reduce (Miller et al., 2007); en la aplicación one sec, lo que más funcionó fue ofrecer la opción explícita de no seguir (Grüning et al., 2023). La tercera: decidir por uno mismo es una necesidad psicológica básica (Ryan y Deci, 2000). Si Relevo decidiera por la persona, sería una presión más y dejaría de ser una ayuda. Este principio ordena todas las demás decisiones.

## Recorrido del usuario

El recorrido tiene cuatro momentos —preparar, seguir en el teléfono, oír la señal y decidir—, y cada uno se diseñó para pedir lo mínimo (Figura 13).

**Figura 13**

*Flujo de la aplicación, de preparar a decidir*

![1. Actividad](memoria-1920x1080/figuras/preparar-p1.png) ![2. Condición](memoria-1920x1080/figuras/preparar-p4.png) ![3. Relevo listo](memoria-1920x1080/figuras/preparar-p6.png) ![4. Inicio, mientras cuenta](anexos/imagenes/app-3.3-1-inicio.jpg) ![5. Señal](anexos/imagenes/app-3.3-4-suena.jpg) ![6. Decisión](anexos/imagenes/app-3.3-6-decidir.jpg)

*Nota.* Capturas del autor, con un perfil de prueba. La prueba en los hogares usó una versión anterior, con los mismos pasos y otra identidad visual.

**Preparar.** Cada actividad preparada con su condición se llama, en la aplicación, un *relevo*. Prepararlo es responder unas pocas preguntas: «¿Qué quieres hacer?», «¿Cómo empiezas?», «¿Dónde empiezas?» y «¿Cuándo suena?». Las respuestas requieren poco esfuerzo: se eligen entre opciones concretas, como «Abrir el libro» o «En el velador», porque seleccionar cuesta menos que escribir, y cada esfuerzo de más hace menos probable que un recordatorio se prepare (Chiu y Gilbert, 2024); escribir sigue disponible. El botón para seguir está siempre en el mismo lugar, al alcance del pulgar. Antes de activar, la persona hace sonar Relevo desde donde quedó y confirma que lo oye: sabe desde el primer día que la señal la va a alcanzar. Cada dato puede cambiarse después, incluso con el relevo activo, algo que nace de los comentarios de una persona durante la prueba.

**Seguir en el teléfono.** Mientras cuenta el tiempo, Relevo se hace a un lado: la persona usa el teléfono como siempre. El tiempo que se cuenta es el que suman las aplicaciones que ella eligió, de 1 minuto a 6 horas: una regla fácil de entender y de ajustar. Una persona de la prueba bajó su límite de 45 a 35 minutos porque, al sonar, ya estaba demasiado inmersa en un video.

**Oír la señal.** Cuando se cumple el tiempo, Relevo suena desde el lugar de la actividad. El sonido dura unos 30 segundos y termina solo; la persona puede silenciarlo antes desde la aplicación o con el botón del Tag.

**Decidir.** Después llega una sola pregunta, «¿Qué decidiste?». Las tres respuestas —«Comencé la actividad», «La dejé para después» y «Cambié de idea»— tienen el mismo tamaño, el mismo color y el mismo lugar, y ninguna viene marcada de antemano: decide la persona.

**Primer uso.** Antes del primer relevo, once pantallas presentan Relevo, piden el consentimiento y los permisos necesarios de la aplicación, y acompañan a preparar el primer relevo. Las tres personas de la prueba las completaron, pero el recorrido les resultó largo.

## Arquitectura de información

La aplicación tiene tres destinos, en una barra inferior: Inicio, Ruta y Perfil (Figura 14). Los destinos se nombran con sustantivos y las acciones con verbos —«Preparar un relevo», «Activar el relevo»—, para que la persona distinga dónde está de lo que puede hacer. Inicio muestra solo lo más próximo, en una tarjeta principal: el relevo que está activo, la vuelta a la aplicación después de una señal o el siguiente paso de una actividad que la persona eligió. Al volver después de unos días, saluda con «Hola de nuevo» y pregunta «¿Sigue siendo lo que quieres?», sin decir cuántos días pasaron: contarlos convertiría el regreso en una falta. Así, la aplicación acompaña sin convertirse en algo que hay que revisar. Ruta guarda los pasos de una actividad que la persona quiere sostener en el tiempo y Perfil reúne lo que es suyo: sus relevos, sus actividades, sus ajustes, sus datos y su personalización.

**Figura 14**

*Arquitectura de información de la aplicación*

[FIGURA POR INSERTAR: esquema de arquitectura de información: Inicio | Tarjeta única con lo más próximo | Preparar un relevo (seis pasos), Relevo activo, Señal, Preguntas y decisión; Ruta | Pasos de una actividad | Paso actual, Editar la ruta, Preparar un relevo con este paso; Perfil | Contenido propio de la persona | Resumen semanal, Relevos, Actividades propias, Apariencia, Avisos, Permisos, Privacidad y datos, Ayuda, Uso del Tag]

*Nota.* Elaboración propia. El registro de las 39 pantallas está en el Anexo F.

La prueba mostró que la pantalla del relevo activo todavía muestra demasiado; la iteración siguiente deja a la vista solo la actividad, el tiempo que falta y una acción.

## Lenguaje visual: Apple como referencia

La interfaz de Relevo toma como referencia las Human Interface Guidelines, las pautas con que Apple explica cómo diseñar para sus plataformas. No se eligieron por un efecto en particular, sino por cómo equilibran belleza y legibilidad: en ellas, el diseño está al servicio de lo que la persona quiere hacer. La decisión se tomó el 27 de septiembre de 2026, frente a una versión plana de la aplicación: el autor buscaba una interfaz hermosa y fácil, sin sobrediseñar ni sobreexplicar.

Tres principios del sistema de diseño que Apple presentó en 2025 guiaron la interfaz (Apple, 2025a). La *jerarquía* se construye con el orden y la agrupación, no con adornos: los controles se apartan y el contenido —la actividad y su primer paso— queda adelante, mientras el color destaca la acción principal. La *armonía* nace de la concentricidad: las esquinas redondeadas de tarjetas, botones y hojas comparten centro con las del teléfono, y todo se siente parte de una misma forma. La *consistencia* hace que cada componente tenga siempre las mismas partes y aparezca donde la persona lo espera.

Para Relevo, eso significa una aplicación que se aprende sin instrucciones y que sabe apartarse. Se abre pocas veces al día, y su trabajo es devolver la atención a otra actividad, como propone la *calm technology* (Weiser y Brown, 1997). Navegarla se parece a usar las aplicaciones que la persona ya conoce: una barra de pestañas abajo y un botón principal ancho, siempre al pie y cerca del pulgar. Cada uno de esos gestos se apoya en principios conocidos de la interacción: las personas prefieren que una interfaz funcione como las que ya usan, un objetivo grande y cercano se alcanza antes, elegir entre pocas opciones toma menos tiempo y una interfaz que responde sin hacer esperar se siente fluida (Yablonski, s. f.). Incluso la belleza cumple una función, porque lo que se percibe bello tiende a percibirse más fácil de usar (Yablonski, s. f.).

La forma se repite en todas las escalas. Las cápsulas de los botones, las esquinas de las tarjetas y los círculos del logo comparten una misma curva, y por eso la aplicación, la marca y el objeto se reconocen como una familia. El desenfoque, sutil, aparece solo en la barra de navegación y en las hojas que suben desde el borde, nunca sobre el contenido: separa lo que se lee de lo que sirve para moverse, como proponen las pautas de Apple (Apple, 2025a), y junto con una opacidad progresiva deja adivinar que hay más contenido abajo.

La jerarquía también se construye en el tiempo: el color sube con el momento (Figura 15). Al preparar un relevo dominan el blanco y el negro, y el color aparece solo en fichas pequeñas que nombran cada parte; en Inicio, la actividad se presenta en una tarjeta con su degradado; cuando suena, ese color llena toda la pantalla, rodeado de anillos que dibujan el sonido. El color, la herramienta de jerarquía más fuerte de la interfaz, se guarda para el único momento que debe pasar al primer plano, y el resto del tiempo Relevo informa desde el segundo plano, como propone la *calm technology* (Weiser y Brown, 1997).

**Figura 15**

*Calma, presencia y señal: el color sube con el momento*

![a. Al preparar: blanco, negro y fichas pequeñas](anexos/imagenes/app-3.3-2-todo-listo.jpg) ![b. Inicio: la actividad, en una tarjeta con su color](anexos/imagenes/app-3.3-1-inicio.jpg) ![c. Cuando suena: el color de la actividad en toda la pantalla](anexos/imagenes/app-3.3-4-suena.jpg)

*Nota.* Capturas del autor, con un perfil de prueba.

**Apple frente a Material Design.** La aplicación corre en Android, donde lo conocido es Material Design, el sistema de Google. De Apple se tomaron principios y una escala tipográfica, no una apariencia: la tipografía se lee en el cuerpo que usa iOS, un poco mayor que el de Material, con más interlineado, y los títulos en seminegrita marcan la jerarquía sin recurrir a cajas ni líneas (Android Open Source Project, s. f.; Apple, s. f.-c). Lo que pertenece al sistema —los permisos, las notificaciones y el gesto para volver— se ve como en cualquier Android, para que la persona lo reconozca de inmediato. Material Design completo se descartó porque su escala tipográfica más chica y sus títulos en regular no daban esa jerarquía clara en una aplicación que se abre pocas veces al día.

**Color e imagen.** Cada actividad tiene su degradado de color, con grano y volumen, y su ícono, y el perfil, un emoji que la persona elige para identificarse. Los degradados son de otro material que las fichas planas de la interfaz, para que el color de una actividad nunca se confunda con el de una función. La tipografía sobre cada color cambia a blanco o negro según qué tan claro u oscuro sea el fondo, para mantener el contraste mínimo que piden las pautas de accesibilidad web (World Wide Web Consortium, 2024).

**Accesibilidad.** La opción «Letra grande» suma un 15 % al cuerpo tipográfico que ya usa la persona; hay tema claro y oscuro; el movimiento se reduce si Android lo pide, por accesibilidad o por ahorro de batería, y el color siempre va acompañado de una palabra y un ícono, como piden las WCAG 2.2 (World Wide Web Consortium, 2024). Una simulación de cómo ven los colores las personas con daltonismo (Machado et al., 2009) muestra que dos pares de fichas se confunden, el celeste con el lila y el rosa con el durazno: por eso el color ayuda, pero el ícono y la palabra informan.

## Voz de Relevo

Las palabras también son parte de la interfaz. Un breve estudio para diseñar los textos de Relevo reunió lo que recomiendan las guías de escritura de Apple, Google y Microsoft y la investigación sobre tono y autonomía, y propuso una voz para Relevo con cuatro rasgos (Figura 16).

**Figura 16**

*Rasgos de la voz de Relevo*

[FIGURA POR INSERTAR: esquema de voz: Cercana y tranquila | Acompaña sin apurar | «Prepáralo con calma.»; Clara y concreta | Dice qué pasa y qué hacer | «No sonó en el parlante. Revisa que esté encendido y conectado.»; Respetuosa de la decisión | Ofrece y no ordena | «Ninguna respuesta es mejor que otra.»; Honesta | Dice qué guarda y qué no ve | «Qué no vemos»]

*Nota.* Elaboración propia a partir del estudio de los textos de la aplicación. Los ejemplos son textos de la aplicación.

La voz es la misma en toda la aplicación; el tono cambia según el momento: acogedor la primera vez, práctico al preparar, sereno mientras cuenta, neutro cuando suena y sobrio al hablar de datos. Relevo habla de tú, en frases cortas y con palabras cotidianas —«querer» antes que «desear», «usar» antes que «utilizar»—, como recomienda la guía de estilo en español de Microsoft (2021), y sigue la regla del equipo de escritura de Apple: tan largo como haga falta y tan corto como se pueda (Apple, 2024). Pregunta en vez de rotular —«¿Cómo empiezas?»—, y sus botones empiezan con un verbo que dice qué va a pasar, como «Activar el relevo» (Apple, 2025b).

El vocabulario también es una decisión. La aplicación habla de «actividad» y de «sonar», palabras que dejan la intención en manos de la persona; *meta*, *tarea* o *alarma* la convertirían en un deber, y por eso se evitan. Por la misma razón evita el lenguaje de la obligación, como «debes» o «tienes que», que despierta rechazo (Miller et al., 2007), y cuando hay opciones las nombra con el mismo peso, porque un texto amable no reemplaza la posibilidad real de que la persona decida (Smit et al., 2019).

## Identidad

**Nombre.** Un relevo es el momento en que algo pasa de una mano a otra, como en una carrera de relevos. El nombre cuenta lo que el sistema busca: que la atención pase de la pantalla a lo que la persona quería hacer, sin que nadie se la quite. Es breve, se pronuncia sin trabas en español y viene del mundo de los traspasos y los turnos, no de las prohibiciones.

**Logo.** Cuatro círculos se pasan el turno en el sentido del reloj, cada uno bajo el siguiente, y dejan el centro abierto: el tiempo, el primer paso, el lugar y la decisión (Figura 17). El centro vacío es el traspaso, de la pantalla a la actividad. Las formas circulares se asocian con suavidad y cuidado (Jiang et al., 2016), y los colores planos, sin transparencias, se reproducen igual en pantalla, en papel o impresos sobre el objeto. Su construcción, paso a paso, y sus versiones están en el Anexo H.

**Figura 17**

*Sistema de identidad de Relevo*

[FIGURA POR INSERTAR: lámina de identidad: logotipo, paleta cromática, tipografía e íconos]

*Nota.* Elaboración propia. Identidad diseñada por el autor, cerrada el 11 de octubre de 2026.

**Paleta cromática.** La paleta se decidió por su función. Seis fichas pastel con el mismo peso visual acompañan cada una un momento: el amarillo, el tiempo; el celeste, el primer paso; el verde, el lugar; el rosa, la decisión, y otros dos, la personalización y lo que viene después de la señal. Las seis tienen casi la misma luminosidad, medida como la percibe el ojo y no como la guarda la pantalla, así que pesan lo mismo: el color distingue sin jerarquizar, que es la traducción visual del principio de que ningún momento vale más que otro. Albers (2013) mostró que un color cambia de apariencia según los que tiene al lado; igualar su luminosidad mantiene ese peso cuando las fichas aparecen juntas. Son claras y poco saturadas, porque la saturación eleva la activación emocional (Wilms y Oberfeld, 2018), y lo que acompaña no debería activar de más. Cada color significa siempre lo mismo, y la selección va en negro y no en color: si usara el amarillo, el amarillo significaría dos cosas. La tipografía sobre cada ficha mantiene el contraste que piden las WCAG 2.2 (World Wide Web Consortium, 2024). Los círculos del logo (Figura 17) son la versión más intensa de cuatro de esas fichas. Las asociaciones entre colores y emociones cambian según el contexto y la persona (Elliot y Maier, 2014; Jonauskaite et al., 2024), así que no fundan la elección: solo sirvieron para descartar. El rojo, muy ligado a la rabia y el tono que más activa (Wilms y Oberfeld, 2018), queda para los errores, y el negro, el gris y el rojo quedan fuera de los estados de la persona, como en la convención de la señalética (International Organization for Standardization [ISO], 2011).

**Tipografía.** La identidad usa dos tipografías sin serifa, cada una con su tarea. El logotipo, «relevo», va siempre en minúsculas y en Chillax Semibold, convertida a trazos. Se eligió entre 20 tipografías sin serifa por tres razones: su «o» es casi un círculo y conversa con los círculos del símbolo; la «e» y la «r» terminan en curvas abiertas, que hacen la palabra amable, y en tamaños pequeños no pierde la forma. La aplicación usa Instrument Sans, una grotesca de código abierto codiseñada por Rodrigo Fuenzalida, diseñador radicado en Santiago, y Jordan Egstad. Se eligió porque se lee bien en pantallas y en papel, porque sus pesos y anchos resuelven toda la jerarquía con una sola familia y porque su dibujo sobrio deja el carácter al logotipo. En la aplicación, la jerarquía sigue la de iOS —título grande, título, encabezado, texto y nota—, con títulos en semibold y texto en regular, siempre con mayúscula inicial y sin interletrado abierto, para que cada rótulo se lea como una frase.

**Iconografía.** Los 72 íconos son propios: se dibujaron en una retícula de 24 con un trazo de 1,6, el mismo grosor que el asta de Instrument Sans junto a su rótulo, para que ícono y palabra pesen lo mismo, y siempre van con una palabra. Lo propio de Relevo se dibuja con sus ideas: el sonido como anillos que se abren, y el primer paso como un punto en el primer peldaño de una escalera.

**Proceso de la identidad.** Entre septiembre y octubre de 2026, el autor exploró más de veinte propuestas de identidad. Un subrayado azul, que venía de «relevar» como resaltar, se descartó porque no decía qué hace Relevo; las tipografías con serifa y las manuscritas se exploraron y se dejaron, y el 11 de octubre quedaron definidos el logo de cuatro círculos, la paleta cromática de seis colores y los 72 íconos. Las propuestas anteriores están en el Anexo H.

## Objeto

**Proceso.** En sus primeras fases, el objeto era un lugar donde dejar el teléfono; después pasó a ser una señal en el lugar donde empieza la actividad.

**Tag.** El prototipo usa un llavero antipérdida Bluetooth: es barato, se consigue fácilmente y suena cuando la aplicación se lo pide. Un prototipo puede usar medios simples si conserva lo esencial (Nielsen, 1993, pp. 96–97), y aquí lo esencial era el lugar y el sonido (Figura 18).

**Figura 18**

*Tag durante la prueba en el hogar*

![a. Relevo preparado y Tag en la mano](figuras/figura-4a-relevo-preparado.jpg) ![b. Tag sobre un mueble del mismo hogar](figuras/figura-4b-tag-en-un-mueble.jpg) ![c. Tag sobre un escritorio](figuras/figura-4c-tag-en-un-escritorio.jpg)

*Nota.* Fotografías de la prueba en los hogares. En a, la pantalla muestra la actividad, el primer paso y el lugar donde sonará el Tag; se difuminó el nombre de la persona.

**Objeto propio.** El objeto propio es una carcasa redonda que lleva adentro la placa y la pila del Tag: conserva el sonido ya probado y suma forma, control y marca (Figura 19). Mide 46 mm de diámetro y 12,3 mm de alto y no tiene frente, así que puede dejarse en cualquier posición. El logo, calado sobre sus cuatro colores, es el botón: al apretarlo baja 0,45 mm y un tope protege el botón del Tag. El sonido sale por la ranura que rodea el logo y por ocho agujeros de la tapa, que se abre con una moneda para cambiar la pila. Es más grande que el Tag por tres razones: para encontrarlo, porque un objeto que hay que hallar para silenciarlo no puede quedar tapado sobre una mesa; para controlarlo, porque una persona de la prueba nunca encontró el botón del Tag y un botón del tamaño del logo se ve y se siente, y para fabricarlo, porque sus detalles necesitan espacio para imprimirse. El modelo está listo para imprimirse en 3D, en cinco piezas y sin soportes; como solo una pieza depende de la placa, podría recibir otros localizadores.

**Figura 19**

*Relevo, con su carcasa propia y la placa del Tag adentro*

![a. Relevo armado, de 46 mm de diámetro](../06_desarrollo_y_factibilidad/testigo-impresion-3d/vistas/testigo-heroe.png) ![b. Cinco piezas, con la placa y la pila del Tag](../06_desarrollo_y_factibilidad/testigo-impresion-3d/vistas/testigo-explosion.png) ![c. Corte](../06_desarrollo_y_factibilidad/testigo-impresion-3d/vistas/testigo-corte.png)

*Nota.* Elaboración propia: modelo 3D hecho con ayuda de Claude Code, a partir de las especificaciones del autor. Las medidas de la placa del Tag son estimadas hasta medirla.

## Señal

La señal es un sonido porque debe alcanzar a quien mira una pantalla, por ejemplo desde otra habitación: una luz o una imagen piden mirar, y la persona está mirando otra cosa. En las entrevistas, las personas imaginaban señales visuales; el sonido se eligió porque alcanza a quien está mirando la pantalla, y por eso se diseñó breve y amable. Dura unos 30 segundos y termina sola o se silencia: tiene más presencia que una notificación y es más amable que una alarma. En el teléfono, Relevo suena con un tono propio: dos golpes de un timbre que bajan de tono y se repiten, más suaves al comienzo; en el Tag suena su pitido de fábrica. Cada rasgo tiene un fundamento: un sonido que desciende y es más grave se percibe menos urgente (Edworthy et al., 1991), menos repeticiones bajan la urgencia (Hellier et al., 1993) y un timbre con muchas frecuencias a la vez ayuda a saber de dónde viene (Middlebrooks y Green, 1991). En la encuesta, 41 de 53 personas prefirieron un sonido de 15 segundos o menos; la duración se mantuvo para la prueba y puede acortarse si el uso lo pide.

## Privacidad y datos

Relevo guarda en el teléfono lo que la persona prepara y sus respuestas, y, con su consentimiento, envía una copia identificada con un código en lugar del nombre. La notificación de la pantalla bloqueada no muestra la actividad, y una sección, «Qué no vemos», explica lo que la aplicación no registra. La persona puede retirar su consentimiento y borrar sus datos desde la aplicación. Responder a la señal siempre es opcional, y el aviso tras una semana sin abrir la aplicación viene desactivado por defecto.


## Iteraciones

En el prototipo, cada cambio respondió a algo aprendido al desarrollarlo o al usarlo (Tabla 2). Las primeras vueltas resolvieron el recorrido antes de tener un objeto; las de octubre respondieron a lo que contaron las personas de la prueba.

**Tabla 2**

*Iteraciones del prototipo*

| Fecha (2026) | Cambio | Motivo |
| --- | --- | --- |
| 21–24 de septiembre | Preparar un relevo, contar el tiempo de una o varias aplicaciones y sonar en un parlante o en el teléfono. | El recorrido podía probarse antes de tener un objeto propio. |
| 25 de septiembre | Una señal de unos 30 segundos que termina sola, y preguntas después de cada señal. | Una señal que no se detiene insiste, y una de 3 segundos no se oiría. |
| 27 de septiembre | Las pautas de diseño de Apple como referencia visual. | Una interfaz bien diseñada, expresiva y fácil, sin sobrediseñar ni sobreexplicar. |
| 30 de septiembre | Activación automática de un relevo, de forma opcional. | Preparar un relevo cada vez añadía esfuerzo. |
| 5 de octubre | Sonar en un localizador Bluetooth. | Se buscaba un objeto barato y ya fabricado. |
| 6–7 de octubre | Opciones de un toque para cómo y dónde empezar. | Escribir añadía esfuerzo extra. |
| 7 de octubre | Prueba de sonido con confirmación, y el Tag como salida. | Que el Tag reciba la orden no asegura que haya sonado. |
| 9 de octubre | Editar un relevo activo. | Una persona de la prueba pidió corregirlo sin borrarlo. |
| 12 de octubre | Identidad visual nueva en toda la interfaz. | Fundamentos del diseño de la aplicación. |
| 14 de octubre | El Tag se calla con confirmación y muestra la carga de su pila. | Una persona contó que el Tag siguió sonando después de la prueba de sonido, y pensó que fallaba la pila. |
| 17 de octubre | Relevo espera más a un Tag que responde lento. | Después de horas sin uso, el Tag sonaba lento y sin parar. |
| 20 de octubre | Una semana con la señal solo en el teléfono. | Hacía falta comparar el objeto con el teléfono. |

*Nota.* Elaboración propia. El detalle de cada cambio está en el Anexo G.

# 12. Factibilidad y límites

## Tecnología

Relevo funciona en teléfonos Android porque ese sistema permite las dos cosas que necesita: saber cuánto tiempo se usan otras aplicaciones, con un permiso que la persona concede en los ajustes, y comunicarse por Bluetooth con un objeto cercano (Google, 2026a, 2026b). El iPhone se descartó en esta etapa, porque allí consultar el uso de otras aplicaciones exige una autorización especial de Apple (Apple, s. f.-a) y trabajar en los dos sistemas habría duplicado el desarrollo. Entre el teléfono y el objeto solo viajan dos órdenes, sonar y callar: lo que la persona escribe se queda en el teléfono. La aplicación se instala como archivo, sin pasar por una tienda, y los datos de la prueba caben en el plan gratuito del servicio que los guarda (Supabase, s. f.), de modo que la escala de esta etapa no exige infraestructura propia.

## Fabricación, mantenimiento y costos

El prototipo no exigió fabricar nada: el Tag es un producto terminado, y su único mantenimiento es cambiar la pila de botón, que según los vendedores dura entre 2 y 8 meses. Relevo, el objeto propio, está modelado en cinco piezas que se imprimen en 3D en PLA, sin soportes, en unos 32 minutos y con menos de 15 g de plástico; su forma se genera a partir de medidas, así que basta cambiar una para ajustarlo a otra placa. La Tabla 3 resume lo que costó el prototipo, sin contar el trabajo del autor.

**Tabla 3**

*Presupuesto del prototipo académico*

| Ítem | Valor (CLP) | Detalle |
| --- | --- | --- |
| Tag con pila de botón | 10 990 | Una unidad, con envío. |
| Teléfono Android | Sin costo | Cada persona usó el suyo. |
| Base de datos de la aplicación | Sin costo | Plan gratuito de Supabase (Supabase, s. f.). |
| Herramientas de inteligencia artificial | Unos 171 000 | Cinco meses de ChatGPT Plus y tres de Claude Pro (Anthropic, s. f.; OpenAI, s. f.). |
| Total desembolsado | Unos 182 000 | — |

*Nota.* CLP = pesos chilenos. Las suscripciones se calcularon al dólar del 27 de octubre de 2026 (Mindicador, 2026). El trabajo del autor, unas 186 horas, equivale a entre 1 070 000 y 1 577 000 pesos según el ingreso de quienes se titulan de Diseño en Chile (Ministerio de Educación, s. f.).

## Del prototipo al producto

El proyecto puede crecer en tres etapas, y cada una empieza solo si la anterior entrega evidencia (Figura 20). Un piloto, en seis hogares y con Relevo impreso, mostraría si sonar desde el lugar de la actividad aporta. El producto, por último, podría abrirse en dos líneas que quedan como ideas por explorar: Relevo Home, para dejar en la casa junto al primer paso de una actividad, y Relevo Go, para llevar consigo. Ambas podrían funcionar con localizadores de otras marcas, de modo que la persona use el que ya tiene, siempre que respondan a la orden estándar de alerta: es un camino que no obliga a fabricar electrónica, aunque depende de modelos que varían entre fabricantes (Gembali, 2023, p. 53).

El piloto es la cifra que decide el paso siguiente. Cada hogar necesita un localizador, una pila de repuesto y una carcasa impresa, entre 10 100 y 12 150 pesos, y los seis hogares, entre 60 500 y 72 900. La carcasa casi no cuesta material: lo que se paga es el trabajo de impresión, y por eso conviene imprimir las seis de una vez, repartiendo el mínimo que cobra un servicio nacional por trabajo (Rabbit Hole, s. f.). Un producto, en cambio, exigiría cotizar molde, ensamblaje y ensayos, que solo se justifican con volumen.

**Figura 20**

*Etapas del proyecto*

[FIGURA POR INSERTAR: esquema de etapas: Prototipo académico | Ahora | Tag comprado y aplicación propia, Unos 182 000 pesos y el trabajo del autor, Tres personas en sus hogares; Piloto | Si la prueba lo justifica | Seis hogares con Relevo impreso, Entre 10 100 y 12 150 pesos por hogar, Revisión de accesibilidad y de protección de datos; Producto | Si el piloto cumple sus metas | Relevo Home y Relevo Go, Localizadores de otras marcas, Costos de producción por cotizar]

*Nota.* Elaboración propia. El costo del piloto incluye el localizador, una pila de repuesto y la carcasa impresa en un servicio nacional (MCI Electronics, s. f.; Rabbit Hole, s. f.).

## Actores del proyecto

El proyecto lo conduce el autor, con la guía de los profesores Sergio Majluf y Simón Gallardo. Las tres personas de la prueba aportaron su uso y sus comentarios, que cambiaron el diseño durante la prueba. Un comercio aportó el Tag, y los datos se guardan en un servicio externo. Un piloto sumaría un servicio de impresión 3D y una revisión especializada en accesibilidad y en protección de datos (Figura 20); un producto, a quien fabrique y distribuya el objeto. El proyecto también toma prestados saberes de otras disciplinas —la psicología de la memoria, la acústica y la electrónica de consumo—, y una etapa siguiente debería consultarlos con especialistas de cada una.

## Seguridad y alcance

La pila de botón puede llegar a ser peligrosa si se traga: por eso la tapa de Relevo se abre con una moneda u objeto similar. El proyecto se centra en el ocio digital cotidiano de personas adultas que quieren recordar algo que eligieron hacer; la adicción, el tratamiento clínico y el control parental pertenecen a otros campos.

# 13. Plan de desarrollo y validación

Lo diseñado se puso a prueba en el uso real: tres personas usaron Relevo en sus hogares durante un mes. La prueba usó el Tag, un objeto comercial, porque lo que se quería observar era la relación entre la señal, el lugar y lo que la persona quería hacer, no la forma del objeto.

## Procedimiento de la prueba

La prueba comenzó el 7 de octubre de 2026 (Figura 21). Cada persona aceptó el consentimiento en la aplicación, preparó su primer relevo y dejó el Tag junto al primer paso de una actividad que quería hacer. Durante dos semanas usaron Relevo a su gusto, cuando quisieron, y cada una fijó su propio límite; las tres completaron esas dos semanas. Tras cada señal, la aplicación preguntó si supieron qué querían hacer antes de leerlo en la pantalla, si recordaron cómo empezar y qué decidieron. Del 21 de octubre al 8 de noviembre no usaron el Tag: la señal llegó solo como una notificación en el teléfono, para comparar ambos soportes, y la aplicación preguntó además si notaron el aviso. La prueba cierra con una entrevista a cada persona. El consentimiento y las preguntas de la aplicación están en el Anexo I.

**Figura 21**

*Prueba en los hogares*

[FIGURA POR INSERTAR: línea de tiempo de la prueba aplicada: 7 de octubre | Inicio | Cada persona acepta el consentimiento, prepara su primer relevo y deja el Tag junto a su primer paso; Semanas 1 y 2 | Con el Tag | Cada persona usa Relevo cuando quiere y responde una serie de preguntas tras cada señal; 21 de octubre al 8 de noviembre | Con el teléfono | Sin el Tag: la señal llega como una notificación; Noviembre | Cierre | Entrevista con cada persona]

*Nota.* Elaboración propia.

## Registro y cuidado de los datos

La aplicación registró cada relevo —cuándo se activó, si sonó y cómo se calló— y las respuestas de cada persona. Esas preguntas completan el registro automático, que muestra qué hizo la persona, pero no por qué (Nielsen, 1993, p. 221). Una señal que falló por un problema de conexión o del objeto no se cuenta, y con tres personas el análisis debe ser por caso y en recuentos.

Para dar el ciclo por logrado, el Tag debía sonar cuando correspondía, la persona debía saber qué quería hacer al oír la señal, sin leer la pantalla, y debía seguir usando Relevo durante las dos semanas.

Las tres personas son mayores de edad, y su participación fue voluntaria y sin pago. Las tres personas podían omitir preguntas, silenciar la señal o dejar la prueba sin dar razones. El consentimiento, en la aplicación, explica el propósito académico, los datos que se registran, la molestia que el sonido puede causar y cómo retirarse. Los datos se guardan en la base de datos que recopila la aplicación con un código en lugar del nombre, aunque no son anónimos, porque actividades y horarios podrían identificar a alguien. Se tratan según la ley chilena de protección de datos (Ley 19628, 1999; Ley 21719, 2024) y se eliminan cuando la persona lo pide o, a más tardar, el 30 de diciembre de 2026.

## Resultados

Durante las semanas con el Tag, el ciclo completo funcionó en los tres hogares. Activaron 31 relevos, todos con el Tag, y siete se eliminaron o editaron antes de sonar. De los 24 que alcanzaron su límite, el Tag sonó en 23 (Figura 22). Hubo 21 respuestas posteriores a una señal, siete de cada persona: en las 21, la persona recordó cómo empezar su actividad; en 19 supo qué quería hacer antes de leerlo en la pantalla, y en 2, a medias.

**Figura 22**

*Resultados de los 24 relevos con el Tag*

[FIGURA POR INSERTAR: cuatro datos en tarjetas: 23 de 24, ciclos completados en que sonó el Tag; 19 de 21, respuestas en que la persona supo qué quería hacer antes de leerlo, y 2 a medias; 21 de 21, respuestas en que recordó el primer paso; 10 de 21, respuestas en que declaró haber empezado la actividad]

*Nota.* Las tres personas, del 8 al 19 de octubre de 2026. Recuentos de los registros de la aplicación.

Con tres personas, el detalle de cada caso dice más que cifras en conjunto (Figura 23). Cada una repitió sus actividades en un mismo lugar, con sus propias aplicaciones y su propio límite. Las personas empezaron la actividad en 10 respuestas, la dejaron para después en 9 y cambiaron de idea en 2, pero la mitad de los comienzos corresponde a una sola persona: la primera empezó en cinco de sus siete respuestas; la segunda, en tres, y la tercera, en dos. Como las tres respondieron el mismo número de veces, la diferencia está en lo que cada una hizo, no en cuánto participó. De las dos respuestas «a medias», una es de la primera persona. El sonido les pareció bueno en 10 respuestas, neutro en 9 y malo en 2, y las dos malas no son de la primera persona. La señal se calló desde el teléfono en nueve ciclos y con el botón del Tag en cinco; sonó completa en siete y quedó interrumpida en dos.

Lo que hicieron las tres personas matiza lo que se había dicho en las entrevistas y la encuesta (Figura 5). En las entrevistas nadie pidió una señal sonora, y en la encuesta 41 de 53 personas prefirieron un sonido de 15 segundos o menos. En la prueba, con una señal de unos 30 segundos, el sonido les pareció bueno o neutro en 19 de 21 respuestas, y en 14 de los 23 ciclos que sonaron lo callaron antes de que terminara, lo que sugiere que una señal más breve bastaría. Las tres condiciones para dar el ciclo por logrado se cumplieron, y los fallos técnicos del objeto comprado se corrigieron durante la prueba.

Leídos contra los criterios del capítulo 9, los resultados muestran qué decisiones funcionaron. El primer paso (criterio 2) sirvió de ancla: en las 21 respuestas, la persona recordó cómo empezar. El lugar y el sonido (criterio 8) llevaron el mensaje sin texto: en 19 respuestas, la persona supo qué quería hacer antes de mirar la pantalla, como anticipaba la idea de una señal que no necesita contener el mensaje si su relación con la intención se comprende (Norman, 1988/2002, p. 73). La decisión quedó abierta (criterio 4): las tres respuestas se usaron. Y la preparación siguió siendo liviana (criterio 6): de 31 relevos, siete se editaron o eliminaron antes de sonar, con la edición que se sumó el 9 de octubre a pedido de una persona.

**Figura 23**

*Decisión de cada persona después de la señal*

[FIGURA POR INSERTAR: resultados por persona: Primera persona | Estudiar, ordenar su pieza o dibujar · Tag en su escritorio · 15 minutos de Instagram, X o YouTube · 7 ciclos | 7 | 5; Segunda persona | Tocar guitarra · Tag junto a la guitarra · 45 y luego 35 minutos de Instagram, YouTube o Reddit · 8 ciclos | 7 | 3; Tercera persona | Dibujar en su croquera · Tag en su escritorio · 25 minutos de TikTok · 9 ciclos | 7 | 2]

*Nota.* Elaboración propia, a partir de las respuestas del 8 al 19 de octubre de 2026. Un punto por respuesta posterior a una señal.

Dos hallazgos orientan el diseño. El primero es que la señal pertenece al lugar de la actividad: el único relevo que no sonó ocurrió fuera de casa, lejos del Tag. El segundo es que recordar no obliga a empezar, porque una señal lleva a actuar solo si coincide con la motivación y la capacidad del momento (Fogg, 2009, p. 1; Figura 24). Relevo actúa sobre la facilidad, porque deja la señal junto a un primer paso concreto, y no sobre la motivación: como pide el criterio 4, la señal devuelve la intención y la decisión sigue siendo de la persona.

**Figura 24**

*Recordar no basta para empezar*

[FIGURA POR INSERTAR: matriz de dos por dos: Motivación | Baja | Alta; Facilidad para empezar | Difícil | Fácil; Mucha motivación y comienzo difícil | Quiere hacerlo, pero el primer paso cuesta; Mucha motivación y comienzo fácil | La señal basta para empezar; Poca motivación y comienzo difícil | La señal recuerda, pero no lleva a empezar; Poca motivación y comienzo fácil | Puede empezar o dejarlo para después]

*Nota.* Elaboración propia a partir de Fogg (2009).

Las personas también dijeron aspectos a mejorar en la aplicación. La primera pidió corregir un relevo sin borrarlo: «podrían implementar que se pueda actualizar o editar las opciones que uno ya eligió… así no tenemos que borrarlo y crearlo de nuevo». La segunda encontró el pitido demasiado fuerte, como una alarma, y juzgó largo el límite de 45 minutos, porque al sonar ya estaba inmersa en un video. La tercera contó que la señal le sirvió cuando estaba en el escritorio, pero que de noche la oye desde la cama y no se levanta.

Del 21 de octubre al 8 de noviembre, la señal llegó solo como una notificación en el teléfono. Las tres personas activaron 27 relevos y eliminaron dos antes de sonar; la notificación llegó en 24, y hubo 21 respuestas: diez de la primera persona, siete de la segunda y cuatro de la tercera (Tabla 4). En las 21, la persona recordó cómo empezar y supo qué quería hacer, aunque con el teléfono el aviso ya trae escrita la actividad. Empezó en 13, la dejó para después en 7 y cambió de idea en 1. Empezar no dependió del soporte: la primera persona empezó en 5 de 7 respuestas con el Tag y en 7 de 10 con el teléfono; la segunda, en 3 de 7 y en 4 de 7, y la tercera, en 2 de 7 y en 2 de 4.

Con el teléfono, recordar fue igual de fácil, pero notar la señal no. En 10 de las 21 respuestas, la persona notó el aviso tarde o no lo notó, y dos de las tres tardaron más en responder: la mediana pasó de 15 a 63 segundos en la segunda persona y de 22 a 69 en la tercera. La segunda persona contó que, con el aviso en el teléfono, ya no molestaba con el ruido del Tag a quien vivía con ella, pero que era más fácil pasarlo de largo. La tercera usó menos Relevo que con el Tag —cinco relevos frente a nueve— y contó que una semana casi no lo abrió.

**Tabla 4**

*Resultados con el Tag y con el teléfono, por persona*

| Persona | Soporte | Relevos | Sonaron | Respuestas | Supo qué quería hacer | Recordó cómo empezar | Empezó / después / cambió de idea | Notó el aviso enseguida / tarde / no | Segundos hasta responder (mediana) |
| --- | --- | ---: | ---: | ---: | --- | ---: | --- | --- | ---: |
| Primera | Tag | 7 | 7 | 7 | 6, y 1 a medias | 7 | 5 / 2 / 0 | — | 7 |
| Primera | Teléfono | 12 | 11 | 10 | 10 | 10 | 7 / 3 / 0 | 8 / 1 / 1 | 4 |
| Segunda | Tag | 8 | 8 | 7 | 7 | 7 | 3 / 3 / 1 | — | 15 |
| Segunda | Teléfono | 8 | 8 | 7 | 7 | 7 | 4 / 2 / 1 | 3 / 4 / 0 | 63 |
| Tercera | Tag | 9 | 8 | 7 | 6, y 1 a medias | 7 | 2 / 4 / 1 | — | 22 |
| Tercera | Teléfono | 5 | 5 | 4 | 4 | 4 | 2 / 2 / 0 | 0 / 2 / 2 | 69 |

*Nota.* Elaboración propia a partir de los registros de la aplicación. Con el Tag, del 8 al 19 de octubre de 2026; con el teléfono, del 21 de octubre al 8 de noviembre. No se cuentan los relevos eliminados antes de sonar. La pregunta sobre el aviso se hizo solo con el teléfono.

Leídos contra el tercer supuesto de la hipótesis —que el objeto ayude al menos tanto como una notificación, sin más molestia—, los resultados lo sostienen en parte. Con el Tag recordaron tanto como con el teléfono, y dos de las tres personas respondieron antes; pero su sonido molestó más a quienes estaban cerca. Como la etapa con el teléfono vino después de las semanas con el Tag, las personas ya sabían qué significaba la señal: la comparación describe lo que vivió cada una, no un efecto del soporte.

## Alcance de esta etapa

Esta etapa validó el uso real del ciclo con tres personas durante un mes: el ciclo funciona en un hogar, la señal se entiende, los fallos que aparecieron se corrigieron durante la prueba y la comparación con el teléfono mostró qué aporta el objeto. Lo que recordaron se conoce por sus propias respuestas, dadas justo después de cada señal.

## Iterar con los resultados

Lo que mostró la prueba se convierte en cambios, y conviene separar los problemas técnicos —la mayoría, del objeto comprado— de los de uso.

Los técnicos se corrigieron durante la prueba; los de uso definen la iteración siguiente, junto con la identidad visual nueva. La Tabla 5 reúne cada hallazgo, su cambio y su estado, junto con lo que mostró la revisión con los profesores.

**Tabla 5**

*Hallazgos de la prueba y de las revisiones, y cambios para la iteración*

| Hallazgo | Tipo | Cambio | Estado |
| --- | --- | --- | --- |
| El Tag siguió sonando tras la prueba de sonido y, más tarde, sin parar. | Técnico, del objeto comprado | Callar con confirmación. | Hecho durante la prueba |
| Tras horas sin uso, el Tag sonaba lento hasta que se le sacaba la pila. | Técnico, del objeto comprado | Esperar más a un Tag que responde lento. | Hecho durante la prueba |
| Fuera de casa, el Tag no sonó. | Técnico | Buscar el Tag antes de que termine el tiempo y, si no responde, sonar en el teléfono. | Decidido; por implementar |
| Corregir un relevo exigía borrarlo y crearlo de nuevo. | Uso | Editar un relevo activo. | Hecho durante la prueba |
| El botón del Tag no se encuentra ni se siente: la señal se calló con él en 5 ciclos y desde el teléfono en 9. | Uso, del objeto comprado | Logo de Relevo como botón. | Diseñado en Relevo |
| El pitido sonó como una alarma. | Uso, del objeto comprado | Volumen regulable en Relevo. | Por probar |
| La primera vez es larga: tiene once pantallas. | Uso | Partirla en una parte al empezar y el resto después, o empezar con plantillas. | Por implementar |
| La pantalla del relevo muestra demasiada información. | Uso | Dejar la actividad, el tiempo que falta y una sola acción. | Por implementar |
| «Elige tu emoji» no pregunta por la persona. | Escritura | «¿Con qué te identificas?» o una pregunta similar. | Por implementar |
| Un límite de 45 minutos resultó largo: al sonar, la persona ya estaba inmersa en un video. | Uso | Proponer un límite breve al empezar y sugerir revisarlo tras las primeras señales. | Propuesta |
| De noche, la señal se oye desde la cama y no lleva a levantarse. | Uso | Permitir que la persona excluya horas del día. | Propuesta |
| Con el teléfono, el aviso se notó tarde o no se notó en 10 de 21 respuestas; el pitido del Tag, en cambio, molestó a quienes estaban cerca. | Uso | Mantener el objeto como señal principal y diseñar en Relevo un sonido más suave. | Propuesta |
| La respuesta fue «La dejé para después» en 9 de 21 señales. | Uso | Ofrecer, desde esa respuesta, preparar el relevo para otro momento, sin repetir la señal. | Propuesta |
| Sin el objeto, no hay cómo empezar. | Uso | «¿Tienes un Tag? No: consíguelo acá». | Por implementar |

*Nota.* Elaboración propia a partir de los registros y comentarios de las tres personas, y de la revisión con los profesores del 28 de octubre de 2026.

# 14. Conclusiones

El proyecto partió de una situación cotidiana —quedarse en el teléfono más de lo que uno quería— y la convirtió en un problema de diseño preciso: que la persona recuerde a tiempo algo que quería hacer, sin que nadie decida por ella. Con esa base tomó decisiones en todas las escalas —el sistema, el recorrido, la interfaz, la voz, la identidad y el objeto—, y cada una responde a un criterio.

El prototipo funciona en uso real: en los tres hogares, el Tag sonó en 23 de los 24 relevos que llegaron a su límite; en las 21 respuestas, la persona recordó cómo empezar, y en 19 supo qué quería hacer antes de leerlo en la pantalla. Los fallos que reportaron se corrigieron durante la prueba, y lo que mostró sobre el uso ya orienta la iteración siguiente. Así, los dos primeros objetivos —entender el problema y diseñar el sistema— se cumplieron; el cuarto, probarlo en hogares, se cumplió con tres personas durante un mes, y el tercero, la comparación con el teléfono, se cumplió del 21 de octubre al 8 de noviembre: con la notificación recordaron igual, pero la notaron tarde o no la notaron en 10 de 21 respuestas.

El avance se ve en el propio prototipo. Entre septiembre y noviembre, la propuesta pasó de un objeto donde dejar el teléfono a un sistema probado en tres hogares: doce cambios, tres de ellos a partir de lo que contaron las personas durante la prueba (Tabla 2); una identidad completa, con logo, paleta cromática, tipografía y 72 íconos propios; una aplicación que llegó a la versión 4.7.2, y un objeto propio modelado para imprimir.

La pregunta de investigación pedía condiciones, y la investigación las precisó: una ayuda debe partir de una actividad que la persona elige, unirla a un primer paso concreto, sonar cuando ella lo decidió y dejar abierta la decisión. Construido así, Relevo devolvió la intención sin decidir por nadie: cada persona decidió a su manera si empezar, dejarlo para después o cambiar de idea. Una de esas condiciones, que la señal llegue desde el lugar donde la actividad comienza, se formuló como hipótesis. La prueba sostiene su primer supuesto: al oír la señal, la persona supo qué quería hacer antes de leerlo en 19 de 21 respuestas y recordó cómo empezar en todas. El tercero se sostiene en parte: con el teléfono recordaron igual, pero el aviso se notó tarde o no se notó en 10 de 21 respuestas, y el sonido del Tag molestó más a quienes estaban cerca. El aporte del proyecto al diseño es haber convertido una tensión cotidiana en decisiones verificables —qué se recuerda, cuándo, dónde, con qué objeto y con qué opciones—, sin reducirla a una cuestión de disciplina.

## Alcances y proyecciones

El trabajo puede seguir en cinco pasos: cerrar la prueba con la entrevista a cada persona; aplicar lo que mostró; imprimir y probar Relevo, con volumen regulable; ampliar la prueba a más personas y compararla con el mismo objeto en un lugar sin relación con la actividad, y explorar Relevo Home y Relevo Go, con localizadores de otras marcas, si sonar desde el lugar mantiene su aporte. Más adelante, un hardware propio permitiría diseñar también el sonido y el control.

# Referencias

Albers, J. (2013). *Interaction of color* (4.ª ed.). Yale University Press.

Android Open Source Project. (s. f.). *TypeScaleTokens.kt* [Código fuente]. AndroidX, Compose Material 3. Recuperado el 2 de noviembre de 2026, de https://github.com/androidx/androidx/blob/androidx-main/compose/material3/material3/src/commonMain/kotlin/androidx/compose/material3/tokens/TypeScaleTokens.kt

Anthropic. (s. f.). *Planes y precios*. Claude. Recuperado el 27 de octubre de 2026, de https://claude.com/es/pricing

Apple. (s. f.-a). *Family Controls App and Website Usage*. Apple Developer Documentation. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/bundleresources/entitlements/com.apple.developer.family-controls.app-and-website-usage

Apple. (s. f.-b). *Set up Screen Time for yourself on iPhone*. Apple Support. Recuperado el 25 de septiembre de 2026, de https://support.apple.com/en-ie/guide/iphone/iphbfa595995/ios

Apple. (s. f.-c). *Typography*. Human Interface Guidelines. Recuperado el 2 de noviembre de 2026, de https://developer.apple.com/design/human-interface-guidelines/typography

Apple. (2024, 8 de febrero). *Q&A with the Apple UX writing team*. Apple Developer. https://developer.apple.com/news/?id=5mcfho5g

Apple. (2025a). *Get to know the new design system* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/356/

Apple. (2025b, 16 de diciembre). *Writing*. Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/writing

Brick LLC. (s. f.-a). *Brick — Take back control of your screen time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/

Brick LLC. (s. f.-b). *Brick Zone*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/pages/brick-zone

Chiu, G. y Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

de Segovia Vicente, D., Van Gaeveren, K., Murphy, S. L. y Vanden Abeele, M. M. P. (2024). Does mindless scrolling hamper well-being? Combining ESM and log-data to examine the link between mindless scrolling, goal conflict, guilt, and daily well-being. *Journal of Computer-Mediated Communication, 29*(1), Artículo zmad056. https://doi.org/10.1093/jcmc/zmad056

Edworthy, J., Loxley, S. y Dennis, I. (1991). Improving auditory warning design: Relationship between warning sound parameters and perceived urgency. *Human Factors, 33*(2), 205–231. https://doi.org/10.1177/001872089103300206

Elliot, A. J. y Maier, M. A. (2014). Color psychology: Effects of perceiving color on psychological functioning in humans. *Annual Review of Psychology, 65*, 95–120. https://doi.org/10.1146/annurev-psych-010213-115035

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Fogg, B. J. (2009). A behavior model for persuasive design. En *Proceedings of the 4th International Conference on Persuasive Technology* (Artículo 40). Association for Computing Machinery. https://doi.org/10.1145/1541948.1541999

Gembali, S. (2023). *Phygital transformation: Adding physical devices to digital products to improve the user experience* [Tesis de maestría, Massachusetts Institute of Technology]. DSpace@MIT. https://hdl.handle.net/1721.1/151254

Goldsmith, L. J. (2021). Using framework analysis in applied qualitative research. *The Qualitative Report, 26*(6), 2061–2076. https://doi.org/10.46743/2160-3715/2021.5011

Gollwitzer, P. M. y Sheeran, P. (2006). Implementation intentions and goal achievement: A meta-analysis of effects and processes. *Advances in Experimental Social Psychology, 38*, 69–119. https://doi.org/10.1016/S0065-2601(06)38002-1

Google. (s. f.). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Pixel Phone Help. Recuperado el 11 de octubre de 2026, de https://support.google.com/pixelphone/answer/9137850?hl=en

Google. (2026a, 26 de febrero). *Communicate in the background*. Android Developers. https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (2026b, 28 de agosto). *UsageStatsManager*. Android Developers. https://developer.android.com/reference/android/app/usage/UsageStatsManager

Grüning, D. J., Riedel, F. y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), Artículo e2213114120. https://doi.org/10.1073/pnas.2213114120

Guynn, M. J., McDaniel, M. A. y Einstein, G. O. (1998). Prospective memory: When reminders fail. *Memory & Cognition, 26*(2), 287–298. https://doi.org/10.3758/BF03201140

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A. y Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (Artículo 243). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hellier, E. J., Edworthy, J. y Dennis, I. (1993). Improving auditory warning design: Quantifying and predicting the effects of different warning parameters on perceived urgency. *Human Factors, 35*(4), 693–706. https://doi.org/10.1177/001872089303500408

Hermann, M., Mahler, T., de Melo, G. y Weber, M. (2007). The Tangible Reminder. En *3rd IET International Conference on Intelligent Environments (IE 07)* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

International Organization for Standardization. (2011). *Graphical symbols — Safety colours and safety signs — Part 1: Design principles for safety signs and safety markings* (Norma ISO n.º 3864-1:2011). https://www.iso.org/standard/51021.html

Ishii, H. y Ullmer, B. (1997). Tangible bits: Towards seamless interfaces between people, bits and atoms. En *Proceedings of the ACM SIGCHI Conference on Human Factors in Computing Systems* (pp. 234–241). Association for Computing Machinery. https://doi.org/10.1145/258549.258715

Jiang, Y., Gorn, G. J., Galli, M. y Chattopadhyay, A. (2016). Does your company have the right logo? How and why circular- and angular-logo shapes influence brand attribute judgments. *Journal of Consumer Research, 42*(5), 709–726. https://doi.org/10.1093/jcr/ucv049

Jonauskaite, D., Epicoco, D., Al-Rasheed, A. S., Aruta, J. J. B. R., Bogushevskaya, V., Brederoo, S. G., Corona, V., Fomins, S., Gizdic, A., Griber, Y. A., Havelka, J., Hirnstein, M., John, G., Jopp, D. S., Karlsson, B., Konstantinou, N., Laurent, É., Marquardt, L., Mefoh, P. C., … Mohr, C. (2024). A comparative analysis of colour–emotion associations in 16–88-year-old adults from 31 countries. *British Journal of Psychology, 115*(2), 275–305. https://doi.org/10.1111/bjop.12687

Keppel, J., Strauss, M., Haliburton, L., Weingärtner, H., Dominiak, J., Faltaous, S., Gruenefeld, U., Mayer, S., Woźniak, P. W. y Schneegass, S. (2025). Situated artifacts amplify engagement in physical activity. En *Proceedings of the 2025 ACM Designing Interactive Systems Conference* (pp. 2959–2974). Association for Computing Machinery. https://doi.org/10.1145/3715336.3735690

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Kitchen Safe. (s. f.). *kSafe by Kitchen Safe: The time lock safe*. Recuperado el 25 de septiembre de 2026, de https://www.thekitchensafe.com/

Kolko, J. (2011). *Exposing the magic of design: A practitioner’s guide to the methods and theory of synthesis*. Oxford University Press.

Ley 19628. (1999, 28 de agosto). Sobre protección de la vida privada. Biblioteca del Congreso Nacional de Chile. https://www.bcn.cl/leychile/navegar?idNorma=141599

Ley 21719. (2024, 13 de diciembre). Regula la protección y el tratamiento de los datos personales y crea la Agencia de Protección de Datos Personales. Biblioteca del Congreso Nacional de Chile. https://www.bcn.cl/leychile/navegar?idNorma=1209272

Lukoff, K., Yu, C., Kientz, J. y Hiniker, A. (2018). What makes smartphone use meaningful or meaningless? *Proceedings of the ACM on Interactive, Mobile, Wearable and Ubiquitous Technologies, 2*(1), Artículo 22. https://doi.org/10.1145/3191754

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M. y Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (Artículo 131). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

McDaniel, M. A. y Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*(7), S127–S144. https://doi.org/10.1002/acp.775

MCI Electronics. (s. f.). *Pila botón CR2032 de lithium para reloj*. Recuperado el 27 de octubre de 2026, de https://mcielectronics.cl/shop/product/pila-boton-cr2032-de-lithium-para-reloj-9838/

Meier, A. y Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Microsoft. (2021). *Spanish (Neutral) style guide*. https://download.microsoft.com/download/4/3/1/431d9836-40dc-4f2b-aafc-def5c7b5d0f3/spa-neu-StyleGuide.pdf

Middlebrooks, J. C. y Green, D. M. (1991). Sound localization by human listeners. *Annual Review of Psychology, 42*, 135–159. https://doi.org/10.1146/annurev.ps.42.020191.001031

Miller, C. H., Lane, L. T., Deatrick, L. M., Young, A. M. y Potts, K. A. (2007). Psychological reactance and promotional health messages: The effects of controlling language, lexical concreteness, and the restoration of freedom. *Human Communication Research, 33*(2), 219–240. https://doi.org/10.1111/j.1468-2958.2007.00297.x

Mindicador. (2026). *Dólar observado* [Serie del Banco Central de Chile]. Recuperado el 27 de octubre de 2026, de https://mindicador.cl/api/dolar

Ministerio de Educación. (s. f.). *Estadísticas por carrera: Diseño*. Mi Futuro, Servicio de Información de Educación Superior. Recuperado el 27 de octubre de 2026, de https://www.mifuturo.cl/buscador-de-estadisticas-por-carrera/

Monge Roffarello, A. y De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53. https://doi.org/10.1145/3571810

Montag, C., Lachmann, B., Herrlich, M. y Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), Artículo 2612. https://doi.org/10.3390/ijerph16142612

Nielsen, J. (1993). *Usability engineering*. Academic Press.

Norman, D. A. (2002). *The design of everyday things*. Basic Books. (Obra original publicada en 1988)

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

OpenAI. (s. f.). *Planes y precios*. ChatGPT. Recuperado el 27 de octubre de 2026, de https://chatgpt.com/es-419/pricing/

O’Rear, A. E. y Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

Peña-Albert, A. K., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C. y Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, Artículo e85349. https://doi.org/10.2196/85349

Rabbit Hole. (s. f.). *Impresión 3D en Chile: resina SLA y FDM*. Recuperado el 27 de octubre de 2026, de https://rabbithole.cl/

Radtke, T., Apel, T., Schenkel, K., Keller, J. y von Lindern, E. (2022). Digital detox: An effective solution in the smartphone era? A systematic literature review. *Mobile Media & Communication, 10*(2), 190–215. https://doi.org/10.1177/20501579211028647

Risko, E. F. y Gilbert, S. J. (2016). Cognitive offloading. *Trends in Cognitive Sciences, 20*(9), 676–688. https://doi.org/10.1016/j.tics.2016.07.002

Riveros Oltra, J. (2023). *BetterHumans: explorando la gamificación y la formación de hábitos en la retención de usuarios: un estudio de caso de Betterfly* [Memoria de título, Universidad de Chile]. Repositorio Académico de la Universidad de Chile. https://doi.org/10.58011/khxf-cq52

Ryan, R. M. y Deci, E. L. (2000). Self-determination theory and the facilitation of intrinsic motivation, social development, and well-being. *American Psychologist, 55*(1), 68–78. https://doi.org/10.1037/0003-066X.55.1.68

Sanders, E. B.-N. y Stappers, P. J. (2012). *Convivial toolbox: Generative research for the front end of design*. BIS Publishers.

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *You know you’re scrolling too much. Take your time back*. Recuperado el 9 de noviembre de 2026, de https://screenlessapp.com/en

Silverman, J. y Barasch, A. (2023). On or off track: How (broken) streaks affect consumer decisions. *Journal of Consumer Research, 49*(6), 1095–1117. https://doi.org/10.1093/jcr/ucac029

Smit, E. S., Zeidler, C., Resnicow, K. y de Vries, H. (2019). Identifying the most autonomy-supportive message frame in digital health communication: A 2x2 between-subjects experiment. *Journal of Medical Internet Research, 21*(10), Artículo e14074. https://doi.org/10.2196/14074

Sohn, T., Li, K. A., Lee, G., Smith, I., Scott, J. y Griswold, W. G. (2005). Place-Its: A study of location-based reminders on mobile phones. En M. Beigl, S. Intille, J. Rekimoto y H. Tokuda (Eds.), *Lecture notes in computer science: Vol. 3660. UbiComp 2005: Ubiquitous computing* (pp. 232–250). Springer. https://doi.org/10.1007/11551201_14

Springer Nature. (s. f.). *AI guidance for researchers, editors and reviewers*. Recuperado el 8 de noviembre de 2026, de https://group.springernature.com/gp/group/ai/ai-guidance-for-researchers-editors-reviewers

Stapley, E., O’Keeffe, S. y Midgley, N. (2022). Developing typologies in qualitative research: The use of ideal-type analysis. *International Journal of Qualitative Methods, 21*, Artículo 16094069221100633. https://doi.org/10.1177/16094069221100633

Subsecretaría de Telecomunicaciones. (2025). *Informe final: Estudio duodécima encuesta sobre acceso, usos y usuarios de internet en Chile*. Ministerio de Transportes y Telecomunicaciones. https://www.subtel.gob.cl/wp-content/uploads/2026/02/Informe-Final-Acceso-y-Uso-Internet-2025_03.pdf

Supabase. (s. f.). *Pricing*. Recuperado el 27 de octubre de 2026, de https://supabase.com/pricing

Terzimehić, N., Haliburton, L., Greiner, P., Schmidt, A., Hussmann, H. y Mäkelä, V. (2022). MindPhone: Mindful reflection at unlock can reduce absentminded smartphone use. En *Proceedings of the 2022 ACM Designing Interactive Systems Conference* (pp. 1818–1830). Association for Computing Machinery. https://doi.org/10.1145/3532106.3533575

Tonietto, G. N., Malkoc, S. A., Reczek, R. W. y Norton, M. I. (2021). Viewing leisure as wasteful undermines enjoyment. *Journal of Experimental Social Psychology, 97*, Artículo 104198. https://doi.org/10.1016/j.jesp.2021.104198

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Venegas Álvarez, S. A. (2026). *Gratitud digitalizada: un enfoque en el diseño de aplicaciones para fomentar la gratitud a través de la gamificación narrativa* [Memoria de título, Universidad de Chile]. Repositorio Académico de la Universidad de Chile. https://repositorio.uchile.cl/handle/2250/216623

Waggoner, J., Lucky, S., Redick, S., Rizki, A. y Yu, J.-C. (2026). Going beyond digital libraries: A literature review of phygital user experience research methods. *International Journal on Digital Libraries, 27*(1), Artículo 1. https://doi.org/10.1007/s00799-025-00436-6

Weiser, M. y Brown, J. S. (1997). The coming age of calm technology. En P. J. Denning y R. M. Metcalfe (Eds.), *Beyond calculation: The next fifty years of computing* (pp. 75–85). Copernicus. https://doi.org/10.1007/978-1-4612-0685-9_6

Wilms, L. y Oberfeld, D. (2018). Color and emotion: Effects of hue, saturation, and brightness. *Psychological Research, 82*(5), 896–914. https://doi.org/10.1007/s00426-017-0880-8

World Wide Web Consortium. (2024, 12 de diciembre). *Web content accessibility guidelines (WCAG) 2.2*. https://www.w3.org/TR/2024/REC-WCAG22-20241212/

Yablonski, J. (s. f.). *Laws of UX*. Recuperado el 9 de noviembre de 2026, de https://lawsofux.com/

Zekveld, J., Bakker, S., Zijlema, A. y van den Hoven, E. (2017). Wobble: Shaping unobtrusive reminders for prospective memories in the home context. En *Proceedings of the Eleventh International Conference on Tangible, Embedded, and Embodied Interaction* (pp. 31–35). Association for Computing Machinery. https://doi.org/10.1145/3024969.3024984

Zimmerman, J., Forlizzi, J. y Evenson, S. (2007). Research through design as a method for interaction design research in HCI. En *Proceedings of the SIGCHI Conference on Human Factors in Computing Systems* (pp. 493–502). Association for Computing Machinery. https://doi.org/10.1145/1240624.1240704


# Glosario

**Activación automática.** Opción del prototipo, apagada por defecto, que repite el último ciclo cuando la persona abre una de las aplicaciones seleccionadas, con 30 minutos de pausa. Reduce el esfuerzo de preparar, pero la actividad deja de elegirse en el momento.

**Activar y desactivar.** Confirmar que un ciclo queda vigente para emitir la señal, o retirarlo antes de que suene. En el prototipo se hace desde la aplicación; el diseño original preveía confirmarlo con un control físico.

**Autonomía.** En el sentido de la teoría de la autodeterminación, actuar por voluntad propia. En términos de diseño, depende de comprender la intervención y poder aceptarla, ajustarla o rechazarla.

**Bluetooth.** Comunicación inalámbrica de corto alcance y bajo consumo. En el prototipo lleva órdenes de la aplicación al Tag, no audio.

**_Calm technology_.** Ideal de diseño según el cual una tecnología informa en segundo plano y pasa al primero solo cuando hace falta, para luego volver (Weiser y Brown, 1997). No tiene una traducción fija al español.

**Ciclo.** Periodo en que una intención y su condición de activación están vigentes. La interfaz de la aplicación lo llama «relevo».

**Conflicto entre metas.** Tensión que aparece cuando una actividad dificulta otra también valorada, sin establecer cuál debería prevalecer.

**Criterio de diseño.** Condición que una propuesta debe cumplir para responder al problema y que sirve después para evaluarla. Esta memoria formula ocho.

**Descarga cognitiva.** Recurso a una acción física, como anotar o disponer un objeto, para reducir la demanda cognitiva de una tarea (Risko y Gilbert, 2016).

**Descarga de intenciones.** Uso del entorno para dejar un aviso de una intención que se cumplirá después, como un objeto junto a la puerta (Risko y Gilbert, 2016).

**Desplazamiento infinito.** Patrón de interfaz que carga contenido nuevo a medida que la persona avanza, sin un final de página reconocible.

**Evaluación formativa.** Evaluación que busca identificar dificultades y orientar mejoras del diseño, no medir su eficacia (Nielsen, 1993).

**Fricción.** Esfuerzo adicional introducido en una interfaz, como esperar o confirmar, que puede abrir una ocasión de reconsiderar.

**Gamificación.** Uso de mecánicas propias de los juegos, como rachas, puntos y premios, en actividades que no son juegos.

**Herramienta de autocontrol digital.** Aplicación o función con la que una persona regula su propio uso de dispositivos mediante mediciones, límites, bloqueos, demoras o mensajes. También se la llama herramienta de bienestar digital.

**Intención.** Lo que la persona se propone hacer, como leer o dibujar. En esta memoria, la que quiere mantener presente mientras dura una sesión de ocio digital.

**Intención de implementación.** Plan que especifica de antemano cuándo, dónde y cómo actuar: si se presenta cierta situación, se inicia una respuesta (Gollwitzer y Sheeran, 2006).

**Interacción tangible.** Campo que estudia cómo los objetos y el espacio físico participan en la relación con la información digital. Abarca sistemas basados en la interacción corporal, la manipulación de objetos, la representación física de datos y su inserción en el espacio real (Ishii y Ullmer, 1997).

**Investigación a través del diseño.** Enfoque en que quien diseña integra resultados de investigación en un artefacto, y ese trabajo constituye un aporte (Zimmerman et al., 2007).

**Localizador Bluetooth.** Objeto pequeño y autónomo, vendido también como llavero antipérdida, que suena cuando la persona lo busca desde el teléfono. El prototipo usa uno comercial, circular, con pila de botón y un solo botón.

**Marco multiproceso.** Explicación de la memoria prospectiva según la cual una intención puede volver porque la persona vigila el entorno o porque un evento la trae de vuelta de forma espontánea. Cuando la actividad en curso absorbe la atención, lo segundo es más probable si la señal es llamativa y está fuertemente asociada a la acción (McDaniel y Einstein, 2000).

**Memoria prospectiva.** Capacidad de recordar una acción que se quiere realizar en el futuro cuando aparece la ocasión adecuada (McDaniel y Einstein, 2000).

**Método Framework.** Método de análisis cualitativo que resume el material codificado en una matriz de unidades de análisis y temas, para identificar patrones dentro de cada caso y entre casos.

**NFC (comunicación de campo cercano).** Tecnología inalámbrica de muy corto alcance. Una etiqueta NFC se lee al acercarle el teléfono.

**Ocio digital.** Actividades que una persona realiza a través de dispositivos en su tiempo disponible para descansar, entretenerse, satisfacer su curiosidad o vincularse con otros.

**_Phygital_.** Término formado por *physical* y *digital* que designa experiencias que integran lo físico y lo digital (Waggoner et al., 2026). En esta memoria nombra el tipo de sistema.

**Precompromiso.** Decisión previa que restringe deliberadamente las opciones futuras, como bloquear aplicaciones hasta volver a un objeto.

**Primer paso.** Acción breve, concreta y disponible con la que comienza una actividad, como abrir el libro o ponerse las zapatillas; la aplicación lo pregunta con «¿Cómo empiezas?». «Junto al primer paso» significa en el lugar donde ese paso se realiza.

**Racha.** Serie de tres o más repeticiones consecutivas de una conducta, que un registro muestra como intacta o rota.

**Relevo.** Sistema *phygital* propuesto en esta memoria, compuesto por una aplicación Android y un objeto físico. En la interfaz, «relevo» nombra además cada ciclo. También es el nombre del objeto propio.

**Reproducción automática.** Patrón de interfaz en que, al terminar un contenido, comienza otro sin exigir una elección nueva.

**Salida.** Medio por el que suena la señal en el prototipo: el Tag, propuesto por defecto; un parlante Bluetooth; un reloj, de forma experimental; o el propio teléfono, que sirve de comparación.

**Señal.** Término general para el estímulo con que el sistema devuelve la intención al presente. Se distingue de la notificación, que en esta memoria designa solo el aviso visual del teléfono.

**Tag.** Nombre que la aplicación da al localizador Bluetooth comercial que reemplaza a Relevo, el objeto propio, en el prototipo. Emite su propio pitido, continuo y de volumen fijo, y no representa su forma.

**Tipo ideal.** Agrupación analítica de casos semejantes que no pretende coincidir del todo con la realidad (Stapley et al., 2022). En esta memoria agrupa situaciones, no personas.

**Usuario principal y usuario límite.** Tipos ideales de situación, no de persona: en la primera, la sesión continúa sin una nueva decisión y otra cosa que la persona quería hacer deja de estar presente; en la segunda, el ocio digital conserva sentido o no existe otra intención, y no corresponde intervenir.

**WCAG (Pautas de Accesibilidad para el Contenido Web).** Recomendación del World Wide Web Consortium que fija criterios verificables de accesibilidad, como el contraste mínimo del texto o no depender solo del color.

# Anexos

- **Anexo A.** Entrevistas: la pauta de 13 preguntas, la síntesis anonimizada de las ocho entrevistas, el método, el libro de 23 códigos, el análisis por caso y los dos tipos de usuario.
- **Anexo B.** Encuesta: las 16 preguntas, el método, los recuentos de las 53 respuestas, los aportes al diseño y la codificación de cada respuesta.
- **Anexo C.** Estado del arte y referentes: la estrategia de búsqueda, una ficha por referente y los prototipos y patentes similares.
- **Anexo D.** Trazabilidad de los criterios de diseño: cada criterio con su evidencia, su aplicación en Relevo y el resultado de la prueba, y los cambios en la aplicación.
- **Anexo E.** Uso de inteligencia artificial: las herramientas, las tareas que apoyaron y el trabajo del autor.
- **Anexo F.** Estados del ciclo y *wireframes*: los 35 estados del ciclo, con sus *wireframes* de agosto, y las 39 pantallas de la aplicación.
- **Anexo G.** Prototipo Android y registro de versiones: la aplicación de la prueba, el Tag, los datos y el panel, cada versión desde la 2.7 hasta la 4.7.2, con sus pantallas, y las palabras clave con que la aplicación reconoce cada actividad.
- **Anexo H.** Identidad visual y sistema de marca: el logo, la tipografía, la iconografía y la paleta cromática, cada uno con su fundamento, y las propuestas anteriores.
- **Anexo I.** Protocolo de la prueba, consentimiento e instrumentos: la prueba aplicada, el protocolo de 21 días, el consentimiento, las preguntas de la aplicación, los instrumentos, de la sesión inicial al cierre, y los resultados por persona.
