// Wireframes de muy baja fidelidad de Relevo, a partir del árbol de cada pantalla (uiautomator).
// Uso, desde esta carpeta: node generar-wireframes.js arbol ../wireframes pantallas.json
// «arbol» guarda el árbol de cada pantalla de la app 2.32, capturado con «adb shell uiautomator dump» en el
// emulador, con un perfil de prueba y sin conexión. Cada elemento tocable se dibuja como caja, cada imagen
// como caja con una X, los textos breves se escriben y los párrafos se vuelven líneas grises.
const fs = require("fs");
const path = require("path");
const [xmlDir, outDir, specFile] = process.argv.slice(2);
const screens = JSON.parse(fs.readFileSync(specFile, "utf8"));
fs.mkdirSync(outDir, { recursive: true });

const S = 3; // 1080 px del emulador → 360 de ancho
const W = 360, H = 800;
const INK = "#2b2b2b", MID = "#8a8a8a", LIGHT = "#d6d6d6", FILL = "#efefef", PAPER = "#ffffff";
const esc = (t) => t.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;");
const decode = (t) => t.replace(/&quot;/g, '"').replace(/&apos;/g, "'").replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&amp;/g, "&").replace(/&#10;/g, " ");

function parse(xml) {
  const nodes = [];
  const re = /<node ([^>]*?)\/?>/g;
  let m;
  while ((m = re.exec(xml))) {
    const a = {};
    for (const [, k, v] of m[1].matchAll(/([\w-]+)="([^"]*)"/g)) a[k] = decode(v);
    const b = (a.bounds || "").match(/\[(\d+),(\d+)\]\[(\d+),(\d+)\]/);
    if (!b) continue;
    const [x1, y1, x2, y2] = b.slice(1).map(Number);
    nodes.push({ text: a.text || "", desc: a["content-desc"] || "", click: a.clickable === "true", cls: a.class || "", pkg: a.package || "",
      x: x1 / S, y: y1 / S, w: (x2 - x1) / S, h: (y2 - y1) / S, checked: a.checked === "true", sel: a.selected === "true" });
  }
  return nodes;
}

const xbox = (x, y, w, h, r = 14) => `<g><rect x="${x}" y="${y}" width="${w}" height="${h}" rx="${r}" fill="${FILL}" stroke="${MID}" stroke-dasharray="4 3"/><line x1="${x + 8}" y1="${y + 8}" x2="${x + w - 8}" y2="${y + h - 8}" stroke="${LIGHT}"/><line x1="${x + w - 8}" y1="${y + 8}" x2="${x + 8}" y2="${y + h - 8}" stroke="${LIGHT}"/></g>`;
function wrapLines(n, lineH) { return Math.max(1, Math.round(n.h / lineH)); }

function render(screen) {
  const xml = fs.readFileSync(path.join(xmlDir, screen.file + ".xml"), "utf8");
  let nodes = parse(xml).filter((n) => n.w > 2 && n.h > 2 && n.y < H && n.pkg !== "com.android.systemui");
  const out = [];
  const crop = screen.crop || 0; // px del emulador que se ocultan arriba al desplazar
  const replace = screen.replace || {};
  for (const [x, y, w, h] of screen.img || []) out.push(xbox(x, y, w, h, y === 0 ? 0 : 14));
  // Cajas: elementos tocables (botones, filas, tarjetas). Se dibujan primero, de mayor a menor.
  const clickables = nodes.filter((n) => n.click && n.w * n.h > 300 && !(n.w >= W - 2 && n.h >= H - 40));
  clickables.sort((a, b) => b.w * b.h - a.w * a.h);
  const texts = nodes.filter((n) => n.text.trim());
  const textInside = (c) => texts.filter((t) => t.x >= c.x - 1 && t.y >= c.y - 1 && t.x + t.w <= c.x + c.w + 1 && t.y + t.h <= c.y + c.h + 1);
  const primaryWords = screen.primary || [];
  for (const c of clickables) {
    const inner = textInside(c).map((t) => t.text.trim());
    const isPrimary = inner.some((t) => primaryWords.includes(t));
    const r = Math.min(c.h / 2, 16);
    if (isPrimary) out.push(`<rect x="${c.x}" y="${c.y}" width="${c.w}" height="${c.h}" rx="${r}" fill="${INK}"/>`);
    else out.push(`<rect x="${c.x}" y="${c.y}" width="${c.w}" height="${c.h}" rx="${r}" fill="${c.w > 200 ? PAPER : FILL}" stroke="${MID}" stroke-width="1"/>`);
    c.primary = isPrimary;
    if (!isPrimary && c.w > 200 && c.h > 150) {
      const top = Math.min(...textInside(c).map((t) => t.y), c.y + c.h);
      if (top - c.y > 70) out.push(xbox(c.x + 8, c.y + 8, c.w - 16, top - c.y - 16));
    }
  }
  // Imágenes e íconos: nodos con descripción y sin texto propio que no son tocables.
  const seen = new Set();
  for (const n of nodes) {
    if (n.text.trim() || !n.desc.trim() || n.click) continue;
    if (texts.some((t) => t.text.trim() === n.desc.trim() && Math.abs(t.y - n.y) < 40 && Math.abs(t.x - n.x) < 200)) continue;
    const key = [Math.round(n.x), Math.round(n.y), Math.round(n.w)].join(",");
    if (seen.has(key)) continue; seen.add(key);
    if (/^Paso \d+ de \d+$/.test(n.desc) || n.desc === "Volver" || n.desc === "Cerrar" || n.desc === "Cancelar") continue;
    // Un ícono dentro de un botón principal no se dibuja: el botón ya es oscuro.
    if (clickables.some((c) => c.primary && n.x >= c.x - 1 && n.y >= c.y - 1 && n.x + n.w <= c.x + c.w + 1 && n.y + n.h <= c.y + c.h + 1)) continue;
    if (n.w > 120 && n.h > 80) {
      out.push(`<g><rect x="${n.x}" y="${n.y}" width="${n.w}" height="${n.h}" rx="14" fill="${FILL}" stroke="${MID}" stroke-dasharray="4 3"/>` +
        `<line x1="${n.x + 8}" y1="${n.y + 8}" x2="${n.x + n.w - 8}" y2="${n.y + n.h - 8}" stroke="${LIGHT}"/><line x1="${n.x + n.w - 8}" y1="${n.y + 8}" x2="${n.x + 8}" y2="${n.y + n.h - 8}" stroke="${LIGHT}"/></g>`);
    } else if (n.w <= 120) {
      const d = Math.min(n.w, n.h, 40);
      out.push(`<circle cx="${n.x + n.w / 2}" cy="${n.y + n.h / 2}" r="${d / 2.4}" fill="${FILL}" stroke="${MID}"/>`);
    }
  }
  // Textos: cortos se escriben; largos se dibujan como líneas grises.
  const done = new Set();
  for (const t of texts) {
    let label = t.text.trim().replace(/\s+/g, " ");
    if (replace[label] !== undefined) label = replace[label];
    const key = label + "|" + Math.round(t.y);
    if (done.has(key)) continue; done.add(key);
    const parent = clickables.find((c) => t.x >= c.x - 1 && t.y >= c.y - 1 && t.x + t.w <= c.x + c.w + 1 && t.y + t.h <= c.y + c.h + 1);
    const onDark = parent && parent.primary;
    // Párrafos (más de 60 caracteres): líneas grises, una por renglón aproximado.
    if (label.length > 60) {
      const n = Math.max(2, Math.min(8, Math.round(t.h / 16)));
      for (let i = 0; i < n; i++) {
        const lw = i === n - 1 ? t.w * 0.62 : t.w;
        out.push(`<rect x="${t.x}" y="${t.y + i * (t.h / n) + (t.h / n) * 0.3}" width="${lw}" height="${Math.max(4, (t.h / n) * 0.36)}" rx="2" fill="${onDark ? "#9a9a9a" : LIGHT}"/>`);
      }
      continue;
    }
    // Textos breves: se escriben, en 1 a 3 renglones, con el tamaño que llena su caja.
    const words = label.split(" ");
    let best = null;
    for (let k = 1; k <= Math.min(3, words.length); k++) {
      const per = Math.ceil(label.length / k);
      const s = Math.min((t.h / k) * 0.74, t.w / (per * 0.56));
      if (!best || s > best.s + 0.3) best = { k, s };
    }
    const size = Math.max(8.5, Math.min(30, best.s));
    // Reparte las palabras en k renglones parejos.
    const rows = [];
    let row = "";
    const target = label.length / best.k;
    for (const w of words) {
      if (row && (row + " " + w).length > target + 3 && rows.length < best.k - 1) { rows.push(row); row = w; } else row = row ? row + " " + w : w;
    }
    rows.push(row);
    const weight = size >= 16 || parent ? 700 : 400;
    const anchorCenter = parent && Math.abs(t.x + t.w / 2 - (parent.x + parent.w / 2)) < 6 && t.w < parent.w * 0.8;
    const x = anchorCenter ? t.x + t.w / 2 : t.x;
    const ta = anchorCenter ? ' text-anchor="middle"' : "";
    const fill = onDark ? PAPER : (weight === 700 ? INK : "#555");
    const lh = t.h / rows.length;
    rows.forEach((r, i) => out.push(`<text x="${x}" y="${t.y + lh * (i + 0.5)}" dominant-baseline="central" font-size="${size.toFixed(1)}" font-weight="${weight}" fill="${fill}"${ta}>${esc(r)}</text>`));
  }
  // Avance «Paso N de M»: barra en segmentos.
  for (const n of nodes) {
    const m = n.desc.match(/^Paso (\d+) de (\d+)$/);
    if (!m) continue;
    const [k, total] = [Number(m[1]), Number(m[2])];
    const gap = 4, segW = (n.w - gap * (total - 1)) / total, y = n.y + n.h / 2 - 2.5;
    for (let i = 0; i < total; i++) out.push(`<rect x="${n.x + i * (segW + gap)}" y="${y}" width="${segW}" height="5" rx="2.5" fill="${i < k ? INK : LIGHT}"/>`);
  }
  const shift = crop / S;
  const body = out.join("\n");
  const notes = (screen.notes || []).map((n, i) => n);
  const svg = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 ${W} ${H}" width="${W}" height="${H}" font-family="Helvetica, Arial, sans-serif">
<title>${esc(screen.title)}</title>
<rect x="0.5" y="0.5" width="${W - 1}" height="${H - 1}" rx="28" fill="${PAPER}" stroke="${INK}" stroke-width="1.5"/>
<clipPath id="c"><rect x="0" y="0" width="${W}" height="${H}" rx="28"/></clipPath>
<g clip-path="url(#c)">
<g transform="translate(0 ${-shift})">
${body}
</g>
<rect x="0" y="0" width="${W}" height="24" fill="${PAPER}"/>
<rect x="18" y="9" width="30" height="6" rx="3" fill="${LIGHT}"/><rect x="${W - 54}" y="9" width="36" height="6" rx="3" fill="${LIGHT}"/>
<rect x="${W / 2 - 50}" y="${H - 12}" width="100" height="4" rx="2" fill="${MID}"/>
</g>
</svg>`;
  fs.writeFileSync(path.join(outDir, screen.id + ".svg"), svg);
  return svg;
}

for (const s of screens) render(s);
console.log("ok " + screens.length);
