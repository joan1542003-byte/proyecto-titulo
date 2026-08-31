# Inventario del archivo local

**Fecha de corte del levantamiento:** 23 de agosto de 2026

**Uso vigente:** fotografía archivística; el estado posterior se consulta en la tabla de actualización y en los documentos canónicos enlazados.

## Propósito

Registrar qué materiales existen, cómo se relacionan y qué riesgos presentan antes de reorganizar el archivo físico o trasladar información a GitHub.

Este inventario es descriptivo. No establece por sí solo qué versión es verdadera, vigente o definitiva. Los conteos y vacíos corresponden al corte indicado y no deben leerse como un diagnóstico actual sin revisar la actualización posterior.

## Alcance y método

Se revisaron en modo de solo lectura:

- el nivel raíz del espacio de trabajo;
- `Fin semestre 1`;
- `SEMESTRE 2`, incluida la carpeta `output`.

No se editó, movió ni eliminó ningún archivo. La ejecución de `rg --files` fue bloqueada por Windows dentro de la carpeta sincronizada con OneDrive; se utilizó una enumeración recursiva alternativa. Se revisaron nombres, tamaños, fechas observables, metadatos, texto extraíble y, en `SEMESTRE 2`, hashes SHA-256 para detectar duplicados exactos.

Las fechas de modificación pueden corresponder a copia o sincronización, no a la creación intelectual del documento.

## Panorama general

| Ubicación relativa | Resultado observable | Función predominante |
|---|---:|---|
| Nivel raíz | 16 carpetas y 112 archivos | Investigación, proceso, entregas y versiones de memoria |
| `Fin semestre 1` | 3 archivos | Formulación reciente de Relevo y requerimiento de mapas |
| `SEMESTRE 2` | 416 archivos, 46 subcarpetas y aproximadamente 494 MB | Entregables derivados, exportaciones, mapas, flujos y memorias |
| `SEMESTRE 2/output` | 394 archivos | Producción visual y editorial del semestre |
| `tmp` del nivel raíz | 718 archivos y 51 subcarpetas | Renders, imágenes, extracciones y temporales |
| `bibliografia` | 9 archivos | Fuentes por revisar en profundidad |
| `fuentes usadas` | 1 archivo | Fuente ya utilizada, pendiente de ficha |

## Estado posterior al corte

| Área | Estado al 30 de agosto de 2026 | Documento canónico |
| --- | --- | --- |
| Memoria | La v4 es la única memoria académica activa; las anteriores conservan trazabilidad. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) e [índice de memoria](../08_memoria/README.md) |
| Usuarios | Corpus, códigos, comparación, U1/U2, perfiles, recorridos y requisitos están completados provisionalmente y abiertos a nueva evidencia. | [Índice de usuarios](../03_usuarios/README.md) |
| Mercado | Existe un estudio exploratorio autónomo, fichas y registro de búsqueda con corte del 24 de agosto. No prueba novedad universal ni disposición de pago. | [Estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) |
| Desarrollo y costos | B1 y B2 tienen esquemas revisables y desembolsos parciales; faltan inventario, revisión, compra, medición y costos de producción. | [Desarrollo y factibilidad](../06_desarrollo_y_factibilidad/README.md) |
| Validación | El Protocolo 01, consentimiento y fichas están preparados, pero no existen participantes ni resultados. | [Índice de validación](../07_validacion/README.md) |
| Sistema visual | Existe una dirección documentada y un sistema oscuro v4 en desarrollo. Las exploraciones no fijan por sí solas la forma final del producto. | [Dirección visual](../10_recursos_visuales/08_direccion_visual_relevo/README.md) |
| Gobernanza | La ruta crítica se gestiona mediante hoja de ruta, plan de cierre e Issues #8–#10. | [Hoja de ruta](../00_gobernanza/hoja-de-ruta.md) |

## Carpeta Fin semestre 1

