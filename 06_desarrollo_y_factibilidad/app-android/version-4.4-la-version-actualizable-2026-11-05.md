# Android 4.4: la 4.3, actualizable, con lo de la 1.0.0

**Fecha:** 5 de noviembre de 2026. **Decisiones:** [D-159 y D-160](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.4`, desde `android-4.0-rediseno` (4.3). **Versión:** 4.4, `versionCode` 55. **APK:** [relevo-android-4.4-2026-11-05.apk](releases/relevo-android-4.4-2026-11-05.apk), 10,6 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`). SHA-256: `57F21B32DA469B942A86C55FC230879AAC07E5B052385CD0116DC20F63D12A09`.

## Qué pidió el autor

El autor indicó que la versión buena es la 4.3 que hizo en su otro computador, un Mac, y que sus cambios tienen prioridad. Lo relevante de la 1.0.0 debía sumarse a la 4.3, para que la 4.3 fuera la versión que se puede instalar como actualización.

## Por qué hacía falta

El APK de la 4.3 se hizo para revisar el rediseño sin tocar la app instalada, así que no servía como actualización:

| Problema del APK de la 4.3 | Efecto | En la 4.4 |
| --- | --- | --- |
| Se compiló con `-PrelevoSuffix=.revision`: paquete `cl.udp.relevo.revision` | Se instala al lado, como «Relevo 4.3», vacía y con otro código | Paquete `cl.udp.relevo`: reemplaza a la app instalada y conserva sus datos |
| Se firmó con la clave de depuración del Mac (`72672f3a…`) | Android no la deja instalarse encima de Relevo | Firmada con la clave de siempre (`fdbe6bbe…`) |
| Se compiló sin `local.properties`, que no está en el repositorio | No tenía la dirección de Supabase: no enviaba datos y el panel no la veía | Con la dirección y la clave publicable del proyecto |

## Qué tiene

### Todo lo de la 4.3

El rediseño de las versiones 4.0 a 4.3 (D-155 a D-158) queda tal cual:

- la interfaz en papel y tinta, con las actividades en anillos y sin aura;
- las tres pestañas en una cápsula, y la pestaña Actividades con Tuyas, Paso a paso e Ideas;
- «Tu semana» en Inicio y los ajustes con la tuerca en Perfil;
- el desenfoque progresivo arriba y abajo;
- las sugerencias según lo que se escribe;
- varios relevos a la vez;
- cuatro sonidos para elegir;
- los textos sin posesivos de más.

### Lo que se trae de la 1.0.0

La 1.0.0 (4 de noviembre) quedó en la rama local `android-1.0.0`, que nunca se subió. Sus decisiones se numeraron D-153 y D-154, pero en `main` esos números ya son de la memoria; en la 4.4 su contenido queda como D-159 y D-160.

| Qué | Dónde se ve en la 4.4 |
| --- | --- |
| **Sin la prueba de 21 días.** Salen las semanas A, B y C, la semana de comparación, la pantalla del investigador (se abría manteniendo presionada la versión en Perfil), las tarjetas y los cierres. | Inicio, Preparar, la señal y Perfil ya no muestran nada de la prueba. |
| **Consentimiento v14** (D-160): los mismos datos, sin la prueba y en listas. Quien aceptó la v13 ve «Relevo cambió», conserva su código y sus datos, y los relevos que contaban siguen contando. | Primera pantalla al actualizar desde la 2.33 o la 3.3. |
| **La primera vez, en tres pantallas:** bienvenida, consentimiento y Tiempo de uso, con tres pasos numerados. Después, el primer relevo guiado. El perfil se ofrece al activarlo, o con una tarjeta en Inicio. | «Cómo funciona Relevo» queda en Perfil; el aviso semanal, en Ajustes, apagado. |
| **El Tag se busca a un minuto y medio del final.** Si no responde, la notificación permanente lo dice. Si al cumplirse el tiempo sigue sin responder, suena en el teléfono y la señal lo explica. | Servicio que cuenta, notificación y pantalla de la señal. |
| **«¿No tienes un Tag?»**, con una búsqueda de iTag en Mercado Libre y «Notificaciones» mientras tanto. | Preparar, «¿Dónde suena?», sin un Tag elegido. |
| **Horas sin sonar:** en el tramo elegido, Relevo no cuenta, no suena y no se activa solo. | Ajustes › Horas sin sonar; Inicio y el relevo activo dicen hasta qué hora. |
| **Volumen:** suave, medio o fuerte, para el teléfono y el dispositivo de audio. | Ajustes › Sonido y Preparar › «¿Dónde suena?». |
| **Dejarla lista para después:** al responder «La dejé para después», se pregunta si se deja lista. Si sí, Inicio la ofrece con «Activar ahora». | «¿Qué decidiste?» e Inicio. |
| **Revisión del tiempo:** después de 3 veces que sonó, Inicio pregunta una vez si el tiempo queda bien. | Inicio. |
| **Un límite breve al empezar:** 15 minutos por defecto y una nota en «¿Cuándo suena?». Sale «Probar con 15 segundos». | Preparar. |
| **Sin dibujos del Tag:** la guía «Cómo usar el Tag» va en pasos numerados con un ícono, y la señal muestra el ícono de con qué suena. | Guía del Tag y pantalla de la señal. |
| **Sin el reloj:** un relevo guardado con el reloj pasa a sonar en el teléfono. Sale el permiso para el canal de llamada. | Datos guardados y manifiesto. |

