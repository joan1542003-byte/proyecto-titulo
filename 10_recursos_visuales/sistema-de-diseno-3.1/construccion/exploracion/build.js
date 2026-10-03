// Arma la lámina «Color y letra» a partir de plantilla.html: referencias, direcciones de color, pares de letra y muestras.
const fs = require('fs');
const path = require('path');
const G = require('../out/logo-geometry.json');
const { icon } = require('../apps-lib.js');
const T = fs.readFileSync(path.join(__dirname, 'plantilla.html'), 'utf8');

const wm = () => `<svg class="m-wm" viewBox="0 -1500 6929.5 1840" role="img" aria-label="relevo"><rect class="l" x="0" y="180" width="6929.5" height="160" rx="80"/><use class="w" href="#wm-word"/></svg>`;
const ic = (n) => icon(n, { size: 18, color: 'currentColor', accent: 'currentColor' });
const EXPLICA = 'Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas.';
const poster = () => `<div class="poster"><div class="dots"></div><div class="in">
  <span class="chip">${ic('leer')}<span>Leer</span></span><span></span>
  <h4 class="m-display">Vuelve a<br><span class="m-voice">leer</span>.</h4>
  <p>${EXPLICA}</p>
  <div class="foot">${wm()}<span>Leer<br>Abrir el libro · Junto al sillón</span></div>
</div></div>`;
const app = () => `<div class="app">
  <div class="bar">${wm()}<span>Inicio</span></div>
  <div class="card">
    <div class="lbl"><span>Ahora</span><span class="state">Contando</span></div>
    <div class="act m-display">Vuelve a <span class="m-voice">leer</span>.</div>
    <div class="row"><span>Cómo empiezas</span><span class="m-voice">Abrir el libro</span></div>
    <div class="row"><span>Dónde</span><span class="m-voice">Junto al sillón</span></div>
    <div class="dots15">${'<i></i>'.repeat(6)}${'<i class="off"></i>'.repeat(9)}</div>
    <div class="time">6 min <span>de 15</span></div>
  </div>
</div>`;
const pocket = () => `<div class="pocket"><div class="in">${wm()}<div class="ttl m-display">Vuelve a</div><div class="blank"><i></i><b>.</b></div></div><span class="hand">leer 10 páginas</span></div>`;

// ---------- Referencias de Behance ----------
const REFS = [
  ['Work in Progress, campaña de salud mental', 'https://www.behance.net/gallery/206664653/Work-in-Progress-Mental-Health-Campaign', ['risografía', 'dos tintas'], 'Personajes impresos en azul y rojo coral, con el grano de la risografía, para hablar de salud mental.', 'dos tintas cálidas tratan un tema delicado sin dramatismo.'],
  ['Livres à Vous 2021-2022', 'https://www.behance.net/gallery/189594043/Livres-a-Vous-2021-2022', ['libros', 'papel'], 'El afiche de un festival de libros: papel crema, un dibujo a lápiz y dos tintas, rojo y azul petróleo.', 'el lápiz y el papel dicen «hecho a mano», y dos tintas alcanzan.'],
  ['Hedwig, biblioteca para leer y escuchar', 'https://www.behance.net/gallery/256225289/Digital-Library-for-Reading-Listening-Hedwig', ['app de lectura', 'ilustración'], 'Ilustraciones en grises, con textura, y un solo amarillo que hace de sol.', 'las ilustraciones podrían ir en tinta con el color de su categoría como único acento.'],
  ['time:is', 'https://www.behance.net/gallery/223657767/timeis-visual-identity', ['tiempo', 'color plano'], 'Una identidad sobre el tiempo: fondos planos rojos, amarillos y rosados con dibujos negros hechos de píxeles.', 'color pleno a sangre con un dibujo en tinta; el tiempo hecho de puntos, como TimeDots.'],
  ['The Daily Form', 'https://www.behance.net/gallery/232670173/The-Daily-Form-Brand-Identity', ['azul eléctrico'], 'Casi el mismo azul eléctrico de Relevo, junto a un logotipo en minúsculas.', 'el azul solo no distingue; lo propio tiene que ser el renglón (Ward et al., 2020).'],
  ['Embody, app de yoga', 'https://www.behance.net/gallery/245473209/Branding-Visual-Identity-for-Yoga-App-Embody', ['bienestar'], 'Sus autores la describen con colores apagados y tipografía limpia.', 'ese es el tono por defecto del bienestar; Relevo necesita algo más propio.'],
  ["Théâtre l'Avant Seine 26-27", 'https://www.behance.net/gallery/255056303/Thatre-lAvant-Seine-26-27', ['degradados'], 'Fotos cortadas por formas en degradados de colores vivos.', 'tiene energía, pero es la dirección de degradados que el autor descartó (D-098).'],
  ['Matiz, estudio de cerámica', 'https://www.behance.net/gallery/255387287/Matiz-ceramic-studio-Branding-Design', ['materia', 'mano'], 'Crema, negro, papel kraft y un logotipo escrito a mano.', 'la materia de la casa puede venir del papel y de la mano, no solo del color.'],
  ['OFFit', 'https://www.behance.net/gallery/225640497/OFFit', ['objeto', 'desconexión'], 'Un objeto para desconectarse presentado como aparato: plata, verde menta y renders.', 'Relevo va al revés: un objeto doméstico, no un aparato.'],
];
const refs = REFS.map(([t, u, tags, saw, take]) => `      <article class="ref"><h3><a href="${u}">${t}</a></h3><div class="tags">${tags.map((x) => `<span>${x}</span>`).join('')}</div><p>${saw}</p><p class="take">${take}</p></article>`).join('\n');

