# Protección de datos y aviso de privacidad del prototipo Android 2.6

**Estado:** auditoría documental y borrador para revisión académica y jurídica antes de pruebas con participantes. **Corte:** 24 de septiembre de 2026. Este documento describe el prototipo del repositorio; no equivale a una política publicada ni acredita que todas sus promesas se ejecuten. **Contacto confirmado por el autor:** joan1542003@gmail.com. **Límite propuesto de conservación:** 30 de diciembre de 2026, sujeto a comprobar la eliminación completa.

## Respuesta breve para la comisión

«Relevo solicita acceso a datos de uso de Android para sumar el tiempo de las aplicaciones que la persona eligió mientras el relevo está activo. No necesita leer mensajes ni contenido de pantalla. En el prototipo de investigación se guardan localmente la actividad, el comienzo previsto, el lugar declarado, las apps elegidas, el límite y eventos técnicos de la sesión. Si la base remota está configurada, la app intenta enviarlos a Supabase asociados a un identificador aleatorio. Por eso hablamos de datos seudonimizados, no anónimos: la actividad, los horarios y el código podrían relacionar registros con una persona. El consentimiento académico se presenta antes del permiso del sistema y antes de crear un código local nuevo. El contacto del responsable es joan1542003@gmail.com y el plazo máximo propuesto es el 30 de diciembre de 2026. Antes de usarlo con participantes debemos comprobar la eliminación local y remota, el envío de eventos, la salida Bluetooth y el flujo de retiro. No presentaremos resultados ni protección efectiva que no hayamos verificado».

## Inventario comprobado en el repositorio

| Dato y flujo | Evidencia | Uso y límite |
| --- | --- | --- |
| `PACKAGE_USAGE_STATS` | [Manifest](../06_desarrollo_y_factibilidad/app-android/app/src/main/AndroidManifest.xml) y [servicio de observación](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/monitor/AppUsageMonitorService.kt) | Acceso especial autorizado en Ajustes. El permiso técnicamente abre estadísticas de uso; la promesa de contar solo las apps elegidas depende del código y debe probarse. No equivale a consentimiento para investigar. |
| Configuración e historial | [ReminderStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/ReminderStore.kt), [HistoryStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/HistoryStore.kt), [CustomActivityStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/CustomActivityStore.kt) | Actividad, comienzo, lugar declarado, apps, tiempo, estado e historial local. El historial conserva hasta 200 entradas; eso no borra las filas de investigación. |
| Registro de investigación | [ResearchLogStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/ResearchLogStore.kt) | Sesiones y eventos en SQLite, con código de participante, identificadores, tiempos y respuesta final opcional. |
| Sincronización | [RemoteSync](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/RemoteSync.kt) | Si URL y clave publicable están configuradas, envía sesiones y eventos por HTTPS a Supabase, con reintento de pendientes. No debe afirmarse «solo local» para esa configuración. |
| Consentimiento y borrado | [pantalla de consentimiento](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/RelevoApp.kt) y [ViewModel](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/RelevoViewModel.kt) | La aceptación académica se versiona. El código de participación se crea al aceptar y se conserva entre ciclos; se ve en Relevos. Privacidad y datos ofrece solicitar borrado; al pedirlo se detiene el conteo y se bloquean nuevos envíos. La eliminación remota y local está programada, pero falta comprobarla de extremo a extremo. `reset()` solo reinicia el ciclo: no equivale a borrar todos los datos. |
| Respaldo del sistema | [Manifest](../06_desarrollo_y_factibilidad/app-android/app/src/main/AndroidManifest.xml) | `allowBackup=false` está declarado. Debe verificarse el comportamiento real en los dispositivos del piloto. |

