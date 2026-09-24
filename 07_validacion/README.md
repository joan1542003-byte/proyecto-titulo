# Validación

**Entrega para la corrección del 23 de septiembre de 2026:** [índice de ocho hojas independientes](entrega-23-09-2026/README.md), con un Word A4 y una fuente Markdown por hoja. Es una copia fechada para revisión, no el consentimiento vigente: conserva un contacto en blanco y un plazo anterior. El paquete único previo permanece en el archivo histórico.

**Instrumentos preparados para revisión:** [pauta del prototipo Android 2.5](pauta-testeo-prototipo-android-2026-09-23.md), [ficha individual en blanco](ficha-testeo-prototipo-android-2026-09-23.md) y [borrador de consentimiento Android](consentimiento-android-vigente-2026-09-23.md). El contacto y el plazo ya están indicados, pero antes de emplearlos con participantes hay que comprobar la gestión y eliminación de datos y probar el [APK vigente](../06_desarrollo_y_factibilidad/app-android/README.md) con el teléfono y parlante concretos. El Protocolo 01 de luz y sonido con activación manual sigue siendo una comparación futura; sus condiciones materiales y su consentimiento no describen automáticamente el prototipo Android actual. No se han realizado sesiones con participantes bajo esta pauta.


**Consulta del feedback:** [Qué prototipar, materiales, tiempos y valor](que-prototipar-y-como-validar-el-valor.md). Respuesta documental disponible; validación empírica pendiente.

## Propósito

Comprobar por separado las hipótesis de Relevo y usar los resultados para mantener, modificar o abandonar decisiones.

## Orden de pruebas vigente

1. **Banco técnico:** Android–BLE, patrón, sonido, reconexión y silencio local sin participantes.
2. **Material de fase A:** salida blanca cálida difundida, estabilidad y revisión del conjunto.
3. **Asociación y comprensión:** percepción, atribución, intención y primer paso; autonomía por separado.
4. **Comparación de soporte y lugar:** objeto situado, mismo objeto neutro y notificación Android equivalente, solo si fase A permite avanzar.
5. **Modalidades y forma:** ajustar parámetros y comparar variantes justificadas; vibración solo ante una pregunta concreta de percepción o acceso.
6. **Integración:** condición, Android, electrónica portátil y comportamiento ante fallos.
7. **Uso doméstico:** piloto posterior para estudiar carga y habituación; sin resultados todavía.

## Protocolos planificados

- [Protección de datos del prototipo Android](privacidad-prototipo-android-2026-09-23.md): inventario comprobado en 2.3 y vigente en 2.4, respuesta para la comisión y texto candidato; el correo y la fecha límite ya están indicados, pero falta verificar la eliminación y el canal de contacto antes de participantes.
- [Modelo de datos para evaluar la aplicación](modelo-datos-evaluacion-app-2026-09-22.md): define qué registra el prototipo Android, qué preguntas puede responder y qué inferencias quedan excluidas.
- [Protocolo 01 — Asociación entre intención, señal y lugar](protocolo-01-asociacion-y-comparacion.md): operacionaliza las dos primeras comparaciones y fija reglas de avance, modificación y detención. Todavía no ha sido ejecutado.
- [Consentimiento informado](consentimiento-protocolo-01.md): borrador con fecha máxima de eliminación fijada; correo del responsable y revisión académica pendientes.
- [Ficha de registro](ficha-registro-protocolo-01.md): plantilla que separa observación, interpretación, límites y decisión.
- [Ensayo interno documental](ensayo-interno-protocolo-01-2026-08-27.md): revisión sin participantes de tiempos, contradicciones y dependencias del procedimiento.
- [Especificación mínima de materiales](especificacion-materiales-fase-a.md): define qué debe comprobarse en la plataforma de ensayo antes de involucrar participantes.
- [Ficha de ensayo técnico](ficha-ensayo-tecnico-fase-a.md): plantilla sin datos para registrar conexión, señal, controles, seguridad, incidentes y correcciones.

## Ruta prevista para el protocolo de luz y sonido

