# Aplicación del feedback docente del 23 de septiembre de 2026

> **Actualización del 25 de septiembre de 2026:** el seguimiento de 21 días, antes no incorporado, fue adoptado por el autor como prueba principal (D-075 y D-079, [protocolo 02](../07_validacion/protocolo-02-prueba-21-dias.md)), y el refuerzo se orienta sin rachas ni patrones oscuros (D-074). Lo que sigue describe el estado del 23 de septiembre.

**Fuente de trabajo:** [síntesis de las anotaciones](../02_investigacion/sintesis-anotaciones-2026-09-23.md), [revisión sobre hábitos y rachas](../02_investigacion/habitos-reconocimiento-y-rachas-2026-09-23.md), [auditoría de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) y [estudio de la ruta de audio](../06_desarrollo_y_factibilidad/enrutamiento-audio-parlante-exclusivo-2026-09-23.md). Este registro distingue cambios realizados, decisiones pospuestas y comprobaciones necesarias. Una anotación de clase no equivale a un resultado de prueba.

## Cambios incorporados

| Observación | Decisión aplicada | Dónde comprobarla |
| --- | --- | --- |
| Acompañar la intención sin afirmar que el sistema crea hábitos. | La memoria distingue intención recordada, actividad iniciada y automaticidad. Un piloto de dos días se presenta como prueba de uso, no como demostración de hábito. | [Memoria vigente, capítulos 6 y 13](../08_memoria/memoria-vigente-v4.md). |
| Considerar reconocimiento positivo sin convertir la actividad en obligación. | Android 2.5 muestra un reconocimiento breve cuando la persona declara «Comencé la actividad». No lo llama éxito verificado ni asigna puntajes o rachas; otras respuestas no reciben reproche. | [RU-13](../03_usuarios/matriz-requisitos-de-usuarios.md), [app](../06_desarrollo_y_factibilidad/app-android/README.md) y [memoria, capítulos 9 y 10](../08_memoria/memoria-vigente-v4.md). |
| Explicar con precisión qué datos se guardan. | La memoria ya no describe el prototipo como exclusivamente local o anónimo: diferencia registros en el teléfono y sincronización remota seudonimizada. | [Memoria, capítulos 11 y 13](../08_memoria/memoria-vigente-v4.md) y [auditoría de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md). |
| No confundir un parlante conectado con el objeto controlado por Relevo. | La factibilidad distingue el parlante Bluetooth multimedia usado en el prototipo de la arquitectura de orden breve prevista para un testigo. No afirma separación de audio ni funcionamiento físico comprobado. | [Memoria, capítulo 12](../08_memoria/memoria-vigente-v4.md) y [análisis de audio](../06_desarrollo_y_factibilidad/enrutamiento-audio-parlante-exclusivo-2026-09-23.md). |
| No presentar la respuesta de la persona como actividad observada. | El indicador de Inicio dice «Dijiste que empezaste». Cuenta las respuestas «Comencé la actividad» después de una señal, sin afirmar que el sistema verificó la actividad. Se compiló el APK 2.5 y pasaron siete pruebas unitarias; no se ha probado con un parlante real. | [App Android y descarga](../06_desarrollo_y_factibilidad/app-android/README.md). |
| Preparar una evaluación que mida comprensión, carga y control sin confundirlos con fallos técnicos. | Se actualizaron la pauta y la ficha en blanco para Android 2.5. Incluyen tareas observables, preguntas breves y condiciones de consentimiento y privacidad. No son resultados ni autorización de reclutamiento. | [Pauta](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) y [ficha](../07_validacion/ficha-testeo-prototipo-android-2026-09-23.md). |
| Volver un paso, mantener los controles y explicar permisos. | Android 2.5 admite el gesto de regreso durante tutorial y preparación; el botón principal conserva lugar. Tiempo de uso debe concederse antes de terminar el tutorial y las notificaciones se explican como opcionales. | [App Android](../06_desarrollo_y_factibilidad/app-android/README.md) y [criterios de revisión](../06_desarrollo_y_factibilidad/app-android/criterios-revision-interfaz-2026-09-23.md). |
| Dar una vía para consultar o retirar datos. | El correo y la fecha límite constan en el consentimiento; Historial muestra un código estable entre relevos. El borrado integral continúa sin verificación, por lo que no se autoriza aún el testeo con participantes. | [Privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) y [consentimiento Android](../07_validacion/consentimiento-android-vigente-2026-09-23.md). |

