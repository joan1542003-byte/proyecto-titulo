// Escribe components/<Comp>/README.md y preview.html, components/index.d.ts y components/bundle.js.
const fs = require('fs');
const path = require('path');
const OUT = path.join(__dirname, '..', 'sistema', 'components');

const B = (id) => '/_blob/' + id;
const FOTO = {
  libro: B('3bf86915b563a259cc1ccc25a91cf9fa'), guitarra: B('6e5e21b8c9f1452e909a8665ae99eeff'), pintar: B('336ad297f99c76f50c1ee6bfcb92fbbe'),
  pan: B('89d7b5b600ba8f7872fb00550cd251ee'), escribir: B('dfc7ab984fb85bed5feba468e39563ca'), aprender: B('91cce8c4672f239f69c61686ea36f7b0'),
};
const SRC = 'ui/components/';
const ORIGIN = (file) => `Escrito a mano desde \`${SRC}${file}\` de la app 2.18 (\`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/\`), con las reglas de 3.0.`;

// Cada componente: nombre, grupo, alto de la ficha, guía (README) y el código de la vista previa.
const C = [];
const add = (name, group, height, readme, demo, extra) => C.push(Object.assign({ name, group, height, readme, demo }, extra || {}));

/* ---------------- Marca ---------------- */
add('Wordmark', 'Marca', 200, `
El logotipo «relevo» en minúsculas sobre su renglón azul: la firma de todas las piezas.

**Cuándo:** en la barra de Inicio, la señal, portadas, afiches y la primera diapositiva. Una vez por pantalla o pieza.

**Qué entrega quien lo usa:**
- \`size\`: alto de las letras en px (22 en la barra de la app; nunca menos de 16, que da 64 px de ancho).
- \`tone\`: \`ink\` (tinta y renglón \`blue\`; en tema oscuro se aclara solo), \`paper\` (papel y renglón \`azul-300\`, sobre tinta) u \`on-blue\` (todo en \`on-blue\`, sobre un fondo \`blue\`).
- \`line={false}\` solo donde el renglón ya está en otra parte de la pieza.

**Construcción:** contornos de Schibsted Grotesk 650 con −3 %. El renglón mide el ancho de la palabra y 0,075 em de alto, con su borde superior a 0,236 em bajo la línea base.

**No:** no se escribe con mayúscula, no se dibuja en azul (azul con renglón azul se lee como enlace), no se estira ni se pone sobre la trama sin una tarjeta.

${ORIGIN('Icons.kt')} El renglón viene de D-098.
`, `
function Demo() {
  return h('div', { className: 'rl-demo' },
    h('div', { className: 'rl-demo-row', style: { gap: 24 } },
      h(R.Wordmark, { size: 44 }),
      h('span', { style: { background: 'var(--tinta)', padding: '18px 22px', borderRadius: 22, display: 'inline-flex' } }, h(R.Wordmark, { size: 30, tone: 'paper' })),
      h('span', { style: { background: 'var(--azul-500)', padding: '18px 22px', borderRadius: 22, display: 'inline-flex' } }, h(R.Wordmark, { size: 30, tone: 'white' }))),
    h('div', { className: 'rl-demo-row' }, h(R.Wordmark, { size: 22 }), h('span', { className: 'rl-demo-cap' }, 'En la barra: 22 px de alto.')));
}`);

add('Subrayado', 'Marca', 170, `
El renglón azul bajo la palabra que importa: la actividad, la idea clave o el lugar.

**Cuándo:** uno por pantalla, lámina o diapositiva. En la app marca la actividad elegida («Vuelve a leer.») y la pestaña elegida; en la presentación, la idea clave.

**Qué entrega quien lo usa:** el texto como \`children\`. \`tone\`: \`blue\` (por omisión), \`on-blue\` sobre fondos azules o \`ink\` cuando el azul ya está en la misma línea.

**Medidas:** grosor de 0,09 em (2 px como mínimo), bajo la línea base y continuo, sin cortes en las letras que bajan. Toma el largo de lo que marca.

**No:**
- bajo texto azul (azul y subrayado juntos parecen un enlace);
- más de uno por pantalla;
- con trazo fino, doble o punteado;
- para enlaces: un enlace se escribe como acción (PlainAction).

Nuevo en 3.0 (D-098): en la app 2.18 el subrayado era una línea de tinta bajo texto azul.
`, `
function Demo() {
  return h('div', { className: 'rl-demo' },
    h('p', { style: { margin: 0, font: '380 44px/48px var(--font-serif)', letterSpacing: '-0.015em' } }, 'Vuelve a ', h(R.Subrayado, null, 'leer'), '.'),
    h('p', { style: { margin: 0, font: '400 17px/26px var(--font-sans)' } }, 'Relevo suena ', h(R.Subrayado, null, 'donde empieza'), ' lo que querías hacer.'));
}`);

add('Icon', 'Marca', 300, `
Un ícono del kit de Relevo (102 dibujos propios) en trazo, con el grosor que pide su tamaño.

**Cuándo:** siempre junto a una palabra, salvo en botones redondos con nombre accesible (\`label\`). Los íconos de acción y de estado son formas conocidas; los propios de Relevo (actividad, para empezar, lugar, parlante, apps elegidas) llevan el renglón en \`blue\`.

**Qué entrega quien lo usa:**
- \`name\`: uno de \`Icon.names\` (por ejemplo \`inicio\`, \`inicio-lleno\`, \`actividad\`, \`senal\`).
- \`size\`: 16, 18, 20, 22, 24, 34, 40 o 56 px.
- \`strokeWidth\`: por omisión sigue al tamaño (16 → 1,9; 20 → 1,8; 24 → 1,75; 32 → 1,6; más → 1,5). Junto a texto en 600 se usa 2,1.
- \`color\`: hereda \`currentColor\`. \`mono\` pinta también el renglón en ese color.
- \`label\`: solo si el ícono va sin palabra.

**Retícula:** 24 con área útil de 20, extremos y uniones redondeados, contorno para lo normal y relleno para lo elegido (\`inicio-lleno\`, \`ruta-llena\`, \`perfil-lleno\`). Los recortes son máscaras: el ícono funciona sobre cualquier fondo.

${ORIGIN('Icons.kt y KitIcons.kt')} 28 dibujos vienen de la propuesta D-098 (26 reemplazan a su par de la app; Ruta y Señal son nuevos) y 3 son sus versiones llenas.
`, `
var SET = ['inicio', 'inicio-lleno', 'ruta', 'ruta-llena', 'perfil', 'perfil-lleno', 'actividad', 'primer-paso', 'lugar', 'parlante', 'apps', 'senal', 'tiempo', 'esperando', 'telefono', 'silenciar', 'comence', 'despues', 'cambie', 'agregar', 'editar', 'borrar', 'listo', 'ajustes'];
function Demo() {
  return h('div', { className: 'rl-demo' },
    h('div', { style: { display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(76px, 1fr))', gap: 8 } },
      SET.map(function (n) { return h('div', { key: n, style: { display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 6, padding: '12px 4px', background: 'var(--card)', borderRadius: 18 } }, h(R.Icon, { name: n, size: 24 }), h('span', { className: 'rl-demo-cap', style: { fontSize: 11, lineHeight: '14px' } }, n)); })),
    h('div', { className: 'rl-demo-row', style: { gap: 18 } }, [16, 20, 24, 32, 48].map(function (s) { return h(R.Icon, { key: s, name: 'parlante', size: s }); }), h('span', { className: 'rl-demo-cap' }, 'El trazo se adelgaza al crecer.')));
}`);

