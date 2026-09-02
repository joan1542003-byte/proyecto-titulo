# Android v4 — dirección oscura

## Alcance y estado

Esta carpeta contiene 20 referencias rasterizadas del flujo Android de Relevo: una pantalla de inicio, dos versiones para cada pantalla 02–10 y una referencia horizontal adicional para la señal situada. Se auditaron visualmente todos los PNG vigentes.

El modo oscuro es la única dirección vigente. Las v1 superadas se conservan para hacer trazable el proceso, pero no deben utilizarse para reconstruir la interfaz cuando existe una v2. Las imágenes son referencias visuales: todavía requieren reconstrucción manual, texto real, estados funcionales, pruebas de interacción y auditoría de accesibilidad.

La aplicación configura, acompaña y confirma. El testigo emite la señal situada en el lugar elegido. La pantalla informa esa relación; no reemplaza la experiencia física ni evalúa si la persona comenzó la actividad.

## Criterios semánticos comunes

- Contenido: información que la persona debe comprender.
- Icono: signo convencional que representa una acción o entidad; si es interactivo, requiere etiqueta accesible, foco y objetivo táctil suficiente.
- Elección: alternativa seleccionable con límites y estados distinguibles sin depender solo del color.
- Acción: control que ejecuta, confirma, ajusta, recupera o avanza.
- Estado: información del sistema que no es pulsable.
- Gráfico informativo: composición que explica una relación; necesita texto o leyenda equivalente.
- Decoración: elemento prescindible que no contiene información indispensable ni interacción; no debe parecer botón, selector, pestaña, paginación o progreso.

El rojo #D71921 identifica únicamente el nodo de señal situada. Antes de situar la intención no aparece. Los puntos solo se permiten como marca, señal expresiva breve o gráfico informativo con texto equivalente; no son selección, progreso ni estado. El testigo emite la señal situada y la aplicación comunica el vínculo, la prueba y sus estados.

## Referencias vigentes y candidatas

### 01 — Inicio sin ciclo

Archivo: 01-inicio-sin-ciclo-oscuro-v1.png

Estado: vigente; candidata principal para el inicio.

Función y estado fuente: marco 1.1, estado sin configurar. Presenta la ausencia de ciclo activo y ofrece crear una intención.

Categorías semánticas: RELEVO, SIN CONFIGURAR y el texto explicativo son contenido; ausencia de ciclo es estado; Crear intención es acción; el fondo plano y el espacio libre son decoración secundaria.

Decisión: una sola acción visible, sin rojo, puntos, métricas ni módulos innecesarios. La pantalla establece el tono del flujo antes de que exista una señal situada.

Riesgo: el raster presenta una leve textura; la reconstrucción debe usar un fondo plano. La marca debe permanecer identificable como marca y no como control.

Criterio de reconstrucción: Pantalla Android oscura única, 390×844, RELEVO, SIN CONFIGURAR, Todavía no hay un ciclo activo., Puedes definir una intención y un primer paso., Crear intención; IBM Plex, retícula 8 dp, sin rojo ni métricas.

Reconstrucción necesaria: texto real, escala sp, área táctil, foco, estado vacío y ampliación de texto.

### 02 — Formular intención

Archivo: 02-formular-intencion-oscuro-v2.png

Estado: aprobada como dirección visual; reconstrucción manual pendiente.

Función y estado fuente: marco 1.1, formulación de la intención y del primer paso.

Categorías semánticas: FORMULAR, título, etiquetas y ayuda son contenido; los campos de intención y primer paso son elecciones editables; Atrás, Cancelar y Continuar son acciones; el cursor y el foco son estados de interacción; la regla inferior es decoración estructural.

Decisión: la v2 reduce el título, incorpora retorno claro y cambia las cajas genéricas por campos lineales. La edición se separa de la explicación y de la navegación.

Riesgo: los campos pueden parecer texto estático si el foco, el cursor y la validación no se implementan. Cancelar y Atrás pueden duplicar salida si no se define su consecuencia.

Criterio de reconstrucción: Pantalla Android oscura única, FORMULAR, ¿Qué quieres iniciar?, campos lineales Salir a caminar y Ponerte las zapatillas, ayuda breve, Atrás, Cancelar, Continuar; IBM Plex, retícula 8 dp, sin rojo ni tarjetas genéricas.

