# Cierre del wireframe v1

**Fecha:** 9 de septiembre de 2026

**Estado:** línea base congelada para construir el primer prototipo

**Referencia Git:** etiqueta `wireframe-v1-2026-09-09`

## Qué se cierra

El wireframe v1 fija la estructura del primer ciclo de Relevo. Incluye nueve marcos principales, desde la formulación de una intención hasta el cierre, y ocho categorías prioritarias de recuperación. Esta versión puede usarse como base de desarrollo porque el recorrido, las acciones, las salidas y los estados necesarios están identificados.

Congelar no significa declarar terminada la interfaz. La condición de activación, la modalidad de la señal, la comprensión de los textos, la accesibilidad con personas y el funcionamiento entre Android y el testigo continúan sujetos a prototipado y prueba.

## Fuentes de la línea base

- [`src/wireframes.ts`](wireframes-media-html/src/wireframes.ts): contenido y cobertura.
- [`src/Prototype.tsx`](wireframes-media-html/src/Prototype.tsx): composición de las vistas.
- [`src/prototype.css`](wireframes-media-html/src/prototype.css): jerarquía y presentación.
- [`public/exports`](wireframes-media-html/public/exports/): 44 exportaciones individuales.
- [`public/exports/maps`](wireframes-media-html/public/exports/maps/): arquitectura, ruta principal y cobertura por familias.
- [`public/exports/manifest.json`](wireframes-media-html/public/exports/manifest.json): inventario reproducible.

## Revisión de la ruta principal

| Marco | Función cerrada en v1 | Resultado de revisión | Lo que falta comprobar |
| --- | --- | --- | --- |
| 1.1 Formular | Registrar una intención y un primer paso. | Cumple estructuralmente. La acción principal y la salida voluntaria son visibles. | Comprensión del primer paso y facilidad de escritura. |
| 1.2 Configurar | Elegir aplicación, condición provisional y vigencia. | Cumple estructuralmente. La condición se presenta como configurable, no como inferencia sobre la persona. | Condición técnicamente viable y lenguaje comprendido. |
| 1.3 Revisar | Comprobar y corregir el ciclo antes de situarlo. | Cumple estructuralmente. Se distinguen datos, estado y continuidad. | Carga de revisión y posibles omisiones. |
| 2.1 Situar | Confirmar testigo y lugar próximo al primer paso. | Cumple estructuralmente. El lugar se declara y puede modificarse. | Asociación efectiva entre lugar, testigo e intención. |
| 2.2 Probar | Emitir un pulso previo y permitir ajustes. | Cumple estructuralmente. La prueba antecede al armado. | Percepción, convivencia, luz, sonido y control local. |
| 2.3 Armar | Confirmar el ciclo mediante el control del testigo. | Cumple estructuralmente. La pantalla no sustituye el gesto físico. | Comprensión del gesto y confirmación BLE. |
| 3.1 Esperar | Mostrar vigencia, condición, testigo y opción de desarmar. | Cumple estructuralmente. El sistema informa sin exigir consulta continua. | Comportamiento Android en segundo plano. |
| 3.2 Recibir | Representar el pulso en el lugar, no una interfaz del objeto. | Cumple estructuralmente. El ámbar se limita al acontecimiento de señal. | Si la señal recupera la intención y qué modalidad resulta adecuada. |
| 3.3 Cerrar | Terminar, salir o preparar otro ciclo sin registrar cumplimiento. | Cumple estructuralmente. Mantiene abierta la decisión posterior. | Comprensión del cierre y necesidad real de rearmado. |

## Recuperaciones incluidas

| Categoría prioritaria | Estados documentados | Decisión para v1 |
| --- | --- | --- |
| Datos incompletos | 02 | Impedir continuidad y mostrar qué falta. |
| Salida voluntaria antes de armar | 06 | Salir sin sanción ni pérdida ambigua. |
| Testigo no disponible | 09 | Volver a buscar o abandonar el armado. |
| Señal no percibida o intrusiva | 12 y 13 | Ajustar señal o lugar; no inferir percepción. |
| Confirmación ambigua | 17 | Mostrar el fallo y permitir repetir o salir. |
| Desarme voluntario | 18 | Finalizar la espera sin emitir el pulso. |
| Vencimiento sin activación | 33 | Cerrar sin fabricar un resultado tardío. |
| Cierre después de silenciar o ignorar | 24 y 25 | No interpretar la respuesta como cumplimiento o fracaso. |

Los demás estados siguen disponibles como cobertura técnica. No forman parte obligatoria de la primera implementación mientras la arquitectura correspondiente no exista.

## Corrección previa al cierre

La base adoptó carbón `#17191B`, superficie `#1F2326`, papel cálido `#F4F1EA` y gris `#AEB4B8`. La señal cambió de rojo `#D71921` a ámbar `#FFB000`. Se regeneraron las 44 vistas y los tres mapas. La corrección no modifica el recorrido: alinea las piezas activas y evita que una señal cotidiana comparta el código visual asociado a alerta o error.

## Verificación

- nueve marcos principales y 35 estados complementarios;
- 44 PNG de 824 × 1830 px sobre una base de 412 × 915 dp;
- tres mapas separados por escala de lectura;
- navegación y selección de vistas aprobadas;
- ausencia de desbordes y errores de consola;
- ámbar restringido al momento de señal;
- compilación y runtime comprobados mediante las pruebas del proyecto.

## Regla de cambio

Desde este cierre, una modificación estructural debe responder a una prueba, un fallo de implementación o una contradicción verificable. El cambio se registra antes de sustituir la línea base e indica marco afectado, evidencia, decisión y consecuencia. Los ajustes meramente decorativos no justifican reabrir el flujo.

## Siguiente paso

Construir la navegación Android mínima con los nueve marcos y las recuperaciones prioritarias. La condición puede simularse localmente hasta que exista una implementación autorizada y comprobable. La señal física y la comparación con una notificación permanecen separadas de este cierre.

---

## Registro de cambios (disclaimer)

### 2026-09-09 — Creación y congelamiento

- **Qué cambió:** se reunió la línea base, se revisaron los nueve marcos y las ocho categorías de recuperación, y se fijó una regla para cambios posteriores.
- **Cómo estaba antes:** existían alcance, exportaciones y auditorías separadas, pero ningún documento declaraba qué versión podía pasar a desarrollo.
- **Por qué se decidió:** evitar que programación, pruebas y documentación trabajen sobre recorridos distintos.
- **Límite:** el cierre acredita coherencia interna y reproducibilidad; no acredita comprensión con personas, accesibilidad real, funcionamiento BLE ni eficacia de la señal.
