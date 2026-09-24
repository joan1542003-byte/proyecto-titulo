# Protección de datos y aviso de privacidad del prototipo Android 2.5

**Estado:** auditoría documental y borrador para revisión académica y jurídica antes de pruebas con participantes. **Corte:** 23 de septiembre de 2026; el esquema remoto documentado en 2.3 permanece en 2.5. Este documento describe el prototipo del repositorio; no equivale a una política publicada ni acredita que todas sus promesas se ejecuten. **Contacto confirmado por el autor:** joan1542003@gmail.com. **Límite propuesto de conservación:** 30 de diciembre de 2026, sujeto a comprobar la eliminación completa.

## Respuesta breve para la comisión

«Relevo solicita acceso a datos de uso de Android para contar el tiempo de la aplicación que la persona eligió. No necesita leer mensajes ni contenido de pantalla. En el prototipo de investigación se guardan localmente la intención, el comienzo, el lugar declarado, la app elegida, el umbral y eventos técnicos de la sesión. Si la base remota está configurada, una copia se envía a Supabase asociada a un identificador aleatorio. Por eso hablamos de datos seudonimizados, no anónimos: la actividad, los horarios y el código pueden permitir relacionar registros con una persona. El consentimiento académico se presenta antes del permiso del sistema. El contacto del responsable es joan1542003@gmail.com y el plazo propuesto de eliminación es el 30 de diciembre de 2026. Antes de usarlo con participantes debemos comprobar la eliminación local y remota, la salida Bluetooth y el flujo de retiro. No presentaremos resultados ni protección efectiva que no hayamos verificado».

## Inventario comprobado en el repositorio

| Dato y flujo | Evidencia | Uso y límite |
| --- | --- | --- |
| `PACKAGE_USAGE_STATS` | [Manifest](../06_desarrollo_y_factibilidad/app-android/app/src/main/AndroidManifest.xml) y [servicio de observación](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/monitor/AppUsageMonitorService.kt) | Acceso especial autorizado en Ajustes. El permiso técnicamente abre estadísticas de uso; la promesa de observar solo la app elegida depende del código y debe probarse. No equivale a permiso para investigar. |
| Configuración e historial | [ReminderStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/ReminderStore.kt), [HistoryStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/HistoryStore.kt), [CustomActivityStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/CustomActivityStore.kt) | Actividad, comienzo, lugar declarado, app, tiempo, estado e historial local. El historial se limita a 30 entradas, pero eso no borra las filas de investigación. |
| Registro de investigación | [ResearchLogStore](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/ResearchLogStore.kt) | Sesiones y eventos en SQLite, con código de participante, identificadores, tiempos y respuesta final opcional. |
| Sincronización | [RemoteSync](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/RemoteSync.kt) | Si URL y clave publicable están configuradas, envía sesiones y eventos por HTTPS a Supabase, con reintento de pendientes. No debe afirmarse «solo local» para esa configuración. |
| Consentimiento y borrado | [pantalla de consentimiento](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/RelevoApp.kt) y [ViewModel](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/RelevoViewModel.kt) | La aceptación académica se versiona y se vuelve a solicitar al cambiar su texto. El código de participación se conserva entre ciclos y se ve en Historial. `reset()` borra la configuración activa, pero no elimina historial, SQLite, credenciales ni filas remotas; no anunciar «borrar todos mis datos» como función existente. |
| Respaldo del sistema | [Manifest](../06_desarrollo_y_factibilidad/app-android/app/src/main/AndroidManifest.xml) | `allowBackup=false` está declarado. Debe verificarse el comportamiento real en los dispositivos del piloto. |

Un identificador aleatorio o autenticación anónima de Supabase no anonimiza por sí mismos una serie de actividades, lugares declarados y marcas temporales. El código entregado para solicitar eliminación también crea un vínculo operativo. Se recomienda hablar de **seudonimización** y limitar el acceso a la tabla de correspondencia y a las hojas firmadas. La política de acceso por fila indicada en la [documentación remota](../06_desarrollo_y_factibilidad/app-android/conexion-base-remota-2026-09-21.md) fue probada técnicamente, pero RLS no define por sí sola retención, copias de seguridad ni retiro del consentimiento. El código estable de 2.5 rige los ciclos nuevos; instalaciones de prueba anteriores pudieron generar códigos distintos y no deben identificarse solo por el código que hoy se ve en Historial.

## Marco normativo y criterio aplicado

