// Lámina de construcción de los íconos, con el método de Lucide (D-187): la Figura H7 del Anexo H, rehecha.
//
// Uso, desde la raíz del repositorio (necesita Node y Playwright con Chromium):
//
//     node 10_recursos_visuales/iconos-lucide/construccion/construir_lamina.js
//
// Sigue la composición de la Figura H7 del Pase, en Arial y negro sobre blanco: 1, la retícula; 2, la geometría;
// 3, el trazo y el aire; 4, el peso y el centro, y 5, los tamaños ópticos. Arriba va Suena, un concepto propio
// de Relevo, adaptado de Lucide; abajo, Meditar, una actividad que Lucide no tiene. Lee los dos íconos de
// `propios/`, mide en Chromium su mancha al desenfocar —la prueba de Lucide— y el corrimiento que les da la
// app para centrarlos (D-156), y escribe `construccion-suena-y-meditar.svg` y `.png` en esta carpeta.
const fs = require('fs');
const path = require('path');
const { chromium } = require('playwright');

const AQUI = __dirname;
const PROPIOS = path.join(AQUI, '..', 'propios');
const LETRA = "Arial, 'Liberation Sans', Helvetica, sans-serif";

function elementos(archivo) {
  const texto = fs.readFileSync(path.join(PROPIOS, archivo), 'utf8');
  return texto.match(/<(path|circle|rect|line)\s[^>]*\/>/g);
}
const SUENA = elementos('suena.svg');
const MEDITAR = elementos('meditar.svg');
const CIRCULO = ['<circle cx="12" cy="12" r="10"/>']; // «circle» de Lucide
const CUADRADO = ['<rect width="18" height="18" x="3" y="3" rx="2"/>']; // «square» de Lucide

// Trazo del ícono según su tamaño en pantalla, como opticalStroke() de la app.
const TAMANOS = [[16, 2.0], [20, 1.8], [24, 1.6], [32, 1.4], [48, 1.3]];

const decimal = (n, d = 0) => n.toFixed(d).replace('.', ',');

/** Mancha al desenfocar (la prueba de Lucide) y corrimiento de la app para centrar (D-156), medidos en Chromium. */
async function medir(pagina, nombre, piezas) {
  return pagina.evaluate(async ({ piezas }) => {
    const ns = 'http://www.w3.org/2000/svg';
    const svg = document.createElementNS(ns, 'svg');
    svg.setAttribute('viewBox', '0 0 24 24');
    svg.innerHTML = piezas.join('');
    document.body.appendChild(svg);
    // Centro óptico, como opticalShift() de la app: centrar por la caja del dibujo y sumar un cuarto de la
    // distancia al centro de la tinta, con un tope de 0,6.
    let izq = Infinity, arr = Infinity, der = -Infinity, aba = -Infinity, sx = 0, sy = 0, peso = 0;
    for (const el of svg.children) {
      const caja = el.getBBox();
      izq = Math.min(izq, caja.x); arr = Math.min(arr, caja.y);
      der = Math.max(der, caja.x + caja.width); aba = Math.max(aba, caja.y + caja.height);
      const largo = el.getTotalLength();
      for (let d = 0; d < largo; d += 0.25) {
        const tramo = Math.min(0.25, largo - d);
        const p = el.getPointAtLength(d + tramo / 2);
        sx += p.x * tramo; sy += p.y * tramo; peso += tramo;
      }
    }
    const cajaX = (izq + der) / 2 - 12, cajaY = (arr + aba) / 2 - 12;
    const tintaX = sx / peso - 12, tintaY = sy / peso - 12;
    const tope = (v) => Math.max(-0.6, Math.min(0.6, v));
    const corrimiento = [-(cajaX + tope((tintaX - cajaX) * 0.25)), -(cajaY + tope((tintaY - cajaY) * 0.25))];
    svg.remove();
    // Mancha: el ícono a 480 px con trazo de 2, desenfocado 2 unidades; unidades cuadradas con 12 % de tinta o más.
    const grande = `<svg xmlns="${ns}" width="480" height="480" viewBox="0 0 24 24" fill="none" stroke="#000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">${piezas.join('')}</svg>`;
    const imagen = new Image();
    imagen.src = 'data:image/svg+xml;base64,' + btoa(unescape(encodeURIComponent(grande)));
    await imagen.decode();
    const lienzo = document.createElement('canvas');
    lienzo.width = 480; lienzo.height = 480;
    const c = lienzo.getContext('2d', { willReadFrequently: true });
    c.fillStyle = '#fff'; c.fillRect(0, 0, 480, 480);
    c.filter = 'blur(40px)'; c.drawImage(imagen, 0, 0); c.filter = 'none';
    const datos = c.getImageData(0, 0, 480, 480).data;
    let mancha = 0;
    for (let i = 0; i < 480 * 480; i++) if (1 - datos[i * 4] / 255 > 0.12) mancha++;
    return { mancha: mancha / 400, corrimiento };
  }, { piezas });
}

