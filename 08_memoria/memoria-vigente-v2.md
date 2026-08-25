# Relevo

## Memoria de Proyecto de Título

- **Disciplina:** Diseño
- **Institución:** Universidad Diego Portales
- **Estudiante:** Johan Yantén
- **Año académico:** 2026
- **Versión:** cierre editorial del 25 de agosto de 2026
- **Etapa:** Proyecto de Título, segundo semestre
- **Tipo de proyecto:** Sistema phygital de interacción y producto
- **Estado del desarrollo:** investigación, formulación, arquitectura y esquemas estructurales documentados; prototipado funcional y evaluación de Relevo pendientes

## Resumen

Relevo aborda una situación específica del ocio digital: en algunos episodios, una persona ha formulado una actividad alternativa que valora, pero la continuidad poco deliberada de una sesión digital mantiene disponible la acción actual y la intención alternativa pierde capacidad para orientar el siguiente paso. El problema no se define por la duración de la sesión, por la presencia del teléfono ni por una aplicación particular. Tampoco equivale a adicción, pérdida general de control o rechazo del ocio digital. Una sesión extensa puede ser elegida, relacional, concentrada o reparadora; por ello, el sistema debe reconocer también cuándo no corresponde intervenir.

La investigación reúne revisión de literatura, análisis de referentes y mercado, y un estudio cualitativo exploratorio mediante ocho entrevistas semiestructuradas, habladas y presenciales, realizadas en Santiago los días 11 y 12 de junio de 2026. Las personas fueron reclutadas por referencias, con la edad como único criterio común confirmado; el rango observado fue de 19 a 27 años, incluido P6 con 27 años. El corpus anonimizado se analiza por episodios y permite distinguir un usuario principal situacional —continuidad digital junto con una intención alternativa— y un usuario límite —ocio digital elegido, significativo o coherente con la intención actual—. El corpus no estima prevalencia, no observa hogares y no evalúa Relevo.

La oportunidad de diseño se formula como una hipótesis phygital: una aplicación Android conserva el significado de una intención y configura una condición todavía abierta; un testigo físico situado representa una intención activa y emite un pulso ambiental; la persona lo ubica junto al primer paso de la actividad. La notificación del teléfono será un control comparativo, no la salida final del sistema. La investigación debe determinar si la presencia situada del testigo aporta un valor que una notificación equivalente no ofrece y si ese valor compensa configuración, mantenimiento, costo, privacidad y riesgo de intrusión.

La memoria desarrolla el problema, el marco conceptual, la evidencia de usuarios, el mercado, la síntesis de criterios, el sistema, los flujos, la producción y la gestión. El desarrollo estructural tradujo el ciclo mínimo en tres interacciones, nueve marcos de síntesis y una cobertura complementaria de 35 estados de configuración, vinculación, prueba, armado, espera, señal, cierre y recuperación. Estos *wireframes*, es decir, esquemas que ordenan contenido, acciones y jerarquías antes del diseño visual definitivo, son resultados de diseño y no pruebas de uso. El capítulo de evaluación presenta un plan progresivo P0–P4: asociación con activación simulada; contraste de lugar congruente, lugar neutro y notificación; canales y salida física; condición Android/Bluetooth Low Energy (BLE) y fallos; e integración con piloto acotado. No se han ejecutado estas pruebas. La contribución actual corresponde a investigación, formulación, arquitectura, desarrollo estructural y método; la contribución del artefacto permanece esperada y condicionada a la evidencia.

**Palabras clave:** continuidad digital, memoria prospectiva, descarga de intenciones, diseño phygital, interacción tangible, autonomía, señal situada.

## Abstract

Relevo addresses a specific situation of digital leisure: in some episodes, a person has formulated and valued an alternative activity, yet low-deliberation digital continuity keeps the current activity available and the alternative intention loses its ability to guide the next step. The problem is not defined by session duration, phone presence, or a particular application. It is not equivalent to addiction, generalized loss of control, or a rejection of digital leisure. An extended session may be chosen, social, focused, or restorative; therefore, the system must also recognize when intervention is not pertinent.

The research combines a literature review, an analysis of current products and references, and an exploratory qualitative study based on eight spoken, in-person semi-structured interviews conducted in Santiago on June 11 and 12, 2026. Participants were recruited through referrals, with age as the only confirmed common criterion; the observed range was 19 to 27, including P6 at age 27. The anonymized corpus is analyzed through episodes and supports a distinction between a situational primary user—digital continuity together with an alternative intention—and a boundary user—digital leisure that is chosen, meaningful, or coherent with the current intention. The corpus does not estimate prevalence, observe homes, or evaluate Relevo.

The design opportunity is formulated as a phygital hypothesis: an Android application retains the meaning of an intention and configures a still-open activation condition; a situated physical token represents one active intention and emits an ambient pulse; and the person places it next to the activity’s first step. A phone notification will operate as a comparative control, not as the final output. The project must determine whether the token’s situated presence offers value that an equivalent notification does not, and whether that value compensates for configuration, maintenance, cost, privacy, and intrusion risks.

This report develops the problem, conceptual framework, user evidence, market, synthesis criteria, system, flows, production, and management. The structural design translates the minimum cycle into three interactions, nine synthesis frames, and a complementary coverage of 35 states spanning configuration, pairing, testing, arming, waiting, signalling, closure, and recovery. These wireframes are design outputs rather than usability evidence. The evaluation chapter presents a progressive P0–P4 plan. No Relevo prototype tests have been executed. The current contribution lies in research, formulation, architecture, structural design, and method; the artifact contribution remains expected and conditional on evidence.

**Keywords:** digital continuity, prospective memory, intention offloading, phygital design, tangible interaction, autonomy, situated signal.

## Ficha del proyecto

| Elemento | Formulación vigente |
| --- | --- |
| Proyecto | Relevo |
| Disciplina | Diseño |
| Problema | En algunos episodios de ocio digital, una intención alternativa previamente formulada pierde disponibilidad para orientar el siguiente paso mientras la actividad actual continúa con poca deliberación. |
| Usuario principal | Persona que ha formulado una actividad alternativa propia, reconoce su primer paso y desea mantenerla disponible durante una continuidad digital que puede prolongarse sin una elección renovada claramente reconocida. |
| Usuario límite | Persona o episodio en que la actividad digital coincide con la intención actual, es significativo, relacional, concentrado o reparador, o no existe una intención alternativa que requiera apoyo. |
| Sistema | Aplicación Android, regla observable, testigo físico situado, lugar elegido manualmente y persona que interpreta y decide. |
| Pregunta | ¿En qué condiciones una clave externa, configurada por la persona, puede apoyar la recuperación espontánea de una intención y su primer paso durante una sesión de continuidad digital poco deliberada, sin bloquear, puntuar ni evaluar la decisión posterior? |
| Tesis provisional | Un pulso ambiental, configurado digitalmente y emitido por un testigo situado junto al primer paso de una actividad elegida, podría devolver esa intención a la consideración de la persona sin bloquear su ocio ni evaluar su respuesta. |
| Evidencia realizada | Revisión documental, búsqueda exploratoria de mercado y ocho entrevistas semiestructuradas presenciales. |
| Desarrollo documentado | Tres interacciones, nueve marcos de síntesis y 35 estados estructurales del ciclo, representados mediante wireframes de baja o media fidelidad. |
| Pendientes críticos | Asociación física, comparación con lugar neutro y notificación, canal, condición de activación, integración Android/BLE, accesibilidad, convivencia, costos reales y uso sostenido. |

## Índice

1. Introducción.
2. Planteamiento del problema: antecedentes y construcción.
3. Formulación del proyecto: pregunta, objetivos, alcance, tesis e hipótesis.
4. Metodología.
5. Marco teórico.
6. Usuarios y contexto.
7. Estado del arte, mercado y referentes.
8. Síntesis de investigación y oportunidad de diseño.
9. Propuesta proyectual y decisiones de diseño.
10. Sistema Relevo.
11. Arquitectura de experiencia y flujos.
12. Producción, factibilidad y modelo de gestión.
13. Plan de prototipado y evaluación.
14. Conclusiones, contribución, límites y próximos pasos.

## Motivación personal

Mi interés nació de una situación cotidiana: abrir una aplicación por unos minutos, quedarme más de lo previsto y terminar sin recordar qué había visto, mientras actividades que sí quería realizar —dibujar, leer o salir a caminar— dejaban de estar presentes. No había decidido abandonarlas; simplemente ya no estaban participando de la decisión.

Durante un tiempo interpreté esa experiencia como falta de disciplina. Esa explicación era insuficiente porque no consideraba el diseño de las plataformas, la formación de hábitos ni la diferencia entre querer una actividad y recordarla en el momento oportuno. Tampoco distinguía una sesión digital elegida y satisfactoria de otra que se prolonga con poca deliberación.

El proyecto comenzó preguntando por el tiempo de pantalla y la memoria de lo vivido. La investigación y su revisión crítica obligaron a precisar el foco: el problema abordable desde Diseño no es demostrar que el teléfono daña la memoria, sino intervenir el momento en que una intención propia deja de participar en una decisión. Este desplazamiento evita diagnosticar a la persona y permite trabajar con variables concretas: qué activa la señal, dónde aparece, qué comunica, qué control conserva el usuario y cómo se comprueba el aporte del objeto físico.

No busco eliminar el teléfono ni establecer una forma correcta de descansar. Quiero diseñar una oportunidad comprensible para elegir de nuevo.

# 1. Introducción

## 1.1 Una escena hipotética para delimitar el fenómeno

Una persona llega a su casa y decide descansar unos minutos con una aplicación de desplazamiento continuo. La elección inicial puede ser legítima: quizá busca entretenerse, conversar o recuperar energía. Antes de abrir el teléfono también había pensado comenzar otra actividad, como caminar, dibujar o preparar materiales para leer. Ha identificado un primer paso concreto —ponerse las zapatillas, sacar los materiales o despejar una superficie—, pero ese paso deja de participar en la decisión inmediata cuando la interfaz mantiene disponible un contenido tras otro. La persona podría recordar más tarde lo que había querido hacer; en el momento presente, sin embargo, la actividad digital conserva toda la disponibilidad.

Relevo imagina una posible ayuda para esa situación. Antes de continuar, la persona configura en una aplicación su intención y su primer paso, elige una condición de activación que todavía debe definirse y sitúa un testigo físico junto al primer paso. Si la condición se cumple, el testigo emite un pulso ambiental. La persona puede reconocer la asociación, continuar con el teléfono, silenciar el testigo o iniciar la alternativa. Ninguna de esas respuestas se registra como cumplimiento o incumplimiento.

La escena es hipotética. No reproduce una entrevista ni describe un comportamiento observado. Su función es hacer visible la pregunta de diseño: si la actividad digital puede ser elegida y, al mismo tiempo, dejar de acompañar una intención alternativa, ¿es posible volver a poner esa alternativa a disposición sin bloquear la primera actividad ni juzgar la decisión? El proyecto no intenta resolver la tensión por medio de una prohibición, un puntaje o una norma universal sobre el ocio.

## 1.2 Problema y pertinencia disciplinar

El teléfono concentra comunicación, entretenimiento, descanso, información, relaciones y tareas. Por esa multiplicidad, no basta con considerar la pantalla como una fuente homogénea de daño. La conectividad doméstica en Chile participa de prácticas cotidianas diversas (Subsecretaría de Telecomunicaciones, 2024), y la literatura sobre uso significativo de medios ha mostrado que la duración de una sesión no determina por sí sola su propósito, valoración ni percepción de autonomía (Lukoff et al., 2018; Meier & Reinecke, 2021).

El problema de Relevo se sitúa en una relación temporal y situacional. Una persona puede iniciar una actividad digital por decisión propia y, después, no renovar claramente esa decisión mientras la interfaz, la inercia o la ausencia de un punto de cierre mantienen disponible el siguiente contenido. En algunos episodios, una alternativa que la persona también valoraba pierde capacidad para orientar el próximo paso. En otros, no hay problema: la actividad actual coincide con la intención, posee valor relacional o funciona como descanso. El diseño debe distinguir ambas situaciones.

Esta formulación evita tres reducciones. Primero, no transforma el tiempo de pantalla en una medida universal de perjuicio. Segundo, no diagnostica adicción, automatismo, culpa ni pérdida de voluntad. Tercero, no trata toda alternativa como una obligación productiva. Dormir, conversar, caminar, aprender, dibujar o no hacer nada pueden ser decisiones propias; el sistema no debe imponer una jerarquía entre ellas.

La pertinencia para Diseño está en organizar una experiencia distribuida entre interfaz, objeto, espacio y decisión. El trabajo no consiste solo en fabricar un dispositivo conectado. Debe establecer qué relación entre intención, señal y contexto merece existir, cuándo no debe activarse, qué carga introduce y cómo se produciría, mantendría y retiraría. La propuesta es phygital porque la capa digital conserva el significado y prepara la regla, mientras el testigo físico sitúa un pulso ambiental en el lugar donde puede comenzar la actividad elegida. Debe ponerse a prueba si esa señal sostiene una asociación comprensible y aporta algo que una notificación equivalente no entrega de la misma forma.

## 1.3 Tesis provisional y aporte

La tesis provisional de Relevo es:

> Relevo explora la hipótesis de que un pulso ambiental, configurado digitalmente y emitido por un testigo situado junto al primer paso de una actividad elegida, puede devolver esa intención a la consideración de una persona durante una sesión digital de continuidad poco deliberada, sin bloquear su ocio ni evaluar su respuesta.

La tesis tiene condiciones de pérdida de fundamento. Si la persona necesita volver al teléfono para comprender la señal, si el lugar no aporta una asociación reconocible, si una notificación entrega el mismo valor con menor carga, si el objeto se percibe como vigilancia o alarma genérica, o si la condición técnica no puede ejecutarse con fiabilidad proporcional al alcance, la dirección física deberá modificarse o abandonarse. En ese caso, Relevo no se convertirá en una aplicación sustitutiva: se reformulará el testigo físico y su pulso ambiental conservando el carácter phygital, o se reconocerá que la formulación actual requiere volver a investigación de diseño.

El aporte actual es de investigación, formulación y desarrollo estructural. La memoria delimita un fenómeno, reconoce contraejemplos, define tipos de usuario situacionales, traduce conceptos a requisitos y construye una arquitectura evaluable que incluye recorridos, estados normales, salidas voluntarias y fallos recuperables. El aporte esperado del artefacto consiste en producir conocimiento sobre una ayuda phygital no coercitiva: una experiencia que distribuya una intención entre aplicación, señal física y lugar, manteniendo la decisión posterior fuera del sistema. No se afirma reducción del tiempo de pantalla, aumento de productividad, bienestar, actividad física ni cambio conductual universal.

## 1.4 Recorrido de la memoria

El capítulo 2 construye el problema a partir del contexto digital, la continuidad poco deliberada, la memoria prospectiva y las respuestas existentes. El capítulo 3 fija preguntas, objetivos, alcance, exclusiones e hipótesis. El capítulo 4 documenta la metodología, el levantamiento de usuarios y el plan de investigación mediante diseño. El capítulo 5 desarrolla el marco conceptual. El capítulo 6 presenta los episodios, tipos situacionales y límites de transferencia. El capítulo 7 organiza el estado del arte, mercado y referentes por mecanismos.

Los capítulos 8 y 9 muestran cómo la evidencia se transforma en criterios de diseño y en una dirección objetual provisional. El capítulo 10 define el sistema Relevo; el 11 describe su experiencia y flujos; el 12 desarrolla producción, factibilidad y gestión. El capítulo 13 contiene únicamente el plan de prototipado y evaluación, porque no existen resultados ejecutados. El capítulo 14 cierra con las conclusiones que la evidencia actual permite sostener, separa contribuciones actuales y esperadas y ordena las decisiones siguientes.

# 2. Planteamiento del problema: antecedentes y construcción

## 2.1 El ocio digital es heterogéneo

La digitalización de la vida cotidiana hace que una misma aplicación y un mismo dispositivo sirvan para actividades diferentes. Una persona puede utilizar una red social para entretenerse, comunicarse con alguien, buscar información o descansar. Una videollamada extensa puede ser socialmente importante; un pódcast puede acompañar una comida; un videojuego puede sostener concentración; una sesión de desplazamiento continuo puede ser elegida o puede continuar más allá de la intención inicial. El medio no define por sí solo el valor de la experiencia.

Lukoff et al. (2018) analizaron sesiones de uso de teléfonos inteligentes atendiendo al propósito, la valoración y la autonomía percibida. Su aporte para este proyecto es metodológico: obliga a diferenciar cuánto duró una sesión de qué significó para la persona. Meier y Reinecke (2021) revisaron la relación entre comunicación mediada por computador, redes sociales y salud mental, y señalan que los efectos dependen de actividad, persona y contexto. Radtke et al. (2022), al revisar la literatura sobre desintoxicación digital, muestran que las intervenciones y sus resultados son heterogéneos y que el retiro del dispositivo no constituye una solución universal.

La conectividad chilena proporciona el entorno material en que estas prácticas ocurren, pero las cifras de acceso no describen la experiencia subjetiva de cada sesión (Subsecretaría de Telecomunicaciones, 2024). Por ello, este proyecto no usa la estadística de conexión como evidencia de un problema individual. La utiliza para reconocer que el teléfono forma parte de un contexto doméstico donde pueden coexistir descanso, relación, ocio y tareas pendientes.

## 2.2 Continuidad digital poco deliberada

Algunas interfaces están construidas para que el siguiente contenido permanezca disponible. El desplazamiento infinito, la reproducción automática, la recomendación encadenada y la ausencia de un punto de cierre visible pueden reducir la cantidad de momentos en que la persona vuelve a formular qué desea hacer. Montag et al. (2019) describen características de plataformas y modelos de negocio que pueden hacer más persistente la interacción. Esta referencia no permite atribuir una conducta a una sola función ni afirmar que toda continuidad sea automática.

En esta memoria, **continuidad digital poco deliberada** designa una situación acotada: una persona pudo elegir una actividad digital al inicio, pero luego mantiene la sesión sin una renovación claramente reconocida de esa elección, mientras la interfaz o la inercia hacen disponible el siguiente contenido. El concepto no significa que la persona esté inconsciente, que haya perdido toda capacidad de decidir ni que la actividad sea necesariamente dañina. También puede incluir una ambivalencia: la sesión funciona como descanso y, al mismo tiempo, deja una intención alternativa sin posibilidad de orientar el próximo paso.

De Segovia Vicente et al. (2024) estudiaron la relación entre desplazamiento poco deliberado, conflicto de metas, culpa y bienestar cotidiano mediante métodos de muestreo de experiencias y registros de uso. El estudio es pertinente porque conecta la actividad actual con una meta alternativa, pero sus asociaciones no establecen causalidad universal ni permiten transferir resultados a todas las plataformas. En Relevo, la literatura sostiene una pregunta; no entrega una respuesta sobre la eficacia del objeto.

