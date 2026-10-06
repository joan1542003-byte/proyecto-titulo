# Aplicación Android de Relevo

Prototipo funcional para elegir una actividad, seleccionar las aplicaciones cuyo uso se quiere contar y emitir una señal al completar un límite acumulado. La señal puede sonar en un parlante Bluetooth situado cerca de la actividad o, como alternativa de prueba, en el teléfono.

## Estado

**Versión:** 2.22, para el primer testeo del 7 de octubre: compara las semanas A, B y C del protocolo 02, con el objeto donde la persona empieza, y aclara el lenguaje (D-112; [detalle](version-2.22-comparar-y-lenguaje-claro-2026-10-06.md)). La **2.21** iconos con degradado, nada elegido de antemano y sin patrones oscuros (D-111; [detalle](version-2.21-iconos-y-sin-sugerencias-2026-10-06.md)). La **2.20** la persona elige dónde suena y la app registra su elección (D-110; [detalle](version-2.20-eleccion-libre-2026-10-06.md)). La **2.19** agrega la salida «El llavero»: un llavero iTag que pita con Bluetooth, con búsqueda, prueba, conexión durante la espera y botón que calla la señal; la pantalla se probó en emulador, pero falta probarla con un llavero real ([detalle](version-2.19-llavero-itag-2026-10-05.md), D-109). La **2.18** registra el uso diario de las apps elegidas, el tiempo total de pantalla y el estado del teléfono, permite eliminar un relevo activo y avisa qué falta cuando un campo está vacío; el consentimiento pasa a v11 ([detalle](version-2.18-registro-completo-y-avisos-2026-09-30.md), D-097). La **2.17** hace que los mensajes del proyecto lleguen al instante mientras Relevo cuenta o espera ([detalle](version-2.17-mensajes-al-instante-2026-09-30.md)). La **2.16** agrega la activación automática opcional y los mensajes del proyecto, probados en emulador y no en un teléfono real; el consentimiento pasa a v10 ([detalle](version-2.16-activacion-automatica-y-mensajes-2026-09-30.md), D-095 y D-096). La **2.15** agrega la salida experimental «El reloj», sin probar con un reloj real ([detalle](version-2.15-reloj-como-llamada-2026-09-29.md), D-093).

**Fecha:** 29 de septiembre de 2026

**Identificador:** `cl.udp.relevo`

**Android mínimo:** 12, API 31. El requisito se refiere a la versión del sistema, no al año de compra del teléfono.

**APK vigente:** [relevo-android-2.14-2026-09-29.apk](releases/relevo-android-2.14-2026-09-29.apk). Los de 2.13 a 2.7 se conservan: el autor debe decidir cuál se usa en la prueba de 21 días.

**Proyecto para Android Studio en macOS:** [instrucciones de apertura](ABRIR-EN-MAC.md)

**Paquete portable:** `releases/relevo-android-studio-2.14-2026-09-29.zip`

**Criterios de interfaz y revisión:** [Diseño y experiencia](DISENO-Y-EXPERIENCIA.md) (hasta 2.7), el sistema de marca D-073 aplicado en [Android 2.8](version-2.8-rediseno-perfil-y-ruta-2026-09-26.md) el vidrio, las formas y los emoji de D-083 en [Android 2.9](version-2.9-vidrio-y-emoji-2026-09-27.md) y los textos, el tono de las fotos y la participación de D-084 en [Android 2.10](version-2.10-participacion-y-claridad-2026-09-27.md).

**Cobertura de la corrección:** [revisión del 23 de septiembre](revision-feedback-2026-09-23.md).

**Licencias de recursos de terceros:** [fuente Schibsted Grotesk, fotografías y emoji Noto 3D](licencias/README.md).

**Versión 2.14:** a pedido del autor (D-090), la guía da contexto en tres pantallas y acompaña el primer relevo real, con el primer paso de la ruta elegida como ejemplo; el video se ve más grande, las frases poco naturales se reescribieron y se corrigió el encabezado vacío al responder ([detalle](version-2.14-guia-y-primer-relevo-2026-09-29.md)).

**Versión 2.13:** a pedido del autor (D-088 y D-089), explica cada parte la primera vez con una guía de nueve pantallas y notas en el primer relevo, cambia los intereses amplios por doce actividades de las entrevistas, guarda el nombre aparte con el código, muestra un resumen del relevo activo en Inicio, pregunta por el aviso semanal y corrige el audio del video ([detalle](version-2.13-guia-intereses-y-nombre-2026-09-29.md); [coherencia con la memoria](../../08_memoria/coherencia-app-con-la-memoria-2026-09-29.md)).

**Versión 2.12:** a pedido del autor (D-087), deja de hablar de «prueba» en el uso diario, simplifica los textos, pide solo el permiso de notificaciones y enciende los avisos, usa un código de 4 caracteres, parte en modo claro, registra cómo se usa la app y pide opiniones con caras. La configuración de las tres semanas se abre manteniendo presionado el texto de la versión en el perfil ([detalle](version-2.12-mas-simple-y-mas-datos-2026-09-29.md)).

