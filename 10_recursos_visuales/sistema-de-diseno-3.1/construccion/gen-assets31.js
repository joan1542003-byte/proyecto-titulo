// Recursos 3.1: íconos nuevos (SVG de una tinta), patrones y lámina de color.
const fs = require('fs');
const path = require('path');
const I = require('./icons31.js');
const PAL = require('./palette.json');
const { Font, textPath } = require('./ttf.js');
const font = new Font(path.join(__dirname, 'schibsted.ttf'));
const OUT = path.join(__dirname, 'out');
for (const g of ['Iconos', 'Patrones', 'Color']) fs.mkdirSync(path.join(OUT, g), { recursive: true });
const INK = '#17181C', BLUE = '#3D38F5', PAPER = '#F2F2EF';
const r2 = (n) => Math.round(n * 100) / 100;

// ---------- Íconos ----------
const part = (p) => {
  const col = p.accent ? BLUE : INK;
  const fill = p.fill === 'ink' ? INK : p.fill === 'accent' ? BLUE : 'none';
  const stroke = p.stroke === 'none' ? 'none' : col;
  const a = `${fill !== 'none' ? ` fill="${fill}"` : ''}${stroke === 'none' ? ' stroke="none"' : stroke !== INK ? ` stroke="${stroke}"` : ''}`;
  if (p.d) return `<path d="${p.d}"${a}/>`;
  if (p.c) return `<circle cx="${p.c[0]}" cy="${p.c[1]}" r="${p.c[2]}"${a}/>`;
  return `<rect x="${p.r[0]}" y="${p.r[1]}" width="${p.r[2]}" height="${p.r[3]}" rx="${p.r[4]}"${a}/>`;
};
for (const [n, ic] of Object.entries(I)) {
  fs.writeFileSync(path.join(OUT, 'Iconos', n + '.svg'), `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24" fill="none" stroke="${INK}" stroke-width="1.75" stroke-linecap="round" stroke-linejoin="round">${ic.parts.map(part).join('')}</svg>\n`);
}

// ---------- Patrones ----------
const svg = (w, h, title, body) => `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 ${w} ${h}" width="${w}" height="${h}"><title>${title}</title>${body}</svg>\n`;
// Renglones: hoja de cuaderno con renglones cada 32 px y margen de 20 (el margen de la app).
function renglones(line, bg, name, title) {
  const w = 1200, h = 800;
  let b = `<rect width="${w}" height="${h}" fill="${bg}"/><g fill="${line}">`;
  for (let y = 64; y < h; y += 48) b += `<rect x="0" y="${y}" width="${w}" height="3" rx="1.5"/>`;
  b += '</g>';
  fs.writeFileSync(path.join(OUT, 'Patrones', name), svg(w, h, title, b));
}
renglones(BLUE, '#FFFFFF', 'renglones-azul.svg', 'Renglones azules sobre blanco: la hoja donde se escribe la intención');
renglones('#C4C2FC', PAPER, 'renglones-suaves.svg', 'Renglones azul claro sobre papel, para fondos de lectura');
renglones('#9A97FF', '#17181C', 'renglones-noche.svg', 'Renglones azul claro sobre tinta');
// Cuadrícula de puntos: la trama en reposo, cada 24 px.
{
  const w = 1200, h = 800; let b = `<rect width="${w}" height="${h}" fill="${PAPER}"/><g fill="#9A97FF">`;
  for (let y = 24; y < h; y += 24) for (let x = 24; x < w; x += 24) b += `<circle cx="${x}" cy="${y}" r="1.6"/>`;
  fs.writeFileSync(path.join(OUT, 'Patrones', 'cuadricula-de-puntos.svg'), svg(w, h, 'Cuadrícula de puntos: la trama en reposo', b + '</g>'));
}
// Campos de trama por familia (funciones de la lámina v3).
function fieldValue(nx, ny, seed, dense) {
  const a = Math.sin((nx * 1.5 + ny * 0.8) * 3.6 + seed), bb = Math.sin((-nx * 0.7 + ny * 1.6) * 3.3 + 1.3 + seed * 0.7), c = Math.sin((nx * 2.1 - ny * 0.6) * 2.8 + 2.1 + seed * 0.4);
  const v = a * 0.55 + bb * 0.35 + c * 0.2;
  return 1 / (1 + Math.exp(-3.4 * (v - (dense ? -0.35 : 0.1))));
}
const hexRgb = (hh) => [1, 3, 5].map((i) => parseInt(hh.slice(i, i + 2), 16));
const toHex = (c) => '#' + c.map((v) => Math.round(v).toString(16).padStart(2, '0')).join('').toUpperCase();
const mix = (a, b, t) => toHex(a.map((v, i) => v + (b[i] - v) * t));
function campo(name, light, deep, bg, seed, title) {
  const w = 1200, h = 750, pitch = 12, cols = w / pitch, rows = Math.ceil(h / pitch);
  const L = hexRgb(light), D = hexRgb(deep);
  const groups = new Map(); let faint = '';
  for (let j = 0; j < rows; j++) for (let i = 0; i < cols; i++) {
    const v = fieldValue(i / cols, j / rows, seed, true);
    const x = i * pitch + pitch / 2, y = j * pitch + pitch / 2;
    if (v < 0.16) { faint += `<circle cx="${x}" cy="${y}" r="${r2(pitch * 0.17)}"/>`; continue; }
    const col = mix(L, D, Math.round(v * 7) / 7);
    const rr = r2(Math.min(pitch * 0.56, pitch * 0.5 * (0.24 + 0.8 * v)));
    if (!groups.has(col)) groups.set(col, []);
    groups.get(col).push(`<circle cx="${x}" cy="${y}" r="${rr}"/>`);
  }
  let b = `<rect width="${w}" height="${h}" fill="${bg}"/><g fill="${deep}" opacity=".14">${faint}</g>`;
  for (const [c, d] of groups) b += `<g fill="${c}">${d.join('')}</g>`;
  fs.writeFileSync(path.join(OUT, 'Patrones', name), svg(w, h, title, b));
}
const NAMES = { mostaza: 'Leer', arcilla: 'Crear con las manos', salvia: 'Cuidar la casa y a mí', terracota: 'Moverme', ciruela: 'Con otras personas', pizarra: 'Aprender algo' };
let seed = 0.4;
for (const [fam, f] of Object.entries(PAL)) {
  campo(`trama-${fam}.svg`, f.steps[200].hex, f.steps[f.sig >= 700 ? f.sig : 700].hex, f.steps[50].hex, seed, `Trama de ${fam} («${NAMES[fam]}»): campo de puntos para afiches y portadas`);
  seed += 0.9;
}
// Bandas: los seis renglones y el azul, como en la portada.
{
  const w = 1200, h = 420; let b = `<rect width="${w}" height="${h}" fill="${PAPER}"/>`;
  const fams = ['azul', ...Object.keys(PAL)];
  fams.forEach((fam, i) => {
    const col = fam === 'azul' ? BLUE : PAL[fam].steps[PAL[fam].sig].hex;
    const len = [1040, 780, 900, 660, 980, 720, 860][i];
    b += `<rect x="80" y="${40 + i * 50}" width="${len}" height="28" rx="14" fill="${col}"/>`;
  });
  fs.writeFileSync(path.join(OUT, 'Patrones', 'renglones-de-colores.svg'), svg(w, h, 'Renglones de colores: el azul de Relevo y los seis colores de la casa', b));
}

