# Android 2.28: el Tag por defecto, lugares concretos y una app más fluida

**Fecha:** 7 de octubre de 2026. **Decisión:** D-117. **Estado:** compilada desde cero, con 85 pruebas unitarias aprobadas. Revisada en el emulador, instalada encima de datos existentes y como persona nueva. **No se ha probado en un teléfono real.** El consentimiento no cambia (v13).

## Qué pidió el autor

- Que el Tag sea la opción por defecto y que siempre aparezca su búsqueda por Bluetooth: elegir el aparato y listo.
- Quitar lugares ambiguos como «en la pieza».
- Que, con el relevo listo, la acción principal sea volver y no desactivar.
- Que la app vaya a 60 cuadros por segundo o más.
- En el panel, ver el tiempo exacto en cada app elegida y tener los perfiles en la barra de navegación (ver el [panel](../panel-admin/README.md)).

## Qué cambia

| Parte | Cambio |
| --- | --- |
| El Tag por defecto | Aparece primero y ya elegido en «¿Dónde suena?», salvo en la semana C, en la que suena el teléfono. Se puede cambiar con un toque. Una salida elegida antes se respeta. |
| Búsqueda automática | Sin un Tag elegido, la búsqueda empieza sola al llegar al paso: pide el permiso de dispositivos cercanos si falta y muestra los Tags cerca. Si no aparece ninguno, vuelve a buscar hasta tres veces. Tocar el Tag lo elige y lo prueba. |
| Lugares concretos | Las sugerencias ya no nombran habitaciones enteras («En tu pieza», «En el living», «En la cocina», «En el comedor»). Ahora son lugares donde se puede dejar el Tag, como «Junto a la cama», «Junto a la tele» o «En el mesón de la cocina». Las rutas guardadas se actualizan solas; lo que la persona escribió no cambia. |
| Relevo listo | La acción principal es «Volver al inicio»; «Desactivar el relevo» queda debajo, como opción secundaria. La ficha muestra «Dónde empiezas» y «Suena» con la salida real; antes decía «Parlante» aunque sonara el Tag. |
| Tiempo en cada app | Al sonar o al desactivar un relevo, la app guarda cuántos segundos pasó en cada app elegida desde que lo activó. Lo calcula con los eventos de Tiempo de uso de Android, como el resto del conteo. |
| Fluidez | Ver la sección siguiente. |

## Fluidez: de 72 % a 6 % de cuadros lentos

Se midió en el emulador, desplazando el Inicio doce veces con `dumpsys gfxinfo`. Como referencia, los Ajustes del sistema, en el mismo emulador, dan 5 % de cuadros lentos y 18 ms de mediana.

| Versión | Cuadros lentos | Mediana por cuadro | Percentil 90 |
| --- | --- | --- | --- |
| 2.27 optimizada, con desenfoques progresivos | 72 % | 53 ms | 93 ms |
| 2.28 optimizada, sin desenfoques progresivos | 6 % | 19 ms | 31 ms |

- **La causa:** los bordes de desplazamiento y la banda de cada tarjeta eran desenfoques progresivos, que se recalculaban en cada cuadro al desplazar. Desde que las actividades usan degradados de color y no fotos (D-111), ese desenfoque casi no se notaba. Ahora son degradados de papel con la misma forma. El vidrio se mantiene donde se nota: la barra de pestañas, los botones flotantes y las hojas.
- **Versión optimizada:** el APK ya no es de depuración. Usa R8 y los perfiles de Compose, y pesa 12 MB en vez de 41 MB. Se firma con la misma clave de las versiones anteriores, así que se instala encima sin perder datos.
- **Frecuencia de pantalla:** la app pide la frecuencia más alta del teléfono (90 o 120 Hz) con la misma resolución. Android puede bajarla para ahorrar batería.
- **Límite:** las cifras son del emulador, que funciona a 60 Hz. En un teléfono real los números serán otros; la mejora relativa es la que importa.

**APK:** [relevo-android-2.28-2026-10-07.apk](releases/relevo-android-2.28-2026-10-07.apk), SHA-256 `9BBDF85E0B30BAE8A6D848F60B8343FAF45B85AC3EA9DB01D9ED00CA5DB8F449` (12,1 MB), versión optimizada (*release*) firmada con la clave de depuración de este computador.

## Registro de cambios (disclaimer)

### 2026-10-07 — Creación

- **Qué se añadió:** la versión 2.28: el Tag por defecto con búsqueda automática, lugares concretos, «Volver al inicio» como acción principal, el tiempo en cada app por relevo y una app más fluida.
- **Cómo estaba antes:** la 2.27 no elegía salida, la búsqueda del Tag se iniciaba con un botón, sugería habitaciones enteras, ponía «Desactivar» como única acción del relevo listo y se entregaba como APK de depuración con desenfoques progresivos.
- **Por qué:** pedido del autor (D-117).
