# Verificación previa de la aplicación Android

**Fecha prevista:** 22 de septiembre de 2026

**Versión:** `relevo-android-1.5-2026-09-22.apk`

**Propósito:** impedir que un fallo de software se confunda con una dificultad de comprensión.

## Verificación técnica completada

- compilación de pruebas unitarias y APK: correcta;
- instalación y apertura en emulador Android: correctas;
- navegación entre Inicio y configuración: correcta;
- Source Sans 3 cargada desde recursos locales: correcta;
- conteo con Ajustes en primer plano durante dos segundos: correcto;
- cambio automático de `WAITING` a `SIGNALLED`: correcto;
- notificación final: recibida con actividad y forma de comenzar;
- canal de alarma: creado con sonido del sistema y vibración.

Las comprobaciones que siguen corresponden a la revisión manual previa en el teléfono y no se sustituyen con este ensayo técnico.

## Datos del ensayo

- teléfono y modelo:
- versión de Android:
- salida de audio: teléfono / parlante Bluetooth:
- persona que verifica:
- hora de inicio y término:

## Recorrido principal

| Comprobación | Resultado | Observación o corrección |
|---|---|---|
| Instala y abre sin conexión a internet | Pendiente | |
| Permite escribir actividad y cómo comenzar | Pendiente | |
| Permite elegir una espera | Pendiente | |
| Conserva los datos al volver y editar | Pendiente | |
| Impide continuar con datos obligatorios vacíos | Pendiente | |
| Permite declarar el lugar | Pendiente | |
| Reproduce y detiene la señal de prueba | Pendiente | |
| Exige confirmar percepción antes de activar | Pendiente | |
| Activa el recordatorio de forma explícita | Pendiente | |
| Muestra el tiempo restante | Pendiente | |
| Permite desactivar durante la espera | Pendiente | |
| Emite una sola señal al terminar el tiempo | Pendiente | |
| Permite silenciar de inmediato | Pendiente | |
| Cierra sin preguntar si la actividad se realizó | Pendiente | |
| Permite iniciar un nuevo recordatorio | Pendiente | |

## Recuperaciones prioritarias

| Estado | Cómo provocarlo | Resultado esperado | Resultado |
|---|---|---|---|
| Datos incompletos | dejar vacío un campo | la acción principal permanece deshabilitada o explica qué falta | Pendiente |
| Salida antes de activar | elegir «Salir sin activar» | no se programa ninguna señal | Pendiente |
| Audio bajo o silenciado | reducir el volumen antes de probar | la persona puede ajustar y repetir la prueba | Pendiente |
| Señal no percibida | elegir «Ajustar» | no permite activar hasta repetir y confirmar | Pendiente |
| Desactivación voluntaria | desactivar durante la espera | cierra el ciclo y no emite después | Pendiente |
| Cierre de la aplicación | cerrarla durante la espera y volver a abrir | recupera el recordatorio y recalcula el tiempo | Pendiente |
| Señal activa | mantener la aplicación elegida en primer plano durante el intervalo | reproduce una señal y ofrece silencio | Aprobado en emulador; pendiente en teléfono real |
| Nuevo ciclo | cerrar y preparar otro | elimina el estado anterior y vuelve al comienzo | Pendiente |

## Prueba repetida

Ejecutar tres ciclos consecutivos con una condición de 15 segundos de uso continuo. Deben producir exactamente tres señales, una por ciclo. Salir antes de completar el intervalo debe reiniciar el conteo. Una señal duplicada o posterior a una desactivación se considera un fallo crítico.

## Regla de decisión

La aplicación queda habilitada para una prueba guiada solo cuando todas las filas del recorrido principal estén aprobadas y ningún fallo crítico permanezca abierto. Las observaciones menores deben conservarse para la siguiente versión, pero no pueden alterar los datos recogidos durante una sesión ya iniciada.

## Registro de cambios (disclaimer)

### 2026-09-21 — Creación

- **Cambio:** se creó una verificación específica para instalación, recorrido, recuperaciones y señal única.
- **Versión anterior:** el plan incluía criterios de aceptación, pero no una ficha ejecutable para el teléfono de la sesión.
- **Motivo:** separar fallos técnicos de problemas de comprensión antes de cualquier participación.
- **Alcance:** la ficha permanece sin resultados hasta ser aplicada en un teléfono Android real.
