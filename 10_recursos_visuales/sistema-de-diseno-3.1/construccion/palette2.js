const fs = require('fs');
const { oklchToRgb, hex, fromHex, contrast, simulate, dE, maxChroma } = require('./color-lib');
const FAM = [
  { id: 'mostaza', cat: 'leer', h: 85, c: 0.12, sig: 300 },
  { id: 'arcilla', cat: 'crear', h: 18, c: 0.10, sig: 400 },
  { id: 'salvia', cat: 'cuidar', h: 145, c: 0.10, sig: 500 },
  { id: 'terracota', cat: 'moverme', h: 45, c: 0.13, sig: 600 },
  { id: 'ciruela', cat: 'compartir', h: 340, c: 0.11, sig: 700 },
  { id: 'pizarra', cat: 'aprender', h: 210, c: 0.07, sig: 800 },
];
const STEPS = { 50: [0.97, 0.2], 100: [0.94, 0.32], 200: [0.88, 0.55], 300: [0.80, 0.8], 400: [0.72, 0.95], 500: [0.64, 1], 600: [0.56, 0.98], 700: [0.48, 0.9], 800: [0.39, 0.78], 900: [0.30, 0.6] };
const PAPER = '#F2F2EF', CARD = '#FCFCFA', INK = '#17181C', NIGHTCARD = '#1B1C20';
const out = {};
for (const f of FAM) {
  out[f.id] = { cat: f.cat, h: f.h, sig: f.sig, steps: {} };
  for (const [k, [L, cf]] of Object.entries(STEPS)) {
    const C = Math.min(f.c * cf, maxChroma(L, f.h) * 0.97);
    out[f.id].steps[k] = { hex: hex(oklchToRgb(L, C, f.h).rgb), L, C: +C.toFixed(3) };
  }
}
for (const [id, f] of Object.entries(out)) {
  const s = f.steps;
  console.log(id.padEnd(10), 'firma', f.sig, s[f.sig].hex, '|', Object.entries(s).map(([k, v]) => k + ':' + v.hex).join(' '));
  console.log(''.padEnd(10), '600/papel', contrast(s[600].hex, PAPER).toFixed(2), '700/papel', contrast(s[700].hex, PAPER).toFixed(2), '700/tarjeta', contrast(s[700].hex, CARD).toFixed(2), '300/noche', contrast(s[300].hex, NIGHTCARD).toFixed(2), 'tinta/100', contrast(INK, s[100].hex).toFixed(2));
}
const ids = Object.keys(out);
for (const which of ['sig', 700]) for (const kind of ['normal', 'protan', 'deutan', 'tritan']) {
  let min = 1e9, pair = '';
  for (let i = 0; i < ids.length; i++) for (let j = i + 1; j < ids.length; j++) {
    const A = out[ids[i]].steps[which === 'sig' ? out[ids[i]].sig : 700].hex, Bh = out[ids[j]].steps[which === 'sig' ? out[ids[j]].sig : 700].hex;
    const d = kind === 'normal' ? dE(fromHex(A), fromHex(Bh)) : dE(simulate(A, kind), simulate(Bh, kind));
    if (d < min) { min = d; pair = ids[i] + '–' + ids[j]; }
  }
  console.log(String(which).padEnd(4), kind.padEnd(7), 'ΔE mínimo', min.toFixed(1), pair);
}
fs.writeFileSync('palette.json', JSON.stringify(out, null, 1));
