#!/usr/bin/env python3
"""Reúne el texto completo de las fuentes citadas en la memoria y lo convierte a Markdown.

Solo usa copias legales de acceso abierto: Europe PMC, repositorios institucionales y de autor,
arXiv y las páginas oficiales de cada organización. Nunca usa sitios de copias no autorizadas.

Los textos quedan en textos/, que no se versiona: muchos están protegidos por derechos de autor y
el repositorio es público. Se vuelven a generar con este script. El estado de cada fuente queda en
manifiesto.json, que sí se versiona.

Uso:  python3 construir.py            (todas las fuentes de manifiesto.json)
      python3 construir.py clave ...  (solo esas)
Requiere: pdftotext y pdftoppm (poppler) y pandoc; tesseract solo para PDF escaneados.
"""
import json, os, re, shutil, subprocess, sys, tempfile, unicodedata, urllib.request, urllib.error

AQUI = os.path.dirname(os.path.abspath(__file__))
TEXTOS = os.path.join(AQUI, 'textos')
UA = {'User-Agent': 'Mozilla/5.0 (verificacion de fuentes; proyecto de titulo Relevo)'}

def norm(s):
    s = unicodedata.normalize('NFKD', s or '')
    return re.sub(r'[^a-z0-9]+', '', ''.join(c for c in s if not unicodedata.combining(c)).lower())

def bajar(url, timeout=60):
    if url.startswith('http://'):
        url = 'https://' + url[7:]          # el entorno solo admite HTTPS
    req = urllib.request.Request(url, headers=UA)
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return r.read(), r.headers.get('Content-Type', ''), r.geturl()

def ocr(datos):
    """Reconoce el texto de un PDF escaneado, página por página (Tesseract, inglés)."""
    with tempfile.TemporaryDirectory() as d:
        ruta = os.path.join(d, 'f.pdf')
        open(ruta, 'wb').write(datos)
        subprocess.run(['pdftoppm', '-r', '300', '-gray', '-png', ruta, os.path.join(d, 'p')], check=True)
        imagenes = sorted(x for x in os.listdir(d) if x.endswith('.png'))
        return ['[Texto reconocido por OCR: revisar contra el escaneo antes de citar textualmente.]\n' +
                subprocess.run(['tesseract', os.path.join(d, x), '-', '-l', 'eng'], capture_output=True).stdout.decode('utf8', 'replace')
                for x in imagenes]

def pdf_a_md(datos):
    """Texto del PDF con un marcador por página, para poder citar la página."""
    with tempfile.NamedTemporaryFile(suffix='.pdf', delete=False) as f:
        f.write(datos); ruta = f.name
    try:
        txt = subprocess.run(['pdftotext', '-enc', 'UTF-8', ruta, '-'], capture_output=True, check=True).stdout.decode('utf8', 'replace')
    finally:
        os.unlink(ruta)
    paginas = txt.split('\f')
    if len(txt.split()) < 30 * max(1, len(paginas) - 1) and shutil.which('tesseract'):
        paginas = ocr(datos)                             # PDF escaneado: no trae capa de texto
    partes = []
    for i, p in enumerate(paginas, 1):
        p = re.sub(r'(\w)-\n(\w)', r'\1\2', p)          # palabras cortadas al final de línea
        p = re.sub(r'(?<![.:;!?\n])\n(?!\n)', ' ', p)    # une líneas de un mismo párrafo
        if p.strip():
            partes.append(f'\n\n<!-- pág. PDF {i} -->\n\n' + p.strip())
    return ''.join(partes).strip(), len(paginas)

def pandoc(datos, formato):
    r = subprocess.run(['pandoc', '-f', formato, '-t', 'gfm-raw_html', '--wrap=none'], input=datos, capture_output=True)
    return r.stdout.decode('utf8', 'replace')

def docx_a_md(datos):
    """Versión de autor entregada como Word (algunos repositorios la guardan así)."""
    with tempfile.NamedTemporaryFile(suffix='.docx', delete=False) as f:
        f.write(datos); ruta = f.name
    try:
        r = subprocess.run(['pandoc', '-f', 'docx', '-t', 'gfm-raw_html', '--wrap=none', ruta], capture_output=True)
    finally:
        os.unlink(ruta)
    return r.stdout.decode('utf8', 'replace').strip()

