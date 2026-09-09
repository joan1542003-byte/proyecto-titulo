# Auditoría de organización del repositorio — 8 de septiembre de 2026

## Objetivo

Separar las fuentes que gobiernan el proyecto de los materiales reemplazados, reparar la navegación y comprobar que la limpieza no elimine evidencia, entregas ni archivos necesarios para reproducir los resultados.

## Criterio aplicado

Un archivo se trasladó a `99_archivo/antiguo` solo cuando el propio repositorio permitía comprobar tres condiciones:

1. documentaba una etapa anterior;
2. había dejado de gobernar el trabajo actual;
3. existía una fuente posterior que asumía su función.

La fecha por sí sola no convierte un documento en antiguo. Por esta razón permanecen en su lugar las entregas fechadas, el corpus, la bibliografía, las decisiones, las referencias 4K, el tablero de 44 vistas y los artefactos reproducibles.

## Resultado

Se creó una ruta histórica única con cuatro áreas y 97 archivos:

| Área archivada | Contenido | Reemplazo vigente o fuente actual |
| --- | --- | --- |
| Memoria | v1–v3, módulos de reconstrucción, auditorías anteriores y dos DOCX | memoria v4 y sus controles editoriales activos |
| Desarrollo físico | montajes B1, B2 y 12 V del 30 de agosto | prueba micro:bit, estudio del testigo compacto, ruta XIAO nRF52840 y puerta técnica de fase A |
| Propuesta y wireframes | tablero del 26 de agosto, siete láminas iniciales y paquete del 1 de septiembre | tablero de 44 vistas, láminas 4K y entrega organizada del 2 de septiembre |
| Sistema visual | sistema v3, tres exploraciones iniciales y nueve pantallas v1 descartadas | dirección de comunicación del 7 de septiembre; v4 permanece como referencia técnica anterior para las pantallas de esa etapa |

El [índice de material antiguo](../99_archivo/antiguo/README.md) explica cada grupo y enlaza su reemplazo. Los README de las áreas activas también conservan acceso al proceso, pero ya no mezclan esos antecedentes con los documentos vigentes.

## Correcciones adicionales

- `entrega-encargo-17.md` dejó de llamar vigente al tablero anterior y ahora remite a `wireframes-media-html`.
- La dirección visual tiene una sola autoridad para piezas nuevas: `comunicacion-naming-y-paleta-2026-09-07.md`. El sistema v4 quedó rotulado como referencia técnica anterior, no como un segundo sistema activo.
- La maqueta editorial se reconstruyó desde la memoria v4. El HTML, el manifiesto y las 87 páginas PNG vuelven a coincidir.
- Se añadió `verificar-enlaces.ps1`, una comprobación local basada en PowerShell estándar y sin dependencias nuevas.
- Las rutas modificadas quedaron registradas dentro de sus Markdown y en la decisión D-050.

## Material que se conservó en su lugar

| Conjunto | Razón |
| --- | --- |
| `00_admin/encargos` | Conserva entregas fechadas y permite reconstruir qué se presentó. |
| Exportaciones duplicadas del mapa | Una copia pertenece a la fuente HTML, otra a la entrega organizada y otra facilita control plano. Su igualdad es intencional. |
| Fuentes tipográficas empaquetadas | La biblioteca principal y las copias incluidas en HTML o video cumplen funciones técnicas distintas. |
| `wireframes-referencia-4k` | Sigue siendo el anexo detallado para revisar los 35 estados. |
| `09_archivo_generaciones_completo` | Su función ya es preservar la exploración visual; moverlo no mejoraría su clasificación y afectaría reglas de Git LFS. |
| Memoria v4, anexos y matrices | Constituyen la base académica y sus controles actuales. |

## Controles de cierre

| Control | Resultado |
| --- | --- |
| Enlaces locales en Markdown | 347 archivos y 1.025 destinos comprobados; 0 rotos. |
| Declaraciones de vigencia | Una memoria activa, un tablero vigente y una dirección actual de comunicación. |
| JSON y manifiestos | 14 archivos comprobados; 0 inválidos. |
| Imágenes PNG | 743 firmas y dimensiones válidas; la maqueta contiene 87 páginas. |
| Contenedores | 5 archivos ZIP, DOCX, PPTX o XLSX abiertos correctamente; 0 inválidos. |
| Rutas | 0 colisiones por uso de mayúsculas y minúsculas; 0 archivos inesperadamente vacíos. |
| Marcas de conflicto y espacios de Git | Sin conflictos de combinación ni errores de `git diff --check`. |
| Archivos temporales | Cachés y renders auxiliares permanecen fuera del versionado mediante `.gitignore`; los archivos de dependencias que acompañaron localmente al tablero archivado se retiraron después del traslado. |
| Historial | Los traslados se realizaron como renombres de Git y no como eliminación y copia. |

## Límite de esta auditoría

La limpieza comprueba estructura, navegación e integridad de archivos. No valida el funcionamiento del prototipo, la comprensión del sistema, la percepción de la señal ni la pertinencia definitiva de la dirección visual. Esos asuntos requieren las pruebas ya registradas en `07_validacion`.

---

## Registro de cambios (disclaimer)

### 2026-09-08 — Creación

- **Cambio:** se documentaron criterio, movimientos, excepciones, correcciones y controles de la reorganización integral.
- **Versión anterior:** la auditoría del 7 de septiembre comprobaba integridad, pero no existía una separación física entre fuentes activas y antecedentes reemplazados.
- **Motivo:** permitir que otra persona comprenda qué se movió, por qué se conservó y qué documento gobierna ahora cada área.
- **Alcance:** el informe no añade evidencia de usuarios ni resultados de producto; registra una intervención documental.
- **Verificación:** se comprobaron 1.206 archivos versionados o preparados para versión, 1.025 enlaces locales y 97 elementos dentro del nuevo archivo antiguo.
- **Limpieza local:** se retiraron 2.809 archivos de dependencias ignoradas que no formaban parte de Git ni del registro histórico; los paquetes pueden reinstalarse desde sus archivos de bloqueo.
