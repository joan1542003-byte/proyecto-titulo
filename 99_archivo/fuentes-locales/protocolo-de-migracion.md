# Protocolo de migración del archivo local

## Objetivo

Convertir la mayor cantidad pertinente de documentación propia a Markdown, preservando procedencia, estructura, estado y límites. El objetivo no es maximizar el número de archivos, sino hacer recuperable el conocimiento del proyecto.

## Secuencia obligatoria

### 1. Clasificación previa

Antes de convertir, cada archivo se evalúa en cinco dimensiones:

| Dimensión | Pregunta |
|---|---|
| Autoría | ¿Es material propio, institucional o de terceros? |
| Función | ¿Contiene investigación, decisión, escritura, feedback, proceso, evidencia o solo una exportación? |
| Relación | ¿Es fuente editable, exportación, respaldo, duplicado o versión distinta? |
| Vigencia | ¿Está vigente, es histórico, fue reemplazado o nunca se validó? |
| Sensibilidad | ¿Contiene nombres, entrevistas, datos privados, credenciales o material ajeno? |

### 2. Decisión de tratamiento

- **Conversión completa:** documentos propios con contenido intelectual relevante.
- **Conversión selectiva:** documentos propios extensos que mezclan contenido útil, instrucciones y elementos visuales.
- **Ficha de fuente:** bibliografía, material institucional y documentos de terceros.
- **Índice visual:** imágenes o diagramas propios que requieren descripción y relación con una etapa.
- **Omisión registrada:** cachés, temporales, duplicados, renders redundantes, ejecutables y material sensible no anonimizado.

### 3. Selección de versión

Cuando existen DOCX, PDF y Markdown del mismo entregable:

1. usar la fuente editable más completa;
2. comprobar que la exportación no contenga páginas o anotaciones ausentes;
3. conservar una sola conversión textual;
4. registrar las demás versiones como equivalentes o exportaciones;
5. no presentar el nombre `final` como prueba suficiente de vigencia.

### 4. Conversión por formato

| Formato | Tratamiento |
|---|---|
| MD/TXT | Preservar contenido, normalizar codificación y añadir metadatos archivísticos. |
| DOCX | Extraer títulos, párrafos, listas y tablas; registrar figuras no convertidas; cotejar con exportación cuando exista. |
| PDF propio | Extraer texto con marcadores de página cuando no exista fuente editable; revisar visualmente páginas relevantes cuando sea posible. |
| PPTX propio | Convertir cada diapositiva en sección con título, texto, notas y descripción de recursos visuales. |
| XLSX propio | Convertir hojas pertinentes a tablas o fichas; explicar fórmulas y propósito. |
| PNG/JPG/SVG propio | Crear ficha visual con descripción, etapa, función y archivo relacionado; subir el recurso solo si aporta evidencia o diseño irreemplazable. |
| ZIP | Inventariar contenido antes de considerar respaldo; no subir el contenedor por defecto. |
| PY/JSON/HTML | Registrar solo si documenta un procedimiento reproducible todavía útil. |
| PDF/DOCX de terceros | Crear ficha bibliográfica o de referencia; no reproducir el texto completo. |

## Metadatos mínimos

Cada documento migrado comienza con:

```yaml
---
id: identificador-estable
titulo: título legible
archivo_origen: ruta relativa local
formato_origen: md | txt | docx | pdf | pptx | xlsx
etapa: e09 | e10 | e11 | e12 | semestre-2 | transversal
autoria: propia | institucional | terceros
estado_documental: vigente | histórico | reemplazado | exploratorio
version_reemplazada_por: ruta o decisión, si se conoce
sensibilidad: interna | anonimizada | pública
metodo_conversion: descripción breve
fecha_migracion: 2026-08-23
---
```

Cuando un dato no se conoce se registra como `no determinado`; no se inventa.

## Nota archivística

Después de los metadatos, cada documento debe explicar:

- qué es;
- para qué se produjo;
- qué relación mantiene con el proyecto actual;
- qué versión lo reemplaza, si se conoce;
- qué partes deben leerse con cautela.

## Integridad del contenido

- No resumir silenciosamente.
- Marcar cualquier fragmento omitido.
- Mantener tablas cuando su comparación sea relevante.
- No trasladar instrucciones docentes al cuerpo de la memoria.
- Corregir solo errores que impidan leer; las reformulaciones sustantivas pertenecen a una versión nueva.
- Conservar referencias y enlaces, señalando los que todavía deben verificarse.
- No introducir conceptos actuales dentro de documentos históricos como si hubieran existido en esa fecha.

## Privacidad y propiedad

- Las entrevistas se migran únicamente bajo P1–P8.
- Los nombres presentes en archivos privados no se reproducen.
- Documentos de otros estudiantes se agrupan y registran sin copiar su contenido.
- Artículos, libros y guías externas se transforman en fichas bibliográficas, no en copias completas.
- Rúbricas y documentos institucionales se resumen solo cuando su función organizativa sea necesaria.
- Scripts con rutas, credenciales o nombres locales no se suben sin revisión.

## Control de calidad

Antes de subir una conversión se comprueba:

- título y etapa;
- autoría;
- ausencia de datos personales innecesarios;
- cobertura de títulos, párrafos y tablas;
- relación con otras versiones;
- enlaces internos;
- estado documental;
- presencia del registro de cambios;
- ausencia de rótulos de procesamiento tratados como contenido sustantivo.

## Registro de cambios obligatorio

Cada documento cierra con:

- **Cambio:** qué se creó, reemplazó o normalizó.
- **Versión anterior:** cómo existía antes.
- **Motivo:** por qué se tomó la decisión.
- **Alcance:** qué no fue modificado o qué queda pendiente.

## Lotes

1. Markdown y TXT propios ya estructurados.
2. DOCX propios sin equivalente Markdown.
3. PDF propios sin fuente editable.
4. PPTX y XLSX propios.
5. fichas bibliográficas y material institucional.
6. índice de recursos visuales.
7. auditoría de `SEMESTRE 2/output`.
8. revisión de duplicados y declaración de versiones canónicas.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se definieron criterios de clasificación, conversión, metadatos, privacidad y control de calidad.
- **Versión anterior:** no existía un procedimiento reproducible para trasladar el archivo local a GitHub.
- **Motivo:** evitar una carga masiva sin contexto y conservar la relación entre investigación, versiones y decisiones.
- **Alcance:** el protocolo organiza la migración; no declara por sí solo qué versión de la memoria es canónica.
