// Lista las letras de una categoría de Free Faces Gallery (con paginación) y lee de cada una título, licencia y enlaces.
// uso: node ff-cat.js <categoria> [salida.json]
const fs = require('fs');
const cat = process.argv[2] || 'serif';
const salida = process.argv[3] || 'ff-' + cat + '.json';
const base = 'https://www.freefaces.gallery';
(async () => {
  const slugs = new Set();
  let url = base + '/' + cat;
  for (let n = 0; n < 12 && url; n++) {
    const html = await (await fetch(url)).text();
    for (const m of html.matchAll(/href="\/typefaces\/([a-z0-9-]+)"/g)) slugs.add(m[1]);
    const next = html.match(/class="w-pagination-next[^"]*"[^>]*href="([^"]+)"/) || html.match(/href="([^"]+)"[^>]*class="w-pagination-next/);
    url = next ? (next[1].startsWith('http') ? next[1] : base + '/' + cat + next[1].replace(/^\/[a-z-]+/, '')) : null;
  }
  console.log(cat, 'slugs', slugs.size);
  const out = [];
  for (const s of slugs) {
    try {
      const html = await (await fetch(base + '/typefaces/' + s)).text();
      const title = (html.match(/<title>([^<]+)<\/title>/) || ['', s])[1].replace(/\s*[|–-]\s*Free Faces.*$/i, '').trim();
      const body = html.replace(/<style[\s\S]*?<\/style>/g, ' ').replace(/<script[\s\S]*?<\/script>/g, ' ');
      const links = [...new Set([...body.matchAll(/href="(https?:\/\/[^"]+)"/g)].map((m) => m[1]))].filter((h) => !/freefaces|website-files|webflow|twitter|instagram|simonfoster|googleapis|gstatic|google\.com\/fonts/i.test(h));
      const txt = body.replace(/<[^>]+>/g, ' ').replace(/\s+/g, ' ');
      const lic = (txt.match(/(SIL Open Font License|OFL|Apache|CC0|CC BY[^ ]*|MIT|GPL|Free for personal use|Free for commercial|Public domain|Freeware|Free to use)[^.]{0,50}/i) || [''])[0].trim();
      out.push({ slug: s, title, links: links.slice(0, 5), lic, google: links.some((l) => /fonts\.google\.com/.test(l)) });
    } catch (e) { out.push({ slug: s, error: e.message.slice(0, 40) }); }
  }
  fs.writeFileSync(salida, JSON.stringify(out, null, 1));
  for (const o of out) console.log((o.title || o.slug).padEnd(28), o.google ? '[G]' : '   ', (o.lic || '?').slice(0, 26).padEnd(26), (o.links || [])[0] || '');
})();
