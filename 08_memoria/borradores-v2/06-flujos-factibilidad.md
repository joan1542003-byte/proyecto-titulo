---
id: MEM-V2-06
titulo: "Arquitectura de experiencia, flujos, factibilidad y modelo de gestión"
proyecto: "Relevo"
tipo: "Memoria de Proyecto de Título — Diseño"
estado: "redacción académica para integración"
fecha: 2026-08-24
alcance: "Capítulos 11 y 12"
restricciones: "Sistema phygital; testigo físico sin pantalla; Android y BLE como hipótesis técnicas."
---

# 11. Arquitectura de experiencia y flujos

La arquitectura de experiencia convierte la propuesta en una secuencia de condiciones, estados y decisiones observables. No describe un desempeño alcanzado: organiza qué debe ocurrir para que una prueba sea posible y qué debe suceder cuando una parte no responde. Relevo continúa siendo un sistema phygital compuesto por aplicación Android, regla local, testigo físico sin pantalla, lugar seleccionado manualmente y persona decisora. El objeto no incorpora pantalla ni texto.

En este capítulo, una **precondición** es aquello que debe cumplirse antes de pasar a un estado; un **estado** es una situación reconocible del sistema, como configurado, armado o en reposo; y una **puerta** es un criterio que debe revisarse antes de avanzar a la siguiente etapa de desarrollo. El término **Bluetooth Low Energy (BLE)** designa el protocolo de comunicación inalámbrica de bajo consumo propuesto para transportar patrones y estados técnicos entre la aplicación y el testigo. Un **acuse** es la confirmación técnica de que el objeto recibió un comando. El **vencimiento** es el límite temporal después del cual ese comando deja de ser válido y debe descartarse.

La arquitectura debe mantener separadas tres preguntas. La primera es experiencial: si la persona comprende la relación entre intención, primer paso, lugar y señal. La segunda es funcional: si la secuencia permite configurar, situar, armar, señalar, silenciar y volver a reposo sin evaluar la conducta. La tercera es técnica: si Android, el enlace BLE, la energía y el testigo pueden ejecutar una regla observable dentro de los límites del prototipo. Una falla en una pregunta no demuestra automáticamente una falla en las otras.

## 11.1 Arquitectura mínima y arquitectura aspiracional

La **arquitectura mínima de prototipo** es la cantidad menor de capas que permite investigar el valor de una asociación física sin atribuir capacidades inexistentes al sistema. En su primer nivel, la aplicación conserva una intención y un primer paso; la persona sitúa el testigo sin pantalla; la señal se activa de manera simulada o mediante un control de prueba; y se registra qué recuerda, qué atribuye y qué decide. Este nivel no valida Android, BLE, batería ni activación automática.

En un segundo nivel, la arquitectura mínima de integración incorpora una aplicación Android, una única aplicación seleccionada, una condición observable todavía pendiente de elección, una ventana armada, un comando con identificador y vencimiento, un testigo sin pantalla y una señal única. La persona prueba el lugar y arma explícitamente. Si el enlace no entrega el comando dentro de su vigencia, el evento se descarta y se informa como fallo técnico. El sistema no reproduce una señal tarde ni interpreta que la persona actuó mal.

La **arquitectura aspiracional** corresponde a un sistema que podría consultar uso de aplicaciones con la API UsageStatsManager, funcionar con la aplicación en segundo plano, mantener una conexión BLE, informar batería y recuperar estados en distintos teléfonos y fabricantes. UsageStatsManager es una interfaz de Android que expone información de uso de aplicaciones bajo un permiso especial; no es un detector de automatismo ni garantiza por sí misma una activación inmediata (Google, s. f.-c). La ejecución BLE en segundo plano depende de versión, configuración de energía y fabricante (Google, s. f.-a, s. f.-b). Por ello, esta arquitectura se mantiene como hipótesis técnica y no como desempeño del producto.

| Nivel | Capas presentes | Pregunta que permite investigar | Lo que todavía no demuestra |
| --- | --- | --- | --- |
| Prototipo P0 | Persona, intención, primer paso, lugar manual, carcasa o testigo simulado y señal activada por el investigador | ¿La persona puede asociar una señal sin texto con una intención situada? | Automatización, enlace, batería, producción o adopción |
| Prototipo P1 | Testigo físico sin pantalla, señal autónoma acotada y control de silencio | ¿La señal se percibe, se atribuye y puede detenerse sin reproche? | Que Android active en el momento adecuado |
| Integración P2/P3 | Android, regla observable, BLE, ventana, comando con vencimiento y recuperación técnica | ¿Puede entregarse un evento técnico dentro de una condición definida? | Compatibilidad universal, autonomía final o valor físico sostenido |
| Arquitectura aspiracional | Uso en segundo plano, consulta de estadísticas, varios teléfonos, mantenimiento y producción | ¿Qué debería resolverse para escalar la experiencia? | Que la arquitectura sea viable sin pruebas, proveedores o certificación |

La distinción evita que una maqueta de señal se presente como producto integrado o que una posibilidad de plataforma se lea como detección psicológica. El paso entre niveles debe producir una pregunta nueva y no solo más componentes.

## 11.2 Precondiciones, estados y puertas de experiencia

Antes de armar una regla deben existir una intención alternativa y un primer paso concreto; una aplicación seleccionada; una condición expresada en términos observables; una ventana; un testigo vinculado; un estado de batería suficiente para la prueba; un lugar elegido; una señal perceptible para la persona; y una explicación comprensible de los permisos y límites. La falta de cualquiera de estos elementos no debe traducirse en una señal inesperada.

La siguiente matriz define los estados principales. «Listo» no significa que el sistema haya sido validado: significa que las precondiciones conocidas se encuentran disponibles para la prueba.

| Estado | Precondición de entrada | Operación | Salida válida | Puerta o fallo asociado |
| --- | --- | --- | --- | --- |
| No configurado | Falta intención, primer paso, permiso o condición | Mostrar el elemento faltante y permitir cancelar | Configuración incompleta explícita | No iniciar una señal |
| Configurado | Intención, primer paso, aplicación y ventana registrados | Guardar la regla localmente | Regla preparada, aún desarmada | Revisar claridad y carga de configuración |
| Vinculando | Se solicita asociación con el testigo | Emparejar y registrar el vínculo técnico | Testigo reconocido | Reintentar sin crear vínculos duplicados |
| Probando lugar | Testigo vinculado y señal disponible | La persona sitúa, prueba y evalúa el lugar | Lugar y señal aceptados para ese ciclo | Mover, cambiar canal o cancelar |
| Listo para armar | Permiso, vínculo, batería, lugar y prueba disponibles | Presentar la acción explícita de armado | Estado preparado | No armar si una condición es incierta |
| Armado y en espera | La persona confirma la regla | Evaluar solo la condición observable durante la ventana | Regla activa | Desarmar, modificar o dejar expirar |
| Condición cumplida | La regla alcanza su condición | Crear un comando con vencimiento | Comando pendiente de entrega | No atribuir intención ni automatismo |
| Señalando | El testigo recibe el comando vigente | Emitir una señal no textual y acotada | Señal terminada o silenciada | No repetir automáticamente |
| Silenciado o continuado | La persona detiene o ignora la señal | Finalizar la señal y no registrar cumplimiento | Reposo | No convertir la decisión en error |
| Reposo y rearmado | Señal terminada o ventana expirada | Conservar solo lo necesario para reconfigurar | Nuevo ciclo explícito | Reprobar lugar, vínculo o batería si cambiaron |
| Error técnico | Permiso revocado, desconexión, reinicio, batería insuficiente o entrega tardía | Explicar el problema y ofrecer recuperación | Reintento o desarmado | Descartar el comando vencido |

