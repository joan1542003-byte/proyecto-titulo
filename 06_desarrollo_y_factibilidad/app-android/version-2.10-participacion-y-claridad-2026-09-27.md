# Android 2.10: participación en la prueba, textos claros, tono de las fotos y más emoji

**Fecha:** 27 de septiembre de 2026. **Versión:** 2.10 (`versionCode 22`). **Rama:** `android-2.7`. **Consentimiento en la app:** `2026-09-25-v6`, sin cambios en su texto.
**Base:** [Android 2.9](version-2.9-vidrio-y-emoji-2026-09-27.md). La 2.10 exige participar en la prueba para usar la app, aclara los textos, quita las mayúsculas sostenidas, reduce el desenfoque, adapta el color del texto a cada foto, amplía los emoji y rediseña «Tu ruta» y «Tus actividades». La lógica de la prueba de 21 días y los datos que se guardan no cambian. **Decisión:** D-084 del [registro](../../09_decisiones/registro-de-decisiones.md).

Las comprobaciones se hicieron en un emulador Android 16 (API 36) con datos ficticios y sin red, para que nada llegara a Supabase. Después se restauraron los datos que ya tenía el emulador. No sustituyen la prueba en el teléfono y el parlante reales ni una prueba con personas.

## Qué pidió el autor

Después de ver la 2.9, el autor pidió:
- corregir los textos confusos o poco usados, como «Empiezas», «Lugar» y «Marcar como el paso actual»;
- cambiar la tipografía de «Estás aquí», que parecía monoespaciada, y no usar nunca mayúsculas sostenidas;
- que en esta versión se participe sí o sí en la prueba, sin opción de no hacerlo;
- alejar el desenfoque progresivo del centro de la pantalla y desenfocar menos los botones;
- que el texto sobre una foto cambie de color según la foto: por ejemplo, que no quede texto negro sobre una foto oscura;
- más emoji 3D de Google para el perfil;
- una sección «Tu ruta» más clara e intuitiva y una sección «Tus actividades» que se entienda.

## Cómo se aplicó

| Pedido | En la app |
| --- | --- |
| Textos claros | Los rótulos sueltos pasaron a frases. «Empiezas: ponerte las zapatillas» y «Lugar: junto a la puerta» ahora se leen «Empieza por ponerte las zapatillas, junto a la puerta.». «Marcar como el paso actual» ahora es «Pasar a este paso» o «Volver a este paso», y «Estás aquí», «Ahora». Se fijó un vocabulario: «Para empezar» (cómo empiezas), «Dónde empiezas» (el lugar, que es donde queda el parlante) y «paso» solo para los pasos de la ruta. Ver los ejemplos más abajo. |
| Tipografía y mayúsculas | Los rótulos que iban en mayúsculas con letras espaciadas («ESTÁS AQUÍ», «TU RUTA · MOVERME», «LA ÚLTIMA VEZ», los títulos de las listas) se escriben como una frase, en Schibsted Grotesk seminegrita y sin espaciado. Ningún texto de la app va en mayúsculas sostenidas. |
| Participar sí o sí | Se quitó «No participar» y el uso sin participar de 2.8 y 2.9. El consentimiento se titula «La prueba de 21 días» y dice que Relevo es parte de un proyecto de título. Quien lo había usado sin participar ve el consentimiento al abrir la app. En Privacidad y datos, «Borrar mis datos» avisa: «También dejas la prueba». |
| Desenfoque más lejos del centro | El borde superior termina poco después de la barra (antes seguía 26 dp más) y su desenfoque baja de 22 a 18 dp. Abajo, el desenfoque empieza a la altura del botón y se completa detrás de su mitad inferior y de las pestañas; antes empezaba 22 dp por encima del botón y ya era completo en su mitad superior. |
| Menos desenfoque en los botones | Los botones de vidrio pasan de 24 a 12 dp de desenfoque, y la barra de pestañas, a 16 dp. Las hojas mantienen 24 dp para que su texto se lea. |
| Texto según la foto | La app mide la luminancia media de la zona de la foto que queda bajo el texto. Si es oscura, el texto, las etiquetas y el vidrio de encima toman la paleta de noche (texto blanco); si es clara, la de papel (texto de tinta). Lo mismo pasa con los iconos de la barra de estado y los botones de la barra sobre las fotos que llegan al borde superior. |
| Más emoji | De 24 a 84 emoji 3D de Google, en cinco grupos, como en los teclados: caras (12), animales (20), naturaleza (17), comida (11) y actividades (24). |
| «Tu ruta» más clara | Arriba, en grande, el paso en que está la persona, con «Ahora», el interés, el número de paso y la frase de cómo y dónde empezar. Debajo, «Todos los pasos» con su número en un círculo, unidos por una línea. Tocar un paso abre una hoja con «Preparar un relevo con este paso» y «Pasar a este paso». «Editar los pasos» y «Cambiar intereses» van al final, con el mismo peso. |
| «Tus actividades» clara | Un subtítulo dice para qué sirven: «Lo que haces seguido, listo para preparar en un toque». Sin actividades, se explica qué anotar. Tocar una abre una hoja con «Preparar un relevo» y «Editar». El editor pone la imagen arriba, en un círculo que se cambia en una hoja, y tres renglones: «Actividad», «Para empezar» y «Dónde empiezas». |

