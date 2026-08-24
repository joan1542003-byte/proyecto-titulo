---
id: INST-EQV-001
titulo: "Equivalencias y procedencia de instrumentos y entrevistas"
autoria: propia
estado_documental: vigente
familia_documental: "control de versiones"
sensibilidad: interna
fecha_creacion: 2026-08-23
---

# Equivalencias y procedencia de instrumentos y entrevistas

## Fuentes locales revisadas

| ID | Fuente local | Tamaño | SHA-256 | Páginas renderizadas | Función | Decisión de publicación |
|---|---|---:|---|---:|---|---|
| DOC-ENT-01 | `ENTREVISTAS+ Memoria vieja.docx` | 597.070 bytes | `763706cb0e8512c6afdc20b3c51eb60283d080a88098405be1c25af6147fd36f` | 64 | Memoria histórica y anexo ampliado de entrevistas | No publicar el DOCX; documentar el anexo sin nombres |
| DOC-ENT-02 | `respuestas-invisible-2026-06-13.docx` | 17.130 bytes | `65c74463d7bde10027fd3378f01a753b9c5571c6f54e8b093a8806b1df9b829e` | 14 | Registro temprano de Q1–Q11 | No publicar el DOCX; usarlo en el corpus anonimizado |
| DOC-ENT-03 | `Yanten Johan - Guion entrevista.docx` | 38.046 bytes | `7c4522b13b23d1837f32516479a983d5ddc8c3de34ad1c0ecbbcaf85df07da8c` | 2 | Guion v1 | Convertido a Markdown |
| DOC-ENT-04 | `Yanten Johan - Guion entrevista v2.docx` | 39.569 bytes | `26d4b844c18f3ac17cf4bbb21fe97b39b4be06895e0efa6caa682eb1b70dbe6c` | 3 | Guion v2 | Convertido a Markdown |

Las rutas absolutas se excluyen porque no aportan trazabilidad académica y exponen la organización del equipo local. Los nombres de archivo y las huellas SHA-256 permiten comprobar la identidad de cada fuente sin subirla.

## Relación entre los dos registros de respuestas

DOC-ENT-02 conserva las once preguntas principales de los ocho casos. DOC-ENT-01 incorpora ese material con correcciones ortográficas y añade dos preguntas posteriores para cada participante. La comparación normalizada de Q1–Q11 produjo la siguiente similitud secuencial:

| Caso | Similitud entre registro temprano y anexo |
|---|---:|
| P1 | 97 % |
| P2 | 95 % |
| P3 | 98 % |
| P4 | 97 % |
| P5 | 96 % |
| P6 | 98 % |
| P7 | 99 % |
| P8 | 99 % |

Los porcentajes comprueban continuidad documental; no miden validez de las respuestas. La menor similitud de P2 se explica principalmente porque el anexo condensó Q10.

## Discrepancias resueltas

### P6

- Registro temprano: 24 años.
- Anexo y confirmación del investigador: 27 años.
- Decisión: 27 años.

### P2-Q10

- El registro temprano conserva la respuesta más extensa sobre obligaciones, materiales, separación del teléfono y realización de hobbies.
- El anexo la condensó, aunque mantuvo una repregunta que depende de ese contenido.
- Decisión: utilizar la versión extensa en el corpus.

### Q12–Q13

- Solo aparecen en DOC-ENT-01.
- El investigador confirmó que se realizaron presencialmente después de la secuencia principal.
- Decisión: incorporarlas como Q12–Q13 y registrar que las notas de origen ya no están disponibles.

### Rótulos de repregunta

- DOC-ENT-02 contiene 140 apariciones de un rótulo editorial que atribuye incorrectamente la autoría de preguntas o respuestas.
- El investigador confirmó que formuló personalmente todas las preguntas y repreguntas durante conversaciones habladas.
- Decisión: eliminar ese rótulo de la versión académica y utilizar `Repregunta`.

### Formato del levantamiento

- La apariencia de exportación de DOC-ENT-02 no describe el método de levantamiento.
- El método confirmado fue entrevista semiestructurada, hablada, presencial y con consentimiento oral.
- Decisión: tratar el archivo como una transcripción posterior, no como evidencia de un cuestionario digital.

## Destino canónico

| Contenido | Documento canónico |
|---|---|
| Respuestas Q1–Q13 | [Corpus anonimizado P1–P8](../../../03_usuarios/corpus-anonimizado.md) |
| Condiciones reales de aplicación | [Instrumento aplicado](instrumento-aplicado.md) |
| Discrepancias y cobertura | [Auditoría de integridad](../../../01_contexto_y_fuentes/auditoria-integridad-corpus-entrevistas.md) |
| Diseño temprano del instrumento | [Guion v1](guion-entrevista-v1.md) y [guion v2](guion-entrevista-v2.md) |

No se crea una segunda transcripción completa en `99_archivo`: duplicaría el corpus, aumentaría el riesgo de divergencia y no aportaría nueva evidencia.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se identificaron cuatro fuentes, sus huellas, funciones, equivalencias y destinos canónicos.
- **Versión anterior:** los nombres de archivo no permitían distinguir un guion, una transcripción temprana y un anexo ampliado.
- **Reemplazos:** se resolvieron P6, P2-Q10, Q12–Q13, el rótulo incorrecto de repreguntas y la interpretación errónea del formato de exportación.
- **Motivo:** conservar toda la información útil sin publicar identidades ni multiplicar versiones equivalentes.
- **Originales:** ningún DOCX fue editado, movido ni eliminado.
