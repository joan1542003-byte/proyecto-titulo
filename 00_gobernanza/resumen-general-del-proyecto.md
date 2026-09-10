---
id: ESTADO-RELEVO-2026-09-09
titulo: "Resumen y estado del proyecto — Relevo"
fecha_de_corte: 2026-09-09
estado: "síntesis del estado de proyecto"
---

# ¿Para qué sirve este documento?

Este documento sirve para entender el proyecto sin tener que abrir diez carpetas. Resume qué cambió desde el examen del primer semestre, qué feedback se aplicó, qué investigamos, qué referentes tomamos, qué decisiones se han tomado y qué falta probar.

La fecha de corte es el 9 de septiembre de 2026. La memoria contiene 15.033 palabras de texto académico, excluyendo bibliografía e historial administrativo. El [control editorial](../08_memoria/auditoria-redaccion-v4-2026-08-26.md) explica el conteo; las maquetas anteriores no representan automáticamente esa versión.

## El objetivo del proyecto

Relevo busca ayudar a recuperar una intención personal cuando una sesión de ocio digital continúa y esa actividad que la persona quería realizar deja de estar presente.

La propuesta combina:

- una [aplicación Android](../06_desarrollo_y_factibilidad/decision-plataforma-android.md), donde la persona escribe su intención, define un primer paso y configura una condición;
- un [testigo físico situado](../05_propuesta_phygital/README.md), ubicado cerca del comienzo de la actividad elegida (por ejemplo, salir a caminar; el objeto se deja cerca de unas zapatillas);
- un [pulso ambiental breve](../07_validacion/protocolo-01-asociacion-y-comparacion.md), que vuelve a hacer visible esa intención en el espacio físico.

La persona sigue teniendo la última palabra: puede continuar con el ocio digital, ignorar la señal, silenciarla, cambiar de idea o iniciar la alternativa. Relevo no bloquea aplicaciones, no entrega puntos, no crea rachas y no registra si la actividad se realizó.

### ¿Por qué alguien querría usarlo?

No porque use “demasiado” el teléfono. La situación que nos interesa es más específica: alguien tiene una actividad que sí quiere hacer, sabe cómo empezar, pero durante una sesión digital esa intención deja de estar presente porque la atención se concentra en el teléfono. Esta situación aparece en las entrevistas y se interpreta junto con los referentes teóricos revisados.

### ¿Por qué podría ser deseable?

Relevo podría ser deseable porque devuelve esa posibilidad sin retar, castigar o decidir por la persona.

### ¿Por qué es relevante?

**Muchas herramientas de bienestar digital cuentan minutos, bloquean aplicaciones o interrumpen dentro de la pantalla.** Eso puede servir cuando alguien quiere limitar una conducta, pero no necesariamente ayuda a recuperar una alternativa propia. El proyecto investiga ese espacio intermedio: recordar una intención sin convertirla en obligación.

La [memoria v4](../08_memoria/memoria-vigente-v4.md), los [perfiles situacionales](../03_usuarios/perfiles-situacionales.md) y el [estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) explican esta definición con más detalle.

## Cómo llegamos hasta aquí

| Momento | Qué pasó | Por qué fue importante | Enlace |
|---|---|---|---|
| Exploraciones iniciales, incluida In(Visible) | El tema partía más amplio: ocio digital, desconexión y relación con el teléfono. | Se necesitaba pasar de un tema general a una situación concreta que se pudiera investigar. | [Matriz histórica](../01_contexto_y_fuentes/matriz-historica-encargos-memoria.md) |
| Examen/Pase del primer semestre — 20 de julio | La comisión dijo que no se entendían bien el objeto, el contexto, el usuario, la plataforma, la señal, los costos y los flujos. | El proyecto tenía una idea interesante, pero todavía no se podía explicar con claridad como experiencia completa. | [Feedback E15](../01_contexto_y_fuentes/feedback-e15.md) |
| Después del feedback | Se definieron aplicación, testigo, primer paso, lugar, señal, usuario principal y usuario límite. | El problema dejó de ser “usar mucho el celular” y pasó a ser una intención alternativa que pierde presencia. | [Matriz de incorporación del feedback](../08_memoria/matriz-incorporacion-feedback-e15.md) |
| Encargo 16 y Encargo 17 | Se separaron recorrido de usuario, flujo del sistema y flujo de diseño. Después se construyeron nueve wireframes y 35 estados complementarios. | Se hicieron visibles los estados normales, los errores, las salidas voluntarias y la relación entre app y objeto. | [Encargo 17](../05_propuesta_phygital/entrega-encargo-17.md) · [Cobertura de estados](../05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md) |
| Memoria v4 — 26 a 31 de agosto | La memoria reordenó la historia: problema, antecedentes, teoría, usuarios, referentes, criterios, formulación, propuesta, factibilidad y validación. | La solución aparece después de explicar el problema y no al revés. También se corrigieron redacción, APA 7 y trazabilidad. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) · [Revisión final](../08_memoria/revision-final-textual-2026-08-31.md) |
| Estado actual — 9 de septiembre | El wireframe v1 está congelado, sus 44 exportaciones usan la dirección cromática vigente y el programa de banco para micro:bit ya compila. | El proyecto puede iniciar la navegación Android y preparar la primera comprobación física. La instalación, el montaje cálido, la revisión electrónica y la validación continúan pendientes. | [Cierre del wireframe v1](../05_propuesta_phygital/cierre-wireframe-v1-2026-09-09.md) · [Hoja de ruta](hoja-de-ruta.md) |