### Lo que no se trae de la 1.0.0, y por qué

- **Los textos que la 4.3 ya resolvió de otra forma.** Manda la 4.3, porque el autor la revisó en su teléfono:
  - «Notificaciones» y no «Notificación»;
  - «Empieza por…» en la notificación;
  - «Es momento de volver a elegir» en la señal;
  - «Ajustes» con la tuerca y no «Ajustes de tus relevos»;
  - «Tus datos» y no «Privacidad y datos».
- **Las pantallas de la 1.0.0** (Inicio, Actividades, Perfil y el relevo activo): la 4.x las rediseñó. Lo nuevo de la 1.0.0 se sumó a las pantallas de la 4.3, con sus piezas.

## Cómo se hizo

Fusionar las ramas chocaba en 25 archivos de código, así que cada parte se llevó por separado:

- **Datos:** la 1.0.0 cambió los datos y la 4.3 casi no los tocó, así que se tomaron de la 1.0.0. El relevo y su almacén pierden los campos de la prueba, y los relevos activos de la 4.3 guardan si sonaron en el teléfono.
- **Lógica:** el servicio que cuenta, el sonido y el ViewModel se unieron a mano. Los varios relevos de la 4.3 suman las horas sin sonar y la búsqueda del Tag de la 1.0.0.
- **Pantallas:** se partió de las de la 4.3 y se les sumó lo de la 1.0.0.
- **Código que sale:**
  - la prueba de 21 días (`Study.kt`, `StudyStore.kt`, `StudyScreens.kt` y su prueba automática);
  - la pantalla del primer relevo;
  - el dibujo del Tag;
  - la pregunta del aviso semanal en «Cómo funciona»;
  - el cálculo del tono de las fotos;
  - seis piezas sin uso;
  - 198 importaciones sin uso.
- **Panel:** reconoce la 4.4 como la versión más nueva y nombra las salidas como en la app.
- **Inventario de textos:** se volvió a generar. Tiene 1335 textos, frente a 1410 de la 4.3.

## Verificación

- **Compilación desde cero:** sin advertencias del compilador, salvo las de la API experimental de Haze, que ya estaban en la 4.x. Pasan 90 pruebas unitarias.
- **APK:** paquete `cl.udp.relevo`, versión 4.4 (`versionCode` 55), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **Emulador, sin conexión, sobre los datos del autor con la 1.0.0 instalada** (respaldados antes):
  - abre en Inicio sin pedir el consentimiento, porque ya era la v14;
  - el relevo que contaba pasa a la lista de activos y sigue contando;
  - Ajustes conserva el volumen elegido y muestra las horas sin sonar.
- **Simulando a quien viene de la 2.33 o la 3.3** (consentimiento v13):
  - aparece «Relevo cambió»;
  - al aceptar, se mantiene el mismo código, el consentimiento pasa a la v14 y el relevo sigue contando.
- **Al terminar:** los datos del autor se restauraron idénticos y el emulador volvió a tener conexión.

**Falta probar:**

- La primera vez desde cero.
- Con un Tag real: la búsqueda a un minuto y medio y el sonido en el teléfono cuando no responde.
- Las horas sin sonar en un relevo que cruza el tramo.
- «Dejarla lista» después de que suena.
- El volumen en un dispositivo de audio real.
- La actualización sobre la 2.33 o la 3.3 en un teléfono real.
- TalkBack y letra grande.

## Para instalar y compilar

- **Instalar:** la 4.4 se instala encima de la 2.33, la 3.3 o la 1.0.0 sin perder datos. «Relevo 4.3», la de revisión, es otra app y se puede desinstalar.
- **Compilar en el Mac:** para que salga actualizable, el Mac necesita `local.properties` con la dirección y la clave publicable de Supabase, y la clave de firma de siempre, respaldada en `Documents/Relevo-respaldo-firma`. Hay que compilar sin `-PrelevoSuffix`. Ninguno de los dos archivos se sube al repositorio.

## Registro de cambios (disclaimer)

### 2026-11-05 — Creación

- **Qué cambió:** se documenta la versión 4.4.
- **Cómo estaba antes:** la última versión era la 4.3, solo como APK de revisión, y la 1.0.0 estaba en una rama local.
- **Por qué:** el autor pidió que la 4.3 fuera la versión buena y actualizable, con lo relevante de la 1.0.0.
