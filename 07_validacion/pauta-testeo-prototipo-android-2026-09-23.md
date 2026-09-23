# Relevo — pauta de testeo del prototipo integrado

**Versión para corrección docente:** 23 de septiembre de 2026. **Estado:** instrumento diseñado; no contiene resultados ni autoriza por sí solo a reclutar. **Prototipo de referencia:** aplicación Android 2.2 y parlante Bluetooth multimedia pequeño, si supera la comprobación técnica previa.

## Qué se presenta en la sesión de regreso

La entrega solicitada consta de un prototipo construido, indicadores preparados para revisión y una planificación individual. El [APK 2.2](../06_desarrollo_y_factibilidad/app-android/README.md) permite configurar una actividad, escoger la aplicación cuyo uso se acumula, definir un umbral y registrar el cierre declarado. Compilación y revisión en emulador no equivalen a un ensayo completo en teléfono y parlante físicos. Antes de mostrarlo como listo para testeo, deben comprobarse ambos en la configuración concreta que se utilizará.

Esta pauta estudia **la comprensión del ciclo y el funcionamiento observable de la versión actual**. No reemplaza el [Protocolo 01](protocolo-01-asociacion-y-comparacion.md): aquel compara, en etapas posteriores, una señal situada de luz y sonido con otras condiciones y presupone un material distinto. Tampoco presenta el parlante comercial como forma final del producto.

## Pregunta y objetivos

**Pregunta:** ¿puede una persona preparar, recibir y cerrar un relevo sin ayuda, comprendiendo qué aplicación activa el aviso, dónde aparecerá la señal y que sigue siendo libre de decidir qué hacer?

1. Identificar dificultades de configuración, permisos y comprensión del tiempo acumulado.
2. Verificar que el aviso se produce en la condición prevista y que la persona puede identificar y detener su fuente.
3. Observar si la señal situada ayuda a recordar la actividad y cómo comenzar, sin abrir Relevo ni recibir pistas.
4. Evaluar la carga de situar el parlante, la intrusión del sonido y el sentido de la respuesta final.

Se separan usabilidad, funcionamiento técnico, recuperación de la intención y decisión declarada. Una respuesta «Comencé la actividad» es un autorreporte, no una observación de cumplimiento. Ni una sesión breve ni el registro de la app demuestran disminución de uso digital, creación de hábitos o bienestar.

## Fundamento metodológico

La evaluación se organiza alrededor de personas, tareas y contexto de uso definidos, y documenta decisiones para iterar el diseño, de acuerdo con la orientación del diseño centrado en las personas de ISO 9241-210 (Organización Internacional de Normalización [ISO], 2019). La usabilidad se observará mediante logro de tareas, dificultades y percepción de facilidad en un contexto especificado; estos aspectos no se reducen a una valoración estética (ISO, 2018). Los escenarios describen metas cotidianas sin nombrar los controles de la interfaz para evitar inducir una solución (Nielsen Norman Group, 2014, 2019). Tras las tareas principales se aplicará una pregunta breve de facilidad en una escala de siete puntos; el valor se interpretará junto con la observación, no como prueba estadística en una muestra pequeña (Sauro, 2010).

## Participantes y contexto propuestos para la corrección

- **Muestra formativa propuesta:** cinco o seis personas adultas, inicialmente dentro del rango de 18 a 30 años usado para el reclutamiento previo, que utilicen ocio digital y puedan describir una actividad que a veces quieren comenzar. No deben ser las ocho personas de las entrevistas para la primera ronda si es posible, pues ya conocen el tema.
- **Reclutamiento:** por referencias. Amistades pueden participar si la invitación deja claro que negarse o retirarse no afecta la relación, estudios ni trabajo. Registrar vínculo y posible sesgo; no describir la muestra como representativa.
- **Lugar:** ambiente doméstico o una disposición comparable donde la persona pueda ubicar el parlante cerca de un material asociado a su actividad. Una sala de clase sirve para detectar fallos de interfaz, pero no basta para concluir que el lugar aporta valor cotidiano.
- **Duración estimada:** 35–45 minutos por persona. Primero realizar una sesión piloto para ajustar comprensión, tiempos y ficha; no mezclarla con el conjunto analizado si cambia el procedimiento.
- **Teléfono:** Android compatible con la app. Registrar modelo, versión del sistema y si es equipo propio o prestado. No pedir la contraseña ni revisar contenidos de otras apps.

