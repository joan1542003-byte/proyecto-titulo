// Versión 2 de «Volver a enfocar»: Relevo habla en Schibsted Grotesk; la serif queda solo para las palabras de la persona,
// y el renglón solo bajo esas palabras, del largo de la palabra y un poco más (como el del logotipo).
const fs = require('fs');
const path = require('path');
const F = path.join(__dirname, 'plantilla.html');
let t = fs.readFileSync(F, 'utf8');
const rep = (a, b) => { if (!t.includes(a)) throw new Error('No se encontró: ' + a.slice(0, 80)); t = t.split(a).join(b); };
const UI = 'var(--f-ui)';

// 1. Titulares de la página y de las piezas en la grotesca.
rep('h1 { font: 380 clamp(48px, 7.6vw, 108px)/.92 var(--f-serif); letter-spacing: -.03em;', `h1 { font: 650 clamp(44px, 7vw, 96px)/.95 ${UI}; letter-spacing: -.045em;`);
rep('h2 { font: 380 clamp(32px, 4.6vw, 58px)/1 var(--f-serif); letter-spacing: -.025em;', `h2 { font: 650 clamp(30px, 4.2vw, 52px)/1 ${UI}; letter-spacing: -.04em;`);
rep('.spec .s-head { font: 380 clamp(56px, 8vw, 110px)/.92 var(--f-serif); letter-spacing: -.03em; }', `.spec .s-head { font: 650 clamp(52px, 7.4vw, 100px)/.95 ${UI}; letter-spacing: -.045em; }`);
rep('.roles .r1 { font: 380 30px/1 var(--f-serif); letter-spacing: -.02em; }', `.roles .r1 { font: 650 26px/1 ${UI}; letter-spacing: -.03em; }`);
rep('.sub { font: 380 28px/1.1 var(--f-serif); margin: 60px 0 18px; letter-spacing: -.01em; }', `.sub { font: 650 24px/1.1 ${UI}; margin: 60px 0 18px; letter-spacing: -.025em; }`);
rep('.phead { font: 380 17cqw/.92 var(--f-serif); letter-spacing: -.028em; }', `.phead { font: 650 14.5cqw/.95 ${UI}; letter-spacing: -.045em; }`);
rep('.stitle { margin: 6px 0 0; font: 380 38px/1 var(--f-serif); letter-spacing: -.02em; }', `.stitle { margin: 6px 0 0; font: 650 34px/1 ${UI}; letter-spacing: -.035em; }`);
rep('.ahead { font: 380 30px/.95 var(--f-serif); letter-spacing: -.02em; margin-top: 2px; }', `.ahead { font: 650 25px/1 ${UI}; letter-spacing: -.035em; margin-top: 2px; }`);
rep('.qtitle { font: 380 40px/.98 var(--f-serif); letter-spacing: -.025em; margin: 8px 0 4px; }', `.qtitle { font: 650 34px/1 ${UI}; letter-spacing: -.035em; margin: 8px 0 4px; }`);
rep('.sghead { font: 380 64px/.9 var(--f-serif); letter-spacing: -.03em; margin-top: auto; }', `.sghead { font: 650 52px/.95 ${UI}; letter-spacing: -.045em; margin-top: auto; }`);
rep('.sthead { align-self: end; font: 380 26cqw/.9 var(--f-serif); letter-spacing: -.035em; }', `.sthead { align-self: end; font: 650 21cqw/.92 ${UI}; letter-spacing: -.05em; }`);
rep('.pchead { align-self: end; font: 380 15cqw/.92 var(--f-serif); letter-spacing: -.03em; }', `.pchead { align-self: end; font: 650 12.5cqw/.95 ${UI}; letter-spacing: -.045em; }`);
rep('.slide h3 { align-self: center; margin: 0; font: 380 5.2cqw/1.06 var(--f-serif); letter-spacing: -.02em; max-width: 88%; }', `.slide h3 { align-self: center; margin: 0; font: 600 4.6cqw/1.1 ${UI}; letter-spacing: -.03em; max-width: 88%; }`);
rep('.slide h3.big { font-size: 9cqw; line-height: .92; letter-spacing: -.03em; align-self: end; }', '.slide h3.big { font-size: 8cqw; font-weight: 650; line-height: .95; letter-spacing: -.045em; align-self: end; }');
rep('.yesno h3 { font: 380 32px/1 var(--f-serif); margin: 0 0 12px; }', `.yesno h3 { font: 650 28px/1 ${UI}; letter-spacing: -.03em; margin: 0 0 12px; }`);

