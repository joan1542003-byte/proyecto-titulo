# Android 1.0.0: la versión final

**Fecha:** 4 de noviembre de 2026. **Decisiones:** D-153 y D-154. **Rama:** `android-1.0.0`, desde `main` (3.3). **APK:** [relevo-android-1.0.0-2026-11-04.apk](releases/relevo-android-1.0.0-2026-11-04.apk), 10,1 MB, `versionCode` 50, firmada con el mismo certificado que todas las anteriores (`fdbe6bbe…`): se instala encima de la 3.3 y de la 2.33 sin perder datos.

## Qué es

La versión definitiva de Relevo, por ahora. Parte de la 3.3, la de la línea visual nueva, y aplica la revisión con los profesores del 28 de octubre ([tarea 10 de Por hacer](../../00_gobernanza/por-hacer.md)), lo que mostró la prueba en los hogares (Tabla 4 de la memoria v6) y el [estudio de los textos](textos/estudio-escritura-de-interfaces-2026-10-24.md). Se llama 1.0.0 porque deja de ser un prototipo para una prueba y pasa a ser el producto. Desde ahora, los cambios menores suben el último número y las funciones nuevas, el del medio.

## Lo que decidió el autor el 4 de noviembre

| Pregunta | Respuesta |
| --- | --- |
| ¿Qué datos se guardan sin la prueba de 21 días? | Los mismos. Quien ya estaba registrado conserva su código y sus datos, y se sigue registrando. |
| ¿Con qué puede sonar? | El Tag, el teléfono —que en la app se llama «Notificación»— y un dispositivo de audio. Sale el reloj. |
| ¿Qué mejoras de la Tabla 4 entran? | Todas: un límite breve al empezar, horas sin sonar, dejar un relevo listo para después y el volumen. La más importante era acortar la primera vez. |
| ¿Cómo se llaman las cosas? | Las propuestas del estudio de los textos, y la ruta se llama «Actividades». |
| Las animaciones del Tag | Se quitan: un dibujo puede dar una idea equivocada de cómo se ve un Tag. |

## Qué cambia

### Sale la prueba de 21 días

- Salen las semanas A, B y C, la semana de comparación, la pantalla del investigador (que se abría manteniendo presionada la versión en Perfil), las tarjetas de cada semana, las escalas, el cierre del día 21 y las instrucciones semanales.
- Los relevos ya no guardan condición ni día de la prueba. En la base de datos esas columnas quedan vacías para los relevos nuevos; las de la prueba no se tocan.
- La notificación de cuando suena siempre dice la actividad y cómo empezar: la versión genérica era de la semana C.
- «Probar con 15 segundos», un atajo para probar la app, también sale.

### Los datos siguen siendo los mismos (D-154)

- Se envían a la misma base de datos, con las mismas tablas y los mismos campos: relevos, eventos, respuestas, uso diario, estado del teléfono, nombre aparte y mensajes del proyecto. El panel los sigue leyendo igual.
- Las cuatro preguntas de un toque después de que suena se mantienen, porque son parte de esos datos.
- **El consentimiento pasa a la versión `2026-11-04-v14`.** Dice lo mismo sobre los datos, sin la prueba de 21 días, y está escrito en listas (R12). Quien aceptó la v13 ve «Relevo cambió» al abrir la app: conserva su código y sus datos, y un relevo que estaba contando sigue contando después de aceptar. Si no acepta, Relevo deja de contar; sus datos anteriores siguen guardados hasta que pida borrarlos o hasta el 30 de diciembre de 2026.

### La primera vez, más corta

Antes había 11 pantallas antes del primer relevo: bienvenida, tres de «Cómo funciona», la pregunta del aviso semanal, el consentimiento, tres permisos y tres del perfil, más la pantalla del primer relevo. Ahora hay tres:

1. **Bienvenida.**
2. **Consentimiento.**
3. **Un permiso:** Tiempo de uso, sin el cual Relevo no puede contar, con el nombre que usa Android («Acceso a datos de uso») y tres pasos para darlo.

