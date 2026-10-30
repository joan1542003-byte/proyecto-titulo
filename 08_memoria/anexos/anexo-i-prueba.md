# Anexo I. Protocolo de la prueba, consentimiento e instrumentos

> Parte de los [anexos de la memoria](README.md). Se genera con `node construir-anexos.js` desde sus documentos fuente: para corregirlo, se corrige la fuente y se vuelve a generar.

Reúne lo necesario para repetir la prueba: el protocolo de 21 días con sus condiciones, procedimiento y reglas de decisión; la semana para comparar de la versión 2.33; el texto del consentimiento vigente desde el 6 de octubre de 2026; las preguntas de la app, y las fichas de la sesión inicial y del cierre.

## I.1 Protocolo de la prueba de 21 días

El protocolo se preparó el 25 de septiembre de 2026 para seis personas, una por cada orden posible de las tres condiciones, con un parlante como objeto provisional. La primera etapa lo aplica desde octubre de 2026 con tres personas que usan un Tag junto al primer paso (capítulo 13 de la memoria), y la semana para comparar de la versión 2.33 suma la condición del teléfono. Las condiciones y las reglas de decisión no cambiaron; las preguntas que hace hoy la app están en I.3.

### Qué responde

La memoria pregunta bajo qué condiciones lo que una persona quería hacer vuelve a estar presente a tiempo, y la decisión sigue siendo suya, mientras una sesión de ocio digital continúa (capítulo 10). Su hipótesis (D-091) es: «Si se diseña un sistema phygital que vincula una actividad elegida con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella». Esta prueba responde:

| Pregunta | Cómo se responde |
| --- | --- |
| 1. **Asociación.** Cuando suena, ¿la persona recupera la intención y su primer paso sin mirar el teléfono? | Observación en la sesión inicial y autoinforme tras cada señal en casa. |
| 2. **Lugar y soporte.** ¿Ayuda más la señal junto al primer paso que en un lugar neutro o que un aviso en el teléfono? | Comparación de las tres semanas dentro de cada persona. |
| 3. **Autonomía.** ¿La persona entiende que puede seguir, silenciar o cambiar de idea, sin sentir obligación? | Comprobación en la sesión inicial, preguntas semanales y entrevista final. |
| 4. **Uso y carga.** ¿Cuánto cuesta preparar, qué molesta, qué falla y quién abandona? | Registros de la app, preguntas semanales y entrevista final. |

**No responde:** si la actividad se realizó (solo se conoce lo que la persona declara), si se formó un hábito (21 días no bastan; Lally et al., 2010) ni cuán eficaz es Relevo en la población.

### Procedimiento

#### Antes de reclutar

- **Prueba técnica** en el teléfono y el parlante que se usarán, con la [pauta Android](../../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md). Se comprueban el conteo con varias apps, la señal de 30 segundos, el silencio, la desconexión, el permiso, el envío de registros y el borrado local y remoto.
- **Comparación interna** de la señal desde otra pieza y con ruido de fondo, para confirmar que se escucha.
- **Revisión** del consentimiento y del protocolo con el profesor.

#### Día 0: sesión inicial en casa (40 a 50 minutos)

1. Consentimiento, instalación, permiso y perfil.
2. La persona formula una intención y su primer paso, y deja el parlante junto a ese comienzo.
3. Configura un límite de 8 minutos en una app que usará durante la espera. Es un parámetro de la prueba, no el momento ideal de intervención.
4. Cuando suena, el investigador registra cuatro momentos sin dar pistas:

| Momento | Pregunta | Evidencia mínima |
| --- | --- | --- |
| Percepción | ¿Notó la señal? | Reacción o confirmación sin sugerir el significado. |
| Atribución | ¿Supo que venía de Relevo? | Lo identifica sin ayuda. |
| Recuperación | ¿Recordó la intención? | La nombra sin abrir el teléfono. |
| Primer paso | ¿Recordó cómo empezar? | Lo describe sin ayuda. |

5. Comprobación de autonomía: la persona reconoce al menos dos salidas (seguir, silenciar, empezar o cambiar de idea) sin considerar obligatoria ninguna.
6. Se explica la condición de la primera semana.

Una **asociación completa** exige los cuatro momentos sin consultar el teléfono ni recibir pistas.

