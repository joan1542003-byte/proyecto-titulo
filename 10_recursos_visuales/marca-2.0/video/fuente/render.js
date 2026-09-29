// node render.js preview t1,t2,...  |  node render.js all
const puppeteer = require('puppeteer-core');
const path = require('path'), fs = require('fs');
(async () => {
  const mode = process.argv[2];
  const browser = await puppeteer.launch({ executablePath: 'C:/Program Files/Google/Chrome/Application/chrome.exe', headless: 'new', args: ['--allow-file-access-from-files', '--force-device-scale-factor=1', '--hide-scrollbars'] });
  const page = await browser.newPage();
  await page.setViewport({ width: 1920, height: 1080, deviceScaleFactor: 1 });
  page.on('pageerror', e => console.log('ERR', e.message));
  await page.goto('file:///' + path.resolve('index.html').split(path.sep).join('/'));
  await page.evaluate(() => window.ready());
  if (mode === 'preview') {
    fs.mkdirSync('prev', { recursive: true });
    for (const t of process.argv[3].split(',').map(Number)) {
      await page.evaluate(t => window.render(t), t);
      await page.screenshot({ path: `prev/t${t.toFixed(2)}.png` });
    }
  } else {
    fs.mkdirSync('frames', { recursive: true });
    const fps = 60, n = 15 * fps;
    for (let i = 0; i < n; i++) {
      await page.evaluate(t => window.render(t), i / fps);
      await page.screenshot({ path: `frames/f${String(i).padStart(4, '0')}.jpg`, type: 'jpeg', quality: 95 });
      if (i % 100 === 0) console.log('frame', i);
    }
  }
  await browser.close();
})();