Después se prepara el primer relevo enseguida, guiado paso a paso: enseña haciendo. Lo demás llega en su momento:

- **El perfil** (nombre, «¿Con qué te identificas?» e intereses) se ofrece al activar el primer relevo. Si se deja para después, Inicio lo recuerda con una tarjeta. El nombre sigue siendo obligatorio (D-089).
- **Las notificaciones** se piden al activar un relevo.
- **La batería** se pide en Inicio y en el relevo activo, solo si Android lo restringe.
- **«Cómo funciona Relevo»** y su video quedan en Perfil.
- **El aviso semanal** queda en los ajustes, apagado, como antes (D-088).

### El Tag

- **Antes de que se cumpla el tiempo, Relevo busca el Tag.** A un minuto y medio del final abre la conexión si está cerrada. Si no responde, la notificación permanente lo dice. **Si al cumplirse el tiempo sigue sin responder, suena en el teléfono**, y la pantalla y la notificación lo explican. Es el cambio de comportamiento que pidió la comisión.
- **«¿No tienes un Tag?»:** al elegir el Tag sin tener uno, la app ofrece conseguirlo, con una búsqueda de iTag en Mercado Libre, y propone usar «Notificación» mientras tanto.
- **Sin dibujos del Tag:** la guía «Cómo usar el Tag» pasa a pasos numerados con un ícono, y la pantalla de cuando suena muestra el ícono de con qué suena.

### Las salidas

| En la app | Qué hace | Se guarda como |
| --- | --- | --- |
| Tag | Pita en el lugar donde empieza la actividad. | `tag` |
| Notificación | Suena en el teléfono, donde esté, con una notificación. | `phone` |
| Dispositivo de audio | Suena en un parlante o unos audífonos Bluetooth. | `bluetooth` |

El reloj (D-093) sale: nunca se probó con hardware. Un relevo guardado con el reloj pasa a sonar en el teléfono.

### Mejoras de la Tabla 4

- **Un límite breve al empezar:** un relevo nuevo propone 15 minutos, y el paso «¿Cuándo suena?» explica que un tiempo breve funciona mejor al empezar. Después de 3 veces que sonó, Inicio pregunta una vez si el tiempo queda bien y lleva directo a cambiarlo.
- **Horas sin sonar:** en «Ajustes de tus relevos» se elige un tramo, de 23:00 a 8:00 al encenderlo. En esas horas Relevo no cuenta ni suena, ni se activa solo; el relevo sigue activo y retoma al terminar el tramo.
- **Dejarlo para después:** al responder «La dejé para después», la app pregunta si se deja lista. Si sí, Inicio la ofrece con «Activar ahora», tal como estaba y sin que suene sola.
- **Volumen:** suave, medio o fuerte, para el teléfono y el dispositivo de audio, en el paso de con qué suena y en los ajustes. El Tag pita con su propio volumen: su volumen no se puede cambiar desde el teléfono.

### La pantalla del relevo activo

Muestra solo la actividad, el tiempo que falta y una acción, «Cambiar o desactivar». Esa acción abre las opciones —editar, desactivar o eliminar— con cómo empezar y dónde suena. La tarjeta de Inicio también se simplificó: la actividad, el tiempo que falta y el avance.

### Los textos

Se aplicó el estudio de los textos:

