# Auditoría de redacción y estructura — memoria v4

**Fecha de creación:** 26 de agosto de 2026
**Último control:** 9 de septiembre de 2026
**Documento revisado:** `memoria-vigente-v4.md`

## Resultado

La memoria v4 recupera la progresión narrativa del cierre del primer semestre y mantiene los catorce títulos que ordenaban ese documento. La propuesta aparece por primera vez en el capítulo 10, después de la motivación, la introducción, el problema, la justificación, los antecedentes, el marco teórico, los usuarios, el estado del arte y los criterios de diseño. La única excepción es el resumen académico, cuya función exige sintetizar el documento completo.

## Correspondencia estructural

1. Motivación personal.
2. Introducción.
3. Planteamiento del problema.
4. Justificación.
5. Antecedentes y estado de la cuestión.
6. Marco teórico por ámbitos.
7. Usuario, contexto y hallazgos de entrevistas.
8. Estado del arte y referentes.
9. Criterios de diseño.
10. Formulación.
11. Bajada proyectual.
12. Factibilidad y límites.
13. Plan de desarrollo y validación.
14. Referencias.

## Control de extensión

Conteo actualizado después de la edición de lectura del 9 de septiembre, mediante separación por espacios en blanco del Markdown sin renderizar (`str.split` de Python). Los segmentos incluyen sus encabezados: archivo completo 21.589; inicio hasta antes de `# 14. Referencias`, 17.920; desde `# 1. Motivación personal` hasta antes de referencias, 17.252; referencias hasta antes de `## Registro de cambios`, 1.239; registro hasta el final, 2.430. Los capítulos 1–13 se mantienen dentro del rango general de 15.000–20.000 palabras. El total operativo incluye bibliografía y trazabilidad. La entrega editorial deberá confirmar qué segmentos computa la institución.

Para los límites por apartado se cuenta solo su prosa: se excluyen encabezados, palabras clave y el apartado siguiente. El resumen y el abstract mantienen correspondencia de contenido. La tabla usa ese criterio uniforme, que reemplaza los conteos aproximados previos.

| Apartado con límite explícito | Palabras de prosa | Rango requerido | Resultado |
| --- | ---: | ---: | --- |
| Resumen | 286 | 200–300 | Cumple. |
| Abstract | 268 | 200–300 | Cumple. |
| Motivación personal | 178 | 100–300 | Cumple. |
| Introducción | 623 | 600–1.200 | Cumple. |
| Planteamiento del problema | 779 | 400–800 | Cumple. |
| Justificación | 358 | 300–600 | Cumple. |

Los capítulos extensos mantienen una proporción semejante a la memoria del primer semestre: el marco teórico se desarrolla por ámbitos, mientras usuarios y estado del arte reciben espacio suficiente para sostener la formulación.

## Jerarquía y continuidad de lectura

La memoria conserva la numeración de los catorce capítulos. Dentro de ellos utiliza 42 subtítulos temáticos, frente a los 78 subapartados numerados anteriores, y elimina los 14 encabezados de tercer nivel. Los títulos agrupan argumentos; los párrafos enlazan evidencia, interpretación e implicación de diseño. No se añadieron textos para alcanzar una extensión por apartado.

| Capítulo | Organización actual |
| --- | --- |
| 3 | Tres aristas; la síntesis continúa sin un cuarto subtítulo. |
| 5 | Experiencia, intervenciones, recordatorios y alcance de los antecedentes. |
| 6 | Tres ámbitos teóricos y su conclusión, sin subdivisiones numéricas. |
| 7 | Método completo, hallazgos contrastados, situaciones de usuario y recorridos/contexto. La encuesta pendiente se separa del método de entrevistas. |
| 8 | Comparación por mecanismos, con fuentes, tabla y límites conservados. |
| 9 | Ocho criterios desarrollados en tres argumentos; C1–C8 permanecen identificables en la matriz externa. |
| 10 | Problema y pregunta, definición y alcance, hipótesis y objetivos, actores. |
| 11 | Componentes, recorrido, funcionamiento, acceso y autonomía, soporte y comunicación. |
| 12 | Arquitectura, fabricación/costos, seguridad y gestión/límites. |
| 13 | Asociación/comparación, desarrollo progresivo, registros/decisiones y conclusiones. Reúne el proceso que antes se repetía en el capítulo 11. |

Se revisaron conectores y repeticiones después de agrupar los textos. Se explican testigo, ciclo, armado, evaluación formativa y componentes de señal; se retiran los códigos internos de los antiguos montajes del cuerpo académico. El cambio es editorial: no introduce datos ni altera la pregunta, la hipótesis o los umbrales de prueba.

## Controles narrativos

