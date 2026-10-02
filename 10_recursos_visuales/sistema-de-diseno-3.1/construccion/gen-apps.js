// Aplicaciones 3.1: afiches, redes, láminas, portada de la memoria, objeto, tarjeta y stickers.
// Textos: app 2.18 (HowItWorksScreen, PrepareScreen, SignalScreens), guía de comunicación y memoria v4. Nada inventado.
const fs = require('fs');
const path = require('path');
const L = require('./apps-lib.js');
const { C, CAT, step, sig, wordmark, symbol, appIcon, icon, trama, illus, page } = L;
const { launch } = require('./cdp.js');
const DIR = path.join(__dirname, 'apps');
const OUT = path.join(__dirname, 'out', 'Aplicaciones');
fs.mkdirSync(DIR, { recursive: true });
fs.mkdirSync(OUT, { recursive: true });
const pieces = [];
const add = (name, w, h, html) => pieces.push({ name, w, h, html });
const EXPLICA = 'Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas.';

// ---------- 1. Afiches «Vuelve a…» (A3 vertical, 1080 × 1528) ----------
// Palabras de las ideas de la app (doc 23): actividad · para empezar · dónde.
const AFICHES = [
  ['leer', 'leer', 'Leer', 'Abrir el libro', 'Junto al sillón'],
  ['crear', 'pintar', 'Pintar', 'Preparar las acuarelas', 'En la mesa'],
  ['cuidar', 'cuidar las plantas', 'Cuidar las plantas', 'Llenar la regadera', 'Junto a las plantas'],
  ['moverme', 'salir a caminar', 'Salir a caminar', 'Ponerte las zapatillas', 'Junto a la puerta'],
  ['compartir', 'jugar un juego de mesa', 'Jugar un juego de mesa', 'Sacar la caja', 'En la mesa'],
  ['aprender', 'estudiar', 'Estudiar', 'Abrir tus apuntes', 'En el escritorio'],
];
AFICHES.forEach(([cat, word, act, first, place], i) => {
  const c = CAT[cat], f = c.fam;
  add(`afiche-${cat}`, 1080, 1528, page(1080, 1528, `
<div class="abs" style="inset:0;padding:64px 72px 62px;display:flex;flex-direction:column">
  <div style="display:flex;justify-content:space-between;align-items:center">
    <div style="display:flex;align-items:center;gap:12px;padding:12px 26px 12px 18px;border-radius:999px;background:${step(f, 100)};color:${step(f, 800)};font:600 25px/1 'Schibsted Grotesk'">${icon(c.icon, { size: 32, color: step(f, 600), accent: step(f, 600) })}<span>${c.name}</span></div>
    <div class="mono grafito" style="font-size:22px">${i + 1} / 6</div>
  </div>
  <div style="flex:1;display:flex;align-items:center;margin:10px 0 10px -8px">${illus(c.illus, 952)}</div>
  <div class="serif" data-same=".fit" style="font-size:150px;line-height:1">Vuelve a</div>
  <div style="margin-top:8px"><span class="rg voz fit" data-bleed="1" data-max="930" style="--line:${step(f, 600)};font-size:150px;line-height:1.08">${word}<span class="serif" style="font-style:normal">.</span></span></div>
  <p class="grafito" style="margin-top:70px;font-size:30px;line-height:40px;max-width:880px">${EXPLICA}</p>
  <div style="margin-top:54px;display:flex;justify-content:space-between;align-items:flex-end">
    ${wordmark({ h: 44 })}
    <div class="mono grafito" style="text-align:right;font-size:21px;line-height:30px">${act}<br>${first} · ${place}</div>
  </div>
</div>`, '', step(f, 50)));
});