### Algunos textos antes y después

| Antes (2.9) | Ahora (2.10) |
| --- | --- |
| ESTÁS AQUÍ · Empiezas: Ponerte las zapatillas · Lugar: Junto a la puerta | Ahora · Empieza por ponerte las zapatillas, junto a la puerta. |
| Marcar como el paso actual | Pasar a este paso · Volver a este paso |
| Preparar este paso | Preparar un relevo con este paso |
| ¿Quieres participar en la prueba? · No participar | La prueba de 21 días (sin «No participar») |
| ¿Dónde lo dejas? · ¿Cuándo suena? · ¿Dónde suena? | ¿Dónde empiezas? · ¿Cuándo te avisa? · ¿Cómo te avisa? |
| Cómo empieza · Lugar · Apps · Suena después de · Suena en | Para empezar · Dónde empiezas · Apps que cuentan · Te avisa después de · Te avisa |
| El conteo está en pausa · Abrir ajustes | Relevo no puede contar el tiempo · Dar el permiso |
| Deja de contar y no sonará. Después puedes contar qué decidiste. | Dejará de contar el tiempo y no sonará. Después podrás decir qué decidiste. |
| Aviso de regreso · Constancia elegida · Resumen «Tu semana» | Aviso semanal · Veces por semana · Resumen semanal |
| Parlante junto al comienzo · Parlante en un lugar neutro | Parlante donde empiezas · Parlante en otro lugar |
| Esperando | Contando |
| La señal terminó | Ya dejó de sonar |

No cambiaron las secciones del consentimiento, la frase de aceptación, las preguntas de la prueba de 21 días (tras la señal, al cerrar cada semana y el día 21), las tres respuestas de «¿Qué decidiste?» ni el texto «Tu intención está disponible» de la condición teléfono, porque son instrumentos del protocolo 02.

## Participación y ética

En esta versión, Relevo se usa solo dentro de la prueba (D-084). La app sigue pidiendo el consentimiento completo, con la casilla y los detalles, y el texto del consentimiento no cambió: participar sigue siendo voluntario y se puede terminar la prueba sin explicar por qué. Lo que cambia es que ya no hay un modo para usar la app sin participar:
- quien no acepta no avanza; puede cerrar o desinstalar la app, y no se guardó nada suyo;
- quien participa puede dejar la prueba desde Privacidad y datos: «Borrar mis datos» borra todo, también en la base de la prueba, y la app vuelve al comienzo;
- quien había usado la 2.8 o la 2.9 sin participar conserva en el teléfono su perfil, su ruta y sus actividades, pero no puede preparar relevos hasta aceptar. Lo que hizo antes no se registró y no se envía.