- **R1:** «Para empezar» es el rótulo y «¿Cómo empiezas?», la pregunta. «Tu primer paso» y «Empieza por…» salen de la app.
- **R2:** «suena» y «el sonido» nombran lo que pasa. «Aviso» queda para el aviso semanal y «Notificaciones», para el permiso.
- **R3:** «contar» queda para el tiempo; para la respuesta, «decir».
- **R4:** la ruta se llama «Actividades» en la pestaña, el título y Perfil. Dentro están los pasos de cada interés y «Tus actividades».
- **R5:** cada fila dice lo mismo que el título de su pantalla: «Privacidad y datos», «Tu opinión», «Ajustes de tus relevos».
- **R6:** se dice el nombre de Android de cada permiso.
- **R7:** Relevo habla en tercera persona; el «nosotros» sale de la app.
- **R8:** los títulos van sin punto final. Los títulos en dos tonos se leen como una frase, o como dos, con su puntuación.
- **R10:** van en cifras las cosas que se cuentan.
- **R11:** en la notificación de cuando suena, la actividad va como título y cómo empezar, primero.
- **R13 y R14:** sale «Es momento de volver a elegir»; la pantalla de cuando suena muestra la actividad y cómo empezar. Salen «Detalle técnico» y «testeo», y se explica iSearching.

También cambia la comisión: «Elige tu emoji» pasa a «¿Con qué te identificas?».

El inventario de la 1.0.0 tiene 1195 textos, frente a 1287 de la 3.3 ([inventario](textos/inventario-de-textos.md); el de la 3.3 se conserva como [inventario-de-textos-3.3.md](textos/inventario-de-textos-3.3.md)).

### Usabilidad

- **Áreas táctiles de 48 dp**, como pide Android, en las opciones de un toque, los botones redondos y los selectores (documento 43, sección 9.6). Se dibujan igual.
- **Perfil** reúne «Actividades» en una sola fila, «Ajustes de tus relevos» y «Permisos», con nombres que coinciden con sus pantallas.

### Lo viejo que sale del código

- La prueba de 21 días: `Study.kt`, `StudyStore.kt`, `StudyScreens.kt` y su prueba automática.
- El uso «sin participar» de 2.8 y 2.9 y su marca, y el reloj.
- Las 21 fotos de D-073, 2,7 MB, que no se mostraban desde la 2.21. Siguen en el historial del repositorio.
- El cálculo del tono de las fotos, la pantalla del primer relevo, el dibujo del Tag y once componentes sin uso.
- 102 importaciones sin uso.

Las preferencias guardadas de la prueba, como `relevo_study`, quedan en el teléfono: no se borran.

## Verificación

- **Compilación y pruebas automáticas:** compila sin errores ni advertencias del compilador y pasan las 77 pruebas unitarias. Hay pruebas nuevas para las horas sin sonar, el límite breve, el sonido en el teléfono cuando el Tag no responde y la línea «Para empezar».
- **APK de entrega:** compilada desde cero (`clean`), con `versionCode` 50 y el certificado de siempre. SHA-256: `8DD8DCEAB0501BF673AD9A55F792F3F7ECF34362264ADCDED97BB818A3677C6D`.
- **En el emulador, sin conexión, instalada sobre la 3.3 con los datos del autor:**
  - aparece «Relevo cambió»;
  - al aceptar, se conservan el código, el nombre, el emoji, el historial, las actividades y los pasos;
  - el consentimiento queda en la v14;
  - Inicio, «Actividades», Perfil y «Ajustes de tus relevos» se ven como se diseñaron.
  - El autor usó el emulador al mismo tiempo y probó las horas sin sonar y el volumen. Sus datos se respaldaron antes de instalar.

**Falta probar:**

- La primera vez desde cero, en el emulador. Pide borrar los datos de la app, y se dejó para cuando el autor termine de usarlo.
- El sonido en el teléfono cuando el Tag no responde, con un Tag real.
- Las horas sin sonar en un relevo que cruza el tramo.
- El volumen en un dispositivo de audio real.
- TalkBack y letra grande en un teléfono.

## Registro de cambios (disclaimer)

### 2026-11-04 — Creación

- **Qué cambió:** se documenta la versión 1.0.0.
- **Cómo estaba antes:** la última versión era la 3.3, con la prueba de 21 días.
- **Por qué:** el autor pidió la versión definitiva, ordenada, sin errores, sin código ni cosas viejas, sin la prueba y con lo que pidió la revisión de octubre.