Un identificador aleatorio o autenticación anónima de Supabase no anonimiza por sí mismos una serie de actividades, lugares declarados y marcas temporales. El código entregado para solicitar eliminación también crea un vínculo operativo. Se recomienda hablar de **seudonimización** y limitar el acceso a las hojas firmadas. Las políticas de acceso por fila de la [documentación remota](../06_desarrollo_y_factibilidad/app-android/conexion-base-remota-2026-09-21.md) delimitan las filas accesibles para cada identidad, pero no definen por sí solas retención, copias de seguridad ni retiro del consentimiento. Instalaciones de prueba anteriores pudieron generar códigos distintos y no deben identificarse solo por el código que hoy se ve en Relevos.

## Marco normativo y criterio aplicado

Al 24 de septiembre de 2026, la [Ley chilena N.º 19.628](https://www.bcn.cl/leychile/Navegar?idNorma=141599) rige el tratamiento de datos personales. La [Ley N.º 21.719](https://www.bcn.cl/leychile/navegar?idNorma=1209272) modificará ese marco con vigencia general diferida al **1 de diciembre de 2026**. Como la memoria se entrega en diciembre, la documentación y la operación del piloto deben revisarse de nuevo antes de esa fecha. Esta ficha no determina una base jurídica definitiva ni sustituye la revisión institucional.

Android documenta que `PACKAGE_USAGE_STATS` permite consultar estadísticas de uso y exige concesión mediante Ajustes. Esa autorización técnica no sustituye una explicación de finalidad, almacenamiento y retiro. Las [políticas de datos de Google Play](https://support.google.com/googleplay/android-developer/answer/10144311) tratan el inventario y los datos de uso de otras apps como información sensible, y piden transparencia, divulgación visible y política accesible para una publicación en Play. El piloto por APK también necesita información comprensible para participantes, aunque la ficha de tienda no sea su canal de distribución.

## Texto candidato para el aviso previo al permiso

> **Acceso a datos de uso**
>
> Relevo necesita que Android le permita consultar el uso de aplicaciones para sumar el tiempo de las apps que elijas mientras tu relevo esté activo. Este permiso puede dar acceso técnico a información de uso de otras apps; el prototipo está diseñado para contar solo las seleccionadas. Relevo no lee mensajes, fotos, búsquedas ni lo que haces dentro de esas apps. Puedes retirar el permiso en Ajustes. Si no lo concedes, la función de conteo real no podrá activarse.

> **Datos del estudio**
>
> Para evaluar el prototipo se guardan en el teléfono tu actividad elegida, cómo quieres comenzar, el lugar que declaras, las apps y el límite configurados, las marcas de activación y aviso, y tu respuesta final si decides darla. Si la base de investigación está habilitada, la app intenta enviar esos registros a Supabase asociados a un código aleatorio. No se solicita tu nombre dentro de la app. La hoja de consentimiento firmada se conserva por separado. Antes de aceptar recibirás el contacto del responsable, el plazo de conservación y la forma de solicitar eliminación.

El texto debe adaptarse a la configuración efectivamente instalada. No debe dejarse «si la base está habilitada» como incertidumbre en una sesión concreta: el investigador debe declarar **local únicamente** o **local y remota** antes de entregar el dispositivo. La aceptación de investigación debe mantenerse separada del permiso de Android y de las notificaciones.

## Campos pendientes antes de publicar una política o reclutar

1. El correo confirmado, joan1542003@gmail.com, ya figura en el borrador de consentimiento Android; comprobar que el canal reciba solicitudes antes de testear. El paquete imprimible fechado antes de esta corrección conserva el contacto en blanco y no debe entregarse sin actualizarlo.
2. Confirmar región de alojamiento de Supabase, quién administra el proyecto, quién puede exportar datos, respaldos y acceso de proveedores. No prometer residencia en Chile sin verificarla.
3. Aplicar el plazo propuesto por el autor, **30 de diciembre de 2026**, a cada soporte y comprobar que la eliminación abarque teléfono, SQLite, historial, credenciales, servidor y respaldos aplicables, y que pueda buscarse por el código entregado. El plazo anterior de 13 de enero de 2027 en documentos fechados no gobierna este prototipo Android.
4. Probar retiro de consentimiento y eliminación con una sesión ficticia de extremo a extremo. Distinguir detener el relevo, revocar el permiso y pedir borrado de registros ya recogidos.
5. Contrastar de nuevo, después de cualquier cambio de versión, el texto de consentimiento en la app y las hojas: deben enumerar los mismos campos. La versión 2.6 ya menciona comienzo, lugar, apps, identificadores internos y respuesta opcional.
6. Confirmar si el estudio utilizará exclusivamente adultos. Si cambia la muestra, revisar consentimiento y datos con el marco aplicable.
7. Restringir ejemplos de actividades y lugares que revelen datos sensibles innecesarios; ofrecer formulaciones generales y permitir no responder a la evaluación final.

## Referencias

- Biblioteca del Congreso Nacional de Chile. (1999). *Ley N.º 19.628 sobre protección de la vida privada*. https://www.bcn.cl/leychile/Navegar?idNorma=141599
- Biblioteca del Congreso Nacional de Chile. (2024). *Ley N.º 21.719: Regula la protección y el tratamiento de los datos personales y crea la Agencia de Protección de Datos Personales*. https://www.bcn.cl/leychile/navegar?idNorma=1209272
- Google. (s. f.). *User data*. Play Console Help. https://support.google.com/googleplay/android-developer/answer/10144311
- Google. (s. f.). *Manifest.permission*. Android Developers. https://developer.android.com/reference/android/Manifest.permission#PACKAGE_USAGE_STATS

## Registro de cambios (disclaimer)

### 2026-09-24 — Conciliación con Android 2.6

- **Qué cambió:** se corrigieron los datos recogidos, el límite compartido, el historial, la creación del código tras consentimiento, la ruta de borrado y la diferencia entre instalación local y conexión remota. Se cotejó la fecha de entrada en vigencia de la Ley N.º 21.719 con la Biblioteca del Congreso Nacional.
- **Cómo era antes:** la ficha describía una sola app, historial de 30 entradas y ausencia de una ruta de eliminación en la interfaz.
- **Por qué:** permitir explicar el tratamiento real sin presentar implementación como verificación jurídica o técnica completa.

### 2026-09-23 — Código estable y consentimiento 2.5

- **Qué cambió:** se actualizó el alcance técnico a 2.5: nueva versión de consentimiento y un código visible y persistente entre relevos.
- **Cómo era antes:** el código cambiaba al cerrar cada ciclo y la auditoría describía la versión 2.4.
- **Por qué:** facilitar la localización de registros y evitar que una aceptación anterior cubra un texto distinto.
- **Límite:** sigue sin demostrarse la eliminación de los registros locales y remotos ni la gestión de respaldos.

### 2026-09-23 — Contacto, plazo y versión actual

- **Qué cambió:** se incorporaron el correo confirmado y la fecha máxima propuesta por el autor, y se indicó que el flujo auditado en Android 2.3 continúa en 2.4.
- **Cómo era antes:** contacto y plazo figuraban como pendientes; se citaba el 13 de enero de 2027 del paquete anterior.
- **Por qué:** permitir una explicación concreta ante la comisión sin aparentar que ya existe una ruta comprobada de borrado local y remoto.
- **Límite:** no habilita reclutamiento; hay que verificar el canal, la eliminación y la revisión académica.

### 2026-09-23 — Creación

- **Qué cambió:** se inventariaron datos, flujos y huecos de privacidad del prototipo 2.3, se redactó una respuesta para la comisión y texto candidato para permisos y estudio.
- **Antes:** había consentimiento y modelo de datos separados, sin una conciliación explícita con la sincronización y las rutas reales de borrado.
- **Por qué:** evitar prometer anonimato, almacenamiento exclusivamente local o eliminación integral que el repositorio no demuestra.
- **Alcance:** revisión documental; no se modificó la app, la base ni el consentimiento en uso. Requiere revisión académica y jurídica y verificación técnica antes de participantes.
