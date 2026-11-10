# Análisis de la prueba: unir los datos

**Fecha:** 20 de octubre de 2026. **Script:** [unir-datos.js](unir-datos.js), en Node y sin dependencias.

## Para qué sirve

Los datos de la prueba llegan por tres vías. Este script los junta en una sola tabla de relevos y una de respuestas, y hace un resumen por persona con los mismos recuentos que informa la memoria.

1. **Supabase:** la exportación del panel o la de `datos_sensibles/relevo-datos-reales-*.json`, con las tablas `relevo_*`.
2. **Teléfonos sin conexión:** la copia que la app guarda en `Documentos/Relevo` (`relevo-CÓDIGO.json`) o el archivo de Perfil › Tus datos › «Descargar mis datos». Los dos traen el registro completo del estudio.
3. **Papel:** las [fichas de escalas y cierre](../instrumentos/ficha-escalas-y-cierre-2026-10-20.md) y el [instrumento de cierre](../instrumentos/instrumento-de-cierre-2026-10-28.md), transcritos a un CSV con las columnas `participant_code`, `question`, `answer`, `fecha` y `fuente`.
4. **Excel con el formato del panel:** un `.xlsx` con las hojas «Relevos» y «Respuestas», como el que descarga el panel o el que se arma a mano con los datos que entrega cada persona. Las horas sin zona se leen en hora de Chile.

## Cómo se usa

1. Copiar los archivos JSON, CSV o XLSX en `datos_sensibles/`, que Git ignora.
2. Desde esta carpeta, ejecutar:

   ```bash
   node unir-datos.js --solo CÓDIGO1,CÓDIGO2,CÓDIGO3
   ```

   - `--solo` deja fuera los códigos de prueba del autor y del emulador.
   - `--desde AAAA-MM-DD` cambia el inicio. Por defecto toma los relevos desde el 8 de octubre de 2026.
   - `--hasta AAAA-MM-DD` deja fuera lo posterior a ese día, por ejemplo para separar las semanas con el Tag de la semana con el teléfono.
   - Se le puede pasar otra carpeta como primer argumento.
3. El resultado queda en `datos_sensibles/analisis/`:
   - `relevos.csv`: un relevo por fila, con su fuente.
   - `respuestas.csv`: las respuestas de la app y del papel.
   - `resumen.md`: los recuentos por persona.

## Reglas

- **Duplicados:** si un relevo llega por dos vías, por ejemplo Supabase y el teléfono, queda el registro más completo y la fuente se marca como `supabase+telefono`. Una respuesta repetida, con la misma pregunta, respuesta y minuto, se cuenta una vez.
- **Relevos eliminados o editados** antes de sonar (`deleted`) no entran en los recuentos.
- **Fechas:** en hora de Chile. Las del papel, sin hora, se guardan tal cual.
- **Privacidad:** nada de lo que produce el script entra al repositorio. No incluye nombres: la tabla de nombres de Supabase no se lee.

## Verificación

Se probó con la exportación real de Supabase del 13 de octubre, una copia de teléfono inventada con un relevo eliminado y una ficha en papel inventada, en una carpeta temporal:

- reconoce las tres fuentes;
- no cuenta el relevo eliminado;
- respeta las comas y comillas del CSV;
- guarda la fecha del papel sin correrla.

Los recuentos de la persona con datos en Supabase coinciden con los de la memoria al 10 de octubre: 5 relevos con señal; supo qué quería hacer en 4 y a medias en 1, y empezó la actividad en 3.

## Uso del 20 de octubre

Se unieron los datos de las tres personas hasta el 19 de octubre. Para una, se usó una consulta a Supabase; para las otras dos, los Excel que armó el autor con los datos que ellas entregaron. Los recuentos son los que informa la memoria:

- 31 relevos, 24 completados y 23 señales del Tag;
- 21 respuestas: supieron qué hacer en 19 y a medias en 2, y empezaron en 10.

El ciclo que se activó fuera de casa no tiene `signal_at` y no cuenta como señal, aunque tenga respuestas.

## Uso del 10 de noviembre: datos finales

El autor entregó los datos finales de las tres personas, que se guardan solo en `datos_sensibles/final-2026-11-10/`, con el código de cada una en el nombre del archivo. Los tres vienen con el formato del panel: el de la primera persona sale de Supabase, y los de las otras dos, de lo que ellas entregaron. Se unieron con `node unir-datos.js ../../datos_sensibles/final-2026-11-10`. Desde este día, el script también lee los Excel que escriben sus etiquetas con prefijo, como `<x:row>`, que es como venían los dos últimos.

- **Con el Tag, del 8 al 19 de octubre:** los mismos recuentos del 20 de octubre, sin diferencias.
- **Con el teléfono, del 21 de octubre al 8 de noviembre:** 27 relevos, dos eliminados antes de sonar, 24 señales y 21 respuestas. Recordaron cómo empezar y supieron qué querían hacer en las 21; empezaron en 13, lo dejaron para después en 7 y cambiaron de idea en 1. Notaron el aviso enseguida en 11, tarde en 7 y no lo notaron en 3.
- **Encuesta del rediseño, 8 de noviembre:** las tres respondieron que la app nueva era mejor.

El detalle por persona está en la Tabla 4 de la memoria y en la Tabla I6 del Anexo I. El cierre de las tres personas se analiza en el [análisis del cierre de la prueba](analisis-cierre-de-la-prueba-2026-11-10.md). Las respuestas de la etapa con el teléfono se separan por la salida de cada relevo (`signal_route`: `tag` o `phone`).

## Registro de cambios (disclaimer)

### 2026-11-10 — Análisis del cierre

- **Qué cambió:** se enlaza el análisis del cierre de la prueba.
- **Cómo estaba antes:** no había análisis del cierre.
- **Por qué:** el autor entregó los cierres de las tres personas y pidió analizarlos.

### 2026-11-10 — Datos finales

- **Qué cambió:** se registra la unión de los datos finales y el script lee los Excel con etiquetas con prefijo.
- **Cómo estaba antes:** el último uso era el del 20 de octubre, y esos Excel salían vacíos.
- **Por qué:** el autor entregó los datos finales de la prueba.

### 2026-10-28 — Instrumento de cierre

- **Qué cambió:** la fuente en papel incluye el instrumento de cierre.
- **Cómo estaba antes:** nombraba solo la ficha del 20 de octubre.
- **Por qué:** el cierre del 30 de octubre usa ese instrumento (D-144).

### 2026-10-20 — Excel y fecha de término

- **Qué cambió:** el script lee el Excel con el formato del panel y acepta `--hasta`; se suma el uso con las tres personas.
- **Cómo estaba antes:** leía solo JSON y CSV, sin fecha de término.
- **Por qué:** el autor entregó los datos de las dos personas sin conexión.

### 2026-10-20 — Creación

- **Qué se añadió:** un script para unir los datos de Supabase, de los teléfonos sin conexión y de las fichas en papel, con un resumen por persona.
- **Cómo estaba antes:** el panel solo veía Supabase, y los datos de dos personas de la prueba estaban solo en sus teléfonos.
- **Por qué:** el autor aclaró que dos personas no se conectaron y que sus datos se exportarán; hay que sumarlos al análisis.
