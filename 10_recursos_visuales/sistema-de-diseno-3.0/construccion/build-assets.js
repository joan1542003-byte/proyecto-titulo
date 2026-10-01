// Genera los recursos del sistema Relevo 3.0: íconos, logotipo, ícono de la app y trama.
// Fuentes: KitIcons.kt (97 íconos de la app 2.18), los 27 íconos redibujados de la lámina D-098 v3,
// relevo-tinta.svg (contornos de Schibsted Grotesk 650) y las funciones de trama de la lámina v3.
const fs = require('fs');
const path = require('path');

const REPO = path.resolve(__dirname, '../../..');
const OUT = path.join(__dirname, '..');
const UP = path.join(OUT, 'recursos');

const INK = '#17181C', PAPER = '#F2F2EF', BLUE = '#3D38F5', BLUE_DARK = '#9A97FF', WHITE = '#FFFFFF';

// ---------- Íconos ----------
const kit = JSON.parse(fs.readFileSync(path.join(__dirname, 'kit-icons.json'), 'utf8'));
const lamina = fs.readFileSync(path.join(REPO, '10_recursos_visuales/marca-el-subrayado/lamina-el-subrayado-v3-2026-09-30.html'), 'utf8');
const start = lamina.indexOf('const ICONS = {');
const end = lamina.indexOf('\n  };', start);
const ICONS = new Function('return ' + lamina.slice(start + 'const ICONS = '.length, end + 4).replace(/;\s*$/, ''))();

const r2 = (n) => Math.round(n * 1000) / 1000;
function circlePath(cx, cy, r) {
  return `M${r2(cx - r)} ${r2(cy)}A${r} ${r} 0 1 0 ${r2(cx + r)} ${r2(cy)}A${r} ${r} 0 1 0 ${r2(cx - r)} ${r2(cy)}Z`;
}
function rectPath(x, y, w, h, rx) {
  return `M${r2(x + rx)} ${y}H${r2(x + w - rx)}A${rx} ${rx} 0 0 1 ${r2(x + w)} ${r2(y + rx)}V${r2(y + h - rx)}A${rx} ${rx} 0 0 1 ${r2(x + w - rx)} ${r2(y + h)}H${r2(x + rx)}A${rx} ${rx} 0 0 1 ${x} ${r2(y + h - rx)}V${r2(y + rx)}A${rx} ${rx} 0 0 1 ${r2(x + rx)} ${y}Z`;
}
// Forma normalizada: { d, stroke, fill: 'none'|'ink'|'bg'|'accent', accent }
function fromLamina(parts) {
  return parts.map((p) => ({
    d: p.d || (p.c ? circlePath(p.c[0], p.c[1], p.c[2]) : rectPath(...p.r)),
    stroke: p.stroke !== 'none',
    fill: p.fill || 'none',
    accent: !!p.accent,
  }));
}
function fromKit(shapes) {
  return shapes.map((s) => ({ d: s.d, stroke: s.stroke, fill: s.fill === 'paper' ? 'bg' : s.fill, accent: false }));
}

