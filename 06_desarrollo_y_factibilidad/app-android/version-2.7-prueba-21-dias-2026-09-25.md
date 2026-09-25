# Android 2.7: la app que pide el protocolo 02

**Fecha:** 25 de septiembre de 2026. **Versión:** 2.7 (`versionCode 18`). **Consentimiento en la app:** `2026-09-25-v6`; al cambiar de versión, la app pide aceptar de nuevo.
**Fuentes:** [protocolo 02](../../07_validacion/protocolo-02-prueba-21-dias.md) (apartado «Materiales»), decisiones D-075, D-077, D-078 y D-079 del [registro](../../09_decisiones/registro-de-decisiones.md), [flujos y wireframes escritos](../../05_propuesta_phygital/flujos-y-wireframes-escritos-2026-09-25.md) (B4, B5, T1, T2, V1 y sección 7) y [consentimiento de 21 días](../../07_validacion/consentimiento-android-vigente-2026-09-23.md).

Las comprobaciones se hicieron en un emulador Android 16 (API 36) con datos ficticios, que después se borraron. No sustituyen la prueba técnica con el teléfono y el parlante que se usarán, ni una prueba con personas.

## Lo que pide el protocolo 02

| Requisito del protocolo | Cómo lo resuelve 2.7 |
| --- | --- |
| 1. Señal de unos 30 segundos que se detiene sola (D-078). | La señal repite siete veces la firma sonora de D-071 (dos notas de madera, 587 → 440 Hz, 2,2 s), una cada 4,4 s. Las tres primeras suben de volumen (40 %, 60 % y 80 %) y termina a los 28,6 s. La firma se genera en el teléfono con la misma receta que `firma-sonora.py`. Al terminar, la pantalla dice «La señal ya terminó» y la notificación queda en silencio hasta que la persona responde. La prueba de sonido usa una sola firma. |
| 2. Condición de la semana, asignada por código, con la instrucción de dónde dejar el parlante. | En la sesión inicial, el investigador abre **Privacidad y datos → Configurar la prueba**, elige una de las seis secuencias (A → B → C, …, C → B → A) y la prueba empieza ese día (día 0). Los días 1–7, 8–14 y 15–21 usan la condición que indica la secuencia. Inicio muestra la instrucción de la semana con las palabras del protocolo. Durante la prueba, la condición fija dónde suena la señal y la persona no puede cambiarla. |
| 3. Condición «teléfono»: el mismo sonido en el altavoz y una notificación genérica. | En la condición C suena la misma señal en el altavoz del teléfono, y la notificación dice solo «Relevo · Tu intención está disponible». En todas las condiciones, la pantalla de bloqueo muestra esa versión genérica y no la intención. |
| 4. Preguntas tras cada señal y tarjetas semanales. | Tras cada señal, antes de «¿Qué decidiste?», la app pregunta «Cuando sonó, ¿supiste qué querías hacer antes de mirar el teléfono?» (Sí / A medias / No) y «¿Recordaste cómo empezar?» (Sí / No). Cada una se responde con un toque y se puede omitir. Desde los días 7, 14 y 21, Inicio muestra la tarjeta de cierre de la semana (tres escalas de 1 a 5 y un comentario opcional) y, al final, el cierre del día 21. |
| 5. Registro de tiempo de respuesta, silencio manual o automático, y uso de las apps elegidas 10 minutos antes y después de la señal. | Cada sesión guarda `signal_end` (`silenced`, `auto` o `interrupted`), `response_seconds` y `usage_before_seconds`. `usage_after_seconds` se calcula cuando ya pasaron los 10 minutos, la próxima vez que la app o el conteo corren. Ninguno de estos datos se muestra a la persona. |

## Otros cambios