def html_a_md(datos):
    html = datos.decode('utf8', 'replace')
    html = re.sub(r'(?is)<(script|style|noscript|svg|nav|footer|header|form|iframe)[^>]*>.*?</\1>', ' ', html)
    return re.sub(r'\n{3,}', '\n\n', pandoc(html.encode('utf8'), 'html')).strip()

def docc_a_md(datos):
    """Documentación de Apple: el JSON de DocC que la página carga con JavaScript."""
    j = json.loads(datos)
    refs = j.get('references', {})
    def inline(xs):
        out = []
        for x in xs or []:
            t = x.get('type')
            if t == 'text': out.append(x.get('text', ''))
            elif t in ('emphasis', 'strong'): out.append(('*' if t == 'emphasis' else '**') + inline(x.get('inlineContent')) + ('*' if t == 'emphasis' else '**'))
            elif t == 'codeVoice': out.append('`' + x.get('code', '') + '`')
            elif t == 'reference': out.append(refs.get(x.get('identifier'), {}).get('title', ''))
            elif 'inlineContent' in x: out.append(inline(x['inlineContent']))
        return ''.join(out)
    def bloques(bs, nivel=0):
        out = []
        for b in bs or []:
            t = b.get('type')
            if t == 'heading': out.append('#' * min(6, b.get('level', 2) + 1) + ' ' + b.get('text', ''))
            elif t == 'paragraph': out.append(inline(b.get('inlineContent')))
            elif t in ('unorderedList', 'orderedList'):
                for i, it in enumerate(b.get('items', []), 1):
                    out.append(('- ' if t == 'unorderedList' else f'{i}. ') + ' '.join(bloques(it.get('content'))))
            elif t == 'aside': out.append('> ' + ' '.join(bloques(b.get('content'))))
            elif t == 'table':
                filas = [[' '.join(bloques(c)) for c in fila] for fila in b.get('rows', [])]
                if filas:
                    out.append('| ' + ' | '.join(filas[0]) + ' |'); out.append('|' + ' --- |' * len(filas[0]))
                    out += ['| ' + ' | '.join(f) + ' |' for f in filas[1:]]
            elif 'content' in b: out += bloques(b['content'])
        return out
    partes = ['# ' + j.get('metadata', {}).get('title', ''), inline(j.get('abstract'))]
    for sec in j.get('primaryContentSections', []):
        partes += bloques(sec.get('content'))
    for sec in j.get('sections', []):
        partes += bloques(sec.get('content'))
    return '\n\n'.join(p for p in partes if p and p.strip())

def leychile_a_md(datos):
    """Ley de la Biblioteca del Congreso Nacional: el JSON que usa su visor."""
    j = json.loads(datos)
    html = ''.join(x.get('t', '') for x in j.get('html', []))
    return html_a_md(html.encode('utf8'))

def leyxml_a_md(datos):
    """Ley de la Biblioteca del Congreso Nacional: el XML de intercambio con el texto vigente."""
    import html as h
    x = datos.decode('utf8', 'replace')
    m = re.search(r'fechaVersion="([^"]+)"', x)
    partes = [f'*Versión del texto: {m.group(1)}.*'] if m else []
    for t in re.findall(r'<Texto>(.*?)</Texto>', x, flags=re.S):
        t = h.unescape(t)
        t = re.sub(r'(?<![.:;!?\n])\n(?!\s*\n)', ' ', t)     # une líneas de un mismo párrafo
        partes.append(re.sub(r'[ \t]+', ' ', t).strip())
    return '\n\n'.join(p for p in partes if p)

def europepmc(pmcid):
    datos, _, _ = bajar(f'https://www.ebi.ac.uk/europepmc/webservices/rest/{pmcid}/fullTextXML')
    return pandoc(datos, 'jats').strip()

def valido(f, md):
    """Un texto sirve si trae el título y tiene la extensión esperada para su tipo.
    'marca' reemplaza al título cuando la copia legal lo trae distinto (versión de autor, informe previo)."""
    minimo = {'artículo/capítulo': 2500, 'tesis': 5000, 'libro': 20000}.get(f['tipo'], 150)
    return norm(f.get('marca') or f['titulo'])[:30] in norm(md) and len(md.split()) >= minimo

