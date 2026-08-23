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
