// Inventario de los textos de la app: cada texto que la persona puede ver o escuchar con el lector de pantalla,
// con su pantalla, su tipo, su archivo y su línea. Lee el código Kotlin, no la app instalada.
//
// Uso: node extraer-textos.js            escribe textos-de-la-app.csv e inventario-de-textos.md
//      node extraer-textos.js android-2.33  lee el código de esa rama (sin cambiarse de rama)
//
// Qué deja fuera: claves internas, etiquetas de animaciones, registros técnicos, consultas y nombres de archivo.
// Los datos que pone la persona aparecen como [variable]: [nombre] es su nombre; [duración], un tiempo.

const fs = require('fs');
const path = require('path');
const { execFileSync } = require('child_process');

const AQUI = __dirname;
const APP = path.resolve(AQUI, '..');
const RAMA = process.argv[2] || null;
const BASE = 'app/src/main/java/com/example/relevo';
const CARPETAS = ['ui', 'ui/components', 'monitor', 'domain'];
// Registros técnicos y nombres de eventos: no los ve la persona.
const SIN_TEXTOS = new Set(['monitor/BackgroundAccess.kt', 'monitor/DailyUsage.kt', 'monitor/ForegroundTracker.kt', 'monitor/InstalledAppsRepository.kt', 'monitor/MessageStream.kt', 'monitor/UsageAccess.kt', 'monitor/UsageAfterSignal.kt', 'monitor/UsageWindow.kt', 'monitor/RestoreMonitorReceiver.kt']);

// ---------------------------------------------------------------- Pantallas

// Cada función se asigna a la pantalla o la pieza donde aparece su texto.
const PANTALLAS = [
  ['01', 'Bienvenida', ['WelcomeScreen', 'FloatingRow']],
  ['02', 'Cómo funciona (guía de la primera vez)', ['HowItWorksScreen', 'IntroVideo', 'GuidePanel', 'SystemRow', 'RelevoNavigation']],
  ['03', 'Antes de empezar (consentimiento)', ['ConsentScreen', 'ConsentSections', 'ConsentPart']],
  ['04', 'Para saber cuándo avisarte (permisos de la primera vez)', ['PermissionScreen', 'PermissionEnd']],
  ['05', 'Tu perfil (primera vez)', ['ProfileSetupScreen', 'InterestGrid']],
  ['06', 'Tu primer relevo', ['FirstRelevoScreen']],
  ['07', 'Inicio', ['HomeTab', 'BellButton', 'AvatarButton', 'CreateActivityRow', 'AcknowledgementToast', 'ActiveCard', 'SoundRow', 'ReturnCard', 'NextStepCard', 'StudyCards', 'StudyCard', 'QuickFeedbackCard', 'ratingFaces', 'HomeActions']],
  ['08', 'Preparar un relevo', ['PrepareScreen', 'guideTipFor', 'titleFor', 'missingFor', 'ActivityHeader', 'ActivityStep', 'TileGroup', 'PlaceStep', 'SuggestionChips', 'UsageStep', 'SoundStep', 'tagSubtitle', 'tagProblem', 'TagPanel', 'TagHeardQuestion', 'SoundOption', 'AppPickerSheet', 'TagProtocol']],
  ['09', 'Cómo usar el Tag', ['TagGuideSheet', 'GuideStep', 'TagArt', 'guideSteps']],
  ['10', 'Hojas sobre Inicio', ['FirstRelevoActiveSheet', 'NextStepSheet', 'TurnOffReturnSheet']],
  ['11', 'Tu relevo (contando)', ['ActiveScreen']],
  ['12', 'Suena', ['SignalScreen']],
  ['13', 'Preguntas y ¿Qué decidiste?', ['DecideScreen', 'Question', 'feelingFaces', 'starFaces', 'Face']],
  ['14', 'Ruta', ['RouteTab', 'StepTimeline', 'NowChip', 'RouteActions']],
  ['15', 'Editar la ruta', ['RouteEditScreen', 'StepEditorSheet']],
  ['16', 'Perfil', ['ProfileTab', 'ProfileHeader', 'WeekSummary', 'WeekNoteSheet', 'countLine', 'weekLine']],
  ['17', 'Editar el perfil', ['ProfileEditScreen']],
  ['18', 'Avisos y resúmenes', ['NoticesScreen']],
  ['19', 'Apariencia', ['AppearanceScreen']],
  ['20', 'Permisos', ['PermissionsScreen']],
  ['21', 'Tus relevos', ['HistoryScreen']],
  ['22', 'Tus actividades', ['ActivitiesScreen']],
  ['23', 'Crear o editar una actividad', ['ActivityEditScreen']],
  ['24', 'Privacidad y datos', ['PrivacyScreen', 'RelevoViewModel', 'backupStatusText', 'syncStatusText']],
  ['25', 'Lo que aceptaste', ['ConsentDetailsScreen']],
  ['26', 'Prueba de 21 días (investigador)', ['StudyScreen', 'StudyPlan']],
  ['27', '¿Cómo te fue esta semana?', ['WeekReviewScreen']],
  ['28', 'Cierre de la prueba', ['ClosingScreen']],
  ['29', 'Opinar sobre Relevo', ['FeedbackScreen']],
  ['30', 'Reportar un problema', ['ReportScreen']],
  ['31', 'Notificaciones', ['AppUsageMonitorService', 'ProjectMessages', 'ReturnNotice']],
];
const DE_FUNCION = new Map(PANTALLAS.flatMap(([n, nombre, fs]) => fs.map((f) => [f, `${n} ${nombre}`])));
const COMPARTIDOS = '32 Textos compartidos';
const IDEAS = '33 Ideas, sugerencias y rutas';
const COMPONENTES = '34 Piezas de la interfaz';

