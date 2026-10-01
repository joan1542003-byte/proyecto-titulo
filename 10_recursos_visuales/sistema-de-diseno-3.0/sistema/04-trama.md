# Trama

La trama es una retícula de puntos azules. Tiene dos lecturas que unen las dos partes de Relevo: son los píxeles de la pantalla y también la rejilla perforada del parlante, como la de la radio T3 de Dieter Rams (1958). Por eso aparece donde el teléfono y la casa se tocan: la señal, la foto de lo que espera y el tiempo.

## Construcción

| Medida | Valor | Token |
| --- | --- | --- |
| Distancia entre puntos, pantalla | 6 px | `trama-pitch` |
| Distancia, fotos pequeñas e ícono | 4 px | `trama-pitch-small` |
| Distancia, impresión | 2 mm | `trama-pitch-print` |
| Punto más chico (luces) | 16 % de la distancia | `trama-dot-min` |
| Punto más grande (sombras) | 104 % de la distancia | `trama-dot-max` |
| Punto tenue (sin imagen) | 28 % de la distancia | `trama-dot-faint` |

- **Una sola tinta:** `blue` sobre `paper`, `card` o blanco. En campos de fondo, los puntos van de `blue-dots` (claros) a `blue` (densos).
- **Retícula recta**, sin rotar, como una pantalla.
- **Fotos:** se reduce la foto a un píxel por punto, se mide la oscuridad y el radio crece con ella. Las zonas casi blancas quedan como puntos tenues para que la retícula se vea.

## Usos

1. **La señal.** Cuando suena, la pantalla se llena de trama y los puntos laten (`Trama mode="senal"`). El mensaje va en una tarjeta de vidrio.
2. **La actividad activa.** En Inicio, la foto de la actividad va en trama (`mode="foto"`). Las demás fotos, no.
3. **El tiempo.** `TimeDots`: un punto por minuto en las apps elegidas; «6 de 15» son seis puntos llenos.
4. **Marca.** El ícono de la app con trama, portadas, afiches y la portada de la presentación (`mode="campo"`).

## Íconos en trama

Cada ícono de trazo se puede pasar a una retícula de 12 × 12 o 16 × 16 puntos (`mode="icono"`). Los puntos del renglón quedan en azul. Se usan solo en momentos de marca: el ícono de la app, la señal, los estados vacíos y los afiches. En la interfaz se quedan los de trazo, porque a 24 px los puntos se pierden y un ícono se reconoce mejor cuanto más se parece a lo que representa (Isherwood et al., 2007).

## Reglas

- Todo texto sobre la trama va en una tarjeta (vidrio o sólida). Nunca texto suelto encima.
- No en cada pantalla: en pantallas de datos, ajustes y listas no hay trama.
- No mezclar con otros patrones ni con degradados.
- La animación se detiene fuera de la vista y cuando el sistema pide reducir el movimiento.

## Archivos

El grupo Trama tiene un campo apaisado (`trama-campo.svg`), el fondo de la señal (`trama-senal.svg`), la foto de «leer» en trama, el tiempo «6 de 15» y seis íconos en trama de 16 × 16.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
