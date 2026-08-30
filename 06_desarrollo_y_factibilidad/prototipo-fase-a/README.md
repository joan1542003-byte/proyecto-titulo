# Firmware provisional del montaje de fase A

**Estado:** fuente preparada; no compilada, cargada ni ensayada en hardware

## Función

El archivo [relevo_fase_a.ino](relevo_fase_a.ino) implementa únicamente el comportamiento necesario para el [montaje mínimo](../montaje-minimo-fase-a-2026-08-30.md). No contiene Bluetooth, Android, almacenamiento, intenciones ni historial.

## Comportamiento esperado

1. El montaje parte con la luz apagada.
2. Una pulsación válida inicia tres pulsos.
3. Cada pulso permanece encendido 500 ms.
4. Entre pulsos existen dos intervalos apagados de 750 ms.
5. La secuencia nominal suma 3000 ms desde el primer encendido hasta el apagado final; la aceptación técnica es 3000 ms ± 300 ms hasta medir el montaje.
6. Una pulsación recibida durante la secuencia se descarta y no se acumula.
7. El silenciamiento corta físicamente la luz y comunica al programa que debe volver a reposo.
8. Recuperar energía no reproduce la señal anterior.

Los tiempos son una decisión instrumental de fase A. Facilitan medir una secuencia simple; no definen el lenguaje final del pulso ni demuestran que resulte perceptible, tranquilo o accesible.

## Asignación provisional

| Pin | Elemento | Estado eléctrico |
| --- | --- | --- |
| D9 | Entrada de control del módulo MOSFET | PWM 0–255. La tira LED utiliza alimentación externa. |
| D2 | Pulsador de activación a tres metros | Activo en LOW mediante `INPUT_PULLUP`. |
| D3 | Segundo polo del interruptor DPDT | Activo en LOW cuando el montaje está silenciado. |

Un polo del DPDT abre la rama luminosa de baja tensión. El otro conecta D3 a tierra cuando se selecciona silencio. Esta separación permite detener la luz aunque el programa falle y, al mismo tiempo, abandonar el estado activo. La posición activa solo acepta órdenes después de permanecer estable durante 30 ms.

La asignación debe contrastarse con la placa real y el módulo MOSFET antes de cablear. La tira LED no se conecta directamente a D9. Fuente, controlador y módulo de potencia requieren una referencia común de tierra; la salida del reductor debe medirse en 5 V antes de conectar la placa.

## Intensidad provisional

El código ofrece tres valores PWM: 48, 96 y 160 sobre 255. El valor inicial es 96. Estas cifras permiten repetir una configuración eléctrica, pero no equivalen a porcentajes perceptivos. La intensidad debe comenzar en el nivel inferior durante el ensayo técnico y registrarse junto con iluminación, distancia y difusor.

Cambiar `ACTIVE_LEVEL_INDEX` obliga a crear una nueva versión de montaje o a registrar el cambio antes de repetir la serie afectada.

## Implementación

La lógica utiliza `millis()` en lugar de pausas bloqueantes. Así puede leer el silenciamiento durante la señal. Todos los cambios de luz se calculan desde un único inicio, con límites nominales en 500, 1250, 1750, 2500 y 3000 ms. Esto evita acumular el retraso de cada transición. Una aserción de compilación impide modificar los tiempos de modo que la secuencia deje de sumar 3000 ms, pero no sustituye su medición física.

El código no afirma por sí solo que:

- compile para la placa disponible;
- el nivel PWM produzca una señal adecuada;
- el MOSFET responda con la polaridad esperada;
- el cable de tres metros no introduzca ruido;
- el interruptor esté conectado correctamente;
- la entrada del MOSFET permanezca apagada antes de que el programa inicie;
- el montaje sea seguro o estable.

## Comprobaciones anteriores a la ficha técnica

- [ ] Seleccionar la placa y el procesador correctos en el entorno Arduino.
- [ ] Compilar sin errores ni advertencias relevantes.
- [ ] Cargar el programa con la luz desconectada.
- [ ] Confirmar 5 V medidos en la alimentación del controlador.
- [ ] Comprobar que D9 controla el módulo MOSFET y no alimenta la tira.
- [ ] Confirmar la polaridad del módulo MOSFET y que no exista un destello al encender, reiniciar o recuperar energía.
- [ ] Si el módulo no conserva el apagado durante el arranque, añadir una resistencia adecuada y actualizar esquema y lista de materiales.
- [ ] Confirmar reposo al encender y después de retirar alimentación.
- [ ] Con el sistema desconectado, identificar por continuidad los comunes y salidas del DPDT en ambas posiciones.
- [ ] Confirmar que la posición activa cierra la rama luminosa y deja D3 en HIGH.
- [ ] Confirmar que la posición silenciosa abre físicamente la rama luminosa y lleva D3 a LOW.
- [ ] Comprobar que el corte físico detiene la luz aunque la salida de control esté activa.
- [ ] Medir tres pulsos y una duración total entre 2700 y 3300 ms antes de montar el difusor.
- [ ] Probar las tres intensidades y seleccionar una para el ensayo técnico.
- [ ] Identificar versión de código, placa, conexiones y nivel PWM en la ficha.

Después de estas comprobaciones se ejecuta completa la [ficha de ensayo técnico](../../07_validacion/ficha-ensayo-tecnico-fase-a.md). Ningún resultado debe marcarse desde este README.

## Límite de seguridad

La fuente mantiene toda alimentación de red dentro de un adaptador comercial cerrado. El montaje de protoboard opera en baja tensión, pero aun así requiere revisión de polaridad, aislación, conexiones, temperatura y corte físico antes de acercarlo a participantes. Si no se dispone de experiencia suficiente, una persona competente en electrónica debe revisar el circuito.

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Auditoría de temporización y silencio

- **Cambio:** la secuencia pasó a utilizar límites absolutos desde un único inicio; se estabilizó la rehabilitación del silencio y se añadieron pruebas de continuidad, estado lógico y arranque eléctrico.
- **Versión anterior:** cada transición reiniciaba su reloj, el cambio del DPDT podía rebotar y el reposo inicial solo estaba descrito desde el programa.
- **Motivo:** impedir la acumulación de retrasos y distinguir una lógica preparada de un comportamiento eléctrico todavía no medido.
- **Alcance:** el código continúa sin compilar, cargar ni ensayar; 3000 ms es una duración nominal con tolerancia de aceptación de ± 300 ms.

### 2026-08-30 — Primera fuente de firmware

- **Cambio:** se documentaron pines, estados, patrón temporal, intensidad provisional, silenciamiento y comprobaciones anteriores al ensayo.
- **Versión anterior:** el montaje definía comportamiento y arquitectura, pero todavía no existía una fuente ejecutable.
- **Motivo:** permitir construir y auditar la lógica sin integrar Android, Bluetooth o funciones ajenas a fase A.
- **Alcance:** código no compilado ni cargado; no constituye un resultado técnico ni autoriza el uso con participantes.