Las puertas son progresivas. La puerta de configuración pregunta si la intención puede expresarse sin cargar al usuario con opciones innecesarias. La puerta de vínculo pregunta si el objeto correcto está conectado. La puerta del lugar pregunta si la persona entiende qué relación está creando. La puerta de armado pregunta si el sistema puede iniciar sin estados ambiguos. La puerta técnica pregunta si la condición, entrega y expiración son observables. La puerta de señal pregunta si el evento se percibe y se atribuye. La puerta de rearmado pregunta si el ciclo puede repetirse sin convertir el objeto en una obligación.

## 11.3 Flujo de usuario

El flujo comienza antes de la señal. La persona identifica una actividad alternativa que desea mantener disponible y la traduce a un primer paso que pueda reconocer en el entorno. No se le solicita que reduzca toda actividad digital ni que demuestre que perdió el control. La aplicación conserva el contenido semántico de esa intención porque el testigo no tiene pantalla.

En la configuración, la persona selecciona una única aplicación y una condición operacional dentro de una ventana. La condición exacta sigue abierta entre uso continuo, uso acumulado en una ventana u horario. La aplicación debe explicar que se observará un evento técnico de uso, no una intención subjetiva. La persona concede el permiso correspondiente, vincula el testigo y puede cancelar antes de armar.

En la asociación, sitúa manualmente el testigo junto al primer paso. La aplicación inicia una prueba de señal, pero no puede saber si el lugar conserva significado. La persona comprueba si el objeto puede percibirse, si la señal es tolerable y si el espacio permite una relación razonable con la actividad. Si el testigo se mueve después, la ubicación anterior no debe considerarse vigente automáticamente: corresponde reubicarlo, volver a probar y rearmar.

El armado es explícito. La persona debe poder corregir la intención, el primer paso, el lugar o la modalidad antes de confirmar. Los controles físicos exactos son provisionales; la propuesta vigente reserva una salida física para silenciar una señal activa y mantiene abierta la decisión sobre el armado. La aplicación puede comunicar el estado técnico, pero no debe convertir cada consulta en un requisito de uso.

Durante la espera, Android evalúa la condición escogida. Un cambio de aplicación, el bloqueo de pantalla o una interrupción no pueden interpretarse como evidencia de automatismo. Deben tener una regla declarada: pausar, reiniciar, continuar acumulando o cancelar. Hasta que esa decisión se pruebe, la integración no está cerrada.

Cuando se cumple la condición, la aplicación intenta enviar un identificador de patrón al testigo. El comando tiene vencimiento para impedir que una reconexión tardía produzca una señal fuera de contexto. Si el objeto confirma recepción dentro de la ventana válida, emite una señal no textual. La persona puede recordar la intención, iniciar el primer paso, continuar con el teléfono, ignorar la señal o silenciarla. Ninguna de esas respuestas se almacena como cumplimiento.

La señal termina por una duración de prueba, por silencio físico o por una condición definida en el prototipo. Después el sistema vuelve a reposo. El siguiente ciclo exige armado explícito; no hay rearmado automático ni repetición indefinida. El uso cotidiano termina en la decisión de la persona. La evaluación posterior, realizada por el investigador con consentimiento, puede preguntar por percepción, atribución, recuerdo, intrusión, autonomía y relación con el lugar, pero no convierte esas preguntas en una función del producto.

## 11.4 Flujo del sistema

El flujo del sistema distribuye responsabilidades entre capas. La persona formula y decide; la aplicación conserva significado y estado; la regla local transforma una condición observable en un evento posible; el enlace transporta un patrón; el testigo señala sin texto; y el lugar funciona como una asociación experiencial, no como un sensor.

```text
PERSONA
formula intención + primer paso
        ↓
APLICACIÓN ANDROID
guarda contenido, condición y ventana; solicita permiso; vincula testigo
        ↓
LUGAR MANUAL
persona sitúa el testigo junto al primer paso y prueba la señal
        ↓
ARMADO EXPLÍCITO
se verifican permiso, vínculo, batería, prueba y vigencia de la ventana
        ↓
REGLA LOCAL
evalúa solo la condición operacional definida para una app seleccionada
        ↓
COMANDO CON VENCIMIENTO
la app envía identificador de patrón por BLE; si vence, se descarta
        ↓
TESTIGO SIN PANTALLA
emite señal no textual y permite una salida física provisional
        ↓
PERSONA
recuerda, retoma, continúa, ignora o silencia
        ↓
REPOSO
no se registra si actuó; el siguiente ciclo exige armado explícito
```

Esta secuencia muestra por qué la aplicación y el objeto tienen una dependencia técnica, mientras que el lugar tiene una dependencia experiencial. La aplicación puede saber que una regla está armada; no puede saber que el objeto sigue junto al primer paso. El testigo puede confirmar un comando; no puede explicar qué intención representa. La persona puede asociarlos; el sistema no debe atribuirle una acción posterior.

La arquitectura mínima no necesita resolver todos los contextos domésticos. Necesita permitir que una única persona, una intención, un primer paso, un testigo y una condición acotada produzcan una experiencia examinable. La arquitectura aspiracional agregaría compatibilidad, servicio en segundo plano, telemetría técnica y mantenimiento, pero cada agregado aumenta permisos, estados y carga.

## 11.5 Flujo técnico y manejo de fallos

El flujo técnico comienza después de que la persona arma la regla. Android consulta localmente la fuente de eventos de uso que corresponda al prototipo. El permiso puede ser revocado por la persona o quedar limitado por políticas de energía. BLE intenta transportar un patrón, pero su entrega depende de la disponibilidad del objeto, del teléfono y de la ventana. El testigo ejecuta una señal solo cuando recibe un comando vigente.

