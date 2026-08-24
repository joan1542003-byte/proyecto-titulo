# Registro de omisiones y tratamiento restringido

## Propósito

Registrar materiales conocidos que no se copiarán íntegramente al repositorio. Omitir no significa ignorar: cada exclusión debe responder a privacidad, propiedad, redundancia o falta de contenido intelectual.

## Categorías

| Categoría | Alcance inicial | Tratamiento | Motivo |
|---|---:|---|---|
| `tmp` | 718 archivos | Registro agregado | Temporales, renders, extracciones y pruebas |
| Cachés PYC | 7 archivos | Omisión | No contienen documentación intelectual |
| Documentos colectivos de E11 | 35 archivos ajenos y un documento propio | Migrar solo el propio; registrar el conjunto | Autoría y privacidad de terceros |
| Material colectivo de E10 | 4 archivos | Revisar feedback pertinente; no copiar trabajos ajenos | Autoría de terceros |
| Bibliografía local | 10 archivos contando `fuentes usadas` | Fichas bibliográficas | Propiedad intelectual externa |
| Coordinación de titulación S2 | 21 archivos | Resumen o ficha institucional | Material administrativo y de terceros |
| Entrevistas identificables | Varias versiones | Usar corpus P1–P8 ya anonimizado | Privacidad y consentimiento |
| PDF duplicado de fuente editable | Por determinar | Registrar equivalencia | Evitar duplicar texto |
| Renders PNG/JPG/SVG | Centenares | Índice visual selectivo | Redundancia y tamaño |
| ZIP | 13 archivos | Inventariar antes de decidir | Contenido desconocido o duplicado |
| Scripts y rutas locales | 54 PY y otros auxiliares | Omitir salvo utilidad reproducible | Riesgo de datos locales y ruido técnico |
| Logotipos y material institucional | Varios | Referencia de existencia | No aportan investigación y pueden tener restricciones de uso |

## Entrevistas

No se subirán archivos con nombres ni exportaciones originales. El contenido pertinente ya se conserva en:

- `03_usuarios/corpus-anonimizado.md`;
- `03_usuarios/reconstrucciones-de-caso.md`;
- `03_usuarios/matriz-evidencia-p1-p8.md`;
- `01_contexto_y_fuentes/auditoria-integridad-corpus-entrevistas.md`.
- `99_archivo/fuentes-locales/instrumentos/equivalencias-y-procedencia.md`.

## Documentos de terceros

No se reproducen memorias, entrevistas, presentaciones ni planillas de otros estudiantes. El archivo local puede conservarlos, pero GitHub solo registrará:

- existencia del conjunto;
- función que cumplió;
- cantidad y formatos;
- razón de exclusión;
- aprendizajes propios ya integrados en documentos de feedback, cuando corresponda.

## Bibliografía

Los textos académicos y guías externas se convertirán en fichas. Cada ficha debe contener referencia APA 7, enlace o DOI verificable, tipo de fuente, aporte, límite, relación con el proyecto y estado de lectura. No incluirá el texto completo.

## Recursos visuales

Un render se migra solo si:

- representa una decisión no recuperable desde otro archivo;
- es necesario para comprender la evolución formal;
- puede describirse y vincularse con una etapa;
- no contiene datos personales;
- no es una copia exacta o una variación irrelevante.

## Revisión

La omisión puede revertirse si aparece una necesidad académica concreta, se resuelve la privacidad y no existe una alternativa documental más adecuada.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se registraron categorías excluidas o restringidas y su tratamiento.
- **Versión anterior:** las restricciones aparecían dispersas entre inventarios y decisiones.
- **Motivo:** impedir que la autorización para organizar el repositorio se convierta en publicación indiscriminada de material ajeno, sensible o redundante.
- **Alcance:** las cantidades son iniciales y se actualizarán al cerrar cada lote.

### 2026-08-23 — Aplicación al lote 1A y a Semestre 2

- **Cambio:** se aplicaron las reglas de omisión al primer lote textual y a la auditoría de Semestre 2.
- **Versión anterior:** las categorías estaban definidas, pero todavía no existía un resultado de migración sobre el cual comprobarlas.
- **Motivo:** registrar qué se excluyó efectivamente, sin borrar ni ocultar su existencia.
- **Resultado del lote 1A:** se migraron trece fuentes textuales propias; no se copiaron originales identificables de entrevistas ni documentos completos de terceros.
- **Resultado de Semestre 2:** 126 grupos de duplicados exactos, que abarcan 281 archivos y 150,78 MiB redundantes, quedaron solo inventariados. No se eliminó ningún archivo.
- **Material visual:** 217 PNG, 60 SVG y 77 PDF dentro de `output` permanecen pendientes de un manifiesto selectivo; no se subieron indiscriminadamente.
- **Material institucional:** los 21 archivos de coordinación se mantienen como conjunto inventariado y separado de la autoría propia.
- **Paquetes y código:** trece ZIP y tres archivos Python de Semestre 2 se conservarán en su formato; Markdown describirá su función cuando corresponda.

### 2026-08-23 — Aplicación al sublote 1B

- **Cambio:** se aplicaron las reglas de omisión y tratamiento restringido a tres memorias DOCX.
- **Versión anterior:** los DOCX y sus medios internos estaban inventariados, pero no tenían una decisión de publicación.
- **Motivo:** convertir el contenido textual sin abrir todavía una línea de visualidad.
- **Originales DOCX:** no se subieron, editaron, movieron ni eliminaron; se registraron ruta relativa y SHA-256.
- **Medios internos:** 23 imágenes distintas por SHA-256 quedaron inventariadas, sin publicación binaria.
- **Renders de control:** 113 páginas renderizadas permanecen como temporales locales y no forman parte del repositorio.
- **Correcciones:** se aplicaron solo a las copias Markdown y quedaron detalladas en el disclaimer; las fuentes históricas permanecen intactas.

### 2026-08-23 — Aplicación al sublote 1C

- **Cambio:** cinco copias Markdown exactas se registraron como ubicaciones redundantes y no se publicaron como documentos separados.
- **Versión anterior:** los 21 archivos podían interpretarse como 21 piezas distintas.
- **Motivo:** una copia idéntica no aporta una nueva decisión, pero su ruta sí aporta procedencia.
- **Resultado:** se conservaron 16 copias canónicas; cada una lista todas sus fuentes locales equivalentes.
- **Visualidad:** no se subieron PNG, PDF, SVG, ZIP ni archivos Python durante este sublote.

### 2026-08-23 — Aplicación al sublote 1D

- **Cambio:** se mantuvieron fuera de GitHub dos DOCX identificables y 83 páginas de control visual.
- **Versión anterior:** la categoría entrevistas identificables no enumeraba la relación entre los dos registros ni los dos guiones.
- **Motivo:** preservar privacidad, evitar duplicar el corpus y separar fuentes editables de documentación académica.
- **Resultado:** dos guiones se convirtieron a Markdown; los registros con nombres se identificaron mediante SHA-256 y se vincularon con P1–P8.
- **Datos omitidos:** nombres, horas exactas, rutas absolutas, comentarios editoriales completos y cuatro medios internos de la memoria compuesta.
- **Originales:** ningún DOCX fue editado, movido ni eliminado.