El problema, entonces, no aparece cuando una persona utiliza el teléfono durante mucho tiempo, sino cuando una intención alternativa previamente formulada pierde disponibilidad para orientar el siguiente paso. La expresión **intención alternativa** se refiere a una actividad que la persona desea mantener presente junto con la actividad digital actual. No equivale a una obligación externa. Puede ser una acción de descanso, relación, aprendizaje, movimiento o creación.

## 2.3 Recordar una experiencia y recuperar una intención

Recordar qué ocurrió durante una sesión no es lo mismo que recuperar qué se quería hacer después. La memoria episódica organiza acontecimientos pasados; la **memoria prospectiva** permite recordar realizar una acción futura cuando aparece una condición pertinente (McDaniel & Einstein, 2000). Relevo toma esta distinción como marco de diseño, sin convertirla en una explicación completa del uso digital.

La recuperación prospectiva requiere una intención formulada y una clave que ayude a reconocer el momento o contexto apropiado. Una persona puede recordar que quería caminar y, sin embargo, no haber traducido esa intención a un primer paso que pueda iniciar. **Primer paso** designa aquí una acción concreta, próxima y reconocible en el entorno: ponerse las zapatillas, sacar los materiales, despejar una superficie o abrir un libro. No es el objetivo completo ni una promesa de ejecución. Su función es hacer examinable la transición entre recordar y comenzar.

Las intenciones de implementación vinculan una condición anticipada con una respuesta prevista (Gollwitzer & Sheeran, 2006). Relevo comparte solo esa estructura: la aplicación podría emitir una señal cuando se cumpla una condición observable. No automatiza caminar, leer, descansar ni abandonar el teléfono. La respuesta posterior permanece abierta. Esto impide presentar la señal como una orden y obliga a distinguir recuperación de conducta.

## 2.4 Respuestas existentes al uso problemático

Las herramientas actuales se agrupan por mecanismos. Algunas miden y visualizan tiempo o aperturas; otras introducen pausas o preguntas de reconsideración; otras bloquean aplicaciones, exigen una llave física o crean fricción; y algunas vinculan objetos, lugares, sonidos o recompensas con sesiones de foco. Las diferencias importan porque cada mecanismo distribuye de manera distinta el control, la carga y la decisión.

Lyngs et al. (2019) revisaron 367 herramientas de autocontrol digital y encontraron una presencia importante de bloqueos, eliminación de estímulos y obstáculos. Biedermann et al. (2021) revisaron 28 intervenciones y encontraron resultados variables y una confianza general limitada por muestras pequeñas, periodos breves y contextos heterogéneos. Monge Roffarello y De Russis (2023) sintetizaron 43 estudios y observaron que la evidencia del campo es fragmentaria; su metaanálisis final reunió siete estudios y estimó un efecto pequeño a medio sobre reducción de uso no deseado. Ese resultado no demuestra que una modalidad concreta sea eficaz ni que usar menos el teléfono equivalga a estar mejor.

MyTime hizo visible la relación cotidiana con el teléfono mediante una intervención diseñada para apoyar el no uso (Hiniker et al., 2016). one sec, estudiado por Grüning et al. (2023) y Haliburton et al. (2024), introduce una fricción al abrir aplicaciones objetivo y aporta evidencia específica sobre aperturas, pausas y rebotes durante periodos determinados. Estas herramientas son referentes de reconsideración dentro de la pantalla, no pruebas de un objeto situado.

Las funciones nativas de Apple y Google ofrecen medición, temporizadores, periodos de desconexión y controles de aplicaciones (Apple, s. f.; Google, s. f.-c). Pause Point, descrito por Google como una pausa breve antes de abrir una aplicación seleccionada, es un antecedente reciente de intervención intermedia (Sanders, 2026). Su documentación oficial describe funcionamiento y disponibilidad, no una mejora demostrada en recuperación de intenciones.

Los productos físicos revisados, como Brick, Unpluq y Screenless Breaker, utilizan objetos o etiquetas para bloquear, desbloquear o dificultar el acceso (Brick LLC, s. f.-a; Screenless, s. f.; Unpluq, s. f.). Brick Zone relaciona un dispositivo Bluetooth con espacios declarados y bloqueo de aplicaciones (Brick LLC, s. f.-b). Focusaur combina un objeto con una aplicación, señales, etiquetas y funciones de foco o hábitos (Focusaur, s. f.). Estas páginas oficiales describen características, precios y modelos de uso; no demuestran eficacia independiente, adopción sostenida ni pertinencia para Relevo.

El antecedente histórico *The Tangible Reminder* vinculó objetos cotidianos con información de citas y un display ambiental (Hermann et al., 2007). Es relevante porque muestra una relación entre objeto, lugar y señal, pero se diferencia de Relevo por utilizar display, color semántico y tareas temporales. In(Visible) se conserva solo como antecedente histórico de exploración conceptual y como contexto de Q13; no constituye evaluación de Relevo.

## 2.5 La oportunidad que se desprende del contraste

El campo revisado ofrece muchas respuestas dentro del teléfono y varias barreras físico-digitales. Hay menos evidencia sobre una señal física sin texto que se sitúe junto al primer paso de una actividad autoelegida, sin bloquear ni registrar cumplimiento. Esta afirmación describe una oportunidad acotada al corpus académico, técnico y comercial consultado hasta el 24 de agosto de 2026. No significa que ningún producto semejante exista en el mundo ni constituye una afirmación de novedad absoluta.

La oportunidad depende de una comparación exigente. El testigo debe probarse en un lugar congruente y en un lugar neutro. Luego debe compararse con una notificación digital equivalente. La notificación no es el producto final: es un control que permite saber si el objeto aporta algo específico. Si las tres condiciones generan la misma comprensión y la notificación añade menos configuración, costo y mantenimiento, la materialidad no queda justificada en su forma actual.

El objeto agrega complejidad: debe producirse, cargarse, trasladarse, vincularse, protegerse, repararse y retirarse. También puede generar ruido, exposición de una intención, pérdida, confusión o intrusión. El valor físico no consiste en ser atractivo ni novedoso; consiste en una diferencia que la persona pueda explicar por la presencia, ubicación o manipulación del objeto y que una notificación no entregue de la misma manera.

## 2.6 Formulación del problema de diseño

La construcción del problema reúne cuatro premisas: el ocio digital tiene significados heterogéneos; ciertas interfaces favorecen la continuidad; algunas personas relatan una intención alternativa que pierde disponibilidad mientras la sesión continúa; y las respuestas actuales introducen cargas que no siempre coinciden con la situación. La inferencia de diseño es que existe una brecha posible entre formular una intención y mantenerla disponible para la decisión inmediata.

El problema se formula así:

> En algunos episodios de ocio digital, una persona reconoce o valora una intención alternativa, pero la continuidad de la sesión mantiene disponible la actividad actual y la intención pierde capacidad para orientar el siguiente paso. La investigación exploratoria no permite estimar la frecuencia ni atribuir una causa única. El desafío de diseño consiste en explorar una ayuda externa, autoelegida y situada que haga recuperable una posibilidad sin convertir el ocio en una falta y sin intervenir cuando la actividad actual es coherente con la intención de la persona.

La formulación deja fuera el diagnóstico clínico, la vigilancia del comportamiento, el control parental, la optimización de productividad y la reducción general de minutos. También deja fuera la detección automática de intenciones, culpa, automatismo o pertinencia subjetiva. Android solo puede operar sobre una condición técnica observable. La persona conserva la interpretación y la decisión.

# 3. Formulación del proyecto: pregunta, objetivos, alcance, tesis e hipótesis

## 3.1 Pregunta de investigación

¿En qué condiciones una clave externa, configurada por la persona, puede apoyar la recuperación espontánea de una intención previamente formulada y de su primer paso durante una sesión de continuidad digital poco deliberada, sin bloquear, puntuar ni evaluar la decisión posterior?

La recuperación se define operacionalmente como la identificación espontánea de la intención y del primer paso después de la señal, sin consultar la aplicación para descifrar el contenido. No significa realizar la actividad, abandonar el teléfono, reducir el tiempo de pantalla ni aceptar la propuesta del sistema.

## 3.2 Pregunta proyectual

¿Cómo puede diseñarse un sistema phygital compuesto por una aplicación Android, un testigo físico situado y un lugar elegido manualmente para explorar si la asociación entre intención, señal y primer paso aporta un valor que una notificación digital equivalente no aporta, preservando autonomía, privacidad y convivencia?

## 3.3 Objetivo general

Diseñar y evaluar formativamente un sistema phygital que articule una aplicación Android, un testigo físico situado y una asociación manual con el primer paso de una actividad elegida, con el fin de explorar si un pulso ambiental puede apoyar la recuperación de una intención durante una sesión de continuidad digital poco deliberada sin bloquear, calificar ni registrar la conducta posterior.

## 3.4 Objetivos específicos

1. Caracterizar el problema mediante revisión de literatura y análisis cualitativo de entrevistas, distinguiendo episodios de pertinencia, contraejemplos y límites de transferencia.
2. Traducir evidencia, conceptos y referentes en criterios de diseño, requisitos, no requisitos, riesgos, decisiones y pruebas.
3. Desarrollar y documentar un sistema inicial compuesto por aplicación Android, condición observable, testigo físico situado, pulso ambiental, lugar manual, controles de salida, datos acotados y criterios de mantenimiento.
4. Explorar la asociación entre intención, primer paso, lugar y señal mediante activación simulada antes de automatizar.
5. Comparar la ubicación congruente, la ubicación neutra y una notificación digital equivalente para examinar el valor específico de la materialidad.
6. Examinar percepción, atribución, intrusión, autonomía, convivencia y accesibilidad como requisitos situacionales.
7. Probar de manera progresiva la condición Android/BLE, los estados técnicos, el enlace, el vencimiento y los fallos previsibles.
8. Documentar producción, costos diferenciados, actores, mantenimiento, reparación, cumplimiento y criterios para mantener, reformular o abandonar la dirección física.

## 3.5 Hipótesis de trabajo

Las hipótesis se presentan como relaciones evaluables, no como resultados.

**H1. Asociación intención–primer paso–lugar–señal.** Si una persona formula una intención alternativa y un primer paso, sitúa manualmente el testigo junto a ese paso y recibe una señal sin texto, podría identificar la intención y el primer paso sin consultar la aplicación. H1 se debilita si la señal se percibe, pero no se atribuye a la intención; si el lugar no ayuda a explicar la relación; o si la persona requiere volver al teléfono.

**H2. Aporte físico situado frente a lugar neutro y notificación.** El testigo ubicado en un lugar congruente podría facilitar una relación situada que no aparece con el mismo testigo en un lugar neutro y que una notificación equivalente no entrega de la misma forma. H2 se debilita si el lugar congruente y el neutro producen la misma interpretación o si la notificación ofrece igual valor con menor carga, costo y mantenimiento.

**H3. Percepción, atribución, intrusión y autonomía.** Una señal física no textual podría ser percibida y atribuida a la intención sin transformarse en alarma, vigilancia o reproche, mientras la persona conserva la posibilidad de ignorar, silenciar, modificar o desarmar. H3 se debilita si la señal no se distingue, se interpreta como control externo, invade la convivencia o no ofrece una salida comprensible.

**H4. Ejecución técnica de condición, enlace y vencimiento.** Una condición observable, el enlace BLE y el vencimiento podrían ejecutarse de manera legible y tolerante a fallos en el entorno Android seleccionado. H4 se debilita si los permisos, estados, reconexiones o comandos tardíos hacen que la señal sea inexplicable o desproporcionada respecto del valor físico.

La activación permanece abierta entre uso continuo, uso acumulado en una ventana y horario o franja elegida. No se puede cerrar esta elección solo por facilidad de programación, pues modifica el significado de la señal, la privacidad, el flujo técnico y los posibles falsos positivos.

## 3.6 Alcance

El alcance inicial comprende una persona, una intención activa, un primer paso, una aplicación seleccionada, una condición observable, un testigo físico situado y un lugar elegido manualmente. Android es la plataforma inicial de prototipado, no una promesa de compatibilidad universal. El hogar es el primer contexto de diseño, no un contexto ya observado ni una generalización sobre todas las viviendas.

La propuesta está pensada para una transición autoelegida dentro del ocio digital, no para interrumpir conversaciones, videollamadas, trabajo concentrado, estudio, descanso deliberado o actividades que la persona considera coherentes. El sistema debe aceptar la ausencia de pertinencia como resultado correcto.

## 3.7 Exclusiones

Relevo no bloquea aplicaciones, no asigna puntajes, no construye rachas, no compara usuarios, no registra cumplimiento, no utiliza vigilancia de ubicación, no realiza inferencia clínica y no determina qué actividad es correcta. El testigo no tiene pantalla ni texto. La aplicación no interpreta culpa, automatismo, emoción, intención desplazada ni valor subjetivo del ocio. El lugar no es detectado automáticamente por Android.

Quedan pendientes, y por tanto fuera de toda afirmación cerrada, la forma final, el color, las dimensiones, el peso, la duración de la señal, la autonomía, los materiales definitivos, los componentes de serie, la compatibilidad universal, el precio, la disposición de pago, la accesibilidad universal y la adopción sostenida.

## 3.8 Criterios de cambio y abandono

La dirección física se mantiene si la asociación entre intención y primer paso resulta comprensible, el lugar aporta una diferencia reconocible, la señal es perceptible y tolerable, la salida es autónoma y la ejecución técnica es proporcional. Se modifica si existe valor físico, pero fallan canal, lugar, control, condición, convivencia, accesibilidad o producción. Se abandona la dirección física actual si el objeto no añade valor frente a la notificación, exige consulta constante, se vuelve vigilancia o acumula una carga que su aporte no compensa.

Si falla el testigo transportable, puede reformularse o reemplazarse por otra interfaz objetual ambiental dentro del sistema phygital. No se convierte Relevo en una aplicación para conservar una forma inicial. Si ninguna configuración física sostiene una diferencia defendible, se registra la refutación de la formulación actual y se vuelve a investigación de diseño.

## 3.9 Teoría de cambio

La teoría de cambio hace explícita la transformación buscada sin confundirla con una promesa de eficacia. Su función es conectar problema, evidencia, intervención, comportamiento posible y evaluación.

**1. Enunciado de cambio.** Relevo busca que una persona que ya formuló una actividad alternativa, en un episodio doméstico de continuidad digital poco deliberada, transite desde una situación en que esa intención pierde disponibilidad hacia otra en que puede volver a considerarla, mediante un testigo físico situado que la propia persona vincula con el primer paso de la actividad. El cambio buscado es recuperar una posibilidad de elección, no imponer la ejecución de la alternativa.

**2. Cadena causal provisional.** La persona formula una intención y un primer paso → sitúa el objeto junto a ese paso → una condición observable activa una señal → la persona percibe y atribuye la señal → la intención puede volver a estar disponible → la persona decide si continúa, silencia o cambia de actividad. Las tres primeras relaciones son decisiones de diseño; la recuperación de la intención y el aporte del lugar permanecen como hipótesis de evaluación.

**3. Mecanismo de cambio.** El mecanismo combina memoria prospectiva, descarga de intenciones y una clave situada (Kirsh, 1995; McDaniel & Einstein, 2000; Risko & Gilbert, 2016). La aplicación conserva significado y condición; el objeto desplaza la señal fuera del flujo visual del teléfono; el lugar elegido busca relacionarla con una acción concreta. La señal no produce por sí sola el cambio ni reemplaza la decisión.

**4. Contrato con el usuario.** El sistema ofrece una clave externa, control de salida, ausencia de bloqueo y ausencia de evaluación de cumplimiento. A cambio solicita formular una intención, reconocer su primer paso, configurar una condición, elegir un lugar, mantener el objeto disponible e interpretar una señal no textual. Si esa carga supera el valor percibido, el contrato resulta desproporcionado.

**5. Supuestos críticos.** El corpus respalda parcialmente que existen episodios donde una alternativa valorada pierde disponibilidad, sin estimar su frecuencia. Permanece por validar que la asociación intención–objeto–lugar pueda comprenderse sin volver a la pantalla; que el lugar congruente aporte más que un lugar neutro o una notificación; y que la configuración, el mantenimiento y la presencia doméstica sean tolerables. Si estos supuestos fallan, debe modificarse o abandonarse la dirección física actual.

**6. Frontera de decisiones.** Se mantienen como decisiones firmes el carácter phygital, el testigo físico situado, el pulso ambiental, la autonomía posterior a la señal, la ausencia de bloqueo y la lectura situacional del usuario. Permanecen abiertas la condición de activación, el canal, la forma, la materialidad, el lugar doméstico específico, la arquitectura electrónica final, el precio y la modalidad de acceso. Cada decisión abierta se cierra solo mediante la prueba que le corresponde.

**7. Indicadores de éxito.** Los indicadores formativos son observables: asociación espontánea entre señal e intención sin consultar la aplicación; diferencia atribuible al lugar congruente frente al lugar neutro y la notificación; percepción y salida autónoma sin lectura punitiva; y ejecución técnica legible ante vencimiento, desconexión o señal tardía. No se fijan porcentajes, tiempos ni frecuencias antes de establecer una línea base en P0 y P1.

# 4. Metodología

## 4.1 Enfoque general

El proyecto combina investigación cualitativa exploratoria, revisión de literatura, análisis de mercado y referentes, y desarrollo mediante prototipado progresivo. La secuencia responde a una dependencia: primero se delimita el fenómeno y la pertinencia de intervenir; luego se formula una relación entre intención, primer paso, lugar y señal; después se examina el valor específico del objeto; y solo entonces se abre la integración Android/BLE, la producción y el piloto.

La metodología distingue estados epistémicos:

| Estado | Significado en esta memoria |
| --- | --- |
| Realizado | Revisión documental, entrevistas, análisis inicial y búsqueda exploratoria de mercado. |
| Interpretado | Patrones, tensiones, tipos situacionales y criterios de diseño derivados de la evidencia. |
| Decidido | Restricciones o elecciones del proyecto, como phygitalidad, interfaz objetual ambiental y ausencia de evaluación conductual. |
| Planificado | Protocolos P0–P4, comparaciones, pruebas técnicas y piloto. |
| Pendiente | Condiciones que no pueden cerrarse sin nueva evidencia, como activación, canal, autonomía y producción. |

La investigación mediante diseño no se utiliza para hacer pasar una intención de producto por resultado. Un prototipo sirve para aislar una pregunta y producir conocimiento sobre una condición. Una activación simulada puede estudiar asociación sin probar Android. Un prototipo electrónico puede estudiar entrega sin probar valor situado. Una integración técnica puede estudiar permisos y fallos sin probar autonomía o adopción.

## 4.2 Revisión documental y marco de búsqueda

La revisión priorizó publicaciones de 2019 en adelante y conservó antecedentes fundacionales cuando eran necesarios para definir conceptos, como memoria prospectiva, espacio o interacción tangible. Se revisaron literatura sobre uso significativo y bienestar digital, conflicto de metas, descarga de intenciones, memoria prospectiva, notificaciones, recordatorios situados y prototipado. Cada fuente se utilizó según su función: una revisión para conocer el campo, un estudio empírico para discutir un mecanismo, una documentación oficial para describir funcionamiento y una página comercial para describir oferta, precio visible o modelo de valor.