**Versión 2.11:** a pedido del autor (D-086), la primera vez explica cómo usar la app con el video de Relevo en vertical y cinco pasos, y guarda cada dato en Supabase y en una copia en Documentos/Relevo del teléfono, con la salida real del sonido y la versión de la app; el consentimiento pasa a v7. Se comprobó con conexión que sesiones, eventos y respuestas llegan a Supabase y que el borrado alcanza a las dos copias ([detalle y pasos para el primer testeo](version-2.11-primer-testeo-2026-09-28.md)).

**Versión 2.10:** a pedido del autor, exige participar en la prueba para usar la app (sin «No participar»), cambia los rótulos por frases claras («Empieza por ponerte las zapatillas, junto a la puerta.»), quita las mayúsculas sostenidas, aleja el desenfoque del centro y lo reduce en los botones, pone el texto en blanco o en tinta según el tono de cada foto, amplía el perfil a 84 emoji y rediseña «Tu ruta» y «Tus actividades». No cambian la lógica de la prueba ni los datos. Detalle, verificación y pendientes en [Android 2.10](version-2.10-participacion-y-claridad-2026-09-27.md).

**Versión 2.9:** a pedido del autor, lleva la interfaz al estilo de iOS 26: pantalla completa, vidrio con desenfoque sutil en la capa de navegación, cápsulas y esquinas amplias en lugar de bloques, emoji 3D de Google en el perfil y textos más naturales, sin avisos de privacidad repetidos. No cambia la lógica ni los datos. Detalle, verificación y pendientes en [Android 2.9](version-2.9-vidrio-y-emoji-2026-09-27.md).

**Versión 2.8:** aplica el sistema de marca D-073 con fotografías, suma perfil, ruta de actividades, aviso de regreso opcional, apariencia y uso sin participar, y completa las pantallas del diseño escrito. Conserva sin cambios la lógica de la prueba de 21 días. Detalle, verificación y pendientes en [Android 2.8](version-2.8-rediseno-perfil-y-ruta-2026-09-26.md).

**Versión 2.7:** incorpora lo que exige el [protocolo 02](../../07_validacion/protocolo-02-prueba-21-dias.md) y corrige el envío de eventos. Cambios, causa del problema de eventos y verificación en [Android 2.7](version-2.7-prueba-21-dias-2026-09-25.md).

La versión 2.10 compila y sus 58 pruebas unitarias pasan. En un emulador Android 16, sin red y con datos ficticios, se recorrieron la primera vez, la ruta, las actividades, la preparación, un ciclo completo con la señal y la respuesta sobre una foto oscura y el tema oscuro. Faltan el teléfono real de la prueba, el parlante Bluetooth y el borrado sin conexión. No es una aplicación validada con participantes.

## Qué permite hacer

1. escribir una actividad y una forma concreta de comenzar;
2. elegir una o varias aplicaciones instaladas; sus tiempos de uso se suman hasta un único límite;
3. partir de actividades ilustradas o escribir una actividad propia;
4. definir el tiempo acumulado entre 1 minuto y 6 horas mediante un deslizador, ajustes y accesos rápidos, además de una prueba de 15 segundos;
5. reconocer las aplicaciones por su icono real;
6. moverse entre Inicio, Ruta y Perfil y consultar el historial de relevos, agrupado por día;
7. ver dónde quedó situada la última señal;
8. autorizar el acceso a Tiempo de uso; las notificaciones se solicitan por separado y son opcionales;
9. crear un identificador aleatorio que agrupa los datos sin solicitar nombre, correo ni teléfono;
10. activar un monitoreo visible mediante una notificación persistente;
11. elegir expresamente si la señal suena en un parlante Bluetooth multimedia o en el altavoz del teléfono, además de vibración breve y notificación; nunca cambiar de salida sin informarlo;
12. pausar el conteo si la persona sale de la aplicación y retomarlo cuando vuelve;
13. desactivar, silenciar y cerrar el ciclo.
14. responder opcionalmente qué decidió hacer después de la señal;
15. contar cuántas veces se eligió cada actividad y distinguir las señales seguidas de un inicio autodeclarado;
16. conservar sesiones y eventos sin conexión e intentar enviarlos a Supabase cuando la base está configurada;
17. solicitar una sola vez el consentimiento para uso académico antes de mostrar el tutorial o iniciar cualquier registro;
18. empezar con una bienvenida breve, la decisión de participar en la prueba y el permiso de Tiempo de uso, sin tutorial de varias páginas (A1 a A3 desde 2.8);
19. preparar un relevo por etapas: actividad; aplicación y tiempo; inicio y ubicación; revisión y activación. Las actividades propias se crean en tres pasos y se pueden reutilizar;
20. después del permiso, escribir un nombre, elegir un emoji e intereses, o saltar cada paso; los intereses arman una ruta de actividades;
21. volver con el gesto de Android en todas las pantallas; consultar en Privacidad y datos un código de participación estable entre ciclos;
22. ver una confirmación breve cuando la persona declara que comenzó su actividad, sin presentar la declaración como una comprobación de Relevo;
23. probar el sonido antes de activar, conocer explícitamente si la salida elegida falló y consultar una pantalla de privacidad para solicitar la eliminación de los registros locales y remotos;
24. encontrar de nuevo la actividad anterior al abrir la app dos días o más después del último relevo («Hola de nuevo»), sin decir cuántos días pasaron ni imponer una racha;
25. escuchar una señal de unos 30 segundos hecha con la firma sonora de Relevo, que empieza suave y se detiene sola (D-078); después, la pantalla y la notificación quedan en silencio hasta que la persona responde;
26. seguir la prueba de 21 días del protocolo 02: el investigador asigna en la sesión inicial una de las seis secuencias; cada semana la app indica la condición (parlante donde empiezas, parlante en otro lugar o aviso en el teléfono) y fija dónde suena;
27. en la condición «teléfono», recibir una notificación genérica («Tu intención está disponible»); en la pantalla de bloqueo, la notificación nunca muestra la intención;
28. responder tras cada señal, con un toque y pudiendo omitir, si supo qué quería hacer antes de mirar el teléfono y si recordó cómo empezar; responder la tarjeta de cierre de cada semana y el cierre del día 21;
29. registrar para la investigación si la señal se silenció o terminó sola, cuánto tardó la respuesta y el uso de las apps elegidas 10 minutos antes y después de la señal, sin mostrarlo como tiempo excedido;
30. repetir el último relevo desde Inicio, retomar el conteo tras reiniciar el teléfono o actualizar la app, ver un aviso si se retira Tiempo de uso y permitir opcionalmente que Relevo funcione sin la restricción de batería;
31. consultar en Privacidad y datos el estado del envío (pendientes, último envío y rechazos) y el día de la prueba;
32. seguir una ruta de pasos editables por interés; tras tres respuestas «Comencé» en el mismo paso, la app ofrece probar el siguiente, sin obligar;
33. activar, si se quiere, el aviso semanal, el resumen semanal, las veces por semana y el mensaje después de responder;
34. elegir tema claro, oscuro o del sistema y texto grande;
35. dejar la prueba cuando se quiera: «Borrar mis datos», en Privacidad y datos, borra todo, también en la base; desde 2.10 no hay uso sin participar;
36. descargar en un archivo todo lo guardado en el teléfono, opinar sobre la app o reportar un problema;
37. leer el texto sobre las fotos en blanco o en tinta según el tono de cada foto, y elegir entre 84 emoji para el perfil.

