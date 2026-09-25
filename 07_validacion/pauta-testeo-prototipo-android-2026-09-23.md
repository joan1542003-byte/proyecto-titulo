# Relevo — pauta de evaluación formativa del prototipo Android 2.6

**Sesión de revisión docente:** 23 de septiembre de 2026. **Estado:** instrumento para revisión y ajuste; no contiene resultados ni autoriza por sí solo el reclutamiento. **Versión descrita:** APK Android 2.6 (actualizada el 25 de septiembre de 2026), junto con el teléfono y el parlante Bluetooth concretos que se declaren antes de cada sesión.

## Propósito y alcance

Esta pauta permite observar si una persona entiende y puede preparar un relevo, si la configuración se siente pertinente para una actividad que eligió, qué carga implica, qué control conserva y cómo interpreta el aviso. Separa la experiencia de uso de las fallas técnicas y de los datos que registra la aplicación.

La evaluación no determina si la persona tiene un problema de uso digital, si debe dejar una aplicación ni si realizó efectivamente la actividad. La respuesta final de la app recoge lo que declara la persona; no verifica lo que hizo. Recordar una intención, comenzar una actividad, repetirla y formar un hábito son resultados distintos. La prueba tampoco compara todavía el lugar con una notificación ni evalúa la forma final del producto phygital.

## Prototipo y límites que se deben explicar

La versión 2.6 permite registrar una actividad y una manera concreta de comenzar, elegir **una o varias aplicaciones** cuyo tiempo en primer plano se suma hasta un único umbral de 1 minuto a 6 horas, indicar una ubicación, elegir la salida del sonido, probarla, revisar la configuración y activar el ciclo. La preparación está dividida en cuatro etapas; la creación de una actividad propia, en tres. Antes del tutorial, la app pide aceptar el uso académico de los datos. Durante el monitoreo muestra una notificación persistente y pausa el conteo cuando la persona sale de las aplicaciones elegidas, para retomarlo al volver. El mínimo documentado es Android 12 (API 31). La compilación y diez pruebas unitarias pasaron, y en emulador se revisaron consentimiento, tutorial, Inicio y preparación con dos aplicaciones; el recorrido completo en un teléfono real, la reproducción en un parlante real, el envío de eventos y la eliminación de datos siguen pendientes. Véanse el [APK 2.6](../06_desarrollo_y_factibilidad/app-android/releases/relevo-android-2.6-2026-09-24.apk) y el [estado técnico de la versión](../06_desarrollo_y_factibilidad/app-android/README.md).

La persona elige expresamente si el tono suena en un **parlante Bluetooth multimedia** o en el **altavoz del teléfono**, y puede probarlo antes de activar. Con el parlante, el código solicita dirigir **el tono de Relevo** a esa salida y comprueba la ruta que informa Android; si la salida elegida no está disponible, informa el fallo y no cambia de salida sin avisar. El tono continúa mientras el ciclo esté en estado de señal, también con la app fuera de pantalla, y se detiene al silenciar o cerrar. Todo esto debe comprobarse con los dispositivos concretos. Un parlante multimedia corriente puede convertirse en la salida de audio general del teléfono: la app no impide que YouTube, Instagram u otras aplicaciones suenen también por él. Android no garantiza que la ruta preferida sea la ruta efectiva. La función Samsung *Separate app sound* depende del modelo y no puede suponerse en otros teléfonos. Véase el [análisis de enrutamiento](../06_desarrollo_y_factibilidad/enrutamiento-audio-parlante-exclusivo-2026-09-23.md).

Por lo tanto, no presentar como comprobadas la exclusividad del parlante, la conexión persistente, la percepción del sonido fuera de la app ni la ausencia de interferencias. El prototipo Android 2.6 no aporta una luz física; no evaluar ni prometer esa salida en esta sesión. Si una sesión usa el altavoz del teléfono, registrarla como variante sin objeto situado: sirve para revisar preparación y control, pero no para evaluar el aporte del lugar.

