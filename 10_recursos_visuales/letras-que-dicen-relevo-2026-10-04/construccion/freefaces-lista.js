// Lee la categoría «display» de Free Faces Gallery: nombre, autoría, licencia y enlace a la fuente de cada letra.
const fs = require('fs');
(async () => {
  const slugs = new Set();
  let pagKey = null;
  const first = await (await fetch('https://www.freefaces.gallery/display')).text();
  const m = first.match(/\?([0-9a-f]{8})_page=2/);
  pagKey = m ? m[1] : null;
  console.log('clave de paginación:', pagKey);
  for (let p = 1; p <= 30; p++) {
    const u = p === 1 ? 'https://www.freefaces.gallery/display' : `https://www.freefaces.gallery/display?${pagKey}_page=${p}`;
    const t = await (await fetch(u)).text();
    const found = [...new Set([...t.matchAll(/href="\/typefaces\/([a-z0-9-]+)"/g)].map((x) => x[1]))];
    const antes = slugs.size;
    found.forEach((s) => slugs.add(s));
    console.log('página', p, found.length, 'nuevas', slugs.size - antes);
    if (slugs.size === antes) break;
  }
  fs.writeFileSync('freefaces-slugs.json', JSON.stringify([...slugs], null, 1));
  console.log('total', slugs.size);
})();
