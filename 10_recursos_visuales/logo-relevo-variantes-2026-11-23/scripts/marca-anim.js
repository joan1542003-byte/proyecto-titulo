// Cuadros de las animaciones de la marca (los cuatro círculos), sin mover el logotipo.
// Uso: node marca-anim.js <carpeta> <arma|turno> <marca|horizontal>
//
// La marca son cuatro círculos de radio 29, a 21 del centro, en el sentido del reloj desde arriba:
// amarillo, cielo, lima y rubor. Cada uno lleva el mordisco del siguiente (un círculo 3,4 más grande).
// Aquí se dibujan con máscaras, así cada círculo puede moverse y crecer y los mordiscos lo siguen.
const fs = require('fs');
const path = require('path');
const OUT = process.argv[2];
const ANIM = process.argv[3] || 'arma';
const FORMATO = process.argv[4] || 'marca';
fs.mkdirSync(OUT, { recursive: true });
const src = fs.readFileSync(path.join(__dirname, '..', '..', 'logo-relevo-2026-10-11', 'relevo-logo-horizontal-degradado.svg'), 'utf8');
const word = src.match(/<path fill="#141312" transform="translate\(109.314 72.3\)" d="([^"]+)"/)[1];

const PAPEL = '#F6F4F3', TINTA = '#141312';
const C = [
  { n: 'amarillo', i: '#FFD54A', claro: '#FFE57E', vecino: '#F6C06A' },
  { n: 'cielo', i: '#9DD6F4', claro: '#B5E3FC', vecino: '#A9C6F2' },
  { n: 'lima', i: '#B3E788', claro: '#C8F3A6', vecino: '#9FDDA6' },
  { n: 'rubor', i: '#F6A3CB', claro: '#FDB7D8', vecino: '#E9A3D8' },
];
const R = 29, D = 21, GAP = 3.4;
const ANG = [-90, 0, 90, 180]; // arriba, derecha, abajo, izquierda

const clamp = x => Math.max(0, Math.min(1, x));
const ss = t => t * t * (3 - 2 * t);
const outBack = t => { const c = 1.25; return 1 + (c + 1) * (t - 1) ** 3 + c * (t - 1) ** 2; }; // llega con un leve rebote
const inOut = t => (t < 0.5 ? 4 * t ** 3 : 1 - (-2 * t + 2) ** 3 / 2);

// Estado de cada círculo en el tiempo t (segundos): ángulo, distancia al centro y radio.
let DUR;
function estado(t) {
  if (ANIM === 'arma') {
    // Se arma: cada círculo sale del anterior y gira un cuarto de vuelta hasta su lugar. El último cierra con el primero.
    DUR = 5.2;
    const ESC = 0.42, VIAJE = 0.95, QUIETO = 2.95, SALIDA = 4.6;
    return C.map((_, k) => {
      if (t >= SALIDA) {
        // Se recogen los cuatro juntos hacia el centro, girando, y vuelve a empezar.
        const q = ss(clamp((t - SALIDA) / 0.5));
        return { a: ANG[k] + 45 * q, d: D * (1 - q), r: R * (1 - q) };
      }
      const p = clamp((t - k * ESC) / VIAJE);
      if (p <= 0) return { a: ANG[k], d: 0, r: 0 };
      const e = outBack(p);
      const desde = k === 0 ? ANG[0] : ANG[k] - 90; // del lugar del anterior
      return { a: desde + (ANG[k] - desde) * ss(p), d: k === 0 ? D * e : D * Math.min(1.08, 0.35 + 0.65 * e), r: R * e };
    });
  }
  // Pasa el turno: el turno recorre los cuatro en el sentido del reloj; quien lo tiene da un paso afuera y crece apenas.
  DUR = 3.6;
  const POR = DUR / 4;
  return C.map((_, k) => {
    let x = ((t / POR - k) % 4 + 4) % 4; // 0 cuando le llega el turno
    const w = x < 1.4 ? Math.sin(Math.PI * clamp(x / 1.4)) : 0;
    const s = inOut(w);
    return { a: ANG[k], d: D + 4.5 * s, r: R + 2.2 * s };
  });
}

const vec = (id) => C.map((c, k) => `<linearGradient id="${id}v${k}" gradientUnits="userSpaceOnUse" x1="0" y1="0" x2="100" y2="100"><stop offset="0" stop-color="${c.claro}"/><stop offset=".55" stop-color="${c.i}"/><stop offset="1" stop-color="${c.vecino}"/></linearGradient>`).join('');
const pos = s => [50 + s.d * Math.cos((s.a * Math.PI) / 180), 50 + s.d * Math.sin((s.a * Math.PI) / 180)];
function marcaSvg(t, id) {
  const S = estado(t);
  let defs = vec(id), body = '';
  S.forEach((s, k) => {
    if (s.r <= 0.05) return;
    const nx = S[(k + 1) % 4];
    const [x, y] = pos(s);
    let mask = '';
    if (nx.r > 0.05) {
      const [nxX, nxY] = pos(nx);
      defs += `<mask id="${id}m${k}" maskUnits="userSpaceOnUse" x="-30" y="-30" width="160" height="160"><rect x="-30" y="-30" width="160" height="160" fill="#fff"/><circle cx="${nxX.toFixed(3)}" cy="${nxY.toFixed(3)}" r="${(nx.r + GAP * (nx.r / R)).toFixed(3)}" fill="#000"/></mask>`;
      mask = ` mask="url(#${id}m${k})"`;
    }
    body += `<circle cx="${x.toFixed(3)}" cy="${y.toFixed(3)}" r="${s.r.toFixed(3)}" fill="url(#${id}v${k})"${mask}/>`;
  });
  return { defs, body };
}

const FPS = 25;
estado(0);
const N = Math.round(DUR * FPS);
function frameSvg(i) {
  const id = 'f' + i;
  const { defs, body } = marcaSvg(i / FPS, id);
  if (FORMATO === 'marca') return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="-14 -14 128 128" width="440" height="440"><defs>${defs}</defs>${body}</svg>`;
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="-10 -10 426.214 105.314" width="760"><defs>${defs}</defs><g transform="scale(0.853)">${body}</g><path fill="${TINTA}" transform="translate(109.314 72.3)" d="${word}"/></svg>`;
}
const [W, H] = FORMATO === 'marca' ? [520, 520] : [880, 260];
const POR_PAGINA = FORMATO === 'marca' ? 12 : 20;
const paginas = Math.ceil(N / POR_PAGINA);
for (let p = 0; p < paginas; p++) {
  let html = '';
  for (let i = p * POR_PAGINA; i < Math.min(N, (p + 1) * POR_PAGINA); i++) html += `<div class="f">${frameSvg(i)}</div>`;
  fs.writeFileSync(path.join(OUT, `p${String(p).padStart(2, '0')}.html`), `<!doctype html><meta charset="utf-8"><style>html,body{margin:0;background:${PAPEL}}.f{width:${W}px;height:${H}px;display:flex;align-items:center;justify-content:center}</style>${html}`);
}
fs.writeFileSync(path.join(OUT, 'info.json'), JSON.stringify({ N, FPS, W, H, POR_PAGINA, paginas }));
console.log({ ANIM, FORMATO, N, paginas });