| Estado técnico | Evento | Respuesta mínima | Qué no debe afirmarse |
| --- | --- | --- | --- |
| Permiso disponible | La aplicación puede consultar la condición | Evaluar la regla dentro de la ventana | Que el permiso revela intención o automatismo |
| Permiso revocado | Android deja de entregar la información necesaria | Desarmar o pausar y explicar el motivo | Que la regla continúa operando normalmente |
| Batería insuficiente | El nivel no permite asegurar la señal | Advertir, impedir armado o pedir carga según el prototipo | Una autonomía no medida |
| Objeto desconectado | No hay enlace BLE válido | Reintentar solo dentro de la vigencia; luego descartar | Que la señal llegará al reconectar en cualquier momento |
| Cambio de aplicación | La persona deja la aplicación seleccionada | Aplicar la regla previamente definida: pausa, reinicio, acumulación o cancelación | Que el cambio significa continuidad poco deliberada |
| Pantalla bloqueada | El teléfono cambia de estado de uso | Aplicar la política declarada y registrar un estado técnico | Que la persona sigue usando la aplicación |
| Reinicio del teléfono | Se interrumpe la regla o el enlace | Recuperar como desarmado hasta comprobación explícita | Que la sesión continúa sin revisión |
| Reinicio del testigo | Se pierde el estado local | Solicitar vínculo o prueba nuevamente | Que el objeto conserva el estado sin confirmación |
| Objeto movido | La persona cambia el lugar | Exigir reubicación, prueba y armado | Que Android detecta el movimiento |
| Señal tardía | El comando llega después de su vencimiento | Descartar, informar fallo técnico y volver a reposo | Que una señal tardía conserva significado |
| Señal no percibida | El objeto ejecuta, pero la persona no la nota | Registrar como problema de percepción o convivencia | Resolverlo solo aumentando potencia o duración |

La separación de fallos es esencial. Un **fallo de concepto** ocurre cuando la persona no entiende qué relación representa el testigo o no reconoce para qué lo situó. Un **fallo de percepción** ocurre cuando la señal no se detecta, se confunde con otra o resulta invasiva en el contexto. Un **fallo técnico** ocurre cuando el permiso, la condición, el enlace, la batería o el comando no se comportan como la regla declara. Un **fallo de convivencia** ocurre cuando la señal afecta a otras personas o expone una intención en un espacio compartido. Cada tipo exige una respuesta diferente.

| Fallo | Pregunta de diagnóstico | Corrección posible | No corresponde hacer |
| --- | --- | --- | --- |
| Conceptual | ¿La persona puede explicar la asociación sin releer la aplicación? | Reformular lugar, primer paso, señal o dirección física | Añadir reconexión BLE para resolver significado |
| Perceptivo | ¿La señal se detecta y atribuye en esa superficie y distancia? | Comparar canal, posición y perfil de señal | Declarar accesibilidad universal |
| Técnico | ¿El evento y el comando respetaron la regla? | Revisar permiso, segundo plano, enlace, batería y vencimiento | Culpar a la persona por no responder |
| Convivencia | ¿La señal es tolerable y privada en ese hogar? | Cambiar canal, alcance, horario o contexto | Aumentar alcance sin estudiar exposición |

El comando con vencimiento es una decisión de seguridad experiencial, no solo una optimización. Una señal emitida mucho después de la sesión puede parecer arbitraria y romper la confianza en el sistema. Descartar el comando tarde protege la relación entre condición, lugar y momento, aunque implique reportar que la integración no funcionó.

## 11.6 Flujo de diseño y puertas de decisión

El flujo de diseño avanza desde una pregunta hacia una prueba y solo después hacia una especificación. La investigación y la producción se mantienen conectadas, pero no simultáneas sin prioridad. Cada etapa debe cerrar una incertidumbre antes de agregar otra.

| Fase | Pregunta principal | Evidencia o registro | Puerta para avanzar |
| --- | --- | --- | --- |
| Delimitación | ¿Qué patrón situacional se aborda y cuándo no se interviene? | Usuario principal, límite, exclusiones y matriz de evidencia | La no intervención queda explícita |
| Asociación | ¿La persona relaciona intención, primer paso, lugar y señal? | Activación simulada, recuerdo, atribución y contraejemplos | La señal no es solo una alarma genérica |
| Dirección física | ¿El testigo transportable aporta una cualidad situada? | Comparación situado, neutro y notificación | Existe un aporte físico identificable o se reformula la dirección |
| Prototipo de señal | ¿Qué canal se percibe y tolera en el contexto? | Detección, atribución, intrusión, privacidad y convivencia | Se elige una variable de señal, sin declarar universalidad |
| Regla técnica | ¿Qué condición observable puede ejecutar Android? | Pruebas de permisos, eventos, cambios, reinicios y vencimiento | La regla se puede explicar y sus fallos se pueden recuperar |
| Integración | ¿App, enlace y objeto producen el evento dentro de la ventana? | Acuses, pérdidas, latencia, batería y estados | No aparecen comandos tardíos sin explicación |
| Gestión | ¿Puede producirse, mantenerse, repararse y retirarse? | Lista de materiales (BOM, por su sigla en inglés), proceso, actores, riesgos, cumplimiento y fin de vida | La carga es proporcional al valor físico |
| Escala o reformulación | ¿La dirección física merece continuar? | Resultado de las puertas anteriores y límites | Mantener, modificar o abandonar la dirección actual, sin convertir Relevo en una aplicación aislada |

La arquitectura mínima de prototipo termina en asociación y señal comprensible. La arquitectura técnica aspiracional no debe adelantarse a esa puerta. Del mismo modo, una forma final, una carcasa industrial o una cadena de proveedores no deben presentarse antes de saber si el testigo aporta una diferencia frente a la notificación.

## 11.7 Accesibilidad, autonomía y convivencia

La accesibilidad se aborda como un conjunto de requisitos por investigar, no como una propiedad universal del sistema. La ausencia de pantalla no resuelve por sí sola las barreras: desplaza la carga hacia la señal, el control, la explicación en la aplicación y el contexto doméstico. Cada dimensión puede revelar una exclusión distinta.

| Dimensión | Requisito a investigar | Riesgo y límite actual |
| --- | --- | --- |
| Visual | No depender exclusivamente de color, contraste o línea de visión; comprobar detección en distintas iluminaciones | La señal puede pasar inadvertida o confundirse con decoración |
| Auditiva | Permitir desactivar sonido y estudiar perfiles que no expongan la intención | El sonido puede molestar, despertar o revelar la regla a convivientes |
| Táctil | Comprobar si vibración o resonancia se perciben en distintas superficies y formas de contacto | Una vibración sobre mesa no equivale necesariamente a una señal háptica |
| Cognitiva | Presentar una intención, un primer paso, un estado y una recuperación comprensibles | La ausencia de texto en el objeto puede producir ambigüedad |
| Motora | Reducir precisión, fuerza y duración necesarias para silenciar, rearmar o recuperar | Los gestos físicos siguen sin prueba y pueden generar activaciones accidentales |
| Doméstica y convivencia | Permitir control de alcance, privacidad, superficie, horario y canal | El hogar no fue observado sistemáticamente y no existe perfil universal |

La señal visual debe considerar el riesgo de destellos, pero cumplir una referencia preventiva no demuestra percepción ni accesibilidad (World Wide Web Consortium, s. f.). La señal auditiva debe evaluarse por alcance y privacidad, no como solución automática a una baja visibilidad. La vibración debe describirse como una variable de prueba hasta observarla sobre superficies reales. La aplicación deberá explicar estados técnicos en lenguaje comprensible sin exigir consulta posterior para interpretar una señal cotidiana.

