// Adapta la escena de 30 s a formato vertical (1080 × 1920) con reemplazos exactos.
const fs = require('fs');
const f = 'vertical.html';
let s = fs.readFileSync(f, 'utf8');
const R = [
  ['<title>Relevo · 15 s</title>', '<title>Relevo · vertical</title>'],
  ['html,body{width:1920px;height:1080px;', 'html,body{width:1080px;height:1920px;'],
  ['#stage{position:relative;width:1920px;height:1080px;', '#stage{position:relative;width:1080px;height:1920px;'],
  ['#s1{background:radial-gradient(1200px 800px at 30% 40%', '#s1{background:radial-gradient(1000px 1200px at 50% 30%'],
  ['#phone{left:250px;top:120px;', '#phone{left:335px;top:110px;'],
  ['#s1text{left:780px;top:250px;width:1000px;', '#s1text{left:90px;top:1040px;width:920px;'],
  ['.big{font-size:108px;', '.big{font-size:96px;'],
  ['#clockRow{margin-top:44px;', '#clockRow{margin-top:36px;'],
  ['#clock{font-size:170px;', '#clock{font-size:150px;'],
  ['.hero{font-size:196px;', '.hero{font-size:168px;'],
  ['#vuelve{left:200px;top:420px}', '#vuelve{left:90px;top:640px}'],
  ['.ruled{left:0;height:2px;width:1920px;', '.ruled{left:0;height:2px;width:1080px;'],
  ['#wordbox{top:420px;height:220px}', '#wordbox{top:840px;height:200px}'],
  ['.word{position:absolute;left:0;top:0;font-size:196px;', '.word{position:absolute;left:0;top:0;font-size:168px;'],
  ['.emo{width:190px;height:190px}', '.emo{width:210px;height:210px}'],
  ['.head{left:200px;top:300px;width:660px;font-size:80px;', '.head{left:90px;top:170px;width:900px;font-size:74px;'],
  ['#card1{left:1030px;top:190px;', '#card1{left:240px;top:600px;'],
  ['#frame{left:1000px;top:160px;width:640px;height:720px;', '#frame{left:140px;top:440px;width:800px;height:1000px;'],
  ['#rail{left:200px;top:958px;width:1520px;', '#rail{left:90px;top:1758px;width:900px;'],
  ['#tu{left:880px;top:130px;font-size:170px;', '#tu{left:90px;top:1030px;font-size:150px;'],
  ['#tusub{left:884px;top:330px;width:880px;font-size:40px;', '#tusub{left:94px;top:1210px;width:900px;font-size:38px;'],
  ['.ans{left:880px;width:800px;height:118px;', '.ans{left:90px;width:900px;height:110px;'],
  ['#logo{left:200px;top:250px;width:1000px}', '#logo{left:90px;top:720px;width:900px}'],
  ['#tag{left:204px;top:660px;font-size:84px;font-weight:650;letter-spacing:-.03em;line-height:1.05;width:1200px}', '#tag{left:94px;top:1020px;font-size:84px;font-weight:650;letter-spacing:-.03em;line-height:1.05;width:900px}'],
  ['.sysrow{left:200px;display:flex;align-items:center;gap:44px;white-space:nowrap}', '.sysrow{left:90px;width:900px;display:flex;align-items:center;gap:36px}'],
  ['.sysic{width:150px;height:150px;', '.sysic{width:136px;height:136px;'],
  ['.systx{font-size:104px;font-weight:650;letter-spacing:-.035em}', '.systx{font-size:74px;font-weight:650;letter-spacing:-.035em;line-height:1.05;flex:1}'],
  ['<div id="s1b" class="abs" style="left:780px;top:330px;width:1000px;color:#F2F2EF">', '<div id="s1b" class="abs" style="left:90px;top:1090px;width:920px;color:#F2F2EF">'],
  ['<div id="cap" class="abs" style="left:204px;top:750px;width:1080px;font-size:54px;', '<div id="cap" class="abs" style="left:94px;top:1150px;width:900px;font-size:54px;'],
  // Composición calculada en el código
  ["d.style.top = (118 + k * 132) + 'px'; rb.appendChild(d); }", "d.style.top = (112 + k * 132) + 'px'; rb.appendChild(d); }"],
  ['for (let k = 0; k < 7; k++) { const d = document', 'for (let k = 0; k < 14; k++) { const d = document'],
  ['for (let k = 0; k < 7; k++) { const a = E.outExpo(P(t, B2 + .05 + k * .05, B2 + .8 + k * .05))', 'for (let k = 0; k < 14; k++) { const a = E.outExpo(P(t, B2 + .05 + k * .04, B2 + .8 + k * .04))'],
  ["const EC = [['1f98a', 1480, 250], ['1f4da', 1660, 400], ['1f3b8', 1440, 480], ['2615', 1640, 640], ['1f33b', 1460, 720], ['1f3a8', 1700, 170]];",
   "const EC = [['1f98a', 110, 300], ['1f4da', 460, 190], ['1f3b8', 810, 330], ['2615', 150, 1420], ['1f33b', 500, 1540], ['1f3a8', 830, 1400]];"],
  ["wordX = $('vuelve').getBoundingClientRect().right + 44;", 'wordX = 90;'],
  ["s2.style.clipPath = t < W1[1] ? `circle(${wipe * 2400}px at 455px 540px)` : 'none';", "s2.style.clipPath = t < W1[1] ? `circle(${wipe * 2000}px at 540px 530px)` : 'none';"],
  ["S($('line'), { left: lerp(wordX - 10, 200, exitL) + 'px', top: lerp(658, 958, exitL) + 'px', width: Math.max(0, lerp(820 * lineIn, 1520, exitL)) + 'px'",
   "S($('line'), { left: lerp(wordX - 4, 90, exitL) + 'px', top: lerp(1052, 1758, exitL) + 'px', width: Math.max(0, lerp(720 * lineIn, 900, exitL)) + 'px'"],
  ["S($('e' + i), { left: '1600px', top: '210px',", "S($('e' + i), { left: '780px', top: '330px',"],
  ["S($('frame'), { left: lerp(1000, 250, m) + 'px', top: lerp(160, 60, m) + 'px', width: lerp(640, 540, m) + 'px', height: lerp(720, 960, m) + 'px'",
   "S($('frame'), { left: lerp(140, 290, m) + 'px', top: lerp(440, 90, m) + 'px', width: lerp(800, 500, m) + 'px', height: lerp(1000, 880, m) + 'px'"],
  ['const ox = 1420, oyEnd = 660,', 'const ox = 665, oyEnd = 1134,'],
  ["S($('place'), { left: '1060px', top: '205px',", "S($('place'), { left: '200px', top: '485px',"],
  ["S($('timer'), { left: '1060px', top: '290px',", "S($('timer'), { left: '200px', top: '570px',"],
  ['const rad = 85 + 520 * E.outCubic(q);', 'const rad = 85 + 460 * E.outCubic(q);'],
  ["S($('railfill'), { width: (E.inOutCubic(P(t, T3[1], T3[1] + .5)) * 760 + E.inOutCubic(P(t, T3[2], T3[2] + .5)) * 760) + 'px' });",
   "S($('railfill'), { width: (E.inOutCubic(P(t, T3[1], T3[1] + .5)) * 450 + E.inOutCubic(P(t, T3[2], T3[2] + .5)) * 450) + 'px' });"],
  ["S($('n' + i), { left: (200 + i * 760) + 'px', top: '960px',", "S($('n' + i), { left: (90 + i * 450) + 'px', top: '1760px',"],
  ["S($('a' + i), { top: (520 + i * 146) + 'px',", "S($('a' + i), { top: (1340 + i * 132) + 'px',"],
  ["S(row, { top: (250 + i * 215) + 'px' });", "S(row, { top: (520 + i * 300) + 'px' });"],
];
for (const [a, b] of R) {
  if (!s.includes(a)) { console.error('NO ENCONTRADO:', a.slice(0, 80)); process.exit(1); }
  s = s.replace(a, b);
}
fs.writeFileSync(f, s);
console.log('ok', R.length);
