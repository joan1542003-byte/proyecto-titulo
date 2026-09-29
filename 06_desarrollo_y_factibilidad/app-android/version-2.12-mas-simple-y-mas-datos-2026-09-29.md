# Android 2.12: más simple para la persona y más datos para el proyecto

**Fecha:** 29 de septiembre de 2026. **Versión:** 2.12 (`versionCode 24`). **Rama:** `android-2.7`. **Consentimiento en la app:** `2026-09-29-v8`.
**Base:** [Android 2.11](version-2.11-primer-testeo-2026-09-28.md). La 2.12 quita de la vista de la persona el lenguaje de «prueba», simplifica los textos, enciende los avisos por defecto, usa un código corto, parte en modo claro, registra cómo se usa la app y pide opiniones con un toque. La lógica de las tres semanas no cambia.

## Qué pidió el autor

> «EVITA COMPLEJIZARL OAPRA EL USUARIO, no deberia sentrirse como un testeo, y por favor revisa que se registre todo en nuestar abse de datos. debemos tener la mayro cantidad de datos posibles y asegruarnos que el usuario nos de el mejro feedback de manera facil. seria muy pero muy util que tambien por dfeefecto todas las notifiaciones esten encendidas. y el codig ode usaurio es algo complejo no? deberia ser mas simple. por defecto la app en modo claro. recuerda debe ser lo mas facil posible para el usaurio, sin complejizar ni usar paalbras dificiles.»

## Qué cambió

| Pedido | En la app |
| --- | --- |
| Que no se sienta como un testeo | Las pantallas de la persona ya no hablan de «la prueba», «el investigador», «sesión inicial», «condición» ni «cierre de la semana». La tarjeta del día 0 dice «Tu primer relevo» y desaparece después del primero; la de cada semana dice «Esta semana»; la del cierre, «¿Cómo te fue esta semana?», y la del día 21, «¡Llegaste al día 21! Gracias.». La configuración de las tres semanas salió del perfil: se abre **manteniendo presionado el texto de la versión** al final del perfil, solo para el investigador. |
| Palabras simples | El consentimiento se titula «Antes de empezar», con frases cortas («Tú decides», «Qué guardamos», «Qué no vemos», «Hasta cuándo»). «Privacidad y datos» pasa a «Tus datos»; «Código de participación», a «Tu código»; «Consentimiento», a «Lo que aceptaste»; «Omitir», a «Saltar». La notificación de la semana del teléfono dice «Es momento de volver a elegir» en vez de «Tu intención está disponible». El estado del envío ya no cuenta datos pendientes: dice «Todo está enviado» o «Algunos datos se enviarán cuando haya internet». |
| Notificaciones encendidas | Al llegar a la pantalla de permisos, la app pide sola el permiso de notificaciones de Android (la persona solo toca «Permitir»). Esa pantalla también ofrece quitar la restricción de batería. El aviso semanal y el resumen semanal empiezan encendidos; antes empezaban apagados. |
| Código más simple | Los códigos nuevos tienen 4 caracteres, como `3PVF`, sin letras ni números que se confundan (0 y O, 1 e I, 5 y S, entre otros). Hay 234 256 combinaciones. Los códigos que ya existían no cambian. |
| Modo claro | La app parte en modo claro; antes seguía el tema del teléfono. Se puede cambiar en Perfil › Apariencia. |
| Más datos | Una tabla nueva, `relevo_app_events`, registra cómo se usa la app: cuándo se abre y cuánto tiempo queda abierta, qué pantallas y pestañas se ven, cuánto del video se mira y si se activa su sonido, el consentimiento aceptado, los permisos cuando cambian, los intereses, el emoji y si hay nombre (no el nombre), las actividades propias, los cambios de ruta, los ajustes, cada paso de la preparación y si se cerró sin activar, las pruebas de sonido, la salida elegida y el aviso semanal. Cada relevo guarda además cómo le cayó el aviso. Todo va a Supabase, a la base del teléfono y a la copia en Documentos/Relevo (ahora con una cuarta tabla, `…-uso.csv`), y se envía también al salir de la app. |
| Preguntas siempre | Las preguntas tras el aviso se hacen cada vez que suena, aunque el investigador no haya configurado las tres semanas. Antes solo aparecían con la prueba configurada. |
| Opinión fácil | Tras cada aviso, «¿Cómo te cayó el aviso?» con tres caras (Bien, Normal, Mal). Después del tercer y del décimo relevo, Inicio muestra «¿Qué tal te va con Relevo?» con cinco caras: un toque la envía; «Contar más» abre el comentario. Las caras son emoji 3D de Google (Noto, SIL OFL 1.1); se sumaron cuatro. |

