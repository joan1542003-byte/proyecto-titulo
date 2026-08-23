# Auditoría de integridad del corpus de entrevistas

## Propósito

Comprobar que el corpus utilizado en la matriz P1–P8 conserve todos los casos, preguntas y datos metodológicos disponibles, y establecer una regla explícita para resolver discrepancias entre dos versiones digitales.

## Archivos revisados

1. `respuestas-invisible-2026-06-13.docx`: exportación digital con las once preguntas base.
2. `ENTREVISTAS+ Memoria vieja.docx`: documento combinado cuyo anexo reúne las once preguntas base y las dos preguntas adicionales.

Los nombres de participantes presentes en los archivos se excluyen de la documentación analítica. El repositorio utiliza únicamente P1–P8.

## Integridad por caso

| Caso | Edad vigente | Fecha | Q1–Q11 en archivo base | Q1–Q11 en anexo | Q12–Q13 en anexo |
|---|---:|---|---:|---:|---:|
| P1 | 21 | 12 de junio de 2026 | 11/11 | 11/11 | 2/2 |
| P2 | 22 | 12 de junio de 2026 | 11/11 | 11/11 | 2/2 |
| P3 | 19 | 11 de junio de 2026 | 11/11 | 11/11 | 2/2 |
| P4 | 22 | 11 de junio de 2026 | 11/11 | 11/11 | 2/2 |
| P5 | 20 | 11 de junio de 2026 | 11/11 | 11/11 | 2/2 |
| P6 | 27 | 11 de junio de 2026 | 11/11 | 11/11 | 2/2 |
| P7 | 21 | 11 de junio de 2026 | 11/11 | 11/11 | 2/2 |
| P8 | 19 | 11 de junio de 2026 | 11/11 | 11/11 | 2/2 |

Las ocho entrevistas cuentan con las once preguntas base. Las dos preguntas adicionales solo se conservan en el anexo. El rango observado es de 19 a 27 años; el criterio de convocatoria fue de 18 a 30 años.

## Discrepancias identificadas

### Edad de P6

- **Archivo base:** 24 años.
- **Anexo:** 27 años.
- **Declaración directa del autor:** 27 años.
- **Decisión:** utilizar 27 años en todo análisis.

### P2-Q10

El anexo omite una parte de la respuesta sobre tener materiales disponibles, desconectarse del celular y realizar el hobby deseado. El archivo base contiene la respuesta más completa y la repregunta del anexo presupone ese fragmento.

**Decisión:** para P2-Q10 se utiliza el archivo base como versión completa.

### Preguntas Q12 y Q13

No aparecen en el archivo base y sí aparecen para los ocho casos en el anexo. El autor confirmó que ambas fueron realizadas presencialmente.

**Decisión:** Q12 y Q13 se incorporan desde el anexo.

### Rótulos de repreguntas

Una versión contiene rótulos automáticos que atribuyen incorrectamente las repreguntas a una herramienta. El autor confirmó que todas fueron formuladas por él durante las conversaciones.

**Decisión:** normalizar todos esos rótulos como `Repregunta`. El rótulo erróneo no constituye un código ni una condición de exclusión.

### Respuestas parcialmente informativas

- **P3-Q6:** responde que habría dicho la verdad, pero no especifica el contenido del relato. Se codifica como respuesta vaga, no como recuerdo claro.
- **P8-Q11:** devuelve una pregunta sobre la cantidad de tiempo libre actual y no responde directamente al cierre. Se registra como respuesta no contestada.
- Respuestas como sí, no, nada o más o menos se conservan; cuando no existe contexto suficiente, no sostienen inferencias fuertes.

## Regla de consolidación

1. Usar el archivo base para Q1–Q11 por conservar respuestas menos condensadas.
2. Usar el anexo para Q12–Q13.
3. Usar el anexo como contraste de continuidad y ortografía, no para sustituir silenciosamente una respuesta más completa.
4. Resolver datos personales contradictorios mediante la declaración directa más reciente del autor.
5. Mantener P1–P8 y excluir nombres.
6. No completar respuestas vagas ni ausentes.
7. Registrar en la matriz la pregunta exacta que sustenta cada hallazgo.

## Revisión estructural y visual

La extracción textual y la estructura de párrafos permitieron comprobar casos, preguntas, fechas y respuestas. No fue posible renderizar nuevamente los DOCX en este entorno porque no se encontró LibreOffice ni el conversor PDF requerido. Esta limitación afecta la comprobación visual de maquetación, no la integridad textual utilizada en el análisis.

## Resultado

El corpus consolidado contiene ocho casos, once preguntas base por caso y dos preguntas adicionales por caso. Las discrepancias relevantes tienen una regla de resolución documentada y no impiden el análisis cualitativo.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se documentó la revisión cruzada de las dos versiones digitales, su cobertura y las discrepancias P6, P2-Q10, P3-Q6 y P8-Q11.
- **Versión anterior:** el repositorio trataba la transcripción como un corpus único sin explicitar qué archivo aportaba cada bloque.
- **Motivo:** asegurar que la matriz utilice la versión más completa de cada respuesta y que ninguna corrección se realice de forma silenciosa.
- **Decisión derivada:** consolidar Q1–Q11 desde el archivo base, Q12–Q13 desde el anexo y P6 como 27 años.
