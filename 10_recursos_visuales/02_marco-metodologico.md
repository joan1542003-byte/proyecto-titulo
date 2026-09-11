# Marco metodológico para el nuevo sistema visual

## Enfoque

El sistema visual se desarrollará mediante diseño centrado en las personas. La norma ISO 9241-210:2019 plantea que el diseño de sistemas interactivos debe considerar a las personas, sus tareas y sus contextos durante todo el ciclo de vida. Aplicado a Relevo, esto impide cerrar una identidad solo por preferencia del diseñador: la aplicación, el testigo y la comunicación deben relacionarse con situaciones observables y volver a evaluarse a medida que el prototipo avanza (International Organization for Standardization [ISO], 2019a).

El proceso se organiza con el Doble Diamante: descubrir, definir, desarrollar y entregar. El modelo alterna apertura y selección, pero no describe una secuencia irreversible. El Design Council señala que los resultados tempranos pueden obligar a volver sobre el problema y que la entrega incluye probar, descartar y mejorar a pequeña escala (Design Council, s. f.).

## Fase 1: descubrir

### Objetivo

Comprender qué significados, expectativas y confusiones existen alrededor de Relevo antes de decidir su forma.

### Fuentes

- entrevistas P1–P8 y perfiles situacionales;
- memoria vigente y estado del arte;
- flujo Android y estados de recuperación;
- restricciones del testigo físico;
- referentes comerciales de bienestar digital, objetos de fricción y recordatorios ambientales;
- normas de interacción, accesibilidad, señales luminosas y auditivas.

### Preguntas

- ¿Qué hace pensar que el sistema bloquea, mide o juzga?
- ¿Qué necesita comprenderse antes de armar un ciclo?
- ¿Qué diferencia una señal cotidiana de una alarma?
- ¿Cómo se reconoce un control físico sin exponer la intención?
- ¿Qué rasgos acercan el producto al hogar y cuáles lo vuelven ambiguo?

## Fase 2: definir

Los hallazgos se transforman en requisitos, no directamente en formas. Cada requisito debe indicar la fuente, el riesgo que controla y cómo se comprobará.

| Requisito | Fuente principal | Prueba prevista |
| --- | --- | --- |
| Distinguir contenido, acción, elección y estado | Norman; ISO 9241-110; errores observables del flujo | Clasificación y recorrido sin ayuda. |
| Mantener visible la autonomía | Entrevistas; alcance de Relevo; investigación en bienestar digital | Preguntas de comprensión y revisión del lenguaje. |
| No depender de un solo canal sensorial | WCAG 2.2; diseño inclusivo; ISO 24550 | Pruebas con color alterado, sonido silenciado y distintas condiciones de luz. |
| Evitar sobrecarga visual | W3C; estudios sobre complejidad de interfaces | Comparación de variantes y desempeño en tareas. |
| Integrar forma, material, fabricación y uso | Munari; desarrollo físico | Prototipos de volumen, manipulación e instalación. |
| Mantener continuidad sin uniformidad | Investigación de identidad visual y sistemas de diseño | Auditoría transversal de significados, no de parecido superficial. |

## Fase 3: desarrollar

La exploración formal deberá producir pocas alternativas contrastantes. Crear variaciones casi idénticas no permite aprender qué decisión causa una diferencia.

Para cada alternativa se documentará:

1. principio que la origina;
2. soporte y tarea donde se aplica;
3. decisiones estructurales;
4. decisiones expresivas;
5. riesgos;
6. condición de descarte;
7. prueba necesaria.

La investigación de Gregersen y Johansen (2018) cuestiona la idea de que una identidad deba ser idéntica en todos los medios. Propone entender la consistencia como un continuo y distinguir la continuidad a través del tiempo de la repetición entre plataformas. Para Relevo, la continuidad debe residir en la jerarquía, el lenguaje, la autonomía y el tratamiento de estados; no en repetir un motivo gráfico en cada soporte.

