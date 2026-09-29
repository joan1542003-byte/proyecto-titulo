# Registro de pedidos del autor a la IA

**Propósito:** dejar una auditoría de cómo el autor dirige el trabajo con IA en Relevo: qué pidió, de qué tipo fue cada pedido, qué se obtuvo y qué decidió. Cada fila resume un pedido y enlaza su resultado. Las citas textuales, cuando existen, están en la [trazabilidad del uso de IA](trazabilidad-uso-ia-2026-09-23.md); el resumen de los días 26 a 28 de septiembre está en la [bitácora](bitacora-trabajo-con-ia-2026-09-26-28.md).

**Herramienta:** Claude Code, con el modelo Claude Opus 5.5, salvo que se indique otra.

**Regla:** desde el 29 de septiembre de 2026, cada pedido, cambio u orden del autor se registra aquí el mismo día, antes de cerrar el trabajo.

## Tipos de pedido

- **Encargo:** producir algo nuevo (una versión de la app, un documento, una pieza visual).
- **Corrección:** cambiar algo ya hecho a partir de la revisión del autor.
- **Consulta:** pedir una opinión, una explicación o una orientación.
- **Decisión:** el autor elige entre opciones que la IA le presentó.

## Pedidos

| Fecha | Tipo | Pedido del autor | Resultado | Decisión |
| --- | --- | --- | --- | --- |
| 23 sep. | Encargo | Revisar el repositorio, desarrollar por escrito las anotaciones del día y tomar `proyecto-titulo` como única fuente de contexto. | [Síntesis de anotaciones](../02_investigacion/sintesis-anotaciones-2026-09-23.md), [ficha de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) y trazabilidad | — |
| 23 sep. | Encargo | Aplicar a la app el feedback docente del día: reconocer lo que la persona hace, sin rachas y sin generar culpa. | Android 2.5 | — |
| 25–26 sep. | Encargo y corrección | Quitar la opción de agendar una entrevista y elevar el diseño al nivel de las mejores apps, según las nuevas directrices del repositorio. Tras ver una primera versión, recuperar las fotografías, la personalización y las pantallas que faltaban, y cuidar interacciones y animaciones. | [Android 2.8](../06_desarrollo_y_factibilidad/app-android/version-2.8-rediseno-perfil-y-ruta-2026-09-26.md) | D-082 |
| 27 sep. | Encargo | Llevar la app al estilo de iOS 26: pantalla completa, transparencias y desenfoques sutiles sin brillo, bordes redondeados, emoji 3D de Google en el perfil, sin repetir avisos de privacidad y sin sobreexplicar. | [Android 2.9](../06_desarrollo_y_factibilidad/app-android/version-2.9-vidrio-y-emoji-2026-09-27.md) | D-083 |
| 27 sep. | Corrección | Aclarar los textos confusos, cambiar la tipografía de «Estás aquí», no usar mayúsculas sostenidas, hacer obligatoria la participación, reducir el desenfoque, adaptar el color del texto a cada foto, sumar emoji y hacer más claras «Tu ruta» y «Tus actividades». | [Android 2.10](../06_desarrollo_y_factibilidad/app-android/version-2.10-participacion-y-claridad-2026-09-27.md) | D-084 |
| 27 sep. | Encargo | Desarrollar en Figma el sistema de marca de la nueva app, con vidrio líquido, iconos, emoji y tratamiento de imagen. | [Sistema de marca 2.0](../10_recursos_visuales/22_sistema-de-marca-2.0-figma-2026-09-27.md) | D-085, pendiente de aprobación |
| 27 sep. | Encargo | Leer las anotaciones dejadas en cada diapositiva de Figma y actualizar el texto de la presentación del 30 de septiembre. | [Guion v2](guion-presentacion-correccion-cruzada-2026-09-30.md) | — |
| 27 sep. | Encargo | Grabar un GIF de la app en funcionamiento para la presentación. | [GIF de la app 2.10](../06_desarrollo_y_factibilidad/app-android/capturas/como-funciona-2.10/README.md) | — |
| 28 sep. | Encargo | Crear un video de animación de 15 segundos, en español, que explique qué es Relevo con calidad profesional. | [Video](../10_recursos_visuales/marca-2.0/video/README.md), versión de 15 s | — |
| 28 sep. | Corrección | Extender el video a 30 segundos y quitar los textos que no aportan, como «Proyecto de título». | Video de 30 s | — |
| 28 sep. | Encargo | Revisar todo lo hecho, subirlo a GitHub y documentar decisiones, uso de la IA y cambios. | [Bitácora del trabajo con IA](bitacora-trabajo-con-ia-2026-09-26-28.md) | — |
| 28 sep. | Consulta | Pedir una evaluación franca del estado del proyecto y de sus posibilidades de titulación. | Respuesta en la conversación: riesgos en la evidencia con personas, el objeto físico y el calendario | — |
| 28 sep. | Consulta | Preguntar cómo ampliar el testeo con un solo parlante y poco presupuesto, cuándo empezar, con cuántas personas, a quién reclutar y si tres personas bastan. | Orientación en la conversación: parlantes propios de los participantes, tres a seis personas con órdenes equilibrados y el perfil del usuario principal | D-081 sigue sin actualizar |
| 28 sep. | Encargo | Revisar la app y dejarla lista para el primer testeo: mantener el parlante y el teléfono, explicar su uso la primera vez, incluir el video en vertical y guardar todos los datos en la base y en el teléfono. | [Android 2.11](../06_desarrollo_y_factibilidad/app-android/version-2.11-primer-testeo-2026-09-28.md) | D-086 |
| 28 sep. | Corrección y encargo | Simplificar la app para que no se sienta un testeo, registrar la mayor cantidad de datos, facilitar las opiniones, encender las notificaciones, usar un código más simple y el modo claro por defecto. Proponer actividades para generar sus imágenes. | [Android 2.12](../06_desarrollo_y_factibilidad/app-android/version-2.12-mas-simple-y-mas-datos-2026-09-29.md) y [actividades](../10_recursos_visuales/23_actividades-e-imagenes-2026-09-29.md) | D-087 |
| 29 sep. | Corrección y encargo | Reemplazar los intereses amplios por actividades concretas de las entrevistas, guardar el nombre, crear una guía de cada parte, revisar el audio saturado, resumir el relevo activo en Inicio y contrastar todo con la memoria. | [Android 2.13](../06_desarrollo_y_factibilidad/app-android/version-2.13-guia-intereses-y-nombre-2026-09-29.md) y [coherencia con la memoria](../08_memoria/coherencia-app-con-la-memoria-2026-09-29.md) | D-088 |
| 29 sep. | Decisión | Guardar el nombre de cada participante, después de conocer por qué no se guardaba, y preguntar Sí o No por el aviso semanal. | Tabla aparte para el nombre; aviso semanal preguntado en la guía | D-089 y D-088 |
| 29 sep. | Corrección y encargo | Reescribir las frases poco naturales, agrandar el video, rehacer la guía con contexto para que acompañe también el primer relevo, dejar la app lista para el testeo real y registrar cada pedido a la IA. | [Android 2.14](../06_desarrollo_y_factibilidad/app-android/version-2.14-guia-y-primer-relevo-2026-09-29.md) y este registro | D-090 |
| 29 sep. | Consulta | Revisar el encargo escrito para diseñar en Figma las diapositivas de la corrección cruzada, antes de ejecutarlo. | Revisión en la conversación: los datos teóricos coinciden con la memoria; la diapositiva 10 describe la app 2.6 y la 11 una prueba con seis personas, lo que choca con D-081; el conector de Figma necesita volver a autorizarse | — |
| 29 sep. | Encargo | Diseñar en Figma las diapositivas de la corrección cruzada según el encargo, con dos variantes por diapositiva, conservando la 2, 3 y 4 y usando los datos más recientes. | 18 diapositivas nuevas en las secciones «Variantes A» y «Variantes B» de la presentación, con notas del orador; la 10 muestra la app 2.14 y la 11, la prueba con una persona (D-081) | — |
| 29 sep. | Corrección | Rehacer las diapositivas con el estilo de diseño del autor, usar la hipótesis literal de la memoria y ordenar mejor la información, con textos más claros y concisos y sin elementos innecesarios. | Las 18 diapositivas rehechas con fondo blanco, Inter y el subrayado azul del autor; pregunta, hipótesis y objetivo general copiados de la memoria v4; se quitaron ilustraciones, tarjetas y pies sobrantes | — |
| 29 sep. | Consulta y encargo | Replantear la hipótesis, porque es compleja y difícil de entender: debe expresar aquello en que se basa la app, no su resultado. Estudiar la documentación, proponer opciones y, una vez elegida, actualizarla en todo el proyecto. | Tres opciones de hipótesis fundamentadas en el marco teórico y comprobables con el protocolo 02 | — |
| 29 sep. | Decisión | Adoptar la hipótesis de dos frases: la premisa (no se recuerda a tiempo) y lo que se pone a prueba (un aviso en el lugar donde empieza la actividad), y actualizarla en todo el proyecto. | Hipótesis cambiada en la memoria, el protocolo 02, los flujos, la guía de comunicación, el guion y las diapositivas 8A y 8B | D-091 |
| 29 sep. | Corrección | Señalar que la versión adoptada no es una hipótesis y pedir que se revisen las anteriores del proyecto. | Revisión de las hipótesis anteriores, todas con forma «si…, entonces…», y tres formulaciones nuevas con esa forma | — |
| 29 sep. | Decisión | Adoptar la hipótesis «Si durante una sesión en el teléfono suena una señal junto al primer paso…, entonces recordará esa actividad a tiempo para decidir si empezarla, mejor que con una notificación en el teléfono». | Hipótesis reemplazada en la memoria, el protocolo 02, los flujos, la guía de comunicación, el guion y las diapositivas 8A y 8B | D-091, corregida |

