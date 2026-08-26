# Relevo

*Sistema phygital de apoyo a la recuperación situada de intenciones durante el ocio digital de adultos jóvenes*

## Memoria de Proyecto de Título

- **Disciplina:** Diseño
- **Institución:** Universidad Diego Portales
- **Estudiante:** Johan Yantén
- **Año académico:** 2026
- **Versión:** cierre escrito del 26 de agosto de 2026
- **Etapa:** Proyecto de Título, segundo semestre
- **Tipo de proyecto:** Sistema phygital de interacción y producto
- **Estado del desarrollo:** investigación, formulación, arquitectura y esquemas estructurales documentados; prototipado funcional y evaluación de Relevo pendientes

## Resumen

Esta investigación aborda una situación del ocio digital: episodios en que una actividad continúa sin que la persona reconozca una renovación clara de su decisión, mientras otra intención valorada pierde capacidad para orientar el siguiente paso. Esta **continuidad digital poco deliberada** no se define por la duración, el teléfono o una aplicación, ni equivale a adicción. Una sesión extensa puede ser elegida, relacional o reparadora; por ello, debe reconocerse cuándo no intervenir.

El estudio combinó revisión bibliográfica, análisis de referentes y mercado, y ocho entrevistas semiestructuradas presenciales realizadas en Santiago los días 11 y 12 de junio de 2026. Participaron personas de 19 a 27 años, reclutadas mediante referencias; la edad fue el criterio común confirmado. Del análisis surgieron un usuario principal situacional, cuando existe una intención alternativa que pierde disponibilidad, y un usuario límite, cuando la actividad digital conserva significado o coincide con la intención del momento. Por su alcance, el corpus no permite estimar prevalencia ni evaluar el producto.

De esta investigación surge Relevo, un sistema phygital —integración de componentes físicos y digitales con funciones complementarias— compuesto por una aplicación Android y un testigo físico situado junto al primer paso de una actividad elegida. La aplicación conserva la intención y configura una condición de activación; al cumplirse, el testigo emite un pulso ambiental, una señal breve y no textual. Puede ignorarse o silenciarse, no bloquea el teléfono ni evalúa la respuesta.

La memoria construye el problema mediante tres aristas, estudia las respuestas existentes y deriva criterios, formulación, arquitectura, factibilidad y una evaluación progresiva. Los 35 estados desarrollados ordenan la interacción, pero no constituyen pruebas de uso. Como las cinco etapas P0–P4 aún no se han ejecutado, el aporte actual corresponde a la investigación y al desarrollo estructural; el valor específico del artefacto deberá compararse con una notificación equivalente.

**Palabras clave:** ocio digital, continuidad digital poco deliberada, memoria prospectiva, diseño phygital.

## Abstract

This research addresses a situation in digital leisure: episodes in which an activity continues without the person clearly recognising a renewed decision, while another valued intention loses its ability to guide the next step. This **low-deliberation digital continuity** is not defined by duration, phone presence, or a particular application, nor is it equivalent to addiction. An extended session may be chosen, social, or restorative; therefore, the project must recognise when not to intervene.

The study combined a literature review, an analysis of design references and the market, and eight in-person semi-structured interviews conducted in Santiago on June 11 and 12, 2026. Eight participants, aged 19 to 27, were recruited through referrals; age was the shared criterion. Analysis distinguished a situational primary user, when an alternative intention loses availability, and a situational boundary user, when digital activity remains meaningful or aligned with the person’s current intention. Given its scope, the corpus cannot estimate prevalence or evaluate the product.

The research informed Relevo, a phygital system—an integration of physical and digital components with complementary functions—comprising an Android application and a physical token placed next to the first step of a chosen activity. The application stores the intention and configures an activation condition; when it is met, the token emits an ambient pulse, a brief, non-textual signal. It may be ignored or silenced and does not block the phone or evaluate the response.

The report constructs the problem through three dimensions, examines existing responses, and derives design criteria, formulation, architecture, feasibility, and a progressive evaluation plan. The 35 documented states organise the interaction but do not constitute evidence of use. Since the five P0–P4 stages have not been conducted, the current contribution lies in research and structural development; the artifact’s specific value must be compared with an equivalent notification.

**Keywords:** digital leisure, low-deliberation digital continuity, prospective memory, phygital design.

## Índice

1. Motivación personal.
2. Introducción.
3. Planteamiento del problema.
4. Justificación y pertinencia disciplinar.
5. Antecedentes y estado de la cuestión.
6. Marco teórico por ámbitos.
7. Investigación de usuarios: método, contexto y hallazgos.
8. Estado del arte, mercado y referentes de diseño.
9. Síntesis de la investigación y criterios de diseño.
10. Formulación del proyecto.
11. Propuesta y desarrollo proyectual.
12. Arquitectura de experiencia y flujos.
13. Producción, factibilidad y modelo de gestión.
14. Plan de prototipado y evaluación.
15. Conclusiones, contribución, límites y próximos pasos.
16. Referencias y anexos.

# 1. Motivación personal

Mi interés nació de una situación cotidiana: abrir una aplicación por unos minutos, quedarme más de lo previsto y terminar sin recordar qué había visto, mientras actividades que sí quería realizar —dibujar, leer o salir a caminar— dejaban de estar presentes. No había decidido abandonarlas; simplemente ya no estaban participando de la decisión.

Durante un tiempo interpreté esa experiencia como falta de disciplina. Esa explicación era insuficiente porque no consideraba el diseño de las plataformas, la formación de hábitos ni la diferencia entre querer una actividad y recordarla en el momento oportuno. Tampoco distinguía una sesión digital elegida y satisfactoria de otra que se prolonga con poca deliberación.

El proyecto comenzó preguntando por el tiempo de pantalla y la memoria de lo vivido. La investigación y su revisión crítica obligaron a precisar el foco: el problema abordable desde Diseño no es demostrar que el teléfono daña la memoria, sino intervenir el momento en que una intención propia deja de participar en una decisión. Este desplazamiento evita diagnosticar a la persona y permite trabajar con variables concretas: qué activa la señal, dónde aparece, qué comunica, qué control conserva el usuario y cómo se comprueba el aporte del objeto físico.

No busco eliminar el teléfono ni establecer una forma correcta de descansar. Quiero diseñar una oportunidad comprensible para elegir de nuevo.

# 2. Introducción

## 2.1 Punto de partida

El ocio digital reúne actividades muy distintas: conversar, jugar, mirar videos, escuchar un pódcast, buscar información o recorrer una red social. Su presencia en la vida cotidiana no constituye por sí sola un problema. Tampoco existe una duración que permita decidir, sin atender al contexto, si una sesión fue valiosa o perjudicial. La investigación comienza en una situación más precisa: una actividad digital puede haber sido elegida al inicio y continuar después, mientras otra intención que la persona también valora deja de orientar lo que ocurre a continuación.

Algunas plataformas favorecen esa continuidad mediante el **desplazamiento infinito**, patrón de interfaz que carga contenido sucesivamente a medida que la persona avanza, sin un cierre de página claramente marcado. La reproducción automática y las recomendaciones encadenadas cumplen una función semejante: reducen los momentos en que hace falta decidir si se quiere continuar. Estas características no vuelven automática toda experiencia ni explican por sí solas la conducta de una persona, pero forman parte del entorno en que se toma la decisión (Montag et al., 2019; de Segovia Vicente et al., 2024).

Para distinguir la interfaz de la experiencia, esta memoria utiliza el concepto **continuidad digital poco deliberada**. Con él se describe un episodio en que la actividad actual sigue disponible sin que la persona reconozca una renovación clara de su decisión. El concepto no equivale a desplazamiento infinito: el primero nombra una situación vivida; el segundo, un patrón de interfaz que puede contribuir a ella. Tampoco constituye un diagnóstico clínico ni supone que toda sesión extensa sea involuntaria.

## 2.2 Del fenómeno a la pregunta de diseño

La escena que orienta el proyecto puede resumirse así: alguien llega a su casa, abre una aplicación para descansar y, antes de hacerlo, piensa en caminar, leer o dibujar. La sesión digital continúa; entretanto, la actividad alternativa deja de estar presente como siguiente posibilidad. Más tarde la persona todavía puede recordarla, pero ya no participó en la decisión oportuna. Este ejemplo es hipotético y no reproduce ninguna entrevista. Sirve para delimitar una relación entre actividad actual, intención alternativa y momento de elección.

La pregunta inicial no es cómo obligar a abandonar el teléfono, sino cómo mantener disponible una intención propia cuando la actividad digital ofrece continuidad. Ese cambio de enfoque resulta decisivo. Evita reducir el problema a minutos de pantalla, no interpreta el ocio como una falta y permite reconocer episodios en que una intervención sería improcedente, como una videollamada significativa, un videojuego concentrado o un descanso deliberado.

La investigación, por tanto, debe responder antes de diseñar: ¿qué caracteriza un episodio pertinente?, ¿qué papel tienen la interfaz, el conflicto con otras metas y el contexto?, ¿qué estrategias emplean las personas?, ¿qué ofrecen las respuestas existentes? Solo después de examinar esas preguntas corresponde formular qué puede aportar el diseño.

## 2.3 Orientación del proyecto y estado actual

Relevo es la respuesta proyectual que se desarrolla a partir de esa investigación. En una experiencia **phygital**, los componentes físicos y digitales cumplen funciones distintas pero articuladas: una aplicación conserva la intención y configura una regla; un **testigo físico**, entendido como el objeto que representa una intención activa, lleva una señal breve al lugar que la persona relaciona con el comienzo de la actividad elegida. Esa señal se denomina **pulso ambiental** porque hace perceptible la intención sin recurrir a texto ni indicar qué decisión tomar. La decisión posterior sigue perteneciendo a quien la recibe.

Esta descripción orienta la lectura, pero no adelanta una eficacia que todavía no existe. Se han completado la investigación documental, las entrevistas, el análisis de mercado, la formulación, los criterios de diseño, los flujos y los esquemas estructurales de interfaz. Continúan pendientes la selección final de la condición de activación, la forma y el canal de señal, la integración funcional, las pruebas con usuarios y la evaluación del aporte físico frente a una notificación digital equivalente.

El proyecto se encuentra, por ello, en una etapa intermedia entre investigación y prototipado. Sus resultados actuales permiten explicar qué se propone construir, por qué se tomaron ciertas decisiones y cómo se evaluarán. No permiten afirmar todavía que el sistema recupere intenciones, modifique conductas o resulte preferible a una alternativa exclusivamente digital.

## 2.4 Organización de la memoria

Los primeros capítulos construyen el fundamento del proyecto. El capítulo 3 expone el problema mediante tres aristas; el 4 justifica su relevancia y pertinencia disciplinar; el 5 revisa los antecedentes del campo; y el 6 articula el marco teórico en tres ámbitos. Después, el capítulo 7 presenta el método, el contexto y los hallazgos de las entrevistas, mientras el capítulo 8 analiza cómo la investigación y el mercado han respondido a problemas próximos.

Solo entonces se produce el paso hacia el proyecto. El capítulo 9 transforma la evidencia en criterios; el 10 formula el problema de diseño, la hipótesis, los objetivos, el alcance y el plan de trabajo. Los capítulos 11 a 13 desarrollan la propuesta, sus flujos y la factibilidad productiva. El capítulo 14 organiza las pruebas pendientes y el 15 distingue las contribuciones actuales de aquello que todavía requiere validación.

# 3. Planteamiento del problema

En 2025, el 96,6 % de los hogares chilenos declaró contar con acceso propio y pagado a internet. Entre los hogares conectados, el teléfono móvil o *smartphone* fue el dispositivo de acceso más extendido, con una presencia declarada de 99,1 % (Subsecretaría de Telecomunicaciones, 2026a). Estas cifras describen una infraestructura cotidiana casi universal; no indican cuánto ocio digital es deseado, qué experiencias resultan problemáticas ni cuántas personas necesitarían una intervención.

El problema estudiado aparece en una escala menor: el momento en que una actividad digital sigue ofreciendo continuidad y otra intención, también valorada por la persona, deja de orientar el siguiente paso. Para comprender esa situación sin reducirla a falta de disciplina o exceso de minutos, se examinan tres **aristas**, entendidas aquí como dimensiones complementarias del mismo problema: una experiencial y cognitiva, una tecnológica y una evaluativa.

## 3.1 Arista experiencial y cognitiva: una intención deja de orientar el siguiente paso

Una **intención alternativa** es una actividad que la persona reconoce como propia y que podría realizar en lugar de continuar con la actividad actual. Puede consistir en dormir, conversar, caminar, leer, dibujar, preparar una comida o simplemente cambiar de forma de descanso. Su valor no depende de ser productiva. El conflicto surge cuando esa intención existe, pero deja de participar en la decisión inmediata.

Recordar más tarde que se quería hacer algo no equivale a recordarlo en el momento oportuno. De Segovia Vicente et al. (2024) estudiaron 1.315 adultos mediante 67.762 evaluaciones breves realizadas en la vida cotidiana y registros de actividad del teléfono. Encontraron que los periodos más extensos de desplazamiento digital percibido como carente de propósito se asociaban con mayor conflicto entre la actividad digital y otras metas, y que ese conflicto explicaba parcialmente la culpa reportada. El diseño observacional del estudio no permite atribuir causalidad ni concluir que toda sesión digital produzca ese efecto. Sí aporta evidencia de que el problema no depende únicamente del tiempo transcurrido: importa la relación entre la actividad actual, la conciencia del episodio y aquello que la persona también quería hacer.

La dificultad abordada por Relevo no es un daño de memoria. Tampoco se afirma que una intención desaparezca. El punto es más acotado: en ciertos episodios, una posibilidad previamente formulada pierde disponibilidad para orientar el próximo paso. Esa pérdida puede coexistir con disfrute, descanso o ambivalencia, de modo que el diseño no puede deducirla desde fuera ni tratarla como una falla permanente del usuario.

## 3.2 Arista tecnológica: la continuidad también está diseñada

La sesión no ocurre en un entorno neutral. El desplazamiento infinito, la reproducción automática y las recomendaciones encadenadas mantienen disponible el siguiente contenido sin exigir una nueva elección ante cada elemento. Montag et al. (2019) describen cómo estas características se relacionan con modelos de negocio basados en permanencia y participación; de Segovia Vicente et al. (2024) señalan que tales recursos facilitan un consumo rápido, consecutivo y con menor conciencia del propósito.

Reconocer esta arista no significa que la interfaz determine por sí sola la conducta. Entre una característica de plataforma y una experiencia concreta intervienen propósito, contexto, hábito, estado de ánimo y valoración personal. Sin embargo, tampoco resulta suficiente explicar la continuidad como una decisión individual aislada. El diseño distribuye oportunidades: puede introducir un cierre, pedir una elección, mantener la secuencia o dificultar la salida.

Las respuestas de bienestar digital también son decisiones de diseño. Medir minutos, bloquear aplicaciones, retrasar una apertura o exigir una llave física cambia la relación entre la persona y la actividad. Cada mecanismo puede ser pertinente para un problema distinto, pero ninguno es neutral. Cuando el desafío consiste en recuperar una intención propia, una barrera de acceso puede impedir la actividad actual sin devolver la alternativa que perdió presencia.

