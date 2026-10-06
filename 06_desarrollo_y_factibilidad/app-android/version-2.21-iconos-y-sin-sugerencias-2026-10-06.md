# Android 2.21: iconos con degradado y nada elegido por la persona de antemano

**Fecha:** 6 de octubre de 2026. **Decisión:** D-111. **Estado:** compilada desde cero, con 84 pruebas unitarias aprobadas y revisada en el emulador como persona nueva, de la bienvenida a «¿Cómo te avisa?» y a Inicio. No se ha probado en un teléfono real. El consentimiento sigue en v12.

## Qué pidió el autor

- Que ninguna salida venga marcada por defecto y que se corrija lo pendiente de la 2.20.
- Que cada actividad se muestre con un icono sobre un degradado sutil, sin foto.
- Que la app sea fácil de usar y de entender, que no choque con lo que dice la memoria y que no tenga patrones oscuros.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Imágenes | Las actividades, la ruta, las ideas, los intereses y las pantallas de bienvenida muestran el icono de la actividad en tinta sobre un degradado diagonal sutil del color de su familia: menta para moverse, celeste para leer y estudiar, lila para crear, rosa para la música, naranja para la casa y la cocina, y sol para lo demás (claros de D-104). El degradado va del papel al tinte, sin brillos ni texto encima. Las fotos quedan en los recursos como antecedente, pero ya no se muestran. |
| Dónde suena | En un relevo nuevo no hay salida marcada. «Seguir» y «Activar el relevo» piden elegir una («Elige dónde quieres que suene»). Al repetir un relevo se conserva la elección de ese relevo, porque es de la persona. |
| Dónde dejar el objeto | Hasta que la persona elige, el texto no se inclina por ninguna opción: «Las dos opciones sirven. Elige lo que de verdad vas a hacer.». |
| Textos de «¿Cómo te avisa?» | «Elige una. Después puedes probar cómo suena.» y la nota: «No hay una respuesta correcta: elige lo que te acomode. Lo puedes cambiar en cada relevo.». |
| Primer relevo | La imagen de arriba baja de 300 a 200 dp, así que la lista de seis pasos ya no queda bajo los botones. |
| Consentimiento | Suma «No quiero participar», que explica sin culpa que la app solo se usa en la prueba y que no se guardó nada. Decir que no está a la vista, igual que decir que sí. |
| Aviso semanal | «Sí, avísame» y «No, gracias» tienen el mismo peso visual: ninguna respuesta viene sugerida. |

## Revisión de patrones oscuros

Se revisaron las pantallas de la primera vez, la preparación y la señal con las categorías habituales: opciones marcadas de antemano, botones que favorecen una respuesta, culpa al decir que no, urgencia falsa y salidas escondidas.

- **Corregido en esta versión:** la salida marcada por defecto, el texto que favorecía dejar el objeto donde empieza, el aviso semanal con «Sí» destacado y el consentimiento sin forma de decir que no.
- **Lo que ya cumplía:** desactivar y eliminar un relevo están a la vista. Las preguntas después de la señal se pueden saltar y dicen que ninguna respuesta es mejor que otra. Los permisos explican para qué son. La activación automática es opcional y se apaga desde Inicio.
- **Lo que queda por decidir:** participar sigue siendo obligatorio para usar la app (D-084). No es un patrón oscuro, porque se dice claramente y ahora hay un «No quiero participar» visible, pero el profesor debe confirmar que encaja con un consentimiento voluntario.

## Coherencia con la memoria

| Dice la memoria | Qué hace la app | Estado |
| --- | --- | --- |
| Un objeto situado junto al primer paso (secciones 12 y 13) | Ofrece dejarlo donde empieza o en otro lugar, y registra lo que elige la persona | La app explora la hipótesis en vez de imponerla. La memoria debe decir que la ubicación la elige la persona (D-110). |
| Objetivo específico 3: comparar la señal junto al primer paso, en un lugar neutro y en el teléfono | Registra A, B y C según lo que elige la persona | Pasa de una comparación controlada a una observación de lo que elige. Hay que reescribir el objetivo y la sección de evaluación. |
| Fotografías que muestran el comienzo (sistema de marca D-073) | Icono con degradado | Cambio visual pedido por el autor. Si la memoria describe las fotos de la app, hay que actualizarla. |
| Decisión abierta, sin obligación ni juicio | Sin opciones marcadas, respuestas que se pueden saltar y texto neutro | Coherente. |

Estos cambios en la memoria no se hicieron: requieren la decisión del autor y revisar los límites de palabras.

**APK:** [relevo-android-2.21-2026-10-06.apk](releases/relevo-android-2.21-2026-10-06.apk), SHA-256 `54AB33F5B52F1D18ED35F930E9813FD381E73658C07AEBFD5167BDD7601B2D16` (41,3 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-06 — Creación

- **Qué se añadió:** la versión 2.21, con iconos sobre degradado, ninguna salida marcada de antemano, textos neutros, el primer relevo sin superposición, «No quiero participar», el aviso semanal con opciones del mismo peso, la revisión de patrones oscuros y la tabla de coherencia con la memoria.
- **Cómo estaba antes:** la 2.20 mostraba fotos, marcaba el parlante por defecto y destacaba «Sí» en el aviso semanal.
- **Por qué:** pedido del autor del 6 de octubre (D-111).
