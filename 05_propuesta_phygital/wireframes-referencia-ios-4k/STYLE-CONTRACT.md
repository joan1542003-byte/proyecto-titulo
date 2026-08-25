# STYLE CONTRACT — Wireframes Relevo · iOS 4K

## Propósito

Este contrato fija el sistema visual utilizado en las láminas `A1-configuracion-ios-4k.png` y `A2-configuracion-ios-4k.png`. Su función es permitir que otra persona pueda reconstruir los wireframes en Figma manteniendo continuidad entre estados, sin convertir estas referencias en una interfaz final ni en una copia literal de iOS.

La estética toma referencias contemporáneas de composición iOS —tarjetas agrupadas, hojas inferiores, navegación sobria y jerarquía espacial—, pero el sistema representado sigue siendo Relevo y su arquitectura inicial continúa siendo Android. La referencia visual no modifica esa decisión técnica.

## Lienzo y composición

| Token | Valor exacto |
| --- | --- |
| Lienzo final | `3840 × 2160 px` — 16:9 |
| Fondo | `#FCFBF8` |
| Columnas | 3 pantallas completas, una por estado |
| Marco móvil de referencia | aproximadamente `1012 × 1808 px`, proporción vertical cercana a 9:16 |
| Posición vertical del marco | aproximadamente `175 px` desde el borde superior |
| Margen lateral de la lámina | aproximadamente `245 px` |
| Separación entre marcos | aproximadamente `160 px` |
| Etiqueta de estado | sobre cada marco, en mayúsculas pequeñas |
| Fondo auxiliar | retícula cálida muy tenue, sin competir con las pantallas |

Cada lámina debe mostrar dos o tres pantallas grandes, completas y fáciles de calcar. No se agregan teléfonos físicos, manos, escenas fotográficas ni marcos de dispositivo externos. El marco móvil es una superficie plana de referencia.

## Paleta

| Uso | Color |
| --- | --- |
| Fondo principal | `#FCFBF8` |
| Superficie de tarjeta | `#FFFFFF` |
| Superficie secundaria / hoja inferior | `#F1EEE9` |
| Regla y borde | `#D8D4CE` |
| Texto principal | `#262522` |
| Texto secundario | `#6D6A65` |
| Estado disponible o no concedido | gris neutro, sin color semántico saturado |
| Acción principal | `#262522` con texto `#FCFBF8`, solo cuando se necesita jerarquía |

No utilizar azul de sistema, verde de éxito, rojo de error, gradientes intensos, neón, sombras cromáticas ni colores de marca. Un estado técnico se comunica mediante texto, borde, icono lineal y jerarquía; nunca mediante alarma visual.

## Tipografía

- Sans serif limpia de sistema, equivalente visual a SF Pro o Inter; no usar una tipografía decorativa.
- Títulos de pantalla: peso semibold, aproximadamente `48–60 px` en el lienzo final, interlineado compacto.
- Cuerpo: regular, aproximadamente `28–34 px`, interlineado entre `1.25` y `1.4`.
- Etiquetas de campo: medium, aproximadamente `22–26 px`.
- Acción principal: medium, aproximadamente `28–32 px`.
- Etiquetas de lámina: mayúsculas, peso medium, tracking leve, aproximadamente `22–26 px`.
- Mantener una sola familia tipográfica por lámina.
- El texto debe ser breve, literal y legible; no rellenar espacios con microcopy.

## Geometría y componentes

- Radio exterior de marco: `28–36 px`.
- Radio de tarjetas: `20–28 px`.
- Radio de botones: `18–24 px`.
- Borde: `2 px` en gris cálido, sin contornos negros pesados salvo una acción focal.
- Sombra: única, amplia y muy suave; opacidad baja, sin efecto flotante exagerado.
- Separación vertical entre grupos: `24–40 px`.
- Padding interno de tarjeta: `32–44 px`.
- Botones de ancho completo, alto aproximado `92–108 px`.
- Campos y filas con área táctil amplia, aunque la lámina no representa estados de accesibilidad completos.
- Iconos lineales, geométricos, monocromos y secundarios; nunca usar iconos como sustituto del texto esencial.
- Navegación superior con nombre `RELEVO`, una affordance textual o chevrón simple y un indicador de progreso de puntos o números.
- No incluir barra de estado del sistema, barra de navegación Android, botón atrás triangular, menú vertical de tres puntos ni pantalla de ajustes del sistema operativo.

## Reglas de contenido para Relevo

Cada ciclo representado debe conservar exactamente:

1. una intención propia;
2. un primer paso concreto;
3. una condición observable provisional;
4. una vigencia;
5. un testigo físico situado;
6. un pulso ambiental posterior.

La serie A1–A2 cubre solo la configuración inicial y sus salidas. No debe inventar una condición psicológica, detectar culpa, inferir automatismo ni presentar una actividad alternativa como obligación.

La aplicación conserva el significado y explica los estados técnicos. El testigo físico no contiene pantalla, texto, menú ni historial. El permiso se comunica como una condición técnica, no como juicio sobre la persona. Guardar un borrador es opcional. Salir, volver, cambiar de condición y continuar editando son decisiones válidas.

## Mapa de estados y copia aprobada

