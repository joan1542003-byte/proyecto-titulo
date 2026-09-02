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
const page = await browser.newPage({ viewport: { width: 1900, height: 1500 }, deviceScaleFactor: 2 });
const manifest = [];

for (const target of targets) {
  const url = `${baseUrl}/?mode=${target.mode}&${target.key}=${encodeURIComponent(target.id)}`;
  await page.goto(url, { waitUntil: "networkidle" });
  const current = page.getByTestId("wireframe-current");
  await current.waitFor({ state: "visible" });
  if ((await current.getAttribute("data-frame-id")) !== target.id) throw new Error(`No se pudo abrir ${target.mode} ${target.id}`);
  const download = page.getByTestId("download-frame");
  const fileName = await download.getAttribute("download");
  if (!fileName) throw new Error(`El marco ${target.id} no declara nombre de descarga`);
  const surface = page.getByTestId("export-surface");
  await surface.evaluate((node) => node.scrollIntoView({ block: "center", inline: "nearest" }));
  const box = await surface.boundingBox();
  if (!box || Math.abs(box.width - 412) > 1 || Math.abs(box.height - 915) > 1) throw new Error(`Lienzo inesperado en ${target.id}: ${box?.width} × ${box?.height}`);
  const overflow = await surface.locator(".wireframe-canvas").evaluate((node) => node.scrollHeight > node.clientHeight + 1 || node.scrollWidth > node.clientWidth + 1);
  if (overflow) throw new Error(`El contenido desborda el lienzo en ${target.mode} ${target.id}`);
  await surface.screenshot({ path: path.join(outputDir, fileName) });
  manifest.push({ ...target, file: fileName, canvas: "412x915dp", png: "824x1830px", url });
}

await writeFile(path.join(outputDir, "manifest.json"), `${JSON.stringify(manifest, null, 2)}\n`, "utf8");
await browser.close();
console.log(`Exportados ${manifest.length} wireframes en ${outputDir}`);