def conseguir(f):
    """Prueba las vías en orden y devuelve (markdown, vía, páginas, válido).
    Si ninguna pasa la validación, devuelve la más larga para revisarla a mano."""
    mejor, ultimo = None, None
    for via in f.get('vias', []):
        try:
            if via.startswith('europepmc:'):
                md, final, n = europepmc(via.split(':', 1)[1]), via, None
            elif via.startswith(('docc:', 'leychile:', 'leyxml:', 'json:')):
                pref, url = via.split(':', 1)
                datos, _, final = bajar(url)
                n = None
                md = (docc_a_md(datos) if pref == 'docc' else leychile_a_md(datos) if pref == 'leychile'
                      else leyxml_a_md(datos) if pref == 'leyxml'
                      else '```json\n' + datos.decode('utf8', 'replace')[:20000] + '\n```')
            else:
                datos, tipo, final = bajar(via)
                n = None
                if datos[:4] == b'%PDF' or 'pdf' in tipo:
                    md, n = pdf_a_md(datos)
                elif datos[:2] == b'PK' and 'wordprocessingml' in tipo:
                    md = docx_a_md(datos)
                else:
                    md = html_a_md(datos)
                    m = re.search(rb'name="citation_pdf_url"\s+content="([^"]+)"', datos)
                    if m and not valido(f, md):
                        datos2, _, final2 = bajar(m.group(1).decode())
                        if datos2[:4] == b'%PDF':
                            md, n = pdf_a_md(datos2); final = final2
        except Exception as e:
            ultimo = e
            continue
        if valido(f, md):
            return md, final, n, True
        if mejor is None or len(md) > len(mejor[0]):
            mejor = (md, final, n, False)
    if mejor:
        return mejor
    raise ultimo or RuntimeError('sin vías')

def resumen(f):
    """Resumen oficial cuando no hay texto completo: 'openalex:DOI' (editorial) o 'pubmed:DOI'."""
    fuente, doi = f['resumen'].split(':', 1)
    if fuente == 'openalex':
        d = json.loads(bajar(f'https://api.openalex.org/works/doi:{doi}?select=abstract_inverted_index')[0])
        pos = {p: w for w, ps in (d.get('abstract_inverted_index') or {}).items() for p in ps}
        return ' '.join(pos[i] for i in sorted(pos)), f'OpenAlex (resumen de la editorial), DOI {doi}'
    d = json.loads(bajar(f'https://www.ebi.ac.uk/europepmc/webservices/rest/search?query=DOI:%22{doi}%22&resultType=core&format=json')[0])
    r = d['resultList']['result'][0]
    return re.sub(r'<[^>]+>', '', r.get('abstractText', '')), f"PubMed vía Europe PMC, PMID {r.get('pmid')}"

def main():
    man = json.load(open(os.path.join(AQUI, 'manifiesto.json'), encoding='utf8'))
    pedidas = set(sys.argv[1:])
    os.makedirs(TEXTOS, exist_ok=True)
    for f in man['fuentes']:
        if pedidas and f['clave'] not in pedidas:
            continue
        destino = os.path.join(TEXTOS, f['clave'] + '.md')
        md, via, n, ok, error = None, None, None, False, None
        if f.get('vias'):
            try:
                md, via, n, ok = conseguir(f)
            except Exception as e:
                error = e
        if ok:
            cabecera = (f"# {f['referencia']}\n\n> Texto obtenido de: {via}\n> Acceso: {f.get('acceso','')}\n"
                        f"> Convertido a Markdown para verificar citas. Uso interno; no se redistribuye.\n")
            open(destino, 'w', encoding='utf8').write(cabecera + '\n' + md + '\n')
            print(f"✓ {f['clave']}: {len(md.split())} palabras" + (f", {n} págs." if n else ''))
        elif f.get('resumen'):
            txt, origen = resumen(f)
            open(destino, 'w', encoding='utf8').write(
                f"# {f['referencia']}\n\n> SOLO RESUMEN. Texto completo no disponible en este entorno.\n> Resumen obtenido de: {origen}\n"
                f"> Sirve para verificar la idea central; no para citar páginas ni detalles que no estén en el resumen.\n\n{txt}\n")
            print(f"r {f['clave']}: solo resumen ({len(txt.split())} palabras)")
        else:
            # No se guarda la página de bloqueo o de error: se deja constancia del motivo.
            motivo = f.get('estado', {}).get('motivo') or (str(error) if error else 'sin vía de acceso legal conocida')
            open(destino, 'w', encoding='utf8').write(
                f"# {f['referencia']}\n\n> SIN TEXTO COMPLETO. Motivo: {motivo}\n> No usar para sostener afirmaciones hasta conseguir el original.\n")
            print(f"✗ {f['clave']}: sin texto ({motivo})")

if __name__ == '__main__':
    main()
