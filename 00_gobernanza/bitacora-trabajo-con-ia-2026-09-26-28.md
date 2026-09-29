# Bitácora del trabajo con IA: 26 al 28 de septiembre de 2026

**Estado:** registro de lo hecho con Claude Code entre el 26 y el 28 de septiembre de 2026, a pedido del autor. Reúne en un solo lugar qué se pidió, qué se hizo, qué se decidió, cómo se usó la IA, qué se comprobó y qué falta. No reemplaza los documentos de cada trabajo; los enlaza.

**Rama:** todo está en `android-2.7` y subido a GitHub (último commit `6be9b37`). No se fusionó con `main`.

## 1. Qué se hizo

| Fecha | Pedido del autor | Resultado | Commit | Decisión |
| --- | --- | --- | --- | --- |
| 26–27 sep. | Llevar la app al estilo de iOS 26: vidrio sin brillo, pantalla completa, bordes redondeados, emoji y textos naturales. | [Android 2.9](../06_desarrollo_y_factibilidad/app-android/version-2.9-vidrio-y-emoji-2026-09-27.md) | `e6d6e96` | D-083 |
| 27 sep. | Textos más claros, nunca mayúsculas sostenidas, participación obligatoria en la prueba, menos desenfoque, texto según el tono de la foto, más emoji, «Tu ruta» y «Tus actividades» más claras. | [Android 2.10](../06_desarrollo_y_factibilidad/app-android/version-2.10-participacion-y-claridad-2026-09-27.md) | `27d2923` | D-084 |
| 27 sep. | Desarrollar la marca en Figma acorde a la app nueva, con vidrio líquido, iconos, emoji y tratamiento de imagen. | [Sistema de marca 2.0](../10_recursos_visuales/22_sistema-de-marca-2.0-figma-2026-09-27.md), con [vistas](../10_recursos_visuales/marca-2.0/README.md) | `cfa4179` | D-085 (propuesta) |
| 27 sep. | Leer las anotaciones que dejó en las diapositivas de Figma y actualizar el texto de la presentación. | [Guion de la corrección cruzada, versión 2](guion-presentacion-correccion-cruzada-2026-09-30.md) | `8cc73d9` | — |
| 27 sep. | Grabar un GIF de la app funcionando. | [GIF de la app 2.10](../06_desarrollo_y_factibilidad/app-android/capturas/como-funciona-2.10/README.md) | `9794456` | — |
| 28 sep. | Revisar la app y dejarla lista para el primer testeo real: explicar su uso la primera vez, incluir el video en vertical y guardar todo en la base de datos y en el teléfono. | [Android 2.11](../06_desarrollo_y_factibilidad/app-android/version-2.11-primer-testeo-2026-09-28.md) | «Android 2.11: primer testeo» | D-086 |
| 28–29 sep. | App más simple, que no se sienta como un testeo, con más datos, notificaciones y modo claro por defecto, código simple y actividades para generar imágenes. | [Android 2.12](../06_desarrollo_y_factibilidad/app-android/version-2.12-mas-simple-y-mas-datos-2026-09-29.md) y [actividades](../10_recursos_visuales/23_actividades-e-imagenes-2026-09-29.md) | «Android 2.12: más simple y más datos» | D-087 |
| 28 sep. | Un video de animación de 15 segundos que muestre qué es Relevo, en español; después, alargarlo a 30 segundos sin textos que no aporten. | [Relevo en 30 segundos](../10_recursos_visuales/marca-2.0/video/README.md) | `7a052ef` y `6be9b37` | — |

## 2. Decisiones

