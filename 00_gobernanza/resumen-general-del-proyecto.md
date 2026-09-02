---
id: RESUMEN-GENERAL-RELEVO-2026-09-02
titulo: "Resumen general del proyecto — Relevo"
fecha_de_corte: 2026-09-02
estado: "síntesis ejecutiva del estado vigente"
---

# Resumen general del proyecto — Relevo

Este documento resume la evolución desde el examen del primer semestre y la memoria del Pase hasta la memoria vigente v4. Reúne el feedback aplicado, las investigaciones realizadas, las decisiones de diseño y lo que todavía debe comprobarse. La fecha de corte es el 2 de septiembre de 2026.

La síntesis distingue entre lo que está documentado, lo que es una decisión de diseño y lo que sigue siendo una hipótesis. Todavía no existen resultados de validación con participantes.

## 1. Qué es Relevo hoy

Relevo es un sistema **phygital** compuesto por una aplicación Android y un testigo físico situado junto al comienzo de una actividad elegida. La persona registra una intención propia, define su primer paso y configura una condición. Cuando esa condición se cumple, el testigo emite un pulso ambiental breve. La persona puede continuar con el ocio digital, silenciar la señal, cambiar de idea o iniciar la alternativa.

Relevo no bloquea aplicaciones, no mide el valor de una persona, no entrega puntos, no crea rachas y no registra si la actividad se realizó. Su propósito es volver a hacer perceptible una intención propia sin convertirla en una orden.

### Propuesta de valor

> Relevo devuelve una intención elegida al momento y al lugar en que puede comenzar, mediante una señal breve, situada y voluntaria.

La propuesta es relevante porque las herramientas existentes suelen medir el tiempo, bloquear el acceso o interrumpir dentro del teléfono. Relevo investiga otra posibilidad: mantener disponible una alternativa sin asumir que todo ocio digital es negativo y sin imponer una conducta.

La deseabilidad todavía es una hipótesis. Una persona podría querer Relevo cuando tiene algo que desea hacer, sabe cómo comenzar y, aun así, pierde esa alternativa durante una sesión digital. No debería quererlo —ni recibir una intervención— cuando ese ocio es significativo, reparador o coherente con su intención del momento.

## 2. Evolución desde el primer semestre

| Momento | Qué cambió | Por qué se tomó la decisión |
|---|---|---|
| Exploraciones iniciales, incluida In(Visible) | El proyecto pasó de un tema amplio sobre ocio digital y desconexión a una situación concreta: una intención alternativa deja de orientar el siguiente paso. | Un problema situado permite investigar una experiencia específica y no generalizar que usar el teléfono siempre es un problema. |
| Examen/Pase del primer semestre | La comisión señaló que no se entendían con precisión el objeto, el contexto, la plataforma, el usuario, la modalidad de señal, los costos ni la diferencia entre flujo de usuario y flujo técnico. | La propuesta debía poder explicarse como experiencia y sistema, no solo como idea o programación. |
| Después del feedback | Se definieron aplicación, testigo, lugar, señal, primer paso, usuario principal y usuario límite. También se separaron los flujos y se explicitaron las exclusiones. | Evitar que el proyecto prometiera bloqueo, productividad, reducción de pantalla o eficacia que todavía no estaban demostrados. |
| Memoria v4 | La memoria recuperó una secuencia clara: problema, antecedentes, teoría, usuarios, referentes, criterios, formulación, propuesta, factibilidad y validación. | La solución debía aparecer después de construir el problema y sus fundamentos, no dirigir la lectura desde el inicio. |
| Estado actual | Existen wireframes, un sistema visual, una comparación técnica B1/B2 y un protocolo de prueba. La implementación y la validación siguen pendientes. | Convertir las decisiones principales en pruebas antes de cerrar la forma, el canal y el costo del producto. |

La [matriz histórica de encargos y memoria](../01_contexto_y_fuentes/matriz-historica-encargos-memoria.md) conserva el recorrido completo del primer semestre y explica qué aprendizajes se mantuvieron y cuáles pertenecían solo a los formatos docentes.

## 3. Cómo se aplicó el feedback de la comisión