## 3.3 Arista evaluativa: el ocio se juzga en relación con otras metas

El ocio no se valora únicamente por lo que ocurre durante la actividad. También intervienen las creencias con que una persona interpreta ese tiempo. Tonietto et al. (2021) realizaron cuatro estudios con 1.310 participantes y observaron que considerar el ocio como improductivo o desperdiciado disminuía su disfrute, sobre todo cuando la actividad se realizaba como un fin en sí mismo y no como medio para obtener otro resultado. La investigación no se refiere específicamente al teléfono, pero demuestra que el juicio sobre el valor del ocio puede modificar la experiencia.

En el ámbito digital, el conflicto con otras metas ayuda a explicar por qué dos sesiones semejantes pueden evaluarse de manera distinta (de Segovia Vicente et al., 2024; Meier & Reinecke, 2021). Una conversación extensa puede conservar valor relacional; el mismo tiempo en una secuencia sin propósito puede sentirse incongruente con una intención previa. La diferencia no está en una jerarquía universal entre actividades, sino en la relación que cada persona reconoce entre lo que hizo y lo que quería hacer.

Esta arista impone un límite ético. Si una intervención convierte el ocio en deuda, compara días, premia obediencia o supone que toda alternativa debe ser productiva, puede reforzar el juicio que intenta abordar. Relevo no busca demostrar que caminar sea mejor que mirar videos ni que una sesión breve sea superior a una extensa. Su campo de acción comienza solo cuando la persona formuló una alternativa y desea conservarla disponible.

## 3.4 Síntesis del problema

Las tres aristas describen una misma brecha desde escalas diferentes. En la experiencia, una intención propia deja de orientar el momento oportuno; en la interfaz, la actividad actual conserva continuidad; y en la evaluación, el ocio puede quedar atrapado entre disfrute, conflicto y juicio. Ninguna arista basta por separado. Culpar solo a la persona ignora la arquitectura de la interacción; responsabilizar únicamente a la plataforma borra la diversidad de propósitos; y medir el resultado mediante productividad impone una valoración externa.

El problema de diseño se formula así:

> En algunos episodios de ocio digital, una persona ha formulado una actividad alternativa que valora, pero la continuidad de la sesión mantiene disponible la acción actual y esa intención pierde capacidad para orientar el siguiente paso. El desafío consiste en volverla perceptible en el momento oportuno sin bloquear el ocio digital, decidir por la persona ni intervenir cuando la actividad actual es coherente con su intención.

Quedan fuera de esta formulación la adicción, el control parental, la vigilancia, la productividad general y la reducción universal del tiempo de pantalla. Tampoco se pretende detectar culpa, automatismo o conflicto de metas mediante el teléfono. El sistema solo puede operar sobre una condición observable y elegida; la pertinencia de la señal y la decisión posterior pertenecen a la persona.

# 4. Justificación y pertinencia disciplinar

## 4.1 Por qué es relevante abordar esta situación

La conectividad doméstica y la presencia del teléfono hacen que el ocio digital forme parte de la vida cotidiana en Chile, pero su extensión no permite distinguir experiencias elegidas de episodios que continúan por inercia. Tratar todos los usos como equivalentes conduce a respuestas poco precisas: un límite temporal puede interrumpir una conversación importante y, al mismo tiempo, no ayudar a comenzar una actividad que la persona quería realizar.

Abordar esta brecha importa porque se relaciona con la capacidad de sostener decisiones propias en entornos que mantienen disponible la acción presente. El proyecto no promete bienestar ni una corrección general de hábitos. Busca hacer investigable una pregunta más concreta: si una persona ya formuló una intención, ¿puede el entorno ayudar a que vuelva a considerarla sin imponer su ejecución? Esa pregunta protege tanto la posibilidad de cambiar de actividad como el derecho a continuar con un ocio elegido.

También existe una razón preventiva. Cuando la única respuesta disponible consiste en bloquear, contabilizar o comparar, el apoyo puede transformarse en una nueva fuente de carga. Formular una alternativa no debería crear una obligación frente al sistema. Por ello, ignorar una señal, silenciarla o cambiar de intención deben entenderse como decisiones válidas y no como incumplimientos.

## 4.2 Pertinencia desde Diseño

El fenómeno involucra variables propias del diseño de interacción: momento, canal, continuidad, cierre, jerarquía, fricción, legibilidad y control. Diseñar una respuesta exige decidir qué información se conserva, dónde aparece, cuánto esfuerzo requiere configurarla y cómo se recupera el control ante un error. La psicología puede explicar memoria o conflicto de metas, y la ingeniería puede ejecutar una condición técnica; corresponde al diseño articular esas dimensiones en una experiencia comprensible, situada y evaluable.

La intervención propuesta es phygital porque distribuye funciones entre una aplicación, un objeto y el entorno. Esa distribución no se justifica por novedad formal. Debe demostrar que la presencia física y el lugar aportan algo que una notificación dentro del teléfono no ofrece con la misma claridad y menor costo. Convertir esa comparación en parte del proyecto evita asumir que todo objeto mejora una experiencia por el solo hecho de existir.

El aporte disciplinar se encuentra, entonces, en investigar una mediación que no sustituya una arquitectura persuasiva por otra. Relevo no intenta hacer más difícil el acceso al teléfono; explora cómo una intención autoelegida puede recuperar presencia fuera del flujo que concentra la atención. La propuesta se sostiene solo si preserva autonomía, privacidad y convivencia, y si su carga material resulta proporcional al valor que produce.

## 4.3 Valor y alcance del proyecto

Relevo se especializa en una situación que las herramientas actuales abordan de manera indirecta: recuperar una intención propia en el lugar donde puede comenzar su primer paso. El valor potencial no consiste en reducir minutos, aumentar productividad o recompensar una conducta. Consiste en abrir una nueva ocasión de elección mediante una señal que la persona configuró y que puede ignorar.

Esta especialización delimita la magnitud del proyecto. Una aplicación y un objeto conectado implican permisos, energía, mantenimiento, costos, reparación, privacidad y soporte. Por eso, la factibilidad no puede separarse del fundamento: si una notificación equivalente produce el mismo aporte, la complejidad física deja de estar justificada. El proyecto adquiere valor académico precisamente porque declara esa posibilidad de refutación y organiza las pruebas necesarias para decidir si la dirección debe mantenerse, modificarse o abandonarse.

# 5. Antecedentes y estado de la cuestión

## 5.1 Del tiempo de pantalla al uso significativo

Los primeros enfoques de bienestar digital tendieron a representar el uso mediante duración, número de aperturas o categorías de aplicaciones. Estas medidas describen actividad, pero no explican por sí solas qué propósito tuvo una sesión. Lukoff et al. (2018) analizaron experiencias con teléfonos inteligentes considerando intención, valoración y autonomía percibida; su trabajo muestra que un mismo dispositivo puede sostener usos significativos o insatisfactorios según la relación entre actividad y propósito.

La literatura posterior reforzó esa lectura contextual. Meier y Reinecke (2021), al revisar la relación entre redes sociales, comunicación mediada y salud mental, encontraron efectos heterogéneos que dependen de la persona, la actividad y la situación. Radtke et al. (2022) llegaron a una conclusión semejante al estudiar 21 intervenciones de desconexión digital: los resultados positivos, nulos y negativos impiden tratar el retiro temporal de tecnología como una solución universal.

Estos antecedentes desplazan la unidad de análisis. En lugar de preguntar cuántos minutos son aceptables, conviene examinar qué estaba haciendo la persona, para qué lo hacía, cómo continuó la sesión y si existía otra intención relevante. Relevo adopta esa perspectiva y utiliza el episodio, no el tiempo agregado, como unidad principal.

## 5.2 Intervenciones de autocontrol digital

El campo ha desarrollado numerosas respuestas para reducir distracciones o modificar hábitos. Lyngs et al. (2019) revisaron 367 herramientas de autocontrol digital y observaron una concentración en bloqueos, remoción de estímulos y obstáculos. Esa distribución muestra que gran parte de la oferta interviene sobre la disponibilidad de la conducta no deseada, mientras una proporción menor apoya directamente la actividad que la persona quiere realizar.

Biedermann et al. (2021) analizaron 28 intervenciones y encontraron resultados variables, con una confianza limitada por muestras pequeñas, periodos breves y contextos poco comparables. Monge Roffarello y De Russis (2023) revisaron 43 estudios; solo cinco superaban los dos meses y el metaanálisis final —un análisis estadístico que combina resultados de varios estudios— pudo reunir siete. El efecto estimado sobre la reducción de uso no deseado fue pequeño a medio (*g* de Hedges = 0,47, una medida estandarizada de la magnitud del efecto), sin que ello permita atribuir el resultado a un mecanismo específico ni equiparar menor uso con mayor bienestar.

Otros trabajos han estudiado pausas antes de abrir una aplicación. Grüning et al. (2023) y Haliburton et al. (2024) aportan evidencia sobre cambios en aperturas, pausas y retornos cuando una fricción interrumpe el acceso. Sus resultados demuestran que una intervención breve puede modificar el curso de la interacción; no responden si una clave física situada ayuda a recuperar una intención alternativa.

## 5.3 Recordatorios externos y contexto

Una segunda línea de antecedentes estudia cómo las personas trasladan información al entorno para recordarla más tarde. Notas, alarmas, objetos y lugares reducen la necesidad de mantener una intención activa de manera constante, aunque introducen un costo de configuración y pueden fallar si la señal no se relaciona con la acción prevista (Risko & Gilbert, 2016; Gilbert et al., 2023; Chiu & Gilbert, 2024).

Los recordatorios basados en lugar muestran que el contexto puede colaborar en la recuperación, pero la proximidad no garantiza una acción (Sohn et al., 2005; O’Rear & Radvansky, 2019). Por su parte, *The Tangible Reminder* vinculó objetos cotidianos con información sobre citas y demostró tempranamente que una señal ambiental puede distribuirse entre dispositivo y entorno (Hermann et al., 2007). El caso se refería a tareas temporales y utilizaba información visible; no constituye una prueba para el ocio digital ni para Relevo.

## 5.4 Vacío de investigación que orienta el proyecto

Consideradas en conjunto, las investigaciones disponibles explican cuatro aspectos: la duración no basta para valorar una experiencia; ciertas interfaces favorecen la continuidad; las fricciones pueden modificar aperturas o acceso; y las claves externas pueden apoyar el recuerdo de una acción futura. Aun así, el corpus revisado no resuelve cómo reunir una intención autoformulada, su primer paso, una condición digital y una señal física situada sin bloquear ni registrar cumplimiento.

Ese vacío debe expresarse con cautela. La revisión fue exploratoria, priorizó publicaciones desde 2019 y conservó trabajos anteriores cuando eran necesarios para definir memoria prospectiva, contexto o interacción tangible. No se realizó una revisión sistemática, un estudio de patentes ni un inventario exhaustivo de todos los mercados. Por lo tanto, la ausencia de una solución equivalente en el corpus no demuestra novedad universal. Define una oportunidad suficientemente precisa para ser investigada y comparada.

# 6. Marco teórico por ámbitos

El marco teórico articula tres ámbitos que cumplen funciones distintas. El primero explica cómo una experiencia de ocio puede coexistir con otra intención y por qué recordar después no equivale a recuperar a tiempo. El segundo analiza las decisiones de interfaz que sostienen la continuidad y establece límites de autonomía para cualquier intervención. El tercero estudia cómo una intención puede distribuirse entre aplicación, objeto y espacio. La propuesta solo adquiere sentido en la intersección de los tres.

## 6.1 Ámbito 1: experiencia subjetiva del ocio digital

### 6.1.1 Continuidad y conflicto de metas

La continuidad digital poco deliberada describe una experiencia situada, no una propiedad permanente de la persona. Existe cuando la actividad actual continúa sin una renovación claramente reconocida de la elección y, al mismo tiempo, otra intención pierde capacidad para orientar el paso siguiente. Una sesión extensa no cumple automáticamente esta definición; tampoco una sesión breve queda excluida.

El **conflicto de metas** es la tensión percibida entre una actividad actual y otra meta o intención valorada. De Segovia Vicente et al. (2024) relacionan el desplazamiento digital percibido como carente de propósito con mayor conflicto y culpa en algunos episodios, pero no establecen que esas experiencias sean universales. Para Relevo, el concepto permite describir una relación entre acciones posibles sin decidir cuál es correcta.

La valoración subjetiva introduce un límite adicional. El ocio puede contribuir al descanso y, sin embargo, perder parte de su disfrute cuando se interpreta como tiempo desperdiciado (Tonietto et al., 2021). Por ello, una intervención que mida éxito mediante productividad o abstinencia correría el riesgo de reemplazar una dificultad por otra. El sistema debe permitir tanto recuperar una alternativa como reconocer que la actividad digital actual sigue siendo la elección pertinente.

### 6.1.2 Memoria prospectiva y recuperación oportuna

La **memoria prospectiva** es la capacidad de recordar realizar una acción futura cuando aparece una ocasión adecuada (McDaniel & Einstein, 2000). Se diferencia de la memoria retrospectiva, que permite reconstruir algo ya ocurrido. Una persona puede recordar al final del día que quería caminar y, aun así, no haber recuperado esa intención cuando todavía podía comenzar.

Una clave prospectiva funciona cuando ayuda a reconocer la ocasión y se relaciona con la intención. El proyecto distingue cuatro momentos: percibir una señal, atribuirla al sistema, recuperar la intención y decidir qué hacer. Percibir no implica comprender; comprender no asegura recordar; recordar no obliga a ejecutar. Esta separación será central para evaluar Relevo sin convertir la respuesta en obediencia.

### 6.1.3 Consecuencia para el proyecto

El primer ámbito desplaza el objetivo desde controlar una conducta hacia devolver una posibilidad a la decisión. La unidad de éxito no puede ser el abandono del teléfono, porque ese resultado no permite saber si la intención fue recuperada ni si la persona seguía valorándola. La pregunta pertinente es si la señal permite reconocer espontáneamente la intención y su comienzo, manteniendo abierta la elección posterior.

## 6.2 Ámbito 2: arquitecturas de atención, intervención y autonomía

### 6.2.1 Continuidad diseñada y condición observable

Una **arquitectura de atención** es el conjunto de decisiones que organiza qué elementos captan la atención, cómo continúa una interacción y cuándo se solicita una nueva elección. El desplazamiento infinito y la reproducción automática reducen cierres, mientras temporizadores, pausas y bloqueos introducen interrupciones de distinta intensidad (Montag et al., 2019; Lyngs et al., 2019).

Las **intenciones de implementación** vinculan una condición anticipada con una respuesta prevista: si ocurre una situación, entonces se inicia una acción (Gollwitzer & Sheeran, 2006). Relevo adopta únicamente esa estructura condicional. La aplicación puede traducir un evento observable en una señal, pero no puede detectar estados subjetivos como automatismo, culpa o pérdida de intención. La condición deberá expresarse en términos que Android pueda consultar y la persona pueda comprender, por ejemplo, continuidad de uso, tiempo acumulado dentro de una ventana o una franja horaria.

