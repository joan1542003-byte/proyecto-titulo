---
id: INV-S2-001
titulo: "Auditoría documental de Semestre 2"
autoria: propia
estado_documental: vigente
relacion_con_proyecto: "inventario y priorización"
sensibilidad: interna
fecha_creacion: 2026-08-23
---

# Auditoría documental de Semestre 2

## Alcance

Auditoría de lectura de la carpeta local `SEMESTRE 2`. No se editaron archivos ni se eligió automáticamente una versión canónica.

## Resultado general

| Indicador | Resultado |
|---|---:|
| Archivos | 416 |
| Carpetas, incluida la raíz | 47 |
| Tamaño total | 471,16 MiB |
| Archivos dentro de `output` | 394 |
| Grupos de duplicados exactos SHA-256 | 126 |
| Archivos pertenecientes a grupos duplicados | 281 |
| Espacio redundante estimado | 150,78 MiB |
| Markdown existentes | 21 |

## Distribución por formato

| Ubicación | DOCX | MD | PDF | PNG | PY | SVG | ZIP | Total |
|---|---:|---:|---:|---:|---:|---:|---:|---:|
| Raíz | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 1 |
| Coordinación de titulación | 9 | 0 | 5 | 5 | 0 | 2 | 0 | 21 |
| `output` | 3 | 21 | 77 | 217 | 3 | 60 | 13 | 394 |
| **Total** | **12** | **21** | **83** | **222** | **3** | **62** | **13** | **416** |

No se localizaron PPTX ni TXT dentro de esta carpeta.

## Familias documentales detectadas

| Familia | Componentes observados | Decisión archivística inicial |
|---|---|---|
| Memorias del proyecto | Tres DOCX propios con PDF asociado | Conservar las tres versiones y comparar antes de declarar una vigente |
| Memoria del semestre 1 | Un PDF sin DOCX equivalente dentro de esta carpeta | Relacionar con la versión Markdown ya migrada y verificar equivalencia |
| Tríada de mapas | Estados sin sufijo, final, Relevo sin pantalla, sistema editorial v3 y Miro | Agrupar por versión, no por formato |
| Perfiles P01–P03 y U01–U03 | Variantes completas, de usuario, Miro y Material 3 | Tratar como iteraciones históricas; no confundir con el análisis actual P1–P8 |
| Material Design 3 | PNG, PDF, SVG, imágenes, guías y código | Separar fuente editable, exportación y documentación |
| Paquetes de entrega | Trece ZIP con materiales repetidos | Inventariar; no descomprimir ni copiar cada paquete al repositorio |
| Documentación de proceso | README, LEEME, QA, fundamentaciones y guías | Consolidar copias idénticas y enlazar sus apariciones |
| Documentos institucionales | Actas, instructivos, calendario, protocolo, matriz y reglamento | Mantener como inventario externo, no como contenido propio de la memoria |

## Duplicados exactos

| Tamaño del grupo | Cantidad de grupos |
|---:|---:|
| Dos copias | 98 |
| Tres copias | 27 |
| Cuatro copias | 1 |

| Formato | Grupos duplicados |
|---|---:|
| PNG | 72 |
| PDF | 32 |
| SVG | 18 |
| MD | 4 |

Los duplicados se concentran en mapas, imágenes conceptuales, exportaciones PDF, SVG editables y documentos de guía copiados entre paquetes. No se propone borrar ningún archivo local.

## Fuentes propias prioritarias

1. `output/Johan Yanten - Memoria perfeccionada Relevo - Encargo 16.docx`.
2. `output/Johan Yanten - Memoria actualizada Encargo 16.docx`.
3. `output/Johan Yanten - Memoria Relevo - Sistema editorial v3.docx`.
4. Los 21 Markdown de proceso, previa deduplicación.
5. Fichas de mapas y decisiones de perfiles que contengan texto único.

Los tres DOCX contienen entre 276 y 349 párrafos y entre 9 y 14 tablas. Los nombres de archivo no permiten decidir por sí solos cuál debe ser la memoria vigente.

## Materiales que no deben transcribirse íntegramente

- PNG, SVG y PDF de mapas: conservar una referencia por versión y crear una ficha Markdown.
- Código Python: conservar como código y documentar su función.
- ZIP: registrar composición, hash y relación con archivos ya presentes.
- Logotipos y documentos institucionales: inventariar sin mezclarlos con autoría propia.

## Riesgos de organización

- Varias ramas diferentes están denominadas final.
- La carpeta está ordenada por entregables y exportaciones, no por proceso o vigencia.
- Una misma pieza aparece en varias resoluciones y formatos.
- Elegir una versión principal sin comparar contenido podría borrar decisiones o consolidar una rama descartada.

## Secuencia recomendada

1. Crear un manifiesto con ruta, tamaño, hash, autoría, familia, versión, función y destino.
2. Convertir y comparar las tres memorias DOCX.
3. Ordenar los 21 Markdown por memoria, perfiles, flujos, fundamentación, QA y guías.
4. Crear fichas para entregables visuales sin duplicar cada exportación.
5. Registrar por separado código, paquetes e institucionales.

## Límite de interpretación

Esta auditoría describe existencia, formato, duplicación y relaciones aparentes. No valida la calidad académica de los contenidos ni establece qué propuesta de producto debe continuar. Los rótulos locales que mencionan herramientas o estados de generación se conservan únicamente como datos de procedencia.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se documentaron estructura, formatos, duplicados, familias y prioridades de la carpeta Semestre 2.
- **Versión anterior:** la carpeta tenía 416 archivos sin una lectura archivística consolidada en GitHub.
- **Motivo:** evitar conversiones indiscriminadas y preparar una migración por familias verificables.
- **Alcance:** documento de organización; no modifica por sí mismo el contenido sustantivo ni la vigencia de las fuentes enlazadas.

## Ejecución posterior a la auditoría

La primera prioridad recomendada ya fue ejecutada:

- [x] Convertir las tres memorias DOCX propias.
- [x] Comparar estructura y similitud sin declarar una versión vigente.
- [x] Registrar tablas, figuras, comentarios y control de cambios.
- [x] Corregir en las copias la reconstrucción metodológica errónea del estudio de junio.
- [ ] Ordenar y deduplicar los 21 Markdown de proceso.
- [ ] Crear fichas para perfiles, recorridos, flujos y mapas.
- [ ] Resolver qué memoria alimentará el documento activo.

### 2026-08-23 — Actualización de ejecución

- **Cambio:** se marcó como completada la conversión prioritaria de memorias.
- **Versión anterior:** la auditoría solo proponía lotes.
- **Motivo:** diferenciar recomendaciones de acciones ya realizadas.
- **Alcance:** los demás 408 archivos de la carpeta siguen bajo las decisiones registradas en esta auditoría.
