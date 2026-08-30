# Proyecto de título — Relevo

Repositorio privado de investigación, desarrollo y documentación del proyecto de titulación de Johan Yantén, carrera de Diseño, Universidad Diego Portales.

## Propósito del repositorio

Este repositorio es la fuente central de trazabilidad del proyecto. Ordena y relaciona:

- contexto, antecedentes y evolución de Relevo;
- fuentes y niveles de evidencia;
- decisiones de investigación y diseño;
- análisis de usuarios;
- estado del arte y mercado;
- flujos de usuario, diseño y funcionamiento técnico;
- desarrollo del producto phygital;
- factibilidad, producción y costos;
- validaciones;
- versiones de la memoria;
- tareas pendientes mediante GitHub Issues.

## Síntesis vigente

Relevo es un proyecto phygital que busca recuperar una intención personal cuando una sesión de ocio digital continúa y esa alternativa deja de orientar el siguiente paso. La propuesta combina una aplicación Android con un objeto situado junto al comienzo de una actividad elegida.

El proyecto no pretende prohibir aplicaciones, reducir el tiempo de pantalla como fin en sí mismo ni evaluar el comportamiento. Su valor propuesto depende de apoyar una decisión autónoma mediante una señal breve, configurable y no punitiva.

Esta formulación continúa abierta a revisión. El producto final deberá responder a la investigación y a la evidencia, no antecederlas.

La versión breve y mantenida después de cada actualización está en el [resumen vigente de Relevo](08_memoria/resumen-vigente-proyecto.md).

## Estado actual