## Límites

Relevo reconoce qué aplicación está en primer plano, pero no lee mensajes, imágenes, búsquedas ni contenidos. Solo suma el tiempo de las aplicaciones elegidas mientras el relevo está activo. Sesiones, eventos y respuestas se guardan primero en SQLite y la app intenta sincronizarlos con Supabase. La base tiene políticas que limitan el acceso de cada participante a sus filas. Hasta el 24 de septiembre ningún evento llegaba porque la base no permitía leer la columna usada para evitar duplicados; desde 2.7, un registro rechazado ya no detiene el envío de los demás ([detalle](version-2.7-prueba-21-dias-2026-09-25.md)).

La señal sonora comprueba que Android haya dirigido el audio a la salida elegida. Suena unos 30 segundos, incluso con la app fuera de pantalla, y cesa antes si la persona la silencia. Si la ruta no está disponible, se informa el fallo y no se marca la señal como audible. La alternativa en el teléfono permite probar la interacción, pero no sustituye la situación phygital: el aviso ya no está junto a la actividad. La selección de ruta de Android no demuestra exclusividad absoluta en todos los modelos; se necesita probar el teléfono y parlante concretos.

La comprobación anterior se refiere **solo al tono de Relevo**: no impide que YouTube, Instagram u otra app envíen audio al mismo parlante multimedia. Las opciones para separar esos sonidos y la prueba necesaria están en el [análisis de enrutamiento](../enrutamiento-audio-parlante-exclusivo-2026-09-23.md).

## Instalación y permiso

1. instalar el APK;
2. abrir Relevo;
3. leer y aceptar la participación en la prueba de 21 días; desde 2.10, sin aceptarla no se puede usar la app;
4. autorizar **Tiempo de uso**;
5. escribir el nombre, elegir un emoji e intereses, o saltar esos pasos;
6. autorizar notificaciones si se quiere recibir el aviso con otra aplicación abierta;
7. en la sesión inicial, el investigador abre **Perfil → Prueba de 21 días**, elige la secuencia asignada a la persona y pulsa **Empezar la prueba hoy** (día 0).

Android muestra una notificación mientras el recordatorio está activo. Esta visibilidad comunica que existe observación en curso y no debe eliminarse.

## Datos de prueba

La estructura y sus límites están descritos en [detección de uso y datos](arquitectura-deteccion-uso-y-datos-2026-09-21.md) y, para la prueba de 21 días, en el [modelo de datos](../../07_validacion/modelo-datos-evaluacion-app-2026-09-22.md). La app usa un código aleatorio. El nombre del perfil es opcional y, como la imagen, los intereses y la ruta, no sale del teléfono. El consentimiento indica finalidad académica, correo responsable y plazo máximo de conservación hasta el 30 de diciembre de 2026. Antes de entregar el APK a participantes debe probarse la eliminación solicitada desde la app, incluida la respuesta sin conexión.

## Compilación

En macOS se recomienda abrir directamente esta carpeta en Android Studio. La guía completa se encuentra en [ABRIR-EN-MAC.md](ABRIR-EN-MAC.md).

