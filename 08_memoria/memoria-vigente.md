---
id: MEM-VIG-001
titulo: "Memoria vigente de Relevo"
autoria: Johan Yantén
estado_documental: vigente
relacion_con_proyecto: "base escrita activa del proyecto de título"
sensibilidad: anonimizada
version_base: "memoria-relevo-sistema-editorial-v3.md"
fuente_base_sha256: 525edebd9bef5246adc7e80f323b5ca3670aaea982f15afde520384eb0d6ae1d
fecha_actualizacion: 2026-08-24
---

# Memoria vigente de Relevo

## Estado de la versión

Este documento constituye la base escrita vigente del proyecto. Deriva de la versión editorial v3, seleccionada por contener la formulación más desarrollada de Relevo, pero corrige su metodología, elimina referencias a entregas docentes del cuerpo académico, actualiza el mercado y distingue decisiones, hipótesis y pendientes.

UNIVERSIDAD DIEGO PORTALES / ESCUELA DE DISEÑO

RELEVO

Un testigo phygital doméstico que devuelve una intención al lugar donde puede comenzar

MEMORIA DE PROYECTO DE TÍTULO / VERSIÓN DE TRABAJO

Johan Yantén

Profesores guía: Sergio Majluf y Simón Gallardo

Santiago de Chile · 24 de agosto de 2026

## Resumen

El ocio digital puede ser significativo, social y reparador. El problema abordado por esta investigación no es su duración ni su existencia, sino una situación más precisa: durante algunas sesiones que se prolongan de manera automática, una intención que la persona también valoraba deja de estar disponible en su decisión. Las herramientas de bienestar digital suelen responder a ese fenómeno midiendo, bloqueando o retrasando aplicaciones; ofrecen menos apoyo para volver perceptible una alternativa elegida por la propia persona y vinculada con un lugar de acción.

La investigación articula revisión bibliográfica sobre ocio digital significativo, conflicto de metas, memoria prospectiva, descarga de intenciones y cognición situada; ocho entrevistas semiestructuradas presenciales realizadas en Santiago con personas adultas jóvenes de 19 a 27 años; y un análisis comparativo de productos y proyectos. El registro permite sostener que seis participantes reconocieron sesiones difíciles de describir posteriormente, uno lo hizo de manera parcial y uno no reconoció el problema. También muestra que el ocio digital focalizado puede ser recordado y valorado, y que las alternativas nombradas son actividades concretas que el diseño traduce en posibles primeros pasos. Por el tamaño y naturaleza del estudio, estos hallazgos orientan el diseño, pero no estiman prevalencia ni validan un producto.

La síntesis conduce a Relevo: un testigo activo, circular y sin pantalla que se sitúa junto al primer paso de una actividad. La persona configura en Android una intención, su primer paso y una condición aproximada de devolución; luego arma el testigo y lo ubica. Cuando se cumple la condición, el objeto emite una o más modalidades configurables de luz, sonido y vibración. La señal se extingue sola y un único botón permite silenciarla de inmediato; continuar con el teléfono no se registra como fracaso. El proyecto propone validar, antes de automatizar por completo, si la asociación entre objeto, lugar e intención aporta más que una notificación. Su contribución esperada es materializar la descarga de una intención con un objeto pequeño y una meta de costo acotada, sin bloquear, calificar ni definir qué forma de ocio es correcta.

**Palabras clave:** memoria prospectiva; descarga de intenciones; ocio digital; diseño phygital.

## Abstract

Digital leisure can be meaningful, social, and restorative. This research does not treat its duration or existence as the problem. It examines a more specific situation: during some sessions that continue automatically, an intention the person also valued becomes unavailable to their decision. Digital wellbeing tools commonly address this phenomenon by measuring, blocking, or delaying applications; fewer support a person in making a self-chosen alternative perceptible again and connecting it to a place where action can begin.

The study combines a literature review on meaningful digital leisure, goal conflict, prospective memory, intention offloading, and situated cognition; eight in-person semi-structured interviews conducted in Santiago with young adults aged 19 to 27; and a comparative analysis of products and projects. The available record supports that six participants recognized sessions they later found difficult to describe, one reported this partially, and one did not recognize the issue. It also shows that focused digital leisure may be remembered and valued, and identifies concrete activities that design can translate into possible first steps. This translation is a design inference. Given the study's size and format, these findings guide design but do not estimate prevalence or validate a product.

The synthesis leads to Relevo: an active, circular, screenless token placed beside the first step of an activity. Through an Android application, the person configures an intention, its first step, and an approximate return condition; they then arm and place the token. When the condition is met, the object emits one or more configurable modalities of light, sound, and vibration. The cue ends automatically, and a single button can silence it immediately; continuing to use the phone is not recorded as failure. Before full automation, the project proposes testing whether the association among object, place, and intention adds value beyond a notification. Its intended contribution is to materialize intention offloading through a small object with a bounded cost target, without blocking, scoring, or prescribing a correct form of leisure.

**Keywords:** prospective memory; intention offloading; digital leisure; phygital design.

## Índice

1. Introducción: una intención que deja de participar    6

2. Del tiempo de pantalla al problema de diseño    6

3. Marco teórico: recordar hacer, no solo recordar lo vivido    7

4. Consulta exploratoria y contexto de uso    8

5. Formulación de la investigación y del proyecto    10

6. Estado del arte: qué existe y qué falta    11

7. Del criterio a la forma    12

8. Relevo: propuesta de diseño    14

9. Factibilidad tecnológica, productiva y económica    16

10. Metodología de prototipado y validación    17

11. Arquitectura de experiencia    19

12. Conclusiones    21

13. Referencias    23

Anexo A. Trazabilidad del estudio de junio    27

Anexo B. Instrumentos para la siguiente etapa    28

Anexo C. Factibilidad y especificación detalladas    29

Anexo D. Protocolo de prototipado y validación    32

Anexo E. Declaración de uso de inteligencia artificial    35

**Figura 1**

*Hipótesis de Relevo como sistema distribuido entre aplicación Android, testigo físico y ubicación elegida*

> **Figura conservada en la fuente DOCX:** image2.png. Véase el [manifiesto de medios](../99_archivo/fuentes-locales/semestre-2/memorias/manifesto-de-medios.md).

*Nota.* Modelo conceptual; relaciones y desempeño por validar.

Relevo es un sistema phygital doméstico compuesto por una aplicación Android, un testigo sin pantalla y una ubicación elegida. La app conserva intención, primer paso y condición; el testigo emite una clave de recuperación; el lugar aporta contexto; y la persona recuerda y decide.

PARTE I / OBSERVAR

## 1. Introducción: una intención que deja de participar

### 1.1 Escena e hipótesis

Una persona decide salir a caminar y formula un primer paso: ponerse las zapatillas. En Android configura una condición aproximada y deja un pequeño testigo junto al calzado. Más tarde usa Instagram. Al cumplirse la condición, el testigo emite una señal breve de luz, timbre y vibración. Su ubicación puede ayudar a reconstruir la asociación; la persona puede levantarse o continuar. Relevo no bloquea ni evalúa la respuesta.

La escena describe una hipótesis, no un efecto demostrado. Debe comprobarse si la señal se percibe, si la asociación se recuerda sin abrir la app y si el objeto agrega valor frente a una notificación o al mismo testigo ubicado en un lugar neutro.

### 1.2 Evolución del problema

El proyecto comenzó preguntando qué quedaba en la memoria después de una sesión extensa de teléfono. Esa formulación confundía duración, recuerdo y calidad del ocio, y no justificaba un objeto físico. La revisión del primer semestre permitió desplazar la pregunta: lo relevante no es cuánto dura una experiencia digital, sino si durante algunas sesiones otra intención elegida deja de participar en la decisión.

Relevo investiga cómo una intención futura puede recuperarse mediante una clave externa situada. La app conserva la formulación y la condición; el lugar aporta contexto; el testigo llama la atención. El significado no reside completo en el objeto y la conducta posterior permanece fuera del sistema.

### 1.3 Alcance y aporte disciplinar

El MVP se acota al ocio doméstico de adultos jóvenes que reconocen episodios de continuidad poco deliberada y quieren mantener disponible una actividad concreta. Trabaja con una persona, un testigo, una intención, una aplicación seleccionada y un lugar asociado. Android es la única plataforma prevista; no se desarrollará iOS.

Relevo no diagnostica adicción, no trata insomnio, no prescribe productividad y no detecta un estado subjetivo de automatismo. Su aporte pertenece al diseño de interacción y producto: traducir memoria prospectiva y descarga de intenciones a un sistema físico-digital comprensible, situado, comprobable y respetuoso de la autonomía.

## 2. Del tiempo de pantalla al problema de diseño

### 2.1 Duración no equivale a valor

La conectividad explica que parte del ocio ocurra en pantalla, pero no describe su calidad. En Chile, el 96,5 % de los hogares declaró acceso propio y pagado a internet (Subsecretaría de Telecomunicaciones, 2024). Lukoff et al. (2018), al estudiar 86.402 sesiones, mostraron que propósito, valoración posterior y autonomía distinguen experiencias que una métrica temporal trataría como equivalentes. Meier y Reinecke (2021) y Radtke et al. (2022) también advierten resultados heterogéneos en bienestar y desconexión digital. Relevo no puede usar reducción de pantalla como criterio principal.

### 2.2 Continuidad automática y conflicto

Desplazamiento continuo, reproducción automática y contenido encadenado reducen cierres que podrían solicitar una decisión renovada (Montag et al., 2019). Sin embargo, ninguna función prueba por sí sola pérdida de control. Aquí, «continuidad digital automática» designa operacionalmente una sesión que se prolonga sin elección renovada reconocida por la persona y en la que otra intención deja de estar disponible.

En 1.315 adultos, de Segovia Vicente et al. (2024) reunieron 67.762 mediciones momentáneas; 26.708 contaron con registros pareados de 691 usuarios Android. Un mayor desplazamiento sin propósito se asoció con culpa y el conflicto de metas medió parcialmente esa relación. El diseño observacional no permite causalidad, pero desplaza la atención desde los minutos hacia la relación entre actividad e intención. Un producto que califica jornadas podría amplificar culpa (Reinecke y Meier, 2020).

### 2.3 Qué ofrecen las herramientas actuales

