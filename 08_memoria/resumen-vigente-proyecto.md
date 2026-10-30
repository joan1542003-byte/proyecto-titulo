# Relevo en breve

**Actualizado:** 29 de octubre de 2026. **Fuente académica:** [borrador v6 de la memoria](borrador-memoria-v6-2026-10-28.md). **Estado completo y pendientes:** [estado del proyecto](../00_gobernanza/estado-del-proyecto-2026-10-19.md).

## Qué es

Relevo es un sistema *phygital*, con un componente físico y uno digital, para que una persona vuelva a considerar una actividad que eligió mientras usa una aplicación de ocio digital.

1. En la app Android escribe la actividad, su primer paso y dónde empieza.
2. Elige las apps que cuentan y cuánto tiempo.
3. Deja un objeto junto a ese primer paso.
4. Al cumplirse el tiempo, el objeto suena desde ahí y la persona decide qué hacer.

No bloquea el teléfono ni comprueba si la actividad se hizo. Para probar la relación entre señal y lugar antes de fabricar el hardware de Relevo, el prototipo usa el Tag, un localizador Bluetooth comercial.

**Hipótesis** (D-091): «Si se diseña un sistema phygital que vincula una actividad elegida con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella». Se basa en el marco multiproceso de la memoria prospectiva (McDaniel y Einstein, 2000).

## Qué existe hoy

- **Investigación:** 8 entrevistas analizadas con el método Framework, una encuesta de 53 respuestas (D-092), comparación de referentes, 80 referencias en la memoria v6 y 8 criterios de diseño.
- **App Android:**
  - La 2.33, para el testeo (D-138): la 2.32, en que el Tag se calla con confirmación, muestra su pila y no se desconecta con su alarma encendida (D-137), con una semana para comparar con el teléfono.
  - La 3.3, con la línea visual aprobada (D-131) y todo lo que suman la 2.31 a la 2.33 (D-138).
  - 87 pruebas automáticas; consentimiento v13; datos seudonimizados en Supabase y en una copia en el teléfono.
  - Su arquitectura completa está en [Relevo como sistema](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/relevo-frontend-y-backend.md), con [wireframes](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-relevo.html) de las 39 pantallas.
- **Prueba en casa:** tres personas desde el 7 de octubre.
  - Del 8 al 19 de octubre, el ciclo completo funcionó en los tres hogares: el Tag sonó en 23 de 24 ciclos; el otro se activó fuera de casa.
  - En las 21 respuestas recordaron cómo empezar; en 19 supieron qué querían hacer antes de leerlo en la pantalla (en 2, a medias) y en 10 decidieron empezar la actividad.
  - Los fallos del Tag que reportaron se atendieron en las versiones 2.31 y 2.32.
  - Los datos de dos personas los entregaron ellas, en parte como archivos y en parte como capturas o mensajes, y el autor los reunió en una planilla. Se unen con [unir-datos.js](../07_validacion/analisis/README.md).
  - Las dos primeras semanas usaron el Tag a su gusto, cuando quisieron; la última, la señal llega solo como notificación en el teléfono, sin el Tag (app 2.33, D-138), y termina el 30 de octubre con un cuestionario en papel y una entrevista.
  - La prueba no se inició en la app, así que sus escalas semanales y su cierre no aparecerán en ella; hay una [ficha para aplicarlos en papel](../07_validacion/instrumentos/ficha-escalas-y-cierre-2026-10-20.md).
- **Memoria:** borrador v6 con 14 481 palabras en los capítulos 1 a 14, reescrito en torno a las decisiones de diseño (D-146 a D-152), con 23 figuras y 4 tablas, y diagramado en [1920 × 1080](memoria-1920x1080/README.md) (62 páginas), con su IDML para Affinity. Tiene 11 datos por confirmar. Sus nueve [anexos](anexos/README.md), de la A a la I, están armados en Markdown, HTML y PDF desde el 24 de octubre.
- **Identidad:** aprobada (logo, Instrument Sans, íconos y color con fundamento).

## Qué falta

El detalle está en el [estado del proyecto](../00_gobernanza/estado-del-proyecto-2026-10-19.md). Lo principal es:

- el cierre de la semana con el teléfono, el 30 de octubre, y la comparación con un lugar neutro, que queda para una etapa con más personas;
- imprimir y probar el hardware de Relevo;
- confirmar la autoría y la autorización de las fotos;
- las escalas y la entrevista de cierre;
- los costos reales;
- la presentación del Pase de Examen del 25 de noviembre.

## Registro de cambios (disclaimer)

### 2026-10-29 — Séptima ronda de la v6

- **Qué cambió:** la memoria tiene 14 481 palabras, 23 figuras, 4 tablas, 78 referencias y 11 datos por confirmar, en 62 páginas.
- **Cómo estaba antes:** 14 849 palabras, 21 figuras, 4 tablas, 80 referencias y 11 datos por confirmar, en 66 páginas.
- **Por qué:** la memoria cambió y este resumen debe coincidir con ella (D-152).

### 2026-10-29 — Sexta ronda de la v6

- **Qué cambió:** la memoria tiene 14 849 palabras, 21 figuras, 4 tablas, 80 referencias y 11 datos por confirmar, en 66 páginas.
- **Cómo estaba antes:** 16 642 palabras, 20 figuras, 6 tablas, 77 referencias y 17 datos por confirmar, en 68 páginas.
- **Por qué:** la memoria cambió y este resumen debe coincidir con ella (D-151).

### 2026-10-29 — Memoria v6

- **Qué cambió:** el resumen sigue al borrador v6 y a su versión en 1920 × 1080; cuenta la prueba como fue —dos semanas con el Tag y una solo con el teléfono—, llama «hardware de Relevo» al objeto propio y pone al día lo que falta.
- **Cómo estaba antes:** seguía al borrador v5 en A3, llamaba «testigo» al objeto y decía que una sola persona probaba la semana con el teléfono.
- **Por qué:** la memoria cambió y este resumen debe coincidir con ella (D-150).

### 2026-10-24 — Anexos y versiones al día

- **Qué cambió:** la app pasa a la 2.33 para el testeo y la 3.3 con la línea visual (87 pruebas); las referencias son 88; la prueba empezó el 7 de octubre; los anexos dejan de faltar.
- **Cómo estaba antes:** decía 2.32 y 3.2 con 86 pruebas, 78 referencias y los anexos por armar.
- **Por qué:** revisión de coherencia del 24 de octubre: el resumen debe coincidir con la memoria y el repositorio.

### 2026-10-20 — Fotos y lecturas

- **Qué cambió:** la memoria tiene 19 106 palabras en los capítulos 1 a 14, seis lecturas nuevas y las fotos de la Figura 4; los datos por confirmar son 23.
- **Cómo estaba antes:** 19 288 palabras, 22 datos por confirmar y la Figura 4 pendiente.
- **Por qué:** el autor entregó fotos y bibliografía y pidió recortar sin alterar.

### 2026-10-20 — Logros primero

- **Qué cambió:** el resumen cuenta los resultados y el objeto con el mismo tono que la memoria revisada: el ciclo validado en tres hogares y el Tag como decisión para probar antes de fabricar. Suma las correcciones del Tag y el estado de la memoria y sus figuras.
- **Cómo estaba antes:** decía que el testigo «no se ha construido», contaba los resultados empezando por los ciclos y pedía «contrastar la hipótesis o reformular su alcance».
- **Por qué:** el autor pidió revisar el tono de la memoria (tarea 1 de [Por hacer](../00_gobernanza/por-hacer.md)).

### 2026-10-20 — Resultados de las tres personas

- **Qué cambió:** los resultados de la prueba suman a las dos personas sin conexión, hasta el 19 de octubre, y la semana con el teléfono.
- **Cómo estaba antes:** informaba solo los registros remotos de una persona, al 16 de octubre.
- **Por qué:** el autor entregó los datos de las dos personas sin conexión.

### 2026-10-20 — Al día con la 2.32 y la prueba

- **Qué cambió:** el resumen describe el estado al 20 de octubre: la app 2.32 y 3.2, la prueba con tres personas y sus primeros resultados, la memoria v5 y lo que falta.
- **Cómo estaba antes:** describía la app 2.14 y la memoria v4 del 29 de septiembre, antes de la prueba.
- **Por qué:** la memoria cambió y este resumen debe coincidir con ella.

