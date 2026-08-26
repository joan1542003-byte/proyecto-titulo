import { chromium } from "@playwright/test";
import { mkdir, writeFile } from "node:fs/promises";
import path from "node:path";

const baseUrl = process.env.RELEVO_PREVIEW_URL ?? "http://127.0.0.1:4173";
const outputDir = path.resolve("public/exports");
const delivery = ["1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2", "3.3"];
const coverage = Array.from({ length: 35 }, (_, index) => String(index + 1).padStart(2, "0"));
const targets = [
  ...delivery.map((id) => ({ mode: "entrega", key: "frame", id })),
  ...coverage.map((id) => ({ mode: "cobertura", key: "state", id })),
];

await mkdir(outputDir, { recursive: true });
const browser = await chromium.launch({
  headless: true,
  executablePath: process.env.RELEVO_BROWSER_PATH ?? "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
});
const page = await browser.newPage({ viewport: { width: 1400, height: 1200 }, deviceScaleFactor: 2 });
const manifest = [];

for (const target of targets) {
  const url = `${baseUrl}/?mode=${target.mode}&${target.key}=${encodeURIComponent(target.id)}`;
  await page.goto(url, { waitUntil: "networkidle" });
  await page.locator('[data-testid="home-indicator"], [data-testid="android-navigation-bar"]').evaluateAll((nodes) => {
    for (const node of nodes) node.style.display = "none";
  });
  const current = page.getByTestId("wireframe-current");
  await current.waitFor({ state: "visible" });
  if ((await current.getAttribute("data-frame-id")) !== target.id) throw new Error(`No se pudo abrir ${target.mode} ${target.id}`);
  const download = page.getByTestId("download-frame");
  const fileName = await download.getAttribute("download");
  if (!fileName) throw new Error(`El marco ${target.id} no declara nombre de descarga`);
  const surface = page.getByTestId("export-surface");
  await surface.evaluate((node) => { node.style.borderRadius = "0"; });
  await surface.evaluate((node) => node.scrollIntoView({ block: "center", inline: "nearest" }));
  await surface.screenshot({ path: path.join(outputDir, fileName) });
  manifest.push({ ...target, file: fileName, url });
}

await writeFile(path.join(outputDir, "manifest.json"), `${JSON.stringify(manifest, null, 2)}\n`, "utf8");
await browser.close();
console.log(`Exportados ${manifest.length} wireframes en ${outputDir}`);