En la muestra de 367 herramientas de Lyngs et al. (2019), el 74 % incorporaba bloqueo o eliminación de distracciones; al mapear funciones a autorregulación, predominaban características preventivas frente al apoyo de hábitos deseados. MyTime permitía seleccionar aplicaciones, fijar un límite y formular una aspiración que reaparecía al alcanzarlo; en dos semanas con 23 participantes disminuyó el uso de aplicaciones evaluadas como poco satisfactorias, sin cambiar el de las satisfactorias (Hiniker et al., 2016). Pause Point introduce una espera no bloqueante y alternativas, pero su comunicación pública no informa evaluación de eficacia (Sanders, 2026).

### 2.4 Brecha de diseño

Durante ciertas sesiones domésticas de ocio digital que se prolongan sin elección renovada, una intención autoelegida puede dejar de participar. Las respuestas disponibles se concentran en medir, bloquear o retrasar; existe espacio para investigar una clave situada que vuelva perceptible una alternativa sin imponerla.

La propuesta debe resolver cuatro tensiones: saliencia sin alarma, apoyo sin coerción, ubicación sin pérdida de alcance y automatización sin falsa precisión.

## 3. Marco teórico: recordar hacer, no solo recordar lo vivido

### 3.1 Memoria prospectiva

La memoria episódica describe acontecimientos pasados (Tulving, 2002), pero Relevo se ocupa de una acción futura. McDaniel y Einstein (2000) definen la memoria prospectiva como recordar realizar una acción prevista y proponen que la recuperación depende de la tarea, la señal, la relación señal–intención y la persona. Por ello no basta una alarma temporal genérica: la clave debe distinguirse y conservar una asociación pertinente.

### 3.2 Descarga de intenciones

La descarga cognitiva modifica el entorno para reducir demanda interna (Risko y Gilbert, 2016). Gilbert et al. (2023) revisan la *descarga de intenciones*: crear señales externas que apoyen una intención diferida, desde alertas hasta objetos ubicados estratégicamente. Vortac et al. (1995) observaron en una tarea controlada que las claves externas apoyaron principalmente la recuperación de acciones pendientes. Ningún antecedente demuestra que una señal no verbal recupere una intención de ocio en el hogar; esa relación es la hipótesis de Relevo.

La externalización propuesta es distribuida. La app conserva texto, primer paso y condición; el testigo emite una señal no semántica; el lugar puede reforzar una asociación; y la persona reconstruye el significado. Una sola intención activa reduce el riesgo de recordar que «hay algo pendiente» sin saber qué.

### 3.3 Condición y primer paso

Las intenciones de implementación vinculan una situación anticipada con una respuesta propia (Gollwitzer y Sheeran, 2006). Relevo comparte solo esa estructura condicional: automatiza la aparición de una señal, no la conducta posterior. El marco ayuda a especificar condición y primer paso, pero no permite anticipar que la persona actuará. La formulación correcta es: «si la app seleccionada alcanza aproximadamente el umbral, emitir la señal asociada con salir a caminar»; un primer paso posible es ponerse las zapatillas.

### 3.4 Espacio, percepción y autonomía

