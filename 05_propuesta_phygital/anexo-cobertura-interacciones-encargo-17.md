# Anexo de cobertura de interacciones — Encargo 17

## Propósito

Este anexo amplía el tablero evaluable de nueve marcos sin reemplazarlo. Su función es comprobar que el ciclo mínimo de Relevo pueda representarse desde el inicio hasta su cierre, incluyendo validaciones, decisiones voluntarias, fallos técnicos y estados límite.

- **Figma:** [Anexo · Cobertura de estados](https://www.figma.com/design/kjzrPcLGWfoJZAVANivEo4?node-id=13-2)
- **Página:** `13:2`.
- **Tablero:** `13:3`.
- **Referencias detalladas para calcar:** [catorce láminas 4K con los 35 estados](wireframes-referencia-ios-4k/README.md).

La cobertura se construyó respecto del ciclo mínimo documentado entonces en la memoria v2. Para cualquier revisión posterior debe interpretarse bajo la [memoria v4](../08_memoria/memoria-vigente-v4.md), no como autorización para agregar funciones futuras. Cada estado tiene un wireframe independiente para poder revisarlo; esto no significa que la persona deba mirar el teléfono durante todo el recorrido. En uso, el pulso situado del testigo conserva el papel central y Android se limita a configurar, informar estado y facilitar recuperación.

## Reglas que delimitan la cobertura

- Un ciclo contiene una intención, un primer paso, una condición provisional, un testigo y un pulso.
- La persona puede continuar, ignorar, silenciar, modificar, desarmar o cerrar sin que el sistema juzgue su conducta.
- Relevo no bloquea aplicaciones, no infiere estados subjetivos y no registra cumplimiento.
- Una decisión personal distinta de la intención inicial es una salida válida, no un error.
- Después del cierre, vencimiento, silencio o desarmado no existe rearme automático.
- Los fallos se comunican como estados técnicos recuperables y no como incumplimientos.

## Matriz de wireframes

### A. Configuración

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 01 | Sin configurar | No existe un ciclo activo. | Crear una intención. | 02 |
| 02 | Datos incompletos | Falta intención, primer paso, condición o vigencia. | Completar o corregir. | 03 o 05 |
| 03 | Permiso requerido | La condición necesita un permiso de Android. | Revisar y solicitar permiso. | 04 o 05 |
| 04 | Permiso denegado | La persona rechaza o Android no concede el permiso. | Abrir ajustes o cambiar condición. | 03, 02 o 06 |
| 05 | Revisión | Los datos mínimos están completos. | Confirmar preparación o editar. | 07 o 02 |
| 06 | Salida voluntaria | La persona decide no continuar. | Descartar borrador o volver. | 01 o 05 |

### B. Vinculación y prueba física

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 07 | Buscando testigo | Comienza la asociación física. | Esperar, reintentar o cancelar. | 08, 09 o 06 |
| 08 | Elegir y confirmar testigo | Se encuentra uno o más dispositivos. | Identificar y vincular el correcto. | 10 u 11 |
| 09 | Testigo incorrecto o no reconocido | El dispositivo no coincide o no responde. | Volver a buscar. | 07 |
| 10 | Batería baja | El testigo vinculado no asegura el ciclo. | Cargarlo o posponer. | 11 o 06 |
| 11 | Probar lugar | El testigo se ubica en el lugar elegido. | Emitir pulso de prueba. | 12, 13 o 14 |
| 12 | Señal no percibida | La persona no detecta el pulso de prueba. | Ajustar señal o reubicar. | 11 |
| 13 | Señal intrusiva | El pulso se percibe, pero interfiere con el contexto. | Reducir, reubicar o volver a probar. | 11 |
| 14 | Listo para armar | Lugar, enlace y pulso fueron comprobados. | Iniciar armado explícito. | 15 |

### C. Armado

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 15 | Vinculando o armando | Se solicita el armado. | Esperar confirmación o cancelar. | 16 o 17 |
| 16 | Armado | Android y testigo confirman el ciclo activo. | Dejar el teléfono o desarmar. | 20 o 18 |
| 17 | Confirmación ambigua o fallo | No existe confirmación suficiente del armado. | Reintentar, revisar enlace o cancelar. | 15, 29 o 18 |
| 18 | Desarmado voluntario | La persona detiene el ciclo. | Cerrar o volver a preparar. | 01, 05 o 34 |
| 19 | Editar mientras está armado | Se intenta cambiar un ciclo activo. | Desarmar antes de editar o conservarlo. | 18, 02 o 20 |

### D. Espera y señal

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 20 | Armado en espera | El ciclo está activo y la condición aún no ocurre. | Consultar estado o desarmar. | 21, 18 o 33 |
| 21 | Condición cumplida y orden válida | Android reconoce la condición provisional dentro de la vigencia. | Enviar la orden al testigo. | 23 o 29 |
| 22 | Orden tardía o expirada | La orden llega fuera de la vigencia definida. | Cerrar sin pulso o preparar otro ciclo. | 33 o 34 |
| 23 | Señal física activa | El testigo emite el único pulso situado. | Percibir y decidir libremente. | 24 o 25 |
| 24 | Silenciar, ignorar o continuar | La persona responde al pulso sin obligación de actuar. | Silenciar y cerrar; actuar queda fuera del registro. | 25 |

### E. Cierre y recuperación

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 25 | Intención cumplida o cierre | La persona decide terminar el ciclo. | Cerrar sin registrar cumplimiento. | 01 o 34 |
| 26 | Intención cambiada | La persona ya no desea realizar lo formulado. | Cerrar o reformular. | 01 o 02 |
| 27 | Permiso revocado | Android retira un permiso durante el ciclo. | Recuperar permiso o cerrar. | 03, 18 o 33 |
| 28 | Restricción en segundo plano | Android impide observar la condición con fiabilidad. | Ajustar la restricción o cerrar. | 20, 18 o 33 |
| 29 | Pérdida de BLE o reconexión | Se interrumpe el vínculo con el testigo. | Reconectar, reintentar o cerrar. | 20, 23 o 33 |
| 30 | Objeto movido | Cambia el lugar cuya percepción fue probada. | Repetir prueba antes de continuar. | 11 |
| 31 | Batería crítica | La energía deja de asegurar la entrega del pulso. | Cargar, desarmar o cerrar. | 10, 18 o 33 |
| 32 | Reinicio del objeto | El testigo pierde temporalmente su estado. | Verificar vínculo y rearmar explícitamente. | 07, 15 o 34 |
| 33 | Vencimiento sin activación | Termina la vigencia sin una señal válida. | Cerrar o preparar un nuevo ciclo. | 01 o 34 |
| 34 | Rearme explícito | La persona desea repetir un ciclo terminado. | Revisar y confirmar nuevamente. | 05 |
| 35 | Eliminar configuración | La persona decide borrar el ciclo o borrador. | Confirmar eliminación o cancelar. | 01 o estado anterior |

## Criterio de lectura

Las pantallas 01, 05, 08, 11, 14, 16, 20, 23 y 25 forman la ruta principal. Las demás no componen una segunda experiencia: hacen visibles las bifurcaciones necesarias para que el sistema sea comprensible y recuperable. El anexo distingue cinco tipos de ruta: principal, validación previa, salida voluntaria, fallo técnico y estado límite.

## Auditoría del archivo Figma

La revisión final confirmó:

- 35 wireframes editables y numerados correlativamente;
- cinco secciones: configuración, vinculación y prueba física, armado, espera y señal, cierre y recuperación;
- 475 nodos de texto, todos en Roboto;
- escala de grises sin colores ajenos;
- ausencia de elementos desbordados;
- disparador, acción y siguiente estado visibles en cada marco;
- tablero evaluable original preservado en el marco `2:2`, con 2300 × 2760 px, nueve pantallas y 186 nodos de texto.

Las transiciones están declaradas textualmente y no como conexiones clicables. Esta decisión corresponde al nivel de baja fidelidad y mantiene el foco en la estructura antes de prototipar comportamiento.

## Límites

Los wireframes describen estructura y comportamiento esperado. No validan la condición de activación, la intensidad del pulso, la comprensión del armado, la estabilidad de Android o BLE, la autonomía energética ni la pertinencia del testigo en contextos reales. Esas decisiones continúan abiertas a prototipado y prueba.

---

## Registro de cambios (disclaimer)

### 2026-08-26 — Fuente académica vigente

- **Cambio:** el anexo distingue la memoria v2 utilizada al crear la cobertura de la v4 que gobierna revisiones posteriores.
- **Versión anterior:** la v2 aparecía como fuente activa sin indicar que había sido sustituida.
- **Motivo:** evitar divergencias entre los wireframes documentados y la memoria vigente.
- **Alcance:** no se añadieron ni eliminaron estados de interacción.

### 2026-08-25 — Cobertura visual 4K por estado

- **Cambio:** se sustituyó la referencia principal de siete láminas por catorce composiciones 4K, manteniendo la correspondencia exacta con la matriz 01–35.
- **Versión anterior:** el anexo remitía a una síntesis visual de siete imágenes.
- **Motivo:** separar mejor estados, escenas físicas y recuperaciones para facilitar su reconstrucción en Figma.
- **Alcance:** no se incorporan nuevas funciones ni se modifica la matriz; la serie anterior permanece como historial.

### 2026-08-25 — Referencias visuales detalladas

- **Cambio:** se enlazaron siete láminas generadas y auditadas para reconstruir los 35 estados en Figma.
- **Versión anterior:** el anexo contenía wireframes editables deliberadamente esquemáticos.
- **Motivo:** aportar una referencia visual más detallada sin sustituir la estructura editable ni fijar un diseño final.
- **Alcance:** las láminas sirven para calcar y discutir; no constituyen validación ni interfaz definitiva.

### 2026-08-25 — Incorporación y auditoría del tablero Figma

- **Cambio:** se incorporaron el enlace directo, los identificadores del anexo y los resultados de la auditoría visual y programática.
- **Versión anterior:** la matriz escrita definía los 35 estados, pero no registraba aún su representación editable.
- **Motivo:** mantener trazabilidad entre la arquitectura documentada y el archivo de trabajo.
- **Alcance:** se verificó estructura de baja fidelidad; las transiciones no constituyen todavía un prototipo interactivo.

### 2026-08-25 — Creación del anexo de cobertura

- **Cambio:** se documentaron 35 estados del ciclo mínimo, organizados en cinco familias y vinculados mediante disparadores, acciones y continuidades.
- **Versión anterior:** el Encargo 17 mostraba únicamente la ruta evaluable de tres interacciones y nueve marcos.
- **Motivo:** verificar todas las interacciones relevantes sin sobrecargar ni modificar el tablero exigido por la pauta.
- **Alcance:** la matriz amplía la cobertura estructural; no incorpora funciones futuras ni acredita validación técnica o con usuarios.