Cada alternativa cambia el significado de la intervención. El uso continuo mantiene una relación directa con la aplicación seleccionada, pero puede confundir permanencia con pertinencia. El uso acumulado admite pausas, aunque exige explicar qué se suma y cuándo se reinicia. Un horario simplifica la técnica, pero puede producir una señal sin relación con la actividad digital. Elegir la opción más fácil de programar antes de estudiar su sentido sería un sesgo de solución.

### 6.2.2 Autonomía y no coerción

La autonomía se define mediante acciones verificables. Quien utiliza Relevo debe poder configurar, modificar, desarmar, ignorar, silenciar y continuar sin recibir sanciones, puntajes, comparaciones ni registros de cumplimiento. La ausencia de bloqueo no basta: una señal persistente, inexplicable o difícil de detener también puede ejercer presión.

El sistema tampoco evalúa la conducta posterior. Si la persona recuerda que quería leer y decide seguir conversando, la intención fue recuperada aunque la actividad no se ejecute. Cambiar de idea constituye una decisión válida. De este modo, la intervención busca ampliar el campo de elección sin apropiarse del resultado.

### 6.2.3 No intervenir como respuesta correcta

Toda arquitectura de apoyo necesita una frontera. Ante una videollamada significativa, un videojuego concentrado, un pódcast elegido o un descanso deliberado, la señal puede resultar improcedente. Por eso Relevo requiere que exista previamente una intención alternativa formulada y una regla armada de manera explícita. La inactividad del sistema no representa una falla; en numerosos episodios es el comportamiento adecuado.

## 6.3 Ámbito 3: mediación phygital situada

### 6.3.1 Descarga de intenciones y costo de configuración

La **descarga de intenciones** consiste en externalizar parte del trabajo de recordar mediante una nota, una alarma, un objeto o algún recurso del entorno (Risko & Gilbert, 2016; Gilbert et al., 2023). Esta estrategia puede liberar a la persona de mantener una intención activa, pero no elimina el esfuerzo de formularla ni garantiza que la señal se interprete correctamente.

Configurar también tiene un costo. Elegir una actividad, precisar su comienzo, seleccionar una condición, vincular un dispositivo, escoger un lugar y rearmar el ciclo son tareas adicionales. Chiu y Gilbert (2024) muestran que el esfuerzo requerido para establecer recordatorios influye en la decisión de externalizar una intención. Su estudio no determina cuánto esfuerzo será aceptable en Relevo, pero obliga a tratar la carga como parte del mecanismo y no como un detalle posterior.

### 6.3.2 Espacio, contexto y primer paso

Kirsh (1995) explica que las personas organizan el espacio para volver perceptibles ciertas relaciones y reducir demandas cognitivas. Desde esta perspectiva, un lugar puede participar en una actividad sin convertirse en una coordenada detectada automáticamente. La literatura sobre recordatorios situados confirma que el contexto puede apoyar la recuperación, aunque estar cerca de un sitio no produce por sí mismo una acción (Sohn et al., 2005; O’Rear & Radvansky, 2019).

El **primer paso** es una acción concreta, próxima y reconocible que permite comenzar una actividad: ponerse las zapatillas, abrir un libro, sacar materiales o despejar una mesa. No equivale a la meta completa. Al situar una señal junto a ese paso se busca reducir la distancia entre recordar una intención e identificar cómo empezar.

El lugar se elige manualmente porque la asociación pertenece a la persona. Su valor depende de visibilidad, superficie, distancia, ruido, privacidad, circulación y convivencia. Si el mismo objeto produce idéntica comprensión en un lugar neutro, la ubicación no añade significado; si expone una intención o molesta a otras personas, la relación espacial debe modificarse.

### 6.3.3 Objeto, señal e interacción tangible

En una experiencia phygital, las capas física y digital se articulan para cumplir una función que ninguna resuelve por separado. La aplicación de Relevo conserva el significado y configura la condición; el **testigo físico situado** representa que existe una intención activa y se ubica junto a su primer paso; el **pulso ambiental** es una señal breve y no textual que hace perceptible esa intención sin indicar qué decisión tomar.

La **interacción tangible** ocurre cuando la presencia, ubicación o manipulación de un objeto participa en la acción y en su significado. *The Tangible Reminder* constituye un antecedente porque vinculó objetos cotidianos con información y señales ambientales, aunque su uso de pantalla, color semántico y citas temporales respondía a otro problema (Hermann et al., 2007). Waggoner et al. (2026) advierten que las experiencias phygital deben evaluarse en sus transiciones, accesibilidad e inclusión, no solo en la interfaz digital.

La materialidad, por tanto, es una hipótesis. Puede aportar presencia periférica, asociación espacial y una salida manipulable, pero también puede resultar ambigua, intrusiva, difícil de mantener o innecesaria. Solo una comparación con el mismo testigo en un lugar neutro y con una notificación equivalente permitirá saber si existe un valor físico específico.

## 6.4 Conclusiones de la intersección

Los tres ámbitos convergen en una misma relación. La experiencia subjetiva define cuándo existe una intención alternativa y evita juzgar todo ocio; la arquitectura de atención explica por qué la actividad actual puede conservar continuidad y fija límites de autonomía; la mediación situada propone distribuir la intención entre aplicación, objeto y lugar. De su cruce surge la pregunta central: ¿puede una señal física, configurada por la persona y situada junto al primer paso, devolver una intención a la decisión sin bloquear ni evaluar lo que ocurra después?

| Concepto | Función en el proyecto | Límite que debe conservarse |
| --- | --- | --- |
| Continuidad digital poco deliberada | Delimita el episodio de interés. | No equivale a adicción ni se deduce de la duración. |
| Conflicto de metas | Describe la coexistencia de la actividad actual y otra intención valorada. | No establece cuál actividad es correcta. |
| Memoria prospectiva | Explica la recuperación de una acción futura ante una ocasión pertinente. | Recordar no implica ejecutar. |
| Descarga de intenciones | Permite distribuir parte del recuerdo en el entorno. | Configurar agrega esfuerzo y no garantiza comprensión. |
| Primer paso | Concreta cómo puede comenzar la actividad elegida. | No representa la meta completa ni un resultado conductual. |
| Testigo físico situado | Lleva una señal al contexto relacionado con el primer paso. | Su valor frente a una notificación aún debe probarse. |
| Autonomía | Mantiene abiertas las opciones de modificar, ignorar, silenciar o continuar. | Una señal sin bloqueo todavía puede ser intrusiva. |

La investigación mediante diseño convierte estas relaciones en preguntas evaluables. Distintos prototipos producen conocimientos diferentes: una activación simulada puede estudiar asociación; una maqueta funcional, percepción y salida; una integración Android–BLE, estados técnicos y fallos (Real et al., 2021). Aumentar fidelidad antes de resolver la pregunta anterior añadiría complejidad sin aclarar el fundamento. Por eso el desarrollo avanza mediante puertas sucesivas y registra en cada una qué se aprendió, qué cambió y qué continúa abierto.

# 7. Investigación de usuarios: método, contexto y hallazgos

## 7.1 Diseño del estudio

Se realizó un estudio cualitativo exploratorio para conocer episodios, significados, tensiones, estrategias y contraejemplos asociados al ocio digital. El formato semiestructurado mantuvo una pauta común y permitió profundizar en situaciones particulares mediante repreguntas. No se observaron conductas directamente ni se presentó Relevo como prototipo.

Participaron ocho personas, identificadas como P1–P8. Las entrevistas fueron habladas y presenciales, y se realizaron en Santiago los días 11 y 12 de junio de 2026. El reclutamiento se efectuó mediante referencias de la red personal del investigador. Se buscó el rango de 18 a 30 años; la muestra obtenida quedó entre 19 y 27 años y P6 tenía 27. La edad fue el único criterio común confirmado. Por ello, Santiago y el rango etario describen el levantamiento, pero no definen una población a la que puedan generalizarse los resultados.

## 7.2 Instrumento y procedimiento

La pauta inicial, Q1–Q11, avanzó desde el tiempo libre y las actividades digitales hacia el relato de una sesión reciente, su propósito, continuidad, recuerdo, valoración y cierre. Todas las preguntas y repreguntas fueron formuladas por el investigador durante las conversaciones. Después se realizaron presencialmente dos preguntas adicionales: Q12 indagó estrategias para descansar o separarse del teléfono y Q13 recogió reacciones ante el concepto histórico In(Visible).

Se obtuvo consentimiento informado oral para la participación y el uso académico anonimizado del material. Las conversaciones se transcribieron y regularizaron después del levantamiento para facilitar su lectura, sin añadir preguntas ni respuestas. El corpus se organizó mediante códigos P1–P8 y Q1–Q13. Como la transcripción no se utiliza como registro literal palabra por palabra, el análisis privilegia paráfrasis y reserva las citas breves para fragmentos cuya trazabilidad puede establecerse con claridad.

## 7.3 Unidad de análisis y procedimiento analítico

La unidad principal fue el **episodio**, entendido como una situación narrada en relación con actividad, intención, continuidad, percepción temporal, valoración, conflicto, estrategia o cierre. Cada persona reúne varios episodios y no se convierte automáticamente en un perfil fijo. Así, un mismo participante puede relatar una situación pertinente para Relevo y otra en que cualquier señal sería innecesaria.

Como unidad secundaria se utilizó el segmento pregunta–respuesta, identificado mediante la combinación P/Q. El material se ordenó en una matriz por contexto, actividad digital, intención, continuidad, temporalidad, recuerdo, valoración, tensión, estrategia y reacción ante una señal. El análisis siguió el método Framework, procedimiento que organiza casos y categorías en matrices comparables (Goldsmith, 2021), y se complementó con tipos ideales revisables construidos a partir de semejanzas y contrastes entre casos (Stapley et al., 2022).

La interpretación fue realizada por el investigador y no contó con un segundo codificador independiente. Para mantener trazabilidad se conservaron el libro de códigos, las reconstrucciones de casos, la matriz comparativa y los vínculos P/Q. Los episodios ambiguos se presentan como indicios y no como confirmaciones. Q8, por ejemplo, reúne seis respuestas afirmativas, una parcial y una negativa sobre la dificultad de describir posteriormente una sesión; esa distribución caracteriza el corpus y no estima prevalencia ni demuestra pérdida de control.

## 7.4 Consideraciones éticas y reflexividad

El investigador cumplió a la vez los roles de entrevistador, diseñador e intérprete. Esa posición pudo orientar la atención hacia continuidad, intención y autonomía. También pudo influir en Q13, porque la pregunta presentaba In(Visible). Sus respuestas se utilizan únicamente para orientar, de manera condicional, el tono, la discreción y la posibilidad de silenciar; no se consideran evidencia de aceptación de Relevo.

La muestra por referencias introduce un sesgo de selección y no representa a todos los adultos jóvenes. Tampoco se observaron viviendas, superficies, convivientes, distancias, ruido, privacidad o movilidad del objeto. En consecuencia, el estudio no permite afirmar frecuencia poblacional, causalidad, eficacia, accesibilidad, adopción, disposición de pago ni superioridad frente a una notificación.

Las pruebas posteriores requerirán un consentimiento específico que explique activaciones, observación, fotografías, registros técnicos, anonimización, retiro voluntario y eliminación de datos. Los fallos del sistema no podrán atribuirse de manera automática a la persona, y terminar una sesión o cambiar de intención no tendrá consecuencias.

## 7.5 Alcance de la caracterización

Los resultados permiten construir dos posiciones situacionales, no dos biografías cerradas ni segmentos de mercado. La diferencia central está entre episodios en que una intención alternativa pierde disponibilidad y episodios en que la actividad digital conserva significado, propósito o coherencia con la decisión actual. Una persona puede ocupar ambas posiciones según la actividad y el contexto.

Esta lectura protege el proyecto frente a dos simplificaciones. La edad, la ocupación o la aplicación no se utilizan como causas del problema; tampoco se supone que una persona necesite siempre la misma intervención. El usuario principal y el usuario límite que se presentan a continuación funcionan como herramientas para orientar requisitos, recorridos y pruebas.

## 7.6 Matriz de participantes anonimizados

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

## 7.7 Episodios centrales y contraejemplos

P2 abrió Instagram al acostarse para ver memes, reconoció el sueño y continuó mirando el teléfono. La sesión fue recordada con claridad, pero el cierre fue evaluado como incompleto. El caso no muestra que la persona haya olvidado lo ocurrido; muestra una tensión entre una intención alternativa —dormir— y la continuidad de la actividad actual. También aporta una consideración material: mantener disponibles los elementos necesarios para otra actividad puede facilitar su inicio, pero esa inferencia todavía debe probarse.

P3 describió videos humorísticos en Instagram como una forma de pasar el tiempo. Relató pérdida de noción temporal y reconoció alternativas que consideraba mejores, aunque también describió la sesión como una pausa frente a responsabilidades. El caso concentra la ambivalencia que el diseño debe conservar: una actividad puede resultar agradable y, al mismo tiempo, competir con otra intención. Relevo no debe interpretar esa ambivalencia como autorización para corregir.

P5 es adyacente. Relató entretenimiento inmediato y aburrimiento posterior, y mencionó estrategias que no siempre evitan volver al teléfono. El episodio orienta sobre estrategias frágiles y sobre la diferencia entre una valoración posterior negativa y una intención alternativa previamente formulada. No tiene la misma claridad que P2 y P3 respecto de qué primer paso debía mantenerse disponible.

P6 relató una videollamada extensa, con contenido, vínculo y valoración positiva. P7 describió un pódcast elegido mientras comía, recordó el episodio y no reconoció una obligación que exigiera corregirlo. P4 aportó el contraste del sudoku focalizado frente a actividades digitales más rutinarias. P8 mostró que la dificultad de describir una rutina digital puede coexistir con la aceptación de esa sesión como descanso. Estos casos impiden intervenir por duración, aplicación o presencia del teléfono.

P1 y P4 muestran que la misma persona puede diferenciar actividades dirigidas de actividades que continúan con menor deliberación. Esta variación interna impide tratar a un individuo como usuario principal permanente. P6, P7 y parte de P8 hacen visible que la no intervención no es una excepción del sistema, sino una condición de diseño.

## 7.8 Hallazgos de las preguntas adicionales Q12 y Q13

Q12 reunió estrategias autodeclaradas para descansar o separarse del teléfono: alejarlo, cargarlo en otro lugar, silenciarlo o activar modos de no molestar. Estas respuestas no fueron observadas ni comparadas. Informan sobre el repertorio que algunas personas ya consideran, pero no prueban que una separación física sea eficaz ni que un objeto sea preferible.

Q13 fue realizada presencialmente y se refirió a la reacción ante el concepto histórico In(Visible). Sus respuestas permiten orientar condicionalmente un tono tranquilo, discreto y no punitivo, además de la posibilidad de ignorar o silenciar. No son una evaluación de Relevo. No permiten inferir aceptación del sistema, preferencia por un objeto, valor de una ubicación, eficacia de una señal ni disposición de pago. La prueba futura debe presentar el sistema actual y registrar sus respuestas sin apoyarse en Q13 como resultado.

