// Láminas de exploración del logotipo 3.1: dónde va el renglón y los ajustes de peso, espaciado y distancia.
const fs = require('fs');
const path = require('path');
const { Font, textPath } = require('./ttf.js');
const font = new Font(path.join(__dirname, 'schibsted.ttf'));
const OUT = path.join(__dirname, 'out', 'Logotipo');
const INK = '#17181C', BLUE = '#3D38F5', GRAPHITE = '#5B5F68', LINE = '#D5D6D8';
const f1 = (v) => +v.toFixed(1);
const KERN = { el: -40, le: -10, vo: -8 };

function bounds(d) {
  const n = d.match(/-?[\d.]+/g).map(Number);
  let x0 = Infinity, x1 = -Infinity;
  for (let i = 0; i < n.length; i += 2) { x0 = Math.min(x0, n[i]); x1 = Math.max(x1, n[i]); }
  return { x0, x1 };
}
// Palabra en unidades de la fuente con el asta de la «r» en x = 0.
function word(weight, tracking, kern = KERN) {
  const t = textPath(font, 'relevo', { size: 2048, weight, tracking, kern });
  const b = bounds(t.d);
  const t2 = textPath(font, 'relevo', { size: 2048, weight, tracking, kern, x: -b.x0 });
  return { d: t2.d, right: bounds(t2.d).x1 };
}
const label = (s, x, y, size, fill = GRAPHITE, weight = 500) => `<path fill="${fill}" d="${textPath(font, s, { size, weight, x, y }).d}"/>`;
// Una celda: palabra a escala k dentro de un marco de 560 × 230, con su nota debajo.
function cell(x, y, w, body, title, note, chosen) {
  let s = `<g transform="translate(${x} ${y})"><rect width="${w}" height="300" rx="22" fill="#FFFFFF"${chosen ? ` stroke="${BLUE}" stroke-width="3"` : ''}/>`;
  s += `<g transform="translate(40 150) scale(0.068)">${body}</g>`;
  s += label(title, 40, 238, 19, chosen ? BLUE : INK, 650);
  s += label(note, 40, 268, 16, GRAPHITE, 400);
  return s + '</g>';
}
// ---------- Renglón: seis posiciones ----------
{
  const W6 = word(600, -0.022), W65 = word(650, -0.03, {});
  const xh = 1080, bar = 160;
  const cap = (x, y, w, h = bar, fill = BLUE) => `<rect x="${f1(x)}" y="${y}" width="${f1(w)}" height="${h}" rx="${h / 2}" fill="${fill}"/>`;
  // La «o» es la última letra: su caja va de oX0 a W.right.
  const oBox = (Wd) => { const t = textPath(font, 'o', { size: 2048, weight: 600 }); const b = bounds(t.d); return { w: b.x1 - b.x0 }; };
  const ow = oBox(W6).w, ox = W6.right - ow, ocx = ox + ow / 2, ocy = -540;
  let dots = '';
  for (let yy = -900; yy <= -180; yy += 120) for (let xx = ox + 130; xx <= W6.right - 130; xx += 120) if (((xx - ocx) / (ow / 2 - 150)) ** 2 + ((yy - ocy) / 370) ** 2 <= 1) dots += `<circle cx="${f1(xx)}" cy="${yy}" r="40"/>`;
  const v = [
    ['3.0', 'Rectángulo del ancho de la palabra: un subrayado cualquiera.', `<rect x="0" y="483" width="${f1(W65.right)}" height="154" fill="${BLUE}"/><path fill="${INK}" d="${W65.d}"/>`],
    ['A · Sobre la línea base', 'Toca las letras: en tamaños chicos se funden con ellas.', `${cap(0, -40, W6.right + xh)}<path fill="${INK}" d="${W6.d}"/>`],
    ['B · Bajo la palabra y hace lugar (elegida)', 'Cápsula del grosor de la «e»; pasa la «o» en una altura de x.', `${cap(0, 180, W6.right + xh)}<path fill="${INK}" d="${W6.d}"/>`, true],
    ['C · Del ancho de la palabra', 'Correcta, pero cerrada: no deja lugar después de la «o».', `${cap(0, 180, W6.right)}<path fill="${INK}" d="${W6.d}"/>`],
    ['D · La «o» como parlante', 'Pone el objeto en el centro, lo que D-072 dejó atrás.', `<path fill="${INK}" d="${W6.d}"/><g fill="${BLUE}">${dots}</g>${cap(0, 180, W6.right)}`],
    ['E · La «o» llena', 'Se lee como un punto o como el botón de grabar.', `<path fill="${INK}" d="${W6.d}"/><ellipse cx="${f1(ocx)}" cy="${ocy}" rx="${f1(ow / 2)}" ry="566" fill="${INK}"/>${cap(0, 180, W6.right)}`],
  ];
  let body = `<rect width="1240" height="1100" fill="#F2F2EF"/>`;
  body += label('Dónde va el renglón', 40, 70, 34, INK, 650) + label('Seis posiciones probadas con la misma palabra. Quedó B: es la única que se lee como renglón y deja lugar.', 40, 106, 18, GRAPHITE, 400);
  v.forEach(([t, n, b, ch], i) => { body += cell(40 + (i % 2) * 600, 140 + Math.floor(i / 2) * 320, 560, b, t, n, ch); });
  fs.writeFileSync(path.join(OUT, 'exploracion-renglon.svg'), `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1240 1100" width="1240" height="1100"><title>relevo — exploración: dónde va el renglón</title>${body}</svg>\n`);
}
// ---------- Ajustes: peso, espaciado y distancia ----------
{
  const xh = 1080, bar = 160;
  const mk = (w, tr, gap, kern = KERN) => { const W = word(w, tr, kern); return `<rect x="0" y="${gap}" width="${f1(W.right + xh)}" height="${bar}" rx="${bar / 2}" fill="${BLUE}"/><path fill="${INK}" d="${W.d}"/>`; };
  const v = [
    ['Peso 560', 'Fino: elegante, pero pierde frente al renglón.', mk(560, -0.022, 180)],
    ['Peso 600 (elegido)', 'Un paso más fino que los títulos de 650: se lee como dibujo.', mk(600, -0.022, 180), true],
    ['Peso 700', 'Pesado: el renglón queda débil al lado.', mk(700, -0.022, 180)],
    ['Espaciado 0 y sin kerning', 'Los huecos de «el» y «vo» se notan.', mk(600, 0, 180, {})],
    ['Espaciado −3,5 %', 'Las letras se tocan en tamaños chicos.', mk(600, -0.035, 180)],
    ['Distancia 240', 'El renglón se separa y parece otra pieza.', mk(600, -0.022, 240)],
  ];
  let body = `<rect width="1240" height="1100" fill="#F2F2EF"/>`;
  body += label('Peso, espaciado y distancia', 40, 70, 34, INK, 650) + label('Quedó Schibsted Grotesk 600, espaciado −2,2 %, kerning el −40, le −10, vo −8 y el renglón a 180 unidades bajo la línea base.', 40, 106, 18, GRAPHITE, 400);
  v.forEach(([t, n, b, ch], i) => { body += cell(40 + (i % 2) * 600, 140 + Math.floor(i / 2) * 320, 560, b, t, n, ch); });
  fs.writeFileSync(path.join(OUT, 'exploracion-ajustes.svg'), `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1240 1100" width="1240" height="1100"><title>relevo — exploración: peso, espaciado y distancia</title>${body}</svg>\n`);
}
console.log('ok', fs.statSync(path.join(OUT, 'exploracion-renglon.svg')).size, fs.statSync(path.join(OUT, 'exploracion-ajustes.svg')).size);
