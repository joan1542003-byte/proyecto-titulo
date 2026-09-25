# Modelo de datos para evaluar la aplicación Relevo

**Estado:** vigente para el prototipo Android 2.7 y la prueba de 21 días del [protocolo 02](protocolo-02-prueba-21-dias.md) (revisado el 25 de septiembre de 2026 contra `base-remota-supabase.sql`).

**Fecha:** 22 de septiembre de 2026.

## Propósito

El registro permite estudiar si la condición técnica funciona, qué configuraciones eligen las personas y qué respuesta declaran después de la señal. No busca vigilar contenido ni demostrar por sí solo un cambio de conducta.

## Unidad de análisis

La unidad principal es una **sesión de Relevo**: comienza cuando la persona activa un recordatorio y termina cuando lo cierra. Una instalación recibe un usuario anónimo de Supabase y un código de participación estable entre ciclos; cada sesión conserva además un identificador aleatorio y la versión del consentimiento aceptado. Los datos se guardan primero en el teléfono y se envían a tres tablas: `relevo_sessions`, una fila por sesión; `relevo_events`, una fila por evento técnico, y `relevo_answers`, una fila por respuesta de las tarjetas semanales, del cierre del día 21 o de la configuración de la prueba.

## Datos registrados

| Dato | Para qué sirve | Lo que no permite afirmar |
|---|---|---|
| actividad | reconocer qué quiso retomar la persona | que realizó la actividad |
| cómo comenzar | analizar el grado de concreción de la preparación | que ese comienzo fue eficaz |
| lugar declarado | estudiar dónde se sitúa la señal | ubicación GPS o presencia física efectiva |
| aplicaciones elegidas | identificar qué usos suman tiempo para la condición (una o varias, bajo un mismo umbral) | contenido observado dentro de las aplicaciones |
| umbral | conocer el tiempo configurado | tiempo recomendado o saludable |
| tiempo observado | comprobar el conteo acumulado | atención, intención o efecto psicológico |
| señal emitida | verificar que se cumplió la condición técnica | que la señal fue vista u oída |
| respuesta final | conocer qué decisión declara la persona | comprobación externa de la conducta |
| eventos técnicos | reconstruir activación, entrada y salida de las apps elegidas, señal emitida o fallida, silencio, desactivación y cierre | percepción de la señal o decisión de la persona |
| código de participación y versión del consentimiento | localizar y eliminar los registros de una persona y saber qué texto aceptó | identidad de la persona |
| condición y día de la prueba (`study_condition`, `study_day`) | comparar las tres condiciones dentro de cada persona | que la persona siguió la instrucción de dónde dejar el parlante |
| preguntas tras la señal (`knew_intention`, `recalled_first_step`) | responder por autoinforme si la señal devolvió la intención y el primer paso | una observación directa, que solo existe en la sesión inicial |
| fin del sonido (`signal_end`) y tiempo de respuesta (`response_seconds`) | saber si la persona silenció la señal o esta terminó sola, y cuánto tardó en responder | que la persona oyó la señal |
| uso de las apps elegidas 10 minutos antes y después de la señal (`usage_before_seconds`, `usage_after_seconds`) | describir qué ocurrió en el teléfono alrededor de la señal | que la persona hizo o no hizo la actividad; no se muestra como «tiempo excedido» |
| respuestas semanales y del cierre (`relevo_answers`) | carga de preparar, molestia de la señal, relación con el lugar y valoración final | resultados de una población |

La respuesta final ofrece cuatro estados: comenzó la actividad, la dejó para después, cambió de idea o prefirió no responder. Las preguntas tras la señal y las respuestas semanales se pueden omitir; un valor vacío significa que no se respondieron.

Las claves de `relevo_answers` son: `prueba_inicio` y `prueba_fin` (secuencia y fechas); `semanaN_costo_preparar`, `semanaN_molestia_senal` y `semanaN_relacion_lugar` (1 a 5); `semanaN_comentario` o `semanaN_omitida`, y las del cierre con prefijo `cierre_`.

## Preguntas que puede responder

1. ¿Cuántos relevos se activaron y cuántos alcanzaron la señal?
2. ¿Qué actividades fueron elegidas con mayor frecuencia?
3. ¿Cuántas veces se eligió `Caminar`?
4. ¿Qué aplicaciones, solas o combinadas, se asociaron a cada actividad?
5. ¿Qué umbrales configuraron las personas?
6. ¿Qué decisión declararon después de recibir la señal?
7. ¿Dónde se interrumpió el recorrido técnico? ¿Cuántas señales fallaron por la salida de audio?

## Consultas de revisión

