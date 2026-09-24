# Entregables de Android

La versión vigente de trabajo es **2.5**, compilada el 23 de septiembre de 2026. Los archivos con números anteriores se conservan como antecedentes; no deben mezclarse con la pauta de evaluación actual.

| Archivo | Uso |
| --- | --- |
| [APK 2.5](relevo-android-2.5-2026-09-23.apk) | Instalación interna en un teléfono con Android 12 o posterior. Es un APK de depuración, no una publicación de tienda. |
| [Proyecto 2.5 para Android Studio](relevo-android-studio-2.5-2026-09-23.zip) | Abrir y continuar el desarrollo en Windows o macOS; no incluye `local.properties` ni credenciales privadas. |

**SHA-256 del APK 2.5:** `39F82AFE36A88A068903181795565BBC51C0EDAD14C9FE3A57F04F740B008083`.

El código compila y pasó siete pruebas unitarias. Se inspeccionaron consentimiento y tutorial en emulador, pero el recorrido completo y la salida de audio todavía deben comprobarse en el teléfono y parlante concretos. El [consentimiento](../../../07_validacion/consentimiento-android-vigente-2026-09-23.md) y la [pauta](../../../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) siguen en revisión: el APK no debe entregarse a participantes hasta comprobar la eliminación local y remota y resolver la corrección académica.

## Registro de cambios (disclaimer)

### 2026-09-23 — Índice de entregables

- **Qué cambió:** se creó un punto de entrada para distinguir la versión vigente de las descargas anteriores, con huella del APK y alcance de su verificación.
- **Cómo era antes:** la carpeta contenía varias versiones sin un índice que indicara cuál correspondía a la documentación actual.
- **Por qué:** facilitar una instalación controlada y evitar que una compilación se confunda con un prototipo ya validado con participantes.
