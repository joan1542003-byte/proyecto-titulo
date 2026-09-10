# Índice operativo del repositorio

Este documento indica dónde comenzar, qué archivo funciona como referencia vigente y cómo distinguir el desarrollo actual del material histórico. Su propósito es evitar que una versión anterior oriente una decisión nueva por accidente.


**Base académica actualizada:** [Coherencia de la memoria y pendientes por área](../08_memoria/auditoria-coherencia-memoria-2026-09-09.md). Recorrido, soporte y alcance comparativo reconciliados; evidencia empírica pendiente.

**Consulta del feedback:** [Las 23 preguntas y sus documentos responsables](../01_contexto_y_fuentes/feedback-2026-09-02.md). Respuesta documental disponible; validación empírica pendiente.

## Orden de lectura

1. [README principal](../README.md): síntesis del proyecto, estado actual y arquitectura general.
2. [Guía de comunicación](guia-comunicacion-relevo.md): forma de explicar Relevo por audiencias, tiempos, ejemplos y niveles de certeza.
3. [Directrices de trabajo](directrices-de-trabajo.md): reglas para investigar, escribir, decidir y registrar cambios.
4. [Auditoría de organización del 8 de septiembre](auditoria-organizacion-2026-09-08.md): traslados al archivo antiguo, excepciones y controles de cierre.
5. [Auditoría integral del 8 de septiembre](auditoria-integridad-2026-09-08.md): comprobaciones, correcciones, fuentes vigentes y pendientes reales.
6. [Auditoría de organización del 2 de septiembre](auditoria-organizacion-2026-09-02.md): antecedente estructural y criterio de conservación.
7. [Memoria vigente](../08_memoria/memoria-vigente-v4.md): texto académico que organiza el proyecto en su estado actual.
8. [Resumen vigente](../08_memoria/resumen-vigente-proyecto.md): síntesis breve para recuperar rápidamente qué es Relevo.
9. Las áreas de contexto, investigación, usuarios, mercado, propuesta, factibilidad y validación, en ese orden.
10. [Sistema visual](../10_recursos_visuales/README.md): dirección visual, aplicaciones, exploraciones y piezas editoriales.
11. [Encargos fechados](../00_admin/encargos/README.md): entregas organizadas para revisión.

**Última revisión documental:** [Textos, vigencia y limpieza del 9 de septiembre](auditoria-textual-2026-09-09.md). Las auditorías anteriores describen sus respectivos cortes, no el estado permanente de todas las fuentes.

## Mapa de carpetas

| Carpeta | Estado | Qué contiene |
|---|---|---|
| `00_admin` | Administración | Encargos fechados, controles, registros y herramientas de apoyo. |
| `00_gobernanza` | Vigente | Reglas, calendario, criterios de calidad y este índice. |
| `01_contexto_y_fuentes` | Vigente y de respaldo | Procedencia, corpus, bibliografía y documentos que sostienen las afirmaciones. |
| `02_investigacion` | Vigente | Preguntas, método y síntesis de investigación. |
| `03_usuarios` | Vigente y en desarrollo | Análisis anonimizado, patrones, tipos de usuario y recorridos. |
| `04_mercado_y_referentes` | Vigente y en desarrollo | Estado del arte, mercado, referentes, comparación y oportunidades. |
| `05_propuesta_phygital` | Wireframe v1 cerrado; prototipo en desarrollo | Propuesta, arquitectura de experiencia, flujos y wireframes. |
| `06_desarrollo_y_factibilidad` | Vigente y en desarrollo | Tecnología, producción, costos, riesgos y límites. |
| `07_validacion` | Preparada; ejecución pendiente | Protocolos, criterios de evaluación, instrumentos y puertas técnicas; todavía no hay resultados. |
| `08_memoria` | Texto académico vigente | Memoria v4, anexos, matrices, controles editoriales y resumen del proyecto. |
| `09_decisiones` | Registro vigente | Decisiones tomadas, razones, evidencia y consecuencias. |
| `10_recursos_visuales` | Vigente y exploratoria | Sistema visual, piezas editoriales, gráficos, tipografías y exportaciones. |
| `99_archivo` | Histórico | Fuentes locales y [material antiguo o reemplazado](../99_archivo/antiguo/README.md), conservados por trazabilidad. |

## Fuentes de referencia actuales

