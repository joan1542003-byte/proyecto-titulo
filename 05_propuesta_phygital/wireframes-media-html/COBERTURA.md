# Cobertura de wireframes de media fidelidad en HTML

## Propósito y alcance

Este documento fija la cobertura que debe conservar la versión HTML de los wireframes del Encargo 17. La implementación puede presentar los marcos por separado y permitir la descarga individual de cada uno, pero no debe alterar la arquitectura evaluable ni convertir el anexo de estados en una nueva experiencia.

La cobertura se basa en el [Encargo 17](../../01_contexto_y_fuentes/encargo-17-requisitos.md), la [entrega escrita](../entrega-encargo-17.md), el [anexo de cobertura](../anexo-cobertura-interacciones-encargo-17.md), la [memoria vigente v4](../../08_memoria/memoria-vigente-v4.md) y las [referencias visuales 4K](../wireframes-referencia-4k/README.md).

El sistema es phygital: la aplicación configura y comunica estados; el testigo físico situado emite un pulso ambiental en el lugar asociado al primer paso. El estado físico situado forma parte del recorrido, aunque no sea una pantalla. El testigo no tiene interfaz de consulta: no muestra texto, menú, historial ni instrucciones, y no reemplaza a la aplicación.

## 1. Interacciones evaluables y nueve marcos exactos

La pauta exige tres interacciones principales, con un máximo de tres pantallas por interacción. La entrega se organiza en nueve marcos, distribuidos de la siguiente manera:

### Interacción 1. Formular y preparar una intención

| Marco | Función estructural |
| --- | --- |
| **1.1 Formular** | Registrar la intención personal y convertirla en un primer paso concreto. |
| **1.2 Configurar condición provisional** | Elegir y comprender una condición observable y una vigencia, sin presentarlas como definitivas. |
| **1.3 Revisar** | Comprobar intención, primer paso, condición y preparación antes de continuar. |

**Leyenda de la interacción:** esta interacción reúne el contenido mínimo del ciclo. La persona formula qué desea mantener disponible y cómo podría comenzar. La condición se explica como una hipótesis estructural, no como una lectura de aburrimiento o pérdida de control. La salida conecta con la vinculación y la prueba del testigo.

### Interacción 2. Situar, probar y armar el testigo

| Marco | Función estructural |
| --- | --- |
| **2.1 Situar** | Vincular el testigo y ubicarlo junto al primer paso de la actividad elegida. |
| **2.2 Probar el pulso** | Emitir una señal de prueba para revisar percepción, discreción y posibilidad de detenerla. |
| **2.3 Armar mediante control físico provisional** | Confirmar explícitamente el armado mediante una pulsación prolongada en el control físico provisional. |

**Leyenda de la interacción:** aquí la intención deja de ser solo información digital y se relaciona con un lugar. El pulso de prueba permite revisar la relación entre señal, superficie y convivencia. El armado requiere una acción explícita y deja el ciclo listo para esperar la condición configurada.

### Interacción 3. Recibir el pulso y cerrar el ciclo

| Marco | Función estructural |
| --- | --- |
| **3.1 Esperar** | Mostrar que el ciclo está armado, vigente y a la espera de una condición observable. |
| **3.2 Recibir el pulso situado** | Representar el momento físico en que el testigo emite el único pulso ambiental en el lugar elegido. |
| **3.3 Cerrar o recuperar un fallo técnico** | Permitir el cierre del ciclo o mostrar una recuperación técnica sin convertirla en una cuarta pantalla. |

**Leyenda de la interacción:** la espera ocurre sin juzgar el valor de la actividad digital. El pulso sucede en el espacio, no dentro de una interfaz de consulta instalada en el objeto. Después, la persona puede actuar, continuar, ignorar o silenciar; ninguna respuesta se registra como cumplimiento. El ciclo termina o se recupera de forma explícita.

### Ruta principal

`Formular → configurar → revisar → situar → probar → armar → esperar → recibir el pulso → cerrar o recuperar`

La tercera interacción mantiene visible la condición phygital: el marco 3.2 es contextual y representa el pulso situado, no una pantalla del testigo. Los nueve marcos son la síntesis evaluable; los estados 01–35 de la sección siguiente son cobertura complementaria.

## 2. Matriz completa de estados 01–35

La siguiente matriz conserva las cinco familias del anexo. “Contenido” identifica el estado y su condición de entrada; “acción” indica la salida principal; “continuidad” señala los estados siguientes documentados. Las continuidades no equivalen necesariamente a conexiones clicables.

