// Para cada letra de Free Faces Gallery: título, autoría, licencia y enlaces de descarga o de la fuente.
const fs = require('fs');
const slugs = JSON.parse(fs.readFileSync('freefaces-slugs.json', 'utf8'));
const goog = new Set(JSON.parse(fs.readFileSync('../v38/google-families.json', 'utf8')).map((f) => f.toLowerCase().replace(/[^a-z0-9]/g, '')));
(async () => {
  const out = [];
  for (const s of slugs) {
    try {
      const html = await (await fetch('https://www.freefaces.gallery/typefaces/' + s)).text();
      const title = (html.match(/<title>([^<]+)<\/title>/) || ['', s])[1].replace(/\s*[|–-]\s*Free Faces.*$/i, '').trim();
      const body = html.replace(/<style[\s\S]*?<\/style>/g, ' ').replace(/<script[\s\S]*?<\/script>/g, ' ');
      const links = [...new Set([...body.matchAll(/href="(https?:\/\/[^"]+)"/g)].map((m) => m[1]))].filter((h) => !/freefaces|website-files|webflow|twitter|instagram|simonfoster|googleapis|gstatic|google\.com/i.test(h));
      const txt = body.replace(/<[^>]+>/g, ' ').replace(/\s+/g, ' ');
      const lic = (txt.match(/(OFL|SIL Open Font License|Apache|CC0|CC BY[^ ]*|MIT|GPL|Free for personal|Free for commercial|Public domain|Freeware)[^.]{0,40}/i) || [''])[0].trim();
      const by = (txt.match(/(?:by|designer|designed by)\s+([A-Z][^.|]{3,40})/) || ['', ''])[1].trim();
      out.push({ slug: s, title, links: links.slice(0, 6), lic, by, google: goog.has(title.toLowerCase().replace(/[^a-z0-9]/g, '')) || links.some((l) => /fonts\.google\.com/.test(l)) });
    } catch (e) { out.push({ slug: s, error: e.message.slice(0, 40) }); }
  }
  fs.writeFileSync('freefaces.json', JSON.stringify(out, null, 1));
  for (const o of out) console.log((o.title || o.slug).padEnd(26), o.google ? '[GOOGLE]' : '        ', (o.lic || '?').slice(0, 24).padEnd(24), (o.links || [])[0] || '');
})();
