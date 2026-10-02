// Familia del logotipo 3.1: logotipo, firmas, símbolo, íconos de app, favicon, notificación, trama y construcción.
const fs = require('fs');
const path = require('path');
const { Font, textPath, contourToPath } = require('./ttf.js');
const font = new Font(path.join(__dirname, 'schibsted.ttf'));
const PAL = require('./palette.json');
const OUT = path.join(__dirname, 'out', 'Logotipo');
fs.mkdirSync(OUT, { recursive: true });

const C = { ink: '#17181C', paper: '#F2F2EF', white: '#FFFFFF', blue: '#3D38F5', blue300: '#9A97FF', blue700: '#1F1BB4', graphite: '#5B5F68' };
// Geometría (unidades de la fuente, UPM 2048).
const G = { weight: 600, tracking: -0.022, kern: { el: -40, le: -10, vo: -8 }, bar: 160, gap: 180, ext: 1080, xh: 1080, asc: 1500, over: 26 };
const f2 = (v) => +v.toFixed(1);

function glyphBounds(d) {
  const n = d.match(/-?[\d.]+/g).map(Number);
  let x0 = Infinity, x1 = -Infinity, y0 = Infinity, y1 = -Infinity;
  for (let i = 0; i < n.length; i += 2) { x0 = Math.min(x0, n[i]); x1 = Math.max(x1, n[i]); y0 = Math.min(y0, n[i + 1]); y1 = Math.max(y1, n[i + 1]); }
  return { x0, x1, y0, y1 };
}
// La palabra, con el borde izquierdo del asta de la «r» en x = 0.
function wordmark() {
  const t = textPath(font, 'relevo', { size: 2048, weight: G.weight, tracking: G.tracking, kern: G.kern });
  const b = glyphBounds(t.d);
  const t2 = textPath(font, 'relevo', { size: 2048, weight: G.weight, tracking: G.tracking, kern: G.kern, x: -b.x0 });
  const b2 = glyphBounds(t2.d);
  return { d: t2.d, right: b2.x1, top: b2.y0, bottom: b2.y1 };
}
const W = wordmark();
const LINE = { x: 0, y: G.gap, w: W.right + G.ext, h: G.bar };
const lineRect = (fill, o = {}) => `<rect x="${f2((o.x ?? LINE.x))}" y="${f2(o.y ?? LINE.y)}" width="${f2(o.w ?? LINE.w)}" height="${G.bar}" rx="${G.bar / 2}" fill="${fill}"/>`;