- **D-083 y D-084** son decisiones del autor, ya implementadas en la app y sin probar con personas. Las elecciones de detalle (qué emoji, el umbral de tono de 0,19, los textos nuevos) las propuso la herramienta y están pendientes de revisión.
- **D-085**, el sistema de marca 2.0, es una propuesta: el autor pidió el trabajo, pero no ha aprobado el resultado como manual vigente. Reúne D-073 con los cambios de D-083 y D-084.
- **El guion, el GIF y el video** no crean decisiones nuevas: aplican decisiones vigentes a piezas de presentación. En el guion se corrigieron dos datos vencidos: la prueba es por ahora con una persona (D-081) y la app vigente es la 2.10.
- **D-086** (Android 2.11) es decisión del autor: explicar la app la primera vez y guardar los datos en Supabase y en el teléfono. El texto de los pasos, el formato de la copia y las vistas de análisis los propuso la herramienta.
- **D-087** (Android 2.12) es decisión del autor: lenguaje sin «prueba», avisos encendidos, código corto, modo claro, más datos y opiniones con caras. Los textos, los usos registrados y las actividades sumadas los propuso la herramienta.
- **Queda sin decidir:**
  - qué versión de la app (2.7 a 2.10) se usa en la prueba de 21 días;
  - si el profesor guía confirma que exigir la participación es compatible con el consentimiento;
  - si D-085 se aprueba.

Detalle en el [registro de decisiones](../09_decisiones/registro-de-decisiones.md).

## 3. Cómo se usó la IA

Todas las tareas las hizo Claude Code, con el modelo Claude Opus 5.5, trabajando sobre el repositorio y con herramientas locales. El autor dio cada pedido, corrigió los resultados y eligió qué seguía.

| Trabajo | Qué hizo la herramienta | Qué aportó o decidió el autor | Herramientas |
| --- | --- | --- | --- |
| Android 2.9 y 2.10 | Programó el vidrio, las formas, el tono de las fotos, los textos y los emoji. Escribió pruebas unitarias y recorrió la app en el emulador sin red. Documentó cada versión. | Pidió el estilo y señaló los textos confusos, la tipografía que no le gustaba y el exceso de desenfoque. Valoró la interfaz de 2.9 antes de pedir los ajustes de 2.10. | Kotlin y Compose, Gradle, emulador Android y adb |
| Marca 2.0 | Creó el archivo de Figma con variables, estilos, 97 iconos, 18 componentes, las 155 imágenes subidas y las once páginas. Calculó el tono de cada foto y exportó vistas al repositorio. | Pidió el alcance: vidrio líquido, iconos, emoji e imagen. La aprobación está pendiente. | Conector oficial de Figma |
| Guion | Leyó las ocho anotaciones de Figma y la memoria, reescribió el guion, sumó el marco teórico y amplió las preguntas probables. | Revisó su presentación y anotó qué cambiar en cada diapositiva: el dato del problema, el orden, la comparación, los porqués, el GIF, el tono y la carta Gantt. | Conector de Figma para leer; edición del Markdown |
| GIF | Respaldó los datos del autor en el emulador, preparó un relevo ficticio sin red, lo grabó, lo montó y restauró los datos. | Pidió el GIF para la diapositiva «Cómo funciona». | Emulador, adb, grabación de pantalla de Android y ffmpeg |
| Video | Escribió el guion visual, animó la pieza en HTML, la renderizó cuadro a cuadro con Chrome y sintetizó la banda sonora; luego la alargó a 30 segundos. | Pidió el video, lo aprobó («está muy buena») y pidió alargarlo y quitar textos de relleno. | HTML y JavaScript, Chrome sin ventana, ffmpeg |

Los pedidos literales, las fuentes consultadas y lo que no se afirma de cada trabajo están en la [trazabilidad del uso de IA](trazabilidad-uso-ia-2026-09-23.md).

## 4. Qué se comprobó y qué no

