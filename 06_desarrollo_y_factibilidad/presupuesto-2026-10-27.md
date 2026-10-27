# Presupuesto de Relevo

> **Para qué:** dar los parámetros cuantitativos de factibilidad que pide la rúbrica y cerrar el subcriterio 8.2 de la [matriz de pase](../01_contexto_y_fuentes/matriz-de-pase-proyecto-titulo.md), que hoy está como no logrado porque la Tabla 9 de la memoria no tiene montos. Es la tarea 5 de [Por hacer](../00_gobernanza/por-hacer.md#5-costos-y-presupuesto).
>
> **Fecha:** 27 de octubre de 2026. Los precios son los publicados por comercios y servicios chilenos en esa fecha, salvo donde se indica otra.

## En breve

El proyecto tiene tres presupuestos distintos, y conviene no mezclarlos:

| Presupuesto | Para qué sirve | Estado |
| --- | --- | --- |
| **Prototipo académico** | Lo que costó llegar a la prueba de 21 días | **Cerrado:** unos 182 000 pesos, con financiamiento propio |
| **Piloto de seis hogares** | Lo que costaría la etapa siguiente | **Calculado:** entre 60 500 y 72 900 pesos en materiales |
| **Serie corta** | Lo que costaría fabricar testigos propios | Depende de un modelo que todavía no existe |

El trabajo del autor se valoriza aparte: 114 horas registradas en el repositorio entre el 23 de agosto y el 27 de octubre de 2026, que a valor de referencia equivalen a entre 656 000 y 967 000 pesos.

## 1. Prototipo académico

El prototipo no exigió fabricación: su parte física es un producto terminado, comprado una vez. Por eso la lista es corta.

| Ítem | Valor (CLP) | Fuente y fecha |
| --- | --- | --- |
| Localizador Bluetooth (iTag NEWOTAG-BL), una unidad, con su pila CR2032 | **10 990** | Comprado en MercadoLibre en octubre de 2026: 7990 el producto y 3000 el envío |
| Teléfono Android | **Sin costo** | No se compró: quienes participaron usaron sus propios teléfonos |
| Servicio remoto de datos (Supabase) | **Sin costo** | Plan gratuito, que cubre la escala de la prueba |
| Herramientas de inteligencia artificial | **unos 171 000** | Entre marzo y octubre de 2026: cinco meses de ChatGPT Plus a 19 990 (99 950) y tres de Claude Pro a 20 dólares más impuestos (unos 71 000 al dólar observado del 27 de octubre, 994,29) |
| Placas micro:bit V2 y XIAO nRF52840 | No adquiridas | 24 990 y 16 590 el 7 de septiembre de 2026; la primera, 22 990 el 11 de octubre |
| **Total desembolsado** | **unos 182 000** | Financiamiento propio, con ingresos del trabajo a tiempo parcial del autor |

**La tabla está cerrada.** El autor confirmó los cuatro datos el 27 de octubre de 2026. El único monto aproximado es el de las suscripciones: se calcula con los precios de lista vigentes y, en el caso de Claude, con el dólar observado de ese día, porque los cargos se hicieron entre marzo y octubre a tipos de cambio distintos.

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

**Las horas.** El repositorio registra 114 horas de trabajo entre el 23 de agosto y el 27 de octubre de 2026. Se calculan agrupando las confirmaciones de cambios en sesiones —una sesión termina cuando pasan más de 90 minutos sin actividad— y sumando su duración, más 20 minutos por sesión para el trabajo previo al primer guardado. Cada sesión se atribuye al área donde cambió más archivos.

| Área | Horas | Qué incluye |
| --- | --- | --- |
| Desarrollo y factibilidad | 34 | Aplicación Android, Tag, objeto y estudios técnicos |
| Memoria | 27 | Escritura, anexos y versión A3 |
| Recursos visuales | 20 | Identidad, íconos, color y láminas |
| Gobernanza y administración | 14 | Estado, riesgos, decisiones y registro |
| Validación | 8 | Protocolo, instrumentos y datos de la prueba |
| Propuesta phygital | 5 | Recorrido, estados y especificación |
| Otras | 6 | Índices, herramientas y archivo |
| **Total** | **114** | |

**Qué deja fuera.** Es un piso, no el total: no cuenta el primer semestre —entrevistas, encuesta y seminario—, ni la lectura, las conversaciones con la inteligencia artificial que no terminaron en un cambio guardado, las compilaciones y pruebas en el teléfono, ni las reuniones con los profesores guía. El autor puede sumar esas horas si quiere una cifra completa.

**El valor.** Quienes se titulan de Diseño en universidades chilenas reciben, en pesos de septiembre de 2025, estos ingresos brutos mensuales (Ministerio de Educación, s. f.):

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

**Lo que vale ese trabajo.** Las 114 horas equivalen a 655 500 pesos al valor del primer año tras titularse y a 966 720 al del quinto. No es un desembolso: es el aporte del autor al proyecto, y conviene decirlo junto al total de la Tabla 9, porque es varias veces mayor.

## 5. Lo que falta

| Qué | Quién | Cuándo |
| --- | --- | --- |
| Horas del primer semestre, si se quiere el total completo | El autor | Opcional |
| Peso de la carcasa y cotización del taller | Después del modelo | Tarea 4 |
| Horas de revisión especializada del piloto | Cotizar | Si el piloto se hace |
| Circuito, molde y ensayos de la serie corta | Cotizar | Si la serie corta se justifica |

## Fuentes

Todas se consultaron el 27 de octubre de 2026, salvo las fechadas antes.

- Anthropic. (s. f.). *Planes y precios*. Claude. https://claude.com/es/pricing
- MCI Electronics. (s. f.). *Pila botón CR2032 de lithium para reloj*. https://mcielectronics.cl/shop/product/pila-boton-cr2032-de-lithium-para-reloj-9838/
- Mindicador. (2026). *Dólar observado* [Serie del Banco Central de Chile]. https://mindicador.cl/api/dolar
- Ministerio de Educación. (s. f.). *Estadísticas por carrera: Diseño*. Mi Futuro, Servicio de Información de Educación Superior. https://www.mifuturo.cl/buscador-de-estadisticas-por-carrera/
- OpenAI. (s. f.). *Planes y precios*. ChatGPT. https://chatgpt.com/es-419/pricing/
- Rabbit Hole. (s. f.). *Impresión 3D en Chile: resina SLA y FDM*. https://rabbithole.cl/
- Supabase. (s. f.). *Pricing*. https://supabase.com/pricing
- TodoToner. (s. f.). *Filamentos*. https://www.todotoner.cl/filamentos
- Ley 21561. (2023, 26 de abril). Modifica el Código del Trabajo con el objeto de reducir la jornada laboral. Biblioteca del Congreso Nacional de Chile. https://www.bcn.cl/leychile/navegar?idNorma=1191554
- Precios del localizador y de las placas: [búsqueda de productos terminados](busqueda-productos-terminados-chile-2026-09-11.md) y [versión 2.19 de la aplicación](app-android/version-2.19-llavero-itag-2026-10-05.md).

**Límites.** El monto de las suscripciones usa precios de lista y un tipo de cambio de un solo día, así que es aproximado; los precios de comercio varían y no se pactó ninguno; el mínimo de impresión es de un solo servicio y no reemplaza una cotización; el ingreso de referencia es un promedio nacional por carrera, no una tarifa del autor.

## Registro de cambios (disclaimer)

### 2026-10-27 — Datos del autor

- **Qué cambió:** la Tabla del prototipo académico queda cerrada en unos 182 000 pesos con financiamiento propio, y las horas pasan de una planilla vacía a 114 horas medidas en el repositorio, repartidas por área y valorizadas.
- **Cómo estaba antes:** cuatro montos y las horas estaban por confirmar.
- **Por qué:** el autor entregó los datos y pidió que las horas se estimaran desde el registro del proyecto.

### 2026-10-27 — Creación

- **Qué cambió:** se escribió el presupuesto con tres niveles —prototipo académico, piloto de seis hogares y serie corta—, el costo por unidad del piloto calculado con precios chilenos del 27 de octubre de 2026, un valor hora de referencia tomado de fuentes públicas y la lista de lo que falta por confirmar o cotizar.
- **Cómo estaba antes:** la Tabla 9 de la memoria tenía la estructura, pero ningún monto, y la matriz de pase marcaba el presupuesto como no logrado.
- **Por qué:** es la tarea 5 de Por hacer, y el autor pidió a la IA elegir una tarea que pudiera hacer sola y hacerla.