Reconstrucción necesaria: teclado, foco, edición, validación, errores, orden de lectura y decisión sobre las dos salidas.

### 03 — Condición provisional

Archivo: 03-condicion-provisional-oscuro-v2.png

Estado: candidata; no pasa todavía a referencia principal.

Función y estado fuente: marco 1.2, configuración de aplicación, condición observable y vigencia antes de revisar el ciclo.

Categorías semánticas: título, explicación y valores son contenido; aplicación, condición y vigencia son elecciones; disponibilidad y permisos son estados; Atrás y Revisar ciclo son acciones; cheurones son iconos convencionales solo si mantienen etiqueta y área táctil.

Decisión: la v2 elimina comillas, reduce la escala del título y limita visualmente las tres elecciones. La estructura es más clara que la v1.

Riesgo: mantiene retorno en la barra superior y una acción Atrás inferior. Esa duplicación puede generar duda sobre la navegación. Los cheurones no deben cargar por sí solos el significado de cada campo.

Criterio de reconstrucción: Pantalla Android oscura única, CONFIGURAR CONDICIÓN, aplicación, condición provisional y vigencia como tres campos seleccionables delineados, Atrás, Revisar ciclo; IBM Plex, sin rojo, puntos ni tarjetas universales.

Reconstrucción necesaria: conservar una sola salida, definir estados seleccionado/no seleccionado, permisos, valores no disponibles y lectura accesible.

### 04 — Revisar ciclo

Archivo: 04-revisar-ciclo-oscuro-v2.png

Estado: aprobada como dirección visual; reconstrucción manual pendiente.

Función y estado fuente: marco 1.3, revisión de la configuración antes de situar el testigo.

Categorías semánticas: intención, primer paso, condición y vigencia son contenido; El ciclo aún no está armado es estado; Editar y Continuar para situar son acciones; filas y reglas son estructura informativa, no decoración autónoma.

Decisión: la v2 reemplaza la tarjeta-resumen dominante por una agrupación de filas, reglas y ritmo tipográfico. El estado queda separado de los datos y no usa rojo.

Riesgo: las filas deben seguir siendo legibles como resumen y no parecer una lista de opciones. Un icono informativo no es necesario si el texto ya explica el estado.

Criterio de reconstrucción: Pantalla Android oscura única, REVISAR, Salir a caminar, primer paso, condición provisional, vigencia, estado El ciclo aún no está armado, acciones Editar y Continuar para situar; filas con reglas, sin tarjeta gigante ni rojo.

Reconstrucción necesaria: texto real, lectura lineal, foco, navegación y prueba para distinguir contenido de elección.

### 05 — Vincular testigo

Archivo: 05-vincular-testigo-oscuro-v2.png

Estado: candidata.

Función y estado fuente: marco 2.1, confirmación del testigo situado y preparación del vínculo.

Categorías semánticas: SITUAR, explicación y nombre del testigo son contenido; vínculo y batería son estados; Elegir otro y Vincular testigo son acciones; las filas y reglas son estructura informativa.

Decisión: la v2 elimina la silueta que fijaba prematuramente una forma industrial y traduce la confirmación a estados textuales. El testigo se entiende por la función que cumple: emite la señal situada en el lugar elegido.

Riesgo: la alineación vertical y la jerarquía de Vincular testigo todavía pueden normalizarse. Elegir otro debe tener una consecuencia distinta y visible.

Criterio de reconstrucción: Pantalla Android oscura única, SITUAR, Confirma el testigo, explicación breve, filas TESTIGO — Relevo, Vínculo disponible, Batería suficiente para probar, acciones Elegir otro y Vincular testigo; IBM Plex, sin representación industrial cerrada ni rojo.

Reconstrucción necesaria: alinear etiquetas y valores, definir jerarquía de acciones, vínculo disponible, batería insuficiente y recuperación.

### 06 — Probar señal

Archivo: 06-probar-pulso-oscuro-v2.png

Estado: aprobada como dirección visual; reconstrucción manual pendiente.

