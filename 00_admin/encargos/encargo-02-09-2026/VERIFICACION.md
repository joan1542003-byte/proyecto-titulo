# Verificación de la entrega

## Resultado

| Revisión | Resultado |
|---|---|
| Wireframes de ruta principal | 9 archivos |
| Estados de cobertura | 35 archivos |
| Dimensión de los 44 wireframes | 824 × 1830 px |
| Archivos con dimensión incorrecta | 0 |
| Pantalla destacada de alta fidelidad | 853 × 1844 px, tamaño original |
| Texto de la pantalla destacada | Revisado visualmente |
| Diferencias entre repositorio y carpeta `Encargos` | 0 |
| Mapa general | Incluido |
| Explicación individual | Incluida para 9 + 35 vistas |
| Carpetas individuales dentro del mapa | 44 |
| PNG locales auditados | 198 |
| PNG transparentes respaldados en Git | 25 de 25 |

## Controles aplicados

Se comprobó la existencia y dimensión de los 44 wireframes. El mapa organizado contiene una carpeta por marco y mantiene separadas la ruta principal y la cobertura. La pantalla destacada conserva su tamaño original para evitar una ampliación o recorte innecesario.

La pantalla 3.1 se revisó por contenido, jerarquía y correspondencia con el recorrido. No usa rojo, progreso ni recompensas porque representa un ciclo en espera. La interfaz mantiene visible la salida “Desarmar ciclo”. Además, se reemplazó una frase que explicaba el soporte por los estados directos “Testigo vinculado” y “En espera”.

La carpeta local de generaciones se comparó por huella digital con Git. Después del rescate y de la corrección de la pantalla principal, 194 de 198 PNG tienen una coincidencia exacta y las 25 imágenes con transparencia están respaldadas. Los cuatro archivos restantes corresponden a una fuente ya normalizada, un borrador defectuoso y dos editoriales conceptualmente desactualizadas.

## Límites de la verificación

Esta revisión detecta archivos faltantes, copias diferentes, dimensiones incorrectas y errores visibles en la pantalla principal. No evalúa interacción, orden de foco, teclado, permisos, conexión BLE ni percepción del pulso.

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Verificación ampliada

- **Qué se incorporó:** control de la estructura individual, revisión de la nueva pantalla destacada y auditoría del archivo local de generaciones.
- **Cómo estaba antes:** la verificación cubría exportaciones planas, mapa y la pantalla 1.1.
- **Por qué se hizo:** confirmar la organización solicitada y distinguir respaldo de aprobación visual.

### 2026-09-02 — Verificación inicial

- **Qué se incorporó:** conteo, control de dimensiones, revisión visual y comparación entre las dos copias de la entrega.
- **Cómo estaba antes:** no existía un informe de integridad para esta carpeta fechada.
- **Por qué se hizo:** evitar una entrega incompleta o distinta entre el repositorio y la carpeta local de encargos.