1. Acceder a una micro:bit V2 e instalar el [programa Android–BLE compilado](../06_desarrollo_y_factibilidad/prueba-microbit-ble/README.md).
2. Comprobar sin participantes el recorrido Android → Bluetooth de baja energía (BLE) → matriz roja y sonido, junto con la orden `activar`, la reconexión y el silenciamiento local. La matriz solo representa el canal luminoso en este banco técnico.
3. Conectar y revisar una luz blanca cálida externa, preparar una cubierta neutra y comprobar que los indicadores de placa no compiten con la señal. Este material, no la matriz roja, corresponde a la fase A.
4. Ejecutar la [ficha de ensayo técnico](ficha-ensayo-tecnico-fase-a.md). Una falla de conexión o material impide usar la sesión para evaluar comprensión; debe registrarse, corregirse y repetirse. Este trabajo está controlado por la [Issue #11](https://github.com/joan1542003-byte/proyecto-titulo/issues/11) y descrito en el [estudio de plataformas existentes](../06_desarrollo_y_factibilidad/plataformas-existentes-modificables-2026-09-07.md).
5. Incorporar el correo confirmado al consentimiento del Protocolo 01, comprobar que el canal funciona, someter protocolo y materiales a revisión académica y resolver las observaciones antes de reclutar.
6. Aplicar la fase A. Solo si supera sus reglas de decisión se habilita la comparación de la fase B.
7. Integrar después un testigo portátil basado en XIAO nRF52840, si la evidencia justifica continuar. Esta etapa corresponde a la [Issue #10](https://github.com/joan1542003-byte/proyecto-titulo/issues/10), no a la puerta técnica inmediata.

La activación de la fase A sigue siendo manual porque el investigador decide cuándo enviar la orden. El uso de BLE no incorpora todavía detección automática de aplicaciones ni una condición algorítmica. Antes de cada sesión, el enlace y los controles deben superar la verificación indicada en la ficha.

## Antecedentes técnicos, no dependencias activas

Los montajes [B1](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/esquema-b1-xiao-anillo-5v.md), [B2](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/esquema-b2-xiao-luz-calida-5v.md) y [12 V](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/montaje-luminoso-12v.md), junto con su [firmware provisional](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/firmware-12v/README.md), conservan valor como exploraciones de mesa sobre luz, alimentación y control. No es necesario construirlos antes de la prueba con plataforma existente y no representan la arquitectura portátil elegida.

**Estado al 8 de septiembre de 2026:** el programa MakeCode y su binario de mesa están preparados y la compilación terminó sin errores. No existen instalación, montaje cálido, resultados técnicos ni resultados con participantes. Faltan acceso a la plataforma, prueba física, ensayo documentado, contacto del responsable y revisión académica.

## Regla de medición

No se mezclará en una sola métrica:

- recordar la intención;
- iniciar la actividad;
- cambiar de decisión;
- valorar el objeto;
- reducir uso digital.

Recordar no equivale a obedecer. Continuar con el ocio digital puede ser una decisión válida.

## Criterios obligatorios

Cada protocolo debe declarar hipótesis, variable, muestra, procedimiento, indicador, criterio de éxito, criterio de abandono, riesgos y uso previsto del resultado.

---

## Registro de cambios

### 2026-09-23 — Instrumentos 2.5

- **Cambio:** el índice apunta a la pauta sincronizada con Android 2.5.
- **Antes:** indicaba la versión 2.4.
- **Motivo:** evitar la revisión de una versión anterior sin presentar el paquete Word fechado como consentimiento vigente.

### 2026-09-23 — Estado del contacto confirmado

- **Cambio:** se distinguió el correo ya confirmado del trabajo todavía pendiente de verificar su funcionamiento y el borrado de registros; se señaló que el consentimiento del Protocolo 01 aún debe incorporarlo.
- **Antes:** el índice volvía a pedir que se completara el correo para Android, aunque el borrador actual ya lo contiene.
- **Motivo:** evitar una tarea duplicada sin dar por aprobados los procedimientos de privacidad.

### 2026-09-23 — Consentimiento Android diferenciado del paquete fechado

- **Cambio:** se enlazó un borrador actualizado con contacto y plazo confirmados para Android, y el paquete Word del día quedó señalado como copia previa para revisión.
- **Antes:** el índice podía llevar a utilizar una hoja con contacto vacío y fecha de conservación anterior.
- **Motivo:** no aplicar a participantes un consentimiento que contradiga los datos confirmados después de producir el paquete.

### 2026-09-23 — Instrumentos sincronizados con Android 2.4

- **Cambio:** el índice enlaza la pauta y ficha actualizadas para la versión 2.4 y recuerda las condiciones previas al reclutamiento.
- **Antes:** presentaba la pauta como versión 2.2 y la app como 2.3, aunque ambas ya habían sido revisadas.
- **Motivo:** evitar aplicar un instrumento desactualizado o confundir documentación lista para revisión con autorización para testear.

### 2026-09-23 — Revisión de privacidad

- **Cambio:** se enlazó la auditoría documental del tratamiento de datos de la versión 2.3.
- **Antes:** el consentimiento, el modelo de datos y el código remoto debían conciliarse por separado.
- **Motivo:** hacer explícitas las promesas comprobadas y los campos pendientes antes de participantes.
- **Alcance:** no se alteran instrumentos aprobados ni se declara lista la política.

### 2026-09-23 — Distinción entre instrumento 2.2 y aplicación 2.3

- **Cambio:** el índice señala que la pauta y la ficha fueron redactadas para 2.2 y requieren revisión antes de usarlas con la preparación por etapas de 2.3.
- **Antes:** describía esos documentos como instrumentos de la aplicación actual, sin advertir el cambio de versión.
- **Motivo:** evitar que un protocolo fechado se aplique a una interfaz distinta sin actualizar las observaciones y la verificación física.

### 2026-09-23 — Reorganización del paquete de validación

- **Cambio:** se rehizo la jerarquía del DOCX, se separaron las instrucciones por destinatario y se ampliaron los campos de respuesta. La fuente Markdown refleja el mismo contenido y registra las diferencias con la versión anterior.
- **Antes:** el paquete combinaba pauta, indicadores y formularios con párrafos y campos difíciles de recorrer.
- **Motivo:** permitir una lectura rápida durante la corrección y una hoja de uso legible para cada participante.
- **Alcance:** mejora de presentación e instrumentos; no se añaden resultados ni se levantan los pendientes técnicos y de consentimiento.

### 2026-09-22 — Paquete imprimible de la sesión de regreso

- **Cambio:** se enlazaron el DOCX y su fuente Markdown, con pauta, consentimiento y dos hojas idénticas para participantes.
- **Antes:** la pauta y la ficha estaban separadas y no había un paquete listo para revisar e imprimir.
- **Motivo:** facilitar la corrección del 23 de septiembre sin confundir instrumentos preparados con pruebas realizadas.
- **Alcance:** el consentimiento aún requiere completar contacto y verificar la gestión de datos y el equipo físico antes de reclutar.

### 2026-09-22 — Instrumentos para la corrección del prototipo actual

- **Cambio:** se añadieron accesos a la pauta e instrumento individual del APK 2.2 y se separaron de la ruta anterior de luz y sonido.
- **Antes:** el índice presentaba el Protocolo 01 como única ruta de validación y podía confundirse con la app y el parlante actuales.
- **Motivo:** mantener la evaluación vinculada al material realmente construido y distinguir lo preparado de lo ejecutado.
- **Límite:** el ensayo físico, la revisión del consentimiento y la corrección docente continúan pendientes.

### 2026-09-22 — Registro evaluativo de la aplicación

- **Cambio:** se incorporó el modelo de sesiones y eventos del prototipo Android.
- **Versión anterior:** validación describía la prueba física, pero no la información recopilada por la aplicación funcional.
- **Motivo:** distinguir selección, funcionamiento técnico y conducta declarada antes de revisar resultados.
- **Alcance:** la base remota todavía requiere configuración y comprobación con credenciales del proyecto.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se añadió acceso directo a la respuesta responsable del feedback. Se alineó el orden de pruebas con las fases A/B y la puerta técnica vigente.
- **Versión anterior:** había respuestas dispersas, índices incompletos o formulaciones sustituidas.
- **Motivo:** mantener una respuesta localizable y coherente con las decisiones vigentes.
- **Alcance:** actualización documental; no se añaden resultados ni se cambian los parámetros del protocolo.

### 2026-09-08 — Programa compilado y doble puerta material

- **Cambio:** la ruta comienza con un binario de mesa para matriz roja y separa después la incorporación de una luz cálida externa antes de fase A.
- **Versión anterior:** `programación` figuraba como pendiente general y la plataforma micro:bit podía interpretarse como material perceptivo completo.
- **Motivo:** aprovechar lo integrado para aislar fallos técnicos sin cambiar silenciosamente la señal descrita para participantes.
- **Alcance:** no se ha instalado ni ejecutado el programa; tampoco se ha conectado, difundido o medido la luz cálida.

### 2026-09-08 — Validación alineada con la ruta física vigente

- **Cambio:** se sustituyó la construcción obligatoria de B1/B2 por una secuencia que primero comprueba Android, BLE, luz, sonido y control local en una plataforma existente; la integración con XIAO queda como etapa posterior.
- **Versión anterior:** el índice presentaba B1, B2 y el montaje de 12 V como dependencias operativas de la fase A, aunque el desarrollo ya había elegido una prueba previa con micro:bit V2.
- **Motivo:** separar la pregunta de comprensión del riesgo de fabricar simultáneamente electrónica, alimentación y carcasa, y mantener una sola ruta vigente en el repositorio.
- **Alcance:** no se modificaron la muestra ni las reglas de decisión; tampoco se ejecutaron ensayos ni se habilitó el reclutamiento.

### 2026-08-30 — Esquema B2 incorporado a la puerta técnica

- **Cambio:** se añadieron los esquemas B1 y B2 como evidencia obligatoria anterior al ensayo.
- **Versión anterior:** el índice exigía comparar las variantes, pero no enlazaba sus especificaciones eléctricas.
- **Motivo:** hacer verificable que ambas fuentes luminosas se comparan bajo exigencias equivalentes.
- **Alcance:** no existen revisión electrónica, montaje ni resultados.

### 2026-08-30 — Puerta luminosa anterior al ensayo

- **Cambio:** el índice enlaza B1/B2 y la compra escalonada como dependencia anterior al ensayo, y reclasifica montaje y firmware de 12 V como respaldo.
- **Versión anterior:** validación remitía directamente a construir la configuración de 12 V.
- **Motivo:** mantener un único estado operativo entre desarrollo, gobernanza y validación.
- **Alcance:** el protocolo y sus criterios no cambian; ninguna variante fue construida ni probada.

### 2026-08-30 — Fecha de eliminación fijada

- **Cambio:** el índice distingue la fecha máxima ya resuelta del correo y la revisión que siguen abiertos.
- **Versión anterior:** el consentimiento aparecía como borrador sin mostrar cuál de sus campos administrativos permanecía pendiente.
- **Motivo:** evitar reabrir decisiones cerradas y mantener visible el bloqueo real.
- **Alcance:** el documento no está autorizado para reclutamiento.

### 2026-08-30 — Arquitectura y firmware anteriores al ensayo

- **Cambio:** se enlazaron el montaje provisional y su firmware desde el índice de validación.
- **Versión anterior:** el directorio permitía localizar requisitos y ficha, pero no la configuración elegida para ejecutarlos.
- **Motivo:** conservar una ruta única entre criterio, construcción, código y registro técnico.
- **Alcance:** los documentos preparan la prueba; no contienen resultados ni habilitan participantes.

### 2026-08-30 — Ficha ejecutable del ensayo técnico

- **Cambio:** se enlazó la ficha que operacionaliza las comprobaciones de fase A.
- **Versión anterior:** el directorio definía pruebas y umbrales, pero no ofrecía un registro independiente para cada repetición.
- **Motivo:** asegurar trazabilidad técnica antes de solicitar revisión académica o reclutar.
- **Alcance:** no se ejecutó el ensayo ni se añadieron resultados.

### 2026-08-27 — Material mínimo de fase A

- **Cambio:** se documentaron componentes, comportamiento, repetibilidad, silenciamiento, estabilidad y seguridad del material de prueba.
- **Versión anterior:** el ensayo interno identificaba la necesidad, pero no definía una puerta técnica anterior a participantes.
- **Motivo:** impedir que fallos de construcción se interpreten como fallos de asociación.
- **Alcance:** no se diseñó la forma final ni se registraron resultados técnicos.

### 2026-08-27 — Ensayo interno documental

- **Cambio:** se añadió un recorrido temporal y operativo sin participantes; se corrigieron duración y compatibilidad Android.
- **Versión anterior:** el protocolo podía leerse como listo, aunque la fase B no cabía en el tiempo declarado y carecía de un emisor de notificación.
- **Motivo:** detectar fallos del procedimiento antes de fabricar, reclutar o recoger datos.
- **Alcance:** la fase A necesita ensayo técnico; la fase B permanece bloqueada hasta disponer de una notificación local.

### 2026-08-27 — Parámetros e instrumentos preparados

- **Cambio:** se cerraron los parámetros provisionales y se añadieron consentimiento y ficha de registro.
- **Versión anterior:** el protocolo contenía ocho preguntas abiertas y no tenía instrumentos de aplicación.
- **Motivo:** permitir una revisión piloto completa antes del reclutamiento.
- **Alcance en esa versión:** no se habían recogido datos y contacto, fecha y revisión seguían pendientes. La fecha fue resuelta el 30 de agosto; correo y revisión continúan abiertos.

### 2026-08-27 — Primer protocolo operacional

- **Cambio:** se enlazó el protocolo planificado para asociación básica y comparación de soporte y lugar.
- **Versión anterior:** el directorio definía el orden y los criterios obligatorios, pero no existían puertas de decisión previas a la prueba.
- **Motivo:** evitar interpretar resultados con umbrales definidos después de observarlos.
- **Alcance:** faltan cerrar muestra, tiempos, canal, condición neutra, notificación y gestión de registros antes de ejecutar.

### 2026-08-23 — Creación

- **Cambio:** separación inicial de las hipótesis y resultados de validación.
- **Versión anterior:** distintas pruebas aparecían reunidas dentro de planes generales.
- **Motivo:** evitar atribuir al producto efectos que una prueba no puede demostrar.