add('Trama', 'Marca', 360, `
La trama de puntos: una foto, un fondo o un ícono hecho de puntos en una sola tinta azul.

**Cuándo:** solo en momentos de marca. La señal (\`mode="senal"\`, late mientras suena), las fotos de actividades en Inicio (\`mode="foto"\`), portadas y afiches (\`mode="campo"\`) y los íconos grandes de momentos de marca (\`mode="icono"\`). No va en cada pantalla.

**Qué entrega quien lo usa:**
- un contenedor con tamaño: el lienzo lo ocupa entero;
- \`mode\` y, según el modo, \`src\` (una foto del mismo origen), \`icon\` y \`grid\` (12 o 16);
- \`pitch\`: 6 px en pantalla (por omisión), 4 px en fotos pequeñas;
- \`label\` si la trama comunica algo (una foto de actividad); si es fondo, se oculta a los lectores de pantalla.

**Reglas:**
- El punto crece con la sombra, de 16 % a 104 % de la distancia entre puntos.
- Todo texto sobre la trama va en una tarjeta de vidrio o sólida; nunca suelto encima.
- La animación se detiene fuera de la vista y cuando el sistema pide reducir el movimiento.

Nuevo en 3.0 (D-098 v3): la trama son los píxeles de la pantalla y la rejilla del parlante.
`, `
function Demo() {
  var box = { height: 200, borderRadius: 22, overflow: 'hidden', background: 'var(--card)' };
  return h('div', { className: 'rl-demo' },
    h('div', { style: { display: 'grid', gridTemplateColumns: '1.3fr 1fr 1fr', gap: 12 } },
      h('figure', { style: { margin: 0 } }, h('div', { style: box }, h(R.Trama, { mode: 'senal' })), h('figcaption', { className: 'rl-demo-cap' }, 'Señal: late mientras suena')),
      h('figure', { style: { margin: 0 } }, h('div', { style: Object.assign({}, box, { background: 'var(--card)' }) }, h(R.Trama, { mode: 'foto', src: '${FOTO.libro}', label: 'Un libro abierto, en trama' })), h('figcaption', { className: 'rl-demo-cap' }, 'Foto de «leer» en trama')),
      h('figure', { style: { margin: 0 } }, h('div', { style: Object.assign({}, box, { padding: 28, boxSizing: 'border-box' }) }, h(R.Trama, { mode: 'icono', icon: 'parlante', grid: 16 })), h('figcaption', { className: 'rl-demo-cap' }, 'Parlante en 16 × 16 puntos'))));
}`);

add('TimeDots', 'Marca', 150, `
El tiempo en puntos: cada punto es un minuto en las apps elegidas y los llenos son los que ya pasaron.

**Cuándo:** en la tarjeta del relevo activo (Inicio) y en el detalle, mientras Relevo cuenta. «6 de 15» se ve como seis puntos llenos.

**Qué entrega quien lo usa:** \`value\` (minutos contados) y \`total\` (minutos hasta la señal). Sobre 60 minutos, cada punto vale 5. \`caption={false}\` oculta la cifra cuando ya está escrita al lado.

**Accesibilidad:** los puntos se leen como «6 de 15 minutos»; la cifra escrita repite el dato, así que el color no es la única pista.

Nuevo en 3.0 (D-098 v3). Reemplaza a la barra de avance en la tarjeta del relevo activo.
`, `
function Demo() {
  var s = React.useState(6), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo' },
    h(R.TimeDots, { value: v, total: 15 }),
    h('div', { className: 'rl-demo-row' }, h(R.Button, { kind: 'secondary', compact: true, onClick: function () { set(Math.min(15, v + 1)); } }, 'Sumar un minuto'), h(R.PlainAction, { color: 'var(--graphite)', onClick: function () { set(0); } }, 'Reiniciar')));
}`);

/* ---------------- Acciones ---------------- */
add('Button', 'Acciones', 300, `
El botón en cápsula: 56 px de alto y ancho completo, o compacto dentro de una tarjeta.

**Cuándo:** \`primary\` (tinta) para la acción principal, una por pantalla y abajo, al alcance del pulgar. \`secondary\` (niebla) para la alternativa. \`destructive\` solo para borrar o eliminar, siempre con confirmación.

**Qué entrega quien lo usa:**
- la etiqueta como \`children\`: un verbo, sin punto final («Seguir», «Probar el sonido», «Eliminar este relevo»);
- \`kind\`, \`compact\`, \`icon\` (nombre de Icon) y \`onClick\`;
- \`disabled\` solo si no hay nada que explicar; si falta algo, usar GuardedButton.

**Comportamiento:** al presionar se hunde a 97 % (95 % el compacto) y el relleno pasa a \`slate\`, \`line\` o \`error\` al 15 %. Sin ondas ni rebotes.

**No:** botones azules (el azul es el renglón y el tiempo) ni más de una acción principal por pantalla.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } },
    h(R.Button, null, 'Seguir'),
    h(R.Button, { kind: 'secondary', icon: 'probar' }, 'Probar el sonido'),
    h('div', { className: 'rl-demo-row' }, h(R.Button, { compact: true }, 'Listo'), h(R.Button, { compact: true, kind: 'secondary' }, 'Más tarde'), h(R.Button, { compact: true, kind: 'destructive', icon: 'borrar' }, 'Eliminar'), h(R.Button, { compact: true, disabled: true }, 'Sin conexión')));
}`);

add('GuardedButton', 'Acciones', 220, `
Un botón que dice qué falta: si \`missing\` tiene texto, se ve apagado pero responde mostrando el aviso encima.

**Cuándo:** en pasos con campos obligatorios («Seguir» sin actividad escrita). Reemplaza al botón deshabilitado, que no explica nada.

**Qué entrega quien lo usa:** \`missing\` (qué falta, como frase: «Escribe qué quieres hacer o toca una idea.») o \`null\`; \`onClick\`; \`onMissing\` para registrar qué faltó.

**Comportamiento:** el primer toque muestra el aviso (MissingHint) y vibra; si se toca otra vez, el aviso crece un instante. El aviso es neutro, nunca rojo: no es un error de la persona. Al completar lo que faltaba, se va.

${ORIGIN('Controls.kt')} Nuevo en la app 2.18 (D-097).
`, `
function Demo() {
  var s = React.useState(''), text = s[0], set = s[1];
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } },
    h(R.RenglonField, { label: 'Actividad', placeholder: 'Leer 10 páginas', value: text, onChange: set }),
    h(R.GuardedButton, { missing: text.trim() ? null : 'Escribe qué quieres hacer o toca una idea.' }, 'Seguir'));
}`);