// Texto auxiliar como trazado (firmas, rótulos de construcción).
function txt(str, { size, weight = 500, x = 0, y = 0, fill = C.ink, tracking = 0 }) {
  const t = textPath(font, str, { size, weight, x, y, tracking });
  return { svg: `<path fill="${fill}" d="${t.d}"/>`, width: t.width };
}
function wrap(vb, body, label, bg) {
  const [x, y, w, h] = vb.map(f2);
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="${x} ${y} ${w} ${h}" width="${f2(w / 8)}" height="${f2(h / 8)}" role="img" aria-label="relevo"><title>${label}</title>${bg ? `<rect x="${x}" y="${y}" width="${w}" height="${h}" fill="${bg}"/>` : ''}${body}</svg>\n`;
}
const files = {};
const put = (name, svg) => { files[name] = svg; fs.writeFileSync(path.join(OUT, name), svg); };

// ---------- Logotipo ----------
const PAD = 0;
const vbLogo = [-PAD, -G.asc - PAD, LINE.w + 2 * PAD, G.asc + G.gap + G.bar + 2 * PAD];
const logo = (letters, line, label, bg) => wrap(vbLogo, lineRect(line) + `<path fill="${letters}" d="${W.d}"/>`, label, bg);
put('relevo.svg', logo(C.ink, C.blue, 'relevo — logotipo principal: tinta y renglón azul'));
put('relevo-papel.svg', logo(C.paper, C.blue300, 'relevo — papel y renglón azul claro, sobre tinta'));
put('relevo-blanco.svg', logo(C.white, C.white, 'relevo — blanco, sobre azul'));
put('relevo-tinta.svg', logo(C.ink, C.ink, 'relevo — una tinta'));
put('relevo-azul-profundo.svg', logo(C.ink, C.blue700, 'relevo — renglón azul profundo, para impresión'));
for (const [fam, f] of Object.entries(PAL)) put(`relevo-${fam}.svg`, logo(C.ink, f.steps[600].hex, `relevo — renglón ${fam} (${f.cat})`));
// Compacto: el renglón del ancho de la palabra (espacios estrechos).
put('relevo-compacto.svg', wrap([0, -G.asc, W.right, G.asc + G.gap + G.bar], lineRect(C.blue, { w: W.right }) + `<path fill="${C.ink}" d="${W.d}"/>`, 'relevo — compacto, renglón del ancho de la palabra'));

// ---------- Firmas (logotipo + frase) ----------
{
  // Horizontal: frase en dos líneas a la derecha, del alto de la x.
  const s = 553, lh = 691;
  const gapX = G.xh * 0.8;
  const l1 = txt('Vuelve a lo que', { size: s, weight: 500, x: LINE.w + gapX, y: -lh });
  const l2 = txt('querías hacer.', { size: s, weight: 500, x: LINE.w + gapX, y: 0 });
  const w = LINE.w + gapX + Math.max(l1.width, l2.width);
  put('firma-horizontal.svg', wrap([0, -G.asc, w, G.asc + G.gap + G.bar], lineRect(C.blue) + `<path fill="${C.ink}" d="${W.d}"/>` + l1.svg.replace(C.ink, C.graphite) + l2.svg.replace(C.ink, C.graphite), 'relevo — firma horizontal'));
  // Vertical: logotipo y frase debajo.
  const s2 = 560, y2 = G.gap + G.bar + 900;
  const t1 = txt('Vuelve a lo que querías hacer.', { size: s2, weight: 500, x: 0, y: y2 });
  put('firma-vertical.svg', wrap([0, -G.asc, Math.max(LINE.w, t1.width), y2 + 160 + G.asc], lineRect(C.blue) + `<path fill="${C.ink}" d="${W.d}"/>` + t1.svg.replace(C.ink, C.graphite), 'relevo — firma vertical'));
  // Con descriptor, para presentar el producto sin contexto.
  const s3 = 470, y3 = G.gap + G.bar + 820;
  const d1 = txt('Un recordatorio físico que preparas', { size: s3, weight: 500, x: 0, y: y3 });
  const d2 = txt('desde el teléfono.', { size: s3, weight: 500, x: 0, y: y3 + 600 });
  put('firma-descriptor.svg', wrap([0, -G.asc, Math.max(LINE.w, d1.width), y3 + 600 + 150 + G.asc], lineRect(C.blue) + `<path fill="${C.ink}" d="${W.d}"/>` + d1.svg.replace(C.ink, C.graphite) + d2.svg.replace(C.ink, C.graphite), 'relevo — firma con descriptor'));
}

// ---------- Símbolo: la «r» con su renglón que hace lugar ----------
function rShape() {
  const coords = font.normalize({ wght: G.weight });
  const g = font.glyph(font.gid('r'), coords);
  let d = '';
  for (const ct of g.contours) d += contourToPath(ct, 0, 0, 1);
  const b = glyphBounds(d);
  // Mueve el asta a x = 0.
  let d2 = '';
  for (const ct of g.contours) d2 += contourToPath(ct, -b.x0, 0, 1);
  return { d: d2, w: b.x1 - b.x0, h: -b.y0 };
}
const R = rShape();
const SYM = { lineW: R.w + G.xh, top: -R.h, bottom: 130 + G.bar };
const SYM_GAP = 130;
function symbolGroup(fill, line) {
  return `${lineRect(line, { x: 0, w: SYM.lineW, y: SYM_GAP })}<path fill="${fill}" d="${R.d}"/>`;
}
put('simbolo.svg', wrap([0, SYM.top, SYM.lineW, SYM.bottom - SYM.top], symbolGroup(C.ink, C.blue), 'relevo — símbolo: la «r» y su renglón'));
// Ícono de la app en 512 con esquinas de 114: el conjunto ocupa el 64 % del ancho, centrado ópticamente.
function appIcon(bg, fill, line, extra = '', label = 'relevo — ícono') {
  const box = 512, k = (box * 0.62) / SYM.lineW;
  const w = SYM.lineW * k, h = (SYM.bottom - SYM.top) * k;
  const tx = (box - w) / 2, ty = (box - h) / 2 - SYM.top * k - 6;
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="512" height="512" role="img" aria-label="relevo"><title>${label}</title><rect width="512" height="512" rx="114" fill="${bg}"/>${extra}<g transform="translate(${f2(tx)} ${f2(ty)}) scale(${(+k.toFixed(5))})">${symbolGroup(fill, line)}</g></svg>\n`;
}
put('icono-azul.svg', appIcon(C.blue, C.white, C.white, '', 'relevo — ícono principal'));
put('icono-tinta.svg', appIcon(C.ink, C.paper, C.blue300, '', 'relevo — ícono sobre tinta'));
put('icono-papel.svg', appIcon(C.paper, C.ink, C.blue, '', 'relevo — ícono sobre papel'));
// Con trama: puntos de azul-300 que crecen hacia la esquina inferior derecha.
{
  let dots = '';
  const pitch = 512 / 22;
  for (let j = 0; j < 22; j++) for (let i = 0; i < 22; i++) {
    const v = Math.max(0, Math.min(1, (i + j) / 42 - 0.15));
    const r = pitch * 0.5 * (0.18 + 0.82 * v ** 1.4);
    dots += `<circle cx="${f2(i * pitch + pitch / 2)}" cy="${f2(j * pitch + pitch / 2)}" r="${f2(r)}"/>`;
  }
  put('icono-trama.svg', appIcon(C.blue, C.white, C.white, `<clipPath id="c"><rect width="512" height="512" rx="114"/></clipPath><g clip-path="url(#c)" fill="#5652F7">${dots}</g>`, 'relevo — ícono con trama'));
}
// Android: capas del ícono adaptable (108 dp; zona segura de 66 dp) y monocromo para íconos temáticos.
function adaptive(layer) {
  const box = 108, safe = 66, k = (safe * 0.86) / SYM.lineW;
  const w = SYM.lineW * k, h = (SYM.bottom - SYM.top) * k;
  const tx = (box - w) / 2, ty = (box - h) / 2 - SYM.top * k - 1;
  const g = `<g transform="translate(${f2(tx)} ${f2(ty)}) scale(${(+k.toFixed(6))})">${symbolGroup(layer === 'mono' ? '#000' : C.white, layer === 'mono' ? '#000' : C.white)}</g>`;
  if (layer === 'fondo') return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 108 108" width="432" height="432"><title>relevo — fondo del ícono adaptable</title><rect width="108" height="108" fill="${C.blue}"/></svg>\n`;
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 108 108" width="432" height="432"><title>relevo — ${layer === 'mono' ? 'ícono monocromo' : 'frente del ícono adaptable'}</title>${g}</svg>\n`;
}
put('android-frente.svg', adaptive('frente'));
put('android-fondo.svg', adaptive('fondo'));
put('android-monocromo.svg', adaptive('mono'));
// Ícono de notificación: silueta blanca en 24 dp, con más aire.
{
  const k = 19 / SYM.lineW, w = SYM.lineW * k, h = (SYM.bottom - SYM.top) * k;
  const tx = (24 - w) / 2, ty = (24 - h) / 2 - SYM.top * k;
  put('notificacion.svg', `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="96" height="96"><title>relevo — ícono de notificación (blanco)</title><g transform="translate(${f2(tx)} ${f2(ty)}) scale(${(+k.toFixed(6))})">${symbolGroup(C.white, C.white)}</g></svg>\n`);
}
// Favicon: más grueso y con más relleno para 16 px.
put('favicon.svg', appIcon(C.blue, C.white, C.white, '', 'relevo — favicon').replace('rx="114"', 'rx="128"'));

