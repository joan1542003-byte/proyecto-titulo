import { chromium } from '@playwright/test';
import { mkdir } from 'node:fs/promises';
import path from 'node:path';
import { fileURLToPath } from 'node:url';

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), '..');
const output = path.join(root, 'qa');
await mkdir(output, { recursive: true });

const browser = await chromium.launch({ channel: 'msedge' });
for (const viewport of [
  { width: 1366, height: 1000 },
  { width: 1536, height: 1000 },
  { width: 1920, height: 1200 },
]) {
  const page = await browser.newPage({ viewport });
  await page.goto('http://127.0.0.1:4173/?mode=entrega&frame=1.1', { waitUntil: 'networkidle' });
  await page.screenshot({
    path: path.join(output, `tablero-${viewport.width}.png`),
    fullPage: true,
  });
  await page.close();
}
await browser.close();
