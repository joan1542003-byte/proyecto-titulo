# Entregables de Android

La versión vigente de trabajo es **2.6**, compilada el 24 de septiembre de 2026. Los archivos con números anteriores se conservan como antecedentes; no deben mezclarse con la pauta de evaluación actual.

| Archivo | Uso |
| --- | --- |
| [APK 2.6](relevo-android-2.6-2026-09-24.apk) | Instalación interna en un teléfono con Android 12 o posterior. Incluye URL y clave **publicable** de Supabase; es un APK de depuración, no una publicación de tienda. |
| [Proyecto 2.6 para Android Studio](relevo-android-studio-2.6-2026-09-24.zip) | Abrir y continuar el desarrollo en Windows o macOS. No incluye `local.properties`: para sincronizar en otra máquina hay que configurar URL y clave publicable siguiendo `local.properties.example`. |

**SHA-256 del APK 2.6:** `8AA57837E74DC1B30711E9D52A1859365F0CAB6F702E811354C42831D1CEC3B3`.

**SHA-256 del ZIP 2.6:** `85A573FA9A7F31B385B6680955093AA1434658D7223E22F373E404C10AEBB420`. Se creó a partir de los archivos fuente de esta versión, con documentación y capturas 2.6; se excluyeron compilados, APK anteriores y `local.properties`.

El código compila y pasó diez pruebas unitarias sin fallos. Se inspeccionaron primer inicio, tutorial, Inicio y preparación con dos apps en emulador; no se completó un ciclo ni se comprobó la salida Bluetooth con equipo físico. La base remota contiene sesiones, pero no eventos, de modo que el envío de eventos y la eliminación solicitada aún requieren prueba aislada. El [consentimiento](../../../07_validacion/consentimiento-android-vigente-2026-09-23.md) y la [pauta](../../../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) siguen en revisión: el APK no debe entregarse a participantes antes de esas comprobaciones.

## Registro de cambios (disclaimer)

### 2026-09-24 — Entrega Android 2.6

- **Qué cambió:** el índice señala el APK y el proyecto 2.6, añade huellas verificadas, configuración de la base y estado de pruebas.
- **Cómo era antes:** apuntaba a 2.5, siete pruebas unitarias y capturas parciales de esa versión.
- **Por qué:** distinguir la descarga vigente de antecedentes y no presentar compilación como validación con personas o hardware.

### 2026-09-23 — Paquete portable comprobado

- **Qué cambió:** se añadió la huella del ZIP y se documentó su origen y exclusiones.
- **Cómo era antes:** el índice anunciaba el paquete, pero aún no tenía una huella para comparar la descarga.
- **Por qué:** permitir verificar integridad y no confundir el proyecto fuente con archivos locales o versiones anteriores.

### 2026-09-23 — Índice de entregables

- **Qué cambió:** se creó un punto de entrada para distinguir la versión vigente de las descargas anteriores, con huella del APK y alcance de su verificación.
- **Cómo era antes:** la carpeta contenía varias versiones sin un índice que indicara cuál correspondía a la documentación actual.
- **Por qué:** facilitar una instalación controlada y evitar que una compilación se confunda con un prototipo ya validado con participantes.
