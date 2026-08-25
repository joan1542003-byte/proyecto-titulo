---
id: MEM-V2-02
titulo: "Método y estudio de usuarios"
proyecto: "Relevo"
tipo: "Memoria de Proyecto de Título — Diseño"
estado: "borrador académico listo para integración"
fecha: 2026-08-24
alcance: "capítulos 4 y 6; no incluye capítulo 5"
---

# 4. Diseño metodológico y plan de trabajo

## 4.1 Propósito y alcance

Este capítulo documenta el estudio de usuarios que orienta Relevo y el plan mediante el cual sus hallazgos se traducirán en decisiones de diseño. La etapa realizada buscó comprender situaciones de ocio digital en que una intención alternativa pierde disponibilidad y distinguirlas de usos elegidos, significativos o coherentes con la intención actual. No buscó estimar frecuencia, representar una población ni probar Relevo.

La investigación es un **estudio cualitativo exploratorio mediante entrevistas semiestructuradas**. Es cualitativo porque atiende a secuencias narradas, significados, tensiones y excepciones; y semiestructurado porque mantuvo preguntas comunes, permitiendo aclaraciones y profundización. Esta denominación describe con precisión ocho entrevistas presenciales y habladas, en lugar de reducirlas a una «consulta exploratoria».

El estudio pertenece a un Proyecto de Título de Diseño **phygital**: una aplicación digital y un objeto físico sin pantalla se articulan para una misma situación de uso. La investigación no demuestra la eficacia de esa articulación; establece qué problema podría justificarla, cuándo no debería intervenir y qué preguntas deben resolverse antes de cerrar la propuesta.

Se distinguen tres estados: **realizado**, que incluye la revisión documental, las entrevistas y el análisis inicial; **interpretado**, que reúne patrones y necesidades inferidas; y **propuesto**, que comprende tipos situacionales, escenarios y pruebas futuras. La evaluación de prototipo, la comparación con una notificación, la integración Android–Bluetooth Low Energy y el piloto doméstico no se presentan como resultados.

## 4.2 Muestra, reclutamiento y condiciones del levantamiento

Participaron ocho personas, identificadas como P1–P8. Las entrevistas fueron presenciales en Santiago los días 11 y 12 de junio de 2026. Santiago es el contexto del levantamiento, no la población de generalización. La edad describe la muestra: el rango observado fue de 19 a 27 años y P6 tiene 27 años. No se generaliza a todas las personas de ese rango ni se convierte la edad en explicación causal.

El reclutamiento se realizó por referencias de la red personal. El único criterio común confirmado fue la edad; no se documentó otro que permita tratar la muestra como segmento de mercado. No corresponde asumir que las personas son estudiantes, comparten vivienda o tienen la misma ocupación. El procedimiento permite una exploración inicial, pero introduce sesgo de selección y no permite estimar prevalencia.

La aplicación fue hablada y presencial. Todas las preguntas y repreguntas fueron realizadas por el investigador. Se registró consentimiento informado oral; no se conserva el texto exacto de la información entregada. La anonimización corresponde al tratamiento actual del corpus. Tampoco se dispone de duración individual, no hay audio disponible en el corpus documentado y no se conservan las notas manuscritas originales, por lo que se privilegian paráfrasis analíticas.

Q1–Q11 corresponden a la secuencia inicial. Q12 y Q13 fueron preguntas suplementarias presenciales posteriores: Q12 trató estrategias para descansar sin el teléfono y Q13 recogió una reacción condicional sobre el tono y la discreción de una posible intervención ante el concepto histórico de In(Visible), no una evaluación de Relevo. Q13 no permite inferir aceptación; tampoco valida la forma, señal, ubicación, eficacia o valor comparativo del sistema.

## 4.3 Procesamiento posterior y corpus de análisis

Después del trabajo de campo, el habla fue transcrita y regularizada en ortografía y redacción académica con apoyo de una herramienta automatizada. La asistencia fue posterior y no produjo preguntas, repreguntas ni respuestas. El corpus es una transcripción anonimizada y formalizada, no una reproducción literal; por ello se privilegian paráfrasis trazables.

