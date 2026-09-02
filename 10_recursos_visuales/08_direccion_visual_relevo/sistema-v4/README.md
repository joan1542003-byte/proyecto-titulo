# Sistema visual v4 de Relevo

## Estado de vigencia

La v4 es el contrato operativo actual para desarrollar y auditar el sistema visual de Relevo. Su dirección conceptual es `Transferencia situada`: la relación entre una intención, el primer paso, un lugar y una señal emitida por el testigo físico.

La aplicación Android organiza y confirma. El testigo emite la señal situada. La persona conserva la decisión. El sistema no mide cumplimiento, no bloquea el teléfono, no moraliza la actividad y no convierte la señal en una orden.

Las nuevas pantallas digitales se desarrollan únicamente en modo oscuro. Las exploraciones claras de v3 y las dos pantallas claras de Android v4 son antecedentes históricos. No son una segunda dirección activa.

## Reglas no negociables

- El canvas vigente es `#111314`; el texto funcional usa tipografía continua.
- El rojo `#EF3E45` se reserva al nodo de señal situada.
- IBM Plex Sans se utiliza para lectura, instrucciones y acciones; IBM Plex Mono, para datos y etiquetas técnicas.
- Los puntos solo funcionan como marca, expresión breve o gráfico informativo acompañado de texto equivalente.
- Decoración, icono, elección, acción, estado y gráfico informativo deben poder distinguirse.
- No se utilizan métricas, rachas, premios, culpa, evaluación, glassmorphism, sombras, tarjetas gigantes ni cápsulas universales.
- La forma, material, mecanismo y canal del testigo permanecen abiertos hasta las pruebas correspondientes.

## Manual central y anexos

| Documento | Función |
|---|---|
| [`manual-sistema-visual-relevo.md`](manual-sistema-visual-relevo.md) | Contrato central: concepto, principios, identidad, color, tipografía, retícula, imagen, movimiento, accesibilidad, soportes, usos y gobernanza. |
| [`tokens-y-especificaciones.md`](tokens-y-especificaciones.md) | Tokens técnicos, estados de madurez, medidas, contraste, opacidad, iconos y movimiento. |
| [`componentes-y-semantica.md`](componentes-y-semantica.md) | Clasificación semántica, componentes Android, estados, jerarquías y reconstrucción desde wireframes. |
| [`sistema-editorial-y-fisico.md`](sistema-editorial-y-fisico.md) | Memoria, láminas, diagramas, fotografía, testigo físico, materialidad, instalación, mantenimiento y costos por levantar. |
| [`metodologia-validacion-visual.md`](metodologia-validacion-visual.md) | Método de validación con Norman, Albers, Munari, estándares de accesibilidad y pruebas phygital. |

## Documentación complementaria

- [`contrato-visual-oscuro.md`](contrato-visual-oscuro.md): contrato oscuro previo, conservado como anexo de continuidad.
- [`android/README.md`](android/README.md): pantallas Android y clasificación de las claras históricas.
- [`android/inventario-pantallas-oscuras.md`](android/inventario-pantallas-oscuras.md): nueve marcos, 35 estados y relación con Encargo 17.
- [`android/oscuro/README.md`](android/oscuro/README.md): auditoría individual de las diez pantallas rasterizadas.
- [`investigacion-interna-referencia-nothing.md`](investigacion-interna-referencia-nothing.md): investigación interna de referentes; no gobierna el discurso público de Relevo.

## Fuente estructural y orden de autoridad

La anatomía de la interfaz se deriva de `05_propuesta_phygital/wireframes-media-html/src/wireframes.ts` y del anexo de cobertura del Encargo 17. La función y los límites se derivan de `08_memoria/memoria-vigente-v4.md` y `09_decisiones/registro-de-decisiones.md`. La biblioteca de diseño en `01_contexto_y_fuentes/biblioteca_diseno/` fundamenta principios y límites, pero no reemplaza la evidencia del proyecto.

