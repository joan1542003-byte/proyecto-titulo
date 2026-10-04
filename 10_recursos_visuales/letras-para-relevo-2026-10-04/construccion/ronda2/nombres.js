// Añade a cada letra de UNCUT su nombre (título de la página) y si también está en Google Fonts.
const fs = require('fs');
const lista = JSON.parse(fs.readFileSync('enlaces.json', 'utf8'));
const goog = new Set(JSON.parse(fs.readFileSync('../google-families.json', 'utf8')).map((f) => f.toLowerCase().replace(/[^a-z0-9]/g, '')));
(async () => {
  for (const o of lista) {
    try {
      const html = await (await fetch(`https://uncut.wtf/${o.id}/`)).text();
      const t = (html.match(/<title>([^<]+)<\/title>/) || ['', ''])[1];
      o.nombre = t.replace(/^Download\s+/, '').replace(/\s+[–-]\s+UNCUT.*$/, '').trim();
    } catch (e) { o.nombre = o.id.split('/')[1]; }
    const n = o.nombre.toLowerCase().replace(/[^a-z0-9]/g, '');
    o.google = goog.has(n) || /fonts\.google\.com/.test(o.dl);
  }
  fs.writeFileSync('enlaces.json', JSON.stringify(lista, null, 1));
  console.log('en Google Fonts:', lista.filter((o) => o.google).map((o) => o.nombre).join(', '));
  console.log('total', lista.length, 'no Google', lista.filter((o) => !o.google).length);
})();
