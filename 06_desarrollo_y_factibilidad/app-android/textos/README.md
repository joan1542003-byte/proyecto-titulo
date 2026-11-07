# Textos de la app

Todo lo que dice Relevo: cada palabra de la app, cómo se escribe y por qué. Sirve para revisar los textos sin abrir el código y como base para actualizarlos. Nada de esta carpeta cambia la app.

| Archivo | Qué es |
| --- | --- |
| [Estudio de los textos](estudio-escritura-de-interfaces-2026-10-24.md) | Cómo habla Relevo: lo que recomiendan las guías y la investigación, cómo escriben apps conocidas, el diagnóstico de los textos actuales (R1 a R14), la voz, el tono, las reglas por tipo de texto y el vocabulario. |
| [Pantallas de la app 3.3](pantallas-de-la-app-3.3.md) | Cada pantalla descrita por escrito: para qué sirve, cuándo aparece, qué muestra, qué se puede hacer, qué registra y sus textos. |
| [Catastro de palabras clave](catastro-de-palabras-clave.md) | Las 634 palabras y 121 frases con que la app reconoce una actividad propia, por concepto, con lo que sugiere para empezar y dónde. Se genera con [`generar-catastro.js`](generar-catastro.js). |
| [Inventario de textos](inventario-de-textos.md) | Los 1381 textos de la 4.6.3, agrupados por pantalla, con su identificador (T0001…), tipo, archivo y línea. Los de la 4.3 y la 3.3 quedan en el historial de Git. |
| [Tabla de textos](textos-de-la-app.csv) | Lo mismo en una tabla para abrir en Excel (separada por punto y coma). |
| [Inventario de 2.33](inventario-de-textos-android-2.33.md) y [tabla de 2.33](textos-de-la-app-android-2.33.csv) | Los textos de la versión que se usa en la prueba. |
| [`extraer-textos.js`](extraer-textos.js) | El script que genera los inventarios desde el código. |

## Cómo se generan

Desde esta carpeta:

```bash
node extraer-textos.js
```

Para la versión de la prueba, sin cambiarse de rama:

```bash
node extraer-textos.js android-2.33
```

El script lee el código Kotlin de `app/src/main/java/com/example/relevo/` (carpetas `ui`, `ui/components`, `monitor` y `domain`) y deja fuera lo que la persona no ve: claves internas, registros técnicos, consultas y nombres de archivo. Los datos que pone la persona aparecen entre corchetes, como [nombre] o [duración], y el correo del investigador se reemplaza por «[correo del investigador]».

**Límites.** Los identificadores siguen el orden del código: si se agrega o quita un texto, cambian los que vienen después. Para citar un texto de forma estable, conviene usar también su archivo y línea. El inventario incluye unos pocos textos que siguen en el código pero ya no se muestran; el estudio los indica.

## Registro de cambios (disclaimer)

### 2026-11-07 — Inventario de la 4.6.3

- **Qué cambió:** el inventario pasa a la 4.6.3, con cinco textos corregidos: «En las que se cuenta el tiempo», «espera 30 minutos antes de volver a activarlo», «Cuántas veces a la semana quieres hacer tus actividades», «No sonará sola» y «sonará en tu teléfono».
- **Cómo estaba antes:** tenía los textos de la 4.6.2.
- **Por qué:** D-167.

### 2026-11-07 — Inventario de la 4.6.2

- **Qué cambió:** el inventario pasa a la 4.6.2: «contar» siempre dice qué se cuenta, lo que aún no pasa va en futuro y el perfil es «tu perfil». Las reglas están en [Android 4.6.2](../version-4.6.2-textos-claros-y-bluetooth-2026-11-07.md).
- **Cómo estaba antes:** tenía los textos de la 4.6.1.
- **Por qué:** D-166.

### 2026-11-07 — Inventario de la 4.6.1

- **Qué cambió:** el inventario pasa a los 1381 textos de la 4.6.1, con «Cerrar» del velo de las hojas.
- **Cómo estaba antes:** tenía los textos de la 4.6.
- **Por qué:** D-165.

### 2026-11-06 — Inventario de la 4.6

- **Qué cambió:** el inventario pasa a los 1379 textos de la 4.6, con los de la encuesta del rediseño.
- **Cómo estaba antes:** tenía los 1353 textos de la 4.5.
- **Por qué:** D-164.

### 2026-11-06 — Catastro de palabras clave (4.5)

- **Qué cambió:** se suma el catastro de palabras clave, generado desde el código, y el inventario pasa a los 1353 textos de la 4.5.
- **Cómo estaba antes:** las palabras clave solo estaban en el código, y el inventario tenía los 1335 textos de la 4.4.
- **Por qué:** el autor pidió más palabras y frases clave y documentarlas todas (D-163).

### 2026-11-05 — Inventario de la 4.4

- **Qué cambió:** el inventario y la tabla se volvieron a generar con el código de la 4.4.
- **Cómo estaba antes:** eran los de la 4.3, con 1410 textos.
- **Por qué:** la 4.4 quita la prueba de 21 días y suma las pantallas de la 1.0.0 (D-159).

### 2026-11-05 — Inventario de 4.3

- **Qué cambió:** el inventario y la tabla se volvieron a generar con el código de 4.3. El script reconoce el catastro de palabras clave (sus sugerencias van a «Ideas, sugerencias y rutas» y sus palabras internas quedan fuera), la hoja del sonido y la de opciones, y los nombres de pantalla sin «tu».
- **Cómo estaba antes:** tenían los 1221 textos de 4.2.1.
- **Por qué:** la 4.3 sumó las sugerencias de 34 conceptos, los sonidos y nuevos textos de Perfil, y quitó posesivos (D-158).

### 2026-11-05 — Inventario de 4.2.1

- **Qué cambió:** el inventario y la tabla se volvieron a generar con el código de 4.2.1.
- **Cómo estaba antes:** tenían los 1219 textos de 4.2.
- **Por qué:** la corrección de preparar desde una idea sumó dos avisos y cambió otros dos.

### 2026-11-05 — Inventario de 4.2

- **Qué cambió:** el inventario y la tabla se volvieron a generar con el código de 4.2, y el script reconoce la lista de predefinidas y el nuevo nombre de «Envíanos un comentario».
- **Cómo estaba antes:** tenían los 1237 textos de 4.1.
- **Por qué:** el autor cambió textos al ver la 4.1 (D-157).

### 2026-11-05 — Inventario de 4.1

- **Qué cambió:** el inventario y la tabla se volvieron a generar con el código de 4.1, y el script reconoce las pantallas nuevas (Actividades y Ajustes).
- **Cómo estaba antes:** tenían los 1.287 textos de 3.3.
- **Por qué:** 4.0 y 4.1 quitaron y acortaron textos (D-155 y D-156).

### 2026-10-24 — Creación

- **Qué cambió:** se creó la carpeta con el estudio de los textos, la descripción de las pantallas, los inventarios de 3.3 y 2.33 y el script que los genera.
- **Cómo estaba antes:** los textos de la app solo estaban dentro del código Kotlin.
- **Por qué:** el autor pidió estudiar cómo comunicarse en la app, documentar cada palabra y cada pantalla, y dejar la base para actualizar los textos más adelante.
