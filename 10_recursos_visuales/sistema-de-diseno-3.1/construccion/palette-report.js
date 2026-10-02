const { contrast, simulate, dE, rgbToOklab, fromHex } = require('./color-lib.js');
const PAL = require('./palette.json');
const PAPER = '#F2F2EF', CARD = '#FCFCFA', NIGHT = '#111215', NCARD = '#1B1C20', INK = '#17181C', BLUE = '#3D38F5';
const f2 = (v) => v.toFixed(2).replace('.', ',');
const rows = [];
for (const [fam, f] of Object.entries(PAL)) {
  const s = (k) => f.steps[k].hex;
  const lab = rgbToOklab(fromHex(s(f.sig)));
  const C = Math.hypot(lab[1], lab[2]), H = (Math.atan2(lab[2], lab[1]) * 180 / Math.PI + 360) % 360;
  rows.push({ fam, cat: f.cat, sig: f.sig, hex: s(f.sig), L: lab[0].toFixed(3), C: C.toFixed(3), H: H.toFixed(0),
    l600paper: f2(contrast(s(600), PAPER)), l600card: f2(contrast(s(600), CARD)), t700paper: f2(contrast(s(700), PAPER)), t700soft: f2(contrast(s(700), s(100))),
    l300night: f2(contrast(s(300), NCARD)), t200on900: f2(contrast(s(200), s(900))), ink100: f2(contrast(INK, s(100))) });
}
console.table(rows);
// Distancia entre firmas con visión normal y simulada.
const fams = Object.keys(PAL);
for (const kind of ['normal', 'protan', 'deutan', 'tritan']) {
  let min = Infinity, pair = '';
  for (let i = 0; i < fams.length; i++) for (let j = i + 1; j < fams.length; j++) {
    const a = PAL[fams[i]].steps[PAL[fams[i]].sig].hex, b = PAL[fams[j]].steps[PAL[fams[j]].sig].hex;
    const d = kind === 'normal' ? dE(a, b) : dE(simulate(a, kind), simulate(b, kind));
    if (d < min) { min = d; pair = fams[i] + '/' + fams[j]; }
  }
  console.log(kind, 'ΔEok mínimo entre firmas', min.toFixed(3), pair);
}
const lb = rgbToOklab(fromHex(BLUE)); console.log('azul L C', lb[0].toFixed(3), Math.hypot(lb[1], lb[2]).toFixed(3));