## Pregunta de evaluación

¿Cómo comprende y experimenta una persona la preparación y recepción de un relevo asociado a una actividad elegida, y qué relación observa entre la aplicación, el tiempo configurado, el lugar y la señal sonora?

La pregunta se divide en cuatro focos:

1. **Pertinencia:** ¿la actividad y la forma de comenzar tienen sentido para la persona y su situación cotidiana?
2. **Comprensión:** ¿puede explicar qué observa Relevo, cuándo espera el aviso y qué significa la ubicación elegida?
3. **Carga:** ¿qué esfuerzo, tiempo, dudas o pasos de vuelta requiere preparar y usar el sistema?
4. **Control:** ¿puede revisar sus decisiones, detener o silenciar el aviso y decidir qué hacer sin sentirse obligada?

## Criterio metodológico

La pauta parte de tareas y contextos de uso definidos y registra qué ocurre para orientar cambios de diseño, de acuerdo con el diseño centrado en las personas (Organización Internacional de Normalización [ISO], 2019). La observación considera logro de tareas, dificultades y percepción de facilidad en el contexto especificado; no reduce la usabilidad a una impresión estética (ISO, 2018). Las instrucciones describen metas cotidianas, sin indicar qué control tocar, para reducir la inducción de respuestas (Nielsen Norman Group, 2014, 2019). Una escala breve de facilidad se interpreta junto con las observaciones y comentarios, no como evidencia estadística de una muestra pequeña (Sauro, 2010).

## Participantes y condiciones de aplicación

- **Muestra formativa propuesta:** cinco o seis personas adultas, dentro del rango de 18 a 30 años usado en el reclutamiento previo, que utilicen ocio digital y puedan escoger una actividad propia. Es una muestra exploratoria por conveniencia; no es representativa. Amistades pueden participar si la invitación deja claro que aceptar, rechazar o retirarse no afecta su relación, estudios ni trabajo. Registrar el vínculo y considerarlo al interpretar las respuestas.
- **Contexto:** un espacio donde la persona pueda decidir si el parlante cabe y dónde tendría sentido situarlo. Una sala de clase sirve para detectar problemas de interfaz, pero no demuestra por sí sola el valor del lugar en una situación cotidiana.
- **Duración estimada:** 35–45 minutos por sesión. Primero realizar un piloto del procedimiento; si se modifica la pauta después del piloto, registrar el cambio y no mezclar sus observaciones con las sesiones que sigan la versión revisada.
- **Teléfono:** Android 12 o posterior compatible con la app. Registrar modelo, versión de Android, si es propio o prestado, modelo de parlante y ajustes relevantes de audio. No pedir contraseña ni revisar contenidos ajenos a la tarea.
- **Datos de identidad:** asignar un código como `P01`; mantener los consentimientos firmados y cualquier dato de contacto separados de las fichas. No subir información identificable al repositorio.

## Puerta ética y de privacidad antes de convocar

La auditoría de privacidad iniciada en la versión 2.3, cuyo esquema remoto permanece en 2.6, describe almacenamiento local en una base de datos del teléfono y sincronización a Supabase, el servicio remoto de datos del proyecto, si la app tiene configurada su dirección y clave publicable. Los registros pueden incluir actividad, forma de comenzar, lugar declarado, aplicaciones elegidas, umbral, tiempos, eventos y respuesta final opcional. El identificador aleatorio no vuelve anónimos esos registros: son seudonimizados, es decir, se asocian a un código en vez del nombre, pero podrían relacionarse con una persona. La ruta completa de eliminación —incluidos la base local, el historial, las credenciales, el servidor y los respaldos aplicables— no está verificada. Véase [protección de datos del prototipo](privacidad-prototipo-android-2026-09-23.md).

Antes de reclutar, la persona responsable debe:

1. comprobar si la versión instalada guardará datos solo localmente o también los sincronizará con Supabase; explicar a cada participante la condición real, quién tendrá acceso y qué datos se recogen;
2. comprobar que joan1542003@gmail.com reciba solicitudes, incorporar el límite del 30 de diciembre de 2026 a todos los materiales vigentes y demostrar un procedimiento para retirar el consentimiento y solicitar eliminación; esta gestión todavía necesita verificación;
3. conciliar el consentimiento de la app con la hoja entregada y obtener la revisión docente/institucional que corresponda;
4. explicar por separado el consentimiento académico y los permisos de Android. El acceso a datos de uso es necesario para probar el conteo real; el permiso de notificaciones habilita avisos del sistema. No presionar a la persona para concederlos;
5. registrar solo notas de la tarea por defecto. No grabar pantalla, audio, notificaciones, conversaciones ni otras aplicaciones. Cualquier grabación requeriría consentimiento específico y revisión previa.

Si no se puede explicar la ruta efectiva de los datos, el contacto o el retiro/eliminación, no iniciar una sesión con participantes. Si alguien no acepta participar o no concede un permiso, detener la actividad que dependa de él, agradecer y no tratarlo como un error de la persona.

## Comprobación técnica previa, sin participante

Registrar fecha, versión exacta del APK, teléfono, sistema Android, parlante, método de conexión y configuración de Supabase. Probar antes de convocar:

- conexión, desconexión y reconexión del parlante;
- señal de Relevo con la app visible y fuera de pantalla;
- prueba de sonido previa con cada salida, ruta que Android informa para el tono y aviso visible cuando la salida elegida no está disponible;
- posibilidad de silenciar y cerrar el ciclo, y corte del sonido si se pierde la conexión;
- reproducción de un audio de control de otra aplicación en el mismo teléfono: comprobar si también sale por el parlante. Registrar el resultado sin prometer separación;
- funcionamiento del permiso de acceso de uso y, si se probará el aviso fuera de pantalla, de las notificaciones;
- conteo acumulado con dos aplicaciones usadas de forma alternada, pausa al salir de ellas y reanudación;
- solicitud de eliminación desde Privacidad y datos, con y sin conexión, y comprobación de que los registros desaparecen del teléfono y de la base remota.

La conexión normal de un parlante Bluetooth multimedia no reserva el dispositivo para Relevo. Si el audio de control de otra app sale por el parlante, anotar el hecho y explicar la limitación. Si la sesión busca evaluar únicamente la comprensión de Relevo, puede continuar solo si el sonido no crea un riesgo o una confusión; no usarla para afirmar que existe una salida exclusiva. Si falla la señal prevista, clasificar la observación como incidencia técnica, no como falta de comprensión.

## Guion de la sesión

### Apertura y elección de una situación — 5 minutos

Leer: «Estamos evaluando el prototipo, no tus capacidades. Puedes omitir cualquier pregunta o detenerte cuando quieras. No hay una acción correcta que tengas que demostrar. Elige una actividad cotidiana que de verdad te interese; no tiene que ser productiva ni tienes que contar algo privado».

Preguntar: «¿Hay algo que te gustaría hacer en una situación en que a veces sigues usando otra aplicación?». Registrar la actividad en las palabras de la persona. No ofrecer caminar, leer u otros ejemplos salvo que pida ayuda para entender la pregunta. Anotar si la actividad es pertinente para ella hoy, si la considera posible y qué contexto desea compartir; no juzgar la elección.

### Tarea 1 — Preparar el relevo — 8–10 minutos

Indicar: «Deja preparado Relevo para esa actividad y decide tú cómo tendría sentido que te avisara». No señalar controles ni sugerir app, tiempo o ubicación. Observar la preparación por etapas, el uso de atrás/revisión y cualquier duda. Si la persona se detiene, esperar; ofrecer ayuda solo cuando la solicite o no pueda continuar y anotar literalmente qué ayuda se dio.

