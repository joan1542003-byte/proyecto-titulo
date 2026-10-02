// Piezas comunes para las aplicaciones 3.1: colores, letras, logotipo, símbolo, íconos y campos de trama.
const fs = require('fs');
const path = require('path');
const PAL = require('./palette.json');
const G = require('./out/logo-geometry.json');
const ICONS = require('./build/bundle-icons31.json');

const C = {
  ink: '#17181C', paper: '#F2F2EF', card: '#FCFCFA', white: '#FFFFFF', graphite: '#5B5F68', mist: '#E6E6E1',
  blue: '#3D38F5', blue700: '#1F1BB4', blue300: '#9A97FF', blue200: '#C4C2FC', blue50: '#ECEBFE', blueDots: '#5652F7',
};
// Categorías de actividad (doc 23) con su familia, nombre en la app, ícono e ilustración.
const CAT = {
  leer: { fam: 'mostaza', name: 'Leer', icon: 'leer', illus: 'leer-sillon' },
  crear: { fam: 'arcilla', name: 'Crear con las manos', icon: 'pintar', illus: 'crear-mesa' },
  cuidar: { fam: 'salvia', name: 'Cuidar la casa y a mí', icon: 'plantas', illus: 'cuidar-ventana' },
  moverme: { fam: 'terracota', name: 'Moverme', icon: 'caminar', illus: 'moverme-puerta' },
  compartir: { fam: 'ciruela', name: 'Con otras personas', icon: 'juego-de-mesa', illus: 'compartir-juego' },
  aprender: { fam: 'pizarra', name: 'Aprender algo', icon: 'estudiar', illus: 'aprender-escritorio' },
};
const step = (fam, k) => PAL[fam].steps[k].hex;
const sig = (fam) => PAL[fam].steps[PAL[fam].sig].hex;
const r1 = (v) => Math.round(v * 10) / 10;

