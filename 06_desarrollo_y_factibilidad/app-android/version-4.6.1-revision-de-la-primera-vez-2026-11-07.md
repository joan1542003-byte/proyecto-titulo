# Android 4.6.1: revisión de la primera vez, la encuesta y la accesibilidad

**Fecha:** 7 de noviembre de 2026. **Decisión:** [D-165](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.6`. **Versión:** 4.6.1, `versionCode` 58. **APK:** [relevo-android-4.6.1-2026-11-07.apk](releases/relevo-android-4.6.1-2026-11-07.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.6 y de las anteriores. SHA-256: `63B9EF70AA86960F099271F09F64EC1161FB14A19F190F9942906F55897BD06E`.

## Qué se pidió

El autor preguntó si había alguna tarea que se pudiera tomar, que no fuera la memoria, y pidió hacerla. Se eligió la revisión de la app que quedaba pendiente desde la 4.4 hasta la 4.6:
- la primera vez desde cero;
- la encuesta del rediseño, en una instalación nueva y al activar un relevo;
- la letra grande;
- los nombres que lee TalkBack, el lector de pantalla de Android.

## Cómo se revisó

- **Sin tocar los datos del autor:** se usó una copia aparte de la app (paquete `cl.udp.relevo.prueba`), que se instala como otra app, vacía.
- **Sin conexión de principio a fin:** nada de la prueba llegó a Supabase. La copia se desinstaló al terminar, antes de reconectar el emulador.
- **Accesibilidad:** en cada pantalla, un script leyó la estructura que ve TalkBack y marcó los botones sin nombre y los menores de 48 dp, el mínimo de Android para tocar con el dedo.

## Qué funciona

- **La primera vez desde cero:** bienvenida, consentimiento, permiso de Tiempo de uso, los seis pasos del primer relevo y la activación.
- **Si se rechaza el Bluetooth:** la app avisa «Falta un permiso», explica para qué es y deja elegir «Notificaciones».
- **Los permisos de Android:** el de notificaciones aparece al activar el primer relevo, que es cuando hace falta.
- **La encuesta en una instalación nueva:** queda marcada como no elegible y no aparece.
- **La encuesta al activar un relevo:** en una actualización simulada, apareció justo después de activar. La app llevaba unos 45 s abierta, así que la mostró la activación y no el minuto.
- **Letra grande (130 %):**
  - Inicio, la cuadrícula y la encuesta se leen sin cortes;
  - la encuesta y su escala de 1 a 7 caben en el ancho.
- **Botones:** todos los revisados tienen nombre para TalkBack y miden al menos 48 dp. Los únicos marcados eran trozos de filas cortados por el borde al desplazar.

## Qué se arregló

| Problema | Antes | Ahora | Archivo |
| --- | --- | --- | --- |
| Una palabra partida en la cuadrícula de cuatro | «Hacer man / ualidades» | El nombre mantiene su ancho y solo se ensancha, con aire hacia la celda vecina, si una palabra no cabe. Si tampoco cabe así, la letra baja lo justo. Nunca parte una palabra. | `ui/components/Ring.kt` |
| El velo detrás de cada hoja, que la cierra al tocarlo, no tenía nombre | TalkBack lo leía como un botón sin nombre | Se lee «Cerrar» | `ui/components/Sheet.kt` |

El primer arreglo de la palabra partida dejaba que el nombre ocupara toda la celda. Así, «Hacer ejercicio» y «Pasear al perro» quedaban en una línea, pegados uno al otro, y se corrigió antes de publicar.

**Con letra grande,** los nombres más largos, como «Hacer manualidades» o «Salir en bicicleta», se ven un poco más chicos que sus vecinos. Es el precio de no partir palabras.

## Para que decida el autor

- **El Tag viene elegido por defecto** en «¿Dónde suena?» (2.28), así que Android pide el permiso de Bluetooth apenas se entra a ese paso, aunque la persona no tenga un Tag. Se podría pedir solo al tocar «Buscar el Tag».

## Verificación

- **Compilación desde cero:** sin advertencias y con 97 pruebas unitarias.
- **APK:** paquete `cl.udp.relevo`, versión 4.6.1 (`versionCode` 58), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **Emulador:** la copia aparte se desinstaló, la letra volvió al 100 % y el emulador volvió a tener conexión. La app del autor no se tocó.

**Falta probar:** TalkBack encendido de punta a punta, la letra al 200 % y la 4.6.1 en un teléfono real.

## Registro de cambios (disclaimer)

### 2026-11-07 — Creación

- **Qué cambió:** se documenta la revisión de la 4.6 y los dos arreglos de la 4.6.1.
- **Cómo estaba antes:** la primera vez desde cero, la encuesta al activar y en una instalación nueva, la letra grande y TalkBack estaban sin probar.
- **Por qué:** el autor pidió tomar una tarea pendiente que no fuera la memoria y terminarla.
