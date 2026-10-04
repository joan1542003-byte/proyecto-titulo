# Bitácora del trabajo con IA: 4 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code el 4 de octubre de 2026, a pedido del autor. Continúa la [bitácora del 3 de octubre](bitacora-trabajo-con-ia-2026-10-03.md). Cada pedido está en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Propuesta 3.6, «Letra con identidad» | El autor descartó los logotipos dibujados. Se buscaron 29 letras gratuitas con identidad y se recomendó Chubbo, con Calistoga y Fraunces Soft como alternativas. El azul pasa a `#1C3891`. [Lámina](https://claude.ai/artifact/XPgDvNQEcgjZ1nnTWX3GXS) y [documento 34](../10_recursos_visuales/34_letra-con-identidad-2026-10-04.md). | D-105 |
| Propuesta 3.7, «Letras para relevo» | A pedido del autor: 176 letras de cuatro fuentes sin Google Fonts, dieciocho finalistas en cuatro familias con su autoría y licencia, y una recomendación por familia. [Lámina](https://claude.ai/artifact/R9eHYeUaWooRcPjXqvC2B6) y [documento 35](../10_recursos_visuales/35_letras-para-relevo-2026-10-04.md). | D-106 |
| Propuesta 3.7, versión 2 | Con permiso para descargar, se bajaron 84 archivos de los enlaces de UNCUT y se sumaron 88 letras (UNCUT y Open Foundry): 264 en total y 30 finalistas. Misma [lámina](https://claude.ai/artifact/R9eHYeUaWooRcPjXqvC2B6), versión 2, y [documento 35](../10_recursos_visuales/35_letras-para-relevo-2026-10-04.md). | D-106 |
| Propuesta 3.8, «Letras que dicen relevo» | A pedido del autor: 61 letras nuevas de tipo display de cinco fuentes, 108 miradas en grande y catorce fichas que leen cada letra con los conceptos de Relevo. [Lámina](https://claude.ai/artifact/C8C9apN8tayiAoPERJ9gxZ) y [documento 36](../10_recursos_visuales/36_letras-que-dicen-relevo-2026-10-04.md). | D-107 |

## 2. Cómo se usó la IA

- **Licencias verificadas en su fuente:** Claude leyó la ITF Free Font License 2.0 de Fontshare (permite crear logotipos y registrarlos como marca) y las preguntas frecuentes de Pangram Pangram (gratis solo para uso personal y proyectos escolares; un logotipo de empresa requiere licencia pagada).
- **Letras compuestas, no descargadas:** las 29 letras se compusieron con las hojas de estilo públicas de Fontshare y Google Fonts en Chrome sin ventana. No se descargó ningún archivo de fuente.
- **Probadas en su propia página:** para la 3.7, cada letra de Pangram Pangram, Velvetyne y Collletttivo se probó escribiendo «relevo» dentro de la página de su fundición, que ya carga la fuente para su probador; no se descargó ningún archivo. La de Fontshare se probó con su hoja de estilo pública.
- **Autorías verificadas:** la autoría de las dieciocho y la licencia de cada fuente se leyeron en las páginas de cada una (Pangram Pangram exige comprar licencia para un logotipo real).
- **Descargas con permiso:** en la segunda ronda se bajaron 84 archivos (repositorios de GitHub y Codeberg, zips de UNCUT y archivos de los sitios de sus autores). Se guardaron fuera del repositorio, no se instaló ni ejecutó nada y no se usó ningún formulario. Las letras de Google Fonts se excluyeron.
- **Un tropiezo técnico:** Windows no abría los archivos de rutas de más de 260 caracteres; varias letras salían con la letra de reemplazo hasta que se copiaron a una ruta corta. La verificación del navegador decía «sin cargar» en letras que sí cargaban, así que se revisó cada imagen a ojo.
- **Lectura letra por letra (3.8):** cada una de las 108 letras se escribió en grande, con «relevo», «RELEVO», la firma y los acentos, y se miró; las catorce elegidas tienen una lámina con la palabra, cada letra suelta con notas numeradas y pruebas en azul. Las notas anotan solo lo que se ve; la relación con los conceptos de Relevo se declara como hipótesis de diseño.
- **Hechos leídos en la fuente:** la página de cada letra se leyó para la autoría, la licencia y la descripción; así se corrigió una primera impresión errónea de Typefesse (se leyó como manos y la página dice que son glúteos) y se supo que los agujeros de Pilowlava son del estilo Atome.
- **Pruebas medidas:** minúsculas propias y acentos se comprobaron dibujando cada carácter en un canvas con dos tipografías de respaldo, y se midió lo que ocupa «relevo» a 32 px; la primera prueba no detectaba glifos vacíos y se corrigió.
- **De la amplitud a la decisión:** primero las 29 letras en una grilla, después seis en usos reales con el azul nuevo y la familia de colores, y al final tableros completos de tres.

## 3. Qué se comprobó y qué no

- **Comprobado:**
  - la lámina a 1280 y 400 px, sin desbordes;
  - los datos de autoría de Chubbo, Calistoga y Fraunces;
  - las licencias;
  - el antecedente de Mailchimp en Design Week.
- **Para la 3.7:** la lámina a 1280 y 400 px sin desbordes; los dieciocho tableros con la fuente cargada en cada uno.
- **Para la versión 2:** las 69 letras de UNCUT y las 19 de Open Foundry se revisaron en sus imágenes; los doce tableros nuevos con la fuente cargada; la licencia de cada finalista nueva, en la página de UNCUT u Open Foundry.
- **Para la 3.8:** las catorce láminas de lectura y la página a 1280 y 390 px, con el filtro por concepto y la ampliación de láminas funcionando; las autorías y las licencias, en la página de cada letra; los acentos y las minúsculas, con la prueba de canvas.
- **No comprobado:**
  - la lectura de conceptos con personas;
  - las 17 letras nuevas que solo se vieron en la hoja de contacto;
  - las letras con personas;
  - Chubbo dentro de la app, porque incorporarla requiere descargar la fuente.

## 4. Pendientes

- Que el autor elija la letra del logotipo (Chubbo, Calistoga o Fraunces Soft) y diga si también va en titulares de campaña.
- Que el autor apruebe el azul `#1C3891`.
- Con su permiso, descargar la fuente elegida para dibujar el logotipo en curvas y probarla en la app.
- Que el autor elija entre las treinta finalistas de la 3.7; la descarga de los archivos de la o las elegidas ya está autorizada.
- Que el autor elija entre las catorce fichas de la 3.8 (cinco de logotipo, tres de señal y seis de carteles) y diga si los carteles pueden ir en mayúsculas.
- Retomar la exploración de los visuales generales (composición, fotografía, app, movimiento y objeto), que el 3 de octubre se cortó por el límite de uso.

## Registro de cambios (disclaimer)

### 2026-10-04 — Letras que dicen relevo

- **Qué cambió:** se suma la propuesta 3.8 con lo hecho, lo comprobado y lo pendiente.
- **Cómo estaba antes:** la bitácora llegaba a la versión 2 de la propuesta 3.7.
- **Por qué:** el autor pidió buscar más letras de tipo display y analizarlas, viéndolas y leyendo qué conceptos de Relevo evocan.

### 2026-10-04 — Letras para relevo, versión 2

- **Qué cambió:** se suma la versión 2 de la propuesta 3.7 con lo hecho, lo comprobado y lo pendiente.
- **Cómo estaba antes:** la bitácora tenía solo la primera versión de la 3.7.
- **Por qué:** el autor dio permiso para descargar lo que quisiera de las fuentes que quisiera y pidió explorar más.

### 2026-10-04 — Corrección de un término

- **Qué cambió:** «Credenciales verificadas» pasa a «Autorías verificadas».
- **Cómo estaba antes:** el término decía credenciales, que no es lo que se verificó.
- **Por qué:** lo verificado fueron las autorías y las licencias de las letras.

### 2026-10-04 — Letras para relevo

- **Qué cambió:** se suma la propuesta 3.7 con lo hecho, lo comprobado y lo pendiente.
- **Cómo estaba antes:** la bitácora terminaba en la propuesta 3.6.
- **Por qué:** el autor pidió explorar más tipografías, usar más licencias porque el proyecto no sale a la venta, no usar Google Fonts en el logotipo y tener una variedad de elecciones.

### 2026-10-04 — Creación

- **Qué cambió:** se creó la bitácora del 4 de octubre con la propuesta 3.6.
- **Cómo estaba antes:** la última bitácora era la del 3 de octubre.
- **Por qué:** regla de registrar el trabajo con IA de cada día.
