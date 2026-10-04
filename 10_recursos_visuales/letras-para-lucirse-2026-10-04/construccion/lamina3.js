// Propuesta 3.9, «Letras para lucirse»: 23 letras hermosas en cuatro familias, cada una en su tablero.
// Escribe lamina3/letras-para-lucirse.html (para publicar) y lamina3/vista.html (copia local con charset).
const fs = require('fs');
const path = require('path');
const { LIC, URL, G } = require('./datos39.js');
const dir = __dirname;
const img = (f) => 'data:image/jpeg;base64,' + fs.readFileSync(path.join(dir, 'tableros', f)).toString('base64');
const rec = (f) => 'data:image/jpeg;base64,' + fs.readFileSync(path.join(dir, 'recortes', f)).toString('base64');
const total = G.reduce((n, g) => n + g[2].length, 0);
const esc = (s) => s.replace(/&/g, '&amp;').replace(/</g, '&lt;');
const card = ([id, nombre, estilo, autor, origen, via, slug, lindo, cuidado]) => `<figure class="card" id="l-${id}">
<img src="${img(id + '.jpg')}" alt="Tablero del logotipo relevo en ${nombre}: grande, en cinco tintas, en cuatro tamaños, como ícono y en uso">
<figcaption><h4>${nombre}</h4><p class="meta">${esc(autor)} · ${origen} · ${estilo}</p><dl><div><dt>Lo lindo</dt><dd>${esc(lindo)}</dd></div><div><dt>Cuidado</dt><dd>${esc(cuidado)}</dd></div><div><dt>Licencia</dt><dd>${LIC[via]} <a href="${URL[via](slug)}">Página de la letra</a>.</dd></div></dl></figcaption></figure>`;
const grupos = G.map(([t, d, items], i) => `<section class="fam" id="g${i + 1}"><div class="head"><p class="eyebrow">${items.length} letras</p><h2>${t}</h2><p>${d}</p></div><div class="cards">${items.map(card).join('')}</div></section>`).join('\n');
const muestrario = G.flatMap((g) => g[2]).map(([id, nombre]) => `<a class="mu" href="#l-${id}"><img src="${rec(id + '.jpg')}" alt="relevo en ${nombre}"><span>${nombre}</span></a>`).join('');
const nPP = G.flatMap((g) => g[2]).filter((x) => x[5] === 'pp').length, nFS = G.flatMap((g) => g[2]).filter((x) => x[5] === 'fs').length, nVE = G.flatMap((g) => g[2]).filter((x) => x[5] === 'ofl').length;

