# Fusión de los textos en `main`, 10 de noviembre de 2026

**Fecha:** 10 de noviembre de 2026. **Pedido del autor:** «por ahora sube solo los textos al main, registra qué cambios hiciste. Júntalo, pero por ahora no hagas ni PDF ni nada de eso». **Antes:** `main` estaba en `f34f668` (4 de noviembre, D-154), y el trabajo posterior vivía en ramas sin fusionar, como describe el [estado al 4 de noviembre](estado-del-proyecto-2026-11-04.md).

## Qué entró

Siete ramas de textos, en este orden:

| Rama | Último commit | Commits | Qué trae | PR |
| --- | --- | --- | --- | --- |
| `estado-del-proyecto-2026-11-04` | `5ddebbe` | 2 | El estado al 4 de noviembre: dónde está cada cosa y qué vivía en cada rama. | #20 |
| `anexos-para-word` | `f0c4161` | 13 | Los anexos A a I formales, en Word y PDF, según la pauta de la Biblioteca; las rondas 10 a 13 de la memoria v6, con títulos formales; la verificación de las 107 referencias y la portada de los anexos (D-168 a D-174). | — |
| `claude/funny-bohr-yvmki9` | `1ead8df` | 43 | Las entrevistas a expertos: perfiles, guiones, correos y la ficha de Denis Parra; la evaluación de la v6 como comisión; los criterios del examen; el calendario con la entrega previa del 11 de noviembre. | #19 |
| `tarea-11-pregunta-de-investigacion` | `e6a11de` | 3 | Las tareas 11, 12 y 13 de Por hacer: la pregunta y sus dos partes, lo que había que corregir antes del Pase y el camino a la nota máxima. | #15 |
| `alinear-pregunta-archivos-satelite` | `09a10f1` | 1 | La redacción nueva de la pregunta en los archivos que citaban la anterior. | #16 |
| `fuentes-de-la-memoria` | `74e9133` | 2 | Las fuentes de los capítulos 1 a 6 y la tarea 14. | #18 |
| `decisiones-de-diseno` | `e9e21eb` | 1 | El documento 43: las decisiones de diseño de Relevo, explicadas y verificadas. | #17 |

En total cambian 81 archivos. Las líneas que se borran vienen de las ramas, no de la fusión: casi todas son de los anexos, que la rama `anexos-para-word` rehízo como documento formal (D-168 a D-170).

## Qué quedó fuera

- **`android-4.6`**, la app 4.6.3 a 4.7.2 (D-155 a D-167 y D-175 a D-177), con su código, sus APK y la entrevista de cierre del 9 de noviembre. No es texto de la memoria. Por eso, en `main`, el registro de decisiones salta de D-154 a D-168: las decisiones que faltan están en esa rama.
- **`iconos-propios`**, los íconos propios y los documentos 43 y 44 de esa rama (D-162): 188 archivos, casi todos imágenes.
- **PR #12 y #13**, de septiembre y octubre: cada uno tiene un commit y va más de cien commits atrás de `main`. Lo que proponían quedó reemplazado por la memoria v6 y su versión en 1920 × 1080.

## Cómo se resolvieron los choques

Ningún choque fue de contenido de la memoria. Todos se resolvieron conservando los dos lados:

- **Registro de pedidos:** se conservaron las filas de todas las ramas, ordenadas por fecha, y las entradas de su registro de cambios, de la más nueva a la más antigua. Se quitaron dos filas y una entrada que estaban repetidas, idénticas, en dos ramas.
- **Por hacer:** se conservaron las tareas 11 a 14 y un solo registro de cambios, con las 37 entradas de ambos lados.
- **Traspaso a Claude, índice de la memoria y resumen vigente:** se conservaron las líneas y las entradas de ambos lados.
- **Anexo I:** la rama `alinear-pregunta-archivos-satelite` actualizaba la pregunta en el párrafo anterior a los anexos formales. Quedó la versión formal, que ya tiene la pregunta nueva y no lleva códigos de decisión, como pidió el autor.

## Lo que no se hizo

- **No se generó ningún archivo:** ni el PDF de la memoria, ni el IDML en 1920 × 1080, ni los anexos en Word o PDF. Los que entraron son los que ya estaban en las ramas.
- **No se cambió ningún texto de la memoria ni de los anexos** fuera de lo que traían las ramas.

## Comprobación

- Ningún archivo quedó con marcas de choque.
- Los enlaces relativos de los 81 archivos llevan a archivos que existen, salvo uno que ya estaba roto en `main`: D-147 enlaza `08_memoria/figuras/fuentes/LEEME.md`, que no está en ninguna rama.

## Registro de cambios (disclaimer)

### 2026-11-10 — Creación

- **Qué cambió:** se documenta la fusión de las siete ramas de textos en `main`, lo que quedó fuera y cómo se resolvieron los choques.
- **Cómo estaba antes:** el trabajo desde el 4 de noviembre vivía en ramas sin fusionar.
- **Por qué:** el autor pidió subir los textos a `main` y registrar los cambios.
