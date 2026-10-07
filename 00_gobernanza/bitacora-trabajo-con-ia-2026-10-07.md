# Bitácora del trabajo con IA: 7 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code el 7 de octubre de 2026, día del primer testeo. Continúa la [bitácora del 6 de octubre](bitacora-trabajo-con-ia-2026-10-06.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Llavero comprado | El autor probó su llavero con iSearching y funciona. Puede usarlo en Android si el iPhone se desconecta: el llavero acepta una conexión a la vez. | D-109 |
| Android 2.25 y panel 10 | «Tag» en pantalla y guía de ocho pasos con un Tag redondo animado; el panel permite borrar datos y suma barra lateral, búsqueda y filtros ([app](../06_desarrollo_y_factibilidad/app-android/version-2.25-tag-y-guia-paso-a-paso-2026-10-07.md); [panel](../06_desarrollo_y_factibilidad/panel-admin/README.md)). | D-114 |
| Android 2.24 | Hoja «Cómo usar el llavero» y aviso para callarlo con un toque sin apagarlo ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.24-tutorial-del-llavero-2026-10-07.md)). | D-109 |
| Android 2.23 | Degradados de tres colores, cuatro actividades nuevas (videojuegos, música, películas, llamar a alguien) y opciones de un toque para el primer paso y el lugar ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.23-colores-y-opciones-listas-2026-10-07.md)). | D-113 |

## 2. Cómo se usó la IA

- **Actividades con fuente:** antes de sumar los videojuegos se buscaron en el corpus: aparecen en P3, P6, P7 y P8; música, películas y videollamadas también aparecen.
- **Color revisado en pantalla:** la primera mezcla de amarillo con verde se veía oliva en el emulador; se cambiaron esas familias antes de cerrar.

- **Borrado probado sin borrar:** las consultas de borrado se validaron con `explain` en la base real, sin ejecutarlas, y se probaron completas con datos de ejemplo. No se borró ninguna fila real.
- **Un error antiguo del panel:** en el teléfono, las pestañas quedaban arriba y no abajo, porque el desenfoque de la barra superior las contenía. Se corrigió quitando el desenfoque en el teléfono.

## 3. Qué se comprobó y qué no

- **Comprobado:** compilación desde cero, 83 pruebas y recorrido en el emulador de los intereses a Inicio, con las opciones de un toque.
- **No comprobado:** la app en el teléfono de la persona que participa y el llavero conectado a Relevo.

## 4. Pendientes

- Probar el llavero con Relevo en Android («Probar el llavero»).
- Revisar el consentimiento v13 con el profesor.

## Registro de cambios (disclaimer)

### 2026-10-07 — Android 2.25 y panel 10

- **Qué cambió:** la bitácora suma la 2.25 y el panel 10.
- **Cómo estaba antes:** terminaba en la 2.24.
- **Por qué:** pedido del autor.

### 2026-10-07 — Android 2.24

- **Qué cambió:** la bitácora suma la 2.24.
- **Cómo estaba antes:** terminaba en la 2.23.
- **Por qué:** pedido del autor.

### 2026-10-07 — Creación

- **Qué se añadió:** la bitácora del 7 de octubre.
- **Cómo estaba antes:** la última bitácora era la del 6 de octubre.
- **Por qué:** registrar el trabajo del día.
