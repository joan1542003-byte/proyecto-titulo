// Animaciones sin palabras que explican Relevo.
// Uso: node explica.js <carpeta> <escena> [fondo]
//   escena: como-funciona (simple) | como-funciona-detallada | pelicula | tiempo | suena | primer-paso | decides
//   fondo:  transparente (por defecto) | blanco
// Con la variable PREVIEW="0.5,1,2.4" escribe una sola página con esos instantes, en una grilla, para revisar.
//
// La historia, en los cuatro colores de la marca:
//   tu tiempo (amarillo): el tiempo en el teléfono se llena como un anillo alrededor de la pantalla.
//   el lugar (lima): el turno pasa del teléfono al lugar donde empieza la actividad, y ahí suena el Tag.
//   tu primer paso (cielo): el libro se abre y pasa la primera hoja.
//   lo que decides (rubor): la elección queda marcada, y los cuatro colores forman la marca.
const fs = require('fs');
const path = require('path');
const { oklch2hex, rgb2oklch } = require(path.join(__dirname, '..', '..', 'logo-relevo-variantes-2026-11-23', 'scripts', 'color.js'));
const [OUT, ESCENA = 'pelicula', FONDO = 'transparente'] = process.argv.slice(2);
fs.mkdirSync(OUT, { recursive: true });
const src = fs.readFileSync(path.join(__dirname, '..', '..', 'logo-relevo-2026-10-11', 'relevo-logo-horizontal-degradado.svg'), 'utf8');
const marcaPaths = [...src.matchAll(/<path fill="url\(#luz[TRBL]\)" d="([^"]+)"/g)].map(m => m[1]);
const word = src.match(/<path fill="#141312" transform="translate\(109.314 72.3\)" d="([^"]+)"/)[1];
const letras = [];
for (const s of word.split(/(?=M)/)) {
  const xs = s.match(/-?\d*\.?\d+/g).map(Number).filter((_, i) => i % 2 === 0);
  const x0 = Math.min(...xs), x1 = Math.max(...xs);
  const prev = letras[letras.length - 1];
  if (prev && x0 >= prev.x0 - 0.5 && x0 <= prev.x1) { prev.d += s; prev.x1 = Math.max(prev.x1, x1); } else letras.push({ d: s, x0, x1 });
}

// --- Color ---
const TINTA = '#141312';
const COL = {
  amarillo: { i: '#FFD54A', c: '#FFE57E' },
  cielo: { i: '#9DD6F4', c: '#B5E3FC' },
  lima: { i: '#B3E788', c: '#C8F3A6' },
  rubor: { i: '#F6A3CB', c: '#FDB7D8' },
};
const ORDEN = ['amarillo', 'cielo', 'lima', 'rubor']; // en el sentido del reloj desde arriba
function mixOk(a, b, t) { const A = rgb2oklch(a), B = rgb2oklch(b); let dh = B[2] - A[2]; if (dh > 180) dh -= 360; if (dh < -180) dh += 360; return oklch2hex(A[0] + (B[0] - A[0]) * t, A[1] + (B[1] - A[1]) * t, A[2] + dh * t); }
const conBlanco = (hex, t) => { const [L, C, H] = rgb2oklch(hex); return oklch2hex(L + (1 - L) * t, C * (1 - t), H); };
const hondo = (hex, k) => { const [L, C, H] = rgb2oklch(hex); return oklch2hex(L - k, C * (1 + k), H); };

// --- Tiempo y curvas ---
const clamp = x => Math.max(0, Math.min(1, x));
const lerp = (a, b, t) => a + (b - a) * t;
const seg = (t, a, b) => clamp((t - a) / (b - a));
function bezier(x1, y1, x2, y2) {
  const f = (t, a, b) => 3 * a * t * (1 - t) ** 2 + 3 * b * t * t * (1 - t) + t ** 3;
  return x => { x = clamp(x); let lo = 0, hi = 1, t = x; for (let i = 0; i < 28; i++) { t = (lo + hi) / 2; if (f(t, x1, x2) < x) lo = t; else hi = t; } return f(t, y1, y2); };
}
const entra = bezier(0, 0, 0.3, 1);
const sale = bezier(0.4, 0.14, 1, 1);
const estandar = bezier(0.4, 0.14, 0.3, 1);
function resorte(t, z = 0.72, T = 0.9) {
  if (t <= 0) return 0;
  const w = (2 * Math.PI) / T, wd = w * Math.sqrt(1 - z * z);
  return 1 - Math.exp(-z * w * t) * (Math.cos(wd * t) + ((z * w) / wd) * Math.sin(wd * t));
}
const n2 = v => +v.toFixed(2);
const n3 = v => +v.toFixed(3);
const T_ = (x, y, s = 1, r = 0) => `translate(${n2(x)} ${n2(y)})${r ? ` rotate(${n2(r)})` : ''}${s !== 1 ? ` scale(${n3(s)})` : ''}`;

// --- Definiciones fijas (una vez por página) ---
const lin = (id, a, b, x2 = 0.35, y2 = 1) => `<linearGradient id="${id}" x1="0" y1="0" x2="${x2}" y2="${y2}"><stop offset="0" stop-color="${a}"/><stop offset="1" stop-color="${b}"/></linearGradient>`;
const DEFS = [
  lin('gTinta', '#2C2A28', '#0E0D0C', 0.7, 1),
  ...ORDEN.map(n => lin(`g_${n}`, COL[n].c, COL[n].i)),
  ...ORDEN.map(n => lin(`gh_${n}`, COL[n].i, hondo(COL[n].i, 0.06))),
  lin('gTag', '#FFFFFF', '#ECE8E4'),
  lin('gTapa', '#E4D8CB', '#D3C4B5', 0, 1),
  lin('gMueble', '#F0E8DF', '#E2D6CA', 0, 1),
  lin('gCajon', '#E6DBCF', '#D8CBBE', 0, 1),
  lin('gHoja', '#FFFFFF', '#F4F1EE', 1, 0),
  lin('gHojaIzq', '#F4F1EE', '#FFFFFF', 1, 0),
  lin('gInterior', conBlanco(COL.cielo.c, 0.55), conBlanco(COL.cielo.c, 0.2), 1, 0),
  ...['#E4DFDA,#D3CCC5', '#E1E4E2,#CDD2CF', '#E9E1DC,#D8CBC3', '#E2E0E6,#CFCCD7'].map((p, k) => lin(`gFoto${k}`, ...p.split(','), 0.6, 1)),
  ...['#DAD4CE,#C9C1B9', '#D8DCDA,#C4C9C6', '#E0D6D0,#CDBFB6'].map((p, k) => lin(`gAvatar${k}`, ...p.split(','), 1, 1)),
  `<radialGradient id="gSombra"><stop offset="0" stop-color="${TINTA}" stop-opacity=".16"/><stop offset=".55" stop-color="${TINTA}" stop-opacity=".07"/><stop offset="1" stop-color="${TINTA}" stop-opacity="0"/></radialGradient>`,
  ...ORDEN.map((n, k) => `<radialGradient id="gM${k}" gradientUnits="userSpaceOnUse" cx="50" cy="50" r="50"><stop offset=".3" stop-color="${COL[n].i}"/><stop offset="1" stop-color="${COL[n].c}"/></radialGradient>`),
  `<clipPath id="clipPantalla"><rect x="-81" y="-173" width="162" height="346" rx="24"/></clipPath>`,
  `<clipPath id="clipLetras"><rect x="-10" y="-90" width="320" height="92.5"/></clipPath>`,
].join('');

// --- Íconos (trazos de Lucide, 24 × 24) ---
const CORAZON = 'M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z';
const GLOBO = 'M7.9 20A9 9 0 1 0 4 16.1L2 22Z';

