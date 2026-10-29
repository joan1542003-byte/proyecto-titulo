Universidad Diego Portales

Facultad de Arquitectura, Arte y Diseño

Escuela de Diseño

# Relevo

Sistema *phygital* para recuperar intenciones personales durante el ocio digital

Memoria para optar al título de [CONFIRMAR: denominación oficial del título y mención, según la Escuela]

Johan Yantén [CONFIRMAR: nombre legal completo]

Profesores guía: Sergio Majluf y Simón Gallardo

Santiago, Chile

2026

# Agradecimientos

A mi familia, que hizo posible este proyecto.

A mi mamá, por estar siempre presente, por apoyarme y por darme todo lo que he necesitado para cumplir mis metas.

A mi abuela, por educarme y por enseñarme a soñar y a explorar.

A las dos, por permitir que la creatividad, el arte y la entretención fueran parte de mi vida diaria.

# Resumen

Algunas sesiones de ocio digital se prolongan sin una nueva decisión de continuar, y otra actividad también deseada deja de estar presente cuando aún es posible comenzarla. El proyecto buscó diseñar y evaluar formativamente un sistema *phygital* (físico y digital) que ayude a recuperar esa intención —volver a tenerla presente— sin bloquear el teléfono ni juzgar la decisión posterior. La investigación combinó una revisión bibliográfica, ocho entrevistas semiestructuradas analizadas con el método Framework, una encuesta de 53 respuestas y una comparación de herramientas. Los resultados indican que la duración no basta para valorar una sesión, que la mayoría de las herramientas revisadas actúa sobre el uso del teléfono y no sobre la actividad desplazada, y que no corresponde intervenir cuando el ocio digital conserva sentido. De ellos se derivaron ocho criterios de diseño y Relevo: una aplicación Android y un objeto, el testigo, que se deja junto al primer paso de lo que la persona quiere hacer —por ejemplo, junto al libro— y suena al cumplirse una condición definida por la persona. Para probar la relación entre señal y lugar antes de fabricar el testigo, el prototipo hace sonar un localizador Bluetooth comercial. Tres personas lo usan en su hogar desde el 7 de octubre de 2026; hasta el 19, el ciclo completo funcionó en los tres hogares: el localizador sonó en 23 de 24 ciclos y, en 19 de 21 respuestas, la persona supo qué quería hacer antes de leerlo en la pantalla; en las 21 recordó cómo empezar, y en 10 decidió empezar. Esta etapa validó el ciclo; la comparación con un lugar neutro y con el teléfono, ya implementada, es el paso siguiente para contrastar la hipótesis. El proyecto aporta, además, un prototipo funcional y un procedimiento para comparar señales situadas con sus alternativas antes de fabricar un objeto.

*Palabras clave:* ocio digital, memoria prospectiva, diseño *phygital*

# Abstract

Some digital leisure sessions go on without a new decision to continue, and another activity, also desired, fades from view while it can still be started. The project sought to design and formatively evaluate a phygital (physical and digital) system that helps people retrieve that intention—bring it back to mind—without blocking the phone or judging the decision that follows. The research combined a literature review, eight semistructured interviews analyzed with the Framework method, a survey with 53 responses, and a comparison of tools. The results indicate that duration alone is not enough to assess a session, that most of the tools reviewed act on phone use, not on the displaced activity, and that no intervention is called for when digital leisure remains meaningful. Eight design criteria were derived from these results, along with Relevo: an Android application and an object, the *testigo*, left next to the first step of the chosen activity (for example, next to a book), which sounds once a condition defined by the person is met. To test the relationship between signal and place before building the *testigo*, the prototype sounds a commercial Bluetooth tracker. Three people have used it at home since October 7, 2026; up to October 19, the full cycle worked in all three homes: the tracker sounded in 23 of 24 cycles, and in 19 of 21 responses the person knew what they wanted to do before reading it on the screen; in all 21 they remembered how to start, and in 10 they chose to start. This stage validated the cycle; the comparison with a neutral place and with the phone, already implemented, is the next step toward testing the hypothesis. The project also contributes a working prototype and a procedure for comparing situated signals with their alternatives before building an object.

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
- 11. Bajada proyectual: las decisiones de diseño
- 12. Factibilidad y límites
- 13. Plan de desarrollo y validación
- 14. Conclusiones
- Referencias
- Glosario
- Anexos

## Índice de tablas

- Tabla 1. Las decisiones de diseño de Relevo
- Tabla 2. Lo que Relevo toma de iOS y el principio que lo justifica
- Tabla 3. Iteraciones del prototipo y aprendizajes que las motivaron
- Tabla 4. Presupuesto del prototipo académico
- Tabla 5. Lo que mostró la prueba y cómo se itera
- Tabla 6. Estado de los objetivos al cierre de este documento

## Índice de figuras

- Figura 1. Dos caminos para que vuelva una intención
- Figura 2. La señal y el mensaje de un recordatorio
- Figura 3. Cómo pasa la señal de la periferia al centro de la atención
- Figura 4. Lo que dicen y lo que hacen las personas
- Figura 5. Episodios recientes de ocio digital según la encuesta
- Figura 6. Opiniones sobre la propuesta
- Figura 7. Sobre qué actúan las herramientas y dónde ocurren
- Figura 8. Los ocho criterios de diseño, agrupados por responsabilidad
- Figura 9. El proceso del proyecto, de marzo a octubre de 2026
- Figura 10. Relación entre intención, lugar, condición y decisión
- Figura 11. Flujo de la aplicación, de la primera vez a la decisión
- Figura 12. Pantallas del prototipo Android al preparar un ciclo
- Figura 13. Contar, sonar y decidir
- Figura 14. Registro de pantallas: la primera vez
- Figura 15. Arquitectura de información de la aplicación
- Figura 16. Sistema de identidad de Relevo
- Figura 17. El Tag durante la prueba en el hogar
- Figura 18. El testigo: un objeto propio con la placa del Tag adentro
- Figura 19. La prueba aplicada en los hogares
- Figura 20. Lo que ocurrió en los 24 relevos que alcanzaron su límite
- Figura 21. Qué decidió cada persona después de la señal
- Figura 22. Recordar no basta para empezar

# 1. Motivación personal

Me ocurre con frecuencia abrir una aplicación para descansar unos minutos y quedarme en ella más tiempo del que imaginaba. Al cerrarla, descubro que otras cosas que también quería hacer —dibujar, leer, caminar o cocinar con calma— dejaron de estar presentes. No decidí abandonarlas; dejaron de participar en lo que hacía.

No pienso que todo uso del teléfono sea negativo. Muchas veces encuentro en él entretención, conversación, información o un descanso que valoro. Me inquieta la diferencia entre elegir seguir y darme cuenta, después, de que no volví a considerar lo demás.

Me interesa estudiar ese momento sin convertirlo en un juicio sobre disciplina o productividad: por qué una intención personal pierde presencia, qué condiciones lo favorecen y cómo el diseño podría ayudar a que vuelva a ser considerada. La pregunta nace de mi experiencia; lo que esta memoria afirma sobre otras personas proviene de la investigación. Parte de un límite claro: descansar, cambiar de actividad o seguir frente al teléfono pueden ser decisiones igualmente válidas.

# 2. Introducción

Los teléfonos inteligentes reúnen en un mismo dispositivo la comunicación, la información, el trabajo y el entretenimiento. Con ellos cambió la forma de organizar el tiempo y de descansar: una persona puede conversar, escuchar música, jugar, mirar una serie o recorrer una red social sin cambiar de soporte. Esa variedad impide tratar el uso del teléfono como una sola experiencia y vuelve insuficiente cualquier juicio basado solo en cuánto tiempo se usa.

Aquí se entiende por *ocio digital* el conjunto de actividades que una persona realiza a través de dispositivos en su tiempo disponible para descansar, entretenerse, satisfacer su curiosidad o vincularse con otros. No se opone a otras formas de ocio ni necesita justificarse por su utilidad. Una sesión larga puede ser satisfactoria; una breve puede sentirse inoportuna si desplaza algo que la persona consideraba importante. La diferencia depende del propósito, del contexto y de la valoración de quien la vive (Lukoff et al., 2018).

El problema aparece en un momento preciso. Al comenzar una sesión, la persona puede tener presente otra actividad que también quiere hacer: leer, dibujar, salir a caminar, ordenar su pieza o llamar a alguien. La sesión continúa y esa intención deja de orientar el paso siguiente; cuando vuelve a pensar en ella, la ocasión puede haber cambiado o queda menos tiempo. La situación tiene dos formas: en una, la otra actividad deja de estar presente y se recuerda tarde; en la otra, sigue presente y aun así no se inicia. El proyecto se dirige a la primera; queda abierto si también puede ayudar en la segunda.

Ese momento no ocurre en el vacío. Muchas aplicaciones están diseñadas para que la actividad continúe: el *desplazamiento infinito* carga contenido nuevo sin un final reconocible, y la reproducción automática inicia un contenido apenas termina otro. Estos patrones no determinan la conducta, pero reducen los *puntos de cierre*, los momentos en que algo termina y hay que elegir si seguir (Montag et al., 2019).

Las respuestas más difundidas actúan sobre la actividad presente. Las herramientas de bienestar digital miden el tiempo, fijan límites, bloquean aplicaciones o ponen una pausa antes de abrirlas (Lyngs et al., 2019). Sirven cuando alguien quiere reducir una conducta concreta, pero detener lo que se está haciendo no devuelve lo que se quería hacer: un bloqueo puede cerrar una aplicación y dejar igualmente ausente la otra intención, o cortar un descanso que la persona sí quería mantener.

La psicología ofrece un concepto para precisar la situación. La *memoria prospectiva* es la capacidad de recordar una acción que se quiere realizar cuando llega la ocasión de hacerla (McDaniel y Einstein, 2000). Recordar al final del día que se quería leer no equivale a recuperar esa intención cuando todavía era posible abrir el libro. Así planteado, el desafío no es frenar el uso del teléfono, sino lograr que una intención vuelva a tiempo, sin convertirse en una obligación.

Este proyecto aborda ese desafío desde el diseño. Busca que una persona vuelva a considerar, mientras la sesión continúa, una actividad que ella misma eligió, sin prohibir la actividad actual ni decidir por ella qué forma de descanso vale más. Para comprender la experiencia, la investigación combina una revisión bibliográfica, entrevistas, una encuesta y el análisis de herramientas y referentes. Para intervenir en ella, propone un sistema *phygital* —físico y digital— que vincula lo que la persona quiere hacer con el lugar donde eso comienza: la persona prepara en una aplicación su intención y su primer paso, y un objeto ubicado donde empieza esa actividad suena cuando se cumple una condición que ella define. La propuesta se prueba en el uso cotidiano, en el hogar, para observar si esa señal ayuda a recuperar la intención y si la decisión sigue siendo de quien la recibe.

# 3. Planteamiento del problema

En Chile, el teléfono es la puerta principal a internet: en 2025, el 96,6 % de los hogares encuestados declaró tener acceso propio y pagado, y entre los hogares conectados el teléfono inteligente fue el dispositivo más extendido, presente en el 99,1 % (Subsecretaría de Telecomunicaciones, 2025). Esas cifras describen un entorno conectado, pero no dicen si cada momento frente a la pantalla fue elegido. Este capítulo precisa cuándo ese uso se vuelve un problema y cuándo no.

## El problema

Una persona abre una aplicación para descansar unos minutos antes de dibujar, algo que quería hacer desde la tarde. Media hora después la cierra, y ya es tarde para empezar. No decidió abandonar el dibujo: mientras la sesión seguía, el dibujo no volvió a aparecer. Que lo recuerde después muestra que la intención no se perdió; lo que faltó fue que volviera a tiempo, cuando todavía podía orientar la decisión.

El problema puede formularse así: **durante algunos episodios de ocio digital, una actividad que la persona también quería realizar deja de estar presente y vuelve cuando la ocasión ya pasó.** No se trata de cuánto tiempo se usa el teléfono, sino de la relación entre la actividad presente y otra cosa que la persona también quería hacer.

## Por qué ocurre

**La atención está ocupada.** Recordar una acción futura exige que la intención vuelva por sí misma en el momento oportuno; cuando la actividad presente absorbe la atención, esa vuelta depende más de una señal del entorno que del esfuerzo de recordar (McDaniel y Einstein, 2000). En un estudio con 1315 personas adultas, que combinó cuestionarios breves durante el día con registros del uso del teléfono, cuanto más se prolongaba el desplazamiento sin propósito por contenidos, más culpa declaraban las personas, y el conflicto con otras metas explicaba parte de esa relación (de Segovia Vicente et al., 2024). El estudio es observacional y no distingue el olvido de la postergación, pero muestra que la relación con otras intenciones pesa en cómo se vive una sesión.

**La interfaz sostiene la continuidad.** Un capítulo, una canción o una página tienen un final reconocible; el desplazamiento infinito y la reproducción automática, en cambio, mantienen abierta la secuencia y ofrecen la acción siguiente con poco esfuerzo (Montag et al., 2019). La interfaz no actúa sola, pero organiza cuándo aparecen los cierres y las ocasiones de elegir.

**El ocio se juzga con la vara de la productividad.** Tonietto et al. (2021) observaron que considerar el ocio una pérdida de tiempo disminuye su disfrute, sobre todo cuando la actividad se realiza como un fin en sí misma. El estudio no trata del teléfono, pero advierte que una ayuda que presente el descanso como tiempo perdido puede dañar lo que pretende cuidar.

## El desafío de diseño

De ahí se desprende el desafío: **ayudar a que la persona recuerde a tiempo algo que quería hacer, sin bloquear lo que está haciendo, sin decidir por ella y sin intervenir cuando el ocio digital conserva sentido.** Recuperar una intención significa devolverla a la decisión, no convertirla en obligación.

# 4. Justificación

El tema es relevante porque el teléfono participa constantemente en la vida cotidiana y reúne actividades que no pueden evaluarse con una sola regla. Las mediciones de tiempo informan cuánto se usó, pero no si una sesión respondió al propósito de la persona ni si desplazó otra intención. Una respuesta más precisa debe reconocer tanto el derecho a cambiar de actividad como el de seguir en un descanso elegido.

Cuando las alternativas se reducen a bloquear, contabilizar o comparar, una herramienta de apoyo puede convertirse en una nueva fuente de presión. Fijar una intención no debería crear una deuda con el sistema: ignorar una señal, cambiar de idea o permanecer en la actividad digital son resultados legítimos. Este criterio traduce en decisiones de diseño la autonomía, una necesidad psicológica básica según la teoría de la autodeterminación (Ryan y Deci, 2000), y evita confundir ayuda con obediencia.

El problema involucra variables propias del diseño: continuidad, cierre, momento, canal, jerarquía, legibilidad, esfuerzo y control. La psicología aporta conceptos para entender el recuerdo de acciones futuras y el conflicto entre metas, y la ingeniería permite programar las condiciones y la comunicación entre dispositivos; al diseño le corresponde unir ambos conocimientos en una experiencia clara, situada y respetuosa de quien la usa.

El tema también corresponde al diseño porque permite repartir una interacción entre componentes físicos y digitales: una experiencia *phygital*, de *physical* y *digital* (Waggoner et al., 2026). La interacción tangible estudia cómo los objetos y el espacio físico participan en la relación con información digital (Ishii y Ullmer, 1997); un recordatorio ubicado en el entorno podría devolver una intención desde fuera de la pantalla que concentra la atención. El aporte se espera en dos planos: criterios para diseñar ayudas que acompañen una decisión sin presionarla, y un procedimiento para comparar, antes de fabricar un objeto propio, una señal situada donde comienza la actividad con la misma señal en otro lugar y con una notificación en el teléfono.

# 5. Antecedentes y estado de la cuestión

Antes de proponer una respuesta, conviene saber qué se ha estudiado. Esta revisión de la investigación previa es exploratoria, no sistemática: priorizó publicaciones desde 2019 y las anteriores que definen sus conceptos, y sus fuentes académicas están en inglés.

## Uso del teléfono y sentido de la experiencia

Meier y Reinecke (2021) reunieron 34 revisiones sobre comunicación digital y salud mental: la asociación entre uso de redes sociales y salud mental fue, en general, negativa y pequeña, y varió según el aspecto del uso y el indicador estudiados. Radtke et al. (2022) revisaron intervenciones de desconexión digital y encontraron resultados positivos, nulos y negativos. Reducir el uso no es una solución válida para todos; importa la relación entre lo que la persona hace y lo que quería hacer (de Segovia Vicente et al., 2024).

## Bloqueos, límites y pausas

Lyngs et al. (2019) analizaron 367 aplicaciones y extensiones de navegador: tres de cada cuatro bloqueaban o quitaban distracciones y alrededor de un tercio ayudaba a avanzar hacia una meta, por ejemplo recordándola. En los 43 estudios de evaluación que revisaron Monge Roffarello y De Russis (2023), la mediana de duración fue de 21 días y solo cinco superaron los 2 meses; su metaanálisis de siete estudios estimó un efecto entre pequeño y mediano sobre el tiempo de uso (*g* = 0,47), medida que consideran demasiado gruesa para el bienestar.