// ---------- Logotipo en trama (momentos de marca) ----------
// Se marca qué celdas de una retícula caen dentro de las letras con una prueba punto-en-polígono sobre el trazado aplanado.
function flatten(d, step = 20) {
  const polys = [];
  let cur = [], x = 0, y = 0, sx = 0, sy = 0;
  const t = d.match(/[MLQZ]|-?[\d.]+/g);
  let i = 0, cmd;
  const num = () => parseFloat(t[i++]);
  while (i < t.length) {
    if (/[MLQZ]/.test(t[i])) cmd = t[i++];
    if (cmd === 'M') { if (cur.length) polys.push(cur); cur = []; x = sx = num(); y = sy = num(); cur.push([x, y]); }
    else if (cmd === 'L') { x = num(); y = num(); cur.push([x, y]); }
    else if (cmd === 'Q') { const cx = num(), cy = num(), nx = num(), ny = num(); for (let s = 1; s <= 8; s++) { const u = s / 8; cur.push([(1 - u) ** 2 * x + 2 * (1 - u) * u * cx + u * u * nx, (1 - u) ** 2 * y + 2 * (1 - u) * u * cy + u * u * ny]); } x = nx; y = ny; }
    else if (cmd === 'Z') { cur.push([sx, sy]); polys.push(cur); cur = []; }
  }
  if (cur.length) polys.push(cur);
  return polys;
}
function inside(polys, px, py) {
  let c = false;
  for (const p of polys) for (let a = 0, b = p.length - 1; a < p.length; b = a++) {
    const [xa, ya] = p[a], [xb, yb] = p[b];
    if ((ya > py) !== (yb > py) && px < ((xb - xa) * (py - ya)) / (yb - ya) + xa) c = !c;
  }
  return c;
}
{
  // Retícula de 72 unidades (15 filas por altura de x) alineada a la línea base; el punto crece con la parte de la celda
  // que cae dentro de la letra, así los bordes se suavizan como en un medio tono. El renglón son puntos del grosor del
  // renglón: el tiempo en puntos de TimeDots (un punto, un minuto).
  const polys = flatten(W.d);
  const pitch = 72, S = 7;
  let ink = '', line = '';
  for (let y = -pitch / 2; y > -G.asc - pitch; y -= pitch) for (let x = pitch / 2; x < W.right + pitch; x += pitch) {
    let hit = 0;
    for (let a = 0; a < S; a++) for (let b = 0; b < S; b++) if (inside(polys, x - pitch / 2 + (a + 0.5) * pitch / S, y - pitch / 2 + (b + 0.5) * pitch / S)) hit++;
    const cov = hit / (S * S);
    if (cov >= 0.1) ink += `<circle cx="${f2(x)}" cy="${f2(y)}" r="${f2(pitch * 0.45 * Math.min(1, Math.sqrt(cov) * 1.08))}"/>`;
  }
  const step = G.bar * 1.45;
  for (let x = G.bar / 2; x < LINE.w; x += step) line += `<circle cx="${f2(x)}" cy="${f2(G.gap + G.bar / 2)}" r="${G.bar / 2}"/>`;
  put('relevo-trama.svg', wrap([0, -G.asc - 40, LINE.w, G.asc + 40 + G.gap + G.bar], `<g fill="${C.blue}">${line}</g><g fill="${C.ink}">${ink}</g>`, 'relevo — logotipo en trama, solo para momentos de marca'));
}

