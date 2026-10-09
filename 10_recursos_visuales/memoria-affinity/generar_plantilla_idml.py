#!/usr/bin/env python3
"""Genera la plantilla IDML de la memoria de Relevo para abrirla en Affinity.

IDML es el formato de intercambio abierto de Adobe InDesign. Affinity
(Publisher 2 y la app unificada de Canva) lo abre con «Archivo › Abrir».

La plantilla trae:
- formato A3 horizontal, páginas sueltas y 3 mm de sangrado;
- retícula de 12 columnas con medianil de 15 pt y línea base de 15 pt;
- páginas maestras: Lectura, Apertura, Tres columnas y Portada;
- estilos de párrafo, carácter y tabla con nombres en español;
- la paleta de Relevo (papel, tinta, azul y la familia de colores de D-104);
- el texto de la memoria vigente repartido por capítulos, con un hilo de
  marcos por capítulo y el índice con los números de página de cada apertura.

Uso:
    python3 generar_plantilla_idml.py                  # texto de la memoria
    python3 generar_plantilla_idml.py --sin-texto      # solo maqueta vacía
    python3 generar_plantilla_idml.py --tablas-como-texto

Requiere fontTools solo para estimar cuántas páginas ocupa cada capítulo.
"""

import argparse
import json
import math
import re
import zipfile
from pathlib import Path
from xml.sax.saxutils import escape

AQUI = Path(__file__).resolve().parent
REPO = AQUI.parents[1]
MEMORIA = REPO / "08_memoria" / "memoria-vigente-v4.md"
FUENTES = AQUI / "fuentes"

# ---------------------------------------------------------------- medidas (pt)
MM = 72 / 25.4
W, H = 420 * MM, 297 * MM          # A3 horizontal
SANGRADO = 3 * MM
BL = 15.0                          # línea base
LINEAS = 47                        # líneas de la caja de texto
CAJA_H = LINEAS * BL               # 705 pt
SUP = 20 * MM                      # margen superior
INF = H - SUP - CAJA_H             # margen inferior (≈ 28,3 mm)
IZQ = DER = 20 * MM
MED = 15.0                         # medianil = una línea base
COLS = 12
COLW = (W - IZQ - DER - (COLS - 1) * MED) / COLS
FILA = 7 * BL                      # 6 filas de 7 líneas con 1 línea de medianil
APERTURA_Y = SUP + 2 * (FILA + BL)  # el texto de una apertura empieza en la fila 3


def col_x(i):
    return IZQ + i * (COLW + MED)


def ancho(n):
    return n * COLW + (n - 1) * MED


ANCHO_4 = ancho(4)

# ---------------------------------------------------------------- color (RGB)
COLORES = [
    # nombre, (r, g, b), grupo
    ("Tinta", (23, 24, 28), "Relevo"),
    ("Papel", (242, 242, 239), "Relevo"),
    ("Azul Relevo", (28, 56, 145), "Relevo"),
    ("Grafito", (91, 95, 104), "Relevo"),
    ("Línea", (213, 214, 216), "Relevo"),
    ("Niebla", (229, 229, 226), "Relevo"),
    ("Error", (179, 38, 30), "Relevo"),
    ("Sol", (0xE7, 0xBF, 0x57), "Actividades"),
    ("Naranja", (0xFE, 0xB0, 0x74), "Actividades"),
    ("Rosa", (0xFE, 0xA4, 0xCF), "Actividades"),
    ("Menta", (0x6F, 0xDE, 0xA7), "Actividades"),
    ("Celeste", (0x54, 0xD6, 0xFE), "Actividades"),
    ("Lila", (0xCE, 0xB5, 0xFE), "Actividades"),
    ("Violeta", (0x3F, 0x23, 0x64), "Actividades"),
    ("Petróleo", (0x01, 0x3C, 0x4C), "Actividades"),
    ("Bosque", (0x01, 0x41, 0x28), "Actividades"),
    ("Vino", (0x5C, 0x15, 0x3D), "Actividades"),
]


def cref(nombre):
    return "Color/" + nombre


# ---------------------------------------------------------------- tipografía
SG = "Schibsted Grotesk"
MONO = "IBM Plex Mono"
FAMILIAS = {
    SG: [("Regular", "SchibstedGrotesk-Regular"), ("Italic", "SchibstedGrotesk-Italic"),
         ("Medium", "SchibstedGrotesk-Medium"), ("Medium Italic", "SchibstedGrotesk-MediumItalic"),
         ("SemiBold", "SchibstedGrotesk-SemiBold"), ("SemiBold Italic", "SchibstedGrotesk-SemiBoldItalic"),
         ("Bold", "SchibstedGrotesk-Bold"), ("Bold Italic", "SchibstedGrotesk-BoldItalic")],
    MONO: [("Regular", "IBMPlexMono-Regular"), ("Italic", "IBMPlexMono-Italic"),
           ("Medium", "IBMPlexMono-Medium")],
}
IDIOMA = "$ID/Spanish"

# Estilos de párrafo: nombre -> propiedades. «base» indica el estilo padre.
P = {}


def pstyle(nombre, base=None, **kw):
    P[nombre] = dict(base=base, **kw)


pstyle("Base", font=SG, style="Regular", size=10.5, lead=15, color="Tinta", grid=True,
       hyph=True, just="LeftAlign")
pstyle("Cuerpo", "Base", indent=15, next="Cuerpo")
pstyle("Cuerpo sin sangría", "Base", indent=0, next="Cuerpo")
pstyle("Título 2", "Base", style="SemiBold", size=14, lead=15, before=30, keep=3, hyph=False,
       next="Cuerpo sin sangría")
pstyle("Título 3", "Base", style="SemiBold", before=15, keep=2, hyph=False, next="Cuerpo sin sangría")
pstyle("Capítulo número", "Base", style="Bold", size=150, lead=150, color="Azul Relevo", grid=False,
       hyph=False, tracking=-40)
pstyle("Capítulo título", "Base", style="Bold", size=42, lead=45, tracking=-20, hyph=False,
       next="Cuerpo sin sangría")
pstyle("Título preliminar", "Base", style="Bold", size=30, lead=30, after=30, tracking=-15, hyph=False,
       next="Cuerpo sin sangría")
pstyle("Destacado", "Base", style="Medium", size=16, lead=22.5, before=15, after=15, first_only=True,
       hyph=False, next="Cuerpo sin sangría")
pstyle("Cita en bloque", "Base", left=15, next="Cuerpo sin sangría")
pstyle("Lista viñeta", "Base", left=15, indent=-15, bullet=True, next="Lista viñeta")
pstyle("Lista numerada", "Base", left=15, indent=-15, numbered=True, next="Lista numerada")
pstyle("Tabla número", "Base", style="SemiBold", before=15, keep=2, hyph=False, next="Tabla título")
pstyle("Tabla título", "Base", style="Italic", keep=2, hyph=False, next="Cuerpo sin sangría")
pstyle("Figura número", "Tabla número", next="Figura título")
pstyle("Figura título", "Tabla título", next="Figura contenido")
pstyle("Figura contenido", "Base", style="SemiBold", size=13, lead=22.5, before=7.5, after=7.5,
       first_only=True, color="Azul Relevo", hyph=False)
