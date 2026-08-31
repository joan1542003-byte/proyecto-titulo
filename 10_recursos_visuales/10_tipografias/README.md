# Tipografías de trabajo

Esta carpeta conserva las familias tipográficas empleadas por el sistema visual vigente de Relevo. Se incluyen archivos instalables para diseño editorial y archivos web para prototipos digitales.

## Familias

### IBM Plex Sans Variable

Familia principal para títulos, navegación, instrucciones y lectura continua. Se incluyen las variantes romana e itálica en TTF y WOFF2.

- Versión del paquete: `@ibm/plex-sans-variable@0.2.0`.
- Eje de peso variable: permite trabajar con distintos pesos desde un mismo archivo.
- Uso previsto: interfaz Android, memoria, láminas y documentación.

### IBM Plex Mono Variable

Familia complementaria para folios, medidas, estados técnicos y etiquetas breves. No debe utilizarse para párrafos extensos.

- Versión del paquete: `@ibm/plex-mono-variable@1.0.0`.
- Uso previsto: datos, códigos, valores y microetiquetas no críticas.

## Estructura

- `ibm-plex-sans/ttf`: archivos instalables en el sistema operativo.
- `ibm-plex-sans/woff2`: archivos optimizados para prototipos web.
- `ibm-plex-mono/ttf`: archivos instalables en el sistema operativo.
- `ibm-plex-mono/woff2`: archivos optimizados para prototipos web.
- `paquetes-originales`: descargas oficiales completas sin modificar.

Cada familia conserva `license.txt`. IBM Plex se distribuye bajo SIL Open Font License 1.1. Fuente oficial: https://github.com/IBM/plex

## Estado de la decisión

IBM Plex Sans y IBM Plex Mono son las tipografías vigentes de trabajo, no una conclusión perceptiva validada. Antes de cerrar artes finales deben comprobarse legibilidad, reproducción impresa, caracteres españoles, tamaños mínimos y comportamiento con ampliación de texto.

## Registro de cambios

### 2026-08-31 — Incorporación de archivos oficiales

- **Cambio:** se añadieron IBM Plex Sans Variable e IBM Plex Mono Variable en TTF, WOFF2 y paquete ZIP oficial.
- **Versión anterior:** las familias estaban especificadas en la documentación, pero sus archivos no se conservaban dentro del repositorio.
- **Motivo:** asegurar continuidad entre la documentación, el prototipado y la futura producción editorial o digital.
- **Alcance:** la descarga no reemplaza las pruebas tipográficas pendientes ni autoriza a ignorar los términos de la licencia incluida.
