// Descarga los archivos de las letras de UNCUT que están en GitHub o en el propio UNCUT (con el permiso del autor) y extrae las fuentes.
// Se guardan fuera del repositorio, en esta carpeta de trabajo. No se instala nada ni se ejecuta nada descargado.
const fs = require('fs');
const path = require('path');
const { spawnSync } = require('child_process');
const lista = JSON.parse(fs.readFileSync(path.join(__dirname, 'enlaces.json'), 'utf8'));
const ZIPS = path.join(__dirname, 'zips');
const EXT = path.join(__dirname, 'extraido');
fs.mkdirSync(ZIPS, { recursive: true });
fs.mkdirSync(EXT, { recursive: true });

function destino(dl) {
  try {
    const u = new URL(dl);
    if (u.hostname === 'github.com') {
      const p = u.pathname.split('/').filter(Boolean);
      if (p.length >= 2) {
        if (p[2] === 'releases' || p[2] === 'raw') return null;
        return `https://github.com/${p[0]}/${p[1]}/archive/HEAD.zip`;
      }
    }
    if (u.hostname === 'uncut.wtf' && /\.zip$/i.test(u.pathname)) return dl;
    if (/\.(zip|otf|ttf|woff2?)$/i.test(u.pathname) && !/google|behance/.test(u.hostname)) return dl;
  } catch (e) { /* sin enlace */ }
  return null;
}

async function bajar(id, url) {
  const nombre = id.replace(/\//g, '__');
  const zip = path.join(ZIPS, nombre + (/\.(otf|ttf|woff2?)$/i.test(url) ? path.extname(new URL(url).pathname) : '.zip'));
  if (fs.existsSync(zip) && fs.statSync(zip).size > 1000) return { id, zip, ok: true, cache: true };
  const ctl = new AbortController();
  const t = setTimeout(() => ctl.abort(), 120000);
  try {
    const r = await fetch(url, { redirect: 'follow', signal: ctl.signal });
    if (!r.ok) return { id, ok: false, motivo: 'HTTP ' + r.status };
    const buf = Buffer.from(await r.arrayBuffer());
    if (buf.length > 120 * 1024 * 1024) return { id, ok: false, motivo: 'muy grande ' + Math.round(buf.length / 1048576) + ' MB' };
    fs.writeFileSync(zip, buf);
    return { id, zip, ok: true, mb: +(buf.length / 1048576).toFixed(1) };
  } catch (e) { return { id, ok: false, motivo: e.name === 'AbortError' ? 'tiempo agotado' : e.message.slice(0, 60) }; } finally { clearTimeout(t); }
}

(async () => {
  const tareas = lista.map((o) => ({ id: o.id, url: destino(o.dl) })).filter((x) => x.url);
  console.log('a descargar:', tareas.length, 'de', lista.length);
  const res = [];
  let i = 0;
  async function worker() {
    while (i < tareas.length) {
      const t = tareas[i++];
      const r = await bajar(t.id, t.url);
      if (r.ok && /\.zip$/i.test(r.zip)) {
        const dir = path.join(EXT, t.id.replace(/\//g, '__'));
        if (!fs.existsSync(dir)) { fs.mkdirSync(dir, { recursive: true }); const x = spawnSync('tar', ['-xf', r.zip, '-C', dir], { encoding: 'utf8' }); if (x.status !== 0) r.extraer = 'error tar: ' + (x.stderr || '').slice(0, 80); }
      } else if (r.ok) {
        const dir = path.join(EXT, t.id.replace(/\//g, '__')); fs.mkdirSync(dir, { recursive: true }); fs.copyFileSync(r.zip, path.join(dir, path.basename(r.zip)));
      }
      res.push(r);
      console.log(r.ok ? 'ok ' : 'NO ', t.id, r.mb ? r.mb + ' MB' : (r.motivo || ''), r.extraer || '');
    }
  }
  await Promise.all([worker(), worker(), worker(), worker()]);
  fs.writeFileSync(path.join(__dirname, 'descargas.json'), JSON.stringify(res, null, 1));
  console.log('listo:', res.filter((r) => r.ok).length, 'ok;', res.filter((r) => !r.ok).length, 'fallaron');
})();
