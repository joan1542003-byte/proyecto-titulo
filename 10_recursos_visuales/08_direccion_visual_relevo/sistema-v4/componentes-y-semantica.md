# Componentes y semántica de Relevo

## Propósito

Este documento define cómo se distingue cada elemento de la interfaz Android de Relevo. Un componente no se aprueba por su apariencia: debe tener una función, un estado, una jerarquía, un comportamiento y un criterio de accesibilidad.

La fuente estructural es `05_propuesta_phygital/wireframes-media-html/src/wireframes.ts`, complementada por `05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md` y `android/inventario-pantallas-oscuras.md`. La interfaz configura, organiza, confirma y recupera; el testigo emite la señal situada en el entorno.

## Contrato semántico

| Categoría | Definición | ¿Puede interactuarse? | Tratamiento mínimo | Riesgo que controla |
|---|---|---|---|---|
| Contenido | Información que la persona debe comprender | No necesariamente | Texto continuo, jerarquía y lectura clara | Que una instrucción parezca decoración |
| Icono | Signo convencional de una acción o entidad | Solo si tiene comportamiento | Significado estable, etiqueta accesible si es interactivo y área táctil | Que un símbolo ambiguo reemplace una acción |
| Elección | Alternativa que puede seleccionarse | Sí | Límite visible, seleccionado/no seleccionado y consecuencia | Que un estado parezca una opción o que el color sea la única diferencia |
| Acción | Control que ejecuta, confirma, ajusta o avanza | Sí | Nombre verbal, jerarquía, foco, objetivo táctil y salida | Que una acción quede escondida o parezca estado |
| Estado | Información no pulsable del sistema o del ciclo | No | Texto, estructura y tratamiento no interactivo | Que batería, vínculo o espera parezcan botones |
| Gráfico informativo | Relación visual que agrega comprensión | No, salvo controles separados | Leyenda o texto equivalente | Que puntos y líneas parezcan progreso o decoración |
| Decoración | Recurso prescindible sin información indispensable | No | Peso secundario, contraste controlado y separación | Que lo decorativo compita con la tarea |

Si una forma puede eliminarse sin perder comprensión, es decoración. Si su eliminación cambia la comprensión, debe reclasificarse como contenido o gráfico informativo. Si la persona debe tocarla, nunca es decoración.

## Anatomía común de una pantalla

El orden recomendado es:

1. encabezado y retorno, cuando exista;
2. título de pantalla;
3. explicación breve del objetivo;
4. contenido crítico del ciclo;
5. elección o estado correspondiente;
6. acción principal;
7. salidas secundarias y recuperación.

La secuencia no obliga a que todas las pantallas tengan los siete niveles. Evita, sin embargo, introducir una acción antes de explicar su consecuencia. Una pantalla puede agrupar información mediante reglas y espacio; no debe crear una tarjeta para cada dato.

## Componentes base

### Marco de pantalla

**Función:** mantener una tarea principal y un contexto reconocible.

**Reglas:** fondo `color.canvas`; margen lateral base de 24 dp; retícula de 8 dp; scroll si el texto ampliado lo necesita; una acción primaria por pantalla. El encabezado no incluye navegación inferior durante el recorrido único.

**No demuestra:** que una composición ordenada sea comprensible. Se valida mediante recorrido cognitivo y tarea real.

### Encabezado y retorno

El título identifica el momento (`FORMULAR`, `REVISAR`, `SITUAR`, `ESPERAR`). El retorno es un icono convencional dentro de un objetivo de 48 × 48 dp, con etiqueta accesible. La marca `RELEVO` no funciona como botón si no existe un comportamiento de inicio documentado.

### Título y explicación

El título expresa la tarea, no una promesa de transformación. La explicación responde qué se configura o qué ocurrió. Se evita el tono publicitario, el imperativo moral y el metalenguaje técnico.

Ejemplos válidos: `Define una intención`, `Comprueba el vínculo`, `Elige una condición`, `La señal se emitió en el testigo`. Ejemplos inválidos: `Sé mejor`, `No pierdas el tiempo`, `Lo lograste`.

### Campo editable

**Categoría:** contenido interactivo; funciona como elección editable.

**Uso:** intención y primer paso en el marco 1.1.

**Debe mostrar:** etiqueta, valor o marcador de posición, foco, error de completitud y posibilidad de editar. La línea o borde indica el campo; no se usa la matriz de puntos.

**Estados:** vacío, enfocado, completo, incompleto, error técnico si corresponde y lectura ampliada.

**Riesgo:** que un campo parezca una tarjeta o que `primer paso` se interprete como meta evaluada. El texto debe explicar que es una acción concreta de inicio.

### Fila de elección

**Categoría:** elección.

