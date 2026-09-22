# Detección de uso y registro de datos

## Decisión implementada

La persona elige una aplicación instalada y un intervalo. Mientras el recordatorio está activo, Relevo consulta los eventos de uso de Android una vez por segundo y comprueba si esa aplicación está en primer plano. La señal se emite al completar el tiempo acumulado. Salir de la aplicación pausa el conteo; volver a ella lo retoma.

Este criterio evita confundir tiempo transcurrido con uso efectivo. También acota la observación a una condición comprensible: aplicación elegida, primer plano y duración acumulada desde la activación.

## Qué observa y qué no

Relevo utiliza `UsageStatsManager`, la interfaz oficial de Android para consultar eventos de uso. Android exige que la persona conceda manualmente el acceso especial `PACKAGE_USAGE_STATS`. El monitoreo corre como servicio en primer plano y mantiene una notificación visible.

Se conserva únicamente:

- identificador aleatorio del participante, sin nombre, correo ni teléfono;
- paquete de la aplicación elegida;
- entrada y salida de esa aplicación;
- activación, desactivación, señal y cierre;
- fecha, hora y segundos observados.

No se guarda contenido de pantalla, mensajes, teclas, búsquedas, fotografías, contactos ni historial general. El sistema recibe eventos del dispositivo para identificar el primer plano, pero solo compara y registra la aplicación seleccionada.

## Base de datos local

Los eventos se guardan en `relevo_research.db`, tabla `events`, dentro del almacenamiento privado de la aplicación. Los campos son `session_id`, `participant_code`, `event_type`, `target_package`, `created_at`, `value_seconds` y `consent_version`.

Esta base permite relacionar eventos de una misma sesión sin guardar nombres. Aún no es una base central: los datos no salen del teléfono ni se cruzan entre dispositivos.

## Condiciones para una base remota

Una base remota solo debe incorporarse después de definir por escrito: responsable de los datos; finalidad y variables mínimas; plazo de conservación; personas con acceso; cifrado; forma de retirar el consentimiento y eliminar una sesión; y separación entre códigos y datos identificadores.

Para el testeo inmediato, la opción local es suficiente y reduce exposición innecesaria. Un servicio remoto no mejora la experiencia central de Relevo; solo facilita consolidar resultados, por lo que debe justificarse por la investigación y no por comodidad técnica.

## Comprobación realizada

En un emulador Android se configuró una aplicación objetivo con una condición de cinco segundos. Se usó durante tres segundos, se abandonó y luego se volvió a abrir. El conteo conservó el progreso y, al completar cinco segundos acumulados, el registro pasó de `WAITING` a `SIGNALLED` y marcó una única emisión. La compilación y las pruebas unitarias terminaron correctamente.

## Referencias técnicas

Android Developers. (s. f.). *UsageStatsManager*. https://developer.android.com/reference/android/app/usage/UsageStatsManager

Android Developers. (2026). *Foreground service types are required*. https://developer.android.com/about/versions/14/changes/fgs-types-required

Android Developers. (s. f.). *Declare foreground services and request permissions*. https://developer.android.com/develop/background-work/services/fgs/declare

Android Developers. (s. f.). *Minimize your permission requests*. https://developer.android.com/privacy-and-security/minimize-permission-requests

## Registro de cambios (disclaimer)

### 2026-09-21 — Documento inicial

- **Cambio:** se documentó la detección, el límite de observación, el esquema local y las condiciones previas a cualquier sincronización remota.
- **Versión anterior:** no existía una especificación consolidada para la condición automática ni el tratamiento de sus eventos.
- **Motivo:** hacer verificable el comportamiento técnico y evitar que la recolección exceda la finalidad del testeo.
