# Android 4.8.1: tamaño óptico y la huella del primer paso

**Fecha:** 22 de noviembre de 2026. **Decisión:** [D-187](../../09_decisiones/registro-de-decisiones.md). **Rama:** `iconos-lucide`. **Versión:** 4.8.1, `versionCode` 65. **APK:** [relevo-android-4.8.1-2026-11-22.apk](releases/relevo-android-4.8.1-2026-11-22.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.8 y de las anteriores sin perder datos. SHA-256: `744EB537C81681CF25035A1CC53175EFFC065285920394D6E6F0F1CAF4FB2943`.

## Qué se pidió

El autor revisó los íconos de la [4.8](version-4.8-iconos-de-lucide-2026-11-22.md) y pidió dos cosas:

- el ícono del primer paso no debe ser una escalera;
- algunos íconos propios se ven muy pequeños, y el tamaño debe ser óptico, no matemático.

## Qué cambió

- **El primer paso** («Cómo empieza») es ahora una sola huella de Lucide (`footprints`), más grande e inclinada hacia adelante. Se distingue de Caminar, que son dos huellas rectas. Ninguna pantalla lo usa todavía.
- **Cuatro íconos crecieron** hasta pesar como sus vecinos de Lucide:
  - **Suena:** el Tag pasa de radio 5 a 6, con el botón, y los dos anillos son concéntricos al Tag: se abren desde el objeto.
  - **Silenciar:** el mismo Tag, con una cruz de 5, como la de `volume-x`.
  - **Estirar:** el rollo pasa de radio 6 a 7 y la colchoneta sube.
  - **Meditar:** los pétalos son más llenos y la base, más ancha.
- **Cómo se midió:** con la prueba del desenfoque que pide Lucide. Cada ícono se desenfoca y se mide su mancha. Antes, Silenciar, Suena, Estirar y Meditar quedaban entre el 11 % y el 22 % más chico de los íconos de Lucide de la app, y la escalera en el 9 %. Ahora, Suena queda en la mitad y Estirar y Meditar, en el 38 %. Silenciar queda a la par de `volume-x`, su equivalente en Lucide, y la huella, en el rango de los íconos angostos, como Bluetooth. El detalle está en el [documento 46](../../10_recursos_visuales/46_iconos-desde-lucide-2026-11-22.md#tamaño-óptico).
- **El resto no cambió:** los otros 113 íconos, sus palabras, el trazo según el tamaño y el centro óptico.

Quedan 109 íconos de Lucide tal cual, seis adaptados (ahora también el primer paso) y tres propios: el Tag, la colchoneta y la flor de loto.

## Verificación

- **Los dibujos:** los 118 trazados generados coinciden píxel a píxel con sus SVG.
- **Compilación y pruebas:** 110 pruebas unitarias sin fallas, incluidas las cuatro de `KitIconsTest`.
- **APK:** paquete `cl.udp.relevo`, versión 4.8.1 (`versionCode` 65) y el mismo certificado que la 4.7.2 y la 4.8.
- **Medición:** [`medir_tamano_optico.js`](../../10_recursos_visuales/iconos-lucide/medir_tamano_optico.js) repite la prueba del desenfoque para cualquier ícono nuevo.

**Falta probar:** la app no se abrió en un teléfono ni en un emulador.

## Registro de cambios (disclaimer)

### 2026-11-22 — Creación

- **Qué cambió:** se documenta la 4.8.1: la huella del primer paso y cuatro íconos propios con más cuerpo, medidos con la prueba del desenfoque.
- **Cómo estaba antes:** en la 4.8, el primer paso era una escalera, y Suena, Silenciar, Estirar y Meditar se veían más chicos que sus vecinos.
- **Por qué:** el autor pidió que el primer paso no fuera una escalera y que el tamaño fuera óptico, no matemático.
