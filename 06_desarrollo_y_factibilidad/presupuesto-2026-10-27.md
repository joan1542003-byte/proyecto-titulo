# Presupuesto de Relevo

> **Para qué:** dar los parámetros cuantitativos de factibilidad que pide la rúbrica y cerrar el subcriterio 8.2 de la [matriz de pase](../01_contexto_y_fuentes/matriz-de-pase-proyecto-titulo.md), que hoy está como no logrado porque la Tabla 9 de la memoria no tiene montos. Es la tarea 5 de [Por hacer](../00_gobernanza/por-hacer.md#5-costos-y-presupuesto).
>
> **Fecha:** 27 de octubre de 2026. Los precios son los publicados por comercios y servicios chilenos en esa fecha, salvo donde se indica otra.

## En breve

El proyecto tiene tres presupuestos distintos, y conviene no mezclarlos:

| Presupuesto | Para qué sirve | Estado |
| --- | --- | --- |
| **Prototipo académico** | Lo que costó llegar a la prueba de 21 días | Estructura lista; los montos pagados los sabe el autor |
| **Piloto de seis hogares** | Lo que costaría la etapa siguiente | **Calculado:** entre 60 500 y 72 900 pesos en materiales |
| **Serie corta** | Lo que costaría fabricar testigos propios | Depende de un modelo que todavía no existe |

El trabajo del autor se valoriza aparte, con una referencia pública: entre 5750 y 8480 pesos por hora.

## 1. Prototipo académico

El prototipo no exigió fabricación: su parte física es un producto terminado, comprado una vez. Por eso la lista es corta.

| Ítem | Valor (CLP) | Fuente y fecha |
| --- | --- | --- |
| Localizador Bluetooth (iTag NEWOTAG-BL), una unidad, con su pila CR2032 | **Por confirmar:** monto pagado y comercio | Publicaciones consultadas el 5 de octubre de 2026: 5930 y 7990 |
| Teléfono Android | **Por confirmar:** propio, prestado o comprado | — |
| Servicio remoto de datos (Supabase) | **Por confirmar:** plan y monto | El plan gratuito no tiene costo; el siguiente parte en 25 dólares al mes (Supabase, s. f.) |
| Herramientas de inteligencia artificial | **Por confirmar:** suscripciones y monto | — |
| Placas micro:bit V2 y XIAO nRF52840 | No adquiridas | 24 990 y 16 590 el 7 de septiembre de 2026; la primera, 22 990 el 11 de octubre |
| **Total desembolsado** | **Por confirmar** | — |

**Lo que falta es solo del autor:** cuánto pagó por el llavero y dónde, si el teléfono es propio, qué plan de Supabase usa y qué suscripciones de inteligencia artificial pagó en el período. Con esos cuatro datos la tabla queda cerrada.

**Lo que no cuesta dinero y conviene decir:** la aplicación se distribuye como archivo instalable, fuera de la tienda, así que no hubo cuenta de publicación; el plan gratuito de Supabase cubre 500 MB de base de datos, 50 000 personas usuarias al mes y 5 GB de tráfico, y pausa los proyectos tras una semana sin actividad (Supabase, s. f.), de modo que la escala de la prueba cabe sin costo.

## 2. Piloto de seis hogares

Esta es la cifra nueva. El piloto necesita un localizador por hogar, una pila de repuesto y una carcasa impresa.

| Ítem | Por unidad (CLP) | Seis unidades (CLP) | Fuente |
| --- | --- | --- | --- |
| Localizador Bluetooth | 5930 a 7990 | 35 580 a 47 940 | Publicaciones del 5 de octubre de 2026 |
| Pila CR2032 de repuesto | 1690 | 10 140 | MCI Electronics, s. f. |
| Carcasa impresa en 3D | unos 2470 | 14 800 | Mínimo por trabajo de Rabbit Hole, s. f. |
| **Total** | **10 100 a 12 150** | **60 500 a 72 900** | — |

Tres cosas explican la cifra:

- **La carcasa casi no cuesta material.** Un rollo de PLA de un kilo vale entre 9690 y 13 890 pesos (TodoToner, s. f.), y una carcasa de este tamaño usa unos gramos: las seis juntas no llegan a 1300 pesos de filamento. Lo que se paga es el trabajo de impresión.
- **Por eso conviene imprimir las seis de una vez.** Un servicio nacional publica un mínimo de 14 800 pesos por trabajo (Rabbit Hole, s. f.). Repartido entre seis, son unos 2470 por carcasa; impresa de a una, cada carcasa costaría el mínimo completo.
- **La primera pila viene incluida** con el localizador. La de repuesto está en la tabla porque el mantenimiento del objeto se reduce a cambiarla, y su duración con la conexión que Relevo mantiene en cada ciclo todavía no se midió.

**Lo que falta para cerrar esta cifra:** el peso real de la carcasa, que se sabrá cuando exista el modelo ([tarea 4](../00_gobernanza/por-hacer.md#4-objeto-propio-la-carcasa-del-tag)), y una cotización del taller que se elija. El valor usado es un mínimo publicado, no una cotización del archivo.

**Lo que no entra aquí:** las horas de revisión especializada en accesibilidad, protección de datos y electrónica que el piloto prevé. Son horas de terceros y hay que cotizarlas.

## 3. Serie corta

Solo se abriría si el piloto alcanza sus umbrales. Hay dos caminos y cuestan muy distinto.

- **Recomendar un localizador compatible y distribuir solo la aplicación.** No hay fabricación ni costo por unidad para el proyecto. A cambio, quedan fuera del diseño el sonido, la forma y el control, y el resultado depende de modelos que cambian entre fabricantes.
- **Fabricar un testigo propio.** Hay que cotizar circuito, carcasa, batería, ensamblaje, ensayos, distribución y soporte, más el informe de ensayo de laboratorio, la declaración de conformidad y el código QR que exige la normativa chilena de equipos de alcance reducido desde febrero de 2026.

Con impresión 3D, el costo por carcasa baja al repartir el mínimo por trabajo entre más unidades; con inyección, el molde es un costo fijo alto que solo se justifica con volumen. Ninguno de los dos se cotiza aquí: ambos necesitan el modelo terminado y una pieza de referencia.

## 4. Trabajo profesional

La memoria no valoriza el trabajo del autor, y conviene hacerlo: la rúbrica pide parámetros cuantitativos, y el trabajo es la mayor parte del costo real del proyecto.

**La referencia.** Quienes se titulan de Diseño en universidades chilenas reciben, en pesos de septiembre de 2025, estos ingresos brutos mensuales (Ministerio de Educación, s. f.):

| Año tras titularse | Ingreso bruto mensual (CLP) | Equivalente por hora (CLP) |
| --- | --- | --- |
| 1.º | 1 035 131 | 5750 |
| 2.º | 1 193 890 | 6630 |
| 3.º | 1 298 863 | 7220 |
| 4.º | 1 450 393 | 8060 |
| 5.º | 1 525 896 | 8480 |

La columna de la derecha divide el ingreso mensual por 180 horas, que es lo que suma al mes una jornada ordinaria de 42 horas semanales, vigente desde el 26 de abril de 2026 por la Ley 21561 (2023).

**Cómo leerla.** Es un ingreso de trabajo dependiente, no un honorario: quien emite boleta debe sumar sus cotizaciones, su retención y los períodos sin proyecto, de modo que un honorario de mercado es más alto. Sirve como piso razonable y verificable, no como tarifa.

**Las horas.** Esta planilla la llena el autor; el repositorio permite acotarla, porque guarda la fecha de cada decisión, cada versión de la aplicación y cada pedido a la inteligencia artificial.

| Actividad | Horas | Valor (CLP) |
| --- | --- | --- |
| Investigación (entrevistas, encuesta, estado del arte) | Por confirmar | — |
| Diseño (identidad, interfaz, objeto, memoria) | Por confirmar | — |
| Programación (aplicación Android y herramientas) | Por confirmar | — |
| Electrónica y pruebas con el objeto | Por confirmar | — |
| **Total** | | |

## 5. Lo que falta

| Qué | Quién | Cuándo |
| --- | --- | --- |
| Montos pagados del prototipo y fuente de financiamiento | El autor | Antes de la entrega |
| Horas por actividad | El autor | Antes de la entrega |
| Peso de la carcasa y cotización del taller | Después del modelo | Tarea 4 |
| Horas de revisión especializada del piloto | Cotizar | Si el piloto se hace |
| Circuito, molde y ensayos de la serie corta | Cotizar | Si la serie corta se justifica |

## Fuentes

Todas se consultaron el 27 de octubre de 2026, salvo las fechadas antes.

- MCI Electronics. (s. f.). *Pila botón CR2032 de lithium para reloj*. https://mcielectronics.cl/shop/product/pila-boton-cr2032-de-lithium-para-reloj-9838/
- Ministerio de Educación. (s. f.). *Estadísticas por carrera: Diseño*. Mi Futuro, Servicio de Información de Educación Superior. https://www.mifuturo.cl/buscador-de-estadisticas-por-carrera/
- Rabbit Hole. (s. f.). *Impresión 3D en Chile: resina SLA y FDM*. https://rabbithole.cl/
- Supabase. (s. f.). *Pricing*. https://supabase.com/pricing
- TodoToner. (s. f.). *Filamentos*. https://www.todotoner.cl/filamentos
- Ley 21561. (2023, 26 de abril). Modifica el Código del Trabajo con el objeto de reducir la jornada laboral. Biblioteca del Congreso Nacional de Chile. https://www.bcn.cl/leychile/navegar?idNorma=1191554
- Precios del localizador y de las placas: [búsqueda de productos terminados](busqueda-productos-terminados-chile-2026-09-11.md) y [versión 2.19 de la aplicación](app-android/version-2.19-llavero-itag-2026-10-05.md).

**Límites.** Los precios de comercio varían y no se pactó ninguno; el mínimo de impresión es de un solo servicio y no reemplaza una cotización; el ingreso de referencia es un promedio nacional por carrera, no una tarifa del autor.

## Registro de cambios (disclaimer)

### 2026-10-27 — Creación

- **Qué cambió:** se escribió el presupuesto con tres niveles —prototipo académico, piloto de seis hogares y serie corta—, el costo por unidad del piloto calculado con precios chilenos del 27 de octubre de 2026, un valor hora de referencia tomado de fuentes públicas y la lista de lo que falta por confirmar o cotizar.
- **Cómo estaba antes:** la Tabla 9 de la memoria tenía la estructura, pero ningún monto, y la matriz de pase marcaba el presupuesto como no logrado.
- **Por qué:** es la tarea 5 de Por hacer, y el autor pidió a la IA elegir una tarea que pudiera hacer sola y hacerla.