La autonomía se expresa en salidas concretas: no armar, desarmar, silenciar, ignorar, continuar con el teléfono, cambiar de intención y borrar la regla. Estas salidas no generan puntuación. La convivencia agrega una dimensión que no se reduce a la experiencia de quien configura: una señal puede afectar a otra persona o revelar que existe una intención privada. La prueba debe registrar ambas perspectivas cuando corresponda, sin ampliar el alcance a un estudio doméstico general.

## 11.8 Mapa de datos y privacidad

El procesamiento local limita la circulación de datos, pero no equivale a privacidad absoluta. La aplicación puede necesitar consultar estadísticas del teléfono durante una ventana armada; ese permiso permite acceder a información sobre actividad de aplicaciones. Además, la intención puede quedar visible para quien tenga acceso al dispositivo y una señal puede exponer la existencia de una regla en un espacio compartido. La memoria debe declarar esas superficies en lugar de afirmar que Relevo no rastrea.

| Dato o estado | Propósito | Almacenamiento previsto | Retención y borrado | Exposición o riesgo |
| --- | --- | --- | --- | --- |
| Intención y primer paso | Conservar el significado semántico de la regla | Teléfono, almacenamiento local | Editar, borrar al desarmar o eliminar la regla; definir qué ocurre al desinstalar | Puede ser visto por otra persona con acceso al teléfono |
| Aplicación seleccionada | Evaluar la condición técnica | Teléfono, idealmente como referencia local mínima | Mantener solo mientras la regla lo necesita y borrar al cerrar | El permiso permite inferir actividad de uso |
| Umbral, ventana y estado armado | Ejecutar y explicar la regla | Teléfono | Reiniciar al terminar, desarmar o vencer | Una regla persistente puede revelar hábitos |
| Identificador y vínculo BLE | Entregar el patrón al objeto | Teléfono y memoria mínima del testigo | Desvincular y restablecer; evitar persistencia innecesaria | Puede permitir reconocer el objeto si no se restablece |
| Batería, acuse y error técnico | Recuperar la integración | Teléfono mientras la sesión está armada | Definir si se conserva solo mientras la sesión está armada | Los registros técnicos pueden revelar momentos de uso |
| Condición posterior a la señal | No es necesaria para el servicio | No debe almacenarse | Exclusión explícita | Registrar cumplimiento convertiría la autonomía en vigilancia |
| Registro de investigación | Analizar percepción, recuerdo y abandono | Instrumento separado del servicio | Retención definida por protocolo y consentimiento | No debe confundirse con historial cotidiano del producto |

El mapa exige cuatro decisiones para cada dato: finalidad, lugar de almacenamiento, tiempo de retención y forma de exposición o eliminación. También debe aclarar qué permiso solicita Android, por qué es necesario, qué ocurre si se revoca y cómo se comunica que la regla dejó de operar. La aplicación no debe esconder la falla para mantener la apariencia de continuidad.

La privacidad y la autonomía son parte de la arquitectura, no un texto agregado al final. El testigo recibe únicamente el identificador de patrón y los parámetros indispensables para la señal; no recibe la intención ni funciona como localizador. La investigación puede registrar consultas, silencios o reubicaciones con consentimiento, pero el producto cotidiano no debe inferir ni almacenar si la persona obedeció.

# 12. Producción, factibilidad y modelo de gestión

La factibilidad de Relevo no consiste en demostrar que existe una carcasa posible. Consiste en establecer qué necesita cada pregunta, quién puede resolverla, cuánto cuesta explorarla, qué riesgos quedan abiertos y qué condiciones permitirían sostener una dirección física sin pantalla. La producción se entiende aquí como una cadena de prototipado, fabricación, ensamblaje, prueba, reparación y fin de vida. La escala comercial no se presume.

## 12.1 Etapas de prototipo por pregunta

La secuencia se organiza por fidelidad progresiva. Un **prototipo de fidelidad** es una construcción cuyo nivel de detalle se ajusta a la pregunta que debe responder; no es necesariamente una versión pequeña del producto final. La investigación mediante diseño usa esa relación para no invertir en integración antes de conocer el valor que se quiere integrar (Real et al., 2021).

| Etapa | Construcción candidata | Pregunta principal | Evidencia de avance | Lo que no valida |
| --- | --- | --- | --- | --- |
| P0 · Asociación | Carcasa o testigo simulado; activación manual; lugar congruente y neutro | ¿La persona recuerda intención y primer paso sin texto en el objeto? | Relatos, atribución, consulta del teléfono, relación con el lugar | Android, BLE, batería o producción |
| P1 · Señal | Testigo físico sin pantalla, actuadores candidatos y silencio físico | ¿Qué señal se percibe, se atribuye y se detiene sin intrusión? | Detección, atribución, tolerancia, convivencia y control | Regla automática y compatibilidad entre teléfonos |
| P2 · Enlace | Microcontrolador de desarrollo, BLE, comando y acuse | ¿El patrón llega al objeto dentro de una ventana controlada? | Comandos entregados, perdidos, tardíos, reconexión y estados | Valor de la asociación o autonomía final |
| P3 · Integración | Android, una condición observable, ventana, batería y testigo | ¿La regla se explica y opera con los fallos previstos? | Permisos, cambios de aplicación, pantalla bloqueada, reinicio, batería y vencimiento | Cobertura universal o desempeño comercial |
| P4 · Piloto acotado | Carcasa de mayor fidelidad, mantenimiento y uso repetido | ¿La dirección física conserva valor y carga proporcional? | Habituación, rearmado, pérdida, privacidad, abandono y comparación con notificación | Mercado, precio o sostenibilidad industrial |

P0 debe anteceder a P1 porque una señal técnicamente funcional no resuelve una asociación que nadie entiende. P1 debe anteceder a P2 porque el enlace no corrige una señal imperceptible. P2 debe anteceder a P3 porque una aplicación integrada no debe ocultar si el comando se pierde. P4 solo tiene sentido si las puertas anteriores sostienen una dirección física; si el testigo transportable no aporta, se reformula esa capa física antes de invertir en compactación o serie.

## 12.2 Electrónica, materiales y componentes candidatos

Los componentes son medios para responder preguntas y no decisiones finales. El prototipo temprano puede utilizar un microcontrolador disponible, como ESP32-C3, porque facilita comprobar flujo y comunicación. Esa elección no representa el consumo del objeto final. Para una versión de bajo consumo se han documentado como candidatos nRF52810/11, un gestor de energía como nPM1100, actuadores de luz, un piezo, un actuador resonante lineal y un controlador háptico. Las hojas técnicas describen componentes aislados; no demuestran que el conjunto alcance una autonomía o una señal determinada (Nordic Semiconductor ASA, s. f.-a, s. f.-b; Precision Microdrives Ltd., 2023; Texas Instruments, 2018).