- La memoria que debe orientar la redacción es `08_memoria/memoria-vigente-v4.md`.
- La explicación breve que debe acompañar cada actualización es `08_memoria/resumen-vigente-proyecto.md`.
- La explicación pública, oral o demostrativa debe mantener las capas y los límites de `00_gobernanza/guia-comunicacion-relevo.md`.
- La entrega fechada del 2 de septiembre se revisa desde `00_admin/encargos/encargo-02-09-2026/README.md`.
- La línea base para construir Android se consulta en [`cierre-wireframe-v1-2026-09-09.md`](../05_propuesta_phygital/cierre-wireframe-v1-2026-09-09.md); sus fuentes y exportaciones están en `05_propuesta_phygital/wireframes-media-html/`.
- La dirección vigente de comunicación, naming y color se consulta en `10_recursos_visuales/comunicacion-naming-y-paleta-2026-09-07.md`; las carpetas anteriores conservan el proceso visual.
- La ruta física vigente se consulta en `06_desarrollo_y_factibilidad/plataformas-existentes-modificables-2026-09-07.md`; el código y el binario de la puerta inmediata están en `06_desarrollo_y_factibilidad/prueba-microbit-ble/`. La Issue #11 controla esa prueba y la #10 conserva la integración portátil.
- Las versiones anteriores no se borran si permiten reconstruir una decisión; se consultan desde [`99_archivo/antiguo`](../99_archivo/antiguo/README.md).

## Política de duplicados y archivo

- Una copia adicional se conserva solo cuando cumple una función distinta: fuente editable, entrega, respaldo práctico o archivo histórico.
- La fuente vigente siempre es la que enlaza el README correspondiente; las copias planas se identifican como respaldo.
- Un archivo idéntico que no aporta una función nueva puede retirarse después de comprobar su coincidencia y dejar constancia de la decisión.
- Las piezas históricas se conservan cuando permiten reconstruir el proceso, aunque ya no formen parte del recorrido principal.

## Convenciones de orden

- Las carpetas numeradas indican el recorrido de lectura; `99_` identifica material histórico o de apoyo que no debe confundirse con el estado vigente.
- Las fechas usan el formato `AAAA-MM-DD`.
- Cada conjunto de piezas tiene un `README.md` que explica propósito, contenido, estado, límites y procedencia.
- Una imagen no reemplaza su explicación: las piezas importantes deben acompañarse de una justificación y de la relación con la memoria.
- Antes de editar un archivo, se revisa el README de su carpeta y los documentos enlazados que definen su contexto.
- Cada modificación de un documento Markdown termina con su registro de cambios, indicando qué se modificó, cómo estaba antes y por qué se tomó la decisión.

## Qué no debe mezclarse

El material de archivo puede orientar una comparación, pero no debe presentarse como decisión vigente. Del mismo modo, una exportación visual sirve para revisar una dirección, pero no reemplaza la memoria ni demuestra que una interacción, circuito o prueba ya funcione.

---

## Último control del feedback

La [auditoría del 9 de septiembre](auditoria-feedback-2026-09-09.md) registra correcciones, alcance y verificación de las 23 respuestas. Se consulta junto a las auditorías anteriores para reconstruir cambios; estas conservan sus fechas de corte.

## Registro de cambios (disclaimer)


### 2026-09-09 — Limpieza y vigencia documental

- **Cambio:** se enlazó el control textual actual y se aclaró la consulta de versiones.
- **Antes:** el recorrido de lectura no distinguía todos los cambios posteriores a las auditorías y exportaciones anteriores.
- **Motivo:** facilitar una entrada única a la revisión y evitar estados contradictorios.
- **Alcance:** Revisión documental; no añade resultados ni modifica el protocolo o los artefactos.

### 2026-09-09 — Coherencia de la memoria

- **Cambio:** se sincronizó este documento con la revisión de la memoria y su auditoría de cobertura.
- **Versión anterior:** describía el estado previo a la reconciliación del recorrido, soporte y alcance comparativo.
- **Motivo:** mantener una base académica consistente y pendientes localizables.
- **Alcance:** documental; no incorpora resultados ni modifica el protocolo.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se enlazó la auditoría de cobertura y vigencia. Se añadió acceso directo a la respuesta responsable del feedback.
- **Versión anterior:** había respuestas dispersas, índices incompletos o formulaciones sustituidas.
- **Motivo:** mantener una respuesta localizable y coherente con las decisiones vigentes.
- **Alcance:** actualización documental; no se añaden resultados ni se cambian los parámetros del protocolo.