| Archivo | Clasificación | Observación |
|---|---|---|
| `Encargo 16_ Mapa triple y avance memoria.md` | Proceso | Solicita viaje de usuario, flujo funcional y flujo técnico; no es evidencia de usuarios. |
| `Johan Yantén Dis. Gráfico.pdf` | Memoria final de Relevo | Fuente de 36 páginas, fechada el 8 de julio de 2026; copia binaria exacta de `SEMESTRE 2/Memoria Final Semestre 1.pdf`. |
| `memoria ocn correciones, borrador.pdf` | Exportación duplicada mal ubicada | Copia binaria exacta del PDF de Relevo v3 del segundo semestre, cuya fuente DOCX y conversión Markdown ya están documentadas. |

Los tres archivos de la carpeta están resueltos sin moverlos: el mapa triple ya se migró; la memoria de julio se convirtió íntegramente porque no se localizó un editable; y la exportación v3 se registró como redundante. Los hashes, destinos y límites están en las [equivalencias PDF](../99_archivo/fuentes-locales/semestre-1/cierre/equivalencias-pdf.md).

## Fuentes relacionadas con usuarios

| Material | Estado |
|---|---|
| Guion de entrevista inicial | Instrumento de trabajo, fecha observable 2 de junio de 2026 |
| Guion de entrevista v2 | Revisión del instrumento, fecha observable 8 de junio de 2026 |
| Guía metodológica E11 en Markdown | Documento de proceso |
| Notas manuscritas | Ya no están disponibles; no forman parte del archivo operativo |
| Exportación de respuestas del 12 de junio | Versión digital parcial e histórica |
| Documento de respuestas del 13 de junio | Transcripción consolidada y corpus operativo de ocho participantes |
| PDF de entrevistas semiestructuradas | Reconstrucción o presentación derivada |
| Perfiles, journey maps y flujos U01–U03/P01–P03 | Representaciones de diseño; no evidencia primaria |

Los archivos digitales con respuestas contienen datos identificables y deben permanecer fuera de GitHub. Los códigos internos no garantizan anonimización si un archivo conserva nombres, rostros o contexto reconocible.

## Evolución documental

### In(Visible)

Los materiales E09 desarrollan el registro del ocio digital, la memoria episódica y un objeto phygital doméstico bajo el nombre In(Visible).

### Transición E10–E11

Se encontraron contenidos de presentación, corrección cruzada, transcripciones, guiones, teoría de cambio, planificación, instrumentos de entrevista y respuesta a feedback. Son documentos de proceso y no deben confundirse con fuentes empíricas primarias.

### E12 y cierre del primer semestre

Existe una cadena extensa de borradores y entregas de In(Visible), seguida por la memoria final de Relevo del 8 de julio. La comparación de contenido y hashes permite afirmar cuál es el cierre más tardío localizado, aunque no convierte automáticamente sus decisiones en la postura vigente del segundo semestre. La autoevaluación E12 ya fue convertida y se clasificó como una autodeclaración generada por script, sin resultado docente; otros editables de E12 todavía deben compararse.

### Relevo y producción de agosto

`Fin semestre 1` y `SEMESTRE 2/output` documentan el paso a Relevo, el testigo físico situado, la arquitectura técnica, el storyboard, la validación propuesta y múltiples versiones de mapas de usuario, flujos funcionales y flujos técnicos.

## Cronología provisional

| Periodo observable | Materiales | Lectura archivística |
|---|---|---|
| 23 de mayo de 2026 | Rúbrica, pauta, E09 y auditoría bibliográfica | Marco institucional e inicio documentado |
| 24–26 de mayo | Presentación, corrección cruzada, transcripción y guion E10 | Proceso y feedback |
| 2–10 de junio | Guiones, teoría de cambio, planificación y E11 | Preparación del levantamiento |
| 11–13 de junio | Exportaciones y reconstrucciones digitales de entrevistas | Registros derivados |
| 13–15 de junio | Cadena de versiones E12 | Escritura y revisión |
| 23–29 de junio | Entregas de In(Visible), respaldo y autoevaluación | Hito E12 y preparación del cierre |
| 8 de julio | Memoria final de Relevo | Cierre más tardío localizado del Seminario de Título |
| 13–19 de agosto | Memorias, perfiles, mapas y flujos de Relevo | Nueva etapa de desarrollo |
| 23 de agosto | Sincronización observable de varias carpetas | Fecha técnica, no necesariamente autoría |