En Supabase se sumaron la tabla de uso, la columna `signal_feeling` y dos vistas en el esquema `analisis`: `analisis.uso` (cada registro, con hora de Chile) y `analisis.resumen_de_uso` (por persona: días con uso, aperturas, minutos en la app, pantallas vistas y preparaciones sin activar). El SQL está al final de [base-remota-supabase.sql](base-remota-supabase.sql). El revisor de seguridad de Supabase no mostró avisos nuevos; siguen los que ya existían sobre las sesiones anónimas, que son parte del diseño.

## Comprobaciones

En un emulador Android 16, con conexión y datos de prueba:

- 61 pruebas unitarias pasan (3 nuevas sobre el código corto) y el APK sale de una compilación limpia.
- **Primera vez:** «Cómo funciona», «Antes de empezar» con los textos nuevos y el pedido automático de notificaciones al llegar a los permisos. El código asignado fue de 4 caracteres.
- **Configuración oculta:** mantener presionado el texto de la versión abrió la configuración de las tres semanas.
- **Tres relevos de 15 segundos:** con la reacción marcada, llegaron a Supabase con `signal_feeling`, las dos preguntas y la decisión.
- **Opinión rápida:** tras el tercer relevo apareció la tarjeta de Inicio; la respuesta llegó como `opinion_rapida`.
- **Registro de uso:** llegaron 68 registros de 12 tipos, entre ellos el video (segundos vistos y sonido activado), los permisos, los intereses y el tiempo en la app. `analisis.resumen_de_uso` mostró 6 aperturas, 7 minutos en la app y 23 pantallas.
- **Borrar mis datos:** dejó en 0 los registros de uso y los demás datos de ese código, y vació Documentos/Relevo.

Los datos de prueba se borraron desde la app; Supabase quedó con las filas previas (8 sesiones, 9 eventos, 0 respuestas y 0 registros de uso). Los datos que ya tenía el emulador se respaldaron antes y se restauraron después.

**Corregido durante la prueba:** las etiquetas bajo las caras se recortaban en los bordes y la tarjeta «Tu primer relevo» seguía visible después del primero. Las correcciones se compilaron y el borrado se volvió a comprobar con ellas, pero las caras corregidas no se volvieron a fotografiar.

## Lo que no se comprobó

- El teléfono y el parlante de la prueba.
- El borrado sin conexión.
- Las tarjetas del cierre de semana y del día 21 con las fechas reales.
- Con TalkBack, las caras se leen por su nombre («Bien», «Normal», «Mal»), pero no se probó con el lector de pantalla.

## Cuidados

- **Consentimiento:** como se guardan más datos, el texto cambió y la versión pasó a v8. Hay que actualizar la hoja firmada y que el profesor guía la revise. La [hoja de consentimiento](../../07_validacion/consentimiento-android-vigente-2026-09-23.md) ya tiene el texto nuevo.
- **Sigue siendo un estudio:** la app evita el lenguaje de «prueba» en el uso diario, pero el consentimiento dice con claridad que es parte de un proyecto de título y que se guardan datos. Eso no se puede ocultar.
- **El nombre no se envía.** Solo se registra si la persona escribió uno o no.
- **Códigos:** con 4 caracteres, la probabilidad de que dos personas reciban el mismo código es muy baja con pocas personas, pero no es cero. Al anotar el código en la hoja firmada, conviene revisar que no se repita.

## Registro de cambios (disclaimer)

### 2026-09-29 — Creación

- **Qué se añadió:** el registro de Android 2.12: lenguaje sin «prueba», textos simples, notificaciones, código corto, modo claro, registro del uso de la app, reacción al aviso, opinión rápida, consentimiento v8, comprobaciones y cuidados.
- **Cómo estaba antes:** la 2.11 hablaba de «la prueba» en varias pantallas, dejaba apagados los avisos opcionales, usaba códigos de 10 caracteres y no registraba el uso de la app.
- **Por qué:** el autor pidió que la app sea lo más fácil posible, que no se sienta como un testeo y que se registre la mayor cantidad de datos posible (D-087).
