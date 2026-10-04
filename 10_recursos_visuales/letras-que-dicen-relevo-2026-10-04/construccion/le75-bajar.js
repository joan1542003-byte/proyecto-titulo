// Descarga las letras libres de la tipoteca de Le75 (Bruselas), con el permiso del autor del proyecto, y las abre. Se guardan fuera del repositorio.
const fs = require('fs');
const path = require('path');
const { spawnSync } = require('child_process');
const TAR = 'C:/Windows/System32/tar.exe';
(async () => {
  const html = await (await fetch('https://typotheque.le75.be/')).text();
  const zips = [...new Set([...html.matchAll(/href="(\/site\/assets\/files\/\d+\/[^"]+\.zip)"/g)].map((m) => m[1]))];
  const licInfo = html.replace(/<style[\s\S]*?<\/style>/g, ' ').replace(/<script[\s\S]*?<\/script>/g, ' ').replace(/<[^>]+>/g, ' ').replace(/\s+/g, ' ');
  const i = licInfo.search(/licen[cs]e/i);
  console.log('licencia en la página:', i >= 0 ? licInfo.slice(Math.max(0, i - 100), i + 260) : '(no se encontró)');
  fs.mkdirSync('zips', { recursive: true }); fs.mkdirSync('ext', { recursive: true });
  const res = [];
  for (const z of zips) {
    const id = path.basename(z, '.zip');
    try {
      const r = await fetch('https://typotheque.le75.be' + z);
      if (!r.ok) { console.log('NO', id, r.status); continue; }
      const buf = Buffer.from(await r.arrayBuffer());
      fs.writeFileSync(path.join('zips', id + '.zip'), buf);
      const dir = path.join('ext', id); fs.mkdirSync(dir, { recursive: true });
      const x = spawnSync(TAR, ['-xf', path.join('zips', id + '.zip'), '-C', dir], { encoding: 'utf8' });
      res.push({ id, nombre: id, mb: +(buf.length / 1048576).toFixed(2), tar: x.status === 0 });
      console.log('ok', id.padEnd(22), (buf.length / 1024).toFixed(0), 'KB', x.status === 0 ? '' : 'tar falló');
    } catch (e) { console.log('NO', id, e.message.slice(0, 50)); }
  }
  fs.writeFileSync('lista.json', JSON.stringify(res, null, 1));
  console.log('listo', res.length);
})();
