// Extrae los zip descargados con el tar de Windows (bsdtar), que sí abre zip.
const fs = require('fs');
const path = require('path');
const { spawnSync } = require('child_process');
const ZIPS = path.join(__dirname, 'zips');
const EXT = path.join(__dirname, 'extraido');
const TAR = 'C:/Windows/System32/tar.exe';
let ok = 0, mal = 0;
for (const f of fs.readdirSync(ZIPS).filter((x) => /\.zip$/i.test(x))) {
  const dir = path.join(EXT, f.replace(/\.zip$/i, ''));
  if (fs.existsSync(dir) && fs.readdirSync(dir).length) continue;
  fs.mkdirSync(dir, { recursive: true });
  const r = spawnSync(TAR, ['-xf', path.join(ZIPS, f), '-C', dir], { encoding: 'utf8' });
  if (r.status === 0) ok++; else { mal++; console.log('NO', f, (r.stderr || '').slice(0, 100)); }
}
console.log('extraídos', ok, 'con error', mal);
