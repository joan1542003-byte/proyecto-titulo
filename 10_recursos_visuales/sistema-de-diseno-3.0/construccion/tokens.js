// tokens.json del sistema Relevo 3.0. Valores de theme/Color.kt, Type.kt, Theme.kt y ui/components de la
// app 2.18, más la identidad D-098 v3 (azul eléctrico, renglón, trama y serif de titulares).
const fs = require('fs');
const path = require('path');
const OUT = path.join(__dirname, '..', 'sistema', 'tokens.json');

const c = (name, light, dark, usage) => ({ name, value: dark === undefined ? light : { light, dark }, usage });

const color = {
  themes: [
    { id: 'light', name: 'Claro' },
    { id: 'dark', name: 'Oscuro' },
  ],
  tokens: [
    c('paper', '#f2f2ef', '#111215', 'Papel: el fondo de toda pantalla, lámina y diapositiva. Lleva ink, graphite y blue encima.'),
    c('card', '#fcfcfa', '#1b1c20', 'Tarjeta: el contenido agrupado (Panel, ListSection, Notice), apenas más claro que paper. Lleva ink, graphite y blue.'),
    c('ink', '#17181c', '#e9eaec', 'Tinta: texto, iconos, el botón principal y el logotipo. 15,8:1 sobre paper y 17,3:1 sobre card en claro; 15,6:1 y 14,1:1 en oscuro; 15,1:1 sobre blue-soft.'),
    c('on-ink', '#f2f2ef', '#111215', 'Texto e icono sobre un relleno de ink (botón principal, QuickChoice elegida, CheckMark): 15,8:1 en claro y 15,6:1 en oscuro.'),
    c('graphite', '#5b5f68', '#9ba0a9', 'Grafito: texto secundario, rótulos de campo, pies y pestañas sin elegir. Sobre paper 5,71:1, card 6,23:1 y mist 5,07:1 en claro; 7,13:1, 6,48:1 y 5,62:1 en oscuro. Desde 3.0 también es el borde de CheckMark y RadioMark sin marcar.'),
    c('mist', '#e5e5e2', '#26282d', 'Niebla: relleno de controles secundarios (botón secundario, QuickChoice, SearchField, pista de SegmentedControl y ProgressLine) y espacio de una foto mientras carga. Lleva ink o graphite.'),
    c('line', '#d5d6d8', '#30333a', 'Línea: separadores de 1 px entre filas, el asa de Sheet y el botón secundario presionado. Es decorativa (1,30:1): nunca es el único borde de un control.'),
    c('gray', '#9ba0a9', '#5b5f68', 'Gris: contenido deshabilitado y estrellas vacías. No se usa para texto que haya que leer (2,08:1 sobre mist en claro). En la app 2.18 también era el borde de CheckMark y RadioMark sin marcar, con 2,56:1 sobre card: no llega a 3:1, por eso 3.0 usa graphite.'),
    c('slate', '#33363d', '#c9cbcf', 'Pizarra: el botón principal presionado. on-ink sobre slate da 10,8:1 en claro y 11,5:1 en oscuro.'),
    c('voice', '{blue}', '{blue}', 'La voz de la persona: lo que escribió, mostrado como valor de una fila (ListRow con valueIsVoice, FactRow). Es un alias de blue: en 3.0 el azul eléctrico reemplaza al #2A4BD7 / #8CA6FF de la app 2.18. No se subraya (azul y subrayado juntos parecen un enlace).'),
    c('voice-soft', '{blue-soft}', '{blue-soft}', 'Azul muy suave para una selección; alias de blue-soft (en 2.18 era #EEF1FD / #1C2238).'),
    c('error', '#b3261e', '#f2b8b5', 'Solo errores del sistema, nunca de la persona: icono y texto del aviso de error y del botón destructivo. 5,83:1 sobre paper y 6,36:1 sobre card en claro; 10,97:1 y 9,97:1 en oscuro.'),
    c('error-soft', '#b3261e17', '#f2b8b529', 'Relleno del botón destructivo (error al 9 % en claro y al 16 % en oscuro). error sobre este relleno: 5,06:1 y 7,84:1.'),
    c('error-tint', '#b3261e12', '#f2b8b524', 'Fondo del aviso de error (error al 7 % y al 14 %). error encima: 5,23:1 y 8,30:1; graphite: 5,12:1 y 5,39:1.'),
    c('glass', '#f7f7f4a8', '#1b1c20ad', 'Tinte del vidrio de navegación (barras, botones de vidrio, TabBar), sobre un desenfoque de 12 a 24 px. Solo para la capa de navegación: el contenido nunca va en vidrio. ink encima: 16,2:1.'),
    c('glass-edge', '#17181c12', '#ffffff17', 'Borde de 0,75 px que separa el vidrio del contenido.'),
    c('sheet-glass', '#f2f2efdb', '#1b1c20e0', 'Tinte de la hoja flotante (Sheet): paper al 86 % en claro, card al 88 % en oscuro.'),
    c('scrim', '#0000002e', '#00000073', 'Velo detrás de una hoja abierta (negro al 18 % y al 45 %).'),
    c('thumb', '{card}', '#3a3c42', 'La cápsula que marca la opción elegida en SegmentedControl. ink encima: 9,16:1 en oscuro.'),
    c('tab-indicator', '#17181c12', '#ffffff1a', 'La cápsula del destino elegido en TabBar (ink al 7 % en claro, blanco al 10 % en oscuro).'),
    c('row-pressed', '#d5d6d88c', '#30333a8c', 'Fondo de una fila presionada (line al 55 %).'),
    c('blue', '{azul-500}', '{azul-300}', 'El azul de Relevo en la interfaz: el renglón, el tiempo (ProgressLine, TimeDots), dónde estás (StepProgress, la pestaña elegida), el foco y la voz de la persona. Como texto: 6,07:1 sobre paper, 6,63:1 sobre card y 5,40:1 sobre mist en claro; 7,35:1, 6,68:1 y 5,79:1 en oscuro. Nunca en botones ni en grandes superficies de la interfaz.'),
    c('on-blue', '#ffffff', '#111215', 'Texto, logotipo y renglón sobre un relleno de blue (ícono de la app, portadas): 6,81:1 en claro y 7,35:1 en oscuro.'),
    c('blue-soft', '{azul-50}', '#23224a', 'Fondo azul muy suave: selección y etiquetas. blue encima: 5,80:1 en claro y 5,89:1 en oscuro; ink: 15,1:1 y 12,5:1.'),
    c('blue-dots', '{azul-200}', '#3a3880', 'Los puntos claros de la trama, el tiempo que falta en TimeDots sobre fondos azules y los puntos tenues de un campo. Decorativo: nunca lleva texto.'),
    c('tinta', '#17181c', '#17181c', 'Tinta constante de la marca: fondo oscuro de lockups, impresión en negro e ícono de la app en tinta. En la interfaz se usa ink, que cambia con el tema.'),
    c('papel', '#f2f2ef', '#f2f2ef', 'Papel constante: el logotipo y el texto sobre tinta o fotos oscuras en piezas fijas (15,8:1 sobre tinta). En la interfaz se usa paper.'),
    c('blanco', '#ffffff', '#ffffff', 'Blanco: el logotipo, la «r» del ícono y el texto sobre azul-500 (6,81:1) en portadas y afiches.'),
    c('azul-700', '#1f1bb4', '#1f1bb4', 'Azul profundo de la escala: azul presionado e impresión de una tinta sobre fondos claros. Blanco encima: 11,2:1; sobre azul-50: 9,54:1.'),
    c('azul-500', '#3d38f5', '#3d38f5', 'El azul eléctrico de Relevo, medido en la presentación: logotipo, renglón, ícono de la app y portadas. Igual en ambos temas; en la interfaz se usa a través de blue.'),
    c('azul-300', '#9a97ff', '#9a97ff', 'El azul para fondos oscuros: renglón del logotipo sobre tinta y blue del tema oscuro. 6,96:1 sobre ink claro.'),
    c('azul-200', '#c4c2fc', '#c4c2fc', 'Puntos claros de la trama sobre blanco o papel. Decorativo (1,68:1 sobre blanco); ink encima: 10,5:1.'),
    c('azul-50', '#ecebfe', '#ecebfe', 'Selección y fondos de etiqueta sobre papel o blanco.'),
  ],
};