add('MissingHint', 'Acciones', 110, `
Qué falta completar, en una cápsula clara con el ícono de información.

**Cuándo:** lo muestra GuardedButton sobre el botón. Sirve solo para avisos breves y neutros; para errores del sistema, usar Notice con \`tone="error"\`.

**Qué entrega quien lo usa:** \`text\`, una frase que dice qué hacer, con punto final.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 440 } }, h(R.MissingHint, { text: 'Escribe qué quieres hacer o toca una idea.' }));
}`);

add('PlainAction', 'Acciones', 120, `
Una acción de texto, con área táctil de 48 px.

**Cuándo:** acciones secundarias dentro de una sección o un aviso («Ver todas», «Probar otra vez») y el cierre de una hoja sin vidrio.

**Qué entrega quien lo usa:** la etiqueta, \`onClick\`, \`icon\` opcional y \`color\` (\`ink\` por omisión; \`graphite\` para acciones menores).

**Comportamiento:** al presionar baja a la mitad de opacidad.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row', style: { gap: 20 } },
    h(R.PlainAction, { icon: 'probar' }, 'Probar otra vez'), h(R.PlainAction, { color: 'var(--graphite)' }, 'Ver todas'), h(R.PlainAction, { disabled: true }, 'Sin conexión')));
}`);

add('IconAction', 'Acciones', 110, `
Botón redondo de ícono: 44 px y nombre accesible.

**Cuándo:** acciones dentro del contenido (borrar lo escrito, más opciones). En la barra superior se usa GlassIconButton.

**Qué entrega quien lo usa:** \`icon\`, \`label\` (lo que lee el lector de pantalla), \`onClick\` y \`filled\` para mostrar el relleno de niebla en reposo.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row' },
    h(R.IconAction, { icon: 'mas', label: 'Más opciones' }), h(R.IconAction, { icon: 'editar', label: 'Editar', filled: true }), h(R.IconAction, { icon: 'cerrar', label: 'Cerrar' })));
}`);

add('GlassIconButton', 'Acciones', 150, `
Botón redondo de vidrio para la barra: volver, cerrar, más opciones.

**Cuándo:** solo en la capa de navegación (barra superior, sobre fotos que llegan al borde). El vidrio deja ver, desenfocado, lo que pasa detrás.

**Qué entrega quien lo usa:** \`icon\`, \`label\` y \`onClick\`. \`size\`: 44 px por omisión.

**Reglas:** el vidrio es \`glass\` con un desenfoque de 12 px y un borde de 0,75 px en \`glass-edge\`. Sin brillos, reflejos ni degradados de luz. El contenido nunca va en vidrio.

${ORIGIN('Glass.kt')}
`, `
function Demo() {
  return h('div', { style: { position: 'relative', height: 150, overflow: 'hidden' } },
    h('div', { style: { position: 'absolute', inset: 0 } }, h(R.Trama, { mode: 'campo', seed: 2.2 })),
    h('div', { className: 'rl-demo-row', style: { position: 'relative', padding: 20 } },
      h(R.GlassIconButton, { icon: 'volver', label: 'Volver' }), h(R.GlassIconButton, { icon: 'cerrar', label: 'Cerrar' }), h(R.GlassIconButton, { icon: 'mas', label: 'Más opciones' })));
}`);

add('GlassTextButton', 'Acciones', 150, `
Botón de texto en una cápsula de vidrio: «Saltar», «Listo».

**Cuándo:** en la barra superior y en el encabezado de una hoja (Sheet), para cerrar o saltar un paso.

**Qué entrega quien lo usa:** la etiqueta, \`onClick\`, \`icon\` opcional y \`color\`.

${ORIGIN('Glass.kt')}
`, `
function Demo() {
  return h('div', { style: { position: 'relative', height: 150, overflow: 'hidden' } },
    h('div', { style: { position: 'absolute', inset: 0 } }, h(R.Trama, { mode: 'campo', seed: 3.1 })),
    h('div', { className: 'rl-demo-row', style: { position: 'relative', padding: 20 } }, h(R.GlassTextButton, null, 'Listo'), h(R.GlassTextButton, { icon: 'siguiente' }, 'Saltar')));
}`);

/* ---------------- Selección ---------------- */
add('SegmentedControl', 'Selección', 170, `
Control segmentado: una pista en cápsula y una cápsula clara que se desliza hasta la opción elegida.

**Cuándo:** de dos a cinco opciones cortas y excluyentes (tema, tamaño del texto, una escala). Tocar la elegida la desmarca cuando la pregunta se puede omitir.

**Qué entrega quien lo usa:** \`options\` como \`[valor, etiqueta]\` o \`{value, label}\`, \`value\`, \`onChange\`, \`label\` para el grupo y \`allowDeselect={false}\` si la respuesta es obligatoria.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  var s = React.useState('auto'), v = s[0], set = s[1];
  var t = React.useState(null), v2 = t[0], set2 = t[1];
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } },
    h(R.SegmentedControl, { label: 'Tema', options: [['light', 'Claro'], ['dark', 'Oscuro'], ['auto', 'Automático']], value: v, onChange: set, allowDeselect: false }),
    h(R.SegmentedControl, { label: '¿Cómo te fue?', options: [['bien', 'Bien'], ['regular', 'Regular'], ['mal', 'Mal']], value: v2, onChange: set2 }));
}`);

add('ScaleControl', 'Selección', 130, `
Escala de 1 a 5 con sus extremos nombrados.

**Cuándo:** preguntas de la prueba y de las encuestas breves. Se puede dejar sin responder.

**Qué entrega quien lo usa:** \`value\` (1–5 o \`null\`), \`onChange\`, \`low\` y \`high\` («Nada» y «Mucho» por omisión).

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  var s = React.useState(4), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } }, h(R.ScaleControl, { value: v, onChange: set, label: '¿Cuánto te ayudó?' }));
}`);

add('QuickChoice', 'Selección', 140, `
Opción rápida en cápsula: relleno suave; la elegida, en tinta.

**Cuándo:** ideas para empezar («Leer», «Dibujar», «Salir a caminar») y respuestas de un toque. Para opciones con imagen, usar PictureTile.

**Qué entrega quien lo usa:** la etiqueta, \`selected\`, \`onClick\` e \`icon\` opcional.

${ORIGIN('Controls.kt')}
`, `
var IDEAS = ['Leer', 'Dibujar', 'Salir a caminar', 'Ordenar', 'Cocinar', 'Tocar guitarra'];
function Demo() {
  var s = React.useState('Leer'), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row', style: { gap: 8 } },
    IDEAS.map(function (i) { return h(R.QuickChoice, { key: i, selected: v === i, onClick: function () { set(v === i ? null : i); } }, i); })));
}`);

