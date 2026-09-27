# Android 2.9: vidrio, formas redondeadas, emoji y textos naturales

**Fecha:** 27 de septiembre de 2026. **Versión:** 2.9 (`versionCode 21`). **Rama:** `android-2.7`. **Consentimiento en la app:** `2026-09-25-v6`, sin cambios.
**Base:** [Android 2.8](version-2.8-rediseno-perfil-y-ruta-2026-09-26.md). La 2.9 cambia el aspecto, la interacción y los textos; la lógica de la prueba de 21 días, los datos y las pantallas siguen siendo los de la 2.8. **Decisión:** D-083 del [registro](../../09_decisiones/registro-de-decisiones.md).

Las comprobaciones se hicieron en un emulador Android 16 (API 36) con datos ficticios, que después se borraron. No sustituyen la prueba en el teléfono y el parlante reales ni una prueba con personas.

## Qué pidió el autor

Después de ver la 2.8, el autor pidió:
- no repetir a cada rato que la información es privada;
- un diseño más moderno, a pantalla completa, con bordes redondeados y al estilo de iOS 26: transparencias con desenfoques sutiles, sin brillos;
- solo iconos o emoji en la imagen del perfil, y sugirió los emoji 3D que Google lanzó hace poco;
- una interfaz y unos textos más naturales;
- cada pantalla perfeccionada, hermosa pero fácil de usar, sin sobrediseñar ni sobreexplicar, y nada de bloques cuadrados.

Recomendó revisar Laws of UX y sitios de componentes y microinteracciones, como transitions.dev y React Bits.

## Qué se tomó de cada fuente

- **Liquid Glass de Apple (iOS 26):**
  - el vidrio va solo en la capa de navegación, que flota sobre el contenido, y nunca en el contenido mismo;
  - la barra de pestañas es una cápsula separada de los bordes;
  - al desplazar, el contenido se desenfoca y se funde bajo las barras («borde de desplazamiento»);
  - los controles son cápsulas y las esquinas anidadas son concéntricas (Apple, 2025a, 2025b).
- **Laws of UX (Yablonski, s. f.):**
  - patrones conocidos de iOS y Android (ley de Jakob);
  - la acción principal grande y abajo, al alcance del pulgar (ley de Fitts);
  - menos opciones y menos texto por pantalla (ley de Hick y carga cognitiva);
  - respuestas visuales inmediatas, por debajo de 400 ms (umbral de Doherty);
  - cuidado estético sin sacrificar la claridad (efecto estética-usabilidad).
- **transitions.dev:** el indicador en cápsula que se desliza entre pestañas, las cifras que aparecen con un leve desenfoque, la marca de listo que se dibuja con el trazo y el mensaje que sube con desenfoque y escala.
- **Emoji Noto 3D de Google:** Google los publicó en su repositorio el 17 de septiembre de 2026, en PNG de cuatro tamaños (Google, 2026; googlefonts, 2026).

## Cómo se aplicó