// --- Objetos ---
// Teléfono, centrado en su origen: 176 × 360.
const TRAZA = 'M0 -189H57A39 39 0 0 1 96 -150V150A39 39 0 0 1 57 189H-57A39 39 0 0 1 -96 150V-150A39 39 0 0 1 -57 -189Z';
function tarjeta(n, y) {
  const k = ((n % 4) + 4) % 4;
  return `<circle cx="-60" cy="${n2(y + 13)}" r="9" fill="url(#gAvatar${k % 3})"/>`
    + `<rect x="-45" y="${n2(y + 7)}" width="${[58, 44, 66, 50][k]}" height="7" rx="3.5" fill="#DCD6D0"/>`
    + `<rect x="-45" y="${n2(y + 17.5)}" width="${[36, 28, 40, 30][k]}" height="5" rx="2.5" fill="#E9E5E1"/>`
    + `<rect x="-72" y="${n2(y + 32)}" width="144" height="88" rx="14" fill="url(#gFoto${k})"/>`
    + `<circle cx="${[38, -36, 30, 42][k]}" cy="${n2(y + 55)}" r="8.5" fill="#FFFFFF" fill-opacity=".6"/>`
    + `<path d="M-58 ${n2(y + 120)}L${[-24, -8, -30, -16][k]} ${n2(y + 80)}L${[2, 18, -2, 10][k]} ${n2(y + 104)}L${[20, 34, 22, 30][k]} ${n2(y + 90)}L58 ${n2(y + 120)}Z" fill="${TINTA}" fill-opacity=".07"/>`
    + `<g transform="${T_(-72, y + 127, 0.62)}" fill="none" stroke="#A9A29B" stroke-width="2.3" stroke-linecap="round" stroke-linejoin="round"><path d="${CORAZON}"/><path d="${GLOBO}" transform="translate(30 0)"/></g>`
    + `<rect x="-72" y="${n2(y + 149)}" width="${[118, 96, 126, 104][k]}" height="6" rx="3" fill="#E9E5E1"/>`;
}
function feed(scroll) {
  const PASO = 172;
  let s = '';
  const n0 = Math.floor(scroll / PASO) - 1;
  for (let n = n0; n < n0 + 4; n++) { const y = -163 + n * PASO - scroll; if (y < -173 - PASO || y > 175) continue; s += tarjeta(n, y); }
  return s;
}
function bannerRelevo(p) {
  // Aviso de Relevo que baja por la pantalla: una cápsula clara con la marca y dos líneas, sin palabras.
  const y = lerp(-236, -120, p);
  return `<g transform="translate(0 ${n2(y)})"><rect x="-73" y="-24" width="146" height="48" rx="24" fill="#FFFFFF" fill-opacity=".97"/><rect x="-73" y="-24" width="146" height="48" rx="24" fill="none" stroke="${TINTA}" stroke-opacity=".08"/>`
    + `<g transform="translate(-64 -16) scale(.375)">${marcaPaths.map((d, k) => `<path fill="url(#gM${k})" d="${d}"/>`).join('')}</g>`
    + `<rect x="-20" y="-8" width="72" height="7.5" rx="3.75" fill="#D6D0CA"/><rect x="-20" y="5" width="48" height="6" rx="3" fill="#E4DFDA"/></g>`;
}
function telefono(p) {
  const op = p.op ?? 1;
  if (op <= 0) return '';
  let s = `<g transform="${T_(p.x, p.y, p.s, p.rot || 0)}" opacity="${n3(op)}">`;
  s += `<ellipse cx="0" cy="214" rx="92" ry="11" fill="url(#gSombra)"/>`;
  const tr = p.traza ?? 0;
  const va = p.vacia || 0;
  if (p.pista && va < 1) s += `<path d="${TRAZA}" fill="none" stroke="${COL.amarillo.i}" stroke-opacity="${n3(0.22 * p.pista * (1 - va))}" stroke-width="5.5"/>`;
  if (tr - va > 0.002) s += `<path d="${TRAZA}" pathLength="1" fill="none" stroke="url(#gh_amarillo)" stroke-width="${n2(5.5 + 3.5 * (p.pulso || 0))}" stroke-linecap="round" stroke-dasharray="${n3(tr - va)} 2" stroke-dashoffset="${n3(-va)}"/>`;
  s += `<rect x="-91" y="-110" width="4" height="30" rx="2" fill="#2C2A28"/><rect x="-91" y="-70" width="4" height="30" rx="2" fill="#2C2A28"/><rect x="87" y="-96" width="4" height="46" rx="2" fill="#2C2A28"/>`;
  s += `<rect x="-88" y="-180" width="176" height="360" rx="31" fill="url(#gTinta)"/>`;
  s += `<g clip-path="url(#clipPantalla)"><rect x="-81" y="-173" width="162" height="346" fill="#FBFAF9"/>${feed(p.scroll || 0)}`;
  if (p.dim) s += `<rect x="-81" y="-173" width="162" height="346" fill="${TINTA}" fill-opacity="${n3(0.1 * p.dim)}"/>`;
  if (p.blanca) s += `<rect x="-81" y="-173" width="162" height="346" fill="#FFFFFF" fill-opacity="${n3(p.blanca)}"/>`; // la pantalla se vuelve blanca (dentro del teléfono, para que se desvanezcan juntos)
  if (p.banner) s += bannerRelevo(p.banner);
  if (p.apagado) s += `<rect x="-81" y="-173" width="162" height="346" fill="#0F0E0D" fill-opacity="${n3(p.apagado)}"/>`;
  s += `</g><rect x="-22" y="-165" width="44" height="13" rx="6.5" fill="${TINTA}"/></g>`;
  return s;
}
// Tag: pequeño, claro, con el botón lima. Origen en su centro; 46 × 46.
function tag(p) {
  if ((p.op ?? 1) <= 0) return '';
  let s = `<g transform="${T_(p.x, p.y, p.s ?? 1)}" opacity="${n3(p.op ?? 1)}">`;
  for (const a of p.ondas || []) {
    const r = lerp(30, 104, entra(a)), o = (1 - a) ** 1.6 * clamp(a / 0.08); // cada onda nace suave
    s += `<circle r="${n2(r)}" fill="none" stroke="${hondo(COL.lima.i, 0.05)}" stroke-opacity="${n3(0.95 * o)}" stroke-width="${n2(lerp(4.5, 2.2, a))}"/>`;
  }
  s += `<ellipse cx="0" cy="25" rx="30" ry="5" fill="url(#gSombra)"/>`;
  s += `<g transform="rotate(${n2(p.vib || 0)})"><rect x="-23" y="-23" width="46" height="46" rx="15" fill="url(#gTag)"/><rect x="-23" y="-23" width="46" height="46" rx="15" fill="none" stroke="${TINTA}" stroke-opacity=".13"/>`;
  s += `<circle cx="-13" cy="-13" r="4" fill="none" stroke="${TINTA}" stroke-opacity=".2" stroke-width="1.4"/>`;
  s += `<circle r="${n2(10.5 * (1 + 0.18 * (p.boton || 0)))}" fill="url(#gh_lima)"/></g></g>`;
  return s;
}
// Velador: el lugar donde empieza la actividad. Origen en el centro de la cubierta; 240 de ancho.
function velador(p) {
  if ((p.op ?? 1) <= 0) return '';
  return `<g transform="${T_(p.x, p.y, p.s ?? 1)}" opacity="${n3(p.op ?? 1)}">`
    + `<ellipse cx="0" cy="152" rx="132" ry="9" fill="url(#gSombra)"/>`
    + `<rect x="-100" y="128" width="13" height="20" rx="4" fill="#CBBBAB"/><rect x="87" y="128" width="13" height="20" rx="4" fill="#CBBBAB"/>`
    + `<rect x="-110" y="10" width="220" height="124" rx="10" fill="url(#gMueble)"/>`
    + `<rect x="-96" y="32" width="192" height="48" rx="9" fill="url(#gCajon)"/>`
    + `<rect x="-17" y="52" width="34" height="8" rx="4" fill="#B2A291"/>`
    + `<rect x="-120" y="0" width="240" height="17" rx="7" fill="url(#gTapa)"/>`
    + `</g>`;
}
// Libro de pie, visto de frente. Origen en el centro de su base. Cerrado mide 72 × 110; abierto, 144.
function lineas(x0, ancho, desde) {
  let s = '';
  for (let k = 0; k < 7; k++) s += `<rect x="${n2(x0)}" y="${n2(-96 + k * 12)}" width="${n2(ancho * [1, 0.92, 0.97, 0.84, 1, 0.9, 0.6][(k + desde) % 7])}" height="4.4" rx="2.2" fill="#DED9D4"/>`;
  return s;
}
function hojaQueGira(g, spine, cara) {
  // g: 0 = sobre la página derecha, 1 = sobre la izquierda. La hoja gira sobre el lomo con un leve sesgo de perspectiva.
  const sx = Math.cos(Math.PI * g), sk = -Math.sin(Math.PI * g) * 6;
  return `<g transform="translate(${n2(spine)} 0) skewY(${n2(sk)}) scale(${n3(sx)} 1)">${cara(sx >= 0)}</g>`;
}
function libro(p) {
  if ((p.op ?? 1) <= 0) return '';
  const redondo = v => (v > 0.999 ? 1 : v < 0.001 ? 0 : v);
  const abre = redondo(p.abre || 0), hoja = redondo(p.hoja || 0);
  const tapa = frente => frente
    ? `<rect x="0" y="-112" width="74" height="113" rx="5" fill="url(#g_cielo)"/><rect x="0" y="-112" width="9" height="113" rx="3" fill="${hondo(COL.cielo.i, 0.08)}" fill-opacity=".55"/><rect x="21" y="-88" width="38" height="9" rx="4.5" fill="#FFFFFF" fill-opacity=".6"/><rect x="27" y="-73" width="26" height="5" rx="2.5" fill="#FFFFFF" fill-opacity=".45"/>`
    : `<rect x="0" y="-112" width="74" height="113" rx="5" fill="url(#gh_cielo)"/><rect x="0" y="-109" width="70" height="107" rx="3" fill="url(#gInterior)"/>`;
  const spine = -36 + 36 * estandar(abre); // el lomo llega al centro cuando el libro está abierto
  let s = `<g transform="${T_(p.x, p.y, p.s ?? 1)}" opacity="${n3(p.op ?? 1)}">`;
  s += `<ellipse cx="${n2(spine + 36 - 36 * abre)}" cy="3" rx="${n2(46 + 40 * abre)}" ry="5" fill="url(#gSombra)"/>`;
  // contratapa y bloque de páginas (a la derecha del lomo)
  s += `<rect x="${n2(spine)}" y="-112" width="74" height="113" rx="5" fill="url(#gh_cielo)"/>`;
  s += `<rect x="${n2(spine)}" y="-109" width="70" height="107" rx="3" fill="url(#gHoja)"/>`;
  s += lineas(spine + 10, 50, 3);
  // cuando la tapa ya pasó al lado izquierdo queda debajo de las hojas que se den vuelta
  if (abre > 0.5) s += hojaQueGira(abre, spine, tapa);
  if (hoja > 0) {
    if (hoja > 0.5) s += `<rect x="${n2(spine - 70)}" y="-109" width="70" height="107" rx="3" fill="url(#gHojaIzq)"/>` + lineas(spine - 60, 50, 0);
    s += hojaQueGira(hoja, spine, frente => `<rect x="0" y="-109" width="70" height="107" rx="3" fill="${frente ? 'url(#gHoja)' : 'url(#gHojaIzq)'}"/>` + (frente ? lineas(10, 50, 5) : lineas(10, 50, 0)));
  }
  // sombra suave del lomo cuando está abierto
  if (abre > 0.2) s += `<rect x="${n2(spine - 7)}" y="-109" width="14" height="107" fill="${TINTA}" fill-opacity="${n3(0.05 * clamp((abre - 0.2) / 0.5))}"/>`;
  // tapa, mientras todavía cubre las páginas
  if (abre <= 0.5) s += hojaQueGira(abre, spine, tapa);
  s += '</g>';
  return s;
}
// Lo que decides: un círculo rubor con un visto.
function visto(p) {
  if ((p.s || 0) <= 0.01) return '';
  return `<g transform="${T_(p.x, p.y, p.s, p.rot || 0)}" opacity="${n3(p.op ?? 1)}"><circle r="22" fill="url(#gh_rubor)"/><path d="M-9 0.5L-3 6.5L9.5 -6" fill="none" stroke="#FFFFFF" stroke-width="4.2" stroke-linecap="round" stroke-linejoin="round"/></g>`;
}
// La marca dibujada con círculos y máscaras, para que se pueda armar y girar.
const ANG = [-90, 0, 90, 180], R = 29, D = 21, GAP = 3.4;
function marcaViva(id, S, extra = '') {
  let defs = '', body = '';
  const pos = c => [50 + c.d * Math.cos((c.a * Math.PI) / 180), 50 + c.d * Math.sin((c.a * Math.PI) / 180)];
  S.circ.forEach((c, k) => {
    if (c.r <= 0.05) return;
    const nx = S.circ[(k + 1) % 4];
    const [x, y] = c.xy || pos(c);
    let mask = '';
    if (nx.r > 0.05) {
      const [a, b] = nx.xy || pos(nx);
      defs += `<mask id="${id}m${k}" maskUnits="userSpaceOnUse" x="-400" y="-400" width="900" height="900"><rect x="-400" y="-400" width="900" height="900" fill="#fff"/><circle cx="${n2(a)}" cy="${n2(b)}" r="${n2(nx.r + GAP * Math.min(1, nx.r / R))}" fill="#000"/></mask>`;
      mask = ` mask="url(#${id}m${k})"`;
    }
    body += `<circle cx="${n2(x)}" cy="${n2(y)}" r="${n2(c.r)}" fill="url(#gM${k})"${mask}/>`;
  });
  return { defs, body: `<g transform="rotate(${n2(S.rot || 0)} 50 50)"${extra}>${body}</g>` };
}
function logotipo(id, ys, colorA, colorB, m) {
  const L = letras.map((l, i) => `<path transform="translate(0 ${n2(ys[i])})" d="${l.d}"/>`).join('');
  const g = (gid, c) => `<linearGradient id="${gid}" gradientUnits="userSpaceOnUse" x1="0" y1="0" x2="0" y2="-72.3"><stop offset="0" stop-color="${COL[c].i}"/><stop offset="1" stop-color="${COL[c].c}"/></linearGradient>`;
  let defs = g(`${id}ta`, colorA), capas = `<g fill="url(#${id}ta)">${L}</g>`;
  if (colorB && m > 0) {
    const BANDA = 24, E = 6 - BANDA / 2 + (297.5 - 6 + BANDA) * m;
    defs += g(`${id}tb`, colorB) + `<linearGradient id="${id}bm" gradientUnits="userSpaceOnUse" x1="${n2(E - BANDA / 2)}" y1="0" x2="${n2(E + BANDA / 2)}" y2="0"><stop offset="0" stop-color="#fff"/><stop offset="1" stop-color="#000"/></linearGradient><mask id="${id}mb" maskUnits="userSpaceOnUse" x="-20" y="-100" width="340" height="120"><rect x="-20" y="-100" width="340" height="120" fill="url(#${id}bm)"/></mask>`;
    capas += `<g mask="url(#${id}mb)" fill="url(#${id}tb)">${L}</g>`;
  }
  return { defs, body: `<g transform="translate(109.314 72.3)" clip-path="url(#clipLetras)">${capas}</g>` };
}
// Un punto de color que viaja en arco, con una estela corta.
function viaje(t, a, b, desde, hasta, alto, color, colorFin, r = 7) {
  const P = u => { const e = estandar(u); const cx = (desde[0] + hasta[0]) / 2, cy = Math.min(desde[1], hasta[1]) - alto; return [(1 - e) ** 2 * desde[0] + 2 * (1 - e) * e * cx + e * e * hasta[0], (1 - e) ** 2 * desde[1] + 2 * (1 - e) * e * cy + e * e * hasta[1]]; };
  const u = seg(t, a, b);
  if (t < a || t > b + 0.02) return '';
  let s = '';
  for (let k = 7; k >= 0; k--) {
    const uu = clamp(u - k * 0.016);
    const [x, y] = P(uu);
    const c = colorFin ? mixOk(color, colorFin, seg(uu, 0.55, 1)) : color;
    s += `<circle cx="${n2(x)}" cy="${n2(y)}" r="${n2(r * (1 - k * 0.1) * lerp(0.6, 1, entra(seg(u, 0, 0.15))))}" fill="${c}" fill-opacity="${n3(k ? 0.3 * (1 - k / 8) : 1)}"/>`;
  }
  return s;
}