## Opciones estudiadas, no incorporadas

- **Rachas y premios:** pueden influir en la participación, pero Relevo no verifica la actividad fuera del teléfono y una racha podría convertirse en un objetivo distinto. Antes de diseñarla habría que definir qué registra, para quién aporta valor, cómo se pausa y cómo se mide su carga. No es una prohibición científica universal ni una función aprobada.
- **Seguimiento de 21 días:** serviría para observar continuidad y molestias bajo otro consentimiento; no bastaría para declarar un hábito. Primero deben resolverse comprensión, fiabilidad y privacidad del prototipo actual.
- **Recordatorios tras días sin uso:** no se enviarán por defecto. Harían falta un criterio de inactividad comprensible, control de frecuencia, apagado y prueba de intrusión.
- **Varias aplicaciones, avatares o perfiles personales:** no se deducen de las ocho entrevistas. Se estudiarían solo si una dificultad observada justifica el costo de configuración y datos.
- **Compra de una placa como solución final:** las comparaciones de Atom Echo, micro:bit y otras opciones son investigación de factibilidad. Ninguna acredita autonomía de 8–12 horas, facilidad de uso ni audio separado con el APK actual.
- **Rediseño visual integral:** los cambios de navegación, progreso y tutorial de 2.5 son una revisión acotada. No prueban que el estilo guste o mejore el uso en un teléfono real; eso requiere inspección y prueba específica.

## Condiciones antes de testear con participantes

1. Comprobar que el correo confirmado funciona y alinear los textos del consentimiento en papel y en la aplicación; el paquete Word fechado aún conserva el contacto en blanco.
2. Demostrar que una sesión puede localizarse por el código entregado y eliminarse en el teléfono y en la base remota.
3. Probar con el teléfono y parlante concretos la salida del sonido, el resto del audio del teléfono, el segundo plano, la desconexión y el silencio.
4. Revisar indicadores y protocolo con el docente; registrar versión de app, material y modificaciones antes de la primera sesión.

Las respuestas de participantes y resultados técnicos que todavía no existen no se presentan como avances completados. La [pauta de validación](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) debe mantenerse alineada con la versión de app utilizada.

## Registro de cambios (disclaimer)

### 2026-09-25 — Aviso de actualización

- **Qué cambió:** se añadió un aviso con las decisiones D-074, D-075 y D-079.
- **Cómo estaba antes:** el seguimiento de 21 días figuraba como no incorporado.
- **Por qué:** decisiones del autor del 25 de septiembre.

### 2026-09-23 — Revisión de la app 2.5

- **Qué se cambió:** el registro distingue funciones ya implementadas de ideas pospuestas, actualiza el contacto y mantiene la eliminación de datos como condición previa.
- **Cómo era antes:** el reconocimiento positivo figuraba solo como posibilidad, no se registraban el regreso por pasos ni el código estable y se pedía completar un correo ya confirmado.
- **Por qué:** hacer corresponder la decisión documentada con la app compilada sin confundir implementación con validación ante participantes.

### 2026-09-23 — Creación

- **Qué se cambió:** se convirtió la síntesis de observaciones en decisiones trazables, separando adopción, investigación y condiciones previas.
- **Cómo era antes:** los documentos recientes reunían fuentes, candidatos de texto y propuestas, pero no indicaban en un solo lugar qué modificaciones habían ingresado en memoria y requisitos.
- **Por qué:** evitar que una sugerencia docente o una comparación de mercado aparezca como función desarrollada o resultado empírico.
- **Alcance:** registro documental de decisiones. No sustituye pruebas con personas, revisión del consentimiento ni mediciones del objeto físico.

### 2026-09-23 — Verificación de implementación

- **Qué se cambió:** se registró el ajuste del indicador de la app y la sincronización de instrumentos con el APK 2.4.
- **Cómo era antes:** el registro recogía cambios en memoria y requisitos, pero aún no reflejaba la corrección de interfaz ni la pauta revisada.
- **Por qué:** permitir comprobar la misma decisión en el texto académico, el prototipo y la evaluación sin confundir compilación con validación física.
