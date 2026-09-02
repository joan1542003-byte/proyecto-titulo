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
if (!box || Math.abs(box.width - 412) > 1 || Math.abs(box.height - 915) > 1) throw new Error(`Lienzo exportable inesperado: ${box?.width} × ${box?.height}`);
if (await page.locator(".phone-device, .device-screen, .status-bar, .android-navigation-bar").count()) throw new Error("La presentación todavía contiene simulación de teléfono");

const download = page.getByTestId("download-frame");
if (await surface.locator('[data-testid="download-frame"]').count()) throw new Error("El botón de exportación está dentro del PNG");
if ((await download.getAttribute("download")) !== "1-1-formular.png") throw new Error("Nombre de descarga incorrecto para 1.1");

await page.getByTestId("next-frame").click();
if (await page.getByTestId("wireframe-current").getAttribute("data-frame-id") !== "1.2") throw new Error("La navegación siguiente no avanzó a 1.2");
await page.getByTestId("mode-cobertura").click();
if (await page.getByTestId("wireframe-current").getAttribute("data-frame-id") !== "01") throw new Error("El selector Cobertura no abrió el estado 01");
for (const width of [1366, 1536, 1920]) {
  await page.setViewportSize({ width, height: 1000 });
  await page.goto(`${baseUrl}/?mode=entrega&frame=1.1`, { waitUntil: "networkidle" });
  const boardOverflow = await page.evaluate(() => document.documentElement.scrollWidth > window.innerWidth + 1);
  if (boardOverflow) throw new Error(`El tablero desborda horizontalmente a ${width} px`);
}

await page.goto(`${baseUrl}/?mode=entrega&frame=3.2`, { waitUntil: "networkidle" });
if (!(await page.getByTestId("export-surface").locator(".wireframe-canvas").evaluate((node) => node.classList.contains("is-physical")))) throw new Error("3.2 no se identifica como momento físico");
if (await page.getByTestId("export-surface").locator("button").count()) throw new Error("3.2 representa respuestas físicas como botones");

const manifest = JSON.parse(readFileSync(path.resolve("public/exports/manifest.json"), "utf8"));
if (manifest.length !== 44) throw new Error(`Se esperaban 44 exportaciones y se encontraron ${manifest.length}`);
for (const item of manifest) {
  const filePath = path.resolve("public/exports", item.file);
  if (!existsSync(filePath)) throw new Error(`Falta ${item.file}`);
  const png = readFileSync(filePath);
  const width = png.readUInt32BE(16);
  const height = png.readUInt32BE(20);
  if (width !== 824 || height !== 1830) throw new Error(`Dimensiones inesperadas en ${item.file}: ${width} × ${height}`);
}

const css = readFileSync(path.resolve("src/prototype.css"), "utf8");
for (const forbidden of ["box-shadow", "linear-gradient", "radial-gradient"]) {
  if (css.toLowerCase().includes(forbidden)) throw new Error(`El CSS contiene un recurso impropio de wireframe: ${forbidden}`);
}
if ((css.match(/#d71921/gi) ?? []).length !== 1 || (css.match(/var\(--signal\)/g) ?? []).length !== 1) throw new Error("El rojo no está restringido al nodo de señal situada");

const overflow = await page.getByTestId("wireframe-current").evaluate((node) => node.scrollWidth > node.clientWidth + 1);
if (overflow) throw new Error("Existe desborde horizontal en el tablero");
if (errors.length) throw new Error(`Errores de consola: ${errors.join(" | ")}`);

console.log(JSON.stringify({ language: "es", canvas: `${box.width}x${box.height}`, png: "824x1830", phoneSimulation: false, signalColorRestricted: true, navigation: "passed", exports: manifest.length, overflow: false, consoleErrors: 0 }));
await browser.close();
