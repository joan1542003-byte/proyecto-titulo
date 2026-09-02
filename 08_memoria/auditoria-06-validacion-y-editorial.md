# Auditoría 6: validación, conclusiones, APA y calidad editorial

**Proyecto:** Relevo, Proyecto de Título de Diseño, Universidad Diego Portales

**Fecha de auditoría:** 24 de agosto de 2026

**Alcance:** revisión de 08_memoria/memoria-vigente.md y 07_validacion/README.md
**Estado de este informe:** auditoría interna para orientar una reescritura; no reemplaza la memoria vigente.

## 1. Dictamen ejecutivo

La memoria vigente tiene una base argumental sólida: distingue el ocio digital de su duración, reconoce que las ocho entrevistas son exploratorias, formula una hipótesis compatible con un objeto físico sin pantalla y separa recuerdo, reconsideración, autonomía y conducta. Esa dirección debe mantenerse.

Sin embargo, todavía no puede presentarse como una memoria cerrada ni como una validación de Relevo. El directorio 07_validacion contiene únicamente un marco de pruebas y no registra participantes, ejecuciones, observaciones, datos, resultados ni decisiones posteriores. La memoria describe un plan detallado, pero en varios puntos utiliza una precisión numérica y técnica que puede producir la apariencia de evidencia realizada. La corrección principal consiste en separar con mayor rigor tres estados:

- **Realizado:** revisión documental, entrevistas de junio de 2026, análisis inicial del corpus y decisiones conceptuales/formales registradas.
- **Diseñado, pero no ejecutado:** pruebas de asociación, modalidad, forma, comparación con notificación, integración Android–Bluetooth LE y piloto doméstico.
- **Pendiente de decisión:** condición operacional de activación, arquitectura Android, canales definitivos, aporte específico del objeto frente a una notificación, costos, aceptación y cierre del proyecto.

El cierre honesto de esta etapa debe afirmar que Relevo es una propuesta phygital fundamentada y evaluable, no que su eficacia, superioridad, adopción o factibilidad comercial ya fueron demostradas. La memoria debe responder qué se investigó, qué se decidió y qué queda por comprobar sin convertir el protocolo futuro en resultado.

## 2. Documentos y criterio de auditoría

Se leyeron completos:

- [Memoria vigente de Relevo](memoria-vigente.md).
- [Marco de validación](../07_validacion/README.md).
- [Criterios de calidad](../00_gobernanza/criterios-de-calidad.md).
- [Directrices de trabajo](../00_gobernanza/directrices-de-trabajo.md).
- [Matriz de incorporación del feedback E15](matriz-incorporacion-feedback-e15.md).

La revisión aplicó cinco preguntas:

1. ¿La pregunta de investigación se traduce en una hipótesis que pueda observarse?
2. ¿Cada hipótesis tiene variables, protocolo, indicador y criterio de decisión identificables?
3. ¿La memoria diferencia evidencia realizada, inferencia de diseño, plan y resultado?
4. ¿Las conclusiones responden solo lo que el corpus y las pruebas permiten afirmar?
5. ¿La escritura cumple una política estable de claridad, trazabilidad, APA 7, anonimato y ausencia de metalenguaje?

Se utilizan las categorías **mantener**, **reemplazar**, **ampliar** y **retirar**. Mantener no significa que una sección esté cerrada: significa conservar su función y someter su redacción a la política editorial indicada aquí.

## 3. Estado de evidencia y correspondencia lógica

### 3.1 Inventario de afirmaciones por estado

| Estado | Afirmaciones que la memoria puede sostener actualmente | Afirmaciones que no puede sostener todavía |
| --- | --- | --- |
| Evidencia de usuarios | Se realizaron ocho entrevistas semiestructuradas, presenciales y habladas en Santiago, entre el 11 y el 12 de junio de 2026. El criterio común confirmado fue la edad; el rango observado fue de 19 a 27 años. El corpus presenta casos afirmativos, parciales y negativos. | Que el fenómeno sea prevalente, representativo o propio de todas las personas adultas jóvenes. |
| Evidencia bibliográfica | La literatura permite discutir memoria prospectiva, descarga de intenciones, conflicto de metas, ocio digital y recordatorios situados. | Que una señal física sin texto funcione en el hogar de la misma forma que en los estudios citados. |
| Decisión de diseño | Se decidió investigar un sistema phygital compuesto por aplicación Android, testigo físico sin pantalla y lugar elegido. Se excluyeron bloqueo, ranking, racha y registro de cumplimiento. | Que el sistema ya funcione de manera estable, sea comprensible para usuarios nuevos o preserve autonomía en uso real. |
| Hipótesis | Se propone que la asociación entre intención, primer paso, testigo y ubicación congruente puede favorecer la recuperación sin consultar el teléfono. | Que la ubicación congruente produzca una mejora, que el objeto supere a una notificación o que la persona inicie la actividad. |
| Plan de evaluación | Existen protocolos preliminares para asociación, forma, modalidad, aporte físico, integración y uso doméstico. | Que se hayan reclutado participantes, ejecutado pruebas, medido indicadores o alcanzado umbrales. |
| Factibilidad | Existen escenarios técnicos, productivos y económicos de planificación. | Que existan cotizaciones, precio validado, autonomía demostrada, certificación o viabilidad comercial. |

### 3.2 Matriz de trazabilidad de la pregunta a la conclusión

La siguiente matriz debe transformarse en la columna vertebral de la reescritura. El identificador H1 corresponde a la hipótesis explícita de la memoria. H2–H4 son relaciones que aparecen en el plan, pero que deben formalizarse o declararse como preguntas secundarias; no deben presentarse como hipótesis ya confirmadas.