## 7.9 Usuario principal situacional

El usuario principal se define por la coincidencia de tres condiciones:

1. La actividad digital continúa sin una elección renovada claramente reconocida.
2. Existe una intención alternativa propia que la persona desea mantener disponible.
3. La intención alternativa pierde capacidad para orientar el siguiente paso.

P2 y P3 sostienen mejor este patrón. P5 lo bordea y permite examinar qué ocurre cuando existe ambivalencia, pero no un primer paso igualmente preciso. La necesidad inferida es disponer de una alternativa sin que el sistema imponga su ejecución, y recuperar un primer paso sin tener que volver necesariamente al mismo flujo del teléfono. Esta necesidad no fue expresada como solicitud literal de Relevo.

Los puntos de fricción son continuar después de reconocer una alternativa, recuperar poco de la sesión y volver al teléfono después de haberlo alejado. Los deseos relatados —dormir, caminar, hacer un pasatiempo, aprender o ejercitarse— no deben traducirse automáticamente en productividad. Para el diseño, cada deseo necesita una primera acción elegida por la persona y una ubicación que pueda explicar.

## 7.10 Usuario límite situacional

El usuario límite corresponde a un episodio en que la actividad digital es elegida, significativa, dirigida, relacional, concentrada o reparadora, o en que no existe una intención alternativa que requiera apoyo. P6 y P7 son contrastes claros; P4, P6 y P8 muestran variación según actividad.

La necesidad de este usuario no es recibir una intervención. Es conservar autonomía, discreción y control sobre la pertinencia de una ayuda. Si Relevo se activa por aplicación, duración o presencia del teléfono, puede interrumpir una videollamada, un pódcast elegido o un descanso que la persona considera coherente. En este patrón, permanecer inactivo, permitir el silencio o hacer posible una salida inmediata son comportamientos correctos.

## 7.11 Necesidades, tensiones y requisitos

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

## 7.12 Mapa de viaje del usuario principal

Un **mapa de viaje** organiza una experiencia como una secuencia de momentos, acciones y tensiones para localizar oportunidades de diseño. El mapa agregado de P2 y P3 puede sintetizarse así:

1. **Inicio elegido o tolerado.** La sesión comienza como entretenimiento o descanso.
2. **Continuidad.** El contenido sucesivo mantiene la atención y hace disponible el siguiente elemento.
3. **Aparición de alternativa.** Surge el sueño, una actividad pendiente o la percepción de que había mejores opciones.
4. **Decisión inmediata.** La sesión continúa o se cierra con ambivalencia; la alternativa no logra orientar el paso.
5. **Reconstrucción posterior.** La persona recuerda con claridad, recuerda parcialmente o describe dificultad temporal.
6. **Separación intentada.** Se aleja o silencia el teléfono, con retorno variable.

Este recorrido no es una rutina universal. Se construye a partir de episodios y sirve para ubicar el posible momento de una señal. La activación no debe presentarse como detectada ya por Android.

## 7.13 Mapa de viaje del usuario límite

El recorrido límite comienza con una actividad digital elegida y continúa con atención, relación, concentración o descanso. La persona recuerda lo ocurrido, reconoce su valor y no identifica una alternativa que requiera apoyo. La secuencia termina sin necesidad de corrección. P6 y P7 muestran que la duración puede ser extensa sin que exista la oportunidad de Relevo; P8 muestra que la valoración puede depender del estado de obligaciones y descanso.

El sistema debe diseñarse para no convertir una condición técnica en un juicio sobre este recorrido. Mientras no exista una intención alternativa formulada, no debe armarse una regla. Si la intención cambia después del armado, la persona debe poder desarmar sin que el sistema registre una inconsistencia.

## 7.14 Contexto doméstico como hipótesis

El hogar se propone como primer ámbito porque permite relacionar el objeto con materiales, superficies y primeros pasos, y porque varias estrategias de Q12 dependen de la distancia y el lugar de carga. Sin embargo, no se observaron sistemáticamente viviendas, convivientes, ruido, superficies, privacidad, movilidad ni disponibilidad de espacio.

El hogar no puede tratarse como un escenario homogéneo. Un sonido puede molestar o revelar una regla privada; una luz puede pasar inadvertida; una vibración puede no transmitirse a una mesa; un objeto visible puede ser desplazado por otra persona; una superficie puede ser necesaria para el primer paso. Estas variables deben entrar en el protocolo y no resolverse mediante una promesa de universalidad.

## 7.15 Implicaciones de usuario para el sistema

Para responder a ambos recorridos, el sistema exige una intención autoelegida y un primer paso concreto, mientras mantiene editable la relación con el lugar. La señal no contiene texto, aunque los estados técnicos sí deben explicarse en la aplicación. Ignorar, silenciar, desarmar o continuar son salidas legítimas; bloquear, puntuar, comparar y registrar cumplimiento quedan fuera del proyecto. En consecuencia, la no pertinencia también constituye un resultado válido.

# 8. Estado del arte, mercado y referentes de diseño

## 8.1 Alcance y criterios de búsqueda

La búsqueda de mercado y referentes se cerró el 24 de agosto de 2026. Fue exploratoria y no sistemática. Se priorizaron fuentes de 2019 en adelante, con antecedentes anteriores cuando eran necesarios para la memoria prospectiva, el espacio, los recordatorios tangibles o el diseño de interacción. El corpus combinó artículos académicos, documentación oficial, páginas comerciales y fichas técnicas.

Las fuentes se clasificaron según su fuerza para cada afirmación. Revisiones y metaanálisis orientan la consistencia del campo, mientras los estudios experimentales o longitudinales describen mecanismos concretos y condiciones acotadas. La documentación oficial informa funciones, compatibilidad declarada, requisitos y precios visibles. Por último, las páginas comerciales muestran cómo una marca organiza su propuesta, pero no sostienen eficacia independiente.

La búsqueda no fue un estudio de patentes, disponibilidad en Chile, participación de mercado o disposición de pago. La oportunidad que se formula a continuación es relativa al corpus revisado y a su fecha de corte.

## 8.2 Criterios para leer las respuestas existentes

La evidencia académica revisada en el capítulo 5 obliga a comparar mecanismos y no solo apariencias. Las intervenciones de autocontrol digital muestran resultados variables y suelen evaluarse mediante reducción de uso, aperturas o persistencia, indicadores que no equivalen a bienestar, autonomía ni recuperación de una intención (Biedermann et al., 2021; Monge Roffarello & De Russis, 2023). Un bloqueo puede ser adecuado cuando el objetivo es impedir el acceso, pero no por ello responde al problema delimitado en esta memoria.

Las pausas estudiadas en one sec demuestran que una fricción breve puede modificar el curso de una apertura y que sus efectos deben observarse a lo largo del tiempo (Grüning et al., 2023; Haliburton et al., 2024). Para Relevo funcionan como control cercano: si una intervención en el teléfono ofrece el mismo apoyo con menor carga, el objeto pierde fundamento. A su vez, la investigación sobre recordatorios externos advierte que formular, emparejar, situar y rearmar también forman parte del costo de la intervención (Chiu & Gilbert, 2024). Por eso la comparación del mercado considera tanto lo que cada respuesta hace como el esfuerzo, la dependencia técnica y los problemas que deja abiertos.

## 8.3 Familias de mecanismos

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

## 8.4 Herramientas nativas

Apple Screen Time y Google Digital Wellbeing ofrecen medición, temporizadores, límites y periodos de desconexión (Apple, s. f.; Google, s. f.-c). Su ventaja es la disponibilidad y el bajo costo adicional: no requieren un objeto, carga ni emparejamiento. Su límite para Relevo es que el significado de la intervención permanece dentro del teléfono y suele expresarse como tiempo, apertura, categoría o pausa.

Pause Point, comunicado por Google en 2026, acerca la plataforma a una intervención de reconsideración. Su disponibilidad está vinculada a versiones y dispositivos específicos, por lo que no se trata como una capacidad universal de Android (Google, s. f.-c; Sanders, 2026). El proyecto no necesita negar el valor de una pausa nativa. Necesita saber qué tendría que aportar un objeto externo para justificar su complejidad.

## 8.5 Aplicaciones de fricción

one sec ofrece fricciones configurables y seguimiento de aperturas, y su mecanismo ha sido estudiado en condiciones experimentales y de uso prolongado (one sec, s. f.; Grüning et al., 2023; Haliburton et al., 2024). Es el referente digital más próximo a la reconsideración antes de continuar. Su señal aparece dentro del flujo que concentra la atención y puede ser ignorada, sostenida o abandonada según la situación.

Para Relevo, one sec establece un control conceptual: si una intervención en pantalla entrega el mismo apoyo a la intención con menos costo y mantenimiento, el objeto pierde fundamento. La diferencia no debe buscarse en hacer una interrupción más intensa, sino en examinar si el entorno físico puede participar en la recuperación.

## 8.6 Objetos de barrera y llaves

Brick declara un dispositivo físico que funciona como llave para activar o revertir modos de bloqueo, con un precio visible de USD 59 y compatibilidad declarada con Android 12 o posterior e iOS 17 o posterior al momento de la consulta (Brick LLC, s. f.-a). Unpluq combina Tag, NFC, barreras, horarios y estadísticas, con un modelo que incluye suscripción (Unpluq, s. f.). Screenless Breaker ofrece una llave física NFC para volver a abrir aplicaciones bloqueadas y mostraba un precio de EUR 45 (Screenless, s. f.).

Brick Zone describe un dispositivo Bluetooth orientado a bloquear aplicaciones en espacios declarados y mostraba un precio de USD 99 (Brick LLC, s. f.-b). Estos productos prueban que existe una oferta comercial de objetos vinculados al control del teléfono. No prueban que el objeto pueda actuar como recordatorio no coercitivo ni que su relación espacial sea equivalente a la de Relevo.

## 8.7 Objetos de foco y recordatorios

Focusaur declara un dispositivo de foco con aplicación, movimiento del teléfono, etiquetas NFC, sonidos y funciones de hábito; su página mostraba USD 129 en oferta y un precio de referencia de USD 169 a la fecha de corte (Focusaur, s. f.). La oferta sirve para estudiar lenguaje de valor, componentes y modelo de negocio. La cifra de patrocinadores comunicada por la marca no se interpreta como adopción independiente. Su lógica de foco y recompensa no se incorpora a Relevo.

*The Tangible Reminder* vincula objetos con información de citas y un display ambiental (Hermann et al., 2007). El antecedente es útil para pensar la relación entre objeto, lugar y señal, pero presenta contenido visible, urgencia cromática y tareas temporales. Relevo distribuye el significado entre la aplicación, la memoria de la persona y la presencia del testigo situado.

## 8.8 Adopción, abandono y modelos de valor

La evidencia revisada muestra que una herramienta puede ser abandonada por dejar de ser necesaria, ser demasiado restrictiva, poder sortearse o exigir una configuración que no compensa. La persistencia no se deduce del interés inicial. Los estudios de one sec muestran que una fricción puede modificar aperturas en un periodo, pero también que la intervención puede producir pausas y rebotes. Chiu y Gilbert (2024) sitúan el esfuerzo de armado como parte del mecanismo.

Una línea reciente explora la reconfiguración de reglas en lugar de asumir que una intervención configurada una vez seguirá siendo pertinente. Kidel Peña-Albert et al. (2026) estudiaron una invitación a reconfigurar una herramienta de autocontrol digital: 63 de 138 personas del grupo experimental, equivalentes al 46 %, aceptaron la propuesta. El estudio aporta una señal acotada sobre la importancia de revisar reglas que pierden pertinencia; no demuestra que Relevo necesite personalización algorítmica ni que una mayor interacción con la herramienta equivalga a autonomía o bienestar.

Los modelos de mercado observados incluyen funciones integradas al sistema operativo, aplicaciones con funciones premium, suscripciones vinculadas a una etiqueta y dispositivos con aplicación complementaria. La existencia de un precio no indica disposición de pago. Para Relevo, el modelo de gestión tendrá que separar costo del prototipo, trabajo profesional, producción, soporte, reemplazo y precio hipotético.

## 8.9 Frontera phygital y oportunidad acotada

El corpus revisado combina herramientas digitales, llaves físicas, Bluetooth, NFC, espacios declarados, recordatorios tangibles y productos de foco. No se encontró en el corpus una evaluación independiente que reúna explícitamente una intención autoformulada, un primer paso, una condición digital, un testigo físico situado por la persona, ausencia de bloqueo y comparación con una notificación. Esta formulación no afirma inexistencia universal; delimita una oportunidad investigable.

La oportunidad de Relevo se acota a una especialización provisional: recuperar una intención propia en el lugar donde puede comenzar su primer paso. El proyecto no convierte la medición, el bloqueo, la interrupción o la separación física en su mecanismo principal, sino que investiga si una señal situada puede devolver esa intención a la escena donde puede iniciarse, manteniendo abierta la decisión. La notificación es el control porque el testigo debe demostrar que aporta algo más que un mensaje. Esta formulación no acredita eficacia, adopción ni novedad universal.

# 9. Síntesis de la investigación y criterios de diseño

## 9.1 De la evidencia a la decisión

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
| Android y Bluetooth de baja energía (BLE). | Existe una ruta técnica, con permisos y fallos. | Condición observable y vencimiento. | Android inicial. | P3. | Pendiente. |

## 9.2 Principios de diseño

**Recuperación situada de una intención propia.** Relevo se especializa provisionalmente en volver presente una intención formulada por la persona en el lugar donde puede comenzar su primer paso. Este principio expresa una propuesta de valor provisional, no un efecto demostrado.

**Pertinencia situacional.** La ayuda solo resulta pertinente cuando una intención propia pierde capacidad para orientar el paso siguiente durante un episodio de continuidad digital poco deliberada. La condición técnica será un evento observable y configurable, todavía abierto; podrá iniciar el ciclo, pero no inferir por sí sola que una actividad es indeseada ni que la persona deba interrumpirla.

**No intervención como resultado.** La inactividad del sistema es correcta ante ocio elegido, actividad relacional, concentración, descanso o ausencia de alternativa.

**Valor físico específico.** El objeto debe aportar una relación explicable por presencia, ubicación o manipulación que una notificación no entregue de la misma forma.

**Autonomía reversible.** La persona puede configurar, modificar, ignorar, silenciar y desarmar. Continuar con el teléfono no produce deuda ni registro.

**Carga proporcional.** El armado, emparejamiento, prueba, carga y reubicación deben mantenerse en proporción con el valor investigado.

**Apertura a reformulación.** Si el testigo transportable falla, se modifica o reemplaza la dirección física sin convertir Relevo en una aplicación.

## 9.3 Oportunidad formulada

