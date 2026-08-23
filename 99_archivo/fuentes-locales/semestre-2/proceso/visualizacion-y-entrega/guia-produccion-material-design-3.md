---
id: FL-S2-PROC-VIS-004
titulo: "Guía histórica de producción Material Design 3"
autoria: propia
estado_documental: histórico
familia_documental: "visualización y entrega"
sensibilidad: interna
fuente_sha256: e43564d09b8ba591384065cfdca66494b63ced4b6473458364a4ec0fbbc58bee
duplicado_exacto: false
fuentes_locales_relativas:
  - "SEMESTRE 2/output/Johan Yanten - Encargo 16 - Material 3 - FINAL/05 Fundamentacion y guia/LEEME.md"
metodo_conversion: "copia estructural desde Markdown con correcciones factuales declaradas"
fecha_migracion: 2026-08-23
---

# Guía histórica de producción Material Design 3

## Nota archivística

Este documento registra una iteración de producción o entrega. Sus rótulos internos se conservan por procedencia, pero no deben trasladarse a la memoria final como referencias a un encargo.

U01–U03 son códigos históricos de escenarios o perfiles de uso y permanecen separados de los participantes P1–P8.

Las menciones a herramientas generativas se conservan únicamente como procedencia de recursos visuales. No describen el método de las entrevistas.

## Contenido migrado

# Entrega Encargo 16 — Relevo / Material Design 3

## Carga en Miro

Crear tres grupos: **U01 Activación fuera de casa**, **U02 Actividad personal** y **U03 Hogar compartido**. Dentro de cada grupo, cargar los PNG en orden: Mapa 1, Mapa 2 y Mapa 3. La carpeta `01 Mapas PNG 300dpi para Miro` contiene las nueve imágenes literales, a 4961 × 3508 px (A3 horizontal a 300 dpi); no son ilustraciones ni miniaturas.

Las imágenes de ChatGPT son acompañamiento conceptual. Para U01 usar el contexto de salida; para U02, actividad; y para U03, hogar compartido. Las tres imágenes “lámina” pueden acompañar respectivamente viaje, flujo funcional y flujo técnico, sin sustituir el mapa con texto.

## Impresión

Imprimir los nueve PDF en A3 horizontal, al 100 % y sin “ajustar al área de impresión”. Cada perfil ocupa tres láminas físicas independientes.

## Editar o volver a exportar

El archivo `build_encargo16_material3.py` es la fuente de las nueve láminas. Está preparado para generar PDF, SVG o PNG:

```text
python build_encargo16_material3.py
python build_encargo16_material3.py --formats png,svg --profile U02
python build_encargo16_material3.py --formats png --dpi 300 --png-out "01 Mapas PNG 300dpi para Miro"
```

La documentación de cumplimiento y la decisión de perfiles están en `05 Fundamentación y guía`.

---

## Registro de cambios (disclaimer)

### 2026-08-23 — Migración y clasificación

- **Cambio realizado:** se trasladó una fuente Markdown local a una ruta funcional del archivo histórico.
- **Estado anterior:** el documento estaba organizado por paquete de entrega y no por función, versión o vigencia.
- **Motivo:** conservar el proceso sin convertir una entrega visual anterior en definición actual del proyecto.
- **Duplicación:** no se detectó otra copia exacta dentro de los 21 Markdown auditados.
- **Originales:** ningún archivo local fue editado, movido ni eliminado.
- **Correcciones factuales:** no se detectaron en esta fuente las formulaciones metodológicas o de autoría definidas para sustitución.
- **Criterio de uso:** toda decisión contenida aquí debe contrastarse con la memoria y la investigación activas antes de reutilizarse.