## Condiciones que deben quedar resueltas antes de convocar

1. Probar en el teléfono y parlante concretos: conexión, ruta del tono de Relevo, ausencia de audio de otras apps en el parlante mientras suenan YouTube o Instagram en el teléfono, emisión con Relevo fuera de pantalla, desconexión, silencio y ausencia de señal duplicada. Registrar versión del APK, modelos, versión de Android y ajustes de audio. Si falla la separación requerida, **no presentarla como lograda ni usar el intento como dato sobre la comprensión de la persona**. Véase el [análisis de enrutamiento](../06_desarrollo_y_factibilidad/enrutamiento-audio-parlante-exclusivo-2026-09-23.md).
2. Confirmar el alcance real de la recopilación local y remota, quién accede, cuánto tiempo se conserva, cómo se retira el consentimiento y cómo se eliminan datos. El texto de consentimiento de la app debe coincidir con el documento entregado. Completar correo de contacto del responsable y obtener revisión docente antes de reclutar. El [consentimiento anterior](consentimiento-protocolo-01.md) describe otro montaje y no debe reutilizarse sin adaptación.
3. Acordar si se registrarán notas solamente. No grabar pantalla, audio, aplicaciones ajenas ni conversaciones privadas por defecto. Cualquier grabación requiere consentimiento específico.
4. Usar un identificador como `P01`; guardar por separado cualquier dato de contacto. No subir fichas identificables a este repositorio.
5. Acordar el modo de terminar la prueba si el sonido incomoda, el permiso no se concede, el parlante falla o la persona quiere retirarse.

## Guion de la sesión

**Apertura, 5 minutos.** Explicar: «Estamos probando Relevo, no tus capacidades. Puedes pensar en voz alta si te acomoda, omitir preguntas o detenerte. Puedes elegir una actividad cotidiana que no sea privada». Confirmar consentimiento y permisos antes de recoger datos. Preguntar: «¿Hay alguna actividad que quisieras retomar en un momento en que sueles seguir usando otra app?». Registrar las palabras de la persona, sin sustituirlas por categorías del investigador.

**Tarea 1 — Preparar, 8–10 minutos.** «Imagina que hoy te gustaría hacer esa actividad, pero sabes que podrías seguir usando una app de tu teléfono. Deja preparado Relevo para que te avise después de un tiempo que tú elijas». No mencionar dónde están el selector, el deslizador ni el botón. Observar si comprende qué app cuenta, que el tiempo es acumulado, qué actividad queda registrada y qué espera del parlante. Solo dar ayuda si no puede avanzar, registrando cuándo y qué se dijo.

**Tarea 2 — Situar y activar, 5 minutos.** «Deja el parlante en un lugar que tenga sentido para comenzar lo que elegiste y pon el sistema en marcha». Pedir una explicación breve, antes de que ocurra el aviso: «¿Qué esperas que pase y dónde?». Registrar si la relación entre actividad y lugar fue elegida por la persona o sugerida por el investigador. Comprobar que el sonido de prueba y el silencio sean entendibles; no exigir que la persona mantenga el parlante conectado contra su voluntad.

**Tarea 3 — Esperar y recibir, 8–12 minutos.** La persona utiliza la app que eligió con un umbral breve acordado para la prueba; registrar por separado el tiempo configurado y el tiempo real. No interrumpir al llegar la señal. Observar percepción, fuente identificada, eventual consulta al teléfono y acción para detenerla. Después preguntar, sin nombrar la actividad: «¿Qué te recordó el aviso?» y «¿Cómo pensabas empezar?». Si la señal no llega o aparece por una falla técnica, marcar el intento como inválido, explicar el incidente y repetir solo si la persona acepta.

