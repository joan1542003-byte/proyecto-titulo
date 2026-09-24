# Diseño de la experiencia Android de Relevo

**Estado:** versión 2.6, revisión de diseño y compilación del 24 de septiembre de 2026. Es una dirección implementada, no una validación con usuarios. Véanse también los [criterios de revisión de interfaz](criterios-revision-interfaz-2026-09-23.md) y la [revisión del feedback](revision-feedback-2026-09-23.md).

## Qué debe sentirse al usarla

Relevo acompaña una decisión personal; no califica el tiempo de pantalla ni castiga el uso de las aplicaciones. Por eso el recorrido evita contadores de culpa, mensajes de productividad y urgencia visual. La persona puede preparar una actividad, elegir las apps cuyo uso quiere sumar, fijar un límite, dejar un parlante en el lugar previsto y recibir una señal. También puede elegir el altavoz del teléfono para probar la experiencia sin parlante; esa alternativa no equivale a situar la señal junto a la actividad. La pantalla final pregunta qué decidió hacer sin presentar ninguna respuesta como correcta.

## Referentes examinados

Los Apple Design Awards de 2026 distinguen por separado interacción, inclusión, deleite y gráfica. *grug* fue reconocido por convertir una idea pequeña en un momento de reflexión; *Tide Guide*, por presentar datos temporales con claridad mediante una gráfica propia (Apple, 2026). No son modelos para copiar: en Relevo estas observaciones se traducen en un momento principal claramente identificable y en información de tiempo legible. La guía de movimiento de Apple (2025) recomienda que la animación explique cambios de estado sin demorar la tarea ni volverse un fin en sí misma. Android (s. f.) recomienda superficies táctiles de al menos 48 dp y comprobar la semántica de los elementos personalizados.

