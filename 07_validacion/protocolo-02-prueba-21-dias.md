# Protocolo 02 — Prueba de 21 días en casa: asociación, comparación y uso

**Estado:** planificado, no ejecutado.
**Fecha de preparación:** 25 de septiembre de 2026.
**Decisiones:** D-070 (sin luz), D-075 (21 días), D-078 (señal de unos 30 segundos) y D-079 (la prueba responde la hipótesis), en el [registro de decisiones](../09_decisiones/registro-de-decisiones.md).
**Relación con el protocolo 01:** lo reemplaza como estudio principal. Conserva su cadena de asociación, sus tres condiciones, sus reglas de decisión y sus fallos críticos, pero los lleva a una sola prueba en los hogares, sin luz. El [protocolo 01](protocolo-01-asociacion-y-comparacion.md) queda como antecedente.

## Qué responde

La memoria pregunta qué condiciones pueden ayudar a que una persona vuelva a considerar una actividad elegida cuando, durante una sesión de ocio digital, esa intención deja de orientar su decisión (capítulo 10). Esta prueba responde:

| Pregunta | Cómo se responde |
| --- | --- |
| 1. **Asociación.** Cuando suena, ¿la persona recupera la intención y su primer paso sin mirar el teléfono? | Observación en la sesión inicial y autoinforme tras cada señal en casa. |
| 2. **Lugar y soporte.** ¿Ayuda más la señal junto al primer paso que en un lugar neutro o que un aviso en el teléfono? | Comparación de las tres semanas dentro de cada persona. |
| 3. **Autonomía.** ¿La persona entiende que puede seguir, silenciar o cambiar de idea, sin sentir obligación? | Comprobación en la sesión inicial, preguntas semanales y entrevista final. |
| 4. **Uso y carga.** ¿Cuánto cuesta preparar, qué molesta, qué falla y quién abandona? | Registros de la app, preguntas semanales y entrevista final. |

**No responde:** si la actividad se realizó (solo se conoce lo que la persona declara), si se formó un hábito (21 días no bastan; Lally et al., 2010) ni cuán eficaz es Relevo en la población.

## Participantes

- **Por ahora, una persona** (decisión del autor del 25 de septiembre de 2026, D-081) de 18 a 30 años que no participó en las entrevistas P1–P8, con un teléfono Android 12 o posterior. Se le asigna una de las seis secuencias. El diseño para seis personas se conserva por si la prueba se amplía.
- Cada una debe poder nombrar una actividad que a veces pierde frente al teléfono y un primer paso concreto.
- Reclutamiento por referencias, voluntario y sin pago.
- Cada persona usa un parlante Bluetooth propio o prestado por el proyecto. El parlante reemplaza al testigo, que no estará construido a tiempo; no es el objeto final.

## Materiales

**App Android 2.7.** Debe agregar a la 2.6:

1. la señal de D-078: unos 30 segundos, que se detiene sola;
2. la condición de la semana, asignada por código, con la instrucción de dónde dejar el parlante;
3. en la condición «teléfono», el mismo sonido por el altavoz del teléfono y una notificación genérica, «Relevo · Tu intención está disponible», que no muestra la intención ni el primer paso hasta abrirla;
4. las preguntas tras cada señal y las tarjetas semanales;
5. el registro de tiempo de respuesta, de silencio manual o automático y del uso de las apps elegidas en los 10 minutos anteriores y posteriores a la señal.

**Estado al 25 de septiembre:** los cinco puntos están implementados en [Android 2.7](../06_desarrollo_y_factibilidad/app-android/version-2.7-prueba-21-dias-2026-09-25.md) y se comprobaron en emulador con datos ficticios. La secuencia se asigna en la sesión inicial desde **Privacidad y datos → Configurar la prueba**. El texto del cierre del día 21 y los extremos de las escalas son una propuesta pendiente de revisión (D-080). Falta la prueba técnica en el teléfono y el parlante que se usarán.

**Además:**

- el [consentimiento](consentimiento-android-vigente-2026-09-23.md) de 21 días;
- la [ficha de registro](ficha-registro-protocolo-01.md) de la sesión inicial, adaptada.

## Procedimiento

### Antes de reclutar