add('CheckMark', 'Selección', 110, `
Marca de selección redonda: el círculo se llena de tinta y la marca se dibuja con el trazo.

**Cuándo:** listas con varias elecciones (apps elegidas, intereses) y la esquina de una PictureTile elegida.

**Qué entrega quien lo usa:** \`checked\` y \`size\` (24 px; 22 en fichas). Va dentro de un control que tiene el rol y el nombre.

**3.0:** el borde sin marcar pasa de \`gray\` (2,56:1 sobre \`card\`) a \`graphite\` (6,23:1), para que el control se vea con 3:1 o más.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  var s = React.useState(true), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row', style: { gap: 18 } },
    h('button', { type: 'button', onClick: function () { set(!v); }, style: { border: 0, background: 'none', padding: 0, cursor: 'pointer' }, 'aria-pressed': v }, h(R.CheckMark, { checked: v })),
    h(R.CheckMark, { checked: false }), h(R.CheckMark, { checked: true, size: 22 }), h('span', { className: 'rl-demo-cap' }, 'Toca la primera.')));
}`);

add('RadioMark', 'Selección', 110, `
Opción única: un anillo con un punto que crece al elegirla.

**Cuándo:** listas de opciones excluyentes dentro de filas (ListRow con \`trailing\`).

**Qué entrega quien lo usa:** \`selected\`. El rol y el nombre van en la fila que lo contiene.

**3.0:** el anillo sin elegir es \`graphite\` en vez de \`gray\`, por contraste.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row', style: { gap: 18 } }, h(R.RadioMark, { selected: true }), h(R.RadioMark, { selected: false })));
}`);

add('StarRating', 'Selección', 120, `
Estrellas para opinar sobre la app o la prueba; nunca califican a la persona ni lo que hizo (D-073).

**Qué entrega quien lo usa:** \`value\` (1–5 o \`null\`), \`onChange\` y \`label\`. Tocar la estrella elegida la quita.

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  var s = React.useState(4), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo' }, h(R.StarRating, { value: v, onChange: set, label: '¿Qué tal te va con Relevo?' }));
}`);

add('DurationStepper', 'Selección', 150, `
Selector de tiempo con − y +: la cifra cambia con un leve desenfoque y mantener presionado repite el paso.

**Cuándo:** cuánto uso en las apps elegidas antes de que suene (Preparar). Pasos de 1 minuto hasta 10, de 5 hasta 60, de 15 hasta 120 y de 30 después; de 1 minuto a 6 horas.

**Qué entrega quien lo usa:** \`seconds\`, \`onChange\` y \`label\` («Después de este uso en tus apps»).

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  var s = React.useState(900), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } }, h(R.DurationStepper, { seconds: v, onChange: set, label: 'Después de este uso en tus apps' }));
}`);

add('CountStepper', 'Selección', 110, `
Cantidad con − y +, para la constancia elegida.

**Qué entrega quien lo usa:** \`value\`, \`min\`, \`max\`, \`onChange\` y \`label\` ya escrito con la cifra («3 días por semana»).

${ORIGIN('Controls.kt')}
`, `
function Demo() {
  var s = React.useState(3), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } }, h(R.CountStepper, { value: v, min: 1, max: 7, onChange: set, label: v + (v === 1 ? ' día por semana' : ' días por semana') }));
}`);

/* ---------------- Campos ---------------- */
add('RenglonField', 'Campos', 200, `
El renglón: lo que escribe la persona, en tinta, sobre una línea azul.

**Cuándo:** el campo de la actividad, de cómo empieza y de dónde. Es el lugar donde la persona pone sus palabras; por eso es el recurso de marca dentro de la app.

**Qué entrega quien lo usa:** \`label\` (rótulo como frase), \`placeholder\` (un ejemplo real, en \`graphite\`), \`value\` y \`onChange\` (o \`defaultValue\`), \`maxLength\` (120).

**Medidas:** texto en \`voice\` (20/26, 500); línea de 1,5 px en \`blue\`, que pasa a 2,5 px con el foco; cursor azul.

**3.0:** en la app 2.18 el texto iba en azul sobre una línea de tinta. Ahora el texto es tinta y la línea es azul: el azul marca el lugar, no las palabras.

${ORIGIN('Fields.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 420, gap: 22 } },
    h(R.RenglonField, { label: 'Actividad', defaultValue: 'Leer 10 páginas' }),
    h(R.RenglonField, { label: 'Cómo empieza', placeholder: 'Abrir el libro' }));
}`);

add('RenglonArea', 'Campos', 190, `
Texto largo sobre el renglón, para comentarios.

**Qué entrega quien lo usa:** lo mismo que RenglonField; acepta hasta 600 caracteres y crece en líneas.

${ORIGIN('Fields.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 440 } }, h(R.RenglonArea, { label: 'Comentario', placeholder: 'Lo que quieras contarnos sobre esta semana.' }));
}`);

add('SearchField', 'Campos', 110, `
Buscador sobre niebla: con lupa y un botón para borrar lo escrito.

**Cuándo:** listas largas (apps del teléfono, actividades guardadas).

**Qué entrega quien lo usa:** \`placeholder\` («Buscar apps»), \`value\` y \`onChange\` (o \`defaultValue\`).

${ORIGIN('Fields.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } }, h(R.SearchField, { placeholder: 'Buscar apps', defaultValue: 'Insta' }));
}`);

add('Signature', 'Campos', 300, `
La firma «Vuelve a ___.»: las palabras de la persona en tinta, sobre el renglón azul.

**Cuándo:** la tarjeta del relevo activo (\`variant="card"\`), el título de un relevo (\`title\`) y la señal (\`signal\`). \`sans\` repite la firma de la app 2.18.

**Qué entrega quien lo usa:** \`words\` (lo que escribió la persona; se quita el punto final y se pasa la primera letra a minúscula), \`variant\`, \`prefix\` («Vuelve a » por omisión) y \`animate\`.

**Movimiento:** el renglón está desde el comienzo y las letras se escriben encima en 450 ms, lineal. Es la única animación de marca; si el sistema pide reducir el movimiento, aparece entera.

**3.0:** titulares en serif (Newsreader 380) y el renglón azul bajo la frase de la persona, en vez de texto azul con línea de tinta.

${ORIGIN('Fields.kt')}
`, `
function Demo() {
  var s = React.useState(0), k = s[0], set = s[1];
  return h('div', { className: 'rl-demo', style: { gap: 18 } },
    h(R.Signature, { key: 'a' + k, words: 'Leer', variant: 'signal' }),
    h(R.Signature, { key: 'b' + k, words: 'Salir a caminar', variant: 'card' }),
    h('div', null, h(R.PlainAction, { icon: 'reintentar', color: 'var(--graphite)', onClick: function () { set(k + 1); } }, 'Escribir de nuevo')));
}`);

