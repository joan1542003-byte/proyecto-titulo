# Auditoría 5 — propuesta phygital, sistema, interacción, factibilidad y modelo de gestión

---
id: AUD-05-SISTEMA-FACTIBILIDAD-2026-08-24
titulo: "Auditoría 5 — propuesta phygital, sistema, interacción, factibilidad y modelo de gestión"
agente: "Luna Max"
fecha: 2026-08-24
estado: "informe de auditoría; no integrado a la memoria vigente"
alcance: "Revisión de 05_propuesta_phygital, 06_desarrollo_y_factibilidad y de los capítulos correspondientes de memoria-vigente.md"
restriccion: "No se modificó memoria-vigente.md; no se incorporan desempeños, preferencias, validaciones ni costos no comprobados."
---

## Resultado ejecutivo

Relevo tiene una formulación defendible: una aplicación Android configura una intención y una condición; un objeto físico sin pantalla emite una señal; la persona lo sitúa junto al primer paso de una actividad y decide qué hacer cuando la señal aparece. La idea se reconoce después de leer el resumen, la escena inicial y el capítulo 8 de la [memoria vigente](memoria-vigente.md). Sin embargo, todavía no se entiende con suficiente inmediatez para una persona que no conoce el proceso, porque la explicación mezcla en la misma secuencia el problema cognitivo, el mecanismo, la arquitectura Android, la forma, los componentes electrónicos y las metas económicas.

El sistema tampoco está cerrado en el sentido de que sus tres partes tengan una relación necesaria ya demostrada. La aplicación y el objeto sí forman una dependencia técnica prevista. El lugar, en cambio, es actualmente una asociación manual y una hipótesis experiencial: el sistema no detecta la ubicación, no sabe si el objeto sigue junto al primer paso y no puede atribuir por sí solo un significado a la señal. Por lo tanto, la formulación correcta es que Relevo **propone investigar un sistema experiencial triádico** —persona, aplicación-testigo y lugar—, no que ya haya probado que esas tres partes son inseparables.

La ausencia de pantalla es una restricción firme del proyecto. Su valor como señal no textual, asociada a un lugar y a un primer paso, permanece como hipótesis investigable; también crea riesgos: el objeto puede parecer una alarma genérica, los estados pueden ser ambiguos y el significado puede perderse si se mueve. Si una dirección física falla, se reformula o reemplaza esa dirección, pero cualquier alternativa mantiene el carácter phygital y el objeto físico sin pantalla.

El problema de mayor prioridad es la condición de activación. La memoria habla de condición aproximada, umbral, ventana y uso de una aplicación seleccionada, pero todavía no define qué se acumula, durante cuánto tiempo, qué sucede al cambiar de aplicación, cómo se reinicia la regla ni qué ocurre cuando Android entrega el evento tarde. Sin esta definición no es posible auditar de manera honesta la arquitectura técnica, los flujos, la autonomía de la batería, la señal ni el costo.

La recomendación general es reordenar la memoria de acuerdo con cuatro niveles: **propósito de la intervención**, **regla operacional mínima**, **sistema de experiencia** y **factibilidad condicionada**. Las dimensiones, componentes, duraciones de señal, precio de venta y metas de autonomía deben quedar como hipótesis de desarrollo o retirarse del cuerpo principal hasta que exista una pregunta de prueba y una fuente o medición que los sostenga.

## 1. Criterio de auditoría y clasificación de afirmaciones

La revisión se realizó como una auditoría de Proyecto de Título. Se consideró si cada afirmación permite comprender qué problema se aborda, qué decisión de diseño se toma, cómo se puede poner a prueba, qué se necesita para producirla y qué parte sigue abierta. Se distinguieron los siguientes niveles:

| Nivel | Uso en este informe | Ejemplo aplicado a Relevo |
| --- | --- | --- |
| Hecho o restricción | Algo confirmado por el registro del proyecto o por una condición institucional | El objeto no tiene pantalla; existen ocho entrevistas reales; el registro disponible no acredita desempeño técnico. |
| Evidencia | Material que permite sostener una afirmación dentro de sus límites | Entrevistas, fuentes académicas, documentación oficial de Android, hojas de datos o una medición reproducible. |
| Interpretación | Lectura del autor a partir de la evidencia | Algunas actividades requieren materiales disponibles; eso orienta a explorar una asociación espacial. |
| Hipótesis | Relación que aún debe ponerse a prueba | Una ubicación congruente puede ayudar a recordar el primer paso. |
| Decisión provisional | Elección de diseño que organiza la siguiente etapa | Mantener el testigo sin pantalla, una intención activa y una señal que no califica la conducta. |
| Pendiente crítico | Decisión que modifica la arquitectura o puede invalidar la propuesta | Definir qué significa exactamente que se cumpla la condición de activación. |

El [feedback E15](matriz-incorporacion-feedback-e15.md) se utiliza aquí como orientación de auditoría y priorización. No se trata como evidencia de que una persona comprenda, prefiera o tolere el sistema.

## 2. ¿Se entiende Relevo de inmediato?

### 2.1 Diagnóstico

La memoria contiene una buena definición distribuida en varios lugares: el título dice “testigo phygital doméstico”, la escena explica un caso y los capítulos 8 y 11 describen el sistema. El problema es de jerarquía, no de ausencia de contenido. En la primera lectura aparecen al mismo tiempo términos que todavía requieren explicación —testigo, descarga de intenciones, clave de recuperación, condición aproximada, Bluetooth LE, UsageStatsManager— y detalles que no son necesarios para comprender la propuesta.

La definición actual también deja una ambigüedad importante: el lector puede creer que el objeto detecta la sesión o conoce la intención. En realidad, la aplicación evalúa una regla local; el objeto recibe un identificador de patrón y emite una señal; el lugar no es detectado por el sistema. Esa distinción debe aparecer antes de cualquier detalle técnico.

### 2.2 Definición canónica recomendada

Se recomienda usar una formulación breve y estable al inicio de la memoria, en el resumen, en la introducción y al comienzo de la propuesta. La siguiente redacción es una propuesta de contenido, no una validación de la solución:

> Relevo es un sistema phygital que vincula una aplicación Android con un objeto físico sin pantalla, situado junto al primer paso de una actividad que la persona quiere mantener disponible. Cuando se cumple una condición de uso elegida, el objeto emite una señal configurable; la persona puede recuperar esa asociación, continuar con el teléfono o silenciarla. Relevo no bloquea aplicaciones, no califica la conducta ni registra si la actividad fue realizada.

