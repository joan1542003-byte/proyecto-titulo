# Entregables de Android

La versión vigente de trabajo es **2.7**, compilada el 25 de septiembre de 2026 para la prueba de 21 días del [protocolo 02](../../../07_validacion/protocolo-02-prueba-21-dias.md). Los archivos con números anteriores se conservan como antecedentes; no deben mezclarse con la pauta de evaluación actual.

| Archivo | Uso |
| --- | --- |
| [APK 2.7](relevo-android-2.7-2026-09-25.apk) | Instalación interna en un teléfono con Android 12 o posterior. Incluye URL y clave **publicable** de Supabase; es un APK de depuración, no una publicación de tienda. |
| [Proyecto 2.7 para Android Studio](relevo-android-studio-2.7-2026-09-25.zip) | Abrir y continuar el desarrollo en Windows o macOS. No incluye `local.properties`: para sincronizar en otra máquina hay que configurar URL y clave publicable siguiendo `local.properties.example`. |

**SHA-256 del APK 2.7:** `41749D58F292EDDEAC03ED68255C019787CF057CD39155907744E779A78C0944`.

**SHA-256 del ZIP 2.7:** `3B349734D60AF57F514F0AD8D6C7707B416502A0F8E5F1C150E57E6ED73A310E`. Contiene los archivos fuente, la documentación y las capturas de `app-android`; se excluyeron compilados, cachés, `releases` y `local.properties`.

El código compila y pasó 34 pruebas unitarias. En emulador, con datos ficticios, se recorrieron la sesión inicial, una semana en condición «teléfono», las preguntas tras la señal, las tarjetas semanales y el cierre del día 21, y los registros llegaron a Supabase ([detalle](../version-2.7-prueba-21-dias-2026-09-25.md)). Faltan el teléfono de la prueba, el parlante Bluetooth y el borrado sin conexión. El [consentimiento](../../../07_validacion/consentimiento-android-vigente-2026-09-23.md) y la [pauta](../../../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) siguen en revisión: el APK no debe entregarse a participantes antes de esas comprobaciones.

**Antecedente 2.6:** APK `8AA57837E74DC1B30711E9D52A1859365F0CAB6F702E811354C42831D1CEC3B3`; ZIP `85A573FA9A7F31B385B6680955093AA1434658D7223E22F373E404C10AEBB420`.

## Registro de cambios (disclaimer)

### 2026-09-25 — Entrega Android 2.7

- **Qué cambió:** el índice señala el APK y el proyecto 2.7, con sus huellas y lo comprobado en emulador.
- **Cómo era antes:** apuntaba a 2.6, con el envío de eventos y el borrado sin probar.
- **Por qué:** la prueba técnica del protocolo 02 necesita la versión 2.7 y saber qué se verificó.

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