La batería protegida y el circuito de carga son candidatos condicionados por picos, seguridad, recarga y servicio. No se fija aquí una capacidad, una duración ni un número de activaciones. La autonomía debe medirse con el ciclo real del prototipo: reposo, consulta, enlace, señal, carga y recuperación. Una cifra de componente no equivale a la autonomía del sistema.

Los materiales se agrupan por función: carcasa protectora, difusor o guía de señal, apoyo, fijaciones, placa, batería y actuadores. Las alternativas de impresión, resina, polímero técnico, elastómero y fijación mecánica deben compararse por protección, reparación, estabilidad, seguridad y disponibilidad. La ausencia de pantalla es una restricción firme del proyecto, no una condición temporal de esta dirección. Si el testigo transportable falla, se reformula o reemplaza la dirección física; cualquier nueva dirección debe seguir siendo phygital y utilizar un objeto físico sin pantalla.

| Candidato | Pregunta que habilita | Condición para conservarlo | Riesgo abierto |
| --- | --- | --- | --- |
| Microcontrolador de desarrollo | ¿Puede recibir y traducir un patrón? | Disponibilidad y registro reproducible | Consumo no representativo |
| Plataforma BLE de bajo consumo | ¿Puede mantener el vínculo dentro de la ventana? | Pruebas de entrega, reconexión y reinicio | Dependencia de versión y fabricante |
| Luz | ¿Puede señalar sin texto y sin exposición excesiva? | Detección, atribución y convivencia | Invisibilidad o confusión |
| Piezo o sonido | ¿Aporta alcance suficiente sin invadir? | Perfil configurable y privacidad | Molestia, sobresalto y exposición |
| Actuador resonante | ¿Se percibe en el objeto y la superficie? | Prueba de contacto y estabilidad | No equivale automáticamente a tacto |
| Batería recargable protegida | ¿Permite el ciclo sin riesgo desproporcionado? | Medición de picos, carga y mantenimiento | Autonomía, temperatura y fin de vida |
| Carcasa desmontable | ¿Protege y permite reparación? | Ensamble, caída, apertura y reposición | Sellado, tolerancias y costo |

## 12.3 Fabricación, ensamblaje, prueba, reparación y fin de vida

La fabricación académica puede comenzar con una carcasa impresa, apoyos y componentes accesibles. El objetivo inicial es aprender sobre asociación, señal y montaje, no simular una producción industrial. En una fase posterior, una placa propia, una carcasa más resistente y una guía de señal separada podrían reducir improvisaciones, pero solo después de cerrar las preguntas que justifican esos cambios.

El ensamblaje debe documentar una secuencia reproducible: inspección de componentes, montaje de placa y actuadores, conexión y protección de batería, cierre de carcasa, prueba de carga, prueba de señal, prueba de botón, prueba de vínculo y registro de identificación. Cada unidad de prototipo debe poder etiquetarse y abrirse sin destruirla si la investigación exige revisar el circuito. La ausencia de pantalla hace especialmente importante que la aplicación comunique batería, vínculo, armado, error y recuperación.

Las pruebas de fabricación se separan de las pruebas de experiencia. Las primeras revisan continuidad eléctrica, carga, temperatura, integridad del cierre, entrega del comando y respuesta del actuador. Las segundas revisan comprensión, atribución, intrusión, autonomía, convivencia y asociación. Que un objeto encienda no demuestra que la persona entienda su función. Que una persona comprenda una señal simulada no demuestra que el enlace real la entregue.

La reparación debe contemplar batería, placa, actuadores, botón, difusor y carcasa. Un cierre mecánico reversible facilita diagnóstico y reemplazo, pero puede afectar protección. La solución no se declara reparable hasta observar si el componente puede cambiarse sin producir un riesgo nuevo. El mantenimiento mínimo incluye carga, revisión de vínculo, rearmado, actualización o reinstalación de la aplicación y restablecimiento del testigo.

El fin de vida debe separar batería, placa, polímeros, elastómeros y actuadores según la infraestructura disponible. No se declara sostenibilidad solo por reducir piezas o usar un material particular. Deben registrarse masa, posibilidad real de desmontaje, reemplazo, disposición y responsabilidad de quien recibe el objeto. Una eventual versión comercial requeriría revisar ensayos eléctricos, seguridad de batería, radio, etiquetado y la categoría normativa aplicable.

## 12.4 Costos diferenciados y alcance económico

La planificación económica separa cuatro magnitudes que no deben sumarse como si fueran equivalentes: costo del prototipo académico, trabajo profesional, costo de producción y precio. Esta separación impide usar una lista de materiales de una unidad como si fuera el costo industrial o convertir una tarifa de trabajo en disposición de pago.

| Magnitud | Qué incluye | Estado actual | Uso permitido |
| --- | --- | --- | --- |
| Prototipo académico | Componentes, impresión o fabricación, reposición, ensamble, herramientas y contingencia | Aproximadamente CLP 59.000–107.000: base CLP 51.140–92.640, más 15 % = CLP 58.811–106.536, redondeado; planificación sin cotizaciones | Presupuestar la siguiente prueba y transparentar supuestos |
| Trabajo profesional | Diseño de experiencia, investigación, electrónica, desarrollo Android, coordinación, documentación y análisis | La memoria documenta un escenario de dedicación profesional, pero no una tarifa institucional ni un costo de mercado | Visibilizar trabajo que no aparece en la lista de materiales |
| Producción | Proveedores, PCB, carcasa, batería, ensamble, prueba, certificación, logística, impuestos, merma, soporte y garantía | No calculado: requiere volumen, cotizaciones, ingeniería y cumplimiento | Construir escenarios posteriores, no sostener viabilidad actual |
| Precio | Disposición de pago, alternativas gratuitas, servicio, reposición y modelo de sostenibilidad | No definido; no existe evidencia de disposición de pago | No usar una cifra de venta como argumento del proyecto |

El rango de prototipo corregido deriva de una suma base mínima de CLP 51.140 y máxima de CLP 92.640. Al aplicar una contingencia del 15 %, los extremos son CLP 58.811 y CLP 106.536; por redondeo se comunica como CLP 59.000–107.000. Sigue siendo un presupuesto de planificación, no una cotización: no incluye horas profesionales, certificación, producción en serie, impuestos ni desempeño. Debe conservar la fecha de consulta y señalar qué partidas cuentan con precio publicado y cuáles son presupuestos de ingeniería.

El trabajo profesional no debe esconderse dentro de los materiales. La estimación de dedicación puede acompañar el modelo de gestión como escenario de recursos, pero no prueba que exista un negocio ni que ese tiempo deba remunerarse con una tarifa específica. El costo de producción tampoco puede inferirse multiplicando una unidad: la escala introduce moldes, pruebas, rechazo, proveedores, almacenamiento, cumplimiento y soporte.

El precio directo queda fuera del argumento principal. Antes de establecerlo se necesitarían costos reales, comparación con alternativas, modelo de mantenimiento, disposición de pago y una decisión sobre quién sostiene la aplicación y el reemplazo del objeto. Si la materialidad no aporta valor reconocible, un precio no la justifica; se reformula la dirección física o se vuelve a investigación de diseño.

