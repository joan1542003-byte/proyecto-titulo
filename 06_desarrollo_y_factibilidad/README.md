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

- [Decisión de plataforma inicial: Android](decision-plataforma-android.md): comparación técnica y metodológica con web e iPhone, fuentes oficiales, límites y consecuencias para el prototipo.
- [Montaje mínimo de fase A](montaje-minimo-fase-a-2026-08-30.md): alternativas de activación, arquitectura cableada seleccionada, lista de materiales con fecha de corte, riesgos y puerta anterior al ensayo técnico.
- [Alternativas para simplificar la arquitectura física](alternativas-arquitectura-fisica-2026-08-30.md): comparación entre el montaje de 12 V, variantes de 5 V y soluciones comerciales o pasivas; propone contrastar dos fuentes luminosas pequeñas antes de sustituir la arquitectura vigente.
- [Esquema provisional del núcleo de 5 V](esquema-provisional-xiao-esp32c3-5v-2026-08-30.md): alimentación, conversión lógica, señales, silencio, arranque y campos exigidos para la revisión electrónica anterior al montaje.
- [Lista de materiales y compra escalonada del núcleo de 5 V](lista-materiales-y-compra-escalonada-5v-2026-08-30.md): compara una luz direccionable y una luz cálida sencilla, separa desembolso y costo atribuible, y condiciona cada compra a una puerta de revisión o prueba.
- [Esquema de conexión provisional](esquema-conexion-provisional-fase-a-2026-08-30.md): tabla funcional, registro de terminales y puertas para revisión antes de energizar.

---

## Registro de cambios

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
