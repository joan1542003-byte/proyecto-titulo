# Ficha de ensayo técnico — material de fase A

**Estado:** plantilla sin ejecutar

**Uso:** comprobar conexión, estabilidad, repetibilidad, control y seguridad antes de trabajar con participantes

**Documento relacionado:** [Especificación mínima de materiales](especificacion-materiales-fase-a.md)

## Regla de uso

Esta ficha registra el desempeño del material, no el de una persona. No contiene nombres, intenciones, preferencias ni observaciones de usuarios. Cada serie se completa con una única versión del montaje. Si se modifica un componente, el patrón o el código de control, debe abrirse una ficha nueva e identificar la versión anterior.

## Identificación del ensayo

| Campo | Registro |
| --- | --- |
| Código del ensayo | ET-A-____ |
| Fecha | ____ / ____ / 2026 |
| Hora de inicio y término | ____ / ____ |
| Responsable | ____ |
| Plataforma y código de unidad | ____ |
| Dispositivo Android y versión del sistema | ____ |
| Aplicación o control y versión | ____ |
| Versión del montaje | ____ |
| Firmware o versión del código | ____ |
| Servicio o perfil BLE utilizado | ____ |
| Fuente de alimentación | ____ |
| Ubicación de fotografías o video técnico | ____ |

## Componentes utilizados

| Componente | Modelo, material o especificación | Función | Cambio respecto de la versión anterior |
| --- | --- | --- | --- |
| Cuerpo estable | ____ | Sostener y situar el material. | ____ |
| Fuente de luz | ____ | Emitir el patrón. | ____ |
| Difusor | ____ | Distribuir la señal. | ____ |
| Fuente sonora | ____ | Emitir un tono breve. | ____ |
| Activación remota | ____ | Recibir órdenes BLE desde Android. | ____ |
| Control de silenciamiento | ____ | Detener la secuencia. | ____ |
| Controlador | ____ | Ejecutar el patrón y volver a reposo. | ____ |
| Alimentación y protección | ____ | Mantener operación estable y segura. | ____ |
| Otro | ____ | ____ | ____ |

## Condiciones de comprobación

| Código | Superficie | Iluminación | Entorno sonoro | Distancia | Observación del entorno |
| --- | --- | --- | --- | ---: | --- |
| C1 | Mesa clara | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 1 m | ____ |
| C2 | Mesa clara | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 2 m | ____ |
| C3 | Mesa clara | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 3 m | ____ |
| C4 | Mesa oscura | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 1 m | ____ |
| C5 | Mesa oscura | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 2 m | ____ |
| C6 | Mesa oscura | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 3 m | ____ |
| C7 | Suelo o mueble bajo | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 1 m | ____ |
| C8 | Suelo o mueble bajo | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 2 m | ____ |
| C9 | Suelo o mueble bajo | ____ (diurna/artificial; lux si se dispone) | ____ (dB si se dispone) | 3 m | ____ |

La iluminación y el entorno sonoro de cada condición se fijan y registran antes de iniciar la serie. El conjunto debe incluir al menos una condición diurna y una artificial cuando ambas estén disponibles. Cambiar la luz o introducir un ruido puntual durante una repetición invalida esa fila.

## Control previo del montaje

- [ ] La fuente comercial de baja tensión y su valor nominal están identificados.
- [ ] No existen conductores expuestos, aislación dañada, conexiones sueltas ni piezas deformadas.
- [ ] El montaje parte apagado y el control físico devuelve el sistema a reposo.
- [ ] La plataforma permanece en reposo al encenderse, enlazarse y reconectarse.
- [ ] Android envía `activar` por BLE a tres metros sin acercarse al material.
- [ ] El control físico de silenciamiento funciona sin depender del enlace.
- [ ] Los indicadores de alimentación o conexión ajenos a la señal están cubiertos, desactivados o fuera del campo visible, y su tratamiento quedó registrado.
- [ ] La luz blanca cálida puede regularse al menos en tres niveles reproducibles.
- [ ] Si se utiliza micro:bit V2, la fuente de fase A es un LED cálido externo revisado; la matriz roja integrada se limita al banco técnico sin participantes.
- [ ] El tono puede regularse al menos en tres niveles reproducibles y no contiene voz.
- [ ] El difusor evita una fuente puntual directa.
- [ ] La cubierta no utiliza los LED para mostrar letras, números, menús ni instrucciones.
- [ ] El comienzo de la señal puede identificarse desde una posición frontal, una oblicua y una lateral en la condición registrada.

