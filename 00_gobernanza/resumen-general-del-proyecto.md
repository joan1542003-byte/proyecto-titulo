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

| Momento | Qué cambió | Por qué se tomó la decisión | Enlace |
|---|---|---|---|
| Exploraciones iniciales, incluida In(Visible) | El proyecto pasó de un tema amplio sobre ocio digital y desconexión a una situación concreta: una intención alternativa deja de orientar el siguiente paso. | Un problema situado permite investigar una experiencia específica y no generalizar que usar el teléfono siempre es un problema. | [Matriz histórica](../01_contexto_y_fuentes/matriz-historica-encargos-memoria.md) |
| Examen/Pase del primer semestre | La comisión señaló que no se entendían con precisión el objeto, el contexto, la plataforma, el usuario, la modalidad de señal, los costos ni la diferencia entre flujo de usuario y flujo técnico. | La propuesta debía poder explicarse como experiencia y sistema, no solo como idea o programación. | [Feedback E15](../01_contexto_y_fuentes/feedback-e15.md) |
| Después del feedback | Se definieron aplicación, testigo, lugar, señal, primer paso, usuario principal y usuario límite. También se separaron los flujos y se explicitaron las exclusiones. | Evitar que el proyecto prometiera bloqueo, productividad, reducción de pantalla o eficacia que todavía no estaban demostrados. | [Matriz de incorporación](../08_memoria/matriz-incorporacion-feedback-e15.md) |
| Memoria v4 | La memoria recuperó una secuencia clara: problema, antecedentes, teoría, usuarios, referentes, criterios, formulación, propuesta, factibilidad y validación. | La solución debía aparecer después de construir el problema y sus fundamentos, no dirigir la lectura desde el inicio. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) |
| Estado actual | Existen wireframes, un sistema visual, una comparación técnica B1/B2 y un protocolo de prueba. La implementación y la validación siguen pendientes. | Convertir las decisiones principales en pruebas antes de cerrar la forma, el canal y el costo del producto. | [README del proyecto](../README.md) · [Hoja de ruta](hoja-de-ruta.md) |

La [matriz histórica de encargos y memoria](../01_contexto_y_fuentes/matriz-historica-encargos-memoria.md) conserva el recorrido completo del primer semestre y explica qué aprendizajes se mantuvieron y cuáles pertenecían solo a los formatos docentes.

## 3. Cómo se aplicó el feedback de la comisión

El feedback no se copió literalmente en la memoria. Se convirtió en preguntas, criterios de diseño, decisiones, documentos y pruebas pendientes.