Función y estado fuente: marco 2.2, prueba breve de la señal en el testigo antes de armar el ciclo.

Categorías semánticas: intención, primer paso y lugar son contenido; vínculo y batería son estados; Ajustar lugar y Emitir pulso son acciones; la explicación de la prueba es contenido; la separación por reglas es estructura.

Decisión: la v2 aclara que la prueba emite una señal breve en el testigo y que el resultado posterior lo declara la persona. No simula la señal dentro de la interfaz.

Riesgo: Emitir pulso podría confundirse con armar el ciclo si el texto explicativo desaparece. La prueba y el armado deben conservar estados distintos.

Criterio de reconstrucción: Pantalla Android oscura única, PROBAR EL PULSO, Sitúa el testigo junto al primer paso., filas de intención, primer paso y lugar, estados de vínculo y batería, El resultado lo declaras tú después de la prueba., Ajustar lugar, Emitir pulso; sin rojo ni simulación gráfica del evento.

Reconstrucción necesaria: emisión real, resultado declarado, permisos, errores y separación entre probar y armar.

### 07 — Ciclo activo en espera

Archivo: 07-ciclo-activo-espera-oscuro-v2.png

Estado: aprobada como dirección visual; reconstrucción manual pendiente.

Función y estado fuente: marco 3.1, ciclo armado y en espera de la condición configurada.

Categorías semánticas: intención, primer paso, condición, vigencia y testigo son contenido; CICLO ACTIVO, vínculo disponible y disponibilidad de señal son estados; Desarmar ciclo es acción; reglas y espacio son estructura secundaria.

Decisión: la espera se comunica sin contador, racha, porcentaje, premio ni evaluación. El testigo queda preparado para emitir la señal situada cuando corresponda.

Riesgo: el texto heredado de la imagen necesita corrección manual para expresar esa función con claridad. CICLO ACTIVO debe significar configuración armada, no actividad realizada.

Criterio de reconstrucción: Pantalla Android oscura única, CICLO ACTIVO, intención, primer paso, condición provisional, vigencia, testigo, vínculo disponible, estado de espera, Desarmar ciclo; retícula precisa, sin métricas, progreso, culpa ni rojo.

Reconstrucción necesaria: reemplazar copy heredado, definir actualización de estados, desarme explícito y comportamiento ante pérdida de vínculo.

### 08 — Señal situada

Archivo: 08-senal-situada-oscuro-v2.png

Estado: aprobada como dirección; mejor referencia actual de la señal situada.

Función y estado fuente: marcos 3.2/3.3, comunicación de que el testigo emitió una señal en el lugar configurado.

Categorías semánticas: SEÑAL SITUADA, intención, lugar y primer paso son contenido; la relación intención → vínculo → señal situada es gráfico informativo; el único nodo rojo es señal situada; Se emitió una señal en el testigo es estado; Silenciar testigo y Cerrar ciclo son acciones; puntos y reglas pertenecen al gráfico informativo, no a controles.

Decisión: un único nodo #D71921 identifica el acontecimiento. La matriz y la transferencia se acompañan con texto equivalente. La pantalla devuelve la decisión a la persona mediante Ahora decides si comienzas.

Riesgo: los puntos pueden parecer progreso o selección si pierden sus rótulos. El nodo rojo no debe ser pulsable ni transformarse en alerta. El icono de silencio requiere significado convencional y etiqueta accesible.

Criterio de reconstrucción: Pantalla Android oscura única, SEÑAL SITUADA, relación informativa etiquetada INTENCIÓN → VÍNCULO → SEÑAL SITUADA, un único nodo rojo #D71921, lugar, primer paso, Ahora decides si comienzas, Silenciar testigo, Cerrar ciclo; sin métricas ni controles decorativos.

La referencia `11-referencia-senal-situada-horizontal.png` amplía este criterio: propone una transferencia horizontal más directa y una jerarquía tipográfica contenida. Se conserva como referencia de calidad para 3.2, no como una pantalla nueva ni como sustituto del marco vigente.

Reconstrucción necesaria: gráfico con texto equivalente, contraste en escala de grises, estado de silencio, cierre sin evaluación y sincronía con el testigo.

### 09 — Recuperar vínculo

