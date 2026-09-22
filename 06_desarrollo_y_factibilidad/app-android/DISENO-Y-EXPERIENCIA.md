# Diseño de la experiencia Android de Relevo

**Estado:** versión 1.9, revisión visual y funcional del 22 de septiembre de 2026. Es una dirección implementada, no una validación con usuarios.

## Qué debe sentirse al usarla

Relevo acompaña una decisión personal; no califica el tiempo de pantalla ni castiga el uso de una aplicación. Por eso el recorrido evita contadores de culpa, mensajes de productividad y urgencia visual. La persona puede preparar una actividad, elegir una app y un tiempo, dejar un parlante en el lugar previsto y recibir una señal. La pantalla final pregunta qué decidió hacer sin presentar ninguna respuesta como correcta.

## Referentes examinados

Los Apple Design Awards de 2026 distinguen por separado interacción, inclusión, deleite y gráfica. *grug* fue reconocido por convertir una idea pequeña en un momento de reflexión; *Tide Guide*, por presentar datos temporales con claridad mediante una gráfica propia (Apple, 2026). No son modelos para copiar: en Relevo estas observaciones se traducen en un momento principal claramente identificable y en información de tiempo legible. La guía de movimiento de Apple (2025) recomienda que la animación explique cambios de estado sin demorar la tarea ni volverse un fin en sí misma. Android (s. f.) recomienda superficies táctiles de al menos 48 dp y comprobar la semántica de los elementos personalizados.

## Decisiones aplicadas

| Área | Decisión | Motivo y comprobación pendiente |
| --- | --- | --- |
| Inicio | Una acción protagonista, seguida de datos de uso y acceso al historial. | La preparación es la tarea más importante; los datos no deben competir con ella. Comprobar si se entiende que la tarjeta completa abre la configuración. |
| Configuración | Actividad y forma de empezar antes de app y tiempo; botón de activación fijo al pie que explica qué falta si está inactivo. | Primero se define qué quiere hacer la persona, luego cuándo necesita la señal. El botón permanece disponible al desplazarse sin tapar los campos. |
| Espera | Tiempo acumulado visible junto con la app elegida y el lugar del parlante. | Se distingue el avance de la actividad deseada; el conteo no se presenta como objetivo moral. |
| Señal | La actividad ocupa la mayor jerarquía; el inicio concreto aparece inmediatamente debajo. | La persona puede reconocer lo que quería hacer sin descifrar una gráfica. |
| Cierre | Pregunta neutral y respuesta opcional. | Evita interpretar la decisión de la persona como éxito o fracaso. |
| Navegación | Inicio, Actividad y Relevos muestran siempre icono y nombre. | Un icono solo puede ser ambiguo; los tres destinos deben poder reconocerse sin ensayo y error. |
| Estados vacíos | Actividad y Relevos explican qué aparecerá allí y ofrecen preparar el primer relevo. | Evitan un contador sin contexto o datos inventados; la ilustración abstracta acompaña, pero el texto y el botón contienen la información y la acción. |
| Movimiento | Transiciones breves entre estados; se omiten cuando Android desactiva las animaciones. | El movimiento aporta continuidad, pero no contiene información indispensable. |
| Sonido | La prueba del parlante dura unos segundos y comunica si no hay una salida Bluetooth confirmada. | Una prueba no debe quedar sonando indefinidamente; el resultado debe ser visible además de audible. |
| Identificación | El ícono reúne un punto coral y dos anillos sobre verde; reemplaza el ícono de plantilla de Android. | Retoma el momento de señal de la interfaz y permite reconocer la app desde el sistema sin ilustrar un teléfono ni prometer una forma física definitiva. |

## Sistema de interfaz

La tipografía instalada es Source Sans 3, con cuatro pesos. Se usa una escala amplia para la actividad y títulos; los datos y acciones conservan texto legible en lugar de convertirse en microetiquetas. El fondo cálido (`#F8FAF8`) permite separar contenido sin sombras intensas. El verde (`#087A69`) identifica acciones y estados activos; el coral (`#F47F68`) se reserva para el foco de la señal. Ninguno de estos colores sustituye un texto de estado. Son códigos de interfaz vigentes en esta versión, no una afirmación de que el color tenga un significado universal para los usuarios.

Los círculos concéntricos aparecen solo en la acción principal y la señal. Representan un aviso que llega a un lugar concreto; no son botones ni decoración superpuesta a opciones. Las superficies secundarias son planas, con borde tenue, para que la jerarquía dependa del contenido y no de elevaciones artificiales. Aunque la aplicación usa Jetpack Compose y algunas primitivas de su biblioteca de componentes, los elementos visibles se configuran con tamaños, color, espaciado y comportamiento propios de Relevo; no se presenta como una adaptación del estilo visual Material.

## Verificación realizada y límites

La versión 1.9 compiló y pasó las pruebas unitarias. Se abrió en un emulador Android de 1080 × 2400 píxeles y se inspeccionaron consentimiento, tutorial, inicio y configuración. Esto permite detectar desbordes y problemas de jerarquía, pero no demuestra comprensión real, accesibilidad completa ni calidad percibida. Antes de cerrar el diseño deben verificarse, con personas y dispositivos físicos, cinco tareas: comprender Relevo sin explicación externa, preparar un relevo, encontrar y probar el parlante, entender el conteo en espera y responder o saltar el cierre. También falta probar texto ampliado, TalkBack, pantallas pequeñas y la ruta real de audio Bluetooth.

## Referencias

Android Developers. (s. f.). *API defaults*. https://developer.android.com/develop/ui/compose/accessibility/api-defaults

Apple. (2026, 2 de junio). *Apple reveals winners of the 2026 Apple Design Awards*. https://www.apple.com/ie/newsroom/2026/06/apple-reveals-winners-of-the-2026-apple-design-awards/

Apple Developer. (2025). *Motion*. https://developer.apple.com/design/human-interface-guidelines/motion

## Registro de cambios (disclaimer)

- **Documento nuevo:** registra el criterio y el estado de la interfaz Android 1.9.
- **Antes:** la información sobre diseño estaba dispersa entre el código y el README; no existía aquí una relación directa entre referentes, decisiones y pruebas pendientes. El ícono aún era el de plantilla de Android.
- **Motivo:** permitir evaluar y corregir la experiencia sin confundir una pantalla atractiva con una solución ya validada.
