# Revisión de la interfaz Android tras la corrección del 23 de septiembre

**Alcance:** decisiones para el prototipo de evaluación, no resultados con participantes. Actualizado para Android 2.6. Este documento se lee junto con el [resumen vigente](../../08_memoria/resumen-vigente-proyecto.md), la [síntesis del feedback](../../02_investigacion/sintesis-anotaciones-2026-09-23.md), la [auditoría de privacidad](../../07_validacion/privacidad-prototipo-android-2026-09-23.md) y la [cobertura de la corrección](revision-feedback-2026-09-23.md).

## Criterio rector

Relevo no premia minutos sin teléfono. Su función es presentar de nuevo una actividad elegida cuando se cumple una condición configurada. La persona puede comenzarla, dejarla para después o cambiar de idea. El texto y la navegación deben hacer visibles esas salidas sin convertirlas en una nota de rendimiento. Una respuesta en la app es una declaración de la persona, no prueba de lo que hizo fuera del teléfono.

## Decisiones para esta iteración

| Observación | Decisión y fundamento | Comprobación necesaria |
| --- | --- | --- |
| Volver un paso | Usar el gesto de regreso de Android y un control visible que lleven al mismo paso anterior. El contenido escrito debe conservarse. Un gesto estándar reduce la necesidad de aprender otro mecanismo (Android Developers, s. f.-a). | Retroceder y avanzar en tutorial, preparación, edición de actividad y selección de app sin saltar consentimiento ni perder datos. |
| Permiso de tiempo de uso | No dejar terminar el tutorial ni activar un relevo que depende del conteo si falta ese acceso. Explicar qué permite técnicamente Android y qué datos usa Relevo. El permiso de notificaciones se explica aparte; no se confunde con el consentimiento académico. | Conceder, denegar y revocar acceso en Android 12–16; comprobar el retorno desde Ajustes. |
| Acción principal | Mantener su posición al avanzar y al aparecer opciones secundarias. Nombrarla por la acción siguiente: «Elegir apps», «Revisar mi relevo» o «Activar relevo» cuando corresponda. El cambio de texto debe aclarar la tarea, no sorprender. | Revisar pantallas pequeñas, teclado abierto y escala de fuente ampliada. |
| Tutorial | Dar mayor espacio a la imagen cuando enseñe la actividad, el lugar o la señal. No ampliar por decoración ni centrar párrafos largos indiscriminadamente. Priorizar texto legible y controles visibles. | Pedir a personas que expliquen el flujo sin intervención del investigador; comprobar recortes y lectura ampliada. |
| Progreso | Una barra continua puede comunicar avance entre pasos sin crear la apariencia de varias tareas inconexas. La animación debe indicar un cambio real y respetar la preferencia de reducir movimiento (Android Developers, s. f.-b). | Volver atrás y comprobar que barra, número y contenido coincidan. |
| Navegación inferior | Mostrar icono sobre nombre y mantener ambos legibles. En el emulador, un desenfoque produjo una franja defectuosa: la versión 2.6 prioriza una superficie estable y legible antes que imitar un material de otro sistema. Los materiales de Apple sirven como referencia de capas funcionales, no como tecnología trasladable literalmente a Android (Apple, s. f.-a, s. f.-b). | Inspección en teléfono real, con fondos claros y fotografías, movimiento reducido y tamaño de letra ampliado. |
| Reconocimiento positivo | Tras «Comencé la actividad», reconocer de forma breve lo que la persona **declaró**, sin puntaje, racha ni deducción de éxito. Después de otras respuestas, mantener un tono neutral. El sistema no debe felicitar por no usar una app si no definió una meta ni verificó su significado. | Preguntar si el mensaje se siente alentador, infantilizante o presionante; corregir el texto según lo observado. |
| Regreso después de días | La versión 2.6 muestra la última actividad si la persona vuelve al menos dos días después de un relevo registrado, sin rearmarlo ni enviar avisos por defecto. Si había un ciclo activo, ofrece un acceso a él. Todavía no indica con certeza si el monitoreo se interrumpió mientras la app estuvo cerrada. | Probar reapertura, pérdida de permisos y continuidad real del servicio; no prometer vigilancia si se detuvo. |

Los controles personalizados deben mantener un área táctil de al menos 48 dp y un nombre accesible; la jerarquía de texto debe sobrevivir a tamaños de fuente mayores (Android Developers, s. f.-c). «Más animación» no significa más pasos, espera artificial o pérdida de control.

## Lo que ya existe y lo que no se incorpora ahora

La versión anterior ya conserva actividades creadas por la persona y permite responder al cierre con una sola pulsación u omitir la respuesta. La versión 2.6 amplió las propuestas predefinidas y permite seleccionar varias apps con un único límite de tiempo. Esas funciones requieren prueba de uso, no solo implementación. El tiempo configurado es un umbral elegido, no una recomendación de cuánto debería durar el ocio.

No se añaden perfiles de personalidad para recopilar más datos, rachas, avisos tras días sin uso ni una supuesta medición de hábitos. Cada propuesta aumenta datos, configuraciones o inferencias. La selección múltiple sí se incorporó porque las entrevistas describen alternancia entre aplicaciones y se mantiene una regla simple: sumar los tiempos. Antes de interpretar cualquier mejora personal debe haber una dificultad observada, una hipótesis de mejora y consentimiento acorde. Un estudio de 21 días podría observar continuidad de uso, pero no demostrar automáticamente un hábito. El parlante Bluetooth no es el objeto final; una salida solo por teléfono sirve como comparación y no prueba el aporte phygital.

## Referencias

Android Developers. (s. f.-a). *About predictive back*. https://developer.android.com/develop/ui/compose/system/predictive-back

Android Developers. (s. f.-b). *Progress indicators in Jetpack Compose*. https://developer.android.com/develop/ui/compose/components/progress

Android Developers. (s. f.-c). *API defaults*. https://developer.android.com/develop/ui/compose/accessibility/api-defaults

Apple. (s. f.-a). *Materials*. https://developer.apple.com/design/human-interface-guidelines/materials

Apple. (s. f.-b). *Tab bars*. https://developer.apple.com/design/human-interface-guidelines/tab-bars

## Registro de cambios (disclaimer)

### 2026-09-24 — Ajuste tras Android 2.6

- **Qué cambió:** se registran la selección múltiple, la alternativa de salida telefónica, el regreso tras varios días y la corrección del efecto de navegación.
- **Cómo era antes:** el documento negaba la selección de varias apps y describía una navegación con desenfoque que resultó defectuosa.
- **Por qué:** mantener los criterios de interfaz alineados con el prototipo y separar implementación de validación.

### 2026-09-23 — Límite de regreso prolongado

- **Qué cambió:** se señaló que el regreso después de días sigue pendiente de comprobación y comunicación de interrupciones.
- **Cómo era antes:** la fila podía leerse como si la versión 2.5 ya resolviera por completo ese caso.
- **Por qué:** no prometer un conteo continuo que aún no se ha probado fuera de la app.

### 2026-09-23 — Primera redacción

- **Qué cambió:** se convirtió el feedback en decisiones de interfaz, pruebas necesarias y propuestas que no deben presentarse como funciones actuales.
- **Cómo era antes:** las anotaciones, la memoria y la app describían prioridades en lugares distintos; no había una pauta breve que enlazara cada observación de interfaz con una justificación y su comprobación.
- **Por qué:** evitar que una corrección estética o una idea de seguimiento pase directamente al producto sin distinguir funcionamiento, preferencia y evidencia.
- **Alcance:** decisiones para implementar y revisar; no certifica calidad visual ni resultados con usuarios.