// ——— Dibujo ———
const ANCHO = 1760, ALTO = 1100;
const GRIS = '#9a9a9a', RETICULA = '#dedede';
let clips = 0;

/** Un panel de 24 × 24 en (x, y) de [lado] px, con su retícula, su borde y el contenido en unidades. */
function panel(x, y, lado, contenido, conReticula = true) {
  const s = lado / 24;
  const id = `c${clips++}`;
  const lineas = [];
  if (conReticula) for (let i = 1; i < 24; i++) lineas.push(`<line x1="${i}" y1="0" x2="${i}" y2="24"/><line x1="0" y1="${i}" x2="24" y2="${i}"/>`);
  return `<g transform="translate(${x} ${y}) scale(${s})">
    <clipPath id="${id}"><rect width="24" height="24"/></clipPath>
    <g stroke="${RETICULA}" stroke-width="${0.8 / s}">${lineas.join('')}</g>
    <g clip-path="url(#${id})">${contenido(s)}</g>
    <rect width="24" height="24" fill="none" stroke="#000" stroke-width="${1.1 / s}"/>
  </g>`;
}
const fino = (s, color = '#000', px = 1.5) => `fill="none" stroke="${color}" stroke-width="${px / s}" stroke-linecap="round" stroke-linejoin="round"`;
const guia = (s) => `fill="none" stroke="${GRIS}" stroke-width="${1 / s}" stroke-dasharray="${5 / s} ${4 / s}"`;
const punto = (s, x, y) => `<circle cx="${x}" cy="${y}" r="${2.6 / s}" fill="#000"/>`;
const texto = (x, y, t, tam = 18, ancla = 'start') => `<text x="${x}" y="${y}" font-family="${LETRA}" font-size="${tam}" text-anchor="${ancla}" fill="#000">${t}</text>`;
const conEstilo = (piezas, atributos) => piezas.map((p) => p.replace(/\/>$/, ` ${atributos}/>`)).join('');

/** Paso 2: las piezas que vienen de Lucide y sus guías. */
function geometriaSuena(s) {
  const rayos = [-45, 45].map((a) => {
    const r = (a * Math.PI) / 180;
    return `<line x1="7.5" y1="12" x2="${7.5 + 24 * Math.cos(r)}" y2="${12 + 24 * Math.sin(r)}" ${guia(s)}/>`;
  }).join('');
  return `<line x1="0" y1="12" x2="24" y2="12" ${guia(s)}/>${rayos}
    <circle cx="7.5" cy="12" r="9.5" ${guia(s)}/><circle cx="7.5" cy="12" r="13.5" ${guia(s)}/>
    ${conEstilo(SUENA.filter((p) => !p.includes('h.01')), fino(s))}${punto(s, 7.5, 12)}`;
}
function geometriaMeditar(s) {
  const centros = [[6.343, 9, 9], [17.657, 9, 9], [9.966, 9.302, 7], [5.034, 16.698, 7]];
  return `<line x1="12" y1="0" x2="12" y2="24" ${guia(s)}/>
    ${centros.map(([x, y, r]) => `<circle cx="${x}" cy="${y}" r="${r}" ${guia(s)}/>${punto(s, x, y)}`).join('')}
    ${conEstilo(MEDITAR, fino(s))}`;
}

