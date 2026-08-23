---
id: FL-S2-MEM-001
titulo: "Memoria actualizada — Encargo 16"
autoria: propia
estado_documental: histórico
relacion_con_proyecto: "versión anterior de la memoria del semestre 2"
sensibilidad: anonimizada
fuente_local_relativa: "SEMESTRE 2/output/Johan Yanten - Memoria actualizada Encargo 16.docx"
formato_fuente: docx
fuente_sha256: bfab2d35792e26ab51d8b5bf7c7cecb944dbd4805c6e017e4777890879343915
modificacion_local: "2026-08-15T18:16:57-04:00"
metodo_conversion: "extracción estructural de párrafos, listas y tablas mediante OOXML"
fecha_migracion: 2026-08-23
---

# Memoria actualizada — Encargo 16

## Nota archivística

Versión propia anterior a las ramas denominadas Perfeccionada y Sistema editorial v3. Se archiva sin declararla vigente.

La fuente contiene 312 párrafos, 9 tablas y 3 formas en línea. Se detectaron 3 archivos de medios internos. Los medios se registran en un manifiesto separado y no se publican en esta fase porque la entrega actual no exige visualidad y primero debe resolverse la duplicación entre versiones.

## Contenido migrado

**UNIVERSIDAD DIEGO PORTALES  ·  FACULTAD DE ARQUITECTURA, ARTE Y DISEÑO**

**DE LA CONTINUIDAD
AUTOMÁTICA A LA
DECISIÓN SITUADA**

Investigación en diseño sobre una pausa físico-digital no punitiva para el ocio doméstico de adultos jóvenes

**MEMORIA DE PROYECTO DE TÍTULO
SEGUNDO SEMESTRE · ENCARGO 16**

**Johan Yantén**

Profesores guía: Sergio Majluf y Simón Gallardo

Santiago de Chile · 15 de agosto de 2026

## Resumen

El ocio digital no siempre continúa por una decisión renovada. En algunas sesiones, una persona abre una aplicación por un momento, permanece en ella de forma automática y deja de considerar actividades que también quería realizar. Esta investigación aborda esa brecha en adultos jóvenes y pregunta cómo el diseño puede devolver una intención a la decisión sin castigar el ocio digital ni convertir el descanso en una exigencia de rendimiento.

La etapa de Seminario combinó revisión bibliográfica en experiencia subjetiva del ocio, arquitecturas de atención y mediación material de información personal; ocho entrevistas semiestructuradas exploratorias realizadas en Santiago; y el análisis comparativo de seis referentes. Los hallazgos mostraron estrategias informales de separación del teléfono, actividades concretas que las personas querían retomar y rechazo hacia devoluciones basadas en notas, rachas o comparación. La síntesis de estas fuentes exigió acotar el contexto doméstico, separar experiencia y arquitectura técnica, y explicitar criterios de autonomía, accesibilidad, factibilidad y fracaso.

Esta versión responde a esas observaciones mediante un MVP acotado. La investigación conduce a Relevo, un testigo físico doméstico al que la persona entrega una intención y sitúa junto al primer paso necesario para realizarla. Una aplicación Android cumple funciones secundarias de configuración y detección. Cuando una aplicación seleccionada alcanza un umbral, el testigo devuelve la intención mediante texto, icono y una señal periférica. La persona puede iniciar, continuar, posponer o desactivar. Se propone validar primero el valor de la pausa material con activaciones simuladas; solo después se integra la detección real de uso. El aporte esperado no es disminuir tiempo de pantalla, sino convertir una continuación automática en una elección explícita entre formas de ocio igualmente legítimas.

**Palabras clave:** ocio digital automático; toma de decisiones; bienestar digital; interacción físico-digital; diseño de interacción; autonomía.

## Abstract

Digital leisure does not always continue through a renewed decision. In some sessions, a person opens an app briefly, remains in it automatically, and stops considering activities they also intended to pursue. This study examines that gap among young adults and asks how design can return an intention to the decision without punishing digital leisure or turning rest into a performance demand.

The Seminar stage combined a literature review on the subjective experience of leisure, attention architectures, and the material mediation of personal information; eight exploratory semi-structured interviews conducted in Santiago; and a comparative analysis of six references. Findings revealed informal strategies for separating from the phone, concrete activities participants wished to resume, and rejection of feedback based on scores, streaks, or comparison. Synthesizing these sources required narrowing the domestic context, separating experience from technical architecture, and defining explicit criteria for autonomy, accessibility, feasibility, and failure.

This revision addresses those issues through a bounded MVP. The research leads to Relevo, a domestic physical token to which a person entrusts an intention and places beside the first step required to pursue it. An Android app performs the secondary functions of configuration and detection. When a selected app reaches a threshold, the token returns the intention through text, an icon, and a peripheral signal. The person can start, continue, postpone, or disable the rule. Validation first tests the value of the material pause with simulated activations; real usage detection is integrated only afterward. The intended contribution is not to reduce screen time, but to turn automatic continuation into an explicit choice between equally legitimate forms of leisure.

**Keywords:** automatic digital leisure; decision-making; digital wellbeing; physical-digital interaction; interaction design; autonomy.

## Índice

1. Motivación personal

2. Introducción y delimitación

3. Planteamiento del problema

4. Justificación

5. Antecedentes y estado de la cuestión

6. Marco teórico

7. Usuario, contexto y entrevistas

8. Estado del arte y contexto de producto

9. Criterios de diseño

10. Formulación: de la investigación al proyecto

11. Propuesta proyectual: Relevo

12. Factibilidad, costos y límites

13. Metodología, validación y cronograma

14. Encargo 16: arquitectura de experiencia

15. Conclusiones

16. Referencias

Anexo A. Pauta de entrevista semiestructurada

## 1. Motivación personal

Mi interés nació de una situación cotidiana: abrir una aplicación por unos minutos, quedarme más de lo previsto y terminar sin recordar qué había visto, mientras actividades que sí quería realizar —dibujar, leer o salir a caminar— dejaban de estar presentes. No había decidido abandonarlas; simplemente ya no estaban participando de la decisión.

Durante un tiempo interpreté esa experiencia como falta de disciplina. Esa explicación era insuficiente porque no consideraba el diseño de las plataformas, la formación de hábitos ni la diferencia entre querer una actividad y recordarla en el momento oportuno. Tampoco distinguía una sesión digital elegida y satisfactoria de otra que se prolonga de manera reactiva.

El proyecto comenzó preguntando por el tiempo de pantalla y la memoria de lo vivido. La investigación y su revisión crítica obligaron a precisar el foco: el problema abordable desde diseño no es demostrar que el teléfono daña la memoria, sino intervenir el momento en que una intención propia deja de participar en una decisión. Este desplazamiento evita diagnosticar a la persona y permite trabajar con variables concretas de diseño: qué activa la pausa, dónde aparece, qué comunica, qué control conserva el usuario y cómo se comprueba el aporte del objeto físico.

No busco eliminar el teléfono ni establecer una forma correcta de descansar. Quiero diseñar una oportunidad comprensible para elegir de nuevo.

## 2. Introducción y delimitación

Tomar el teléfono, abrir una aplicación y permanecer en ella puede ocurrir sin una decisión explícita sobre cómo ocupar el tiempo libre. La sesión puede resultar entretenida y, aun así, extenderse mientras otras actividades que también importaban dejan de ser consideradas. No fueron rechazadas: dejaron de estar disponibles como alternativas en ese momento.

El ocio digital no constituye por sí mismo un problema. Puede ofrecer descanso, vínculo social, aprendizaje o disfrute. Una sesión extensa tampoco es necesariamente negativa si fue elegida. El foco de esta investigación son episodios iniciados o prolongados de forma automática que la persona no reconoce después como una decisión renovada. La duración describe cuánto tiempo pasó, pero no explica si ese tiempo fue deseado, significativo o coherente con otras intenciones.

La unidad de diseño relevante es, por tanto, la decisión. La investigación no pregunta cuánto tiempo debería usar una persona su teléfono; pregunta bajo qué condiciones una actividad que ella misma eligió puede volver a ser considerada cuando el uso automático ya está en curso.

### 2.1 Qué, quién, cuándo, dónde y por qué

> **Tabla 1:** conversión estructural desde la tabla de Word.

