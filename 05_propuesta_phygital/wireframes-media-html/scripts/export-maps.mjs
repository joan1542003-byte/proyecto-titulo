import { chromium } from "@playwright/test";
import fs from "node:fs/promises";
import path from "node:path";
import { fileURLToPath } from "node:url";

const here = path.dirname(fileURLToPath(import.meta.url));
const output = path.resolve(here, "../public/exports/maps");
const baseUrl = process.env.RELEVO_URL ?? "http://127.0.0.1:4173";

const maps = [
  { id: "overview", file: "mapa-general-jerarquico.png" },
  { id: "route", file: "mapa-ruta-principal-legible.png" },
  { id: "coverage", file: "mapa-cobertura-por-familias.png" },
];

await fs.mkdir(output, { recursive: true });

const browser = await chromium.launch({
  headless: true,
  executablePath: process.env.RELEVO_BROWSER_PATH ?? "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
});
try {
  for (const map of maps) {
    const page = await browser.newPage({ viewport: { width: 4200, height: 7600 }, deviceScaleFactor: 1 });
    await page.goto(`${baseUrl}/?view=mapa&map=${map.id}`, { waitUntil: "networkidle" });
    await page.evaluate(() => document.fonts.ready);
    const surface = page.locator('[data-testid="map-export"]');
    await surface.waitFor({ state: "visible" });
    await surface.screenshot({ path: path.join(output, map.file), animations: "disabled" });
    await page.close();
  }
} finally {
  await browser.close();
}

console.log(`Guardados ${maps.length} mapas en ${output}`);
