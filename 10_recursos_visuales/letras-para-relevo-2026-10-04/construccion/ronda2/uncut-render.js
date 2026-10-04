// Escribe «relevo» con el archivo de fuente más representativo de cada descarga de UNCUT (cargado desde el disco, sin instalar nada).
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const lista = JSON.parse(fs.readFileSync(path.join(__dirname, 'enlaces.json'), 'utf8'));
const EXT = path.join(__dirname, 'extraido');
const OUT = path.join(__dirname, 'img');
const CORTO = path.join(require('os').tmpdir(), 'rf').split(path.sep).join('/'); // ruta corta: Windows no abre rutas de más de 260 caracteres
fs.mkdirSync(CORTO, { recursive: true });
fs.mkdirSync(OUT, { recursive: true });

function recorrer(dir, acc = []) {
  for (const f of fs.readdirSync(dir, { withFileTypes: true })) {
    const p = path.join(dir, f.name);
    if (f.isDirectory()) { if (!/__MACOSX|node_modules|\.git$|sources?$|ufo|glyphs|specimen|docs?$|static$/i.test(f.name) || /static$/i.test(f.name)) recorrer(p, acc); }
    else if (/\.(woff2|woff|otf|ttf)$/i.test(f.name)) acc.push(p);
  }
  return acc;
}
const norm = (s) => s.toLowerCase().replace(/[^a-z0-9]/g, '');
function elegir(id, nombre, archivos) {
  const slug = norm(id.split('/')[1]);
  const nom = norm(nombre);
  const pts = archivos.map((p) => {
    const b = path.basename(p).toLowerCase();
    const n = norm(b);
    let s = 0;
    const variable = /variable|\[wght|\[wdth|\[opsz|-vf|_vf|gx\b/.test(b);
    if (variable) s += 40;
    if (/extrabold|black|heavy/.test(b)) s += 22; else if (/semibold|demibold/.test(b)) s += 28; else if (/bold/.test(b)) s += 30; else if (/medium/.test(b)) s += 18; else if (/regular|book|roman/.test(b)) s += 12; else if (/light|thin|hairline/.test(b)) s -= 10;
    if (/italic|oblique|slanted/.test(b)) s -= 40;
    if (n.includes(slug) || n.includes(nom)) s += 60;
    if (/mono/.test(b) && !/mono/.test(slug)) s -= 25;
    if (/outline|shadow|inline|stencil|pixel/.test(b)) s -= 10;
    if (/\.woff2$/i.test(b)) s += 3;
    if (/web|subset/.test(p.toLowerCase()) && !/\.woff2?$/i.test(b)) s -= 1;
    return { p, s, variable, b };
  }).sort((a, b) => b.s - a.s);
  return pts[0];
}

(async () => {
  const items = [];
  for (const o of lista) {
    const dir = path.join(EXT, o.id.replace(/\//g, '__'));
    if (!fs.existsSync(dir) || o.google) continue;
    const archivos = recorrer(dir);
    if (!archivos.length) continue;
    const e = elegir(o.id, o.nombre, archivos);
    if (e) { const corto = CORTO + '/u' + items.length + path.extname(e.p).toLowerCase(); fs.copyFileSync(e.p, corto); e.p = corto; }
    if (e) items.push({ id: o.id, nombre: o.nombre, lic: o.lic, by: o.by, dl: o.dl, archivo: e.p, variable: e.variable, base: e.b, n: archivos.length });
  }
  console.log('con fuentes:', items.length);
  const css = items.map((it, i) => `@font-face{font-family:"f${i}";src:url("file:///${it.archivo.split(path.sep).join('/')}");${it.variable ? 'font-weight:100 900;font-stretch:50% 200%;' : ''}}`).join('\n');
  const html = `<!doctype html><meta charset="utf-8"><style>${css}</style><body style="margin:0;background:#fff">${items.map((it, i) => `<div id="r${i}" style="width:900px;padding:18px 26px;box-sizing:border-box;font-family:'f${i}';font-weight:${it.variable ? 700 : 400};font-size:150px;line-height:1.1;white-space:nowrap;letter-spacing:-0.02em;color:#141519;background:#fff">relevo</div>`).join('')}</body>`;
  fs.writeFileSync(path.join(__dirname, 'render.html'), html);
  const ch = await launch(9422);
  try {
    await ch.size(1000, 900);
    await ch.open('file:///' + path.join(__dirname, 'render.html').split(path.sep).join('/'));
    await sleep(6000);
    const bad = await ch.eval(`(async () => { await document.fonts.ready; const n = ${items.length}; const out = []; for (let i = 0; i < n; i++) { const ok = document.fonts.check('40px "f' + i + '"'); if (!ok) out.push(i); } return out; })()`);
    const H = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1000, H); await sleep(900);
    for (let i = 0; i < items.length; i++) {
      const r = await ch.eval(`(() => { const b = document.getElementById('r${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(OUT, items[i].id.replace(/\//g, '__') + '.png'), Buffer.from(s.data, 'base64'));
    }
    fs.writeFileSync(path.join(__dirname, 'items.json'), JSON.stringify(items.map((it, i) => ({ ...it, fam: 'f' + i, sinCargar: bad.includes(i) })), null, 1));
    console.log('renders', items.length, 'sin cargar:', bad.map((i) => items[i].nombre).join(', '));
  } finally { await ch.close(); }
})();
