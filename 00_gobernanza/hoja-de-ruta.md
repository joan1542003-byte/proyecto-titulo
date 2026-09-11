# Hoja de ruta del proyecto

## Estado general

Relevo cuenta con una memoria integral en Markdown, auditada según los títulos, la secuencia y los límites del examen. Articula investigación, usuarios, mercado, propuesta, flujos, producción y gestión. La línea sustantiva activa es la [prueba de asociación entre intención, primer paso, lugar y señal](https://github.com/joan1542003-byte/proyecto-titulo/issues/8). La migración documental general permanece en pausa; el Encargo 17 quedó completado.

El calendario de término se encuentra en el [plan de cierre de agosto a diciembre de 2026](plan-de-cierre-agosto-diciembre-2026.md) y sus fechas institucionales se respaldan en el [calendario oficial del segundo semestre de 2026](calendario-oficial-segundo-semestre-2026.md). El producto debe estar prácticamente terminado el 31 de octubre y completamente cerrado el 15 de noviembre. El Pase de Examen se entrega el 25 de noviembre, la memoria el 2 de diciembre y los exámenes de Proyecto de Título se realizan entre el 14 y el 18 de diciembre.

El trabajo avanza por dependencias: una etapa solo alimenta a la siguiente cuando sus preguntas, evidencia, límites y decisiones están registrados. El producto phygital no se desarrolla como una respuesta autónoma; debe poder reconstruirse desde la investigación.

## Base metodológica consolidada

Durante junio de 2026 se realizaron ocho entrevistas semiestructuradas, habladas y presenciales en Santiago con personas de 19 a 27 años, bajo un criterio de convocatoria de 18 a 30 años. El reclutamiento fue no probabilístico, mediante referencias de la red personal. Se obtuvo consentimiento informado oral.

Todas las preguntas y repreguntas fueron formuladas por el investigador durante las conversaciones. El corpus operativo corresponde a una transcripción anonimizada y regularizada después del levantamiento, sin preguntas ni respuestas añadidas. La duración individual no fue registrada. P6 tiene 27 años.

Estas limitaciones deben declararse, pero no impiden realizar un análisis cualitativo exploratorio.

## Secuencia de trabajo

### Fase 0 — Gobernanza y fuentes

**Estado:** completada.

Resultados:

- arquitectura documental del repositorio;
- reglas de escritura, evidencia y control de cambios;
- inventario de fuentes locales;
- procedencia metodológica consolidada;
- separación entre material vigente, histórico y derivado;
- registro de decisiones e Issues.

### Línea auxiliar A — Organización y migración documental

**Estado:** pausada con arquitectura operativa.

Orden obligatorio:

1. inventariar archivos y familias;
2. distinguir autoría, sensibilidad, fuente, exportación y duplicado;
3. definir arquitectura y protocolo Markdown;
4. migrar texto propio ya estructurado;
5. convertir DOCX, PDF, PPTX y XLSX propios pertinentes;
6. crear fichas para fuentes externas;
7. indexar recursos visuales relevantes;
8. declarar versiones canónicas y omisiones;
9. comprobar navegación, privacidad y registros de cambios;
10. reabrir una unidad de la Issue #4 solo cuando resuelva una laguna concreta; no completar la migración por cantidad de archivos.

Documentación: [Fuentes locales migradas](../99_archivo/fuentes-locales/README.md).

### Fase 1 — Usuarios

**Estado:** análisis, tipología y traducción de diseño completados provisionalmente; abiertos a contraste mediante prototipos.

Orden obligatorio:

1. [Completado] preparar el corpus anonimizado P1–P8;
2. [Completado] construir un libro de códigos inicial;
3. [Completado] analizar cada caso antes de comparar;
4. [Completado] construir una matriz de evidencia entre casos;
5. [Completado] reconocer patrones, contradicciones y casos negativos;
6. [Completado] proponer dos tipos situacionales;
7. [Completado] elegir usuario principal más usuario límite;
8. [Completado] convertir la síntesis narrativa en fichas de perfiles situacionales y recorridos actual/futuro trazables;
9. [Completado] consolidar una matriz autónoma de requisitos y límites derivados de usuarios;
10. [Completado] redactar el apartado de usuario para la memoria v4.

No se elaborarán biografías o visualidades ficticias. Los entregables existentes ordenan la evidencia y declaran sus vacíos; los perfiles se revisarán cuando las pruebas produzcan evidencia nueva.

### Fase 2 — Problema y valor

**Estado:** completada provisionalmente en la memoria v4; debe revisarse ante nuevos contraejemplos.

Preguntas centrales:

- ¿Qué situación concreta merece intervención?
- ¿Por qué es relevante abordarla desde Diseño?
- ¿Qué valor ofrece Relevo y para quién?
- ¿Cuándo no debería intervenir?
- ¿Qué evidencia sostiene cada afirmación?

### Fase 3 — Estado del arte y mercado

**Estado:** estudio principal cerrado el 24 de agosto de 2026, con ampliaciones fechadas de referentes y tecnología hasta el 9 de septiembre. Una nueva revisión requiere información que afecte una decisión concreta.

Incluye bibliografía académica reciente, productos disponibles, aproximaciones en desarrollo, mecanismos de acción, resultados, fallas, condiciones de adopción y espacios no cubiertos. Encontrar productos no será suficiente: se analizará cómo se organiza el mercado y qué enfoques muestran valor o límites.

### Fase 4 — Definición de la propuesta phygital

**Estado:** arquitectura provisional documentada y sistematización visual iniciada mediante aplicaciones para objeto, memoria y Android; el valor físico, la identidad final y la forma del objeto siguen pendientes de desarrollo y pruebas de asociación, comparación y señal.

La propuesta documentada deriva de requisitos de investigación e incluye valor, principios de interacción, relación física y digital, flujos, alcance, límites y alternativas descartadas. Sus beneficios esperados se mantienen como hipótesis.

La [investigación visual](../10_recursos_visuales/README.md) define preguntas, criterios y alternativas para los soportes de Relevo. No fija todavía paleta, tipografía, logotipo, forma industrial ni parámetros perceptivos; esas decisiones requieren prototipos y pruebas. Luz y sonido continúan como canales previstos para el testigo.

### Fase 5 — Desarrollo y factibilidad

**Estado:** arquitectura portátil seleccionada como candidata y prueba temprana separada de la integración. La XIAO nRF52840 orienta el testigo compacto. El programa micro:bit para comprobar Android, BLE, luz, sonido y silencio local está compilado; faltan acceso a la placa, instalación, luz cálida externa, mediciones y revisión del montaje.

Incluye arquitectura técnica, producción, materiales, componentes, costos, mantenimiento, privacidad, riesgos, escenarios de fabricación y factibilidad académica.

### Fase 6 — Prototipado y evaluación

**Estado:** línea sustantiva activa en la [Issue #8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8). La primera puerta física está en la [Issue #11](https://github.com/joan1542003-byte/proyecto-titulo/issues/11): instalar el [paquete micro:bit compilado](../06_desarrollo_y_factibilidad/prueba-microbit-ble/README.md), comprobar el banco BLE y preparar después la salida cálida de fase A. La [Issue #10](https://github.com/joan1542003-byte/proyecto-titulo/issues/10) conserva la integración portátil posterior con XIAO nRF52840. El protocolo, el consentimiento y los instrumentos están preparados, pero no se puede comenzar con participantes hasta verificar un comportamiento seguro y repetible; la comparación posterior depende además de una notificación Android equivalente.

Cada prototipo deberá responder una pregunta. Los protocolos, resultados, contradicciones y cambios de dirección quedarán documentados antes de iterar.

Siguiente puerta de avance: conseguir acceso a una micro:bit V2, instalar `relevo-prueba-mesa-v0.1.hex` y ejecutar el banco sin participantes. La comprobación debe registrar conexión y reconexión, latencia, patrón rojo de referencia, sonido, silencio local y fallos observados. Después se conecta una luz blanca cálida externa revisada y se repiten las series materiales de fase A. Ninguna de estas acciones habilita por sí sola el reclutamiento ni una afirmación de eficacia.

### Fase 7 — Escritura y cierre de memoria

**Estado:** memoria v4 activa y auditada; reabrir después de cada resultado ejecutado.

La memoria integrará solo argumentos respaldados por el proceso. Se revisarán coherencia narrativa, trazabilidad, lenguaje académico, APA 7, definiciones, redundancias y correspondencia entre problema, usuarios, propuesta y validación.

## Criterio para cambiar de fase

Una fase se considera suficientemente desarrollada cuando:

- sus preguntas están respondidas o declaradas como límites;
- la evidencia puede localizarse;
- las inferencias están diferenciadas de los datos;
- existen decisiones explícitas y justificadas;
- las contradicciones relevantes no han sido ocultadas;
- la siguiente fase puede formularse sin inventar supuestos.

---

## Registro de cambios (disclaimer)

### 2026-09-11 — Ruta visual corregida

- **Qué cambió:** la fase de propuesta dirige a la investigación visual reiniciada y distingue criterios de especificaciones cerradas.
- **Cómo estaba antes:** una dirección de comunicación y color gobernaba las piezas nuevas.
- **Por qué se decidió:** mantener una sola fuente activa y evitar decisiones por inercia.


### 2026-09-09 — Limpieza y vigencia documental

- **Cambio:** se retiraron pendientes ya resueltos y se precisó el carácter selectivo del archivo y de las ampliaciones de mercado.
- **Antes:** el orden de trabajo conservaba verbos de inicio para entregables terminados y proponía cerrar la migración general.
- **Motivo:** sincronizar la ruta con los documentos y las Issues abiertas.
- **Alcance:** Revisión documental; no añade resultados ni modifica el protocolo o los artefactos.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se corrigió la referencia visual rectora y se distinguió selección de canales de validación.
- **Versión anterior:** La respuesta estaba dispersa o conservaba formulaciones anteriores.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.

### 2026-09-08 — Puerta micro:bit ejecutable

- **Cambio:** la hoja de ruta reconoce el programa compilado, elimina el wireframe ya resuelto como bloqueo inmediato y divide la comprobación entre banco rojo sin participantes y material cálido de fase A.
- **Versión anterior:** el siguiente paso todavía comenzaba por congelar el wireframe y trataba la plataforma existente como una única prueba de luz.
- **Motivo:** hacer que el orden operativo corresponda al estado real y a las capacidades de micro:bit V2.
- **Alcance:** la compilación no demuestra funcionamiento; siguen pendientes placa, instalación, montaje cálido, mediciones y revisión.

### 2026-09-07 — Puertas físicas reordenadas

- **Cambio:** la fase de factibilidad y la de prototipado distinguen ahora la comprobación con plataforma existente de la integración portátil con XIAO nRF52840.
- **Versión anterior:** la siguiente puerta exigía inventariar y comparar B1/B2 como rutas físicas principales.
- **Motivo:** sincronizar la hoja de ruta con D-047 y evitar fabricar varias arquitecturas antes de comprobar el comportamiento mínimo.
- **Alcance:** las Issues #11, #10 y #8 siguen abiertas; no se incorporan resultados ni se omite la revisión electrónica.

### 2026-08-30 — B2 deja de ser bloqueo documental

- **Cambio:** la siguiente puerta comienza en inventario y revisión porque B2 ya dispone de esquema revisable.
- **Versión anterior:** la hoja de ruta situaba la redacción del esquema B2 como primer pendiente.
- **Motivo:** mantener la secuencia de trabajo en el estado comprobable del repositorio.
- **Alcance:** la revisión, la compra y la comparación continúan pendientes.

### 2026-08-30 — Puerta B1/B2 anterior a la construcción

- **Cambio:** desarrollo y prototipado incorporan la comparación entre dos fuentes de 5 V y enlazan la Issue #10 como dependencia de la Issue #8.
- **Versión anterior:** la hoja de ruta daba por preparada una única arquitectura cableada de 12 V y situaba su construcción como acción inmediata.
- **Motivo:** decidir la escala y el tipo de luz antes de consolidar componentes que pueden resultar innecesarios.
- **Decisión derivada:** primero se iguala la documentación y revisión de B1 y B2; después se construye solo la variante seleccionada.

### 2026-08-30 — Preparación técnica anterior a la construcción

- **Cambio:** la fase activa incorpora arquitectura cableada, costos y firmware provisional, manteniendo separadas preparación, construcción, ensayo y trabajo con participantes.
- **Versión anterior:** la hoja de ruta solo reconocía instrumentos y requisitos mínimos.
- **Motivo:** sincronizar la dependencia principal con el montaje ya documentado.
- **Decisión derivada:** la próxima acción sustantiva sigue siendo construir y comprobar la señal; el código preparado no modifica esa puerta.

### 2026-08-30 — Estado verificable de usuarios

- **Cambio:** se separó el análisis completado de los perfiles, recorridos y requisitos que existen en forma narrativa, pero todavía no como entregables autónomos.
- **Versión anterior:** la hoja de ruta marcaba toda la traducción de usuarios como completada.
- **Motivo:** evitar que el apartado redactado de la memoria se confunda con el cierre de las herramientas de diseño que deben sostenerlo.
- **Decisión derivada:** la Issue #2 permanece abierta únicamente para producir tres documentos trazables, sin crear personas biográficas.

### 2026-08-30 — Perfiles y recorridos documentados

- **Cambio:** se completaron las fichas de perfiles situacionales y la separación entre recorridos actuales y escenario futuro.
- **Versión anterior:** la traducción existía solo en forma narrativa dentro de la memoria y la arquitectura de interacción.
- **Motivo:** cerrar herramientas de diseño trazables antes de consolidar requisitos.
- **Decisión derivada:** la matriz de requisitos es el único entregable autónomo pendiente de la fase de usuarios.

### 2026-08-30 — Cierre provisional de la fase de usuarios

- **Cambio:** se completó la matriz autónoma de requisitos y se comprobó su correspondencia con perfiles, recorridos, memoria y validación.
- **Versión anterior:** la fase mantenía pendiente la traducción final entre hallazgos y requisitos verificables.
- **Motivo:** cerrar la capa documental antes de modificarla con resultados futuros.
- **Decisión derivada:** la fase se revisará únicamente ante una contradicción auditada o nueva evidencia de prototipos.

### 2026-08-30 — Calendario institucional confirmado

- **Cambio:** se incorporaron el Pase de Examen del 25 de noviembre, la entrega de memoria del 2 de diciembre y el periodo de exámenes del 14 al 18 de diciembre.
- **Versión anterior:** la hoja de ruta utilizaba el 11 de diciembre como fecha objetivo pendiente de confirmación.
- **Motivo:** sincronizar la ruta general con el calendario oficial de la Coordinación de Titulación.
- **Decisión derivada:** se mantienen el 31 de octubre y el 15 de noviembre como cierres internos anticipados.

### 2026-08-29 — Calendario de cierre

- **Cambio:** se enlazó la secuencia por fases con un calendario de hitos y criterios de salida hasta diciembre.
- **Versión anterior:** la hoja de ruta declaraba dependencias, pero no indicaba cuándo debía quedar terminado el producto, la memoria o la preparación de entrega.
- **Motivo:** convertir la ruta metodológica en un compromiso temporal verificable sin duplicar el calendario completo.

### 2026-08-28 — Inicio de la sistematización intersoportes

- **Cambio:** se registraron la matriz común y las primeras aplicaciones visuales por soporte.
- **Versión anterior:** la hoja de ruta informaba una dirección conceptual seleccionada, pero todavía no aplicada.
- **Motivo:** reflejar el avance sin confundir exploración gráfica con validación o diseño final.

### 2026-08-28 — Selección visual dentro de la fase 4

- **Cambio:** se registró `Transferencia situada` como base conceptual seleccionada y se abrió su sistematización.
- **Versión anterior:** la fase 4 mantenía tres direcciones visuales en comparación.
- **Motivo:** alinear la hoja de ruta con la selección realizada por el autor sin anticipar decisiones industriales o de señal.

### 2026-08-28 — Exploración visual dentro de la fase 4

- **Cambio:** se incorporó la dirección visual como desarrollo de la propuesta y se separó de las decisiones que dependen de validación.
- **Versión anterior:** la fase 4 registraba arquitectura, pero no enlazaba un proceso visual trazable.
- **Motivo:** permitir investigación formal sin convertir una preferencia estética en especificación funcional.
- **Decisión derivada:** comparar y seleccionar una dirección antes de sistematizarla; mantener abiertos objeto y señal física.

### 2026-08-28 — Puerta operativa de la fase A

- **Cambio:** se reemplazó el inicio genérico de la prueba por una puerta técnica verificable y se registró por separado el bloqueo de la fase B.
- **Versión anterior:** la hoja de ruta indicaba comenzar por la asociación, sin mostrar qué documentación ya existía ni qué impedía ejecutarla.
- **Motivo:** sincronizar la gobernanza con `07_validacion` y mantener separadas preparación, ejecución y resultados.
- **Decisión derivada:** la única acción sustantiva siguiente es construir y comprobar la señal manual; todavía no corresponde reclutar ni interpretar resultados.

### 2026-08-26 — Memoria v4 y etapas descriptivas

- **Cambio:** se sincronizó la hoja de ruta con `memoria-vigente-v4.md`, se reemplazaron códigos internos por nombres descriptivos y se corrigió la descripción del corpus de entrevistas.
- **Versión anterior:** la hoja remitía a la v2 y describía la transcripción mediante información técnica ajena al método de entrevista.
- **Motivo:** mantener un registro claro del levantamiento real y evitar que la nomenclatura operativa pase a la narración académica.
- **Decisión derivada:** la siguiente actividad continúa siendo la prueba de asociación; no se modifican la muestra ni los pendientes técnicos.

### 2026-08-25 — Cierre editorial posterior al desarrollo estructural

- **Cambio:** se registró la incorporación de tres interacciones, nueve marcos y 35 estados a la memoria, y se marcó el Encargo 17 como completado.
- **Versión anterior:** la hoja declaraba la memoria v2 auditada, pero mantenía el desarrollo del Encargo 17 en pausa.
- **Motivo:** sincronizar la secuencia de trabajo con los resultados documentales efectivamente producidos.
- **Decisión derivada:** P0 continúa como única línea sustantiva activa y se gestiona en la Issue #8; los wireframes no sustituyen su ejecución.

### 2026-08-24 — Memoria v2 y transición a P0

- **Cambio:** se actualizaron los estados de usuarios, problema, mercado, propuesta, factibilidad, evaluación y escritura.
- **Versión anterior:** la migración documental era la única línea activa y las fases 2–7 figuraban como pendientes.
- **Motivo:** la memoria v2 y sus auditorías documentan avances verificables en todas esas áreas, sin convertir el plan de prototipado en resultados.
- **Decisión derivada:** la próxima línea sustantiva es cerrar y ejecutar P0; Encargo 17 y la migración general permanecen en pausa.

### 2026-08-23 — Prioridad documental

- **Cambio:** se añadió una línea auxiliar activa y se pausó el paso de personas.
- **Versión anterior:** la hoja abría inmediatamente perfiles y recorridos.
- **Motivo:** el autor priorizó migrar el archivo local completo y explicarlo en Markdown.
- **Decisión derivada:** no desarrollar dos áreas en paralelo; la fase de usuarios se retoma después de una base documental suficiente.

### 2026-08-23 — Avance de la fase 1

- **Cambio:** se marcó como completada la secuencia desde corpus hasta tipología y se precisó el rango observado.
- **Versión anterior:** todos los pasos de análisis figuraban como próximos y el rango de convocatoria podía confundirse con el rango efectivo.
- **Motivo:** mantener la hoja de ruta sincronizada con los entregables registrados.
- **Decisión derivada:** abrir únicamente el desarrollo de personas y recorridos.

### 2026-08-23 — Cierre de procedencia e inicio operativo de la matriz

- **Cambio:** se consolidó la metodología real del levantamiento y se reemplazó la preservación de notas por el uso de la transcripción digital como corpus operativo.
- **Versión anterior:** la hoja de ruta mantenía abierta la recuperación de notas y condicionaba el uso del corpus a esa tarea.
- **Motivo:** el autor confirmó que todas las preguntas fueron realizadas por él y que la transcripción digital anonimizada conserva el contenido del levantamiento presencial.
- **Decisión derivada:** avanzar a libro de códigos y matriz P1–P8 sin mantener un bloqueo artificial.

### 2026-08-23 — Creación de la hoja de ruta

- **Cambio:** se organizó el proyecto en fases dependientes y criterios de avance.
- **Versión anterior:** no existía una secuencia única documentada.
- **Motivo:** impedir que la forma final del producto anteceda a la investigación.
