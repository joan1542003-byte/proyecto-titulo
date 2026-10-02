// Lector mínimo de TrueType variable: contornos (glyf), compuestos, avances, cmap 4/12, fvar, avar y gvar con IUP.
// Sirve para exportar texto de Schibsted Grotesk como trazados SVG en cualquier peso de su eje wght.
const fs = require('fs');

class Font {
  constructor(file) {
    const b = (this.b = fs.readFileSync(file));
    const n = b.readUInt16BE(4);
    this.t = {};
    for (let i = 0; i < n; i++) {
      const o = 12 + i * 16;
      this.t[b.toString('ascii', o, o + 4)] = { off: b.readUInt32BE(o + 8), len: b.readUInt32BE(o + 12) };
    }
    const head = this.t.head.off;
    this.upm = b.readUInt16BE(head + 18);
    this.locFmt = b.readInt16BE(head + 50);
    this.numGlyphs = b.readUInt16BE(this.t.maxp.off + 4);
    const hhea = this.t.hhea.off;
    this.ascender = b.readInt16BE(hhea + 4);
    this.descender = b.readInt16BE(hhea + 6);
    this.numHMetrics = b.readUInt16BE(hhea + 34);
    this.loca = [];
    const lo = this.t.loca.off;
    for (let i = 0; i <= this.numGlyphs; i++) this.loca.push(this.locFmt === 0 ? b.readUInt16BE(lo + i * 2) * 2 : b.readUInt32BE(lo + i * 4));
    this.parseCmap();
    this.parseFvar();
    this.parseAvar();
    this.parseGvar();
    this.cache = new Map();
  }
  advanceDefault(gid) {
    const o = this.t.hmtx.off;
    const i = Math.min(gid, this.numHMetrics - 1);
    return this.b.readUInt16BE(o + i * 4);
  }
  lsbDefault(gid) {
    const o = this.t.hmtx.off;
    if (gid < this.numHMetrics) return this.b.readInt16BE(o + gid * 4 + 2);
    return this.b.readInt16BE(o + this.numHMetrics * 4 + (gid - this.numHMetrics) * 2);
  }
  parseCmap() {
    const b = this.b, base = this.t.cmap.off, n = b.readUInt16BE(base + 2);
    this.cmap = new Map();
    let best = null;
    for (let i = 0; i < n; i++) {
      const pid = b.readUInt16BE(base + 4 + i * 8), eid = b.readUInt16BE(base + 6 + i * 8), off = b.readUInt32BE(base + 8 + i * 8);
      const fmt = b.readUInt16BE(base + off);
      if (fmt === 12 && (pid === 3 || pid === 0)) best = { off: base + off, fmt };
      else if (fmt === 4 && (pid === 3 || pid === 0) && (!best || best.fmt !== 12)) best = { off: base + off, fmt };
    }
    const o = best.off;
    if (best.fmt === 4) {
      const segX2 = b.readUInt16BE(o + 6), seg = segX2 / 2;
      const ends = o + 14, starts = ends + segX2 + 2, deltas = starts + segX2, ranges = deltas + segX2;
      for (let s = 0; s < seg; s++) {
        const end = b.readUInt16BE(ends + s * 2), start = b.readUInt16BE(starts + s * 2), delta = b.readInt16BE(deltas + s * 2), ro = b.readUInt16BE(ranges + s * 2);
        for (let c = start; c <= end && c !== 0xffff; c++) {
          let g;
          if (ro === 0) g = (c + delta) & 0xffff;
          else { g = b.readUInt16BE(ranges + s * 2 + ro + (c - start) * 2); if (g) g = (g + delta) & 0xffff; }
          this.cmap.set(c, g);
        }
      }
    } else {
      const ng = b.readUInt32BE(o + 12);
      for (let i = 0; i < ng; i++) {
        const s = b.readUInt32BE(o + 16 + i * 12), e = b.readUInt32BE(o + 20 + i * 12), g = b.readUInt32BE(o + 24 + i * 12);
        for (let c = s; c <= e; c++) this.cmap.set(c, g + c - s);
      }
    }
  }
  parseFvar() {
    const b = this.b, o = this.t.fvar.off;
    const axesOff = b.readUInt16BE(o + 4), axisCount = b.readUInt16BE(o + 8), axisSize = b.readUInt16BE(o + 10);
    this.axes = [];
    for (let i = 0; i < axisCount; i++) {
      const a = o + axesOff + i * axisSize;
      this.axes.push({ tag: b.toString('ascii', a, a + 4), min: b.readInt32BE(a + 4) / 65536, def: b.readInt32BE(a + 8) / 65536, max: b.readInt32BE(a + 12) / 65536 });
    }
  }
  parseAvar() {
    this.avar = null;
    if (!this.t.avar) return;
    const b = this.b; let o = this.t.avar.off + 6;
    this.avar = [];
    for (let a = 0; a < this.axes.length; a++) {
      const n = b.readUInt16BE(o); o += 2;
      const map = [];
      for (let i = 0; i < n; i++) { map.push([b.readInt16BE(o) / 16384, b.readInt16BE(o + 2) / 16384]); o += 4; }
      this.avar.push(map);
    }
  }
  normalize(values) {
    return this.axes.map((ax, i) => {
      let v = values[ax.tag] ?? ax.def;
      v = Math.min(ax.max, Math.max(ax.min, v));
      let n = v < ax.def ? -(ax.def - v) / (ax.def - ax.min) : v > ax.def ? (v - ax.def) / (ax.max - ax.def) : 0;
      if (this.avar && this.avar[i] && this.avar[i].length) {
        const m = this.avar[i];
        for (let k = 1; k < m.length; k++) {
          if (n <= m[k][0]) { const [x0, y0] = m[k - 1], [x1, y1] = m[k]; n = y0 + ((n - x0) * (y1 - y0)) / (x1 - x0 || 1); break; }
        }
      }
      return n;
    });
  }
  parseGvar() {
    const b = this.b, o = this.t.gvar.off;
    this.gv = {
      o, axisCount: b.readUInt16BE(o + 4), sharedCount: b.readUInt16BE(o + 6), sharedOff: b.readUInt32BE(o + 8),
      glyphCount: b.readUInt16BE(o + 12), flags: b.readUInt16BE(o + 14), dataOff: b.readUInt32BE(o + 16),
    };
    const g = this.gv;
    g.shared = [];
    for (let i = 0; i < g.sharedCount; i++) {
      const t = [];
      for (let a = 0; a < g.axisCount; a++) t.push(b.readInt16BE(o + g.sharedOff + (i * g.axisCount + a) * 2) / 16384);
      g.shared.push(t);
    }
    g.offs = [];
    for (let i = 0; i <= g.glyphCount; i++) g.offs.push(g.flags & 1 ? b.readUInt32BE(o + 20 + i * 4) : b.readUInt16BE(o + 20 + i * 2) * 2);
  }
  // Puntos sin variar: contornos (simple) o componentes (compuesto), más 4 puntos fantasma.
  rawGlyph(gid) {
    const b = this.b, start = this.t.glyf.off + this.loca[gid], end = this.t.glyf.off + this.loca[gid + 1];
    const adv = this.advanceDefault(gid), lsb = this.lsbDefault(gid);
    if (end <= start) return { type: 'empty', points: [], ends: [], comps: [], phantom: [[0, 0], [adv, 0], [0, 0], [0, 0]] };
    const nc = b.readInt16BE(start), xMin = b.readInt16BE(start + 2);
    const phantom = [[xMin - lsb, 0], [xMin - lsb + adv, 0], [0, 0], [0, 0]];
    if (nc >= 0) {
      const ends = [];
      for (let i = 0; i < nc; i++) ends.push(b.readUInt16BE(start + 10 + i * 2));
      const np = nc ? ends[nc - 1] + 1 : 0;
      let p = start + 10 + nc * 2;
      const il = b.readUInt16BE(p); p += 2 + il;
      const flags = [];
      while (flags.length < np) { const f = b[p++]; flags.push(f); if (f & 8) { let r = b[p++]; while (r--) flags.push(f); } }
      const xs = [], ys = [];
      let v = 0;
      for (const f of flags) { if (f & 2) { const d = b[p++]; v += f & 16 ? d : -d; } else if (!(f & 16)) { v += b.readInt16BE(p); p += 2; } xs.push(v); }
      v = 0;
      for (const f of flags) { if (f & 4) { const d = b[p++]; v += f & 32 ? d : -d; } else if (!(f & 32)) { v += b.readInt16BE(p); p += 2; } ys.push(v); }
      return { type: 'simple', ends, points: xs.map((x, i) => [x, ys[i], !!(flags[i] & 1)]), phantom };
    }
    // Compuesto.
    let p = start + 10, more = true;
    const comps = [];
    while (more) {
      const f = b.readUInt16BE(p), gi = b.readUInt16BE(p + 2); p += 4;
      let dx, dy;
      if (f & 1) { dx = f & 2 ? b.readInt16BE(p) : b.readUInt16BE(p); dy = f & 2 ? b.readInt16BE(p + 2) : b.readUInt16BE(p + 2); p += 4; }
      else { dx = f & 2 ? b.readInt8(p) : b[p]; dy = f & 2 ? b.readInt8(p + 1) : b[p + 1]; p += 2; }
      let m = [1, 0, 0, 1];
      if (f & 8) { const s = b.readInt16BE(p) / 16384; m = [s, 0, 0, s]; p += 2; }
      else if (f & 0x40) { m = [b.readInt16BE(p) / 16384, 0, 0, b.readInt16BE(p + 2) / 16384]; p += 4; }
      else if (f & 0x80) { m = [b.readInt16BE(p) / 16384, b.readInt16BE(p + 2) / 16384, b.readInt16BE(p + 4) / 16384, b.readInt16BE(p + 6) / 16384]; p += 8; }
      comps.push({ gid: gi, dx, dy, m, xy: !!(f & 2) });
      more = !!(f & 0x20);
    }
    return { type: 'composite', comps, phantom };
  }
  tupleScalar(peak, startT, endT, coords) {
    let s = 1;
    for (let a = 0; a < peak.length; a++) {
      const pk = peak[a], c = coords[a];
      if (pk === 0) continue;
      if (c === 0) return 0;
      if (startT) {
        const st = startT[a], en = endT[a];
        if (st > pk || pk > en || (st < 0 && en > 0)) continue;
        if (c < st || c > en) return 0;
        if (c < pk) s *= (c - st) / (pk - st); else if (c > pk) s *= (en - c) / (en - pk);
      } else {
        if (Math.sign(c) !== Math.sign(pk) || Math.abs(c) > Math.abs(pk)) return 0;
        s *= c / pk;
      }
    }
    return s;
  }
  // Deltas de gvar para un glifo con n puntos (incluidos los fantasma).
  deltas(gid, n, coords, contoursEnds, basePts) {
    const b = this.b, g = this.gv;
    const dx = new Float64Array(n), dy = new Float64Array(n);
    const start = g.o + g.dataOff + g.offs[gid], end = g.o + g.dataOff + g.offs[gid + 1];
    if (end <= start) return { dx, dy };
    let p = start;
    const tc = b.readUInt16BE(p), dataOff = b.readUInt16BE(p + 2);
    const count = tc & 0x0fff, sharedPts = !!(tc & 0x8000);
    p += 4;
    const headers = [];
    for (let i = 0; i < count; i++) {
      const size = b.readUInt16BE(p), ti = b.readUInt16BE(p + 2); p += 4;
      let peak;
      if (ti & 0x8000) { peak = []; for (let a = 0; a < g.axisCount; a++) { peak.push(b.readInt16BE(p) / 16384); p += 2; } }
      else peak = g.shared[ti & 0x0fff];
      let st = null, en = null;
      if (ti & 0x4000) { st = []; en = []; for (let a = 0; a < g.axisCount; a++) { st.push(b.readInt16BE(p) / 16384); p += 2; } for (let a = 0; a < g.axisCount; a++) { en.push(b.readInt16BE(p) / 16384); p += 2; } }
      headers.push({ size, priv: !!(ti & 0x2000), peak, st, en });
    }
    let d = start + dataOff;
    const readPoints = () => {
      let c = b[d++];
      if (c === 0) return null; // todos los puntos
      if (c & 0x80) c = ((c & 0x7f) << 8) | b[d++];
      const pts = [];
      let last = 0;
      while (pts.length < c) {
        const ctl = b[d++], run = (ctl & 0x7f) + 1, words = ctl & 0x80;
        for (let k = 0; k < run && pts.length < c; k++) { const v = words ? b.readUInt16BE((d += 2) - 2) : b[d++]; last += v; pts.push(last); }
      }
      return pts;
    };
    const readDeltas = (cnt) => {
      const out = [];
      while (out.length < cnt) {
        const ctl = b[d++], run = (ctl & 0x3f) + 1;
        if (ctl & 0x80) { for (let k = 0; k < run; k++) out.push(0); }
        else if (ctl & 0x40) { for (let k = 0; k < run; k++) { out.push(b.readInt16BE(d)); d += 2; } }
        else { for (let k = 0; k < run; k++) out.push(b.readInt8(d++)); }
      }
      return out;
    };
    const shared = sharedPts ? readPoints() : null;
    for (const h of headers) {
      const tupleStart = d;
      const pts = h.priv ? readPoints() : shared;
      const cnt = pts ? pts.length : n;
      const xd = readDeltas(cnt), yd = readDeltas(cnt);
      d = tupleStart + h.size;
      const s = this.tupleScalar(h.peak, h.st, h.en, coords);
      if (!s) continue;
      if (!pts) { for (let i = 0; i < n; i++) { dx[i] += xd[i] * s; dy[i] += yd[i] * s; } continue; }
      // Puntos tocados; el resto se interpola (IUP) dentro de cada contorno.
      const tx = new Float64Array(n), ty = new Float64Array(n), touched = new Uint8Array(n);
      pts.forEach((pi, k) => { if (pi < n) { tx[pi] += xd[k]; ty[pi] += yd[k]; touched[pi] = 1; } });
      if (contoursEnds && basePts) {
        let cs = 0;
        for (const ce of contoursEnds) {
          this.iup(basePts, tx, ty, touched, cs, ce);
          cs = ce + 1;
        }
      }
      for (let i = 0; i < n; i++) { dx[i] += tx[i] * s; dy[i] += ty[i] * s; }
    }
    return { dx, dy };
  }
  iup(pts, tx, ty, touched, s, e) {
    const idx = [];
    for (let i = s; i <= e; i++) if (touched[i]) idx.push(i);
    if (!idx.length) return;
    if (idx.length === 1) { const k = idx[0]; for (let i = s; i <= e; i++) if (!touched[i]) { tx[i] = tx[k]; ty[i] = ty[k]; } return; }
    for (let a = 0; a < idx.length; a++) {
      const p1 = idx[a], p2 = idx[(a + 1) % idx.length];
      let i = p1 + 1 > e ? s : p1 + 1;
      while (i !== p2) {
        for (const [ax, t] of [[0, tx], [1, ty]]) {
          const c1 = pts[p1][ax], c2 = pts[p2][ax], d1 = t[p1], d2 = t[p2], c = pts[i][ax];
          let v;
          if (c1 === c2) v = d1 === d2 ? d1 : 0;
          else {
            const lo = Math.min(c1, c2), hi = Math.max(c1, c2), dlo = c1 < c2 ? d1 : d2, dhi = c1 < c2 ? d2 : d1;
            if (c <= lo) v = dlo; else if (c >= hi) v = dhi; else v = dlo + ((c - lo) * (dhi - dlo)) / (hi - lo);
          }
          t[i] = v;
        }
        i = i + 1 > e ? s : i + 1;
      }
    }
  }
  // Glifo en una instancia: contornos [{pts:[[x,y,on]]}] y avance.
  glyph(gid, coords) {
    const key = gid + ':' + coords.join(',');
    if (this.cache.has(key)) return this.cache.get(key);
    const raw = this.rawGlyph(gid);
    let res;
    if (raw.type === 'simple' || raw.type === 'empty') {
      const base = raw.points.map((p) => [p[0], p[1]]).concat(raw.phantom);
      const n = base.length;
      const { dx, dy } = this.deltas(gid, n, coords, raw.ends.concat([n - 1]).length ? raw.ends : [], base);
      const pts = raw.points.map((p, i) => [p[0] + dx[i], p[1] + dy[i], p[2]]);
      const np = raw.points.length;
      const adv = (raw.phantom[1][0] + dx[np + 1]) - (raw.phantom[0][0] + dx[np]);
      const contours = [];
      let s = 0;
      for (const e of raw.ends) { contours.push(pts.slice(s, e + 1)); s = e + 1; }
      res = { contours, adv, shift: raw.phantom[0][0] + dx[np] };
    } else {
      const n = raw.comps.length + 4;
      const base = raw.comps.map((c) => [c.dx, c.dy]).concat(raw.phantom);
      const { dx, dy } = this.deltas(gid, n, coords, null, base);
      const contours = [];
      raw.comps.forEach((c, i) => {
        const sub = this.glyph(c.gid, coords);
        const ox = c.dx + dx[i], oy = c.dy + dy[i];
        for (const ct of sub.contours) contours.push(ct.map(([x, y, on]) => [c.m[0] * x + c.m[2] * y + ox, c.m[1] * x + c.m[3] * y + oy, on]));
      });
      const adv = (raw.phantom[1][0] + dx[raw.comps.length + 1]) - (raw.phantom[0][0] + dx[raw.comps.length]);
      res = { contours, adv, shift: raw.phantom[0][0] + dx[raw.comps.length] };
    }
    this.cache.set(key, res);
    return res;
  }
  gid(ch) { return this.cmap.get(ch.codePointAt(0)) || 0; }
}