| Tema señalado por la comisión | Integración en la memoria y el repositorio | Lo que aún falta | Enlace |
|---|---|---|---|
| “¿Qué es exactamente Relevo?” | Se definió el sistema completo: aplicación Android, testigo físico, lugar, condición y pulso. | Cerrar la forma final del testigo. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) · [Propuesta phygital](../05_propuesta_phygital/README.md) |
| Contexto y usuario poco precisos | Se construyeron ocho casos a partir de entrevistas, dos tipos situacionales —usuario principal y usuario límite— y un contexto doméstico tratado como hipótesis. | Observar y probar el uso en espacios reales. | [Perfiles](../03_usuarios/perfiles-situacionales.md) · [Recorridos](../03_usuarios/recorridos-situacionales.md) |
| Separar experiencia y programación | Se documentaron por separado el recorrido de la persona, el flujo del sistema y el proceso de diseño. | Probar permisos, segundo plano, vínculo, batería, vencimiento y recuperación. | [Cobertura de interacciones](../05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md) · [Factibilidad](../06_desarrollo_y_factibilidad/README.md) |
| Justificar la señal | Luz, sonido, vibración y lugar se definieron como alternativas a comparar, no como solución cerrada. | Comparar perceptibilidad, molestia, discreción, accesibilidad y convivencia. | [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| Mostrar valor y diferencia frente a una notificación | Se formuló la hipótesis de que el lugar y la presencia física podrían aportar significado, y se incorporó una notificación digital como comparación. | Comprobar si lo físico aporta algo suficiente o solo agrega carga. | [Estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) · [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| Evitar una solución punitiva | Se excluyeron bloqueos, rankings, rachas, premios y evaluación de cumplimiento. Ignorar o silenciar son respuestas válidas. | Verificar que las personas entiendan y puedan ejercer esas salidas. | [Requisitos de usuarios](../03_usuarios/matriz-requisitos-de-usuarios.md) |
| Definir plataforma y factibilidad | Android quedó como única plataforma del primer prototipo, con una justificación comparativa frente a web e iPhone. | Construir y probar la integración Android/BLE. | [Decisión Android](../06_desarrollo_y_factibilidad/decision-plataforma-android.md) |
| Incluir producción, costos y rol del diseñador | Se separaron materiales, electrónica, fabricación, reparación, costos y responsabilidades del diseño. | Completar proveedores, cotizaciones, tiempos, cuerpo, difusor y horas de trabajo. | [Factibilidad](../06_desarrollo_y_factibilidad/README.md) · [Plan de cierre](plan-de-cierre-agosto-diciembre-2026.md) |
| Mejorar memoria, redacción y cronología | La v4 reorganizó la narración, auditó citas y referencias APA 7, eliminó metalenguaje y recuperó la evolución marzo–julio. | Reauditar después de incorporar resultados y preparar la presentación oral como pieza independiente. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) · [Revisión final](../08_memoria/revision-final-textual-2026-08-31.md) |

El detalle de cada observación está en la [matriz de incorporación del feedback E15](../08_memoria/matriz-incorporacion-feedback-e15.md) y en el [feedback original de la comisión](../01_contexto_y_fuentes/feedback-e15.md).

## 4. Qué investigación se realizó

### Usuarios

- Se realizaron [ocho entrevistas semiestructuradas](../01_contexto_y_fuentes/declaracion-procedencia-entrevistas.md), habladas y presenciales en Santiago los días 11 y 12 de junio de 2026.
- Las personas tenían entre 19 y 27 años; el criterio de convocatoria fue de 18 a 30 años, según el [registro metodológico del corpus](../03_usuarios/metodo-de-analisis.md).
- El [corpus anonimizado P1–P8](../03_usuarios/corpus-anonimizado.md) se codificó y se transformó en patrones, tipos situacionales, perfiles, recorridos y una matriz de requisitos.
- La investigación mostró que el mismo uso digital puede ser significativo en un momento e inoportuno en otro. Por eso la unidad de análisis pasó a ser el episodio concreto y no el número de minutos de pantalla; la [matriz de evidencia](../03_usuarios/matriz-evidencia-p1-p8.md) conserva esa relación.
- No se han realizado nuevas entrevistas después del examen. Lo nuevo de esta etapa es la profundización y trazabilidad del análisis existente, no una nueva muestra; el [inventario de fuentes](../01_contexto_y_fuentes/inventario-de-fuentes.md) mantiene la procedencia.

Ver [corpus y análisis de usuarios](../03_usuarios/README.md), [perfiles situacionales](../03_usuarios/perfiles-situacionales.md) y [matriz de requisitos](../03_usuarios/matriz-requisitos-de-usuarios.md).

### Investigación teórica

La [memoria v4](../08_memoria/memoria-vigente-v4.md) organiza tres ámbitos que se cruzan para explicar el problema:

1. **Experiencia subjetiva del ocio digital:** el valor de una actividad depende del propósito, el contexto y la autonomía, no solo de su duración.
2. **Arquitecturas de atención y bienestar digital:** las pausas y fricciones pueden abrir una reconsideración, pero los bloqueos no son una respuesta universal.
3. **Memoria prospectiva, espacio e interacción tangible:** una intención puede externalizarse en un objeto o lugar, siempre que la relación sea comprensible y el esfuerzo de configuración sea proporcional.

Entre las referencias principales están Lukoff, Meier y Reinecke, Radtke, Lyngs, Biedermann, Monge Roffarello y De Russis, Grüning, Haliburton, Gilbert, Chiu y Kirsh. Estas fuentes ayudaron a delimitar el problema y los criterios; no se usan como prueba de que Relevo funcionará. La [metodología de investigación](../02_investigacion/README.md) y la bibliografía de la [memoria v4](../08_memoria/memoria-vigente-v4.md) permiten revisar las fuentes completas.

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

| Decisión | Por qué | Evidencia o detalle |
|---|---|---|
| Sistema phygital | La aplicación conserva y configura el significado; el testigo lo vuelve perceptible en el lugar donde puede comenzar la actividad. La separación permite comprobar si la capa física agrega valor. | [Propuesta phygital](../05_propuesta_phygital/README.md) |
| Un ciclo con una intención, un primer paso y un pulso | Reduce complejidad, hace observable la asociación y evita que el sistema parezca un gestor general de productividad. | [Secuencia de uso en la memoria v4](../08_memoria/memoria-vigente-v4.md) |
| Usuario situacional, no una “persona” fija | La misma persona puede querer una pausa en un episodio y no querer intervenir en otro. Esto evita juzgar el ocio digital por adelantado. | [Perfiles situacionales](../03_usuarios/perfiles-situacionales.md) |
| Android como primera plataforma | Permite concentrar el prototipo en una sola arquitectura con actividad autorizada, notificación local y posible comunicación BLE. Web e iPhone quedan fuera de esta etapa para no duplicar el desarrollo. | [Decisión de plataforma](../06_desarrollo_y_factibilidad/decision-plataforma-android.md) |
| Condición de activación abierta | Continuidad, acumulación dentro de una ventana y horario tienen implicancias distintas de privacidad, significado y factibilidad; deben probarse antes de elegir. | [Criterios de diseño](../08_memoria/memoria-vigente-v4.md) · [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |
| Sin bloqueo, gamificación ni historial de cumplimiento | La propuesta busca devolver una decisión, no imponerla ni transformar una intención en rendimiento medible. | [Matriz de requisitos](../03_usuarios/matriz-requisitos-de-usuarios.md) |
| Comparar objeto situado, objeto en lugar neutro y notificación | Permite aislar qué aporta el objeto y qué aporta específicamente su ubicación. | [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |

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

## 9. Costos estimados y estado de factibilidad

Los montos corresponden a precios observados y desembolsos estimados al 30 de agosto de 2026. No son el precio de venta ni el costo final de producción. Todavía faltan cuerpo, difusor, conductores internos, protección definitiva, revisión electrónica, envío, horas de trabajo y posibles compras adicionales.

| Alternativa | Monto documentado | Qué significa | Enlace |
|---|---:|---|---|
| Montaje provisional de 12 V | **CLP 28.130** | Costo parcial de referencia. Excluye terminales y protección de potencia; se mantiene como respaldo si las fuentes de 5 V no alcanzan la visibilidad necesaria. | [Alternativas físicas](../06_desarrollo_y_factibilidad/alternativas-arquitectura-fisica-2026-08-30.md) |
| B1: XIAO ESP32-C3 + anillo direccionable de 5 V | **CLP 22.383 + conversor lógico** sin base; **CLP 28.073 + conversor lógico** con base comparable | Incluye las partidas con precio identificado. El conversor lógico, conductores internos, cuerpo, difusor, envío y revisión siguen abiertos. | [Lista B1](../06_desarrollo_y_factibilidad/lista-materiales-y-compra-escalonada-5v-2026-08-30.md) |
| B2: XIAO ESP32-C3 + luz cálida no direccionable de 5 V | **CLP 23.591 + resistencia de estado y conductores** sin base; **CLP 29.281 + esas partidas** con base comparable | Incluye paquetes de LED, módulo de control y protección candidata. La ventaja de B2 sería funcional —menos funciones de color—, no necesariamente económica. | [Lista B2](../06_desarrollo_y_factibilidad/lista-materiales-y-compra-escalonada-5v-2026-08-30.md) |
| Núcleo común B1/B2 | **CLP 17.126** si todo debe comprarse; **CLP 10.440** reutilizando fuente, jack y cable USB-C | Corresponde a XIAO, pulsador, cable de activación, interruptor, borneras, fuente, jack y cable de programación. Debe confirmarse qué existe realmente en el taller. | [Costos comunes](../06_desarrollo_y_factibilidad/lista-materiales-y-compra-escalonada-5v-2026-08-30.md) |

La comparación no permite declarar todavía un ahorro. Las listas no son completamente equivalentes y los componentes no han sido comprados. La decisión correcta es revisar B1 y B2, medir la señal y completar solo la variante que resulte segura, estable, perceptible y coherente con la prueba. Ver la [ruta de compra por puertas](../06_desarrollo_y_factibilidad/lista-materiales-y-compra-escalonada-5v-2026-08-30.md).

## 10. Lo que ya se hizo y cambios aplicados

| Área | Ya realizado | Cambio aplicado y por qué | Enlace |
|---|---|---|---|
| Problema y alcance | Se delimitó una situación concreta de ocio digital y una intención alternativa. | Se dejó de tratar el tiempo de pantalla como problema universal para poder investigar episodios situados. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) |
| Usuarios | Se analizaron las ocho entrevistas P1–P8 y se construyeron perfiles, recorridos y requisitos. | Se pasó de una persona genérica a un usuario principal y un usuario límite, porque no todas las situaciones requieren intervención. | [Usuarios](../03_usuarios/README.md) |
| Feedback del Pase | Se respondieron las observaciones sobre objeto, contexto, plataforma, costos, señal y flujos. | El feedback se tradujo en decisiones y pruebas pendientes, sin presentarlo como evidencia empírica. | [Matriz E15](../08_memoria/matriz-incorporacion-feedback-e15.md) |
| Teoría y referentes | Se consolidaron tres ámbitos y se conectaron con antecedentes de bienestar digital, memoria prospectiva, espacio y tangibilidad. | Se ordenó la teoría antes de la solución para explicar por qué Relevo podría ser pertinente. | [Marco teórico v4](../08_memoria/memoria-vigente-v4.md) |
| Mercado | Se realizó una exploración con corte al 24 de agosto y seis familias de referentes. | Se abandonó la afirmación de novedad absoluta y se definió una diferencia investigable frente a bloqueadores y notificaciones. | [Estudio de mercado](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md) |
| Experiencia y flujos | Se desarrollaron tres interacciones, nueve marcos principales y 35 estados complementarios. | Se separaron recorrido de usuario, flujo del sistema y flujo de diseño para hacer visibles errores y salidas voluntarias. | [Encargo 17](../05_propuesta_phygital/entrega-encargo-17.md) · [Anexo](../05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md) |
| Lenguaje e identidad | Se definieron Relevo, aplicación, testigo, ciclo, pulso ambiental y señal situada. | Se escogieron palabras funcionales que no atribuyen inteligencia, vigilancia ni obligación al objeto. | [Naming](../05_propuesta_phygital/entregables-clave-2026-09-01/naming.md) |
| Sistema visual | Se seleccionó Transferencia situada, con modo oscuro para Android, soporte editorial claro y rojo reservado para la señal. | El color dejó de ser decorativo y pasó a comunicar estados y acontecimientos con criterios de contraste. | [Dirección visual](../10_recursos_visuales/08_direccion_visual_relevo/README.md) · [Códigos cromáticos](../05_propuesta_phygital/entregables-clave-2026-09-01/codigos-cromaticos.md) |
| Técnica y validación | Se justificó Android, se comparan B1/B2 y se preparó el Protocolo 01. | Se decidió no comprar ni construir el conjunto completo antes de revisar seguridad, señal y factibilidad. | [Android](../06_desarrollo_y_factibilidad/decision-plataforma-android.md) · [Protocolo](../07_validacion/protocolo-01-asociacion-y-comparacion.md) |

## 11. Qué está resuelto y qué falta

### Resuelto o suficientemente definido

- [problema y límites del proyecto](../08_memoria/memoria-vigente-v4.md);
- [usuario principal y usuario límite](../03_usuarios/perfiles-situacionales.md);
- [corpus y análisis de las ocho entrevistas](../03_usuarios/matriz-evidencia-p1-p8.md);
- [marco teórico y criterios de diseño](../08_memoria/memoria-vigente-v4.md);
- [mercado y referentes con corte temporal](../04_mercado_y_referentes/estudio-mercado-relevo-2026-08-24.md);
- [definición de aplicación, testigo, lugar y señal](../05_propuesta_phygital/README.md);
- [arquitectura de flujos y wireframes](../05_propuesta_phygital/entrega-encargo-17.md);
- [plataforma Android inicial](../06_desarrollo_y_factibilidad/decision-plataforma-android.md);
- [naming, dirección visual y paleta base](../05_propuesta_phygital/entregables-clave-2026-09-01/naming.md);
- [protocolo, consentimiento, ficha y criterios previos de decisión](../07_validacion/README.md);
- [memoria v4 con estructura, trazabilidad y control APA 7](../08_memoria/memoria-vigente-v4.md).

### Pendiente crítico

- [construir una señal segura, repetible y perceptible](../07_validacion/especificacion-materiales-fase-a.md);
- [ejecutar la prueba de asociación con participantes](../07_validacion/protocolo-01-asociacion-y-comparacion.md);
- [comparar modalidad, lugar y notificación](../07_validacion/protocolo-01-asociacion-y-comparacion.md);
- [probar accesibilidad, convivencia y posibilidad de no intervenir](../03_usuarios/matriz-requisitos-de-usuarios.md);
- [implementar Android, permisos, segundo plano y BLE](../06_desarrollo_y_factibilidad/decision-plataforma-android.md);
- [decidir forma, material, protección, reparación, proveedores y costo real](../06_desarrollo_y_factibilidad/README.md);
- [incorporar resultados a la memoria y preparar la defensa oral](plan-de-cierre-agosto-diciembre-2026.md).

## 12. Próximos pasos y fechas estimadas

| Fecha estimada | Paso siguiente | Resultado esperado | Enlace |
|---|---|---|---|
| 2–6 septiembre 2026 | Inventario y revisión de B1/B2; construir solo el material mínimo; ensayo interno del protocolo. | Señal manual segura y procedimiento habilitado. | [Alternativas físicas](../06_desarrollo_y_factibilidad/alternativas-arquitectura-fisica-2026-08-30.md) · [Plan de cierre](plan-de-cierre-agosto-diciembre-2026.md) |
| 7–20 septiembre 2026 | Ejecutar la prueba de asociación y observar el papel del lugar. | Decidir si se avanza, itera o reformula la relación intención–lugar–señal. | [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md) · [Issue #8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8) |
| 21 septiembre–4 octubre 2026 | Comparar luz, sonido, vibración o combinación acotada; revisar accesibilidad y convivencia. | Modalidad provisional justificable y silenciable. | [Hoja de ruta](hoja-de-ruta.md) · [Requisitos de usuarios](../03_usuarios/matriz-requisitos-de-usuarios.md) |
| 5–18 octubre 2026 | Implementar el ciclo Android, la notificación local y la integración técnica mínima. | Recorrido funcional con recuperación ante fallos críticos. | [Decisión Android](../06_desarrollo_y_factibilidad/decision-plataforma-android.md) · [Plan de cierre](plan-de-cierre-agosto-diciembre-2026.md) |
| 19–31 octubre 2026 | Cerrar forma, montaje, sistema visual aplicado, costos y registro del prototipo. | Producto prácticamente terminado y presentable. | [Factibilidad](../06_desarrollo_y_factibilidad/README.md) · [Dirección visual](../10_recursos_visuales/08_direccion_visual_relevo/README.md) |
| 1–15 noviembre 2026 | Validación final acotada, análisis, ajustes y auditoría integral. | Producto, evidencia, memoria y anexos cerrados internamente. | [Memoria v4](../08_memoria/memoria-vigente-v4.md) · [Plan de cierre](plan-de-cierre-agosto-diciembre-2026.md) |
| 25 noviembre 2026 | Pase de Examen. | Clasificar observaciones sin abrir una reformulación general. | [Plan de cierre](plan-de-cierre-agosto-diciembre-2026.md) |
| 2 diciembre 2026 | Entrega oficial de la memoria. | Memoria definitiva exportada y respaldada. | [Calendario oficial](calendario-oficial-segundo-semestre-2026.md) · [Memoria v4](../08_memoria/memoria-vigente-v4.md) |
| 14–18 diciembre 2026 | Examen de Proyecto de Título. | Presentación, defensa y demostración del prototipo. | [Calendario oficial](calendario-oficial-segundo-semestre-2026.md) |

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

### 2026-09-02 — Costos, enlaces y calendario ampliados

- **Cambio:** se añadieron enlaces de evidencia a las tablas principales, costos estimados de 12 V, B1 y B2, un registro de avances y cambios aplicados, y una tabla de próximos pasos con fechas estimadas.
- **Motivo:** permitir que cada afirmación importante pueda verificarse directamente en el repositorio y que el estado económico y temporal del proyecto se entienda sin reconstruirlo desde varias carpetas.
- **Alcance:** los costos siguen siendo parciales y estimados; no se compraron componentes, no se agregaron resultados de validación y las fechas corresponden al plan vigente.

### 2026-09-02 — Creación del resumen general

- **Cambio:** se creó una síntesis ejecutiva que reúne la evolución desde el examen del primer semestre hasta la memoria v4, la aplicación del feedback, la investigación, los referentes, las decisiones de producto, naming, color, implementación y los próximos hitos.
- **Motivo:** ofrecer una lectura simple y ordenada del proyecto sin obligar a reconstruir el estado desde múltiples carpetas.
- **Alcance:** este documento no agrega evidencia, no reemplaza la memoria y no presenta como resultados las pruebas aún no ejecutadas.
