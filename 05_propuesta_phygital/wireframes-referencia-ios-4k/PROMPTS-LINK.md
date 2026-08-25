# Registro de generación y auditoría — LINK

## Alcance

Este registro documenta la generación de cuatro láminas visuales para los estados 07–14 del ciclo mínimo de Relevo. Las imágenes son referencias de baja/media fidelidad para calcar y discutir en Figma; no son una interfaz final ni una validación del producto.

**Fecha:** 25 de agosto de 2026  
**Agente:** LINK  
**Herramienta:** built-in `image_gen`  
**Referencia visual obligatoria:** `A2-configuracion-ios-4k.png`  
**Contrato visual consultado:** `STYLE-CONTRACT.md` — no fue modificado.

## Fuentes de decisión

Antes de generar se leyeron de forma completa:

- `08_memoria/memoria-vigente-v2.md`.
- `01_contexto_y_fuentes/encargo-17-requisitos.md`.
- `05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md`.
- `05_propuesta_phygital/wireframes-referencia-ios-4k/STYLE-CONTRACT.md`.
- `05_propuesta_phygital/wireframes-referencia-ios-4k/A2-configuracion-ios-4k.png` como referencia visual.

La lectura mantuvo las siguientes decisiones de la memoria y del Encargo 17:

1. Relevo es un sistema phygital: la aplicación conserva el significado y el testigo físico situado emite un pulso ambiental.
2. El testigo no contiene pantalla, texto, menú, historial ni interfaz de consulta.
3. La aplicación configura, vincula, prueba, informa estados técnicos y permite recuperar el ciclo.
4. El lugar se declara manualmente y la percepción del pulso la confirma la persona.
5. El armado es explícito; no existe armado ni rearme automático.
6. Continuar, ignorar, silenciar, cambiar de intención, desarmar o no armar son salidas válidas.
7. No se representa bloqueo, puntaje, racha, cumplimiento, vigilancia ni inferencia de intención, emoción o percepción.
8. La condición permanece provisional y no se presenta como una detección psicológica.

## Prompt base común

Se utilizó una especificación del tipo `ui-mockup` para una lámina de wireframes de baja/media fidelidad, con estas instrucciones comunes:

> Crear una lámina horizontal 16:9 con dos wireframes móviles verticales, grandes, completos y separados. Usar la referencia `A2-configuracion-ios-4k.png` para la retícula, el fondo cálido `#FCFBF8`, la retícula tenue, las tarjetas agrupadas, los radios suaves, los bordes grises y la jerarquía tipográfica. Crear una composición original inspirada en patrones contemporáneos de iOS, sin imitar una interfaz de Android ni convertirla en UI final. Usar una familia sans serif de sistema equivalente a SF Pro o Inter, blanco, gris cálido y carbón, sin color semántico saturado. Integrar una viñeta lineal del mismo testigo físico compacto y redondeado, sin pantalla, junto a la interfaz móvil. Mantener todos los elementos y conectores dentro de sus marcos, sin barra de estado, barra de navegación Android, botón atrás de Android, menú de tres puntos, logos, fotografías, manos ni marcas.

> Renderizar el texto en español de forma literal, legible y sin texto adicional. Mantener una intención, un primer paso, una condición provisional, una vigencia y un testigo. No bloquear aplicaciones, no puntuar, no registrar cumplimiento, no inferir estados subjetivos y no presentar el pulso como una obligación. Salida esperada: lámina 3840 × 2160 px, 16:9, lista para calcar en Figma.

## Prompts específicos y entregables

### B1a — Vinculación: búsqueda y confirmación

**Archivo final:** `B1a-vinculacion-ios-4k.png`  
**Estados:** 07 Buscando testigo; 08 Confirmar testigo.

Se solicitó una pantalla de búsqueda con la intención `Leer un capítulo`, el primer paso `Abrir el libro`, la condición `Condición provisional · por validar`, y las acciones `Buscar de nuevo` y `Cancelar`. La segunda pantalla debía mostrar `Testigo Relevo`, `Vínculo disponible`, `Batería suficiente para probar`, `Vincular testigo` y `Elegir otro`. La vinculación debía ser manual y explícita.

### B1b — Vinculación: fallo técnico y batería

**Archivo final:** `B1b-vinculacion-ios-4k.png`  
**Estados:** 09 Testigo no reconocido; 10 Batería baja.

Se solicitó la copia `Testigo no reconocido`, `No coincide con este ciclo. Puedes buscar de nuevo o cancelar.`, `Sin confirmación`, `Vínculo no disponible`, `Buscar de nuevo` y `Cancelar`. Para batería se solicitó `Batería baja`, `El testigo puede no completar la prueba o el ciclo.`, `Carga insuficiente para continuar`, `Cargar testigo` y `Posponer`. El fallo debía comunicarse como estado técnico, nunca como error de la persona.

### B2a — Prueba: lugar y percepción declarada

**Archivo final:** `B2a-prueba-ios-4k.png`  
**Estados:** 11 Probar lugar; 12 Señal no percibida.

Se solicitó la relación visual entre un testigo redondeado y un libro como primer paso. La copia central fue `Sitúa el testigo junto al primer paso.`, `Intención · Leer un capítulo`, `Primer paso · Abrir el libro`, `Lugar declarado manualmente`, `Pulso de prueba`, `Emitir pulso` y `Ajustar lugar`. Para el estado de percepción se solicitó `Tú decides si el pulso es reconocible.`, `Resultado declarado por ti`, `Ajustar señal`, `Cambiar lugar`, `Probar de nuevo` y `No armar`.