## 12.5 Actores, responsabilidades y colaboraciones

El modelo de gestión asigna responsabilidades sin suponer que todas las funciones deban existir como cargos formales. El diseñador coordina el sistema, pero no puede garantizar por sí solo radio, autonomía, certificación o compatibilidad entre fabricantes. Cada promesa necesita una colaboración o una prueba que la sostenga.

| Actor o rol | Responsabilidad principal | Producto verificable | Dependencia |
| --- | --- | --- | --- |
| Diseñador y autor | Formular problema, requisitos, no requisitos, flujos, hipótesis físicas y criterios de decisión | Memoria, matrices, prototipos, protocolos y registro de fallos | Dirección académica y colaboradores técnicos |
| Dirección académica | Revisar pertinencia, evidencia, límites y coherencia de la tesis | Puertas de revisión y decisiones documentadas | Estado real del proyecto |
| Desarrollo Android | Implementar configuración, permisos, regla observable, estados y recuperación | Aplicación de prototipo y registro técnico | Documentación oficial y teléfonos de prueba |
| Electrónica y firmware | Seleccionar candidatos, montar, programar señal, batería y vínculo | Placa, firmware, mediciones y procedimiento de recuperación | Componentes, herramientas y seguridad |
| Fabricación | Construir carcasa, apoyo, fijaciones y versiones de prueba | Piezas identificadas, ensamble y reparabilidad | Materiales, taller y tolerancias |
| Investigación y accesibilidad | Diseñar pruebas de asociación, percepción, autonomía y convivencia | Instrumentos, consentimiento, codificación y análisis | Participantes y protocolo ético |
| Proveedores | Entregar componentes, materiales o servicios con fecha y condición | Cotizaciones, hojas técnicas y trazabilidad | Disponibilidad y compras |
| Cumplimiento técnico | Revisar radio, batería, seguridad, etiquetado y requisitos aplicables | Matriz regulatoria y ensayos cuando corresponda | Versión final y jurisdicción |
| Persona participante | Formular intención, situar, probar, interpretar y reportar experiencia | Datos de investigación con consentimiento | No representa un operador que deba obedecer |

Las colaboraciones pueden ocurrir por asesoría puntual o por desarrollo conjunto. Lo importante es registrar qué decisión depende de una fuente externa y qué responsabilidad sigue siendo del diseñador. El modelo no incluye cuenta, administración remota, soporte multiusuario ni vigilancia de convivientes en su alcance mínimo.

## 12.6 Recursos, hitos y puertas de ejecución

Los recursos mínimos son un teléfono Android de prueba, un testigo sin pantalla, componentes de señal, herramienta de montaje, medios de carga segura, superficies domésticas variadas, instrumentos de registro y tiempo para repetir fallos. La existencia de un recurso no significa que su desempeño sea suficiente; cada uno debe vincularse a una pregunta.

| Hito | Trabajo | Recurso principal | Evidencia para avanzar |
| --- | --- | --- | --- |
| H0 · Regla | Redactar condición, ventana, cambio de aplicación, pantalla bloqueada y vencimiento | Documentación Android y matriz de estados | Regla comprensible sin términos subjetivos |
| H1 · Asociación | Activación simulada con testigo sin pantalla | Carcasa, señal controlada y lugares contrastados | Intención, primer paso y lugar pueden discutirse sin repetir el texto |
| H2 · Señal | Comparar canales y silencio | Actuadores candidatos, superficies y registro de convivencia | Perfil perceptible y tolerable para la prueba |
| H3 · Enlace | Entregar patrón y acuse | Android, BLE, firmware y estados de error | Pérdida, reconexión y vencimiento quedan observables |
| H4 · Integración | Probar condición técnica y batería | Aplicación, testigo, teléfonos y carga | No aparecen señales tardías sin explicación |
| H5 · Gestión | Documentar fabricación, reparación, datos y cumplimiento | Lista de materiales, proveedores, procedimiento y matriz de riesgos | La carga de mantener la dirección física es conocida |
| H6 · Escala o reformulación | Comparar aporte físico, notificación y costos | Resultados acumulados, no supuestos | Mantener, modificar o descartar la dirección física |

La secuencia respeta una sola prioridad sustantiva por etapa. Si H1 falla por significado, H3 no debe comenzar como si la integración pudiera compensarlo. Si H3 falla por entrega, no debe concluirse que el lugar no aporta. Si H5 revela una carga desproporcionada, la decisión debe volver a la dirección física y no ocultarse con un precio hipotético.

## 12.7 Riesgos, cumplimiento y responsabilidad

| Riesgo | Consecuencia | Acción de reducción | Estado de la afirmación |
| --- | --- | --- | --- |
| Regla ambigua | No se puede saber cuándo señalar | Cerrar evento, ventana, acumulación, cambios y vencimiento | Pendiente crítico |
| Señal genérica | El testigo no recupera la asociación | Comparar atribución, lugar y notificación | Hipótesis de valor |
| Permiso revocado o segundo plano limitado | La regla deja de operar | Estado explícito, desarmado y recuperación | Hipótesis técnica |
| BLE perdido o tardío | La señal no llega o llega fuera de contexto | Acuse, vencimiento y descarte | Hipótesis técnica |
| Batería insuficiente | El objeto parece fallar sin explicación | Medir ciclo, advertir y bloquear armado cuando corresponda | Meta no medida |
| Canal invasivo | Se contradicen autonomía y convivencia | Perfiles, silencio y prueba doméstica | Pendiente de percepción |
| Accesibilidad sobregeneralizada | Se excluyen personas o situaciones | Desglosar dimensiones y declarar límites | Requisito de investigación |
| Exposición de intención | La privacidad se rompe en teléfono o espacio | Mapa de datos, aviso de permiso y señal discreta | Riesgo abierto |
| Materiales o batería inseguros | Daño, falla o imposibilidad de reparar | Protección, ensayos, desmontaje y servicio especializado | Requisito técnico |
| Costos sin cotización | Se presenta una viabilidad falsa | Actualizar proveedores y separar escenarios | Planificación solamente |
| Incumplimiento regulatorio | No se puede comercializar el enlace de radio | Revisar categoría, ensayos, etiquetado y declaración aplicable | Pendiente para producto |
| Fin de vida opaco | Batería y componentes se desechan sin control | Diseñar desmontaje e instrucciones | Meta de gestión |

La regulación de equipos de alcance reducido debe revisarse según la categoría concreta del producto, incluyendo ensayos, etiquetado y declaración de conformidad cuando corresponda (Subsecretaría de Telecomunicaciones, 2026). Esa revisión pertenece a una eventual versión comercial; un prototipo académico no equivale a certificación. Del mismo modo, los requisitos de servicios en primer plano y distribución de una aplicación Android deben comprobarse en la versión objetivo y no inferirse de una demostración local (Google Play, s. f.).

La responsabilidad ética incluye no transformar datos de uso en una calificación. La aplicación puede fallar; la persona no debe convertirse en el lugar donde se deposita ese fallo. La documentación de errores, permisos y límites debe ser accesible para quien configura el sistema y verificable para quien evalúa el prototipo.

