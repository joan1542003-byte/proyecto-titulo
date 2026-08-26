# Auditoría de diseño — Wireframes HTML de Relevo

## Evidencia comparada

- **Verdad visual de origen:** `../wireframes-referencia-ios-4k/A1-configuracion-ios-4k.png`, lámina de 3840 × 2160 px; para la comparación se aisló el estado 01 en un recorte de 1280 × 2160 px.
- **Implementación:** `public/exports/cobertura-01-sin-configurar.png`, 716 × 1296 px; corresponde a una superficie de 358 × 648 CSS px capturada a densidad 2.
- **Comparación conjunta:** `qa/comparison-01-final.png`, 1683 × 1480 px.
- **Viewport funcional:** pantalla móvil de 393 × 852 CSS px, `deviceScaleFactor: 1`.
- **Estado:** Cobertura 01 · Sin configurar.

La comparación de vista completa confirma una jerarquía equivalente: identificación del estado, título, contenido conceptual, acción principal y leyenda. No se requirió un recorte adicional: el texto, los contornos, las etiquetas de componente y la acción son legibles en la comparación conjunta a tamaño original.

## Superficies de fidelidad

- **Tipografía:** Roboto mantiene una lectura utilitaria, pesos diferenciados y una escala clara. Los títulos, etiquetas y cuerpos no se truncan en la muestra ni en los recorridos probados.
- **Espaciado y ritmo:** la composición conserva márgenes amplios, agrupación por tarjetas, controles táctiles y una progresión vertical estable. No se detectó desborde horizontal.
- **Color y tokens:** la paleta permanece acromática, con fondo cálido, superficies blancas, gris de apoyo y negro para la acción principal. Los estados técnicos no dependen del color.
- **Iconos y recursos:** se utiliza una sola familia de iconos de Radix. No hay ilustraciones provisionales, SVG dibujados a mano, emoji ni recursos que presenten una forma física como definitiva.
- **Copia:** la interfaz distingue decisión personal y estado técnico. No introduce bloqueo, sanción, cumplimiento, rearme automático ni inferencias subjetivas.
- **Momento phygital:** el marco 3.2 y el estado 23 explican testigo, lugar y pulso sin instalar texto, menú o historial en el objeto.

## Historial de comparación y correcciones

### Iteración 1

- **[P2] Los marcos evaluables estaban demasiado resumidos.** La primera captura mostraba título, estado y acción, pero no hacía visibles campos, selectores, resumen, vínculo, batería, prueba, armado, espera y recuperación.
- **Corrección:** se incorporaron componentes específicos para los nueve marcos principales y etiquetas simples de campo, selector, resumen, estado, tarjeta y error.
- **Evidencia posterior:** `public/exports/1-1-formular.png`, `public/exports/2-2-probar-pulso.png` y `public/exports/3-3-cerrar-o-recuperar.png`.

### Iteración 2

- **[P2] El estado 01 no anticipaba la relación entre intención y primer paso.** La referencia mostraba ambos elementos conceptuales y la implementación solo informaba que no existía un ciclo.
- **Corrección:** el estado vacío incorporó los campos conceptuales Intención y Primer paso, ambos sin definir.
- **Evidencia posterior:** `qa/comparison-01-final.png`.

### Iteración 3

- **[P2] La exportación incluía cromo del dispositivo.** Las primeras imágenes contenían el indicador inferior y recortes redondeados del runtime móvil.
- **Corrección:** el proceso de exportación oculta el cromo del dispositivo, centra la superficie y produce PNG rectangulares limpios.
- **Evidencia posterior:** las 44 imágenes vigentes de `public/exports/`.

## Verificación funcional

- Integridad del runtime móvil: aprobada, 28 archivos protegidos intactos.
- Navegación siguiente: 1.1 → 1.2, aprobada.
- Cambio Entrega → Cobertura: abre el estado 01, aprobado.
- Ficha desplegable: aprobada.
- Exportaciones: 44 archivos presentes, 9 evaluables y 35 complementarios.
- Consola del navegador: 0 errores relevantes.
- Desborde horizontal: no detectado.
- Build de producción y paquete Sites: aprobados; 4 pruebas superadas.

## Hallazgos finales

No permanecen hallazgos P0, P1 o P2. Como refinamiento P3 posterior puede explorarse una mayor diferenciación visual entre familias del anexo, siempre dentro de la escala de grises y sin convertirla en identidad final.

**final result: passed**
