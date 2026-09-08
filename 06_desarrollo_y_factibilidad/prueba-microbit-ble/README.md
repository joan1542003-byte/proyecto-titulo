# Prueba Android–BLE con micro:bit V2

**Estado:** fuente compilada; instalación y ensayo en una placa real pendientes
**Función:** comprobar el recorrido Android → Bluetooth de baja energía (BLE) → luz y sonido → silencio local antes de involucrar participantes

## Qué resuelve este paquete

El programa recibe una única orden, `activar`, mediante el servicio UART de Bluetooth. Si el sistema está en reposo, ejecuta tres pulsos de luz durante tres segundos y un tono breve al comienzo. Los botones A y B detienen la secuencia localmente. Una segunda orden recibida mientras la señal está activa se ignora, y una reconexión no produce ninguna señal.

El teléfono recibe mensajes de control que ayudan a revisar el montaje sin añadir funciones a la experiencia:

| Mensaje | Significado técnico |
| --- | --- |
| `lista` | El enlace BLE quedó disponible. |
| `recibida` | La orden válida llegó al objeto. |
| `silenciada` | Un botón físico detuvo la secuencia. |
| `terminada` | La secuencia concluyó sin interrupción. |

Estos mensajes solo sirven para el ensayo. El programa no recibe intenciones, nombres de actividades, horarios ni datos personales, y no guarda historial.

## Límite descubierto

La matriz integrada de micro:bit V2 está formada por LED rojos. Por eso permite comprobar conexión, recepción, duración, sonido y silenciamiento, pero **no cumple por sí sola la luz blanca cálida definida para la prueba de asociación con participantes**. Presentarla como equivalente habría mezclado una prueba técnica con una decisión perceptiva no resuelta.

El archivo [`main.ts`](main.ts) deja dos modos explícitos:

- `USE_EXTERNAL_WARM_LIGHT = false`: usa la matriz roja para una prueba de mesa sin participantes;
- `USE_EXTERNAL_WARM_LIGHT = true`: utiliza una luz cálida externa conectada a P1 para preparar el material de fase A.

Antes de cualquier sesión con participantes, el segundo modo debe superar la [ficha de ensayo técnico](../../07_validacion/ficha-ensayo-tecnico-fase-a.md). Si la fuente externa no es visible a las distancias previstas, no se reduce la resistencia ni se aumenta la carga por ensayo y error: se detiene el montaje y se revisa el circuito o la plataforma.

## Material mínimo

### Prueba de mesa

- micro:bit V2;
- cable USB o portapilas compatible;
- teléfono Android con BLE;
- aplicación de terminal compatible con el UART de micro:bit.

### Preparación de la luz de fase A

- lo anterior;
- un LED blanco cálido de alta eficiencia;
- una resistencia de 1 kΩ como punto de partida seguro;
- tres cables con pinzas o una placa de pruebas;
- un difusor neutro;
- revisión de conexión antes de energizar.

La conexión mínima sigue la guía oficial para LED externos, trasladada de P0 a P1 para mantener P0 libre:

```text
P1 ── resistencia 1 kΩ ── ánodo del LED
GND ───────────────────── cátodo del LED
```

Cada pin puede entregar como máximo 5 mA en modo de alta corriente. La resistencia debe ajustarse únicamente con la ficha técnica del LED y revisión competente. Esta conexión busca una primera medición, no define la electrónica final de Relevo.

## Carga del programa

