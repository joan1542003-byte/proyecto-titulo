# Modelo de datos para evaluar la aplicación Relevo

**Estado:** vigente para el prototipo Android 1.4.

**Fecha:** 22 de septiembre de 2026.

## Propósito

El registro permite estudiar si la condición técnica funciona, qué configuraciones eligen las personas y qué respuesta declaran después de la señal. No busca vigilar contenido ni demostrar por sí solo un cambio de conducta.

## Unidad de análisis

La unidad principal es una **sesión de Relevo**: comienza cuando la persona activa un recordatorio y termina cuando lo cierra. Una instalación recibe un usuario anónimo de Supabase y cada sesión conserva un identificador aleatorio independiente.

## Datos registrados

| Dato | Para qué sirve | Lo que no permite afirmar |
|---|---|---|
| actividad | reconocer qué quiso retomar la persona | que realizó la actividad |
| cómo comenzar | analizar el grado de concreción de la preparación | que ese comienzo fue eficaz |
| lugar declarado | estudiar dónde se sitúa la señal | ubicación GPS o presencia física efectiva |
| aplicación elegida | identificar qué uso activa la condición | contenido observado dentro de la aplicación |
| umbral | conocer el tiempo configurado | tiempo recomendado o saludable |
| tiempo observado | comprobar el conteo acumulado | atención, intención o efecto psicológico |
| señal emitida | verificar que se cumplió la condición técnica | que la señal fue vista u oída |
| respuesta final | conocer qué decisión declara la persona | comprobación externa de la conducta |

La respuesta final ofrece cuatro estados: comenzó la actividad, la dejó para después, cambió de idea o prefirió no responder.

## Preguntas que puede responder

1. ¿Cuántos relevos se activaron y cuántos alcanzaron la señal?
2. ¿Qué actividades fueron elegidas con mayor frecuencia?
3. ¿Cuántas veces se eligió `Caminar`?
4. ¿Qué aplicaciones se asociaron a cada actividad?
5. ¿Qué umbrales configuraron las personas?
6. ¿Qué decisión declararon después de recibir la señal?
7. ¿Dónde se interrumpió el recorrido técnico?

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
```

## Privacidad y seguridad

- no se registran nombres, correos, mensajes, imágenes, teclas ni contenido de pantalla;
- la instalación se autentica como usuario anónimo;
- cada cliente puede insertar y actualizar únicamente sus propias sesiones;
- los eventos técnicos son de solo inserción;
- la clave secreta o `service_role` nunca se incluye en la aplicación;
- el registro se conserva localmente cuando no existe conexión y se reintenta después;
- la respuesta final es opcional.

La base remota debe definir responsable, fecha de eliminación, mecanismo para retirar consentimiento y acceso administrativo antes de una prueba con participantes.

## Interpretación

La frecuencia de una actividad describe elecciones dentro de Relevo. Para afirmar que una persona caminó, estudió o entrenó se necesita su declaración o una observación externa acordada. Incluso la opción `Comencé la actividad` continúa siendo un autorreporte y debe presentarse como tal.

---

## Registro de cambios (disclaimer)

### 2026-09-22 — Modelo creado

- **Qué cambió:** se definieron unidad de análisis, variables, preguntas, consultas y límites interpretativos.
- **Cómo era antes:** la aplicación registraba eventos técnicos sin una estructura explícita para analizar actividades y respuestas.
- **Por qué se decidió:** evaluar el sistema sin confundir selección, señal y conducta efectivamente realizada.
- **Límite:** el envío remoto requiere configurar el proyecto Supabase y verificarlo con una sesión de prueba.
