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
| Arquitectura general | 3840 × 2160 px |
| Atlas de ruta principal | 3168 × 7080 px |
| Cobertura por familias | 3840 × 3000 px |
| Explicación individual | Incluida para 9 + 35 vistas |
| Carpetas individuales dentro del mapa | 44 |
| PNG locales auditados | 198 |
| PNG transparentes respaldados en Git | 25 de 25 |

## Controles aplicados

Se comprobó la existencia y dimensión de los 44 wireframes. El mapa organizado contiene una carpeta por marco y mantiene separadas la ruta principal y la cobertura. Las nueve pantallas de la ruta se revisaron a tamaño de lectura; la pantalla destacada conserva su tamaño original para evitar una ampliación o recorte innecesario.

La pantalla 3.1 se revisó por contenido, jerarquía y correspondencia con el recorrido. No usa rojo, progreso ni recompensas porque representa un ciclo en espera. La interfaz mantiene visible la salida “Desarmar ciclo”. Además, se reemplazó una frase que explicaba el soporte por los estados directos “Testigo vinculado” y “En espera”.

El archivo visual local se comparó por huella digital con el repositorio. Después del rescate y de la corrección de la pantalla principal, 194 de 198 PNG tienen una coincidencia exacta y las 25 imágenes con transparencia están respaldadas. Los cuatro archivos restantes corresponden a una fuente ya normalizada, un borrador defectuoso y dos editoriales conceptualmente desactualizadas.

La revisión automatizada confirmó el idioma español, el lienzo de 412 × 915 dp, las exportaciones de 824 × 1830 px, la navegación, la ausencia de simulación de teléfono, el uso exclusivo del rojo en la señal situada, la descripción accesible del gráfico, la inexistencia de desbordes y cero errores de consola.

## Límites de la verificación

Esta revisión detecta archivos faltantes, copias diferentes, dimensiones incorrectas y errores visibles en la pantalla principal. No evalúa interacción, orden de foco, teclado, permisos, conexión BLE ni percepción del pulso.

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Verificación de la reconstrucción visual

- **Qué se incorporó:** dimensiones de los tres mapas, revisión de las nueve pantallas y controles sobre color, gráfico informativo, navegación, desbordes y consola.
- **Cómo estaba antes:** el informe solo registraba la presencia de un mapa general y concentraba la revisión visual en la pantalla 3.1.
- **Qué se reemplazó:** la comprobación del mapa único se sustituyó por controles separados de arquitectura, ruta ampliada y cobertura.
- **Por qué se hizo:** verificar el resultado vigente y no una estructura visual ya retirada.

### 2026-09-02 — Verificación ampliada

- **Qué se incorporó:** control de la estructura individual, revisión de la nueva pantalla destacada e inventario del archivo visual local.
- **Cómo estaba antes:** la verificación cubría exportaciones planas, mapa y la pantalla 1.1.
- **Por qué se hizo:** confirmar la organización solicitada y distinguir respaldo de aprobación visual.

### 2026-09-02 — Verificación inicial

- **Qué se incorporó:** conteo, control de dimensiones, revisión visual y comparación entre las dos copias de la entrega.
- **Cómo estaba antes:** no existía un informe de integridad para esta carpeta fechada.
- **Por qué se hizo:** evitar una entrega incompleta o distinta entre el repositorio y la carpeta local de encargos.
