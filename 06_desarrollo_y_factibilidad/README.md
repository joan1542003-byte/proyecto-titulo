# Desarrollo y factibilidad


**Consulta del feedback:** [Luz, sonido y evaluación condicionada de vibración](senal-luz-sonido-y-vibracion.md). Respuesta documental disponible; validación empírica pendiente.

## Propósito

Documentar la capa de desarrollo que puede no aparecer completa en la memoria, pero que determina si Relevo puede producirse, probarse y sostenerse.

## Áreas

- arquitectura Android y detección de condiciones;
- comunicación local entre aplicación y objeto;
- electrónica, energía y seguridad;
- forma, dimensiones, montaje y materiales;
- modalidades de señal y accesibilidad;
- prototipado y plan de fabricación;
- lista de materiales y costos;
- precio, instalación y mantenimiento;
- normativa aplicable;
- privacidad y superficie de datos;
- riesgos técnicos, dependencias y alternativas;
- ventajas, desventajas y límites del producto;
- rol del diseñador y colaboraciones necesarias.

## Regla de factibilidad

Una cifra o componente no se considerará vigente sin fecha, proveedor o fuente técnica y condiciones de cálculo. Los costos de prototipo, producción y precio de venta deben permanecer separados.

## Documentación vigente

- [Aplicación Android 2.6](app-android/README.md): prototipo ejecutable vigente. Permite preparar un relevo con una o varias apps bajo un límite común y emitir un tono por un parlante Bluetooth o por el teléfono. Compila y pasa sus pruebas unitarias; falta probarlo en equipos reales. Incluye su [registro de licencias](app-android/licencias/README.md).
- [Energía, autonomía y viabilidad portátil del Atom Echo](energia-autonomia-atom-echo-2026-09-23.md): detalla alimentación USB, incompatibilidad directa de la base A151, cálculo ilustrativo de autonomía y límites para un producto final compacto.
- [Compra económica de un objeto sonoro Wi-Fi](recomendacion-compra-sonido-wifi-chile-2026-09-23.md): compara costo puesto en Chile, discrepancias de publicaciones y requisitos antes de elegir Atom Echo u otra opción.
- [Comparación BLE, Wi-Fi y Supabase para el objeto](comparacion-ble-wifi-supabase-dispositivo-2026-09-23.md): distingue orden local y remota, confirma que micro:bit no tiene Wi-Fi y evalúa latencia, conexión, seguridad y límites del test.
- [Exploración de dispositivos sonoros comprables en Chile](exploracion-dispositivos-sonoros-chile-2026-09-23.md): compara kits y objetos programables, precio base, alimentación, alcance y trabajo de integración pendiente.
- [Compra para el testeo sonoro en Chile](compra-para-testeo-audio-chile-2026-09-23.md): productos con precio y disponibilidad visibles, condición del teléfono y límites antes de comprar.
- [Enrutamiento del audio a un parlante reservado para Relevo](enrutamiento-audio-parlante-exclusivo-2026-09-23.md): distingue la pista propia de la salida de otras apps y compara parlante multimedia, ajuste Samsung y orden BLE; sin ensayo físico todavía.
- [Plan de desarrollo de la aplicación Android para prueba](plan-app-android-prueba-2026-09-22.md): fija el alcance ejecutable, la arquitectura, el recorrido, los criterios de aceptación y la entrega prevista para el 22 de septiembre de 2026.
- [Búsqueda de productos terminados disponibles en Chile](busqueda-productos-terminados-chile-2026-09-11.md) (antecedente del 11 de septiembre; los iTag no se compraron): contrasta iTag y parlantes compactos con control desde una aplicación propia; recomienda comprar dos muestras iTag y someterlas a una prueba GATT antes de recurrir a una placa de desarrollo.
- [Estudio de un testigo compacto con luz y sonido](estudio-dispositivo-compacto-luz-sonido-2026-09-07.md): compara referentes comerciales y cuatro arquitecturas; conserva XIAO como integración posterior si la prueba con productos terminados demuestra que hace falta construir un objeto propio.
- [Plataformas físicas existentes y modificables](plataformas-existentes-modificables-2026-09-07.md) (antecedente del 7 de septiembre): sitúa dos iTag clásicos como primera puerta, micro:bit como respaldo y XIAO como posible integración posterior; incorpora BleenyButton como antecedente abierto de carcasa, batería y montaje.
- [Prueba Android–BLE con micro:bit V2](prueba-microbit-ble/README.md): contiene el proyecto MakeCode, una compilación de mesa, el contrato de mensajes y la conexión mínima de una luz cálida externa anterior a participantes.
- [Decisión de plataforma inicial: Android](decision-plataforma-android.md): comparación técnica y metodológica con web e iPhone, fuentes oficiales, límites y consecuencias para el prototipo.
- [Especificación y puerta técnica de fase A](../07_validacion/especificacion-materiales-fase-a.md): conecta la plataforma vigente con comprobaciones de BLE, luz, sonido, control y seguridad anteriores a participantes.