| Identificador | Pregunta o relación | Hipótesis o supuesto | Variable o resultado principal | Protocolo previsto | Estado actual | Conclusión permitida |
| --- | --- | --- | --- | --- | --- | --- |
| QI | ¿Bajo qué condiciones una señal externa configurada por la persona puede apoyar la recuperación de una intención de ocio durante una sesión digital doméstica sin bloquear ni evaluar? | **H1:** una intención autoelegida, un primer paso concreto y una señal situada junto al elemento asociado favorecerían el recuerdo de intención y primer paso sin consultar el teléfono, en comparación con una ubicación neutra. | Resultado primario: recuerdo espontáneo exacto de intención y primer paso. Resultados separados: consulta del teléfono, atribución de la señal, autonomía, intrusión y reconsideración. | Asociación sin pantalla, con ubicación congruente y neutra. | No ejecutado. | La literatura, las entrevistas y el razonamiento de diseño justifican la hipótesis; no permiten afirmar que se cumpla. |
| QP | ¿Bajo qué condiciones un testigo físico sin texto puede actuar como clave de recuperación sin reducir autonomía? | **H2, por formalizar:** el aporte del testigo dependería de que la asociación espacial sea comprensible, la señal sea perceptible y la persona pueda ignorarla o silenciarla sin penalización. | Comprensión de la relación, posibilidad de silenciar, autonomía percibida, intrusión y reproche. | Forma, asociación, modalidad y entrevista posterior. | Parcialmente operacionalizado. | Puede formularse como criterio de diseño y pregunta de evaluación; no como propiedad demostrada del objeto. |
| QP secundaria | ¿Qué aporta el medio físico frente a una notificación Android? | **H3, por formalizar:** el testigo podría aportar una clave situada o una separación del flujo de pantalla; no se presupone superioridad en recuerdo ni en cambio conductual. | Ventaja física identificada, recuerdo, consulta del teléfono, carga de configuración, autonomía y preferencia razonada. | Comparación contrabalanceada entre testigo situado y notificación textual. | No ejecutado; el contraste debe definirse con mayor precisión. | Solo puede afirmarse que la comparación es necesaria para justificar el componente físico. |
| Modalidad | ¿Qué combinación de luz, sonido y vibración es perceptible y tolerable en distintos contextos? | **H4, por formalizar:** no existe un canal universal; la configuración debe adaptarse a distancia, superficie, convivencia y accesibilidad. | Detección, atribución, latencia percibida, molestia, exposición y tolerancia. | Prueba de modalidad y alcance. | No ejecutado; faltan definiciones y condiciones. | Puede mantenerse como principio de evaluación, no como hallazgo. |
| Técnica | ¿Puede la arquitectura Android entregar una señal vigente sin vigilancia o permisos desproporcionados? | Supuesto técnico: el sistema puede aproximar una condición de uso y enviar un patrón dentro de una ventana activa. | Entrega oportuna, pérdida de enlace, activación tardía, batería, permisos y diferencias por fabricante. | Pruebas de integración con modelos y versiones definidos. | No ejecutado; la condición y arquitectura siguen abiertas. | La factibilidad es una hipótesis técnica, no una capacidad disponible. |
| Adopción | ¿La configuración, ubicación y rearmado caben en una rutina doméstica breve? | Supuesto de adopción: el ritual físico no agrega una carga mayor que el valor que ofrece. | Errores, tiempo de configuración, rearmado, pérdida, habituación, abandono y motivos de modificación. | Piloto doméstico breve y entrevista de cierre. | No ejecutado. | No puede afirmarse uso sostenido, habituación ni disposición de pago. |

### 3.3 Vacíos lógicos que deben resolverse antes de llamar «validación» al capítulo 10

La hipótesis H1 es razonablemente clara, pero todavía contiene cuatro ambigüedades que afectan la interpretación:

- **Condición de activación:** se habla de una condición aproximada, umbral, ventana y acumulado continuo, pero no existe una definición única de qué evento activa la señal. La prueba manual puede estudiar asociación; no puede validar la condición digital.
- **Estado previo de la intención:** la propia memoria advierte que afirmar que la intención «volvió» exige saber si estaba activa antes. El protocolo debe medir o preguntar el estado previo antes de la señal; de lo contrario, solo mide reconocimiento o recuerdo inducido.
- **Unidad de análisis:** no se define si el resultado es por persona, por episodio, por condición o por señal. Con muestras pequeñas, mezclar episodios puede inflar artificialmente el número de observaciones.
- **Recuerdo exacto:** aparecen las categorías exacto, parcial, error y consulta, pero no se especifica qué combinación cuenta como éxito. Debe definirse por adelantado si intención y primer paso son dos componentes independientes o un resultado compuesto.

## 4. Auditoría específica de 07_validacion

El archivo de validación cumple una función correcta como índice y regla general: exige declarar hipótesis, variable, muestra, procedimiento, indicador, éxito, abandono, riesgos y uso de cada resultado. El problema es que la memoria no cumple todavía esa exigencia de manera uniforme.

### 4.1 Correspondencias que funcionan

- La regla de no mezclar recuerdo, inicio de actividad, cambio de decisión, valoración y reducción del uso digital está bien formulada y debe conservarse.
- La frase «recordar no equivale a obedecer» protege la autonomía y evita convertir la conducta posterior en una métrica de cumplimiento.
- La secuencia general cubre asociación, comprensión, modalidad, soporte, forma, integración y uso doméstico.
- La memoria separa fallo conceptual, perceptivo y técnico, lo que permite identificar dónde se rompe el sistema.

### 4.2 Incumplimientos o vacíos

| Requisito del marco de validación | Situación en la memoria | Corrección necesaria |
| --- | --- | --- |
| Hipótesis por protocolo | La Tabla 12 presenta etapas, pero no asigna una hipótesis explícita a cada una. | Añadir un código H y una pregunta decisional por etapa. |
| Variable | Se enumeran indicadores, pero no se separan variable manipulada, resultado y condición de control. | Usar una ficha por protocolo con independiente, dependientes, controles y variables de contexto. |
| Muestra | Se proponen tamaños, pero no se justifica por qué son suficientes para la decisión concreta. | Presentarlos como muestras formativas para detectar problemas, no como base de eficacia; justificar la pertinencia y el alcance. |
| Procedimiento | Se describe la secuencia general, pero faltan instrucciones de asignación, intervalos de recuerdo, orden exacto, ayudas permitidas y criterios de interrupción. | Escribir un protocolo ejecutable por otra persona. |
| Indicador | «Recuerdo confiable», «valor físico», «baja molestia» y «autonomía» no tienen anclajes comunes. | Definir codificación, escala, momento de medición y evidencia mínima. |
| Éxito | Los umbrales 4/5 y 90 % aparecen sin fundamento metodológico o de ingeniería. | Reemplazar por reglas formativas justificadas o declarar explícitamente su carácter provisional. |
| Fallo | Hay criterios de modificar o abandonar, pero no una definición general de fallo de prueba, fallo de sistema y fallo de proyecto. | Separar esos tres niveles y registrar qué decisión activa cada uno. |
| Abandono | La Tabla 13 menciona abandonar, pero no establece una secuencia de repetición, severidad o decisión final. | Definir abandono de hipótesis, componente o proyecto; no confundirlo con retiro de un participante. |
| Riesgos | La Tabla 12 no tiene una columna de riesgos y el texto no los vincula a cada etapa. | Incluir riesgos de privacidad, convivencia, fatiga, aprendizaje, exposición, permisos, batería y activación tardía. |
| Uso del resultado | No se especifica qué decisión concreta se tomará con cada dato. | Añadir una columna «si ocurre X, se mantiene/modifica/retira Y». |