Al 23 de septiembre de 2026, la [Ley chilena N.º 19.628](https://www.bcn.cl/leychile/Navegar?idNorma=141599) rige el tratamiento de datos personales. La [Ley N.º 21.719](https://www.bcn.cl/leychile/navegar?idNorma=1209272) modificará ese marco con vigencia general diferida al **1 de diciembre de 2026**. Como la memoria se entrega en diciembre, la documentación y la operación del piloto deben revisarse de nuevo antes de esa fecha. Esta ficha no determina una base jurídica definitiva ni sustituye la revisión institucional.

Android documenta que `PACKAGE_USAGE_STATS` permite consultar estadísticas de uso y exige concesión mediante Ajustes. Esa autorización técnica no sustituye una explicación de finalidad, almacenamiento y retiro. Las [políticas de datos de Google Play](https://support.google.com/googleplay/android-developer/answer/10144311) tratan el inventario y los datos de uso de otras apps como información sensible, y piden transparencia, divulgación visible y política accesible para una publicación en Play. El piloto por APK también necesita información comprensible para participantes, aunque la ficha de tienda no sea su canal de distribución.

## Texto candidato para el aviso previo al permiso

> **Acceso a datos de uso**
>
> Relevo necesita que Android le permita consultar el uso de aplicaciones para contar el tiempo de la app que elijas mientras tu relevo esté activo. Este permiso puede dar acceso técnico a información de uso de otras apps; el prototipo está diseñado para utilizar la app seleccionada. Relevo no lee mensajes, fotos, búsquedas ni lo que haces dentro de esas apps. Puedes retirar el permiso en Ajustes. Si no lo concedes, la función de conteo real no podrá activarse.

> **Datos del estudio**
>
> Para evaluar el prototipo se guardan en el teléfono tu actividad elegida, cómo quieres comenzar, el lugar que declaras, la app y el tiempo configurados, las marcas de activación y aviso, y tu respuesta final si decides darla. Si la base de investigación está habilitada, esos registros se envían también a Supabase mediante un código aleatorio. No se solicita tu nombre dentro de la app. La hoja de consentimiento firmada se conserva por separado. Antes de aceptar recibirás el contacto del responsable, el plazo de conservación y la forma comprobada de solicitar eliminación.

El texto debe adaptarse a la configuración efectivamente instalada. No debe dejarse «si la base está habilitada» como incertidumbre en una sesión concreta: el investigador debe declarar **local únicamente** o **local y remota** antes de entregar el dispositivo. La aceptación de investigación debe mantenerse separada del permiso de Android y de las notificaciones.

## Campos pendientes antes de publicar una política o reclutar

1. El correo confirmado, joan1542003@gmail.com, ya figura en el borrador de consentimiento Android; comprobar que el canal reciba solicitudes antes de testear. El paquete imprimible fechado antes de esta corrección conserva el contacto en blanco y no debe entregarse sin actualizarlo.
2. Confirmar región de alojamiento de Supabase, quién administra el proyecto, quién puede exportar datos, respaldos y acceso de proveedores. No prometer residencia en Chile sin verificarla.
3. Aplicar el plazo propuesto por el autor, **30 de diciembre de 2026**, a cada soporte y comprobar que la eliminación abarque teléfono, SQLite, historial, credenciales, servidor y respaldos aplicables, y que pueda buscarse por el código entregado. El plazo anterior de 13 de enero de 2027 en documentos fechados no gobierna este prototipo Android.
4. Probar retiro de consentimiento y eliminación con una sesión ficticia de extremo a extremo. Distinguir detener el relevo, revocar el permiso y pedir borrado de registros ya recogidos.
5. Revisar el texto de consentimiento en la app y las hojas para que enumeren los mismos campos; hoy la pantalla resumida omite comienzo, lugar declarado, app/paquete y respuesta final que sí aparecen en la base.
6. Confirmar si el estudio utilizará exclusivamente adultos. Si cambia la muestra, revisar consentimiento y datos con el marco aplicable.
7. Restringir ejemplos de actividades y lugares que revelen datos sensibles innecesarios; ofrecer formulaciones generales y permitir no responder a la evaluación final.

## Referencias

- Biblioteca del Congreso Nacional de Chile. (1999). *Ley N.º 19.628 sobre protección de la vida privada*. https://www.bcn.cl/leychile/Navegar?idNorma=141599
- Biblioteca del Congreso Nacional de Chile. (2024). *Ley N.º 21.719: Regula la protección y el tratamiento de los datos personales y crea la Agencia de Protección de Datos Personales*. https://www.bcn.cl/leychile/navegar?idNorma=1209272
- Google. (s. f.). *User data*. Play Console Help. https://support.google.com/googleplay/android-developer/answer/10144311
- Google. (s. f.). *Manifest.permission*. Android Developers. https://developer.android.com/reference/android/Manifest.permission#PACKAGE_USAGE_STATS

## Registro de cambios (disclaimer)

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
