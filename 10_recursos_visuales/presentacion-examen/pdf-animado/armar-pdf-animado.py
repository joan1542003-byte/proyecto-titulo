#!/usr/bin/env python3
"""Arma un PDF de la presentación del examen con los GIF animados encima.

Toma un PDF de base (la presentación exportada desde Figma, o las láminas como
imágenes) y pone cada animación en su lámina, en la misma posición y con el mismo
tamaño que tiene en Figma, con el paquete «animate» de LaTeX. Cada animación se
repite sin fin y empieza sola al abrir la lámina.

- El logo de la portada, la identidad y el cierre se arma con un fondo fijo (el aura
  de la memoria o el blanco de su ficha) y, encima, solo el logo animado, con
  transparencia, desde su animación WebM. Así el PDF no repite el fondo en cada cuadro.
- Todos los cuadros se guardan en PNG de 256 colores (con transparencia en los logos), y los
  cuadros idénticos seguidos se juntan sumando su duración.
- «Cómo funciona», «Seguir en el teléfono» y la app usan los cuadros de su GIF, con las
  esquinas redondeadas dibujadas sobre el fondo de la página.

Las animaciones se ven en Adobe Acrobat Reader (y en otros lectores con JavaScript,
como PDF-XChange). Los navegadores y Vista Previa de macOS muestran el primer cuadro.

Uso:
  armar-pdf-animado.py BASE SALIDA.pdf
    BASE   un PDF de 41 láminas de 1920 × 1080 (o del mismo formato, a otra escala),
           o una carpeta con p01.png … p41.png de 1920 × 1080
Necesita pdflatex con los paquetes animate, pdfpages y geometry, ffmpeg, pdftoppm y Pillow.
"""
import os, shutil, subprocess, sys, tempfile
from PIL import Image, ImageDraw

AQUI = os.path.dirname(os.path.abspath(__file__))
VIS = os.path.normpath(os.path.join(AQUI, '..', '..'))
GIF = os.path.join(AQUI, '..', 'gif')
AURA = os.path.normpath(os.path.join(VIS, '..', '08_memoria', 'memoria-1920x1080', 'figuras', 'aura'))
LOGO = os.path.join(VIS, 'logo-relevo-variantes-2026-11-23', 'animacion-logo')

# Posición y tamaño en la lámina de Figma (1920 × 1080, origen arriba a la izquierda).
# Logos: WebM con transparencia, tamaño de los cuadros y fondo fijo («aura:archivo» o «blanco»).
# GIF: archivo, radios de las esquinas que recorta Figma (arriba izq., arriba der., abajo der.,
# abajo izq.) y escala máxima de los cuadros respecto del tamaño en la lámina.
LOGOS = [
    (1, 32, 145, 704, 208, 'relevo-turno-texto-tinta-sin-fondo.webm', (1056, 312), 'aura:portada.jpg'),
    (31, 246, 335, 550, 163, 'relevo-turno-sin-fondo.webm', (960, 284), 'blanco'),
    (41, 580, 497, 774, 229, 'relevo-turno-texto-tinta-sin-fondo.webm', (1160, 343), 'aura:contraportada.jpg'),
]
GIFS = [
    (28, 96, 303, 1056, 594, 'lamina-28-como-funciona.gif', (32, 32, 32, 32), 2.0),
    (29, 534, 302, 414, 414, 'lamina-29-2-seguir-en-el-telefono.gif', (32, 32, 0, 0), 2.0),
    (30, 403.93, 292.93, 232.14, 516.07, 'lamina-30-preparar-un-relevo-en-la-app.gif', (25.89,) * 4, 1.0),
]


def mascara(w, h, radios):
    """Rectángulo con las esquinas redondeadas."""
    m = Image.new('L', (w * 4, h * 4), 255)
    d = ImageDraw.Draw(m)
    for k, r in enumerate(radios):
        if not r:
            continue
        r4 = int(round(r * 4))
        izq, arr = k in (0, 3), k in (0, 1)
        x0, y0 = (0 if izq else w * 4 - r4), (0 if arr else h * 4 - r4)
        cx, cy = (r4 if izq else w * 4 - r4), (r4 if arr else h * 4 - r4)
        d.rectangle((x0, y0, x0 + r4, y0 + r4), fill=0)
        d.ellipse((cx - r4, cy - r4, cx + r4, cy + r4), fill=255)
    return m.resize((w, h), Image.LANCZOS)


