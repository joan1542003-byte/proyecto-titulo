---
id: MEM-V2-07
titulo: Plan de prototipado y evaluación; conclusiones, contribución, límites y próximos pasos
estado: módulo fuente sin resultados de prototipo
fecha: 2026-08-24
---

# 13. Plan de prototipado y evaluación

## 13.1. Estado de la evidencia y preguntas de evaluación

Las entrevistas exploratorias a P1–P8 fueron realizadas presencialmente en Santiago los días 11 y 12 de junio de 2026. Aportan episodios, percepciones y estrategias relatadas por las personas participantes; no constituyen una evaluación de Relevo. La pregunta Q13 se refirió al concepto histórico In(Visible), por lo que solo orienta aspectos de tono, discreción y rechazo a una interacción punitiva. No permite afirmar aceptación, eficacia, forma, valor físico ni preferencia por Relevo.

En consecuencia, el prototipo, las comparaciones de ubicación, la notificación de control y la integración Android/BLE permanecen pendientes. El plan siguiente separa la evidencia ya producida de la evidencia que todavía debe obtenerse. Cada prueba tiene carácter formativo: su función es decidir qué conservar, modificar o detener en la siguiente etapa, no producir una generalización sobre la población.

Relevo conserva una arquitectura phygital: una aplicación Android configura la intención y la condición de activación; un objeto físico sin pantalla emite una señal; la persona selecciona manualmente el lugar asociado al primer paso. La notificación del teléfono se incorpora solo como condición de control experimental. No es la salida final del sistema ni autoriza a convertir el proyecto en una aplicación si la dirección física pierde fundamento.

Las cuatro hipótesis de trabajo son:

- **H1. Asociación situada.** Una configuración que articula intención, primer paso, lugar y señal puede facilitar el reconocimiento de qué se quería hacer y cuál era el primer paso, sin exigir la consulta de la aplicación. La hipótesis se debilita si la señal se percibe pero no se atribuye a esa intención, si el lugar no ayuda a interpretar la situación o si la persona debe volver al teléfono para comprenderla.
- **H2. Aporte físico situado.** Un testigo físico ubicado en un lugar congruente puede aportar una relación situada que no aparece, o aparece con menor claridad, cuando el mismo testigo se encuentra en un lugar neutro y cuando se entrega una notificación equivalente. La hipótesis se debilita si las tres condiciones producen la misma comprensión y la notificación genera igual valor con menor carga, costo o mantenimiento.
- **H3. Percepción, atribución, intrusión y autonomía.** La señal física puede ser percibida y atribuida a una intención sin convertirse en alarma, vigilancia o reproche, y la persona puede ignorarla, silenciarla, modificarla o continuar con su actividad. La hipótesis se debilita si la señal se interpreta como control externo, si invade la convivencia o si no existe una salida física clara.
- **H4. Ejecución técnica.** La condición de activación, el enlace entre aplicación y objeto y el vencimiento de la condición pueden ejecutarse de forma legible y tolerante a fallos en el entorno Android/BLE seleccionado. La hipótesis se debilita si el sistema no distingue los estados, entrega señales tardías o exige una operación técnica desproporcionada.

La activación sigue abierta entre continuidad de uso, acumulación dentro de una ventana y horario programado. No se cierra esa decisión antes de observar qué condición conserva la relación con la intención sin tratar todo uso digital como problema. El plan no incorpora una métrica porcentual ni un umbral arbitrario; utiliza reglas cualitativas y condicionales justificadas por la evidencia de cada etapa.

## 13.2. Ruta progresiva

La secuencia adopta una progresión de baja fidelidad a integración funcional. La fidelidad se incrementa solo cuando la puerta anterior entrega información suficiente para tomar una decisión. Esta lógica permite separar el problema de significado, el aporte físico, la experiencia de la señal y la ejecución técnica.

### P0. Asociación con activación simulada

**Pregunta.** ¿La persona puede relacionar una intención configurada, su primer paso, el lugar seleccionado y una señal no textual cuando la activación se simula manualmente?

**Estado y participantes.** Planificado; no ejecutado. Se convocarán personas que cumplan el criterio de usuario principal definido en la investigación. Podrá incorporarse una situación límite para examinar cuándo Relevo debe permanecer inactivo. El número, la duración, el reclutamiento y la distribución de participantes quedan pendientes de un protocolo previo y no se inventan en este documento.

