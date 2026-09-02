# Decisiones de diseño del tablero de wireframes

## Método

Cada decisión se revisa mediante cuatro preguntas:

1. ¿Qué problema de lectura o evaluación resuelve?
2. ¿De qué documento del proyecto se deriva?
3. ¿Qué riesgo introduce?
4. ¿Cómo puede comprobarse?

Este método evita justificar una forma solo por preferencia. Las fuentes de autoridad son la pauta del Encargo 17, la memoria vigente, el anexo de cobertura y el sistema visual v4. Los principios de visibilidad, correspondencia y retroalimentación se apoyan en Norman (2013), sin convertir esa referencia general en evidencia de funcionamiento de Relevo.

## Decisiones vigentes

| Decisión | Fundamento | Riesgo controlado | Verificación |
|---|---|---|---|
| Separar catálogo, lienzo y fundamento | La navegación y la descarga pertenecen a la entrega, no a Relevo | Confundir controles del tablero con funciones del producto | El PNG contiene solo `[data-testid="export-surface"]` |
| Eliminar la simulación de teléfono | El encargo evalúa estructura y flujo; el hardware no aporta información | Presentar el wireframe como interfaz Android terminada | QA confirma ausencia de `.phone-device`, `.device-screen` y barras de sistema |
| Conservar 9 + 35 vistas | La pauta exige nueve marcos; el anexo documenta excepciones sin ampliar la entrega | Contar los estados como nuevas pantallas principales | Selector separado: `Ruta principal · 9` y `Cobertura · 35` |
| Usar un lienzo 4:5 fijo | Facilita comparar y archivar marcos con dimensiones idénticas | Interpretarlo como proporción del teléfono | La cabecera lo identifica como lámina; la documentación declara que no es dispositivo |
| Trabajar en escala de grises | Mantiene la atención en jerarquía, estado y continuidad | Confundir media fidelidad con identidad visual final | No existen tokens de rojo ni imágenes en el CSS del wireframe |
| Utilizar bordes y rellenos planos | Diferencia contenido, elección y acción sin efectos decorativos | Dar jerarquía mediante sombra, textura o acabado | Revisión CSS: sin `box-shadow`, `gradient` o `filter` |
| Aplicar una retícula basada en 4 px | Permite que márgenes, separación y controles respondan a incrementos coherentes | Espaciado arbitrario entre estados equivalentes | Auditoría de tokens y comparación de capturas |
| Mantener tipografía utilitaria | Roboto ofrece lectura estable y no utiliza la tipografía expresiva de la identidad | Adelantar el sistema gráfico final | Una familia para contenido; monospace solo en identificadores técnicos |
| Etiquetar campo, selector, estado y recuperación | El Encargo 17 exige identificar componentes y decisiones | Que un estado parezca una acción o una elección parezca decoración | Cada componente declara su categoría en texto |
| Usar negro lleno solo para la acción primaria | La jerarquía debe distinguir la salida principal sin introducir color | Que acciones secundarias compitan con la continuidad principal | Una acción primaria por marco; alternativas con contorno |
| Mantener salidas visibles | La memoria sostiene autonomía, reversibilidad y ausencia de sanción | Presentar el recorrido como obligatorio | Cada marco incluye salida o error y la nota de decisión permanece visible |
| Representar 3.2 como momento físico | El pulso ocurre en el entorno, no en una pantalla del testigo | Digitalizar la capa física o atribuir interfaz al objeto | Borde discontinuo, rótulo `Momento físico` y diagrama testigo–lugar |
| Presentar respuestas físicas como posibilidades equivalentes | Después del pulso no existe una acción correcta ni una respuesta que deba registrarse | Convertir iniciar, continuar, ignorar o silenciar en botones del testigo | El marco físico no contiene acción primaria; enumera respuestas válidas sin control ejecutable |
| Mostrar continuidad en los estados 01–35 | Los estados deben conducir a una recuperación o cierre documentado | Crear callejones sin salida durante implementación | Cada PNG de cobertura registra `estado → continuidad` |
| Exportar a densidad 2 | Mejora legibilidad al imprimir o incorporar en la memoria | Alterar dimensiones entre vistas | Todas las imágenes miden 1840 × 2300 px |
| Mantener descarga fuera del lienzo | La descarga sirve a quien revisa, no a la persona usuaria de Relevo | Que el botón aparezca como función del producto | QA comprueba que el enlace no sea descendiente del lienzo |

## Retícula y medidas

- Lienzo base: 920 × 1150 px.
- Exportación: 1840 × 2300 px.
- Unidad mínima de espaciado: 4 px.
- Separaciones principales: 8, 12, 16, 24, 28 y 32 px.
- Controles del tablero: altura mínima de 44 px.
- Acción principal representada: 48 px.
- Dos columnas en la leyenda: jerarquía y error o salida.

Las medidas organizan la entrega; no especifican todavía densidad, tamaño táctil o retícula definitiva de la aplicación Android.

## Límites

El tablero puede demostrar cobertura, consistencia y trazabilidad. No puede demostrar comprensión, eficacia de la señal, percepción del pulso, accesibilidad con TalkBack, funcionamiento BLE ni adecuación del gesto físico. Esas preguntas requieren prototipos pertinentes y pruebas con personas.

## Referencias

Norman, D. A. (2013). *The design of everyday things* (Rev. and expanded ed.). Basic Books.

Universidad Diego Portales. (2026). *Encargo 17: Wireframes. Del flujo a la estructura* [Pauta académica].

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Fundamentación integral

- **Cambio:** se documentaron decisiones de estructura, fidelidad, retícula, semántica, exportación y accesibilidad del tablero.
- **Versión anterior:** las razones estaban distribuidas entre README, cobertura, memoria y auditorías visuales.
- **Motivo:** permitir que cada decisión sea revisada por su función, fuente, riesgo y criterio de comprobación.
- **Alcance:** el documento fundamenta la representación de wireframes; no valida la interfaz ni cierra el sistema visual final.