Organizar el espacio puede dirigir atención y hacer visibles relaciones que de otro modo deben mantenerse mentalmente (Kirsh, 1995). Los recordatorios basados en lugar muestran que la ubicación representa contextos más ricos que una coordenada (Sohn et al., 2005; O'Rear y Radvansky, 2019). Aplicar esos hallazgos a unas zapatillas o materiales de dibujo es una inferencia de diseño y exige comparar ubicación congruente y neutra.

La distancia introduce un límite: la luz requiere línea de visión y la vibración no es háptica si el objeto no se porta o toca. El sonido ofrece alcance, pero puede molestar o revelar una regla. Las modalidades deben ser configurables y evaluarse por canal y superficie; los antecedentes domésticos justifican probar contexto, no validan un patrón específico (Komninos et al., 2019; McGee-Lennon, 2012).

La autonomía se materializa en reglas: la persona elige intención y condición; el sistema no bloquea; la señal termina sola; una pulsación breve la silencia; continuar no se clasifica como error; y no hay ranking, racha ni registro de cumplimiento. Slow Technology orienta únicamente a evitar urgencia y evaluación constante, no fundamenta la duración de la señal (Hallnäs y Redström, 2001).

**Tabla 1**

*Síntesis teórica convertida en requisitos*

> **Tabla 1:** conversión estructural desde la tabla de Word.

| Origen teórico | Traducción al MVP | Límite de la afirmación |
| --- | --- | --- |
| Memoria prospectiva | Una clave distinguible asociada con una acción futura. | No garantiza recuerdo. |
| Descarga de intenciones | App, testigo y lugar distribuyen la ayuda. | El testigo no contiene la intención. |
| Intención de implementación | Condición aproximada y primer paso concreto. | La señal no automatiza la conducta. |
| Uso del espacio | Testigo reubicable junto al primer paso. | La cercanía no provoca la acción. |
| Autonomía | Señal acotada, configurable y evitable. | No se asume aceptación de usuarios. |

*Nota.* Elaboración propia a partir de las fuentes citadas en el capítulo 3.

## 4. Consulta exploratoria y contexto de uso

### 4.1 Procedencia y límites

Entre el 11 y el 12 de junio de 2026 se realizaron en Santiago ocho entrevistas semiestructuradas presenciales y habladas. Las personas fueron reclutadas mediante contactos obtenidos por referencias cercanas; el único criterio común confirmado fue la edad. El rango observado fue de 19 a 27 años. El investigador formuló todas las preguntas y repreguntas y confirmó consentimiento informado oral. La asistencia automatizada se utilizó después para transcribir y formalizar académicamente el registro. Las dos preguntas adicionales sobre estrategias para dejar el teléfono y reacción ante In(Visible) también fueron realizadas presencialmente.

El muestreo fue exploratorio y de conveniencia. No estima prevalencia, no compara grupos y no valida la solución. Las repreguntas variables reducen comparabilidad. Su aporte es delimitar vocabulario, casos y contrapuntos.

### 4.2 Hallazgos sustentados

En la pregunta 8, seis participantes respondieron que sí les había costado describir una sesión, uno indicó que ocurría pocas veces y uno respondió que no. El corpus también distingue ocio digital focalizado —videollamada, sudoku, pódcast, manga o videojuegos— de sesiones rutinarias o insatisfactorias. Tres relatos recientes expresan conflicto con sueño, otra actividad o valoración posterior; no corresponde generalizarlo.

Las personas nombran actividades concretas como leer, dibujar, cocinar, caminar, hacer deporte, armar maquetas o estar con alguien. Traducirlas a primeros pasos es una inferencia proyectual. La mención de tener materiales «a la mano» orienta la ubicación, pero no demuestra eficacia de un objeto situado.

**Tabla 2**

*Hallazgos verificables y traducción prudente*

> **Tabla 2:** conversión estructural desde la tabla de Word.

| Hallazgo | Rastro del registro transcrito | Implicación prudente |
| --- | --- | --- |
| Seis sí, uno parcial y uno no. | Pregunta 8; participantes P1–P8. | Fenómeno presente, no universal. |
| Ocio digital narrable y valorado. | Participantes P1, P4, P6 y P7: manga, sudoku, videollamada y pódcast. | No interrumpir categorías ni igualar duración con daño. |
| Conflicto o insatisfacción en algunos casos. | Participantes P2, P3 y P5. | Usar reglas autoelegidas. |
| Actividades concretas fuera de la sesión. | Preguntas 2 y 10; varios participantes. | Explorar posibles primeros pasos y lugares. |
| Caso negativo. | Participante P7; preguntas 8–10. | Diseñar para quien reconoce la brecha. |

*Nota.* Elaboración propia a partir del registro transcrito anonimizado de junio de 2026.

### 4.3 Dos tipos situacionales y contexto doméstico

La evidencia no justifica dos segmentos demográficos rígidos. Se definen dos tipos situacionales que pueden aparecer en personas distintas o en momentos diferentes de una misma persona.

El **usuario principal** corresponde a una situación de continuidad digital con intención desplazada. La persona reconoce una necesidad o actividad alternativa, pero esa intención pierde capacidad para orientar la acción mientras la sesión continúa. P2 y P3 constituyen los casos más claros; P5 aporta un caso próximo, aunque su intención alternativa aparece menos definida.

El **usuario límite** corresponde a una situación de ocio digital elegido y coherente. La actividad puede ser extensa y seguir siendo relacional, restauradora, concentrada o satisfactoria. P6 y P7 aportan los casos más claros; P1, P4 y P8 muestran que la pertinencia depende del episodio y no de la aplicación o duración. En este tipo, el comportamiento adecuado del sistema puede ser permanecer silencioso o permitir que la persona lo ignore.

| Dimensión | Usuario principal | Usuario límite |
| --- | --- | --- |
| Relación con la sesión | Una intención reconocida pierde disponibilidad. | La sesión coincide con la intención actual o cumple una función aceptada. |
| Recuerdo | Puede ser claro o débil. | También puede ser claro o débil. |
| Duración | No define el patrón. | No define el patrón. |
| Papel de Relevo | Hacer recuperable una intención y su primer paso. | No intervenir o permitir una salida reversible. |
| Riesgo | No apoyar una transición que la persona ya desea. | Interrumpir o juzgar un ocio legítimo. |

El hogar es relevante porque varias estrategias descritas en Q12 dependen de la proximidad: dejar el teléfono lejos de la cama, cargarlo en otra habitación o situarlo cerca de los materiales de otra actividad. Sin embargo, no se observaron sistemáticamente los hogares. No corresponde asumir una habitación propia, una superficie disponible, privacidad constante ni una distribución uniforme. La ubicación elegida es una hipótesis de diseño que debe adaptarse y comprobarse.

La decisión vigente es que el objeto físico no incorpora pantalla. Q13 permite sostener la exploración de una señal simple, discreta y no evaluativa, pero no determina por sí sola la forma, el canal o la eficacia del objeto.

PARTE II / TRADUCIR

## 5. Formulación de la investigación y del proyecto

### 5.1 Problema y preguntas

Las herramientas existentes ayudan principalmente a medir, bloquear o retrasar aplicaciones. Para quien quiere conservar una alternativa sin renunciar al ocio digital, falta evidencia sobre una ayuda que externalice parcialmente esa intención y la vuelva perceptible en un lugar de acción.

**Pregunta de investigación:** ¿Bajo qué condiciones una señal externa configurada por la persona puede apoyar la recuperación de una intención de ocio durante una sesión digital doméstica, sin bloquear ni evaluar?

**Pregunta proyectual:** ¿Bajo qué condiciones de asociación, ubicación y modalidad un testigo físico sin texto puede actuar como clave de recuperación, sin reducir autonomía?

### 5.2 Hipótesis

Si una persona formula una intención y su primer paso, mantiene una sola intención activa y sitúa el testigo junto al elemento asociado, entonces la señal no semántica permitirá recuperar correctamente intención y primer paso sin consultar el teléfono con mayor frecuencia que la misma señal desde una ubicación neutra.

La hipótesis evalúa recuperación sin texto y aporte de la ubicación congruente. Autonomía, intrusión y reproche son resguardos exploratorios. Una comparación secundaria con notificación Android no anticipa superioridad del objeto. Afirmar que la intención «volvió» exige además saber que no estaba activa antes de la señal.

### 5.3 Objetivo general y objetivos específicos

El objetivo general es diseñar y evaluar un sistema phygital doméstico que apoye la recuperación de una intención autoelegida mediante una clave situada y perceptible, preservando la posibilidad de continuar sin evaluación.

1. **Investigar:** caracterizar la brecha y traducir memoria prospectiva, descarga de intenciones y cognición situada a requisitos verificables.

2. **Diseñar:** comparar tipologías y desarrollar un testigo sin pantalla coherente con situación, autonomía, percepción, privacidad, energía y costo.

3. **Validar:** contrastar ubicación congruente y neutra, y explorar después el valor frente a una notificación mediante puertas explícitas de cambio o abandono.

### 5.4 Criterios de diseño

**Tabla 3**

*Criterios de diseño del MVP*

> **Tabla 3:** conversión estructural desde la tabla de Word.

| Criterio | Definición para el MVP |
| --- | --- |
| Autoelegido | La persona define intención, primer paso, app, condición y modalidad. |
| Situado y asociable | Puede ubicarse junto al primer paso y recuperarse sin texto. |
| Perceptible y accesible | Luz, sonido y vibración configurables; no depende solo de color. |
| Evasible y no evaluativo | Silenciar, continuar o desarmar no producen deuda ni puntaje. |
| Privado | Procesamiento local; el testigo no recibe texto ni rastrea. |
| Comprobable | Cada decisión tiene prueba, indicador y criterio de abandono. |

*Nota.* Elaboración propia; los criterios son decisiones proyectuales por validar.

**Figura 2**

*Cadena de trazabilidad desde marco teórico y consulta exploratoria hasta decisiones y pruebas del objeto*

> **Figura conservada en la fuente DOCX:** image3.png. Véase el [manifiesto de medios](../99_archivo/fuentes-locales/semestre-2/memorias/manifesto-de-medios.md).

## 6. Estado del arte y mercado actual

El análisis se organiza por mecanismos de intervención y no por parecido formal. La literatura académica permite discutir mecanismos y límites; la documentación técnica describe capacidades; y la comunicación comercial caracteriza la oferta, pero no demuestra eficacia independiente.

Biedermann, Schneider y Drachsler (2021) revisaron 28 intervenciones de autocontrol digital y observaron resultados variables. Las propuestas basadas solo en aumentar conciencia mostraron efectos limitados, mientras que las sanciones o bloqueos tendían a operar únicamente cuando eran difíciles de eludir. La confianza general fue baja por muestras pequeñas, duraciones breves y contextos poco comparables. Monge Roffarello y De Russis (2023) describen un campo igualmente fragmentado y señalan la necesidad de evaluaciones longitudinales, medidas comparables y atención a implicancias éticas.

Esta evidencia no demuestra que bloquear sea siempre incorrecto ni que una señal no restrictiva sea superior. Indica que medir, demorar o bloquear no produce por sí solo un resultado uniforme y que el mecanismo debe responder al problema y al contexto.

**Tabla 4**

*Mercado comparado por mecanismo*

| Familia | Referentes | Operación declarada | Aprendizaje y límite |
| --- | --- | --- | --- |
| Fricción en el teléfono | one sec; Pause Point (one sec, s. f.; Sanders, 2026) | Introducen una pausa antes de acceder o continuar en aplicaciones. | Favorecen reconsideración sin objeto, pero mantienen la intervención en el mismo dispositivo. |
| Bloqueo físico-digital | Brick; Unpluq Tag; Screenless Breaker (Brick LLC, s. f.; Screenless, s. f.; Unpluq, s. f.) | Usan una pieza física o NFC para activar, mantener o revertir restricciones. | El gesto físico modifica el acceso; su lógica principal sigue siendo restricción o fricción. |
| Ritual o foco con objetos | Focusaur; Aro, como antecedente de disponibilidad incierta (Aro, s. f.; Focusaur, s. f.) | Vinculan objetos o lugares con sesiones de foco o separación del teléfono. | Hacen visible un compromiso, pero pueden exigir depósito, volumen o una definición productiva del tiempo. |
| Recordatorio tangible | Tangible Reminder (Hermann et al., 2007) | Asocia información o tareas digitales con piezas físicas. | Sustenta la posibilidad de una clave material en otro contexto técnico. |

*Nota.* Las funciones comerciales fueron verificadas en sitios oficiales el 24 de agosto de 2026. Las promesas de ahorro de tiempo o cambio de hábitos se tratan como comunicación comercial, no como evidencia independiente.

Brick y Unpluq muestran que existe un mercado de objetos ligados al control de aplicaciones. one sec y Pause Point muestran que la fricción puede integrarse directamente al sistema digital. Estas soluciones hacen visible una pregunta central: si una notificación o pausa en pantalla entrega el mismo valor con menor carga, el objeto físico pierde justificación.

La gamificación utiliza elementos propios del juego —como puntos, desafíos, niveles o recompensas— en actividades que no son juegos. No toda gamificación es punitiva ni se descarta universalmente. Relevo excluye puntos, rachas, rankings y comparaciones porque no busca premiar obediencia ni transformar la continuidad digital en una falta. Esta decisión responde a la autonomía expresada en las entrevistas y a la ausencia de registro de cumplimiento.

En la revisión preliminar hasta el 24 de agosto de 2026 no se identificó una solución que reúna simultáneamente intención autoformulada, condición digital elegida, señal física no semántica situada junto al primer paso y ausencia de bloqueo, ranking o registro de cumplimiento. Es un vacío provisional de la búsqueda, no una afirmación de inexistencia total.

La oportunidad de Relevo no es ser otro bloqueador físico. Consiste en investigar si un objeto sin pantalla puede externalizar una intención y devolverla a un lugar de acción sin impedir el ocio digital. Su valor solo se sostiene si la asociación situada aporta más que una notificación y conserva autonomía, privacidad y convivencia.

## 7. Del criterio a la forma

### 7.1 Tres familias

Se compararon tres arquitecturas: una **pinza situada**, muy próxima a la actividad pero difícil de adaptar sin dañar materiales; un **faro fijo**, perceptible aunque débilmente asociado con distintos primeros pasos; y un **testigo transportable**, capaz de acompañar lugares diversos. Las siluetas vectoriales igualan la fidelidad de las alternativas y no representan preferencias de usuarios.

**Figura 3**

*Tres familias objetuales exploradas: pinza situada, faro doméstico y testigo transportable*

> **Figura conservada en la fuente DOCX:** image4.png. Véase el [manifiesto de medios](../99_archivo/fuentes-locales/semestre-2/memorias/manifesto-de-medios.md).

*Nota.* Comparación vectorial cualitativa; no expresa preferencias de usuarios.

La comparación es una matriz cualitativa del autor. Bajo criterios de coherencia, asociación espacial, percepción, privacidad, autonomía, factibilidad y costo, el testigo transportable mostró el mejor ajuste relativo. El resultado organiza una decisión proyectual; no constituye evidencia de preferencia ni desempeño.

### 7.2 Por qué no usa pantalla ni cuna

Una pantalla explicita la intención, pero agrega costo, energía, espesor y exposición doméstica. Eliminarla obliga a probar la asociación entre intención, testigo y lugar: esa desventaja es a la vez el núcleo investigable. La cuna aportaba guardado y carga, pero duplicaba carcasa, contactos y volumen. La versión vigente conserva una sola pieza con carga USB-C directa; una base o bandeja no forma parte del MVP.

### 7.3 Dirección seleccionada

Se propone un disco coral y grafito, con aro luminoso, ojal, base antideslizante y botón cóncavo. Las metas de 44 mm de diámetro, 14 mm de grosor y 28 g o menos son hipótesis de empaquetado, no especificaciones validadas. AirTag informa la compacidad de la categoría, no la función ni la identidad de Relevo.

PARTE III / MATERIALIZAR

## 8. Relevo: propuesta de diseño

### 8.1 Definición y sentido

Relevo es un sistema phygital doméstico compuesto por una aplicación Android, un testigo sin pantalla y una ubicación elegida. La app conserva intención, primer paso y condición; el testigo emite una clave de recuperación; el lugar aporta contexto; y la persona recuerda y decide. El «relevo» es el traspaso de la llamada de atención desde la interfaz donde transcurre la sesión hacia el entorno donde otra actividad puede comenzar.

Una sola pieza se asocia con una intención activa. Esta restricción disminuye ambigüedad y hace visible que existe una regla armada, aunque no comunica por sí sola su contenido.

**Figura 4**

*Dirección formal seleccionada: testigo circular sin pantalla, con aro luminoso, botón y ojal*

> **Figura conservada en la fuente DOCX:** image5.png. Véase el [manifiesto de medios](../99_archivo/fuentes-locales/semestre-2/memorias/manifesto-de-medios.md).

*Nota.* Vistas conceptuales y metas de empaquetado por validar.

### 8.2 Sistema y secuencia

**Tabla 5**

*Arquitectura funcional de Relevo*

> **Tabla 5:** conversión estructural desde la tabla de Word.

| Parte | Hace | No hace |
| --- | --- | --- |
| App Android | Formula intención; elige app, condición, franja y modalidad; empareja y prueba. | No usa cuenta, nube, ranking ni contenido de otras apps. |
| Regla local | Estima una condición de uso aproximada. | No detecta automatismo, emoción ni culpa. |
| Bluetooth LE | Envía patrón y recibe batería o acuse técnico. | No localiza ni envía el texto de la intención. |
| Testigo | Se arma, señala, se silencia y se desarma. | No muestra menú, historial ni respuesta correcta. |
| Lugar | Aporta contexto y refuerza la asociación. | No garantiza recuerdo ni acción. |

*Nota.* Elaboración propia; describe el alcance previsto, no un sistema ya validado.

La persona define una intención y un primer paso, selecciona condición y modalidad, sitúa el testigo y prueba su alcance en el lugar real. La app prepara la regla; una pulsación prolongada de dos segundos alterna armado y desarmado. Al cumplirse la condición, Android envía un comando local y Relevo ejecuta una sola secuencia. Una pulsación breve la silencia; si nadie interviene, termina sola. La regla queda inactiva hasta un nuevo armado y el producto no pregunta qué hizo la persona.

**Figura 5**

*Secuencia principal: formular, situar, probar, armar, alcanzar la condición, señalar y decidir fuera del sistema*

> **Figura conservada en la fuente DOCX:** image6.png. Véase el [manifiesto de medios](../99_archivo/fuentes-locales/semestre-2/memorias/manifesto-de-medios.md).

### 8.3 Modalidad y control

El halo ofrece una opción silenciosa, el piezo amplía alcance y el LRA confirma presencia mecánica. Ningún canal se declara universal. La vibración solo es háptica al portar o tocar el objeto; sobre superficies se evaluará como resonancia. El patrón de partida usa un halo de diez a doce segundos, un bitono inferior a un segundo y dos pulsos LRA de 150–220 ms. Cada canal puede desactivarse y no hay repetición automática.

El único control físico combina dos gestos contextuales: pulsación prolongada para armar o desarmar y breve para silenciar durante la señal. Emparejamiento y prueba se inician desde la app. Ningún gesto significa «hecho». El patrón luminoso queda bajo tres destellos por segundo como referencia preventiva (World Wide Web Consortium, s. f.).

### 8.4 Forma, privacidad y valor

La carcasa preliminar combina frente coral, dorso grafito, aro translúcido, ojal y TPE localizado. El *stack-up* debe verificar batería, placa, cavidad acústica, LRA, USB-C y tolerancias antes de fijar 44 × 14 mm. El TPE protege superficies, pero puede amortiguar la vibración; se comparará con apoyos rígidos.

Android concede un permiso de estadísticas de uso amplio. Relevo limita por diseño la consulta y almacenamiento al paquete seleccionado durante la ventana armada. El testigo recibe solo un identificador de patrón, no texto; no hay GPS, UWB, NFC, micrófono, nube ni red de localización.

El valor propuesto es recordar sin volver a mirar el teléfono, vincular la alternativa con un lugar de comienzo y conservar la libertad de continuar. Si una notificación ofrece el mismo valor con menor carga o la asociación sin texto falla, el objeto debe cambiar o abandonarse.

## 9. Factibilidad tecnológica, productiva y económica

### 9.1 Arquitectura y energía

UsageStatsManager permite consultar eventos de paquetes con un permiso especial habilitado en Ajustes, pero no detecta estados subjetivos ni garantiza tiempo real (Google, s. f.-c). CompanionDeviceManager apoya el vínculo cercano (Google, s. f.-b) y la presencia BLE debe resolver restricciones de fondo según versión y fabricante (Google, s. f.-a). Una ejecución prolongada puede requerir servicio en primer plano y revisión de Google Play; por ello se probarán tres fabricantes antes de fijar arquitectura (Google Play, s. f.).

El prototipo usa ESP32-C3 para validar flujo, no autonomía. La versión compacta evalúa nRF52810/11, nPM1100, cuatro LED, piezo, LRA C08-00A con DRV2605L y Li-Po protegida de 200–300 mAh. CR2032 queda descartada por falta de margen para cargas de pulso; CR2450R se conserva solo como alternativa experimental (Energizer Holdings, Inc., 2020; Murata Manufacturing Co., Ltd., 2023; Nordic Semiconductor ASA, s. f.-a, s. f.-b; Precision Microdrives Ltd., 2023; Texas Instruments, 2018).

El presupuesto preliminar de pico es cercano a 60 mA y cabe nominalmente bajo un regulador de 150 mA, pero debe medirse en batería llena, media y baja. Treinta días es una puerta de prototipo y noventa días una meta posterior, no autonomías demostradas.

**Figura 6**

*Arquitectura Android–BLE–testigo y manejo de excepciones*

> **Figura conservada en la fuente DOCX:** image7.png. Véase el [manifiesto de medios](../99_archivo/fuentes-locales/semestre-2/memorias/manifesto-de-medios.md).

### 9.2 Producción, costo y cumplimiento

La ruta P0–P4 separa representación, señal, enlace, integración y piloto. Un prototipo funcional se estima en CLP 58.000–107.000; una BOM hipotética de 1.000 unidades se estima en USD 18–36 ex fábrica y CLP 24.000–48.000 puesta en Chile. Son rangos de planificación, no cotizaciones. La meta condicionada es BOM bajo USD 25; el precio directo CLP 79.990–99.990 debe validarse frente a disposición de pago y alternativas gratuitas.

La dirección industrial considera PC/ABS, guía de luz separada, TPE localizado, tornillos internos y batería reemplazable por servicio. Desde el 22 de febrero de 2026, los equipos de alcance reducido deben revisar el régimen SUBTEL de QR, ensayos y declaración de conformidad según categoría (Subsecretaría de Telecomunicaciones, 2026). La BOM, presupuesto profesional, reparabilidad y riesgos técnicos completos se documentan en el Anexo C.

PARTE IV / VALIDAR

## 10. Metodología de prototipado y validación

### 10.1 Resultados esperados y reglas de interpretación

El resultado principal es la recuperación semántica después de la señal: identificar correctamente intención y primer paso sin consultar la app. Reconsideración declarada, autonomía percibida, intrusión y preferencia se informan por separado. Afirmar que la intención «volvió» exige comprobar que no estaba activa inmediatamente antes; sin esa evidencia se hablará de recuperación o reconsideración. La conducta posterior es secundaria y no actuar sigue siendo válido.

### 10.2 Secuencia de pruebas

**Tabla 6**

*Plan resumido de validación*

> **Tabla 6:** conversión estructural desde la tabla de Word.

| Etapa | Contraste | Puerta de diseño |
| --- | --- | --- |
| Asociación | Mismo token en ubicación congruente y neutra, con intenciones distintas y contrabalanceadas. | Recuperación confiable y mejor que neutra; si falla, añadir marcador o replantear. |
| Forma | Maquetas de 40, 44 y 48 mm; ojal, apoyo y botón. | Armar, silenciar y desarmar sin ayuda; evitar lectura de alarma o rastreador. |
| Modalidad | Luz, luz + piezo y luz + LRA en habitaciones y superficies. | Cada persona encuentra un perfil perceptible y tolerable. |
| Aporte físico | Testigo situado frente a notificación textual, con intenciones equivalentes distintas. | Valor físico identificable sin mayor reproche; no se exige superar texto en recuerdo literal. |
| Integración y piloto | Tres fabricantes Android; luego 6–8 personas durante 7–10 días. | Entrega oportuna, baja molestia y utilidad; abandonar si la carga supera el aporte. |

*Nota.* Elaboración propia; las puertas son umbrales de diseño, no inferencia estadística.

No se repite una intención dentro de una sesión. Se fija un intervalo y una actividad digital en curso; asignación, orden y criterios de codificación se establecen antes de probar. Se reportan episodios correctos sobre episodios totales, casos y contraejemplos, no significancia estadística. Durante el piloto se pregunta si la intención estaba presente antes de la señal y si la sesión era vivida como continuidad poco deliberada.

**Figura 7**

*Secuencia de prototipos y puertas de decisión*

> **Figura conservada en la fuente DOCX:** image8.png. Véase el [manifiesto de medios](../99_archivo/fuentes-locales/semestre-2/memorias/manifesto-de-medios.md).

El Anexo D contiene instrumentos, indicadores, cronología y criterios completos. La investigación separa fallo conceptual, perceptivo y técnico: entrega del comando, percepción, recuperación, reconsideración y conducta son niveles distintos.

## 11. Arquitectura de experiencia

### 11.1 Límite del sistema

Relevo es un sistema phygital doméstico compuesto por una aplicación Android, un testigo físico sin pantalla y un lugar elegido. La aplicación conserva la intención; el objeto emite una señal no textual; el lugar aporta contexto; y la persona interpreta la relación y decide.

El sistema no registra si la actividad fue realizada ni califica la conducta. Actuar, silenciar o ignorar permanece fuera de la evaluación del producto.

### 11.2 Flujo de usuario

La persona configura una intención, su primer paso, una aplicación, la condición aproximada y la modalidad. Luego elige un lugar, sitúa el testigo, prueba su percepción y arma la regla. Cuando la condición se cumple dentro de la ventana activa, Android intenta enviar un patrón mediante Bluetooth LE. El testigo emite luz, sonido o vibración sin mostrar la intención.

| Momento | Acción de la persona | Respuesta del sistema | Resultado |
| --- | --- | --- | --- |
| Configuración | Define intención, primer paso, condición y modalidad. | La aplicación prepara una regla local. | Regla preparada. |
| Asociación | Elige un lugar y sitúa el testigo. | El objeto queda vinculado al contexto por decisión de la persona. | Asociación situada. |
| Prueba y armado | Verifica la señal y arma la regla. | La aplicación comprueba permisos, vínculo y batería. | Regla en espera. |
| Activación | Continúa con su actividad digital. | Android evalúa la condición y envía un patrón vigente. | Señal física. |
| Recuperación | Actúa, continúa o silencia. | La señal termina y el sistema vuelve a reposo. | Decisión fuera del sistema. |

### 11.3 Estados y controles

| Estado | Condición | Salida |
| --- | --- | --- |
| No configurado | Falta intención, permiso, vínculo o modalidad. | Completar o corregir. |
| Vinculado y listo | Regla completa y testigo disponible. | Armar explícitamente. |
| Armado y en espera | La ventana está activa. | Cumplir condición, desarmar o expirar. |
| Condición cumplida | Permiso, vínculo, batería y vigencia se verifican. | Enviar comando o registrar fallo técnico. |
| Señalando | El objeto ejecuta una única señal. | Finalización automática o silencio físico. |
| Silenciado o terminado | La señal concluyó. | Nuevo armado explícito. |
| Expirado o con error | Falta un requisito o la entrega perdió vigencia. | Corregir y armar nuevamente. |

La pulsación breve silencia únicamente una señal activa. La pulsación prolongada puede armar o desarmar solo en estados definidos. Ningún gesto significa que la actividad fue realizada. El objeto no incorpora pantalla, texto, menú, encoder, historial ni respuestas múltiples.

### 11.4 Flujo técnico provisional

La aplicación conserva localmente la intención y consulta una regla operacional. La factibilidad depende de permisos, versión de Android y ejecución en segundo plano. Bluetooth LE transmite un identificador de patrón, no el texto.

1. La persona configura y arma la regla.
2. La aplicación verifica permiso, vínculo, batería y ventana.
3. Android consulta localmente la condición.
4. La aplicación genera un comando con identificador y vencimiento.
5. El testigo confirma recepción y ejecuta una señal única.
6. Si se pierde el enlace, la reconexión solo se intenta mientras la ventana siga vigente.
7. Si la entrega expira, la señal se descarta y no se reproduce tarde.
8. El sistema vuelve a reposo sin solicitar un reporte conductual.

Permanecen pendientes la condición exacta, las versiones de Android, la estrategia BLE, la política de batería y la matriz de permisos y fallos.

### 11.5 Flujo de diseño

| Fase | Pregunta | Registro |
| --- | --- | --- |
| Investigación | ¿Qué problema se aborda? | Fuentes, entrevistas, casos negativos y límites. |
| Traducción | ¿Qué debe hacer y evitar Relevo? | Evidencia, interpretación, requisito y no requisito. |
| Arquitectura | ¿Qué corresponde a app, objeto y lugar? | Flujos de usuario, funcional y técnico. |
| Prototipado | ¿La asociación y señal son perceptibles? | Protocolo, errores y contraejemplos. |
| Integración | ¿El sistema funciona con carga proporcional? | Permisos, enlace, batería, latencia y fallos. |
| Decisión | ¿El aporte físico supera su carga? | Mantener, modificar o abandonar. |

## 12. Conclusiones

La investigación comenzó preguntando por el recuerdo de una sesión digital y termina formulando un problema de memoria prospectiva: una intención futura puede dejar de participar durante una continuidad automática. Ese desplazamiento corrige una confusión conceptual y da sentido propio al objeto. Relevo no reconstruye lo que la persona vio ni intenta medir cuánto debería descansar. Distribuye la externalización entre app, lugar y testigo, y devuelve una señal de recuperación como posibilidad.

La forma aparece gradualmente desde esa tesis. El campo mostró que el fenómeno no es universal, que el ocio digital focalizado puede ser significativo y que las alternativas nombradas son actividades concretas que el diseño traduce en posibles primeros pasos. La teoría explicó por qué una señal externa y situada puede ayudar, sin garantizarlo. Los referentes revelaron el predominio de medición, demora y bloqueo. La exploración comparó pinza, faro y testigo; una revisión posterior eliminó e-paper y cuna porque no eran necesarios para estudiar el mecanismo.

Relevo queda definido como un token circular, compacto y sin pantalla, configurado desde Android y situado junto al primer paso. Luz, timbre y vibración no constituyen el valor por sí mismos: son canales configurables para hacer perceptible la asociación. La ubicación aporta contexto y una clave asociativa; el contenido permanece en la app y en la memoria de la persona. Una pulsación prolongada arma o desarma y una breve silencia una señal activa; la persona decide fuera del sistema.

La propuesta gana coherencia y viabilidad al reducir componentes, pero también asume un riesgo más nítido: sin texto, el testigo puede convertirse en una alarma genérica. Por eso la primera validación no mide minutos ni cambio conductual. Comprueba si la persona recuerda la asociación y si una ubicación congruente agrega algo frente al mismo testigo en un lugar neutro; la notificación queda como comparación secundaria. Si no ocurre, el proyecto debe incorporar una marca física, cambiar la tipología o abandonarse.

La integridad metodológica también forma parte del resultado. El estudio de junio se presenta como ocho entrevistas semiestructuradas presenciales y habladas, registradas posteriormente mediante transcripción. Las reacciones al concepto y las estrategias para dejar el teléfono corresponden a preguntas formuladas presencialmente. Toda eficacia, preferencia y disposición de pago queda por validar. Esta precisión distingue evidencia, inferencia e hipótesis y entrega a la siguiente etapa preguntas que un prototipo puede responder.

CIERRE / FUENTES

## 13. Referencias

Apple Inc. (s. f.). *AirTag (2.ª generación): Especificaciones técnicas*. Soporte técnico de Apple. Recuperado el 15 de agosto de 2026, de https://support.apple.com/es-la/126203

Aro. (s. f.). *Aro: Screen time solution* [Referente histórico; disponibilidad comercial por verificar]. Recuperado el 15 de agosto de 2026, de https://goaro.com/

Banco Central de Chile. (2026). *Dólar observado*. Base de Datos Estadísticos. Recuperado el 15 de agosto de 2026, de https://si3.bcentral.cl/Bdemovil/BDE/Series/MOV_BD_TC1

Biedermann, D., Schneider, J., y Drachsler, H. (2021). Digital self-control interventions for distracting media multitasking: A systematic review. *Journal of Computer Assisted Learning, 37*(5), 1217–1231. https://doi.org/10.1111/jcal.12581

Brick LLC. (s. f.). *Brick: Take back control of your screen time*. Recuperado el 15 de agosto de 2026, de https://getbrick.com/

de Segovia Vicente, D., Van Gaeveren, K., Murphy, S. L., y Vanden Abeele, M. M. P. (2024). Does mindless scrolling hamper well-being? Combining ESM and log-data to examine the link between mindless scrolling, goal conflict, guilt, and daily well-being. *Journal of Computer-Mediated Communication, 29*(1), zmad056. https://doi.org/10.1093/jcmc/zmad056

Energizer Holdings, Inc. (2020). *Energizer CR2032: Product datasheet* [Hoja de datos]. https://www.data.energizer.com/pdfs/ultimatecr2032EU0920.pdf

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Gilbert, S. J., Boldt, A., Sachdeva, C., Scarampi, C., y Tsai, P.-C. (2023). Outsourcing memory to external tools: A review of “intention offloading”. *Psychonomic Bulletin & Review, 30*(1), 60–76. https://doi.org/10.3758/s13423-022-02139-4

Gollwitzer, P. M., y Sheeran, P. (2006). Implementation intentions and goal achievement: A meta-analysis of effects and processes. *Advances in Experimental Social Psychology, 38*, 69–119. https://doi.org/10.1016/S0065-2601(06)38002-1

Google Play. (s. f.). *Foreground service requirements for apps targeting Android 14 or higher*. Google Play Console Help. Recuperado el 15 de agosto de 2026, de https://support.google.com/googleplay/android-developer/answer/17105854

Google. (s. f.-a). *Communicate in the background*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (s. f.-b). *Companion device pairing*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing

Google. (s. f.-c). *UsageStatsManager*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/reference/android/app/usage/UsageStatsManager

Hallnäs, L., y Redström, J. (2001). Slow technology—Designing for reflection. *Personal and Ubiquitous Computing, 5*(3), 201–212. https://doi.org/10.1007/PL00000019

Hermann, M., Mahler, T., de Melo, G., y Weber, M. (2007). The tangible reminder. En *3rd IET International Conference on Intelligent Environments* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

Hiniker, A., Hong, S., Kohno, T., y Kientz, J. A. (2016). MyTime: Designing and evaluating an intervention for smartphone non-use. En *Proceedings of the 2016 CHI Conference on Human Factors in Computing Systems* (pp. 4746–4757). Association for Computing Machinery. https://doi.org/10.1145/2858036.2858403

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Komninos, A., Besharat, J., Stefanis, V., Gogoulou, G., y Garofalakis, J. (2019). Assessing the perceptibility of smartphone notifications in smart lighting spaces. *Journal of Ambient Intelligence and Smart Environments, 11*(3), 277–297. https://doi.org/10.3233/AIS-190525

Lukoff, K., Yu, C., Kientz, J. A., y Hiniker, A. (2018). What makes smartphone use meaningful or meaningless? *Proceedings of the ACM on Interactive, Mobile, Wearable and Ubiquitous Technologies, 2*(1), Article 22. https://doi.org/10.1145/3191754

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M., y Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (Paper 21, pp. 1–18). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

McDaniel, M. A., y Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*, S127–S144. https://doi.org/10.1002/acp.775

McGee-Lennon, M. R. (2012). Reminders that make sense: Designing multisensory notifications for the home. *Journal of Assistive Technologies, 6*(2), 93–104. https://doi.org/10.1108/17549451211234957

MechatronicStore. (s. f.). *Motores y actuadores*. Recuperado el 15 de agosto de 2026, de https://www.mechatronicstore.cl/motores-y-actuadores/

Meier, A., y Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Monge Roffarello, A., y De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Article 53, 1–66. https://doi.org/10.1145/3571810

Montag, C., Lachmann, B., Herrlich, M., y Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), 2612. https://doi.org/10.3390/ijerph16142612