### 4.3 Pseudo-precisión detectada

Los siguientes números pueden mantenerse solo si se presentan como umbrales internos de prototipado, se justifica su origen y se indica que no son evidencia estadística:

- 4 de 5 para recordar o ejecutar tareas.
- 90 % de comandos entregados.
- 100 activaciones sin reinicio.
- 30 días de autonomía y 90 días como meta posterior.
- 40, 44 y 48 mm de diámetro.
- 6–8 participantes durante 7–10 días.
- CLP 79.990–99.990 como hipótesis de precio.

En su formulación actual, la precisión de estas cifras puede sugerir que existe una base empírica que no está documentada. La solución no es eliminar toda cifra: es clasificarla. La memoria debe usar:

- **medida observada**, cuando proviene de una ejecución registrada;
- **umbral técnico**, cuando define una condición de funcionamiento y tiene una razón de ingeniería;
- **regla formativa**, cuando ayuda a tomar una decisión temprana con una muestra pequeña;
- **meta de exploración**, cuando aún es una aspiración de diseño;
- **supuesto económico**, cuando no es una cotización ni una disposición de pago.

Los tamaños de muestra no deben llamarse «adecuados» sin una justificación referida a la tarea. Es más exacto decir que se proponen para detectar problemas tempranos y que no permiten estimar eficacia o prevalencia.

## 5. Matriz de intervención editorial