Al terminar, preguntar: «Cuéntame con tus palabras qué dejaste configurado y qué esperas que ocurra». Comprobar comprensión de: actividad y comienzo elegidos; aplicaciones que se observan y que su tiempo se suma; condición temporal configurada; ubicación declarada; canal de aviso. No corregir durante la tarea salvo que exista un riesgo o una decisión de privacidad incomprendida. Registrar primero la interpretación espontánea y luego aclarar los hechos necesarios para continuar.

### Tarea 2 — Situar y activar — 5 minutos

Indicar: «Ubica el parlante donde te parezca que podría ayudarte a empezar, prueba el sonido si quieres y activa el relevo si todavía te hace sentido». Observar el tiempo y esfuerzo de ubicar/conectar el parlante, el espacio disponible, si la ubicación la elige la persona y si la relación con la actividad le resulta clara. Preguntar antes de que llegue la señal: «¿Qué esperas que pase, dónde y por qué?». No proponer una ubicación.

### Tarea 3 — Esperar y recibir el aviso — 8–12 minutos

La persona usa una de las aplicaciones que eligió con un umbral breve acordado y registrado. La duración configurada y la duración real de la tarea son datos distintos. Si se usa el modo de comprobación de 15 segundos documentado en la app, etiquetar la sesión como demostración técnica breve: no permite concluir que la experiencia del umbral habitual o de una sesión cotidiana funciona igual.

No anunciar cuándo debe sonar. Registrar si la persona percibe el aviso, qué cree que lo emitió, si mira el teléfono y qué decide hacer. No pedirle que empiece la actividad como prueba de éxito. Después de registrar la primera respuesta espontánea, preguntar: «¿Qué te hizo pensar el aviso?», «¿Qué actividad habías pensado hacer y por dónde podrías empezar?» y «¿Qué decidiste hacer después?». Anotar si la actividad y el comienzo surgieron espontáneamente o después de la pregunta. Si no suena, suena por otra salida o la conexión falla, detener la interpretación de experiencia, registrar la incidencia y ofrecer repetir solo si la persona quiere.

### Tarea 4 — Controlar y cerrar — 3–5 minutos

Indicar: «Haz con el aviso lo que te parezca adecuado y termina el relevo cuando quieras». Observar si encuentra el control real para silenciar o cerrar, si sabe revisar o cambiar una elección disponible y si entiende que puede seguir, posponer o cambiar de idea. No dar por hecho una función de pausa manual o desconexión selectiva que no exista. La solicitud de eliminación existe en Privacidad y datos, pero solo puede ofrecerse como vía de retiro si superó la comprobación técnica previa. No insistir si la persona no quiere continuar.

### Conversación final — 8 minutos

Hacer las preguntas del apartado siguiente. Mantener preguntas neutrales; no explicar la intención del diseño antes de recoger la interpretación de la persona. Agradecer la participación y recordar el canal de contacto y retiro que se haya informado en el consentimiento.

## Indicadores para observar