Relevo formula una ayuda phygital cuyo posible valor consiste en recuperar una intención propia allí donde puede comenzar su primer paso. A diferencia de respuestas orientadas a medir, bloquear, interrumpir la continuidad o separar físicamente el teléfono, la propuesta sitúa el énfasis en la relación entre intención, lugar y señal. La oportunidad existe solo si la persona puede reconstruir la intención y el primer paso sin consultar nuevamente el teléfono, si el lugar aporta un significado reconocible, si la señal no se vuelve intrusiva y si el conjunto compensa la carga que agrega.

La oportunidad no es un resultado de usuarios. Las personas entrevistadas no compararon productos, no probaron Relevo y no expresaron preferencia por su forma. La propuesta surge de la relación entre evidencia, marco teórico, mercado y criterios del autor. Sus decisiones deben permanecer trazables y revisables.

# 10. Formulación del proyecto

A partir de las aristas del problema, el marco teórico, los episodios de usuarios, el estado del arte y los criterios anteriores, el proyecto puede formularse sin usar el producto como justificación retrospectiva de la investigación.

## 10.1 Problema de diseño

En algunos episodios de ocio digital, una intención alternativa previamente formulada pierde capacidad para orientar el siguiente paso mientras la actividad actual conserva continuidad. Las respuestas más extendidas miden, interrumpen o restringen el uso, pero no necesariamente devuelven esa intención al lugar donde puede comenzar. El problema de diseño consiste en mediar esa recuperación sin bloquear el ocio digital, evaluar la respuesta ni confundir una condición técnica con el estado subjetivo de la persona.

## 10.2 Perspectiva del usuario

La declaración de punto de vista, o **POV** por la expresión inglesa *point of view*, sintetiza usuario, necesidad e interpretación de fondo:

> Una persona adulta joven que ya formuló una actividad alternativa y reconoce cómo empezarla necesita mantener esa posibilidad disponible durante ciertos episodios de continuidad digital, porque el siguiente contenido conserva presencia inmediata mientras la intención propia deja de orientar la decisión.

El POV no describe a todas las personas de 18 a 30 años ni convierte la edad en causa. Se activa únicamente cuando coinciden la continuidad, una intención autoelegida y la pérdida de disponibilidad de su primer paso. Ante ocio significativo o ausencia de alternativa, el POV deja de ser pertinente y el sistema debe permanecer inactivo.

## 10.3 Preguntas del proyecto

**Pregunta de investigación.** ¿En qué condiciones una clave externa, configurada por la persona, puede apoyar la recuperación espontánea de una intención y de su primer paso durante un episodio de continuidad digital poco deliberada, sin bloquear, puntuar ni evaluar la decisión posterior?

La recuperación se reconocerá cuando la persona identifique la intención y el primer paso después de la señal sin consultar la aplicación para descifrarla. No equivale a realizar la actividad, abandonar el teléfono o reducir minutos.

**Pregunta proyectual.** ¿Cómo diseñar un sistema phygital compuesto por una aplicación Android, una condición observable y un testigo físico situado, de modo que la relación entre intención, señal, lugar y primer paso preserve autonomía, privacidad y convivencia, y pueda compararse con una notificación digital equivalente?

## 10.4 Hipótesis de trabajo

> Si una persona registra una intención propia y su primer paso, sitúa un testigo físico junto a ese comienzo y recibe allí un pulso ambiental cuando se cumple una condición configurada, entonces la intención podría volver a estar disponible para la decisión sin bloquear la actividad digital ni imponer su ejecución.

La hipótesis contiene cuatro relaciones que deberán evaluarse por separado: asociación entre señal e intención; aporte del lugar y del objeto frente a una notificación; percepción y salida autónoma; y ejecución técnica de la condición. Se debilita si la persona necesita consultar el teléfono, si el lugar no añade una relación reconocible, si la señal se percibe como vigilancia o si la materialidad agrega más carga que valor.

## 10.5 Objetivos

### 10.5.1 Objetivo general

Diseñar y evaluar formativamente un sistema phygital que apoye la recuperación situada de una intención autoelegida durante episodios de continuidad digital poco deliberada, mediante la articulación de una aplicación Android, una condición observable y un testigo físico asociado al primer paso de la actividad, sin bloquear ni calificar la decisión posterior.

### 10.5.2 Objetivos específicos

1. Caracterizar la relación entre ocio digital, continuidad, intención alternativa y contexto mediante revisión bibliográfica, entrevistas y análisis de referentes, para establecer usuarios, límites y criterios de diseño.
2. Desarrollar un sistema phygital inicial que traduzca esos criterios en una aplicación, un testigo físico situado, una señal, flujos, estados técnicos y condiciones productivas documentadas.
3. Evaluar progresivamente la comprensión de la asociación, el aporte del lugar y la materialidad, la autonomía de salida y la factibilidad técnica, para decidir si la propuesta se mantiene, se modifica o se abandona.

## 10.6 Alcance, exclusiones y criterios de cambio

El alcance inicial considera una persona, una intención activa, un primer paso, una aplicación seleccionada, una condición observable, un testigo físico y un lugar doméstico elegido manualmente. Android será la plataforma del prototipo integrado; esta elección concentra recursos y aprovecha capacidades nativas para consultar estadísticas autorizadas de uso y comunicarse mediante Bluetooth de baja energía. No constituye una promesa de compatibilidad universal.

Relevo no bloquea aplicaciones, asigna puntajes, construye rachas, compara usuarios, registra cumplimiento, utiliza geolocalización ni determina qué actividad es correcta. Tampoco infiere culpa, automatismo, emoción o valor subjetivo. La persona puede modificar, ignorar, silenciar, desarmar y continuar.

La forma, las dimensiones, el peso, el canal de señal, la autonomía energética, los materiales finales, el precio, la accesibilidad y la adopción sostenida permanecen abiertos. La dirección física se conservará si la asociación se comprende, el lugar aporta una diferencia reconocible, la señal admite una salida clara y la ejecución técnica resulta proporcional. Se modificará si falla una capa específica; se abandonará si una notificación equivalente entrega el mismo valor con menor carga o si ninguna configuración física evita vigilancia, confusión o intrusión.

## 10.7 Teoría de cambio

La **teoría de cambio** explica qué transformación se busca, mediante qué mecanismo y bajo qué supuestos. En Relevo, el estado inicial corresponde a un episodio donde una intención propia perdió disponibilidad. La intervención distribuye esa intención entre aplicación, testigo y lugar. Si la señal se percibe y se relaciona con el primer paso, la intención puede volver a considerarse; a partir de ahí, la persona decide libremente.

La cadena causal provisional es:

> formular una intención y su primer paso → situar el testigo → armar una condición observable → recibir un pulso vigente → atribuirlo a la intención → recuperar la posibilidad → decidir.

Los primeros cuatro eslabones dependen del diseño y la técnica; atribuir, recuperar y decidir dependen de la experiencia de la persona. Ninguno autoriza a registrar obediencia. El sistema ofrece una clave externa y control de salida; a cambio, solicita formular, configurar, situar, mantener e interpretar. Si ese esfuerzo supera el valor percibido, el contrato de uso deja de ser proporcional.

Los supuestos críticos son tres: que la asociación pueda comprenderse sin volver a la aplicación; que el lugar y el objeto aporten una diferencia frente a un lugar neutro y una notificación; y que la configuración, la convivencia y el mantenimiento resulten tolerables. La evaluación del capítulo 14 convierte cada supuesto en una puerta de decisión.

## 10.8 Mapa de actores

| Actor | Relación con el proyecto | Decisión o necesidad principal |
| --- | --- | --- |
| Usuario principal situacional | Configura una intención, sitúa el testigo e interpreta la señal. | Comprensión, control, privacidad y carga proporcional. |
| Usuario límite y convivientes | Pueden recibir una señal no pertinente o compartir el espacio. | No intervención, discreción y salida inmediata. |
| Diseñador | Articula investigación, experiencia, forma, flujos y evaluación. | Mantener trazabilidad y detener decisiones sin fundamento. |
| Desarrollo Android y electrónica | Implementan condición, enlace, energía, señal y recuperación. | Fiabilidad acotada, estados comprensibles y documentación de fallos. |
| Especialistas en accesibilidad e investigación | Revisan canales, instrumentos, consentimiento y análisis. | Evitar exclusiones y afirmaciones que excedan la evidencia. |
| Fabricantes, proveedores y cumplimiento | Participan en materiales, ensamblaje, reparación, radio y seguridad. | Costos, trazabilidad productiva y requisitos aplicables. |

El capítulo 13 desarrolla responsabilidades, entregables y modelo de gestión. Aquí el mapa cumple una función de formulación: muestra que la experiencia no depende solo del usuario y el objeto, sino de una red de decisiones técnicas, productivas y éticas.

## 10.9 Metodología proyectual y plan de trabajo

La investigación mediante diseño organiza el avance por preguntas dependientes. Primero se estudia la asociación entre intención, primer paso, lugar y señal mediante una activación simulada. Si esa relación se comprende, se compara el testigo en un lugar congruente, un lugar neutro y una notificación. Solo entonces se seleccionan el canal y la salida física, se integra la condición Android–BLE y se prepara un piloto acotado.

Cada etapa produce un resultado distinto. Una prueba conceptual informa comprensión; una maqueta funcional, percepción y manipulación; un banco técnico, permisos, enlace y vencimiento; un piloto, uso situado y carga acumulada. Pasar a una fidelidad mayor sin resolver la pregunta anterior mezclaría fallos de concepto, forma y técnica.

El trabajo pendiente sigue esta secuencia:

1. Ejecutar P0 y decidir si la asociación básica merece continuar.
2. Ejecutar P1 para aislar el aporte del lugar y del objeto frente a la notificación.
3. Definir en P2 el canal, la intensidad y la salida física a partir de percepción, convivencia y accesibilidad.
4. Integrar y probar en P3 la condición observable, permisos, enlace, vencimiento y recuperación de fallos.
5. Preparar P4 únicamente si las etapas anteriores sostienen una propuesta comprensible, autónoma y técnicamente proporcional.
6. Actualizar forma, producción, costos y conclusiones con la evidencia obtenida.

No se desarrollarán simultáneamente la forma final, la automatización completa y el escalamiento. Cada decisión abierta se cerrará con la prueba correspondiente y quedará registrada junto con la evidencia que la sostiene.

# 11. Propuesta y desarrollo proyectual

## 11.1 Del problema a una dirección objetual

El desarrollo compara familias de objetos según asociación con el primer paso, percepción del pulso ambiental, autonomía, movilidad, carga de configuración, privacidad, convivencia, factibilidad técnica y producción. La matriz es una herramienta cualitativa del autor; no recoge preferencias de las personas entrevistadas.

El análisis se realiza en dos escalas. La primera pregunta qué familia conserva la relación entre aplicación, testigo, lugar y persona. La segunda pregunta si el objeto puede situarse, percibirse y silenciarse sin instrucciones excesivas. Una alternativa técnicamente sencilla que elimina la asociación manual puede resolver un artefacto, pero no necesariamente el problema de Relevo.

El criterio rector no es añadir una barrera al uso digital, sino conservar la relación intención–primer paso–lugar identificada en el estado del arte. Una decisión que desplace el centro hacia medir, bloquear, interrumpir por sí misma o separar el teléfono deberá considerarse una desviación de la oportunidad formulada, no una profundización de Relevo.

## 11.2 Familias exploradas

**Cuna o base de guardado.** Concentra carga y almacenamiento, pero fija el objeto a un punto y desplaza el sentido desde el primer paso hacia el guardado. Agrega volumen, contactos y piezas. Se descarta provisionalmente porque no es necesaria para estudiar asociación.

**Objeto de consulta con pantalla.** Mostraría intención, estado o instrucciones, pero repetiría el contenido de la aplicación, aumentaría consumo y convertiría el testigo en otra superficie de lectura. Se descarta porque desplaza su función desde la presencia ambiental hacia la consulta de información.

**Faro fijo.** Puede ser perceptible y estable, pero limita la relación con primeros pasos diversos. Se conserva como alternativa conceptual, no como dirección inicial.

**Testigo transportable.** Permite situar manualmente la señal junto al primer paso y comparar un lugar congruente con uno neutro. Se selecciona como dirección provisional porque ajusta mejor con una asociación reversible. Sus riesgos son pérdida, reubicación, baja perceptibilidad, mantenimiento y apariencia de alarma genérica.

## 11.3 Estado de forma y materialidad

La forma circular, la compacidad, la transportabilidad, la presencia reconocible y la posibilidad de manipular el objeto son hipótesis formales y metas de prototipado, no especificaciones finales. No se fija en esta memoria una medida, peso, color, autonomía, canal o material definitivo.

Más que una cuestión de tamaño, la compacidad reúne varias exigencias. Debe permitir que la señal se perciba, que el objeto se sitúe, que la batería se mantenga, que los componentes puedan repararse y que el conjunto no se confunda con una alarma. Aunque la transportabilidad puede facilitar la asociación, también aumenta el riesgo de pérdida y la carga de traslado. A su vez, la presencia debe ser suficiente para quien configuró el sistema sin imponerse a convivientes.

Luz, sonido y vibración son variables de prueba. La luz puede depender de línea de visión; el sonido puede alcanzar a otras personas; la vibración puede no transmitirse sobre todas las superficies. La configuración de canales no se declara universal ni accesible por anticipado.

## 11.4 Decisiones mantenidas y descartadas

**Tabla 5**

*Estado de decisiones de dirección*

| Elemento | Estado | Razón |
| --- | --- | --- |
| Sistema phygital | Mantener | La pregunta exige relación entre aplicación, objeto, lugar y persona. |
| Testigo físico situado | Mantener | Permite investigar la relación entre intención, primer paso, lugar y pulso ambiental. |
| Aplicación Android | Mantener para el prototipo inicial | Reúne capacidades nativas de consulta autorizada de uso y comunicación BLE en un único entorno de prueba. |
| Aplicación web | Descartar como capa operativa inicial | La distribución mediante URL no asegura compatibilidad BLE uniforme; las fuentes consultadas no identifican una función equivalente a `UsageStatsManager`, servicio de Android que permite consultar estadísticas de uso autorizadas. |
| Aplicación iOS | Fuera del alcance inicial | Su integración es plausible, pero requiere una segunda arquitectura nativa y autorizaciones propias antes de validar el aporte del sistema. |
| Lugar manual | Mantener provisionalmente | La asociación pertenece a la persona, no a una detección automática. |
| Una intención y un primer paso | Mantener provisionalmente | Reduce ambigüedad y carga inicial. |
| Cuna o base | Descartar provisionalmente | No es necesaria para la primera pregunta y agrega piezas. |
| Display de consulta | Descartar por alcance | Duplica contenido y desplaza al testigo desde la presencia ambiental hacia otra superficie informativa. |
| Faro fijo | No seleccionar inicialmente | Reduce movilidad y variedad de contextos. |
| Testigo transportable | Seleccionar provisionalmente | Permite comparación situada/neutra y reubicación manual. |
| Forma, peso, color, autonomía | Pendiente | Requieren pruebas de percepción, manipulación, energía y producción. |
| Precio | Pendiente | Requiere costos reales, modelo de gestión y disposición de pago. |

## 11.5 Dirección física y criterio de refutación

