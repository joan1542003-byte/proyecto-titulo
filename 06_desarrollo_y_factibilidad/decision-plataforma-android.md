---
id: DES-PLATAFORMA-2026-08-25
titulo: "Decisión de plataforma inicial: Android"
fecha_de_corte: 2026-08-25
estado: "decisión de alcance vigente"
---

# Decisión de plataforma inicial: Android

## Pregunta

¿La capa digital inicial de Relevo debe desarrollarse como aplicación Android, aplicación web progresiva o aplicación para iPhone?

## Decisión

Android será la única plataforma del primer prototipo técnico integrado. La web se descarta como capa operativa y iPhone queda fuera del alcance de esta etapa. La decisión acota recursos y dependencias antes de comprobar el aporte del testigo físico; no establece que Android sea universalmente superior ni que las otras plataformas sean incompatibles con una evolución futura.

## Criterios

La plataforma debe permitir, dentro de un mismo entorno de prueba:

1. configurar una intención, un primer paso y una condición observable;
2. consultar localmente actividad autorizada si la condición elegida lo requiere;
3. comunicarse con un testigo mediante Bluetooth Low Energy (BLE);
4. ejecutar y recuperar estados cuando la interfaz no permanece visible;
5. documentar permisos, restricciones, vencimiento y fallos;
6. reducir el número de arquitecturas que deben construirse antes de validar el valor físico.

## Comparación

| Alternativa | Capacidad documentada | Límite para el prototipo | Decisión |
| --- | --- | --- | --- |
| Android nativo | `UsageStatsManager` permite consultar historial y estadísticas de uso con autorización especial concedida por la persona. Android documenta rutas para buscar, asociar y comunicarse con periféricos BLE en segundo plano. | Permisos, ciclo de vida del proceso, batería, restricciones de segundo plano y diferencias entre dispositivos impiden prometer funcionamiento universal. | Seleccionada como plataforma inicial. |
| Web o aplicación web progresiva | Puede configurar información y comunicarse con BLE en algunos navegadores compatibles. | Web Bluetooth exige un contexto seguro, autorización y una acción iniciada por la persona; la compatibilidad no es uniforme y WebKit declara que no implementa Web Bluetooth. En las fuentes consultadas no se identificó una capacidad web equivalente a `UsageStatsManager`. | Descartada como capa operativa del prototipo. Podría reconsiderarse como interfaz auxiliar. |
| iPhone mediante aplicación nativa | Apple ofrece Device Activity y Family Controls para actividad de aplicaciones y sitios bajo autorizaciones y capacidades específicas; Core Bluetooth permite comunicarse con accesorios. | Requiere una segunda implementación nativa, otros permisos y reglas de ejecución. Duplicaría el frente técnico antes de validar la relación intención–lugar–testigo. | Fuera del alcance del prototipo actual; su integración se considera plausible, no demostrada. |

## Justificación

Android concentra las capacidades que Relevo podría necesitar para probar una condición basada en actividad autorizada y enviar un comando al testigo mediante BLE. `UsageStatsManager` no interpreta intención, automatismo ni valor del ocio: solo ofrece datos de uso bajo un permiso especial. Del mismo modo, las rutas documentadas para BLE en segundo plano no garantizan una conexión persistente; deben comprobarse en un teléfono, versión y configuración registrados (Google, s. f.-a, s. f.-b, s. f.-c).

Una interfaz web tendría distribución más amplia, pero alcance global de acceso no equivale a funcionamiento global del sistema. Web Bluetooth depende del navegador y de una interacción explícita, mientras WebKit declara que no implementa esa API. La web puede resolver formularios o configuración, pero no ofrece una base suficientemente uniforme para la operación completa planteada en esta etapa (Chrome for Developers, s. f.; WebKit, s. f.).

La integración con iPhone es técnicamente plausible, pero no está demostrada para Relevo. Apple dispone de marcos para actividad del dispositivo y comunicación BLE; incorporarlos obliga a desarrollar y validar una arquitectura paralela con autorizaciones y restricciones propias. Excluir iPhone es una decisión metodológica y de recursos: primero debe demostrarse que Relevo aporta valor como sistema phygital en un entorno acotado (Apple Developer, s. f.-a, s. f.-b, s. f.-c).

## Consecuencias

- Los prototipos conceptuales P0–P2 pueden simular la activación y no dependen de Android.
- P3 utilizará Android como banco técnico documentado.
- Cuando se retome el desarrollo de wireframes, estos representarán una aplicación móvil Android sin prometer compatibilidad multiplataforma.
- No se construirá una web operativa ni una aplicación iOS durante el prototipo inicial.
- La condición de activación continúa abierta; seleccionar Android no decide entre continuidad, acumulación u horario.
- Una expansión futura requerirá volver a evaluar arquitectura, recursos, privacidad y compatibilidad después de demostrar el aporte físico.

## Referencias

Apple Developer. (s. f.-a). *Core Bluetooth*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/CoreBluetooth

Apple Developer. (s. f.-b). *Device Activity*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/DeviceActivity

Apple Developer. (s. f.-c). *Family Controls App and Website Usage*. Recuperado el 25 de agosto de 2026, de https://developer.apple.com/documentation/bundleresources/entitlements/com.apple.developer.family-controls.app-and-website-usage

Chrome for Developers. (s. f.). *Communicating with Bluetooth devices over JavaScript*. Recuperado el 25 de agosto de 2026, de https://developer.chrome.com/docs/capabilities/bluetooth

Google. (s. f.-a). *Communicate in the background*. Android Developers. Recuperado el 25 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/ble/background

Google. (s. f.-b). *Companion device pairing*. Android Developers. Recuperado el 25 de agosto de 2026, de https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing

Google. (s. f.-c). *UsageStatsManager*. Android Developers. Recuperado el 25 de agosto de 2026, de https://developer.android.com/reference/android/app/usage/UsageStatsManager

WebKit. (s. f.). *Tracking prevention in WebKit*. Recuperado el 25 de agosto de 2026, de https://webkit.org/tracking-prevention/

---

## Registro de cambios (disclaimer)

### 2026-08-25 — Creación

- **Cambio:** se documentó la comparación entre Android, web e iPhone y se seleccionó Android para el prototipo inicial.
- **Versión anterior:** Android aparecía como plataforma provisional, pero no existía una justificación comparativa ni un registro explícito de las alternativas descartadas.
- **Motivo:** acotar el desarrollo técnico a una arquitectura verificable antes de invertir recursos en compatibilidad multiplataforma.
- **Alcance:** la decisión no fija la condición de activación, no garantiza funcionamiento en segundo plano y no declara inviables la web o iPhone para etapas posteriores.
