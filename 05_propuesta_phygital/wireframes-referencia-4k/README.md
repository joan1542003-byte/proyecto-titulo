# Wireframes de referencia 4K — Encargo 17

## Propósito

Esta carpeta reúne las referencias visuales destinadas a reconstruir en Figma los 35 estados del ciclo mínimo de Relevo. Las láminas fueron producidas durante la vigencia de la memoria v2; la [memoria v4](../../08_memoria/memoria-vigente-v4.md) gobierna cualquier revisión posterior. El [anexo de cobertura](../anexo-cobertura-interacciones-encargo-17.md) conserva la relación entre estados y composiciones de baja o media fidelidad, sin fijar la interfaz final del producto.

Cada PNG mide exactamente `3840 × 2160 px`. El lenguaje gráfico es contemporáneo, minimalista y ordenado; la serie funciona como referencia compositiva y no modifica la decisión de usar Android como plataforma técnica inicial.

## Inventario y cobertura

| Lámina | Estados | Contenido |
| --- | --- | --- |
| [A1](A1-configuracion-4k.png) | 01–03 | Inicio, datos incompletos y permiso requerido. |
| [A2](A2-configuracion-4k.png) | 04–06 | Permiso no concedido, revisión y salida voluntaria. |
| [B1a](B1a-vinculacion-4k.png) | 07–08 | Búsqueda, identificación y elección del testigo. |
| [B1b](B1b-vinculacion-4k.png) | 09–10 | Testigo incorrecto y batería baja. |
| [B2a](B2a-prueba-4k.png) | 11–12 | Prueba situada y señal no percibida. |
| [B2b](B2b-prueba-4k.png) | 13–14 | Señal intrusiva y preparación previa al armado. |
| [C1](C1-armado-4k.png) | 15–17 | Armado en curso, confirmación y fallo ambiguo. |
| [C2](C2-armado-4k.png) | 18–19 | Desarmado voluntario y edición durante un ciclo activo. |
| [D1](D1-espera-4k.png) | 20–22 | Espera, orden válida y orden expirada. |
| [D2](D2-senal-4k.png) | 23–24 | Pulso situado y respuestas igualmente válidas. |
| [E1](E1-cierre-4k.png) | 25–27 | Cierre, cambio de intención y permiso revocado. |
| [E2](E2-recuperacion-4k.png) | 28–30 | Segundo plano, pérdida de vínculo y cambio de lugar. |
| [E3](E3-recuperacion-4k.png) | 31–33 | Batería crítica, reinicio y vencimiento sin activación. |
| [E4](E4-finales-4k.png) | 34–35 | Rearme explícito y eliminación. |

La serie distingue la naturaleza de cada estado:

- **Aplicación:** 01–06, 16, 18–20, 25–28 y 33–35.
- **Interacción coordinada entre aplicación, testigo y lugar:** 07–15, 17, 21–22 y 29–32.
- **Situación física:** 23; representa el pulso emitido en el lugar y no una pantalla.
- **Anotación de comportamiento:** 24; compara respuestas posibles sin afirmar que el sistema observe o juzgue la conducta.

## Cómo usarlas en Figma

1. Importar cada PNG como referencia bloqueada en una página separada.
2. Crear encima marcos móviles editables y reconstruir componentes, texto y espaciado.
3. Mantener la numeración 01–35 y las continuidades declaradas en el anexo.
4. Tratar las condiciones, permisos, umbrales de batería y cualidades del pulso como hipótesis provisionales.
5. No convertir las láminas en evidencia de validación ni añadir funciones no respaldadas por la memoria.

El tablero evaluable de nueve marcos continúa siendo la síntesis requerida por el Encargo 17. Estas catorce láminas son un anexo de profundidad para dibujar todos los estados posibles sin sobrecargar la entrega principal.

## Criterios de coherencia

