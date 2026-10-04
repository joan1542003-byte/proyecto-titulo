// Lee en la página de cada tipografía quién la diseñó y bajo qué licencia se ofrece.
const { launch, sleep } = require('../cdp.js');
const PAGES = [
  ['gosha-sans', 'https://pangrampangram.com/products/gosha-sans'], ['editorial-new', 'https://pangrampangram.com/products/editorial-new'], ['migra', 'https://pangrampangram.com/products/migra'], ['eiko', 'https://pangrampangram.com/products/eiko'],
  ['pangaia', 'https://pangrampangram.com/products/pangaia'], ['agrandir', 'https://pangrampangram.com/products/agrandir'], ['frama', 'https://pangrampangram.com/products/frama'], ['watch', 'https://pangrampangram.com/products/watch'],
  ['combat', 'https://velvetyne.fr/fonts/combat/'], ['ouroboros', 'https://velvetyne.fr/fonts/ouroboros/'],
  ['mattone', 'https://www.collletttivo.it/typefaces/mattone'], ['ronzino', 'https://www.collletttivo.it/typefaces/ronzino'],
];
function leer() {
  const t = document.body.innerText.split('\n').map((s) => s.trim()).filter(Boolean);
  const out = [];
  t.forEach((s, i) => {
    if (/^(designers?|designed by|released|release date|year|foundry|published)\s*:?$/i.test(s) && t[i + 1]) {
      out.push(s + ': ' + t[i + 1].slice(0, 90) + (t[i + 2] && t[i + 2].length < 60 ? ' / ' + t[i + 2] : ''));
    }
  });
  return out.slice(0, 6);
}
(async () => {
  const ch = await launch(9409);
  try {
    await ch.size(1400, 900);
    for (const [id, url] of PAGES) {
      await ch.open(url); await sleep(2500);
      const r = await ch.eval(`(${leer.toString()})()`);
      console.log('##', id, '\n  ' + r.join('\n  '));
    }
  } finally { await ch.close(); }
})();