Después de esa definición deben responderse tres preguntas en el mismo orden:

1. **Qué problema aborda:** una intención autoelegida puede dejar de participar durante algunas sesiones digitales que continúan sin una decisión renovada.
2. **Cómo interviene:** externaliza una señal mediante una aplicación, un objeto y una asociación espacial; no detecta estados subjetivos.
3. **Por qué el objeto físico es necesario como hipótesis:** permite investigar si la señal situada en el entorno aporta una clave que una notificación en la pantalla no entrega.

La escena de caminar y ponerse las zapatillas puede conservarse como escenario hipotético. Debe rotularse como ejemplo de uso y no como conducta observada de las personas entrevistadas. El texto debe evitar que Instagram, las zapatillas o el hogar parezcan datos del corpus si no provienen de él.

## 3. Auditoría del sistema phygital

### 3.1 La relación entre aplicación, objeto, lugar y persona

La memoria identifica tres componentes, pero el significado no reside en ellos por separado. La persona debe incorporarse explícitamente a la arquitectura: formula la intención, elige el primer paso, interpreta la señal y decide. Sin esa capa, el sistema parece un mecanismo automático de notificación y se debilita la promesa de autonomía.

| Elemento | Función que sí está fundamentada como propuesta | Lo que no puede afirmarse todavía | Decisión de auditoría |
| --- | --- | --- | --- |
| Persona | Define intención, primer paso, aplicación, ventana y modalidad; sitúa el objeto e interpreta la señal | Que recuerde siempre la asociación o que actúe después | Mantener como agente decisor explícito del sistema |
| Aplicación Android | Configura la regla, solicita permisos, evalúa una condición técnica y comunica el estado | Que la evaluación sea instantánea, estable entre fabricantes o equivalente a detectar automatismo | Mantener como plataforma de prototipo, con alcance técnico acotado |
| Regla local | Traduce una condición definida por la persona a un evento operacional | Que represente una experiencia subjetiva o que mida pérdida de control | Reemplazar lenguaje de “automatismo” por una condición observable |
| Bluetooth LE | Transporta un identificador de patrón y estados técnicos entre aplicación y objeto | Que la conexión permanezca disponible durante todas las ventanas de uso | Mantener como alternativa técnica condicionada a pruebas |
| Testigo sin pantalla | Hace perceptible una señal, permite silenciar y conserva una asociación física | Que comunique por sí mismo qué intención representa o que sea perceptible para todos | Mantener la ausencia de pantalla; probar asociación, señal y controles |
| Lugar y primer paso | Aportan contexto externo y una clave espacial elegida por la persona | Que el sistema conozca la ubicación, la conserve o que la cercanía provoque la acción | Reformular como componente experiencial y variable experimental |
| Datos locales | Conservan configuración y permiten operar la regla | Que “local” signifique ausencia completa de vigilancia: Android entrega a la app acceso amplio a estadísticas de uso | Ampliar mapa de datos, permisos, retención y eliminación |

La relación es, por ahora, de dos tipos:

- **Dependencia técnica:** aplicación, regla local, enlace y objeto deben coordinarse para producir la señal.
- **Dependencia experiencial:** el lugar puede ayudar a interpretar la señal porque se eligió junto al primer paso, pero esa contribución debe compararse con una ubicación neutra y con una notificación.

Esta diferencia debe aparecer en la memoria. Si la ubicación congruente no mejora la recuperación ni aporta un valor reconocible, el lugar no debe conservarse como una pieza indispensable solo porque el proyecto debe ser phygital. Podría quedar como contexto de uso, o la arquitectura tendría que reformularse.

### 3.2 Arquitectura mínima propuesta

La arquitectura que conviene llevar a la siguiente iteración es la mínima que permite probar el valor del sistema sin comprometerlo con hardware o automatización innecesarios:

```text
Persona formula una intención y un primer paso
        ↓
Aplicación configura una regla local + una ventana + una señal
        ↓
Persona concede el permiso necesario y vincula el testigo
        ↓
Persona sitúa el testigo junto al primer paso y prueba su percepción
        ↓
Persona arma explícitamente la regla
        ↓
Aplicación evalúa una única condición operacional en la aplicación seleccionada
        ↓
Aplicación envía un patrón con vencimiento al testigo
        ↓
Testigo emite una señal no textual y acotada
        ↓
Persona reconstruye la asociación en el lugar y decide
        ├─ retomar la actividad alternativa
        ├─ continuar con el teléfono
        └─ silenciar o desarmar sin penalización
```

El lugar no debe dibujarse como un sensor ni como una entrada automática al flujo. La arquitectura debe indicar que la asociación espacial la crea la persona al situar el objeto. Si el objeto se mueve, el sistema no lo sabe: la reubicación exige una decisión explícita y, preferentemente, una nueva prueba antes de armar.

## 4. Objeto sin pantalla

### 4.1 Decisión que debe mantenerse

La ausencia de pantalla está bien alineada con el propósito de investigar una clave no textual y con la intención de no devolver el contenido de la intervención al teléfono. También puede reducir exposición de la intención frente a convivientes, consumo, complejidad de interfaz y dependencia de una nueva superficie de lectura.

Debe mantenerse como una **restricción firme del proyecto**; que esa ausencia produzca una asociación suficiente sigue siendo una hipótesis de investigación, no un desempeño validado.

### 4.2 Justificación que debe reemplazarse

La memoria justifica la ausencia de pantalla en parte por costo, energía, espesor y exposición. Esos motivos son secundarios y podrían aplicarse a muchos objetos. La justificación principal debe responder a una pregunta de diseño:

> ¿Puede una señal física no textual, vinculada a un lugar y a un primer paso, recuperar la intención sin exigir que la persona vuelva a leer el teléfono?

La restricción de ausencia de pantalla se mantiene; su valor experiencial solo se sostiene si la respuesta permite una asociación suficiente. Sus beneficios y riesgos deben exponerse en paralelo:

| Beneficio hipotético | Riesgo correspondiente | Prueba necesaria |
| --- | --- | --- |
| Evita repetir en el objeto el contenido de la intención | La señal puede parecer una alarma genérica | Recuperación de intención y primer paso sin consultar la app |
| Mantiene la intervención fuera de la pantalla | La persona puede volver al teléfono para descifrarla | Consulta del teléfono y recuerdo espontáneo |
| Reduce superficies de interacción y datos expuestos | El estado armado, desarmado o fallido puede ser ambiguo | Comprensión de estados y recuperación de errores |
| Hace relevante el lugar | La asociación puede desaparecer al mover el objeto | Comparación situado/neutro y prueba de reubicación |
| Permite un objeto pequeño | El objeto puede convertirse en decoración o perderse | Repetición de armado, ubicación y uso durante el piloto |