**Uso:** aplicación, condición, vigencia, testigo disponible o alternativa de lugar.

**Debe mostrar:** nombre, descripción breve, límite visible, estado seleccionado/no seleccionado y consecuencia de escogerla. La selección no puede depender solo del color; se usan posición, contorno, texto, icono o indicador redundante.

**Estados:** no seleccionada, seleccionada, enfocada, deshabilitada por dependencia, error de disponibilidad.

**Riesgo:** que el usuario lea una fila de estado como elección. Los valores técnicos como batería y vínculo permanecen fuera del contenedor seleccionable si no se pueden elegir.

### Acción primaria

**Categoría:** acción.

**Uso:** avanzar, revisar, vincular, probar, reintentar, cerrar o confirmar una decisión.

**Debe mostrar:** verbo y consecuencia reconocible. El contraste y la posición dan jerarquía; el rojo no se utiliza para convertirla en protagonista.

**Estados:** disponible, enfocada, presionada, en espera, deshabilitada con razón explicada y error recuperable.

**Riesgo:** que una acción se confunda con estado o que una acción de prueba se confunda con armado. `Emitir pulso` debe explicar que prueba el testigo; no arma el ciclo.

### Acción secundaria y salida

Editar, cancelar, silenciar, reubicar, desarmar y cerrar son acciones reales, aunque tengan menor jerarquía. No deben desaparecer por ser secundarias. `Cerrar ciclo` no significa que la intención se haya cumplido; `Preparar otro ciclo` siempre inicia una revisión explícita.

### Estado técnico

**Categoría:** estado.

**Ejemplos:** `Vínculo disponible`, `Batería suficiente para probar`, `Permiso pendiente`, `Vínculo perdido`, `El ciclo no se modificó`.

**Reglas:** texto y estructura primero; icono solo si es convencional; sin objetivo táctil si no hay acción; sin rojo de señal situada; sin contenedor que parezca selector.

### Gráfico de origen–vínculo–señal

**Categoría:** gráfico informativo.

Se utiliza cuando ayuda a comprender la relación entre intención, lugar, testigo y señal. Lleva texto equivalente (`Origen`, `Vínculo`, `Señal situada`) y no funciona como barra de progreso, paginación ni control. El rojo solo aparece en el nodo de señal situada, no en el origen ni el vínculo.

### Contexto físico

**Categoría:** contenido y gráfico informativo.

Representa la relación entre el primer paso y el lugar donde se situó el testigo. No decide la forma industrial del objeto, no presenta medidas no verificadas ni atribuye al testigo funciones de información continua. Si el dibujo se elimina y la instrucción sigue clara, el dibujo es decoración y debe reducirse.

## Estados visuales del flujo

La cobertura completa tiene 35 estados. La siguiente tabla define la lectura mínima y el componente dominante; no convierte cada estado en una pantalla adicional.

| Estados | Momento | Componente dominante | Acción o salida | Regla crítica |
|---:|---|---|---|---|
| 01–02 | Formular | Campo editable, contenido y estado de completitud | Crear, completar, corregir o guardar borrador | Sin rojo ni señal situada |
| 03–04 | Permiso | Estado técnico y acción de recuperación | Revisar ajustes, cambiar condición o volver | No atribuir el fallo a la persona |
| 05 | Revisar | Resumen de contenido y estado provisional | Editar o continuar para situar | El resumen no parece selector |
| 06 | Salida voluntaria | Acción de salida y elección de conservar/descartar | Guardar, descartar o seguir editando | Salir no es fracaso |
| 07–10 | Vincular | Estado de búsqueda, elección de testigo y batería | Esperar, buscar, vincular, cargar o posponer | No usar batería como acento de señal |
| 11–14 | Probar y preparar | Contexto físico, estado y acción | Emitir pulso, ajustar, declarar y continuar | Prueba antes de armado explícito |
| 15–19 | Armar | Estado de transición y control físico provisional | Esperar, cancelar, desarmar o editar | No mostrar progreso ni rearme automático |
| 20 | Esperar | Estado armado y resumen | Consultar o desarmar | Espera no es rendimiento |
| 21–22 | Orden | Estado técnico y gráfico de tránsito | Enviar, cerrar o preparar otro ciclo | Orden no es señal situada confirmada |
| 23–24 | Señal y respuesta | Gráfico contextual, señal situada y acciones | Percibir, silenciar, ignorar o continuar | Único nodo rojo; ninguna respuesta es evaluada |
| 25–26 | Cierre o cambio | Estado de cierre y acciones | Cerrar, editar o reformular | Cambiar de idea es válido |
| 27–32 | Recuperación | Estado técnico y acciones de reparación | Revisar permiso, reconectar, reubicar o probar | Fallo técnico no es incumplimiento |
| 33–35 | Vencimiento y eliminación | Estado de cierre, elección y confirmación | Cerrar, preparar otro, eliminar o cancelar | No afirmar resultado ni eliminar accidentalmente |