El feedback no se copió literalmente en la memoria. Se convirtió en preguntas, criterios de diseño, decisiones, documentos y pruebas pendientes.

| Tema señalado por la comisión | Integración en la memoria y el repositorio | Lo que aún falta |
|---|---|---|
| “¿Qué es exactamente Relevo?” | Se definió el sistema completo: aplicación Android, testigo físico, lugar, condición y pulso. | Cerrar la forma final del testigo. |
| Contexto y usuario poco precisos | Se construyeron ocho casos a partir de entrevistas, dos tipos situacionales —usuario principal y usuario límite— y un contexto doméstico tratado como hipótesis. | Observar y probar el uso en espacios reales. |
| Separar experiencia y programación | Se documentaron por separado el recorrido de la persona, el flujo del sistema y el proceso de diseño. | Probar permisos, segundo plano, vínculo, batería, vencimiento y recuperación. |
| Justificar la señal | Luz, sonido, vibración y lugar se definieron como alternativas a comparar, no como solución cerrada. | Comparar perceptibilidad, molestia, discreción, accesibilidad y convivencia. |
| Mostrar valor y diferencia frente a una notificación | Se formuló la hipótesis de que el lugar y la presencia física podrían aportar significado, y se incorporó una notificación digital como comparación. | Comprobar si lo físico aporta algo suficiente o solo agrega carga. |
| Evitar una solución punitiva | Se excluyeron bloqueos, rankings, rachas, premios y evaluación de cumplimiento. Ignorar o silenciar son respuestas válidas. | Verificar que las personas entiendan y puedan ejercer esas salidas. |
| Definir plataforma y factibilidad | Android quedó como única plataforma del primer prototipo, con una justificación comparativa frente a web e iPhone. | Construir y probar la integración Android/BLE. |
| Incluir producción, costos y rol del diseñador | Se separaron materiales, electrónica, fabricación, reparación, costos y responsabilidades del diseño. | Completar proveedores, cotizaciones, tiempos, cuerpo, difusor y horas de trabajo. |
| Mejorar memoria, redacción y cronología | La v4 reorganizó la narración, auditó citas y referencias APA 7, eliminó metalenguaje y recuperó la evolución marzo–julio. | Reauditar después de incorporar resultados y preparar la presentación oral como pieza independiente. |

El detalle de cada observación está en la [matriz de incorporación del feedback E15](../08_memoria/matriz-incorporacion-feedback-e15.md) y en el [feedback original de la comisión](../01_contexto_y_fuentes/feedback-e15.md).

## 4. Qué investigación se realizó

### Usuarios

- Se realizaron ocho entrevistas semiestructuradas, habladas y presenciales en Santiago los días 11 y 12 de junio de 2026.
- Las personas tenían entre 19 y 27 años; el criterio de convocatoria fue de 18 a 30 años.
- El corpus anonimizado P1–P8 se codificó y se transformó en patrones, tipos situacionales, perfiles, recorridos y una matriz de requisitos.
- La investigación mostró que el mismo uso digital puede ser significativo en un momento e inoportuno en otro. Por eso la unidad de análisis pasó a ser el episodio concreto y no el número de minutos de pantalla.
- No se han realizado nuevas entrevistas después del examen. Lo nuevo de esta etapa es la profundización y trazabilidad del análisis existente, no una nueva muestra.

Ver [corpus y análisis de usuarios](../03_usuarios/README.md), [perfiles situacionales](../03_usuarios/perfiles-situacionales.md) y [matriz de requisitos](../03_usuarios/matriz-requisitos-de-usuarios.md).

### Investigación teórica

La memoria v4 organiza tres ámbitos que se cruzan para explicar el problema:

1. **Experiencia subjetiva del ocio digital:** el valor de una actividad depende del propósito, el contexto y la autonomía, no solo de su duración.
2. **Arquitecturas de atención y bienestar digital:** las pausas y fricciones pueden abrir una reconsideración, pero los bloqueos no son una respuesta universal.
3. **Memoria prospectiva, espacio e interacción tangible:** una intención puede externalizarse en un objeto o lugar, siempre que la relación sea comprensible y el esfuerzo de configuración sea proporcional.

