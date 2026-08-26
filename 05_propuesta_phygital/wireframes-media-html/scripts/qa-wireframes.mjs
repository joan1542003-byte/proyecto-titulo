import { chromium } from "@playwright/test";
import { existsSync, readFileSync } from "node:fs";
import path from "node:path";

const baseUrl = process.env.RELEVO_PREVIEW_URL ?? "http://127.0.0.1:4173";
const browser = await chromium.launch({ headless: true, executablePath: process.env.RELEVO_BROWSER_PATH ?? "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe" });
const page = await browser.newPage({ viewport: { width: 1400, height: 1200 }, deviceScaleFactor: 1 });
const errors = [];
page.on("console", (message) => {
  if (message.type() === "error" && !message.text().includes("Failed to load resource")) errors.push(message.text());
});
page.on("pageerror", (error) => errors.push(error.message));
page.on("response", (response) => {
  if (response.status() >= 400 && !response.url().endsWith("/favicon.ico")) errors.push(`${response.status()} ${response.url()}`);
});

await page.goto(`${baseUrl}/?mode=entrega&frame=1.1`, { waitUntil: "networkidle" });
const screen = page.getByTestId("device-screen");
const box = await screen.boundingBox();
if (!box || Math.abs(box.width - 393) > 1 || Math.abs(box.height - 852) > 1) throw new Error(`Viewport móvil inesperado: ${box?.width} × ${box?.height}`);
await page.getByTestId("next-frame").click();
if (await page.getByTestId("wireframe-current").getAttribute("data-frame-id") !== "1.2") throw new Error("La navegación siguiente no avanzó a 1.2");
await page.getByTestId("mode-cobertura").click();
if (await page.getByTestId("wireframe-current").getAttribute("data-frame-id") !== "01") throw new Error("El selector Cobertura no abrió el estado 01");
await page.getByTestId("frame-sheet").locator("summary").click();
if (!(await page.getByTestId("frame-sheet").evaluate((node) => node.open))) throw new Error("La ficha no se abrió");

const manifest = JSON.parse(readFileSync(path.resolve("public/exports/manifest.json"), "utf8"));
if (manifest.length !== 44) throw new Error(`Se esperaban 44 exportaciones y se encontraron ${manifest.length}`);
for (const item of manifest) {
  if (!existsSync(path.resolve("public/exports", item.file))) throw new Error(`Falta ${item.file}`);
}
const overflow = await page.getByTestId("wireframe-current").evaluate((node) => node.scrollWidth > node.clientWidth + 1);
if (overflow) throw new Error("Existe desborde horizontal en el contenido principal");
if (errors.length) throw new Error(`Errores de consola: ${errors.join(" | ")}`);

console.log(JSON.stringify({ viewport: `${box.width}x${box.height}`, navigation: "passed", sheet: "passed", exports: manifest.length, overflow: false, consoleErrors: 0 }));
await browser.close();