## Tono del texto sobre las fotos

- **Cálculo:** para cada foto y cada zona se decodifica una copia de unos 64 px de ancho, se recorta como en pantalla y se promedia la luminancia relativa de sus píxeles. El cálculo se hace una vez, fuera del hilo principal, y se guarda en memoria.
- **Umbral:** 0,19. Es el punto en que el texto blanco y el de tinta tienen el mismo contraste sobre el fondo, según la definición de luminancia y contraste de WCAG 2.2 (World Wide Web Consortium, 2023). Por debajo, la zona se considera oscura.
- **Dónde se aplica:** en las fotos grandes con banda de vidrio (Inicio, Tu ruta, Todo listo, relevo activo y regreso) y en las fotos que llegan al borde superior (bienvenida, permiso, Tu relevo y señal), donde cambian los iconos de la barra de estado y los botones de vidrio.
- **Límite:** es un promedio. Una foto con una zona muy clara y otra muy oscura bajo el mismo texto puede quedar con menos contraste en una parte. Apple describe el mismo principio para Liquid Glass, que pasa de claro a oscuro según el contenido que tiene detrás (Apple, 2025).

## Técnica

- **Archivos nuevos:** `ui/components/Tone.kt` (tono de las fotos y de la barra de estado) y tres pruebas: `ToneMathTest`, `StartSentenceTest` y una prueba más en `EmojiTest`.
- **Emoji:** 60 PNG nuevos de 256 px, bajados del repositorio de Google. Los 84 se recomprimieron sin pérdida (se comprobó que los píxeles no cambian): pesan 4,3 MB en vez de 6,0 MB. Se cargan fuera del hilo principal, a la mitad de resolución en el selector.
- **Teclado:** con el teclado abierto, el contenido termina encima del botón flotante, para que el campo que se escribe no quede tapado por «Guardar» o «Seguir». En el emulador el teclado quedó flotante y no se pudo comprobar.
- **Tamaño:** el APK pasó de 36,5 MB (2.9) a 39,3 MB.
- **Proyecto portable:** desde 2.10, el ZIP deja fuera `capturas/` y `assets-explorados/`, que siguen en el repositorio. Pesa 7,4 MB en vez de 61 MB; GitHub había advertido que el ZIP de 2.9 superaba los 50 MB recomendados.

## Datos y privacidad

No cambia qué se guarda ni qué se envía. El registro para la investigación ya exigía el consentimiento vigente; ahora también lo exige usar la app. La imagen del perfil sigue siendo `emoji:<código>` y queda solo en el teléfono.

## Verificación

| Comprobación | Resultado |
| --- | --- |
| Compilación limpia y 58 pruebas unitarias: las 50 de 2.9 y 8 nuevas (cálculo del tono, frase de cómo y dónde empezar y catálogo de emoji). | Aprobadas. |
| Primera vez (bienvenida, consentimiento sin «No participar», permiso, emoji por grupos e intereses). | Recorrido completo. |
| Quien usaba la 2.9 sin participar (datos simulados). | Al abrir, ve el consentimiento; la marca del uso sin participar se borra. |
| «Tu ruta»: paso actual, todos los pasos, hoja del paso, «Pasar a este paso», edición de los pasos y rutas con fotos claras y oscuras. | Funciona. Se corrigió una etiqueta «Ahora» que chocaba con el nombre del paso en la lista. |
| Preparación con «Tocar un instrumento» (foto oscura), revisión, relevo activo, «Tu relevo», señal tras 15 s en Chrome (salida teléfono), «¿Qué decidiste?» y mensaje. | Recorrido completo. Sobre la foto oscura, el texto y el vidrio pasaron a blanco y oscuro, y los iconos de la barra de estado, a claros. Se corrigió que, al pasar de «Tu relevo» a la señal, la barra de estado volvía a iconos oscuros. |
| «Tus actividades»: sin actividades, crear una, lista, hoja y selector de imagen. | Funciona. Se vio que, con el teclado abierto, el botón «Guardar» tapaba el último renglón; el ajuste quedó programado, pero no se pudo comprobar (ver Técnica). |
| Avisos y resúmenes, Privacidad y datos, tema oscuro. | Funcionan. |
| Supabase. | Las pruebas se hicieron sin red: no se envió nada. Al terminarlas, la base tenía 7 sesiones, 6 eventos y 0 respuestas, del 22 al 27 de septiembre. La sesión más reciente (27 de septiembre, 07:19 UTC) es anterior a estas pruebas y viene de los datos propios del emulador; no se tocó. |
| No comprobado. | Borrar los datos (solo cambiaron sus textos), el ajuste del teclado, el teléfono y el parlante reales, TalkBack y el texto grande. |

