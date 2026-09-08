# Protocolo 01 — Asociación entre intención, señal y lugar

**Estado:** planificado, no ejecutado
**Fecha de preparación:** 27 de agosto de 2026
**Etapas relacionadas:** 13.1 y 13.2 de la memoria v4

## Propósito

Comprobar primero si una señal breve puede recuperar una intención y su primer paso sin obligar a consultar el teléfono. Solo después se comparará el objeto situado con el mismo objeto en un lugar neutro y con una notificación digital equivalente.

El protocolo responde al carácter iterativo del diseño centrado en las personas: los requisitos de uso deben orientar tanto el diseño como su evaluación, y la información obtenida debe quedar documentada para decidir la siguiente iteración (International Organization for Standardization, 2019, 2023).

## Lo que esta prueba no busca demostrar

- reducción del tiempo de pantalla;
- formación de hábitos;
- bienestar psicológico;
- adopción prolongada;
- eficacia poblacional;
- disposición de pago;
- superioridad general de lo físico sobre lo digital.

Iniciar la actividad tampoco constituye el resultado principal. Después de reconocer la intención, continuar con el teléfono, cambiar de idea o no actuar siguen siendo decisiones válidas.

## Participantes y alcance

La muestra formativa estará compuesta por seis personas de 18 a 30 años que no hayan participado en las entrevistas anteriores. Cada una deberá poder describir un episodio reciente en que otra intención dejó de orientar el momento, formular una actividad con un primer paso concreto y utilizar un teléfono Android compatible con el prototipo local de notificación. En la fase A, el investigador controla la señal desde un dispositivo Android; el teléfono de cada participante se incorpora como condición de comparación únicamente en la fase B.

El reclutamiento se realizará mediante referencias, con participación voluntaria y sin pago. Estas condiciones deberán informarse antes de aceptar. Si la convocatoria o la compensación cambian, la modificación se registrará antes de incorporar a la primera persona.

La muestra no permitirá estimar prevalencia ni eficacia. Su función será encontrar fallos de comprensión, diferencias entre condiciones y razones que obliguen a modificar el prototipo.

## Fase A — Asociación básica

### Preparación

Antes de la primera sesión, la plataforma debe cumplir por completo la [especificación mínima](especificacion-materiales-fase-a.md) y su [ficha de ensayo técnico](ficha-ensayo-tecnico-fase-a.md). Inmediatamente antes de recibir a cada participante, el investigador realiza tres activaciones de control, un silenciamiento físico y una reconexión. Estas acciones no forman parte de los resultados de usuario.

1. La persona formula una intención en sus propias palabras.
2. Define un primer paso observable.
3. Elige un lugar que relacione con ese comienzo.
4. Sitúa un objeto simple en ese lugar.
5. Recibe una explicación breve sobre la señal de luz y sonido, y practica cómo detenerla.
6. Realiza otra actividad mientras el investigador envía manualmente la orden de activación desde Android.

La activación es manual porque el investigador decide el momento; no depende todavía de una detección automática. La transmisión por Bluetooth de baja energía se controla por separado. Si una orden no llega, llega tarde, se duplica o el objeto se desconecta, el intento queda invalidado: se registra el incidente, se restablece el sistema y se repite sin contabilizarlo como fallo de asociación.

### Cadena observable

Cada ensayo registra cuatro momentos de asociación:

| Momento | Pregunta de observación | Evidencia mínima |
| --- | --- | --- |
| Percepción | ¿La persona detectó la señal? | Reacción observable o confirmación posterior sin sugerir el significado. |
| Atribución | ¿Reconoció que la señal provenía de Relevo? | Identificación espontánea del sistema o del ciclo configurado. |
| Recuperación | ¿Recordó la intención correcta? | Reconstrucción de la actividad sin abrir el teléfono. |
| Primer paso | ¿Recordó cómo comenzaba? | Descripción del primer paso configurado sin ayuda. |

Una **asociación completa** ocurre cuando los cuatro momentos pueden reconstruirse sin consultar el teléfono ni recibir pistas sobre el contenido. Percibir la señal sin recuperar la intención se registra como asociación parcial, no como éxito.

El control se comprueba por separado. La persona debe explicar que puede ignorar, silenciar o actuar, y reconocer al menos dos de esas salidas sin presentar una como obligatoria. Esta comprobación no cambia el resultado de asociación; una falla de control impide avanzar por comprometer la autonomía de la experiencia.

