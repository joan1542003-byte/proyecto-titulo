# Fundamentación y método de la exploración visual

## Propósito

La exploración busca que Relevo pueda reconocerse en diferentes soportes sin repetir una misma composición. La coherencia se construye mediante relaciones estables entre contenido, jerarquía, contraste y significado. El objetivo no es decorar el proyecto, sino darle un sistema capaz de explicar su funcionamiento, orientar acciones y distinguir una señal situada de cualquier otro estado.

## Método de desarrollo

Se utilizó una secuencia de cuatro operaciones:

1. **Descomposición semántica:** cada pieza se separó en origen, vínculo y señal situada. Esta operación evita seleccionar formas únicamente por gusto.
2. **Traducción por soporte:** la misma relación se adaptó a Android, editorial, cartel y recurso transparente según la tarea de cada medio.
3. **Variación controlada:** se modificaron fondo, densidad, escala, orientación y cantidad de texto sin alterar los roles de color ni la jerarquía básica.
4. **Auditoría:** cada resultado se revisó según legibilidad, función, riesgo de ambigüedad, fidelidad al proyecto y posibilidad de reconstrucción.

El procedimiento se relaciona con la descomposición del problema propuesta por Munari (1971), con la necesidad de hacer visibles las posibilidades de acción señalada por Norman (2002) y con el estudio relacional del color de Albers (2013). Estas fuentes orientan el proceso; no prueban por sí solas que una pieza sea comprendida.

## Decisiones justificadas

### Matriz de puntos

Los puntos se utilizan porque permiten representar continuidad y cambio de organización sin recurrir a una flecha imperativa. Un campo denso comunica origen; la disminución de densidad permite observar una transferencia; un nodo aislado hace visible la señal situada. El recurso se rechaza cuando parece progreso, paginación, selección o carga.

La decisión deriva del concepto del proyecto y no de una referencia formal aislada. La matriz se limita a marca, numerales, relaciones y elementos gráficos breves. IBM Plex Sans conserva la lectura continua, mientras IBM Plex Mono distingue información técnica.

### Rojo de señal

El rojo `#EF3E45` identifica exclusivamente la señal situada. No se aplica a botones, errores, títulos, selección, batería ni decoración. Esta restricción reduce ambigüedad entre una acción digital y el momento perceptible del sistema. Albers (2013) advierte que el color cambia según contexto, proporción y soporte; por ello, el valor debe revisarse en pantalla, papel y material físico.

Varias imágenes generadas aproximan el rojo con valores cercanos, en especial `#D71921`. Esa variación pertenece al mockup y no modifica el token vigente: toda reconstrucción debe aplicar `#EF3E45` y volver a comprobar contraste, impresión y percepción sin color.

### Blanco cálido y grafito

El fondo claro `#F4F4F2` se aproxima al comportamiento del papel y facilita una memoria con lectura prolongada. El grafito `#111314` reduce el contraste extremo de un negro absoluto y sostiene la interfaz digital vigente. Ambos mantienen texto legible, reglas delgadas y espacios amplios, pero no se consideran equivalentes automáticos.

La interfaz clara generada en esta colección funciona como comparación. No reemplaza el contrato oscuro v4 mientras no exista una prueba o decisión registrada.

### Espacio negativo

El espacio vacío organiza la atención y separa relaciones. No se utiliza para ocultar acciones ni para simular sofisticación. Norman (2002) permite justificar que la prioridad sea reconocer la acción y su consecuencia; por ello, los componentes funcionales deben conservar nombres claros, objetivos táctiles suficientes y estados distinguibles.

### Elementos decorativos

Un elemento es decorativo cuando puede retirarse sin perder información ni acción. Debe tener menor contraste, quedar fuera de zonas táctiles y no adoptar contornos propios de botones, selectores o campos. Si una matriz explica origen, vínculo y señal, se clasifica como gráfico informativo y necesita texto equivalente. Esta distinción sigue el contrato semántico de Relevo.

## Traducción entre soportes

| Soporte | Función principal | Uso de la matriz | Tratamiento cromático | Límite |
|---|---|---|---|---|
| Android | Formular, revisar, vincular y recuperar. | Gráfico informativo secundario; nunca reemplaza un control. | Grafito vigente; rojo solo después de la señal situada. | No introducir métricas, tarjetas innecesarias ni navegación ajena al flujo. |
| Memoria | Explicar problema, investigación, decisiones y resultados. | Marca, numerales, diagramas y tablas. | Blanco cálido adaptado a papel. | No reducir legibilidad académica ni presentar imágenes generadas como evidencia. |
| Presentación | Hacer visible una relación a distancia. | Campos amplios y secuencias breves. | Claro u oscuro según contraste ambiental. | No simplificar hallazgos hasta perder precisión. |
| Objeto | Investigar presencia, lugar y señal. | Puede orientar aperturas o distribución de luz, si una prueba lo respalda. | Depende de material y contexto. | No trasladar una interfaz ni fijar una forma industrial desde una imagen. |

## Accesibilidad y validación

Las imágenes no certifican accesibilidad. La reconstrucción debe comprobar contraste mínimo, ampliación de texto, orden de foco, etiquetas, objetivos táctiles de 48 × 48 dp, percepción sin color y reducción de movimiento. Los criterios parten de WCAG 2.2 y de las guías de accesibilidad de Android (Google, 2023; World Wide Web Consortium, 2023).

## Referencias

Albers, J. (2013). *Interaction of color* (4.ª ed.). Yale University Press.

Google. (2023). *Accessibility*. Android Developers. https://developer.android.com/design/ui/mobile/guides/foundations/accessibility

Munari, B. (1971). *Design as art* (P. Creagh, Trad.). Penguin Books. (Trabajo original publicado en 1966).

Norman, D. A. (2002). *The design of everyday things*. Basic Books.

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios

### 2026-09-01 — Aclaración cromática y ampliación

- **Cambio:** se distinguió el token vigente `#EF3E45` de las aproximaciones cromáticas presentes en imágenes generadas.
- **Versión anterior:** la fundamentación declaraba el token, pero no advertía que algunos mockups podían mostrar otro valor.
- **Motivo:** impedir que una variación del generador se interprete como una segunda paleta aprobada.
- **Alcance:** el valor continúa sujeto a pruebas de contraste, impresión y percepción.

### 2026-08-31 — Fundamentación inicial

- **Cambio:** se documentaron método, decisiones formales, traducción entre soportes, límites y criterios de validación.
- **Versión anterior:** las reglas existían en el manual v4, pero las nuevas generaciones todavía no tenían una justificación común.
- **Motivo:** impedir que la colección se evalúe solo por afinidad estética.
- **Alcance:** la fundamentación explica decisiones de trabajo; las pruebas pendientes conservan su estado abierto.