pstyle("Tabla texto", "Base", size=8.5, lead=12, grid=False)
pstyle("Tabla encabezado", "Tabla texto", style="SemiBold", hyph=False)
pstyle("Nota", "Base", size=9, after=15, next="Cuerpo sin sangría")
pstyle("Referencia", "Base", size=9.5, left=15, indent=-15, keep_lines=True)
pstyle("Glosario", "Base", size=9.5, after=15)
pstyle("Índice 1", "Base", style="SemiBold", tab=True)
pstyle("Índice 2", "Base", left=15, tab=True)
pstyle("Cornisa", "Base", font=MONO, size=7.5, lead=15, color="Grafito", grid=False, hyph=False)
pstyle("Folio", "Cornisa", just="RightAlign")
pstyle("Portada título", "Base", style="Bold", size=230, lead=200, tracking=-45, color="Papel",
       grid=False, hyph=False)
pstyle("Portada subtítulo", "Base", style="Medium", size=24, lead=30, tracking=-10, color="Papel",
       grid=False, hyph=False)
pstyle("Portada datos", "Base", color="Papel", grid=False, hyph=False)
pstyle("Portada etiqueta", "Cornisa", color="Papel")
pstyle("Nota de maqueta", "Base", font=MONO, size=8, color="Azul Relevo", grid=False, hyph=False,
       after=7.5)

# Estilos de carácter
C = {
    "Cursiva": dict(style="Italic"),
    "Negrita": dict(style="SemiBold"),
    "Negrita cursiva": dict(style="SemiBold Italic"),
    "Dato": dict(font=MONO, style="Regular", size=9),
    "Voz de la persona": dict(style="Italic"),
    "Superíndice": dict(position="Superscript"),
}


def resolver(nombre):
    """Propiedades efectivas de un estilo de párrafo, con herencia."""
    s = P[nombre]
    base = resolver(s["base"]) if s["base"] else {}
    out = dict(base)
    out.update({k: v for k, v in s.items() if k != "base"})
    return out


# ---------------------------------------------------------------- medición
class Medidor:
    """Estima líneas con las anchuras reales de Schibsted Grotesk, sin partir
    palabras; Affinity divide en sílabas y suele usar algo menos de espacio."""

    def __init__(self):
        self.anchos = {}
        try:
            from fontTools.ttLib import TTFont
        except ImportError:
            return
        for estilo, archivo in (("Regular", "SchibstedGrotesk-Regular.otf"),
                                ("SemiBold", "SchibstedGrotesk-SemiBold.otf"),
                                ("Medium", "SchibstedGrotesk-Medium.otf"),
                                ("Bold", "SchibstedGrotesk-Bold.otf"),
                                ("Italic", "SchibstedGrotesk-Italic.otf")):
            ruta = FUENTES / archivo
            if not ruta.exists():
                continue
            f = TTFont(ruta)
            cmap, hmtx, upm = f.getBestCmap(), f["hmtx"], f["head"].unitsPerEm
            self.anchos[estilo] = {cp: hmtx[g][0] / upm for cp, g in cmap.items()}

    def ancho_texto(self, texto, size, estilo="Regular"):
        tabla = self.anchos.get(estilo) or self.anchos.get("Regular")
        if not tabla:
            return len(texto) * 0.52 * size
        return sum(tabla.get(ord(c), 0.55) for c in texto) * size

    def lineas(self, texto, size, anchura, estilo="Regular", sangria=0):
        if not texto.strip():
            return 1
        palabras = texto.split()
        espacio = self.ancho_texto(" ", size, estilo)
        n, actual = 1, abs(sangria)
        for p in palabras:
            w = self.ancho_texto(p, size, estilo)
            if actual and actual + espacio + w > anchura:
                n += 1
                actual = w
            else:
                actual += (espacio if actual else 0) + w
        return n


# ---------------------------------------------------------------- Markdown
RE_INLINE = re.compile(r"(\*\*\*.+?\*\*\*|\*\*.+?\*\*|\*.+?\*|`.+?`|\[[^\]]+\]\([^)]+\))")


def runs(texto):
    """Convierte el formato en línea de Markdown en tramos con estilo de carácter."""
    out = []
    for parte in RE_INLINE.split(texto):
        if not parte:
            continue
        if parte.startswith("***") and parte.endswith("***") and len(parte) > 6:
            out.append(("Negrita cursiva", parte[3:-3]))
        elif parte.startswith("**") and parte.endswith("**") and len(parte) > 4:
            for estilo, t in runs(parte[2:-2]):
                out.append(("Negrita cursiva" if estilo == "Cursiva" else "Negrita", t))
        elif parte.startswith("*") and parte.endswith("*") and len(parte) > 2:
            out.append(("Cursiva", parte[1:-1]))
        elif parte.startswith("`") and parte.endswith("`"):
            out.append(("Dato", parte[1:-1]))
        elif parte.startswith("["):
            m = re.match(r"\[([^\]]+)\]\(([^)]+)\)", parte)
            out.append((None, m.group(1)))
        else:
            out.append((None, parte))
    return out


def plano(texto):
    return "".join(t for _, t in runs(texto))


def bloques(lineas):
    """Divide líneas de Markdown en bloques (título, párrafo, lista, cita, tabla)."""
    out, i = [], 0
    while i < len(lineas):
        l = lineas[i].rstrip()
        if not l.strip():
            i += 1
            continue
        if l.startswith("### "):
            out.append(("h3", l[4:].strip()))
        elif l.startswith("## "):
            out.append(("h2", l[3:].strip()))
        elif l.startswith("> "):
            out.append(("quote", l[2:].strip()))
        elif l.startswith("|"):
            filas = []
            while i < len(lineas) and lineas[i].startswith("|"):
                filas.append(lineas[i].rstrip())
                i += 1
            out.append(("table", filas))
            continue
        elif re.match(r"^- ", l):
            out.append(("bullet", l[2:].strip()))
        elif re.match(r"^\d+\. ", l):
            out.append(("num", re.sub(r"^\d+\. ", "", l).strip()))
        else:
            out.append(("p", l.strip()))
        i += 1
    return out


def celdas(fila):
    return [c.strip() for c in fila.strip().strip("|").split("|")]


def leer_memoria():
    texto = MEMORIA.read_text(encoding="utf-8").splitlines()
    fin = next(i for i, l in enumerate(texto) if l.startswith("## Registro de cambios"))
    texto = texto[:fin]
    secciones, actual = [], None
    for l in texto:
        if l.startswith("# "):
            actual = {"titulo": l[2:].strip(), "lineas": []}
            secciones.append(actual)
        elif actual is not None:
            actual["lineas"].append(l)
    return secciones


# ---------------------------------------------------------------- párrafos de historia
class Parrafo:
    def __init__(self, estilo, tramos, tabla=None):
        self.estilo, self.tramos, self.tabla = estilo, tramos, tabla


