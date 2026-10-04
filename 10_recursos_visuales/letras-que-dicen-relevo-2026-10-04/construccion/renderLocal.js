// Escribe «relevo» con el archivo de fuente más representativo de cada carpeta extraída (cargado desde el disco; no se instala nada).
// uso: node renderLocal.js <lista.json> <carpeta-extraida> <carpeta-de-imágenes> <puerto> <prefijo>
// lista.json: [{ id, nombre }]; cada id es el nombre de una subcarpeta de la carpeta extraída.
const fs = require('fs');
const os = require('os');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [listaF, EXT, OUT, PORT, PRE = 'x'] = process.argv.slice(2);
const lista = JSON.parse(fs.readFileSync(listaF, 'utf8'));
fs.mkdirSync(OUT, { recursive: true });
// Windows no abre rutas de más de 260 caracteres: las fuentes elegidas se copian a una ruta corta.
const CORTO = path.join(os.tmpdir(), 'rf').split(path.sep).join('/');
fs.mkdirSync(CORTO, { recursive: true });

function recorrer(dir, acc = []) {
  for (const f of fs.readdirSync(dir, { withFileTypes: true })) {
    const p = path.join(dir, f.name);
    if (f.isDirectory()) { if (!/__MACOSX|node_modules|\.git$|sources?$|ufo|glyphs|specimen|docs?$/i.test(f.name)) recorrer(p, acc); }
    else if (/\.(woff2|woff|otf|ttf)$/i.test(f.name)) acc.push(p);
  }
  return acc;
}
const norm = (s) => s.toLowerCase().replace(/[^a-z0-9]/g, '');
function elegir(id, nombre, archivos) {
  const slug = norm(id), nom = norm(nombre);
  return archivos.map((p) => {
    const b = path.basename(p).toLowerCase(), n = norm(b);
    let s = 0;
    const variable = /variable|\[wght|\[wdth|\[opsz|-vf|_vf|gx\b/.test(b);
    if (variable) s += 40;
    if (/extrabold|black|heavy/.test(b)) s += 22; else if (/semibold|demibold/.test(b)) s += 28; else if (/bold/.test(b)) s += 30; else if (/medium/.test(b)) s += 18; else if (/regular|book|roman/.test(b)) s += 12; else if (/light|thin|hairline/.test(b)) s -= 10;
    if (/italic|oblique|slanted/.test(b)) s -= 40;
    if (n.includes(slug) || n.includes(nom)) s += 60;
    if (/\.woff2$/i.test(b)) s += 3;
    return { p, s, variable, b };
  }).sort((a, b) => b.s - a.s)[0];
}

(async () => {
  const items = [];
  for (const o of lista) {
    const dir = path.join(EXT, o.id);
    if (!fs.existsSync(dir)) continue;
    const archivos = recorrer(dir);
    if (!archivos.length) continue;
    const e = elegir(o.id, o.nombre, archivos);
    const corto = CORTO + '/' + PRE + items.length + path.extname(e.p).toLowerCase();
    fs.copyFileSync(e.p, corto);
    items.push({ ...o, archivo: corto, variable: e.variable, base: e.b, n: archivos.length });
  }
  console.log('con fuentes:', items.length);
  const css = items.map((it, i) => `@font-face{font-family:"f${i}";src:url("file:///${it.archivo}");${it.variable ? 'font-weight:100 900;' : ''}}`).join('\n');
  const html = `<!doctype html><meta charset="utf-8"><style>${css}</style><body style="margin:0;background:#fff">${items.map((it, i) => `<div id="r${i}" style="width:900px;padding:18px 26px;box-sizing:border-box;font-family:'f${i}';font-weight:${it.variable ? 700 : 400};font-size:150px;line-height:1.1;white-space:nowrap;letter-spacing:-0.02em;color:#141519;background:#fff">relevo</div>`).join('')}</body>`;
  const htmlF = path.resolve(path.dirname(listaF), 'render-' + PRE + '.html');
  fs.writeFileSync(htmlF, html);
  const ch = await launch(Number(PORT));
  try {
    await ch.size(1000, 900);
    await ch.open('file:///' + htmlF.split(path.sep).join('/'));
    await sleep(6000);
    const H = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1000, H); await sleep(900);
    for (let i = 0; i < items.length; i++) {
      const r = await ch.eval(`(() => { const b = document.getElementById('r${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(OUT, items[i].id + '.png'), Buffer.from(s.data, 'base64'));
    }
    fs.writeFileSync(path.join(path.dirname(listaF), 'items-' + PRE + '.json'), JSON.stringify(items.map((it, i) => ({ ...it, fam: 'f' + i })), null, 1));
    console.log('renders', items.length);
  } finally { await ch.close(); }
})();
