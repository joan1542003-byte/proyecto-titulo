// Variantes del logo de Relevo: degradados sutiles en la marca y color en el logotipo.
const fs = require('fs');
const path = require('path');
const { legible, oklch2hex, rgb2oklch, contrast } = require('./color.js');
const SRC = path.join(__dirname, '..', '..', 'logo-relevo-2026-10-11', 'relevo-logo-horizontal-degradado.svg');
const OUT = process.argv[2] || path.join(__dirname, '..'); // la lámina va en la carpeta; los SVG, en svg/
fs.mkdirSync(path.join(OUT, 'svg'), { recursive: true });
const src = fs.readFileSync(SRC, 'utf8');
const marca = [...src.matchAll(/<path fill="url\(#luz[TRBL]\)" d="([^"]+)"/g)].map(m => m[1]); // arriba, derecha, abajo, izquierda
const word = src.match(/<path fill="#141312" transform="translate\(109.314 72.3\)" d="([^"]+)"/)[1];

const PAPEL = '#F6F4F3', TINTA = '#141312';
// Los cuatro colores en el sentido del reloj desde arriba: tu tiempo, tu primer paso, el lugar y lo que decides.
const C = [
  { n: 'amarillo', i: '#FFD54A', claro: '#FFE57E', vecino: '#F6C06A' },
  { n: 'cielo', i: '#9DD6F4', claro: '#B5E3FC', vecino: '#A9C6F2' },
  { n: 'lima', i: '#B3E788', claro: '#C8F3A6', vecino: '#9FDDA6' },
  { n: 'rubor', i: '#F6A3CB', claro: '#FDB7D8', vecino: '#E9A3D8' },
];
for (const c of C) c.hondo = c.n === 'amarillo' ? legible(c.i, PAPEL, 3, -25) : legible(c.i, PAPEL, 3);
for (const c of C) c.hondo2 = c.n === 'amarillo' ? legible(c.i, PAPEL, 4.5, -25) : legible(c.i, PAPEL, 4.5);

// Logotipo: ocupa x 115,3 a 406,8 e y 0 a 73,7 en la retícula del logo horizontal.
const WX0 = 6, WX1 = 297.5; // en el espacio propio del trazado del logotipo
const VB = '0 0 406.214 85.314';
const g = (id, stops, x0 = WX0, x1 = WX1, y0 = 0, y1 = 0) =>
  `<linearGradient id="${id}" gradientUnits="userSpaceOnUse" x1="${x0}" y1="${y0}" x2="${x1}" y2="${y1}">${stops.map(([o, c]) => `<stop offset="${o}" stop-color="${c}"/>`).join('')}</linearGradient>`;
const radialLuz = () => C.map((c, k) => {
  const ctr = [[50, 13.05], [86.95, 50], [50, 86.95], [13.05, 50]][k];
  return `<radialGradient id="r${k}" gradientUnits="userSpaceOnUse" cx="${ctr[0]}" cy="${ctr[1]}" r="42.05"><stop offset="0" stop-color="${c.claro}"/><stop offset=".55" stop-color="${c.i}"/><stop offset="1" stop-color="${C[k].i}"/></radialGradient>`;
}).join('');
// Tres tonos vecinos por círculo, en diagonal (como las superficies de la memoria v8).
const vecinos = () => C.map((c, k) => g(`v${k}`, [[0, c.claro], [0.55, c.i], [1, c.vecino]], 0, 100, 0, 100)).join('');
// Cada círculo pasa suavemente hacia el color del siguiente, en el sentido del reloj.
const turno = () => C.map((c, k) => {
  const nx = C[(k + 1) % 4];
  const d = [[0, 0.5, 1, 0.5], [0.5, 0, 0.5, 1], [1, 0.5, 0, 0.5], [0.5, 1, 0.5, 0]][k]; // hacia el círculo siguiente
  return `<linearGradient id="t${k}" x1="${d[0]}" y1="${d[1]}" x2="${d[2]}" y2="${d[3]}"><stop offset="0" stop-color="${c.i}"/><stop offset=".55" stop-color="${c.i}"/><stop offset="1" stop-color="${mixOk(c.i, nx.i, 0.55)}"/></linearGradient>`;
}).join('');
const marcaSvg = fills => `<g transform="scale(0.853)">${marca.map((d, k) => `<path fill="${fills[k]}" d="${d}"/>`).join('')}</g>`;
const wordSvg = fill => `<path fill="${fill}" transform="translate(109.314 72.3)" d="${word}"/>`;
const svg = (defs, m, w) => `<svg xmlns="http://www.w3.org/2000/svg" viewBox="${VB}"><defs>${defs}</defs>${m}${w}</svg>`;