Murata Manufacturing Co., Ltd. (2023). *CR2450R: Coin manganese dioxide lithium batteries* [Hoja de datos]. https://www.murata.com/-/media/webrenewal/products/batteries/micro/cr/high-drain/ds-cr2450r-004-je_202307.ashx?cvid=20231214062952000000&la=en

Nordic Semiconductor ASA. (s. f.-a). *nPM1100 product specification*. Recuperado el 15 de agosto de 2026, de https://docs.nordicsemi.com/r/bundle/ps_npm1100/page/keyfeatures_html5.html

Nordic Semiconductor ASA. (s. f.-b). *nRF52810 product specification*. Recuperado el 15 de agosto de 2026, de https://docs-be.nordicsemi.com/bundle/nRF52810-PS/raw/resource/enus/nRF52810_PS_v1.1.pdf

O'Rear, A. E., y Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

one sec. (s. f.). *FAQ*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/faq/

Precision Microdrives Ltd. (2023). *C08-00A: 8 mm linear resonant actuator* [Hoja de datos]. https://precisionmicrodrives.com/cdn/datasheets/C08-00A%20-%20datasheet%20-%20002/c08-00a-datasheet-002.pdf

Radtke, T., Apel, T., Schenkel, K., Keller, J., y von Lindern, E. (2022). Digital detox: An effective solution in the smartphone era? A systematic literature review. *Mobile Media & Communication, 10*(2), 190–215. https://doi.org/10.1177/20501579211028647