| ID | Sección o elemento | Acción | Diagnóstico | Corrección concreta |
| --- | --- | --- | --- | --- |
| A06-01 | Estado de la versión, líneas iniciales | Reemplazar | «Base escrita vigente», «versión de trabajo» y la derivación desde v3 son metainformación del repositorio, no parte del argumento académico. | Mantener el control en el encabezado del archivo, pero preparar una copia de entrega cuyo inicio sea título, resumen, palabras clave y cuerpo de la memoria. |
| A06-02 | Título y resumen | Ampliar | El resumen comunica con claridad el problema, pero la descripción del sistema usa presente factual para funciones aún no probadas. | Cambiar «el objeto emite» por «la propuesta contempla que el objeto emita» y «la persona configura» por «la propuesta permite configurar». Cerrar con el estado real: propuesta fundamentada y plan de evaluación, sin eficacia demostrada. |
| A06-03 | Abstract | Reemplazar | El abstract reproduce la misma sobreafirmación temporal del resumen y contiene decisiones de traducción que pueden parecer resultados. | Traducir después de cerrar la versión española y usar exactamente los mismos estados epistémicos: conducted, proposed, planned, not yet evaluated. |
| A06-04 | Índice con páginas | Retirar | Los números de página no son verificables en Markdown y pueden quedar desactualizados al maquetar. | Generar el índice en el documento final o dejar solo enlaces de sección en la documentación del repositorio. |
| A06-05 | Marcadores de figuras y tablas heredados de DOCX | Retirar del cuerpo | «Figura conservada en la fuente DOCX», «conversión estructural desde la tabla de Word» y «véase el manifiesto» son metalenguaje de migración. | Mover la procedencia a 99_archivo; en la memoria final conservar solo la figura, su título, nota y fuente cuando corresponda. |
| A06-06 | 1.1 Escena e hipótesis | Mantener y ampliar | La escena hace comprensible Relevo y anticipa la prueba principal. | Marcar cada elemento como escenario hipotético y separar condición digital, señal, ubicación y respuesta libre. No presentar Instagram, zapatillas o duración como evidencia de usuarios. |
| A06-07 | 1.2 Evolución del problema | Mantener y condensar | La evolución aclara por qué el proyecto cambió de tiempo de pantalla a intención. Repite argumentos que reaparecen en conclusiones. | Conservar el giro conceptual en dos o tres párrafos y trasladar el detalle histórico al archivo de proceso. |
| A06-08 | 1.3 Alcance y aporte | Ampliar | El alcance está acotado, pero «MVP», «adultos jóvenes» y «aporte disciplinar» necesitan definición y límite. | Definir producto mínimo viable, operacionalizar el grupo por el rango del estudio sin convertirlo en segmento de mercado y formular el aporte como pregunta de diseño investigable. |
| A06-09 | Capítulo 2 | Mantener y actualizar | El capítulo construye el problema y evita reducirlo a minutos de pantalla. | Mantener la argumentación, pero revisar que cada fuente sostenga la afirmación exacta. Separar literatura, datos nacionales y descripción comercial. |
| A06-10 | 2.3 Herramientas actuales | Ampliar | El análisis por mecanismos es mejor que un catálogo, pero MyTime es antiguo y Pause Point se apoya en comunicación oficial. | Presentar MyTime como antecedente de investigación, no como mercado vigente; distinguir oferta actual de evidencia de eficacia y registrar fecha de consulta en una ficha de mercado. |
| A06-11 | Capítulo 3 | Mantener y ampliar | El marco teórico está alineado con H1, pero «cognición situada» aparece en el resumen sin una definición equivalente en el capítulo. | Definir el concepto en su primera aparición o retirarlo del resumen. Añadir una frase que explique exactamente qué aporta cada teoría y qué no permite inferir. |
| A06-12 | 4.1 Procedencia | Mantener y reemplazar título | La información metodológica es precisa y corrige el registro previo, pero «consulta exploratoria» minimiza ocho entrevistas semiestructuradas reales. | Usar «Estudio exploratorio mediante entrevistas semiestructuradas» y conservar límites: conveniencia, edad como criterio común, consentimiento oral, sin audio ni duración individual disponible. |
| A06-13 | 4.2 Hallazgos | Mantener y ampliar | El conteo 6/1/1 y los casos negativos son útiles, pero la categoría «difícil de describir» no equivale automáticamente a continuidad automática o intención desplazada. | Declarar que la pregunta 8 identifica un indicio de experiencia difícil de narrar; usar otras respuestas para argumentar conflicto solo cuando el registro lo muestra. |
| A06-14 | 4.3 Tipos situacionales | Mantener y ampliar | Usuario principal y usuario límite son una buena solución a la muestra pequeña y evitan segmentos ficticios. | Convertir cada tipo en patrón situacional con necesidades, riesgos, condiciones de intervención y evidencia P1–P8. No presentarlos como perfiles demográficos ni como validación de usuarios. |
| A06-15 | Capítulo 5 | Mantener y ampliar | Las preguntas y H1 están alineadas, pero faltan definiciones operacionales y preguntas secundarias formalizadas. | Incorporar la matriz QI/QP–H1–H4 y distinguir hipótesis central, preguntas exploratorias y supuestos técnicos. |
| A06-16 | Tabla 3 de criterios | Mantener y ampliar | Los criterios traducen la teoría a diseño y protegen la autonomía. | Añadir fuente o tipo de respaldo a cada criterio: literatura, entrevista, decisión del autor o riesgo. Separar criterio de diseño de resultado esperado. |
| A06-17 | Capítulo 6 | Mantener y ampliar | El mercado está organizado por mecanismo y reconoce los límites de fuentes comerciales. | Añadir fecha de consulta, versión o disponibilidad comprobada por referente; evitar afirmar una brecha total. La frase sobre no identificar una solución debe quedar como resultado de búsqueda acotado, con alcance y método de búsqueda. |
| A06-18 | Capítulo 7 | Mantener y reemplazar | La comparación de tres familias es decisión del autor, no preferencia de usuarios. La forma seleccionada aparece antes de comprobar asociación, percepción y carga. | Nombrar la dirección como alternativa conceptual seleccionada provisionalmente. Retirar lenguaje de «mejor ajuste» o acompañarlo de criterios ponderados y límites. |
| A06-19 | Capítulo 8 | Mantener y ampliar | La propuesta phygital, sin pantalla, es comprensible. La secuencia mezcla comportamiento diseñado con comportamiento ya implementado. | Usar «la propuesta contempla», «el sistema debería» y «en el escenario de uso» hasta que existan pruebas. Separar especificación actual, hipótesis de interacción y requisito de validación. |
| A06-20 | 8.3 Modalidad y control | Reemplazar parcialmente | Duraciones, frecuencias y gestos aparecen como especificaciones antes de probarse. | Presentarlos como patrón inicial de prototipo. Explicar el origen de cada cifra o retirarla del cuerpo y conservarla en el anexo técnico. |
| A06-21 | 8.4 Privacidad | Ampliar | Se declara procesamiento local y ausencia de rastreo, pero no hay inventario de datos, retención, borrado, permisos y fallos. | Crear una tabla de datos: dato, origen, propósito, ubicación, retención, eliminación, exposición y riesgo. No afirmar «privado» sin esa especificación. |
| A06-22 | Capítulo 9 y Anexo C | Mantener y ampliar | La distinción entre BOM, costo profesional, precio y certificación es correcta. | Definir BOM en español, separar costo de prototipo/costo de fabricación/precio y verificar fuentes técnicas y regulatorias antes de una versión de entrega. |
| A06-23 | Capítulo 10 | Reemplazar título y arquitectura | «Metodología de prototipado y validación» puede hacer pensar que existe validación realizada. | Mientras no haya datos, usar «Plan de prototipado y evaluación». Añadir una futura sección «Resultados de evaluación» que permanezca vacía o marcada como pendiente hasta ejecutar pruebas. |
| A06-24 | Tabla 6 y Tabla 12 | Reemplazar y ampliar | Son planes útiles, pero no contienen todos los campos exigidos por 07_validacion. | Convertir cada etapa en ficha: pregunta, hipótesis, variable manipulada, resultados, muestra, procedimiento, controles, instrumento, criterio de análisis, riesgos, éxito formativo, fallo y decisión. |
| A06-25 | Indicadores | Reemplazar parcialmente | «Recuerdo confiable», «reconsideración», «autonomía», «intrusión» y «preferencia» no tienen definición de medición suficiente. | Crear un diccionario de indicadores con definición, pregunta o tarea, momento, codificación y límite interpretativo. |
| A06-26 | Tabla 13 | Ampliar y reemplazar umbrales | Mantener/modificar/abandonar es una estructura adecuada, pero 4/5 y dos participantes pueden parecer evidencia general. | Nombrar las reglas como puertas formativas. Explicar el riesgo que cada una controla y añadir qué ocurre si los datos son mixtos o inconclusos. |
| A06-27 | Capítulo 11 | Mantener y ampliar | La separación entre flujo de usuario, flujo técnico y flujo de diseño responde a una necesidad real. | Distinguir flujo propuesto, flujo simulado y flujo validado. No escribir «Android evalúa» como capacidad demostrada mientras no exista integración. |
| A06-28 | Capítulo 12 | Reemplazar completamente | El cierre es coherente con el argumento, pero «termina», «gana viabilidad» y «queda definido» adelantan conclusiones que la validación aún no puede sostener. | Reescribir como cierre provisional de investigación y diseño: hallazgos, decisiones, contribución esperada, límites, no-resultados y siguiente decisión crítica. |
| A06-29 | Referencias | Mantener y auditar | La lista está ordenada y la mayoría de las entradas tienen correspondencia en el cuerpo. La mención de AirTag no tiene cita autor-fecha explícita. | Añadir (Apple Inc., s. f.) o retirar la comparación. Verificar todas las entradas con una matriz cita–referencia y aplicar una convención única de APA 7 en español. |
| A06-30 | Fuentes anteriores a 2019 | Ampliar | Se usan fuentes fundacionales pertinentes, pero no siempre se explica por qué una fuente antigua sigue siendo necesaria. | En la ficha bibliográfica marcar función fundacional, reemplazable o vigente. Reforzar con estudios posteriores cuando la afirmación sea empírica y no conceptual. |
| A06-31 | Anexo A | Mantener y corregir edición | La trazabilidad del corpus protege el anonimato y transparenta sus límites. Las citas conservan faltas ortográficas sin [sic]. | Parafrasear los fragmentos o señalarlos con [sic]; conservar la nota sobre ortografía original solo si es metodológicamente necesaria. |
| A06-32 | Anexo D | Mantener como instrumento | El protocolo es valioso, pero no debe confundirse con resultados. | Etiquetar cada tabla como «plan previsto al 24-08-2026» y añadir versión, fecha de congelamiento y responsable de cambio. |
| A06-33 | Anexo E | Mantener con ajuste institucional | La declaración diferencia las entrevistas reales del uso posterior de asistencia automatizada. | Confirmar qué exige la normativa institucional y separar transcripción/formalización de generación, búsqueda y edición. No usarla para sustituir la trazabilidad de fuentes. |
| A06-34 | Registro de cambios | Mantener en GitHub, retirar de copia de entrega | Es obligatorio para la gobernanza del repositorio, pero el detalle de migración DOCX y cell_replacement es metalenguaje en una memoria académica. | Mantenerlo en Markdown de trabajo y producir una copia de entrega sin el registro interno, si la pauta institucional no lo solicita. |

