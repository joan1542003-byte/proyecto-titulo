# Bitácora de producción y auditoría — Estados 25–35

**Fecha:** 25 de agosto de 2026  
**Proyecto:** Relevo  
**Entrega relacionada:** Encargo 17 — Wireframes: del flujo a la estructura  
**Tipo de pieza:** referencia visual raster 4K
**Referencia visual:** `A2-configuracion-4k.png`

## Alcance

Se produjeron cuatro láminas raster de referencia para calcar en Figma. Cada lámina representa estados ya definidos en la matriz de cobertura del Encargo 17 y en la memoria vigente v2. No son interfaces finales ni resultados de validación.

Se revisaron antes de producir:

- `08_memoria/memoria-vigente-v2.md`;
- `01_contexto_y_fuentes/encargo-17-requisitos.md`;
- `05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md`;
- `05_propuesta_phygital/wireframes-referencia-4k/contrato-visual.md`;
- `05_propuesta_phygital/wireframes-referencia-4k/A2-configuracion-4k.png`.

## Contrato común aplicado a las cuatro láminas

- Lienzo horizontal 16:9, con salida final exacta de `3840 × 2160 px`.
- Baja/media fidelidad: estructura, jerarquía y comportamiento visible; no UI final.
- Estética contemporánea, minimalista y original, con composición espacial sobria sin copiar una interfaz específica.
- Fondo `#FCFBF8`, superficies blancas, secundarios `#F1EEE9`, bordes `#D8D4CE`, texto `#262522` y `#6D6A65`.
- Tarjetas agrupadas, esquinas suaves, tipografía sans serif de sistema, iconos lineales monocromos y sombras discretas.
- Superficies móviles planas, sin marcos de teléfono, fotografías, personas ni manos.
- Sin barra de estado, barra de navegación, menú o ajustes visuales de Android.
- El testigo físico aparece únicamente como referencia lineal o contextual cuando ayuda a explicar un estado híbrido; no tiene pantalla, texto, menú ni historial.
- No se representan bloqueo, puntuación, rachas, vigilancia, inferencia subjetiva, cumplimiento ni rearme automático.

## Prompt base

> Producir una lámina horizontal de wireframes móviles de baja/media fidelidad para Relevo, usando `A2-configuracion-4k.png` como referencia visual obligatoria de retícula, jerarquía, proporciones, tarjetas agrupadas, fondo cálido, radios y tipografía. Mantener superficies móviles planas, grandes, completas y fáciles de calcar. Usar una estética moderna, minimalista, contemporánea y original, con composición espacial sobria y sin imitar una interfaz específica. El sistema es phygital: la aplicación conserva el significado y comunica estados; el testigo físico no tiene pantalla. Respetar la memoria v2, la matriz del Encargo 17 y el contrato conceptual de Relevo: no bloqueo, no cumplimiento, no puntuación, no inferencia subjetiva y no rearme automático. Usar exclusivamente el texto indicado para cada estado, en español legible y con tildes correctas.

## Lámina E1

**Archivo:** `E1-cierre-4k.png`
**Estados:** 25 Ciclo cerrado · 26 Intención cambiada · 27 Permiso revocado  
**Composición solicitada:** tres wireframes verticales completos, en tres columnas.

**Prompt específico:**

> Crear tres pantallas para cierre y recuperación de decisión. En 25, mostrar el cierre del ciclo y dejar explícito que no se guarda si la persona continuó, ignoró o cambió de actividad. En 26, mostrar que la intención cambió sin lenguaje de fracaso y permitir cerrar o editar. En 27, mostrar el permiso como estado técnico de Android y ofrecer revisar, cambiar la condición o cerrar. Mantener una sola acción principal por pantalla y alternativas contenidas. No convertir el permiso en juicio, no afirmar cumplimiento y no introducir una pantalla del testigo.

**Texto indicado:**

- 25: `Ciclo cerrado` · `El ciclo terminó.` · `No se guarda si continuaste, ignoraste o cambiaste de actividad.` · `Preparar otro ciclo` · `Volver al inicio`.
- 26: `La intención cambió` · `Puedes cerrar este ciclo o formular otro primer paso.` · `Cerrar ciclo` · `Editar intención`.
- 27: `Permiso revocado` · `Android ya no permite observar la condición elegida.` · `Revisar permiso` · `Cambiar condición` · `Cerrar ciclo`.

## Lámina E2

**Archivo:** `E2-recuperacion-4k.png`
**Estados:** 28 Segundo plano restringido · 29 Testigo desconectado · 30 Lugar por volver a probar  
**Composición solicitada:** tres wireframes verticales completos, en tres columnas.

