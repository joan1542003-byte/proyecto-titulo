# Ficha de estudio para el examen

Lo que el autor debe saber de memoria para el examen del 14 y el 15 de diciembre de 2026. Todo sale de la [memoria](../08_memoria/borrador-memoria-v8-2026-11-21.md) vigente al 25 de noviembre; lo que va entre comillas está tal cual. Para practicar, conviene decir cada bloque en voz alta en menos de 30 segundos y después responder las [preguntas preparadas del guion](49_guion-presentacion-examen-2026-12.md).

## 1. Los términos

| Término | Qué es |
| --- | --- |
| Ocio digital | Actividades que una persona realiza con dispositivos digitales en su tiempo disponible para descansar, entretenerse, satisfacer su curiosidad o vincularse con otros. |
| Intención personal | Lo que la persona se propone hacer por iniciativa propia, como leer o dibujar. |
| *Phygital* | Físico y digital a la vez. En Relevo, una aplicación para Android y un objeto. |
| Primer paso | La acción breve y concreta con que empieza una actividad, como abrir el libro o sacar la guitarra. |
| Memoria prospectiva | La capacidad de recordar una acción futura cuando aparece la ocasión (McDaniel y Einstein, 2000). |
| Recuerdo oportuno | Al sonar la señal, la persona sabe qué quería hacer y cómo empezar antes de leerlo en la pantalla. |
| Sentido de agencia | La experiencia de ser quien inicia las propias acciones y controla lo que sigue de ellas (Lukoff et al., 2021; Moore, 2016). |

## 2. El problema

> “Durante algunas sesiones de ocio digital, una actividad que la persona también quería realizar deja de estar presente y vuelve cuando la oportunidad ya pasó.”

Lo que se pierde no son horas, sino una decisión. Es una pérdida del sentido de agencia. Plantearlo como tiempo de uso lleva a medir y a bloquear. Plantearlo como un recuerdo que no llega a tiempo lo vuelve abordable desde el diseño.

**De dónde nace:** la experiencia del autor, las entrevistas y la encuesta, y un contexto que lo facilita. En Chile, el 99,1 % de los hogares conectados tiene un teléfono inteligente, y las aplicaciones están hechas para continuar.

## 3. La pregunta, la hipótesis y los supuestos

**Pregunta:**

> “¿Cuál es el efecto de un sistema *phygital* que vincula una actividad pendiente con su lugar de inicio sobre el recuerdo oportuno de esa actividad durante el ocio digital?”

**Hipótesis:**

> “Si se diseña un sistema *phygital* que vincula una actividad que la persona quiere hacer con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella.”

Con la fórmula de la pauta: **Si X** (el sistema que vincula la actividad con su lugar) **→ entonces Y** (la recordará a tiempo) **→ porque Z** (una señal asociada devuelve la intención: la memoria prospectiva).

**Los tres supuestos:**

1. **Asociación.** Al oír la señal, la persona sabe que es Relevo y recuerda su actividad y cómo empezar, sin mirar el teléfono.
2. **Decisión.** La señal devuelve la intención sin presionar. La persona elige con libertad si empezar, dejarlo para después o cambiar de idea.
3. **Soporte.** El objeto, que en la prueba fue el Tag, ayuda al menos tanto como una notificación en el teléfono, sin más molestia.

## 4. Los objetivos

**Objetivo general:** “Diseñar y evaluar Relevo: un sistema que ayude a recordar a tiempo algo que la persona quería hacer mientras descansa con el teléfono, con una señal junto al primer paso de esa actividad y la decisión en sus manos.”

**Objetivos específicos:**

1. Entender cuándo el uso del teléfono desplaza algo que la persona quería hacer, a partir de estudios, entrevistas, una encuesta y herramientas existentes.
2. Diseñar una aplicación y un objeto que lleven esa intención al lugar donde la actividad empieza.
3. Comparar el sonido del objeto junto al primer paso con una notificación en el teléfono.
4. Probar en hogares si las personas reconocen la señal y si les resulta cómoda. El recuerdo oportuno se mide con la proporción de respuestas a la señal en que supieron qué querían hacer antes de mirar la pantalla y recordaron cómo empezar. También se registra en qué proporción de esas respuestas empezaron la actividad.

**Cómo se cumplieron:** el 1 y el 2, sí. El 4, sí, con tres personas durante cinco semanas. El 3, en parte: con la notificación recordaron igual, pero esa comparación no permite decir cuál ayuda más.

## 5. Lo que se investigó