La unidad principal es el **episodio**, entendido como una situación de ocio digital narrada en relación con actividad, intención, experiencia temporal, valoración o estrategia. La persona es el caso que reúne episodios, no un perfil fijo: puede aportar un episodio pertinente para intervenir y otro que exige no intervenir. La unidad secundaria es el segmento pregunta–respuesta, identificado como P/Q.

El corpus se organizó por contexto, continuidad digital, intención, percepción temporal, descripción, recuerdo, valoración, tensión, estrategia y reacción ante una señal. Cada fragmento se clasificó como evidencia, interpretación, hipótesis, decisión provisional o pendiente. Así, una necesidad inferida no se presenta como frase de una persona ni una propuesta del diseñador como preferencia de la muestra.

Q8 requiere una acotación específica. La pregunta indagó si la persona había vivido sesiones difíciles de describir posteriormente. En el corpus se registran seis respuestas afirmativas, una parcial y una negativa (P1–P8, Q8; [matriz de evidencia P1–P8](../../03_usuarios/matriz-evidencia-p1-p8.md)). El conteo describe la distribución de respuestas a una pregunta de recuerdo narrativo; no es una medida de prevalencia, de pérdida de control, de intención desplazada ni de la sesión reciente de cada participante. P8 muestra que una experiencia difícil de narrar puede coexistir con una valoración del tiempo como descanso (P8, Q7–Q10), mientras P7 niega experimentar lagunas en el episodio relatado y no identifica una necesidad de corrección (P7, Q7–Q11). Por eso Q8 funciona como indicio descriptivo y no como criterio suficiente para clasificar usuarios.

## 4.4 Procedimiento de análisis

El análisis siguió una secuencia de análisis Framework, entendido como una matriz que ordena sistemáticamente casos y categorías, seguida de una comparación de tipos ideales. La decisión metodológica está documentada en [Método de análisis](../../03_usuarios/metodo-de-analisis.md) y se relaciona con el procedimiento descrito por Goldsmith (2021) y con la construcción de tipos ideales revisables propuesta por Stapley et al. (2022). El procedimiento tuvo cinco movimientos:

1. **Familiarización y matriz.** Se revisó P1–P8 y Q1–Q13, y se ordenaron los fragmentos por contexto, actividad, intención, continuidad, temporalidad, recuerdo, cierre, estrategia y reacción.
2. **Reconstrucción de casos.** Cada entrevista se sintetizó por separado, distinguiendo evidencia, interpretación, tensión, confianza y límite.
3. **Comparación transversal.** Se buscaron convergencias, variaciones internas y casos negativos. P4 y P6 muestran que una misma persona puede cambiar de patrón según la actividad (P4, Q3–Q8; P6, Q3–Q10).
4. **Tipos situacionales.** Se construyeron patrones episódicos, no identidades demográficas, y se eligió usuario principal más usuario límite para definir pertinencia y no intervención.
5. **Traducción a diseño.** Necesidades, tensiones, deseos, estrategias y puntos de dolor se transformaron en requisitos provisionales. Ninguna traducción equivale a validar el prototipo.

La interpretación fue realizada por el investigador y no se documentó una codificación independiente de un segundo analista. Para compensar parcialmente ese límite se conservaron el libro de códigos, las reconstrucciones de caso, la matriz comparativa y la trazabilidad P/Q. Las afirmaciones fuertes se restringen a los casos donde la secuencia está documentada; cuando un episodio es ambiguo, se presenta como indicio o se mantiene fuera de la clasificación central.

## 4.5 Reflexividad y límites

El investigador fue entrevistador, diseñador e intérprete. Como el problema ya se orientaba a continuidad digital, intención y autonomía, las preguntas pudieron hacer visibles ciertos episodios más que otros. Q13, además, puso en circulación un concepto externo al sistema actual; sus respuestas pueden reflejar la presentación de In(Visible), no una evaluación neutral de Relevo. El corpus debe leerse como una construcción situada, no como observación directa.