Cuando una imagen contradice un documento vigente, prevalece el documento hasta registrar una nueva decisión. Una regla pasa de hipótesis a vigente solo después de una prueba pertinente, un registro reproducible y una consecuencia explícita.

## Estado de madurez

| Área | Estado actual | Para llamarla definitiva falta |
|---|---|---|
| Dirección conceptual | Vigente | Revisar comprensión en las tres superficies |
| Tema oscuro digital | Vigente como contrato de trabajo | Auditoría en prototipo funcional y texto ampliado |
| Color y uso del rojo | Rol vigente; percepción por validar | Pruebas de contraste, escala de grises y contexto |
| Tipografía y escala | Candidata con valores iniciales | Lectura real, Android, impresión y accesibilidad |
| Componentes Android | Estructurados | Implementación, foco, TalkBack, estados y recuperación |
| Editorial | Sistema definido como guía | Maquetación con contenido real, APA 7 e impresión |
| Testigo físico | Función definida; forma abierta | Señal, canal, material, energía, instalación, costo y convivencia |
| Movimiento | Reglas preventivas | Prototipo y prueba de reducción de movimiento |

## Próximo orden de trabajo

1. Auditar una sola pantalla Android contra el contrato semántico.
2. Reconstruirla con tokens reales, foco y estados.
3. Probar comprensión y accesibilidad.
4. Registrar la decisión y recién después extenderla a otra pantalla.
5. Llevar la misma pregunta al editorial o al testigo, sin copiar la interfaz.

## Fuentes base

- [Biblioteca de diseño](../../../01_contexto_y_fuentes/biblioteca_diseno/README.md): lecturas, cobertura y límites de Norman, Albers, Munari e Isaacson.
- [Memoria vigente v4](../../../08_memoria/memoria-vigente-v4.md): problema, propuesta phygital, usuarios, estado del arte y pendientes.
- [Registro de decisiones](../../../09_decisiones/registro-de-decisiones.md): decisiones de alcance, plataforma, flujo y dirección visual.
- [Wireframes del Encargo 17](../../../05_propuesta_phygital/wireframes-media-html/src/wireframes.ts): marcos, estados y acciones estructurales.
- [Anexo de cobertura](../../../05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md): 35 estados y cinco familias de interacción.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Apertura de v4

- **Cambio:** se abrió una versión centrada en piezas individuales y auditables.
- **Situación anterior:** el sistema v3 definía fundamentos generales y reunía exploraciones Android de calidad desigual.
- **Motivo:** evitar que una imagen panorámica o una serie generada oculte fallas de jerarquía, legibilidad y coherencia entre estados.
- **Asuntos abiertos:** definir una fuente única de reglas, estados de madurez y condiciones de validación.

### 2026-08-29 — Consolidación documental v4

- **Cambio:** el archivo se actualizó como índice principal de v4 y enlaza el manual central, cuatro anexos operativos, la documentación Android y la investigación interna.
- **Situación anterior:** el README solo describía la apertura de v4 y remitía a Android, sin establecer la arquitectura documental, el orden de autoridad ni la madurez de cada área.
- **Motivo:** convertir el sistema visual en una fuente navegable y gobernable, distinguir reglas vigentes de hipótesis y evitar que las imágenes actúen como especificación aislada.
- **Decisión de continuidad:** v3 y las exploraciones claras permanecen como historial; la v4 gobierna nuevas piezas digitales oscuras.
- **Asuntos abiertos:** validar comprensión, accesibilidad, color contextual, tipografía, movimiento, funcionamiento Android y todas las variables físicas del testigo.

### 2026-09-01 — Control editorial A3

- **Cambio:** v4 reconoce la página A3 horizontal única como formato de exploración editorial y fija `#D71921` como único rojo de señal.
- **Versión anterior:** la documentación visual no diferenciaba con suficiente claridad una página horizontal de un pliego y coexistían dos rojos de señal.
- **Motivo:** alinear la producción de memoria con el contrato visual y prevenir usos decorativos del sistema.
- **Alcance:** la decisión editorial no reemplaza una plantilla institucional ni valida los textos de las maquetas generadas.