**Materiales.** Un objeto sin pantalla o un sustituto de baja fidelidad que reproduzca la señal prevista; una aplicación o ficha de configuración; tarjetas o registros de intención y primer paso; lugares seleccionables; guion de consentimiento y registro anonimizado. La activación será disparada por la persona investigadora en un momento previamente definido del escenario, sin atribuir el evento a Android ni a BLE.

**Procedimiento.** La persona formulará una intención alternativa y un primer paso observable, elegirá un lugar congruente y configurará la señal. Después se representará una continuidad digital breve o una actividad equivalente al escenario delimitado. La investigadora activará la señal sin explicar de antemano qué debería significar. Se preguntará qué percibió, qué cree que ocurrió, qué intención y primer paso recuerda, qué relación encuentra con el lugar y si consultaría el teléfono. Se registrará también la posibilidad de ignorar, silenciar o desarmar el objeto.

**Variables e indicadores.** Se observará la cadena intención–primer paso–lugar–señal; percepción de la señal; atribución de su significado; recuerdo de la intención; recuerdo del primer paso; necesidad de consulta; claridad del lugar; intrusión; autonomía; y diferencias entre respuesta espontánea y respuesta posterior a una explicación. No se confundirá recordar la intención con ejecutar el primer paso.

**Evidencia a registrar.** Relato inmediato, acciones observables, preguntas espontáneas, errores de atribución, lugar elegido y razón declarada, operación de silencio o salida, notas de la investigadora y condiciones del escenario. La respuesta no será presentada como resultado de una condición técnica real.

**Riesgos y sesgos.** La explicación de la investigadora puede inducir la respuesta; la novedad del objeto puede aumentar la atención; el escenario puede ser más ordenado que la vida cotidiana; y la activación simulada no reproduce una condición automática. Para reducir esos riesgos se diferenciará lo que la persona dijo antes y después de la explicación y se anotará toda ayuda entregada.

**Criterio formativo.** Si la asociación aparece sin consulta y el primer paso puede ser expresado con autonomía, se conserva la dirección para P1. Si la asociación depende del teléfono, del texto o de una explicación posterior, se modifica el vínculo entre lugar, señal y primer paso antes de comparar condiciones. Si el objeto se interpreta como alarma o vigilancia, se detiene el desarrollo formal de la señal y se revisa su tono, intensidad y salida.

**Qué no permite afirmar.** P0 no permite atribuir eficacia a Android/BLE, escoger la condición de activación, estimar cambio de conducta, comparar el valor físico con una notificación ni sostener uso autónomo en el hogar.

### P1. Lugar congruente, lugar neutro y notificación de control

**Pregunta.** ¿El lugar congruente aporta reconocimiento situado frente al mismo objeto en un lugar neutro y frente a una notificación equivalente?

**Estado y participantes.** Planificado; depende de que P0 establezca una asociación interpretable. El criterio de participación será la capacidad de formular una intención alternativa y su primer paso, sin convertir la edad en segmentación suficiente. El número, orden de condiciones, duración y reclutamiento se fijarán antes de la aplicación.

**Materiales.** El mismo objeto sin pantalla, dos ubicaciones definidas por la persona —una congruente y otra neutra—, una notificación textual o visual equivalente en el teléfono y una misma intención configurada. La notificación funcionará como control experimental; no se presentará como solución final ni se compararán condiciones con mensajes de distinta claridad.

**Procedimiento.** Se expondrá a la persona a las condiciones de ubicación y a la condición de notificación. El orden debe definirse previamente y, cuando sea posible, contrabalancearse para evitar que la primera experiencia determine las siguientes. La intención, el primer paso y la señal se mantendrán equivalentes. Después de cada condición se recogerán comprensión, atribución, recuerdo, lugar, consulta, intrusión y autonomía. La pregunta de preferencia se realizará al final y no reemplazará el análisis de cada condición.

**Variables e indicadores.** Se comparará la explicación espontánea del significado, la facilidad para conectar el objeto con el primer paso, la relevancia atribuida al lugar, la necesidad de consultar el teléfono y la carga percibida. Para la condición de notificación se observará si entrega la misma información sin el soporte situado. Se registrarán diferencias cualitativas, no una superioridad estadística inexistente.

**Evidencia a registrar.** Matriz por condición, ubicación exacta y razón de elección, frases de atribución, consultas al teléfono, acciones de silencio, observaciones de confusión y comentarios sobre convivencia, visibilidad y movilidad. Se documentará si el lugar agrega significado o solo funciona como soporte material.

