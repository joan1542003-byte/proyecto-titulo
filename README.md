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

## Síntesis provisional

Relevo es un proyecto phygital que busca devolver una intención personal a la consideración de una persona durante una sesión de ocio digital poco deliberada. La formulación vigente combina una aplicación Android con un testigo físico doméstico, sin pantalla, situado cerca del lugar u objeto donde una actividad puede comenzar.

El proyecto no pretende prohibir aplicaciones, reducir el tiempo de pantalla como fin en sí mismo ni evaluar el comportamiento. Su valor propuesto depende de apoyar una decisión autónoma mediante una señal breve, configurable y no punitiva.

Esta formulación continúa abierta a revisión. El producto final deberá responder a la investigación y a la evidencia, no antecederlas.

## Estado actual

**Línea activa: actualización de la memoria y preparación escrita del Encargo 17.**

La base metodológica del corpus quedó consolidada:

- se realizaron ocho entrevistas semiestructuradas, habladas y presenciales en Santiago durante junio de 2026;
- las personas fueron reclutadas mediante referencias de la red personal; el criterio de convocatoria fue de 18 a 30 años y el rango observado fue de 19 a 27 años;
- se obtuvo consentimiento informado oral;
- todas las preguntas y repreguntas fueron realizadas por el investigador;
- la asistencia automatizada se utilizó únicamente para transcribir las conversaciones después del levantamiento;
- el documento digital de transcripción constituye el corpus operativo;
- las notas manuscritas ya no están disponibles y su ausencia no bloquea el análisis;
- P6 tiene 27 años;
- la duración individual de las entrevistas no quedó registrada.

El criterio común de selección confirmado para P1–P8 es la edad; no se utilizará la condición de estudiante como rasgo común. Como la entrega aún no exige visualidad, los futuros perfiles se mantendrán como fichas basadas en evidencia, sin nombres, imágenes o biografías inventadas.

La actualización se gestiona en la [Issue #6](https://github.com/joan1542003-byte/proyecto-titulo/issues/6). La migración general de la [Issue #4](https://github.com/joan1542003-byte/proyecto-titulo/issues/4) queda pausada. La base actual es la [memoria vigente](08_memoria/memoria-vigente.md) y la estructura se prepara en [Encargo 17](05_propuesta_phygital/preparacion-escrita-encargo-17.md).

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
| `99_archivo` | Material histórico y fuentes locales migradas, con estado y procedencia explícitos. |

## Gestión de tareas

Las acciones pendientes se registran como GitHub Issues. Los documentos Markdown conservan el razonamiento, la evidencia y los resultados; las Issues conservan el estado operativo y los criterios de cierre.

---

## Registro de cambios (disclaimer)

### 2026-08-24 — Memoria vigente y Encargo 17

- **Cambio:** se actualizó la línea activa y se enlazaron memoria y preparación escrita.
- **Versión anterior:** la migración documental era la única línea activa.
- **Motivo:** priorizar escritura antes de visualidad.
- **Alcance:** la migración queda pausada; el objeto sigue sin pantalla.


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

- **Cambio:** se incorporaron fecha, rango etario, modalidad, reclutamiento, consentimiento, autoría de preguntas, procedimiento de transcripción, edad de P6 y estado del corpus.
- **Versión anterior:** se presentaban las notas manuscritas como fuente primaria pendiente de preservar y se atribuían a la asistencia automatizada tareas posteriores más amplias.
- **Motivo:** el autor aclaró que todo el levantamiento fue hablado y dirigido por él, que la asistencia automatizada solo transcribió y que las notas ya no están disponibles.
- **Decisión derivada:** usar la transcripción digital anonimizada como corpus operativo y cerrar la preservación de notas como tarea no realizable, sin tratarla como bloqueo.

### 2026-08-23 — Inicio de la fase 1

- **Cambio:** se actualizó el estado del proyecto y se enlazaron las Issues de trabajo.
- **Versión anterior:** el repositorio permanecía en fase 0 y describía la procedencia de las entrevistas como una duda abierta.
- **Motivo:** existían antecedentes suficientes para iniciar el análisis de usuarios.

### 2026-08-23 — Inicialización documental

- **Cambio:** se reemplazó el README mínimo por el contexto, propósito, principios y arquitectura del repositorio.
- **Versión anterior:** el archivo contenía únicamente `# proyecto-titulo`.
- **Motivo:** establecer una fuente central, legible y trazable antes de incorporar investigación o desarrollo.