No se observaron sistemáticamente hogares, superficies, convivientes, distancias, ruido, movimientos del objeto ni privacidad. El hogar es una hipótesis de alcance. La muestra por referencias, el tamaño reducido, la ausencia de audio disponible en el corpus documentado y de notas originales, la duración no registrada y la transcripción posterior impiden inferir prevalencia, causalidad, cambio de conducta, eficacia, accesibilidad, adopción, disposición de pago o superioridad frente a una notificación.

Estos límites definen el aporte exploratorio: precisar la pregunta, reconocer contraejemplos y evitar activar el objeto ante cualquier uso prolongado. La próxima fase requerirá consentimiento específico y un protocolo que separe percepción, atribución, recuerdo, reconsideración, decisión, carga e incidentes técnicos.

## 4.6 Plan de trabajo y puertas de decisión

El plan se organiza de manera secuencial para que cada etapa produzca una decisión antes de abrir la siguiente. La prioridad metodológica es cerrar la asociación entre intención, primer paso, lugar y señal antes de abrir decisiones de forma, producción o evaluación integrada.

| Etapa | Estado | Producto y decisión |
| --- | --- | --- |
| Delimitación del problema y revisión de literatura y referentes | Realizada y en actualización | Definir la diferencia entre continuidad digital, intención desplazada y ocio elegido; registrar límites de cada fuente. |
| Levantamiento de usuarios | Realizado | Corpus anonimizado P1–P8, consentimiento oral informado y registro de condiciones del estudio. |
| Análisis, tipología y escritura | Realizado como base; en integración | Mantener usuario principal y usuario límite como patrones episódicos; corregir afirmaciones que excedan la evidencia. |
| Asociación física sin pantalla | Planificada | Probar primero si una persona puede vincular intención, primer paso, lugar y señal con activación simulada. |
| Modalidad, comparación con notificación e integración técnica | Pendiente | Solo avanzar si la asociación tiene sentido y el objeto aporta algo específico frente al teléfono. |
| Factibilidad, producción y evaluación contextual | Pendiente | Definir regla de activación, permisos, costos, mantenimiento y criterios de descarte antes de cerrar el producto. |

La primera puerta sustantiva es la asociación física sin pantalla. Si la persona debe consultar reiteradamente la aplicación para entender la señal, o si el lugar no aporta una clave distinguible de una notificación, la dirección debe modificarse. La condición de activación Android y los detalles de producción no deben presentarse como resueltos antes de esa decisión.

# 6. Estudio de usuarios y contextos de uso

## 6.1 Alcance de los hallazgos

El estudio no produce segmentos de mercado ni biografías. Produce una lectura situada de ocho casos y de los episodios que cada uno relató. La diferencia analíticamente más útil no es entre personas que «usan mucho» o «usan poco» el teléfono, sino entre situaciones en que una intención alternativa pierde disponibilidad y situaciones en que la actividad digital conserva significado, propósito o coherencia. Esta distinción permite formular un usuario principal y un usuario límite sin atribuir a ninguna persona una identidad estable.

## 6.2 Hallazgos transversales

El corpus muestra que el teléfono aloja actividades heterogéneas: P1 distinguió manga y TikTok; P4, sudoku y TikTok; P6, una videollamada relacional y otros usos rutinarios; y P7, un podcast elegido mientras comía (P1, Q3–Q8; P4, Q3–Q8; P6, Q3–Q10; P7, Q3–Q11). El dispositivo y la duración no determinan por sí solos la pertinencia de intervenir.

P2 y P3 son los casos centrales. P2 abrió Instagram para ver memes al acostarse, reconoció el sueño y continuó mirando el teléfono. Recordó claramente la sesión, pero evaluó su cierre como incompleto (P2, Q3–Q7). P3 describió videos humorísticos en Instagram como una forma de matar el tiempo, declaró pérdida de noción temporal y reconoció alternativas que consideraba mejores; a la vez, admitió que la sesión podía funcionar como descanso frente a responsabilidades (P3, Q3–Q11). En ambos casos el conflicto no se reduce a olvidar: una alternativa aparece o es valorada, pero la continuidad digital conserva la decisión inmediata.