- **Prueba técnica** en el teléfono y el parlante que se usarán, con la [pauta Android](pauta-testeo-prototipo-android-2026-09-23.md). Se comprueban el conteo con varias apps, la señal de 30 segundos, el silencio, la desconexión, el permiso, el envío de registros y el borrado local y remoto.
- **Comparación interna** de la señal desde otra pieza y con ruido de fondo, para confirmar que se escucha.
- **Revisión** del consentimiento y del protocolo con el profesor.

### Día 0: sesión inicial en casa (40 a 50 minutos)

1. Consentimiento, instalación, permiso y perfil.
2. La persona formula una intención y su primer paso, y deja el parlante junto a ese comienzo.
3. Configura un límite de 8 minutos en una app que usará durante la espera. Es un parámetro de la prueba, no el momento ideal de intervención.
4. Cuando suena, el investigador registra cuatro momentos sin dar pistas:

| Momento | Pregunta | Evidencia mínima |
| --- | --- | --- |
| Percepción | ¿Notó la señal? | Reacción o confirmación sin sugerir el significado. |
| Atribución | ¿Supo que venía de Relevo? | Lo identifica sin ayuda. |
| Recuperación | ¿Recordó la intención? | La nombra sin abrir el teléfono. |
| Primer paso | ¿Recordó cómo empezar? | Lo describe sin ayuda. |

5. Comprobación de autonomía: la persona reconoce al menos dos salidas (seguir, silenciar, empezar o cambiar de idea) sin considerar obligatoria ninguna.
6. Se explica la condición de la primera semana.

Una **asociación completa** exige los cuatro momentos sin consultar el teléfono ni recibir pistas.

### Días 1 a 21: tres semanas, una condición por semana

| Condición | Dónde suena | Qué pide la app al comenzar la semana |
| --- | --- | --- |
| A. Situada | Parlante junto al primer paso. | «Esta semana deja el parlante junto a lo que necesitas para empezar». |
| B. Lugar neutro | Parlante en un lugar visible de la casa, a más de un metro del primer paso y fuera de su recorrido. | «Esta semana deja el parlante en un lugar que no tenga relación con la actividad». |
| C. Teléfono | Altavoz del teléfono con notificación genérica. | «Esta semana el aviso sonará en tu teléfono». |

- **Orden:** se usan las seis secuencias posibles de A, B y C, una por participante.
- **Uso:** la persona prepara relevos cuando tengan sentido para ella; se sugieren al menos tres por semana, sin obligación. Una semana con menos señales se registra, no se penaliza.
- **Intenciones:** pueden cambiar entre relevos; cada una se registra con la condición en que se usó.

**Tras cada señal**, cada pregunta con un toque y siempre omitible:

1. «Cuando sonó, ¿supiste qué querías hacer antes de mirar el teléfono?» Sí / A medias / No.
2. «¿Recordaste cómo empezar?» Sí / No.
3. «¿Qué decidiste?» Comencé / La dejé para después / Cambié de idea.

**Al final de cada semana**, una tarjeta en Inicio con escala de 1 a 5:

- cuánto costó preparar;
- cuánto molestó la señal;
- cuánto se relacionaba la señal con el lugar;
- un comentario opcional.

**Día 21:** cinco preguntas de cierre y una entrevista de 15 minutos, presencial o por llamada, sobre qué condición ayudó más y por qué, qué molestó, dónde estuvo el parlante y qué cambiaría. La entrevista la acuerda el investigador directamente; la app no pregunta por ella (decisión del autor del 25 de septiembre).

## Reglas de decisión

**Con una persona (D-081):** los umbrales siguientes, pensados para seis, no se aplican. Se describe si esa persona completó la asociación en la sesión inicial y cómo respondió en cada condición. Sirve para orientar el diseño; no permite comparar entre personas ni estimar eficacia. Las reglas se conservan para una ampliación.

**Sesión inicial (asociación observada):**

- **Continuar:** al menos cinco de seis personas completan la asociación, sin fallos críticos.
- **Modificar y repetir:** tres o cuatro la completan, o se repite una confusión en la señal, la explicación, el lugar o el primer paso.
- **Detener la configuración:** dos o menos la completan después de una iteración correctiva.

**Tres semanas (comparación):**