El estado del arte y mercado tuvo fecha de corte 24 de agosto de 2026 y carácter exploratorio, no sistemático. Se consultaron fuentes académicas, documentación oficial de Apple, Google, Android y la Subsecretaría de Telecomunicaciones (SUBTEL), y páginas oficiales de one sec, Brick, Brick Zone, Unpluq, Screenless y Focusaur. Las fuentes comerciales se utilizaron para describir funciones y restricciones declaradas. No se utilizaron para afirmar eficacia, adopción, bienestar ni superioridad.

## 4.3 Estudio cualitativo exploratorio

El estudio fue cualitativo porque atendió a episodios narrados, significados, tensiones, estrategias y contraejemplos. Fue semiestructurado porque mantuvo preguntas comunes y permitió repreguntas según cada respuesta. No fue observación directa ni evaluación de Relevo.

Participaron ocho personas identificadas como P1–P8. Las entrevistas fueron habladas, presenciales y realizadas en Santiago los días 11 y 12 de junio de 2026. El reclutamiento se hizo mediante referencias de la red personal. La edad fue el único criterio común confirmado; el rango observado fue de 19 a 27 años y P6 tenía 27 años. Santiago describe el contexto del levantamiento, no la población de generalización.

El consentimiento fue informado y oral. No se conserva el texto exacto de la información entregada. Las preguntas y repreguntas fueron realizadas por el investigador. Q1–Q11 correspondieron a la secuencia inicial; Q12 y Q13 fueron preguntas adicionales presenciales. Q12 abordó estrategias para descansar sin el teléfono. Q13 recogió una reacción condicional frente al concepto histórico In(Visible), especialmente sobre tono, discreción y carácter no punitivo. Q13 no evaluó Relevo y no permite inferir aceptación, preferencia, forma, eficacia ni valor comparativo del sistema.

Después del levantamiento, el habla se transcribió y regularizó con apoyo automatizado. Esa asistencia fue posterior y no produjo preguntas, repreguntas ni respuestas. El corpus actual es una transcripción anonimizada y formalizada, no un registro literal garantizado. No hay audio disponible, no se dispone de la duración individual de las entrevistas y no se conservan las notas manuscritas originales. Por ello, la memoria privilegia paráfrasis analíticas y citas textuales breves solo cuando su trazabilidad está clara.

## 4.4 Unidad de análisis y procesamiento

La unidad principal de análisis es el **episodio**: una situación de ocio digital narrada en relación con actividad, intención, continuidad, percepción temporal, valoración, conflicto, estrategia o cierre. La persona es el caso que reúne episodios; no se la convierte en un perfil fijo. Una misma persona puede narrar un episodio pertinente para una intervención y otro en que la intervención sería incorrecta.

La unidad secundaria es el segmento pregunta–respuesta, identificado como P/Q. El material se ordenó por contexto, actividad digital, intención, continuidad, temporalidad, recuerdo, valoración, tensión, estrategia y reacción ante una señal. Cada afirmación se distinguió como evidencia, interpretación, hipótesis, decisión o pendiente.

Q8 registra seis respuestas afirmativas, una parcial y una negativa sobre dificultad para describir posteriormente una sesión. Ese conteo es descriptivo para esa pregunta y ese corpus. No es una medida de prevalencia, pérdida de control, intención desplazada ni diagnóstico. P8 muestra que la dificultad de descripción puede coexistir con una valoración del tiempo como descanso; P7 ofrece un caso negativo y no identifica una necesidad de corrección.

El análisis siguió el método Framework, un procedimiento matricial que ordena casos y categorías para compararlos de manera sistemática, junto con una comparación de tipos ideales revisables. Goldsmith (2021) describe este método como un procedimiento aplicado y comparativo; Stapley et al. (2022) explican cómo construir tipologías cualitativas a partir de reconstrucciones de caso y comparación. El investigador realizó la interpretación; no hubo un segundo codificador independiente. Para compensar parcialmente ese límite se conservaron libro de códigos, reconstrucciones, matriz comparativa y trazabilidad P/Q. Las afirmaciones fuertes se restringen a secuencias documentadas; los episodios ambiguos se presentan como indicios o se mantienen fuera de la clasificación central.

## 4.5 Ética, reflexividad y límites del levantamiento

El investigador fue entrevistador, diseñador e intérprete. Esa posición pudo orientar la atención hacia continuidad, intención y autonomía. Q13 pudo hacer visibles respuestas asociadas a la presentación de In(Visible), por lo que se trata como orientación condicional sobre tono y discreción, no como evidencia sobre Relevo.

No se observaron hogares, superficies, convivientes, distancias, ruido, movilidad del objeto ni privacidad. La muestra por referencias introduce sesgo de selección. La ausencia de audio, duración individual y notas originales limita la literalidad y la auditoría externa de cada conversación, sin invalidar que las entrevistas se realizaron. El estudio no permite inferir prevalencia, causalidad, eficacia, accesibilidad, adopción, disposición de pago ni superioridad frente a una notificación.

Una futura evaluación requerirá consentimiento específico para activaciones, observación, registro técnico, fotografías, citas anonimizadas y eventuales pruebas domésticas. También deberá definir retiro voluntario, eliminación de datos, manejo de fallos y cierre de la sesión sin consecuencias para la persona.

## 4.6 Plan de trabajo dependiente

La secuencia de trabajo es:

1. Mantener la formulación del problema, el usuario principal y el usuario límite.
2. Ejecutar P0 con activación simulada para examinar asociación.
3. Ejecutar P1 solo si P0 deja una relación comprensible entre intención, primer paso, lugar y señal.
4. Elegir canal y salida física en P2 sin fijar una modalidad universal.
5. Probar condición Android/BLE, permisos, enlace y vencimiento en P3.
6. Integrar un piloto acotado en P4 solo si el objeto conserva valor situado y la técnica es proporcional.
7. Actualizar producción, mantenimiento, costos y conclusiones con evidencia real.

La investigación no debe abrir simultáneamente forma final, automatización, costos industriales y escalamiento. Cada etapa debe cerrar una incertidumbre antes de agregar otra.

# 5. Marco teórico

El marco se organiza en tres ámbitos que se imbrican y no funcionan como capítulos independientes. El primero, **experiencia subjetiva del ocio digital**, reúne continuidad, conflicto de metas y memoria prospectiva. El segundo, **arquitecturas de atención e intervención**, examina cómo las interfaces mantienen la actividad, cómo operan las respuestas actuales y por qué la autonomía limita la intervención. El tercero, **mediación phygital situada**, articula descarga de intenciones, condición, espacio, primer paso e interacción tangible. La investigación mediante diseño funciona como enfoque metodológico transversal para convertir estas relaciones en preguntas evaluables. La intersección de los tres ámbitos produce la oportunidad de Relevo: apoyar la recuperación de una intención mediante una señal física situada, sin bloquear ni juzgar el ocio digital.

## 5.1 Continuidad digital y conflicto de metas

La continuidad digital poco deliberada es el constructo central del problema. Se define como una continuidad de la actividad actual sin una renovación claramente reconocida de la elección, en un episodio en que existe o puede existir una intención alternativa. El constructo no describe una patología y no supone que la persona haya perdido capacidad de decisión.

El **conflicto de metas** aparece cuando una actividad actual y una alternativa valorada no apuntan al mismo siguiente paso. De Segovia Vicente et al. (2024) vinculan el desplazamiento poco deliberado con conflicto y culpa en ciertos episodios, pero no establecen que la experiencia sea uniforme ni que la culpa deba ser el objetivo de una intervención. Relevo se interesa por la disponibilidad de la alternativa, no por aumentar culpa o imponer productividad.

La distinción es importante porque un usuario puede vivir una sesión como descanso y, al mismo tiempo, reconocer que había pensado hacer otra cosa. La intervención no debe decidir cuál valoración es correcta. Solo puede ofrecer una clave que haga visible la alternativa que la propia persona configuró.

## 5.2 Memoria prospectiva

La memoria prospectiva se refiere a recordar realizar una acción futura. McDaniel y Einstein (2000) proponen que su recuperación puede depender de procesos estratégicos y automáticos, y que las claves contextuales pueden apoyar la identificación de la ocasión pertinente. El proyecto toma este marco para formular una pregunta sobre señales, no para atribuir un mecanismo psicológico completo a una sesión digital.

Relevo separa cuatro estados: percibir una señal, atribuirla al sistema, recuperar la intención y ejecutar el primer paso. Percibir no implica comprender. Comprender no implica recordar la intención. Recordarla no implica realizarla. Ejecutarla no es un requisito de cumplimiento del sistema. Esta separación evita que el resultado de una futura prueba se reduzca a obediencia.

## 5.3 Descarga de intenciones y costo de configuración

La **descarga de intenciones** es la externalización parcial de una intención en una señal, objeto, nota, lugar o recurso del entorno (Gilbert et al., 2023; Risko & Gilbert, 2016). Externalizar puede aliviar la demanda de mantener la intención internamente, pero no elimina la necesidad de formularla ni asegura que la señal se interprete.

La configuración tiene un costo. La persona debe elegir una actividad, definir un primer paso, seleccionar una condición, vincular un objeto, escoger un lugar, probar la señal y rearmar el ciclo. Chiu y Gilbert (2024) estudiaron cómo el esfuerzo físico de establecer recordatorios afecta la descarga estratégica de intenciones. Su resultado es pertinente como advertencia: la materialidad debe compensar el trabajo que agrega. El proyecto no utiliza el estudio para fijar un umbral de configuración ni para afirmar que un objeto doméstico tendrá el mismo efecto.

Por eso Relevo limita provisionalmente el ciclo a una intención y un primer paso. Esta decisión reduce ambigüedad y permite evaluar qué relación se está recuperando. No implica que un sistema final deba limitarse para siempre a una única intención.

## 5.4 Intenciones de implementación y condición

Las intenciones de implementación articulan una condición con una acción prevista (Gollwitzer & Sheeran, 2006). Relevo adopta la estructura condicional de manera restringida: la aplicación puede traducir un evento observable en una posible señal, pero nunca ejecuta la actividad alternativa. La condición puede ser uso continuo, acumulación dentro de una ventana o horario. Cada candidato modifica la relación entre actividad digital, tiempo y significado.

Una condición de uso continuo puede señalar después de una permanencia en primer plano, pero puede confundir continuidad con pertinencia. Una condición acumulada tolera pausas, pero exige explicar qué se acumula. Un horario es técnicamente más simple, pero puede producir una señal sin relación con la actividad digital. Ninguna opción queda cerrada antes de P3.

La aplicación no puede detectar automatismo, culpa, intención desplazada o valor del ocio. Solo puede consultar estados que el sistema operativo exponga bajo permisos y restricciones. Esta limitación no es un detalle técnico: define qué puede prometer el proyecto.

## 5.5 Espacio, contexto y primer paso

Kirsh (1995) describe cómo las personas organizan el espacio para hacer perceptibles relaciones y reducir demandas cognitivas. La cognición situada entiende que una actividad se apoya parcialmente en el cuerpo, los objetos y el entorno. Los recordatorios basados en lugar muestran que un espacio puede actuar como contexto de recuperación, pero la cercanía no provoca por sí sola una acción (Sohn et al., 2005; O’Rear & Radvansky, 2019).

En Relevo, el lugar no es una coordenada detectada por el teléfono. Es una asociación creada por la persona: el testigo se sitúa junto al primer paso porque esa relación debe ser comprendida por quien configura el sistema. El valor del lugar depende de visibilidad, superficie, distancia, tránsito, ruido, privacidad, convivencia y posibilidad de manipular el objeto.

La hipótesis espacial exige comparar el mismo testigo en un lugar congruente y en un lugar neutro. Si no existe diferencia explicable, la ubicación funciona solo como soporte físico y no como capa significativa. Si la ubicación expone la intención o dificulta la convivencia, la dirección debe cambiar.

## 5.6 Autonomía y no coerción

La autonomía se define aquí de manera operacional. Una persona es autónoma frente al sistema si puede configurar, modificar, desarmar, ignorar, silenciar y continuar sin recibir sanción, puntuación, clasificación ni registro de cumplimiento. La ausencia de bloqueo no basta: una señal persistente, ambigua o difícil de detener también puede ser coercitiva.

La decisión posterior permanece fuera del sistema. Relevo no registra si la persona se puso las zapatillas, abrió un libro o continuó mirando el teléfono. Una señal puede devolver una intención a la consideración y la persona puede decidir que ya no corresponde. Cambiar de intención no es un fallo.

Q13 solo orienta este criterio de forma condicional porque se refirió a In(Visible). Las entrevistas sugieren que una intervención futura debe explorar discreción, tranquilidad y posibilidad de silenciar, pero no ofrecen aceptación de Relevo. La autonomía debe evaluarse con el testigo actual y en contextos de uso pertinentes.

## 5.7 Phygital e interacción tangible

**Phygital** designa una experiencia en que las dimensiones física y digital articulan una función común. En Relevo, la aplicación conserva el significado de la intención; el objeto emite una señal fuera de la pantalla; el lugar aporta una asociación contextual; y la persona interpreta y decide. Si cualquiera de estas capas se limita a decorar o repetir a otra, la experiencia pierde su fundamento phygital.

La interacción tangible ocurre cuando la presencia, ubicación o manipulación de un objeto participa en la acción y en el significado. *The Tangible Reminder* funciona como antecedente histórico de recordatorio material, pero su uso de display y tareas temporales no prueba la propuesta actual (Hermann et al., 2007). Waggoner et al. (2026) subrayan que la investigación de experiencias phygital debe considerar transiciones entre capas, accesibilidad e inclusión, no solo la interfaz digital.

La interfaz objetual se concentra en representar una intención mediante un pulso ambiental situado; su capacidad para sostener una asociación comprensible constituye una hipótesis. La distribución mantiene el contenido semántico en la aplicación y reserva al testigo la función de presencia y señal. También puede producir ambigüedad, baja saliencia, alarma genérica o una dependencia excesiva del recuerdo. El objeto se justifica solo si la comparación demuestra un aporte específico.

## 5.8 Investigación mediante diseño y conocimiento proyectual

La investigación mediante diseño utiliza prototipos y situaciones para poner en tensión hipótesis. Real et al. (2021) muestran que distintos métodos de prototipado producen distintos tipos de conocimiento. Un prototipo de baja fidelidad puede estudiar significado; uno electrónico puede estudiar percepción o enlace; una integración puede estudiar estados técnicos. Ninguno equivale automáticamente a un producto terminado.

La secuencia de Relevo sigue esa lógica. P0 no automatiza: pregunta si la relación se comprende. P1 compara condiciones de significado. P2 examina la forma de la señal y la salida. P3 prueba ejecución y fallos. P4 observa una integración acotada. Cada etapa debe registrar qué demuestra localmente y qué no permite afirmar.

El diseñador produce conocimiento cuando hace visible una condición de decisión: mantener, modificar, sustituir o abandonar. Un fallo de señal no se atribuye de inmediato a la persona; puede corresponder a modalidad, lugar, configuración, contexto o método. La materialidad no debe defenderse por su existencia previa, sino por la evidencia que produce.

## 5.9 Síntesis conceptual

| Concepto | Traducción para Relevo | Límite |
| --- | --- | --- |
| Continuidad poco deliberada | Situación en que la actividad actual continúa sin una renovación claramente reconocida de la elección. | No equivale a adicción, culpa ni diagnóstico. |
| Memoria prospectiva | Recuperación de una acción futura ante una clave pertinente. | Recuperar no implica ejecutar. |
| Descarga de intenciones | Distribución parcial del significado entre aplicación, señal y contexto. | La señal puede no comprenderse; configurar tiene costo. |
| Primer paso | Acción concreta que inicia la alternativa. | No es la actividad completa ni un resultado conductual. |
| Lugar manual | Relación elegida entre testigo y primer paso. | Android no lo detecta ni la cercanía garantiza acción. |
| Autonomía | Configurar, modificar, ignorar, silenciar y continuar sin evaluación. | La ausencia de bloqueo no asegura baja intrusión. |
| Phygital | Articulación de aplicación, objeto, lugar y decisión en una experiencia común. | No prueba superioridad del objeto. |
| Prototipo | Construcción para responder una pregunta acotada. | No prueba eficacia, adopción ni producción por sí sola. |

# 6. Usuarios y contexto

## 6.1 Alcance de los hallazgos

El estudio no produce segmentos de mercado ni biografías de usuarios. Produce una lectura situada de ocho casos y de los episodios que cada persona relató. La diferencia analítica principal no es entre personas que utilizan mucho o poco el teléfono, sino entre situaciones en que una intención alternativa pierde disponibilidad y situaciones en que la actividad digital conserva significado, propósito o coherencia con la intención actual.

La persona puede cambiar de patrón según la actividad. Por eso los tipos de usuario se definen como configuraciones episódicas. Una misma persona puede ocupar el lugar principal en un episodio y el límite en otro. Esta decisión evita transformar la edad, la ocupación o la aplicación en explicaciones causales.

## 6.2 Matriz de participantes anonimizados

**Tabla 1**

*Matriz descriptiva de participantes y función analítica*

| Código | Edad | Respuesta descriptiva a Q8 | Función en el análisis |
| --- | ---: | --- | --- |
| P1 | 21 | Afirmativa | Variación entre ocio digital valorado y continuidad difícil de describir. |
| P2 | 22 | Parcial: ocurre poco | Caso central de sueño reconocido y continuidad posterior. |
| P3 | 19 | Afirmativa frecuente | Caso central de pérdida de noción temporal y alternativas valoradas. |
| P4 | 22 | Afirmativa frecuente | Contraste entre desplazamiento difícil de describir y sudoku focalizado. |
| P5 | 20 | Afirmativa | Caso adyacente de entretenimiento inmediato y aburrimiento posterior. |
| P6 | 27 | Afirmativa | Caso límite de videollamada significativa y recordada. |
| P7 | 21 | Negativa | Caso límite: no reconoce la brecha como problema. |
| P8 | 19 | Afirmativa | Variación episódica entre rutina digital y descanso aceptado. |

*Nota.* La tabla describe el corpus disponible y no representa una población ni una distribución de prevalencia. P6 tiene 27 años.

## 6.3 Episodios centrales y contraejemplos

P2 abrió Instagram al acostarse para ver memes, reconoció el sueño y continuó mirando el teléfono. La sesión fue recordada con claridad, pero el cierre fue evaluado como incompleto. El caso no muestra que la persona haya olvidado lo ocurrido; muestra una tensión entre una intención alternativa —dormir— y la continuidad de la actividad actual. También aporta una consideración material: mantener disponibles los elementos necesarios para otra actividad puede facilitar su inicio, pero esa inferencia todavía debe probarse.

