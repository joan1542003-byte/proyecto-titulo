# Bitácora del trabajo con IA: 5 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code el 5 de octubre de 2026, a pedido del autor. Continúa la [bitácora del 4 de octubre](bitacora-trabajo-con-ia-2026-10-04.md); los pedidos de la noche del 4 (sans para lucirse y tipografías recientes) están en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Qué comprar para el testeo y revisión del logotipo | Respuesta en la conversación: un parlante Bluetooth solo para quien no tenga y, opcional, un llavero iTag. El logotipo vigente del sistema 3.1 contradice pedidos posteriores (letra simple, subrayado y azul antiguo) y no coincide con el de la app. | — |
| Android 2.19, «El llavero» | El autor decidió comprar un iTag y pidió que la app lo haga sonar solo si se le aseguraba que funciona. Salida «El llavero» con búsqueda, prueba, conexión durante la espera, botón que calla la señal, registro y migración de Supabase. [Detalle](../06_desarrollo_y_factibilidad/app-android/version-2.19-llavero-itag-2026-10-05.md). | D-109 |
| Compra del llavero | Tres publicaciones de MercadoLibre Chile que indican la app iSearching, de CLP 5.930 a 7.990, y los pasos para probarlo al llegar. | D-109 |
| Panel privado | Muestra «llavero» como salida y los eventos nuevos. | D-109 |

## 2. Cómo se usó la IA

- **Asegurar lo que se puede asegurar:** el protocolo del iTag se apoyó en el código de una app de código abierto publicada en Google Play, en el manual de iSearching y en análisis independientes. Se dijo al autor que lo verificado es el protocolo, no un anuncio concreto, y que el llavero debe probarse al llegar.
- **MercadoLibre sin cuenta:** las páginas de MercadoLibre piden iniciar sesión y su API respondió 403; no se intentó saltar ese bloqueo. Los precios vienen de los resultados de búsqueda.
- **Robustez antes de tener el llavero:** se agregaron una segunda forma estándar de apagar la alarma por desconexión, la búsqueda de respaldo con todos los aparatos cercanos y el descarte de un aparato que no sabe pitar. Al probar en el emulador apareció un defecto (el aviso «Bluetooth apagado» seguía visible con el Bluetooth encendido) y se corrigió.
- **Privacidad:** la dirección del llavero queda solo en el teléfono, el registro no guarda el nombre del aparato y el permiso se declara sin uso de ubicación. Una nota explica el permiso antes de pedirlo.
- **Pruebas sin ensuciar la base:** cada prueba en el emulador se hizo sin red, con un respaldo de los datos del emulador que se devolvió al terminar y se comparó archivo por archivo; los permisos nuevos se dejaron como estaban.

## 3. Qué se comprobó y qué no

- **Comprobado:**
  - la compilación desde cero y las 81 pruebas unitarias;
  - en el emulador, el panel del llavero, el permiso, el Bluetooth apagado y su encendido con búsqueda automática, la búsqueda sin resultados, la búsqueda de respaldo y el aviso de campo faltante, sin cierres inesperados;
  - la migración en Supabase, con las tres reglas nuevas leídas de la base.
- **No comprobado:**
  - la conexión y el pitido con un llavero real;
  - el botón que calla la señal y el apagado de la alarma por desconexión;
  - una espera larga, la reconexión y un teléfono con Android 12;
  - las publicaciones de MercadoLibre por dentro.

## 4. Pendientes

- Que el autor compre el llavero (conviene dos y una pila CR2032 de repuesto) y lo pruebe con los pasos de la 2.19.
- Que el autor decida si el llavero se usa en la prueba de 21 días; si se usa, nombrarlo en el consentimiento escrito y revisarlo con el profesor.
- Que el autor decida el logotipo y la letra: siguen abiertas las propuestas 3.6 a 3.9, la lámina «Sans para lucirse» y los tableros de tipografías recientes.

## Registro de cambios (disclaimer)

### 2026-10-05 — Creación

- **Qué se añadió:** la bitácora del 5 de octubre, con la consulta de compra y logotipo, Android 2.19 y la compra del llavero.
- **Cómo estaba antes:** la última bitácora era la del 4 de octubre.
- **Por qué:** registrar el trabajo del día, como en los días anteriores.
