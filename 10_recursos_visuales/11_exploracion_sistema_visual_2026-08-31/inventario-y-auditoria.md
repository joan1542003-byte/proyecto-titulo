# Inventario y auditoría de piezas

## Criterios

Cada pieza se revisó según cinco preguntas: ¿expresa una relación propia de Relevo?, ¿mantiene una jerarquía clara?, ¿distingue información, decoración y acción?, ¿respeta el rol del rojo?, ¿puede reconstruirse sin copiar errores del texto generado?

## Inventario

| Archivo | Resolución | Evaluación | Uso permitido | Corrección necesaria |
|---|---:|---|---|---|
| `01_android/android-formular-intencion-oscuro-v1.png` | 853 × 1844 | Candidato visual. Buena jerarquía y ausencia correcta de rojo. | Referencia para reconstruir el marco de formulación. | Reducir altura del gráfico, verificar texto real y adaptar a 390 × 844 dp. |
| `01_android/android-revisar-ciclo-claro-exploratorio-v1.png` | 852 × 1846 | Exploración comparativa. La composición es útil, pero el generador sustituyó el español por inglés. | Estudiar jerarquía, ritmo y filas de resumen. | No reutilizar el texto; reconstruir en español y mantener el tema claro como hipótesis. |
| `02_editorial/editorial-estado-del-arte-claro-v1.png` | 1672 × 941 | Candidato compositivo. | Retícula, relación entre tabla, diagrama, pies y folios. | Reemplazar toda afirmación por contenido verificado de la memoria. |
| `02_editorial/editorial-viaje-usuario-oscuro-v1.png` | 1672 × 941 | Candidato de presentación, no de evidencia. | Organización horizontal y cambio de densidad. | Eliminar la cita sintética y reconstruir solo con hallazgos trazables. |
| `03_carteles/cartel-transferencia-situada-claro-v1.png` | 941 × 1672 | Candidato sólido. | Cartel, portada o apertura reconstruida. | Ajustar retícula y reproducir la marca con un alfabeto propio. |
| `04_modulos_transparentes/modulo-transferencia-grafito-transparente-v1.png` | 1774 × 887 | Candidato reutilizable. Alfa correcto en las cuatro esquinas. | Sobre fondos claros, presentaciones y diagramas. | Limpiar irregularidades antes de convertir a vector. |
| `04_modulos_transparentes/modulo-transferencia-blanco-transparente-exploratorio-v1.png` | 1774 × 887 | Requiere corrección. Alfa correcto, pero presenta bordes y puntos contaminados. | Solo comparación interna. | Regenerar o reconstruir; no usar como arte final. |
| `04_modulos_transparentes/simbolo-senal-orbita-abierta-exploratorio-v1.png` | 1254 × 1254 | Requiere revisión semántica. Alfa correcto. | Ensayo de apertura y señal. | Reducir semejanza con objetivo, selector o indicador de carga; aplanar el rojo. |
| `04_modulos_transparentes/simbolo-vinculo-neutral-transparente-v1.png` | 1254 × 1254 | Candidato reutilizable. Alfa correcto. | Diagramas y separadores informativos. | Comprobar que no parezca control deslizante. |
| `05_fondos/fondo-campo-transferencia-claro-v1.png` | 1672 × 941 | Candidato sólido. | Fondo editorial y presentación con texto en espacio negativo. | Controlar contraste y recorte según formato. |
| `05_fondos/fondo-campo-transferencia-oscuro-v1.png` | 1672 × 941 | Candidato sólido. | Fondo digital y presentación. | Mantener la matriz fuera de zonas de lectura e interacción. |
| `99_descartados/cartel-transferencia-situada-oscuro-rechazado-v1.png` | 941 × 1672 | Descartado. | Comparación interna del proceso. | Regenerar con texto blanco o gris, nodo rojo menor y sin acento rojo en la marca. |

## Hallazgos de la auditoría

La familia más consistente combina un campo lateral, una transición amplia y un nodo situado pequeño. Las piezas pierden precisión cuando convierten la señal en un círculo dominante o cuando distribuyen puntos como decoración indiferenciada. El sistema se fortalece al reservar la matriz para relaciones y al permitir que la tipografía convencional sostenga el contenido.

La generación de imágenes puede proponer composición y atmósfera, pero no es confiable para textos académicos, citas, datos ni microcopias definitivas. Por ello, cada pieza textual debe reconstruirse desde la memoria y el registro de decisiones.

## Registro de cambios

### 2026-08-31 — Primera auditoría

- **Cambio:** se verificaron doce archivos, sus resoluciones y la transparencia de cuatro módulos.
- **Versión anterior:** las piezas estaban generadas, pero aún no existía una clasificación entre candidatos, comparaciones y resultados que requieren corrección.
- **Motivo:** conservar diversidad sin tratar todos los resultados como igualmente válidos.
- **Alcance:** la auditoría visual no reemplaza pruebas de comprensión, accesibilidad o implementación.