1. Abrir [MakeCode para micro:bit](https://makecode.microbit.org/) y crear un proyecto.
2. Añadir la extensión oficial `Bluetooth`. MakeCode retirará `Radio` porque ambas funciones no se usan simultáneamente.
3. Cambiar a JavaScript y reemplazar el contenido de `main.ts` por el archivo de este directorio.
4. Mantener `USE_EXTERNAL_WARM_LIGHT = false` para la comprobación inicial. Usar `true` solo con la conexión externa revisada.
5. Descargar el archivo HEX y copiarlo a la micro:bit V2 mediante USB. Registrar la versión del editor y el nombre del archivo en la ficha técnica.
6. Después de actualizar el programa, volver a emparejar la placa si Android dejó de reconocerla.

El directorio [`compilado`](compilado/) contiene `relevo-prueba-mesa-v0.1.hex`, generado con `pxt-microbit 9.1.1` y `pxt-core 13.0.1`. La compilación terminó sin errores el 8 de septiembre de 2026. Su suma SHA-256 es `50FD11A9C8A1C9388D11537B46B79C60596030C4EF741E69C3956D53CB3B4DE0`.

Ese archivo conserva `USE_EXTERNAL_WARM_LIGHT = false`: enciende la matriz roja y se limita al banco técnico. **Que compile no significa que funcione en la placa ni que cumpla la fase A.** Para usar la salida cálida externa se debe cambiar el parámetro, volver a compilar y ejecutar el ensayo completo antes de conservar un segundo HEX.

## Envío desde Android

Para esta puerta no se construye todavía la aplicación completa de Relevo. El soporte oficial de micro:bit documenta el uso de una aplicación de terminal UART en Android y señala que primero deben completarse emparejamiento y conexión.

1. Emparejar la placa siguiendo el procedimiento oficial de micro:bit para Android.
2. Abrir una aplicación compatible con el UART de micro:bit; la guía oficial informa una prueba con **Serial Bluetooth Terminal**.
3. Conectarse a la micro:bit y configurar salto de línea al enviar. El programa normaliza tanto LF como CRLF.
4. Comprobar que aparece `lista` sin que se encienda la señal.
5. Enviar exactamente `activar` seguido de un salto de línea.
6. Confirmar `recibida`, observar una sola secuencia y registrar la latencia desde el envío hasta el comienzo visible.
7. Repetir la activación y pulsar A o B durante la secuencia. La luz y el sonido deben detenerse en menos de un segundo y el terminal debe recibir `silenciada`.

El temporizador se simula manualmente en Android. Si se cancela antes del momento previsto, no se envía nada. La detección del uso de aplicaciones pertenece a una etapa posterior.

## Parámetros que deben quedar registrados

Los valores iniciales se encuentran al comienzo de `main.ts`:

| Parámetro | Valor inicial | Función |
| --- | ---: | --- |
| Brillo de matriz | 96/255 | Solo para el banco de prueba con LED rojos. |
| Nivel PWM externo | 640/1023 | Punto de partida para el LED cálido; requiere medición. |
| Volumen | 72/255 | Punto de partida, no nivel definitivo. |
| Frecuencia | 523 Hz | Tono breve de ensayo. |
| Duración del tono | 180 ms | Inicio audible sin voz. |
| Pulso encendido | 600 ms × 3 | Tres apariciones visibles. |
| Intervalo apagado | 600 ms × 2 | Separa los pulsos. |
| Duración luminosa total | 3000 ms | Coincide con la especificación de fase A. |

Todo cambio se anota antes del siguiente bloque de repeticiones. Los valores no demuestran perceptibilidad ni comodidad hasta completar la ficha.

## Criterio de cierre

El paquete no queda validado por existir o compilar. Se considera técnicamente habilitado solo cuando una micro:bit V2 real supera las series de conexión, reconexión, activación, latencia, patrón, silencio, recuperación y estabilidad definidas en [`07_validacion`](../../07_validacion/README.md). La luz cálida externa debe probarse además sobre las superficies, distancias y condiciones de iluminación previstas.

## Fuentes técnicas

- Micro:bit Educational Foundation. (s. f.). *Connecting an LED to the micro:bit*. https://support.microbit.org/support/solutions/articles/19000101863-connecting-an-led-to-the-micro-bit
- Micro:bit Educational Foundation. (s. f.). *Hardware*. https://tech.microbit.org/hardware/
- Micro:bit Educational Foundation. (2025). *Using the micro:bit Bluetooth Low Energy UART*. https://support.microbit.org/support/solutions/articles/19000062330-using-the-micro-bit-bluetooth-low-energy-uart-serial-over-bluetooth-
- Microsoft. (s. f.). *Bluetooth*. Microsoft MakeCode. https://makecode.microbit.org/reference/bluetooth
- Microsoft. (s. f.). *Stop all sounds*. Microsoft MakeCode. https://makecode.microbit.org/reference/music/stop-all-sounds

## Registro de cambios (disclaimer)

### 2026-09-08 — Creación del paquete mínimo

- **Qué cambió:** se incorporaron el proyecto MakeCode, el comportamiento de señal, el protocolo de prueba desde Android, los parámetros de ajuste y la distinción entre matriz integrada y luz cálida externa.
- **Cómo era antes:** el repositorio describía el recorrido micro:bit–BLE, pero no contenía código ejecutable ni advertía que la matriz roja no cumple la especificación cromática de la fase A.
- **Por qué:** retirar firmware y fabricación del mismo bloqueo, sin presentar una placa educativa como material equivalente al definido para participantes.
- **Alcance:** el código compiló con `pxt-microbit 9.1.1`, pero no ha sido instalado ni medido en una placa real; no autoriza reclutamiento ni demuestra percepción, comprensión o valor del sistema.