| Indicador | Registro | Decisión que puede orientar |
|---|---|---|
| Pertinencia de la intención | La persona explica por qué esa actividad le importa en esa situación; pertinente para ella / parcialmente / no pertinente / prefiere no decirlo. Conservar sus palabras y no inferir motivación. | Si la preparación representa una intención propia o empuja a elegir una actividad que no corresponde. |
| Comprensión del funcionamiento | Después de configurar, explica qué aplicación se observa, cómo se acumula el tiempo y qué espera que active el aviso; adecuada / parcial / errónea / no evaluable. | Revisar el lenguaje, la condición y la confirmación de la configuración. |
| Comprensión de la señal y el lugar | Explica de dónde espera el sonido, qué le recuerda y por qué situó allí el parlante; registrar por separado lo previsto y lo realmente observado. | Revisar la relación entre actividad, ubicación y señal, sin atribuir un efecto causal al lugar. |
| Recuperación de la intención | Tras la señal, nombra la actividad y cómo podría empezar; registrar ambas / solo una / ninguna, y si lo dijo espontáneamente o tras la pregunta neutral. No equiparar recuerdo o declaración con haber realizado la actividad. | Evaluar si el aviso devuelve a la conversación una intención concreta y qué papel cumple la ubicación. |
| Carga de preparación | Tiempo por etapa, retrocesos, errores, solicitudes de ayuda y dificultad percibida de 1 (muy baja) a 7 (muy alta); anotar el punto concreto de fricción. | Simplificar el paso que produjo carga, no eliminar control sin evidencia. |
| Control percibido y observable | Revisa/corrige antes de activar; encuentra silencio/cierre; entiende que puede no seguir la sugerencia. Marcar observado / con ayuda / no observado / no evaluable. | Corregir etiquetas, ubicación de controles y explicación de opciones. |
| Privacidad comprendida | En sus palabras, identifica para qué se solicita acceso de uso, qué información se registra y si la configuración de esta sesión la envía a un servidor. No evaluar si “acepta” como indicador de comprensión. | Hacer más clara la información y comprobar coherencia entre consentimiento y configuración efectiva. |
| Percepción y atribución | Detecta el aviso: sí / no / dudoso; atribuye la fuente correctamente: sí / no / dudoso; describe molestias o sorpresa con sus palabras. | Distinguir reconocimiento de fallas de ruta, volumen o conexión. |
| Facilidad y pertinencia global | «¿Qué tan fácil o difícil fue preparar y cerrar el relevo?» 1 = muy difícil; 7 = muy fácil. Añadir «¿qué hizo que eligieras ese número?». | Priorizar cambios junto a evidencia observada; no interpretar un promedio aislado como éxito. |
| Incidencias técnicas | Registrar componente, hora y estado: permiso, monitoreo, notificación, parlante, ruta, señal, silencio, cierre, sincronización declarada. | Separar fallas del prototipo de problemas de comprensión y decidir si el intento sirve para analizar cada pregunta. |

No sumar los indicadores en una calificación única. El éxito de una tarea no compensa un problema crítico de consentimiento, control o sonido. Los criterios de avance son provisionales y deben recibir corrección docente; con una muestra formativa no se infiere prevalencia poblacional.

## Preguntas de cierre

1. **Pertinencia:** «¿En qué situación real, si alguna, te serviría preparar algo así? ¿Qué parte no encaja con tu forma de hacer las cosas?»
2. **Comprensión:** «Explícame qué estaba observando Relevo y qué tenía que ocurrir para que apareciera el aviso». No completar su respuesta.
3. **Carga:** «¿Qué parte te pidió más esfuerzo o te hizo dudar? ¿Hubo algún paso que te pareciera innecesario?»
4. **Control:** «¿En algún momento sentiste que tenías menos control del que querías? ¿Qué opción te habría ayudado, si es que faltó alguna?» Registrar la experiencia, sin prometer nuevas funciones.
5. **Señal y ubicación:** «¿Qué te recordó el sonido? ¿La ubicación influyó en lo que pensaste o hiciste, o no tuvo importancia?» La respuesta no demuestra que el lugar causara la decisión.
6. **Reconocimiento y rachas, exploratorio:** primero preguntar «Después de usar Relevo, ¿qué información o devolución te habría resultado útil, si alguna?». Si la persona no lo menciona, presentar como idea no implementada: «La versión que probaste no incluye rachas ni reconocimientos. ¿Te serviría que una versión futura mostrara algún registro de continuidad, como una racha —una secuencia de ocasiones consecutivas—, te sería indiferente o preferirías que no apareciera? ¿Por qué?». Registrar utilidad, indiferencia, presión o rechazo en sus términos. No mostrar un diseño, no atribuir la idea a una función actual ni tratar la respuesta como decisión de producto.

