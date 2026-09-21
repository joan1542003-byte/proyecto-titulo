# Aplicación Android de Relevo

Primera aplicación Android instalable para comprobar el recorrido de preparación, activación, señal y cierre de Relevo.

## Estado

**Versión:** 1.0 de prueba  
**Fecha:** 21 de septiembre de 2026  
**Identificador:** `cl.udp.relevo`  
**Android mínimo:** 8.0, API 26  
**APK:** [relevo-prueba-2026-09-21.apk](releases/relevo-prueba-2026-09-21.apk)

La compilación y las pruebas unitarias terminaron correctamente. El APK aún debe instalarse y revisarse en el teléfono Android que se utilizará en la sesión.

## Qué permite hacer

1. escribir una actividad;
2. precisar una forma concreta de comenzar;
3. elegir una espera de 15 segundos, 1 minuto o 5 minutos;
4. revisar lo configurado;
5. declarar el lugar donde quedará la señal;
6. reproducir y detener una señal de prueba;
7. confirmar que la señal fue percibida;
8. activar y desactivar el recordatorio;
9. recibir una sola señal al terminar la espera;
10. silenciar y cerrar sin registrar cumplimiento;
11. preparar un nuevo recordatorio;
12. conservar el ciclo activo si la aplicación se cierra y vuelve a abrir.

## Alcance de esta versión

La aplicación prueba el recorrido y su comprensión. La condición es un temporizador local y la señal sale por el canal de audio de Android. Si el teléfono está conectado a un parlante Bluetooth, el sistema operativo puede dirigir allí el sonido.

Esta versión no detecta el uso de otras aplicaciones, no controla un rastreador comercial, no utiliza cuentas ni internet y no demuestra todavía el funcionamiento del objeto físico final.

## Instalación en el teléfono

### Opción directa

1. copiar el APK al teléfono Android;
2. abrirlo desde Descargas o Archivos;
3. autorizar temporalmente la instalación desde esa fuente si Android lo solicita;
4. instalar y abrir Relevo;
5. devolver el permiso de instalación a su estado anterior después de completar la instalación.

### Opción mediante ADB

Con depuración USB habilitada y el teléfono conectado:

```powershell
D:\AndroidSdk\platform-tools\adb.exe install -r releases\relevo-prueba-2026-09-21.apk
```

## Comprobación anterior a la sesión

El [ensayo técnico en emulador](ensayo-emulador-2026-09-21.md) completó el recorrido y permitió corregir dos bloqueos de estado. Antes de utilizar otro equipo, seguir [la matriz de verificación](verificacion-previa-2026-09-22.md). La aplicación no debe utilizarse con participantes si no permite preparar, probar, activar, percibir, silenciar y cerrar el recordatorio en el teléfono elegido.

## Compilación local

Requisitos comprobados en este equipo:

- Android Studio 2026.1.4.7;
- JDK incluido con Android Studio;
- Android SDK 36 y Build Tools 36;
- Gradle Wrapper 9.1.0.

Desde esta carpeta:

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
$env:ANDROID_HOME='D:\AndroidSdk'
$env:RELEVO_BUILD_DIR='D:\AndroidBuild'
.\gradlew.bat :app:testDebugUnitTest :app:assembleDebug --no-configuration-cache
```

`RELEVO_BUILD_DIR` evita bloqueos de archivos temporales causados por la sincronización de OneDrive. No modifica el código ni el contenido del APK.

## Estructura relevante

- `domain/Reminder.kt`: estados y reglas del ciclo;
- `data/ReminderStore.kt`: persistencia local;
- `signal/SignalPlayer.kt`: sonido y vibración de prueba;
- `ui/RelevoViewModel.kt`: temporizador y coordinación del estado;
- `ui/RelevoApp.kt`: recorrido de nueve momentos;
- `theme/`: colores y tema visual vigente;
- `releases/`: APK identificable para instalación;
- `verificacion-previa-2026-09-22.md`: control anterior a la sesión.

## Integridad del APK

SHA-256:

```text
15920D2301885DF322C6E28540575501CBE94FBD8FCF6FDE334586DD8F208B5F
```

## Registro de cambios (disclaimer)

### 2026-09-21 — Primera versión instalable

- **Cambio:** se creó una aplicación Android nativa con nueve momentos, persistencia local, temporizador, señal, cierre y pruebas unitarias del ciclo.
- **Versión anterior:** el repositorio disponía de wireframes y criterios de validación, pero no de una aplicación Android compilable.
- **Motivo:** disponer de un material funcional para comprobar el recorrido antes de integrar la condición automática y el objeto físico definitivo.
- **Alcance:** compilación y pruebas unitarias aprobadas; instalación, prueba en un teléfono real y resultados con participantes todavía pendientes.
