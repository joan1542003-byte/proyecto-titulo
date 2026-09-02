import { chromium } from "@playwright/test";
import { existsSync, readFileSync } from "node:fs";
import path from "node:path";

const baseUrl = process.env.RELEVO_PREVIEW_URL ?? "http://127.0.0.1:4173";
const browser = await chromium.launch({ headless: true, executablePath: process.env.RELEVO_BROWSER_PATH ?? "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe" });
const page = await browser.newPage({ viewport: { width: 1900, height: 1500 }, deviceScaleFactor: 1 });
const errors = [];

page.on("console", (message) => {
  if (message.type() === "error" && !message.text().includes("Failed to load resource")) errors.push(message.text());
});
page.on("pageerror", (error) => errors.push(error.message));
page.on("response", (response) => {
  if (response.status() >= 400 && !response.url().endsWith("/favicon.ico")) errors.push(`${response.status()} ${response.url()}`);
});

await page.goto(`${baseUrl}/?mode=entrega&frame=1.1`, { waitUntil: "networkidle" });
if (await page.locator("html").getAttribute("lang") !== "es") throw new Error("El documento no declara idioma español");
const surface = page.getByTestId("export-surface");
const box = await surface.boundingBox();
if (!box || Math.abs(box.width - 920) > 1 || Math.abs(box.height - 1150) > 1) throw new Error(`Lienzo exportable inesperado: ${box?.width} × ${box?.height}`);
if (await page.locator(".phone-device, .device-screen, .status-bar, .android-navigation-bar").count()) throw new Error("La presentación todavía contiene simulación de teléfono");

const download = page.getByTestId("download-frame");
if (await surface.locator('[data-testid="download-frame"]').count()) throw new Error("El botón de exportación está dentro del PNG");
if ((await download.getAttribute("download")) !== "1-1-formular.png") throw new Error("Nombre de descarga incorrecto para 1.1");

await page.getByTestId("next-frame").click();
if (await page.getByTestId("wireframe-current").getAttribute("data-frame-id") !== "1.2") throw new Error("La navegación siguiente no avanzó a 1.2");
await page.getByTestId("mode-cobertura").click();
if (await page.getByTestId("wireframe-current").getAttribute("data-frame-id") !== "01") throw new Error("El selector Cobertura no abrió el estado 01");

const manifest = JSON.parse(readFileSync(path.resolve("public/exports/manifest.json"), "utf8"));
if (manifest.length !== 44) throw new Error(`Se esperaban 44 exportaciones y se encontraron ${manifest.length}`);
for (const item of manifest) {
  const filePath = path.resolve("public/exports", item.file);
  if (!existsSync(filePath)) throw new Error(`Falta ${item.file}`);
  const png = readFileSync(filePath);
  const width = png.readUInt32BE(16);
  const height = png.readUInt32BE(20);
  if (width !== 1840 || height !== 2300) throw new Error(`Dimensiones inesperadas en ${item.file}: ${width} × ${height}`);
}

const css = readFileSync(path.resolve("src/prototype.css"), "utf8");
for (const forbidden of ["box-shadow", "linear-gradient", "radial-gradient", "#d71921"]) {
  if (css.toLowerCase().includes(forbidden)) throw new Error(`El CSS contiene un recurso impropio de wireframe: ${forbidden}`);
}

const overflow = await page.getByTestId("wireframe-current").evaluate((node) => node.scrollWidth > node.clientWidth + 1);
if (overflow) throw new Error("Existe desborde horizontal en el tablero");
if (errors.length) throw new Error(`Errores de consola: ${errors.join(" | ")}`);

console.log(JSON.stringify({ language: "es", canvas: `${box.width}x${box.height}`, png: "1840x2300", phoneSimulation: false, colorIdentity: false, navigation: "passed", exports: manifest.length, overflow: false, consoleErrors: 0 }));
await browser.close();