#### Días 1 a 21: tres semanas, una condición por semana

| Condición | Dónde suena | Qué pide la app al comenzar la semana |
| --- | --- | --- |
| A. Situada | Parlante junto al primer paso. | «Esta semana deja el parlante junto a lo que necesitas para empezar». |
| B. Lugar neutro | Parlante en un lugar visible de la casa, a más de un metro del primer paso y fuera de su recorrido. | «Esta semana deja el parlante en un lugar que no tenga relación con la actividad». |
| C. Teléfono | Altavoz del teléfono con notificación genérica. | «Esta semana el aviso sonará en tu teléfono». |

- **Orden:** se usan las seis secuencias posibles de A, B y C, una por participante.
- **Uso:** la persona prepara relevos cuando tengan sentido para ella; se sugieren al menos tres por semana, sin obligación. Una semana con menos señales se registra, no se penaliza.
- **Intenciones:** pueden cambiar entre relevos; cada una se registra con la condición en que se usó.

**Tras cada señal**, cada pregunta con un toque y siempre omitible:

1. «Cuando sonó, ¿supiste qué querías hacer antes de mirar el teléfono?» Sí / A medias / No.
2. «¿Recordaste cómo empezar?» Sí / No.
3. «¿Qué decidiste?» Comencé / La dejé para después / Cambié de idea.

**Al final de cada semana**, una tarjeta en Inicio con escala de 1 a 5:

- cuánto costó preparar;
- cuánto molestó la señal;
- cuánto se relacionaba la señal con el lugar;
- un comentario opcional.

**Día 21:** cinco preguntas de cierre y una entrevista de 15 minutos, presencial o por llamada, sobre qué condición ayudó más y por qué, qué molestó, dónde estuvo el parlante y qué cambiaría. La entrevista la acuerda el investigador directamente; la app no pregunta por ella (decisión del autor del 25 de septiembre).

### Reglas de decisión

**Con tres personas (primera etapa):** los umbrales siguientes, pensados para seis, no se aplican. La lectura es cualitativa: la propuesta se mantiene si la señal se relaciona con la intención y la persona entiende sus opciones, y se modifica si falla una parte específica. Sirve para orientar el diseño; no permite estimar eficacia. Las reglas se conservan para la etapa comparativa.

**Sesión inicial (asociación observada):**

- **Continuar:** al menos cinco de seis personas completan la asociación, sin fallos críticos.
- **Modificar y repetir:** tres o cuatro la completan, o se repite una confusión en la señal, la explicación, el lugar o el primer paso.
- **Detener la configuración:** dos o menos la completan después de una iteración correctiva.

**Tres semanas (comparación):**

- **Mantener la configuración situada:** A iguala o supera a C en señales con «Sí» a la primera pregunta, supera a B en más de la mitad de las personas y no aumenta de forma recurrente la carga ni la molestia.
- **Modificar la relación física:** resultados mixtos, o el lugar ayuda solo con algunos tipos de actividad.
- **Detener la configuración física probada:** C iguala o supera a A con menos esfuerzo, o B da resultados equivalentes a A. Esto obliga a reformular la relación *phygital*; no prueba que todo soporte físico carezca de valor.

Estos umbrales orientan decisiones de diseño con seis personas; no estiman eficacia. Cualquier cambio de umbral se registra antes de ver resultados.

### Fallos críticos

Impiden avanzar aunque se cumplan los umbrales:

- la persona interpreta la señal como obligación, sanción o evaluación;
- el contenido de la intención queda expuesto a terceros;
- silenciar o abandonar no se entiende;
- suena una señal fuera del relevo acordado;
- aparece una barrera de accesibilidad sin alternativa razonable, por ejemplo en personas con baja audición, porque la señal es solo sonora;
- se registra información que el consentimiento no contempla.

Una falla de conexión, del parlante o de la app no cuenta como respuesta de la persona: se registra como incidente técnico y esa señal se excluye de la comparación.

### Datos y conservación