/* ---------------- Listas ---------------- */
add('ListSection', 'Listas', 330, `
Sección agrupada: título breve escrito como frase, tarjeta clara de esquinas amplias y filas separadas por una línea fina.

**Qué entrega quien lo usa:** \`title\` (opcional), \`footer\` (opcional) y filas (ListRow, FactRow) como \`children\`. La línea entre filas empieza después del ícono.

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 440 } },
    h(R.ListSection, { title: 'Ajustes', footer: 'Puedes cambiarlos cuando quieras.' },
      h(R.ListRow, { icon: 'avisos', title: 'Avisos y resúmenes', chevron: true, onClick: function () {} }),
      h(R.ListRow, { icon: 'tema', title: 'Apariencia', value: 'Automática', chevron: true, onClick: function () {} }),
      h(R.ListRow, { icon: 'privacidad', title: 'Tus datos', chevron: true, onClick: function () {} })));
}`);

add('ListRow', 'Listas', 430, `
Fila dentro de una sección: ícono, texto, valor y destino. Al presionarla se oscurece.

**Qué entrega quien lo usa:**
- \`title\` y \`subtitle\` opcional;
- \`icon\` o \`leading\` (un Avatar, una miniatura);
- \`value\` alineado al final; con \`valueIsVoice\` va en \`voice\` porque lo escribió la persona;
- \`trailing\` (un RadioMark, un CheckMark), \`chevron\` y \`onClick\`.

**Medidas:** alto mínimo de 54 px; relleno de 12, 16, 12 y 18 px; el rótulo conserva su ancho hasta el 58 % y el valor usa el resto, con dos líneas como máximo.

**3.0:** la flecha de destino pasa de \`gray\` a \`graphite\`, por contraste.

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  var s = React.useState('15'), v = s[0], set = s[1];
  function opt(val, label) { return h(R.ListRow, { key: val, title: label, trailing: h(R.RadioMark, { selected: v === val }), onClick: function () { set(val); } }); }
  return h('div', { className: 'rl-demo', style: { maxWidth: 440 } },
    h(R.ListSection, null,
      h(R.ListRow, { icon: 'actividad', title: 'Actividad', value: 'Leer 10 páginas', valueIsVoice: true }),
      h(R.ListRow, { leading: h(R.Avatar, { name: 'Ana', size: 30 }), title: 'Tu perfil', subtitle: 'Código, intereses y apariencia', chevron: true, onClick: function () {} })),
    h(R.ListSection, { title: 'Después de cuánto uso' }, opt('15', '15 min'), opt('30', '30 min'), opt('45', '45 min')));
}`);

add('FactRow', 'Listas', 240, `
Dato con su rótulo, para resúmenes: «Cómo empieza · Abrir el libro». Lo que escribió la persona va en \`voice\`.

**Qué entrega quien lo usa:** \`icon\`, \`label\`, \`value\`, \`valueIsVoice\` (verdadero por omisión) y \`onClick\` si se puede editar.

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 440 } }, h(R.ListSection, null,
    h(R.FactRow, { icon: 'actividad', label: 'Actividad', value: 'Leer 10 páginas' }),
    h(R.FactRow, { icon: 'primer-paso', label: 'Cómo empieza', value: 'Abrir el libro', onClick: function () {} }),
    h(R.FactRow, { icon: 'lugar', label: 'Dónde', value: 'Junto al sillón' }),
    h(R.FactRow, { icon: 'tiempo', label: 'Después de', value: '15 min', valueIsVoice: false })));
}`);

add('IconTile', 'Listas', 100, `
El ícono de una fila: el trazo del kit en una caja de 30 px, sin baldosa de color (nada de bloques cuadrados, D-083).

**Qué entrega quien lo usa:** \`icon\` y \`tint\` opcional. ListRow lo agrega solo cuando recibe \`icon\`.

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row' }, ['actividad', 'lugar', 'parlante', 'apps', 'tiempo'].map(function (n) { return h(R.IconTile, { key: n, icon: n }); })));
}`);

add('Notice', 'Listas', 330, `
Aviso: dice qué pasó y qué hacer.

**Cuándo:** \`info\` para explicar un estado («Tu primer relevo está activo»); \`error\` para fallas del sistema (sin conexión, permiso retirado), con un tinte rojo suave. Nunca se usa para errores de la persona.

**Qué entrega quien lo usa:** \`text\`, \`title\` opcional, \`icon\` (\`info\` por omisión), \`tone\` y \`actions\` (PlainAction).

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 460 } },
    h(R.Notice, { title: 'Tu primer relevo está activo', text: 'Cuando suene, la app te dirá qué hacer. Puedes ver o desactivar el relevo en Inicio.', icon: 'comence' }),
    h(R.Notice, { tone: 'error', title: 'Sin conexión', text: 'Guardamos tus respuestas y las enviamos cuando vuelva la conexión.', actions: h(R.PlainAction, { icon: 'reintentar' }, 'Reintentar') }));
}`);

add('StatusChip', 'Listas', 110, `
Estado breve en cápsula: «Contando», «Suena en el parlante». Sobre una tarjeta, va en papel.

**Qué entrega quien lo usa:** \`icon\`, \`text\` y \`onPanel\` cuando va dentro de un Panel o una tarjeta.

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row' },
    h(R.StatusChip, { icon: 'esperando', text: 'Contando' }), h(R.StatusChip, { icon: 'senal', text: 'Suena en el parlante' }),
    h('span', { style: { background: 'var(--card)', padding: 10, borderRadius: 20 } }, h(R.StatusChip, { icon: 'pausar', text: 'En pausa', onPanel: true }))));
}`);

add('Panel', 'Listas', 270, `
Tarjeta clara de esquinas amplias para contenido agrupado.

**Qué entrega quien lo usa:** el contenido y \`padding\` (20 px por omisión). Los elementos se separan 8 px.

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } }, h(R.Panel, null,
    h(R.StatusChip, { icon: 'esperando', text: 'Contando', onPanel: true }),
    h(R.Signature, { words: 'Leer', variant: 'card', animate: false }),
    h('p', { style: { margin: 0, font: '400 15px/21px var(--font-sans)', color: 'var(--graphite)' } }, 'Sonará junto al sillón cuando sumes 15 min en tus apps.'),
    h(R.TimeDots, { value: 6, total: 15, dense: true })));
}`);

add('SectionHeader', 'Listas', 110, `
Título de una sección con una acción opcional a la derecha: «Ideas · Ver todas».

**Qué entrega quien lo usa:** \`title\` (en \`title2\`), \`action\` y \`onAction\`.

${ORIGIN('Lists.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 440 } }, h(R.SectionHeader, { title: 'Ideas', action: 'Ver todas', onAction: function () {} }));
}`);