**Riesgos y sesgos.** El lugar congruente puede ser más visible o accesible que el neutro; una notificación mal redactada puede perder por su redacción y no por su modalidad; la comparación repetida puede producir aprendizaje; y el orden puede influir en la preferencia. Las condiciones ambientales y el texto deberán mantenerse comparables y quedar registradas.

**Criterio formativo.** Si el lugar congruente facilita una asociación que no aparece en el lugar neutro y no se replica con la notificación, se conserva la hipótesis de aporte situado para P2. Si el lugar no produce diferencia interpretable, se reformula la dirección física. Si la notificación entrega el mismo valor con menor carga, la forma física deja de ser justificable en su formulación actual. Si el lugar genera intrusión o dificulta la convivencia, se modifica el emplazamiento o se abandona esa configuración.

**Qué no permite afirmar.** P1 no permite afirmar que el objeto mejore la conducta, que el resultado se mantenga en el tiempo, que la persona actúe sobre su intención, que la modalidad sea accesible para todas las personas ni que exista una preferencia de mercado.

### P2. Canales de señal y salida física

**Pregunta.** ¿Qué combinación de canal no textual, intensidad y salida física permite percibir y atribuir la señal sin forzar una consulta al teléfono ni producir una interacción punitiva?

**Estado y participantes.** Planificado; depende de la decisión de P1. Se utilizarán las personas y condiciones que permitan comparar las alternativas sin agregar una nueva variable de significado. Si se incorpora una nueva muestra, su criterio, número y duración se decidirán en el protocolo.

**Materiales.** Prototipos de baja o media fidelidad del testigo, con canales aún abiertos; superficies y lugares de uso; controles de silencio, pausa, desarme o modificación desde el objeto; y la configuración mínima de la aplicación. El objeto continuará sin pantalla.

**Procedimiento.** Se presentarán alternativas de señal en condiciones comparables. La persona describirá qué percibió y qué cree que significa antes de recibir explicación. Luego deberá realizar una salida física, como silenciar o detener la señal, sin regresar a la aplicación. Se registrarán también las consecuencias de ignorar la señal y las condiciones que podrían hacerla inapropiada para otra persona o para una vivienda compartida.

**Variables e indicadores.** Percepción, atribución, legibilidad, habituación declarada, intrusión, tolerancia, autonomía de salida, necesidad de teléfono, compatibilidad con el lugar y percepción de presencia física. La respuesta sensorial no se tratará como accesibilidad universal: la audición, visión, tacto, movilidad, convivencia y contexto requieren pruebas específicas posteriores.

**Evidencia a registrar.** Canal y configuración utilizada, elección de la persona, descripción espontánea, tiempo cualitativo de resolución sin convertirlo en umbral, errores, solicitudes de ayuda, acciones de salida, condiciones ambientales y razones para mantener o descartar cada alternativa.

**Riesgos y sesgos.** La comparación de canales puede convertir la prueba en una demostración tecnológica; el investigador puede privilegiar una alternativa; la novedad puede aumentar la tolerancia; y una situación controlada no representa la convivencia cotidiana. Se deberá mantener neutralidad en la presentación y registrar las condiciones de uso.

**Criterio formativo.** Se conserva el canal que apoye atribución y autonomía sin añadir una carga desproporcionada. Si la señal se percibe pero no se comprende, se revisa la relación con el lugar y el primer paso antes de elevar su intensidad. Si ninguna alternativa aporta valor situado o la salida física no es clara, se reformula o reemplaza la dirección física; Relevo no se transforma en una aplicación.

**Qué no permite afirmar.** P2 no permite afirmar accesibilidad, eficacia de una señal en todos los hogares, seguridad, adopción sostenida, durabilidad material ni conveniencia comercial.

### P3. Condición Android/BLE y fallos

**Pregunta.** ¿La condición de activación, el enlace mediante Bluetooth de baja energía (BLE) y el vencimiento de la condición funcionan de forma legible bajo fallos previsibles?

**Estado y participantes.** Planificado; requiere una decisión de hardware y de versión Android. La primera etapa puede ser una prueba técnica de banco, sin participantes. Si se necesita interacción con personas, el criterio y el protocolo se definirán antes. No se presupone compatibilidad universal.

**Materiales.** Dispositivo o dispositivos Android seleccionados; objeto con enlace BLE; aplicación de prueba; registro de estados y eventos; batería; permisos; escenarios de pantalla bloqueada, aplicación en segundo plano, pérdida de enlace, reinicio, batería baja, cambio de condición, objeto desplazado y señal tardía. La condición de activación se mantendrá abierta entre continuidad, acumulación y horario hasta que la evidencia técnica y conceptual permita elegir.