## 12.8 Mantenimiento y modelo operativo

El mantenimiento empieza en la configuración. La persona crea una intención, concede permisos, vincula, sitúa, prueba y arma. Durante el uso puede consultar estado técnico, pero no debe estar obligada a mirar el teléfono para interpretar una señal cotidiana. Si reubica el objeto, debe repetir la prueba y armar. Si baja la batería, la aplicación debe explicar la limitación y orientar la carga o el desarmado.

| Momento | Responsable principal | Operación mínima | Pendiente que debe resolverse |
| --- | --- | --- | --- |
| Preparación | Persona y aplicación | Crear intención, permiso, vínculo, lugar y prueba | Cantidad mínima de pasos y comprensión |
| Uso | Persona y sistema | Evaluar condición, emitir una señal y permitir salida | Regla exacta, canal y control |
| Reubicación | Persona | Mover, probar y rearmar | Cómo se comunica que cambió el contexto |
| Batería | Persona; soporte en versión posterior | Cargar, revisar y recuperar | Umbral de advertencia y reemplazo |
| Desconexión | Aplicación y firmware | Reintentar dentro de vigencia o descartar | Estrategia de reconexión |
| Restablecimiento | Persona o servicio | Desvincular, borrar y volver a configurar | Gesto, datos y confirmación sin pantalla |
| Reparación | Servicio o autor en prototipo | Cambiar batería, placa, actuador o carcasa | Acceso, seguridad y disponibilidad de piezas |
| Actualización | Desarrollo y soporte | Revisar aplicación y firmware | Compatibilidad, recuperación y responsabilidad |
| Fin de vida | Persona, servicio o fabricante futuro | Separar batería y componentes | Reciclaje, instrucciones y trazabilidad |

La arquitectura mínima de prueba mantiene un usuario, un testigo y una intención activa por ciclo. Esta simplificación organiza la prueba, pero no constituye un modelo comercial. Para sostener el sistema en el tiempo aún se deberían resolver garantía, repuestos, actualización, soporte, compatibilidad, tratamiento de datos y responsabilidad por la batería. No se presenta un servicio de suscripción ni una cuenta remota porque no forman parte de la arquitectura mínima.

## 12.9 Rol del diseñador y modelo de colaboración

El diseñador articula la cadena entre evidencia, sistema, objeto y gestión. Su trabajo no consiste en garantizar solo una carcasa o una interfaz, sino en decidir qué pregunta responde cada componente, qué resultado obligaría a cambiar una dirección y cómo se documenta la relación entre capas.

| Responsabilidad | Entregable | Colaboración |
| --- | --- | --- |
| Formular problema y límites | Tesis, usuario situacional, no intervención y exclusiones | Investigación y dirección académica |
| Traducir evidencia | Matrices de requisito, no requisito, prueba y estado | Revisión teórica y usuarios |
| Diseñar arquitectura | Flujos, estados, puertas y recuperación | Desarrollo Android y electrónica |
| Definir función física | Hipótesis de señal, lugar, control y transportabilidad | Prototipado, fabricación y accesibilidad |
| Coordinar pruebas | Protocolos, indicadores, contraejemplos y análisis | Participantes y análisis |
| Organizar factibilidad | Candidatos, lista de materiales, reparación, cumplimiento y riesgos | Proveedores, técnico y regulatorio |
| Documentar decisiones | Memoria, anexos, fallos y trazabilidad | Todas las colaboraciones |

La responsabilidad del diseñador incluye detener una progresión cuando la evidencia no la sostiene. Un componente técnicamente posible no debe ingresar al producto solo porque está disponible. Un costo estimado no debe convertirse en precio. Una señal perceptible no debe convertirse en promesa de accesibilidad universal. La coordinación es una práctica de diseño porque hace visible qué relaciones mantienen unido al sistema phygital.

## 12.10 Criterios de escala, reformulación y abandono de la dirección física

Escalar no significa fabricar más unidades. Significa que una dirección puede sostener su función, su señal, su privacidad, su reparación y su gestión bajo condiciones más amplias que la primera prueba. La escala solo se considera después de cerrar las puertas de asociación, percepción, técnica y factibilidad.

| Estado | Criterio | Decisión |
| --- | --- | --- |
| Mantener | La persona recupera intención y primer paso; el lugar aporta una diferencia reconocible; la señal es tolerable; la regla es explicable; la carga de mantenimiento es proporcional | Continuar con la dirección física y aumentar fidelidad de manera acotada |
| Reformular | Existe una aportación física, pero falla el testigo transportable, la señal, el lugar, el control, la accesibilidad o la producción | Cambiar esa capa física; la nueva dirección debe seguir siendo phygital y sin pantalla |
| Descartar dirección actual | El testigo transportable exige consulta reiterada, no aporta frente a lugar neutro o notificación, o su carga técnica y material es desproporcionada | Abandonar o reemplazar esa dirección física, sin presentar una aplicación como Relevo |
| Volver a investigación | Ninguna configuración física produce un valor situado defendible | Registrar la refutación de la formulación vigente y reabrir investigación de diseño |
| Escalar | La dirección física mantiene valor, autonomía, privacidad, reparación y cumplimiento bajo pruebas ampliadas | Preparar proveedores, costos reales, certificación y soporte; no asumir viabilidad comercial |

La notificación es un control comparativo para identificar el aporte físico, no una salida final del proyecto. La ausencia de pantalla es una restricción firme del proyecto, no una condición de esta dirección. Si el testigo transportable no aporta, se reformula o reemplaza la dirección física; cualquier nueva dirección debe seguir siendo phygital y utilizar un objeto físico sin pantalla. Relevo no se convierte en una aplicación.

## 12.11 Matriz de estado de producción y gestión

| Elemento | Estado | Formulación vigente | Próxima evidencia |
| --- | --- | --- | --- |
| Phygital y objeto sin pantalla | Restricción vigente | App, objeto, lugar y persona forman la experiencia; el objeto no muestra texto | Prueba de asociación y valor físico |
| Arquitectura P0 | Decisión de método | Activación simulada y testigo físico para estudiar significado | Recuerdo, atribución, lugar y autonomía |
| Arquitectura Android/BLE | Hipótesis técnica | Plataforma y enlace iniciales, condicionados a permisos, segundo plano y fabricantes | Matriz de eventos, entrega, reinicio y vencimiento |
| Condición de activación | Pendiente crítico | Continuidad, acumulación u horario aún deben elegirse | Regla operacional y prueba de comprensión |
| Señal y control | Decisión provisional | Canales y silencio se prueban; armado exacto permanece abierto | Detección, atribución, intrusión y recuperación |
| Accesibilidad | Requisito de investigación | Visual, auditiva, táctil, cognitiva, motora y doméstica se evalúan por separado | Pruebas con límites declarados |
| Datos y privacidad | Requisito provisional | Procesamiento local acotado, sin historial de cumplimiento ni nube | Mapa de datos, permisos, retención y borrado |
| Componentes y materiales | Candidatos | Se eligen según la pregunta y la disponibilidad | Medición de señal, consumo, seguridad y reparación |
| Lista de materiales de prototipo | Planificación | Aproximadamente CLP 59.000–107.000: base CLP 51.140–92.640, contingencia del 15 %, sin cotizaciones | Actualización de partidas y compras |
| Trabajo profesional | Escenario de recursos | Se separa de materiales y no fija precio de venta | Plan de colaboradores y dedicación real |
| Producción | Pendiente | Requiere volumen, proveedores, ensamble, prueba y cumplimiento | Cotizaciones y matriz de producción |
| Precio | No definido | Se retira del argumento principal por falta de disposición de pago | Investigación económica posterior |
| Mantenimiento | Decisión de gestión provisional | Carga, vínculo, reubicación, reparación y fin de vida deben existir | Ensayo de recuperación y desmontaje |
| Escala | Puerta posterior | Solo después de demostrar valor físico y carga proporcional | Comparación, riesgos y cumplimiento |