// 2. La voz de la persona: la única serif, un poco más grande que la grotesca para igualar la altura de x.
rep('.pvoz { display: inline-block; font: italic 380 17cqw/1.05 var(--f-serif); letter-spacing: -.028em; }', '.pvoz { position: relative; display: inline-block; font: italic 400 16.5cqw/1.08 var(--f-serif); letter-spacing: -.02em; }');
rep('.avoz { display: inline-block; font: italic 380 30px/1.1 var(--f-serif); letter-spacing: -.02em; }', '.avoz { position: relative; display: inline-block; font: italic 400 29px/1.15 var(--f-serif); letter-spacing: -.015em; }');
rep('.sgvoz { display: inline-block; font: italic 380 56px/1.05 var(--f-serif); letter-spacing: -.03em; }', '.sgvoz { position: relative; display: inline-block; font: italic 400 54px/1.08 var(--f-serif); letter-spacing: -.02em; }');
rep('.spec .s-voz { font: italic 380 clamp(56px, 8vw, 110px)/1.02 var(--f-serif); letter-spacing: -.03em; }', '.spec .s-voz { position: relative; display: inline-block; font: italic 400 clamp(56px, 8vw, 106px)/1.08 var(--f-serif); letter-spacing: -.02em; }');

// 3. El renglón: ya no cruza la pieza. Va bajo las palabras de la persona y las pasa en media eme, en cápsula.
rep('.pline { position: relative; padding-bottom: 2.4cqw; white-space: nowrap; }', '.pline { white-space: nowrap; margin-top: .5cqw; }');
rep('.pline::after { content: ""; position: absolute; left: -7cqw; right: -7cqw; bottom: 0; height: 1.8cqw; background: var(--blue); transform-origin: left center; }', '');
rep('.aline { position: relative; margin: 0 -18px; padding: 0 18px 6px; white-space: nowrap; }', '.aline { white-space: nowrap; }');
rep('.aline::after { content: ""; position: absolute; left: 0; right: 0; bottom: 0; height: 4px; background: var(--blue); }', '');
rep('.sgline { position: relative; margin: 2px -18px 0; padding: 0 18px 8px; white-space: nowrap; }', '.sgline { white-space: nowrap; margin-top: 2px; }');
rep('.sgline::after { content: ""; position: absolute; left: 0; right: 0; bottom: 0; height: 7px; background: var(--blue); }', '');
rep('.spec .s-line { position: relative; padding-bottom: 12px; white-space: nowrap; }', '.spec .s-line { white-space: nowrap; }');
rep('.spec .s-line::after { content: ""; position: absolute; left: -34px; right: -34px; bottom: 0; height: 9px; background: var(--blue); }', '');
rep('.pdot, .avoz span, .sgvoz span { font-style: normal; }', `.pdot, .avoz span, .sgvoz span { font-style: normal; }
.pvoz::after, .avoz::after, .sgvoz::after, .spec .s-voz::after { content: ""; position: absolute; left: .02em; right: -.5em; bottom: .04em; height: max(3px, .06em); border-radius: 999px; background: var(--blue); transform-origin: left center; }`);
// Líneas para escribir: dentro de los márgenes y más finas.
rep('.stline { height: 2.6cqw; background: var(--blue); margin: 24cqw -8cqw 0; }', '.stline { height: 1.2cqw; border-radius: 99px; background: var(--blue); margin: 22cqw 0 0; }');
rep('.pcline { height: 1.3cqw; background: var(--blue); margin: 10cqw -7cqw 1cqw; }', '.pcline { height: .9cqw; border-radius: 99px; background: var(--blue); margin: 10cqw 0 1cqw; }');
rep('.fieldv { font: italic 400 26px/1.3 var(--f-serif); padding-bottom: 6px; box-shadow: inset 0 -3px 0 var(--blue); }', '.fieldv { font: italic 400 26px/1.3 var(--f-serif); padding-bottom: 6px; box-shadow: inset 0 -2px 0 var(--blue); }');
rep('.rg { box-shadow: inset 0 -.1em 0 var(--blue); }', '.rg { box-shadow: inset 0 -.07em 0 var(--blue); }');
// La animación del renglón sigue a la palabra.
rep('#afiche-portada .pline::after { animation:', '#afiche-portada .pvoz::after { animation:');