### Reglas de decisión de la fase A

- **Avanzar a la comparación:** al menos cinco de las seis personas completan la asociación sin consultar el teléfono y no aparece un fallo crítico de autonomía, privacidad o seguridad.
- **Modificar y repetir:** tres o cuatro personas completan la asociación, o se repite una confusión localizada en la señal, la explicación, el lugar o el primer paso.
- **Detener la configuración probada:** dos o menos personas completan la asociación después de una iteración correctiva, o el significado depende de mostrar texto en el objeto, reabrir el teléfono o aumentar la señal hasta un nivel invasivo.

Los porcentajes funcionan como puertas formativas para una muestra pequeña; no representan estimaciones sobre una población. Cualquier cambio de umbral deberá hacerse antes de observar resultados y quedar registrado con su motivo.

## Fase B — Comparación de soporte y lugar

Cada participante recibe, en orden contrabalanceado, tres condiciones. Se utiliza una intención distinta en cada una, con primeros pasos de claridad y relevancia semejantes según la valoración de la persona. El intervalo y el momento de activación se mantienen equivalentes; el lugar o el canal cambian según la condición porque forman parte de la comparación:

1. objeto situado junto al primer paso;
2. el mismo objeto en un lugar neutro;
3. notificación digital.

El orden contrabalanceado distribuye las condiciones en secuencias diferentes para reducir el efecto de practicar primero con una alternativa.

### Variables comparadas

- asociación completa;
- consulta del teléfono para reconstruir el significado;
- relación percibida entre señal y lugar;
- carga de preparación;
- intrusión;
- claridad de las salidas;
- preferencia explicada, sin convertirla en prueba de eficacia.

### Reglas de decisión de la fase B

- **Mantener la configuración situada:** iguala o supera a la notificación en asociación completa, supera al lugar neutro para una mayoría simple y no aumenta de manera recurrente la consulta del teléfono, la intrusión o la carga.
- **Modificar la relación física:** los resultados son mixtos, el lugar aporta solo en algunos tipos de intención o la señal funciona pero su ubicación, explicación o control producen confusión.
- **Detener la configuración física probada:** la notificación iguala o supera de manera consistente la recuperación con menor carga, o el lugar neutro produce resultados equivalentes al lugar relacionado. Esta decisión obliga a reformular la relación phygital; no autoriza a declarar que todo soporte físico carece de valor.

## Fallos críticos

Un fallo crítico impide avanzar aunque se alcance el porcentaje previsto:

- la persona interpreta la señal como obligación, sanción o evaluación;
- el contenido de la intención queda expuesto a terceros;
- silenciar o abandonar no es comprensible;
- aparece una señal fuera de la vigencia acordada;
- el ensayo genera una barrera de accesibilidad que no admite una alternativa razonable;
- el registro metodológico recoge información no contemplada por el consentimiento.

Una falla de conexión, energía o ejecución del patrón no se interpreta como respuesta del participante. Invalida el intento afectado y obliga a repetirlo después de restablecer las condiciones técnicas. Si reaparece, la sesión se detiene y el material vuelve a ensayo técnico.

## Registro por sesión

Cada ficha deberá incluir código de participante, plataforma, versión del prototipo y del control, comprobación previa, intención, primer paso, relación con el lugar, orden de condiciones, observaciones por momento, consultas del teléfono, incidentes técnicos o metodológicos, respuestas abiertas, interpretación, límite y decisión. La conducta observada se separará de la inferencia del investigador.

Los registros pertenecen a la investigación. No se incorporarán al historial funcional de Relevo ni se utilizarán para puntuar cumplimiento.

La ejecución utilizará el [consentimiento informado](consentimiento-protocolo-01.md) y la [ficha de registro](ficha-registro-protocolo-01.md). Ambos documentos permanecen como plantillas sin datos hasta completar su revisión.

## Parámetros de ejecución

