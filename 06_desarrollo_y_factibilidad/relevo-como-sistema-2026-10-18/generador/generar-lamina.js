// Arma la lámina «Wireframes de Relevo» (../wireframes-relevo.html) con los SVG de ../wireframes.
// Uso, desde esta carpeta: node generar-lamina.js
const fs = require("fs");
const list = JSON.parse(fs.readFileSync("pantallas.json", "utf8"));
const notes = JSON.parse(fs.readFileSync("notas.json", "utf8"));
const esc = (t) => t.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");

const intros = {
  "Primera vez": "Se ven una sola vez: presentan la idea, piden el consentimiento y los permisos, y arman el perfil y la ruta.",
  "Preparar un relevo": "El corazón de la app: seis pasos para pasar de una intención a una condición que suena en un lugar.",
  "Contar, sonar y decidir": "Lo que pasa después de activar: la app cuenta, la señal suena y la persona cuenta qué decidió.",
  "Inicio, Ruta y Perfil": "Las tres pestañas de la app.",
  "Perfil": "Ajustes, datos, ayuda y la configuración de la prueba.",
};
const groups = [];
for (const s of list) {
  let g = groups.find((x) => x.name === s.group);
  if (!g) groups.push((g = { name: s.group, items: [] }));
  g.items.push(s);
}
let n = 0;
const sections = groups.map((g) => `
  <section>
    <header class="group"><h2>${esc(g.name)}</h2><p>${esc(intros[g.name] || "")}</p></header>
    <ol class="flow">
${g.items.map((s) => { n++; return `      <li id="${s.id}">
        <img src="wireframes/${s.id}.svg" alt="Wireframe de «${esc(s.title)}»" loading="lazy" width="360" height="800">
        <p class="num">${String(n).padStart(2, "0")}</p>
        <h3>${esc(s.title)}</h3>
        <p>${esc(notes[s.id] || "")}</p>
      </li>`; }).join("\n")}
    </ol>
  </section>`).join("\n");

const html = `<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<title>Wireframes de Relevo</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Instrument+Sans:wght@400..700&display=swap">
<style>
/* Lámina de wireframes de muy baja fidelidad: papel, tinta y cajas grises, como los propios wireframes. */
:root { --paper: #F7F4F0; --card: #FFFFFF; --ink: #141312; --mute: #6B655F; --line: #E4DED6; --sans: "Instrument Sans", "Helvetica Neue", Arial, sans-serif; }
@media (prefers-color-scheme: dark) { :root:not([data-theme="light"]) { --paper: #161514; --card: #201E1C; --ink: #F3F0EC; --mute: #A9A29A; --line: #34302C; color-scheme: dark; } }
:root[data-theme="dark"] { --paper: #161514; --card: #201E1C; --ink: #F3F0EC; --mute: #A9A29A; --line: #34302C; color-scheme: dark; }
* { box-sizing: border-box; }
html, body { background: var(--paper); }
body { margin: 0; color: var(--ink); font-family: var(--sans); font-size: 15px; line-height: 1.5; -webkit-font-smoothing: antialiased; }
.wrap { max-width: 1400px; margin: 0 auto; padding-inline: 20px; padding-block: 44px 72px; }
h1 { font-size: clamp(34px, 5vw, 56px); line-height: 1.02; letter-spacing: -.03em; font-weight: 600; margin: 0; max-width: 20ch; text-wrap: balance; }
.lead { color: var(--mute); font-size: 17px; max-width: 70ch; margin: 14px 0 0; }
.legend { display: flex; flex-wrap: wrap; gap: 10px 22px; margin: 22px 0 0; padding: 0; list-style: none; color: var(--mute); font-size: 14px; }
.legend li { display: flex; align-items: center; gap: 8px; }
.sw { width: 34px; height: 18px; border-radius: 9px; display: inline-block; }
.sw.dark { background: #2b2b2b; box-shadow: 0 0 0 1px var(--mute); } .sw.box { background: #fff; border: 1px solid #8a8a8a; }
.sw.img { background: repeating-linear-gradient(45deg, #efefef 0 4px, #d6d6d6 4px 5px); border: 1px dashed #8a8a8a; }
.sw.text { height: 6px; width: 34px; background: #d6d6d6; border-radius: 3px; }
section { margin-top: 56px; }
.group { display: grid; gap: 4px; border-top: 1px solid var(--line); padding-top: 18px; }
.group h2 { margin: 0; font-size: 24px; letter-spacing: -.02em; font-weight: 600; }
.group p { margin: 0; color: var(--mute); max-width: 70ch; }
.flow { list-style: none; margin: 20px 0 0; padding: 0; display: grid; grid-template-columns: repeat(auto-fill, minmax(min(100%, 210px), 1fr)); gap: 26px 20px; }
.flow li { min-width: 0; position: relative; }
.flow img { display: block; width: 100%; height: auto; max-width: 100%; aspect-ratio: 360 / 800; background: #fff; border-radius: 26px; box-shadow: 0 1px 2px rgba(20,19,18,.06), 0 16px 34px -26px rgba(20,19,18,.35); }
.num { margin: 12px 0 0; font-size: 12px; color: var(--mute); font-variant-numeric: tabular-nums; letter-spacing: .04em; }
.flow h3 { margin: 2px 0 0; font-size: 16px; font-weight: 600; line-height: 1.3; }
.flow li > p:last-child { margin: 4px 0 0; color: var(--mute); font-size: 14px; }
.note { margin-top: 56px; background: var(--card); border-radius: 22px; padding: 20px 22px; color: var(--mute); max-width: 82ch; }
.note b { color: var(--ink); font-weight: 600; }
</style>
</head>
<body>
<main class="wrap">
  <h1>Wireframes de Relevo</h1>
  <p class="lead">Las ${list.length} pantallas de la app Android que usa el testeo (versión 2.32), en muy baja fidelidad. Se dibujaron a partir de la posición real de cada elemento en el emulador, sin color, fotos ni marca, para mirar solo la estructura y el recorrido.</p>
  <ul class="legend" aria-label="Cómo leer los wireframes">
    <li><span class="sw dark"></span>Acción principal</li>
    <li><span class="sw box"></span>Botón, fila u opción que se toca</li>
    <li><span class="sw img"></span>Imagen o ilustración</li>
    <li><span class="sw text"></span>Párrafo</li>
  </ul>
${sections}
  <p class="note"><b>Cómo se hicieron.</b> Cada pantalla se recorrió en el emulador con un perfil de prueba y sin conexión, y se guardó su árbol de elementos con <code>uiautomator</code>. El script <code>generador/generar-wireframes.js</code> lo convierte en SVG. La 3.2 tiene las mismas pantallas con otra composición visual. Las preguntas semanales y de cierre de la prueba no se dibujaron, porque solo aparecen al pasar los días de la prueba.</p>
</main>
</body>
</html>
`;
fs.writeFileSync("../wireframes-relevo.html", html);
console.log("ok " + n);