// Logotipo: h = alto de la «l» en px.
function wordmark({ h = 40, ink = C.ink, line = C.blue, compact = false, extra = '' } = {}) {
  const lw = compact ? G.W.right : G.LINE.w;
  const vbh = G.G.asc + G.LINE.y + G.LINE.h, k = h / G.G.asc;
  return `<svg class="wm" ${extra} viewBox="0 ${-G.G.asc} ${lw} ${vbh}" width="${r1(lw * k)}" height="${r1(vbh * k)}" role="img" aria-label="relevo"><rect x="0" y="${G.LINE.y}" width="${lw}" height="${G.LINE.h}" rx="${G.LINE.h / 2}" fill="${line}"/><path fill="${ink}" d="${G.wordPath}"/></svg>`;
}
// Símbolo: la «r» y su renglón; h = altura de x en px.
function symbol({ h = 40, ink = C.ink, line = C.blue } = {}) {
  const S = G.SYM, hh = S.bottom - S.top, k = h / -S.top;
  return `<svg class="sym" viewBox="0 ${S.top} ${S.lineW} ${hh}" width="${r1(S.lineW * k)}" height="${r1(hh * k)}" role="img" aria-label="relevo"><rect x="0" y="130" width="${S.lineW}" height="${G.LINE.h}" rx="${G.LINE.h / 2}" fill="${line}"/><path fill="${ink}" d="${G.rPath}"/></svg>`;
}
// Ícono de la app (caja de 512).
function appIcon({ size = 96, bg = C.blue, ink = C.white, line = C.white, round = false, dots = false } = {}) {
  const S = G.SYM, k = (512 * 0.62) / S.lineW, w = S.lineW * k, hh = (S.bottom - S.top) * k;
  const tx = (512 - w) / 2, ty = (512 - hh) / 2 - S.top * k - 6;
  let d = '';
  if (dots) {
    const p = 512 / 22;
    for (let j = 0; j < 22; j++) for (let i = 0; i < 22; i++) { const v = Math.max(0, Math.min(1, (i + j) / 42 - 0.15)); d += `<circle cx="${r1(i * p + p / 2)}" cy="${r1(j * p + p / 2)}" r="${r1(p * 0.5 * (0.18 + 0.82 * v ** 1.4))}"/>`; }
    d = `<g clip-path="url(#ai${size})" fill="${C.blueDots}">${d}</g>`;
  }
  return `<svg viewBox="0 0 512 512" width="${size}" height="${size}"><defs><clipPath id="ai${size}"><rect width="512" height="512" rx="${round ? 256 : 114}"/></clipPath></defs><rect width="512" height="512" rx="${round ? 256 : 114}" fill="${bg}"/>${d}<g transform="translate(${r1(tx)} ${r1(ty)}) scale(${k.toFixed(5)})"><rect x="0" y="130" width="${S.lineW}" height="${G.LINE.h}" rx="${G.LINE.h / 2}" fill="${line}"/><path fill="${ink}" d="${G.rPath}"/></g></svg>`;
}
// Íconos del kit (formato del bundle): s = trazo, i = relleno, a = acento, b = recorte.
let uid = 0;
function icon(name, { size = 24, color = C.ink, accent = C.blue, sw } = {}) {
  const parts = ICONS[name];
  if (!parts) throw new Error('Ícono no existe: ' + name);
  const w = sw ?? (size <= 16 ? 1.9 : size <= 20 ? 1.8 : size <= 24 ? 1.75 : size <= 32 ? 1.6 : 1.5);
  let body = '', defs = '';
  parts.forEach(([d, f]) => {
    const col = f.includes('a') ? accent : color;
    if (f.includes('b')) {
      const id = 'm' + (++uid);
      defs += `<mask id="${id}" maskUnits="userSpaceOnUse" x="-2" y="-2" width="28" height="28"><rect x="-2" y="-2" width="28" height="28" fill="#fff"/><path d="${d}" fill="#000"/></mask>`;
      body = `<g mask="url(#${id})">${body}</g>`;
      if (f.includes('s')) body += `<path d="${d}" fill="none" stroke="${col}"/>`;
      return;
    }
    body += `<path d="${d}" fill="${f.includes('i') ? col : 'none'}" stroke="${f.includes('s') ? col : 'none'}"/>`;
  });
  return `<svg viewBox="0 0 24 24" width="${size}" height="${size}" fill="none" stroke-width="${w}" stroke-linecap="round" stroke-linejoin="round">${defs ? `<defs>${defs}</defs>` : ''}${body}</svg>`;
}
// Campo de trama: puntos en retícula que crecen con el valor del campo (mismas ondas de la lámina v3).
function fieldValue(nx, ny, seed) {
  const a = Math.sin((nx * 1.5 + ny * 0.8) * 3.6 + seed), b = Math.sin((-nx * 0.7 + ny * 1.6) * 3.3 + 1.3 + seed * 0.7), c = Math.sin((nx * 2.1 - ny * 0.6) * 2.8 + 2.1 + seed * 0.4);
  return 1 / (1 + Math.exp(-3.4 * (a * 0.55 + b * 0.35 + c * 0.2 + 0.35)));
}
const hexRgb = (h) => [1, 3, 5].map((i) => parseInt(h.slice(i, i + 2), 16));
const mix = (a, b, t) => '#' + hexRgb(a).map((v, i) => Math.round(v + (hexRgb(b)[i] - v) * t).toString(16).padStart(2, '0')).join('');
// mode: 'campo' (ondas, dos tonos) o 'gradiente' (crece hacia abajo a la derecha, una tinta).
function trama({ w, h, pitch = 14, mode = 'campo', light = C.blue200, deep = C.blue, seed = 0.4, bg = null, angle = 0.35, min = 0.16 }) {
  const cols = Math.ceil(w / pitch), rows = Math.ceil(h / pitch);
  const groups = new Map();
  for (let j = 0; j < rows; j++) for (let i = 0; i < cols; i++) {
    let v;
    if (mode === 'gradiente') v = Math.max(0, Math.min(1, ((i / cols) * angle + (j / rows) * (1 - angle)) * 1.15 - 0.1 + 0.08 * Math.sin(i * 0.9 + j * 1.3)));
    else v = fieldValue(i / cols, j / rows, seed);
    if (v < min) continue;
    const col = mode === 'gradiente' ? deep : mix(light, deep, Math.round(v * 6) / 6);
    const rr = r1(Math.min(pitch * 0.54, pitch * 0.5 * (0.2 + 0.85 * v)));
    if (!groups.has(col)) groups.set(col, []);
    groups.get(col).push(`<circle cx="${r1(i * pitch + pitch / 2)}" cy="${r1(j * pitch + pitch / 2)}" r="${rr}"/>`);
  }
  let s = `<svg class="trama" viewBox="0 0 ${w} ${h}" width="${w}" height="${h}">${bg ? `<rect width="${w}" height="${h}" fill="${bg}"/>` : ''}`;
  for (const [c, d] of groups) s += `<g fill="${c}">${d.join('')}</g>`;
  return s + '</svg>';
}
// Ilustración en línea (SVG de out/Ilustraciones).
function illus(name, width) {
  const s = fs.readFileSync(path.join(__dirname, 'out', 'Ilustraciones', name + '.svg'), 'utf8');
  return s.replace(/width="640" height="480"/, `width="${width}" height="${r1((width * 480) / 640)}"`).replace(/<title>.*?<\/title>/, '');
}

