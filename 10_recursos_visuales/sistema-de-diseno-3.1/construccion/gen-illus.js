// Ilustraciones 3.1 «El lugar donde empieza»: una escena por categoría, con el testigo junto al primer paso.
// Lenguaje: el de los íconos agrandado (trazo de tinta redondeado), rellenos de la familia, sombras en trama
// y el renglón como suelo, del color de la categoría.
const fs = require('fs');
const path = require('path');
const PAL = require('./palette.json');
const OUT = path.join(__dirname, 'out', 'Ilustraciones');
fs.mkdirSync(OUT, { recursive: true });
const INK = '#17181C', BLUE = '#3D38F5', WHITE = '#FFFFFF';
const W = 640, H = 480, FLOOR = 404;
const r1 = (v) => Math.round(v * 10) / 10;

function scene(fam, title, draw) {
  const s = PAL[fam].steps;
  const C = { bg: s[50].hex, soft: s[100].hex, light: s[200].hex, mid: s[300].hex, base: s[400].hex, deep: s[600].hex, dark: s[700].hex };
  let b = `<rect width="${W}" height="${H}" fill="${C.bg}"/>`;
  b += draw(C, s);
  // El renglón: el suelo, del color de la categoría.
  b += `<rect x="40" y="${FLOOR}" width="${W - 80}" height="9" rx="4.5" fill="${C.deep}"/>`;
  return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 ${W} ${H}" width="${W}" height="${H}" fill="none" stroke-linecap="round" stroke-linejoin="round"><title>${title}</title>${b}</svg>\n`;
}
const line = (d, w = 3.2, col = INK) => `<path d="${d}" stroke="${col}" stroke-width="${w}"/>`;
const shape = (d, fill, w = 3.2) => `<path d="${d}" fill="${fill}" stroke="${INK}" stroke-width="${w}"/>`;
const rect = (x, y, w, h, rx, fill, sw = 3.2) => `<rect x="${x}" y="${y}" width="${w}" height="${h}" rx="${rx}" fill="${fill}" stroke="${INK}" stroke-width="${sw}"/>`;
const circ = (cx, cy, r, fill, sw = 3.2) => `<circle cx="${cx}" cy="${cy}" r="${r}" fill="${fill}" stroke="${INK}" stroke-width="${sw}"/>`;
// Sombra en trama: puntos en una elipse, más grandes hacia el centro.
function tramaShadow(cx, cy, rx, ry, color, pitch = 7) {
  let d = '';
  for (let y = cy - ry; y <= cy + ry; y += pitch) for (let x = cx - rx; x <= cx + rx; x += pitch) {
    const q = ((x - cx) / rx) ** 2 + ((y - cy) / ry) ** 2;
    if (q > 1) continue;
    const v = 1 - q;
    d += `<circle cx="${r1(x)}" cy="${r1(y)}" r="${r1(pitch * 0.5 * (0.2 + 0.75 * v))}"/>`;
  }
  return `<g fill="${color}">${d}</g>`;
}
// Luz en trama: puntos en un trapecio que se abren hacia abajo (lámparas).
function tramaLight(x0, x1, top, bottom, spread, color, pitch = 8) {
  let d = '';
  for (let y = top; y <= bottom; y += pitch) {
    const t = (y - top) / (bottom - top);
    const a = x0 - spread * t, b = x1 + spread * t;
    for (let x = a; x <= b; x += pitch) d += `<circle cx="${r1(x)}" cy="${r1(y)}" r="${r1(pitch * 0.5 * (0.55 - 0.45 * t))}"/>`;
  }
  return `<g fill="${color}">${d}</g>`;
}
// El testigo: un disco bajo, blanco, con su banda azul en la base y la rejilla de puntos al frente.
function testigo(x, y, scale = 1) {
  const w = 74 * scale, h = 34 * scale;
  const id = 't' + Math.round(x) + Math.round(y);
  let g = `<clipPath id="${id}"><rect x="${x - w / 2}" y="${y - h}" width="${w}" height="${h}" rx="${h / 2}"/></clipPath>`;
  g += `<rect x="${x - w / 2}" y="${y - h}" width="${w}" height="${h}" rx="${h / 2}" fill="${WHITE}"/>`;
  g += `<rect x="${x - w / 2}" y="${y - h * 0.3}" width="${w}" height="${h * 0.3}" fill="${BLUE}" clip-path="url(#${id})"/>`;
  for (let i = -2; i <= 2; i++) for (let j = 0; j < 2; j++) g += `<circle cx="${r1(x + i * 7 * scale)}" cy="${r1(y - h * 0.68 + j * 7 * scale)}" r="${r1(1.6 * scale)}" fill="${INK}"/>`;
  g += `<rect x="${x - w / 2}" y="${y - h}" width="${w}" height="${h}" rx="${h / 2}" fill="none" stroke="${INK}" stroke-width="3.2"/>`;
  return g;
}

