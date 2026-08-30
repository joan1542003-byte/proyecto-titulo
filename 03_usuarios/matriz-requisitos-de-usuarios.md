# Matriz de requisitos derivados de usuarios

## Propósito

Esta matriz conecta los hallazgos del estudio cualitativo con necesidades, requisitos, límites y pruebas. Su función es impedir que una decisión de interfaz, objeto o comportamiento se presente como evidente sin mostrar qué la origina y cómo deberá comprobarse.

La matriz se lee junto con los [perfiles situacionales](perfiles-situacionales.md), los [recorridos](recorridos-situacionales.md), los criterios del capítulo 9 de la [memoria v4](../08_memoria/memoria-vigente-v4.md#9-criterios-de-diseño) y el [protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md).

## Clasificaciones

### Tipo de origen

- **E — Entrevistas:** hallazgo declarado dentro de P1–P8.
- **T — Teoría:** criterio respaldado por bibliografía de la memoria.
- **M — Mercado:** aprendizaje o límite derivado del estado del arte.
- **P — Proyecto:** decisión necesaria para convertir los hallazgos en una arquitectura comprobable.

Una fila puede combinar orígenes. La combinación no transforma una hipótesis proyectual en resultado de entrevista.

### Prioridad

- **P0 — Esencial:** protege la hipótesis, la autonomía o la pertinencia. Un fallo obliga a modificar o detener la configuración.
- **P1 — Necesario:** permite comprender, controlar y sostener el ciclo. Debe resolverse antes del prototipo integrado final.
- **P2 — Complementario:** mejora adopción, mantenimiento o ampliación, pero no precede a las pruebas centrales.

### Estado

Todos los requisitos se encuentran **especificados y pendientes de validación**, salvo cuando la columna indica que existe únicamente una representación estructural en wireframes. Ninguna fila acredita resultados de uso.

## Matriz principal

| ID | Origen | Hallazgo | Necesidad U1/U2 | Requisito verificable | Límite o no intervención | Evidencia y confianza | Prioridad | Método de validación | Estado |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| RU-01 | E + T | Duración, aplicación y recuerdo no distinguen por sí solos una sesión pertinente. U1 aparece cuando existe una intención alternativa; U2 cuando no existe o perdió vigencia. | U1: conservar una intención propia. U2: no recibir apoyo sin contenido legítimo. | El ciclo debe comenzar con una intención formulada explícitamente por la persona y no crearla de manera automática. | Sin intención registrada no se arma ni emite señal. | P2–P3 y P6–P8, Q3–Q10; confianza alta para la frontera situacional. | P0 | Recorrido guiado y prueba de comprensión: identificar quién formuló la intención y cuándo el sistema permanece inactivo. | Representado; no validado. |
| RU-02 | T + P, con apoyo E | Las actividades valoradas suelen expresarse como metas amplias; recordar una meta no asegura reconocer cómo comenzar. | U1: reducir la distancia entre intención y comienzo sin imponer la actividad. | La configuración debe vincular cada intención con un primer paso concreto que la persona pueda explicar con sus propias palabras. | El primer paso no se interpreta como obligación ni como actividad cumplida. | P2, Q9–Q10; P3, Q9–Q10; teoría de intenciones de implementación; confianza media como derivación. | P0 | Protocolo 01, fase A: recuperación correcta de intención y primer paso sin consultar el teléfono. | Representado; no validado. |
| RU-03 | E | P6, P7 y P8 muestran episodios extensos o rutinarios que conservan sentido. | U2: proteger ocio elegido, relacional, concentrado o reparador. | La activación debe depender de un ciclo voluntario vigente, no de una regla universal aplicada a todo uso digital. | Permanecer inactivo es una respuesta correcta cuando no existe una intención alternativa configurada. | P6–P8, Q3–Q13; confianza alta dentro del corpus. | P0 | Pruebas de escenarios U2: reconocer casos donde no corresponde armar o donde debe cerrarse el ciclo. | Especificado; no validado. |
| RU-04 | E + T | P4 y P6 cambian de patrón según la actividad; P2 recuerda con claridad y P8 no presenta conflicto pese al recuerdo débil. | U1/U2: ser tratados según el episodio y la intención, no mediante una etiqueta permanente. | La aplicación no debe presentar tiempo, aplicación, recuerdo o categoría de contenido como diagnóstico de distracción, pérdida de control o calidad del ocio. | Ningún dato técnico autoriza a clasificar automáticamente a la persona como U1. | P2, P4, P6 y P8, Q3–Q13; confianza alta. | P0 | Auditoría de contenido y pruebas de comprensión de mensajes, estados y permisos. | Parcialmente representado; no validado. |
| RU-05 | T + P | Una condición técnica puede observar tiempo, horario o continuidad, pero no estados subjetivos. | U1: comprender por qué podría aparecer una señal. U2: cambiar o retirar una regla que ya no corresponde. | La condición de activación debe describir un evento observable, mostrar su vigencia y permitir modificación o desarme. | No utilizar expresiones que afirmen detectar aburrimiento, culpa, distracción o satisfacción. | Capítulos 6.2.4 y 9.3 de la memoria; variación P1–P8; confianza alta como límite, condición específica abierta. | P0 | Prueba de paráfrasis: explicar qué observa la regla, qué no conoce y cómo cambiarla. Prueba técnica posterior de vigencia. | Estructura representada; alternativa pendiente. |
| RU-06 | E + T + M | Las personas aceptan apoyo condicionado y rechazan evaluación, castigo o rigidez. | U1: reconsiderar sin obedecer. U2: continuar o detener una intervención improcedente. | En configuración, espera y señal deben existir salidas comprensibles para editar, cancelar, desarmar, ignorar, silenciar, continuar o cerrar. | Ninguna salida se registra o comunica como incumplimiento. | P2–P8, Q13; literatura de autonomía y límites de bloqueadores; confianza media-alta porque Q13 se refería al concepto anterior. | P0 | Protocolo 01: explicar al menos dos salidas sin presentar una como obligatoria; pruebas de flujo y recuperación. | Representado; no validado. |
| RU-07 | P + T | El núcleo requiere que una señal externa permita recuperar intención y primer paso sin reabrir el teléfono. | U1: reconocer la intención en el momento pertinente con una carga acotada. | Después del pulso, la persona debe poder identificar intención y primer paso sin consultar la aplicación ni recibir pistas sobre el contenido. | Percibir el pulso sin recuperar la intención se registra como asociación parcial, no como éxito. | Memoria prospectiva y criterios 9.2/9.8; no existe evidencia de uso de Relevo. | P0 | Protocolo 01, cadena percepción → atribución → recuperación → primer paso → control. | Hipótesis central; no validada. |
| RU-08 | E + T | Se prefieren señales tranquilas, discretas o visuales y se rechazan notas o comparaciones; el hogar introduce convivencia y exposición. | U1: percibir apoyo. U2 y convivientes: evitar molestia o revelación de información personal. | El objeto no debe exponer el texto de la intención; el pulso debe poder detenerse y ajustarse a condiciones de percepción y convivencia. | Una señal invasiva o que revele contenido constituye fallo crítico. | P3–P5 y P7–P8, Q13; Q13 orienta, no valida Relevo; confianza media. | P0 | Prueba situada de percepción, intrusión y control; inspección de contenido visible y audible. | Especificado; canal abierto. |
| RU-09 | E + T + P | Alejar, guardar o cargar el teléfono muestra que el espacio ya participa en estrategias, pero no se observaron viviendas. | U1: relacionar la intención con un lugar significativo. U2: modificar el lugar si cambia el contexto. | La persona debe elegir manualmente la ubicación y repetir la prueba del pulso cuando el objeto se mueve. | El sistema no infiere el lugar ni supone que una ubicación funciona en todos los hogares. | P1–P5 y P7–P8, Q12; marco espacial; confianza alta para estrategias declaradas y baja para eficacia del lugar. | P0 | Protocolo 01, comparación entre lugar relacionado, lugar neutro y notificación; prueba de objeto movido. | Representado; aporte no validado. |
| RU-10 | E + T + M | P5 y P8 anticipan extrañeza o fricción inicial; la literatura y el mercado muestran costos de configuración y mantenimiento. | U1/U2: decidir si el esfuerzo agregado ofrece valor suficiente. | El recorrido debe permitir completar, abandonar o retomar la preparación y reducir pasos que no aporten comprensión, seguridad o funcionamiento. | Si configuración, vínculo, ubicación y rearme superan el beneficio percibido, el alcance debe simplificarse. | P5 y P8, Q13; Chiu y Gilbert (2024); referentes de mercado; confianza media. | P1 | Prueba de tareas, tiempo, errores, abandonos y entrevista de carga; comparación con notificación. | Representado; carga no medida. |
| RU-11 | E + T | Las preferencias declaradas varían entre señal visual y señal tranquila; un único canal puede excluir o pasar inadvertido. | U1: percibir la señal. U2/convivientes: evitar intensidad innecesaria. | La evaluación debe ofrecer una alternativa perceptiva razonable y no depender solo del color para comunicar estado o control. | Si no existe alternativa accesible sin volver invasiva la señal, la configuración probada debe detenerse. | P3–P5 y P7–P8, Q13; criterios de accesibilidad; confianza media, sin prueba funcional. | P1 | Comparación de modalidades después de P0; prueba en condiciones de iluminación/ruido y revisión de contraste y controles. | Criterio especificado; canal abierto. |
| RU-12 | P + T | Permisos, vínculo, batería, ejecución en segundo plano y vencimiento pueden fallar sin relación con la decisión personal. | U1/U2: saber si el ciclo puede funcionar y recuperar control ante un fallo. | La aplicación debe diferenciar estado técnico de intención personal, informar cuando no puede evaluar la condición y ofrecer recuperación o desarme. | No simular que una condición fue comprobada ni emitir órdenes vencidas. | Capítulos 11.2, 11.6 y 12.1–12.2; no deriva directamente de entrevistas. | P1 | Pruebas técnicas y de comprensión: permiso revocado, pérdida de enlace, batería baja, reinicio, restricción en segundo plano y orden tardía. | Estados representados; no implementados. |
| RU-13 | E + T | P7 rechaza notas y comparaciones; otros casos muestran culpa o normas de productividad que el proyecto no debe reforzar. | U1: recibir apoyo sin evaluación. U2: mantener legitimidad del ocio. | Relevo no debe utilizar puntajes, rachas, recompensas, comparaciones entre días ni historial de cumplimiento. | La acción posterior al pulso no se clasifica como éxito o fracaso del usuario. | P3, P5 y P7–P8, Q9–Q13; confianza media-alta para el límite ético. | P0 | Auditoría funcional y de contenido; comprobación de almacenamiento y ficha metodológica separada de datos del producto. | Especificado; no validado. |
| RU-14 | P + T | La intención puede cambiar, el contexto puede dejar de ser pertinente y una señal tardía pierde significado. | U1/U2: conservar control temporal y evitar intervenciones fuera de contexto. | Todo ciclo debe tener vigencia, cierre explícito y rearme voluntario; una orden vencida no debe activar el objeto. | No rearmar automáticamente ni conservar una regla como obligación permanente. | Arquitectura de estados 18, 22, 25–26 y 33–34; criterio de autonomía; evidencia empírica futura. | P1 | Pruebas de vencimiento, cambio de intención, desarme, orden tardía y rearme. | Representado; no implementado. |

## Puerta de decisión de la dimensión física

La siguiente condición no es un requisito atribuido a P1–P8, sino una exigencia de evaluación del proyecto:

| ID | Condición | Decisión asociada | Prueba |
| --- | --- | --- | --- |
| PE-01 | El objeto y el lugar deben aportar una diferencia reconocible frente a una notificación digital equivalente sin aumentar de manera desproporcionada intrusión, consulta del teléfono o carga. | Mantener, modificar o detener la configuración física probada. La decisión no determina que todo soporte físico funcione o fracase. | Protocolo 01, fase B: objeto situado, objeto neutro y notificación contrabalanceados. |

## Cobertura por perfil

| Requisito | U1 | U2 | Convivencia o sistema |
| --- | --- | --- | --- |
| RU-01–RU-02 | Conserva intención y comienzo. | Impide activar sin contenido propio. | — |
| RU-03–RU-05 | Delimita cuándo y por qué intervenir. | Protege episodios elegidos. | Evita inferencias subjetivas. |
| RU-06–RU-07 | Abre reconsideración y asociación. | Conserva la salida libre. | Separa comprensión de obediencia. |
| RU-08–RU-11 | Favorece percepción con carga razonable. | Evita intrusión. | Protege privacidad, accesibilidad y convivencia. |
| RU-12–RU-14 | Evita señales fuera de contexto. | Facilita desarme y cambio de idea. | Hace visibles fallos, vigencia y almacenamiento. |

## Correspondencia con la memoria v4

- El capítulo 7 respalda la distinción U1/U2, sus necesidades y los límites de no intervención.
- Los requisitos RU-01 a RU-14 desarrollan los criterios 9.1 a 9.8 sin añadir resultados.
- La formulación del capítulo 10 se mantiene: intención, primer paso, condición, señal, lugar y decisión libre.
- La bajada del capítulo 11 y los wireframes representan parte de los requisitos, pero no demuestran comprensión ni funcionamiento.
- PE-01 conserva la posibilidad de reformular la relación phygital si la notificación ofrece el mismo apoyo con menor carga.

## Regla de actualización

Después de cada prueba, una fila solo puede cambiar de estado si se enlaza la evidencia correspondiente. Una preferencia aislada puede orientar una iteración, pero no valida un requisito para toda la población. Si una prueba contradice un requisito P0, debe registrarse la decisión de modificar o detener antes de continuar con refinamiento visual o productivo.

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Creación de la matriz de requisitos

- **Cambio:** se conectaron hallazgos, necesidades, requisitos verificables, límites, evidencia P/Q, confianza, prioridad, método de validación y estado.
- **Versión anterior:** los criterios estaban trazados en la memoria y los requisitos podían reconstruirse desde perfiles, recorridos, wireframes y protocolos, pero no existía una matriz autónoma centrada en usuarios.
- **Motivo:** cerrar la traducción de la fase de usuarios y establecer qué debe protegerse, probarse o abandonarse antes de fabricar una solución completa.
- **Límite:** la matriz especifica condiciones; no presenta resultados de uso ni cierra canal, forma, condición de activación o valor de la dimensión física.