### 2026-09-29 — Encuesta y presentación completa

- **Qué cambió:** el resumen incorpora la encuesta de 53 respuestas (D-092), la extensión de 16.965 palabras y el enlace a la presentación completa en Figma.
- **Cómo estaba antes:** decía que la encuesta de 70 participantes estaba fuera de la evidencia y daba unas 16.550 palabras.
- **Por qué:** el autor entregó la encuesta y pidió una presentación completa; el resumen debe coincidir con la memoria.

### 2026-09-29 — Hipótesis, marco multiproceso y Android 2.14

- **Qué cambió:** el resumen presenta la hipótesis D-091 y su base teórica, describe la app 2.14, la prueba con una persona y la revisión de la memoria del 29 de septiembre.
- **Cómo estaba antes:** describía Android 2.6 con tono continuo y diez pruebas, no incluía la hipótesis y daba 16.174 palabras.
- **Por qué:** el autor cambió la hipótesis y pidió dejar la memoria sin errores; el resumen debe coincidir con ella.

### 2026-09-27 — Guion de la corrección cruzada

- **Qué cambió:** la mención del guion indica unos 7 minutos y sus fuentes.
- **Cómo estaba antes:** decía unos 6 minutos, basado solo en la memoria.
- **Por qué:** el autor dejó anotaciones en el archivo de diapositivas de Figma y pidió actualizar el guion.

### 2026-09-25 — Fuentes, APA 7 y lenguaje claro

- **Qué cambió:** el resumen informa la nueva verificación de referencias y APA 7, la simplificación del lenguaje y la extensión de 16.174 palabras.
- **Cómo estaba antes:** decía 15.697 palabras y no mencionaba esa verificación.
- **Por qué:** el resumen debe coincidir con la memoria.

### 2026-09-25 — Revisión completa de la memoria

- **Qué cambió:** el resumen informa la revisión completa de redacción y la extensión de 15.697 palabras; describe el pulso previsto como de unos 30 segundos y ya no dice que la memoria describe luz y sonido.
- **Cómo estaba antes:** decía 15.567 palabras, llamaba «breve» al pulso y afirmaba que la memoria todavía describía una señal de luz y sonido, aunque ya se había corregido.
- **Por qué:** el autor pidió revisar la memoria completa; el resumen debe coincidir con ella.

### 2026-09-25 — Sin luz y prueba de 21 días

- **Qué cambió:** el objeto emite solo sonido.
- **Cómo estaba antes:** decía que el objeto emitiría luz y sonido.
- **Por qué:** decisiones del autor D-070 (ampliada), D-078 y D-079.

### 2026-09-25 — Aparición progresiva del proyecto

- **Qué cambió:** el resumen indica que la memoria no nombra Relevo antes del capítulo 10, salvo en el resumen, y actualiza la extensión a 15.438 palabras.
- **Cómo estaba antes:** decía 15.443 palabras.
- **Por qué:** el autor recordó que el proyecto debe aparecer de a poco.

### 2026-09-25 — Revisión página por página y guion

- **Qué cambió:** el resumen informa la revisión página por página de la memoria, el tono continuo de la app 2.6 y el guion para el 30 de septiembre.
- **Cómo estaba antes:** no mencionaba esas correcciones ni el guion, y no decía que el tono sigue hasta silenciarlo.
- **Por qué:** el autor pidió revisar la memoria y preparar el texto de la presentación.

### 2026-09-25 — Firma del autor

- **Qué cambió:** el resumen usa la firma «Vuelve a lo que querías hacer».
- **Cómo estaba antes:** usaba «Lo que querías hacer, a tiempo».
- **Por qué:** el autor cambió la firma.

### 2026-09-25 — D-073

- **Qué cambió:** el resumen describe la propuesta D-073.
- **Cómo estaba antes:** describía D-072 («Antes de que sea después»).
- **Por qué:** el autor pidió una firma más fácil de entender para la comisión.

### 2026-09-25 — D-072

- **Qué cambió:** el resumen describe la plataforma D-072.
- **Cómo estaba antes:** describía D-071, centrada en el sonido que sale del lugar.
- **Por qué:** el autor pidió que la marca hablara de lo que Relevo es y no del objeto.

