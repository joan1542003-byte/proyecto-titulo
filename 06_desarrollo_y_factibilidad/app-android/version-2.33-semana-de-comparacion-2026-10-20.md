# Android 2.33: semana de comparación y preguntas de la experiencia

**Fecha:** 20 de octubre de 2026. **Decisión:** D-138. **Estado:** compilada desde cero en versión optimizada, con 87 pruebas unitarias aprobadas y la misma firma de las anteriores. Se recorrió completa en el emulador, sin conexión: iniciar la semana C, responder las semanas anteriores, un relevo con la señal en el teléfono y sus preguntas, y la tarjeta semanal y el cierre adelantando la fecha 6 días. El consentimiento no cambia (v13).

Es la 2.32 con la semana de comparación, sobre la misma interfaz de la 2.30. El código está en la rama `android-2.33`, que sale de `android-2.32`.

## El pedido

Desde el 20 de octubre, la persona participante que usó el Tag junto al primer paso pasa a probar solo con la notificación del teléfono. El autor pidió que la app tuviera las preguntas adecuadas para conocer su experiencia en estas semanas y después de cada relevo.

## Por qué hacía falta un cambio

- **La app solo iniciaba la prueba de 21 días completa,** con tres semanas en un orden fijo. La persona ya lleva 12 días con el Tag sin una condición asignada, así que ninguna de las seis secuencias calzaba.
- **Sin la prueba iniciada, la app no hace preguntas semanales ni de cierre.** Además, ninguna de sus preguntas comparaba el teléfono con el Tag.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Semana de comparación | La pantalla del investigador suma «Una semana para comparar», con la semana A, B o C. Empieza hoy (día 1), dura 7 días y fija la condición, igual que una semana de la prueba completa. En la semana C, la señal suena solo en el teléfono y la notificación dice «Es momento de volver a elegir», sin nombrar la actividad. |
| Antes de empezar | En Inicio aparece «¿Cómo te fue hasta ahora?»: las tres escalas de la tarjeta semanal, de 1 a 5, sobre las semanas anteriores con el objeto que ya usaba. Así quedan registradas las semanas con el Tag, que la app nunca preguntó. |
| Tras cada relevo | Pregunta nueva, la primera: «¿Notaste el aviso apenas sonó?», con las opciones Enseguida / Un rato después / No lo noté. Percibir la señal es el primer paso para recordar (protocolo 02), y es donde más puede diferir el teléfono de un objeto que suena en la casa. Siguen las de siempre: cómo le cayó el sonido, si supo qué quería hacer antes de leerlo en la pantalla, si recordó cómo empezar y qué decidió. |
| Tarjeta del día 7 | Además de las tres escalas: «Comparado con las semanas anteriores, ¿esta semana te ayudó a recordar lo que querías hacer…» Más / Igual / Menos, y «¿Por qué?». |
| Cierre del día 7 | Siete preguntas: ¿Seguirías usando Relevo?; ¿Qué te ayudó más a recordar lo que querías hacer? (el objeto donde empiezo, el aviso en el teléfono, los dos por igual o ninguno); ¿Por qué?; Si siguieras usando Relevo, ¿con qué te gustaría que sonara? (un objeto, el teléfono o me da igual); ¿Qué te molestó?; ¿Qué cambiarías?; ¿Dónde quedó el objeto la mayor parte del tiempo? |
| Instrucción de la semana C | Suma que el Tag se puede apagar manteniendo apretado su centro 3 segundos, para que no suene ni gaste pila durante la semana. |
| Registro | Claves nuevas en `relevo_answers`: `semanas_previas_costo_preparar`, `semanas_previas_molestia_senal`, `semanas_previas_relacion_lugar`, `semanas_previas_comentario`, `percepcion_senal` (con el relevo), `semana1_comparacion` (mas, igual o menos), `cierre_por_que_ayudo` y `cierre_prefiere_que_suene`. Los relevos de la semana quedan con `study_condition = C` y su día. El panel las muestra con palabras y su versión de referencia pasa a 2.33. |

