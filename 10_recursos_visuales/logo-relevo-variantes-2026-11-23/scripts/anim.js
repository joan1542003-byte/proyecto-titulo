// Cuadros del GIF: el logotipo «relevo» pasa por los cuatro colores con un degradado sutil.
// Uso: node anim.js <carpeta> <papel|tinta>
const fs = require('fs');
const path = require('path');
const { oklch2hex, rgb2oklch } = require('./color.js');
const OUT = process.argv[2];
const MODO = process.argv[3] || 'papel';
fs.mkdirSync(OUT, { recursive: true });
const src = fs.readFileSync(path.join(__dirname, '..', '..', 'logo-relevo-2026-10-11', 'relevo-logo-horizontal-degradado.svg'), 'utf8');
const marca = [...src.matchAll(/<path fill="url\(#luz[TRBL]\)" d="([^"]+)"/g)].map(m => m[1]);
const word = src.match(/<path fill="#141312" transform="translate\(109.314 72.3\)" d="([^"]+)"/)[1];

const PAPEL = '#F6F4F3', TINTA = '#141312';
const C = [
  { n: 'amarillo', i: '#FFD54A', claro: '#FFE57E', vecino: '#F6C06A' },
  { n: 'cielo', i: '#9DD6F4', claro: '#B5E3FC', vecino: '#A9C6F2' },
  { n: 'lima', i: '#B3E788', claro: '#C8F3A6', vecino: '#9FDDA6' },
  { n: 'rubor', i: '#F6A3CB', claro: '#FDB7D8', vecino: '#E9A3D8' },
];
// Los colores originales: cada uno va de su tono claro (a) a su color (b).
for (const c of C) { c.a = c.claro; c.b = c.i; }
const ORD = [2, 1, 3, 0].map(i => C[i]); // lima, cielo, rubor, amarillo: por tono, sin pasar por el oliva

const lerp = (a, b, t) => a + (b - a) * t;
// Mezcla en OKLCH por el tono más corto; «alza» aclara el medio del paso si hiciera falta.
function mix(x, y, t, alza = 0) {
  const A = rgb2oklch(x), B = rgb2oklch(y);
  let dh = B[2] - A[2]; if (dh > 180) dh -= 360; if (dh < -180) dh += 360;
  const s = Math.sin(Math.PI * t);
  return oklch2hex(lerp(A[0], B[0], t) + alza * s, lerp(A[1], B[1], t) + alza * 0.4 * s, A[2] + dh * t);
}
const ss = t => t * t * (3 - 2 * t);
// Franja de color continua y cíclica: u en [0, 4). En cada tramo el color va de «a» a «b» (sutil) y al final pasa al siguiente.
function col(u) {
  u = ((u % 4) + 4) % 4;
  const k = Math.floor(u), t = u - k;
  const c = ORD[k], nx = ORD[(k + 1) % 4];
  const PASO = 0.3; // fracción del tramo dedicada al paso al color siguiente
  if (t < 1 - PASO) return mix(c.a, c.b, Math.min(1, t / 0.5)); // llega a su color a mitad del tramo
  const own = c.b;
    return mix(own, nx.a, ss((t - (1 - PASO)) / PASO));
}

// Marca fija: tres tonos vecinos por círculo, como la variante 02.
const vec = C.map((c, k) => `<linearGradient id="v${k}" gradientUnits="userSpaceOnUse" x1="0" y1="0" x2="100" y2="100"><stop offset="0" stop-color="${c.claro}"/><stop offset=".55" stop-color="${c.i}"/><stop offset="1" stop-color="${c.vecino}"/></linearGradient>`).join('');
const WX0 = 6, WX1 = 297.5;
const ANCHO = 0.55; // cuánto de la franja cabe en el logotipo: un degradado sutil, nunca un arcoíris
function frameSvg(s, id) {
  const stops = [];
  for (let j = 0; j <= 12; j++) stops.push(`<stop offset="${(j / 12).toFixed(3)}" stop-color="${col(s + ANCHO * j / 12)}"/>`);
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 406.214 85.314" width="720"><defs>${vec.replace(/id="v/g, `id="${id}v`)}<linearGradient id="${id}w" gradientUnits="userSpaceOnUse" x1="${WX0}" y1="0" x2="${WX1}" y2="0">${stops.join('')}</linearGradient></defs><g transform="scale(0.853)">${marca.map((d, k) => `<path fill="url(#${id}v${k})" d="${d}"/>`).join('')}</g><path fill="url(#${id}w)" transform="translate(109.314 72.3)" d="${word}"/></svg>`;
}

// Tiempo: 4 colores × 1,6 s; cada uno se queda quieto y luego se desliza al siguiente.
const FPS = 25, POR = 1.6, N = Math.round(4 * POR * FPS);
const QUIETO = 0.45; // fracción del tiempo de cada color en que no se mueve
const sAt = i => {
  const x = (i / N) * 4, k = Math.floor(x), f = x - k;
  const m = f < QUIETO ? 0 : ss((f - QUIETO) / (1 - QUIETO));
  // la ventana cabe entera en el tramo del color «k» mientras está quieto
  return k + m + 0.04;
};
const W = 880, H = 240, POR_PAGINA = 20;
const bg = MODO === 'papel' ? PAPEL : TINTA;
const paginas = Math.ceil(N / POR_PAGINA);
for (let p = 0; p < paginas; p++) {
  let body = '';
  for (let i = p * POR_PAGINA; i < Math.min(N, (p + 1) * POR_PAGINA); i++) body += `<div class="f">${frameSvg(sAt(i), 'f' + i)}</div>`;
  fs.writeFileSync(path.join(OUT, `p${String(p).padStart(2, '0')}.html`), `<!doctype html><meta charset="utf-8"><style>html,body{margin:0;background:${bg}}.f{width:${W}px;height:${H}px;display:flex;align-items:center;justify-content:center}</style>${body}`);
}
fs.writeFileSync(path.join(OUT, 'info.json'), JSON.stringify({ N, FPS, W, H, POR_PAGINA, paginas }));
console.log({ N, paginas });