def parrafos_de(bloques_md, contexto="capitulo"):
    """Asigna estilos de párrafo a los bloques del Markdown."""
    out = []
    previo = "inicio"
    pendiente_figura = False
    for tipo, dato in bloques_md:
        if tipo == "h2":
            out.append(Parrafo("Título 2", runs(dato)))
        elif tipo == "h3":
            out.append(Parrafo("Título 3", runs(dato)))
        elif tipo == "table":
            out.append(Parrafo("Cuerpo sin sangría", [], tabla=dato))
        elif tipo == "quote":
            out.append(Parrafo("Figura contenido" if pendiente_figura else "Destacado", runs(dato)))
            pendiente_figura = False
        elif tipo == "bullet":
            out.append(Parrafo("Lista viñeta", runs(dato)))
        elif tipo == "num":
            out.append(Parrafo("Lista numerada", runs(dato)))
        else:
            m = re.fullmatch(r"\*\*(Tabla|Figura) (\d+)\*\*", dato)
            if m:
                out.append(Parrafo(f"{m.group(1)} número", [(None, f"{m.group(1)} {m.group(2)}")]))
                previo = m.group(1).lower()
                pendiente_figura = m.group(1) == "Figura"
                continue
            if previo in ("tabla", "figura") and dato.startswith("*") and dato.endswith("*"):
                out.append(Parrafo(f"{previo.capitalize()} título", [(None, dato.strip('*'))]))
                previo = "titulo-" + previo
                continue
            if dato.startswith("*Nota.*"):
                out.append(Parrafo("Nota", runs(dato)))
                previo = "nota"
                continue
            elif contexto == "referencias":
                out.append(Parrafo("Referencia", runs(dato)))
            elif contexto == "glosario":
                out.append(Parrafo("Glosario", runs(dato)))
            else:
                sin = previo not in ("p",)
                out.append(Parrafo("Cuerpo sin sangría" if sin else "Cuerpo", runs(dato)))
                previo = "p"
                continue
        previo = tipo
    return out


def lineas_parrafo(par, med, anchura):
    """Líneas de 15 pt que ocupa un párrafo, con sus espacios."""
    if par.tabla:
        return lineas_tabla(par.tabla, med, anchura)
    s = resolver(par.estilo)
    texto = "".join(t for _, t in par.tramos)
    estilo = s["style"] if s["style"] in med.anchos else "Regular"
    n = med.lineas(texto, s["size"], anchura - s.get("left", 0), estilo, s.get("indent", 0))
    alto = n * s["lead"] + s.get("before", 0) + s.get("after", 0)
    return math.ceil(alto / BL - 0.01)


def anchos_columnas(filas, med, anchura):
    datos = [celdas(f) for f in filas if not re.fullmatch(r"\|[\s:\-|]+\|", f.strip())]
    ncol = len(datos[0])
    largo = [max(med.ancho_texto(plano(fila[c]) if c < len(fila) else "", 8.5) for fila in datos)
             for c in range(ncol)]
    minimo = 40.0
    total = sum(largo)
    w = [max(minimo, anchura * l / total) for l in largo]
    k = anchura / sum(w)
    return datos, [x * k for x in w]


def lineas_tabla(filas, med, anchura):
    datos, w = anchos_columnas(filas, med, anchura)
    alto = 0
    for fila in datos:
        n = max(med.lineas(plano(c), 8.5, w[i] - 8) for i, c in enumerate(fila))
        alto += n * 12 + 6
    return math.ceil(alto / BL) + 1


# ---------------------------------------------------------------- IDML: utilidades
class Ids:
    def __init__(self):
        self.n = 0x200

    def __call__(self):
        self.n += 1
        return "u%x" % self.n


ids = Ids()

NS = 'xmlns:idPkg="http://ns.adobe.com/AdobeInDesign/idml/1.0/packaging" DOMVersion="16.0"'
CAB = '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>\n'


def a(valor):
    return escape(str(valor), {'"': "&quot;"})


def num(x):
    return ("%.4f" % x).rstrip("0").rstrip(".")


def estilo_attrs(s, es_parrafo=True):
    """Atributos IDML de un diccionario de propiedades."""
    at, props = [], []
    if "style" in s:
        at.append(f'FontStyle="{a(s["style"])}"')
    if "size" in s:
        at.append(f'PointSize="{num(s["size"])}"')
    if "color" in s:
        at.append(f'FillColor="{cref(s["color"])}"')
    if "tracking" in s:
        at.append(f'Tracking="{num(s["tracking"])}"')
    if "position" in s:
        at.append(f'Position="{s["position"]}"')
    if es_parrafo:
        if "just" in s:
            at.append(f'Justification="{s["just"]}"')
        for clave, attr in (("before", "SpaceBefore"), ("after", "SpaceAfter"),
                            ("indent", "FirstLineIndent"), ("left", "LeftIndent")):
            if clave in s:
                at.append(f'{attr}="{num(s[clave])}"')
        if "grid" in s:
            at.append('GridAlignment="%s"' % ("AlignBaseline" if s["grid"] else "None"))
        if "first_only" in s:
            at.append('GridAlignFirstLineOnly="%s"' % ("true" if s["first_only"] else "false"))
        if "hyph" in s:
            at.append('Hyphenation="%s"' % ("true" if s["hyph"] else "false"))
            if s["hyph"]:
                at.append('HyphenateWordsLongerThan="6" HyphenateAfterFirst="3" '
                          'HyphenateBeforeLast="3" HyphenateLadderLimit="2" '
                          'HyphenateCapitalizedWords="false"')
        if "keep" in s:
            at.append(f'KeepWithNext="{s["keep"]}"')
        if s.get("keep_lines"):
            at.append('KeepLinesTogether="true" KeepAllLinesTogether="true"')
        if s.get("bullet"):
            at.append('BulletsAndNumberingListType="BulletList" BulletsTextAfter="^t"')
            props.append('<BulletChar BulletCharacterType="UnicodeOnly" BulletCharacterValue="8226" />')
        if s.get("numbered"):
            at.append('BulletsAndNumberingListType="NumberedList" NumberingExpression="^#.^t" '
                      'NumberingStartAt="1" NumberingContinue="true"')
            props.append('<AppliedNumberingList type="object">NumberingList/$ID/[Default]</AppliedNumberingList>')
            props.append('<NumberingFormat type="string">1, 2, 3, 4...</NumberingFormat>')
        if s.get("tab"):
            props.append('<TabList type="list"><ListItem type="record">'
                         '<Alignment type="enumeration">RightAlign</Alignment>'
                         '<AlignmentCharacter type="string">.</AlignmentCharacter>'
                         '<Leader type="string"> </Leader>'
                         f'<Position type="unit">{num(ANCHO_4 - 1)}</Position></ListItem></TabList>')
    if "lead" in s:
        props.append(f'<Leading type="unit">{num(s["lead"])}</Leading>')
    if "font" in s:
        props.append(f'<AppliedFont type="string">{a(s["font"])}</AppliedFont>')
    return " ".join(at), "".join(props)