## Qué feedback aplicamos

El feedback de la comisión no se pegó literalmente en la memoria. Se convirtió en decisiones, criterios, documentos y pruebas pendientes.

| Feedback | Qué cambios hice | Por qué | Enlace |
|---|---|---|---|
| “No se entiende bien qué es el objeto” | Ahora se explica el sistema completo: aplicación, testigo, lugar, condición y pulso. | Una persona debe entender la experiencia antes de entrar en la parte técnica. | [Propuesta phygital](../05_propuesta_phygital/README.md) |
| “El contexto y el usuario son muy amplios” | Se definieron un usuario principal y un usuario límite. El hogar quedó como contexto inicial de prueba, no como verdad definitiva. | La misma persona puede querer una señal en una situación y no quererla en otra. | [Perfiles](../03_usuarios/perfiles-situacionales.md) · [Recorridos](../03_usuarios/recorridos-situacionales.md) |
| “Hay que separar los flujos” | Se separaron el recorrido de la persona, el funcionamiento del sistema y el proceso de diseño. | Así se pueden detectar fallos de comprensión sin confundirlos con fallos de programación. | [Cobertura de interacciones](../05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md) |
| “Hay que justificar la luz, el sonido o la vibración” | Se seleccionaron luz y sonido para el prototipo; vibración queda como alternativa condicionada. | Todavía no sabemos qué señal se percibe bien sin volverse una alarma o una molestia. | [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| “Hay que demostrar el valor del objeto” | Se agregó una comparación entre objeto situado, objeto en un lugar neutro y notificación digital. | Permite saber si el valor está en el objeto, en el lugar o simplemente en recibir un aviso. | [Estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) · [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| “No conviertan esto en algo punitivo” | Se descartaron bloqueos, rankings, rachas, premios y evaluación de cumplimiento. | La intención es devolver una opción, no transformar la actividad en una obligación. | [Requisitos de usuarios](../03_usuarios/matriz-requisitos-de-usuarios.md) |
| “Faltan plataforma, costos y rol del diseñador” | Android quedó como plataforma inicial; se documentaron materiales, costos, producción y responsabilidades del diseño. | Acotar el desarrollo permite comprobar primero el valor de la experiencia. | [Android](../06_desarrollo_y_factibilidad/decision-plataforma-android.md) · [Factibilidad](../06_desarrollo_y_factibilidad/README.md) |
| “La memoria necesita mejor orden y redacción” | La v4 corrigió la secuencia, la ortografía, la terminología, la cronología, las citas y la relación entre capítulos. | La memoria debe poder leerse sin que el autor tenga que explicarla oralmente. | [Matriz E15](../08_memoria/matriz-incorporacion-feedback-e15.md) · [Memoria v4](../08_memoria/memoria-vigente-v4.md) |

## Qué investigamos

### Usuarios

Se hicieron [ocho entrevistas semiestructuradas](../01_contexto_y_fuentes/declaracion-procedencia-entrevistas.md), presenciales y habladas, en Santiago los días 11 y 12 de junio de 2026. Las personas observadas tenían entre 19 y 27 años; el criterio de convocatoria era de 18 a 30 años.

El [corpus anonimizado P1–P8](../03_usuarios/corpus-anonimizado.md) se codificó y se transformó en [patrones, tipos, perfiles, recorridos y requisitos](../03_usuarios/README.md). El hallazgo más importante fue que el mismo uso digital puede ser valioso en un momento e inoportuno en otro. Por eso no usamos los minutos de pantalla como medida principal.

Además, existe una [encuesta complementaria con 70 participantes](../03_usuarios/encuesta-70-participantes-pendiente.md) que está pendiente de publicarse, revisarse e integrarse al repositorio y a la memoria. Por ahora no se mezcla con P1–P8 ni se usa como evidencia: primero hay que publicar los materiales, revisar su procedencia, consentimiento, anonimización y análisis.

### Teoría

La [memoria v4](../08_memoria/memoria-vigente-v4.md) organiza la investigación teórica en tres partes:

1. **Experiencia del ocio digital:** el sentido de una actividad depende del propósito, el contexto y la autonomía, no solamente de cuánto dura.
2. **Atención y bienestar digital:** las pausas y fricciones pueden abrir una reconsideración, pero bloquear no es una solución universal.
3. **Memoria prospectiva, espacio y objetos:** una intención puede apoyarse en un recurso externo, siempre que la relación sea comprensible y el esfuerzo de configurarlo tenga sentido.

### Mercado y estado del arte

La [investigación de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) se cerró el 24 de agosto de 2026. Revisó artículos académicos, herramientas nativas, productos, sitios comerciales, fichas técnicas y patentes. El registro organiza seis familias y nueve referentes nucleares; no es una revisión sistemática ni una prueba de demanda.

La búsqueda mostró que sí existen partes de la idea, pero no se encontró en el corpus una propuesta que reuniera explícitamente todos estos elementos: intención propia, primer paso concreto, condición digital, testigo ubicado junto a ese primer paso, pulso ambiental y decisión abierta.

Eso no permite decir que Relevo sea una invención universalmente inédita. La oportunidad está en investigar esa combinación concreta y comprobar si realmente aporta algo.

### Investigación de diseño

La [síntesis aplicada del sistema visual](../01_contexto_y_fuentes/biblioteca_diseno/sintesis-aplicada-sistema-visual-relevo.md) toma cuatro referentes de diseño:

- **Norman:** ayuda a ordenar acciones, estados, retroalimentación y errores.
- **Albers:** ayuda a entender que un color cambia según el fondo, la luz y el soporte.
- **Munari:** conecta signo, forma, material, función y uso.
- **Isaacson:** sirve para pensar la integración entre producto, tecnología y experiencia.

Se usan como criterios para diseñar y revisar, no como reemplazo de las pruebas con personas.

## Referentes y estado del arte: qué parte cubre cada uno

No se tomaron los referentes solo como inspiración visual. Cada grupo responde a una parte distinta del problema o del proyecto.

| Parte del proyecto o de la problemática | Referentes | Qué nos ayudaron a entender | Cómo se refleja en Relevo | Enlace |
|---|---|---|---|---|
| **Problema base: qué significa usar el teléfono** | Lukoff et al.; Meier y Reinecke; Radtke et al. | El mismo tiempo de uso puede tener sentidos distintos. No se puede suponer que toda sesión larga sea mala. | Relevo trabaja con episodios concretos y acepta que a veces no debe intervenir. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) |
| **Continuidad y autocontrol digital** | Lyngs et al.; Biedermann et al.; Monge Roffarello y De Russis; Grüning et al.; Haliburton et al. | Las herramientas de autocontrol tienen resultados variados. Una pausa puede abrir una elección, pero no garantiza un cambio duradero. | No se promete reducir minutos ni formar hábitos; se probará una recuperación puntual de la intención. | [Antecedentes y estado de la cuestión](../08_memoria/memoria-vigente-v4.md) |
| **Memoria e intención futura** | Risko y Gilbert; Gilbert et al.; Chiu y Gilbert | Externalizar una intención puede ayudar, pero configurar el recordatorio también cuesta y puede hacer que se abandone. | El ciclo se limita a una intención, un primer paso y una configuración breve. | [Marco teórico](../08_memoria/memoria-vigente-v4.md) |
| **Espacio como apoyo para comenzar** | Kirsh | El espacio puede hacer visibles relaciones entre una intención y una acción. | El testigo se ubica cerca del lugar donde comienza el primer paso, no en cualquier parte de la casa. | [Criterios de diseño](../08_memoria/memoria-vigente-v4.md) |
| **Medición y límites dentro del teléfono** | Apple Screen Time; Bienestar Digital de Android | Dan métricas, horarios y límites, pero se enfocan en tiempo o acceso. | Relevo no usa los minutos como juicio y no bloquea el teléfono. | [Estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) |
| **Pausa y fricción en pantalla** | one sec; MindPhone; Android Pause Point | Una demora puede interrumpir la continuidad y abrir reconsideración, pero todo ocurre en la pantalla. | La notificación digital se mantiene como comparación, mientras el testigo prueba qué cambia al sacar la señal del teléfono. | [Estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) |
| **Bloqueadores y llaves físicas** | Brick Zone; Unpluq; Screenless Breaker; Shush; kSafe | Los objetos pueden introducir distancia o compromiso, pero suelen impedir el acceso. | Relevo toma la presencia física, pero descarta bloqueo, castigo y precompromiso obligatorio. | [Fichas de mercado](../04_mercado_y_referentes/fichas-mercado-2026-08-24.md) |
| **Objetos de foco y hábitos** | Focusaur; FocuShift; Jaye Band | Hay interés comercial por objetos conectados, rituales y alertas, pero suelen mezclar productividad, recompensas o hábitos. | Relevo mantiene una función más acotada: hacer disponible una intención propia. | [Estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) |
| **Recordatorios tangibles y situados** | The Tangible Reminder; Wobble; Raya; Remind Holder | Un objeto, su ubicación y una señal ambiental pueden apoyar un recordatorio. No resuelven exactamente la transición desde ocio digital. | Son el antecedente más cercano para investigar la relación entre objeto, lugar y acción. | [Estado del arte](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) |
| **Comprensión, color y materialidad** | Norman; Albers; Munari; Isaacson | La forma y la gráfica deben ayudar a entender el sistema y también considerar producción, soporte y uso. | La identidad visual se trata como sistema aplicado a Android, memoria y testigo, no como decoración aislada. | [Síntesis visual](../01_contexto_y_fuentes/biblioteca_diseno/sintesis-aplicada-sistema-visual-relevo.md) |

### Qué deja este estado del arte

El mercado ya tiene medidores, bloqueadores, pausas, objetos de foco y recordatorios situados. Lo que todavía no está resuelto es si un objeto colocado junto al primer paso de una actividad puede recuperar una intención sin bloquear, premiar ni evaluar. Esa es la pregunta que la fase de validación debe responder.

## Decisiones principales y por qué

| Decisión | Por qué se tomó | Evidencia |
|---|---|---|
| **Hacerlo phygital** | La aplicación configura el significado y el testigo lo lleva al lugar donde puede comenzar la actividad. Así se puede comprobar si lo físico aporta algo. | [Propuesta phygital](../05_propuesta_phygital/README.md) |
| **Trabajar con una situación, no con un usuario fijo** | La misma persona puede querer una señal en un momento y no quererla en otro. | [Perfiles situacionales](../03_usuarios/perfiles-situacionales.md) |
| **Un ciclo con una intención, un primer paso y un pulso** | Mantiene la experiencia entendible y evita convertir Relevo en una agenda o app general de productividad. | [Encargo 17](../05_propuesta_phygital/entrega-encargo-17.md) |
| **Android como primera plataforma** | Permite concentrar el esfuerzo en una sola arquitectura con notificación local, actividad autorizada y posible Bluetooth Low Energy. Web e iPhone quedan fuera por ahora para no duplicar el desarrollo. | [Decisión de plataforma Android](../06_desarrollo_y_factibilidad/decision-plataforma-android.md) |
| **Dejar abierta la condición de activación** | Continuidad, acumulación y horario tienen implicancias distintas de privacidad, significado y factibilidad. Primero hay que probarlas. | [Hoja de ruta](hoja-de-ruta.md) · [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| **No bloquear ni gamificar** | La propuesta busca devolver una opción, no medir rendimiento ni imponer una conducta. | [Matriz de requisitos](../03_usuarios/matriz-requisitos-de-usuarios.md) |
| **Comparar objeto situado, objeto neutro y notificación** | Es la manera más clara de separar el valor del objeto del valor de su ubicación y del aviso digital. | [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| **Diseñar con producción y costos en mente** | La forma final no puede definirse solo por apariencia; debe poder construirse, mantenerse y explicarse. | [Factibilidad](../06_desarrollo_y_factibilidad/README.md) |

El rol del diseño quedó entendido como articular problema, evidencia, experiencia, lenguaje, objeto y sistema. La electrónica, la fabricación, el mantenimiento y los costos son restricciones y colaboraciones que deben hacerse visibles; diseñar la experiencia no significa que toda la producción ya esté resuelta.

## Naming y lenguaje

**Relevo** es el nombre del sistema completo porque sugiere un cambio de turno, pero no dice que la persona tenga que abandonar el teléfono ni que obligatoriamente deba hacer otra actividad.

La arquitectura de nombres quedó así:

- **aplicación Relevo:** configura y conserva la intención;
- **testigo Relevo:** objeto que la mantiene presente sin fingir que es inteligente;
- **ciclo:** unidad de uso desde el armado hasta el cierre;
- **pulso ambiental:** manifestación física breve;
- **señal situada:** relación entre pulso, primer paso y lugar.

Se eligió **testigo** en vez de “dispositivo", “asistente” u “objeto inteligente” porque describe lo que hace sin cerrar todavía su forma ni sugerir vigilancia u obligación.

El descriptor actual para explicar el proyecto de manera directa es: **“Una señal donde quieres empezar.”** La formulación académica —sistema phygital para recuperar intenciones personales durante el ocio digital— se conserva para desarrollar su alcance, no como frase principal de presentación. Ver [comunicación, nombre y color](../10_recursos_visuales/comunicacion-naming-y-paleta-2026-09-07.md).

## Decisiones visuales y cromáticas

La dirección vigente parte de **cercanía, brevedad, traslado y autonomía**, según D-046. **Transferencia situada** conserva valor conceptual dentro del proceso anterior; su sistema gráfico no gobierna piezas nuevas.

- Android usa un **modo oscuro** para mantener continuidad y facilitar la lectura de la aplicación.
- La memoria y las piezas editoriales usan un **fondo claro y cálido** porque necesitan lectura larga, impresión, citas, tablas e imágenes.
- El ámbar **`#FFB000`** identifica provisionalmente la señal situada. El rojo anterior queda como registro del proceso y no gobierna las piezas nuevas.
- El color nunca funciona solo: los estados también deben explicarse con texto, estructura y contraste.
- IBM Plex Sans y Mono tienen usos definidos. La forma, el logotipo final, el material, el difusor y los parámetros del pulso siguen sujetos a pruebas de legibilidad, accesibilidad y convivencia.

Ver [comunicación, nombre y color](../10_recursos_visuales/comunicacion-naming-y-paleta-2026-09-07.md), [dirección visual](../10_recursos_visuales/08_direccion_visual_relevo/README.md) y [síntesis visual aplicada](../01_contexto_y_fuentes/biblioteca_diseno/sintesis-aplicada-sistema-visual-relevo.md).

## Cómo se ha implementado hasta ahora

Hasta ahora la implementación es principalmente estructural y preparatoria:

1. **Formular:** escribir una intención, un primer paso y una condición provisional.
2. **Situar:** relacionar el testigo con el lugar donde comienza la actividad.
3. **Probar y armar:** comprobar el pulso y activar el ciclo de forma explícita.
4. **Esperar y señalar:** emitir un pulso breve cuando corresponde.
5. **Decidir y cerrar:** continuar, ignorar, silenciar, iniciar, desarmar o dejar vencer el ciclo.

El [Encargo 17](../05_propuesta_phygital/entrega-encargo-17.md) convirtió este recorrido en tres interacciones y nueve marcos principales. El [anexo de cobertura](../05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md) lo amplió a 35 estados, incluyendo errores, permisos, salidas voluntarias y recuperación.

La ruta física actual separa dos propósitos. Primero se instalará en una micro:bit V2 un programa ya compilado para comprobar Android → BLE, sonido, tiempos y silencio local. Su matriz roja se usa solo en el banco sin participantes; la prueba de asociación requiere añadir una luz blanca cálida externa y difundida. Después se integrará el testigo portátil con XIAO nRF52840, batería recargable, una luz, un transductor sonoro y un control local. BleenyButton aporta un precedente abierto para estudiar batería, fijación y carcasa. Los montajes B1, B2 y 12 V se conservan como antecedentes de mesa, no como dirección principal. Todavía no se han comprado componentes, instalado el binario, construido el montaje ni ejecutado pruebas con participantes. Ver [programa micro:bit](../06_desarrollo_y_factibilidad/prueba-microbit-ble/README.md), [plataformas físicas existentes y modificables](../06_desarrollo_y_factibilidad/plataformas-existentes-modificables-2026-09-07.md), [testigo compacto](../06_desarrollo_y_factibilidad/estudio-dispositivo-compacto-luz-sonido-2026-09-07.md) y [validación](../07_validacion/README.md).

## Costos estimados

Existen precios de referencia para comparar rutas, pero todavía no hay un presupuesto completo del testigo portátil. Los valores de B1, B2 y 12 V fueron observados el 30 de agosto; los de las plataformas compactas, el 7 de septiembre de 2026. No corresponden al costo final de producción ni al precio de venta.

| Alternativa | Costo preliminar | Qué incluye / qué falta | Enlace |
|---|---:|---|---|
| micro:bit V2 | **CLP 24.990** | Plataforma disponible para una prueba rápida. Faltan acceso o préstamo, alimentación portátil y funda de ensayo; no representa el producto final. | [Plataformas existentes](../06_desarrollo_y_factibilidad/plataformas-existentes-modificables-2026-09-07.md) |
| XIAO nRF52840 | **CLP 16.590 solo la placa** | Ruta de integración vigente. Faltan batería, luz, transductor, control, conexiones, carcasa, difusión, envío y revisión. | [Testigo compacto](../06_desarrollo_y_factibilidad/estudio-dispositivo-compacto-luz-sonido-2026-09-07.md) |
| Montaje provisional de 12 V | **CLP 28.130** | Referencia parcial. Excluye terminales y protección de potencia; queda como respaldo. | [Alternativas físicas](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/alternativas-arquitectura-fisica.md) |
| B1: XIAO + anillo 5 V | **CLP 22.383 + conversor lógico** sin base; **CLP 28.073 + conversor lógico** con base comparable | Faltan conversor lógico, conductores internos, cuerpo, difusor, envío y revisión. | [Lista B1](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/lista-materiales-b1-b2.md) |
| B2: XIAO + luz cálida 5 V | **CLP 23.591 + resistencia de estado y conductores** sin base; **CLP 29.281 + esas partidas** con base comparable | Faltan resistencia de estado, conductores, cuerpo, difusor, envío y revisión. | [Lista B2](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/lista-materiales-b1-b2.md) |
| Núcleo común B1/B2 | **CLP 17.126** comprando todo; **CLP 10.440** reutilizando fuente, jack y cable USB-C | Incluye XIAO, pulsador, cable, interruptor, borneras, fuente, jack y cable de programación. Hay que confirmar qué piezas existen. | [Costos comunes](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/lista-materiales-b1-b2.md) |

La conclusión económica por ahora es simple: **no se puede declarar todavía un ahorro ni un costo cerrado**. La micro:bit reduce trabajo de la primera prueba, pero no sustituye el prototipo integrado. La XIAO reduce tamaño y componentes, aunque su subtotal sigue incompleto. Ninguna compra debe decidirse solo por el precio de la placa.

## Qué ya está listo y qué falta

| Ya está hecho | Falta hacer | Evidencia |
|---|---|---|
| Problema acotado, usuario principal y usuario límite. | Observar el uso en espacios reales y confirmar el contexto doméstico. | [Usuarios](../03_usuarios/README.md) |
| Entrevistas analizadas, perfiles, recorridos y requisitos. | Ejecutar una nueva prueba con participantes; todavía no hay resultados. | [Matriz de evidencia](../03_usuarios/matriz-evidencia-p1-p8.md) |
| Encuesta complementaria de 70 participantes registrada como fuente pendiente. | Publicar sus materiales, revisar la metodología y decidir si complementa o modifica la memoria. | [Ficha de seguimiento](../03_usuarios/encuesta-70-participantes-pendiente.md) |
| Marco teórico, referentes y mercado organizados. | Hacer solo una vigilancia breve si aparece información nueva relevante. | [Mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) |
| Aplicación, testigo, lugar, señal y flujos definidos como hipótesis. | Comprobar si el objeto aporta más que una notificación. | [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| Wireframes: nueve marcos principales y 35 estados complementarios. | Implementar Android, permisos, segundo plano, vínculo y recuperación. | [Encargo 17](../05_propuesta_phygital/entrega-encargo-17.md) |
| Nombre de trabajo, descriptor, tipografías y paleta seleccionados. | Probar comprensión y legibilidad; cerrar forma, material, difusor y parámetros de la señal. | [Comunicación, nombre y color](../10_recursos_visuales/comunicacion-naming-y-paleta-2026-09-07.md) |
| Plataformas comparadas y programa micro:bit compilado; B1/B2 conservadas como antecedentes. | Conseguir la placa, instalar y medir el banco, revisar la luz cálida externa y completar la lista XIAO solo si la evidencia justifica continuar. | [Programa micro:bit](../06_desarrollo_y_factibilidad/prueba-microbit-ble/README.md) · [Factibilidad](../06_desarrollo_y_factibilidad/README.md) |
| Memoria v4 ordenada y auditada. | Incorporar los resultados reales y preparar la presentación oral. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) |

## Próximos pasos e hitos

El [plan de cierre](plan-de-cierre-agosto-diciembre-2026.md) conserva el calendario completo y la [Issue #9](https://github.com/joan1542003-byte/proyecto-titulo/issues/9) registra su avance. Esta síntesis distingue fechas internas de compromisos institucionales.

| Hito | Estado o condición |
| --- | --- |
| Hasta el 12 de septiembre | Wireframe v1 cerrado el día 9. Falta ejecutar el banco micro:bit o registrar su bloqueo de acceso. |
| 19 y 29 de septiembre | App base y señal manual; después, prueba interna y preparación de la corrección cruzada. |
| 30 de septiembre | Corrección cruzada oficial. |
| 7 y 17 de octubre | Cierre del piloto técnico; prueba con usuarios solo si se cumplen las puertas del protocolo. |
| 19–23 de octubre | Semana oficial de Pruebas Solemnes. |
| 31 de octubre y 8 de noviembre | Integración prácticamente terminada; después, validación acotada y congelamiento. |
| 15 de noviembre | Cierre interno de producto, evidencia, memoria y entrega. |
| 25 de noviembre y 2 de diciembre | Pase de Examen y entrega oficial de memoria, respectivamente. |
| 14–18 de diciembre | Periodo oficial de exámenes de Proyecto de Título. |

La encuesta complementaria mantiene una fecha estimada y condicionada en su [ficha de seguimiento](../03_usuarios/encuesta-70-participantes-pendiente.md); no bloquea el uso del corpus P1–P8 ni aporta resultados antes de su revisión. Las fechas oficiales se respaldan en el [calendario institucional](calendario-oficial-segundo-semestre-2026.md).

## Cierre

Desde el examen, Relevo pasó de ser una idea difícil de leer a tener un problema acotado, usuarios situacionales, investigación trazable, estado del arte, propuesta phygital, flujos separados, naming, sistema visual, costos preliminares y un plan de validación.

La pregunta que queda es la más importante: **¿el testigo físico situado recupera una intención de una manera más clara o pertinente que una notificación digital, sin aumentar demasiado la carga, la intrusión o los problemas de accesibilidad?**

Eso todavía no lo puede responder la memoria ni el wireframe. Lo tienen que responder el prototipo y las pruebas.

## Documentos principales

- [README del repositorio](../README.md).
- [Memoria vigente v4](../08_memoria/memoria-vigente-v4.md).
- [Resumen vigente del proyecto](../08_memoria/resumen-vigente-proyecto.md).
- [Feedback original de la comisión](../01_contexto_y_fuentes/feedback-e15.md).
- [Matriz de incorporación del feedback](../08_memoria/matriz-incorporacion-feedback-e15.md).
- [Matriz histórica del Pase y la memoria](../01_contexto_y_fuentes/matriz-historica-encargos-memoria.md).
- [Investigación de usuarios](../03_usuarios/README.md).
- [Estado del arte y mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md).
- [Propuesta phygital y wireframes](../05_propuesta_phygital/README.md).
- [Factibilidad, materiales y costos](../06_desarrollo_y_factibilidad/README.md).
- [Protocolo de validación](../07_validacion/README.md).
- [Plan de cierre](plan-de-cierre-agosto-diciembre-2026.md).

---

## Respuestas completas al feedback del 2 de septiembre

La [matriz de 23 preguntas](../01_contexto_y_fuentes/feedback-2026-09-02.md) conduce a respuestas por área: comunicación y primer paso; estado y viaje del usuario; forma y ubicación; localizador UGREEN; encontrabilidad y paleta; luz, sonido y vibración; prototipos, materiales y valor. La documentación está resuelta; las hipótesis empíricas siguen abiertas. La aclaración de UGREEN permite estudiarlo como referente compacto sin asumir un modelo o plataforma de control. El siguiente ensayo sigue en la Issue #11.

## Registro de cambios (disclaimer)


### 2026-09-09 — Limpieza y vigencia documental

- **Cambio:** se actualizó el estado de la memoria, se corrigieron fuentes rectoras y se condensó el calendario en hitos.
- **Antes:** el resumen repetía extensamente el plan, remitía a entregas anteriores y trataba algunas selecciones como pendientes.
- **Motivo:** reducir redundancia y conservar una síntesis que pueda leerse sin reconstruir el historial.
- **Alcance:** Revisión documental; no añade resultados ni modifica el protocolo o los artefactos.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se incorporó el acceso a todas las preguntas y se separó cierre documental de validación. Se sincronizaron alcance de señal, autoridad visual y planificación histórica.
- **Versión anterior:** había respuestas dispersas, índices incompletos o formulaciones sustituidas.
- **Motivo:** mantener una respuesta localizable y coherente con las decisiones vigentes.
- **Alcance:** actualización documental; no se añaden resultados ni se cambian los parámetros del protocolo.

### 2026-09-09 — Wireframe v1 como base de desarrollo

- **Cambio:** se actualizó la fecha de corte y el estado del proyecto después del cierre estructural y cromático del wireframe.
- **Cómo estaba antes:** el resumen situaba al proyecto todavía cerrando esa versión.
- **Por qué se decidió:** mantener el resumen sincronizado con el hito verificable más reciente.
- **Alcance:** no se agregan resultados técnicos ni con participantes.

### 2026-09-08 — Banco micro:bit preparado

- **Cambio:** el resumen registra el programa compilado, la diferencia entre matriz roja y luz cálida y el nuevo bloqueo operativo de instalación y medición.
- **Cambio documental:** la fecha de corte, el identificador y la fila de estado se actualizaron al 8 de septiembre.
- **Versión anterior:** señalaba que todavía faltaba compilar firmware y presentaba la plataforma existente como un solo material de prueba.
- **Motivo:** comunicar con precisión qué está listo y evitar que una salida roja se utilice con participantes por conveniencia.
- **Alcance:** no hay placa, montaje, instalación, ficha ni resultados; la integración XIAO sigue condicionada a evidencia posterior.

### 2026-09-07 — Sincronización física y comunicacional

- **Cambio:** se actualizaron descriptor, color de señal, ruta técnica y costos de referencia conforme a D-045, D-046 y D-047.
- **Versión anterior:** el resumen todavía presentaba el descriptor técnico como frase principal, el rojo como color vigente y B1/B2 como ruta física activa.
- **Motivo:** evitar que la síntesis ejecutiva contradiga las decisiones actuales del repositorio.
- **Alcance:** no se incorporan resultados ni se declara una forma, un costo o una ventaja validados; la prueba y la integración continúan pendientes.

### 2026-09-07 — Actualización del estado operativo

- **Cambio:** se actualizó la fecha de corte y el proyecto pasó de una revisión general de wireframes al cierre del wireframe v1, con alcance inicial y backlog documentados.
- **Versión anterior:** el estado permanecía fechado el 2 de septiembre y no registraba la verificación de 44 exportaciones ni la deuda técnica paralela.
- **Motivo:** permitir que una lectura ejecutiva distinga los avances comprobados de la revisión electrónica y la validación todavía pendientes.
- **Alcance:** no modifica la formulación de Relevo ni añade resultados empíricos.

### 2026-09-02 — Calendario de cierre reordenado

- **Cambio:** se actualizó la tabla de próximos pasos para comenzar con la revisión de wireframes, seguir con MVP y wireframe v1, construir la app y la señal manual, probar internamente, probar con usuarios e integrar después.
- **Motivo:** hacer que las fechas representen dependencias reales y no presentar pruebas o decisiones técnicas como si ya estuvieran ejecutadas.
- **Alcance:** se conservaron los cambios recientes del resumen, la encuesta de 70 participantes como pendiente y los hitos oficiales del semestre.

### 2026-09-02 — Encuesta de 70 participantes registrada

- **Cambio:** se añadió al apartado de usuarios la existencia de una encuesta con 70 participantes y se enlazó su ficha de seguimiento.
- **Motivo:** dejar visible una fuente potencial que todavía debe publicarse y revisarse antes de entrar en la memoria como evidencia.
- **Alcance:** no se incorporaron resultados ni se mezcló la encuesta con las ocho entrevistas P1–P8.

### 2026-09-02 — Tono, enlaces y categorías ampliadas

- **Cambio:** se reescribió el resumen en un tono más natural y directo, se incorporaron referentes, estado del arte e investigación de mercado organizados por parte del problema, y se reforzaron los enlaces de evidencia.
- **Cambio adicional:** se mantuvieron los costos de 12 V, B1, B2 y núcleo común, junto con el registro de avances y la tabla de fechas estimadas.
- **Motivo:** facilitar una lectura rápida del proyecto sin perder el porqué de las decisiones ni la trazabilidad documental.
- **Alcance:** no se agregan resultados de validación, no se presenta una forma física como definitiva y los costos continúan siendo preliminares.

### 2026-09-02 — Creación del resumen general

- **Cambio:** se creó una síntesis ejecutiva de la evolución desde el examen del primer semestre hasta la memoria v4.
- **Motivo:** reunir en un solo documento el feedback, la investigación, las decisiones, la implementación y los próximos pasos.
- **Alcance:** este documento no reemplaza la memoria ni agrega evidencia nueva.

### 2026-09-02 — Corrección de enlaces y redacción de entrada

- **Qué cambió:** se corrigieron erratas de lectura y se actualizaron los enlaces de naming y códigos cromáticos para dirigir a la entrega fechada vigente, no al paquete histórico del 1 de septiembre.
- **Cómo estaba antes:** el resumen mezclaba un enlace histórico con la fuente vigente y contenía formulaciones y signos de interrogación incompletos.
- **Por qué se decidió:** asegurar que una lectura rápida del proyecto conduzca a los documentos actuales y no introduzca ruido en su comprensión.
- **Alcance:** no se modificó la formulación del proyecto, la evidencia ni las decisiones de diseño.