P5 es adyacente. Mientras veía TikTok describió entretenimiento inmediato y aburrimiento al terminar, con poca actividad recuperable; también señaló estrategias que no siempre evitan volver al teléfono (P5, Q3–Q12). Como en el episodio no aparece con igual precisión una intención alternativa activa, orienta el problema de las estrategias frágiles sin equivaler a P2 o P3.

P6 y P7 son límites críticos. P6 recordó una videollamada significativa, con contexto y emociones, y quiso repetirla; P7 recordó un podcast de fútbol, negó lagunas en el episodio y no identificó obligaciones que exigieran corregirlo (P6, Q3–Q7; P7, Q3–Q11). Intervenir allí solo por duración, aplicación o presencia del teléfono contradice el proyecto. P1, P4 y P8 mantienen la variación episódica: una persona puede diferenciar actividades dirigidas, feed rutinario y descanso aceptado (P1, Q3–Q13; P4, Q3–Q13; P8, Q3–Q13).

Q12 reúne estrategias autodeclaradas como alejar, cargar en otro lugar, silenciar o activar «no molestar» (P1–P8, Q12). No fueron observadas ni comparadas y no prueban que un objeto sea mejor. Q13, referido a In(Visible), permite formular condicionalmente una orientación hacia un tono tranquilo, discreto y no punitivo, y hacia evitar notas o comparaciones (P1–P8, Q13; [reconstrucciones de caso](../../03_usuarios/reconstrucciones-de-caso.md)). No constituye una preferencia validada sobre Relevo; si se prueba el sistema, la señal debe poder ignorarse o silenciarse y no registrar cumplimiento.

## 6.3 Usuario principal y usuario límite como patrones situacionales

### Usuario principal: continuidad digital con intención desplazada

El usuario principal es un episodio con tres condiciones: una actividad digital que continúa sin decisión renovada; una intención alternativa reconocida o valorada; y una tensión entre ambas. P2 y P3 documentan, respectivamente, continuidad después de reconocer el sueño y coexistencia entre videos, pérdida temporal y alternativas consideradas mejores (P2, Q3–Q7; P3, Q3–Q11). P5 es adyacente porque muestra continuidad y cierre vacío sin una intención alternativa igualmente explícita (P5, Q3–Q10).

Las **necesidades inferidas** son mantener disponible una alternativa sin imponerla, recuperar un primer paso y decidir sin volver necesariamente al mismo flujo. Se fundan en P2, P3 y P5, pero no significan que hayan pedido literalmente Relevo (P2, Q4, Q10–Q12; P3, Q5, Q9–Q12; P5, Q9–Q12). La tensión es que descanso y obligación coexisten: P2 no consideró plenamente reparadora la sesión, mientras P3 reconoció descanso y autocrítica (P2, Q5–Q7; P3, Q5–Q11). Sus deseos declarados incluyen dormir, hacer hobbies, aprender o ejercitarse, sin convertir todo ocio en productividad (P2, Q9–Q10; P3, Q9–Q11).

Los puntos de dolor son continuar tras reconocer una intención, recuperar poco de la sesión y volver al teléfono después de apartarlo (P2, Q4, Q12; P3, Q4, Q8, Q12; P5, Q6, Q8, Q12). La respuesta de diseño es una clave externa de baja carga, asociada por la persona con intención y primer paso; sigue siendo una hipótesis que debe probarse sin consulta obligada a la aplicación.

### Usuario límite: ocio digital elegido y coherente

El usuario límite es un episodio en que la actividad digital es elegida, significativa, dirigida, relacional o compatible con la intención actual, sin alternativa que requiera apoyo. P6 y P7 lo sostienen mediante una videollamada y un podcast recordados y valorados como ocio legítimo; P4 aporta el sudoku y P8 una sesión de Instagram aceptada como descanso (P6, Q3–Q7; P7, Q3–Q11; P4, Q3–Q7; P8, Q7–Q10).

