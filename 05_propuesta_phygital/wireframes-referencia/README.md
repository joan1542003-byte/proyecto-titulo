# Wireframes generados de referencia — Encargo 17

## Propósito

Esta carpeta contiene siete láminas rasterizadas con 35 wireframes de baja fidelidad. Su finalidad es servir como referencia detallada para reconstruir y ajustar manualmente los marcos en Figma. No reemplazan el tablero editable, la memoria ni las decisiones posteriores de prototipado.

Los wireframes amplían la resolución visual de la [matriz de cobertura](../anexo-cobertura-interacciones-encargo-17.md). La ruta evaluable de tres interacciones y nueve marcos continúa siendo la entrega principal.

## Inventario

| Lámina | Estados incluidos | Dimensiones |
| --- | --- | --- |
| [A — Configuración](A-configuracion.png) | 01–06: inicio, validación, permisos, revisión y salida. | 1822 × 863 px |
| [B1 — Vinculación](B1-vinculacion.png) | 07–10: búsqueda, confirmación, error de identidad y batería baja. | 1822 × 863 px |
| [B2 — Prueba física](B2-prueba-fisica.png) | 11–14: lugar, percepción, intrusión y preparación. | 1823 × 863 px |
| [C — Armado](C-armado.png) | 15–19: confirmación, armado, fallo, desarmado y edición. | 1822 × 863 px |
| [D — Espera y señal](D-espera-y-senal.png) | 20–24: espera, condición, vencimiento, pulso situado y respuesta libre. | 1802 × 872 px |
| [E1 — Cierre y recuperación](E1-cierre-y-recuperacion.png) | 25–30: cierre, cambio de intención y recuperaciones técnicas. | 1802 × 873 px |
| [E2 — Estados finales](E2-estados-finales.png) | 31–35: batería crítica, reinicio, vencimiento, rearme y eliminación. | 1801 × 873 px |

## Uso recomendado en Figma

1. Importar una lámina en una página de trabajo separada.
2. Bloquearla y reducir su opacidad para usarla como guía.
3. Reconstruir cada marco con componentes editables; no convertir la imagen en interfaz final.
4. Mantener la numeración y comprobar cada transición contra la matriz escrita.
5. Corregir cualquier detalle que cambie cuando la condición, el gesto físico o la señal sean prototipados.

La lámina D contiene una excepción deliberada: el estado 23 se representa como escena física situada y no como pantalla móvil. Esto conserva la función central del testigo durante el pulso.

## Criterios conceptuales aplicados

- una intención, un primer paso, una condición observable provisional, un testigo y un pulso por ciclo;
- armado y rearme explícitos;
- lugar declarado y percepción confirmada por la persona;
- Android configura, informa estado y facilita recuperación;
- el pulso ocurre en el entorno físico y no requiere volver al teléfono;
- iniciar, continuar, ignorar, silenciar o cambiar de intención son decisiones válidas;
- ausencia de bloqueo, puntuación, rachas, seguimiento de cumplimiento e inferencia subjetiva;
- fallos técnicos descritos sin atribuir responsabilidad a la persona.

## Control de calidad

La revisión se realizó lámina por lámina. Se comprobó:

- presencia correlativa de los estados 01–35;
- consistencia de proporción, jerarquía y lenguaje Android;
- escala de grises y baja fidelidad;
- legibilidad suficiente para calcar;
- ausencia de pantallas o interfaces incorporadas al testigo físico;
- distinción entre salida voluntaria, validación y fallo técnico;
- cierre sin registro de cumplimiento y rearme no automático.

Durante la auditoría se regeneraron fragmentos para:

1. limitar los permisos a observación y continuidad del ciclo;
2. distinguir batería insuficiente de un fallo de vinculación;
3. describir silenciar como detención del pulso activo, no de pulsos futuros;
4. reemplazar una condición físicamente inferida por un evento observable en la aplicación;
5. explicitar que el cambio de lugar lo informa la persona.

## Procedencia y conjunto de prompts

Las siete imágenes se produjeron mediante el modo integrado de generación de imágenes. Se utilizó el siguiente prompt base:

> Crear una lámina horizontal de wireframes Android profesionales de baja fidelidad, en escala de grises, con marcos verticales completos, jerarquía práctica, tipografía sans serif legible y separación suficiente para calcar en Figma. Mantener un lenguaje visual constante entre láminas. No incorporar identidad final, color, fotografías, gamificación, bloqueo, vigilancia, inferencia subjetiva, métricas de cumplimiento, logos ni marcas de agua.

A este prompt se añadieron las siguientes especificaciones:

- **A:** estados 01–06; campos de intención, primer paso, aplicación, condición y vigencia; permisos limitados; revisión y salida voluntaria.
- **B1:** estados 07–10; búsqueda Bluetooth, identificación del testigo, fallo de reconocimiento y batería insuficiente.
- **B2:** estados 11–14; declaración manual del lugar, prueba del pulso, señal no percibida o intrusiva y preparación sin armado automático.
- **C:** estados 15–19; confirmación física provisional, estado armado, confirmación ambigua, desarmado y edición protegida.
- **D:** estados 20–24; espera, orden vigente o expirada, escena física del pulso y respuestas igualmente válidas.
- **E1:** estados 25–30; cierre neutral, cambio de intención, permiso revocado, segundo plano, pérdida de BLE y lugar informado como modificado.
- **E2:** estados 31–35; batería crítica, reinicio, vencimiento, revisión para rearme explícito y eliminación.

Las regeneraciones conservaron la composición y cambiaron únicamente los textos o elementos señalados en el control de calidad.

## Límites

Estas láminas son referencias sintéticas, no evidencia de usuarios ni interfaces validadas. Los ejemplos de contenido no fijan una condición definitiva, una forma del testigo, una intensidad de pulso o una política técnica de Android. Toda reconstrucción debe mantener visibles esas incertidumbres.

---

## Registro de cambios (disclaimer)

### 2026-08-25 — Creación y auditoría de las láminas

- **Cambio:** se generaron y documentaron siete láminas que representan los 35 estados del ciclo mínimo.
- **Versión anterior:** los 35 estados existían como wireframes editables simplificados y como matriz escrita, sin referencias visuales detalladas para calcar.
- **Motivo:** facilitar una reconstrucción manual más rica en Figma sin confundir la referencia rasterizada con diseño final.
- **Alcance:** las imágenes profundizan estructura y jerarquía; no acreditan validación, factibilidad técnica ni decisiones visuales definitivas.
