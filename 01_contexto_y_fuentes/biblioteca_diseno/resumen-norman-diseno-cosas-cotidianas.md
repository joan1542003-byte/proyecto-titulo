# Don Norman — diseño de las cosas cotidianas

## Referencia APA 7 provisional

Norman, D. A. (2002). *The design of everyday things*. Basic Books.

**Dato por confirmar:** el PDF incluye un prefacio identificado como correspondiente a la edición de 2002, pero la copia revisada no permite confirmar de manera completa la editorial, el ISBN ni la edición bibliográfica exacta desde su página legal. La referencia anterior es provisional.

## Estructura de la obra

El libro contiene un prefacio a la edición de 2002, un prefacio general y siete capítulos: `The Psychopathology of Everyday Things`, `The Psychology of Everyday Actions`, `Knowledge in the Head and in the World`, `Knowing What to Do`, `To Err Is Human`, `The Design Challenge` y `User-Centered Design`. Le siguen notas, lecturas sugeridas, referencias e índice. La lectura cubrió las 270 páginas del PDF, incluida la última página del índice.

## Tesis y conceptos centrales

Norman sostiene que muchos problemas atribuidos a la torpeza de las personas provienen de diseños que no hacen comprensibles sus posibilidades, relaciones y estados. Un objeto bien diseñado comunica qué se puede hacer, cómo hacerlo y qué ocurrió después. El autor no propone sacrificar la belleza por la facilidad de uso: plantea equilibrar comprensión, seguridad, función, costo y placer.

Una **affordance** es una relación entre las propiedades de un objeto y una acción posible; por ejemplo, una superficie plana puede permitir apoyar algo. En el uso cotidiano, lo decisivo es que esa posibilidad pueda percibirse mediante claves visibles. En Relevo, esas claves pueden ser una etiqueta, la forma de un control o una respuesta del sistema que haga reconocible la acción, no una textura decorativa. La edición revisada no utiliza el término *signifier*, incorporado por Norman en formulaciones posteriores; por eso aquí no se le atribuye ese concepto a la copia de 2002.

El **mapeo** es la relación entre un control y el efecto que produce. Un mapeo natural aprovecha relaciones espaciales, culturales o físicas que reducen la necesidad de memorizar reglas. La **retroalimentación** comunica el efecto de una acción. Si alguien vincula un testigo, prueba una señal o desarma un ciclo, debe poder saber qué ocurrió y qué salida tiene.

Las **restricciones** limitan las acciones posibles para reducir errores. Norman distingue restricciones físicas, semánticas, culturales y lógicas. El libro no propone eliminar toda elección: muestra que una buena estructura puede evitar acciones imposibles o ambiguas sin convertir el sistema en una barrera.

El **modelo conceptual** es una explicación simplificada de cómo funciona un sistema. Permite anticipar el efecto de una acción. Si Relevo muestra una condición técnica, una intención, un lugar y un testigo, la persona debe poder comprender cómo se relacionan; de lo contrario, puede crear una explicación equivocada.

El ciclo de acción se organiza en una meta, una intención, una secuencia de acciones, su ejecución, la percepción del resultado, su interpretación y su evaluación. Norman lo presenta como un modelo aproximado, no como una descripción completa de la conducta. Los abismos de ejecución y evaluación nombran la distancia entre lo que alguien quiere hacer, las acciones que el sistema ofrece y la información disponible para interpretar el resultado.

## Argumentos y ejemplos relevantes

La puerta que no indica si debe empujarse o tirarse muestra que la estética no compensa la ausencia de señales. El proyector de diapositivas, operado con un solo botón para avanzar o retroceder mediante duraciones distintas, muestra un mapeo arbitrario y una retroalimentación insuficiente. El termostato evidencia que una interfaz puede inducir un modelo mental equivocado aunque sus controles parezcan familiares.

El análisis de las tijeras muestra la combinación de affordances, restricciones y mapeo: los agujeros sugieren introducir los dedos, su tamaño limita la acción y la relación entre mango y hoja ayuda a anticipar el resultado. En el capítulo sobre errores, Norman plantea que todo error posible debe considerarse, que sus efectos deben ser detectables y, cuando sea posible, reversibles. El capítulo final insiste en observar a las personas, hacer visible el estado del sistema y evaluar la relación entre intención, acción y resultado.

## Aporte para Relevo

