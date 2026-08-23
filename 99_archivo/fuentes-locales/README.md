# Fuentes locales migradas

## Propósito

Esta colección convierte el archivo local del proyecto en documentación Markdown navegable y trazable. Conserva el proceso intelectual sin tratar cada archivo antiguo como formulación vigente.

La colección no replica carpetas de forma ciega. Distingue:

- documentos propios con contenido intelectual;
- fuentes editables y exportaciones del mismo entregable;
- versiones históricas;
- materiales vigentes;
- fuentes de terceros;
- información sensible;
- renders, temporales y duplicados;
- archivos que solo necesitan una ficha de existencia.

## Principio de organización

El repositorio cumple dos funciones diferentes:

1. **Directorios 00–09:** investigación, decisiones y desarrollo actualmente utilizables.
2. **Directorio 99:** procedencia, versiones anteriores y materiales necesarios para reconstruir el proceso.

Un documento archivado puede contener ideas todavía útiles. Su ubicación indica estado documental, no falta de valor.

## Estructura prevista

| Ruta | Contenido | Estado |
|---|---|---|
| `semestre-1/e09` | Auditoría y memoria del hito E09 | Migrado |
| `semestre-1/e10` | Revisión cruzada y transcripción | Parcial |
| `semestre-1/e11` | Guía, plan, presentación y memoria revisada | Migrado en Markdown |
| `semestre-1/e12` | Cadena de borradores y cierre de memoria | Migrado en Markdown |
| `semestre-1/cierre` | Entregables y reflexiones de cierre | Parcial |
| `semestre-2` | Desarrollo de Relevo, mapas, flujos y nuevas memorias | Tres memorias y 21 Markdown migrados; binarios pendientes |
| `instrumentos` | Guiones, cuestionarios y protocolos propios | Parcialmente migrado |
| `fuentes-terceros` | Fichas bibliográficas y registros de existencia | Pendiente |
| `inventarios` | Mapas, manifiestos, omisiones y equivalencias | Activo |

## Estados documentales

- **Vigente:** puede alimentar el trabajo actual.
- **Histórico:** documenta una etapa anterior.
- **Reemplazado:** existe una versión posterior identificada.
- **Exploratorio:** contiene una formulación que no fue validada.
- **Fuente editable:** archivo desde el que se generó una exportación.
- **Exportación:** PDF, imagen o presentación derivada de una fuente.
- **Ficha de fuente:** registro de un material que no se copia íntegramente.
- **Omitido:** archivo reconocido, pero excluido por privacidad, propiedad, redundancia o falta de contenido intelectual.

## Reglas de acceso y uso

1. Leer primero la nota archivística de cada documento.
2. No citar una versión histórica como postura actual sin comprobar su vigencia.
3. No copiar afirmaciones a la memoria sin rastrear su evidencia.
4. No confundir una exportación visual con una fuente editable.
5. No publicar información identificable de participantes.
6. No reproducir documentos completos de terceros; registrar referencia, función y ubicación local.
7. No subir temporales, cachés ni duplicados solo para aumentar cobertura.
8. Mantener un registro de cambios al final de cada Markdown migrado.

## Navegación

- [Archivo del semestre 1](semestre-1/README.md)
- [Archivo del semestre 2](semestre-2/README.md)
- [Protocolo de migración](protocolo-de-migracion.md)
- [Mapa del archivo local](inventarios/mapa-del-archivo-local.md)
- [Índice maestro](inventarios/indice-maestro.md)
- [Registro de omisiones](inventarios/registro-de-omisiones.md)
- [Registro de conversiones](inventarios/registro-de-conversiones.md)
- [Auditoría documental de Semestre 2](inventarios/auditoria-semestre-2.md)

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Creación

- **Cambio:** se creó una colección específica para migrar documentación local a Markdown.
- **Versión anterior:** `99_archivo` definía reglas generales, pero no tenía una arquitectura de conversión ni navegación propia.
- **Motivo:** ampliar la cobertura documental sin mezclar versiones históricas con contenido vigente.
- **Decisión derivada:** migrar por lotes, comenzando por documentos propios que ya existen como Markdown o texto estructurado.

### 2026-08-23 — Primer lote documental

- **Cambio:** se añadieron trece documentos propios, ocho índices internos, una bitácora de conversiones y la auditoría de Semestre 2.
- **Versión anterior:** la arquitectura estaba definida, pero aún no contenía fuentes locales migradas.
- **Motivo:** comenzar la consolidación con materiales textuales propios y verificables antes de abordar formatos complejos.
- **Decisión derivada:** continuar con los DOCX propios y los 21 Markdown de Semestre 2; los visuales se registrarán mediante manifiestos.

### 2026-08-23 — Memorias del semestre 2

- **Cambio:** se añadieron tres memorias convertidas, su comparación, un manifiesto de medios y un informe de integridad.
- **Versión anterior:** Semestre 2 estaba auditado, pero no contenía fuentes DOCX migradas.
- **Motivo:** resolver primero la familia documental que concentra la formulación más amplia del proyecto.
- **Decisión derivada:** mantener la vigencia de la memoria abierta y continuar con los 21 Markdown de proceso.

### 2026-08-23 — Proceso Markdown de Semestre 2

- **Cambio:** se incorporaron los 21 Markdown locales como 16 copias canónicas y seis documentos de control.
- **Versión anterior:** solo la familia de memorias estaba disponible dentro del archivo del semestre 2.
- **Motivo:** preservar la capa de proceso sin duplicar archivos idénticos ni promover visualidad histórica a contenido activo.
- **Decisión derivada:** continuar con documentos propios de otros hitos y equivalencias de formatos.