## Registro e interpretación

Usar una ficha por sesión. Mantener separadas cuatro capas: **observación directa** (lo que hizo), **respuesta textual** (lo que dijo), **evento registrado por la app** y **interpretación del investigador**. Anotar ayuda entregada, cambios de guion, configuración local/remota y fallos. Una señal registrada no demuestra que se percibió; una elección declarada no demuestra conducta sostenida; abrir o completar una racha no demuestra hábito.

Clasificar por indicador cuántas sesiones muestran cada tipo de dificultad, y acompañar el conteo con ejemplos identificados mediante códigos. Un intento con falla del parlante puede informar sobre conexión y carga, pero no sobre reconocimiento del sonido. Una tarea completada con ayuda no se registra como autónoma. No convertir percepciones ni autoinformes en efectos causales.

## Secuencia posterior a la sesión de revisión del 23-09

| Momento | Trabajo | Condición para avanzar |
|---|---|---|
| Corrección docente, 23-09-2026 | Revisar pertinencia de las tareas, indicadores, reglas de registro y alcance declarado de la versión evaluada (2.5 en la sesión docente; 2.6 desde el 24 de septiembre). | Registrar qué observaciones se aceptan, se ajustan o quedan abiertas. |
| Antes de invitar participantes | Resolver contacto, consentimiento, configuración efectiva de datos, retención y eliminación; probar la ruta de audio con el equipo exacto. | No iniciar reclutamiento mientras la información entregada o la prueba técnica no sean suficientes. |
| Piloto | Aplicar el procedimiento, registrar duración y ayudas y revisar comprensión de las preguntas. | Si se cambia el instrumento, documentar la versión y separar el piloto del análisis posterior. |
| Septiembre–octubre de 2026 | Ejecutar una ronda formativa, corregir problemas y documentar decisiones. Considerar una comparación del lugar solo con protocolo revisado. | No atribuir a la ubicación un efecto que no se comparó. |
| Hasta el 31 de octubre / 15 de noviembre | Cerrar progresivamente producto, evidencia y contenidos de memoria según la hoja de ruta vigente. | Ajustar el alcance a pruebas y dependencias realmente resueltas. |

La planificación general se consulta en la [hoja de ruta](../00_gobernanza/hoja-de-ruta.md) y el [calendario oficial del segundo semestre](../00_gobernanza/calendario-oficial-segundo-semestre-2026.md). Las fechas no convierten pruebas pendientes en resultados.

## Referencias (APA 7)

Nielsen Norman Group. (2014). *Task scenarios for usability testing*. https://www.nngroup.com/articles/task-scenarios-usability-testing/

Nielsen Norman Group. (2019). *Usability (user) testing 101*. https://www.nngroup.com/articles/usability-testing-101/

Organización Internacional de Normalización. (2018). *ISO 9241-11:2018. Ergonomics of human-system interaction—Part 11: Usability: Definitions and concepts*. https://www.iso.org/standard/63500.html

Organización Internacional de Normalización. (2019). *ISO 9241-210:2019. Ergonomics of human-system interaction—Part 210: Human-centred design for interactive systems*. https://www.iso.org/standard/77520.html

Sauro, J. (2010, 2 de marzo). *If you could only ask one question, use this one*. MeasuringU. https://measuringu.com/single-question/

## Registro de cambios (disclaimer)

### 2026-09-25 — Sincronización con Android 2.6

- **Qué cambió:** la pauta describe el APK 2.6: varias aplicaciones con un solo umbral, elección y prueba de la salida de sonido (parlante o teléfono), consentimiento previo, pausa del conteo al salir de las apps elegidas y solicitud de eliminación. La comprobación técnica previa incluye el conteo con dos apps y la eliminación con y sin conexión.
- **Cómo era antes:** describía 2.5, con una sola aplicación, solo salida Bluetooth y la eliminación como función no presente.
- **Por qué:** el instrumento debe corresponder a la versión que se instalará; la sesión docente del 23 de septiembre se conserva como antecedente en la tabla de revisión.

