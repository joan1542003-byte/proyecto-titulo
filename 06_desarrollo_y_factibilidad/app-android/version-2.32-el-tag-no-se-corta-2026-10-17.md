# Android 2.32: el Tag no se corta con la alarma encendida

**Fecha:** 17 de octubre de 2026. **Decisión:** D-137. **Estado:** compilada desde cero en versión optimizada, con 86 pruebas unitarias aprobadas y la misma firma de las anteriores. En el emulador se instaló sobre datos existentes y se revisaron la guía del Tag y una prueba sin Tag; la desconexión diferida se dejó correr 100 s sin cierres. **No se probó con un Tag real**, porque el emulador no tiene Bluetooth. El consentimiento no cambia (v13).

Es la 2.31 con otra forma de manejar la conexión. La interfaz sigue siendo la de la 2.30, con el ícono y el logo de la línea 3.0. El código está en la rama `android-2.32`, que sale de `android-2.31`. El mismo cambio está en `main`, sobre la 3.2.

## El reporte

La participante de la 2.31 contó que, cuando el Tag pasa mucho tiempo sin usarse y la app lo hace sonar, en la prueba o en un relevo, suena lento y repetido («tutututu»). Solo para si abre el Tag y lo vuelve a cerrar. Dice que nunca ha encontrado el botón del Tag.

## Qué mostró el registro de la 2.31

- **Pila:** marca 75 % en reposo y 50 % justo después de pitar. Es lo normal en una pila CR2032 a media carga, no una pila agotada.
- **Patrón de las pruebas malas:** pasan en la primera conexión después de mucho rato (al día siguiente, o después de dos horas de relevo). En ellas, el Tag no confirmó las órdenes a tiempo (`boton=no`, `alarma_desconexion=sin_apagar`) y la app tuvo que abrir otra conexión (`apagado=reconnected`).
- **Pitido normal no escuchado:** a las 00:13 del 17 de octubre, la persona dijo dos veces que no escuchó el pitido normal, una vez con cada nivel.

## La causa más probable

1. Después de mucho rato quieto, el Tag tarda más en responder.
2. La 2.31 esperaba 1,5 s cada respuesta. Si no llegaba a tiempo, daba la orden por fallida y no alcanzaba a confirmar que la alarma por desconexión estuviera apagada.
3. Para callar el Tag, la 2.31 cortaba la conexión y abría otra.
4. Cortar la conexión con esa alarma encendida es justo lo que la hace sonar. En este modelo no para al volver a conectarse: solo para al reiniciar el Tag sacándole la pila.

Es la explicación que mejor calza con el registro. No se reprodujo con su Tag.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Nunca cortar con la alarma encendida | La app solo desconecta cuando el Tag confirmó, en esa conexión, que FFE2 y la alarma por desconexión están en 0. Si no lo confirma, mantiene la conexión e insiste cada 15 s durante 10 minutos; solo después desconecta igual. |
| Insistir en vez de reconectar | Para callar el Tag, o si la señal no recibe respuesta, la app insiste en la conexión abierta hasta 25 s. Solo abre otra si la conexión ya se perdió. Una conexión abierta con el mismo Tag ya no se corta por responder lento. |
| Más paciencia | Espera hasta 6 s cada respuesta, en vez de 1,5 s, y 3 s para las órdenes que se repiten mientras suena. Si Android sigue ocupado con una orden anterior, espera y la vuelve a intentar. Una respuesta atrasada ya no confirma una orden distinta. |
| Conexión rápida | Al conectar y antes de hacerlo sonar, la app pide una conexión rápida, que despierta al Tag. Mientras el relevo espera, vuelve a la normal para no gastar la pila. |
| Lo primero al conectar | Lo primero es apagar la alarma por desconexión, antes que la alerta estándar o cualquier lectura. |
| Después de una prueba | La conexión queda abierta 90 s. Así, probar de nuevo no abre otra, y cada conexión nueva es un riesgo. |
| Señal | Espera hasta 30 s para conectar o para que un Tag lento responda, en vez de 20 s. |
| Guía del Tag | Explica que el botón no se ve: es el centro de la cara de arriba, y al apretarlo firme se siente un clic. Si suena lento y sin parar, hay que sacarle la pila unos segundos. |
| Registro | `prueba_de_sonido` suma `respuesta_ms`, la respuesta más lenta del Tag en esa conexión, y `conexion=nueva` o `abierta`. El panel avisa cuando el Tag tardó más de 1,5 s, y su versión de referencia pasa a 2.32. |

## Verificación

- **Compilación:** desde cero, en versión optimizada y de depuración, con 86 pruebas unitarias. La 3.2 de `main`, con el mismo cambio, también compila y pasa las pruebas.
- **Firma:** la misma clave de siempre (`fdbe6bbe…`), con `versionCode` 47, así que se instala encima de la 2.31 y de la 3.2.
- **Emulador:**
  - Se respaldaron los datos del autor y se activó el modo avión.
  - La 2.32 se instaló sobre la 3.2 con datos.
  - La guía muestra el texto nuevo del botón.
  - Una prueba con un Tag simulado falló como debía («No lo encontramos»), sin cierres, a los 54 s.
  - Se esperaron 100 s más para la desconexión diferida, sin errores.
  - Al final se volvió a la 3.2 y los datos del autor quedaron idénticos (MD5).
- **No probado:** con el Tag real, después de horas sin uso, la señal completa ni la conexión que espera 10 minutos.

**APK:** [relevo-android-2.32-2026-10-17.apk](releases/relevo-android-2.32-2026-10-17.apk), SHA-256 `F5D4209327ACC55FBB8F3B3C686F5CCF1B17FFD0F4CE121D854052D337A42751` (12,1 MB).

## Para la participante

1. Instalar la 2.32 encima de la 2.31, sin desinstalar.
2. Si el Tag está sonando, sacarle la pila unos segundos y volver a ponerla.
3. Para descartar la pila, conviene una CR2032 nueva.
4. El botón es el centro de la cara de arriba: se aprieta firme hasta sentir un clic. Un toque calla el pitido; mantenerlo 3 s apaga el Tag.

## Límites

- Si el Tag deja de responder del todo, Android termina cortando la conexión por su cuenta, y la alarma puede sonar igual. La app solo puede evitar los cortes que hace ella.
- Mantener la conexión hasta 10 minutos gasta algo más de pila, pero solo pasa cuando el Tag no confirmó la alarma apagada.

## Registro de cambios (disclaimer)

### 2026-10-17 — Creación

- **Qué se añadió:** la versión 2.32: nunca cortar la conexión con la alarma encendida, más paciencia con un Tag lento, conexión rápida, guía del botón y registro de la demora.
- **Cómo estaba antes:** la 2.31 esperaba 1,5 s cada respuesta y, para callar el Tag, cortaba la conexión y abría otra.
- **Por qué:** reporte de una participante, transmitido por el autor (D-137).