// Contorno TrueType (cuadráticas) → trazado SVG; y hacia abajo y origen en (x0, y0).
function contourToPath(ct, x0, y0, s) {
  const P = ct.map(([x, y, on]) => [x0 + x * s, y0 - y * s, on]);
  const n = P.length;
  if (!n) return '';
  let startIdx = P.findIndex((p) => p[2]);
  let start;
  if (startIdx < 0) { start = [(P[0][0] + P[1][0]) / 2, (P[0][1] + P[1][1]) / 2]; startIdx = 0; }
  else start = P[startIdx];
  const f = (v) => +v.toFixed(2);
  let d = `M${f(start[0])} ${f(start[1])}`;
  let i = (startIdx + 1) % n, prevOff = null, count = 0;
  while (count < n) {
    const p = P[i];
    if (p[2]) {
      if (prevOff) { d += `Q${f(prevOff[0])} ${f(prevOff[1])} ${f(p[0])} ${f(p[1])}`; prevOff = null; }
      else d += `L${f(p[0])} ${f(p[1])}`;
    } else {
      if (prevOff) { const mx = (prevOff[0] + p[0]) / 2, my = (prevOff[1] + p[1]) / 2; d += `Q${f(prevOff[0])} ${f(prevOff[1])} ${f(mx)} ${f(my)}`; }
      prevOff = p;
    }
    i = (i + 1) % n; count++;
    if (i === (startIdx + 1) % n && count >= n) break;
  }
  if (prevOff) d += `Q${f(prevOff[0])} ${f(prevOff[1])} ${f(start[0])} ${f(start[1])}`;
  return d + 'Z';
}

// Texto → { d, width } con espaciado (tracking en unidades de em) y kerning manual opcional.
function textPath(font, str, { size = 100, weight = 400, x = 0, y = 0, tracking = 0, kern = {} } = {}) {
  const coords = font.normalize({ wght: weight });
  const s = size / font.upm;
  let pen = x, d = '';
  const chars = [...str];
  chars.forEach((ch, i) => {
    const g = font.glyph(font.gid(ch), coords);
    for (const ct of g.contours) d += contourToPath(ct, pen, y, s);
    pen += g.adv * s + tracking * size + ((kern[chars[i] + (chars[i + 1] || '')] || 0) * s);
  });
  return { d, width: pen - x - tracking * size };
}

module.exports = { Font, textPath, contourToPath };
