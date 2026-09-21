# Aplicación Android de Relevo

Prototipo funcional para preparar una intención, elegir una aplicación y emitir una señal cuando esa aplicación permanece en primer plano durante el tiempo definido.

## Estado

**Versión:** 1.1 de prueba

**Fecha:** 21 de septiembre de 2026

**Identificador:** `cl.udp.relevo`

**Android mínimo:** 8.0, API 26

**APK vigente:** [relevo-uso-aplicaciones-2026-09-21.apk](releases/relevo-uso-aplicaciones-2026-09-21.apk)

La aplicación compila, sus pruebas unitarias pasan y la condición automática fue comprobada en Android: al mantener la aplicación elegida en primer plano durante el tiempo configurado, el recordatorio cambia a señal emitida.

## Qué permite hacer

1. escribir una actividad y una forma concreta de comenzar;
2. elegir una aplicación instalada;
3. definir 15 segundos, 1 minuto o 5 minutos de uso acumulado;
4. autorizar el acceso de uso exigido por Android;
5. registrar un código seudónimo y aceptar el tratamiento local informado;
6. situar y probar la señal;
7. activar un monitoreo visible mediante una notificación persistente;
8. emitir una sola señal cuando se cumple la condición;
9. pausar el conteo si la persona sale de la aplicación y retomarlo cuando vuelve;
10. desactivar, silenciar y cerrar el ciclo.

## Límites

Relevo reconoce qué aplicación está en primer plano, pero no lee mensajes, imágenes, búsquedas ni contenidos. Los eventos de prueba permanecen en una base SQLite dentro del teléfono. No existe sincronización remota ni un repositorio central de participantes en esta versión.

La señal se reproduce mediante Android. Si el teléfono está conectado a un parlante Bluetooth, Android puede dirigir el audio al parlante. La integración directa con un objeto físico independiente sigue siendo una etapa posterior.

## Instalación y permiso

1. instalar el APK;
2. abrir Relevo;
3. pulsar **Abrir ajustes de acceso** en la pantalla de condición;
4. autorizar Relevo en **Acceso de uso**;
5. regresar y pulsar **Ya lo autoricé**.

Android muestra una notificación mientras el recordatorio está activo. Esta visibilidad comunica que existe observación en curso y no debe eliminarse.

## Datos de prueba

La estructura y sus límites están descritos en [detección de uso y datos](arquitectura-deteccion-uso-y-datos-2026-09-21.md). Para pruebas académicas se debe usar un código como `P01`; nunca el nombre de la persona. Antes de una base remota se deben aprobar responsable, plazo de conservación, acceso y procedimiento de eliminación.

## Compilación

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
$env:ANDROID_HOME='D:\AndroidSdk'
$env:RELEVO_BUILD_DIR='D:\AndroidBuild'
.\gradlew.bat :app:testDebugUnitTest :app:assembleDebug --no-configuration-cache
```

## Estructura relevante

- `domain/Reminder.kt`: estados y condiciones del ciclo;
- `monitor/AppUsageMonitorService.kt`: observación visible del primer plano;
- `monitor/UsageAccess.kt`: comprobación del permiso;
- `data/ResearchLogStore.kt`: eventos seudónimos en SQLite;
- `data/ReminderStore.kt`: estado local del recordatorio;
- `signal/SignalPlayer.kt`: sonido y vibración;
- `ui/RelevoViewModel.kt`: coordinación;
- `ui/RelevoApp.kt`: recorrido reducido a inicio, configuración, estado activo y señal.

## Registro de cambios (disclaimer)

### 2026-09-21 — Condición automática por aplicación

- **Cambio:** el temporizador pasivo fue reemplazado por la selección de una aplicación y la medición de uso acumulado en primer plano.

### 2026-09-21 — Simplificación del recorrido

- **Cambio:** nueve pantallas fueron reducidas a cuatro momentos y toda la configuración quedó reunida en una sola vista.
- **Versión anterior:** el recorrido separaba formulación, condición, revisión, ubicación, prueba y activación.
- **Motivo:** reducir carga, evitar repeticiones y hacer visible desde el inicio qué hace Relevo.
- **Versión anterior:** la señal aparecía después de una espera, sin reconocer el uso de otras aplicaciones.
- **Motivo:** hacer comprobable la relación central de Relevo entre el uso prolongado de una aplicación elegida y una señal situada.
- **Privacidad:** se incorporaron consentimiento explícito, código seudónimo, notificación persistente y almacenamiento local limitado.
