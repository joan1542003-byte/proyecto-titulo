// Exporta los wireframes de Relevo a PNG con Chrome sin ventana.
// Uso, desde esta carpeta: node exportar.js
// - ../wireframes-png/NN-pantalla.png: cada pantalla, a 3× (1176 × 2436 px), para imprimir o insertar.
// - ../wireframes-png/hojas/N-recorrido.png: cada recorrido en una hoja, con título y nota por pantalla, a 2×.
// Necesita Google Chrome. Otra ruta se indica con la variable CHROME.
const fs = require("fs");
const path = require("path");
const { execFileSync } = require("child_process");

const here = __dirname;
const chrome = process.env.CHROME || [
  "C:/Program Files/Google/Chrome/Application/chrome.exe",
  "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome",
  "/usr/bin/google-chrome",
].find((p) => fs.existsSync(p));
if (!chrome) throw new Error("No se encontró Chrome; indica su ruta en la variable CHROME.");

global.window = {};
require(path.join(here, "pantallas.js"));
const screens = window.RELEVO_SCREENS;
const groups = [...new Set(screens.map((s) => s.group))];
const url = "file:///" + path.join(here, "wireframes.html").replace(/\\/g, "/");
const out = path.join(here, "..", "wireframes-png");
fs.mkdirSync(path.join(out, "hojas"), { recursive: true });

function shot(file, query, width, height, scale) {
  execFileSync(chrome, ["--headless=new", "--disable-gpu", "--allow-file-access-from-files", "--hide-scrollbars",
    `--window-size=${width},${height}`, `--force-device-scale-factor=${scale}`, "--virtual-time-budget=3000",
    `--screenshot=${file}`, `${url}?${query}`], { stdio: "ignore" });
}

for (const s of screens) shot(path.join(out, `${s.id}.png`), `s=${encodeURIComponent(s.id)}`, 392, 812, 3);

const slug = (t) => t.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase().replace(/[^a-z0-9]+/g, "-").replace(/^-|-$/g, "");
groups.forEach((g, i) => {
  const n = screens.filter((s) => s.group === g).length;
  const cols = Math.min(n, 6), rows = Math.ceil(n / cols);
  shot(path.join(out, "hojas", `${i + 1}-${slug(g)}.png`), `g=${encodeURIComponent(g)}&cols=${cols}`, cols * 392, 110 + rows * 930, 2);
});
console.log(`ok: ${screens.length} pantallas y ${groups.length} hojas en ${out}`);
