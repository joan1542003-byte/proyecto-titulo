// OKLCH <-> sRGB y contraste WCAG.
const hex2rgb = h => [1, 3, 5].map(i => parseInt(h.slice(i, i + 2), 16) / 255);
const rgb2hex = c => '#' + c.map(v => Math.round(Math.min(1, Math.max(0, v)) * 255).toString(16).padStart(2, '0')).join('').toUpperCase();
const lin = v => (v <= 0.04045 ? v / 12.92 : ((v + 0.055) / 1.055) ** 2.4);
const gam = v => (v <= 0.0031308 ? 12.92 * v : 1.055 * v ** (1 / 2.4) - 0.055);
function rgb2oklch(hex) {
  const [r, g, b] = hex2rgb(hex).map(lin);
  const l = Math.cbrt(0.4122214708 * r + 0.5363325363 * g + 0.0514459929 * b);
  const m = Math.cbrt(0.2119034982 * r + 0.6806995451 * g + 0.1073969566 * b);
  const s = Math.cbrt(0.0883024619 * r + 0.2817188376 * g + 0.6299787005 * b);
  const L = 0.2104542553 * l + 0.793617785 * m - 0.0040720468 * s;
  const A = 1.9779984951 * l - 2.428592205 * m + 0.4505937099 * s;
  const B = 0.0259040371 * l + 0.7827717662 * m - 0.808675766 * s;
  return [L, Math.hypot(A, B), ((Math.atan2(B, A) * 180) / Math.PI + 360) % 360];
}
function oklch2rgbRaw(L, C, H) {
  const A = C * Math.cos((H * Math.PI) / 180), B = C * Math.sin((H * Math.PI) / 180);
  const l = (L + 0.3963377774 * A + 0.2158037573 * B) ** 3;
  const m = (L - 0.1055613458 * A - 0.0638541728 * B) ** 3;
  const s = (L - 0.0894841775 * A - 1.291485548 * B) ** 3;
  return [4.0767416621 * l - 3.3077115913 * m + 0.2309699292 * s, -1.2684380046 * l + 2.6097574011 * m - 0.3413193965 * s, -0.0041960863 * l - 0.7034186147 * m + 1.707614701 * s];
}
// Reduce el croma hasta que el color quepa en sRGB.
function oklch2hex(L, C, H) {
  let c = C;
  for (let i = 0; i < 60; i++) {
    const rgb = oklch2rgbRaw(L, c, H);
    if (rgb.every(v => v >= -0.0005 && v <= 1.0005)) return rgb2hex(rgb.map(gam));
    c *= 0.95;
  }
  return rgb2hex(oklch2rgbRaw(L, 0, H).map(gam));
}
const lum = hex => { const [r, g, b] = hex2rgb(hex).map(lin); return 0.2126 * r + 0.7152 * g + 0.0722 * b; };
const contrast = (a, b) => { const x = lum(a), y = lum(b); return (Math.max(x, y) + 0.05) / (Math.min(x, y) + 0.05); };
// Baja la luminosidad (y gira el tono si se pide) hasta lograr el contraste pedido sobre el fondo.
function legible(hex, bg, target = 3, hueShift = 0) {
  const [L0, C0, H0] = rgb2oklch(hex);
  for (let L = L0; L > 0.2; L -= 0.005) {
    const t = (L0 - L) / L0;
    const out = oklch2hex(L, C0 * (1 + 0.5 * t), H0 + hueShift * Math.min(1, t * 3));
    if (contrast(out, bg) >= target) return out;
  }
  return '#141312';
}
module.exports = { rgb2oklch, oklch2hex, contrast, legible };
