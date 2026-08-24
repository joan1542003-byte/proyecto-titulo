---
id: FL-S1-CL-QA-001
titulo: "Informe de integridad de los PDF de Fin semestre 1"
autoria: propia
estado_documental: histórico
relacion_con_proyecto: "control estructural y visual"
sensibilidad: interna
fecha_creacion: 2026-08-23
---

# Informe de integridad de los PDF de `Fin semestre 1`

## Alcance

Se revisaron los dos PDF de la carpeta, su texto extraíble, metadatos, imágenes, tablas, duplicados y relación con fuentes editables. La revisión comprueba integridad documental; no valida automáticamente los argumentos de las memorias.

## Memoria final de Relevo

### Estructura

| Campo | Resultado |
|---|---|
| Páginas | 36 |
| Palabras extraídas | 10.521 |
| Página vacía | Ninguna |
| Tablas lógicas | 5, distribuidas entre varias páginas |
| Figuras sustantivas | 3 |
| Imagen institucional | 1 logotipo con máscara de transparencia |
| Fuentes incrustadas | Calibri y Arial, con variantes regular, negrita e itálica |
| PDF etiquetado | Sí |
| Cifrado | No |
| JavaScript o formularios | No |

### Revisión visual

Las 36 páginas fueron renderizadas y revisadas mediante seis hojas de contacto; las páginas con tablas y figuras se inspeccionaron además en detalle. No se observaron recortes, solapamientos, glifos ausentes ni páginas en blanco.

Aspectos editoriales observados:

- portada de baja densidad, coherente con su función;
- cuerpo legible y jerarquía consistente;
- tablas densas en las páginas 17–23, 27–29 y 32–33;
- referencias extensas en tamaño reducido, pero legibles;
- tres figuras integradas en las páginas 23, 27 y 30;
- encabezado y número de página repetidos de forma consistente.

### Conversión

- Se eliminaron encabezados, pies y foliación.
- Los cortes de párrafo por cambio de página se reunieron.
- Cinco tablas partidas se reconstruyeron como cinco tablas Markdown.
- Las tres figuras sustantivas se extrajeron sin recomprimir.
- El logotipo institucional se omitió por no aportar contenido investigativo.
- Se normalizó `físico-digital` como `phygital`.
- Se corrigieron separaciones accidentales de palabras y tres URL partidas por salto de línea.
- La declaración histórica `28–42 minutos, audio y notas` se sustituyó, solo en la copia Markdown, por los datos metodológicos confirmados por el autor.

### Control de cobertura textual

La comparación automatizada entre el texto del PDF y la copia Markdown obtuvo los siguientes resultados:

- 99,3 % de coincidencia en secuencias muestreadas de ocho palabras al excluir portada, índice y páginas de tablas;
- 100 % de presencia exacta en 140 celdas sustantivas de las cinco tablas, después de normalizar espacios y cortes de palabra;
- las diferencias restantes corresponden a portada, encabezados, pies, títulos reestructurados, figuras y la corrección metodológica declarada.

Este control no evalúa la veracidad de las afirmaciones; verifica que la conversión no haya resumido ni perdido silenciosamente el contenido fuente.

## PDF de memoria v3 mal ubicado

| Campo | Resultado |
|---|---|
| Páginas | 35 |
| Formato | Carta vertical |
| PDF etiquetado | Sí |
| Objetos de imagen | 11 |
| Familias o subconjuntos de fuente | 9 |
| Duplicados exactos | Dos ubicaciones adicionales |
| Fuente editable | DOCX de memoria Relevo v3 |
| Conversión existente | Markdown de memoria Relevo v3 |

El archivo es idéntico por SHA-256 a la exportación del DOCX v3 ya revisado. Por ello, su integridad y cobertura textual se heredan de la auditoría de esa familia; una nueva conversión solo duplicaría contenido.

## Riesgos documentales detectados

- El nombre `memoria ocn correciones, borrador.pdf` no describe su contenido ni su etapa.
- El nombre genérico `Johan Yantén Dis. Gráfico.pdf` oculta que se trata de la memoria final de Relevo.
- La memoria de julio no tiene fuente editable localizada; el PDF debe conservarse de forma privada como fuente maestra.
- La memoria histórica contiene afirmaciones metodológicas que deben leerse con las correcciones actuales.
- La existencia de una versión de agosto no vuelve obsoleta la de julio: cumplen funciones de trazabilidad distintas.

## Material publicado y omitido

### Publicado

- Conversión Markdown completa de la memoria de julio.
- Tres figuras propias extraídas.
- Equivalencias, hashes y control visual.

### Omitido

- Dos PDF originales y sus copias exactas.
- Logotipo institucional.
- 36 renders nuevos de la memoria de julio y 35 páginas de control ya disponibles para la versión v3 equivalente.
- Máscaras y objetos internos sin valor documental independiente.
- Rutas absolutas del equipo.

Los originales no fueron editados, movidos ni eliminados.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se documentaron estructura, revisión visual, conversión, riesgos y omisiones de los dos PDF.
- **Versión anterior:** la carpeta carecía de control de integridad y los nombres de archivo podían interpretarse como dos memorias diferentes del mismo cierre.
- **Motivo:** cerrar la colección con una decisión verificable para cada elemento.
- **Alcance:** el informe verifica documentos y equivalencias; no decide la vigencia conceptual del producto actual.

### 2026-08-23 — Control de cobertura añadido

- **Cambio:** se incorporaron las métricas de cobertura textual y se precisó la procedencia de las páginas de control visual.
- **Versión anterior:** el informe registraba la inspección estructural y visual, pero no cuantificaba la conservación del texto.
- **Motivo:** respaldar la conversión íntegra con una comprobación independiente de párrafos y tablas.
- **Alcance:** las métricas miden correspondencia documental, no calidad académica ni validez de la evidencia.