# ---------------------------------------------------------------- IDML: recursos
def styles_xml():
    car = ['<CharacterStyle Self="CharacterStyle/$ID/[No character style]" Imported="false" '
           'Name="$ID/[No character style]" />']
    for nombre, s in C.items():
        s = dict(s)
        if "style" in s:
            s.setdefault("font", SG)
        at, props = estilo_attrs(s, es_parrafo=False)
        car.append(f'<CharacterStyle Self="CharacterStyle/{a(nombre)}" Name="{a(nombre)}" {at}>'
                   f'<Properties><BasedOn type="string">$ID/[No character style]</BasedOn>{props}'
                   '</Properties></CharacterStyle>')
    par = ['<ParagraphStyle Self="ParagraphStyle/$ID/[No paragraph style]" Name="$ID/[No paragraph style]" '
           f'FontStyle="Regular" PointSize="10.5" AppliedLanguage="{IDIOMA}" KerningMethod="$ID/Metrics" '
           'Ligatures="true" Composer="HL Composer" Justification="LeftAlign" FillColor="Color/Tinta">'
           f'<Properties><Leading type="unit">15</Leading><AppliedFont type="string">{SG}</AppliedFont>'
           '</Properties></ParagraphStyle>',
           '<ParagraphStyle Self="ParagraphStyle/$ID/NormalParagraphStyle" Name="$ID/NormalParagraphStyle" '
           'NextStyle="ParagraphStyle/$ID/NormalParagraphStyle"><Properties>'
           '<BasedOn type="string">$ID/[No paragraph style]</BasedOn></Properties></ParagraphStyle>']
    for nombre, s in P.items():
        # La fuente, el tamaño, el interlineado y el color se escriben siempre: algunos
        # importadores de IDML no los heredan del estilo base.
        efectivo = resolver(nombre)
        propio = {k: v for k, v in s.items() if k not in ("base", "next")}
        for k in ("font", "style", "size", "lead", "color"):
            propio[k] = efectivo[k]
        at, props = estilo_attrs(propio)
        base = f"ParagraphStyle/{s['base']}" if s["base"] else "ParagraphStyle/$ID/[No paragraph style]"
        nxt = f"ParagraphStyle/{s.get('next', nombre)}"
        par.append(f'<ParagraphStyle Self="ParagraphStyle/{a(nombre)}" Name="{a(nombre)}" '
                   f'NextStyle="{a(nxt)}" AppliedLanguage="{IDIOMA}" {at}>'
                   f'<Properties><BasedOn type="object">{a(base)}</BasedOn>{props}</Properties>'
                   '</ParagraphStyle>')
    toc = ('<TOCStyle Self="TOCStyle/Índice de capítulos" Name="Índice de capítulos" Title="Índice" '
           'TitleStyle="ParagraphStyle/Título preliminar" RunIn="false" IncludeHidden="false" '
           'CreateBookmarks="true">'
           '<TOCStyleEntry Self="TOCStyle/Índice de capítulosTOCStyleEntry0" Name="Capítulo título" '
           'FormatStyle="ParagraphStyle/Índice 1" Level="1" PageNumberPosition="AfterEntry" '
           'Separator="^t" SortAlphabet="false" />'
           '<TOCStyleEntry Self="TOCStyle/Índice de capítulosTOCStyleEntry1" Name="Tabla título" '
           'FormatStyle="ParagraphStyle/Índice 2" Level="2" PageNumberPosition="AfterEntry" '
           'Separator="^t" SortAlphabet="false" /></TOCStyle>')
    celda_base = 'TextTopInset="3" TextBottomInset="3" TextLeftInset="4" TextRightInset="4"'
    celdas_xml = ('<RootCellStyleGroup Self="u_celdas">'
                  '<CellStyle Self="CellStyle/$ID/[None]" AppliedParagraphStyle="ParagraphStyle/$ID/[No paragraph style]" Name="$ID/[None]" />'
                  f'<CellStyle Self="CellStyle/Celda encabezado" Name="Celda encabezado" {celda_base} '
                  'AppliedParagraphStyle="ParagraphStyle/Tabla encabezado" />'
                  f'<CellStyle Self="CellStyle/Celda cuerpo" Name="Celda cuerpo" {celda_base} '
                  'AppliedParagraphStyle="ParagraphStyle/Tabla texto" />'
                  '</RootCellStyleGroup>')
    borde = lambda lado, w: (f'{lado}BorderStrokeWeight="{w}" {lado}BorderStrokeType="StrokeStyle/$ID/Solid" '
                             f'{lado}BorderStrokeColor="Color/Tinta" {lado}BorderStrokeTint="100"')
    tablas_xml = ('<RootTableStyleGroup Self="u_tablas">'
                  '<TableStyle Self="TableStyle/$ID/[No table style]" Name="$ID/[No table style]" />'
                  '<TableStyle Self="TableStyle/Tabla Relevo" Name="Tabla Relevo" '
                  f'{borde("Top", 0.75)} {borde("Bottom", 0.75)} {borde("Left", 0)} {borde("Right", 0)} '
                  'SpaceBefore="7.5" SpaceAfter="7.5" HeaderRegionCellStyle="CellStyle/Celda encabezado" '
                  'BodyRegionCellStyle="CellStyle/Celda cuerpo" />'
                  '</RootTableStyleGroup>')
    objetos = ('<RootObjectStyleGroup Self="u_objetos">'
               '<ObjectStyle Self="ObjectStyle/$ID/[None]" Name="$ID/[None]" FillColor="Swatch/None" '
               'StrokeColor="Swatch/None" StrokeWeight="0" />'
               '<ObjectStyle Self="ObjectStyle/$ID/[Normal Graphics Frame]" Name="$ID/[Normal Graphics Frame]" '
               'FillColor="Swatch/None" StrokeColor="Swatch/None" StrokeWeight="0"><Properties>'
               '<BasedOn type="object">ObjectStyle/$ID/[None]</BasedOn></Properties></ObjectStyle>'
               '<ObjectStyle Self="ObjectStyle/$ID/[Normal Text Frame]" Name="$ID/[Normal Text Frame]" '
               'FillColor="Swatch/None" StrokeColor="Swatch/None" StrokeWeight="0"><Properties>'
               '<BasedOn type="object">ObjectStyle/$ID/[None]</BasedOn></Properties>'
               '<TextFramePreference TextColumnCount="1" FirstBaselineOffset="LeadingOffset" '
               'VerticalJustification="TopAlign" /></ObjectStyle>'
               '</RootObjectStyleGroup>')
    return (CAB + f'<idPkg:Styles {NS}>'
            f'<RootCharacterStyleGroup Self="u_car">{"".join(car)}</RootCharacterStyleGroup>'
            f'<RootParagraphStyleGroup Self="u_par">{"".join(par)}</RootParagraphStyleGroup>'
            f'{toc}{celdas_xml}{tablas_xml}{objetos}</idPkg:Styles>')


def graphic_xml():
    colores = [
        '<Color Self="Color/Black" Model="Process" Space="CMYK" ColorValue="0 0 0 100" '
        'ColorOverride="Specialblack" Name="Black" ColorEditable="false" ColorRemovable="false" Visible="true" />',
        '<Color Self="Color/Paper" Model="Process" Space="CMYK" ColorValue="0 0 0 0" ColorOverride="Specialpaper" '
        'Name="Paper" ColorEditable="true" ColorRemovable="false" Visible="true" />',
        '<Color Self="Color/Registration" Model="Registration" Space="CMYK" ColorValue="100 100 100 100" '
        'ColorOverride="Specialregistration" Name="Registration" ColorEditable="false" ColorRemovable="false" Visible="true" />',
    ]
    for nombre, (r, g, b), _ in COLORES:
        colores.append(f'<Color Self="{a(cref(nombre))}" Model="Process" Space="RGB" ColorValue="{r} {g} {b}" '
                       f'ColorOverride="Normal" Name="{a(nombre)}" ColorEditable="true" ColorRemovable="true" Visible="true" />')
    return (CAB + f'<idPkg:Graphic {NS}>' + "".join(colores) +
            '<Ink Self="Ink/$ID/Process Cyan" Name="$ID/Process Cyan" IsProcessInk="true" />'
            '<Ink Self="Ink/$ID/Process Magenta" Name="$ID/Process Magenta" IsProcessInk="true" />'
            '<Ink Self="Ink/$ID/Process Yellow" Name="$ID/Process Yellow" IsProcessInk="true" />'
            '<Ink Self="Ink/$ID/Process Black" Name="$ID/Process Black" IsProcessInk="true" />'
            '<Swatch Self="Swatch/None" Name="None" ColorEditable="false" ColorRemovable="false" Visible="true" />'
            '<StrokeStyle Self="StrokeStyle/$ID/Solid" Name="$ID/Solid" />'
            '</idPkg:Graphic>')


