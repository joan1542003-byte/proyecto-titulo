// Paleta «viva» (3.2): seis colores de la casa saturados, cada uno en dos pasos con función.
// campo: fondo vivo con tinta encima (≥ 7:1). tinta: renglón, ícono y texto sobre papel (≥ 4,5:1).
const { oklchToRgb, hex, contrast, maxChroma, simulate, dE, fromHex, rgbToOklab } = require('../color-lib.js');
const fs = require('fs');
const path = require('path');
const INK = '#141519', PAPER = '#FAFAF7', NIGHT = '#141519', BLUE = '#3D38F5';
// Tono (grados OKLCH) y luz de cada campo; la tinta se busca para llegar a 4,5:1 sobre papel con el mayor croma posible.
const CATS = {
  leer: { name: 'Leer', fam: 'sol', h: 90, Lc: 0.895, k: 0.97, why: 'la luz de la lámpara sobre el libro' },
  moverme: { name: 'Moverme', fam: 'naranja', h: 45, Lc: 0.72, k: 0.97, why: 'la tierra y el atardecer afuera' },
  crear: { name: 'Crear con las manos', fam: 'fucsia', h: 354, Lc: 0.775, k: 0.95, why: 'el pigmento en las manos' },
  cuidar: { name: 'Cuidar la casa y a mí', fam: 'hoja', h: 156, Lc: 0.69, k: 0.86, why: 'una planta recién regada' },
  aprender: { name: 'Aprender algo', fam: 'celeste', h: 228, Lc: 0.84, k: 0.92, why: 'los renglones celestes del cuaderno' },
  compartir: { name: 'Con otras personas', fam: 'cereza', h: 22, Lc: 0.625, k: 0.97, why: 'la mesa compartida' },
};
const mk = (L, h, k = 0.96) => { const C = maxChroma(L, h) * k; return { L, C: +C.toFixed(3), hex: hex(oklchToRgb(L, C, h).rgb) }; };
const out = {};
for (const [id, c] of Object.entries(CATS)) {
  const campo = mk(c.Lc, c.h, c.k);
  // Tinta: la luz más alta que llega a 4,5:1 sobre papel y sobre blanco.
  let tinta = null;
  for (let L = 0.70; L > 0.30; L -= 0.005) { const t = mk(+L.toFixed(3), c.h); if (contrast(t.hex, PAPER) >= 4.5 && contrast(t.hex, '#FFFFFF') >= 4.6) { tinta = t; break; } }
  const suave = mk(0.955, c.h, 0.55);
  out[id] = { ...c, campo, tinta, suave,
    k: { inkOnCampo: +contrast(INK, campo.hex).toFixed(2), tintaOnPaper: +contrast(tinta.hex, PAPER).toFixed(2), campoOnNight: +contrast(campo.hex, NIGHT).toFixed(2), tintaOnSuave: +contrast(tinta.hex, suave.hex).toFixed(2) } };
}
// Distancias entre campos con visión típica y simulada.
const ids = Object.keys(out);
const dist = {};
for (const kind of ['normal', 'protan', 'deutan', 'tritan']) {
  let m = 1e9, p = '';
  for (let i = 0; i < ids.length; i++) for (let j = i + 1; j < ids.length; j++) {
    const a = out[ids[i]].campo.hex, b = out[ids[j]].campo.hex;
    const d = kind === 'normal' ? dE(fromHex(a), fromHex(b)) : dE(simulate(a, kind), simulate(b, kind));
    if (d < m) { m = d; p = ids[i] + '/' + ids[j]; }
  }
  dist[kind] = { min: +m.toFixed(1), pair: p };
}
const blueC = Math.hypot(...rgbToOklab(fromHex(BLUE)).slice(1));
fs.writeFileSync(path.join(__dirname, 'palette-vivo.json'), JSON.stringify({ base: { INK, PAPER, BLUE }, cats: out, dist }, null, 1));
for (const [id, c] of Object.entries(out)) console.log(id.padEnd(10), 'campo', c.campo.hex, 'C', c.campo.C, '| tinta', c.tinta.hex, 'L', c.tinta.L, 'C', c.tinta.C, '| suave', c.suave.hex, '|', JSON.stringify(c.k));
console.log('distancias', JSON.stringify(dist), '| croma del azul', blueC.toFixed(3));