const SANS = 'sans', SERIF = 'serif', MONO = 'mono';
const st = (name, fontSize, lineHeight, fontWeight, letterSpacing, sample, usage, extra) =>
  Object.assign({ name, fontSize, lineHeight, fontWeight }, letterSpacing ? { letterSpacing } : {}, { sample, usage }, extra || {});

const type = {
  fonts: [{ family: 'Schibsted Grotesk', file: 'fonts/schibsted-grotesk.ttf', weight: '400 900', style: 'normal' }],
  families: {
    sans: '"Schibsted Grotesk", "Segoe UI", system-ui, -apple-system, sans-serif',
    serif: 'Newsreader, "Iowan Old Style", Georgia, serif',
    mono: '"IBM Plex Mono", ui-monospace, "Cascadia Mono", monospace',
  },
  groups: [
    {
      name: 'Interfaz',
      family: SANS,
      note: 'Schibsted Grotesk variable 400–900, la letra de la app, del logotipo y de la presentación. Escala de theme/Type.kt: titulares en 650 con −2 %, texto de 17 con interlineado amplio. Nada en mayúsculas sostenidas ni con letras espaciadas.',
      styles: [
        st('largeTitle', '34px', '40px', 650, '-0.02em', 'Tu semana', 'Título grande de pantalla en la app 2.18. En 3.0, las pantallas principales usan displayTitle; largeTitle queda para pantallas de datos y ajustes.'),
        st('title', '28px', '34px', 650, '-0.02em', 'Arma tu ruta', 'Título de tarjeta o de hoja grande; inicial de Avatar (escalada).'),
        st('title2', '22px', '28px', 600, '-0.01em', '¿Qué decidiste?', 'Título de sección (SectionHeader), de hoja (Sheet) y los signos − y + de los steppers.'),
        st('headline', '17px', '22px', 600, null, 'La última vez', 'Título de ficha (PhotoCard), título de aviso, título en la barra y PlainAction.'),
        st('body', '17px', '26px', 400, null, 'Te avisa cuando sumes este tiempo en las apps que elijas.', 'Texto corrido, filas (ListRow) y buscador.'),
        st('callout', '16px', '23px', 400, null, 'Lo primero que harías, en pocas palabras.', 'Texto de apoyo un poco menor que body.'),
        st('subhead', '15px', '21px', 400, null, 'Escribe qué quieres hacer o toca una idea.', 'Texto de avisos (Notice, MissingHint), SegmentedControl y QuickChoice (en 600).'),
        st('footnote', '13px', '18px', 400, null, 'Sonará junto al sillón después de 40 min.', 'Subtítulos de fila, pies de sección, rótulos de campo (en 500) y StatusChip (en 600).'),
        st('caption', '12px', '16px', 400, null, 'Versión 2.18', 'Metadatos mínimos; la pestaña usa 11 px en 500 o 600.'),
        st('label', '14px', '18px', 600, null, 'Ahora', 'Rótulo breve sobre un título («Ahora», «La última vez»), escrito como frase.'),
        st('section', '15px', '20px', 600, null, 'Ajustes', 'Título de un grupo de filas (ListSection), en graphite.'),
        st('voice', '20px', '26px', 500, '-0.005em', 'Leer 10 páginas', 'Lo que escribe la persona sobre el renglón (RenglonField). En 3.0 va en ink sobre un renglón blue.'),
        st('signature', '36px', '40px', 650, '-0.03em', 'Vuelve a leer.', 'La firma «Vuelve a ___.» de la app 2.18. En 3.0 la reemplazan los estilos display de serif.'),
        st('button', '17px', '22px', 600, null, 'Seguir', 'Etiqueta de Button de 56 px.'),
      ],
    },
    {
      name: 'Titulares',
      family: SERIF,
      note: 'Serif de titulares de 3.0 (D-098): Newsreader, con tamaño óptico 6–72, peso 380 y −1,5 %. Es la opción de trabajo para pantalla; Instrument Serif queda como alternativa. Solo desde 28 px y solo para la frase principal de una pantalla, lámina o afiche.',
      styles: [
        st('displayPoster', '72px', '74px', 380, '-0.015em', 'Vuelve a lo que querías hacer.', 'Afiches, portadas y la primera lámina de una presentación.', { opticalSize: 72 }),
        st('displaySlide', '54px', '58px', 380, '-0.015em', 'Lo que querías hacer sigue ahí.', 'Título de diapositiva y de sección en láminas.', { opticalSize: 54 }),
        st('displaySignal', '44px', '46px', 380, '-0.015em', 'Vuelve a leer.', 'La frase de la señal, cuando suena el parlante.', { opticalSize: 44 }),
        st('displayTitle', '36px', '40px', 380, '-0.015em', '¿Qué quieres hacer?', 'Título de las pantallas principales de la app (Inicio, Preparar, Ruta).', { opticalSize: 36 }),
        st('displayCard', '30px', '34px', 380, '-0.015em', 'Vuelve a leer.', 'La frase del relevo activo en la tarjeta de Inicio.', { opticalSize: 30 }),
      ],
    },
    {
      name: 'Datos',
      family: MONO,
      note: 'IBM Plex Mono 300: solo piezas de comunicación (palabras dispersas en afiches) y datos del panel del investigador. Nunca en la app.',
      styles: [st('mono', '13px', '18px', 300, null, 'leer · dibujar · salir a caminar', 'Palabras de las personas como textura en afiches; códigos y cifras del panel.')],
    },
  ],
};

