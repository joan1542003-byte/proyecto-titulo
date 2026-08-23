# Proyecto de título — Relevo

Repositorio privado de investigación, desarrollo y documentación del proyecto de titulación de Johan Yantén, carrera de Diseño, Universidad Diego Portales.

## Propósito del repositorio

Este repositorio es la fuente central de trazabilidad del proyecto. Conserva de manera ordenada:

- el contexto y la evolución de Relevo;
- las fuentes y su nivel de confiabilidad;
- las decisiones de investigación y diseño;
- el análisis de usuarios;
- el estado del arte y el mercado;
- los flujos de usuario, diseño y funcionamiento técnico;
- el desarrollo del producto phygital;
- la factibilidad, producción y costos;
- la validación;
- las versiones de la memoria y sus cambios;
- las tareas pendientes mediante GitHub Issues.

## Síntesis provisional

Relevo es un proyecto phygital que busca devolver una intención personal a la consideración de una persona durante una sesión de ocio digital poco deliberada. La formulación vigente combina una aplicación Android con un testigo físico doméstico, sin pantalla, situado cerca del lugar u objeto donde una actividad puede comenzar.

El proyecto no pretende prohibir aplicaciones, reducir el tiempo de pantalla como fin en sí mismo ni evaluar el comportamiento. Su valor propuesto depende de apoyar una decisión autónoma mediante una señal breve, configurable y no punitiva.

Esta formulación continúa abierta a revisión. El producto final deberá responder a la investigación, no antecederla.

## Estado actual

**Fase 1 activa: investigación y análisis de usuarios.**

La fase 0 quedó cerrada después de aclarar que:

- las ocho entrevistas son reales y se realizaron presencialmente en Santiago;
- existió consentimiento informado;
- las notas manuscritas son el registro original;
- la IA se utilizó únicamente después del levantamiento para apoyar la transcripción, organización y redacción académica;
- las dos preguntas adicionales también se realizaron presencialmente y quedaron registradas en notas;
- P6 tiene 27 años.

La tarea sustantiva vigente está en la [Issue #2](https://github.com/joan1542003-byte/proyecto-titulo/issues/2). La preservación de las notas originales se controla por separado en la [Issue #3](https://github.com/joan1542003-byte/proyecto-titulo/issues/3).

## Principios de trabajo

- Investigar antes de concluir o diseñar.
- Desarrollar una sola área principal a la vez.
- Vincular cada decisión del producto con evidencia, una hipótesis o una restricción explícita.
- Distinguir hechos, interpretaciones, hipótesis y decisiones.
- Preferir bibliografía académica desde 2019; usar fuentes anteriores cuando sean fundamentales o no exista evidencia reciente equivalente.
- Redactar en español claro y académico, con citas y referencias según APA 7.
- Explicar los conceptos especializados en su primera aparición.
- Evitar contenido de relleno, reiteraciones y formulaciones no respaldadas.
- Usar consistentemente el término **phygital**.
- No mencionar encargos, talleres o procesos docentes internos dentro del cuerpo definitivo de la memoria.
- Mantener los datos identificables fuera del repositorio.
- Cerrar cada documento Markdown con un registro de cambios.

Las reglas completas están en [Directrices de trabajo](https://github.com/joan1542003-byte/proyecto-titulo/blob/main/00_gobernanza/directrices-de-trabajo.md).

## Arquitectura

| Directorio | Función |
|---|---|
| `00_gobernanza` | Reglas, metodología de trabajo, hoja de ruta y criterios de calidad. |
| `01_contexto_y_fuentes` | Contexto, inventario, procedencia y evaluación de las fuentes. |
| `02_investigacion` | Preguntas, marco conceptual, fichas bibliográficas y síntesis de evidencia. |
| `03_usuarios` | Datos anonimizados, análisis, patrones, personas y recorridos. |
| `04_mercado_y_referentes` | Estado del arte, mercado, comparaciones y oportunidades. |
| `05_propuesta_phygital` | Propósito, arquitectura, interacción, forma y propuesta de valor. |
| `06_desarrollo_y_factibilidad` | Tecnología, producción, costos, riesgos, ventajas y límites. |
| `07_validacion` | Hipótesis, protocolos, resultados y criterios de decisión. |
| `08_memoria` | Arquitectura narrativa, capítulos, versiones y control APA 7. |
| `09_decisiones` | Registro cronológico de decisiones y cambios de dirección. |
| `99_archivo` | Material superado que debe conservarse sin tratarse como vigente. |

## Gestión de tareas

Las acciones pendientes se registran como GitHub Issues. Los documentos Markdown conservan el razonamiento, la evidencia y los resultados; las Issues conservan el estado operativo, responsables y criterios de cierre.

---

## Registro de cambios

### 2026-08-23 — Inicio de la fase 1

- **Cambio:** actualización del estado del proyecto, incorporación de las aclaraciones metodológicas y enlaces a las Issues #2 y #3.
- **Versión anterior:** el repositorio permanecía en fase 0 y describía la procedencia de las entrevistas como una duda abierta.
- **Motivo:** el autor confirmó la modalidad presencial, el consentimiento, la fuente manuscrita, el uso posterior de IA, la procedencia de las preguntas adicionales y la edad de P6.
- **Decisión derivada:** comenzar el análisis de usuarios sin presentar como literales las redacciones procesadas por IA.

### 2026-08-23 — Inicialización documental

- **Cambio:** reemplazo del README mínimo por el contexto, propósito, principios y arquitectura prevista del repositorio.
- **Versión anterior:** el archivo contenía únicamente `# proyecto-titulo`.
- **Motivo:** establecer una fuente central, legible y trazable antes de incorporar investigación o desarrollo.
