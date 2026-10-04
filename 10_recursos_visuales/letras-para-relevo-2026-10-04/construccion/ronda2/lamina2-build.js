// Propuesta 3.7 (versión 2), «Letras para relevo»: 30 letras finalistas de seis fuentes (sin Google Fonts) y las 264 que se miraron.
// Escribe lamina/letras-para-relevo.html (para publicar) y lamina/vista.html (copia local con charset).
const fs = require('fs');
const path = require('path');
const img = (f) => 'data:image/jpeg;base64,' + fs.readFileSync(path.join(__dirname, 'img', f)).toString('base64');

const LIC = {
  fs: 'ITF Free Font License 2.0: gratis para uso personal y comercial; permite crear y registrar logotipos.',
  pp: 'Gratis para probar: uso personal, portafolio y proyectos escolares. Un logotipo real requiere su licencia de pago (desde 40 USD).',
  ofl: 'SIL Open Font License: libre, también para uso comercial.',
};
// id, nombre, diseño, origen, licencia, lo bueno, cuidado
const G = [
  ['Sans con carácter', 'Una grotesca que no sea una sans simple: rasgos propios en las letras, sin perder la calma.', [
    ['gosha-sans', 'Gosha Sans', 'Mat Desjardins', 'Pangram Pangram', 'pp', 'Robusta y cercana. Su «r» de brazo recto es el rasgo que la vuelve propia.', 'La «r» puede leerse como una «Γ» en tamaños muy chicos.'],
    ['cabinet-grotesk', 'Cabinet Grotesk', 'Indian Type Foundry', 'Fontshare', 'fs', 'Líneas sueltas y terminales cortados en ángulo; amable sin ser infantil.', 'Se ve mucho en portafolios y sitios de estudios.'],
    ['pally', 'Pally', 'Indian Type Foundry (pesos de Jean-Baptiste Morizot)', 'Fontshare', 'fs', 'Sus letras son algo temblorosas a propósito, lo que le da calor y movimiento.', 'Puede sentirse infantil junto a un texto serio.'],
    ['mattone', 'Mattone', 'Nunzio Mazzaferro (2018)', 'Collletttivo', 'ofl', 'Negra y geométrica, con aire de cartel. Llena bien el ícono.', 'Es muy ancha: ocupa mucho espacio en la barra de la app.'],
    ['ronzino', 'Ronzino', 'Luigi Gorlero y Nunzio Mazzaferro (2025)', 'Collletttivo', 'ofl', 'Grotesca tranquila y liviana; la opción más callada.', 'Sola es poco memorable: el logotipo dependería del espaciado y de un gesto.'],
  ]],
  ['Blandas y cálidas', 'Remates redondos, trazos blandos y algo de mano: letras que parecen de la casa, no de la pantalla.', [
    ['chubbo', 'Chubbo', 'Rafał Buchner (2021)', 'Fontshare', 'fs', 'Egipcia (de remates rectangulares) con las puntas redondeadas: firme como un afiche, suave como un objeto.', 'Con peso bold se ve algo tosca en tamaños grandes.'],
    ['paquito', 'Paquito', 'Juanjo Lopez (2021)', 'Fontshare', 'fs', 'Slab de trazo cálido y algo irregular, como hecha con pincel.', 'Tiene aire de panadería: hay que cuidar el contexto.'],
    ['combat', 'Combat', 'Martin Desinde', 'Velvetyne', 'ofl', 'Negra, con remates acampanados que recuerdan las letras gruesas y blandas de los años setenta. La más libre en licencia.', 'Es muy pesada y muy marcada: solo sirve como logotipo.'],
    ['ouroboros', 'Ouroboros', 'Ariel Martín Pérez, con H·Alix Sanyas', 'Velvetyne', 'ofl', 'Redonda y orgánica, con una «o» en espiral. La más expresiva de la lista.', 'Cuesta leerla en chico y su carácter es muy fuerte.'],
  ]],
  ['Serif con identidad', 'Si el logotipo puede ser una serif (los titulares siguen en Schibsted Grotesk): calidez editorial con rasgos propios.', [
    ['erode', 'Erode', 'Nikhil Ranganathan (2021)', 'Fontshare', 'fs', 'Serif de remates suaves y acampanados; calmada y cercana.', 'Menos llamativa que las otras serif de la lista.'],
    ['neco', 'Neco', 'Jitka Janečková (2021)', 'Fontshare', 'fs', 'Serif gruesa de formas blandas, con presencia y buena lectura en chico.', 'Se parece a muchas serif gruesas contemporáneas.'],
    ['editorial-new', 'Editorial New', 'Mat Desjardins y Francesca Bolognini', 'Pangram Pangram', 'pp', 'Serif de alto contraste, elegante y muy reconocible.', 'Está en demasiados portafolios y revistas.'],
    ['migra', 'Migra', 'Valerio Monopoli', 'Pangram Pangram', 'pp', 'Serif afilada, con una «e» y una «r» de mucha personalidad.', 'Su tono es de moda y editorial, menos doméstico.'],
    ['eiko', 'Eiko', 'Caio Kondo', 'Pangram Pangram', 'pp', 'Serif rotunda de contraste alto; se lee con fuerza.', 'Más seria que cálida.'],
    ['pangaia', 'Pangaia', 'Samuel Salminen y Mat Desjardins', 'Pangram Pangram', 'pp', 'La «v» con lazo es un rasgo que se recuerda; el resto es sobrio.', 'El lazo se pierde en 16 px.'],
  ]],
  ['Anchas y firmes', 'Letras de mucha presencia, para un logotipo que se vea desde lejos.', [
    ['agrandir', 'Agrandir', 'Alex Slobzheninov', 'Pangram Pangram', 'pp', 'Ancha y negra, de curvas redondas y generosas.', 'Muy ancha para la barra de la app.'],
    ['frama', 'Frama', 'Samuel Salminen y Mat Desjardins', 'Pangram Pangram', 'pp', 'Negra y apretada, con las letras muy juntas; firme y de gran presencia.', 'Se acerca a la grotesca negra de cualquier marca.'],
    ['watch', 'Watch', 'Niklas Herrmann y Mat Desjardins', 'Pangram Pangram', 'pp', 'Extra ancha; la silueta más distinta de las dieciocho.', 'Es la que más ancho ocupa: casi no cabe en el ícono.'],
  ]],
];
const G2 = [
  ['Más sans con carácter', 'Seis sans de la segunda ronda, todas con licencia abierta (OFL).', [
    ['hauora-sans', 'Hauora Sans', 'Wayne Shih', 'UNCUT', 'ofl', 'Sans humanista de aperturas abiertas: amable y fácil de leer. Viene como fuente variable, de peso ajustable.', 'Es muy parecida a otras sans humanistas: tiene poco gesto propio.'],
    ['rag', 'Rag', 'Dennis Grauel', 'UNCUT', 'ofl', 'Grotesca robusta de terminales suaves y ritmo parejo; una sans con cuerpo.', 'Se parece a una grotesca negra convencional.'],
    ['tanklager', 'Tanklager', 'Ariel Martín Pérez (el autor de Ouroboros)', 'UNCUT', 'ofl', 'Grotesca ancha y firme, de terminales cortados con carácter. Variable.', 'Algo ancha para la barra de la app.'],
    ['gap-sans', 'Gap Sans', 'Antoine Sigur', 'UNCUT', 'ofl', 'Contornos algo irregulares, como recortados a mano: calidez sin ser infantil.', 'La irregularidad se pierde a 16 px.'],
    ['violet-sans', 'Violet Sans', 'Violet Office', 'UNCUT', 'ofl', 'Sans redonda y liviana, de formas tranquilas.', 'Poco memorable por sí sola.'],
    ['cooper-hewitt', 'Cooper Hewitt', 'Chester Jenkins', 'Open Foundry', 'ofl', 'La sans de la identidad del museo Cooper Hewitt: equilibrada, legible y con ocho pesos.', 'Menos carácter que las demás.'],
  ]],
  ['Más blandas y firmes', 'Sans de curvas llenas, con presencia sin agresividad.', [
    ['solitus', 'Solitus', 'J Hudson', 'UNCUT', 'ofl', 'Semiancha, de curvas llenas y terminales planos; amable.', 'Poco conocida: el espaciado habría que ajustarlo a mano.'],
    ['perun', 'Perun', 'Stefan Peev', 'UNCUT', 'ofl', 'Negra y de curvas generosas; presencia sin dureza.', 'Se parece a otras negras geométricas.'],
  ]],
  ['Más serif con identidad', 'Cuatro serif libres, con más historia que las de Pangram Pangram.', [
    ['bagnard', 'Bagnard', 'Sebastien Sanfilippo', 'Open Foundry', 'ofl', 'Inspirada en los grafitis de un prisionero anónimo de las guerras napoleónicas: trazos irregulares y remates redondos, cálida y con historia.', 'Un solo peso; la irregularidad se pierde en tamaños chicos.'],
    ['bluu-next', 'Bluu Next', 'Jean-Baptiste Morizot', 'Open Foundry', 'ofl', 'Serif afilada y precisa; solo existe en bold. Morizot también diseñó los pesos de Pally.', 'Tono formal.'],
    ['sprat', 'Sprat', 'Ethan Nakache', 'UNCUT', 'ofl', 'Serif negra de contraste alto y remates redondeados. Variable.', 'Peso y contraste altos: en chico pierde finura.'],
    ['career', 'Career', 'Antoine Gelgon', 'UNCUT', 'ofl', 'Serif de proporciones amplias y contraste moderado; calmada.', 'Parece de libro: menos gesto.'],
  ]],
];
const count = G.reduce((n, g) => n + g[2].length, 0);
const count2 = G2.reduce((n, g) => n + g[2].length, 0);
const card = ([id, nombre, dise, origen, lic, bueno, cuidado]) => `<figure class="card" id="l-${id}">
<img src="${img(id + '.jpg')}" alt="Tablero del logotipo relevo en ${nombre}: grande, en cinco tintas, en cuatro tamaños, como ícono y en uso" loading="lazy">
<figcaption><h4>${nombre}</h4><p class="meta">${dise} · ${origen}</p><dl><div><dt>Lo bueno</dt><dd>${bueno}</dd></div><div><dt>Cuidado</dt><dd>${cuidado}</dd></div><div><dt>Licencia</dt><dd>${LIC[lic]}</dd></div></dl></figcaption></figure>`;
const grupos = G.map(([t, d, items], i) => `<section class="fam" id="g${i + 1}"><div class="head"><p class="eyebrow">${i + 1} de ${G.length} · ${items.length} letras</p><h2>${t}</h2><p>${d}</p></div><div class="cards">${items.map(card).join('')}</div></section>`).join('\n');
const grupos2 = G2.map(([t, d, items]) => `<div class="sub2"><h3>${t}</h3><p class="sub2d">${d}</p><div class="cards">${items.map(card).join('')}</div></div>`).join('\n');
const hojaRng = ['1 a 40 (Pangram Pangram)', '41 a 80 (Pangram Pangram y Fontshare)', '81 a 120 (Fontshare y Velvetyne)', '121 a 160 (Velvetyne)', '161 a 176 (Collletttivo)'];
const hojas = [1, 2, 3, 4, 5].map((n) => `<figure class="sheet"><img src="${img('hoja-' + n + '.jpg')}" alt="Hoja ${n}: letras numeradas ${hojaRng[n - 1]}" loading="lazy"><figcaption>Hoja ${n}: números ${hojaRng[n - 1]}.</figcaption></figure>`).join('');
const hoja2Rng = ['177 a 216 (UNCUT)', '217 a 256 (UNCUT y Open Foundry)', '257 a 264 (Open Foundry)'];
const hojas2 = [1, 2, 3].map((n) => `<figure class="sheet"><img src="${img('hoja2-' + n + '.jpg')}" alt="Hoja ${n + 5}: letras numeradas ${hoja2Rng[n - 1]}" loading="lazy"><figcaption>Hoja ${n + 5}: números ${hoja2Rng[n - 1]}.</figcaption></figure>`).join('');
const total = count + count2;