const t = (name, value, usage) => ({ name, value, usage });
const tokens = {
  name: 'Relevo',
  version: 1,
  meta: {
    source: 'github',
    repo: 'proyecto-titulo',
    ref: 'android-2.7@6563dd4',
    paths: {
      tokens: ['06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/theme/Color.kt', '.../theme/Type.kt', '.../theme/Theme.kt'],
      components: ['06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/components/'],
      identity: ['10_recursos_visuales/25_identidad-el-subrayado-2026-09-30.md', '10_recursos_visuales/marca-el-subrayado/lamina-el-subrayado-v3-2026-09-30.html'],
      fonts: ['06_desarrollo_y_factibilidad/app-android/app/src/main/res/font/schibsted_grotesk.ttf'],
      assets: ['10_recursos_visuales/marca-a-tiempo/logotipo/', '.../ui/components/KitIcons.kt'],
    },
    synced: '2026-10-01',
  },
  color,
  type,
  spacing: {
    note: 'Valores de los componentes de la app (dp = px), sin redondear a una retícula. El margen de pantalla es de 20, como el de un cuaderno.',
    tokens: [
      t('space-2', '2px', 'Título y subtítulo de una fila; icono y nombre en la pestaña; estrellas.'),
      t('space-4', '4px', 'Sangría del título y del pie de ListSection; relleno lateral de PlainAction.'),
      t('space-6', '6px', 'Rótulo y renglón de RenglonField; eyebrow, título y subtítulo; icono y texto en botones compactos y de vidrio.'),
      t('space-8', '8px', 'Título de sección y su tarjeta; separación interna de Panel; icono y texto en QuickChoice, StatusChip y SearchField.'),
      t('space-10', '10px', 'Icono y texto del botón grande; aviso y botón en GuardedButton; foto y título de PhotoCard; los dos steppers.'),
      t('space-12', '12px', 'Separación de Carousel; relleno vertical de filas; relleno lateral de StatusChip, SearchField y la barra superior.'),
      t('space-14', '14px', 'Icono y texto de filas y avisos.'),
      t('space-16', '16px', 'Relleno lateral del botón compacto, QuickChoice y GlassTextButton; relleno derecho de filas.'),
      t('space-18', '18px', 'Relleno izquierdo de filas; relleno de Notice y MissingHint.'),
      t('margin', '20px', 'Margen de pantalla y relleno de Panel y PhotoHero.'),
      t('space-22', '22px', 'Relleno lateral del botón de 56; arriba y abajo del título de pantalla; relleno de la hoja.'),
      t('space-24', '24px', 'Aire sobre la acción principal flotante.'),
      t('section-gap', '28px', 'Entre secciones de una pantalla (SectionGap).'),
      t('space-36', '36px', 'Reserva bajo el contenido cuando no hay acción flotante.'),
      t('space-48', '48px', 'Comienzo del texto en la banda de vidrio de PhotoHero, medido desde el borde de la banda.'),
    ],
  },
  radius: {
    note: 'Cápsulas para todo lo que se toca; esquinas amplias para tarjetas, fotos y hojas, concéntricas con las del teléfono. Nada de bloques cuadrados (D-083).',
    tokens: [
      t('radius-xs', '12px', 'Menús y diálogos de Material (extraSmall).'),
      t('radius-tile', '22px', 'Fotos de PhotoCard y PictureTile.'),
      t('radius-panel', '28px', 'Panel, ListSection, Notice y PhotoHero.'),
      t('radius-sheet', '34px', 'Hoja flotante y esquinas inferiores de la foto que llega al borde superior.'),
      t('radius-control', '9999px', 'Cápsula: botones, campos, chips, SegmentedControl, ProgressLine y TabBar. Equivale al 50 % del lado corto de Compose.'),
    ],
  },
  shadow: {
    note: 'Casi sin sombras: el vidrio y el papel separan las capas. Una sombra suave para la cápsula de SegmentedControl, otra para tarjetas de vidrio sobre la trama, y el anillo de foco.',
    tokens: [
      { name: 'shadow-thumb', value: { light: '0 1px 3px #0000001f, 0 0 1px #0000000f', dark: 'none' }, usage: 'La cápsula elegida de SegmentedControl (solo en claro).' },
      { name: 'shadow-glass', value: { light: '0 18px 50px #14143c1f', dark: '0 18px 50px #00000066' }, usage: 'Tarjeta de vidrio que flota sobre la trama en la señal, portadas y afiches.' },
      { name: 'focus-ring', value: { light: '0 0 0 2px #f2f2ef, 0 0 0 4px #3d38f5', dark: '0 0 0 2px #111215, 0 0 0 4px #9a97ff' }, usage: 'Foco de teclado: 2 px del color del papel y 2 px de blue sólido (6,07:1 en claro, 7,35:1 en oscuro). Como box-shadow, sigue la cápsula.' },
    ],
  },
  size: {
    note: 'Alturas y áreas táctiles de los componentes de la app. Toda área táctil mide 44 px o más.',
    tokens: [
      t('size-button', '56px', 'Button de ancho completo.'),
      t('size-button-compact', '40px', 'Button compacto y QuickChoice.'),
      t('size-touch', '48px', 'Área mínima de PlainAction y alto de SectionHeader.'),
      t('size-icon-action', '44px', 'IconAction, GlassIconButton, GlassTextButton, SegmentedControl y SearchField.'),
      t('size-stepper', '52px', 'Botones − y + de DurationStepper y CountStepper.'),
      t('size-star', '54px', 'Área de cada estrella en StarRating.'),
      t('size-row', '54px', 'Alto mínimo de ListRow.'),
      t('size-bar', '56px', 'Barra superior de la pantalla.'),
      t('size-tab-bar', '64px', 'Barra de pestañas flotante.'),
      t('size-progress', '6px', 'Grosor de ProgressLine y StepProgress.'),
      t('size-mark', '24px', 'CheckMark y RadioMark.'),
      t('size-photo-card', '152px', 'Ancho de PhotoCard en un carrusel.'),
    ],
  },
  stroke: {
    note: 'Trazo de los íconos en unidades de la retícula de 24. Sigue al tamaño (RelevoIcon) o al peso del texto que acompaña.',
    tokens: [
      t('stroke-16', '1.9', 'Íconos de 16 px o menos.'),
      t('stroke-20', '1.8', 'Íconos de 17 a 20 px.'),
      t('stroke-24', '1.75', 'Íconos de 21 a 24 px; el trazo base del sistema.'),
      t('stroke-32', '1.6', 'Íconos de 25 a 32 px.'),
      t('stroke-48', '1.5', 'Íconos de más de 32 px.'),
      t('stroke-medium', '1.8', 'Peso medio, junto a texto en 500.'),
      t('stroke-semibold', '2.1', 'Pestaña elegida y junto a texto en 600.'),
      t('stroke-control', '2', 'Íconos dentro de botones y botones de vidrio.'),
    ],
  },
  trama: {
    note: 'La trama de puntos de 3.0: los píxeles de la pantalla y la rejilla del parlante. Un punto crece con la sombra; una sola tinta azul.',
    tokens: [
      t('trama-pitch', '6px', 'Distancia entre puntos en pantalla (fotos y fondos).'),
      t('trama-pitch-small', '4px', 'Fotos pequeñas, maquetas y el ícono de la app.'),
      t('trama-pitch-print', '2mm', 'Distancia entre puntos en impresión.'),
      t('trama-dot-min', '16%', 'Diámetro del punto más chico, como fracción de la distancia (zonas claras).'),
      t('trama-dot-max', '104%', 'Diámetro del punto más grande (zonas oscuras): los puntos vecinos apenas se tocan.'),
      t('trama-dot-faint', '28%', 'Diámetro de los puntos tenues que marcan la retícula donde no hay imagen.'),
      t('trama-time-dot', '12px', 'Diámetro de cada minuto en TimeDots (separación de 6 px).'),
      t('trama-time-dot-dense', '11px', 'Diámetro de cada minuto en TimeDots dentro de tarjetas angostas (separación de 4 px).'),
    ],
  },
};