Reinecke, L., y Meier, A. (2020). Guilt and media use. En J. Van den Bulck, D. R. Ewoldsen, M.-L. Mares y E. Scharrer (Eds.), *The international encyclopedia of media psychology* (pp. 1–5). Wiley. https://doi.org/10.1002/9781119011071.iemp0183

Risko, E. F., y Gilbert, S. J. (2016). Cognitive offloading. *Trends in Cognitive Sciences, 20*(9), 676–688. https://doi.org/10.1016/j.tics.2016.07.002

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en

Sohn, T., Li, K. A., Lee, G., Smith, I., Scott, J., y Griswold, W. G. (2005). Place-Its: A study of location-based reminders on mobile phones. En M. Beigl, S. Intille, J. Rekimoto y H. Tokuda (Eds.), *UbiComp 2005: Ubiquitous computing* (Lecture Notes in Computer Science, Vol. 3660, pp. 232–250). Springer. https://doi.org/10.1007/11551201_14

Subsecretaría de Telecomunicaciones. (2024). *Informe final: Undécima encuesta sobre acceso, usos y usuarios de internet en Chile 2024*. Ministerio de Transportes y Telecomunicaciones, Gobierno de Chile. https://www.subtel.gob.cl/wp-content/uploads/2025/02/Informe-Final-Subtel-Acceso-y-Uso-Internet-2024.pdf