La revisión de [Dribbble](https://dribbble.com/tags/best-app-design) sirvió como repertorio visual, no como prueba de usabilidad: allí predominan capturas aisladas que no muestran tareas completas. En el [intercambio de r/iOSProgramming](https://www.reddit.com/r/iOSProgramming/comments/1obpqg8/can_you_recommend_apps_with_great_design/) se mencionan, entre otras, Flighty y Mela por su claridad, y Wikipedia por sus transiciones discretas. Son opiniones de usuarios, no evaluaciones comparables. Lo aprovechable para Relevo es una hipótesis de diseño: dar presencia visual a la acción principal sin convertir toda la pantalla en espectáculo. La [guía de Apple sobre Liquid Glass](https://developer.apple.com/documentation/TechnologyOverviews/adopting-liquid-glass) sitúa la navegación en una capa diferenciada del contenido. En Android se usa un desenfoque gradual de Haze sobre el contenido: no equivale al material nativo de iOS.

## Decisiones aplicadas

| Área | Decisión | Motivo y comprobación pendiente |
| --- | --- | --- |
| Inicio | Cuatro actividades reconocibles por imagen, una opción para escribir otra y acceso a más propuestas. Los datos de uso quedan en la pestaña Actividad. | Los accesos rápidos reducen escritura sin obligar a aceptar una actividad predeterminada. Se debe comprobar si la fotografía facilita reconocer la acción o distrae. |
| Configuración | Cuatro pantallas: actividad; apps y límite común; acción inicial, ubicación y salida de sonido; revisión con prueba audible y enlaces de edición. Solo la última permite activar. Una actividad propia se guarda en tres pasos. El gesto atrás y el enlace visible retroceden un paso; el tiempo puede ajustarse entre 1 minuto y 6 horas. | Cada pantalla agrupa decisiones relacionadas y conserva lo escrito al volver. La revisión reduce activaciones accidentales; la prueba de sonido aparece antes de los detalles para que no quede oculta al final. Falta comprobar con usuarios si los pasos resultan claros y no excesivos. |
| Tutorial | Cuatro escenas de objetos sin pantallas de la app y una composición de los permisos reales; al terminar ofrece preparar el primer relevo o ir a Inicio, pero requiere conceder Tiempo de uso. | La imagen contextualiza la acción sin aparentar una interfaz inexistente. La elección al final permite aprender haciendo; el permiso necesario no puede saltarse. Las escenas son conceptuales: no documentan el aspecto de un dispositivo definitivo. |
| Encabezado y navegación | El encabezado conserva la marca centrada y el pie utiliza una barra flotante de icono y texto. Se eliminó un efecto de desenfoque que produjo una franja visible en emulador; la superficie actual prioriza lectura y contraste. | Una referencia visual no justifica un efecto que dificulte percibir la navegación. Se puede volver a estudiar un desenfoque progresivo después de probar rendimiento y contraste en distintos teléfonos. |
| Espera | Tiempo acumulado visible junto con las apps elegidas y el lugar de la señal. | Se distingue el avance de la actividad deseada; el conteo no se presenta como objetivo moral. |
| Señal | La actividad ocupa la mayor jerarquía; el inicio concreto aparece inmediatamente debajo. | La persona puede reconocer lo que quería hacer sin descifrar una gráfica. |
| Cierre | Pregunta neutral y respuesta opcional. | Evita interpretar la decisión de la persona como éxito o fracaso. |
| Navegación | Inicio, Actividad y Relevos conservan icono y nombre en una barra flotante dentro de Inicio. La preparación, espera, señal y cierre tienen navegación contextual. | Las pestañas no compiten con la tarea de preparar o atender una señal. Si Inicio vuelve a mostrarse con una sesión activa, conserva un acceso explícito a ella. |
| Inicio | «Dijiste que empezaste» cuenta sesiones con señal emitida y respuesta «Comencé la actividad». | El rótulo identifica una respuesta voluntaria; Relevo no observa si la actividad se realizó. El criterio y el número contado no cambian. |
| Reconocimiento | Si la persona indica que comenzó, Inicio reconoce esa declaración una vez y permite cerrar el mensaje. Las demás respuestas no reciben reproche ni se convierten en racha. | Se refuerza una respuesta voluntaria sin afirmar que Relevo observó la actividad. Debe preguntarse si el tono resulta oportuno, neutro y comprensible. |
| Datos | El consentimiento actualizado se presenta de nuevo tras la actualización; Relevos muestra el código de participación y Privacidad y datos explica el uso, contacto, plazo y solicitud de eliminación. | Una persona debe poder identificar sus registros y ejercer control sobre ellos. La interfaz de borrado existe, pero su ejecución remota todavía debe ensayarse de extremo a extremo. |
| Estados vacíos | Actividad y Relevos explican qué aparecerá allí y ofrecen preparar el primer relevo. | Evitan un contador sin contexto o datos inventados; la ilustración abstracta acompaña, pero el texto y el botón contienen la información y la acción. |
| Movimiento | Transiciones breves entre estados; se omiten cuando Android desactiva las animaciones. | El movimiento aporta continuidad, pero no contiene información indispensable. |
| Sonido | La persona escoge parlante o teléfono. La prueba dura unos segundos y comunica si la salida escogida no pudo reproducir. | No se sustituye silenciosamente una salida por otra; el resultado debe ser visible además de audible. |
| Identificación | El ícono reúne un punto coral y dos anillos sobre verde; reemplaza el ícono de plantilla de Android. | Retoma el momento de señal de la interfaz y permite reconocer la app desde el sistema sin ilustrar un teléfono ni prometer una forma física definitiva. |

## Sistema de interfaz

La tipografía instalada es Source Sans 3, con cuatro pesos. Se usa una escala amplia para la actividad y títulos; los datos y acciones conservan texto legible en lugar de convertirse en microetiquetas. El fondo cálido (`#F8FAF8`) permite separar contenido sin sombras intensas. El verde (`#087A69`) identifica acciones y estados activos; el coral (`#F47F68`) se reserva para el foco de la señal. Ninguno de estos colores sustituye un texto de estado. Son códigos de interfaz vigentes en esta versión, no una afirmación de que el color tenga un significado universal para los usuarios.

Los círculos concéntricos aparecen en algunos estados vacíos y en la señal; no se superponen a decisiones ni se usan para fingir interacción. Las superficies secundarias son planas, con borde tenue, para que la jerarquía dependa del contenido y no de elevaciones artificiales. Aunque la aplicación usa Jetpack Compose y algunas primitivas de su biblioteca, los elementos visibles se configuran con tamaños, color, espaciado y comportamiento propios de Relevo. La revisión visual sigue abierta: compartir principios de claridad con interfaces de iOS no convierte esta app Android en una implementación de Liquid Glass.

Las imágenes de actividad comparten una regla: un objeto asociado a la acción, sin rostros ni marcas, fotografiado sobre fondo claro con luz de color suave. El nombre y la flecha son los elementos interactivos legibles; la foto facilita el reconocimiento, pero no contiene instrucciones. A las siete propuestas anteriores se añadieron «Pasear al perro» y «Manualidades», relacionadas con actividades mencionadas en el corpus de entrevistas. «Descansar» se exploró visualmente, pero no se incorporó: una señal sonora situada en un dormitorio merece antes una decisión sobre pertinencia y control del sonido. En Inicio se muestran cuatro opciones para no saturar; en Preparación aparecen las propuestas y siempre se puede escribir otra actividad. Las decisiones y los prompts de las imágenes añadidas se registran en [recursos explorados](assets-explorados/README.md).

## Verificación realizada y límites

La versión 2.6 compiló y pasó sus pruebas unitarias. En un emulador se inspeccionaron consentimiento, tutorial, Inicio y la preparación con dos apps. Se corrigió un deslizador cuya representación visual se rompía y una franja defectuosa de navegación. No se completó un ciclo en este emulador para evitar crear registros de prueba en la base activa; tampoco se comprobó el parlante físico. Esto no es una validación con personas. Antes de cerrar el diseño deben verificarse cinco tareas: comprender Relevo sin explicación externa, preparar un relevo por etapas, encontrar y probar el parlante, entender el conteo en espera y responder o saltar el cierre. También faltan texto ampliado, TalkBack, pantallas pequeñas, rendimiento, ruta real de audio Bluetooth y borrado remoto. Se priorizan teléfonos con Android 12 o posterior; cuatro años de antigüedad del equipo no garantizan una versión específica del sistema.

## Referencias

Android Developers. (s. f.). *API defaults*. https://developer.android.com/develop/ui/compose/accessibility/api-defaults

Android Developers. (s. f.). *<uses-sdk>*. https://developer.android.com/guide/topics/manifest/uses-sdk-element

Apple. (2026, 2 de junio). *Apple reveals winners of the 2026 Apple Design Awards*. https://www.apple.com/ie/newsroom/2026/06/apple-reveals-winners-of-the-2026-apple-design-awards/

Apple Developer. (2025). *Motion*. https://developer.apple.com/design/human-interface-guidelines/motion

Apple Developer. (2025). *Adopting Liquid Glass*. https://developer.apple.com/documentation/TechnologyOverviews/adopting-liquid-glass

Dribbble. (s. f.). *Best app design*. https://dribbble.com/tags/best-app-design

Haze. (s. f.). *Progressive (aka gradient) blurs*. https://chrisbanes.github.io/haze/1.5.4/usage/

r/iOSProgramming. (2025). *Can you recommend apps with great design?* [Foro de discusión]. Reddit. https://www.reddit.com/r/iOSProgramming/comments/1obpqg8/can_you_recommend_apps_with_great_design/

## Registro de cambios (disclaimer)

### 2026-09-24 — Revisión 2.6

- **Cambio:** se documentan el límite compartido entre apps, la salida elegible, el acceso visible a la prueba de sonido, las actividades añadidas y las correcciones visuales verificadas en emulador.
- **Antes:** la descripción de 2.5 presentaba una app objetivo, solo parlante y un desenfoque cuya ejecución no correspondía a lo visto en pantalla.
- **Motivo:** fundamentar decisiones observables y no prometer una calidad de interfaz o una validación que todavía no se ha demostrado.

### 2026-09-23 — Aplicación 2.5

- **Cambio:** se añadieron los criterios de regreso por pasos, permiso indispensable, tiempo hasta seis horas, reconocimiento sin juicio y acceso al código de participación; se precisó el alcance de la inspección visual real.
- **Antes:** el texto describía 2.4, no distinguía el permiso obligatorio del opcional ni registraba el código estable o la nueva respuesta de Inicio.
- **Motivo:** que la justificación de interfaz corresponda al comportamiento implementado y no confunda la revisión en emulador con la validación de uso.

### 2026-09-23 — Indicador de Inicio 2.4

- **Cambio:** el recuento de respuestas «Comencé la actividad» pasa a llamarse «Dijiste que empezaste».
- **Antes:** «Relevos exitosos» podía leerse como una actividad observada o un resultado comprobado.
- **Motivo:** comunicar que el dato proviene de lo que la persona reporta después de la señal.
- **Alcance:** ajuste de lenguaje y versión; no se modifica la lógica de conteo ni se declara validación con usuarios.

### 2026-09-23 — Recorrido, imágenes y compatibilidad 2.3

- **Cambio:** se documentan las cuatro etapas de preparación, las tres de creación de actividades, el cierre opcional del tutorial y la revisión previa a activar.
- **Antes:** la tabla describía una preparación concentrada en una sola vista y no explicaba la bifurcación del tutorial.
- **Motivo:** hacer corresponder el criterio de diseño con la interfaz implementada y dejar explícito qué requiere testeo.
- **Cambio:** se precisan el gradiente de desenfoque, el uso conceptual de las escenas y Android 12 como mínimo técnico.
- **Antes:** el texto negaba el desenfoque real y seguía situado en 2.1, aunque el código ya contenía Haze desde 2.2; las imágenes antiguas mostraban pantallas que no representaban fielmente la app.
- **Motivo:** corregir información desactualizada y separar las imágenes de apoyo de las evidencias del prototipo físico.
- **Cambio:** se registra que el emulador no permitió completar la inspección visual de 2.3.
- **Antes:** el apartado de verificación solo reflejaba una revisión anterior.
- **Motivo:** no presentar compilación como prueba de calidad visual o de usabilidad.

### 2026-09-22 — Actividades personalizadas y desenfoque real 2.2

- **Cambio:** una actividad puede conservar nombre, inicio, lugar, icono y color propios para reutilizarse. El color identifica la ficha elegida; el texto sigue transmitiendo la información principal.
- **Antes:** solo se podía modificar el contenido de una preparación, sin guardar una identidad visual propia de la actividad.
- **Motivo:** facilitar el reconocimiento de opciones frecuentes sin depender exclusivamente del color.
- **Cambio:** el encabezado y la navegación de Inicio se superponen al contenido con desenfoque progresivo; las métricas laterales comparten altura.
- **Antes:** las superficies eran translúcidas pero sin desenfoque real, y las métricas no compartían dimensión.
- **Motivo:** mantener continuidad espacial, legibilidad y alineación. Se implementó con Haze 1.6.10, compatible con la configuración actual del proyecto; no reproduce literalmente los materiales de iOS.
- **Cambio:** se retiró la pregunta duplicada del cierre. Tocar una respuesta registra la elección y vuelve a Inicio.
- **Antes:** el cierre añadía una explicación y un paso más.
- **Motivo:** respetar una decisión ya expresada. La opción de omitir permanece disponible.
- **Pendiente de validación:** rendimiento del desenfoque en equipo físico, comprensión de las opciones de respuesta y navegación mediante lector de pantalla.

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