// ---------- 2. Carrusel «¿Te ha pasado?» (1080 × 1350, 4 láminas) ----------
const footer = (n) => `<div class="abs" style="left:72px;right:72px;bottom:60px;display:flex;justify-content:space-between;align-items:flex-end">${wordmark({ h: 34 })}<div class="mono grafito" style="font-size:22px">${n} / 4</div></div>`;
const label = (ic, t) => `<div style="display:flex;align-items:center;gap:12px;font:600 28px/1 'Schibsted Grotesk';color:${C.graphite}">${icon(ic, { size: 34, color: C.ink, accent: C.blue })}<span>${t}</span></div>`;
{
  // 1. El tiempo en puntos: un punto por minuto; 42 de 60 llenos.
  let dots = '';
  for (let k = 0; k < 60; k++) dots += `<span style="width:46px;height:46px;border-radius:50%;background:${k < 42 ? C.blue : 'transparent'};box-shadow:${k < 42 ? 'none' : `inset 0 0 0 3px ${C.blue200}`}"></span>`;
  add('redes-carrusel-1', 1080, 1350, page(1080, 1350, `
<div class="abs" style="left:72px;top:96px;right:72px">
  <h1 class="serif" style="font-size:128px;line-height:1.02">¿Te ha pasado?</h1>
  <p style="margin-top:56px;font:600 46px/58px 'Schibsted Grotesk'">Abres una app para descansar.</p>
  <p class="grafito" style="margin-top:10px;font-size:46px;line-height:58px;max-width:900px">Se pasa el rato y lo que querías hacer queda esperando.</p>
</div>
<div class="abs" style="left:72px;bottom:190px"><div style="display:grid;grid-template-columns:repeat(15,46px);gap:18px 16px">${dots}</div>
  <p class="mono grafito" style="margin-top:28px;font-size:22px">Un punto, un minuto.</p></div>${footer(1)}`));
  // 2. La app: el campo con la voz de la persona en itálica, sobre el renglón de su categoría.
  const row = (ic, k, v) => `<div style="display:flex;align-items:center;gap:16px;padding:22px 0;border-top:1.5px solid ${C.mist}">${icon(ic, { size: 34, color: C.graphite, accent: C.blue })}<span class="grafito" style="font-size:30px;flex:1">${k}</span><span class="voz" style="font-size:36px">${v}</span></div>`;
  add('redes-carrusel-2', 1080, 1350, page(1080, 1350, `
<div class="abs" style="left:72px;top:96px;right:72px">
  ${label('telefono', 'La app')}
  <h1 class="serif" style="margin-top:40px;font-size:92px;line-height:1.04">Anotas qué quieres hacer y cómo empiezas.</h1>
  <div style="margin-top:96px;background:${C.card};border-radius:36px;padding:44px 44px 20px">
    <div style="font:600 26px/1 'Schibsted Grotesk';color:${C.graphite}">¿Qué quieres hacer?</div>
    <div class="voz" style="margin-top:18px;font-size:58px;line-height:1.15;padding-bottom:12px;box-shadow:inset 0 -3px 0 ${step('mostaza', 600)}">Leer 10 páginas</div>
    <div style="margin-top:30px">${row('primer-paso', 'Cómo empiezas', 'Abrir el libro')}${row('lugar', 'Dónde', 'Junto al sillón')}<div style="display:flex;align-items:center;gap:16px;padding:22px 0;border-top:1.5px solid ${C.mist}">${icon('tiempo', { size: 34, color: C.graphite, accent: C.blue })}<span class="grafito" style="font-size:30px;flex:1">Te avisa después de</span><span style="font:600 34px/1 'Schibsted Grotesk';color:${C.blue}">30 min</span></div></div>
  </div>
</div>${footer(2)}`));
  // 3. El parlante en el lugar: la ilustración de «Leer» con el objeto junto al libro.
  add('redes-carrusel-3', 1080, 1350, page(1080, 1350, `
<div class="abs" style="left:72px;top:96px;right:72px">
  ${label('parlante', 'El parlante')}
  <h1 class="serif" style="margin-top:40px;font-size:92px;line-height:1.04">Lo dejas donde empiezas.</h1>
  <p class="grafito" style="margin-top:22px;font-size:40px;line-height:52px;max-width:900px">Suena cuando llevas en tus apps el tiempo que elegiste.</p>
</div>
<div class="abs" style="left:0;right:0;bottom:150px;display:flex;justify-content:center"><div style="border-radius:40px;overflow:hidden">${illus('leer-sillon', 936)}</div></div>${footer(3)}`));
  // 4. Tú decides: las tres respuestas de la app, ninguna destacada.
  const btn = (ic, t) => `<div style="display:flex;align-items:center;gap:18px;height:100px;padding:0 36px;border-radius:999px;background:${C.card};box-shadow:inset 0 0 0 1.5px ${C.mist};font:600 36px/1 'Schibsted Grotesk'">${icon(ic, { size: 38, color: C.ink, accent: C.blue })}<span>${t}</span></div>`;
  add('redes-carrusel-4', 1080, 1350, page(1080, 1350, `
<div class="abs" style="left:72px;top:96px;right:72px">
  ${label('usuario', 'Tú')}
  <h1 class="serif" style="margin-top:40px;font-size:92px;line-height:1.04"><span class="rg">Decides</span> si empiezas o sigues con lo que estabas haciendo.</h1>
  <div style="margin-top:60px;display:flex;flex-direction:column;gap:18px">${btn('comence', 'Comencé la actividad')}${btn('despues', 'La dejé para después')}${btn('cambie', 'Cambié de idea')}</div>
  <p class="grafito" style="margin-top:56px;font-size:40px;line-height:52px">Ninguna respuesta es mejor que otra.</p>
</div>${footer(4)}`));
}

