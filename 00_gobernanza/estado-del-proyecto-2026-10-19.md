# Estado de Relevo al 19 de octubre de 2026

**Qué es:** una revisión del proyecto completo: app, objeto, datos, prueba, memoria, presentación y repositorio. Dice qué está, qué falta sí o sí antes del Pase de Examen, qué conviene mejorar y qué no existe todavía.

**Qué se revisó:**

- **GitHub:** las ramas, los PR y los Issues abiertos.
- **Documentos recientes:** la memoria v5 del 13 de octubre, la presentación del 14 de octubre y los documentos de las versiones 2.31 y 2.32.
- **Base remota:** los registros de la prueba en Supabase, revisados solo como recuentos.
- **Criterios institucionales:** el resumen de [criterios oficiales](../01_contexto_y_fuentes/criterios-oficiales-memoria-proyecto-titulo.md), la [matriz de pase](../01_contexto_y_fuentes/matriz-de-pase-proyecto-titulo.md) y el [calendario oficial](calendario-oficial-segundo-semestre-2026.md).

**Límite:** la estimación por rúbrica es propia y orientativa; no es una calificación de la Escuela.

## En pocas palabras

Relevo tiene una base de investigación sólida, una app que funciona en un hogar real y documentación muy completa. Lo que falta está casi todo en la **propuesta de diseño**, que pesa el 40 % de la rúbrica:

1. La hipótesis no está contrastada: la comparación con el teléfono nunca se aplicó.
2. No hay un objeto diseñado por el autor: el Tag es un producto comprado.
3. Los resultados son de una sola persona y de pocos días.
4. La prueba de 21 días nunca se inició dentro de la app. Por eso no aparecerán las escalas semanales ni las preguntas de cierre que la memoria espera.

Quedan **37 días para el Pase de Examen**. Esta semana es de pruebas solemnes, y el cierre interno del producto está fijado para el 31 de octubre.

## Plazos

| Fecha | Hito | Días desde hoy |
| --- | --- | ---: |
| 19–23 oct. | Semana de pruebas solemnes | 0 |
| 31 oct. | Cierre interno: producto prácticamente terminado | 12 |
| 15 nov. | Cierre interno de producto, evidencia, memoria y entregables | 27 |
| 25 nov. | **Entrega del Pase de Examen** | 37 |
| 2 dic. | **Entrega de la memoria** | 44 |
| 14–18 dic. | **Examen de Proyecto de Título** | 56–60 |

## Lo que está

| Parte | Estado | Evidencia |
| --- | --- | --- |
| Investigación | Completa: 8 entrevistas analizadas con el método Framework, encuesta de 53 respuestas, comparación de referentes, 78 referencias verificadas y 8 criterios de diseño trazables. | Memoria v5, capítulos 5 a 9, y anexos A a D (listados). |
| Formulación | Pregunta, hipótesis (D-091), objetivos, actores y método por fases. | Memoria v5, capítulo 10. |
| App Android | La 2.32 para el testeo y la 3.2 con la línea visual nueva; 86 pruebas automáticas; consentimiento v13; borrado local y remoto. | [Relevo como sistema](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/relevo-frontend-y-backend.md). |
| Objeto | El Tag comercial suena desde la app y su botón calla la señal. Los fallos reales se corrigieron en la 2.31 y la 2.32. | Versiones [2.31](../06_desarrollo_y_factibilidad/app-android/version-2.31-el-tag-se-calla-2026-10-14.md) y [2.32](../06_desarrollo_y_factibilidad/app-android/version-2.32-el-tag-no-se-corta-2026-10-17.md). |
| Datos y panel | Supabase con reglas por persona y el panel funcionando fuera de claude.ai. | [HERRAMIENTAS.md](../HERRAMIENTAS.md). |
| Prueba en casa | Una persona, del 8 al 16 de octubre: 10 relevos, 7 con señal, 7 respondidos y 3 eliminados; ninguna señal fallida y 2 interrumpidas. | Supabase, recuento del 19 de octubre. |
| Identidad | Aprobada: logo, Instrument Sans, íconos y color con fundamento. | Memoria v5, Anexo H. |
| Memoria | Borrador v5 con 18.700 palabras en los capítulos 1 a 14, dentro del rango recomendado de 15.000 a 20.000, y diagramado en A3. | [Borrador v5](../08_memoria/borrador-memoria-v5-2026-10-11.md) y [memoria en A3](../08_memoria/memoria-a3/README.md). |
| Wireframes | 39 pantallas de la app actual, en muy baja fidelidad. | [Lámina](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-relevo.html). |
| Trazabilidad | Registro de pedidos diario, 137 decisiones, bitácoras y documentos por versión. | `00_gobernanza/` y `09_decisiones/`. |