| Pregunta | Delimitación de la investigación |
| --- | --- |
| ¿Qué se observa? | Sesiones de ocio digital que comienzan o continúan de modo reactivo mientras una intención previa deja de participar en la decisión. |
| ¿A quiénes? | Adultos jóvenes que reconocen esa brecha y no buscan eliminar el ocio digital. |
| ¿Cuándo? | Durante tiempo libre doméstico, una vez que la continuidad automática ya está en curso. |
| ¿Dónde? | En el hogar, donde las actividades alternativas poseen objetos, lugares y primeros pasos reconocibles. |
| ¿Por qué abordarlo desde diseño? | Porque el momento, el canal, el lenguaje, la fricción y las salidas disponibles son decisiones proyectuales, no propiedades inevitables del teléfono. |

### 2.2 Alcance de la investigación

El problema general puede aparecer en el metro, la universidad, el trabajo o la cama. Resolver todos esos contextos produciría una propuesta difusa y técnicamente inmanejable. La investigación se limita al hogar porque allí las intenciones se relacionan con objetos, lugares y primeros pasos concretos; además, es posible observar la convivencia y realizar pruebas repetidas bajo condiciones estables.

La primera iteración considera una sola persona adulta joven, una intención activa, una aplicación de ocio seleccionada y un lugar doméstico asociado a un primer paso. Este recorte no niega otros contextos ni plataformas; establece una condición de aprendizaje. Si el mecanismo no aporta valor en ese escenario controlable, ampliarlo carecería de fundamento.

### 2.3 Orden de investigación y proyecto

La solución no se adopta como punto de partida. Primero se define la experiencia que necesita explicación; luego se contrastan teoría, entrevistas y referentes; de esa convergencia se extraen criterios; y solo entonces se formula el proyecto. Este orden permite que la forma final pueda cambiar sin perder el problema investigado y evita usar una demostración tecnológica como justificación retrospectiva.

La plataforma se decide más adelante como condición del prototipo, no como parte del problema. Android se selecciona para la iteración integrada, pero las primeras pruebas emplean activaciones simuladas. Así se puede descartar o modificar la pausa antes de invertir en una automatización cuyo funcionamiento en segundo plano todavía debe comprobarse.

### 2.4 Higiene del sueño: contexto, no promesa

El dormitorio y el periodo previo al sueño son contextos pertinentes porque el teléfono suele acompañar el final del día. Una revisión sistemática y metaanálisis de 55 estudios, con 41.716 participantes, encontró asociaciones entre uso de medios electrónicos, menor calidad de sueño y mayores problemas de sueño, con variaciones según tipo y patrón de uso (Han et al., 2024). Esa evidencia no autoriza a afirmar que el proyecto trate insomnio ni que una pausa mejore el sueño.

En esta etapa, la higiene del sueño funciona como criterio contextual: brillo regulable, sonido desactivado por defecto, ausencia de destellos rápidos y posibilidad de establecer una franja nocturna. Los resultados se evaluarán como comprensión, autonomía y reconsideración de una intención; no como eficacia clínica ni calidad objetiva del sueño.

## 3. Planteamiento del problema

El problema no es usar demasiado el teléfono ni preferir una pantalla. Aparece cuando una sesión recreativa continúa sin decisión renovada y desplaza actividades que la persona también deseaba. La duración no basta para explicarlo: una sesión larga puede ser elegida y satisfactoria, mientras una breve puede ser automática.

Indicadores de acceso permiten dimensionar el contexto, no probar la brecha. Kemp (2025) estimó un promedio global de 6 horas y 38 minutos diarios de uso de internet en adultos; en Chile, el 96,5 % de los hogares declaró acceso propio y pagado a internet (Subsecretaría de Telecomunicaciones, 2024). Esos datos muestran la infraestructura cotidiana sobre la que operan tres aristas interrelacionadas.

### 3.1 Arista psicológica: una intención deja de estar disponible

Querer realizar una actividad y considerarla en el momento oportuno son cosas distintas. La teoría de sistemas duales ayuda a comprender esa diferencia sin atribuirla únicamente a disciplina: el comportamiento puede responder a procesos rápidos y automáticos o a procesos lentos y deliberados. Las señales del entorno digital favorecen la continuidad antes de que una intención alternativa sea consultada (Lyngs et al., 2019).

La pregunta de diseño no es únicamente cómo detener una conducta, sino cómo hacer que una posibilidad vuelva a estar presente. La distinción entre memoria semántica y episódica ayuda a describir la experiencia retrospectiva: una persona puede saber que estuvo en una aplicación sin reconstruir la sesión como un episodio propio (Staniloiu et al., 2020; Tulving, 2002). Sin embargo, una sesión difícil de narrar no es un diagnóstico ni demuestra daño de memoria; puede deberse a repetición, baja diferenciación o límites del relato.

De Segovia Vicente et al. (2024), en un estudio observacional longitudinal intensivo con más de 1.300 adultos, encontraron asociación entre desplazamiento sin propósito, conflicto con metas personales y culpa experimentada el mismo día. El diseño observacional no permite afirmar causalidad, pero orienta el foco: importa que durante la sesión exista o no un propósito reconocible, más que la duración aislada.

### 3.2 Arista tecnológica: la continuidad también está diseñada

La permanencia en plataformas no depende solo de una decisión individual. El desplazamiento continuo, la reproducción automática y la oferta inmediata del contenido siguiente reducen pausas y sostienen la sesión sin solicitar una nueva elección (Bhargava y Velasquez, 2021; Montag et al., 2019). La continuidad es una propiedad de la interfaz.

Muchas herramientas de bienestar digital responden con métricas, temporizadores o bloqueos. Lyngs et al. (2019) revisaron 367 herramientas de autocontrol: el 73 % impedía la activación de hábitos no deseados, mientras solo el 18 % apoyaba la formación de hábitos deseados. El vacío no es la ausencia de límites, sino la escasez de apoyos que conecten el momento de uso con una alternativa elegida.

### 3.3 Arista evaluativa: el ocio se juzga frente a otras intenciones

Reinecke y Meier (2020) relacionan la culpa mediática con la incongruencia percibida entre una actividad y metas u obligaciones personales. Una devolución que compara días o contabiliza «tiempo perdido» puede confirmar esa incongruencia en lugar de aliviarla. Meier y Reinecke (2021), al sintetizar 594 publicaciones, muestran además que la relación entre redes sociales y bienestar es heterogénea; no existe base para condenar el ocio digital como categoría.

El proyecto evita jerarquizar leer, conversar, caminar, jugar o ver videos. Una actividad significativa es aquella que la propia persona desea mantener disponible en su tiempo libre; no necesita ser productiva ni estar fuera de pantalla. La intervención debe permitir continuar, posponer o desactivar sin convertir esas respuestas en derrota.

### 3.4 Síntesis del problema

Las tres aristas delimitan una brecha precisa: durante ciertas sesiones automáticas, una actividad elegida deja de considerarse; al final, las respuestas disponibles devuelven tiempo, restricción o comparación, pero no esa posibilidad personal. El desafío es reintroducirla sin castigo, vigilancia ni una definición externa de descanso correcto.

## 4. Justificación

La presencia cotidiana del teléfono vuelve relevante estudiar no solo cuánto se usa, sino qué capacidad de decisión existe durante ese uso. La oportunidad no está en promover abandono de pantallas, sino en la distancia entre querer hacer algo y volver a considerarlo a tiempo.

Esta distancia también está construida mediante diseño. Una respuesta distinta trabaja con las mismas variables —momento, canal, lenguaje, fricción y control— orientándolas a una decisión comprensible. La disciplina del diseño puede definir qué información aparece, dónde se presenta y qué agencia conserva la persona. Si esas variables no se deciden a favor del usuario, quedan por omisión a favor de la permanencia.

Los resultados variables de las intervenciones de desconexión impiden asumir que reducir pantalla mejore por sí solo la experiencia (Radtke et al., 2022). El aporte del proyecto no se medirá primariamente en minutos evitados, sino en si la persona reconoce la intención, comprende sus opciones, conserva autonomía y puede iniciar un primer paso cuando lo decide.

## 5. Antecedentes y estado de la cuestión

El bienestar digital se consolidó como un campo de interacción humano-computador que discute uso significativo, responsabilidad del diseño y control. Cecchinato et al. (2019) plantean que reducir o eliminar tecnología no constituye una respuesta sostenible en contextos de conectividad ubicua y proponen apoyar interacciones significativas. Lyngs et al. (2019) organizan las herramientas según intervienen antes, durante o después de la conducta, y muestran el predominio del bloqueo sobre el andamiaje.