// Página: letras, colores y un guion que ubica los renglones bajo la línea base (0,14 em, 0,09 em de grosor).
function page(w, h, body, css = '', bg = C.paper) {
  return `<!doctype html><html lang="es"><head><meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Newsreader:ital,opsz,wght@0,6..72,200..800;1,6..72,200..800&family=IBM+Plex+Mono:wght@300;400;500&display=block" rel="stylesheet">
<style>
@font-face{font-family:"Schibsted Grotesk";src:url(../schibsted.ttf);font-weight:400 900}
*{box-sizing:border-box;margin:0;padding:0}
html,body{width:${w}px;height:${h}px;overflow:hidden}
body{background:${bg};color:${C.ink};font-family:"Schibsted Grotesk";font-weight:400;-webkit-font-smoothing:antialiased;position:relative;font-kerning:normal}
.serif{font-family:Newsreader;font-weight:380;letter-spacing:-.015em;font-optical-sizing:auto}
.voz{font-family:Newsreader;font-style:italic;font-weight:400;letter-spacing:-.01em}
.mono{font-family:"IBM Plex Mono";font-weight:300;letter-spacing:0}
.grafito{color:${C.graphite}}
.abs{position:absolute}
.rg{position:relative;display:inline-block;white-space:nowrap}
.rg>.ln{position:absolute;left:0;border-radius:999px;background:var(--line,${C.blue})}
.rg>.bl{display:inline-block;width:0;height:0}
svg{display:block}
${css}
</style></head><body>${body}
<script>
window.__layout = () => {
  // Ajusta el tamaño de los textos .fit hasta que quepan en su ancho.
  for (const el of document.querySelectorAll('.fit')) {
    const max = +el.dataset.max; let fs = parseFloat(getComputedStyle(el).fontSize);
    while (el.scrollWidth > max && fs > 20) { fs -= 2; el.style.fontSize = fs + 'px'; }
  }
  for (const el of document.querySelectorAll('[data-same]')) el.style.fontSize = getComputedStyle(document.querySelector(el.dataset.same)).fontSize;
  // Renglón: grosor 0,09 em, a 0,14 em bajo la línea base; data-bleed lo lleva hasta el borde derecho.
  for (const el of document.querySelectorAll('.rg')) {
    let bl = el.querySelector(':scope>.bl'); if (!bl) { bl = document.createElement('i'); bl.className = 'bl'; el.appendChild(bl); }
    let ln = el.querySelector(':scope>.ln'); if (!ln) { ln = document.createElement('b'); ln.className = 'ln'; el.appendChild(ln); }
    const em = parseFloat(getComputedStyle(el).fontSize);
    const k = el.dataset.k ? +el.dataset.k : 0.09, off = el.dataset.off ? +el.dataset.off : 0.14;
    const base = bl.offsetTop;
    ln.style.top = (base + off * em) + 'px'; ln.style.height = Math.max(2, k * em) + 'px';
    const r = el.getBoundingClientRect();
    if (el.dataset.bleed) { ln.style.width = (document.body.clientWidth - r.left + 40) + 'px'; ln.style.borderRadius = '999px 0 0 999px'; }
    else ln.style.width = (el.dataset.w ? el.dataset.w : r.width) + 'px';
  }
  return true;
};
</script></body></html>`;
}
module.exports = { C, CAT, PAL, G, step, sig, wordmark, symbol, appIcon, icon, trama, illus, page, mix, r1 };