## SEMESTRE 2 y output

### Memorias localizadas

Se encontraron tres familias principales, cada una en DOCX y PDF:

1. memoria actualizada;
2. memoria perfeccionada de Relevo;
3. memoria con sistema editorial v3.

La denominación `v3` y la fecha sugieren mayor actualidad, pero no constituyen prueba suficiente para declararla versión canónica.

### Flujos y mapas

Existen, en distintos formatos y versiones:

- mapas de viaje de usuario;
- flujos funcionales;
- flujos técnicos;
- flujos verticales;
- mapas horizontales;
- arquitectura técnica;
- trazabilidad;
- storyboard;
- materiales para Miro e impresión;
- fuentes SVG editables.

Se identificaron variantes iniciales, `Relevo sin pantalla`, `Sistema editorial v3` y `FINAL`. El rótulo `FINAL` describe una exportación, no necesariamente el estado vigente del proyecto.

### Duplicación

El cálculo de hashes encontró:

- 126 grupos de duplicados exactos;
- 281 archivos dentro de esos grupos;
- 155 copias redundantes respecto de otra copia idéntica.

La duplicación se concentra en mapas repetidos entre carpetas de trabajo, exportaciones 4K/300 dpi, paquetes para Miro y ZIP. Los ZIP no fueron descomprimidos, por lo que puede existir duplicación adicional.

No se eliminará ninguna copia hasta establecer versión maestra, respaldo y relación entre fuentes editables y exportaciones.

## Riesgos de privacidad y distribución

No deben subirse sin revisión y anonimización:

- consentimientos;
- documentos completos con respuestas identificables;
- perfiles, flujos o journey maps nominales;
- carpetas codificadas que todavía contengan información reidentificable;
- ZIP completos sin inspección;
- materiales de otros estudiantes;
- actas, reglamentos, instructivos o logotipos institucionales sin necesidad y permiso;
- scripts con rutas, nombres, credenciales o datos locales;
- memorias que incluyan citas o contexto identificable.

## Vacíos detectados al corte y estado posterior

### Versión maestra

Al corte no existía una declaración inequívoca de la memoria vigente del segundo semestre. Este vacío quedó resuelto: `08_memoria/memoria-vigente-v4.md` gobierna la redacción académica y las versiones anteriores están clasificadas como antecedentes.

### Resultado del Pase

La autoevaluación local marca siete criterios como `Cumple`, pero no contiene APTO, CONDICIONAL o NO APTO, observaciones ni identificación docente. La planificación indica que el resultado oficial se registra por separado. Por ello, este archivo no permite reconstruir el veredicto y no debe usarse como certificación.

### Corpus de entrevistas

La transcripción digital consolidada está disponible. Las notas manuscritas ya no existen y el consentimiento fue informado y oral; no se conserva su guion exacto. Esta situación se registra como límite documental y no como tarea pendiente.

### Mercado

Al corte no se encontró un estudio autónomo y actualizado del mercado. El 24 de agosto se incorporaron un estudio exploratorio, fichas y registro metodológico. Su fecha sigue siendo necesaria porque disponibilidad, funciones y precios pueden cambiar.

### Producción y costos

Al corte no se encontró un expediente independiente. Actualmente existen alternativas de arquitectura, esquemas y listas de compra del prototipo, pero no una cotización de producción, un costo unitario cerrado ni escenarios de fabricación validados. El vacío se redujo, no se cerró.

### Validación

Actualmente existe un expediente autónomo con protocolo, consentimiento y fichas sin datos. Sigue sin haber protocolos aplicados, datos primarios ni resultados de participantes; esa ausencia no puede resolverse mediante documentación.

## Decisiones derivadas en el corte

Estas decisiones explican la organización iniciada el 23 de agosto. No sustituyen la hoja de ruta ni las decisiones posteriores.