La informática personal aporta otra dimensión: las personas interpretan registros según propósitos cambiantes. Un dato no adquiere sentido solo por ser exacto, sino por la situación en que se presenta y por la intención de quien lo lee (Rooksby et al., 2014). Esto cuestiona los tableros que tratan una cifra como explicación suficiente.

La revisión de «desconexión digital» realizada por Radtke et al. (2022) encontró efectos positivos, nulos y negativos entre intervenciones. El problema aquí delimitado es más acotado: sesiones no renovadas que compiten con intenciones personales en rutinas domésticas. Esa delimitación permite evaluar un mecanismo sin convertir la abstinencia en criterio de éxito.

## 6. Marco teórico

El marco cruza cuatro ámbitos: experiencia subjetiva del ocio, arquitecturas de atención, mediación material de información personal y contexto de sueño. Ninguno determina por sí solo la solución; juntos permiten juzgar una propuesta por su relación con la decisión.

### 6.1 Experiencia subjetiva del ocio digital

La experiencia de ocio puede evaluarse por duración, forma de participación y valoración posterior. Si solo importa la duración, basta un contador. Si importa la participación, hay que observar estructura, propósito y agencia. Si importa cómo la persona recuerda y evalúa la experiencia, ningún número resulta suficiente.

Tulving (2002) define la memoria episódica como la capacidad de reexperimentar un acontecimiento situado en tiempo y lugar; Staniloiu et al. (2020) subrayan su relación con el yo que recuerda. Estos trabajos no investigan directamente el consumo digital y no deben utilizarse para afirmar que una aplicación produce amnesia. Entregan, en cambio, un vocabulario para diferenciar saber que una sesión ocurrió de recordarla como experiencia propia.

La absorción tampoco es homogénea. El flujo en videojuegos puede incluir metas claras, retroalimentación y desafío ajustado (Khoshnoud et al., 2020), condiciones distintas del desplazamiento sin propósito. Dos sesiones de igual duración pueden tener estructuras y valoraciones opuestas. Una intervención responsable no debería interrumpir estados de flujo valiosos; deberá probar cuándo una pausa resulta pertinente y cuándo se vuelve una intrusión.

### 6.2 Arquitecturas de atención y bienestar digital

La arquitectura de atención organiza qué capta la mirada, cómo continúa una interacción y cuándo se solicita una nueva elección. Bhargava y Velasquez (2021) analizan el conflicto ético de modelos de negocio financiados por permanencia. Montag et al. (2019) describen funciones que reducen puntos naturales de cierre.

Fogg (2009) plantea que motivación, capacidad y señal deben coincidir para que una conducta ocurra. El modelo permite diferenciar un recordatorio abstracto de un primer paso que reduce la demanda de inicio. Thaler y Sunstein (2008) denominan empujón a una modificación de la arquitectura de elección que orienta sin prohibir y debe ser fácil de evitar. Para este proyecto, esa frontera exige que la persona instale la regla, conozca el mecanismo y conserve una salida.

Mathur et al. (2019) documentan patrones oscuros que orientan decisiones en contra del usuario. Su aporte para este proyecto es una frontera ética: una intervención que oculta sus fines, dificulta desactivarse o utiliza culpa reproduce la asimetría que pretende corregir.

### 6.3 Mediación material de información personal

La mediación material se refiere a formas físicas mediante las que una persona percibe o responde a información digital. Presentar esa información implica decidir qué se registra, cómo aparece y quién conserva control.

Hallnäs y Redström (2001) proponen la tecnología lenta como una relación temporal que permite observar y decidir sin urgencia. Adams et al. (2018), con la interfaz tangible Keppi, muestran que un gesto físico puede reducir la carga de una respuesta situada. Dragicevic et al. (2021) sistematizan cómo la persistencia y manipulación de una representación física pueden favorecer reflexión, pero advierten que la materialidad no es reflexiva por definición. El dato, la agregación, la comparación y el contexto importan más que la novedad del objeto.

Tanil y Yong (2020) observaron, en una tarea controlada con 119 universitarios, menor precisión de recuerdo cuando el teléfono permanecía presente. El estudio se limita a aprendizaje en laboratorio; no demuestra que retirar el teléfono mejore el ocio. Sí muestra que ubicación y presencia material son variables que merecen probarse.

### 6.4 Accesibilidad y modalidades de señal

Una señal luminosa no puede justificarse solo porque parezca «fácil». Su pertinencia depende del lugar, la distancia, la convivencia y las capacidades perceptivas. Las orientaciones de Android recomiendan contraste suficiente y más de una señal visual para comunicar una acción; el color no debe ser el único indicador (Google, s. f.-a, s. f.-b). El W3C establece, como referencia preventiva aplicable a cualquier tecnología, evitar más de tres destellos por segundo (World Wide Web Consortium, s. f.).

Estas orientaciones conducen a especificaciones iniciales que deberán probarse: pulso inferior a 1 Hz, texto e icono de alto contraste, brillo regulable, sonido opcional y confirmación táctil. El mensaje deberá permanecer disponible aunque la luz se apague, para no convertir una ventana breve de percepción en condición de acceso.

### 6.5 Conclusiones del marco

Los ámbitos convergen en una idea: la decisión, no el tiempo, es la unidad relevante. Una sesión no se vuelve valiosa o problemática por su duración aislada; una interfaz puede proteger o erosionar la elección; un dato personal solo enriquece la decisión cuando existe propósito y control; y el canal físico debe justificar su presencia frente a una alternativa digital.

## 7. Usuario, contexto y entrevistas

### 7.1 Muestra y método

Se realizaron ocho entrevistas semiestructuradas exploratorias en Santiago, identificadas como P1 a P8. Participaron personas de 18 a 30 años —edades efectivas entre 19 y 27 años— durante sesiones de 28 a 42 minutos. El guion avanzó desde rutina y tiempo libre hacia una sesión reciente, su recuerdo, valoración y estrategias de separación del teléfono. Un bloque final recogió reacciones ante posibles devoluciones de uso.

Cada participante entregó consentimiento informado para audio y notas con fines académicos. La muestra es exploratoria, no representativa. Las entrevistas permiten reconocer patrones y orientar pruebas; no estimar prevalencias.

### 7.2 Hallazgos

> **Tabla 2:** conversión estructural desde la tabla de Word.

| Hallazgo | Evidencia | Alcance | Implicancia de diseño |
| --- | --- | --- | --- |
| Algunas sesiones automáticas son difíciles de reconstruir. | Seis de ocho participantes describieron sesiones que no lograban narrar; una respuesta fue parcial y una negativa. | Patrón recurrente, 6/8. | Tratarlo como señal de una sesión poco diferenciada, no como falla clínica de memoria. |
| El malestar retrospectivo no requiere reproche externo. | Apareció incomodidad al evaluar la tarde, sin confrontación de terceros. | Patrón sustentado. | No agregar juicio donde ya existe autoevaluación negativa. |
| El ocio con foco deja un relato más claro. | Videollamadas y juegos con desafío se describieron con detalle. | Patrón sustentado. | El problema es específico del uso automático, no del ocio digital en general. |
| Separar el teléfono es una estrategia intentada. | Los ocho mencionaron dejarlo en otra pieza, modo avión, borrar u ocultar aplicaciones; al menos tres lo hacían de forma intermitente. | Patrón recurrente, 8/8. | Investigar qué ocurre después de la separación, sin asumir que basta con alejar el dispositivo. |
| La motivación apunta a actividades concretas. | P2, P3, P6 y P8 nombraron manualidades, pintura, dibujo, concentración o lectura. | Evidencia directa. | Partir de una intención declarada por la persona. |
| Existe rechazo a medición y comparación. | P7 rechazó notas o comparaciones; P8 señaló que abandonaría una herramienta sentida como presión. | Evidencia directa. | Evitar ranking, calificación, rachas obligatorias y comparación entre días. |
| El problema no es universal. | P7 no reportó malestar y consideró bien empleada cualquier tarde libre de obligaciones. | Caso único. | Delimitar al usuario que reconoce la brecha; no universalizar la intervención. |

### 7.3 Perfil primario

El usuario primario es un adulto joven de 18 a 30 años que, durante su ocio doméstico, abre aplicaciones de forma reactiva y reconoce que actividades elegidas dejan de considerarse sin rechazo deliberado. Valora el ocio digital y otras formas de descanso; no busca abstinencia ni tratamiento. Para la prueba integrada utiliza un teléfono Android compatible y está dispuesto a configurar una regla; la primera prueba de experiencia no exige un modelo de teléfono específico.

