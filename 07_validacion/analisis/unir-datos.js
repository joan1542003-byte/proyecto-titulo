// Une los datos de la prueba de Relevo que llegan por tres vías y los deja listos para analizar:
//  1. la exportación de Supabase (un JSON con las tablas relevo_*, como datos_sensibles/relevo-datos-reales-*.json);
//  2. las copias de los teléfonos que no se conectaron (relevo-CODIGO.json de Documentos/Relevo, o el archivo de
//     «Descargar mis datos»; los dos traen «registro_del_estudio»);
//  3. las fichas en papel transcritas a CSV (columnas participant_code, question, answer, fecha, fuente).
//
// Uso, desde esta carpeta:
//   node unir-datos.js [carpeta] [--desde AAAA-MM-DD] [--solo COD1,COD2]
// Por defecto lee ../../datos_sensibles, toma los relevos desde el 8 de octubre de 2026 y escribe en
// <carpeta>/analisis/: relevos.csv, respuestas.csv y resumen.md. Nada de esto entra al repositorio:
// datos_sensibles/ está en .gitignore.
const fs = require("fs");
const path = require("path");

const args = process.argv.slice(2);
const opt = (name, fallback) => { const i = args.indexOf(name); return i >= 0 ? args[i + 1] : fallback; };
const folder = path.resolve(args.find((a, i) => !a.startsWith("--") && !(i > 0 && args[i - 1].startsWith("--"))) || path.join(__dirname, "..", "..", "datos_sensibles"));
const since = new Date((opt("--desde", "2026-10-08")) + "T00:00:00-03:00").getTime();
const only = (opt("--solo", "") || "").split(",").map((c) => c.trim().toUpperCase()).filter(Boolean);

const toMillis = (v) => v == null || v === "" ? null : typeof v === "number" ? v : Date.parse(v);
const iso = (ms) => ms == null ? "" : new Date(ms).toLocaleString("sv-SE", { timeZone: "America/Santiago" }).replace(" ", "T");
const keep = (code) => code && (!only.length || only.includes(String(code).toUpperCase()));

const sessions = new Map(); // session_id → fila
const answers = [];
const sources = [];

function addSession(row, source) {
  const started = toMillis(row.started_at);
  if (!keep(row.participant_code) || started == null || started < since) return;
  const s = {
    participant_code: row.participant_code, fuente: source, session_id: row.session_id, inicio: iso(started),
    actividad: row.activity, primer_paso: row.first_step, lugar: row.place,
    apps: Array.isArray(row.target_apps) ? row.target_apps.map((a) => a.label || a.package || a).join(" + ") : (() => { try { return JSON.parse(row.target_apps || "[]").map((a) => a.label || a.package).join(" + "); } catch { return row.target_app_label || ""; } })() || row.target_app_label || "",
    minutos: row.threshold_seconds != null ? Math.round(row.threshold_seconds / 6) / 10 : "",
    salida: row.signal_route || "", version: row.app_version || "", activacion: row.activation || "",
    condicion: row.study_condition || "", dia: row.study_day ?? "",
    sono: row.signal_at != null && row.signal_at !== "" ? "si" : "no", fin_senal: row.signal_end || "", segundos_respuesta: row.response_seconds ?? "",
    supo: row.knew_intention || "", recordo_primer_paso: row.recalled_first_step || "", decidio: row.outcome || "", sonido: row.signal_feeling || "",
  };
  const prev = sessions.get(s.session_id);
  // Si el mismo relevo llega por dos vías, queda el registro más completo.
  const filled = (x) => Object.values(x).filter((v) => v !== "" && v != null).length;
  if (!prev || filled(s) > filled(prev)) sessions.set(s.session_id, prev ? { ...s, fuente: prev.fuente + "+" + source } : s);
}
function addAnswer(code, question, answer, when, source) {
  if (!keep(code)) return;
  // Una fecha sin hora (las fichas en papel) es del día local: se compara al mediodía y se guarda tal cual.
  if (typeof when === "string" && /^\d{4}-\d{2}-\d{2}$/.test(when)) {
    const day = when;
    if (Date.parse(day + "T12:00:00-03:00") < since) return;
    const key = [code, question, answer, day].join("|");
    if (!answers.some((x) => x.key === key)) answers.push({ key, participant_code: code, fuente: source, pregunta: question, respuesta: answer, fecha: day });
    return;
  }
  const ms = toMillis(when);
  if (ms != null && ms < since) return;
  const key = [code, question, answer, ms == null ? "" : Math.round(ms / 60000)].join("|");
  if (answers.some((a) => a.key === key)) return;
  answers.push({ key, participant_code: code, fuente: source, pregunta: question, respuesta: answer, fecha: ms == null ? String(when || "") : iso(ms) });
}

function csvRows(text) {
  const rows = []; let row = [], cell = "", quoted = false;
  for (let i = 0; i < text.length; i++) {
    const c = text[i];
    if (quoted) { if (c === '"' && text[i + 1] === '"') { cell += '"'; i++; } else if (c === '"') quoted = false; else cell += c; }
    else if (c === '"') quoted = true;
    else if (c === ",") { row.push(cell); cell = ""; }
    else if (c === "\n" || c === "\r") { if (c === "\r" && text[i + 1] === "\n") i++; row.push(cell); rows.push(row); row = []; cell = ""; }
    else cell += c;
  }
  if (cell || row.length) { row.push(cell); rows.push(row); }
  return rows.filter((r) => r.some((c) => c.trim()));
}