def fonts_xml():
    fams = []
    for fam, estilos in FAMILIAS.items():
        fid = ids()
        fs = "".join(f'<Font Self="{fid}Fontn{a(fam)} {a(e)}" FontFamily="{a(fam)}" Name="{a(fam)} {a(e)}" '
                     f'PostScriptName="{ps}" Status="Installed" FontStyleName="{a(e)}" FontType="OpenTypeCFF" '
                     f'WritingScript="0" FullName="{a(fam)} {a(e)}" />' for e, ps in estilos)
        fams.append(f'<FontFamily Self="{fid}" Name="{a(fam)}">{fs}</FontFamily>')
    return CAB + f'<idPkg:Fonts {NS}>' + "".join(fams) + '</idPkg:Fonts>'


def preferences_xml():
    m = (f'Top="{num(SUP)}" Bottom="{num(INF)}" Left="{num(IZQ)}" Right="{num(DER)}" '
         f'ColumnCount="{COLS}" ColumnGutter="{num(MED)}" ColumnDirection="Horizontal"')
    return (CAB + f'<idPkg:Preferences {NS}>'
            f'<DocumentPreference PageHeight="{num(H)}" PageWidth="{num(W)}" PagesPerDocument="1" '
            f'FacingPages="false" DocumentBleedTopOffset="{num(SANGRADO)}" DocumentBleedBottomOffset="{num(SANGRADO)}" '
            f'DocumentBleedInsideOrLeftOffset="{num(SANGRADO)}" DocumentBleedOutsideOrRightOffset="{num(SANGRADO)}" '
            'DocumentBleedUniformSize="true" PageBinding="LeftToRight" Intent="PrintIntent" '
            'CreatePrimaryTextFrame="false" ColumnGuideLocked="true" />'
            f'<MarginPreference {m} />'
            f'<GridPreference DocumentGridShown="false" DocumentGridSnapto="false" BaselineGridShown="true" '
            f'BaselineStart="{num(SUP)}" BaselineDivision="{num(BL)}" BaselineViewThreshold="50" '
            'BaselineGridRelativeOption="TopOfPageOfBaselineGridRelativeOption" GridsInBack="true" '
            'HorizontalGridlineDivision="72" VerticalGridlineDivision="72" HorizontalGridSubdivision="8" '
            'VerticalGridSubdivision="8" />'
            '<ViewPreference HorizontalMeasurementUnits="Millimeters" VerticalMeasurementUnits="Millimeters" '
            'TypographicMeasurementUnits="Points" TextSizeMeasurementUnits="Points" LineMeasurementUnits="Points" '
            'StrokeMeasurementUnits="Points" ShowRulers="true" ShowFrameEdges="true" RulerOrigin="PageOrigin" '
            'PointsPerInch="72" />'
            '<TextPreference TypographersQuotes="true" UseParagraphLeading="false" SmallCap="70" '
            'SuperscriptSize="58.3" SuperscriptPosition="33.3" SubscriptSize="58.3" SubscriptPosition="33.3" />'
            '</idPkg:Preferences>')


# ---------------------------------------------------------------- IDML: página y marcos
def caja(x, y, w, h):
    """Puntos del trazado en coordenadas del pliego (la página está centrada en el origen)."""
    x0, y0, x1, y1 = x - W / 2, y - H / 2, x + w - W / 2, y + h - H / 2
    pts = [(x0, y0), (x0, y1), (x1, y1), (x1, y0)]
    return ("<Properties><PathGeometry><GeometryPathType PathOpen=\"false\"><PathPointArray>" +
            "".join(f'<PathPointType Anchor="{num(px)} {num(py)}" LeftDirection="{num(px)} {num(py)}" '
                    f'RightDirection="{num(px)} {num(py)}" />' for px, py in pts) +
            "</PathPointArray></GeometryPathType></PathGeometry></Properties>")


def marco_texto(capa, historia, x, y, w, h, prev="n", nxt="n", self_id=None):
    fid = self_id or ids()
    return fid, (f'<TextFrame Self="{fid}" ParentStory="{historia}" PreviousTextFrame="{prev}" '
                 f'NextTextFrame="{nxt}" ContentType="TextType" ItemLayer="{capa}" '
                 'AppliedObjectStyle="ObjectStyle/$ID/[Normal Text Frame]" FillColor="Swatch/None" '
                 'StrokeColor="Swatch/None" StrokeWeight="0" ItemTransform="1 0 0 1 0 0">'
                 f'{caja(x, y, w, h)}'
                 '<TextFramePreference TextColumnCount="1" TextColumnGutter="15" '
                 'FirstBaselineOffset="LeadingOffset" VerticalJustification="TopAlign" '
                 'InsetSpacing="0 0 0 0" /></TextFrame>')


def rectangulo(capa, x, y, w, h, color):
    return (f'<Rectangle Self="{ids()}" ContentType="Unassigned" ItemLayer="{capa}" '
            f'FillColor="{cref(color)}" StrokeColor="Swatch/None" StrokeWeight="0" '
            'AppliedObjectStyle="ObjectStyle/$ID/[Normal Graphics Frame]" ItemTransform="1 0 0 1 0 0">'
            f'{caja(x, y, w, h)}</Rectangle>')


def pagina(pid, nombre, maestra):
    m = (f'Top="{num(SUP)}" Bottom="{num(INF)}" Left="{num(IZQ)}" Right="{num(DER)}" '
         f'ColumnCount="{COLS}" ColumnGutter="{num(MED)}" ColumnDirection="Horizontal"')
    return (f'<Page Self="{pid}" Name="{a(nombre)}" AppliedMaster="{maestra}" '
            f'GeometricBounds="0 0 {num(H)} {num(W)}" ItemTransform="1 0 0 1 {num(-W / 2)} {num(-H / 2)}" '
            'MasterPageTransform="1 0 0 1 0 0" OverrideList="" TabOrder="" UseMasterGrid="true">'
            f'<MarginPreference {m} /></Page>')


# ---------------------------------------------------------------- IDML: historias
def contenido(texto):
    return f"<Content>{escape(texto)}</Content>"


def tramos_xml(tramos):
    out = []
    for estilo, texto in tramos:
        ref = f"CharacterStyle/{estilo}" if estilo else "CharacterStyle/$ID/[No character style]"
        out.append(f'<CharacterStyleRange AppliedCharacterStyle="{a(ref)}">{contenido(texto)}</CharacterStyleRange>')
    return "".join(out)