El proyecto desarrolla un solo triple mapa para este perfil. Familiares y convivientes aparecen como actores secundarios por privacidad y convivencia, pero no se inventan perfiles adicionales sin evidencia de campo.

### 7.4 Por qué el hogar

La elección del hogar se sustenta en cuatro condiciones: allí ocurrieron varios relatos de sesiones automáticas; las actividades alternativas tienen objetos y lugares reconocibles; un elemento físico puede mantenerse en una ubicación estable; y la privacidad frente a convivientes puede observarse y diseñarse. El hogar no es un fondo neutral: la ubicación vincula la señal con una posibilidad concreta.

La caminata se utiliza posteriormente como caso de prueba. No se afirma que caminar sea mejor que mirar videos ni se intenta resolver sedentarismo. Funciona como actividad prototípica porque tiene un primer paso visible, una localización doméstica clara y una transición observable.

## 8. Estado del arte y contexto de producto

### 8.1 Referentes seleccionados

Se revisaron seis referentes por la operación que aportan: Screen Time, Pause Point, Brick, Aro, Yoro y Keppi (Adams et al., 2018; Apple Inc., s. f.; Aro, s. f.; Brick LLC, s. f.; Diermeier et al., 2019; Sanders, 2026). La selección no busca enumerar todo el mercado, sino representar medición, pausa, restricción física, separación doméstica, recordatorio material y entrada tangible.

> **Tabla 3:** conversión estructural desde la tabla de Word.

| Referente | Operación central | Aporte transferible | Límite observado |
| --- | --- | --- | --- |
| Screen Time | Medir y limitar uso por aplicación. | Reglas configurables por la persona. | El reporte acumulado como respuesta principal. |
| Pause Point | Pausar la apertura desde el sistema operativo. | Legitimidad de una pausa integrada al uso. | Opera al abrir, propone apps y resuelve dentro de pantalla. |
| Brick | Restringir aplicaciones mediante una acción física. | Decisión tomada fuera de la pantalla. | Bloqueo y dificultad de salida como propuesta de valor. |
| Aro | Registrar separación del teléfono en una caja conectada. | Canal físico doméstico vinculado a app. | Metas, rachas y abstinencia como centro. |
| Yoro | Mantener visible una actividad elegida al depositar el teléfono. | Recordatorio material situado. | Actividad fija, separada del momento efectivo de uso. |
| Keppi | Registrar una respuesta subjetiva mediante presión. | Entrada tangible de baja carga. | Caso clínico sin relación directa con ocio digital. |

### 8.2 Mercado y posición

El mercado actual confirma que existe disposición a pagar por herramientas de autocontrol. Brick comercializa un objeto físico de bloqueo por USD 59, sin suscripción, mientras Opal ofrece un plan anual de USD 99,99 y one sec una suscripción anual informada de EUR 14,99 (Brick LLC, s. f.; one sec, s. f.; Opal, s. f.). Estas cifras describen ofertas vigentes y no equivalen a demanda validada en Chile.

La oportunidad proyectual no consiste en vender dificultad de acceso, productividad ni puntuación. Consiste en probar una pausa doméstica situada que devuelva una intención y conserve cuatro salidas. La ventaja no puede asumirse: si una notificación convencional logra el mismo efecto, el componente físico pierde justificación.

### 8.3 Vacío de diseño

Las herramientas del teléfono conocen el momento, pero resuelven en la misma pantalla y rara vez conocen la intención. Los objetos trasladan la decisión, pero suelen bloquear, premiar la distancia o actuar antes de la sesión. El vacío de diseño es relacionar condición de uso, intención personal, ubicación doméstica, decisión revisable y primer paso en un canal externo.

## 9. Criterios de diseño

> **Tabla 4:** conversión estructural desde la tabla de Word.

| N.º | Criterio | Fundamento y aplicación |
| --- | --- | --- |
| 1 | Trabajar solo con aplicaciones e intenciones elegidas. | El dato tiene sentido si corresponde a una preocupación reconocida por la persona (Rooksby et al., 2014). |
| 2 | Situar el elemento físico junto a la actividad, no en cualquier lugar de la casa. | La ubicación convierte una intención abstracta en una posibilidad perceptible y justifica el contexto doméstico. |
| 3 | Introducir una pausa perceptible antes de solicitar decisión. | Los procesos automáticos actúan antes de la deliberación; la señal debe producir un intervalo reconocible (Lyngs et al., 2019). |
| 4 | Presentar intención y primer paso de baja demanda. | Una señal concreta reduce la capacidad requerida para comenzar frente a una meta abstracta (Fogg, 2009). |
| 5 | Mantener iniciar, continuar, posponer y desactivar como opciones legítimas. | La evitabilidad separa apoyo de imposición (Thaler y Sunstein, 2008). |
| 6 | Evitar notas, rachas obligatorias, rankings y comparación. | Las entrevistas y la literatura sobre culpa muestran riesgo de reforzar incongruencia (Reinecke y Meier, 2020). |
| 7 | No depender de una sola modalidad perceptiva. | Texto, icono, patrón luminoso, sonido opcional y control táctil amplían acceso (Google, s. f.-a, s. f.-b). |
| 8 | Solicitar la menor cantidad de datos y permitir borrarlos. | Se registran reglas y estados, nunca contenidos, contactos ni mensajes. |
| 9 | Comprobar el aporte del componente físico frente a una notificación. | La materialidad puede favorecer reflexión, pero no la garantiza (Dragicevic et al., 2021). |
| 10 | Excluir gamificación del MVP como variable de control, no como dogma. | Premios o progreso introducirían motivación externa y dificultarían atribuir el resultado a la pausa. Se podrán explorar después de validar el mecanismo. |

## 10. Formulación: de la investigación al proyecto

Los criterios no describen todavía un producto; describen condiciones que cualquier respuesta debería cumplir. Al cruzarlos aparece una oportunidad específica: sacar la intención de la pantalla que sostiene la continuidad, confiarla a un elemento material y devolverla desde el lugar donde su primer paso puede ocurrir. La solución se formula desde esa operación —entregar, sostener y devolver— y no desde una aplicación preexistente.

### 10.1 Problema de diseño

Adultos jóvenes que reconocen la brecha abren aplicaciones de ocio de manera reactiva mientras actividades previamente elegidas dejan de considerarse. Las soluciones existentes separan registro, restricción, recordatorio y canal físico; ninguna articula el momento de uso con una intención situada, una decisión revisable y un primer paso sin bloquear ni evaluar.

### 10.2 Perspectiva del usuario

Una persona que valora tanto el ocio digital como otras actividades necesita recuperar una intención durante una sesión automática, mientras aún puede decidir, sin que el sistema compare, culpe o defina una respuesta correcta.

### 10.3 Pregunta de investigación

**¿Bajo qué condiciones de diseño un testigo físico situado en el hogar puede devolver una actividad previamente elegida a la decisión durante una sesión de ocio digital automático, sin castigar el ocio, comparar el desempeño ni reducir la autonomía?**

### 10.4 Hipótesis

Si una persona entrega una intención y su primer paso a un testigo físico, lo sitúa junto a la actividad y recibe allí una señal accesible cuando se cumple una condición elegida, entonces esa intención puede volver a ser considerada conscientemente. El mecanismo es trasladar la decisión fuera del canal que sostiene el uso automático y vincularla materialmente con una posibilidad doméstica concreta.

La intervención es la pausa situada. El resultado principal es comprensión y reconsideración explícita; el inicio del primer paso es secundario. Autonomía percibida, ausencia de reproche y privacidad son resguardos. Una notificación convencional y la ausencia de intervención funcionan como comparaciones.

### 10.5 Objetivo general

Diseñar y validar una experiencia doméstica físico-digital que favorezca la reconsideración de actividades elegidas por adultos jóvenes durante sesiones de ocio digital automático, resguardando autonomía, accesibilidad, privacidad y legitimidad del ocio.

### 10.6 Objetivos específicos

1. Caracterizar las condiciones domésticas en que una intención deja de considerarse durante sesiones automáticas.

1. Traducir evidencia teórica, entrevistas y referentes en criterios verificables de interacción, ubicación, contenido, privacidad y accesibilidad.

1. Diseñar la arquitectura de información, el viaje del usuario y los flujos funcional y técnico antes de continuar la programación.

1. Prototipar el testigo físico, la aplicación Android secundaria y la comunicación local entre ambos por etapas desacopladas.

