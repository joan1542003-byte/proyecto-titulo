# Android 4.3: sugerencias que corresponden, varios relevos a la vez, sonido fundamentado y una app más clara

**Fecha:** 5 de noviembre de 2026. **Decisión:** [D-158](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.0-rediseno`. **Versión:** 4.3, `versionCode` 54. **Sobre:** [Android 4.2.1](version-4.2.1-preparar-desde-una-idea-2026-11-05.md). **APK:** [relevo-android-4.3-revision-2026-11-05.apk](releases/relevo-android-4.3-revision-2026-11-05.apk), optimizado; se instala aparte como «Relevo 4.3». **Capturas:** [interfaz-4.3](capturas/interfaz-4.3/README.md).

## Qué pidió el autor

Al probar la 4.2.1 en el emulador, el autor encontró sugerencias absurdas («Ver una película» sugería sacar un tomo o dejar el teléfono) y pidió:

- Un catastro de palabras clave y asociaciones, para sugerir a partir de lo que la persona escribe, con el rótulo «Sugerencias».
- Corregir «¿Dónde suena?»: el lugar arriba parecía una opción, «En tu Tag: un Tag que pita» se leía raro, no todo necesita un subtítulo, el reloj no debía ser una opción y «En el teléfono» debía ser «Notificaciones», que valen para el teléfono y el reloj.
- «Suena en tu teléfono», no «en el teléfono».
- Poder tener varios relevos activos.
- Un desenfoque que vaya de 100 a 0.
- «Envíanos un comentario» en Ayuda, y los ajustes también como fila en Perfil.
- Editar una actividad sin tener que escribirlo todo: tocar un dato y elegir entre opciones relacionadas, con un campo debajo.
- Íconos por categoría y más íconos; al elegir uno, el nombre de su categoría con un pulso y su degradado.
- Que la píldora de la barra se vea desplazarse, sin fundidos.
- Una pantalla de carga con el logo animado.
- Textos que no se entienden: «Cuando llevas un rato en el teléfono, suena donde empiezas», «Relevo suena a tiempo, donde empiezas», «Algo pequeño, de segundos» y «¿Quieres preparar un relevo esta semana? Sí, avísame».
- Que cada paso empiece arriba, sin arrastrar el desplazamiento del anterior.
- Intereses que se vean ordenados.
- «Cómo usar el Tag» solo si se pide.
- Elegir en Perfil las apps que cuentan.
- Actualizar o quitar el video, que estaba desactualizado.
- Poder elegir el sonido en los ajustes, con su fundamento.

Al revisar la primera versión de la 4.3, pidió además:

- Quitar frases como «Tu Tag» y el exceso de «tu», que entorpece la lectura: «Perfil y ya».
- Llamar «Dispositivo de audio» al parlante.
- Sugerencias concretas, como «Elegir la película» o «Elegir el libro», en vez de «Elegir qué ver».
- Descartar el ícono de escalera, que se entendía mal.
- Seguir afinando el diseño y la usabilidad.

## 1. Catastro de palabras clave

**Qué fallaba:** las sugerencias se armaban con las del mismo relevo, las de otros pasos de su ruta, las de cualquier actividad con el mismo ícono y una frase fija («Dejar el teléfono en otro lugar»). El ícono se adivinaba buscando pedazos de palabras: «capítulo» hacía que «Leer un capítulo de manga» contara como película y «serie», que «Hacer una serie corta» también. Así, «Ver una película» heredaba «Sacar el tomo del estante».

**Qué se hizo:** un [catastro](app/src/main/java/com/example/relevo/ui/Catastro.kt) de 34 conceptos, de moverte a con otras personas. Cada concepto tiene sus palabras, su ícono y lo que tiene sentido sugerir para empezar y dónde.

- **Cómo se elige:** cada palabra se compara entera, o por su raíz si se marcó así. Una palabra suma 1, una frase completa suma 2 y una palabra débil, como «ver», «jugar» o «tocar», suma medio punto, porque sola no decide. Gana el concepto con más puntos, si suma al menos 1.
- **Qué se sugiere:** lo del mismo relevo, si es una idea o un paso de ruta, y lo de su concepto. Nada de otras actividades ni frases genéricas. Si las palabras no nombran nada conocido, no se sugiere nada y el campo muestra un ejemplo.
- **Objetos concretos:** cada sugerencia nombra lo que se toca para empezar: «Elegir la película», «Elegir el libro», «Elegir la canción». «Elegir qué ver» se quitó por abierta.
- **Instrumentos:** nombran su propio objeto: «Tocar guitarra» sugiere «Sacar la guitarra del estuche»; «Practicar ukelele», «Sacar el ukelele del estuche».
- **«Sugerencias»:** las opciones llevan ese rótulo, para distinguirlas de lo que escribe la persona.
- **Pruebas:** cinco pruebas unitarias fijan los casos reportados.

| Actividad | Antes | Ahora |
| --- | --- | --- |
| Ver una película | Elegir la película, Avisar a quien ve contigo, Dejar el teléfono cargando, Sacar el tomo del estante, Abrir el libro en el marcador, Ponerte ropa cómoda | Elegir la película, Elegir el capítulo, Preparar cabritas, Avisar a quien ve contigo |
| Lugar de una película | Junto a la tele y ocho lugares de la casa | Junto a la tele, En el sillón |

## 2. Íconos

- **Trece íconos nuevos** con la misma retícula de 24 y trazo redondeado del kit: perro, correr, nadar, pelota, película, manga, maqueta, tejer, piano, meditar, idiomas, cartas y compartir. Sus SVG quedan en el [kit](../../10_recursos_visuales/marca-a-tiempo/iconos). Resuelven que «Leer» y «Leer manga», y «Hacer manualidades» y «Armar una maqueta», compartieran ícono (límite de la 4.1).
- **Selector por familia:** 34 íconos, agrupados como las ideas, para que el color del anillo y su grupo digan lo mismo.
- **Pulso de la familia:** al elegir un ícono, o una actividad en Preparar, el nombre de su familia crece un 6 % y vuelve, con resortes sin rebote, y el degradado de su anillo recorre las letras y se apaga. Con «quitar animaciones» solo cambia el color.
- **Sin escalera:** el ícono de escalera se leía mal y salió de la app. «Pasos» usa ahora la bandera de «Decisión», y el primer paso, el círculo con la flecha de inicio de «Comencé».

## 3. ¿Dónde suena?

| Antes | Ahora |
| --- | --- |
| Arriba, una fila con el lugar («En la mesa»), que parecía una opción | Sin esa fila: el lugar se ve en «Todo listo» |
| «En tu Tag» con «Un Tag que pita» | «Tag»; solo cuando ya hay uno elegido lleva su nombre y su estado |
| «En el parlante» con «Sin parlante conectado» | «Dispositivo de audio», sin subtítulo; si no hay uno conectado, una línea debajo dice cómo conectarlo |
| «En el reloj», que sonaba como una llamada | Ya no se ofrece |
| «En el teléfono» con «Suena donde esté el teléfono» | «Notificaciones»: suena el teléfono y avisa también el reloj que recibe sus notificaciones |

Los textos nombran cada salida sin posesivo: «No sonó en el Tag», «No sonó en el dispositivo de audio». Solo el teléfono conserva el «tu», como pidió el autor: «Suena en tu teléfono». El texto del consentimiento no cambia.

## 4. Varios relevos a la vez

**Cómo funciona:** el relevo que se prepara y los que cuentan quedan en lugares separados ([ActiveStore](app/src/main/java/com/example/relevo/data/ActiveStore.kt)).

- **Activar** guarda el relevo entre los activos y deja libre el borrador para preparar otro.
- **El servicio** lee una sola vez qué app está en primer plano y suma tiempo a cada relevo que la incluye, con sus propias entradas y salidas en el registro.
- **Cuando uno se cumple**, pasa al primer plano para «Suena» y «¿Qué decidiste?». Si había un borrador a medias, se guarda y vuelve al terminar. Si otro se cumple mientras suena uno, espera su turno sin dejar de contar.
- **Inicio** muestra en la tarjeta de color el que sonará primero y los demás en filas, con cuánto les falta. Debajo queda «Preparar otro relevo».
- **Cada relevo** se abre, se cambia, se desactiva o se elimina por separado.
- **Cada relevo** tiene su sesión en el registro, como antes. Un relevo que estaba contando al instalar la 4.3 pasa solo a los activos.

Con esto se quita la regla de la 4.2.1 que impedía preparar otro relevo mientras uno contaba.

## 5. Perfil

- **Grupos:** «Relevos», «Actividades», «Pasos» y «Apps» en un grupo; «Ajustes» como fila en otro, con «Sonido, avisos, apariencia y datos»; y en Ayuda, «Cómo funciona Relevo», «Cómo usar el Tag», «Envíanos un comentario» y «Reportar un problema». La tuerca de arriba sigue.
- **Apps:** «Las que cuentan el tiempo», es decir, las que la persona considera su tiempo en el teléfono. Al abrir Preparar, un relevo sin apps las trae marcadas, si siguen instaladas.
- **Sin posesivos:** el título es «Perfil», y los campos, «Nombre» y «Emoji».

## 6. Editar una actividad

En «Nueva actividad» y «Editar la actividad», «¿Cómo empiezas la actividad?» y «¿En qué lugar empieza?» son filas. Al tocarlas se abre una hoja con las sugerencias de esa actividad, que se eligen con un toque y cierran la hoja. Debajo queda un campo, «O escríbelo», para escribir la propia.

## 7. Movimiento

- **La píldora de la barra** es una sola y se desplaza hasta la pestaña elegida con un resorte casi sin rebote. Mientras va rápido se estira un poco, como una gota.
- **El borde** va de 100 a 0 en todo su alto: pleno en el borde de la pantalla y nulo del lado del contenido, con curva suave. En la 4.2 era pleno bajo la barra y bajaba solo en el último tramo.
- **Pantalla de carga:** la marca de Relevo enciende sus cuatro luces por turno, en el sentido del reloj desde arriba (el tiempo, el primer paso, el lugar y la decisión), como un relevo que pasa de mano en mano. Usa la pantalla de carga de Android 12, dura menos de un segundo y no retrasa la apertura. Android la retira con su propia transición. Una salida propia, con la marca que crecía y se desvanecía, obligaba a traspasar la pantalla a la app, y en ese traspaso la marca desaparecía un cuadro; se vio al grabar el arranque y se quitó.
- **Cada paso empieza arriba** en Preparar, en «Cómo funciona» y en el perfil de la primera vez.

## 8. Textos

| Dónde | Antes | Ahora |
| --- | --- | --- |
| Bienvenida | «Cuando llevas un rato en el teléfono, suena donde empiezas.» | «Cuando cumplas el tiempo que elegiste en tus apps, sonará un aviso donde empieza esa actividad.» |
| Cómo funciona | «Relevo suena a tiempo, donde empiezas, para que no quede esperando.» | «Cuando se cumple el tiempo que elegiste en tus apps, Relevo suena donde empieza lo que querías hacer.» |
| Cómo funciona, filas | «Algo pequeño, de segundos» y «En el Tag, el parlante o el reloj» | «Con un primer paso, como abrir el libro» y «En el Tag o en un dispositivo de audio, junto a lo que quieres hacer» |
| Aviso semanal | «Una última pregunta», «¿Quieres preparar un relevo esta semana?» y «Sí, avísame» | «¿Te avisamos si pasa una semana?», el aviso de muestra y «Sí, quiero el aviso» |
| Primer paso, ayuda | «Algo que tome segundos» | Un ejemplo de esa actividad: «Ej.: elegir la película» |
| Intereses | Cápsulas de largos muy distintos | Anillos de a tres con una o dos palabras |
| Perfil | «Tu perfil», «Tus relevos», «Tus actividades», «Tus pasos», «Tu nombre», «Tu emoji» y «Tus datos» | «Perfil», «Relevos», «Actividades», «Pasos», «Nombre», «Emoji» y «Datos» |
| Inicio | «Tu paso en…», «Tu último relevo», «Tu semana», «Tus actividades» y «Tu relevo está contando» | «Siguiente paso en…», «Último relevo», «Esta semana», «Actividades» y «El relevo está contando» |
| Preparar | «Tus pasos», «Tus actividades», «Tu actividad» y «Tu primer relevo» | «Pasos», «Creadas por ti», «Actividad» y «Primer relevo» |
| Ideas y pasos | «Ordenar tu pieza», «Abrir tus apuntes» y «Avanzar en tu juego» | «Ordenar la pieza», «Abrir los apuntes» y «Avanzar en el juego» |
| Tag | «Si el tuyo está apagado…» y «Después elige el tuyo en la lista» | «Si está apagado…» y «Después elígelo en la lista» |

**Video:** el video de «Cómo funciona» mostraba la interfaz de la 3.x. Se quitó, junto con su registro de uso; la guía queda en dos pantallas.

## 9. El sonido

**Ajustes › Sonido** ofrece cuatro sonidos, y el que se elige suena una vez en el teléfono:

- **Madera:** la firma de D-071 y el sonido por defecto.
- **Fieltro:** más grave, lento y suave, para una casa silenciosa.
- **Claro:** más brillante y seguido, para una casa con ruido.
- **Tonada:** una frase de seis notas.

Los cuatro duran unos 30 segundos, empiezan suaves y terminan con la cuarta descendente de la firma. El Tag suena siempre con su pitido. El fundamento, la medición y las 26 referencias están en [El sonido de Relevo](sonido-de-relevo-2026-11-05.md); las muestras para escuchar, en [sonidos](sonidos/README.md).

## Verificación

- **Compilación y pruebas:** `assembleDebug` y `assembleRelease` sin errores. Pasan las 100 pruebas unitarias, nueve más que en la 4.2.1: cinco del catastro y cuatro de los sonidos.
- **APK optimizado:** pesa 10,7 MB, 2,1 MB menos que la 4.2.1, porque ya no lleva el video. Se instaló sobre la versión anterior en el emulador de Android 16 y abrió con los datos de prueba intactos, incluidos dos relevos activos.
- **En el emulador**, con el perfil «Prueba» ([capturas](capturas/interfaz-4.3/README.md)):
  - Las sugerencias de «Ver una película» son «Elegir la película», «Elegir el capítulo», «Preparar cabritas» y «Avisar a quien ve contigo»; sus lugares, «Junto a la tele» y «En el sillón».
  - «¿Dónde suena?» muestra «Tag», «Dispositivo de audio» y «Notificaciones», y la búsqueda del Tag ya no dice «el tuyo».
  - Se revisaron Inicio con dos relevos activos, Perfil, Ajustes › Sonido, la hoja de opciones al editar, los íconos por familia, los intereses y «Cómo funciona» sin video.
- **Movimiento**, en grabaciones de pantalla del emulador:
  - **La píldora** se desplaza de Inicio a Perfil y se estira un poco. A velocidad normal, el emulador dibuja tan pocos cuadros que parece saltar, así que se grabó con las animaciones 10 veces más lentas.
  - **La pantalla de carga** enciende las luces por turno al volver a abrir la app.
  - **El borde** desenfoca por completo junto a las barras y nada del lado del contenido.
  - **El nombre de la familia** toma el color de su anillo al elegir un ícono.
- **Corrección encontrada al grabar:** la salida propia de la pantalla de carga dejaba un cuadro sin la marca. Se quitó, y la nueva grabación ya no lo muestra.
- **Sonidos:** se generaron con el código de la app y se midieron ([El sonido de Relevo](sonido-de-relevo-2026-11-05.md)). Madera coincide con la firma.
- **Emulador:** su escala de animación estaba en 0,5; quedó en 1, la de fábrica, para ver las animaciones a su velocidad real.

**Sin verificar:**

- **En un teléfono:** la fluidez de la píldora y del borde a 60 cuadros por segundo, y la pantalla de carga en un arranque en frío. En el emulador, la animación termina antes de que se dibuje su primer cuadro.
- **Los sonidos:** nadie los ha escuchado en el teléfono, en un dispositivo de audio ni en una casa.
- **Varios relevos:** no se probó que dos se cumplan casi juntos, ni varios activos con el Tag o con un dispositivo de audio reales.
- **La migración:** no se probó instalar la 4.3 sobre una 4.2.1 con un relevo contando.

## Límites

- **El catastro** reconoce 34 conceptos. Una actividad fuera de ellos no recibe sugerencias, solo un ejemplo en el campo, y el catastro debe crecer cuando aparezcan actividades nuevas.
- **Las palabras** del catastro son del español de Chile, como «cabritas».
- **Si se cumplen dos relevos seguidos**, el segundo espera a que termine la señal del primero.
- **La memoria** v6 describe solo el sonido por defecto. Esta versión no la cambió.

## Registro de cambios (disclaimer)

### 2026-11-05 — Revisión del autor y cierre

- **Qué cambió:** se sumaron los pedidos de la segunda revisión (menos «tu», «Dispositivo de audio», sugerencias concretas y sin escalera), la sección del sonido, la verificación y los límites. La pantalla de carga ya no usa una salida propia.
- **Cómo estaba antes:** el documento hablaba de «Tu Tag» y «Tu parlante», tenía «Elegir qué ver» entre las sugerencias, y el sonido y la verificación estaban pendientes.
- **Por qué:** revisión del autor de la primera versión de la 4.3.

### 2026-11-05 — Creación

- **Qué cambió:** se describió la 4.3.
- **Cómo estaba antes:** la 4.2.1 sugería lo de otras actividades, permitía un solo relevo activo y tenía textos poco claros.
- **Por qué:** pedido del autor al probar la 4.2.1.