Si una casilla no cumple, el ensayo se detiene y la causa se corrige antes de comenzar la sección A. Este control no sustituye una revisión eléctrica competente cuando el montaje requiera intervenir alimentación de red.

## A. Conexión y reconexión BLE

**Criterio:** en cinco ciclos, Android enlaza con la plataforma, esta permanece en reposo y vuelve a aceptar la conexión después de reiniciarse. El tiempo se registra para describir la operación; no se reemplaza por un promedio.

| Repetición | Enlace establecido | Tiempo de enlace | Permanece en reposo | Reconecta tras reinicio | Cumple | Observación |
| ---: | --- | ---: | --- | --- | --- | --- |
| 1 | ☐ | ____ s | ☐ | ☐ | ☐ | ____ |
| 2 | ☐ | ____ s | ☐ | ☐ | ☐ | ____ |
| 3 | ☐ | ____ s | ☐ | ☐ | ☐ | ____ |
| 4 | ☐ | ____ s | ☐ | ☐ | ☐ | ____ |
| 5 | ☐ | ____ s | ☐ | ☐ | ☐ | ____ |

## B. Activación, latencia y patrón

**Criterio:** cada una de las diez órdenes debe producir una sola secuencia, contener tres pulsos separados por dos intervalos apagados y un único tono al comienzo, no presentar disparos dobles y durar 3 s ± 0,3 s. La latencia entre envío y comienzo se registra en cada repetición; una variación que cambie el momento previsto impide continuar hasta corregirla.

| Repetición | Parte desde reposo | Latencia | Pulsos | Intervalos | Tono único | Duración | Sin duplicación | Cumple |
| ---: | --- | ---: | ---: | ---: | --- | ---: | --- | --- |
| 1 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 2 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 3 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 4 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 5 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 6 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 7 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 8 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 9 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |
| 10 | ☐ | ____ s | ____ | ____ | ☐ | ____ s | ☐ | ☐ |

## C. Silenciamiento local

**Criterio:** el control físico detiene la señal en menos de 1 s y no produce una reactivación espontánea. Se realizan diez repeticiones.

| Repetición | Tiempo hasta reposo | No se reactiva | Cumple | Observación |
| ---: | ---: | --- | --- | --- |
| 1 | ____ s | ☐ | ☐ | ____ |
| 2 | ____ s | ☐ | ☐ | ____ |
| 3 | ____ s | ☐ | ☐ | ____ |
| 4 | ____ s | ☐ | ☐ | ____ |
| 5 | ____ s | ☐ | ☐ | ____ |
| 6 | ____ s | ☐ | ☐ | ____ |
| 7 | ____ s | ☐ | ☐ | ____ |
| 8 | ____ s | ☐ | ☐ | ____ |
| 9 | ____ s | ☐ | ☐ | ____ |
| 10 | ____ s | ☐ | ☐ | ____ |

## D. Recuperación de energía

**Criterio:** después de recuperar alimentación, el material permanece en reposo hasta recibir una orden nueva.

| Repetición | Reinicia en reposo | Espera nueva orden | Cumple | Observación |
| ---: | --- | --- | --- | --- |
| 1 | ☐ | ☐ | ☐ | ____ |
| 2 | ☐ | ☐ | ☐ | ____ |
| 3 | ☐ | ☐ | ☐ | ____ |
| 4 | ☐ | ☐ | ☐ | ____ |
| 5 | ☐ | ☐ | ☐ | ____ |