Otra línea introduce una pausa. En un experimento de campo de 6 semanas con one sec, que demora la apertura de una aplicación y pide reconsiderarla, 280 personas desistieron en el 36 % de los intentos; en otro, en línea, la opción explícita de desistir tuvo el mayor efecto y el mensaje de reflexión, por sí solo, no fue eficaz (Grüning et al., 2023). Los registros de 1039 personas que ya usaban la aplicación sugieren que el efecto no persiste al suspender la intervención (Haliburton et al., 2024). El creador del producto figura entre los autores de ambos trabajos, lo que exige cautela. MindPhone, en cambio, preguntaba al desbloquear el teléfono para qué se iba a usar o qué se haría después fuera de él: en un estudio de campo de 2 semanas con 28 personas, la segunda pregunta redujo el uso distraído y favoreció volver antes al entorno, y la primera aumentó la conciencia de los motivos de uso (Terzimehić et al., 2022).

## Recordatorios, lugares y objetos

Confiar un recuerdo a un recurso externo tiene un costo: en dos experimentos, se fijaron menos recordatorios cuando hacerlo exigía más esfuerzo físico (Chiu y Gilbert, 2024). Place-Its asociaba notas a lugares en teléfonos móviles; en su estudio exploratorio, 19 de 89 recordatorios se fijaron de nuevo porque llegaron en el lugar equivocado o cuando no se podían atender (Sohn et al., 2005). En un centro comercial virtual, las claves de lugar favorecieron el recuerdo de tareas asociadas a cada tienda (O’Rear y Radvansky, 2019).

Otros trabajos llevaron el recordatorio a objetos. The Tangible Reminder representaba cada compromiso con un objeto cotidiano que cambiaba de color al acercarse el plazo (Hermann et al., 2007); servía a citas o tomas de medicamentos, no a intenciones que la persona puede decidir no realizar. Wobble sirvió para investigar, en el hogar, recordatorios periféricos, que no reclaman la atención, y, según sus autores, conviene a intenciones que no exigen actuar de inmediato (Zekveld et al., 2017). Keppel et al. (2025) compararon durante 9 semanas, con 24 personas, un artefacto físico y uno digital que mostraban en el hogar datos de actividad física: ambos sirvieron de recordatorio y el físico generó más involucramiento. Ninguno de estos trabajos trata el ocio digital.

## Alcance de los antecedentes

Las métricas describen el uso, los bloqueos modifican el acceso, las pausas abren una reconsideración y los recordatorios apoyan el recuerdo; ninguna línea muestra bajo qué condiciones lo que la persona quería hacer vuelve a orientar su decisión mientras la sesión continúa.

# 6. Marco teórico por ámbitos

Los antecedentes dicen qué se ha intentado, pero no por qué una intención deja de orientar lo que se hace. Tres ámbitos ayudan a entenderlo: la experiencia del ocio digital, las interfaces que sostienen su continuidad y los objetos y lugares que apoyan el recuerdo. Juntos indican qué condiciones debería respetar una ayuda.

## La experiencia del ocio digital

El sentido de una sesión se asocia con el motivo y el tipo de uso (Lukoff et al., 2018), por lo que la unidad relevante es el *episodio*: una situación concreta con un inicio, una actividad, un propósito, otras intenciones posibles y una valoración posterior.

El *conflicto entre metas* aparece cuando una actividad dificulta otra también valorada, sin establecer cuál debería prevalecer; vincula el malestar con la distancia respecto de otras intenciones (de Segovia Vicente et al., 2024). «Meta» se reserva aquí para las fuentes que la usan; lo que la persona se propone hacer se llama intención.

La culpa, sin embargo, no sirve como indicador automático: Tonietto et al. (2021), que no la midieron, mostraron que creer que el ocio es una pérdida de tiempo —creencia que relacionan con el énfasis social en la productividad— reduce su disfrute. El malestar tras un episodio puede reflejar esa creencia y no un conflicto con otra intención; es más preciso preguntar si existía otra intención que la persona quería mantener disponible.

Una elección inicial deliberada no implica que cada momento posterior responda a una nueva decisión. Se llama *decisión renovada* al momento en que la persona vuelve a considerar si desea continuar, cambiar o detenerse; puede surgir ante el final de un contenido, una pausa o una señal del entorno.

## El diseño de la atención

Patrones de interfaz como el desplazamiento infinito o la reproducción automática (Montag et al., 2019) forman lo que aquí se llama *arquitectura de atención*: un conjunto de decisiones de interfaz que orienta lo que se percibe y cómo avanza la interacción. Seguir con un gesto mínimo exige menos preparación que levantarse, reunir materiales o cambiar de espacio. La *fricción*, un esfuerzo adicional como esperar o confirmar, puede abrir una ocasión de reconsiderar (Grüning et al., 2023), pero si es excesiva frustra actividades legítimas.

La *autonomía* se entiende en el sentido de la teoría de la autodeterminación (Ryan y Deci, 2000): en términos de diseño, depende de comprender la intervención y poder aceptarla, ajustarla o rechazarla. Una ayuda difícil de detener puede presionar aunque no bloquee el teléfono, y un tono amable no reemplaza la posibilidad real de elegir: en un experimento sobre una intervención digital de salud, ofrecer opciones mejoró la valoración de las personas, y cambiar solo el lenguaje, no (Smit et al., 2019).

Las *intenciones de implementación* son planes que especifican de antemano cuándo, dónde y cómo actuar: si se presenta cierta situación, se inicia una respuesta (Gollwitzer y Sheeran, 2006). De ellas interesa precisar cómo y dónde comienza una actividad, no el compromiso de ejecutarla: la persona debe poder recordar su intención y decidir no seguirla.

Recordar una intención, iniciar una actividad y adquirir un hábito son resultados distintos: un hábito es una conducta que se vuelve más automática en un contexto recurrente, y medir su frecuencia o registrar una señal no basta para demostrarlo (Lally et al., 2010). Las *rachas* —series de tres o más repeticiones consecutivas de una conducta— favorecen su continuidad mientras el registro las muestra intactas, porque mantenerlas se vuelve una meta en sí misma; al romperse, la conducta se repite menos (Silverman y Barasch, 2023). Rachas, puntos y premios quedan fuera no por lúdicos, sino porque califican el cumplimiento: el proyecto estudia cómo acompañar una decisión, no cómo crear hábitos.

## Recordar con objetos y lugares

La memoria prospectiva se distingue del recuerdo de acontecimientos pasados porque nadie pide explícitamente recordar: la intención debe volver por sí misma cuando todavía es posible actuar (McDaniel y Einstein, 2000). Para evaluar una ayuda conviene separar cuatro pasos —percibir la señal, identificar su origen, recordar la actividad y recordar cómo comenzarla— y saber en cuál falla sin exigir que la persona actúe.

El *marco multiproceso* explica cómo vuelve una intención: la persona puede vigilar el entorno esperando el momento indicado, o un evento puede traerla de vuelta de forma espontánea (McDaniel y Einstein, 2000; Figura 1). Cuando la actividad en curso absorbe la atención, como en una sesión de ocio digital, lo segundo es más probable si la señal es llamativa y está fuertemente asociada a la acción. Los recordatorios más eficaces aludían a la vez a la ocasión y la acción prevista, y los que solo anunciaban la ocasión no mejoraban el recuerdo (Guynn et al., 1998). Los estudios sobre el lugar evalúan intenciones que se recuperan al estar en el sitio, no un sonido que llega desde él (O’Rear y Radvansky, 2019). De ahí una hipótesis: una señal que proviene del lugar donde comienza la actividad podría indicar, sin texto, qué hacer y con qué empezar. Pero con una sola intención vigente quizá baste cualquier señal convenida, y el aporte del lugar sería entonces acortar el paso entre recordar y empezar.

**Figura 1**

*Dos caminos para que vuelva una intención*

[FIGURA POR INSERTAR: (columna) esquema de caminos: Vigilar | La persona revisa si llegó el momento | Exige atención constante, Falla si otra actividad la absorbe; Recuperar ante una señal | Algo del entorno trae de vuelta la intención | Funciona aunque la atención esté en otra parte, Es el camino que busca Relevo]

*Nota.* Elaboración propia a partir de McDaniel y Einstein (2000).

Una nota, un libro dispuesto sobre la mesa o una alarma son formas de *descarga cognitiva*, la acción física que reduce la demanda cognitiva de una tarea (Risko y Gilbert, 2016). Todo recordatorio reúne una señal, que avisa que hay algo que recordar, y un mensaje, que dice qué es (Norman, 1988/1990, p. 73; Figura 2); la señal no necesita contener el mensaje si su relación con la intención se comprende, y si es ambigua obliga a consultar otra fuente.

**Figura 2**

*La señal y el mensaje de un recordatorio*

[FIGURA POR INSERTAR: (columna) esquema de recordatorio: Señal | Avisa que hay algo que recordar | En Relevo, el sonido del objeto; Mensaje | Dice qué es | En Relevo, el lugar donde suena y el primer paso que está ahí]

*Nota.* Elaboración propia a partir de Norman (1988/1990, p. 73).

Kirsh (1995) explica que la disposición de los objetos puede simplificar la elección, la percepción y el cálculo mental, como un rollo de película dejado junto a la puerta para recordar que se quería revelarlo.

La *interacción tangible* da forma física a la información digital. Ishii y Ullmer (1997) propusieron acoplarla con objetos y superficies cotidianos y distinguieron dos planos: objetos que se manipulan en el centro de la atención y medios ambientales —luz, sonido, corrientes de aire— que informan desde la periferia (Figura 3). Para el problema importan el plano periférico y el espacio: un objeto puede significar por el lugar donde se deja más que por su manipulación.

**Figura 3**

*Cómo pasa la señal de la periferia al centro de la atención*

[FIGURA POR INSERTAR: (columna) pasos de atención: Antes de la señal | La pantalla | El objeto, junto al primer paso; Suena el objeto | El sonido y la actividad que recuerda | La pantalla; Termina la señal | Lo que la persona decida | El objeto, otra vez en silencio]

*Nota.* Elaboración propia a partir de Weiser y Brown (1997).

La *tecnología calma* describe el ideal de esas señales: informar desde la periferia de la atención y pasar fácilmente al centro y de vuelta (Weiser y Brown, 1997; Figura 3). Una señal sonora dirigida a alguien absorto en una pantalla tensiona ese ideal, porque debe irrumpir en el centro: el sonido se percibe aunque la atención esté en otra parte, y por eso mismo es intrusivo (Norman, 1988/1990, p. 103). Los antecedentes señalan ambos riesgos: una señal ambiental puede pasar inadvertida (Lee et al., 2023), y un recordatorio que reclama la atención es difícil de ignorar, pueda o no actuar la persona (Zekveld et al., 2017).

*Phygital* (Waggoner et al., 2026) nombra en esta memoria el tipo de sistema; el análisis se apoya en la interacción tangible. De su revisión sobre métodos de experiencia de usuario en bibliotecas se toma el criterio de evaluar lo físico y lo digital como un solo sistema; se añade la exigencia, que Gembali (2023, p. 56) sí propone, de comprobar si el componente físico aporta valor frente a una solución solo digital.

# 7. Usuario, contexto y hallazgos de entrevistas

## Dos fuentes primarias

La teoría explica el fenómeno en general; faltaba saber cómo lo viven las personas y cuándo una ayuda sería un error. Para eso, el usuario y su contexto se estudiaron con dos fuentes primarias, diseñadas y aplicadas por el autor: ocho entrevistas semiestructuradas y una encuesta en línea. Las entrevistas definieron a quién se dirige el proyecto y cuándo no debe intervenir; la encuesta, posterior, contrastó esos criterios con más personas.

Las entrevistas se hicieron en Santiago, en persona, el 11 y el 12 de junio de 2026, cuando el proyecto trabajaba sobre una idea anterior: un objeto donde se depositaría el teléfono y que luego mostraría una señal del descanso realizado. Por eso la pauta no pregunta directamente por otra actividad que la persona quisiera hacer; esa categoría se construyó en el análisis. Participaron ocho personas de 19 a 27 años, reclutadas por referencias de personas cercanas al investigador, con consentimiento oral. La pauta tiene 13 preguntas, de Q1 a Q13: el tiempo libre, la última sesión de entretenimiento en el teléfono y cómo se vivió, la valoración del ocio, los intentos de descansar sin el teléfono y la reacción ante la idea anterior. La pauta y la síntesis de cada entrevista están en el Anexo A.

Las conversaciones se transcribieron después con apoyo de una herramienta automática [CONFIRMAR: si hubo grabación de audio y con qué se transcribió]. El corpus resultante es una síntesis en tercera persona: sostiene paráfrasis, no citas textuales, y una remisión como «(P2, Q3–Q7)» indica las respuestas que apoyan una afirmación. El análisis, entre el 23 y el 30 de agosto de 2026, siguió el método Framework, que ordena el material codificado en una matriz de casos y temas para comparar dentro de cada caso y entre casos (Goldsmith, 2021): un libro de 23 códigos, la reconstrucción de cada caso y la comparación de los ocho. De las semejanzas y los contrastes surgieron *tipos ideales*, agrupaciones analíticas que no pretenden coincidir del todo con la realidad (Stapley et al., 2022), adaptados aquí a episodios de ocho entrevistas y sin la comprobación por una segunda persona que ese método recomienda. Los relatos son retrospectivos, de una sola conversación por persona, y lo que se dice puede diferir de lo que se hace (Sanders y Stappers, 2012, p. 69; Figura 4): los hallazgos muestran patrones y contraejemplos, no frecuencias ni causas.

**Figura 4**

*Lo que dicen y lo que hacen las personas*

[FIGURA POR INSERTAR: (columna) esquema de fuentes: Lo que dicen | Entrevistas y encuesta | Motivos, valoraciones y recuerdos; Lo que hacen | Registros de la prueba en los hogares | Cuándo sonó la señal, qué respondieron y qué decidieron]

*Nota.* Elaboración propia a partir de Sanders y Stappers (2012, p. 69).

La encuesta, en Google Forms, tuvo 16 preguntas y 53 respuestas analizadas, de personas de 19 a 30 años (mediana de 22) [CONFIRMAR: fecha, convocatoria y relación con la encuesta de 70 participantes registrada el 2 de septiembre]. Se incorporó el 29 de septiembre de 2026, cuando la propuesta ya existía: sirve para contrastar los criterios de diseño, no para explicar su origen. Preguntó por el episodio más reciente en que la persona siguió en una aplicación más tiempo del que quería, por la otra actividad que deseaba y por cómo la habría empezado; después describió la propuesta, con la señal en un parlante, y pidió opiniones. El investigador ordenó las respuestas antes de exportarlas [CONFIRMAR: alcance de esa edición], y las respuestas abiertas de cinco preguntas las clasificó una herramienta de inteligencia artificial con reglas escritas, cuya revisión por el investigador está pendiente [CONFIRMAR: fecha de revisión y códigos corregidos]. Por eso se informan recuentos y categorías, no citas, y las cifras de esas cinco preguntas son provisionales (véase el Anexo B).

## Lo que contaron las personas

P2 abrió Instagram al acostarse, reconoció que tenía sueño y aun así siguió; recordaba bien la sesión, pero dudó de que hubiera sido un descanso (P2, Q3–Q7). P3 vio videos humorísticos, perdió la noción del tiempo y reconoció que tenía cosas mejores que hacer, aunque la sesión le sirvió como pausa (P3, Q3–Q8): una actividad puede descansar y, a la vez, competir con otra intención. P5 describió entretenimiento seguido de aburrimiento, sin una meta concreta: no toda insatisfacción esconde una intención que recuperar (P5, Q3–Q10). P1 y P4 distinguieron usos dirigidos —leer manga, resolver un sudoku— de otros rutinarios: el problema no pertenece a una persona, sino a ciertos momentos (P1, Q3–Q5 y Q8; P4, Q3–Q8).

Otras experiencias conservaron sentido. P6 relató una videollamada de varias horas con una amiga, valorada por el vínculo (P6, Q3–Q9); P7, un pódcast elegido mientras comía (P7, Q3–Q10), y P8, una rutina difícil de describir que aceptaba como descanso (P8, Q3–Q10). Ni la duración ni el tipo de aplicación bastan para decidir cuándo intervenir: una señal activada solo por el tiempo de uso podría interrumpir una conversación o una pausa deliberada.

Para descansar sin el teléfono, siete personas lo alejan, lo guardan, lo silencian o activan el modo No molestar, casi siempre para proteger otra actividad (P1–P5, P7 y P8, Q12), y tres contaron que, si queda cerca, vuelven a mirarlo (P1, P3 y P5, Q12). La distancia y el silencio quitan el teléfono de en medio, pero no hacen presente la otra actividad. Ante la idea anterior, seis personas pidieron señales simples, calmadas, discretas o visuales (P1, P3–P5, P7 y P8, Q13), y una rechazó las calificaciones y comparaciones entre días (P7, Q13). Ninguna pidió una señal sonora, y a P6 le molesta el sonido del teléfono cercano cuando lee o arma maquetas (P6, Q12).

La encuesta mostró que el momento estudiado es frecuente y doméstico (Figura 5). De los 43 episodios con otra actividad deseada, en 21 no se comenzó, en 14 se comenzó —a veces mucho más tarde— y en los ocho restantes la persona cambió de idea, no podía empezarla o no lo recordaba. Casi todos nombraron un *primer paso*, la acción breve con que la actividad comienza, como abrir el libro o ponerse las zapatillas.

