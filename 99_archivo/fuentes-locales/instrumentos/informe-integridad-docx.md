---
id: INST-QA-001
titulo: "Informe de integridad de cuatro DOCX de entrevistas"
autoria: propia
estado_documental: vigente
familia_documental: "control de conversión"
sensibilidad: interna
fecha_revision: 2026-08-23
---

# Informe de integridad de cuatro DOCX de entrevistas

## Alcance

Se revisaron la estructura interna y la representación visual de los dos guiones y los dos registros relacionados con las entrevistas. El control tuvo como objetivo preservar contenido, identificar datos sensibles y comprobar que la conversión a Markdown no dependiera de una lectura incompleta.

## Control estructural

| ID | Palabras estimadas | Párrafos | Tablas | Medios internos | Comentarios | Inserciones | Eliminaciones |
|---|---:|---:|---:|---:|---:|---:|---:|
| DOC-ENT-01 | 18.970 | 505 | 6 | 4 | 28 | 0 | 2 |
| DOC-ENT-02 | 4.667 | 374 | 0 | 0 | 0 | 0 | 0 |
| DOC-ENT-03 | 296 | 31 | 0 | 0 | 0 | 0 | 0 |
| DOC-ENT-04 | 712 | 72 | 0 | 0 | 0 | 0 | 0 |

No se detectaron notas al pie o notas finales con contenido sustantivo. Las dos eliminaciones registradas en DOC-ENT-01 corresponden a control de cambios residual y no alteran el anexo utilizado para el corpus.

Los 28 comentarios de DOC-ENT-01 son observaciones editoriales sobre la memoria histórica. Se registró su existencia, pero no se trasladaron a los instrumentos ni se interpretaron como instrucciones del usuario.

## Control visual

| ID | Páginas revisadas | Resultado |
|---|---:|---|
| DOC-ENT-01 | 64 | Legible; una página en blanco entre secciones |
| DOC-ENT-02 | 14 | Legible; nombres y rótulos erróneos visibles en la fuente |
| DOC-ENT-03 | 2 | Legible; estructura continua |
| DOC-ENT-04 | 3 | Legible; estructura continua |

Se renderizaron y observaron las 83 páginas. No se detectó contenido en contacto con los bordes, recorte de texto ni tablas fuera de página. La página 36 de DOC-ENT-01 está vacía por un salto de sección; no representa contenido perdido.

La representación se generó mediante LibreOffice. Puede existir una diferencia menor frente a Microsoft Word en saltos de línea o paginación, pero la extracción estructural y el control de bordes no muestran pérdidas.

## Datos sensibles y publicación

- DOC-ENT-01 y DOC-ENT-02 contienen nombres personales.
- DOC-ENT-02 contiene horas exactas y rótulos metodológicamente incorrectos.
- Ninguno de los dos archivos se publica.
- Las versiones anonimizadas utilizan P1–P8 y omiten horas exactas.
- Los cuatro medios internos de DOC-ENT-01 pertenecen a la memoria y no son necesarios para comprender los instrumentos; no se incorporan en este sublote.

## Resultado de conversión

- Los dos guiones se conservaron íntegramente como Markdown estructurado.
- Los dos registros de respuestas se relacionaron con el corpus ya anonimizado, sin crear una copia redundante.
- Las discrepancias relevantes quedaron resueltas y documentadas.
- Los originales locales permanecen intactos.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se documentaron estructura, comentarios, control de cambios, medios y revisión visual de cuatro DOCX.
- **Versión anterior:** las conversiones podían comprobar texto, pero no existía un control conjunto de 83 páginas ni una decisión explícita sobre comentarios y datos sensibles.
- **Motivo:** demostrar que la migración conserva la información pertinente y omite únicamente datos o recursos cuya exclusión está justificada.
- **Alcance:** el informe valida la integridad documental; no valida los hallazgos de usuario ni la eficacia del proyecto.