// ---------- Lámina de color (con rótulos en trazado) ----------
{
  const label = (s, x, y, size = 15, weight = 500, fill = INK) => `<path fill="${fill}" d="${textPath(font, s, { size, weight, x, y }).d}"/>`;
  const w = 1320, rowH = 76, top = 130, h = top + rowH * 7 + 60;
  let b = `<rect width="${w}" height="${h}" fill="#FFFFFF"/>`;
  b += label('Los colores de Relevo', 40, 58, 30, 650);
  b += label('El azul es la pantalla y el sistema; los seis colores de la casa son las actividades de la persona.', 40, 92, 16, 400, '#5B5F68');
  const fams = [['azul', 'Relevo', { 50: '#ECEBFE', 200: '#C4C2FC', 300: '#9A97FF', 500: '#3D38F5', 700: '#1F1BB4' }]].concat(Object.entries(PAL).map(([k, f]) => [k, NAMES[k], Object.fromEntries(Object.entries(f.steps).map(([s, v]) => [s, v.hex])), f.sig]));
  fams.forEach(([fam, cat, steps, sig], i) => {
    const y = top + i * rowH;
    b += label(fam, 40, y + 30, 18, 650) + label(cat, 40, y + 52, 13, 400, '#5B5F68');
    let x = 250;
    for (const [k, hex] of Object.entries(steps)) {
      const cw = fam === 'azul' ? 204 : 102;
      const isSig = +k === sig;
      b += `<rect x="${x}" y="${y + 6}" width="${cw - 6}" height="58" rx="10" fill="${hex}"/>`;
      if (isSig) b += `<rect x="${x - 3}" y="${y + 3}" width="${cw}" height="64" rx="12" fill="none" stroke="${INK}" stroke-width="2"/>`;
      const light = parseInt(hex.slice(1, 3), 16) * 0.299 + parseInt(hex.slice(3, 5), 16) * 0.587 + parseInt(hex.slice(5, 7), 16) * 0.114 > 150;
      b += label(String(k), x + 10, y + 26, 12, 600, light ? INK : '#FFFFFF') + label(hex, x + 10, y + 54, 11, 400, light ? INK : '#FFFFFF');
      x += cw;
    }
  });
  fs.writeFileSync(path.join(OUT, 'Color', 'paleta.svg'), svg(w, h, 'Paleta de Relevo 3.1', b));
}
console.log('íconos', Object.keys(I).length, '| patrones', fs.readdirSync(path.join(OUT, 'Patrones')).length, '| color', fs.readdirSync(path.join(OUT, 'Color')).length);
for (const g of ['Iconos', 'Patrones', 'Color']) { const fl = fs.readdirSync(path.join(OUT, g)); console.log(g, Math.round(fl.reduce((t, f) => t + fs.statSync(path.join(OUT, g, f)).size, 0) / 1024) + ' KB'); }