const html = `<title>Letras para lucirse</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Schibsted+Grotesk:wght@400..900&family=IBM+Plex+Mono:wght@400&display=swap">
<style>
/* Una columna de lectura con tableros anchos. La página es papel y tinta; el color vive en los tableros. */
:root {
  --bg: #FAFAF7; --surface: #FFFFFF; --fg: #141519; --muted: #5B5F68; --line: #E4E4DF; --accent: #1C3891;
  --f-ui: "Schibsted Grotesk", "Segoe UI", system-ui, sans-serif; --f-data: "IBM Plex Mono", ui-monospace, monospace;
}
@media (prefers-color-scheme: dark) { :root:not([data-theme="light"]) { --bg: #111215; --surface: #1B1C20; --fg: #ECEDEF; --muted: #A0A4AC; --line: #2E3036; --accent: #87A8F7; color-scheme: dark; } }
:root[data-theme="dark"] { --bg: #111215; --surface: #1B1C20; --fg: #ECEDEF; --muted: #A0A4AC; --line: #2E3036; --accent: #87A8F7; color-scheme: dark; }
* { box-sizing: border-box; }
body { margin: 0; background: var(--bg); color: var(--fg); font: 400 16px/1.55 var(--f-ui); padding-inline: 16px; -webkit-font-smoothing: antialiased; }
.wrap { max-width: 1160px; margin: 0 auto; padding-block: 28px 100px; }
figure { margin: 0; }
a { color: inherit; text-decoration-color: var(--accent); text-underline-offset: .18em; }
:focus-visible { outline: 2px solid var(--accent); outline-offset: 3px; }
.top { display: flex; justify-content: space-between; align-items: center; gap: 16px; flex-wrap: wrap; font: 600 14px/20px var(--f-ui); color: var(--muted); }
.top nav { display: flex; gap: 18px; flex-wrap: wrap; } .top nav a { text-decoration: none; } .top nav a:hover { color: var(--fg); }
.eyebrow { font: 600 13px/18px var(--f-ui); color: var(--muted); margin: 0; }
h1 { font: 800 clamp(44px, 7.2vw, 96px)/.94 var(--f-ui); letter-spacing: -.05em; margin: 12px 0 0; text-wrap: balance; }
h2 { font: 780 clamp(28px, 4vw, 46px)/1 var(--f-ui); letter-spacing: -.045em; margin: 0; text-wrap: balance; }
.lead { font-size: 19px; line-height: 1.5; color: var(--muted); max-width: 62ch; margin: 18px 0 0; }
.lead b { color: var(--fg); font-weight: 650; }
section { margin-top: 96px; scroll-margin-top: 24px; }
.head { display: grid; gap: 12px; margin-bottom: 28px; max-width: 760px; }
.head p { margin: 0; color: var(--muted); font-size: 17px; }
.facts { display: grid; grid-template-columns: repeat(auto-fit, minmax(230px, 1fr)); gap: 0 28px; list-style: none; padding: 0; margin: 36px 0 0; max-width: 1100px; }
.facts li { border-top: 1px solid var(--fg); padding: 14px 0 16px; font-size: 15px; line-height: 22px; color: var(--muted); }
.facts li b { display: block; color: var(--fg); font-size: 17px; margin-bottom: 4px; }
.tablewrap { overflow-x: auto; }
table { width: 100%; border-collapse: collapse; min-width: 700px; font-size: 15px; line-height: 22px; }
th { text-align: left; font: 600 13px/18px var(--f-ui); color: var(--muted); padding: 0 16px 10px 0; border-bottom: 1px solid var(--fg); }
td { vertical-align: top; padding: 14px 16px 14px 0; border-bottom: 1px solid var(--line); color: var(--muted); }
td:first-child { color: var(--fg); font-weight: 650; }
.cards { display: grid; grid-template-columns: repeat(2, minmax(0, 1fr)); gap: 34px 22px; }
.card { display: grid; gap: 12px; align-content: start; min-width: 0; }
.card.wide { grid-column: 1 / -1; }
.card img { width: 100%; max-width: 100%; height: auto; display: block; background: #FAFAF7; box-shadow: 0 0 0 1px var(--line); cursor: zoom-in; }
.card.wide img { cursor: zoom-out; }
.card h4 { margin: 0; font: 760 22px/1.1 var(--f-ui); letter-spacing: -.03em; }
.meta { margin: 2px 0 0; font: 400 12.5px/18px var(--f-data); color: var(--muted); }
.card dl { margin: 12px 0 0; display: grid; gap: 8px; }
.card dl div { display: grid; grid-template-columns: 82px minmax(0, 1fr); gap: 12px; font-size: 14.5px; line-height: 21px; }
.card dt { font-weight: 650; color: var(--fg); } .card dd { margin: 0; color: var(--muted); }
.mus { display: grid; grid-template-columns: repeat(auto-fill, minmax(260px, 1fr)); gap: 12px; }
.mu { display: block; text-decoration: none; background: #FAFAF7; box-shadow: 0 0 0 1px var(--line); color: #141519; }
.mu img { width: 100%; height: auto; display: block; }
.mu span { display: block; font: 600 12.5px/18px var(--f-ui); padding: 0 12px 10px; }
.mu:hover { box-shadow: 0 0 0 2px var(--accent); }
.hint { font-size: 13.5px; color: var(--muted); margin: 14px 0 0; }
.qs { margin: 0; padding-left: 22px; display: grid; gap: 10px; font-size: 18px; line-height: 26px; max-width: 780px; }
.foot { margin-top: 80px; padding-top: 18px; border-top: 1px solid var(--line); font-size: 13.5px; line-height: 20px; color: var(--muted); display: grid; gap: 8px; max-width: 900px; }
.foot p { margin: 0; }
@media (max-width: 860px) { .cards { grid-template-columns: minmax(0, 1fr); } .card dl div { grid-template-columns: 1fr; gap: 2px; } }
</style>
<div class="wrap">
  <header class="top"><span>Relevo · propuesta 3.9</span><nav aria-label="Secciones"><a href="#g1">Cursivas</a><a href="#g2">Contraste</a><a href="#g3">Cálidas</a><a href="#g4">Decorativas</a><a href="#licencias">Licencias</a><a href="#mas">Más lindas</a><a href="#decidir">Decidir</a></nav></header>
  <div>
    <p class="eyebrow" style="margin-top:48px">Propuesta 3.9 · 4 de octubre de 2026</p>
    <h1>Letras para lucirse.</h1>
    <p class="lead">Display es una letra hecha para verse linda en grande, para un logotipo. La propuesta 3.8 buscaba rarezas y pantallas; esta busca belleza. Hay <b>${total} letras en cuatro familias</b>: cursivas con vuelo, serif de contraste alto y afilado, serif cálidas y con cuerpo, y decorativas para una sola palabra. Cada una está escrita como «relevo», en el azul de Relevo y en cuatro tamaños de uso.</p>
    <ul class="facts">
      <li><b>Pangram Pangram, ${nPP}</b>Fundición independiente de las serif más usadas en identidades y revistas. Gratis para probar en portafolios y proyectos escolares.</li>
      <li><b>Fontshare, ${nFS}</b>Catálogo libre de Indian Type Foundry. Gratis también para uso comercial, con logotipos incluidos.</li>
      <li><b>Velvetyne, ${nVE}</b>Fundición francesa de letras abiertas. Ouroboros es libre, con licencia OFL.</li>
    </ul>
  </div>

  <section id="muestrario" style="margin-top:56px"><div class="mus">${muestrario}</div><p class="hint">Cada una lleva a su tablero.</p></section>

  <section id="criterio">
    <div class="head"><p class="eyebrow">Cómo se eligió</p><h2>Cuatro cosas que se miraron</h2><p>Se dejaron fuera las letras de pantalla (píxel, LED, puntos), las experimentales y las que parecen de cuaderno.</p></div>
    <ul class="facts">
      <li><b>Contraste con intención</b>Que el trazo grueso y el fino se alternen con ritmo, sin saltos.</li>
      <li><b>Gestos propios</b>La gota de la «r», el lazo de la «v», la espiral de la «o»: rasgos que se recuerdan.</li>
      <li><b>«relevo» bien resuelto</b>Escrita en minúsculas, con la «e» y la «v» bien dibujadas.</li>
      <li><b>Aguanta el azul</b>Se ve bien en tinta, en blanco sobre azul <code>#1C3891</code>, en el ícono «r» y a 16 px.</li>
    </ul>
    <p class="hint">Toca un tablero para verlo más grande.</p>
  </section>

${grupos}

  <section id="licencias">
    <div class="head"><p class="eyebrow">Licencias</p><h2>Qué se puede hacer con cada una</h2><p>Para la tesis sirven todas. Si Relevo llegara a ser un producto real, cambia lo que hay que pagar.</p></div>
    <div class="tablewrap"><table>
      <thead><tr><th>Fuente</th><th>En la tesis</th><th>Si Relevo sale a la venta</th></tr></thead>
      <tbody>
        <tr><td>Pangram Pangram (${nPP})</td><td>«Gratis para probar»: uso personal; incluye portafolios y proyectos escolares.</td><td>Hay que comprar licencias de logotipo, de aplicación y de redes sociales, desde 40 USD cada una.</td></tr>
        <tr><td>Fontshare (${nFS})</td><td>ITF Free Font License 2.0: gratis, con logotipos incluidos.</td><td>Se puede seguir usando gratis. No se puede modificar ni redistribuir el archivo de la fuente.</td></tr>
        <tr><td>Velvetyne (${nVE})</td><td>SIL Open Font License: libre.</td><td>Se puede seguir usando gratis. Una versión modificada debe conservar la licencia.</td></tr>
      </tbody>
    </table></div>
  </section>

  <section id="mas">
    <div class="head"><p class="eyebrow">Más lindas todavía</p><h2>Las que piden un correo</h2><p>Hay letras de otra liga que solo se prueban con un formulario. Las revisé y no usé ningún dato tuyo: necesito tu permiso.</p></div>
    <div class="tablewrap"><table>
      <thead><tr><th>Letra</th><th>Fundición</th><th>Cómo se prueba</th><th>Qué cambia</th></tr></thead>
      <tbody>
        <tr><td>Reckless</td><td><a href="https://displaay.net/typeface/reckless/">Displaay</a></td><td>Formulario con nombre y correo; llega un enlace con las pruebas completas de las familias elegidas.</td><td>La licencia de compra parte desde 55 €.</td></tr>
        <tr><td>GT Super y GT Alpina</td><td><a href="https://www.grillitype.com/typeface/gt-super">Grilli Type</a></td><td>Formulario con nombre y correo, aceptando la licencia de prueba.</td><td>La prueba sirve solo para maquetas.</td></tr>
        <tr><td>Domaine Display</td><td><a href="https://klim.co.nz/retail-fonts/domaine-display/">Klim</a></td><td>Formulario con correo y licencia de prueba.</td><td>Las pruebas traen pocos caracteres y ninguna función OpenType; sirven para maquetas.</td></tr>
      </tbody>
    </table></div>
    <p class="hint">Canela, Ogg, Saol Display y Recoleta también son de esa liga; no se revisó cómo se prueban.</p>
  </section>

  <section id="decidir">
    <div class="head"><p class="eyebrow">Para decidir</p><h2>Tres preguntas</h2></div>
    <ol class="qs">
      <li>¿Cuáles tres te gustan más? Con eso sigo por ese camino y descarto el resto.</li>
      <li>¿Me autorizas a usar tu nombre y tu correo para pedir las pruebas de Reckless, GT Super, GT Alpina y Domaine Display? Sirven para maquetas.</li>
      <li>¿Alguna de las cursivas te parece demasiado de letra a mano? Telma y Playground son las más cercanas.</li>
    </ol>
  </section>

  <footer class="foot">
    <p>Autorías y licencias, según la página de cada letra en Pangram Pangram, Fontshare y Velvetyne. Los tableros usan el azul de Relevo <code>#1C3891</code>; los textos de afiches y tarjeta vienen de las propuestas 3.4 y 3.5. Las letras de Pangram Pangram se probaron dentro de su página y las de Fontshare y Velvetyne, desde archivos descargados a una carpeta de trabajo fuera del repositorio; no se instaló nada.</p>
  </footer>
</div>
<script>
(function () {
  // Toca un tablero para ampliarlo a todo el ancho; vuelve a tocarlo para reducirlo.
  document.querySelectorAll('.card img').forEach(function (im) {
    im.addEventListener('click', function () { im.closest('.card').classList.toggle('wide'); });
  });
})();
</script>`;
fs.mkdirSync(path.join(dir, 'lamina3'), { recursive: true });
fs.writeFileSync(path.join(dir, 'lamina3', 'letras-para-lucirse.html'), html);
fs.writeFileSync(path.join(dir, 'lamina3', 'vista.html'), '<meta charset="utf-8">\n' + html);
console.log('ok', total, 'letras', Math.round(html.length / 1024) + ' KB');