La selección del testigo transportable cierra una dirección de investigación, no una forma final. Si la asociación no aparece, primero se revisarán señal, lugar, control, gesto y contexto. Si el conjunto físico no aporta diferencia frente a la notificación, la dirección se reformulará o abandonará. Cualquier dirección posterior de Relevo deberá conservar el carácter phygital y una interfaz objetual ambiental; si ninguna configuración de ese tipo sostiene un valor defendible, la formulación actual quedará refutada y volverá a investigación de diseño.

La evidencia negativa debe identificar qué fue refutado. Una señal puede fallar por su modalidad; un lugar, por su relación con el primer paso; el testigo, por su transportabilidad; la regla, por su momento; o el sistema, por su carga total. No corresponde convertir un fallo local en una conclusión sobre toda materialidad.

## 11.6 Resultado del desarrollo estructural

La dirección seleccionada se tradujo a una arquitectura de interacción antes de cerrar su forma. Este paso evita que la propuesta dependa de una imagen única del objeto y permite examinar qué debe comprender, decidir y recuperar la persona en cada momento. El ciclo quedó organizado en tres interacciones principales:

1. **Formular y preparar una intención:** registrar una intención, concretar su primer paso, seleccionar una condición provisional y revisar la configuración.
2. **Vincular, situar, probar y armar:** asociar el testigo correcto, ubicarlo junto al primer paso, comprobar el pulso en ese contexto y armar el ciclo explícitamente.
3. **Esperar, recibir y cerrar:** mantener la regla durante su vigencia, emitir un único pulso cuando exista una orden válida y permitir que la persona cierre, ignore, silencie o recupere un fallo técnico.

Nueve marcos sintetizan la ruta principal, tres por interacción. Una segunda capa amplía esa síntesis a 35 estados para comprobar permisos, salidas voluntarias, enlace, batería, vencimiento, cambio de lugar, recuperación y rearme. La expansión no agrega funciones: vuelve visibles las condiciones necesarias para que el ciclo sea comprensible y no confunda una decisión personal con un error técnico.

Los **wireframes**, o esquemas que organizan contenido, jerarquía y navegación antes de definir la apariencia final, se desarrollaron en baja o media fidelidad. Su estructura constituye un resultado proyectual; el estilo, las dimensiones de interfaz y los componentes gráficos todavía no conforman una identidad definitiva. Tampoco demuestran comprensión, accesibilidad o factibilidad. La cobertura completa se resume en el Anexo D y funciona como base para prototipos posteriores.

## 11.7 Definición canónica

Relevo es un sistema phygital compuesto por:

1. una aplicación Android que conserva el significado de la intención y configura el ciclo;
2. una condición observable cuya forma sigue pendiente;
3. un enlace local mediante Bluetooth de baja energía (BLE), que transporta patrones y estados técnicos;
4. un testigo físico situado, transportable y asociado a una intención activa, que emite un pulso ambiental;
5. un lugar que la persona elige y asocia manualmente con el primer paso;
6. una persona que interpreta, decide, ignora, silencia o modifica.

La aplicación conserva el contenido semántico de la intención; el testigo recibe solo el patrón y los parámetros indispensables para producir el pulso. Esta distribución evita convertir el objeto en otra interfaz de consulta. El lugar no es un sensor. La persona puede cambiar de decisión. Relevo no bloquea, clasifica, puntúa ni registra cumplimiento.

## 11.8 Elementos y límites

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

## 11.9 Caso doméstico mínimo

El caso mínimo considera una persona, una aplicación seleccionada, una intención, un primer paso, un lugar doméstico elegido, un testigo y una **ventana de activación**, es decir, el intervalo durante el cual la regla permanece vigente. El objeto puede moverse, pero el sistema no sabe si fue trasladado. La persona debe poder reubicarlo, probarlo y rearmar. No se supone una habitación privada, una superficie disponible ni una convivencia compatible con sonido.

Este recorte permite estudiar la asociación antes de agregar múltiples usuarios, varias intenciones, geolocalización, detección ambiental o seguimiento. El hogar es una hipótesis de primer contexto porque permite observar materialidad y convivencia, pero las pruebas deberán declarar qué parte del contexto se observó realmente.

## 11.10 Secuencia de uso propuesta

La persona identifica una intención alternativa que desea mantener disponible y define un primer paso. En la aplicación registra el contenido semántico, selecciona una condición provisional y vincula el testigo. Luego sitúa el objeto junto al primer paso y realiza una prueba perceptiva. Antes de armar puede corregir intención, lugar o condición.

Durante la espera puede desarmar o modificar. Si la condición se cumple y el enlace entrega un comando vigente, el testigo emite la señal. La persona puede reconocer la intención, iniciar el primer paso, continuar con la actividad digital, ignorar o silenciar. No hay respuesta correcta.

El armado, desarmado y silencio son decisiones de interacción aún abiertas. Debe existir una salida clara para detener una señal activa, pero los gestos exactos solo se fijarán después de pruebas de comprensión y manipulación. Ningún gesto significa que la actividad alternativa fue realizada.

## 11.11 Candidatos de activación

**Uso continuo.** La señal se produce tras una permanencia de la aplicación seleccionada en primer plano dentro de una ventana armada. Puede ser fácil de explicar, pero confunde continuidad con intención y debe enfrentar cambios de aplicación, pantalla bloqueada y eventos tardíos.

**Uso acumulado en ventana.** La aplicación suma tiempo de primer plano dentro de una ventana y activa al alcanzar una condición. Tolera pausas, pero exige explicar reinicios, fragmentación y privacidad.

**Horario o franja.** La persona elige un momento en que podría recibir la señal, sin depender directamente de un evento de uso. Simplifica la técnica, pero puede aparecer sin relación con la actividad actual y convertirse en alarma.

La elección dependerá de comprensión, observabilidad, pertinencia temporal, permisos, vencimiento y fallos. En ningún caso la aplicación podrá afirmar que detectó automatismo o una intención desplazada. Como regla mínima de integración se exigirán una aplicación, una ventana armada, una condición observable, una señal, un vencimiento y una salida.

## 11.12 Privacidad y autonomía

La propuesta excluye cuentas, servicios en nube, geolocalización, micrófono, historial de cumplimiento, clasificaciones y rachas. Una condición basada en uso podría consultar localmente estadísticas durante una ventana armada; eso limita la circulación, pero no elimina el permiso ni el alcance técnico que el sistema operativo concede.

Los datos posibles son intención, aplicación seleccionada, condición, ventana, identificador del testigo, batería, permisos y errores. Cada dato requiere propósito, almacenamiento, retención, eliminación y exposición definidos. El testigo no recibe el texto de la intención ni funciona como localizador.

La privacidad también incluye quién puede leer la intención en el teléfono y qué revela una señal en un espacio compartido. La autonomía exige que la persona entienda el estado y pueda recuperar el control. Un botón de apagado no basta si el sistema no explica cuándo la señal está armada o si la persona siente que cambiar de intención equivale a fallar.

## 11.13 Alcance de plataforma

Android se selecciona como única plataforma del prototipo técnico integrado por razones de capacidad y alcance, no por una superioridad universal. `UsageStatsManager` permite consultar historial y estadísticas de uso cuando la persona concede una autorización especial, mientras las interfaces de Android para dispositivos asociados y BLE ofrecen rutas documentadas para comunicarse con un periférico cuando la aplicación no permanece visible. Estas capacidades permiten reunir en un entorno acotado la observación de una condición autorizada y el enlace con el testigo. No garantizan fiabilidad: permisos, proceso, restricciones de segundo plano, batería, desconexiones y diferencias entre dispositivos deberán probarse en P3 (Google, s. f.-a, s. f.-b, s. f.-d).

La web se descarta como capa operativa de este prototipo. Puede resolver configuración y comunicarse con BLE en ciertos navegadores, pero Web Bluetooth exige autorización e interacción iniciada por la persona, no posee compatibilidad uniforme y WebKit declara que no implementa esta interfaz de programación. Una dirección web ampliaría el acceso a la interfaz; sin embargo, las fuentes consultadas no permiten sostener una operación uniforme del sistema completo ni identifican una capacidad web equivalente a `UsageStatsManager` (Chrome for Developers, s. f.; WebKit, s. f.).

iPhone también queda fuera del alcance inicial. Su integración es plausible, pero no está demostrada para Relevo. Apple ofrece marcos nativos para actividad de aplicaciones y sitios, así como Core Bluetooth para accesorios; incorporarlos exigiría una segunda implementación, autorizaciones y restricciones propias. El proyecto prioriza demostrar primero la relación intención–lugar–testigo en una arquitectura Android. Web e iOS solo se reconsiderarán después de validar el aporte físico y evaluar recursos, privacidad y factibilidad de expansión (Apple Developer, s. f.-a, s. f.-b, s. f.-c).

# 12. Arquitectura de experiencia y flujos

## 12.1 Arquitectura mínima y aspiracional

La arquitectura mínima de Relevo debe permitir estudiar una relación, no resolver todos los contextos. Incluye una aplicación Android, una aplicación seleccionada, una intención, un primer paso, una condición observable pendiente, una ventana armada, un testigo físico situado, un patrón de señal y una salida. La activación inicial puede ser simulada por el investigador. En esta etapa no son requisitos la automatización, el enlace BLE, la batería ni la producción.

En una arquitectura aspiracional, el sistema podría consultar estadísticas mediante UsageStatsManager, funcionar con la aplicación en segundo plano, mantener un enlace BLE, informar batería, recuperar estados y operar en dispositivos de distintos fabricantes. UsageStatsManager expone información de uso de aplicaciones bajo un permiso especial; no detecta automatismo ni garantiza una activación inmediata (Google, s. f.-d). Por su parte, la ejecución BLE en segundo plano depende de la versión, el fabricante, la energía y la configuración (Google, s. f.-a; Google, s. f.-b). Este planteamiento sigue siendo una hipótesis técnica.

**Tabla 7**

*Niveles de arquitectura*

| Nivel | Componentes | Pregunta | No permite afirmar |
| --- | --- | --- | --- |
| Conceptual | Persona, intención, primer paso, lugar y señal simulada | ¿La relación se entiende? | Desempeño técnico. |
| Funcional | Objeto, canal, control de salida y asociación situada | ¿La señal se percibe y se atribuye? | Accesibilidad universal. |
| Técnico | Android, condición, BLE, estados, vencimiento y batería | ¿El evento se ejecuta y se recupera ante fallos? | Valor físico o autonomía doméstica. |
| Integrado | Sistema completo y piloto acotado | ¿La dirección conserva valor y carga proporcional? | Mercado, precio o adopción sostenida. |

## 12.2 Precondiciones, estados y puertas

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

Estas puertas se atraviesan en orden. Primero se comprueba que la intención pueda expresarse sin opciones innecesarias y que el objeto correcto quede vinculado. Después se examinan la relación creada por el lugar, la percepción y atribución de la señal, y el comportamiento técnico de la condición, la entrega y el vencimiento. El ciclo solo llega al rearmado cuando puede repetirse sin transformarse en una obligación.

## 12.3 Flujo de usuario

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

## 12.4 Flujo del sistema

El sistema distribuye responsabilidades sin reemplazar la decisión personal. Mientras la aplicación conserva el significado y el estado, una regla local convierte la condición observable en un posible evento y el enlace transporta el patrón correspondiente. El testigo lo expresa mediante una señal sin texto; el lugar aporta la asociación experiencial, pero no funciona como sensor. Formular la intención e interpretar qué hacer después sigue correspondiendo a la persona.

Un comando debe incluir un identificador de ciclo, un patrón de señal y un vencimiento. El testigo ejecuta solo comandos vigentes y, cuando sea posible, devuelve una confirmación técnica de recepción. Si el comando llega tarde, se descarta; una señal tardía puede perder significado y no debe presentarse como cumplimiento de la regla. Ante una pérdida de conexión, la aplicación muestra el estado técnico y permite desarmar.

## 12.5 Flujo técnico y fallos

El flujo técnico comienza con el armado explícito de la regla. Desde ese momento, Android consulta localmente la fuente de eventos definida para el prototipo, siempre bajo un permiso que puede revocarse o verse limitado por las políticas de energía. Cuando corresponde activar, BLE intenta transportar el patrón dentro de la ventana vigente; la entrega dependerá del teléfono, el objeto, la conexión y la batería. El testigo solo ejecuta la señal si recibe un comando válido a tiempo.

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

Los fallos se distinguen según el aspecto que comprometen. Son conceptuales cuando no se entiende la relación representada por el objeto; perceptivos, si la señal pasa inadvertida, se confunde o resulta invasiva; técnicos, cuando la condición, el permiso, el enlace, la batería o el vencimiento contradicen el estado informado; y de convivencia, si la señal afecta a otras personas o expone una intención. Diferenciarlos evita atribuir todos los problemas al usuario y permite corregir la capa correspondiente.

## 12.6 Flujo de diseño

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

## 12.7 Accesibilidad, autonomía y convivencia

La accesibilidad es un conjunto de requisitos por investigar, no una propiedad universal anticipada. Deben distinguirse dimensiones visual, auditiva, táctil, cognitiva, motora y doméstica. Un pulso ambiental no resuelve por sí solo las barreras: distribuye la carga entre señal, control, explicación en la aplicación y contexto.

El criterio preventivo de destellos de las Pautas de Accesibilidad para el Contenido Web (WCAG, por su sigla en inglés) orienta el riesgo visual, pero cumplir una referencia no prueba percepción ni accesibilidad (World Wide Web Consortium, s. f.). Una señal auditiva tampoco resuelve automáticamente la baja visibilidad, y la vibración debe evaluarse sobre superficies reales. Además, la aplicación debe explicar los estados técnicos sin exigir una consulta posterior para comprender la señal.

## 12.8 Mapa de datos y privacidad

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

## 12.9 Cobertura de interacciones y recuperación

La arquitectura detallada contiene 35 estados agrupados en cinco familias: configuración; vinculación y prueba física; armado; espera y señal; cierre y recuperación. La ruta principal utiliza los estados 01, 05, 08, 11, 14, 16, 20, 23 y 25. Los restantes explican validaciones previas, decisiones de salida, fallos técnicos o estados límite. Esta distinción impide que cada contingencia se convierta en una nueva función o que el recorrido normal exija atención permanente al teléfono.

Los estados 23 y 24 cambian deliberadamente de soporte. El primero representa el pulso en la situación física donde se encuentra el primer paso; el segundo registra que continuar, ignorar, silenciar o iniciar la actividad son respuestas posibles. No son pantallas del testigo ni evidencias de que el sistema observe la conducta. La aplicación reaparece cuando la persona necesita configurar, comprender un estado técnico o recuperar el control.

La cobertura establece cuatro reglas de cierre. Primero, una orden expirada no produce una señal tardía. Segundo, un cambio de lugar obliga a repetir la prueba antes de armar. Tercero, una pérdida de vínculo o un reinicio no activa un rearme automático. Cuarto, eliminar, desarmar o cambiar de intención son salidas legítimas. El Anexo D presenta la matriz completa y permite relacionar cada estado con su decisión principal.

