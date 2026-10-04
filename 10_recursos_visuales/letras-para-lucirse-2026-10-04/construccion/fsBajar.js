// Baja de Fontshare (hoja de estilo pública) todos los estilos de las letras pedidas, para verlas en grande. Se guardan fuera del repositorio.
// uso: node fsBajar.js <slug> [<slug> ...]   → escribe fs-estilos.json
const fs = require('fs');
const os = require('os');
const path = require('path');
const OUT = path.join(os.tmpdir(), 'rf').split(path.sep).join('/');
fs.mkdirSync(OUT, { recursive: true });
(async () => {
  const j = await (await fetch('https://api.fontshare.com/v2/fonts?limit=100')).json();
  const previo = fs.existsSync('fs-estilos.json') ? JSON.parse(fs.readFileSync('fs-estilos.json', 'utf8')) : {};
  for (const slug of process.argv.slice(2)) {
    const f = j.fonts.find((x) => x.slug === slug);
    if (!f) { console.log(slug, 'no existe'); continue; }
    const estilos = (f.styles || []).filter((s) => s.weight && s.weight.number && !/variable/i.test(s.name || '') && !s.is_variable);
    const vistos = new Set();
    const lista = [];
    for (const s of estilos) { const n = s.weight.number + (s.is_italic ? 1 : 0); if (!vistos.has(n)) { vistos.add(n); lista.push({ n, w: s.weight.number, it: !!s.is_italic }); } }
    if (!lista.length) { console.log(slug, 'sin estilos estáticos'); continue; }
    const css = await (await fetch('https://api.fontshare.com/v2/css?f[]=' + slug + '@' + lista.map((x) => x.n).join(',') + '&display=block')).text();
    const bloques = css.split('@font-face').slice(1);
    const res = [];
    for (const b of bloques) {
      const u = (b.match(/url\(['"]?([^'")]+\.woff2)['"]?\)/) || [])[1];
      const w = (b.match(/font-weight:\s*(\d+)/) || [])[1];
      const st = (b.match(/font-style:\s*(\w+)/) || [])[1] || 'normal';
      if (!u) continue;
      const url = u.startsWith('//') ? 'https:' + u : u;
      const dest = OUT + '/fs-' + slug + '-' + w + (st === 'italic' ? 'i' : '') + '.woff2';
      if (!fs.existsSync(dest)) fs.writeFileSync(dest, Buffer.from(await (await fetch(url)).arrayBuffer()));
      res.push({ w: Number(w), st, archivo: dest });
    }
    previo[slug] = { nombre: f.name, designers: (f.designers || []).map((d) => d.name).join(', '), categoria: f.category, estilos: res };
    console.log(slug, res.map((r) => r.w + (r.st === 'italic' ? 'i' : '')).join(' '));
  }
  fs.writeFileSync('fs-estilos.json', JSON.stringify(previo, null, 1));
})();
