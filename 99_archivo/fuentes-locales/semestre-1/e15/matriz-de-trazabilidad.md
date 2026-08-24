---
id: FL-S1-E15-TRAZ-001
titulo: "Matriz de trazabilidad del feedback E15"
autoria: propia
estado_documental: vigente
relacion_con_proyecto: "control de observaciones y pendientes"
sensibilidad: interna
fecha_creacion: 2026-08-23
---

# Matriz de trazabilidad del feedback E15

## Función

Esta matriz convierte el feedback histórico en un sistema de seguimiento. Una observación puede abrir una pregunta o una tarea, pero no se considera una decisión de diseño hasta que exista evidencia suficiente y quede registrada en el repositorio.

## Criterios vigentes del autor

- Relevo debe ser un proyecto phygital.
- La organización documental y la reconstrucción del proceso son la línea activa.
- La visualidad no es requisito de la entrega actual.
- Las decisiones de usuario deben partir de las entrevistas reales y pueden evolucionar.
- El producto final debe derivarse de investigación, no precederla.
- Se desarrolla una sola área sustantiva a la vez.

Estos criterios prevalecen sobre las formulaciones históricas del E15.

## Leyenda de estados

- **Aceptado como criterio:** orienta el proceso actual, pero todavía puede requerir desarrollo.
- **Por investigar:** falta evidencia externa o empírica.
- **Por decidir:** existen alternativas y aún no corresponde elegir.
- **Pospuesto:** pertinente, pero fuera del alcance de la unidad actual.
- **No incorporable:** no debe trasladarse a la memoria ni convertirse en requisito.
- **Histórico:** se conserva para reconstruir la evaluación.

## Prioridad 0 — Fundamento antes de desarrollar

| ID | Observación de origen | Tratamiento actual | Estado | Evidencia o resultado requerido |
|---|---|---|---|---|
| E15-01 | El objeto físico y su ubicación no se entendían. | Definir Relevo en lenguaje directo y distinguir objeto, interfaz y sistema. | Aceptado como criterio | Formulación breve respaldada por arquitectura y escenario de uso. |
| E15-02 | El contexto doméstico no estaba justificado. | Tratar el hogar como hipótesis, no como hecho cerrado. | Por investigar | Entrevistas, recorrido de usuario y literatura contextual que expliquen cuándo, dónde y por qué ocurre el problema. |
| E15-03 | El proyecto intentaba abordar demasiados problemas. | Delimitar problema, contexto, conducta y primera intervención sin reducir prematuramente el universo de investigación. | Aceptado como criterio | Declaración de alcance, exclusiones y relación con el problema amplio. |
| E15-04 | No estaban definidos éxito y fracaso. | Crear criterios de éxito de experiencia, producto y funcionamiento. | Por investigar | Necesidades de usuario, hipótesis de cambio, métricas observables y límites técnicos. |
| E15-05 | No se mostraron usuarios ni incidencia de entrevistas. | Vincular cada decisión de usuario con P1–P8 y distinguir recurrencias, excepciones y vacíos. | Aceptado como criterio | Matriz de evidencia, perfiles analíticos y recorrido sustentado. |
| E15-06 | Faltaba contexto de producto y mercado. | Analizar categorías, mecanismos, adopción, límites y líneas actuales de desarrollo; no hacer solo una lista de referentes. | Por investigar | Estado del arte de mercado con fuentes verificables y fichas comparables. |
| E15-07 | El valor del proyecto y del diseñador no era explícito. | Formular por qué el problema merece intervención phygital y cuál es el aporte disciplinar del diseño. | Por investigar | Argumento de valor conectado con usuarios, brecha del mercado y decisiones del sistema. |

## Prioridad 1 — Arquitectura y experiencia

| ID | Observación de origen | Tratamiento actual | Estado | Evidencia o resultado requerido |
|---|---|---|---|---|
| E15-08 | El diagrama mezclaba funcionamiento técnico y experiencia. | Mantener tres registros separados: flujo técnico, flujo de usuario y flujo de diseño. | Aceptado como criterio | Diagramas o descripciones secuenciales con entradas, salidas, responsables y excepciones. |
| E15-09 | No se entendía cómo funcionaba la aplicación. | Describir acciones, estados, datos y respuestas sin depender del nombre de una tecnología. | Por decidir | Arquitectura funcional y escenarios normal, alternativo y de fallo. |
| E15-10 | No estaba justificada la modalidad de retroalimentación. | Comparar luz, sonido, vibración y combinaciones según contexto, eficacia, intrusión y accesibilidad. | Por investigar | Criterios de selección, literatura, pruebas con usuarios y riesgos. |
| E15-11 | La accesibilidad no estaba incorporada. | Integrarla como criterio desde la definición de estímulos e interacción. | Por investigar | Requisitos perceptivos, alternativas redundantes y pruebas inclusivas. |
| E15-12 | La decisión de no gamificar era insuficiente. | Separar gamificación, recompensa, castigo y diseño no punitivo antes de aceptar o rechazar mecánicas. | Por investigar | Definiciones, evidencia de efectos y decisión argumentada para Relevo. |
| E15-13 | Android e iOS aparecían sin definición clara. | No fijar plataforma hasta conocer alcance, factibilidad y necesidades. | Por decidir | Matriz de compatibilidad, permisos, restricciones, costo y mantenimiento. |
| E15-14 | La implementación eclipsó al proyecto. | Usar la tecnología como evidencia de factibilidad, subordinada al problema, la experiencia y el valor. | Aceptado como criterio | Relación explícita entre requerimiento, decisión, prototipo y aprendizaje. |

