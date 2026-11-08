// Los nueve anexos de la memoria, en orden. El texto de cada uno está en su Markdown de esta carpeta
// (anexo-<letra>-<slug>.md), que es la fuente: construir-anexos.js lo lee y arma el HTML, el PDF y el Word.
// Aquí solo va lo que el Markdown no dice: el color de su ficha y el resumen del índice.
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
//                                 → la lámina dibujada con los datos de la marca; lo de adentro es lo que muestra GitHub
//   ## Registro de cambios (disclaimer)  → historial del archivo; no entra al HTML, al PDF ni al Word

const portada = {
  titulo: 'Anexos',
  bajada: 'Memoria de Proyecto de Título · Escuela de Diseño UDP',
};

const anexos = [
  { letra: 'A', slug: 'entrevistas', color: 'sky', titulo: 'Entrevistas: pauta, corpus y análisis',
    resumen: 'La pauta de 13 preguntas, la síntesis de las ocho entrevistas, el libro de 23 códigos y los dos tipos de usuario.' },
  { letra: 'B', slug: 'encuesta', color: 'butter', titulo: 'Encuesta: 53 respuestas',
    resumen: 'Las 16 preguntas, el método, los recuentos, lo que tomó el diseño y la codificación de cada respuesta.' },
  { letra: 'C', slug: 'referentes', color: 'lime', titulo: 'Estado del arte y referentes',
    resumen: 'La búsqueda, una ficha por referente y los prototipos y patentes con piezas parecidas.' },
  { letra: 'D', slug: 'criterios', color: 'blush', titulo: 'Trazabilidad de los criterios de diseño',
    resumen: 'Cada criterio con su evidencia, cómo lo aplica Relevo, lo que mostró la prueba y lo que la app ya cambió.' },
  { letra: 'E', slug: 'ia', color: 'lilac', titulo: 'Uso de inteligencia artificial',
    resumen: 'Las herramientas, las cinco tareas en que ayudaron y lo que decidió el autor.' },
  { letra: 'F', slug: 'estados', color: 'peach', titulo: 'Estados del ciclo y wireframes',
    resumen: 'Los 35 estados del ciclo de agosto, con sus láminas, y los wireframes de las 39 pantallas de la app.' },
  { letra: 'G', slug: 'android', color: 'sky', titulo: 'Prototipo Android y registro de versiones',
    resumen: 'La app de la prueba, el Tag, los datos y el panel, y cada versión desde la 2.7 hasta la 4.6.3.' },
  { letra: 'H', slug: 'identidad', color: 'lime', titulo: 'Identidad visual y sistema de marca',
    resumen: 'El logo, las letras, los íconos y el color, cada uno con su fundamento, y las propuestas anteriores.' },
  { letra: 'I', slug: 'prueba', color: 'butter', titulo: 'Protocolo de la prueba, consentimiento e instrumentos',
    resumen: 'La prueba aplicada, el protocolo de 21 días, el consentimiento, las preguntas de la app y los instrumentos.' },
];

module.exports = { portada, anexos };