## E. Perceptibilidad instrumental de luz y sonido

**Criterio:** quien ejecuta el ensayo identifica el comienzo luminoso sin mirar directamente la fuente y reconoce el tono en las nueve condiciones registradas. Se utiliza el nivel mínimo reproducible que permita cumplir. Esta comprobación solo verifica que el material puede probarse; no demuestra accesibilidad ni percepción por parte de usuarios.

| Condición | Luz identificada sin mirada directa | Tono identificado | Nivel de luz / sonido | Cumple | Observación |
| --- | --- | --- | --- | --- | --- |
| C1 | ☐ | ☐ | ____ | ☐ | ____ |
| C2 | ☐ | ☐ | ____ | ☐ | ____ |
| C3 | ☐ | ☐ | ____ | ☐ | ____ |
| C4 | ☐ | ☐ | ____ | ☐ | ____ |
| C5 | ☐ | ☐ | ____ | ☐ | ____ |
| C6 | ☐ | ☐ | ____ | ☐ | ____ |
| C7 | ☐ | ☐ | ____ | ☐ | ____ |
| C8 | ☐ | ☐ | ____ | ☐ | ____ |
| C9 | ☐ | ☐ | ____ | ☐ | ____ |

## F. Estabilidad

**Criterio:** el material no vuelca ni se desplaza al accionar el control.

| Superficie | No vuelca | No se desplaza | Cumple | Observación |
| --- | --- | --- | --- | --- |
| Mesa clara | ☐ | ☐ | ☐ | ____ |
| Mesa oscura | ☐ | ☐ | ☐ | ____ |
| Suelo o mueble bajo | ☐ | ☐ | ☐ | ____ |

## G. Operación durante 30 minutos

**Criterio:** no aparece calentamiento perceptible, conductor expuesto, aislación dañada, deformación, olor, parpadeo no programado ni interrupción. Si se dispone de termómetro, se registran temperatura inicial y final en observaciones; cualquier aumento o señal inesperada obliga a revisar el montaje antes de continuar.

| Momento | Alimentación estable | Sin calentamiento perceptible | Sin conductor expuesto ni deformación | Sin comportamiento imprevisto | Observación |
| --- | --- | --- | --- | --- | --- |
| Inicio | ☐ | ☐ | ☐ | ☐ | ____ |
| 10 min | ☐ | ☐ | ☐ | ☐ | ____ |
| 20 min | ☐ | ☐ | ☐ | ☐ | ____ |
| 30 min | ☐ | ☐ | ☐ | ☐ | ____ |

Ante olor, calor, deformación, cable suelto o conducta eléctrica inesperada, se interrumpe la alimentación y el montaje no continúa a revisión con participantes.

## Incidentes y correcciones

| Hora o prueba | Fallo observado | Causa identificada o hipótesis | Corrección realizada | Serie que debe repetirse |
| --- | --- | --- | --- | --- |
| ____ | ____ | ____ | ____ | ____ |
| ____ | ____ | ____ | ____ | ____ |
| ____ | ____ | ____ | ____ | ____ |

## Control de integridad

- [ ] Todas las filas fueron completadas, incluidas las fallidas.
- [ ] No se borraron repeticiones ni se reemplazaron por un promedio.
- [ ] Cada modificación del montaje quedó registrada.
- [ ] Dispositivo Android, control, firmware, plataforma y alimentación están identificados.
- [ ] Se probaron la orden BLE de activación y el silenciamiento físico.
- [ ] Las series afectadas por una modificación se repitieron desde el inicio.
- [ ] Se utilizaron condiciones diurnas y artificiales, o se justificó por qué una no estaba disponible.
- [ ] No se registraron datos personales ni conclusiones sobre usuarios.
- [ ] La evidencia técnica está identificada mediante una ruta o nombre de archivo.

Una fila vacía, interrumpida o sin registro válido cuenta como **no cumplida**. Debe repetirse y conservarse el incidente; mientras permanezca incompleta, bloquea el paso a revisión académica y a participantes.

