# Ensayo técnico en emulador Android

> **Registro histórico:** este ensayo corresponde a la versión con espera temporal. La comprobación vigente de detección automática está documentada en `arquitectura-deteccion-uso-y-datos-2026-09-21.md`.

**Fecha:** 21 de septiembre de 2026  
**Entorno:** teléfono virtual medio, Android 16, API 36  
**Aplicación:** `cl.udp.relevo`, versión 1.0 de prueba  
**Tipo de ensayo:** comprobación técnica interna, sin participantes

## Resultado

La aplicación se instaló, abrió y completó el recorrido principal de nueve momentos. Se utilizó la actividad «Salir a caminar», el comienzo «Ponerme las zapatillas», el lugar «Junto a las zapatillas» y una espera de 15 segundos.

| Comprobación | Resultado | Evidencia |
|---|---|---|
| Instalación del APK | Aprobada | `adb install -r` devolvió `Success`. |
| Inicio de la aplicación | Aprobada | actividad iniciada en frío sin excepción. |
| Formulación | Aprobada | actividad y forma de comenzar ingresadas. |
| Condición temporal | Aprobada | espera de 15 segundos seleccionada. |
| Revisión | Aprobada tras corrección | los datos se conservaron y el recorrido avanzó. |
| Situación | Aprobada | lugar ingresado antes de probar la señal. |
| Prueba de señal | Aprobada en software | señal iniciada y continuidad habilitada después de confirmar percepción. |
| Activación | Aprobada tras corrección | transición explícita a recordatorio activo. |
| Espera | Aprobada | cuenta regresiva visible desde 12 segundos durante la observación. |
| Señal única | Aprobada | transición a «Señal emitida» al terminar la espera. |
| Silencio y cierre | Aprobada | transición a la novena pantalla sin preguntar por cumplimiento. |
| Excepciones de ejecución | No observadas | no apareció `FATAL EXCEPTION` en el registro revisado. |

## Fallos encontrados y corregidos

### El lugar se exigía antes de solicitarlo

La primera instalación impedía salir de «Revisar» porque la regla de preparación incluía el lugar, aunque el lugar se solicita en la pantalla siguiente. Se separaron los datos preparados de los datos completos para activar. Se añadió una prueba unitaria que conserva este orden.

### Escribir el lugar devolvía el ciclo a borrador

Después de completar el lugar, la aplicación cambiaba el estado a borrador y la acción de activar no producía la espera. Se corrigió la transición para mantener el estado preparado cuando ya existen actividad, comienzo y condición.

## Verificaciones automatizadas

Ocho pruebas unitarias aprobaron las siguientes reglas:

- un recordatorio incompleto no queda preparado;
- la revisión puede preceder a la definición del lugar;
- un recordatorio completo puede activarse;
- una activación calcula su vencimiento;
- la señal solo puede entregarse una vez;
- desactivar impide una señal posterior;
- cerrar elimina el vencimiento;
- un ciclo cerrado no se rearma por sí solo.

## Pendiente antes de la sesión

- instalar el mismo APK en el teléfono Android que se utilizará;
- comprobar sonido, volumen y vibración en ese equipo;
- comprobar la salida por parlante Bluetooth si formará parte del material;
- ejecutar la ficha de verificación previa completa;
- repetir la desactivación y el cierre de la aplicación durante la espera en el equipo real.

## Registro de cambios (disclaimer)

### 2026-09-21 — Ensayo inicial

- **Cambio:** se registraron la instalación virtual, el recorrido completo, dos fallos corregidos y los pendientes de hardware real.
- **Versión anterior:** existían criterios y pruebas unitarias, pero no un recorrido ejecutado de principio a fin en Android.
- **Motivo:** comprobar comportamiento real de la aplicación y conservar los límites de lo observado.
- **Alcance:** el resultado solo corresponde al emulador; no constituye una prueba con participantes ni verifica audio, Bluetooth o persistencia en el teléfono de la sesión.