**Figura 5**

*Episodios recientes de ocio digital según la encuesta*

[FIGURA POR INSERTAR: cuatro datos en tarjetas: 39 de 45, personas que siguieron en una aplicación más tiempo del que querían al menos un día de la última semana; 43 de 47, episodios que incluían otra actividad deseada; 42 de 43, casos en que se nombró un primer paso; 44 de 47, episodios que ocurrieron en casa]

*Nota.* Encuesta en línea del autor (53 respuestas). Cada total corresponde a quienes respondieron esa pregunta.

Después de leer la propuesta, 49 de 53 personas explicaron bien su funcionamiento. La mayoría pondría el parlante junto a la actividad y preferiría un sonido de 15 segundos o menos, y la disposición a probarla quedó repartida, con una mediana de 3 en una escala de 1 a 5 (Figura 6). Los motivos de descarte más citados fueron que sonara en un mal momento (8), el esfuerzo de prepararla (7) y el ruido o la convivencia (7).

**Figura 6**

*Opiniones sobre la propuesta*

[FIGURA POR INSERTAR: gráfico de barras: Dónde pondría el parlante | Junto a la actividad: 36, En un lugar general de la casa: 7, No lo usaría o no sabe dónde: 10; Duración preferida del sonido | 1 a 5 segundos: 16, 6 a 15 segundos: 25, 16 a 30 segundos: 3, Que no sonara: 7, No sabe: 2; Probabilidad de probarlo, de 1 a 5 | 5: 3, 4: 20, 3: 18, 2: 8, 1: 3, No sabe: 1]

*Nota.* Encuesta en línea del autor (53 respuestas). Número de personas por respuesta.

## Dos situaciones de uso

Los hallazgos permiten distinguir dos situaciones, que por convención se nombran como usuarios. No son identidades ni segmentos comerciales: una misma persona puede pasar de una a otra. El *usuario principal* está en la primera: la sesión continúa sin una decisión renovada y otra cosa que la persona quería hacer deja de orientar el paso siguiente. La situación tiene las dos formas descritas en el capítulo 2: la actividad que se recuerda tarde y la que sigue presente y no se inicia. Las entrevistas respaldan sobre todo la segunda —P2 sabía que tenía sueño y siguió (P2, Q4 y Q7)— y en parte la primera: P3 perdió la noción del tiempo, aunque sabía que tenía algo pendiente (P3, Q4 y Q7). La situación a la que apunta la propuesta —una actividad que la persona quiere hacer y sabe cómo empezar, pero no empieza— la respalda sobre todo la encuesta. Su necesidad, derivada del análisis, es volver a considerar a tiempo una alternativa propia.

El *usuario límite* está en la segunda: la actividad digital es elegida, relacional, concentrada o reparadora, o no existe otra intención que apoyar. P6 y P7 son los contrastes más claros, y P4, P6 y P8 muestran que la posición cambia en una misma persona. Su necesidad es conservar la autonomía: una intervención equivocada podría convertir una actividad legítima en un problema, exponer una intención privada o interrumpir a otras personas. Para él, poder no activar, ignorar o detener la señal importa tanto como recibirla.

Como decisión de alcance, la primera versión se dirige a personas de 18 a 30 años, con un teléfono Android 12 o posterior, que pueden nombrar una actividad que quieren hacer en casa y tienen dónde dejar un objeto junto a su primer paso. El recorte corresponde al grupo al que el investigador tuvo acceso y a la plataforma del prototipo. El hogar se eligió porque varias intenciones y estrategias relatadas dependen de objetos, superficies y distancias; un objeto, sin embargo, puede moverse, y un sonido puede no oírse, molestar o revelar algo personal a quienes conviven con la persona, como advirtió P7 (P7, Q11).

## Necesidades de diseño

De ambas situaciones se desprenden necesidades comunes: una intención explícita, una configuración voluntaria, la posibilidad de cambiar de idea, una señal discreta, una salida inmediata y la ausencia de sanciones. Las entrevistas y la encuesta no definen la forma de la solución: precisan el momento que debe abordarse y cuándo intervenir sería un error. Dejan, además, dos tensiones que el diseño debe resolver: las personas prefieren señales visuales y breves, y temen que la señal suene en un mal momento.

# 8. Estado del arte y referentes

## Método y criterios de comparación

Con esas necesidades a la vista, se compararon productos, servicios y la evidencia publicada sobre ellos con seis preguntas: qué problema abordan, qué mecanismo usan, dónde ocurre la interacción principal, qué exigen configurar y mantener, cómo conservan o limitan la autonomía y qué evidencia hay sobre sus resultados. La búsqueda, exploratoria y no sistemática, se cerró el 24 de agosto de 2026, y el Anexo C reúne su registro, las fichas y la exploración de patentes.

## Herramientas digitales de medición y pausa

Apple Screen Time y Google Digital Wellbeing miden el uso y fijan límites de tiempo (Apple, s. f.; Google, s. f.-a). Las aplicaciones de pausa llevan la reconsideración al momento de la apertura: one sec la interrumpe con un ejercicio breve (one sec, s. f.), y su evidencia no informa qué hace la persona después de desistir (Grüning et al., 2023; Haliburton et al., 2024). Pause Point, anunciado por Google en 2026, impone una espera de 10 segundos al abrir una aplicación distractora y no se desactiva sin reiniciar el teléfono (Sanders, 2026). Junto con MindPhone (Terzimehić et al., 2022), todas intervienen en la pantalla, no en el lugar donde la actividad puede comenzar.

## Proyectos de título de diseño en Chile

Dos memorias de diseño de la Universidad de Chile pusieron a prueba la gamificación en aplicaciones de bienestar. Riveros Oltra (2023) probó ocho semanas, con 357 personas de la propia empresa, una función de hábitos con misiones, rachas y recompensas para Betterfly: la gamificación no garantizó la retención, y los usuarios activos semanales aumentaron en promedio un 6,4 %, frente a una meta del 20 %. Venegas Álvarez (2026) evitó puntos y niveles en una aplicación de diario de gratitud, y tras un mes con 36 personas reconoció que la evidencia no demuestra que resuelva la baja adherencia. Ambas buscan que la persona vuelva a la aplicación, y Relevo, que la deje; el caso de Betterfly es coherente con la exclusión de rachas y premios (criterio 4).

## Objetos que restringen o alejan el teléfono

Brick vincula una aplicación con un dispositivo físico que activa o revierte modos de bloqueo; su precio declarado era de 59 dólares estadounidenses (USD; Brick LLC, s. f.-a). Combina distancia y *precompromiso*: una decisión previa que restringe deliberadamente las opciones futuras. Brick Zone, un dispositivo Bluetooth de USD 99, bloquea las aplicaciones donde se deja, sin alcance ni precisión documentados (Brick LLC, s. f.-b): el lugar es allí una condición de restricción, no un recordatorio. Unpluq (s. f.) y Screenless Breaker (Screenless, s. f.) usan etiquetas o llaves NFC (comunicación de campo cercano). En todos, el objeto hace visible el compromiso, pero suma costos de compra, compatibilidad y aprendizaje. kSafe, un contenedor con cierre temporizado, restringe sin conexión con el teléfono, pero es difícil de revertir antes del plazo (Kitchen Safe, s. f.); alejar o silenciar el teléfono, como relataron las entrevistas, es más reversible y no tiene costo.

## Objetos de foco y recordatorios situados

Focusaur combina un dispositivo físico con una aplicación, etiquetas NFC, sonidos, funciones de hábito y recompensas, con un precio promocional de USD 129 (Focusaur, s. f.). Participa de un ritual de inicio, pero sus recompensas pueden llevar a actuar para cumplir con el sistema y se orienta a la productividad. The Tangible Reminder y Wobble (capítulo 5) recuerdan una acción sin depender del teléfono; Place-Its la entregaba en la pantalla, y una ubicación detectada no equivale a una relación personal con el espacio.

Una última familia resuelve el soporte, no el uso del teléfono: los localizadores Bluetooth y llaveros antipérdida, objetos pequeños que suenan cuando la persona los busca desde el teléfono [CONFIRMAR: fuente citable del localizador usado y de un referente de la familia]. El prototipo de Relevo emplea uno. Muestran que una señal sonora cabe en un objeto pequeño y autónomo.

## Evidencia y límites de cada familia

La evidencia es desigual: los estudios sobre herramientas digitales suelen ser breves y medir el tiempo de uso (capítulo 5), y sobre los objetos comerciales no se localizó ninguna evaluación independiente. Además, 63 de 138 personas que habían desactivado los avisos de una herramienta de autocontrol digital aceptaron reconfigurarlos (Peña-Albert et al., 2026): una regla puede dejar de servir. La Figura 7 ubica a cada familia según sobre qué actúa y dónde ocurre.

**Figura 7**

*Sobre qué actúan las herramientas y dónde ocurren*

[FIGURA POR INSERTAR: mapa de posicionamiento: Actúa sobre lo que haces ahora | Parte de lo que querías hacer | En la pantalla | En el lugar, fuera de la pantalla; Screen Time y Bienestar digital | 1.2 | 1.5; one sec y Pause Point | 2.2 | 3.1; MindPhone | 5.6 | 2.3; Place-Its | 7.7 | 3.5; Brick y Unpluq | 1.3 | 7.4; kSafe y dejar el teléfono lejos | 2.4 | 8.8; Focusaur | 4.6 | 6.4; The Tangible Reminder | 7.7 | 7.9; Relevo | 8.9 | 9.4]

*Nota.* Elaboración propia. Ubicación aproximada, según la documentación de cada producto y los estudios citados; no mide eficacia. Las fichas de cada referente están en el Anexo C.

## Oportunidad y exigencia de comparación

Cada elemento de Relevo tiene antecedentes parciales, y una exploración no exhaustiva de patentes halló cuatro documentos con coincidencias parciales: ni el aparato ni la relación entre recordatorios, objetos y lugares pueden presentarse como nuevos. Lo que no se encontró es un producto o prototipo que reúna cinco elementos —una intención formulada por la persona, un primer paso concreto, una condición digital comprensible, una señal emitida desde donde comienza la actividad y una decisión que queda abierta—, ni un estudio que compare esa señal con una notificación en el teléfono.

La oportunidad es, por eso, una pregunta de diseño: si una intención devuelta por una señal desde el lugar donde comienza se recupera mejor que con una notificación, sin dificultar el acceso al teléfono. Y conlleva una exigencia: si una notificación, una pausa con intención o la alarma, el límite o la nota que ya usan 10 de las 53 personas encuestadas ofrecen el mismo apoyo con menor carga, el componente físico no se justifica.

# 9. Criterios de diseño

La investigación, las personas y los referentes dejan ocho condiciones que una ayuda debe cumplir: los criterios de diseño. Sirven para diseñar y, después, para evaluar; formularlos es parte de la síntesis, que traduce una oportunidad en criterios concretos (Kolko, 2011, p. 40). La encuesta permitió contrastar varios. Se agrupan en tres responsabilidades: conservar una intención comprensible (criterios 1 y 2), respetar la decisión de la persona (3 a 5) y justificar el esfuerzo del sistema (6 a 8) (Figura 8). El Anexo D relaciona cada uno con su evidencia y lo que falta probar.

**Figura 8**

*Los ocho criterios de diseño, agrupados por responsabilidad*

[FIGURA POR INSERTAR: esquema de criterios: Conservar una intención comprensible | Criterios 1 y 2 | Partir de una intención propia, Relacionar la intención con un primer paso; Respetar la decisión de la persona | Criterios 3 a 5 | Usar una condición comprensible, Abrir una elección y no imponer una conducta, Reconocer cuándo no intervenir; Justificar el esfuerzo del sistema | Criterios 6 a 8 | Mantener una carga proporcional, Proteger la privacidad y la convivencia, Demostrar el valor de la capa física]

*Nota.* Elaboración propia a partir de la revisión bibliográfica, las entrevistas y la comparación de herramientas.

## Intención propia y comienzo concreto

**Criterio 1: Partir de una intención propia.** La actividad debe elegirla la persona, no deducirse del tiempo de uso o la aplicación abierta. El sentido atribuido a una sesión se asocia con el motivo y el tipo de uso (Lukoff et al., 2018), y el tiempo de pantalla no basta para estimar la relación entre uso y salud mental (Meier y Reinecke, 2021). Lo ilustra el contraste de P2 y P3 con P6, P7 y P8: sin una intención formulada no hay nada que recuperar.

**Criterio 2: Relacionar la intención con un primer paso.** El *primer paso* es una acción breve, concreta y disponible con la que comienza la actividad; sin él, una intención amplia no dice cómo empezar. Las intenciones de implementación favorecen pasar de la meta a la acción (Gollwitzer y Sheeran, 2006). De ellas se toma solo precisar con qué y dónde se empieza, no el compromiso de actuar; por eso no cabe esperar su efecto. P2 asoció una tarde bien aprovechada con tener sus materiales a mano (P2, Q10) y, en la encuesta, 42 de las 43 personas que deseaban otra actividad nombraron un primer paso.

## Activación comprensible y decisión autónoma

**Criterio 3: Usar una condición comprensible.** La activación debe depender de un evento que la persona pueda entender, fijar y modificar. Android permite consultar, con autorización, cuánto se usa cada aplicación (Google, 2026b), pero ese dato no informa lo que la persona siente: el tiempo es una condición que ella fija de antemano, no una inferencia del sistema. En la encuesta, 18 de 53 personas valoraron usar el teléfono para aprender o resolver algo, uso que un conteo de tiempo no distingue. La condición debe explicarse con ejemplos.

**Criterio 4: Abrir una elección, no imponer una conducta.** La señal devuelve la intención al presente sin bloquear el teléfono: ignorarla, detenerla, cambiar de intención o seguir en la actividad digital son respuestas válidas. La evidencia sobre periodos de desconexión es dispar (Radtke et al., 2022); una pausa breve conserva la posibilidad de continuar (Grüning et al., 2023). El sistema puede reconocer lo que la persona declara, pero no felicitar por lo que no observó; rachas, puntajes y premios quedan fuera, porque mantener una racha puede volverse una meta en sí misma (Silverman y Barasch, 2023).

**Criterio 5: Reconocer cuándo no intervenir.** Una actividad digital elegida, relacional, concentrada o reparadora no requiere corrección; tratar el ocio como una pérdida de tiempo reduce su disfrute (Tonietto et al., 2021). La videollamada de P6 y el pódcast que P7 eligió conservaron sentido, y P4, P6 y P8 mostraron que la necesidad de ayuda cambia en una misma persona. Si la persona no tiene otra cosa que quiera hacer, la propuesta debe quedarse inactiva, y una regla puede perder vigencia sin que sea un error.

## Carga de uso, convivencia y aporte físico

**Criterio 6: Mantener una carga proporcional.** Preparar el recordatorio, vincular el objeto y situarlo agregan esfuerzo. En tareas experimentales, un mayor esfuerzo físico para fijar un recordatorio redujo su uso (Chiu y Gilbert, 2024); extenderlo a un objeto doméstico es una inferencia propia. Los productos revisados suman costos de compra y aprendizaje, y preparar y mantener el sistema fue el principal motivo de descarte para 7 de 53 personas encuestadas. Si la carga supera el beneficio, la propuesta debe simplificarse.

**Criterio 7: Proteger la privacidad y la convivencia.** Una señal en el hogar no debe exponer su contenido ni molestar a quienes comparten el espacio. Ante una idea anterior del proyecto, seis personas entrevistadas pidieron señales calmadas, discretas o visuales y ninguna pidió sonido (P1, P3–P5, P7 y P8, Q13). En la encuesta, el ruido y la convivencia fueron el principal motivo de descarte para 7 de 53 personas, y 12 aceptarían solo un registro local o ninguno. Intensidad, duración y ubicación se ajustan mediante pruebas.

**Criterio 8: Demostrar el valor de la capa física.** Un objeto añade costo y mantenimiento (capítulo 8) y solo se justifica por la ayuda que ofrece. El lugar puede participar en el recuerdo de una acción futura (O’Rear y Radvansky, 2019), pero de ello no se sigue que la persona comprenda una señal ni actúe; The Tangible Reminder se evaluó solo con una revisión heurística, sin medir el recuerdo (Hermann et al., 2007). El objeto debe aportar una asociación con el lugar que una notificación no produzca igual: compararlos es condición central de la evaluación.

# 10. Formulación

## Problema de diseño y pregunta de investigación

El estado del arte mostró que medir, pausar o restringir la actividad presente no devuelve necesariamente lo que la persona quería hacer ni indica dónde empezarlo. El problema de diseño es volver a hacer presente una intención formulada por la persona, sin bloquear el teléfono, evaluar su conducta ni intervenir cuando la actividad digital conserva sentido. La propuesta se dirige a quien ya eligió una actividad, sabe cómo comenzarla y está dispuesto a preparar ese comienzo, pero necesita mantenerla disponible durante ciertos episodios de ocio digital. Si la preparación resulta demasiado costosa, será un hallazgo sobre el diseño, no sobre la persona.

> ¿Qué condiciones pueden ayudar a que una persona vuelva a considerar algo que quería hacer cuando, durante una sesión de ocio digital, esa intención deja de orientar su decisión inmediata?

