// Revisa, para cada candidata, si trae los acentos del español (á é í ó ú ñ ¿ ¡) y si tiene minúsculas propias (la «r» distinta de la «R»).
// Método: se dibuja cada carácter en un canvas con la fuente + dos tipografías de respaldo distintas; si el dibujo no cambia, el glifo viene de la fuente.
// uso: node cobertura.js <puerto> <salida.json> <lista1.json> [lista2.json ...]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, SALIDA, ...LISTAS] = process.argv.slice(2);
const todas = LISTAS.flatMap((f) => JSON.parse(fs.readFileSync(f, 'utf8')));
(async () => {
  const css = todas.map((it, i) => `@font-face{font-family:"c${i}";src:url("file:///${it.archivo.split(path.sep).join('/')}");${it.variable ? 'font-weight:100 900;' : ''}}`).join('\n');
  const html = `<!doctype html><meta charset="utf-8"><style>${css}</style><body></body>`;
  const hf = path.resolve('cobertura.html');
  fs.writeFileSync(hf, html);
  const ch = await launch(Number(PORT));
  try {
    await ch.size(800, 600);
    await ch.open('file:///' + hf.split(path.sep).join('/'));
    await sleep(1500);
    const res = await ch.eval(`(async () => {
      const n = ${todas.length};
      const pesos = ${JSON.stringify(todas.map((t) => (t.variable ? 700 : 400)))};
      await Promise.all(Array.from({ length: n }, (_, i) => document.fonts.load(pesos[i] + ' 48px "c' + i + '"').catch(() => 0)));
      await document.fonts.ready;
      const cv = document.createElement('canvas'); cv.width = 120; cv.height = 120; const cx = cv.getContext('2d', { willReadFrequently: true });
      const pix = (fam, w, ch, fb) => { cx.clearRect(0, 0, 120, 120); cx.fillStyle = '#000'; cx.font = w + ' 72px ' + (fam ? '"' + fam + '"' + (fb ? ', ' + fb : '') : fb); cx.textBaseline = 'alphabetic'; cx.fillText(ch, 10, 90); const d = cx.getImageData(0, 0, 120, 120).data; let h = 0, tinta = 0; for (let i = 3; i < d.length; i += 4) { h = (h * 31 + d[i]) | 0; tinta += d[i]; } return tinta === 0 ? 'vacio' : h; };
      const out = [];
      for (let i = 0; i < n; i++) {
        const fam = 'c' + i, w = pesos[i];
        const tiene = (c) => { const a = pix(fam, w, c, 'serif'), b = pix(fam, w, c, 'monospace'); return a === b && a !== 'vacio'; };
        const faltan = [...'áéíóúñ¿¡Ñ'].filter((c) => !tiene(c));
        const minus = [...'relov'].filter((c) => pix(fam, w, c, 'serif') !== pix(fam, w, c.toUpperCase(), 'serif')).length;
        out.push({ faltan, minusculas: minus >= 3 });
      }
      return out;
    })()`);
    const sal = todas.map((t, i) => ({ k: t.k, nombre: t.nombre, origen: t.origen, ...res[i] }));
    fs.writeFileSync(SALIDA, JSON.stringify(sal, null, 1));
    for (const s of sal) console.log(s.nombre.padEnd(24), s.minusculas ? 'minúsculas' : 'SOLO MAYÚSC.', s.faltan.length ? 'faltan: ' + s.faltan.join('') : 'acentos ok');
  } finally { await ch.close(); }
})();