La app registra, con un código, la actividad, el primer paso, el lugar declarado, las apps elegidas, los tiempos, los momentos de señal y respuesta, las respuestas a las preguntas y el uso de las apps elegidas alrededor de la señal. No registra el contenido de otras apps, mensajes ni fotos. El nombre del perfil queda en el teléfono. Desde la 2.16 también registra si cada relevo se activó a mano o solo, y cuándo llegó y se abrió cada mensaje del investigador; con la activación automática encendida, la app revisa qué app está abierta, solo su nombre, sin guardarlo. Desde la 2.18 registra además el uso diario de las apps elegidas alguna vez, el tiempo total de pantalla por día (sin el nombre de las demás apps), el estado del teléfono y los relevos eliminados.

La persona puede pedir el borrado en cualquier momento, y todos los registros se eliminan, como máximo, el 30 de diciembre de 2026. Después solo quedan resultados agregados, sin vínculo con la persona.

### Semana para comparar (desde la 2.33)

Cuando una persona ya usó un objeto sin la prueba iniciada, la pantalla del investigador permite una sola semana de 7 días con una condición (D-138). La semana empieza el día que se inicia y no reemplaza al contrabalanceo de las tres semanas. Antes de empezar, la app pregunta por las semanas anteriores con las tres escalas de la tarjeta semanal. Después de cada relevo, la primera pregunta es si la persona notó el aviso apenas sonó. El día 7, la tarjeta suma «Comparado con las semanas anteriores…», y el cierre pregunta qué le ayudó más a recordar y con qué preferiría que sonara. El análisis debe declarar que el orden no se contrabalanceó ([detalle](../../06_desarrollo_y_factibilidad/app-android/version-2.33-semana-de-comparacion-2026-10-20.md)).

## I.2 Consentimiento vigente (6 de octubre de 2026)

Es el texto que la persona lee en la app antes de empezar; para seguir, marca la casilla «Acepto participar durante 21 días». Versión `2026-10-06-v13`.

> Relevo es parte de un proyecto de título de Diseño. Por 21 días lo usas en tu día a día: cada semana te decimos dónde dejar lo que suena y, de vez en cuando, te hacemos preguntas cortas. Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte. Puedes salir y borrar tus datos cuando quieras.

**Cómo es.** Empieza con un encuentro de unos 45 minutos para dejar todo listo. Cada semana la app te dice dónde suena: junto a donde empiezas, en otro lugar de tu casa o en el teléfono. Tú eliges si usas un parlante, un reloj o un Tag. Cuando se cumple el tiempo que elegiste, suena unos 30 segundos y se apaga. Después de cada aviso y al final de cada semana hay preguntas de un toque; puedes saltarlas. Al final te invitamos a conversar unos 15 minutos. El parlante es provisorio; no es el objeto final.

**Tú decides.** Participar es voluntario. Puedes saltar preguntas, silenciar el sonido, quitar los permisos o salir cuando quieras, sin dar explicaciones. Nadie va a juzgar lo que elijas hacer. El sonido puede molestar a otras personas; puedes detenerlo y contárnoslo.

**Qué guardamos.** Un código al azar; lo que preparas (actividad, cómo empiezas, dónde, apps y tiempo); cuándo lo activas, a mano o solo, cuándo suena y qué respondes; cuánto usaste las apps elegidas 10 minutos antes y después del aviso; cuánto usas cada día las apps que elegiste en Relevo y cuánto tiempo usas el teléfono en total, desde 7 días antes de aceptar; el modelo del teléfono y los permisos que diste; y cómo usas Relevo: cuándo lo abres y por cuánto tiempo, qué pantallas ves, cuánto del video ves, tus intereses, tus actividades y los ajustes que cambias. Tu nombre se guarda aparte, solo con tu código, para saber quién participa; no va junto a lo que haces en Relevo.

**Dónde se guarda.** En el teléfono y en la base de datos del proyecto (Supabase). Si no hay internet, se envía después. También queda una copia sin tu nombre en la carpeta Documentos/Relevo del teléfono; se borra si borras tus datos.

**Qué no vemos.** El permiso de Tiempo de uso podría mostrar el uso de otras apps. Relevo cuenta las que eliges mientras el relevo está activo y, cada día, cuánto las usas y el tiempo total del teléfono; de las demás apps no guarda el nombre. Si enciendes la activación automática, además mira qué app tienes abierta —solo su nombre— para saber cuándo empezar; puedes apagarla cuando quieras. No lee mensajes, fotos, búsquedas ni lo que hay en tu pantalla.

**Mensajes.** El investigador puede enviarte mensajes sobre el testeo; llegan como notificación de Relevo. Guardamos cuándo llegó y cuándo abriste cada uno.

