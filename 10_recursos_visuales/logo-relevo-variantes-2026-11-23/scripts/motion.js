// Familia de animaciones del logo de Relevo: cuadros SVG para Chrome.
// Uso: node motion.js <carpeta> <escena> <texto> <fondo> <formato>
//   escena:  revela | turno
//   texto:   tinta | blanco | cuatro | amarillo | cielo | lima | rubor | turno (toma el color de quien tiene el turno)
//   fondo:   papel | tinta | transparente
//   formato: horizontal | marca
//   estilo:  vecinos (cada círculo va de su claro a su color y a un tono vecino)
//            puntas-claras (cada círculo va de su color original, cerca del centro, a su tono claro en las puntas)
//            centro-claro (al revés: su tono claro en el centro y su color original en el borde)
//
// Principios (ver README, «Cómo se pensó el movimiento»): un solo gesto memorable, recorridos en arco,
// acciones que se superponen, resortes suaves en vez de rebotes, el logotipo que aparece desde su línea
// base y se queda quieto para leerse, y salidas más rápidas que las entradas.
const fs = require('fs');
const path = require('path');
const { oklch2hex, rgb2oklch } = require('./color.js');
const [OUT, ESCENA = 'revela', TEXTO = 'tinta', FONDO = 'papel', FORMATO = 'horizontal', ESTILO = 'vecinos'] = process.argv.slice(2);
const SUTIL = ESTILO !== 'vecinos'; // degradado sutil de un solo color: del original a su tono claro
fs.mkdirSync(OUT, { recursive: true });
const src = fs.readFileSync(path.join(__dirname, '..', '..', 'logo-relevo-2026-10-11', 'relevo-logo-horizontal-degradado.svg'), 'utf8');
const word = src.match(/<path fill="#141312" transform="translate\(109.314 72.3\)" d="([^"]+)"/)[1];

// El logotipo es un solo trazado: se separa en letras (r, e, l, e, v, o) juntando cada contraforma con su letra.
const letras = [];
for (const s of word.split(/(?=M)/)) {
  const xs = s.match(/-?\d*\.?\d+/g).map(Number).filter((_, i) => i % 2 === 0);
  const x0 = Math.min(...xs), x1 = Math.max(...xs);
  const prev = letras[letras.length - 1];
  if (prev && x0 >= prev.x0 - 0.5 && x0 <= prev.x1) { prev.d += s; prev.x1 = Math.max(prev.x1, x1); } else letras.push({ d: s, x0, x1 });
}

const PAPEL = '#F6F4F3', TINTA = '#141312';
const C = [
  { n: 'amarillo', i: '#FFD54A', claro: '#FFE57E', vecino: '#F6C06A' },
  { n: 'cielo', i: '#9DD6F4', claro: '#B5E3FC', vecino: '#A9C6F2' },
  { n: 'lima', i: '#B3E788', claro: '#C8F3A6', vecino: '#9FDDA6' },
  { n: 'rubor', i: '#F6A3CB', claro: '#FDB7D8', vecino: '#E9A3D8' },
];
const R = 29, D = 21, GAP = 3.4;
const ANG = [-90, 0, 90, 180];

// --- Curvas ---
const clamp = x => Math.max(0, Math.min(1, x));
function bezier(x1, y1, x2, y2) {
  const f = (t, a, b) => 3 * a * t * (1 - t) ** 2 + 3 * b * t * t * (1 - t) + t ** 3;
  return x => { x = clamp(x); let lo = 0, hi = 1, t = x; for (let i = 0; i < 30; i++) { t = (lo + hi) / 2; if (f(t, x1, x2) < x) lo = t; else hi = t; } return f(t, y1, y2); };
}
const entra = bezier(0, 0, 0.3, 1); // entrada expresiva (Carbon)
const sale = bezier(0.4, 0.14, 1, 1); // salida expresiva (Carbon)
const estandar = bezier(0.4, 0.14, 0.3, 1); // estándar expresiva (Carbon)
// Resorte amortiguado: llega, se pasa apenas y se asienta. z = amortiguación, T = período en segundos.
function resorte(t, z = 0.62, T = 0.8) {
  if (t <= 0) return 0;
  const w = (2 * Math.PI) / T, wd = w * Math.sqrt(1 - z * z);
  return 1 - Math.exp(-z * w * t) * (Math.cos(wd * t) + ((z * w) / wd) * Math.sin(wd * t));
}

