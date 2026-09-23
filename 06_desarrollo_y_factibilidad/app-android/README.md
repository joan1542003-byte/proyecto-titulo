# Aplicación Android de Relevo

Prototipo funcional para preparar una intención, elegir una aplicación y emitir una señal cuando esa aplicación permanece en primer plano durante el tiempo definido.

## Estado

**Versión:** 2.4 de prueba

**Fecha:** 23 de septiembre de 2026

**Identificador:** `cl.udp.relevo`

**Android mínimo:** 12, API 31. El requisito se refiere a la versión del sistema, no al año de compra del teléfono.

**APK vigente:** [relevo-android-2.4-2026-09-23.apk](releases/relevo-android-2.4-2026-09-23.apk)

**Proyecto para Android Studio en macOS:** [instrucciones de apertura](ABRIR-EN-MAC.md)

**Paquete portable:** `releases/relevo-android-studio-2.4-2026-09-23.zip`

**Criterios de interfaz y revisión:** [Diseño y experiencia](DISENO-Y-EXPERIENCIA.md)

**Capturas de revisión:** [interfaz 2.2](capturas/interfaz-2.2/README.md)

La aplicación compila, sus pruebas unitarias pasan y la condición automática fue comprobada en Android: al mantener la aplicación elegida en primer plano durante el tiempo configurado, el recordatorio cambia a señal emitida.

## Qué permite hacer

1. escribir una actividad y una forma concreta de comenzar;
2. elegir una aplicación instalada;
3. partir de una de siete actividades ilustradas o escribir una actividad propia;
4. definir el tiempo acumulado entre 1 y 60 minutos mediante un deslizador, además de accesos rápidos y una prueba de 15 segundos;
5. reconocer las aplicaciones por su icono real;
6. consultar Inicio, Actividad y el historial de relevos;
7. ver dónde quedó situada la última señal;
8. autorizar el acceso de uso y las notificaciones exigidas por Android;
9. crear un identificador aleatorio que agrupa los datos sin solicitar nombre, correo ni teléfono;
10. activar un monitoreo visible mediante una notificación persistente;
11. emitir una señal continua por un parlante Bluetooth multimedia conectado, además de vibración breve y notificación; si no existe esa salida, no reproducir sonido por el teléfono;
12. pausar el conteo si la persona sale de la aplicación y retomarlo cuando vuelve;
13. desactivar, silenciar y cerrar el ciclo.
14. responder opcionalmente qué decidió hacer después de la señal;
15. contar cuántas veces se eligió cada actividad y distinguir las señales seguidas de un inicio autodeclarado;
16. conservar sesiones y eventos sin conexión y enviarlos a Supabase cuando la base está configurada.
17. solicitar una sola vez el consentimiento para uso académico antes de mostrar el tutorial o iniciar cualquier registro;
18. enseñar el recorrido mediante cuatro escenas de objetos y una explicación visual de permisos, sin mostrar pantallas ficticias;
19. preparar un relevo por etapas: actividad; aplicación y tiempo; inicio y ubicación; revisión y activación. Las actividades propias se crean en tres pasos y se pueden reutilizar;
20. al terminar el tutorial, preparar opcionalmente el primer relevo o ir a Inicio.

## Límites

Relevo reconoce qué aplicación está en primer plano, pero no lee mensajes, imágenes, búsquedas ni contenidos. Sesiones y eventos se guardan primero en SQLite y luego se sincronizan con Supabase. La autenticación anónima, las tablas y las políticas RLS fueron comprobadas mediante una escritura y lectura reales; el registro de verificación se eliminó al terminar la prueba.

La señal sonora se inicia solo cuando Android confirma que la ruta de reproducción del audio de Relevo es un parlante Bluetooth multimedia. Continúa mientras el ciclo siga en estado «señal emitida», incluso con la app fuera de pantalla, y cesa al silenciar o cerrar el ciclo. Si no hay una salida Bluetooth apta, se muestra el aviso sin emitir el tono por el teléfono. Si la conexión se pierde durante la reproducción, la app corta el tono. La selección de ruta de Android no demuestra por sí sola exclusividad absoluta en todos los modelos; se necesita una prueba en el teléfono y parlante concretos antes de afirmar ese comportamiento en la entrega.

La comprobación anterior se refiere **solo al tono de Relevo**: no impide que YouTube, Instagram u otra app envíen audio al mismo parlante multimedia. Las opciones para separar esos sonidos y la prueba necesaria están en el [análisis de enrutamiento](../enrutamiento-audio-parlante-exclusivo-2026-09-23.md).

## Instalación y permiso

1. instalar el APK;
2. abrir Relevo;
3. leer y aceptar el uso académico de los datos;
4. recorrer el tutorial y, si se desea, configurar el primer relevo desde allí;
5. autorizar **Tiempo de uso** en la última escena;
6. autorizar notificaciones si se quiere recibir el aviso con otra aplicación abierta.

Android muestra una notificación mientras el recordatorio está activo. Esta visibilidad comunica que existe observación en curso y no debe eliminarse.

## Datos de prueba

La estructura y sus límites están descritos en [detección de uso y datos](arquitectura-deteccion-uso-y-datos-2026-09-21.md). Para pruebas académicas se debe usar un código como `P01`; nunca el nombre de la persona. Antes de una base remota se deben aprobar responsable, plazo de conservación, acceso y procedimiento de eliminación.

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
- `monitor/AppUsageMonitorService.kt`: observación visible del primer plano;
- `monitor/UsageAccess.kt`: comprobación del permiso;
- `data/ResearchLogStore.kt`: eventos seudónimos en SQLite;
- `data/ReminderStore.kt`: estado local del recordatorio;
- `signal/SignalPlayer.kt`: sonido y vibración;
- `ui/RelevoViewModel.kt`: coordinación;
- `ui/RelevoApp.kt`: tutorial, preparación por etapas, revisión, estado activo y señal.

## Registro de cambios (disclaimer)

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