| Parámetro | Decisión provisional | Razón y control |
| --- | --- | --- |
| Sesiones | La fase A durará entre 35 y 45 minutos; la fase B, entre 60 y 75 minutos. | Tres condiciones con intervalos de ocho minutos no caben de manera responsable en una sesión de 50 minutos. Separar las fases reduce cansancio y aprendizaje inmediato. |
| Intervalo | La señal aparecerá ocho minutos después de terminar la configuración. | Es un intervalo breve y controlable; no permite inferir recuerdo a largo plazo. |
| Actividad de espera | Ocio digital elegido por la persona en su propio teléfono, mantenido durante el intervalo. | Conserva relación con el problema sin imponer una aplicación específica. Las notificaciones ajenas se silenciarán durante el ensayo. |
| Puerta técnica | Cinco reconexiones, diez activaciones, silenciamiento local, recuperación de energía, estabilidad y operación de 30 minutos deben cumplir la ficha técnica. | Evita atribuir a la comprensión una falla de BLE, código, luz, sonido, control o alimentación. Esta puerta no autoriza por sí sola el reclutamiento. |
| Señal provisional | Tres pulsos de luz blanca cálida y difusa durante tres segundos, acompañados por un tono breve al comienzo; ambos niveles se comprueban antes de cada sesión. | Representa las dos salidas vigentes sin fijar todavía su lenguaje final. Si uno de los canales no es accesible o resulta molesto, la variante se acuerda antes de comenzar y se analiza por separado. |
| Lugar situado | Junto al objeto o material necesario para ejecutar el primer paso. | La persona debe explicar la relación antes de activar. |
| Lugar neutro | En la misma habitación y con visibilidad semejante, al menos a un metro del primer paso y fuera de su recorrido inmediato. | Busca conservar perceptibilidad sin mantener la relación semántica con el comienzo. |
| Notificación | Un único aviso local de Android con el texto `Relevo · Tu intención está disponible`, sin mostrar la intención ni repetir el aviso. | Debe aparecer en el teléfono usado durante la espera. Abrirlo para recuperar el contenido se registra como consulta. La fase B no comenzará hasta disponer de un prototipo que emita el aviso sin almacenar historial ni depender de mensajería externa. |
| Intenciones de la fase B | Tres intenciones personales distintas, con primer paso claro y valoración semejante declarada por la persona. | Evita repetir exactamente la misma asociación. La diferencia entre intenciones se conserva como límite interpretativo. |
| Contrabalanceo | Se utilizarán las seis secuencias posibles de las condiciones A, B y C, una por participante. | Distribuye el efecto del orden entre las seis personas. |
| Consentimiento y retiro | Consentimiento escrito antes de la sesión; retiro posible sin justificar y sin conservar la ficha incompleta. | Separa participación voluntaria de desempeño en la prueba. |
| Registro | Notas estructuradas y ficha codificada; sin grabación de pantalla, historial de aplicaciones ni audio por defecto. | Reduce datos personales. Una grabación adicional requeriría autorización específica. |
| Conservación | Las fichas codificadas podrán eliminarse al cerrar el análisis y se eliminarán, como máximo, el 13 de enero de 2027. Los contactos se mantendrán separados y se borrarán al terminar la segunda sesión o al finalizar antes la participación. | El plazo no supera treinta días desde el comienzo del [periodo oficial de exámenes](../00_gobernanza/calendario-oficial-segundo-semestre-2026.md). Después podrán permanecer únicamente resultados agregados o síntesis anónimas sin vínculo recuperable con la ficha. Si el calendario cambia, debe revisarse antes de reclutar. |

Los parámetros quedan fijados para preparar materiales. Cualquier ajuste anterior a la primera sesión deberá registrarse con fecha y motivo. Después de comenzar el estudio solo podrán cambiarse por seguridad o por un fallo crítico; en ese caso, los datos obtenidos con versiones diferentes no se mezclarán sin distinguirlas.

La matriz integrada de micro:bit se limita a pruebas de mesa sin participantes porque emite luz roja. En las sesiones de la fase A se utilizará una fuente externa de luz blanca cálida y difusa, conectada y comprobada mediante la [ficha de ensayo técnico](ficha-ensayo-tecnico-fase-a.md). Los indicadores de encendido o conexión de la placa se cubrirán o quedarán fuera del campo visible para que no actúen como señales adicionales.

## Referencias metodológicas

International Organization for Standardization. (2019). *Ergonomics of human-system interaction—Part 210: Human-centred design for interactive systems (ISO Standard No. 9241-210:2019).* https://www.iso.org/standard/77520.html

International Organization for Standardization. (2023). *Systems and software engineering—Systems and software Quality Requirements and Evaluation (SQuaRE)—General framework for Common Industry Format (CIF) for usability-related information (ISO/TR 25060:2023).* https://www.iso.org/standard/83763.html

---

## Registro de cambios (disclaimer)

### 2026-09-08 — Fuente luminosa válida para la fase A

