# Memoria editorial completa de Relevo

**Estado:** primera maqueta integral automatizada.
**Fuente textual:** `08_memoria/memoria-vigente-v4.md`.
**Formato:** A3 horizontal, una página por archivo PNG.

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

## Limitaciones de esta versión

La paginación automática debe revisarse visualmente. En especial, es necesario comprobar tablas extensas, listas, referencias, viudas, huérfanas, equilibrio de columnas y tamaño real de impresión. Los diagramas y figuras definitivos se incorporarán después de esta auditoría, no antes.

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Primera maqueta integral

- **Cambio:** se creó un sistema reproducible que convierte la memoria vigente en páginas A3 horizontales y exportaciones PNG.
- **Versión anterior:** solo existían páginas aisladas para probar lectura, evidencia y síntesis.
- **Motivo:** desarrollar el diseño de la publicación completa sin inventar el texto de cada página mediante generación de imágenes.
- **Alcance:** esta versión permite auditar la memoria completa, pero todavía no constituye el arte final de impresión.
