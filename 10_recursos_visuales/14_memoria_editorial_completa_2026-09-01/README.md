# Memoria editorial completa de Relevo

**Estado:** maqueta integral reproducible, sincronizada el 7 de septiembre de 2026.

**Fuente textual:** `08_memoria/memoria-vigente-v4.md` en la versión disponible al 7 de septiembre.

**Formato:** A3 horizontal, 86 páginas y un archivo PNG por página.

## Propósito

Esta carpeta contiene el sistema utilizado para trasladar la memoria vigente a páginas editoriales completas. La composición mantiene una misma grilla, tipografía IBM Plex, blanco cálido, grafito y rojo restringido. El texto se obtiene directamente del Markdown para impedir que una imagen generativa cambie citas, cifras o argumentos.

## Estructura

- `renderer/`: fuente reproducible de la publicación.
- `renderer/dist/`: versión HTML generada y manifiesto de páginas.
- `paginas_png/`: exportaciones individuales en orden de lectura.

## Criterios

- una página A3 horizontal por imagen;
- portada, preliminares, aperturas, lectura, tablas y referencias comparten la retícula canónica;
- los capítulos avanzan en el mismo orden narrativo de la memoria;
- las páginas de lectura pueden ser únicamente tipográficas;
- no se agregan citas, resultados, cifras ni fotografías inexistentes;
- el rojo no se utiliza como adorno editorial;
- las imágenes son pruebas de diagramación y no reemplazan el archivo editable final.

## Revisión pendiente

La fuente HTML, el manifiesto y las 86 páginas PNG corresponden entre sí. La paginación todavía debe revisarse a tamaño real para comprobar tablas extensas, listas, referencias, viudas, huérfanas, equilibrio de columnas y legibilidad de impresión. Los diagramas y figuras definitivos deben incorporarse después de esa revisión. Cada cambio posterior de la memoria obliga a reconstruir y volver a exportar esta carpeta.

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Primera maqueta integral

- **Cambio:** se creó un sistema reproducible que convierte la memoria vigente en páginas A3 horizontales y exportaciones PNG.
- **Versión anterior:** solo existían páginas aisladas para probar lectura, evidencia y síntesis.
- **Motivo:** desarrollar el diseño de la publicación completa sin inventar el texto de cada página mediante generación de imágenes.
- **Alcance:** esta versión permite auditar la memoria completa, pero todavía no constituye el arte final de impresión.

### 2026-09-02 — Advertencia de sincronización textual

- **Cambio:** se aclaró que las páginas PNG corresponden a una captura de la memoria disponible el 1 de septiembre.
- **Versión anterior:** el README indicaba la memoria v4 como fuente, pero no advertía que el texto había recibido modificaciones posteriores.
- **Motivo:** evitar que una exportación visual anterior se confunda con la paginación final de la memoria actual.

### 2026-09-07 — Sincronización de fuente y exportaciones

- **Cambio:** se reconstruyeron el HTML, el manifiesto y las páginas PNG desde la memoria vigente; la publicación pasó de 70 a 86 páginas.
- **Versión anterior:** la fuente generaba 86 páginas, pero la carpeta pública conservaba 70 exportaciones anteriores y el README advertía la diferencia.
- **Motivo:** asegurar que todos los formatos publicados correspondan a la misma fuente textual.
- **Alcance:** sincronización técnica y editorial; todavía falta la revisión visual a tamaño real y no constituye arte final de impresión.