1. Comparar la pausa física con una notificación convencional y ausencia de intervención.

1. Evaluar comprensión, reconsideración, primer paso observable, autonomía percibida, reproche, tolerancia y privacidad.

1. Determinar si el testigo físico aporta valor suficiente para justificar costo, complejidad y presencia doméstica.

### 10.7 Mapa de actores y rol del diseñador

El usuario primario configura y recibe la pausa. Los convivientes pueden percibir el objeto o la intención, por lo que afectan privacidad. Android condiciona autorización, acceso a estadísticas de uso y trabajo en segundo plano. No existe proveedor de cuenta ni base de datos en el MVP: regla, eventos e intención permanecen localmente. Especialistas en desarrollo móvil, electrónica y fabricación colaboran en la implementación.

El rol de Johan Yantén como diseñador consiste en delimitar el problema, convertir evidencia en criterios, diseñar la arquitectura de información y la interacción, definir forma y ubicación del testigo, coordinar app y hardware, resguardar accesibilidad y privacidad, construir prototipos y diseñar la validación. La programación demuestra factibilidad, pero no reemplaza esas decisiones.

## 11. Propuesta proyectual: Relevo

El proyecto resultante se denomina **Relevo**. El nombre no alude a sustituir el ocio digital por una actividad supuestamente mejor. Nombra tres movimientos: la persona entrega temporalmente una intención a un objeto; el objeto actúa como testigo que la sostiene mientras la atención está en otra parte; y, cuando corresponde, devuelve el turno de decidir a la persona. La aplicación no es Relevo: es la infraestructura que configura y activa ese intercambio.

El objeto es un testigo doméstico transportable. Tiene un cuerpo compacto, una pantalla de alto contraste, un halo de luz difusa y un control giratorio presionable. Al configurar una intención, la persona lo lleva y deja junto al primer paso: las zapatillas, un libro, los materiales de dibujo o la puerta. La ubicación no decora el sistema; completa su significado al convertir una frase en una posibilidad presente.

> **Figura conservada en la fuente DOCX:** image1.png. Véase el [manifiesto de medios](manifesto-de-medios.md).

*Figura 1. Visualización conceptual de Relevo en un caso de caminata: el testigo físico se sitúa junto a las zapatillas y devuelve la intención durante una sesión de ocio digital. La imagen comunica dirección formal y contexto; no corresponde a un prototipo construido.*

### 11.1 Caso de uso

Al final de la tarde, una persona quiere salir a caminar, pero abre una aplicación de videos breves y la sesión continúa sin que renueve esa decisión. Antes había confiado al testigo la intención «caminar» y lo había dejado junto a sus zapatillas. Cuando se cumple la condición configurada, el halo respira lentamente y la pantalla muestra «Caminar · ponte las zapatillas». Puede comenzar, seguir usando el teléfono, posponer o desactivar. Ninguna respuesta se registra como fracaso; el éxito del sistema es haber devuelto la posibilidad a la decisión.

### 11.2 Componentes del MVP

Relevo opera como un sistema de tres componentes, ordenados por su función en la experiencia:

1. **Testigo físico.** ESP32 con Bluetooth de baja energía, pantalla OLED de alto contraste, halo LED difuso, control rotatorio presionable, sonido opcional y sensor de luz ambiental. Se alimenta por USB-C y conserva localmente una intención activa.

1. **Aplicación Android de configuración.** Vincula el testigo, permite escribir intención y primer paso, seleccionar una aplicación, definir umbral y franja, elegir modalidades y revisar o borrar la regla. No incluye tablero, puntaje, racha ni cuenta.

1. **Detector local.** En la fase integrada consulta eventos de uso de la aplicación seleccionada y, al cumplirse el umbral, envía por Bluetooth solo el identificador de regla y el estado de activación. En las pruebas tempranas, un botón del prototipo genera el mismo evento para independizar la evaluación de la automatización.

> **Figura conservada en la fuente DOCX:** image2.png. Véase el [manifiesto de medios](manifesto-de-medios.md).

*Figura 2. Secuencia conceptual de Relevo: entregar, situar, sostener, devolver y decidir. Elaboración propia.*

### 11.3 Secuencia de interacción

1. La persona enciende el testigo y lo vincula desde la aplicación Android.

1. Entrega al testigo una intención y un primer paso; luego elige aplicación, umbral, franja y modalidades.

1. Lleva el testigo junto al lugar donde ese primer paso puede ocurrir: por ejemplo, una repisa junto a las zapatillas.

1. Durante una sesión, una activación simulada —y posteriormente el detector local— indica que se alcanzó el umbral.

1. El testigo inicia un pulso luminoso lento y muestra intención + primer paso.

1. La persona gira y presiona el control para iniciar, continuar o posponer; desactivar requiere mantener presionado dos segundos y confirmar. También puede no interactuar: la señal se silencia sin penalización y el mensaje permanece disponible.

1. El sistema registra solo la respuesta operacional necesaria para la prueba y vuelve al reposo.

### 11.4 Lenguaje de la pausa

El contenido evita órdenes, productividad y equivalencias. La estructura inicial es:

**Caminar**
Primer paso: ponte las zapatillas.
Iniciar · Continuar · Posponer · Desactivar

Se compararán tres variantes: con minutos visibles; sin minutos; y sin minutos con primer paso. La hipótesis favorece la tercera, pero la decisión final depende de comprensión y percepción de reproche.

### 11.5 Señal física y accesibilidad

La especificación inicial —sujeta a prueba— propone un pulso de luz cálida con 700 ms de aumento y 700 ms de descenso, inferior a un ciclo por segundo. El ciclo dura 20 segundos; después, la luz se apaga y el mensaje permanece hasta que la persona responde o termina la sesión. Si se habilita sonido, utiliza un tono breve al inicio y nunca se repite sin consentimiento.

La pantalla usa fondo oscuro, texto claro, frases breves e iconos redundantes. El estado no depende del color. El control tiene diámetro aproximado de 28 mm, relieve de orientación y confirmación táctil. La app permite aumentar texto, regular brillo, desactivar animación y seleccionar modo visual, sonoro o combinado. La vibración del objeto no es señal primaria porque solo se percibe al tocarlo; se reserva como confirmación del control. Estas decisiones siguen como referencia los criterios de contraste y redundancia de las guías de accesibilidad para Android (Google, s. f.-a, s. f.-b).

### 11.6 Gamificación

Relevo no afirma que toda gamificación sea punitiva. Mecánicas lúdicas pueden apoyar exploración o personalización. Se excluyen del MVP las rachas, puntos, recompensas y rankings porque introducirían una segunda hipótesis —motivación externa— y harían difícil saber si el efecto proviene de la pausa situada. También podrían desplazar el criterio desde autonomía hacia cumplimiento.

Después de validar el mecanismo central, se podrán explorar formas no comparativas, como personalizar animaciones o coleccionar representaciones sin metas. Su permanencia dependerá de que no presionen ni oculten una respuesta correcta.

### 11.7 Arquitectura técnica

> **Figura conservada en la fuente DOCX:** image3.png. Véase el [manifiesto de medios](manifesto-de-medios.md).

*Figura 3. Arquitectura de validación por capas: experiencia, enlace local y detección Android. Elaboración propia.*

La arquitectura separa validación de experiencia y dependencia tecnológica. En fase 1, un pulsador o una interfaz de simulación activa directamente el testigo. En fase 2, la aplicación Android y el ESP32 se vinculan localmente por Bluetooth de baja energía. El sistema de asociación de dispositivos de Android puede realizar el emparejamiento inicial sin solicitar ubicación fina en Android 8.0 o superior; la conexión posterior sigue requiriendo las autorizaciones de dispositivos cercanos que correspondan a la versión (Google, s. f.-d, s. f.-e).

En fase 3, UsageStatsManager consulta el historial y los eventos de uso. Android exige que la persona conceda manualmente acceso a estadísticas de uso desde Ajustes (Google, s. f.-g). Esta API no equivale a un detector instantáneo: el intervalo de consulta, las restricciones de batería y los límites al trabajo en segundo plano pueden producir latencia o interrupciones (Google, s. f.-f). Por ello se fijan dos métricas distintas: menos de 60 segundos entre el umbral estimado y la detección, y menos de 3 segundos entre la detección y la activación del testigo. Ambas deben medirse en varios modelos antes de afirmar factibilidad estable.

