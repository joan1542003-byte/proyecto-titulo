"""Compara dónde cae cada palabra en el PDF de Chrome y en el PDF que exporta Affinity desde el IDML.

Uso: python3 -I comparar-pdf-affinity.py chrome.pdf affinity.pdf [páginas]
Escala el PDF de Affinity al tamaño del de Chrome y busca cada palabra de Chrome en el mismo lugar.
Una palabra que no está donde debería indica un corte de línea distinto (o un texto movido).
"""
import html
import re
import subprocess
import sys
from collections import defaultdict

chrome_pdf, aff_pdf = sys.argv[1], sys.argv[2]
patron = re.compile(r'<word xMin="([\d.]+)" yMin="([\d.]+)" xMax="([\d.]+)" yMax="([\d.]+)">(.*?)</word>')
pagina = re.compile(r'<page width="([\d.]+)" height="([\d.]+)">(.*?)</page>', re.S)


def leer(pdf):
    salida = subprocess.run(["pdftotext", "-bbox", pdf, "-"], capture_output=True, text=True).stdout
    paginas = []
    for w, h, cuerpo in pagina.findall(salida):
        ws = [(float(a), float(b), float(c), float(d), html.unescape(t)) for a, b, c, d, t in patron.findall(cuerpo)]
        paginas.append((float(w), float(h), ws))
    return paginas


C = leer(chrome_pdf)
A = leer(aff_pdf)
print(f"Páginas: Chrome {len(C)}, Affinity {len(A)}")
if len(sys.argv) > 3:
    elegidas = [int(x) for x in sys.argv[3].split(",")]
else:
    elegidas = range(1, min(len(C), len(A)) + 1)

resumen = []
detalle = defaultdict(list)
for p in elegidas:
    cw, ch, cws = C[p - 1]
    aw, ah, aws = A[p - 1]
    k = cw / aw   # de Affinity a Chrome
    a_escaladas = [(x0 * k, y0 * k, x1 * k, y1 * k, t) for x0, y0, x1, y1, t in aws]
    malas = 0
    for x0, y0, x1, y1, t in cws:
        alto = y1 - y0
        ok = any(t == q[4] and abs(q[0] - x0) < max(3.0, alto * 0.25) and abs(q[1] - y0) < alto * 0.5 for q in a_escaladas)
        if not ok:
            ok = any((t in q[4] or q[4] in t) and q[0] - 3 <= x0 <= q[2] + 3 and abs(q[1] - y0) < alto * 0.5 for q in a_escaladas)
        if not ok:
            malas += 1
            detalle[p].append((t, round(x0), round(y0)))
    resumen.append((p, len(cws), malas))

total = sum(n for _, n, _ in resumen)
fuera = sum(m for _, _, m in resumen)
print(f"Palabras del PDF de Chrome: {total}; fuera de lugar en Affinity: {fuera}")
for p, n, m in resumen:
    if m:
        muestra = " ".join(t for t, _, _ in detalle[p][:14])
        print(f"  página {p}: {m} de {n} · {muestra}")
