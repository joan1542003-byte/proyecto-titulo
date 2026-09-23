# ¿Puede sonar solo Relevo en un parlante Bluetooth?

**Estado:** análisis técnico documental, sin cambio de aplicación ni prueba física. **Fecha:** 23 de septiembre de 2026. **Necesidad planteada:** la persona conecta el objeto; YouTube, Instagram y el resto del sonido del teléfono permanecen en el teléfono; solo la señal de Relevo suena en el objeto, que permanece silencioso hasta entonces. El vínculo debe resultar sencillo para quien participa.

## Respuesta breve

**Sí se puede lograr esa experiencia, pero no se puede prometer de forma universal con cualquier parlante Bluetooth multimedia al conectarlo normalmente.** En Android, conectar un parlante de audio suele convertirlo en la salida disponible para el sonido multimedia del teléfono. La app puede pedir que *su propia pista* se dirija a ese parlante mediante `AudioTrack.setPreferredDevice`; esa petición no cambia la ruta de audio de YouTube, Instagram u otras apps. Además, Android advierte que el dispositivo preferido no garantiza el destino efectivo y recomienda consultar la ruta real durante la reproducción ([AudioRouting](https://developer.android.com/reference/android/media/AudioRouting), [MediaRouter](https://developer.android.com/reference/android/media/MediaRouter)).

El [prototipo Android vigente](app-android/README.md) ya busca una salida A2DP o LE Audio, solicita esa ruta para su `AudioTrack` y verifica `routedDevice` antes y durante el tono ([SignalPlayer.kt](app-android/app/src/main/java/com/example/relevo/signal/SignalPlayer.kt)). Esto intenta evitar que **el tono de Relevo** salga por el teléfono. No configura ni controla las demás apps. Tampoco se ha verificado todavía con teléfono y parlante físicos; la documentación de la app reconoce ese límite.

## Tres vías distintas

| Vía | ¿Qué consigue? | Pasos para la persona | Límite principal |
| --- | --- | --- | --- |
| Parlante multimedia Bluetooth corriente + código actual | Relevo puede enviar su tono al parlante y comprobar su propia ruta. | Emparejar y conectar el parlante; probar el tono. | YouTube o Instagram pueden usar el mismo parlante como salida multimedia predeterminada. No cumple por sí sola la separación exigida. |
| Función **Separate app sound** de algunos Samsung Galaxy | Permite escoger una app para el parlante Bluetooth y mantener la salida principal del teléfono en el propio teléfono. | Conectar el parlante; entrar a *Ajustes → Sonidos y vibración → Separate app sound*; elegir Relevo y el parlante; dejar la salida principal en el teléfono; verificar ambas rutas. | Es una función del fabricante, no una capacidad disponible ni idéntica en todos los Android. Samsung indica que el dispositivo elegido debe ser diferente de la salida principal. Requiere configuración adicional y ensayo con el modelo exacto ([Samsung](https://www.samsung.com/uk/support/mobile-devices/useful-audio-settings-on-the-galaxy-phone-including-separate-app-sound/)). |
| Objeto que recibe una **orden BLE** y genera localmente su tono | El teléfono intercambia datos de control, no audio multimedia; por diseño, otras apps no tienen una ruta de reproducción a ese objeto. | Vincular el objeto desde Relevo una vez; confirmar conexión y probar señal. | Requiere un dispositivo programable o un producto con protocolo de control documentado, además de resolver reconexión, batería, volumen y silencio. El [programa de mesa con micro:bit V2](prueba-microbit-ble/README.md) ya ejemplifica la orden `activar`, pero no constituye aún un producto físico ni una prueba con participantes. Android admite el intercambio BLE y el emparejamiento de dispositivos acompañantes ([BLE](https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview), [Companion Device Manager](https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing)). |

**Importante:** BLE como transporte de una orden corta no es lo mismo que un «parlante LE Audio». Un parlante LE Audio también es una salida multimedia y conserva el problema de separación si Android lo selecciona para el resto del teléfono ([tipos de dispositivos de audio Android](https://developer.android.com/reference/android/media/AudioDeviceInfo)).

## Recomendación según el objetivo de la prueba

Para una **demostración controlada de corto plazo**, un Galaxy compatible con *Separate app sound* puede permitir la escena deseada sin construir otro dispositivo; el investigador debe preparar y comprobar la configuración antes de la sesión. No conviene presentar ese recorrido como facilidad universal de Relevo.

Si el requisito es que **cualquier participante conecte fácilmente el objeto y el teléfono conserve su audio habitual**, la arquitectura más coherente es un objeto de señal que reciba una orden BLE y produzca sonido localmente. El vínculo inicial podría apoyarse en la interfaz de emparejamiento de Android para dispositivos acompañantes; aun así, Android aclara que esa interfaz no establece por sí sola una conexión permanente. Su facilidad real solo se conocerá al ensayar permisos, emparejamiento, reconexión y silenciamiento con el material concreto. Esto también permite incorporar la luz que exige la ruta phygital posterior.

## Comprobación mínima antes de afirmarlo ante participantes

1. Conectar el dispositivo y dejarlo en reposo: no debe emitir tono de Relevo ni sonidos propios inesperados de conexión que se confundan con la señal.
2. Reproducir un video con audio en YouTube y otro contenido con audio en Instagram: anotar si suenan en el teléfono y si el objeto permanece silencioso. Las rutas pueden variar entre apps, modelos y ajustes.
3. Disparar la señal de Relevo con la otra app en primer plano: comprobar que solo el objeto emite el tono previsto y que el audio del teléfono no se traslada ni se pierde de manera no prevista.
4. Probar volumen, silencio, pérdida de conexión, reconexión, otra salida Bluetooth cercana y retorno después de apagar el objeto. Registrar modelo de teléfono, versión Android, modelo de dispositivo, ajustes y resultado de cada caso.
5. Si cualquiera de los casos falla, describirlo como limitación técnica del montaje; no atribuir a la persona un fallo de comprensión o de asociación. La [pauta de testeo actual](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) ya exige comprobar la ruta antes de convocar.

No hay una prueba física registrada que confirme hoy la separación de audio. La conclusión es una lectura de las interfaces oficiales y del código existente, no una certificación del comportamiento de un teléfono concreto.

## Referencias técnicas

- Android Developers. (s. f.). *AudioRouting*. https://developer.android.com/reference/android/media/AudioRouting
- Android Developers. (s. f.). *AudioDeviceInfo*. https://developer.android.com/reference/android/media/AudioDeviceInfo
- Android Developers. (s. f.). *Bluetooth Low Energy*. https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview
- Android Developers. (s. f.). *Companion device pairing*. https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing
- Android Developers. (s. f.). *MediaRouter*. https://developer.android.com/reference/android/media/MediaRouter
- Samsung. (2021, 25 de mayo). *Useful audio settings on the Galaxy phone including Separate app sound*. https://www.samsung.com/uk/support/mobile-devices/useful-audio-settings-on-the-galaxy-phone-including-separate-app-sound/

---

## Registro de cambios (disclaimer)

### 2026-09-23 — Análisis inicial

- **Cambio:** se distinguió el enrutamiento de la pista de Relevo del enrutamiento de otras apps y se compararon parlante multimedia, ajuste Samsung y objeto controlado por BLE.
- **Antes:** la documentación exigía probar una «ruta exclusiva» sin explicar qué exclusividad podía y no podía proporcionar Android.
- **Motivo:** responder a la necesidad de una conexión simple donde la señal situada no reciba el ocio digital del teléfono.
- **Alcance y límites:** investigación técnica y criterios de verificación; no se modificaron la app, el dispositivo ni los resultados de validación.
