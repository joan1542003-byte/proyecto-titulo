# Entregables de Android

La versión más reciente es **2.9**, compilada el 27 de septiembre de 2026. Lleva la interfaz al estilo de iOS 26: pantalla completa, vidrio con desenfoque sutil en la capa de navegación, cápsulas y esquinas amplias, emoji 3D de Google en el perfil y textos más naturales (D-083). No cambia la lógica ni los datos de la 2.8 ([detalle](../version-2.9-vidrio-y-emoji-2026-09-27.md)). La **2.7** es la versión que especifica el [protocolo 02](../../../07_validacion/protocolo-02-prueba-21-dias.md); el autor debe decidir cuál se usa en la prueba. Los archivos con números anteriores se conservan como antecedentes; no deben mezclarse con la pauta de evaluación actual.

| Archivo | Uso |
| --- | --- |
| [APK 2.9](relevo-android-2.9-2026-09-27.apk) | Instalación interna en un teléfono con Android 12 o posterior. Incluye URL y clave **publicable** de Supabase; es un APK de depuración, no una publicación de tienda. Se instala sobre la 2.8 o la 2.7 sin pedir de nuevo el consentimiento. |
| [Proyecto 2.9 para Android Studio](relevo-android-studio-2.9-2026-09-27.zip) | Abrir y continuar el desarrollo en Windows o macOS. No incluye `local.properties`: para sincronizar en otra máquina hay que configurar URL y clave publicable siguiendo `local.properties.example`. |
| [APK 2.8](relevo-android-2.8-2026-09-26.apk) y [proyecto 2.8](relevo-android-studio-2.8-2026-09-26.zip) | Perfil, ruta y aviso de regreso con el sistema D-073, sin vidrio. |
| [APK 2.7](relevo-android-2.7-2026-09-25.apk) y [proyecto 2.7](relevo-android-studio-2.7-2026-09-25.zip) | La versión del protocolo 02, sin perfil ni ruta. |

**SHA-256 del APK 2.9:** `CCD3ED64FF294F1836D50C9CEE5E9D88501FA70CB037D33F37FF082C75362969`.

**SHA-256 del ZIP 2.9:** `454CED861A9D60CD6CECDAD55300AE97196BED2F3887C2D346CDE1136AB1D796`. Contiene los archivos fuente, la documentación, las capturas y las imágenes exploradas de `app-android` (260 archivos); se excluyeron compilados, cachés, `releases` y `local.properties`.

El APK 2.9 salió de una compilación limpia y el código pasó 50 pruebas unitarias. En emulador, con datos ficticios, se recorrieron la primera vez, el perfil con emoji, la ruta, la preparación, un ciclo completo con la señal y la respuesta, las hojas de vidrio y el tema oscuro ([detalle](../version-2.9-vidrio-y-emoji-2026-09-27.md)). Faltan el teléfono de la prueba, el parlante Bluetooth y el borrado sin conexión. El [consentimiento](../../../07_validacion/consentimiento-android-vigente-2026-09-23.md) y la [pauta](../../../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) siguen en revisión: el APK no debe entregarse a participantes antes de esas comprobaciones.

**Antecedente 2.8:** APK `BAD37330B2C1DFF6E536DCAFD8BBCD9CB7818557CDB034A5086578C60571BB29`; ZIP `CB935EC3FB9E48F7A2CC0E7076A4AB3F78454F55EBF8331986503F63624EAFD5`. Compiló y pasó 47 pruebas unitarias ([detalle](../version-2.8-rediseno-perfil-y-ruta-2026-09-26.md)).

**Antecedente 2.7:** APK `95965E024596BC45F5F8BCF79D7536336791B88D6B5D19211AD7E9D53A1712C8`; ZIP `618120BAE7B9D26B76BC9DF6B50C4764CB932949AA20CF250073A5CF7B9C57F0`. Compiló y pasó 34 pruebas unitarias; en emulador se recorrieron la sesión inicial, una semana en condición «teléfono», las preguntas tras la señal, las tarjetas semanales y el cierre del día 21 ([detalle](../version-2.7-prueba-21-dias-2026-09-25.md)).

**Antecedente 2.6:** APK `8AA57837E74DC1B30711E9D52A1859365F0CAB6F702E811354C42831D1CEC3B3`; ZIP `85A573FA9A7F31B385B6680955093AA1434658D7223E22F373E404C10AEBB420`.

## Registro de cambios (disclaimer)

### 2026-09-27 — Entrega Android 2.9

- **Qué cambió:** el índice señala el APK y el proyecto 2.9, con sus huellas y lo comprobado en emulador; la 2.8 queda como antecedente, con sus huellas.
- **Cómo era antes:** apuntaba a 2.8 como versión más reciente.
- **Por qué:** el autor pidió la 2.9 (D-083) y debe decidir qué versión se usa en la prueba.

### 2026-09-26 — Entrega Android 2.8

- **Qué cambió:** el índice señala el APK y el proyecto 2.8, con sus huellas y lo comprobado en emulador; la 2.7 queda como la versión del protocolo 02, con sus huellas como antecedente.
- **Cómo era antes:** apuntaba a 2.7 como versión vigente.
- **Por qué:** el autor pidió la 2.8 y debe decidir cuál de las dos se usa en la prueba.

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
