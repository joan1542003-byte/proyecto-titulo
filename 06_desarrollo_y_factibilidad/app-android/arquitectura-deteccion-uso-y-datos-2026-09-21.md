# Detección de uso y registro de datos

## Decisión implementada

La persona elige una o varias aplicaciones instaladas y un límite común. Mientras el relevo está activo, la app consulta los eventos de uso de Android una vez por segundo y comprueba si alguna de las seleccionadas está en primer plano. El tiempo se suma entre ellas; salir de todas pausa el conteo. Al completar el límite, Relevo intenta emitir la señal en la salida de sonido elegida.

Este criterio evita confundir tiempo transcurrido con uso efectivo. También acota la observación a una condición comprensible: aplicaciones elegidas, primer plano y duración acumulada desde la activación. No se establecen límites distintos por app.

## Qué observa y qué no

Relevo utiliza `UsageStatsManager`, la interfaz oficial de Android para consultar eventos de uso. Android exige que la persona conceda manualmente el acceso especial `PACKAGE_USAGE_STATS`. El monitoreo corre como servicio en primer plano y mantiene una notificación visible.

Se conserva únicamente:

- identificador aleatorio del participante, sin nombre, correo ni teléfono;
- paquetes de las aplicaciones elegidas en cada sesión;
- entrada y salida de las aplicaciones elegidas;
- activación, desactivación, señal y cierre;
- fecha, hora y segundos observados.

No se guarda contenido de pantalla, mensajes, teclas, búsquedas, fotografías, contactos ni historial general. El sistema recibe eventos del dispositivo para identificar el primer plano, pero solo compara y registra las aplicaciones seleccionadas. La vista «Actividad» muestra el uso de hoy de esas apps; ese total diario no es el tiempo del relevo activo.

## Base de datos local

Los eventos se guardan en `relevo_research.db`, tabla `events`, dentro del almacenamiento privado de la aplicación. Los campos son `session_id`, `participant_code`, `event_type`, `target_package`, `created_at`, `value_seconds` y `consent_version`. La tabla `sessions` guarda además la actividad, el inicio propuesto, la ubicación, el conjunto de apps elegidas, el límite, las fechas y la respuesta final opcional. Si no suena la ruta seleccionada se registra `signal_failed`, no `signal_emitted`.

La base local permite relacionar eventos de una misma sesión sin guardar nombres. La app intenta sincronizar sus registros con Supabase mediante autenticación anónima cuando la compilación tiene configurada la conexión; los registros pendientes permanecen en el dispositivo si el envío falla. Las políticas de la base permiten a cada identidad leer y borrar solo sus propias filas. Solicitar el borrado desde Privacidad y datos revoca la participación y detiene el monitoreo de inmediato. Luego elimina las filas remotas y confirma que no queden; solo entonces borra las locales y las credenciales. Si falla el borrado remoto, conserva los datos locales para reintentar, sin reactivar el conteo. En una instalación que nunca se conectó a la base, permite el borrado local. Esta ruta aún requiere prueba completa antes de usarla con participantes.

## Condiciones para usar la base remota en el estudio

El consentimiento vigente indica finalidad académica, datos recogidos, correo de contacto y conservación máxima hasta el 30 de diciembre de 2026. La sincronización remota ya forma parte del prototipo; no debe confundirse con una validación completa del tratamiento de datos. Antes de distribuirlo a participantes hay que comprobar en un entorno controlado la escritura de sesiones y eventos, el reintento sin conexión y la eliminación por la misma identidad anónima. También debe definirse el acceso de revisión académica y el procedimiento manual de respuesta a solicitudes por correo.

La base remota no mejora por sí sola la experiencia de Relevo: facilita consolidar datos de la investigación. Por ello se almacenan variables mínimas y el consentimiento se solicita antes de cualquier registro.

## Comprobación realizada

Una iteración anterior comprobó en emulador que el tiempo de una aplicación se acumulaba tras salir y volver. En la versión 2.6 se inspeccionó la selección de dos apps, se ejecutaron las pruebas unitarias y se compiló el APK. Esa inspección no demuestra todavía que la suma funcione durante un ciclo real ni que Supabase reciba todos los eventos. En la base remota se observaron cuatro sesiones y ningún evento; la ruta de envío se corrigió para usar `client_event_id` como clave de conflicto, pero queda pendiente una verificación aislada, sin mezclar datos de prueba con participantes.

## Referencias técnicas

Android Developers. (s. f.). *UsageStatsManager*. https://developer.android.com/reference/android/app/usage/UsageStatsManager

Android Developers. (2026). *Foreground service types are required*. https://developer.android.com/about/versions/14/changes/fgs-types-required

Android Developers. (s. f.). *Declare foreground services and request permissions*. https://developer.android.com/develop/background-work/services/fgs/declare

Android Developers. (s. f.). *Minimize your permission requests*. https://developer.android.com/privacy-and-security/minimize-permission-requests

## Registro de cambios (disclaimer)

### 2026-09-24 — Selección múltiple y base remota

- **Cambio:** se describe el límite común para varias apps, los datos realmente recogidos, la sincronización remota, el borrado solicitado —que detiene el monitoreo inmediatamente— y el estado de verificación.
- **Antes:** el texto afirmaba que solo podía elegirse una app y que los datos nunca salían del teléfono, lo cual ya no corresponde al prototipo.
- **Motivo:** evitar una descripción académica falsa del comportamiento y hacer explícito lo que falta probar.

### 2026-09-21 — Documento inicial

- **Cambio:** se documentó la detección, el límite de observación, el esquema local y las condiciones previas a cualquier sincronización remota.
- **Versión anterior:** no existía una especificación consolidada para la condición automática ni el tratamiento de sus eventos.
- **Motivo:** hacer verificable el comportamiento técnico y evitar que la recolección exceda la finalidad del testeo.