/* ---------------- Fotos ---------------- */
add('PhotoCard', 'Fotos', 330, `
Ficha de actividad: foto 4:5 con el nombre debajo, sobre papel; el texto nunca va sobre la foto.

**Cuándo:** carruseles de actividades e ideas. Las fotos muestran el comienzo, no el resultado.

**Qué entrega quien lo usa:** \`title\`, \`subtitle\` opcional, \`onClick\` y una imagen: \`src\` (foto), \`src\` con \`trama\` (la foto en una sola tinta azul) o \`icon\` (ícono sobre niebla). \`width\`: 152 px.

**3.0:** en Inicio, la foto de la actividad activa va en trama; en los carruseles, la foto normal.

${ORIGIN('Photos.kt')} Fotos CC0 de la app (ver el grupo Fotos).
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h(R.Carousel, null,
    h(R.PhotoCard, { title: 'Leer', subtitle: 'Abrir el libro', src: '${FOTO.libro}', alt: 'Un libro abierto' }),
    h(R.PhotoCard, { title: 'Leer', subtitle: 'En trama', src: '${FOTO.libro}', trama: true, alt: 'Un libro abierto, en trama' }),
    h(R.PhotoCard, { title: 'Tocar guitarra', src: '${FOTO.guitarra}', alt: 'Una guitarra' }),
    h(R.PhotoCard, { title: 'Ordenar', icon: 'ordenar' })));
}`);

add('PictureTile', 'Fotos', 330, `
Ficha elegible en una cuadrícula: la elegida se encoge un poco dentro de un anillo de tinta concéntrico y muestra una marca redonda.

**Qué entrega quien lo usa:** \`selected\`, \`onClick\`, una imagen (\`src\`, \`trama\` o \`icon\`), \`label\`, \`aspect\` (0,8), \`cornerRadius\` (22) y \`prominent\` para rótulos grandes (intereses).

${ORIGIN('Photos.kt')}
`, `
function Demo() {
  var s = React.useState('pan'), v = s[0], set = s[1];
  var items = [['pan', 'Hacer pan', '${FOTO.pan}'], ['pintar', 'Pintar', '${FOTO.pintar}'], ['escribir', 'Escribir', '${FOTO.escribir}'], ['caminar', 'Caminar', null]];
  return h('div', { className: 'rl-demo' }, h('div', { style: { display: 'grid', gridTemplateColumns: 'repeat(4, minmax(0, 1fr))', gap: 12, maxWidth: 560 } },
    items.map(function (it) { return h(R.PictureTile, { key: it[0], label: it[1], src: it[2] || undefined, icon: it[2] ? undefined : 'caminar', selected: v === it[0], onClick: function () { set(it[0]); } }); })));
}`);

add('PhotoHero', 'Fotos', 470, `
Foto grande con una banda de vidrio abajo: la foto sigue a la vista y el texto se lee sobre un desenfoque que crece hacia el borde, sin velos opacos.

**Qué entrega quien lo usa:** una imagen (\`src\`, \`trama\` o \`icon\`), el contenido de la banda como \`children\`, \`aspect\` (0,9), \`dark\` cuando la foto es oscura bajo el texto (la banda toma el tema oscuro) y \`onClick\` con \`clickLabel\` si toda la ficha se puede tocar.

${ORIGIN('Photos.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { style: { display: 'grid', gridTemplateColumns: 'repeat(2, minmax(0, 260px))', gap: 16 } },
    h(R.PhotoHero, { src: '${FOTO.libro}', alt: 'Un libro abierto' }, h(R.StatusChip, { icon: 'esperando', text: 'Contando' }), h(R.Signature, { words: 'Leer', variant: 'card', animate: false })),
    h(R.PhotoHero, { src: '${FOTO.libro}', trama: true, alt: 'Un libro abierto, en trama' }, h(R.Signature, { words: 'Leer', variant: 'card', animate: false }), h(R.TimeDots, { value: 6, total: 15, dense: true }))));
}`);

add('Avatar', 'Fotos', 130, `
La imagen de la persona: el emoji que eligió, en un círculo. Sin emoji, la inicial de su nombre o el ícono de perfil.

**Qué entrega quien lo usa:** \`size\`, \`name\` y, si eligió uno, \`src\` (el PNG del emoji Noto 3D de la app) o \`emoji\` (el carácter, solo en maquetas web). \`label\` para el lector de pantalla.

**Nota:** la app usa los emoji Noto 3D de Google (OFL) como imagen; aquí el carácter es un sustituto para maquetas.

${ORIGIN('Photos.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row', style: { gap: 16 } },
    h(R.Avatar, { size: 72, emoji: '📚', label: 'Libros' }), h(R.Avatar, { size: 72, name: 'Ana' }), h(R.Avatar, { size: 72 }), h(R.Avatar, { size: 34, name: 'Ana' })));
}`);

add('EmojiTile', 'Fotos', 150, `
Emoji elegible en un círculo; el elegido se encoge dentro de un anillo de tinta.

**Qué entrega quien lo usa:** \`selected\`, \`onClick\`, \`label\` y \`src\` (el PNG Noto 3D) o \`emoji\` (sustituto web). Ocupa el ancho de su celda.

${ORIGIN('Photos.kt')}
`, `
var EM = [['libros', '📚', 'Libros'], ['guitarra', '🎸', 'Guitarra'], ['planta', '🪴', 'Planta'], ['cafe', '☕', 'Taza de café'], ['zapatilla', '👟', 'Zapatilla']];
function Demo() {
  var s = React.useState('libros'), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo' }, h('div', { style: { display: 'grid', gridTemplateColumns: 'repeat(5, 64px)', gap: 12 } },
    EM.map(function (e) { return h(R.EmojiTile, { key: e[0], emoji: e[1], label: e[2], selected: v === e[0], onClick: function () { set(e[0]); } }); })));
}`);

/* ---------------- Estructura ---------------- */
add('Screen', 'Estructura', 700, `
Marco de pantalla de la app: barra de vidrio arriba, título, contenido que se desplaza y una acción principal flotante abajo.

**Qué entrega quien lo usa:**
- \`title\` (en serif \`displayTitle\` en 3.0; \`serif={false}\` vuelve a \`largeTitle\`), \`eyebrow\` y \`subtitle\`;
- \`onBack\` con \`closeIcon\` en las hojas de creación;
- \`progress\` y \`step\` para recorridos por pasos;
- \`trailing\`, \`header\` y \`bottom\` (la acción principal);
- el contenido como \`children\` y un contenedor con alto (\`height\`).

**Comportamiento:** el contenido pasa bajo la barra y se desenfoca; el título sube a la barra al desplazar. Margen de 20 px.

${ORIGIN('Screen.kt')} Versión web simplificada: sin la foto que llega al borde superior ni el tono de la barra de estado.
`, `
function Demo() {
  var s = React.useState(''), v = s[0], set = s[1];
  var ideas = ['Leer', 'Dibujar', 'Salir a caminar', 'Ordenar'];
  return h('div', { className: 'rl-demo', style: { alignItems: 'center' } }, h('div', { className: 'rl-demo-phone' },
    h(R.Screen, { title: '¿Qué quieres hacer?', onBack: function () {}, closeIcon: true, progress: 0.25, step: '1 de 4',
      bottom: h(R.GuardedButton, { missing: v.trim() ? null : 'Escribe qué quieres hacer o toca una idea.' }, 'Seguir') },
      h('div', { style: { display: 'flex', flexDirection: 'column', gap: 18 } },
        h(R.RenglonField, { label: 'Actividad', placeholder: 'Leer 10 páginas', value: v, onChange: set }),
        h('div', { className: 'rl-demo-row', style: { gap: 8 } }, ideas.map(function (i) { return h(R.QuickChoice, { key: i, selected: v === i, onClick: function () { set(i); } }, i); }))))));
}`);