// 4. Textos de la lámina.
rep('<p class="eyebrow">Propuesta 3.3 · 3 de octubre de 2026</p>\n      <h1>Volver a <em>enfocar</em>.</h1>', '<p class="eyebrow">Propuesta 3.3, versión 2 · 3 de octubre de 2026</p>\n      <h1>Volver a enfocar.</h1>');
rep('Por eso la actividad aparece <b>desenfocada, en su color vivo</b>, y encima, nítidas, la frase de Relevo y las palabras de la persona sobre el renglón azul.', 'Por eso la actividad aparece <b>desenfocada, en su color vivo</b>, y encima, nítidas, la frase de Relevo y las palabras de la persona.');
rep('<li><span class="n">2</span><span><b>Lo nítido es la intención.</b>La frase de Relevo en Newsreader; lo que escribió la persona, en su itálica; el renglón azul de borde a borde.</span></li>', '<li><span class="n">2</span><span><b>Lo nítido es la intención.</b>Relevo habla en Schibsted Grotesk. Lo que escribió la persona va en itálica, con un renglón azul corto debajo, como el del logotipo.</span></li>');
rep('Propuesta para el autor · reemplaza la letra escrita a mano de la 3.2 · no cambia todavía la app ni el sistema publicado', 'Versión 2, a pedido del autor: menos serif y menos renglón · no cambia todavía la app ni el sistema publicado');
rep('<h2>Una serif tranquila y su itálica</h2>\n      <p>Sin letra escrita a mano. Vuelven las dos voces de la 3.1: Relevo habla en Newsreader romana y la persona, en su itálica. La interfaz y el logotipo siguen en Schibsted Grotesk.</p>', '<h2>Una grotesca para Relevo, una itálica para la persona</h2>\n      <p>La serif ya no es obligatoria. Relevo habla en Schibsted Grotesk, en titulares y en la interfaz. La serif queda en un solo lugar: las palabras que escribió la persona, en Newsreader itálica.</p>');
rep('<li><span class="r1">Newsreader</span><small>La frase de Relevo, grande y liviana (380). Serif para pantalla con tamaños ópticos, de Production Type (2020-2021).</small></li>\n        <li><span class="r2">Newsreader itálica</span><small>Lo que escribe la persona: la actividad, cómo empieza, dónde. Siempre en tinta, sobre el renglón.</small></li>\n        <li><span class="r3">Schibsted Grotesk</span><small>Interfaz, botones y explicaciones; el logotipo en 600. De Bakken &amp; Bæck.</small></li>', '<li><span class="r1">Schibsted Grotesk</span><small>Relevo: titulares en 650 y apretados, interfaz y explicaciones en 400 a 600, logotipo en 600. De Bakken &amp; Bæck.</small></li>\n        <li><span class="r2">Newsreader itálica</span><small>Solo lo que escribe la persona: la actividad, cómo empieza, dónde. De Production Type (2020-2021).</small></li>');
rep('<li>El renglón azul, nítido, de borde a borde.<small>Uno por pieza.</small></li>', '<li>El renglón solo bajo las palabras de la persona.<small>Del largo de la palabra y un poco más, como el del logotipo.</small></li>');
rep('<li>Letra escrita a mano.</li>', '<li>Letra escrita a mano, o serif en titulares.</li>\n        <li>Rayas de borde a borde en todas las piezas.</li>');
rep('<p class="cap"><b>Afiches «Vuelve a…».</b> Uno por categoría, con una idea de la app: la actividad, cómo empieza y dónde. La foto de su lugar, fuera de foco; la frase, nítida.</p>', '<p class="cap"><b>Afiches «Vuelve a…».</b> Uno por categoría, con una idea de la app: la actividad, cómo empieza y dónde. La foto de su lugar, fuera de foco; la frase, nítida; el renglón, solo bajo la palabra de la persona.</p>');
rep('<p class="cap"><b>Láminas.</b> Blancas para las ideas, con el renglón bajo la frase clave; una luz de la casa para abrir cada sección.</p>', '<p class="cap"><b>Láminas.</b> Blancas para las ideas, con un renglón fino bajo la frase clave; una luz de la casa para abrir cada sección.</p>');
rep('<li>¿La luz desenfocada reemplaza a los colores planos de la 3.2 en piezas y en la app?</li>', '<li>¿Queda así, con la grotesca como voz de Relevo y la serif solo para la persona?</li>');
fs.writeFileSync(F, t);
const left = (t.match(/var\(--f-serif\)/g) || []).length;
console.log('ok; usos de la serif que quedan:', left);