Norman permite revisar el flujo de Relevo en dos niveles. En Android, la persona necesita reconocer qué está configurando, qué dato pertenece a su intención, qué es un estado técnico y qué control puede editar, probar, armar o desarmar. Una pantalla que usa puntos, cápsulas o superficies similares para funciones distintas aumenta el abismo de ejecución y dificulta el modelo conceptual.

En el objeto, el control para silenciar o probar la señal debe tener una acción perceptible y un resultado claro. El sistema no debe hacer creer que el objeto almacena texto, evalúa a la persona o detecta por sí mismo un estado subjetivo. El vínculo entre aplicación, objeto y lugar debe estar explicado en la configuración y confirmado por pruebas, porque la señal física no podrá depender de una pantalla instalada en el testigo.

El principio de diseñar para el error es especialmente pertinente para permisos revocados, pérdida de Bluetooth, batería insuficiente, reubicación del objeto, cambio de intención y señales tardías. La salida debe permitir recuperar, modificar o cerrar sin culpa y sin rearme automático.

## Qué no justifica

El libro no demuestra que una señal física sea mejor que una notificación, que una ubicación doméstica facilite el recuerdo de una intención ni que Android sea la plataforma adecuada. Tampoco valida la hipótesis de Relevo, sus colores, la forma del testigo o el uso de puntos. Sus ejemplos muestran principios de comprensión y evaluación; no son resultados de usuarios de este proyecto.

Norman defiende visibilidad y retroalimentación, pero esto no significa que Relevo deba mostrar toda la información en todo momento. El contenido de una intención puede ser privado y la señal debe ser discreta. La aplicación puede mostrar lo necesario durante la configuración y dejar que el objeto actúe como señal breve en el entorno. La distribución exacta debe comprobarse.

## Decisiones posibles y validación

| Aporte | Decisión provisional | Validación necesaria |
| --- | --- | --- |
| Claves visibles y affordances percibidas | Nombrar con claridad `intención`, `primer paso`, `condición`, `lugar`, `testigo`, `probar` y `desarmar`. | Prueba de comprensión y observación de errores sin explicación adicional. |
| Mapeo | Ordenar la aplicación desde intención hacia primer paso, lugar y armado; mostrar el resultado de cada acción. | Recorrido guiado y prueba sin ayuda para detectar confusiones. |
| Retroalimentación | Informar vínculo, prueba, armado, desconexión y cierre como estados distintos. | Simular cada estado y comprobar si la persona puede decir qué ocurrió y qué puede hacer. |
| Restricciones | Evitar que el sistema arme un ciclo sin confirmación o envíe señales fuera de vigencia. | Ensayos técnicos de permisos, reconexión, vencimiento y comandos tardíos. |
| Diseño para el error | Ofrecer reintentar, reubicar, editar, silenciar y cerrar sin evaluación. | Prueba de fallos y registro de recuperación, no de obediencia. |
| Observación | Mirar qué hace la persona antes de corregir el diseño. | Observación estructurada en prototipos progresivos. |

## Referencia aplicable y límite de transferencia

La lectura sustenta una auditoría de comprensión. No convierte los componentes de Relevo en equivalentes de una puerta, unas tijeras o un panel de control. El proyecto debe conservar su propósito: una aplicación que organiza y confirma, un testigo físico que emite una señal situada y una decisión que sigue perteneciendo a la persona.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación del resumen

- **Cambio:** se creó una síntesis de la obra completa suministrada, con referencia provisional, conceptos, ejemplos, aportes, límites y decisiones posibles para Relevo.
- **Situación anterior:** Norman aparecía mencionado de forma general en la memoria y en la dirección visual, pero no existía una lectura documentada de esta copia ni una separación entre principio y validación.
- **Motivo:** convertir affordances percibidas, claves visibles, mapeo, retroalimentación, restricciones, modelos conceptuales y errores en criterios verificables para el sistema phygital.
- **Asunto abierto:** confirmar edición, editorial e ISBN antes de trasladar la referencia a la bibliografía final.

### 2026-08-29 — Precisión terminológica de la edición

- **Cambio:** se retiró la atribución del término *signifier* a la copia de 2002 y se reemplazó por claves visibles y affordances percibidas.
- **Situación anterior:** el resumen trataba los significantes como un concepto desarrollado en esta edición, aunque el término no aparece en su capa textual.
- **Motivo:** distinguir el contenido efectivamente comprobado en el PDF de formulaciones posteriores de Norman.