## Contrato por marco del Encargo 17

| Marco | Tarea | Contenido | Elecciones | Acciones | Estados / riesgos |
|---|---|---|---|---|---|
| 1.1 Formular | Registrar intención y primer paso | Propósito y etiquetas de campos | Valores editables | Crear y continuar, cancelar | Incompletitud no moralizante |
| 1.2 Condición | Elegir condición y vigencia | Explicación técnica | Aplicación, condición y ventana | Revisar ciclo, volver | Permiso separado de elección |
| 1.3 Revisar | Comprobar datos mínimos | Intención, primer paso, condición y vigencia | Ninguna implícita | Editar, continuar | Condición todavía provisional |
| 2.1 Situar | Vincular testigo y lugar | Relación objeto–intención–lugar | Testigo si hay más de uno | Vincular, elegir otro | Forma del objeto abierta |
| 2.2 Probar | Emitir señal de prueba | Lugar, primer paso y explicación | Resultado declarado después | Emitir, ajustar, reubicar | No inferir percepción |
| 2.3 Armar | Confirmar preparación | Resumen y gesto provisional | Ninguna implícita | Continuar, salir | No armar automáticamente |
| 3.1 Esperar | Mantener ciclo armado | Intención, condición y vigencia | Ninguna | Consultar, desarmar | No mostrar métricas |
| 3.2 Recibir | Percibir señal en contexto | Lugar, primer paso y señal | Respuesta libre | Silenciar si corresponde | Señal ocurre fuera de la pantalla |
| 3.3 Cerrar/recuperar | Terminar o reparar | Cierre o fallo técnico | Conservar/cerrar cuando aplique | Cerrar, reintentar, reconectar | Sin evaluación ni rearme |

## Reconstrucción desde wireframes

1. Leer el `objective`, `critical`, `action`, `hierarchy` y `error` del marco antes de elegir componentes.
2. Clasificar cada elemento según este contrato.
3. Mantener el flujo y los textos funcionales del wireframe; no agregar funciones para llenar espacio.
4. Sustituir tarjetas genéricas por filas, reglas o campos cuando no exista interacción independiente.
5. Añadir estados de foco, selección, error y recuperación aunque la imagen de referencia no los muestre.
6. Auditar el color en escala de grises y retirar el rojo de todo marco anterior a la señal situada.
7. Comprobar 48 × 48 dp, texto ampliado, orden de foco y etiquetas accesibles.
8. Registrar cualquier diferencia entre wireframe y prototipo como decisión, no como ajuste invisible.

## Criterios de rechazo

Se rechaza un componente si:

- su categoría no puede explicarse;
- una acción parece un estado o un estado parece pulsable;
- una elección se reconoce solo por color;
- un icono ambiguo reemplaza una etiqueta;
- los puntos se leen como progreso, paginación o selección;
- el rojo aparece fuera de la señal situada;
- introduce métrica, racha, recompensa, culpa o evaluación;
- modifica la función del flujo o promete una capacidad técnica no documentada.

## Referencias

Google. (2023). *Accessibility*. Android Developers. https://developer.android.com/design/ui/mobile/guides/foundations/accessibility

Norman, D. A. (2002). *The design of everyday things*. Basic Books.

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación del contrato de componentes

- **Cambio:** se creó la clasificación operativa de contenido, icono, elección, acción, estado, gráfico informativo y decoración; se definieron componentes Android, estados, marcos del Encargo 17 y reglas de reconstrucción.
- **Situación anterior:** la semántica estaba distribuida entre el contrato oscuro y el inventario de pantallas, sin un contrato único para implementar y auditar cada elemento.
- **Motivo:** evitar que una misma forma visual cambie de significado entre pantallas y controlar la traducción desde los wireframes sin agregar funciones.
- **Decisión de continuidad:** el inventario de 35 estados continúa siendo la fuente de cobertura; este documento define cómo representarlos, no cambia su flujo.
- **Asuntos abiertos:** validar textos, estados de foco, iconos, TalkBack, escalamiento y comportamiento técnico en un prototipo funcional.

### 2026-08-29 — Precisión funcional y bibliográfica

- **Cambio:** se describió el testigo por las funciones que cumple y se corrigió el año de la guía oficial de accesibilidad de Android.
- **Situación anterior:** el contexto físico incluía una negación innecesaria sobre el soporte y la referencia atribuía 2026 a una guía actualizada en 2023.
- **Motivo:** mantener el lenguaje centrado en la función de Relevo y la referencia APA 7 verificable.
