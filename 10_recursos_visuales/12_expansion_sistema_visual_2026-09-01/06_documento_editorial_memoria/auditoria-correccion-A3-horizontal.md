# Auditoría de corrección — Página A3 horizontal única

**Fecha:** 1 de septiembre de 2026
**Alcance:** sustitución progresiva de las maquetas compuestas como pliegos por páginas únicas de 420 × 297 mm, orientación horizontal.

## Hallazgo que motivó la corrección

La colección `01_maquetas_A3_horizontales` tenía una proporción de archivo cercana a A3, pero seis imágenes estaban compuestas como dos páginas verticales enfrentadas. Cada una mostraba un lomo central, sistemas duplicados de folio o encabezado, y funciones editoriales distintas a cada lado. Por ello se conserva como exploración previa, pero no se utiliza como patrón para diagramar la memoria.

La colección vigente es [`02_paginas_A3_horizontales_corregidas`](02_paginas_A3_horizontales_corregidas). Cada archivo debe ser una sola página horizontal con un foco de lectura.

## Reglas de aceptación

1. Un archivo equivale a una página horizontal continua, sin pliegue, lomo ni dos folios.
2. Cada página desarrolla una función: portada, índice, evidencia de usuarios, comparación, secuencia de sistema o factibilidad.
3. El texto de lectura, las tablas y los pies se reconstruyen desde fuentes verificadas; las PNG no son contenido académico.
4. El rojo vigente `#D71921` aparece únicamente cuando representa la señal situada en un diagrama que explica esa relación.
5. Los puntos se eliminan si no comunican una unidad, nodo o relación mediante leyenda.
6. Figuras y tablas finales deben incluir número, título, nota y fuente conforme a APA 7.
7. La retícula debe probarse con un capítulo completo, en tamaño A3 real y en escala de grises, antes de fijar márgenes y cuerpo tipográfico.

## Cobertura inicial corregida

| Archivo | Foco editorial único | Estado de contenido |
| --- | --- | --- |
| `a3h-01-portada-pagina-unica-v1.png` | Identidad y datos de portada. | Composición; verificar datos institucionales. |
| `a3h-02-indice-pagina-unica-v1.png` | Navegación de los catorce capítulos. | Composición; calcular folios con la memoria diagramada. |
| `a3h-03-usuarios-pagina-unica-v1.png` | Método y estructura de análisis de entrevistas. | Composición; texto, íconos y figura requieren reconstrucción desde el corpus. |
| `a3h-04-estado-arte-pagina-unica-v1.png` | Matriz de comparación crítica. | Composición; contrastar categorías y celdas con el estado del arte real. |
| `a3h-05-propuesta-v1.png` | Secuencia de bajada proyectual. | Composición; revisar etiquetas contra la memoria antes de usar. |
| `a3h-06-limites-v1.png` | Factibilidad y decisiones abiertas. | Composición; reemplazar texto por la evaluación vigente. |

## Decisión de sistema relacionada

Se unificó el rojo semántico en `#D71921`. La discrepancia anterior con `#EF3E45` queda resuelta en los documentos v4 activos. Las imágenes históricas no se alteran retrospectivamente: conservan su fecha y función de proceso, pero no determinan el token de las próximas reconstrucciones.

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Creación de la auditoría de corrección

- **Cambio:** se distinguió formalmente entre la serie de pliegos previos y la serie de páginas A3 horizontales únicas, se fijaron reglas de aceptación y se registró la unificación del rojo.
- **Versión anterior:** la auditoría A3 trataba la colección previa como si fuese una familia de páginas horizontales válidas.
- **Motivo:** corregir una interpretación de formato que impedía usar las imágenes como referencia de publicación y prevenir contenido visual no verificable.
- **Alcance:** esta auditoría no convierte las nuevas PNG en arte final; exige reconstrucción editable y revisión a tamaño real.