// Los redibujados de D-098 reemplazan a su par de la app; «ruta» y «señal» son nuevos.
const REDRAWN = {
  inicio: 'INICIO', ruta: null, perfil: 'PERFIL', actividad: 'ACTIVIDAD', lugar: 'LUGAR', parlante: 'PARLANTE',
  primerpaso: 'PRIMER_PASO', apps: 'APPS', senal: null, silenciar: 'SILENCIAR', telefono: 'TELEFONO', tiempo: 'TIEMPO',
  esperando: 'ESPERANDO', agregar: 'AGREGAR', editar: 'EDITAR', borrar: 'BORRAR', cerrar: 'CERRAR', volver: 'VOLVER',
  siguiente: 'SIGUIENTE', listo: 'LISTO', comence: 'COMENCE', despues: 'DESPUES', cambie: 'CAMBIE', info: 'INFO',
  privacidad: 'PRIVACIDAD', permiso: 'PERMISO', advertencia: 'ADVERTENCIA', ajustes: 'AJUSTES',
};
const kebab = (k) => k.toLowerCase().replace(/_/g, '-');
const replaced = new Set(Object.values(REDRAWN).filter(Boolean));
const icons = {}; // nombre → { label, shapes, origin }
for (const [key, v] of Object.entries(kit)) {
  if (replaced.has(key)) continue;
  icons[kebab(key)] = { label: v.label, shapes: fromKit(v.shapes), origin: 'app' };
}
for (const [key, kitKey] of Object.entries(REDRAWN)) {
  const name = key === 'primerpaso' ? 'primer-paso' : key;
  const label = kitKey ? kit[kitKey].label : ICONS[key].label;
  icons[name] = { label, shapes: fromLamina(ICONS[key].parts), origin: 'd098' };
  if (ICONS[key].filled) {
    const filledName = { inicio: 'inicio-lleno', ruta: 'ruta-llena', perfil: 'perfil-lleno' }[key];
    icons[filledName] = { label: label + ', elegido', shapes: fromLamina(ICONS[key].filled), origin: 'd098' };
  }
}
// La etiqueta de la pestaña Ruta.
icons.ruta.label = 'Ruta';
const names = Object.keys(icons).sort((a, b) => a.localeCompare(b, 'es'));

function iconSvg(name) {
  const { shapes } = icons[name];
  let body = '';
  let masks = '';
  let k = 0;
  for (const s of shapes) {
    const color = s.accent ? BLUE : INK;
    if (s.fill === 'bg') {
      k += 1;
      masks += `<mask id="k${k}" maskUnits="userSpaceOnUse" x="-2" y="-2" width="28" height="28"><rect x="-2" y="-2" width="28" height="28" fill="#fff"/><path d="${s.d}" fill="#000"/></mask>`;
      body = `<g mask="url(#k${k})">${body}</g>`;
      if (s.stroke) body += `<path d="${s.d}" stroke="${color}"/>`;
      continue;
    }
    const fill = s.fill === 'ink' ? INK : s.fill === 'accent' ? BLUE : 'none';
    const stroke = s.stroke ? color : 'none';
    body += `<path d="${s.d}"${fill !== 'none' ? ` fill="${fill}"` : ''}${stroke === 'none' ? ' stroke="none"' : stroke !== INK ? ` stroke="${stroke}"` : ''}/>`;
  }
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24" fill="none" stroke="${INK}" stroke-width="1.75" stroke-linecap="round" stroke-linejoin="round">${masks ? `<defs>${masks}</defs>` : ''}${body}</svg>\n`;
}
for (const n of names) fs.writeFileSync(path.join(UP, 'Iconos', n + '.svg'), iconSvg(n));

// Datos compactos para el paquete de componentes: [d, banderas] con s = trazo, i = relleno de tinta,
// b = relleno del fondo (recorte), a = azul de acento.
const bundleIcons = {};
for (const n of names) {
  bundleIcons[n] = icons[n].shapes.map((s) => [s.d, (s.stroke ? 's' : '') + (s.fill === 'ink' ? 'i' : s.fill === 'bg' ? 'b' : s.fill === 'accent' ? 'i' : '') + (s.accent ? 'a' : '')]);
}
fs.writeFileSync(path.join(__dirname, 'bundle-icons.json'), JSON.stringify(bundleIcons));
fs.writeFileSync(path.join(__dirname, 'icon-index.json'), JSON.stringify(names.map((n) => ({ name: n, label: icons[n].label, origin: icons[n].origin, accent: icons[n].shapes.some((s) => s.accent) })), null, 1));