P3 describió videos humorísticos en Instagram como una forma de pasar el tiempo. Relató pérdida de noción temporal y reconoció alternativas que consideraba mejores, aunque también describió la sesión como una pausa frente a responsabilidades. El caso concentra la ambivalencia que el diseño debe conservar: una actividad puede resultar agradable y, al mismo tiempo, competir con otra intención. Relevo no debe interpretar esa ambivalencia como autorización para corregir.

P5 es adyacente. Relató entretenimiento inmediato y aburrimiento posterior, y mencionó estrategias que no siempre evitan volver al teléfono. El episodio orienta sobre estrategias frágiles y sobre la diferencia entre una valoración posterior negativa y una intención alternativa previamente formulada. No tiene la misma claridad que P2 y P3 respecto de qué primer paso debía mantenerse disponible.

P6 relató una videollamada extensa, con contenido, vínculo y valoración positiva. P7 describió un pódcast elegido mientras comía, recordó el episodio y no reconoció una obligación que exigiera corregirlo. P4 aportó el contraste del sudoku focalizado frente a actividades digitales más rutinarias. P8 mostró que la dificultad de describir una rutina digital puede coexistir con la aceptación de esa sesión como descanso. Estos casos impiden intervenir por duración, aplicación o presencia del teléfono.

P1 y P4 muestran que la misma persona puede diferenciar actividades dirigidas de actividades que continúan con menor deliberación. Esta variación interna impide tratar a un individuo como usuario principal permanente. P6, P7 y parte de P8 hacen visible que la no intervención no es una excepción del sistema, sino una condición de diseño.

## 6.4 Q12 y Q13

Q12 reunió estrategias autodeclaradas para descansar o separarse del teléfono: alejarlo, cargarlo en otro lugar, silenciarlo o activar modos de no molestar. Estas respuestas no fueron observadas ni comparadas. Informan sobre el repertorio que algunas personas ya consideran, pero no prueban que una separación física sea eficaz ni que un objeto sea preferible.

Q13 fue realizada presencialmente y se refirió a la reacción ante el concepto histórico In(Visible). Sus respuestas permiten orientar condicionalmente un tono tranquilo, discreto y no punitivo, además de la posibilidad de ignorar o silenciar. No son una evaluación de Relevo. No permiten inferir aceptación del sistema, preferencia por un objeto, valor de una ubicación, eficacia de una señal ni disposición de pago. La prueba futura debe presentar el sistema actual y registrar sus respuestas sin apoyarse en Q13 como resultado.

## 6.5 Usuario principal situacional

El usuario principal se define por la coincidencia de tres condiciones:

1. La actividad digital continúa sin una elección renovada claramente reconocida.
2. Existe una intención alternativa propia que la persona desea mantener disponible.
3. La intención alternativa pierde capacidad para orientar el siguiente paso.

P2 y P3 sostienen mejor este patrón. P5 lo bordea y permite examinar qué ocurre cuando existe ambivalencia, pero no un primer paso igualmente preciso. La necesidad inferida es disponer de una alternativa sin que el sistema imponga su ejecución, y recuperar un primer paso sin tener que volver necesariamente al mismo flujo del teléfono. Esta necesidad no fue expresada como solicitud literal de Relevo.

Los puntos de fricción son continuar después de reconocer una alternativa, recuperar poco de la sesión y volver al teléfono después de haberlo alejado. Los deseos relatados —dormir, caminar, hacer un pasatiempo, aprender o ejercitarse— no deben traducirse automáticamente en productividad. Para el diseño, cada deseo necesita una primera acción elegida por la persona y una ubicación que pueda explicar.

## 6.6 Usuario límite situacional

El usuario límite corresponde a un episodio en que la actividad digital es elegida, significativa, dirigida, relacional, concentrada o reparadora, o en que no existe una intención alternativa que requiera apoyo. P6 y P7 son contrastes claros; P4, P6 y P8 muestran variación según actividad.

La necesidad de este usuario no es recibir una intervención. Es conservar autonomía, discreción y control sobre la pertinencia de una ayuda. Si Relevo se activa por aplicación, duración o presencia del teléfono, puede interrumpir una videollamada, un pódcast elegido o un descanso que la persona considera coherente. En este patrón, permanecer inactivo, permitir el silencio o hacer posible una salida inmediata son comportamientos correctos.

## 6.7 Necesidades, tensiones y requisitos

**Tabla 2**

*Traducción de episodios a criterios situacionales*

| Dimensión | Usuario principal | Usuario límite | Estado |
| --- | --- | --- | --- |
| Necesidad | Mantener disponible una alternativa y su primer paso sin imponer su ejecución. | Preservar ocio, relación, concentración o descanso sin corrección externa. | Inferencia fundada en episodios. |
| Tensión | La actividad actual continúa después de que aparece una alternativa valorada. | Una señal mal dirigida convierte una actividad legítima en problema. | Evidencia e interpretación separadas. |
| Deseo | Disponer de acciones que se sientan valiosas o reparadoras, sin obligación de productividad. | Elegir si la ayuda es pertinente y detenerla sin justificar la decisión. | Orientación condicional. |
| Estrategia | Alejar, silenciar o cargar el teléfono en otro lugar; retorno variable. | Apartar el teléfono solo cuando el contexto lo requiere. | Autorreporte no observado. |
| Punto de fricción | Continuidad difícil de cerrar, alternativa poco disponible o retorno al teléfono. | Intrusión, exposición de una intención o carga de configuración. | Requisito de prueba. |
| No intervención | No activar sin intención alternativa y primer paso formulados. | No activar ante actividad elegida, significativa o coherente. | Decisión provisional. |

## 6.8 Recorrido del usuario principal

El recorrido actual documentado de P2 y P3 puede sintetizarse así:

1. **Inicio elegido o tolerado.** La sesión comienza como entretenimiento o descanso.
2. **Continuidad.** El contenido sucesivo mantiene la atención y hace disponible el siguiente elemento.
3. **Aparición de alternativa.** Surge el sueño, una actividad pendiente o la percepción de que había mejores opciones.
4. **Decisión inmediata.** La sesión continúa o se cierra con ambivalencia; la alternativa no logra orientar el paso.
5. **Reconstrucción posterior.** La persona recuerda con claridad, recuerda parcialmente o describe dificultad temporal.
6. **Separación intentada.** Se aleja o silencia el teléfono, con retorno variable.

Este recorrido no es una rutina universal. Se construye a partir de episodios y sirve para ubicar el posible momento de una señal. La activación no debe presentarse como detectada ya por Android.

## 6.9 Recorrido del usuario límite

El recorrido límite comienza con una actividad digital elegida y continúa con atención, relación, concentración o descanso. La persona recuerda lo ocurrido, reconoce su valor y no identifica una alternativa que requiera apoyo. La secuencia termina sin necesidad de corrección. P6 y P7 muestran que la duración puede ser extensa sin que exista la oportunidad de Relevo; P8 muestra que la valoración puede depender del estado de obligaciones y descanso.

El sistema debe diseñarse para no convertir una condición técnica en un juicio sobre este recorrido. Mientras no exista una intención alternativa formulada, no debe armarse una regla. Si la intención cambia después del armado, la persona debe poder desarmar sin que el sistema registre una inconsistencia.

## 6.10 Contexto doméstico como hipótesis

El hogar se propone como primer ámbito porque permite relacionar el objeto con materiales, superficies y primeros pasos, y porque varias estrategias de Q12 dependen de la distancia y el lugar de carga. Sin embargo, no se observaron sistemáticamente viviendas, convivientes, ruido, superficies, privacidad, movilidad ni disponibilidad de espacio.

El hogar no puede tratarse como un escenario homogéneo. Un sonido puede molestar o revelar una regla privada; una luz puede pasar inadvertida; una vibración puede no transmitirse a una mesa; un objeto visible puede ser desplazado por otra persona; una superficie puede ser necesaria para el primer paso. Estas variables deben entrar en el protocolo y no resolverse mediante una promesa de universalidad.

## 6.11 Implicaciones de usuario para el sistema

El sistema debe exigir una intención autoelegida y un primer paso concreto. Debe permitir que la persona elija el lugar y modifique la relación. Debe ofrecer señal sin texto, pero explicar estados técnicos en la aplicación. Debe permitir ignorar, silenciar, desarmar y continuar. No debe bloquear, puntuar, comparar ni registrar cumplimiento. Debe tratar la no pertinencia como resultado válido.

# 7. Estado del arte, mercado y referentes

## 7.1 Alcance y criterios de búsqueda

La búsqueda de mercado y referentes se cerró el 24 de agosto de 2026. Fue exploratoria y no sistemática. Se priorizaron fuentes de 2019 en adelante, con antecedentes anteriores cuando eran necesarios para la memoria prospectiva, el espacio, los recordatorios tangibles o el diseño de interacción. El corpus combinó artículos académicos, documentación oficial, páginas comerciales y fichas técnicas.

Las fuentes se clasificaron según su fuerza para cada afirmación. Las revisiones y metaanálisis orientan la consistencia del campo. Los estudios experimentales o longitudinales describen mecanismos concretos y condiciones acotadas. La documentación oficial informa funciones, compatibilidad declarada, requisitos y precios visibles. Las páginas comerciales muestran cómo una marca organiza su propuesta, pero no sostienen eficacia independiente.

La búsqueda no fue un estudio de patentes, disponibilidad en Chile, participación de mercado o disposición de pago. La oportunidad que se formula a continuación es relativa al corpus revisado y a su fecha de corte.

## 7.2 Qué muestra la evidencia académica

Biedermann et al. (2021) revisaron 28 intervenciones de autocontrol digital y observaron resultados variables. Las intervenciones de conciencia aislada mostraron efectos limitados en el conjunto revisado, mientras que los mecanismos restrictivos podían operar mejor cuando eran difíciles de eludir. La confianza general fue baja por tamaño de muestra, duración y comparabilidad. Esto no convierte el bloqueo en una solución incorrecta en todos los casos; indica que el mecanismo debe corresponder al problema y al contexto.

Monge Roffarello y De Russis (2023) sintetizaron 43 estudios, con una duración mediana de 21 días y solo cinco estudios que superaron dos meses. Su metaanálisis final reunió siete estudios y estimó un valor *g* de Hedges de 0,47 —una medida estandarizada de la magnitud del efecto—, con intervalo de confianza de 0,27 a 0,68, sobre reducción del uso no deseado. Estos números describen la literatura revisada, no un resultado de Relevo. Tampoco permiten equiparar reducción de uso con bienestar, recuperación de intención o autonomía.

Grüning et al. (2023) estudiaron one sec durante seis semanas y observaron cambios en aperturas de aplicaciones objetivo. Haliburton et al. (2024) analizaron una intervención de fricción en condiciones de uso real durante 13,4 semanas y describieron pausas y rebotes. Son antecedentes relevantes para estudiar persistencia y retorno, pero no examinan un testigo situado ni una comparación con lugar neutro.

Chiu y Gilbert (2024) observaron que el esfuerzo físico de establecer un recordatorio puede influir en la descarga estratégica de intenciones. Para Relevo, el resultado importa como advertencia sobre configuración, emparejamiento, reubicación y rearmado. No permite calcular un esfuerzo aceptable ni concluir que el objeto será abandonado.

## 7.3 Familias de mecanismos

El corpus revisado reúne respuestas que miden el uso, bloquean o dificultan el acceso, interrumpen la continuidad para abrir una reconsideración y separan físicamente el teléfono. Estas estrategias intervienen principalmente sobre la cantidad, la disponibilidad o la continuidad del uso (Biedermann et al., 2021; Monge Roffarello & De Russis, 2023; Grüning et al., 2023; Haliburton et al., 2024). Otros antecedentes externalizan citas mediante recordatorios tangibles o relacionan objetos, espacio, foco y recompensa (Hermann et al., 2007; Focusaur, s. f.). Frente a este conjunto, Relevo articula provisionalmente una relación distinta entre intención propia, primer paso y lugar; esta distinción no demuestra eficacia ni novedad universal.

La comunicación de campo cercano (NFC, por su sigla en inglés) permite intercambiar datos a muy corta distancia y se utiliza en algunas llaves o etiquetas físicas del mercado. En este análisis describe el mecanismo declarado por ciertos referentes; no forma parte de la arquitectura vigente de Relevo.

**Tabla 3**

*Familias de respuesta y límites para Relevo*

| Familia | Mecanismo principal | Ejemplos | Qué parece funcionar según la evidencia | Qué no resuelve para Relevo |
| --- | --- | --- | --- | --- |
| Medición | Mostrar tiempo, aperturas o categorías. | Screen Time, Digital Wellbeing. | Hace visible información de uso. | No recupera un primer paso situado ni distingue valor subjetivo. |
| Pausa o reconsideración | Introducir una detención breve antes de continuar. | one sec, Pause Point. | Puede abrir una ocasión para reconsiderar dentro del teléfono. | Mantiene significado y señal en la misma pantalla. |
| Fricción o bloqueo | Dificultar acceso, exigir espera o llave. | Brick, Unpluq, Screenless Breaker. | Puede alterar aperturas cuando la barrera es difícil de eludir. | Sustituye una transición libre por una restricción de acceso. |
| Separación física | Retirar o alejar el teléfono para reducir su disponibilidad. | kSafe y estrategias de alejamiento (Kitchen Safe, s. f.). | Puede introducir distancia o precompromiso. | No recupera por sí misma una intención propia ni la vincula con el lugar donde puede comenzar una actividad. |
| Objeto de foco | Asociar dispositivo, espacio, hábitos o recompensas. | Focusaur, Brick Zone. | Hace visible un compromiso o relaciona lugar y estado. | Puede introducir gamificación, bloqueo, costos y mantenimiento. |
| Recordatorio tangible | Vincular objetos y contexto con información o tareas. | *The Tangible Reminder*. | Muestra la posibilidad de externalizar una clave en el entorno. | Usa display o tareas distintas; no prueba un testigo ambiental situado para ocio. |

## 7.4 Herramientas nativas

Apple Screen Time y Google Digital Wellbeing ofrecen medición, temporizadores, límites y periodos de desconexión (Apple, s. f.; Google, s. f.-c). Su ventaja es la disponibilidad y el bajo costo adicional: no requieren un objeto, carga ni emparejamiento. Su límite para Relevo es que el significado de la intervención permanece dentro del teléfono y suele expresarse como tiempo, apertura, categoría o pausa.

Pause Point, comunicado por Google en 2026, acerca la plataforma a una intervención de reconsideración. Su disponibilidad está vinculada a versiones y dispositivos específicos, por lo que no se trata como una capacidad universal de Android (Google, s. f.-c; Sanders, 2026). El proyecto no necesita negar el valor de una pausa nativa. Necesita saber qué tendría que aportar un objeto externo para justificar su complejidad.

## 7.5 Aplicaciones de fricción

one sec ofrece fricciones configurables y seguimiento de aperturas, y su mecanismo ha sido estudiado en condiciones experimentales y de uso prolongado (one sec, s. f.; Grüning et al., 2023; Haliburton et al., 2024). Es el referente digital más próximo a la reconsideración antes de continuar. Su señal aparece dentro del flujo que concentra la atención y puede ser ignorada, sostenida o abandonada según la situación.

Para Relevo, one sec establece un control conceptual: si una intervención en pantalla entrega el mismo apoyo a la intención con menos costo y mantenimiento, el objeto pierde fundamento. La diferencia no debe buscarse en hacer una interrupción más intensa, sino en examinar si el entorno físico puede participar en la recuperación.

## 7.6 Objetos de barrera y llaves

Brick declara un dispositivo físico que funciona como llave para activar o revertir modos de bloqueo, con un precio visible de USD 59 y compatibilidad declarada con Android 12 o posterior e iOS 17 o posterior al momento de la consulta (Brick LLC, s. f.-a). Unpluq combina Tag, NFC, barreras, horarios y estadísticas, con un modelo que incluye suscripción (Unpluq, s. f.). Screenless Breaker ofrece una llave física NFC para volver a abrir aplicaciones bloqueadas y mostraba un precio de EUR 45 (Screenless, s. f.).

Brick Zone describe un dispositivo Bluetooth orientado a bloquear aplicaciones en espacios declarados y mostraba un precio de USD 99 (Brick LLC, s. f.-b). Estos productos prueban que existe una oferta comercial de objetos vinculados al control del teléfono. No prueban que el objeto pueda actuar como recordatorio no coercitivo ni que su relación espacial sea equivalente a la de Relevo.

## 7.7 Objetos de foco y recordatorios

Focusaur declara un dispositivo de foco con aplicación, movimiento del teléfono, etiquetas NFC, sonidos y funciones de hábito; su página mostraba USD 129 en oferta y un precio de referencia de USD 169 a la fecha de corte (Focusaur, s. f.). La oferta sirve para estudiar lenguaje de valor, componentes y modelo de negocio. La cifra de patrocinadores comunicada por la marca no se interpreta como adopción independiente. Su lógica de foco y recompensa no se incorpora a Relevo.

*The Tangible Reminder* vincula objetos con información de citas y un display ambiental (Hermann et al., 2007). El antecedente es útil para pensar la relación entre objeto, lugar y señal, pero presenta contenido visible, urgencia cromática y tareas temporales. Relevo distribuye el significado entre la aplicación, la memoria de la persona y la presencia del testigo situado.

## 7.8 Adopción, abandono y modelos de valor

La evidencia revisada muestra que una herramienta puede ser abandonada por dejar de ser necesaria, ser demasiado restrictiva, poder sortearse o exigir una configuración que no compensa. La persistencia no se deduce del interés inicial. Los estudios de one sec muestran que una fricción puede modificar aperturas en un periodo, pero también que la intervención puede producir pausas y rebotes. Chiu y Gilbert (2024) sitúan el esfuerzo de armado como parte del mecanismo.

Una línea reciente explora la reconfiguración de reglas en lugar de asumir que una intervención configurada una vez seguirá siendo pertinente. Kidel Peña-Albert et al. (2026) estudiaron una invitación a reconfigurar una herramienta de autocontrol digital: 63 de 138 personas del grupo experimental, equivalentes al 46 %, aceptaron la propuesta. El estudio aporta una señal acotada sobre la importancia de revisar reglas que pierden pertinencia; no demuestra que Relevo necesite personalización algorítmica ni que una mayor interacción con la herramienta equivalga a autonomía o bienestar.

Los modelos de mercado observados incluyen funciones integradas al sistema operativo, aplicaciones con funciones premium, suscripciones vinculadas a una etiqueta y dispositivos con aplicación complementaria. La existencia de un precio no indica disposición de pago. Para Relevo, el modelo de gestión tendrá que separar costo del prototipo, trabajo profesional, producción, soporte, reemplazo y precio hipotético.

## 7.9 Frontera phygital y oportunidad acotada

El corpus revisado combina herramientas digitales, llaves físicas, Bluetooth, NFC, espacios declarados, recordatorios tangibles y productos de foco. No se encontró en el corpus una evaluación independiente que reúna explícitamente una intención autoformulada, un primer paso, una condición digital, un testigo físico situado por la persona, ausencia de bloqueo y comparación con una notificación. Esta formulación no afirma inexistencia universal; delimita una oportunidad investigable.

