# Fundamentos y tokens

## Gramática compartida

El sistema representa una relación de tres momentos: **origen**, **transferencia** y **señal situada**. El origen es un campo denso asociado a una intención; la transferencia reduce gradualmente el campo; la señal situada concentra la atención en un punto y un contexto. La secuencia no representa progreso, cumplimiento ni recompensa.

## Color

| Rol | Claro | Oscuro | Uso |
| --- | --- | --- | --- |
| Fondo | `#F4F4F2` | `#111314` | Superficie general. |
| Superficie | `#FFFFFF` | `#1B1D1E` | Agrupación principal. |
| Superficie secundaria | `#E9E9E5` | `#242728` | Diferenciación sutil. |
| Texto principal | `#1B1D1E` | `#F1F1F1` | Lectura y estructura. |
| Texto secundario | `#5E6162` | `#B6B8B7` | Apoyo y metadatos. |
| Divisor suave | `#C9CBC8` | `#3A3D3E` | Separación decorativa; no comunica estado. |
| Borde funcional | `#777B7A` | `#767A79` | Controles, foco y gráficos relevantes. |
| Señal accesible | `#B8121A` | `#EF3E45` | Texto, icono o estado localizado. |
| Rojo de identidad | `#D71921` | `#EF3E45` | Marca y acento amplio. |

Contrastes calculados: texto principal 15,36:1 en claro y 16,50:1 en oscuro; texto secundario 5,67:1 y 9,34:1; señal accesible 6,07:1 y 4,83:1. Los divisores suaves no alcanzan 3:1 y, por tanto, solo pueden usarse cuando no transmiten información. Los bordes funcionales superan 3:1 en su tema correspondiente.

## Tipografía

IBM Plex Sans es la candidata para lectura, navegación y escritura académica. IBM Plex Mono se reserva para códigos, folios, medidas y etiquetas técnicas. El alfabeto de puntos se limita a la marca, numerales grandes y fragmentos breves; nunca compone instrucciones, citas ni cuerpo de texto.

### Android

| Rol | Tamaño / interlínea |
| --- | ---: |
| Titular principal | 32 / 40 sp |
| Título de pantalla | 24 / 32 sp |
| Título de sección | 20 / 28 sp |
| Cuerpo | 16 / 24 sp |
| Secundario | 14 / 20 sp |
| Etiqueta | 12 / 16 sp |

### Editorial impreso

| Rol | Tamaño / interlínea |
| --- | ---: |
| Portada | 36–44 pt |
| Apertura de capítulo | 26–32 pt |
| Título secundario | 16–18 pt |
| Cuerpo | 10,5 / 15 pt |
| Pie o nota de figura | 8,5 / 12 pt |
| Folio y dato técnico | 8 pt |

El cuerpo debe procurar líneas de 55 a 70 caracteres y alineación a la izquierda. La medida final se comprobará con la plantilla institucional y pruebas impresas.

## Espacio, forma e iconos

- unidad base: 4;
- escala: 4, 8, 12, 16, 24, 32, 48 y 64;
- Android: margen lateral de 24 dp y objetivo táctil mínimo de 48 × 48 dp;
- radios: 8 para campos, 16 para grupos y 24 para un control dominante excepcional;
- iconos: trazo convencional de 2 px dentro de un área táctil suficiente;
- cápsulas: solo estados compactos, nunca como forma universal;
- sombras: prescindibles; la jerarquía se construye con espacio, contraste y alineación.

## Temas

Claro y oscuro comparten jerarquía, significado y medidas. El tema claro prioriza lectura prolongada, documentación y uso cotidiano. El oscuro concentra atención en presentaciones, estados ambientales y piezas digitales. No se obtiene mediante inversión automática: cada contraste se revisa por rol.

---

## Registro de cambios (disclaimer)

### 2026-08-28 — Creación

- **Cambio:** se fijaron roles de color, contrastes, escalas tipográficas, espaciado y geometría para ambos temas.
- **Versión anterior:** existía una paleta provisional sin pareja completa de temas ni separación entre divisor decorativo y borde funcional.
- **Motivo:** hacer medibles y transferibles las decisiones visuales.

