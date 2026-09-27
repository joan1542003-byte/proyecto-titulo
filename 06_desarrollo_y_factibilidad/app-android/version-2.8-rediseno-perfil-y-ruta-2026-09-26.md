# Android 2.8: sistema de marca D-073, perfil, ruta y regreso

**Fecha:** 26 de septiembre de 2026. **Versión:** 2.8 (`versionCode 20`). **Rama:** `android-2.7`. **Consentimiento en la app:** `2026-09-25-v6`, el mismo de 2.7; quien ya lo aceptó no tiene que aceptarlo de nuevo.
**Fuentes:** [marca «Vuelve a lo que querías hacer»](../../10_recursos_visuales/21_marca-relevo-a-tiempo-2026-09-25.md) y su [kit](../../10_recursos_visuales/marca-a-tiempo/kit-relevo-2026-09-25.html) (D-073), [flujos y wireframes escritos](../../05_propuesta_phygital/flujos-y-wireframes-escritos-2026-09-25.md) (D-074, D-076 y D-077) y [Android 2.7](version-2.7-prueba-21-dias-2026-09-25.md), cuya lógica de la prueba de 21 días se conserva sin cambios.

**Actualización:** la [2.9](version-2.9-vidrio-y-emoji-2026-09-27.md) cambia el aspecto, los textos y la imagen del perfil (D-083). La lógica, los datos y las pantallas descritos aquí siguen vigentes.

Las comprobaciones se hicieron en un emulador Android 16 (API 36) con datos ficticios, que después se borraron. No sustituyen la prueba en el teléfono y el parlante reales ni una prueba con personas.

## Qué pidió el autor

El 25 de septiembre el autor pidió aplicar a la app las directrices de diseño nuevas (D-073). Una primera versión plana, sin fotografías (commit `54faff9`), no lo convenció: la 2.6 y la 2.7 tenían imágenes, se podían personalizar más y se veían mejor diseñadas, y faltaban pantallas del diseño escrito. Pidió entonces ajustar la app a D-073, mejorar el diseño anterior hasta el nivel de las mejores apps del mercado, con buenas interacciones y animaciones, y completar las pantallas que faltaban.

## Cómo se aplica D-073

| Regla del sistema | En la app |
| --- | --- |
| Schibsted Grotesk en todos los usos. | Única fuente, de título grande a nota al pie. Reemplaza a Source Sans 3. |
| Tinta, papel y azul pasta; el azul solo para lo que escribe la persona. | Relevo habla en tinta sobre papel. El azul marca solo las palabras de la persona en el renglón «Vuelve a \_\_\_\_.» y el foco. Modo oscuro con noche y pizarra, y azul claro para las palabras de la persona. |
| Esquinas de 12 dp en controles y 20 dp en paneles; sin píldoras. | Botones, campos y controles segmentados de 12 dp; tarjetas y listas de 20 dp; etiquetas de estado de 8 dp. |
| Sin vidrio, desenfoque, degradados ni velos. | Barras planas sobre papel; una línea aparece bajo la barra al desplazar. Se retiró el desenfoque de Haze que usaban 2.2 a 2.7. |
| Fotografía: el comienzo de la actividad, no el resultado; texto fuera de la foto. | Zapatillas junto a la puerta, un libro abierto, masa sobre la mesa. Los rótulos van debajo de la foto, nunca encima ni con velo. |
| Iconos propios con palabras. | Los 97 iconos del kit, dibujados como código. La barra inferior lleva icono y nombre, y los avisos de Android usan la «r» del ícono de la app. |
| Movimiento breve y sin rebote. | 200 a 240 ms, resortes sin rebote; el renglón se escribe en 450 ms. Si Android tiene las animaciones desactivadas, se quitan. |
| Una acción principal, abajo y con verbo (D-077). | Siempre en el mismo lugar, separada por una línea cuando hay contenido debajo. |
| Tono: tú, sin exclamaciones; «se nota, no se dice». | Los textos no anuncian que Relevo no presiona; lo muestran: una sola señal, respuestas con el mismo peso y sin rachas. |