La pregunta se divide en dos. La primera —qué requisitos debe cumplir una ayuda así— la responden la investigación y los criterios del capítulo 9. La segunda —si aporta algo situar la señal donde comienza la actividad, frente a un lugar neutro o al teléfono— la abordan la hipótesis y la prueba de 21 días.

Volver a considerar una actividad significa reconocer la intención y recordar cómo comenzarla; no equivale a dejar el teléfono, completar la actividad ni reducir el tiempo de uso, y puede evaluarse sin exigir que la persona siga la señal.

## Definición y alcance de Relevo

Relevo es un sistema *phygital* compuesto por una aplicación Android y un objeto físico, el *testigo*, que se sitúa junto al primer paso de una actividad que la persona quiere hacer. La aplicación registra la intención y su primer paso y configura una condición de activación; cuando esta se cumple, el objeto emite una señal —el *pulso ambiental*, un sonido de unos 30 segundos que se detiene solo y no da instrucciones—, y la persona puede considerar la intención, seguir con la actividad digital o detener la señal. Para probar la relación entre señal y lugar antes de fabricar el testigo, el prototipo usa un localizador Bluetooth comercial, que la aplicación llama Tag. Más adelante se explica por qué se tomó cada una de estas decisiones.

El alcance considera una persona, una intención activa, un primer paso, una o varias aplicaciones cuyo uso se suma bajo un mismo límite, un objeto y un lugar doméstico que ella elige. El sistema no deduce emociones, no juzga si una sesión es adecuada ni observa si la actividad se realiza. La propuesta mantiene su carácter *phygital*, pero el componente físico puede cambiar si otra relación con los objetos responde mejor al problema.

## Hipótesis y objetivos

> Si se diseña un sistema *phygital* que vincula una actividad que la persona quiere hacer con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella.

Su fundamento es teórico: cuando una actividad absorbe la atención, es más probable que una intención vuelva si aparece una señal llamativa y fuertemente asociada a la acción (McDaniel y Einstein, 2000), y el lugar donde debe realizarse una acción puede ofrecer esa asociación (Kirsh, 1995; O’Rear y Radvansky, 2019). El respaldo es más firme para la señal que para el lugar, y la comparación debe establecer la ventaja de un objeto sobre un medio digital. La hipótesis se descompone en tres supuestos contrastables:

1. Asociación: al percibir la señal, la persona la atribuye a Relevo y recuerda la actividad y su primer paso sin consultar el teléfono. Sin comparador; se observa en la sesión inicial.
2. Lugar: el objeto junto al primer paso (condición A) favorece ese recuerdo más que el mismo objeto en un *lugar neutro*, visible pero sin relación con la actividad (B). Indicador: respuestas de un toque tras cada señal y valoración semanal.
3. Soporte: la condición A iguala o supera al teléfono con una notificación genérica (C) en esas respuestas, sin más carga ni molestia.

«A tiempo» significa que, al sonar la señal —cuando se cumple el límite que la persona fijó—, ella declara saber qué quería hacer y cómo empezar antes de leerlo en la pantalla. La prueba no mide si la actividad aún era posible ni si se realizó. La hipótesis se debilita si la persona necesita el teléfono para comprender la señal, si A no supera a B o si queda por debajo de C. Los casos en curso informan sobre el primer supuesto; la comparación, ya implementada, aborda los otros dos.

El objetivo general es diseñar y evaluar formativamente un sistema *phygital* que ayude a recuperar una intención personal durante episodios de ocio digital, mediante una señal ubicada junto al primer paso de la actividad y sin bloquear ni juzgar la decisión posterior. La evaluación formativa busca identificar dificultades y orientar mejoras dentro de un proceso iterativo (Nielsen, 1993, p. 170). Los objetivos específicos son:

1. Caracterizar cómo se relacionan el ocio digital, su continuidad, las otras actividades que la persona quiere hacer y el contexto mediante revisión bibliográfica, entrevistas, encuesta y análisis de referentes.
2. Traducir los hallazgos en una experiencia *phygital* que reúna configuración digital, señal física, lugar y control de la persona.
3. Comparar la señal ubicada junto al primer paso con la misma señal en un lugar neutro y con una notificación en el teléfono, para establecer si el lugar y el objeto físico aportan una diferencia reconocible.
4. Evaluar comprensión, percepción, autonomía, funcionamiento técnico, convivencia y carga de uso mediante prototipos cada vez más completos.

## Actores y responsabilidades

El proyecto lo condujo una sola persona, el autor, que investigó, diseñó, dirigió el desarrollo y evaluó. Lo orientaron dos profesores guía; tres personas probaron el prototipo en sus hogares, donde quienes conviven con ellas también oyen la señal, aunque no fueron consultadas, y las herramientas de inteligencia artificial programaron, redactaron borradores y analizaron la encuesta bajo su instrucción. Una etapa posterior requeriría especialistas en electrónica, fabricación, accesibilidad y protección de datos.

## Enfoque metodológico y plan de trabajo

El proyecto sigue un enfoque de investigación a través del diseño, en que el diseñador integra resultados de investigación en un artefacto y ese trabajo constituye un aporte (Zimmerman et al., 2007). Es exploratorio y principalmente cualitativo, con recuentos descriptivos: orienta decisiones de diseño. Avanzó en seis fases: la investigación, en el primer semestre; el análisis, en agosto; la formulación y el diseño, en agosto y septiembre; el prototipo, desde el 21 de septiembre; la evaluación en los hogares, desde el 7 de octubre, y el cierre, con el Pase de Examen el 25 de noviembre, la memoria el 2 de diciembre y el examen entre el 14 y el 18 de diciembre. La Figura 9 muestra cómo se desarrolló: un proceso con cambios de rumbo, en que cada decisión respondió a lo que se iba aprendiendo.

**Figura 9**

*El proceso del proyecto, de marzo a octubre de 2026*

[FIGURA POR INSERTAR: cronología del proyecto: Marzo a junio | Seminario de Título: de un objeto para dejar el teléfono a Relevo; 11 y 12 de junio | Ocho entrevistas en Santiago; 20 de julio | Examen: la comisión pide aclarar el objeto, el contexto y el usuario; 23 al 30 de agosto | Análisis de las entrevistas y criterios de diseño; Septiembre | Se estudia un objeto con luz y se decide probar un localizador; 21 al 25 de septiembre | Primera aplicación Android y señal solo sonora; 29 de septiembre | Hipótesis y encuesta de 53 respuestas; 5 al 7 de octubre | El Tag pasa a ser el objeto del prototipo; 7 de octubre | Comienza la prueba en tres hogares; 9 al 20 de octubre | Cuatro versiones corrigen lo que mostró el uso; 28 de octubre | Modelo del testigo para impresión 3D]

*Nota.* Elaboración propia a partir del registro de decisiones del proyecto.

### Uso de inteligencia artificial

El proyecto empleó ampliamente herramientas de inteligencia artificial generativa: Codex, de OpenAI, desde marzo de 2026, y Claude Code, de Anthropic, la principal desde fines de septiembre [CONFIRMAR: la herramienta con que se transcribieron las entrevistas]. Con ellas se programaron la aplicación, la base remota y el panel; se generaron alternativas visuales; se redactaron y revisaron borradores de esta memoria; se buscaron y verificaron fuentes, y se analizó la encuesta. El autor realizó las entrevistas, definió el problema y los criterios, aprobó, corrigió o rechazó cada propuesta y responde por el contenido. Desde el 29 de septiembre, cada pedido y su decisión se anotaron el mismo día (Anexo E).

# 11. Bajada proyectual: las decisiones de diseño

Con el problema formulado y los criterios definidos, comenzó el diseño. Todas las decisiones de diseño son del autor; el proyecto las registró a medida que se tomaban, con su contexto, sus alternativas y su fundamento: 149 entradas entre el 23 de agosto y el 28 de octubre de 2026. La Tabla 1 las resume, de lo general a lo particular, y las secciones siguientes las desarrollan.

**Tabla 1**

*Las decisiones de diseño de Relevo*

| Ámbito | Decisión | Por qué | Se descartó |
| --- | --- | --- | --- |
| Sistema | Una aplicación, un objeto junto al primer paso y el lugar. | La señal llega desde fuera de la pantalla y junto al comienzo. | Bloquear o pausar aplicaciones; una notificación como única señal. |
| Recorrido | Una decisión por pantalla, con opciones de un toque. | Preparar exige menos lectura y menos esfuerzo. | Un formulario único. |
| Condición | El tiempo en las aplicaciones que la persona elige. | Es fácil de explicar y de ajustar. | La continuidad de uso; una franja horaria. |
| Arquitectura | Tres destinos; Inicio muestra solo lo más próximo. | La aplicación no debe pedir que se la revise. | Un tablero con todo a la vez. |
| Lenguaje visual | La referencia de iOS 26. | Convenciones conocidas y una interfaz que se aparta. | Una interfaz plana; Material Design completo. |
| Escritura | De tú, con preguntas y sin vocabulario de deber. | Una orden o una calificación presiona. | Rachas, puntos y mensajes que apuran. |
| Identidad | Un color para cada función, todos de igual luminosidad. | Ningún estado resalta más que otro. | Fundar el color en asociaciones emocionales. |
| Objeto | Un Tag comercial para probar y, después, el testigo. | Probar la señal y el lugar antes de fabricar. | Localizadores cerrados; un objeto con luz. |
| Señal | Solo sonido, de unos 30 segundos, que termina solo. | Alcanza a quien mira una pantalla. | Una luz; una vibración; una alarma que insiste. |
| Datos | Notificación genérica y datos seudonimizados. | No exponer la intención a quienes conviven. | Registrar más de lo necesario. |

*Nota.* Elaboración propia a partir del registro de decisiones del proyecto.

## El sistema: tres partes y una decisión abierta

**Decisión.** Relevo reparte el trabajo entre tres partes. Una aplicación guarda la intención y vigila la condición que la persona fijó; un objeto, dejado junto al primer paso, emite la señal; y el lugar relaciona esa señal con una acción posible. La persona une las partes con una asociación que ella misma decide, y la secuencia termina en una decisión abierta (Figura 10).

**Figura 10**

*Relación entre intención, lugar, condición y decisión*

[FIGURA POR INSERTAR: diagrama de seis nodos, de la intención personal a la decisión de la persona, con tres salidas del mismo peso]

*Nota.* Elaboración propia. La secuencia termina en una decisión abierta, no en una acción obligatoria.

**Por qué un objeto y no solo el teléfono.** La señal debe llegar desde fuera de la pantalla que retiene la atención. Una intención vuelve con más probabilidad ante una señal llamativa y asociada a la acción, y el lugar donde la acción se realiza puede ofrecer esa asociación (McDaniel y Einstein, 2000). Un objeto en ese lugar une la señal con el comienzo, mientras que una notificación llega por el mismo canal que la persona está mirando; la interacción tangible y la tecnología calma dan el marco de esa relación entre objeto, lugar y atención (Ishii y Ullmer, 1997; Weiser y Brown, 1997).

**Alternativas descartadas.** Bloquear o pausar, porque actúan sobre la actividad presente y no devuelven la otra; una notificación como solución, que queda como condición de comparación, y un objeto donde dejar el teléfono, la idea de junio, que lo alejaba sin traer de vuelta la actividad.

**La decisión es de la persona.** El sistema no detecta si la actividad se realizó ni evalúa la respuesta. Al sonar la señal, considerar la intención, seguir en el teléfono y silenciar pesan lo mismo, y ninguna produce reproches. Este principio, que traduce la necesidad de autonomía de la teoría de la autodeterminación (Ryan y Deci, 2000), ordena el resto de las decisiones.

## El recorrido de la persona

La aplicación conduce a la persona por cuatro momentos: preparar un *relevo* —el ciclo en que una intención y su condición están vigentes—, esperar mientras usa el teléfono, recibir la señal y decidir (Figura 11). La Figura 12 muestra cómo se prepara y la Figura 13, lo que ocurre después.

**Figura 11**

*Flujo de la aplicación, de la primera vez a la decisión*

![1. Bienvenida](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/01-bienvenida.png) ![2. ¿Qué quieres hacer?](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/12-que-quieres-hacer.png) ![3. Todo listo](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/19-todo-listo.png) ![4. Inicio, mientras cuenta](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/21-inicio-contando.png) ![5. Suena el Tag](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/23-suena.png) ![6. Preguntas y decisión](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/24-que-decidiste.png) ![7. De vuelta en Inicio](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/25-inicio.png)

*Nota.* Elaboración propia: *wireframes* —esquemas de baja fidelidad, sin color ni imágenes— de la versión 2.32, la que usó la prueba. Preparar tiene seis pasos; aquí se ven el primero y el último.

**Figura 12**

*Pantallas del prototipo Android al preparar un ciclo*

[FIGURA POR INSERTAR: seis capturas de la versión 3.2 en el orden de la preparación: «¿Qué quieres hacer?», «¿Cómo empiezas?», «¿Dónde empiezas?», «¿Cuándo suena?», «¿Dónde suena?» y «Todo listo»]

*Nota.* Capturas del autor, versión 3.2 de la aplicación (12 de octubre de 2026), con un perfil de prueba. La prueba en los hogares usó la interfaz de la versión 2.30, con los mismos pasos y otra identidad visual.

**Una decisión por pantalla.** Preparar tiene seis pasos: qué quieres hacer, cómo empiezas, dónde empiezas, cuándo suena —qué aplicaciones cuentan y por cuánto tiempo, de 1 minuto a 6 horas—, dónde suena y la revisión. Cada pantalla pide una sola cosa, y el botón para seguir está siempre en el mismo lugar. Se descartó un formulario único, que obliga a leer todo antes de empezar. El primer paso y el lugar se eligen con un toque entre opciones concretas —«Abrir el libro», «En el velador»—, porque, en tareas experimentales, un mayor esfuerzo físico para fijar un recordatorio redujo su uso (Chiu y Gilbert, 2024); escribir sigue disponible. Los lugares son puntos precisos, nunca habitaciones enteras: una señal situada necesita un sitio reconocible.

**Probar antes de confiar.** En el paso «¿Dónde suena?», la persona hace sonar el objeto y confirma si lo oyó. La decisión vino del desarrollo: el Tag aceptaba la orden de sonar sin sonar, de modo que solo la persona puede confirmar que la señal se oye desde donde quedó.

**Corregir sin empezar de nuevo.** Desde la revisión final, cada dato se toca para cambiarlo, y un relevo activo puede editarse antes de sonar. Esta segunda posibilidad la pidió una de las personas de la prueba (Tabla 3).

**Figura 13**

*Contar, sonar y decidir*

![1. Inicio, con lo último que se preparó](anexos/imagenes/app-3.3-1-inicio.jpg) ![2. Suena: la actividad y su primer paso](anexos/imagenes/app-3.3-4-suena.jpg) ![3. Preguntas de un toque, que pueden saltarse](anexos/imagenes/app-3.3-5-preguntas.jpg) ![4. ¿Qué decidiste?, con tres respuestas del mismo peso](anexos/imagenes/app-3.3-6-decidir.jpg)

*Nota.* Capturas del autor, versión 3.3 de la aplicación (20 de octubre de 2026), con un perfil de prueba.

**Después de la señal.** La aplicación hace preguntas de un toque, que pueden saltarse, y cierra con «¿Qué decidiste?»: «Comencé la actividad», «La dejé para después» o «Cambié de idea», del mismo tamaño, color y lugar. Ninguna respuesta queda marcada de antemano. Las preguntas sirven a la prueba; en uso libre, solo la última tiene sentido para la persona.

**La primera vez.** Antes del primer relevo hay once pantallas (Figura 14): bienvenida, cuatro de «Cómo funciona», el consentimiento, los permisos, tres del perfil y una invitación a preparar el primero acompañada. Las tres personas de la prueba las completaron, pero el recorrido resultó largo; la iteración siguiente lo parte en una parte inicial y el resto más adelante.

**Figura 14**

*Registro de pantallas: la primera vez*

![](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/1-primera-vez.png)

*Nota.* Elaboración propia: *wireframes* de la versión 2.32 (18 de octubre de 2026). Cada pantalla lleva su número, su nombre y su función.

## La condición: cuándo suena

**Decisión.** La señal suena cuando las aplicaciones que la persona eligió suman, en primer plano, el tiempo que ella misma fijó. Se eligió esta condición porque es fácil de explicar y de ajustar; se descartaron, por ahora, la continuidad de uso y una franja horaria. En las herramientas por tiempo, la duración sirve para deducir que una sesión es un problema, lo que el criterio 1 descarta; aquí es un umbral que la persona fija de antemano, para un relevo en que ya declaró otra actividad.

**Una objeción y su respuesta.** El conteo no distingue una conversación o un tutorial de un desplazamiento rutinario. Por eso la persona elige qué aplicaciones cuentan, y cada relevo emite una sola señal. La prueba mostró que el límite también se ajusta con el uso: una persona lo bajó de 45 a 35 minutos porque, al sonar, ya estaba inmersa en un video.

**Activación manual.** Cada relevo se activa a mano. Una activación automática, apagada por defecto, repite el último relevo cuando la persona abre una de sus aplicaciones, con 30 minutos de pausa entre uno y otro: reduce el esfuerzo (criterio 6), pero la actividad deja de elegirse en el momento y la señal puede llegar durante un uso que la persona quería mantener (criterios 1 y 5). Por eso es opcional.

