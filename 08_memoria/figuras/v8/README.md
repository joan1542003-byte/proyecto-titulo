# Figuras nuevas del borrador v8

**Fecha:** 21 de noviembre de 2026.
**Para qué:** el autor pidió más figuras en la memoria, como las de los anexos, que expliquen de forma simple los sistemas y los métodos complejos. También sirven para la presentación del examen.

## Las siete figuras

| N.º en la v8 | Figura | Dónde va | Archivos |
| --- | --- | --- | --- |
| 6 | Análisis de las entrevistas con el método Framework | Capítulo 7, «Fuentes de información» | [PDF](figura-v8-framework.pdf) · [PNG](figura-v8-framework.png) |
| 13 | Cadena de la formulación, del problema a las conclusiones | Capítulo 10, después de los objetivos | [PDF](figura-v8-formulacion.pdf) · [PNG](figura-v8-formulacion.png) |
| 14 | Método del proyecto, de la investigación a la iteración | Capítulo 10, «Enfoque metodológico» | [PDF](figura-v8-metodo.pdf) · [PNG](figura-v8-metodo.png) |
| 18 | Estados de un relevo | Capítulo 11, «Recorrido del usuario» | [PDF](figura-v8-estados.pdf) · [PNG](figura-v8-estados.png) |
| 26 | Cómo funciona Relevo: la persona, la aplicación y el objeto | Capítulo 12, «Tecnología» | [PDF](figura-v8-sistema.pdf) · [PNG](figura-v8-sistema.png) |
| 30 | Qué se registró en cada relevo | Capítulo 13, «Registro y cuidado de los datos» | [PDF](figura-v8-registro.pdf) · [PNG](figura-v8-registro.png) |
| 34 | Comparación propuesta para la etapa siguiente | Capítulo 14, «Alcances y proyecciones» | [PDF](figura-v8-comparacion.pdf) · [PNG](figura-v8-comparacion.png) |

![Cómo funciona Relevo](figura-v8-sistema.png)

## Cómo están hechas

- **Medidas:** las de la memoria en Affinity. Las hojas miden 1920 × 1080 pt, y cada figura ocupa el ancho del texto, 1742 pt.
- **Estilo:** el de las fichas de la memoria —una ficha blanca con cajas en el color papel—, con Instrument Sans, la paleta de Relevo y los íconos propios de la app 4.7.2 (`../../memoria-1920x1080/marca-e-iconos.json`).
- **Sin título ni nota dentro:** los pone la memoria, en APA 7, como pide el autor para todas las figuras.
- **Archivos:** cada figura tiene su HTML, que es la fuente; un PDF vectorial con el texto vivo, para colocar en Affinity, y un PNG para verla en el repositorio.
- **Datos:** solo los que dicen la memoria y los anexos. La matriz del método Framework muestra la forma del análisis, no respuestas, y la comparación futura es una propuesta.

## Cómo volver a generarlas

En esta carpeta, con Google Chrome instalado:

```bash
python3 construir-figuras.py
```

Con una clave, solo esa figura, por ejemplo `python3 construir-figuras.py sistema`. Las claves son framework, formulacion, metodo, estados, sistema, registro y comparacion.

## Registro de cambios (disclaimer)

### 2026-11-21 — Creación

- **Qué cambió:** se crearon siete figuras nuevas para el borrador v8, con su generador.
- **Cómo estaba antes:** la memoria tenía 27 figuras, casi todas fichas de texto, sin esquemas del sistema ni de los métodos.
- **Por qué:** el autor pidió figuras que ayuden a entender lo complejo, en la memoria y en la presentación.
