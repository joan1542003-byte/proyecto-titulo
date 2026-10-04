// Para las letras de UNCUT alojadas en sitios de sus autores: busca enlaces directos a archivos (zip, otf, ttf, woff2) en la página de descarga.
const fs = require('fs');
const lista = JSON.parse(fs.readFileSync('enlaces.json', 'utf8'));
const hechos = new Set(JSON.parse(fs.readFileSync('descargas.json', 'utf8')).filter((r) => r.ok).map((r) => r.id));
const skipHost = /github\.com|uncut\.wtf|fonts\.google|behance|velvetyne|collletttivo|fontspring|ftp\.gnu/;
(async () => {
  const pend = lista.filter((o) => !o.google && o.dl && !hechos.has(o.id) && !skipHost.test(o.dl));
  console.log('pendientes en sitios de autores:', pend.length);
  const out = [];
  for (const o of pend) {
    try {
      const ctl = new AbortController(); const t = setTimeout(() => ctl.abort(), 20000);
      const r = await fetch(o.dl, { redirect: 'follow', signal: ctl.signal }); clearTimeout(t);
      const html = await r.text();
      const base = r.url;
      const links = [...new Set([...html.matchAll(/(?:href|src)=["']([^"'#]+\.(?:zip|otf|ttf|woff2?))(?:\?[^"']*)?["']/gi)].map((m) => { try { return new URL(m[1], base).href; } catch (e) { return null; } }).filter(Boolean))];
      out.push({ id: o.id, nombre: o.nombre, dl: o.dl, status: r.status, files: links.slice(0, 8) });
      console.log(o.nombre.padEnd(22), r.status, links.length, links.slice(0, 2).join(' '));
    } catch (e) { out.push({ id: o.id, nombre: o.nombre, dl: o.dl, error: e.message.slice(0, 40) }); console.log(o.nombre.padEnd(22), 'ERR', e.message.slice(0, 40)); }
  }
  fs.writeFileSync('otros.json', JSON.stringify(out, null, 1));
})();
