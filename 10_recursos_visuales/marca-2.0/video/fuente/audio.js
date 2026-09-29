// Banda sonora sintetizada para el video de 15 s, con la firma sonora de Relevo a los 8,45 s.
const fs = require('fs');
const SR = 48000, DUR = 15, N = SR * DUR;
const L = new Float32Array(N), R = new Float32Array(N);
let seed = 7; const rnd = () => ((seed = (seed * 1103515245 + 12345) >>> 0) / 4294967296) * 2 - 1;
const put = (i, v, pan = 0) => { if (i < 0 || i >= N) return; L[i] += v * Math.min(1, 1 - pan); R[i] += v * Math.min(1, 1 + pan); };

function tone(t0, dur, f0, f1, vol, { att = .005, dec = null, pan = 0, harm = [1], curve = 'exp' } = {}) {
  const n = Math.floor(dur * SR), s = Math.floor(t0 * SR); let ph = 0;
  for (let i = 0; i < n; i++) {
    const x = i / n, f = curve === 'exp' ? f0 * Math.pow(f1 / f0, x) : f0 + (f1 - f0) * x;
    ph += 2 * Math.PI * f / SR;
    const a = Math.min(1, i / (att * SR));
    const e = (dec ? Math.exp(-i / (dec * SR)) : (1 - x)) * Math.min(1, (n - i) / (.25 * SR));
    let v = 0; harm.forEach((h, k) => { v += Math.sin(ph * (k + 1)) * h; });
    put(s + i, v * a * e * vol, pan);
  }
}
const kick = (t, vol = .5) => { tone(t, .38, 120, 38, vol, { dec: .12 }); tone(t, .012, 3000, 800, vol * .15, { dec: .004 }); };
function noise(t0, dur, vol, { f0 = 800, f1 = 800, q = .7, env = x => 1 - x, pan = 0 } = {}) {
  // Filtro de variables de estado, pasa banda
  let low = 0, band = 0; const n = Math.floor(dur * SR), s = Math.floor(t0 * SR);
  for (let i = 0; i < n; i++) {
    const x = i / n, fc = f0 * Math.pow(f1 / f0, x), F = 2 * Math.sin(Math.PI * fc / SR);
    const inp = rnd(); low += F * band; const high = inp - low - q * band; band += F * high;
    put(s + i, band * env(x) * vol, pan * Math.sin(x * Math.PI));
  }
}
const whoosh = (tPeak, len = .7, vol = .35, up = true) => noise(tPeak - len * .6, len, vol, { f0: up ? 350 : 5000, f1: up ? 6000 : 300, q: .6, env: x => Math.pow(Math.sin(Math.PI * Math.min(1, x / .6 * .5 + (x > .6 ? (x - .6) / .4 * .5 : 0))), 2), pan: .6 });
const click = (t, vol = .08, f = 3500, pan = 0) => noise(t, .012, vol, { f0: f, f1: f, q: .3, env: x => Math.exp(-x * 6), pan });
const pluck = (t, f, vol = .22, pan = 0) => tone(t, .6, f, f, vol, { dec: .16, harm: [1, .35, .12, .05], pan });
const blip = (t, f = 700, vol = .16, pan = 0) => tone(t, .09, f, f * 2, vol, { dec: .035, harm: [1, .2], pan });
function pad(t0, dur, freqs, vol, att = .8, rel = 1.2) {
  const n = Math.floor(dur * SR), s = Math.floor(t0 * SR);
  freqs.forEach((f, k) => {
    let p1 = 0, p2 = 0;
    for (let i = 0; i < n; i++) {
      const tt = i / SR; p1 += 2 * Math.PI * f * 1.003 / SR; p2 += 2 * Math.PI * f * .997 / SR;
      const a = Math.min(1, tt / att), r = Math.min(1, (dur - tt) / rel);
      put(s + i, (Math.sin(p1) + Math.sin(p2)) * .5 * a * r * vol / freqs.length, (k % 2 ? .3 : -.3));
    }
  });
}

