# Manual del sistema visual de Relevo

## Propósito

Este manual reúne las reglas visuales y semánticas que deben orientar el desarrollo de Relevo. Su función es permitir que otra persona reconstruya el sistema, comprenda por qué existe cada regla y sepa cuándo una decisión todavía necesita pruebas.

Relevo es un sistema phygital. La aplicación Android organiza una intención, un primer paso, una condición, una vigencia, un lugar y un testigo. El testigo emite una señal situada en el entorno. La persona decide qué hacer después. La interfaz no califica la actividad, no bloquea el teléfono y no convierte la señal en una orden.

La dirección vigente es `Transferencia situada`. El término describe el paso de una intención registrada hacia una señal relacionada con el lugar donde puede comenzar una actividad. No significa avance, porcentaje, cumplimiento ni cuenta regresiva.

## Estado de madurez

Este documento es un contrato de trabajo v4, no una declaración de diseño terminado. Las pantallas oscuras y el lenguaje visual están suficientemente definidos para reconstrucción y auditoría; la forma industrial, el material, el mecanismo, el canal de señal, la condición técnica y la percepción situada continúan abiertos.

La documentación se interpreta así:

- **Vigente:** regla que gobierna nuevas piezas hasta que una prueba o una decisión registrada la reemplace.
- **Hipótesis:** propuesta razonable que debe comprobarse antes de cerrarse.
- **Por validar:** dato o comportamiento que no puede afirmarse con la evidencia disponible.
- **Histórico:** exploración conservada para comprender el proceso, pero no aplicable a nuevas piezas.

Las exploraciones claras de v3 y las dos pantallas claras de Android v4 son históricas. No constituyen un segundo tema activo. La dirección digital nueva se desarrolla en oscuro; el papel editorial se trata como soporte material y se adapta para legibilidad, no como una interfaz clara paralela.

## Concepto rector y arquitectura del sistema

La gramática común tiene tres relaciones:

1. **Origen:** la intención y el primer paso formulados por la persona.
2. **Vínculo:** la relación explícita entre intención, condición, lugar y testigo.
3. **Señal situada:** el momento en que el testigo emite una señal en el lugar elegido.

Esta gramática no se dibuja siempre del mismo modo. En Android organiza decisiones y estados; en el editorial explica relaciones y evidencia; en el objeto se investiga como una relación entre presencia, lugar y señal. La coherencia se obtiene por significado, ritmo, contraste y reglas, no por repetir una pantalla en todos los medios.

### Principios rectores

| Principio | Qué resuelve | Fuente o hallazgo | Qué no demuestra | Cómo se valida | Soporte |
|---|---|---|---|---|---|
| La aplicación organiza y confirma | Evita que el teléfono se convierta en el lugar de la señal | Memoria v4, D-023, D-032 y D-037 | No demuestra que el reparto de funciones sea comprendido | Recorrido Android–testigo y prueba comparativa | Android / objeto |
| La persona conserva la salida | Evita bloqueo, culpa, rearme y evaluación | Entrevistas, memoria v4 y wireframes | No demuestra que una salida sea visible o suficiente | Prueba de tareas y clasificación de acciones | Android |
| La señal se sitúa en un contexto | Evita reducir el problema a tiempo de pantalla | Memoria v4, estado del arte y D-030 | No demuestra que el lugar ayude a iniciar | Prueba de percepción, asociación y convivencia | Objeto / editorial |
| El color tiene un rol, no solo un valor | Evita que el rojo se convierta en alarma o estado técnico | Albers (2013), contrato oscuro y D-036 | No garantiza contraste ni interpretación | Prueba contextual, escala de grises y contraste | Todos |
| Los puntos comunican solo cuando tienen relación | Evita textura, progreso y selección ambiguos | Albers (2013), Munari (1971), contrato oscuro | No demuestra que la relación sea reconocible | Retiro del gráfico y prueba de comprensión | Todos |
| La jerarquía precede a la identidad | Evita que la estética opaque una tarea | Norman (2002), wireframes y entrevistas | No garantiza una navegación sin errores | Recorrido cognitivo y prueba de tarea | Android / editorial |
| La forma se mantiene abierta hasta probarla | Evita convertir una imagen en especificación industrial | Munari (1971), D-023, D-036 y D-037 | No retrasa indefinidamente el desarrollo: define qué debe medirse | Comparación de familias, materialidad y producción | Objeto |
| La integración no es repetición | Evita trasladar la interfaz al objeto o la gráfica a la app | Isaacson (2011) como caso histórico, D-037 | No demuestra que un lenguaje común funcione por sí solo | Auditoría entre soportes y prueba del sistema completo | Todos |