def tabla_xml(filas, med, anchura):
    datos, w = anchos_columnas(filas, med, anchura)
    sep = next((f for f in filas if re.fullmatch(r"\|[\s:\-|]+\|", f.strip())), None)
    alineacion = []
    if sep:
        for c in celdas(sep):
            alineacion.append("RightAlign" if c.endswith(":") and not c.startswith(":") else "LeftAlign")
    tid = ids()
    ncol, nfil = len(datos[0]), len(datos)
    xml = [f'<Table Self="{tid}" HeaderRowCount="1" FooterRowCount="0" BodyRowCount="{nfil - 1}" '
           f'ColumnCount="{ncol}" AppliedTableStyle="TableStyle/Tabla Relevo" TableDirection="LeftToRightDirection">']
    for r in range(nfil):
        xml.append(f'<Row Self="{tid}Row{r}" Name="{r}" SingleRowHeight="18" MinimumHeight="18" AutoGrow="true" />')
    for c in range(ncol):
        xml.append(f'<Column Self="{tid}Column{c}" Name="{c}" SingleColumnWidth="{num(w[c])}" />')
    for r, fila in enumerate(datos):
        for c in range(ncol):
            texto = fila[c] if c < len(fila) else ""
            enc = r == 0
            pst = "Tabla encabezado" if enc else "Tabla texto"
            just = alineacion[c] if c < len(alineacion) else "LeftAlign"
            arriba = 0.75 if r == 0 else (0.5 if r == 1 else 0)
            abajo = 0.5 if r == 0 else (0.75 if r == nfil - 1 else 0)
            xml.append(f'<Cell Self="{tid}Cell{c}_{r}" Name="{c}:{r}" RowSpan="1" ColumnSpan="1" '
                       f'AppliedCellStyle="CellStyle/{"Celda encabezado" if enc else "Celda cuerpo"}" '
                       'TextTopInset="3" TextBottomInset="3" TextLeftInset="4" TextRightInset="4" '
                       f'TopEdgeStrokeWeight="{arriba}" BottomEdgeStrokeWeight="{abajo}" '
                       'LeftEdgeStrokeWeight="0" RightEdgeStrokeWeight="0" '
                       'TopEdgeStrokeColor="Color/Tinta" BottomEdgeStrokeColor="Color/Tinta">'
                       f'<ParagraphStyleRange AppliedParagraphStyle="ParagraphStyle/{pst}" Justification="{just}">'
                       f'{tramos_xml(runs(texto))}</ParagraphStyleRange></Cell>')
    xml.append("</Table>")
    return "".join(xml)


def tabla_como_texto(filas):
    datos, _ = anchos_columnas(filas, Medidor(), ANCHO_4)
    out = []
    for r, fila in enumerate(datos):
        out.append(Parrafo("Tabla encabezado" if r == 0 else "Tabla texto",
                           [(None, "\t".join(plano(c) for c in fila))]))
    return out


def historia_xml(sid, parrafos, med, anchura, tablas_texto=False):
    if tablas_texto:
        expandidos = []
        for p in parrafos:
            expandidos.extend(tabla_como_texto(p.tabla) if p.tabla else [p])
        parrafos = expandidos
    cuerpo = []
    for i, p in enumerate(parrafos):
        fin = "" if i == len(parrafos) - 1 else "<Br />"
        ref = f"ParagraphStyle/{p.estilo}"
        if p.tabla:
            dentro = (f'<CharacterStyleRange AppliedCharacterStyle="CharacterStyle/$ID/[No character style]">'
                      f'{tabla_xml(p.tabla, med, anchura)}{fin}</CharacterStyleRange>')
        else:
            dentro = tramos_xml(p.tramos)
            if fin:
                dentro += ('<CharacterStyleRange AppliedCharacterStyle="CharacterStyle/$ID/[No character style]">'
                           f'{fin}</CharacterStyleRange>')
        cuerpo.append(f'<ParagraphStyleRange AppliedParagraphStyle="{a(ref)}">{dentro}</ParagraphStyleRange>')
    return (CAB + f'<idPkg:Story {NS}><Story Self="{sid}" AppliedTOCStyle="n" TrackChanges="false" '
            'StoryTitle="$ID/" AppliedNamedGrid="n"><StoryPreference OpticalMarginAlignment="false" '
            'FrameType="TextFrameType" StoryOrientation="Horizontal" StoryDirection="LeftToRightDirection" />'
            + "".join(cuerpo) + "</Story></idPkg:Story>")


def historia_folio(sid, alineacion="Folio"):
    return (CAB + f'<idPkg:Story {NS}><Story Self="{sid}" AppliedTOCStyle="n" StoryTitle="$ID/">'
            f'<ParagraphStyleRange AppliedParagraphStyle="ParagraphStyle/{alineacion}">'
            '<CharacterStyleRange AppliedCharacterStyle="CharacterStyle/$ID/[No character style]">'
            '<Content><?ACE 18?></Content></CharacterStyleRange></ParagraphStyleRange></Story></idPkg:Story>')