Entre las referencias principales están Lukoff, Meier y Reinecke, Radtke, Lyngs, Biedermann, Monge Roffarello y De Russis, Grüning, Haliburton, Gilbert, Chiu y Kirsh. Estas fuentes ayudaron a delimitar el problema y los criterios; no se usan como prueba de que Relevo funcionará.

### Mercado y referentes

La investigación de mercado, cerrada el 24 de agosto, ordenó los antecedentes en seis familias: medición y límites; pausas dentro del teléfono; llaves y bloqueadores físicos; separación física; objetos de foco y hábitos; y recordatorios tangibles o situados.

Los referentes más útiles fueron:

- **one sec:** demuestra el valor posible de una pausa voluntaria, pero permanece dentro de la pantalla.
- **Brick Zone, Unpluq y similares:** muestran la relación entre objeto, Bluetooth y espacio, aunque principalmente bloquean o restringen.
- **Focusaur y FocuShift:** exploran objetos conectados, sesiones y rituales, pero mezclan productividad, recompensas o barreras.
- **The Tangible Reminder, Wobble, Raya y Remind Holder:** muestran cómo un objeto y su ubicación pueden externalizar un recordatorio, aunque no abordan exactamente la transición desde ocio digital hacia una alternativa personal.

La conclusión no es que Relevo sea universalmente inédito. La oportunidad defendible es investigar la combinación intención propia + primer paso + lugar significativo + pulso ambiental + elección abierta. Ver el [estudio de mercado y antecedentes](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md).

### Referentes de diseño

Norman orienta la comprensión de acciones, estados, retroalimentación y errores; Albers orienta la evaluación del color en relación con el fondo y el soporte; Munari vincula signo, forma, material, función y uso; e Isaacson sirve como referencia para pensar la integración entre producto y experiencia. Son criterios para diseñar y revisar, no sustitutos de la investigación con personas.

## 5. Decisiones principales y sus razones

| Decisión | Por qué |
|---|---|
| Sistema phygital | La aplicación conserva y configura el significado; el testigo lo vuelve perceptible en el lugar donde puede comenzar la actividad. La separación permite comprobar si la capa física agrega valor. |
| Un ciclo con una intención, un primer paso y un pulso | Reduce complejidad, hace observable la asociación y evita que el sistema parezca un gestor general de productividad. |
| Usuario situacional, no una “persona” fija | La misma persona puede querer una pausa en un episodio y no querer intervenir en otro. Esto evita juzgar el ocio digital por adelantado. |
| Android como primera plataforma | Permite concentrar el prototipo en una sola arquitectura con actividad autorizada, notificación local y posible comunicación BLE. Web e iPhone quedan fuera de esta etapa para no duplicar el desarrollo. |
| Condición de activación abierta | Continuidad, acumulación dentro de una ventana y horario tienen implicancias distintas de privacidad, significado y factibilidad; deben probarse antes de elegir. |
| Sin bloqueo, gamificación ni historial de cumplimiento | La propuesta busca devolver una decisión, no imponerla ni transformar una intención en rendimiento medible. |
| Comparar objeto situado, objeto en lugar neutro y notificación | Permite aislar qué aporta el objeto y qué aporta específicamente su ubicación. |

El rol del diseño quedó definido como articular problema, evidencia, experiencia, lenguaje, objeto y sistema. La electrónica, la fabricación, los costos y el mantenimiento se tratan como restricciones y colaboraciones que deben documentarse; diseñar la experiencia no equivale a afirmar que toda la producción ya está resuelta.

## 6. Naming y lenguaje

**Relevo** es el nombre del sistema completo porque sugiere un cambio de turno sin afirmar que la persona abandonará el teléfono ni que necesariamente realizará otra actividad.

La arquitectura verbal quedó así:

- **aplicación Relevo:** configura y conserva la intención;
- **testigo Relevo:** objeto que mantiene presente esa intención sin atribuirle inteligencia;
- **ciclo:** unidad temporal desde el armado hasta el cierre;
- **pulso ambiental:** manifestación física breve;
- **señal situada:** relación entre pulso, primer paso y lugar.