**Procedimiento.** Se ejecutará cada candidato de condición en un entorno controlado y se interrumpirá deliberadamente cada enlace o estado previsto. El sistema deberá distinguir condición activa, señal emitida, enlace perdido, vencimiento y salida de la persona. Los eventos se registrarán con hora y estado, sin almacenar información innecesaria sobre el uso digital.

**Variables e indicadores.** Activación correcta de la condición elegida; enlace; entrega de señal; vencimiento; recuperación tras fallo; legibilidad del estado; permisos requeridos; necesidad de intervención manual; consumo y mantenimiento observados; y posibilidad de apagar o modificar la condición. Se separará fallo conceptual, perceptivo, técnico y de convivencia.

**Evidencia a registrar.** Registros técnicos de eventos, versión de software y hardware, estado de batería, permisos, pasos de recuperación, eventos tardíos o duplicados, errores de interpretación y decisiones de simplificación. La documentación debe permitir reproducir el fallo sin presentar la ausencia de fallos como resultado general.

**Riesgos y sesgos.** El resultado puede depender del fabricante o de una versión específica; un banco de prueba no representa una vivienda; las pruebas repetidas pueden ocultar el costo de configuración; y un registro técnico correcto no asegura una experiencia comprensible. Se documentará el entorno completo y se evitará extrapolar.

**Criterio formativo.** Si la condición y el enlace son legibles, los fallos tienen salida y el mantenimiento es proporcional, P4 puede integrar el sistema. Si una condición produce activaciones tardías, estados ambiguos o una recuperación excesiva, se prueba un candidato más simple o se pospone la integración. Si el aporte físico no sobrevive a la ejecución técnica, se vuelve a P2; no se protege la arquitectura por sí misma.

**Qué no permite afirmar.** P3 no permite afirmar eficacia psicológica, valor situado, accesibilidad, autonomía doméstica, privacidad suficiente para todos los contextos ni viabilidad de producción en serie.

### P4. Integración y piloto acotado

**Pregunta.** ¿La arquitectura completa conserva asociación, aporte situado, autonomía y funcionamiento técnico en un contexto de uso acotado?

**Estado y participantes.** Planificado y condicionado a las decisiones anteriores. El contexto, el número de participantes, la duración, el reclutamiento, el consentimiento y el manejo de retiros quedan pendientes. El criterio debe incluir al usuario principal y, cuando sea pertinente, una situación límite que permita observar cuándo el sistema debe permanecer inactivo.

**Materiales y procedimiento.** Se integrarán aplicación, objeto, lugar, condición de activación, canal, salida física y registro mínimo. La persona configurará una intención y podrá modificarla, ignorarla o detenerla. El piloto se limitará al contexto que pueda documentarse con privacidad y sin asumir que el hogar es una condición ya observada. Se registrarán episodios de uso, fallos, consultas, cambios, silencios, abandonos y comentarios posteriores.

**Variables, evidencia y riesgos.** Se observará la cadena completa H1–H4: asociación, diferencia situada, percepción y atribución, intrusión, autonomía, entrega, enlace, vencimiento y recuperación. También se registrarán novedad, selección de participantes, convivencia, accesibilidad y carga de mantenimiento. Un piloto acotado está expuesto a auto-selección, efecto de novedad, atención del participante y duración limitada.

**Criterio formativo.** Se mantiene la dirección si la evidencia converge en una asociación situada comprensible, una salida autónoma y un funcionamiento técnico proporcional. Se reformula si existe valor físico pero fallan señal, lugar, control, accesibilidad o producción. Se abandona la dirección física actual si el objeto no añade valor frente a la notificación, exige consulta constante o se vuelve vigilancia. El regreso a investigación de diseño es una salida válida si ninguna configuración física sostiene el mecanismo.

**Qué no permite afirmar.** Un piloto acotado no permite afirmar eficacia poblacional, cambio estable de hábitos, adopción comercial, precio aceptado, seguridad doméstica, autonomía a largo plazo ni superioridad definitiva frente a herramientas existentes.

## 13.3. Registro y reglas comunes