## Cómo se configura en el teléfono de la participante

1. **Instalar** la 2.33 encima de la versión que tiene, sin desinstalar. Se conservan sus datos.
2. **Abrir la pantalla del investigador:** Perfil › bajar hasta el final › mantener apretado el texto «Relevo 2.33 · Proyecto de Título…».
3. **Elegir la semana:** en «Una semana para comparar», elegir «Semana C: suena en el teléfono» y tocar «Empezar la semana hoy».
4. **Responder lo pendiente:** en Inicio aparecen la instrucción de la semana y «¿Cómo te fue hasta ahora?»; conviene responder esta última el mismo día.
5. **Apagar el Tag,** manteniendo apretado su centro 3 segundos, y dejarlo guardado.
6. **El día 7** aparecen la tarjeta de la semana y el cierre. Después, la entrevista de cierre de unos 15 minutos sigue la [ficha en papel](../../07_validacion/instrumentos/ficha-escalas-y-cierre-2026-10-20.md).

Si un relevo ya está activo al iniciar la semana, termina con la salida que tenía. Los siguientes suenan en el teléfono.

## Verificación

- **Pruebas:** 87 pruebas unitarias. La nueva comprueba que la semana C dura 7 días, que su condición es el teléfono y que la tarjeta y el cierre llegan el día 7.
- **Firma:** la misma clave (`fdbe6bbe…`), con `versionCode` 48, así que se instala encima de la 2.32 y de la 3.2.
- **Emulador** (sin conexión, perfil de prueba):
  - Al iniciar la semana C, la pantalla dice «Día 1 de 7 · semana de comparación: suena en el teléfono».
  - En «¿Dónde suena?» queda fijo el teléfono.
  - La notificación de la señal dice «Es momento de volver a elegir».
  - Las preguntas nuevas aparecen y se guardan con sus claves.
  - Con la fecha adelantada al día 7, aparecen la tarjeta con la comparación y el cierre de siete preguntas, numeradas del 1 al 7.
  - Al final se volvió a la 3.2, y los datos del autor quedaron idénticos (MD5).
- **No probado:** en el teléfono de la participante.

**APK:** [relevo-android-2.33-2026-10-20.apk](releases/relevo-android-2.33-2026-10-20.apk), SHA-256 `0BE7CA0505542FD7E89F33EC92DC8A31FCE720A361A37BD948F902F8F6D0800A` (12,2 MB).

## Límites

- **No es un contrabalanceo:** es una semana con el teléfono después de 12 días con el Tag, con una persona. El orden puede influir: la persona ya conoce el sistema y tal vez recuerda más por costumbre. El análisis lo tiene que declarar.
- **Las escalas de las semanas con el Tag** se responden al final de esas semanas, de memoria, y no al cierre de cada una.
- **Línea 3.x:** desde el mismo día, la [3.3](version-3.3-semana-de-comparacion-2026-10-20.md) tiene estos cambios, con `versionCode` 49.

## Registro de cambios (disclaimer)

### 2026-10-20 — Android 3.3

- **Qué cambió:** los límites dicen que la 3.3 ya tiene estos cambios.
- **Cómo estaba antes:** decían que la línea 3.x no los tenía.
- **Por qué:** el autor pidió continuar con lo pendiente: llevar la 2.33 a la línea 3.x (D-138).

### 2026-10-20 — Creación

- **Qué se añadió:** la versión 2.33: semana de comparación de una sola condición y preguntas sobre las semanas anteriores, la percepción de la señal, la comparación semanal y el cierre.
- **Cómo estaba antes:** solo se podía iniciar la prueba completa de 21 días, y ninguna pregunta comparaba el teléfono con el objeto.
- **Por qué:** la persona participante pasa a probar solo con la notificación del teléfono, y el autor pidió las preguntas para conocer su experiencia (D-138).
