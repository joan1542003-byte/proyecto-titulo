// Propuesta 3.6, «Letra con identidad»: el azul arreglado y el logotipo con una letra gratuita con carácter.
// Escribe lamina/letra-con-identidad.html (para publicar) y lamina/vista.html (copia local con charset).
const fs = require('fs');
const path = require('path');
const img = (f) => 'data:image/jpeg;base64,' + fs.readFileSync(path.join(__dirname, 'img', f)).toString('base64');
const fig = (f, alt, cap) => `<figure class="fig"><img src="${img(f)}" alt="${alt}" loading="lazy">${cap ? `<figcaption>${cap}</figcaption>` : ''}</figure>`;
const html = `<title>Letra con identidad</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Schibsted+Grotesk:wght@400..900&family=IBM+Plex+Mono:wght@400&display=swap">
<style>
/* Una columna de lectura con figuras anchas: la página es papel y tinta; el color vive en las figuras. */
:root {
  --bg: #FAFAF7; --surface: #FFFFFF; --fg: #141519; --muted: #5B5F68; --line: #E4E4DF; --accent: #1C3891;
  --f-ui: "Schibsted Grotesk", "Segoe UI", system-ui, sans-serif; --f-data: "IBM Plex Mono", ui-monospace, monospace;
}
@media (prefers-color-scheme: dark) { :root:not([data-theme="light"]) { --bg: #111215; --surface: #1B1C20; --fg: #ECEDEF; --muted: #A0A4AC; --line: #2E3036; --accent: #87A8F7; color-scheme: dark; } }
:root[data-theme="dark"] { --bg: #111215; --surface: #1B1C20; --fg: #ECEDEF; --muted: #A0A4AC; --line: #2E3036; --accent: #87A8F7; color-scheme: dark; }
* { box-sizing: border-box; }
body { margin: 0; background: var(--bg); color: var(--fg); font: 400 16px/1.55 var(--f-ui); padding-inline: 16px; -webkit-font-smoothing: antialiased; }
.wrap { max-width: 1160px; margin: 0 auto; padding-block: 28px 100px; }
a { color: inherit; text-decoration-color: var(--accent); text-underline-offset: .18em; }
:focus-visible { outline: 2px solid var(--accent); outline-offset: 3px; }
.top { display: flex; justify-content: space-between; align-items: center; gap: 16px; flex-wrap: wrap; font: 600 14px/20px var(--f-ui); color: var(--muted); }
.top nav { display: flex; gap: 18px; flex-wrap: wrap; } .top nav a { text-decoration: none; } .top nav a:hover { color: var(--fg); }
.eyebrow { font: 600 13px/18px var(--f-ui); color: var(--muted); margin: 0; }
h1 { font: 800 clamp(44px, 7.2vw, 96px)/.94 var(--f-ui); letter-spacing: -.05em; margin: 12px 0 0; text-wrap: balance; }
h2 { font: 780 clamp(28px, 4vw, 48px)/1 var(--f-ui); letter-spacing: -.045em; margin: 0; text-wrap: balance; }
.lead { font-size: 19px; line-height: 1.5; color: var(--muted); max-width: 58ch; margin: 18px 0 0; }
.lead b { color: var(--fg); font-weight: 650; }
.hero { display: grid; grid-template-columns: minmax(0, 1fr) minmax(0, 1fr); gap: 40px; align-items: end; margin-top: 48px; }
.hero img { width: 100%; height: auto; display: block; background: #FAFAF7; }
section { margin-top: 96px; scroll-margin-top: 24px; }
.head { display: grid; gap: 12px; margin-bottom: 28px; max-width: 760px; }
.head p { margin: 0; color: var(--muted); font-size: 17px; }
.fig { margin: 0; } .fig img { width: 100%; max-width: 100%; height: auto; display: block; background: #FAFAF7; box-shadow: 0 0 0 1px var(--line); }
.fig figcaption { margin-top: 10px; font-size: 14px; line-height: 20px; color: var(--muted); max-width: 760px; }
.duo { display: grid; grid-template-columns: minmax(0, 1fr) minmax(0, 1fr); gap: 18px; }
.facts { display: grid; grid-template-columns: repeat(auto-fit, minmax(230px, 1fr)); gap: 0 28px; list-style: none; padding: 0; margin: 28px 0 0; }
.facts li { border-top: 1px solid var(--fg); padding: 14px 0 16px; font-size: 15px; line-height: 22px; color: var(--muted); }
.facts li b { display: block; color: var(--fg); font-size: 17px; margin-bottom: 4px; }
code { font: 400 13px/1 var(--f-data); }
.tablewrap { overflow-x: auto; }
table { width: 100%; border-collapse: collapse; min-width: 720px; font-size: 15px; line-height: 22px; }
th { text-align: left; font: 600 13px/18px var(--f-ui); color: var(--muted); padding: 0 16px 10px 0; border-bottom: 1px solid var(--fg); }
td { vertical-align: top; padding: 14px 16px 14px 0; border-bottom: 1px solid var(--line); color: var(--muted); }
td:first-child { color: var(--fg); font-weight: 650; }
.qs { margin: 0; padding-left: 22px; display: grid; gap: 10px; font-size: 18px; line-height: 26px; max-width: 780px; }
.foot { margin-top: 80px; padding-top: 18px; border-top: 1px solid var(--line); font-size: 13.5px; line-height: 20px; color: var(--muted); display: grid; gap: 8px; max-width: 900px; }
.foot p { margin: 0; }
@media (max-width: 860px) { .hero, .duo { grid-template-columns: minmax(0, 1fr); } }
</style>
<div class="wrap">
  <header class="top"><span>Relevo · propuesta 3.6</span><nav aria-label="Secciones"><a href="#azul">El azul</a><a href="#busqueda">La búsqueda</a><a href="#recomendada">La recomendada</a><a href="#licencias">Licencias</a></nav></header>
  <div class="hero">
    <div>
      <p class="eyebrow">Propuesta 3.6 · 4 de octubre de 2026</p>
      <h1>Una letra con identidad.</h1>
      <p class="lead">Los logotipos dibujados quedan descartados. Busqué letras <b>gratuitas para uso comercial</b> que tengan carácter propio y no sean una sans simple. La recomendada es <b>Chubbo</b>: una egipcia de remates redondos, cálida y analógica, lo opuesto a la pantalla. También el <b>azul de Relevo</b> pasa a combinar con la familia de colores.</p>
    </div>
    <img src="${img('hero.jpg')}" alt="El logotipo relevo compuesto en Chubbo Bold, en tinta sobre papel">
  </div>

  <section id="azul">
    <div class="head"><p class="eyebrow">El azul</p><h2>El azul de Relevo, arreglado</h2><p>El azul anterior, <code>#3D38F5</code>, tenía entre dos y cuatro veces el croma (la intensidad del color) de los demás y una luz que no era la de ningún nivel de la familia. Por eso saltaba y los claros no se leían encima. El nuevo tiene la luz de los profundos y un poco más de croma, para seguir siendo el color de la marca.</p></div>
    ${fig('azul.jpg', 'Comparación del azul anterior y el nuevo dentro de la familia de colores, con contrastes y usos en la interfaz', 'A la izquierda, el azul anterior; a la derecha, el nuevo, con los mismos claros, profundos y usos de interfaz.')}
    <ul class="facts">
      <li><b>Nuevo azul: <code>#1C3891</code></b>Luz 0,38, croma 0,15 y tono 266 en OKLCH. Los profundos tienen luz 0,33 y croma 0,11.</li>
      <li><b>Los claros se leen encima</b>Dan 5,6:1 o más; con el azul anterior daban 3,7:1. Con visión del color simulada, 4,5:1 o más.</li>
      <li><b>Sobre papel, 9,9:1</b>Sirve para el foco, la selección, la pestaña activa y los enlaces. En tema oscuro pasa a <code>#87A8F7</code> (8:1 sobre el fondo oscuro).</li>
    </ul>
  </section>

  <section id="busqueda">
    <div class="head"><p class="eyebrow">La búsqueda</p><h2>Veintinueve letras gratis, con carácter</h2><p>Busqué en Fontshare, de Indian Type Foundry (100 familias gratis para uso comercial), y en Google Fonts (licencia OFL), en cinco grupos: redondas, grotescas raras, display, de ancho y peso, y fuera de la sans.</p></div>
    ${fig('29.jpg', 'Veintinueve letras display escribiendo relevo', 'Las veintinueve. Quedaron fuera las que se leen como letra escrita a mano (Sharpie, Kihim), las de efecto (Segment, Array, Kola), las solo en mayúsculas (Tanker) y las demasiado frías o neutras para Relevo.')}
    <div style="margin-top:34px">${fig('seis.jpg', 'Seis letras finalistas en usos reales', 'Seis finalistas en uso con el azul nuevo y la familia de colores. Pally y Chillax son amables pero se acercan a una sans simple; Panchang tiene identidad pero se siente industrial. Chubbo, Calistoga y Fraunces Soft son las que dan calidez propia.')}</div>
  </section>

  <section id="recomendada">
    <div class="head"><p class="eyebrow">La recomendada</p><h2>Chubbo: blanda, cálida y propia</h2><p>Chubbo, de Rafał Buchner (Fontshare, 2021), es una egipcia (letra de remates rectangulares) cuyos remates terminan en curvas redondas: tiene la firmeza de una letra de afiche y la suavidad de un objeto de la casa. En «relevo» la «r», la «l» y la «v» quedan con pies propios y la palabra se reconoce de lejos. No es una sans simple, pero tampoco la serif de libro que no funcionó.</p></div>
    ${fig('chubbo.jpg', 'Tablero del logotipo en Chubbo: tintas, tamaños, ícono y usos', 'Chubbo Bold en minúsculas, apretada −2 %: tintas, tamaños de 64 a 16 px, ícono con la «r» sobre el azul nuevo, la barra de la app, dos afiches y la tarjeta de bolsillo. Los titulares y la interfaz siguen en Schibsted Grotesk.')}
    <ul class="facts">
      <li><b>Por qué cálida</b>En 2018, Collins rehizo la marca de Mailchimp y eligió Cooper Light porque captaba mejor su espíritu humano y cálido; el logotipo partió de esa letra y se ajustó para que no fuera la letra tal cual (Design Week, 2018). Chubbo y Calistoga trabajan en esa misma familia de formas blandas.</li>
      <li><b>Por qué Relevo</b>La marca habla de volver a cosas de la casa: un libro, unas acuarelas, una correa. Una letra blanda y analógica lo dice antes de leer la palabra.</li>
      <li><b>Cómo se usa</b>Solo para el logotipo y, si el autor quiere, para titulares muy grandes de campaña. La interfaz, los textos y los datos quedan en Schibsted Grotesk e IBM Plex Mono.</li>
    </ul>
    <h3 style="font:700 22px/1.2 var(--f-ui);letter-spacing:-.02em;margin:56px 0 16px">Las otras dos</h3>
    <div class="duo">${fig('calistoga.jpg', 'Tablero del logotipo en Calistoga', 'Calistoga, de Yvonne Schüttler con Sorkin Type (Google Fonts, OFL), inspirada en los rótulos de Oscar M. Bryn para los afiches del ferrocarril Santa Fe. Más compacta y nostálgica.')}${fig('fraunces.jpg', 'Tablero del logotipo en Fraunces Soft', 'Fraunces, de Undercase Type (Google Fonts, OFL), con los ejes blando y «wonky» al máximo. La más cálida, pero es una serif.')}</div>
  </section>

  <section id="licencias">
    <div class="head"><p class="eyebrow">Licencias</p><h2>Qué se puede usar, en claro</h2><p>Todas las finalistas son gratuitas para uso comercial. Las letras «gratis para probar» de fundiciones como Pangram Pangram sirven para la tesis, pero no para una marca real.</p></div>
    <div class="tablewrap"><table>
      <thead><tr><th>Origen</th><th>Licencia</th><th>Logotipo</th><th>Límite</th></tr></thead>
      <tbody>
        <tr><td>Fontshare (Chubbo, Pally, Chillax, Panchang)</td><td>ITF Free Font License 2.0: gratis para uso personal y comercial, en cualquier medio.</td><td>Permite crear logotipos y registrarlos como marca.</td><td>No se puede modificar ni redistribuir el archivo de la fuente.</td></tr>
        <tr><td>Google Fonts (Calistoga, Fraunces)</td><td>SIL Open Font License: libre, también para uso comercial.</td><td>Permitido.</td><td>Una versión modificada de la fuente debe mantener la misma licencia y, si tiene un nombre reservado, cambiarlo.</td></tr>
        <tr><td>«Gratis para probar» (por ejemplo, Pangram Pangram)</td><td>Uso personal no comercial, incluidos portafolios y proyectos escolares.</td><td>Para el logotipo de una empresa piden una licencia de logotipo pagada.</td><td>Vale para la tesis; si Relevo se vuelve un producto real, hay que comprar la licencia.</td></tr>
      </tbody>
    </table></div>
  </section>

  <section id="decidir">
    <div class="head"><p class="eyebrow">Para decidir</p><h2>Tres preguntas</h2></div>
    <ol class="qs">
      <li>¿El logotipo va en Chubbo, en Calistoga o en Fraunces Soft?</li>
      <li>¿La letra del logotipo se usa también en titulares grandes de campaña, o solo en el logotipo?</li>
      <li>¿Aceptas el azul nuevo, <code>#1C3891</code>?</li>
    </ol>
  </section>

  <footer class="foot">
    <p>Fuentes: <a href="https://www.fontshare.com/licenses/itf-ffl">licencia de Fontshare (ITF FFL 2.0)</a>, <a href="https://pangrampangram.com/pages/faq">preguntas frecuentes de Pangram Pangram</a>, <a href="https://www.designweek.co.uk/issues/1-7-october-2018/mailchimp-rebrand-aims-to-unify-bran">Design Week sobre Mailchimp (2018)</a> y la descripción de <a href="https://fonts.google.com/specimen/Calistoga">Calistoga en Google Fonts</a>.</p>
    <p>Los afiches y la tarjeta usan los textos verificados de la 3.4 y la 3.5. Contraste según WCAG 2.2; visión del color según Machado, Oliveira y Fernandes (2009).</p>
  </footer>
</div>`;
fs.writeFileSync(path.join(__dirname, 'letra-con-identidad.html'), html);
fs.writeFileSync(path.join(__dirname, 'vista.html'), '<meta charset="utf-8">\n' + html);
console.log('ok', Math.round(html.length / 1024) + ' KB');