- Mantener todo el archivo local intacto hasta normalizar versiones.
- Tratar `SEMESTRE 2/output` como conjunto de entregables derivados, no como base empírica.
- No reutilizar los tres perfiles históricos como hallazgos de usuario.
- Priorizar en la fase 1 los guiones, entrevistas anonimizadas y memoria histórica pertinente.
- Consultar la [autoevaluación E12 documentada](../99_archivo/fuentes-locales/semestre-1/e12/autoevaluacion-pase.md) solo como autodeclaración histórica.
- Registrar la normalización futura en la [Issue #4](https://github.com/joan1542003-byte/proyecto-titulo/issues/4).
- Conservar el cierre de la antigua tarea de notas en la [Issue #3](https://github.com/joan1542003-byte/proyecto-titulo/issues/3) y no reconstruir material ausente.

## Límites

- No se realizó una auditoría visual página por página de todos los archivos.
- No se descomprimieron ZIP.
- No se estudió todavía el contenido completo de `bibliografia`, `fuentes usadas`, `tmp` ni documentos de terceros.
- Las fechas de OneDrive pueden ser técnicas.
- El inventario identifica existencia, relaciones y riesgos; no valida por sí mismo afirmaciones del proyecto.

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Inventario fechado y reconciliado

- **Cambio:** se fijó el corte del 23 de agosto, se añadió el estado posterior por área y se actualizaron los vacíos de memoria, mercado, desarrollo y validación sin borrar la fotografía original.
- **Versión anterior:** afirmaciones históricas de ausencia podían interpretarse como estado vigente pese a la incorporación posterior de la v4, usuarios, mercado, factibilidad y protocolos.
- **Motivo:** conservar el valor archivístico del levantamiento y evitar que gobierne decisiones actuales por desactualización.
- **Alcance:** no se repitió la enumeración local, no se alteraron archivos fuente y siguen abiertos resultados de pruebas, costos productivos y normalización histórica.

### 2026-08-23 — Estado real del corpus

- **Cambio:** se actualizó el inventario para indicar que la transcripción consolidada es el corpus operativo y que las notas ya no están disponibles.
- **Versión anterior:** las notas figuraban como fuente primaria no localizada y su digitalización permanecía pendiente.
- **Motivo:** incorporar la aclaración del autor y evitar que una tarea imposible bloquee la fase de usuarios.
- **Decisión derivada:** cerrar la Issue #3 y mantener solo el límite documental.

### 2026-08-23 — Creación

- **Cambio:** consolidación de dos inventarios de solo lectura sobre el nivel raíz, `Fin semestre 1` y `SEMESTRE 2`.
- **Versión anterior:** el contenido estaba distribuido entre cientos de archivos sin un mapa archivístico común.
- **Motivo:** comprender el proceso completo, evitar confundir entregables con fuentes y registrar riesgos antes de reorganizar.
- **Pendiente:** declarar versiones maestras, inventariar bibliografía en profundidad y normalizar duplicados mediante la Issue #4.

### 2026-08-23 — Resolución de `Fin semestre 1`

- **Cambio:** se identificó la memoria final de Relevo, se reclasificó el PDF v3 mal ubicado y se corrigió la cronología E12 → cierre → semestre 2.
- **Versión anterior:** los dos PDF se describían por apariencia y nombre; su equivalencia y jerarquía seguían pendientes.
- **Motivo:** la auditoría binaria, textual y visual permitió asignar una decisión verificable a cada archivo.
- **Decisión derivada:** mantener intactos los originales y continuar la migración con la autoevaluación u otro documento textual propio.

### 2026-08-23 — Autoevaluación E12 clasificada

- **Cambio:** se registraron la generación mediante script, la ausencia de resultado docente y la conversión de la autoevaluación.
- **Versión anterior:** la autoevaluación figuraba como pendiente y podía parecer parte de una cadena oficial de evaluación.
- **Motivo:** distinguir el requisito de autoevaluarse del veredicto institucional y de la evidencia que sustenta cada criterio.
- **Decisión derivada:** continuar con equivalencias de E12 sin intentar reconstruir un resultado ausente.