**Prompt específico:**

> Crear tres estados técnicos de recuperación. En 28, comunicar que Relevo puede no observar la condición mientras está en segundo plano, sin prometer fiabilidad total. En 29, comunicar que no se puede confirmar la entrega del pulso y ofrecer reconectar, reintentar o cerrar. En 30, indicar que, si la persona informa que el testigo cambió de lugar, debe volver a probar su relación con el primer paso; no representar detección automática de movimiento ni geolocalización. En los estados híbridos, usar solo una representación lineal neutral del testigo sin pantalla ni texto.

**Texto indicado:**

- 28: `Observación limitada` · `Relevo puede no observar la condición mientras está en segundo plano.` · `Revisar restricción` · `Mantener en espera` · `Cerrar ciclo`.
- 29: `Testigo desconectado` · `No se puede confirmar la entrega del pulso.` · `Reconectar` · `Reintentar` · `Cerrar ciclo`.
- 30: `Lugar por volver a probar` · `Si el testigo cambió de lugar, vuelve a probar su relación con el primer paso.` · `Reubicar y probar` · `Cerrar ciclo`.

## Lámina E3

**Archivo:** `E3-recuperacion-4k.png`
**Estados:** 31 Batería crítica · 32 Testigo reiniciado · 33 Vencimiento sin activación  
**Composición solicitada:** tres wireframes verticales completos, en tres columnas.

**Prompt específico:**

> Crear tres estados de energía, reinicio y vencimiento. En 31, mostrar que la energía disponible no asegura el siguiente pulso y ofrecer cargar, desarmar o cerrar. En 32, mostrar que se verifica el vínculo y se repite la prueba antes de armar de nuevo; no incluir un botón directo de armado. En 33, mostrar que terminó la vigencia sin activación y permitir cerrar o preparar otro ciclo, sin atribuir ignorancia, desinterés o incumplimiento. No afirmar entrega futura, persistencia técnica ni rearme automático.

**Texto indicado:**

- 31: `Batería crítica` · `La energía disponible no asegura el siguiente pulso.` · `Cargar testigo` · `Desarmar ciclo` · `Cerrar ciclo`.
- 32: `Testigo reiniciado` · `Verifica el vínculo y repite la prueba antes de armar de nuevo` · `Verificar vínculo` · `Repetir prueba` · `Cerrar ciclo`.
- 33: `Vigencia terminada` · `No se activó ningún pulso dentro de esta ventana.` · `Cerrar ciclo` · `Preparar otro ciclo`.

## Lámina E4

**Archivo:** `E4-finales-4k.png`
**Estados:** 34 Rearme explícito · 35 Eliminar configuración  
**Composición solicitada:** dos wireframes verticales completos y centrados, con espacio lateral equilibrado.

**Prompt específico:**

> Crear dos estados finales. En 34, mostrar una revisión antes de armar nuevamente, con intención, primer paso, condición provisional y vigencia visibles; la acción principal debe decir “Continuar al armado” y conducir a un armado posterior explícito. En 35, mostrar una confirmación de eliminación con la posibilidad clara de cancelar y conservar la configuración para revisarla después. Mantener la decisión en manos de la persona y no sugerir continuidad automática.

**Texto indicado:**

- 34: `Rearmar ciclo` · `Revisa la intención antes de armar nuevamente.` · `Intención · Leer un capítulo` · `Primer paso · Abrir el libro` · `Condición provisional · por validar` · `Vigencia · hoy, 20:00–22:00` · `Continuar al armado` · `Volver al inicio`.
- 35: `Eliminar configuración` · `¿Quieres eliminar este ciclo?` · `Puedes cancelar y conservarlo para revisarlo después.` · `Cancelar` · `Eliminar`.

## Corrección conceptual aplicada — 25 de agosto de 2026

- **Estado 32:** se reemplazó `Verifica el vínculo y arma el ciclo de nuevo.` por `Verifica el vínculo y repite la prueba antes de armar de nuevo`. El botón `Armar de nuevo` se reemplazó por `Repetir prueba`; se conservaron `Verificar vínculo` y `Cerrar ciclo`.
- **Estado 34:** se reemplazó el botón `Revisar y armar` por `Continuar al armado`.
- **Estilo:** no se modificaron retícula, composición, iconografía, paleta, tipografía, proporciones ni los demás estados.

## Normalización técnica