fs.writeFileSync(OUT, JSON.stringify(tokens, null, 2) + '\n');
// Validación: nombres únicos fuera de type y alias existentes.
const all = [...color.tokens, ...tokens.spacing.tokens, ...tokens.radius.tokens, ...tokens.shadow.tokens, ...tokens.size.tokens, ...tokens.stroke.tokens, ...tokens.trama.tokens];
const seen = new Set();
for (const x of all) {
  if (!/^[A-Za-z0-9][A-Za-z0-9_.-]{0,63}$/.test(x.name)) throw new Error('nombre ' + x.name);
  if (seen.has(x.name)) throw new Error('duplicado ' + x.name);
  seen.add(x.name);
}
const colorNames = new Set(color.tokens.map((x) => x.name));
for (const x of color.tokens) for (const v of Object.values(typeof x.value === 'string' ? { a: x.value } : x.value)) {
  const m = /^\{(.+)\}$/.exec(v);
  if (m && !colorNames.has(m[1])) throw new Error('alias ' + v);
  if (!m && !/^#[0-9a-f]{6}([0-9a-f]{2})?$/.test(v)) throw new Error('color ' + v);
}
console.log('tokens ok:', color.tokens.length, 'colores,', all.length - color.tokens.length, 'otros,', type.groups.reduce((n, g) => n + g.styles.length, 0), 'estilos');