La oportunidad de Relevo se acota a una especialización provisional: recuperar una intención propia en el lugar donde puede comenzar su primer paso. El proyecto no convierte la medición, el bloqueo, la interrupción o la separación física en su mecanismo principal, sino que investiga si una señal situada puede devolver esa intención a la escena donde puede iniciarse, manteniendo abierta la decisión. La notificación es el control porque el testigo debe demostrar que aporta algo más que un mensaje. Esta formulación no acredita eficacia, adopción ni novedad universal.

# 8. Síntesis de investigación y oportunidad de diseño

## 8.1 De la evidencia a la decisión

La síntesis se organiza mediante la cadena evidencia → interpretación → requisito o no requisito → decisión → prueba → estado. Esta cadena evita que una observación se convierta directamente en especificación.

**Tabla 4**

*Matriz de trazabilidad de decisiones*

| Evidencia o fuente | Interpretación | Requisito o no requisito | Decisión | Prueba | Estado |
| --- | --- | --- | --- | --- | --- |
| P2 y P3 relatan continuidad junto con alternativa o pérdida temporal. | Puede existir una intención que no orienta el paso siguiente. | Requisito: intención formulada. No requisito: diagnosticar automatismo. | Usuario principal situacional. | P0 con intención y primer paso. | Provisional. |
| P5 relata ambivalencia y aburrimiento posterior. | La insatisfacción posterior no basta para probar intención desplazada. | Distinguir intención previa de valoración posterior. | Caso adyacente. | Codificación de alternativa previa. | Provisional. |
| P6 y P7 relatan actividades elegidas y valoradas. | Activar por duración interrumpiría ocio legítimo. | No activar por tiempo, aplicación o presencia del teléfono. | Usuario límite. | Casos sin intención alternativa. | Decidido como alcance. |
| Q12 recoge alejar, cargar o silenciar. | La separación física pertenece al repertorio de algunas personas. | Explorar lugar, no asumir eficacia doméstica. | Lugar manual. | Lugar congruente frente a neutro. | Provisional. |
| Teoría de memoria prospectiva y espacio. | Una clave requiere una relación comprensible. | Intención, primer paso y lugar. | Testigo junto al primer paso. | P0 y P1. | Hipótesis. |
| Costo de configuración y mercado físico. | Emparejar y rearmar agregan carga. | Configuración mínima y salida. | Una intención por ciclo. | Registro de pasos, errores y abandono. | Provisional. |
| Herramientas nativas y fricciones. | El teléfono ya puede medir, pausar y notificar. | El objeto debe demostrar valor específico. | Notificación como control. | P1 y comparación posterior. | Pendiente crítico. |
| Testigo físico situado. | Representa una intención fuera del flujo del teléfono, pero puede resultar ambiguo. | Pulso ambiental; significado conservado en la aplicación. | Dirección vigente. | Percepción y atribución. | Decisión e hipótesis. |
| Android y BLE. | Existe una ruta técnica, con permisos y fallos. | Condición observable y vencimiento. | Android inicial. | P3. | Pendiente. |

## 8.2 Principios de diseño

**Recuperación situada de una intención propia.** Relevo se especializa provisionalmente en volver presente una intención formulada por la persona en el lugar donde puede comenzar su primer paso. Este principio expresa una propuesta de valor provisional, no un efecto demostrado.

**Pertinencia situacional.** La ayuda solo resulta pertinente cuando una intención propia pierde capacidad para orientar el paso siguiente durante un episodio de continuidad digital poco deliberada. La condición técnica será un evento observable y configurable, todavía abierto; podrá iniciar el ciclo, pero no inferir por sí sola que una actividad es indeseada ni que la persona deba interrumpirla.

**No intervención como resultado.** La inactividad del sistema es correcta ante ocio elegido, actividad relacional, concentración, descanso o ausencia de alternativa.

**Valor físico específico.** El objeto debe aportar una relación explicable por presencia, ubicación o manipulación que una notificación no entregue de la misma forma.

**Autonomía reversible.** La persona puede configurar, modificar, ignorar, silenciar y desarmar. Continuar con el teléfono no produce deuda ni registro.

**Carga proporcional.** El armado, emparejamiento, prueba, carga y reubicación deben mantenerse en proporción con el valor investigado.

**Apertura a reformulación.** Si el testigo transportable falla, se modifica o reemplaza la dirección física sin convertir Relevo en una aplicación.

## 8.3 Oportunidad formulada

Relevo formula una ayuda phygital cuyo posible valor consiste en recuperar una intención propia allí donde puede comenzar su primer paso. A diferencia de respuestas orientadas a medir, bloquear, interrumpir la continuidad o separar físicamente el teléfono, la propuesta sitúa el énfasis en la relación entre intención, lugar y señal. La oportunidad existe solo si la persona puede reconstruir la intención y el primer paso sin consultar nuevamente el teléfono, si el lugar aporta un significado reconocible, si la señal no se vuelve intrusiva y si el conjunto compensa la carga que agrega.

La oportunidad no es un resultado de usuarios. Las personas entrevistadas no compararon productos, no probaron Relevo y no expresaron preferencia por su forma. La propuesta surge de la relación entre evidencia, marco teórico, mercado y criterios del autor. Sus decisiones deben permanecer trazables y revisables.

# 9. Propuesta proyectual y decisiones de diseño

## 9.1 Del problema a una dirección objetual

El desarrollo compara familias de objetos según asociación con el primer paso, percepción del pulso ambiental, autonomía, movilidad, carga de configuración, privacidad, convivencia, factibilidad técnica y producción. La matriz es una herramienta cualitativa del autor; no recoge preferencias de las personas entrevistadas.

El análisis se realiza en dos escalas. La primera pregunta qué familia conserva la relación entre aplicación, testigo, lugar y persona. La segunda pregunta si el objeto puede situarse, percibirse y silenciarse sin instrucciones excesivas. Una alternativa técnicamente sencilla que elimina la asociación manual puede resolver un artefacto, pero no necesariamente el problema de Relevo.

El criterio rector no es añadir una barrera al uso digital, sino conservar la relación intención–primer paso–lugar identificada en el estado del arte. Una decisión que desplace el centro hacia medir, bloquear, interrumpir por sí misma o separar el teléfono deberá considerarse una desviación de la oportunidad formulada, no una profundización de Relevo.

## 9.2 Familias exploradas

**Cuna o base de guardado.** Concentra carga y almacenamiento, pero fija el objeto a un punto y desplaza el sentido desde el primer paso hacia el guardado. Agrega volumen, contactos y piezas. Se descarta provisionalmente porque no es necesaria para estudiar asociación.

**Objeto de consulta con display.** Mostraría intención, estado o instrucciones, pero repetiría el contenido de la aplicación, aumentaría consumo y convertiría el testigo en otra superficie de lectura. Se descarta porque desplaza su función desde la presencia ambiental hacia la consulta de información.

**Faro fijo.** Puede ser perceptible y estable, pero limita la relación con primeros pasos diversos. Se conserva como alternativa conceptual, no como dirección inicial.

**Testigo transportable.** Permite situar manualmente la señal junto al primer paso y comparar un lugar congruente con uno neutro. Se selecciona como dirección provisional porque ajusta mejor con una asociación reversible. Sus riesgos son pérdida, reubicación, baja saliencia, mantenimiento y apariencia de alarma genérica.

## 9.3 Estado de forma y materialidad

La forma circular, la compacidad, la transportabilidad, la presencia reconocible y la posibilidad de manipular el objeto son hipótesis formales y metas de prototipado, no especificaciones finales. No se fija en esta memoria una medida, peso, color, autonomía, canal o material definitivo.

La compacidad no es solo una cuestión de tamaño. Debe permitir que la señal se perciba, que el objeto se sitúe, que la batería se mantenga, que los componentes puedan repararse y que el objeto no se confunda con una alarma. La transportabilidad puede facilitar la asociación, pero también aumenta pérdida y carga de traslado. La presencia debe ser suficiente para quien configuró el sistema sin imponerse a convivientes.

Luz, sonido y vibración son variables de prueba. La luz puede depender de línea de visión; el sonido puede alcanzar a otras personas; la vibración puede no transmitirse sobre todas las superficies. La configuración de canales no se declara universal ni accesible por anticipado.

## 9.4 Decisiones mantenidas y descartadas

**Tabla 5**

*Estado de decisiones de dirección*

| Elemento | Estado | Razón |
| --- | --- | --- |
| Sistema phygital | Mantener | La pregunta exige relación entre aplicación, objeto, lugar y persona. |
| Testigo físico situado | Mantener | Permite investigar la relación entre intención, primer paso, lugar y pulso ambiental. |
| Aplicación Android | Mantener para el prototipo inicial | Reúne capacidades nativas de consulta autorizada de uso y comunicación BLE en un único entorno de prueba. |
| Aplicación web | Descartar como capa operativa inicial | La distribución mediante URL no asegura compatibilidad BLE uniforme; las fuentes consultadas no identifican una capacidad equivalente a `UsageStatsManager`. |
| Aplicación iOS | Fuera del alcance inicial | Su integración es plausible, pero requiere una segunda arquitectura nativa y autorizaciones propias antes de validar el aporte del sistema. |
| Lugar manual | Mantener provisionalmente | La asociación pertenece a la persona, no a una detección automática. |
| Una intención y un primer paso | Mantener provisionalmente | Reduce ambigüedad y carga inicial. |
| Cuna o base | Descartar provisionalmente | No es necesaria para la primera pregunta y agrega piezas. |
| Display de consulta | Descartar por alcance | Duplica contenido y desplaza al testigo desde la presencia ambiental hacia otra superficie informativa. |
| Faro fijo | No seleccionar inicialmente | Reduce movilidad y variedad de contextos. |
| Testigo transportable | Seleccionar provisionalmente | Permite comparación situada/neutra y reubicación manual. |
| Forma, peso, color, autonomía | Pendiente | Requieren pruebas de percepción, manipulación, energía y producción. |
| Precio | Pendiente | Requiere costos reales, modelo de gestión y disposición de pago. |

## 9.5 Dirección física y criterio de refutación

La selección del testigo transportable cierra una dirección de investigación, no una forma final. Si la asociación no aparece, primero se revisarán señal, lugar, control, gesto y contexto. Si el conjunto físico no aporta diferencia frente a la notificación, la dirección se reformulará o abandonará. Cualquier dirección posterior de Relevo deberá conservar el carácter phygital y una interfaz objetual ambiental; si ninguna configuración de ese tipo sostiene un valor defendible, la formulación actual quedará refutada y volverá a investigación de diseño.

La evidencia negativa debe identificar qué fue refutado. Una señal puede fallar por su modalidad; un lugar, por su relación con el primer paso; el testigo, por su transportabilidad; la regla, por su momento; o el sistema, por su carga total. No corresponde convertir un fallo local en una conclusión sobre toda materialidad.

## 9.6 Resultado del desarrollo estructural

La dirección seleccionada se tradujo a una arquitectura de interacción antes de cerrar su forma. Este paso evita que la propuesta dependa de una imagen única del objeto y permite examinar qué debe comprender, decidir y recuperar la persona en cada momento. El ciclo quedó organizado en tres interacciones principales:

1. **Formular y preparar una intención:** registrar una intención, concretar su primer paso, seleccionar una condición provisional y revisar la configuración.
2. **Vincular, situar, probar y armar:** asociar el testigo correcto, ubicarlo junto al primer paso, comprobar el pulso en ese contexto y armar el ciclo explícitamente.
3. **Esperar, recibir y cerrar:** mantener la regla durante su vigencia, emitir un único pulso cuando exista una orden válida y permitir que la persona cierre, ignore, silencie o recupere un fallo técnico.

Nueve marcos sintetizan la ruta principal, tres por interacción. Una segunda capa amplía esa síntesis a 35 estados para comprobar permisos, salidas voluntarias, enlace, batería, vencimiento, cambio de lugar, recuperación y rearme. La expansión no agrega funciones: vuelve visibles las condiciones necesarias para que el ciclo sea comprensible y no confunda una decisión personal con un error técnico.

Los wireframes se desarrollaron en baja o media fidelidad. Su jerarquía y contenido son resultados proyectuales; su estilo, dimensiones de interfaz y componentes gráficos no constituyen una identidad final. Tampoco demuestran comprensión, accesibilidad o factibilidad. La cobertura completa se resume en el Anexo D y funciona como base para prototipos posteriores.

# 10. Sistema Relevo

## 10.1 Definición canónica

Relevo es un sistema phygital compuesto por:

1. una aplicación Android que conserva el significado de la intención y configura el ciclo;
2. una condición observable cuya forma sigue pendiente;
3. un enlace local, propuesto mediante Bluetooth Low Energy (BLE), que transporta patrones y estados técnicos;
4. un testigo físico situado, transportable y asociado a una intención activa, que emite un pulso ambiental;
5. un lugar que la persona elige y asocia manualmente con el primer paso;
6. una persona que interpreta, decide, ignora, silencia o modifica.

La aplicación conserva el contenido semántico de la intención; el testigo recibe solo el patrón y los parámetros indispensables para producir el pulso. Esta distribución evita convertir el objeto en otra interfaz de consulta. El lugar no es un sensor. La persona puede cambiar de decisión. Relevo no bloquea, clasifica, puntúa ni registra cumplimiento.

## 10.2 Elementos y límites

**Tabla 6**

*Responsabilidades del sistema*

| Elemento | Hace | No hace |
| --- | --- | --- |
| Persona | Formula intención y primer paso, elige condición, sitúa, arma, interpreta y decide. | No es diagnosticada, corregida ni calificada. |
| Aplicación | Conserva significado, configura, solicita permisos, vincula, prueba y comunica estados. | No detecta culpa, automatismo, emoción ni pertinencia subjetiva. |
| Regla local | Traduce una condición observable en una posible activación. | No traduce una intención psicológica. |
| Enlace BLE | Transporta un patrón y estados de entrega. | No localiza a la persona ni necesita enviar el texto de la intención. |
| Testigo | Emite señal no textual y permite una salida física por definir. | No muestra texto, historial, puntaje o respuesta correcta. |
| Lugar | Aporta contexto porque la persona lo asocia al primer paso. | No activa por sí mismo ni es detectado automáticamente. |

## 10.3 Caso doméstico mínimo

El caso mínimo considera una persona, una aplicación seleccionada, una intención, un primer paso, un lugar doméstico elegido, un testigo y una ventana armada. El objeto puede moverse, pero el sistema no sabe si fue trasladado. La persona debe poder reubicarlo, probarlo y rearmar. No se supone una habitación privada, una superficie disponible ni una convivencia compatible con sonido.

Este recorte permite estudiar la asociación antes de agregar múltiples usuarios, varias intenciones, geolocalización, detección ambiental o seguimiento. El hogar es una hipótesis de primer contexto porque permite observar materialidad y convivencia, pero las pruebas deberán declarar qué parte del contexto se observó realmente.

## 10.4 Secuencia de uso propuesta

La persona identifica una intención alternativa que desea mantener disponible y define un primer paso. En la aplicación registra el contenido semántico, selecciona una condición provisional y vincula el testigo. Luego sitúa el objeto junto al primer paso y realiza una prueba perceptiva. Antes de armar puede corregir intención, lugar o condición.

Durante la espera puede desarmar o modificar. Si la condición se cumple y el enlace entrega un comando vigente, el testigo emite la señal. La persona puede reconocer la intención, iniciar el primer paso, continuar con la actividad digital, ignorar o silenciar. No hay respuesta correcta.

El armado, desarmado y silencio son decisiones de interacción aún abiertas. Debe existir una salida clara para detener una señal activa, pero los gestos exactos solo se fijarán después de pruebas de comprensión y manipulación. Ningún gesto significa que la actividad alternativa fue realizada.

## 10.5 Candidatos de activación

**Uso continuo.** La señal se produce tras una permanencia de la aplicación seleccionada en primer plano dentro de una ventana armada. Puede ser fácil de explicar, pero confunde continuidad con intención y debe enfrentar cambios de aplicación, pantalla bloqueada y eventos tardíos.

**Uso acumulado en ventana.** La aplicación suma tiempo de primer plano dentro de una ventana y activa al alcanzar una condición. Tolera pausas, pero exige explicar reinicios, fragmentación y privacidad.

**Horario o franja.** La persona elige un momento en que podría recibir la señal, sin depender directamente de un evento de uso. Simplifica la técnica, pero puede aparecer sin relación con la actividad actual y convertirse en alarma.

La elección dependerá de comprensión, observabilidad, pertinencia temporal, permisos, vencimiento y fallos. La aplicación no puede decir que detectó automatismo o intención desplazada. La regla mínima de integración será una aplicación, una ventana armada, una condición observable, una señal, un vencimiento y una salida.

## 10.6 Privacidad y autonomía

La propuesta excluye cuentas, servicios en nube, geolocalización, micrófono, historial de cumplimiento, clasificaciones y rachas. Una condición basada en uso podría consultar localmente estadísticas durante una ventana armada; eso limita la circulación, pero no elimina el permiso ni el alcance técnico que el sistema operativo concede.

Los datos posibles son intención, aplicación seleccionada, condición, ventana, identificador del testigo, batería, permisos y errores. Cada dato requiere propósito, almacenamiento, retención, eliminación y exposición definidos. El testigo no recibe el texto de la intención ni funciona como localizador.

La privacidad también incluye quién puede leer la intención en el teléfono y qué revela una señal en un espacio compartido. La autonomía exige que la persona entienda el estado y pueda recuperar el control. Un botón de apagado no basta si el sistema no explica cuándo la señal está armada o si la persona siente que cambiar de intención equivale a fallar.

## 10.7 Alcance de plataforma

Android se selecciona como única plataforma del prototipo técnico integrado por razones de capacidad y alcance, no por una superioridad universal. `UsageStatsManager` permite consultar historial y estadísticas de uso cuando la persona concede una autorización especial, mientras las interfaces de Android para dispositivos asociados y BLE ofrecen rutas documentadas para comunicarse con un periférico cuando la aplicación no permanece visible. Estas capacidades permiten reunir en un entorno acotado la observación de una condición autorizada y el enlace con el testigo. No garantizan fiabilidad: permisos, proceso, restricciones de segundo plano, batería, desconexiones y diferencias entre dispositivos deberán probarse en P3 (Google, s. f.-a, s. f.-b, s. f.-d).

La web se descarta como capa operativa de este prototipo. Puede resolver configuración y comunicarse con BLE en ciertos navegadores, pero Web Bluetooth exige autorización e interacción iniciada por la persona, no posee compatibilidad uniforme y WebKit declara que no implementa esta API. Una dirección web ampliaría el acceso a la interfaz; sin embargo, las fuentes consultadas no permiten sostener una operación uniforme del sistema completo ni identifican una capacidad web equivalente a `UsageStatsManager` (Chrome for Developers, s. f.; WebKit, s. f.).