| Pedido | En la app |
| --- | --- |
| Pantalla completa | El contenido ocupa toda la pantalla y pasa bajo las barras. En bienvenida, permiso, «Tu relevo» y señal, la foto llega hasta la barra de estado y termina con esquinas amplias. |
| Transparencias con desenfoque, sin brillo | Vidrio real (desenfoque de 22 a 26 dp con un tinte de papel o de noche) en la barra de pestañas, los botones de la barra, las hojas y el borde de desplazamiento arriba y abajo. Sobre las fotos grandes, el texto va en una banda de vidrio que se vuelve más densa hacia abajo. No hay reflejos, degradados de luz ni sombras marcadas. |
| Bordes redondeados, nada de bloques cuadrados | Botones, controles segmentados, etiquetas, buscador y pestañas en cápsula. Tarjetas de 28 dp y fichas de 20 a 26 dp. Hojas flotantes de 34 dp, separadas de los bordes. Las baldosas cuadradas de los iconos de las listas se quitaron, y las miniaturas, marcas de selección y números de pasos pasaron a círculos. |
| Imagen del perfil solo con iconos | 24 emoji 3D de Google en círculos: objetos de actividades, animales y naturaleza. Quien ya había elegido una foto o un icono ve el emoji más cercano. |
| Textos naturales y sin sobreexplicar | Se quitaron los avisos de privacidad repetidos: «Solo lo verás tú. No sale del teléfono» (P1 y edición del perfil), «No se suben fotos: así no se guardan rostros» (P2) y «Se guardan solo en este teléfono» (Tus actividades). La privacidad se explica en el consentimiento (A2), en la hoja de uso sin participar y en Privacidad y datos. Se acortaron títulos y ayudas en todas las pantallas. |
| Perfeccionar cada pantalla | Foto grande en Inicio y Ruta; preparación con avance en cápsula y opciones de sonido en tarjetas; «¿Qué decidiste?» con tres cápsulas del mismo peso; perfil centrado; el logotipo, sin superponerse a la foto de la bienvenida. |

### Algunos textos antes y después

| Antes (2.8) | Ahora (2.9) |
| --- | --- |
| ¿Cómo te llamamos? · «Solo lo verás tú. No sale del teléfono.» | ¿Cómo te llamas? |
| Elige una imagen · «Una imagen que te represente. No se suben fotos…» | Elige tu ícono |
| Participar en la prueba | ¿Quieres participar en la prueba? |
| Revisa tu relevo | Todo listo |
| ¿Después de cuánto uso? · «El tiempo de estas apps se suma hasta llegar al límite.» | ¿Cuándo suena? · «Suena cuando sumes este tiempo en las apps que elijas.» |
| Preparar un relevo con este paso | Preparar este paso |
| Relevo dejó de contar porque se retiró el permiso de Tiempo de uso. | Se retiró el permiso de Tiempo de uso. |
| Después de responder · Con mensajes / Solo registrar | Mensaje al responder · No / Sí |

No cambiaron las preguntas de la prueba de 21 días, los textos del consentimiento ni los de las condiciones, porque son instrumentos del protocolo 02.

## Interacciones y movimiento

- **Pestañas:** una cápsula clara se desliza hasta el destino elegido, sin rebote, y el icono se asienta con una leve escala.
- **Bordes de desplazamiento:** el desenfoque superior aparece solo cuando hay contenido bajo la barra; el título grande sube a la barra con un fundido.
- **Hojas:** suben desde abajo y se cierran arrastrando hacia abajo, tocando fuera o con el gesto de volver. La hoja deja ver, desenfocado, lo que queda detrás, y el resto de la pantalla se atenúa.
- **Cifras:** el tiempo contado y el selector de tiempo cambian deslizándose y se enfocan al llegar.
- **Marcas:** el círculo se llena y la marca de listo se dibuja con el trazo. En las fichas, la elegida se encoge dentro de un anillo concéntrico.
- **Mensaje tras responder:** sube con un leve desenfoque y escala, la marca se dibuja y se va solo.
- **Bienvenida:** la foto se acerca despacio al abrir.
- **Animaciones desactivadas:** si Android las quita, Relevo también.

## Técnica

- **Desenfoque:** Haze 1.6.10, la misma biblioteca que usaba la 2.7 (licencia Apache 2.0). Desenfoca con `RenderEffect`, disponible desde Android 12, que es el mínimo de la app. Haze 2.0 exigía subir Compose a 1.12 y Kotlin a 2.4, por eso no se usó.
- **Hojas:** ya no son ventanas aparte. Se dibujan en una capa propia sobre la app, lo que permite desenfocar lo que queda detrás.
- **Emoji:** 24 PNG de 256 px, 1,6 MB, reducidos desde los de 512 px del repositorio de Google. La licencia está en [`app/licenses/NOTO_EMOJI_LICENSE.md`](app/licenses/NOTO_EMOJI_LICENSE.md) y en el [registro de licencias](licencias/README.md).
- **Tamaño:** el APK pasó de 34,5 MB (2.8) a 36,5 MB.

