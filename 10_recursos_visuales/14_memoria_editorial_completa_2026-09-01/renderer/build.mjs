import fs from 'node:fs';
import path from 'node:path';
import { fileURLToPath } from 'node:url';

const here = path.dirname(fileURLToPath(import.meta.url));
const repo = path.resolve(here, '../../..');
const source = path.join(repo, '08_memoria', 'memoria-vigente-v4.md');
const out = path.join(here, 'dist');
fs.mkdirSync(out, { recursive: true });

const raw = fs.readFileSync(source, 'utf8').replace(/\r/g, '').split('\n## Registro de cambios')[0];

function esc(value) {
  return value.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
}

function inline(value) {
  return esc(value)
    .replace(/\*\*([^*]+)\*\*/g, '<strong>$1</strong>')
    .replace(/\*([^*]+)\*/g, '<em>$1</em>')
    .replace(/`([^`]+)`/g, '<code>$1</code>')
    .replace(/\[([^\]]+)\]\(([^)]+)\)/g, '<a href="$2">$1</a>');
}

function parseMarkdown(text) {
  const lines = text.split('\n');
  const blocks = [];
  let i = 0;
  while (i < lines.length) {
    const line = lines[i];
    if (!line.trim()) { i += 1; continue; }
    const heading = line.match(/^(#{1,4})\s+(.+)$/);
    if (heading) {
      blocks.push({ type: 'heading', level: heading[1].length, text: heading[2].trim() });
      i += 1; continue;
    }
    if (/^---+$/.test(line.trim())) { blocks.push({ type: 'rule' }); i += 1; continue; }
    if (line.startsWith('|') && i + 1 < lines.length && /^\|?[\s:|-]+\|/.test(lines[i + 1])) {
      const rows = [];
      rows.push(line.split('|').slice(1, -1).map(v => v.trim()));
      i += 2;
      while (i < lines.length && lines[i].startsWith('|')) {
        rows.push(lines[i].split('|').slice(1, -1).map(v => v.trim()));
        i += 1;
      }
      blocks.push({ type: 'table', rows });
      continue;
    }
    if (/^[-*]\s+/.test(line)) {
      const items = [];
      while (i < lines.length && /^[-*]\s+/.test(lines[i])) {
        items.push(lines[i].replace(/^[-*]\s+/, '').trim()); i += 1;
      }
      blocks.push({ type: 'list', items });
      continue;
    }
    if (/^\d+\.\s+/.test(line)) {
      const items = [];
      while (i < lines.length && /^\d+\.\s+/.test(lines[i])) {
        items.push(lines[i].replace(/^\d+\.\s+/, '').trim()); i += 1;
      }
      blocks.push({ type: 'ordered', items });
      continue;
    }
    if (line.startsWith('> ')) {
      const parts = [];
      while (i < lines.length && lines[i].startsWith('> ')) {
        parts.push(lines[i].slice(2).trim()); i += 1;
      }
      blocks.push({ type: 'quote', text: parts.join(' ') });
      continue;
    }
    const parts = [line.trim()];
    i += 1;
    while (i < lines.length && lines[i].trim() && !/^(#{1,4})\s+/.test(lines[i]) && !lines[i].startsWith('|') && !/^[-*]\s+/.test(lines[i]) && !/^\d+\.\s+/.test(lines[i]) && !lines[i].startsWith('> ') && !/^---+$/.test(lines[i].trim())) {
      parts.push(lines[i].trim()); i += 1;
    }
    blocks.push({ type: 'paragraph', text: parts.join(' ') });
  }
  return blocks;
}

function weight(block) {
  if (block.type === 'table') return 1100 + block.rows.length * 260;
  if (block.type === 'heading') return block.level === 2 ? 460 : 260;
  if (block.type === 'list' || block.type === 'ordered') return block.items.join(' ').length * 1.3 + 180;
  if (block.type === 'quote') return block.text.length * 1.4 + 220;
  if (block.type === 'rule') return 100;
  return block.text.length;
}

function renderBlock(block) {
  if (block.type === 'heading') return `<h${Math.min(block.level + 1, 5)}>${inline(block.text)}</h${Math.min(block.level + 1, 5)}>`;
  if (block.type === 'paragraph') return `<p>${inline(block.text)}</p>`;
  if (block.type === 'quote') return `<blockquote>${inline(block.text)}</blockquote>`;
  if (block.type === 'list' || block.type === 'ordered') {
    const tag = block.type === 'ordered' ? 'ol' : 'ul';
    return `<${tag}>${block.items.map(v => `<li>${inline(v)}</li>`).join('')}</${tag}>`;
  }
  if (block.type === 'table') {
    const [head, ...rows] = block.rows;
    return `<div class="table-wrap"><table><thead><tr>${head.map(v => `<th>${inline(v)}</th>`).join('')}</tr></thead><tbody>${rows.map(row => `<tr>${row.map(v => `<td>${inline(v)}</td>`).join('')}</tr>`).join('')}</tbody></table></div>`;
  }
  return '<hr>';
}

const blocks = parseMarkdown(raw);
const pages = [];
let chapter = '00';
let chapterTitle = 'Preliminares';
let bucket = [];
let bucketWeight = 0;
let currentFamily = 'reading';

function flush(family = currentFamily) {
  if (!bucket.length) return;
  pages.push({ family, chapter, chapterTitle, blocks: bucket });
  bucket = []; bucketWeight = 0;
}

for (const block of blocks) {
  if (block.type === 'heading' && block.level === 1) {
    flush();
    const match = block.text.match(/^(\d+)\.\s*(.+)$/);
    if (match) {
      chapter = match[1].padStart(2, '0');
      chapterTitle = match[2];
      currentFamily = 'reading';
      pages.push({ family: 'opener', chapter, chapterTitle, blocks: [] });
    } else if (block.text.toLowerCase() !== 'relevo') {
      chapter = '00'; chapterTitle = block.text;
      pages.push({ family: 'prelim', chapter, chapterTitle, blocks: [] });
    }
    continue;
  }
  if (block.type === 'heading' && block.level === 2 && ['Resumen', 'Abstract', 'Índice'].includes(block.text)) {
    flush(); chapter = '00'; chapterTitle = block.text;
    currentFamily = block.text === 'Índice' ? 'reading' : 'prelim-content';
    if (block.text === 'Índice') pages.push({ family: 'prelim', chapter, chapterTitle, blocks: [] });
    continue;
  }
  const w = weight(block);
  const tablePage = block.type === 'table';
  if (tablePage) {
    flush();
    pages.push({ family: 'table', chapter, chapterTitle, blocks: [block] });
    continue;
  }
  if (bucketWeight + w > 3000 && bucket.length) flush();
  bucket.push(block); bucketWeight += w;
}
flush();

pages.unshift({ family: 'cover', chapter: '00', chapterTitle: 'Relevo', blocks: [] });

const toc = pages.filter(p => p.family === 'opener').map((p, idx) => ({ ...p, idx }));
const total = pages.length;

function pageContent(page, index) {
  const folio = String(index + 1).padStart(2, '0');
  const running = page.chapter === '00' ? 'RELEVO — MEMORIA DE PROYECTO DE TÍTULO' : `${page.chapter} — ${page.chapterTitle}`;
  if (page.family === 'cover') return `<article class="page cover"><div class="brand">RELEVO</div><div class="cover-sub">Sistema phygital para recuperar intenciones personales durante el ocio digital</div><div class="cover-meta">MEMORIA DE PROYECTO DE TÍTULO<br>DISEÑO — UNIVERSIDAD DIEGO PORTALES<br>JOHAN YANTEN — 2026</div><div class="signal" aria-hidden="true"></div></article>`;
  if (page.family === 'opener') return `<article class="page opener"><header>${running}<span>${folio}</span></header><div class="opener-number">${page.chapter}</div><h1>${inline(page.chapterTitle)}</h1><div class="opener-rule"></div><footer>RELEVO <span>${folio} / ${String(total).padStart(2, '0')}</span></footer></article>`;
  if (page.family === 'prelim') {
    const related = pages.slice(index + 1).find(p => p.chapterTitle !== page.chapterTitle && p.family !== 'prelim');
    const content = related ? '' : '';
    const tocHtml = page.chapterTitle === 'Índice' ? `<ol class="toc">${toc.map((p, i) => `<li><span>${p.chapter}</span><b>${inline(p.chapterTitle)}</b></li>`).join('')}</ol>` : '';
    return `<article class="page prelim"><header>${running}<span>${folio}</span></header><div class="prelim-label">${inline(page.chapterTitle)}</div>${tocHtml}<footer>RELEVO <span>${folio} / ${String(total).padStart(2, '0')}</span></footer></article>`;
  }
  const body = page.blocks.map(renderBlock).join('');
  return `<article class="page ${page.family}" data-chapter="${page.chapter}"><header>${running}<span>${folio}</span></header><aside><span>${page.chapter}</span><strong>${inline(page.chapterTitle)}</strong></aside><main data-title="${esc(page.chapterTitle)}">${body}</main><footer>RELEVO — MEMORIA DE PROYECTO DE TÍTULO <span>${folio} / ${String(total).padStart(2, '0')}</span></footer></article>`;
}

const style = fs.readFileSync(path.join(here, 'styles.css'), 'utf8')
  .replaceAll('../../../../10_tipografias', '../../../10_tipografias')
  + '\n.page.table aside{display:none}.page.prelim-content aside span{display:none}.page.prelim-content main{padding-top:90px}.page.prelim-content main:before{content:attr(data-title);display:block;font-size:48px;font-weight:540;margin-bottom:40px}.page main{overflow:hidden}';
const html = `<!doctype html><html lang="es"><head><meta charset="utf-8"><meta name="viewport" content="width=device-width"><title>Relevo — memoria editorial</title><style>${style}</style></head><body><div class="book">${pages.map(pageContent).join('\n')}</div><script>document.documentElement.dataset.ready='true'</script></body></html>`;
fs.writeFileSync(path.join(out, 'index.html'), html);
fs.writeFileSync(path.join(out, 'manifest.json'), JSON.stringify(pages.map((p, i) => ({ page: i + 1, family: p.family, chapter: p.chapter, title: p.chapterTitle })), null, 2));
console.log(`Generadas ${pages.length} páginas en ${out}`);
