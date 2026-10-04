// Baja zips de GitHub (o de cualquier URL directa), los abre y copia a una ruta corta el archivo de fuente más representativo.
// uso: node ghBajar.js <id>=<url> [<id>=<url> ...]   → escribe gh-archivos.json
const fs = require('fs');
const os = require('os');
const path = require('path');
const { execFileSync } = require('child_process');
const RF = path.join(os.tmpdir(), 'rf').split(path.sep).join('/');
const ZIPS = path.resolve('gh/zips'), EXT = path.resolve('gh/ext');
fs.mkdirSync(ZIPS, { recursive: true }); fs.mkdirSync(EXT, { recursive: true }); fs.mkdirSync(RF, { recursive: true });
function recorrer(dir, acc = []) {
  for (const f of fs.readdirSync(dir, { withFileTypes: true })) {
    const p = path.join(dir, f.name);
    if (f.isDirectory()) { if (!/__MACOSX|node_modules|\.git$|sources?$|ufo|glyphs|specimen|docs?$/i.test(f.name)) recorrer(p, acc); }
    else if (/\.(woff2|woff|otf|ttf)$/i.test(f.name)) acc.push(p);
  }
  return acc;
}
function elegir(archivos) {
  return archivos.map((p) => {
    const b = path.basename(p).toLowerCase(); let s = 0;
    if (/\[wght|variable|-vf/.test(b)) s += 10;
    if (/regular|book|roman|normal/.test(b)) s += 30; else if (/medium/.test(b)) s += 20; else if (/semibold|demi/.test(b)) s += 10; else if (/light|thin|hairline/.test(b)) s -= 5; else if (/bold|black|heavy/.test(b)) s += 5;
    if (/italic|oblique|slanted|ital\b/.test(b)) s -= 40;
    if (/\.otf$/.test(b)) s += 3; else if (/\.ttf$/.test(b)) s += 2; else if (/\.woff2$/.test(b)) s += 1;
    return { p, s, b };
  }).sort((a, b) => b.s - a.s)[0];
}
(async () => {
  const salida = fs.existsSync('gh-archivos.json') ? JSON.parse(fs.readFileSync('gh-archivos.json', 'utf8')) : {};
  for (const par of process.argv.slice(2)) {
    const i = par.indexOf('='); const id = par.slice(0, i), url = par.slice(i + 1);
    try {
      const res = await fetch(url, { redirect: 'follow' });
      if (!res.ok) { console.log(id, 'HTTP', res.status); continue; }
      const zip = path.join(ZIPS, id + '.zip');
      fs.writeFileSync(zip, Buffer.from(await res.arrayBuffer()));
      const dest = path.join(EXT, id); fs.rmSync(dest, { recursive: true, force: true }); fs.mkdirSync(dest, { recursive: true });
      try { execFileSync('C:/Windows/System32/tar.exe', ['-xf', zip, '-C', dest], { stdio: 'ignore' }); } catch (e) { /* algunos zips traen archivos de macOS que fallan; se ignoran */ }
      const archivos = recorrer(dest);
      if (!archivos.length) { console.log(id, 'sin fuentes'); continue; }
      const e = elegir(archivos);
      const ext = path.extname(e.p).toLowerCase();
      const corto = RF + '/gh-' + id + ext;
      fs.copyFileSync(e.p, corto);
      salida[id] = { url, archivo: corto, base: e.b, n: archivos.length, todos: archivos.map((x) => path.basename(x)).slice(0, 40) };
      console.log(id, '→', e.b, '(' + archivos.length + ' archivos)');
    } catch (e) { console.log(id, 'ERROR', e.message.slice(0, 80)); }
  }
  fs.writeFileSync('gh-archivos.json', JSON.stringify(salida, null, 1));
})();