// ---------- 3. Historias (1080 × 1920) ----------
add('redes-historia-escribe', 1080, 1920, page(1080, 1920, `
<div class="abs" style="left:80px;top:150px">${wordmark({ h: 52 })}</div>
<div class="abs" style="left:80px;right:80px;top:700px">
  <div class="serif" style="font-size:168px;line-height:1">Vuelve a</div>
  <div style="margin-top:150px;display:flex;align-items:flex-end;gap:18px"><div style="flex:1;height:16px;border-radius:999px;background:${C.blue}"></div><span class="serif" style="font-size:168px;line-height:.6">.</span></div>
  <p class="grafito" style="margin-top:70px;font-size:44px;line-height:56px">Escribe sobre el renglón lo que quieres hacer.</p>
</div>
<div class="abs mono grafito" style="left:80px;bottom:120px;font-size:26px">Relevo · un recordatorio físico que preparas desde el teléfono</div>`));
add('redes-historia-trama', 1080, 1920, page(1080, 1920, `
<div class="abs" style="inset:0">${trama({ w: 1080, h: 1920, pitch: 22, mode: 'gradiente', deep: C.blueDots, angle: 0.3, min: 0.05 })}</div>
<div class="abs" style="left:64px;right:64px;top:560px;padding:64px 60px 70px;border-radius:48px;background:rgba(255,255,255,.12);backdrop-filter:blur(24px);-webkit-backdrop-filter:blur(24px);box-shadow:inset 0 0 0 1.5px rgba(255,255,255,.32)">
  ${wordmark({ h: 92, ink: C.white, line: C.white })}
  <p class="serif" style="margin-top:72px;color:${C.white};font-size:78px;line-height:1.08">Un recordatorio físico que preparas desde el teléfono.</p>
</div>
<p class="abs" style="left:80px;right:80px;bottom:120px;color:rgba(255,255,255,.86);font-size:30px;line-height:42px">Propuesta phygital en desarrollo. Su ventaja frente a una notificación todavía debe validarse.</p>`, '', C.blue));

