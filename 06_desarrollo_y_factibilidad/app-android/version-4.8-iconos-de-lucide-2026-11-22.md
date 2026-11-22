# Android 4.8: los íconos de Lucide

**Fecha:** 22 de noviembre de 2026. **Decisión:** [D-187](../../09_decisiones/registro-de-decisiones.md). **Rama:** `iconos-lucide`. **Versión:** 4.8, `versionCode` 64. **APK:** [relevo-android-4.8-2026-11-22.apk](releases/relevo-android-4.8-2026-11-22.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.7.2 y de las anteriores sin perder datos. SHA-256: `85BF9CE9B532EE886E5C017EC4FD04B6E8CD5F9A8E05A7BF5407D56BDC97030C`.

## Qué se pidió

El autor propuso usar los íconos de Lucide, que son de código abierto, adaptar los que lo requieran y crear nuevos con sus reglas cuando Lucide no tenga algo que el usuario hace.

## Qué cambió

- **Los 118 íconos** salen ahora de [Lucide](https://lucide.dev) 1.70.0. Lucide es un conjunto de íconos de línea de código abierto:
  - **109 son de Lucide tal cual,** elegidos con las reglas de D-162: cada actividad con el objeto con que empieza y un significado por dibujo.
  - **Cinco son adaptados:** Suena y Silenciar llevan el Tag en vez del parlante; Sistema phygital, el Tag junto al teléfono; Actividades, cuatro círculos como los del logo, y Leer manga, un globo de diálogo en el libro.
  - **Cuatro son propios, con sus reglas:** el Tag, la colchoneta de Estirar, la flor de loto de Meditar y la escalera de Cómo empieza, porque Lucide no los tiene.
- **Lo que no cambió:** los nombres de los íconos, sus palabras y dónde aparecen. Tampoco el trazo según el tamaño, de 2,0 a 1,3 (D-124), ni el centro óptico (D-156). Ninguna pantalla cambió de texto ni de orden.
- **De dónde salen:** `KitIcons.kt` ya no se edita a mano. Lo escribe [`generar_kiticons.py`](../../10_recursos_visuales/iconos-lucide/generar_kiticons.py) desde el [mapeo](../../10_recursos_visuales/iconos-lucide/mapeo.json), que dice de dónde sale cada ícono y por qué. El generador convierte círculos y rectángulos en trazados. También separa las banderas de los arcos que el SVG permite escribir pegadas, para que Android no lea «0012» como un solo número.
- **Licencia:** el aviso de Lucide, con la licencia ISC y la MIT de los íconos que vienen de Feather, va en [`app/licenses/LUCIDE_LICENSE.md`](app/licenses/LUCIDE_LICENSE.md) y dentro del APK, en `assets/licencias/LUCIDE_LICENSE.txt`. Está registrado en [licencias](licencias/README.md).

El detalle de cada ícono, con las hojas de antes y después, está en [Íconos desde Lucide](../../10_recursos_visuales/46_iconos-desde-lucide-2026-11-22.md).

## Verificación

- **Los dibujos:** cada trazado generado se dibujó junto a su SVG de origen, a 96 px, y los 118 coincidieron píxel a píxel.
- **Compilación y pruebas:** 110 pruebas unitarias sin fallas. Cuatro son nuevas, en `KitIconsTest`:
  - cada ícono tiene al menos una forma;
  - el lector de trazados de Android lee completo cada trazado;
  - las banderas de los arcos van separadas;
  - ningún ícono repite el dibujo de otro. La estrella llena y la vacía tienen el mismo trazado, pero una va rellena.
- **APK:** paquete `cl.udp.relevo`, versión 4.8 (`versionCode` 64), el mismo certificado que la 4.7.2 y el aviso de Lucide dentro.
- **Compilado en la nube,** con el SDK 36. La primera compilación de la versión optimizada falló porque Maven Central respondió «demasiadas solicitudes»; la segunda compiló.

**Falta probar:** la app no se abrió en un teléfono ni en un emulador. Hay que revisar los íconos en pantalla, sobre todo a 17 px dentro de los anillos, en tema claro y oscuro y con letra grande.

## Registro de cambios (disclaimer)

### 2026-11-22 — Creación

- **Qué cambió:** se documenta la 4.8, con los íconos de Lucide, adaptados o propios, el generador, la licencia y la verificación.
- **Cómo estaba antes:** la 4.7.2 tenía 118 íconos dibujados a mano en `KitIcons.kt`, con las reglas de Lucide.
- **Por qué:** el autor propuso usar los íconos de Lucide y dibujar solo lo que Lucide no tiene (D-187).