**El lugar.** Lo elige la persona —junto al libro para leer o a los materiales para dibujar—; el sistema no lo detecta. Cada reubicación exige probar de nuevo la señal, que puede oírse peor o conservar una asociación anterior.

## La arquitectura de información

**Decisión.** La aplicación tiene tres destinos, en una barra inferior: Inicio, Ruta y Perfil (Figura 15). Los destinos se nombran con sustantivos y las acciones, con verbos («Preparar un relevo», «Activar el relevo»), para que la persona distinga dónde está de lo que puede hacer.

**Figura 15**

*Arquitectura de información de la aplicación*

[FIGURA POR INSERTAR: esquema de arquitectura de información: Inicio | Lo más próximo, en una sola tarjeta | Preparar un relevo (seis pasos), Tu relevo mientras cuenta, Suena, Preguntas y decisión; Ruta | Los pasos de una actividad | El paso actual, Editar la ruta, Preparar un relevo con este paso; Perfil | Lo que es de la persona | Tu semana, Tus relevos, Tus actividades, Apariencia, Avisos, Permisos, Privacidad y datos, Cómo funciona, Cómo usar el Tag]

*Nota.* Elaboración propia a partir de la versión 3.3. Las pantallas de la prueba, para el investigador, quedan ocultas en Perfil. El registro de las 39 pantallas, en *wireframes*, está en el Anexo F.

**Jerarquía.** Inicio muestra solo lo más próximo, en una tarjeta principal: el relevo que está contando, la vuelta después de una señal, el siguiente paso de la ruta o la pregunta «¿Tienes algo en mente?». Se descartó un tablero con todo a la vez, que convierte la aplicación en algo que hay que revisar. Ruta guarda los pasos de una actividad que la persona quiere sostener, con el actual en grande y sin porcentajes de avance. Perfil reúne lo que es de la persona: sus relevos, sus actividades, sus ajustes y sus datos.

**Lo que mostró la prueba.** La pantalla del relevo mientras cuenta ofrece demasiada información; la iteración siguiente deja la actividad, el tiempo que falta y una sola acción a la vista.

## El lenguaje visual de la interfaz

**Decisión: la referencia de iOS.** La interfaz toma el lenguaje visual de iOS 26: vidrio solo en la navegación, formas redondeadas, cápsulas, contenido a pantalla completa y emoji tridimensionales en el perfil. El autor la pidió el 27 de septiembre de 2026, después de ver una versión plana de la aplicación: una interfaz hermosa y fácil, sin sobrediseñar ni sobreexplicar, con transparencias y desenfoques sutiles en vez de brillos. Se apoyó en las pautas con que Apple presentó ese lenguaje (Apple, 2025a).

**Por qué sirve a Relevo.** Relevo se abre pocas veces al día y, cuando se abre, no debe pedir que se aprenda ni quedarse con la atención: su trabajo es devolverla a otra actividad. La referencia de iOS responde a esas dos exigencias. Por familiaridad: sus convenciones —una barra inferior, hojas que suben desde abajo, un botón principal al pie— son habituales en las aplicaciones de uso diario, y las personas prefieren que una interfaz funcione como las que ya conocen (Yablonski, s. f.). Por jerarquía: en ese lenguaje el vidrio queda en la navegación y el contenido adelante (Apple, 2025a), de modo que la aplicación se aparta y lo importante es la actividad, como propone la tecnología calma (Weiser y Brown, 1997). Y por coherencia: las cápsulas y los bordes redondeados prolongan las formas circulares de la marca. La Tabla 2 relaciona cada elemento con el principio que lo justifica. [CONFIRMAR: otras razones del autor para preferir el lenguaje de iOS]

**Tabla 2**

*Lo que Relevo toma de iOS y el principio que lo justifica*

| Elemento | Cómo se aplica en Relevo | Principio de interacción o usabilidad |
| --- | --- | --- |
| Barra de pestañas inferior | Tres destinos: Inicio, Ruta y Perfil. | Ley de Jakob: se espera que funcione como otras aplicaciones; ley de Hick: con pocas opciones, se elige antes. |
| Vidrio solo en la navegación | Barras y hojas de vidrio; la actividad y su primer paso, adelante. | Jerarquía: la navegación se distingue del contenido sin taparlo (Apple, 2025a). |
| Botón principal al pie, de ancho completo | «Seguir» y «Activar el relevo», siempre en el mismo lugar. | Ley de Fitts: un objetivo grande y cercano al pulgar se alcanza antes. |
| Cápsulas de un toque | El primer paso, el lugar y el tiempo se eligen entre opciones concretas. | Ley de Hick, y menos esfuerzo para fijar un recordatorio (Chiu y Gilbert, 2024). |
| Hojas que suben desde abajo | «Elige las apps» y «Cómo usar el Tag». | Mantener el contexto: el paso en curso queda visible detrás. |
| Efectos contenidos | Sin desenfoque en los bordes desde la versión 2.28. | Umbral de Doherty: la interacción fluye si la interfaz no hace esperar. |
| Una estética cuidada | Formas redondeadas, emoji tridimensionales y los colores de la marca. | Efecto estética-usabilidad: lo que se percibe bello tiende a percibirse más fácil de usar. |

*Nota.* Elaboración propia. Las leyes de Jakob, Fitts y Hick, el umbral de Doherty y el efecto estética-usabilidad, según su resumen en Yablonski (s. f.).

**Lo que se descartó y lo que costó.** Material Design, la convención de Android, quedó para los íconos y el color, y los permisos, las notificaciones y el botón atrás siguen siendo los del sistema. La decisión reemplazó una regla anterior del propio proyecto, que prohibía el vidrio y las cápsulas. Tuvo un costo medido: en el emulador, el desenfoque de los bordes hacía lentos el 72 % de los cuadros, y desde la versión 2.28 los bordes no se desenfocan.

**Imágenes y color en la interfaz.** Las actividades se representan con un degradado de color y un ícono, que reemplazaron a las fotos de las primeras versiones [CONFIRMAR: por qué se dejaron las fotos]. El perfil usa un emoji y no pide una foto de la persona. El texto sobre un fondo cambia a claro u oscuro según su luminosidad, para cumplir el contraste mínimo (World Wide Web Consortium, 2024).

**Accesibilidad.** «Letra grande» suma un 15 % al tamaño que ya usa la persona, hay tema claro y oscuro, el movimiento se apaga si Android lo pide y el color nunca va solo: lo acompañan una palabra y un ícono, como piden las WCAG 2.2 (World Wide Web Consortium, 2024). El lector de pantalla y la letra grande no se comprobaron en un teléfono real.

## La escritura de la interfaz

**Decisión.** La aplicación habla de tú, en frases cortas, con un tono cercano, tranquilo y concreto. Pregunta en vez de rotular —«¿Cómo empiezas?»— y sus botones empiezan con un verbo. Evita las palabras que convierten una intención en deber: *meta*, *objetivo*, *hábito*, *tarea*, *alarma*, *progreso*, *logro*. No usa rachas, puntos, comparaciones entre días ni mensajes que culpen o apuren: dice «Prepáralo con calma» y no «¡Vamos, tú puedes!».

**Por qué.** Una señal que se vive como orden o evaluación contradice la autonomía que el proyecto quiere proteger (Ryan y Deci, 2000), y romper una racha desanima a seguir (Silverman y Barasch, 2023). Las pautas de escritura de Apple (2025b) orientaron la claridad y la brevedad. En las entrevistas, una persona rechazó expresamente las calificaciones y comparaciones entre días (P7, Q13).

**Lo que mostró la prueba.** El paso del perfil «Elige tu emoji» describe lo que se ve en vez de preguntar por la persona; pasará a «¿Con qué te identificas?» o una pregunta semejante.

## La identidad

**Nombre.** Relevo es breve, se pronuncia sin dudas y no usa el vocabulario del bloqueo o de la desintoxicación digital. Como «relevo» también evoca deporte, turnos y reemplazos, su registro tendría que comprobarse antes de un uso comercial. El descriptor es «Un recordatorio físico preparado desde el teléfono» [CONFIRMAR: frase de marca definitiva].

**Logo.** Cuatro círculos se pasan el turno en el sentido del reloj, cada uno bajo el siguiente, y dejan el centro abierto: el tiempo, el primer paso, el lugar y la decisión (Figura 16). El tercero representa el lugar y no el objeto, porque el objeto del prototipo es provisional y lo que se estudia es el aporte del lugar. Las formas circulares se asocian con suavidad y cuidado (Jiang et al., 2016), y un logo que describe lo que hace la marca se evalúa mejor, sobre todo cuando la marca es nueva (Luffarelli et al., 2019). Las luces se superponen con trazos planos, sin transparencias, para que se reproduzcan igual en cualquier soporte. El nombre usa Chillax en peso semibold, elegida entre 20 tipografías porque su «o» es casi un círculo y conserva la forma en tamaños pequeños.

**Figura 16**

*Sistema de identidad de Relevo*

[FIGURA POR INSERTAR: lámina de identidad: logotipo, luces, letra e íconos]

*Nota.* Elaboración propia. Identidad aprobada por el autor el 11 de octubre de 2026.

**Color.** La decisión cromática se apoya en la función, no en promedios de asociaciones emocionales. Cada color cumple un solo papel —tu tiempo, tu primer paso, el lugar, lo que decides, la personalización y el después—, y los seis tienen una luminosidad casi igual, para que ninguno resalte más que otro; la tinta sobre cada uno supera el contraste de 4,5:1 que piden las WCAG 2.2 (World Wide Web Consortium, 2024). Los significados del color dependen del contexto y del producto (Elliot y Maier, 2014), y las asociaciones con emociones dividen a las personas: en un estudio de 31 países, el rosa se asoció con el amor en el 53,2 % de las personas y el rojo, en el 69,2 %, de modo que una parte importante no hizo esa asociación (Jonauskaite et al., 2024). Por eso las asociaciones no fundan la elección; solo sirvieron para evitar colores muy ligados a emociones negativas —el rojo se asoció con la rabia en el 55,2 %— y, junto con la convención de la señalética (International Organization for Standardization [ISO], 2011), para que ningún estado de la persona use negro, gris ni rojo. Ninguna de estas asociaciones se midió en este proyecto, y la marca no se ha probado con personas.

**Tipografía e íconos.** La letra es Instrument Sans, una grotesca de código abierto con ejes de peso y ancho, codiseñada por un diseñador radicado en Santiago; es legible en pantalla y en papel, y el trazo de los íconos se midió sobre su asta. Los 72 íconos son propios, en una retícula de 24 con trazo de 1,6, y siempre van con una palabra. Lo propio de Relevo se dibuja con sus ideas: el sonido como anillos, nunca como luz, y el primer paso como un punto en el primer peldaño. El camino que llevó a esta identidad, con las propuestas descartadas, está en el Anexo H.

## El objeto

**Del objeto de luz al objeto que suena.** El objeto cambió varias veces, y cada cambio respondió a una razón. En agosto se pensó en un objeto con luz sobre la mesa; en septiembre, en un testigo portátil con una placa XIAO, luz y sonido, y en un banco de pruebas con una micro:bit. Ninguno se construyó. El 25 de septiembre la señal pasó a ser solo sonora: la luz exige que la persona mire hacia el objeto, el sonido la alcanza aunque esté frente a una pantalla, y construir luz no cabía en el plazo. Por eso la luz salió por plazo, no por evidencia, y queda como límite: seis de las ocho personas entrevistadas habían pedido señales simples, calmadas o visuales (P1, P3–P5, P7 y P8, Q13).

**Por qué un Tag comercial.** Para probar la relación entre señal y lugar antes de fabricar un objeto propio, el prototipo usa un llavero antipérdida Bluetooth, el Tag. Se eligió porque responde a una orden estándar de alerta —sin la aplicación de su fabricante—, cuesta poco (la unidad comprada costó CLP 10.990 con envío), está disponible en Chile y funciona con una pila de botón. Los localizadores de ecosistema cerrado se descartaron porque no permiten ordenarles que suenen. Un prototipo puede usar medios más simples si conserva lo esencial (Nielsen, 1993, pp. 96–97): aquí, el lugar y la señal. El Tag se parece al objeto propuesto en el tamaño y en la planta sin frente, pero no en el sonido —un pitido continuo, de volumen fijo— ni en el control, porque su único botón también lo apaga [CONFIRMAR: medidas y peso del Tag].

**Figura 17**

*El Tag durante la prueba en el hogar*

![a. Un relevo preparado y el Tag en la mano, 7 de octubre de 2026](figuras/figura-4a-relevo-preparado.jpg) ![b. El Tag sobre un mueble del mismo hogar, 7 de octubre de 2026](figuras/figura-4b-tag-en-un-mueble.jpg) ![c. El Tag sobre un escritorio, 17 de octubre de 2026](figuras/figura-4c-tag-en-un-escritorio.jpg)

*Nota.* En a, la pantalla muestra la actividad, el primer paso y el lugar donde sonará el Tag. Se difuminó el nombre de la persona y se recortaron otras pantallas y objetos. El Tag sustituye al testigo y no representa su forma. [CONFIRMAR: autoría de las fotografías, autorización de las personas para publicarlas y de quién es el lugar de c]

**El testigo.** El objeto propio, el *testigo*, se diseñó como una carcasa que lleva dentro la placa y la pila del Tag: así el Bluetooth y el sonido siguen siendo los probados, y la forma, el control y la marca pasan a ser diseño propio (Figura 18). Mide 46 mm de diámetro y 12,3 mm de alto, dentro de la envolvente definida para el testigo (de 42 a 48 mm por 12 a 16 mm), y no tiene frente, para poder dejarse en cualquier orientación. El logo, calado sobre un fondo con sus cuatro colores, es el botón: baja 0,45 mm y un tope protege el botón del Tag. Se descartaron una lengüeta flexible, porque el plástico se fatiga, y un botón aparte, que rompía la simetría. La tapa se abre con una moneda, como la del Tag, para cambiar la pila sin herramientas; una tapa a presión se gasta y una de bayoneta necesita un resorte. El modelo es paramétrico y se imprime en PLA sin soportes; solo una pieza, el chasis, depende de la placa. Al cierre de este documento, el testigo está modelado y no impreso [CONFIRMAR: estado de la impresión].

**Figura 18**

*El testigo: un objeto propio con la placa del Tag adentro*

![a. El testigo armado, de 46 mm de diámetro](../06_desarrollo_y_factibilidad/testigo-impresion-3d/vistas/testigo-heroe.png) ![b. Sus cinco piezas, con la placa y la pila del Tag](../06_desarrollo_y_factibilidad/testigo-impresion-3d/vistas/testigo-explosion.png) ![c. Corte: el medallón del logo hace de botón](../06_desarrollo_y_factibilidad/testigo-impresion-3d/vistas/testigo-corte.png)

*Nota.* Elaboración propia: modelo 3D del autor, versión 0 (28 de octubre de 2026). Las medidas de la placa del Tag son estimadas hasta medirla.

**Por qué más grande que el Tag.** El testigo es mayor que el Tag por tres razones. La primera es encontrarlo: un objeto que debe hallarse para silenciarlo no puede perderse ni quedar tapado sobre una mesa, un riesgo que el proyecto ya había anotado para un objeto pequeño y transportable. La segunda es el control: en la prueba, una persona contó que nunca encontró ni sintió el botón del Tag; un botón del tamaño del logo se ve y se siente. La tercera es construirlo: la rosca, el tope del botón y el logo calado necesitan espacio para imprimirse con detalles de al menos 1,3 mm.

**Un porta Tag, para cualquier Tag.** La misma idea puede crecer hacia un soporte: una carcasa que reciba distintos localizadores compatibles, de modo que el objeto deje de ser una pieza única y la persona pueda usar el Tag que tenga. El modelo ya lo permite, porque solo el chasis depende de la placa. Tiene un límite: sirve para los localizadores que aceptan la orden estándar de alerta, no para los de ecosistema cerrado, y la compatibilidad de cada modelo debe comprobarse; la unidad comprada, por ejemplo, necesitó una característica propia de su fabricante para sonar. En la aplicación, la iteración siguiente ofrecerá una salida para quien no tiene el objeto: «¿Tienes un Tag? No: consíguelo acá».

## La señal

**Solo sonido, de unos 30 segundos.** La señal es sonora porque debe alcanzar a quien mira una pantalla, quizá desde otra habitación: una luz exige línea de visión, y una vibración, contacto. Dura unos 30 segundos y termina sola, para ser más que una notificación y menos que una alarma; una de 3 segundos, pensada para acompañar una luz, no se oiría sin ella. La duración tensiona lo que prefieren las personas: en la encuesta, 41 de 53 eligieron 15 segundos o menos. Se mantuvo para la prueba, y puede acortarse si el uso lo pide.

**La firma sonora.** En el teléfono y en un parlante, la señal es una firma propia: dos golpes de un timbre de madera que descienden, de 587 a 440 Hz, repetidos siete veces, con las tres primeras al 40, 60 y 80 % del volumen. Un contorno que desciende y un tono más grave se perciben como menos urgentes (Edworthy et al., 1991), menos repeticiones bajan la urgencia (Hellier et al., 1993) y un timbre de banda ancha ayuda a ubicar de dónde viene el sonido (Middlebrooks y Green, 1991). En el Tag, en cambio, suena su pitido de fábrica, continuo y de volumen fijo, y la firma no se oye; el testigo, con la placa del Tag, conserva ese límite.