// ---------------------------------------------------------------- Lectura

function fuentes() {
  const archivos = [];
  for (const c of CARPETAS) {
    const dir = `${BASE}/${c}`;
    let lista;
    // --full-tree: desde una subcarpeta, ls-tree filtra por esa carpeta y devolvería una lista vacía.
    if (RAMA) lista = execFileSync('git', ['ls-tree', '--full-tree', '--name-only', `${RAMA}:06_desarrollo_y_factibilidad/app-android/${dir}`], { cwd: APP }).toString().split('\n').filter((f) => f.endsWith('.kt'));
    else lista = fs.readdirSync(path.join(APP, dir)).filter((f) => f.endsWith('.kt'));
    for (const f of lista) {
      const rel = `${dir}/${f}`;
      if (SIN_TEXTOS.has(rel.replace(`${BASE}/`, ''))) continue;
      const texto = RAMA ? execFileSync('git', ['show', `${RAMA}:06_desarrollo_y_factibilidad/app-android/${rel}`], { cwd: APP, maxBuffer: 20 * 1024 * 1024 }).toString() : fs.readFileSync(path.join(APP, rel), 'utf8');
      archivos.push({ rel, texto: texto.replace(/\r\n?/g, '\n') });
    }
  }
  return archivos;
}

/** Recorre el código y devuelve los literales de texto de primer nivel, sin comentarios. */
function literales(codigo) {
  const out = [];
  let i = 0;
  const n = codigo.length;
  while (i < n) {
    const c = codigo[i];
    if (c === '/' && codigo[i + 1] === '/') { while (i < n && codigo[i] !== '\n') i++; continue; }
    if (c === '/' && codigo[i + 1] === '*') { i = codigo.indexOf('*/', i + 2); if (i < 0) break; i += 2; continue; }
    if (c === '\'' ) { i += codigo[i + 1] === '\\' ? 4 : 3; continue; }
    if (c === '"' && codigo.startsWith('"""', i)) { const fin = codigo.indexOf('"""', i + 3); i = fin < 0 ? n : fin + 3; continue; }
    if (c === '"') { const r = leerLiteral(codigo, i); out.push({ inicio: i, fin: r.fin, crudo: r.crudo, plantillas: r.plantillas }); i = r.fin; continue; }
    i++;
  }
  return out;
}

/** Lee un literal "..." desde su comilla; las plantillas ${…} pueden tener otros literales dentro. */
function leerLiteral(codigo, i) {
  let j = i + 1;
  let crudo = '';
  const plantillas = [];
  while (j < codigo.length && codigo[j] !== '"') {
    if (codigo[j] === '\\') { crudo += codigo.slice(j, j + 2); j += 2; continue; }
    if (codigo[j] === '$' && codigo[j + 1] === '{') {
      let prof = 1;
      let k = j + 2;
      while (k < codigo.length && prof > 0) {
        if (codigo[k] === '"') { const r = leerLiteral(codigo, k); plantillas.push(r.crudo); k = r.fin; continue; }
        if (codigo[k] === '{') prof++;
        else if (codigo[k] === '}') prof--;
        k++;
      }
      crudo += `\${${codigo.slice(j + 2, k - 1)}}`;
      j = k;
      continue;
    }
    crudo += codigo[j++];
  }
  return { fin: j + 1, crudo, plantillas };
}