La necesidad de diseño aquí es conservar autonomía, discreción y control sobre la pertinencia de una ayuda. Si el sistema interviniera por aplicación, tiempo o patrón de uso, podría interrumpir el episodio elegido. En estas respuestas aparecen, de manera condicional, orientaciones hacia la discreción y la ausencia de notas, comparaciones o medidas externas (P6, Q9–Q13; P7, Q9–Q13; P8, Q9–Q13); no se las interpreta como aceptación de Relevo. Por ello, sin intención alternativa declarada, con propósito o vínculo reconocible, o cuando la persona considera coherente su descanso, Relevo debe permanecer inactivo o no resultar pertinente. P6 demuestra que una persona puede cambiar de patrón según la actividad (P6, Q8–Q13).

## 6.4 Necesidades, tensiones, deseos, estrategias y criterios de no intervención

| Dimensión | Usuario principal: patrón de intención desplazada | Usuario límite: patrón de ocio elegido | Estado de la afirmación |
| --- | --- | --- | --- |
| Necesidad | Mantener disponible una alternativa y su primer paso sin imponer su ejecución (P2, Q4, Q10–Q12; P3, Q5, Q9–Q12). | Preservar la posibilidad de descansar, conversar o concentrarse sin una corrección externa (P6, Q3–Q10; P7, Q3–Q11). | Inferencia de diseño fundada en episodios. |
| Tensión | La continuidad puede persistir después de reconocer sueño, obligaciones o alternativas valoradas (P2, Q4–Q7; P3, Q4–Q11). | Una señal podría interrumpir una actividad significativa o convertir el ocio en una falta (P6, Q3–Q7; P7, Q9–Q13). | Evidencia e interpretación separadas. |
| Deseo | Hacer actividades que se sientan reparadoras, plenas o valiosas, sin que el sistema las transforme en productividad obligatoria (P2, Q9–Q10; P3, Q9–Q11; P5, Q9–Q10). | Condición de diseño inferida: preservar autonomía y discreción y evitar notas o comparaciones (P6, Q9–Q13; P7, Q9–Q13; P8, Q9–Q13). | Orientación condicional; no validación de producto. |
| Estrategias | Alejar, silenciar, cargar en otro lugar o activar «no molestar», con retorno variable al teléfono (P2, Q12; P3, Q12; P5, Q12). | Apartar el teléfono según contexto; no usar una ayuda diariamente cuando no se percibe necesidad (P6, Q12; P7, Q12). | Autorreporte no observado. |
| Punto de dolor | Continuidad difícil de cerrar, tiempo poco recuperable o retorno al dispositivo (P2, Q4, Q12; P3, Q4, Q8, Q12; P5, Q6, Q12). | El riesgo no es un dolor declarado, sino la intrusión de una intervención mal dirigida (P6, Q3–Q7; P7, Q3–Q11). | El segundo caso es una condición de diseño. |
| No intervención | No activar sin intención alternativa explícita y primer paso que la persona quiera mantener disponible. | No activar ante uso elegido, significativo, dirigido o valorado, aunque sea prolongado (P4, Q3–Q7; P6, Q3–Q7; P7, Q3–Q11; P8, Q7–Q10). | Requisito provisional derivado del contraste. |

## 6.5 Recorridos actuales documentados

El recorrido actual representa etapas de episodios efectivamente narrados; no es una biografía ni una rutina general. En el patrón principal, P2 y P3 permiten reconstruir la siguiente secuencia sin afirmar que sus historias sean idénticas:

