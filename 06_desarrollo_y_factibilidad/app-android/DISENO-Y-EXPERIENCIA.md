# Diseño de la experiencia Android de Relevo

**Estado:** versión 2.1, revisión visual y funcional del 22 de septiembre de 2026. Es una dirección implementada, no una validación con usuarios.

## Qué debe sentirse al usarla

Relevo acompaña una decisión personal; no califica el tiempo de pantalla ni castiga el uso de una aplicación. Por eso el recorrido evita contadores de culpa, mensajes de productividad y urgencia visual. La persona puede preparar una actividad, elegir una app y un tiempo, dejar un parlante en el lugar previsto y recibir una señal. La pantalla final pregunta qué decidió hacer sin presentar ninguna respuesta como correcta.

## Referentes examinados

Los Apple Design Awards de 2026 distinguen por separado interacción, inclusión, deleite y gráfica. *grug* fue reconocido por convertir una idea pequeña en un momento de reflexión; *Tide Guide*, por presentar datos temporales con claridad mediante una gráfica propia (Apple, 2026). No son modelos para copiar: en Relevo estas observaciones se traducen en un momento principal claramente identificable y en información de tiempo legible. La guía de movimiento de Apple (2025) recomienda que la animación explique cambios de estado sin demorar la tarea ni volverse un fin en sí misma. Android (s. f.) recomienda superficies táctiles de al menos 48 dp y comprobar la semántica de los elementos personalizados.