Cada prueba deberá conservar una ficha con versión, fecha, contexto, consentimiento, participantes codificados, materiales, procedimiento, evidencia primaria, interpretación separada y decisión. Se distinguirá: hecho observado; evidencia registrada; interpretación; hipótesis; decisión de diseño; y pendiente. Un retiro de participante no equivale al fracaso del concepto. Un fallo técnico tampoco invalida por sí solo la necesidad investigada.

La evaluación debe registrar tanto los contraejemplos como las respuestas favorables. En especial, se anotarán los casos en que la actividad digital coincide con la intención actual, pues ese patrón límite protege la condición de no intervención. No se utilizarán puntuaciones aisladas como prueba de eficacia ni se presentarán metas de reclutamiento o duración como resultados.

# 14. Conclusiones, contribución, límites y próximos pasos

## 14.1. Conclusión sostenida por la evidencia actual

La evidencia disponible permite delimitar un problema de diseño: ciertas situaciones de continuidad digital de baja deliberación pueden volver menos disponible una intención alternativa que la persona ya había formulado. El problema no equivale a medir tiempo de pantalla, diagnosticar dependencia ni suponer que toda continuidad es indeseable. El usuario límite muestra que una actividad digital puede ser elegida, concentrada, relacional, restaurativa o plenamente coherente con la intención presente; en esos casos una intervención puede ser innecesaria o intrusiva.

El corpus de ocho entrevistas reales aporta material exploratorio para describir episodios, puntos de fricción y estrategias relatadas. La selección por referencias y la edad como único criterio común impiden tratarlo como una segmentación de mercado o como evidencia de prevalencia. Q13 aporta una lectura histórica de In(Visible), no una respuesta sobre Relevo.

El marco conceptual y el análisis de referentes sostienen una oportunidad acotada: distribuir la intención entre una configuración digital, una señal física sin pantalla y un lugar elegido por la persona. La oportunidad depende de que el objeto aporte una relación situada que una notificación equivalente no entregue con la misma claridad y menor carga. Esa proposición sigue siendo una hipótesis de diseño.

Por tanto, todavía no se puede afirmar que Relevo mejore el recuerdo, la ejecución del primer paso, la continuidad de una intención, la autonomía o la experiencia doméstica. Tampoco existe evidencia de que el objeto sea preferible a una notificación, ni de que la condición Android/BLE, el vencimiento, el costo o la producción sean viables. El aporte del artefacto es esperado; el aporte actualmente logrado pertenece a la investigación y a la formulación del problema.

## 14.2. Contribuciones actuales y esperadas

Las contribuciones actuales son cuatro:

1. **Investigación.** Delimitación de un fenómeno situado mediante revisión, mercado y entrevistas exploratorias, con distinción entre usuario principal, usuario límite, episodios relatados y ausencia de intervención.
2. **Formulación.** Conversión del problema en una pregunta investigable y en H1–H4, manteniendo abierta la condición de activación y explicitando qué hallazgos debilitarían la dirección propuesta.
3. **Arquitectura.** Definición provisional de un sistema phygital compuesto por aplicación, objeto sin pantalla, lugar manual, condición y persona, junto con sus flujos de usuario, diseño y técnica.
4. **Método.** Organización de una ruta progresiva que separa asociación, aporte físico, experiencia de señal e integración técnica. La notificación queda como control experimental y los criterios de decisión se expresan sin umbrales ficticios.

Las contribuciones esperadas del prototipo dependen de las pruebas: una forma defendible de situar una intención, una señal comprensible y no punitiva, una salida física autónoma, una condición técnica tolerante a fallos y una arquitectura mantenible. Si el testigo transportable no aporta valor, esa contribución no se obtiene mediante una aplicación de reemplazo. Deberá reformularse o sustituirse la dirección física, conservando necesariamente el carácter phygital y un objeto físico sin pantalla.

## 14.3. Límites

El estudio presenta límites que deben acompañar cualquier afirmación posterior:

- la muestra fue reclutada mediante referencias y la edad fue el único criterio común confirmado;
- no se conservaron duración individual, audio ni notas manuscritas originales;
- el hogar no fue observado como contexto de uso;
- Q13 se refirió a In(Visible), no a Relevo;
- no se ejecutaron pruebas de asociación, comparación de lugares, comparación con notificación, canales, autonomía ni uso sostenido;
- Android y BLE permanecen por probar, al igual que condición, enlace y vencimiento;
- el análisis de entrevistas no tuvo un segundo codificador independiente;
- el mercado permite describir familias, funciones y fricciones, pero no establece eficacia de Relevo;
- no existen cotizaciones que sustenten costos de producción, precio o modelo de pago;
- no se realizaron pruebas específicas de accesibilidad, convivencia, privacidad doméstica, autonomía a largo plazo ni adopción sostenida.