Archivo: 09-fallo-vinculo-oscuro-v2.png

Estado: candidata.

Función y estado fuente: marco 3.3, pérdida de vínculo y recuperación sin modificar silenciosamente el ciclo.

Categorías semánticas: descripción y explicación son contenido; vínculo perdido es estado; testigo y conservación del ciclo son contenido/estado; Cerrar ciclo y Reintentar vínculo son acciones; reglas son estructura.

Decisión: la v2 elimina comillas, guiones ambiguos e iconografía innecesaria. Se mantiene el fallo en acromático: el rojo pertenece solo a la señal situada.

Riesgo: Vínculo perdido aparece repetido como titular y estado. La versión candidata debe mostrarlo una vez y establecer una jerarquía evidente para Reintentar vínculo como recuperación.

Criterio de reconstrucción: Pantalla Android oscura única, RECUPERAR, Vínculo perdido una sola vez, testigo, explicación El ciclo no se modificó. Comprueba la conexión y vuelve a intentarlo., acciones Reintentar vínculo y Cerrar ciclo; estado textual, sin rojo ni iconos ambiguos.

Reconstrucción necesaria: reducir repetición, ordenar acciones, documentar permisos, reconexión y conservación del ciclo.

### 10 — Ciclo cerrado

Archivo: 10-ciclo-cerrado-oscuro-v2.png

Estado: aprobada como dirección visual; reconstrucción manual pendiente.

Función y estado fuente: marco 3.3, cierre del ciclo y salida sin afirmar cumplimiento.

Categorías semánticas: estado de cierre, intención y última configuración son contenido/estado; Salir y Preparar otro ciclo son acciones; Testigo desvinculado es estado; reglas y espacio son estructura secundaria.

Decisión: la v2 elimina el check de éxito, las comillas y la iconografía ambigua. Ciclo cerrado describe el estado del sistema; no significa que la persona haya iniciado la actividad ni que exista un resultado positivo.

Riesgo: la barra superior y la marca deben mantener una jerarquía única. Preparar otro ciclo debe iniciar una nueva configuración explícita, nunca un rearme automático.

Criterio de reconstrucción: Pantalla Android oscura única, CICLO CERRADO, Ciclo cerrado, intención, estado del ciclo, última configuración, Testigo desvinculado, Salir, Preparar otro ciclo; cierre no evaluativo, sin check de logro, métricas ni rojo.

Reconstrucción necesaria: confirmar cierre, desvinculación, salida, nueva configuración y orden de foco.

## Tabla de descarte y antecedentes

| Archivo | Estado | Motivo de descarte o superación | Qué se conserva |
|---|---|---|---|
| 02-formular-intencion-oscuro-v1.png | Histórica; superada | Título excesivo, campos genéricos y retorno poco claro | Separación entre intención y primer paso |
| 03-condicion-provisional-oscuro-v1.png | Histórica; superada | Comillas, título sobredimensionado y selectores pesados | Tres decisiones separadas |
| 04-revisar-ciclo-oscuro-v1.png | Histórica; superada | Tarjeta-resumen dominante y agrupación poco informativa | Revisión previa a situar |
| 05-vincular-testigo-oscuro-v1.png | Rechazada | La silueta fija prematuramente una forma industrial | Estados de vínculo y batería como información secundaria |
| 06-probar-pulso-oscuro-v1.png | Histórica; superada | Jerarquía excesiva y lenguaje heredado que distrae de la prueba | Separación entre prueba, lugar y declaración |
| 07-ciclo-activo-espera-oscuro-v1.png | Histórica; superada | Comillas, copy heredado y acción de desarme con apariencia deshabilitada | Estado de espera y salida explícita |
| 08-senal-situada-oscuro-v1.png | Histórica; superada | Comillas, jerarquía roja ambigua y relación menos legible | Rojo reservado al acontecimiento situado |
| 09-fallo-vinculo-oscuro-v1.png | Histórica; superada | Repetición, guiones ambiguos e indicador técnico confuso | Recuperación sin evaluación |
| 10-ciclo-cerrado-oscuro-v1.png | Rechazada | Check de éxito e iconografía ambigua; cierre podía parecer logro | Cierre sin afirmar cumplimiento |

