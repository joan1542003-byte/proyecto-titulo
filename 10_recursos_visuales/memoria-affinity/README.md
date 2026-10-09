# Plantilla de la memoria para Affinity

Archivos de la propuesta D-121. La guía completa, con los ajustes para que Affinity funcione como InDesign, está en el [documento 38](../38_memoria-en-affinity-2026-10-09.md).

## Contenido

| Archivo | Qué es |
| --- | --- |
| [`plantilla-memoria-relevo-a3.idml`](plantilla-memoria-relevo-a3.idml) | Plantilla principal: 40 páginas A3 horizontales con el texto de la memoria vigente al 9 de octubre de 2026. Se abre en Affinity con «Archivo › Abrir». |
| [`plantilla-memoria-relevo-a3-tablas-como-texto.idml`](plantilla-memoria-relevo-a3-tablas-como-texto.idml) | Igual, con las tablas como texto tabulado, por si Affinity no importa bien las tablas. |
| [`plantilla-memoria-relevo-a3-vacia.idml`](plantilla-memoria-relevo-a3-vacia.idml) | Cuatro páginas sin el texto: portada, resumen, índice y una apertura. |
| [`fuentes/`](fuentes/) | Schibsted Grotesk (ocho estilos) e IBM Plex Mono (tres estilos), estáticas, con sus licencias OFL. Instalar antes de abrir la plantilla. |
| [`vistas/`](vistas/) | Páginas de la plantilla importada en Scribus 1.6.1 y exportada a PDF. Sirven para ver la composición; no son una captura de Affinity. |
| [`generar_plantilla_idml.py`](generar_plantilla_idml.py) | Script que crea las tres plantillas desde `08_memoria/memoria-vigente-v4.md`. |

## Volver a generar la plantilla

Cuando la memoria cambie:

```bash
pip install fonttools          # solo para estimar cuántas páginas ocupa cada capítulo
python3 10_recursos_visuales/memoria-affinity/generar_plantilla_idml.py
python3 10_recursos_visuales/memoria-affinity/generar_plantilla_idml.py --tablas-como-texto
python3 10_recursos_visuales/memoria-affinity/generar_plantilla_idml.py --sin-texto
```

El script lee el Markdown hasta «Registro de cambios», asigna un estilo a cada título, párrafo, lista, cita, tabla, nota, referencia y entrada del glosario, y crea un hilo de marcos por capítulo. Medidas, estilos y colores están al principio del archivo.

## Procedencia de las fuentes

- **Schibsted Grotesk:** archivos OTF estáticos del repositorio oficial `schibsted/schibsted-grotesk` (commit `d485f61`, 3 de marzo de 2023). Licencia SIL Open Font License 1.1 ([`OFL-SchibstedGrotesk.txt`](fuentes/OFL-SchibstedGrotesk.txt)).
- **IBM Plex Mono:** archivos TTF del repositorio `google/fonts`. Licencia SIL Open Font License 1.1, con el nombre reservado «Plex» ([`OFL-IBMPlexMono.txt`](fuentes/OFL-IBMPlexMono.txt)).

Ninguna se modificó.

---

## Registro de cambios (disclaimer)

### 2026-10-09 — Creación

- **Qué cambió:** se creó la carpeta con las tres plantillas IDML, las fuentes, las vistas y el script que las genera.
- **Cómo estaba antes:** no existía una plantilla de diagramación de la memoria.
- **Por qué:** el autor pidió dejar Affinity listo para diseñar la memoria.