- **Envío de datos.** Hasta la migración del 24 de septiembre, la base no permitía a las instalaciones leer la tabla de eventos. Sin ese permiso, PostgreSQL rechaza la inserción con `on_conflict` (error `42501`), que la app usa para no duplicar eventos. Además, las versiones anteriores se detenían en el primer rechazo, por eso llegaban sesiones y ningún evento. Se comprobó reproduciendo el rechazo en una transacción revertida. En 2.7, un registro que la base rechaza se guarda aparte en el teléfono y no bloquea el resto. Ante una sesión vencida, la app la renueva y reintenta. Privacidad y datos muestra los pendientes, el último envío y los rechazos.
- **Resistencia para tres semanas.** El conteo se retoma solo después de reiniciar el teléfono o actualizar la app (evento `monitor_resumed`). Si se retira Tiempo de uso, se detiene y avisa con una notificación y en pantalla (`monitor_paused`, pantalla E2). Hay una nota opcional para quitar la restricción de batería y un aviso de que muchos parlantes se apagan solos.
- **Varias apps.** La suma pasó a `ForegroundTracker`, con pruebas unitarias. Pasar de una app elegida a otra se registra como salida y entrada.
- **Regreso (V1).** Dos días o más después del último relevo, Inicio dice «Hola de nuevo», nombra la última actividad y ofrece «Preparar de nuevo», «Elegir otra actividad» y «Ahora no». No dice cuántos días pasaron. «Repetir el último relevo» abre la configuración anterior en la revisión y no la activa sin confirmación.
- **Reconocimiento (B5).** «Comencé»: «Gracias por contarlo». «Después»: «Queda guardado. Puedes prepararlo cuando quieras». «Cambié de idea»: «Está bien. Puedes elegir otra actividad cuando quieras». Omitir no muestra mensaje.
- **Textos (D-077).** Las acciones llevan verbo: «Seguir», «Activar el relevo», «Probar el sonido», «Probar 15 segundos», «Desactivar el relevo», «Preparar otro relevo», «Crear un relevo», «Ver todas las actividades» y «Abrir ajustes de Android». El consentimiento de la app sigue la hoja de 21 días, con un resumen arriba y el detalle debajo.

## Datos nuevos

- **Sesiones:** `study_condition` (A, B o C; vacío el día 0 y fuera de la prueba), `study_day`, `knew_intention`, `recalled_first_step`, `signal_end`, `response_seconds`, `usage_before_seconds` y `usage_after_seconds`. Cada relevo conserva la condición con que se activó, aunque la señal llegue al día siguiente.
- **Eventos:** `signal_ended` (terminó sola), `signal_interrupted` (se perdió la salida), `responded` (primera acción después de que terminó), `monitor_paused` y `monitor_resumed`. En `silenced` y `responded`, `value_seconds` es el tiempo desde la señal.
- **Respuestas (tabla nueva `relevo_answers`):** `prueba_inicio` y `prueba_fin` (secuencia y fechas), `semanaN_costo_preparar`, `semanaN_molestia_senal`, `semanaN_relacion_lugar`, `semanaN_comentario` o `semanaN_omitida`, y las del cierre con prefijo `cierre_`. Tiene las mismas políticas que las otras tablas: cada instalación inserta, lee y borra solo sus filas. El borrado desde la app incluye esta tabla.

El esquema está en [`base-remota-supabase.sql`](base-remota-supabase.sql). Las migraciones `relevo_monitor_interruption_events` y `relevo_prueba_21_dias` se aplicaron el 24 y el 25 de septiembre. El asesor de seguridad de Supabase solo advierte, como antes, que las tablas admiten usuarios anónimos, lo que es el diseño: cada instalación usa una sesión anónima y solo accede a sus filas.

## Decisiones de implementación que debe revisar el autor

1. **Cierre del día 21.** El diseño escrito (T2) nombra dos preguntas y el protocolo, los temas de la entrevista final. La app usa cinco preguntas derivadas de esas fuentes:
   - ¿Seguirías usando Relevo?
   - ¿Qué semana te ayudó más?
   - ¿Qué te molestó?
   - ¿Qué cambiarías?
   - ¿Dónde quedó el parlante la mayor parte del tiempo?

   A ellas se suma la invitación a la conversación de 15 minutos. Son una propuesta.
