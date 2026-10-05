# Android 2.19: el llavero iTag como objeto que suena

**Fecha:** 5 de octubre de 2026. **Decisión:** D-109. **Estado:** compilada desde cero y con 81 pruebas unitarias aprobadas. La pantalla del llavero se probó en emulador, que no tiene un llavero: **la conexión y el pitido no se han probado con un llavero real**. El consentimiento no cambia (v11).

## Qué pidió el autor

Comprar un llavero iTag, en MercadoLibre si había uno compatible, y actualizar la app para que lo haga sonar, solo si se le podía asegurar que funciona.

## Qué se puede asegurar

- **El protocolo está verificado.** El iTag clásico, el que se configura con la app iSearching, pita con el servicio estándar de Bluetooth «Alerta inmediata»: 2 en «Nivel de alerta» lo enciende y 0 lo apaga. Así lo hace la app de código abierto [iTag](https://github.com/s4ysolutions/itag), publicada en Google Play, y lo confirman otros análisis independientes ([objetos que suenan](../objetos-que-suenan-2026-09-29.md), sección 1). Relevo envía la misma orden.
- **Lo que falta es probar un llavero real.** Sin el llavero no se pudo comprobar la conexión, el pitido, el botón ni el apagado de su alarma por desconexión. Un modelo que no se configure con iSearching puede no responder.
- **Cómo se reduce el riesgo:** comprar un llavero cuyo anuncio diga «iSearching», probarlo apenas llegue con los pasos de abajo y usar la protección de compra de MercadoLibre si no responde.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Salida «El llavero» | Cuarta forma de avisar, junto al parlante, el reloj y el teléfono. En las semanas A y B de la prueba se mantiene, como el reloj; en la C suena el teléfono. |
| `TagProtocol` (nuevo) | Identificadores del iTag: alerta inmediata (`0x1802`, `0x2A06`), servicio propio (`0xFFE0`), botón (`0xFFE1`), interruptor de la alarma por desconexión (`0xFFE2`) y pérdida de enlace estándar (`0x1803`). La señal dura 30 s: seis pitidos de 2 s separados por 3 s. La prueba es un pitido de 2 s. |
| `TagLink` (nuevo) | Busca el llavero, se conecta y lo hace pitar. Antes de conectarse lo busca para que Android sepa qué tipo de dirección usa, reintenta una vez si Android falla al conectar y comprueba que el aparato acepte la orden de pitar. Al conectarse apaga la alarma que el llavero hace sonar cuando pierde la conexión, de las dos formas conocidas, y pide los avisos del botón. Hace una operación de Bluetooth a la vez. |
| `TagStore` (nuevo) | Guarda en el teléfono la dirección y el nombre del llavero elegido. No se envían a la base. |
| `SignalPlayer` | Con el llavero, enciende y apaga el pitido según la señal. Si se aprieta el botón del llavero, la señal se calla («silencio en el objeto»). Si el llavero no responde, el teléfono vibra y avisa; nunca cambia de salida sin decirlo. |
| `AppUsageMonitorService` | Al activar un relevo con llavero, abre la conexión y la mantiene mientras espera; si se corta, la reabre cada 30 s. Al terminar, apaga el pitido y desconecta. Si no lo encuentra, la notificación dice «No se encontró el llavero. Abre Relevo para revisarlo.». |
| Preparar un relevo | Opción «El llavero» con su panel: cómo encenderlo, «Buscar el llavero», la lista «Llaveros cerca» con la distancia en palabras, «Probar el llavero» y «Elegir otro llavero». Antes del permiso explica para qué es. Si el Bluetooth está apagado, ofrece encenderlo y, al encenderse, retoma la búsqueda. Si no aparece ningún llavero, ofrece «Ver todos los aparatos cercanos», por si se anuncia con otro nombre; un aparato que no acepta la orden de pitar no queda elegido. «Seguir» y «Activar el relevo» piden elegir el llavero antes. |
| Registro | La sesión guarda `signal_route = 'tag'`. Si se calla con el botón, `signal_end = 'object'` y el evento `silenced_object`. Uso de la app: `llavero_busqueda`, `llavero_encontrados`, `llavero_vinculado`, `llavero_olvidado` y la prueba de sonido con su resultado, sin el nombre del aparato. El estado del teléfono suma si hay permiso de dispositivos cercanos y si hay un llavero elegido. |
| Permisos | `BLUETOOTH_SCAN`, declarado sin uso de ubicación, y `BLUETOOTH_CONNECT`. Se piden solo al buscar o probar el llavero. |
| Supabase | Migración `relevo_2_19_llavero`: amplía los valores permitidos de `signal_route`, `signal_end` y `event_type`, sin tocar filas. También al final de `base-remota-supabase.sql`. |

## Lo que se comprobó en el emulador

Sin red y con un respaldo de los datos del emulador, que se devolvieron al terminar:

- **Panel:** al elegir «El llavero» aparecen las instrucciones, «Buscar el llavero» y la nota del permiso.
- **Permiso:** «Buscar el llavero» abrió el diálogo de Android de dispositivos cercanos.
- **Bluetooth apagado:** apareció «Bluetooth apagado» con «Encender Bluetooth»; el diálogo de Android lo encendió y la búsqueda empezó sola. En una primera prueba el aviso seguía visible con el Bluetooth ya encendido; se corrigió.
- **Sin llaveros:** después de 12 s, «No apareció ningún llavero» con «Ver todos los aparatos cercanos». La búsqueda de respaldo terminó sin aparatos, como corresponde a un emulador.
- **Campo faltante:** «Seguir» sin llavero mostró «Busca y elige tu llavero, o elige otra forma de avisar.».
- Sin cierres inesperados en el registro de Android.

Capturas en [`capturas/interfaz-2.19`](capturas/interfaz-2.19).

## Lo que falta comprobar con el llavero

1. Que aparezca en la búsqueda, se conecte y pite 2 s al elegirlo.
2. Que un relevo de 15 segundos lo haga pitar seis veces y que el botón lo calle.
3. Que no pite al terminar el relevo ni al alejarse, es decir, que se haya apagado su alarma por desconexión.
4. Que siga conectado durante una espera larga y que se reconecte si se aleja y vuelve.
5. Un teléfono con Android 12, que usa otra forma de recibir los avisos del botón.

## Cómo probarlo cuando llegue

1. **Pila nueva:** el llavero usa una CR2032. Conviene tener una de repuesto.
2. **Encenderlo:** mantener apretado el botón 3 segundos, hasta que pite dos veces. No conectarlo a iSearching o, si se probó con esa app, cerrarla: el llavero acepta una conexión a la vez.
3. **En Relevo:** Preparar › Te avisa › «El llavero» › «Buscar el llavero» › tocarlo en la lista. Debe pitar 2 s y mostrar «Así va a sonar…».
4. **Un relevo corto:** en «Te avisa después de», «Probar con 15 segundos»; activar, abrir una de las apps elegidas y esperar. Debe pitar seis veces en 30 s; apretar el botón debe callarlo.
5. **Al terminar:** cerrar el relevo y alejarse con el teléfono. El llavero no debería pitar.
6. **Si no pita en el paso 3:** probar con la app gratuita nRF Connect: conectar el llavero y escribir `02` en *Immediate Alert* › *Alert Level*. Si así pita, el error es de Relevo y se puede corregir; si tampoco pita, es otro modelo y conviene devolverlo.

## Compra

Publicaciones de MercadoLibre Chile que indican la app iSearching (precios de los resultados de búsqueda del 5 de octubre; las páginas piden iniciar sesión y no se abrieron, así que pueden haber cambiado):

- [Llavero localizador antipérdida Bluetooth iTag](https://articulo.mercadolibre.cl/MLC-1376482113-llavero-localizador-anti-perdida-conexion-bluetooth-itag-_JM): CLP 5.930, pila CR2032.
- [Localizador rastreador iTag Bluetooth con llavero](https://articulo.mercadolibre.cl/MLC-2478783150-localizador-rastreador-itag-bluetooth-con-llavero-android-_JM): CLP 7.990, incluye pila.
- [Mini llavero rastreador iTag, negro](https://www.mercadolibre.cl/mini-llavero-rastreador-itag-localizador-gps-bluetooth-celular-color-negro/p/MLC32345367): precio no visible en la búsqueda.

Conviene comprar dos, por si uno llega fallado.

## Privacidad y prueba de 21 días

- La dirección del llavero queda solo en el teléfono y el permiso se declara sin uso de ubicación. La búsqueda de respaldo muestra los nombres de los aparatos cercanos solo en pantalla; no se guardan.
- Usar el llavero en la prueba de 21 días es una decisión pendiente del autor, como el reloj. Si se usa, el consentimiento escrito debería nombrarlo y hay que revisarlo con el profesor.

**APK:** [relevo-android-2.19-2026-10-05.apk](releases/relevo-android-2.19-2026-10-05.apk), SHA-256 `6CAE525B4313FB43B51A2CF81B8CA9776DACD2EE3E637D7B6E9DDEEB20CE757B` (41,3 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-05 — Creación

- **Qué se añadió:** la versión 2.19, con la salida «El llavero», su conexión, su panel en preparar, el registro y la migración de Supabase, las pruebas en emulador, los pasos para probarlo al llegar y las publicaciones para comprarlo.
- **Cómo estaba antes:** la 2.18 sonaba en un parlante, un reloj o el teléfono; el llavero estaba estudiado desde el 29 de septiembre, pero no integrado.
- **Por qué:** el autor decidió comprar un iTag y pidió que la app lo haga sonar (D-109).