**Si el objeto no responde.** Mientras el relevo espera, la aplicación mantiene la conexión con el Tag y la reabre si se corta. Si al cumplirse el tiempo el objeto no responde, el teléfono vibra, avisa con una notificación y registra la señal como fallida, sin cambiar de salida por su cuenta. Tras la revisión con los profesores, el autor decidió cambiar este comportamiento: la aplicación intentará conectarse al Tag antes de que termine el tiempo y, si no lo logra, sonará en el teléfono. Así la persona no pierde el relevo por un fallo técnico.

## Autonomía, privacidad y datos

**Decisión.** Ninguna función obliga ni vigila más de lo necesario. No responder a la señal no produce repeticiones ni reproches; las funciones que recuerdan el sistema son opcionales, y la notificación tras una semana sin abrir la aplicación viene apagada. La notificación de la pantalla bloqueada es genérica, para no exponer la intención a quienes conviven con la persona, y una sección, «Qué no vemos», explica lo que la aplicación no registra.

**Datos.** El prototipo guarda en el teléfono lo que la persona prepara, los eventos de cada ciclo y sus respuestas, y, con su consentimiento, envía una copia a un servicio remoto identificada con un código aleatorio; el nombre se guarda aparte. Los datos están seudonimizados, no anónimos, porque actividades, lugares y horarios podrían identificar a alguien. La persona puede retirar el consentimiento y borrar sus datos desde la aplicación; el marco legal y los plazos se tratan más adelante.

**Lo que el prototipo aún no cumple.** El diseño pide volumen regulable y un control que no exija movimientos precisos; el Tag no cumple ninguna de las dos condiciones, y ambas pasan a ser requisitos del testigo. La señal sonora excluye a personas con baja audición; una alternativa visual o táctil se estudiaría como adaptación. Y, al sonar, la notificación del teléfono nombra la actividad y añade «Es momento de volver a elegir. Empieza por…», una instrucción que el diseño de la señal excluye.

## Del diseño al prototipo: las iteraciones

El prototipo se construyó por iteraciones cortas: cada versión respondió a un aprendizaje del desarrollo o del uso (Tabla 3). Las del 14 y el 17 de octubre corrigieron lo que contaron las personas de la prueba. La línea visual nueva, de las versiones 3.x, llegará a las personas al terminar la prueba, para no cambiar la interfaz a mitad de ella.

**Tabla 3**

*Iteraciones del prototipo y aprendizajes que las motivaron*

| Versión y fecha (2026) | Cambio | Aprendizaje que lo motivó |
| --- | --- | --- |
| Hasta la 2.6, 21–24 de septiembre | Preparación, conteo de una o varias aplicaciones y tono por parlante o teléfono. | El recorrido podía ensayarse sin un objeto propio. |
| 2.7, 25 de septiembre | Señal de unos 30 segundos que termina sola; condición de prueba por semana; preguntas tras cada señal. | Una señal que no se detiene insiste; una de 3 segundos no se oiría. |
| 2.9–2.10, 27 de septiembre | Lenguaje visual de iOS 26: vidrio en la navegación, cápsulas y emoji. | El autor pidió una interfaz hermosa y fácil, sin sobrediseñar ni sobreexplicar. |
| 2.16, 30 de septiembre | Activación automática opcional. | Preparar cada ciclo añadía esfuerzo. |
| 2.19, 5 de octubre | Salida por localizador Bluetooth. | Se buscaba un objeto barato y ya fabricado; el parlante, además, puede reproducir el audio de otras aplicaciones. |
| 2.22–2.23, 6–7 de octubre | Se restablece la comparación por semanas; opciones de un toque. | La elección libre impedía comparar lugares; escribir añadía carga. |
| 2.26–2.29, 7 de octubre | Confirmación en la prueba de sonido; pitido continuo; Tag por defecto. | Que el Tag acepte la orden no prueba que haya sonado. |
| 2.30, 9 de octubre | Edición de un ciclo activo. | Una de las personas participantes pidió corregir un ciclo sin borrarlo. |
| 3.0–3.2, 12 de octubre | Identidad visual nueva en toda la interfaz, sin cambiar datos ni lógica. | El autor aprobó una identidad nueva. |
| 2.31, 14 de octubre | El Tag se calla con confirmación, y la aplicación muestra y registra la carga de su pila. | Una de las personas participantes contó que el Tag siguió sonando después de la prueba de sonido y, más tarde, sin parar. |
| 2.32, 17 de octubre | La aplicación nunca corta la conexión con la alarma del Tag encendida y espera más a un Tag que responde lento. | Después de horas sin uso, el Tag sonaba lento y sin parar hasta que la persona le sacaba la pila. |
| 2.33 y 3.3, 20 de octubre | Una semana para comparar con el teléfono, con sus propias preguntas; la línea visual nueva suma las correcciones del Tag. | Sin condición asignada, la aplicación no hacía las preguntas semanales ni las de cierre. |

*Nota.* Elaboración propia a partir del registro de versiones del prototipo (Anexo G). Las versiones 2.x mantienen la interfaz que usa la prueba; las 3.x, la identidad nueva.

# 12. Factibilidad y límites

## Plataforma y arquitectura técnica

Un diseño también tiene que poder hacerse: con qué tecnología, a qué costo y con quiénes. El prototipo se desarrolló para Android 12 o posterior porque este sistema permite, con documentación oficial, las dos cosas que Relevo necesita: saber cuánto se usan otras aplicaciones, con permiso de la persona (Google, 2026b), y comunicarse con un objeto cercano por Bluetooth (Google, 2026a). Un sitio web no puede consultar el uso de otras aplicaciones, y en iPhone hacerlo exige autorizaciones especiales de Apple (Apple Developer, s. f.); abarcar los dos sistemas habría duplicado el trabajo antes de examinar la hipótesis.

Entre el teléfono y el Tag viajan datos de control, no audio: el Tag recibe la orden de sonar y de callar, nunca el texto de la intención. UsageStatsManager exige un permiso especial que se concede desde los ajustes (Google, 2026b), y Android cierra la conexión Bluetooth si el sistema termina el proceso de la aplicación (Google, 2026a); por eso la aplicación mantiene una notificación permanente mientras un relevo cuenta.

## Fabricación, mantenimiento y costos

El prototipo no exigió fabricación: su componente físico es un producto terminado, y su mantenimiento se reduce a cambiar la pila CR2032, cuya duración —entre 2 y 8 meses, según los vendedores— no se midió con la conexión que Relevo mantiene. El testigo se imprime en PLA en unos 32 minutos y con menos de 15 g de material; su costo depende del servicio de impresión, no del material.

Se distinguen cuatro montos: el costo del prototipo académico (Tabla 4), el trabajo profesional, la producción con su soporte y un posible precio. El trabajo puede valorarse con el ingreso de quienes se titulan de Diseño en Chile: entre 5750 y 8480 pesos por hora el primer y el quinto año, en pesos de septiembre de 2025 y con 42 horas semanales (Ley 21561, 2023; Ministerio de Educación, s. f.). Las 186 horas del proyecto —114 registradas entre el 23 de agosto y el 27 de octubre de 2026 y unas 72 estimadas del primer semestre— equivalen a entre 1 070 000 y 1 577 000 pesos, varias veces el desembolso. Los dos últimos montos solo podrán cotizarse si la prueba justifica fabricar el testigo.

**Tabla 4**

*Presupuesto del prototipo académico*

| Ítem | Valor (CLP) | Fecha y fuente |
| --- | --- | --- |
| Tag con pila CR2032 | 10 990 | Una unidad comprada en octubre de 2026: 7990 el producto y 3000 el envío. |
| Teléfono Android | Sin costo | No se compró: quienes participaron usaron sus propios teléfonos. |
| Servicio remoto de datos | Sin costo | Plan gratuito de Supabase, que cubre la escala de la prueba (Supabase, s. f.). |
| Herramientas de inteligencia artificial | unos 171 000 | Entre marzo y octubre de 2026, cinco meses de ChatGPT Plus a 19 990 (OpenAI, s. f.) y tres de Claude Pro a 20 dólares más impuestos (Anthropic, s. f.), al dólar observado del 27 de octubre (Mindicador, 2026). |
| Total desembolsado | unos 182 000 | — |

*Nota.* CLP = pesos chilenos. Los montos de las suscripciones son aproximados.

## Modelo de gestión

El modelo tiene tres etapas, y cada una se inicia solo si la anterior entrega evidencia. **El proyecto académico**, de agosto a diciembre de 2026, lo conduce el autor, con la orientación de los profesores guía y la colaboración de quienes participan en la prueba. Sus costos son los de la Tabla 4 más el trabajo del autor, que los financia. Su resultado es conocimiento, no un bien en venta.

**Un piloto** tendría que establecer si situar la señal aporta. Ampliaría la prueba a las seis personas previstas, con un testigo por hogar y revisión especializada en accesibilidad, protección de datos y electrónica. Con precios de octubre de 2026, cada hogar supondría entre 10 100 y 12 150 pesos: el localizador, una pila de repuesto y la carcasa impresa, estimada al repartir entre seis el mínimo de 14 800 por trabajo de un servicio nacional (MCI Electronics, s. f.; Rabbit Hole, s. f.).

**El producto** se abriría solo si el piloto alcanzara los umbrales previstos, por una de dos vías: la aplicación con un porta Tag que reciba localizadores compatibles, sin fabricar electrónica, pero sujeta a modelos que varían y a funciones que no se ajustan del todo (Gembali, 2023, p. 53), o un testigo propio en series cortas, que permitiría diseñar el sonido y el control y obligaría a cotizar circuito, carcasa, batería, ensayos y soporte. Elegir entre ellas, y entre venta, suscripción o distribución institucional, requiere conocer el costo unitario, el de cumplir la normativa y la disposición a pagar.

## Seguridad y condiciones de distribución

Un testigo con electrónica propia sería un equipo de radio nuevo, sujeto a la normativa chilena de equipos de alcance reducido: desde el 22 de febrero de 2026 requiere un informe de ensayo de un laboratorio acreditado, una declaración de conformidad y un código QR que remita a su información técnica en español (Subsecretaría de Telecomunicaciones, 2026). Para un localizador comercial, esa exigencia corresponde a quien lo fabrica o importa, aunque recomendarlo obligaría a verificar que el modelo la cumple. La pila de botón exige un cierre que no se abra sin herramienta, como la tapa con moneda del testigo, porque es peligrosa si se traga.

La aplicación se distribuye hoy como archivo instalable fuera de la tienda. Publicarla en Google Play exigiría declarar su servicio en primer plano, con una descripción y un video que lo muestre (Google, s. f.-b), y revisar las políticas sobre permisos que dan acceso a información sensible.

## Límites de factibilidad

La colaboración interdisciplinaria fue indirecta: la literatura, la documentación técnica y la orientación de los profesores guía. Quedan para la etapa siguiente la condición de activación definitiva, el sonido y el control de un testigo con electrónica propia, la autonomía del localizador, el consumo del teléfono y los costos de producción. El alcance excluye adicción, tratamiento clínico, control parental, vigilancia y reducción del tiempo de pantalla.

# 13. Plan de desarrollo y validación

Lo diseñado se puso a prueba en el uso real. El desarrollo avanzó desde la asociación básica entre intención, señal y lugar hacia un prototipo integrado y su uso cotidiano; en cada etapa aumentó la *fidelidad* del prototipo, su semejanza con el uso previsto. La evaluación usa un objeto comercial —el Tag— y examina la relación entre señal, lugar e intención, no la forma del objeto.

## Estado de avance y verificación técnica

El uso de las tres personas comprobó el ciclo completo en sus teléfonos, con las versiones 2.29 a 2.32, y en las siete pruebas de sonido registradas oyeron el Tag al primer intento. Las versiones vigentes pasan sus pruebas automáticas (87 la 3.3 y la 2.33), y en el emulador se verificaron el envío y la eliminación de registros; el parlante y el reloj quedan como salidas alternativas, sin uso real.

La prueba comenzó el miércoles 7 de octubre de 2026, cuando una de las personas preparó un relevo con el Tag (Figura 17a). Las tres aceptaron el consentimiento en la aplicación, y sus registros comienzan el 8, el 9 y el 10 de octubre [CONFIRMAR: fecha en que los profesores guía revisaron el consentimiento y si hubo sesión inicial presencial]. Las tres conservan la interfaz de la versión 2.30, para no cambiarla a mitad de la prueba.

## La prueba de 21 días: lo previsto y lo aplicado

La prueba se diseñó para responder la hipótesis. Comienza con una sesión en el hogar: la persona formula una intención y su primer paso, deja el objeto junto a ese primer paso y recibe una señal, mientras el investigador registra, sin dar pistas, si la percibe, si la atribuye a Relevo y si nombra la intención y el primer paso. Siguen tres semanas, cada una con una condición —el objeto junto al primer paso (A), el mismo objeto en un lugar neutro (B) y el teléfono (C)—, en un orden distinto para cada persona. Tras cada señal, la aplicación pregunta con un toque si la persona supo qué quería hacer antes de leerlo en la pantalla, si recordó cómo empezar y qué decidió; cada semana cierra con tres escalas, y el día 21, con preguntas de cierre y una entrevista. El protocolo completo está en el Anexo I.

Lo aplicado se apartó de lo previsto, y la Figura 19 muestra cómo. Participaron tres personas, no seis. Durante sus dos primeras semanas usaron el Tag junto al primer paso, sin condición asignada, y cada una fijó su propio límite, de 15 a 45 minutos. Desde el 21 de octubre usan la señal en el teléfono; esa semana termina el 30 de octubre, con un cierre en papel y una entrevista, y se informará al terminar.

**Figura 19**

*La prueba aplicada en los hogares*

[FIGURA POR INSERTAR: línea de tiempo de la prueba aplicada: 7 al 10 de octubre | Inicio | Cada persona acepta el consentimiento, prepara su primer relevo y deja el Tag junto a su primer paso; 8 al 20 de octubre | Con el Tag | Relevos libres, con el Tag junto al primer paso y preguntas tras cada señal; 21 al 30 de octubre | Con el teléfono | En curso: termina el 30 de octubre; 30 de octubre | Cierre | Cuestionario en papel y entrevista]

*Nota.* Elaboración propia. El diseño previsto era de seis personas y tres semanas, con una condición cada una y un orden distinto para cada persona.

## Alcance de la prueba y amenazas a la validez

Esta etapa, con tres personas, valida el uso real del ciclo: si es factible en un hogar, si la señal se comprende, cuánta carga supone y qué fallos aparecen. Como evaluación formativa, conviene repetirla en rondas pequeñas, de unas tres personas por iteración (Nielsen, 1993, p. 173). El aporte del lugar y del soporte corresponde a la comparación. Los teléfonos de dos personas no enviaron datos a la base remota: sus registros llegaron como archivos, capturas o mensajes y se reunieron a mano, un paso más en que pueden introducirse errores.

La asociación se conoce por autoinforme y, con una sola intención activa, es esperable un efecto techo; tampoco se distingue «no la oí» de «la ignoré». La notificación del teléfono muestra la actividad y el primer paso, lo mismo que luego se pregunta [CONFIRMAR: si se unificó a notificación genérica], y la cercanía entre el investigador y las personas puede inclinar las respuestas. En una etapa con más personas, la comparación más limpia es A frente a B, porque con el Tag ambas suenan distinto que C, y conviene sumar el rival digital más fuerte, una notificación con la intención escrita: los recordatorios más eficaces nombran a la vez la ocasión y la actividad (Guynn et al., 1998).

## Consideraciones éticas y protección de datos

La participación es voluntaria y sin pago. Las tres personas fueron reclutadas por cercanía [CONFIRMAR: que las tres son mayores de edad] y pueden omitir preguntas, silenciar la señal o dejar la prueba sin dar razones. El consentimiento vigente en la aplicación, del 6 de octubre de 2026, explica el propósito académico, los datos registrados, la molestia que el sonido puede causar y cómo retirarse; los profesores guía lo revisaron antes de la prueba. No hubo comité de ética [CONFIRMAR: si la Escuela exige alguna instancia de revisión ética].

Los registros son datos seudonimizados, no anónimos; su copia remota se aloja en Canadá, y el consentimiento declara la lectura del uso desde 7 días antes de aceptar. El consentimiento nombra el servicio remoto, pero no el panel del investigador, y no se prevé informar a quienes conviven con la persona, que también oyen la señal. El tratamiento se rige por la Ley 19628 (1999), con las modificaciones de la Ley 21719 (2024) desde el 1 de diciembre de 2026. Los registros se eliminan cuando la persona lo pide y, a más tardar, el 30 de diciembre de 2026; al cierre deberá comprobarse que no quede copia en el teléfono.

## Registro de evidencia y criterios de decisión