// ---- Escena 1: scroll que se acelera ----
for (let t = .05; t < 2.6;) { const x = t / 2.5; click(t, .05 + .07 * x, 2600 + 1800 * x, Math.sin(t * 11) * .4); t += .19 - .155 * Math.pow(Math.min(1, x), 1.4); }
tone(0, 2.7, 48, 96, .22, { att: 1.8, dec: 99, harm: [1, .3] });
noise(.3, 2.4, .06, { f0: 200, f1: 2400, q: .5, env: x => x * x });
whoosh(2.95, .9, .5);
// ---- Escena 2: el renglón ----
kick(3.22, .7);
pad(3.2, 2.8, [349.2, 440, 523.3, 659.3], .16, .6, .8);
[[3.62, 523.3], [4.42, 659.3], [5.2, 784]].forEach(([t, f], i) => { pluck(t, f, .26, [-.3, 0, .3][i]); blip(t + .12, 900 + i * 150, .12, .4); });
for (let k = 0; k < 7; k++) click(3.05 + k * .05, .03, 5000, -.5 + k * .15);
// Pulso de fondo a 120 BPM, con silencio mientras suena la firma
for (let t = 3.7; t < 12.0; t += .5) { if (t > 8.35 && t < 9.35) continue; kick(t, .28); click(t + .25, .035, 7000, .2); }
whoosh(5.95, .6, .35);
// ---- Escena 3: cómo funciona ----
kick(6.08, .45); blip(6.1, 600, .1);
const typed = [['Leer 10 páginas', 6.35, 6.78], ['Abrir el libro', 6.78, 7.0], ['En el velador', 6.98, 7.14]];
typed.forEach(([s, a, b]) => { for (let i = 1; i <= s.length; i++) click(a + (b - a) * i / s.length, .07, 4200 + (i % 3) * 400, .1); });
whoosh(7.35, .5, .32, false);
[.3636, .7273, .9091, 1].forEach((x, i) => tone(7.55 + .65 * x, .25, 110, 60, [.45, .22, .12, .06][i], { dec: .07 }));
blip(7.97, 820, .14, -.3); blip(8.38, 980, .14, .3);
tone(8.28, .2, 600, 1400, .06, { dec: .12 });
// Firma sonora de Relevo
const wav = fs.readFileSync('a/firma-relevo.wav');
let off = 12; while (wav.toString('ascii', off, off + 4) !== 'data') off += 8 + wav.readUInt32LE(off + 4);
const dlen = wav.readUInt32LE(off + 4), data = off + 8, srcN = dlen / 2;
const s0 = Math.floor(8.45 * SR);
for (let i = 0; s0 + i < N; i++) { const pos = i * 44100 / SR, j = Math.floor(pos); if (j + 1 >= srcN) break; const fr = pos - j; const v = (wav.readInt16LE(data + j * 2) * (1 - fr) + wav.readInt16LE(data + j * 2 + 2) * fr) / 32768; put(s0 + i, v * .95, 0); }
// ---- Escena 4: la decisión ----
whoosh(9.6, .8, .4); kick(9.62, .5);
pad(10.2, 1.9, [293.7, 369.99, 440, 554.4], .12, .4, .6);
[10.75, 10.88, 11.01].forEach((t, i) => pluck(t, [587.3, 740, 880][i], .18, [-.35, 0, .35][i]));
// ---- Escena 5: logotipo ----
noise(11.4, 1.0, .12, { f0: 300, f1: 7000, q: .4, env: x => x * x * x });
tone(11.6, .85, 60, 240, .12, { att: .8, dec: 99 });
whoosh(12.3, .6, .45);
kick(12.45, .85); tone(12.45, 1.4, 55, 40, .35, { dec: .5 });
pad(12.45, 2.55, [261.6, 329.6, 392, 493.9, 587.3], .2, .25, 1.4);
[1046.5, 1318.5, 1568, 2093, 1568, 2637].forEach((f, i) => pluck(12.95 + i * .065, f, .09, -.5 + i * .2));
for (let i = 0; i < 6; i++) blip(13.47 + i * .09, 700 + i * 90, .09, i % 2 ? .45 : -.45);
pluck(13.3, 523.3, .1); pluck(13.75, 659.3, .08);

// Suavizado final, normalización y escritura
for (let i = Math.floor(14.3 * SR); i < N; i++) { const g = 1 - (i / SR - 14.3) / .7; L[i] *= g; R[i] *= g; }
let peak = 0; for (let i = 0; i < N; i++) peak = Math.max(peak, Math.abs(L[i]), Math.abs(R[i]));
const gain = .89 / peak;
const buf = Buffer.alloc(44 + N * 4);
buf.write('RIFF', 0); buf.writeUInt32LE(36 + N * 4, 4); buf.write('WAVEfmt ', 8); buf.writeUInt32LE(16, 16); buf.writeUInt16LE(1, 20); buf.writeUInt16LE(2, 22);
buf.writeUInt32LE(SR, 24); buf.writeUInt32LE(SR * 4, 28); buf.writeUInt16LE(4, 32); buf.writeUInt16LE(16, 34); buf.write('data', 36); buf.writeUInt32LE(N * 4, 40);
for (let i = 0; i < N; i++) { buf.writeInt16LE(Math.round(Math.max(-1, Math.min(1, L[i] * gain)) * 32767), 44 + i * 4); buf.writeInt16LE(Math.round(Math.max(-1, Math.min(1, R[i] * gain)) * 32767), 46 + i * 4); }
fs.writeFileSync('banda.wav', buf);
console.log('banda.wav', (buf.length / 1e6).toFixed(1), 'MB, ganancia', gain.toFixed(2));
