# Encargo 17 — Wireframes: del flujo a la estructura

## Resultado

El Encargo 17 quedó desarrollado como un tablero editable de baja fidelidad:

- **Figma:** [Relevo — Encargo 17 · Wireframes estructurales](https://www.figma.com/design/kjzrPcLGWfoJZAVANivEo4)
- **Fecha de cierre estructural:** 25 de agosto de 2026.
- **Fuente académica:** [memoria integral v2](../08_memoria/memoria-vigente-v2.md).
- **Fundamento detallado:** [preparación escrita](preparacion-escrita-encargo-17.md).
- **Decisión asociada:** D-032 en el [registro de decisiones](../09_decisiones/registro-de-decisiones.md).

La entrega contiene exactamente tres interacciones y nueve marcos. Ocho marcos corresponden a estados o tareas coordinadas desde Android; el marco 3.2 representa el momento físico situado y no una interfaz instalada en el testigo.

Como complemento, el [anexo de cobertura de interacciones](anexo-cobertura-interacciones-encargo-17.md) registra y representa las 35 ramificaciones del ciclo mínimo en una [página separada del mismo archivo Figma](https://www.figma.com/design/kjzrPcLGWfoJZAVANivEo4?node-id=13-2). El anexo permite revisar validaciones, salidas voluntarias, fallos técnicos y estados límite sin alterar el tablero exigido por la pauta ni presentarlos como funciones adicionales.

Además, se produjeron [siete láminas detalladas de referencia](wireframes-referencia/README.md) para reconstruir manualmente los 35 estados en Figma. Estas imágenes amplían componentes y jerarquías, pero no forman parte de la cuenta evaluable de nueve marcos ni fijan el diseño final.

## Resumen del recorrido

| Interacción | Marcos | Resultado |
| --- | --- | --- |
| 1. Formular y preparar una intención | 1.1 Formular; 1.2 configurar condición provisional; 1.3 revisar. | Ciclo configurado y listo para asociar con el lugar. |
| 2. Situar, probar y armar el testigo | 2.1 Situar; 2.2 probar el pulso; 2.3 armar mediante control físico provisional. | Testigo situado, probado y ciclo armado explícitamente. |
| 3. Recibir el pulso y cerrar el ciclo | 3.1 Esperar; 3.2 recibir el pulso situado; 3.3 cerrar o recuperar un fallo técnico. | Decisión abierta y retorno a reposo; sin rearme automático. |

## Decisiones estructurales aplicadas

- Un ciclo contiene una intención, un primer paso, una condición observable provisional, un testigo y un pulso.
- La última confirmación de armado se representa provisionalmente mediante una pulsación prolongada en el control físico.
- El recorrido normal no exige volver al teléfono para interpretar el pulso.
- Después del pulso, silencio, vencimiento o desarmado, el ciclo termina.
- El rearme siempre es explícito.
- Iniciar, continuar, ignorar o silenciar son respuestas válidas y no se registran como cumplimiento.
- La condición mostrada en los wireframes funciona como ejemplo estructural; P0–P4 deben determinar su pertinencia y factibilidad.

## Correspondencia con la pauta

| Requisito | Evidencia de cumplimiento |
| --- | --- |
| Tres interacciones derivadas del flujo | Tres secciones conectadas por salidas y continuidades explícitas. |
| Máximo tres pantallas por interacción | Tres marcos por sección; nueve en total. |
| Componentes identificados | Etiquetas visibles: campo, selector, tarjeta, estado, acción, control físico, respuesta y variante de error. |
| Leyenda de tres a cinco líneas | Una leyenda de cuatro líneas en cada sección. |
| Objetivo, información, acción, jerarquía y errores | Panel de fundamentación completo en cada interacción. |
| Baja o media fidelidad | Escala de grises, trazos simples, Roboto utilitaria y ausencia de identidad visual. |
| Recorrido conectado | Configurar → situar/probar/armar → esperar/pulso/cerrar. |

## Auditoría técnica del archivo

La revisión programática del tablero produjo:

- tres secciones;
- nueve marcos, distribuidos 3 + 3 + 3;
- 186 nodos de texto;
- tipografía Roboto en todos los textos;
- ningún color fuera de escala de grises;
- ningún elemento desbordado;
- tres leyendas de cuatro líneas;
- presencia explícita de condición provisional y marco contextual phygital.

La inspección visual se realizó por sección y sobre el tablero completo. Se corrigieron solapamientos de título y contenido en la interacción 1. Una auditoría independiente posterior separó las salidas voluntarias de los errores técnicos y aclaró que el fallo de 3.3 es una variante alternativa del mismo marco, no una cuarta pantalla.

La auditoría complementaria verificó 35 wireframes en cinco secciones, 475 nodos de texto en Roboto, escala de grises y ausencia de desbordes. También confirmó que el marco evaluable `2:2` conserva sus dimensiones, nueve pantallas y contenido previo.

## Límites

Los wireframes no son una interfaz validada ni una especificación técnica final. No acreditan comprensión del armado físico, percepción del pulso, accesibilidad, convivencia, ejecución Android/BLE, eficacia, adopción ni valor superior frente a una notificación. Forma, materialidad, señal, condición y gesto final permanecen abiertos a prototipado.

## Cabos que no bloquean la entrega

1. Seleccionar la condición de activación definitiva.
2. Evaluar el gesto de armado y la salida física.
3. Elegir canal, duración e intensidad del pulso.
4. Resolver forma y materialidad del testigo.
5. Probar accesibilidad y convivencia.
6. Verificar enlace, batería, vencimiento y segundo plano en Android.

Estos puntos pertenecen al desarrollo P0–P4. Convertirlos ahora en especificaciones cerradas produciría una precisión no respaldada.

## Cobertura complementaria

El anexo mantiene cinco familias de estados: configuración; vinculación y prueba física; armado; espera y señal; cierre y recuperación. Cada estado posee un wireframe separado para inspección, aunque no todos exigen atención de la persona durante el uso. En particular, la vinculación del testigo queda explícita como precondición del emplazamiento y el vencimiento sin pulso queda registrado como un cierre válido.

---

## Registro de cambios (disclaimer)

### 2026-08-25 — Láminas de referencia para Figma

- **Cambio:** se enlazaron siete láminas detalladas que cubren los estados 01–35.
- **Versión anterior:** el documento remitía únicamente al tablero estructural y su anexo editable.
- **Motivo:** facilitar el redibujo manual de wireframes más completos sin alterar la pauta.
- **Alcance:** referencias sintéticas de baja fidelidad; no reemplazan el archivo editable ni la validación.

### 2026-08-25 — Anexo exhaustivo de interacciones

- **Cambio:** se enlazó una matriz de 35 estados, su página complementaria en Figma y la auditoría correspondiente.
- **Versión anterior:** la documentación se limitaba a las tres interacciones y nueve marcos evaluables.
- **Motivo:** comprobar las ramificaciones del ciclo mínimo sin modificar la estructura exigida por el Encargo 17.
- **Alcance:** los nuevos marcos funcionan como anexo de cobertura; no agregan funciones ni sustituyen investigación y validación.

### 2026-08-25 — Creación de la entrega

- **Cambio:** se documentó el archivo Figma, el recorrido de nueve marcos, la correspondencia con la pauta y la auditoría técnica.
- **Versión anterior:** solo existían requisitos y una preparación escrita; no había un entregable visual editable.
- **Motivo:** mantener trazabilidad entre memoria, decisiones, estructura y archivo de trabajo.
- **Alcance:** el documento registra un wireframe de baja fidelidad y no resultados de validación.
