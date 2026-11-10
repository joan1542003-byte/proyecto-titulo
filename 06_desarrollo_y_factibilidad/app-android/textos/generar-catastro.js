// Genera catastro-de-palabras-clave.md desde Catastro.kt, para que el documento diga lo mismo que la app.
// Uso, desde esta carpeta: node generar-catastro.js
const fs = require("fs");
const path = require("path");
const src = path.join(__dirname, "../app/src/main/java/com/example/relevo/ui/Catastro.kt");
const out = path.join(__dirname, "catastro-de-palabras-clave.md");
const kt = fs.readFileSync(src, "utf8").replace(/\r\n/g, "\n");
const body = kt.slice(kt.indexOf("internal val catastro"), kt.indexOf("\n)\n\nprivate class Prepared"));

const families = { Moverte: [], "Leer y aprender": [], Crear: [], "Jugar y disfrutar": [], "En casa": [], Descansar: [], "Con otras personas": [] };
let family = null;
const list = key => block => { const m = block.match(new RegExp(`\\b${key} = listOf\\(([\\s\\S]*?)\\),\\n`)); return m ? [...m[1].matchAll(/"([^"]+)"/g)].map(x => x[1]) : []; };
const lines = body.split("\n");
let current = null;
for (let i = 0; i < lines.length; i++) {
  const fam = lines[i].match(/^  \/\/ (.+)$/);
  if (fam && families[fam[1]]) { family = fam[1]; continue; }
  if (lines[i] === "  Concept(") { current = { start: i }; continue; }
  if (current && lines[i] === "  ),") {
    const block = lines.slice(current.start, i + 1).join("\n") + "\n";
    const head = block.match(/\n\s+"([^"]+)", KitIcon\.([A-Z_]+),/);
    families[family].push({
      id: head[1], icon: head[2],
      words: list("words")(block), phrases: list("phrases")(block), weak: list("weak")(block),
      starts: list("starts")(block), places: list("places")(block),
    });
    current = null;
  }
}
const all = Object.values(families).flat();
const count = k => all.reduce((n, c) => n + c[k].length, 0);
const fmt = xs => xs.length ? xs.map(x => `«${x}»`).join(", ") : "—";
const word = w => w.endsWith("*") ? `«${w.slice(0, -1)}…» (y lo que siga)` : `«${w}»`;

let md = `# Catastro de palabras clave

**Qué es:** las palabras y frases con que la app reconoce una actividad que la persona escribe al crear un relevo propio, y lo que le sugiere después: con qué empezar y dónde dejar el Tag. **Fuente:** [\`Catastro.kt\`](../app/src/main/java/com/example/relevo/ui/Catastro.kt). Este documento se genera desde ese archivo con \`node generar-catastro.js\`, así que dice lo mismo que la app. **Versión:** 4.5 (D-163).

## En números

- **${all.length} conceptos** en siete familias.
- **${count("words")} palabras**, **${count("phrases")} frases** y **${count("weak")} palabras débiles**.
- **${count("starts")} primeros pasos** y **${count("places")} lugares** sugeridos.

## Cómo reconoce una actividad

1. **Se normaliza el texto:** minúsculas y sin tildes, así «Película» y «pelicula» son lo mismo.
2. **Cada palabra se compara entera.** Las que terminan en «…» valen también con lo que siga: «dibuj…» reconoce dibujar, dibujo y dibujando.
3. **Puntos por concepto:**
   - cada palabra suma 1;
   - cada frase completa suma 2;
   - cada palabra débil suma medio punto, porque sola no decide, como «ver», «jugar» o «tocar».
4. **Gana el concepto con más puntos, si suma al menos 1.** Ante un empate, gana el que va primero en la lista.
5. **Si nada suma 1,** la app no sugiere nada y muestra un ejemplo en el campo.

Las frases resuelven los casos dudosos:
- «Maratón de series» es de películas y no de correr.
- «Leer una novela gráfica» es de manga y no de leer.
- «Dar una vuelta en bici» es de bicicleta y no de caminar.

Ninguna palabra pertenece a dos conceptos.

## Conceptos

`;
for (const [fam, concepts] of Object.entries(families)) {
  md += `### ${fam}\n\n`;
  for (const c of concepts) {
    md += `#### ${c.id} · ícono ${c.icon.toLowerCase().replace(/_/g, " ")}\n\n`;
    md += `- **Palabras (${c.words.length}):** ${c.words.map(word).join(", ")}.\n`;
    md += `- **Frases (${c.phrases.length}):** ${fmt(c.phrases)}.\n`;
    if (c.weak.length) md += `- **Palabras débiles:** ${fmt(c.weak)}.\n`;
    md += `- **Con qué empezar:** ${fmt(c.starts)}.\n`;
    md += `- **Dónde:** ${fmt(c.places)}.\n\n`;
  }
}
md += `## Para sumar palabras

1. Agregar la palabra en minúsculas y sin tildes a \`words\`, o la frase a \`phrases\`, del concepto en \`Catastro.kt\`.
2. Si la palabra también puede ser de otra actividad («clase», «jugar»), va en \`weak\`.
3. Comprobar que no esté en otro concepto, sumar un caso a \`CatastroTest.kt\` y volver a generar este documento.

## Registro de cambios (disclaimer)

### 2026-11-06 — Creación (4.5, D-163)

- **Qué cambió:** se documentan todas las palabras, frases, palabras débiles, primeros pasos y lugares del catastro, generados desde el código.
- **Cómo estaba antes:** el catastro de la 4.3 tenía 322 palabras, 20 frases y 21 palabras débiles, y solo se podía leer en el código.
- **Por qué:** el autor pidió más palabras y frases clave para los relevos personalizados, y documentarlas todas.
`;
fs.writeFileSync(out, md);
console.log(`ok: ${all.length} conceptos, ${count("words")} palabras, ${count("phrases")} frases, ${count("weak")} débiles`);