**Tu código.** El código reemplaza tu nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte.

**Hasta cuándo.** Puedes borrar tus datos desde Perfil, en Tus datos, o escribiendo al correo del investigador con tu código. Si no lo haces antes, los borramos a más tardar el 30 de diciembre de 2026.

*Fuente:* pantalla de consentimiento de la app, en las versiones 2.33 y 3.3. Donde la app da el correo del investigador, aquí se omite.

## I.3 Preguntas de la app

Todas se responden con un toque y se pueden saltar.

**Después de cada señal** («Cuatro preguntas de un toque»):

1. ¿Notaste el aviso apenas sonó? — Enseguida · Un rato después · No lo noté. Desde la versión 2.33.
2. ¿Cómo te cayó el sonido? — Bien · Normal · Mal.
3. Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla? — Sí · A medias · No.
4. ¿Recordaste cómo empezar? — Sí · No.

Después: «¿Qué decidiste?» — Comencé la actividad · La dejé para después · Cambié de idea. Las tres respuestas tienen el mismo tamaño y el mismo color.

**Al final de cada semana** («¿Cómo te fue esta semana?»), con una escala de 1 («Nada») a 5 («Mucho»):

1. ¿Te costó preparar Relevo?
2. ¿Te molestó el sonido?
3. ¿El sonido tenía que ver con el lugar donde sonó?
4. ¿Algo más que quieras contarnos? Respuesta abierta.

**Al cierre de los 21 días** («¡Terminaste los 21 días!»):

1. ¿Seguirías usando Relevo? — Sí · Tal vez · No.
2. ¿Qué semana te ayudó más? — Suena donde empiezas · Suena en otro lugar · Suena en el teléfono · Ninguna.
3. ¿Qué te molestó?
4. ¿Qué cambiarías?
5. ¿Dónde quedó lo que sonaba la mayor parte del tiempo?

**En la semana para comparar** (desde la versión 2.33):

- Antes de empezar, «¿Cómo te fue hasta ahora?»: las tres escalas semanales sobre las semanas anteriores, con el objeto que ya usaba.
- El día 7, la tarjeta semanal suma «Comparado con las semanas anteriores, ¿esta semana te ayudó a recordar lo que querías hacer…» — Más · Igual · Menos, y «¿Por qué?».
- El cierre («¡Terminaste la prueba!») tiene siete preguntas:
  1. ¿Seguirías usando Relevo? — Sí · Tal vez · No.
  2. ¿Qué te ayudó más a recordar lo que querías hacer? — El objeto donde empiezo · El aviso en el teléfono · Los dos por igual · Ninguno.
  3. ¿Por qué?
  4. Si siguieras usando Relevo, ¿con qué te gustaría que sonara? — Un objeto · El teléfono · Me da igual.
  5. ¿Qué te molestó?
  6. ¿Qué cambiarías?
  7. ¿Dónde quedó el objeto la mayor parte del tiempo?

*Fuente:* pantallas de la app en las versiones 2.33 y 3.3.

## I.4 Ficha de la sesión inicial

Es la plantilla del protocolo 01 que usa la sesión inicial del protocolo 02 desde el 25 de septiembre de 2026. Valen la identificación, la configuración, la cadena de asociación y la comprobación de autonomía; los campos de luz no aplican, porque la señal es solo sonora (D-070).

### Identificación de la sesión

- Código de participante:
- Fecha:
- Sesión: A — asociación / B — comparación
- Plataforma y código de unidad:
- Versión del prototipo:
- Firmware y versión del control Android:
- Investigador:
- Consentimiento firmado: sí / no
- Incidentes previos:

### Configuración

- Intención formulada:
- Primer paso:
- Lugar elegido y explicación:
- Actividad digital de espera:
- Hora de configuración:
- Hora de activación:
- Tres activaciones, silenciamiento local y reconexión comprobados: sí / no
- Niveles de luz y sonido comprobados: sí / no

### Fase A — Cadena observable

| Momento | Observación directa | Respuesta posterior | Resultado |
| --- | --- | --- | --- |
| Percibió la señal |  |  | Sí / No / Dudoso |
| Lo atribuyó a Relevo |  |  | Sí / No / Dudoso |
| Recuperó la intención |  |  | Sí / No / Parcial |
| Recuperó el primer paso |  |  | Sí / No / Parcial |