**Tarea 4 — Cerrar, 3–5 minutos.** «Termina este relevo como te resulte adecuado y vuelve al inicio». Observar si entiende las opciones de respuesta y que puede omitirla. No pedirle que afirme haber realizado una actividad que no realizó.

**Conversación final, 8 minutos.** Utilizar las preguntas de la ficha. Cerrar agradeciendo, aclarando cómo solicitar el retiro de sus datos y sin sugerir que hubo una respuesta correcta.

## Indicadores propuestos para revisión docente

| Indicador | Definición y registro | Para qué decisión sirve |
| --- | --- | --- |
| Configuración autónoma | Tarea 1 completada sin ayuda / con ayuda / no completada; anotar dónde ocurrió la dificultad. | Simplificar selección de app, umbral, actividad o permisos. |
| Comprensión de la condición | Antes del aviso, explica cuál app suma tiempo y qué sucede al salir de ella; correcto / parcial / incorrecto. | Corregir lenguaje y retroalimentación del conteo. |
| Situación deliberada | Elige un lugar y explica su relación con la actividad sin que se le proponga uno; sí / no / no evaluable. | Revisar la relación entre señal y comienzo. |
| Fiabilidad técnica | Activación única y oportuna, audio en parlante, silencio y estado visible; registrar cada componente y fallos. | Separar fallas de implementación de problemas de experiencia. |
| Percepción y atribución | Detecta el aviso y reconoce de dónde viene; sí / no / dudoso en cada parte. | Ajustar canal, volumen o explicación. |
| Recuperación sin pistas | Nombra actividad y forma de empezar sin abrir Relevo; ambas / una / ninguna; registrar si consultó el teléfono. | Evaluar la asociación entre señal, intención y lugar. |
| Control y autonomía | Puede detener el aviso y comprende que actuar, aplazar o cambiar de idea son opciones; sí / parcial / no. | Revisar cierre, tono y control. |
| Carga e intrusión | Valoración de 1 a 7 y razón concreta; registrar contexto y molestias. | Ajustar preparación, duración, volumen y momento. |
| Facilidad percibida | Tras tareas 1 y 4: «¿Qué tan fácil o difícil fue hacer esto?» 1 = muy difícil; 7 = muy fácil. | Priorizar fricciones junto con la observación. |

Los criterios de avance son **provisionales y formativos**, no umbrales estadísticos: mantener lo que no produzca errores críticos ni confusiones repetidas; modificar si dos o más personas tropiezan en el mismo punto o interpretan mal la condición; detener la configuración ensayada ante un problema de privacidad, imposibilidad de silenciar, señal persistente fuera del contexto acordado o fallo técnico reiterado. La corrección docente debe aprobar o ajustar esta regla antes de la primera sesión analizada. No se compensan fallos críticos con una puntuación promedio alta.

## Preguntas finales, en este orden

1. «¿Qué entendiste que hizo Relevo desde que lo activaste hasta que sonó?» — reconstrucción del mecanismo; no sugerir la respuesta.
2. «¿Qué te recordó la señal y qué papel tuvo el lugar donde estaba el parlante?» — distinguir contenido de la intención y aporte del lugar.
3. «¿Hubo algún momento en que el aviso sobrara o interrumpiera algo que sí querías hacer?» — detectar condiciones de no intervención.
4. «¿Qué parte te costó más o te hizo dudar?» — ubicar fricción concreta.
5. «Si pudieras cambiar una cosa antes de volver a usarlo, ¿cuál sería?» — priorizar una modificación, no pedir elogios generales.

La pregunta sobre el lugar no constituye comparación causal: para afirmar que el lugar aporta más que una notificación u otra ubicación se necesita la fase comparativa del Protocolo 01 o un nuevo diseño equivalente.

