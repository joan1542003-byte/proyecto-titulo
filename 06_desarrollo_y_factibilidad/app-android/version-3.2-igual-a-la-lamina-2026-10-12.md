# Android 3.2: igual a «Relevo, la app»

**Fecha:** 12 de octubre de 2026. **Decisión:** D-131. **APK:** [relevo-android-3.2-2026-10-12.apk](releases/relevo-android-3.2-2026-10-12.apk), versión optimizada de 12,8 MB. **SHA-256:** `F858A00ABF53DD67E711D1C31FB2768DFA854E541A38BECB9AB46ED83341FD7A`. **versionCode:** 45.

## Pedido

El autor revisó la 3.1 y dijo que seguía sin parecerse a la lámina [«Relevo, la app»](https://claude.ai/artifact/E6nkPDDmDrDF9Gw8zNxnqM). Señaló errores serios de diseño:

- malas alineaciones;
- falta de orden;
- colores repetidos y mezclados al elegir actividades.

Después de ver la 3.2 pidió otras dos cosas:

- cambiar «mientras todavía puedes hacerlo», que se entendía mal;
- cambiar «Tu ruta», que sonaba raro.

También pidió revisar de nuevo la lámina, porque faltaban detalles.

## Cómo se trabajó

1. La lámina se capturó pantalla por pantalla, a la escala de un teléfono de 411 dp, con Chrome sin ventana.
2. Cada captura se comparó con la misma pantalla del emulador.
3. Las medidas de la lámina se pasaron a la app multiplicadas por 1,5, que es la escala de su teléfono de muestra.

## Qué cambia

### Piezas nuevas o rehechas

- **Marco de pantalla:** arriba va una barra fija con cerrar o volver, el paso («1 de 6») y el avance en segmentos de lado a lado. Abajo, el botón principal queda fijo sobre el papel, con un fundido corto encima; el contenido ya no pasa por detrás sin velo. El título va en dos tonos, en la misma línea.
- **Filas:** tarjetas de 21 dp con una ficha de color de 45 dp, el título de 17 sp en seminegrita, el detalle de 15 sp y la sombra mínima de la lámina. La elegida lleva un anillo de tinta.
- **Opciones:** tarjeta con borde fino y un círculo a la derecha; la elegida lleva borde de tinta y el círculo lleno. Se usan en «¿Dónde suena?» y en «¿Qué decidiste?».
- **Campos:** una caja blanca con el rótulo adentro, arriba. El primer paso y el lugar llevan su ficha (cielo y lima).
- **Fichas de actividad:** solo el cielo y el nombre en una cápsula blanca, sin íconos encima. Un nombre largo pasa a dos líneas en vez de cortarse. La elegida lleva un anillo de tinta por fuera, sin mover nada.
- **Interruptores:** reemplazan los controles de «Sí / No» en Avisos, «Tu aura» y «Letra grande».
- **Barra de pestañas:** tarjeta de vidrio de 32 dp de radio; el destino elegido va en una ficha de tinta.
- **Íconos:** se suman tres del juego de D-124 que faltaban en la app: «Aura», «Avance» y «Abrir».

### Colores en orden

Al preparar un relevo, las 19 ideas se agrupan por familia y en el orden de los cielos:

1. Moverte.
2. Leer y aprender.
3. Crear.
4. Jugar y disfrutar.
5. En casa.
6. Descansar.
7. Con otras personas.

Antes iban mezcladas en tres columnas, y fichas iguales quedaban una al lado de otra. Dentro de una familia, cada actividad toma una variante del cielo (las luces reflejadas), así dos fichas del mismo color no se ven idénticas. La variante es la misma en todas las pantallas. Inicio muestra seis ideas, una por familia. Los intereses también se ordenan por familia.

### Pantallas

| Pantalla | Cómo queda |
| --- | --- |
| Bienvenida | La marca arriba; la actividad en su cielo con su primer paso y su lugar en filas que flotan sobre el aura; la frase y «Empezar» abajo. |
| Cómo funciona | La tercera página muestra las cuatro luces de la marca, cada una en su fila con su ficha: cuenta tu tiempo, te recuerda tu primer paso, suena donde empiezas y tú decides. |
| Antes de empezar | Cada parte del consentimiento va en una fila que se abre; el texto del consentimiento no cambia. La casilla «Acepto…» es una opción con borde. |
| Permisos | Cada permiso en su fila, con su botón o la marca de listo a la derecha. |
| Tu perfil (primera vez) | Los intereses son opciones de un toque con el color de su cielo. |
| Tu primer relevo | La actividad en su cielo y, en sus fichas, cómo empezar y dónde. |
| Inicio | La marca e «Inicio» arriba y la campana de los avisos a la derecha. El saludo va en dos tonos y debajo aparece «Tu siguiente paso para leer», con su cielo, sus filas y el botón. Siguen las ideas y tus actividades de a dos, y «Crear una actividad» con el degradado de la marca. Con un relevo activo, la tarjeta sobre el aura y la fila de dónde suena. |
| Contando | La flecha y «Inicio» arriba, la etiqueta «Contando», el tiempo en grande y una frase con fichas después de lo que nombran. «Eliminar» pasó a la hoja de desactivar. |
| Preparar | La franja de la actividad, las opciones de un toque, los campos con ficha y la nota «Mientras más pequeño, menos cuesta empezar». En «¿Cuándo suena?», el tiempo se cambia en la misma fila. «Todo listo» muestra los datos en sus fichas. |
| Suena | El cielo a pantalla completa, el Tag dibujado con los anillos del sonido y el mensaje en una tarjeta de vidrio. |
| Después de la señal | Primero, «Tres preguntas de un toque»; después, «¿Qué decidiste?» con la actividad en su cielo y las tres respuestas iguales entre sí. |
| Ruta | «Paso a paso hacia lo que te gustaría hacer más seguido», los pasos en escalera y «Agregar un paso». |
| Perfil | El emoji, el nombre y filas con qué hay adentro: tu semana, tus relevos, tus actividades, tus pasos, apariencia y aura, avisos, permisos y privacidad. |
| Apariencia y aura | El aura en una ventana, «Tu aura» con su interruptor, la intensidad, el tema y «Letra grande». |

### Textos que cambian

| Antes | Ahora |
| --- | --- |
| Relevo te lo recuerda mientras todavía puedes hacerlo. | Relevo te avisa a tiempo, cuando llevas un rato en el teléfono. |
| Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas. | Relevo te avisa a tiempo, en el lugar donde empiezas, para que no quede esperando. |
| Tu ruta · Pasos pequeños hacia lo que te gustaría hacer más seguido. | Paso a paso hacia lo que te gustaría hacer más seguido. |
| Tu ruta · Leer (Inicio) | Tu siguiente paso para leer |
| Tu ruta (Perfil y Preparar) | Tus pasos |
| ¿Quieres cambiar la actividad de tu ruta? | ¿Quieres cambiar este paso por otra actividad? |
| Cómo funciona: la app, lo que suena y tú | Las cuatro luces: cuenta tu tiempo, te recuerda tu primer paso, suena donde empiezas, tú decides |

La pestaña sigue llamándose «Ruta». Las preguntas de la investigación y el consentimiento no cambian.

## Qué no cambia

- **Código:** cambian `ui/`, `theme/Type.kt` (botón de 18 sp) y el número de versión. `data/`, `domain/`, `monitor/` y `signal/` son idénticos a los de la 3.0 y la 3.1.
- **Datos:** las preferencias, la base `relevo_research.db` (versión 9), Supabase y el consentimiento v13 son los mismos.
- **Firma:** la misma (`cl.udp.relevo`, certificado `fdbe6bbe…`). Se instala encima de la 3.1, la 3.0 o la 2.30.
- **Respuestas:** el orden y los valores de las tres respuestas de «¿Qué decidiste?» son los mismos. Las tres preguntas tras la señal se hacen antes, en el mismo orden y con los mismos valores; ahora van en su propia pantalla.

## Verificación

**Emulador** (Android 16), sin conexión mientras se probaba:

| Prueba | Resultado |
| --- | --- |
| Compilación limpia y pruebas unitarias | 85 aprobadas, ningún fallo |
| Primera vez completa con datos limpios | Bienvenida, guía, consentimiento, permisos, perfil, intereses y primer relevo |
| Relevo completo de 15 segundos con Reloj y Chrome | Preparar, activar, contar, sonar, tres preguntas y «¿Qué decidiste?» |
| Error encontrado y corregido | «Contando» se cerraba: la frase con fichas necesitaba un texto alternativo. Ahora lo tiene y TalkBack lo lee |
| Inicio, Ruta, Perfil, Apariencia, Avisos, Permisos, Tus relevos, Tus actividades, nueva actividad, Privacidad, opinión, reporte y la guía del Tag | Revisadas con capturas |
| Tema oscuro | Correcto en Apariencia, Inicio, Preparar y Perfil |
| Instalar la versión final encima de la anterior, con los datos del autor | Los datos quedaron idénticos (MD5); la capa de datos es la misma desde la 3.0 |
| Firma | Mismo certificado (`apksigner`) |

Al terminar, el emulador quedó con la 3.2 y con los datos del autor, idénticos a su respaldo.

## Lo que no se probó

- No se probó en un teléfono real ni con el Tag.
- No se revisaron TalkBack completo ni la letra grande al 200 %.
- No se vieron con un relevo activo la configuración de la prueba, las tarjetas semanales ni el cierre del día 21.

## Pendiente

- **Cuándo instalarla:** no conviene hacerlo a mitad de la prueba de 21 días.
- **Video de «Cómo funciona»:** todavía muestra la identidad anterior.
- **Elige su color:** no está implementado.
- **Memoria, capítulo 11:** describe la identidad de la 2.30.

## Registro de cambios (disclaimer)

### 2026-10-12 — Creación

- **Qué se añadió:** la versión 3.2, cómo se comparó con la lámina, lo que cambia (piezas, orden de los colores, pantallas y textos), lo que no, la verificación y lo pendiente.
- **Cómo estaba antes:** la última versión era la 3.1, que el autor revisó y no encontró igual a la lámina.
- **Por qué:** pedidos del autor del 12 de octubre (D-131).