/** Paso 3: el trazo de 2, centrado y redondo, con su eje en blanco. */
function trazo(piezas, extremos, s) {
  return conEstilo(piezas, 'fill="none" stroke="#000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"') +
    conEstilo(piezas.filter((p) => !p.includes('h.01')), fino(s, '#fff', 0.9)) +
    extremos.map(([x, y]) => `<circle cx="${x}" cy="${y}" r="1.15" ${fino(s, '#000', 1)}/>`).join('');
}
/** Una cota: una línea con sus dos topes, en unidades. */
function cota(s, x1, y1, x2, y2) {
  const vertical = x1 === x2;
  const tope = 0.45;
  const topes = vertical
    ? `<line x1="${x1 - tope}" y1="${y1}" x2="${x1 + tope}" y2="${y1}"/><line x1="${x2 - tope}" y1="${y2}" x2="${x2 + tope}" y2="${y2}"/>`
    : `<line x1="${x1}" y1="${y1 - tope}" x2="${x1}" y2="${y1 + tope}"/><line x1="${x2}" y1="${y2 - tope}" x2="${x2}" y2="${y2 + tope}"/>`;
  return `<g stroke="#000" stroke-width="${1 / s}"><line x1="${x1}" y1="${y1}" x2="${x2}" y2="${y2}"/>${topes}</g>`;
}

/** Paso 4: la mancha al desenfocar, el dibujo ya centrado y el centro del lienzo. */
function peso(piezas, corrimiento, s) {
  return `<g filter="url(#desenfoque)">${conEstilo(piezas, 'fill="none" stroke="#b8b8b8" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"')}</g>
    <g transform="translate(${corrimiento[0]} ${corrimiento[1]})">${conEstilo(piezas, fino(s))}</g>
    <g stroke="#000" stroke-width="${1 / s}"><line x1="11" y1="12" x2="13" y2="12"/><line x1="12" y1="11" x2="12" y2="13"/></g>`;
}

