# Ilustración y patrones

## Ilustraciones

Seis escenas de 640 × 480, una por categoría (grupo Ilustraciones). Cada una muestra el lugar donde empieza una actividad, con todo listo y sin nadie todavía, y el parlante junto al primer paso.

| Archivo | Categoría | Qué se ve |
| --- | --- | --- |
| `leer-sillon.svg` | Leer | El libro abierto en la mesa lateral, junto al sillón, bajo la luz de la lámpara |
| `crear-mesa.svg` | Crear con las manos | El cuaderno, las acuarelas y los pinceles sobre la mesa |
| `cuidar-ventana.svg` | Cuidar la casa y a mí | Las plantas en la ventana y la regadera llena |
| `moverme-puerta.svg` | Moverme | La puerta, la polera colgada y las zapatillas |
| `compartir-juego.svg` | Con otras personas | El juego de mesa abierto y dos tazas |
| `aprender-escritorio.svg` | Aprender algo | Los apuntes abiertos en el escritorio, bajo la lámpara |

### Reglas de dibujo

- **El comienzo, no el resultado.** La misma regla de las fotos (documento 23): se ve lo que espera y su primer paso, no a alguien haciéndolo.
- **Sin personas.** Sin manos ni rostros: cualquiera puede verse ahí, y no hay cuerpos que elegir.
- **El renglón es el suelo.** Cada escena se apoya en un renglón en cápsula de 9 px del `<familia>-600` de su categoría.
- **Sombras y luces en trama.** Puntos del color de la familia, que crecen con la sombra; la luz de una lámpara es un cono de puntos que se abre.
- **Trazo de los íconos.** Tinta de 3,2 px con extremos redondeados; rellenos planos del 100 al 700 de la familia.
- **El parlante.** Pequeño, con su rejilla de puntos y la banda azul en la base, junto al primer paso.

### Uso

En afiches, presentaciones, la memoria, estados vacíos y piezas de redes. La app sigue usando fotos para las ideas: las ilustraciones no las reemplazan. Una ilustración va sobre el 50 de su familia, que es su propio fondo, o en una tarjeta con esquinas `radius-panel`.

## Patrones

Fondos hechos con los dos recursos de la marca. Nunca llevan texto encima sin una tarjeta.

| Archivo | Qué es | Dónde |
| --- | --- | --- |
| `renglones-azul.svg` | Renglones `azul-500` cada 48 px sobre blanco | Piezas para escribir a mano |
| `renglones-suaves.svg` | Renglones `azul-200` sobre `papel` | Fondos de lectura y de láminas |
| `renglones-noche.svg` | Renglones `azul-300` sobre `tinta` | Fondos oscuros |
| `cuadricula-de-puntos.svg` | Un punto `azul-300` cada 24 px | La trama en reposo: fondos tranquilos |
| `trama-<familia>.svg` | Campo de trama de 12 px, del 200 al 700 de la familia (800 en pizarra), sobre su 50 | Portadas y afiches de una categoría |
| `renglones-de-colores.svg` | El azul y las seis firmas como renglones de largos distintos | Portadas, separadores, la memoria |

### Por qué

- **El renglón vuelve a ser hoja.** Cada 48 px, el alto de una línea de cuaderno a escala de lámina: deja de ser adorno y vuelve a ser un lugar para escribir lo que se quiere hacer.
- **Una función por trama.** La cuadrícula en reposo es fondo; un campo de color anuncia una categoría. Ninguno entra en las pantallas de listas, datos o ajustes de la app.
- **Medio tono.** Como en la trama, el punto crece con la sombra, de 16 % a 104 % del paso.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** sección nueva: reglas de las ilustraciones y de los patrones.
- **Cómo estaba antes:** no había ilustraciones ni patrones.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