1. **Inicio elegido o tolerado.** La sesión comienza como descanso o entretenimiento en Instagram: P2 abre memes al acostarse y P3 ve videos humorísticos (P2, Q3–Q4; P3, Q3–Q4).
2. **Continuidad del contenido.** La actividad mantiene la atención y continúa más allá del primer momento de uso (P2, Q4; P3, Q4).
3. **Aparición de una alternativa o tensión.** En P2 aparece el sueño y la persona reconoce que debería dormir; en P3 coexisten la pérdida temporal y la idea de que había mejores cosas por hacer (P2, Q4, Q7; P3, Q4–Q5, Q9–Q11).
4. **Decisión inmediata.** La sesión continúa en P2 pese al sueño; en P3 el cierre se acompaña de una valoración ambivalente, porque la actividad funcionó como pausa y, a la vez, fue objeto de autocrítica (P2, Q4–Q7; P3, Q5–Q7, Q11).
5. **Reconstrucción posterior.** P2 recuerda con claridad la secuencia; P3 declara dificultad para describir este tipo de consumo y pérdida de noción temporal (P2, Q5–Q7; P3, Q4, Q8).
6. **Estrategia de separación.** Ambos han intentado alejar o silenciar el teléfono; P3 señala que la cercanía favorece volver a tomarlo y P2 menciona separarlo de la cama (P2, Q12; P3, Q12). Estas estrategias informan el contexto de intervención, pero no prueban la necesidad ni la eficacia de un objeto.

El recorrido límite sigue otra lógica. P6 participa en una videollamada con contenido y vínculo reconocibles, recuerda la experiencia y desea repetirla; P7 escucha un podcast de fútbol mientras come, lo recuerda y no identifica una obligación que vuelva problemática la sesión (P6, Q3–Q7; P7, Q3–Q11). P8 agrega una variación: puede narrar con dificultad una rutina de Instagram, pero la acepta como descanso cuando está al día con sus tareas (P8, Q7–Q10). En estos casos el recorrido termina en una valoración coherente, no en una intención alternativa desplazada. Por ello no corresponde insertar una señal solo porque el teléfono estuvo presente.

## 6.6 Escenario futuro hipotético de uso

El siguiente escenario no fue observado, no reproduce ninguna entrevista y no constituye validación. Es una hipótesis de uso derivada del contraste entre P2–P3 y P6–P8. Una persona identifica una actividad alternativa que quiere mantener disponible y formula un primer paso concreto. En una aplicación Android registra esa intención, selecciona una condición de uso aún pendiente de definición y vincula un testigo físico sin pantalla. Luego sitúa el testigo junto al primer paso, no porque el sistema detecte el lugar, sino porque la persona crea manualmente esa asociación.

Durante una sesión digital elegida, la aplicación intentaría reconocer únicamente la condición técnica que se defina para el prototipo; no interpretaría automatismo, emoción, cumplimiento ni valor del ocio. Si la condición se cumple y el enlace funciona, el testigo emitiría una señal no textual y acotada. La persona podría reconstruir la asociación, retomar la actividad alternativa, continuar con el teléfono, ignorar o silenciar la señal. Ninguna de esas decisiones sería puntuada ni registrada como éxito o fracaso.

El escenario solo tiene sentido si incluye sus límites: no debe activarse ante una videollamada significativa como la de P6, ante un episodio dirigido como el de P7 o ante un descanso que la persona considera coherente como el de P8 (P6, Q3–Q7; P7, Q3–Q11; P8, Q7–Q10). Antes de automatizar Android, la primera prueba debe estudiar con activación simulada si la asociación entre intención, primer paso, testigo y lugar se recupera sin texto y sin consulta obligada al teléfono. El resultado podría mantener, modificar o abandonar la dirección del objeto; no está autorizado a asumirse de antemano.

## 6.7 Implicaciones para Relevo

El estudio justifica investigar una intervención selectiva, no un control general del tiempo de pantalla. La propuesta debe exigir una intención autoelegida y un primer paso concreto; permitir ignorar o silenciar; excluir bloqueo, puntuación, comparación y registro de cumplimiento; y tratar el lugar como una asociación manual, no como una ubicación detectada. El objeto sin pantalla permanece como hipótesis: solo tendrá sentido si entrega una clave situada que una notificación no ofrece y si no obliga a volver a leer el teléfono.

La evidencia actual permite formular y acotar el problema y sus condiciones de no intervención, pero no permite cerrar la forma, la señal, la condición Android, la factibilidad económica ni la adopción. El próximo avance sustantivo debe ser una prueba acotada de asociación, con criterios de recuerdo de intención y primer paso, consulta, autonomía percibida, intrusión y fallos. La decisión de continuar con el sistema phygital deberá depender de ese aporte específico y no de la sola exigencia formal de incorporar un objeto físico.