## Pantallas

El mapa sigue el [diseño escrito](../../05_propuesta_phygital/flujos-y-wireframes-escritos-2026-09-25.md): tres destinos abajo (**Inicio**, **Ruta** y **Perfil**) y las pantallas A, P, R, B, V, S, T y E.

| Grupo | En 2.8 | Diferencias con el diseño escrito |
| --- | --- | --- |
| Primera vez (A1–A3) | Bienvenida con la foto de la puerta y la firma; participar en la prueba, con «Leer los detalles» y «No participar»; permiso de Tiempo de uso. | «No participar» abre una hoja que explica qué pasa antes de confirmar (ver «Datos y privacidad»). |
| Perfil (P1–P3) | Nombre, imagen e intereses, con «Saltar» en cada paso y vista previa de la imagen. | P2 ofrece 16 fotos de la app y 12 iconos del kit; el diseño preveía solo iconos. Se mantiene el criterio: no se suben fotos propias. |
| Ruta (R1–R3) | Ruta por interés con «Estás aquí», edición de pasos (agregar, quitar, reordenar y elegir el actual) y oferta del siguiente paso. | R3 aparece a la tercera respuesta «Comencé» en el mismo paso, en una hoja con dos opciones de igual peso. Si la persona elige quedarse, no se vuelve a ofrecer para ese paso. |
| Relevo (B1–B5) | Inicio con el paso de la ruta, ideas con foto y actividades propias; preparar en seis pasos; esperando; señal; «¿Qué decidiste?». | La foto tocada viaja a la pantalla siguiente. B3 muestra el tiempo contado como un renglón que se llena. |
| Regreso (V1–V2) | V1 como en 2.7, con el nombre si la persona lo dio. V2 opcional: una notificación silenciosa como máximo una vez por semana, solo si no abrió la app. | Falta el caso «Tu relevo anterior terminó sin sonar» de V1. |
| Ajustes (S1–S3) | Perfil con «Tu semana» (si está activo); avisos y resúmenes con las cuatro opciones; privacidad y datos. | Se agregaron Apariencia (tema y texto grande), Permisos, Tus relevos, Tus actividades, «¿Cómo te resultó usar Relevo?» y «Reportar un problema». Estas dos últimas solo aparecen a quien participa en la prueba. |
| Prueba (T1–T2) | Sin cambios de lógica respecto de 2.7. | — |
| Fallos (E1–E2) | Como en 2.7. | Cuando no rige una condición de la prueba y el parlante falla, E1 ofrece además sonar en el teléfono. |

Capturas: [`capturas/interfaz-2.8`](capturas/interfaz-2.8/README.md).

## Interacciones y movimiento

- **Continuidad espacial.** La foto de una tarjeta se expande a la pantalla que abre (preparar, esperando, tu relevo) y vuelve a su lugar al regresar.
- **Volver con el gesto.** En Android 14 o superior, el gesto de volver arrastra la pantalla con el dedo y la devuelve a su lugar si se suelta antes; la preparación y otras pantallas de creación suben desde abajo.
- **Pestañas.** Cada pestaña conserva su desplazamiento y su estado; tocar otra vez la pestaña activa sube al comienzo.
- **Títulos grandes** que pasan a la barra al desplazar, con un fundido.
- **Respuesta al toque.** Los botones se hunden levemente y vibran con un toque corto; las tarjetas responden igual.
- **Estado vivo.** El tiempo contado sube como un contador y el renglón de progreso se llena con un resorte sin rebote. Mientras suena la señal, el icono respira despacio.
- **Entrada escalonada.** Al abrir una pantalla por primera vez, sus bloques aparecen uno tras otro; al volver a ella, ya están en su lugar.
- **Reconocimientos breves** que se van solos a los seis segundos.
- **Fotos sin espera visible.** Se decodifican fuera del hilo principal, se guardan en memoria y aparecen con un fundido.