La medida principal es el número de señales tras las cuales la persona responde que supo qué quería hacer, sobre el total de señales válidas; un fallo de conexión, del objeto o de la aplicación excluye esa señal. Las secundarias son el recuerdo del primer paso, la decisión declarada, el tiempo de respuesta, las escalas y la entrevista de cierre, que completan el registro automático: este muestra qué hizo la persona, pero no por qué (Nielsen, 1993, p. 221). El uso de las aplicaciones es contexto, no resultado, porque reducir el tiempo de pantalla no es un objetivo. Con tres personas, el análisis es descriptivo y por caso: recuentos, sin porcentajes. La propuesta se mantiene si la señal se relaciona con la intención y la persona entiende sus opciones, y se modifica si falla una parte; un fallo crítico de autonomía, privacidad, seguridad o accesibilidad impide avanzar.

## Resultados

Entre el 8 y el 19 de octubre de 2026, el ciclo completo funcionó en los hogares de las tres personas. Activaron 31 relevos, todos con el Tag, y siete se eliminaron o editaron antes de sonar. De los 24 que alcanzaron su límite, el Tag sonó en 23 (Figura 20). Hubo 21 respuestas posteriores a una señal, siete de cada persona: en las 21, la persona recordó cómo empezar su actividad; en 19 supo qué quería hacer antes de leerlo en la pantalla, y en 2, a medias.

**Figura 20**

*Lo que ocurrió en los 24 relevos que alcanzaron su límite*

[FIGURA POR INSERTAR: cuatro datos en tarjetas: 23 de 24, ciclos completados en que sonó el Tag; 19 de 21, respuestas en que la persona supo qué quería hacer antes de leerlo, y 2 a medias; 21 de 21, respuestas en que recordó el primer paso; 10 de 21, respuestas en que declaró haber empezado la actividad]

*Nota.* Las tres personas, del 8 al 19 de octubre de 2026. Recuentos de los registros de la aplicación.

Con tres personas, el detalle de cada caso dice más que un total (Figura 21). Cada una repitió sus actividades en un mismo lugar, con sus propias aplicaciones y su propio límite. Separar los casos cambia la lectura. Las personas empezaron la actividad en 10 respuestas, la dejaron para después en 9 y cambiaron de idea en 2, pero la mitad de los comienzos corresponde a una sola persona: la primera empezó en cinco de sus siete respuestas; la segunda, en tres, y la tercera, en dos. Como las tres respondieron el mismo número de veces, la diferencia está en lo que cada una hizo, no en cuánto participó. De las dos respuestas «a medias», una es de la primera persona. El sonido les pareció bueno en 10 respuestas, neutro en 9 y malo en 2, y las dos malas no son de la primera persona. La señal se calló desde el teléfono en nueve ciclos y con el botón del Tag en cinco; sonó completa en siete y quedó interrumpida en dos [CONFIRMAR: el detalle por persona de las demás respuestas, que da el resumen de unir-datos.js].

**Figura 21**

*Qué decidió cada persona después de la señal*

[FIGURA POR INSERTAR: resultados por persona: Primera persona, desde el 8 de octubre | Estudiar, ordenar su pieza o dibujar · Tag en su escritorio · 15 minutos de Instagram, X o YouTube · 7 ciclos | 7 | 5; Segunda persona, desde el 9 | Tocar guitarra · Tag junto a la guitarra · 45 minutos y, desde el 15, 35 de Instagram, YouTube o Reddit · 8 ciclos | 7 | 3; Tercera persona, desde el 10 | Dibujar en su croquera · Tag en su escritorio · 25 minutos de TikTok · 9 ciclos | 7 | 2]

*Nota.* Cada punto es una respuesta posterior a una señal; los puntos llenos, las veces en que la persona declaró haber empezado su actividad. Del 8 al 19 de octubre de 2026.

Dos hallazgos orientan el diseño. El primero es que la señal situada pertenece al lugar de la actividad: el único ciclo sin sonido se activó fuera de casa, con el Tag fuera de alcance; el teléfono vibró, la aplicación registró la señal como fallida y, según el protocolo, esa señal se excluye. El segundo es que recordar no obliga a empezar, porque una señal lleva a actuar solo si coincide con la motivación y la capacidad del momento (Fogg, 2009, p. 1; Figura 22). Es lo que pide el criterio 4: la señal devuelve la intención y la decisión sigue siendo de la persona.

**Figura 22**

*Recordar no basta para empezar*

[FIGURA POR INSERTAR: matriz de dos por dos: Motivación | Baja | Alta; Facilidad para empezar | Difícil | Fácil; Mucha motivación y comienzo difícil | Quiere hacerlo, pero el primer paso cuesta; Mucha motivación y comienzo fácil | La señal basta para empezar; Poca motivación y comienzo difícil | La señal recuerda, pero no lleva a empezar; Poca motivación y comienzo fácil | Puede empezar o dejarlo para después]

*Nota.* Elaboración propia a partir de Fogg (2009). Relevo actúa sobre la facilidad: deja la señal junto a un primer paso concreto.

Las personas también dijeron qué cambiarían. La primera pidió corregir un relevo sin borrarlo: «podrían implementar que se pueda actualizar o editar las opciones que uno ya eligió… así no tenemos que borrarlo y crearlo de nuevo». La segunda encontró el pitido demasiado fuerte, como una alarma —quien comparte su departamento preguntó qué sonaba—, y juzgó largo el límite de 45 minutos, porque al sonar ya estaba inmersa en un video. La tercera contó que la señal le sirvió cuando estaba en el escritorio, pero que de noche la oye desde la cama y no se levanta.

## Iterar con los resultados

Con tres personas, cada comentario pesa. Lo que mostró la prueba se convierte en cambios, y conviene separar los problemas técnicos —la mayoría, del objeto comprado— de los de uso (Tabla 5). Los técnicos se corrigieron durante la prueba, en las versiones 2.30 a 2.32; los de uso definen la iteración siguiente, que llegará con la línea visual nueva cuando la prueba termine.

**Tabla 5**

*Lo que mostró la prueba y cómo se itera*

| Hallazgo | Tipo | Cambio | Estado |
| --- | --- | --- | --- |
| El Tag siguió sonando tras la prueba de sonido y, más tarde, sin parar. | Técnico, del objeto comprado | Callar con confirmación y no cortar la conexión con su alarma encendida. | Hecho en las versiones 2.31 y 2.32 |
| Tras horas sin uso, el Tag sonaba lento hasta que se le sacaba la pila. | Técnico, del objeto comprado | Esperar más a un Tag que responde lento. | Hecho en la versión 2.32 |
| Fuera de casa, el Tag no sonó. | Técnico | Intentar conectarse antes de que termine el tiempo y, si no se logra, sonar en el teléfono. | Decidido; por implementar |
| Corregir un relevo exigía borrarlo y crearlo de nuevo. | Uso | Editar un relevo activo. | Hecho en la versión 2.30 |
| El botón del Tag no se encuentra ni se siente: la señal se calló con él en 5 ciclos y desde el teléfono en 9. | Uso, del objeto comprado | El logo del testigo como botón. | Diseñado en el testigo |
| El pitido sonó como una alarma y llegó a quien convive. | Uso, del objeto comprado | Volumen regulable como requisito del testigo. | Pendiente |
| La primera vez es larga: once pantallas. | Uso | Partirla en una parte al empezar y el resto después. | Por implementar |
| La pantalla del relevo muestra demasiada información. | Uso | Dejar la actividad, el tiempo que falta y una sola acción. | Por implementar |
| «Elige tu emoji» no pregunta por la persona. | Escritura | «¿Con qué te identificas?» o una pregunta semejante. | Por implementar |
| Un límite de 45 minutos resultó largo: al sonar, la persona ya estaba inmersa en un video. | Uso | Proponer un límite breve al empezar y sugerir revisarlo tras las primeras señales. | Propuesta |
| De noche, la señal se oye desde la cama y no lleva a levantarse. | Uso | Permitir que la persona excluya horas del día. | Propuesta |
| La respuesta fue «La dejé para después» en 9 de 21 señales. | Uso | Ofrecer, desde esa respuesta, preparar el relevo para otro momento, sin repetir la señal. | Propuesta |
| Sin el objeto, no hay cómo empezar. | Uso | «¿Tienes un Tag? No: consíguelo acá». | Por implementar |

*Nota.* Elaboración propia a partir de los registros y comentarios de las tres personas y de la revisión con los profesores del 28 de octubre de 2026. «Propuesta» indica un cambio que el autor aún no decide.

# 14. Conclusiones

El proyecto redefinió el problema: lo desplazó del tiempo de pantalla a que la persona recuerde a tiempo algo que quería hacer, y fijó una regla explícita de no intervención. Con esa base tomó decisiones de diseño en todas las escalas: un sistema que reparte el trabajo entre una aplicación, un objeto y un lugar; un recorrido de una decisión por pantalla; una arquitectura que muestra solo lo más próximo; una interfaz y una escritura que no presionan; una identidad que hace visible el ciclo, y un objeto propio, el testigo, que lleva adentro la placa del localizador probado. Cada decisión responde a un criterio, y cada criterio, a su evidencia.

El prototipo funciona en uso real. En los hogares de las tres personas que lo usaron, el localizador sonó en 23 de los 24 ciclos completados hasta el 19 de octubre; en sus 21 respuestas recordaron cómo empezar su actividad, y en 19 supieron qué querían hacer antes de leerlo en la pantalla. Los fallos que ellas reportaron se corrigieron en dos versiones, y lo que la prueba mostró sobre el uso define la iteración siguiente. La Tabla 6 resume el estado de cada objetivo.

**Tabla 6**

*Estado de los objetivos al cierre de este documento*

| Objetivo | Producto que lo demuestra | Estado |
| --- | --- | --- |
| 1. Caracterizar cómo se relacionan el ocio digital, su continuidad, las otras actividades que la persona quiere hacer y el contexto | Antecedentes, marco teórico, dos situaciones de usuario y comparación de referentes (capítulos 5 a 8) | Cumplido |
| 2. Traducir los hallazgos en una experiencia *phygital* | Ocho criterios, decisiones de diseño, prototipo Android con un Tag y testigo modelado (capítulos 9 a 11) | Cumplido con un objeto comercial; el testigo, modelado |
| 3. Comparar la señal junto al primer paso con un lugar neutro y con el teléfono | Protocolo de tres condiciones, implementado en la aplicación, y una semana con el teléfono (capítulo 13) | En curso: la semana con el teléfono cierra el 30 de octubre |
| 4. Evaluar comprensión, percepción, autonomía, funcionamiento técnico, convivencia y carga | Uso de tres personas en sus hogares y cierre en papel (capítulo 13) | Avanzado: funcionamiento, comprensión y uso continuado en tres hogares; escalas y entrevista de cierre en curso |

*Nota.* El objetivo general está cumplido en el diseño, con un objeto comercial en lugar del testigo, y avanza en la evaluación formativa: el ciclo está validado en tres hogares.

La pregunta de investigación se responde en dos partes. La primera —qué condiciones debe cumplir una ayuda— tiene una respuesta de diseño que ya funciona: la ayuda debe partir de una intención que la persona formula, vincularla con un primer paso reconocible, activarse con una condición que ella entiende y puede cambiar, y dejar abierta la posibilidad de ignorarla; cuando el ocio digital conserva sentido o no existe otra intención, lo adecuado es no intervenir. Construido con esas condiciones, Relevo devolvió la intención sin decidir por nadie: las tres personas recordaron cómo empezar, y cada una decidió a su manera si empezar, dejarlo para después o cambiar de idea. La segunda parte —si situar la señal donde comienza la actividad aporta algo frente a un lugar neutro o al teléfono— es el paso que sigue, y su comparación ya está implementada. El aporte del proyecto al diseño es haber convertido una tensión cotidiana en decisiones verificables —qué se recuerda, cuándo, dónde, con qué objeto y con qué opciones—, sin reducirla a una cuestión de disciplina.

## Alcances y proyecciones

El trabajo sigue en cinco pasos: cerrar la prueba e informar cada caso; aplicar la iteración que la prueba mostró —una primera vez más corta, una pantalla del relevo más simple y la conexión al Tag antes de que suene—; imprimir y probar el testigo, con volumen regulable como requisito; ampliar la prueba a más personas, con la notificación igualada y una condición con la intención escrita; y desarrollar el porta Tag si la señal situada supera al lugar neutro e iguala o supera al teléfono, sin añadir carga. Si no lo hace, la relación *phygital* deberá reformularse.

# Referencias

Anthropic. (s. f.). *Planes y precios*. Claude. Recuperado el 27 de octubre de 2026, de https://claude.com/es/pricing

Apple. (s. f.). *Set up Screen Time for yourself on iPhone*. Apple Support. Recuperado el 25 de septiembre de 2026, de https://support.apple.com/en-ie/guide/iphone/iphbfa595995/ios

Apple. (2025a). *Meet Liquid Glass* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/219/

Apple. (2025b, 16 de diciembre). *Writing*. Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/writing

Apple Developer. (s. f.). *Family Controls App and Website Usage*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/bundleresources/entitlements/com.apple.developer.family-controls.app-and-website-usage

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

Google. (s. f.-a). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Pixel Phone Help. Recuperado el 11 de octubre de 2026, de https://support.google.com/pixelphone/answer/9137850?hl=en

Google. (s. f.-b). *Understanding foreground service and full-screen intent requirements*. Play Console Help. Recuperado el 25 de septiembre de 2026, de https://support.google.com/googleplay/android-developer/answer/13392821?hl=en

Google. (2026a, 26 de febrero). *Communicate in the background*. Android Developers. https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (2026b, 28 de agosto). *UsageStatsManager*. Android Developers. https://developer.android.com/reference/android/app/usage/UsageStatsManager

Grüning, D. J., Riedel, F. y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), Artículo e2213114120. https://doi.org/10.1073/pnas.2213114120

Guynn, M. J., McDaniel, M. A. y Einstein, G. O. (1998). Prospective memory: When reminders fail. *Memory & Cognition, 26*(2), 287–298. https://doi.org/10.3758/BF03201140

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A. y Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (Artículo 243). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hellier, E. J., Edworthy, J. y Dennis, I. (1993). Improving auditory warning design: Quantifying and predicting the effects of different warning parameters on perceived urgency. *Human Factors, 35*(4), 693–706. https://doi.org/10.1177/001872089303500408

Hermann, M., Mahler, T., de Melo, G. y Weber, M. (2007). The Tangible Reminder. En *3rd IET International Conference on Intelligent Environments (IE 07)* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

International Organization for Standardization. (2011). *Graphical symbols — Safety colours and safety signs — Part 1: Design principles for safety signs and safety markings* (ISO 3864-1:2011).

Ishii, H. y Ullmer, B. (1997). Tangible bits: Towards seamless interfaces between people, bits and atoms. En *Proceedings of the ACM SIGCHI Conference on Human Factors in Computing Systems* (pp. 234–241). Association for Computing Machinery. https://doi.org/10.1145/258549.258715

Jiang, Y., Gorn, G. J., Galli, M. y Chattopadhyay, A. (2016). Does your company have the right logo? How and why circular- and angular-logo shapes influence brand attribute judgments. *Journal of Consumer Research, 42*(5), 709–726. https://doi.org/10.1093/jcr/ucv049

Jonauskaite, D., Epicoco, D., Al-Rasheed, A. S., Aruta, J. J. B. R., Bogushevskaya, V., Brederoo, S. G., Corona, V., Fomins, S., Gizdic, A., Griber, Y. A., Havelka, J., Hirnstein, M., John, G., Jopp, D. S., Karlsson, B., Konstantinou, N., Laurent, É., Marquardt, L., Mefoh, P. C., … Mohr, C. (2024). A comparative analysis of colour–emotion associations in 16–88-year-old adults from 31 countries. *British Journal of Psychology, 115*(2), 275–305. https://doi.org/10.1111/bjop.12687

Keppel, J., Strauss, M., Haliburton, L., Weingärtner, H., Dominiak, J., Faltaous, S., Gruenefeld, U., Mayer, S., Woźniak, P. W. y Schneegass, S. (2025). Situated artifacts amplify engagement in physical activity. En *Proceedings of the 2025 ACM Designing Interactive Systems Conference* (pp. 2959–2974). Association for Computing Machinery. https://doi.org/10.1145/3715336.3735690

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Kitchen Safe. (s. f.). *kSafe by Kitchen Safe: The time lock safe*. Recuperado el 25 de septiembre de 2026, de https://www.thekitchensafe.com/

Kolko, J. (2011). *Exposing the magic of design: A practitioner’s guide to the methods and theory of synthesis*. Oxford University Press.

Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W. y Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

Lee, J. G. W., Lee, B. y Choe, E. K. (2023). Decorative, evocative, and uncanny: Reactions on ambient-to-disruptive health notifications via plant-mimicking shape-changing interfaces. En *Proceedings of the 2023 CHI Conference on Human Factors in Computing Systems* (Artículo 320). Association for Computing Machinery. https://doi.org/10.1145/3544548.3581486

Ley 19628. (1999, 28 de agosto). Sobre protección de la vida privada. Biblioteca del Congreso Nacional de Chile. https://www.bcn.cl/leychile/navegar?idNorma=141599

Ley 21561. (2023, 26 de abril). Modifica el Código del Trabajo con el objeto de reducir la jornada laboral. Biblioteca del Congreso Nacional de Chile. https://www.bcn.cl/leychile/navegar?idNorma=1191554