### 2026-09-23 — Sincronización con Android 2.5

- **Qué cambió:** se actualizó la versión y el enlace del APK, y se indicó el nuevo máximo de tiempo. La descripción de privacidad conserva explícita la eliminación no verificada.
- **Cómo era antes:** la pauta describía 2.4 y un máximo de 60 minutos.
- **Por qué:** evitar que se revise una configuración distinta de la que se entregará.

### 2026-09-23 — Contacto y fecha confirmados

- **Qué cambió:** la puerta de privacidad nombra el correo confirmado y la fecha límite indicada por el autor; mantiene pendiente verificar el canal y la eliminación real.
- **Cómo era antes:** pedía completar contacto y plazo sin reconocer que ambos datos ya se habían entregado.
- **Por qué:** preparar una revisión con datos coherentes sin presentar como comprobado el retiro de información.

### 2026-09-23 — Sincronización con el APK 2.4

- **Qué cambió:** la versión descrita y el enlace de descarga se actualizaron a 2.4.
- **Cómo era antes:** la pauta nombraba el APK 2.3, anterior al cambio del indicador de inicio autodeclarado.
- **Por qué:** usar el mismo instrumento y la misma versión de aplicación durante la revisión; los flujos y límites de privacidad de 2.3 siguen vigentes en 2.4.

### 2026-09-23 — Aplicación del feedback docente y actualización a la versión 2.3

- **Qué cambió:** se reemplazaron las referencias al APK 2.2 y a «mañana» por el APK 2.3 y la sesión del 23-09; se reorganizaron la pregunta de evaluación, tareas, indicadores y preguntas para observar pertinencia, comprensión, carga y control. Se añadieron condiciones explícitas de privacidad y consentimiento según los flujos documentados, límites reales del enrutamiento Bluetooth y una pregunta hipotética sobre reconocimiento/rachas.
- **Cómo era antes:** la pauta presentaba la versión 2.2, pedía demostrar una ruta de parlante sin distinguir plenamente el audio de Relevo del audio de otras apps, y dejaba poco operacionalizados la privacidad, la carga y el control. El feedback sobre reconocimiento podía leerse como solicitud de función.
- **Por qué se tomó esta decisión:** alinear el instrumento con la versión existente, separar experiencia de uso de fallas técnicas, informar con precisión los datos y las limitaciones, y recoger la opinión sobre rachas sin tratarlas como función incorporada ni decisión aprobada.
- **Alcance y límites:** solo se actualizó esta pauta. No se modificó la app, el consentimiento, la configuración de Supabase ni otros documentos; no se realizaron pruebas físicas ni sesiones con participantes. La eliminación integral de datos y la separación del audio de otras aplicaciones permanecen sin verificación.

### 2026-09-23 — Corrección inicial del límite de audio

- **Qué cambió:** la puerta técnica distinguió la ruta del tono de Relevo del audio de otras aplicaciones.
- **Cómo era antes:** «ruta exclusiva» podía interpretarse como garantizada al conectar un parlante.
- **Por qué se tomó esta decisión:** el parlante multimedia puede recibir audio general y la app no controla otras aplicaciones.
- **Alcance:** documentación; sin ensayo físico.

### 2026-09-23 — Creación de la pauta

- **Qué cambió:** se redactó una pauta inicial para evaluar la app Android y un parlante Bluetooth.
- **Cómo era antes:** el Protocolo 01 trataba una activación manual con otra configuración y no cubría la condición de uso acumulado de la aplicación.
- **Por qué se tomó esta decisión:** distinguir la evaluación del prototipo Android de la comparación phygital futura.
- **Alcance:** instrumento diseñado; no contiene resultados ni autoriza por sí solo a reclutar.
