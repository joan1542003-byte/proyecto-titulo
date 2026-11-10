# Android 4.0: rediseño de la interfaz

**Fecha:** 5 de noviembre de 2026. **Decisión:** [D-155](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.0-rediseno`, sin fusionar a `main`. **Versión:** 4.0, `versionCode` 50.

## Qué pidió el autor

Después de revisar la 3.3, el autor pidió dejar de lado lo local y ocuparse del diseño: menús, uso, navegación, notificaciones y color. Señaló cinco problemas y pidió un rediseño total, sin reciclar:

1. Unos íconos tenían color y otros no, sin una razón visible.
2. Algunas frases de Inicio no tenían mucho sentido; pidió revisar el [estudio de los textos](textos/estudio-escritura-de-interfaces-2026-10-24.md).
3. La barra de navegación era muy grande.
4. La sección de actividades se sentía desordenada. Los íconos con anillo del selector de imagen funcionaban mejor que las «etiquetas» sobre un cuadrado de color.
5. El aura no debía estar: la [memoria v6](../../08_memoria/borrador-memoria-v6-2026-10-28.md) ya no la menciona.

Además, pidió un resumen de las actividades en Inicio que no juzgue, menos palabras, los ajustes en Perfil con un ícono de tuerca y un desenfoque progresivo arriba y abajo de la pantalla, como en iOS.

## Qué cambió

| Tema | 3.3 | 4.0 | Por qué |
| --- | --- | --- | --- |
| Color | Seis fichas de color, una por papel (D-124): algunos íconos en su color y otros en gris. | La interfaz va en papel y tinta. Todos los íconos de interfaz son iguales: tinta sobre un círculo de piedra. El color es solo de las actividades, en su anillo. | Un color por función no se entendía; un color por actividad sí. |
| Actividades | Un cielo con el nombre en una cápsula blanca (`SkyCard`) en Inicio, Preparar, Perfil y Ruta. | Un anillo: un círculo blanco con el ícono en tinta y un borde con el color de su familia. Es la pieza del selector de íconos de la 3.3. | Pedido del autor: el anillo funciona mejor que la etiqueta sobre un cuadrado de color. |
| Navegación | Inicio, Ruta y Perfil, en una barra de 72 dp de borde a borde con el destino elegido en un bloque negro. | Inicio, Actividades y Perfil, en una cápsula de vidrio centrada de 58 dp. El destino elegido va en tinta sobre una cápsula apenas marcada. | La barra pesaba más que el contenido. |
| Sección de actividades | Repartida en Inicio (Ideas y Tus actividades), Perfil (Tus actividades) y la pestaña Ruta. | Una pestaña, Actividades, con tres partes que no se mezclan: Tuyas, Paso a paso (la ruta) e Ideas. | Un solo lugar para lo que la persona quiere hacer. |
| Paso a paso | Pasos en escalera, corridos hacia la derecha. | Una lista numerada en un grupo, con el paso de ahora marcado. Sigue sin porcentajes, puntos ni niveles (D-074). | La escalera se leía como un adorno y desordenaba la pantalla. |
| Inicio | Saludo en dos tonos, campana de avisos, tarjeta del paso con un cielo, cuadrícula de ideas, tus actividades y «La última vez». | La fecha y el saludo; lo de la prueba si toca; el relevo que cuenta o «Preparar un relevo» con dos atajos (tu paso y el último relevo); **Tu semana**, y tus actividades en anillos. | Lo más próximo arriba y una sola acción principal. |
| Tu semana | Una fila en Perfil: «Preparaste 1 relevo; empezaste 1 vez». | Un resumen en Inicio: cuántos relevos y en qué actividades esta semana, con el anillo de cada una y cuántas veces. | El autor pidió un resumen que no juzgue: solo hechos, sin comparar semanas ni contar lo que faltó. |
| Ajustes | La campana de Inicio abría «Avisos y resúmenes»; los demás ajustes estaban en Perfil. | Una tuerca arriba a la derecha de Perfil abre Ajustes: Avisos, Apariencia, Permisos y Tus datos. | Inicio queda para el día a día. |
| Aura | A pantalla completa en la bienvenida y mientras cuenta un relevo, con su ajuste de intensidad. | Retirada de la app y de los ajustes. Las actividades sin familia toman «arena», un tono neutro. | La memoria v6 ya no la usa. |
| Bordes | Un degradado de papel bajo la barra y sobre los botones (desde 2.28). | Desenfoque progresivo arriba y abajo: pleno en el borde y nulo hacia el contenido, con un velo de papel encima. | Pedido del autor, como el borde de desplazamiento de iOS 26. |
| Listas | Una tarjeta con sombra por fila, separadas por 9 dp. | Las filas de un grupo en una sola tarjeta, con líneas finas entre ellas. | Menos ruido visual. |
| Tu relevo (contando) | Aura, tiempo contado, primer paso, dónde suena y tres acciones. | El anillo, la actividad, cuánto falta y una acción, «Cambiar o desactivar», que abre una hoja con Editar, Desactivar y Eliminar. | Tabla 4 de la memoria: «la pantalla del relevo muestra demasiada información». |
| Bienvenida | El aura y un ejemplo con fichas flotantes. | El logo sobre el papel, una frase y un ejemplo con el anillo de «Leer». | Sin aura y con menos texto. |
| Elegir imagen | Dos grupos: «Fotos» (cielos cuadrados) e «Íconos» (anillos). | Un solo grupo de 23 anillos. | Las fotos ya eran íconos sobre un cielo desde la 2.21. |
| Perfil, primera vez | «Elige tu emoji». | «¿Con qué te identificas?». | Tabla 4 de la memoria. |

### Textos

Se aplicaron las propuestas del [estudio de los textos](textos/estudio-escritura-de-interfaces-2026-10-24.md) que no tocan el protocolo:

- **R1:** «Para empezar» en el resumen de Preparar, en vez de «Cómo empiezas»; «primer paso» sale de la guía.
- **R3:** «contar» queda para el tiempo: «Contar más» pasa a «Escribir un comentario»; «cuéntanos qué hiciste», a «dinos qué hiciste»; «Mensaje después de responder», a «Mensaje al responder», con «Unas palabras después de decir qué decidiste».
- **R5:** la fila y la pantalla de datos se llaman igual, «Tus datos», como dice el consentimiento.
- **R6:** Permisos dice cómo se llama el permiso en Android: «Acceso a datos de uso». La batería dice «Sin restricciones» o «Con restricciones».
- **R8:** los títulos van sin punto final y sin la segunda parte en grafito.
- **R11:** las notificaciones llevan lo importante en el título, sin el nombre de la app, y un texto corto con lo útil primero (ver abajo).
- **R12:** «Preparar un relevo con este paso» pasa a «Preparar este paso», y las notas de la guía se acortan.

No cambian los textos del protocolo ni del consentimiento: la frase de la señal («Es momento de volver a elegir»), las preguntas después de la señal, «¿Qué decidiste?», los cierres de semana y de la prueba y el consentimiento aceptado.

### Notificaciones

| Notificación | 3.3 | 4.0 |
| --- | --- | --- |
| Mientras cuenta | «Relevo está contando tu tiempo en las apps que elegiste» / «Deja de contar cuando desactivas el relevo.» | «Contando para «Leer»» / «Suena al sumar 30 min». En la pantalla de bloqueo, solo «Contando». |
| Activación automática | «Relevo se activará solo» | «Se activa solo» / «Al abrir las apps de tu último relevo» |
| Señal | Título: la actividad. Texto: «Es momento de volver a elegir. Empieza por abrir el libro.» | Título: la actividad. Texto: «Empieza por abrir el libro». La versión genérica de la semana del teléfono y de la pantalla de bloqueo no cambia. |
| Si no sonó | «No se encontró el parlante. Abre Relevo para revisarlo.» | «No sonó en el parlante. Toca para revisar» |
| Dejó de contar | «Relevo dejó de contar» | «Dejó de contar» / «Falta el permiso de Tiempo de uso» |
| Aviso semanal | «Relevo» / «¿Sigue en pie leer esta semana?» | «Leer» / «¿Sigue en pie esta semana?» |

## Lo que no cambia

- El paquete `cl.udp.relevo`, las preferencias, la base local, Supabase, la lógica de la prueba de 21 días y los datos de la investigación.
- La letra (Instrument Sans), el papel, la tinta, el logo y los íconos propios; se suman dos: la tuerca (`TUERCA`) y Actividades (`ACTIVIDADES`), dibujados en la misma retícula de 24 con trazo redondeado.
- El cielo de la actividad a pantalla completa cuando suena: es el color de la actividad, no un papel de la interfaz.

## Datos y registro

- **Ajuste retirado:** la clave `aura` de las preferencias se borra la próxima vez que se guardan los ajustes. No es un dato de la investigación.
- **Imágenes guardadas:** las actividades con imagen `foto:…` o `icono:…` se ven como su anillo; no se pierde ninguna.
- **Registro de pantallas:** la pestaña Actividades se registra como `pestana_activities` (antes, `pestana_route` para la Ruta) y Ajustes como `settings`.

## Instalar la 4.0 sin tocar la versión instalada

`./gradlew assembleDebug -PrelevoSuffix=.revision` genera una app aparte, `cl.udp.relevo.revision`, llamada «Relevo 4.0», que se instala junto a la que ya está, con sus propios datos y sin la base remota. Sin `-PrelevoSuffix`, la compilación es la de siempre.

**Firma:** la 3.3 se firmó con la clave de depuración de otro computador. Un APK compilado en el Mac del autor tiene otra firma y no se puede instalar encima de la 3.3 sin desinstalarla, lo que borra sus datos. Para actualizar sin perder nada, hay que compilar en el computador que firmó la 3.3, o instalar la versión aparte.

## Verificación

- **Compilación:** `assembleDebug` y `assembleRelease` sin errores, con y sin `-PrelevoSuffix`.
- **Pruebas unitarias:** las 87 pasan (`testDebugUnitTest`), sin fallas.
- **Emulador (Android 16, teléfono mediano, perfil y datos de prueba):** la versión de depuración se instaló junto a la 3.3 y se revisaron en pantalla la primera vez completa (bienvenida sin aura, guía, consentimiento, permisos, «¿Con qué te identificas?», intereses y primer relevo), Preparar con sus seis pasos, Inicio con un relevo contando y con «Tu semana», la señal en el teléfono, Actividades (Tuyas, Paso a paso e Ideas), Perfil con la tuerca, Ajustes, Apariencia y el tema oscuro. Las actividades se ven como anillos en todas esas pantallas, los íconos de interfaz son iguales, la barra de pestañas es la cápsula centrada y el borde inferior desenfoca lo que pasa bajo la barra.
- **Sin revisar en pantalla:** Tu relevo (contando) con su hoja «Cambiar o desactivar», «¿Qué decidiste?» y el APK optimizado (`release`), que se compiló pero no se abrió.
- **Rendimiento:** no se pudo medir. Este computador tiene 8 GB de memoria y el emulador trabajó con memoria de intercambio: con la GPU por software, la mediana fue de 150 ms por cuadro, y el sistema del emulador mostró avisos de «no responde» también en apps ajenas a Relevo (el teclado, el teléfono, Google). El desenfoque progresivo se hizo con la imagen reducida a la mitad y con máscara para cuidar los cuadros (el problema de la 2.28), pero hay que comprobarlo en un teléfono real antes de darlo por resuelto.

## APK

[`releases/relevo-android-4.0-revision-2026-11-05.apk`](releases/relevo-android-4.0-revision-2026-11-05.apk): optimizado, `cl.udp.relevo.revision`, «Relevo 4.0». Se instala junto a la versión que ya está en el teléfono, sin tocar sus datos, y no tiene configurada la base remota: lo que se haga en ella queda en el teléfono.

## Registro de cambios (disclaimer)

### 2026-11-05 — Creación

- **Qué cambió:** se describió la versión 4.0: el rediseño de la interfaz, los textos, las notificaciones, lo que no cambia y cómo instalarla.
- **Cómo estaba antes:** la última versión de diseño era la 3.3, del 20 de octubre.
- **Por qué:** el autor pidió rediseñar la app completa a partir de su revisión de la 3.3.