Ley 21719. (2024, 13 de diciembre). Regula la protección y el tratamiento de los datos personales y crea la Agencia de Protección de Datos Personales. Biblioteca del Congreso Nacional de Chile. https://www.bcn.cl/leychile/navegar?idNorma=1209272

Luffarelli, J., Mukesh, M. y Mahmood, A. (2019). Let the logo do the talking: The influence of logo descriptiveness on brand equity. *Journal of Marketing Research, 56*(5), 862–878. https://doi.org/10.1177/0022243719845000

Lukoff, K., Yu, C., Kientz, J. y Hiniker, A. (2018). What makes smartphone use meaningful or meaningless? *Proceedings of the ACM on Interactive, Mobile, Wearable and Ubiquitous Technologies, 2*(1), Artículo 22. https://doi.org/10.1145/3191754

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M. y Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (Artículo 131). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

McDaniel, M. A. y Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*(7), S127–S144. https://doi.org/10.1002/acp.775

MCI Electronics. (s. f.). *Pila botón CR2032 de lithium para reloj*. Recuperado el 27 de octubre de 2026, de https://mcielectronics.cl/shop/product/pila-boton-cr2032-de-lithium-para-reloj-9838/

Meier, A. y Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Middlebrooks, J. C. y Green, D. M. (1991). Sound localization by human listeners. *Annual Review of Psychology, 42*, 135–159. https://doi.org/10.1146/annurev.ps.42.020191.001031

Mindicador. (2026). *Dólar observado* [Serie del Banco Central de Chile]. Recuperado el 27 de octubre de 2026, de https://mindicador.cl/api/dolar

Ministerio de Educación. (s. f.). *Estadísticas por carrera: Diseño*. Mi Futuro, Servicio de Información de Educación Superior. Recuperado el 27 de octubre de 2026, de https://www.mifuturo.cl/buscador-de-estadisticas-por-carrera/

Monge Roffarello, A. y De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53. https://doi.org/10.1145/3571810

Montag, C., Lachmann, B., Herrlich, M. y Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), Artículo 2612. https://doi.org/10.3390/ijerph16142612

Nielsen, J. (1993). *Usability engineering*. Academic Press.

Norman, D. A. (1990). *The design of everyday things*. Doubleday/Currency. (Obra original publicada en 1988)

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

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Silverman, J. y Barasch, A. (2023). On or off track: How (broken) streaks affect consumer decisions. *Journal of Consumer Research, 49*(6), 1095–1117. https://doi.org/10.1093/jcr/ucac029

Smit, E. S., Zeidler, C., Resnicow, K. y de Vries, H. (2019). Identifying the most autonomy-supportive message frame in digital health communication: A 2x2 between-subjects experiment. *Journal of Medical Internet Research, 21*(10), Artículo e14074. https://doi.org/10.2196/14074

Sohn, T., Li, K. A., Lee, G., Smith, I., Scott, J. y Griswold, W. G. (2005). Place-Its: A study of location-based reminders on mobile phones. En M. Beigl, S. Intille, J. Rekimoto y H. Tokuda (Eds.), *Lecture notes in computer science: Vol. 3660. UbiComp 2005: Ubiquitous computing* (pp. 232–250). Springer. https://doi.org/10.1007/11551201_14

Stapley, E., O’Keeffe, S. y Midgley, N. (2022). Developing typologies in qualitative research: The use of ideal-type analysis. *International Journal of Qualitative Methods, 21*, Artículo 16094069221100633. https://doi.org/10.1177/16094069221100633

Subsecretaría de Telecomunicaciones. (2025). *Informe final: Estudio duodécima encuesta sobre acceso, usos y usuarios de internet en Chile*. Ministerio de Transportes y Telecomunicaciones. https://www.subtel.gob.cl/wp-content/uploads/2026/02/Informe-Final-Acceso-y-Uso-Internet-2025_03.pdf

Subsecretaría de Telecomunicaciones. (2026, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Supabase. (s. f.). *Pricing*. Recuperado el 27 de octubre de 2026, de https://supabase.com/pricing

Terzimehić, N., Haliburton, L., Greiner, P., Schmidt, A., Hussmann, H. y Mäkelä, V. (2022). MindPhone: Mindful reflection at unlock can reduce absentminded smartphone use. En *Proceedings of the 2022 ACM Designing Interactive Systems Conference* (pp. 1818–1830). Association for Computing Machinery. https://doi.org/10.1145/3532106.3533575

Tonietto, G. N., Malkoc, S. A., Reczek, R. W. y Norton, M. I. (2021). Viewing leisure as wasteful undermines enjoyment. *Journal of Experimental Social Psychology, 97*, Artículo 104198. https://doi.org/10.1016/j.jesp.2021.104198

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Venegas Álvarez, S. A. (2026). *Gratitud digitalizada: un enfoque en el diseño de aplicaciones para fomentar la gratitud a través de la gamificación narrativa* [Memoria de título, Universidad de Chile]. Repositorio Académico de la Universidad de Chile. https://repositorio.uchile.cl/handle/2250/216623

Waggoner, J., Lucky, S., Redick, S., Rizki, A. y Yu, J. (2026). Going beyond digital libraries: A literature review of phygital user experience research methods. *International Journal on Digital Libraries, 27*(1), Artículo 1. https://doi.org/10.1007/s00799-025-00436-6

Weiser, M. y Brown, J. S. (1997). The coming age of calm technology. En P. J. Denning y R. M. Metcalfe (Eds.), *Beyond calculation: The next fifty years of computing* (pp. 75–85). Copernicus. https://doi.org/10.1007/978-1-4612-0685-9_6

World Wide Web Consortium. (2024, 12 de diciembre). *Web content accessibility guidelines (WCAG) 2.2*. https://www.w3.org/TR/2024/REC-WCAG22-20241212/

Yablonski, J. (s. f.). *Laws of UX*. https://lawsofux.com/

Zekveld, J., Bakker, S., Zijlema, A. y van den Hoven, E. (2017). Wobble: Shaping unobtrusive reminders for prospective memories in the home context. En *Proceedings of the Eleventh International Conference on Tangible, Embedded, and Embodied Interaction* (pp. 31–35). Association for Computing Machinery. https://doi.org/10.1145/3024969.3024984

Zimmerman, J., Forlizzi, J. y Evenson, S. (2007). Research through design as a method for interaction design research in HCI. En *Proceedings of the SIGCHI Conference on Human Factors in Computing Systems* (pp. 493–502). Association for Computing Machinery. https://doi.org/10.1145/1240624.1240704

# Glosario

**Activación automática.** Opción del prototipo, apagada por defecto, que repite el último ciclo cuando la persona abre una de las aplicaciones elegidas, con 30 minutos de pausa. Reduce el esfuerzo de preparar, pero la actividad deja de elegirse en el momento.

**Activar y desactivar.** Confirmar que un ciclo queda vigente para emitir la señal, o retirarlo antes de que suene. En el prototipo se hace desde la aplicación; el diseño original preveía confirmarlo con un control físico.

**Arquitectura de atención.** En esta memoria, conjunto de decisiones de interfaz que orienta lo que se percibe y cómo avanza la interacción, como el desplazamiento infinito o la reproducción automática.

**Autoinforme.** Dato que proviene de lo que la propia persona declara, no de la observación de su conducta.

**Autonomía.** En el sentido de la teoría de la autodeterminación, actuar por voluntad propia. En términos de diseño, depende de comprender la intervención y poder aceptarla, ajustarla o rechazarla.

**Bluetooth.** Comunicación inalámbrica de corto alcance y bajo consumo. En el prototipo lleva órdenes de la aplicación al Tag, no audio.

**Ciclo.** Periodo en que una intención y su condición de activación están vigentes. La interfaz de la aplicación lo llama «relevo».

**Condición de activación.** Evento que el teléfono puede comprobar y que la persona entiende, fija y puede modificar; cuando se cumple, suena la señal. En el prototipo es un límite, de 1 minuto a 6 horas, para el tiempo que las aplicaciones elegidas suman en primer plano.

**Condición de prueba.** Cada una de las tres disposiciones que compara la prueba de 21 días: A, el objeto junto al primer paso; B, el mismo objeto en un lugar neutro; C, el teléfono con una notificación genérica.

**Conflicto entre metas.** Tensión que aparece cuando una actividad dificulta otra también valorada, sin establecer cuál debería prevalecer.

**Criterio de diseño.** Condición que una propuesta debe cumplir para responder al problema y que sirve después para evaluarla. Esta memoria formula ocho.

**Datos seudonimizados.** Datos registrados con un código en lugar del nombre, que se guarda aparte. No son anónimos, porque su contenido —actividades, lugares y horarios— podría permitir identificar a la persona.

**Decisión renovada.** Momento en que la persona vuelve a considerar si desea continuar, cambiar o detenerse.

**Descarga cognitiva.** Recurso a una acción física, como anotar o disponer un objeto, para reducir la demanda cognitiva de una tarea (Risko y Gilbert, 2016).

**Desplazamiento infinito.** Patrón de interfaz que carga contenido nuevo a medida que la persona avanza, sin un final de página reconocible.

**Efecto techo.** Situación en que casi todas las respuestas alcanzan el valor más alto de una medida, de modo que esta deja de distinguir entre condiciones.

**Emulador.** Programa que reproduce en un computador el funcionamiento de un teléfono para probar la aplicación sin el equipo real. El usado en el proyecto no dispone de Bluetooth.

**Episodio.** Unidad de análisis: una situación concreta de ocio digital, con un inicio, una actividad, un propósito, otras intenciones posibles y una valoración posterior.

**Evaluación formativa.** Evaluación que busca identificar dificultades y orientar mejoras del diseño, no medir su eficacia (Nielsen, 1993).

**Fidelidad.** Grado de semejanza de un prototipo con el uso previsto.

**Fricción.** Esfuerzo adicional introducido en una interfaz, como esperar o confirmar, que puede abrir una ocasión de reconsiderar.

**Gamificación.** Uso de mecánicas propias de los juegos, como rachas, puntos y premios, en actividades que no son juegos.

**Herramienta de autocontrol digital.** Aplicación o función con la que una persona regula su propio uso de dispositivos mediante mediciones, límites, bloqueos, demoras o mensajes. También se la llama herramienta de bienestar digital.

**Intención.** Lo que la persona se propone hacer, como leer o dibujar. En esta memoria, la que quiere mantener presente mientras dura una sesión de ocio digital.

**Intención de implementación.** Plan que especifica de antemano cuándo, dónde y cómo actuar: si se presenta cierta situación, se inicia una respuesta (Gollwitzer y Sheeran, 2006).

**Interacción tangible.** Campo que estudia cómo los objetos y el espacio físico participan en la relación con la información digital. Abarca sistemas basados en la interacción corporal, la manipulación de objetos, la representación física de datos y su inserción en el espacio real (Ishii y Ullmer, 1997).

**Investigación a través del diseño.** Enfoque en que quien diseña integra resultados de investigación en un artefacto, y ese trabajo constituye un aporte (Zimmerman et al., 2007).

**Localizador Bluetooth.** Objeto pequeño y autónomo, vendido también como llavero antipérdida, que suena cuando la persona lo busca desde el teléfono. El prototipo usa uno comercial, circular, con pila de botón y un solo botón.

**Lugar neutro.** Ubicación visible de la casa, a más de un metro del primer paso y sin relación con la actividad. En la prueba se compara con el lugar junto al primer paso.

**Marco multiproceso.** Explicación de la memoria prospectiva según la cual una intención puede volver porque la persona vigila el entorno o porque un evento la trae de vuelta de forma espontánea. Cuando la actividad en curso absorbe la atención, lo segundo es más probable si la señal es llamativa y está fuertemente asociada a la acción (McDaniel y Einstein, 2000).

**Memoria prospectiva.** Capacidad de recordar una acción que se quiere realizar en el futuro cuando aparece la ocasión adecuada (McDaniel y Einstein, 2000).

**Método Framework.** Método de análisis cualitativo que resume el material codificado en una matriz de unidades de análisis y temas, para identificar patrones dentro de cada caso y entre casos.

**NFC (comunicación de campo cercano).** Tecnología inalámbrica de muy corto alcance. Una etiqueta NFC se lee al acercarle el teléfono.

**Ocio digital.** Actividades que una persona realiza a través de dispositivos en su tiempo disponible para descansar, entretenerse, satisfacer su curiosidad o vincularse con otros.

**_Phygital_.** Término formado por *physical* y *digital* que designa experiencias que integran lo físico y lo digital (Waggoner et al., 2026). En esta memoria nombra el tipo de sistema.

**Precompromiso.** Decisión previa que restringe deliberadamente las opciones futuras, como bloquear aplicaciones hasta volver a un objeto.

**Primer paso.** Acción breve, concreta y disponible con la que comienza una actividad, como abrir el libro o ponerse las zapatillas; la aplicación lo pregunta con «¿Cómo empiezas?». «Junto al primer paso» significa en el lugar donde ese paso se realiza.

**Primer plano.** Estado de una aplicación abierta en la pantalla. El prototipo suma el tiempo que las aplicaciones elegidas pasan en ese estado.

**Pruebas automáticas.** Comprobaciones programadas que verifican, sin intervención de una persona, que partes del código de la aplicación funcionan como se espera.

**Pulso ambiental.** Nombre de la señal diseñada de Relevo: un sonido de unos 30 segundos, más prolongado que una notificación y más breve que una alarma, que comienza gradualmente, se detiene solo y llama la atención sin dar una instrucción. El prototipo lo implementa en el parlante y en el teléfono; el Tag emite en su lugar su propio pitido.

**Punto de cierre.** Momento en que algo termina y hay que elegir si seguir, como el final de un capítulo, una canción o una página.

**Racha.** Serie de tres o más repeticiones consecutivas de una conducta, que un registro muestra como intacta o rota.

**Relevo.** Sistema *phygital* propuesto en esta memoria, compuesto por una aplicación Android y un objeto físico, el testigo. En la interfaz, «relevo» nombra además cada ciclo.

**Reproducción automática.** Patrón de interfaz en que, al terminar un contenido, comienza otro sin exigir una elección nueva.

**Salida.** Medio por el que suena la señal en el prototipo: el Tag, propuesto por defecto; un parlante Bluetooth; un reloj, de forma experimental; o el propio teléfono, que sirve de comparación.

**Señal.** Término general para el estímulo con que el sistema devuelve la intención al presente. Se distingue de la notificación, que en esta memoria designa solo el aviso visual del teléfono.

**Servicio en primer plano.** En Android, tarea de una aplicación que sigue funcionando aunque esta no se vea en la pantalla. En el prototipo es la que sigue contando el tiempo de uso.

**Tag.** Nombre que la aplicación da al localizador Bluetooth comercial que sustituye al testigo en el prototipo. Emite su propio pitido, continuo y de volumen fijo, y no representa la forma del testigo.

**Tecnología calma.** Ideal de diseño según el cual una tecnología informa desde la periferia de la atención y pasa con facilidad al centro y de vuelta (Weiser y Brown, 1997).

**Testigo.** Componente físico propuesto de Relevo: un objeto pequeño y portátil que se deja junto al primer paso, suena cuando se cumple la condición de activación y tiene un control para silenciarlo. En el prototipo lo sustituye el Tag, un localizador comercial.

**Tipo ideal.** Agrupación analítica de casos semejantes que no pretende coincidir del todo con la realidad (Stapley et al., 2022). En esta memoria agrupa situaciones, no personas.

**Usuario principal y usuario límite.** Tipos ideales de situación, no de persona: en la primera, la sesión continúa sin una decisión renovada y otra cosa que la persona quería hacer deja de orientar el paso siguiente; en la segunda, el ocio digital conserva sentido o no existe otra intención, y no corresponde intervenir.

**WCAG (Pautas de Accesibilidad para el Contenido Web).** Recomendación del World Wide Web Consortium que fija criterios verificables de accesibilidad, como el contraste mínimo del texto o no depender solo del color.

# Anexos

- **Anexo A.** Entrevistas: la pauta (Q1–Q13), la síntesis anonimizada de las ocho entrevistas (P1–P8) y los documentos del análisis: el libro de 23 códigos, los casos y su comparación.
- **Anexo B.** Encuesta: las 16 preguntas, la codificación de las respuestas abiertas y los recuentos de las 53 respuestas.
- **Anexo C.** Estudio de referentes: el método de búsqueda, las fichas comparativas y una exploración de cuatro patentes.
- **Anexo D.** Matriz de trazabilidad: cada criterio con su evidencia, cómo lo aplica el prototipo, lo que mostró la prueba y lo que falta probar.
- **Anexo E.** Uso de inteligencia artificial: las herramientas, las cinco tareas en que ayudaron y lo que decidió el autor.
- **Anexo F.** Estados del ciclo y *wireframes*: los 35 estados del recorrido y las 39 pantallas de la aplicación.
- **Anexo G.** Prototipo Android: capturas de la versión 3.3, el sistema, la aplicación, sus datos y el registro de versiones desde la 2.7.
- **Anexo H.** Identidad: la marca aprobada en octubre de 2026, con su fundamento, y las propuestas descartadas.
- **Anexo I.** Prueba de 21 días: el protocolo, el consentimiento vigente y los instrumentos, de las preguntas tras cada señal al cierre.