Subsecretaría de Telecomunicaciones. (2026, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Texas Instruments. (2018). *DRV2605L: 2- to 5.2-V haptic driver for LRA and ERM with effect library and Smart-Loop architecture* [Hoja de datos]. https://www.ti.com/lit/ds/symlink/drv2605l.pdf

Tulving, E. (2002). Episodic memory: From mind to brain. *Annual Review of Psychology, 53*, 1–25. https://doi.org/10.1146/annurev.psych.53.100901.135114

Unpluq. (s. f.). *Unpluq frequently asked questions*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/pages/faq

Vortac, O. U., Edwards, M. B., y Manning, C. A. (1995). Functions of external cues in prospective memory. *Memory, 3*(2), 201–219. https://doi.org/10.1080/09658219508258966

VShop. (s. f.). *Módulos Arduino ESP32*. Recuperado el 15 de agosto de 2026, de https://vshop.cl/161-modulos-arduino-esp32

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 15 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold
ANEXOS / DOCUMENTAR

## Anexo A. Trazabilidad del estudio de junio

### A.1 Registro primario

El estudio de junio se compone de ocho entrevistas semiestructuradas presenciales realizadas entre el 11 y el 12 de junio de 2026. El registro disponible corresponde a una transcripción posterior anonimizada. Las once preguntas principales y sus repreguntas fueron formuladas por el investigador durante las conversaciones; la asistencia automatizada se limitó a la transcripción y formalización académica posterior. Para esta memoria se conservaron los códigos P1–P8 y se retiraron los nombres.

**Tabla 7**

*Codificación estable de participantes y respuesta P8*

> **Tabla 7:** conversión estructural desde la tabla de Word.

| Código | Edad | Respuesta a P8 sobre dificultad de describir | Uso analítico |
| --- | --- | --- | --- |
| P1 | 21 | Sí | Caso afirmativo con ocio digital también valorado. |
| P2 | 22 | A veces, pero muy poco | Contrapunto parcial; sesión reciente recordada con claridad. |
| P3 | 19 | Sí, suele ocurrir | Caso de pérdida de noción del tiempo y conflicto declarado. |
| P4 | 22 | Sí, muchas veces | Contraste entre TikTok difícil de describir y Sudoku focalizado. |
| P5 | 20 | Sí | Sesión reciente que termina en aburrimiento. |
| P6 | 27 | Sí | Videollamada extensa, positiva y detallada como contrapunto. |
| P7 | 21 | No | Caso negativo; no reconoce la brecha como problema. |
| P8 | 19 | Sí | Caso afirmativo con actividades como lectura y dibujo. |

*Nota.* Elaboración propia a partir del registro transcrito anonimizado; nombres retirados.

La siguiente matriz permite auditar los demás hallazgos usados en el cuerpo. Los fragmentos se conservan breves, anonimizados y con la ortografía del export.

**Tabla 8**

*Matriz de trazabilidad de hallazgos*

> **Tabla 8:** conversión estructural desde la tabla de Word.

| Hallazgo analítico | Participante y número de pregunta | Fragmento transcrito | Alcance |
| --- | --- | --- | --- |
| Ocio digital focalizado y valorado | Participantes P4 y P6; preguntas 3–5 y 3–7, respectivamente | «Era sudoku» / «Concentrada y relajada»; «estuve en videollamada por varias horas» | Casos que impiden igualar duración con baja calidad. |
| Continuidad con sueño postergado | Participante P2; repreguntas asociadas a las preguntas 4 y 7 | «a pesar de saber que tengo mucho sueño, seguí pegada a la pantalla» | Un caso de conflicto; no prevalencia. |
| Pérdida de noción y otra alternativa | Participante P3; preguntas 4–5 | «No tenia noción de el tiempo» / «senti que tenia mejores cosas que hacer» | Un caso explícito de conflicto. |
| Actividad que requiere materiales disponibles | Participante P2; pregunta 10 | «Tendría que tener a la mano todos los materiales que necesito» | Orienta una inferencia sobre lugar y primer paso. |
| Caso negativo | Participante P7; preguntas 8–10 | «No me ha pasado en realidad» / «puedes usar tu tiempo como gustes» | Delimita a quién no se dirige el MVP. |

*Nota.* Fragmentos anonimizados del registro transcrito anonimizado; ortografía original conservada.

### A.2 Límites de procedencia

El registro disponible corresponde a una transcripción posterior de conversaciones presenciales y no incluye audio ni duraciones consolidadas. Las preguntas adicionales 12 y 13, sobre separación del teléfono y reacción ante el objeto, también fueron formuladas presencialmente por el investigador. Sus números identifican preguntas y no participantes; las respuestas se integran al corpus anonimizado P1–P8.

El investigador confirmó que las ocho entrevistas contaron con consentimiento informado oral. Esta confirmación no se presenta como formulario escrito ni se amplía con condiciones no documentadas. La siguiente etapa deberá definir consentimiento específico para observación, activaciones, registro técnico, fotografías y uso de citas anonimizadas.

### A.3 Instrumento original resumido

Las preguntas 1 y 2 abordaron rutina y actividades de descanso; las preguntas 3 y 4, una sesión reciente de entretenimiento en el teléfono; las preguntas 5 a 7, valoración y relato posterior; la pregunta 8, dificultad de describir lo visto; las preguntas 9 y 10, criterios de ocio válido o bien gastado; y la pregunta 11, un cierre abierto. Las repreguntas fueron formuladas presencialmente por el investigador según cada respuesta y se analizaron como parte del registro transcrito.

## Anexo B. Instrumentos para la siguiente etapa

### B.1 Guion de asociación y forma

1. Sin explicación, ¿qué crees que es este objeto y qué te permite hacer?

2. Configura una actividad que quieras mantener disponible y define su primer paso.

3. ¿Dónde pondrías el testigo? Explica por qué ese lugar tiene sentido.

4. Después de la señal, ¿qué intención representa y cuál era el primer paso?

5. ¿Qué parte del lugar o del objeto te ayudó a recordarlo?

6. Presiona para silenciar y luego desarma. ¿Qué crees que hizo cada gesto?

7. ¿Se sintió como invitación, alarma, reproche u otra cosa? ¿Por qué?

8. ¿Qué cambiarías para querer conservarlo en tu casa?

### B.2 Guion de modalidad y convivencia

1. ¿Qué señales percibiste desde cada habitación y superficie?

2. ¿Cuál combinación fue más clara sin ser molesta?

3. ¿En qué situación desactivarías sonido, luz o vibración?

4. ¿La señal revelaría algo que no quieras compartir con convivientes?

5. ¿La vibración se sintió táctil, sonora o no se percibió?

6. ¿Qué duración e intensidad te parecieron suficientes?

### B.3 Comparación con notificación

Cada participante realiza primero el contraste principal entre el mismo testigo en ubicación congruente y neutra, con intenciones equivalentes distintas y asignación contrabalanceada. En una etapa posterior se compara el testigo situado con una notificación Android con texto, también mediante intenciones distintas. Después de cada activación se registran por separado recuerdo, primer paso, reconsideración, intrusión, autonomía y preferencia razonada. La pregunta decisiva es: «¿Qué aportó este medio que no aportó el otro?». Si la respuesta no identifica un valor físico específico, el objeto debe replantearse.

## Anexo C. Factibilidad y especificación detalladas

### C.1 Arquitectura Android y Bluetooth

La aplicación integrada requiere acceso a estadísticas de uso. UsageStatsManager permite consultar eventos asociados con paquetes, pero la persona debe habilitar manualmente el permiso especial desde Ajustes y el sistema no ofrece un disparador subjetivo ni instantáneo garantizado (Google, s. f.-c). Las políticas de ejecución en segundo plano varían según versión y fabricante.

Relevo procesa únicamente el paquete seleccionado durante una ventana armada, aunque el permiso concedido por Android tiene un alcance técnico mayor. La aplicación consulta eventos y calcula un umbral aproximado. La palabra «aproximado» es parte de la interfaz: el proyecto no promete el «momento exacto». Si el usuario cambia de app, bloquea el equipo o vence la franja, el acumulado continuo se reinicia según una regla que debe verificarse en pruebas. Una ejecución prolongada podría requerir un servicio en primer plano y una notificación visible; desde Android 14, su tipo y justificación deben declararse y pueden quedar sujetos a revisión de Google Play, por lo que la arquitectura no se considera resuelta solo por mostrar una notificación (Google Play, s. f.).

El emparejamiento se plantea mediante CompanionDeviceManager, disponible desde Android 8.0. Esta API ayuda a asociar un dispositivo cercano sin solicitar localización fina para el escaneo inicial, aunque requiere servicios de ubicación activos y no crea por sí misma la conexión (Google, s. f.-b). Para mantener presencia durante la ventana armada se evaluará la API de presencia vigente para la versión objetivo o un servicio visible de dispositivo conectado, siguiendo las restricciones de Bluetooth LE en segundo plano (Google, s. f.-a). El prototipo fijará una versión mínima y una versión objetivo después de ensayar al menos tres fabricantes; no se promete una única estrategia válida entre Android 8 y 16.

La arquitectura envía solo un identificador de patrón y parámetros breves; el texto de la intención nunca viaja al testigo. Si el enlace falla, la aplicación registra un error técnico local y no reproduce el evento cuando la conexión vuelve, porque una señal tardía puede carecer de pertinencia. Durante la primera etapa, un control remoto del investigador simulará la activación para separar el valor de la experiencia del riesgo técnico.

### C.2 Electrónica del testigo

La arquitectura de prototipo funcional considera:

- microcontrolador con Bluetooth LE;

- tres o cuatro LED blanco cálido de alta eficiencia y una guía de luz de 360 grados;

- transductor piezoeléctrico de bajo consumo;

- actuador resonante lineal (LRA) de 8 mm con controlador en lazo cerrado;

- botón frontal de recorrido corto;

- Li-Po protegida de 200–300 mAh, medición de batería y carga USB-C directa;

- memoria mínima para vínculo y patrones, sin contenido de la intención.

Un ESP32-C3 compacto facilita la primera integración por disponibilidad y herramientas, pero su consumo no representa el producto final. La versión de bajo consumo evalúa un nRF52810/11 o equivalente (Nordic Semiconductor ASA, s. f.-b) y un gestor de energía como nPM1100. Nordic especifica para este último carga ajustable de 20 a 400 mA, regulador de 150 mA y consumo de reposo típico de 800 nA (Nordic Semiconductor ASA, s. f.-a). Estos datos pertenecen al componente, no al producto completo.

La CR2032 se descarta como arquitectura principal porque sus hojas de datos publican perfiles de pulsos del orden de miliamperios y no entregan margen defendible para radio, luz, piezo y LRA (Energizer Holdings, Inc., 2020). Una CR2450R de alto drenaje puede suministrar pulsos de hasta 50 mA durante tres segundos bajo condiciones acotadas —23 °C y 50 % de descarga—, pero el LRA C08-00A consume 28 mA típicos y hasta 41 mA, y la sustitución por una pila común degradaría la experiencia (Murata Manufacturing Co., Ltd., 2023; Precision Microdrives Ltd., 2023). Se selecciona por ello una Li-Po protegida de 200–300 mAh con carga USB-C directa y un controlador háptico en lazo cerrado como DRV2605L (Texas Instruments, 2018). Las señales se secuenciarán para reducir picos.

El presupuesto preliminar de corriente reserva aproximadamente 5 mA para radio BLE, hasta 41 mA para el LRA seleccionado, hasta 8 mA para cuatro LED y un margen de 6 mA para piezo, lógica y pérdidas. El máximo de planificación queda cercano a 60 mA si existiera solapamiento, por debajo de los 150 mA del regulador propuesto; aun así, tensión, temperatura, reinicios y consumo deben medirse con batería llena, media y baja. El dato no demuestra autonomía ni percepción háptica.

Las puertas preliminares de energía son: completar cien activaciones sin reinicio en batería llena, media y baja; medir tasa y latencia de reconexión, comandos perdidos, temperatura y corriente durante siete días; y alcanzar al menos 30 días en el prototipo optimizado. Noventa días constituye una meta de ingeniería posterior, no una autonomía demostrada.

### C.3 Prototipos por fidelidad

**Tabla 9**

*Niveles de prototipo*

> **Tabla 9:** conversión estructural desde la tabla de Word.

| Nivel | Construcción | Pregunta que responde |
| --- | --- | --- |
| P0 · Representación | Carcasa impresa, peso simulado y activación manual de luz/sonido/vibración. | ¿Se comprende, sitúa y recuerda la intención sin pantalla? |
| P1 · Señal autónoma | Microcontrolador, actuadores, botón y activación remota. | ¿Qué modalidad se percibe sin resultar intrusiva? |
| P2 · Enlace | Android de prueba + BLE + máquina de estados. | ¿El comando llega de forma estable y oportuna? |
| P3 · Integración | Acceso de uso, regla aproximada, token compacto y batería. | ¿El sistema completo funciona en distintos teléfonos y hogares? |
| P4 · Piloto | Carcasa de alta fidelidad y uso durante siete a diez días. | ¿El valor se mantiene o aparece habituación y abandono? |

*Nota.* Elaboración propia.

### C.4 Costos preliminares

Los costos siguientes son rangos de planificación al 15 de agosto de 2026, no cotizaciones. Incluyen margen por compra unitaria en Chile y deben actualizarse con proveedores antes de fabricar. Para convertir la BOM internacional se usa CLP 950 por dólar como supuesto redondeado, cercano al dólar observado de CLP 946,14 informado para el 27 de julio de 2026 (Banco Central de Chile, 2026).

**Tabla 10**

*Rangos de costo por fidelidad*

> **Tabla 10:** conversión estructural desde la tabla de Word.

| Fase | Alcance | Rango estimado |
| --- | --- | --- |
| P0 · Wizard of Oz | Carcasa, difusor, actuadores y control externo. | CLP 18.000–30.000 |
| P1/P2 · Funcional | ESP32-C3, DRV2605L, LRA, Li-Po, carga USB-C, LED, piezo, botón, impresión y ensamblaje. | CLP 50.000–100.000 |
| P3 · Compacto | PCB propia de baja escala, módulo BLE, gestor de energía, carcasa SLA/SLS y difusor. | CLP 70.000–110.000 |
| BOM hipotética a 1.000 unidades | Electrónica, batería, PCB, carcasa, ensamble y prueba; sin moldes, certificación, desarrollo, impuestos ni soporte. | USD 18–36, aproximadamente CLP 17.000–34.000 ex fábrica |

*Nota.* Rangos de planificación al 15 de agosto de 2026; no constituyen cotizaciones.

La trazabilidad del prototipo funcional se explicita a continuación. Los dos precios publicados se conservan como referencia puntual; los demás rangos son presupuestos de ingeniería por cotizar y no deben confundirse con ofertas comerciales.

**Tabla 11**

*BOM trazable del prototipo funcional*

> **Tabla 11:** conversión estructural desde la tabla de Word.

| Componente P1/P2 | Cantidad | Precio unitario de referencia | Subtotal | Fuente y estado |
| --- | --- | --- | --- | --- |
| ESP32-C3 SuperMini | 1 | CLP 3.990 | CLP 3.990 | VShop (s. f.), consulta 15-08-2026; solo prototipo. |
| Módulo DRV2605L | 1 | CLP 10.650 | CLP 10.650 | MechatronicStore (s. f.), consulta 15-08-2026. |
| LRA de 8 mm | 1 | CLP 8.000–15.000 | CLP 8.000–15.000 | Presupuesto de ingeniería; cotización pendiente. |
| Li-Po protegida + carga USB-C | 1 | CLP 7.000–15.000 | CLP 7.000–15.000 | Presupuesto de ingeniería; cotización pendiente. |
| Piezo, LED, botón y pasivos | 1 conjunto | CLP 1.500–6.000 | CLP 1.500–6.000 | Presupuesto de ingeniería; cotización pendiente. |
| Placa, cables y ensamblaje | 1 conjunto | CLP 5.000–12.000 | CLP 5.000–12.000 | Presupuesto de ingeniería; cotización pendiente. |
| Carcasa y difusor impresos | 1 conjunto | CLP 15.000–30.000 | CLP 15.000–30.000 | Presupuesto de ingeniería; cotización pendiente. |
| Contingencia de prototipo | 15 % | — | CLP 7.000–14.000 | Reserva por merma, conectores y reposición. |
| Total de planificación | — | — | CLP 58.000–107.000 | Actualizar antes de compra. |

*Nota.* Precios publicados y presupuestos de ingeniería al 15 de agosto de 2026; actualizar antes de compra.

La BOM de serie de USD 18–36 equivale aproximadamente a CLP 17.000–34.000 ex fábrica; un rango preliminar puesto en Chile de **CLP 24.000–48.000** es más honesto antes de cotizar logística, merma e impuestos. Mantener una BOM bajo USD 25 y un costo puesto bajo CLP 35.000 queda como meta condicionada de diseño, no como conclusión. Una hipótesis inicial de precio directo se sitúa entre **CLP 79.990 y 99.990**, sujeta a disposición de pago, cumplimiento regulatorio, volumen y servicio. Si el valor percibido no supera una app de bajo costo o una notificación gratuita, el proyecto no debe justificar un precio solo por su materialidad.

### C.5 Fabricación, reparación y fin de vida

La fase alfa utilizará carcasa PLA/PETG o resina, inserto TPE, guía de luz translúcida y tornillos. La beta migrará a SLS o SLA resistente con placa compacta. Una producción industrial consideraría dos conchas de PC/ABS, aro TPE, guía de luz separada y ensamble mediante tornillos internos en vez de adhesivo permanente. La Li-Po debe incluir protección y control térmico; caída, compresión y carga deberán ensayarse. Los ensayos eléctricos y el cumplimiento regulatorio de radio quedan fuera del prototipo académico, pero se reconocen como requisitos comerciales.

El diseño para desmontaje permite que servicio técnico reemplace la batería y separe placa, plástico y actuadores. No se afirma sostenibilidad por reducir piezas: se registrarán masa, materiales, vida útil esperada y posibilidad real de reparación. El color bermellón se concentrará en la carcasa frontal para facilitar cambio de variante sin duplicar toda la herramienta de producción.

Desde el 22 de febrero de 2026, SUBTEL establece para equipos de alcance reducido un régimen de etiquetado QR y documentación que incluye informe de ensayo y declaración de conformidad, con condiciones según la categoría del equipo (Subsecretaría de Telecomunicaciones, 2026). Una versión comercial deberá confirmar que el módulo BLE y el producto final cumplen la categoría aplicable; el prototipo académico no equivale a certificación.

### C.6 Rol profesional y factibilidad organizacional

La próxima iteración requiere diseño de interacción, diseño industrial, electrónica y desarrollo Android. Para transparentar el trabajo, se estima una dedicación de 140 horas de diseño para arquitectura, forma, CMF, prototipado, pruebas, análisis y documentación. A una tarifa de planificación de CLP 20.000 por hora, representa CLP 2.800.000. No es una tarifa institucional ni una cotización; visibiliza un costo profesional que no aparece en la BOM.

El diseñador coordina decisiones que atraviesan disciplinas: transforma la teoría en criterios, decide qué no registrar, define los límites de la señal, prepara protocolos, documenta fallas y convierte resultados en cambios formales. El desarrollo electrónico no sustituye ese trabajo; lo hace comprobable.

## Anexo D. Protocolo de prototipado y validación

### D.1 Enfoque

El semestre adopta investigación mediante diseño: construir artefactos para poner en tensión hipótesis y producir conocimiento sobre condiciones de uso. Cada prototipo debe responder una pregunta y habilitar una decisión. La secuencia evita integrar Android antes de saber si la presencia física aporta valor.

El resultado principal es **recuerdo espontáneo correcto**: después de la señal, la persona puede nombrar la intención y su primer paso sin consultar el teléfono. Se registran por separado la reconsideración declarada, la autonomía percibida y la preferencia cualitativa; no se combinan en un único indicador. El inicio observable del primer paso es secundario y no actuar sigue siendo una respuesta válida. Reducción de tiempo de pantalla, productividad y bienestar no son resultados primarios.

### D.2 Plan de pruebas

**Tabla 12**

*Plan detallado de pruebas*

> **Tabla 12:** conversión estructural desde la tabla de Word.

| Etapa | Participantes y método | Comparación | Puerta de decisión |
| --- | --- | --- | --- |
| 1 · Asociación sin pantalla | 5 adultos jóvenes; tres intenciones equivalentes distintas, asignación contrabalanceada y recuerdo diferido. | Mismo token en ubicación congruente y en ubicación neutra; contraste principal. | Al menos 4/5 recuerdan intención y primer paso en situación congruente y el resultado supera al neutro; si no, añadir marcador o replantear. |
| 2 · Forma y gesto | 5 participantes; tres maquetas, observación y pensar en voz alta. | 40, 44 y 48 mm; ojal, apoyo y botón. | 4/5 sitúan, toman, arman, silencian y desarman sin ayuda; corregir forma o estados si se confunde con alarma o rastreador. |
| 3 · Modalidad y alcance | 8 participantes en dos ambientes domésticos. | Luz; luz + timbre; luz + vibración; varias superficies. | Cada persona encuentra al menos un perfil perceptible y tolerable; ningún canal se declara universal. |
| 4 · Aporte físico | 8 participantes, diseño intra-sujeto con activación simulada e intenciones equivalentes distintas. | Testigo situado y notificación Android con texto; contraste secundario, orden contrabalanceado. | El testigo aporta una ventaja física identificable sin aumentar reproche; si empata en valor y suma carga, se descarta o reformula. |
| 5 · Integración | Matriz de al menos 3 modelos Android y 2 versiones de sistema. | Eventos simulados y reales. | 90 % de comandos llegan durante la ventana y no aparecen activaciones tardías; revisar arquitectura si falla. |
| 6 · Piloto doméstico | 6–8 participantes durante 7–10 días. | Línea base breve y Relevo; entrevistas de cierre. | Mantener utilidad, baja molestia y autonomía; identificar habituación, abandono y costo de rearmado. |

*Nota.* Elaboración propia; tamaños orientados a detección temprana de problemas.

Los tamaños son adecuados para detectar problemas tempranos y comparar tareas, no para estimar efectos poblacionales. Las decisiones combinan observación, relato, medidas técnicas y escalas breves. Todo umbral es una puerta de prototipo, no significancia estadística.

### D.3 Instrumentos e indicadores

La prueba de asociación pregunta, sin mostrar la app: «¿Qué representa el testigo?», «¿cuál era el primer paso?» y «¿qué te hizo recordarlo?». La prueba de modalidad registra distancia, habitación, superficie, canal percibido, tiempo de detección, intrusión y privacidad. Para evitar aprendizaje entre condiciones, cada participante trabaja con intenciones distintas pero equivalentes en concreción y familiaridad; su asignación y el orden se contrabalancean. Los criterios de codificación —recuerdo exacto, recuerdo parcial, error y consulta del teléfono— se fijan antes de observar resultados.

Indicadores centrales:

- recuerdo espontáneo correcto de intención y primer paso, sin ayuda ni consulta del teléfono;

- señal percibida y correctamente atribuida;

- reconsideración declarada, informada como resultado distinto del recuerdo;

- autonomía, reproche e intrusión percibidos, informados como escalas separadas;

- preferencia cualitativa razonada frente a notificación, sin tratarla como eficacia;

- tiempo y errores de configuración, armado y ubicación;

- molestias a convivientes y exposición percibida;

- latencia, pérdida de enlace, batería y activaciones tardías;

- razón de abandono o modificación después de una semana.

La investigación no necesita que el producto registre la elección cotidiana. Durante pruebas, el investigador puede observar o preguntar con consentimiento. Separar instrumento y servicio impide que la versión de uso convierta la decisión en puntuación.

### D.4 Criterios de éxito, cambio y abandono

**Tabla 13**

*Criterios para mantener, modificar o abandonar*

> **Tabla 13:** conversión estructural desde la tabla de Word.

| Dimensión | Mantener | Modificar | Abandonar o replantear |
| --- | --- | --- | --- |
| Asociación espacial | 4/5 recuerdan intención y primer paso con ubicación congruente y el resultado supera la ubicación neutra. | Añadir etiqueta o marcador táctil. | La asociación sigue siendo ambigua y exige consultar el teléfono. |
| Aporte físico | Frente a la notificación, las personas identifican una ventaja situada sin perder autonomía. | Cambiar ubicación, forma o momento. | La notificación ofrece el mismo valor con menor carga y costo. |
| Autonomía | La señal se entiende como opción y el botón como silencio. | Ajustar lenguaje, duración o frecuencia. | Dos o más participantes la describen consistentemente como vigilancia o castigo. |
| Convivencia | Existe al menos un perfil perceptible y aceptable por hogar. | Personalizar modalidad y alcance. | La señal necesaria afecta privacidad o convivencia de manera irresoluble. |
| Técnica | Enlace suficiente para la prueba y ninguna activación tardía. | Revisar servicio, reconexión y patrón. | Android exige permisos o vigilancia desproporcionados para el valor obtenido. |
| Adopción | Rearmado y ubicación caben en la rutina durante una semana. | Simplificar configuración o accesorio. | El token se pierde, no se rearma o se vuelve decoración sin función. |

*Nota.* Elaboración propia; umbrales fijados antes de probar.

### D.5 Cronología marzo–diciembre de 2026

**Tabla 14**

*Cronología del proyecto*

> **Tabla 14:** conversión estructural desde la tabla de Word.

| Periodo | Estado | Trabajo y evidencia |
| --- | --- | --- |
| Marzo | Realizado | Observación personal, exploración de ocio digital y formulación inicial desde tiempo de pantalla. |
| Abril | Realizado | Revisión bibliográfica y desarrollo de aristas psicológica, tecnológica y evaluativa. |
| Mayo | Realizado | Referentes, criterios preliminares, ideación e instrumento exploratorio. |
| Junio | Realizado | Ocho entrevistas semiestructuradas presenciales; transcripción posterior y análisis inicial; demostraciones técnicas tempranas. |
| Julio | Realizado | Cierre de Seminario, examen y feedback de comisión. |
| Agosto | En curso | Auditoría de evidencia, giro a memoria prospectiva, tres familias, selección y simplificación sin pantalla. |
| Septiembre | Planificado | P0/P1, asociación espacial, forma y modalidades con activación simulada. |
| Octubre | Planificado | Prototipo BLE, app Android mínima, carcasa compacta y pruebas técnicas. |
| Noviembre | Planificado | Comparación con notificación y piloto doméstico de siete a diez días. |
| Diciembre | Planificado | Análisis, iteración final, memoria, registro audiovisual y defensa. |

*Nota.* Elaboración propia.

## Anexo E. Declaración de uso de inteligencia artificial

En esta versión se utilizó inteligencia artificial generativa como apoyo para auditoría de consistencia, búsqueda dirigida de referencias, corrección editorial, exploración visual y diagramación. Las visualizaciones conceptuales se identifican expresamente como generadas con IA y no se presentan como fotografías de prototipos. La selección de fuentes, formulación del proyecto, decisiones de diseño y responsabilidad académica corresponden al autor, quien debe revisar cada cita, referencia y afirmación antes de entregar. Las entrevistas de junio no incluyeron preguntas, repreguntas ni respuestas automatizadas; la asistencia automatizada se aplicó únicamente a la transcripción y formalización académica posterior.

---

## Registro de cambios (disclaimer)

### 2026-08-24 — Auditoría APA del mercado

- **Cambio:** se añadieron citas parentéticas a la tabla de mercado, se incorporó la referencia oficial de Focusaur y se reordenó alfabéticamente la lista de referencias.
- **Versión anterior:** Focusaur aparecía sin entrada bibliográfica y las referencias comerciales nuevas estaban fuera de orden.
- **Motivo:** mejorar la correspondencia entre afirmaciones dinámicas y fuentes según APA 7.
- **Alcance:** las fuentes comerciales describen oferta y mecanismos; no validan eficacia.

### 2026-08-24 — Declaración como memoria vigente y corrección integral

- **Cambio:** se seleccionó la versión editorial v3 corregida como base vigente y se actualizó su estructura.
- **Versión anterior:** permanecía archivada como candidata y conservaba lenguaje de una entrega específica, un mercado reducido y una caracterización general del usuario.
- **Reemplazos:** el capítulo docente fue sustituido por arquitectura de experiencia; el perfil general por dos tipos situacionales; el mercado se reorganizó por mecanismos; la cuna quedó fuera del MVP; los resultados futuros se nombran como esperados; se confirmó que el objeto no tiene pantalla.
- **Motivo:** alinear la memoria con el feedback, los datos confirmados de entrevistas y la formulación actual.
- **Alcance:** es una base académica de trabajo, no una memoria cerrada. Las hipótesis técnicas, costos y validaciones seguirán abiertas.
- **Documento base preservado:** la versión histórica permanece intacta en `99_archivo`.


### 2026-08-23 — Conversión desde DOCX

- **Cambio realizado:** el documento se convirtió a Markdown respetando el orden de párrafos, listas, enlaces y tablas.
- **Estado anterior:** archivo local SEMESTRE 2/output/Johan Yanten - Memoria Relevo - Sistema editorial v3.docx sin copia textual navegable en GitHub.
- **Motivo:** conservar el desarrollo intelectual y permitir comparar versiones sin depender de Word.
- **Contenido conservado:** texto, jerarquías identificables y tablas; las figuras se representan mediante marcadores vinculados al manifiesto.
- **Contenido no trasladado en esta fase:** maquetación de página, tipografía, márgenes, numeración automática y archivos binarios de imagen.
- **Limpieza estructural:** se omitieron 0 encabezados numéricos aislados identificados como artefactos de paginación, sin contenido argumental.
- **Original:** el DOCX local no fue editado, movido ni eliminado.

### Correcciones metodológicas declaradas

| Cómo aparecía antes | Cómo queda en esta copia | Razón |
|---|---|---|
| Registro metodológico incorrecto sobre el origen de preguntas y repreguntas | Ocho entrevistas semiestructuradas presenciales; preguntas y repreguntas formuladas por el investigador | Aclaración directa del investigador |
| Participantes de 19 a 24 años y P6 con 24 años | Rango observado de 19 a 27 años y P6 con 27 años | Corrección factual confirmada |
| Lugar, consentimiento y modalidad hablada no acreditados | Santiago, entrevistas habladas y consentimiento informado oral | Aclaración directa del investigador |
| Dos preguntas posteriores excluidas | Preguntas realizadas presencialmente e incorporadas al registro | Aclaración directa del investigador |
| Respuestas automatizadas como parte del instrumento | Asistencia automatizada limitada a transcripción y formalización académica posterior | Corrección del origen del registro |

Se aplicaron 28 sustituciones controladas: cell_replacement=14, p6_age=1, paragraph_replacement=10, terminology_replacement=3.
- **Criterio de vigencia:** la conversión no declara esta versión como memoria vigente; la decisión queda pendiente en el documento comparativo.