// ---------- Direcciones de color ----------
const sw = (name, hex, fg, note) => `<div style="background:${hex};color:${fg}"><b>${name}</b><span>${hex}${note ? ' · ' + note : ''}</span></div>`;
const DIRS = [
  { id: 'A', tag: 'A · actual (3.1)', title: 'Casa apagada', idea: 'El azul es Relevo; seis colores apagados, uno por categoría, salidos de los materiales de la casa.',
    sw: [['Azul', '#3D38F5', '#fff', '6,1:1'], ['Papel', '#F2F2EF', '#17181C', ''], ['Tinta', '#17181C', '#F2F2EF', '15,8:1'], ['Mostaza 300', '#DAB974', '#17181C', 'leer'], ['Arcilla 400', '#DA8C8E', '#17181C', 'crear'], ['Salvia 500', '#649C66', '#fff', 'cuidar'], ['Terracota 600', '#B0582D', '#fff', 'moverme'], ['Ciruela 700', '#82466F', '#fff', 'compartir'], ['Pizarra 800', '#1A4D55', '#fff', 'aprender']],
    why: ['<b>Cada categoría tiene su color</b> y siempre va con ícono y nombre.', '<b>Medido:</b> renglones e íconos en 600 dan de 3,96 a 4,38:1 sobre papel; el texto en 700, de 5,59 a 6,13:1.', '<b>Construido en OKLCH,</b> con la misma luz por paso en las seis familias.'],
    risk: 'Se parece al promedio de las apps de bienestar (colores suaves y letra limpia) y al estilo cálido muy repetido de crema, serif y terracota. Seis colores piden memoria a quien mira.' },
  { id: 'B', tag: 'B · nueva', title: 'Cuaderno', idea: 'Dos tintas, como un cuaderno escolar: el renglón azul donde se escribe y el margen rojo que marca dónde empieza.',
    sw: [['Papel de cuaderno', '#FBFBF7', '#2A2C33', ''], ['Grafito', '#2A2C33', '#FBFBF7', '13,4:1'], ['Azul Relevo', '#3D38F5', '#fff', '6,6:1'], ['Rojo de margen', '#E23B45', '#fff', '4,1:1 líneas'], ['Rojo para texto', '#C72B36', '#fff', '5,3:1'], ['Celeste de renglones', '#BFD3F2', '#2A2C33', 'solo fondo']],
    why: ['<b>El margen es donde empieza.</b> Relevo suena donde empieza la actividad; en un cuaderno, la línea roja marca dónde se empieza a escribir. Es un segundo recurso con sentido.', '<b>Dos tintas se recuerdan.</b> Las referencias que mejor funcionan usan azul y un rojo cálido, y un recurso repetido igual es el que se vuelve propio (Romaniuk, 2018).', '<b>Lápiz y papel.</b> La persona escribe en grafito sobre el renglón azul: su voz no es azul, así no se confunde con un enlace.'],
    risk: 'Azul y rojo pueden verse escolares o institucionales si se abusa. El rojo de margen no se usa para errores ni alarmas: el error de la app tiene que quedar en otro rojo, más oscuro.' },
  { id: 'C', tag: 'C · nueva', title: 'Tintas de imprenta', idea: 'Seis tintas vivas, como las de una risógrafa, que se sobreimprimen con el azul. Para piezas, no para la interfaz.',
    sw: [['Azul', '#3D38F5', '#fff', 'blanco 6,8:1'], ['Amarillo', '#FFD23F', '#17181C', 'leer · 12,3:1'], ['Rosa', '#FF5D9E', '#17181C', 'crear · 6,2:1'], ['Naranja', '#FF7A33', '#17181C', 'moverme · 6,8:1'], ['Verde', '#1FA866', '#17181C', 'cuidar · 5,8:1'], ['Turquesa', '#12A1B0', '#17181C', 'aprender · 5,7:1'], ['Morado', '#8E3C8C', '#fff', 'compartir · 6,6:1']],
    why: ['<b>Imprime con puntos.</b> La risografía imprime en trama: la trama de Relevo deja de ser un efecto y pasa a ser técnica.', '<b>Energía sin degradados,</b> cerca de las referencias que el autor compartió el 30 de septiembre.', '<b>Texto en tinta sobre cada color</b> (5,7 a 12,3:1), salvo el morado y el azul, que llevan blanco.'],
    risk: 'No sirve en la interfaz: amarillo, rosa, naranja, verde y turquesa no llegan a 3:1 sobre papel. Verde y turquesa casi se confunden con tritanopía (2,0). Vuelve a ser una paleta de colores vivos, lo que 3.0 quiso evitar.' },
  { id: 'D', tag: 'D · nueva', title: 'Noche y lámpara', idea: 'El momento real del uso: de noche, el teléfono es azul y la casa es la luz cálida de una lámpara.',
    sw: [['Noche', '#121327', '#F2EDE3', ''], ['Tarjeta', '#1D1F3B', '#F2EDE3', ''], ['Luz', '#F2EDE3', '#121327', '15,7:1'], ['Azul pantalla', '#8F8CFF', '#121327', '6,4:1'], ['Lámpara', '#FFB547', '#121327', '10,4:1']],
    why: ['<b>Cuenta la escena.</b> El rato en el teléfono suele ser de noche; la lámpara es la casa que espera, como en la ilustración de «Leer».', '<b>El renglón se enciende.</b> Bajo la palabra de la persona va en ámbar: la luz que se prende cuando suena.', '<b>Contraste alto</b> en todo: la luz da 15,7:1 y el ámbar 10,4:1 sobre la noche.'],
    risk: 'Una identidad oscura pesa en papel e impresión, y una app clara de día la contradice. Sirve mejor como tema oscuro y para la pantalla de la señal.' },
];
const dirs = DIRS.map((d) => `      <article class="dir" id="dir-${d.id}">
        <div>
          <header><span class="tag">${d.tag}</span><h3>${d.title}</h3><p class="idea">${d.idea}</p></header>
          <div class="sw">${d.sw.map((s) => sw(...s)).join('')}</div>
          <ul class="why">${d.why.map((w) => `<li>${w}</li>`).join('')}</ul>
          <p class="risk">${d.risk}</p>
        </div>
        <div class="muestra trio" data-pal="${d.id}" data-type="1">${poster()}${app()}</div>
      </article>`).join('\n');