## 6. Riesgos críticos

| Prioridad | Riesgo | Por qué compromete el Proyecto de Título | Control exigido |
| --- | --- | --- | --- |
| Crítico | Convertir el plan en resultado | La memoria puede parecer demostrar recuerdo, autonomía, aporte físico o factibilidad sin una sola ejecución registrada. | Separar «realizado», «propuesto» y «pendiente» en resumen, capítulos 8–12 y conclusiones. |
| Crítico | Condición operacional sin resolver | Sin saber qué evento activa el testigo no se puede interpretar una prueba integrada ni comparar el sistema con una notificación. | Congelar una condición mínima para el prototipo o declarar que la primera etapa estudia solo asociación con activación manual. |
| Crítico | Ausencia de línea de base | Sin comprobar si la intención estaba presente antes de la señal, «recuperación» puede ser reconocimiento inducido. | Pregunta o tarea pre-señal, registro de intención activa y definición de intervalo de recuerdo. |
| Crítico | Confundir recuerdo con cambio de conducta | La señal puede ser recordada sin que la persona cambie su decisión; actuar tampoco es el único resultado legítimo. | Mantener resultados separados y no usar «eficacia» como sinónimo de iniciar la actividad. |
| Crítico | Comparación física–notificación incompleta | Sin una comparación ejecutable, la razón de ser del objeto queda como intuición formal. | Definir tareas equivalentes, orden, texto de la notificación, tiempo de exposición, carga y pregunta sobre aporte específico. |
| Alto | Umbrales numéricos sin fundamento | 4/5, 90 %, 100 activaciones y 30 días pueden producir falsa certeza. | Clasificar cada cifra y eliminarla cuando no controle un riesgo concreto. |
| Alto | Protocolos no reproducibles | Otra persona no podría ejecutar el plan sin decidir intervalos, ayudas, orden, codificación y criterios de interrupción. | Fichas protocolarias completas y versión congelada antes del trabajo de campo. |
| Alto | Muestra de junio sobreinterpretada | Ocho entrevistas por conveniencia no representan un mercado ni permiten construir biografías generales. | Mantener P1–P8 como casos y patrones situacionales; usar verbos de alcance: «aparece», «se observa en este corpus», «orienta». |
| Alto | Problemas éticos de la próxima fase | El consentimiento oral de junio no cubre automáticamente activaciones, registros técnicos, fotografías, convivencia ni citas de nuevas pruebas. | Crear consentimiento específico antes de reclutar para evaluación y registrar qué datos se recogerán. |
| Alto | Promesa de privacidad no especificada | «Procesamiento local» no informa qué permisos existen, cuánto se retiene ni qué queda visible en Android. | Inventario de datos, permisos y retención; separar privacidad del testigo y privacidad de la aplicación. |
| Medio | Meta-lenguaje en la entrega | Las referencias a DOCX, tablas convertidas, encargos o sustituciones distraen del argumento y revelan la infraestructura de edición. | Mantener trazabilidad en el repositorio y exportar una versión académica limpia. |
| Medio | Citas y referencias no reconciliadas | Una fuente comercial o técnica puede describir una función, pero no probar eficacia; una entrada no citada rompe la trazabilidad. | Auditoría cita–referencia, ficha de fuente y revisión independiente de toda afirmación dinámica. |
| Medio | Conceptos técnicos sin definición | MVP, BOM, BLE, LRA, CMF, TPE, SLS, SLA, UsageStatsManager y CompanionDeviceManager pueden excluir a lectores no técnicos. | Glosario o primera definición breve; trasladar detalle de componentes al anexo. |

## 7. Correcciones concretas para la reescritura

### 7.1 Reestructurar la parte de evaluación

La estructura recomendada para el bloque de evaluación es:

1. **Propósito de la evaluación:** qué decisión de diseño debe informar cada prueba.
2. **Hipótesis y preguntas secundarias:** H1–H4, con estado de cada una.
3. **Variables y resultados:** definición operacional, unidad de análisis y criterio de codificación.
4. **Protocolos:** una ficha por etapa, no solo una tabla resumen.
5. **Criterios de interpretación:** qué significa resultado favorable, mixto, inconcluso o negativo.
6. **Criterios de modificación y abandono:** separados para concepto, forma, modalidad, técnica y adopción.
7. **Resultados:** sección reservada para datos observados, contraejemplos y decisiones posteriores.
8. **Limitaciones:** qué no fue posible probar y cómo afecta el alcance.

Hasta que existan ejecuciones, el título del capítulo debe ser **Plan de prototipado y evaluación**. «Validación» puede aparecer como propósito metodológico, no como estado alcanzado.

### 7.2 Ficha mínima de cada protocolo

Cada protocolo debe responder, en este orden:

- **Pregunta:** qué se intenta decidir.
- **Hipótesis:** qué patrón se espera y qué resultado la debilitaría.
- **Muestra:** quién participa, por qué, cuántos casos y qué no representa.
- **Manipulación o comparación:** qué cambia entre condiciones.
- **Controles:** orden, familiaridad, intención, ubicación, distancia, superficie y ayudas.
- **Procedimiento:** instrucciones, duración, intervalo de recuerdo, posibilidad de consulta y cierre.
- **Indicadores:** qué se observa, pregunta o mide.
- **Codificación:** exacto, parcial, error, consulta, no percibido, rechazo, abandono u otra categoría.
- **Criterio formativo:** qué patrón permite mantener o modificar.
- **Fallo:** qué resultado muestra que esa prueba o componente no cumple su función.
- **Abandono:** qué resultado hace descartar la hipótesis o el componente después de considerar alternativas.
- **Riesgos:** privacidad, convivencia, carga, aprendizaje, exposición, accesibilidad, técnica y bienestar.
- **Uso del resultado:** decisión concreta que se tomará con los datos.

### 7.3 Definiciones operacionales obligatorias

La reescritura debe fijar, antes de cualquier ejecución, estas definiciones:

| Concepto | Definición de trabajo recomendada |
| --- | --- |
| Recuperación de intención | Mención espontánea de la actividad autoelegida después de la señal, sin consultar la aplicación ni recibir una pista semántica. |
| Recuperación del primer paso | Mención espontánea de la primera acción concreta asociada con esa actividad. |
| Recuerdo exacto | Intención y primer paso coinciden con lo configurado, con una tolerancia previamente descrita para sinónimos. |
| Recuerdo parcial | Se identifica solo la intención o solo el primer paso, o la respuesta es demasiado general para considerarse exacta. |
| Consulta | La persona mira o abre el teléfono para reconstruir el significado antes de responder. |
| Reconsideración | La persona declara que volvió a considerar qué hacer, sin que ello implique que cambió su conducta. |
| Autonomía percibida | Evaluación de si la señal fue entendida como una opción que podía aceptarse, ignorarse o silenciarse. |
| Intrusión | Evaluación de interrupción no deseada de la actividad digital o del entorno doméstico. |
| Valor físico específico | Aporte que la persona puede explicar como consecuencia de la presencia, ubicación o interacción del testigo y que una notificación textual no entrega de la misma forma. |
| Activación tardía | Señal ejecutada después de que venció la ventana o perdió pertinencia, aunque el enlace se haya recuperado. |
| Abandono del componente | Decisión de retirar una característica o hipótesis porque no cumple su función o añade una carga que el aporte no compensa. |
| Retiro de participante | Salida voluntaria de una persona de una prueba; no es un fallo del producto ni un abandono de la hipótesis. |

### 7.4 Propuesta de reglas de decisión sin falsa precisión

La memoria puede conservar puertas de decisión, pero deben vincularse a riesgos y no presentarse como pruebas de eficacia. Se recomienda:

- Para **asociación**, informar por participante y condición los casos exactos, parciales, erróneos y con consulta. Mantener la hipótesis solo si aparece un patrón claro y repetido de asociación congruente que no dependa de una explicación posterior del investigador.
- Para **forma y gesto**, mantener una alternativa solo si las personas pueden situar, armar, silenciar y desarmar con comprensión suficiente y sin que el gesto se interprete como castigo o alarma. Si existe confusión, modificar antes de probar el sistema integrado.
- Para **modalidad**, no buscar un canal universal. Conservar perfiles configurables solo si se identifica al menos una combinación perceptible y tolerable para cada contexto estudiado, documentando los casos en que no funciona.
- Para **aporte físico**, exigir una razón específica y observable para preferir el testigo situado. Si la comparación empata y el objeto agrega costo, permisos o carga sin un valor identificable, debe replantearse o abandonarse.
- Para **técnica**, reportar cada modelo de teléfono, versión, número de eventos, latencia, fallos y activaciones tardías. Una tasa agregada no puede ocultar una falla grave en un modelo.
- Para **adopción**, registrar rearmado, pérdida, habituación, modificación y retiro. No llamar «adopción» a una intención declarada de uso ni a un piloto demasiado breve.

## 8. Política editorial propuesta

### 8.1 Estados epistémicos y tiempos verbales

La memoria debe aplicar esta política en todos los capítulos:

| Estado | Tiempo y verbos recomendados | Verbos que deben evitarse |
| --- | --- | --- |
| Hecho realizado | «se realizaron», «el registro muestra», «se observó», «la fuente informa» | «demuestra» cuando el estudio no permite esa fuerza. |
| Interpretación | «sugiere», «permite interpretar», «orienta», «es consistente con» | «confirma» si no existe contraste suficiente. |
| Hipótesis | «se plantea», «se propone evaluar», «podría», «se espera explorar» | «funciona», «permite» o «favorece» como hecho. |
| Decisión | «se decidió», «la propuesta adopta», «se excluye por» | «era inevitable», «es la única solución». |
| Plan | «se evaluará», «se registrará», «queda previsto» | «se validó», «se obtuvo», «las personas prefirieron». |
| Resultado | «los datos observados indican», con muestra y protocolo | «el sistema es eficaz» sin resultado comparativo suficiente. |
| Límite | «no se puede inferir», «no se observó», «queda fuera del alcance» | Ocultar el vacío mediante una cifra o una formulación absoluta. |

### 8.2 Política contra AI slop y repetición

Cada párrafo debe cumplir una función verificable: introducir un problema, presentar evidencia, interpretarla, justificar una decisión, describir una condición, reportar un resultado o declarar un límite. Si un párrafo solo repite que Relevo no bloquea, no evalúa y devuelve una intención, debe integrarse en la primera definición y citarse después como criterio.

La revisión final debe eliminar:

- frases de introducción que no agregan contexto;
- adjetivos como «simple», «intuitivo», «innovador», «significativo» o «natural» sin criterio observable;
- enumeraciones de componentes sin función ni consecuencia;
- conclusiones que repiten el resumen palabra por palabra;
- atribuciones genéricas a «la sociedad», «los usuarios» o «la tecnología» sin fuente;
- afirmaciones que presentan una decisión formal como preferencia de usuarios;
- lenguaje de proceso editorial, migración, encargo o conversación dentro del cuerpo académico;
- citas añadidas solo para decorar un párrafo, sin explicar qué cambia en el proyecto.