add('StepProgress', 'Estructura', 100, `
Avance de un recorrido por pasos: una cápsula fina de 112 px que se llena, con su lectura para lectores de pantalla.

**Qué entrega quien lo usa:** \`progress\` (0–1) y \`step\` («2 de 4»). Screen lo pone en la barra cuando recibe \`progress\`.

**3.0:** se llena en \`blue\` (dónde estás); en la app 2.18 era tinta.

${ORIGIN('Screen.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h('div', { className: 'rl-demo-row', style: { gap: 24 } }, h(R.StepProgress, { progress: 0.25, step: '1 de 4' }), h(R.StepProgress, { progress: 0.75, step: '3 de 4' })));
}`);

add('ProgressLine', 'Estructura', 120, `
Avance continuo del tiempo contado: una cápsula que se llena.

**Cuándo:** detalle del relevo y lugares sin espacio para TimeDots.

**Qué entrega quien lo usa:** \`progress\` (0–1), \`label\` y \`height\` (6 px).

**3.0:** se llena en \`blue\`, porque es tiempo; en la app 2.18 era tinta.

${ORIGIN('Screen.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo', style: { maxWidth: 420 } }, h(R.ProgressLine, { progress: 0.4, label: '6 de 15 minutos' }), h('p', { className: 'rl-demo-cap' }, '6 min de 15'));
}`);

add('Carousel', 'Estructura', 330, `
Carrusel horizontal que llega a los bordes y se detiene con cada ficha alineada al margen.

**Qué entrega quien lo usa:** fichas (PhotoCard) como \`children\`, \`spacing\` (12 px) y \`bleed={false}\` si no está dentro del margen de 20 px de una pantalla.

${ORIGIN('Screen.kt')}
`, `
function Demo() {
  return h('div', { className: 'rl-demo' }, h(R.Carousel, null,
    h(R.PhotoCard, { title: 'Hacer pan', subtitle: 'Sacar la harina', src: '${FOTO.pan}' }),
    h(R.PhotoCard, { title: 'Pintar', subtitle: 'Mojar el pincel', src: '${FOTO.pintar}' }),
    h(R.PhotoCard, { title: 'Escribir', subtitle: 'Abrir el cuaderno', src: '${FOTO.escribir}' }),
    h(R.PhotoCard, { title: 'Aprender', subtitle: 'Leer la primera página', src: '${FOTO.aprender}' })));
}`);

add('Sheet', 'Estructura', 520, `
Hoja flotante de vidrio: sube desde abajo, separada de los bordes, y deja ver desenfocado lo que hay detrás.

**Cuándo:** elegir algo sin dejar la pantalla (emoji, apps, una confirmación con detalle). Se cierra tocando fuera, con Escape, con el gesto de volver o con \`done\`.

**Qué entrega quien lo usa:** \`open\`, \`onDismiss\`, \`title\`, \`done\` («Listo»), \`tall\` para listas largas, el contenido e \`inline\` cuando va dentro de un contenedor (maquetas).

${ORIGIN('Sheet.kt')}
`, `
function Demo() {
  var s = React.useState(true), open = s[0], set = s[1];
  return h('div', { className: 'rl-demo', style: { alignItems: 'center' } }, h('div', { className: 'rl-demo-phone', style: { height: 460 } },
    h(R.Screen, { title: 'Perfil', serif: false }, h(R.Button, { kind: 'secondary', onClick: function () { set(true); } }, 'Abrir la hoja')),
    h(R.Sheet, { open: open, inline: true, title: 'Tu imagen', done: 'Listo', onDismiss: function () { set(false); } },
      h('div', { style: { display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 10 } },
        ['📚', '🎸', '🪴', '☕', '👟', '🎨', '🧩', '🚲'].map(function (e, i) { return h(R.EmojiTile, { key: i, emoji: e, label: 'Emoji ' + (i + 1), selected: i === 0 }); })))));
}`);

add('TabBar', 'Estructura', 140, `
Barra de pestañas flotante: una cápsula de vidrio separada de los bordes, con una cápsula más clara que se desliza al destino elegido.

**Qué entrega quien lo usa:** \`items\` (\`label\`, \`icon\` e \`iconSelected\`), \`selected\` y \`onSelect\`. Los destinos de la app son Inicio, Ruta y Perfil.

**3.0:** la pestaña elegida lleva el ícono lleno y su nombre sobre el renglón azul (dónde estás). Ruta cambia de escalera a recorrido con inicio y meta, y Perfil, de credencial a persona.

${ORIGIN('TabBar.kt')}
`, `
var TABS = [{ label: 'Inicio', icon: 'inicio', iconSelected: 'inicio-lleno' }, { label: 'Ruta', icon: 'ruta', iconSelected: 'ruta-llena' }, { label: 'Perfil', icon: 'perfil', iconSelected: 'perfil-lleno' }];
function Demo() {
  var s = React.useState(0), v = s[0], set = s[1];
  return h('div', { className: 'rl-demo', style: { maxWidth: 360 } }, h(R.TabBar, { items: TABS, selected: v, onSelect: set }));
}`);