El criterio de cambio debe quedar claro: si la señal sin texto requiere una consulta reiterada a la app, se modifica la señal, la asociación o la dirección física. No se presenta una pantalla como salida: la ausencia de pantalla sigue siendo una restricción firme y no se protege su valor por coherencia formal.

### 4.3 Control y estados sin pantalla

Existe una contradicción pendiente entre la memoria y la preparación de la siguiente interacción. La memoria presenta una pulsación prolongada de dos segundos como control de armado/desarmado y una pulsación breve como silencio; la preparación de [05_propuesta_phygital](../05_propuesta_phygital/preparacion-escrita-encargo-17.md) pregunta todavía si el armado ocurrirá desde la aplicación, desde el botón o desde ambas superficies.

Esta decisión no puede quedar implícita. Antes de wireframing debe definirse:

- qué superficie inicia el armado;
- cómo se confirma que el testigo quedó armado si no tiene pantalla;
- cómo se evita que una pulsación accidental silencie, desarme o arme;
- qué sucede si la aplicación indica “listo” pero el objeto no recibió el estado;
- cómo se recupera el sistema sin agregar una pantalla física;
- si el control físico se aprende en la aplicación o debe ser comprensible sin instrucciones.

La recomendación de arquitectura es que el armado sea una acción explícita de la aplicación después de completar permiso, vínculo, prueba y ubicación; el botón físico puede quedar reservado para silencio y recuperación local, salvo que una prueba demuestre que un armado físico aporta valor. Esto reduce estados divergentes entre app y objeto. No debe considerarse una decisión cerrada hasta probarla.

## 5. Contexto doméstico y caso de uso

### 5.1 Diagnóstico

La memoria usa “doméstico” como alcance del producto mínimo viable (MVP) y lo relaciona con estrategias mencionadas en las entrevistas. Esa relación es razonable como hipótesis, pero las entrevistas no observaron sistemáticamente hogares, superficies, convivientes, distancias ni condiciones de privacidad. Por ello no puede decirse que el hogar sea el contexto validado del proyecto.

Además, “doméstico” puede significar una habitación privada, un espacio compartido, una casa con varias personas o un objeto trasladable dentro del hogar. Cada situación cambia la percepción, el sonido, la privacidad y la posibilidad de asociar un lugar.

### 5.2 Caso mínimo recomendado

Para que la memoria de Proyecto de Título no prometa un mercado o una situación que todavía no estudió, el caso de uso debe quedar así de acotado:

> Una persona adulta joven, en un espacio doméstico elegido por ella, inicia o prolonga una sesión de ocio en una única aplicación seleccionada. Antes de usarla, formula una actividad alternativa y un primer paso concreto, sitúa el testigo cerca de ese primer paso y arma una ventana de intervención. El testigo señala una sola vez cuando se cumple la condición operacional. La persona interpreta la señal, puede retomar la alternativa, continuar con su ocio o silenciarla.

Este caso no supone que el objeto permanezca instalado, que la persona viva sola, que la actividad sea productiva, que el usuario quiera dormir o que el problema ocurra en toda sesión digital. Deben quedar fuera del alcance actual: diagnóstico de adicción, tratamiento de insomnio, control parental, trabajo, rendimiento escolar, reducción universal de pantalla y monitoreo de convivientes.

### 5.3 Lugar como asociación manual

La memoria debe distinguir entre:

- **Lugar detectado:** el sistema reconoce automáticamente una ubicación y la usa como condición. Relevo no propone esto.
- **Lugar seleccionado:** la persona sitúa el objeto junto al primer paso y usa esa proximidad para reconstruir una asociación. Esta es la hipótesis vigente.

La palabra “situado” solo es precisa si se acompaña de esta limitación. La movilidad puede ser una ventaja para probar actividades distintas, pero crea una obligación de reubicación: cada cambio de lugar debe permitir volver a probar y armar. De lo contrario, el diseño delega una condición crítica en la memoria de uso y no en una regla comprensible.

## 6. Condición de activación: el pendiente crítico

### 6.1 Lo que falta definir

La memoria menciona “condición aproximada”, “umbral”, “ventana”, “aplicación seleccionada” y “uso continuo”, pero no define una regla única. Antes de desarrollar la aplicación deben resolverse al menos estas preguntas:

| Variable | Alternativas que no deben mezclarse | Consecuencia |
| --- | --- | --- |
| Evento observado | Tiempo de primer plano de una app; aperturas; permanencia; acumulación en ventana | Cambia lo que Android puede medir y lo que la persona entiende |
| Forma de acumulación | Continua; acumulada con pausas; por sesión | Cambia cuándo se activa y qué significa “seguir” |
| Ventana | Desde armado hasta una hora; hasta cierre; una franja definida por la persona | Cambia batería, privacidad y pertinencia |
| Cambio de aplicación | Pausa; reinicio; continúa acumulando; cancela | Evita señales tardías o sorprendentes |
| Pantalla bloqueada | Pausa; termina; mantiene ventana | Puede producir una activación sin sesión activa |
| Activación | Una sola vez; repetible; rearmado automático | Define el riesgo de molestia y la necesidad de control |
| Señal tardía | Descartar; entregar al reconectar; mostrar error técnico | Entregar tarde puede romper el sentido de la asociación |
| Estado del permiso | Revocado; restringido por batería; aplicación cerrada | Puede hacer que la persona crea que el sistema está funcionando cuando no lo está |

### 6.2 Regla mínima candidata

Como candidato de arquitectura, se recomienda probar una única regla observable:

> Durante una ventana armada, la aplicación estima el tiempo de primer plano de una única aplicación seleccionada. Al alcanzar el umbral definido por la persona, intenta emitir una sola señal con vencimiento. Si el vínculo no está disponible dentro de ese vencimiento, el evento se descarta y se informa como fallo técnico; no se reproduce tarde.

Esta regla no afirma que se haya elegido acumulación continua o acumulada. Esa decisión debe registrarse antes de la prueba. Tampoco establece un número de minutos: el umbral debe expresarse como variable hasta que una prueba de comprensión y factibilidad permita fijarlo. Lo importante es eliminar del lenguaje la detección de “automatismo”, “pérdida de control” o “sesión poco deliberada”: la aplicación solo puede observar una condición técnica.