### A. Configuración

| N.º | Contenido / estado | Acción o salida principal | Continuidad |
| --- | --- | --- | --- |
| 01 | **Sin configurar.** No existe un ciclo activo. | Crear una intención. | 02 |
| 02 | **Datos incompletos.** Falta intención, primer paso, condición o vigencia. | Completar o corregir. | 03 o 05 |
| 03 | **Permiso requerido.** La condición necesita un permiso de Android. | Revisar y solicitar permiso. | 04 o 05 |
| 04 | **Permiso denegado.** La persona rechaza o Android no concede el permiso. | Abrir ajustes o cambiar condición. | 03, 02 o 06 |
| 05 | **Revisión.** Los datos mínimos están completos. | Confirmar preparación o editar. | 07 o 02 |
| 06 | **Salida voluntaria.** La persona decide no continuar. | Descartar borrador o volver. | 01 o 05 |

### B. Vinculación y prueba física

| N.º | Contenido / estado | Acción o salida principal | Continuidad |
| --- | --- | --- | --- |
| 07 | **Buscando testigo.** Comienza la asociación física. | Esperar, reintentar o cancelar. | 08, 09 o 06 |
| 08 | **Elegir y confirmar testigo.** Se encuentra uno o más dispositivos. | Identificar y vincular el correcto. | 10 u 11 |
| 09 | **Testigo incorrecto o no reconocido.** El dispositivo no coincide o no responde. | Volver a buscar. | 07 |
| 10 | **Batería baja.** El testigo vinculado no asegura el ciclo. | Cargarlo o posponer. | 11 o 06 |
| 11 | **Probar lugar.** El testigo se ubica en el lugar elegido. | Emitir pulso de prueba. | 12, 13 o 14 |
| 12 | **Señal no percibida.** La persona no detecta el pulso de prueba. | Ajustar señal o reubicar. | 11 |
| 13 | **Señal intrusiva.** El pulso se percibe, pero interfiere con el contexto. | Reducir, reubicar o volver a probar. | 11 |
| 14 | **Listo para armar.** Lugar, enlace y pulso fueron comprobados. | Iniciar armado explícito. | 15 |

### C. Armado

| N.º | Contenido / estado | Acción o salida principal | Continuidad |
| --- | --- | --- | --- |
| 15 | **Vinculando o armando.** Se solicita el armado. | Esperar confirmación o cancelar. | 16 o 17 |
| 16 | **Armado.** Android y testigo confirman el ciclo activo. | Dejar el teléfono o desarmar. | 20 o 18 |
| 17 | **Confirmación ambigua o fallo.** No existe confirmación suficiente del armado. | Reintentar, revisar enlace o cancelar. | 15, 29 o 18 |
| 18 | **Desarmado voluntario.** La persona detiene el ciclo. | Cerrar o volver a preparar. | 01, 05 o 34 |
| 19 | **Editar mientras está armado.** Se intenta cambiar un ciclo activo. | Desarmar antes de editar o conservarlo. | 18, 02 o 20 |

### D. Espera y señal

| N.º | Contenido / estado | Acción o salida principal | Continuidad |
| --- | --- | --- | --- |
| 20 | **Armado en espera.** El ciclo está activo y la condición aún no ocurre. | Consultar estado o desarmar. | 21, 18 o 33 |
| 21 | **Condición cumplida y orden válida.** Android reconoce la condición provisional dentro de la vigencia. | Enviar la orden al testigo. | 23 o 29 |
| 22 | **Orden tardía o expirada.** La orden llega fuera de la vigencia definida. | Cerrar sin pulso o preparar otro ciclo. | 33 o 34 |
| 23 | **Señal física activa.** El testigo emite el único pulso situado. | Percibir y decidir libremente. | 24 o 25 |
| 24 | **Silenciar, ignorar o continuar.** La persona responde al pulso sin obligación de actuar. | Silenciar y cerrar; actuar queda fuera del registro. | 25 |

### E. Cierre y recuperación