# 13. Producción, factibilidad y modelo de gestión

## 13.1 Factibilidad como cadena de preguntas

Evaluar la factibilidad de Relevo no consiste en demostrar que una carcasa puede fabricarse. El análisis debe establecer qué necesita cada pregunta, quién puede resolverla, qué recursos requiere, qué riesgos permanecen y bajo qué condiciones podría sostenerse un testigo físico situado de señal ambiental. En esa escala, la producción comprende prototipado, fabricación, ensamblaje, prueba, reparación, mantenimiento y fin de vida; no se presume todavía una escala comercial.

## 13.2 Etapas de prototipo por pregunta

**Tabla 11**

*Relación entre fidelidad, pregunta y evidencia requerida*

| Etapa | Representación | Pregunta | Evidencia |
| --- | --- | --- | --- |
| P0 | Carcasa o testigo simulado y activación manual | ¿La persona asocia intención, primer paso, lugar y señal? | Relatos, atribución, consulta y relación espacial. |
| P1 | Mismo testigo en lugar congruente/neutro y notificación de control | ¿El lugar y la materialidad agregan valor? | Diferencias cualitativas, carga, intrusión y autonomía. |
| P2 | Prototipos de señal y salida física | ¿Qué canal se percibe y tolera? | Percepción, atribución, privacidad, convivencia y salida. |
| P3 | Android, BLE, condición, ventana, batería y objeto | ¿La regla se explica y opera ante fallos? | Permisos, enlace, vencimiento, reinicios y comandos tardíos. |
| P4 | Integración de mayor fidelidad y piloto acotado | ¿La dirección conserva valor y carga proporcional? | Rearmado, habituación, pérdida, privacidad, mantenimiento y abandono. |

## 13.3 Electrónica y componentes candidatos

Los componentes son medios para responder preguntas, no decisiones finales. Un microcontrolador de desarrollo como ESP32-C3 puede facilitar el primer enlace por disponibilidad, pero su consumo no representa un producto final. Para una versión de bajo consumo se han considerado como candidatos un nRF52810 o nRF52811, un gestor de energía nPM1100, un actuador de luz, un piezo, un actuador resonante lineal (LRA, por su sigla en inglés) y un controlador háptico.

Las hojas técnicas describen componentes aislados. Nordic especifica capacidades del nPM1100 y del nRF52810; Precision Microdrives documenta el actuador LRA C08-00A; Texas Instruments documenta el controlador DRV2605L (Nordic Semiconductor ASA, s. f.-a, s. f.-b; Precision Microdrives Ltd., 2023; Texas Instruments, 2018). Estos datos no demuestran que el conjunto alcance una autonomía, una intensidad o una experiencia perceptiva determinada.

La fuente de energía y el sistema de carga permanecen como decisiones de ingeniería por probar. La elección deberá basarse en mediciones del ciclo real —reposo, enlace, señal, carga y recuperación—, además de temperatura, seguridad, posibilidad de reemplazo y fin de vida. Una ficha aislada de batería no permite anticipar la autonomía del sistema.

## 13.4 Fabricación, ensamblaje y reparación

La fabricación académica puede comenzar con carcasa impresa, apoyos y componentes accesibles. Una fase posterior podría usar una placa de circuito impreso propia, una carcasa más resistente y una guía de señal separada, pero solo después de cerrar asociación, canal y enlace. Un prototipo demostrativo no debe presentarse como producto industrial.

La reparación debe contemplar batería, placa, actuadores, botón, difusor y carcasa. Un cierre reversible facilita diagnóstico y reemplazo, aunque puede reducir protección. La solución no se declara reparable hasta observar si el componente puede cambiarse sin introducir un riesgo nuevo. El mantenimiento mínimo incluye carga, revisión de vínculo, reubicación, prueba, rearmado, actualización o reinstalación de la aplicación y restablecimiento del testigo.

El fin de vida requiere separar batería, placa, carcasa y elementos de señal, además de definir qué parte puede reutilizarse. La responsabilidad del diseñador incluye no diseñar una pieza sellada o desechable sin justificarla mediante evidencia de seguridad, costo y reparación.

## 13.5 Costos diferenciados

La planificación económica separa cuatro magnitudes:

1. **Costo de prototipo académico:** componentes, impresión o fabricación, reposición, ensamble, herramientas y contingencia.
2. **Trabajo profesional:** investigación, diseño de experiencia, diseño industrial, electrónica, desarrollo Android, coordinación, análisis y documentación.
3. **Costo de producción:** proveedores, placa de circuito impreso, carcasa, batería, ensamblaje, prueba, certificación, logística, impuestos, merma, soporte y garantía.
4. **Precio:** decisión posterior que requiere costos reales, modelo de mantenimiento, alternativas y disposición de pago.

La lista base corregida se sitúa entre 51.140 y 92.640 pesos chilenos (CLP). Con una contingencia de 15 %, los extremos son CLP 58.811 y CLP 106.536; se comunica redondeada como **CLP 59.000–107.000**. Es una planificación no cotizada para una etapa de prototipo. No incluye horas profesionales, certificación, producción en serie, impuestos, soporte ni desempeño.

No se fija precio. La cifra de una unidad no puede multiplicarse para inferir producción. La escala introduce moldes, pruebas, rechazo, proveedores, almacenamiento, cumplimiento, garantía y soporte. Si la materialidad no aporta valor reconocible, un precio no la justifica.

## 13.6 Android, BLE y cumplimiento

UsageStatsManager puede exponer eventos de paquetes bajo un permiso especial, pero no detecta estados subjetivos ni garantiza tiempo real (Google, s. f.-d). Companion Device Pairing puede apoyar el vínculo cercano, aunque no crea por sí solo una conexión persistente (Google, s. f.-b). Las restricciones de ejecución BLE en segundo plano dependen de versión y fabricante (Google, s. f.-a). Las aplicaciones que requieran servicios en primer plano deben revisar los requisitos de distribución de Android (Google Play, s. f.).

Android es una plataforma inicial de prototipo. No se presenta compatibilidad universal, cobertura de fabricantes ni confiabilidad alcanzada. La integración deberá probar permisos, pantalla bloqueada, aplicación en segundo plano, cambio de aplicación, reinicio, batería, reconexión y vencimiento.

Un producto con radio deberá revisar el régimen aplicable a equipos de alcance reducido, junto con la documentación, los ensayos, el etiquetado y la declaración de conformidad exigibles en Chile (Subsecretaría de Telecomunicaciones [SUBTEL], 2026b). El prototipo académico no equivale a certificación.

## 13.7 Mapa de actores y modelo de gestión

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

## 13.8 Riesgos, mantenimiento y fin de vida

Los riesgos se organizan por concepto, percepción, técnica, convivencia, accesibilidad y economía. Cuando no se entiende la relación, corresponde volver a la intención, el primer paso, el lugar y la señal. Los problemas perceptivos exigen comparar canal, superficie y alcance; los técnicos, revisar estados, vencimiento, desarmado y recuperación. Si la convivencia se ve afectada, deben reconsiderarse exposición, privacidad y control de alcance. En materia económica, planificación y cotización permanecen separadas.

El mantenimiento empieza en la configuración. La persona crea una intención, concede permisos, vincula, sitúa, prueba y arma. Si reubica el objeto, debe repetir la prueba y armar. Si baja la batería, la aplicación debe explicar la limitación y orientar la carga o el desarmado. La reparación debe considerar batería, placa, actuadores, botón, difusor y carcasa. El fin de vida debe separar batería y electrónica y evitar una pieza sellada sin justificación.

La escala se considera solo cuando la dirección conserva función, señal, privacidad, reparación, mantenimiento y gestión en pruebas más amplias. Si existe aporte físico pero falla el testigo transportable, se modifica esa capa y se mantiene una interfaz objetual ambiental dentro del sistema phygital. Si ninguna configuración aporta una diferencia, se abandona la dirección física actual y se vuelve a investigación de diseño.

# 14. Plan de prototipado y evaluación

## 14.1 Estado de la evidencia y preguntas de evaluación

Las ocho entrevistas fueron realizadas presencialmente en Santiago los días 11 y 12 de junio de 2026. Constituyen evidencia exploratoria sobre episodios relatados, no una evaluación de Relevo. Q13 se refirió al concepto histórico In(Visible), por lo que solo orienta de manera condicional el tono discreto y no punitivo; no permite afirmar aceptación, eficacia, preferencia ni valor físico de Relevo. A la fecha de cierre de esta memoria no existen resultados de prototipos, comparación entre ubicaciones, comparación con una notificación ni integración Android–BLE.

Relevo se mantiene como sistema phygital: una aplicación configura el significado, un testigo físico situado emite un pulso ambiental y la persona lo asocia manualmente con un lugar y un primer paso. La notificación del teléfono será un control comparativo, no la solución final. Si el testigo transportable no aporta una diferencia reconocible, deberá reformularse o reemplazarse la dirección física; el proyecto no se convertirá en una aplicación sola.

La hipótesis central del capítulo 10 se examina mediante cuatro dimensiones operativas:

### E1. Asociación situada

Una intención, un primer paso, un lugar y una señal pueden formar una clave recuperable sin consultar continuamente la aplicación. Se debilita si la persona no puede explicar la relación o depende de texto y ayuda del investigador.

### E2. Aporte físico situado

El testigo en un lugar congruente podría aportar algo que no aparece con el mismo testigo en un lugar neutro ni con una notificación equivalente. Se debilita si las tres condiciones producen la misma comprensión y la notificación exige menos carga.

### E3. Percepción, autonomía y convivencia

La señal podría percibirse y atribuirse sin transformarse en alarma, vigilancia o reproche, y podría ignorarse, silenciarse o detenerse. Se debilita si invade la convivencia, expone una intención privada o no ofrece una salida clara.

### E4. Ejecución técnica

La activación, el vínculo entre aplicación y objeto y el vencimiento de una condición podrían operar de forma legible en el entorno Android/BLE elegido. Se debilita ante estados ambiguos, señales tardías o recuperación técnica desproporcionada. No se presupone compatibilidad universal.

La condición de activación permanece abierta entre continuidad de uso, acumulación dentro de una ventana y horario programado. El número de participantes, la duración y el reclutamiento del prototipo permanecen pendientes de un protocolo anterior a cualquier aplicación. Ninguna meta técnica o perceptiva se presenta como resultado.

## 14.2 Ruta progresiva P0–P4

La fidelidad aumenta únicamente cuando la etapa anterior deja una base suficiente. En cada puerta, la evidencia puede sostener la dirección, exigir cambios o justificar su detención.

### P0. Asociación con activación simulada

P0 busca saber si la persona puede relacionar la intención, el primer paso, el lugar y el pulso ambiental cuando el evento se activa manualmente. Basta un testigo de baja fidelidad, una ficha de configuración y un escenario acotado. Interesan la explicación espontánea, el recuerdo de la intención y del primer paso, la necesidad de consultar el teléfono, la posible intrusión y la libertad para ignorar o silenciar. Esta etapa no prueba Android, BLE, cambios de conducta ni uso doméstico; si la asociación requiere una explicación posterior o se confunde con una alarma, la señal deberá reformularse antes de avanzar.

### P1. Lugar congruente, lugar neutro y notificación de control

Con una asociación ya comprensible, P1 compara el mismo testigo en un lugar congruente y otro neutro, además de una notificación equivalente. Esta última funciona como control para aislar el aporte de la modalidad física, no como reemplazo de Relevo. La intención, el primer paso y la claridad del mensaje deben mantenerse comparables; el registro considera orden, razones de elección, comprensión, consulta, intrusión y salida. Si el lugar no crea una diferencia reconocible, o si la notificación entrega el mismo valor con menor carga, será necesario reformular la dirección física.

### P2. Canales de señal y salida

P2 compara alternativas visuales, auditivas y táctiles como variables de prueba, sin asumir que una de ellas será universal. Además de describir lo percibido, la persona debe poder silenciar o detener la señal sin regresar a la aplicación. La observación considera atribución, convivencia, superficie, movilidad, solicitudes de ayuda y autonomía. Si ningún canal resulta comprensible y reversible, habrá que modificar o reemplazar el testigo.

### P3. Condición Android/BLE y fallos

P3 traslada la evaluación al banco técnico. Allí se comparan las condiciones de activación todavía abiertas y se examinan el enlace BLE, el vencimiento y la recuperación ante permisos revocados, batería baja, desconexión, cambio de aplicación, pantalla bloqueada, reinicio, desplazamiento del objeto y señales tardías. Los fallos de concepto, percepción, técnica y convivencia se registran por separado. Los resultados solo describirán el dispositivo y la versión documentados; si la operación resulta desproporcionada, se ensayará una arquitectura más simple o se regresará a P2.

### P4. Integración y piloto acotado

P4 integra aplicación, objeto, lugar, condición, canal y salida únicamente después de superar las puertas anteriores. Antes de ejecutarlo deberán fijarse el contexto, el número de participantes, la duración, el reclutamiento, el consentimiento y el manejo de retiros. El registro incluirá episodios, cambios, silencios, abandonos y fallos, sin convertir la respuesta en un puntaje de cumplimiento. Aun así, un piloto acotado no permitirá afirmar eficacia poblacional, adopción, precio, accesibilidad universal ni autonomía prolongada.

## 14.3 Registro y regla de decisión

Cada prueba conservará su versión, fecha, contexto, consentimiento, participantes codificados, materiales, procedimiento, evidencia primaria, interpretación, límites y decisión posterior. Esta trazabilidad debe mantener separados los hechos, la evidencia, las inferencias, las hipótesis, las decisiones de alcance y los asuntos pendientes. Así, una activación simulada no podrá presentarse como automatización ni un registro técnico correcto como una experiencia ya comprensible. La dirección solo se sostendrá si convergen una asociación situada, una salida autónoma y una ejecución proporcional. Si el objeto no aporta frente a la notificación, la formulación física vigente quedará refutada y deberá regresar a investigación de diseño; cualquier alternativa posterior tendrá que conservar el carácter phygital y una interfaz objetual ambiental.

## 14.4 Instrumentos y trazabilidad de evaluación

Cada puerta se documentará mediante una ficha de prueba y una matriz de casos. La ficha identificará la versión del sistema, la pregunta que se intenta responder, la hipótesis relacionada, la condición comparada, el material utilizado, el procedimiento, el contexto, los participantes codificados, el consentimiento, los incidentes y la decisión siguiente. La matriz reunirá por separado lo que la persona hizo o dijo, la evidencia que permite sostenerlo, la interpretación del investigador, la hipótesis que permanece abierta y la decisión que se desprende de la prueba. Esta separación evita que una impresión favorable se convierta en eficacia o que un fallo técnico se interprete como refutación automática de la necesidad.

El registro de P0 y P1 deberá distinguir al menos cinco estados: la persona percibió la señal; pudo atribuirla al sistema; recuperó la intención; identificó el primer paso; y decidió qué hacer después. Consultar el teléfono, continuar con la actividad digital, ignorar la señal o modificar la intención no se codificarán como incumplimientos. En P2 se añadirá la posibilidad de silenciar o detener el objeto y la incidencia sobre la convivencia. En P3 se registrarán los estados técnicos y su recuperación; en P4 se observará la relación entre configuración, uso, rearmado, mantenimiento y abandono.