// ---------- Pares de letra ----------
const TYPES = [
  { id: '1', tag: '1 · actual (3.1)', title: 'Dos voces', what: 'Schibsted Grotesk para la interfaz; Newsreader romana para Relevo e itálica para la persona.',
    why: ['<b>Tamaño óptico</b> de 6 a 72: sirve desde 19 px.', '<b>Sobria y legible,</b> ya probada en el sistema 3.1.'], risk: 'Correcta pero esperable; a 17 px la itálica se distingue poco de la romana.' },
  { id: '2', tag: '2', title: 'Instrument Serif', what: 'Schibsted Grotesk con Instrument Serif, más estrecha y editorial, en romana e itálica.',
    why: ['<b>La aprobó el autor</b> el 30 de septiembre como serif posible.', '<b>Más carácter en titulares:</b> contraste alto y formas estrechas.'], risk: 'No tiene tamaño óptico: bajo 28 px se ve frágil. Solo para titulares y la palabra de la persona en grande.' },
  { id: '3', tag: '3', title: 'Fraunces suave', what: 'Schibsted Grotesk con Fraunces: el eje SOFT redondea los remates y WONK le da a la itálica un gesto de mano.',
    why: ['<b>Cálida, de casa:</b> se siente doméstica sin ser infantil a pesos medios.', '<b>Ejes propios:</b> se puede ajustar qué tan suave o qué tan inclinada.'], risk: 'Se acerca al estilo cálido muy repetido; con peso alto se vuelve juguetona.' },
  { id: '4', tag: '4', title: 'Bricolage Grotesque', what: 'Una grotesca con carácter para titulares e interfaz, con ancho y tamaño óptico variables; la persona sigue en itálica serif.',
    why: ['<b>Más propia que una grotesca neutra:</b> trampas de tinta y formas irregulares.', '<b>Titulares estrechos</b> (ancho 80) que caben en pantallas chicas.'], risk: 'Cambia la letra de la app y la base del logotipo, que hoy es Schibsted Grotesk: es la opción más cara.' },
  { id: '5', tag: '5 · nueva', title: 'Letra de cuaderno', what: 'Relevo sigue en Schibsted Grotesk y Newsreader; la persona escribe en Playwrite CL, la letra ligada que se enseña en las escuelas de Chile.',
    why: ['<b>Sale de la escuela chilena:</b> TypeTogether la dibujó con el modelo de letra ligada del país, en su proyecto Primarium sobre cómo se enseña a escribir.', '<b>Trae renglones:</b> su versión Guides dibuja las líneas guía del cuaderno, como el renglón de Relevo.'], risk: 'Una cursiva cuesta más de leer en tamaños chicos y para quien aprendió otra letra. Solo en piezas, en la tarjeta y en el campo grande donde se escribe; en listas, itálica.' },
];
const types = TYPES.map((t) => `      <article class="type">
        <span class="tag">${t.tag}</span><h3>${t.title}</h3>
        <p class="note" style="margin:0">${t.what}</p>
        <div class="muestra spec" data-pal="A" data-type="${t.id}" style="background:var(--m-bg)">
          <div class="s1 m-display">¿Qué quieres hacer?</div>
          <div class="s2 m-display">Vuelve a <span class="m-voice">leer</span>.</div>
          <p class="s3">Te avisa cuando sumes este tiempo en las apps que elijas.</p>
          <div class="s4"><div><span>Cómo empiezas</span><span class="m-voice">Abrir el libro</span></div><div><span>Dónde</span><span class="m-voice">Junto al sillón</span></div></div>
          <div class="s5">ejemplo · 2026-10-02 21:42 · leer · 15 min · comencé</div>${t.id === '5' ? '\n          <div class="guides" aria-label="Playwrite CL Guides">leer 10 páginas</div>' : ''}
        </div>
        <ul class="why">${t.why.map((w) => `<li>${w}</li>`).join('')}</ul>
        <p class="risk">${t.risk}</p>
      </article>`).join('\n');

