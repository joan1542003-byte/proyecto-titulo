# Android 4.1: anillos simétricos, textos con función, sin viudas y movimiento al tacto

**Fecha:** 5 de noviembre de 2026. **Decisión:** [D-156](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.0-rediseno`. **Versión:** 4.1, `versionCode` 51. **Sobre:** [Android 4.0](version-4.0-rediseno-2026-11-05.md). **APK:** [relevo-android-4.1-revision-2026-11-05.apk](releases/relevo-android-4.1-revision-2026-11-05.apk), optimizado; se instala aparte como «Relevo 4.1». **Capturas:** [interfaz-4.1](capturas/interfaz-4.1/README.md).

## Qué pidió el autor

Al revisar la 4.0 pidió cinco cosas: revisar los íconos circulares, que no se veían simétricos; quitar mensajes como «Así suena Relevo», que no tienen sentido; que no haya viudas; seguir las pautas de Apple con microinteracciones y animaciones que se sientan bien al tocarlas, sin efectos triviales como el 3D, y que cada decisión responda a la memoria y esté fundamentada, entendiendo antes cómo funciona cada cosa.

## 1. Los anillos

### Qué se midió

- **El color:** el anillo se pintaba con el cielo de su familia, cuyas luces están en lugares distintos y algunas son casi blancas (`#E6F7FF`, `#F7FBFF`, `#FFE0B8`). Junto al círculo blanco, el lado pálido parecía más delgado que el saturado.
- **El centro:** el círculo interior se centraba redondeando a píxeles enteros; con un anillo de 9,45 px quedaba de 9 px en un lado y de 10 en el otro.
- **Los íconos:** se midió el dibujo de los 104 íconos del kit. Varios no estaban al centro de su retícula de 24: la campana (`AVISOS`) bajaba 1,64 unidades por su badajo; la escalera (`PRIMER_PASO`, `RUTA`), 1,25; la bicicleta, 1,15; el control, 1,13; el pincel subía 1,10, y el triángulo de reproducir estaba 1,28 a la derecha.

### Qué se hizo

| Pieza | 4.0 | 4.1 |
| --- | --- | --- |
| Dibujo | Tres capas: el cielo recortado en círculo, un círculo blanco encima y el ícono. | Un solo lienzo con un mismo centro: el anillo como trazo, el círculo y el ícono. El grosor es el 7,5 % del diámetro, redondeado a píxeles enteros. |
| Color | El cielo de la familia, con luces distintas en cada lado. | Un degradado igual a la izquierda y a la derecha: un color arriba, otro a los lados y otro abajo, tomados de la familia y llevados a una misma luminancia. |
| Ícono | En su lugar de la retícula. | En su centro óptico: centrado por la caja del dibujo, más un cuarto de la distancia al centro de la tinta, con un tope de 0,6 unidades. Se aplica a todos los íconos de la app. |
| Variantes | Dos actividades de la misma familia tenían cielos distintos. | La misma familia tiene el mismo anillo; el ícono distingue la actividad. |
| Elegido | Un anillo de tinta que aparecía de golpe. | Aparece desde adentro con un resorte sin rebote, y marca un tic. |

**Por qué:** la memoria funda el color en que las fichas tengan «casi la misma luminosidad», para que pesen lo mismo y ninguna se imponga (Albers, 2013; borrador v6, «Color»). La 4.1 aplica la misma regla dentro de cada anillo: si los colores tienen la misma luminancia, el contorno se lee del mismo grosor. Centrar por la caja corrige el error de construcción; la corrección hacia la tinta, pequeña y con tope, evita que una figura pesada abajo se vea caída sin mover las simétricas.

| Familia | Arriba | Lados | Abajo |
| --- | --- | --- | --- |
| Moverte | `#3FB482` | `#3FB487` | `#3DAEC3` |
| Leer y aprender | `#2A6DD4` | `#356ADA` | `#3B6BD2` |
| Crear | `#EE6C23` | `#E8698E` | `#A080EE` |
| Jugar y disfrutar | `#E79A0B` | `#E39A4F` | `#BF98F1` |
| En casa | `#DB5D10` | `#E8501E` | `#E6522A` |
| Descansar | `#36457C` | `#34457A` | `#25419A` |
| Con otras personas | `#DA4265` | `#D24A6F` | `#D8426F` |
| Otras | `#B49972` | `#B09A7B` | `#B09A77` |

## 2. Los textos

Se quitaron los textos que narraban la pantalla en vez de informar: decían qué tocar, cuando el botón ya está a la vista, o hablaban de la app («Así suena Relevo»). El autor ya había rechazado en septiembre «el uso repetitivo de texto sin función» ([dirección del autor](../../00_gobernanza/direccion-del-autor-y-referencias-2026-09-27.md)), y la memoria sigue la regla de Apple: tan largo como haga falta y tan corto como se pueda (Apple, 2024).

| Dónde | Antes | Ahora |
| --- | --- | --- |
| Suena, primera vez | «Así suena Relevo. Toca «Silenciar y continuar» y después dinos qué hiciste.» | Nada. |
| Suena, con el Tag | «Para callarlo en el Tag, toca su botón una vez.» | «Un toque al botón del Tag también lo calla.» |
| ¿Qué decidiste?, primera vez | «Responde lo que pasó de verdad. No hay respuestas buenas ni malas; todas nos ayudan a mejorar Relevo.» | Siempre, bajo la pregunta: «Ninguna respuesta es mejor que otra.» (criterio 4). |
| Inicio, primera vez | «Empieza aquí: toca «Preparar un relevo».» | Nada: es el botón principal. |
| Preparar, primera vez | Una nota por paso: «Te propusimos…», «Toca una opción o escribe la tuya…», «Toca un dato para cambiarlo…». | Nada. La ayuda va en el campo, como un ejemplo: «Ej.: leer 10 páginas», «Algo que tome segundos», «Ej.: en el velador». |
| Preparar, ¿dónde suena? | «Suena en el teléfono. Si prefieres otra cosa, elígela.» | Nada: la opción elegida ya se ve. Durante la prueba sigue la instrucción de la semana. |
| Probar el sonido | «Así va a sonar.» | «Sonó en el parlante.» |
| Tu primer relevo | «[nombre], empecemos por dibujar o pintar. Te guiamos.» y «Puedes cambiar todo antes de activarlo.» | Solo el título, el anillo y cómo empieza. |
| Primer relevo activo | «Tu primer relevo está activo», tres oraciones. | «Tu relevo está contando» y una oración: dónde y cuándo suena. |
| Cómo funciona | «Mira este video corto. Después te contamos…» y un párrafo bajo las cuatro filas. | El video y las filas, sin texto que las repita. |
| Opinión rápida | «Toca una cara. Nos ayuda a mejorarlo.» | Solo la pregunta. |
| Editar los pasos | «Toca un paso para cambiarlo. Con los tres puntos, puedes moverlo o borrarlo.» | Nada. |
| Notificaciones | «No sonó en el parlante. Toca para revisar» | «No sonó en el parlante» |
| Preparar, el campo de la actividad | «Qué quieres hacer», bajo el título «¿Qué quieres hacer?» | «Actividad», como en el editor de pasos y según la regla de campos del estudio. |
| Preparar, validación | «Escribe qué quieres hacer o toca una idea.» | «Escribe qué quieres hacer o elige una idea.» |
| Batería | «Para que Relevo siga contando aunque pasen días, quítale la restricción de batería.» y el botón «Quitar la restricción» | «Para que Relevo siga contando aunque pasen días.» El botón ya dice qué hacer. |
| Buscar el Tag, bajo la lista | «Toca el tuyo. Va a pitar una vez para confirmarlo.» | «Al elegirlo, pita una vez para confirmarlo.» |
| Cómo usar el Tag, paso 3 | «Con el Tag cerca del teléfono, toca «Buscar el Tag» y elígelo en la lista. Va a pitar una vez para confirmarlo.» | «Ten el Tag cerca del teléfono y elígelo cuando aparezca en la lista. Pita una vez para confirmarlo.» |

**Por qué se quita la guía de la primera vez:** la memoria registra que la primera vez «les resultó largo» a las tres personas de la prueba (borrador v6, «La primera vez»), y el documento 43 propone que el primer relevo enseñe cómo funciona Relevo «haciéndolo» (sección 10.3). El primer relevo sigue recorriendo los seis pasos; lo que se quita son las notas que lo narraban. Los textos del consentimiento y del protocolo no cambian.

**Qué se mantiene:** las instrucciones del botón del Tag («Cuando suene, toca el botón una vez»), porque hablan del objeto y no de la pantalla; «Algo que tome segundos» como ayuda del primer paso, la frase del estudio de los textos para ese paso (T0207), y «Cuatro preguntas de un toque», que retoma las «preguntas de un toque» del consentimiento.

**Inventario:** se volvió a generar con el código de 4.1: 1237 textos y 5212 palabras, frente a 1287 y 5837 en 3.3 ([inventario](textos/inventario-de-textos.md)).

## 3. Sin viudas

**Regla:** la de la memoria (D-135): «las últimas palabras de cada párrafo van unidas». Toda la app usa un `Text` propio que une con un espacio que no se parte las dos últimas palabras de cada párrafo de tres o más palabras; con dos palabras no une nada, para que un nombre como «Tocar guitarra» pueda partirse en una celda angosta. Los títulos y el texto centrado se parten en líneas de largo parejo (`LineBreak.Heading`), para que el bloque quede simétrico, y el texto corrido, con la estrategia de mejor calidad de Android (`LineBreak.Paragraph`). Cuatro pruebas unitarias cubren la regla.

## 4. Movimiento y tacto

Se siguen las pautas de Apple para interfaces fluidas (Apple, 2018) y para la vibración (Apple, 2019), dentro de lo que el documento 43 ya fijó: transiciones breves, sin giros ni inclinaciones (sección 9.7).

| Principio | En Relevo |
| --- | --- |
| Responder al apoyar el dedo, no al soltarlo | Botones, filas, anillos y ahora también las pestañas se hunden apenas se tocan. |
| Resortes sin rebote por omisión; rebote solo si el gesto traía impulso | Todo usa resortes críticamente amortiguados. La hoja que se arrastra hacia abajo vuelve con un amortiguamiento de 0,8 y la velocidad del dedo. |
| Proyectar el impulso | Al soltar una hoja, se calcula dónde terminaría el gesto con su velocidad, como el desplazamiento de iOS, y con ese punto se decide si se cierra. |
| Causa, armonía y utilidad en la vibración | Vibra solo lo que confirma o cambia algo: activar el relevo y responder «¿Qué decidiste?» (confirmación), un interruptor (encendido o apagado), elegir una opción (un tic) y un botón que pide algo que falta (rechazo). Ya no vibran todos los botones principales ni el cambio de pestaña. |
| El cambio de una cifra se ve | «Faltan 12 min» y la cifra grande de Tu relevo cambian deslizándose hacia abajo cuando la cuenta baja. |
| Sin efectos 3D | El Tag y los objetos que suenan se dibujan planos, sin brillos ni sombras que imiten volumen; las sombras de la barra, las tarjetas de vidrio y el perfil se aligeraron. |
| Áreas táctiles de 48 dp | Las opciones de un toque, los botones de − y + y los botones de ícono reservan 48 dp sin cambiar su dibujo, como pide Android (documento 43, sección 9.6). |

## 5. Alineación

Al revisar la 4.1 en el emulador aparecieron bordes que no coincidían por pocos píxeles. Cada pieza quedó alineada con algo que se ve:

| Pieza | Antes | Ahora |
| --- | --- | --- |
| Acciones de texto («Quitar la restricción», «Ver todas», «Saltar») | 4 dp de relleno a los lados: quedaban corridas respecto de su texto y del borde de las tarjetas. | Sin relleno: empiezan en la columna de su texto y terminan en el borde. El área táctil sigue midiendo 48 dp. |
| Títulos de las listas agrupadas («Ayuda») | 4 dp hacia adentro: ni en el borde de la tarjeta ni en el de su contenido. | Donde empieza el contenido de las filas (14 dp), como en las listas agrupadas de iOS. |
| Rótulos sobre los anillos («Moverte», «Leer y aprender») | 4 dp hacia adentro. | En el margen, como «Tus actividades» en Inicio. |
| Barra de «Tu relevo» | 24 dp más angosta a cada lado que la tarjeta de abajo. | Del mismo ancho que la tarjeta. |

## Verificación

- **Compilación y pruebas:** `assembleDebug` y `assembleRelease` sin errores; las 91 pruebas unitarias pasan, entre ellas las cuatro de la regla de viudas.
- **Emulador** (Android 16, perfil de prueba): el anillo mide entre 6,9 y 7,1 px en ocho ángulos. Se revisaron Inicio contando, Tu relevo, Actividades, Ideas, Perfil, Preparar, Suena, las preguntas y ¿Qué decidiste?, en el tema claro, e Inicio, Actividades y Perfil en el oscuro: sin viudas, con los anillos simétricos y las piezas alineadas. El APK optimizado recorrió las mismas pantallas sin cerrarse.
- **Sin verificar:** cómo se sienten los resortes, la cifra que se desliza, la hoja con impulso y la vibración. El emulador no vibra y dibuja por software, con pocos cuadros por segundo; falta probarlo en un teléfono.

## Límites

- Dos pares de ideas comparten ícono, «Leer» y «Leer manga», y «Hacer manualidades» y «Armar una maqueta», porque el kit no tiene uno propio para ellas. Se distinguen por su nombre.
- La memoria v6 todavía describe las fichas de papel y el cielo con cápsula (D-155); el anillo de igual luminancia es una aplicación de su misma regla.

## Referencias

Albers, J. (2013). *Interaction of color* (4.ª ed.). Yale University Press.

Apple. (2018). *Designing fluid interfaces* [Video]. WWDC18. https://developer.apple.com/videos/play/wwdc2018/803/

Apple. (2019). *Designing audio-haptic experiences* [Video]. WWDC19. https://developer.apple.com/videos/play/wwdc2019/810/

Apple. (2024, 8 de febrero). *Q&A with the Apple UX writing team*. Apple Developer. https://developer.apple.com/news/?id=5mcfho5g

## Registro de cambios (disclaimer)

### 2026-11-05 — Creación

- **Qué cambió:** se describió la 4.1: anillos simétricos y centrados, textos sin narración, sin viudas, movimiento al tacto, alineación, la verificación en el emulador y sus límites.
- **Cómo estaba antes:** la 4.0 dibujaba el anillo con el cielo de la familia y tenía notas de guía en la primera vez.
- **Por qué:** pedido del autor al revisar la 4.0.
