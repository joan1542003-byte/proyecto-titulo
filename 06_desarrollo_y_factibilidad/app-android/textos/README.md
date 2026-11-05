# Textos de la app

Todo lo que dice Relevo: cada palabra de la app, cómo se escribe y por qué. Sirve para revisar los textos sin abrir el código y como base para actualizarlos. Nada de esta carpeta cambia la app.

| Archivo | Qué es |
| --- | --- |
| [Estudio de los textos](estudio-escritura-de-interfaces-2026-10-24.md) | Cómo habla Relevo: lo que recomiendan las guías y la investigación, cómo escriben apps conocidas, el diagnóstico de los textos actuales (R1 a R14), la voz, el tono, las reglas por tipo de texto y el vocabulario. |
| [Pantallas de la app 3.3](pantallas-de-la-app-3.3.md) | Cada pantalla descrita por escrito: para qué sirve, cuándo aparece, qué muestra, qué se puede hacer, qué registra y sus textos. |
| [Inventario de textos](inventario-de-textos.md) | Los 1221 textos de 4.2.1, agrupados por pantalla, con su identificador (T0001…), tipo, archivo y línea. El de 3.3 queda en el historial de Git. |
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