Se eligió **testigo** en lugar de “dispositivo”, “token”, “asistente” u “objeto inteligente” porque describe una función sin cerrar la forma industrial ni sugerir vigilancia, autonomía o evaluación.

El descriptor actual es: **“Sistema phygital para recuperar intenciones personales durante el ocio digital.”** La decisión de naming es académica y de prototipo; todavía no es una comprobación de marca, dominio o disponibilidad comercial. Ver [decisiones de naming](../05_propuesta_phygital/entregables-clave-2026-09-01/naming.md).

## 7. Decisiones cromáticas y visuales

- La dirección conceptual seleccionada es **Transferencia situada**, porque permite representar el paso de la intención desde la aplicación hacia el lugar y luego hacia el pulso, sin fingir que el objeto final ya está resuelto.
- Android utiliza un modo oscuro para favorecer continuidad, concentración y lectura prolongada.
- La memoria y las piezas editoriales utilizan un fondo claro y cálido porque necesitan lectura extensa, impresión y convivencia con citas, tablas e imágenes.
- El rojo `#D71921` se reserva para la señal situada. No se usa para botones, errores, éxito, navegación ni decoración; así la aparición del color comunica un acontecimiento específico.
- La interfaz no depende únicamente del color: el contraste, el texto y la estructura deben explicar los estados. El rojo no se usa como texto pequeño sobre el fondo oscuro por su contraste insuficiente.
- La forma, tipografía final, material, difusor y parámetros definitivos del pulso permanecen abiertos hasta las pruebas de legibilidad, accesibilidad y convivencia.

Ver [códigos cromáticos](../05_propuesta_phygital/entregables-clave-2026-09-01/codigos-cromaticos.md) y [síntesis aplicada del sistema visual](../01_contexto_y_fuentes/biblioteca_diseno/sintesis-aplicada-sistema-visual-relevo.md).

## 8. Cómo se ha implementado hasta ahora

La implementación actual es principalmente estructural y preparatoria:

1. **Formular:** registrar intención, primer paso y condición provisional.
2. **Situar:** vincular el testigo con el lugar donde comienza la actividad.
3. **Probar y armar:** comprobar el pulso y activar el ciclo de manera explícita.
4. **Esperar y señalar:** emitir un pulso breve cuando corresponde.
5. **Decidir y cerrar:** continuar, ignorar, silenciar, iniciar, desarmar o dejar vencer el ciclo.

El [Encargo 17](../05_propuesta_phygital/entrega-encargo-17.md) convirtió el flujo en tres interacciones y nueve marcos principales. El anexo amplía la cobertura a 35 estados, incluidos permisos, errores, salidas voluntarias y recuperación. Estos wireframes muestran la arquitectura de la experiencia; no demuestran comprensión ni funcionamiento real.

La [dirección visual y sus aplicaciones](../10_recursos_visuales/08_direccion_visual_relevo/README.md) reúne las exploraciones para Android, memoria y objeto. La [versión HTML de los wireframes](../05_propuesta_phygital/wireframes-media-html/README.md) facilita revisar el recorrido, pero tampoco reemplaza las pruebas con personas.

En lo técnico, la fase A mantiene una activación manual cableada. Antes de comprar se comparan dos variantes de 5 V para la señal: B1, con XIAO ESP32-C3 y anillo direccionable; B2, con XIAO ESP32-C3 y luz cálida no direccionable. Aún no se ha comprado, energizado ni construido el montaje, y la fase B permanece bloqueada hasta contar con una notificación local Android comparable.

Ver [decisión de plataforma Android](../06_desarrollo_y_factibilidad/decision-plataforma-android.md), [alternativas físicas B1/B2](../06_desarrollo_y_factibilidad/alternativas-arquitectura-fisica-2026-08-30.md) y [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md).

## 9. Qué está resuelto y qué falta

### Resuelto o suficientemente definido

- problema y límites del proyecto;
- usuario principal y usuario límite;
- corpus y análisis de las ocho entrevistas;
- marco teórico y criterios de diseño;
- mercado y referentes con corte temporal;
- definición de aplicación, testigo, lugar y señal;
- arquitectura de flujos y wireframes;
- plataforma Android inicial;
- naming, dirección visual y paleta base;
- protocolo, consentimiento, ficha y criterios previos de decisión;
- memoria v4 con estructura, trazabilidad y control APA 7.

