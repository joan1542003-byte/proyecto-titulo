# Android 2.31: el Tag se calla siempre

**Fecha:** 14 de octubre de 2026. **Decisión:** D-134. **Estado:** compilada desde cero en su versión optimizada, con 86 pruebas unitarias aprobadas y la misma firma de las anteriores. En el emulador se instaló sobre datos existentes y se revisaron la pantalla de inicio, el logo, el ícono y la línea de la pila. **No se probó con un Tag real:** el emulador no tiene Bluetooth, así que el arreglo se verificó leyendo el código y compilando. El consentimiento no cambia (v13).

Es la 2.30 del primer testeo, con su misma interfaz, más el arreglo del Tag, la lectura de la pila y el ícono y el logo de la línea 3.0. Su código está en la rama `android-2.31`, que sale de la 2.30 (`4db9a99`). El mismo arreglo quedó en `main`, sobre la 3.2.

## El reporte

Una participante del primer testeo, con la app 2.30, contó dos problemas:

- Al probar el sonido, el Tag siguió pitando después de los 3 segundos de la prueba.
- Unos minutos después de dejar la app, empezó un sonido más apagado que no se detuvo hasta que abrió el Tag.

## Qué mostró el registro

Su registro en Supabase, revisado sin copiar su nombre ni su código al repositorio, mostró esto:

| Momento | Lo que registró la app |
| --- | --- |
| 13 de octubre, noche | Dos pruebas correctas (`orden=si`, `boton=si`, `alarma_desconexion=apagada`), y la persona dijo que escuchó el pitido. |
| 14 de octubre, 00:19 | La señal del relevo empezó en el Tag y se cortó a los 3 segundos (`signal_interrupted`). |
| 14 de octubre, 01:23 | Una prueba no logró conectarse (`orden=no`). |
| 14 de octubre, 01:31 y 01:32 | Dos pruebas correctas; la app se cerró segundos después. |

Su Tag publica el servicio de batería (`180f:2a19`), la alarma por desconexión estándar (`1803`) y FFE2 solo con escritura con respuesta.

## La causa

Android atiende una sola orden de Bluetooth a la vez. Si el Tag no responde a una orden, Android puede seguir ocupado y rechazar las siguientes. En la 2.30 eso tenía cuatro efectos:

1. **La señal se cortaba sola.** Tres órdenes sin respuesta seguidas cuentan como corte. Fue lo que pasó a las 00:19, a los 3 segundos.
2. **La orden de callar fallaba sin aviso.** La app no revisaba si había llegado, así que el Tag podía quedar pitando con FFE2 en 1.
3. **La desconexión no esperaba.** La app desconectaba y cerraba en el mismo instante, y en Android eso puede dejar la conexión abierta a medias. Cuando por fin se cortaba, el Tag hacía sonar su alarma por desconexión. Ese es el sonido apagado que no paraba.
4. **Al reconectar, la alerta seguía encendida.** La app apagaba FFE2 y la alarma por desconexión, pero no la alerta estándar. Por eso un Tag que quedó pitando no se callaba al volver a conectarse.

Es la explicación que mejor calza con el registro y con el código. No se reprodujo con su Tag.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Callar el Tag | FFE2, la alerta estándar y la alarma por desconexión se apagan con confirmación, cuando el Tag la ofrece, y con hasta tres intentos cada una. Si no se confirma, la app abre otra conexión, que las apaga al conectarse, y solo después se desconecta. |
| Conexión dudosa | Si una orden queda sin respuesta, la conexión se marca como dudosa. Callar el Tag, mantener la conexión durante el relevo o una nueva prueba la abren de nuevo. |
| Desconectar | La app espera hasta 2 s a que Android confirme la desconexión antes de cerrar. |
| Al conectar | También se apaga la alerta estándar, así que un Tag que quedó pitando se calla. |
| Señal | Antes de darla por cortada, la app abre la conexión de nuevo una vez y sigue. Al terminar, si el Tag no confirmó que se calló, la app lo calla en segundo plano. Eso pasa después de registrar el final, así que no alarga la duración registrada. |
| Prueba | El Tag se calla aunque la orden de encender haya fallado: pudo llegar al Tag sin confirmarse. |
| Pila | Al conectarse, la app lee la carga del Tag (servicio estándar de batería). Con un Tag elegido, muestra «iTAG, elegido · pila al 80 %»; con 20 % o menos, agrega «cámbiala pronto». |
| Registro | `prueba_de_sonido` suma `apagado` (`quiet`, `reconnected` o `failed`), si hubo conexión, y `pila`. El evento nuevo `llavero_pila` guarda la carga al sonar la señal. El panel los muestra y su versión de referencia pasa a 2.31. |
| Ícono y logo | El ícono de la app, el de las notificaciones y el logotipo «relevo» son los de la línea 3.0 (D-125 y D-127). El resto de la interfaz es la de la 2.30. |

## Verificación

- **Compilación:** desde cero, en versión optimizada y de depuración, con 86 pruebas unitarias. La prueba nueva cubre el servicio de batería y el texto de la pila.
- **Firma:** la misma clave de las versiones anteriores (`fdbe6bbe…`). `versionCode` 46, mayor que el de la 2.30 (42) y el de la 3.2 (45), así que se instala encima de cualquiera de ellas.
- **Emulador:**
  - Se respaldaron los datos del autor y se activó el modo avión.
  - La 2.31 se instaló sobre la 3.2, con datos. El inicio quedó con el logo nuevo y los datos a la vista, y en la lista de apps aparece el ícono nuevo.
  - Con un Tag simulado (dirección falsa y pila al 18 %), «¿Dónde suena?» mostró la línea de la pila. La prueba falló como debía («No lo encontramos»), sin cierres, y registró `pila=18`.
  - Después se volvió a la 3.2 y se restauraron los datos del autor, que quedaron idénticos (MD5).
- **No probado:** con el Tag real, la señal larga, la reconexión ni la lectura real de la pila.

**APK:** [relevo-android-2.31-2026-10-14.apk](releases/relevo-android-2.31-2026-10-14.apk), SHA-256 `2C69323A2D2E7846947E91FE6EACE66B7C2437D3E2C9473BD6CE6F908890946E` (12,1 MB).

## Para la participante

1. Instalar la 2.31 encima de la 2.30, sin desinstalar: se conservan sus datos y su relevo.
2. Si el Tag está sonando, apagarlo con su botón o sacarle la pila, y volver a ponerla.
3. Volver a probar el sonido en «¿Dónde suena?» y fijarse en la carga de la pila que muestra la app.

## Registro de cambios (disclaimer)

### 2026-10-14 — Creación

- **Qué se añadió:** la versión 2.31, con el arreglo del Tag, la pila y el ícono y el logo nuevos sobre la interfaz de la 2.30.
- **Cómo estaba antes:** la 2.30 no confirmaba que el Tag se callara, desconectaba sin esperar y no leía la pila.
- **Por qué:** reporte de una participante del primer testeo, transmitido por el autor (D-134).