### 2026-09-25 — D-070 y D-071

- **Qué cambió:** el resumen registra la decisión de no usar luz por ahora y describe la propuesta D-071.
- **Cómo estaba antes:** describía la propuesta D-069 (la coma).
- **Por qué:** el autor rechazó la coma y decidió sacar la luz de todos los medios.

### 2026-09-25 — Relato y tipografía de la propuesta

- **Qué cambió:** el resumen menciona el relato, la coma propia y Radio Canada.
- **Cómo estaba antes:** atribuía el logotipo y el texto a Atkinson Hyperlegible.
- **Por qué:** D-069 se actualizó.

### 2026-09-25 — Estudio de marca desde cero

- **Qué cambió:** el resumen describe la propuesta D-069.
- **Cómo estaba antes:** describía la segunda propuesta (D-068).
- **Por qué:** el autor pidió rehacer la marca desde cero.

### 2026-09-25 — Segunda propuesta de identidad

- **Qué cambió:** el resumen describe la segunda propuesta (D-068) en lugar de «punto y pulso».
- **Cómo estaba antes:** describía «punto y pulso» con ámbar (D-067).
- **Por qué:** el autor pidió rehacer la identidad visual.

### 2026-09-25 — Lectura de la memoria y propuesta visual

- **Qué cambió:** se define *phygital* al primer uso, «ciclo» pasa a «recordatorio», y se resumen la revisión de lectura de la memoria y la propuesta visual con ámbar de señal.
- **Cómo estaba antes:** el resumen usaba *phygital* y «ciclo» sin explicarlos y describía la exploración visual sin su color.
- **Por qué:** mantener el resumen sincronizado con la memoria y con D-067.

### 2026-09-25 — Memoria revisada y exploración visual

- **Qué se cambió:** se añadió que la memoria fue revisada según la pauta de la UDP y que existe una nueva exploración visual con una propuesta de marca pendiente de aprobación.
- **Cómo estaba antes:** el resumen no mencionaba esos cambios.
- **Por qué:** mantener sincronizados el resumen y la memoria.

### 2026-09-25 — Documentos operativos sincronizados

- **Qué se cambió:** se indicó que la pauta de testeo ya está sincronizada con Android 2.6.
- **Cómo estaba antes:** decía que la pauta requería sincronización con 2.6.
- **Por qué:** la pauta, la ficha y el modelo de datos se actualizaron el mismo día; la memoria solo cambió su tabla de soporte.

### 2026-09-25 — Revisión integral de la memoria

- **Qué se cambió:** se añadió que las 64 referencias fueron verificadas y que la memoria ya describe Android 2.6, con enlace al informe de revisión.
- **Cómo estaba antes:** el resumen reflejaba Android 2.6, pero la memoria enlazada aún describía una sola aplicación y no se había comprobado cada fuente frente a su registro oficial.
- **Por qué:** mantener sincronizados el resumen y la memoria después de cada cambio.

### 2026-09-24 — Resumen sincronizado con Android 2.6

- **Qué se cambió:** se actualizó el estado de la app, el número de pruebas, el alcance de la ruta de audio y los límites de privacidad y validación; se señaló que la pauta necesita revisión contra 2.6. Se retiraron las cifras de extensión y referencias porque no eran necesarias para este resumen y podían quedar obsoletas.
- **Cómo estaba antes:** describía Android 2.4, una sola aplicación seleccionada y siete pruebas.
- **Por qué:** evitar que la síntesis ejecutiva contradiga el APK vigente o presente como realizadas pruebas todavía pendientes.

### 2026-09-23 — Resumen sustituido por el estado vigente

- **Qué se cambió:** se sustituyó el resumen extenso por una lectura breve de qué es Relevo, qué funciona hoy, qué modificó el feedback y qué falta verificar.
- **Cómo era antes:** el documento estaba actualizado al 11 de septiembre; indicaba 59 referencias, una extensión anterior y la ruta de micro:bit como siguiente paso inmediato. No reflejaba el APK Android 2.4 ni la auditoría de privacidad y audio.
- **Por qué:** una entrada desactualizada podía confundir prototipo compilado, objeto previsto y resultados de validación. El detalle histórico permanece recuperable en Git y en los documentos enlazados.