### 6.3 Puerta de decisión

La condición de activación debe resolverse antes de cerrar la arquitectura visual o industrial. La puerta se considera cumplida solo cuando exista:

1. una frase operacional sin términos subjetivos;
2. una tabla de estados para cambio de app, bloqueo, reinicio y expiración;
3. una prueba con eventos reales y simulados en los teléfonos objetivo;
4. un criterio para que una activación tardía no se presente como señal válida;
5. una explicación comprensible para la persona usuaria;
6. un registro de permisos y límites de privacidad.

## 7. Android y factibilidad técnica

### 7.1 Qué se puede mantener

La documentación de la memoria acierta al tratar Android, UsageStatsManager, Bluetooth LE, permisos y ejecución en segundo plano como riesgos y no como capacidades garantizadas. También es correcto separar un prototipo de enlace de una versión compacta y advertir que el comportamiento varía según versión y fabricante.

### 7.2 Qué debe corregirse

Android aparece como la única plataforma del MVP, pero el registro de entrevistas no confirma que el corpus use Android ni que exista una razón de mercado para excluir iOS. Esa exclusión puede mantenerse como **límite técnico del prototipo**, no como definición del público objetivo. La memoria debe decir por qué se elige Android: es una plataforma de investigación para probar la regla de uso y el enlace BLE, no una preferencia demostrada del usuario.

También debe evitarse presentar “la aplicación consulta la condición” como si el sistema operativo garantizara un evento instantáneo. La factibilidad necesita una matriz técnica mínima:

| Prueba | Pregunta | Evidencia de cierre |
| --- | --- | --- |
| Permiso de uso | ¿La persona entiende el permiso y la app obtiene solo lo necesario para el prototipo? | Pasos reproducibles, estado concedido/revocado y mensaje de error |
| Evento de aplicación | ¿La API entrega los eventos y tiempos con una precisión suficiente para la regla? | Registro técnico comparado con observación controlada |
| Segundo plano | ¿La regla se evalúa con pantalla apagada, app cerrada o batería optimizada? | Matriz por versión, fabricante y estado de energía |
| BLE | ¿El enlace se establece, mantiene y recupera dentro de la ventana? | Tasa de comandos entregados, perdidos y tardíos |
| Reinicio | ¿Qué sucede después de reiniciar teléfono u objeto? | Estado explícito de recuperación y rearmado |
| Batería | ¿Cómo se conoce el estado si el objeto no tiene pantalla? | Lectura en la app, advertencia y conducta ante batería baja |
| Distribución | ¿El prototipo requiere Play Store, servicio visible o permisos adicionales? | Alcance declarado; no confundir demostración académica con producto comercial |

La arquitectura no debe elegir todavía una versión mínima de Android ni una API definitiva solo porque aparece en una lista de componentes. Primero se fija la regla; después se elige la implementación que permita probarla con la menor carga.

### 7.3 Flujo técnico propuesto

```text
CONFIGURACIÓN
Aplicación guarda localmente intención, primer paso, app seleccionada,
condición, ventana y modalidad.
        ↓
PRECONDICIONES
Verifica permiso, vínculo, batería, estado del objeto y ventana válida.
Si falla algo, no arma la regla y explica la recuperación.
        ↓
ESPERA ARMADA
Evalúa solo la condición operacional definida para una app seleccionada.
No interpreta emoción, automatismo, intención ni cumplimiento.
        ↓
CONDICIÓN CUMPLIDA
Genera un comando con identificador de patrón y vencimiento.
        ↓
ENTREGA BLE
Si el testigo confirma dentro de la ventana, ejecuta una señal única.
Si no confirma, registra un fallo técnico local y descarta el comando.
        ↓
SEÑAL FÍSICA
El botón permite silenciar una señal activa según el estado definido.
        ↓
REPOSO
No se registra si la persona actuó, continuó o ignoró la señal.
El siguiente ciclo exige armado explícito.
```

El diagrama debe acompañarse de ramas para permiso revocado, app cerrada, cambio de aplicación, teléfono reiniciado, objeto desconectado, batería baja, señal no percibida y reubicación. Un flujo lineal que omite estas condiciones da una impresión de factibilidad mayor que la disponible.

## 8. Canales y accesibilidad

### 8.1 Canales: mantener el principio, retirar la falsa precisión

Es correcto mantener la idea de modalidades configurables y la advertencia de que ningún canal es universal. También es acertado reconocer que la vibración no es necesariamente háptica cuando el objeto descansa sobre una superficie.

En cambio, el halo de diez a doce segundos, el bitono inferior a un segundo, los pulsos LRA de 150–220 ms y el límite de tres destellos por segundo aparecen demasiado pronto. Son parámetros de laboratorio, no conclusiones de diseño. La referencia WCAG sobre destellos puede prevenir un riesgo específico, pero no demuestra que la señal sea accesible, perceptible, tolerable o adecuada al hogar.

| Canal | Posible aporte | Riesgo que debe probarse | Redacción recomendada en esta etapa |
| --- | --- | --- | --- |
| Luz | Señal discreta y no textual cuando existe línea de visión | Puede no verse, confundirse con decoración o depender del color | “Se probará una señal visual configurable; no se declara suficiencia ni universalidad.” |
| Sonido | Puede alcanzar otra habitación y no requiere línea de visión | Intrusión, convivencia, exposición de la regla y sobresalto | “Se evaluará por alcance, privacidad y tolerancia, no como ampliación garantizada.” |
| Vibración o resonancia | Puede aportar una diferencia física sin sonido | Puede no sentirse sobre una superficie; el LRA no equivale a contacto háptico | “El actuador intentará producir vibración; su percepción en superficie es una pregunta de prueba.” |
| Combinación | Puede aumentar detectabilidad | Aumenta carga, molestia y consumo | “Se compararán perfiles limitados y se permitirá desactivar canales.” |

La validación debe medir al menos detección, atribución al testigo, comprensión del significado, intrusión, privacidad y posibilidad de silenciar. No se debe sumar todo en una única puntuación de “accesibilidad”.

### 8.2 Accesibilidad como requisito verificable

La frase “perceptible y accesible” es demasiado amplia para presentarse como criterio ya cumplido. Debe desagregarse:

| Dimensión | Requisito a investigar | Límite actual |
| --- | --- | --- |
| Visual | No depender exclusivamente de un color; permitir percibir la señal en distintas condiciones de iluminación | No hay evidencia de percepción visual del prototipo |
| Auditiva | Poder desactivar sonido y definir una alternativa no sonora | No se ha probado convivencia ni diferencias auditivas |
| Táctil | No prometer que una vibración sobre mesa será percibida como tacto | No hay medición de superficies ni usuarios con necesidades diversas |
| Cognitiva | Explicar una sola intención, un solo estado y una recuperación acotada | El objeto sin pantalla puede generar ambigüedad |
| Motora | Reducir precisión y fuerza necesarias para silenciar o rearmar | El gesto de dos segundos aún no está probado |
| Doméstica | Controlar alcance, privacidad y molestia para convivientes | El hogar no fue observado sistemáticamente |

Las ocho entrevistas no constituyen evidencia de accesibilidad. La siguiente etapa debe declarar si realizará una exploración inclusiva específica o si presentará estas dimensiones como límites del estudio. No corresponde usar la palabra “accesible” como resultado antes de esa prueba.

## 9. Privacidad y autonomía

### 9.1 Fortalezas

La propuesta evita cuenta, nube, GPS, UWB, NFC, micrófono, historial de cumplimiento, ranking, rachas y texto en el objeto. También distingue entre evaluar una regla y evaluar a la persona. Estas son decisiones valiosas y deben conservarse.

### 9.2 Corrección necesaria: local no equivale a ausencia de seguimiento

La aplicación necesita observar técnicamente el uso de una aplicación seleccionada. Aunque el procesamiento sea local y esté limitado a una ventana, esto sigue siendo una forma de observación de actividad del teléfono. La memoria debe reemplazar expresiones absolutas como “no rastrea” por una formulación precisa: **no hay seguimiento remoto ni historial conductual del servicio; existe una consulta local y acotada de datos de uso durante la regla armada**.

Se recomienda incluir un mapa de datos antes de presentar la privacidad como una propiedad resuelta:

| Dato | Finalidad | Dónde permanece | Retención y control pendiente |
| --- | --- | --- | --- |
| Intención y primer paso | Recordar la asociación en la app | Teléfono | Ver, editar, borrar y eliminar al desarmar o desinstalar |
| Paquete de aplicación seleccionado | Evaluar la condición | Teléfono | Precisar si se conserva el nombre, solo un identificador o un estado transitorio |
| Umbral y ventana | Ejecutar la regla | Teléfono | Definir retención y reinicio |
| Identificador BLE y vínculo | Comunicar con el objeto | Teléfono y memoria mínima del objeto | Desvincular, restablecer y evitar identificadores persistentes innecesarios |
| Batería, acuse y errores | Recuperación técnica | Teléfono | Definir si se conserva solo mientras la sesión está armada |
| Conducta posterior | No es necesaria para el producto | No debe almacenarse | Mantener exclusión explícita |

La memoria también debe reconocer dos riesgos de contexto: una persona con acceso al teléfono puede ver la intención, y un conviviente puede inferir que existe una regla por el sonido o la señal. Privacidad no significa invisibilidad absoluta. La configuración debe informar permisos, datos y límites en un lenguaje comprensible.

## 10. Producción, costos y factibilidad económica

### 10.1 Diagnóstico de sobredeterminación

El capítulo 9 y el Anexo C muestran una dedicación valiosa a la factibilidad, pero en esta etapa se comportan como una especificación de producto más que como un conjunto ordenado de hipótesis. Aparecen microcontroladores, gestores de energía, actuadores, batería, dimensiones, peso, materiales, color, tipo de carcasa, rangos de autonomía y precio antes de haber cerrado el comportamiento esencial.

La factibilidad debe demostrar qué se necesita para responder cada pregunta del proyecto, no anticipar una producción industrial completa. Una decisión de componente es pertinente solo si habilita una prueba concreta.

### 10.2 Especificaciones que deben bajar de nivel

| Elemento actual | Evaluación | Acción recomendada |
| --- | --- | --- |
| 44 mm, 14 mm y 28 g o menos | Meta de empaquetado sin evidencia de uso, transporte o percepción | Retirar del cuerpo principal; conservar en anexo como rango de exploración con pregunta asociada |
| Disco coral y grafito, aro, ojal, base y TPE | Dirección formal no necesaria para cerrar el mecanismo; la entrega actual no exige visualidad | Retirar de esta fase o marcar como hipótesis formal posterior |
| nRF52810/11, nPM1100, DRV2605L, LRA C08-00A | Candidatos técnicos, no selección final | Mantener solo como alternativas de prototipado y justificar cada una por la prueba que habilita |
| Li-Po protegida de 200–300 mAh | Rango de ingeniería sin presupuesto de consumo medido | Reemplazar por capacidad a determinar después de medir ciclo y picos |
| 30 y 90 días de autonomía | Meta no demostrada y poco relevante antes del patrón de uso | Retirar del argumento principal; probar primero activaciones, carga y recuperación |
| 100 activaciones, tres fabricantes y 90 % de comandos | Umbrales de prototipo posibles, pero todavía arbitrarios | Mantener solo como puertas internas si se explica su origen y se separan de resultados académicos |
| Lista de materiales (BOM, por su sigla en inglés) de USD 18–36 y meta bajo USD 25 | Escenario sin cotizaciones, volumen ni cumplimiento | Conservar como escenario condicionado, nunca como costo del producto |
| Precio CLP 79.990–99.990 | No existe disposición de pago ni comparación económica suficiente | Retirar del cuerpo y reabrir solo con investigación de mercado y costos reales |

### 10.3 Verificación aritmética corregida de la lista de materiales

La suma base corregida de las partidas documentadas es de CLP 51.140 en el extremo mínimo y CLP 92.640 en el extremo máximo. Al aplicar una contingencia del 15 %, los resultados son CLP 58.811 y CLP 106.536, respectivamente. Por redondeo de planificación, el rango comunicable es CLP 59.000–107.000. Se trata de una verificación documental sin cotizaciones nuevas y no de un costo validado del producto.

El cálculo anterior de esta auditoría, que llevaba el máximo a aproximadamente CLP 112.000, fue erróneo: incorporó una base máxima distinta de la suma trazable de las partidas. La nueva formulación parte de CLP 51.140–92.640, explicita la contingencia y mantiene separado el presupuesto académico de trabajo profesional, producción y precio. El rango no demuestra factibilidad económica; solo corrige la aritmética de planificación.

### 10.4 Modelo económico mínimo

La memoria debe separar cuatro magnitudes:

1. **Costo del prototipo académico:** materiales, fabricación, reposición, ensamble y tiempo de prueba.
2. **Costo profesional:** diseño, desarrollo, electrónica, documentación y coordinación; no es parte de la lista de materiales.
3. **Costo de producción:** volumen, proveedores, PCB, carcasa, batería, ensamble, prueba, certificación, logística, impuestos, soporte y merma.
4. **Precio o sostenibilidad del producto:** requiere disposición de pago, alternativas gratuitas, servicio posventa y una decisión de modelo de negocio.

La cifra de 140 horas de diseño puede mantenerse como escenario de trabajo si se presenta como estimación del esfuerzo profesional requerido, no como tarifa de mercado ni como conclusión económica. El precio directo debe retirarse mientras no exista evidencia específica.

## 11. Mantenimiento y modelo de gestión

### 11.1 Falta actual

La memoria menciona batería reemplazable por servicio, carga USB-C, reparación, rearmado y fin de vida, pero todavía no presenta un modelo de gestión. Un modelo de gestión no es solo producir el objeto: explica quién configura, quién mantiene, qué ocurre cuando falla el enlace, cómo se actualiza o restablece, quién controla los datos y cuándo se abandona o reemplaza el dispositivo.

La ausencia de pantalla aumenta la necesidad de una estrategia de mantenimiento comprensible en la aplicación. La persona no puede diagnosticar batería, vínculo o estado desde el objeto si no existe una señal física suficientemente clara.

### 11.2 Modelo de gestión propuesto para el MVP

| Momento | Responsable principal | Operación mínima | Decisión pendiente |
| --- | --- | --- | --- |
| Preparación | Persona + aplicación | Crear una intención, conceder permiso, vincular y probar | Qué pasos son imprescindibles y cuánto soporte requieren |
| Uso | Persona | Situar, armar, percibir, silenciar o continuar | Control definitivo de armado y señal |
| Reubicación | Persona | Mover el objeto, volver a probar y rearmar | Cómo se comunica que el lugar anterior ya no es válido |
| Batería | Persona | Consultar estado en app y cargar | Umbral de advertencia y conducta ante batería baja |
| Desconexión | Aplicación | Evitar señal tardía, explicar error y permitir reintento | Estrategia de reconexión y expiración |
| Restablecimiento | Persona o soporte | Desvincular y volver a configurar | Gesto, pérdida de datos y recuperación sin pantalla |
| Datos | Persona | Ver, editar, borrar y desarmar | Retención exacta y logs técnicos |
| Reparación | Servicio técnico o autor en prototipo | Reemplazar batería/placa según arquitectura | Si el producto es reparable por el usuario o por terceros |
| Fin de vida | Persona/servicio | Separar batería y componentes | Instrucciones, reciclaje y responsabilidad |

El alcance actual debe declarar que no hay cuenta, administración remota ni soporte a múltiples usuarios. “Un usuario, un testigo y una intención activa” es una regla de simplificación, no un modelo comercial. Si se quiere hablar de un producto sostenible, todavía falta estudiar reposición, actualizaciones, garantía, soporte y disponibilidad de piezas.

### 11.3 Rol del diseñador

El rol descrito en el Anexo C es pertinente, pero puede volverse más preciso. El diseñador no debe presentarse como responsable único de garantizar radio, autonomía, certificación o desarrollo Android. Su responsabilidad está en articular preguntas, decisiones y pruebas entre disciplinas.

| Responsabilidad del diseñador | Producto verificable | Colaboración necesaria |
| --- | --- | --- |
| Formular el problema y sus límites | Problema, usuarios situacionales, exclusiones y criterios | Investigación y dirección académica |
| Traducir evidencia a requisitos | Matriz evidencia–decisión–prueba | Investigación de usuarios y revisión bibliográfica |
| Diseñar la arquitectura de experiencia | Flujos, estados, errores, reglas de interacción y no requisitos | Desarrollo Android y electrónica |
| Definir el papel del objeto | Hipótesis de asociación, señal, control y ubicación | Prototipado físico y pruebas de percepción |
| Organizar validación | Protocolos, comparación con notificación, criterios de cambio/abandono | Participantes, registro y análisis |
| Coordinar factibilidad | Escenarios de componentes, costos, mantenimiento y límites | Ingeniería, fabricación y proveedores |
| Documentar decisiones | Memoria, anexos, fallos, iteraciones y trazabilidad | Todo el equipo o colaboradores |

La estimación de horas puede acompañar esta tabla, pero no reemplazarla. El valor profesional del diseñador se demuestra por las decisiones y la articulación del sistema, no por una cifra aislada.

## 12. Flujos propuestos

### 12.1 Flujo de diseño

El flujo actual de la memoria es correcto como esquema general, pero debe convertirse en un flujo de decisiones con puertas explícitas:

```text
1. Delimitar el fenómeno
   ↓  ¿El problema es una intención desplazada y no el tiempo de pantalla en general?
2. Traducir evidencia a requisitos y exclusiones
   ↓  ¿La ubicación, la autonomía y la ausencia de evaluación tienen respaldo o son hipótesis?
3. Definir la regla operacional mínima
   ↓  ¿Se sabe exactamente qué evento activa la señal?
4. Comparar arquitectura de intervención
   ↓  ¿La señal situada aporta una pregunta que una notificación no responde?
5. Probar asociación y forma sin automatización completa
   ↓  ¿La persona identifica intención, primer paso y control?
6. Probar canales, convivencia y accesibilidad
   ↓  ¿Existe un perfil perceptible y tolerable, sin declarar universalidad?
7. Implementar el corte técnico mínimo
   ↓  ¿Android y BLE permiten evaluar la regla sin falsas certezas?
8. Integrar y comparar con notificación
   ↓  ¿El aporte físico justifica carga, costo y mantenimiento?
9. Mantener, modificar o abandonar
```

El orden importa: no debe fijarse la carcasa, la pantalla de la app ni la lista de materiales antes de cerrar las preguntas de los pasos 3 y 4.

### 12.2 Flujo de usuario

1. La persona identifica una actividad que quiere mantener disponible y formula un primer paso observable.
2. Selecciona una única aplicación y una condición operacional dentro de una ventana.
3. Concede el permiso y vincula el testigo.
4. Elige el lugar junto al primer paso, sitúa el objeto y prueba la señal.
5. Si la señal no se percibe o el estado no es claro, la regla no se arma; la aplicación permite cambiar lugar o modalidad.
6. La persona arma explícitamente la regla.
7. Continúa con la aplicación seleccionada. El sistema evalúa la condición técnica y no interpreta su intención.
8. Si la condición se cumple y el comando llega vigente, el testigo emite una señal única.
9. La persona reconstruye la asociación y decide: retomar, continuar, silenciar o ignorar.
10. La señal termina y el sistema queda en reposo. El siguiente ciclo exige armado explícito.
11. Si el objeto se mueve, se pierde el vínculo, baja la batería o vence la ventana, la aplicación informa una recuperación técnica; no atribuye un fallo conductual.

