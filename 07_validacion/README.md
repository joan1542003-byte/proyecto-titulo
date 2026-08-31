# Validación

## Propósito

Comprobar por separado las hipótesis de Relevo y usar los resultados para mantener, modificar o abandonar decisiones.

## Orden provisional de pruebas

1. **Asociación:** ubicación congruente frente a ubicación neutra.
2. **Comprensión:** recuperación de intención y primer paso sin abrir el teléfono.
3. **Modalidad:** luz, sonido y vibración según contexto y accesibilidad.
4. **Soporte:** objeto físico frente a notificación Android.
5. **Forma:** ubicación, tamaño, montaje y manipulación.
6. **Integración:** aplicación, detección, comunicación y comportamiento ante fallos.
7. **Uso doméstico:** piloto longitudinal breve y efecto de habituación.

## Protocolos planificados

- [Protocolo 01 — Asociación entre intención, señal y lugar](protocolo-01-asociacion-y-comparacion.md): operacionaliza las dos primeras comparaciones y fija reglas de avance, modificación y detención. Todavía no ha sido ejecutado.
- [Consentimiento informado](consentimiento-protocolo-01.md): borrador con fecha máxima de eliminación fijada; correo del responsable y revisión académica pendientes.
- [Ficha de registro](ficha-registro-protocolo-01.md): plantilla que separa observación, interpretación, límites y decisión.
- [Ensayo interno documental](ensayo-interno-protocolo-01-2026-08-27.md): revisión sin participantes de tiempos, contradicciones y dependencias del procedimiento.
- [Especificación mínima de materiales](especificacion-materiales-fase-a.md): requisitos y comprobaciones técnicas previas de la señal manual de fase A.
- [Ficha de ensayo técnico](ficha-ensayo-tecnico-fase-a.md): plantilla sin datos para registrar repeticiones, incidentes, correcciones y la puerta anterior a participantes.
- [Comparación de arquitecturas físicas](../06_desarrollo_y_factibilidad/alternativas-arquitectura-fisica-2026-08-30.md): mantiene la activación cableada, enfrenta B1 y B2 de 5 V y conserva el montaje de 12 V como respaldo.
- [Lista de materiales y compra por puertas](../06_desarrollo_y_factibilidad/lista-materiales-y-compra-escalonada-5v-2026-08-30.md): separa desembolso, reutilización y partidas pendientes antes de construir.
- [Esquema B1 de 5 V](../06_desarrollo_y_factibilidad/esquema-provisional-xiao-esp32c3-5v-2026-08-30.md): relaciones funcionales del anillo direccionable y condiciones anteriores a su revisión.
- [Esquema B2 de 5 V](../06_desarrollo_y_factibilidad/esquema-provisional-xiao-luz-calida-5v-2026-08-30.md): ramas LED, control de potencia, cálculo inicial y criterios de apagado; debe revisarse antes de la comparación luminosa.
- [Montaje de 12 V](../06_desarrollo_y_factibilidad/montaje-minimo-fase-a-2026-08-30.md): arquitectura de respaldo, costos, riesgos y secuencia de construcción si las fuentes pequeñas no cumplen.
- [Firmware provisional de 12 V](../06_desarrollo_y_factibilidad/prototipo-fase-a/README.md): lógica de respaldo preparada para tres pulsos, rechazo de órdenes acumuladas y silenciamiento; aún no compilada ni probada.

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