// --- Color ---
function mixOk(a, b, t) { const A = rgb2oklch(a), B = rgb2oklch(b); let dh = B[2] - A[2]; if (dh > 180) dh -= 360; if (dh < -180) dh += 360; return oklch2hex(A[0] + (B[0] - A[0]) * t, A[1] + (B[1] - A[1]) * t, A[2] + dh * t); }
const ORD = [2, 1, 3, 0];
function rampa(cols) { const out = []; const n = cols.length - 1; for (let k = 0; k < n; k++) for (let j = 0; j < 4; j++) out.push([(k + j / 4) / n, mixOk(cols[k], cols[k + 1], j / 4)]); out.push([1, cols[n]]); return out; }
const cuatro = rampa(ORD.flatMap(i => [C[i].claro, C[i].i]));
// Con el degradado sutil, el texto va de su color original en la línea base a su tono claro arriba.
const unColor = c => (SUTIL ? [[0, c.i], [1, c.claro]] : [[0, c.claro], [0.55, c.i], [1, c.i]]);
function stopsTexto(t) {
  if (TEXTO === 'tinta') return [[0, TINTA], [1, TINTA]];
  if (TEXTO === 'blanco') return [[0, '#FFFFFF'], [1, '#FFFFFF']];
  if (TEXTO === 'cuatro') return cuatro;
  if (TEXTO === 'turno') { const { k, m } = turnoColor(t); const a = unColor(C[k]), b = unColor(C[(k + 1) % 4]); return a.map(([o, x], j) => [o, mixOk(x, b[j][1], m)]); }
  return unColor(C.find(c => c.n === TEXTO));
}

// --- Escenas: estado de los círculos, del grupo y de las letras en el tiempo t ---
let DUR;
const BEAT = 1.5; // un turno
function turnoColor(t) {
  // En «revela» el texto toma el amarillo, que tiene el primer turno.
  if (ESCENA !== 'turno') return { k: 0, m: 0 };
  const k = Math.floor(t / BEAT) % 4, tau = t % BEAT;
  return { k, m: estandar((tau - 0.28) / 0.75) }; // m: avance del barrido de color en el texto
}
function escena(t) {
  if (ESCENA === 'revela') {
    // 0,15 s: la marca se despliega desde el centro, girando en arco; cada círculo sale 90 ms después del anterior.
    // 0,75 s: las letras suben desde su línea base, una tras otra (45 ms), mientras la marca termina de asentarse.
    // 2,0 a 3,95 s: quieto, para leerse. 3,95 s: sale, más rápido que la entrada. Vuelve a empezar en 4,6 s.
    DUR = 4.6;
    const SAL = 3.95;
    const fuera = sale(clamp((t - SAL) / 0.4));
    const circ = C.map((_, k) => {
      const p = resorte(t - 0.15 - k * 0.09, 0.62, 0.85);
      return { a: ANG[k], d: D * p * (1 - fuera), r: R * Math.min(p, 1.06) * (1 - fuera) };
    });
    const rot = -110 * (1 - resorte(t - 0.15, 0.72, 1.15)) + 40 * fuera;
    const let_ = letras.map((_, i) => {
      const e = entra(clamp((t - 0.75 - i * 0.045) / 0.5));
      const s = sale(clamp((t - SAL - (letras.length - 1 - i) * 0.025) / 0.3));
      return { y: 80 * (1 - e) + 80 * s };
    });
    return { circ, rot, let_ };
  }
  // turno: la marca armada pasa el turno al siguiente cada 1,5 s. Primero se recoge 4° hacia atrás (anticipación,
  // 180 ms); luego gira un cuarto de vuelta con un resorte casi sin rebote (se pasa un 2 %) y se queda quieta.
  // El círculo que sube a tomar el turno crece apenas, y el texto cambia a su color con un barrido de izquierda a derecha.
  DUR = BEAT * 4;
  const k = Math.floor(t / BEAT), tau = t - k * BEAT;
  const ANT = 0.18;
  const giro = tau < ANT ? 4 * estandar(tau / ANT) : -90 * resorte(tau - ANT, 0.78, 0.95) + 4 * (1 - resorte(tau - ANT, 0.78, 0.95));
  const rot = -90 * k + giro;
  const circ = C.map((_, j) => {
    const llega = (j === (k + 1) % 4) ? Math.sin(Math.PI * clamp((tau - 0.35) / 0.75)) : 0;
    return { a: ANG[j], d: D + 1.6 * llega, r: R + 1 * llega };
  });
  return { circ, rot, let_: letras.map(() => ({ y: 0 })) };
}

