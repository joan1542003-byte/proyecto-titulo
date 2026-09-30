# Android 2.18: registro completo, relevos que se pueden eliminar y avisos de campos faltantes

**Fecha:** 30 de septiembre de 2026. **Decisión:** D-097. **Estado:** compilada desde cero y con 75 pruebas unitarias aprobadas. Probada en emulador con conexión, pero no en un teléfono real. El consentimiento pasa a `2026-09-30-v11` y falta la revisión docente.

## Qué pidió el autor

Registrar todo lo de cada participante (apps elegidas, uso y configuración) y tenerlo almacenado; poder eliminar un relevo activo, y que la app avise cuando falta completar un campo en vez de no hacer nada.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| `DailyUsage` (nuevo) | Calcula el uso de cada día con los eventos de Tiempo de uso de Android: segundos y aperturas por app y tiempo total de pantalla. Dos entradas a la misma app con menos de 5 segundos de diferencia cuentan como una apertura. Las pantallas de inicio y la interfaz del sistema no suman al total. El tiempo deja de contar cuando la pantalla se apaga, se bloquea o el teléfono se apaga. |
| `ResearchLogStore` | Base local versión 9 con la tabla `daily_usage` (día, app, nombre, segundos, aperturas). Entra en la copia, la exportación y el borrado. |
| `StateSnapshot` (nuevo) | Reúne el estado del teléfono en un registro: perfil sin el nombre (imagen e intereses), ruta, actividades propias, ajustes, activación automática, permisos, fabricante, modelo y versión de Android, relevo en curso, último relevo, prueba y apps elegidas alguna vez. |
| `RemoteSync` | Cada 30 minutos como máximo, al sincronizar: recalcula el uso de ayer y hoy (y de los días que falten, hasta 14), envía el estado solo si cambió y sube el uso pendiente. La primera vez incluye los 7 días anteriores como línea base. El borrado incluye las dos tablas nuevas. |
| Inicio y relevo activo | «Ver, desactivar o eliminar» lleva al relevo activo, que suma «Eliminar este relevo». Una hoja pregunta «¿Eliminar este relevo?» y explica que deja de contar, no sonará y no queda en tus relevos. En la base queda con `outcome = 'deleted'` y el evento `relevo_eliminado`. |
| `GuardedButton` (nuevo) | Botón que dice qué falta. Si falta algo, se ve apagado pero responde: muestra encima un aviso neutro con el ícono de información y vibra. Si se vuelve a tocar, el aviso crece un instante. Se usa en preparar un relevo, el consentimiento, el perfil, la ruta, las actividades, las opiniones, los reportes y la prueba. |
| Registro de avisos | `falta_completar` guarda el paso y el aviso («paso=usage;aviso=Elige al menos una app que cuente.»), una vez cada 10 segundos si se repite. |
| Consentimiento en la app | «Qué guardamos» y «Qué no vemos» suman el uso diario, el tiempo total del teléfono desde 7 días antes, el modelo y los permisos, y aclaran que de las demás apps no se guarda el nombre. |
| Supabase | Migración `relevo_state_usage_and_deleted`: tablas `relevo_participant_state` y `relevo_daily_usage`, con reglas para que cada teléfono solo lea, escriba y borre lo suyo, y el resultado `deleted` permitido en `relevo_sessions`. También al final de `base-remota-supabase.sql`. |

## Avisos de campos faltantes

| Paso | Aviso |
| --- | --- |
| Qué quieres hacer | «Escribe qué quieres hacer o toca una idea.» |
| Cómo empiezas | «Escribe cómo empiezas: lo primero que harías.» |
| Dónde empiezas | «Escribe dónde empiezas.» |
| Apps | «Falta el permiso de Tiempo de uso. Tócalo arriba para darlo.» o «Elige al menos una app que cuente.» |
| Consentimiento | «Marca «Acepto participar durante 21 días» para seguir.» |

Los demás formularios (perfil, ruta, actividades, opiniones, reportes y secuencia de la prueba) usan avisos del mismo tipo.

## Lo que se comprobó en el emulador

Con un usuario de prueba nuevo (código EMU-TEST):

- **Estado:** llegó a `relevo_participant_state` con sus diez partes: perfil, ruta, actividades propias, ajustes, permisos, equipo, último relevo, relevo actual, prueba y apps elegidas.
- **Uso diario:** llegaron filas del 23 al 30 de septiembre, con el tiempo total y Chrome, la app elegida. El emulador tiene la pantalla siempre encendida, así que su total quedó entre 21 y 24 horas diarias; en un teléfono la pantalla se apaga y el total baja.
- **Aviso de campo faltante:** con la actividad vacía, «Seguir» mostró «Escribe qué quieres hacer o toca una idea.».
- **Eliminar un relevo activo:** un relevo que se activó solo al abrir Chrome se eliminó a los 7 segundos. La sesión quedó con `outcome = 'deleted'` y la app volvió a Inicio sin relevo activo.
- **Borrar mis datos:** otro usuario de prueba envió su estado, 11 filas de uso diario y 3 eventos. Perfil › Tus datos › Borrar mis datos los dejó en cero en Supabase, y la app mostró «Tus datos se borraron y saliste del proyecto».

En una prueba en el emulador, siete toques seguidos en el paso de apps dejaron siete registros en cuatro segundos. Por eso la compilación final registra uno cada 10 segundos y agranda el aviso al tocar de nuevo; estos dos ajustes compilaron y pasaron las pruebas, pero no se miraron en pantalla. Tampoco se pudo probar el corte por pantalla bloqueada, porque el emulador no se bloquea.

Después se borraron de Supabase las filas de los usuarios de prueba y se devolvieron al emulador sus datos anteriores.

## Límites

- No se probó en un teléfono real. El tiempo se calcula con los eventos de Android y puede diferir de Bienestar digital.
- La línea base depende de cuántos días guarde Android sus eventos. En el emulador estaban los 7 días; en otros teléfonos puede haber menos.
- Hay más datos personales que antes, sobre todo el tiempo total de pantalla por día. Hay que revisarlo con el profesor antes de reclutar.
- Los relevos eliminados no cuentan en el panel, pero quedan en la base para el análisis.

**APK:** [relevo-android-2.18-2026-09-30.apk](releases/relevo-android-2.18-2026-09-30.apk), SHA-256 `4D4BABD9D1AB66A93AD9F012B72AD42999DAC0B8F2F4040C5A8D7AF0882F1B49` (41,1 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-09-30 — Creación

- **Qué se añadió:** la versión 2.18, con uso diario, estado del teléfono, relevos activos que se pueden eliminar, avisos de campos faltantes y consentimiento v11, y las pruebas en emulador.
- **Cómo estaba antes:** en la 2.17 el uso de las apps se registraba solo alrededor de cada señal, un relevo activo solo se podía desactivar y «Seguir» no decía qué faltaba.
- **Por qué:** pedido del autor (D-097).