Las salidas originales midieron `1672 × 941 px`. Para cumplir la especificación de la carpeta, cada imagen se convirtió a `3840 × 2160 px` mediante una ampliación proporcional con `Image.Resampling.LANCZOS`. La proporción original se conservó: el contenido quedó en `3838 × 2160 px` y se añadieron dos píxeles de fondo cálido repartidos lateralmente. No se estiró ni se recortó ninguna pantalla.

Para esta corrección, E3 y E4 se editaron mediante localización de texto sobre sus láminas existentes y se volvieron a normalizar con el mismo procedimiento. E1 y E2 no fueron modificadas.

## Auditoría final

| Control | E1 | E2 | E3 | E4 |
| --- | --- | --- | --- | --- |
| Dimensión exacta `3840 × 2160` | Sí | Sí | Sí | Sí |
| Estados correctos | 25–27 | 28–30 | 31–33 | 34–35 |
| Cantidad de wireframes | 3 | 3 | 3 | 2 |
| Pantallas completas y calcables | Sí | Sí | Sí | Sí |
| Retícula y estilo consistentes con A2 | Sí | Sí | Sí | Sí |
| Texto visible y revisado visualmente | Sí | Sí | Sí | Sí |
| Barras o controles Android | No | No | No | No |
| Pantalla en el testigo físico | No | No | No | No |
| Rearme automático | No | No | No | No |
| Cumplimiento o evaluación de respuesta | No | No | No | No |

### Decisiones verificadas

- La desconexión no afirma que el pulso haya sido entregado: se presenta como entrega no confirmada.
- El movimiento del testigo no se detecta automáticamente: el estado se activa cuando la persona informa que cambió de lugar o que debe repetir la relación.
- El vencimiento se presenta como cierre temporal, no como ignorancia o incumplimiento.
- El rearme requiere revisión y acción explícita.
- En el estado 32, repetir la prueba queda antes del armado; no existe un botón directo `Armar de nuevo`.
- En el estado 34, la acción de continuidad ahora se denomina `Continuar al armado`.
- La aplicación puede comunicar un estado técnico, pero el testigo sigue siendo un objeto sin pantalla.
- Las láminas no representan la interfaz final ni cierran las decisiones todavía pendientes de condición, canal, energía, accesibilidad, convivencia o producción.

## Archivos creados en esta ejecución

- `E1-cierre-4k.png`
- `E2-recuperacion-4k.png`
- `E3-recuperacion-4k.png`
- `E4-finales-4k.png`
- `registro-laminas-25-35.md`

`contrato-visual.md` no fue editado. `A2-configuracion-4k.png` se utilizó exclusivamente como referencia visual en esta ejecución.

## Disclaimer y registro de cambios

- **Versión anterior:** la carpeta contenía las referencias A1–A2 y el contrato visual, pero no las cuatro láminas E1–E4 ni una bitácora específica de esta producción.
- **Cambio realizado:** se añadieron cuatro imágenes de referencia para los estados 25–35 y este documento con prompts, copy, normalización y auditoría.
- **Corrección posterior:** se actualizaron únicamente E3/32 y E4/34 para reflejar el orden conceptual correcto entre verificación, repetición de prueba y armado, y para nombrar `Continuar al armado`.
- **Versión anterior de esos estados:** E3/32 incluía `Armar de nuevo` como acción directa y E4/34 decía `Revisar y armar`.
- **Motivo de la corrección:** hacer visible que el testigo reiniciado debe verificarse y probarse antes de volver a armar, y separar la continuación de la revisión del armado posterior.
- **Motivo:** entregar referencias visuales consistentes y calcables para continuar el desarrollo del Encargo 17 en Figma sin alterar la arquitectura de la memoria.
- **Archivos no modificados:** `contrato-visual.md`, los documentos de la memoria, la matriz del Encargo 17 y el tablero Figma. No se incorporaron decisiones técnicas nuevas.
- **Alcance:** las imágenes son material de referencia de baja/media fidelidad; no validan eficacia, accesibilidad, estabilidad de Android/BLE, valor situado, adopción ni forma final del producto.

### 2026-09-02 — Normalización del nombre y del registro

- **Cambio:** se eliminó la referencia a una plataforma del nombre de la carpeta y de los archivos, se reemplazaron nombres operativos por nombres descriptivos y se retiró el identificador de colaboración del encabezado.
- **Cómo estaba antes:** la carpeta y el registro usaban “iOS” y un nombre de trabajo, aunque estas láminas solo cumplen una función de referencia compositiva.
- **Motivo:** evitar que una referencia estética se confunda con una decisión técnica del proyecto y ordenar la documentación por función, sin modificar las imágenes ni su cobertura.