## Registro y análisis

Usar una [ficha por sesión](ficha-testeo-prototipo-android-2026-09-23.md). Separar cuatro columnas al analizar: observación directa, respuesta de la persona, evento registrado por la app e interpretación del investigador. Una señal emitida en el registro no prueba que fue percibida; una declaración de inicio no prueba conducta sostenida. Señalar la versión del prototipo y cualquier cambio de guion. Resumir por indicador cuántas personas tuvieron cada dificultad y acompañarlo de ejemplos codificados; no inferir porcentajes poblacionales.

## Plan individual que conviene llevar mañana

| Plazo | Objetivo verificable | Dependencia |
| --- | --- | --- |
| Antes de la corrección | Mostrar APK 2.2, parlante previsto y una demostración técnica breve; llevar esta pauta y una ficha en blanco. | Probar teléfono y parlante juntos; declarar cualquier fallo. |
| Después de la corrección | Ajustar indicadores, consentimiento, retención de datos y guion; registrar cambios aprobados. | Observaciones docentes y responsable de datos. |
| Finales de septiembre / inicio de octubre | Ejecutar piloto y luego primera ronda formativa; sintetizar problemas y decisiones. | Condiciones éticas y técnicas resueltas. |
| Octubre | Iterar app y soporte físico; si procede, comparar valor del lugar y soporte. | Evidencia de la primera ronda; protocolo comparativo revisado. |
| Hasta 31 de octubre | Tener producto casi terminado y registro de cambios verificable. | Pruebas e iteraciones. |
| Hasta 15 de noviembre | Cerrar producto, evidencia y contenidos de memoria. | Ensayos finales y revisión editorial. |

Esta tabla orienta el [plan individual](../00_gobernanza/hoja-de-ruta.md); las fechas institucionales vigentes están en el [calendario oficial](../00_gobernanza/calendario-oficial-segundo-semestre-2026.md). La corrección puede modificar alcance y secuencia, pero no convertir en resultados las pruebas aún no realizadas.

## Referencias (APA 7)

Nielsen Norman Group. (2014). *Task scenarios for usability testing*. https://www.nngroup.com/articles/task-scenarios-usability-testing/

Nielsen Norman Group. (2019). *Usability (user) testing 101*. https://www.nngroup.com/articles/usability-testing-101/

Organización Internacional de Normalización. (2018). *ISO 9241-11:2018. Ergonomics of human-system interaction—Part 11: Usability: Definitions and concepts*. https://www.iso.org/standard/63500.html

Organización Internacional de Normalización. (2019). *ISO 9241-210:2019. Ergonomics of human-system interaction—Part 210: Human-centred design for interactive systems*. https://www.iso.org/standard/77520.html

Sauro, J. (2010, 2 de marzo). *If you could only ask one question, use this one*. MeasuringU. https://measuringu.com/single-question/

## Registro de cambios (disclaimer)

### 2026-09-23 — Verificación de separación de audio

- **Cambio:** la puerta técnica distingue la ruta del tono de Relevo del audio de otras apps y exige probar ambos con el montaje concreto.
- **Antes:** «ruta exclusiva» podía interpretarse como garantizada por seleccionar el parlante para Relevo.
- **Motivo:** el parlante multimedia conectado puede recibir audio general del teléfono; la experiencia solicitada requiere comprobación separada.
- **Alcance:** corrección del instrumento; no se ha ejecutado la prueba ni modificado el prototipo.

- **Cambio:** se creó una pauta para el prototipo Android 2.2 con parlante Bluetooth, indicadores observables, preguntas no inductivas y una ruta de decisión.
- **Antes:** el Protocolo 01 describía una señal de luz y sonido activada manualmente con otro montaje; no cubría la detección acumulada ni la interfaz actual.
- **Motivo:** presentar mañana un instrumento coherente con lo que efectivamente existe, sin atribuirle resultados ni abandonar la futura comparación phygital.