El MVP no utiliza nube, credenciales ni perfil personal. La intención y la regla se almacenan en el teléfono; el testigo conserva solo la intención activa y el último estado. El paquete Bluetooth contiene identificador local de regla, comando, texto breve y duración. Los registros de investigación se exportan por separado, con códigos de participante y sin nombres de aplicaciones si no son necesarios para el análisis.

### 11.8 Estados y excepciones

> **Tabla 5:** conversión estructural desde la tabla de Word.

| Situación | Respuesta del sistema | Criterio de recuperación |
| --- | --- | --- |
| Acceso de uso denegado o revocado | La app explica qué función queda inactiva y ofrece activación simulada. | No bloquear la configuración ni ocultar el estado. |
| Bluetooth denegado o apagado | Mostrar causa, acceso directo a configuración y alternativa simulada. | No solicitar permisos no necesarios ni presentar un emparejamiento falso. |
| Testigo no vinculado | Guía de vinculación; mantener presionado 3 s; patrón de tres pulsos lentos; espera máxima de 60 s. | Permitir reintentar o continuar con simulación. |
| Conexión BLE perdida | El testigo conserva la regla; la app intenta reconectar hasta dos veces. | No activar eventos antiguos cuando vuelve la conexión. |
| Detección tarda más de 60 s | Registrar modelo, versión, batería y estado del proceso. | Tratar como falla técnica; no afirmar detección en tiempo real. |
| Envío al testigo tarda más de 3 s | Reintentar hasta dos veces; luego registrar falla. | No repetir la pausa tardíamente si perdió pertinencia. |
| Sin respuesta de usuario | Luz se apaga a los 20 s; texto permanece; el evento cierra sin juicio. | Medir tolerancia y no contar como fracaso personal. |
| Posponer | Reprogramar una sola vez por 15 min en el MVP. | Evitar bucles insistentes. |
| Desactivar | Mantener 2 s y confirmar; revocar regla desde app. | Salida siempre disponible. |
| Reinicio o corte de energía | Recuperar configuración desde memoria no volátil. | Volver a estado reposo, nunca activar una señal residual. |

## 12. Factibilidad, costos y límites

### 12.1 Factibilidad funcional

Las tecnologías centrales existen, pero su integración no debe confundirse con validación del proyecto. Android ofrece acceso autorizado al historial de uso, asociación de dispositivos compañeros y soporte de plataforma para Bluetooth de baja energía (Google, s. f.-c, s. f.-e, s. f.-g); el ESP32 puede recibir el evento y gobernar pantalla, luz y control. La demostración del semestre 1 confirmó que es posible comunicar dos dispositivos, aunque la nueva dirección reemplaza el relé en nube por un enlace local. La incertidumbre principal no es si un LED puede encenderse, sino si la pausa física mejora la reconsideración sin volverse molesta y si la detección se mantiene estable bajo las restricciones de Android.

Por eso, la construcción avanza por capas: primero mensaje y decisión con datos simulados; después modalidad física; luego comunicación app-objeto; finalmente detección real. Si una etapa falla, se modifica antes de invertir en la siguiente.

### 12.2 Costo preliminar del prototipo

MechatronicStore ofrece en Chile un kit ESP32 con OLED, sensores, botones y buzzer por CLP 21.990, útil como base de prototipado (MechatronicStore, s. f.). A partir de precios minoristas y estimaciones de taller se propone el siguiente presupuesto, que debe cotizarse nuevamente antes de comprar.

> **Tabla 6:** conversión estructural desde la tabla de Word.

| Partida | Estimación CLP | Observación |
| --- | --- | --- |
| ESP32, OLED, protoboard, cables, botones y buzzer | 21.990 | Kit de prototipado local. |
| Aro o matriz LED direccionable y difusor | 6.500 | Señal visual periférica. |
| Encoder rotatorio y sensor de luz | 4.000 | Entrada y regulación de brillo. |
| Alimentación USB y cable | 5.000 | Fuente certificada para prototipo. |
| Carcasa PLA, acrílico y fijaciones | 12.000 | Impresión y pruebas de encaje. |
| Contingencia aproximada, 20 % | 9.900 | Reemplazos, soldadura y ajustes. |
| Total prototipo unitario | 59.390 | Estimación de planificación, no cotización comercial. |

El producto se instalará por el usuario mediante una guía de aproximadamente 15 minutos; no requiere técnico ni intervención eléctrica del hogar. Para una serie pequeña, se plantea como hipótesis un costo directo de CLP 35.000–45.000 y un precio de venta de CLP 89.990–119.990, por validar con diseño industrial, impuestos, empaque, soporte y volumen. La referencia de Brick a USD 59 y de Aro reacondicionado a USD 149 sitúa una banda internacional, pero no prueba disposición a pagar en Chile (Aro, s. f.; Brick LLC, s. f.).

### 12.3 Valor del trabajo de diseño

El costo unitario no incluye investigación, diseño ni desarrollo. Para transparentar el rol profesional se estima una dedicación de 120 horas para la siguiente iteración —arquitectura, interacción, interfaz, forma, prototipado, coordinación y validación— a una tarifa de planificación de CLP 20.000 por hora: **CLP 2.400.000**. Esta cifra no es una tarifa institucional ni un precio cerrado; hace visible que el valor del diseñador no se reduce a fabricar la carcasa.

### 12.4 Criterios de éxito y fracaso

> **Tabla 7:** conversión estructural desde la tabla de Word.

| Dimensión | Umbral operacional inicial | Fracaso que obliga a reorientar |
| --- | --- | --- |
| Comprensión | Al menos 4 de 5 personas explican qué activó la pausa y qué opciones tienen, sin ayuda. | La mayoría interpreta el objeto como alarma, castigo o bloqueo. |
| Aporte físico | Al menos 3 de 5 prefieren o recuerdan mejor la pausa física que una notificación. | La notificación consigue el mismo resultado con menor carga. |
| Autonomía | Ningún participante cree que «continuar» sea una respuesta incorrecta; máximo 1 de 5 percibe reproche. | Dos o más perciben culpa, vigilancia o presión. |
| Técnica del testigo | 9 de 10 eventos simulados llegan por BLE en menos de 3 s. | Señal tardía, activaciones falsas o conexión inestable. |
| Detección Android | En al menos 9 de 10 pruebas, el umbral se reconoce dentro de 60 s en cada modelo ensayado. | Variabilidad de segundo plano impide una pausa oportuna o requiere vigilancia excesiva. |
| Accesibilidad | Las cinco personas perciben el mensaje con su modalidad elegida y operan el control. | Información esencial depende de color, tiempo breve o destreza fina. |
| Configuración | 4 de 5 completan onboarding en menos de 8 min. | Permisos, lenguaje o vinculación impiden comenzar. |

Estos umbrales son puertas de decisión para prototipos pequeños, no resultados estadísticos ni evidencia de eficacia.

### 12.5 Privacidad y ética

La persona configura la pausa que encontrará. Puede revisar permisos, borrar intenciones, desvincular el testigo y eliminar datos. El detector consulta eventos de uso solo para la aplicación seleccionada; no accede a contenidos, contactos, mensajes ni navegación interna. El MVP no exige cuenta ni sincronización en nube.

La señal doméstica introduce exposición ante convivientes. El objeto mostrará por defecto una etiqueta breve configurable o un icono; la intención completa puede ocultarse. La ubicación debe acordarse con quien comparte el espacio. Relevo no utiliza cámaras, micrófonos ni sensores de presencia.

### 12.6 Límites

El proyecto no diagnostica adicción, no trata trastornos de sueño, no demuestra causalidad entre desplazamiento continuo y bienestar ni reemplaza apoyo clínico. La compatibilidad se limita a Android en la iteración integrada y no se promete cobertura universal. Quedan abiertas la tolerancia a la señal, vigencia de las intenciones, acostumbramiento, diferencias entre flujo y automatismo, utilidad en hogares compartidos y valor del objeto frente a una notificación.

## 13. Metodología, validación y cronograma

### 13.1 Trabajo realizado y planificado

La cronología distingue trabajo ejecutado de trabajo futuro para evitar la impresión de un proyecto iniciado al final del semestre.

> **Tabla 8:** conversión estructural desde la tabla de Word.