// ---------- 4. Publicación cuadrada: las seis categorías (1080 × 1080) ----------
{
  const order = ['moverme', 'leer', 'crear', 'aprender', 'cuidar', 'compartir'];
  const tiles = order.map((k) => { const c = CAT[k], f = c.fam; return `<div style="background:${step(f, 100)};border-radius:32px;padding:30px 28px;display:flex;flex-direction:column;justify-content:space-between;height:300px">${icon(c.icon, { size: 76, color: step(f, 600), accent: step(f, 600), sw: 1.5 })}<div style="font:600 31px/37px 'Schibsted Grotesk';color:${step(f, 800)}">${c.name}</div></div>`; }).join('');
  add('redes-categorias', 1080, 1080, page(1080, 1080, `
<div class="abs" style="left:72px;right:72px;top:84px">
  <h1 class="serif" style="font-size:92px;line-height:1">¿Qué quieres hacer?</h1>
  <div style="margin-top:56px;display:grid;grid-template-columns:repeat(3,1fr);gap:18px">${tiles}</div>
</div>
<div class="abs" style="left:72px;right:72px;bottom:56px;display:flex;justify-content:space-between;align-items:flex-end">${wordmark({ h: 34 })}<div class="mono grafito" style="font-size:22px">Las ideas de la app, por interés</div></div>`));
}

// ---------- 5. Láminas de presentación (1920 × 1080) ----------
const sl = (n, sec, body, bg = C.white) => page(1920, 1080, `
<div class="abs grafito" style="left:120px;top:72px;font:500 24px/1 'Schibsted Grotesk'">${sec}</div>
<div class="abs mono grafito" style="right:120px;top:72px;font-size:24px">${String(n).padStart(2, '0')}</div>${body}`, '', bg);
add('presentacion-1-portada', 1920, 1080, page(1920, 1080, `
<div class="abs" style="right:0;top:0;width:700px;height:1080px;background:${C.blue}">${trama({ w: 700, h: 1080, pitch: 20, mode: 'gradiente', deep: C.blueDots, angle: 0.25, min: 0.04 })}</div>
<div class="abs" style="right:250px;top:440px">${appIcon({ size: 200, bg: C.white, ink: C.ink, line: C.blue })}</div>
<div class="abs" style="left:120px;top:150px">${wordmark({ h: 120 })}</div>
<h1 class="abs serif" style="left:120px;top:420px;width:980px;font-size:76px;line-height:1.1">Sistema phygital para recuperar intenciones personales durante el ocio digital</h1>
<p class="abs grafito" style="left:120px;bottom:96px;font-size:26px;line-height:38px">Memoria de Proyecto de Título · Escuela de Diseño<br>Universidad Diego Portales · Santiago, 2026</p>`, '', C.white));
add('presentacion-2-seccion', 1920, 1080, sl(3, 'Sección', `
<div class="abs mono" style="left:120px;top:360px;font-size:44px;color:${C.blue}">03</div>
<h1 class="abs serif" style="left:120px;top:440px;font-size:136px;line-height:1.04;width:1500px">Planteamiento del <span class="rg">problema</span></h1>`));
add('presentacion-3-idea', 1920, 1080, sl(4, 'Problema', `
<h1 class="abs serif" style="left:120px;top:300px;width:1560px;font-size:92px;line-height:1.12">Algunas sesiones de ocio digital se prolongan sin que la persona <span class="rg">vuelva a decidir</span> si quiere continuar.</h1>
<p class="abs mono grafito" style="left:120px;bottom:80px;font-size:22px">Memoria, resumen</p>`));
{
  const col = (n, t) => `<div><div class="serif" style="font-size:230px;line-height:.9">${n}</div><p style="margin-top:34px;font-size:32px;line-height:44px;max-width:470px">${t}</p></div>`;
  add('presentacion-4-datos', 1920, 1080, sl(5, 'Investigación', `
<h2 class="abs serif" style="left:120px;top:170px;font-size:72px;line-height:1.1">Lo que se <span class="rg">investigó</span></h2>
<div class="abs" style="left:120px;right:120px;top:400px;display:grid;grid-template-columns:repeat(3,1fr);gap:80px">
  ${col('8', 'entrevistas semiestructuradas, analizadas con el método Framework')}
  ${col('53', 'personas respondieron una encuesta en línea')}
  ${col('21', 'días de prueba en hogares, diseñada para comparar la señal en el lugar con un lugar neutro y con el teléfono')}
</div>
<p class="abs mono grafito" style="left:120px;bottom:80px;font-size:22px">Memoria, resumen. La prueba de 21 días aún no se realiza.</p>`));
}
{
  const col = (ic, t) => `<div style="border-top:3px solid ${C.ink};padding-top:40px">${icon(ic, { size: 96, color: C.ink, accent: C.blue, sw: 1.5 })}<p style="margin-top:40px;font:600 46px/56px 'Schibsted Grotesk'">${t}</p></div>`;
  add('presentacion-5-ambitos', 1920, 1080, sl(6, 'Marco teórico', `
<h2 class="abs serif" style="left:120px;top:170px;font-size:72px;line-height:1.1">Tres <span class="rg">ámbitos</span></h2>
<div class="abs" style="left:120px;right:120px;top:420px;display:grid;grid-template-columns:repeat(3,1fr);gap:72px">
  ${col('ocio-digital', 'La experiencia del ocio digital')}${col('diseno-atencion', 'El diseño de la atención')}${col('objetos-lugares', 'Recordar con objetos y lugares')}
</div>`));
}
add('presentacion-6-cierre', 1920, 1080, page(1920, 1080, `
<div class="abs" style="left:0;right:0;top:330px;text-align:center"><h1 class="serif" style="font-size:132px;line-height:1.05">Vuelve a <span class="rg">lo que querías hacer</span>.</h1></div>
<div class="abs" style="left:0;right:0;top:700px;display:flex;justify-content:center">${wordmark({ h: 72 })}</div>`, '', C.white));