for (const name of fs.readdirSync(folder)) {
  const file = path.join(folder, name);
  if (!fs.statSync(file).isFile()) continue;
  if (name.endsWith(".json")) {
    let j; try { j = JSON.parse(fs.readFileSync(file, "utf8")); } catch { continue; }
    if (Array.isArray(j.relevo_sessions)) {
      sources.push(`${name}: exportación de Supabase`);
      j.relevo_sessions.forEach((r) => addSession(r, "supabase"));
      (j.relevo_answers || []).forEach((a) => addAnswer(a.participant_code, a.question, a.answer, a.created_at, "supabase"));
    } else if (j.registro_del_estudio) {
      const log = j.registro_del_estudio, code = j.codigo_participacion;
      sources.push(`${name}: copia del teléfono de ${code}`);
      (log.sessions || []).forEach((r) => addSession({ ...r, participant_code: r.participant_code || code }, "telefono"));
      (log.answers || []).forEach((a) => addAnswer(a.participant_code || code, a.question, a.answer, a.created_at, "telefono"));
    }
  } else if (name.endsWith(".csv")) {
    const rows = csvRows(fs.readFileSync(file, "utf8").replace(/^﻿/, ""));
    const head = (rows[0] || []).map((h) => h.trim());
    if (!["participant_code", "question", "answer"].every((h) => head.includes(h))) continue;
    sources.push(`${name}: transcripción en papel`);
    const at = (r, h) => r[head.indexOf(h)] ?? "";
    rows.slice(1).forEach((r) => addAnswer(at(r, "participant_code").trim(), at(r, "question").trim(), at(r, "answer").trim(), at(r, "fecha").trim() || null, at(r, "fuente").trim() || "papel"));
  }
}

const out = path.join(folder, "analisis");
fs.mkdirSync(out, { recursive: true });
const cell = (v) => { const t = String(v ?? ""); return /[",\n]/.test(t) ? `"${t.replace(/"/g, '""')}"` : t; };
const writeCsv = (file, rows, cols) => fs.writeFileSync(path.join(out, file), "﻿" + [cols.join(","), ...rows.map((r) => cols.map((c) => cell(r[c])).join(","))].join("\n") + "\n");

const rel = [...sessions.values()].sort((a, b) => a.participant_code.localeCompare(b.participant_code) || a.inicio.localeCompare(b.inicio));
writeCsv("relevos.csv", rel, Object.keys(rel[0] || { participant_code: 0 }));
const ans = answers.sort((a, b) => a.participant_code.localeCompare(b.participant_code) || a.fecha.localeCompare(b.fecha));
writeCsv("respuestas.csv", ans, ["participant_code", "fuente", "pregunta", "respuesta", "fecha"]);

// Resumen por persona, con los mismos recuentos que informa la memoria.
const codes = [...new Set([...rel.map((r) => r.participant_code), ...ans.map((a) => a.participant_code)])].sort();
const count = (list, f) => list.filter(f).length;
const lines = [`# Resumen de la prueba`, ``, `Generado el ${iso(Date.now()).slice(0, 16).replace("T", " ")} con relevos desde el ${new Date(since).toISOString().slice(0, 10)}.`, ``, `Fuentes leídas:`, ...sources.map((s) => `- ${s}`), ``,
  `| Persona | Relevos | Sonaron | Supo qué hacer (sí / a medias / no) | Recordó el primer paso | Empezó / después / cambió de idea | Sonido bien / normal / mal | Escalas semanales | Cierre |`,
  `| --- | ---: | ---: | --- | --- | --- | --- | ---: | ---: |`];
for (const c of codes) {
  const r = rel.filter((x) => x.participant_code === c && x.decidio !== "deleted");
  const s = r.filter((x) => x.sono === "si");
  const a = ans.filter((x) => x.participant_code === c);
  lines.push(`| ${c} | ${r.length} | ${s.length} | ${count(s, (x) => x.supo === "yes")} / ${count(s, (x) => x.supo === "partly")} / ${count(s, (x) => x.supo === "no")} | ${count(s, (x) => x.recordo_primer_paso === "yes")} de ${s.length} | ${count(s, (x) => x.decidio === "started")} / ${count(s, (x) => x.decidio === "later")} / ${count(s, (x) => x.decidio === "changed")} | ${count(s, (x) => x.sonido === "good")} / ${count(s, (x) => x.sonido === "neutral")} / ${count(s, (x) => x.sonido === "bad")} | ${count(a, (x) => /^semana\d_/.test(x.pregunta))} | ${count(a, (x) => /^(cierre_|entrevista_)/.test(x.pregunta))} |`);
}
lines.push("", "Los relevos eliminados o editados antes de sonar no se cuentan. Los recuentos son autoinforme; no son una medición de conducta.", "");
fs.writeFileSync(path.join(out, "resumen.md"), lines.join("\n"));
console.log(`ok: ${rel.length} relevos y ${ans.length} respuestas de ${codes.length} personas → ${out}`);