| Periodo | Estado | Trabajo y evidencia |
| --- | --- | --- |
| Marzo 2026 | Realizado | Observación personal, exploración del ocio digital y delimitación inicial del problema. |
| Abril 2026 | Realizado | Revisión bibliográfica inicial, desarrollo de aristas y reformulación desde tiempo de pantalla hacia decisión. |
| Mayo 2026 | Realizado | Análisis de referentes, ideación, criterios preliminares y preparación del guion de entrevistas. |
| Junio 2026 | Realizado | Ocho entrevistas, análisis de patrones, comparación de propuestas y demostración tecnológica de comunicación entre dispositivos. |
| Julio 2026 | Realizado | Síntesis de memoria, examen de Seminario y recepción de feedback de comisión. |
| Agosto 2026 | En curso | Reestructuración narrativa, definición del testigo físico, foco doméstico, MVP Android, triple mapa, costos, accesibilidad y arquitectura. |
| Septiembre 2026 | Planificado | Pruebas de comprensión, mensaje, modalidad y aporte físico con eventos simulados. |
| Octubre 2026 | Planificado | Integración app/simulador, enlace BLE y testigo físico; iteración formal. |
| Noviembre 2026 | Planificado | Piloto doméstico de 7 a 10 días con 6 a 8 participantes; comparación con notificación. |
| Diciembre 2026 | Planificado | Análisis, decisiones finales, documentación, memoria y presentación. |

### 13.2 Etapas de validación

> **Tabla 9:** conversión estructural desde la tabla de Word.

| Etapa | Método | Decisión que habilita |
| --- | --- | --- |
| 1. Valor de la transición | Comparar notificación, pausa física simulada y ausencia de intervención. | Mantener o descartar el mecanismo central. |
| 2. Lenguaje | Comparar minutos visibles, sin minutos y con primer paso. | Definir contenido y tono. |
| 3. Modalidad y accesibilidad | Comparar luz, luz + texto y modo combinado opcional. | Definir señal, brillo, duración y alternativas. |
| 4. Forma y ubicación | Probar apoyo junto a zapatillas, libro u objeto de actividad. | Justificar presencia y ubicación doméstica. |
| 5. Integración | Prototipo app/simulador + servicio de eventos + ESP32. | Confirmar o reformular arquitectura. |
| 6. Uso cotidiano | Piloto doméstico de 7 a 10 días. | Ajustar momento, frecuencia, autonomía, privacidad y retención. |

### 13.3 Instrumentos

La prueba inicial utilizará observación de tarea, protocolo de pensar en voz alta, preguntas de comprensión, escala breve de autonomía y reproche, y entrevista posterior. El piloto registrará activaciones, latencia, respuesta seleccionada, posposiciones, reglas desactivadas, errores y configuraciones abandonadas. Los logs no incluirán contenidos de uso.

La pregunta principal del análisis será cualitativa: ¿la intención volvió a estar disponible como opción? El inicio observable del primer paso es evidencia secundaria; continuar también puede ser una decisión válida.

## 14. Encargo 16: arquitectura de experiencia

El Encargo 16 se desarrolla para un único perfil primario: adulto joven que reconoce sesiones domésticas automáticas y quiere mantener disponible una actividad concreta. El teléfono Android es una condición del prototipo integrado, no un rasgo identitario del perfil. Los convivientes y colaboradores técnicos aparecen como actores, no como usuarios inventados.

### 14.1 Mapa de viaje

El viaje recorre conciencia, consideración, adopción, uso, retención y recomendación. La retención no depende de rachas ni culpa: depende de que el apoyo siga siendo pertinente, editable y fácil de silenciar. La recomendación se formula como recuperación de decisión, no como promesa de productividad.

### 14.2 Flujo funcional

El flujo desde la experiencia comienza en la entrega de una intención al testigo, continúa con ubicación, configuración y activación, y termina en cuatro ramas de respuesta. Incluye denegación de permisos, falla de vinculación, posposición única, ausencia de respuesta y desactivación. La secuencia visible para el usuario se separa de las operaciones internas.

### 14.3 Flujo técnico

El flujo técnico separa aplicación Android, acceso local a estadísticas de uso, comunicación BLE y testigo ESP32. Define permisos, estados, reintentos, dos umbrales de latencia, señal LED, pantalla, control, memoria local y excepciones. La especificación inicial se entiende como hipótesis técnica que debe medirse.

### 14.4 Metas SMART para las próximas 72 horas

1. **Antes del 18 de agosto de 2026 a las 18:00**, presentar los tres mapas a dos adultos jóvenes del perfil, pedirles que expliquen el sistema sin ayuda, registrar al menos cinco confusiones o preguntas y priorizar tres correcciones de arquitectura.

1. **Antes del 18 de agosto de 2026 a las 21:00**, montar ESP32 + OLED + LED + encoder y completar diez activaciones simuladas consecutivas; documentar entrega, señal, lectura y respuesta, y lograr al menos nueve ciclos correctos antes de integrar la detección Android.

## 15. Conclusiones

El desarrollo de la investigación cambió el centro de gravedad del proyecto. La teoría permitió abandonar la duración como explicación suficiente; las entrevistas mostraron que la brecha no es universal y que las intenciones son concretas; los referentes revelaron una concentración en medición, bloqueo o recompensa. Solo después de esa trayectoria aparece Relevo como respuesta: un testigo doméstico que recibe una intención, la sostiene fuera de pantalla y la devuelve junto a su primer paso. Android activa el intercambio, pero no constituye su sentido.

El recorte fortalece la investigación. Un solo contexto, plataforma, usuario e intención permiten comprobar el mecanismo sin pretender resolver sueño, sedentarismo, adicción y productividad al mismo tiempo. La higiene del sueño informa decisiones de brillo y sonido, pero no se convierte en promesa clínica. La gamificación se pospone para aislar la variable central. La accesibilidad deja de ser una adición tardía y pasa a definir modalidades, control y duración.

El proyecto tendrá éxito si el testigo hace comprensible y disponible una alternativa sin culpa ni pérdida de autonomía. También puede fracasar de manera productiva: si una notificación logra lo mismo, si el objeto solo molesta, si la detección Android no es oportuna o si la configuración pesa más que su beneficio, la arquitectura debe reorientarse. Hacer visibles esas condiciones transforma el prototipo en un proyecto de diseño evaluable.

## 16. Referencias

Adams, A. T., Murnane, E. L., Adams, P., Elfenbein, M., Chang, P. F., Sannon, S., Gay, G., y Choudhury, T. (2018). Keppi: A tangible user interface for self-reporting pain. En *Proceedings of the 2018 CHI Conference on Human Factors in Computing Systems* (Paper 502). Association for Computing Machinery. https://doi.org/10.1145/3173574.3174076

Apple Inc. (s. f.). *Set schedules with Screen Time on iPhone*. Apple Support. Recuperado el 15 de agosto de 2026, de https://support.apple.com/guide/iphone/set-schedules-with-screen-time-iphb0c7313c9/ios

Aro. (s. f.). *Aro: Screen time solution*. Recuperado el 15 de agosto de 2026, de https://goaro.com/

Bhargava, V. R., y Velasquez, M. (2021). Ethics of the attention economy: The problem of social media addiction. *Business Ethics Quarterly, 31*(3), 321–359. https://doi.org/10.1017/beq.2020.32

Brick LLC. (s. f.). *Brick: Take back control of your screen time*. Recuperado el 15 de agosto de 2026, de https://getbrick.com/

Cecchinato, M. E., Rooksby, J., Hiniker, A., Munson, S., Lukoff, K., Ciolfi, L., Thieme, A., y Harrison, D. (2019). Designing for digital wellbeing: A research and practice agenda. En *Extended Abstracts of the 2019 CHI Conference on Human Factors in Computing Systems* (pp. 1–8). Association for Computing Machinery. https://doi.org/10.1145/3290607.3298998

De Segovia Vicente, D., Van Gaeveren, K., Murphy, S. L., y Vanden Abeele, M. M. P. (2024). Does mindless scrolling hamper well-being? Combining ESM and log-data to examine the link between mindless scrolling, goal conflict, guilt, and daily well-being. *Journal of Computer-Mediated Communication, 29*(1), zmad056. https://doi.org/10.1093/jcmc/zmad056

Diermeier, D., Jehu, C., Camerin, P., y Johansson, J. E. (2019). *Yoro*. Recuperado el 15 de agosto de 2026, de https://www.diermeierdaniel.com/yoro

Dragicevic, P., Jansen, Y., y Vande Moere, A. (2021). Data physicalization. En J. Vanderdonckt, P. Palanque y M. Winckler (Eds.), *Handbook of human computer interaction* (pp. 1–51). Springer. https://doi.org/10.1007/978-3-319-27648-9_94-1