## Decisión

Marcar una sola alternativa:

- [ ] **Material técnicamente preparado para revisión académica:** todas las comprobaciones y el control de integridad cumplen.
- [ ] **Modificar y repetir:** existe un fallo aislable de conexión, repetibilidad, señal, silenciamiento, estabilidad o alimentación.
- [ ] **Detener el montaje:** exige una intensidad invasiva, presenta un riesgo o no permite una salida física comprensible.

**Fundamento de la decisión:**

____

**Siguiente acción, responsable y fecha:**

____

**Firma o iniciales de quien ejecuta:** ____

Cumplir esta ficha autoriza únicamente a solicitar revisión académica del material y del procedimiento. El trabajo con participantes continúa bloqueado hasta completar el consentimiento, obtener esa revisión y resolver sus observaciones. La ficha no demuestra comprensión, asociación, accesibilidad, preferencia ni valor diferencial de Relevo.

---

## Registro de cambios (disclaimer)

### 2026-09-08 — Control de luz e indicadores en micro:bit

- **Cambio:** el control previo distingue la matriz roja de banco de la luz cálida exigida para fase A y obliga a registrar los indicadores ajenos a la señal.
- **Versión anterior:** la ficha pedía luz cálida, pero no impedía aprobar la matriz integrada ni aclaraba qué significaba reposo cuando la placa mantenía indicadores de estado.
- **Motivo:** comprobar el material que describe el protocolo y evitar que otra luz altere la percepción de los pulsos.
- **Alcance:** las nuevas casillas permanecen vacías; no acreditan montaje, seguridad, visibilidad ni resultados.

### 2026-09-08 — Registro técnico de Android, BLE, luz y sonido

- **Cambio:** la ficha ahora identifica plataforma, Android, control y firmware; añade conexión, reconexión, latencia, sonido y silenciamiento local.
- **Versión anterior:** el instrumento comprobaba un montaje luminoso activado a distancia, pero no permitía distinguir fallos del enlace, del comando o del canal sonoro.
- **Motivo:** la plataforma existente reduce fabricación, pero incorpora dependencias técnicas que deben quedar verificadas antes de interpretar una sesión con participantes.
- **Alcance:** todos los campos permanecen vacíos; no se añadieron resultados ni conclusiones sobre usuarios.

### 2026-08-30 — Comprobación observable del patrón

- **Cambio:** cada repetición debe registrar el número de pulsos y de intervalos apagados, además de la duración total.
- **Versión anterior:** la ficha podía aprobar una secuencia única de tres segundos sin demostrar que contuviera los tres pulsos definidos.
- **Motivo:** hacer comprobable el patrón completo y no solo su inicio y término.
- **Alcance:** se cuentan eventos visibles; la ficha no evalúa todavía la percepción de participantes.

### 2026-08-30 — Correcciones posteriores a auditoría

- **Cambio:** se añadió control previo, se fijó el registro de iluminación, se aclaró que activación y duración comparten diez secuencias, se alinearon los criterios de seguridad y se definió el tratamiento de filas incompletas.
- **Versión anterior:** tres condiciones no declaraban iluminación; algunos requisitos del montaje no tenían comprobación directa y la decisión podía confundirse con autorización para participantes.
- **Motivo:** asegurar reproducibilidad, integridad y separación entre aptitud técnica y autorización metodológica.
- **Alcance:** la ficha continúa vacía y no contiene resultados.

### 2026-08-30 — Creación de la ficha

- **Cambio:** se creó un instrumento para registrar cada repetición, incidente, corrección y decisión del ensayo técnico de fase A.
- **Versión anterior:** la especificación definía pruebas y umbrales, pero no existía una ficha independiente para ejecutarlos sin perder trazabilidad.
- **Motivo:** impedir que el material pase a participantes mediante una impresión general o un resultado no reproducible.
- **Alcance:** plantilla sin resultados; no registra personas ni valida la experiencia de Relevo.