## Personalización

- **Perfil:** nombre, imagen (16 fotos o 12 iconos) e intereses, incluida «Otra» con texto propio.
- **Ruta:** pasos editables por interés; la persona elige en qué paso está.
- **Actividades propias:** nombre, primer paso, lugar y una imagen, a elegir entre fotos, 21 iconos o una foto que la app sugiere según las palabras del nombre.
- **Apariencia:** tema del sistema, claro u oscuro; texto grande (15 % más, sobre el ajuste de Android).
- **Avisos y resúmenes (S2):** resumen «Tu semana» (no por defecto), aviso de regreso (nunca por defecto), mensajes de reconocimiento o solo registrar, y constancia elegida, apagada por defecto y con «Pausar la constancia».

## Datos y privacidad

- **Solo en el teléfono:** nombre, imagen, intereses, ruta y ajustes. No se envían a Supabase. Cuando la persona prepara un relevo desde un paso de la ruta, la actividad, el primer paso y el lugar se registran como en cualquier relevo.
- **Usar sin participar («No participar» en A2):** la app funciona igual, pero no guarda sesiones, eventos ni respuestas de la investigación y no crea la sesión anónima de Supabase. Desde Privacidad y datos se puede entrar a la prueba más tarde.
- **Respuestas nuevas en `relevo_answers`,** todas opcionales y solo para quien participa: `opinion_estrellas` (1 a 5; las estrellas califican la app, no a la persona), `opinion_comentario`, `reporte_problema`, `reporte_registro` y `tu_semana_ayudo`. El registro técnico se adjunta solo si la persona lo marca e incluye versión de la app y de Android, estado del relevo, salida elegida, permisos, restricción de batería, si está contando, pendientes y rechazos del envío y el último error (160 caracteres como máximo). No incluye nada de lo que la persona hace en otras apps. La base ya aceptaba estas claves: limita la clave a 40 caracteres y la respuesta a 600, igual que la app.
- **Descargar mis datos (S3):** un archivo JSON, guardado donde la persona elige, con perfil, ruta, actividades propias, relevos y el registro del estudio (sesiones, eventos y respuestas).
- **Borrar:** además de lo que borraba 2.7, borra perfil, ruta y ajustes, y cancela el aviso de regreso.
- **Pantalla de bloqueo:** el aviso de regreso, como la señal, muestra ahí solo «¿Quieres preparar un relevo esta semana?», sin la actividad.

## Fotografías

La 2.8 usa 21 fotografías (2,7 MB). Son provisionales: D-073 pide una sesión propia en hogares reales, con consentimiento.

