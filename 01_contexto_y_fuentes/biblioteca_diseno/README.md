# Biblioteca de diseño

## Propósito

Esta biblioteca reúne cuatro obras utilizadas para fundamentar decisiones de diseño de Relevo. No funciona como una colección de frases inspiradoras: cada libro se registra por su procedencia, cobertura, tipo de evidencia, conceptos útiles, límites de interpretación y relación con el sistema phygital.

La biblioteca cumple dos funciones. Primero, conserva una lectura trazable de los archivos que fueron incorporados al repositorio. Segundo, traduce sus aportes a preguntas y decisiones que pueden comprobarse en la aplicación Android, la gráfica editorial y el objeto físico. Una obra no valida por sí sola una decisión de Relevo; permite formularla, justificarla provisionalmente o diseñar una prueba.

## Alcance y estructura

| Archivo | Función |
| --- | --- |
| `registro-lectura-y-cobertura.md` | Método de lectura, cobertura por obra, extracción, páginas revisadas y limitaciones. |
| `resumen-norman-diseno-cosas-cotidianas.md` | Síntesis aplicada de principios de comprensión, acción, error y diseño centrado en las personas. |
| `resumen-albers-interaccion-color.md` | Síntesis aplicada de relatividad perceptual, contexto, contraste y pruebas de color. |
| `resumen-munari-diseno-como-arte.md` | Síntesis aplicada de comunicación visual, función, método, materialidad y experimentación. |
| `resumen-isaacson-steve-jobs.md` | Lectura histórica y biográfica de procesos de integración, simplificación y desarrollo de productos. |
| `sintesis-aplicada-sistema-visual-relevo.md` | Traducción crítica de las cuatro obras al sistema visual y phygital vigente. |
| `originales/` | Copias canónicas de los PDF aportados, sin alteraciones. |

## Procedencia de los archivos

Los PDF fueron incorporados al repositorio privado en `originales/`. La lectura se realizó sobre esos archivos locales, no sobre resúmenes externos. La extracción textual se hizo de forma temporal, página por página, y se registró fuera de la biblioteca como apoyo de auditoría. No se incorporaron audios, datos personales ni material identificable.

Las copias se conservan para consulta académica interna del proyecto. Su presencia en un repositorio privado no modifica los derechos de autor ni autoriza su redistribución pública. Los resúmenes son paráfrasis críticas y no reemplazan las obras originales.

## Inventario bibliográfico y estado de lectura

Los hashes corresponden a la copia canónica actualmente almacenada. La columna de edición solo se completa cuando el propio archivo permite confirmarla.

| Obra | Autor | Año / edición identificable | Páginas del PDF | Tamaño | SHA-256 | Estado de lectura |
| --- | --- | --- | ---: | ---: | --- | --- |
| *The Design of Everyday Things* | Don Norman | La portada interior no permite confirmar todos los datos; incluye una “Preface to the 2002 Edition”. Se registra provisionalmente como edición de 2002. | 270 | 3.140.257 bytes | `85E2F248ED85EB8B4271E181F38602239A66FE1611ADE7E187357AD467C5C232` | Completa para el archivo suministrado: prefacios, siete capítulos, notas, lecturas sugeridas, referencias e índice. |
| *Interaction of Color* | Josef Albers | 2013, cuarta edición; “50th Anniversary Edition”; Yale University Press. ISBN visible: 978-0-300-17935-4. | 210 | 8.762.475 bytes | `101A484101845275AD81AF045F8B344DC930B4251029493F5B18C7F7563450C8` | Completa para el archivo suministrado: introducción, capítulos I–XXVI y placas con comentarios. |
| *Design as Art* | Bruno Munari | Traducción inglesa de Patrick Creagh publicada por Penguin Books en 1971; obra original publicada en 1966. | 155 | 6.335.217 bytes | `832D518FE44508F9C7181F92745392B13411CCB2512EE0012C5FF7AF642817AE` | Completa para el PDF suministrado, pero el archivo parece incompleto respecto del índice de su propia edición: el índice anuncia secciones posteriores a la página 155 que no están presentes. |
| *Steve Jobs* | Walter Isaacson | Texto en español; título original y año visibles: *Steve Jobs*, 2011. Traducción de David González-Iglesias González. Editorial, ISBN y edición española no confirmados en el archivo. | 1.412 | 4.725.316 bytes | `C8D898EF623661238EBEDF86E45B629C3C12937CA9CDF53DA0695B74AD06DC5D` | Completa para el archivo suministrado: introducción, 41 capítulos, agradecimientos, fuentes, bibliografía, anotaciones y notas finales. |

### Nota sobre las copias de Isaacson

Antes de crear la copia canónica se calcularon los hashes de los dos archivos aportados de *Steve Jobs*. Ambos devolvieron `C8D898EF623661238EBEDF86E45B629C3C12937CA9CDF53DA0695B74AD06DC5D`; por ello se conserva una sola copia. La comparación puede auditarse mediante este registro, aunque el duplicado no se incorporó al repositorio.

## Criterio de uso académico

Norman y Albers se utilizan como fuentes teóricas y profesionales para formular criterios de interacción y percepción. Munari se utiliza como fuente teórica y profesional de diseño, comunicación visual y experimentación, con la reserva de que el PDF está incompleto frente a su propio índice. Isaacson se utiliza como fuente histórica y biográfica para comprender procesos de desarrollo, integración y cultura de producto; no se utiliza como metodología de investigación, evidencia de usabilidad ni autoridad sobre la experiencia de las personas.

Las referencias APA 7 de cada obra son provisionales cuando falta editorial, ISBN, edición o información equivalente. Esos vacíos aparecen también en los resúmenes individuales y deberán confirmarse antes de trasladar las referencias a la memoria final.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación de la biblioteca

- **Cambio:** se creó el índice de la biblioteca, el inventario bibliográfico, el registro de hashes, la procedencia, el estado de lectura y la regla de uso académico.
- **Situación anterior:** existían cuatro PDF en `originales/`, pero no había una biblioteca documentada ni una lectura trazable de sus ediciones y límites.
- **Motivo:** impedir que los archivos se usen como referencias indiferenciadas y dejar separadas las fuentes teóricas, profesionales, históricas y biográficas.
- **Asunto abierto:** confirmar los datos editoriales faltantes de Norman, Munari e Isaacson y localizar, si fuese necesario, una edición completa de Munari.

### 2026-08-29 — Integridad del duplicado y alcance de acceso

- **Cambio:** se precisó que las dos copias de Isaacson fueron comparadas antes de la canonicalización y se añadió la regla de consulta académica interna.
- **Situación anterior:** la nota describía la igualdad como un antecedente no repetible y no explicitaba el límite de redistribución de los PDF.
- **Motivo:** documentar con exactitud la verificación realizada y separar almacenamiento privado de autorización sobre derechos de autor.