def fondo_pagina(pdf, lam, x, y, w, h, k, nw, nh, tmp):
    """El fondo de la página bajo la animación, al tamaño de sus cuadros."""
    dpi = 72.0 * nw / (w * k)
    raiz = os.path.join(tmp, f'pagina{lam:02d}')
    subprocess.run(['pdftoppm', '-f', str(lam), '-l', str(lam), '-r', f'{dpi:.4f}', '-png', '-singlefile', pdf, raiz], check=True)
    pag = Image.open(raiz + '.png').convert('RGB')
    e = dpi / 72.0
    return pag.crop((round(x * k * e), round(y * k * e), round((x + w) * k * e), round((y + h) * k * e))).resize((nw, nh), Image.LANCZOS)


def aura(nombre, x, y, w, h, nw, nh):
    """El aura de la memoria ajustada a 1920 × 1080 como la ajusta Figma, recortada bajo el logo."""
    im = Image.open(os.path.join(AURA, nombre)).convert('RGB')
    s = max(1920 / im.width, 1080 / im.height)
    im = im.resize((round(im.width * s), round(im.height * s)), Image.LANCZOS)
    ox, oy = (im.width - 1920) // 2, (im.height - 1080) // 2
    return im.crop((ox + x, oy + y, ox + x + w, oy + y + h)).resize((nw, nh), Image.LANCZOS)


def juntar(cuadros, carpeta, modo):
    """Guarda los cuadros y junta los idénticos seguidos, sumando su duración."""
    lista, previo = [], None
    for c, dur in cuadros:
        datos = c.tobytes()
        if previo is not None and datos == previo:
            lista[-1] = (lista[-1][0], lista[-1][1] + dur)
            continue
        previo = datos
        archivo = os.path.join(carpeta, f'{len(lista):04d}.png')
        limpio = Image.frombytes(modo, c.size, datos)
        metodo = Image.Quantize.FASTOCTREE if modo == 'RGBA' else Image.Quantize.MEDIANCUT
        limpio.quantize(colors=256, method=metodo, dither=Image.Dither.NONE).save(archivo, optimize=True)
        lista.append((archivo, dur))
    return lista


def cuadros_logo(webm, nw, nh, carpeta, tmp):
    crudo = os.path.join(tmp, os.path.basename(carpeta) + '-crudo')
    os.makedirs(crudo)
    subprocess.run(['ffmpeg', '-v', 'error', '-y', '-c:v', 'libvpx-vp9', '-i', os.path.join(LOGO, webm),
                    '-vf', f'fps=25,scale={nw}:{nh}:flags=lanczos,format=rgba', os.path.join(crudo, '%04d.png')], check=True)
    archivos = sorted(os.listdir(crudo))
    return juntar(((Image.open(os.path.join(crudo, a)).convert('RGBA'), 40) for a in archivos), carpeta, 'RGBA')


def cuadros_gif(nombre, x, y, w, h, radios, escala, pdf, lam, k, carpeta, tmp):
    im = Image.open(os.path.join(GIF, nombre))
    nw, nh = im.size
    if nw > w * escala:
        nw, nh = round(w * escala), round(h * escala)
    m = mascara(nw, nh, [r * nw / w for r in radios])
    bg = fondo_pagina(pdf, lam, x, y, w, h, k, nw, nh, tmp)

    def gen():
        for i in range(im.n_frames):
            im.seek(i)
            c = im.convert('RGB')
            if c.size != (nw, nh):
                c = c.resize((nw, nh), Image.LANCZOS)
            yield Image.composite(c, bg, m), (im.info.get('duration', 40) or 40)
    return juntar(gen(), carpeta, 'RGB')


def animacion(lista, w, h):
    partes, ritmo = [], None
    for j, (archivo, dur) in enumerate(lista):
        fps = 1000.0 / dur
        img = f'\\includegraphics[width={w:.3f}bp,height={h:.3f}bp]{{{archivo}}}'
        if j == 0:
            partes.append(img)
        else:
            partes.append('\\newframe' + (f'[{fps:.4f}]' if abs(fps - ritmo) > 1e-6 else '') + img)
        ritmo = fps
    return (f'\\begin{{animateinline}}[autoplay,loop]{{{1000.0 / lista[0][1]:.4f}}}\n' + '\n'.join(partes) + '\n\\end{animateinline}')