- La motivación se limita a la experiencia personal presente. No explica la evolución del proyecto ni adelanta el producto.
- La introducción define ocio digital, desplazamiento infinito, decisión renovada y memoria prospectiva antes de utilizarlos como base argumental.
- La introducción y el cierre del marco teórico desarrollan el argumento sin describir la organización del documento ni anunciar la formulación.
- Se usa únicamente `desplazamiento infinito`; no se alterna con su denominación en inglés.
- Se eliminó la expresión `continuidad digital poco deliberada`. El fenómeno se describe mediante frases directas, sin convertirlo en una categoría innecesaria.
- El problema mantiene tres aristas: experiencial y cognitiva, tecnológica y evaluativa.
- Los dos usuarios se presentan como situaciones que una misma persona puede ocupar, no como biografías inventadas.
- El estado del arte compara mecanismos, evidencia, fortalezas, fallos y desarrollos recientes. No funciona como catálogo de productos.
- Relevo se formula después de los criterios de diseño y se describe en términos positivos por la relación que construye entre intención, primer paso, lugar y señal.
- Las etapas de prueba tienen nombres descriptivos. No se utilizan códigos internos en la memoria.
- Las afirmaciones sobre entrevistas, mercado, funcionamiento y factibilidad distinguen evidencia, hipótesis y trabajo pendiente.
- Q13 se presenta por su función metodológica —una propuesta preliminar de señal ambiental— sin trasladar al cuerpo el nombre de una etapa histórica.
- La factibilidad distingue la ruta micro:bit/XIAO vigente desde el 7–8 de septiembre de los costos de mesa del 30 de agosto, conservados como antecedentes; separa desembolsos incompletos de costo, producción y precio.

## Control de APA 7