2. **Escalas semanales.** Se anclan en «1 · nada» y «5 · mucho». El protocolo fija la escala, pero no sus extremos.
3. **Orden de las tarjetas.** La tarjeta de cierre del día 21 aparece después de las semanales pendientes.
4. **Sesión inicial.** El día 0 no tiene condición y la persona elige la salida. El protocolo pide dejar el parlante junto al primer paso.
5. **Dónde se configura la prueba.** En Privacidad y datos, en una sección para el investigador, sin contraseña.

## Verificación

| Comprobación | Resultado |
| --- | --- |
| Compilación y 34 pruebas unitarias. Cubren el plan de la prueba, la suma de varias apps, el uso en una ventana de tiempo, la señal (30 s, comienzo suave, pausas en silencio) y el ciclo del recordatorio. | Aprobadas. |
| Consentimiento nuevo y configuración de la secuencia 2 (A → C → B). | La app pidió aceptar de nuevo. Inicio mostró la tarjeta de sesión inicial. La base recibió `prueba_inicio`. |
| Día 0: ciclo de 15 s con Clock y salida en el teléfono, sin silenciar. | La señal terminó sola, unos 30 s después de empezar. La pantalla pasó a «La señal ya terminó / Continuar». La base recibió `signal_ended` (31 s) y `responded` (76 s), `signal_end = auto`, las respuestas «A medias» y «Sí», y 14 s de uso en los 10 minutos previos. |
| Semana 2 (condición C, día 8), simulada moviendo el día 0 en el emulador. | Inicio mostró la instrucción de la semana y la tarjeta de cierre de la semana 1. La salida quedó fija en el teléfono. La notificación fue la genérica y se retiró al responder. La base recibió `study_condition = C`, `study_day = 8` y `signal_end = silenced` (11 s). |
| Tarjetas semanales y cierre del día 21. | La base recibió la semana 1 completa, `semana2_omitida`, la semana 3 parcial y las respuestas del cierre. |
| Uso posterior a la señal. | Al reabrir la app pasados los 10 minutos, se guardaron 142 s y 81 s para las dos señales. |
| Borrado con conexión desde Privacidad y datos. | La base quedó sin sesiones, eventos ni respuestas de esa instalación; solo quedaron las 4 sesiones técnicas antiguas de otras instalaciones. El teléfono quedó sin registros, sin plan de prueba y sin la última configuración. |

Capturas: [`capturas/interfaz-2.7`](capturas/interfaz-2.7/README.md).

## Pendiente antes de la prueba técnica (1 al 7 de octubre)

- Repetir el recorrido en el teléfono y con el parlante de la prueba. En particular:
  - que la señal de 30 segundos se oiga desde otra pieza y con ruido de fondo (comparación interna del protocolo);
  - el reinicio y el gestor de batería del fabricante.
- Probar el borrado sin conexión y con reintento.
- Si la sesión anónima de un teléfono caduca, las filas anteriores no se pueden borrar desde la app. Conservan el código de participación y se borran desde la administración de la base; el procedimiento de borrado debe decirlo.
- Confirmar las cinco decisiones de la sección anterior.
- Perfil, ruta y aviso de regreso opcional (D-076, V2, S1 y S2) siguen sin implementar. Si se agregan antes de la prueba, deben quedar iguales durante las tres semanas.

## Registro de cambios (disclaimer)

### 2026-09-25 — Documento nuevo

- **Qué se añadió:** qué exige el protocolo 02 y cómo lo resuelve 2.7; la causa comprobada de la ausencia de eventos; los datos nuevos; las decisiones de implementación pendientes de revisión, y la verificación en emulador.
- **Cómo estaba antes:** el README de la app anunciaba la 2.7 como próxima versión; la ausencia de eventos no estaba diagnosticada.
- **Por qué:** dejar trazable qué pidió cada decisión, qué se implementó y qué falta comprobar antes de la prueba técnica.