La primera generación de esta lámina fue descartada durante la auditoría porque utilizaba un testigo cilíndrico distinto y dejaba conectores visuales prolongándose hacia el borde inferior. Se generó una segunda versión con la silueta redondeada común a las láminas de vinculación y con todos los conectores contenidos dentro de los marcos.

### B2b — Prueba: intrusión y armado explícito

**Archivo final:** `B2b-prueba-ios-4k.png`  
**Estados:** 13 Señal intrusiva; 14 Listo para armar.

Se solicitó `La señal interfiere`, `Ajusta el pulso o cambia el lugar.`, `Resultado declarado por ti`, `Ajustar señal`, `Cambiar lugar`, `Probar de nuevo` y `No armar`. La pantalla de armado conserva `Leer un capítulo`, `Abrir el libro`, `Condición provisional · por validar`, `Vigencia · hoy, 20:00–22:00` y `Testigo situado`. Tras la auditoría conceptual del estado 14, sus acciones finales quedaron como `Continuar al armado`, `Volver a probar` y `Salir sin armar`.

La primera generación mostraba una silueta cilíndrica en ambas pantallas. Se descartó por inconsistencia con B1a, B1b y la versión final de B2a. La versión final repite el testigo compacto redondeado y mantiene las líneas dentro de los marcos.

## Normalización técnica

El built-in `image_gen` entregó las salidas nativas en `1672 × 941 px`. Cada selección final fue ampliada proporcionalmente al lienzo exacto de `3840 × 2160 px` mediante interpolación bicúbica de alta calidad. La proporción se conservó; el ajuste dejó un margen horizontal de dos píxeles integrado al fondo cálido para evitar estirar la imagen.

| Archivo | Dimensión final | Estados | Resultado de auditoría |
| --- | --- | --- | --- |
| `B1a-vinculacion-ios-4k.png` | 3840 × 2160 | 07–08 | Aprobada |
| `B1b-vinculacion-ios-4k.png` | 3840 × 2160 | 09–10 | Aprobada |
| `B2a-prueba-ios-4k.png` | 3840 × 2160 | 11–12 | Aprobada tras segunda generación |
| `B2b-prueba-ios-4k.png` | 3840 × 2160 | 13–14 | Aprobada tras segunda generación |

## Auditoría visual y conceptual

### Composición

- Cada lámina contiene dos wireframes móviles grandes, completos y separados.
- La retícula, el fondo cálido, los radios, las tarjetas y la jerarquía mantienen continuidad con `A2-configuracion-ios-4k.png`.
- La lectura es de baja/media fidelidad: muestra estructura, estados y acciones, pero no pretende ser una interfaz lista para producción.
- Las viñetas del testigo son diagramas físicos, no pantallas adicionales. El objeto se representa sin texto funcional ni superficie de consulta.

### Contenido y flujo

- B1a cubre búsqueda, identificación y confirmación manual del testigo.
- B1b cubre un testigo no reconocido y una batería insuficiente antes de la prueba.
- B2a cubre la declaración manual del lugar, el pulso de prueba y la percepción no confirmada por el sistema.
- B2b cubre la señal declarada como intrusiva y la preparación de un armado manual.
- La intención y el primer paso permanecen consistentes en las cuatro láminas.
- La condición continúa rotulada como provisional y por validar.

### Exclusiones comprobadas

- No hay barras ni controles de Android.
- No hay pantalla, texto, menú, historial ni notificación dentro del testigo.
- No hay bloqueo, puntaje, racha, cumplimiento, vigilancia, inferencia subjetiva ni rearme automático.
- No se afirma que la persona percibió una señal: los estados 12 y 13 se presentan como declaración de la persona.
- No se muestra armado automático ni ubicación automática.
- No hay elementos que desborden los marcos móviles en las versiones finales.

## Archivos no modificados

No se modificaron `STYLE-CONTRACT.md`, `A2-configuracion-ios-4k.png`, la memoria, los requisitos del Encargo 17, el anexo de cobertura ni los archivos de otras series visuales. Las salidas de generación nativas permanecen fuera del repositorio; en el repositorio solo se conservaron las cuatro selecciones finales normalizadas.

## Registro de cambios (disclaimer)

**Archivo nuevo:** `PROMPTS-LINK.md`.

**Qué se incorporó:** fuentes leídas, contrato conceptual, prompt base, prompts específicos de los cuatro estados, decisiones de descarte, normalización a 4K, auditoría visual y límites de uso.

**Versión anterior:** no existía un registro específico de LINK para estas cuatro láminas.

**Motivo:** dejar trazabilidad de cómo se generaron y revisaron las imágenes, sin modificar el contrato visual ni presentar las referencias como una interfaz final o como validación del producto.

**Alcance:** este archivo documenta las imágenes B1a, B1b, B2a y B2b; no reemplaza la matriz del Encargo 17 ni cierra las decisiones técnicas pendientes de la memoria.

### 2026-08-25 — Corrección conceptual del estado 14

- **Archivo afectado:** `B2b-prueba-ios-4k.png`.
- **Antes:** el estado `14 · LISTO PARA ARMAR` mostraba los botones `Armar ciclo` y `Desarmar`.
- **Después:** el botón principal ahora dice `Continuar al armado` y el botón de salida dice `Salir sin armar`.
- **Motivo:** el estado 14 todavía es previo al armado; `Desarmar` corresponde a un ciclo ya activo y confundía la transición del flujo. Las nuevas etiquetas explicitan el paso siguiente y conservan una salida voluntaria antes de armar.
- **Conservado:** se mantuvieron la composición, ilustraciones, tarjetas, jerarquía, escala de grises, formato 3840 × 2160 y todos los demás textos y elementos de la lámina. Se aplicó una corrección focalizada de texto para no regenerar la imagen completa.