Las decisiones serán formativas y comparativas, no una suma de puntuaciones. Un caso puede sostener una asociación y, al mismo tiempo, mostrar una señal intrusiva; una falla de enlace puede exigir simplificar la arquitectura sin negar el problema; y una buena comprensión en laboratorio puede no transferirse a una vivienda. Por eso cada ficha deberá conservar también contraejemplos, condiciones ambientales y razones de descarte. La memoria solo incorporará como resultado aquello que tenga una ejecución documentada; todo lo demás permanecerá formulado como hipótesis, decisión provisional o pendiente.

# 15. Conclusiones, contribución, límites y próximos pasos

## 15.1 Conclusión actual

La investigación delimita una situación, no un diagnóstico general: una actividad digital puede continuar cuando una intención alternativa ya fue reconocida o valorada, pero esa misma actividad puede ser elegida, significativa, relacional o reparadora. Por eso la duración, la aplicación y la presencia del teléfono no bastan para decidir una intervención. El usuario principal y el usuario límite son patrones situacionales, no identidades demográficas.

La contribución alcanzada hasta aquí es una formulación investigable de esa tensión y una arquitectura que distribuye significado entre aplicación, testigo físico situado, lugar y persona. El desarrollo estructural permite describir la propuesta como un ciclo coherente de configuración, asociación, señal y recuperación, con tres interacciones principales, nueve marcos de síntesis y 35 estados diferenciados. Este resultado organiza lo que debe probarse; no demuestra que la experiencia sea comprensible o valiosa. La evidencia no permite afirmar que Relevo mejore recuerdo, ejecución, autonomía, bienestar, adopción o continuidad de una intención. Tampoco permite sostener todavía la condición Android/BLE, el costo, la producción ni la superioridad del objeto frente a una notificación.

## 15.2 Contribuciones actuales y aporte esperado

**Tabla 13**

*Contribuciones según estado de desarrollo*

| Tipo de aporte | Estado actual | Alcance legítimo |
| --- | --- | --- |
| Investigación | Revisión de literatura y mercado, más ocho entrevistas reales codificadas P1–P8. | Delimita episodios, variaciones y condiciones de no intervención; no estima prevalencia. |
| Formulación | Problema, preguntas, usuario principal, usuario límite, hipótesis de trabajo y cuatro dimensiones de evaluación. | Hace evaluable la relación entre intención, señal, lugar y autonomía; no la valida. |
| Arquitectura | Sistema phygital de aplicación, testigo físico situado, lugar manual y persona. | Organiza dependencias y puertas; no demuestra factibilidad integrada. |
| Desarrollo estructural | Tres interacciones, nueve marcos de síntesis y una cobertura de 35 estados. | Hace visibles recorrido, salidas y fallos; no constituye una prueba de uso. |
| Método | Ruta P0–P4 y comparación con notificación. | Define qué evidencia falta y cuándo detener una dirección. |
| Artefacto esperado | Testigo situado, señal no textual y salida autónoma, si las pruebas lo sostienen. | Aporte eventual; si falla, debe reformularse o reemplazarse la dirección física, nunca reducir Relevo a una aplicación. |

*Nota.* La tabla separa contribuciones documentadas de aportes dependientes de pruebas futuras.

## 15.3 Límites

La muestra fue reclutada por referencias y la edad fue el único criterio común confirmado; el rango observado fue de 19 a 27 años y P6 tiene 27 años. El consentimiento informado fue oral y la duración individual no quedó registrada. Como el corpus fue regularizado y anonimizado después de las conversaciones, el análisis privilegia paráfrasis. Q13 trató In(Visible), no Relevo.

No se observó sistemáticamente el hogar, sus superficies, convivientes, ruido, distancias, privacidad o desplazamiento del objeto. Tampoco se han ejecutado P0–P4 ni pruebas de accesibilidad, convivencia, privacidad doméstica, autonomía, adopción o disposición de pago. Los esquemas de interfaz estructuran recorridos posibles, pero no demuestran comprensión, preferencia, desempeño o valor.

Android, BLE, activación, enlace, batería, vencimiento, costos, producción, reparación y cumplimiento siguen siendo hipótesis, metas o pendientes según la sección correspondiente. La planificación económica de prototipo permanece en CLP 59.000–107.000 no cotizados; no constituye costo de producción ni precio. La interpretación no tuvo un segundo codificador independiente, y las referencias de mercado describen funciones y afirmaciones públicas, no eficacia de Relevo.

## 15.4 Próximos pasos por dependencia

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

Subsecretaría de Telecomunicaciones. (2026a). *Informe final: Estudio Duodécima Encuesta sobre acceso, usos y usuarios de Internet en Chile*. Ministerio de Transportes y Telecomunicaciones, Gobierno de Chile. https://www.subtel.gob.cl/wp-content/uploads/2026/02/Informe-Final-Acceso-y-Uso-Internet-2025_03.pdf

Subsecretaría de Telecomunicaciones. (2026b, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Texas Instruments. (2018). *DRV2605L: 2- to 5.2-V haptic driver for LRA and ERM with effect library and Smart-Loop architecture* [Hoja de datos]. https://www.ti.com/lit/ds/symlink/drv2605l.pdf

Tonietto, G. N., Malkoc, S. A., Reczek, R. W. y Norton, M. I. (2021). Viewing leisure as wasteful undermines enjoyment. *Journal of Experimental Social Psychology, 97*, 104198. https://doi.org/10.1016/j.jesp.2021.104198

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Waggoner, J., Lucky, S., Redick, S., Rizki, A. y Yu, J. C. (2026). Going beyond digital libraries: A literature review of phygital user experience research methods. *International Journal on Digital Libraries, 27*(1), Artículo 1. https://doi.org/10.1007/s00799-025-00436-6

WebKit. (s. f.). *Tracking prevention in WebKit*. Recuperado el 25 de agosto de 2026, de https://webkit.org/tracking-prevention/

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 24 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold

# Anexos selectivos

## Anexo A. Ficha metodológica del corpus

La matriz individual P1–P8 se presenta en la Tabla 1 del capítulo 7. Este anexo reúne las condiciones del levantamiento sin duplicar los perfiles.

**Tabla A1**

*Condiciones documentadas del estudio cualitativo*

| Campo | Registro disponible | Límite de uso |
| --- | --- | --- |
| Técnica | Entrevistas semiestructuradas, habladas y presenciales. | No constituyen observación directa ni evaluación de Relevo. |
| Fecha y lugar | Santiago, 11 y 12 de junio de 2026. | El lugar describe el levantamiento, no una población de generalización. |
| Reclutamiento | Referencias de la red personal. | Introduce sesgo de selección. |
| Criterio común | Edad; rango observado de 19 a 27 años. | La edad describe la muestra y no define por sí sola al usuario. |
| Consentimiento | Informado y oral. | No se conserva el texto exacto de la explicación entregada. |
| Registro actual | Transcripción anonimizada y regularizada después de las conversaciones. | Se utiliza para análisis temático y no como transcripción literal certificada. |
| Preguntas | Q1–Q11 y preguntas presenciales adicionales Q12–Q13, todas realizadas por el investigador. | Q13 se refirió a In(Visible), no a Relevo. |
| Unidad de análisis | Episodio y segmento pregunta–respuesta. | Los conteos descriptivos no estiman prevalencia. |

*Nota.* Las preguntas principales, las repreguntas y Q12–Q13 fueron realizadas presencialmente por el investigador. El material no permite atribuir preferencias sobre Relevo ni sobre su forma.

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

**Correcciones de la auditoría final.** Se definieron siglas y conceptos técnicos en su primera aparición; se separó la función del testigo físico de su valor asociativo todavía hipotético; se incorporó investigación de 2026 sobre reconfiguración de intervenciones; se numeró la tabla de contribuciones; y el anexo metodológico dejó de repetir la matriz individual ya presente en el capítulo 7.

**Referencias, anexos y estado de evidencia.** Se consolidó una lista única de referencias APA 7 en español y se conservaron anexos selectivos sobre metodología, jerarquía de afirmaciones y protocolo. No se añadieron respuestas, preferencias, cotizaciones, especificaciones ni resultados de prototipo inexistentes. La activación, la comparación física, Android/BLE, accesibilidad, convivencia, producción y aporte del artefacto permanecen pendientes de evaluación.

**Alineación con el historial de encargos.** Tras revisar la secuencia acumulativa de encargos, se restituyeron la identificación académica, el índice visible y la motivación personal; se hicieron localizables los títulos de planteamiento del problema, formulación, propuesta proyectual y mapa de actores; y se explicitaron los tres ámbitos del marco teórico y los siete componentes de la teoría de cambio. Antes, estos contenidos estaban ausentes o distribuidos entre capítulos sin los títulos exigidos. Se incorporaron para hacer reconocible la arquitectura académica sin eliminar la ampliación propia del Proyecto de Título. En una revisión posterior se sustituyó la definición negativa del objeto por la formulación positiva **testigo físico situado que representa una intención activa y emite un pulso ambiental**; la exclusión de una interfaz de consulta permanece solo como requisito técnico y no como propuesta de valor.

**Corrección de formulación funcional.** Se reemplazaron dos expresiones residuales que definían la interfaz objetual mediante una exclusión. Antes, el apartado de pertinencia y la tesis provisional destacaban una característica ausente; ahora describen la relación entre configuración digital, testigo situado y pulso ambiental. La arquitectura electrónica específica sigue abierta y este cambio no agrega resultados de validación.

**25 de agosto de 2026 — Especialización derivada del estado del arte.** Se articuló explícitamente la cadena entre familias de respuesta existentes, límites observados, oportunidad y propuesta proyectual. Antes, medición, bloqueo, interrupción, separación y recuperación situada aparecían distribuidos entre los capítulos 7, 8 y 9; ahora fundamentan una especialización provisional única: recuperar una intención propia en el lugar donde puede comenzar. Se añadió la fuente primaria de kSafe para respaldar la familia de separación física y se distinguió pertinencia situacional de condición técnica. El cambio no atribuye eficacia a Relevo ni afirma novedad universal.

**25 de agosto de 2026 — Alcance Android.** Se añadió una comparación explícita entre Android, web e iPhone y se cerró Android como única plataforma del prototipo técnico integrado. Antes, Android figuraba como una ruta provisional sin justificación comparativa; ahora se fundamenta por capacidades nativas y concentración de recursos. Web se descarta como capa operativa e iPhone queda fuera del alcance inicial, sin declararlos inviables para expansiones futuras. Se añadieron las fuentes oficiales correspondientes; la condición de activación y el desempeño permanecen pendientes.

**Archivos afectados.** Las intervenciones del 25 de agosto modifican `08_memoria/memoria-vigente-v2.md`, sincronizan `08_memoria/resumen-vigente-proyecto.md` y actualizan la documentación asociada en `06_desarrollo_y_factibilidad` y `09_decisiones`.

**25 de agosto de 2026 — Cierre editorial e incorporación del desarrollo estructural.** Se actualizó el estado del proyecto y se incorporaron como resultados de diseño las tres interacciones principales, los nueve marcos de síntesis y la cobertura de 35 estados. Antes, la memoria describía flujos y estados mínimos, pero no registraba el desarrollo exhaustivo realizado posteriormente ni distinguía sus soportes. Se añadieron los apartados 9.6 y 11.9, la Tabla D1, una fila de contribución estructural y límites explícitos sobre el valor probatorio de los wireframes. También se reemplazó en la ficha la formulación negativa de la tesis por su definición funcional mediante pulso ambiental y testigo situado. El documento queda cerrado editorialmente para el estado real del proyecto; no se agregaron resultados de prototipo, preferencias, factibilidad o eficacia inexistentes.

**25 de agosto de 2026 — Corrección APA de obras sin fecha de Google.** Se reordenaron alfabéticamente `Manage how you spend time...` y `UsageStatsManager`, y se actualizaron sus sufijos de `s. f.-c/d` en el cuerpo. Antes, los sufijos seguían el orden de incorporación de las fuentes y no el orden alfabético de títulos requerido para obras del mismo autor sin fecha. El cambio es exclusivamente bibliográfico y no modifica la argumentación técnica ni proyectual.

**25 de agosto de 2026 — Revisión de fluidez y preparación del entregable DOCX.** Se revisó el ritmo de los apartados más densos y se sustituyeron secuencias entrecortadas por relaciones explícitas entre ideas. En particular, un encabezado técnico anterior pasó a denominarse “Función en el proyecto”; la descripción abreviada de P0–P4 se convirtió en un recorrido argumentado; y los flujos técnico, sistémico y de evaluación dejaron de repetir el mismo sujeto al comienzo de cada oración. Antes, estas secciones funcionaban como inventarios comprimidos y resultaban pesadas de leer. La revisión conserva conceptos, cifras, citas, estados de evidencia y decisiones de alcance; no añade resultados ni modifica la propuesta. La organización general se contrastó con una memoria académica de referencia únicamente para revisar continuidad y legibilidad, sin trasladar su contenido ni utilizarla como fuente.

**26 de agosto de 2026 — Versión v3 y reestructuración narrativa.** Se creó `08_memoria/memoria-vigente-v3.md` y se preservó la v2 como antecedente. Antes, la formulación completa aparecía en el capítulo 3 y antecedía al marco teórico, los usuarios, el estado del arte y los criterios; ahora el capítulo 3 construye el problema mediante tres aristas explícitas, mientras la formulación se presenta en el capítulo 10 como resultado de la investigación. La justificación, los antecedentes y los tres ámbitos teóricos recuperaron capítulos propios conforme al orden del cierre del primer semestre y a los requisitos institucionales. La ficha inicial se retiró porque duplicaba el resumen y adelantaba decisiones que la narración todavía no había fundamentado.

**26 de agosto de 2026 — Conceptos, método y consistencia académica.** Se adoptó únicamente `desplazamiento infinito` para el patrón de interfaz y se explicaron los conceptos especializados en su primera aparición. Las menciones al tratamiento técnico de la transcripción se retiraron del cuerpo y del anexo; el registro conserva que las entrevistas, preguntas y repreguntas fueron presenciales y realizadas por el investigador. La hipótesis de trabajo se mantuvo como una sola proposición y las cuatro hipótesis secundarias de la versión anterior se reemplazaron por dimensiones de evaluación E1–E4. Se añadieron Tonietto et al. (2021) y la encuesta nacional de acceso y uso de internet publicada por SUBTEL en 2026; también se corrigieron sus referencias cruzadas. Como cierre editorial, se variaron los comienzos repetidos de ocho párrafos del resumen, el abstract, el estado del arte, el desarrollo y la factibilidad. Antes, esas secuencias reiteraban un mismo artículo o sujeto y producían un ritmo mecánico; ahora enlazan las relaciones mediante transiciones sin alterar su contenido. No se agregaron datos de entrevistas, preferencias ni resultados de prototipo inexistentes.