// ---------- 6. Portada de la memoria (A4, 1240 × 1754) ----------
{
  const lines = [[C.blue, 760], [sig('mostaza'), 560], [sig('arcilla'), 660], [sig('salvia'), 480], [sig('terracota'), 720], [sig('ciruela'), 520], [sig('pizarra'), 620]];
  const rl = lines.map(([c, w]) => `<div style="width:${w}px;height:26px;border-radius:999px;background:${c}"></div>`).join('');
  add('memoria-portada', 1240, 1754, page(1240, 1754, `
<p class="abs mono grafito" style="left:110px;top:120px;font-size:26px">Memoria de Proyecto de Título</p>
<div class="abs" style="left:110px;top:330px">${wordmark({ h: 200 })}</div>
<h1 class="abs serif" style="left:110px;top:680px;width:960px;font-size:68px;line-height:1.12">Sistema phygital para recuperar intenciones personales durante el ocio digital</h1>
<div class="abs" style="left:110px;top:1160px;display:flex;flex-direction:column;gap:20px">${rl}</div>
<div class="abs" style="left:110px;right:110px;bottom:110px;display:flex;justify-content:space-between;align-items:flex-end;font-size:26px;line-height:38px"><p>Escuela de Diseño<br>Facultad de Arquitectura, Arte y Diseño<br>Universidad Diego Portales</p><p class="grafito" style="text-align:right">Santiago, Chile<br>2026</p></div>`));
}