iPhone también queda fuera del alcance inicial. Su integración es plausible, pero no está demostrada para Relevo. Apple ofrece marcos nativos para actividad de aplicaciones y sitios, así como Core Bluetooth para accesorios; incorporarlos exigiría una segunda implementación, autorizaciones y restricciones propias. El proyecto prioriza demostrar primero la relación intención–lugar–testigo en una arquitectura Android. Web e iOS solo se reconsiderarán después de validar el aporte físico y evaluar recursos, privacidad y factibilidad de expansión (Apple Developer, s. f.-a, s. f.-b, s. f.-c).

# 11. Arquitectura de experiencia y flujos

## 11.1 Arquitectura mínima y aspiracional

La arquitectura mínima de Relevo debe permitir estudiar una relación, no resolver todos los contextos. Incluye una aplicación Android, una aplicación seleccionada, una intención, un primer paso, una condición observable pendiente, una ventana armada, un testigo físico situado, un patrón de señal y una salida. La activación inicial puede ser simulada por el investigador. En esta etapa no son requisitos la automatización, el enlace BLE, la batería ni la producción.

La arquitectura aspiracional podría consultar estadísticas de uso mediante UsageStatsManager, funcionar con la aplicación en segundo plano, mantener un enlace BLE, informar batería, recuperar estados y operar en distintos fabricantes. UsageStatsManager expone información de uso de aplicaciones bajo un permiso especial; no detecta automatismo ni garantiza una activación inmediata (Google, s. f.-d). La ejecución BLE en segundo plano depende de versión, fabricante, energía y configuración (Google, s. f.-a; Google, s. f.-b). La arquitectura aspiracional es una hipótesis técnica.

**Tabla 7**

*Niveles de arquitectura*

| Nivel | Componentes | Pregunta | No permite afirmar |
| --- | --- | --- | --- |
| Conceptual | Persona, intención, primer paso, lugar y señal simulada | ¿La relación se entiende? | Desempeño técnico. |
| Funcional | Objeto, canal, control de salida y asociación situada | ¿La señal se percibe y se atribuye? | Accesibilidad universal. |
| Técnico | Android, condición, BLE, estados, vencimiento y batería | ¿El evento se ejecuta y se recupera ante fallos? | Valor físico o autonomía doméstica. |
| Integrado | Sistema completo y piloto acotado | ¿La dirección conserva valor y carga proporcional? | Mercado, precio o adopción sostenida. |

## 11.2 Precondiciones, estados y puertas

Antes de armar una regla deben existir una intención alternativa y un primer paso concreto; una aplicación seleccionada; una condición expresada en términos observables; una ventana; un testigo vinculado; batería suficiente para la prueba; un lugar elegido; una señal perceptible; y una explicación comprensible de permisos y límites. Si una precondición es incierta, el sistema no debe emitir una señal inesperada.

**Tabla 8**

*Estados mínimos de experiencia y sistema*

| Estado | Entrada | Operación | Salida válida | Fallo asociado |
| --- | --- | --- | --- | --- |
| Sin configurar | No existe intención o primer paso | Crear o abandonar configuración | Configuración iniciada o reposo | Carga excesiva o intención ambigua. |
| Configurado | Intención, primer paso, condición y lugar registrados | Revisar y corregir | Listo para prueba | Texto o lugar no comprensible. |
| Vinculando | Testigo disponible | Emparejar y confirmar identidad | Vinculado | Objeto equivocado o permiso incompleto. |
| Probando lugar | Testigo situado | Emitir señal de prueba | Señal percibida o ajuste | Señal no percibida, intrusión o exposición. |
| Listo para armar | Permiso, vínculo, batería y prueba disponibles | Confirmar armado | Armado | Estado técnico incierto. |
| Armado | Ventana activa y regla vigente | Esperar condición | Condición cumplida o vencimiento | Permiso revocado, cambio de aplicación o regla ambigua. |
| Señal activa | Comando vigente recibido | Emitir señal y aceptar salida | Silencio, vencimiento o reposo | Comando tardío, señal persistente o no atribuida. |
| Reposo | Ciclo terminado o detenido | Conservar solo lo necesario | Nuevo ciclo o eliminación | Datos retenidos sin propósito. |

Las puertas son progresivas. La puerta de configuración examina si la intención puede expresarse sin opciones innecesarias. La puerta de vínculo verifica que el objeto correcto esté conectado. La puerta del lugar pregunta si la persona entiende qué relación está creando. La puerta de señal examina percepción y atribución. La puerta técnica observa condición, entrega y vencimiento. La puerta de rearmado examina si el ciclo puede repetirse sin convertirse en una obligación.

## 11.3 Flujo de usuario

1. **Formular:** la persona identifica una actividad alternativa y un primer paso.
2. **Configurar:** registra el significado en la aplicación y selecciona una condición todavía sujeta a decisión.
3. **Vincular:** asocia el testigo y confirma que corresponde al ciclo.
4. **Situar:** coloca el objeto junto al primer paso y explica por qué ese lugar importa.
5. **Probar:** ejecuta una señal breve y decide si el canal es perceptible, tolerable y privado.
6. **Armar:** activa la regla de manera explícita y puede abandonar antes de iniciar la ventana.
7. **Esperar:** la actividad digital ocurre sin que el sistema evalúe su valor.
8. **Recibir:** si la condición y el enlace lo permiten, el objeto emite la señal.
9. **Decidir:** la persona recuerda, inicia, continúa, ignora o silencia.
10. **Cerrar:** el ciclo vence, se silencia o se desarma; la persona puede cambiar la intención.

La consulta de la aplicación no debe ser necesaria para descifrar una señal cotidiana. Puede ser necesaria para configurar o revisar un estado técnico, pero esa dependencia debe distinguirse de la recuperación de la intención.

## 11.4 Flujo del sistema

La persona formula y decide. La aplicación conserva significado y estado. La regla local traduce una condición observable en un evento posible. El enlace transporta un patrón. El testigo señala sin texto. El lugar funciona como asociación experiencial y no como sensor.

Un comando debe incluir un identificador de ciclo, un patrón de señal y un vencimiento. El testigo debe ejecutar solo comandos vigentes y devolver un acuse técnico cuando sea posible. Si el comando llega tarde, se descarta; una señal tardía puede perder significado y no debe presentarse como cumplimiento de la regla. Si la conexión se pierde, la aplicación debe mostrar estado técnico y permitir desarmar.

## 11.5 Flujo técnico y fallos

El flujo técnico comienza cuando la persona arma la regla. Android consulta localmente la fuente de eventos que corresponda al prototipo. El permiso puede revocarse o quedar limitado por políticas de energía. BLE intenta transportar el patrón, pero depende de teléfono, objeto, batería y ventana. El testigo ejecuta la señal solo al recibir un comando vigente.

**Tabla 9**

*Estados técnicos y respuesta mínima*

| Situación | Evento | Respuesta mínima | No afirmar |
| --- | --- | --- | --- |
| Permiso revocado | La aplicación no puede consultar la condición | Mostrar estado, desarmar y explicar recuperación | Que la condición se evaluó. |
| Aplicación en segundo plano limitada | El sistema restringe ejecución | Registrar limitación y evitar señal inesperada | Compatibilidad universal. |
| Cambio de aplicación | La persona abandona la aplicación seleccionada | Aplicar política definida para el prototipo | Que la persona perdió intención. |
| Pantalla bloqueada | Cambia el estado de uso | Aplicar política y registrar estado técnico | Que la sesión continuó. |
| Pérdida de BLE | No se entrega el patrón | Informar, reintentar según ventana o volver a reposo | Que el testigo conserva la regla. |
| Batería insuficiente | El objeto no puede emitir | Avisar y permitir desarmar | Que la ausencia de señal fue ignorada. |
| Reinicio del objeto | Se pierde el estado local | Solicitar vínculo o prueba nuevamente | Que el estado persiste. |
| Comando tardío | Llega después del vencimiento | Descartar e informar fallo técnico | Que la señal conserva pertinencia. |
| Objeto movido | Cambia el lugar sin registro | Solicitar prueba y rearmado | Que la ubicación sigue siendo válida. |

Se distinguen cuatro fallos. Un **fallo de concepto** ocurre cuando la persona no entiende qué relación representa el objeto. Un **fallo perceptivo** ocurre cuando la señal no se detecta, se confunde o resulta invasiva. Un **fallo técnico** ocurre cuando condición, permiso, enlace, batería o vencimiento no se comportan como la regla declara. Un **fallo de convivencia** ocurre cuando la señal afecta a otras personas o expone una intención. Cada fallo exige una respuesta diferente.

## 11.6 Flujo de diseño

El flujo de diseño avanza de la pregunta a la prueba y de la prueba a la especificación:

1. Delimitar episodio pertinente y caso límite.
2. Formular intención y primer paso.
3. Probar asociación con señal simulada.
4. Comparar lugar congruente, lugar neutro y notificación.
5. Elegir canal y salida física.
6. Definir condición observable y vencimiento.
7. Probar enlace, estados y fallos.
8. Integrar una versión acotada.
9. Evaluar producción, mantenimiento y gestión.
10. Mantener, reformular, sustituir o abandonar la dirección física.

Una especificación que aparece antes de la pregunta debe tratarse como candidata. Esto se aplica a forma, canal, electrónica, duración, batería, materiales, costos y precio.

## 11.7 Accesibilidad, autonomía y convivencia

La accesibilidad es un conjunto de requisitos por investigar, no una propiedad universal anticipada. Deben distinguirse dimensiones visual, auditiva, táctil, cognitiva, motora y doméstica. Un pulso ambiental no resuelve por sí solo las barreras: distribuye la carga entre señal, control, explicación en la aplicación y contexto.

El criterio preventivo de destellos de las Pautas de Accesibilidad para el Contenido Web (WCAG, por su sigla en inglés) orienta el riesgo visual, pero cumplir una referencia no prueba percepción ni accesibilidad (World Wide Web Consortium, s. f.). La señal auditiva no es solución automática a la baja visibilidad. La vibración debe evaluarse sobre superficies reales. La aplicación debe explicar estados técnicos sin exigir consulta posterior para comprender la señal.

## 11.8 Mapa de datos y privacidad

**Tabla 10**

*Datos previstos y riesgos de exposición*

| Dato o estado | Propósito | Almacenamiento provisional | Riesgo | Requisito |
| --- | --- | --- | --- | --- |
| Intención | Mostrar y configurar significado | Teléfono | Lectura por terceros | Protección local y eliminación clara. |
| Primer paso y lugar | Preparar asociación | Teléfono | Revelar actividad privada | Control de acceso y edición. |
| Aplicación seleccionada | Evaluar condición técnica | Teléfono | Permiso de uso | Explicar alcance y desarmar. |
| Ventana y estado armado | Ejecutar regla | Teléfono | Persistencia no deseada | Vencer, reiniciar o eliminar. |
| Identificador del testigo | Vincular patrón | Teléfono y objeto | Asociación no autorizada | Emparejamiento comprensible. |
| Batería y errores | Recuperar funcionamiento | Teléfono | Carga de mantenimiento | Estado visible y acotado. |
| Cumplimiento | No necesario | No almacenar | Vigilancia y juicio | Excluir del producto. |

El procesamiento local limita la circulación, pero no equivale a privacidad absoluta. La investigación puede registrar eventos con consentimiento; el producto cotidiano no debe inferir ni guardar si la persona obedeció.

## 11.9 Cobertura de interacciones y recuperación

La arquitectura detallada contiene 35 estados agrupados en cinco familias: configuración; vinculación y prueba física; armado; espera y señal; cierre y recuperación. La ruta principal utiliza los estados 01, 05, 08, 11, 14, 16, 20, 23 y 25. Los restantes explican validaciones previas, decisiones de salida, fallos técnicos o estados límite. Esta distinción impide que cada contingencia se convierta en una nueva función o que el recorrido normal exija atención permanente al teléfono.

Los estados 23 y 24 cambian deliberadamente de soporte. El primero representa el pulso en la situación física donde se encuentra el primer paso; el segundo registra que continuar, ignorar, silenciar o iniciar la actividad son respuestas posibles. No son pantallas del testigo ni evidencias de que el sistema observe la conducta. La aplicación reaparece cuando la persona necesita configurar, comprender un estado técnico o recuperar el control.

La cobertura establece cuatro reglas de cierre. Primero, una orden expirada no produce una señal tardía. Segundo, un cambio de lugar obliga a repetir la prueba antes de armar. Tercero, una pérdida de vínculo o un reinicio no activa un rearme automático. Cuarto, eliminar, desarmar o cambiar de intención son salidas legítimas. El Anexo D presenta la matriz completa y permite relacionar cada estado con su decisión principal.

# 12. Producción, factibilidad y modelo de gestión

## 12.1 Factibilidad como cadena de preguntas

La factibilidad de Relevo no consiste en demostrar que una carcasa puede fabricarse. Consiste en establecer qué necesita cada pregunta, quién puede resolverla, qué recursos requiere, qué riesgos permanecen y qué condiciones permitirían sostener un testigo físico situado de señal ambiental. La producción comprende prototipado, fabricación, ensamblaje, prueba, reparación, mantenimiento y fin de vida. La escala comercial no se presume.

## 12.2 Etapas de prototipo por pregunta

**Tabla 11**

*Relación entre fidelidad, pregunta y evidencia requerida*

| Etapa | Representación | Pregunta | Evidencia |
| --- | --- | --- | --- |
| P0 | Carcasa o testigo simulado y activación manual | ¿La persona asocia intención, primer paso, lugar y señal? | Relatos, atribución, consulta y relación espacial. |
| P1 | Mismo testigo en lugar congruente/neutro y notificación de control | ¿El lugar y la materialidad agregan valor? | Diferencias cualitativas, carga, intrusión y autonomía. |
| P2 | Prototipos de señal y salida física | ¿Qué canal se percibe y tolera? | Percepción, atribución, privacidad, convivencia y salida. |
| P3 | Android, BLE, condición, ventana, batería y objeto | ¿La regla se explica y opera ante fallos? | Permisos, enlace, vencimiento, reinicios y comandos tardíos. |
| P4 | Integración de mayor fidelidad y piloto acotado | ¿La dirección conserva valor y carga proporcional? | Rearmado, habituación, pérdida, privacidad, mantenimiento y abandono. |

## 12.3 Electrónica y componentes candidatos

Los componentes son medios para responder preguntas, no decisiones finales. Un microcontrolador de desarrollo como ESP32-C3 puede facilitar el primer enlace por disponibilidad, pero su consumo no representa un producto final. Para una versión de bajo consumo se han considerado como candidatos un nRF52810 o nRF52811, un gestor de energía nPM1100, un actuador de luz, un piezo, un actuador resonante lineal (LRA, por su sigla en inglés) y un controlador háptico.

Las hojas técnicas describen componentes aislados. Nordic especifica capacidades del nPM1100 y del nRF52810; Precision Microdrives documenta el actuador LRA C08-00A; Texas Instruments documenta el controlador DRV2605L (Nordic Semiconductor ASA, s. f.-a, s. f.-b; Precision Microdrives Ltd., 2023; Texas Instruments, 2018). Estos datos no demuestran que el conjunto alcance una autonomía, una intensidad o una experiencia perceptiva determinada.

La fuente de energía y el sistema de carga permanecen como decisiones de ingeniería por probar. La elección deberá basarse en mediciones del ciclo real —reposo, enlace, señal, carga y recuperación—, además de temperatura, seguridad, posibilidad de reemplazo y fin de vida. Una ficha aislada de batería no permite anticipar la autonomía del sistema.

## 12.4 Fabricación, ensamblaje y reparación

La fabricación académica puede comenzar con carcasa impresa, apoyos y componentes accesibles. Una fase posterior podría usar una placa de circuito impreso propia, una carcasa más resistente y una guía de señal separada, pero solo después de cerrar asociación, canal y enlace. Un prototipo demostrativo no debe presentarse como producto industrial.

La reparación debe contemplar batería, placa, actuadores, botón, difusor y carcasa. Un cierre reversible facilita diagnóstico y reemplazo, aunque puede reducir protección. La solución no se declara reparable hasta observar si el componente puede cambiarse sin introducir un riesgo nuevo. El mantenimiento mínimo incluye carga, revisión de vínculo, reubicación, prueba, rearmado, actualización o reinstalación de la aplicación y restablecimiento del testigo.

El fin de vida requiere separar batería, placa, carcasa y elementos de señal, además de definir qué parte puede reutilizarse. La responsabilidad del diseñador incluye no diseñar una pieza sellada o desechable sin justificarla mediante evidencia de seguridad, costo y reparación.

## 12.5 Costos diferenciados

La planificación económica separa cuatro magnitudes:

1. **Costo de prototipo académico:** componentes, impresión o fabricación, reposición, ensamble, herramientas y contingencia.
2. **Trabajo profesional:** investigación, diseño de experiencia, diseño industrial, electrónica, desarrollo Android, coordinación, análisis y documentación.
3. **Costo de producción:** proveedores, placa de circuito impreso, carcasa, batería, ensamblaje, prueba, certificación, logística, impuestos, merma, soporte y garantía.
4. **Precio:** decisión posterior que requiere costos reales, modelo de mantenimiento, alternativas y disposición de pago.

La lista base corregida se sitúa entre CLP 51.140 y CLP 92.640. Con una contingencia de 15 %, los extremos son CLP 58.811 y CLP 106.536; se comunica redondeada como **CLP 59.000–107.000**. Es una planificación no cotizada para una etapa de prototipo. No incluye horas profesionales, certificación, producción en serie, impuestos, soporte ni desempeño.

No se fija precio. La cifra de una unidad no puede multiplicarse para inferir producción. La escala introduce moldes, pruebas, rechazo, proveedores, almacenamiento, cumplimiento, garantía y soporte. Si la materialidad no aporta valor reconocible, un precio no la justifica.

## 12.6 Android, BLE y cumplimiento

UsageStatsManager puede exponer eventos de paquetes bajo un permiso especial, pero no detecta estados subjetivos ni garantiza tiempo real (Google, s. f.-d). Companion Device Pairing puede apoyar el vínculo cercano, aunque no crea por sí solo una conexión persistente (Google, s. f.-b). Las restricciones de ejecución BLE en segundo plano dependen de versión y fabricante (Google, s. f.-a). Las aplicaciones que requieran servicios en primer plano deben revisar los requisitos de distribución de Android (Google Play, s. f.).

Android es una plataforma inicial de prototipo. No se presenta compatibilidad universal, cobertura de fabricantes ni confiabilidad alcanzada. La integración deberá probar permisos, pantalla bloqueada, aplicación en segundo plano, cambio de aplicación, reinicio, batería, reconexión y vencimiento.

Un producto con radio deberá revisar el régimen aplicable a equipos de alcance reducido, documentación, ensayo, etiquetado y declaración de conformidad de SUBTEL (Subsecretaría de Telecomunicaciones, 2026). El prototipo académico no equivale a certificación.

## 12.7 Mapa de actores y modelo de gestión