La matriz evita que la producción aparezca como una promesa independiente de la experiencia. El objetivo de esta etapa no es declarar que Relevo ya puede fabricarse o comercializarse, sino dejar claro qué debe comprobarse para que una dirección física sin pantalla pueda continuar.

## Referencias técnicas del bloque

Google. (s. f.-a). *Communicate in the background*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (s. f.-b). *Companion device pairing*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing

Google. (s. f.-c). *UsageStatsManager*. Android Developers. Recuperado el 24 de agosto de 2026, de https://developer.android.com/reference/android/app/usage/UsageStatsManager

Google Play. (s. f.). *Foreground service requirements for apps targeting Android 14 or higher*. Google Play Console Help. Recuperado el 24 de agosto de 2026, de https://support.google.com/googleplay/android-developer/answer/17105854

Nordic Semiconductor ASA. (s. f.-a). *nPM1100 product specification*. Recuperado el 24 de agosto de 2026, de https://docs.nordicsemi.com/r/bundle/ps_npm1100/page/keyfeatures_html5.html

Nordic Semiconductor ASA. (s. f.-b). *nRF52810 product specification*. Recuperado el 24 de agosto de 2026, de https://docs-be.nordicsemi.com/bundle/nRF52810-PS/raw/resource/enus/nRF52810_PS_v1.1.pdf

Precision Microdrives Ltd. (2023). *C08-00A: 8 mm linear resonant actuator* [Hoja de datos]. https://precisionmicrodrives.com/cdn/datasheets/C08-00A%20-%20datasheet%20-%20002/c08-00a-datasheet-002.pdf

Real, R., Snider, C. M., Goudswaard, M. A., y Hicks, B. J. (2021). Dimensions of knowledge in prototyping: A review and characterisation of prototyping methods and their contributions to design knowledge. *Proceedings of the Design Society, 1*, 1303–1312. https://doi.org/10.1017/pds.2021.130

Subsecretaría de Telecomunicaciones. (2026, 15 de enero). *Equipos de alcance reducido*. https://www.subtel.gob.cl/equipos-de-alcance-reducido/

Texas Instruments. (2018). *DRV2605L: 2- to 5.2-V haptic driver for LRA and ERM with effect library and Smart-Loop architecture* [Hoja de datos]. https://www.ti.com/lit/ds/symlink/drv2605l.pdf

World Wide Web Consortium. (s. f.). *Understanding success criterion 2.3.1: Three flashes or below threshold*. Recuperado el 24 de agosto de 2026, de https://www.w3.org/WAI/WCAG22/Understanding/three-flashes-or-below-threshold

## Registro de cambios (disclaimer)

### 2026-08-24 — Creación de los capítulos 11 y 12

- **Cambio:** se creó este archivo con la arquitectura de experiencia y flujos; la producción, factibilidad y el modelo de gestión de Relevo.
- **Versión anterior:** no existía un bloque consolidado para estos capítulos. Los flujos de usuario, sistema, técnica y diseño, junto con factibilidad, producción, costos, mantenimiento y gestión, estaban distribuidos entre `memoria-vigente.md`, sus anexos técnicos, `05_propuesta_phygital`, `06_desarrollo_y_factibilidad` y la auditoría de sistema.
- **Motivo:** hacer auditable la relación entre experiencia, implementación y gestión; separar arquitectura mínima de arquitectura aspiracional; distinguir fallos conceptuales, perceptivos, técnicos y de convivencia; y evitar que hipótesis técnicas o económicas se lean como resultados.
- **Contenido incorporado:** precondiciones, estados, puertas, configuración, vínculo, prueba del lugar, armado, evaluación de condición, comando con vencimiento, señal, silencio, continuación, reposo y rearmado; manejo de permisos, batería, desconexión, cambio de aplicación, pantalla bloqueada, reinicios, objeto movido y señal tardía; accesibilidad por dimensiones visual, auditiva, táctil, cognitiva, motora y doméstica; mapa de datos y privacidad; etapas de prototipo; candidatos de electrónica y materiales; fabricación, ensamblaje, pruebas, reparación y fin de vida; separación de costos; actores, recursos, hitos, riesgos, cumplimiento, mantenimiento y criterios de escala o abandono de una dirección física.
- **Corrección económica:** se documenta como planificación un rango aproximado de CLP 59.000–107.000. La base es CLP 51.140–92.640; con una contingencia del 15 % resulta CLP 58.811–106.536, redondeado. No se presenta como cotización. El costo del prototipo, trabajo profesional, producción y precio quedan separados; el precio directo no se utiliza como argumento principal.
- **Versión anterior, nueva formulación y motivo:** la versión anterior consignaba CLP 58.000–112.000, derivado de una suma aritmética errónea introducida en la auditoría. La nueva formulación usa la base corregida, aplica explícitamente la contingencia y redondea a CLP 59.000–107.000 para evitar presentar una base de costos falsa como factibilidad.
- **Alcance y límites:** Android, BLE, batería, autonomía, canales, accesibilidad, producción, certificación, reparación y escala se presentan como hipótesis, requisitos o pendientes según corresponda. No se agregaron desempeños, costos cotizados, preferencias, resultados de usuarios ni validaciones técnicas. Relevo se mantiene phygital y el objeto no incorpora pantalla.
- **Fuentes añadidas al bloque:** se incorporaron referencias APA 7 de documentación Android, requisitos de distribución, componentes técnicos, prototipado, cumplimiento de equipos de alcance reducido y criterio preventivo de destellos. Deben reconciliarse con la bibliografía general para evitar duplicados.
- **Corrección editorial final:** se reemplazó “app” por “aplicación” y se precisó que el abandono se refiere a la dirección física actual, no al carácter phygital ni a la ausencia de pantalla.
- **Archivos afectados:** solo `08_memoria/borradores-v2/06-flujos-factibilidad.md`. No se modificaron otros archivos, no se alteró `memoria-vigente.md` y no se realizó commit ni push.