// ---------- 7. El objeto: renglón en la base y trama en la rejilla (1600 × 1000) ----------
{
  const grille = (cx, cy, r, pitch, dot, col) => { let s = ''; for (let y = -r; y <= r; y += pitch) for (let x = -r; x <= r; x += pitch) if (x * x + y * y <= (r - dot) ** 2) s += `<circle cx="${(cx + x).toFixed(1)}" cy="${(cy + y).toFixed(1)}" r="${dot}"/>`; return `<g fill="${col}">${s}</g>`; };
  const top = (cx, cy, body, edge, dots) => `<circle cx="${cx}" cy="${cy}" r="190" fill="${C.blue}"/><circle cx="${cx}" cy="${cy}" r="182" fill="${body}" stroke="${edge}" stroke-width="3"/>${grille(cx, cy, 128, 17, 4.2, dots)}`;
  const side = (x, y, body, edge) => `<rect x="${x}" y="${y}" width="380" height="118" rx="44" fill="${body}" stroke="${edge}" stroke-width="3"/><clipPath id="cl${x}-${y}"><rect x="${x}" y="${y}" width="380" height="118" rx="44"/></clipPath><rect x="${x}" y="${y + 90}" width="380" height="28" fill="${C.blue}" clip-path="url(#cl${x}-${y})"/>`;
  const dim = (x1, y1, x2, y2, t, tx, ty, anchor = 'middle') => `<line x1="${x1}" y1="${y1}" x2="${x2}" y2="${y2}" stroke="${C.graphite}" stroke-width="2"/><line x1="${x1}" y1="${y1 - 10}" x2="${x1}" y2="${y1 + 10}" stroke="${C.graphite}" stroke-width="2" transform="${x1 === x2 ? `rotate(90 ${x1} ${y1})` : ''}"/><line x1="${x2}" y1="${y2 - 10}" x2="${x2}" y2="${y2 + 10}" stroke="${C.graphite}" stroke-width="2" transform="${x1 === x2 ? `rotate(90 ${x2} ${y2})` : ''}"/><text x="${tx}" y="${ty}" text-anchor="${anchor}" font-family="IBM Plex Mono" font-weight="300" font-size="22" fill="${C.graphite}">${t}</text>`;
  const svg = `<svg width="1000" height="640" viewBox="0 0 1000 640">
${top(250, 300, C.card, C.ink, C.ink)}
${dim(60, 60, 440, 60, '42–48 mm', 250, 44)}
${side(540, 120, C.card, C.ink)}
${side(540, 360, C.ink, C.ink)}
${dim(940, 120, 940, 238, '12–16 mm', 940, 274)}
<text x="540" y="300" font-family="Schibsted Grotesk" font-weight="500" font-size="22" fill="${C.graphite}">Cuerpo papel</text>
<text x="540" y="540" font-family="Schibsted Grotesk" font-weight="500" font-size="22" fill="${C.graphite}">Cuerpo tinta</text>
<text x="250" y="560" text-anchor="middle" font-family="Schibsted Grotesk" font-weight="500" font-size="22" fill="${C.graphite}">Vista superior: la rejilla es la trama</text>
</svg>`;
  const note = (t) => `<p style="font-size:24px;line-height:34px;padding:18px 0;border-top:1.5px solid ${C.mist}">${t}</p>`;
  add('objeto-renglon-y-trama', 1600, 1000, page(1600, 1000, `
<div class="abs" style="left:80px;top:72px;width:1000px">
  <h1 class="serif" style="font-size:64px;line-height:1.05">El objeto lleva el <span class="rg">renglón</span></h1>
  <p class="grafito" style="margin-top:22px;font-size:28px;line-height:38px">Una banda azul en la base subraya el lugar donde empieza la actividad. La rejilla del parlante es la trama de puntos de la pantalla.</p>
</div>
<div class="abs" style="left:60px;top:300px">${svg}</div>
<div class="abs" style="left:1140px;top:300px;width:390px">
  ${note('Sin texto ni categoría: la señal es genérica y su sentido viene de lo que preparaste y del lugar (documento 05).')}
  ${note('Medidas: metas de diseño de D‑045, no una especificación de fabricación.')}
  ${note('La prueba usa un parlante Bluetooth comercial (D‑063). Esta lámina muestra cómo llevaría la marca un objeto propio.')}
</div>`));
}

// ---------- 8. Tarjeta de bolsillo (85 × 55 mm a 300 ppp: 1004 × 650) ----------
add('tarjeta-frente', 1004, 650, page(1004, 650, `
<div class="abs" style="left:64px;top:64px">${wordmark({ h: 40 })}</div>
<div class="abs serif" style="left:64px;top:250px;font-size:104px;line-height:1">Vuelve a</div>
<div class="abs" style="left:64px;right:64px;top:470px;display:flex;align-items:flex-end;gap:10px"><div style="flex:1;height:10px;border-radius:999px;background:${C.blue}"></div><span class="serif" style="font-size:104px;line-height:.55">.</span></div>
<p class="abs mono grafito" style="left:64px;bottom:44px;font-size:20px">Escribe lo que quieres hacer.</p>`));
add('tarjeta-reverso', 1004, 650, page(1004, 650, `
<div class="abs" style="left:64px;top:64px">${symbol({ h: 44, ink: C.white, line: C.white })}</div>
<p class="abs" style="left:64px;right:64px;bottom:60px;color:${C.white};font-size:29px;line-height:41px">Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad que quieres tener presente y, cuando se cumple la condición que elegiste, emite una señal breve. Tú decides qué hacer después.</p>`, '', C.blue));