El uso normal termina en la decisión de la persona, no en una confirmación dentro de la aplicación. La investigación sí puede preguntar después qué recordó o cómo interpretó la señal; eso pertenece al instrumento de evaluación, no al servicio cotidiano.

### 12.3 Flujo técnico

| Estado | Entrada | Operación propuesta | Salida válida | Fallo y recuperación |
| --- | --- | --- | --- | --- |
| No configurado | Falta intención, permiso, vínculo o modalidad | Mostrar el requisito faltante | Regla incompleta explícita | Completar o cancelar |
| Configurado | Regla completa | Guardar localmente y permitir prueba | Estado listo | Corregir datos |
| Probando | Persona inicia prueba | Enviar patrón temporal y verificar percepción | Lugar y canal aceptados por la persona | Mover, cambiar canal o cancelar |
| Armado | Persona confirma | Verificar permiso, batería, vínculo y ventana | Regla en espera | No armar; explicar causa |
| Evaluando | Ventana activa | Observar solo la condición definida | Condición no cumplida o cumplida | Pausar, reiniciar o expirar según regla |
| Comando pendiente | Condición cumplida | Enviar identificador con vencimiento | Acuse dentro de la ventana | Descartar y registrar fallo técnico local |
| Señalando | Objeto recibe comando | Ejecutar una secuencia acotada | Señal percibida, silenciada o terminada | Finalizar sin repetición automática |
| Reposo | Señal terminada o ventana expirada | No registrar conducta posterior | Nuevo armado explícito | Reconfigurar si corresponde |

La tabla debe diferenciar dos fallos que actualmente aparecen juntos: **fallo de concepto/percepción** —la persona no sabe qué representa la señal— y **fallo técnico** —el comando no llegó o llegó tarde—. No se debe intentar resolver un problema de significado agregando reconexión BLE.

## 13. Matriz de decisión: mantener, reemplazar, ampliar o retirar

| Elemento auditado | Acción | Corrección concreta | Prioridad |
| --- | --- | --- | --- |
| Definición breve de Relevo | Mantener | Conservar la triada app–objeto–lugar y añadir qué hace y qué no hace en el primer bloque | P0 |
| Escena inicial | Mantener y ampliar | Presentarla como hipótesis de uso; separar explícitamente ejemplo de evidencia de entrevistas | P0 |
| Problema como intención desplazada | Mantener | Es el núcleo que conecta investigación, teoría y sistema | P0 |
| “Sistema inseparable” | Reemplazar | Diferenciar dependencia técnica app–objeto de dependencia experiencial del lugar; someter esta última a comparación | P0 |
| Persona como componente | Ampliar | Incluirla en arquitectura: formula, sitúa, interpreta y decide | P0 |
| Objeto sin pantalla | Mantener como restricción firme e hipótesis de valor | Justificar por señal no textual y probar su valor sin introducir pantalla | P0 |
| Control de armado/desarmado | Reemplazar | Resolver contradicción entre app, botón y confirmación antes de wireframing | P0 |
| Caso doméstico | Ampliar | Definir un caso mínimo y declarar que el hogar no fue observado sistemáticamente | P0 |
| Lugar | Reemplazar | Nombrarlo como asociación manual; no como ubicación detectada ni garantía de acción | P0 |
| Condición de activación | Reemplazar | Fijar una regla operacional única: evento, ventana, acumulación, reinicio, activación única y vencimiento | P0 |
| Android | Ampliar | Presentarlo como límite del prototipo y documentar razón, versiones, fabricantes y permisos | P0 |
| UsageStatsManager | Mantener con cautela | Tratarlo como fuente técnica a probar, no como disparador en tiempo real ni detector de automatismo | P0 |
| Bluetooth LE | Mantener como alternativa | Probar entrega, reconexión, pantalla apagada, batería y señal tardía antes de fijar arquitectura | P1 |
| Luz, sonido y vibración | Mantener principio | Evaluar canales por detectabilidad, intrusión, privacidad y superficie | P1 |
| Duraciones y pulsos exactos | Retirar del cuerpo principal | Mover a parámetros de prueba; no presentarlos como dirección final | P1 |
| Accesibilidad | Ampliar | Desglosar dimensiones visual, auditiva, táctil, cognitiva, motora y doméstica | P0 |
| Privacidad local | Ampliar y reemplazar lenguaje | Sustituir “no rastrea” por mapa de datos, permisos, retención, eliminación y riesgos | P0 |
| No bloqueo, no puntaje, no cumplimiento | Mantener | Es una decisión coherente con autonomía; probar cómo se percibe, sin tratar feedback como evidencia | P1 |
| P0–P4 | Mantener con reordenamiento | Cada nivel debe responder una pregunta; no mezclar prototipos con producto comercial | P1 |
| Dimensiones, peso, color y materiales | Retirar provisionalmente del cuerpo | Conservar en anexo como hipótesis formal o técnica con pregunta asociada | P1 |
| Componentes electrónicos concretos | Ampliar | Convertir la selección en alternativas condicionadas a consumo, señal y disponibilidad | P1 |
| Autonomía de 30/90 días | Retirar como meta narrativa | Primero medir ciclo, picos, carga y recuperación; luego definir una meta de uso | P1 |
| Lista de materiales de prototipo | Reemplazar parcialmente | Verificar base CLP 51.140–92.640, contingencia del 15 %, redondeo CLP 59.000–107.000 y declarar reposición, fabricación y ensayo | P0 |
| Lista de materiales de serie | Mantener como escenario | Exigir volumen, proveedor, logística, impuestos, certificación y fecha antes de presentarla como factibilidad | P1 |
| Precio CLP 79.990–99.990 | Retirar | No existe aún disposición de pago ni modelo comercial defendible | P0 |
| Mantenimiento y reparación | Ampliar | Añadir carga, batería, vínculo, restablecimiento, actualización, soporte y fin de vida | P1 |
| Rol del diseñador | Mantener y ampliar | Vincular responsabilidades con entregables y colaboraciones; separar la tarifa de la lista de materiales | P1 |
| Comparación con notificación | Reemplazar prioridad | Pasar de contraste secundario a puerta de falsación del valor físico | P0 |
| Flujo de usuario | Ampliar | Añadir precondiciones, estados, errores, reubicación, reposo y decisión fuera del sistema | P0 |
| Flujo técnico | Reemplazar | Separar condición observable, envío, acuse, vencimiento y fallos; no prometer desempeño | P0 |
| Flujo de diseño | Mantener y ampliar | Convertirlo en puertas de decisión ordenadas antes de visualidad y producción | P1 |