### 2026-09-09 — Línea base de interfaz incorporada

- **Qué cambió:** el índice identifica el wireframe v1 como cerrado y enlaza su registro antes de la construcción Android.
- **Cómo estaba antes:** la carpeta de propuesta figuraba solamente como desarrollo abierto.
- **Por qué se decidió:** asegurar que nuevas revisiones partan de una única secuencia y no de entregas históricas.
- **Alcance:** el cierre es estructural; no acredita implementación ni validación.

### 2026-09-08 — Ruta única para material reemplazado

- **Qué cambió:** el índice distingue la memoria activa de sus versiones anteriores y enlaza el archivo central de antecedentes.
- **Cómo estaba antes:** reconocía el carácter histórico de `99_archivo`, pero permitía que documentos sustituidos permanecieran mezclados en áreas vigentes.
- **Por qué se decidió:** reducir ambigüedad y mantener una regla simple de navegación para nuevas revisiones.
- **Alcance:** no se eliminaron entregas fechadas, fuentes, evidencia ni duplicados que cumplen funciones distintas.

### 2026-09-08 — Paquete ejecutable incorporado al recorrido

- **Qué cambió:** el índice enlaza la implementación micro:bit además del estudio comparativo y prioriza las dos auditorías del 8 de septiembre sobre el antecedente del día 2.
- **Cómo estaba antes:** permitía encontrar la decisión física, pero no el programa que materializa la siguiente puerta; además, la auditoría organizacional más reciente no aparecía en el orden de lectura.
- **Por qué se decidió:** reducir búsquedas y evitar que una conversación vuelva a programar o seleccione un montaje histórico.
- **Alcance:** el enlace conduce a una compilación sin prueba física; no acredita resultados.

### 2026-09-07 — Ruta física incorporada

- **Qué cambió:** se añadió al índice la fuente vigente para distinguir la prueba con plataforma existente de la integración portátil.
- **Cómo estaba antes:** el índice dirigía a factibilidad en términos generales, sin señalar la secuencia controlada por las Issues #11 y #10.
- **Por qué se decidió:** impedir que B1/B2 o una exploración histórica vuelvan a orientar accidentalmente el siguiente prototipo.
- **Alcance:** el índice organiza las fuentes; no acredita construcción ni resultados.

### 2026-09-07 — Auditoría integral incorporada

- **Qué cambió:** se añadió la auditoría transversal más reciente al orden de lectura.
- **Cómo estaba antes:** el índice dirigía únicamente a la auditoría estructural del 2 de septiembre.
- **Por qué se decidió:** permitir que una revisión nueva encuentre primero el estado comprobado después de sincronizar wireframes, maqueta editorial y video.
- **Alcance:** la auditoría anterior se conserva como historial y criterio de organización.

### 2026-09-04 — Ruta de comunicación incorporada

- **Qué cambió:** la guía de comunicación se incorporó al orden de lectura y a las fuentes de referencia actuales.
- **Cómo estaba antes:** el índice dirigía a la formulación y a la memoria, pero no a un criterio transversal para explicar el proyecto a distintas audiencias.
- **Por qué se decidió:** separar la precisión académica del primer nivel de comunicación sin permitir que ambas versiones se contradigan.
- **Alcance:** no cambia la jerarquía de evidencia ni reemplaza el resumen vigente o la memoria.

### 2026-09-02 — Creación del índice operativo

- **Qué cambió:** se creó un mapa único de lectura, estados y fuentes de referencia del repositorio.
- **Cómo estaba antes:** la función de cada carpeta estaba distribuida entre el README principal y varios índices locales.
- **Qué se conservó:** no se eliminaron archivos ni se alteró el contenido de las áreas de trabajo.
- **Por qué se decidió:** reducir ambigüedades entre memoria vigente, entregas fechadas, exploraciones y archivo histórico.

### 2026-09-02 — Precisión del estado de validación y criterio de duplicados

- **Qué cambió:** se reemplazó la etiqueta “Planificada” por una descripción que distingue instrumentos preparados, puertas técnicas y ejecución pendiente; además, se incorporó una política breve para decidir cuándo conservar o retirar copias.
- **Cómo estaba antes:** el índice podía hacer pensar que no existía trabajo de validación documentado y no explicitaba cómo se tratarían los duplicados.
- **Por qué se decidió:** mantener el índice consistente con `07_validacion/README.md` y hacer que futuras limpiezas sean comprobables y reversibles en su justificación.