| N.º | Contenido / estado | Acción o salida principal | Continuidad |
| --- | --- | --- | --- |
| 25 | **Intención cumplida o cierre.** La persona decide terminar el ciclo. | Cerrar sin registrar cumplimiento. | 01 o 34 |
| 26 | **Intención cambiada.** La persona ya no desea realizar lo formulado. | Cerrar o reformular. | 01 o 02 |
| 27 | **Permiso revocado.** Android retira un permiso durante el ciclo. | Recuperar permiso o cerrar. | 03, 18 o 33 |
| 28 | **Restricción en segundo plano.** Android impide observar la condición con fiabilidad. | Ajustar la restricción o cerrar. | 20, 18 o 33 |
| 29 | **Pérdida de BLE o reconexión.** Se interrumpe el vínculo con el testigo. | Reconectar, reintentar o cerrar. | 20, 23 o 33 |
| 30 | **Objeto movido.** Cambia el lugar cuya percepción fue probada. | Repetir prueba antes de continuar. | 11 |
| 31 | **Batería crítica.** La energía deja de asegurar la entrega del pulso. | Cargar, desarmar o cerrar. | 10, 18 o 33 |
| 32 | **Reinicio del objeto.** El testigo pierde temporalmente su estado. | Verificar vínculo y rearmar explícitamente. | 07, 15 o 34 |
| 33 | **Vencimiento sin activación.** Termina la vigencia sin una señal válida. | Cerrar o preparar un nuevo ciclo. | 01 o 34 |
| 34 | **Rearme explícito.** La persona desea repetir un ciclo terminado. | Revisar y confirmar nuevamente. | 05 |
| 35 | **Eliminar configuración.** La persona decide borrar el ciclo o borrador. | Confirmar eliminación o cancelar. | 01 o estado anterior |

## 3. Componentes y estados necesarios

### Componentes de interfaz

La pauta exige identificar los componentes con etiquetas simples. Como mínimo, la implementación debe hacer reconocibles los siguientes elementos:

| Componente | Uso dentro del recorrido |
| --- | --- |
| **Campo** | Escribir la intención y el primer paso. |
| **Selector** | Elegir condición, vigencia u otra alternativa explícitamente disponible. |
| **Tarjeta** | Agrupar el resumen de intención, primer paso, lugar, condición o estado técnico. |
| **Estado** | Informar preparación, espera, armado, conexión, permiso, batería o vencimiento. |
| **Acción** | Confirmar, continuar, editar, reintentar, cancelar, cerrar, desarmar o recuperar. |
| **Control físico** | Representar la prueba, el silenciamiento y el armado provisional del testigo. No es una pantalla del objeto. |
| **Respuesta** | Representar la señal percibida y las salidas legítimas: actuar, continuar, ignorar o silenciar. |
| **Variante de error** | Mostrar fallos técnicos recuperables, como permiso, batería, segundo plano, BLE, reinicio u orden tardía. |
| **Indicador de continuidad** | Hacer visible el paso siguiente sin convertir el anexo en una segunda experiencia. |
| **Leyenda** | Explicar, en tres a cinco líneas, qué resuelve cada interacción y por qué se estructura así. |

### Estados de sistema que deben distinguirse

La implementación debe diferenciar, al menos, los estados principales de la memoria:

1. **Sin intención:** no hay ciclo activo.
2. **Preparación:** se define actividad y primer paso.
3. **Vinculación:** se asocia y prueba el testigo.
4. **Situado:** el lugar fue elegido y la señal fue probada.
5. **Armado:** la condición se encuentra vigente.
6. **Señal activa:** el testigo emite el pulso ambiental.
7. **Fallo técnico:** la condición o el enlace no pueden ejecutarse.
8. **Ciclo cerrado:** la señal terminó, la regla venció o la persona cerró.

“Situado” y “señal activa” son estados del sistema phygital, no estados que deban convertirse en una interfaz de consulta dentro del objeto. La aplicación puede informar su estado técnico; el testigo participa por presencia, control físico y pulso ambiental.

## 4. Checklist verificable de la pauta

