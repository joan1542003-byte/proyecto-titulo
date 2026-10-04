// Renderiza «relevo» con cada tipografía de Fontshare con licencia ITF Free Font License (la hoja de estilo pública de Fontshare; no se guardan fuentes).
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
(async () => {
  const j = await (await fetch('https://api.fontshare.com/v2/fonts?limit=100')).json();
  const list = j.fonts.filter((f) => f.license_type === 'itf_ffl' && !/Handwritten|Script/i.test(f.category)).map((f) => {
    const ws = [...new Set((f.styles || []).filter((s) => !s.is_italic && !/variable/i.test(s.name || '')).map((s) => s.weight && s.weight.number).filter(Boolean))].sort((a, b) => a - b);
    const w = ws.includes(700) ? 700 : ws.includes(600) ? 600 : ws.includes(800) ? 800 : ws.includes(500) ? 500 : ws[ws.length - 1] || 400;
    return { name: f.name, slug: f.slug, cat: f.category, w, ws, designers: (f.designers || []).map((d) => d.name).join(', '), year: (f.inserted_at || '').slice(0, 4) };
  });
  fs.writeFileSync(path.join(__dirname, 'lista.json'), JSON.stringify(list, null, 1));
  const css = 'https://api.fontshare.com/v2/css?' + list.map((f) => `f[]=${f.slug}@${f.w}`).join('&') + '&display=block';
  const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${css}"><body style="margin:0;background:#fff">${list.map((f, i) => `<div id="r${i}" style="width:900px;padding:18px 26px;box-sizing:border-box;font-family:'${f.name}';font-weight:${f.w};font-size:150px;line-height:1.1;white-space:nowrap;letter-spacing:-0.02em;color:#141519;background:#fff">relevo</div>`).join('')}</body>`;
  fs.writeFileSync(path.join(__dirname, 'run.html'), html);
  const ch = await launch(9405);
  try {
    await ch.size(1000, 900);
    await ch.open('file:///' + path.join(__dirname, 'run.html').split(path.sep).join('/'));
    await sleep(5000);
    const bad = await ch.eval(`(async () => { await document.fonts.ready; return ${JSON.stringify(list.map((f) => f.name))}.filter((n, i) => !document.fonts.check(${JSON.stringify(list.map((f) => f.w))}[i] + ' 40px "' + n + '"')); })()`);
    const H = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1000, H); await sleep(800);
    for (let i = 0; i < list.length; i++) {
      const r = await ch.eval(`(() => { const b = document.getElementById('r${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(__dirname, 'img', list[i].slug + '.png'), Buffer.from(s.data, 'base64'));
    }
    console.log('renders', list.length, 'sin cargar:', JSON.stringify(bad));
  } finally { await ch.close(); }
})();