- **Mantener la configuración situada:** A iguala o supera a C en señales con «Sí» a la primera pregunta, supera a B en más de la mitad de las personas y no aumenta de forma recurrente la carga ni la molestia.
- **Modificar la relación física:** resultados mixtos, o el lugar ayuda solo con algunos tipos de actividad.
- **Detener la configuración física probada:** C iguala o supera a A con menos esfuerzo, o B da resultados equivalentes a A. Esto obliga a reformular la relación *phygital*; no prueba que todo soporte físico carezca de valor.

Estos umbrales orientan decisiones de diseño con seis personas; no estiman eficacia. Cualquier cambio de umbral se registra antes de ver resultados.

## Fallos críticos

Impiden avanzar aunque se cumplan los umbrales:

- la persona interpreta la señal como obligación, sanción o evaluación;
- el contenido de la intención queda expuesto a terceros;
- silenciar o abandonar no se entiende;
- suena una señal fuera del relevo acordado;
- aparece una barrera de accesibilidad sin alternativa razonable, por ejemplo en personas con baja audición, porque la señal es solo sonora;
- se registra información que el consentimiento no contempla.

Una falla de conexión, del parlante o de la app no cuenta como respuesta de la persona: se registra como incidente técnico y esa señal se excluye de la comparación.

## Límites

- **Autoinforme:** la asociación en casa se informa después de la señal y puede sobrestimarse; por eso la sesión inicial la observa directamente.
- **Intenciones distintas:** cambian entre semanas y su dificultad no es idéntica.
- **Orden y habituación:** el contrabalanceo reparte el efecto de practicar primero, pero la persona puede acostumbrarse a la señal.
- **Parlante comercial:** no está reservado para Relevo y puede reproducir el audio de otras apps.
- **Muestra:** por ahora, una persona reclutada por cercanía. Los resultados describen un caso.

## Datos y conservación

La app registra, con un código, la actividad, el primer paso, el lugar declarado, las apps elegidas, los tiempos, los momentos de señal y respuesta, las respuestas a las preguntas y el uso de las apps elegidas alrededor de la señal. No registra el contenido de otras apps, mensajes ni fotos. El nombre del perfil queda en el teléfono.

La persona puede pedir el borrado en cualquier momento, y todos los registros se eliminan, como máximo, el 30 de diciembre de 2026. Después solo quedan resultados agregados, sin vínculo con la persona.

## Calendario previsto

Según el [plan de cierre](../00_gobernanza/plan-de-cierre-agosto-diciembre-2026.md):

1. 1 al 7 de octubre: prueba técnica, revisión del consentimiento y reclutamiento.
2. 8 al 10 de octubre: sesiones iniciales.
3. Del día 0 al 31 de octubre: las tres semanas.
4. 1 al 8 de noviembre: análisis.

Si la prueba técnica se atrasa, se corre todo el calendario y se registra el cambio.

## Referencias

Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W., & Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

---

## Registro de cambios (disclaimer)

### 2026-09-25 — Una persona y sin pregunta de entrevista en la app

- **Qué cambió:** la prueba se hace por ahora con una persona (D-081). Las reglas de decisión para seis quedan en reserva. La app ya no pregunta por la conversación final, que acuerda el investigador.
- **Cómo estaba antes:** seis personas, con umbrales de cinco de seis, y una pregunta de la app sobre la conversación de 15 minutos.
- **Por qué:** decisión del autor del 25 de septiembre.

### 2026-09-25 — Estado de la app 2.7

- **Qué cambió:** se añadió el estado de implementación de los cinco puntos que el protocolo pide a la app.
- **Cómo estaba antes:** la app 2.7 figuraba como requisito sin implementar.
- **Por qué:** la prueba técnica del 1 al 7 de octubre debe partir de lo que la app hace realmente.

### 2026-09-25 — Creación

- **Qué se añadió:** protocolo de una prueba de 21 días en casa que responde la hipótesis de la memoria y las preguntas de uso. Tiene una sesión inicial observada, tres semanas con una condición cada una en orden contrabalanceado, preguntas de un toque en la app, reglas de decisión, fallos críticos, límites y conservación de datos.
- **Cómo estaba antes:** el protocolo 01 planteaba dos sesiones con luz y sonido, separadas de una evaluación de la app de dos días que no respondía la hipótesis.
- **Por qué:** el autor decidió no usar luz, una prueba de 21 días y que esa prueba responda también la hipótesis, porque el tiempo no alcanza para estudios separados (D-070, D-075, D-078 y D-079).