## Prioridad 2 — Producción y sostenibilidad

| ID | Observación de origen | Tratamiento actual | Estado | Evidencia o resultado requerido |
|---|---|---|---|---|
| E15-15 | Faltaban precio, instalación y costos. | Desarrollar modelo preliminar de producción, instalación, operación y mantenimiento después de estabilizar el alcance. | Pospuesto | Lista de materiales, costos directos e indirectos, escenarios de escala y supuestos. |
| E15-16 | No estaba claro cuánto vale el rol del diseñador. | Registrar funciones, entregables, decisiones y horas del diseño dentro del sistema. | Pospuesto | Desglose de trabajo y relación entre aporte de diseño y valor del producto. |

## Prioridad 3 — Comunicación y trazabilidad

| ID | Observación de origen | Tratamiento actual | Estado | Evidencia o resultado requerido |
|---|---|---|---|---|
| E15-17 | La explicación no respondía qué, cómo, cuándo y por qué. | Aplicar esas preguntas como prueba de claridad a cada definición central. | Aceptado como criterio | Ficha de definición del proyecto y revisión editorial. |
| E15-18 | La teoría ocultaba el objeto. | Presentar primero una definición concreta; después, el fundamento que explica las decisiones. | Aceptado como criterio | Arquitectura narrativa de memoria y presentación con funciones distintas. |
| E15-19 | Diapositivas y documento competían con la voz. | Reservar desarrollo teórico y citas extensas para la memoria; diseñar la presentación según su función oral. | Pospuesto | Guion y sistema de diapositivas cuando la entrega lo requiera. |
| E15-20 | Había errores formales y vocabulario impreciso. | Mantener revisión ortográfica, terminológica, editorial y visual como control de calidad. | Aceptado como criterio | Lista de control y revisión humana antes de cada entrega. |
| E15-21 | El cronograma invisibilizaba marzo y abril. | Reconstruir el proceso completo y registrar decisiones con fecha y fuente. | Aceptado como criterio | Cronología verificable y bitácora de decisiones. |
| E15-22 | Se pedían mockups, videos y diagramas para comunicar. | Conservar el requisito metodológico de claridad, pero no producir visualidad para la entrega actual. | Pospuesto | Activar solo cuando la etapa o entrega lo exija. |

## Elementos que no se adoptan automáticamente

| ID | Contenido de la fuente | Decisión | Estado | Motivo |
|---|---|---|---|---|
| E15-X01 | Caso de uso centrado en sedentarismo, zapatillas y puerta de salida. | Conservar como ejemplo de especificidad, no como solución seleccionada. | No incorporable como requisito | No proviene de la investigación de usuarios ni de una comparación de alternativas. |
| E15-X02 | Apreciaciones sobre timidez, confianza o mecanismos personales. | No trasladar a la memoria ni usar para evaluar el proyecto. | No incorporable | Son valoraciones personales situadas, ajenas a la evidencia del problema de diseño. |
| E15-X03 | Calificación 5,0 y condición de aprobación. | Conservar únicamente como antecedente académico. | Histórico | No informa usuario, mercado, experiencia ni factibilidad. |
| E15-X04 | Referencia a una forma específica de presentar productos. | Tomar solo el principio general de adecuación entre medio y mensaje. | No incorporable como modelo obligatorio | Una comparación retórica no sustituye criterios de comunicación propios del proyecto. |
| E15-X05 | Pausar la programación. | Interpretar como advertencia histórica contra saltarse etapas, no como prohibición permanente. | Aceptado como criterio de secuencia | La implementación puede continuar cuando esté ligada a una pregunta y documente qué valida. |

## Orden de activación

1. Cerrar la organización y la procedencia del archivo.
2. Retomar el análisis de usuarios y el contexto de uso.
3. Investigar problema, mercado y enfoques existentes.
4. Formular valor, alcance y criterios de éxito.
5. Construir recorridos y flujos separados.
6. Comparar modalidades phygital y accesibilidad.
7. Definir arquitectura, plataforma, producción y costos.
8. Desarrollar visualidad y presentación cuando la entrega lo requiera.

Solo una etapa se mantiene activa a la vez. Las demás permanecen registradas como backlog.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se descompuso el feedback en veintidós observaciones operativas y cinco elementos no adoptables de forma automática.
- **Versión anterior:** la síntesis activa agrupaba prioridades, pero no asignaba ID, estado, evidencia requerida ni orden de activación.
- **Motivo:** convertir observaciones históricas en TODO verificable sin confundirlas con decisiones vigentes.
- **Alcance:** ningún pendiente se considera resuelto por aparecer en esta matriz.

