# Consentimiento para evaluar el prototipo Android de Relevo

**Borrador para revisión docente, alineado con el [protocolo 02](protocolo-02-prueba-21-dias.md) y la app 2.7 que ese protocolo requiere. No entregar a participantes hasta comprobar eliminación local y remota, envío de eventos, salida de audio y versión del APK.** Responsable: Johan Yantén, Proyecto de Título de Diseño, Universidad Diego Portales. Contacto para preguntas, retiro o solicitud de eliminación: **joan1542003@gmail.com**.

## En qué consiste

Se me invita a probar durante 21 días una aplicación Android y un parlante Bluetooth, propio o prestado. La prueba comienza con una sesión de unos 45 minutos en la que el investigador me acompaña a preparar Relevo y observa una primera señal. Después, cada semana la app me pedirá dejar el parlante en un lugar distinto, o usar el teléfono como aviso. Elegiré actividades que me gustaría considerar, cómo podría empezar y una o varias aplicaciones cuyo tiempo de uso se sumará. Al cumplirse el límite que configuré, sonará una señal de unos 30 segundos que se detiene sola. Tras cada señal, y al final de cada semana, la app me hará preguntas breves de un toque, que puedo omitir. Al terminar, se me invitará a una conversación de unos 15 minutos. El parlante es material de prueba; no representa el objeto final.

## Mi decisión

Participar es voluntario. Puedo omitir preguntas, silenciar el aviso, retirar el permiso de Android o terminar la prueba sin explicar por qué ni sufrir consecuencias. La actividad que elija no será juzgada. El sonido puede resultar inoportuno o molestar a otras personas. Si eso ocurre, puedo detenerlo y comunicarlo. No debo entregar contraseñas, mensajes ni información de salud.

## Datos y permisos

La aplicación solicita acceso de Android a estadísticas de uso para contar las aplicaciones elegidas. Ese permiso técnico puede permitir consultar uso de otras aplicaciones. El prototipo está diseñado para contabilizar las seleccionadas mientras el ciclo está activo y, además, cuánto uso cada día las aplicaciones que elegí alguna vez en Relevo y cuánto tiempo uso el teléfono en total; de las demás aplicaciones no guarda el nombre. Si enciendo la activación automática, que empieza apagada, la app además revisa qué aplicación tengo abierta, solo su nombre, para activar sola mi último relevo cuando abro una de las elegidas; puedo apagarla cuando quiera. Las notificaciones son un permiso separado. El responsable puede enviarme mensajes sobre la prueba, que llegan como notificación de Relevo. Ningún permiso del sistema sustituye esta decisión de participar.

El teléfono conserva un código aleatorio, la actividad, cómo quiero empezar, el lugar que declaro, las aplicaciones elegidas, el tiempo configurado y acumulado, los momentos de activación, aviso y respuesta, si el relevo se activó a mano o solo, si eliminé un relevo activo, cuándo llegó y cuándo abrí cada mensaje del responsable, si silencié la señal, el uso de las aplicaciones elegidas en los minutos anteriores y posteriores a la señal, el tiempo de uso y las veces que abro cada día las aplicaciones que elegí alguna vez, el tiempo total de uso del teléfono por día desde 7 días antes de aceptar, el modelo del teléfono, su versión de Android, los permisos que di, y las respuestas que decida dar, incluida una reacción con caras después de cada aviso. También se guarda cómo uso Relevo: cuándo lo abro y por cuánto tiempo, qué pantallas veo, cuánto del video de explicación miro, los permisos que doy, mis intereses, mis actividades, los cambios en mi ruta y los ajustes que cambio. Mi nombre, que escribo al empezar, se guarda en Supabase en una tabla aparte, solo junto a mi código, para que el responsable sepa quién participa; no se guarda junto a mis actividades, respuestas ni uso de la app. La app intenta enviar estos registros a una base de datos Supabase; si no hay conexión, quedan pendientes en el teléfono. Además, la app guarda una copia de estos registros, sin mi nombre, en la carpeta Documentos/Relevo del teléfono, para que el responsable pueda recuperar los resultados si falla el envío; esa copia se borra cuando pido la eliminación desde la app. El código reemplaza mi nombre en esos registros, pero no los vuelve anónimos: la combinación de actividades, lugares y horarios podría identificarme. La hoja firmada se guardará separada de los registros. No se recopilan mensajes, fotografías, búsquedas ni contenido de pantalla.

Puedo pedir la eliminación de mis registros al correo indicado, entregando el código de participación que aparece en Relevos, o solicitarla desde Privacidad y datos en la app. Si no pido antes su eliminación, se eliminarán, como máximo, el **30 de diciembre de 2026**; después solo quedarán resultados agregados sin vínculo conmigo. La solicitud desde la app detiene el conteo inmediatamente. Si el borrado remoto falla, mantiene los registros locales para poder reintentar y muestra el problema; no reanuda el monitoreo. Antes de iniciar el estudio, el responsable debe comprobar que puede localizar y borrar los datos del teléfono y de Supabase, incluidos los pendientes de sincronización, y explicar qué ocurre con los respaldos. Los resultados académicos se presentarán sin mi nombre.

## Aceptación

He recibido esta explicación, pude hacer preguntas y acepto participar durante 21 días.

Código de participación: ____________________  Fecha: ____________________