- **App:** la 2.9 y la 2.10 compilan, pasan sus pruebas unitarias (50 y 58) y se recorrieron en el emulador con datos ficticios. No se probaron en un teléfono ni con un parlante reales, ni con personas. Tampoco se comprobó el arreglo del teclado.
- **Figma:** cada página se revisó con capturas y se corrigieron los errores encontrados. Las piezas con vidrio líquido nativo se ven casi planas en las capturas exportadas; hay que revisarlas en el editor.
- **Guion:** los enlaces del repositorio se revisaron (0 rotos). El guion no se ha ensayado.
- **GIF y video:** se revisaron cuadro a cuadro antes de entregarlos.
- **Android 2.11:** en emulador y con conexión se comprobó que sesiones, eventos y respuestas llegan a Supabase (las respuestas nunca habían llegado antes), que la copia en el teléfono se escribe con y sin conexión y que el borrado alcanza a ambas. Falta el teléfono y el parlante de la prueba.

## 5. Correcciones hechas en el camino

- **Origen de las imágenes:** en Figma se describieron primero las imágenes de la app como fotos de banco. En realidad, 15 de las 21 se generaron con IA. Se corrigió en cada página que las usa, y el video usa solo las 6 fotografías CC0.
- **Opacidades en Figma:** Figma no conservó en las instancias la opacidad de los colores enlazados a variables. Se crearon variables con transparencia propia, como en el código.
- **GIF compuesto:** para que la señal llegara pronto, el GIF une dos grabaciones: la preparación con 15 minutos y la señal de un relevo de prueba de 15 segundos. En el emulador el aviso suena en el teléfono porque no hay parlante. Ambas cosas se declaran en su documento.
- **Defecto de la app:** al grabar el GIF apareció por 0,2 segundos un encabezado vacío al responder «¿Qué decidiste?». Quedó registrado en los pendientes de Android 2.10.
- **Datos vencidos del guion:** decía seis personas y app 2.6; ahora dice una persona y app 2.10.

## 6. Privacidad y cuidado de los datos

- No se agregaron nombres, códigos de participación ni datos personales a las capturas, el GIF ni el video.
- Las grabaciones en el emulador se hicieron sin red, para que nada llegara a Supabase. Los datos que el autor tenía en el emulador se respaldaron antes y se restauraron después.
- La encuesta de 70 respuestas no se usó como evidencia, porque sus materiales no están documentados en el repositorio.

## 7. Pendientes

- **Decisiones del autor:** la versión de la app para la prueba, la aprobación de D-085 y la revisión de los textos nuevos de la app.
- **Ética:** que el profesor guía confirme la participación obligatoria.
- **Presentación del 30 de septiembre:**
  - pasar el guion y el GIF a las diapositivas de Figma, lo que requiere volver a autorizar el conector de Figma;
  - agregar datos de la encuesta, si el autor entrega el formulario y las respuestas;
  - ensayar.
- **Pruebas reales:** la app en el teléfono y el parlante de la prueba, el borrado sin conexión, TalkBack y texto grande, y el defecto visual al responder.

## Registro de cambios (disclaimer)

### 2026-09-29 — Android 2.12

- **Qué cambió:** se sumaron el pedido y el resultado de Android 2.12, la lista de actividades y D-087.
- **Cómo estaba antes:** la bitácora terminaba con Android 2.11.
- **Por qué:** registrar el trabajo pedido por el autor.

### 2026-09-28 — Android 2.11

- **Qué cambió:** se sumaron el pedido y el resultado de Android 2.11, D-086 y sus comprobaciones.
- **Cómo estaba antes:** la bitácora terminaba con el video de 30 segundos.
- **Por qué:** registrar el trabajo del mismo día pedido por el autor.

### 2026-09-28 — Creación

- **Qué se añadió:** una bitácora de los trabajos del 26 al 28 de septiembre, con pedidos, resultados, commits, decisiones, uso de la IA, comprobaciones, correcciones, privacidad y pendientes.
- **Cómo estaba antes:** cada trabajo tenía su documento, pero no había un resumen conjunto de estos tres días.
- **Por qué:** el autor pidió revisar y documentar todo lo hecho, incluidas las decisiones y el uso de la IA.
