# Aplicación del feedback docente del 23 de septiembre de 2026

**Fuente de trabajo:** [síntesis de las anotaciones](../02_investigacion/sintesis-anotaciones-2026-09-23.md), [revisión sobre hábitos y rachas](../02_investigacion/habitos-reconocimiento-y-rachas-2026-09-23.md), [auditoría de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) y [estudio de la ruta de audio](../06_desarrollo_y_factibilidad/enrutamiento-audio-parlante-exclusivo-2026-09-23.md). Este registro distingue cambios realizados, decisiones pospuestas y comprobaciones necesarias. Una anotación de clase no equivale a un resultado de prueba.

## Cambios incorporados

| Observación | Decisión aplicada | Dónde comprobarla |
| --- | --- | --- |
| Acompañar la intención sin afirmar que el sistema crea hábitos. | La memoria distingue intención recordada, actividad iniciada y automaticidad. Un piloto de dos días se presenta como prueba de uso, no como demostración de hábito. | [Memoria vigente, capítulos 6 y 13](../08_memoria/memoria-vigente-v4.md). |
| Considerar reconocimiento positivo sin convertir la actividad en obligación. | RU-13 admite estudiar un mensaje sobre hechos que el sistema conoce; mantiene fuera del prototipo los puntajes, las rachas y los premios. No clasifica como éxito o fracaso una decisión posterior. | [RU-13](../03_usuarios/matriz-requisitos-de-usuarios.md) y [memoria, capítulos 9 y 10](../08_memoria/memoria-vigente-v4.md). |
| Explicar con precisión qué datos se guardan. | La memoria ya no describe el prototipo como exclusivamente local o anónimo: diferencia registros en el teléfono y sincronización remota seudonimizada. | [Memoria, capítulos 11 y 13](../08_memoria/memoria-vigente-v4.md) y [auditoría de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md). |
| No confundir un parlante conectado con el objeto controlado por Relevo. | La factibilidad distingue el parlante Bluetooth multimedia usado en el prototipo de la arquitectura de orden breve prevista para un testigo. No afirma separación de audio ni funcionamiento físico comprobado. | [Memoria, capítulo 12](../08_memoria/memoria-vigente-v4.md) y [análisis de audio](../06_desarrollo_y_factibilidad/enrutamiento-audio-parlante-exclusivo-2026-09-23.md). |
| No presentar la respuesta de la persona como actividad observada. | El indicador de Inicio ahora dice «Dijiste que empezaste». Cuenta las respuestas «Comencé la actividad» después de una señal, sin afirmar que el sistema verificó la actividad. Se compiló el APK 2.4 y pasaron siete pruebas unitarias; no se ha probado con un parlante real. | [App Android y descarga](../06_desarrollo_y_factibilidad/app-android/README.md). |
| Preparar una evaluación que mida comprensión, carga y control sin confundirlos con fallos técnicos. | Se actualizaron la pauta y la ficha en blanco para Android 2.4. Incluyen tareas observables, preguntas breves y condiciones de consentimiento y privacidad. No son resultados ni autorización de reclutamiento. | [Pauta](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) y [ficha](../07_validacion/ficha-testeo-prototipo-android-2026-09-23.md). |

## Opciones estudiadas, no incorporadas

- **Rachas y premios:** pueden influir en la participación, pero Relevo no verifica la actividad fuera del teléfono y una racha podría convertirse en un objetivo distinto. Antes de diseñarla habría que definir qué registra, para quién aporta valor, cómo se pausa y cómo se mide su carga. No es una prohibición científica universal ni una función aprobada.
- **Seguimiento de 21 días:** serviría para observar continuidad y molestias bajo otro consentimiento; no bastaría para declarar un hábito. Primero deben resolverse comprensión, fiabilidad y privacidad del prototipo actual.
- **Recordatorios tras días sin uso:** no se enviarán por defecto. Harían falta un criterio de inactividad comprensible, control de frecuencia, apagado y prueba de intrusión.
- **Varias aplicaciones, avatares o perfiles personales:** no se deducen de las ocho entrevistas. Se estudiarían solo si una dificultad observada justifica el costo de configuración y datos.
- **Compra de una placa como solución final:** las comparaciones de Atom Echo, micro:bit y otras opciones son investigación de factibilidad. Ninguna acredita autonomía de 8–12 horas, facilidad de uso ni audio separado con el APK actual.
- **Nueva gráfica o efectos de interfaz:** las anotaciones orientan una auditoría en teléfonos reales. No se trasladan directamente a una regla estética o a una supuesta preferencia de usuario.

## Condiciones antes de testear con participantes

1. Completar contacto del responsable y alinear los textos del consentimiento en papel y en la aplicación.
2. Demostrar que una sesión puede localizarse por el código entregado y eliminarse en el teléfono y en la base remota.
3. Probar con el teléfono y parlante concretos la salida del sonido, el resto del audio del teléfono, el segundo plano, la desconexión y el silencio.
4. Revisar indicadores y protocolo con el docente; registrar versión de app, material y modificaciones antes de la primera sesión.

Las respuestas de participantes y resultados técnicos que todavía no existen no se presentan como avances completados. La [pauta de validación](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) debe mantenerse alineada con la versión de app utilizada.

## Registro de cambios (disclaimer)

### 2026-09-23 — Creación

- **Qué se cambió:** se convirtió la síntesis de observaciones en decisiones trazables, separando adopción, investigación y condiciones previas.
- **Cómo era antes:** los documentos recientes reunían fuentes, candidatos de texto y propuestas, pero no indicaban en un solo lugar qué modificaciones habían ingresado en memoria y requisitos.
- **Por qué:** evitar que una sugerencia docente o una comparación de mercado aparezca como función desarrollada o resultado empírico.
- **Alcance:** registro documental de decisiones. No sustituye pruebas con personas, revisión del consentimiento ni mediciones del objeto físico.

### 2026-09-23 — Verificación de implementación

- **Qué se cambió:** se registró el ajuste del indicador de la app y la sincronización de instrumentos con el APK 2.4.
- **Cómo era antes:** el registro recogía cambios en memoria y requisitos, pero aún no reflejaba la corrección de interfaz ni la pauta revisada.
- **Por qué:** permitir comprobar la misma decisión en el texto académico, el prototipo y la evaluación sin confundir compilación con validación física.