### 8.3 Glosario y consistencia terminológica

Antes de la versión de entrega se debe establecer un glosario breve. Como mínimo, la primera aparición debe explicar:

- **phygital:** sistema en que las dimensiones física y digital se articulan como una única experiencia, no como piezas independientes;
- **memoria prospectiva:** capacidad de recordar realizar una acción prevista;
- **descarga de intenciones:** externalización parcial de una intención en una señal o recurso del entorno;
- **producto mínimo viable (MVP):** versión acotada que permite probar una hipótesis central, no sinónimo de producto terminado;
- **Bluetooth Low Energy (BLE):** protocolo inalámbrico de bajo consumo usado aquí como hipótesis de comunicación;
- **BOM o lista de materiales:** relación de componentes y costos directos de fabricación, separada del trabajo profesional y del precio;
- **Wizard of Oz:** prototipo en que una persona o control externo simula una función para evaluar la experiencia antes de automatizarla;
- **LRA:** actuador resonante lineal para producir vibración;
- **cognición situada:** enfoque que entiende que la actividad cognitiva se apoya parcialmente en la relación con el entorno, el cuerpo y los objetos.

Los detalles de UsageStatsManager, CompanionDeviceManager, ESP32-C3, nRF52810/11, DRV2605L, TPE, SLA, SLS, PC/ABS, CMF, UWB y NFC deben permanecer en el anexo técnico, cada uno con definición y fuente primaria. En el cuerpo basta explicar qué decisión de experiencia afectan.

### 8.4 Política de citas y referencias APA 7

La auditoría preliminar encuentra una correspondencia bibliográfica alta, pero no una auditoría cerrada. Deben ejecutarse estas correcciones:

- añadir cita autor-fecha a la afirmación sobre la compacidad de AirTag o retirar la mención;
- producir una tabla de control con tres columnas: cita en el cuerpo, entrada en referencias y función de la fuente;
- comprobar que toda fuente citada aparece una sola vez con el año y sufijo correctos;
- comprobar que toda entrada de referencias se utiliza o se elimina;
- separar fuentes académicas, técnicas, regulatorias y comerciales en el análisis, aunque la lista final siga la norma APA;
- justificar en una ficha interna el uso de fuentes anteriores a 2019 cuando cumplen una función fundacional;
- no usar una página comercial para afirmar eficacia, bienestar o cambio conductual;
- verificar nuevamente fechas, funciones de producto, precios, especificaciones y normativa antes de la entrega;
- mantener títulos, DOI, URL, fechas de recuperación, cursivas y autores corporativos con una única convención de APA 7 en español;
- no incorporar una referencia porque la IA la sugirió sin consultar la publicación o página original.

### 8.5 Citas de entrevistas y ortografía del corpus

Los fragmentos de P1–P8 deben continuar anonimizados. Como el registro disponible es una transcripción posterior y no un audio publicable, se recomienda preferir paráfrasis analíticas y conservar citas breves solo cuando aporten una formulación relevante.

Si se conserva la ortografía original, una forma como «No tenia noción de el tiempo» debe señalarse con [sic] o reemplazarse por una paráfrasis. No se debe corregir silenciosamente una cita ni convertir una transcripción formalizada en una cita literal. La memoria debe indicar en el método si los fragmentos fueron transcritos literalmente, normalizados o solo utilizados como evidencia de codificación.

## 9. Cierre honesto de Proyecto de Título en curso

La conclusión actual debe dejar de sonar como el final de una validación ya realizada. La siguiente formulación puede orientar la reescritura:

> Hasta esta etapa, el proyecto permitió precisar un problema de diseño: en algunas sesiones de ocio digital, una intención autoelegida puede perder disponibilidad para la decisión sin que la duración de la sesión permita determinar por sí sola si el ocio fue valioso o problemático. Las ocho entrevistas exploratorias no establecen prevalencia, pero aportan casos contrastantes que justifican distinguir entre continuidad con intención desplazada y ocio digital elegido y valorado. La revisión teórica y de referentes permite formular una hipótesis de diseño: una señal externa, configurada por la persona y situada junto al primer paso de una actividad, podría apoyar la recuperación de esa intención sin bloquear ni evaluar.
>
> En respuesta, Relevo se formula provisionalmente como un sistema phygital compuesto por una aplicación y un testigo físico sin pantalla situado en un lugar elegido. La decisión de excluir texto, bloqueo, ranking y registro de cumplimiento protege el carácter autónomo de la intervención, pero también crea el principal riesgo del proyecto: que el testigo se perciba como una alarma genérica o no entregue un valor distinto de una notificación. Por esta razón, la contribución todavía no consiste en demostrar eficacia, sino en convertir ese riesgo en una pregunta evaluable mediante asociación espacial, comprensión, modalidades, comparación de medios e integración técnica.
>
> No se han ejecutado las pruebas de prototipo descritas en el plan. Por ello, no es posible concluir que la señal favorezca el recuerdo, que la ubicación congruente sea superior, que el objeto sea preferible a una notificación, que la persona cambie de actividad, que la autonomía se preserve en uso doméstico o que exista un precio viable. El siguiente cierre sustantivo debe comenzar por la condición de activación y la prueba de asociación con activación simulada; los resultados deberán informar si se mantiene, modifica o abandona la dirección física antes de completar la automatización Android.

Este cierre responde a la investigación sin prometer más de lo que existe. También identifica la contribución disciplinar en términos verificables: diseñar y documentar una hipótesis phygital situada, con límites de autonomía, criterios de descarte y una comparación explícita con una solución digital equivalente.

## 10. Listas verificables para la reescritura final

### 10.1 Lógica y evidencia

- [ ] Cada afirmación importante está clasificada como hecho, evidencia de participante, interpretación, hipótesis, decisión o pendiente.
- [ ] La pregunta de investigación aparece con una respuesta provisional y un límite explícito.
- [ ] H1 está conectada con una manipulación, un resultado y un protocolo.
- [ ] H2–H4 están formalizadas como hipótesis secundarias o reducidas a preguntas de diseño.
- [ ] Se distingue estudio exploratorio de entrevistas y evaluación del prototipo.
- [ ] Ningún caso P1–P8 se presenta como representante del mercado.
- [ ] El usuario principal y el usuario límite se fundamentan con evidencia y condiciones situacionales.
- [ ] Se identifica evidencia favorable y contradictoria, incluido P7 como caso negativo.
- [ ] Cada decisión formal, técnica y de alcance tiene razón, alternativa descartada y condición de cambio.