const plano = C.map(c => c.i);
const ORD = [2, 1, 3, 0]; // por tono, sin pasar por el oliva: lima, cielo, rubor, amarillo
function mixOk(a, b, t) { const A = rgb2oklch(a), B = rgb2oklch(b); let dh = B[2] - A[2]; if (dh > 180) dh -= 360; if (dh < -180) dh += 360; return oklch2hex(A[0] + (B[0] - A[0]) * t, A[1] + (B[1] - A[1]) * t, A[2] + dh * t); }
function ramp(cols) { const out = []; const n = cols.length - 1; for (let k = 0; k < n; k++) for (let j = 0; j < 6; j++) { const t = j / 6; out.push([(k + t) / n, mixOk(cols[k], cols[k + 1], t)]); } out.push([1, cols[n]]); return out.map(([o, c]) => [+o.toFixed(4), c]); }
const four = (key) => ramp(ORD.map(i => C[i][key]));
const V = [];
const add = (id, titulo, nota, fondo, defs, m, w) => { const p = "x" + id.replace(/[^a-z0-9]/g, ""); const fix = t => t.replace(/id="([a-z0-9]+)"/g, `id="${p}$1"`).replace(/url\(#([a-z0-9]+)\)/g, `url(#${p}$1)`); V.push({ id, titulo, nota, fondo, svg: svg(fix(defs), fix(m), fix(w)) }); };

add('01-actual', 'Actual', 'La marca con su degradado radial y el logotipo en tinta (D-125, D-127).', PAPEL,
  radialLuz(), marcaSvg(C.map((_, k) => `url(#r${k})`)), wordSvg(TINTA));
add('02-marca-tres-tonos', 'Marca con tres tonos vecinos', 'Cada círculo va de su tono claro a su color y a un tono vecino, en diagonal: el degradado sutil de las figuras de la memoria v8. Logotipo en tinta.', PAPEL,
  vecinos(), marcaSvg(C.map((_, k) => `url(#v${k})`)), wordSvg(TINTA));
add('03-marca-pasa-el-turno', 'Marca que pasa el turno', 'Cada círculo termina en el color del siguiente, en el sentido del reloj: los cuatro se tocan sin un corte de color. Logotipo en tinta.', PAPEL,
  turno(), marcaSvg(C.map((_, k) => `url(#t${k})`)), wordSvg(TINTA));
add('04-logotipo-cuatro-colores', 'Logotipo con los cuatro colores', 'El logotipo recorre los cuatro colores ordenados por tono —lima, cielo, rubor, amarillo— para que el paso sea limpio y no pase por el oliva, en sus tonos hondos, legibles sobre el papel (contraste 3:1).', PAPEL,
  vecinos() + g('w', four('hondo')), marcaSvg(C.map((_, k) => `url(#v${k})`)), wordSvg('url(#w)'));
add('05-logotipo-cuatro-colores-claros', 'Logotipo con los cuatro colores, claros', 'Los mismos colores de la marca, sin oscurecer. Es el más luminoso, pero sobre el papel se lee poco (contraste de 1,3 a 1,7).', PAPEL,
  vecinos() + g('w', four('i')), marcaSvg(C.map((_, k) => `url(#v${k})`)), wordSvg('url(#w)'));
C.forEach((c, k) => add(`06${'abcd'[k]}-logotipo-${c.n}`, `Logotipo en ${c.n}`, `Un solo color, con un degradado sutil de su tono hondo a uno más profundo (${c.hondo} → ${c.hondo2}).`, PAPEL,
  vecinos() + g('w', [[0, c.hondo], [1, c.hondo2]]), marcaSvg(C.map((_, j) => `url(#v${j})`)), wordSvg('url(#w)')));
add('07-tinta-con-color', 'Tinta que se tiñe', 'El logotipo empieza en tinta y termina, apenas, en el celeste hondo. Casi no se nota de lejos.', PAPEL,
  vecinos() + g('w', [[0, TINTA], [0.55, TINTA], [1, C[1].hondo2]]), marcaSvg(C.map((_, k) => `url(#v${k})`)), wordSvg('url(#w)'));
add('08-sobre-tinta-blanco', 'Sobre tinta, logotipo blanco', 'La marca en color y el logotipo en blanco, sobre la tinta.', TINTA,
  vecinos(), marcaSvg(C.map((_, k) => `url(#v${k})`)), wordSvg('#FFFFFF'));
add('09-sobre-tinta-cuatro-colores', 'Sobre tinta, logotipo con los cuatro colores', 'Sobre la tinta los colores claros se leen bien (contraste de 11 a 13): el logotipo puede llevarlos sin oscurecer.', TINTA,
  vecinos() + g('w', four('claro')), marcaSvg(C.map((_, k) => `url(#v${k})`)), wordSvg('url(#w)'));
const bgHondo = `<linearGradient id="bg" x1="0" y1="0" x2="1" y2="1">${four('hondo').map(([o, c]) => `<stop offset="${o}" stop-color="${c}"/>`).join('')}</linearGradient>`;
add('10-blanco-sobre-color', 'Todo en blanco, sobre los colores', 'Marca y logotipo en blanco, sobre un degradado de los cuatro tonos hondos.', 'url(#bg)',
  '', marcaSvg(C.map(() => '#FFFFFF')), wordSvg('#FFFFFF'));
add('11-blanco-sobre-cielo', 'Todo en blanco, sobre un color', 'Marca y logotipo en blanco, sobre el celeste hondo con un degradado sutil.', `linear-gradient(135deg, ${C[1].hondo}, ${C[1].hondo2})`,
  '', marcaSvg(C.map(() => '#FFFFFF')), wordSvg('#FFFFFF'));

fs.writeFileSync(path.join(__dirname, 'variantes.json'), JSON.stringify({ C, V: V.map(v => ({ ...v, svg: undefined })) }, null, 1));
for (const v of V) fs.writeFileSync(path.join(OUT, 'svg', `relevo-logo-${v.id}.svg`), v.svg);

// Lámina para revisar: una tarjeta por variante.
const card = v => {
  const bg = v.fondo === 'url(#bg)' ? `linear-gradient(135deg, ${four('hondo').map(([o, c]) => `${c} ${o * 100}%`).join(', ')})` : v.fondo;
  const dark = v.fondo !== PAPEL;
  return `<figure><div class="lienzo" style="background:${bg}">${v.svg}</div><figcaption><b>${v.titulo}</b><span>${v.nota}</span></figcaption></figure>`;
};
const html = `<!doctype html><html lang="es"><meta charset="utf-8"><title>Variantes del logo de Relevo</title>
<style>
body{margin:0;background:#FFFFFF;font-family:'Instrument Sans',system-ui,sans-serif;color:${TINTA}}
main{padding:72px 80px;max-width:1440px}
h1{font-size:44px;letter-spacing:-.02em;margin:0 0 8px}
p.bajada{font-size:20px;color:#6E6964;margin:0 0 48px;max-width:900px;line-height:1.4}
.grid{display:grid;grid-template-columns:repeat(2,1fr);gap:40px 32px}
figure{margin:0}
.lienzo{border-radius:28px;height:260px;display:flex;align-items:center;justify-content:center}
.lienzo svg{width:62%;height:auto}
figcaption{padding:14px 4px 0;display:flex;flex-direction:column;gap:4px;font-size:17px;line-height:1.35}
figcaption span{color:#6E6964}
.colores{display:flex;gap:14px;margin:0 0 48px}
.colores div{flex:1;border-radius:18px;overflow:hidden;font-size:14px}
.colores i{display:block;height:54px}
.colores small{display:block;padding:8px 2px;color:#6E6964}
</style><main>
<h1>Variantes del logo de Relevo</h1>
<p class="bajada">Degradados sutiles en la marca y color en el logotipo. Los trazados son los del logo vigente: cuatro círculos y «relevo» en Chillax Semibold.</p>
<div class="colores">${C.map(c => `<div><i style="background:linear-gradient(90deg,${c.claro},${c.i},${c.vecino})"></i><i style="background:linear-gradient(90deg,${c.hondo},${c.hondo2});height:30px"></i><small>${c.n}: ${c.i} · hondo ${c.hondo} (${contrast(c.hondo, PAPEL).toFixed(1)}:1)</small></div>`).join('')}</div>
<div class="grid">${V.map(card).join('')}</div></main></html>`;
fs.writeFileSync(path.join(OUT, 'lamina-variantes.html'), html);
console.log(V.length, 'variantes;', C.map(c => `${c.n} ${c.hondo} ${c.hondo2}`).join(' | '));