- **Cambio:** se reservó la matriz roja de micro:bit para pruebas de mesa y se exigió una fuente externa de luz blanca cálida y difusa para las sesiones, junto con el control de indicadores ajenos a la señal.
- **Versión anterior:** el protocolo definía la señal como luz blanca cálida, pero no aclaraba que la matriz integrada de la plataforma seleccionada emite luz roja.
- **Motivo:** evitar que la implementación técnica contradiga el estímulo fijado y que luces de estado introduzcan señales no controladas.
- **Alcance:** la decisión no valida todavía perceptibilidad, seguridad ni comprensión; esas condiciones deben comprobarse antes de reclutar.

### 2026-09-08 — Activación manual sobre un enlace verificado

- **Cambio:** se definió que el investigador inicia la señal desde Android por BLE, se incorporaron luz y sonido, una comprobación previa por sesión y una regla que invalida los intentos afectados por fallas técnicas.
- **Versión anterior:** la activación manual excluía Android y Bluetooth, y la señal provisional utilizaba únicamente luz.
- **Motivo:** alinear el protocolo con el testigo vigente sin permitir que una desconexión, una orden duplicada o una falla de alimentación se interpreten como falta de comprensión.
- **Alcance:** se conservan seis participantes, las dos fases, el contrabalanceo y las puertas de decisión; el protocolo sigue sin ejecutar y el reclutamiento continúa bloqueado.

### 2026-08-30 — Control separado de la asociación

- **Cambio:** la asociación completa vuelve a sus cuatro momentos y la comprensión del control se registra como condición independiente y obligatoria.
- **Versión anterior:** el protocolo contaba control como quinto momento, mientras la memoria definía cuatro componentes de asociación.
- **Motivo:** medir por separado recuperación de significado y autonomía sin debilitar ninguna de las dos puertas.
- **Alcance:** los umbrales de muestra no cambian; no se añadieron resultados ni se habilitó el reclutamiento.

### 2026-08-30 — Conservación con fecha máxima

- **Cambio:** se reemplazó un plazo relativo por la eliminación a más tardar el 13 de enero de 2027; se permitió eliminar antes al cerrar el análisis y se aclaró el tratamiento de contactos, retiro y síntesis anónimas.
- **Versión anterior:** el protocolo exigía completar la fecha después y podía interpretarse como conservación durante treinta días exactos desde una defensa aún no asignada.
- **Motivo:** comunicar un límite verificable que no exceda treinta días desde el inicio del periodo oficial de exámenes.
- **Alcance:** el protocolo continúa sin ejecutar y el consentimiento aún requiere contacto y revisión académica.

### 2026-08-27 — Correcciones del ensayo interno documental

- **Cambio:** se amplió la fase B a 60–75 minutos, se incorporó compatibilidad Android al reclutamiento y se condicionó la comparación a un emisor local estandarizado.
- **Versión anterior:** ambas sesiones se limitaban a 35–50 minutos y Android no era requisito, aunque una condición exigía recibir una notificación en el teléfono personal.
- **Motivo:** eliminar contradicciones de tiempo y soporte antes de involucrar participantes.
- **Alcance:** la fase A continúa siendo manual; la fase B permanece bloqueada hasta disponer del prototipo de notificación.

### 2026-08-27 — Parámetros de ejecución cerrados

- **Cambio:** se fijaron seis participantes, dos sesiones, intervalo, actividad de espera, señal provisional, definiciones de lugar, notificación, intenciones comparables, contrabalanceo y tratamiento de registros.
- **Versión anterior:** ocho parámetros permanecían formulados como preguntas previas a la ejecución.
- **Motivo:** permitir preparar materiales sin ajustar condiciones después de observar resultados.
- **Alcance:** las decisiones son formativas y deberán declararse como límites; ningún dato ha sido recogido.

### 2026-08-27 — Creación del protocolo planificado

- **Cambio:** se operacionalizaron la asociación básica y la comparación entre objeto situado, objeto neutro y notificación.
- **Versión anterior:** la memoria nombraba variables y criterios generales, pero no fijaba puertas de avance, modificación y detención.
- **Motivo:** impedir que los criterios se ajusten después de observar resultados y separar comprensión de obediencia.
- **Alcance:** el protocolo no ha sido ejecutado; muestra, tiempos, canal, lugar neutro, notificación y gestión de datos deben cerrarse antes del reclutamiento.
