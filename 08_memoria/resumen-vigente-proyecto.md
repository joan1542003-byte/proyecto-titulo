# Relevo en breve

**Actualizado:** 29 de septiembre de 2026. **Fuente académica:** [memoria vigente](memoria-vigente-v4.md).

## Qué es

Relevo es un sistema *phygital* —con un componente físico y uno digital que cumplen funciones relacionadas— para que una persona vuelva a considerar una actividad que eligió mientras usa una aplicación de ocio digital. Prepara en Android la actividad, una forma concreta de empezarla y la condición para recibir un aviso. La propuesta final contempla un objeto situado cerca de esa actividad que emite una señal sonora de unos 30 segundos; la luz se descartó por tiempo (D-070). La señal ofrece una ocasión de decidir; no bloquea el teléfono ni comprueba que la actividad se realizó.

**Hipótesis** (D-091): «Si se diseña un sistema phygital que vincula una actividad elegida con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella». Se basa en el marco multiproceso de la memoria prospectiva: cuando una actividad absorbe la atención, recordar lo que se quería hacer depende de que la señal sea llamativa y esté fuertemente asociada a la acción (McDaniel y Einstein, 2000).

## Qué existe hoy

La [aplicación Android 2.14](../06_desarrollo_y_factibilidad/app-android/README.md) guía a la persona la primera vez, prepara un recordatorio, suma el uso de varias aplicaciones seleccionadas hasta un solo límite y, al cumplirlo, hace sonar durante unos 30 segundos un tono en un parlante Bluetooth multimedia o en el teléfono, que luego se detiene solo. Tras cada aviso hace preguntas de un toque. Guarda los registros en el teléfono y, con consentimiento, en Supabase con un código; el nombre se guarda aparte. El indicador de inicio es una respuesta autodeclarada, no una conducta observada. El APK compila y pasa 61 pruebas unitarias. El recorrido principal, el envío de registros y el borrado se comprobaron en emulador, pero no en un teléfono ni con un parlante reales. El parlante puede reproducir audio de otras aplicaciones y no es un testigo exclusivo de Relevo.

La memoria conserva la estructura de catorce capítulos. El 25 de septiembre se verificaron sus 64 referencias: todas existen, y se corrigieron datos bibliográficos, paráfrasis de entrevistas y la descripción del prototipo ([revisión integral](revision-integral-fuentes-y-redaccion-2026-09-25.md)). El mismo día se revisó su redacción según la pauta de presentación de la UDP, y se revisó para que la entienda quien no conoce el proyecto: los criterios se nombran con palabras y se explican los códigos de participantes y preguntas. Una revisión página por página corrigió paráfrasis que atribuían a las fuentes más de lo que dicen, retiró un dato sin respaldo sobre prototipos anteriores y devolvió la introducción y la justificación a su extensión mínima. El proyecto aparece de manera progresiva: el texto no lo nombra antes del capítulo 10, salvo en el resumen. El autor decidió que Relevo no usará luz por ahora ([D-070](../09_decisiones/registro-de-decisiones.md)), y la memoria ya describe una señal solo sonora de unos 30 segundos y la prueba de 21 días (D-078 y D-079). Una revisión completa de redacción precisó fuentes, retiró restos de la señal luminosa y alineó el plan de validación con el protocolo 02. Después se volvieron a verificar las 64 referencias y el formato APA 7, y se simplificó el lenguaje para la comisión. El 29 de septiembre la memoria incorporó la hipótesis nueva y el marco multiproceso, actualizó el estado del prototipo y de la prueba, y pasó sus citas a APA 7 en español («y» en lugar de «&»). El mismo día incorporó una [encuesta en línea de 53 respuestas](../03_usuarios/encuesta-53-respuestas-2026-09.md) como evidencia complementaria (D-092) y quedó en 16.965 palabras. La propuesta de marca [«Vuelve a lo que querías hacer»](../10_recursos_visuales/21_marca-relevo-a-tiempo-2026-09-25.md), cuya firma eligió el autor y que sigue pendiente de decisión (D-073), explica Relevo en palabras simples. La persona escribe en un renglón lo que quiere hacer, Relevo se lo recuerda mientras todavía puede y ella decide. La marca usa el logotipo «relevo» en Schibsted Grotesk, tinta y papel, y azul pasta para lo que escribe la persona. Las ocho entrevistas sostienen dos situaciones de uso, no dos identidades permanentes: la intención alternativa puede perder presencia, o el ocio digital puede conservar sentido y no requerir intervención. La encuesta (53 personas de 19 a 30 años; respuestas editadas antes del análisis y muestra no representativa) coincide con esas situaciones: 43 de 47 episodios tenían otra actividad deseada, 44 ocurrieron en casa y 42 personas nombraron un primer paso concreto. También muestra que 41 de 53 preferirían un sonido de 15 segundos o menos, más breve que el previsto.

## Qué cambió y qué falta

Para la corrección cruzada del 30 de septiembre hay un [guion de presentación](../00_gobernanza/guion-presentacion-correccion-cruzada-2026-09-30.md) de unos 7 minutos, basado en la memoria, el protocolo 02 y el plan de cierre, y una [presentación completa en Figma](https://www.figma.com/slides/zhLK5LTPQWXPHIQeq4wuE8) de 18 diapositivas con diagramas, gráficos de la encuesta y notas del orador.

El feedback del 23 de septiembre llevó a distinguir recordar una intención, empezar una actividad y formar un hábito. No se añadieron rachas ni premios. La revisión de Android 2.6 aclaró el consentimiento, el registro seudónimo, la selección de salida y los límites del parlante. Las decisiones y alternativas están en el [registro de aplicación del feedback](../00_gobernanza/aplicacion-feedback-docente-2026-09-23.md) y en la [auditoría específica de Android](../06_desarrollo_y_factibilidad/app-android/revision-feedback-2026-09-23.md).

La prueba con participantes será de 21 días en casa y responderá también la hipótesis ([protocolo 02](../07_validacion/protocolo-02-prueba-21-dias.md)). Por ahora se hará con una persona (D-081), así que describirá un caso. Antes de convocar faltan pruebas en teléfono y parlante reales y la revisión académica del consentimiento. La [pauta de testeo](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) todavía describe Android 2.6 y no contiene resultados. El aporte del objeto frente a un aviso digital, la forma final, la autonomía y los costos continúan abiertos a prueba.

## Registro de cambios (disclaimer)

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
