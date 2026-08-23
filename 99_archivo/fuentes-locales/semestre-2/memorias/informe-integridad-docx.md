---
id: FL-S2-MEM-QA-001
titulo: "Informe de integridad de las memorias DOCX"
autoria: propia
estado_documental: vigente
relacion_con_proyecto: "control de conversión"
sensibilidad: interna
fecha_revision: 2026-08-23
---

# Informe de integridad de las memorias DOCX

## Alcance

Se renderizaron y revisaron las 113 páginas de las tres memorias antes de cerrar su conversión textual. También se examinó la estructura OOXML para detectar comentarios, control de cambios, cuadros de texto, imágenes flotantes y contenido externo incrustado. Los renders permanecen como material temporal local y no se publican en esta fase.

## Resultado por fuente

| Fuente | Páginas | Tablas | Imágenes en línea | Páginas vacías | Resultado visual |
|---|---:|---:|---:|---:|---|
| Memoria actualizada | 38 | 9 | 3 | 0 | Jerarquía clara; tablas legibles; defecto menor en una figura |
| Memoria perfeccionada | 40 | 14 | 11 | 0 | Composición consistente; tablas legibles; texto pequeño en mapas |
| Sistema editorial v3 | 35 | 14 | 11 | 0 | Versión compacta; tablas y figuras completas; texto pequeño en mapas |

## Hallazgos visuales

### Memoria actualizada

- La portada, el índice, los títulos y la paginación son consistentes.
- Las tablas permanecen dentro de los márgenes y repiten encabezados cuando continúan en otra página.
- En la Figura 3 de la página 25, el último punto de cada una de las tres cajas queda parcialmente cortado por el borde inferior redondeado.
- No se observaron solapamientos generales ni páginas vacías.

### Memoria perfeccionada

- Las catorce tablas son legibles y no desbordan.
- El journey map de la página 21 y el flujo técnico de la página 23 contienen texto interno pequeño.
- No se detectaron cortes, solapamientos ni páginas vacías.

### Sistema editorial v3

- Las catorce tablas son legibles y las figuras están completas.
- El journey map de la página 19 y los flujos de las páginas 20 y 21 contienen texto interno pequeño.
- Algunos cierres de sección dejan espacio blanco amplio, pero no existen páginas completamente vacías.

## Integridad estructural

Ninguna de las tres fuentes contiene:

- comentarios de Word;
- inserciones o eliminaciones controladas;
- control de cambios activo;
- cuadros de texto;
- imágenes flotantes;
- contenido externo mediante altChunk.

Las imágenes son elementos en línea. Sus textos internos son rasterizados y no pueden recuperarse como texto editable mediante una conversión automática.

## Riesgos y tratamiento aplicado

| Riesgo | Tratamiento |
|---|---|
| Tablas divididas visualmente entre páginas | Se reconstruyeron desde la tabla OOXML original y se verificó que cada fila Markdown mantuviera el mismo número de columnas |
| Figuras rasterizadas | Se insertó un marcador en el lugar correspondiente y se creó un manifiesto por nombre, tamaño, dimensiones y hash |
| Método de entrevistas descrito erróneamente | Se corrigió en las copias Markdown y se declaró cada reemplazo en el disclaimer |
| P6 registrada con 24 años | Se corrigió a 27 años y se declaró el cambio |
| Códigos P usados a la vez para personas y preguntas | Se reservaron P1–P8 para participantes y se escribieron los números de preguntas como pregunta 1, pregunta 2, etc. |
| Rótulos internos de Encargo 16 | Se conservaron en el archivo histórico, pero quedaron señalados para no trasladarlos a la memoria activa |

## Verificación de la conversión

- Las 37 tablas de las tres fuentes se transformaron sin inconsistencias en el número de columnas.
- Los 25 marcadores de figura coinciden con las formas en línea detectadas.
- No se encontraron nombres conocidos de participantes en las copias.
- La memoria perfeccionada y Sistema editorial v3 recibieron 28 sustituciones controladas cada una: diez párrafos metodológicos, catorce celdas, tres usos terminológicos y la edad de P6.
- Los DOCX originales no fueron modificados, movidos ni eliminados.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se documentó la revisión visual y estructural previa a la migración.
- **Versión anterior:** solo existían los DOCX y sus exportaciones, sin constancia separada de integridad.
- **Motivo:** diferenciar problemas de maquetación, riesgos de extracción y errores metodológicos antes de usar el contenido.
- **Alcance:** este control confirma legibilidad y recuperabilidad; no valida todavía citas, costos ni decisiones de producto.