**Línea activa: [prueba de asociación entre intención, primer paso, lugar y señal](https://github.com/joan1542003-byte/proyecto-titulo/issues/8).**

El procedimiento, el consentimiento, la ficha de registro y los requisitos mínimos de la señal manual están documentados en [`07_validacion`](07_validacion/README.md). La fase A cuenta con una [arquitectura provisional y un costo parcial de componentes identificados](06_desarrollo_y_factibilidad/montaje-minimo-fase-a-2026-08-30.md), un [esquema de conexión pendiente de revisión eléctrica](06_desarrollo_y_factibilidad/esquema-conexion-provisional-fase-a-2026-08-30.md) y [firmware preparado para revisión](06_desarrollo_y_factibilidad/prototipo-fase-a/README.md). El circuito aún no está aprobado para energización: faltan la revisión electrónica, una única ruta de alimentación para el Nano, terminales y protección de la rama de 12 V. Después corresponde comprar, compilar, construir y completar el ensayo técnico antes de convocar participantes. La fase B permanece bloqueada hasta disponer de una notificación local Android comparable. No existen resultados de validación.

La [dirección visual de Relevo](10_recursos_visuales/08_direccion_visual_relevo/README.md) ya cuenta con una base conceptual seleccionada: `Transferencia situada`. El sistema dispone de [aplicaciones exploratorias](10_recursos_visuales/08_direccion_visual_relevo/aplicaciones/README.md) para objeto, memoria y Android, gobernadas por una matriz común. Permanecen abiertos el logotipo final, la tipografía, la forma industrial y los parámetros de la señal física.

La base metodológica del corpus quedó consolidada:

- se realizaron ocho entrevistas semiestructuradas, habladas y presenciales en Santiago los días 11 y 12 de junio de 2026;
- las personas fueron reclutadas mediante referencias de la red personal; el criterio de convocatoria fue de 18 a 30 años y el rango observado fue de 19 a 27 años;
- se obtuvo consentimiento informado oral;
- todas las preguntas y repreguntas fueron realizadas por el investigador;
- el documento digital anonimizado constituye el corpus operativo del análisis;
- P6 tiene 27 años;
- la duración individual de las entrevistas no quedó registrada.

El criterio común de selección confirmado para P1–P8 es la edad; no se utilizará la condición de estudiante como rasgo común. Como el trabajo vigente no exige visualidad, los perfiles se mantienen como fichas basadas en evidencia, sin nombres, imágenes o biografías inventadas.

La [Issue #6](https://github.com/joan1542003-byte/proyecto-titulo/issues/6) reúne los [wireframes estructurales del Encargo 17](05_propuesta_phygital/entrega-encargo-17.md). La [Issue #8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8) concentra el siguiente trabajo empírico; la migración general de la [Issue #4](https://github.com/joan1542003-byte/proyecto-titulo/issues/4) permanece en pausa. La base académica activa es la [memoria v4](08_memoria/memoria-vigente-v4.md), respaldada por su [auditoría de redacción y estructura](08_memoria/auditoria-redaccion-v4-2026-08-26.md). La [v3](08_memoria/memoria-vigente-v3.md), las auditorías anteriores y la [matriz histórica](01_contexto_y_fuentes/matriz-historica-encargos-memoria.md) conservan la trazabilidad del proceso.

El [plan de cierre agosto–diciembre de 2026](00_gobernanza/plan-de-cierre-agosto-diciembre-2026.md) sitúa al proyecto en la transición desde definición documentada hacia prototipado y validación. La [Issue #9](https://github.com/joan1542003-byte/proyecto-titulo/issues/9) controla sus hitos. El producto debe quedar prácticamente terminado el 31 de octubre y el proyecto completo el 15 de noviembre. La memoria se entrega oficialmente el 2 de diciembre y el examen se realiza entre el 14 y el 18; el periodo intermedio se reserva para estudiar, ensayar y resolver correcciones menores.

## Inicio para nuevas conversaciones

Antes de trabajar con ChatGPT o Codex, conecta GitHub y usa [Instrucciones maestras para conversaciones](INSTRUCCIONES_CHATGPT.md). Ese documento define el protocolo de lectura del repositorio, el contexto estable, las reglas de investigación y escritura, y el registro de resultados.

## Principios de trabajo

- Investigar antes de concluir o diseñar.
- Desarrollar una sola área principal a la vez.
- Vincular cada decisión del producto con evidencia, una hipótesis o una restricción explícita.
- Distinguir hechos, interpretaciones, hipótesis y decisiones.
- Preferir bibliografía académica publicada desde 2019; usar fuentes anteriores cuando sean fundamentales o no exista evidencia reciente equivalente.
- Redactar en español claro y académico, con citas y referencias según APA 7.
- Explicar los conceptos especializados en su primera aparición.
- Evitar contenido de relleno, reiteraciones y afirmaciones no respaldadas.
- Usar consistentemente el término **phygital**.
- No mencionar encargos, talleres o procesos docentes internos dentro del cuerpo definitivo de la memoria.
- Mantener los datos identificables fuera del repositorio.
- Cerrar cada documento Markdown con un registro de cambios.
- Registrar tanto lo que se decide como la evidencia y la razón de la decisión.
- Sincronizar el [resumen vigente](08_memoria/resumen-vigente-proyecto.md) cada vez que se modifique la memoria.

Las reglas completas están en [Directrices de trabajo](https://github.com/joan1542003-byte/proyecto-titulo/blob/main/00_gobernanza/directrices-de-trabajo.md).

## Arquitectura

| Directorio | Función |
|---|---|
| `00_gobernanza` | Reglas, metodología de trabajo, hoja de ruta y criterios de calidad. |
| `01_contexto_y_fuentes` | Contexto, inventario, procedencia y evaluación de las fuentes. |
| `02_investigacion` | Preguntas, marco conceptual, fichas bibliográficas y síntesis de evidencia. |
| `03_usuarios` | Datos anonimizados, análisis, patrones, tipos de usuario y recorridos. |
| `04_mercado_y_referentes` | Estado del arte, mercado, comparaciones y oportunidades. |
| `05_propuesta_phygital` | Propósito, arquitectura, interacción, forma y propuesta de valor. |
| `06_desarrollo_y_factibilidad` | Tecnología, producción, costos, riesgos, ventajas y límites. |
| `07_validacion` | Hipótesis, protocolos, resultados y criterios de decisión. |
| `08_memoria` | Arquitectura narrativa, capítulos, versiones y control APA 7. |
| `09_decisiones` | Registro cronológico de decisiones y cambios de dirección. |
| `10_recursos_visuales` | Escenas, texturas y módulos gráficos sintéticos para explorar la comunicación visual de Relevo. |
| `99_archivo` | Material histórico y fuentes locales migradas, con estado y procedencia explícitos. |

## Gestión de tareas

Las acciones pendientes se registran como GitHub Issues. Los documentos Markdown conservan el razonamiento, la evidencia y los resultados; las Issues conservan el estado operativo y los criterios de cierre.

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Puerta eléctrica explicitada

- **Cambio:** la portada distingue el costo parcial del montaje, enlaza el esquema de conexión y declara las condiciones que impiden energizar el circuito.
- **Versión anterior:** resumía esos pendientes como una revisión general y podía dar a entender que la lista de materiales estaba completa.
- **Motivo:** evitar que la portada contradiga la documentación técnica y que una arquitectura provisional se interprete como un montaje seguro o validado.
- **Alcance:** no se modificó el diseño del circuito ni se añadieron costos, componentes o resultados.

### 2026-08-30 — Montaje de fase A y calendario sincronizados

- **Cambio:** el estado principal enlaza la arquitectura cableada, sus costos, el firmware provisional y las puertas que siguen pendientes; también corrige la entrega de memoria al 2 de diciembre y el examen al periodo del 14 al 18.
- **Versión anterior:** solo informaba requisitos e instrumentos, por lo que no distinguía el avance de diseño técnico de una construcción todavía inexistente, y conservaba el 11 de diciembre como fecha estimada.
- **Motivo:** mantener visible el siguiente paso real sin presentar código o lista de materiales como funcionamiento comprobado.
- **Alcance:** no se compraron componentes, no se compiló el firmware y no se ejecutaron ensayos.

### 2026-08-29 — Plan de cierre hasta la entrega

- **Cambio:** se incorporaron el estado de madurez, los hitos de cierre de octubre, noviembre y diciembre, y la Issue #9 como tablero operativo.
- **Versión anterior:** el README identificaba la línea activa, pero no comunicaba el plazo total ni la función de cada periodo.
- **Motivo:** permitir que cualquier conversación o colaborador comprenda de inmediato qué debe terminarse y cuándo.
- **Alcance:** no se modificó la memoria ni se añadieron resultados de validación.

### 2026-08-28 — Aplicaciones del sistema visual

- **Cambio:** se enlazaron las exploraciones coordinadas para objeto, memoria y aplicación.
- **Versión anterior:** el estado principal informaba la selección visual, pero no sus aplicaciones por soporte.
- **Motivo:** facilitar acceso a las piezas, fundamentos, auditoría y decisiones asociadas.

### 2026-08-28 — Dirección visual seleccionada

- **Cambio:** se actualizó el estado visual desde exploración abierta a dirección conceptual seleccionada.
- **Versión anterior:** el repositorio informaba tres alternativas sin selección.
- **Motivo:** reflejar la decisión del autor y mantener visibles los aspectos que todavía requieren desarrollo o validación.

### 2026-08-28 — Dirección visual en exploración

- **Cambio:** se enlazó el nuevo proceso visual y se distinguieron alternativas, criterios y decisiones todavía abiertas.
- **Versión anterior:** el estado principal no permitía localizar una investigación visual sistemática.
- **Motivo:** mantener accesible la documentación sin presentar una exploración como identidad final.
- **Alcance:** la memoria y la arquitectura funcional de Relevo no cambiaron.

### 2026-08-28 — Estado operativo de la primera validación

- **Cambio:** se enlazaron los instrumentos preparados y se distinguieron las condiciones pendientes de las fases A y B.
- **Versión anterior:** el estado solo indicaba que la prueba de asociación era la línea activa.
- **Motivo:** evitar que la preparación documental se confunda con ejecución o resultados.
- **Alcance:** no se construyó el prototipo, no se reclutaron participantes y no se registraron datos.

### 2026-08-26 — Activación de la memoria v4

- **Cambio:** se declaró `08_memoria/memoria-vigente-v4.md` como base académica activa y se actualizó la descripción breve del proyecto.
- **Versión anterior:** la raíz remitía a la v3, empleaba una denominación compleja para el fenómeno y nombraba la siguiente prueba mediante un código interno.
- **Motivo:** mantener el repositorio sincronizado con una memoria más fiel al orden del primer semestre y más clara para lectores externos.
- **Alcance:** la definición funcional de Relevo se mantiene; cambia la forma de narrarla y documentarla.

### 2026-08-26 — Activación de la memoria v3

- **Cambio:** se declaró `08_memoria/memoria-vigente-v3.md` como base académica activa y se enlazó su auditoría narrativa.
- **Versión anterior:** la v2 era el cierre editorial vigente y presentaba la formulación antes de completar el fundamento investigativo.
- **Motivo:** recuperar el orden del cierre del primer semestre y cumplir la rúbrica mediante aristas, justificación, tres ámbitos teóricos, usuarios, estado del arte y criterios antes de la formulación.
- **Alcance:** la definición funcional de Relevo se mantiene; no se añadieron resultados de prototipo.

### 2026-08-25 — Cierre editorial de la memoria

- **Cambio:** se declaró la memoria activa como cierre editorial del estado real y se registró la cobertura estructural de 35 estados.
- **Versión anterior:** la memoria v2 estaba auditada, pero el desarrollo posterior de wireframes permanecía documentado solo en la propuesta phygital.
- **Motivo:** mantener sincronizados investigación, diseño y estado operativo del repositorio.
- **Alcance:** el siguiente trabajo sustantivo continúa en la Issue #8 dedicada a P0; no se agregaron resultados de validación inexistentes.

### 2026-08-25 — Cierre del Encargo 17

- **Cambio:** se registró la entrega de nueve wireframes estructurales en Figma y se cerró la Issue #6.
- **Versión anterior:** el Encargo 17 permanecía en pausa mientras la memoria integral tenía prioridad.
- **Motivo:** la memoria v2 permitió cerrar el ciclo mínimo, desarrollar tres interacciones conectadas y auditarlas contra la pauta.
- **Alcance:** la entrega resuelve estructura; condición, señal, forma y factibilidad pasan a P0–P4.

### 2026-08-25 — Primera colección visual exploratoria

- **Cambio:** se añadió `10_recursos_visuales` con escenas, texturas, recursos transparentes, variantes cromáticas y una hoja de contacto para explorar una línea visual de Relevo.
- **Motivo:** disponer de material gráfico coherente con la relación entre intención, primer paso, lugar y pulso ambiental.
- **Límite:** los recursos son sintéticos y exploratorios; no representan evidencia de usuarios ni cierran la forma, materialidad o señal final del testigo.

### 2026-08-24 — Definición positiva del testigo

- **Cambio:** se reemplazó la descripción negativa del objeto por su función concreta como testigo físico situado de una intención activa.
- **Versión anterior:** la síntesis lo definía principalmente mediante una exclusión técnica.
- **Motivo:** una propuesta de valor debe explicar qué hace y qué relación construye, no enumerar componentes ausentes.
- **Alcance:** la interfaz objetual seguirá basada en señales ambientales; canal, forma y electrónica se cerrarán mediante desarrollo y prueba.

### 2026-08-24 — Recuperación del historial estructural

- **Cambio:** se enlazaron el resumen vigente y la matriz histórica de encargos, y se estableció su actualización junto con la memoria.
- **Versión anterior:** el README enlazaba la memoria y su auditoría, pero no ofrecía una síntesis breve ni la trazabilidad de requisitos acumulativos.
- **Motivo:** permitir que el autor y nuevas conversaciones comprendan rápidamente qué es Relevo y por qué la memoria adopta su estructura.
- **Alcance:** el resumen no sustituye la memoria; la matriz histórica orienta organización y no se cita como evidencia académica del problema.

### 2026-08-24 — Activación de la memoria integral v2

- **Cambio:** se declaró `memoria-vigente-v2.md` como base académica activa y se enlazó su auditoría rectora.
- **Versión anterior:** `memoria-vigente.md` era la base activa y la preparación escrita de la Issue #6 compartía prioridad.
- **Motivo:** la v2 integra investigación, usuarios, mercado, propuesta, flujos, producción, gestión y evaluación con estados de evidencia explícitos.
- **Alcance:** la v1 se preserva; las Issues #4 y #6 permanecen pausadas; la Issue #7 conserva el seguimiento de los pendientes críticos de la memoria.

### 2026-08-24 — Memoria vigente y Encargo 17

- **Cambio:** se actualizó la línea activa y se enlazaron memoria y preparación escrita.
- **Versión anterior:** la migración documental era la única línea activa.
- **Motivo:** priorizar escritura antes de visualidad.
- **Alcance:** la migración queda pausada; el canal y la forma del testigo siguen abiertos a desarrollo y prueba.


### 2026-08-23 — Instrucciones para nuevas conversaciones

- **Cambio:** se añadió un acceso directo a las instrucciones maestras para ChatGPT y Codex.
- **Versión anterior:** una conversación nueva debía reconstruir el protocolo desde varios documentos y mensajes previos.
- **Motivo:** asegurar continuidad, lectura correcta de GitHub y recuperación del estado vigente desde las Issues.
- **Decisión derivada:** toda conversación nueva debe comenzar por el repositorio y no por recuerdos aislados.

### 2026-08-23 — Activación de la migración documental

- **Cambio:** se pausó el desarrollo de personas, se registró que la edad es el único criterio común y se enlazó la nueva arquitectura de fuentes locales.
- **Versión anterior:** el siguiente paso activo era construir personas y recorridos.
- **Motivo:** el autor priorizó convertir y ordenar la documentación local antes de continuar el desarrollo analítico.
- **Decisión derivada:** trabajar una sola línea principal mediante la Issue #4; no añadir visualidad de personas mientras no sea exigida.

### 2026-08-23 — Integridad del corpus y tipología

- **Cambio:** se precisó el rango observado y se actualizó el estado después de construir corpus anonimizado, libro de códigos, casos, matriz y dos tipos situacionales.
- **Versión anterior:** el README solo indicaba el criterio amplio de 18 a 30 años y situaba la fase antes de la matriz.
- **Motivo:** reflejar los datos efectivos P1–P8 y el avance verificable del análisis.
- **Decisión derivada:** continuar con personas y recorridos sin volver a segmentar por demografía.

### 2026-08-23 — Consolidación metodológica de las entrevistas

- **Cambio:** se incorporaron fecha, rango etario, modalidad, reclutamiento, consentimiento, autoría de preguntas, edad de P6 y estado del corpus.
- **Versión anterior:** la procedencia y el alcance del registro no estaban diferenciados con claridad.
- **Motivo:** el autor confirmó que todo el levantamiento fue hablado, presencial y dirigido por él.
- **Decisión derivada:** usar la transcripción digital anonimizada como corpus operativo y privilegiar paráfrasis en el análisis.

### 2026-08-23 — Inicio de la fase 1

- **Cambio:** se actualizó el estado del proyecto y se enlazaron las Issues de trabajo.
- **Versión anterior:** el repositorio permanecía en fase 0 y describía la procedencia de las entrevistas como una duda abierta.
- **Motivo:** existían antecedentes suficientes para iniciar el análisis de usuarios.

### 2026-08-23 — Inicialización documental

- **Cambio:** se reemplazó el README mínimo por el contexto, propósito, principios y arquitectura del repositorio.
- **Versión anterior:** el archivo contenía únicamente `# proyecto-titulo`.
- **Motivo:** establecer una fuente central, legible y trazable antes de incorporar investigación o desarrollo.
