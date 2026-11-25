# Android 4.8.2: los nueve íconos, con las reglas de Lucide

**Fecha:** 22 de noviembre de 2026. **Decisión:** [D-187](../../09_decisiones/registro-de-decisiones.md). **Rama:** `iconos-lucide`. **Versión:** 4.8.2, `versionCode` 66. **APK:** [relevo-android-4.8.2-2026-11-22.apk](releases/relevo-android-4.8.2-2026-11-22.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.8.1 y de las anteriores sin perder datos. SHA-256: `6B3E5B201948B693943526AFBC1FC5C3DC9FE31C2BCC9A6CF415DF113EF7B5A2`.

## Qué se pidió

El autor revisó los íconos de la [4.8.1](version-4.8.1-tamano-optico-y-primer-paso-2026-11-22.md) y pidió: «mejorables, perfecciónalos. Estudia cómo funcionan».

## Qué se estudió

Se leyeron las tres páginas de la guía de Lucide —el lenguaje de diseño, la especificación y las convenciones del código— y se midieron sus 2.029 íconos. Las reglas y lo medido están en el [documento 46](../../10_recursos_visuales/46_iconos-desde-lucide-2026-11-22.md#cómo-funcionan-los-íconos-de-lucide). Con eso se revisaron los nueve íconos que no son de Lucide tal cual, y cinco no cumplían alguna regla.

## Qué cambió

| Ícono | Qué no cumplía en la 4.8.1 | Cómo queda en la 4.8.2 |
| --- | --- | --- |
| **Suena** | Los anillos no venían de ningún ícono de Lucide, aunque Lucide ya dibuja ondas de sonido, y el botón del Tag era un círculo dentro de otro, que lo hacía más denso. | Los anillos son los de `radio`: abiertos 45° a cada lado y separados por 4, centrados en el Tag. El Tag es un círculo con un punto al centro, como el cono de `speaker`. |
| **Silenciar** | La cruz quedaba a 1,35 del Tag, y la regla pide al menos 2 entre elementos distintos. | El mismo Tag de Suena y la cruz de 5 de `volume-x`, a 2,3 del Tag. |
| **Estirar** | La cara de arriba de la colchoneta terminaba justo sobre el rollo: un corte brusco, que la guía pide evitar. | Esa cara se detiene a 2 del rollo. Para que quepa, el rollo baja de radio 7 a 6,5. |
| **Meditar** | La base quedaba a 1,6 de los pétalos. | Tres pétalos cerrados que nacen de un punto, como las hojas de `flower-2`, sobre el suelo de `sprout`, a 3 de ellos. |
| **Cómo empieza** | La huella estaba girada, y la guía pide conservar la orientación de la forma que se toma de Lucide. | La huella izquierda de `footprints`, sin girar, sola y 1,25 veces más grande. |

Objeto, Sistema phygital, Actividades y Leer manga ya cumplían y no cambiaron. Tampoco cambiaron los otros 109 íconos, sus palabras, el trazo según el tamaño (D-124) ni el centro óptico (D-156).

**El tamaño.** La prueba del desenfoque se repitió con los nuevos dibujos. Suena y Meditar quedan en la mediana de los íconos de Lucide de la app, y Estirar, dentro de la mitad central, cerca de su borde liviano. Silenciar queda algo más liviano que `volume-x` (297 frente a 329), porque la cruz necesita 2 de aire y el Tag es el mismo de Suena. La huella queda liviana por su forma, como Bluetooth. El detalle está en el [documento 46](../../10_recursos_visuales/46_iconos-desde-lucide-2026-11-22.md#tamaño-óptico).

## Verificación

- **Las reglas:** [`verificar_reglas.py`](../../10_recursos_visuales/iconos-lucide/verificar_reglas.py) mide el margen y el aire entre trazos de los nueve, y los nueve cumplen.
- **Los dibujos:** los 118 trazados generados coinciden píxel a píxel con sus SVG.
- **Compilación y pruebas:** 110 pruebas unitarias sin fallas, incluidas las cuatro de `KitIconsTest`.
- **APK:** paquete `cl.udp.relevo`, versión 4.8.2 (`versionCode` 66) y el mismo certificado que la 4.8.1.

**Falta probar:** la app no se abrió en un teléfono ni en un emulador.

## Registro de cambios (disclaimer)

### 2026-11-22 — Creación

- **Qué cambió:** se documenta la 4.8.2: el estudio de las reglas de Lucide y los cinco íconos que se corrigieron con ellas.
- **Cómo estaba antes:** en la 4.8.1, Silenciar y Meditar tenían menos de 2 de aire entre trazos, Estirar terminaba en un corte brusco, la huella estaba girada y los anillos de Suena no venían de Lucide.
- **Por qué:** el autor pidió perfeccionar los íconos y estudiar cómo funcionan los de Lucide.