## Lo que falta sí o sí

Ordenado por riesgo para el Pase y el examen.

### 1. Resolver cuántas personas participan

- **El dato:** la presentación del 14 de octubre dice «3 personas probándolo en su casa», pero en Supabase solo una persona envía datos desde el 7 de octubre.
- **Las posibilidades:** si hay otras dos, no han aceptado participar, no tienen conexión o no han empezado. Si son tres, sus datos se están perdiendo.
- **La acción:** confirmar con cada una, revisar en el panel si su código aparece y, si no, reinstalar o acompañar la configuración.
- **Coherencia:** la memoria y la presentación tienen que decir lo mismo.

### 2. La prueba de 21 días no está iniciada en la app

- **El dato:** los relevos de la participante no tienen condición ni día de la prueba (`study_condition` y `study_day` vacíos). Nunca se tocó «Empezar la prueba hoy».
- **La consecuencia:** la app no mostrará las tarjetas semanales (costo de preparar, molestia y relación con el lugar) ni las cinco preguntas de cierre. La memoria cuenta con esas escalas: queda un dato por confirmar que dice «actualizar con … las escalas semanales y la entrevista de cierre».
- **Las opciones:**
  - **a)** Iniciar la prueba ahora en su teléfono, con una secuencia elegida.
  - **b)** Aplicar las escalas y el cierre fuera de la app, en papel o en un formulario, y hacer la entrevista de cierre de 15 minutos del protocolo.
- **Recomendación:** la **b** para las escalas y el cierre, porque no cambia lo que la persona ya está haciendo. Además, decidir la comparación del punto 3.

### 3. La hipótesis sigue sin contrastar

- **El dato:** la memoria lo declara con honestidad: la comparación con un lugar neutro y con el teléfono «quedó diseñada e implementada, pero no se aplica a este caso».
- **El riesgo:** es el mayor de la formulación y de la propuesta. El criterio 8 dice que el valor del objeto solo se demuestra comparándolo, y la comisión de julio pidió distinguir proyecto de prototipo.
- **Opciones de menor costo**, en orden:
  1. **Una semana C** con la misma persona: la señal suena solo en el teléfono, con la notificación genérica, y se compara con sus semanas de Tag. La app ya lo soporta. Es un contraste dentro de una persona, no una prueba de la hipótesis, pero da evidencia del criterio 8.
  2. **Una sesión breve de comparación** con dos o tres personas más, al estilo del protocolo 01: la misma señal desde el lugar del primer paso, desde otro lugar y en el teléfono.
  3. Si no hay tiempo, **reformular el alcance** en la memoria y la presentación: lo que se probó es que la señal se entiende y se asocia; la comparación queda como siguiente etapa.
- **La decisión es del autor**, y conviene tomarla esta semana para que alcance antes del 15 de noviembre.

### 4. Un objeto diseñado por el autor

- **El dato:** la presentación del 14 de octubre lo plantea como duda («¿Tengo que construirlo entero? ¿Basta con diseñarle una forma propia al Tag?»), pero la respuesta de los profesores no está registrada en el repositorio.
- **Lo mínimo que se espera en Proyecto de Título:** la matriz de pase pide un «prototipo final: planos, registro de uso, documentación gráfica». Sin una forma propia, la parte física de la propuesta queda como compra.
- **Lo mínimo factible en el plazo:** una **carcasa propia para el Tag** que siga la especificación del testigo de la memoria (planta circular de 42 a 48 mm, sin frente, con el botón accesible). Se resuelve con modelo 3D, impresión, fotos en uso, planos con medidas y una ficha de materiales y costos. La señal y el volumen del Tag no cambian, y eso se declara como límite.
- **Antes, registrar** lo que dijeron los profesores el 14 de octubre, como decisión D-138.