# ---------------------------------------------------------------- armado
def construir(con_texto=True, tablas_texto=False):
    med = Medidor()
    capa = "u_capa"
    historias = {}      # id -> xml
    pliegos = []        # xml de cada pliego
    resumen = []        # páginas por sección, para el README

    # --- maestras
    maestras = {}
    def maestra(prefijo, base, elementos):
        mid = ids()
        pid = ids()
        m = (f'Top="{num(SUP)}" Bottom="{num(INF)}" Left="{num(IZQ)}" Right="{num(DER)}" '
             f'ColumnCount="{COLS}" ColumnGutter="{num(MED)}" ColumnDirection="Horizontal"')
        xml = (CAB + f'<idPkg:MasterSpread {NS}><MasterSpread Self="{mid}" Name="{prefijo}-{a(base)}" '
               f'NamePrefix="{prefijo}" BaseName="{a(base)}" ShowMasterItems="true" PageCount="1" '
               'ItemTransform="1 0 0 1 0 0">'
               f'<Page Self="{pid}" Name="{prefijo}" AppliedMaster="n" GeometricBounds="0 0 {num(H)} {num(W)}" '
               f'ItemTransform="1 0 0 1 {num(-W / 2)} {num(-H / 2)}" MasterPageTransform="1 0 0 1 0 0">'
               f'<MarginPreference {m} /></Page>' + "".join(elementos) + '</MasterSpread></idPkg:MasterSpread>')
        maestras[prefijo] = (mid, xml)
        return mid

    def cornisa_y_folio(con_cornisa=True):
        els = []
        if con_cornisa:
            sid = ids()
            historias[sid] = historia_xml(sid, [Parrafo("Cornisa", [(None, "Relevo — Memoria de Proyecto de Título")])], med, ancho(6))
            els.append(marco_texto(capa, sid, col_x(0), SUP - 30, ancho(6), 15)[1])
            sid2 = ids()
            historias[sid2] = historia_xml(sid2, [Parrafo("Folio", [(None, "Escuela de Diseño UDP · 2026")])], med, ancho(4))
            els.append(marco_texto(capa, sid2, col_x(8), SUP - 30, ancho(4), 15)[1])
        sid3 = ids()
        historias[sid3] = historia_folio(sid3)
        els.append(marco_texto(capa, sid3, col_x(10), SUP + CAJA_H + 15, ancho(2), 15)[1])
        return els

    M_A = maestra("A", "Lectura", cornisa_y_folio(True))
    M_B = maestra("B", "Apertura", cornisa_y_folio(False))
    M_C = maestra("C", "Tres columnas", cornisa_y_folio(True))
    M_D = maestra("D", "Portada", [])

    paginas = []  # (maestra, [elementos])

    def nueva_pagina(maestra_id, elementos):
        paginas.append((maestra_id, elementos))
        return len(paginas)

    def hilo(sid, parrafos, marcos_por_pagina, primera, pag_total, maestra_rest):
        """Crea un hilo de marcos: `primera` son los marcos de la página de apertura."""
        geos = []
        for n in range(pag_total):
            geos.append((M_B if n == 0 else maestra_rest, primera if n == 0 else marcos_por_pagina))
        total = sum(len(g) for _, g in geos)
        fids = [ids() for _ in range(total)]
        k = 0
        for maestra_id, marcos in geos:
            els = []
            for (x, y, w, h) in marcos:
                prev = fids[k - 1] if k else "n"
                nxt = fids[k + 1] if k + 1 < total else "n"
                els.append(marco_texto(capa, sid, x, y, w, h, prev, nxt, self_id=fids[k])[1])
                k += 1
            yield maestra_id, els

    lectura = [(col_x(4), SUP, ANCHO_4, CAJA_H), (col_x(8), SUP, ANCHO_4, CAJA_H)]
    tres = [(col_x(0), SUP, ANCHO_4, CAJA_H)] + lectura
    apertura = [(col_x(4), APERTURA_Y, ANCHO_4, SUP + CAJA_H - APERTURA_Y),
                (col_x(8), APERTURA_Y, ANCHO_4, SUP + CAJA_H - APERTURA_Y)]
    lineas_apertura = 2 * round((SUP + CAJA_H - APERTURA_Y) / BL)

    secciones = leer_memoria() if con_texto else []
    portada = next((s for s in secciones if s["titulo"] == "Relevo"), None)

    # --- 1. portada
    els = [rectangulo(capa, -SANGRADO, -SANGRADO, W + 2 * SANGRADO, H + 2 * SANGRADO, "Azul Relevo")]
    sid = ids()
    historias[sid] = historia_xml(sid, [Parrafo("Portada título", [(None, "relevo")])], med, ancho(12))
    els.append(marco_texto(capa, sid, col_x(0), SUP, ancho(12), 230)[1])
    sid = ids()
    subtitulo = "Sistema phygital para recuperar intenciones personales durante el ocio digital"
    if portada:
        sub = next((l for l in portada["lineas"] if l.startswith("*") and l.endswith("*")), None)
        subtitulo = sub.strip("*") if sub else subtitulo
    historias[sid] = historia_xml(sid, [Parrafo("Portada subtítulo", [(None, subtitulo)])], med, ancho(6))
    els.append(marco_texto(capa, sid, col_x(0), SUP + 4 * (FILA + BL), ancho(6), 2 * FILA)[1])
    sid = ids()
    datos = [
        Parrafo("Portada etiqueta", [(None, "Memoria de Proyecto de Título")]),
        Parrafo("Portada datos", [("Negrita", "Estudiante: "), (None, "[completar]")]),
        Parrafo("Portada datos", [("Negrita", "Profesores guía: "), (None, "[completar]")]),
        Parrafo("Portada datos", [(None, "Memoria para optar al título profesional de la carrera de Diseño [confirmar denominación y mención]")]),
        Parrafo("Portada datos", [(None, "Facultad de Arquitectura, Arte y Diseño, Escuela de Diseño, Universidad Diego Portales")]),
        Parrafo("Portada datos", [(None, "Santiago, Chile, 2026")]),
    ]
    historias[sid] = historia_xml(sid, datos, med, ANCHO_4)
    els.append(marco_texto(capa, sid, col_x(8), SUP + 4 * (FILA + BL), ANCHO_4, 2 * FILA + BL)[1])
    nueva_pagina(M_D, els)
    resumen.append(("Portada", 1, 1))

    # --- 2. resumen y abstract
    def pre(titulo):
        s = next((x for x in secciones if x["titulo"] == "Relevo"), None)
        if not s:
            return []
        lineas, dentro = [], False
        for l in s["lineas"]:
            if l.startswith("## "):
                dentro = l[3:].strip() == titulo
                continue
            if dentro:
                lineas.append(l)
        return lineas

    els = []
    for i, titulo in enumerate(("Resumen", "Abstract")):
        sid = ids()
        pars = [Parrafo("Título preliminar", [(None, titulo)])]
        cuerpo = parrafos_de(bloques(pre(titulo))) if con_texto else [
            Parrafo("Nota de maqueta", [(None, f"Pega aquí el {titulo.lower()}.")])]
        pars += cuerpo
        historias[sid] = historia_xml(sid, pars, med, ANCHO_4)
        els.append(marco_texto(capa, sid, col_x(4 + 4 * i), SUP, ANCHO_4, CAJA_H)[1])
        usadas = sum(lineas_parrafo(p, med, ANCHO_4) for p in pars)
        if usadas > LINEAS:
            print(f"aviso: {titulo} podría desbordar ({usadas} de {LINEAS} líneas)")
    nueva_pagina(M_A, els)
    resumen.append(("Resumen y abstract", 2, 2))

    # --- 3. índice (se completa con las páginas al final)
    indice_sid = ids()
    nueva_pagina(M_A, [marco_texto(capa, indice_sid, col_x(4), SUP, ANCHO_4, CAJA_H)[1]])
    resumen.append(("Índice", 3, 3))

    # --- 4. capítulos
    capitulos = [s for s in secciones if re.match(r"^\d+\. ", s["titulo"]) or s["titulo"] == "Glosario"]
    if not con_texto:
        capitulos = [{"titulo": "1. Título del capítulo", "lineas": ["Texto del capítulo."]}]
    entradas_indice = []
    for cap in capitulos:
        m = re.match(r"^(\d+)\. (.+)$", cap["titulo"])
        numero, titulo = (m.group(1), m.group(2)) if m else ("", cap["titulo"])
        contexto = "referencias" if titulo == "Referencias" else ("glosario" if titulo == "Glosario" else "capitulo")
        pars = parrafos_de(bloques(cap["lineas"]), contexto)
        if pars and pars[0].estilo == "Cuerpo":
            pars[0].estilo = "Cuerpo sin sangría"
        lineas = sum(lineas_parrafo(p, med, ANCHO_4) for p in pars)
        necesarias = lineas * 1.06 + 4
        resto = tres if contexto != "capitulo" else lectura
        por_pagina = len(resto) * LINEAS
        n_pag = 1 + max(0, math.ceil((necesarias - lineas_apertura) / por_pagina))
        inicio = len(paginas) + 1
        # número y título de la apertura
        sid_num, sid_tit = ids(), ids()
        historias[sid_num] = historia_xml(sid_num, [Parrafo("Capítulo número", [(None, numero.zfill(2) if numero else "")])], med, ANCHO_4)
        historias[sid_tit] = historia_xml(sid_tit, [Parrafo("Capítulo título", [(None, titulo)])], med, ancho(8))
        extra = [marco_texto(capa, sid_num, col_x(0), SUP, ANCHO_4, 2 * FILA + BL)[1],
                 marco_texto(capa, sid_tit, col_x(4), SUP, ancho(8), 2 * FILA + BL)[1]]
        sid = ids()
        historias[sid] = historia_xml(sid, pars, med, ANCHO_4, tablas_texto)
        for n, (maestra_id, marcos) in enumerate(hilo(sid, pars, resto, apertura, n_pag, M_C if contexto != "capitulo" else M_A)):
            nueva_pagina(maestra_id, (extra if n == 0 else []) + marcos)
        entradas_indice.append((numero, titulo, inicio))
        resumen.append((cap["titulo"], inicio, len(paginas)))

    # --- índice con páginas
    pars = [Parrafo("Título preliminar", [(None, "Índice")])]
    for numero, titulo, pag in entradas_indice:
        etiqueta = f"{numero}. {titulo}" if numero else titulo
        pars.append(Parrafo("Índice 1", [(None, f"{etiqueta}\t{pag}")]))
    pars.append(Parrafo("Nota de maqueta", [(None,
        "Nota de maqueta (borrar antes de exportar): los números de página corresponden a la apertura de cada "
        "capítulo en esta plantilla. Si cambias la paginación, reemplaza este índice con la tabla de contenidos "
        "de Affinity usando los estilos «Capítulo título» y «Tabla título». El índice de tablas y figuras "
        "se genera igual con «Tabla título» y «Figura título».")]))
    historias[indice_sid] = historia_xml(indice_sid, pars, med, ANCHO_4)

    # --- pliegos
    archivos_pliegos = []
    for i, (maestra_id, els) in enumerate(paginas, start=1):
        sid_p, pid = ids(), ids()
        xml = (CAB + f'<idPkg:Spread {NS}><Spread Self="{sid_p}" PageCount="1" BindingLocation="0" '
               'ShowMasterItems="true" AllowPageShuffle="true" ItemTransform="1 0 0 1 0 0">'
               + pagina(pid, str(i), maestra_id) + "".join(els) + "</Spread></idPkg:Spread>")
        archivos_pliegos.append((f"Spreads/Spread_{sid_p}.xml", xml, pid))
    return maestras, archivos_pliegos, historias, resumen