// ---------- Opciones del combinador ----------
const opt = (name, v, label, sub, checked) => `          <label class="opt" for="${name}-${v}"><input type="radio" name="${name}" id="${name}-${v}" value="${v}"${checked ? ' checked' : ''}><span>${label}<small>${sub}</small></span></label>`;
const palopts = [['A', 'Casa apagada', '3.1: seis colores de la casa'], ['B', 'Cuaderno', 'azul y margen rojo'], ['C', 'Tintas de imprenta', 'tintas vivas para piezas'], ['D', 'Noche y lámpara', 'azul de pantalla y luz cálida']].map(([v, l, s], i) => opt('pal', v, l, s, i === 0)).join('\n');
const typeopts = [['1', 'Dos voces', 'Schibsted y Newsreader'], ['2', 'Instrument Serif', 'más editorial'], ['3', 'Fraunces suave', 'más cálida'], ['4', 'Bricolage Grotesque', 'grotesca con carácter'], ['5', 'Letra de cuaderno', 'la persona en Playwrite CL']].map(([v, l, s], i) => opt('type', v, l, s, i === 0)).join('\n');

let html = T.replace('{{WORD}}', G.wordPath).replace('{{REFS}}', refs).replace('{{DIRS}}', dirs).replace('{{TYPES}}', types)
  .replace('{{PALOPTS}}', palopts).replace('{{TYPEOPTS}}', typeopts).replace('{{POSTER}}', poster()).replace('{{APP}}', app()).replace('{{POCKET}}', pocket());
if (/\{\{[A-Z]+\}\}/.test(html)) throw new Error('Quedó un marcador sin reemplazar');
fs.writeFileSync(path.join(__dirname, 'color-y-letra.html'), html);
console.log('ok', Math.round(html.length / 1024) + ' KB');
