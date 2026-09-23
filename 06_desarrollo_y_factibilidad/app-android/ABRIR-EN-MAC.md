# Abrir Relevo en Android Studio desde macOS

Este directorio es un proyecto completo de Android Studio. No es necesario copiar archivos dentro de otro proyecto.

## Opción recomendada: clonar desde GitHub

1. Instala una versión reciente de [Android Studio](https://developer.android.com/studio).
2. En la pantalla inicial elige **Get from VCS**.
3. Usa el repositorio:

   ```text
   https://github.com/joan1542003-byte/proyecto-titulo.git
   ```

4. Cuando termine la descarga, elige **Open** y abre esta carpeta:

   ```text
   06_desarrollo_y_factibilidad/app-android
   ```

5. Acepta la instalación del SDK que Android Studio proponga y espera a que termine **Gradle Sync**.

## Opción alternativa: paquete ZIP

1. Descarga `relevo-android-studio-2.0-2026-09-22.zip` desde la carpeta `releases`.
2. Descomprímelo.
3. En Android Studio elige **Open** y selecciona la carpeta `app-android`.

## Configuración local

Android Studio crea `local.properties` automáticamente con la ubicación del SDK. Para habilitar la sincronización con Supabase, añade al mismo archivo las dos variables descritas en `local.properties.example` y reemplaza sus valores. La clave utilizada por la aplicación es publicable; una clave `service_role` nunca debe colocarse en el proyecto.

Sin estas dos variables la aplicación compila y funciona localmente, pero conserva los registros pendientes en el teléfono.

## Ejecutar

1. Conecta un teléfono Android mediante USB o crea un emulador.
2. Selecciona el módulo `app`.
3. Pulsa **Run**.
4. En el primer inicio, acepta el uso académico, completa el tutorial y concede Tiempo de uso. Las notificaciones son recomendadas.

Si macOS impide ejecutar Gradle desde Terminal, abre una terminal en esta carpeta y ejecuta una sola vez:

```bash
chmod +x gradlew
```

## Comprobación opcional

```bash
./gradlew testDebugUnitTest assembleDebug
```

El APK resultante queda en `app/build/outputs/apk/debug/app-debug.apk`.

---

## Registro de cambios (disclaimer)

### 2026-09-22 — Paquete 2.0

- **Cambio:** la guía apunta al paquete 2.0 y al nombre de carpeta real que contiene el ZIP actual.
- **Antes:** se indicaba el paquete 1.9 y la carpeta `Relevo-Android-Studio`.
- **Motivo:** evitar que la persona abra una versión anterior o busque una carpeta inexistente.

### 2026-09-22 — Preparación para macOS

- **Cambio:** se añadieron instrucciones de clonación, apertura, configuración y ejecución en Android Studio para macOS.
- **Cómo era antes:** el repositorio contenía el proyecto completo, pero la guía de compilación utilizaba rutas de Windows y no explicaba qué carpeta abrir.
- **Motivo:** permitir trasladar el desarrollo al Mac sin copiar archivos manualmente ni incorporar credenciales al repositorio.
