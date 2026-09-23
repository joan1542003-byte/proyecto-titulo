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

## Vigencia y versiones del ajuste Samsung

*Separate app sound* **es una función real de Samsung**: el fabricante la presentó para Galaxy S8/S8+ en 2017 ([Samsung Newsroom, agosto de 2017](https://news.samsung.com/in/all-that-you-need-to-know-about-galaxy-s8s-audio-features)). Estos modelos salieron con **Android 7.0** ([ficha de lanzamiento Samsung](https://news.samsung.com/es/samsung-presenta-samsung-galaxy-s8-un-smartphone-sin-limites)). Esto establece que la función existía **al menos en esos modelos y esa generación de software**; no implica que todos los teléfonos con Android 7.0, ni todos los Samsung posteriores, la ofrezcan. Era anterior a la marca One UI, por lo que tampoco existe una «primera versión de One UI» aplicable a su origen.

Samsung [continúa explicando el ajuste en su soporte oficial consultado en septiembre de 2026](https://www.samsung.com/us/support/answer/ANS10002549/): *Ajustes → Sonidos y vibración → Sonido de aplicación independiente* (*Separate app sound*), elegir aplicación y dispositivo de audio Bluetooth. Su existencia actual en una guía no certifica disponibilidad en un modelo, región o versión específicos. Para Relevo, comprobar el menú en el Galaxy concreto, seleccionar Relevo como única app enviada al parlante y dejar la salida multimedia general en el teléfono; luego verificar con YouTube/Instagram y la señal real. La configuración solo separa rutas de audio cuando el dispositivo elegido difiere de la salida principal; no certifica que dos apps reproduzcan simultáneamente sin intervención del sistema de audio.

### ¿Está en **todos** los Samsung lanzados desde septiembre de 2020?

**No se puede afirmar eso y la evidencia oficial ofrece una excepción documental.** Se revisaron manuales del Galaxy **A03 Core** (lanzado en diciembre de 2021), una variante Android Go. Sus manuales oficiales para [Android 11](https://downloadcenter.samsung.com/content/UM/202111/20211123132843738/SM-A032F_UM_ASIA_RR_Eng_Rev.1.0_211117.pdf), [Android 12](https://downloadcenter.samsung.com/content/UM/202212/20221209134116129/SM-A032F_UM_ASIA_SS_Eng_Rev.1.0_221110.pdf) y [Android 13](https://downloadcenter.samsung.com/content/UM/202310/20231006114058019/SM-A032F_UM_ASIA_TT_Eng_Rev.1.0_230817.pdf) describen el menú **Sounds and vibration** pero no enumeran *Separate app sound* ni contienen una sección para configurarlo. El [lanzamiento oficial de Samsung](https://news.samsung.com/in/samsung-launches-galaxy-a03-core-in-india-will-strengthen-poweringdigitalindia-initiative) confirma fecha y plataforma Android Go. La [página de soporte de ese modelo](https://www.samsung.com/africa_en/support/model.SM-A032FZBAAFA/) enlaza una FAQ genérica sobre *Separate app sound*, pese a que sus manuales específicos no lo documentan; ese enlace no es una prueba de compatibilidad. La ausencia en tres manuales específicos impide dar este modelo por compatible; sin un A03 Core físico, tampoco se afirma que todas sus variantes de firmware carezcan del ajuste.

La función sí figura expresamente en manuales oficiales de equipos posteriores, por ejemplo [Galaxy S23 FE, manual revisado en 2024](https://images.samsung.com/is/content/samsung/assets/fr/support/warranty/refurbished-devices-information-warranty/s23-fe-sm-s711b-um-eu-uu-eng-rev-1-1-240417.pdf) y [Galaxy Z Fold6, manual de 2024](https://images.samsung.com/is/content/samsung/assets/fr/support/warranty/refurbished-devices-information-warranty/z-fold-6-sm-f956b-ug-eu-uu-eng-rev-1-1-240814.pdf). Esos mismos manuales advierten que algunas funciones dependen del modelo. La página de soporte que Samsung mantiene en 2026 demuestra vigencia de la función en su catálogo, **no cobertura de todos los modelos fabricados entre 2020 y 2026**. Un inventario exhaustivo exigiría enumerar variantes regionales, firmware y versiones de cada equipo; no se ha hecho una verificación física de ese universo. Para la compra del parlante y la investigación de Relevo, el criterio operativo sigue siendo **modelo exacto y prueba real de rutas antes de usar el montaje**.

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
- Samsung Newsroom. (2017, 17 de agosto). *All That You Need to Know About Galaxy S8’s Audio Features*. https://news.samsung.com/in/all-that-you-need-to-know-about-galaxy-s8s-audio-features
- Samsung Newsroom. (2017, 29 de marzo). *Samsung presenta Samsung Galaxy S8: un smartphone sin límites*. https://news.samsung.com/es/samsung-presenta-samsung-galaxy-s8-un-smartphone-sin-limites
- Samsung Support. (consulta: 2026-09-23). *Sounds, vibrations, and notifications on your Galaxy phone or tablet*. https://www.samsung.com/us/support/answer/ANS10002549/
- Samsung Newsroom. (2021, 6 de diciembre). *Samsung Launches Galaxy A03 Core in India*. https://news.samsung.com/in/samsung-launches-galaxy-a03-core-in-india-will-strengthen-poweringdigitalindia-initiative
- Samsung. (2021, 2022, 2023). *Galaxy A03 Core (SM-A032F), user manuals for Android 11–13*. https://www.samsung.com/africa_en/support/model.SM-A032FZBAAFA/
- Samsung. (2024). *Galaxy S23 FE (SM-S711B), user manual*. https://images.samsung.com/is/content/samsung/assets/fr/support/warranty/refurbished-devices-information-warranty/s23-fe-sm-s711b-um-eu-uu-eng-rev-1-1-240417.pdf
- Samsung. (2024). *Galaxy Z Fold6 (SM-F956B), user manual*. https://images.samsung.com/is/content/samsung/assets/fr/support/warranty/refurbished-devices-information-warranty/z-fold-6-sm-f956b-ug-eu-uu-eng-rev-1-1-240814.pdf

---

## Registro de cambios (disclaimer)

### 2026-09-23 — Verificación de la afirmación «todos los Samsung de los últimos seis años»

- **Cambio:** se compararon tres manuales oficiales del A03 Core de 2021 con manuales posteriores que sí documentan el ajuste y se explicitó que la guía general de 2026 no prueba cobertura universal.
- **Antes:** constaba la advertencia de compatibilidad por modelo, pero no un contraejemplo documental dentro de 2020–2026.
- **Motivo:** evitar que la recomendación de compra dependa de que cualquier Samsung reciente tenga la función.
- **Alcance y límites:** revisión de documentos, no inventario exhaustivo de modelos, regiones y firmware ni ensayo físico de los teléfonos citados.

### 2026-09-23 — Fecha de origen y vigencia documentada de Samsung

- **Cambio:** se añadieron fuentes primarias de 2017 y la guía de soporte vigente para precisar desde cuándo consta la función y qué no permite inferir sobre compatibilidad universal.
- **Antes:** se citaba una guía de 2021 sin distinguir la fecha de origen ni el vínculo entre versión Android y modelo Galaxy.
- **Motivo:** responder a la duda sobre si el ajuste existe todavía y desde qué versiones puede acreditarse.
- **Alcance y límites:** evidencia documental; no se ha probado el modelo de teléfono del test.

### 2026-09-23 — Análisis inicial

- **Cambio:** se distinguió el enrutamiento de la pista de Relevo del enrutamiento de otras apps y se compararon parlante multimedia, ajuste Samsung y objeto controlado por BLE.
- **Antes:** la documentación exigía probar una «ruta exclusiva» sin explicar qué exclusividad podía y no podía proporcionar Android.
- **Motivo:** responder a la necesidad de una conexión simple donde la señal situada no reciba el ocio digital del teléfono.
- **Alcance y límites:** investigación técnica y criterios de verificación; no se modificaron la app, el dispositivo ni los resultados de validación.
