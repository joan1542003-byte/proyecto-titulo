// Mide el tamaño óptico de los íconos de Relevo con la prueba del desenfoque (D-187).
//
// Uso, desde la raíz del repositorio (necesita Node y Playwright con Chromium):
//
//     node 10_recursos_visuales/iconos-lucide/medir_tamano_optico.js
//
// Cada ícono se dibuja a 480 px con trazo de 2, se desenfoca 2 unidades de la retícula y se mide la «mancha»:
// cuántas unidades cuadradas quedan con al menos un 12 % de tinta. Es la prueba que pide Lucide para igualar
// el peso visual: un ícono se ve del tamaño correcto cuando su mancha se parece a la de sus vecinos, aunque sus
// medidas no coincidan. El resultado compara cada ícono adaptado o propio con los de Lucide que usa la app.
const fs = require('fs');
const path = require('path');
const { chromium } = require('playwright');

const AQUI = __dirname;
const mapeo = JSON.parse(fs.readFileSync(path.join(AQUI, 'mapeo.json'), 'utf8')).iconos;

function interior(archivo) {
  const texto = fs.readFileSync(path.join(AQUI, archivo), 'utf8');
  return texto.match(/<svg[^>]*>([\s\S]*)<\/svg>/)[1].replace(/currentColor/g, '#000');
}

(async () => {
  const navegador = await chromium.launch();
  const pagina = await navegador.newPage({ viewport: { width: 600, height: 600 } });
  await pagina.setContent('<canvas id="c" width="480" height="480"></canvas>');
  const medidas = {};
  for (const [nombre, entrada] of Object.entries(mapeo)) {
    const relleno = entrada.relleno ? '#000' : 'none';
    const svg = `<svg xmlns="http://www.w3.org/2000/svg" width="480" height="480" viewBox="0 0 24 24" fill="${relleno}" stroke="#000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">${interior(entrada.archivo)}</svg>`;
    medidas[nombre] = await pagina.evaluate(async (svg) => {
      const imagen = new Image();
      imagen.src = 'data:image/svg+xml;base64,' + btoa(unescape(encodeURIComponent(svg)));
      await imagen.decode();
      const c = document.getElementById('c').getContext('2d', { willReadFrequently: true });
      c.filter = 'none';
      c.fillStyle = '#fff';
      c.fillRect(0, 0, 480, 480);
      c.filter = 'blur(40px)';
      c.drawImage(imagen, 0, 0);
      c.filter = 'none';
      const datos = c.getImageData(0, 0, 480, 480).data;
      let mancha = 0;
      for (let i = 0; i < 480 * 480; i++) if (1 - datos[i * 4] / 255 > 0.12) mancha++;
      return mancha / 400; // 20 px por unidad
    }, svg);
  }
  await navegador.close();

  const lucide = Object.keys(mapeo).filter((n) => mapeo[n].categoria === 'lucide').map((n) => medidas[n]).sort((a, b) => a - b);
  const percentil = (valor) => Math.round((lucide.filter((v) => v < valor).length / lucide.length) * 100);
  const mediana = lucide[Math.floor(lucide.length / 2)];
  console.log(`Íconos de Lucide de la app: ${lucide.length}. Mancha mediana ${mediana.toFixed(0)}; mitad central, de ${lucide[Math.floor(lucide.length / 4)].toFixed(0)} a ${lucide[Math.floor((3 * lucide.length) / 4)].toFixed(0)}.`);
  for (const [nombre, entrada] of Object.entries(mapeo)) {
    if (entrada.categoria === 'lucide') continue;
    console.log(`${nombre.padEnd(12)} ${entrada.categoria.padEnd(9)} mancha ${medidas[nombre].toFixed(0).padStart(4)}  percentil ${String(percentil(medidas[nombre])).padStart(3)}`);
  }
})();