## Identidad verbal y visual

### Nombre y alfabeto de puntos

`RELEVO` es la marca de trabajo. El alfabeto de puntos es un recurso identitario breve: puede aparecer en la marca, numerales grandes o una expresión corta de señal. No compone instrucciones, párrafos, permisos, botones, mensajes de error ni citas académicas.

Una unidad puntual debe construirse desde una retícula común, con separación suficiente para no confundirse con texto continuo. El alfabeto definitivo es una hipótesis: antes de cerrarlo se debe comprobar lectura, autoría, reproducción a diferentes tamaños y diferenciación frente a otros lenguajes modulares. No se debe usar una matriz como logotipo simplemente porque sea reconocible en una referencia.

### Voz

El tono es directo, respetuoso, situado y no moralizante. Describe lo que el sistema sabe, lo que no sabe y qué puede hacer la persona. Evita prometer control, transformación personal o éxito.

| Preferir | Evitar |
|---|---|
| `Define una intención` | `Sé más disciplinado` |
| `Elige un primer paso` | `No pierdas el tiempo` |
| `La señal se emitió en el testigo` | `Lo hiciste bien` |
| `Puedes ignorarla, silenciarla o cerrar el ciclo` | `Debes comenzar ahora` |
| `No pudimos confirmar el vínculo` | `Fallaste` |

## Color

El sistema v4 utiliza una paleta oscura y plana. El color se define por función semántica, no por decoración. Los valores técnicos aparecen también en `tokens-y-especificaciones.md`; si ambos documentos difieren, el registro de decisiones debe resolver la discrepancia antes de producir.

| Rol | Valor vigente | Función | Restricción |
|---|---|---|---|
| Canvas | `#111314` | Fondo general | No añadir textura, ruido ni degradado que altere la lectura |
| Superficie | `#1B1D1E` | Agrupación funcional puntual | No usarla como tarjeta automática para cada dato |
| Superficie quieta | `#242728` | Estado secundario no interactivo | No debe parecer elección ni botón |
| Texto principal | `#F1F1F1` | Contenido, títulos y acciones | Revisar contraste en cada tamaño |
| Texto secundario | `#B6B8B7` | Ayuda, metadatos y estados secundarios | No usarlo para información crítica si pierde contraste |
| Regla | `#3A3D3E` | Separación no informativa | No comunicar selección, error o foco |
| Borde funcional | `#767A79` | Campo, foco y control delineado | Debe distinguirse también por forma y texto |
| Señal situada | `#EF3E45` | Único nodo de señal situada | No usar en acciones, errores, batería, vínculo, selección o decoración |

El rojo solo aparece cuando la señal situada es el contenido semántico de la pantalla o de la pieza. Antes de situar la intención se omite. Si una pieza requiere rojo por otra razón, se considera una contradicción y no se aprueba hasta resolverla. La comprensión debe mantenerse en escala de grises y mediante texto o estructura equivalente.

Albers (2013) permite entender por qué el mismo valor puede cambiar de apariencia según fondo, tamaño, proporción, luz y soporte. No convierte estos hexadecimales en una paleta universal ni certifica accesibilidad. Cada combinación debe probarse en Android, impresión y contexto físico.

## Tipografía

- **IBM Plex Sans:** lectura, contenido, instrucciones, navegación y acciones.
- **IBM Plex Mono:** metadatos, folios, códigos, medidas y estados técnicos breves.
- **Alfabeto de puntos:** marca y expresiones breves no esenciales.

La tipografía de lectura tiene prioridad sobre el carácter expresivo. Los tamaños iniciales para Android son 32/40 sp para título principal, 24/32 sp para título de pantalla, 20/28 sp para sección, 16/24 sp para cuerpo, 14/20 sp para contenido secundario y 12/16 sp para etiqueta. Son valores de trabajo: deben comprobarse con texto real, español, texto ampliado y lector de pantalla.

En la memoria y las piezas editoriales, el cuerpo debe conservar una medida cómoda, pies de figura legibles y referencias compatibles con APA 7. La identidad no justifica reducir el texto académico ni componer citas con puntos.

## Retícula, escala y composición