| Estado | Tratamiento visual | Texto principal aprobado |
| --- | --- | --- |
| 01 · Sin configurar | Estado vacío con dos campos conceptuales y una acción de inicio | `Sin configurar` · `Crea una intención` · `Define una actividad y su primer paso.` · `Crear intención` |
| 02 · Datos incompletos | Filas agrupadas, un dato ausente y validación contenida | `Completa tu ciclo` · `Intención` · `Primer paso` · `Aplicación` · `Condición provisional` · `Vigencia` · `Falta este dato para continuar` · `Revisar` |
| 03 · Permiso requerido | Explicación del alcance del permiso y acciones de recuperación | `Permiso requerido` · `Relevo necesita consultar el estado de uso de la aplicación elegida para observar la condición provisional durante el ciclo` · `Aún no concedido` · `Abrir ajustes` · `Cambiar condición` · `Volver` |
| 04 · Permiso denegado | Estado técnico no punitivo con rutas alternativas | `Permiso no concedido` · `No se puede observar la condición elegida con este permiso` · `Sin acceso` · `Abrir ajustes` · `Cambiar condición` · `Salir` |
| 05 · Revisión | Resumen editable antes de situar el testigo | `Revisa antes de situar el testigo` · `Leer un capítulo` · `Abrir el libro` · `Condición provisional · por validar` · `Vigencia · hoy, 20:00–22:00` · `El ciclo aún no está armado` · `Editar` · `Continuar para situar` |
| 06 · Salida voluntaria | Hoja inferior sobre la revisión, sin culpa ni presión | `¿Salir de la configuración?` · `Puedes volver después. La decisión queda en tus manos.` · `Guardar borrador` · `Descartar borrador` · `Seguir editando` |

Los valores de estado 05 son un ejemplo estructural y deben permanecer rotulados como provisionales. No representan una condición definitiva ni una validación ejecutada.

## Control de coherencia entre láminas

Antes de replicar o modificar una lámina, comprobar:

- misma retícula, márgenes, radios, tipografía y jerarquía;
- misma posición relativa del encabezado y del indicador de progreso;
- tres columnas, sin pantallas cortadas ni elementos fuera de marco;
- una sola acción principal por pantalla, salvo la hoja de salida que presenta alternativas equivalentes;
- lenguaje técnico separado de la decisión personal;
- ausencia de bloqueo, puntaje, racha, cumplimiento, vigilancia, inferencia subjetiva o rearme automático;
- no presentar Android como una interfaz visual literal ni trasladar controles técnicos al testigo físico;
- no añadir funciones de mercado, seguimiento o personalización no respaldadas por la memoria vigente v2.

## Registro breve de prompts

### A1 — Estados 01–03

Se solicitó una lámina `ui-mockup` de 3840 × 2160 con tres pantallas completas: `Sin configurar`, `Datos incompletos` y `Permiso requerido`. El prompt fijó la copia aprobada, una intención y un primer paso, condición provisional, vigencia, permiso técnico y acciones de recuperación. También exigió paleta cálida acromática, tarjetas agrupadas, navegación sobria, estilo iOS contemporáneo original y exclusión explícita de patrones Android.

### A2 — Estados 04–06

Se solicitó una lámina con la misma composición y sistema visual para `Permiso denegado`, `Revisión` y `Salida voluntaria`. El prompt fijó los valores estructurales de revisión, la condición rotulada `por validar`, el estado no armado y una hoja inferior de salida con guardar, descartar o seguir editando. Se excluyeron lenguaje punitivo, bloqueo, cumplimiento, automatismos, sistema Android literal y texto adicional.

### Normalización técnica

El built-in `image_gen` produjo ambas imágenes en `1672 × 941 px`. Cada salida se amplió proporcionalmente hasta un lienzo final exacto de `3840 × 2160 px`, con interpolación bicúbica de alta calidad, sin recortar ni estirar el contenido. Las salidas nativas se conservaron fuera del repositorio como originales de generación; las versiones finales de este directorio son las copias de trabajo.

## Registro de creación (disclaimer)

**Fecha:** 25 de agosto de 2026.

**Archivo nuevo:** se creó este contrato junto con `A1-configuracion-ios-4k.png` y `A2-configuracion-ios-4k.png` dentro de `wireframes-referencia-ios-4k`.

**Decisión:** se adoptó una referencia visual contemporánea inspirada en patrones de composición iOS, sin fijar una identidad final ni contradecir la decisión de Android como plataforma técnica inicial.

**Alcance:** las láminas son referencias visuales de baja/media fidelidad para calcar y discutir en Figma. No sustituyen el tablero evaluable de Encargo 17, no validan el producto y no cierran forma, materialidad, canal, condición ni accesibilidad.

### 2026-08-25 — Corrección de copia de permisos

- **Cambio:** el estado 03 reemplazó la variante textual incorrecta por la frase aprobada sobre observar la condición provisional durante el ciclo; el estado 04 se alineó con la formulación final visible en la lámina A2.
- **Versión anterior:** la lámina A1 contenía una variante textual incorrecta sobre probar la condición provisional; el mapa de copia tenía una formulación distinta para el estado 03 y el estado 04 decía `Sin este permiso no se puede observar la condición elegida`.
- **Motivo:** corregir el error textual, describir con precisión el alcance técnico del permiso y mantener continuidad entre el mapa de copia y las referencias visuales.
- **Alcance:** solo se modificaron las filas 03 y 04 del mapa de copia; no se alteran las decisiones de plataforma, la arquitectura phygital ni el alcance conceptual de Relevo.