## Datos y privacidad

No cambia qué se guarda ni qué se envía. La imagen del perfil se guarda como `emoji:<código>` y, como en 2.8, queda solo en el teléfono. La descarga de datos incluye esa clave.

## Verificación

| Comprobación | Resultado |
| --- | --- |
| Compilación limpia y 50 pruebas unitarias: las 47 de 2.8 y 3 nuevas sobre el catálogo de emoji y la equivalencia con las imágenes antiguas. | Aprobadas. |
| Inicio, Ruta y Perfil: pestañas de vidrio, bordes al desplazar, fotos con banda, botón flotante sobre las pestañas. | Funcionan. Se corrigieron tres detalles: un borde superior demasiado débil, un título grande algo desenfocado en reposo y una ficha «Nueva actividad» que era un bloque vacío. |
| Hojas de vidrio: apps, emoji, paso de la ruta, confirmaciones y uso sin participar. | Se abren, desenfocan lo de atrás y se cierran con «Listo», tocando fuera, arrastrando o con el gesto de volver. |
| Preparación completa hasta activar, relevo activo, señal tras 15 s en Chrome (sin parlante: E1), respuesta y mensaje. | Recorrido completo. |
| Primera vez completa (A1 a A3 con «No participar», P1 a P3). | Recorrido completo. Antes se respaldaron los datos del emulador y después se restauraron. |
| Imagen de perfil elegida antes de 2.9 (un icono de música). | Se ve como el emoji de audífonos. |
| Tema oscuro. | Vidrio oscuro, banda oscura sobre las fotos y controles legibles. |
| Supabase. | El relevo de prueba creó 1 sesión y 4 eventos; se borraron. La base volvió a 6 sesiones y 4 eventos, todos del 22 al 25 de septiembre. |

## Pendiente

- **Decisión del autor:** qué versión usar en la prueba de 21 días. La 2.9 conserva la lógica y los datos de 2.8 y 2.7.
- **Manual de marca:** D-083 cambia en la app la regla de D-073 que prohibía vidrio, desenfoque y píldoras. Si el autor quiere mantener coherencia, el manual y el kit deben actualizarse.
- **En el teléfono real:**
  - que el desenfoque se vea fluido;
  - texto grande en todas las pantallas;
  - TalkBack en las hojas y en los botones de vidrio.
- **Textos:** revisión del autor de los textos nuevos.
- Lo pendiente de 2.8 sigue igual: parlante, borrado sin conexión y fotografía propia.

## Referencias

Apple Inc. (2025a). *Get to know the new design system* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/356/

Apple Inc. (2025b). *Meet Liquid Glass* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/219/

Google. (2026). *Express yourself authentically with Google's Noto 3D emoji*. The Keyword. https://blog.google/products-and-platforms/platforms/android/noto-3d-emoji/

googlefonts. (2026). *noto-emoji* [Repositorio de código]. GitHub. https://github.com/googlefonts/noto-emoji

Yablonski, J. (s. f.). *Laws of UX*. https://lawsofux.com/

## Registro de cambios (disclaimer)

### 2026-09-27 — Documento nuevo

- **Qué se añadió:** los pedidos del autor, las fuentes consultadas y qué se tomó de cada una, cómo se aplicó cada pedido, ejemplos de textos, interacciones, técnica, datos, verificación y pendientes de la versión 2.9.
- **Cómo estaba antes:** la 2.8 era la versión más reciente, con superficies planas, fotos en el perfil y avisos de privacidad repetidos.
- **Por qué:** dejar trazable qué pidió el autor, qué se decidió (D-083), qué se comprobó y qué falta.