La unidad digital base es 8 dp, con submúltiplos de 4 dp para ajustes menores. El margen lateral Android parte en 24 dp y cada control interactivo debe ofrecer un objetivo mínimo de 48 × 48 dp. Estas medidas son requisitos técnicos de trabajo, no garantía de comprensión.

La composición debe seguir este orden: contexto breve, contenido principal, elección o estado, acción principal y salidas secundarias. Una pantalla no debe presentar una colección de módulos solo para demostrar variedad. El vacío sirve para separar relaciones y dar tiempo de lectura; no debe ocultar la acción principal.

En editorial, la retícula puede ampliarse a doce columnas para combinar texto, evidencia, figuras, tablas y diagramas. La matriz no debe imponerse sobre el cuerpo académico. En el objeto, la retícula es una herramienta de investigación para comparar familias y no una instrucción de fabricación.

## Formas, bordes y radios

Las formas redondeadas tienen función. Un radio de 8 dp puede delimitar un campo; 16 dp puede agrupar una superficie; un radio mayor solo se permite si una prueba muestra que mejora la lectura o la interacción. No se usan cápsulas como estructura universal.

Las reglas y los espacios separan información relacionada. Las superficies se reservan para agrupaciones funcionales. No se colocan círculos, bordes o rellenos detrás de elementos decorativos si pueden parecer controles. Las sombras, el vidrio, el ruido y los degradados no forman parte del contrato vigente.

## Iconografía

Los iconos son signos convencionales, no ilustraciones abstractas. Se usan pocos y se acompañan con texto cuando el significado no sea inmediato. Todo icono interactivo necesita etiqueta accesible, foco visible y objetivo táctil suficiente. Un símbolo de marca o una matriz no puede operar como control esencial.

Los iconos de retorno, cerrar, editar, silenciar, batería, vínculo y permisos deben mantener significado estable. No se inventa un símbolo para reemplazar una palabra que ya puede decirse con claridad. Un icono meramente informativo puede eliminarse si el texto explica mejor el estado.

## Gráficos informativos y puntos

Un gráfico informativo comunica una relación que no queda completa en una frase aislada. En Relevo, un gráfico puede mostrar origen, vínculo y señal situada, pero debe incluir una leyenda o texto equivalente. Los puntos no pueden parecer opción, botón, paginación, progreso, cuenta regresiva o estado seleccionado.

La prueba mínima consiste en retirar los puntos: si se pierde una relación necesaria, el gráfico necesita texto equivalente; si no se pierde comprensión, los puntos son decoración y deben reducirse o eliminarse. Esta regla se aplica a Android, editorial y documentación de objeto.

## Fotografía e imagen

La fotografía documenta materialidad, escala, luz, distancia, instalación o prueba. No debe funcionar como fondo de la app ni presentar una familia de objeto como producto elegido. Cada fotografía necesita procedencia, fecha cuando sea relevante, descripción de lo que demuestra y límite de interpretación.

Las imágenes generadas o exploratorias no son evidencia de comportamiento. Antes de incorporarlas a la memoria, deben reemplazarse por registros propios o identificarse como exploración. Munari (1971) respalda relacionar forma, material, transporte, montaje y uso; no autoriza escoger una carcasa a partir de una imagen atractiva.

## Movimiento

El movimiento explica un cambio de estado, no celebra una conducta. Debe ser breve, reversible y detenerse cuando la persona lo solicite. No se usan bucles permanentes, destellos rápidos, contadores, confeti ni pulsos gráficos que simulen la señal física.

La aplicación respeta la preferencia de reducción de movimiento. La duración exacta de las transiciones es una hipótesis de implementación y se valida con prototipo; el límite de destellos debe revisarse según WCAG 2.2. El pulso del testigo se prueba como fenómeno físico, no se deduce de una animación de pantalla.

## Accesibilidad

El sistema debe considerar contraste, texto ampliado, lectura lineal, orden de foco, etiquetas accesibles, redundancia de estados, reducción de movimiento y condiciones físicas de percepción. La información no puede depender solo del rojo, de la forma, del sonido o de la posición.

Como criterios mínimos de trabajo se adoptan 4,5:1 para texto pequeño, 3:1 para texto grande y 3:1 para elementos no textuales relevantes, junto con objetivos táctiles de 48 × 48 dp y conservación del contenido al ampliar texto hasta 200 %. Estos criterios deben auditarse en la implementación y contrastarse con las pautas vigentes, no solo con una imagen rasterizada.

## Traducción por soporte

