# Bitácora del trabajo con IA: 6 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code el 6 de octubre de 2026, a pedido del autor. Continúa la [bitácora del 5 de octubre](bitacora-trabajo-con-ia-2026-10-05.md). Cada pedido está en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Elección libre (Android 2.20) | La persona elige dónde suena y si deja el objeto donde empieza; la app registra A, B o C según su elección. Recorrido completo en emulador como persona nueva ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.20-eleccion-libre-2026-10-06.md)). Panel 6 con «Qué elige». | D-110 |
| APK y panel | Se envió el APK 2.19. El [panel](https://claude.ai/artifact/QMsAiSqpkuivix6FJzh9uM) pasa a la versión 5, con Resultados y Exportar ([cómo funciona](../06_desarrollo_y_factibilidad/panel-admin/README.md)). | D-096 |

## 2. Cómo se usó la IA

- **Estadísticas calculadas en la página:** el panel pide los relevos sin eliminar y calcula las cifras por condición y por persona; las consultas se probaron antes contra la base real.
- **Colores comprobados:** los tres colores de las condiciones se validaron con el script de la guía de visualización (daltonismo en todos los pares y contraste, en claro y oscuro). El verde agua no llega a 3:1 en tema claro, por eso cada barra lleva su letra y su valor escritos.
- **Revisión con datos de ejemplo:** las cinco pestañas se capturaron a 1280 y 390 px, en claro y oscuro, con Chrome sin ventana; así se corrigieron un gráfico demasiado grande, la letra de cada condición que no se veía y el rótulo del encabezado que tocaba las pestañas. Las descargas de CSV y Excel se probaron con los mismos datos.

- **Recorrido como persona nueva:** la app se instaló limpia en el emulador, sin red, y se recorrió de la bienvenida a la respuesta después de la señal, con capturas en cada paso. Así aparecieron los textos que empujaban a dejar el parlante junto al comienzo, que se reemplazaron por textos neutros.

## 3. Qué se comprobó y qué no

- **Comprobado:** las consultas nuevas en Supabase (10 relevos, sin `user_id` en la exportación); las capturas sin desbordes; el CSV con punto y coma y BOM; el Excel generado (61 KB con datos de ejemplo).
- **No comprobado:** la descarga real dentro de claude.ai, que pide la confirmación del autor; el panel con muchos datos, porque la prueba aún no empieza.

## 4. Pendientes

- Revisar el consentimiento v12 con el profesor.
- Preguntar al profesor cuántas personas espera para el Pase de Examen (25 de noviembre) y si acepta un estudio de caso.
- Comprar el iTag y probarlo con los pasos de la 2.19.

## Registro de cambios (disclaimer)

### 2026-10-06 — Elección libre

- **Qué cambió:** la bitácora suma Android 2.20 (D-110) y el recorrido completo en emulador.
- **Cómo estaba antes:** registraba el APK y el panel 5.
- **Por qué:** pedido del autor del mismo día.

### 2026-10-06 — Creación

- **Qué se añadió:** la bitácora del 6 de octubre.
- **Cómo estaba antes:** la última bitácora era la del 5 de octubre.
- **Por qué:** registrar el trabajo del día.