/* ---------------- Pantallas (página de muestra) ---------------- */
const PANTALLAS = `
var TABS = [{ label: 'Inicio', icon: 'inicio', iconSelected: 'inicio-lleno' }, { label: 'Ruta', icon: 'ruta', iconSelected: 'ruta-llena' }, { label: 'Perfil', icon: 'perfil', iconSelected: 'perfil-lleno' }];
function Phone(props) { return h('figure', { style: { margin: 0, display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 14 } }, h('div', { className: 'rl-demo-phone' }, props.children), h('figcaption', { className: 'rl-demo-cap', style: { maxWidth: 300, textAlign: 'center' } }, props.caption)); }
function Inicio() {
  return h(R.Screen, { leading: h('span', { style: { paddingLeft: 8 } }, h(R.Wordmark, { size: 22 })), trailing: h(R.Avatar, { size: 34, emoji: '📚', label: 'Perfil' }), title: 'Hola.', eyebrow: 'Miércoles 1 de octubre' },
    h('div', { style: { display: 'flex', flexDirection: 'column', gap: 18 } },
      h('div', { style: { background: 'var(--card)', borderRadius: 28, overflow: 'hidden' } },
        h('div', { style: { height: 150 } }, h(R.Trama, { mode: 'foto', src: '${FOTO.libro}', pitch: 5, label: 'Un libro abierto, en trama' })),
        h('div', { style: { padding: '14px 18px 18px', display: 'flex', flexDirection: 'column', gap: 10 } },
          h('div', null, h(R.StatusChip, { icon: 'esperando', text: 'Contando' })),
          h(R.Signature, { words: 'Leer', variant: 'card' }),
          h('p', { style: { margin: 0, font: '400 15px/21px var(--font-sans)', color: 'var(--graphite)' } }, 'Sonará junto al sillón cuando sumes 15 min en tus apps.'),
          h(R.TimeDots, { value: 6, total: 15, dense: true })))),
    h('div', { style: { position: 'absolute', left: 14, right: 14, bottom: 14, zIndex: 3 } }, h(R.TabBar, { items: TABS, selected: 0 })));
}
function Preparar() {
  var s = React.useState('Leer 10 páginas'), v = s[0], set = s[1];
  return h(R.Screen, { title: '¿Qué quieres hacer?', onBack: function () {}, closeIcon: true, progress: 0.25, step: '1 de 4', bottom: h(R.GuardedButton, { missing: v.trim() ? null : 'Escribe qué quieres hacer o toca una idea.' }, 'Seguir') },
    h('div', { style: { display: 'flex', flexDirection: 'column', gap: 18 } },
      h(R.RenglonField, { label: 'Actividad', value: v, onChange: set }),
      h('p', { className: 'rl-demo-cap' }, 'Escribe lo que quieres hacer o toca una idea.'),
      h('div', { className: 'rl-demo-row', style: { gap: 8 } }, ['Leer', 'Dibujar', 'Salir a caminar', 'Ordenar', 'Cocinar'].map(function (i) { return h(R.QuickChoice, { key: i, selected: v === i, onClick: function () { set(i); } }, i); }))));
}
function Senal() {
  return h('div', { style: { position: 'absolute', inset: 0, background: 'var(--paper)' } },
    h('div', { style: { position: 'absolute', inset: 0 } }, h(R.Trama, { mode: 'senal' })),
    h('div', { style: { position: 'absolute', left: 16, right: 16, bottom: 92, padding: '20px 18px', borderRadius: 28, background: 'var(--glass)', backdropFilter: 'blur(18px)', WebkitBackdropFilter: 'blur(18px)', border: '.75px solid var(--glass-edge)', boxShadow: 'var(--shadow-glass)', display: 'flex', flexDirection: 'column', gap: 10 } },
      h(R.Wordmark, { size: 18 }),
      h('div', null, h(R.StatusChip, { icon: 'senal', text: 'Suena en el parlante', onPanel: true })),
      h(R.Signature, { words: 'Leer', variant: 'signal' }),
      h('p', { style: { margin: 0, font: '400 15px/21px var(--font-sans)', color: 'var(--graphite)' } }, 'Para empezar: abrir el libro.')),
    h('div', { style: { position: 'absolute', left: 16, right: 16, bottom: 18 } }, h(R.Button, { icon: 'silenciar' }, 'Silenciar y continuar')));
}
function Demo() {
  return h('div', { className: 'rl-demo', style: { flexDirection: 'row', gap: 36, justifyContent: 'center', padding: '24px 20px' } },
    h(Phone, { caption: 'Inicio: la foto en trama, la frase de la persona sobre el renglón y el tiempo en puntos.' }, h(Inicio)),
    h(Phone, { caption: 'Preparar: el campo es el renglón y el botón dice qué falta.' }, h(Preparar)),
    h(Phone, { caption: 'La señal: la trama late mientras suena y el texto va en una tarjeta de vidrio.' }, h(Senal)));
}`;

/* ---------------- Escritura ---------------- */
function preview(group, height, title, code, extraMarker) {
  return `<!-- @dsCard group="${group}" height=${height}${extraMarker || ''} -->
<!doctype html>
<html lang="es">
<head><meta charset="utf-8"><title>${title} — Relevo</title></head>
<body>
<div id="root"></div>
<script>
  var R = window.Relevo, h = React.createElement;
${code.trim().split('\n').map((l) => '  ' + l).join('\n')}
  ReactDOM.createRoot(document.getElementById('root')).render(h(Demo));
</script>
</body>
</html>
`;
}
// En el repositorio, cada Markdown lleva su registro de cambios (CLAUDE.md); la versión publicada no lo necesita.
const REG = "\n\n## Registro de cambios (disclaimer)\n\n### 2026-10-01 — Creación\n\n- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.\n- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.\n- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.\n";
for (const comp of C) {
  const dir = path.join(OUT, comp.name);
  fs.mkdirSync(dir, { recursive: true });
  fs.writeFileSync(path.join(dir, 'README.md'), `# ${comp.name}\n${comp.readme.replace(/^\n/, '\n')}`.replace(/\s*$/, '') + REG);
  fs.writeFileSync(path.join(dir, 'preview.html'), preview(comp.group, comp.height, comp.name, comp.demo));
}
fs.mkdirSync(path.join(OUT, 'Pantallas'), { recursive: true });
fs.writeFileSync(path.join(OUT, 'Pantallas', 'preview.html'), preview('Pantallas', 760, 'Pantallas', PANTALLAS, ' width=1120 page subtitle="Inicio, Preparar y la señal armados con los componentes"'));
fs.writeFileSync(path.join(OUT, 'Pantallas', 'README.md'), `# Pantallas

Tres pantallas de la app armadas solo con los componentes del sistema: Inicio, Preparar y la señal.

Es una maqueta de cómo se vería la app 2.19 con la identidad 3.0, no una captura de la app. La foto de «leer» es una de las fotografías CC0 de la app, pasada por la trama.` + REG);

// bundle.js
const icons = fs.readFileSync(path.join(__dirname, 'bundle-icons.json'), 'utf8');
const wordmark = fs.readFileSync(path.join(__dirname, 'wordmark-paths.json'), 'utf8');
const header = '/* @ds-bundle: ' + JSON.stringify({ format: 4, namespace: 'Relevo', components: C.map((c) => ({ name: c.name })) }) + ' */\n';
let src = fs.readFileSync(path.join(__dirname, 'bundle-src.js'), 'utf8').replace('__ICONS__', icons).replace('__WORDMARK__', wordmark);
const bundle = header + src;
if (/<\/script|<!--/i.test(bundle)) throw new Error('bundle.js tiene </script o <!--');
fs.writeFileSync(path.join(OUT, 'bundle.js'), bundle);
module.exports = { C };
console.log('componentes', C.length, '| bundle', Math.round(bundle.length / 1024) + ' KB');