### 5. Instalar la 2.32 y probarla con el Tag real

- **El dato:** la participante seguía en la 2.31 el 18 de octubre. Los dos problemas que reportó del Tag (pitido que no se detiene y sonido lento después de horas sin uso) solo se corrigen en la 2.32, y esa corrección no se ha probado con el Tag real.
- **La acción:** instalar la 2.32, poner una pila CR2032 nueva y revisar en el panel la demora del Tag y cómo quedó al callarlo, después de horas sin uso.

### 6. Fotografías y registro del uso real

- **Figuras pendientes:** la Figura 4 (el Tag junto al primer paso) y la Figura 3 (capturas de la preparación) siguen pendientes, y no hay fotos ni video del uso en casa.
- **Para qué hacen falta:** son la evidencia visual que pide la matriz de pase en «registro de uso» y lo que más ayuda a la comisión a entender el objeto, que fue la crítica central del examen de julio.
- **Cómo hacerlas:** con consentimiento para las imágenes, sin caras, nombres ni datos del teléfono.

### 7. Completar la memoria

- **21 datos por confirmar, que solo el autor sabe:**
  - **Identificación:** nombre legal, denominación del título y frase de marca.
  - **Método:** grabación y transcripción, encuesta y su relación con la de 70 participantes, y herramientas de IA usadas antes de septiembre.
  - **Costos:** monto pagado por el Tag, teléfono, servicio remoto, suscripciones de IA, total y financiamiento.
  - **Ética:** si la Escuela exige una revisión ética y la fecha de revisión del consentimiento.
  - **Prueba:** si hubo sesión inicial presencial y si la notificación se unificó.
  - **Otros:** medidas y peso del Tag.
- **6 figuras por insertar.** Las figuras de diagramas y cifras ya existen en la versión A3; faltan las fotos.
- **Resultados y conclusiones:** actualizarlos con los registros posteriores al 13 de octubre (7 señales en vez de 5) y con las escalas y la entrevista de cierre.
- **Iteraciones y fallos:** sumar a la Tabla 7 las versiones 2.31 y 2.32. Son el mejor ejemplo de iteración guiada por el uso real. También hay que actualizar «Funcionamiento y recuperación de fallos» (capítulo 11): la app ya no reconecta cortando la conexión.
- **Versión que se presenta:** decidir cuál y decirlo igual en todas partes. El texto describe la 3.2, pero el testeo usa la 2.30 a la 2.32.
- **Anexos:** los nueve (A a I) están listados, pero no armados como documentos. La carpeta `08_memoria/anexos/` solo tiene su README. Hay que reunirlos antes del 2 de diciembre; casi todo el material ya existe en el repositorio.

### 8. La presentación del Pase y del examen

Todavía no existe. La del 14 de octubre era de estado. Tiene que mostrar con claridad:

- qué es el objeto, dónde vive y cómo funciona;
- quién lo usa y por qué en la casa;
- el flujo de la persona y el flujo técnico, por separado;
- la evidencia y sus límites.

Son justo los puntos que la comisión de julio no entendió (feedback E15).

## Lo que conviene mejorar

**App**

- **Notificación de la señal:** nombra la actividad y dice «Empieza por…», una instrucción que el diseño de la señal excluye (memoria, capítulo 11). Decidir si se deja genérica o se declara como límite.
- **Textos pendientes de la 3.2:** «Armar mi ruta» en la primera vez, y la línea «Suena en el Tag…», que sigue visible aunque se elija el teléfono.
- **Accesibilidad:** probar con TalkBack y con la letra al 200 %.
- **Video «Cómo funciona»:** es anterior a la marca y al Tag.

**Panel**

- La copia publicada en claude.ai es anterior a los cambios de la 2.31 y la 2.32. El repositorio está al día, pero conviene usarlo con `node servidor.js` o volver a publicarlo.

**Repositorio**

