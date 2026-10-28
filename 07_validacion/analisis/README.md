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

## Registro de cambios (disclaimer)

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
