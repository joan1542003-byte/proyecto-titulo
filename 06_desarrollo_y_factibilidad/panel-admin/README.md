# Panel del testeo de Relevo

**Enlace:** [Panel de Relevo](https://claude.ai/artifact/QMsAiSqpkuivix6FJzh9uM), una página privada en claude.ai. Solo la ven su dueño y las personas a quienes se invite desde el menú Compartir. **Decisiones:** D-096, D-097 y D-109. **Fecha:** 6 de octubre de 2026. **Versión:** 5.

## Diseño

Desde la segunda versión, el panel usa el diseño de la app: el papel de fondo, las tarjetas de esquinas amplias (28 px), la fuente Schibsted Grotesk, las cápsulas, el azul solo para lo que escribe la persona y el vidrio solo en la barra de navegación. No hay textos en mayúsculas. Tiene modo claro y oscuro con los colores de la app. En el teléfono, las pestañas bajan a una barra en cápsula, como en la app.

Los gráficos destacan una serie en azul y dejan el resto en gris, con una sola escala. Los colores se comprobaron en ambos modos: contraste de al menos 3:1 con el fondo y diferencia visible con los tres tipos comunes de daltonismo. Al pasar el puntero o tocar una barra aparecen los valores del día.

## Qué muestra

El panel se ordena en cuatro pestañas:

1. **Ahora.** Cifras del testeo (contando ahora, esperan responder, relevos de hoy, respuestas de las señales, relevos que se activaron solos y participantes con actividad reciente). Debajo, **Para revisar**: quién perdió el permiso de Tiempo de uso, tiene las notificaciones apagadas o la batería con restricción, no envía datos hace más de un día o usa una app anterior a la 2.18. Cada caso trae el botón «Escribirle» con el mensaje listo que lo resuelve. Después, quién está contando o esperando responder, y lo último que llegó (incluye relevos eliminados y campos que faltaron).
2. **Participantes.** Cada persona con su estado, su condición, las señales respondidas y su tiempo de pantalla de hoy. Al tocarla se abre una hoja con:
   - su **uso del teléfono**: un gráfico por día del tiempo de pantalla, separado en sus apps elegidas y el resto, con la marca del día 0 de la prueba, promedios de los últimos 7 días, una tabla día por día y el uso de cada app elegida;
   - las apps que eligió alguna vez y su relevo en curso o el último;
   - sus relevos y sus respuestas;
   - su teléfono y ajustes: modelo, versión de Android y de la app, permisos, activación automática, avisos, apariencia y consentimiento;
   - su perfil, su ruta con el paso actual, sus actividades propias y la prueba (secuencia, día y condición);
   - dónde le faltó completar un campo;
   - los botones «Escribirle» y «Descargar sus datos», que guarda un archivo JSON con todo lo de esa persona en Supabase: participante, estado, relevos, eventos, respuestas, uso diario y mensajes.
3. **Respuestas.** Por condición, si supo qué quería hacer al sonar. También los relevos por día (los que sonaron y los que no), las respuestas a cada señal y las tarjetas semanales, el cierre y las opiniones. Los relevos eliminados aparecen marcados y no se cuentan.
4. **Mensajes.** Formulario con mensajes listos, lista de enviados y a cuántos les llegó y cuántos lo abrieron.

## Resultados y exportar (versión 5)

- **Pestañas:** Ahora, Personas, Resultados, Mensajes y Exportar. Cada cifra de Ahora lleva una línea que explica qué cuenta, y «Cómo leer este panel» define relevo, señal, respondida, condiciones, activación automática y «Para revisar».
- **Resultados:** se puede ver todo o una persona. Seis cifras (relevos, señales, respondidas, comenzó la actividad, supo qué quería hacer y la mediana del tiempo para responder), una tarjeta por condición, barras que comparan A, B y C con el porcentaje y «x de y», el reparto de qué hizo después de la señal, el uso de las apps elegidas 10 minutos antes y después, cómo sonó (salida, activación y final de la señal), los relevos por día y las listas de respuestas. No cuenta los relevos eliminados. Las cifras se calculan en la página con los relevos de Supabase.
- **Colores de las condiciones:** A azul, B naranja y C verde agua, validados para daltonismo en todos los pares y en ambos temas; cada barra lleva su letra y su valor escritos.
- **Exportar:** todo en Excel (una hoja por tabla, el resumen por condición y un diccionario de columnas), CSV por tabla (resumen, relevos, respuestas, eventos, uso de Relevo y uso diario), un respaldo JSON y, aparte, los códigos con nombres. Se puede exportar todo o una persona. Los archivos salen sin `user_id` ni nombres, con horas de Chile; los CSV usan punto y coma y UTF-8 para Excel. El Excel se arma con SheetJS 0.18.5, que se carga desde cdnjs solo al pedirlo. Cada descarga pide confirmación en claude.ai.

## Mensajes listos

Sirven para coordinar. Ninguno recuerda la actividad ni anuncia la señal, como pide el protocolo 02. Al tocarlos llenan el título y el mensaje, que se pueden editar antes de enviar; si ya había texto escrito, se puede deshacer.

| Momento | Botón | Título | Mensaje |
| --- | --- | --- | --- |
| Al empezar | Bienvenida | Gracias por participar | Ya empezó tu prueba de Relevo. Si algo falla o tienes dudas, escríbeme por el medio que acordamos. Puedes dejar la prueba cuando quieras, sin dar explicaciones. |
| Al empezar | Semana nueva | Empieza una semana nueva | Abre Relevo: en Inicio verás dónde sonará el aviso esta semana. Lo demás sigue igual. |
| Durante la prueba | Tarjeta semanal | Tu tarjeta de la semana | En Inicio tienes una tarjeta con tres preguntas de 1 a 5 y un comentario opcional sobre esta semana. Toma un minuto y puedes omitir lo que quieras. |
| Durante la prueba | ¿Todo bien? | ¿Cómo va Relevo? | ¿Te ha funcionado bien la app? Si algo falló o te molestó, cuéntame por el medio que acordamos. Si todo va bien, no hace falta responder. |
| Durante la prueba | Activación automática | Sobre la activación automática | Si la activación automática te molesta, puedes apagarla en Inicio con «Apagar». Los relevos que actives a mano siguen igual. |
| Problemas técnicos | Parlante | Revisa el parlante | Revisa que el parlante tenga batería, esté encendido y conectado al teléfono. Si no se conecta, escríbeme y lo vemos. |
| Problemas técnicos | Sin datos | No han llegado datos de Relevo | Hace un rato no llegan datos de tu teléfono. Abre Relevo un momento con internet para que se envíen. Si ves un aviso, síguelo; si no, escríbeme. |
| Problemas técnicos | Permiso de Tiempo de uso | Relevo necesita un permiso | A Relevo le falta el permiso de Tiempo de uso y no puede contar el tiempo en tus apps. Ábrelo y ve a Perfil › Permisos › Tiempo de uso para darlo. |
| Problemas técnicos | Batería | Ajusta la batería de Relevo | Android puede estar deteniendo Relevo para ahorrar batería. Ábrelo y ve a Perfil › Permisos › Batería para dejarlo sin restricción. |
| Problemas técnicos | Versión nueva | Hay una versión nueva de Relevo | Te la envío por el medio que acordamos. Instálala encima de la actual, sin desinstalar, para no perder lo que ya tienes. |
| Al terminar | Conversación final | Coordinemos la conversación final | Terminaste las tres semanas. Me gustaría conversar 15 minutos, en persona o por llamada, sobre cómo te fue. Escríbeme por el medio que acordamos con el día y la hora que te acomoden. |
| Al terminar | Gracias | Gracias por estas tres semanas | La prueba terminó. Si quieres borrar tus datos ahora, hazlo antes de desinstalar: Perfil › Tus datos › Borrar mis datos. Si no, se borran a más tardar el 30 de diciembre de 2026. |

Si una persona tiene las notificaciones apagadas, el mensaje no se ve hasta que abre la app; el panel lo advierte antes de enviar y sugiere escribirle por otro medio.

## Enviar una notificación

Se elige «Todos» o una persona, se escribe un título (hasta 60 caracteres) y el mensaje (hasta 400), o se toca un mensaje listo, y se revisa en una hoja con la vista previa de la notificación antes de enviarla. Con la app 2.17 o posterior, el mensaje llega al instante si Relevo está contando o tiene la activación automática encendida. Si no, llega al abrir la app o en hasta 15 minutos. El panel muestra qué caso corresponde a cada persona. No hay que escribir datos personales.

## Cómo funciona

La página no guarda datos ni claves. Cada 30 segundos consulta Supabase con el conector de Supabase de claude.ai de quien la abre (`execute_sql`). Al abrir a una persona hace otra consulta con sus relevos, respuestas, estado, uso diario y campos faltantes. Al enviar un mensaje, inserta una fila en `relevo_messages`. La descarga pide confirmación a quien la usa antes de guardar el archivo. Quien no tenga ese conector con acceso al proyecto no ve datos.

Los datos llegan al panel cuando los teléfonos los envían: al activar un relevo, cuando suena, al cerrar la app y cada 15 minutos. El estado y el uso diario se envían cada 30 minutos como máximo, desde la app 2.18.

Este archivo, [panel-relevo.html](panel-relevo.html), es una copia del código publicado, para trazabilidad. Para cambiar el panel hay que volver a publicarlo en la misma dirección.

## Límites

- Muestra nombres y el uso del teléfono, porque es solo para el investigador; no se debe compartir con otras personas. Los archivos descargados tampoco se suben al repositorio.
- No es tiempo real exacto: depende de cuándo cada teléfono envía sus datos.
- El estado de cada participante se deduce de lo último que llegó; un teléfono sin conexión puede verse desactualizado.
- Las funciones nuevas se probaron con las consultas reales sobre datos de prueba y con datos de ejemplo en local; los botones de descarga y los mensajes listos no se usaron dentro de claude.ai.

## Registro de cambios (disclaimer)

### 2026-10-06 — Resultados y exportar (versión 5)

- **Qué cambió:** el panel suma la pestaña Resultados, con estadísticas por condición y por persona, y la pestaña Exportar (Excel, CSV y JSON); las cifras de Ahora explican qué cuentan y hay una guía de lectura.
- **Cómo estaba antes:** Respuestas mostraba una barra por condición y las listas; solo se podía descargar el JSON de una persona.
- **Por qué:** el autor pidió rediseñarlo para que se vea mejor, se entienda fácil y tenga estadísticas y exportación.

### 2026-10-05 — Llavero (versión 4)

- **Qué cambió:** el panel reconoce la salida «llavero» de Android 2.19, el evento de silencio con el botón del llavero y los eventos de búsqueda y elección del llavero; la ficha de cada persona dice si eligió un llavero y si le falta el permiso de dispositivos cercanos.
- **Cómo estaba antes:** conocía el parlante, el teléfono y el reloj; un relevo con llavero se habría mostrado como «suena en el teléfono».
- **Por qué:** Android 2.19 agrega el llavero iTag (D-109).

### 2026-09-30 — Uso diario, configuración y mensajes listos (versión 3)

- **Qué cambió:** el panel suma «Para revisar», el uso diario de cada persona con gráfico y tabla, su configuración, perfil y ruta, dónde le faltó completar, la descarga de sus datos y 12 mensajes listos. Los relevos eliminados se marcan y no se cuentan; los gráficos usan azul y gris comprobados en ambos modos.
- **Cómo estaba antes:** la hoja de cada persona mostraba solo sus relevos y respuestas, y los mensajes se escribían desde cero.
- **Por qué:** el autor pidió registrar y tener todo lo de cada participante y mensajes predeterminados para enviar (D-097).

### 2026-09-30 — Diseño de la app y pestañas

- **Qué cambió:** el panel usa el diseño de la app y se ordena en cuatro pestañas (Ahora, Participantes, Respuestas y Mensajes). Suma una hoja por persona, una vista previa antes de enviar y el tiempo de llegada de cada mensaje.
- **Cómo estaba antes:** todo estaba en una sola página con tablas, colores propios y encabezados en mayúsculas.
- **Por qué:** el autor pidió ordenar mejor el panel y diseñarlo como la app.

### 2026-09-30 — Creación

- **Qué se añadió:** el panel privado del testeo y su documentación.
- **Cómo estaba antes:** los datos solo se veían en Supabase, con las vistas del esquema `analisis`.
- **Por qué:** el autor pidió un panel con respuestas, usuarios activos y estadísticas en tiempo real, y poder enviar notificaciones (D-096).