- Un ciclo contiene una intención, un primer paso, una condición observable provisional, una vigencia, un testigo situado y un pulso posterior.
- La persona puede continuar, ignorar, silenciar, modificar, desarmar o cerrar sin evaluación moral ni registro de cumplimiento.
- Relevo no bloquea aplicaciones, no puntúa, no infiere estados subjetivos y no se rearma automáticamente.
- El testigo conserva una interacción física mínima; la aplicación configura, explica estados técnicos y facilita recuperación.
- El pulso físico no se presenta como una notificación convencional del teléfono.

El sistema gráfico completo se documenta en [contrato-visual.md](contrato-visual.md). Los registros de producción, correcciones y decisiones se conservan en [registro-laminas-07-14.md](registro-laminas-07-14.md), [registro-laminas-15-24.md](registro-laminas-15-24.md), [registro-laminas-25-35.md](registro-laminas-25-35.md) y [auditoria-lamina-01.md](auditoria-lamina-01.md). El cierre transversal está registrado en [auditoria-serie-4k.md](auditoria-serie-4k.md).

## Producción y auditoría

Las imágenes fueron producidas, revisadas por familias y normalizadas proporcionalmente a 4K. La supervisión verificó cobertura correlativa, legibilidad, coherencia de acciones y ausencia de patrones visuales propios de Android. Las correcciones finales evitaron un armado prematuro en el estado 14, precisaron la orden del estado 21, exigieron repetir la prueba tras el reinicio del estado 32 y mantuvieron el rearme del estado 34 como decisión explícita.

## Límites

Estas láminas no validan usabilidad, accesibilidad, percepción del pulso, estabilidad de BLE, ejecución en segundo plano, autonomía energética, forma o materialidad. Su precisión es estructural: permite discutir y prototipar la experiencia con trazabilidad, pero no reemplaza pruebas posteriores.

---

## Registro de creación (disclaimer)

### 2026-08-26 — Jerarquía de fuentes para futuras revisiones

- **Cambio:** se distinguió la memoria utilizada durante la producción de la fuente académica actualmente activa.
- **Versión anterior:** el README remitía únicamente a la v2 y podía interpretarse como instrucción vigente.
- **Motivo:** preservar el origen de las láminas sin desincronizar nuevas iteraciones de la memoria v4.
- **Alcance:** no se modificaron imágenes, estados ni decisiones visuales.

### 2026-08-25 — Serie completa de referencias 4K

- **Cambio:** se creó una serie de catorce láminas que representa los estados 01–35 y se documentaron su uso, cobertura, reglas y límites.
- **Versión anterior:** existía una serie sintética de siete láminas y un tablero editable de menor detalle.
- **Motivo:** ofrecer referencias grandes, legibles y consistentes que puedan reconstruirse manualmente en Figma sin perder las decisiones de la memoria.
- **Alcance:** material de baja o media fidelidad; no sustituye la entrega evaluable, no constituye validación y no fija el diseño final.

### 2026-08-25 — Auditoría independiente

- **Cambio:** se incorporó el veredicto transversal sobre cobertura, secuencia, autonomía, lenguaje visual y aptitud para reconstrucción.
- **Versión anterior:** el documento reunía la serie y sus controles de producción, pero no enlazaba una auditoría final separada.
- **Motivo:** distinguir la creación de las láminas de su revisión de cierre.
- **Alcance:** revisión de consistencia; no equivale a validación con usuarios ni técnica.

### 2026-09-02 — Normalización del nombre de la serie

- **Cambio:** se retiró del nombre de la carpeta y de las láminas cualquier referencia a una plataforma; también se ordenaron los registros por familia y función.
- **Cómo estaba antes:** la carpeta y sus archivos usaban una etiqueta de plataforma aunque funcionaban como referencias compositivas para reconstrucción.
- **Motivo:** evitar confundir una referencia visual con una decisión técnica y facilitar la navegación, sin modificar las imágenes ni los estados cubiertos.