```sql
-- Veces que se eligió caminar.
select count(*)
from public.relevo_sessions
where lower(activity) = 'caminar';

-- Actividades ordenadas por frecuencia.
select activity, count(*) as sesiones
from public.relevo_sessions
group by activity
order by sesiones desc;

-- Respuesta declarada después de la señal.
select activity, outcome, count(*) as sesiones
from public.relevo_sessions
where signal_at is not null
group by activity, outcome
order by activity, sesiones desc;

-- Cumplimiento técnico de la condición.
select
  count(*) as activadas,
  count(signal_at) as con_senal,
  round(100.0 * count(signal_at) / nullif(count(*), 0), 1) as porcentaje_con_senal
from public.relevo_sessions;

-- Protocolo 02: señales con «Sí» a la primera pregunta, por persona y condición.
select participant_code, study_condition,
  count(*) filter (where signal_at is not null) as senales,
  count(*) filter (where knew_intention = 'yes') as supo_que_hacer,
  count(*) filter (where signal_end = 'auto') as terminaron_solas
from public.relevo_sessions
where study_condition is not null
group by participant_code, study_condition
order by participant_code, study_condition;

-- Protocolo 02: escalas semanales.
select participant_code, question, answer
from public.relevo_answers
where question like 'semana%'
order by participant_code, question;
```

## Privacidad y seguridad

- no se registran nombres, correos, mensajes, imágenes, teclas ni contenido de pantalla;
- la instalación se autentica como usuario anónimo;
- las políticas de seguridad por fila permiten a cada instalación leer, insertar, actualizar y eliminar solo sus propias sesiones, e insertar, leer y eliminar solo sus propios eventos y respuestas;
- los eventos no se modifican después de registrarse, pero pueden eliminarse a solicitud de la persona;
- la clave secreta o `service_role` nunca se incluye en la aplicación;
- el registro se conserva localmente cuando no existe conexión y se reintenta después;
- la respuesta final es opcional.

El consentimiento de la app indica responsable, correo de contacto y plazo máximo de conservación hasta el 30 de diciembre de 2026, y la app ofrece solicitar la eliminación local y remota. La ausencia de eventos observada el 24 de septiembre se debía a que la base no permitía leer la tabla de eventos. Sin ese permiso, la inserción con `on_conflict` se rechaza (`42501`), y las versiones anteriores de la app dejaban de enviar en el primer rechazo. El permiso se corrigió ese día y Android 2.7 ya no bloquea el envío. En emulador, con datos ficticios, se comprobó que llegan sesiones, eventos y respuestas y que el borrado con conexión elimina las tres tablas ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.7-prueba-21-dias-2026-09-25.md)). Antes de una prueba con participantes falta repetirlo en el teléfono real, probar la eliminación sin conexión y definir quién tiene acceso administrativo.

## Interpretación

La frecuencia de una actividad describe elecciones dentro de Relevo. Para afirmar que una persona caminó, estudió o entrenó se necesita su declaración o una observación externa acordada. Incluso la opción `Comencé la actividad` continúa siendo un autorreporte y debe presentarse como tal.

---

## Registro de cambios (disclaimer)

### 2026-09-25 — Android 2.7 y protocolo 02

- **Qué cambió:** se añadieron la tabla `relevo_answers`, los datos de la prueba de 21 días (condición, día, preguntas tras la señal, fin del sonido, tiempo de respuesta y uso alrededor de la señal), dos consultas del protocolo 02 y la causa comprobada de la ausencia de eventos.
- **Cómo estaba antes:** el modelo describía dos tablas y Android 2.6, y la falta de eventos figuraba sin diagnóstico.
- **Por qué:** el protocolo 02 necesita estos datos para comparar las condiciones, y el modelo debe coincidir con la base desplegada.

### 2026-09-25 — Sincronización con Android 2.6

- **Qué cambió:** el modelo describe varias aplicaciones por sesión, el código de participación estable, la versión del consentimiento, la tabla de eventos, las políticas que permiten eliminar las propias filas y el estado real de envío y eliminación.
- **Cómo estaba antes:** se declaraba vigente para el prototipo Android 1.4, con una sola aplicación, eventos de solo inserción y sin mecanismo de retiro.
- **Por qué:** el documento debe corresponder al esquema que usa la versión instalada.

### 2026-09-22 — Modelo creado

- **Qué cambió:** se definieron unidad de análisis, variables, preguntas, consultas y límites interpretativos.
- **Cómo era antes:** la aplicación registraba eventos técnicos sin una estructura explícita para analizar actividades y respuestas.
- **Por qué se decidió:** evaluar el sistema sin confundir selección, señal y conducta efectivamente realizada.
- **Límite:** el envío remoto requiere configurar el proyecto Supabase y verificarlo con una sesión de prueba.