def base_pdf(base, tmp):
    """Si la base es una carpeta de imágenes, la convierte en un PDF de 1920 × 1080 puntos."""
    if base.lower().endswith('.pdf'):
        return os.path.abspath(base)
    paginas = [Image.open(os.path.join(base, f'p{i:02d}.png')).convert('RGB') for i in range(1, 42)]
    salida = os.path.join(tmp, 'base.pdf')
    paginas[0].save(salida, save_all=True, append_images=paginas[1:], resolution=72, quality=90)
    return salida


def tamano_pagina(pdf):
    out = subprocess.run(['pdfinfo', pdf], capture_output=True, text=True).stdout
    for linea in out.splitlines():
        if linea.startswith('Page size:'):
            p = linea.split(':', 1)[1].split()
            return float(p[0]), float(p[2])
    return 1920.0, 1080.0


def main():
    if len(sys.argv) != 3:
        print(__doc__)
        sys.exit(1)
    base, salida = sys.argv[1], os.path.abspath(sys.argv[2])
    tmp = tempfile.mkdtemp(prefix='pdf-animado-')
    pdf = base_pdf(base, tmp)
    pw, ph = tamano_pagina(pdf)
    k = pw / 1920.0
    capas = {}
    for lam, x, y, w, h, webm, (nw, nh), fondo in LOGOS:
        carpeta = os.path.join(tmp, f'l{lam:02d}')
        os.makedirs(carpeta)
        lista = cuadros_logo(webm, nw, nh, carpeta, tmp)
        f = os.path.join(tmp, f'fondo{lam:02d}.png')
        (aura(fondo.split(':', 1)[1], x, y, w, h, nw, nh) if fondo.startswith('aura:') else Image.new('RGB', (nw, nh), (255, 255, 255))).save(f)
        fijo = f'\\put({x * k:.3f},{(1080 - y - h) * k:.3f}){{\\includegraphics[width={w * k:.3f}bp,height={h * k:.3f}bp]{{{f}}}}}'
        capas[lam] = fijo + f'\\put({x * k:.3f},{(1080 - y - h) * k:.3f}){{{animacion(lista, w * k, h * k)}}}'
    for lam, x, y, w, h, nombre, radios, escala in GIFS:
        carpeta = os.path.join(tmp, f'l{lam:02d}')
        os.makedirs(carpeta)
        lista = cuadros_gif(nombre, x, y, w, h, radios, escala, pdf, lam, k, carpeta, tmp)
        capas[lam] = f'\\put({x * k:.3f},{(1080 - y - h) * k:.3f}){{{animacion(lista, w * k, h * k)}}}'
    paginas = []
    for lam in range(1, 42):
        if lam in capas:
            paginas.append(f'\\includepdf[pages={lam},picturecommand={{\\setlength{{\\unitlength}}{{1bp}}{capas[lam]}}}]{{{pdf}}}')
        else:
            paginas.append(f'\\includepdf[pages={lam}]{{{pdf}}}')
    tex = ('\\documentclass{article}\n'
           f'\\usepackage[paperwidth={pw}bp,paperheight={ph}bp,margin=0bp]{{geometry}}\n'
           '\\usepackage{graphicx}\n\\usepackage{animate}\n\\usepackage{pdfpages}\n'
           '\\begin{document}\n' + '\n'.join(paginas) + '\n\\end{document}\n')
    with open(os.path.join(tmp, 'presentacion.tex'), 'w', encoding='utf-8') as fh:
        fh.write(tex)
    for _ in range(2):
        r = subprocess.run(['pdflatex', '-interaction=nonstopmode', 'presentacion.tex'], cwd=tmp, capture_output=True, text=True)
    if r.returncode != 0 or not os.path.exists(os.path.join(tmp, 'presentacion.pdf')):
        print(r.stdout[-3000:])
        sys.exit('pdflatex falló; los archivos quedaron en ' + tmp)
    shutil.copy(os.path.join(tmp, 'presentacion.pdf'), salida)
    shutil.rmtree(tmp)
    print('listo:', salida)


if __name__ == '__main__':
    main()
