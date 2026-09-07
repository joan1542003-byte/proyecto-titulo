# Índice operativo del repositorio

Este documento indica dónde comenzar, qué archivo funciona como referencia vigente y cómo distinguir el desarrollo actual del material histórico. Su propósito es evitar que una versión anterior oriente una decisión nueva por accidente.

## Orden de lectura

1. [README principal](../README.md): síntesis del proyecto, estado actual y arquitectura general.
2. [Guía de comunicación](guia-comunicacion-relevo.md): forma de explicar Relevo por audiencias, tiempos, ejemplos y niveles de certeza.
3. [Directrices de trabajo](directrices-de-trabajo.md): reglas para investigar, escribir, decidir y registrar cambios.
4. [Auditoría integral del 7 de septiembre](auditoria-integridad-2026-09-07.md): comprobaciones, correcciones, fuentes vigentes y pendientes reales.
5. [Auditoría de organización](auditoria-organizacion-2026-09-02.md): revisión estructural anterior y criterio de conservación.
6. [Memoria vigente](../08_memoria/memoria-vigente-v4.md): texto académico que organiza el proyecto en su estado actual.
7. [Resumen vigente](../08_memoria/resumen-vigente-proyecto.md): síntesis breve para recuperar rápidamente qué es Relevo.
8. Las áreas de contexto, investigación, usuarios, mercado, propuesta, factibilidad y validación, en ese orden.
9. [Sistema visual](../10_recursos_visuales/README.md): dirección visual, aplicaciones, exploraciones y piezas editoriales.
10. [Encargos fechados](../00_admin/encargos/README.md): entregas organizadas para revisión.

## Mapa de carpetas

| Carpeta | Estado | Qué contiene |
|---|---|---|
| `00_admin` | Administración | Encargos fechados, controles, registros y herramientas de apoyo. |
| `00_gobernanza` | Vigente | Reglas, calendario, criterios de calidad y este índice. |
| `01_contexto_y_fuentes` | Vigente y de respaldo | Procedencia, corpus, bibliografía y documentos que sostienen las afirmaciones. |
| `02_investigacion` | Vigente | Preguntas, método y síntesis de investigación. |
| `03_usuarios` | Vigente y en desarrollo | Análisis anonimizado, patrones, tipos de usuario y recorridos. |
| `04_mercado_y_referentes` | Vigente y en desarrollo | Estado del arte, mercado, referentes, comparación y oportunidades. |
| `05_propuesta_phygital` | Vigente y en desarrollo | Propuesta, arquitectura de experiencia, flujos y wireframes. |
| `06_desarrollo_y_factibilidad` | Vigente y en desarrollo | Tecnología, producción, costos, riesgos y límites. |
| `07_validacion` | Preparada; ejecución pendiente | Protocolos, criterios de evaluación, instrumentos y puertas técnicas; todavía no hay resultados. |
| `08_memoria` | Texto académico vigente | Versiones, anexos, auditorías, referencias y resumen del proyecto. |
| `09_decisiones` | Registro vigente | Decisiones tomadas, razones, evidencia y consecuencias. |
| `10_recursos_visuales` | Vigente y exploratoria | Sistema visual, piezas editoriales, gráficos, tipografías y exportaciones. |
| `99_archivo` | Histórico | Fuentes locales, entregas anteriores y material conservado por trazabilidad. |

## Fuentes de referencia actuales

- La memoria que debe orientar la redacción es `08_memoria/memoria-vigente-v4.md`.
- La explicación breve que debe acompañar cada actualización es `08_memoria/resumen-vigente-proyecto.md`.
- La explicación pública, oral o demostrativa debe mantener las capas y los límites de `00_gobernanza/guia-comunicacion-relevo.md`.
- La entrega fechada del 2 de septiembre se revisa desde `00_admin/encargos/encargo-02-09-2026/README.md`.
- La dirección vigente de comunicación, naming y color se consulta en `10_recursos_visuales/comunicacion-naming-y-paleta-2026-09-07.md`; las carpetas anteriores conservan el proceso visual.
- Las versiones anteriores no se borran si permiten reconstruir una decisión; se consultan desde `99_archivo` o desde la carpeta histórica indicada por cada README.

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

## Registro de cambios (disclaimer)

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