El diseñador coordina el sistema, pero no puede garantizar por sí solo radio, batería, certificación, compatibilidad o producción. Cada promesa requiere una colaboración o una prueba.

**Tabla 12**

*Actores, responsabilidades y entregables*

| Actor | Responsabilidad | Entregable o decisión |
| --- | --- | --- |
| Diseñador y autor | Problema, criterios, flujos, hipótesis, protocolos, decisiones y documentación. | Memoria, prototipos, matrices y registro de fallos. |
| Dirección académica | Revisar pertinencia, evidencia, límites y coherencia. | Puertas de revisión. |
| Desarrollo Android | Configuración, permisos, condición, estados y recuperación. | Aplicación de prueba y registros técnicos. |
| Electrónica | Circuito, BLE, energía, actuadores y seguridad. | Testigo, mediciones y manejo de fallos. |
| Diseño industrial | Forma, ensamblaje, protección, reparación y fin de vida. | Carcasa, documentación y pruebas físicas. |
| Investigación y accesibilidad | Protocolos, consentimiento, observación y análisis. | Instrumentos, codificación y límites. |
| Fabricación y proveedores | Componentes, impresión, placa de circuito impreso, ensamblaje y cotizaciones. | Partidas reales y condiciones de producción. |
| Cumplimiento | Radio, seguridad, batería y distribución. | Requisitos y documentación aplicable. |

El diseñador tiene una responsabilidad de detención: un componente técnicamente posible no entra al producto porque esté disponible; una señal perceptible no se convierte en promesa de accesibilidad; un costo estimado no se convierte en precio; y un plan no se convierte en resultado por estar documentado.

## 12.8 Riesgos, mantenimiento y fin de vida

Los riesgos se organizan por concepto, percepción, técnica, convivencia, accesibilidad y economía. Un fallo de concepto se aborda volviendo a intención, primer paso, lugar y señal. Un fallo perceptivo exige comparar canal, superficie y alcance. Un fallo técnico exige estados, vencimiento, desarmado y recuperación. Un fallo de convivencia exige revisar exposición, privacidad y control de alcance. Un riesgo económico exige separar planificación y cotización.

El mantenimiento empieza en la configuración. La persona crea una intención, concede permisos, vincula, sitúa, prueba y arma. Si reubica el objeto, debe repetir la prueba y armar. Si baja la batería, la aplicación debe explicar la limitación y orientar la carga o el desarmado. La reparación debe considerar batería, placa, actuadores, botón, difusor y carcasa. El fin de vida debe separar batería y electrónica y evitar una pieza sellada sin justificación.

La escala se considera solo cuando la dirección conserva función, señal, privacidad, reparación, mantenimiento y gestión en pruebas más amplias. Si existe aporte físico pero falla el testigo transportable, se modifica esa capa y se mantiene una interfaz objetual ambiental dentro del sistema phygital. Si ninguna configuración aporta una diferencia, se abandona la dirección física actual y se vuelve a investigación de diseño.

# 13. Plan de prototipado y evaluación

## 13.1 Estado de la evidencia y preguntas de evaluación

Las ocho entrevistas fueron realizadas presencialmente en Santiago los días 11 y 12 de junio de 2026. Constituyen evidencia exploratoria sobre episodios relatados, no una evaluación de Relevo. Q13 se refirió al concepto histórico In(Visible), por lo que solo orienta de manera condicional el tono discreto y no punitivo; no permite afirmar aceptación, eficacia, preferencia ni valor físico de Relevo. A la fecha de cierre de esta memoria no existen resultados de prototipos, comparación entre ubicaciones, comparación con una notificación ni integración Android–BLE.

Relevo se mantiene como sistema phygital: una aplicación configura el significado, un testigo físico situado emite un pulso ambiental y la persona lo asocia manualmente con un lugar y un primer paso. La notificación del teléfono será un control comparativo, no la solución final. Si el testigo transportable no aporta una diferencia reconocible, deberá reformularse o reemplazarse la dirección física; el proyecto no se convertirá en una aplicación sola.

Las hipótesis operativas son:

### H1. Asociación situada

Una intención, un primer paso, un lugar y una señal pueden formar una clave recuperable sin consultar continuamente la aplicación. Se debilita si la persona no puede explicar la relación o depende de texto y ayuda del investigador.

### H2. Aporte físico situado

El testigo en un lugar congruente podría aportar algo que no aparece con el mismo testigo en un lugar neutro ni con una notificación equivalente. Se debilita si las tres condiciones producen la misma comprensión y la notificación exige menos carga.

### H3. Percepción, autonomía y convivencia

La señal podría percibirse y atribuirse sin transformarse en alarma, vigilancia o reproche, y podría ignorarse, silenciarse o detenerse. Se debilita si invade la convivencia, expone una intención privada o no ofrece una salida clara.

### H4. Ejecución técnica

La activación, el vínculo entre aplicación y objeto y el vencimiento de una condición podrían operar de forma legible en el entorno Android/BLE elegido. Se debilita ante estados ambiguos, señales tardías o recuperación técnica desproporcionada. No se presupone compatibilidad universal.

La condición de activación permanece abierta entre continuidad de uso, acumulación dentro de una ventana y horario programado. El número de participantes, la duración y el reclutamiento del prototipo permanecen pendientes de un protocolo anterior a cualquier aplicación. Ninguna meta técnica o perceptiva se presenta como resultado.

## 13.2 Ruta progresiva P0–P4

La secuencia aumenta la fidelidad solo después de resolver la pregunta anterior. Cada puerta puede conservar, modificar o detener una dirección.

### P0. Asociación con activación simulada

Se pregunta si la persona relaciona intención, primer paso, lugar y pulso ambiental cuando el investigador activa el evento manualmente. El material puede ser un testigo de baja fidelidad, una ficha de configuración y un escenario acotado. Se registran explicación espontánea, recuerdo de intención y primer paso, consulta al teléfono, intrusión, autonomía y posibilidad de ignorar o silenciar. P0 no prueba Android, BLE, cambio de conducta ni uso doméstico. Si la asociación depende de una explicación posterior o se interpreta como alarma, se vuelve a formular la señal antes de avanzar.

### P1. Lugar congruente, lugar neutro y notificación de control

Solo si P0 es interpretable, se compara el mismo testigo físico en un lugar congruente y uno neutro con una notificación equivalente. La notificación controla el aporte de la modalidad; no es un reemplazo de Relevo. Deben mantenerse comparables intención, primer paso y claridad del mensaje, y registrarse orden, razón de elección, comprensión, consulta, intrusión y salida. Si el lugar no agrega una relación distinguible o la notificación entrega el mismo valor con menor carga, se reformula la dirección física.

### P2. Canales de señal y salida

Se examinan alternativas visuales, auditivas y táctiles como variables de prueba, no como soluciones universales. La persona debe poder describir qué percibió y silenciar o detener la señal sin regresar a la aplicación. Se observan atribución, convivencia, superficie, movilidad, solicitudes de ayuda y autonomía. Si ningún canal permite una señal comprensible y reversible, se modifica o reemplaza el testigo.

### P3. Condición Android/BLE y fallos

Se prueba en banco la condición de activación aún abierta, el enlace BLE, el vencimiento y la recuperación ante permisos revocados, batería baja, desconexión, cambio de aplicación, pantalla bloqueada, reinicio, objeto movido y señal tardía. Se separan fallos de concepto, percepción, técnica y convivencia. La prueba no demuestra desempeño fuera del dispositivo y versión documentados. Si la técnica obliga a una operación desproporcionada, se prueba una arquitectura más simple o se regresa a P2.

### P4. Integración y piloto acotado

Solo después de las puertas anteriores se integran aplicación, objeto, lugar, condición, canal y salida. El contexto, el número de participantes, la duración, el reclutamiento, el consentimiento y el manejo de retiros se fijarán antes de ejecutarlo. Se registran episodios, cambios, silencios, abandonos y fallos, sin puntuar cumplimiento. Un piloto no permite afirmar eficacia poblacional, adopción, precio, accesibilidad universal ni autonomía prolongada.

## 13.3 Registro y regla de decisión

Cada prueba conservará versión, fecha, contexto, consentimiento, códigos de participantes, materiales, procedimiento, evidencia primaria, interpretación, limitaciones y decisión. Hecho, evidencia, inferencia, hipótesis, decisión de alcance y pendiente deben permanecer diferenciados. La activación simulada no se describirá como automatización; un registro técnico correcto no se describirá como experiencia comprensible. La dirección se mantiene solo si converge una asociación situada, una salida autónoma y una ejecución proporcional. Si el objeto no aporta frente a la notificación, la formulación física vigente queda refutada y vuelve a investigación de diseño, manteniendo el carácter phygital y una interfaz objetual ambiental en cualquier dirección posterior.

## 13.4 Instrumentos y trazabilidad de evaluación

Cada puerta se documentará mediante una ficha de prueba y una matriz de casos. La ficha identificará la versión del sistema, la pregunta que se intenta responder, la hipótesis relacionada, la condición comparada, el material utilizado, el procedimiento, el contexto, los participantes codificados, el consentimiento, los incidentes y la decisión siguiente. La matriz reunirá por separado lo que la persona hizo o dijo, la evidencia que permite sostenerlo, la interpretación del investigador, la hipótesis que permanece abierta y la decisión que se desprende de la prueba. Esta separación evita que una impresión favorable se convierta en eficacia o que un fallo técnico se interprete como refutación automática de la necesidad.

El registro de P0 y P1 deberá distinguir al menos cinco estados: la persona percibió la señal; pudo atribuirla al sistema; recuperó la intención; identificó el primer paso; y decidió qué hacer después. Consultar el teléfono, continuar con la actividad digital, ignorar la señal o modificar la intención no se codificarán como incumplimientos. En P2 se añadirá la posibilidad de silenciar o detener el objeto y la incidencia sobre la convivencia. En P3 se registrarán los estados técnicos y su recuperación; en P4 se observará la relación entre configuración, uso, rearmado, mantenimiento y abandono.

Las decisiones serán formativas y comparativas, no una suma de puntuaciones. Un caso puede sostener una asociación y, al mismo tiempo, mostrar una señal intrusiva; una falla de enlace puede exigir simplificar la arquitectura sin negar el problema; y una buena comprensión en laboratorio puede no transferirse a una vivienda. Por eso cada ficha deberá conservar también contraejemplos, condiciones ambientales y razones de descarte. La memoria solo incorporará como resultado aquello que tenga una ejecución documentada; todo lo demás permanecerá formulado como hipótesis, decisión provisional o pendiente.

# 14. Conclusiones, contribución, límites y próximos pasos

## 14.1 Conclusión actual

La investigación delimita una situación, no un diagnóstico general: una actividad digital puede continuar cuando una intención alternativa ya fue reconocida o valorada, pero esa misma actividad puede ser elegida, significativa, relacional o reparadora. Por eso la duración, la aplicación y la presencia del teléfono no bastan para decidir una intervención. El usuario principal y el usuario límite son patrones situacionales, no identidades demográficas.

La contribución alcanzada hasta aquí es una formulación investigable de esa tensión y una arquitectura que distribuye significado entre aplicación, testigo físico situado, lugar y persona. El desarrollo estructural permite describir la propuesta como un ciclo coherente de configuración, asociación, señal y recuperación, con tres interacciones principales, nueve marcos de síntesis y 35 estados diferenciados. Este resultado organiza lo que debe probarse; no demuestra que la experiencia sea comprensible o valiosa. La evidencia no permite afirmar que Relevo mejore recuerdo, ejecución, autonomía, bienestar, adopción o continuidad de una intención. Tampoco permite sostener todavía la condición Android/BLE, el costo, la producción ni la superioridad del objeto frente a una notificación.

## 14.2 Contribuciones actuales y aporte esperado

**Tabla 13**

*Contribuciones según estado de desarrollo*

| Tipo de aporte | Estado actual | Alcance legítimo |
| --- | --- | --- |
| Investigación | Revisión de literatura y mercado, más ocho entrevistas reales codificadas P1–P8. | Delimita episodios, variaciones y condiciones de no intervención; no estima prevalencia. |
| Formulación | Problema, pregunta, usuario principal, usuario límite e hipótesis H1–H4. | Hace evaluable la relación entre intención, señal, lugar y autonomía; no la valida. |
| Arquitectura | Sistema phygital de aplicación, testigo físico situado, lugar manual y persona. | Organiza dependencias y puertas; no demuestra factibilidad integrada. |
| Desarrollo estructural | Tres interacciones, nueve marcos de síntesis y una cobertura de 35 estados. | Hace visibles recorrido, salidas y fallos; no constituye una prueba de uso. |
| Método | Ruta P0–P4 y comparación con notificación. | Define qué evidencia falta y cuándo detener una dirección. |
| Artefacto esperado | Testigo situado, señal no textual y salida autónoma, si las pruebas lo sostienen. | Aporte eventual; si falla, debe reformularse o reemplazarse la dirección física, nunca reducir Relevo a una aplicación. |

*Nota.* La tabla separa contribuciones documentadas de aportes dependientes de pruebas futuras.

## 14.3 Límites

La muestra fue reclutada por referencias y la edad fue el único criterio común confirmado; el rango observado fue de 19 a 27 años y P6 tiene 27 años. No se dispone de duración individual, audio ni notas manuscritas originales. El consentimiento informado fue oral, pero no se conserva el texto exacto de la explicación entregada. La transcripción posterior fue regularizada y anonimizada, por lo que se privilegian paráfrasis. Q13 trató In(Visible), no Relevo.

No se observó sistemáticamente el hogar, sus superficies, convivientes, ruido, distancias, privacidad o desplazamiento del objeto. No se han ejecutado P0–P4 ni pruebas de accesibilidad, convivencia, privacidad doméstica, autonomía, adopción o disposición de pago. Los wireframes estructuran recorridos posibles, pero no demuestran comprensión, preferencia, desempeño o valor. Android, BLE, activación, enlace, batería, vencimiento, costos, producción, reparación y cumplimiento siguen siendo hipótesis, metas o pendientes según la sección correspondiente. La planificación económica de prototipo permanece en CLP 59.000–107.000 no cotizados; no constituye costo de producción ni precio. La interpretación no tuvo un segundo codificador independiente. Las referencias de mercado describen funciones y afirmaciones públicas, no eficacia de Relevo.

## 14.4 Próximos pasos por dependencia

1. Cerrar el protocolo, consentimiento y registro de P0, incluyendo la distinción entre recordar una intención y ejecutar su primer paso.
2. Ejecutar P0 con activación simulada y decidir si la asociación es comprensible sin texto ni consulta obligada.
3. Si procede, comparar en P1 lugar congruente, lugar neutro y notificación de control.
4. Resolver en P2 canal, intensidad, salida, convivencia y accesibilidad situada; no declarar universalidad.
5. Probar en P3 la condición de activación, Android/BLE y fallos previsibles; solo entonces definir los parámetros técnicos necesarios.
6. Establecer el número de participantes, la duración, el reclutamiento y el contexto de P4; después estimar producción, mantenimiento y costos con cotizaciones reales.
7. Actualizar este cierre con resultados, contraejemplos y decisiones. Si ninguna capa física aporta un valor específico, volver a investigación de diseño y sustituir la dirección física sin convertir Relevo en una aplicación aislada.

# Referencias

Apple. (s. f.). *Get started with Screen Time on iPhone*. Recuperado el 24 de agosto de 2026, de https://support.apple.com/en-ie/guide/iphone/iphb0c7313c9/ios

Apple Developer. (s. f.-a). *Core Bluetooth*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/CoreBluetooth

Apple Developer. (s. f.-b). *Device Activity*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/DeviceActivity

Apple Developer. (s. f.-c). *Family Controls App and Website Usage*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/bundleresources/entitlements/com.apple.developer.family-controls.app-and-website-usage

Biedermann, D., Schneider, J. y Drachsler, H. (2021). Digital self-control interventions for distracting media multitasking: A systematic review. *Journal of Computer Assisted Learning, 37*(5), 1217–1231. https://doi.org/10.1111/jcal.12581

Brick LLC. (s. f.-a). *Brick: Take back your time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/

Brick LLC. (s. f.-b). *Brick Zone*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/pages/brick-zone

Chiu, G. y Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

Chrome for Developers. (s. f.). *Communicating with Bluetooth devices over JavaScript*. Recuperado el 25 de agosto de 2026, de https://developer.chrome.com/docs/capabilities/bluetooth

de Segovia Vicente, D., Van Gaeveren, K., Murphy, S. L. y Vanden Abeele, M. M. P. (2024). Does mindless scrolling hamper well-being? Combining ESM and log-data to examine the link between mindless scrolling, goal conflict, guilt, and daily well-being. *Journal of Computer-Mediated Communication, 29*(1), zmad056. https://doi.org/10.1093/jcmc/zmad056

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Gilbert, S. J., Boldt, A., Sachdeva, C., Scarampi, C. y Tsai, P.-C. (2023). Outsourcing memory to external tools: A review of “intention offloading”. *Psychonomic Bulletin & Review, 30*(1), 60–76. https://doi.org/10.3758/s13423-022-02139-4

Goldsmith, L. J. (2021). Using framework analysis in applied qualitative research. *The Qualitative Report, 26*(6), 2061–2076. https://doi.org/10.46743/2160-3715/2021.5011

Gollwitzer, P. M. y Sheeran, P. (2006). Implementation intentions and goal achievement: A meta-analysis of effects and processes. *Advances in Experimental Social Psychology, 38*, 69–119. https://doi.org/10.1016/S0065-2601(06)38002-1

Google. (s. f.-a). *Communicate in the background*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (s. f.-b). *Companion device pairing*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing

Google. (s. f.-c). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Recuperado el 24 de agosto de 2026, de https://support.google.com/pixelphone/answer/9137850?hl=en

Google. (s. f.-d). *UsageStatsManager*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/reference/android/app/usage/UsageStatsManager

Google Play. (s. f.). *Foreground service requirements for apps targeting Android 14 or higher*. Google Play Console Help. Recuperado el 24 de agosto de 2026, de https://support.google.com/googleplay/android-developer/answer/17105854

Grüning, D. J., Riedel, F. y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), e2213114120. https://doi.org/10.1073/pnas.2213114120

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A. y Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (Artículo 243, pp. 1–16). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hermann, M., Mahler, T., de Melo, G. y Weber, M. (2007). The tangible reminder. En *Proceedings of the 3rd IET International Conference on Intelligent Environments* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

Hiniker, A., Hong, S., Kohno, T. y Kientz, J. A. (2016). MyTime: Designing and evaluating an intervention for smartphone non-use. En *Proceedings of the 2016 CHI Conference on Human Factors in Computing Systems* (pp. 4746–4757). Association for Computing Machinery. https://doi.org/10.1145/2858036.2858403

Kidel Peña-Albert, A., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C. y Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, e85349. https://doi.org/10.2196/85349

