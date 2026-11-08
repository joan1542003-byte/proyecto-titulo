// Los nueve anexos de la memoria, en orden. El texto de cada uno está en su Markdown de esta carpeta
// (anexo-<letra>-<slug>.md), que es la fuente: construir-anexos.js lo lee y arma el Word y el PDF.
// Aquí solo va el orden y el título, que debe coincidir con el «# Anexo X.» del Markdown.
//
// Convenciones del Markdown que entiende el constructor:
//   # Anexo X. Título            → título del anexo (debe coincidir con `titulo`)
//   párrafo antes del primer ##   → introducción
//   ## X.n Título                 → cada parte; «## Referencias» lleva sangría francesa
//   **Tabla X1** / *Título* / tabla / *Nota.* …   → tablas y figuras en APA 7
//   tabla cuyas celdas son solo imágenes          → galería
//   fila con solo la primera celda en negrita     → fila de grupo
//   ```mermaid                                    → diagrama, guardado como SVG en imagenes/diagramas
//   <!-- lamina: LOGO | ICONOS | PALETA | CIELOS --> … <!-- /lamina -->
//                                 → figura armada con los archivos de la marca; lo de adentro es lo que muestra GitHub
//   ## Registro de cambios (disclaimer)  → historial del archivo; no entra al Word ni al PDF

const anexos = [
  { letra: 'A', slug: 'entrevistas', titulo: 'Entrevistas: pauta, corpus y análisis' },
  { letra: 'B', slug: 'encuesta', titulo: 'Encuesta: 53 respuestas' },
  { letra: 'C', slug: 'referentes', titulo: 'Estado del arte y referentes' },
  { letra: 'D', slug: 'criterios', titulo: 'Trazabilidad de los criterios de diseño' },
  { letra: 'E', slug: 'ia', titulo: 'Uso de inteligencia artificial' },
  { letra: 'F', slug: 'estados', titulo: 'Estados del ciclo y wireframes' },
  { letra: 'G', slug: 'android', titulo: 'Prototipo Android y registro de versiones' },
  { letra: 'H', slug: 'identidad', titulo: 'Identidad visual y sistema de marca' },
  { letra: 'I', slug: 'prueba', titulo: 'Protocolo de la prueba, consentimiento e instrumentos' },
];

module.exports = { anexos };