Compilación desde Windows:

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
$env:ANDROID_HOME='D:\AndroidSdk'
$env:RELEVO_BUILD_DIR='D:\AndroidBuild'
.\gradlew.bat :app:testDebugUnitTest :app:assembleDebug --no-configuration-cache
```

## Estructura relevante

- `domain/Reminder.kt`: estados y condiciones del ciclo;
- `domain/Study.kt`: plan de la prueba de 21 días, semanas y condiciones;
- `monitor/AppUsageMonitorService.kt`: observación visible del primer plano y emisión de la señal;
- `monitor/ForegroundTracker.kt` y `monitor/UsageWindow.kt`: suma del tiempo en las apps elegidas y uso alrededor de la señal;
- `monitor/DailyUsage.kt` y `data/StateSnapshot.kt`: uso diario de las apps elegidas y tiempo total de pantalla, y estado del teléfono para el panel (D-097);
- `monitor/RestoreMonitorReceiver.kt`: reanudación tras reiniciar o actualizar;
- `monitor/UsageAccess.kt` y `monitor/BackgroundAccess.kt`: permiso de Tiempo de uso y restricción de batería;
- `data/ResearchLogStore.kt`: sesiones, eventos y respuestas seudónimos en SQLite;
- `data/RemoteSync.kt`: envío a Supabase, rechazos, borrado y estado del envío;
- `data/StudyStore.kt` y `data/ReminderStore.kt`: estado local de la prueba y del recordatorio;
- `signal/FirmaSonora.kt` y `signal/SignalPlayer.kt`: firma sonora, señal de 30 segundos, prueba de sonido y vibración;
- `domain/Route.kt`, `data/RouteStore.kt` y `data/ProfileStore.kt`: ruta de actividades, oferta del siguiente paso y perfil local;
- `data/SettingsStore.kt`, `data/Participation.kt` y `monitor/ReturnNotice.kt`: ajustes, participación y aviso semanal;
- `ui/RelevoViewModel.kt`: coordinación;
- `ui/RelevoApp.kt`: navegación, transiciones y gesto de volver;
- `ui/FirstRunScreens.kt`, `ui/ProfileScreens.kt`, `ui/RouteScreens.kt`, `ui/HomeScreen.kt`, `ui/PrepareScreen.kt`, `ui/SignalScreens.kt` y `ui/SettingsScreens.kt`: pantallas;
- `ui/components/` y `theme/`: componentes, iconos, fotos, emoji, vidrio, tono de las fotos (`Tone.kt`), movimiento y el sistema D-073;
- `ui/StudyScreens.kt`: configuración de la prueba, tarjetas y preguntas.

## Registro de cambios (disclaimer)

### 2026-10-06 — Android 2.22

- **Qué cambió:** el estado suma la 2.22.
- **Cómo estaba antes:** la más reciente era la 2.21.
- **Por qué:** D-112.

### 2026-10-06 — Android 2.21

- **Qué cambió:** el estado suma la 2.21.
- **Cómo estaba antes:** la más reciente era la 2.20.
- **Por qué:** pedido del autor (D-111).

### 2026-10-06 — Android 2.20

- **Qué cambió:** el estado suma la 2.20, con elección libre.
- **Cómo estaba antes:** la versión más reciente era la 2.19.
- **Por qué:** pedido del autor (D-110).

### 2026-10-05 — Android 2.19

- **Qué cambió:** el estado suma la versión 2.19, con la salida «El llavero».
- **Cómo estaba antes:** la versión más reciente era la 2.18.
- **Por qué:** el autor decidió comprar un llavero iTag y pidió que la app lo haga sonar (D-109).

### 2026-09-30 — Versión 2.18: registro completo y avisos

- **Qué cambió:** el estado menciona la 2.18 y el mapa del código suma `DailyUsage` y `StateSnapshot`.
- **Cómo estaba antes:** la versión más reciente era la 2.17.
- **Por qué:** pedido del autor (D-097).

### 2026-09-30 — Versión 2.17: mensajes al instante

- **Qué cambió:** el estado menciona la 2.17, con mensajes al instante por Realtime.
- **Cómo estaba antes:** la versión más reciente era la 2.16.
- **Por qué:** el autor preguntó si la notificación podía llegar al instante.

### 2026-09-30 — Versión 2.16: activación automática y mensajes

- **Qué cambió:** el estado menciona la 2.16, con activación automática, mensajes del proyecto y consentimiento v10.
- **Cómo estaba antes:** la versión más reciente era la 2.15.
- **Por qué:** pedido del autor (D-095 y D-096).

### 2026-09-29 — Versión 2.15 experimental: el reloj

- **Qué cambió:** el estado menciona la 2.15, que agrega la salida «El reloj».
- **Cómo estaba antes:** solo describía la 2.14.
- **Por qué:** el autor pidió probar su reloj como objeto que suena (D-093).

### 2026-09-29 — Versión 2.14: guía y primer relevo

- **Qué cambió:** el estado apunta a la 2.14, para el testeo real.
- **Cómo estaba antes:** apuntaba a la 2.13.
- **Por qué:** pedido del autor (D-090).

### 2026-09-29 — Versión 2.13: guía, intereses y nombre

- **Qué cambió:** el estado apunta a la 2.13.
- **Cómo estaba antes:** apuntaba a la 2.12.
- **Por qué:** pedidos del autor (D-088 y D-089).

### 2026-09-29 — Versión 2.12: más simple y más datos

- **Qué cambió:** el estado apunta a la 2.12.
- **Cómo estaba antes:** apuntaba a la 2.11.
- **Por qué:** pedido del autor (D-087).

### 2026-09-28 — Versión 2.11: primer testeo

- **Qué cambió:** el estado apunta a la 2.11, con «Cómo funciona», el video vertical y los datos guardados en Supabase y en el teléfono.
- **Cómo estaba antes:** apuntaba a la 2.10.
- **Por qué:** el autor pidió dejar la app lista para el primer testeo real (D-086).

### 2026-09-27 — Versión 2.10: participación, textos claros y tono de las fotos

- **Qué cambió:** el estado apunta a 2.10 y resume lo que cambia; la lista de funciones y la instalación dicen que ya no hay uso sin participar y usan los nombres nuevos de los ajustes y las condiciones.
- **Cómo estaba antes:** describía la 2.9, con uso sin participar.
- **Por qué:** pedido del autor del 27 de septiembre (D-084).

### 2026-09-27 — Versión 2.9: vidrio, formas redondeadas y emoji

- **Qué cambió:** el estado apunta a 2.9 y resume lo que cambia: vidrio en la capa de navegación, pantalla completa, cápsulas, emoji en el perfil y textos más breves.
- **Cómo estaba antes:** describía la 2.8, con superficies planas y fotos en el perfil.
- **Por qué:** pedido del autor del 26 de septiembre (D-083).

### 2026-09-26 — Versión 2.8: sistema de marca D-073, perfil y ruta

- **Cambio:** el estado apunta a 2.8. La lista de funciones reemplaza el tutorial por A1 a A3 y el perfil, mueve el código de participación a Privacidad y datos, y suma ruta, avisos opcionales, apariencia, uso sin participar, descarga de datos, opinión y reportes. La instalación y la estructura describen las pantallas y archivos nuevos. La fuente pasa a Schibsted Grotesk.
- **Antes:** describía la 2.7, con tutorial de cuatro escenas, Source Sans 3 y el código en Historial.
- **Motivo:** el autor pidió aplicar D-073, recuperar las fotografías y completar las pantallas del diseño escrito ([detalle](version-2.8-rediseno-perfil-y-ruta-2026-09-26.md)).
- **Verificación:** compilación, 47 pruebas unitarias y recorrido en emulador con datos ficticios. **Pendiente:** decisión del autor entre 2.8 y 2.7 para la prueba, teléfono real, parlante y borrado sin conexión.

### 2026-09-25 — Versión 2.7 para la prueba de 21 días

- **Cambio:** señal de unos 30 segundos con la firma sonora (D-078); condición de la semana asignada por secuencia y que fija la salida; notificación genérica en la condición «teléfono» y versión pública sin la intención; preguntas de un toque tras cada señal, tarjetas semanales y cierre del día 21; registro de silencio o fin automático, tiempo de respuesta y uso de las apps elegidas 10 minutos antes y después de la señal. También: envío que no se bloquea por un registro rechazado, reanudación tras reiniciar, aviso si se retira el permiso, repetición del último relevo, regreso según el diseño escrito (V1), consentimiento de 21 días y botones con verbo (D-077).
- **Antes:** la señal sonaba hasta que la persona la silenciaba; la app no conocía la prueba de 21 días; la base tenía 0 eventos por una causa no diagnosticada.
- **Motivo:** el protocolo 02 exige la versión 2.7 antes de la prueba técnica (D-075, D-078 y D-079).
- **Verificación:** compilación, 34 pruebas unitarias y recorrido con datos ficticios en emulador, con registros comprobados en Supabase. **Pendiente:** teléfono real, parlante Bluetooth y borrado sin conexión.

### 2026-09-25 — Próxima versión 2.7

- **Qué cambió:** se enumeran los cambios que requiere el protocolo 02.
- **Antes:** no había una versión siguiente definida.
- **Por qué:** D-078 y D-079.

### 2026-09-25 — Registro de licencias

- **Cambio:** se enlazó un registro que reúne la licencia de Source Sans 3 (ya incluida en `app/licenses/`) y la procedencia de las imágenes.
- **Antes:** la licencia estaba presente, pero no había un índice visible desde este README.
- **Motivo:** facilitar la comprobación del uso legal de material ajeno en un repositorio público.

### 2026-09-24 — Revisión funcional 2.6

- **Cambio:** el índice apunta a 2.6; documenta aplicaciones múltiples con un límite común, selección explícita de salida de sonido, prueba previa, fallos visibles, privacidad y las comprobaciones realizadas.
- **Antes:** describía 2.5 como una sola aplicación y solo una salida Bluetooth, sin distinguir la existencia de sesiones remotas de la ausencia de eventos.
- **Motivo:** hacer coincidir la documentación con el código y no atribuirle al prototipo validaciones que aún no tiene.

### 2026-09-23 — Revisión de interfaz y consentimiento 2.5

- **Cambio:** se fijaron las acciones del tutorial, se hizo necesario el permiso de Tiempo de uso para terminarlo, se añadió el regreso por gesto en los pasos, se reforzó la legibilidad de la navegación, se reemplazaron barras separadas por un progreso continuo y se amplió el tiempo hasta seis horas. Historial distingue las respuestas autodeclaradas y muestra el código estable de participación; Inicio confirma sin calificar como éxito la respuesta «Comencé». El consentimiento incluye correo, fecha y ruta de datos, y cambió de versión para solicitar una nueva aceptación.
- **Antes:** se podía ir a Inicio sin el permiso imprescindible, el código cambiaba al cerrar cada relevo, el tiempo terminaba en 60 minutos y el consentimiento anterior seguía aceptado después de cambiar su contenido.
- **Motivo:** dar control real sobre la secuencia y permitir localizar registros de una persona sin inferir su conducta fuera de la app.
- **Verificación:** compilación Android y siete pruebas unitarias aprobadas; tutorial y consentimiento inspeccionados en emulador. El emulador se cerró antes de completar la inspección de Inicio e Historial. No hay aún prueba de audio con equipo físico ni procedimiento de eliminación local y remota demostrado; por ello el APK no está habilitado para participantes.

### 2026-09-23 — Indicador de inicio autodeclarado 2.4

- **Cambio:** Inicio muestra «Dijiste que empezaste» para el recuento de sesiones con señal emitida y respuesta «Comencé la actividad».
- **Antes:** el indicador se llamaba «Relevos exitosos», aunque Relevo no observa si la actividad efectivamente se realizó.
- **Motivo:** describir el dato como lo que es: una respuesta voluntaria de la persona, no una comprobación de éxito.
- **Alcance:** cambia el rótulo; el criterio y el valor del recuento permanecen iguales. No añade funciones ni implica resultados observados.

### 2026-09-23 — Límite de separación de audio

- **Cambio:** se aclaró que la ruta verificada por el código corresponde al tono de Relevo y se enlazó el análisis de otras apps.
- **Antes:** el límite de exclusividad absoluta estaba indicado, pero no explicaba el caso de YouTube o Instagram.
- **Motivo:** evitar presentar un parlante multimedia conectado como salida reservada para Relevo.
- **Alcance:** documentación; sin cambio de código ni prueba física.

### 2026-09-23 — Preparación por etapas 2.3

- **Cambio:** el alta de una actividad propia tiene tres pantallas y la preparación del relevo cuatro, con una revisión editable previa a la activación. El tutorial permite iniciar esa preparación o dejarla para más tarde.
- **Antes:** todos los campos de preparación aparecían en una pantalla y el tutorial terminaba siempre en Inicio.
- **Motivo:** reducir decisiones simultáneas y evitar activar una configuración sin revisarla. La separación es una hipótesis de usabilidad pendiente de testeo, no un resultado validado.
- **Cambio:** las escenas del tutorial muestran objetos y situaciones, no una supuesta interfaz; los permisos se explican con componentes de la propia app. El desenfoque superior e inferior usa una intensidad gradual más suave.
- **Antes:** algunas ilustraciones incluían pantallas ficticias y el desenfoque era más intenso.
- **Motivo:** no confundir una representación conceptual con la interfaz real y preservar la legibilidad del contenido que se desplaza.
- **Cambio:** el mínimo pasa de Android 8 (API 26) a Android 12 (API 31).
- **Antes:** se anunciaba compatibilidad con sistemas antiguos que no forman parte del grupo de prueba prioritario.
- **Motivo:** concentrar verificación y rendimiento visual en versiones recientes. El año de fabricación no determina por sí solo la versión de Android; se debe comprobar el teléfono concreto.
- **Cambio:** si existe un relevo activo, las tarjetas de actividades propias y el acceso para crear otra actividad devuelven a la sesión en curso.
- **Antes:** esos dos accesos podían abrir la preparación durante un ciclo activo.
- **Motivo:** impedir que una interacción secundaria modifique los datos de una sesión que ya se está midiendo.
- **Verificado:** compilación y pruebas unitarias. **Pendiente:** inspección visual en dispositivo físico, rendimiento del desenfoque, acceso con texto ampliado y recorrido completo con un parlante Bluetooth real.

### 2026-09-22 — Actividades propias y continuidad visual 2.2

- **Cambio:** las actividades propias se guardan en el teléfono con nombre, forma de empezar, ubicación, icono y color. Pueden volver a elegirse, editarse y eliminarse.
- **Antes:** una actividad escrita durante la preparación no se conservaba como opción reutilizable.
- **Motivo:** reducir la configuración repetida sin imponer las actividades sugeridas. Estos datos permanecen locales; no se incorporaron al registro remoto de sesiones.
- **Cambio:** Inicio ocupa toda la pantalla, con contenido desplazable detrás del encabezado y la barra flotante y desenfoque progresivo en ambos extremos. Las dos tarjetas de métricas tienen la misma altura.
- **Antes:** el encabezado y la barra se apoyaban en superficies opacas y las métricas tenían alturas diferentes.
- **Motivo:** conservar la lectura y el acceso a la navegación sin interrumpir la continuidad del contenido.
- **Cambio:** la espera y el aviso identifican la «Ubicación de Relevo». Al elegir una respuesta final, esta se registra y se vuelve a Inicio inmediatamente.
- **Antes:** se hablaba de la ubicación del parlante y el cierre repetía la pregunta.
- **Motivo:** nombrar el lugar de la señal con claridad y eliminar una confirmación innecesaria.
- **Límite:** se verificaron compilación, pruebas, análisis estático y funcionamiento visual en emulador. El desenfoque y la lectura accesible aún requieren prueba en teléfonos físicos.

### 2026-09-22 — Preparación 2.1

- **Cambio:** la actividad elegida queda resumida y editable, el selector de apps permite buscar por nombre y el tiempo se ajusta con accesos rápidos, botones o deslizador continuo; la barra inferior aparece solo en Inicio. En instalaciones nuevas, el tiempo inicial es de 15 minutos y puede modificarse.
- **Antes:** todas las actividades y los campos estaban visibles después de elegir, y la barra seguía marcando Inicio durante la preparación.
- **Motivo:** reducir pasos y ruido sin quitar control sobre el aviso. Los cambios de actividad, app y tiempo tienen transiciones breves, no animaciones decorativas continuas.
- **Alcance:** compilación y revisión en emulador; aún no equivale a validación con usuarios ni a Liquid Glass nativo de iOS.

### 2026-09-22 — Interfaz 2.0

- **Cambio:** se añadieron siete fotografías de actividad, tarjetas de acceso rápido, marca centrada y navegación flotante persistente en el recorrido principal. Los textos de Inicio se redujeron a instrucciones y datos útiles.
- **Versión anterior:** preestablecidos de texto, «Tu espacio», «Una idea para hoy» y barra de navegación limitada a Inicio.
- **Motivo:** facilitar la elección, hacer reconocibles las opciones y mantener accesible el regreso a una señal activa.
- **Cambio de datos:** el historial conserva identificador de sesión, señal emitida y respuesta final; «Relevos exitosos» requiere señal emitida e inicio declarado por la persona.
- **Versión anterior:** «Relevos cerrados» contaba también cancelaciones.
- **Motivo:** evitar una afirmación de éxito que la aplicación no podía sostener.

### 2026-09-22 — Recorrido visual 1.9

- **Cambio:** se reorganizaron Inicio, configuración, espera, señal y cierre con una jerarquía propia; Actividad y Relevos explican su estado vacío. La navegación conserva sus tres nombres visibles y la activación permanece al pie de la configuración.
- **Versión anterior:** varias pantallas dependían de tarjetas equivalentes, la navegación ocultaba los nombres no seleccionados y era necesario desplazarse hasta el final para activar el relevo.
- **Motivo:** reducir ambigüedad, hacer visible la acción principal y relacionar cada pantalla con una decisión concreta de la persona.
- **Corrección:** el tutorial ya no promete luz en el prototipo actual, la prueba del parlante termina automáticamente después de unos segundos y el ícono de plantilla fue sustituido por la señal de Relevo.
- **Versión anterior:** el tutorial atribuía luz al dispositivo y el sonido de prueba podía permanecer activo.
- **Motivo:** que la interfaz describa lo que la versión funcional realmente hace.
- **Corrección técnica:** la comprobación de Tiempo de uso emplea una API disponible desde Android 8, y el respaldo automático del almacenamiento local queda desactivado.
- **Versión anterior:** la comprobación invocaba una API disponible solo desde Android 10, pese a declarar compatibilidad con Android 8; el sistema podía incluir datos locales en copias automáticas.
- **Motivo:** respetar la compatibilidad declarada y reducir la exposición de registros de investigación.

### 2026-09-22 — Señal persistente dirigida a Bluetooth

- **Cambio:** el tono deja de tener una duración fija y se mantiene hasta que la persona silencia o cierra el ciclo; la ruta se comprueba antes de emitirlo y durante la reproducción.
- **Versión anterior:** sonaba durante tres segundos mediante la salida de alarma de Android, que podía reproducirse en el teléfono.
- **Motivo:** sostener la señal en el objeto cercano sin hacer sonar el teléfono cuando no haya un parlante Bluetooth disponible. El comportamiento aún requiere verificación física en los dispositivos de prueba.

### 2026-09-22 — Proyecto portable para Android Studio

- **Cambio:** se añadieron una guía específica para macOS, un ejemplo de configuración local y un paquete ZIP sin credenciales ni archivos de compilación.
- **Versión anterior:** el código estaba completo en GitHub, pero la apertura y compilación solo estaban explicadas mediante rutas de Windows.
- **Motivo:** permitir continuar el desarrollo desde Android Studio en macOS con la menor cantidad posible de pasos manuales.

### 2026-09-22 — Lenguaje directo, permisos y sincronización verificada

- **Cambio:** el texto visible explica el identificador aleatorio sin recurrir al término técnico “código seudónimo”.
- **Versión anterior:** el consentimiento empleaba un concepto que podía resultar ambiguo para una persona ajena a la investigación.
- **Motivo:** informar con precisión qué dato se crea y qué información personal no se solicita.
- **Cambio:** el tutorial elimina rótulos redundantes y agrega una escena final que explica y solicita Tiempo de uso y Notificaciones.
- **Versión anterior:** los permisos aparecían más tarde y sin formar parte del aprendizaje inicial.
- **Motivo:** explicar cada solicitud antes de abrir el ajuste del sistema y evitar permisos sin contexto.
- **Cambio visual:** se retiró la marca repetida de las pantallas internas, los botones con apariencia predeterminada y el selector emergente de aplicaciones.
- **Versión anterior:** la jerarquía dependía de títulos pequeños, mayúsculas y componentes reconocibles del sistema visual anterior.
- **Motivo:** dejar que el contenido guíe la lectura y reservar la marca para el inicio.
- **Verificación:** Supabase aceptó autenticación anónima, inserción y lectura bajo RLS. El registro técnico se eliminó después de comprobar el recorrido.

### 2026-09-22 — Consentimiento inicial y tutorial ilustrado

- **Cambio:** el consentimiento académico aparece antes del tutorial, exige una aceptación explícita y persiste durante los usos siguientes.
- **Versión anterior:** los términos se aceptaban dentro de cada configuración y competían con el permiso técnico de Android.
- **Motivo:** separar la decisión de participar de la autorización del sistema operativo y evitar cualquier registro previo al consentimiento.
- **Cambio visual:** cada etapa del tutorial incorpora una ilustración propia y la configuración reemplaza campos y chips predeterminados por componentes de Relevo.
- **Versión anterior:** el tutorial utilizaba iconos aislados y la configuración mantenía patrones visuales genéricos.
- **Motivo:** enseñar acciones reales, mantener continuidad narrativa y elevar la identidad del producto.
- **Alcance:** antes de una prueba formal todavía debe añadirse el contacto del responsable y aprobarse el texto definitivo de consentimiento.

### 2026-09-22 — Introducción progresiva y navegación propia

- **Cambio:** el primer inicio presenta cinco escenas breves y no vuelve a mostrarlas después de completarlas.
- **Versión anterior:** cada creación pasaba por una pantalla tutorial extensa.
- **Motivo:** explicar una idea por vez y evitar instrucciones repetidas en usos posteriores.
- **Cambio visual:** se sustituyó la barra inferior predeterminada, se eliminó la sombra del llamado principal y se ampliaron las transiciones entre estados.
- **Versión anterior:** la navegación y varias superficies conservaban una apariencia reconocible de Material Design.
- **Motivo:** consolidar una experiencia propia de Relevo con profundidad contenida y continuidad espacial.

### 2026-09-22 — Registro evaluativo y movimiento continuo

- **Cambio:** se añadieron sesiones estructuradas, respuesta final opcional, recuento por actividad y cola de sincronización remota.
- **Versión anterior:** solo se almacenaban eventos técnicos locales y el historial no sintetizaba actividades.
- **Motivo:** evaluar elecciones y comportamiento del sistema sin afirmar acciones que la aplicación no puede observar.
- **Cambio visual:** se retiraron sombras de tarjetas, se limitaron a elementos flotantes, se suavizaron transiciones y se incorporó un degradado lento en la acción principal.

### 2026-09-22 — Jerarquía visual y datos vinculados

- **Cambio:** Inicio elimina saludos y estados genéricos, el tutorial concentra la explicación visual y Actividad muestra únicamente aplicaciones elegidas por la persona.
- **Versión anterior:** la ilustración aparecía en Inicio y el resumen de uso incluía todas las aplicaciones registradas por Android.
- **Motivo:** cada elemento debe comunicar una función del sistema y las métricas deben corresponder a decisiones tomadas dentro de Relevo.
- **Cambio visual:** se incorporaron profundidad moderada, un degradado reservado para la acción principal, superficie translúcida elevada en navegación y un selector temporal con mayor jerarquía.

### 2026-09-22 — Tablero, tiempos y retroalimentación

- **Cambio:** se incorporaron navegación inferior, resumen diario, historial, ubicación de la señal, preestablecidos, iconos reales, deslizador de tiempo, transiciones, alarma y notificación final.
- **Versión anterior:** la aplicación comenzaba directamente en una portada y la configuración solo ofrecía tres duraciones.
- **Motivo:** hacer visible el estado del sistema, reducir escritura repetida y permitir configurar condiciones reales sin aumentar la cantidad de pantallas.
- **Corrección técnica:** Android 13 o superior ahora solicita el permiso de notificaciones durante la ejecución.

### 2026-09-21 — Condición automática por aplicación

- **Cambio:** el temporizador pasivo fue reemplazado por la selección de una aplicación y la medición de uso acumulado en primer plano.

### 2026-09-21 — Simplificación del recorrido

- **Cambio:** nueve pantallas fueron reducidas a cuatro momentos y toda la configuración quedó reunida en una sola vista.
- **Versión anterior:** el recorrido separaba formulación, condición, revisión, ubicación, prueba y activación.
- **Motivo:** reducir carga, evitar repeticiones y hacer visible desde el inicio qué hace Relevo.
- **Versión anterior:** la señal aparecía después de una espera, sin reconocer el uso de otras aplicaciones.
- **Motivo:** hacer comprobable la relación central de Relevo entre el uso prolongado de una aplicación elegida y una señal situada.
- **Privacidad:** se incorporaron consentimiento explícito, un identificador aleatorio no nominal, notificación persistente y almacenamiento local limitado.
