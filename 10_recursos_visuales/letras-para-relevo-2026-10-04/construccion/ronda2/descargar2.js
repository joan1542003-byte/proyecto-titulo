// Descarga los archivos directos de las letras de UNCUT alojadas en sitios de sus autores (con el permiso del autor del proyecto).
const fs = require('fs');
const path = require('path');
const { spawnSync } = require('child_process');
const otros = JSON.parse(fs.readFileSync('otros.json', 'utf8'));
const ZIPS = path.join(__dirname, 'zips'), EXT = path.join(__dirname, 'extraido');
const TAR = 'C:/Windows/System32/tar.exe';
const norm = (s) => s.toLowerCase().replace(/[^a-z0-9]/g, '');
const SALTAR = /gitlab\.com\/assets|filesusr\.com|compagnon/i;
(async () => {
  const res = [];
  for (const o of otros) {
    const files = (o.files || []).filter((u) => !SALTAR.test(u));
    if (!files.length) continue;
    const n = norm(o.nombre);
    const pick = files.find((u) => norm(decodeURIComponent(u.split('/').pop())).includes(n)) || (/Mono/.test(o.nombre) ? files.find((u) => /Bold/i.test(u)) : null) || files[0];
    const nombre = o.id.replace(/\//g, '__');
    const ext = (pick.split('?')[0].match(/\.(zip|otf|ttf|woff2?)$/i) || ['.zip'])[0].toLowerCase();
    const dest = path.join(ZIPS, nombre + ext);
    try {
      const ctl = new AbortController(); const t = setTimeout(() => ctl.abort(), 90000);
      const r = await fetch(pick, { redirect: 'follow', signal: ctl.signal }); clearTimeout(t);
      if (!r.ok) { console.log('NO ', o.nombre, 'HTTP', r.status); continue; }
      const buf = Buffer.from(await r.arrayBuffer());
      if (buf.length > 150 * 1024 * 1024) { console.log('NO ', o.nombre, 'muy grande'); continue; }
      fs.writeFileSync(dest, buf);
      const dir = path.join(EXT, nombre); fs.mkdirSync(dir, { recursive: true });
      if (ext === '.zip') { const x = spawnSync(TAR, ['-xf', dest, '-C', dir], { encoding: 'utf8' }); if (x.status !== 0) { console.log('NO ', o.nombre, 'tar', (x.stderr || '').slice(0, 60)); continue; } }
      else fs.copyFileSync(dest, path.join(dir, path.basename(dest)));
      res.push({ id: o.id, ok: true, url: pick, mb: +(buf.length / 1048576).toFixed(2) });
      console.log('ok ', o.nombre.padEnd(22), (buf.length / 1048576).toFixed(2), 'MB', pick.slice(0, 80));
    } catch (e) { console.log('NO ', o.nombre, e.name === 'AbortError' ? 'tiempo agotado' : e.message.slice(0, 50)); }
  }
  const prev = JSON.parse(fs.readFileSync('descargas.json', 'utf8'));
  fs.writeFileSync('descargas.json', JSON.stringify(prev.concat(res), null, 1));
  console.log('listo', res.length);
})();
