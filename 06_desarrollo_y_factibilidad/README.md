# Desarrollo y factibilidad

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

- [Estudio de un testigo compacto con luz y sonido](estudio-dispositivo-compacto-luz-sonido-2026-09-07.md): compara referentes comerciales y cuatro arquitecturas, selecciona un módulo BLE compacto con batería recargable para el siguiente prototipo y explicita costos, riesgos, montaje y pruebas pendientes.
- [Plataformas físicas existentes y modificables](plataformas-existentes-modificables-2026-09-07.md): separa una prueba rápida con una plataforma ya construida de la integración final con XIAO; incorpora BleenyButton como antecedente abierto de carcasa, batería y montaje.
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