Kitchen Safe. (s. f.). *kSafe*. Recuperado el 24 de agosto de 2026, de https://intl.thekitchensafe.com/

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Lukoff, K., Yu, C., Kientz, J. A. y Hiniker, A. (2018). What makes smartphone use meaningful or meaningless? *Proceedings of the ACM on Interactive, Mobile, Wearable and Ubiquitous Technologies, 2*(1), Artículo 22. https://doi.org/10.1145/3191754

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M. y Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (Paper 21, pp. 1–18). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

McDaniel, M. A. y Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*, S127–S144. https://doi.org/10.1002/acp.775

Meier, A. y Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Monge Roffarello, A. y De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53, 1–66. https://doi.org/10.1145/3571810

Montag, C., Lachmann, B., Herrlich, M. y Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), 2612. https://doi.org/10.3390/ijerph16142612

Nordic Semiconductor ASA. (s. f.-a). *nPM1100 product specification*. Recuperado el 24 de agosto de 2026, de https://docs.nordicsemi.com/r/bundle/ps_npm1100/page/keyfeatures_html5.html

Nordic Semiconductor ASA. (s. f.-b). *nRF52810 product specification*. Recuperado el 24 de agosto de 2026, de https://docs-be.nordicsemi.com/bundle/nRF52810-PS/raw/resource/enus/nRF52810_PS_v1.1.pdf

O’Rear, A. E. y Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

Precision Microdrives Ltd. (2023). *C08-00A: 8 mm linear resonant actuator* [Hoja de datos]. https://precisionmicrodrives.com/cdn/datasheets/C08-00A%20-%20datasheet%20-%20002/c08-00a-datasheet-002.pdf

Radtke, T., Apel, T., Schenkel, K., Keller, J. y von Lindern, E. (2022). Digital detox: An effective solution in the smartphone era? A systematic literature review. *Mobile Media & Communication, 10*(2), 190–215. https://doi.org/10.1177/20501579211028647

Real, R., Snider, C. M., Goudswaard, M. A. y Hicks, B. J. (2021). Dimensions of knowledge in prototyping: A review and characterisation of prototyping methods and their contributions to design knowledge. *Proceedings of the Design Society, 1*, 1303–1312. https://doi.org/10.1017/pds.2021.130

Risko, E. F. y Gilbert, S. J. (2016). Cognitive offloading. *Trends in Cognitive Sciences, 20*(9), 676–688. https://doi.org/10.1016/j.tics.2016.07.002

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Sohn, T., Li, K. A., Lee, G., Smith, I., Scott, J. y Griswold, W. G. (2005). Place-Its: A study of location-based reminders on mobile phones. En M. Beigl, S. Intille, J. Rekimoto y H. Tokuda (Eds.), *UbiComp 2005: Ubiquitous computing* (Lecture Notes in Computer Science, Vol. 3660, pp. 232–250). Springer. https://doi.org/10.1007/11551201_14

Stapley, E., O’Keeffe, S. y Midgley, N. (2022). Developing typologies in qualitative research: The use of ideal-type analysis. *International Journal of Qualitative Methods, 21*, 1–9. https://doi.org/10.1177/16094069221100633

Subsecretaría de Telecomunicaciones. (2024). *Informe final: Undécima encuesta sobre acceso, usos y usuarios de internet en Chile 2024*. Ministerio de Transportes y Telecomunicaciones, Gobierno de Chile. https://www.subtel.gob.cl/wp-content/uploads/2025/02/Informe-Final-Subtel-Acceso-y-Uso-Internet-2024.pdf

Subsecretaría de Telecomunicaciones. (2026, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Texas Instruments. (2018). *DRV2605L: 2- to 5.2-V haptic driver for LRA and ERM with effect library and Smart-Loop architecture* [Hoja de datos]. https://www.ti.com/lit/ds/symlink/drv2605l.pdf

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Waggoner, J., Lucky, S., Redick, S., Rizki, A. y Yu, J. C. (2026). Going beyond digital libraries: A literature review of phygital user experience research methods. *International Journal on Digital Libraries, 27*(1), Artículo 1. https://doi.org/10.1007/s00799-025-00436-6

WebKit. (s. f.). *Tracking prevention in WebKit*. Recuperado el 25 de agosto de 2026, de https://webkit.org/tracking-prevention/

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 24 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold

# Anexos selectivos

## Anexo A. Ficha metodológica del corpus

La matriz individual P1–P8 se presenta en la Tabla 1 del capítulo 6. Este anexo reúne las condiciones del levantamiento sin duplicar los perfiles.

**Tabla A1**

*Condiciones documentadas del estudio cualitativo*

| Campo | Registro disponible | Límite de uso |
| --- | --- | --- |
| Técnica | Entrevistas semiestructuradas, habladas y presenciales. | No constituyen observación directa ni evaluación de Relevo. |
| Fecha y lugar | Santiago, 11 y 12 de junio de 2026. | El lugar describe el levantamiento, no una población de generalización. |
| Reclutamiento | Referencias de la red personal. | Introduce sesgo de selección. |
| Criterio común | Edad; rango observado de 19 a 27 años. | La edad describe la muestra y no define por sí sola al usuario. |
| Consentimiento | Informado y oral. | No se conserva el texto exacto de la explicación entregada. |
| Registro actual | Transcripción regularizada y anonimizada como P1–P8. | No hay audio, duración individual ni notas manuscritas originales disponibles. |
| Preguntas | Q1–Q11 y preguntas presenciales adicionales Q12–Q13, todas realizadas por el investigador. | Q13 se refirió a In(Visible), no a Relevo. |
| Unidad de análisis | Episodio y segmento pregunta–respuesta. | Los conteos descriptivos no estiman prevalencia. |

*Nota.* El apoyo automatizado ocurrió después del levantamiento y no generó preguntas, repreguntas ni respuestas. El material no permite atribuir preferencias sobre Relevo ni sobre su forma.

## Anexo B. Jerarquía de afirmaciones

**Tabla B1**

*Estados utilizados para controlar el alcance de las afirmaciones*

| Categoría | Qué significa en esta memoria | Ejemplo de uso |
| --- | --- | --- |
| Evidencia | Registro de entrevista, cita académica, documentación oficial o dato técnico de una fuente. | P2 relata continuidad después de reconocer el sueño. |
| Inferencia | Lectura analítica derivada de una o más evidencias, con alcance limitado. | Conviene mantener una alternativa disponible sin imponerla. |
| Hipótesis | Proposición que debe ponerse a prueba. | El lugar congruente puede aportar una clave situada. |
| Decisión de alcance | Restricción adoptada para orientar el proyecto. | Relevo es phygital y el testigo comunica mediante un pulso ambiental. |
| Pendiente | Decisión o resultado que todavía no existe. | Activación, número de participantes, duración y reclutamiento de P0–P4. |
| Descartado | Dirección que contradice el mecanismo o el alcance vigente. | Bloqueo, puntaje y registro de cumplimiento como solución. |

Esta jerarquía impide convertir una fuente, una interpretación o una intención de diseño en resultado de producto. Las decisiones de alcance no equivalen a validación; las hipótesis no equivalen a preferencias de las entrevistas.

## Anexo C. Resumen del protocolo P0–P4

**Tabla C1**

*Puertas de evaluación y evidencia requerida*

| Puerta | Pregunta principal | Activación y material | Evidencia para avanzar |
| --- | --- | --- | --- |
| P0 | ¿Se entiende la relación intención–primer paso–lugar–señal? | Activación simulada; testigo físico o sustituto de baja fidelidad. | Asociación espontánea, recuerdo, consulta, intrusión y salida. |
| P1 | ¿El lugar aporta frente a lugar neutro y notificación? | Mismo objeto, dos lugares y notificación equivalente. | Diferencia situada interpretable y carga comparable. |
| P2 | ¿La señal se percibe, atribuye y detiene sin reproche? | Canales visual, auditivo y táctil como alternativas de prueba. | Percepción, atribución, convivencia y autonomía de salida. |
| P3 | ¿La condición y el enlace sobreviven a fallos? | Android/BLE seleccionado para banco; estados y fallos registrados. | Vencimiento, recuperación, batería, permisos y señal tardía legibles. |
| P4 | ¿La arquitectura completa es proporcional en un contexto acotado? | Aplicación, objeto, lugar y señal integrados. | Convergencia de asociación, aporte físico, autonomía y ejecución. |

En todas las puertas el número de participantes, la duración y el reclutamiento del prototipo permanecen pendientes. El consentimiento y el registro se fijarán antes de la aplicación. Ninguna puerta mide eficacia poblacional ni autoriza una aplicación sola como sustituto de Relevo.

## Anexo D. Cobertura estructural del ciclo

**Tabla D1**

*Estados de interacción y decisión principal*

| N.º | Familia | Estado | Decisión o respuesta principal |
| ---: | --- | --- | --- |
| 01 | Configuración | Sin configurar | Crear una intención. |
| 02 | Configuración | Datos incompletos | Completar o corregir los datos mínimos. |
| 03 | Configuración | Permiso requerido | Revisar el alcance del permiso o cambiar la condición. |
| 04 | Configuración | Permiso no concedido | Abrir ajustes, cambiar la condición o salir. |
| 05 | Configuración | Revisión | Editar o continuar para situar el testigo. |
| 06 | Configuración | Salida voluntaria | Guardar, descartar o seguir editando. |
| 07 | Vinculación y prueba | Buscando testigo | Esperar, reintentar o cancelar. |
| 08 | Vinculación y prueba | Elegir y confirmar testigo | Vincular el dispositivo correcto. |
| 09 | Vinculación y prueba | Testigo incorrecto o no reconocido | Volver a buscar. |
| 10 | Vinculación y prueba | Batería baja | Cargar o posponer. |
| 11 | Vinculación y prueba | Probar lugar | Emitir un pulso de prueba. |
| 12 | Vinculación y prueba | Señal no percibida | Ajustar o reubicar y volver a probar. |
| 13 | Vinculación y prueba | Señal intrusiva | Reducir, cambiar el lugar o no armar. |
| 14 | Vinculación y prueba | Listo para armar | Continuar al armado, volver a probar o salir. |
| 15 | Armado | Armado en curso | Esperar confirmación o cancelar. |
| 16 | Armado | Armado confirmado | Dejar el sistema en espera o desarmar. |
| 17 | Armado | Confirmación ambigua o fallo | Reintentar, revisar vínculo o cancelar. |
| 18 | Armado | Desarmado voluntario | Cerrar o volver a preparar. |
| 19 | Armado | Edición durante ciclo activo | Conservar el ciclo o desarmar antes de editar. |
| 20 | Espera y señal | Armado en espera | Consultar estado o desarmar. |
| 21 | Espera y señal | Condición cumplida y orden válida | Enviar la orden vigente al testigo. |
| 22 | Espera y señal | Orden expirada | Cerrar sin pulso o preparar otro ciclo. |
| 23 | Espera y señal | Pulso físico activo | Percibir y decidir libremente. |
| 24 | Espera y señal | Respuesta al pulso | Continuar, ignorar, silenciar o iniciar la actividad. |
| 25 | Cierre y recuperación | Cierre decidido | Terminar el ciclo sin registrar cumplimiento. |
| 26 | Cierre y recuperación | Intención cambiada | Cerrar o reformular. |
| 27 | Cierre y recuperación | Permiso revocado | Recuperar permiso, desarmar o cerrar. |
| 28 | Cierre y recuperación | Restricción en segundo plano | Ajustar la restricción o cerrar. |
| 29 | Cierre y recuperación | Pérdida de vínculo BLE | Reconectar, reintentar o cerrar. |
| 30 | Cierre y recuperación | Testigo movido | Repetir la prueba de lugar. |
| 31 | Cierre y recuperación | Batería crítica | Cargar, desarmar o cerrar. |
| 32 | Cierre y recuperación | Reinicio del testigo | Verificar vínculo y repetir la prueba antes de armar. |
| 33 | Cierre y recuperación | Vencimiento sin activación | Cerrar o preparar un nuevo ciclo. |
| 34 | Cierre y recuperación | Rearme explícito | Revisar nuevamente antes de continuar al armado. |
| 35 | Cierre y recuperación | Eliminar configuración | Confirmar eliminación o cancelar. |

*Nota.* La tabla documenta cobertura de diseño. Los estados no equivalen a pantallas obligatorias ni a comportamientos observados. La ruta principal y las recuperaciones deberán simplificarse o modificarse según los resultados de P0–P4.

# Registro de cambios (disclaimer)

**Fecha:** 24 de agosto de 2026.

**Archivo y versión anterior.** Se creó `08_memoria/memoria-vigente-v2.md` como candidata integral y se preservó `08_memoria/memoria-vigente.md` como versión anterior. La nueva memoria sintetiza los siete módulos de reconstrucción registrados en `08_memoria/borradores-v2/`; no corresponde a una suma literal de esos documentos.

**Contenido mantenido.** Se conservaron el problema de continuidad digital poco deliberada, el valor del ocio elegido, la intención alternativa, la condición de no intervención, el carácter phygital, la interfaz objetual ambiental, Android como plataforma inicial de prueba y el corpus anonimizado P1–P8.

**Contenido reemplazado o corregido.** La descripción general del público fue sustituida por un usuario principal y un usuario límite situacionales. El levantamiento se formuló como estudio cualitativo exploratorio mediante entrevistas semiestructuradas; se precisaron reclutamiento, consentimiento, tratamiento posterior y límites del registro. Q13 quedó restringida al concepto histórico In(Visible). El mercado se reorganizó por mecanismos y por fuerza de fuente. Los flujos, datos, producción, costos, gestión y evaluación se separaron según evidencia, inferencia, hipótesis, decisión y pendiente.

**Contenido retirado.** Se eliminaron como especificaciones cerradas la forma coral, dimensiones, peso, color, canal, autonomía, materiales, precio y umbrales de validación que no contaban con pruebas. También se retiró la comparación prematura entre baterías específicas y cualquier formulación que presentara planes como resultados de Relevo.

**Correcciones cuantitativas y metodológicas.** Se mantuvieron las fechas de entrevistas del 11 y 12 de junio de 2026, el rango observado de 19 a 27 años, P6 con 27 años y la edad como único criterio común confirmado. La lista de materiales se recalculó sobre una base de CLP 51.140–92.640; con 15 % de contingencia resulta CLP 58.811–106.536 y se comunica redondeada como CLP 59.000–107.000, sin cotizaciones. El plan P0–P4 no fija número de participantes, duración ni reclutamiento sin protocolo previo.

**Correcciones de la auditoría final.** Se definieron siglas y conceptos técnicos en su primera aparición; se separó la función del testigo físico de su valor asociativo todavía hipotético; se incorporó investigación de 2026 sobre reconfiguración de intervenciones; se numeró la tabla de contribuciones; y el anexo metodológico dejó de repetir la matriz individual ya presente en el capítulo 6.

**Referencias, anexos y estado de evidencia.** Se consolidó una lista única de referencias APA 7 en español y se conservaron anexos selectivos sobre metodología, jerarquía de afirmaciones y protocolo. No se añadieron respuestas, preferencias, cotizaciones, especificaciones ni resultados de prototipo inexistentes. La activación, la comparación física, Android/BLE, accesibilidad, convivencia, producción y aporte del artefacto permanecen pendientes de evaluación.

**Alineación con el historial de encargos.** Tras revisar la secuencia acumulativa de encargos, se restituyeron la identificación académica, el índice visible y la motivación personal; se hicieron localizables los títulos de planteamiento del problema, formulación, propuesta proyectual y mapa de actores; y se explicitaron los tres ámbitos del marco teórico y los siete componentes de la teoría de cambio. Antes, estos contenidos estaban ausentes o distribuidos entre capítulos sin los títulos exigidos. Se incorporaron para hacer reconocible la arquitectura académica sin eliminar la ampliación propia del Proyecto de Título. En una revisión posterior se sustituyó la definición negativa del objeto por la formulación positiva **testigo físico situado que representa una intención activa y emite un pulso ambiental**; la exclusión de una interfaz de consulta permanece solo como requisito técnico y no como propuesta de valor.

**Corrección de formulación funcional.** Se reemplazaron dos expresiones residuales que definían la interfaz objetual mediante una exclusión. Antes, el apartado de pertinencia y la tesis provisional destacaban una característica ausente; ahora describen la relación entre configuración digital, testigo situado y pulso ambiental. La arquitectura electrónica específica sigue abierta y este cambio no agrega resultados de validación.

**25 de agosto de 2026 — Especialización derivada del estado del arte.** Se articuló explícitamente la cadena entre familias de respuesta existentes, límites observados, oportunidad y propuesta proyectual. Antes, medición, bloqueo, interrupción, separación y recuperación situada aparecían distribuidos entre los capítulos 7, 8 y 9; ahora fundamentan una especialización provisional única: recuperar una intención propia en el lugar donde puede comenzar. Se añadió la fuente primaria de kSafe para respaldar la familia de separación física y se distinguió pertinencia situacional de condición técnica. El cambio no atribuye eficacia a Relevo ni afirma novedad universal.

**25 de agosto de 2026 — Alcance Android.** Se añadió una comparación explícita entre Android, web e iPhone y se cerró Android como única plataforma del prototipo técnico integrado. Antes, Android figuraba como una ruta provisional sin justificación comparativa; ahora se fundamenta por capacidades nativas y concentración de recursos. Web se descarta como capa operativa e iPhone queda fuera del alcance inicial, sin declararlos inviables para expansiones futuras. Se añadieron las fuentes oficiales correspondientes; la condición de activación y el desempeño permanecen pendientes.

**Archivos afectados.** Las intervenciones del 25 de agosto modifican `08_memoria/memoria-vigente-v2.md`, sincronizan `08_memoria/resumen-vigente-proyecto.md` y actualizan la documentación asociada en `06_desarrollo_y_factibilidad` y `09_decisiones`.

**25 de agosto de 2026 — Cierre editorial e incorporación del desarrollo estructural.** Se actualizó el estado del proyecto y se incorporaron como resultados de diseño las tres interacciones principales, los nueve marcos de síntesis y la cobertura de 35 estados. Antes, la memoria describía flujos y estados mínimos, pero no registraba el desarrollo exhaustivo realizado posteriormente ni distinguía sus soportes. Se añadieron los apartados 9.6 y 11.9, la Tabla D1, una fila de contribución estructural y límites explícitos sobre el valor probatorio de los wireframes. También se reemplazó en la ficha la formulación negativa de la tesis por su definición funcional mediante pulso ambiental y testigo situado. El documento queda cerrado editorialmente para el estado real del proyecto; no se agregaron resultados de prototipo, preferencias, factibilidad o eficacia inexistentes.

**25 de agosto de 2026 — Corrección APA de obras sin fecha de Google.** Se reordenaron alfabéticamente `Manage how you spend time...` y `UsageStatsManager`, y se actualizaron sus sufijos de `s. f.-c/d` en el cuerpo. Antes, los sufijos seguían el orden de incorporación de las fuentes y no el orden alfabético de títulos requerido para obras del mismo autor sin fecha. El cambio es exclusivamente bibliográfico y no modifica la argumentación técnica ni proyectual.