---

## Registro de cambios (disclaimer)

### 2026-08-24 — Creación de `02-metodo-usuarios.md`

- **Cambio realizado:** se creó este archivo como segunda fase de redacción de la memoria. Integra exclusivamente el capítulo 4, «Diseño metodológico y plan de trabajo», y el capítulo 6, «Estudio de usuarios y contextos de uso». El capítulo 5 no fue redactado.
- **Versión anterior:** no existía un borrador `02-metodo-usuarios.md` en `08_memoria/borradores-v2`; la metodología y los hallazgos se encontraban distribuidos entre `memoria-vigente.md`, los documentos de `03_usuarios`, el dictamen de reconstrucción y las auditorías internas.
- **Criterio de reorganización:** se reemplazó la denominación «consulta exploratoria» por «estudio cualitativo exploratorio mediante entrevistas semiestructuradas»; se separaron hechos, interpretaciones, hipótesis, decisiones provisionales y pendientes; y se ordenó el método antes de los hallazgos.
- **Correcciones factuales incorporadas:** se registraron ocho entrevistas reales, presenciales y habladas, realizadas en Santiago los días 11 y 12 de junio de 2026; reclutamiento por referencias; edad como único criterio común confirmado; rango observado de 19 a 27 años; P6 con 27 años; consentimiento informado oral sin texto exacto de la información entregada disponible; preguntas y repreguntas realizadas por el investigador; y ausencia de duración individual, audio disponible en el corpus documentado y notas manuscritas disponibles.
- **Procesamiento posterior:** se dejó una mención breve y transparente a la transcripción y regularización académica con apoyo automatizado posterior. Se estableció que esa herramienta no participó en la conversación ni produjo preguntas, repreguntas o respuestas. El texto evita atribuir el contenido del levantamiento a esa asistencia y privilegia paráfrasis por sobre citas literales.
- **Q8:** se mantuvo el resultado descriptivo de seis respuestas afirmativas, una parcial y una negativa, pero se eliminó cualquier lectura como prevalencia, automatismo, intención desplazada o validación de la propuesta.
- **Q13 — corrección de alcance:** **Antes:** se formulaba como hipótesis sobre modalidad, discreción y aceptación, y se describía en algunos pasajes con lenguaje de rechazo o preferencia. **Después:** se presenta como reacción condicional ante In(Visible), limitada a orientar el tono, la discreción, la ausencia de castigo y la posibilidad de silenciar; no permite inferir aceptación ni valida Relevo. **Motivo:** Q13 no evaluó el sistema actual, por lo que sus respuestas no pueden tratarse como preferencia validada ni como evidencia de aceptación del objeto.
- **Tipología:** se consolidó la elección de usuario principal más usuario límite. P2 y P3 sustentan el patrón principal; P5 se presenta como caso adyacente; P6 y P7 funcionan como límites de no intervención; P1, P4 y P8 mantienen la variación episódica y evitan perfiles fijos.
- **Recorridos:** se incorporaron recorridos actuales por etapas construidos solo con episodios documentados. El recorrido futuro se rotuló como hipótesis no observada y se dejó pendiente la condición operacional de activación.
- **Límites preservados:** el archivo no afirma prevalencia, causalidad, eficacia, accesibilidad, adopción, disposición de pago, superioridad frente a notificaciones, validación técnica ni observación sistemática del hogar. Santiago se conserva como contexto del levantamiento y la edad como descripción de la muestra, no como población objetivo.
- **Archivos no modificados:** no se modificaron `08_memoria/memoria-vigente.md`, `08_memoria/dictamen-rector-reconstruccion-memoria.md`, `08_memoria/borradores-v2/01-apertura-formulacion.md`, ningún archivo de `03_usuarios` ni otros archivos del repositorio. No se realizó commit ni push.
- **Pendiente de integración:** reconciliar las citas metodológicas de Goldsmith (2021) y Stapley et al. (2022) con la bibliografía general de la memoria, revisar la numeración al maquetar y comprobar que las referencias internas se mantengan válidas en la versión final.
