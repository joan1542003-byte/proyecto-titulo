# Índice operativo del repositorio

Este documento indica dónde comenzar, qué archivo funciona como referencia vigente y cómo distinguir el desarrollo actual del material histórico. Su propósito es evitar que una versión anterior oriente una decisión nueva por accidente.

## Orden de lectura

1. [README principal](../README.md): síntesis del proyecto, estado actual y arquitectura general.
2. [Directrices de trabajo](directrices-de-trabajo.md): reglas para investigar, escribir, decidir y registrar cambios.
3. [Memoria vigente](../08_memoria/memoria-vigente-v4.md): texto académico que organiza el proyecto en su estado actual.
4. [Resumen vigente](../08_memoria/resumen-vigente-proyecto.md): síntesis breve para recuperar rápidamente qué es Relevo.
5. Las áreas de contexto, investigación, usuarios, mercado, propuesta, factibilidad y validación, en ese orden.
6. [Sistema visual](../10_recursos_visuales/README.md): dirección visual, aplicaciones, exploraciones y piezas editoriales.
7. [Encargos fechados](../00_admin/encargos/README.md): entregas organizadas para revisión.

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
| `07_validacion` | Planificada | Protocolos, criterios de evaluación y resultados cuando existan. |
| `08_memoria` | Texto académico vigente | Versiones, anexos, auditorías, referencias y resumen del proyecto. |
| `09_decisiones` | Registro vigente | Decisiones tomadas, razones, evidencia y consecuencias. |
| `10_recursos_visuales` | Vigente y exploratoria | Sistema visual, piezas editoriales, gráficos, tipografías y exportaciones. |
| `99_archivo` | Histórico | Fuentes locales, entregas anteriores y material conservado por trazabilidad. |

## Fuentes de referencia actuales

- La memoria que debe orientar la redacción es `08_memoria/memoria-vigente-v4.md`.
- La explicación breve que debe acompañar cada actualización es `08_memoria/resumen-vigente-proyecto.md`.
- La entrega fechada del 2 de septiembre se revisa desde `00_admin/encargos/encargo-02-09-2026/README.md`.
- La dirección visual se consulta desde `10_recursos_visuales/08_direccion_visual_relevo/README.md` y sus carpetas de sistema.
- Las versiones anteriores no se borran si permiten reconstruir una decisión; se consultan desde `99_archivo` o desde la carpeta histórica indicada por cada README.

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

### 2026-09-02 — Creación del índice operativo

- **Qué cambió:** se creó un mapa único de lectura, estados y fuentes de referencia del repositorio.
- **Cómo estaba antes:** la función de cada carpeta estaba distribuida entre el README principal y varios índices locales.
- **Qué se conservó:** no se eliminaron archivos ni se alteró el contenido de las áreas de trabajo.
- **Por qué se decidió:** reducir ambigüedades entre memoria vigente, entregas fechadas, exploraciones y archivo histórico.