### 10.2 Validación y resultados

- [ ] El capítulo se titula «Plan de prototipado y evaluación» mientras no existan ejecuciones documentadas.
- [ ] Cada protocolo contiene pregunta, hipótesis, muestra, procedimiento, variables, indicadores, riesgos y uso del resultado.
- [ ] El intervalo de recuerdo está definido.
- [ ] El estado previo de la intención se mide o se reconoce como límite.
- [ ] La unidad de análisis está fijada.
- [ ] Recuerdo exacto, parcial, error, consulta y no respuesta tienen codificación previa.
- [ ] Se separan señal entregada, señal percibida, atribución, recuerdo, reconsideración y conducta.
- [ ] Se define cómo se controlará el aprendizaje y el orden de condiciones.
- [ ] El contraste con notificación tiene equivalencia de intención, orden, texto y tiempo.
- [ ] Los umbrales numéricos tienen razón declarada o se renombran como metas formativas.
- [ ] Fallo de prueba, fallo técnico, abandono de componente y retiro de participante no se confunden.
- [ ] No se escribe ningún resultado futuro en tiempo pasado.
- [ ] Los datos futuros tendrán tabla de casos, contraejemplos, limitaciones y decisión derivada.

### 10.3 Conclusiones

- [ ] La conclusión responde la pregunta y no solo resume capítulos.
- [ ] El problema de diseño se formula sin volver a medir calidad de ocio por minutos.
- [ ] La contribución phygital se describe como mecanismo y criterio, no solo como forma.
- [ ] Se declara qué parte está demostrada, qué parte es inferencia y qué parte es hipótesis.
- [ ] Se declara de forma directa que todavía no hay validación de producto.
- [ ] Se incluye el valor de la comparación con una notificación como condición de legitimidad del objeto.
- [ ] Se incluyen limitaciones del corpus, del método, de la tecnología y del estado de desarrollo.
- [ ] Se define un único siguiente paso sustantivo: asociación espacial con activación simulada y condición de activación acotada.
- [ ] No se afirma precio, adopción, autonomía, eficacia o preferencia sin datos propios.

### 10.4 Editorial, ortografía y APA

- [ ] Se retiran del cuerpo los comentarios sobre DOCX, migración, tablas convertidas, entregas y sustituciones internas.
- [ ] Se genera el índice después de la maquetación y no se conservan páginas provisionales.
- [ ] Se define cada concepto técnico en su primera aparición o se mueve al anexo.
- [ ] Se reemplazan formulaciones repetidas por una definición canónica y referencias internas.
- [ ] Se revisan tildes, concordancia, mayúsculas, guiones, términos ingleses y uso consistente de «aplicación», «testigo» y «señal».
- [ ] Las citas textuales del corpus son literales, breves, anonimizadas y llevan [sic] cuando corresponde, o se presentan como paráfrasis.
- [ ] Todas las citas del cuerpo tienen entrada en referencias.
- [ ] Todas las entradas de referencias tienen uso identificable; en particular, se corrige la mención sin cita de AirTag.
- [ ] Se distinguen fuentes académicas, técnicas, regulatorias y comerciales en la argumentación.
- [ ] Los datos dinámicos se verifican con fecha próxima a la entrega.
- [ ] La declaración de uso de inteligencia artificial coincide con el proceso real y no reemplaza la autoría ni la verificación de fuentes.
- [ ] Se conserva un Markdown con registro de cambios y se prepara una copia académica limpia si la institución no solicita el historial.

## 11. Decisión recomendada para la fase siguiente

No se recomienda ampliar todavía la automatización, la visualidad ni el detalle industrial. La única fase sustantiva siguiente debe ser cerrar la definición operacional y ejecutar la primera prueba de asociación sin pantalla con activación simulada. Esa prueba debe responder si una persona puede reconstruir la intención y el primer paso a partir de la relación entre testigo, lugar e intención, y si aparece un problema de alarma genérica, consulta obligada o baja saliencia.

Si esa asociación no aparece, la memoria debe registrar el resultado como una razón para modificar o abandonar la dirección del objeto, no como una falla del participante. Si aparece, recién entonces corresponde decidir modalidad, forma, condición Android y comparación con notificación. Esta secuencia mantiene el sentido disciplinar del proyecto: la tecnología queda subordinada a una pregunta de experiencia y el objeto debe justificar su existencia mediante un aporte específico.

---

## Registro de cambios (disclaimer)

### 2026-08-24 — Creación del informe de Auditoría 6

- **Cambio:** se creó este informe para auditar la correspondencia entre pregunta, hipótesis, métricas, protocolos, criterios de decisión, conclusiones, citas, referencias y calidad editorial de la memoria vigente.
- **Versión anterior:** no existía un informe específico que revisara de manera conjunta 07_validacion, la ausencia de resultados ejecutados, la pseudo-precisión de los umbrales y el cierre de Proyecto de Título.
- **Motivo:** evitar que un plan de evaluación se lea como validación realizada y establecer una política de escritura académica honesta para la siguiente reescritura.
- **Alcance:** este archivo propone correcciones y criterios; no modifica memoria-vigente.md, no incorpora resultados inexistentes, no reemplaza protocolos ejecutados y no constituye una conclusión final del proyecto.
- **Archivos no modificados:** 08_memoria/memoria-vigente.md y 07_validacion/README.md.
- **Pendientes derivados:** reestructurar el capítulo de evaluación, formalizar H2–H4, definir variables y codificación, ejecutar la primera prueba de asociación, auditar APA 7 con una matriz cita–referencia y reescribir las conclusiones.

### 2026-09-02 — Normalización del nombre del archivo

- **Cambio:** se normalizó el nombre del archivo para describir directamente su función: validación y calidad editorial.
- **Cómo estaba antes:** el archivo llevaba un nombre compuesto que mezclaba su función con el origen de la revisión.
- **Motivo:** facilitar la navegación del repositorio y mantener separadas las auditorías temáticas, sin modificar su diagnóstico ni sus pendientes.
