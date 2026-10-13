// Datos de ejemplo del panel de Relevo. Son inventados (códigos EJ-01 y EJ-02, «Ejemplo Uno»): sirven para ver y
// probar el panel sin conexión a Supabase. No corresponden a ninguna persona del testeo.
(function () {
  const now = Date.now(), iso = (ms) => new Date(ms).toISOString(), day = (n) => new Date(now - n * 86400000).toISOString().slice(0, 10);
  const people = [
    { code: 'EJ-01', name: 'Ejemplo Uno', version: '2.18', user_id: '00000000-0000-4000-8000-000000000001', last_seen: iso(now - 4 * 60000), contact: iso(now - 2 * 60000), last_event: 'target_entered', activity: 'Leer 10 páginas', threshold: 600, observed: 320, started_at: iso(now - 30 * 60000), condition: 'A', day: 5, route: 'bluetooth', last_signal_at: null, last_outcome: null, auto: 'si', auto_state: true, permisos: { tiempo_de_uso: true, notificaciones: true, bateria_sin_restriccion: false }, equipo: { app: '2.18', modelo: 'Pixel 7', android: 35, fabricante: 'Google' }, apps: 2, state_at: iso(now - 20 * 60000), pantalla_hoy: 9120, elegidas_hoy: 2710, relevos: 9, respondidos: 6, senales: 7, automaticos: 3, eliminados: 1 },
    { code: 'EJ-02', name: null, version: '2.17', user_id: '00000000-0000-4000-8000-000000000002', last_seen: iso(now - 30 * 3600000), contact: iso(now - 30 * 3600000), last_event: 'closed', activity: 'Salir a caminar', threshold: 900, observed: 900, started_at: iso(now - 32 * 3600000), condition: 'B', day: 4, route: 'bluetooth', last_signal_at: iso(now - 31 * 3600000), last_outcome: 'started', auto: 'no', auto_state: null, permisos: null, equipo: null, apps: null, state_at: null, pantalla_hoy: null, elegidas_hoy: null, relevos: 5, respondidos: 4, senales: 5, automaticos: 0, eliminados: 0 }
  ];
  const daily = []; for (let i = 20; i >= 0; i--) { const r = (i * 7) % 4; daily.push({ day: day(i), relevos: r, senales: Math.max(0, r - (i % 2)) }); }
  const snapshot = { participants: people, totals: { relevos_hoy: 2, senales: 12, respondidos: 10, automaticos: 3 },
    sessions: [{ code: 'EJ-01', activity: 'Leer 10 páginas', started_at: iso(now - 30 * 60000), signal_at: null, outcome: null, activation: 'auto', study_condition: 'A', study_day: 5, signal_route: 'bluetooth' },
      { code: 'EJ-01', activity: 'Ordenar el escritorio', started_at: iso(now - 5 * 3600000), signal_at: null, outcome: 'deleted', activation: 'auto', study_condition: 'A', study_day: 5, signal_route: 'bluetooth' },
      { code: 'EJ-02', activity: 'Salir a caminar', started_at: iso(now - 32 * 3600000), signal_at: iso(now - 31 * 3600000), outcome: 'started', knew_intention: 'yes', recalled_first_step: 'yes', signal_feeling: 'good', response_seconds: 14, activation: 'manual', study_condition: 'B', study_day: 4, signal_route: 'bluetooth' }],
    answers: [{ code: 'EJ-02', question: 'semana1_costo_preparar', answer: '2', created_at: iso(now - 50 * 3600000) }],
    conditions: [{ condition: 'A', relevos: 6, senales: 5, si: 3, medias: 1, no: 1, recordo: 4, comenzo: 3 }, { condition: 'B', relevos: 5, senales: 5, si: 2, medias: 2, no: 1, recordo: 3, comenzo: 2 }],
    daily, feed: [{ code: 'EJ-01', what: 'target_entered', created_at: iso(now - 4 * 60000) }, { code: 'EJ-01', what: 'falta_completar', detail: 'paso=usage;aviso=Elige al menos una app que cuente.', created_at: iso(now - 40 * 60000) }, { code: 'EJ-01', what: 'falta_completar', detail: 'paso=usage;aviso=Elige al menos una app que cuente.', created_at: iso(now - 41 * 60000) }, { code: 'EJ-01', what: 'relevo_eliminado', created_at: iso(now - 5 * 3600000) }],
    messages: [{ id: 'x', created_at: iso(now - 3 * 3600000), target_code: null, title: 'Empieza una semana nueva', body: 'Abre Relevo: en Inicio verás dónde sonará el aviso esta semana. Lo demás sigue igual.', entregados: 2, abiertos: 1 }] };
  const usage = [];
  for (let i = 13; i >= 0; i--) {
    const t = 7200 + ((i * 3137) % 9000);
    usage.push({ day: day(i), package: '_total', label: 'Tiempo de pantalla', seconds: t, opens: 40 + (i * 7) % 30 });
    usage.push({ day: day(i), package: 'com.instagram.android', label: 'Instagram', seconds: Math.round(t * 0.22), opens: 12 + i % 5 });
    if (i % 3) usage.push({ day: day(i), package: 'com.google.android.youtube', label: 'YouTube', seconds: Math.round(t * 0.1), opens: 3 });
  }
  const state = { perfil: { imagen: 'icono:libro', intereses: ['Leer', 'Moverme'], otro_interes: '' },
    ruta: [{ interes: 'Leer', paso_actual: 2, pasos: [{ actividad: 'Leer 5 páginas', para_empezar: 'Abrir el libro en el velador' }, { actividad: 'Leer 10 páginas', para_empezar: 'Sentarme en el sillón' }, { actividad: 'Terminar un capítulo', para_empezar: 'Buscar el marcador' }] }],
    actividades_propias: [], ajustes: { tema: 'sistema', texto_grande: false, resumen_semanal: true, aviso_semanal: true, mensaje_despues_de_responder: true, veces_por_semana: 3, activacion_automatica: true },
    permisos: { tiempo_de_uso: true, notificaciones: true, bateria_sin_restriccion: false }, equipo: { android: 35, fabricante: 'Google', modelo: 'Pixel 7', app: '2.18' }, ultimo_relevo: null,
    relevo_actual: { estado: 'waiting', actividad: 'Leer 10 páginas', para_empezar: 'Sentarme en el sillón', lugar: 'Junto al sillón', apps: [{ paquete: 'com.instagram.android', nombre: 'Instagram' }, { paquete: 'com.google.android.youtube', nombre: 'YouTube' }], segundos: 600, contados: 320, salida: 'bluetooth', se_activo_solo: true },
    prueba: { secuencia: 'ABC', dia0: day(4), dia: 5, condicion: 'A' }, apps_elegidas: [{ paquete: 'com.instagram.android', nombre: 'Instagram' }, { paquete: 'com.google.android.youtube', nombre: 'YouTube' }] };
  const detail = { counts: { relevos: 3, eventos: 18, respuestas: 2, uso_app: 40, uso_diario: 30, estado: 1, mensajes: 2, nombre: 1 }, sessions: snapshot.sessions.filter((s) => s.code === 'EJ-01').map((x, i) => Object.assign({ session_id: '00000000-0000-4000-8000-00000000000' + i, target_apps: [{ package: 'com.instagram.android', label: 'Instagram', seconds: 420 + i * 60 }, { package: 'com.zhiliaoapp.musically', label: 'TikTok', seconds: 180 }] }, x)), answers: [{ session_id: "00000000-0000-4000-8000-000000000000", question: "lugar_del_objeto", answer: "Junto a la cama", created_at: iso(now - 50 * 60000) }, { session_id: null, question: "semana1_costo_preparar", answer: "2", created_at: iso(now - 26 * 3600000) }],
    flow: [
      { what: "app_abierta", detail: null, created_at: iso(now - 70 * 60000), src: "app" },
      { what: "pantalla", detail: "pestana_home", created_at: iso(now - 69 * 60000), src: "app" },
      { what: "preparar_abierto", detail: "ruta", created_at: iso(now - 68 * 60000), src: "app" },
      { what: "actividad_elegida", detail: "Leer 10 páginas", created_at: iso(now - 68 * 60000), src: "app" },
      { what: "preparar_paso", detail: "usage", created_at: iso(now - 67 * 60000), src: "app" },
      { what: "falta_completar", detail: "paso=usage;aviso=Elige al menos una app que cuente.", created_at: iso(now - 67 * 60000), src: "app" },
      { what: "falta_completar", detail: "paso=usage;aviso=Elige al menos una app que cuente.", created_at: iso(now - 66 * 60000), src: "app" },
      { what: "salida_elegida", detail: "tag", created_at: iso(now - 65 * 60000), src: "app" },
      { what: "prueba_de_sonido", detail: "salida=tag;orden=si;intento=1;nivel=2;boton=si;alarma_desconexion=apagada", created_at: iso(now - 65 * 60000), src: "app" },
      { what: "llavero_escuchado", detail: "si;intento=1", created_at: iso(now - 64 * 60000), src: "app" },
      { what: "armed", detail: null, created_at: iso(now - 63 * 60000), src: "relevo" },
      { what: "app_cerrada", detail: "segundos=420", created_at: iso(now - 63 * 60000), src: "app" },
      { what: "target_entered", detail: null, created_at: iso(now - 60 * 60000), src: "relevo" },
      { what: "signal_emitted", detail: null, created_at: iso(now - 50 * 60000), src: "relevo" },
      { what: "silenced_object", detail: null, created_at: iso(now - 49 * 60000), src: "relevo" },
      { what: "responded", detail: null, created_at: iso(now - 48 * 60000), src: "relevo" },
      { what: "app_abierta", detail: null, created_at: iso(now - 26 * 3600000), src: "app" }
    ], usage,
    state: { updated_at: iso(now - 20 * 60000), app_version: '2.18', consent_version: '2026-09-30-v11', state },
    missing: [{ detail: 'paso=usage;aviso=Elige al menos una app que cuente.', created_at: iso(now - 40 * 60000) }, { detail: 'paso=usage;aviso=Elige al menos una app que cuente.', created_at: iso(now - 41 * 60000) }] };
  // v5: relevos de ejemplo para Resultados y Exportar.
  const conds = ["A","B","C"], outs = ["started","started","later","changed",null,"started","later"], feel = ["good","neutral","bad","good"], routes = ["bluetooth","tag","phone"];
  const stats = []; for (let i = 0; i < 36; i++) { const c = conds[i % 3], sig = i % 5 !== 4, out = sig ? outs[i % 7] : null;
    stats.push({ code: i % 2 ? "EJ-01" : "EJ-02", started_at: iso(now - (36 - i) * 9 * 3600000), study_condition: i < 33 ? c : null, study_day: 1 + (i % 21), signal_route: c === "C" ? "phone" : routes[i % 2], activation: i % 4 ? "manual" : "auto",
      signal_at: sig ? iso(now - (36 - i) * 9 * 3600000 + 1800000) : null, outcome: out, knew_intention: out ? ["yes","partly","no","yes"][i % 4] : null, recalled_first_step: out ? (i % 3 ? "yes" : "no") : null,
      signal_feeling: sig ? feel[i % 4] : null, response_seconds: sig ? 6 + (i * 7) % 40 : null, usage_before_seconds: sig ? 200 + (i * 37) % 400 : null, usage_after_seconds: sig ? 60 + (i * 53) % 300 : null,
      signal_end: sig ? ["silenced","object","auto","silenced"][i % 4] : null }); }
  const exp = { relevos: stats.map((x, i) => Object.assign({ session_id: "s" + i, participant_code: x.code, activity: "Leer 10 páginas", threshold_seconds: 600, consent_version: "2026-09-30-v11" }, x)), respuestas: snapshot.answers, eventos: [], uso_app: [], uso_diario: usage, estado: [], mensajes: [] };
  // Respuesta de ejemplo para cada consulta del panel, según el nombre de la columna que pide.
  window.RELEVO_EJEMPLO = {
    filas(query) {
      if (/as snapshot/.test(query)) return [{ snapshot }];
      if (/as detail/.test(query)) return [{ detail }];
      if (/as deleted/.test(query)) return [{ deleted: { r1: 0 } }];
      if (/as stats/.test(query)) return [{ stats }];
      if (/as export/.test(query)) return [{ export: exp }];
      if (/as nombres/.test(query)) return [{ nombres: [{ codigo: 'EJ-01', nombre: 'Ejemplo Uno' }] }];
      if (/insert into public.relevo_messages/.test(query)) return [{ id: 'ejemplo' }];
      return [];
    },
  };
})();