- **Issues desactualizados:** el #8 al #11 describen la luz, la micro:bit y el testigo con LiPo de septiembre. Habría que cerrarlos o ponerlos al día con el estado real.
- **PR abiertos:** el [joan1542003-byte/proyecto-titulo#12](https://github.com/joan1542003-byte/proyecto-titulo/pull/12) y el [joan1542003-byte/proyecto-titulo#13](https://github.com/joan1542003-byte/proyecto-titulo/pull/13), del 25 de septiembre y el 9 de octubre, siguen sin integrar. El #13 usa D-121, que ya tiene otro uso. Conviene cerrarlos o integrar lo útil.
- **README de la app desactualizado:** su encabezado todavía dice «APK vigente: 2.14» y «Fecha: 29 de septiembre».
- **Tamaño:** el repositorio pesa unos 785 MB, por los APK de cada versión, y GitHub recomienda menos de 1 GB. Se podría dejar solo los APK de las versiones vigentes y mover el resto a los *releases* de GitHub.

**Marca**

- Hacer la búsqueda en INAPI de marcas parecidas a «Relevo», pendiente desde el 11 de octubre.

## Lo que no hay y debería haber

| Falta | Por qué importa | Dimensión de la rúbrica |
| --- | --- | --- |
| Evidencia de comparación, aunque sea mínima | El criterio 8 y la hipótesis dependen de ella. | Formulación y propuesta |
| Forma propia del objeto: modelo, planos y prototipo impreso | Hoy la parte física es una compra. | Propuesta: solución, factibilidad y producción |
| Fotos y video del uso en casa | Es la evidencia de «registro de uso» y explica el objeto. | Propuesta y presentación |
| Escalas semanales y entrevista de cierre | Son la valoración de la carga, la molestia y el lugar. | Validación |
| Costos reales del prototipo | La Tabla 9 tiene todos sus montos por confirmar. | Factibilidad y gestión |
| Registro del feedback del 14 de octubre | Es la respuesta de los profesores a las dudas sobre el objeto. | Proceso |
| Anexos armados | Forman parte de la entrega del 2 de diciembre. | Formal |
| Presentación del Pase | Es la entrega del 25 de noviembre. | Todas |

## Estimación por rúbrica

Estimación propia y orientativa, con la rúbrica de Proyecto de Título.

| Dimensión | Peso | Nivel estimado hoy | Qué lo sube |
| --- | ---: | --- | --- |
| Formulación | 20 % | Bueno | Contrastar algo de la hipótesis o reformular su alcance con claridad. |
| Desarrollo de la investigación | 40 % | Bueno a excelente | Mantener la trazabilidad; armar los anexos A a D. |
| Propuesta de diseño | 40 % | Suficiente a bueno | Objeto propio documentado, resultados con escalas y entrevista, costos reales y fotos del uso. |

La app y el uso de tecnologías están por sobre lo esperado. El marco ético también: consentimiento, seudonimización, borrado y ausencia de patrones oscuros. Lo débil es la factibilidad y la producción del objeto, y la validación.

## Plan sugerido

| Semana | Foco | Quién |
| --- | --- | --- |
| 19–25 oct. (solemnes) | Instalar la 2.32 y poner una pila nueva; confirmar cuántas personas participan; registrar el feedback del 14 de octubre; decidir la comparación (punto 3) y el objeto (punto 4); completar los datos por confirmar que solo sabe el autor. | Autor, con apoyo para registrar y documentar. |
| 26 oct.–1 nov. | Modelar e imprimir la carcasa o la maqueta del objeto; fotografiar el uso; empezar la semana de comparación si se decidió; reunir costos. | Autor; la IA puede apoyar el modelado paramétrico y los planos. |
| 2–8 nov. | Escalas y entrevista de cierre; actualizar resultados, figuras y conclusiones; armar los anexos. | Autor e IA. |
| 9–15 nov. | Memoria v6 cerrada (cierre interno del 15 de noviembre); regenerar la versión A3. | IA, con revisión del autor. |
| 16–24 nov. | Presentación del Pase y ensayo. | Autor e IA. |
| 25 nov. | Entrega del Pase. | Autor. |

## Registro de cambios (disclaimer)

### 2026-10-19 — Creación

- **Qué se añadió:** una revisión del estado completo del proyecto, con lo que está, lo que falta sí o sí, lo que conviene mejorar, lo que no existe, una estimación por rúbrica y un plan hasta el Pase.
- **Cómo estaba antes:** los pendientes estaban repartidos entre el traspaso, las bitácoras, los documentos de versión, la presentación del 14 de octubre y GitHub, y algunos estaban desactualizados.
- **Por qué:** pedido del autor del 19 de octubre de 2026.
