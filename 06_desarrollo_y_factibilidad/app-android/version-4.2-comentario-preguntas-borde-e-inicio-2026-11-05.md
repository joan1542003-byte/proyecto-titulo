# Android 4.2: un solo comentario, las preguntas de cada actividad, predefinidas primero, el borde como en iOS e Inicio con color

**Fecha:** 5 de noviembre de 2026. **Decisión:** [D-157](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.0-rediseno`. **Versión:** 4.2, `versionCode` 52. **Sobre:** [Android 4.1](version-4.1-anillos-textos-y-movimiento-2026-11-05.md). **APK:** [relevo-android-4.2-revision-2026-11-05.apk](releases/relevo-android-4.2-revision-2026-11-05.apk), optimizado; se instala aparte como «Relevo 4.2». **Capturas:** [interfaz-4.2](capturas/interfaz-4.2/README.md).

## Qué pidió el autor

Al ver la 4.1 en el emulador pidió seis cosas: que «¿Qué te ayudó?» diga «Envíanos un comentario»; un desenfoque progresivo al nivel del de Apple; que «Para empezar» sea «¿Cómo empiezas la actividad?» y «Dónde empiezas», «¿En qué lugar empieza?»; que agregar una actividad empiece por las predefinidas, con la opción de hacer una propia; un Inicio más atractivo, y que «Tuyas» sea «Creadas por ti».

## 1. «Envíanos un comentario»

**Qué había:** Perfil tenía dos filas para lo mismo. «¿Qué te ayudó esta semana?», solo durante la prueba y después de preparar un relevo, abría una hoja con un campo y guardaba la respuesta como `tu_semana_ayudo`. «Opinar sobre Relevo», en Ayuda, abría una pantalla con estrellas y un comentario.

**Qué se hizo:** queda una fila, «Envíanos un comentario», en el grupo de arriba y siempre a la vista. Abre la pantalla de opinión, que ahora se titula igual: primero el comentario, con un ejemplo («Ej.: me gustaría elegir otro sonido»), y después «¿Cómo te resultó Relevo?», con estrellas opcionales. Es la misma pantalla que abre «Escribir un comentario» en Inicio. Las respuestas se guardan como antes, en `opinion_comentario` y `opinion_estrellas`; `tu_semana_ayudo` deja de escribirse en esta rama. La versión de la prueba (2.33) no cambia.

**Por qué:** dos entradas para la misma intención obligan a elegir sin saber la diferencia. Una sola, con el nombre que propuso el autor, dice qué se puede hacer.

## 2. Las preguntas de cada actividad

| Dónde | Antes | Ahora |
| --- | --- | --- |
| Rótulo del primer paso | «Para empezar» | «¿Cómo empiezas la actividad?» |
| Rótulo del lugar | «Dónde empiezas» | «¿En qué lugar empieza?» |
| Segmento de Actividades | «Tuyas» | «Creadas por ti» |
| Validaciones | «Escribe cómo empiezas.» y «Escribe dónde empiezas.» | «Escribe cómo empiezas la actividad.» y «Escribe en qué lugar empieza.» |
| Validación del tiempo de uso | «Falta el permiso de Tiempo de uso. Tócalo arriba para darlo.» | «Da el permiso de Tiempo de uso.» |

Las dos preguntas usan las palabras del autor y tienen una sola forma en toda la app: los campos de «Nueva actividad» y de los pasos, las hojas de las actividades, la bienvenida, «Cómo funciona» y «Todo listo». En las hojas y en «Todo listo», la pregunta va arriba del dato, como el rótulo de un campo; antes iba debajo. En Preparar, el título de cada paso ya hace la pregunta: los pasos 2 y 3 se titulan con la pregunta del autor y su campo no la repite a la vista (el lector de pantalla sí la lee). «Todo listo» repite la pregunta de cada paso sobre su dato.

**Inventario:** se volvió a generar: 1219 textos y 5184 palabras, frente a 1237 y 5212 en 4.1 ([inventario](textos/inventario-de-textos.md)).

El estudio de los textos proponía rótulos como sustantivos («Actividad»). El autor eligió preguntas para el primer paso y el lugar; se aplicó su forma y se mantuvo una sola en toda la app, que es la regla que importa del estudio: una palabra por concepto (R2).

## 3. Nueva actividad: primero las predefinidas

«Nueva», en Actividades y en Inicio, abre la lista de actividades predefinidas, por familia y en anillos, sin las que ya están guardadas. Abajo, siempre a la vista, está «Crear una propia». Es el patrón de iOS para agregar un modo de concentración: lo frecuente primero y lo propio a un toque.

- **Elegir una predefinida** abre el formulario lleno: nombre, cómo empieza, en qué lugar y su ícono, para ajustarlos antes de guardar. Volver regresa a la lista.
- **«Crear una propia»** abre el formulario vacío, como antes.
- **El nombre:** desde la 2.8 una actividad propia no podía llamarse como una idea. Esa regla impedía guardar una predefinida y se quitó; sigue sin poder repetirse el nombre de otra actividad guardada.
- **En Preparar,** una idea que la persona ya guardó aparece solo en «Tus actividades», con su forma de empezar, y no dos veces.

## 4. El borde, como en iOS

**Qué estaba mal:** el borde de la 4.0 calculaba un solo desenfoque de 20 dp y lo hacía aparecer con un degradado de opacidad (la opción rápida de Haze, `preferPerformance`), sobre la imagen reducida a la mitad y bajo un velo de papel del 74 al 90 %. En la rampa se veían a la vez la imagen nítida y la borrosa, y abajo, bajo la barra, quedaba una neblina.

**Cómo lo hace Apple:** el borde suave del sistema de diseño de iOS 26 desenfoca y desvanece el contenido de forma progresiva donde lo cubre una barra o un botón flotante. Es el estilo por omisión en iOS y aparece solo donde hay algo flotando encima (Apple, 2025).

**Qué se hizo:**

| Pieza | 4.1 | 4.2 |
| --- | --- | --- |
| Desenfoque | Uno solo, con máscara de opacidad. | Variable: el radio crece punto a punto, de cero a 18 dp. |
| Resolución | La mitad. | Completa. |
| Forma | Pleno bajo la barra y una rampa de 26 dp. | Pleno bajo la barra o los botones y una rampa de 32 dp (36 bajo las pestañas), con una curva suave en los dos extremos. |
| Velo de papel | Del 74 al 90 %. | Hasta el 55 % en el borde de la pantalla, con la misma curva; en el lado del contenido, cero. |
| Cuándo | Cuando algo pasa por debajo. | Igual. |

El desenfoque variable usa el sombreador de Haze (desde Android 13); en Android 12, Haze vuelve a la máscara. Cuesta más que la máscara, por eso se limita a las franjas de los bordes. El botón secundario pasó a ser blanco, como dice su descripción desde la 3.0: transparente, sobre el borde de abajo dejaba ver los colores que pasaban detrás.

## 5. Inicio con color

**Qué faltaba:** la memoria dice que el color sube con el momento: al preparar dominan el papel y la tinta, «en Inicio, la actividad se presenta en una tarjeta con su degradado» y, cuando suena, el color llena la pantalla (borrador v6, Figura 15). La 4.0 dejó Inicio en papel y tinta, con el color solo en los anillos, y la pantalla quedó sin un punto donde mirar.

**Qué se hizo:** lo más próximo va en una tarjeta con el color de su actividad. Arriba, el cielo de su familia; sobre su borde, el anillo con un aro de papel, alineado con el texto, y abajo, en papel, qué es, un detalle y la acción, que se leen con el contraste de siempre. En el tema oscuro el cielo baja un 20 % su luz.

| Estado | Encabezado | Detalle | Acción |
| --- | --- | --- | --- |
| Contando | «Contando» o «En pausa» | Dónde suena | La barra y «Faltan 9 min»; tocar la tarjeta abre el relevo |
| Regreso tras unos días | «La última vez» | — | «Preparar de nuevo» y «Elegir otra · Ahora no» |
| Paso sugerido | «Tu paso en dibujar o pintar» | «Empieza por…, en…» | «Preparar un relevo» y «Elegir otra»; debajo, repetir el último |
| Sin paso, con un relevo anterior | «Tu último relevo» | «Empieza por…, en…» | «Preparar de nuevo» y «Elegir otra» |
| Sin nada | — | — | «Preparar un relevo» |

La opinión rápida («¿Qué tal te va con Relevo?») bajó debajo de la tarjeta: lo primero es lo que la persona viene a ver.

## 6. Otros detalles

- Las estrellas de «¿Cómo te resultó Relevo?» quedaban 16 dp a la derecha de su pregunta; ahora empiezan en su columna.

## Verificación

- **Compilación y pruebas:** `assembleDebug` y `assembleRelease` sin errores; pasan las 91 pruebas unitarias.
- **Emulador** (Android 16, perfil de prueba): Inicio con el paso sugerido y contando, en claro y en oscuro; el borde de arriba y el de abajo, ampliados: desenfoque continuo, sin doble imagen ni neblina; «Creadas por ti» cabe en su segmento; «Nueva» → predefinidas → formulario lleno → volver → «Crear una propia»; Preparar, pasos 1 a 3; Perfil y «Envíanos un comentario».
- **Sin verificar:** el rendimiento del desenfoque variable en un teléfono real (el emulador dibuja por software) y «Todo listo» en pantalla, que pide el permiso de Tiempo de uso; usa la misma fila que las hojas de actividad, que sí se revisaron.

## Límites

- `tu_semana_ayudo` deja de registrarse en esta rama.
- En Android 12 el borde usa la máscara, de menor calidad.
- La memoria v6 y el documento 42 siguen describiendo las fichas de papel de 3.3 (D-155); con la tarjeta de color, Inicio vuelve a coincidir con la Figura 15.

## Referencias

Apple. (2025). *Get to know the new design system* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/356/

## Registro de cambios (disclaimer)

### 2026-11-05 — Creación

- **Qué cambió:** se describió la 4.2: un solo comentario, las preguntas de cada actividad, las predefinidas primero, el borde como en iOS e Inicio con color.
- **Cómo estaba antes:** la 4.1 tenía dos filas para opinar, rótulos como «Para empezar», «Nueva» abría un formulario vacío, el borde era un desenfoque con máscara bajo un velo casi opaco e Inicio iba en papel y tinta.
- **Por qué:** pedido del autor al ver la 4.1 en el emulador.
