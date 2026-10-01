(function () {
  'use strict';
  var React = window.React;
  var h = React.createElement;
  var useState = React.useState, useEffect = React.useEffect, useRef = React.useRef, useId = React.useId;

  /* Íconos: [trazado, banderas] en la retícula de 24. s = trazo, i = relleno, b = recorte del fondo, a = azul. */
  var ICONS = __ICONS__;
  /* Contornos del logotipo «relevo» (Schibsted Grotesk 650, unidades de la fuente, UPM 2048). */
  var WORDMARK = __WORDMARK__;

  function cx() {
    var out = [];
    for (var i = 0; i < arguments.length; i++) if (arguments[i]) out.push(arguments[i]);
    return out.join(' ');
  }
  function reduceMotion() {
    return typeof window.matchMedia === 'function' && window.matchMedia('(prefers-reduced-motion: reduce)').matches;
  }
  function safeId(id) { return 'rl' + String(id).replace(/[^A-Za-z0-9]/g, ''); }
  function optValue(o) { return Array.isArray(o) ? o[0] : o.value; }
  function optLabel(o) { return Array.isArray(o) ? o[1] : o.label; }

  /* ---------- Marca ---------- */

  /** Trazo según el tamaño, como RelevoIcon: 16 → 1,9; 20 → 1,8; 24 → 1,75; 32 → 1,6; más → 1,5. */
  function strokeFor(size) { return size <= 16 ? 1.9 : size <= 20 ? 1.8 : size <= 24 ? 1.75 : size <= 32 ? 1.6 : 1.5; }

  function Icon(props) {
    var size = props.size || 24;
    var parts = ICONS[props.name];
    var uid = safeId(useId());
    if (!parts) return null;
    var sw = props.strokeWidth != null ? props.strokeWidth : strokeFor(size);
    var accent = props.mono ? 'currentColor' : 'var(--blue)';
    var masks = [];
    var body = [];
    parts.forEach(function (p, i) {
      var f = p[1], col = f.indexOf('a') >= 0 ? accent : 'currentColor';
      if (f.indexOf('b') >= 0) {
        var id = uid + 'k' + i;
        masks.push(h('mask', { key: id, id: id, maskUnits: 'userSpaceOnUse', x: -2, y: -2, width: 28, height: 28 },
          h('rect', { x: -2, y: -2, width: 28, height: 28, fill: '#fff' }), h('path', { d: p[0], fill: '#000' })));
        body = [h('g', { key: 'g' + i, mask: 'url(#' + id + ')' }, body)];
        if (f.indexOf('s') >= 0) body.push(h('path', { key: i, d: p[0], fill: 'none', stroke: col }));
        return;
      }
      body.push(h('path', { key: i, d: p[0], fill: f.indexOf('i') >= 0 ? col : 'none', stroke: f.indexOf('s') >= 0 ? col : 'none' }));
    });
    var a11y = props.label ? { role: 'img', 'aria-label': props.label } : { 'aria-hidden': 'true', focusable: 'false' };
    return h('svg', Object.assign({
      className: cx('rl-icon', props.className), viewBox: '0 0 24 24', width: size, height: size, fill: 'none',
      strokeWidth: sw, strokeLinecap: 'round', strokeLinejoin: 'round', style: Object.assign({ color: props.color }, props.style),
    }, a11y), masks.length ? h('defs', null, masks) : null, body);
  }
  Icon.names = Object.keys(ICONS);

  /** Logotipo «relevo» con su renglón: del ancho de la palabra y 0,075 em de alto. size = alto de las letras. */
  function Wordmark(props) {
    var size = props.size || 22;
    var tone = props.tone || 'ink';
    var letters = { 'on-blue': 'var(--on-blue)', white: 'var(--blanco)', paper: 'var(--papel)' }[tone] || 'var(--ink)';
    var line = { 'on-blue': 'var(--on-blue)', white: 'var(--blanco)', paper: 'var(--azul-300)' }[tone] || 'var(--blue)';
    return h('svg', {
      className: cx('rl-wordmark', props.className), viewBox: '145 -1500 5910 2137', role: 'img', 'aria-label': 'relevo',
      width: Math.round(size * 5910 / 1500 * 10) / 10, height: Math.round(size * 2137 / 1500 * 10) / 10, style: props.style,
    },
    h('g', { fill: letters }, WORDMARK.map(function (d, i) { return h('path', { key: i, d: d }); })),
    props.line === false ? null : h('rect', { x: 145, y: 483, width: 5910, height: 154, fill: line }));
  }

  /** El renglón bajo una palabra: lo que importa en la frase. Uno por pantalla y nunca bajo texto azul. */
  function Subrayado(props) {
    return h('span', { className: cx('rl-sub', props.tone && 'rl-sub--' + props.tone, props.className) }, props.children);
  }

  /* ---------- Trama ---------- */

  function cssVar(el, name, fallback) {
    var v = getComputedStyle(el).getPropertyValue(name).trim();
    return v || fallback;
  }
  function parseColor(c) {
    var m = /^#([0-9a-f]{6})/i.exec(c);
    if (m) return [parseInt(m[1].slice(0, 2), 16), parseInt(m[1].slice(2, 4), 16), parseInt(m[1].slice(4, 6), 16)];
    m = /rgba?\(([^)]+)\)/.exec(c);
    if (m) return m[1].split(',').slice(0, 3).map(function (x) { return parseFloat(x); });
    return [61, 56, 245];
  }
  function mixRgb(a, b, t) { return 'rgb(' + a.map(function (v, k) { return Math.round(v + (b[k] - v) * t); }).join(',') + ')'; }
  function fieldValue(nx, ny, seed, dense, t) {
    var a = Math.sin((nx * 1.5 + ny * 0.8) * 3.6 + t * 0.6 + seed);
    var b = Math.sin((-nx * 0.7 + ny * 1.6) * 3.3 - t * 0.45 + 1.3 + seed * 0.7);
    var c = Math.sin((nx * 2.1 - ny * 0.6) * 2.8 + t * 0.3 + 2.1 + seed * 0.4);
    var v = a * 0.55 + b * 0.35 + c * 0.2;
    return 1 / (1 + Math.exp(-3.4 * (v - (dense ? -0.35 : 0.1))));
  }
  function iconCoverage(name, n) {
    var S = 8, R = 24 * S;
    function mk() { var cv = document.createElement('canvas'); cv.width = R; cv.height = R; var x = cv.getContext('2d', { willReadFrequently: true }); x.scale(S, S); return x; }
    var o = mk(), a = mk();
    (ICONS[name] || []).forEach(function (p) {
      var t = p[1].indexOf('a') >= 0 ? a : o, path = new Path2D(p[0]);
      t.lineCap = 'round'; t.lineJoin = 'round'; t.lineWidth = 2.4; t.fillStyle = '#000'; t.strokeStyle = '#000';
      if (p[1].indexOf('i') >= 0) t.fill(path);
      if (p[1].indexOf('s') >= 0) t.stroke(path);
    });
    var d1 = o.getImageData(0, 0, R, R).data, d2 = a.getImageData(0, 0, R, R).data, cell = R / n, out = [];
    for (var j = 0; j < n; j++) for (var i = 0; i < n; i++) {
      var s1 = 0, s2 = 0, cnt = 0;
      for (var y = Math.floor(j * cell); y < Math.floor((j + 1) * cell); y += 2) for (var x = Math.floor(i * cell); x < Math.floor((i + 1) * cell); x += 2) { var k = (y * R + x) * 4 + 3; s1 += d1[k]; s2 += d2[k]; cnt++; }
      out.push([s1 / (cnt * 255), s2 / (cnt * 255)]);
    }
    return out;
  }

  /**
   * Trama de puntos en un lienzo. mode: 'campo' (fondo), 'senal' (late mientras suena), 'foto' (una foto en
   * una sola tinta azul; src del mismo origen) o 'icono' (un ícono en una retícula de 12 o 16 puntos).
   */
  function Trama(props) {
    var ref = useRef(null);
    var mode = props.mode || 'campo';
    useEffect(function () {
      var cv = ref.current;
      if (!cv) return undefined;
      var alive = true, raf = 0, visible = true, img = null, cover = null, t0 = performance.now();
      var animate = (props.animate !== false) && mode === 'senal' && !reduceMotion();
      function draw(t) {
        var dpr = Math.min(2, window.devicePixelRatio || 1), w = cv.clientWidth, hh = cv.clientHeight;
        if (!w || !hh) return;
        if (cv.width !== Math.round(w * dpr) || cv.height !== Math.round(hh * dpr)) { cv.width = Math.round(w * dpr); cv.height = Math.round(hh * dpr); }
        var ctx = cv.getContext('2d');
        ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
        ctx.clearRect(0, 0, w, hh);
        var blue = parseColor(cssVar(cv, '--blue', '#3d38f5'));
        var dots = parseColor(cssVar(cv, '--blue-dots', '#c4c2fc'));
        var ink = cssVar(cv, '--ink', '#17181c');
        var paper = parseColor(cssVar(cv, '--paper', '#f2f2ef'));
        var dark = (paper[0] + paper[1] + paper[2]) / 3 < 100;
        var faint = dark ? 'rgba(255,255,255,.10)' : 'rgba(60,60,120,.14)';
        var TAU = Math.PI * 2, i, j, x, y, v, r;
        if (mode === 'icono') {
          var n = props.grid || 16, step = Math.min(w, hh) / n, ox = (w - step * n) / 2, oy = (hh - step * n) / 2;
          if (!cover) cover = iconCoverage(props.icon || 'actividad', n);
          for (j = 0; j < n; j++) for (i = 0; i < n; i++) {
            var cvv = cover[j * n + i], cov = Math.max(cvv[0], cvv[1]);
            x = ox + i * step + step / 2; y = oy + j * step + step / 2;
            ctx.beginPath();
            if (cov < 0.08) { ctx.fillStyle = faint; ctx.arc(x, y, step * 0.12, 0, TAU); ctx.fill(); continue; }
            ctx.fillStyle = cvv[1] > cvv[0] ? 'rgb(' + blue.join(',') + ')' : ink;
            ctx.arc(x, y, step * 0.5 * Math.min(1, 0.35 + 0.75 * Math.sqrt(cov)), 0, TAU); ctx.fill();
          }
          return;
        }
        var pitch = props.pitch || (mode === 'senal' ? 7 : 6);
        var cols = Math.ceil(w / pitch), rows = Math.ceil(hh / pitch);
        if (mode === 'foto') {
          if (!img || !img.complete || !img.naturalWidth) return;
          var off = document.createElement('canvas'); off.width = cols; off.height = rows;
          var o = off.getContext('2d', { willReadFrequently: true });
          var ir = img.naturalWidth / img.naturalHeight, cr = cols / rows, sw, sh, sx, sy;
          if (ir > cr) { sh = img.naturalHeight; sw = sh * cr; sx = (img.naturalWidth - sw) / 2; sy = 0; } else { sw = img.naturalWidth; sh = sw / cr; sx = 0; sy = (img.naturalHeight - sh) * 0.55; }
          o.drawImage(img, sx, sy, sw, sh, 0, 0, cols, rows);
          var data;
          try { data = o.getImageData(0, 0, cols, rows).data; } catch (e) { return; }
          var lo = 1, hi = 0, dk = new Float32Array(cols * rows);
          for (var k = 0; k < cols * rows; k++) { var d = 1 - (0.2126 * data[k * 4] + 0.7152 * data[k * 4 + 1] + 0.0722 * data[k * 4 + 2]) / 255; dk[k] = d; if (d < lo) lo = d; if (d > hi) hi = d; }
          var span = Math.max(0.05, hi - lo);
          if (props.background) { ctx.fillStyle = props.background; ctx.fillRect(0, 0, w, hh); }
          for (j = 0; j < rows; j++) for (i = 0; i < cols; i++) {
            v = (dk[j * cols + i] - lo) / span; x = i * pitch + pitch / 2; y = j * pitch + pitch / 2;
            ctx.beginPath();
            if (v < 0.06) { ctx.fillStyle = faint; ctx.arc(x, y, pitch * 0.14, 0, TAU); ctx.fill(); continue; }
            ctx.fillStyle = 'rgb(' + blue.join(',') + ')';
            ctx.arc(x, y, pitch * 0.5 * (0.16 + 0.88 * Math.pow(v, 0.85)), 0, TAU); ctx.fill();
          }
          return;
        }
        var seed = props.seed != null ? props.seed : (mode === 'senal' ? 1.1 : 0.7);
        for (j = 0; j < rows; j++) for (i = 0; i < cols; i++) {
          var nx = i / cols, ny = j / rows;
          v = fieldValue(nx, ny, seed, true, animate ? t * 0.35 : 0);
          x = i * pitch + pitch / 2; y = j * pitch + pitch / 2;
          ctx.beginPath();
          if (v < 0.16) { ctx.fillStyle = faint; ctx.arc(x, y, pitch * 0.17, 0, TAU); ctx.fill(); continue; }
          ctx.fillStyle = mixRgb(dots, blue, v);
          var pulse = animate ? 1 + 0.16 * Math.sin(t * 5.4 - (nx + ny) * 7) : 1;
          r = Math.min(pitch * 0.56, pitch * 0.5 * (0.24 + 0.8 * v) * pulse);
          ctx.arc(x, y, r, 0, TAU); ctx.fill();
        }
      }
      function loop(now) {
        if (!alive) return;
        if (visible) draw((now - t0) / 1000);
        raf = requestAnimationFrame(loop);
      }
      if (mode === 'foto' && props.src) {
        img = new Image();
        img.onload = function () { if (alive) draw(0); };
        img.src = props.src;
      }
      draw(0);
      var ro = typeof ResizeObserver === 'function' ? new ResizeObserver(function () { draw((performance.now() - t0) / 1000); }) : null;
      if (ro) ro.observe(cv);
      var io = null;
      if (animate) {
        if (typeof IntersectionObserver === 'function') {
          io = new IntersectionObserver(function (entries) { visible = entries[0].isIntersecting; });
          io.observe(cv);
        }
        raf = requestAnimationFrame(loop);
      }
      return function () { alive = false; cancelAnimationFrame(raf); if (ro) ro.disconnect(); if (io) io.disconnect(); };
    }, [mode, props.src, props.icon, props.grid, props.pitch, props.seed, props.animate, props.background]);
    return h('canvas', {
      ref: ref, className: cx('rl-trama', props.className), style: props.style,
      role: props.label ? 'img' : undefined, 'aria-label': props.label || undefined, 'aria-hidden': props.label ? undefined : 'true',
    });
  }

  /** El tiempo en puntos: un punto por minuto en las apps elegidas; sobre 60, un punto cada 5 minutos. */
  function TimeDots(props) {
    var total = Math.max(1, props.total || 15);
    var value = Math.max(0, Math.min(props.value || 0, total));
    var unit = total > 60 ? 5 : 1;
    var n = Math.ceil(total / unit), on = Math.floor(value / unit), dots = [];
    for (var i = 0; i < n; i++) dots.push(h('i', { key: i, className: cx('rl-time__dot', i < on && 'is-on') }));
    return h('div', { className: cx('rl-time', props.dense && 'rl-time--dense', props.className) },
      h('div', { className: 'rl-time__dots', role: 'img', 'aria-label': value + ' de ' + total + ' minutos' }, dots),
      props.caption === false ? null : h('p', { className: 'rl-time__label' }, h('b', null, value + ' min'), ' de ' + total));
  }

  /* ---------- Acciones ---------- */

  function Button(props) {
    var kind = props.kind || 'primary';
    return h('button', {
      type: props.type || 'button', className: cx('rl-btn', 'rl-btn--' + kind, props.compact && 'rl-btn--compact', props.muted && 'rl-btn--muted', props.className),
      disabled: props.disabled, onClick: props.onClick, 'aria-disabled': props.muted ? 'true' : undefined, style: props.style,
    },
    props.icon ? h(Icon, { name: props.icon, size: props.compact ? 18 : 20, strokeWidth: 2 }) : null,
    h('span', null, props.children != null ? props.children : props.label));
  }

  function MissingHint(props) {
    return h('div', { className: cx('rl-hint', props.className), role: 'status' },
      h(Icon, { name: 'info', size: 18, strokeWidth: 2 }), h('span', null, props.text != null ? props.text : props.children));
  }

  /** Botón que dice qué falta: con missing, se ve apagado pero responde mostrando el aviso encima. */
  function GuardedButton(props) {
    var s = useState(null), shown = s[0], setShown = s[1];
    var b = useState(0), bump = b[0], setBump = b[1];
    var missing = props.missing == null ? null : props.missing;
    useEffect(function () { setShown(function (prev) { return missing == null ? null : prev == null ? null : missing; }); }, [missing]);
    function click(e) {
      if (missing != null) {
        if (shown === missing && !reduceMotion()) setBump(function (n) { return n + 1; });
        setShown(missing);
        if (props.onMissing) props.onMissing(missing);
      } else if (props.onClick) props.onClick(e);
    }
    return h('div', { className: cx('rl-guarded', props.className) },
      h('div', { className: cx('rl-guarded__hint', shown != null && 'is-open') },
        h('div', { className: 'rl-guarded__inner' }, shown != null ? h(MissingHint, { key: bump, text: shown, className: bump ? 'rl-bump' : null }) : null)),
      h(Button, { kind: props.kind, icon: props.icon, muted: missing != null, onClick: click }, props.children != null ? props.children : props.label));
  }

  function PlainAction(props) {
    return h('button', { type: 'button', className: cx('rl-plain', props.className), disabled: props.disabled, onClick: props.onClick, style: Object.assign({ color: props.color }, props.style) },
      props.icon ? h(Icon, { name: props.icon, size: 20 }) : null, h('span', null, props.children != null ? props.children : props.label));
  }

  function IconAction(props) {
    return h('button', { type: 'button', className: cx('rl-iconbtn', props.filled && 'is-filled', props.className), 'aria-label': props.label, onClick: props.onClick },
      h(Icon, { name: props.icon, size: 20 }));
  }

  function GlassIconButton(props) {
    var size = props.size || 44;
    return h('button', { type: 'button', className: cx('rl-glass-btn', props.className), 'aria-label': props.label, onClick: props.onClick, style: { width: size, height: size } },
      h(Icon, { name: props.icon, size: 20, strokeWidth: 2 }));
  }

  function GlassTextButton(props) {
    return h('button', { type: 'button', className: cx('rl-glass-text', props.className), onClick: props.onClick, style: { color: props.color } },
      props.icon ? h(Icon, { name: props.icon, size: 18 }) : null, h('span', null, props.children != null ? props.children : props.label));
  }

  /* ---------- Selección ---------- */

  function SegmentedControl(props) {
    var options = props.options || [];
    var idx = -1;
    options.forEach(function (o, i) { if (optValue(o) === props.value) idx = i; });
    var allowDeselect = props.allowDeselect !== false;
    return h('div', { className: cx('rl-seg', props.className), role: 'radiogroup', 'aria-label': props.label, style: { '--n': options.length, '--i': Math.max(0, idx) } },
      h('span', { className: cx('rl-seg__thumb', idx < 0 && 'is-hidden'), 'aria-hidden': 'true' }),
      options.map(function (o, i) {
        var active = i === idx;
        return h('button', {
          key: String(optValue(o)), type: 'button', role: 'radio', 'aria-checked': active ? 'true' : 'false', className: cx('rl-seg__opt', active && 'is-on'),
          onClick: function () { if (props.onChange) props.onChange(active && allowDeselect ? null : optValue(o)); },
        }, optLabel(o));
      }));
  }

  function ScaleControl(props) {
    var opts = [1, 2, 3, 4, 5].map(function (n) { return [n, String(n)]; });
    return h('div', { className: cx('rl-scale', props.className) },
      h(SegmentedControl, { options: opts, value: props.value, onChange: props.onChange, label: props.label }),
      h('div', { className: 'rl-scale__ends' }, h('span', null, '1 · ' + (props.low || 'Nada')), h('span', null, '5 · ' + (props.high || 'Mucho'))));
  }

  function QuickChoice(props) {
    return h('button', { type: 'button', className: cx('rl-chip', props.selected && 'is-on', props.className), 'aria-pressed': props.selected ? 'true' : 'false', onClick: props.onClick },
      props.icon ? h(Icon, { name: props.icon, size: 18 }) : null, h('span', null, props.children != null ? props.children : props.label));
  }

  function CheckMark(props) {
    var size = props.size || 24, box = size * 0.6;
    return h('span', { className: cx('rl-check', props.checked && 'is-on', props.className), style: { width: size, height: size }, 'aria-hidden': 'true' },
      h('svg', { viewBox: '0 0 10 10', width: box, height: box }, h('path', { d: 'M1.2 5.2L4 7.8L8.8 2.4', pathLength: 1, strokeWidth: 2.2 * 10 / box })));
  }

  function RadioMark(props) {
    return h('span', { className: cx('rl-radio', props.selected && 'is-on', props.className), 'aria-hidden': 'true' });
  }

  function StarRating(props) {
    var value = props.value || 0;
    return h('div', { className: cx('rl-stars', props.className), role: 'radiogroup', 'aria-label': props.label || 'Calificación' },
      [1, 2, 3, 4, 5].map(function (n) {
        var filled = value >= n;
        return h('button', {
          key: n, type: 'button', role: 'radio', 'aria-checked': value === n ? 'true' : 'false', 'aria-label': n + ' de 5', className: cx('rl-star', filled && 'is-on'),
          onClick: function () { if (props.onChange) props.onChange(value === n ? null : n); },
        }, h(Icon, { name: filled ? 'estrella-llena' : 'estrella', size: 34 }));
      }));
  }

  function formatDuration(seconds) {
    if (seconds < 60) return seconds + ' s';
    if (seconds % 3600 === 0) return seconds / 3600 + ' h';
    if (seconds > 3600) return Math.floor(seconds / 3600) + ' h ' + Math.floor((seconds % 3600) / 60) + ' min';
    return Math.floor(seconds / 60) + ' min';
  }

  /** Botón − o + que repite el paso al mantenerlo presionado (450 ms y luego cada 110 ms). */
  function RepeatButton(props) {
    var timer = useRef(null), stepRef = useRef(props.onStep);
    stepRef.current = props.onStep;
    function stop() { if (timer.current) { clearTimeout(timer.current); clearInterval(timer.current); timer.current = null; } }
    useEffect(function () { return stop; }, []);
    useEffect(function () { if (props.disabled) stop(); }, [props.disabled]);
    return h('button', {
      type: 'button', className: 'rl-step', disabled: props.disabled, 'aria-label': props.label,
      onClick: function () { stepRef.current(); },
      onPointerDown: function () {
        stop();
        timer.current = setTimeout(function () { timer.current = setInterval(function () { stepRef.current(); }, 110); }, 450);
      },
      onPointerUp: stop, onPointerLeave: stop, onPointerCancel: stop,
    }, props.symbol);
  }

  function DurationStepper(props) {
    var seconds = props.seconds;
    function step(c) { return c < 600 ? 60 : c < 3600 ? 300 : c < 7200 ? 900 : 1800; }
    function dec() { if (props.onChange) props.onChange(Math.max(60, seconds - step(seconds - 1))); }
    function inc() { if (props.onChange) props.onChange(Math.min(21600, seconds + step(seconds))); }
    return h('div', { className: cx('rl-stepper', props.className) },
      h('div', { className: 'rl-stepper__text' },
        h('span', { key: seconds, className: 'rl-stepper__value', 'aria-live': 'polite' }, formatDuration(seconds)),
        h('span', { className: 'rl-stepper__label' }, props.label)),
      h(RepeatButton, { label: 'Restar tiempo', symbol: '−', disabled: seconds <= 60, onStep: dec }),
      h(RepeatButton, { label: 'Sumar tiempo', symbol: '+', disabled: seconds >= 21600, onStep: inc }));
  }

  function CountStepper(props) {
    var min = props.min != null ? props.min : 1, max = props.max != null ? props.max : 7, value = props.value;
    return h('div', { className: cx('rl-stepper', props.className) },
      h('span', { className: 'rl-stepper__count', 'aria-live': 'polite' }, props.label),
      h(RepeatButton, { label: 'Restar', symbol: '−', disabled: value <= min, onStep: function () { if (props.onChange) props.onChange(Math.max(min, value - 1)); } }),
      h(RepeatButton, { label: 'Sumar', symbol: '+', disabled: value >= max, onStep: function () { if (props.onChange) props.onChange(Math.min(max, value + 1)); } }));
  }

  /* ---------- Campos ---------- */

  /** El renglón: lo que escribe la persona en tinta sobre una línea azul (1,5 px; 2,5 px con foco). */
  function RenglonField(props) {
    var Tag = props.multiline ? 'textarea' : 'input';
    var controlled = props.value !== undefined;
    var attrs = {
      className: 'rl-field__input', placeholder: props.placeholder, maxLength: props.maxLength || (props.multiline ? 600 : 120),
      autoCapitalize: 'sentences', rows: props.multiline ? 3 : undefined, onKeyDown: props.onKeyDown,
      onChange: function (e) { if (props.onChange) props.onChange(e.target.value); },
    };
    if (controlled) attrs.value = props.value; else attrs.defaultValue = props.defaultValue;
    return h('label', { className: cx('rl-field', props.className) },
      h('span', { className: 'rl-field__label' }, props.label), h(Tag, attrs));
  }

  function RenglonArea(props) {
    return h(RenglonField, Object.assign({}, props, { multiline: true, maxLength: props.maxLength || 600 }));
  }

  function SearchField(props) {
    var s = useState(props.defaultValue || ''), inner = s[0], setInner = s[1];
    var value = props.value !== undefined ? props.value : inner;
    function set(v) { if (props.value === undefined) setInner(v); if (props.onChange) props.onChange(v); }
    return h('div', { className: cx('rl-search', value && 'has-value', props.className), role: 'search' },
      h(Icon, { name: 'buscar', size: 20 }),
      h('input', { className: 'rl-search__input', type: 'search', value: value, placeholder: props.placeholder, 'aria-label': props.placeholder, onChange: function (e) { set(e.target.value); } }),
      value ? h(IconAction, { icon: 'cerrar', label: 'Borrar la búsqueda', onClick: function () { set(''); } }) : null);
  }

  /**
   * La firma «Vuelve a ___.»: las palabras de la persona en tinta sobre el renglón azul. El renglón está
   * desde el comienzo y las letras se escriben encima en 450 ms (sin animación si se pide reducir).
   */
  function Signature(props) {
    var prefix = props.prefix != null ? props.prefix : 'Vuelve a ';
    var raw = String(props.words || '').trim().replace(/\.+$/, '');
    var phrase = raw ? raw.charAt(0).toLowerCase() + raw.slice(1) : '';
    var animate = props.animate !== false && !reduceMotion();
    var s = useState(animate ? 0 : phrase.length), shown = s[0], setShown = s[1];
    useEffect(function () {
      if (!animate) { setShown(phrase.length); return undefined; }
      setShown(0);
      var n = 0, len = phrase.length, every = Math.max(16, 450 / Math.max(1, len)), timer = 0;
      function tick() { n += 1; setShown(n); if (n < len) timer = setTimeout(tick, every); }
      timer = setTimeout(tick, every);
      return function () { clearTimeout(timer); };
    }, [phrase, animate]);
    var variant = props.variant || 'title';
    return h(props.as || 'p', { className: cx('rl-signature', 'rl-signature--' + variant, props.className), 'aria-label': prefix + phrase + '.' },
      h('span', { 'aria-hidden': 'true' }, prefix,
        h('span', { className: 'rl-sub' }, phrase.slice(0, shown), h('span', { className: 'rl-signature__rest' }, phrase.slice(shown))), '.'));
  }

  /* ---------- Listas ---------- */

  function ListSection(props) {
    return h('section', { className: cx('rl-section', props.className) },
      props.title ? h('h3', { className: 'rl-section__title' }, props.title) : null,
      h('div', { className: 'rl-section__card' }, props.children),
      props.footer ? h('p', { className: 'rl-section__footer' }, props.footer) : null);
  }

  function IconTile(props) {
    return h('span', { className: cx('rl-icontile', props.className), style: { color: props.tint } }, h(Icon, { name: props.icon, size: 22 }));
  }

  function ListRow(props) {
    var Tag = props.onClick ? 'button' : 'div';
    var lead = props.leading || (props.icon ? h(IconTile, { icon: props.icon, tint: props.iconTint }) : null);
    var hasValue = props.value != null && props.value !== '';
    return h(Tag, {
      type: props.onClick ? 'button' : undefined, onClick: props.onClick,
      className: cx('rl-row', lead && 'rl-row--lead', hasValue && 'rl-row--value', props.onClick && 'rl-row--action', props.className),
    },
    lead ? h('span', { className: 'rl-row__lead' }, lead) : null,
    h('span', { className: 'rl-row__text' },
      h('span', { className: 'rl-row__title', style: { color: props.titleColor } }, props.title),
      props.subtitle ? h('span', { className: 'rl-row__subtitle' }, props.subtitle) : null),
    hasValue ? h('span', { className: cx('rl-row__value', props.valueIsVoice && 'is-voice') }, props.value) : null,
    props.trailing ? h('span', { className: 'rl-row__trailing' }, props.trailing) : null,
    props.chevron ? h(Icon, { name: 'siguiente', size: 16, strokeWidth: 2.2, className: 'rl-row__chevron' }) : null);
  }

  /** Dato con su rótulo para resúmenes: lo que escribió la persona va en voice. */
  function FactRow(props) {
    return h(ListRow, {
      icon: props.icon, title: props.label, value: props.value, valueIsVoice: props.valueIsVoice !== false,
      titleColor: 'var(--graphite)', chevron: !!props.onClick, onClick: props.onClick, className: props.className,
    });
  }

  function Notice(props) {
    var error = props.tone === 'error';
    return h('div', { className: cx('rl-notice', error && 'rl-notice--error', props.className), role: error ? 'alert' : 'note' },
      h('span', { className: 'rl-notice__icon' }, h(Icon, { name: error ? 'error' : (props.icon || 'info'), size: 20 })),
      h('div', { className: 'rl-notice__body' },
        props.title ? h('p', { className: 'rl-notice__title' }, props.title) : null,
        h('p', { className: 'rl-notice__text' }, props.text != null ? props.text : props.children),
        props.actions ? h('div', { className: 'rl-notice__actions' }, props.actions) : null));
  }

  function StatusChip(props) {
    return h('span', { className: cx('rl-status', props.onPanel && 'is-on-panel', props.className) },
      props.icon ? h(Icon, { name: props.icon, size: 16 }) : null, h('span', null, props.text != null ? props.text : props.children));
  }

  function Panel(props) {
    return h('div', { className: cx('rl-panel', props.className), style: Object.assign(props.padding != null ? { padding: props.padding } : {}, props.style) }, props.children);
  }

  function SectionHeader(props) {
    return h('div', { className: cx('rl-sechead', props.className) },
      h('h2', { className: 'rl-sechead__title' }, props.title),
      props.action ? h(PlainAction, { color: 'var(--graphite)', onClick: props.onAction }, props.action) : null);
  }

  /* ---------- Fotos ---------- */

  /** Contenido de una ficha: foto, foto en trama o ícono del kit sobre niebla. */
  function Picture(props) {
    if (props.src && props.trama) return h('span', { className: 'rl-picture' }, h(Trama, { mode: 'foto', src: props.src, pitch: props.pitch || 6, label: props.alt }));
    if (props.src) return h('span', { className: 'rl-picture' }, h('img', { src: props.src, alt: props.alt || '', loading: 'lazy' }));
    return h('span', { className: 'rl-picture rl-picture--icon' }, h(Icon, { name: props.icon || 'actividad', size: props.iconSize || 36, label: props.alt }));
  }

  function PhotoCard(props) {
    return h('button', { type: 'button', className: cx('rl-photocard', props.className), onClick: props.onClick, style: { width: props.width || 152 } },
      h('span', { className: 'rl-photocard__pic' }, h(Picture, { src: props.src, trama: props.trama, icon: props.icon, alt: props.alt, iconSize: 40 })),
      h('span', { className: 'rl-photocard__title' }, props.title),
      props.subtitle ? h('span', { className: 'rl-photocard__sub' }, props.subtitle) : null);
  }

  function PictureTile(props) {
    var r = props.cornerRadius != null ? props.cornerRadius : 22;
    return h('button', {
      type: 'button', role: 'radio', 'aria-checked': props.selected ? 'true' : 'false', 'aria-label': props.description || props.label,
      className: cx('rl-tile', props.selected && 'is-on', props.prominent && 'rl-tile--prominent', props.className), onClick: props.onClick,
      style: { '--aspect': props.aspect || 0.8, '--r': r + 'px' },
    },
    h('span', { className: 'rl-tile__frame' },
      h('span', { className: 'rl-tile__pic' }, h(Picture, { src: props.src, trama: props.trama, icon: props.icon, iconSize: 30 })),
      h('span', { className: 'rl-tile__ring' }),
      props.selected ? h('span', { className: 'rl-tile__check' }, h(CheckMark, { checked: true, size: 22 })) : null),
    props.label ? h('span', { className: 'rl-tile__label' }, props.label) : null);
  }

  /** Foto grande con una banda de vidrio abajo; dark: la foto es oscura bajo el texto y la banda toma el tema oscuro. */
  function PhotoHero(props) {
    var Tag = props.onClick ? 'button' : 'div';
    return h(Tag, {
      type: props.onClick ? 'button' : undefined, onClick: props.onClick, 'aria-label': props.clickLabel,
      className: cx('rl-hero', props.className), style: { '--aspect': props.aspect || 0.9 },
    },
    h('span', { className: 'rl-hero__pic' }, h(Picture, { src: props.src, trama: props.trama, icon: props.icon, alt: props.alt, iconSize: 56 })),
    h('span', { className: 'rl-hero__band', 'data-theme': props.dark ? 'dark' : 'light' }, props.children));
  }

  function Avatar(props) {
    var size = props.size || 72;
    var initial = (props.name || '').trim().charAt(0).toUpperCase();
    var content;
    if (props.src) content = h('img', { src: props.src, alt: '' });
    else if (props.emoji) content = h('span', { className: 'rl-avatar__emoji', style: { fontSize: size * 0.5 } }, props.emoji);
    else if (initial) content = h('span', { style: { fontSize: 28 * size / 72 } }, initial);
    else content = h(Icon, { name: 'perfil', size: Math.round(size * 0.46) });
    return h('span', { className: cx('rl-avatar', props.className), role: 'img', 'aria-label': props.label || props.name || 'Perfil', style: { width: size, height: size, background: props.background } }, content);
  }

  function EmojiTile(props) {
    return h('button', {
      type: 'button', role: 'radio', 'aria-checked': props.selected ? 'true' : 'false', 'aria-label': props.label,
      className: cx('rl-emoji', props.selected && 'is-on', props.className), onClick: props.onClick,
    },
    h('span', { className: 'rl-emoji__disc' }, props.src ? h('img', { src: props.src, alt: '' }) : h('span', { className: 'rl-emoji__char', 'aria-hidden': 'true' }, props.emoji)),
    h('span', { className: 'rl-emoji__ring' }));
  }

  /* ---------- Estructura ---------- */

  function ProgressLine(props) {
    var p = Math.max(0, Math.min(1, props.progress || 0));
    return h('div', {
      className: cx('rl-progress', props.className), role: 'progressbar', 'aria-valuemin': 0, 'aria-valuemax': 100, 'aria-valuenow': Math.round(p * 100), 'aria-label': props.label,
      style: { '--p': p, height: props.height || 6 },
    }, h('span', { className: 'rl-progress__fill' }));
  }

  function StepProgress(props) {
    return h(ProgressLine, { progress: props.progress, className: cx('rl-progress--step', props.className), label: props.step ? 'Paso ' + props.step : 'Avance' });
  }

  function Carousel(props) {
    return h('div', { className: cx('rl-carousel', props.bleed === false && 'is-contained', props.className), style: { '--gap': (props.spacing != null ? props.spacing : 12) + 'px' } }, props.children);
  }

  /** Marco de pantalla de la app: barra de vidrio, título, contenido que se desplaza y acción flotante. */
  function Screen(props) {
    var s = useState(false), scrolled = s[0], setScrolled = s[1];
    var hasTitle = props.title != null;
    return h('div', { className: cx('rl-screen', scrolled && 'is-scrolled', props.bottom && 'has-bottom', props.className), style: Object.assign({ height: props.height }, props.style) },
      h('div', { className: 'rl-screen__bar' },
        h('div', { className: 'rl-screen__side' }, props.onBack ? h(GlassIconButton, { icon: props.closeIcon ? 'cerrar' : 'volver', label: props.backLabel || 'Volver', onClick: props.onBack }) : props.leading),
        h('div', { className: 'rl-screen__center' }, props.progress != null ? h(StepProgress, { progress: props.progress, step: props.step }) : hasTitle && scrolled ? h('span', { className: 'rl-screen__bar-title' }, props.title) : null),
        h('div', { className: 'rl-screen__side rl-screen__side--end' }, props.trailing)),
      h('div', { className: 'rl-screen__scroll', onScroll: function (e) { setScrolled(e.currentTarget.scrollTop > 0); } },
        h('div', { className: 'rl-screen__content' },
          props.header,
          hasTitle ? h('div', { className: 'rl-screen__head' },
            props.eyebrow ? h('p', { className: 'rl-screen__eyebrow' }, props.eyebrow) : null,
            h('h1', { className: cx('rl-screen__title', props.serif === false && 'is-sans') }, props.title),
            props.subtitle ? h('p', { className: 'rl-screen__subtitle' }, props.subtitle) : null) : null,
          props.children)),
      props.bottom ? h('div', { className: 'rl-screen__bottom' }, props.bottom) : null);
  }

  /** Hoja flotante de vidrio. inline: se dibuja dentro de su contenedor (vistas previas, maquetas). */
  function Sheet(props) {
    useEffect(function () {
      if (!props.open) return undefined;
      function onKey(e) { if (e.key === 'Escape' && props.onDismiss) props.onDismiss(); }
      document.addEventListener('keydown', onKey);
      return function () { document.removeEventListener('keydown', onKey); };
    }, [props.open, props.onDismiss]);
    if (!props.open) return null;
    return h('div', { className: cx('rl-sheet-layer', props.inline && 'is-inline') },
      h('div', { className: 'rl-sheet-scrim', onClick: props.onDismiss }),
      h('div', { className: cx('rl-sheet', props.tall && 'is-tall'), role: 'dialog', 'aria-modal': 'true', 'aria-label': props.title },
        h('div', { className: 'rl-sheet__handle' }),
        props.title || props.done ? h('div', { className: 'rl-sheet__head' },
          h('h2', { className: 'rl-sheet__title' }, props.title),
          props.done ? h(GlassTextButton, { onClick: props.onDismiss }, props.done) : null) : null,
        h('div', { className: 'rl-sheet__body' }, props.children)));
  }

  /** Barra de pestañas flotante. En 3.0 la elegida lleva el ícono lleno y su nombre sobre el renglón. */
  function TabBar(props) {
    var items = props.items || [];
    var sel = props.selected || 0;
    return h('nav', { className: cx('rl-tabbar', props.className), role: 'tablist', style: { '--n': items.length, '--i': sel } },
      h('span', { className: 'rl-tabbar__indicator', 'aria-hidden': 'true' }),
      items.map(function (it, i) {
        var active = i === sel;
        return h('button', {
          key: it.label, type: 'button', role: 'tab', 'aria-selected': active ? 'true' : 'false', className: cx('rl-tab', active && 'is-on'),
          onClick: function () { if (props.onSelect) props.onSelect(i); },
        },
        h(Icon, { key: active ? 'on' : 'off', name: active && it.iconSelected ? it.iconSelected : it.icon, size: 24, strokeWidth: active ? 2.1 : 1.7 }),
        h('span', { className: cx('rl-tab__label', active && 'rl-sub') }, it.label));
      }));
  }

  var C = window;
  C.Relevo = Object.assign(C.Relevo || {}, {
    Wordmark: Wordmark, Subrayado: Subrayado, Icon: Icon, Trama: Trama, TimeDots: TimeDots,
    Button: Button, GuardedButton: GuardedButton, MissingHint: MissingHint, PlainAction: PlainAction, IconAction: IconAction,
    GlassIconButton: GlassIconButton, GlassTextButton: GlassTextButton,
    SegmentedControl: SegmentedControl, ScaleControl: ScaleControl, QuickChoice: QuickChoice, CheckMark: CheckMark, RadioMark: RadioMark,
    StarRating: StarRating, DurationStepper: DurationStepper, CountStepper: CountStepper,
    RenglonField: RenglonField, RenglonArea: RenglonArea, SearchField: SearchField, Signature: Signature,
    ListSection: ListSection, ListRow: ListRow, FactRow: FactRow, IconTile: IconTile, Notice: Notice, StatusChip: StatusChip,
    Panel: Panel, SectionHeader: SectionHeader,
    PhotoCard: PhotoCard, PictureTile: PictureTile, PhotoHero: PhotoHero, Avatar: Avatar, EmojiTile: EmojiTile,
    Screen: Screen, StepProgress: StepProgress, ProgressLine: ProgressLine, Carousel: Carousel, Sheet: Sheet, TabBar: TabBar,
    formatDuration: formatDuration,
  });
})();
