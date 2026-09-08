# Compilación de mesa

Este directorio contiene el archivo que puede copiarse a una micro:bit V2 para comprobar el enlace BLE con Android, la secuencia luminosa roja integrada, el tono y el silencio mediante los botones A o B.

| Archivo | Configuración | Estado |
| --- | --- | --- |
| `relevo-prueba-mesa-v0.1.hex` | Matriz integrada; `USE_EXTERNAL_WARM_LIGHT = false` | Compilado sin errores; no instalado ni probado en hardware. |

**SHA-256:** `50FD11A9C8A1C9388D11537B46B79C60596030C4EF741E69C3956D53CB3B4DE0`

El repositorio trata los archivos HEX sin conversión automática de saltos de línea, de modo que la suma se mantenga estable al clonar o descargar el proyecto.

Este binario no reemplaza la variante con luz blanca cálida y no debe utilizarse con participantes. Las instrucciones, fuentes y criterios de prueba están en el [README principal](../README.md).

## Registro de cambios (disclaimer)

### 2026-09-08 — Creación

- **Qué cambió:** se conservó la primera compilación reproducible del programa de mesa y se registraron su configuración y suma de verificación.
- **Cómo era antes:** no existía un archivo HEX para la ruta micro:bit ni un registro que distinguiera compilación de funcionamiento físico.
- **Por qué:** permitir la instalación directa sin presentar el binario como validado.
- **Alcance:** el archivo no ha sido probado en una placa real y utiliza la matriz roja integrada; no habilita la prueba con participantes.
