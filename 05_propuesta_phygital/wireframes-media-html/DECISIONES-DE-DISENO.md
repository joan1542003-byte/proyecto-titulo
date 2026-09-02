# Decisiones de diseño del tablero de wireframes

## Método

Cada decisión responde a cuatro preguntas: qué problema resuelve, de qué antecedente del proyecto se deriva, qué riesgo controla y cómo puede comprobarse. La pauta del Encargo 17 define la cobertura; la memoria vigente define el sentido de la experiencia; el sistema visual v4 aporta retícula, tipografía, color y semántica. Los principios de visibilidad, correspondencia y retroalimentación se apoyan en Norman (2013).

## Decisiones vigentes

| Decisión | Fundamento y riesgo controlado | Comprobación |
|---|---|---|
| Separar catálogo, wireframe y fundamento | Los controles de la entrega no son funciones de Relevo. Evita que navegación o descarga parezcan parte del producto. | El PNG contiene solo la superficie exportable. |
| Usar 412 × 915 dp como base | Entrega una proporción móvil Android representativa sin adjudicar universalidad a un supuesto promedio. | Las 44 superficies comparten la misma medida. |
| No simular hardware | El objeto de revisión es la estructura de la pantalla, no un modelo comercial. | No existen carcasa, cámara, barra de estado ni navegación del sistema. |
| Aplicar retícula de 8 dp, margen de 24 dp y controles de 48 dp | Traslada los tokens vigentes y permite reconstruir la pantalla con medidas consistentes. | Auditoría CSS y exportación sin desbordes. |
| Utilizar IBM Plex Sans y Mono | Distingue lectura de información técnica sin introducir una tercera voz tipográfica. | Fuentes locales incluidas con sus licencias. |
| Trabajar en modo oscuro | Corresponde a la dirección vigente de la interfaz y mantiene continuidad entre sistema visual y wireframes. | Tokens cromáticos coinciden con la especificación v4. |
| Reservar `#D71921` para la señal situada | El rojo comunica la aparición del pulso físico, no prioridad genérica. Evita volver decorativa la señal. | El rojo aparece solo en la representación del momento físico. |
| Usar la marca de puntos como identificador, no como control | La trama permite reconocer a Relevo sin añadir un botón o una pestaña falsa. | La marca no tiene contenedor, estado presionado ni consecuencia interactiva. |
| Diferenciar información, elección y acción | Un dato no debe parecer seleccionable y una elección no debe parecer adorno. | Campos interactivos tienen contorno; información pasiva usa separación; la acción conserva 48 dp. |
| Mantener salidas visibles | La experiencia preserva autonomía, reversibilidad y ausencia de sanción. | Cada marco documenta una salida, recuperación o continuidad. |
| Representar 3.2 como momento físico | El pulso sucede en el entorno y el testigo no posee interfaz propia. | Se utiliza un diagrama contextual, sin botón ficticio ni registro de cumplimiento. |
| Conservar 9 + 35 vistas | Los nueve marcos responden al encargo y la cobertura documenta excepciones sin transformarlas en nuevas interacciones principales. | Catálogo separado para ruta y cobertura. |
| Dividir el mapa en tres niveles | Reunir 44 capturas completas en una sola lámina impide leerlas. La arquitectura, la secuencia y la cobertura responden a preguntas distintas. | Existen un mapa jerárquico, un atlas de nueve pantallas y una lámina de estados por familias. |

## Límites

El tablero demuestra cobertura, coherencia estructural y trazabilidad. No demuestra comprensión, accesibilidad con TalkBack, funcionamiento BLE, percepción del pulso ni eficacia de Relevo; esas afirmaciones requieren prototipos y pruebas con personas.

## Referencias

Norman, D. A. (2013). *The design of everyday things* (Rev. and expanded ed.). Basic Books.

Universidad Diego Portales. (2026). *Encargo 17: Wireframes. Del flujo a la estructura* [Pauta académica].

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Jerarquía visual y mapas legibles

- **Cambio:** las nueve pantallas principales adoptaron el sistema oscuro vigente y el mapa único se dividió en tres escalas de lectura.
- **Antes:** solo una pantalla desarrollaba la dirección visual y el mapa completo dependía de miniaturas.
- **Motivo:** revisar estructura, semántica y lenguaje gráfico en cada marco sin perder una visión completa del sistema.
- **Alcance:** la fidelidad visual no acredita implementación, accesibilidad ni comprensión con personas.

### 2026-09-01 — Coherencia con el sistema visual v4

- **Cambio:** se reemplazó la lámina 4:5 neutra por una ventana Android representativa y se incorporaron retícula, tipografías y códigos cromáticos vigentes.
- **Antes:** la documentación separaba los wireframes del lenguaje visual y declaraba ausencia de identidad.
- **Motivo:** sostener una baja fidelidad bien diseñada sin confundir consistencia gráfica con validación final.