// ---------- Logotipo ----------
const tinta = fs.readFileSync(path.join(REPO, '10_recursos_visuales/marca-a-tiempo/logotipo/relevo-tinta.svg'), 'utf8');
const wordPaths = [...tinta.matchAll(/<path d="([^"]+)"\/>/g)].map((m) => m[1]);
if (wordPaths.length !== 6) throw new Error('Se esperaban 6 contornos y hay ' + wordPaths.length);
fs.writeFileSync(path.join(__dirname, 'wordmark-paths.json'), JSON.stringify(wordPaths));
// Renglón: del ancho de la palabra (x 145–6055), 0,075 em de alto (UPM 2048 → 154), con su borde
// superior a 0,236 em bajo la línea base (483), como en la lámina v3 (.wm::after).
const RL = { x: 145, y: 483, w: 5910, h: 154 };
const VB = '145 -1500 5910 2137';
function wordmark(text, line, label) {
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="${VB}" width="591" height="213.7" role="img" aria-label="relevo"><title>relevo${label ? ' — ' + label : ''}</title><g fill="${text}">${wordPaths.map((d) => `<path d="${d}"/>`).join('')}</g><rect x="${RL.x}" y="${RL.y}" width="${RL.w}" height="${RL.h}" fill="${line}"/></svg>\n`;
}
fs.writeFileSync(path.join(UP, 'Logotipo', 'relevo-tinta.svg'), wordmark(INK, BLUE, 'tinta y renglón azul'));
fs.writeFileSync(path.join(UP, 'Logotipo', 'relevo-papel.svg'), wordmark(PAPER, BLUE_DARK, 'papel y renglón azul claro'));
fs.writeFileSync(path.join(UP, 'Logotipo', 'relevo-blanco.svg'), wordmark(WHITE, WHITE, 'blanco sobre azul'));

// Ícono de la app: la «r» del logotipo con su renglón (lámina v3: «r» de 64 px en 96, renglón de 32 × 5).
const rPath = wordPaths[0];
const S = 512 / 96 * 64 / 2048; // unidades de la fuente → px del ícono de 512
const rBox = { x0: 145, x1: 866, top: -1106 };
const rW = (rBox.x1 - rBox.x0) * S;
const lineW = 32 / 96 * 512, lineH = 5 / 96 * 512, gap = 4 / 96 * 512;
const rH = -rBox.top * S;
const blockH = rH + gap + lineH;
const baseline = (512 - blockH) / 2 + rH;
const tx = 256 - rW / 2 - rBox.x0 * S;
function appIcon(bg, fg, line, extra) {
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="512" height="512" role="img" aria-label="relevo"><title>relevo</title><rect width="512" height="512" rx="114" fill="${bg}"/>${extra || ''}<path fill="${fg}" transform="translate(${r2(tx)} ${r2(baseline)}) scale(${r2(S * 1e4) / 1e4})" d="${rPath}"/><rect x="${r2(256 - lineW / 2)}" y="${r2(baseline + gap)}" width="${r2(lineW)}" height="${r2(lineH)}" fill="${line}"/></svg>\n`;
}
fs.writeFileSync(path.join(UP, 'Logotipo', 'icono-azul.svg'), appIcon(BLUE, WHITE, WHITE));
fs.writeFileSync(path.join(UP, 'Logotipo', 'icono-tinta.svg'), appIcon(INK, PAPER, BLUE_DARK));