- [ ] Se presentan exactamente **tres interacciones principales** derivadas del flujo: formular/preparar; situar/probar/armar; recibir/cerrar.
- [ ] Cada interacción contiene **tres marcos como máximo** y la síntesis evaluable suma exactamente **nueve marcos**.
- [ ] Los nueve marcos conservan los nombres y funciones definidos en la sección 1.
- [ ] Cada marco identifica componentes mediante etiquetas simples y legibles.
- [ ] Cada interacción incluye una leyenda de **tres a cinco líneas**.
- [ ] En cada interacción se distinguen objetivo, información crítica, acción esperada, jerarquía y tratamiento de errores.
- [ ] Se conserva un recorrido conectado desde la formulación hasta el cierre o la recuperación.
- [ ] La representación mantiene fidelidad baja o media y no se presenta como diseño visual final.
- [ ] La versión HTML permite revisar cada marco de forma independiente sin duplicarlo como una nueva interacción.
- [ ] La descarga individual de un marco conserva su número, nombre, interacción y leyenda correspondiente.
- [ ] El marco 3.2 representa el pulso físico situado dentro del recorrido phygital y no una interfaz instalada en el testigo.
- [ ] El objeto no muestra texto, menú, historial, instrucciones ni una respuesta visual de consulta.
- [ ] El anexo 01–35 está separado de la síntesis evaluable y no se cuenta como 35 pantallas exigidas.
- [ ] Las condiciones, señales, materiales, gestos, permisos y umbrales se presentan como decisiones provisionales cuando todavía no han sido validados.
- [ ] Ignorar, continuar, silenciar, cambiar de idea, desarmar y cerrar aparecen como salidas legítimas; no se representan como incumplimiento.
- [ ] No existe rearme automático, registro de cumplimiento, puntaje, racha, bloqueo ni sanción.

## 5. Contradicciones a evitar

1. **Confundir el marco físico con una pantalla.** El pulso situado ocurre en el objeto y el entorno. La pantalla puede contextualizarlo, pero el objeto no tiene interfaz de consulta.
2. **Hacer que el objeto repita la aplicación.** No debe incorporar menú, texto, historial, configuración, estadísticas ni instrucciones.
3. **Convertir la señal en una orden.** Relevo devuelve una posibilidad a la decisión de la persona; no obliga a iniciar el primer paso.
4. **Contar el anexo como la entrega principal.** Los 35 estados documentan cobertura; la pauta evalúa tres interacciones con nueve marcos.
5. **Crear una cuarta pantalla para el fallo de 3.3.** El cierre y la recuperación técnica son variantes del mismo marco.
6. **Presentar como resultado validado una condición o señal provisional.** La matriz describe estructura; no demuestra comprensión, eficacia, convivencia, accesibilidad o funcionamiento técnico.
7. **Tratar toda continuidad digital como problema.** El usuario límite puede estar en una actividad significativa, relacional, concentrada o reparadora; en ese caso no corresponde intervenir.
8. **Inferir aburrimiento, automatismo, culpa o pérdida de control.** El sistema solo puede operar con condiciones observables y explicables.
9. **Introducir bloqueo, evaluación o cumplimiento.** Continuar, ignorar, silenciar, cambiar de intención y cerrar deben mantenerse como decisiones válidas.
10. **Perder la continuidad entre marcos.** Cada acción debe conducir a la salida documentada en la matriz o declarar con claridad una variante de error o salida voluntaria.
11. **Confundir media fidelidad con identidad final.** El HTML puede ser limpio y consistente para facilitar lectura, pero no debe convertir esta cobertura estructural en una especificación definitiva de forma, color, materialidad o canal.
12. **Dejar que las funciones de presentación alteren el producto.** La navegación y descarga individual de los wireframes son apoyos para revisar la entrega; no deben convertirse en funciones atribuidas a Relevo.

---

## Disclaimer de creación

**Fecha:** 26 de agosto de 2026.

**Cambio:** se creó esta cobertura para orientar la implementación HTML de media fidelidad del Encargo 17. Se reunieron las tres interacciones evaluables, sus nueve marcos exactos, la matriz completa de estados 01–35, los componentes, los estados, el checklist de la pauta y las contradicciones que deben evitarse.

**Versión anterior:** no existía un documento específico para la cobertura de los wireframes HTML.

**Motivo:** mantener trazabilidad entre la pauta, la memoria vigente, el anexo de estados y la futura implementación, haciendo explícito el papel del pulso físico situado dentro del recorrido phygital.

**Alcance:** este documento no agrega funciones, no acredita validación y no reemplaza la entrega evaluable ni la investigación de la memoria.

### 2026-09-02 — Actualización de enlace visual

- **Cambio:** se actualizó la ruta de las referencias visuales 4K después de normalizar el nombre de su carpeta.
- **Cómo estaba antes:** la ruta incluía una etiqueta de plataforma que podía confundirse con la decisión técnica del proyecto.
- **Motivo:** conservar la navegación funcional y distinguir la referencia visual del sistema Android documentado, sin modificar la cobertura HTML.