const files = {};
// 1. Leer — mostaza: el sillón, la lámpara y el libro abierto en la mesa lateral.
files['leer-sillon.svg'] = scene('mostaza', 'Leer: el libro abierto junto al sillón, con el testigo al lado', (C) => {
  let b = tramaShadow(250, FLOOR - 4, 190, 22, C.deep, 8);
  // Lámpara de pie.
  b += tramaLight(430, 478, 140, 300, 60, C.light, 9);
  b += line(`M454 ${FLOOR}V140`) + line(`M430 ${FLOOR}H478`);
  b += shape('M418 140L436 82H472L490 140Z', C.mid);
  // Sillón.
  b += shape(`M150 320V214Q150 168 196 168H300Q346 168 346 214V320`, C.base);
  b += shape(`M112 300Q112 270 140 270Q168 270 168 300V330H328V300Q328 270 356 270Q384 270 384 300V372Q384 380 376 380H120Q112 380 112 372Z`, C.mid);
  b += line(`M140 380V${FLOOR - 4}M356 380V${FLOOR - 4}`);
  b += line('M182 330H314', 3.2);
  // Mesa lateral con el libro y el testigo.
  b += rect(500, 300, 96, 14, 7, C.base);
  b += line(`M548 314V${FLOOR - 2}`);
  b += line(`M524 ${FLOOR - 2}H572`);
  b += shape('M512 298Q530 284 548 294Q566 284 584 298L584 300H512Z', WHITE, 2.6);
  b += line('M548 294V300', 2.4);
  b += testigo(372, FLOOR - 6, 0.9);
  return b;
});
// 2. Crear con las manos — arcilla: la mesa con el cuaderno de dibujo, los lápices y las acuarelas.
files['crear-mesa.svg'] = scene('arcilla', 'Crear con las manos: el cuaderno de dibujo y las acuarelas sobre la mesa, con el testigo al lado', (C) => {
  let b = tramaShadow(320, FLOOR - 4, 250, 20, C.deep, 8);
  b += rect(60, 262, 520, 18, 9, C.base);
  b += line(`M92 280L80 ${FLOOR - 4}M548 280L560 ${FLOOR - 4}`);
  // Cuaderno abierto.
  b += shape('M150 260L170 214H300L312 260Z', WHITE);
  b += shape('M312 260L322 214H452L472 260Z', WHITE);
  b += line('M196 236Q232 222 262 240', 2.6, C.deep) + line('M206 248Q236 238 254 250', 2.2, C.mid);
  b += line('M312 260L322 214', 2.6);
  // Acuarelas.
  b += rect(372, 236, 64, 18, 5, WHITE, 2.6);
  [[384, C.deep], [398, C.mid], [412, BLUE], [426, C.dark]].forEach(([x, col]) => { b += `<circle cx="${x}" cy="245" r="4.6" fill="${col}"/>`; });
  // Lápices en un vaso.
  b += shape('M460 262V214H492V262', C.mid);
  b += line('M468 214L462 176M476 214V170M484 214L492 180', 3);
  b += testigo(536, 262, 0.8);
  return b;
});
// 3. Cuidar la casa y a mí — salvia: la ventana con plantas y la regadera.
files['cuidar-ventana.svg'] = scene('salvia', 'Cuidar las plantas: la regadera junto a las plantas de la ventana, con el testigo al lado', (C) => {
  let b = rect(150, 60, 340, 250, 14, C.soft);
  b += tramaLight(170, 470, 74, 296, 0, C.light, 12);
  b += line('M320 60V310M150 186H490');
  b += rect(150, 60, 340, 250, 14, 'none');
  b += rect(124, 310, 392, 16, 8, C.base);
  // Macetas en el alféizar.
  const pot = (x, h) => shape(`M${x - 28} ${310}L${x - 22} ${310 - h}H${x + 22}L${x + 28} ${310}Z`, C.deep) + line(`M${x} ${310 - h}V${310 - h - 34}`) + shape(`M${x} ${310 - h - 22}Q${x - 34} ${310 - h - 30} ${x - 30} ${310 - h - 56}Q${x - 4} ${310 - h - 52} ${x} ${310 - h - 22}Z`, C.mid, 2.8) + shape(`M${x} ${310 - h - 30}Q${x + 32} ${310 - h - 40} ${x + 30} ${310 - h - 66}Q${x + 4} ${310 - h - 60} ${x} ${310 - h - 30}Z`, C.base, 2.8);
  b += pot(220, 40) + pot(320, 30) + pot(420, 44);
  // Regadera en el suelo.
  b += tramaShadow(472, FLOOR - 4, 80, 10, C.deep, 7);
  b += shape(`M436 ${FLOOR - 4}V350Q436 338 448 338H492Q504 338 504 350V${FLOOR - 4}Z`, C.base);
  b += line('M504 356L552 330') + line('M546 326L560 336', 3.2);
  b += line('M448 338Q470 300 492 338', 3);
  b += testigo(360, FLOOR - 6, 0.9);
  return b;
});
// 4. Moverme — terracota: la puerta, las zapatillas y el colgador.
files['moverme-puerta.svg'] = scene('terracota', 'Salir a caminar: las zapatillas junto a la puerta, con el testigo al lado', (C) => {
  let b = tramaShadow(300, FLOOR - 4, 220, 18, C.deep, 8);
  b += shape(`M220 ${FLOOR - 4}V92Q220 72 240 72H380Q400 72 400 92V${FLOOR - 4}`, C.mid);
  b += line(`M246 ${FLOOR - 4}V100Q246 96 250 96H370Q374 96 374 100V${FLOOR - 4}`, 2.6);
  b += `<circle cx="352" cy="248" r="7" fill="${INK}"/>`;
  // Colgador con chaqueta.
  b += line('M450 120H540') + line('M470 120V136M520 120V136');
  b += shape('M460 136Q470 132 480 136L496 150L512 136Q522 132 532 136L540 236Q540 244 532 244H460Q452 244 452 236Z', C.base);
  b += line('M496 150V244', 2.6);
  // Zapatillas.
  const shoe = (x) => shape(`M${x} ${FLOOR - 4}V${FLOOR - 34}Q${x} ${FLOOR - 42} ${x + 8} ${FLOOR - 40}L${x + 22} ${FLOOR - 32}L${x + 36} ${FLOOR - 46}Q${x + 46} ${FLOOR - 30} ${x + 70} ${FLOOR - 26}Q${x + 84} ${FLOOR - 24} ${x + 84} ${FLOOR - 12}V${FLOOR - 4}Z`, WHITE) + line(`M${x} ${FLOOR - 12}H${x + 84}`, 2.6, C.deep);
  b += shoe(430) + shoe(520);
  b += testigo(150, FLOOR - 6, 0.9);
  return b;
});
// 5. Con otras personas — ciruela: la mesa con el juego de mesa y dos tazas.
files['compartir-juego.svg'] = scene('ciruela', 'Jugar un juego de mesa: la caja abierta sobre la mesa, con el testigo al lado', (C) => {
  let b = tramaShadow(320, FLOOR - 4, 240, 20, C.deep, 8);
  b += rect(90, 250, 460, 18, 9, C.base);
  b += line(`M124 268L112 ${FLOOR - 4}M516 268L528 ${FLOOR - 4}`);
  // Tablero.
  b += shape('M222 248L244 212H418L440 248Z', C.soft);
  b += line('M268 212L262 248M292 212L290 248M316 212L318 248M340 212L346 248M364 212L374 248M388 212L402 248', 2, C.mid);
  b += `<circle cx="292" cy="232" r="7" fill="${C.deep}" stroke="${INK}" stroke-width="2.4"/><circle cx="372" cy="226" r="7" fill="${BLUE}" stroke="${INK}" stroke-width="2.4"/>`;
  // Tazas.
  const cup = (x) => shape(`M${x} 248V214H${x + 40}V240Q${x + 40} 248 ${x + 32} 248Z`, WHITE, 2.8) + line(`M${x + 40} 220Q${x + 54} 220 ${x + 54} 230Q${x + 54} 238 ${x + 40} 238`, 2.8);
  b += cup(104) + cup(470);
  b += testigo(186, 248, 0.7).replace(/stroke-width="3.2"/g, 'stroke-width="2.8"');
  return b;
});
// 6. Aprender algo — pizarra: el escritorio con los apuntes, la lámpara y los libros.
files['aprender-escritorio.svg'] = scene('pizarra', 'Estudiar: los apuntes abiertos en el escritorio, con el testigo al lado', (C) => {
  let b = tramaShadow(330, FLOOR - 4, 240, 18, C.deep, 8);
  b += rect(80, 240, 510, 18, 9, C.base);
  b += line(`M114 258V${FLOOR - 4}M556 258V${FLOOR - 4}`);
  b += rect(404, 258, 126, 72, 6, C.mid);
  b += line('M450 294H484', 3);
  // Lámpara de escritorio y su luz.
  b += tramaLight(150, 196, 140, 232, 40, C.light, 8);
  b += line('M160 238L196 160L150 120', 3.4) + shape('M128 108L170 92L178 140Z', C.deep) + line('M140 238H182');
  // Libros apilados.
  b += rect(436, 214, 88, 14, 4, C.deep) + rect(442, 200, 78, 14, 4, C.light) + rect(432, 186, 84, 14, 4, C.base);
  // Cuaderno de apuntes abierto.
  b += shape('M232 238L248 206H326L330 238Z', WHITE) + shape('M330 238L334 206H412L424 238Z', WHITE);
  b += line('M262 218H312M260 226H304M346 218H398M348 226H388', 2.2, C.mid);
  b += testigo(556, 240, 0.7).replace(/stroke-width="3.2"/g, 'stroke-width="2.8"');
  return b;
});
for (const [n, s] of Object.entries(files)) fs.writeFileSync(path.join(OUT, n), s);
console.log(Object.keys(files).join(' '));
