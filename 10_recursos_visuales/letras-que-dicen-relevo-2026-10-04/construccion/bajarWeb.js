// Baja los archivos de fuente que cada sitio ya publica para su página (Velvetyne, Collletttivo, Fontshare) para poder verlos en grande.
// Los archivos se guardan fuera del repositorio. uso: node bajarWeb.js <puerto>
const fs = require('fs');
const os = require('os');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const PORT = Number(process.argv[2] || 9461);
const OUT = path.join(os.tmpdir(), 'rf').split(path.sep).join('/');
fs.mkdirSync(OUT, { recursive: true });

const PAGINAS = ['backout', 'basteleur', 'facade', 'picnic', 'gulax', 'outward', 'resistance', 'steps-mono', 'lithops', 'ouvrieres'].map((id) => ['ve', id, 'https://velvetyne.fr/fonts/' + id + '/']);
const FONTSHARE = [['boxing', 400], ['striper', 400], ['bevellier', 700], ['nippo', 700], ['styro', 800], ['chubbo', 700], ['melodrama', 700], ['clash-display', 600], ['aktura', 400], ['tanker', 400], ['technor', 700], ['bespoke-stencil', 700], ['array', 700]];

(async () => {
  const salida = {};
  const ch = await launch(PORT);
  try {
    await ch.size(1300, 800);
    for (const [src, id, url] of PAGINAS) {
      try {
        await ch.open(url);
        await sleep(2200);
        const recursos = await ch.eval(String.raw`performance.getEntriesByType('resource').map(e => e.name).filter(n => /\.(woff2?|otf|ttf)(\?|$)/i.test(n))`);
        const propios = recursos.filter((n) => !/velvelyne|inter-|ronzino|vtf/i.test(n));
        if (!propios.length) { console.log(id, 'sin archivos propios', JSON.stringify(recursos).slice(0, 200)); continue; }
        const u = propios[0];
        const ext = (u.match(/.(woff2|woff|otf|ttf)/i) || ['', 'woff2'])[1].toLowerCase();
        const mejor = { fam: id, w: '' };
        const buf = Buffer.from(await (await fetch(u)).arrayBuffer());
        const dest = OUT + '/w-' + id + '.' + ext;
        fs.writeFileSync(dest, buf);
        salida[id] = { src, fam: mejor.fam, w: mejor.w, archivo: dest, url: u, bytes: buf.length };
        console.log(id, '|', mejor.fam, mejor.w, ext, buf.length);
      } catch (e) { console.log(id, 'ERROR', e.message.slice(0, 80)); }
    }
  } finally { await ch.close(); }
  for (const [slug, peso] of FONTSHARE) {
    try {
      const css = await (await fetch('https://api.fontshare.com/v2/css?f[]=' + slug + '@' + peso + '&display=block')).text();
      const m = css.match(/url\(['"]?([^'")]+)['"]?\)/);
      if (!m) { console.log(slug, 'sin url'); continue; }
      const u = new URL(m[1], 'https://api.fontshare.com/').href.replace(/^http:/, 'https:');
      const ext = (u.match(/\.(woff2|woff|otf|ttf)/i) || ['', 'woff2'])[1].toLowerCase();
      const buf = Buffer.from(await (await fetch(u.startsWith('//') ? 'https:' + u : u)).arrayBuffer());
      const dest = OUT + '/w-' + slug + '.' + ext;
      fs.writeFileSync(dest, buf);
      salida[slug] = { src: 'fs', archivo: dest, url: u, bytes: buf.length };
      console.log(slug, '| fontshare', ext, buf.length);
    } catch (e) { console.log(slug, 'ERROR', e.message.slice(0, 80)); }
  }
  const previo = fs.existsSync('web-archivos-1.json') ? JSON.parse(fs.readFileSync('web-archivos-1.json', 'utf8')) : {}; fs.writeFileSync('web-archivos.json', JSON.stringify({ ...previo, ...salida }, null, 1));
})();