- Consultó el teléfono para reconstruir el significado: sí / no
- Asociación completa: sí / no
- Comprendió que podía ignorar, silenciar o actuar: sí / no / parcial
- Salidas que pudo explicar sin ayuda:
- Decisión posterior declarada, sin evaluarla como cumplimiento:

### Incidentes técnicos

- Enlace interrumpido, orden tardía o duplicada: sí / no
- Señal incompleta o distinta del patrón previsto: sí / no
- Falla de alimentación o del control local: sí / no
- Momento y descripción:
- Acción realizada:
- Intento invalidado y repetido: sí / no / no corresponde

Un intento con una falla técnica no se utiliza para decidir si hubo asociación. El incidente se conserva, el sistema se restablece y la repetición se identifica como un intento nuevo. Si la falla vuelve a aparecer, la sesión se detiene.

### Fallos críticos

Marcar y describir cuando corresponda:

- [ ] Interpretación como obligación, sanción o evaluación.
- [ ] Exposición del contenido a terceros.
- [ ] Salida o silenciamiento incomprensible.
- [ ] Señal fuera de vigencia.
- [ ] Barrera de accesibilidad sin alternativa razonable.
- [ ] Registro no contemplado por el consentimiento.

Descripción:

### Decisión de diseño

- Resultado de la sesión: avanzar / modificar / detener / evidencia insuficiente
- Capa afectada: explicación / señal / lugar / primer paso / control / registro / otra
- Cambio propuesto:
- Evidencia necesaria antes de aplicarlo:
- Responsable y fecha:

## I.5 Ficha en papel: escalas, cierre y entrevista

### Por qué existe

La app muestra la tarjeta semanal (los días 7, 14 y 21) y las cinco preguntas de cierre solo si la prueba de 21 días se inició en el teléfono, con «Empezar la prueba hoy». En los teléfonos de la prueba en curso no se inició: los relevos no tienen condición ni día, según la revisión del [estado del proyecto](../../00_gobernanza/estado-del-proyecto-2026-10-19.md). Sin esta ficha, la memoria quedaría sin las escalas de carga, molestia y relación con el lugar, y sin el cierre.

### Qué contiene

- **Página 1, escalas semanales:** las mismas tres preguntas de la tarjeta de la app, con la misma escala de 1 («Nada») a 5 («Mucho»), y un comentario opcional, para las semanas 1, 2 y 3.
  - ¿Te costó preparar Relevo?
  - ¿Te molestó el sonido?
  - ¿El sonido tenía que ver con el lugar donde sonó?
- **Página 2, cierre:**
  - Las cinco preguntas de cierre de la app. La segunda, «¿Qué semana te ayudó más?», solo se hace si hubo semanas con el objeto en lugares distintos o con el teléfono.
  - Una guía de entrevista de unos 15 minutos, con los temas del [protocolo 02](../../07_validacion/protocolo-02-prueba-21-dias.md): qué ayudó más a recordar y por qué, qué molestó, dónde estuvo el objeto y qué cambiaría. Suma además dos preguntas que el protocolo revisa en la sesión inicial: si la persona supo de dónde venía la señal y qué quería hacer sin mirar el teléfono, y si sintió que podía elegir.

## Referencias

Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W. y Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

## Registro de cambios (disclaimer)

### 2026-10-30 — Redacción de la pregunta

- **Qué cambió:** la referencia a la pregunta de investigación usa la nueva redacción aprobada por el autor.
- **Cómo estaba antes:** citaba la pregunta de la v4, «vuelva a considerar una actividad elegida… deja de orientar su decisión».
- **Por qué:** el autor aprobó una nueva redacción y pidió alinear los archivos que citaban la anterior. La hipótesis no se tocó: la cita de D-091 es fiel a su registro.

### 2026-10-24 — Creación

- **Qué cambió:** el anexo se arma desde sus documentos fuente, con el resto de los anexos A–I de la memoria v5.
- **Cómo estaba antes:** la carpeta de anexos solo tenía un README de la v4, con cinco anexos y sin su contenido.
- **Por qué:** el autor pidió elegir un pendiente de prioridad alta y terminarlo; la memoria v5 remite a nueve anexos que no estaban armados.