// ---------- Construcción ----------
{
  const pad = 1500, lab = (s, x, y, a = 'start') => { const t = txt(s, { size: 230, weight: 500, fill: C.graphite }); const dx = a === 'end' ? -t.width : a === 'middle' ? -t.width / 2 : 0; return txt(s, { size: 230, weight: 500, x: x + dx, y, fill: C.graphite }).svg; };
  const vb = [-pad, -G.asc - pad, LINE.w + 2 * pad + 1400, G.asc + G.gap + G.bar + 2 * pad];
  const guide = (y, color = '#C4C2FC') => `<line x1="${-pad}" x2="${LINE.w + pad}" y1="${y}" y2="${y}" stroke="${color}" stroke-width="10"/>`;
  let body = `<rect x="${vb[0]}" y="${vb[1]}" width="${vb[2]}" height="${vb[3]}" fill="#FFFFFF"/>`;
  // Área de respeto: la altura de la «o» alrededor.
  body += `<rect x="${-G.xh}" y="${-G.asc - G.xh}" width="${LINE.w + 2 * G.xh}" height="${G.asc + G.gap + G.bar + 2 * G.xh}" fill="none" stroke="#C4C2FC" stroke-width="10" stroke-dasharray="40 30"/>`;
  body += guide(0) + guide(-G.xh) + guide(-G.asc) + guide(G.gap) + guide(G.gap + G.bar);
  body += lineRect('#3D38F5') + `<path fill="${C.ink}" d="${W.d}"/>`;
  body += `<line x1="${W.right}" x2="${W.right}" y1="${G.gap - 260}" y2="${G.gap + G.bar + 260}" stroke="#1F1BB4" stroke-width="10"/>`;
  body += lab('altura de x', LINE.w + 60, -G.xh - 40) + lab('línea base', LINE.w + 60, -40) + lab('ascendente', LINE.w + 60, -G.asc - 40);
  body += lab('renglón: el grosor del travesaño de la «e»', 0, G.gap + G.bar + 420) + lab('pasa la «o» en una altura de x', W.right + 60, G.gap + G.bar + 420);
  body += lab('área de respeto: la altura de la «o»', -G.xh + 60, -G.asc - G.xh + 300);
  put('construccion.svg', wrap(vb, body, 'relevo — construcción del logotipo'));
}

fs.writeFileSync(path.join(__dirname, 'out', 'logo-geometry.json'), JSON.stringify({ G, W: { right: W.right }, LINE, R: { w: R.w, h: R.h }, SYM, wordPath: W.d, rPath: R.d }));
console.log(Object.keys(files).length, 'archivos:', Object.keys(files).join(' '));
