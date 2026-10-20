// Arma la lámina «Wireframes de Relevo» (../wireframes-relevo.html) con los PNG de ../wireframes-png.
// Uso, desde esta carpeta, después de node exportar.js: node generar-lamina.js
const fs = require("fs");
global.window = {};
require("./pantallas.js");
const list = window.RELEVO_SCREENS;
const intros = window.RELEVO_GROUPS;
const esc = (t) => String(t).replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
const slug = (t) => t.normalize("NFD").replace(/[̀-ͯ]/g, "").toLowerCase().replace(/[^a-z0-9]+/g, "-").replace(/^-|-$/g, "");

const groups = [];
for (const s of list) {
  let g = groups.find((x) => x.name === s.group);
  if (!g) groups.push((g = { name: s.group, items: [] }));
  g.items.push(s);
}
let n = 0;
const sections = groups.map((g, gi) => `
  <section>
    <header class="group"><h2>${esc(g.name)}</h2><p>${esc(intros[g.name] || "")}</p><a href="wireframes-png/hojas/${gi + 1}-${slug(g.name)}.png">Hoja del recorrido en PNG</a></header>
    <ol class="flow">
${g.items.map((s) => { n++; return `      <li id="${s.id}">
        <a href="wireframes-png/${s.id}.png"><img src="wireframes-png/${s.id}.png" alt="Wireframe de «${esc(s.title)}»" loading="lazy" width="392" height="812"></a>
        <p class="num">${String(n).padStart(2, "0")}</p>
        <h3>${esc(s.title)}</h3>
        <p>${esc(s.note || "")}</p>
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
/* Lámina de wireframes de muy baja fidelidad: papel, tinta y gris, como los propios wireframes. */
:root { --paper: #F7F4F0; --card: #FFFFFF; --ink: #141312; --mute: #6B655F; --line: #E4DED6; --sans: "Instrument Sans", "Helvetica Neue", Arial, sans-serif; }
@media (prefers-color-scheme: dark) { :root:not([data-theme="light"]) { --paper: #161514; --card: #201E1C; --ink: #F3F0EC; --mute: #A9A29A; --line: #34302C; color-scheme: dark; } }
:root[data-theme="dark"] { --paper: #161514; --card: #201E1C; --ink: #F3F0EC; --mute: #A9A29A; --line: #34302C; color-scheme: dark; }
* { box-sizing: border-box; }
html, body { background: var(--paper); }
body { margin: 0; color: var(--ink); font-family: var(--sans); font-size: 15px; line-height: 1.5; -webkit-font-smoothing: antialiased; }
.wrap { max-width: 1400px; margin: 0 auto; padding-inline: 20px; padding-block: 44px 72px; }
h1 { font-size: clamp(34px, 5vw, 56px); line-height: 1.02; letter-spacing: -.03em; font-weight: 600; margin: 0; max-width: 20ch; text-wrap: balance; }
.lead { color: var(--mute); font-size: 17px; max-width: 72ch; margin: 14px 0 0; }
.legend { display: flex; flex-wrap: wrap; gap: 10px 22px; margin: 22px 0 0; padding: 0; list-style: none; color: var(--mute); font-size: 14px; }
.legend li { display: flex; align-items: center; gap: 8px; }
.sw { width: 34px; height: 18px; border-radius: 9px; display: inline-block; flex: none; }
.sw.dark { background: #1c1c1c; box-shadow: 0 0 0 1px var(--mute); } .sw.box { background: #fff; border: 1.5px solid #bdbdbd; }
.sw.on { background: #fff; border: 2px solid #1c1c1c; }
.sw.img { background: repeating-linear-gradient(45deg, #f2f2f2 0 4px, #e0e0e0 4px 5px); border: 1.5px dashed #bdbdbd; }
a { color: inherit; }
section { margin-top: 56px; }
.group { display: grid; gap: 4px; border-top: 1px solid var(--line); padding-top: 18px; }
.group h2 { margin: 0; font-size: 24px; letter-spacing: -.02em; font-weight: 600; }
.group p { margin: 0; color: var(--mute); max-width: 70ch; }
.group a { font-size: 14px; color: var(--mute); width: max-content; }
.flow { list-style: none; margin: 20px 0 0; padding: 0; display: grid; grid-template-columns: repeat(auto-fill, minmax(min(100%, 210px), 1fr)); gap: 26px 20px; }
.flow li { min-width: 0; }
.flow img { display: block; width: 100%; height: auto; max-width: 100%; aspect-ratio: 392 / 812; border-radius: 22px; background: #fff; }
.num { margin: 10px 0 0; font-size: 12px; color: var(--mute); font-variant-numeric: tabular-nums; letter-spacing: .04em; }
.flow h3 { margin: 2px 0 0; font-size: 16px; font-weight: 600; line-height: 1.3; }
.flow li > p:last-child { margin: 4px 0 0; color: var(--mute); font-size: 14px; }
.note { margin-top: 56px; background: var(--card); border-radius: 22px; padding: 20px 22px; color: var(--mute); max-width: 82ch; }
.note b { color: var(--ink); font-weight: 600; }
</style>
</head>
<body>
<main class="wrap">
  <h1>Wireframes de Relevo</h1>
  <p class="lead">Las ${list.length} pantallas de la app Android que usa el testeo (versión 2.32), en muy baja fidelidad: sin color, fotos ni marca, para mirar solo la estructura y el recorrido. Cada imagen abre su PNG a 3×, listo para imprimir o insertar.</p>
  <ul class="legend" aria-label="Cómo leer los wireframes">
    <li><span class="sw dark"></span>Acción principal u opción elegida</li>
    <li><span class="sw box"></span>Botón, fila, campo u opción</li>
    <li><span class="sw on"></span>Opción seleccionada</li>
    <li><span class="sw img"></span>Imagen o ilustración</li>
  </ul>
${sections}
  <p class="note"><b>Cómo se hicieron.</b> Los textos y el orden de cada pantalla salen del recorrido real de la 2.32 en el emulador, con un perfil de prueba y sin conexión (18 de octubre de 2026). Cada pantalla se dibujó con las mismas piezas, sobre una retícula de 360 × 780, en <code>generador/wireframes.html</code>; <code>generador/exportar.js</code> la exporta a PNG. Los datos de ejemplo («Nombre», «Leer 10 páginas», «XXXX») no son de ninguna persona. Las preguntas semanales y de cierre de la prueba no se dibujaron, porque la app solo las muestra con la prueba iniciada.</p>
</main>
</body>
</html>
`;
fs.writeFileSync("../wireframes-relevo.html", html);
console.log("ok " + n);