function lamina(medidas) {
  const p = [];
  // 1. Retícula de Lucide: 24, con 1 de margen, y su círculo y su cuadrado.
  const X1 = 34, Y1 = 68, L1 = 622, s1 = L1 / 24;
  p.push(texto(34, 24, '1', 22));
  const dimension = (y, desde, hasta, rotulo) => {
    const medio = (desde + hasta) / 2;
    return `<g stroke="#000" stroke-width="1.1"><line x1="${desde}" y1="${y}" x2="${medio - 20}" y2="${y}"/><line x1="${medio + 20}" y1="${y}" x2="${hasta}" y2="${y}"/>
      <line x1="${desde}" y1="${y - 6}" x2="${desde}" y2="${y + 6}"/><line x1="${hasta}" y1="${y - 6}" x2="${hasta}" y2="${y + 6}"/></g>${texto(medio, y + 7, rotulo, 20, 'middle')}`;
  };
  p.push(dimension(50, X1, X1 + L1, '24'));
  p.push(panel(X1, Y1, L1, (s) => `
    <rect x="1" y="1" width="22" height="22" fill="none" stroke="#000" stroke-width="${1.2 / s}" stroke-dasharray="${6 / s} ${5 / s}"/>
    ${conEstilo(CIRCULO, fino(s, GRIS, 1.6))}${conEstilo(CUADRADO, fino(s, GRIS, 1.6))}`));
  // El área viva, 22, se acota abajo, con líneas de referencia desde las esquinas del margen.
  const abajo = Y1 + L1 + 24;
  p.push(`<g stroke="#000" stroke-width="0.8"><line x1="${X1 + s1}" y1="${Y1 + L1 - s1 + 4}" x2="${X1 + s1}" y2="${abajo + 6}"/><line x1="${X1 + L1 - s1}" y1="${Y1 + L1 - s1 + 4}" x2="${X1 + L1 - s1}" y2="${abajo + 6}"/></g>`);
  p.push(dimension(abajo, X1 + s1, X1 + L1 - s1, '22'));

  // 2 a 4, Suena arriba y Meditar abajo.
  const COLUMNAS = [740, 1092, 1444], FILAS = [68, 418], L = 272, s = L / 24;
  ['2', '3', '4'].forEach((n, i) => p.push(texto(COLUMNAS[i], 24, n, 22)));
  const u = (columna, fila, x, y) => [COLUMNAS[columna] + x * s, FILAS[fila] + y * s];

  p.push(panel(COLUMNAS[0], FILAS[0], L, geometriaSuena));
  p.push(panel(COLUMNAS[0], FILAS[1], L, geometriaMeditar));

  p.push(panel(COLUMNAS[1], FILAS[0], L, (s) => trazo(SUENA, [[14.218, 5.282], [14.218, 18.718], [17.046, 2.454], [17.046, 21.546]], s) +
    cota(s, 14, 12, 16, 12)));
  {
    const [lx, ly] = u(1, 0, 1.2, 3.6);
    const [ax, ay] = u(1, 0, 3.61 - 0.75, 8.11 - 0.75);
    p.push(texto(lx, ly, '2', 18) + `<line x1="${lx + 6}" y1="${ly + 4}" x2="${ax}" y2="${ay}" stroke="#000" stroke-width="1"/>`);
    const [gx, gy] = u(1, 0, 15, 10.9);
    p.push(texto(gx, gy, '2', 15, 'middle'));
  }
  p.push(panel(COLUMNAS[1], FILAS[1], L, (s) => trazo(MEDITAR, [[5, 21], [19, 21]], s) + cota(s, 12, 17, 12, 20) + cota(s, 12, 0, 12, 1)));
  {
    const [tx, ty] = u(1, 1, 12.7, 19.1);
    p.push(texto(tx, ty, '3', 15));
    const [mx, my] = u(1, 1, 12.7, 1.15);
    p.push(texto(mx, my + 4, '1', 15));
  }

  p.push(panel(COLUMNAS[2], FILAS[0], L, (s) => peso(SUENA, medidas.suena.corrimiento, s)));
  p.push(panel(COLUMNAS[2], FILAS[1], L, (s) => peso(MEDITAR, medidas.meditar.corrimiento, s)));
  {
    const [ax, ay] = u(2, 0, 0.8, 2.2);
    p.push(texto(ax, ay, decimal(medidas.suena.mancha), 17));
    const [bx, by] = u(2, 1, 0.8, 2.2);
    p.push(texto(bx, by, decimal(medidas.meditar.mancha), 17));
  }

  // 5. Tamaños ópticos: el trazo de la app según el tamaño.
  p.push(texto(34, 806, '5', 22));
  const ESCALA = 3.2, BASE = 1012, ESPACIO = 143;
  let x = 34;
  for (const [tam, grosor] of TAMANOS) {
    const w = tam * ESCALA;
    const icono = (piezas, x0, corr) => `<svg x="${x0}" y="${BASE - w}" width="${w}" height="${w}" viewBox="0 0 24 24" overflow="visible">
      <g transform="translate(${corr[0]} ${corr[1]})">${conEstilo(piezas, `fill="none" stroke="#000" stroke-width="${grosor}" stroke-linecap="round" stroke-linejoin="round"`)}</g></svg>`;
    p.push(icono(SUENA, x, medidas.suena.corrimiento) + icono(MEDITAR, x + w * 1.5, medidas.meditar.corrimiento));
    p.push(texto(x + w * 1.25, BASE + 44, `${tam} · ${decimal(grosor, 1)}`, 20, 'middle'));
    x += w * 2.5 + ESPACIO;
  }
  return `<svg xmlns="http://www.w3.org/2000/svg" width="${ANCHO}" height="${ALTO}" viewBox="0 0 ${ANCHO} ${ALTO}">
  <defs><filter id="desenfoque" x="-50%" y="-50%" width="200%" height="200%"><feGaussianBlur stdDeviation="1.4"/></filter></defs>
  <rect width="${ANCHO}" height="${ALTO}" fill="#fff"/>
  ${p.join('\n  ')}
</svg>\n`;
}

(async () => {
  const navegador = await chromium.launch();
  const pagina = await navegador.newPage({ viewport: { width: ANCHO, height: ALTO }, deviceScaleFactor: 2 });
  await pagina.setContent('<!doctype html><body style="margin:0"></body>');
  const medidas = {
    suena: await medir(pagina, 'Suena', SUENA),
    meditar: await medir(pagina, 'Meditar', MEDITAR),
    circulo: await medir(pagina, 'circle', CIRCULO),
    cuadrado: await medir(pagina, 'square', CUADRADO),
  };
  const svg = lamina(medidas);
  fs.writeFileSync(path.join(AQUI, 'construccion-suena-y-meditar.svg'), svg);
  await pagina.setContent(`<!doctype html><body style="margin:0">${svg}</body>`);
  await pagina.locator('svg').first().screenshot({ path: path.join(AQUI, 'construccion-suena-y-meditar.png') });
  await navegador.close();
  for (const [nombre, m] of Object.entries(medidas)) {
    console.log(`${nombre.padEnd(9)} mancha ${m.mancha.toFixed(0).padStart(4)}  corrimiento de la app ${m.corrimiento.map((v) => v.toFixed(2)).join(', ')}`);
  }
})();