const html = `<title>Letras para relevo</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Schibsted+Grotesk:wght@400..900&family=IBM+Plex+Mono:wght@400&display=swap">
<style>
/* Catálogo: una columna de lectura con tableros anchos. La página es papel y tinta; el color vive en los tableros. */
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
h3 { font: 700 24px/1.15 var(--f-ui); letter-spacing: -.03em; margin: 0 0 6px; }
.lead { font-size: 19px; line-height: 1.5; color: var(--muted); max-width: 60ch; margin: 18px 0 0; }
.lead b { color: var(--fg); font-weight: 650; }
section { margin-top: 96px; scroll-margin-top: 24px; }
.head { display: grid; gap: 12px; margin-bottom: 28px; max-width: 760px; }
.head p { margin: 0; color: var(--muted); font-size: 17px; }
.picks { list-style: none; padding: 0; margin: 36px 0 0; display: grid; grid-template-columns: repeat(auto-fit, minmax(240px, 1fr)); gap: 0 28px; max-width: 1100px; }
.picks li { border-top: 1px solid var(--fg); padding: 14px 0 18px; font-size: 15px; line-height: 22px; color: var(--muted); }
.picks li b { display: block; color: var(--fg); font-size: 18px; margin-bottom: 4px; }
.picks li b a { text-decoration: none; border-bottom: 2px solid var(--accent); }
.facts { display: grid; grid-template-columns: repeat(auto-fit, minmax(230px, 1fr)); gap: 0 28px; list-style: none; padding: 0; margin: 0; }
.facts li { border-top: 1px solid var(--fg); padding: 14px 0 16px; font-size: 15px; line-height: 22px; color: var(--muted); }
.facts li b { display: block; color: var(--fg); font-size: 17px; margin-bottom: 4px; }
code { font: 400 13px/1 var(--f-data); }
.tablewrap { overflow-x: auto; }
table { width: 100%; border-collapse: collapse; min-width: 760px; font-size: 15px; line-height: 22px; }
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
.hint { font-size: 13.5px; color: var(--muted); margin: -10px 0 24px; }
.ronda2 { margin-top: 110px; padding-top: 18px; border-top: 1px solid var(--fg); }
.sub2 { margin-top: 56px; } .sub2d { margin: 0 0 18px; max-width: 760px; color: var(--muted); font-size: 16px; }
details { margin-top: 14px; border-top: 1px solid var(--line); padding-top: 14px; }
details summary { cursor: pointer; font: 650 17px/24px var(--f-ui); }
.sheet { margin-top: 16px; } .sheet img { width: 100%; height: auto; display: block; box-shadow: 0 0 0 1px var(--line); background: #EDEDE8; }
.sheet figcaption { font-size: 13.5px; color: var(--muted); margin-top: 8px; }
.qs { margin: 0; padding-left: 22px; display: grid; gap: 10px; font-size: 18px; line-height: 26px; max-width: 780px; }
.foot { margin-top: 80px; padding-top: 18px; border-top: 1px solid var(--line); font-size: 13.5px; line-height: 20px; color: var(--muted); display: grid; gap: 8px; max-width: 900px; }
.foot p { margin: 0; }
@media (max-width: 860px) { .cards { grid-template-columns: minmax(0, 1fr); } .card dl div { grid-template-columns: 1fr; gap: 2px; } }
</style>
<div class="wrap">
  <header class="top"><span>Relevo · propuesta 3.7</span><nav aria-label="Secciones"><a href="#busqueda">La búsqueda</a><a href="#licencias">Licencias</a><a href="#g1">Primera ronda</a><a href="#ronda2">Segunda ronda</a><a href="#todas">Todas</a><a href="#decidir">Decidir</a></nav></header>
  <div>
    <p class="eyebrow" style="margin-top:48px">Propuesta 3.7, versión 2 · 4 de octubre de 2026</p>
    <h1>Treinta letras para relevo.</h1>
    <p class="lead">Como es un proyecto de título y todavía no sale a la venta, amplié las licencias y dejé fuera Google Fonts. Con tu permiso también <b>descargué archivos</b> de UNCUT y de los sitios de sus autores. En total miré <b>264 letras de seis fuentes</b> y elegí <b>${total} finalistas</b>: ${count} en la primera ronda y ${count2} en la segunda.</p>
    <ul class="picks">
      <li><b><a href="#l-chubbo">Chubbo</a></b>La blanda: egipcia de puntas redondas. Cálida, analógica y gratuita para uso comercial.</li>
      <li><b><a href="#l-erode">Erode</a></b>La serif calmada: remates suaves y acampanados. También gratuita para uso comercial.</li>
      <li><b><a href="#l-combat">Combat</a></b>La de más identidad y la de licencia más abierta: negra y acampanada, con OFL.</li>
      <li><b><a href="#l-gosha-sans">Gosha Sans</a></b>La sans con carácter: robusta, con una «r» propia. Solo para la tesis.</li>
      <li><b><a href="#l-bagnard">Bagnard</a></b>Nueva: la serif con historia, inspirada en los grafitis de un prisionero. Libre (OFL).</li>
      <li><b><a href="#l-hauora-sans">Hauora Sans</a></b>Nueva: la sans humanista y variable. Libre (OFL).</li>
    </ul>
  </div>

  <section id="busqueda">
    <div class="head"><p class="eyebrow">La búsqueda</p><h2>264 letras, seis fuentes</h2><p>Escribí «relevo» en cada una y descarté las que se leen como letra escrita a mano, las de efecto y las que solo tienen mayúsculas. Quedaron las que sostienen una palabra de seis letras en minúsculas, también a 16 px.</p></div>
    <ul class="facts">
      <li><b>Pangram Pangram, 60</b>Fundición independiente conocida por Neue Montreal y Editorial New. Sus letras son gratis para probar.</li>
      <li><b>Fontshare, 59</b>Catálogo de Indian Type Foundry con licencia propia, gratuita también para uso comercial.</li>
      <li><b>Velvetyne, 41</b>Fundición francesa de letras abiertas, muchas experimentales; todas con licencia OFL.</li>
      <li><b>Collletttivo, 16</b>Colectivo italiano de letras abiertas, con licencia OFL.</li>
      <li><b>UNCUT, 69</b>Catálogo de letras abiertas contemporáneas. Descargué 84 archivos (repositorios de GitHub y Codeberg, zips de UNCUT y de los propios autores) y mostré 69, sin las que también están en Google Fonts.</li>
      <li><b>Open Foundry, 19</b>Selección de letras abiertas con su propia hoja de estilo pública. Sin las que ya están en Google Fonts.</li>
    </ul>
    <p class="hint" style="margin:22px 0 0">Las de Pangram Pangram, Velvetyne y Collletttivo se probaron dentro de la página de cada fundición, que ya las carga para su probador; las de Fontshare y Open Foundry, con su hoja de estilo pública. Las de UNCUT se cargaron desde los archivos descargados, que están en una carpeta de trabajo fuera del repositorio; no se instaló nada.</p>
  </section>

  <section id="licencias">
    <div class="head"><p class="eyebrow">Licencias</p><h2>Qué se puede hacer con cada una</h2><p>Para la tesis sirven todas. Si Relevo llegara a ser un producto real, cambia lo que hay que pagar.</p></div>
    <div class="tablewrap"><table>
      <thead><tr><th>Fuente</th><th>Licencia</th><th>En la tesis</th><th>Si Relevo sale a la venta</th></tr></thead>
      <tbody>
        <tr><td>Fontshare</td><td>ITF Free Font License 2.0 (17 de agosto de 2026): gratis para uso personal y comercial, en cualquier medio.</td><td>Sin límites. Permite crear logotipos y registrarlos como marca.</td><td>Se puede seguir usando gratis. No se puede modificar ni redistribuir el archivo de la fuente.</td></tr>
        <tr><td>Velvetyne, Collletttivo, UNCUT y Open Foundry</td><td>SIL Open Font License 1.1, según la página de cada letra. UNCUT incluye unas pocas con otras licencias (GPL, por ejemplo); ninguna finalista las usa.</td><td>Sin límites.</td><td>Se puede seguir usando gratis. Una versión modificada debe conservar la licencia.</td></tr>
        <tr><td>Pangram Pangram</td><td>«Gratis para probar»: uso personal; incluye portafolios, propuestas a clientes y proyectos escolares.</td><td>Sirve: la tesis es un proyecto escolar y un portafolio.</td><td>Hay que comprar licencias: de logotipo, de aplicación y de redes sociales. Desde 40 USD cada una.</td></tr>
      </tbody>
    </table></div>
  </section>

  <p class="hint" style="margin:60px 0 -50px">Toca un tablero para verlo más grande.</p>
${grupos}

  <section id="ronda2" class="ronda2">
    <div class="head"><p class="eyebrow">Segunda ronda</p><h2>${count2} más, de UNCUT y Open Foundry</h2><p>Todas con licencia abierta (OFL), así que sirven también para un producto real. Se eligieron por caracteres distintos a los de la primera ronda: más sans humanistas, dos negras de curvas llenas y cuatro serif libres con historia.</p></div>
${grupos2}
  </section>

  <section id="todas">
    <div class="head"><p class="eyebrow">Todas</p><h2>Las 264 que se miraron</h2><p>Cada una lleva un número. Si te gusta alguna que no esté entre las treinta, dime su número y armo su tablero.</p></div>
    <details><summary>Ver las ocho hojas</summary>${hojas}${hojas2}</details>
  </section>

  <section id="decidir">
    <div class="head"><p class="eyebrow">Para decidir</p><h2>Tres preguntas</h2></div>
    <ol class="qs">
      <li>¿Cuáles tres o cuatro de las treinta te gustan más? Con eso afino el espaciado y las pruebo en la app.</li>
      <li>¿La letra del logotipo se usa también en titulares grandes de campaña, o solo en el logotipo?</li>
      <li>¿Quieres que siga con otras fuentes? Quedan más letras de UNCUT en sitios de autores sin descarga directa y las pruebas gratuitas de fundiciones comerciales, que piden un correo para descargar.</li>
    </ol>
  </section>

  <footer class="foot">
    <p>Fuentes: <a href="https://www.fontshare.com/licenses/itf-ffl">licencia de Fontshare (ITF FFL 2.0)</a>, <a href="https://pangrampangram.com/pages/faq#free-fonts-and-personal-use">preguntas frecuentes de Pangram Pangram</a>, <a href="https://velvetyne.fr/fonts/">Velvetyne</a>, <a href="https://www.collletttivo.it/typefaces">Collletttivo</a>, <a href="https://uncut.wtf/">UNCUT</a> y <a href="https://open-foundry.com/">Open Foundry</a>. Autoría y fechas, según la página de cada letra.</p>
    <p>Los tableros usan el azul de Relevo <code>#1C3891</code> y la familia de colores de la propuesta 3.6. Los textos de los afiches y la tarjeta vienen de las propuestas 3.4 y 3.5.</p>
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
fs.writeFileSync(path.join(__dirname, 'letras-para-relevo.html'), html);
fs.writeFileSync(path.join(__dirname, 'vista.html'), '<meta charset="utf-8">\n' + html);
console.log('ok', total, 'finalistas', Math.round(html.length / 1024) + ' KB');