// --- Escenas ---
let W = 960, H = 540, DUR = 15.6;
const ESCALA_LOGO = 1.38;
function pelicula(t, id) {
  let defs = '', s = '';
  // 1. Tu tiempo: el teléfono y el anillo amarillo que se llena mientras se desliza el contenido.
  const flicks = [0.35, 1.15, 1.95, 2.75, 3.35];
  const scroll = flicks.reduce((acc, a) => acc + 150 * entra(seg(t, a, a + 0.75)), 0);
  const aparece = resorte(t - 0.05, 0.8, 0.9);
  const mueve = estandar(seg(t, 4.1, 5.1));
  const ph = {
    x: lerp(480, 268, mueve), y: lerp(270 + 16 * (1 - aparece), 292, mueve), s: lerp(0.94 + 0.06 * aparece, 0.8, mueve),
    op: seg(t, 0, 0.3) * (1 - seg(t, 7.35, 7.8)),
    scroll, pista: seg(t, 0.3, 0.6), traza: lerp(0, 1, seg(t, 0.6, 3.7) ** 1.05),
    pulso: Math.sin(Math.PI * seg(t, 3.7, 4.05)), dim: entra(seg(t, 3.8, 4.3)), banner: resorte(t - 3.82, 0.78, 0.8) * (1 - seg(t, 6.9, 7.2)),
    apagado: estandar(seg(t, 6.9, 7.3)), vacia: estandar(seg(t, 4.95, 5.35)),
  };
  // 2. El lugar: el velador con el libro y el Tag.
  const vel = { x: 650, y: 330 + 24 * (1 - resorte(t - 4.4, 0.8, 0.9)), op: seg(t, 4.4, 4.75) * (1 - seg(t, 11.15, 11.4)) };
  const lib = { x: 614, y: vel.y, s: (0.9 + 0.1 * resorte(t - 4.65, 0.75, 0.8)), op: seg(t, 4.65, 4.95) * (1 - seg(t, 11.2, 11.45)), abre: estandar(seg(t, 8.65, 9.65)), hoja: estandar(seg(t, 9.75, 10.5)) };
  const llegada = 5.85;
  const ondas = [0, 0.4, 0.8, 1.2, 1.6].map(d => t - llegada - d).filter(a => a >= 0 && a <= 1.2).map(a => a / 1.2);
  const vib = t > llegada && t < llegada + 1.9 ? 4 * Math.sin((t - llegada) * 2 * Math.PI * 9) * Math.sin(Math.PI * seg(t, llegada, llegada + 1.9)) : 0;
  const tg = { x: 712, y: vel.y - 18, s: 0.78 * (0.92 + 0.08 * resorte(t - 4.8, 0.75, 0.8)), op: seg(t, 4.8, 5.05) * (1 - seg(t, 11.15, 11.4)), ondas, vib, boton: Math.sin(Math.PI * seg(t, llegada, llegada + 0.35)) };
  // 3. Tu primer paso y 4. lo que decides: la cámara se acerca al libro; se abre, pasa una hoja y aparece el visto.
  const acerca = estandar(seg(t, 7.55, 8.75)), aleja = estandar(seg(t, 11.15, 12.1));
  const zoom = lerp(lerp(1, 1.75, acerca), 1, aleja);
  const cx = lerp(lerp(480, 614, acerca), 480, aleja), cy = lerp(lerp(270, 262, acerca), 270, aleja);
  const cam = `translate(480 270) scale(${n3(zoom)}) translate(${n2(-cx)} ${n2(-cy)})`;
  const vis = { x: 614, y: 330 - 152, s: resorte(t - 10.45, 0.62, 0.7), rot: -12 * (1 - resorte(t - 10.45, 0.7, 0.8)), op: 1 - seg(t, 11.25, 11.5) };
  s += `<g transform="${cam}">`;
  s += telefono(ph) + velador(vel) + libro(lib) + tag(tg) + visto(vis);
  // el turno pasa del teléfono al Tag: un punto amarillo que viaja y llega lima
  const cima = [ph.x, ph.y - 189 * ph.s];
  s += viaje(t, 5.0, 5.85, cima, [tg.x, tg.y], 150, COL.amarillo.i, COL.lima.i, 7);
  s += '</g>';
  // 5. La marca: cuatro puntos salen de donde ocurrió cada parte y forman la marca.
  if (t > 11.3) {
    const S = ESCALA_LOGO * 0.853;
    const lockup = estandar(seg(t, 13.05, 14.0));
    const mx = lerp(480, 480 - (406.214 * ESCALA_LOGO) / 2 + 42.66 * ESCALA_LOGO, lockup), my = 270;
    const aMundo = (lx, ly) => [mx + (lx - 50) * S, my + (ly - 50) * S];
    const camPt = (x, y) => [480 + (x - cx) * zoom, 270 + (y - cy) * zoom];
    const origen = [camPt(268, 292 - 189 * 0.8), camPt(lib.x + 36, lib.y - 56), camPt(tg.x, tg.y), camPt(vis.x, vis.y)];
    const ANTT = 12.85;
    const giro = t < ANTT ? 0 : t < ANTT + 0.18 ? 4 * estandar(seg(t, ANTT, ANTT + 0.18)) : -90 * resorte(t - ANTT - 0.18, 0.78, 0.95) + 4 * (1 - resorte(t - ANTT - 0.18, 0.78, 0.95));
    const circ = ORDEN.map((n, k) => {
      const ini = 11.45 + k * 0.08, fin = ini + 0.75;
      const u = seg(t, ini, fin);
      const dest = [50 + D * Math.cos((ANG[k] * Math.PI) / 180), 50 + D * Math.sin((ANG[k] * Math.PI) / 180)];
      const dw = aMundo(...dest);
      const e = estandar(u);
      const ctrl = [(origen[k][0] + dw[0]) / 2, Math.min(origen[k][1], dw[1]) - 60];
      const xy = [(1 - e) ** 2 * origen[k][0] + 2 * (1 - e) * e * ctrl[0] + e * e * dw[0], (1 - e) ** 2 * origen[k][1] + 2 * (1 - e) * e * ctrl[1] + e * e * dw[1]];
      const crece = resorte(t - fin + 0.12, 0.72, 0.8);
      const rMundo = lerp(7 * entra(seg(t, ini, ini + 0.15)), R * S, crece);
      // en coordenadas de la marca (0–100), para que los mordiscos sigan a cada círculo
      return { r: rMundo / S, xy: [(xy[0] - mx) / S + 50, (xy[1] - my) / S + 50], a: ANG[k], d: D };
    });
    const m = marcaViva(`${id}mk`, { circ, rot: 0 });
    defs += m.defs;
    s += `<g transform="translate(${n2(mx)} ${n2(my)}) scale(${n3(S)}) rotate(${n2(giro)}) translate(-50 -50)">${m.body}</g>`;
    if (t > 13.05) {
      const ys = letras.map((_, i) => 82 * (1 - entra(seg(t, 13.25 + i * 0.045, 13.75 + i * 0.045))));
      const w = logotipo(`${id}lt`, ys, 'amarillo', 'cielo', estandar(seg(t, 13.1, 13.9)));
      defs += w.defs;
      const x0 = mx - 42.66 * ESCALA_LOGO, y0 = 270 - (85.314 * ESCALA_LOGO) / 2; // el logotipo va pegado a la marca mientras se corre
      s += `<g transform="translate(${n2(x0)} ${n2(y0)}) scale(${ESCALA_LOGO})">${w.body}</g>`;
    }
  }
  return { defs, body: s };
}
// Bucles cuadrados (540 × 540), uno por idea.
function bucleTiempo(t) {
  // 4,8 s: el anillo se llena, llega el aviso, se queda un momento y vuelve a empezar.
  const scroll = [0.2, 0.95, 1.7, 2.45].reduce((acc, a) => acc + 150 * entra(seg(t, a, a + 0.75)), 0) - 600 * estandar(seg(t, 4.25, 4.8));
  const ph = { x: 270, y: 262, s: 1, scroll, pista: 1, traza: seg(t, 0.15, 3.1) * (1 - estandar(seg(t, 4.2, 4.75))), pulso: Math.sin(Math.PI * seg(t, 3.1, 3.45)), dim: entra(seg(t, 3.2, 3.6)) * (1 - seg(t, 4.2, 4.6)), banner: resorte(t - 3.22, 0.78, 0.8) * (1 - estandar(seg(t, 4.15, 4.55))) };
  return { defs: '', body: telefono(ph) };
}
function bucleSuena(t) {
  // 2,4 s: suena dos veces y descansa. El Tag está en el velador, junto al libro.
  const ondas = [0, 0.32, 0.64].map(d => t - d).filter(a => a >= 0 && a <= 1.25).map(a => a / 1.25);
  const vib = t < 1.1 ? 4 * Math.sin(t * 2 * Math.PI * 9) * Math.sin(Math.PI * seg(t, 0, 1.1)) : 0;
  return { defs: '', body: velador({ x: 270, y: 300 }) + libro({ x: 234, y: 300 }) + tag({ x: 334, y: 277, ondas, vib, boton: Math.sin(Math.PI * seg(t, 0, 0.35)) }) };
}
function buclePrimerPaso(t) {
  // 4,6 s: el libro se abre, pasa una hoja, se queda abierto y se cierra para volver a empezar.
  const abre = estandar(seg(t, 0.3, 1.3)) * (1 - estandar(seg(t, 3.7, 4.45)));
  const hoja = t < 3.6 ? estandar(seg(t, 1.45, 2.2)) : abre; // al cerrar, la hoja vuelve junto con la tapa
  return { defs: '', body: libro({ x: 270, y: 395, s: 2.3, abre, hoja }) };
}
function bucleDecides(t) {
  // 4,4 s: el teléfono se apaga y se aparta; el libro queda al frente y aparece el visto.
  const a = estandar(seg(t, 0.4, 1.2)), v = (1 - estandar(seg(t, 3.7, 4.3)));
  // el teléfono se apaga y se aleja un poco (más chico y más abajo), sin volverse gris
  const ph = { x: lerp(170, 152, a * v), y: lerp(262, 292, a * v), s: lerp(0.72, 0.6, a * v), scroll: 120 * entra(seg(t, 0, 0.6)), apagado: a * v, pista: 0 };
  const lb = { x: lerp(370, 380, a), y: 380, s: lerp(1.45, 1.6, a * v), abre: 1 };
  const vis = { x: lb.x, y: 380 - 110 * lb.s - 44, s: resorte(t - 1.25, 0.62, 0.7) * v, rot: -12 * (1 - resorte(t - 1.25, 0.7, 0.8)) };
  return { defs: '', body: telefono(ph) + libro(lb) + visto(vis) };
}
// --- Cómo funciona: un relevo completo, sin palabras ---
// Cada color dice siempre lo mismo, en el orden de la marca (en el sentido del reloj desde arriba) y de «Cómo funciona» en la app:
//   amarillo, tu tiempo (cuenta el tiempo en tus apps); cielo, tu primer paso (como abrir el libro);
//   lima, el lugar donde empiezas, donde suena el Tag; rubor, lo que decides (empezar, dejarlo o cambiar de idea).
// Los íconos son los de la app (Lucide 1.70.0, ISC, y el de Suena, propio con las reglas de Lucide).
const ICONOS = {
  tiempo: { trazos: ['M10 2L14 2', 'M4 14A8 8 0 1 0 20 14A8 8 0 1 0 4 14Z'], aguja: 'M12 14L15 11' },
  primerPaso: { trazos: ['M12 5v16', 'M20.001 19A2 2 0 0 0 22 17V5a2 2 0 0 0-1.999-2L16 3.002A5 5 0 0 0 12 5a5 5 0 0 0-4-2H4a2 2 0 0 0-2 2v12a2 2 0 0 0 1.999 2H8a5 5 0 0 1 4 2 5 5 0 0 1 4-2z'] },
  lugar: { trazos: ['M2 12A5.5 5.5 0 1 0 13 12A5.5 5.5 0 1 0 2 12Z', 'M7.5 12h0.01'], ondas: ['M14.218 5.282a9.5 9.5 0 0 1 0 13.435', 'M17.046 2.454a13.5 13.5 0 0 1 0 19.092'] },
  decides: { trazos: ['M4 22V4a1 1 0 0 1 .4-.8A6 6 0 0 1 8 2c3 0 5 2 7.333 2q2 0 3.067-.8A1 1 0 0 1 20 4v10a1 1 0 0 1-.4.8A6 6 0 0 1 16 16c-3 0-5-2-8-2a6 6 0 0 0-4 1.528'] },
};
const PARTES = [
  { n: 'amarillo', icono: 'tiempo' },
  { n: 'cielo', icono: 'primerPaso' },
  { n: 'lima', icono: 'lugar' },
  { n: 'rubor', icono: 'decides' },
];
const hexMix = (a, b, t) => '#' + [1, 3, 5].map(i => Math.round(lerp(parseInt(a.slice(i, i + 2), 16), parseInt(b.slice(i, i + 2), 16), t)).toString(16).padStart(2, '0')).join('');
const trazar = (d, p) => `<path d="${d}" pathLength="1" stroke-dasharray="1 1" stroke-dashoffset="${n3(1 - p)}"/>`;
function comoFunciona(t, id) {
  // 13 s, se repite.
  // 0–2,8 s   tu tiempo: el contenido se desliza y el anillo amarillo cuenta el tiempo alrededor del teléfono.
  // 2,85 s    el teléfono se vuelve el círculo amarillo, arriba, y aparece el reloj; la aguja da la vuelta.
  // 4,75 s    el turno pasa, en el sentido del reloj, al círculo cielo: tu primer paso, el libro se abre.
  // 6,4 s     pasa al círculo lima: el lugar donde empiezas; el Tag suena.
  // 8,1 s     pasa al círculo rubor: lo que decides; la bandera se levanta.
  // 9,45 s    el turno vuelve a tu tiempo y el círculo se cierra.
  // 9,85 s    los cuatro se juntan y son la marca. 11 s: aparece «relevo». 12,6 s: se desvanece y vuelve a empezar.
  const CX = 480, CY = 270, RD = 150, RC = 60;
  const pos = k => [CX + RD * Math.cos((ANG[k] * Math.PI) / 180), CY + RD * Math.sin((ANG[k] * Math.PI) / 180)];
  const salida = 1 - seg(t, 12.6, 13.0); // fundido final para el bucle
  let defs = '', body = '';
  // 1. Tu tiempo: el teléfono
  const S0 = 0.78;
  const scroll = [0.3, 1.05, 1.8].reduce((a, b) => a + 150 * entra(seg(t, b, b + 0.75)), 0);
  const blanca = entra(seg(t, 2.55, 2.85));
  const m = t < 2.85 ? 0 : resorte(t - 2.85, 0.8, 1.0); // del teléfono al círculo
  if (t < 2.86) {
    body += telefono({ x: CX, y: CY, s: S0, op: seg(t, 0, 0.3), scroll, pista: 1, traza: seg(t, 0.3, 2.5), pulso: Math.sin(Math.PI * seg(t, 2.5, 2.8)), blanca });
  }
  // círculos de las cuatro partes
  const conv = t < 9.95 ? 0 : resorte(t - 10.1, 0.78, 0.95); // se juntan en la marca
  const lleno = estandar(seg(t, 9.95, 10.3)); // de blanco con anillo a color lleno
  const lock = estandar(seg(t, 11.0, 11.8)); // la marca se corre y aparece el logotipo
  const SM = lerp(1.5, 1.25, lock); // escala de la marca (100 unidades)
  const ESC_L = SM / 0.853;
  const mx = lerp(CX, CX - (406.214 * ESC_L) / 2 + 42.66 * ESC_L, lock);
  const aparece = [t < 2.85 ? 0 : 1, resorte(t - 5.2, 0.7, 0.75), resorte(t - 6.85, 0.7, 0.75), resorte(t - 8.55, 0.7, 0.75)];
  const turno = [[3.4, 4.9], [5.2, 6.6], [6.85, 8.3], [8.55, 9.9]];
  const circ = PARTES.map((p, k) => {
    const activo = Math.sin(Math.PI * seg(t, turno[k][0], turno[k][1])) ** 0.5 * (t < turno[k][1] ? 1 : 0);
    const r0 = RC * aparece[k] * (1 + 0.06 * activo);
    const ang = (ANG[k] * Math.PI) / 180;
    const d = lerp(RD, D * SM, conv), r = lerp(r0, R * SM, conv);
    return { x: mx + d * Math.cos(ang), y: CY + d * Math.sin(ang), r, d };
  });
  // el teléfono se transforma en el círculo amarillo (termina en el tamaño que tiene el círculo en ese instante)
  const rcA = RC * (1 + 0.06 * Math.sin(Math.PI * seg(t, turno[0][0], turno[0][1])) ** 0.5);
  const enMorph = t >= 2.85 && t < 3.95;
  if (enMorph) {
    const [tx, ty] = pos(0);
    const X = lerp(CX, tx, m), Y = lerp(CY, ty, m);
    const caja = (w0, h0, r0, w1, h1, r1) => { const w = lerp(w0, w1, m), h = lerp(h0, h1, m), rx = lerp(r0, r1, m); return `x="${n2(X - w / 2)}" y="${n2(Y - h / 2)}" width="${n2(w)}" height="${n2(h)}" rx="${n2(rx)}"`; };
    const mb = clamp(m * 3); // en el primer tercio la pantalla blanca crece hasta cubrir el marco
    body += `<rect ${caja(176 * S0, 360 * S0, 31 * S0, 2 * rcA, 2 * rcA, rcA)} fill="${TINTA}"/>`;
    body += `<rect ${caja(lerp(162, 176, mb) * S0, lerp(346, 360, mb) * S0, lerp(24, 31, mb) * S0, 2 * rcA, 2 * rcA, rcA)} fill="#FFFFFF"/>`;
    if (m < 0.2) body += `<rect x="${n2(X - 22 * S0)}" y="${n2(Y - 165 * S0)}" width="${n2(44 * S0)}" height="${n2(13 * S0)}" rx="${n2(6.5 * S0)}" fill="${TINTA}" opacity="${n3(1 - m * 5)}"/>`;
    body += `<rect ${caja(192 * S0, 378 * S0, 39 * S0, 2 * rcA - 8, 2 * rcA - 8, rcA - 4)} fill="none" stroke="url(#gh_amarillo)" stroke-width="${n2(lerp(5.5 * S0, 8, m))}"/>`;
  }
  // los círculos
  circ.forEach((c, k) => {
    if (c.r < 0.5 || (k === 0 && t < 3.95)) return;
    const nx = circ[(k + 1) % 4], col = COL[PARTES[k].n];
    defs += `<mask id="${id}m${k}" maskUnits="userSpaceOnUse" x="0" y="0" width="960" height="540"><rect width="960" height="540" fill="#fff"/>${nx.r > 0.5 ? `<circle cx="${n2(nx.x)}" cy="${n2(nx.y)}" r="${n2(nx.r + GAP * (nx.r / R) * Math.min(1, SM))}" fill="#000"/>` : ''}</mask>`;
    defs += `<radialGradient id="${id}g${k}" gradientUnits="userSpaceOnUse" cx="${n2(mx)}" cy="${CY}" r="${n2(c.d + c.r)}"><stop offset=".3" stop-color="${col.i}"/><stop offset="1" stop-color="${col.c}"/></radialGradient>`;
    const anillo = 8 * (1 - lleno);
    let g = `<g mask="url(#${id}m${k})" opacity="${n3(salida)}"><circle cx="${n2(c.x)}" cy="${n2(c.y)}" r="${n2(c.r)}" fill="#FFFFFF"/>`;
    if (lleno > 0) g += `<circle cx="${n2(c.x)}" cy="${n2(c.y)}" r="${n2(c.r)}" fill="url(#${id}g${k})" fill-opacity="${n3(lleno)}"/>`;
    if (anillo > 0.05) g += `<circle cx="${n2(c.x)}" cy="${n2(c.y)}" r="${n2(Math.max(0, c.r - anillo / 2))}" fill="none" stroke="url(#gh_${PARTES[k].n})" stroke-width="${n2(anillo)}"/>`;
    body += g + '</g>';
  });
  // el lugar suena: ondas lima que salen del círculo
  {
    const [lx, ly] = [circ[2].x, circ[2].y];
    for (const d0 of [7.3, 7.7, 8.1]) {
      const a = (t - d0) / 1.2;
      if (a < 0 || a > 1) continue;
      const o = (1 - a) ** 1.6 * clamp(a / 0.08) * (1 - lleno);
      body += `<circle cx="${n2(lx)}" cy="${n2(ly)}" r="${n2(lerp(RC, RC + 62, entra(a)))}" fill="none" stroke="${hondo(COL.lima.i, 0.05)}" stroke-opacity="${n3(0.9 * o)}" stroke-width="${n2(lerp(4, 2, a))}"/>`;
    }
  }
  // íconos
  const sinIconos = 1 - estandar(seg(t, 9.85, 10.1));
  const icono = (k, inner, op) => {
    const c = circ[k], esc = (RC * 0.9) / 24;
    return `<g transform="translate(${n2(c.x - 12 * esc)} ${n2(c.y - 12 * esc)}) scale(${n3(esc)})" fill="none" stroke="${TINTA}" stroke-width="1.75" stroke-linecap="round" stroke-linejoin="round" opacity="${n3(op * sinIconos * salida)}">${inner}</g>`;
  };
  if (t > 3.3 && sinIconos > 0) {
    // tu tiempo: el reloj se dibuja y su aguja da una vuelta
    const p = estandar(seg(t, 3.45, 3.95));
    const giro = 360 * estandar(seg(t, 3.95, 4.75));
    body += icono(0, ICONOS.tiempo.trazos.map(d => trazar(d, p)).join('') + `<g transform="rotate(${n2(giro)} 12 14)">${trazar(ICONOS.tiempo.aguja, p)}</g>`, clamp(p * 4));
  }
  if (t > 5.3 && sinIconos > 0) {
    // tu primer paso: el libro se abre desde su lomo
    const p = estandar(seg(t, 5.3, 5.6));
    const sx = Math.cos(Math.PI * (1 - clamp(resorte(t - 5.6, 0.74, 0.8)))); // de -1 (cerrado) a 1 (abierto)
    const tr = ICONOS.primerPaso.trazos.map(d => trazar(d, p)).join('');
    defs += `<clipPath id="${id}li"><rect x="-2" y="-2" width="14.4" height="28"/></clipPath><clipPath id="${id}ld"><rect x="11.6" y="-2" width="14.4" height="28"/></clipPath>`;
    body += icono(1, `<g clip-path="url(#${id}ld)">${tr}</g><g transform="translate(12 0) scale(${n3(sx)} 1) translate(-12 0)"><g clip-path="url(#${id}li)">${tr}</g></g>`, clamp(p * 4));
  }
  if (t > 6.95 && sinIconos > 0) {
    // el lugar: el Tag se dibuja y sus ondas laten dos veces
    const p = estandar(seg(t, 6.95, 7.3));
    const late = j => 0.35 + 0.65 * Math.max(Math.sin(Math.PI * seg(t, 7.3 + j * 0.12, 7.75 + j * 0.12)), Math.sin(Math.PI * seg(t, 7.9 + j * 0.12, 8.35 + j * 0.12)));
    body += icono(2, ICONOS.lugar.trazos.map(d => trazar(d, p)).join('') + ICONOS.lugar.ondas.map((d, j) => `<g opacity="${n3(t < 7.3 ? 1 : late(j))}">${trazar(d, p)}</g>`).join(''), clamp(p * 4));
  }
  if (t > 8.65 && sinIconos > 0) {
    // lo que decides: la bandera se dibuja y flamea
    const p = estandar(seg(t, 8.65, 9.05));
    const ola = 7 * Math.sin(Math.PI * 3 * seg(t, 9.05, 9.85)) * (1 - seg(t, 9.05, 9.85));
    body += icono(3, `<g transform="translate(4 0) skewY(${n2(ola)}) translate(-4 0)">${ICONOS.decides.trazos.map(d => trazar(d, p)).join('')}</g>`, clamp(p * 4));
  }
  // el turno pasa: un punto viaja por el arco, del color que entrega al que recibe
  // El punto conserva el color de quien entrega el turno, para no pasar por el color de otra parte, y deja una huella fina.
  const PASES = [[0, 4.75, 5.3], [1, 6.4, 6.95], [2, 8.1, 8.65], [3, 9.45, 9.95]]; // el último devuelve el turno a tu tiempo y cierra el círculo
  const huella = 1 - lleno;
  for (const [k, a, b] of PASES) {
    if (t < a || huella <= 0) continue;
    const e = estandar(seg(t, a, b));
    const a0 = ((ANG[k] + 24) * Math.PI) / 180, a1 = ((ANG[k] + 24 + 42 * e) * Math.PI) / 180;
    if (e > 0.01) body += `<path d="M${n2(CX + RD * Math.cos(a0))} ${n2(CY + RD * Math.sin(a0))}A${RD} ${RD} 0 0 1 ${n2(CX + RD * Math.cos(a1))} ${n2(CY + RD * Math.sin(a1))}" fill="none" stroke="#E2DDD8" stroke-width="2.5" stroke-linecap="round" opacity="${n3(huella * salida)}"/>`;
    if (t > b) continue;
    const u = seg(t, a, b), col = hondo(COL[PARTES[k].n].i, 0.03);
    for (let j = 6; j >= 0; j--) {
      const ang = ((ANG[k] + 24 + 42 * estandar(clamp(u - j * 0.018))) * Math.PI) / 180;
      body += `<circle cx="${n2(CX + RD * Math.cos(ang))}" cy="${n2(CY + RD * Math.sin(ang))}" r="${n2(7 * (1 - j * 0.11) * lerp(0.5, 1, entra(seg(u, 0, 0.2))))}" fill="${col}" fill-opacity="${n3(j ? 0.32 * (1 - j / 7) : 1)}"/>`;
    }
  }
  // la marca: con «relevo» en tinta, que no representa ninguna de las cuatro partes
  if (t > 11.0) {
    const ys = letras.map((_, i) => 82 * (1 - entra(seg(t, 11.2 + i * 0.045, 11.7 + i * 0.045))));
    const L = letras.map((l, i) => `<path transform="translate(0 ${n2(ys[i])})" d="${l.d}"/>`).join('');
    const x0 = mx - 42.66 * ESC_L, y0 = CY - (85.314 * ESC_L) / 2;
    body += `<g transform="translate(${n2(x0)} ${n2(y0)}) scale(${n3(ESC_L)})" opacity="${n3(salida)}"><g transform="translate(109.314 72.3)" clip-path="url(#clipLetras)" fill="${TINTA}">${L}</g></g>`;
  }
  return { defs, body };
}
// --- Cómo funciona, versión simple ---
// La misma historia que «como-funciona-detallada», sin efectos, como hecha en un editor básico:
// colores planos, sin sombras ni degradados, sin rebotes (solo entradas y salidas suaves), íconos que aparecen,
// un punto sin estela y «relevo» que aparece de una vez.
const suave = bezier(0.42, 0, 0.58, 1); // ease-in-out
const alSalir = bezier(0, 0, 0.58, 1); // ease-out
const PLANO = { amarillo: '#FFD54A', cielo: '#9DD6F4', lima: '#B3E788', rubor: '#F6A3CB' };
function comoFuncionaSimple(t, id) {
  // 13,2 s, se repite.
  // 0,4–2,6 s  el anillo amarillo cuenta el tiempo alrededor del teléfono.
  // 2,7 s      el teléfono se va y el anillo se vuelve el círculo amarillo, arriba, con el reloj.
  // 4,5 s      el turno pasa al cielo (el libro se abre), 6,1 s al lima (el Tag suena), 8 s al rubor (la bandera).
  // 9,3 s      el turno vuelve a tu tiempo. 10,1 s: los cuatro se juntan en la marca. 11 s: «relevo».
  const CX = 480, CY = 270, RD = 150, RC = 56;
  const fuera = 1 - seg(t, 12.8, 13.2);
  const pos = k => [CX + RD * Math.cos((ANG[k] * Math.PI) / 180), CY + RD * Math.sin((ANG[k] * Math.PI) / 180)];
  let defs = '', body = '';
  // 1. El teléfono: un rectángulo negro con la pantalla blanca y tres bloques grises que suben.
  const ve = seg(t, 0, 0.3) * (1 - suave(seg(t, 2.7, 3.0)));
  if (ve > 0) {
    const sc = 1 - 0.1 * suave(seg(t, 2.7, 3.0));
    const scroll = [0.5, 1.3, 2.1].reduce((a, b) => a + 112 * suave(seg(t, b, b + 0.55)), 0);
    let contenido = '';
    for (let n = Math.floor(scroll / 112) - 1; n < Math.floor(scroll / 112) + 4; n++) {
      const y = -132 + n * 112 - scroll;
      contenido += `<rect x="-59" y="${n2(y)}" width="118" height="68" rx="10" fill="#E8E4E0"/><rect x="-59" y="${n2(y + 78)}" width="${[84, 70, 92, 64][((n % 4) + 4) % 4]}" height="7" rx="3.5" fill="#EEEBE8"/><rect x="-59" y="${n2(y + 91)}" width="${[56, 48, 62, 44][((n % 4) + 4) % 4]}" height="7" rx="3.5" fill="#EEEBE8"/>`;
    }
    defs += `<clipPath id="${id}pa"><rect x="-69" y="-144" width="138" height="288" rx="21"/></clipPath>`;
    body += `<g transform="translate(${CX} ${CY}) scale(${n3(sc)})" opacity="${n3(ve)}"><rect x="-75" y="-150" width="150" height="300" rx="26" fill="${TINTA}"/><rect x="-69" y="-144" width="138" height="288" rx="21" fill="#FFFFFF"/><g clip-path="url(#${id}pa)">${contenido}</g></g>`;
  }
  // el anillo del tiempo: se llena y después se vuelve el círculo amarillo
  const lleno = seg(t, 0.4, 2.6);
  const m = suave(seg(t, 2.75, 3.35)); // del anillo alrededor del teléfono al círculo
  const [ax, ay] = pos(0);
  if (lleno > 0.002 && t < 3.4) {
    const w = lerp(168, 2 * RC, m), h = lerp(318, 2 * RC, m), rx = lerp(35, RC, m);
    const x = lerp(CX, ax, m), y = lerp(CY, ay, m);
    // rectángulo redondeado que empieza arriba al centro y sigue el sentido del reloj, para recortarlo con la línea punteada
    const L = x - w / 2, R2 = x + w / 2, T = y - h / 2, B = y + h / 2, r = Math.min(rx, w / 2, h / 2);
    const d = `M${n2(x)} ${n2(T)}H${n2(R2 - r)}A${n2(r)} ${n2(r)} 0 0 1 ${n2(R2)} ${n2(T + r)}V${n2(B - r)}A${n2(r)} ${n2(r)} 0 0 1 ${n2(R2 - r)} ${n2(B)}H${n2(L + r)}A${n2(r)} ${n2(r)} 0 0 1 ${n2(L)} ${n2(B - r)}V${n2(T + r)}A${n2(r)} ${n2(r)} 0 0 1 ${n2(L + r)} ${n2(T)}Z`;
    const relleno = suave(seg(t, 3.05, 3.35));
    if (relleno > 0) body += `<path d="${d}" fill="${PLANO.amarillo}" fill-opacity="${n3(relleno)}"/>`;
    body += `<path d="${d}" pathLength="1" fill="none" stroke="${PLANO.amarillo}" stroke-width="6" stroke-linecap="round" stroke-dasharray="${n3(lleno)} 2"/>`;
  }
  // los cuatro círculos: aparecen, se juntan en la marca y la marca se corre para dejar lugar a «relevo»
  const junta = suave(seg(t, 10.1, 10.8));
  const lock = suave(seg(t, 11.0, 11.6));
  const SM = lerp(1.5, 1.25, lock);
  const ESC_L = SM / 0.853;
  const mx = lerp(CX, CX - (406.214 * ESC_L) / 2 + 42.66 * ESC_L, lock);
  const aparece = [t >= 3.4 ? 1 : 0, alSalir(seg(t, 5.1, 5.45)), alSalir(seg(t, 6.7, 7.05)), alSalir(seg(t, 8.6, 8.95))];
  const circ = PARTES.map((p, k) => {
    const ang = (ANG[k] * Math.PI) / 180, d = lerp(RD, D * SM, junta), r = lerp(RC * aparece[k], R * SM, junta);
    return { x: mx + d * Math.cos(ang), y: CY + d * Math.sin(ang), r };
  });
  circ.forEach((c, k) => {
    if (c.r < 0.5) return;
    const nx = circ[(k + 1) % 4];
    defs += `<mask id="${id}m${k}" maskUnits="userSpaceOnUse" x="0" y="0" width="960" height="540"><rect width="960" height="540" fill="#fff"/>${nx.r > 0.5 ? `<circle cx="${n2(nx.x)}" cy="${n2(nx.y)}" r="${n2(nx.r + GAP * (nx.r / R))}" fill="#000"/>` : ''}</mask>`;
    body += `<circle cx="${n2(c.x)}" cy="${n2(c.y)}" r="${n2(c.r)}" fill="${PLANO[PARTES[k].n]}" mask="url(#${id}m${k})" opacity="${n3(fuera)}"/>`;
  });
  // íconos en tinta: aparecen con un fundido y se van antes de que los círculos se junten
  const sinIconos = 1 - suave(seg(t, 9.9, 10.15));
  const icono = (k, inner, op) => {
    const c = circ[k], esc = (RC * 0.82) / 24;
    return `<g transform="translate(${n2(c.x - 12 * esc)} ${n2(c.y - 12 * esc)}) scale(${n3(esc)})" fill="none" stroke="${TINTA}" stroke-width="1.75" stroke-linecap="round" stroke-linejoin="round" opacity="${n3(op * sinIconos)}">${inner}</g>`;
  };
  const camino = d => `<path d="${d}"/>`;
  if (t > 3.35) {
    const giro = 360 * suave(seg(t, 3.65, 4.4));
    body += icono(0, ICONOS.tiempo.trazos.map(camino).join('') + `<g transform="rotate(${n2(giro)} 12 14)">${camino(ICONOS.tiempo.aguja)}</g>`, suave(seg(t, 3.35, 3.6)));
  }
  if (t > 5.35) {
    const sx = Math.cos(Math.PI * (1 - suave(seg(t, 5.6, 6.05)))); // la tapa gira sobre el lomo: de cerrado (-1) a abierto (1)
    const tr = ICONOS.primerPaso.trazos.map(camino).join('');
    defs += `<clipPath id="${id}li"><rect x="-2" y="-2" width="14.4" height="28"/></clipPath><clipPath id="${id}ld"><rect x="11.6" y="-2" width="14.4" height="28"/></clipPath>`;
    body += icono(1, `<g clip-path="url(#${id}ld)">${tr}</g><g transform="translate(12 0) scale(${n3(sx)} 1) translate(-12 0)"><g clip-path="url(#${id}li)">${tr}</g></g>`, suave(seg(t, 5.35, 5.55)));
  }
  if (t > 6.95) {
    const titila = j => (t < 7.25 ? 1 : 0.3 + 0.7 * Math.max(Math.cos(Math.PI * seg(t, 7.25 + j * 0.1, 7.65 + j * 0.1)) ** 2, Math.cos(Math.PI * seg(t, 7.75 + j * 0.1, 8.15 + j * 0.1)) ** 2)); // las ondas del Tag laten dos veces: suena
    body += icono(2, ICONOS.lugar.trazos.map(camino).join('') + ICONOS.lugar.ondas.map((d, j) => `<g opacity="${n3(titila(j))}">${camino(d)}</g>`).join(''), suave(seg(t, 6.95, 7.15)));
  }
  if (t > 8.85) body += icono(3, ICONOS.decides.trazos.map(camino).join(''), suave(seg(t, 8.85, 9.05)));
  // el turno pasa: un punto del color de quien lo entrega, por el arco
  for (const [k, a, b] of [[0, 4.5, 5.1], [1, 6.1, 6.7], [2, 8.0, 8.6], [3, 9.3, 9.9]]) {
    if (t < a || t > b) continue;
    const ang = ((ANG[k] + 22 + 46 * suave(seg(t, a, b))) * Math.PI) / 180;
    body += `<circle cx="${n2(CX + RD * Math.cos(ang))}" cy="${n2(CY + RD * Math.sin(ang))}" r="6" fill="${PLANO[PARTES[k].n]}"/>`;
  }
  // «relevo» en tinta, de una vez
  if (t > 11.1) {
    const a = alSalir(seg(t, 11.1, 11.6));
    const L = letras.map(l => `<path d="${l.d}"/>`).join('');
    const x0 = mx - 42.66 * ESC_L + 10 * (1 - a), y0 = CY - (85.314 * ESC_L) / 2;
    body += `<g transform="translate(${n2(x0)} ${n2(y0)}) scale(${n3(ESC_L)})" opacity="${n3(a * fuera)}"><g transform="translate(109.314 72.3)" fill="${TINTA}">${L}</g></g>`;
  }
  return { defs, body };
}
const ESC = {
  pelicula: { f: pelicula, W: 960, H: 540, dur: 15.6 },
  tiempo: { f: bucleTiempo, W: 540, H: 540, dur: 4.8 },
  'como-funciona': { f: comoFuncionaSimple, W: 960, H: 540, dur: 13.2 },
  'como-funciona-detallada': { f: comoFunciona, W: 960, H: 540, dur: 13.0 },
  suena: { f: bucleSuena, W: 540, H: 540, dur: 2.4 },
  'primer-paso': { f: buclePrimerPaso, W: 540, H: 540, dur: 4.6 },
  decides: { f: bucleDecides, W: 540, H: 540, dur: 4.4 },
}[ESCENA];
W = ESC.W; H = ESC.H; DUR = ESC.dur;
const FPS = 50;
function cuadro(t, i) {
  const { defs, body } = ESC.f(t, 'f' + i);
  return `<svg xmlns="http://www.w3.org/2000/svg" width="${W}" height="${H}" viewBox="0 0 ${W} ${H}"><defs>${defs}</defs>${body}</svg>`;
}
const bg = FONDO === 'blanco' ? '#FFFFFF' : 'transparent';
const comunes = `<svg width="0" height="0" style="position:absolute"><defs>${DEFS}</defs></svg>`;
const estilo = `<style>html,body{margin:0;background:${bg}}.f{width:${W}px;height:${H}px;overflow:hidden}</style>`;
if (process.env.PREVIEW) {
  const ts = process.env.PREVIEW.split(',').map(Number);
  const cols = W > 600 ? 2 : 4;
  const html = `<!doctype html><meta charset="utf-8"><style>html,body{margin:0;background:#fff}.g{display:grid;grid-template-columns:repeat(${cols},${W}px);gap:8px;padding:8px;background:#ddd}.f{width:${W}px;height:${H}px;background:#fff;position:relative}.f b{position:absolute;left:8px;top:6px;font:12px system-ui;color:#999}</style>${comunes}<div class="g">${ts.map((t, i) => `<div class="f"><b>${t}s</b>${cuadro(t, i)}</div>`).join('')}</div>`;
  fs.writeFileSync(path.join(OUT, 'preview.html'), html);
  console.log(JSON.stringify({ preview: ts.length, W: cols * (W + 8) + 8, H: Math.ceil(ts.length / cols) * (H + 8) + 8 }));
} else {
  const N = Math.round(DUR * FPS);
  const POR_PAGINA = 8;
  const paginas = Math.ceil(N / POR_PAGINA);
  for (let p = 0; p < paginas; p++) {
    let html = '';
    for (let i = p * POR_PAGINA; i < Math.min(N, (p + 1) * POR_PAGINA); i++) html += `<div class="f">${cuadro(i / FPS, i)}</div>`;
    fs.writeFileSync(path.join(OUT, `p${String(p).padStart(2, '0')}.html`), `<!doctype html><meta charset="utf-8">${estilo}${comunes}${html}`);
  }
  fs.writeFileSync(path.join(OUT, 'info.json'), JSON.stringify({ N, FPS, W, H, POR_PAGINA, paginas }));
  console.log(JSON.stringify({ ESCENA, N, paginas }));
}