Las capturas están en [capturas/interfaz-2.10](capturas/interfaz-2.10/README.md).

## Pendiente

- **Decisión del autor:** qué versión usar en la prueba de 21 días. La 2.10 conserva la lógica y los datos de 2.7, 2.8 y 2.9, pero ya no permite usar la app sin participar.
- **Revisión ética:** conviene que el profesor guía confirme que exigir la participación para usar esta versión es compatible con el consentimiento, que la declara voluntaria.
- **Manual de marca:** D-084 quita en la app las «notas en mayúsculas» de D-073, como D-083 quitó la regla sin vidrio. Si el autor quiere coherencia, el manual y el kit deben actualizarse; para eso se propuso el 27 de septiembre el [sistema de marca 2.0 en Figma](../../10_recursos_visuales/22_sistema-de-marca-2.0-figma-2026-09-27.md) (D-085).
- **En el teléfono real:** que el desenfoque se vea fluido, que el tono elegido funcione con las fotos definitivas, TalkBack y texto grande.
- **Textos:** revisión del autor de los textos nuevos.
- **Defecto visual:** al responder «¿Qué decidiste?», mientras la pantalla se va, se ve por unos 0,2 segundos un encabezado vacío («Desactivaste el relevo. Vuelve a .»). Se vio en el emulador al grabar el [GIF de la app](capturas/como-funciona-2.10/README.md), después de desactivar un relevo y preparar otro; no afecta los datos.
- Lo pendiente de 2.8 y 2.9 sigue igual: parlante, borrado sin conexión y fotografía propia.

## Referencias

Apple Inc. (2025). *Meet Liquid Glass* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/219/

googlefonts. (2026). *noto-emoji* [Repositorio de código]. GitHub. https://github.com/googlefonts/noto-emoji

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

Yablonski, J. (s. f.). *Laws of UX*. https://lawsofux.com/

## Registro de cambios (disclaimer)

### 2026-09-27 — Defecto visual al responder

- **Qué cambió:** se registró como pendiente un encabezado vacío que aparece por un instante al salir de «¿Qué decidiste?».
- **Cómo estaba antes:** no estaba registrado.
- **Por qué:** se vio al grabar el GIF de la app para la presentación.

### 2026-09-27 — Marca 2.0

- **Qué cambió:** el pendiente del manual de marca enlaza el sistema de marca 2.0 en Figma (D-085).
- **Cómo estaba antes:** decía solo que el manual y el kit debían actualizarse.
- **Por qué:** el autor pidió esa actualización el mismo día.

### 2026-09-27 — Documento nuevo

- **Qué se añadió:** los pedidos del autor sobre la 2.9, cómo se aplicó cada uno, ejemplos de textos, la participación obligatoria y sus límites éticos, el cálculo del tono de las fotos, la técnica, los datos, la verificación y lo pendiente de la versión 2.10.
- **Cómo estaba antes:** la 2.9 era la versión más reciente, con uso sin participar, rótulos en mayúsculas y textos como «Empiezas» y «Lugar».
- **Por qué:** dejar trazable qué pidió el autor, qué se decidió (D-084), qué se comprobó y qué falta.