## Fase 4: entregar

El cierre visual no será una elección subjetiva entre tableros. Requiere resultados verificables en cinco niveles:

- **comprensión:** las personas entienden propósito, secuencia y opciones;
- **operación:** pueden completar las tareas críticas y recuperarse de errores;
- **percepción:** la señal se distingue en condiciones relevantes sin ser excesiva;
- **identificación:** la marca se reconoce y no se confunde con categorías equivocadas;
- **producción:** pantalla, impresión y objeto pueden realizarse con los recursos del proyecto.

## Métodos específicos

### Auditoría heurística

Se utilizarán los principios de interacción de ISO 9241-110:2020 y los conceptos de modelo conceptual, correspondencia, retroalimentación y recuperación de Norman. La auditoría detectará ambigüedades antes de convocar participantes; no reemplazará las pruebas con personas (ISO, 2020; Norman, 2002).

### Comparación semántica

La forma física y la identidad se compararán mediante pares de atributos comprensibles: discreto–dominante, cercano–distante, cotidiano–clínico, ayuda–control, claro–ambiguo. Los atributos deben verificarse con personas, porque diseñadores y usuarios pueden atribuir significados distintos a la misma forma (Hsu et al., 2000).

### Prueba perceptual de color

Albers (2013) demuestra que la apariencia del color depende del contexto, la cantidad, el material y los colores vecinos. Por eso no se aprobará una paleta mediante muestras aisladas. Cada rol se probará en pantalla, impresión y luz física, con contraste medido y lectura humana.

### Pruebas de accesibilidad

WCAG 2.2 será el umbral verificable para contraste, foco, ampliación y comunicación no dependiente del color. Android añade objetivos táctiles de al menos 48 × 48 dp, etiquetas accesibles y pruebas con TalkBack. Cumplir una guía no convierte automáticamente el producto en accesible; se requieren pruebas manuales y con personas (Android Developers, s. f.-a; World Wide Web Consortium [W3C], 2023).

### Ensayo situado de la señal

La señal se evaluará en el lugar, a diferentes distancias y con ruido e iluminación variables. ISO 24550:2019 entrega criterios para luces indicadoras y las normas ISO 24500 e ISO 24501 abordan señales auditivas en productos de consumo. Estas normas orientan la medición; no fijan por sí solas el patrón adecuado para Relevo (ISO, 2010a, 2010b, 2019b).

## Escala de decisión

| Nivel | Significado | Uso permitido |
| --- | --- | --- |
| Hipótesis | Relación plausible sin prueba específica | Explorar y comparar. |
| Criterio | Restricción sustentada por evidencia o norma | Exigir en todas las alternativas. |
| Decisión provisional | Alternativa seleccionada para prototipar | Aplicar de manera controlada y probar. |
| Decisión validada | Superó el criterio definido en su contexto | Incorporar al sistema vigente. |
| Especificación | Valor listo para producción | Documentar medida, tolerancia y soporte. |

## Regla contra el sobrediseño

Antes de añadir un elemento se preguntará qué información, acción o estado deja de comprenderse si se elimina. Si nada se pierde, el elemento no entra a la versión de prueba. Esto no prohíbe la expresión de marca; obliga a situarla donde aporte reconocimiento sin competir con la tarea.

---

## Registro de cambios (disclaimer)

### 2026-09-11 — Creación del marco metodológico

- **Qué cambió:** se definió un proceso de cuatro fases, una escala de decisión y métodos para interfaz, forma, color, accesibilidad y señal.
- **Cómo era antes:** la documentación combinaba metodología, reglas visuales y producción en distintos niveles de certeza.
- **Por qué se decidió:** impedir que una preferencia formal se presente como resultado y vincular cada decisión con una prueba.
- **Límite:** las normas citadas orientan criterios; la consulta de sus resúmenes públicos no sustituye la adquisición de los textos completos cuando se necesite acreditar conformidad.