- **15 a partir de 12 imágenes generadas con IA** para el proyecto entre las versiones 2.3 y 2.6 (tres de ellas en dos encuadres), las mismas que usaba la 2.7, conservadas en [`assets-explorados/fotos-app-hasta-2.7`](assets-explorados/fotos-app-hasta-2.7). Se procesaron con la receta de imagen de D-073 ([`receta-imagen.py`](../../10_recursos_visuales/marca-desde-cero/receta-imagen.py), reproducida en C#): encuadre 4:5 a 720 px o 3:2 a 1080 px, saturación −16 %, sombras levantadas y frías, altas luces tibias, grano de 2 % y JPEG de calidad 86.
- **6 con licencia CC0** obtenidas mediante Openverse para el estudio de marca, ya tratadas con esa receta: libro, escribir, aprender, guitarra, pan y pintar. Autores y enlaces en el [registro de licencias](licencias/README.md). Muestran manos y objetos, sin rostros.

El APK pasó de 90,6 MB en 2.7 a 34,5 MB: las fotos pasaron de PNG a JPEG y se retiraron el desenfoque de Haze y los iconos de Material.

## Verificación

| Comprobación | Resultado |
| --- | --- |
| Compilación y 47 pruebas unitarias (34 de 2.7 y 13 nuevas: ruta, oferta del siguiente paso, regla semanal del aviso de regreso y uso sin participar). | Aprobadas. |
| Actualización sobre una instalación con datos de 2.7. | La app abrió P1–P3 sin pedir de nuevo el consentimiento y después Inicio, Ruta y Perfil. |
| Primera vez: A1, A2 con «No participar», A3. | Recorrido completo. Sin participar, la base local quedó con 0 registros de investigación y sin datos de sesión remota. |
| Ciclo completo participando: preparar desde un paso de la ruta, prueba de 15 s con Chrome, señal en el teléfono y respuesta. | Supabase recibió la sesión y sus 4 eventos. Después se borraron. |
| R3: tres respuestas «Comencé» en el mismo paso. | Apareció la oferta; «Probar el siguiente paso» avanzó la ruta. |
| Tema oscuro, S2, «Tu semana», Tus relevos por día, editor de actividades con foto sugerida, descarga del JSON y gesto de volver. | Funcionaron; el archivo exportado se borró después. |
| V2: aviso activado, ocho días sin abrir la app simulados en los ajustes y reloj del emulador adelantado 31 horas. | La alarma diaria disparó una notificación silenciosa en el canal «Aviso de regreso». «Ahora no» la quitó y la contó; «Preparar» abrió la preparación. Se corrigieron dos fallas: sin un relevo anterior, «Preparar» solo abría Inicio, y los avisos usaban un icono genérico de Android. Después se restauraron reloj y ajustes. |

Durante una sesión, el emulador se saturó (CPU al 95 % y el sistema dejó de responder). Tras reiniciarlo con más memoria no se repitió. No se pudo atribuir a la app; conviene vigilarlo en el teléfono real.

La base remota conserva 6 sesiones y 4 eventos del 22 al 25 de septiembre, anteriores a esta versión, y ninguna respuesta. Las sesiones de prueba de 2.8 se borraron.

## Pendiente

- **Decisión del autor:** usar 2.8 o 2.7 en la prueba de 21 días. Si se usa 2.8, perfil, ruta y avisos deben quedar iguales las tres semanas, y D-073 sigue siendo una propuesta hasta que el autor la apruebe.
- **Textos** de P1–P3, R3, V2, S2, la opinión y el reporte: revisión del autor.
- **Consentimiento:** dice que el código de participación aparece en «Relevos»; en 2.8 está en Perfil → Privacidad y datos y en Prueba de 21 días. Decidir si la opinión, el reporte y su registro técnico deben nombrarse aparte o bastan «las respuestas que decida dar».
- **En el teléfono real:** la alarma de V2 con el gestor de batería del fabricante, texto grande en todas las pantallas y TalkBack.
- **No comprobado en el emulador:** la pregunta para apagar el aviso tras dos «Ahora no» seguidos y la versión genérica del aviso en la pantalla de bloqueo, añadida después de la prueba de V2.
- **Sin implementar:** el caso de V1 «Tu relevo anterior terminó sin sonar».
- **Fotografía propia** que reemplace las 21 provisionales.
- Lo pendiente de 2.7 sigue igual: parlante Bluetooth, borrado sin conexión y caducidad de la sesión anónima.

## Registro de cambios (disclaimer)

### 2026-09-27 — Remisión a 2.9

- **Qué cambió:** se añadió una nota que remite a la 2.9.
- **Cómo estaba antes:** no se indicaba que existía una versión posterior.
- **Por qué:** que quien lea la 2.8 sepa qué cambió después.

### 2026-09-26 — Documento nuevo

- **Qué se añadió:** qué pidió el autor, cómo se aplica D-073, las pantallas frente al diseño escrito, interacciones, personalización, datos nuevos, procedencia de las fotos, verificación y pendientes de la versión 2.8.
- **Cómo estaba antes:** la 2.8 existía solo como un commit «en curso», sin fotos ni documentación.
- **Por qué:** dejar trazable qué se cambió a pedido del autor, qué se comprobó y qué debe decidir antes de la prueba.