Nombre y firma de participante: ____________________________________________

Firma del responsable: _____________________________________________________

## Registro de cambios (disclaimer)

### 2026-09-30 — Uso diario y estado del teléfono (versión v11 en la app)

- **Qué cambió:** el consentimiento dice que también se guardan, cada día, el tiempo de uso y las aperturas de las aplicaciones elegidas alguna vez en Relevo y el tiempo total de uso del teléfono, desde 7 días antes de aceptar, sin el nombre de las demás aplicaciones; el modelo del teléfono, la versión de Android y los permisos; y si se eliminó un relevo activo. En Android 2.18 pasa a `2026-09-30-v11`.
- **Cómo estaba antes:** el uso de las aplicaciones se guardaba solo en los 10 minutos anteriores y posteriores a cada señal, y no se guardaban el equipo ni los permisos.
- **Por qué:** el autor pidió registrar todo lo de cada participante: apps elegidas, uso y configuración (D-097). Sigue pendiente la revisión docente, ahora con más datos personales que revisar.

### 2026-09-30 — Activación automática y mensajes (versión v10 en la app)

- **Qué cambió:** el consentimiento explica la activación automática, que revisa qué aplicación está abierta mientras está encendida, y los mensajes del responsable; registra si cada relevo se activó a mano o solo y cuándo llegó y se abrió cada mensaje. En Android 2.16 pasa a `2026-09-30-v10`.
- **Cómo estaba antes:** la app solo contaba mientras un relevo estaba activo y no había mensajes.
- **Por qué:** el autor pidió ambas funciones, también durante el testeo (D-095 y D-096). Sigue pendiente la revisión docente.

### 2026-09-29 — Nombre guardado aparte (versión v9 en la app)

- **Qué cambió:** el nombre se guarda en Supabase, en una tabla aparte, solo con el código. En Android 2.13 el consentimiento pasa a `2026-09-29-v9`.
- **Cómo estaba antes:** el nombre quedaba solo en el teléfono (D-076).
- **Por qué:** el autor pidió guardar el nombre para tener el registro de cada participante (D-089).

### 2026-09-29 — Uso de la app (versión v8 en la app)

- **Qué cambió:** la hoja dice que también se guardan la reacción tras cada aviso y cómo se usa Relevo (aperturas, tiempo, pantallas, video, permisos, intereses, actividades, ruta y ajustes). En Android 2.12 el consentimiento pasa a la versión `2026-09-29-v8`, con el mismo contenido en palabras más simples.
- **Cómo estaba antes:** solo se guardaban los relevos, sus eventos y las respuestas.
- **Por qué:** el autor pidió registrar la mayor cantidad de datos posible (D-087).

### 2026-09-28 — Copia en el teléfono (versión v7 en la app)

- **Qué cambió:** la hoja dice que la app guarda una copia de los registros, sin el nombre, en Documentos/Relevo, y que se borra al pedir la eliminación desde la app. En Android 2.11 el consentimiento pasa a la versión `2026-09-28-v7`.
- **Cómo estaba antes:** los registros quedaban solo en la base interna de la app y en Supabase.
- **Por qué:** el autor pidió que todo quede guardado en la base de datos y también en el teléfono, para tener copia de los resultados.

### 2026-09-25 — Prueba de 21 días

- **Qué cambió:** la hoja describe la prueba de 21 días del protocolo 02: sesión inicial, una condición por semana, señal de unos 30 segundos, preguntas de un toque, entrevista final, datos adicionales y eliminación como máximo el 30 de diciembre de 2026.
- **Cómo estaba antes:** describía una prueba de dos días con Android 2.6.
- **Por qué:** decisiones D-075, D-078 y D-079 del autor.

### 2026-09-24 — Contenido de la versión 2.6

- **Qué cambió:** la hoja describe varias apps con límite común, la alternativa de sonido en el teléfono, los registros pendientes y la ruta de eliminación desde la app.
- **Cómo era antes:** se refería a 2.5, una sola app, un parlante obligatorio y solo una petición por correo.
- **Por qué:** la persona debe conocer exactamente lo que hará el prototipo y cómo tratará sus datos antes de aceptar.

### 2026-09-23 — Código localizable

- **Qué cambió:** la hoja indica dónde verá la persona su código de participación en la app.
- **Cómo era antes:** decía que recibiría un código, pero no identificaba una ruta verificable para consultarlo.
- **Por qué:** permitir que la persona pueda usarlo al preguntar por sus registros o solicitar su eliminación.
- **Límite:** mostrar el código no demuestra aún que el borrado local y remoto funcione; eso sigue siendo una condición previa.

### 2026-09-23 — Borrador Android actualizado

- **Qué cambió:** se creó una hoja específica para el prototipo Android 2.4, con el correo confirmado, el plazo propuesto, los campos locales y remotos y la diferencia entre consentimiento y permisos.
- **Cómo era antes:** el paquete fechado para la corrección mantenía un contacto en blanco, un plazo de 13 de enero de 2027 y una formulación condicional sobre la base remota.
- **Por qué:** permitir revisión de un texto que describa la configuración prevista sin ocultar la ruta de datos ni prometer una eliminación que aún no se ha comprobado.
- **Límite:** este borrador no autoriza reclutamiento ni sustituye la prueba técnica de eliminación y salida de audio.