### Pendiente crítico

- construir una señal segura, repetible y perceptible;
- ejecutar la prueba de asociación con participantes;
- comparar modalidad, lugar y notificación;
- probar accesibilidad, convivencia y posibilidad de no intervenir;
- implementar Android, permisos, segundo plano y BLE;
- decidir forma, material, protección, reparación, proveedores y costo real;
- incorporar resultados a la memoria y preparar la defensa oral.

## 10. Próximos pasos y fechas aproximadas

| Fecha | Paso | Resultado esperado |
|---|---|---|
| 2–6 septiembre 2026 | Inventario y revisión de B1/B2; construir solo el material mínimo; ensayo interno del protocolo. | Señal manual segura y procedimiento habilitado. |
| 7–20 septiembre | Ejecutar la prueba de asociación y observar el papel del lugar. | Decidir si se avanza, itera o reformula la relación intención–lugar–señal. |
| 21 septiembre–4 octubre | Comparar luz, sonido, vibración o combinación acotada; revisar accesibilidad y convivencia. | Modalidad provisional justificable y silenciable. |
| 5–18 octubre | Implementar el ciclo Android, la notificación local y la integración técnica mínima. | Recorrido funcional con recuperación ante fallos críticos. |
| 19–31 octubre | Cerrar forma, montaje, sistema visual aplicado, costos y registro del prototipo. | Producto prácticamente terminado y presentable. |
| 1–15 noviembre | Validación final acotada, análisis, ajustes y auditoría integral. | Producto, evidencia, memoria y anexos cerrados internamente. |
| 25 noviembre | Pase de Examen. | Clasificar observaciones sin abrir una reformulación general. |
| 2 diciembre | Entrega oficial de la memoria. | Memoria definitiva exportada y respaldada. |
| 14–18 diciembre | Examen de Proyecto de Título. | Presentación, defensa y demostración del prototipo. |

El detalle operativo está en el [plan de cierre agosto–diciembre de 2026](plan-de-cierre-agosto-diciembre-2026.md) y en la [hoja de ruta](hoja-de-ruta.md).

## Cierre

Desde el examen del primer semestre, Relevo pasó de ser una propuesta difícil de leer a un proyecto con problema acotado, usuarios situacionales, investigación trazable, referentes comparados, flujos separados, una arquitectura phygital explícita y una ruta de validación.

El proyecto ya puede responder qué es, para quién se plantea y por qué podría ser relevante. La pregunta decisiva que queda es si el testigo físico situado recupera una intención de manera más clara o pertinente que una notificación digital, sin aumentar demasiado la carga, la intrusión o los problemas de accesibilidad. Esa respuesta debe venir de las pruebas, no de la memoria ni de los wireframes.

## Documentos principales

- [Memoria vigente v4](../08_memoria/memoria-vigente-v4.md).
- [Resumen vigente del proyecto](../08_memoria/resumen-vigente-proyecto.md).
- [Matriz de incorporación del feedback E15](../08_memoria/matriz-incorporacion-feedback-e15.md).
- [Matriz histórica del Pase y la memoria](../01_contexto_y_fuentes/matriz-historica-encargos-memoria.md).
- [Análisis de usuarios](../03_usuarios/README.md).
- [Estudio de mercado y referentes](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md).
- [Propuesta phygital](../05_propuesta_phygital/README.md).
- [Factibilidad y desarrollo](../06_desarrollo_y_factibilidad/README.md).
- [Validación](../07_validacion/README.md).

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Creación del resumen general

- **Cambio:** se creó una síntesis ejecutiva que reúne la evolución desde el examen del primer semestre hasta la memoria v4, la aplicación del feedback, la investigación, los referentes, las decisiones de producto, naming, color, implementación y los próximos hitos.
- **Motivo:** ofrecer una lectura simple y ordenada del proyecto sin obligar a reconstruir el estado desde múltiples carpetas.
- **Alcance:** este documento no agrega evidencia, no reemplaza la memoria y no presenta como resultados las pruebas aún no ejecutadas.