La [matriz de correspondencia](matriz-citas-referencias-v4-2026-08-27.md) registra 52 entradas. Se preserva la auditoría previa de 51 referencias y se verifica la nueva cita de Gibbons (2017) en [Continuidad de la experiencia y soporte](memoria-vigente-v4.md#continuidad-de-la-experiencia-y-soporte); esta actualización no repite la evaluación del contenido de todas las fuentes. Se corrigieron el orden de una cita parentética, dos posiciones alfabéticas y los sufijos de obras con la misma autoría y sin fecha. Las afirmaciones comerciales continúan diferenciadas de la evidencia académica.

## Control de trazabilidad de criterios

La [matriz de trazabilidad](matriz-trazabilidad-criterios-v4-2026-08-27.md) relaciona cada criterio del capítulo 9 con literatura, entrevistas o estado del arte. El control confirma que los ocho criterios poseen un fundamento identificable y conservan un límite explícito. Ninguno se presenta como una característica validada de Relevo.

## Verificación de la edición de lectura

Se comprobó que los catorce títulos de capítulo mantienen su orden, que no quedan subtítulos numéricos ni un tercer nivel en el cuerpo, y que las 52 entradas bibliográficas permanecen idénticas. Se conservaron las 84 citas entre paréntesis que contienen fecha, la pregunta de investigación, la hipótesis y los parámetros del protocolo. Los seis apartados con límites particulares cumplen sus rangos. Los registros históricos de los documentos modificados permanecen íntegros.

La comprobación de navegación revisa rutas locales y los destinos de los nuevos enlaces a títulos de la memoria. La revisión de escritura comprueba conexiones y repeticiones; no constituye una prueba de comprensión con lectores externos.

## Decisión editorial

`memoria-vigente-v4.md` reemplaza a la v3 como archivo académico activo. Las versiones anteriores se conservan para trazabilidad, pero no deben utilizarse como base de redacción mientras la v4 siga vigente. No se genera un nuevo DOCX porque el formato solicitado para esta etapa es Markdown.

---

## Registro de cambios

### 2026-09-09 — Jerarquía y lectura de la memoria

- **Cambio:** se actualizó la referencia a la memoria después de agrupar apartados, mejorar transiciones y sustituir la numeración secundaria por títulos temáticos.
- **Versión anterior:** conservaba ubicaciones o controles correspondientes a los subapartados numerados.
- **Motivo:** mantener la trazabilidad sin obligar al lector a reconstruir la estructura anterior.
- **Alcance:** revisión editorial; fuentes, protocolo y resultados pendientes se mantienen.

### 2026-09-09 — Coherencia de la memoria

- **Cambio:** se sincronizó este documento con la revisión de la memoria y su auditoría de cobertura.
- **Versión anterior:** describía el estado previo a la reconciliación del recorrido, soporte y alcance comparativo.
- **Motivo:** mantener una base académica consistente y pendientes localizables.
- **Alcance:** documental; no incorpora resultados ni modifica el protocolo.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se corrigió una referencia temporal de factibilidad que seguía atribuyendo vigencia a la comparación de agosto.
- **Versión anterior:** La respuesta estaba dispersa o conservaba formulaciones anteriores.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.

**8 de septiembre de 2026 — Fuente luminosa y conteo sincronizados.** Se actualizó el control después de distinguir la matriz roja del banco técnico y la luz blanca cálida del material con participantes. Antes, la auditoría registraba 20.307 palabras totales, 16.334 en los capítulos 1–13 y 49 referencias en su apartado APA. Ahora registra 20.453, 16.359 y 51, respectivamente. La modificación conserva el cuerpo dentro del rango y no incorpora resultados de validación.

**7 de septiembre de 2026 — Ruta física y control editorial.** Se actualizó el conteo después de sustituir la ruta B1/B2 por una prueba con plataforma existente y una integración portátil con XIAO nRF52840. Antes, la auditoría registraba 19.809 palabras totales, 16.113 en los capítulos 1–13 y 49 referencias. Ahora registra 20.307, 16.334 y 50, respectivamente. El cuerpo se mantiene dentro del rango; no se incorporaron resultados y el total operativo incluye bibliografía y trazabilidad.

**31 de agosto de 2026 — Revisión final textual y vigencia técnica.** Se repitieron los controles de estructura, extensión, metalenguaje y consistencia con factibilidad. Antes, la memoria conservaba dos pasajes autorreferenciales, nombraba una etapa histórica en el método y utilizaba un rango económico anterior a la comparación B1/B2. Ahora el cuerpo mantiene el mismo orden y las mismas fuentes, pero explica Q13 por su función, enlaza la arquitectura técnica activa y comunica solo desembolsos trazables. No se añadieron resultados ni se cerraron decisiones que requieren pruebas.

**30 de agosto de 2026 — Asociación y control.** Se actualizó la extensión después de separar los cuatro momentos de asociación de la comprensión de las salidas. Antes, memoria y protocolo usaban cuatro y cinco componentes respectivamente. El cambio no altera los límites por apartado, la muestra ni los resultados inexistentes.

**27 de agosto de 2026 — Parámetros e instrumentos del protocolo 01.** Se actualizó la extensión después de fijar la muestra en seis personas y traducir los umbrales a cantidades de casos. El protocolo cuenta ahora con parámetros de ejecución, borrador de consentimiento y ficha vacía de registro. No se han reclutado participantes ni producido resultados.

**27 de agosto de 2026 — Reglas operativas de validación.** Se actualizó la extensión después de incorporar al capítulo 13 la definición de asociación completa, umbrales formativos y fallos críticos. Antes, la memoria no fijaba cómo avanzar, modificar o detener la primera configuración. En ese control, el protocolo conservaba preguntas previas al reclutamiento que fueron cerradas en la revisión siguiente.

**27 de agosto de 2026 — Selección de anexos.** Se actualizó la extensión después de enlazar el índice de anexos desde usuarios y arquitectura de interacción. Antes, la evidencia complementaria estaba distribuida por el repositorio sin una selección formal. El nuevo índice no duplica documentos ni incorpora materiales internos como evidencia.

**27 de agosto de 2026 — Registros operativos y metodológicos.** Se actualizó la extensión después de aclarar la frontera entre los datos necesarios para ejecutar un ciclo y los registros temporales de las pruebas. Antes, la exclusión de registros de cumplimiento y la existencia de fichas de observación podían parecer incompatibles. La corrección no añade funciones al producto ni fija todavía los protocolos finales.

**27 de agosto de 2026 — Clasificación del cierre académico.** Se actualizó la extensión tras separar en las conclusiones los hallazgos, la decisión proyectual, el aporte alcanzado, la hipótesis pendiente y el criterio de continuidad. Antes, el valor propuesto y el aporte todavía no demostrado del objeto podían confundirse. No se añadieron resultados ni referencias.

**27 de agosto de 2026 — Trazabilidad de criterios.** Se actualizó la extensión después de fundamentar individualmente los ocho criterios del capítulo 9 y se enlazó su matriz de respaldo. Antes, la auditoría registraba 18.260 palabras y no contaba con un control específico para la relación entre evidencia y criterios. La modificación no añadió referencias ni resultados de pruebas.

**27 de agosto de 2026 — Actualización de extensión y control APA.** Se reemplazó el conteo aproximado del 26 de agosto por una medición reproducible del archivo completo, el cuerpo, las referencias y el registro de cambios. También se enlazó la matriz completa de 49 referencias. Antes, la auditoría informaba 16.470 palabras y solo declaraba una correspondencia bibliográfica básica. Los límites de las secciones siguen cumpliéndose y no se añadieron fuentes nuevas.

**26 de agosto de 2026 — Creación.** Se creó esta auditoría para comprobar el orden narrativo, los títulos, los límites de extensión, la introducción de conceptos y la ubicación de la formulación en `memoria-vigente-v4.md`. Antes, la auditoría disponible correspondía a la v3 y no incorporaba la corrección específica sobre anticipación del proyecto. El documento no añade contenido académico ni resultados; registra los controles aplicados a la nueva versión.
