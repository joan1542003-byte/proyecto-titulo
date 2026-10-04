// Lee en la página de cada tipografía de Pangram Pangram quién la diseñó, el año y la licencia que ofrece.
const fs = require('fs');
const { launch, sleep } = require('../cdp.js');
const SLUGS = ['acma', 'hatton', 'migra', 'kyoto', 'right-didone', 'gatwick', 'editorial-new', 'pangaia', 'chronos-serif', 'woodland', 'playground', 'eiko', 'casa-stencil', 'grafier'];
function leer() {
  const t = document.body.innerText.split('\n').map((s) => s.trim()).filter(Boolean);
  const out = [];
  t.forEach((s, i) => {
    if (/^(designers?|designed by|design|released|release date|year|foundry|published|license|licence|styles?|glyphs?|languages?)\s*:?$/i.test(s) && t[i + 1]) out.push(s + ': ' + t[i + 1].slice(0, 100));
  });
  const free = t.filter((s) => /free to try|free trial|personal use|student|portfolio/i.test(s)).slice(0, 4);
  return { campos: out.slice(0, 10), libres: free };
}
(async () => {
  const ch = await launch(9751);
  const res = {};
  try {
    await ch.size(1400, 900);
    for (const s of SLUGS) {
      await ch.open('https://pangrampangram.com/products/' + s); await sleep(2800);
      res[s] = await ch.eval(`(${leer.toString()})()`);
      console.log('##', s, JSON.stringify(res[s]).slice(0, 420));
    }
  } finally { fs.writeFileSync('creditos-pp.json', JSON.stringify(res, null, 1)); await ch.close(); }
})();