## 14. Riesgos críticos y acciones de cierre

| Código | Riesgo | Por qué puede invalidar la propuesta | Acción de cierre |
| --- | --- | --- | --- |
| R-01 | La condición de activación no está definida | Sin regla no hay aplicación evaluable ni flujo técnico verificable | Redactar y probar una única regla operacional |
| R-02 | El objeto sin pantalla se percibe como alarma genérica | El sistema no puede recuperar la intención sin volver al teléfono | Prueba de recuerdo espontáneo y consulta de la app |
| R-03 | El lugar se declara indispensable sin ser detectado | La triada phygital puede ser solo una yuxtaposición conceptual | Comparar ubicación congruente, neutra y notificación |
| R-04 | Android no mantiene el monitoreo o el enlace | La señal puede no llegar o llegar fuera de contexto | Matriz de fabricantes, versiones, permiso, segundo plano y BLE |
| R-05 | Los canales no son perceptibles o afectan convivencia | Una señal no detectada no interviene; una intrusiva contradice autonomía | Prueba por distancia, superficie, habitación y perfil configurable |
| R-06 | “Accesible” se presenta sin evidencia | Invalida una afirmación normativa y oculta exclusiones | Convertir accesibilidad en requisitos y límites verificables |
| R-07 | La privacidad está sobreafirmada | UsageStatsManager implica acceso amplio a actividad del teléfono | Mapa de datos, retención, borrado y comunicación de permisos |
| R-08 | La factibilidad económica parece exacta, pero no lo es | Costos, lista de materiales y precio pueden sostener una conclusión falsa | Mantener base CLP 51.140–92.640, contingencia del 15 %, rango redondeado CLP 59.000–107.000, separar escenarios y retirar precio prematuro |
| R-09 | El objeto se mueve o se desconecta sin recuperación clara | Se rompe la relación entre señal, lugar e intención | Diseñar reubicación, estado de error y rearmado explícito |
| R-10 | La app devuelve al usuario a la misma pantalla que se quiere interrumpir | El mecanismo puede aumentar atención y carga | Probar configuración mínima, señal interpretable y ausencia de consulta posterior |

## 15. Orden recomendado de incorporación

La siguiente secuencia mantiene una sola línea sustantiva y evita desarrollar visualidad antes de cerrar la arquitectura:

1. Reescribir la definición canónica y separar hecho, hipótesis y decisión.
2. Fijar el caso doméstico mínimo y el rol no automático del lugar.
3. Resolver la condición de activación y sus estados límite.
4. Resolver armado, desarmado, silencio, reposo y recuperación sin pantalla.
5. Reescribir la arquitectura Android como hipótesis técnica con matriz de pruebas.
6. Reducir canales a variables de prueba y desglosar accesibilidad y convivencia.
7. Crear el mapa de datos y reemplazar el lenguaje absoluto de privacidad.
8. Corregir y separar prototipo, producción, costo profesional, costo de serie y precio.
9. Añadir mantenimiento y modelo de gestión.
10. Ejecutar primero la prueba de asociación y la comparación con notificación; solo después cerrar forma, wireframes y especificaciones de producción.

El siguiente paso sustantivo único es el punto 3: **definir la condición operacional mínima y sus estados de error**. Mientras esa decisión permanezca abierta, cualquier refinamiento de la forma o del precio sería prematuro.

## Registro de cambios (disclaimer)

### 2026-08-24 — Creación del informe de Auditoría 5

- **Cambio:** se creó este informe con una auditoría específica de la propuesta phygital, el objeto sin pantalla, la relación entre aplicación–objeto–lugar–persona, el contexto doméstico, la condición de activación, Android, canales, accesibilidad, privacidad, producción, costos, mantenimiento, modelo de gestión, rol del diseñador y flujos.
- **Versión anterior:** no existía un informe separado que examinara estas dimensiones como sistema de Proyecto de Título. Los elementos estaban distribuidos entre `08_memoria/memoria-vigente.md`, `05_propuesta_phygital` y `06_desarrollo_y_factibilidad`.
- **Motivo:** distinguir decisiones defendibles de especificaciones prematuras y señalar los pendientes que pueden cambiar la arquitectura antes de avanzar a wireframes o desarrollo visual.
- **Alcance:** auditoría documental y de coherencia interna; no constituye evidencia de usuarios, prueba técnica, cotización, validación de accesibilidad, certificación, estudio de disposición de pago ni evaluación de desempeño.
- **Restricciones respetadas:** no se modificó `memoria-vigente.md`; no se inventaron resultados ni preferencias; el objeto se trató como sin pantalla; el feedback docente se trató como orientación y no como evidencia empírica; no se realizó commit ni push.
- **Siguiente efecto esperado:** el modelo principal debe decidir si acepta la arquitectura mínima y cerrar la condición operacional antes de incorporar correcciones en la memoria vigente.

### 2026-08-24 — Corrección aritmética y de alcance físico

- **Versión anterior:** la auditoría afirmaba una inconsistencia y calculaba un máximo aproximado de CLP 112.000 a partir de una suma que no correspondía a la base trazable de la lista de materiales. También describía la ausencia de pantalla como decisión provisional y dejaba formulaciones que podían hacerla depender de la dirección del testigo transportable.
- **Nueva formulación:** la suma base correcta es CLP 51.140–92.640; con 15 % de contingencia resulta CLP 58.811–106.536 y se comunica, por redondeo, como CLP 59.000–107.000. La ausencia de pantalla es una restricción firme del proyecto. Si falla el testigo transportable, se reformula o reemplaza esa dirección física, manteniendo siempre el carácter phygital y un objeto físico sin pantalla.
- **Motivo:** reconocer y corregir el error de cálculo introducido en la auditoría, evitar una conclusión económica basada en una base incorrecta y alinear la arquitectura física con la restricción firme del proyecto. El rango sigue siendo planificación no cotizada y no valida factibilidad, producción ni precio.