// ---------- 9. Pliego de stickers (1200 × 1200) ----------
{
  const st = (x, y, rot, inner, radius = 999, pad = 10) => `<div class="abs" style="left:${x}px;top:${y}px;transform:rotate(${rot}deg);padding:${pad}px;border-radius:${radius}px;background:${C.white};box-shadow:0 10px 26px rgba(23,24,28,.14),0 2px 6px rgba(23,24,28,.08)">${inner}</div>`;
  const tag = (k) => { const c = CAT[k], f = c.fam; return `<div style="display:flex;align-items:center;gap:14px;padding:18px 34px 18px 24px;border-radius:999px;background:${step(f, 100)};color:${step(f, 800)};font:600 34px/1 'Schibsted Grotesk'">${icon(c.icon, { size: 44, color: step(f, 600), accent: step(f, 600) })}<span>${c.name}</span></div>`; };
  let td = '';
  for (let k = 0; k < 15; k++) td += `<span style="width:26px;height:26px;border-radius:50%;background:${k < 6 ? C.blue : 'transparent'};box-shadow:${k < 6 ? 'none' : `inset 0 0 0 2.5px ${C.blue200}`}"></span>`;
  add('stickers', 1200, 1200, page(1200, 1200, `
${st(80, 80, -6, appIcon({ size: 280, round: true }))}
${st(450, 110, 3, `<div style="padding:46px 60px 40px;background:${C.white}">${wordmark({ h: 92 })}</div>`, 40, 0)}
${st(90, 470, 2, tag('leer'))}
${st(560, 430, -3, tag('moverme'))}
${st(110, 600, -2, tag('crear'))}
${st(620, 590, 4, tag('cuidar'))}
${st(80, 740, 3, tag('compartir'))}
${st(640, 760, -4, tag('aprender'))}
${st(90, 900, -3, `<div style="padding:34px 44px 44px;border-radius:30px;background:${C.paper};width:520px"><div class="serif" style="font-size:84px;line-height:1">Vuelve a</div><div style="margin-top:56px;height:9px;border-radius:999px;background:${C.blue}"></div></div>`, 40)}
${st(700, 930, 5, `<div style="padding:30px 34px;border-radius:30px;background:${C.white};width:420px"><div style="display:grid;grid-template-columns:repeat(8,26px);gap:14px">${td}</div><p style="margin-top:22px;font:600 30px/1 'Schibsted Grotesk'">6 min <span class="grafito" style="font-weight:400">de 15</span></p></div>`, 40)}
${st(890, 300, -5, appIcon({ size: 220, dots: true }), 56)}
${st(395, 405, 8, appIcon({ size: 130, bg: C.ink, ink: C.paper, line: C.blue300, round: true }))}
`, '', '#E9E9E4'));
}

// ---------- Render ----------
(async () => {
  const only = process.argv[2] ? new RegExp(process.argv[2]) : null;
  const ch = await launch();
  try {
    for (const p of pieces) {
      if (only && !only.test(p.name)) continue;
      const file = path.join(DIR, p.name + '.html');
      fs.writeFileSync(file, p.html);
      await ch.size(p.w, p.h);
      await ch.open('file:///' + file.replace(/\\/g, '/'));
      await ch.eval('window.__layout()');
      await ch.eval('new Promise(r => setTimeout(r, 120))');
      await ch.shot(path.join(OUT, p.name + '.png'), p.w, p.h);
      console.log('ok', p.name, Math.round(fs.statSync(path.join(OUT, p.name + '.png')).size / 1024) + ' KB');
    }
  } finally { await ch.close(); }
})();