## Lo que muestra el registro

- **Cómo dirige el autor:** la mayoría de los pedidos corrigen algo ya hecho a partir de su propia revisión de la app o de las piezas. La IA propone y ejecuta; el autor revisa, corrige el rumbo y decide.
- **Decisiones que tomó el autor tras conocer alternativas:** guardar el nombre (D-089) y preguntar por el aviso semanal en vez de encenderlo (D-088).
- **Contradicciones que la IA señaló antes de actuar:** el nombre en la base y el aviso semanal encendido, ambos frente a la memoria.

Los pedidos anteriores al 23 de septiembre están en el «Registro de prompts existentes» de la [trazabilidad](trazabilidad-uso-ia-2026-09-23.md).

## Registro de cambios (disclaimer)

### 2026-09-29 — Hipótesis

- **Qué cambió:** se registraron el pedido de una hipótesis más simple, la primera elección del autor, su corrección porque no tenía forma de hipótesis y la elección final (D-091).
- **Cómo estaba antes:** el registro terminaba en la corrección de las diapositivas.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Corrección de las diapositivas

- **Qué cambió:** se registró la corrección de estilo y contenido de las diapositivas en Figma.
- **Cómo estaba antes:** el registro terminaba en el encargo de las diapositivas.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Encargo de diapositivas

- **Qué cambió:** se registró la revisión del encargo de diapositivas para Figma.
- **Cómo estaba antes:** el registro terminaba en Android 2.14.
- **Por qué:** regla de registrar cada pedido del autor el mismo día.

### 2026-09-29 — Creación

- **Qué se añadió:** un registro cronológico de los pedidos del autor a la IA desde el 23 de septiembre, con su tipo, su resultado y la decisión asociada, y la regla de registrar cada pedido nuevo.
- **Cómo estaba antes:** los pedidos estaban repartidos entre la trazabilidad, la bitácora y los documentos de cada versión.
- **Por qué:** el autor pidió una auditoría de cómo usa la IA en el proyecto.