def designmap(maestras, pliegos, historias):
    primera_pag = pliegos[0][2]
    return (CAB + '<?aid style="50" type="document" readerVersion="6.0" featureSet="257" product="16.0" ?>\n'
            f'<Document {NS} Self="d" StoryList="{" ".join(historias)}" Name="memoria-relevo" ZeroPoint="0 0" '
            'ActiveLayer="u_capa" CMYKProfile="Coated FOGRA39 (ISO 12647-2:2004)" RGBProfile="sRGB IEC61966-2.1">'
            f'<Language Self="Language/{IDIOMA}" Name="{IDIOMA}" SingleQuotes="‘’" DoubleQuotes="«»" '
            'PrimaryLanguageName="$ID/Spanish" SublanguageName="$ID/" Id="1027" '
            'HyphenationVendor="Hunspell" SpellingVendor="Hunspell" />'
            '<idPkg:Graphic src="Resources/Graphic.xml" />'
            '<idPkg:Fonts src="Resources/Fonts.xml" />'
            '<idPkg:Styles src="Resources/Styles.xml" />'
            '<NumberingList Self="NumberingList/$ID/[Default]" Name="$ID/[Default]" '
            'ContinueNumbersAcrossStories="false" ContinueNumbersAcrossDocuments="false" />'
            '<idPkg:Preferences src="Resources/Preferences.xml" />'
            '<idPkg:Tags src="XML/Tags.xml" />'
            '<Layer Self="u_capa" Name="Maqueta" Visible="true" Locked="false" IgnoreWrap="false" '
            'ShowGuides="true" LockGuides="false" UI="true" Expendable="true" Printable="true" />'
            + "".join(f'<idPkg:MasterSpread src="MasterSpreads/MasterSpread_{mid}.xml" />'
                      for mid, _ in maestras.values())
            + "".join(f'<idPkg:Spread src="{ruta}" />' for ruta, _, _ in pliegos)
            + f'<Section Self="u_seccion" Length="{len(pliegos)}" Name="" ContinueNumbering="false" '
            f'IncludeSectionPrefix="false" PageNumberStart="1" Marker="" PageStart="{primera_pag}" SectionPrefix="">'
            '<Properties><PageNumberStyle type="enumeration">Arabic</PageNumberStyle></Properties></Section>'
            '<idPkg:BackingStory src="XML/BackingStory.xml" />'
            + "".join(f'<idPkg:Story src="Stories/Story_{sid}.xml" />' for sid in historias)
            + '<ColorGroup Self="ColorGroup/[Root Color Group]" Name="[Root Color Group]" IsRootColorGroup="true">'
            + "".join(f'<ColorGroupSwatch Self="u_cg{i}" SwatchItemRef="{a(cref(n))}" />'
                      for i, (n, _, _) in enumerate(COLORES))
            + '</ColorGroup></Document>')


def escribir(destino, con_texto=True, tablas_texto=False):
    global ids
    ids = Ids()
    maestras, pliegos, historias, resumen = construir(con_texto, tablas_texto)
    with zipfile.ZipFile(destino, "w") as z:
        z.writestr(zipfile.ZipInfo("mimetype"), "application/vnd.adobe.indesign-idml-package",
                   compress_type=zipfile.ZIP_STORED)
        z.writestr("META-INF/container.xml", CAB +
                   '<container version="1.0" xmlns="urn:oasis:names:tc:opendocument:xmlns:container">'
                   '<rootfiles><rootfile full-path="designmap.xml" media-type="text/xml" /></rootfiles></container>',
                   compress_type=zipfile.ZIP_DEFLATED)
        archivos = {
            "designmap.xml": designmap(maestras, pliegos, historias),
            "Resources/Graphic.xml": graphic_xml(),
            "Resources/Fonts.xml": fonts_xml(),
            "Resources/Styles.xml": styles_xml(),
            "Resources/Preferences.xml": preferences_xml(),
            "XML/Tags.xml": CAB + f'<idPkg:Tags {NS}><XMLTag Self="XMLTag/Root" Name="Root" /></idPkg:Tags>',
            "XML/BackingStory.xml": CAB + f'<idPkg:BackingStory {NS}><XmlStory Self="u_backing" '
                                          'AppliedTOCStyle="n"><ParagraphStyleRange AppliedParagraphStyle='
                                          '"ParagraphStyle/$ID/NormalParagraphStyle"><CharacterStyleRange '
                                          'AppliedCharacterStyle="CharacterStyle/$ID/[No character style]">'
                                          '<XMLElement Self="di2" MarkupTag="XMLTag/Root" /></CharacterStyleRange>'
                                          '</ParagraphStyleRange></XmlStory></idPkg:BackingStory>',
        }
        for mid, xml in maestras.values():
            archivos[f"MasterSpreads/MasterSpread_{mid}.xml"] = xml
        for ruta, xml, _ in pliegos:
            archivos[ruta] = xml
        for sid, xml in historias.items():
            archivos[f"Stories/Story_{sid}.xml"] = xml
        for nombre, xml in archivos.items():
            z.writestr(nombre, xml.encode("utf-8"), compress_type=zipfile.ZIP_DEFLATED)
    return resumen, len(pliegos)


def main():
    ap = argparse.ArgumentParser(description=__doc__.split("\n")[0])
    ap.add_argument("--sin-texto", action="store_true", help="maqueta vacía, sin el texto de la memoria")
    ap.add_argument("--tablas-como-texto", action="store_true",
                    help="tablas como párrafos con tabulaciones (por si Affinity no importa las tablas)")
    ap.add_argument("--salida", default=None)
    args = ap.parse_args()
    nombre = "plantilla-memoria-relevo-a3"
    if args.sin_texto:
        nombre += "-vacia"
    if args.tablas_como_texto:
        nombre += "-tablas-como-texto"
    destino = Path(args.salida) if args.salida else AQUI / f"{nombre}.idml"
    resumen, n = escribir(destino, not args.sin_texto, args.tablas_como_texto)
    print(f"{destino.name}: {n} páginas")
    print(json.dumps(resumen, ensure_ascii=False))


if __name__ == "__main__":
    main()