// --- Dibujo ---
const vec = id => C.map((c, k) => {
  if (ESTILO === 'puntas-claras') return `<radialGradient id="${id}v${k}" gradientUnits="userSpaceOnUse" cx="50" cy="50" r="50"><stop offset=".3" stop-color="${c.i}"/><stop offset="1" stop-color="${c.claro}"/></radialGradient>`;
  if (ESTILO === 'centro-claro') return `<radialGradient id="${id}v${k}" gradientUnits="userSpaceOnUse" cx="50" cy="50" r="50"><stop offset=".15" stop-color="${c.claro}"/><stop offset=".85" stop-color="${c.i}"/></radialGradient>`;
  return `<linearGradient id="${id}v${k}" gradientUnits="userSpaceOnUse" x1="0" y1="0" x2="100" y2="100"><stop offset="0" stop-color="${c.claro}"/><stop offset=".55" stop-color="${c.i}"/><stop offset="1" stop-color="${c.vecino}"/></linearGradient>`;
}).join('');
const pos = s => [50 + s.d * Math.cos((s.a * Math.PI) / 180), 50 + s.d * Math.sin((s.a * Math.PI) / 180)];
function marca(S, id) {
  let defs = vec(id), body = '';
  S.circ.forEach((s, k) => {
    if (s.r <= 0.05) return;
    const nx = S.circ[(k + 1) % 4];
    const [x, y] = pos(s);
    let mask = '';
    if (nx.r > 0.05) {
      const [nxX, nxY] = pos(nx);
      defs += `<mask id="${id}m${k}" maskUnits="userSpaceOnUse" x="-40" y="-40" width="180" height="180"><rect x="-40" y="-40" width="180" height="180" fill="#fff"/><circle cx="${nxX.toFixed(3)}" cy="${nxY.toFixed(3)}" r="${(nx.r + GAP * Math.min(1, nx.r / R)).toFixed(3)}" fill="#000"/></mask>`;
      mask = ` mask="url(#${id}m${k})"`;
    }
    body += `<circle cx="${x.toFixed(3)}" cy="${y.toFixed(3)}" r="${s.r.toFixed(3)}" fill="url(#${id}v${k})"${mask}/>`;
  });
  return { defs, body: `<g transform="rotate(${S.rot.toFixed(3)} 50 50)">${body}</g>` };
}
function grad(id, stops) {
  const eje = SUTIL && TEXTO !== 'cuatro' ? 'x1="0" y1="0" x2="0" y2="-72.3"' : 'x1="6" y1="0" x2="297.5" y2="0"'; // vertical con el degradado sutil
  return `<linearGradient id="${id}" gradientUnits="userSpaceOnUse" ${eje}>${stops.map(([o, c]) => `<stop offset="${(+o).toFixed(4)}" stop-color="${c}"/>`).join('')}</linearGradient>`;
}
function texto(S, t, id) {
  const letrasSvg = letras.map((l, i) => `<path transform="translate(0 ${S.let_[i].y.toFixed(3)})" d="${l.d}"/>`).join('');
  let defs = `<clipPath id="${id}c"><rect x="-10" y="-90" width="320" height="92.5"/></clipPath>`;
  let capas;
  if (TEXTO === 'turno' && ESCENA === 'turno') {
    // Dos capas: el color de quien tenía el turno y, encima, el de quien lo recibe, descubierto por un borde suave que avanza.
    const { k, m } = turnoColor(t);
    const BANDA = 24, E = 6 - BANDA / 2 + (297.5 - 6 + BANDA) * m;
    defs += grad(`${id}wa`, unColor(C[k])) + grad(`${id}wb`, unColor(C[(k + 1) % 4]));
    defs += `<linearGradient id="${id}bm" gradientUnits="userSpaceOnUse" x1="${(E - BANDA / 2).toFixed(2)}" y1="0" x2="${(E + BANDA / 2).toFixed(2)}" y2="0"><stop offset="0" stop-color="#fff"/><stop offset="1" stop-color="#000"/></linearGradient><mask id="${id}mb" maskUnits="userSpaceOnUse" x="-20" y="-100" width="340" height="120"><rect x="-20" y="-100" width="340" height="120" fill="url(#${id}bm)"/></mask>`;
    capas = `<g fill="url(#${id}wa)">${letrasSvg}</g>` + (m > 0 ? `<g mask="url(#${id}mb)" fill="url(#${id}wb)">${letrasSvg}</g>` : '');
  } else {
    defs += grad(`${id}w`, stopsTexto(t));
    capas = `<g fill="url(#${id}w)">${letrasSvg}</g>`;
  }
  return { defs, body: `<g transform="translate(109.314 72.3)" clip-path="url(#${id}c)">${capas}</g>` };
}
const FPS = 50;
escena(0);
const N = Math.round(DUR * FPS);
function cuadro(i) {
  const t = i / FPS, id = 'f' + i, S = escena(t);
  const m = marca(S, id);
  if (FORMATO === 'marca') return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="-18 -18 136 136" width="400" height="400"><defs>${m.defs}</defs>${m.body}</svg>`;
  const w = texto(S, t, id);
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="-12 -12 430.214 109.314" width="760"><defs>${m.defs}${w.defs}</defs><g transform="scale(0.853)">${m.body}</g>${w.body}</svg>`;
}
const [W, H] = FORMATO === 'marca' ? [480, 480] : [880, 260];
const POR_PAGINA = FORMATO === 'marca' ? 10 : 16;
const paginas = Math.ceil(N / POR_PAGINA);
const bg = FONDO === 'tinta' ? TINTA : FONDO === 'transparente' ? 'transparent' : PAPEL;
for (let p = 0; p < paginas; p++) {
  let html = '';
  for (let i = p * POR_PAGINA; i < Math.min(N, (p + 1) * POR_PAGINA); i++) html += `<div class="f">${cuadro(i)}</div>`;
  fs.writeFileSync(path.join(OUT, `p${String(p).padStart(2, '0')}.html`), `<!doctype html><meta charset="utf-8"><style>html,body{margin:0;background:${bg}}.f{width:${W}px;height:${H}px;display:flex;align-items:center;justify-content:center}</style>${html}`);
}
fs.writeFileSync(path.join(OUT, 'info.json'), JSON.stringify({ N, FPS, W, H, POR_PAGINA, paginas, letras: letras.length }));
console.log({ ESCENA, TEXTO, FONDO, FORMATO, ESTILO, N, paginas, letras: letras.length });
