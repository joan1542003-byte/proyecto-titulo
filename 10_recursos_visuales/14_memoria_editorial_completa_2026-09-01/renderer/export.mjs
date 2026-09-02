import fs from 'node:fs';
import path from 'node:path';
import { fileURLToPath } from 'node:url';
import { chromium } from '@playwright/test';

const here = path.dirname(fileURLToPath(import.meta.url));
const html = path.join(here, 'dist', 'index.html');
const output = path.resolve(here, '..', 'paginas_png');
fs.mkdirSync(output, { recursive: true });
for (const file of fs.readdirSync(output)) {
  if (/^pagina-\d{3}\.png$/.test(file)) fs.unlinkSync(path.join(output, file));
}

const edge = 'C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe';
const browser = await chromium.launch({ headless: true, executablePath: edge });
const page = await browser.newPage({ viewport: { width: 1700, height: 1250 }, deviceScaleFactor: 1 });
await page.goto(`file:///${html.replace(/\\/g, '/')}`);
await page.waitForFunction(() => document.documentElement.dataset.ready === 'true');
await page.evaluate(async () => document.fonts.ready);
const pages = page.locator('.page');
const count = await pages.count();
for (let i = 0; i < count; i += 1) {
  const name = `pagina-${String(i + 1).padStart(3, '0')}.png`;
  await pages.nth(i).screenshot({ path: path.join(output, name) });
}
await browser.close();
console.log(`Exportadas ${count} páginas en ${output}`);