## Antecedentes de mesa del 30 de agosto

Estos documentos conservan exploraciones, cálculos y riesgos útiles, pero dejaron de gobernar la siguiente construcción cuando se adoptó la secuencia D-047. No deben utilizarse como lista de compra ni como requisito de la fase A vigente.

El conjunto y su relación con la ruta actual se explican en el [índice de desarrollo físico anterior](../99_archivo/antiguo/desarrollo-fisico/README.md).

- [Montaje luminoso de 12 V](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/montaje-luminoso-12v.md) y su [firmware provisional](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/firmware-12v/README.md).
- [Comparación de arquitecturas de mesa](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/alternativas-arquitectura-fisica.md).
- [Esquema B1 con XIAO ESP32-C3 y anillo](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/esquema-b1-xiao-anillo-5v.md).
- [Esquema B2 con luz cálida](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/esquema-b2-xiao-luz-calida-5v.md).
- [Lista de materiales B1/B2](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/lista-materiales-b1-b2.md).
- [Esquema funcional de conexión de 12 V](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/esquema-conexion-12v.md).

---

## Registro de cambios

### 2026-09-25 — Aplicación Android en el índice vigente

- **Cambio:** la documentación vigente comienza con la aplicación Android 2.6 y su registro de licencias; las búsquedas de iTag y plataformas quedan marcadas como antecedentes.
- **Versión anterior:** el índice no enlazaba la app construida y presentaba dos iTag como primera puerta física, aunque nunca se compraron.
- **Motivo:** que la entrada del área corresponda al prototipo que existe.

### 2026-09-23 — Energía y autonomía del Atom Echo

- **Cambio:** se añadió el análisis de carga, bases oficiales, capacidad y volumen del conjunto completo.
- **Antes:** el Atom Echo figuraba como candidato compacto sin detallar que la base A151 requiere cortar G33 y que 200 mAh no permiten prometer una jornada.
- **Motivo:** responder si la compra sirve como objeto recargable de uso prolongado o como producto final.
- **Alcance:** documentación técnica y cálculo ilustrativo; sin compra ni medición de autonomía.

### 2026-09-23 — Recomendación de compra con costo real

- **Cambio:** se añadió una comparación centrada en una sola compra económica, con impuestos estimados visibles y la inconsistencia de dos publicaciones internacionales.
- **Antes:** el índice ofrecía alternativas técnicas y precios base, pero no una regla para evitar confundir precio del componente con costo entregado.
- **Motivo:** cuidar el presupuesto del test y distinguir un objeto armado de un kit de mesa.
- **Alcance:** investigación de fuentes comerciales y técnicas; sin compra, integración ni ensayo físico.

### 2026-09-23 — BLE frente a Wi-Fi y Supabase

- **Cambio:** se enlazó la comparación de comunicación local y remota para activar un objeto programable.
- **Antes:** el índice reunía las opciones de compra, pero no respondía cómo podría llegar una orden desde Supabase a un dispositivo Wi-Fi.
- **Motivo:** distinguir el funcionamiento actual de la app de una arquitectura remota futura y hacer explícitas sus dependencias.
- **Alcance:** documentación y fuentes oficiales; sin cambios de software o base de datos.

### 2026-09-23 — Compra condicionada para el testeo sonoro

- **Cambio:** se enlazó la comparación de JBL Go 4 y micro:bit V2.2 con stock visible en Chile.
- **Antes:** el índice explicaba arquitecturas y enrutamiento, pero no indicaba qué compra concreta depende del teléfono y del tipo de prueba.
- **Motivo:** mantener trazable la recomendación económica sin confundir un parlante multimedia con un objeto BLE.
- **Alcance:** documentación de mercado fechada; no se compró ni probó ningún producto.

### 2026-09-23 — Enrutamiento exclusivo del sonido

- **Cambio:** se enlazó el análisis de las condiciones necesarias para que solo Relevo emita una señal en el objeto.
- **Antes:** el índice reunía rutas de desarrollo, pero no distinguía audio multimedia del teléfono y órdenes BLE de control.
- **Motivo:** hacer localizable la respuesta técnica a la pregunta de uso planteada por el autor.
- **Alcance:** documentación; ninguna app ni dispositivo fue modificado o probado.

### 2026-09-21 — Plan de la primera aplicación Android