// ---------------------------------------------------------------- Clasificación

const VARIABLES = [
  [/formatDuration\(reminder\.requiredUsageSeconds\)|formatDuration\(lastReminder\.requiredUsageSeconds\)|formatDuration\(seconds\)/, 'duración'],
  [/formatDuration\(remaining\)/, 'tiempo que falta'],
  [/formatDuration\(reminder\.observedUsageSeconds\)/, 'tiempo contado'],
  [/formatDuration/, 'duración'],
  [/selectedApps\.joinToString/, 'apps elegidas'],
  [/\bname\b|profile\.name/, 'nombre'],
  [/activity|step\.activity|idea\.activity/, 'actividad'],
  [/howToStart|firstStep|\bfirst\b/, 'primer paso'],
  [/place|where|placePhrase/, 'lugar'],
  [/routeName|signalRoute/, 'salida'],
  [/participantCode/, 'código'],
  [/day\b|study\.day/, 'día'],
  [/week\b|study\.week/, 'semana'],
  [/condition/, 'condición'],
  [/title|routeTitle|track\.title/, 'ruta'],
  [/apps\.size/, 'número de apps'],
  [/linkedName/, 'nombre del Tag'],
  [/battery/, 'pila'],
  [/index/, 'número'],
];
const variable = (expr) => (VARIABLES.find(([re]) => re.test(expr)) || [null, 'dato'])[1];
const legible = (crudo) => crudo
  .replace(/\$\{([^{}]*(\{[^{}]*\}[^{}]*)*)\}/g, (_, e) => `[${variable(e)}]`)
  .replace(/\$([a-zA-Z_]\w*(?:\.[a-zA-Z_]\w*)*)/g, (_, e) => `[${variable(e)}]`) // «$name.» deja el punto final
  .replace(/\\n/g, ' ').replace(/\\"/g, '"').replace(/\\\$/g, '$')
  .replace(/[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+\.[A-Za-z]{2,}/g, '[correo del investigador]').trim();

const TIPOS = [
  [/setContentTitle\($/, 'notificación: título'],
  [/(setContentText|bigText)\($/, 'notificación: texto'],
  [/addAction\(0, $/, 'notificación: botón'],
  [/NotificationChannel\([A-Z_]+, $/, 'canal de notificación'],
  [/(contentDescription|description|onClickLabel) = $|IconAction\([^,]+, $|BrandMark\(.*description = $/, 'lector de pantalla'],
  [/placeholder = $/, 'ayuda del campo'],
  [/missing = $|-> "?$/, null],
  [/(RelevoButton|GuardedButton)\($|finishLabel = $|continueLabel = $|done = $/, 'botón'],
  [/PlainAction\($/, 'acción'],
  [/backLabel = $/, 'volver'],
  [/titleSoft = $/, 'segunda línea del título'],
  [/subtitle = $|soft = $/, 'subtítulo'],
  [/RelevoScreen\(.*title = $|^\s*title = $|ScreenTitle\($|RelevoSheet\(.*title = $/, 'título'],
  [/Notice\($/, 'aviso'],
  [/Notice\(.*title = $|title = $/, 'título'],
  [/OptionRow\($/, 'opción'],
  [/QuickChoice\($/, 'opción rápida'],
  [/ListRow\($/, 'fila'],
  [/Question\($/, 'pregunta'],
  [/RenglonField\($|RenglonArea\($|SearchField\(/, 'campo'],
  [/GuideTip\($/, 'guía'],
  [/TipCard\($/, 'consejo'],
  [/Chip\($|StatusChip\(/, 'etiqueta'],
  [/SectionHeader\($|SectionLabel\($|ListSection\(title = $|action = $/, 'rótulo'],
  [/StudyCard\(/, 'tarjeta'],
  [/GuidePage\(/, 'guía'],
  [/GuideStep\(/, 'guía del Tag'],
  [/SkyCard\($/, 'actividad'],
  [/Text\($/, 'texto'],
];

function tipo(antes, linea, texto, archivo) {
  const previo = antes.slice(-160);
  for (const [re, t] of TIPOS) if (re.test(previo)) return t || clasificarCaso(texto);
  if (/missing|Falta|Elige|Escribe|Busca y elige/.test(linea) && /^(Falta|Elige|Escribe|Busca|Marca|Espera)/.test(texto)) return 'validación';
  if (archivo.includes('monitor/')) return 'notificación';
  return 'texto';
}
const clasificarCaso = (texto) => (/^(Falta|Elige|Escribe|Busca|Marca|Espera)/.test(texto) ? 'validación' : 'texto');

/** Lo que no ve la persona: claves, etiquetas internas, formatos, rutas. */
function interno(texto, antes, archivo) {
  const t = texto.trim();
  if (!t) return true;
  if (/^[MLHVCSQTAZmlhvcsqtaz0-9 .,-]+$/.test(t) && /\d/.test(t)) return true; // trazos de los íconos (llevan cifras; «Mal» no)
  if (/^[\w\s]*=/.test(t) || /^[a-z_]+;/.test(t)) return true;                 // pares clave=valor de los registros
  if (/(\blog|technicalLog|logEvent|record|put)\("[^"]*", $|(\blog|technicalLog|logEvent|record|put)\($/.test(antes.slice(-80))) return true;
  if (/^;\S|_\[|^[a-z_]+\[|^\w+ \[dato\]$/.test(t)) return true;              // nombres de eventos con su valor («; empezaste…» sí se ve)
  if (/label = $|key = $|tag = $|TAG, $|Log\.[dwie]\($|getSharedPreferences\($|\.(put|get|opt)(String|Boolean|Int|Long|Float|JSONArray|JSONObject|StringSet)?\($|\.has\($|\.remove\($|\.contains\($|Intent\($|setAction\($|putExtra\($|equals\($|startsWith\($|endsWith\($|fromParts\($|Uri\.parse\($|logScreen\($|onMissing\($|mark(Guide)?\($|event\(|"event"|Locale\(|forLanguageTag\($|SimpleDateFormat\($|DateTimeFormatter\.ofPattern\($|\.format\($|String\.format\($|split\($|replace\($|Regex\($|matches\($|substringBefore\($|substringAfter\($|query\($|eq\($|header\($|addHeader\($|url\($|from\($|\.post\($|select=|order=|channelId|CHANNEL|WorkManager|uniqueWork|setGroup\($|createNotificationChannel/.test(antes.slice(-60))) return true;
  if (/^[a-z0-9_.:/#\-]+$/.test(t)) return true;                       // claves y rutas
  if (/^(foto|emoji|icono):/.test(t)) return true;                     // claves de imágenes guardadas
  if (/^[A-Z0-9_]+$/.test(t)) return true;                             // constantes
  if (/^%|^\{|^\[|^<|https?:|\.kt$|\.json$|\.csv$|^tnum$|^#[0-9A-F]/i.test(t)) return true;
  if (/^(application\/|text\/|image\/|android\.|com\.|cl\.)/.test(t)) return true;
  if (/^(SELECT|INSERT|UPDATE|DELETE|eq\.|in\.)/.test(t)) return true;
  if (archivo.includes('data/') && !/[áéíóúñ¿¡ ]/.test(t)) return true;
  return false;
}

function pantallaDe(funcion, archivo) {
  if (DE_FUNCION.has(funcion)) return DE_FUNCION.get(funcion);
  const base = path.basename(archivo, '.kt');
  if (DE_FUNCION.has(base)) return DE_FUNCION.get(base);
  if (archivo.endsWith('components/Sky.kt')) return IDEAS;
  if (funcion === 'keywords') return null;
  if (funcion === 'Tab') return COMPONENTES;
  if (archivo.endsWith('ui/Common.kt') && /^(Common|commonPlaces|placeSuggestions|startSuggestions|activityIdeas|homeIdeas|ideasByFamily|interestPhoto|interestIcon)$/.test(funcion)) return IDEAS;
  if (archivo.includes('/components/')) return COMPONENTES;
  if (archivo.includes('domain/') || /BrandData|Route\.kt|Common\.kt/.test(archivo) && /idea|Idea|suggest|Suggest|places|Places|track|Track|interest|Interest|steps/.test(funcion)) return IDEAS;
  return COMPARTIDOS;
}

// ---------------------------------------------------------------- Principal

function principal() {
  const filas = [];
  for (const { rel, texto } of fuentes()) {
    const lineas = texto.split('\n');
    const inicioLinea = [0];
    for (let i = 0; i < texto.length; i++) if (texto[i] === '\n') inicioLinea.push(i + 1);
    const lineaDe = (pos) => { let lo = 0, hi = inicioLinea.length - 1; while (lo < hi) { const m = (lo + hi + 1) >> 1; if (inicioLinea[m] <= pos) lo = m; else hi = m - 1; } return lo + 1; };
    // Función que contiene cada posición: la última «fun nombre(» o clase anterior.
    // Solo las declaraciones de primer nivel: una función local, como «go», pertenece a la pantalla que la contiene.
    const funciones = [...texto.matchAll(/(?:^|\n)(?:internal |private |public |data |sealed |enum )*(?:fun|class|object|interface|val|var)\s+(?:<[^>]+>\s*)?(?:[\w.<>]+\.)?(\w+)/g)].map((m) => ({ pos: m.index, nombre: m[1] }));
    const funcionDe = (pos) => { let f = path.basename(rel, '.kt'); for (const x of funciones) { if (x.pos <= pos) f = x.nombre; else break; } return f; };
    for (const lit of literales(texto)) {
      const antes = texto.slice(Math.max(0, lit.inicio - 200), lit.inicio);
      const t = legible(lit.crudo);
      if (interno(t, antes, rel)) continue;
      if (!/[a-záéíóúñ]/i.test(t)) continue;
      const linea = lineaDe(lit.inicio);
      const funcion = funcionDe(lit.inicio);
      const contexto = lineas[linea - 1];
      const pantalla = pantallaDe(funcion, rel);
      if (!pantalla) continue;
      filas.push({ pantalla, tipo: tipo(antes, contexto, t, rel), texto: t, archivo: rel.replace(`${BASE}/`, ''), linea, funcion });
      // Los fragmentos dentro de una plantilla (por ejemplo, las ramas de un «if») también se ven.
      for (const p of lit.plantillas) {
        const tp = legible(p);
        if (!interno(tp, '', rel) && /[a-záéíóúñ]/i.test(tp) && tp.length > 1) filas.push({ pantalla: pantallaDe(funcion, rel), tipo: 'fragmento', texto: tp, archivo: rel.replace(`${BASE}/`, ''), linea, funcion });
      }
    }
  }
  filas.sort((a, b) => a.pantalla.localeCompare(b.pantalla, 'es', { numeric: true }) || a.archivo.localeCompare(b.archivo) || a.linea - b.linea);
  filas.forEach((f, k) => { f.id = `T${String(k + 1).padStart(4, '0')}`; });

  const sufijo = RAMA ? `-${RAMA}` : '';
  const csv = ['id;pantalla;tipo;texto;archivo;linea;funcion', ...filas.map((f) => [f.id, f.pantalla, f.tipo, f.texto, f.archivo, f.linea, f.funcion].map((x) => `"${String(x).replace(/"/g, '""')}"`).join(';'))].join('\n');
  fs.writeFileSync(path.join(AQUI, `textos-de-la-app${sufijo}.csv`), '﻿' + csv);

  const palabras = filas.filter((f) => f.tipo !== 'fragmento').reduce((s, f) => s + f.texto.split(/\s+/).filter(Boolean).length, 0);
  const md = [`# Inventario de textos de la app${RAMA ? ` (rama ${RAMA})` : ''}`, '',
    `> Se genera con \`node extraer-textos.js\` desde el código de la app. Para cambiar un texto se cambia el código y se vuelve a generar. Los datos variables van entre corchetes, como [nombre] o [duración].`, '',
    `**Total:** ${filas.length} textos, ${palabras} palabras, en ${new Set(filas.map((f) => f.pantalla)).size} pantallas o grupos.`, ''];
  let actual = null;
  for (const f of filas) {
    if (f.pantalla !== actual) {
      actual = f.pantalla;
      const n = filas.filter((x) => x.pantalla === actual).length;
      md.push('', `## ${actual}`, '', `${n} textos.`, '', '| Id | Tipo | Texto | Dónde |', '| --- | --- | --- | --- |');
    }
    md.push(`| ${f.id} | ${f.tipo} | ${f.texto.replace(/\|/g, '\\|')} | \`${path.basename(f.archivo)}:${f.linea}\` |`);
  }
  md.push('', '## Registro de cambios (disclaimer)', '', '### 2026-10-24 — Creación', '', '- **Qué cambió:** se creó el inventario, generado desde el código.', '- **Cómo estaba antes:** los textos solo estaban dentro del código Kotlin.', '- **Por qué:** el autor pidió estudiar y documentar cada palabra de la app antes de actualizar los textos.', '');
  fs.writeFileSync(path.join(AQUI, `inventario-de-textos${sufijo}.md`), md.join('\n'));
  const porTipo = {};
  for (const f of filas) porTipo[f.tipo] = (porTipo[f.tipo] || 0) + 1;
  console.log(`${filas.length} textos, ${palabras} palabras`);
  console.log(porTipo);
  const porPantalla = {};
  for (const f of filas) porPantalla[f.pantalla] = (porPantalla[f.pantalla] || 0) + 1;
  console.log(porPantalla);
}

principal();