No se borran las v1. Su función es documentar decisiones descartadas y evitar que se repitan sus problemas.

## Auditoría común antes de implementar

1. La pantalla corresponde a un marco y estado real del flujo.
2. El contenido principal se comprende antes de atender la decoración.
3. Cada elección tiene límites, estados y consecuencia visibles.
4. Cada acción expresa qué ejecuta y tiene foco y objetivo táctil suficiente.
5. Ningún estado parece pulsable.
6. Los iconos son convencionales, escasos y accesibles cuando son interactivos.
7. El rojo aparece únicamente en el nodo de señal situada y el significado se conserva sin color.
8. Los puntos, si se mantienen, tienen rótulo o texto equivalente y no parecen progreso, paginación o selección.
9. El testigo se describe por su función: emite la señal situada en el lugar elegido.
10. No hay métricas, rachas, premios, culpa, moralización, evaluación ni rearme automático.
11. La reconstrucción conserva IBM Plex, retícula, contraste, escalamiento y estados de error.
12. La pantalla se prueba con texto real, lectura lineal, foco, ampliación y tareas completas.

## Limitaciones

Las imágenes rasterizadas pueden contener errores tipográficos, textura, proporciones o alineaciones que no deben pasar directamente al prototipo. La auditoría visual no certifica accesibilidad, rendimiento, permisos, conexión, sincronización ni percepción del testigo. Esos aspectos requieren implementación y pruebas con personas.

## Registro de cambios (disclaimer)

### 2026-08-29 — Corrección de estados y fichas de imágenes

- Qué se modificó: se reescribió el README para documentar la dirección oscura vigente, las diez referencias actuales o candidatas, la tabla breve de descarte de v1, los criterios existentes, los riesgos y la reconstrucción necesaria.
- Cómo estaba antes: el documento registraba principalmente las v1 y las presentaba como aprobadas, mientras que las v2 no tenían una ficha equivalente. También conservaba formulaciones heredadas que describían al testigo por ausencia o situaban el evento mediante lenguaje impreciso.
- Qué se reemplazó: las v1 de 02–10 dejaron de figurar como referencias de implementación. 05-vincular-testigo-oscuro-v1.png quedó explícitamente rechazada por fijar una silueta industrial; las demás v1 quedaron como históricas o superadas según su problema.
- Qué se incorporó: 02, 04, 06, 07, 08 y 10 v2 como dirección aprobada; 03, 05 y 09 v2 como candidatas con ajustes concretos; 08 v2 como mejor referencia actual de señal situada.
- Corrección de lenguaje: se eliminó la descripción del testigo por ausencia y se documentó positivamente que emite la señal situada en el lugar elegido. Las imágenes rasterizadas que aún contienen copy heredado quedan señaladas para corrección durante la reconstrucción manual.
- Por qué: hacer coincidir el registro con la auditoría visual y con el contrato semántico del sistema, evitando contradicciones entre versiones y decisiones prematuras sobre el objeto.
- Alcance: no se modificaron PNG, wireframes, memoria, inventario ni otros documentos. La forma industrial, el material y el mecanismo del testigo siguen abiertos a investigación y validación.

### 2026-09-01 — Unificación cromática

- **Cambio:** las menciones del rojo de señal se actualizaron a `#D71921`.
- **Versión anterior:** las fichas y prompts registraban `#EF3E45`.
- **Motivo:** sincronizar las referencias Android con el token semántico y el control editorial vigentes.
- **Alcance:** no se modificaron los PNG ni se autorizó el rojo para selección, navegación o decoración.

### 2026-09-02 — Referencia horizontal de señal situada

- **Cambio:** se incorporó una referencia adicional para la composición del marco 3.2 y se reemplazó la etiqueta de proceso por criterios de reconstrucción.
- **Versión anterior:** la carpeta reunía 19 imágenes y la referencia 08 v2 concentraba por sí sola la dirección de la señal situada.
- **Motivo:** conservar una composición especialmente clara sin convertirla en un paso nuevo ni introducir lenguaje ajeno al proyecto.
- **Alcance:** la referencia orienta jerarquía, ritmo y transferencia; el contenido funcional continúa gobernado por el wireframe y la memoria.