| Fuente | Qué | Lo que dejó |
| --- | --- | --- |
| Estudios | Memoria prospectiva, atención y diseño de la atención, experiencia del ocio digital. | Una intención vuelve por dos caminos: vigilarla o que una señal del entorno la traiga. |
| Herramientas | 367 aplicaciones y extensiones analizadas por otros autores: tres de cada cuatro bloquean o quitan distracciones. | Casi todas actúan sobre el uso del teléfono, no sobre lo que se deja de hacer. |
| Entrevistas | Ocho personas de 19 a 27 años, en junio de 2026, ordenadas con el método Framework. | Una misma sesión puede ser descanso o pérdida, según el motivo. |
| Encuesta | 53 personas, sobre la última vez que siguieron en una aplicación más de lo que querían. | 39 de 45 siguieron más de lo que querían al menos un día de la semana; 43 de 47 querían hacer otra cosa; 42 de 43 sabían su primer paso; 44 de 47 estaban en casa. |

## 6. Los ocho criterios, en tres ideas

- **Partir de la persona:** 1. La persona elige qué quiere hacer. 2. Cada actividad empieza con un paso concreto.
- **Dejarle las decisiones:** 3. La persona decide cuándo suena. 4. La persona decide qué hacer cuando suena. 5. El sistema interviene solo cuando hace falta.
- **Justificar el esfuerzo:** 6. Prepararlo toma poco esfuerzo. 7. Lo que la persona escribe es privado. 8. El objeto suma algo que el teléfono no da.

## 7. Relevo

Una aplicación para Android y un objeto que la persona deja junto al primer paso de una actividad. Cada actividad preparada es un relevo y pasa por cuatro momentos: **preparar** (qué quiere hacer, cómo empieza y cuánto tiempo se da en ciertas aplicaciones), **seguir en el teléfono**, **oír la señal** (el objeto suena unos 30 segundos desde el lugar) y **decidir** (empezar, dejarlo para después o cambiar de idea; las tres valen lo mismo).

Por detrás, la aplicación cuenta el tiempo con un permiso de Android y hace sonar el Tag por Bluetooth. Supabase guarda relevos y respuestas con un código en lugar del nombre, y el panel de la prueba muestra los resultados.

## 8. La prueba y sus cifras

Tres personas mayores de edad, en sus hogares, del 7 de octubre al 10 de noviembre de 2026: dos semanas con el Tag y después la etapa con una notificación en el teléfono, del 21 de octubre al 8 de noviembre. Cierre con cuestionario y entrevista.

| Dato | Cifra |
| --- | --- |
| Relevos en que el Tag sonó | 23 de 24 (el que no sonó se cumplió fuera de casa) |
| Supieron qué querían hacer antes de mirar la pantalla | 19 de 21 respuestas |
| Recordaron cómo empezar | 21 de 21 |
| Empezaron la actividad | 10 de 21 (9 lo dejaron para después y 2 cambiaron de idea) |
| Con el teléfono | Recordaron igual, pero en 10 de 21 respuestas notaron el aviso tarde o no lo notaron. La segunda y la tercera persona tardaron tres o cuatro veces más en responder que con el Tag |

## 9. Qué respondió el proyecto

- **La pregunta:** casi siempre recordaron a tiempo. Pero no se puede afirmar que se deba al Tag, porque con el celular recordaron igual, ni al lugar, porque el Tag nunca estuvo lejos de la actividad.
- **La hipótesis:** compatible con los resultados, pero no probada. Fueron tres personas y la etapa con el celular vino siempre después de la del Tag.
- **Los supuestos:** la asociación se cumplió casi siempre; la decisión se cumplió; el soporte, el Tag, se cumplió en parte, porque su sonido molestó más a quienes estaban cerca.
- **Dos hallazgos:** la señal depende del objeto, y recordar no obliga a empezar.

## 10. Lo que sigue

Una comparación con seis personas y tres semanas en distinto orden: el objeto junto al primer paso, el mismo objeto en otro lugar y una notificación genérica. Algunos relevos se cumplirían sin señal, para medir cuánto se debe solo a haberlo preparado. Para validar Relevo, el objeto propio, se probaría su forma, su sonido y su ubicación.

## Registro de cambios (disclaimer)

### 2026-11-25 — Creación

- **Qué cambió:** se creó la ficha con los términos, el problema, la pregunta, la hipótesis, los supuestos, los objetivos, los criterios, la prueba y lo que respondió el proyecto, tal como están en la memoria.
- **Cómo estaba antes:** esa información estaba repartida en la memoria, la presentación y el guion.
- **Por qué:** después del Pase, el autor anotó que debe aprenderse el problema, la hipótesis y los objetivos específicos, y practicarlos.
