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

**Fase 1 activa: análisis de usuarios.**

La base metodológica del corpus quedó consolidada:

- se realizaron ocho entrevistas semiestructuradas, habladas y presenciales en Santiago durante junio de 2026;
- las personas fueron reclutadas mediante referencias de la red personal, dentro del rango de 18 a 30 años definido para el levantamiento;
- se obtuvo consentimiento informado oral;
- todas las preguntas y repreguntas fueron realizadas por el investigador;
- la asistencia automatizada se utilizó únicamente para transcribir las conversaciones después del levantamiento;
- el documento digital de transcripción constituye el corpus operativo;
- las notas manuscritas ya no están disponibles y su ausencia no bloquea el análisis;
- P6 tiene 27 años;
- la duración individual de las entrevistas no quedó registrada.

El análisis se desarrolla en la [Issue #2](https://github.com/joan1542003-byte/proyecto-titulo/issues/2). La antigua tarea de preservación de notas se conserva como decisión cerrada en la [Issue #3](https://github.com/joan1542003-byte/proyecto-titulo/issues/3).

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
| `99_archivo` | Material superado que debe conservarse sin tratarse como vigente. |

## Gestión de tareas

Las acciones pendientes se registran como GitHub Issues. Los documentos Markdown conservan el razonamiento, la evidencia y los resultados; las Issues conservan el estado operativo y los criterios de cierre.

---

## Registro de cambios (disclaimer)

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
