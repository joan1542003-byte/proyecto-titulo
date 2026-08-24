---
id: FL-S1-E12-QA-001
titulo: "Informe de integridad de la autoevaluación E12"
autoria: propia
estado_documental: vigente
relacion_con_proyecto: "control de procedencia, estructura y límites probatorios"
sensibilidad: interna
fecha_creacion: 2026-08-23
---

# Informe de integridad de la autoevaluación E12

## Alcance

Se revisaron el DOCX `Yanten Johan E12 - Autoevaluación Pase.docx`, su script generador y la sección del Pase en `Seminario_Titulo_2026_Planificacion (oficial).docx`. La revisión determina qué contiene la autoevaluación, cómo fue producida y qué no puede probar.

## Identificación de fuentes

| Fuente local | Función | Tamaño | SHA-256 |
|---|---|---:|---|
| `Yanten Johan E12 - Autoevaluación Pase.docx` | Autoevaluación propia convertida | 37.493 bytes | `3dff196fd7d5bfca26f0e6478426097e661b8f203f7e20596bb928d716a663b7` |
| `_crear_autoevaluacion_pase.py` | Script que genera el DOCX | 2.303 bytes | `976f3dfe98481cc1aeead877ae4a161020662a51dd7eed36c85b00f66d888def` |
| `Seminario_Titulo_2026_Planificacion (oficial).docx` | Fuente institucional de requisitos | 193.523 bytes | `dc02a32735d93bb4bb69ad8bb5ff46a25bdc8ba5ace59db2af271cf037ffcd28` |

El sistema de archivos registra la creación del script a las 23:58:24 y del DOCX a las 23:58:50 del 13 de junio de 2026. El texto del script coincide con todo el contenido sustantivo del documento. Las fechas internas de propiedades señalan 2013 y revisión 1, valores predeterminados que no sirven para fechar la autoría.

## Integridad estructural

| Campo | Resultado |
|---|---:|
| Páginas renderizadas | 1 |
| Formato | Carta vertical |
| Palabras | 140 |
| Párrafos OOXML | 27 |
| Párrafos no vacíos | 27 |
| Tablas | 1 |
| Filas | 8 |
| Celdas | 24 |
| Imágenes o dibujos | 0 |
| Comentarios | 0 |
| Inserciones controladas | 0 |
| Eliminaciones controladas | 0 |

La diferencia entre tres párrafos visibles y veintisiete párrafos OOXML se explica porque cada celda de la tabla contiene un párrafo propio.

## Revisión visual

El DOCX fue convertido a PDF y PNG mediante el flujo de renderizado documental. La única página se revisó a resolución completa.

- No hay páginas vacías, recortes, solapamientos ni caracteres ausentes.
- El título, la identificación y la explicación inicial son legibles.
- La tabla completa cabe dentro de la página.
- La tercera columna es estrecha y produce cortes de línea densos; la palabra `agradecimientos` se divide visualmente entre líneas, pero su contenido permanece legible y completo.
- No existen elementos visuales que requieran extracción o publicación.

## Relación con la planificación

La planificación institucional solicita para la Semana 14 una memoria borrador completa y una tabla de autoevaluación. Publica siete condiciones mínimas y señala que el docente completa una tabla durante la sesión del Pase. También distingue APTO, CONDICIONAL y NO APTO.

La autoevaluación reproduce los siete nombres de criterio y añade una columna de evidencia, pero no conserva:

- un resultado oficial;
- observaciones por criterio;
- identificación o firma docente;
- fecha de revisión realizada;
- correcciones solicitadas después del Pase.

Por ello, su función documental es registrar la evaluación que el autor hacía de su propio borrador, no certificar una habilitación.

## Riesgos de interpretación

1. Los siete estados son idénticos y no incluyen grados de incertidumbre ni pendientes.
2. Las evidencias son frases de síntesis; no contienen citas, páginas ni enlaces a capítulos concretos.
3. La fila Metodología presenta validación con prototipo y usuarios como incluida, mientras la memoria contemporánea ubica el uso doméstico del prototipo en una etapa futura.
4. La fila Usuario combina entrevistas reales con un perfil y un contexto derivados; esas tres capas no tienen el mismo nivel de evidencia.
5. La existencia de una propuesta phygital de In(Visible) no demuestra la pertinencia de la definición posterior de Relevo.
6. La creación mediante script asegura repetibilidad formal, pero no valida el juicio `Cumple`.

## Publicación y omisiones

### Publicado

- Conversión completa de la autoevaluación.
- Matriz de contraste con las condiciones mínimas de la planificación.
- Hashes y control estructural, visual y de procedencia.

### Omitido

- DOCX original.
- Script generador con una ruta absoluta obsoleta.
- Documento institucional completo.
- PDF y PNG temporales de revisión.

Las omisiones evitan publicar binarios redundantes, rutas locales y material institucional completo. Ninguna fuente fue editada, movida o eliminada.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se documentaron integridad, procedencia, relación institucional, revisión visual, riesgos y omisiones de la autoevaluación E12.
- **Versión anterior:** el DOCX podía interpretarse por su título y por los estados `Cumple`, sin información sobre su generación ni sobre la ausencia de un resultado oficial.
- **Motivo:** distinguir una autoevaluación histórica de una evaluación docente y de la evidencia que sostiene cada criterio.
- **Alcance:** el informe verifica documentos y niveles probatorios; no reconstruye un veredicto que no está presente en las fuentes revisadas.