Estos límites no anulan el proyecto; establecen el alcance legítimo de sus conclusiones y evitan confundir una oportunidad razonada con un resultado de producto.

## 14.4. Decisiones abiertas

Las decisiones pendientes, en orden de dependencia, son:

1. elegir mediante P0 la formulación operativa de asociación y descartar interpretaciones de alarma o vigilancia;
2. comparar en P1 lugar congruente, lugar neutro y notificación de control;
3. decidir en P2 canal, intensidad, materialidad y salida física;
4. escoger en P3 la condición de activación entre continuidad, acumulación y horario, junto con el comportamiento ante fallos;
5. definir Android, BLE, permisos, batería, retención de datos y vencimiento;
6. establecer contexto, reclutamiento, duración y consentimiento del piloto;
7. estimar producción, mantenimiento y costos reales solo después de sostener el valor físico;
8. integrar resultados, contraejemplos y decisiones en la memoria final.

Cada punto debe abordarse como una decisión sustantiva. No corresponde cerrar forma, precio, automatización o producción mientras la asociación y el aporte físico permanezcan abiertos.

## 14.5. Próximos pasos

El siguiente paso es cerrar el protocolo de P0, incluidos los conceptos operativos, el guion, el consentimiento, el modo de registrar evidencia y la regla que separará recuerdo de ejecución. Luego se ejecutará P0 con activación simulada. Solo si la asociación resulta inteligible se diseñará P1; solo si P1 entrega una diferencia situada se avanzará a P2; solo si la señal y la salida física son defendibles se invertirá en P3; y solo si la ejecución técnica es proporcional se considerará P4.

La conclusión final deberá escribirse después de ese recorrido y deberá declarar, para cada hipótesis, si la evidencia la sostiene provisionalmente, la debilita o exige una reformulación. Mientras esas pruebas no existan, Relevo debe presentarse como una propuesta phygital fundamentada y evaluable, no como un artefacto cuyo efecto ya está establecido.

## Registro de cambios (disclaimer)

- **Creación.** Se creó este módulo fuente con los capítulos 13, Plan de prototipado y evaluación, y 14, Conclusiones, contribución, límites y próximos pasos.
- **Reemplazo de formulaciones anteriores.** Se sustituyó la presentación de la evaluación como una etapa capaz de entregar resultados inmediatos por una ruta P0–P4 condicionada y auditable. Se reorganizaron las pruebas para que P0 trate la asociación simulada; P1 compare lugar congruente, lugar neutro y notificación; P2 examine canales y salida física; P3 examine Android/BLE, condición, enlace y vencimiento; y P4 integre un piloto acotado.
- **Corrección de alcance.** Se retiraron resultados, porcentajes, tamaños muestrales, duraciones y umbrales que no cuentan con ejecución o fuente. Los datos de participantes, reclutamiento y duración quedan como decisiones de protocolo pendientes.
- **Corrección de evidencia.** Se explicitó que las entrevistas fueron realizadas, pero que Q13 evaluó In(Visible) y no Relevo. Se separaron evidencia exploratoria, hipótesis, decisiones y pendientes.
- **Corrección conceptual.** Se mantuvo Relevo como sistema phygital con objeto físico sin pantalla. La notificación se definió como control experimental y se dejó abierta la activación entre continuidad, acumulación y horario.
- **Precisión metodológica y terminológica.** Se consignaron las fechas exactas del levantamiento, se reemplazaron anglicismos técnicos prescindibles y se explicitó que la phygitalidad y la ausencia de pantalla permanecen como restricciones necesarias aun si cambia la dirección física.
- **Corrección del cierre.** Las conclusiones se limitaron al problema delimitado, el corpus exploratorio, el marco y la oportunidad. El aporte del artefacto se dejó como esperado, sujeto a evaluación futura.
- **Alcance de edición.** Solo se creó este archivo. No se modificaron otros archivos, no se realizó commit y no se hizo push.
- **Conteo aproximado.** 3.787 palabras de cuerpo y 4.070 palabras en total, incluido el registro de cambios.
- **Autochequeo.** No se presentan planes como resultados; no se atribuyen efectos a Relevo; se incluyen H1–H4, P0–P4, criterios, evidencia, riesgos, límites y decisiones abiertas; se conserva la condición phygital y el objeto sin pantalla.