- **Cambio:** se añadió el plan ejecutable para producir y verificar un APK de prueba el 22 de septiembre de 2026.
- **Versión anterior:** el índice reunía decisiones de plataforma y desarrollo físico, pero no unía el recorrido de interfaz con una fecha, criterios de aceptación y entregables de software.
- **Motivo:** iniciar la construcción con un alcance verificable y proteger la prueba de dependencias físicas todavía no comprobadas.
- **Alcance:** el APK y sus resultados técnicos permanecen pendientes hasta completar compilación e instalación.

### 2026-09-12 — Ruta física sincronizada

- **Cambio:** las descripciones vigentes distinguen la prueba inmediata con dos iTag, el respaldo micro:bit y la integración posterior con XIAO.
- **Versión anterior:** el índice enlazaba la investigación iTag, pero todavía describía XIAO como siguiente prototipo y la comparación de plataformas no reflejaba su nueva primera puerta.
- **Motivo:** impedir que una lectura breve conduzca a comprar una placa antes de comprobar la alternativa comercial.
- **Alcance:** ningún dispositivo ha sido comprado o aprobado; la prueba de aceptación sigue siendo obligatoria.

### 2026-09-11 — Productos terminados en Chile

- **Cambio:** se añadió la búsqueda de rastreadores y parlantes disponibles en Chile, junto con el protocolo que debe superar un iTag antes de modificar la ruta física.
- **Versión anterior:** el índice conducía directamente a micro:bit y XIAO, sin una puerta previa para comprobar un producto terminado con BLE estándar.
- **Motivo:** priorizar una construcción simple y económica sin depender de ecosistemas cerrados ni asumir compatibilidad por semejanza formal.
- **Alcance:** la ruta iTag es una compra de muestra condicionada; micro:bit permanece como respaldo hasta disponer de resultados físicos.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se añadió acceso directo a la respuesta responsable del feedback.
- **Versión anterior:** La respuesta estaba dispersa o conservaba formulaciones anteriores.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.

### 2026-09-08 — Antecedentes de mesa trasladados

- **Cambio:** los montajes B1, B2 y 12 V, junto con sus esquemas, costos y firmware, se reunieron en `99_archivo/antiguo/desarrollo-fisico`.
- **Versión anterior:** ya estaban declarados como antecedentes, pero seguían mezclados físicamente con la prueba micro:bit y la ruta portátil.
- **Motivo:** evitar compras o construcciones basadas en una arquitectura sustituida y conservar sus aprendizajes como comparación.
- **Alcance:** ningún cálculo fue validado ni eliminado; la ruta vigente continúa sujeta a instalación, ensayo y revisión competente.

### 2026-09-08 — Paquete micro:bit compilado

- **Cambio:** se enlazó el programa MakeCode que recibe `activar`, ejecuta luz y sonido, admite silencio local y distingue el banco con matriz roja de la fuente cálida requerida para participantes.
- **Versión anterior:** la ruta micro:bit estaba descrita, pero no disponía de código, binario trazable ni una corrección de la incompatibilidad cromática.
- **Motivo:** convertir la siguiente puerta en una tarea instalable y evitar que una prueba de transporte BLE se confunda con el material perceptivo de fase A.
- **Alcance:** la compilación terminó sin errores; no existe instalación, medición ni prueba física, y el binario de mesa no habilita participantes.

### 2026-09-08 — Separación entre ruta vigente y antecedentes de mesa

- **Cambio:** el índice conserva como vigentes la prueba con plataforma existente, la integración XIAO y Android; los documentos B1, B2 y 12 V pasan a una sección histórica explícita.
- **Versión anterior:** todos los montajes aparecían juntos bajo documentación vigente y podían interpretarse como pasos simultáneos.
- **Motivo:** mantener accesibles los cálculos sin crear dos rutas operativas incompatibles.
- **Alcance:** ningún antecedente fue eliminado; tampoco se autoriza compra, montaje o energización.

### 2026-09-07 — Plataformas ya fabricadas y precedente de montaje

- **Cambio:** se incorporó una comparación de plataformas que ya integran luz, sonido y conectividad, junto con BleenyButton como antecedente abierto de carcasa, batería y fijación para XIAO.
- **Versión anterior:** el estudio físico partía de módulos y componentes que había que integrar desde cero, sin una distinción clara entre prueba rápida e integración.
- **Motivo:** hacer viable una prueba temprana de la experiencia antes de invertir tiempo en alimentación, electrónica y una carcasa final.
- **Alcance:** micro:bit V2 sirve para una prueba inmediata; Circuit Playground Bluefruit exige confirmar stock; XIAO nRF52840 conserva la ruta de integración posterior y cualquier reutilización del precedente requiere revisar su licencia GPL-3.0.

### 2026-09-07 — Arquitectura portátil recomendada