// ---------- Trama (funciones de la lámina v3, sin lienzo) ----------
const hexRgb = (h) => [1, 3, 5].map((i) => parseInt(h.slice(i, i + 2), 16));
const toHex = (c) => '#' + c.map((v) => Math.round(v).toString(16).padStart(2, '0')).join('').toUpperCase();
function paletteAt(stops, p) {
  p = Math.max(0, Math.min(1, p));
  const seg = p * (stops.length - 1), i = Math.min(stops.length - 2, Math.floor(seg)), t = seg - i;
  return stops[i].map((v, k) => v + (stops[i + 1][k] - v) * t);
}
function fieldValue(nx, ny, seed, dense, t) {
  const a = Math.sin((nx * 1.5 + ny * 0.8) * 3.6 + t * 0.6 + seed);
  const b = Math.sin((-nx * 0.7 + ny * 1.6) * 3.3 - t * 0.45 + 1.3 + seed * 0.7);
  const c = Math.sin((nx * 2.1 - ny * 0.6) * 2.8 + t * 0.3 + 2.1 + seed * 0.4);
  const v = a * 0.55 + b * 0.35 + c * 0.2;
  return 1 / (1 + Math.exp(-3.4 * (v - (dense ? -0.35 : 0.1))));
}
// Campo de puntos agrupado por color (cuantizado en 8 tonos) para que el SVG pese poco.
function fieldSvg({ w, h, pitch, seed, dense, stops, faint, bg, extra, rx }) {
  const cols = Math.ceil(w / pitch), rows = Math.ceil(h / pitch);
  const st = stops.map(hexRgb);
  const groups = new Map();
  const faintDots = [];
  for (let j = 0; j < rows; j++) for (let i = 0; i < cols; i++) {
    const nx = i / cols, ny = j / rows, v = fieldValue(nx, ny, seed, dense, 0);
    const x = r2(i * pitch + pitch / 2), y = r2(j * pitch + pitch / 2);
    if (v < 0.16) { faintDots.push(`<circle cx="${x}" cy="${y}" r="${r2(pitch * 0.17)}"/>`); continue; }
    const q = Math.round(v * 7) / 7;
    const color = toHex(paletteAt(st, q));
    const r = r2(Math.min(pitch * 0.56, pitch * 0.5 * (0.24 + 0.8 * v)));
    if (!groups.has(color)) groups.set(color, []);
    groups.get(color).push(`<circle cx="${x}" cy="${y}" r="${r}"/>`);
  }
  let body = bg ? `<rect width="${w}" height="${h}"${rx ? ` rx="${rx}"` : ''} fill="${bg}"/>` : '';
  body += `<g fill="${faint}">${faintDots.join('')}</g>`;
  for (const [c, dots] of groups) body += `<g fill="${c}">${dots.join('')}</g>`;
  return { body, cols, rows };
}
const campo = fieldSvg({ w: 1200, h: 750, pitch: 10, seed: 0.7, dense: true, stops: ['#C4C2FC', BLUE], faint: '#3C3C781F', bg: WHITE });
fs.writeFileSync(path.join(UP, 'Trama', 'trama-campo.svg'), `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 750" width="1200" height="750"><title>Trama de Relevo: campo de puntos azules</title>${campo.body}</svg>\n`);
const senal = fieldSvg({ w: 390, h: 844, pitch: 7, seed: 1.1, dense: true, stops: ['#C4C2FC', BLUE], faint: '#3C3C781F', bg: PAPER });
fs.writeFileSync(path.join(UP, 'Trama', 'trama-senal.svg'), `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 390 844" width="390" height="844"><title>Trama de la señal: fondo de la pantalla cuando suena</title>${senal.body}</svg>\n`);
// Ícono de la app con trama: puntos azules claros sobre el azul, con la «r» y el renglón en blanco.
const iconField = fieldSvg({ w: 512, h: 512, pitch: 4 / 96 * 512, seed: 0.9, dense: false, stops: ['#5A55FF', '#A9A6FF'], faint: '#FFFFFF24', bg: null });
fs.writeFileSync(path.join(UP, 'Logotipo', 'icono-trama.svg'), appIcon(BLUE, WHITE, WHITE, `<clipPath id="c"><rect width="512" height="512" rx="114"/></clipPath><g clip-path="url(#c)">${iconField.body}</g>`));
// El tiempo en puntos: 6 de 15.
const dots = Array.from({ length: 15 }, (_, i) => `<circle cx="${8 + i * 18}" cy="8" r="6" fill="${i < 6 ? BLUE : '#E5E5E2'}"/>`).join('');
fs.writeFileSync(path.join(UP, 'Trama', 'tiempo-6-de-15.svg'), `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 268 16" width="268" height="16" role="img" aria-label="6 de 15 minutos"><title>6 de 15 minutos: un punto por minuto</title>${dots}</svg>\n`);

console.log('íconos', names.length, '| redibujados', names.filter((n) => icons[n].origin === 'd098').length);
console.log('r: baseline', r2(baseline), 'tx', r2(tx), 'S', S);
for (const g of ['Iconos', 'Logotipo', 'Trama']) {
  const files = fs.readdirSync(path.join(UP, g));
  const size = files.reduce((t, f) => t + fs.statSync(path.join(UP, g, f)).size, 0);
  console.log(g, files.length, 'archivos', Math.round(size / 1024) + ' KB');
}