Fogg, B. J. (2009). A behavior model for persuasive design. En *Proceedings of the 4th International Conference on Persuasive Technology* (Article 40). Association for Computing Machinery. https://doi.org/10.1145/1541948.1541999

Google. (s. f.-a). *Accessibility*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/design/ui/mobile/guides/foundations/accessibility

Google. (s. f.-b). *Android color for mobile design*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/design/ui/mobile/guides/styles/color

Google. (s. f.-c). *Bluetooth Low Energy*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview

Google. (s. f.-d). *Bluetooth permissions*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/bt-permissions

Google. (s. f.-e). *Companion device pairing*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing

Google. (s. f.-f). *System restrictions on background tasks*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/develop/background-work/background-tasks/bg-work-restrictions

Google. (s. f.-g). *UsageStatsManager*. Android Developers. Recuperado el 15 de agosto de 2026, de https://developer.android.com/reference/android/app/usage/UsageStatsManager

Hallnäs, L., y Redström, J. (2001). Slow technology – designing for reflection. *Personal and Ubiquitous Computing, 5*(3), 201–212. https://doi.org/10.1007/PL00000019

Han, X., Zhou, E., y Liu, D. (2024). Electronic media use and sleep quality: Updated systematic review and meta-analysis. *Journal of Medical Internet Research, 26*, e48356. https://doi.org/10.2196/48356

Kemp, S. (2025). *Digital 2025: Global overview report*. DataReportal. https://datareportal.com/reports/digital-2025-global-overview-report

Khoshnoud, S., Alvarez Igarzábal, F., y Wittmann, M. (2020). Peripheral-physiological and neural correlates of the flow experience while playing video games: A comprehensive review. *PeerJ, 8*, e10520. https://doi.org/10.7717/peerj.10520

Lyngs, U., Lukoff, K., Slovak, P., Binns, R., Slack, A., Inzlicht, M., Van Kleek, M., y Shadbolt, N. (2019). Self-control in cyberspace: Applying dual systems theory to a review of digital self-control tools. En *Proceedings of the 2019 CHI Conference on Human Factors in Computing Systems* (pp. 1–18). Association for Computing Machinery. https://doi.org/10.1145/3290605.3300361

Mathur, A., Acar, G., Friedman, M. J., Lucherini, E., Mayer, J., Chetty, M., y Narayanan, A. (2019). Dark patterns at scale: Findings from a crawl of 11K shopping websites. *Proceedings of the ACM on Human-Computer Interaction, 3*(CSCW), Article 81. https://doi.org/10.1145/3359183

MechatronicStore. (s. f.). *Kit starter IoT principiante ESP32 30 pines Wi-Fi y Bluetooth*. Recuperado el 15 de agosto de 2026, de https://www.mechatronicstore.cl/kit-starter-electronica-con-placa-de-desarrollo-esp32-wifi/

Meier, A., y Reinecke, L. (2021). Computer-mediated communication, social media, and mental health: A conceptual and empirical meta-review. *Communication Research, 48*(8), 1182–1209. https://doi.org/10.1177/0093650220958224

Montag, C., Lachmann, B., Herrlich, M., y Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), 2612. https://doi.org/10.3390/ijerph16142612

one sec. (s. f.). *FAQ*. Recuperado el 15 de agosto de 2026, de https://one-sec.app/faq/

Opal. (s. f.). *Opal pricing*. Recuperado el 15 de agosto de 2026, de https://opalapp.com/pricing

Radtke, T., Apel, T., Schenkel, K., Keller, J., y von Lindern, E. (2022). Digital detox: An effective solution in the smartphone era? A systematic literature review. *Mobile Media & Communication, 10*(2), 190–215. https://doi.org/10.1177/20501579211028647

Reinecke, L., y Meier, A. (2020). Guilt and media use. En J. Van den Bulck, D. R. Ewoldsen, M.-L. Mares y E. Scharrer (Eds.), *The international encyclopedia of media psychology* (pp. 1–5). Wiley. https://doi.org/10.1002/9781119011071.iemp0183

Rooksby, J., Rost, M., Morrison, A., y Chalmers, M. (2014). Personal tracking as lived informatics. En *Proceedings of the SIGCHI Conference on Human Factors in Computing Systems* (pp. 1163–1172). Association for Computing Machinery. https://doi.org/10.1145/2556288.2557039

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google: The Keyword. https://blog.google/products-and-platforms/platforms/android/pause-point/

Staniloiu, A., Kordon, A., y Markowitsch, H. J. (2020). Quo vadis ‘episodic memory’? Past, present, and perspective. *Neuropsychologia, 141*, 107362. https://doi.org/10.1016/j.neuropsychologia.2020.107362

Subsecretaría de Telecomunicaciones. (2024). *Informe final: Undécima encuesta sobre acceso, usos y usuarios de internet en Chile 2024*. Ministerio de Transportes y Telecomunicaciones, Gobierno de Chile. https://www.subtel.gob.cl/wp-content/uploads/2025/02/Informe-Final-Subtel-Acceso-y-Uso-Internet-2024.pdf

Tanil, C. T., y Yong, M. H. (2020). Mobile phones: The effect of its presence on learning and memory. *PLoS ONE, 15*(8), e0219233. https://doi.org/10.1371/journal.pone.0219233

Thaler, R. H., y Sunstein, C. R. (2008). *Nudge: Improving decisions about health, wealth, and happiness*. Yale University Press.

Tulving, E. (2002). Episodic memory: From mind to brain. *Annual Review of Psychology, 53*, 1–25. https://doi.org/10.1146/annurev.psych.53.100901.135114

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 15 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold

## Anexo A. Pauta de entrevista semiestructurada

**Aplicación:** 11 y 12 de junio de 2026, Santiago.

**Participantes:** ocho personas, P1–P8, entre 18 y 30 años; edades efectivas 19–27.

**Duración:** 28–42 minutos.

**Registro:** audio y notas con consentimiento informado; transcripciones con ajustes mínimos de ortografía.

### Bloques del guion

1. Rutina y tiempo libre.

1. Relato de una sesión reciente de ocio digital.

1. Qué recuerda de esa sesión y si la reconoce como descanso.

1. Sesiones difíciles de describir y definición personal de una tarde bien gastada.

1. Cierre abierto.

1. Bloque final separado: estrategias previas de separación del teléfono y reacción ante distintas devoluciones de uso, comparación, lenguaje y presión.

### Preguntas para la nueva etapa de prototipado

1. Sin explicación previa, ¿qué crees que hace este sistema?

1. ¿Qué información esperas encontrar en el testigo físico?

1. ¿En qué lugar de tu hogar tendría sentido ubicarlo y junto a qué actividad?

1. ¿Qué entiendes por iniciar, continuar, posponer y desactivar?

1. ¿La señal se siente como recordatorio, invitación, interrupción, presión u otra cosa?

1. ¿Qué modalidad puedes percibir con mayor comodidad: luz, texto, sonido opcional o combinación?

1. ¿Qué dato no aceptarías que el sistema registrara o mostrara ante convivientes?

1. ¿El testigo físico aporta algo que una notificación no aportaría? ¿Qué exactamente?

1. ¿Qué te haría dejar de usarlo después de una semana?

1. ¿Qué tendría que ocurrir para que recomendaras Relevo a otra persona?

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Conversión desde DOCX

- **Cambio realizado:** el documento se convirtió a Markdown respetando el orden de párrafos, listas, enlaces y tablas.
- **Estado anterior:** archivo local SEMESTRE 2/output/Johan Yanten - Memoria actualizada Encargo 16.docx sin copia textual navegable en GitHub.
- **Motivo:** conservar el desarrollo intelectual y permitir comparar versiones sin depender de Word.
- **Contenido conservado:** texto, jerarquías identificables y tablas; las figuras se representan mediante marcadores vinculados al manifiesto.
- **Contenido no trasladado en esta fase:** maquetación de página, tipografía, márgenes, numeración automática y archivos binarios de imagen.
- **Limpieza estructural:** se omitieron 0 encabezados numéricos aislados identificados como artefactos de paginación, sin contenido argumental.
- **Original:** el DOCX local no fue editado, movido ni eliminado.
- **Correcciones metodológicas:** esta versión ya describía el levantamiento como entrevistas semiestructuradas; no se aplicó la corrección extensa requerida por las otras dos ramas.
- **Criterio de vigencia:** la conversión no declara esta versión como memoria vigente; la decisión queda pendiente en el documento comparativo.