- **Cambio:** se enlazó el estudio de mercado y factibilidad para un testigo pequeño con luz y sonido.
- **Versión anterior:** las opciones vigentes se concentraban en montajes de mesa de 5 y 12 V y no respondían a una forma transportable comparable en escala con un localizador.
- **Motivo:** reducir volumen, componentes y mano de obra sin intentar miniaturización industrial antes de validar el valor del objeto.
- **Alcance:** la XIAO nRF52840 es la candidata recomendada; dimensiones, batería, volumen, autonomía y fiabilidad Android siguen sujetos a construcción y medición.

### 2026-08-30 — B2 preparada para revisión

- **Cambio:** se enlazó el esquema revisable de la variante cálida no direccionable.
- **Versión anterior:** el directorio disponía de esquema B1 y una descripción de B2, pero no de una especificación eléctrica equivalente.
- **Motivo:** impedir una comparación asimétrica y cerrar cálculos, estados y verificaciones antes de comprar.
- **Alcance:** el documento habilita revisión; no autoriza montaje, energización ni selección de B2.

### 2026-08-30 — Compra de 5 V dividida por puertas

- **Cambio:** se enlazó una lista de materiales ampliada y una ruta de compra que compara el anillo direccionable con una fuente de luz cálida no direccionable.
- **Versión anterior:** el subtotal de 5 V omitía auxiliares y no distinguía el dinero pagado por un paquete del valor de las piezas usadas.
- **Motivo:** comparar arquitecturas con exclusiones visibles y evitar adquirir el conjunto antes de resolver la fuente luminosa.
- **Alcance:** los precios son referencias de abastecimiento; no constituyen costo de producción ni autorización de compra.

### 2026-08-30 — Esquema revisable del núcleo de 5 V

- **Cambio:** se enlazó el esquema funcional de la XIAO ESP32-C3 y se corrigió la candidata genérica por una placa con documentación oficial.
- **Versión anterior:** la alternativa de 5 V todavía no definía distribución, conversión de 3,3 V a 5 V, asignación provisional de señales ni comportamiento de silencio y arranque.
- **Motivo:** convertir la simplificación en una propuesta auditable sin adelantar conexiones aprobadas.
- **Alcance:** no existe compra, montaje, energización ni resultado; la arquitectura de 12 V permanece como respaldo.

### 2026-08-30 — Alternativas físicas de menor complejidad

- **Cambio:** se enlazó una comparación de cinco arquitecturas y una puerta de prueba para un núcleo de 5 V.
- **Versión anterior:** el directorio documentaba la construcción de fase A, pero no una revisión explícita de si podía resolverse con menos piezas y una sola alimentación.
- **Motivo:** evitar comprar o consolidar la arquitectura de 12 V antes de comprobar si una solución más simple conserva la función física situada.
- **Alcance:** la alternativa ESP32-C3 es candidata de prototipo, no arquitectura final ni circuito aprobado.

### 2026-08-30 — Esquema anterior a la construcción

- **Cambio:** se enlazó la tabla de conexiones que distingue relaciones funcionales de terminales todavía no identificados.
- **Versión anterior:** la lista de materiales y la arquitectura no ofrecían un registro único para la revisión electrónica.
- **Motivo:** impedir que fotografías o etiquetas no comprobadas se conviertan en instrucciones de montaje.
- **Alcance:** no se aprobó, conectó ni energizó el circuito.

### 2026-08-30 — Montaje mínimo para fase A

- **Cambio:** se enlazó una configuración provisional construible para producir la señal manual de la primera prueba.
- **Versión anterior:** el directorio enumeraba electrónica, materiales y costos como áreas, pero solo contenía la decisión de plataforma Android.
- **Motivo:** desbloquear el ensayo técnico sin confundir su montaje con la arquitectura final de Relevo.
- **Alcance:** componentes y precios no comprados; cuerpo, difusor, herramientas, revisión electrónica y envío permanecen fuera del subtotal.

### 2026-08-25 — Plataforma inicial documentada

- **Cambio:** se enlazó la justificación comparativa de Android como única plataforma del primer prototipo técnico integrado.
- **Versión anterior:** el directorio mencionaba arquitectura Android, pero no documentaba por qué se descartaban web e iPhone en esta etapa.
- **Motivo:** separar una decisión de alcance de una afirmación de superioridad o compatibilidad universal.
- **Alcance:** la condición de activación y el desempeño técnico permanecen pendientes de implementación y pruebas Android.

### 2026-08-23 — Creación

- **Cambio:** definición del alcance de desarrollo, producción y costos.
- **Versión anterior:** la factibilidad aparecía principalmente como anexos de una versión de la memoria.
- **Motivo:** permitir profundizar y actualizar cada decisión sin depender del capítulo editorial.