La revisión de [Dribbble](https://dribbble.com/tags/best-app-design) sirvió como repertorio visual, no como prueba de usabilidad: allí predominan capturas aisladas que no muestran tareas completas. En el [intercambio de r/iOSProgramming](https://www.reddit.com/r/iOSProgramming/comments/1obpqg8/can_you_recommend_apps_with_great_design/) se mencionan, entre otras, Flighty y Mela por su claridad, y Wikipedia por sus transiciones discretas. Son opiniones de usuarios, no evaluaciones comparables. Lo aprovechable para Relevo es una hipótesis de diseño: dar presencia visual a la acción principal sin convertir toda la pantalla en espectáculo. La [guía de Apple sobre Liquid Glass](https://developer.apple.com/documentation/TechnologyOverviews/adopting-liquid-glass) sitúa la navegación en una capa diferenciada del contenido. En Android esta versión emplea una superficie translúcida con borde y selección nítida; no reproduce el material nativo de iOS ni afirma tener desenfoque de fondo real.

## Decisiones aplicadas

| Área | Decisión | Motivo y comprobación pendiente |
| --- | --- | --- |
| Inicio | Cuatro actividades reconocibles por imagen, una opción para escribir otra y datos de uso por debajo. | Los accesos rápidos reducen escritura sin obligar a aceptar una actividad predeterminada. Se debe comprobar si la fotografía facilita reconocer la acción o distrae. |
| Configuración | Actividad seleccionada, app y tiempo aparecen primero; el inicio concreto y el lugar del parlante siguen editables más abajo. El botón de activación explica qué falta si está inactivo. | La persona decide primero qué hará y cuándo quiere el aviso; los detalles no compiten con esa elección, pero se pueden revisar antes de activar. |
| Espera | Tiempo acumulado visible junto con la app elegida y el lugar del parlante. | Se distingue el avance de la actividad deseada; el conteo no se presenta como objetivo moral. |
| Señal | La actividad ocupa la mayor jerarquía; el inicio concreto aparece inmediatamente debajo. | La persona puede reconocer lo que quería hacer sin descifrar una gráfica. |
| Cierre | Pregunta neutral y respuesta opcional. | Evita interpretar la decisión de la persona como éxito o fracaso. |
| Navegación | Inicio, Actividad y Relevos conservan icono y nombre en una barra flotante dentro de Inicio. La preparación, espera, señal y cierre tienen navegación contextual. | Las pestañas no compiten con la tarea de preparar o atender una señal. Si Inicio vuelve a mostrarse con una sesión activa, conserva un acceso explícito a ella. |
| Historial | «Relevos exitosos» exige dos condiciones: señal emitida y respuesta «Comencé la actividad». | Un relevo cancelado o sin respuesta no prueba que la persona comenzó. Es un indicador autodeclarado, no una medición objetiva del comportamiento fuera del teléfono. |
| Estados vacíos | Actividad y Relevos explican qué aparecerá allí y ofrecen preparar el primer relevo. | Evitan un contador sin contexto o datos inventados; la ilustración abstracta acompaña, pero el texto y el botón contienen la información y la acción. |
| Movimiento | Transiciones breves entre estados; se omiten cuando Android desactiva las animaciones. | El movimiento aporta continuidad, pero no contiene información indispensable. |
| Sonido | La prueba del parlante dura unos segundos y comunica si no hay una salida Bluetooth confirmada. | Una prueba no debe quedar sonando indefinidamente; el resultado debe ser visible además de audible. |
| Identificación | El ícono reúne un punto coral y dos anillos sobre verde; reemplaza el ícono de plantilla de Android. | Retoma el momento de señal de la interfaz y permite reconocer la app desde el sistema sin ilustrar un teléfono ni prometer una forma física definitiva. |

## Sistema de interfaz

La tipografía instalada es Source Sans 3, con cuatro pesos. Se usa una escala amplia para la actividad y títulos; los datos y acciones conservan texto legible en lugar de convertirse en microetiquetas. El fondo cálido (`#F8FAF8`) permite separar contenido sin sombras intensas. El verde (`#087A69`) identifica acciones y estados activos; el coral (`#F47F68`) se reserva para el foco de la señal. Ninguno de estos colores sustituye un texto de estado. Son códigos de interfaz vigentes en esta versión, no una afirmación de que el color tenga un significado universal para los usuarios.

Los círculos concéntricos aparecen solo en la acción principal y la señal. Representan un aviso que llega a un lugar concreto; no son botones ni decoración superpuesta a opciones. Las superficies secundarias son planas, con borde tenue, para que la jerarquía dependa del contenido y no de elevaciones artificiales. Aunque la aplicación usa Jetpack Compose y algunas primitivas de su biblioteca de componentes, los elementos visibles se configuran con tamaños, color, espaciado y comportamiento propios de Relevo; no se presenta como una adaptación del estilo visual Material.

Las siete imágenes de actividad comparten una regla: un objeto asociado a la acción, sin personas ni marcas, fotografiado sobre fondo claro con luz de color suave. El nombre y la flecha son los elementos interactivos legibles; la foto funciona como reconocimiento rápido y no contiene instrucciones. Caminar usa zapatillas, entrenar pesas, leer un libro, estudiar un cuaderno, dibujar materiales de dibujo, cocinar ingredientes y ordenar textiles con cesta. La luz varía ligeramente para dar diversidad al conjunto, mientras el tratamiento fotográfico y el tamaño de tarjeta mantienen unidad. En Inicio se muestran cuatro opciones para no saturar; en Preparación aparecen las siete y siempre se puede escribir otra actividad.

## Verificación realizada y límites

La versión 2.0 compiló y pasó las pruebas unitarias y el análisis estático. Se abrió en un emulador Android de 1080 × 2400 píxeles y se inspeccionaron Inicio y Preparación. Esto permite detectar desbordes y problemas evidentes de jerarquía, pero no demuestra comprensión real, accesibilidad completa ni calidad percibida. Antes de cerrar el diseño deben verificarse, con personas y dispositivos físicos, cinco tareas: comprender Relevo sin explicación externa, preparar un relevo, encontrar y probar el parlante, entender el conteo en espera y responder o saltar el cierre. También falta probar texto ampliado, TalkBack, pantallas pequeñas y la ruta real de audio Bluetooth.

## Referencias

Android Developers. (s. f.). *API defaults*. https://developer.android.com/develop/ui/compose/accessibility/api-defaults

Apple. (2026, 2 de junio). *Apple reveals winners of the 2026 Apple Design Awards*. https://www.apple.com/ie/newsroom/2026/06/apple-reveals-winners-of-the-2026-apple-design-awards/

Apple Developer. (2025). *Motion*. https://developer.apple.com/design/human-interface-guidelines/motion

Apple Developer. (2025). *Adopting Liquid Glass*. https://developer.apple.com/documentation/TechnologyOverviews/adopting-liquid-glass

Dribbble. (s. f.). *Best app design*. https://dribbble.com/tags/best-app-design

r/iOSProgramming. (2025). *Can you recommend apps with great design?* [Foro de discusión]. Reddit. https://www.reddit.com/r/iOSProgramming/comments/1obpqg8/can_you_recommend_apps_with_great_design/

## Registro de cambios (disclaimer)

### 2026-09-22 — Preparación y movimiento 2.1

- **Cambio:** la actividad seleccionada se muestra como resumen editable; los detalles se abren cuando la persona decide modificarlos. La app se busca por nombre y el tiempo combina opciones rápidas, ajuste de un minuto y deslizador.
- **Antes:** la preparación mostraba todas las actividades y campos al mismo tiempo, incluso después de elegir una actividad sugerida.
- **Motivo:** dar prioridad a las dos decisiones que activan el aviso —app y tiempo— sin perder la posibilidad de personalizar la actividad, el primer gesto y el lugar del parlante.
- **Cambio:** la barra inferior se limita a Inicio; se mantienen transiciones breves y respuesta táctil al seleccionar una actividad.
- **Antes:** la barra ocupaba espacio y seguía marcando «Inicio» durante la preparación.
- **Motivo:** evitar una indicación de ubicación incorrecta y recuperar espacio para el contenido.
- **Límite:** la barra es translúcida, pero todavía no aplica desenfoque real del fondo. La revisión se realizó en emulador; falta prueba de comprensión, TalkBack y dispositivo físico.

### 2026-09-22 — Actividades visuales y navegación 2.0

- **Cambio:** siete accesos rápidos usan fotografías coherentes y el nombre de Relevo queda centrado en Inicio. La barra inferior se mantiene visible fuera del tutorial y del consentimiento; una sesión activa puede retomarse desde cualquier pestaña.
- **Antes:** los preestablecidos eran fichas de texto, el encabezado mostraba «Tu espacio» y la barra solo aparecía en Inicio.
- **Motivo:** reconocer una actividad con menos lectura, retirar un texto que no aportaba función y no perder el control de una señal al navegar.
- **Cambio:** «Hoy en apps elegidas» pasa a «Tiempo hoy en las apps que vinculaste»; «Relevos cerrados» pasa a «Relevos exitosos» con una definición verificable en el registro.
- **Antes:** el contador incluía cancelaciones y no almacenaba la respuesta final junto al historial.
- **Motivo:** no presentar como resultado positivo un cierre que no prueba el inicio de la actividad. Las entradas anteriores sin ese dato permanecen en el historial, pero no se cuentan como exitosas.
- **Límite:** el tratamiento translúcido de la barra no equivale al material Liquid Glass de iOS; la versión actual no aplica desenfoque real del contenido situado detrás.

- **Documento nuevo:** registra el criterio y el estado de la interfaz Android 1.9.
- **Antes:** la información sobre diseño estaba dispersa entre el código y el README; no existía aquí una relación directa entre referentes, decisiones y pruebas pendientes. El ícono aún era el de plantilla de Android.
- **Motivo:** permitir evaluar y corregir la experiencia sin confundir una pantalla atractiva con una solución ya validada.