| Soporte | Hace | Comparte | No debe hacer |
|---|---|---|---|
| Android | Configura, confirma, informa estados y permite recuperar | Origen, vínculo, señal situada, ritmo y roles cromáticos | Medir cumplimiento, bloquear, simular el pulso o convertir cada dato en tarjeta |
| Editorial | Explica problema, evidencia, decisiones, relaciones y pruebas | Tipografía, contraste, puntos con leyenda y secuencia | Presentar exploraciones como resultados o usar una gráfica sin fuente |
| Objeto físico | Hace perceptible una señal situada en un lugar significativo | Relación con intención, primer paso y lugar | Repetir la interfaz, revelar innecesariamente la intención o fijar forma sin pruebas |

La integración phygital se evalúa por la continuidad de la experiencia, no por la semejanza literal. Una interfaz trasladada al objeto es un uso incorrecto; una gráfica editorial trasladada sin adaptación a Android también lo es.

## Usos correctos e incorrectos

| Correcto | Incorrecto |
|---|---|
| Texto continuo para instrucciones y contenido | Texto de puntos para un botón o párrafo |
| Rojo solo en el nodo de señal situada | Rojo en error, batería, selección o acción primaria |
| Estado técnico con texto y estructura | Estado comunicado solo con un punto o color |
| Resumen separado por reglas y ritmo | Tarjeta gigante para cada dato |
| Acción verbal con foco y salida | Estado presentado como control |
| Gráfico de relación con leyenda | Puntos que parecen progreso o paginación |
| Fotografía con procedencia y pie | Imagen generada presentada como evidencia |
| Objeto investigado por familias y pruebas | Una silueta tratada como forma industrial final |

## Gobernanza del sistema

Una nueva regla se registra antes de aplicarse a más de una pieza. El registro debe incluir: identificador, fecha, decisión, soporte, problema que resuelve, fuente o hallazgo, estado de madurez, límite, prueba, resultado y consecuencia. Las imágenes no pueden reemplazar esta trazabilidad.

El orden de autoridad es: memoria y decisiones vigentes del proyecto; requisitos del Encargo 17 cuando correspondan al flujo; estándares y guías profesionales; fundamentos de la biblioteca; hipótesis visuales; preferencias formales. Si una imagen contradice una regla escrita, prevalece la regla hasta registrar una revisión.

El sistema pasa de hipótesis a vigente solo cuando existe una prueba pertinente, un registro reproducible y una consecuencia explícita. Un resultado visual atractivo no constituye validación. La revisión debe producir una nueva decisión o mantener la anterior con evidencia.

## Referencias

Albers, J. (2013). *Interaction of color* (4th ed.). Yale University Press.

Isaacson, W. (2011). *Steve Jobs* (D. González-Iglesias González, Trad.). [Editorial y edición en español por confirmar].

Munari, B. (1971). *Design as art* (P. Creagh, Trad.). Penguin Books. (Trabajo original publicado en 1966).

Norman, D. A. (2002). *The design of everyday things*. Basic Books.

Google. (2023). *Accessibility*. Android Developers. https://developer.android.com/design/ui/mobile/guides/foundations/accessibility

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación del manual integral v4

- **Cambio:** se creó un manual central con concepto rector, arquitectura, semántica, color, tipografía, retícula, formas, iconografía, gráficos, imagen, movimiento, accesibilidad, microcopy, traducción por soporte, usos incorrectos y gobernanza.
- **Situación anterior:** v4 tenía un contrato oscuro y reglas distribuidas entre inventarios, aplicaciones y documentos de v3, pero no un manual único que explicara la relación entre decisiones, límites y validación.
- **Motivo:** permitir reconstrucción y auditoría coherentes sin convertir exploraciones visuales en una identidad cerrada ni fijar la forma del objeto.
- **Decisión de continuidad:** v3 queda como antecedente histórico; este manual gobierna nuevas piezas v4 hasta que el registro de decisiones documente una sustitución.
- **Asuntos abiertos:** validar tipografía, color en contexto, iconografía, movimiento, comprensión entre soportes y todas las decisiones materiales y técnicas del testigo.

### 2026-08-29 — Verificación de la referencia de accesibilidad

- **Cambio:** se corrigió el año de la guía de accesibilidad de Android según la fecha publicada en la fuente oficial.
- **Situación anterior:** la referencia usaba 2026 como año de publicación.
- **Motivo:** mantener APA 7 trazable y distinguir la fecha de consulta de la fecha editorial.
